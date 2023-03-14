package com.srn.erp.sueldos.op;

import com.srn.erp.general.bm.ClasificadorEntidad;
import com.srn.erp.rrhh.op.TraerLeyendasRepEval;

import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bm.Parametros.ValorParametro;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class InitLegajos extends Operation {

	public InitLegajos() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		inicializar(mapaDatos);
	}
	
	private IDataSet getDataSetOtrosDatos() {
		IDataSet dataset = new TDataSet();
		dataset.create("TOtrosDatosLeg");
		dataset.fieldDef(new Field("nro_clasif_puesto", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_clasif_ent_puesto", Field.INTEGER, 0));
		dataset.fieldDef(new Field("nro_clasif_empresa", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_clasif_ent_empresa", Field.INTEGER, 0));
		dataset.fieldDef(new Field("nro_clasif_sector", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_clasif_ent_sector", Field.INTEGER, 0));		
		return dataset;
	}
	
	private void cargarOtrosDatosLeg(IDataSet dsOtrosDatos) throws BaseException {
		dsOtrosDatos.append();
		
		Integer nroClasifPuesto = new Integer(0);
		Integer nroClasifEmpresa = new Integer(0);
		Integer nroClasifSector = new Integer(0);
		
		ClasificadorEntidad clasifPuesto  = null;
		ClasificadorEntidad clasifEmpresa  = null;
		ClasificadorEntidad clasifSector  = null;
		
		try {
			clasifPuesto  = TraerLeyendasRepEval.getClasificadorPuesto(this.getSesion());
			nroClasifPuesto = clasifPuesto.getNroClasif();
		} catch(Exception e) {
		}
		
		try {
			clasifEmpresa  = TraerLeyendasRepEval.getClasificadorEmpresa(this.getSesion());
			nroClasifEmpresa = clasifEmpresa.getNroClasif();
		} catch(Exception e) {
		}
		
		try {
			clasifSector  = TraerLeyendasRepEval.getClasificadorSector(this.getSesion());
			nroClasifSector = clasifSector.getNroClasif();
		} catch(Exception e) {
		}		
		
		dsOtrosDatos.fieldValue("nro_clasif_puesto", nroClasifPuesto);
		if (clasifPuesto!=null)
			dsOtrosDatos.fieldValue("oid_clasif_ent_puesto", clasifPuesto.getOIDInteger());
		else
			dsOtrosDatos.fieldValue("oid_clasif_ent_puesto", "");
		
		dsOtrosDatos.fieldValue("nro_clasif_empresa", nroClasifEmpresa);
		if (clasifEmpresa!=null)
			dsOtrosDatos.fieldValue("oid_clasif_ent_empresa", clasifEmpresa.getOIDInteger());
		else
			dsOtrosDatos.fieldValue("oid_clasif_ent_empresa", "");		
		
		dsOtrosDatos.fieldValue("nro_clasif_sector", nroClasifSector);
		if (clasifSector!=null)
			dsOtrosDatos.fieldValue("oid_clasif_ent_sector", clasifSector.getOIDInteger());
		else
			dsOtrosDatos.fieldValue("oid_clasif_ent_sector", "");		
		
	}
	

	private IDataSet getDataSetInitLegajos() {
		IDataSet dataset = new TDataSet();
		dataset.create("TOcultarSolapasLegajo");
		dataset.fieldDef(new Field("ocultar_solapa_tarjetas", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("ocultar_solapa_con_acc", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("ocultar_solapa_personal", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("ocultar_solapa_empresa", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("ocultar_solapa_sanciones", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("ocultar_solapa_servmed", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("ocultar_solapa_eval", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("ocultar_solapa_legales", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("ocultar_solapa_desarrollo", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("ocultar_solapa_observaciones", Field.BOOLEAN, 0));
		return dataset;
	}
	
	public static boolean isOcultaSolapaTarjetas(ISesion aSesion)
	throws BaseException {
		try {
			return ValorParametro.findByCodigoParametro(
					"OCULTAR_SOL_TARJ_LEG", aSesion).getBoolean();
		} catch(Exception e) {
			return false;
		}
	}
	
	public static boolean isOcultaSolapaObsLeg(ISesion aSesion)
	throws BaseException {
		try {
			return ValorParametro.findByCodigoParametro(
					"OCULTAR_SOL_OBS_LEG", aSesion).getBoolean();
		} catch(Exception e) {
			return false;
		}
	}	

	public static boolean isOcultaSolapaControlAcceso(ISesion aSesion)
	throws BaseException {
		try {
			return ValorParametro.findByCodigoParametro(
					"OCULTAR_SOL_CONT_ACCESO", aSesion).getBoolean();
		} catch (Exception e) {
			return false;
		}
	}
	
	public static boolean isOcultaSolapaPersonal(ISesion aSesion)
	throws BaseException {
		try {
			return ValorParametro.findByCodigoParametro(
					"OCULTAR_SOL_PERSONALES", aSesion).getBoolean();
		} catch (Exception e) {
			return false;
		}
	}
	
	public static boolean isOcultaSolapaDesarrollo(ISesion aSesion)
	throws BaseException {
		try {
			return ValorParametro.findByCodigoParametro(
					"OCULTAR_SOL_DESARROLLO", aSesion).getBoolean();
		} catch (Exception e) {
			return false;
		}
	}
	
	
	
	
	public static boolean isOcultaSolapaEmpresa(ISesion aSesion)
	throws BaseException {
		try {
			return ValorParametro.findByCodigoParametro(
					"OCULTAR_SOL_EMPRESA", aSesion).getBoolean();
		} catch (Exception e) {
			return false;
		}
	}
	
	public static boolean isOcultaSolapaSanciones(ISesion aSesion)
	throws BaseException {
		try {
			return ValorParametro.findByCodigoParametro(
					"OCULTAR_SOL_SANCIONES", aSesion).getBoolean();
		} catch (Exception e) {
			return false;
		}
	}
	
	public static boolean isOcultaSolapaServMed(ISesion aSesion)
	throws BaseException {
		try {
			return ValorParametro.findByCodigoParametro(
					"OCULTAR_SOL_SERV_MED", aSesion).getBoolean();
		} catch (Exception e) {
			return false;
		}
	}
	
	public static boolean isOcultaSolapaLegales(ISesion aSesion)
	throws BaseException {
		try {
			return ValorParametro.findByCodigoParametro(
					"OCULTAR_SOLAPA_LEG", aSesion).getBoolean();
		} catch (Exception e) {
			return false;
		}
	}
	
	
	
	public static boolean isOcultaSolapaEvaluaciones(ISesion aSesion)
	throws BaseException {
		try {
			return ValorParametro.findByCodigoParametro(
					"OCULTAR_SOL_EVALUACIONES", aSesion).getBoolean();
		} catch (Exception e) {
			return false;
		}
	}
	
	
	
	
	

	private void inicializar(MapDatos mapaDatos) throws BaseException {
		IDataSet dataset = this.getDataSetInitLegajos();
		IDataSet dsOtrosDatos = getDataSetOtrosDatos();
		cargarRegistro(dataset);
		cargarOtrosDatosLeg(dsOtrosDatos);
		writeCliente(dataset);
		writeCliente(dsOtrosDatos);
	}

	private void cargarRegistro(IDataSet dataset) throws BaseException {
		dataset.append();
		dataset.fieldValue("ocultar_solapa_tarjetas", isOcultaSolapaTarjetas(this.getSesion()));
		dataset.fieldValue("ocultar_solapa_con_acc", isOcultaSolapaControlAcceso(this.getSesion()));
		dataset.fieldValue("ocultar_solapa_personal", isOcultaSolapaPersonal(this.getSesion()));
		dataset.fieldValue("ocultar_solapa_empresa", isOcultaSolapaEmpresa(this.getSesion()));
		dataset.fieldValue("ocultar_solapa_sanciones", isOcultaSolapaSanciones(this.getSesion()));
		dataset.fieldValue("ocultar_solapa_servmed", isOcultaSolapaServMed(this.getSesion()));
		dataset.fieldValue("ocultar_solapa_eval", isOcultaSolapaEvaluaciones(this.getSesion()));
		dataset.fieldValue("ocultar_solapa_legales", isOcultaSolapaLegales(this.getSesion()));
		dataset.fieldValue("ocultar_solapa_desarrollo", isOcultaSolapaDesarrollo(this.getSesion()));
		dataset.fieldValue("ocultar_solapa_observaciones", isOcultaSolapaObsLeg(this.getSesion()));
	}
	

}
