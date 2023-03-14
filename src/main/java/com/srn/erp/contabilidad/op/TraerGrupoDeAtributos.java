package com.srn.erp.contabilidad.op;

import java.util.Iterator;

import com.srn.erp.contabilidad.bm.AtributoEnGrupo;
import com.srn.erp.contabilidad.bm.GrupoDeAtributos;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerGrupoDeAtributos extends Operation {

	public TraerGrupoDeAtributos() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		GrupoDeAtributos grupodeatributos = null;
		if (mapaDatos.containsKey("oid")) {
			Integer oid = mapaDatos.getInteger("oid");
			grupodeatributos = GrupoDeAtributos.findByOid(oid, getSesion());
		}
		else {
			String codigo = mapaDatos.getString("codigo");
			grupodeatributos = GrupoDeAtributos.findByCodigo(codigo, getSesion());
		}

		IDataSet datasetGrupoDeAtributos = getDataSetGrupoDeAtributos();
		IDataSet datasetAtriEnGrupo = getDataSetAtributoEnGrupo();
		
		if (grupodeatributos != null) {
			cargarRegistroGrupoDeAtributos(datasetGrupoDeAtributos, grupodeatributos);
			cargarRegistrosAtriEnGrupos(datasetAtriEnGrupo,grupodeatributos);
		}

		writeCliente(datasetGrupoDeAtributos);
		writeCliente(datasetAtriEnGrupo);
	}
	
	private void cargarRegistrosAtriEnGrupos(IDataSet dataset, 
			                                     GrupoDeAtributos grupoDeAtributos) throws BaseException {
		Iterator iterAtriEnGrupo = grupoDeAtributos.getAtributosEnGrupo().iterator();
		while (iterAtriEnGrupo.hasNext()) {
			AtributoEnGrupo atributoEnGrupo = (AtributoEnGrupo) iterAtriEnGrupo.next();
			cargarRegistroAtributoEnGrupo(dataset,atributoEnGrupo);
		}
	}

	private IDataSet getDataSetGrupoDeAtributos() {
		IDataSet dataset = new TDataSet();
		dataset.create("TGrupoDeAtributos");
		dataset.fieldDef(new Field("oid_grupos_atri", Field.INTEGER, 0));
		dataset.fieldDef(new Field("codigo", Field.STRING, 20));
		dataset.fieldDef(new Field("descripcion", Field.STRING, 50));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		return dataset;
	}
	
  private IDataSet getDataSetAtributoEnGrupo() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TAtributoEnGrupo");
    dataset.fieldDef(new Field("oid_atri_en_grupo", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("oid_grupos_atri", Field.INTEGER, 0));
    
    dataset.fieldDef(new Field("oid_atributo", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("cod_atributo", Field.STRING, 50));
    dataset.fieldDef(new Field("desc_atributo", Field.STRING, 100));
    dataset.fieldDef(new Field("secu", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("formato", Field.STRING, 50)); 
    dataset.fieldDef(new Field("obligatorio", Field.BOOLEAN, 0)); 
    dataset.fieldDef(new Field("max_longitud", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0)); 
    
    return dataset;
  }	

	private void cargarRegistroAtributoEnGrupo(IDataSet dataset, AtributoEnGrupo atributoEnGrupo) throws BaseException {
		dataset.append();
		dataset.fieldValue("oid_atri_en_grupo", atributoEnGrupo.getOIDInteger());
		dataset.fieldValue("oid_grupos_atri", atributoEnGrupo.getGrupoatri().getOIDInteger());
		dataset.fieldValue("oid_atributo", atributoEnGrupo.getAtributo().getOIDInteger());
		dataset.fieldValue("cod_atributo", atributoEnGrupo.getAtributo().getCodigo());
		dataset.fieldValue("desc_atributo", atributoEnGrupo.getAtributo().getDescripcion());
		
		dataset.fieldValue("secu", atributoEnGrupo.getSecu());
		dataset.fieldValue("formato", atributoEnGrupo.getFormato());
		dataset.fieldValue("obligatorio", atributoEnGrupo.isObligatorio());
		dataset.fieldValue("max_longitud", atributoEnGrupo.getMax_longitud());
		dataset.fieldValue("activo", atributoEnGrupo.isActivo());
		
	}

	private void cargarRegistroGrupoDeAtributos(IDataSet dataset, GrupoDeAtributos grupoDeAtributos) throws BaseException {
		dataset.append();
		dataset.fieldValue("oid_grupos_atri", grupoDeAtributos.getOIDInteger());
		dataset.fieldValue("codigo", grupoDeAtributos.getCodigo());
		dataset.fieldValue("descripcion", grupoDeAtributos.getDescripcion());
		dataset.fieldValue("activo", grupoDeAtributos.isActivo());
	}
}
