package com.srn.erp.legales.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import com.srn.erp.legales.bm.Juicio;
import com.srn.erp.legales.bm.PagoJuicio;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;

public class DBPagoJuicio extends DBObjetoPersistente {

	public static final String OID_PAGO_JUICIO = "oid_pago_juicio";
	public static final String OID_JUICIO = "oid_juicio";
	public static final String FEC_PAGO = "fec_pago";
	public static final String OBSERVACION = "observacion";
	public static final String OID_CONC_PAGO_SECLO = "oid_conc_pago_seclo";
	public static final String PAGO_ACUERDO = "pago_acuerdo";
	public static final String PAGO_HORARIO = "pago_horario";
	public static final String PAGO_PERITO = "pago_perito";
	public static final String PAGO_TASA_JUST = "pago_tasa_just";
	public static final String ACTIVO = "activo";
	public static final String PAGO_ABOGADO = "pago_abogado";

	public static final int SELECT_BY_JUICIO = 100;
	public static final int SELECT_BY_FEC_DES_HAS = 101;

	public DBPagoJuicio() {
	}

	protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_PAGO_JUICIO = 1;
		final int OID_JUICIO = 2;
		final int FEC_PAGO = 3;
		final int OBSERVACION = 4;
		final int OID_CONC_PAGO_SECLO = 5;
		final int PAGO_ACUERDO = 6;
		final int PAGO_HORARIO = 7;
		final int PAGO_PERITO = 8;
		final int PAGO_TASA_JUST = 9;
		final int ACTIVO = 10;
		final int PAGO_ABOGADO = 11;

		PagoJuicio pers = (PagoJuicio) objetoPersistente;

		StringBuffer sqlInsert = new StringBuffer();
		sqlInsert.append(" insert into legPagoJuicio " + " ( " + "OID_PAGO_JUICIO," + "OID_JUICIO," + "FEC_PAGO," + "OBSERVACION," + "OID_CONC_PAGO_SECLO," + "PAGO_ACUERDO," + "PAGO_HORARIO,"
				+ "PAGO_PERITO," + "PAGO_TASA_JUST," + "ACTIVO , PAGO_ABOGADO)" + " values " + "(" + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?) ");

		PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
		qInsert.setInt(OID_PAGO_JUICIO, pers.getOID());
		qInsert.setInt(OID_JUICIO, pers.getJuicio().getOID());
		qInsert.setDate(FEC_PAGO, new java.sql.Date(pers.getFec_pago().getTime()));
		if (pers.getObservacion() != null)
			qInsert.setString(OBSERVACION, pers.getObservacion());
		else
			qInsert.setNull(OBSERVACION, Types.VARCHAR);
		if (pers.getConcepto_pago_seclo() != null)
			qInsert.setInt(OID_CONC_PAGO_SECLO, pers.getConcepto_pago_seclo().getOID());
		else
			qInsert.setNull(OID_CONC_PAGO_SECLO, java.sql.Types.INTEGER);
		if (pers.getPago_acuerdo() != null)
			qInsert.setDouble(PAGO_ACUERDO, pers.getPago_acuerdo().doubleValue());
		else
			qInsert.setNull(PAGO_ACUERDO, Types.DOUBLE);
		if (pers.getPago_horario() != null)
			qInsert.setDouble(PAGO_HORARIO, pers.getPago_horario().doubleValue());
		else
			qInsert.setNull(PAGO_HORARIO, Types.DOUBLE);
		if (pers.getPago_perito() != null)
			qInsert.setDouble(PAGO_PERITO, pers.getPago_perito().doubleValue());
		else
			qInsert.setNull(PAGO_PERITO, Types.DOUBLE);
		if (pers.getPago_tasa_just() != null)
			qInsert.setDouble(PAGO_TASA_JUST, pers.getPago_tasa_just().doubleValue());
		else
			qInsert.setNull(PAGO_TASA_JUST, Types.DOUBLE);
		qInsert.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		if (pers.getPagoLetrado() != null)
			qInsert.setDouble(PAGO_ABOGADO, pers.getPagoLetrado().doubleValue());
		else
			qInsert.setNull(PAGO_ABOGADO, Types.DOUBLE);
		qInsert.executeUpdate();
		qInsert.close();
	}

	protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_JUICIO = 1;
		final int FEC_PAGO = 2;
		final int OBSERVACION = 3;
		final int OID_CONC_PAGO_SECLO = 4;
		final int PAGO_ACUERDO = 5;
		final int PAGO_HORARIO = 6;
		final int PAGO_PERITO = 7;
		final int PAGO_TASA_JUST = 8;
		final int ACTIVO = 9;
		final int PAGO_ABOGADO = 10;
		final int OID_PAGO_JUICIO = 11;

		PagoJuicio pers = (PagoJuicio) objetoPersistente;

		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append(" update legPagoJuicio set " + "oid_juicio=?" + ",fec_pago=?" + ",observacion=?" + ",oid_conc_pago_seclo=?" + ",pago_acuerdo=?" + ",pago_horario=?" + ",pago_perito=?"
				+ ",pago_tasa_just=?" + ",activo=? , pago_abogado = ? " + " where " + " oid_pago_juicio=? ");

		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_PAGO_JUICIO, pers.getOID());
		qUpdate.setInt(OID_JUICIO, pers.getJuicio().getOID());
		qUpdate.setDate(FEC_PAGO, new java.sql.Date(pers.getFec_pago().getTime()));
		qUpdate.setString(OBSERVACION, pers.getObservacion());
		if (pers.getConcepto_pago_seclo() != null)
			qUpdate.setInt(OID_CONC_PAGO_SECLO, pers.getConcepto_pago_seclo().getOID());
		else
			qUpdate.setNull(OID_CONC_PAGO_SECLO, java.sql.Types.INTEGER);
		if (pers.getPago_acuerdo() != null)
			qUpdate.setDouble(PAGO_ACUERDO, pers.getPago_acuerdo().doubleValue());
		else
			qUpdate.setNull(PAGO_ACUERDO, Types.DOUBLE);
		if (pers.getPago_horario() != null)
			qUpdate.setDouble(PAGO_HORARIO, pers.getPago_horario().doubleValue());
		else
			qUpdate.setNull(PAGO_HORARIO, Types.DOUBLE);
		if (pers.getPago_perito() != null)
			qUpdate.setDouble(PAGO_PERITO, pers.getPago_perito().doubleValue());
		else
			qUpdate.setNull(PAGO_PERITO, Types.DOUBLE);
		if (pers.getPago_tasa_just() != null)
			qUpdate.setDouble(PAGO_TASA_JUST, pers.getPago_tasa_just().doubleValue());
		else
			qUpdate.setNull(PAGO_TASA_JUST, Types.DOUBLE);
		qUpdate.setBoolean(ACTIVO, pers.isActivo().booleanValue());

		if (pers.getPagoLetrado() != null)
			qUpdate.setDouble(PAGO_ABOGADO, pers.getPagoLetrado().doubleValue());
		else
			qUpdate.setNull(PAGO_ABOGADO, Types.DOUBLE);

		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_PAGO_JUICIO = 1;
		PagoJuicio pers = (PagoJuicio) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update legPagoJuicio " + " set activo=0 " + " where " + " oid_pago_juicio=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_PAGO_JUICIO, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_PAGO_JUICIO = 1;
		PagoJuicio pers = (PagoJuicio) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update legPagoJuicio " + " set activo=1 " + " where " + " oid_pago_juicio=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_PAGO_JUICIO, pers.getOID());
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
		case SELECT_BY_JUICIO: {
			ps = this.selectBySeclo(aCondiciones);
			break;
		}
		case SELECT_BY_FEC_DES_HAS: {
			ps = this.selectByFecDesdeHasta(aCondiciones);
			break;
		}
		}
		return ps;
	}

	private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

		final int OID_PAGO_JUICIO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  legPagoJuicio  ");
		textSQL.append(" WHERE oid_pago_juicio = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		int oid = ((Integer) aCondiciones).intValue();
		querySelect.setInt(OID_PAGO_JUICIO, oid);
		return querySelect;
	}

	private PreparedStatement selectByFecDesdeHasta(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT a.* FROM  legPagoJuicio a , legJuicios b , suLegajo c ");
		textSQL.append(" WHERE a.oid_juicio = b.oid_juicio and b.activo=1 and a.fec_pago >= ? and a.fec_pago<=? and a.activo = 1 and c.oid_legajo = b.oid_legajo and c.activo = 1  ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		java.util.Date fecDesde = (java.util.Date) condiciones.get("FEC_DESDE");
		java.util.Date fecHasta = (java.util.Date) condiciones.get("FEC_HASTA");
		querySelect.setDate(1, new java.sql.Date(fecDesde.getTime()));
		querySelect.setDate(2, new java.sql.Date(fecHasta.getTime()));
		return querySelect;
	}

	private PreparedStatement selectBySeclo(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  legPagoJuicio ");
		textSQL.append(" WHERE oid_juicio = ? and activo = 1 order by fec_pago desc ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		Juicio juicio = (Juicio) aCondiciones;
		querySelect.setInt(1, juicio.getOID());
		return querySelect;
	}

	private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

		final int CODIGO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  legPagoJuicio ");
		textSQL.append(" WHERE  = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		String codigo = (String) aCondiciones;
		querySelect.setString(CODIGO, codigo);
		return querySelect;
	}

	private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();

		textSQL.append("SELECT oid_pago_juicio oid, codigo,  descripcion ,activo ");
		textSQL.append(" from legPagoJuicio");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}

	public static List getPagosJuicio(Juicio aJuicio, ISesion aSesion) throws BaseException {
		return (List) ObjetoLogico.getObjects(PagoJuicio.NICKNAME, DBPagoJuicio.SELECT_BY_JUICIO, aJuicio, new ListObserver(), aSesion);
	}
	
	public static List getPagosJuicio(java.util.Date fecDesde,java.util.Date fecHasta, ISesion aSesion) throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put("FEC_DESDE", fecDesde);
		condiciones.put("FEC_HASTA", fecHasta);
		return (List) ObjetoLogico.getObjects(PagoJuicio.NICKNAME, DBPagoJuicio.SELECT_BY_FEC_DES_HAS, condiciones, new ListObserver(), aSesion);
	}	

}
