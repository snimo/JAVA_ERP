package com.srn.erp.legales.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.legales.bm.PagoSeclo;
import com.srn.erp.legales.bm.Seclo;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;

public class DBPagoSeclo extends DBObjetoPersistente {

	public static final String OID_PAGO_SECLO = "oid_pago_seclo";
	public static final String OID_SECLO = "oid_seclo";
	public static final String FEC_PAGO = "fec_pago";
	public static final String OBSERVACION = "observacion";
	public static final String PAGO_ACUERDO = "pago_acuerdo";
	public static final String ACTIVO = "activo";
	public static final String PAGO_LETRADO = "pago_letrado";
	public static final String OID_CONC_PAGO_SECLO = "oid_conc_pago_seclo";
	public static final String PAGO_CONCILIADOR = "pago_conciliador";
	public static final String PAGO_OTROS = "pago_otros";

	public static final int SELECT_BY_SECLO = 100;
	public static final int SELECT_BY_FEC_DES_HAS = 101;

	public DBPagoSeclo() {
	}

	protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_PAGO_SECLO = 1;
		final int OID_SECLO = 2;
		final int FEC_PAGO = 3;
		final int OBSERVACION = 4;
		final int PAGO_ACUERDO = 5;
		final int ACTIVO = 6;
		final int PAGO_LETRADO = 7;
		final int OID_CONC_PAGO_SECLO = 8;
		final int PAGO_CONCILIADOR = 9;
		final int PAGO_OTROS = 10;

		PagoSeclo pers = (PagoSeclo) objetoPersistente;

		StringBuffer sqlInsert = new StringBuffer();
		sqlInsert.append(" insert into legPagoSeclo " + " ( " + "OID_PAGO_SECLO," + "OID_SECLO," + "FEC_PAGO," + "OBSERVACION," + "PAGO_ACUERDO," + "ACTIVO," + "PAGO_LETRADO,"
				+ "OID_CONC_PAGO_SECLO," + "PAGO_CONCILIADOR," + "PAGO_OTROS)" + " values " + "(" + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?) ");

		PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
		qInsert.setInt(OID_PAGO_SECLO, pers.getOID());
		qInsert.setInt(OID_SECLO, pers.getSeclo().getOID());
		qInsert.setDate(FEC_PAGO, new java.sql.Date(pers.getFec_pago().getTime()));
		qInsert.setString(OBSERVACION, pers.getObservacion());
		if (pers.getPago_acuerdo() != null)
			qInsert.setDouble(PAGO_ACUERDO, pers.getPago_acuerdo().doubleValue());
		else
			qInsert.setDouble(PAGO_ACUERDO, 0);
		qInsert.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		if (pers.getPago_letrado() != null)
			qInsert.setDouble(PAGO_LETRADO, pers.getPago_letrado().doubleValue());
		else
			qInsert.setDouble(PAGO_LETRADO, 0);
		qInsert.setInt(OID_CONC_PAGO_SECLO, pers.getConc_pago().getOID());
		if (pers.getPago_conciliador() != null)
			qInsert.setDouble(PAGO_CONCILIADOR, pers.getPago_conciliador().doubleValue());
		else
			qInsert.setDouble(PAGO_CONCILIADOR, 0);
		if (pers.getPago_otros() != null)
			qInsert.setDouble(PAGO_OTROS, pers.getPago_otros().doubleValue());
		else
			qInsert.setDouble(PAGO_OTROS, 0);
		qInsert.executeUpdate();
		qInsert.close();
	}

	protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_SECLO = 1;
		final int FEC_PAGO = 2;
		final int OBSERVACION = 3;
		final int PAGO_ACUERDO = 4;
		final int ACTIVO = 5;
		final int PAGO_LETRADO = 6;
		final int OID_CONC_PAGO_SECLO = 7;
		final int PAGO_CONCILIADOR = 8;
		final int PAGO_OTROS = 9;
		final int OID_PAGO_SECLO = 10;

		PagoSeclo pers = (PagoSeclo) objetoPersistente;

		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append(" update legPagoSeclo set " + "oid_seclo=?" + ",fec_pago=?" + ",observacion=?" + ",pago_acuerdo=?" + ",activo=?" + ",pago_letrado=?" + ",oid_conc_pago_seclo=?"
				+ ",pago_conciliador=?" + ",pago_otros=?" + " where " + " oid_pago_seclo=? ");

		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_PAGO_SECLO, pers.getOID());
		qUpdate.setInt(OID_SECLO, pers.getSeclo().getOID());
		qUpdate.setDate(FEC_PAGO, new java.sql.Date(pers.getFec_pago().getTime()));
		qUpdate.setString(OBSERVACION, pers.getObservacion());
		if (pers.getPago_acuerdo() != null)
			qUpdate.setDouble(PAGO_ACUERDO, pers.getPago_acuerdo().doubleValue());
		else
			qUpdate.setDouble(PAGO_ACUERDO, 0);
		qUpdate.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		if (pers.getPago_letrado() != null)
			qUpdate.setDouble(PAGO_LETRADO, pers.getPago_letrado().doubleValue());
		else
			qUpdate.setDouble(PAGO_LETRADO, 0);
		qUpdate.setInt(OID_CONC_PAGO_SECLO, pers.getConc_pago().getOID());
		if (pers.getPago_conciliador() != null)
			qUpdate.setDouble(PAGO_CONCILIADOR, pers.getPago_conciliador().doubleValue());
		else
			qUpdate.setDouble(PAGO_CONCILIADOR, 0);
		if (pers.getPago_otros() != null)
			qUpdate.setDouble(PAGO_OTROS, pers.getPago_otros().doubleValue());
		else
			qUpdate.setDouble(PAGO_OTROS, 0);
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_PAGO_SECLO = 1;
		PagoSeclo pers = (PagoSeclo) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update legPagoSeclo " + " set activo=0 " + " where " + " oid_pago_seclo=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_PAGO_SECLO, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_PAGO_SECLO = 1;
		PagoSeclo pers = (PagoSeclo) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update legPagoSeclo " + " set activo=1 " + " where " + " oid_pago_seclo=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_PAGO_SECLO, pers.getOID());
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
		case SELECT_BY_SECLO: {
			ps = this.selectByCeclo(aCondiciones);
			break;
		}
		case SELECT_BY_FEC_DES_HAS: {
			ps = this.selectByFecDesHas(aCondiciones);
			break;
		}

		}
		return ps;
	}

	private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

		final int OID_PAGO_SECLO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  legPagoSeclo ");
		textSQL.append(" WHERE oid_pago_seclo = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		int oid = ((Integer) aCondiciones).intValue();
		querySelect.setInt(OID_PAGO_SECLO, oid);
		return querySelect;
	}

	private PreparedStatement selectByFecDesHas(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT a.* FROM  legPagoSeclo a , legSeclos b , suLegajo c ");
		textSQL.append(" WHERE a.fec_pago>=? and a.fec_pago<=? and a.activo = 1 and a.oid_seclo = b.oid_seclo and b.activo = 1 and b.oid_legajo = c.oid_legajo and c.activo = 1 ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		java.util.Date fecDesde = (java.util.Date) condiciones.get("FEC_DESDE");
		java.util.Date fecHasta = (java.util.Date) condiciones.get("FEC_HASTA");
		
		querySelect.setDate(1, new java.sql.Date(fecDesde.getTime()));
		querySelect.setDate(2, new java.sql.Date(fecHasta.getTime()));
		return querySelect;
	}	
	
	private PreparedStatement selectByCeclo(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  legPagoSeclo ");
		textSQL.append(" WHERE oid_seclo  = ? and activo = 1 order by fec_pago desc ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		Seclo seclo = (Seclo) aCondiciones;
		querySelect.setInt(1, seclo.getOID());
		return querySelect;
	}

	private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

		final int CODIGO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  legPagoSeclo ");
		textSQL.append(" WHERE  = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		String codigo = (String) aCondiciones;
		querySelect.setString(CODIGO, codigo);
		return querySelect;
	}

	private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();

		textSQL.append("SELECT oid_pago_seclo oid, codigo, oid_seclo descripcion ,activo ");
		textSQL.append(" from legPagoSeclo");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}

	public static List getPagosSeclo(Seclo aSeclo, ISesion aSesion) throws BaseException {
		return (List) ObjetoLogico.getObjects(PagoSeclo.NICKNAME, DBPagoSeclo.SELECT_BY_SECLO, aSeclo, new ListObserver(), aSesion);
	}
	
	public static List getPagosSeclo(java.util.Date fecDesde, java.util.Date fecHasta, ISesion aSesion) throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put("FEC_DESDE", fecDesde);
		condiciones.put("FEC_HASTA", fecHasta);
		return (List) ObjetoLogico.getObjects(PagoSeclo.NICKNAME, DBPagoSeclo.SELECT_BY_FEC_DES_HAS, condiciones, new ListObserver(), aSesion);
	}	

}
