package com.srn.erp.bancos.op;

import java.util.Iterator;

import com.srn.erp.bancos.bm.ConciliacionCab;
import com.srn.erp.bancos.bm.ConciliacionDet;

import framework.applicarionServer.bm.Varios.Money;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerConciliacionBanco extends Operation { 

  public TraerConciliacionBanco() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    ConciliacionCab conciliacioncab = null;
    if (mapaDatos.containsKey("oid")) { 
       Integer oid = mapaDatos.getInteger("oid"); 
       conciliacioncab = ConciliacionCab.findByOid(oid, getSesion()); 
    } 
    else { 
       String codigo = mapaDatos.getString("codigo"); 
       conciliacioncab = ConciliacionCab.findByCodigo(codigo, getSesion()); 
    } 

    IDataSet datasetConciliacionCab = getDataSetConciliacionCab();
    IDataSet datasetConciliacionDet = getDataSetConciliacionDet();
    
    if (conciliacioncab != null)  {
        cargarRegistroConciliacionCab(datasetConciliacionCab,conciliacioncab);
        
        Iterator iterConciliacionesDet = 
        	conciliacioncab.getConciliacionesDet().iterator();
        while (iterConciliacionesDet.hasNext()) {
        	ConciliacionDet concDet = (ConciliacionDet) iterConciliacionesDet.next();
        	cargarRegistroConciliacionDet(datasetConciliacionDet, concDet);
        }
        
    }
    
    writeCliente(datasetConciliacionCab);
    writeCliente(datasetConciliacionDet);
    
  }

  private IDataSet getDataSetConciliacionCab() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TConciliacionCab");
    dataset.fieldDef(new Field("oid_conciliacion", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("codigo", Field.STRING, 100));
    dataset.fieldDef(new Field("fecha", Field.DATE, 0));
    dataset.fieldDef(new Field("conciliado_al", Field.DATE, 0)); 
    dataset.fieldDef(new Field("fecha_desde", Field.DATE, 0)); 
    dataset.fieldDef(new Field("descripcion", Field.STRING, 255)); 
    dataset.fieldDef(new Field("oid_cta_bancaria", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_cta_bancaria", Field.STRING, 50));
    dataset.fieldDef(new Field("desc_cta_bancaria", Field.STRING, 100));
    dataset.fieldDef(new Field("obs_generales", Field.STRING, 1000)); 
    dataset.fieldDef(new Field("saldo_ini_extrac", Field.CURRENCY, 0)); 
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("nro_conciliacion", Field.BOOLEAN, 0));
    return dataset;
  }
  
  private IDataSet getDataSetConciliacionDet() { 
	    IDataSet dataset = new TDataSet(); 
	    dataset.create("TConciliacionDet");
	    dataset.fieldDef(new Field("oid_conciliacion_det", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("oid_conciliacion", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("conciliado", Field.BOOLEAN, 0));
	    dataset.fieldDef(new Field("oid_mov_cta_bco", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("fecha", Field.DATE, 0));
	    dataset.fieldDef(new Field("tipo_mov", Field.STRING, 50));
	    dataset.fieldDef(new Field("oid_ana_imp",Field.INTEGER, 0));
	    dataset.fieldDef(new Field("cod_concepto", Field.STRING, 100));
	    dataset.fieldDef(new Field("desc_concepto", Field.STRING, 255));
	    dataset.fieldDef(new Field("nro", Field.STRING, 100));
	    dataset.fieldDef(new Field("impo_contable", Field.CURRENCY, 0));
	    dataset.fieldDef(new Field("impo_extracto", Field.CURRENCY, 0));
	    dataset.fieldDef(new Field("es_saldo_inicial", Field.BOOLEAN, 0));
	    dataset.fieldDef(new Field("comentario", Field.MEMO, 0));
	    return dataset;
  }
  

  private void cargarRegistroConciliacionCab(IDataSet dataset, 
                         ConciliacionCab conciliacion) throws BaseException {
    dataset.append(); 
    dataset.fieldValue("oid_conciliacion", conciliacion.getOIDInteger());
    dataset.fieldValue("codigo", conciliacion.getCodigo());
    dataset.fieldValue("fecha", conciliacion.getEmision());
    dataset.fieldValue("conciliado_al", conciliacion.getConciliado_al());
    dataset.fieldValue("fecha_desde", conciliacion.getFec_desde());
    dataset.fieldValue("descripcion", conciliacion.getDescripcion());
    dataset.fieldValue("oid_cta_bancaria", conciliacion.getCuenta_bancaria().getOIDInteger());
    dataset.fieldValue("cod_cta_bancaria", conciliacion.getCuenta_bancaria().getCodigo());
    dataset.fieldValue("desc_cta_bancaria", conciliacion.getCuenta_bancaria().getDescripcion());
    dataset.fieldValue("obs_generales", conciliacion.getObs_generales());
    dataset.fieldValue("saldo_ini_extrac", conciliacion.getSaldo_ini_extrac());
    dataset.fieldValue("activo", conciliacion.isActivo());
    dataset.fieldValue("nro_conciliacion", conciliacion.getNroExt());
  }
  
  private void cargarRegistroConciliacionDet(IDataSet dataset, 
          			ConciliacionDet conciliacionDet) throws BaseException {
	  dataset.append(); 
	  dataset.fieldValue("oid_conciliacion_det", conciliacionDet.getOIDInteger());
	  dataset.fieldValue("oid_conciliacion", conciliacionDet.getConciliacion_cab().getOIDInteger());
	  dataset.fieldValue("conciliado", conciliacionDet.isConciliado());
	  if (conciliacionDet.getMovimiento_cuenta()!=null)
		  dataset.fieldValue("oid_mov_cta_bco", conciliacionDet.getMovimiento_cuenta().getOIDInteger());
	  else
		  dataset.fieldValue("oid_mov_cta_bco", "");
	  dataset.fieldValue("fecha", conciliacionDet.getFecha());
	  dataset.fieldValue("tipo_mov", conciliacionDet.getTipo_mov());
	  
	  if (conciliacionDet.getCuenta_contable()!=null) {
		  dataset.fieldValue("oid_ana_imp", conciliacionDet.getCuenta_contable().getOIDInteger());
		  dataset.fieldValue("cod_concepto", conciliacionDet.getCuenta_contable().getCodigoCuentaMasCodigosValCompo());
		  dataset.fieldValue("desc_concepto", conciliacionDet.getCuenta_contable().getDescCuentaMasDescValCompo());
	  } else{
		  if ((conciliacionDet.getMovimiento_cuenta()!=null) && (conciliacionDet.getMovimiento_cuenta().getTipoValor()!=null)) {
			  dataset.fieldValue("oid_ana_imp", "");
			  dataset.fieldValue("cod_concepto", conciliacionDet.getMovimiento_cuenta().getTipoValor().getCodigo());
			  dataset.fieldValue("desc_concepto", conciliacionDet.getMovimiento_cuenta().getTipoValor().getDescripcion());
		  } else {
			  dataset.fieldValue("oid_ana_imp", "");
			  dataset.fieldValue("cod_concepto", "");
			  dataset.fieldValue("desc_concepto", "");
		  }
	  }
	  
	  if (conciliacionDet.getNro_valor()==0)
		  dataset.fieldValue("nro", "");
	  else
		  if (conciliacionDet.getNro_valor()!=null)
			  dataset.fieldValue("nro", ""+conciliacionDet.getNro_valor());
		  else
			  dataset.fieldValue("nro", "");
	  dataset.fieldValue("impo_contable", conciliacionDet.getA_conciliar());
	  dataset.fieldValue("impo_extracto", conciliacionDet.getExtracto());
	  dataset.fieldValue("es_saldo_inicial", new Boolean(false));
	  dataset.fieldValue("comentario", conciliacionDet.getObservacion());	  
	  
  }
  
  
}
