package com.srn.erp.Ausentismo.op;

import java.util.Hashtable;
import java.util.List;

import com.srn.erp.Ausentismo.bm.GrupoRRHH;
import com.srn.erp.Ausentismo.bm.GrupoRRHHDetalle;
import com.srn.erp.payroll.bm.PayTipoAusencias;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerGrupoRRHHTipoAusentismo extends Operation { 

	public TraerGrupoRRHHTipoAusentismo() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		Hashtable<String,Object> hashTable = new Hashtable<String,Object>();
		GrupoRRHH grupo = null;
		if (mapaDatos.containsKey("oid")) {
			Integer oid = mapaDatos.getInteger("oid");
			hashTable.put("oid", oid);
			grupo = GrupoRRHH.findByOid(oid, getSesion());
		}

		IDataSet datasetGrupo = getDataSetGrupo();
		IDataSet datasetGrupoDetalle = getDataSetGrupoDetalle();
		
		if (grupo != null) {
			cargarRegistroGrupo(datasetGrupo, grupo.getOIDInteger(), grupo.getTipo(), grupo.getNombre(), grupo.isActivo());
		}
		
		List<PayTipoAusencias> tipoAusentismo = null;
		Integer oid = mapaDatos.getInteger("oid");
		List<GrupoRRHHDetalle> grupodetalle = GrupoRRHHDetalle.getSelectByOidGrupo(getSesion(),oid);
		tipoAusentismo = PayTipoAusencias.findAll(getSesion());
		
		if (tipoAusentismo != null) {
			cargarRegistroGrupoDetalle(datasetGrupoDetalle, tipoAusentismo, grupodetalle, grupo);
		}
		
		writeCliente(datasetGrupo);
		writeCliente(datasetGrupoDetalle);
	}

	private IDataSet getDataSetGrupo() {
		IDataSet dataset = new TDataSet();
		dataset.create("TGrupo");
		dataset.fieldDef(new Field("oid_grupo", Field.INTEGER, 0));
		dataset.fieldDef(new Field("tipo", Field.STRING, 100));
		dataset.fieldDef(new Field("nombre", Field.STRING, 100));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		return dataset;
	}

	private void cargarRegistroGrupo(IDataSet dataset, Integer oid_grupo,
			String tipo, String nombre, Boolean activo) {
		dataset.append();
		dataset.fieldValue("oid_grupo", oid_grupo);
		dataset.fieldValue("tipo", tipo);
		dataset.fieldValue("nombre", nombre);
		dataset.fieldValue("activo", activo);
	}
	
	private IDataSet getDataSetGrupoDetalle() {
		IDataSet dataset = new TDataSet();
		dataset.create("TAusencias");
		dataset.fieldDef(new Field("oid", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_grupo", Field.INTEGER, 0));
		dataset.fieldDef(new Field("codigo", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cotab", Field.INTEGER, 0));
		dataset.fieldDef(new Field("descrip", Field.STRING, 200));
		dataset.fieldDef(new Field("seleccionado", Field.BOOLEAN, 0));
		return dataset;
	}
	
	private void cargarRegistroGrupoDetalle(IDataSet dataset, List<PayTipoAusencias> tipoAusentismos, List<GrupoRRHHDetalle> gruposDetalle, GrupoRRHH grupo)
			throws BaseException {
		Integer oid = 1;
		for (PayTipoAusencias tAusentismo : tipoAusentismos) {
			dataset.append();
			dataset.fieldValue("oid", oid);
			dataset.fieldValue("oid_grupo", grupo.getOIDInteger());
			dataset.fieldValue("codigo", tAusentismo.getCodigoActual());
			dataset.fieldValue("cotab", tAusentismo.getCotab());
			dataset.fieldValue("descrip", tAusentismo.getDescrip());

			if (rotaSeleccionada(tAusentismo, gruposDetalle)) {
				dataset.fieldValue("seleccionado", true);
			} else {
				dataset.fieldValue("seleccionado", false);
			}
			oid++;
		}
	}
	
	private Boolean rotaSeleccionada(PayTipoAusencias tAusentismo, List<GrupoRRHHDetalle> gruposDetalle) throws BaseException {
		for (GrupoRRHHDetalle grupoDetalle : gruposDetalle) {
			if (tAusentismo.getCodigoActual().equals(Integer.parseInt(grupoDetalle.getCod_ext_1()))) {
				if(tAusentismo.getCotab().equals(Integer.parseInt(grupoDetalle.getCod_ext_2()))){
					return true;
				}
			}
		}
		return false;
	}
}
