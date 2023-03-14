package com.srn.erp.Ausentismo.op;

import java.util.List;

import com.srn.erp.Ausentismo.bm.GrupoRRHH;
import com.srn.erp.Ausentismo.bm.GrupoRRHHDetalle;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveGrupoRRHHDetalleRotas extends Operation { 

  public SaveGrupoRRHHDetalleRotas() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    IDataSet dataset = mapaDatos.getDataSet("TRotas"); 
    procesarRegistros(dataset); 
  } 

  private void procesarRegistros(IDataSet dataset) throws BaseException { 
    dataset.first();
    Boolean primero = true;
    String cod_ext_tramo = null;
    GrupoRRHHDetalle grupodetalle = new GrupoRRHHDetalle();
    List<GrupoRRHHDetalle> grupodetalles = GrupoRRHHDetalle.getSelectByOidGrupo(getSesion(), dataset.getInteger("oid_grupo"));
    if(!grupodetalles.isEmpty()){
    	grupodetalle = grupodetalles.get(0);
    	grupodetalle.setOID(grupodetalle.getOIDInteger());
    }
    grupodetalle.setOid_grupo(dataset.getInteger("oid_grupo"));
    while (!dataset.EOF()) { 
    	if(dataset.getBoolean("seleccionado")){
    		if(primero){
    			cod_ext_tramo = dataset.getString("tracodigo") + ";";
    			primero = false;
    		}else{
    			cod_ext_tramo = cod_ext_tramo + dataset.getString("tracodigo") + ";";
    		}
    	}
    }
    grupodetalle.setCod_ext_1(cod_ext_tramo);
    GrupoRRHH grupo = GrupoRRHH.findByOid(dataset.getInteger("oid_grupo"),getSesion());
    grupodetalle.setActivo(grupo.isActivo());
    addTransaccion(grupodetalle);
    dataset.next();
  }
  
}