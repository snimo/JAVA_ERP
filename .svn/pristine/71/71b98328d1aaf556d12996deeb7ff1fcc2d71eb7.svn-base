package com.srn.erp.Ausentismo.op;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import com.srn.erp.Ausentismo.bm.GrupoRRHHGeneral;
import com.srn.erp.Ausentismo.bm.GrupoRRHHGeneralCodigo;
import com.srn.erp.Ausentismo.bm.GrupoRRHHGeneralDesc;
import com.srn.erp.payroll.bm.PayEmpresa;
import com.srn.erp.payroll.bm.PayEstado;
import com.srn.erp.payroll.bm.PayPuesto;
import com.srn.erp.payroll.bm.PaySectores;
import com.srn.erp.payroll.bm.PayTareaDesempenada;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerGrupoRRHHGeneral extends Operation {

	public TraerGrupoRRHHGeneral() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {

		Integer oidGrupoGral = null;
		if (mapaDatos.containsKey("oid")) {
			oidGrupoGral = mapaDatos.getInteger("oid");
		}

		GrupoRRHHGeneral grupoGral = null;
		List<GrupoRRHHGeneralDesc> gruposGralDescrip = new ArrayList<GrupoRRHHGeneralDesc>();
		if (oidGrupoGral != null) {
			grupoGral = GrupoRRHHGeneral.findByOid(oidGrupoGral, this.getSesion());
		}

		IDataSet datasetGrupoRRHHGeneral = getDataSetGrupoRRHHGeneral();
		if (grupoGral != null) {
			gruposGralDescrip = GrupoRRHHGeneralDesc.findByOidGrupoGral(grupoGral, this.getSesion());
			cargarRegistroGrupoRRHHGeneral(datasetGrupoRRHHGeneral, grupoGral);
		}

		// Creo Datasets
		IDataSet datasetGrupoRRHHGeneralDesc = getDataSetGrupoRRHHGeneralDesc();
		IDataSet datasetEmpresa = getDataSetEmpresas();
		IDataSet datasetEstado = getDataSetEstados();
		IDataSet datasetSector = getDataSetSector();
		IDataSet datasetPuesto = getDataSetPuesto();
		IDataSet datasetTareaDesemp = getDataSetTareaDesemp();
		IDataSet datasetSindicato = getDataSetSindicato();
		
		//Cargo Datasets
		if (gruposGralDescrip != null && !gruposGralDescrip.isEmpty()) {
			cargarRegistroGrupoRRHHGeneralDesc(datasetGrupoRRHHGeneralDesc, gruposGralDescrip, grupoGral);

			Hashtable<String, Object> hashTable = new Hashtable<String, Object>();
			List<PayEmpresa> empresas = PayEmpresa.findAllEmpresas(this.getSesion(), hashTable);
			List<PayEstado> estados = PayEstado.findAll(this.getSesion());
			List<PaySectores> sectores = PaySectores.findAll(this.getSesion());
			List<PayPuesto> puestos = PayPuesto.findAll(this.getSesion());
			List<PayTareaDesempenada> tareas = PayTareaDesempenada.findAll(this.getSesion());
			for (GrupoRRHHGeneralDesc grupoDesc : gruposGralDescrip) {
				List<GrupoRRHHGeneralCodigo> gruposCodigos = grupoDesc.getGruposGeneralCodigo();
				cargarRegistroEmpresas(datasetEmpresa, empresas, grupoDesc, gruposCodigos);
				cargarRegistroEstados(datasetEstado, estados, grupoDesc, gruposCodigos);
				cargarRegistroSectores(datasetSector, sectores, grupoDesc, gruposCodigos);
				cargarRegistroPuestos(datasetPuesto, puestos, grupoDesc, gruposCodigos);
				cargarRegistroTareasDesempenadas(datasetTareaDesemp, tareas, grupoDesc, gruposCodigos);
				//TODO Fala Sindicato
			}
		}

		writeCliente(datasetGrupoRRHHGeneral);
		writeCliente(datasetGrupoRRHHGeneralDesc);
		writeCliente(datasetEmpresa);
		writeCliente(datasetEstado);
		writeCliente(datasetSector);
		writeCliente(datasetPuesto);
		writeCliente(datasetTareaDesemp);
		writeCliente(datasetSindicato);
	}

	// ************************************ DataSets *******************************************

	private IDataSet getDataSetGrupoRRHHGeneral() {
		IDataSet dataset = new TDataSet();
		dataset.create("TGrupoGral");
		dataset.fieldDef(new Field("oid_grupo_gral", Field.INTEGER, 0));
		dataset.fieldDef(new Field("tipo", Field.STRING, 50));
		dataset.fieldDef(new Field("nombre", Field.STRING, 100));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		return dataset;
	}

	private IDataSet getDataSetGrupoRRHHGeneralDesc() {
		IDataSet dataset = new TDataSet();
		dataset.create("TGrupoGralDesc");
		dataset.fieldDef(new Field("oid_gru_gral_desc", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_grupo_gral", Field.INTEGER, 0));
		dataset.fieldDef(new Field("descripcion", Field.STRING, 100));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		return dataset;
	}

	private IDataSet getDataSetEmpresas() {
		IDataSet dataset = new TDataSet();
		dataset.create("TEmpresa");
		dataset.fieldDef(new Field("oid", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_gru_gral_desc", Field.INTEGER, 0));
		dataset.fieldDef(new Field("codigo", Field.STRING, 100));
		dataset.fieldDef(new Field("descripcion", Field.STRING, 100));
		dataset.fieldDef(new Field("seleccionado", Field.BOOLEAN, 0));
		return dataset;
	}

	private IDataSet getDataSetEstados() {
		IDataSet dataset = new TDataSet();
		dataset.create("TEstado");
		dataset.fieldDef(new Field("oid", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_gru_gral_desc", Field.INTEGER, 0));
		dataset.fieldDef(new Field("estado", Field.STRING, 100));
		dataset.fieldDef(new Field("seleccionado", Field.BOOLEAN, 0));
		return dataset;
	}

	private IDataSet getDataSetSector() {
		IDataSet dataset = new TDataSet();
		dataset.create("TSector");
		dataset.fieldDef(new Field("oid", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_gru_gral_desc", Field.INTEGER, 0));
		dataset.fieldDef(new Field("codigo", Field.STRING, 100));
		dataset.fieldDef(new Field("descripcion", Field.STRING, 100));
		dataset.fieldDef(new Field("seleccionado", Field.BOOLEAN, 0));
		return dataset;
	}

	private IDataSet getDataSetPuesto() {
		IDataSet dataset = new TDataSet();
		dataset.create("TPuesto");
		dataset.fieldDef(new Field("oid", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_gru_gral_desc", Field.INTEGER, 0));
		dataset.fieldDef(new Field("codigo", Field.STRING, 100));
		dataset.fieldDef(new Field("descripcion", Field.STRING, 100));
		dataset.fieldDef(new Field("seleccionado", Field.BOOLEAN, 0));
		return dataset;
	}

	private IDataSet getDataSetTareaDesemp() {
		IDataSet dataset = new TDataSet();
		dataset.create("TTareaDesemp");
		dataset.fieldDef(new Field("oid", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_gru_gral_desc", Field.INTEGER, 0));
		dataset.fieldDef(new Field("codigo", Field.STRING, 100));
		dataset.fieldDef(new Field("descripcion", Field.STRING, 100));
		dataset.fieldDef(new Field("seleccionado", Field.BOOLEAN, 0));
		return dataset;
	}

	private IDataSet getDataSetSindicato() {
		IDataSet dataset = new TDataSet();
		dataset.create("TSindicato");
		dataset.fieldDef(new Field("oid", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_gru_gral_desc", Field.INTEGER, 0));
		dataset.fieldDef(new Field("codigo", Field.STRING, 100));
		dataset.fieldDef(new Field("descripcion", Field.STRING, 100));
		dataset.fieldDef(new Field("seleccionado", Field.BOOLEAN, 0));
		return dataset;
	}

	// *********************************** Cargar DataSets ********************************

	private void cargarRegistroGrupoRRHHGeneral(IDataSet dataset, GrupoRRHHGeneral grupoGral) throws BaseException {
		dataset.append();
		dataset.fieldValue("oid_grupo_gral", grupoGral.getOIDInteger());
		dataset.fieldValue("tipo", grupoGral.getTipo());
		dataset.fieldValue("nombre", grupoGral.getNombre());
		dataset.fieldValue("activo", grupoGral.isActivo());
	}

	private void cargarRegistroGrupoRRHHGeneralDesc(IDataSet dataset, List<GrupoRRHHGeneralDesc> gruposGralDesc, GrupoRRHHGeneral grupoGral) throws BaseException {
		for (GrupoRRHHGeneralDesc grupoRRHHGeneralDesc : gruposGralDesc) {
			dataset.append();
			dataset.fieldValue("oid_gru_gral_desc", grupoRRHHGeneralDesc.getOIDInteger());
			dataset.fieldValue("oid_grupo_gral", grupoGral.getOIDInteger());
			dataset.fieldValue("descripcion", grupoRRHHGeneralDesc.getDescripcion());
			dataset.fieldValue("activo", grupoRRHHGeneralDesc.isActivo());
		}
	}

	private void cargarRegistroEmpresas(IDataSet dataset, List<PayEmpresa> empresas, GrupoRRHHGeneralDesc grupoGralDesc, List<GrupoRRHHGeneralCodigo> gruposCodigos) throws BaseException {
		int oid = 1;
		for (PayEmpresa empresa : empresas) {
			dataset.append();
			dataset.fieldValue("oid", oid);
			dataset.fieldValue("oid_gru_gral_desc", grupoGralDesc.getOIDInteger());
			dataset.fieldValue("codigo", empresa.getEmpresa());
			dataset.fieldValue("descripcion", empresa.getNombre());
			if (empresaSeleccionada(empresa, gruposCodigos)) {
				dataset.fieldValue("seleccionado", true);
			} else {
				dataset.fieldValue("seleccionado", false);
			}
			oid++;
		}
	}
	
	private void cargarRegistroEstados(IDataSet dataset, List<PayEstado> estados, GrupoRRHHGeneralDesc grupoGralDesc, List<GrupoRRHHGeneralCodigo> gruposCodigos) throws BaseException {
		int oid = 1;
		for (PayEstado estado : estados) {
			dataset.append();
			dataset.fieldValue("oid", oid);
			dataset.fieldValue("oid_gru_gral_desc", grupoGralDesc.getOIDInteger());
			dataset.fieldValue("estado", estado.getEstado());
			if (estadoSeleccionada(estado, gruposCodigos)) {
				dataset.fieldValue("seleccionado", true);
			} else {
				dataset.fieldValue("seleccionado", false);
			}
			oid++;
		}
	}
	
	private void cargarRegistroSectores(IDataSet dataset, List<PaySectores> sectores, GrupoRRHHGeneralDesc grupoGralDesc, List<GrupoRRHHGeneralCodigo> gruposCodigos) throws BaseException {
		int oid = 1;
		for (PaySectores sector : sectores) {
			dataset.append();
			dataset.fieldValue("oid", oid);
			dataset.fieldValue("oid_gru_gral_desc", grupoGralDesc.getOIDInteger());
			dataset.fieldValue("codigo", sector.getCodigo());
			dataset.fieldValue("descripcion", sector.getDescripcion());
			if (sectorSeleccionada(sector, gruposCodigos)) {
				dataset.fieldValue("seleccionado", true);
			} else {
				dataset.fieldValue("seleccionado", false);
			}
			oid++;
		}
	}
	
	private void cargarRegistroPuestos(IDataSet dataset, List<PayPuesto> puestos, GrupoRRHHGeneralDesc grupoGralDesc, List<GrupoRRHHGeneralCodigo> gruposCodigos) throws BaseException {
		int oid = 1;
		for (PayPuesto puesto : puestos) {
			dataset.append();
			dataset.fieldValue("oid", oid);
			dataset.fieldValue("oid_gru_gral_desc", grupoGralDesc.getOIDInteger());
			dataset.fieldValue("codigo", puesto.getCodigo());
			dataset.fieldValue("descripcion", puesto.getDescripcion());
			if (puestoSeleccionada(puesto, gruposCodigos)) {
				dataset.fieldValue("seleccionado", true);
			} else {
				dataset.fieldValue("seleccionado", false);
			}
			oid++;
		}
	}

	private void cargarRegistroTareasDesempenadas(IDataSet dataset, List<PayTareaDesempenada> tareas, GrupoRRHHGeneralDesc grupoGralDesc, List<GrupoRRHHGeneralCodigo> gruposCodigos) throws BaseException {
		int oid = 1;
		for (PayTareaDesempenada tarea : tareas) {
			dataset.append();
			dataset.fieldValue("oid", oid);
			dataset.fieldValue("oid_gru_gral_desc", grupoGralDesc.getOIDInteger());
			dataset.fieldValue("codigo", tarea.getCodigo());
			dataset.fieldValue("descripcion", tarea.getDescripcion());
			if (tareaSeleccionada(tarea, gruposCodigos)) {
				dataset.fieldValue("seleccionado", true);
			} else {
				dataset.fieldValue("seleccionado", false);
			}
			oid++;
		}
	}
	
	// *************************************** Validadores ***************************************
	
	private Boolean empresaSeleccionada(PayEmpresa tEmpresa, List<GrupoRRHHGeneralCodigo> gruposCod) throws BaseException {
		for (GrupoRRHHGeneralCodigo grupoCod : gruposCod) {
			if(grupoCod.getTipotabla().equals("Empresa")){
				if (tEmpresa.getEmpresa().equals(Integer.parseInt(grupoCod.getCodigoexternoelemento()))) {
					return true;
				}
			}
		}
		return false;
	}
	
	private Boolean estadoSeleccionada(PayEstado tEmpresa, List<GrupoRRHHGeneralCodigo> gruposCod) throws BaseException {
		for (GrupoRRHHGeneralCodigo grupoCod : gruposCod) {
			if(grupoCod.getTipotabla().equals("Estado")){
				if (tEmpresa.getEstado().equals(Integer.parseInt(grupoCod.getCodigoexternoelemento()))) {
					return true;
				}
			}
		}
		return false;
	}
	
	private Boolean sectorSeleccionada(PaySectores tSector, List<GrupoRRHHGeneralCodigo> gruposCod) throws BaseException {
		for (GrupoRRHHGeneralCodigo grupoCod : gruposCod) {
			if(grupoCod.getTipotabla().equals("Sector")){
				if (tSector.getCodigo().equals(Integer.parseInt(grupoCod.getCodigoexternoelemento()))) {
					return true;
				}
			}
		}
		return false;
	}
	
	private Boolean puestoSeleccionada(PayPuesto tPuesto, List<GrupoRRHHGeneralCodigo> gruposCod) throws BaseException {
		for (GrupoRRHHGeneralCodigo grupoCod : gruposCod) {
			if(grupoCod.getTipotabla().equals("Puesto")){
				if (tPuesto.getCodigo().equals(Integer.parseInt(grupoCod.getCodigoexternoelemento()))) {
					return true;
				}
			}
		}
		return false;
	}
	
	private Boolean tareaSeleccionada(PayTareaDesempenada tTarea, List<GrupoRRHHGeneralCodigo> gruposCod) throws BaseException {
		for (GrupoRRHHGeneralCodigo grupoCod : gruposCod) {
			if(grupoCod.getTipotabla().equals("Tarea")){
				if (tTarea.getCodigo().equals(Integer.parseInt(grupoCod.getCodigoexternoelemento()))) {
					return true;
				}
			}
		}
		return false;
	}

}
