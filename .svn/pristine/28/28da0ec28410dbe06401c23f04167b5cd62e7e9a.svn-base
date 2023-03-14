package com.srn.erp.sueldos.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

import com.srn.erp.cip.bm.Rota;
import com.srn.erp.general.bm.ClasificadorEntidad;
import com.srn.erp.general.bm.ValorClasificadorEntidad;
import com.srn.erp.rrhh.bm.FiltroLegCab;
import com.srn.erp.rrhh.bm.FiltroValLegCab;
import com.srn.erp.rrhh.op.TraerLeyendasRepEval;
import com.srn.erp.sueldos.bm.Legajo;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Servicios.ServicioPoolBD;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.applicarionServer.bm.Seguridad.AltaFuncEspSeg;
import framework.applicarionServer.bm.Seguridad.Usuario;
import framework.request.bl.PoolBD.IPoolBD;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.ObjetoObservado;

public class DBLegajo extends DBObjetoPersistente {

	public static final String OID_LEGAJO = "oid_legajo";
	public static final String NRO_LEGAJO = "nro_legajo";
	public static final String APELLIDO = "apellido";
	public static final String NOMBRE = "nombre";
	public static final String ACTIVO = "activo";

	public static final String OID_CLASIF_01 = "oid_clasif_01";
	public static final String OID_CLASIF_02 = "oid_clasif_02";
	public static final String OID_CLASIF_03 = "oid_clasif_03";
	public static final String OID_CLASIF_04 = "oid_clasif_04";
	public static final String OID_CLASIF_05 = "oid_clasif_05";
	public static final String OID_CLASIF_06 = "oid_clasif_06";
	public static final String OID_CLASIF_07 = "oid_clasif_07";
	public static final String OID_CLASIF_08 = "oid_clasif_08";
	public static final String OID_CLASIF_09 = "oid_clasif_09";
	public static final String OID_CLASIF_10 = "oid_clasif_10";
	public static final String OID_CLASIF_11 = "oid_clasif_11";
	public static final String OID_CLASIF_12 = "oid_clasif_12";
	public static final String OID_CLASIF_13 = "oid_clasif_13";
	public static final String OID_CLASIF_14 = "oid_clasif_14";
	public static final String OID_CLASIF_15 = "oid_clasif_15";
	public static final String OID_CLASIF_16 = "oid_clasif_16";
	public static final String OID_CLASIF_17 = "oid_clasif_17";
	public static final String OID_CLASIF_18 = "oid_clasif_18";
	public static final String OID_CLASIF_19 = "oid_clasif_19";
	public static final String OID_CLASIF_20 = "oid_clasif_20";
	public static final String FEC_INGRESO = "fec_ingreso";
	public static final String FEC_RETIRO = "fec_retiro";
	public static final String ID_IDENTIFICACION = "id_identificacion";
	public static final String OID_GRUPO_PUERTA_ING = "oid_grupo_pue_ing";
	public static final String OID_GRUPO_PUERTA_EGR = "oid_grupo_pue_egr";
	public static final String OID_ESTADO = "oid_estado";
	public static final String OID_PERM_SEMANAL = "oid_perm_semanal";
	
	public static final String ACT_ANTI_PASS_BACK = "act_anti_pass_back";
	public static final String FEC_ULT_PASO = "fec_ult_paso";
	public static final String HOR_ULT_PASO = "hora_ult_paso";
	public static final String SENTIDO_PASO = "sentido_paso";
	
	public static final String IGNORAR_PROX_ANTI_PASS_BACK = "ignorar_prox_apb";
	public static final String CIRCUITO_CACHEO = "circuito_cacheo";
	public static final String OID_ZONA_ACTUAL = "oid_zona_actual";
	
	public static final String LIB_ING_AL_PREDIO = "lib_ing_al_predio";
	public static final String PROHIBIR_ACCESO =  "prohibir_acceso";
	
	public static final String CUIL = "cuil";
	public static final String SEXO = "sexo";
	public static final String DIRECCION = "direccion";
	public static final String OID_ESTADO_CIVIL = "oid_estado_civil";
	public static final String FEC_NAC = "fec_nac";
	public static final String OID_TIPO_DOCUMENTO = "oid_tipo_documento";
	public static final String NRO_DOCUMENTO = "nro_documento";
	public static final String TEL_PARTICULAR = "tel_particular";
	public static final String TEL_CELULAR = "tel_celular";
	public static final String OID_CLASE_SIND = "oid_clase_sind";
	public static final String FEC_ANT_RECO = "fec_ant_reco";
	public static final String OID_MOT_EGRESO = "oid_mot_egreso";
	public static final String FEC_VENC_PROT = "fec_venc_prot";
	public static final String FEC_ING_UTE = "fec_ing_ute";	
	
	public static final String OID_GRADO_LEG = "oid_grado_leg";
	public static final String OID_EST_DESA = "oid_est_desa";
	
	public static final String SEGUI_LEGALES = "segui_legales";
	public static final String SEGUI_CARTAS_DOCU = "segui_cartas_docu";
	public static final String OID_TAREA_DESEMP = "oid_tarea_desemp";
	
	public static final int SELECT_BY_CONDICIONES = 100;
	public static final int SELECT_BY_IDENTIFICACION = 101;
	public static final int SELECT_BY_LEG_ACT_CON_IDENTIF = 102;
	public static final int SELECT_BY_LEGAJO_EN_PREDIO = 103;
	public static final int SELECT_BY_CONS_EVAL = 104;
	public static final int SELECT_BY_LEG_EMP_SEC_PUE_EST = 105;
	public static final int SELECT_BY_SEGUI_LEGALES = 106;
	public static final int SELECT_BY_LEG_CON_PLANIF_ROTAS_ENT_FECHA = 107;
	
	

	public DBLegajo() {
	}

	protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_LEGAJO = 1;
		final int NRO_LEGAJO = 2;
		final int APELLIDO = 3;
		final int NOMBRE = 4;
		final int ACTIVO = 5;

		final int OID_CLASIF_01 = 6;
		final int OID_CLASIF_02 = 7;
		final int OID_CLASIF_03 = 8;
		final int OID_CLASIF_04 = 9;
		final int OID_CLASIF_05 = 10;
		final int OID_CLASIF_06 = 11;
		final int OID_CLASIF_07 = 12;
		final int OID_CLASIF_08 = 13;
		final int OID_CLASIF_09 = 14;
		final int OID_CLASIF_10 = 15;
		final int OID_CLASIF_11 = 16;
		final int OID_CLASIF_12 = 17;
		final int OID_CLASIF_13 = 18;
		final int OID_CLASIF_14 = 19;
		final int OID_CLASIF_15 = 20;
		final int OID_CLASIF_16 = 21;
		final int OID_CLASIF_17 = 22;
		final int OID_CLASIF_18 = 23;
		final int OID_CLASIF_19 = 24;
		final int OID_CLASIF_20 = 25;

		final int FEC_INGRESO = 26;
		final int FEC_RETIRO = 27;
		final int ID_IDENTIFICACION = 28;
		final int OID_GRUPO_PUERTA_ING = 29;
		final int OID_GRUPO_PUERTA_EGR = 30;
		final int OID_ESTADO = 31;
		final int OID_PERM_SEM = 32;
		
		final int ACT_ANTI_PASS_BACK = 33;
		final int FEC_ULT_PASO = 34;
		final int HOR_ULT_PASO = 35;
		final int SENTIDO_PASO = 36;
		
		final int IGNORAR_PROX_ANTI_PASS_BACK = 37;
		final int CIRCUITO_CACHEO = 38;
		
		final int OID_ZONA_ACTUAL = 39;
		
		final int LIB_ING_AL_PREDIO = 40;
		
		final int PROHIBIR_ACCESO = 41;
		
		final int CUIL = 42;
		final int SEXO = 43;
		final int DIRECCION = 44;
		final int OID_ESTADO_CIVIL = 45;
		final int FEC_NAC = 46;
		final int OID_TIPO_DOCUMENTO = 47;
		final int NRO_DOCUMENTO = 48;
		final int TEL_PARTICULAR = 49;
		final int TEL_CELULAR = 50;
		final int OID_CLASE_SIND = 51;
		final int FEC_ANT_RECO = 52;
		final int OID_MOT_EGRESO = 53;
		final int FEC_VENC_PROT = 54;
		final int FEC_ING_UTE = 55;
		final int OID_EST_DESA = 56;
		
		final int OID_GRADO_LEG = 57;
		
		final int SEGUI_LEGALES = 58;
		
		final int SEGUI_CARTAS_DOCU = 59;
		
		final int OID_TAREA_DESEMP = 60;

		Legajo pers = (Legajo) objetoPersistente;

