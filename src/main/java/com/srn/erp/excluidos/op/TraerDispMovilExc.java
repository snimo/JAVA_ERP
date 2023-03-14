package com.srn.erp.excluidos.op;

import java.util.Iterator;

import com.srn.erp.excluidos.bm.DispMovilExc;
import com.srn.erp.excluidos.bm.LogSincroExcluido;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerDispMovilExc extends Operation { 

  public TraerDispMovilExc() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    DispMovilExc dispmovilexc = null;
    if (mapaDatos.containsKey("oid")) { 
       Integer oid = mapaDatos.getInteger("oid"); 
       dispmovilexc = DispMovilExc.findByOid(oid, getSesion()); 
    } 
    else { 
       String codigo = mapaDatos.getString("codigo"); 
       dispmovilexc = DispMovilExc.findByCodigo(codigo, getSesion()); 
    } 

    IDataSet datasetDispMovilExc = getDataSetDispMovilExc();
    IDataSet datasetLogfs = this.getDataSetLogsSincro();
    
    if (dispmovilexc != null) {
    	
        cargarRegistroDispMovilExc(datasetDispMovilExc, dispmovilexc);
        
        Iterator iterSincroExcluido = 
        	LogSincroExcluido.getLogsSincUlt30Dias(dispmovilexc, this.getSesion()).iterator();
        while (iterSincroExcluido.hasNext()) {
        	LogSincroExcluido logSincroExcluido = (LogSincroExcluido) iterSincroExcluido.next();
        	cargarRegistroLogsSincro(datasetLogfs, logSincroExcluido);
        }
        
    }
    
    writeCliente(datasetDispMovilExc);
    writeCliente(datasetLogfs);
    
  }

  private IDataSet getDataSetDispMovilExc() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TDispMovilExc");
    dataset.fieldDef(new Field("oid_disp_movil", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("codigo", Field.STRING, 50)); 
    dataset.fieldDef(new Field("descripcion", Field.STRING, 100)); 
    dataset.fieldDef(new Field("oid_grupo_imp_exc", Field.STRING, 0)); 
    dataset.fieldDef(new Field("fec_hor_ult_sinc_ol", Field.STRING, 50)); 
    dataset.fieldDef(new Field("forzar_sinc_all", Field.BOOLEAN, 0)); 
    dataset.fieldDef(new Field("ult_nro_lote_inf", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0)); 
    dataset.fieldDef(new Field("forzar_siempre_sinc", Field.BOOLEAN, 0));
    
    return dataset;
  }
  
  private IDataSet getDataSetLogsSincro() { 
	    IDataSet dataset = new TDataSet(); 
	    dataset.create("TLogSincro");
	    dataset.fieldDef(new Field("oid_log_sincro", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("oid_disp_movil", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("fecha", Field.DATE, 0));
	    dataset.fieldDef(new Field("hora", Field.STRING, 5));
	    dataset.fieldDef(new Field("grupo_importacion", Field.STRING, 50));
	    dataset.fieldDef(new Field("nro_lote", Field.INTEGER, 0));
	    return dataset;
  }
  
  private void cargarRegistroLogsSincro(
		  		IDataSet ds,
		  		LogSincroExcluido logSincroExcluido) throws BaseException {
	  ds.append();
	  ds.fieldValue("oid_log_sincro", logSincroExcluido.getOIDInteger());
	  ds.fieldValue("oid_disp_movil", logSincroExcluido.getDisp_movil().getOIDInteger());
	  ds.fieldValue("fecha", logSincroExcluido.getFecha());
	  ds.fieldValue("hora", logSincroExcluido.getHora());
	  if (logSincroExcluido.getGrupo_imp_exc()!=null)
		  ds.fieldValue("grupo_importacion", logSincroExcluido.getGrupo_imp_exc().getDescripcion());
	  else
		  ds.fieldValue("grupo_importacion", "");
	  ds.fieldValue("nro_lote", logSincroExcluido.getNro_lote());
  }
  

  private void cargarRegistroDispMovilExc(IDataSet dataset, DispMovilExc dispMov) throws BaseException {
    dataset.append(); 
    dataset.fieldValue("oid_disp_movil", dispMov.getOIDInteger());
    dataset.fieldValue("codigo", dispMov.getCodigo());
    dataset.fieldValue("descripcion", dispMov.getDescripcion());
    if (dispMov.getGrupo_importacion()!=null)
    	dataset.fieldValue("oid_grupo_imp_exc", dispMov.getGrupo_importacion().getOIDInteger());
    else
    	dataset.fieldValue("oid_grupo_imp_exc", "");
    dataset.fieldValue("fec_hor_ult_sinc_ol", dispMov.getFec_hor_ult_sinc_ol());
    dataset.fieldValue("forzar_sinc_all", dispMov.isForzar_sinc_all());
    dataset.fieldValue("ult_nro_lote_inf", dispMov.getUlt_nro_lote_inf());
    dataset.fieldValue("activo", dispMov.isActivo());
    dataset.fieldValue("forzar_siempre_sinc", dispMov.isForzarSiempreSinc());
  }
}
