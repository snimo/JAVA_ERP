package com.srn.erp.Ausentismo.op;

import java.util.List;

import com.srn.erp.Ausentismo.bm.GrupoRRHHGeneral;
import com.srn.erp.Ausentismo.bm.GrupoRRHHGeneralDesc;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveGrupoRRHHGeneral extends Operation {

	public SaveGrupoRRHHGeneral() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		IDataSet dataset = mapaDatos.getDataSet("TGrupoGral");
		procesarRegistros(dataset);
	}

	private void procesarRegistros(IDataSet dataset) throws BaseException {
		dataset.first();
		while (!dataset.EOF()) {
			GrupoRRHHGeneral gruporrhhgeneral = null;
			if (dataset.getInteger("oid_grupo_gral") != null) {
				gruporrhhgeneral = GrupoRRHHGeneral.findByOid(dataset.getInteger("oid_grupo_gral"), getSesion());
			} else {
				gruporrhhgeneral = GrupoRRHHGeneral.findByOid(-1, getSesion());
			}
			gruporrhhgeneral.setOID(gruporrhhgeneral.getOIDInteger());
			gruporrhhgeneral.setTipo(dataset.getString("tipo"));
			gruporrhhgeneral.setNombre(dataset.getString("nombre"));
			gruporrhhgeneral.setActivo(dataset.getBoolean("activo"));

			IDataSet dsGrupoGralDesc = dataset.getDataSet("TGrupoGralDesc");
			IDataSet datasetEmpresa = dataset.getDataSet("TEmpresa");
			IDataSet datasetEstado = dataset.getDataSet("TEstado");
			IDataSet datasetSector = dataset.getDataSet("TSector");
			IDataSet datasetPuesto = dataset.getDataSet("TPuesto");
			IDataSet datasetTareaDesemp = dataset.getDataSet("TTareaDesemp");
			IDataSet datasetSindicato = dataset.getDataSet("TSindicato");
			dsGrupoGralDesc.first();
			List<GrupoRRHHGeneralDesc> grupoGralDesc = GrupoRRHHGeneralDesc.findByOidGrupoGral(gruporrhhgeneral, this.getSesion());
			while (!dsGrupoGralDesc.EOF()) {
				if (!grupoGralDesc.isEmpty()) {
					GrupoRRHHGeneralDesc grupoGeneralDesc = rotaNoGuardada(grupoGralDesc, dsGrupoGralDesc.getInteger("oid_gru_gral_desc"));
					if (grupoGeneralDesc == null) {
						crearNuevoGrupoGralDesc(gruporrhhgeneral, dsGrupoGralDesc);
					} else {
						grupoGeneralDesc.setActivo(false);
						gruporrhhgeneral.addGruposGeneralDesc(grupoGeneralDesc);
					}
				} else {
					crearNuevoGrupoGralDesc(gruporrhhgeneral, dsGrupoGralDesc);
				}
				dsGrupoGralDesc.next();
			}
			addTransaccion(gruporrhhgeneral);
			dataset.next();
		}

	}

	private void crearNuevoGrupoGralDesc(GrupoRRHHGeneral gruporrhhgeneral, IDataSet dsGrupoGralDesc) throws BaseException {
		GrupoRRHHGeneralDesc grupoDetalle = GrupoRRHHGeneralDesc.findByOid(-1, getSesion());
		grupoDetalle.setOID(grupoDetalle.getOIDInteger());
		grupoDetalle.setGrupogral(gruporrhhgeneral);
		grupoDetalle.setDescripcion(dsGrupoGralDesc.getString("descripcion"));
		grupoDetalle.setActivo(true);
		gruporrhhgeneral.addGruposGeneralDesc(grupoDetalle);
	}

	private GrupoRRHHGeneralDesc rotaNoGuardada(List<GrupoRRHHGeneralDesc> grupoGralDesc, Integer oid_gru_gral_dec) throws BaseException {
		for (GrupoRRHHGeneralDesc grupo : grupoGralDesc) {
			if (oid_gru_gral_dec.equals(grupo.getOIDInteger())) {
				return grupo;
			}
		}
		return null;
	}
}
