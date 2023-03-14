package com.srn.erp.compras.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.compras.bm.EsqHabProdUsu;
import com.srn.erp.compras.bm.EsquemaHabilitacionProducto;
import com.srn.erp.general.bm.IValorClasificadorEntidad;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.applicarionServer.bm.Seguridad.Usuario;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.ObjetoObservado;

public class DBEsqHabProdUsu extends DBObjetoPersistente {

	public static final String	OID_ESQ_HAB_USU									= "oid_esq_hab_usu";

	public static final String	OID_ESQ_HAB_PROD								= "oid_esq_hab_prod";

	public static final String	OID_VAL_CLASIF_ENT							= "oid_val_clasif_ent";

	public static final String	OID_USUARIO											= "oid_usuario";

	public static final int			SELECT_BY_ESQUEMA_HABILITACION	= 100;
	public static final int     SELECT_BY_ESQUEMA_VALORCLASIF_USUARIO = 101;

	public DBEsqHabProdUsu() {
	}

	protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_ESQ_HAB_USU = 1;
		final int OID_ESQ_HAB_PROD = 2;
		final int OID_VAL_CLASIF_ENT = 3;
		final int OID_USUARIO = 4;

		EsqHabProdUsu pers = (EsqHabProdUsu) objetoPersistente;

		StringBuffer sqlInsert = new StringBuffer();
		sqlInsert.append(" insert into cpEsqHabProdUsu " + " ( " + "OID_ESQ_HAB_USU," + "OID_ESQ_HAB_PROD,"
				+ "OID_VAL_CLASIF_ENT," + "OID_USUARIO)" + " values " + "(" + "?," + "?," + "?," + "?) ");

		PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
		qInsert.setInt(OID_ESQ_HAB_USU, pers.getOID());
		qInsert.setInt(OID_ESQ_HAB_PROD, pers.getEsquema_habilitacion().getOID());
		qInsert.setInt(OID_VAL_CLASIF_ENT, pers.getValor_clasificador().getOID());
		qInsert.setInt(OID_USUARIO, pers.getUsuario().getOID());
		qInsert.executeUpdate();
		qInsert.close();
	}

	protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_ESQ_HAB_PROD = 1;
		final int OID_VAL_CLASIF_ENT = 2;
		final int OID_USUARIO = 3;
		final int OID_ESQ_HAB_USU = 4;

		EsqHabProdUsu pers = (EsqHabProdUsu) objetoPersistente;

		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append(" update cpEsqHabProdUsu set " + "oid_esq_hab_prod=?" + ",oid_val_clasif_ent=?" + ",oid_usuario=?"
				+ " where " + " oid_esq_hab_usu=? ");

		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_ESQ_HAB_USU, pers.getOID());
		qUpdate.setInt(OID_ESQ_HAB_PROD, pers.getEsquema_habilitacion().getOID());
		qUpdate.setInt(OID_VAL_CLASIF_ENT, pers.getValor_clasificador().getOID());
		qUpdate.setInt(OID_USUARIO, pers.getUsuario().getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_ESQ_HAB_USU = 1;
		EsqHabProdUsu pers = (EsqHabProdUsu) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("delete from cpEsqHabProdUsu " + " where " + " oid_esq_hab_usu=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_ESQ_HAB_USU, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_ESQ_HAB_USU = 1;
		EsqHabProdUsu pers = (EsqHabProdUsu) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update cpEsqHabProdUsu " + " set activo=1 " + " where " + " oid_esq_hab_usu=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_ESQ_HAB_USU, pers.getOID());
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
		case SELECT_BY_ESQUEMA_HABILITACION: {
			ps = this.selectByEsquemaHabilitacion(aCondiciones);
			break;
		}
		case SELECT_BY_ESQUEMA_VALORCLASIF_USUARIO: {
			ps = this.selectByEsquemaValorClasifUsuario(aCondiciones);
			break;
		}
		}
		return ps;
	}

	private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

		final int OID_ESQ_HAB_USU = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cpEsqHabProdUsu ");
		textSQL.append(" WHERE oid_esq_hab_usu = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		int oid = ((Integer) aCondiciones).intValue();
		querySelect.setInt(OID_ESQ_HAB_USU, oid);
		return querySelect;
	}

	private PreparedStatement selectByEsquemaHabilitacion(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cpEsqHabProdUsu ");
		textSQL.append(" WHERE oid_esq_hab_prod = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		EsquemaHabilitacionProducto esquemaHabProd = (EsquemaHabilitacionProducto) aCondiciones;
		querySelect.setInt(1, esquemaHabProd.getOID());
		return querySelect;
	}
	
	private PreparedStatement selectByEsquemaValorClasifUsuario(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cpEsqHabProdUsu ");
		textSQL.append(" WHERE oid_esq_hab_prod = ? and oid_val_clasif_ent = ? and oid_usuario = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		EsquemaHabilitacionProducto esqHabProd = (EsquemaHabilitacionProducto) condiciones.get(EsquemaHabilitacionProducto.NICKNAME);
		IValorClasificadorEntidad valClasifEnt = (IValorClasificadorEntidad) condiciones.get("VALOR_CLASIFICADOR");
		Usuario usuario = (Usuario) condiciones.get(Usuario.NICKNAME);
		
		querySelect.setInt(1, esqHabProd.getOID());
		querySelect.setInt(2, valClasifEnt.getOID());
		querySelect.setInt(3, usuario.getOID());
		
		return querySelect;
	}
	
	
	

	private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

		final int CODIGO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cpEsqHabProdUsu ");
		textSQL.append(" WHERE  = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		String codigo = (String) aCondiciones;
		querySelect.setString(CODIGO, codigo);
		return querySelect;
	}

	private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();

		textSQL.append("SELECT oid_esq_hab_usu oid, codigo,  descripcion ,activo ");
		textSQL.append(" from cpEsqHabProdUsu");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}

	public static List getHabilitacionesProductoUsuario(EsquemaHabilitacionProducto esquemaHabilitacionProducto,
			ISesion aSesion) throws BaseException {
		return (List) ObjetoLogico.getObjects(EsqHabProdUsu.NICKNAME,
				DBEsqHabProdUsu.SELECT_BY_ESQUEMA_HABILITACION, esquemaHabilitacionProducto,
				new ListObserver(), aSesion);
	}
	
  public static EsqHabProdUsu getEsqHabProdUsu(EsquemaHabilitacionProducto esqHabProd,
			IValorClasificadorEntidad valorClasif, Usuario usuario, ISesion aSesion) throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put(EsquemaHabilitacionProducto.NICKNAME, esqHabProd);
		condiciones.put("VALOR_CLASIFICADOR", valorClasif);
		condiciones.put(Usuario.NICKNAME, usuario);
		return (EsqHabProdUsu) ObjetoLogico.getObjects(EsqHabProdUsu.NICKNAME,
				DBEsqHabProdUsu.SELECT_BY_ESQUEMA_VALORCLASIF_USUARIO, condiciones, new ObjetoObservado(), aSesion);
	}
	

}
