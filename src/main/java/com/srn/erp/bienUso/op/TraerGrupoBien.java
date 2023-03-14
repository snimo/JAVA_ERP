package com.srn.erp.bienUso.op;

import java.util.Iterator;

import com.srn.erp.bienUso.bm.GrupoBien;
import com.srn.erp.bienUso.bm.SistemaValuacion;
import com.srn.erp.bienUso.bm.VidaUtilGrupo;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerGrupoBien extends Operation { 

  public TraerGrupoBien() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    GrupoBien grupobien = null;
    if (mapaDatos.containsKey("oid")) { 
       Integer oid = mapaDatos.getInteger("oid"); 
       grupobien = GrupoBien.findByOid(oid, getSesion()); 
    } 
    else { 
       String codigo = mapaDatos.getString("codigo"); 
       grupobien = GrupoBien.findByCodigo(codigo, getSesion()); 
    } 

    IDataSet datasetGrupoBien = getDataSetGrupoBien();
    IDataSet datasetVidaUtil  = getDataSetVidaUtilGrupo();
    
    if (grupobien != null) { 
        cargarRegistroGrupoBien(datasetGrupoBien, 
                         grupobien);
        Iterator iterSistVal = SistemaValuacion.getSistemasDeValuacion(getSesion()).iterator();
        while (iterSistVal.hasNext()) {
        	SistemaValuacion sistVal = (SistemaValuacion) iterSistVal.next();
        	VidaUtilGrupo vidaUtilGrupo = VidaUtilGrupo.getVidaUtilGrupo(grupobien,sistVal,getSesion());
        	cargarRegistroVidaUtilGrupo(datasetVidaUtil,sistVal,grupobien,vidaUtilGrupo);
        }
        
        
    }
    writeCliente(datasetGrupoBien);
    writeCliente(datasetVidaUtil);
  }

  private IDataSet getDataSetGrupoBien() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TGrupoBien");
    dataset.fieldDef(new Field("oid_grupo_bien_uso", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("codigo", Field.STRING, 20)); 
    dataset.fieldDef(new Field("descripcion", Field.STRING, 50)); 
    dataset.fieldDef(new Field("amortiza", Field.BOOLEAN, 0)); 
    dataset.fieldDef(new Field("oid_ai_vo", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("cod_ai_vo", Field.STRING, 50));
    dataset.fieldDef(new Field("desc_ai_vo", Field.STRING, 100));
    dataset.fieldDef(new Field("oid_ai_aa", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_ai_aa", Field.STRING, 50));
    dataset.fieldDef(new Field("desc_ai_aa", Field.STRING, 100));
    dataset.fieldDef(new Field("oid_ai_rvo", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_ai_rvo", Field.STRING, 50));
    dataset.fieldDef(new Field("desc_ai_rvo", Field.STRING, 100));    
    dataset.fieldDef(new Field("oid_ai_raa", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("cod_ai_raa", Field.STRING, 50));
    dataset.fieldDef(new Field("desc_ai_raa", Field.STRING, 100));    
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0)); 
    return dataset;
  }

  private void cargarRegistroGrupoBien(IDataSet dataset, 
                         GrupoBien grupoBien) throws BaseException {
    dataset.append(); 
    dataset.fieldValue("oid_grupo_bien_uso", grupoBien.getOIDInteger());
    dataset.fieldValue("codigo", grupoBien.getCodigo());
    dataset.fieldValue("descripcion", grupoBien.getDescripcion());
    dataset.fieldValue("amortiza", grupoBien.isAmortiza());
    dataset.fieldValue("oid_ai_vo", grupoBien.getAi_vo().getOIDInteger());
    dataset.fieldValue("cod_ai_vo", grupoBien.getAi_vo().getCodigoCuentaMasCodigosValCompo());
    dataset.fieldValue("desc_ai_vo", grupoBien.getAi_vo().getDescCuentaMasDescValCompo());    
    dataset.fieldValue("oid_ai_aa", grupoBien.getAi_aa().getOIDInteger());
    dataset.fieldValue("cod_ai_aa", grupoBien.getAi_aa().getCodigoCuentaMasCodigosValCompo());
    dataset.fieldValue("desc_ai_aa", grupoBien.getAi_aa().getDescCuentaMasDescValCompo());    
    dataset.fieldValue("oid_ai_rvo", grupoBien.getAi_rvo().getOIDInteger());
    dataset.fieldValue("cod_ai_rvo", grupoBien.getAi_rvo().getCodigoCuentaMasCodigosValCompo());
    dataset.fieldValue("desc_ai_rvo", grupoBien.getAi_rvo().getDescCuentaMasDescValCompo());    
    dataset.fieldValue("oid_ai_raa", grupoBien.getAi_raa().getOIDInteger());
    dataset.fieldValue("cod_ai_raa", grupoBien.getAi_raa().getCodigoCuentaMasCodigosValCompo());
    dataset.fieldValue("desc_ai_raa", grupoBien.getAi_raa().getDescCuentaMasDescValCompo());    
    dataset.fieldValue("activo", grupoBien.isActivo());
  }
  
  private IDataSet getDataSetVidaUtilGrupo() { 
	IDataSet dataset = new TDataSet(); 
	dataset.create("TVidaUtilGrupo");
	dataset.fieldDef(new Field("oid_vida_util_g", Field.INTEGER, 0)); 
	dataset.fieldDef(new Field("oid_grupo_bien_uso", Field.INTEGER, 0)); 
	dataset.fieldDef(new Field("oid_sist_val", Field.INTEGER, 0));
	dataset.fieldDef(new Field("desc_sist_val", Field.STRING, 100));
	dataset.fieldDef(new Field("vida_util", Field.INTEGER, 0)); 
	dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0)); 
	return dataset;
  }

  private void cargarRegistroVidaUtilGrupo(IDataSet dataset,
		  					 SistemaValuacion sistVal, 	
			  				 GrupoBien grupoBien,
	                         VidaUtilGrupo vidaUtilGrupo) throws BaseException {
	dataset.append(); 
	if (vidaUtilGrupo==null)
	  dataset.fieldValue("oid_vida_util_g", new Integer(-1));
	else
	  dataset.fieldValue("oid_vida_util_g", vidaUtilGrupo.getOIDInteger());
	dataset.fieldValue("oid_grupo_bien_uso", grupoBien.getOIDInteger());
	dataset.fieldValue("oid_sist_val", sistVal.getOIDInteger());
	dataset.fieldValue("desc_sist_val",sistVal.getDescripcion());
	
	if (vidaUtilGrupo==null) {
	  dataset.fieldValue("vida_util", new Integer(0));
	  dataset.fieldValue("activo", new Boolean(true));	  
	}
	else {
	  dataset.fieldValue("vida_util", vidaUtilGrupo.getVida_util());		 
	  dataset.fieldValue("activo", vidaUtilGrupo.isActivo());	  
	}  
  }  
}
