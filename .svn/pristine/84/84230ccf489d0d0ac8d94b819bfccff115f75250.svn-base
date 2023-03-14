package com.srn.erp.compras.da;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.compras.bm.InformeControlCalidad;
import com.srn.erp.compras.bm.InformeRecepcion;
import com.srn.erp.compras.bm.Proveedor;
import com.srn.erp.general.bm.Talonario;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;

public class DBInformeControlCalidad extends DBObjetoPersistente {

	public static final String OID_CC = "oid_cc";

	public static final int SELECT_BY_CONDICIONES = 100;

	public DBInformeControlCalidad() {
	}

	protected void insert(IObjetoPersistente objetoPersistente)
			throws BaseException, SQLException {

		final int OID_CC = 1;

		InformeControlCalidad pers = (InformeControlCalidad) objetoPersistente;

		StringBuffer sqlInsert = new StringBuffer();
		sqlInsert.append(" insert into cpCtrlCalidad " + " ( " + "OID_CC)"
				+ " values " + "(" + "?) ");

		PreparedStatement qInsert = getSesion().getConexionBD()
				.prepareStatement(sqlInsert.toString());
		qInsert.setInt(OID_CC, pers.getOID());
		qInsert.executeUpdate();
		qInsert.close();
	}

	protected void update(IObjetoPersistente objetoPersistente)
			throws BaseException, SQLException {

	}

	protected void delete(IObjetoPersistente objetoPersistente)
			throws BaseException, SQLException {
		final int OID_CC = 1;
		InformeControlCalidad pers = (InformeControlCalidad) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update geComproCab  " + " set activo=0 " + " where "
				+ " oid_cco=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD()
				.prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_CC, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void rehabilitar(IObjetoPersistente objetoPersistente)
			throws BaseException, SQLException {
		final int OID_CC = 1;
		InformeControlCalidad pers = (InformeControlCalidad) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update cpCtrlCalidad " + " set activo=1 " + " where "
				+ " oid_cc=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD()
				.prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_CC, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	public PreparedStatement prepararSelect(int aSelect, Object aCondiciones)
			throws BaseException, SQLException {
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
		}
		return ps;
	}

	private PreparedStatement selectByOID(Object aCondiciones)
			throws BaseException, SQLException {

		final int OID_CC = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT a.*,b.* FROM  cpCtrlCalidad a, geComproCab b");
		textSQL.append(" WHERE b.oid_cco = a.oid_cc and a.oid_cc = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD()
				.prepareStatement(textSQL.toString());
		int oid = ((Integer) aCondiciones).intValue();
		querySelect.setInt(OID_CC, oid);
		return querySelect;
	}

	private PreparedStatement selectByCondiciones(Object aCondiciones)
			throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();
		textSQL
				.append("SELECT a.*,b.* FROM  cpCtrlCalidad a, geComproCab b where a.oid_cc = b.oid_cco ");
		textSQL.append(" and 1=1 ");
		HashTableDatos condiciones = (HashTableDatos) aCondiciones;

		InformeRecepcion infRec = (InformeRecepcion) condiciones
				.get(InformeRecepcion.NICKNAME);
		if (infRec != null)
			textSQL
					.append("  and a.oid_cc in (select oid_cc from cpCtrlCalidadDet where oid_inf_rec_det in "
							+ " (select oid_inf_rec_det from cpInfRecepDet where oid_inf_rec ="
							+ infRec.getOIDInteger().toString() + ")) ");

		if (condiciones.containsKey(Proveedor.NICKNAME)) {
			Proveedor proveedor = (Proveedor) condiciones
					.get(Proveedor.NICKNAME);
			if (infRec != null)
				textSQL
						.append("  and a.oid_cc in (select oid_cc from cpCtrlCalidadDet where oid_inf_rec_det in "
								+ " (select c.oid_inf_rec_det from cpInfRecepDet c,cpInfRecep d where c.oid_inf_rec = d.oid_inf_rec and d.oid_proveedor ="
								+ proveedor.getOIDInteger().toString() + ")) ");
		}

		if (condiciones.containsKey(Talonario.NICKNAME)) {
			Talonario talonario = (Talonario) condiciones
					.get(Talonario.NICKNAME);
			textSQL.append(" and b.oid_talonario = "
					+ talonario.getOIDInteger().toString());
		}

		if (condiciones.containsKey("NRO_DESDE")) {
			Integer nroExt = (Integer) condiciones.get("NRO_DESDE");
			textSQL.append(" and b.nro_ext >= " + nroExt.toString());
		}

		if (condiciones.containsKey("NRO_HASTA")) {
			Integer nroExt = (Integer) condiciones.get("NRO_HASTA");
			textSQL.append(" and b.nro_ext <= " + nroExt.toString());
		}

		if (condiciones.containsKey("FEC_DESDE"))
			textSQL.append(" and b.imputac >= ? ");

		if (condiciones.containsKey("FEC_HASTA"))
			textSQL.append(" and b.imputac <= ? ");

		int nroParam = 0;

		PreparedStatement querySelect = getSesion().getConexionBD()
				.prepareStatement(textSQL.toString());

		if (condiciones.containsKey("FEC_DESDE")) {
			java.util.Date fecha = (java.util.Date) condiciones
					.get("FEC_DESDE");
			++nroParam;
			querySelect.setDate(nroParam, new Date(fecha.getTime()));
		}

		if (condiciones.containsKey("FEC_HASTA")) {
			java.util.Date fecha = (java.util.Date) condiciones
					.get("FEC_HASTA");
			++nroParam;
			querySelect.setDate(nroParam, new Date(fecha.getTime()));
		}

		return querySelect;
	}

	private PreparedStatement selectByCodigo(Object aCondiciones)
			throws BaseException, SQLException {

		final int CODIGO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cpCtrlCalidad ");
		textSQL.append(" WHERE  = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD()
				.prepareStatement(textSQL.toString());
		String codigo = (String) aCondiciones;
		querySelect.setString(CODIGO, codigo);
		return querySelect;
	}

	private PreparedStatement selectAllHelp(Object aCondiciones)
			throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();

		textSQL.append("SELECT oid_cc oid, codigo,  descripcion ,activo ");
		textSQL.append(" from cpCtrlCalidad");

		PreparedStatement querySelect = getSesion().getConexionBD()
				.prepareStatement(textSQL.toString());
		return querySelect;
	}

	public static List getInformesCC(HashTableDatos aCondiciones,
			ISesion aSesion) throws BaseException {
		return (List) ObjetoLogico.getObjects(InformeControlCalidad.NICKNAME,
				DBInformeControlCalidad.SELECT_BY_CONDICIONES, aCondiciones,
				new ListObserver(), aSesion);
	}

}
