package com.srn.erp.compras.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.compras.bm.AutorizadorCompra;
import com.srn.erp.compras.bm.EsquemaAutorizCompras;
import com.srn.erp.general.bm.ValorClasificadorEntidad;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.ObjetoObservado;

public class DBAutorizadorCompra extends DBObjetoPersistente {

	public static final String	OID_AUTORIZ_CPRA					= "oid_autoriz_cpra";

	public static final String	OID_ESQ_AUTORIZ						= "oid_esq_autoriz";

	public static final String	OID_VAL_CLASIF_ENT				= "oid_val_clasif_ent";

	public static final String	OID_MONEDA								= "oid_moneda";

	public static final int			SELECT_BY_ESQ_AUTORIZ			= 100;

	public static final int			SELECT_BY_VAL_CLASIF_ENT	= 101;
	
	public static final int 		SELECT_BY_ESQ_SIN_CLASIF  = 102;

	public DBAutorizadorCompra() {
	}

	protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_AUTORIZ_CPRA = 1;
		final int OID_ESQ_AUTORIZ = 2;
		final int OID_VAL_CLASIF_ENT = 3;
		final int OID_MONEDA = 4;

		AutorizadorCompra pers = (AutorizadorCompra) objetoPersistente;

		StringBuffer sqlInsert = new StringBuffer();
		sqlInsert.append(" insert into cpAutorizCpra " + " ( " + "OID_AUTORIZ_CPRA," + "OID_ESQ_AUTORIZ,"
				+ "OID_VAL_CLASIF_ENT," + "OID_MONEDA)" + " values " + "(" + "?," + "?," + "?," + "?) ");

		PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
		qInsert.setInt(OID_AUTORIZ_CPRA, pers.getOID());
		qInsert.setInt(OID_ESQ_AUTORIZ, pers.getEsquema_autoriz().getOID());
		if (pers.getValor_clasificador()!=null)
			qInsert.setInt(OID_VAL_CLASIF_ENT, pers.getValor_clasificador().getOID());
		else
			qInsert.setNull(OID_VAL_CLASIF_ENT, java.sql.Types.INTEGER);
		qInsert.setInt(OID_MONEDA, pers.getMoneda().getOID());
		qInsert.executeUpdate();
		qInsert.close();
	}

	protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_ESQ_AUTORIZ = 1;
		final int OID_VAL_CLASIF_ENT = 2;
		final int OID_MONEDA = 3;
		final int OID_AUTORIZ_CPRA = 4;

		AutorizadorCompra pers = (AutorizadorCompra) objetoPersistente;

		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append(" update cpAutorizCpra set " + "oid_esq_autoriz=?" + ",oid_val_clasif_ent=?" + ",oid_moneda=?"
				+ " where " + " oid_autoriz_cpra=? ");

		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_AUTORIZ_CPRA, pers.getOID());
		qUpdate.setInt(OID_ESQ_AUTORIZ, pers.getEsquema_autoriz().getOID());
		if (pers.getValor_clasificador()!=null)
			qUpdate.setInt(OID_VAL_CLASIF_ENT, pers.getValor_clasificador().getOID());
		else
			qUpdate.setNull(OID_VAL_CLASIF_ENT, java.sql.Types.INTEGER);
		qUpdate.setInt(OID_MONEDA, pers.getMoneda().getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_AUTORIZ_CPRA = 1;
		AutorizadorCompra pers = (AutorizadorCompra) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("delete from cpAutorizCpra where " + " oid_autoriz_cpra=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_AUTORIZ_CPRA, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_AUTORIZ_CPRA = 1;
		AutorizadorCompra pers = (AutorizadorCompra) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update cpAutorizCpra " + " set activo=1 " + " where " + " oid_autoriz_cpra=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_AUTORIZ_CPRA, pers.getOID());
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
		case SELECT_BY_ESQ_AUTORIZ: {
			ps = this.selectByEsqAutoriz(aCondiciones);
			break;
		}
		case SELECT_BY_VAL_CLASIF_ENT: {
			ps = this.selectByClasifEnt(aCondiciones);
			break;
		}
		case SELECT_BY_ESQ_SIN_CLASIF: {
			ps = this.selectByEsquemaSinClasifEnt(aCondiciones);
			break;
		}
		}
		return ps;
	}

	private PreparedStatement selectByEsqAutoriz(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cpAutorizCpra ");
		textSQL.append(" WHERE oid_esq_autoriz = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		EsquemaAutorizCompras esquema = (EsquemaAutorizCompras) aCondiciones;
		querySelect.setInt(1, esquema.getOID());
		return querySelect;
	}

	private PreparedStatement selectByEsquemaSinClasifEnt(Object aCondiciones) throws BaseException, SQLException {
		
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cpAutorizCpra ");
		textSQL.append(" WHERE oid_esq_autoriz = ? and oid_val_clasif_ent is null ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		EsquemaAutorizCompras esqAutorizCompras = (EsquemaAutorizCompras) condiciones.get(EsquemaAutorizCompras.NICKNAME);

		querySelect.setInt(1, esqAutorizCompras.getOID());
		return querySelect;
		
	}
	
	
	private PreparedStatement selectByClasifEnt(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cpAutorizCpra ");
		textSQL.append(" WHERE oid_esq_autoriz = ? and oid_val_clasif_ent = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		EsquemaAutorizCompras esqAutorizCompras = (EsquemaAutorizCompras) condiciones.get(EsquemaAutorizCompras.NICKNAME);
		ValorClasificadorEntidad valClasifEnt = (ValorClasificadorEntidad) condiciones
				.get(ValorClasificadorEntidad.NICKNAME);

		querySelect.setInt(1, esqAutorizCompras.getOID());
		querySelect.setInt(2, valClasifEnt.getOID());
		return querySelect;
	}

	private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

		final int OID_AUTORIZ_CPRA = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cpAutorizCpra ");
		textSQL.append(" WHERE oid_autoriz_cpra = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		int oid = ((Integer) aCondiciones).intValue();
		querySelect.setInt(OID_AUTORIZ_CPRA, oid);
		return querySelect;
	}

	private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

		final int CODIGO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cpAutorizCpra ");
		textSQL.append(" WHERE  = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		String codigo = (String) aCondiciones;
		querySelect.setString(CODIGO, codigo);
		return querySelect;
	}

	private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();

		textSQL.append("SELECT oid_autoriz_cpra oid, codigo,  descripcion ,activo ");
		textSQL.append(" from cpAutorizCpra");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}

	public static List getAutorizadoresCompras(EsquemaAutorizCompras esquemaAutorizCompras, ISesion aSesion)
			throws BaseException {
		return (List) ObjetoLogico.getObjects(AutorizadorCompra.NICKNAME, DBAutorizadorCompra.SELECT_BY_ESQ_AUTORIZ,
				esquemaAutorizCompras, new ListObserver(), aSesion);
	}

	public static AutorizadorCompra getAutorizacionComraByValorClasif(EsquemaAutorizCompras esqAutorizCompras,
			ValorClasificadorEntidad valClasifEnt, ISesion aSesion) throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put(EsquemaAutorizCompras.NICKNAME, esqAutorizCompras);
		condiciones.put(ValorClasificadorEntidad.NICKNAME, valClasifEnt);
		return (AutorizadorCompra) ObjetoLogico.getObjects(AutorizadorCompra.NICKNAME,
				DBAutorizadorCompra.SELECT_BY_VAL_CLASIF_ENT, condiciones, new ObjetoObservado(), aSesion);
	}
	
	public static AutorizadorCompra getAutorizacionComra(EsquemaAutorizCompras esqAutorizCompras,
			ISesion aSesion) throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put(EsquemaAutorizCompras.NICKNAME, esqAutorizCompras);
		return (AutorizadorCompra) ObjetoLogico.getObjects(AutorizadorCompra.NICKNAME,
				DBAutorizadorCompra.SELECT_BY_ESQ_SIN_CLASIF, condiciones, new ObjetoObservado(), aSesion);
	}
	

}
