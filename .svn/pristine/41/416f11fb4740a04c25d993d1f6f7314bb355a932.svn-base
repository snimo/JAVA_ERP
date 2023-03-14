package com.srn.erp.rrhh.da;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.general.bm.ClasificadorEntidad;
import com.srn.erp.general.bm.ValorClasificadorEntidad;
import com.srn.erp.rrhh.bm.EvaluacionLegajoCab;
import com.srn.erp.rrhh.bm.ModeloEvalCab;
import com.srn.erp.rrhh.op.TraerLeyendasRepEval;
import com.srn.erp.sueldos.bm.Legajo;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.ObjetoObservado;

public class DBEvaluacionLegajoCab extends DBObjetoPersistente {

	public static final String OID_EVAL_CAB = "oid_eval_cab";
	public static final String VERSION_EVAL = "version_eval";
	public static final String OID_MOD_EVAL_CAB = "oid_mod_eval_cab";
	public static final String OID_LEGAJO = "oid_legajo";
	public static final String FEC_EVAL = "fec_eval";
	public static final String FEC_PUNTUACION = "fec_puntuacion";
	public static final String OID_USU_CARGA = "oid_usu_carga";
	public static final String FEC_ALTA_CARGA = "fec_alta_carga";
	public static final String OID_USU_MODIF = "oid_usu_modif";
	public static final String FEC_ULT_MODIF = "fec_ult_modif";
	public static final String PUNTAJE = "puntaje";
	public static final String FIRMADO = "firmado";
	public static final String FEC_FIRMADO = "fec_firmado";
	public static final String COMEN_DEL_EVALUADO = "comen_del_evaluado";
	public static final String ACTIVO = "activo";
	public static final String OID_COND_MOD = "oid_cond_mod";
	public static final String VIGENTE = "vigente";
	public static final String OID_VAL_PUE_FUT = "oid_val_pue_fut";

	public static final int UPDATE_NO_VIGENTE = 100;
	public static final int SELECT_BY_CONSULTA = 101;
	public static final int SELECT_BY_MODELO_LEGAJO = 102;
	public static final int SELECT_BY_OTRAS_EVAL = 103;
	public static final int SELECT_BY_MODELO_LEGAJO_ACT = 104;
	public static final int SELECT_BY_MODELO = 105;
	public static final int SELECT_BY_LEGAJO = 106;
	public static final int SELECT_BY_LEG_VIG_ULT_EVAL = 107;
	public static final int SELECT_BY_LEG_VIG_ULT_EVAL_FECHAS = 108;
	public static final int SELECT_BY_LEG_VIG_ULT_EVAL_FEC_TIPO = 109;
	public static final int SELECT_BY_MODELO_LEG_FEC_VIG = 110;
	

	public DBEvaluacionLegajoCab() {
	}

	protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_EVAL_CAB = 1;
		final int VERSION_EVAL = 2;
		final int OID_MOD_EVAL_CAB = 3;
		final int OID_LEGAJO = 4;
		final int FEC_EVAL = 5;
		final int FEC_PUNTUACION = 6;
		final int OID_USU_CARGA = 7;
		final int FEC_ALTA_CARGA = 8;
		final int OID_USU_MODIF = 9;
		final int FEC_ULT_MODIF = 10;
		final int PUNTAJE = 11;
		final int FIRMADO = 12;
		final int FEC_FIRMADO = 13;
		final int COMEN_DEL_EVALUADO = 14;
		final int ACTIVO = 15;
		final int OID_COND_MOD = 16;
		final int VIGENTE = 17;
		final int OID_VAL_PUE_FUT = 18;

		EvaluacionLegajoCab pers = (EvaluacionLegajoCab) objetoPersistente;

		StringBuffer sqlInsert = new StringBuffer();
		sqlInsert.append(" insert into rhEvalLegCab " + " ( " + "OID_EVAL_CAB," + "VERSION_EVAL," + "OID_MOD_EVAL_CAB," + "OID_LEGAJO," + "FEC_EVAL," + "FEC_PUNTUACION," + "OID_USU_CARGA,"
				+ "FEC_ALTA_CARGA," + "OID_USU_MODIF," + "FEC_ULT_MODIF," + "PUNTAJE," + "FIRMADO," + "FEC_FIRMADO," + "COMEN_DEL_EVALUADO," + "ACTIVO,OID_COND_MOD,VIGENTE , OID_VAL_PUE_FUT)" + " values " + "(" + "?,"
				+ "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?,"+ "?," + "?," + "?) ");

		PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
		qInsert.setInt(OID_EVAL_CAB, pers.getOID());
		qInsert.setInt(VERSION_EVAL, pers.getVersion_eval().intValue());
		qInsert.setInt(OID_MOD_EVAL_CAB, pers.getModelo_eval_cab().getOID());
		qInsert.setInt(OID_LEGAJO, pers.getLegajo().getOID());
		qInsert.setDate(FEC_EVAL, new java.sql.Date(pers.getFec_eval().getTime()));
		if (pers.getFec_puntuacion() != null)
			qInsert.setDate(FEC_PUNTUACION, new java.sql.Date(pers.getFec_puntuacion().getTime()));
		else
			qInsert.setNull(FEC_PUNTUACION, Types.DATE);
		qInsert.setInt(OID_USU_CARGA, pers.getUsuario_alta().getOID());
		qInsert.setDate(FEC_ALTA_CARGA, new java.sql.Date(pers.getFec_alta_carga().getTime()));
		if (pers.getUsuario_modif() != null)
			qInsert.setInt(OID_USU_MODIF, pers.getUsuario_modif().getOID());
		else
			qInsert.setNull(OID_USU_MODIF, Types.INTEGER);
		if (pers.getFec_ult_modif() != null)
			qInsert.setDate(FEC_ULT_MODIF, new java.sql.Date(pers.getFec_ult_modif().getTime()));
		else
			qInsert.setNull(FEC_ULT_MODIF, Types.DATE);
		if (pers.getPuntaje() != null)
			qInsert.setDouble(PUNTAJE, pers.getPuntaje().doubleValue());
		else
			qInsert.setDouble(PUNTAJE, 0);
		if (pers.isFirmado() != null)
			qInsert.setBoolean(FIRMADO, pers.isFirmado().booleanValue());
		else
			qInsert.setBoolean(FIRMADO, false);
		if (pers.getFec_firmado() != null)
			qInsert.setDate(FEC_FIRMADO, new java.sql.Date(pers.getFec_firmado().getTime()));
		else
			qInsert.setNull(FEC_FIRMADO, Types.DATE);
		if (pers.getComen_del_evaluado() != null)
			qInsert.setString(COMEN_DEL_EVALUADO, pers.getComen_del_evaluado());
		else
			qInsert.setString(COMEN_DEL_EVALUADO, "");
		qInsert.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		if (pers.getCondModEvalCab() != null)
			qInsert.setInt(OID_COND_MOD, pers.getCondModEvalCab().getOID());
		else
			qInsert.setNull(OID_COND_MOD, Types.INTEGER);
		qInsert.setBoolean(VIGENTE, pers.isVigente());
		if (pers.getValClasifPuestoFuturo()!=null)
			qInsert.setInt(OID_VAL_PUE_FUT , pers.getValClasifPuestoFuturo().getOIDInteger());
		else
			qInsert.setNull(OID_VAL_PUE_FUT , Types.INTEGER);
		qInsert.executeUpdate();
		qInsert.close();
	}

	protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int VERSION_EVAL = 1;
		final int OID_MOD_EVAL_CAB = 2;
		final int OID_LEGAJO = 3;
		final int FEC_EVAL = 4;
		final int FEC_PUNTUACION = 5;
		final int OID_USU_CARGA = 6;
		final int FEC_ALTA_CARGA = 7;
		final int OID_USU_MODIF = 8;
		final int FEC_ULT_MODIF = 9;
		final int PUNTAJE = 10;
		final int FIRMADO = 11;
		final int FEC_FIRMADO = 12;
		final int COMEN_DEL_EVALUADO = 13;
		final int ACTIVO = 14;
		final int OID_COND_MOD = 15;
		final int VIGENTE = 16;
		final int OID_VAL_PUE_FUT = 17;
		final int OID_EVAL_CAB = 18;

		EvaluacionLegajoCab pers = (EvaluacionLegajoCab) objetoPersistente;

		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append(" update rhEvalLegCab set " + "version_eval=?" + ",oid_mod_eval_cab=?" + ",oid_legajo=?" + ",fec_eval=?" + ",fec_puntuacion=?" + ",oid_usu_carga=?" + ",fec_alta_carga=?"
				+ ",oid_usu_modif=?" + ",fec_ult_modif=?" + ",puntaje=?" + ",firmado=?" + ",fec_firmado=?" + ",comen_del_evaluado=?" + ",activo=?" + ",oid_cond_mod=?" + ",vigente=? , oid_val_pue_fut = ? " + " where "
				+ " oid_eval_cab=? ");

		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_EVAL_CAB, pers.getOID());
		qUpdate.setInt(VERSION_EVAL, pers.getVersion_eval().intValue());
		qUpdate.setInt(OID_MOD_EVAL_CAB, pers.getModelo_eval_cab().getOID());
		qUpdate.setInt(OID_LEGAJO, pers.getLegajo().getOID());
		qUpdate.setDate(FEC_EVAL, new java.sql.Date(pers.getFec_eval().getTime()));
		if (pers.getFec_puntuacion() != null)
			qUpdate.setDate(FEC_PUNTUACION, new java.sql.Date(pers.getFec_puntuacion().getTime()));
		else
			qUpdate.setNull(FEC_PUNTUACION, Types.DATE);
		qUpdate.setInt(OID_USU_CARGA, pers.getUsuario_alta().getOID());
		qUpdate.setDate(FEC_ALTA_CARGA, new java.sql.Date(pers.getFec_alta_carga().getTime()));
		if (pers.getUsuario_modif() != null)
			qUpdate.setInt(OID_USU_MODIF, pers.getUsuario_modif().getOID());
		else
			qUpdate.setNull(OID_USU_MODIF, Types.INTEGER);
		if (pers.getFec_ult_modif() != null)
			qUpdate.setDate(FEC_ULT_MODIF, new java.sql.Date(pers.getFec_ult_modif().getTime()));
		else
			qUpdate.setNull(FEC_ULT_MODIF, Types.DATE);

		if (pers.getPuntaje() != null)
			qUpdate.setDouble(PUNTAJE, pers.getPuntaje().doubleValue());
		else
			qUpdate.setDouble(PUNTAJE, 0);
		if (pers.isFirmado() != null)
			qUpdate.setBoolean(FIRMADO, pers.isFirmado().booleanValue());
		else
			qUpdate.setBoolean(FIRMADO, false);
		if (pers.getFec_firmado() != null)
			qUpdate.setDate(FEC_FIRMADO, new java.sql.Date(pers.getFec_firmado().getTime()));
		else
			qUpdate.setNull(FEC_FIRMADO, Types.DATE);
		if (pers.getComen_del_evaluado() != null)
			qUpdate.setString(COMEN_DEL_EVALUADO, pers.getComen_del_evaluado());
		else
			qUpdate.setString(COMEN_DEL_EVALUADO, "");
		qUpdate.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		if (pers.getCondModEvalCab() != null)
			qUpdate.setInt(OID_COND_MOD, pers.getCondModEvalCab().getOID());
		else
			qUpdate.setNull(OID_COND_MOD, Types.INTEGER);
		qUpdate.setBoolean(VIGENTE, pers.isVigente());
		if (pers.getValClasifPuestoFuturo()!=null)
			qUpdate.setInt(OID_VAL_PUE_FUT , pers.getValClasifPuestoFuturo().getOIDInteger());
		else
			qUpdate.setNull(OID_VAL_PUE_FUT , Types.INTEGER);		
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_EVAL_CAB = 1;
		EvaluacionLegajoCab pers = (EvaluacionLegajoCab) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update rhEvalLegCab " + " set activo=0 " + " where " + " oid_eval_cab=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_EVAL_CAB, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_EVAL_CAB = 1;
		EvaluacionLegajoCab pers = (EvaluacionLegajoCab) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update rhEvalLegCab " + " set activo=1 " + " where " + " oid_eval_cab=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_EVAL_CAB, pers.getOID());
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
		case UPDATE_NO_VIGENTE: {
			ps = this.updateNoVigente(aCondiciones);
			break;
		}
		case SELECT_BY_CONSULTA: {
			ps = this.selectByConsulta(aCondiciones);
			break;
		}
		case SELECT_BY_MODELO_LEGAJO: {
			ps = this.selectByModeloLegajo(aCondiciones);
			break;
		}
		case SELECT_BY_MODELO_LEGAJO_ACT: {
			ps = this.selectByModeloLegajoAct(aCondiciones);
			break;
		}
		case SELECT_BY_OTRAS_EVAL: {
			ps = this.selectByOtrasEval(aCondiciones);
			break;
		}
		case SELECT_BY_MODELO: {
			ps = this.selectByModelo(aCondiciones);
			break;
		}
		case SELECT_BY_LEGAJO: {
			ps = this.selectByLegajo(aCondiciones);
			break;
		}
		case SELECT_BY_LEG_VIG_ULT_EVAL: {
			ps = this.selectByLegVigUltEval(aCondiciones);
			break;
		}
		case SELECT_BY_LEG_VIG_ULT_EVAL_FECHAS: {
			ps = this.selectByLegVigUltEvalFechas(aCondiciones);
			break;
		}		
		case SELECT_BY_LEG_VIG_ULT_EVAL_FEC_TIPO: {
			ps = this.selectByLegVigUltEvalFecTipo(aCondiciones);
			break;
		}
		case SELECT_BY_MODELO_LEG_FEC_VIG: {
			ps = this.selectByModeloLegFecVig(aCondiciones);
			break;
		}
		}
		return ps;
	}

	private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

		final int OID_EVAL_CAB = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  rhEvalLegCab ");
		textSQL.append(" WHERE oid_eval_cab = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		int oid = ((Integer) aCondiciones).intValue();
		querySelect.setInt(OID_EVAL_CAB, oid);
		return querySelect;
	}

	private PreparedStatement selectByConsulta(Object aCondiciones) throws BaseException, SQLException {

		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		java.util.Date fecDesde = (java.util.Date) condiciones.get("FECHA_DESDE");
		java.util.Date fecHasta = (java.util.Date) condiciones.get("FECHA_HASTA");
		List listaModelos = (List) condiciones.get("MODELOS");
		List listaLegajos = (List) condiciones.get("LEGAJOS");
		List listaEmpresas = (List) condiciones.get("EMPRESAS");
		List listaSectores = (List) condiciones.get("SECTORES");
		List listaPuestos = (List) condiciones.get("PUESTOS");
		List listaEstados = (List) condiciones.get("ESTADOS");

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  rhEvalLegCab ");
		textSQL.append(" WHERE  activo = 1 and vigente = 1 ");

		if (fecDesde != null)
			textSQL.append(" and fec_eval>=? ");

		if (fecHasta != null)
			textSQL.append(" and fec_eval<=? ");

		if (listaModelos.size() != 0) {
			StringBuffer condINModelos = new StringBuffer("");
			Iterator iterMode = listaModelos.iterator();
			while (iterMode.hasNext()) {
				ModeloEvalCab modeloEvalCab = (ModeloEvalCab) iterMode.next();
				if (condINModelos.length() == 0)
					condINModelos.append(modeloEvalCab.getOIDInteger());
				else
					condINModelos.append("," + modeloEvalCab.getOIDInteger());
			}
			textSQL.append(" and oid_mod_eval_cab in (" + condINModelos.toString() + ") ");
		}

		if (listaLegajos.size() != 0) {
			StringBuffer condINLegajos = new StringBuffer("");
			Iterator iterLega = listaLegajos.iterator();
			while (iterLega.hasNext()) {
				Legajo legajo = (Legajo) iterLega.next();
				if (condINLegajos.length() == 0)
					condINLegajos.append(legajo.getOIDInteger());
				else
					condINLegajos.append("," + legajo.getOIDInteger());
			}
			textSQL.append(" and oid_legajo in (" + condINLegajos.toString() + ") ");
		}

		// Traer Empresas
		ClasificadorEntidad clasifEmpresa = TraerLeyendasRepEval.getClasificadorEmpresa(this.getSesion());
		if (listaEmpresas.size() != 0) {
			StringBuffer condEmpresas = new StringBuffer("");
			condEmpresas.append(" select oid_eval_cab from rhEvalValClasif where activo=1 and oid_clasificador=" + clasifEmpresa.getOIDInteger() + " and ");
			condEmpresas.append(" oid_val_clasif in (");
			int i = 0;
			Iterator iterEmp = listaEmpresas.iterator();
			while (iterEmp.hasNext()) {
				ValorClasificadorEntidad valClasifEntEmp = (ValorClasificadorEntidad) iterEmp.next();
				if (i == 0)
					condEmpresas.append(valClasifEntEmp.getOIDInteger());
				else
					condEmpresas.append("," + valClasifEntEmp.getOIDInteger());
				++i;
			}
			condEmpresas.append(") ");
			textSQL.append(" and oid_eval_cab in (" + condEmpresas.toString() + ") ");
		}

		// Traer Sectores
		ClasificadorEntidad clasifSector = TraerLeyendasRepEval.getClasificadorSector(this.getSesion());
		if (listaSectores.size() != 0) {
			StringBuffer condSectores = new StringBuffer("");
			condSectores.append(" select oid_eval_cab from rhEvalValClasif where activo=1 and oid_clasificador=" + clasifSector.getOIDInteger() + " and ");
			condSectores.append(" oid_val_clasif in (");
			int i = 0;
			Iterator iterSec = listaSectores.iterator();
			while (iterSec.hasNext()) {
				ValorClasificadorEntidad valClasifEntSec = (ValorClasificadorEntidad) iterSec.next();
				if (i == 0)
					condSectores.append(valClasifEntSec.getOIDInteger());
				else
					condSectores.append("," + valClasifEntSec.getOIDInteger());
				++i;
			}
			condSectores.append(") ");
			textSQL.append(" and oid_eval_cab in (" + condSectores.toString() + ") ");
		}

		// Traer Puestos
		ClasificadorEntidad clasifPuesto = TraerLeyendasRepEval.getClasificadorPuesto(this.getSesion());
		if (listaPuestos.size() != 0) {
			StringBuffer condPuestos = new StringBuffer("");
			condPuestos.append(" select oid_eval_cab from rhEvalValClasif where activo=1 and oid_clasificador=" + clasifPuesto.getOIDInteger() + " and ");
			condPuestos.append(" oid_val_clasif in (");
			int i = 0;
			Iterator iterPue = listaPuestos.iterator();
			while (iterPue.hasNext()) {
				ValorClasificadorEntidad valClasifEntPue = (ValorClasificadorEntidad) iterPue.next();
				if (i == 0)
					condPuestos.append(valClasifEntPue.getOIDInteger());
				else
					condPuestos.append("," + valClasifEntPue.getOIDInteger());
				++i;
			}
			condPuestos.append(") ");
			textSQL.append(" and oid_eval_cab in (" + condPuestos.toString() + ") ");
		}

		// Traer Activos
		ClasificadorEntidad clasifEstado = TraerLeyendasRepEval.getClasificadorEstado(this.getSesion());
		if (listaEstados.size() != 0) {
			StringBuffer condEstados = new StringBuffer("");
			condEstados.append(" select oid_eval_cab from rhEvalValClasif where activo=1 and oid_clasificador=" + clasifEstado.getOIDInteger() + " and ");
			condEstados.append(" oid_val_clasif in (");
			int i = 0;
			Iterator iterEst = listaEstados.iterator();
			while (iterEst.hasNext()) {
				ValorClasificadorEntidad valClasifEntEst = (ValorClasificadorEntidad) iterEst.next();
				if (i == 0)
					condEstados.append(valClasifEntEst.getOIDInteger());
				else
					condEstados.append("," + valClasifEntEst.getOIDInteger());
				++i;
			}
			condEstados.append(") ");
			textSQL.append(" and oid_eval_cab in (" + condEstados.toString() + ") ");
		}

		int param = 0;
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());

		if (fecDesde != null) {
			++param;
			querySelect.setDate(param, new java.sql.Date(fecDesde.getTime()));
		}

		if (fecHasta != null) {
			++param;
			querySelect.setDate(param, new java.sql.Date(fecHasta.getTime()));
		}

		return querySelect;

	}

	private PreparedStatement selectByOtrasEval(Object aCondiciones) throws BaseException, SQLException {
		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		ModeloEvalCab modeloEvalCab = (ModeloEvalCab) condiciones.get(ModeloEvalCab.NICKNAME);
		Legajo legajo = (Legajo) condiciones.get(Legajo.NICKNAME);
		EvaluacionLegajoCab evaluacionLegajoCab = (EvaluacionLegajoCab) condiciones.get(EvaluacionLegajoCab.NICKNAME);

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  rhEvalLegCab ");
		textSQL.append(" WHERE oid_mod_eval_cab = ? and oid_legajo = ? and oid_eval_cab<>? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		querySelect.setInt(1, modeloEvalCab.getOID());
		querySelect.setInt(2, legajo.getOID());
		querySelect.setInt(3, evaluacionLegajoCab.getOID());
		return querySelect;
	}

	private PreparedStatement selectByModeloLegajoAct(Object aCondiciones) throws BaseException, SQLException {
		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		ModeloEvalCab modeloEvalCab = (ModeloEvalCab) condiciones.get(ModeloEvalCab.NICKNAME);
		Legajo legajo = (Legajo) condiciones.get(Legajo.NICKNAME);

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  rhEvalLegCab ");
		textSQL.append(" WHERE oid_mod_eval_cab = ? and oid_legajo = ? and activo = 1 order by fec_alta_carga desc,oid_eval_cab desc ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		querySelect.setInt(1, modeloEvalCab.getOID());
		querySelect.setInt(2, legajo.getOID());
		return querySelect;
	}

	private PreparedStatement selectByModelo(Object aCondiciones) throws BaseException, SQLException {
		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		ModeloEvalCab modeloEvalCab = (ModeloEvalCab) condiciones.get(ModeloEvalCab.NICKNAME);
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  rhEvalLegCab ");
		textSQL.append(" WHERE oid_mod_eval_cab = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		querySelect.setInt(1, modeloEvalCab.getOID());
		return querySelect;
	}
	
	private PreparedStatement selectByModeloLegFecVig(Object aCondiciones) throws BaseException, SQLException {

		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		Legajo legajo = (Legajo) condiciones.get(Legajo.NICKNAME);
		java.util.Date fec = (java.util.Date) condiciones.get("FECHA");
		ModeloEvalCab modeloEvalCab = (ModeloEvalCab) condiciones.get(ModeloEvalCab.NICKNAME);
		
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  rhEvalLegCab ");
		textSQL.append(" WHERE oid_mod_eval_cab = ? and activo = 1 and vigente = 1 and oid_legajo = ? and fec_eval = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		querySelect.setInt(1, modeloEvalCab.getOID());
		querySelect.setInt(2, legajo.getOID());
		querySelect.setDate(3, new java.sql.Date(fec.getTime()));
		return querySelect;

	}	
	

	private PreparedStatement selectByLegVigUltEvalFecTipo(Object aCondiciones) throws BaseException, SQLException {

		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		Legajo legajo = (Legajo) condiciones.get(Legajo.NICKNAME);
		java.util.Date fecDesde = (java.util.Date) condiciones.get("FECHA_DESDE");
		java.util.Date fecHasta = (java.util.Date) condiciones.get("FECHA_HASTA");
		String tipo = (String) condiciones.get("TIPO");
		
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT a.* FROM  rhEvalLegCab a , rhModEvalCab b ");
		textSQL.append(" WHERE a.oid_mod_eval_cab = b.oid_mod_eval_cab and a.activo = 1 and a.vigente = 1 and a.oid_legajo = ? and b.fec_hasta>=? and b.fec_hasta<=? and b.tipo=? order by b.fec_hasta desc ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		querySelect.setInt(1, legajo.getOID());
		querySelect.setDate(2, new java.sql.Date(fecDesde.getTime()));
		querySelect.setDate(3, new java.sql.Date(fecHasta.getTime()));
		querySelect.setString(4, tipo);
		return querySelect;

	}	
	
	
	private PreparedStatement selectByLegVigUltEvalFechas(Object aCondiciones) throws BaseException, SQLException {

		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		Legajo legajo = (Legajo) condiciones.get(Legajo.NICKNAME);
		java.util.Date fecDesde = (java.util.Date) condiciones.get("FECHA_DESDE");
		java.util.Date fecHasta = (java.util.Date) condiciones.get("FECHA_HASTA");
		
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT a.* FROM  rhEvalLegCab a , rhModEvalCab b ");
		textSQL.append(" WHERE a.oid_mod_eval_cab = b.oid_mod_eval_cab and a.activo = 1 and a.vigente = 1 and a.oid_legajo = ? and b.fec_hasta>=? and b.fec_hasta<=? order by b.fec_hasta desc ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		querySelect.setInt(1, legajo.getOID());
		querySelect.setDate(2, new java.sql.Date(fecDesde.getTime()));
		querySelect.setDate(3, new java.sql.Date(fecHasta.getTime()));
		return querySelect;

	}
	
	
	private PreparedStatement selectByLegVigUltEval(Object aCondiciones) throws BaseException, SQLException {

		Legajo legajo = (Legajo) aCondiciones;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT a.* FROM  rhEvalLegCab a , rhModEvalCab b ");
		textSQL.append(" WHERE a.oid_mod_eval_cab = b.oid_mod_eval_cab and a.activo = 1 and a.vigente = 1 and a.oid_legajo = ? order by b.fec_hasta desc ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		querySelect.setInt(1, legajo.getOID());
		return querySelect;

	}

	private PreparedStatement selectByLegajo(Object aCondiciones) throws BaseException, SQLException {

		Legajo legajo = (Legajo) aCondiciones;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  rhEvalLegCab ");
		textSQL.append(" WHERE oid_legajo = ? and activo = 1");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		querySelect.setInt(1, legajo.getOID());
		return querySelect;
	}

	private PreparedStatement selectByModeloLegajo(Object aCondiciones) throws BaseException, SQLException {
		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		ModeloEvalCab modeloEvalCab = (ModeloEvalCab) condiciones.get(ModeloEvalCab.NICKNAME);
		Legajo legajo = (Legajo) condiciones.get(Legajo.NICKNAME);

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  rhEvalLegCab ");
		textSQL.append(" WHERE oid_mod_eval_cab = ? and oid_legajo = ? and activo = 1 and vigente = 1 ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		querySelect.setInt(1, modeloEvalCab.getOID());
		querySelect.setInt(2, legajo.getOID());
		return querySelect;
	}

	private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

		final int CODIGO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  rhEvalLegCab ");
		textSQL.append(" WHERE  = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		String codigo = (String) aCondiciones;
		querySelect.setString(CODIGO, codigo);
		return querySelect;
	}

	private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();

		textSQL.append("SELECT oid_eval_cab oid, codigo,  descripcion ,activo ");
		textSQL.append(" from rhEvalLegCab");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}

	private PreparedStatement updateNoVigente(Object aCondiciones) throws BaseException, SQLException {

		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		ModeloEvalCab modelo = (ModeloEvalCab) condiciones.get(ModeloEvalCab.NICKNAME);
		Legajo legajo = (Legajo) condiciones.get(Legajo.NICKNAME);
		EvaluacionLegajoCab evaluacionLegajoCab = (EvaluacionLegajoCab) condiciones.get(EvaluacionLegajoCab.NICKNAME);
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update rhEvalLegCab " + " set vigente=0 " + " where " + " oid_mod_eval_cab=? and oid_legajo=? and oid_eval_cab<>? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(1, modelo.getOID());
		qUpdate.setInt(2, legajo.getOID());
		qUpdate.setInt(3, evaluacionLegajoCab.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
		return null;

	}

	public static List getConsulta(java.util.Date fecDesde, java.util.Date fecHasta, List modelos, List legajos, List empresas, List sectores, List puestos, List estados, ISesion aSesion)
			throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		if (fecDesde != null)
			condiciones.put("FECHA_DESDE", fecDesde);
		if (fecHasta != null)
			condiciones.put("FECHA_HASTA", fecHasta);
		condiciones.put("MODELOS", modelos);
		condiciones.put("LEGAJOS", legajos);
		condiciones.put("EMPRESAS", empresas);
		condiciones.put("SECTORES", sectores);
		condiciones.put("PUESTOS", puestos);
		condiciones.put("ESTADOS", estados);
		return (List) ObjetoLogico.getObjects(EvaluacionLegajoCab.NICKNAME, DBEvaluacionLegajoCab.SELECT_BY_CONSULTA, condiciones, new ListObserver(), aSesion);
	}

	public static EvaluacionLegajoCab getEvaluacionLegajoCab(ModeloEvalCab modeloEvalCab, Legajo legajo, ISesion aSesion) throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put(ModeloEvalCab.NICKNAME, modeloEvalCab);
		condiciones.put(Legajo.NICKNAME, legajo);
		return (EvaluacionLegajoCab) ObjetoLogico.getObjects(EvaluacionLegajoCab.NICKNAME, DBEvaluacionLegajoCab.SELECT_BY_MODELO_LEGAJO, condiciones, new ObjetoObservado(), aSesion);
	}

	public static List getOtrasVersiones(ModeloEvalCab modeloEvalCab, Legajo legajo, EvaluacionLegajoCab eEvaluacionLegajoCab, ISesion aSesion) throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put(ModeloEvalCab.NICKNAME, modeloEvalCab);
		condiciones.put(Legajo.NICKNAME, legajo);
		condiciones.put(EvaluacionLegajoCab.NICKNAME, eEvaluacionLegajoCab);

		return (List) ObjetoLogico.getObjects(EvaluacionLegajoCab.NICKNAME, DBEvaluacionLegajoCab.SELECT_BY_OTRAS_EVAL, condiciones, new ListObserver(), aSesion);
	}

	public static List getEvaluacionesActivasModeloLeg(ModeloEvalCab modeloEvalCab, Legajo legajo, ISesion aSesion) throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put(ModeloEvalCab.NICKNAME, modeloEvalCab);
		condiciones.put(Legajo.NICKNAME, legajo);

		return (List) ObjetoLogico.getObjects(EvaluacionLegajoCab.NICKNAME, DBEvaluacionLegajoCab.SELECT_BY_MODELO_LEGAJO_ACT, condiciones, new ListObserver(), aSesion);
	}

	public static List getEvaluacionesByModelo(ModeloEvalCab modeloEvalCab, ISesion aSesion) throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put(ModeloEvalCab.NICKNAME, modeloEvalCab);

		return (List) ObjetoLogico.getObjects(EvaluacionLegajoCab.NICKNAME, DBEvaluacionLegajoCab.SELECT_BY_MODELO, condiciones, new ListObserver(), aSesion);
	}

	public static int getNroMaxVersion(ModeloEvalCab aModeloEvalCab, Legajo legajo, ISesion aSesion) throws BaseException {

		try {

			StringBuffer textSQL = new StringBuffer();
			textSQL.append("SELECT max(version_eval) version_eval FROM rhEvalLegCab  ");
			textSQL.append(" WHERE oid_mod_eval_cab = ? and oid_legajo=?  ");
			PreparedStatement querySelect = aSesion.getConexionBD().prepareStatement(textSQL.toString());
			querySelect.setInt(1, aModeloEvalCab.getOID());
			querySelect.setInt(2, legajo.getOID());
			ResultSet rs = querySelect.executeQuery();
			int cant = 0;
			if (rs.next())
				cant = rs.getInt(1);
			rs.close();
			querySelect.close();

			return cant;
		} catch (Exception e) {
			throw new BaseException(null, e.getMessage());
		}
	}

	public static List getEvaluacionesByLegajo(Legajo aLegajo, ISesion aSesion) throws BaseException {

		return (List) ObjetoLogico.getObjects(EvaluacionLegajoCab.NICKNAME, DBEvaluacionLegajoCab.SELECT_BY_LEGAJO, aLegajo, new ListObserver(), aSesion);
	}

	public static EvaluacionLegajoCab getUltimaEvaluacionLegajoCab(Legajo aLegajo, ISesion aSesion) throws BaseException {
		
		List lista =
			(List) ObjetoLogico.getObjects(EvaluacionLegajoCab.NICKNAME, DBEvaluacionLegajoCab.SELECT_BY_LEG_VIG_ULT_EVAL, aLegajo, new ListObserver(), aSesion);
		
		if (lista.size()>0)
			return (EvaluacionLegajoCab)lista.get(0);
		else
			return null;
		
	}
	
	public static EvaluacionLegajoCab getUltimaEvalLegCab(
			java.util.Date fecDesde,
			java.util.Date fecHasta,
			Legajo aLegajo, ISesion aSesion) throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put(Legajo.NICKNAME, aLegajo);
		condiciones.put("FECHA_DESDE", fecDesde);
		condiciones.put("FECHA_HASTA", fecHasta);
		
		List lista =
			(List) ObjetoLogico.getObjects(EvaluacionLegajoCab.NICKNAME, DBEvaluacionLegajoCab.SELECT_BY_LEG_VIG_ULT_EVAL_FECHAS, condiciones, new ListObserver(), aSesion);
		
		if (lista.size()>0)
			return (EvaluacionLegajoCab)lista.get(0);
		else
			return null;
		
	}
	
	public static EvaluacionLegajoCab getEvalByModeloLegFecVig(
			ModeloEvalCab modelo,
			java.util.Date fecha,
			Legajo legajo,ISesion aSesion) throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put(ModeloEvalCab.NICKNAME, modelo);
		condiciones.put("FECHA", fecha);
		condiciones.put(Legajo.NICKNAME, legajo);
		
		List lista =
			(List) ObjetoLogico.getObjects(EvaluacionLegajoCab.NICKNAME, DBEvaluacionLegajoCab.SELECT_BY_MODELO_LEG_FEC_VIG, condiciones, new ListObserver(), aSesion);
		
		if (lista.size()>0)
			return (EvaluacionLegajoCab)lista.get(0);
		else
			return null;
		
	}	
	
	public static EvaluacionLegajoCab getUltimaEvalLegCab(
			java.util.Date fecDesde,
			java.util.Date fecHasta,
			String tipo,
			Legajo aLegajo, ISesion aSesion) throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put(Legajo.NICKNAME, aLegajo);
		condiciones.put("FECHA_DESDE", fecDesde);
		condiciones.put("FECHA_HASTA", fecHasta);
		condiciones.put("TIPO", tipo);
		List lista =
			(List) ObjetoLogico.getObjects(EvaluacionLegajoCab.NICKNAME, DBEvaluacionLegajoCab.SELECT_BY_LEG_VIG_ULT_EVAL_FEC_TIPO, condiciones, new ListObserver(), aSesion);
		
		if (lista.size()>0)
			return (EvaluacionLegajoCab)lista.get(0);
		else
			return null;
		
	}	
	

}
