package com.srn.erp.rrhh.op;

import com.srn.erp.rrhh.bm.FiltroLegCab;
import com.srn.erp.rrhh.bm.FiltroValLegCab;
import com.srn.erp.rrhh.bm.PerfilFiltroLegajo;

import framework.applicarionServer.bm.Seguridad.PerfilFuncional;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveFiltroLegCab extends Operation {

	public SaveFiltroLegCab() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		IDataSet dataset = mapaDatos.getDataSet("TFiltroLegCab");
		procesarRegistros(dataset);
	}

	private void procesarRegistros(IDataSet dataset) throws BaseException {
		dataset.first();
		while (!dataset.EOF()) {
			FiltroLegCab filtrolegcab = FiltroLegCab.findByOid(dataset.getInteger("oid_filtro_cab"), getSesion());
			filtrolegcab.setOID(dataset.getInteger("oid_filtro_cab"));
			filtrolegcab.setDescripcion(dataset.getString("descripcion"));
			filtrolegcab.setAplic_cons_rotas(dataset.getBoolean("aplic_cons_rotas"));
			filtrolegcab.setAplic_busq_leg(dataset.getBoolean("aplic_busq_leg"));
			
			filtrolegcab.setActivo(dataset.getBoolean("activo"));
			addTransaccion(filtrolegcab);

			IDataSet dsEmpresa = dataset.getDataSet("TValoresEmpresa");
			dsEmpresa.first();
			while (!dsEmpresa.EOF()) {

				FiltroValLegCab filtroValLegCab = FiltroValLegCab.getFiltroValLegCab(filtrolegcab, "EMPRESA", dsEmpresa.getInteger("oid_valor"), this.getSesion());

				if (filtroValLegCab == null) {
					filtroValLegCab = (FiltroValLegCab) FiltroValLegCab.getNew(FiltroValLegCab.NICKNAME, this.getSesion());
					filtroValLegCab.setFiltro_cab(filtrolegcab);
					filtroValLegCab.setTipo("EMPRESA");
					filtroValLegCab.setOid_valor(dsEmpresa.getInteger("oid_valor"));
				}
				filtroValLegCab.setActivo(dsEmpresa.getBoolean("activo"));

				filtrolegcab.addValorFiltro(filtroValLegCab);

				dsEmpresa.next();
			}

			IDataSet dsPerfiles = dataset.getDataSet("TPerfilFilLegCab");
			dsPerfiles.first();
			while (!dsPerfiles.EOF()) {
				PerfilFiltroLegajo perfilFiltroLegajo = PerfilFiltroLegajo.findByOid(dsPerfiles.getInteger("oid_perfil_leg_filtro"), this.getSesion());
				perfilFiltroLegajo.setFiltro_legajo_cab(filtrolegcab);
				perfilFiltroLegajo.setPerfil(PerfilFuncional.findByOidProxy(dsPerfiles.getInteger("oid_perfil"), this.getSesion()));
				perfilFiltroLegajo.setActivo(dsPerfiles.getBoolean("activo"));

				filtrolegcab.addPerfil(perfilFiltroLegajo);

				dsPerfiles.next();
			}

			IDataSet dsEstados = dataset.getDataSet("TValoresEstados");
			dsEstados.first();
			while (!dsEstados.EOF()) {

				FiltroValLegCab filtroValLegCab = FiltroValLegCab.getFiltroValLegCab(filtrolegcab, "ESTADO", dsEstados.getInteger("oid_valor"), this.getSesion());

				if (filtroValLegCab == null) {
					filtroValLegCab = (FiltroValLegCab) FiltroValLegCab.getNew(FiltroValLegCab.NICKNAME, this.getSesion());
					filtroValLegCab.setFiltro_cab(filtrolegcab);
					filtroValLegCab.setTipo("ESTADO");
					filtroValLegCab.setOid_valor(dsEstados.getInteger("oid_valor"));
				}
				filtroValLegCab.setActivo(dsEstados.getBoolean("activo"));

				filtrolegcab.addValorFiltro(filtroValLegCab);

				dsEstados.next();
			}
			
			
			IDataSet dsTareas = dataset.getDataSet("TValoresTareasDesemp");
			dsTareas.first();
			while (!dsTareas.EOF()) {

				FiltroValLegCab filtroValLegCab = FiltroValLegCab.getFiltroValLegCab(filtrolegcab, "TAREA", dsTareas.getInteger("oid_valor"), this.getSesion());

				if (filtroValLegCab == null) {
					filtroValLegCab = (FiltroValLegCab) FiltroValLegCab.getNew(FiltroValLegCab.NICKNAME, this.getSesion());
					filtroValLegCab.setFiltro_cab(filtrolegcab);
					filtroValLegCab.setTipo("TAREA");
					filtroValLegCab.setOid_valor(dsTareas.getInteger("oid_valor"));
				}
				filtroValLegCab.setActivo(dsTareas.getBoolean("activo"));

				filtrolegcab.addValorFiltro(filtroValLegCab);

				dsTareas.next();
			}			
			
			IDataSet dsSindicatos = dataset.getDataSet("TValoresClasesSind");
			dsSindicatos.first();
			while (!dsSindicatos.EOF()) {

				FiltroValLegCab filtroValLegCab = FiltroValLegCab.getFiltroValLegCab(filtrolegcab, "SINDICATO", dsSindicatos.getInteger("oid_valor"), this.getSesion());

				if (filtroValLegCab == null) {
					filtroValLegCab = (FiltroValLegCab) FiltroValLegCab.getNew(FiltroValLegCab.NICKNAME, this.getSesion());
					filtroValLegCab.setFiltro_cab(filtrolegcab);
					filtroValLegCab.setTipo("SINDICATO");
					filtroValLegCab.setOid_valor(dsSindicatos.getInteger("oid_valor"));
				}
				filtroValLegCab.setActivo(dsSindicatos.getBoolean("activo"));

				filtrolegcab.addValorFiltro(filtroValLegCab);

				dsSindicatos.next();
			}			

			IDataSet dsSectores = dataset.getDataSet("TValoresSectores");
			dsSectores.first();
			while (!dsSectores.EOF()) {

				FiltroValLegCab filtroValLegCab = FiltroValLegCab.getFiltroValLegCab(filtrolegcab, "SECTOR", dsSectores.getInteger("oid_valor"), this.getSesion());

				if (filtroValLegCab == null) {
					filtroValLegCab = (FiltroValLegCab) FiltroValLegCab.getNew(FiltroValLegCab.NICKNAME, this.getSesion());
					filtroValLegCab.setFiltro_cab(filtrolegcab);
					filtroValLegCab.setTipo("SECTOR");
					filtroValLegCab.setOid_valor(dsSectores.getInteger("oid_valor"));
				}
				filtroValLegCab.setActivo(dsSectores.getBoolean("activo"));

				filtrolegcab.addValorFiltro(filtroValLegCab);

				dsSectores.next();
			}

			IDataSet dsPuestos = dataset.getDataSet("TValoresPuestos");
			dsPuestos.first();
			while (!dsPuestos.EOF()) {

				FiltroValLegCab filtroValLegCab = FiltroValLegCab.getFiltroValLegCab(filtrolegcab, "PUESTO", dsPuestos.getInteger("oid_valor"), this.getSesion());

				if (filtroValLegCab == null) {
					filtroValLegCab = (FiltroValLegCab) FiltroValLegCab.getNew(FiltroValLegCab.NICKNAME, this.getSesion());
					filtroValLegCab.setFiltro_cab(filtrolegcab);
					filtroValLegCab.setTipo("PUESTO");
					filtroValLegCab.setOid_valor(dsPuestos.getInteger("oid_valor"));
				}
				filtroValLegCab.setActivo(dsPuestos.getBoolean("activo"));

				filtrolegcab.addValorFiltro(filtroValLegCab);

				dsPuestos.next();
			}

			dataset.next();
		}

	}

}
