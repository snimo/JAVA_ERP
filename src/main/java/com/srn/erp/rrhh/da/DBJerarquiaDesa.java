package com.srn.erp.rrhh.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import com.srn.erp.general.bm.ValorClasificadorEntidad;
import com.srn.erp.rrhh.bm.AccCronoDesa;
import com.srn.erp.rrhh.bm.JerarquiaDesa;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.ObjetoObservado;

public class DBJerarquiaDesa extends DBObjetoPersistente {

	public static final String OID_JERAR_DESA = "oid_jerar_desa";
	public static final String OID_ACCION_CRO = "oid_accion_cro";
	public static final String OID_VAL_CLASIF_EMP = "oid_val_clasif_emp";
	public static final String OID_VAL_CLASIF_SEC = "oid_val_clasif_sec";
	public static final String OID_VAL_CLASIF_PUE = "oid_val_clasif_pue";
	public static final String ACTIVO = "activo";
	public static final String ORDEN = "orden";
	public static final String CATEG_POSIBLE = "oid_categ_posible";
	public static final String CANT_ANIOS_PUESTO = "cant_anios_puesto";
	public static final String CANT_MESES_PUESTO =  "cant_meses_puesto";
	public static final String OID_RANKEAR =  "oid_rankear";
	public static final String PTOS_MIN_EVAL = "ptos_min_eval";
	public static final String CANT_MIN_JUEGOS_A = "cant_min_juegos_a";
	public static final String CANT_ANIOS_HC = "cant_anios_hc";
	public static final String CANT_MESES_HC = "cant_meses_hc";
	public static final String PTOS_MIN_CALIF_GEN = "ptos_min_calif_gen";
	public static final String ULT_MESES_EVAL_POT = "ult_meses_eval_pot";
	public static final String EVAL_PEND_SIN_EVAL = "eval_pend_sin_eval";
	public static final String EVAL_PEND_SIN_JUE = "eval_pend_sin_jue";
	public static final String EVAL_PEND_SIN_IRL = "eval_pend_sin_irl";
	public static final String ULT_MESES_IRL = "ult_meses_irl";
	public static final String EVAL_PEND_SIN_POT = "eval_pend_sin_pot";
	
	

	public static final int SELECT_BY_ACCION = 100;
	public static final int SELECT_EMPRESA_SECTOR_PUESTO = 101;

	public DBJerarquiaDesa() {
	}

	protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_JERAR_DESA = 1;
		final int OID_ACCION_CRO = 2;
		final int OID_VAL_CLASIF_EMP = 3;
		final int OID_VAL_CLASIF_SEC = 4;
		final int OID_VAL_CLASIF_PUE = 5;
		final int ACTIVO = 6;
		final int ORDEN = 7;
		final int OID_CATEG_POSIBLE = 8;
		final int CANT_ANIOS_PUESTO = 9;
		final int CANT_MESES_PUESTO = 10;
		final int OID_RANKEAR = 11;
		final int PTOS_MIN_EVAL = 12;
		final int CANT_MIN_JUEGOS_A = 13; 
		final int CANT_ANIOS_HC = 14;
		final int CANT_MESES_HC = 15;
		final int PTOS_MIN_CALIF_GEN = 16;
		final int ULT_MESES_EVAL_POT = 17;
		final int EVAL_PEND_SIN_EVAL = 18;
		final int EVAL_PEND_SIN_JUE = 19;		
		final int EVAL_PEND_SIN_IRL = 20;
		final int ULT_MESES_IRL = 21;
		final int EVAL_PEND_SIN_POT = 22;

		JerarquiaDesa pers = (JerarquiaDesa) objetoPersistente;

		StringBuffer sqlInsert = new StringBuffer();
		sqlInsert.append(" insert into rhJerarquiaDesa " + " ( " + "OID_JERAR_DESA," + "OID_ACCION_CRO," + "OID_VAL_CLASIF_EMP," + "OID_VAL_CLASIF_SEC," + "OID_VAL_CLASIF_PUE," + "ACTIVO , ORDEN , OID_CATEG_POSIBLE , CANT_ANIOS_PUESTO , CANT_MESES_PUESTO , OID_RANKEAR , PTOS_MIN_EVAL , CANT_MIN_JUEGOS_A,CANT_ANIOS_HC,CANT_MESES_HC,ptos_min_calif_gen,ULT_MESES_EVAL_POT,EVAL_PEND_SIN_EVAL,EVAL_PEND_SIN_JUE,eval_pend_sin_irl,ult_meses_irl,eval_pend_sin_pot) "
				+ " values " + "(" + "?," + "?,"+ "?,"+ "?," + "?,"+"?," + "?," + "?," + "?," + "?,"+ "?,"+ "?," + "? , ? ,? , ? , ?, ?,?, ? , ?, ?) ");

		PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
		qInsert.setInt(OID_JERAR_DESA, pers.getOID());
		qInsert.setInt(OID_ACCION_CRO, pers.getAccion().getOID());
		if (pers.getVal_clasif_empresa()!=null)
			qInsert.setInt(OID_VAL_CLASIF_EMP, pers.getVal_clasif_empresa().getOID());
		else
			qInsert.setNull(OID_VAL_CLASIF_EMP, Types.INTEGER);
		if (pers.getVal_clasif_sector()!=null)
			qInsert.setInt(OID_VAL_CLASIF_SEC, pers.getVal_clasif_sector().getOID());
		else
			qInsert.setNull(OID_VAL_CLASIF_SEC, Types.INTEGER);
		if (pers.getVal_clasif_puesto()!=null)
			qInsert.setInt(OID_VAL_CLASIF_PUE, pers.getVal_clasif_puesto().getOID());
		else
			qInsert.setNull(OID_VAL_CLASIF_PUE, Types.INTEGER);
		qInsert.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		if (pers.getOrden() != null)
			qInsert.setInt(ORDEN, pers.getOrden().intValue());
		else
			qInsert.setInt(ORDEN, 0);
		if (pers.getCategPosible()!=null)
			qInsert.setInt(OID_CATEG_POSIBLE , pers.getCategPosible().getOID());
		else
			qInsert.setNull(OID_CATEG_POSIBLE , Types.INTEGER);
		if (pers.getCantAniosPuesto()!=null)
			qInsert.setInt(CANT_ANIOS_PUESTO, pers.getCantAniosPuesto());
		else
			qInsert.setNull(CANT_ANIOS_PUESTO, Types.INTEGER);
		if (pers.getCantMesesPuesto()!=null)
			qInsert.setInt(CANT_MESES_PUESTO ,  pers.getCantMesesPuesto());
		else
			qInsert.setNull(CANT_MESES_PUESTO ,  Types.INTEGER);
		if (pers.getRankearCab()!=null)
			qInsert.setInt(OID_RANKEAR ,  pers.getRankearCab().getOID());
		else
			qInsert.setNull(OID_RANKEAR ,  Types.INTEGER);
		if (pers.getPuntosMinEval()!=null)
			qInsert.setDouble(PTOS_MIN_EVAL ,  pers.getPuntosMinEval().doubleValue());
		else
			qInsert.setNull(PTOS_MIN_EVAL ,  Types.DOUBLE);
		
		if (pers.getCantMinJuegosA()!=null)
			qInsert.setInt(CANT_MIN_JUEGOS_A ,  pers.getCantMinJuegosA().intValue());
		else
			qInsert.setNull(CANT_MIN_JUEGOS_A ,  Types.INTEGER);
		
		if (pers.getCantAniosHC()!=null)
			qInsert.setInt(CANT_ANIOS_HC ,  pers.getCantAniosHC().intValue());
		else
			qInsert.setNull(CANT_ANIOS_HC ,  Types.INTEGER);
		
		if (pers.getCantMesesHC()!=null)
			qInsert.setInt(CANT_MESES_HC ,  pers.getCantMesesHC().intValue());
		else
			qInsert.setNull(CANT_MESES_HC ,  Types.INTEGER);
		
		if (pers.getPuntosMinCalifGen()!=null)
			qInsert.setDouble(PTOS_MIN_CALIF_GEN ,  pers.getPuntosMinCalifGen().doubleValue());
		else
			qInsert.setNull(PTOS_MIN_CALIF_GEN ,  Types.DOUBLE);		
		
		if (pers.getUltMesesEvalPot()!=null)
			qInsert.setInt(ULT_MESES_EVAL_POT ,  pers.getUltMesesEvalPot().intValue());
		else
			qInsert.setNull(ULT_MESES_EVAL_POT ,  Types.INTEGER);		
		
