package com.srn.erp.compras.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.compras.bm.OtrasDireccionesProveedor;
import com.srn.erp.compras.bm.Proveedor;
import com.srn.erp.general.bm.PeriodoInc;
import com.srn.erp.general.bm.PeriodoIncDet;
import com.srn.erp.general.da.DBPeriodoIncDet;
import com.srn.erp.ventas.bm.Sujeto;
import com.srn.erp.ventas.bm.UnidadEdilicia;
import com.srn.erp.ventas.da.DBUnidadEdilicia;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.Utils.ObjetoObservado;

public class DBOtrasDireccionesProveedor extends DBObjetoPersistente {

	public static final String OID_DIRECCION = "oid_direccion";
	public static final String OID_PROVEEDOR = "oid_proveedor";
	public static final String CODIGO = "codigo";
	public static final String CALLE_Y_NRO = "calle_y_nro";
	public static final String LOCALIDAD = "localidad";
	public static final String CODIGO_POSTAL = "codigo_postal";
	public static final String OID_TIPO_UNIDAD = "oid_tipo_unidad";
	public static final String TELEFONOS = "telefonos";
	public static final String OID_PROVINCIA = "oid_provincia";
	public static final String CONTACTO = "contacto";
	public static final String OID_PAIS = "oid_pais";
	public static final String ACTIVO = "activo";
	public static final String DOM_DEV_MERCADERIA = "dom_dev_mercaderia";

	public static final int SELECT_BY_PROVEEDOR = 100;
	public static final int SELECT_BY_CODIGO_PROVEEDOR = 101;

	public DBOtrasDireccionesProveedor() {
	}

	protected void insert(IObjetoPersistente objetoPersistente)
			throws BaseException, SQLException {

		final int OID_DIRECCION = 1;
		final int OID_PROVEEDOR = 2;
		final int CODIGO = 3;
		final int CALLE_Y_NRO = 4;
		final int LOCALIDAD = 5;
		final int CODIGO_POSTAL = 6;
		final int OID_TIPO_UNIDAD = 7;
		final int TELEFONOS = 8;
		final int OID_PROVINCIA = 9;
		final int CONTACTO = 10;
		final int OID_PAIS = 11;
		final int ACTIVO = 12;
		final int DOM_DEV_MERCADERIA = 13;

		OtrasDireccionesProveedor pers = (OtrasDireccionesProveedor) objetoPersistente;

		StringBuffer sqlInsert = new StringBuffer();
		sqlInsert.append(" insert into cpOtrasDirecProv " + " ( "
				+ "OID_DIRECCION," + "OID_PROVEEDOR," + "CODIGO,"
				+ "CALLE_Y_NRO," + "LOCALIDAD," + "CODIGO_POSTAL,"
				+ "OID_TIPO_UNIDAD," + "TELEFONOS," + "OID_PROVINCIA,"
				+ "CONTACTO," + "OID_PAIS," + "ACTIVO," + "DOM_DEV_MERCADERIA)"
				+ " values " + "(" + "?," + "?," + "?," + "?," + "?," + "?,"
				+ "?," + "?," + "?," + "?," + "?," + "?," + "?) ");

		PreparedStatement qInsert = getSesion().getConexionBD()
				.prepareStatement(sqlInsert.toString());
		qInsert.setInt(OID_DIRECCION, pers.getOID());
		qInsert.setInt(OID_PROVEEDOR, pers.getProveedor().getOID());
		qInsert.setString(CODIGO, pers.getCodigo());
		qInsert.setString(CALLE_Y_NRO, pers.getCalle_y_nro());
		qInsert.setString(LOCALIDAD, pers.getLocalidad());
		qInsert.setString(CODIGO_POSTAL, pers.getCodigo_postal());
		qInsert.setInt(OID_TIPO_UNIDAD, pers.getTipo_unidad().getOID());
		qInsert.setString(TELEFONOS, pers.getTelefonos());
		if (pers.getProvincia() != null)
			qInsert.setInt(OID_PROVINCIA, pers.getProvincia().getOID());
		else
			qInsert.setNull(OID_PROVINCIA, java.sql.Types.INTEGER);
		qInsert.setString(CONTACTO, pers.getContacto());
		if (pers.getPais() != null)
			qInsert.setInt(OID_PAIS, pers.getPais().getOID());
		else
			qInsert.setNull(OID_PAIS, java.sql.Types.INTEGER);
		qInsert.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		qInsert.setBoolean(DOM_DEV_MERCADERIA, pers.isDom_dev_mercaderia()
				.booleanValue());
		qInsert.executeUpdate();
		qInsert.close();
	}