		StringBuffer sqlInsert = new StringBuffer();
		sqlInsert
				.append(" insert into suLegajo "
						+ " ( "
						+ "OID_LEGAJO,"
						+ "NRO_LEGAJO,"
						+ "APELLIDO,"
						+ "NOMBRE,"
						+ "ACTIVO,"
						+ "OID_CLASIF_01,"
						+ "OID_CLASIF_02,"
						+ "OID_CLASIF_03,"
						+ "OID_CLASIF_04,"
						+ "OID_CLASIF_05,"
						+ "OID_CLASIF_06,"
						+ "OID_CLASIF_07,"
						+ "OID_CLASIF_08,"
						+ "OID_CLASIF_09,"
						+ "OID_CLASIF_10,"
						+ "OID_CLASIF_11,"
						+ "OID_CLASIF_12,"
						+ "OID_CLASIF_13,"
						+ "OID_CLASIF_14,"
						+ "OID_CLASIF_15,"
						+ "OID_CLASIF_16,"
						+ "OID_CLASIF_17,"
						+ "OID_CLASIF_18,"
						+ "OID_CLASIF_19,"
						+ "OID_CLASIF_20,FEC_INGRESO,FEC_RETIRO,ID_IDENTIFICACION,OID_GRUPO_PUE_ING,OID_GRUPO_PUE_EGR,OID_ESTADO,OID_PERM_SEMANAL, "+
						"act_anti_pass_back,"+
						"fec_ult_paso,"+
						"hora_ult_paso,"+
						"sentido_paso,ignorar_prox_apb , circuito_cacheo , oid_zona_actual , lib_ing_al_predio , prohibir_acceso"+
						",cuil,sexo,direccion,oid_estado_civil,fec_nac,oid_tipo_documento,nro_documento,tel_particular,tel_celular,"+
						"oid_clase_sind,fec_ant_reco,oid_mot_egreso,fec_venc_prot,fec_ing_ute , oid_grado_leg , oid_est_desa , segui_legales , segui_cartas_docu , oid_tarea_desemp "+
						") "+
						" values " + "(" + "?,"+ "?,"+"?,"+ "?,"+ "?,"+ "?,"+ "?,"+ "?," + "?,"+ "?," + "?,"+ "?," + "?,"+ "?," + "?,"+ "?," + "?," + "?," + "?," + "?," + "?," + "?,"+ "?," + "?," + "?,"
						+ "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?,"+ "?," + "?," + "?,"
						+ "?,"+ "?," + "?,"+ "?,"+ "?,"+ "?,"+ "?,"+ "?,"+ "?,"+ "?,"+ "?,"+ "?,"+ "?,"+ "?,"+ "?,"+ "?,"+ "?," + "?) ");

		PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
		qInsert.setInt(OID_LEGAJO, pers.getOID());
		qInsert.setString(NRO_LEGAJO, pers.getNro_legajo());
		
		if (pers.getApellido()!=null)
			qInsert.setString(APELLIDO, pers.getApellido());
		else
			qInsert.setNull(APELLIDO, Types.VARCHAR);
		
		if (pers.getNombre()!=null)
			qInsert.setString(NOMBRE, pers.getNombre());
		else
			qInsert.setNull(NOMBRE, Types.VARCHAR);
		
		qInsert.setBoolean(ACTIVO, pers.isActivo().booleanValue());

		qInsert.setInt(OID_CLASIF_01, pers.getOidValorClasif(new Integer(1)).intValue());
		qInsert.setInt(OID_CLASIF_02, pers.getOidValorClasif(new Integer(2)).intValue());
		qInsert.setInt(OID_CLASIF_03, pers.getOidValorClasif(new Integer(3)).intValue());
		qInsert.setInt(OID_CLASIF_04, pers.getOidValorClasif(new Integer(4)).intValue());
		qInsert.setInt(OID_CLASIF_05, pers.getOidValorClasif(new Integer(5)).intValue());
		qInsert.setInt(OID_CLASIF_06, pers.getOidValorClasif(new Integer(6)).intValue());
		qInsert.setInt(OID_CLASIF_07, pers.getOidValorClasif(new Integer(7)).intValue());
		qInsert.setInt(OID_CLASIF_08, pers.getOidValorClasif(new Integer(8)).intValue());
		qInsert.setInt(OID_CLASIF_09, pers.getOidValorClasif(new Integer(9)).intValue());
		qInsert.setInt(OID_CLASIF_10, pers.getOidValorClasif(new Integer(10)).intValue());
		qInsert.setInt(OID_CLASIF_11, pers.getOidValorClasif(new Integer(11)).intValue());
		qInsert.setInt(OID_CLASIF_12, pers.getOidValorClasif(new Integer(12)).intValue());
		qInsert.setInt(OID_CLASIF_13, pers.getOidValorClasif(new Integer(13)).intValue());
		qInsert.setInt(OID_CLASIF_14, pers.getOidValorClasif(new Integer(14)).intValue());
		qInsert.setInt(OID_CLASIF_15, pers.getOidValorClasif(new Integer(15)).intValue());
		qInsert.setInt(OID_CLASIF_16, pers.getOidValorClasif(new Integer(16)).intValue());
		qInsert.setInt(OID_CLASIF_17, pers.getOidValorClasif(new Integer(17)).intValue());
		qInsert.setInt(OID_CLASIF_18, pers.getOidValorClasif(new Integer(18)).intValue());
		qInsert.setInt(OID_CLASIF_19, pers.getOidValorClasif(new Integer(19)).intValue());
		qInsert.setInt(OID_CLASIF_20, pers.getOidValorClasif(new Integer(20)).intValue());

		if (pers.getFecIngreso() != null)
			qInsert.setDate(FEC_INGRESO, new java.sql.Date(pers.getFecIngreso().getTime()));
		else
			qInsert.setNull(FEC_INGRESO, java.sql.Types.DATE);

		if (pers.getFecRetiro() != null)
			qInsert.setDate(FEC_RETIRO, new java.sql.Date(pers.getFecRetiro().getTime()));
		else
			qInsert.setNull(FEC_RETIRO, java.sql.Types.DATE);

		if (pers.getIDIdentificacion() != null)
			qInsert.setInt(ID_IDENTIFICACION, pers.getIDIdentificacion().intValue());
		else
			qInsert.setNull(ID_IDENTIFICACION, java.sql.Types.INTEGER);

		if (pers.getGrupoPuertaIngreso() != null)
			qInsert.setInt(OID_GRUPO_PUERTA_ING, pers.getGrupoPuertaIngreso().getOID());
		else
			qInsert.setNull(OID_GRUPO_PUERTA_ING, java.sql.Types.INTEGER);

		if (pers.getGrupoPuertaEgreso() != null)
			qInsert.setInt(OID_GRUPO_PUERTA_EGR, pers.getGrupoPuertaEgreso().getOID());
		else
			qInsert.setNull(OID_GRUPO_PUERTA_EGR, java.sql.Types.INTEGER);

		if (pers.getEstadoCIP() != null)
			qInsert.setInt(OID_ESTADO, pers.getEstadoCIP().getOID());
		else
			qInsert.setNull(OID_ESTADO, java.sql.Types.INTEGER);

		if (pers.getPermisoSemanal() != null)
			qInsert.setInt(OID_PERM_SEM, pers.getPermisoSemanal().getOID());
		else
			qInsert.setNull(OID_PERM_SEM, java.sql.Types.INTEGER);
		
		if (pers.isActivarAntiPassBack() != null)
			qInsert.setBoolean(ACT_ANTI_PASS_BACK, pers.isActivarAntiPassBack());
		else
			qInsert.setNull(ACT_ANTI_PASS_BACK, java.sql.Types.INTEGER);

		if (pers.getFecUltPaso() != null)
			qInsert.setTimestamp(FEC_ULT_PASO, new java.sql.Timestamp(pers.getFecUltPaso().getTime()));
		else
			qInsert.setNull(FEC_ULT_PASO, Types.TIMESTAMP);
		
		if (pers.getHoraUltPaso() != null)
			qInsert.setString(HOR_ULT_PASO, pers.getHoraUltPaso());
		else
			qInsert.setNull(HOR_ULT_PASO, java.sql.Types.VARCHAR);
		
		if (pers.getSentidoPaso() != null)
			qInsert.setString(SENTIDO_PASO, pers.getSentidoPaso());
		else
			qInsert.setNull(SENTIDO_PASO, java.sql.Types.VARCHAR);
		
		if (pers.isIgnorarProxAntiPassBack() != null)
			qInsert.setBoolean(IGNORAR_PROX_ANTI_PASS_BACK, pers.isIgnorarProxAntiPassBack());
		else
			qInsert.setNull(IGNORAR_PROX_ANTI_PASS_BACK, java.sql.Types.INTEGER);		
		
