package com.srn.erp.Ausentismo.op;

import java.util.List;

import com.srn.erp.Ausentismo.bm.GrupoRRHH;
import com.srn.erp.Ausentismo.bm.GrupoRRHHDetalle;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveGrupoRRHHRotas extends Operation { 

  public SaveGrupoRRHHRotas() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    IDataSet dataset = mapaDatos.getDataSet("TGrupo"); 
    procesarRegistros(dataset); 
  } 

  private void procesarRegistros(IDataSet dataset) throws BaseException { 
    dataset.first(); 
      while (!dataset.EOF()) { 
        GrupoRRHH grupo = GrupoRRHH.findByOid(dataset.getInteger("oid_grupo"),getSesion());
        grupo.setTipo("Rota");
        grupo.setNombre(dataset.getString("nombre"));
        grupo.setActivo(dataset.getBoolean("activo"));
        grupo.save();
        
        IDataSet dsRota = dataset.getDataSet("TRotas");
        dsRota.first();
        List<GrupoRRHHDetalle> grupodetalles = GrupoRRHHDetalle.getSelectByOidGrupo(getSesion(), grupo.getOIDInteger());
        while (!dsRota.EOF()) { 
        	if(dsRota.getBoolean("seleccionado")){
        		if(rotaNoGuardada(grupodetalles, dsRota.getString("tracodigo")) == null){
        			GrupoRRHHDetalle grupoDetalle = GrupoRRHHDetalle.findByOid(-1, getSesion());
        			grupoDetalle.setOID(grupoDetalle.getOIDInteger());
        			grupoDetalle.setOid_grupo(grupo.getOIDInteger());
        			grupoDetalle.setCod_ext_1(dsRota.getString("tracodigo"));
        			grupoDetalle.setActivo(true);
        			grupoDetalle.save();
        		}
        	}else{
        		GrupoRRHHDetalle grupoDetalle = rotaNoGuardada(grupodetalles, dsRota.getString("tracodigo"));
        		if(grupoDetalle != null){
        			grupoDetalle.setActivo(false);
        			grupoDetalle.save();
        		}	
        	}
	        dsRota.next();
        }
        dataset.next();
    }
  }
  
	private GrupoRRHHDetalle rotaNoGuardada(List<GrupoRRHHDetalle> grupodetalles, String rota) throws BaseException {
		for (GrupoRRHHDetalle grupoDetalle : grupodetalles) {
			if (rota.equals(grupoDetalle.getCod_ext_1())) {
				return grupoDetalle;
			}
		}
		return null;
	}
  
  
}