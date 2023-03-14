package com.srn.erp.Ausentismo.op;

import java.util.List;

import com.srn.erp.Ausentismo.bm.GrupoRRHH;
import com.srn.erp.Ausentismo.bm.GrupoRRHHDetalle;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveGrupoRRHHTipoAusencia extends Operation { 

  public SaveGrupoRRHHTipoAusencia() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    IDataSet dataset = mapaDatos.getDataSet("TGrupo"); 
    procesarRegistros(dataset); 
  } 

  private void procesarRegistros(IDataSet dataset) throws BaseException { 
    dataset.first(); 
      while (!dataset.EOF()) { 
        GrupoRRHH grupo = GrupoRRHH.findByOid(dataset.getInteger("oid_grupo"),getSesion());
        grupo.setTipo("Ausencia");
        grupo.setNombre(dataset.getString("nombre"));
        grupo.setActivo(dataset.getBoolean("activo"));
        grupo.save();
        
        IDataSet dsAusencias = dataset.getDataSet("TAusencias");
        dsAusencias.first();
        List<GrupoRRHHDetalle> grupodetalles = GrupoRRHHDetalle.getSelectByOidGrupo(getSesion(), grupo.getOIDInteger());
        while (!dsAusencias.EOF()) { 
        	if(dsAusencias.getBoolean("seleccionado")){
        		if(rotaNoGuardada(grupodetalles, dsAusencias.getInteger("codigo"), dsAusencias.getInteger("cotab")) == null){
        			GrupoRRHHDetalle grupoDetalle = GrupoRRHHDetalle.findByOid(-1, getSesion());
        			grupoDetalle.setOID(grupoDetalle.getOIDInteger());
        			grupoDetalle.setOid_grupo(grupo.getOIDInteger());
        			grupoDetalle.setCod_ext_1(dsAusencias.getString("codigo"));
        			grupoDetalle.setCod_ext_2(dsAusencias.getString("cotab"));
        			grupoDetalle.setDescripcion(dsAusencias.getString("descrip"));
        			grupoDetalle.setActivo(true);
        			grupoDetalle.save();
        		}
        	}else{
        		GrupoRRHHDetalle grupoDetalle = rotaNoGuardada(grupodetalles, dsAusencias.getInteger("codigo"), dsAusencias.getInteger("cotab"));
        		if(grupoDetalle != null){
        			grupoDetalle.setActivo(false);
        			grupoDetalle.save();
        		}	
        	}
        	dsAusencias.next();
        }
        dataset.next();
    }
  }
  
	private GrupoRRHHDetalle rotaNoGuardada(List<GrupoRRHHDetalle> grupodetalles, Integer codigo, Integer cotab) throws BaseException {
		for (GrupoRRHHDetalle grupoDetalle : grupodetalles) {
			if (codigo.equals(Integer.parseInt(grupoDetalle.getCod_ext_1()))) {
				if (cotab.equals(Integer.parseInt(grupoDetalle.getCod_ext_2()))) {
					return GrupoRRHHDetalle.findByOid(grupoDetalle.getOIDInteger(), this.getSesion());
				}
			}
		}
		return null;
	}
  
  
}