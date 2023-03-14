package com.srn.erp.excluidos.op;

import java.util.Iterator;

import com.srn.erp.excluidos.bm.GrupoImportacionExcEst;
import com.srn.erp.excluidos.bm.GrupoImportacionExcMaq;
import com.srn.erp.excluidos.bm.GrupoImportacionExcPeli;
import com.srn.erp.excluidos.bm.GrupoImportacionExcluido;
import com.srn.erp.excluidos.bm.GrupoImportacionSoloEst;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerGrupoImportacionExcluido extends Operation { 

  public TraerGrupoImportacionExcluido() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    GrupoImportacionExcluido grupoimportacionexcluido = null;
    if (mapaDatos.containsKey("oid")) { 
       Integer oid = mapaDatos.getInteger("oid"); 
       grupoimportacionexcluido = GrupoImportacionExcluido.findByOid(oid, getSesion()); 
    } 
    else { 
       String codigo = mapaDatos.getString("codigo"); 
       grupoimportacionexcluido = GrupoImportacionExcluido.findByCodigo(codigo, getSesion()); 
    } 

    IDataSet datasetGrupoImportacionExcluido = getDataSetGrupoImportacionExcluido();
    IDataSet datasetGrupoImportacionExcPeli = getDataSetGrupoImportacionExcPeli();
    IDataSet datasetGrupoImportacionExcEst = getDataSetGrupoImportacionExcEst();
    IDataSet datasetGrupoImportacionExcMaq = getDataSetGrupoImportacionExcMaq();
    IDataSet datasetGrupoImportacionSolEst = getDataSetGrupoImportacionSoloEst();
    
    if (grupoimportacionexcluido != null) { 
    	
        cargarRegistroGrupoImportacionExcluido(datasetGrupoImportacionExcluido, 
                         grupoimportacionexcluido.getOIDInteger(),
                         grupoimportacionexcluido.getCodigo(),
                         grupoimportacionexcluido.getDescripcion(),
                         grupoimportacionexcluido.getTipo_individuo(),
                         grupoimportacionexcluido.isActivo());
        
        
        Iterator iterGrupoImpExcPeli = 
        	grupoimportacionexcluido.getGruposImpoPeli().iterator();
        while (iterGrupoImpExcPeli.hasNext()) {
        	GrupoImportacionExcPeli grupoImportacionExcPeli = (GrupoImportacionExcPeli) iterGrupoImpExcPeli.next();
        	cargarRegistroGrupoImportacionExcPeli(datasetGrupoImportacionExcPeli, grupoImportacionExcPeli);
        }
        
        Iterator iterGrupoImpExcEst = 
        	grupoimportacionexcluido.getGruposImpoEst().iterator();
        while (iterGrupoImpExcEst.hasNext()) {
        	GrupoImportacionExcEst grupoImportacionExcEst = (GrupoImportacionExcEst) iterGrupoImpExcEst.next();
        	cargarRegistroGrupoImportacionExcEst(datasetGrupoImportacionExcEst, grupoImportacionExcEst);
        }        
        
        Iterator iterGrupoImpExcMaq = 
        	grupoimportacionexcluido.getGruposImpoMaquinas().iterator();
        while (iterGrupoImpExcMaq.hasNext()) {
        	GrupoImportacionExcMaq grupoImportacionExcMaq = (GrupoImportacionExcMaq) iterGrupoImpExcMaq.next();
        	cargarRegistroGrupoImportacionExcMaq(datasetGrupoImportacionExcMaq, grupoImportacionExcMaq);
        }        
        
        Iterator iterGrupoImpEstExc = 
        	grupoimportacionexcluido.getImportacionSoloEstados().iterator();
        while (iterGrupoImpEstExc.hasNext()) {
        	GrupoImportacionSoloEst grupoImpSoloEst = (GrupoImportacionSoloEst) iterGrupoImpEstExc.next();
        	cargarRegistroGrupoImportacionSoloEst(datasetGrupoImportacionSolEst, grupoImpSoloEst);
        }        
        
    }
    
    writeCliente(datasetGrupoImportacionExcluido);
    writeCliente(datasetGrupoImportacionExcPeli);
    writeCliente(datasetGrupoImportacionExcEst);
    writeCliente(datasetGrupoImportacionExcMaq);
    writeCliente(datasetGrupoImportacionSolEst);
    
  }

  private IDataSet getDataSetGrupoImportacionExcluido() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TGrupoImportacionExcluido");
    dataset.fieldDef(new Field("oid_grupo_imp_exc", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("codigo", Field.STRING, 50)); 
    dataset.fieldDef(new Field("descripcion", Field.STRING, 100)); 
    dataset.fieldDef(new Field("tipo_individuo", Field.STRING, 50)); 
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0)); 
    return dataset;
  }

  private void cargarRegistroGrupoImportacionExcluido(IDataSet dataset, 
                         Integer oid_grupo_imp_exc,
                         String codigo,
                         String descripcion,
                         String tipo_individuo,
                         Boolean activo) {
    dataset.append(); 
    dataset.fieldValue("oid_grupo_imp_exc", oid_grupo_imp_exc);
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("descripcion", descripcion);
    dataset.fieldValue("tipo_individuo", tipo_individuo);
    dataset.fieldValue("activo", activo);
  }
  
  private IDataSet getDataSetGrupoImportacionExcPeli() { 
	    IDataSet dataset = new TDataSet(); 
	    dataset.create("TGrupoImportacionExcPeli");
	    dataset.fieldDef(new Field("oid_grupo_impo_peli", Field.INTEGER, 0)); 
	    dataset.fieldDef(new Field("oid_grupo_imp_exc", Field.INTEGER, 0)); 
	    dataset.fieldDef(new Field("oid_predio", Field.INTEGER, 0)); 
	    dataset.fieldDef(new Field("oid_peligrosidad", Field.INTEGER, 0)); 
	    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0)); 
	    return dataset;
	  }

  private void cargarRegistroGrupoImportacionExcPeli(IDataSet dataset, 
	                         GrupoImportacionExcPeli grupoImpExcPeli) throws BaseException {
	    dataset.append(); 
	    dataset.fieldValue("oid_grupo_impo_peli", grupoImpExcPeli.getOIDInteger());
	    dataset.fieldValue("oid_grupo_imp_exc", grupoImpExcPeli.getGrupo_imp_esc().getOID());
	    dataset.fieldValue("oid_predio", grupoImpExcPeli.getPredio().getOIDInteger());
	    dataset.fieldValue("oid_peligrosidad", grupoImpExcPeli.getPeligrosidad().getOIDInteger());
	    dataset.fieldValue("activo", grupoImpExcPeli.isActivo());
  }
  
  private IDataSet getDataSetGrupoImportacionExcEst() { 
	    IDataSet dataset = new TDataSet(); 
	    dataset.create("TGrupoImportacionExcEst");
	    dataset.fieldDef(new Field("oid_grupo_impo_est", Field.INTEGER, 0)); 
	    dataset.fieldDef(new Field("oid_grupo_imp_exc", Field.INTEGER, 0)); 
	    dataset.fieldDef(new Field("oid_predio", Field.INTEGER, 0)); 
	    dataset.fieldDef(new Field("oid_estado", Field.INTEGER, 0)); 
	    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0)); 
	    return dataset;
  }

  private void cargarRegistroGrupoImportacionExcEst(
		  					 IDataSet dataset, 
	                         GrupoImportacionExcEst grupoImpExcEst) throws BaseException {
	    dataset.append(); 
	    dataset.fieldValue("oid_grupo_impo_est", grupoImpExcEst.getOIDInteger());
	    dataset.fieldValue("oid_grupo_imp_exc", grupoImpExcEst.getGrupo_imp_esc().getOIDInteger());
	    dataset.fieldValue("oid_predio", grupoImpExcEst.getPredio().getOIDInteger());
	    dataset.fieldValue("oid_estado", grupoImpExcEst.getEstado().getOIDInteger());
	    dataset.fieldValue("activo", grupoImpExcEst.isActivo());
  }
  
  private IDataSet getDataSetGrupoImportacionExcMaq() { 
	    IDataSet dataset = new TDataSet(); 
	    dataset.create("TGrupoImportacionExcMaq");
	    dataset.fieldDef(new Field("oid_grupo_imp_maq", Field.INTEGER, 0)); 
	    dataset.fieldDef(new Field("oid_grupo_imp_exc", Field.INTEGER, 0)); 
	    dataset.fieldDef(new Field("oid_maquina", Field.INTEGER, 0)); 
	    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0)); 
	    return dataset;
	  }

  private void cargarRegistroGrupoImportacionExcMaq(IDataSet dataset, 
	                         GrupoImportacionExcMaq grupo) throws BaseException {
	    dataset.append(); 
	    dataset.fieldValue("oid_grupo_imp_maq", grupo.getOIDInteger());
	    dataset.fieldValue("oid_grupo_imp_exc", grupo.getGrupo_imp_exc().getOIDInteger());
	    dataset.fieldValue("oid_maquina", grupo.getMaquina().getOIDInteger());
	    dataset.fieldValue("activo",  grupo.isActivo());
	  }
  
  private IDataSet getDataSetGrupoImportacionSoloEst() { 
	    IDataSet dataset = new TDataSet(); 
	    dataset.create("TGrupoImportacionSoloEst");
	    dataset.fieldDef(new Field("oid_grupo_solo_est", Field.INTEGER, 0)); 
	    dataset.fieldDef(new Field("oid_grupo_imp_exc", Field.INTEGER, 0)); 
	    dataset.fieldDef(new Field("oid_estado", Field.INTEGER, 0)); 
	    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0)); 
	    return dataset;
	  }

	  private void cargarRegistroGrupoImportacionSoloEst(IDataSet dataset, 
	                         GrupoImportacionSoloEst grupoImpSoloEst) throws BaseException {
	    dataset.append(); 
	    dataset.fieldValue("oid_grupo_solo_est", grupoImpSoloEst.getOIDInteger());
	    dataset.fieldValue("oid_grupo_imp_exc", grupoImpSoloEst.getGrupo_imp_exc().getOIDInteger());
	    dataset.fieldValue("oid_estado", grupoImpSoloEst.getEstado().getOIDInteger());
	    dataset.fieldValue("activo", grupoImpSoloEst.isActivo());
	  }  
  
}
