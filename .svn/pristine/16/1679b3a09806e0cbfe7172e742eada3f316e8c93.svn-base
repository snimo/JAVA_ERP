package com.srn.erp.compras.da;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.compras.bm.InformeRecepcion;
import com.srn.erp.compras.bm.OrdenDeCompraCab;
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
import framework.request.bl.Utils.ObjetoObservado;

public class DBInformeRecepcion extends DBObjetoPersistente {

	public static final String OID_INF_REC = "oid_inf_rec";

	public static final String REMITO_PROV = "remito_prov";

	public static final String OID_PROVEEDOR = "oid_proveedor";
	
	public static final String OID_CCO_FACT_PROV = "oid_cco_fact_prov";
	
	public static final String REFERENCIA = "referencia";
	
	public static final String TIPO = "tipo";

	public static final int SELECT_BY_CONDICIONES = 100;
	public static final int SELECT_BY_INF_REC_PEND_FACTURAR = 101;
	public static final int SELECT_BY_NRO_PROV = 102;

	public DBInformeRecepcion() {
	}

	protected void insert(IObjetoPersistente objetoPersistente)
			throws BaseException, SQLException {

		final int OID_INF_REC = 1;
		final int REMITO_PROV = 2;
		final int OID_PROVEEDOR = 3;
		final int OID_CCO_FACT_PROV = 4;
		final int REFERENCIA = 5;
		final int TIPO = 6;

		InformeRecepcion pers = (InformeRecepcion) objetoPersistente;

		StringBuffer sqlInsert = new StringBuffer();
		sqlInsert.append(" insert into cpInfRecep " + " ( " + "OID_INF_REC,"
				+ "REMITO_PROV," + "OID_PROVEEDOR , OID_CCO_FACT_PROV , REFERENCIA , TIPO)" + " values " + "(" + "?,"
				+ "?,"+ "?,"+ "?,"+ "?," + "?) ");

		PreparedStatement qInsert = getSesion().getConexionBD()
				.prepareStatement(sqlInsert.toString());
		qInsert.setInt(OID_INF_REC, pers.getOID());
		qInsert.setString(REMITO_PROV, pers.getRemito_prov());
		if (pers.getProveedor()!=null)
			qInsert.setInt(OID_PROVEEDOR, pers.getProveedor().getOID());
		else
			qInsert.setInt(OID_PROVEEDOR, java.sql.Types.INTEGER);
		if (pers.getComproProveedor()!=null)
			qInsert.setInt(OID_CCO_FACT_PROV, pers.getComproProveedor().getOID());
		else
			qInsert.setNull(OID_CCO_FACT_PROV, java.sql.Types.INTEGER);
		if (pers.getReferencia()!=null)
			qInsert.setString(REFERENCIA, pers.getReferencia());
		else
			qInsert.setNull(REFERENCIA, java.sql.Types.VARCHAR);
		qInsert.setString(TIPO, pers.getTipo());
		
		qInsert.executeUpdate();
		qInsert.close();
	}

