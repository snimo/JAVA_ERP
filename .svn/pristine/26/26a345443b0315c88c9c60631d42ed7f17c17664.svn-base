package com.srn.erp.tesoreria.op;

import java.util.Iterator;

import com.srn.erp.tesoreria.bm.GrupoCajas;
import com.srn.erp.tesoreria.bm.GrupoCajasDet;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerGrupoCajas extends Operation { 

  public TraerGrupoCajas() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    GrupoCajas grupocajas = null;
    if (mapaDatos.containsKey("oid")) { 
       Integer oid = mapaDatos.getInteger("oid"); 
       grupocajas = GrupoCajas.findByOid(oid, getSesion()); 
    } 
    else { 
       String codigo = mapaDatos.getString("codigo"); 
       grupocajas = GrupoCajas.findByCodigo(codigo, getSesion()); 
    } 

    IDataSet datasetGrupoCajas = getDataSetGrupoCajas();
    IDataSet datasetGrupoCajasDet = getDataSetGrupoCajasDet(); 
    
    if (grupocajas != null) {  
        cargarRegistroGrupoCajas(datasetGrupoCajas,grupocajas);
        Iterator iterGruposCajasDet = 
        	grupocajas.getGrupoCajasDet().iterator();
        while (iterGruposCajasDet.hasNext()) {
        	GrupoCajasDet grupoCajasDet = (GrupoCajasDet) iterGruposCajasDet.next();
        	cargarRegistroGrupoCajasDet(datasetGrupoCajasDet, grupoCajasDet);
        }
    }
    
    writeCliente(datasetGrupoCajas);
    writeCliente(datasetGrupoCajasDet);
    
  }

  private IDataSet getDataSetGrupoCajas() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TGrupoCajas");
    dataset.fieldDef(new Field("oid_grupo_caja", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("codigo", Field.STRING, 20)); 
    dataset.fieldDef(new Field("descripcion", Field.STRING, 50)); 
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0)); 
    return dataset;
  }

  private void cargarRegistroGrupoCajas(IDataSet dataset, 
                         GrupoCajas grupoCaja) throws BaseException {
    dataset.append(); 
    dataset.fieldValue("oid_grupo_caja", grupoCaja.getOIDInteger());
    dataset.fieldValue("codigo", grupoCaja.getCodigo());
    dataset.fieldValue("descripcion", grupoCaja.getDescripcion());
    dataset.fieldValue("activo", grupoCaja.isActivo());
  }
  
  private IDataSet getDataSetGrupoCajasDet() { 
	    IDataSet dataset = new TDataSet(); 
	    dataset.create("TGrupoCajasDet");
	    dataset.fieldDef(new Field("oid_grupo_caja_det", Field.INTEGER, 0)); 
	    dataset.fieldDef(new Field("oid_grupo_caja", Field.INTEGER, 0)); 
	    dataset.fieldDef(new Field("oid_caja", Field.INTEGER, 0)); 
	    dataset.fieldDef(new Field("cod_caja", Field.STRING, 50));
	    dataset.fieldDef(new Field("desc_caja", Field.STRING, 100));
	    dataset.fieldDef(new Field("orden", Field.INTEGER, 0)); 
	    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0)); 
	    return dataset;
  }

  private void cargarRegistroGrupoCajasDet(IDataSet dataset, 
	                         GrupoCajasDet grupoCajasDet) throws BaseException {
	    dataset.append(); 
	    dataset.fieldValue("oid_grupo_caja_det", grupoCajasDet.getOIDInteger());
	    dataset.fieldValue("oid_grupo_caja", grupoCajasDet.getGrupo_caja().getOIDInteger());
	    dataset.fieldValue("oid_caja", grupoCajasDet.getCaja().getOIDInteger());
	    dataset.fieldValue("cod_caja", grupoCajasDet.getCaja().getCodigo());
	    dataset.fieldValue("desc_caja", grupoCajasDet.getCaja().getDescripcion());
	    dataset.fieldValue("orden", grupoCajasDet.getOrden());
	    dataset.fieldValue("activo", grupoCajasDet.isActivo());
  }
  
  
}