	protected void update(IObjetoPersistente objetoPersistente)
			throws BaseException, SQLException {

		final int OID_PROVEEDOR = 1;
		final int CODIGO = 2;
		final int CALLE_Y_NRO = 3;
		final int LOCALIDAD = 4;
		final int CODIGO_POSTAL = 5;
		final int OID_TIPO_UNIDAD = 6;
		final int TELEFONOS = 7;
		final int OID_PROVINCIA = 8;
		final int CONTACTO = 9;
		final int OID_PAIS = 10;
		final int ACTIVO = 11;
		final int DOM_DEV_MERCADERIA = 12;
		final int OID_DIRECCION = 13;

		OtrasDireccionesProveedor pers = (OtrasDireccionesProveedor) objetoPersistente;

		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append(" update cpOtrasDirecProv set " + "oid_proveedor=?"
				+ ",codigo=?" + ",calle_y_nro=?" + ",localidad=?"
				+ ",codigo_postal=?" + ",oid_tipo_unidad=?" + ",telefonos=?"
				+ ",oid_provincia=?" + ",contacto=?" + ",oid_pais=?"
				+ ",activo=?" + ",dom_dev_mercaderia=?" + " where "
				+ " oid_direccion=? ");

		PreparedStatement qUpdate = getSesion().getConexionBD()
				.prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_DIRECCION, pers.getOID());
		qUpdate.setInt(OID_PROVEEDOR, pers.getProveedor().getOID());
		qUpdate.setString(CODIGO, pers.getCodigo());
		qUpdate.setString(CALLE_Y_NRO, pers.getCalle_y_nro());
		qUpdate.setString(LOCALIDAD, pers.getLocalidad());
		qUpdate.setString(CODIGO_POSTAL, pers.getCodigo_postal());
		qUpdate.setInt(OID_TIPO_UNIDAD, pers.getTipo_unidad().getOID());
		qUpdate.setString(TELEFONOS, pers.getTelefonos());
		if (pers.getProvincia() != null)
			qUpdate.setInt(OID_PROVINCIA, pers.getProvincia().getOID());
		else
			qUpdate.setNull(OID_PROVINCIA, java.sql.Types.INTEGER);
		qUpdate.setString(CONTACTO, pers.getContacto());
		if (pers.getPais() != null)
			qUpdate.setInt(OID_PAIS, pers.getPais().getOID());
		else
			qUpdate.setNull(OID_PAIS, java.sql.Types.INTEGER);
		qUpdate.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		qUpdate.setBoolean(DOM_DEV_MERCADERIA, pers.isDom_dev_mercaderia()
				.booleanValue());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void delete(IObjetoPersistente objetoPersistente)
			throws BaseException, SQLException {
		final int OID_DIRECCION = 1;
		OtrasDireccionesProveedor pers = (OtrasDireccionesProveedor) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("delete from cpOtrasDirecProv " + " where "
				+ " oid_direccion=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD()
				.prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_DIRECCION, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void rehabilitar(IObjetoPersistente objetoPersistente)
			throws BaseException, SQLException {
		final int OID_DIRECCION = 1;
		OtrasDireccionesProveedor pers = (OtrasDireccionesProveedor) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update cpOtrasDirecProv " + " set activo=1 "
				+ " where " + " oid_direccion=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD()
				.prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_DIRECCION, pers.getOID());
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
		case SELECT_BY_PROVEEDOR: {
			ps = this.selectByProveedor(aCondiciones);
			break;
		}
		case SELECT_BY_CODIGO_PROVEEDOR: {
			ps = this.selectByCodigoYProveedor(aCondiciones);
			break;
		}

		}
		return ps;
	}

	private PreparedStatement selectByOID(Object aCondiciones)
			throws BaseException, SQLException {

		final int OID_DIRECCION = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cpOtrasDirecProv ");
		textSQL.append(" WHERE oid_direccion = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD()
				.prepareStatement(textSQL.toString());
		int oid = ((Integer) aCondiciones).intValue();
		querySelect.setInt(OID_DIRECCION, oid);
		return querySelect;
	}

	private PreparedStatement selectByCodigo(Object aCondiciones)
			throws BaseException, SQLException {

		final int CODIGO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cpOtrasDirecProv ");
		textSQL.append(" WHERE  = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD()
				.prepareStatement(textSQL.toString());
		String codigo = (String) aCondiciones;
		querySelect.setString(CODIGO, codigo);
		return querySelect;
	}

	private PreparedStatement selectByProveedor(Object aCondiciones)
			throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cpOtrasDirecProv ");
		textSQL.append(" WHERE oid_proveedor = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD()
				.prepareStatement(textSQL.toString());
		Proveedor proveedor = (Proveedor) aCondiciones;
		querySelect.setInt(1, proveedor.getOID());
		return querySelect;
	}

	private PreparedStatement selectAllHelp(Object aCondiciones)
			throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();

		textSQL
				.append("SELECT oid_direccion oid, codigo,  descripcion ,activo ");
		textSQL.append(" from cpOtrasDirecProv");

		PreparedStatement querySelect = getSesion().getConexionBD()
				.prepareStatement(textSQL.toString());
		return querySelect;
	}

	public static List getOtrasDireccionesProveedor(Proveedor proveedor,
			ISesion aSesion) throws BaseException {
		return (List) ObjetoLogico.getObjects(
				OtrasDireccionesProveedor.NICKNAME,
				DBOtrasDireccionesProveedor.SELECT_BY_PROVEEDOR, proveedor,
				new ListObserver(), aSesion);
	}

	private PreparedStatement selectByCodigoYProveedor(Object aCondiciones)
			throws BaseException, SQLException {
		MapDatos mapaDatos = (MapDatos) aCondiciones;
		String codigo = mapaDatos.getString("codigo");
		Integer oidSujAlta = mapaDatos.getInteger("oid_proveedor");
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cpOtrasDirecProv ");
		textSQL.append(" WHERE codigo = ? and oid_proveedor = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD()
				.prepareStatement(textSQL.toString());
		querySelect.setString(1, codigo);
		querySelect.setInt(2, oidSujAlta.intValue());
		return querySelect;
	}

	public static OtrasDireccionesProveedor getOtrasDireccionesProveedor(
			String codigo, Proveedor proveedor, ISesion aSesion)
			throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put("codigo", codigo);
		condiciones.put("oid_proveedor", proveedor.getOIDInteger() + "");
		return (OtrasDireccionesProveedor) ObjetoLogico.getObjects(
				OtrasDireccionesProveedor.NICKNAME,
				DBOtrasDireccionesProveedor.SELECT_BY_CODIGO_PROVEEDOR,
				condiciones, new ObjetoObservado(), aSesion);
	}

}
