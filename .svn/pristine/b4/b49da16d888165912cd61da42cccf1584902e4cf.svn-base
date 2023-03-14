package com.srn.erp.mensajero.op;

import java.util.Iterator;

import com.srn.erp.mensajero.bm.GrupoMaquina;
import com.srn.erp.mensajero.bm.GrupoMaquinaDet;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerGrupoMaquina extends Operation {

	public TraerGrupoMaquina() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		
		GrupoMaquina grupomaquina = null;
		if (mapaDatos.containsKey("oid")) {
			Integer oid = mapaDatos.getInteger("oid");
			grupomaquina = GrupoMaquina.findByOid(oid, getSesion());
		} else {
			String codigo = mapaDatos.getString("codigo");
			grupomaquina = GrupoMaquina.findByCodigo(codigo, getSesion());
		}

		IDataSet datasetGrupoMaquina = getDataSetGrupoMaquina();
		IDataSet datasetGrupoMaquinaDet = getDataSetGrupoMaquinaDet();
		
		if (grupomaquina != null) {
			
			cargarRegistroGrupoMaquina(datasetGrupoMaquina, grupomaquina);
			Iterator iterMaquinasDet = 
				grupomaquina.getMaquinasDet().iterator();
			while (iterMaquinasDet.hasNext()) {
				GrupoMaquinaDet grupoMaquinaDet = (GrupoMaquinaDet) iterMaquinasDet.next();
				cargarRegistroGrupoMaquinaDet(datasetGrupoMaquinaDet, grupoMaquinaDet);
			}
			
		}
		
		writeCliente(datasetGrupoMaquina);
		writeCliente(datasetGrupoMaquinaDet);
		
	}

	private IDataSet getDataSetGrupoMaquina() {
		IDataSet dataset = new TDataSet();
		dataset.create("TGrupoMaquina");
		dataset.fieldDef(new Field("oid_grupo_maq", Field.INTEGER, 0));
		dataset.fieldDef(new Field("nombre", Field.STRING, 100));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		return dataset;
	}
	
	private IDataSet getDataSetGrupoMaquinaDet() {
		IDataSet dataset = new TDataSet();
		dataset.create("TGrupoMaquinaDet");
		dataset.fieldDef(new Field("oid_grupo_maq_det", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_grupo_maq", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_maquina", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_maquina", Field.STRING, 50));
		dataset.fieldDef(new Field("desc_maquina", Field.STRING, 100));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		return dataset;
	}
	

	private void cargarRegistroGrupoMaquina(IDataSet dataset, GrupoMaquina grupoMaquina) throws BaseException {
		dataset.append();
		dataset.fieldValue("oid_grupo_maq", grupoMaquina.getOIDInteger());
		dataset.fieldValue("nombre", grupoMaquina.getNombre());
		dataset.fieldValue("activo", grupoMaquina.isActivo());
	}
	
	private void cargarRegistroGrupoMaquinaDet(IDataSet dataset, GrupoMaquinaDet grupoMaquinaDet) throws BaseException {
		dataset.append();
		dataset.fieldValue("oid_grupo_maq_det", grupoMaquinaDet.getOIDInteger());
		dataset.fieldValue("oid_grupo_maq", grupoMaquinaDet.getGrupo_maquina().getOIDInteger());
		dataset.fieldValue("oid_maquina", grupoMaquinaDet.getMaquina().getOIDInteger());
		dataset.fieldValue("cod_maquina", grupoMaquinaDet.getMaquina().getCodigo());
		dataset.fieldValue("desc_maquina", grupoMaquinaDet.getMaquina().getNombre());
		dataset.fieldValue("activo", grupoMaquinaDet.isActivo());
	}	
	
}