		if (pers.isCircuitoCacheo() != null)
			qInsert.setBoolean(CIRCUITO_CACHEO, pers.isCircuitoCacheo());
		else
			qInsert.setNull(CIRCUITO_CACHEO, java.sql.Types.INTEGER);		
		
		if (pers.getZonaActual()!=null)
			qInsert.setInt(OID_ZONA_ACTUAL, pers.getZonaActual().getOID());
		else
			qInsert.setNull(OID_ZONA_ACTUAL, java.sql.Types.INTEGER);
		qInsert.setBoolean(LIB_ING_AL_PREDIO, pers.isLiberarIngAlPredio());
		qInsert.setBoolean(PROHIBIR_ACCESO , pers.isProhibirAcceso());
		
		if (pers.getCUIT()!=null)
			qInsert.setString(CUIL, pers.getCUIT());
		else
			qInsert.setNull(CUIL, Types.VARCHAR);
		
		if (pers.getSEXO()!=null)
			qInsert.setString(SEXO, pers.getSEXO());
		else
			qInsert.setNull(SEXO, Types.VARCHAR);
		
		if (pers.getDireccion()!=null)
			qInsert.setString(DIRECCION, pers.getDireccion());
		else
			qInsert.setNull(DIRECCION, Types.VARCHAR);
		
		if (pers.getEstadoCivil()!=null)
			qInsert.setInt(OID_ESTADO_CIVIL, pers.getEstadoCivil().getOID());
		else
			qInsert.setNull(OID_ESTADO_CIVIL, Types.INTEGER);
		
		if (pers.getFecNacimiento()!=null)
			qInsert.setDate(FEC_NAC, new java.sql.Date(pers.getFecNacimiento().getTime()));
		else
			qInsert.setNull(FEC_NAC, Types.DATE);
		
		if (pers.getTipoDocumento()!=null)
			qInsert.setInt(OID_TIPO_DOCUMENTO, pers.getTipoDocumento().getOID());
		else
			qInsert.setNull(OID_TIPO_DOCUMENTO, Types.INTEGER);
		
		if (pers.getNroDocumento()!=null)
			qInsert.setString(NRO_DOCUMENTO, pers.getNroDocumento());
		else
			qInsert.setNull(NRO_DOCUMENTO, Types.VARCHAR);
		
		if (pers.getTelefono()!=null)
			qInsert.setString(TEL_PARTICULAR, pers.getTelefono());
		else
			qInsert.setNull(TEL_PARTICULAR, Types.VARCHAR);

		if (pers.getTelefonoCelular()!=null)
			qInsert.setString(TEL_CELULAR, pers.getTelefonoCelular());
		else
			qInsert.setNull(TEL_CELULAR, Types.VARCHAR);
		
		if (pers.getClaseSindicato()!=null)
			qInsert.setInt(OID_CLASE_SIND, pers.getClaseSindicato().getOID());
		else
			qInsert.setNull(OID_CLASE_SIND, Types.INTEGER);

		if (pers.getFecAntReconocimiento()!=null)
			qInsert.setDate(FEC_ANT_RECO, new java.sql.Date(pers.getFecAntReconocimiento().getTime()));
		else
			qInsert.setNull(FEC_ANT_RECO, Types.DATE);
		
		if (pers.getMotivoEgresoEmp()!=null)
			qInsert.setInt(OID_MOT_EGRESO, pers.getMotivoEgresoEmp().getOID());
		else
			qInsert.setNull(OID_MOT_EGRESO, Types.INTEGER);
		
		if (pers.getFecVencProteccion()!=null)
			qInsert.setDate(FEC_VENC_PROT, new java.sql.Date(pers.getFecVencProteccion().getTime()));
		else
			qInsert.setNull(FEC_VENC_PROT, Types.DATE);
		
		if (pers.getIngresoUTE()!=null)
			qInsert.setDate(FEC_ING_UTE, new java.sql.Date(pers.getIngresoUTE().getTime()));
		else
			qInsert.setNull(FEC_ING_UTE, Types.DATE);
		
		if (pers.getGradoLegajo()!=null)
			qInsert.setInt(OID_GRADO_LEG, pers.getGradoLegajo().getOID());
		else
			qInsert.setNull(OID_GRADO_LEG, Types.INTEGER);
		
		if (pers.getEstadoDesarrollo()!=null)
			qInsert.setInt(OID_EST_DESA, pers.getEstadoDesarrollo().getOID());
		else
			qInsert.setNull(OID_EST_DESA, Types.INTEGER);
		
		if (pers.isSeguiLegales()!=null)
			qInsert.setBoolean(SEGUI_LEGALES, pers.isSeguiLegales().booleanValue());
		else
			qInsert.setNull(SEGUI_LEGALES, Types.BOOLEAN);		
		
		if (pers.isSeguiCartasDocu()!=null)
			qInsert.setBoolean(SEGUI_CARTAS_DOCU, pers.isSeguiCartasDocu().booleanValue());
		else
			qInsert.setNull(SEGUI_CARTAS_DOCU, Types.BOOLEAN);		
		
		if (pers.getTareaDesempeneada()!=null)
			qInsert.setInt(OID_TAREA_DESEMP, pers.getTareaDesempeneada().getOID());
		else
			qInsert.setNull(OID_TAREA_DESEMP, Types.INTEGER);		
		
