package com.srn.erp.contabilidad.op;

import java.util.Iterator;

import com.srn.erp.contabilidad.bm.Componente;
import com.srn.erp.contabilidad.bm.Cuenta;
import com.srn.erp.contabilidad.bm.DriverComponente;
import com.srn.erp.contabilidad.bm.DriverSubreparto;
import com.srn.erp.contabilidad.bm.FaseCompoOriginal;
import com.srn.erp.contabilidad.bm.FaseCuentaOrigen;
import com.srn.erp.contabilidad.bm.FaseSubReparto;
import com.srn.erp.contabilidad.bm.FaseValCompoDest;
import com.srn.erp.contabilidad.bm.FaseValorCompoOriginal;

import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerFaseSubReparto extends Operation { 

  int secu = 0;
  
  public TraerFaseSubReparto() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
	  
    FaseSubReparto fasesubreparto = null;
    if (mapaDatos.containsKey("oid")) { 
       Integer oid = mapaDatos.getInteger("oid"); 
       fasesubreparto = FaseSubReparto.findByOid(oid, getSesion()); 
    } 
    else { 
       String codigo = mapaDatos.getString("codigo"); 
       fasesubreparto = FaseSubReparto.findByCodigo(codigo, getSesion()); 
    } 

    IDataSet datasetFaseSubReparto = getDataSetFaseSubReparto();
    IDataSet datasetFaseCompoOri = getDataSetFaseCompoOri();
    IDataSet datasetFaseValorCompoOri = getDataSetFaseValorCompoOri();
    IDataSet datasetFaseCtaOri = getDataSetCuentaOri();
    IDataSet datasetFaseCompoDest = getFaseValorCompoDest();
    
    if (fasesubreparto != null) { 
    	
        cargarRegistroFaseSubReparto(datasetFaseSubReparto, 
                         fasesubreparto.getOIDInteger(),
                         fasesubreparto.getCodigo(),
                         fasesubreparto.getDescripcion(),
                         fasesubreparto.getCompo_destino(),
                         fasesubreparto.isActivo());
        
        
        if (fasesubreparto.getCompo_destino()!=null) {
        	Iterator iterValoresCompo = 
        		fasesubreparto.getCompo_destino().getValoresCompo().iterator();
        	while (iterValoresCompo.hasNext()) {
        		IObjetoLogico valorCompoDest = 
        			(IObjetoLogico) iterValoresCompo.next();
        		boolean compoDestinoActivo = new Boolean(false);
        		FaseValCompoDest faseValCompoDest =
        			FaseValCompoDest.getFaseValCompoDest(fasesubreparto, valorCompoDest, this.getSesion());
        		DriverSubreparto driverSub = null;
        		if (faseValCompoDest!=null) {
        			compoDestinoActivo = true;
        			driverSub = faseValCompoDest.getDriver(); 
        		}
        		cargarRegistroFaseCompoDest(
        				datasetFaseCompoDest, 
        				new Integer(++secu), 
        				fasesubreparto.getOIDInteger(), 
        				valorCompoDest, 
        				driverSub, new Boolean(compoDestinoActivo));
        	}
        }
        
        Iterator iterCuentas =
        	Cuenta.getAllActivos(this.getSesion()).iterator();
        while (iterCuentas.hasNext()) {
        	Cuenta cuenta = (Cuenta) iterCuentas.next();
        	boolean activoCuentaOri = false;
        	FaseCuentaOrigen faseCuentaOrigen =
        		FaseCuentaOrigen.getFaseCuentaOrigen(fasesubreparto, cuenta, this.getSesion());
        	if (faseCuentaOrigen!=null)
        		activoCuentaOri = true;
        	cargarRegistroFaseCuentaOri(datasetFaseCtaOri,
        			new Integer(++secu),
        			fasesubreparto.getOIDInteger(),
        			cuenta,
        			activoCuentaOri);
        }
        
        Iterator iterComponentes = 
        	Componente.getAllComponentes(this.getSesion()).iterator();
        while (iterComponentes.hasNext()) {
        	Componente compo = (Componente) iterComponentes.next();
        	FaseCompoOriginal faseCompoOri =
        		FaseCompoOriginal.getFaseCompoOriginal(fasesubreparto, compo, this.getSesion());
        	boolean compoActivo = false;
        	
        	if (faseCompoOri!=null) compoActivo = true;
        	
        	cargarRegistroFaseCompoOri(datasetFaseCompoOri,
        							   new Integer(++secu),
        							   fasesubreparto.getOIDInteger(),
        							   compo,
        							   new Boolean(compoActivo));
        	
        	// Si el componente esta activo
        	if (compoActivo) {
        		Iterator iterValoresCompo =
        			compo.getValoresCompo().iterator();
        		while (iterValoresCompo.hasNext()) {
        			IObjetoLogico objLog = (IObjetoLogico) iterValoresCompo.next();
        			FaseValorCompoOriginal faseValorCompoOriginal =  
        				FaseValorCompoOriginal.getFaseValorCompoOri(
        					fasesubreparto, 
        					compo, 
        					objLog, this.getSesion());
        			boolean activoValorCompoOri = false;
        			if (faseValorCompoOriginal!=null) activoValorCompoOri = true;
        			cargarRegistroFaseValorCompoOri(datasetFaseValorCompoOri,
        					new Integer(++secu),
        					fasesubreparto.getOIDInteger(),
        					compo,
        					objLog,
        					activoValorCompoOri
        					);
        		}
        		
        	}
        }
        
    }
    
    writeCliente(datasetFaseSubReparto);
    writeCliente(datasetFaseCompoOri);
    writeCliente(datasetFaseValorCompoOri);
    writeCliente(datasetFaseCtaOri);
    writeCliente(datasetFaseCompoDest);
    
  }
  
  private IDataSet getFaseValorCompoDest() { 
	    IDataSet dataset = new TDataSet(); 
	    dataset.create("TFaseValorCompoDest");
	    dataset.fieldDef(new Field("oid_fase_valor_compo",Field.INTEGER, 0));
	    dataset.fieldDef(new Field("oid_fase",Field.INTEGER, 0));
	    dataset.fieldDef(new Field("oid_valor_compo",Field.INTEGER, 0));
	    dataset.fieldDef(new Field("cod_valor_compo",Field.STRING, 50));
	    dataset.fieldDef(new Field("desc_valor_compo",Field.STRING, 100));
	    dataset.fieldDef(new Field("oid_driver",Field.INTEGER, 0));
	    dataset.fieldDef(new Field("activo",Field.BOOLEAN, 0));
	    return dataset;
	  }
  
  private void cargarRegistroFaseCompoDest(IDataSet dataset, 
          Integer oidFaseValorCompo,
          Integer oidFase,
          IObjetoLogico valorCompo,
          DriverSubreparto driver,
          Boolean activo) throws BaseException {
	  dataset.append();
	  dataset.fieldValue("oid_fase_valor_compo",oidFaseValorCompo);
	  dataset.fieldValue("oid_fase",oidFase);
	  if (valorCompo!=null) {
		  dataset.fieldValue("oid_valor_compo",valorCompo.getOIDInteger());
		  dataset.fieldValue("cod_valor_compo",valorCompo.getCodigo());
		  dataset.fieldValue("desc_valor_compo",valorCompo.getDescripcion());
	  } else {
		  dataset.fieldValue("oid_valor_compo","");
		  dataset.fieldValue("cod_valor_compo","");
		  dataset.fieldValue("desc_valor_compo","");
	  }
	  if (driver!=null)
		  dataset.fieldValue("oid_driver",driver.getOIDInteger());
	  else
		  dataset.fieldValue("oid_driver","");
	  dataset.fieldValue("activo",activo);
  }
	  
  
  

  private IDataSet getDataSetFaseSubReparto() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TFaseSubReparto");
    dataset.fieldDef(new Field("oid_fase", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("codigo", Field.STRING, 50)); 
    dataset.fieldDef(new Field("descripcion", Field.STRING, 100)); 
    dataset.fieldDef(new Field("oid_compo_destino", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("cod_compo_destino", Field.STRING, 50));
    dataset.fieldDef(new Field("desc_compo_destino", Field.STRING, 100));
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0)); 
    return dataset;
  }
  
  private IDataSet getDataSetFaseCompoOri() { 
	    IDataSet dataset = new TDataSet(); 
	    dataset.create("TFaseCompoOri");
	    dataset.fieldDef(new Field("oid_fase_compo_ori", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("oid_fase", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("oid_compo", Field.INTEGER, 0)); 
	    dataset.fieldDef(new Field("cod_compo", Field.STRING, 50));
	    dataset.fieldDef(new Field("desc_compo", Field.STRING, 100));
	    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0)); 
	    return dataset;
  }
  
  private IDataSet getDataSetFaseValorCompoOri() { 
	    IDataSet dataset = new TDataSet(); 
	    dataset.create("TFaseValorCompoOri");
	    dataset.fieldDef(new Field("oid_fase_valor_compo", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("oid_fase", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("oid_compo", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("oid_val_compo", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("cod_val_compo", Field.STRING, 100));
	    dataset.fieldDef(new Field("desc_val_compo", Field.STRING, 255));
	    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
	    return dataset;
  }
  
  private IDataSet getDataSetCuentaOri() { 
	    IDataSet dataset = new TDataSet(); 
	    dataset.create("TFaseCtaOri");
	    dataset.fieldDef(new Field("oid_fase_cta_ori", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("oid_fase", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("desc_estruc", Field.STRING, 255));
	    dataset.fieldDef(new Field("oid_ana_con", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("cod_ana_con", Field.STRING, 50));
	    dataset.fieldDef(new Field("desc_ana_con", Field.STRING, 100));
	    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
	    return dataset;
  }
  
  private void cargarRegistroFaseCuentaOri(IDataSet dataset, 
          Integer oidFaseCtaOri,
          Integer oidFase,
          Cuenta cuenta,
          Boolean activo) throws BaseException {
	  dataset.append();
	  dataset.fieldValue("oid_fase_cta_ori", oidFaseCtaOri);
	  dataset.fieldValue("oid_fase", oidFase);
	  if (cuenta.getEstructura()!=null)
		  dataset.fieldValue("desc_estruc", cuenta.getEstructura().getDescripcion());
	  else
		  dataset.fieldValue("desc_estruc", "");
	  dataset.fieldValue("oid_ana_con", cuenta.getOIDInteger());
	  dataset.fieldValue("cod_ana_con", cuenta.getCodigo());
	  dataset.fieldValue("desc_ana_con", cuenta.getDescripcion());
	  dataset.fieldValue("activo", activo);
  }  
  
  
  
  
  private void cargarRegistroFaseValorCompoOri(IDataSet dataset, 
          Integer oidFaseValorCompoOri,
          Integer oidFase,
          Componente compo,
          IObjetoLogico objLog,
          Boolean activo) throws BaseException {
	  dataset.append();
	  dataset.fieldValue("oid_fase_valor_compo", oidFaseValorCompoOri);
	  dataset.fieldValue("oid_fase", oidFase);
	  dataset.fieldValue("oid_compo", compo.getOIDInteger()); 
	  dataset.fieldValue("oid_val_compo", objLog.getOIDInteger());
	  dataset.fieldValue("cod_val_compo", objLog.getCodigo());
	  dataset.fieldValue("desc_val_compo", objLog.getDescripcion());
	  dataset.fieldValue("activo", activo);
  }  
  
  
  
  private void cargarRegistroFaseCompoOri(IDataSet dataset, 
          Integer oidFaseCompoOri,
          Integer oidFase,
          Componente compo,
          Boolean activo) throws BaseException {
	  dataset.append();
	  dataset.fieldValue("oid_fase_compo_ori", oidFaseCompoOri);
	  dataset.fieldValue("oid_fase", oidFase);
	  dataset.fieldValue("oid_compo", compo.getOIDInteger()); 
	  dataset.fieldValue("cod_compo", compo.getCodigo());
	  dataset.fieldValue("desc_compo", compo.getDescripcion());
	  dataset.fieldValue("activo", activo);
  }  

  private void cargarRegistroFaseSubReparto(IDataSet dataset, 
                         Integer oid_fase,
                         String codigo,
                         String descripcion,
                         Componente componente,
                         Boolean activo) throws BaseException {
    dataset.append(); 
    dataset.fieldValue("oid_fase", oid_fase);
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("descripcion", descripcion);
    dataset.fieldValue("oid_compo_destino", componente.getOIDInteger());
    dataset.fieldValue("cod_compo_destino", componente.getCodigo());
    dataset.fieldValue("desc_compo_destino", componente.getDescripcion());
    dataset.fieldValue("activo", activo);
  }
}
