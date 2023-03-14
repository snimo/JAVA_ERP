package com.srn.erp.Ausentismo.op;

import java.util.List;

import com.srn.erp.Ausentismo.bm.GrupoRRHHDetalle;
import com.srn.erp.payroll.bm.PayRotas;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerRotasByGrupoDet extends Operation {

	public TraerRotasByGrupoDet() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {

		Integer oidGrupo = mapaDatos.getInteger("oid_padre");
		
		List<PayRotas> rotas = null;
		List<GrupoRRHHDetalle> grupodetalle = null;
		if (oidGrupo.intValue()>0) {
			grupodetalle = GrupoRRHHDetalle.getSelectByOidGrupo(getSesion(),oidGrupo);
			
			if (!grupodetalle.isEmpty()) {
				rotas = PayRotas.findAll(getSesion());
			}
			
			if (rotas != null) {
				IDataSet datasetGrupoDetalle = getDataSetGrupoDetalle();
				
				cargarRegistroGrupoDetalle(datasetGrupoDetalle, rotas, grupodetalle, oidGrupo);
				writeCliente(datasetGrupoDetalle);
			}
		}else{
			rotas = PayRotas.findAll(getSesion());
			if(rotas != null){
				IDataSet datasetGrupoDetalle = getDataSetGrupoDetalle();
				cargarRegistro(datasetGrupoDetalle, oidGrupo, rotas);
				writeCliente(datasetGrupoDetalle);
			}
		}

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

	private void cargarRegistro(IDataSet dataset, Integer oidGrupo,List<PayRotas> rotas) throws BaseException{
		Integer oid = 1;
		for (PayRotas payRota : rotas) {
			dataset.append();
			dataset.fieldValue("oid", oid);
			dataset.fieldValue("oid_grupo",oidGrupo);
			dataset.fieldValue("tracodigo", payRota.getTracodigo());
			dataset.fieldValue("tradescrip", payRota.getTradescrip());
			dataset.fieldValue("trahoraini", payRota.getTrahoraini());
			dataset.fieldValue("trahorafin", payRota.getTrahorafin());
			dataset.fieldValue("seleccionado", false);
			oid++;
		}
	}
	
	private void cargarRegistroGrupoDetalle(IDataSet dataset, List<PayRotas> rotas, List<GrupoRRHHDetalle> grupoDetalle, Integer oidGrupo)
			throws BaseException {
		Integer oid = 1;
		for (PayRotas payRota : rotas) {
			dataset.append();
			dataset.fieldValue("oid", oid);
			dataset.fieldValue("oid_grupo", oidGrupo);
			dataset.fieldValue("tracodigo", payRota.getTracodigo());
			dataset.fieldValue("tradescrip", payRota.getTradescrip());
			dataset.fieldValue("trahoraini", payRota.getTrahoraini());
			dataset.fieldValue("trahorafin", payRota.getTrahorafin());

			if (rotaSeleccionada(payRota.getTracodigo(), grupoDetalle)) {
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
