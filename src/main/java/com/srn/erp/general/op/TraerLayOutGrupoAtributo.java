package com.srn.erp.general.op;

import java.util.Iterator;

import com.srn.erp.contabilidad.bm.AtributoEnGrupo;
import com.srn.erp.contabilidad.bm.GrupoDeAtributos;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerLayOutGrupoAtributo extends Operation {

	public TraerLayOutGrupoAtributo() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {

		Integer oidGrupoAtributos = mapaDatos.getInteger("oid_grupo_atributos");
		GrupoDeAtributos grupoDeAtributos = GrupoDeAtributos.findByOid(oidGrupoAtributos, this.getSesion());
		
		IDataSet dataSetAtriEnGrupos = this.getDataSetAtributosEnGrupo();

		cargarAtributosEnGrupo(dataSetAtriEnGrupos, grupoDeAtributos);

		writeCliente(dataSetAtriEnGrupos);
		
	}

	private IDataSet getDataSetAtributosEnGrupo() {
		IDataSet dataset = new TDataSet();
		dataset.create("TAtributosEnGrupo");
		dataset.fieldDef(new Field("oid_atri_en_grupo", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_grupos_atri", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_atributo", Field.INTEGER, 0));
		dataset.fieldDef(new Field("tipo", Field.STRING, 10));
		dataset.fieldDef(new Field("secu", Field.INTEGER, 0));
		dataset.fieldDef(new Field("formato", Field.STRING, 50));
		dataset.fieldDef(new Field("obligatorio", Field.BOOLEAN,0));
		dataset.fieldDef(new Field("max_longitud", Field.INTEGER,0));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN,0));
		dataset.fieldDef(new Field("oid_compo", Field.INTEGER,0));
		dataset.fieldDef(new Field("nombre", Field.STRING,100));
		return dataset;
	}
	
	private void cargarAtributosEnGrupo(IDataSet dataset, GrupoDeAtributos grupoDeAtributos) throws BaseException {
		
		Iterator iterAtriEnGrupo = grupoDeAtributos.getAtributosEnGrupo().iterator();
		while (iterAtriEnGrupo.hasNext()) {
			AtributoEnGrupo atributoEnGrupo = (AtributoEnGrupo) iterAtriEnGrupo.next();
			dataset.append();
			dataset.fieldValue("oid_atri_en_grupo", atributoEnGrupo.getOIDInteger());
			dataset.fieldValue("oid_grupos_atri", atributoEnGrupo.getGrupoatri().getOIDInteger());
			dataset.fieldValue("oid_atributo", atributoEnGrupo.getAtributo().getOIDInteger());
			dataset.fieldValue("tipo", atributoEnGrupo.getAtributo().getTipo());
			dataset.fieldValue("secu", atributoEnGrupo.getSecu());
			dataset.fieldValue("formato", atributoEnGrupo.getFormato());
			dataset.fieldValue("obligatorio", atributoEnGrupo.isObligatorio());
			dataset.fieldValue("max_longitud", atributoEnGrupo.getMax_longitud());
			dataset.fieldValue("activo", atributoEnGrupo.isActivo());
			if (atributoEnGrupo.getAtributo().getCompo()!=null)
				dataset.fieldValue("oid_compo", atributoEnGrupo.getAtributo().getCompo().getOIDInteger());
			else
				dataset.fieldValue("oid_compo", 0);
			dataset.fieldValue("nombre", atributoEnGrupo.getAtributo().getDescripcion());
		}
	}
	
	
}
