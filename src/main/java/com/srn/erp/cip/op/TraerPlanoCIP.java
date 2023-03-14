package com.srn.erp.cip.op;

import java.util.Iterator;

import com.srn.erp.cip.bm.AgrupadorPlano;
import com.srn.erp.cip.bm.PlanoCIP;
import com.srn.erp.cip.bm.Puerta;
import com.srn.erp.cip.bm.PuertaPlanoCIP;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerPlanoCIP extends Operation { 

  public TraerPlanoCIP() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    PlanoCIP planocip = null;
    if (mapaDatos.containsKey("oid")) { 
       Integer oid = mapaDatos.getInteger("oid"); 
       planocip = PlanoCIP.findByOid(oid, getSesion()); 
    } 
    else { 
       String codigo = mapaDatos.getString("codigo"); 
       planocip = PlanoCIP.findByCodigo(codigo, getSesion()); 
    } 

    IDataSet datasetPlanoCIP    = getDataSetPlanoCIP();
    IDataSet datasetPuertaPlano = getDataSetPuertaPlanoCIP();
    
    if (planocip != null) { 
    	
        cargarRegistroPlanoCIP(datasetPlanoCIP, 
                         planocip.getOIDInteger(),
                         planocip.getCodigo(),
                         planocip.getDescripcion(),
                         planocip.getGrupo_plano(),
                         planocip.getOrden(),
                         planocip.isActivo());
        
        Iterator iterPuertasActivos = 
        	Puerta.getPuertasActivas(this.getSesion()).iterator();
        int secu = 1;
        while (iterPuertasActivos.hasNext()) {
        	Puerta puerta = (Puerta) iterPuertasActivos.next();
        	
        	PuertaPlanoCIP puertaPlano = PuertaPlanoCIP.getPuertaPlanoCIP(puerta, planocip , this.getSesion());
        	
        	if (puertaPlano!=null) 
        		cargarRegistroPuertaPlano(datasetPuertaPlano, secu , puertaPlano.getOrden() , planocip , puerta , puertaPlano.isHab_entrada() , puertaPlano.isHab_salida() , true);
        	else
        		cargarRegistroPuertaPlano(datasetPuertaPlano, secu , 0 , planocip , puerta , false , false, false);
        	  
        	++secu;
        }
        
    }
    
    writeCliente(datasetPlanoCIP);
    writeCliente(datasetPuertaPlano);
    
  }

  private IDataSet getDataSetPlanoCIP() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TPlanoCIP");
    dataset.fieldDef(new Field("oid_plano", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("codigo", Field.STRING, 20)); 
    dataset.fieldDef(new Field("descripcion", Field.STRING, 50)); 
    dataset.fieldDef(new Field("oid_agrup_plano", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_agrup_plano", Field.STRING, 50));
    dataset.fieldDef(new Field("desc_agrup_plano", Field.STRING, 100));
    dataset.fieldDef(new Field("orden", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0)); 
    return dataset;
  }
  
  private IDataSet getDataSetPuertaPlanoCIP() { 
	    IDataSet dataset = new TDataSet(); 
	    dataset.create("TPuertaPlano");
	    dataset.fieldDef(new Field("oid_puerta_plano", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("orden", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("oid_plano", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("oid_puerta", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("cod_puerta", Field.STRING, 50));
	    dataset.fieldDef(new Field("desc_puerta", Field.STRING, 100));
	    dataset.fieldDef(new Field("hab_entrada", Field.BOOLEAN, 0));
	    dataset.fieldDef(new Field("hab_salida", Field.BOOLEAN, 0));
	    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
	    return dataset;
  }
  

  private void cargarRegistroPlanoCIP(IDataSet dataset, 
                         Integer oid_plano,
                         String codigo,
                         String descripcion,
                         AgrupadorPlano agrupador,
                         Integer orden,
                         Boolean activo) throws BaseException {
    dataset.append(); 
    dataset.fieldValue("oid_plano", oid_plano);
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("descripcion", descripcion);
    dataset.fieldValue("oid_agrup_plano", agrupador.getOIDInteger());
    dataset.fieldValue("cod_agrup_plano", agrupador.getCodigo());
    dataset.fieldValue("desc_agrup_plano", agrupador.getDescripcion());
    dataset.fieldValue("orden", orden);
    dataset.fieldValue("activo", activo);
  }
  
  private void cargarRegistroPuertaPlano(IDataSet dataset, 
          Integer oidPuertaPlano,
          Integer orden,
          PlanoCIP plano,
          Puerta puerta,
          boolean habEntrada,
          boolean habSalida,
          boolean activo
          ) throws BaseException {
	  dataset.append();
	  dataset.fieldValue("oid_puerta_plano", oidPuertaPlano);
	  dataset.fieldValue("orden", orden);
	  dataset.fieldValue("oid_plano", plano.getOIDInteger());
	  dataset.fieldValue("oid_puerta", puerta.getOIDInteger());
	  dataset.fieldValue("cod_puerta", puerta.getCodigo());
	  dataset.fieldValue("desc_puerta", puerta.getDescripcion());
	  dataset.fieldValue("hab_entrada", habEntrada);
	  dataset.fieldValue("hab_salida", habSalida);
	  dataset.fieldValue("activo", activo);
  }  
}