		qInsert.executeUpdate();
		qInsert.close();
	}

	protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int NRO_LEGAJO = 1;
		final int APELLIDO = 2;
		final int NOMBRE = 3;
		final int ACTIVO = 4;

		final int OID_CLASIF_01 = 5;
		final int OID_CLASIF_02 = 6;
		final int OID_CLASIF_03 = 7;
		final int OID_CLASIF_04 = 8;
		final int OID_CLASIF_05 = 9;
		final int OID_CLASIF_06 = 10;
		final int OID_CLASIF_07 = 11;
		final int OID_CLASIF_08 = 12;
		final int OID_CLASIF_09 = 13;
		final int OID_CLASIF_10 = 14;
		final int OID_CLASIF_11 = 15;
		final int OID_CLASIF_12 = 16;
		final int OID_CLASIF_13 = 17;
		final int OID_CLASIF_14 = 18;
		final int OID_CLASIF_15 = 19;
		final int OID_CLASIF_16 = 20;
		final int OID_CLASIF_17 = 21;
		final int OID_CLASIF_18 = 22;
		final int OID_CLASIF_19 = 23;
		final int OID_CLASIF_20 = 24;

		final int FEC_INGRESO = 25;
		final int FEC_RETIRO = 26;

		final int ID_IDENTIFICACION = 27;
		final int OID_GRUPO_PUE_ING = 28;
		final int OID_GRUPO_PUERTA_EGR = 29;
		final int OID_ESTADO = 30;
		final int OID_PERM_SEM = 31;
		
		final int ACT_ANTI_PASS_BACK = 32;
		final int FEC_ULT_PASO = 33;
		final int HOR_ULT_PASO = 34;
		final int SENTIDO_PASO = 35;
		
		final int IGNORAR_PROX_ANTI_PASS_BACK = 36;
		final int CIRCUITO_CACHEO = 37;
		
		final int OID_ZONA_ACTUAL = 38;
		final int LIB_ING_AL_PREDIO = 39;
		final int PROHIBIR_ACCESO = 40;
		
		final int CUIL = 41;
		final int SEXO = 42;
		final int DIRECCION = 43;
		final int OID_ESTADO_CIVIL = 44;
		final int FEC_NAC = 45;
		final int OID_TIPO_DOCUMENTO = 46;
		final int NRO_DOCUMENTO = 47;
		final int TEL_PARTICULAR = 48;
		final int TEL_CELULAR = 49;
		final int OID_CLASE_SIND = 50;
		final int FEC_ANT_RECO = 51;
		final int OID_MOT_EGRESO = 52;
		final int FEC_VENC_PROT = 53;
		final int FEC_ING_UTE = 54;
		
		final int OID_GRADO_LEG = 55;
		final int OID_EST_DESA = 56;
		final int SEGUI_LEGALES = 57;
		final int SEGUI_CARTAS_DOCU = 58;
		final int OID_TAREA_DESEMP = 59;
		final int OID_LEGAJO = 60;

		Legajo pers = (Legajo) objetoPersistente;

		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append(" update suLegajo set " + "nro_legajo=?" + ",apellido=?" + ",nombre=?" + ",activo=?," + "oid_clasif_01 = ?,"
				+ "oid_clasif_02 = ?," + "oid_clasif_03 = ?," + "oid_clasif_04 = ?," + "oid_clasif_05 = ?," + "oid_clasif_06 = ?,"
				+ "oid_clasif_07 = ?," + "oid_clasif_08 = ?," + "oid_clasif_09 = ?," + "oid_clasif_10 = ?," + "oid_clasif_11 = ?,"
				+ "oid_clasif_12 = ?," + "oid_clasif_13 = ?," + "oid_clasif_14 = ?," + "oid_clasif_15 = ?," + "oid_clasif_16 = ?,"
				+ "oid_clasif_17 = ?," + "oid_clasif_18 = ?," + "oid_clasif_19 = ?," + "oid_clasif_20 = ?, " + "fec_ingreso = ?, "
				+ "fec_retiro = ?, " + "id_identificacion = ?, " + "oid_grupo_pue_ing = ?, " + "oid_grupo_pue_egr = ?, "
				+ "oid_estado = ?, " + "oid_perm_semanal = ? , act_anti_pass_back = ? , fec_ult_paso=? , hora_ult_paso=?, sentido_paso =? , ignorar_prox_apb = ? , circuito_cacheo = ? , oid_zona_actual = ? , lib_ing_al_predio = ? , prohibir_acceso = ?, " +
				" cuil = ? ,sexo = ? ,direccion = ?,oid_estado_civil = ?,fec_nac = ?,oid_tipo_documento = ?,nro_documento = ?,tel_particular = ?,"+
				" tel_celular = ?,"+
				" oid_clase_sind=?,fec_ant_reco=?,oid_mot_egreso=?,fec_venc_prot=?,fec_ing_ute=? , oid_grado_leg = ? , oid_est_desa = ? , segui_legales = ? , segui_cartas_docu = ? , oid_tarea_desemp = ? "+
				" where " + " oid_legajo=? ");

		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_LEGAJO, pers.getOID());
		qUpdate.setString(NRO_LEGAJO, pers.getNro_legajo());
		
		if (pers.getApellido()!=null)
			qUpdate.setString(APELLIDO, pers.getApellido());
		else
			qUpdate.setNull(APELLIDO, Types.VARCHAR);
		
		if (pers.getNombre()!=null)
			qUpdate.setString(NOMBRE, pers.getNombre());
		else
			qUpdate.setNull(NOMBRE, Types.VARCHAR);
		
		
		qUpdate.setBoolean(ACTIVO, pers.isActivo().booleanValue());

		qUpdate.setInt(OID_CLASIF_01, pers.getOidValorClasif(new Integer(1)).intValue());
		qUpdate.setInt(OID_CLASIF_02, pers.getOidValorClasif(new Integer(2)).intValue());
		qUpdate.setInt(OID_CLASIF_03, pers.getOidValorClasif(new Integer(3)).intValue());
		qUpdate.setInt(OID_CLASIF_04, pers.getOidValorClasif(new Integer(4)).intValue());
		qUpdate.setInt(OID_CLASIF_05, pers.getOidValorClasif(new Integer(5)).intValue());
		qUpdate.setInt(OID_CLASIF_06, pers.getOidValorClasif(new Integer(6)).intValue());
		qUpdate.setInt(OID_CLASIF_07, pers.getOidValorClasif(new Integer(7)).intValue());
		qUpdate.setInt(OID_CLASIF_08, pers.getOidValorClasif(new Integer(8)).intValue());
		qUpdate.setInt(OID_CLASIF_09, pers.getOidValorClasif(new Integer(9)).intValue());
		qUpdate.setInt(OID_CLASIF_10, pers.getOidValorClasif(new Integer(10)).intValue());
		qUpdate.setInt(OID_CLASIF_11, pers.getOidValorClasif(new Integer(11)).intValue());
		qUpdate.setInt(OID_CLASIF_12, pers.getOidValorClasif(new Integer(12)).intValue());
		qUpdate.setInt(OID_CLASIF_13, pers.getOidValorClasif(new Integer(13)).intValue());
		qUpdate.setInt(OID_CLASIF_14, pers.getOidValorClasif(new Integer(14)).intValue());
		qUpdate.setInt(OID_CLASIF_15, pers.getOidValorClasif(new Integer(15)).intValue());
		qUpdate.setInt(OID_CLASIF_16, pers.getOidValorClasif(new Integer(16)).intValue());
		qUpdate.setInt(OID_CLASIF_17, pers.getOidValorClasif(new Integer(17)).intValue());
		qUpdate.setInt(OID_CLASIF_18, pers.getOidValorClasif(new Integer(18)).intValue());
		qUpdate.setInt(OID_CLASIF_19, pers.getOidValorClasif(new Integer(19)).intValue());
		qUpdate.setInt(OID_CLASIF_20, pers.getOidValorClasif(new Integer(20)).intValue());

		if (pers.getFecIngreso() != null)
			qUpdate.setDate(FEC_INGRESO, new java.sql.Date(pers.getFecIngreso().getTime()));
		else
			qUpdate.setNull(FEC_INGRESO, java.sql.Types.DATE);

		if (pers.getFecRetiro() != null)
			qUpdate.setDate(FEC_RETIRO, new java.sql.Date(pers.getFecRetiro().getTime()));
		else
			qUpdate.setNull(FEC_RETIRO, java.sql.Types.DATE);

		if (pers.getIDIdentificacion() != null)
			qUpdate.setInt(ID_IDENTIFICACION, pers.getIDIdentificacion().intValue());
		else
			qUpdate.setNull(ID_IDENTIFICACION, java.sql.Types.INTEGER);

		if (pers.getGrupoPuertaIngreso() != null)
			qUpdate.setInt(OID_GRUPO_PUE_ING, pers.getGrupoPuertaIngreso().getOID());
		else
			qUpdate.setNull(OID_GRUPO_PUE_ING, java.sql.Types.INTEGER);

		if (pers.getGrupoPuertaEgreso() != null)
			qUpdate.setInt(OID_GRUPO_PUERTA_EGR, pers.getGrupoPuertaEgreso().getOID());
		else
			qUpdate.setNull(OID_GRUPO_PUERTA_EGR, java.sql.Types.INTEGER);

		if (pers.getEstadoCIP() != null)
			qUpdate.setInt(OID_ESTADO, pers.getEstadoCIP().getOID());
		else
			qUpdate.setNull(OID_ESTADO, java.sql.Types.INTEGER);

		if (pers.getPermisoSemanal() != null)
			qUpdate.setInt(OID_PERM_SEM, pers.getPermisoSemanal().getOID());
		else
			qUpdate.setNull(OID_PERM_SEM, java.sql.Types.INTEGER);
		
		if (pers.isActivarAntiPassBack() != null)
			qUpdate.setBoolean(ACT_ANTI_PASS_BACK, pers.isActivarAntiPassBack());
		else
			qUpdate.setNull(ACT_ANTI_PASS_BACK, java.sql.Types.INTEGER);

		if (pers.getFecUltPaso() != null)
			qUpdate.setTimestamp(FEC_ULT_PASO, new java.sql.Timestamp(pers.getFecUltPaso().getTime()));
		else
			qUpdate.setNull(FEC_ULT_PASO, Types.TIMESTAMP);
		
		if (pers.getHoraUltPaso() != null)
			qUpdate.setString(HOR_ULT_PASO, pers.getHoraUltPaso());
		else
			qUpdate.setNull(HOR_ULT_PASO, java.sql.Types.VARCHAR);
		
		if (pers.getSentidoPaso() != null)
			qUpdate.setString(SENTIDO_PASO, pers.getSentidoPaso());
		else
			qUpdate.setNull(SENTIDO_PASO, java.sql.Types.VARCHAR);
		
		if (pers.isIgnorarProxAntiPassBack() != null)
			qUpdate.setBoolean(IGNORAR_PROX_ANTI_PASS_BACK, pers.isIgnorarProxAntiPassBack());
		else
			qUpdate.setNull(IGNORAR_PROX_ANTI_PASS_BACK, java.sql.Types.INTEGER);
		
		if (pers.isCircuitoCacheo() != null)
			qUpdate.setBoolean(CIRCUITO_CACHEO, pers.isCircuitoCacheo());
		else
			qUpdate.setNull(CIRCUITO_CACHEO, java.sql.Types.INTEGER);		
		
		if (pers.getZonaActual()!=null)
			qUpdate.setInt(OID_ZONA_ACTUAL, pers.getZonaActual().getOID());
		else
			qUpdate.setNull(OID_ZONA_ACTUAL, java.sql.Types.INTEGER);
		qUpdate.setBoolean(LIB_ING_AL_PREDIO, pers.isLiberarIngAlPredio());
		qUpdate.setBoolean(PROHIBIR_ACCESO , pers.isProhibirAcceso());
		
		if (pers.getCUIT()!=null)
			qUpdate.setString(CUIL, pers.getCUIT());
		else
			qUpdate.setNull(CUIL, Types.VARCHAR);
		
		if (pers.getSEXO()!=null)
			qUpdate.setString(SEXO, pers.getSEXO());
		else
			qUpdate.setNull(SEXO, Types.VARCHAR);
		
		if (pers.getDireccion()!=null)
			qUpdate.setString(DIRECCION, pers.getDireccion());
		else
			qUpdate.setNull(DIRECCION, Types.VARCHAR);
		
		if (pers.getEstadoCivil()!=null)
			qUpdate.setInt(OID_ESTADO_CIVIL, pers.getEstadoCivil().getOID());
		else
			qUpdate.setNull(OID_ESTADO_CIVIL, Types.INTEGER);
		
		if (pers.getFecNacimiento()!=null)
			qUpdate.setDate(FEC_NAC, new java.sql.Date(pers.getFecNacimiento().getTime()));
		else
			qUpdate.setNull(FEC_NAC, Types.DATE);
		
		if (pers.getTipoDocumento()!=null)
			qUpdate.setInt(OID_TIPO_DOCUMENTO, pers.getTipoDocumento().getOID());
		else
			qUpdate.setNull(OID_TIPO_DOCUMENTO, Types.INTEGER);
		
		if (pers.getNroDocumento()!=null)
			qUpdate.setString(NRO_DOCUMENTO, pers.getNroDocumento());
		else
			qUpdate.setNull(NRO_DOCUMENTO, Types.VARCHAR);
		
		if (pers.getTelefono()!=null)
			qUpdate.setString(TEL_PARTICULAR, pers.getTelefono());
		else
			qUpdate.setNull(TEL_PARTICULAR, Types.VARCHAR);

		if (pers.getTelefonoCelular()!=null)
			qUpdate.setString(TEL_CELULAR, pers.getTelefonoCelular());
		else
			qUpdate.setNull(TEL_CELULAR, Types.VARCHAR);
		
		if (pers.getClaseSindicato()!=null)
			qUpdate.setInt(OID_CLASE_SIND, pers.getClaseSindicato().getOID());
		else
			qUpdate.setNull(OID_CLASE_SIND, Types.INTEGER);

		if (pers.getFecAntReconocimiento()!=null)
			qUpdate.setDate(FEC_ANT_RECO, new java.sql.Date(pers.getFecAntReconocimiento().getTime()));
		else
			qUpdate.setNull(FEC_ANT_RECO, Types.DATE);
		
		if (pers.getMotivoEgresoEmp()!=null)
			qUpdate.setInt(OID_MOT_EGRESO, pers.getMotivoEgresoEmp().getOID());
		else
			qUpdate.setNull(OID_MOT_EGRESO, Types.INTEGER);
		
		if (pers.getFecVencProteccion()!=null)
			qUpdate.setDate(FEC_VENC_PROT, new java.sql.Date(pers.getFecVencProteccion().getTime()));
		else
			qUpdate.setNull(FEC_VENC_PROT, Types.DATE);
		
		if (pers.getIngresoUTE()!=null)
			qUpdate.setDate(FEC_ING_UTE, new java.sql.Date(pers.getIngresoUTE().getTime()));
		else
			qUpdate.setNull(FEC_ING_UTE, Types.DATE);
		
		if (pers.getGradoLegajo()!=null)
			qUpdate.setInt(OID_GRADO_LEG, pers.getGradoLegajo().getOID());
		else
			qUpdate.setNull(OID_GRADO_LEG, Types.INTEGER);
		
		if (pers.getEstadoDesarrollo()!=null)
			qUpdate.setInt(OID_EST_DESA, pers.getEstadoDesarrollo().getOID());
		else
			qUpdate.setNull(OID_EST_DESA, Types.INTEGER);
		
		
		if (pers.isSeguiLegales()!=null)
			qUpdate.setBoolean(SEGUI_LEGALES, pers.isSeguiLegales().booleanValue());
		else
			qUpdate.setNull(SEGUI_LEGALES, Types.BOOLEAN);		
		
		if (pers.isSeguiCartasDocu()!=null)
			qUpdate.setBoolean(SEGUI_CARTAS_DOCU, pers.isSeguiCartasDocu().booleanValue());
		else
			qUpdate.setNull(SEGUI_CARTAS_DOCU, Types.BOOLEAN);		
		
		if (pers.getTareaDesempeneada()!=null)
			qUpdate.setInt(OID_TAREA_DESEMP, pers.getTareaDesempeneada().getOID());
		else
			qUpdate.setNull(OID_TAREA_DESEMP, Types.INTEGER);		
		
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_LEGAJO = 1;
		Legajo pers = (Legajo) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update suLegajo " + " set activo=0 " + " where " + " oid_legajo=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_LEGAJO, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_LEGAJO = 1;
		Legajo pers = (Legajo) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update suLegajo " + " set activo=1 " + " where " + " oid_legajo=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_LEGAJO, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	public PreparedStatement prepararSelect(int aSelect, Object aCondiciones) throws BaseException, SQLException {
		PreparedStatement ps = null;
		switch (aSelect) {
		case IDBObjetoPersistente.SELECT_BY_OID: {
			ps = this.selectByOID(aCondiciones);
			break;
		}
		case IDBObjetoPersistente.SELECT_BY_CODIGO: {
			ps = this.selectByCodigo(aCondiciones);
			break;
		}
		case IDBObjetoPersistente.SELECT_ALL_HELP: {
			ps = this.selectAllHelp(aCondiciones);
			break;
		}
		case SELECT_BY_CONDICIONES: {
			ps = this.selectByCondiciones(aCondiciones);
			break;
		}
		case SELECT_ALL: {
			ps = this.selectALL(aCondiciones);
			break;
		}
		case SELECT_BY_IDENTIFICACION: {
			ps = this.selectByIdentificacion(aCondiciones);
			break;
		}
		case SELECT_BY_LEG_ACT_CON_IDENTIF: {
			ps = this.selectByIdentifLegAct(aCondiciones);
			break;
		}
		case SELECT_BY_LEGAJO_EN_PREDIO: {
			ps = this.selectByLegajoEnPredio(aCondiciones);
			break;
		}
		case SELECT_BY_CONS_EVAL: {
			ps = this.selectByConsEval(aCondiciones);
			break;
		}
		case SELECT_BY_LEG_EMP_SEC_PUE_EST: {
			ps = this.selectByLegEmpSecpueEst(aCondiciones);
			break;
		}
		case SELECT_BY_SEGUI_LEGALES: {
			ps = this.selectBySeguiLegales(aCondiciones);
			break;			
		}
		case SELECT_BY_LEG_CON_PLANIF_ROTAS_ENT_FECHA: {
			ps = this.selectByLegConPlanifRotasEntreFecha(aCondiciones);
			break;			
		}
		}
		return ps;
	}
	
	
	
	private PreparedStatement selectBySeguiLegales(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  suLegajo ");
		textSQL.append(" WHERE (segui_legales = 1 OR segui_cartas_docu = 1) and activo = 1 ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}	

	private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

		final int OID_LEGAJO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  suLegajo ");
		textSQL.append(" WHERE oid_legajo = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		int oid = ((Integer) aCondiciones).intValue();
		querySelect.setInt(OID_LEGAJO, oid);
		return querySelect;
	}

	private PreparedStatement selectAll(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  suLegajo ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}

	private PreparedStatement selectByIdentifLegAct(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  suLegajo ");
		textSQL.append(" WHERE id_identificacion is not null and activo=1 ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}
	
	private PreparedStatement selectByLegajoEnPredio(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT a.* FROM  suLegajo a , cipZona b ");
		textSQL.append(" WHERE a.oid_zona_actual = b.oid_zona and a.activo=1 and b.es_externa = 0 ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}

	
	private PreparedStatement selectByLegEmpSecpueEst(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  suLegajo a ");
		textSQL.append(" WHERE activo = 1 ");
		
		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		List listaLegajos = (List) condiciones.get("LEGAJOS");
		List listaEmpresas = (List) condiciones.get("EMPRESAS");
		List listaSectores= (List) condiciones.get("SECTORES");
		List listaPuestos = (List) condiciones.get("PUESTOS");
		List listaEstados = (List) condiciones.get("ESTADOS");
		
	    if (listaLegajos.size()!=0) {
	    	StringBuffer condINLegajos = new StringBuffer("");
	    	Iterator iterLega = listaLegajos.iterator();
	    	while (iterLega.hasNext()) {
	    		Legajo legajo = (Legajo) iterLega.next();
	    		if (condINLegajos.length()==0)
	    			condINLegajos.append(legajo.getOIDInteger());
	    		else
	    			condINLegajos.append(","+legajo.getOIDInteger());
	    	}
	    	textSQL.append(" and oid_legajo in ("+condINLegajos.toString()+") ");
	    }
		
	    // Traer Empresas
	    ClasificadorEntidad clasifEmpresa = TraerLeyendasRepEval.getClasificadorEmpresa(this.getSesion());
	    if (listaEmpresas.size()!=0) {
	    	StringBuffer condEmpresas = new StringBuffer("");	    	
	    	int i=0;
	    	Iterator iterEmp = listaEmpresas.iterator();
	    	while (iterEmp.hasNext()) {
	    		ValorClasificadorEntidad valClasifEntEmp = (ValorClasificadorEntidad) iterEmp.next();
	    		if (i==0)
	    			condEmpresas.append(valClasifEntEmp.getOIDInteger());
	    		else
	    			condEmpresas.append(","+valClasifEntEmp.getOIDInteger());
	    		++i;
	    	}
	    	
	    	if (condEmpresas.length()!=0)
	    		textSQL.append(" and "+clasifEmpresa.getCampoFisico()+" in ("+condEmpresas.toString()+") ");
	    }
	    
	    // Traer Sectores
	    ClasificadorEntidad clasifSector= TraerLeyendasRepEval.getClasificadorSector(this.getSesion());
	    if (listaSectores.size()!=0) {
	    	StringBuffer condSectores = new StringBuffer("");
	    	int i=0;
	    	Iterator iterSec = listaSectores.iterator();
	    	while (iterSec.hasNext()) {
	    		ValorClasificadorEntidad valClasifEntSec = (ValorClasificadorEntidad) iterSec.next();
	    		if (i==0)
	    			condSectores.append(valClasifEntSec.getOIDInteger());
	    		else
	    			condSectores.append(","+valClasifEntSec.getOIDInteger());
	    		++i;
	    	}
	    	if (condSectores.length()!=0)
	    		textSQL.append(" and "+clasifSector.getCampoFisico()+" in ("+condSectores.toString()+") ");
	    }
	    
	    // Traer Puestos
	    ClasificadorEntidad clasifPuesto = TraerLeyendasRepEval.getClasificadorPuesto(this.getSesion());
	    if (listaPuestos.size()!=0) {
	    	StringBuffer condPuestos = new StringBuffer("");
	    	int i=0;
	    	Iterator iterPue = listaPuestos.iterator();
	    	while (iterPue.hasNext()) {
	    		ValorClasificadorEntidad valClasifEntPue = (ValorClasificadorEntidad) iterPue.next();
	    		if (i==0)
	    			condPuestos.append(valClasifEntPue.getOIDInteger());
	    		else
	    			condPuestos.append(","+valClasifEntPue.getOIDInteger());
	    		++i;
	    	}
	    	if (condPuestos.length()!=0)
	    		textSQL.append(" and "+clasifPuesto.getCampoFisico()+" in ("+condPuestos.toString()+") ");
	    }
	    
	    // Traer Activos
	    ClasificadorEntidad clasifEstado = TraerLeyendasRepEval.getClasificadorEstado(this.getSesion());
	    if (listaEstados.size()!=0) {
	    	StringBuffer condEstados = new StringBuffer("");
	    	int i=0;
	    	Iterator iterEst = listaEstados.iterator();
	    	while (iterEst.hasNext()) {
	    		ValorClasificadorEntidad valClasifEntEst = (ValorClasificadorEntidad) iterEst.next();
	    		if (i==0)
	    			condEstados.append(valClasifEntEst.getOIDInteger());
	    		else
	    			condEstados.append(","+valClasifEntEst.getOIDInteger());
	    		++i;
	    	}
	    	if (condEstados.length()!=0)
	    		textSQL.append(" and "+clasifEstado.getCampoFisico()+" in ("+condEstados.toString()+") ");
	    }
	    
		
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
	    
		return querySelect;
	}
	
	
	
	private PreparedStatement selectByConsEval(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  suLegajo a ");
		textSQL.append(" WHERE activo = 1 ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		List listaLegajos = (List) condiciones.get("LEGAJOS");
		List listaEmpresas = (List) condiciones.get("EMPRESAS");
		List listaSectores= (List) condiciones.get("SECTORES");
		List listaPuestos = (List) condiciones.get("PUESTOS");
		List listaEstados = (List) condiciones.get("ESTADOS");
		
		Iterator iterLegajos = listaLegajos.iterator();
		while (iterLegajos.hasNext()) {
			Legajo legajo = (Legajo) iterLegajos.next();
		}
		
		Iterator iterEmpresas = listaEmpresas.iterator();
		while (iterEmpresas.hasNext()
				) {
			
		}
		
		return querySelect;
	}
	
	private PreparedStatement selectByIdentificacion(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  suLegajo ");
		textSQL.append(" WHERE id_identificacion = ? and activo=1 ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		Integer identif = (Integer) aCondiciones;
		querySelect.setInt(1, identif);
		return querySelect;
	}

	private PreparedStatement selectByCondiciones(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  suLegajo ");
		textSQL.append(" WHERE 1=1 ");

		HashTableDatos condiciones = (HashTableDatos) aCondiciones;

		// Filtrar por legajo
		List legajos = (List) condiciones.get("LEGAJOS");
		StringBuffer condOIDLegajo = new StringBuffer("");
		if ((legajos != null) && (legajos.size() > 0)) {
			Iterator iterLegajos = legajos.iterator();
			while (iterLegajos.hasNext()) {
				Integer oidLegajo = (Integer) iterLegajos.next();
				if (condOIDLegajo.length() == 0)
					condOIDLegajo.append(oidLegajo.toString());
				else
					condOIDLegajo.append("," + oidLegajo.toString());
			}
			textSQL.append(" and oid_legajo in (" + condOIDLegajo.toString() + ") ");
		}

		// Filtrar por Valores de clasificador
		HashTableDatos hashTableClasif = new HashTableDatos();
		List listaValClasif = (List) condiciones.get("VALORES_CLASIF");
		if (listaValClasif != null) {

			Iterator iterValClasif = listaValClasif.iterator();
			while (iterValClasif.hasNext()) {
				ValorClasificadorEntidad valClasifEnt = (ValorClasificadorEntidad) iterValClasif.next();
				HashTableDatos htValClasif = (HashTableDatos) hashTableClasif.get(valClasifEnt.getClasificador_entidad().getOIDInteger());
				if (htValClasif == null) {
					htValClasif = new HashTableDatos();
					hashTableClasif.put(valClasifEnt.getClasificador_entidad().getOIDInteger(), htValClasif);
				}
				htValClasif.put(valClasifEnt.getOIDInteger(), valClasifEnt);
			}

			Iterator iterGrupoValClasif = hashTableClasif.values().iterator();
			while (iterGrupoValClasif.hasNext()) {
				HashTableDatos datos = (HashTableDatos) iterGrupoValClasif.next();
				Iterator iterValClasif1 = datos.values().iterator();
				int j = 1;
				while (iterValClasif1.hasNext()) {
					ValorClasificadorEntidad valClasifEnt = (ValorClasificadorEntidad) iterValClasif1.next();
					if (j == 1)
						textSQL.append(" and (");
					else
						textSQL.append(" or ");
					textSQL.append(valClasifEnt.getClasificador_entidad().getCampoFisico() + "=" + valClasifEnt.getOIDInteger());
					++j;

				}
				if (j > 1)
					textSQL.append(" ) ");
			}

		}

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}

	private PreparedStatement selectALL(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  suLegajo ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}

	private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

		final int CODIGO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  suLegajo ");
		textSQL.append(" WHERE nro_legajo = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		String codigo = (String) aCondiciones;
		querySelect.setString(CODIGO, codigo);
		return querySelect;
	}

	private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();

		String caracter = "||";
		if (this.getSesion().getServicios().getServPoolBD(ServicioPoolBD.FILE_POOL_BD).getPoolBD().getTipoBD().equals(IPoolBD.MSSQLServer))
			caracter = "+";
			
		textSQL.append("SELECT oid_legajo oid,nro_legajo codigo, LTRIM(apellido"+caracter+"' ')"+caracter+" nombre descripcion ,activo ");
		textSQL.append(" from suLegajo where 1=1 ");
		
		if (AltaFuncEspSeg.isFuncEspSegHabilitada(20026,"",false, this.getSesion()))
			aplicarSeguridadLegajosAVisu(textSQL);
			
		
		

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}
	
	private void aplicarSeguridadLegajosAVisu(StringBuffer textSQL1) throws BaseException {
		
		
		StringBuffer textSQL =  new StringBuffer();
		
		try {
		
		Usuario usuario = Usuario.findByOidProxy(this.getSesion().getLogin().getUsuario().getOIDInteger(), this.getSesion());
		
		ClasificadorEntidad clasifSector= TraerLeyendasRepEval.getClasificadorSector(this.getSesion());
		ClasificadorEntidad clasifEmpresa = TraerLeyendasRepEval.getClasificadorEmpresa(this.getSesion());
		ClasificadorEntidad clasifEstado = TraerLeyendasRepEval.getClasificadorEstado(this.getSesion());
		ClasificadorEntidad clasifPuesto = TraerLeyendasRepEval.getClasificadorPuesto(this.getSesion());
		
		
		if (FiltroLegCab.getFiltrosLegajosCabByUSuario(this.getSesion(), usuario).size()>0)
			textSQL.append(" and ( ");
		
		int secu = 0;
		Iterator iterFiltroLegCab = FiltroLegCab.getFiltrosLegajosCabByUSuario(this.getSesion(), usuario).iterator();
		while (iterFiltroLegCab.hasNext()) {
			FiltroLegCab filtro = (FiltroLegCab) iterFiltroLegCab.next();
			if (!filtro.isAplic_busq_leg()) continue;
			++secu;
			
			if (secu==1)
				textSQL.append(" (1=1 ");
			else
				textSQL.append(" or (1=1 ");
			
			List listaValEmp = filtro.getValoresFiltroEmpresa();
			if (listaValEmp.size()>0) {
				String armarCondIN = "";
				Iterator iterValEmp = listaValEmp.iterator();
				while (iterValEmp.hasNext()) {
					FiltroValLegCab filtroValLegCab = (FiltroValLegCab) iterValEmp.next();
					if (armarCondIN.length()==0)
						armarCondIN = filtroValLegCab.getOid_valor().toString();
					else
						armarCondIN = armarCondIN + ","+filtroValLegCab.getOid_valor().toString();
				}
				armarCondIN = " and oid_legajo in (select oid_legajo from suLegajo where "+clasifEmpresa.getCampoFisico()+" IN ("+armarCondIN+")) ";
				textSQL.append(armarCondIN);
			}
			List listaValSec = filtro.getValoresFiltroSector();
			if (listaValSec.size()>0) {
				String armarCondIN = "";
				Iterator iterValSec = listaValSec.iterator();
				while (iterValSec.hasNext()) {
					FiltroValLegCab filtroValLegCab = (FiltroValLegCab) iterValSec.next();
					if (armarCondIN.length()==0)
						armarCondIN = filtroValLegCab.getOid_valor().toString();
					else
						armarCondIN = armarCondIN + ","+filtroValLegCab.getOid_valor().toString();
				}
				armarCondIN = " and oid_legajo in (select oid_legajo from suLegajo where "+clasifSector.getCampoFisico()+" IN ("+armarCondIN+")) ";
				textSQL.append(armarCondIN);
			}		
			
			
			List listaValTareas = filtro.getValoresFiltroTareas();
			if (listaValTareas.size()>0) {
				String armarCondIN = "";
				Iterator iterValTareas = listaValTareas.iterator();
				while (iterValTareas.hasNext()) {
					FiltroValLegCab filtroValLegCab = (FiltroValLegCab) iterValTareas.next();
					if (armarCondIN.length()==0)
						armarCondIN = filtroValLegCab.getOid_valor().toString();
					else
						armarCondIN = armarCondIN + ","+filtroValLegCab.getOid_valor().toString();
				}
				armarCondIN = " and oid_legajo in (select oid_legajo from suLegajo where oid_tarea_desemp IN ("+armarCondIN+")) ";
				textSQL.append(armarCondIN);
			}		
			
			List listaValSindicatos = filtro.getValoresFiltroSindicatos();
			if (listaValSindicatos.size()>0) {
				String armarCondIN = "";
				Iterator iterValSindicatos = listaValSindicatos.iterator();
				while (iterValSindicatos.hasNext()) {
					FiltroValLegCab filtroValLegCab = (FiltroValLegCab) iterValSindicatos.next();
					if (armarCondIN.length()==0)
						armarCondIN = filtroValLegCab.getOid_valor().toString();
					else
						armarCondIN = armarCondIN + ","+filtroValLegCab.getOid_valor().toString();
				}
				armarCondIN = " and oid_legajo in (select oid_legajo from suLegajo where oid_clase_sind IN ("+armarCondIN+")) ";
				textSQL.append(armarCondIN);
			}		
			
			List listaValPue = filtro.getValoresFiltroPuesto();
			if (listaValPue.size()>0) {
				String armarCondIN = "";
				Iterator iterValPue = listaValPue.iterator();
				while (iterValPue.hasNext()) {
					FiltroValLegCab filtroValLegCab = (FiltroValLegCab) iterValPue.next();
					if (armarCondIN.length()==0)
						armarCondIN = filtroValLegCab.getOid_valor().toString();
					else
						armarCondIN = armarCondIN + ","+filtroValLegCab.getOid_valor().toString();
				}
				armarCondIN = " and oid_legajo in (select oid_legajo from suLegajo where "+clasifPuesto.getCampoFisico()+" IN ("+armarCondIN+")) ";
				textSQL.append(armarCondIN);
			}
			
			List listaValEst = filtro.getValoresFiltroEstado();
			if (listaValEst.size()>0) {
				String armarCondIN = "";
				Iterator iterValEst = listaValEst.iterator();
				while (iterValEst.hasNext()) {
					FiltroValLegCab filtroValLegCab = (FiltroValLegCab) iterValEst.next();
					if (armarCondIN.length()==0)
						armarCondIN = filtroValLegCab.getOid_valor().toString();
					else
						armarCondIN = armarCondIN + ","+filtroValLegCab.getOid_valor().toString();
				}
				armarCondIN = " and oid_legajo in (select oid_legajo from suLegajo where "+clasifEstado.getCampoFisico()+" IN ("+armarCondIN+")) ";
				textSQL.append(armarCondIN);
			}
			
			textSQL.append(" ) ");
			
		}
		
		if (FiltroLegCab.getFiltrosLegajosCabByUSuario(this.getSesion(), usuario).size()>0) {
			if (secu==0)
				textSQL.append(" 1=-1) ");
			else
				textSQL.append(" ) ");
		textSQL1.append(textSQL);
		}
		} catch(Exception e) {
			
		}
		
		
	}

	public static List getLegajosByCondiciones(List listaLegajos, List valoresClasificadores, ISesion aSesion) throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		if (listaLegajos != null)
			condiciones.put("LEGAJOS", listaLegajos);
		if (valoresClasificadores != null)
			condiciones.put("VALORES_CLASIF", valoresClasificadores);
		return (List) ObjetoLogico.getObjects(Legajo.NICKNAME, DBLegajo.SELECT_BY_CONDICIONES, condiciones, new ListObserver(), aSesion);
	}

	public static List getAllLegajos(ISesion aSesion) throws BaseException {
		return (List) ObjetoLogico.getObjects(Legajo.NICKNAME, IDBObjetoPersistente.SELECT_ALL, null, new ListObserver(), aSesion);
	}

	public static Legajo getLegajoByIdentificacion(Integer identificacion, ISesion aSesion) throws BaseException {
		return (Legajo) ObjetoLogico
				.getObjects(Legajo.NICKNAME, DBLegajo.SELECT_BY_IDENTIFICACION, identificacion, new ObjetoObservado(), aSesion);
	}
	
	public static List getAllLegajosActivosConIdentif(ISesion aSesion) throws BaseException {
		return (List) ObjetoLogico.getObjects(Legajo.NICKNAME, DBLegajo.SELECT_BY_LEG_ACT_CON_IDENTIF, null, new ListObserver(), aSesion);
	}
	
	public static List getLegajosEnPredio(ISesion aSesion) throws BaseException {
		return (List) ObjetoLogico.getObjects(Legajo.NICKNAME, DBLegajo.SELECT_BY_LEGAJO_EN_PREDIO, null, new ListObserver(), aSesion);
	}
	
	public static List getLegajosEnSeguiLegales(ISesion aSesion) throws BaseException {
		return (List) ObjetoLogico.getObjects(Legajo.NICKNAME, DBLegajo.SELECT_BY_SEGUI_LEGALES, null, new ListObserver(), aSesion);
	}	
	
	public static List getLegajosEvalRRHH(
			  List legajos,
			  List empresas,
			  List sectores,
			  List puestos,
			  List estados,
	          ISesion aSesion) throws BaseException {
		  HashTableDatos condiciones = new HashTableDatos();
		  condiciones.put("LEGAJOS", legajos);
		  condiciones.put("EMPRESAS", empresas);
		  condiciones.put("SECTORES", sectores);
		  condiciones.put("PUESTOS", puestos);
		  condiciones.put("ESTADOS", estados);
		  return (List) ObjetoLogico.getObjects(Legajo.NICKNAME,
	             DBLegajo.SELECT_BY_LEG_EMP_SEC_PUE_EST,
	             condiciones,
	             new ListObserver(),
	             aSesion);
	}
	
	private PreparedStatement selectByLegConPlanifRotasEntreFecha(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		
		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		java.util.Date fechaDesde = (java.util.Date) condiciones.get("FECHA_DESDE");
		java.util.Date fechaHasta = (java.util.Date) condiciones.get("FECHA_HASTA");
		FiltroLegCab filtro = (FiltroLegCab)  condiciones.get(FiltroLegCab.NICKNAME);
		
		ClasificadorEntidad clasifEmpresa = TraerLeyendasRepEval.getClasificadorEmpresa(this.getSesion());
		ClasificadorEntidad clasifEstado = TraerLeyendasRepEval.getClasificadorEstado(this.getSesion());
		ClasificadorEntidad clasifSector = TraerLeyendasRepEval.getClasificadorSector(this.getSesion());
		ClasificadorEntidad clasifPuesto = TraerLeyendasRepEval.getClasificadorPuesto(this.getSesion());				
		
		Rota rota = (Rota) condiciones.get(Rota.NICKNAME);		
		
		textSQL.append("select * from suLegajo where  oid_legajo in ( ");
		
		textSQL.append("SELECT oid_legajo FROM  cipLegRotFec ");
		textSQL.append(" WHERE fecha  >= ? and fecha<=? and activo=1 and oid_rota="+rota.getOIDInteger());
		
		if (rota!=null)
			textSQL.append(" and oid_rota="+rota.getOIDInteger()+" ");
		
		List listaValEmp = filtro.getValoresFiltroEmpresa();
		if (listaValEmp.size()>0) {
			String armarCondIN = "";
			Iterator iterValEmp = listaValEmp.iterator();
			while (iterValEmp.hasNext()) {
				FiltroValLegCab filtroValLegCab = (FiltroValLegCab) iterValEmp.next();
				if (armarCondIN.length()==0)
					armarCondIN = filtroValLegCab.getOid_valor().toString();
				else
					armarCondIN = armarCondIN + ","+filtroValLegCab.getOid_valor().toString();
			}
			armarCondIN = " and oid_legajo in (select oid_legajo from suLegajo where "+clasifEmpresa.getCampoFisico()+" IN ("+armarCondIN+")) ";
			textSQL.append(armarCondIN);
		}
		
		if (condiciones.containsKey("JUEGOS")) {
			List listaJuegos = new ArrayList();
			String juegos = (String) condiciones.get("JUEGOS");
			StringTokenizer st =
				new StringTokenizer(juegos,",");
			int i=1;
			while (st.hasMoreTokens()) {
			    String valor = st.nextToken();
			    listaJuegos.add(valor);
			}
		
			String armarCondIN = " and oid_legajo in (select b.oid_legajo from rhGradosLeg a , sulegajo b where a.oid_grado_leg = b.oid_grado_leg ";
			armarCondIN = armarCondIN + " and (";
			
			boolean firstTime = true;
			Iterator iterJuegos = 
				listaJuegos.iterator();
			while (iterJuegos.hasNext()) {
				String juego = (String) iterJuegos.next();
				if (firstTime) {
					armarCondIN = armarCondIN + "descripcion like '%"+juego+"%'";
					firstTime = false;
				} else {
					armarCondIN = armarCondIN + " or descripcion like '%"+juego+"%'";
				}
			}
			armarCondIN = armarCondIN + " )";
			armarCondIN = armarCondIN + " ) ";
			textSQL.append(armarCondIN);			
			
		}		
		
		List listaValSec = filtro.getValoresFiltroSector();
		if (listaValSec.size()>0) {
			String armarCondIN = "";
			Iterator iterValSec = listaValSec.iterator();
			while (iterValSec.hasNext()) {
				FiltroValLegCab filtroValLegCab = (FiltroValLegCab) iterValSec.next();
				if (armarCondIN.length()==0)
					armarCondIN = filtroValLegCab.getOid_valor().toString();
				else
					armarCondIN = armarCondIN + ","+filtroValLegCab.getOid_valor().toString();
			}
			armarCondIN = " and oid_legajo in (select oid_legajo from suLegajo where "+clasifSector.getCampoFisico()+" IN ("+armarCondIN+")) ";
			textSQL.append(armarCondIN);
		}		
		
		
		List listaValTareas = filtro.getValoresFiltroTareas();
		if (listaValTareas.size()>0) {
			String armarCondIN = "";
			Iterator iterValTareas = listaValTareas.iterator();
			while (iterValTareas.hasNext()) {
				FiltroValLegCab filtroValLegCab = (FiltroValLegCab) iterValTareas.next();
				if (armarCondIN.length()==0)
					armarCondIN = filtroValLegCab.getOid_valor().toString();
				else
					armarCondIN = armarCondIN + ","+filtroValLegCab.getOid_valor().toString();
			}
			armarCondIN = " and oid_legajo in (select oid_legajo from suLegajo where oid_tarea_desemp IN ("+armarCondIN+")) ";
			textSQL.append(armarCondIN);
		}		
		
		List listaValSindicatos = filtro.getValoresFiltroSindicatos();
		if (listaValSindicatos.size()>0) {
			String armarCondIN = "";
			Iterator iterValSindicatos = listaValSindicatos.iterator();
			while (iterValSindicatos.hasNext()) {
				FiltroValLegCab filtroValLegCab = (FiltroValLegCab) iterValSindicatos.next();
				if (armarCondIN.length()==0)
					armarCondIN = filtroValLegCab.getOid_valor().toString();
				else
					armarCondIN = armarCondIN + ","+filtroValLegCab.getOid_valor().toString();
			}
			armarCondIN = " and oid_legajo in (select oid_legajo from suLegajo where oid_clase_sind IN ("+armarCondIN+")) ";
			textSQL.append(armarCondIN);
		}		
		
		List listaValPue = filtro.getValoresFiltroPuesto();
		if (listaValPue.size()>0) {
			String armarCondIN = "";
			Iterator iterValPue = listaValPue.iterator();
			while (iterValPue.hasNext()) {
				FiltroValLegCab filtroValLegCab = (FiltroValLegCab) iterValPue.next();
				if (armarCondIN.length()==0)
					armarCondIN = filtroValLegCab.getOid_valor().toString();
				else
					armarCondIN = armarCondIN + ","+filtroValLegCab.getOid_valor().toString();
			}
			armarCondIN = " and oid_legajo in (select oid_legajo from suLegajo where "+clasifPuesto.getCampoFisico()+" IN ("+armarCondIN+")) ";
			textSQL.append(armarCondIN);
		}
		
		List listaValEst = filtro.getValoresFiltroEstado();
		if (listaValEst.size()>0) {
			String armarCondIN = "";
			Iterator iterValEst = listaValEst.iterator();
			while (iterValEst.hasNext()) {
				FiltroValLegCab filtroValLegCab = (FiltroValLegCab) iterValEst.next();
				if (armarCondIN.length()==0)
					armarCondIN = filtroValLegCab.getOid_valor().toString();
				else
					armarCondIN = armarCondIN + ","+filtroValLegCab.getOid_valor().toString();
			}
			armarCondIN = " and oid_legajo in (select oid_legajo from suLegajo where "+clasifEstado.getCampoFisico()+" IN ("+armarCondIN+")) ";
			textSQL.append(armarCondIN);
		}		
		
		
		textSQL.append(" ) ");
		
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());

		querySelect.setDate(1, new java.sql.Date(fechaDesde.getTime()));
		querySelect.setDate(2, new java.sql.Date(fechaHasta.getTime()));
		
		
		return querySelect;
	}
	
	public static List getLegConsPlanifRotasEntFechas(
			java.util.Date fechaDesde,
			java.util.Date fechaHasta,
			Rota rota,
			FiltroLegCab filtro,
			String juegos,
			ISesion aSesion) throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put("FECHA_DESDE", fechaDesde);
		condiciones.put("FECHA_HASTA", fechaHasta);
		
		if (filtro!=null)
			condiciones.put(FiltroLegCab.NICKNAME, filtro);
		
		if (rota!=null)
			condiciones.put(Rota.NICKNAME, rota);
		
		if ((juegos!=null) && (juegos.trim().length()!=0))
			condiciones.put("JUEGOS", juegos);
		
		return (List) ObjetoLogico.getObjects(
				Legajo.NICKNAME, 
				DBLegajo.SELECT_BY_LEG_CON_PLANIF_ROTAS_ENT_FECHA, 
				condiciones, 
				new ListObserver(),
				aSesion);
	}	

}