	protected void update(IObjetoPersistente objetoPersistente)
			throws BaseException, SQLException {

		final int REMITO_PROV = 1;
		final int OID_PROVEEDOR = 2;
		final int OID_CCO_FACT_PROV = 3;
		final int REFERENCIA = 4;
		final int TIPO = 5;
		final int OID_INF_REC = 6;

		InformeRecepcion pers = (InformeRecepcion) objetoPersistente;

		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append(" update cpInfRecep set "
				+ "remito_prov=?,oid_proveedor=? , oid_cco_fact_prov = ? , referencia = ? , tipo = ? " + " where "
				+ " oid_inf_rec=? ");

		PreparedStatement qUpdate = getSesion().getConexionBD()
				.prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_INF_REC, pers.getOID());
		if (pers.getProveedor()!=null)
			qUpdate.setInt(OID_PROVEEDOR, pers.getProveedor().getOID());
		else
			qUpdate.setNull(OID_PROVEEDOR, java.sql.Types.INTEGER);
		qUpdate.setString(REMITO_PROV, pers.getRemito_prov());
		if (pers.getComproProveedor()!=null)
			qUpdate.setInt(OID_CCO_FACT_PROV, pers.getComproProveedor().getOID());
		else
			qUpdate.setNull(OID_CCO_FACT_PROV, java.sql.Types.INTEGER);
		if (pers.getReferencia()!=null)
			qUpdate.setString(REFERENCIA, pers.getReferencia());
		else
			qUpdate.setNull(REFERENCIA, java.sql.Types.VARCHAR);
		qUpdate.setString(TIPO, pers.getTipo());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void delete(IObjetoPersistente objetoPersistente)
			throws BaseException, SQLException {
		final int OID_INF_REC = 1;
		InformeRecepcion pers = (InformeRecepcion) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update geComproCab  " + " set activo=0 " + " where "
				+ " oid_cco=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD()
				.prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_INF_REC, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void rehabilitar(IObjetoPersistente objetoPersistente)
			throws BaseException, SQLException {
		final int OID_INF_REC = 1;
		InformeRecepcion pers = (InformeRecepcion) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update geComproCab " + " set activo=1 " + " where "
				+ " oid_cco=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD()
				.prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_INF_REC, pers.getOID());
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
		case IDBObjetoPersistente.SELECT_ALL: {
			ps = this.selectAll(aCondiciones);
			break;
		}
		case SELECT_BY_CONDICIONES: {
			ps = this.selectByCondiciones(aCondiciones);
			break;
		}
		case SELECT_BY_INF_REC_PEND_FACTURAR: {
			ps = this.selectByInfRecPendFact(aCondiciones);
			break;		
		}
		case SELECT_BY_NRO_PROV: {
			ps = this.selectByNroProv(aCondiciones);
			break;		
		}
		}
		return ps;
	}

	private PreparedStatement selectByOID(Object aCondiciones)
			throws BaseException, SQLException {
		final int OID_INF_REC = 1;
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cpInfRecep a, geComproCab b ");
		textSQL
				.append(" WHERE a.oid_inf_rec = b.oid_cco and a.oid_inf_rec = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD()
				.prepareStatement(textSQL.toString());
		int oid = ((Integer) aCondiciones).intValue();
		querySelect.setInt(OID_INF_REC, oid);
		return querySelect;
	}

	private PreparedStatement selectByNroProv(Object aCondiciones)
		throws BaseException, SQLException {
		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		Proveedor proveedor = (Proveedor) condiciones.get(Proveedor.NICKNAME);
		String nroExt = (String) condiciones.get(DBInformeRecepcion.REMITO_PROV);
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cpInfRecep a, geComproCab b ");
		textSQL.append(" WHERE a.oid_inf_rec = b.oid_cco and a.remito_prov=? and a.oid_proveedor = ? and b.activo=1 ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		querySelect.setString(1, nroExt);
		querySelect.setInt(2, proveedor.getOID());
		return querySelect;
	}
	
	
	
	private PreparedStatement selectAll(Object aCondiciones)
			throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cpInfRecep a, geComproCab b ");
		textSQL.append(" WHERE a.oid_inf_rec = b.oid_cco ");
		PreparedStatement querySelect = getSesion().getConexionBD()
				.prepareStatement(textSQL.toString());
		return querySelect;
	}

	private PreparedStatement selectByInfRecPendFact(Object aCondiciones)
			throws BaseException, SQLException {
		
		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		StringBuffer textSQL = new StringBuffer();
		textSQL.append(" SELECT * FROM  cpInfRecep h, geComproCab i ");
		textSQL.append(" WHERE h.oid_inf_rec = i.oid_cco and i.oid_cco in ");
		textSQL.append(" (select ");
		textSQL.append("    b.oid_inf_rec ");
		textSQL.append("  from ");
		textSQL.append("    cpInfRecepDet a, ");
		textSQL.append("    cpInfRecep b, ");
		textSQL.append("    geComproCab c ");
		textSQL.append("  where ");
		textSQL.append("    b.oid_inf_rec = c.oid_cco and c.activo = 1 and ");
		textSQL.append("    a.oid_inf_rec = b.oid_inf_rec and ");
		textSQL.append("    a.pend_fact = 1 and a.anulado = 0 ");
		if (condiciones.containsKey(Proveedor.NICKNAME)) {
			Proveedor proveedor = (Proveedor) condiciones
					.get(Proveedor.NICKNAME);
			textSQL.append(" and  b.oid_proveedor =  "+proveedor.getOIDInteger().toString());
		}
		textSQL.append("    )");
		
		if (condiciones.containsKey(Talonario.NICKNAME)) {
			Talonario talonario = (Talonario) condiciones
					.get(Talonario.NICKNAME);
			textSQL.append(" and i.oid_talonario = "
					+ talonario.getOIDInteger().toString());
		}

		if (condiciones.containsKey("NRO_DESDE")) {
			Integer nroExt = (Integer) condiciones.get("NRO_DESDE");
			textSQL.append(" and i.nro_ext >= " + nroExt.toString());
		}

		if (condiciones.containsKey("NRO_HASTA")) {
			Integer nroExt = (Integer) condiciones.get("NRO_HASTA");
			textSQL.append(" and i.nro_ext <= " + nroExt.toString());
		}

		if (condiciones.containsKey("FEC_DESDE"))
			textSQL.append(" and i.imputac >= ? ");

		if (condiciones.containsKey("FEC_HASTA"))
			textSQL.append(" and I.imputac <= ? ");
		
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
		textSQL.append("SELECT * FROM  cpInfRecep ");
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

		textSQL.append("SELECT oid_inf_rec oid, codigo,  descripcion ,activo ");
		textSQL.append(" from cpInfRecep");

		PreparedStatement querySelect = getSesion().getConexionBD()
				.prepareStatement(textSQL.toString());
		
		
		return querySelect;
	}

	private PreparedStatement selectByCondiciones(Object aCondiciones)
			throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();
		textSQL
				.append("SELECT a.*,b.* FROM  cpInfRecep a, GECOMPROCAB b where a.oid_inf_rec = b.oid_cco ");
		textSQL.append(" AND 1=1 ");
		HashTableDatos condiciones = (HashTableDatos) aCondiciones;

		OrdenDeCompraCab oc = (OrdenDeCompraCab) condiciones
				.get(OrdenDeCompraCab.NICKNAME);
		if (oc != null)
			textSQL
					.append("  and a.oid_inf_rec in (select oid_inf_rec from cpInfRecepDet where oid_oc_det in "
							+ " (select oid_oc_det from cpOCDet where oid_cco_cpra ="
							+ oc.getOIDInteger().toString() + ")) ");

		if (condiciones.containsKey(Proveedor.NICKNAME)) {
			Proveedor proveedor = (Proveedor) condiciones
					.get(Proveedor.NICKNAME);
			textSQL.append(" and a.oid_proveedor = "
					+ proveedor.getOIDInteger().toString());
		}

		if (condiciones.containsKey("remito")) {
			textSQL.append(" and a.remito_prov like '%"
					+ condiciones.getString("remito")+"%' ");
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

	public static List getInformesRecepcion(HashTableDatos aCondiciones,
			ISesion aSesion) throws BaseException {
		return (List) ObjetoLogico.getObjects(InformeRecepcion.NICKNAME,
				DBInformeRecepcion.SELECT_BY_CONDICIONES, aCondiciones,
				new ListObserver(), aSesion);
	}
	
	public static List getInformesRecepcionPendFact(HashTableDatos condiciones,
			ISesion aSesion) throws BaseException {
		return (List) ObjetoLogico.getObjects(InformeRecepcion.NICKNAME,
				DBInformeRecepcion.SELECT_BY_INF_REC_PEND_FACTURAR, 
				condiciones,
				new ListObserver(), aSesion);
	}
	
	public static InformeRecepcion getInformeRecepcion(String nroRtoProvedor,
			  Proveedor proveedor,
	          ISesion aSesion)
	          throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put(Proveedor.NICKNAME, proveedor);
		condiciones.put(DBInformeRecepcion.REMITO_PROV,nroRtoProvedor);
		  return (InformeRecepcion) ObjetoLogico.getObjects(InformeRecepcion.NICKNAME,
				  				DBInformeRecepcion.SELECT_BY_NRO_PROV,
				  				condiciones,
				  				new ObjetoObservado(),
				  				aSesion);
	  }

}
