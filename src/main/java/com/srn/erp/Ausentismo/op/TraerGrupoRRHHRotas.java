package com.srn.erp.Ausentismo.op;

import java.util.Hashtable;
import java.util.List;

import com.srn.erp.Ausentismo.bm.GrupoRRHH;
import com.srn.erp.Ausentismo.bm.GrupoRRHHDetalle;
import com.srn.erp.payroll.bm.PayRotas;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerGrupoRRHHRotas extends Operation { 

	public TraerGrupoRRHHRotas() {
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
		
		List<PayRotas> rotas = null;
		Integer oid = mapaDatos.getInteger("oid");
		List<GrupoRRHHDetalle> grupodetalle = GrupoRRHHDetalle.getSelectByOidGrupo(getSesion(),oid);
		rotas = PayRotas.findAll(getSesion());
		
		if (rotas != null) {
			cargarRegistroGrupoDetalle(datasetGrupoDetalle, rotas, grupodetalle, grupo);
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
		dataset.create("TRotas");
		dataset.fieldDef(new Field("oid", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_grupo", Field.INTEGER, 0));
		dataset.fieldDef(new Field("tracodigo", Field.STRING, 100));
		dataset.fieldDef(new Field("tradescrip", Field.STRING, 100));
		dataset.fieldDef(new Field("trahoraini", Field.STRING, 100));
		dataset.fieldDef(new Field("trahorafin", Field.STRING, 100));
		dataset.fieldDef(new Field("seleccionado", Field.BOOLEAN, 0));
		return dataset;
	}
	
	private void cargarRegistroGrupoDetalle(IDataSet dataset, List<PayRotas> rotas, List<GrupoRRHHDetalle> gruposDetalle, GrupoRRHH grupo)
			throws BaseException {
		Integer oid = 1;
		for (PayRotas payRota : rotas) {
			dataset.append();
			dataset.fieldValue("oid", oid);
			dataset.fieldValue("oid_grupo", grupo.getOIDInteger());
			dataset.fieldValue("tracodigo", payRota.getTracodigo());
			dataset.fieldValue("tradescrip", payRota.getTradescrip());
			dataset.fieldValue("trahoraini", payRota.getTrahoraini());
			dataset.fieldValue("trahorafin", payRota.getTrahorafin());

			if (rotaSeleccionada(payRota.getTracodigo(), gruposDetalle)) {
				dataset.fieldValue("seleccionado", true);
			} else {
				dataset.fieldValue("seleccionado", false);
			}
			oid++;
		}
	}
	
	private Boolean rotaSeleccionada(String rota, List<GrupoRRHHDetalle> gruposDetalle) throws BaseException {
		for (GrupoRRHHDetalle grupoDetalle : gruposDetalle) {
			if (rota.equals(grupoDetalle.getCod_ext_1())) {
				return true;
			}
		}
		return false;
	}
  
}
