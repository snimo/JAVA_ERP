package com.srn.erp.Ausentismo.op;

import java.util.List;

import com.srn.erp.Ausentismo.bm.GrupoRRHHDetalle;
import com.srn.erp.payroll.bm.PayTipoAusencias;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerAusenciasByGrupoDet extends Operation {

	public TraerAusenciasByGrupoDet() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {

		Integer oidGrupo = mapaDatos.getInteger("oid_padre");
		
		List<PayTipoAusencias> ausencias = null;
		List<GrupoRRHHDetalle> grupodetalle = null;
		if (oidGrupo.intValue()>0) {
			grupodetalle = GrupoRRHHDetalle.getSelectByOidGrupo(getSesion(),oidGrupo);
			
			if (!grupodetalle.isEmpty()) {
				ausencias = PayTipoAusencias.findAll(getSesion());
			}
			
			if (ausencias != null) {
				IDataSet datasetGrupoDetalle = getDataSetGrupoDetalle();
				
				cargarRegistroGrupoDetalle(datasetGrupoDetalle, ausencias, grupodetalle, oidGrupo);
				writeCliente(datasetGrupoDetalle);
			}
		}else{
			ausencias = PayTipoAusencias.findAll(getSesion());
			if(ausencias != null){
				IDataSet datasetGrupoDetalle = getDataSetGrupoDetalle();
				cargarRegistro(datasetGrupoDetalle, oidGrupo, ausencias);
				writeCliente(datasetGrupoDetalle);
			}
		}

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

	private void cargarRegistro(IDataSet dataset, Integer oidGrupo, List<PayTipoAusencias> tipoAusentismos) throws BaseException{
		Integer oid = 1;
		for (PayTipoAusencias tAusentismo : tipoAusentismos) {
			dataset.append();
			dataset.fieldValue("oid", oid);
			dataset.fieldValue("oid_grupo",oidGrupo);
			dataset.fieldValue("codigo", tAusentismo.getCodigoActual());
			dataset.fieldValue("cotab", tAusentismo.getCotab());
			dataset.fieldValue("descrip", tAusentismo.getDescrip());
			dataset.fieldValue("seleccionado", false);
			oid++;
		}
	}
	
	private void cargarRegistroGrupoDetalle(IDataSet dataset, List<PayTipoAusencias> tipoAusentismos, List<GrupoRRHHDetalle> gruposDetalle, Integer oid_grupo)
			throws BaseException {
		Integer oid = 1;
		for (PayTipoAusencias tAusentismo : tipoAusentismos) {
			dataset.append();
			dataset.fieldValue("oid", oid);
			dataset.fieldValue("oid_grupo", oid_grupo);
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
