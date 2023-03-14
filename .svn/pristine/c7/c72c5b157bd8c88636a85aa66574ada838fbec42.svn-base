package com.srn.erp.ventas.da;

import java.sql.*;
import java.util.List;

import com.srn.erp.ventas.bm.*;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.*;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.*;

public class DBCotizacionTotal extends DBObjetoPersistente {

	public static final String	OID_COTIZ_TOTAL				= "oid_cotiz_total";

	public static final String	OID_COTIZ_CAB					= "oid_cotiz_cab";

	public static final String	OID_CONC_IMPU					= "oid_conc_impu";

	public static final String	SECU									= "secu";

	public static final String	COMPORTAMIENTO				= "comportamiento";

	public static final String	CONCEPTO							= "concepto";

	public static final String	IMPORTE								= "importe";

	public static final int			SELECT_BY_COTIZACION	= 100;

	public DBCotizacionTotal() {
	}

	protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_COTIZ_TOTAL = 1;
		final int OID_COTIZ_CAB = 2;
		final int OID_CONC_IMPU = 3;
		final int SECU = 4;
		final int COMPORTAMIENTO = 5;
		final int CONCEPTO = 6;
		final int IMPORTE = 7;

		CotizacionTotal pers = (CotizacionTotal) objetoPersistente;

		StringBuffer sqlInsert = new StringBuffer();
		sqlInsert.append(" insert into veCotizTotales " + " ( " + "OID_COTIZ_TOTAL," + "OID_COTIZ_CAB," + "OID_CONC_IMPU,"
				+ "SECU," + "COMPORTAMIENTO," + "CONCEPTO," + "IMPORTE)" + " values " + "(" + "?," + "?," + "?," + "?," + "?,"
				+ "?," + "?) ");

		PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
		qInsert.setInt(OID_COTIZ_TOTAL, pers.getOID());
		qInsert.setInt(OID_COTIZ_CAB, pers.getCotizacioncab().getOID());
		if (pers.getConceptoimpuesto() != null)
			qInsert.setInt(OID_CONC_IMPU, pers.getConceptoimpuesto().getOID());
		else
			qInsert.setNull(OID_CONC_IMPU, java.sql.Types.INTEGER);
		qInsert.setInt(SECU, pers.getSecu().intValue());
		qInsert.setString(COMPORTAMIENTO, pers.getComportamiento());
		qInsert.setString(CONCEPTO, pers.getConcepto());
		qInsert.setDouble(IMPORTE, pers.getImporte().doubleValue());
		qInsert.executeUpdate();
		qInsert.close();
	}

	protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_COTIZ_CAB = 1;
		final int OID_CONC_IMPU = 2;
		final int SECU = 3;
		final int COMPORTAMIENTO = 4;
		final int CONCEPTO = 5;
		final int IMPORTE = 6;
		final int OID_COTIZ_TOTAL = 7;

		CotizacionTotal pers = (CotizacionTotal) objetoPersistente;

		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append(" update veCotizTotales set " + "oid_cotiz_cab=?" + ",oid_conc_impu=?" + ",secu=?"
				+ ",comportamiento=?" + ",concepto=?" + ",importe=?" + " where " + " oid_cotiz_total=? ");

		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_COTIZ_TOTAL, pers.getOID());
		qUpdate.setInt(OID_COTIZ_CAB, pers.getCotizacioncab().getOID());
		if (pers.getConceptoimpuesto() != null)
			qUpdate.setInt(OID_CONC_IMPU, pers.getConceptoimpuesto().getOID());
		else
			qUpdate.setNull(OID_CONC_IMPU, java.sql.Types.INTEGER);
		qUpdate.setInt(SECU, pers.getSecu().intValue());
		qUpdate.setString(COMPORTAMIENTO, pers.getComportamiento());
		qUpdate.setString(CONCEPTO, pers.getConcepto());
		qUpdate.setDouble(IMPORTE, pers.getImporte().doubleValue());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_COTIZ_TOTAL = 1;
		CotizacionTotal pers = (CotizacionTotal) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("delete from veCotizTotales where oid_cotiz_total=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_COTIZ_TOTAL, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_COTIZ_TOTAL = 1;
		CotizacionTotal pers = (CotizacionTotal) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update veCotizTotales " + " set activo=1 " + " where " + " oid_cotiz_total=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_COTIZ_TOTAL, pers.getOID());
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
		case SELECT_BY_COTIZACION: {
			ps = this.selectByCotizacion(aCondiciones);
			break;
		}
		}
		return ps;
	}

	private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

		final int OID_COTIZ_TOTAL = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  veCotizTotales ");
		textSQL.append(" WHERE oid_cotiz_total = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		int oid = ((Integer) aCondiciones).intValue();
		querySelect.setInt(OID_COTIZ_TOTAL, oid);
		return querySelect;
	}

	private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

		final int CODIGO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  veCotizTotales ");
		textSQL.append(" WHERE  = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		String codigo = (String) aCondiciones;
		querySelect.setString(CODIGO, codigo);
		return querySelect;
	}

	private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();

		textSQL.append("SELECT oid_cotiz_total oid, codigo,  descripcion ,activo ");
		textSQL.append(" from veCotizTotales");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}

	private PreparedStatement selectByCotizacion(Object aCondiciones) throws BaseException, SQLException {
		CotizacionCab cotizacionCab = (CotizacionCab) aCondiciones;
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  veCotizTotales ");
		textSQL.append(" WHERE  oid_cotiz_cab = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		querySelect.setInt(1, cotizacionCab.getOID());
		return querySelect;
	}

	public static List getDetallesByCotizacion(CotizacionCab cotizacion, ISesion aSesion) throws BaseException {
		return (List) ObjetoLogico.getObjects(CotizacionTotal.NICKNAME, DBCotizacionTotal.SELECT_BY_COTIZACION, cotizacion,
				new ListObserver(), aSesion);
	}
	

}
