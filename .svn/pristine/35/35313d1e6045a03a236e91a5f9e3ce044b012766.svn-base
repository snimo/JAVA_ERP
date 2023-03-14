package com.srn.erp.compras.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.compras.bm.AcuerdoLP;
import com.srn.erp.compras.bm.Proveedor;
import com.srn.erp.compras.bm.TipoAcuerdo;
import com.srn.erp.general.bm.ValorClasifEntProdGen;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.ObjetoObservado;

public class DBAcuerdoLP extends DBObjetoPersistente {

	public static final String OID_ACUERDO_LP = "oid_acuerdo_lp";

	public static final String OID_TIPO_ACUERDO = "oid_tipo_acuerdo";

	public static final String OID_PROVEEDOR = "oid_proveedor";

	public static final String VIGENCIA_DESDE = "vigencia_desde";

	public static final String VIGENCIA_HASTA = "vigencia_hasta";

	public static final String ACTIVO = "activo";

	public static final String OID_DEF_ESTRUC_LP_CAB = "oid_def_estruc_lp";

	public static final String DESCRIPCION = "descripcion";

	public static final int SELECT_BY_TIPO_PROVEEDOR = 100;
	public static final int SELECT_BY_PROV_FECHA_TIPO_ACUERDO = 101;
	public static final int SELECT_BY_ACUERDO_PROVEEDOR = 102;
	public static final int SELECT_BY_LP_PROVEEDOR = 103;
	public static final int SELECT_BY_TIPO_ACUERDO_PROVEEDOR = 104;
	public static final int SELECT_BY_ACUERDOS_BY_VAL_CLASIF = 105;

	public DBAcuerdoLP() {
	}

	protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_ACUERDO_LP = 1;
		final int OID_TIPO_ACUERDO = 2;
		final int OID_PROVEEDOR = 3;
		final int ACTIVO = 4;
		final int DESCRIPCION = 5;

		AcuerdoLP pers = (AcuerdoLP) objetoPersistente;

		StringBuffer sqlInsert = new StringBuffer();
		sqlInsert.append(" insert into cpAcuerdosLP " + " ( " + "OID_ACUERDO_LP," + "OID_TIPO_ACUERDO," + "OID_PROVEEDOR,"
				+ "ACTIVO , DESCRIPCION)" + " values " + "(" + "?," + "?," + "?," + "?," + "?) ");

		PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
		qInsert.setInt(OID_ACUERDO_LP, pers.getOID());
		qInsert.setInt(OID_TIPO_ACUERDO, pers.getTipo_acuerdo().getOID());
		qInsert.setInt(OID_PROVEEDOR, pers.getProveedor().getOID());
		qInsert.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		if (pers.getDescripcion() != null)
			qInsert.setString(DESCRIPCION, pers.getDescripcion());
		else
			qInsert.setString(DESCRIPCION, "Sin descripción");
		qInsert.executeUpdate();
		qInsert.close();
	}

	protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_TIPO_ACUERDO = 1;
		final int OID_PROVEEDOR = 2;
		final int ACTIVO = 3;
		final int DESCRIPCION = 4;
		final int OID_ACUERDO_LP = 5;

		AcuerdoLP pers = (AcuerdoLP) objetoPersistente;

		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append(" update cpAcuerdosLP set " + "oid_tipo_acuerdo=?" + ",oid_proveedor=?" + ",activo=? , descripcion = ? "
				+ " where " + " oid_acuerdo_lp=? ");

		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_ACUERDO_LP, pers.getOID());
		qUpdate.setInt(OID_TIPO_ACUERDO, pers.getTipo_acuerdo().getOID());
		qUpdate.setInt(OID_PROVEEDOR, pers.getProveedor().getOID());
		qUpdate.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		if (pers.getDescripcion() != null)
			qUpdate.setString(DESCRIPCION, pers.getDescripcion());
		else
			qUpdate.setString(DESCRIPCION, "Sin descripción");
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_ACUERDO_LP = 1;
		AcuerdoLP pers = (AcuerdoLP) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update cpAcuerdosLP " + " set activo=0 " + " where " + " oid_acuerdo_lp=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_ACUERDO_LP, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_ACUERDO_LP = 1;
		AcuerdoLP pers = (AcuerdoLP) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update cpAcuerdosLP " + " set activo=1 " + " where " + " oid_acuerdo_lp=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_ACUERDO_LP, pers.getOID());
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
		case SELECT_BY_TIPO_PROVEEDOR: {
			ps = this.selectByTipoProveedor(aCondiciones);
			break;
		}
		case SELECT_BY_PROV_FECHA_TIPO_ACUERDO: {
			ps = this.selectByProvFechaTipoAcuerdo(aCondiciones);
			break;
		}
		case SELECT_BY_ACUERDO_PROVEEDOR: {
			ps = this.selectByAcuerdoProveedor(aCondiciones);
			break;
		}
		case SELECT_BY_LP_PROVEEDOR: {
			ps = this.selectByLPProveedor(aCondiciones);
			break;
		}
		case SELECT_BY_TIPO_ACUERDO_PROVEEDOR: {
			ps = this.selectByTipoAcuerdoyProveedor(aCondiciones);
			break;
		}
		case SELECT_BY_ACUERDOS_BY_VAL_CLASIF: {
			ps = this.selectByAcuerdosByValClasif(aCondiciones);
			break;
		}
		}
		return ps;
	}

	private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

		final int OID_ACUERDO_LP = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cpAcuerdosLP ");
		textSQL.append(" WHERE oid_acuerdo_lp = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		int oid = ((Integer) aCondiciones).intValue();
		querySelect.setInt(OID_ACUERDO_LP, oid);
		return querySelect;
	}
	
	private PreparedStatement selectByAcuerdosByValClasif(Object aCondiciones) throws BaseException, SQLException {
		ValorClasifEntProdGen valClasifEntProdGrla = (ValorClasifEntProdGen) aCondiciones;
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT a.* FROM  cpAcuerdosLP a where a.activo=1 ");
		textSQL.append(" and a.oid_acuerdo_lp in ");
		textSQL.append(" (select b.oid_acuerdo_lp from cpPrecPorClasifArt b where b.activo=1 and b.oid_val_clasif_art="+valClasifEntProdGrla.getOIDInteger()+" )"); 
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;

	}
	

	private PreparedStatement selectByTipoAcuerdoyProveedor(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cpAcuerdosLP where activo=1 ");

		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		Proveedor proveedor = (Proveedor) condiciones.get(Proveedor.NICKNAME);
		if (proveedor != null)
			textSQL.append(" and oid_proveedor=" + proveedor.getOIDInteger().toString());

		TipoAcuerdo tipoAcuerdo = (TipoAcuerdo) condiciones.get(TipoAcuerdo.NICKNAME);
		if (tipoAcuerdo != null)
			textSQL.append(" and oid_tipo_acuerdo=" + tipoAcuerdo.getOIDInteger().toString());
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;

	}

	private PreparedStatement selectByTipoProveedor(Object aCondiciones) throws BaseException, SQLException {

		final int OID_ACUERDO_LP = 1;
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cpAcuerdosLP where 1=1 ");

		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		Proveedor proveedor = (Proveedor) condiciones.get(Proveedor.NICKNAME);
		if (proveedor != null)
			textSQL.append(" and oid_proveedor=" + proveedor.getOIDInteger().toString());

		TipoAcuerdo tipoAcuerdo = (TipoAcuerdo) condiciones.get(TipoAcuerdo.NICKNAME);
		if (tipoAcuerdo != null)
			textSQL.append(" and oid_tipo_acuerdo=" + tipoAcuerdo.getOIDInteger().toString());
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;

	}

	private PreparedStatement selectByAcuerdoProveedor(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT a.* FROM  cpAcuerdosLP a , cpTiposAcuerdos b where a.oid_tipo_acuerdo=b.oid_tipo_acuerdo and a.activo=1 ");

		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		Proveedor proveedor = (Proveedor) condiciones.get(Proveedor.NICKNAME);
		textSQL.append(" and a.oid_proveedor=" + proveedor.getOIDInteger().toString());

		textSQL.append(" and b.tipo_acuerdo = 'ACUERDO' ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;

	}

	private PreparedStatement selectByLPProveedor(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT a.* FROM  cpAcuerdosLP a , cpTiposAcuerdos b where a.oid_tipo_acuerdo=b.oid_tipo_acuerdo and a.activo=1 ");

		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		Proveedor proveedor = (Proveedor) condiciones.get(Proveedor.NICKNAME);
		textSQL.append(" and a.oid_proveedor=" + proveedor.getOIDInteger().toString());

		textSQL.append(" and b.tipo_acuerdo = 'LP' ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;

	}

	private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cpAcuerdosLP ");
		textSQL.append(" WHERE descripcion = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		String codigo = (String) aCondiciones;
		querySelect.setString(1, codigo);
		return querySelect;
	}

	private PreparedStatement selectByProvFechaTipoAcuerdo(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();

		textSQL.append(" select * ");
		textSQL.append(" from cpAcuerdosLP where oid_proveedor = ? ");
		textSQL.append(" and ?>=vigencia_desde and ?<=vigencia_hasta");
		textSQL.append(" and oid_tipo_acuerdo in (select oid_tipo_acuerdo from cpTiposAcuerdos where tipo_acuerdo=?) ");

		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		Proveedor proveedor = (Proveedor) condiciones.get(Proveedor.NICKNAME);
		java.util.Date fecha = (java.util.Date) condiciones.get("FECHA");
		String tipoAcuerdo = (String) condiciones.get("TIPO_ACUERDO");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		querySelect.setInt(1, proveedor.getOID());
		querySelect.setDate(2, new java.sql.Date(fecha.getTime()));
		querySelect.setDate(3, new java.sql.Date(fecha.getTime()));
		querySelect.setString(4, tipoAcuerdo);
		return querySelect;
	}

	private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();

		textSQL.append("SELECT oid_acuerdo_lp oid, codigo,  descripcion ,activo ");
		textSQL.append(" from cpAcuerdosLP");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}

	public static List getAcuerdosLP(Proveedor proveedor, TipoAcuerdo tipoAcuerdo, ISesion aSesion) throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		if (proveedor != null)
			condiciones.put(Proveedor.NICKNAME, proveedor);
		if (tipoAcuerdo != null)
			condiciones.put(TipoAcuerdo.NICKNAME, tipoAcuerdo);
		return (List) ObjetoLogico.getObjects(AcuerdoLP.NICKNAME, DBAcuerdoLP.SELECT_BY_TIPO_PROVEEDOR, condiciones, new ListObserver(),
				aSesion);
	}

	public static List getAcuerdosLP(Proveedor proveedor, String tipoAcuerdo, java.util.Date fecha, ISesion aSesion) throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put(Proveedor.NICKNAME, proveedor);
		condiciones.put("FECHA", fecha);
		condiciones.put("TIPO_ACUERDO", tipoAcuerdo);

		return (List) ObjetoLogico.getObjects(AcuerdoLP.NICKNAME, DBAcuerdoLP.SELECT_BY_PROV_FECHA_TIPO_ACUERDO, condiciones,
				new ListObserver(), aSesion);
	}
	
	public static List getAcuerdosLPByValClasifEntProd(ValorClasifEntProdGen valorClasifEntProdGral, ISesion aSesion) throws BaseException {
		return (List) ObjetoLogico.getObjects(AcuerdoLP.NICKNAME, DBAcuerdoLP.SELECT_BY_ACUERDOS_BY_VAL_CLASIF, valorClasifEntProdGral,
				new ListObserver(), aSesion);
	}
	

	public static AcuerdoLP getAcuedoProveedor(Proveedor proveedor, ISesion aSesion) throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put(Proveedor.NICKNAME, proveedor);
		return (AcuerdoLP) ObjetoLogico.getObjects(AcuerdoLP.NICKNAME, DBAcuerdoLP.SELECT_BY_ACUERDO_PROVEEDOR, condiciones,
				new ObjetoObservado(), aSesion);
	}

	public static AcuerdoLP getListaDePreciosProveedor(Proveedor proveedor, ISesion aSesion) throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put(Proveedor.NICKNAME, proveedor);
		return (AcuerdoLP) ObjetoLogico.getObjects(AcuerdoLP.NICKNAME, DBAcuerdoLP.SELECT_BY_LP_PROVEEDOR, condiciones,
				new ObjetoObservado(), aSesion);
	}

	public static AcuerdoLP getAcuerdoLP(Proveedor proveedor, TipoAcuerdo tipoAcuerdo, ISesion aSesion) throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put(Proveedor.NICKNAME, proveedor);
		condiciones.put(TipoAcuerdo.NICKNAME, tipoAcuerdo);
		return (AcuerdoLP) ObjetoLogico.getObjects(AcuerdoLP.NICKNAME, DBAcuerdoLP.SELECT_BY_TIPO_ACUERDO_PROVEEDOR, condiciones,
				new ObjetoObservado(), aSesion);
	}

}
