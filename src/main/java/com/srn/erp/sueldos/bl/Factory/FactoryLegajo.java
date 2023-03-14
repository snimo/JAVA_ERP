package com.srn.erp.sueldos.bl.Factory;

import com.srn.erp.cip.bm.EstadoCIP;
import com.srn.erp.cip.bm.GrupoPuerta;
import com.srn.erp.cip.bm.PermisoSemanalCIP;
import com.srn.erp.cip.bm.ZonaCIP;
import com.srn.erp.rrhh.bm.ClaseSindicato;
import com.srn.erp.rrhh.bm.EstadoDesarrollo;
import com.srn.erp.rrhh.bm.GradoLegajo;
import com.srn.erp.rrhh.bm.MotivoEgresoEmp;
import com.srn.erp.rrhh.bm.TareaDesempeneada;
import com.srn.erp.sueldos.bm.Legajo;
import com.srn.erp.sueldos.da.DBLegajo;
import com.srn.erp.ventas.bm.EstadoCivil;
import com.srn.erp.ventas.bm.TipoDocumento;
import com.srn.erp.ventas.da.DBSujeto;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryLegajo extends FactoryObjetoLogico {

	public FactoryLegajo() {
	}

	public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
		Legajo legajo = (Legajo) objLog;
		legajo.setOID(db.getInteger(DBLegajo.OID_LEGAJO));
		legajo.setNro_legajo(db.getString(DBLegajo.NRO_LEGAJO));
		legajo.setApellido(db.getString(DBLegajo.APELLIDO));
		legajo.setNombre(db.getString(DBLegajo.NOMBRE));
		legajo.setActivo(db.getBoolean(DBLegajo.ACTIVO));
		legajo.setFecIngreso(db.getDate(DBLegajo.FEC_INGRESO));
		legajo.setFecRetiro(db.getDate(DBLegajo.FEC_RETIRO));
		legajo.setIDIdentificacion(db.getInteger(DBLegajo.ID_IDENTIFICACION));
		legajo.setGrupoPuertaIngreso(GrupoPuerta.findByOidProxy(db.getInteger(DBLegajo.OID_GRUPO_PUERTA_ING), this.getSesion()));
		legajo.setGrupoPuertaEgreso(GrupoPuerta.findByOidProxy(db.getInteger(DBLegajo.OID_GRUPO_PUERTA_EGR), this.getSesion()));
		legajo.setEstadoCIP(EstadoCIP.findByOidProxy(db.getInteger(DBLegajo.OID_ESTADO), this.getSesion()));
		legajo.setPermisoSemanal(PermisoSemanalCIP.findByOidProxy(db.getInteger(DBLegajo.OID_PERM_SEMANAL), this.getSesion()));
		legajo.setZonaActual(ZonaCIP.findByOidProxy(db.getInteger(DBLegajo.OID_ZONA_ACTUAL), this.getSesion()));

		legajo.setActivarAntiPassBack(db.getBoolean(DBLegajo.ACT_ANTI_PASS_BACK));
		legajo.setFecUltPaso(db.getDateTime(DBLegajo.FEC_ULT_PASO));
		legajo.setHoraUltPaso(db.getString(DBLegajo.HOR_ULT_PASO));
		legajo.setSentidoPaso(db.getString(DBLegajo.SENTIDO_PASO));
		legajo.setIgnorarProxAntiPassBack(db.getBoolean(DBLegajo.IGNORAR_PROX_ANTI_PASS_BACK));
		legajo.setLibIngAlPredio(db.getBoolean(DBLegajo.LIB_ING_AL_PREDIO));
		legajo.setProhibirAcceso(db.getBoolean(DBLegajo.PROHIBIR_ACCESO));

		legajo.addOidValorClasif(new Integer(1), db.getInteger(DBSujeto.OID_CLASIF_01));
		legajo.addOidValorClasif(new Integer(2), db.getInteger(DBSujeto.OID_CLASIF_02));
		legajo.addOidValorClasif(new Integer(3), db.getInteger(DBSujeto.OID_CLASIF_03));
		legajo.addOidValorClasif(new Integer(4), db.getInteger(DBSujeto.OID_CLASIF_04));
		legajo.addOidValorClasif(new Integer(5), db.getInteger(DBSujeto.OID_CLASIF_05));
		legajo.addOidValorClasif(new Integer(6), db.getInteger(DBSujeto.OID_CLASIF_06));
		legajo.addOidValorClasif(new Integer(7), db.getInteger(DBSujeto.OID_CLASIF_07));
		legajo.addOidValorClasif(new Integer(8), db.getInteger(DBSujeto.OID_CLASIF_08));
		legajo.addOidValorClasif(new Integer(9), db.getInteger(DBSujeto.OID_CLASIF_09));
		legajo.addOidValorClasif(new Integer(10), db.getInteger(DBSujeto.OID_CLASIF_10));
		legajo.addOidValorClasif(new Integer(11), db.getInteger(DBSujeto.OID_CLASIF_11));
		legajo.addOidValorClasif(new Integer(12), db.getInteger(DBSujeto.OID_CLASIF_12));
		legajo.addOidValorClasif(new Integer(13), db.getInteger(DBSujeto.OID_CLASIF_13));
		legajo.addOidValorClasif(new Integer(14), db.getInteger(DBSujeto.OID_CLASIF_14));
		legajo.addOidValorClasif(new Integer(15), db.getInteger(DBSujeto.OID_CLASIF_15));
		legajo.addOidValorClasif(new Integer(16), db.getInteger(DBSujeto.OID_CLASIF_16));
		legajo.addOidValorClasif(new Integer(17), db.getInteger(DBSujeto.OID_CLASIF_17));
		legajo.addOidValorClasif(new Integer(18), db.getInteger(DBSujeto.OID_CLASIF_18));
		legajo.addOidValorClasif(new Integer(19), db.getInteger(DBSujeto.OID_CLASIF_19));
		legajo.addOidValorClasif(new Integer(20), db.getInteger(DBSujeto.OID_CLASIF_20));

		legajo.setCircuitoCacheo(db.getBoolean(DBLegajo.CIRCUITO_CACHEO));

		legajo.setCUIT(db.getString(DBLegajo.CUIL));
		legajo.setSexo(db.getString(DBLegajo.SEXO));
		legajo.setDireccion(db.getString(DBLegajo.DIRECCION));
		legajo.setEstadoCivil(EstadoCivil.findByOidProxy(db.getInteger(DBLegajo.OID_ESTADO_CIVIL), this.getSesion()));
		legajo.setFecNacimiento(db.getDate(DBLegajo.FEC_NAC));
		legajo.setTipoDocumento(TipoDocumento.findByOidProxy(db.getInteger(DBLegajo.OID_TIPO_DOCUMENTO), this.getSesion()));
		legajo.setNroDocumento(db.getString(DBLegajo.NRO_DOCUMENTO));
		legajo.setTelefono(db.getString(DBLegajo.TEL_PARTICULAR));
		legajo.setTelefonoCelular(db.getString(DBLegajo.TEL_CELULAR));
		legajo.setClaseSindicato(ClaseSindicato.findByOidProxy(db.getInteger(DBLegajo.OID_CLASE_SIND), this.getSesion()));
		legajo.setFecAntReconocimiento(db.getDate(DBLegajo.FEC_ANT_RECO));
		legajo.setMotivoEgresoEmp(MotivoEgresoEmp.findByOidProxy(db.getInteger(DBLegajo.OID_MOT_EGRESO), this.getSesion()));
		legajo.setFecVencProteccion(db.getDate(DBLegajo.FEC_VENC_PROT));
		legajo.setFecIngresoUTE(db.getDate(DBLegajo.FEC_ING_UTE));
		legajo.setGradoLegajo(GradoLegajo.findByOidProxy(db.getInteger(DBLegajo.OID_GRADO_LEG), this.getSesion()));
		legajo.setEstadoDesarrollo(EstadoDesarrollo.findByOidProxy(db.getInteger(DBLegajo.OID_EST_DESA), this.getSesion()));
		legajo.setSeguiLegales(db.getBoolean(DBLegajo.SEGUI_LEGALES));
		legajo.setSeguiCartasDocu(db.getBoolean(DBLegajo.SEGUI_CARTAS_DOCU));
		legajo.setTareaDempeneada(TareaDesempeneada.findByOidProxy(db.getInteger(DBLegajo.OID_TAREA_DESEMP), this.getSesion()));
		

	}
}