		if (pers.isPendEvalSiFaltaEvalDesemp()!=null)
			qInsert.setBoolean(EVAL_PEND_SIN_EVAL ,  pers.isPendEvalSiFaltaEvalDesemp().booleanValue());
		else
			qInsert.setNull(EVAL_PEND_SIN_EVAL ,  Types.BOOLEAN);		
		
		if (pers.isPendEvalSiFaltaJuegos()!=null)
			qInsert.setBoolean(EVAL_PEND_SIN_JUE,  pers.isPendEvalSiFaltaJuegos().booleanValue());
		else
			qInsert.setNull(EVAL_PEND_SIN_JUE ,  Types.BOOLEAN);		
		
		if (pers.isEvalPendSinIRL()!=null)
			qInsert.setBoolean(EVAL_PEND_SIN_IRL,  pers.isEvalPendSinIRL().booleanValue());
		else
			qInsert.setNull(EVAL_PEND_SIN_IRL ,  Types.BOOLEAN);		
		
		if (pers.getUltMesesIRL()!=null)
			qInsert.setInt(ULT_MESES_IRL,  pers.getUltMesesIRL().intValue());
		else
			qInsert.setNull(ULT_MESES_IRL ,  Types.INTEGER);	
		
		if (pers.isEvalPendSinPot()!=null)
			qInsert.setBoolean(EVAL_PEND_SIN_POT,  pers.isEvalPendSinPot().booleanValue());
		else
			qInsert.setNull(EVAL_PEND_SIN_POT ,  Types.BOOLEAN);		
		
		
		qInsert.executeUpdate();
		qInsert.close();
	}

	protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_ACCION_CRO = 1;
		final int OID_VAL_CLASIF_EMP = 2;
		final int OID_VAL_CLASIF_SEC = 3;
		final int OID_VAL_CLASIF_PUE = 4;
		final int ACTIVO = 5;
		final int ORDEN = 6;
		final int OID_CATEG_POSIBLE = 7;
		final int CANT_ANIOS_PUESTO = 8;
		final int CANT_MESES_PUESTO = 9;
		final int OID_RANKEAR = 10;
		final int PTOS_MIN_EVAL = 11;
		final int CANT_MIN_JUEGOS_A = 12;
		final int CANT_ANIOS_HC = 13;
		final int CANT_MESES_HC = 14;
		final int PTOS_MIN_CALIF_GEN = 15;
		final int ULT_MESES_EVAL_POT = 16;
		final int EVAL_PEND_SIN_EVAL = 17;
		final int EVAL_PEND_SIN_JUE = 18;
		final int EVAL_PEND_SIN_IRL = 19;
		final int ULT_MESES_IRL = 20;
		final int EVAL_PEND_SIN_POT = 21;
		final int OID_JERAR_DESA = 22;

		JerarquiaDesa pers = (JerarquiaDesa) objetoPersistente;

		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append(" update rhJerarquiaDesa set " + "oid_accion_cro=?" + ",oid_val_clasif_emp=?" + ",oid_val_clasif_sec=?" + ",oid_val_clasif_pue=?" + ",activo=? , orden = ? , oid_categ_posible = ? , CANT_ANIOS_PUESTO = ? , CANT_MESES_PUESTO = ? , OID_RANKEAR = ? , PTOS_MIN_EVAL = ?  , CANT_MIN_JUEGOS_A = ?  , cant_anios_hc = ? , cant_meses_hc = ? , ptos_min_calif_gen = ? , ULT_MESES_EVAL_POT = ? , EVAL_PEND_SIN_EVAL = ? , EVAL_PEND_SIN_JUE = ? , eval_pend_sin_irl = ? , ult_meses_irl = ? , eval_pend_sin_pot = ?  " + " where "
				+ " oid_jerar_desa=? ");

		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_JERAR_DESA, pers.getOID());
		qUpdate.setInt(OID_ACCION_CRO, pers.getAccion().getOID());
		if (pers.getVal_clasif_empresa()!=null)
			qUpdate.setInt(OID_VAL_CLASIF_EMP, pers.getVal_clasif_empresa().getOID());
		else
			qUpdate.setNull(OID_VAL_CLASIF_EMP, Types.INTEGER);
		if (pers.getVal_clasif_sector()!=null)
			qUpdate.setInt(OID_VAL_CLASIF_SEC, pers.getVal_clasif_sector().getOID());
		else
			qUpdate.setNull(OID_VAL_CLASIF_SEC, Types.INTEGER);
		if (pers.getVal_clasif_puesto()!=null)
			qUpdate.setInt(OID_VAL_CLASIF_PUE, pers.getVal_clasif_puesto().getOID());
		else
			qUpdate.setNull(OID_VAL_CLASIF_PUE, Types.INTEGER);
		qUpdate.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		if (pers.getOrden() != null)
			qUpdate.setInt(ORDEN, pers.getOrden().intValue());
		else
			qUpdate.setInt(ORDEN, 0);
		if (pers.getCategPosible()!=null)
			qUpdate.setInt(OID_CATEG_POSIBLE , pers.getCategPosible().getOID());
		else
			qUpdate.setNull(OID_CATEG_POSIBLE , Types.INTEGER);
		if (pers.getCantAniosPuesto()!=null)
			qUpdate.setInt(CANT_ANIOS_PUESTO, pers.getCantAniosPuesto());
		else
			qUpdate.setNull(CANT_ANIOS_PUESTO, Types.INTEGER);
		if (pers.getCantMesesPuesto()!=null)
			qUpdate.setInt(CANT_MESES_PUESTO ,  pers.getCantMesesPuesto());
		else
			qUpdate.setNull(CANT_MESES_PUESTO ,  Types.INTEGER);
		if (pers.getRankearCab()!=null)
			qUpdate.setInt(OID_RANKEAR ,  pers.getRankearCab().getOID());
		else
			qUpdate.setNull(OID_RANKEAR ,  Types.INTEGER);
		if (pers.getPuntosMinEval()!=null)
			qUpdate.setDouble(PTOS_MIN_EVAL ,  pers.getPuntosMinEval().doubleValue());
		else
			qUpdate.setNull(PTOS_MIN_EVAL ,  Types.DOUBLE);
		if (pers.getCantMinJuegosA()!=null)
			qUpdate.setInt(CANT_MIN_JUEGOS_A ,  pers.getCantMinJuegosA().intValue());
		else
			qUpdate.setNull(CANT_MIN_JUEGOS_A ,  Types.INTEGER);
		
		if (pers.getCantAniosHC()!=null)
			qUpdate.setInt(CANT_ANIOS_HC ,  pers.getCantAniosHC().intValue());
		else
			qUpdate.setNull(CANT_ANIOS_HC ,  Types.INTEGER);
		
		if (pers.getCantMesesHC()!=null)
			qUpdate.setInt(CANT_MESES_HC ,  pers.getCantMesesHC().intValue());
		else
			qUpdate.setNull(CANT_MESES_HC ,  Types.INTEGER);
		
		if (pers.getPuntosMinCalifGen()!=null)
			qUpdate.setDouble(PTOS_MIN_CALIF_GEN ,  pers.getPuntosMinCalifGen().doubleValue());
		else
			qUpdate.setNull(PTOS_MIN_CALIF_GEN ,  Types.DOUBLE);		
		
		if (pers.getUltMesesEvalPot()!=null)
			qUpdate.setInt(ULT_MESES_EVAL_POT ,  pers.getUltMesesEvalPot().intValue());
		else
			qUpdate.setNull(ULT_MESES_EVAL_POT ,  Types.INTEGER);		
		
		if (pers.isPendEvalSiFaltaEvalDesemp()!=null)
			qUpdate.setBoolean(EVAL_PEND_SIN_EVAL ,  pers.isPendEvalSiFaltaEvalDesemp().booleanValue());
		else
			qUpdate.setNull(EVAL_PEND_SIN_EVAL ,  Types.BOOLEAN);		
		
		if (pers.isPendEvalSiFaltaJuegos()!=null)
			qUpdate.setBoolean(EVAL_PEND_SIN_JUE,  pers.isPendEvalSiFaltaJuegos().booleanValue());
		else
			qUpdate.setNull(EVAL_PEND_SIN_JUE ,  Types.BOOLEAN);	
		
		if (pers.isEvalPendSinIRL()!=null)
			qUpdate.setBoolean(EVAL_PEND_SIN_IRL,  pers.isEvalPendSinIRL().booleanValue());
		else
			qUpdate.setNull(EVAL_PEND_SIN_IRL ,  Types.BOOLEAN);
		
		if (pers.getUltMesesIRL()!=null)
			qUpdate.setInt(ULT_MESES_IRL,  pers.getUltMesesIRL().intValue());
		else
			qUpdate.setNull(ULT_MESES_IRL ,  Types.INTEGER);	
		
		if (pers.isEvalPendSinPot()!=null)
			qUpdate.setBoolean(EVAL_PEND_SIN_POT,  pers.isEvalPendSinPot().booleanValue());
		else
			qUpdate.setNull(EVAL_PEND_SIN_POT ,  Types.BOOLEAN);		
		
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_JERAR_DESA = 1;
		JerarquiaDesa pers = (JerarquiaDesa) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update rhJerarquiaDesa " + " set activo=0 " + " where " + " oid_jerar_desa=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_JERAR_DESA, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_JERAR_DESA = 1;
		JerarquiaDesa pers = (JerarquiaDesa) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update rhJerarquiaDesa " + " set activo=1 " + " where " + " oid_jerar_desa=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_JERAR_DESA, pers.getOID());
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
		case SELECT_BY_ACCION: {
			ps = this.selectByAccion(aCondiciones);
			break;
		}
		case SELECT_EMPRESA_SECTOR_PUESTO: {
			ps = this.selectByEmpresaSectorPuesto(aCondiciones);
			break;
		}
		}
		return ps;
	}

	private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

		final int OID_JERAR_DESA = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  rhJerarquiaDesa ");
		textSQL.append(" WHERE oid_jerar_desa = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		int oid = ((Integer) aCondiciones).intValue();
		querySelect.setInt(OID_JERAR_DESA, oid);
		return querySelect;
	}

	private PreparedStatement selectByEmpresaSectorPuesto(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  rhJerarquiaDesa ");
		textSQL.append(" WHERE oid_accion_cro = ? and oid_val_clasif_emp = ? and oid_val_clasif_sec = ? and oid_val_clasif_pue = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		AccCronoDesa accCronoDesa = (AccCronoDesa) condiciones.get(AccCronoDesa.NICKNAME);
		ValorClasificadorEntidad valClasifEmp = (ValorClasificadorEntidad) condiciones.get("EMPRESA");
		ValorClasificadorEntidad valClasifSec = (ValorClasificadorEntidad) condiciones.get("SECTOR");
		ValorClasificadorEntidad valClasifPue = (ValorClasificadorEntidad) condiciones.get("PUESTO");

		querySelect.setInt(1, accCronoDesa.getOID());
		querySelect.setInt(2, valClasifEmp.getOID());
		querySelect.setInt(3, valClasifSec.getOID());
		querySelect.setInt(4, valClasifPue.getOID());

		return querySelect;
	}

	private PreparedStatement selectByAccion(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  rhJerarquiaDesa ");
		textSQL.append(" WHERE oid_accion_cro = ? and activo = 1 ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		AccCronoDesa accion = (AccCronoDesa) aCondiciones;
		querySelect.setInt(1, accion.getOID());
		return querySelect;
	}

	private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

		final int CODIGO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  rhJerarquiaDesa ");
		textSQL.append(" WHERE  = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		String codigo = (String) aCondiciones;
		querySelect.setString(CODIGO, codigo);
		return querySelect;
	}

	private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();

		textSQL.append("SELECT oid_jerar_desa oid, codigo,  descripcion ,activo ");
		textSQL.append(" from rhJerarquiaDesa");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}

	public static List getJerarquiasDesa(AccCronoDesa aAccCronoDesa, ISesion aSesion) throws BaseException {
		return (List) ObjetoLogico.getObjects(JerarquiaDesa.NICKNAME, DBJerarquiaDesa.SELECT_BY_ACCION, aAccCronoDesa, new ListObserver(), aSesion);
	}

	public static JerarquiaDesa getJerarquiaDesa(AccCronoDesa accCronoDesa, ValorClasificadorEntidad valorClasifEmp, ValorClasificadorEntidad valorClasifSec, ValorClasificadorEntidad valorClasifPue,
			ISesion aSesion) throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put(AccCronoDesa.NICKNAME, accCronoDesa);
		condiciones.put("EMPRESA", valorClasifEmp);
		condiciones.put("SECTOR", valorClasifSec);
		condiciones.put("PUESTO", valorClasifPue);
		return (JerarquiaDesa) ObjetoLogico.getObjects(JerarquiaDesa.NICKNAME, DBJerarquiaDesa.SELECT_EMPRESA_SECTOR_PUESTO, condiciones, new ObjetoObservado(), aSesion);
	}

}
