package com.srn.erp.ventas.da;

import java.sql.*;
import java.util.List;

import com.srn.erp.general.bm.PeriodoInc;
import com.srn.erp.general.bm.PeriodoIncDet;
import com.srn.erp.general.da.DBPeriodoIncDet;
import com.srn.erp.ventas.bm.*;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.*;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.*;

public class DBObsCodifVtas extends DBObjetoPersistente {

	public static final String OID_OBS_COD = "oid_obs_cod";
	public static final String CODIGO = "codigo";
	public static final String DESCRIPCION = "descripcion";
	public static final String INCLUIR = "incluir";
	public static final String ACTIVO = "activo";
	public static final String TIPO = "tipo";
	public static final String ORDEN = "orden";

	public static final int SELECT_BY_HELP_PRESUPUESTOS = 100;
	public static final int SELECT_BY_HELP_PEDIDOS = 101;
	public static final int SELECT_BY_VALIDAR_PRESU = 102;
	public static final int SELECT_OBS_DEF_PRESU = 103;
	public static final int SELECT_BY_VALIDAR_PEDIDO = 104;
	public static final int SELECT_OBS_DEF_PEDIDO = 105;
	
	public DBObsCodifVtas() {
	}

	protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_OBS_COD = 1;
		final int CODIGO = 2;
		final int DESCRIPCION = 3;
		final int INCLUIR = 4;
		final int ACTIVO = 5;
		final int TIPO = 6;
		final int ORDEN = 7;

		ObsCodifVtas pers = (ObsCodifVtas) objetoPersistente;

		StringBuffer sqlInsert = new StringBuffer();
		sqlInsert.append(" insert into veObsCodVtasCab " + " ( " + "OID_OBS_COD," + "CODIGO," + "DESCRIPCION," + "INCLUIR," + "ACTIVO,"
				+ "TIPO," + "ORDEN)" + " values " + "(" + "?," + "?," + "?," + "?," + "?," + "?," + "?) ");

		PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
		qInsert.setInt(OID_OBS_COD, pers.getOID());
		qInsert.setString(CODIGO, pers.getCodigo());
		qInsert.setString(DESCRIPCION, pers.getDescripcion());
		qInsert.setBoolean(INCLUIR, pers.isIncluir().booleanValue());
		qInsert.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		qInsert.setString(TIPO, pers.getTipo());
		qInsert.setInt(ORDEN, pers.getOrden().intValue());
		qInsert.executeUpdate();
		qInsert.close();
	}

	protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int CODIGO = 1;
		final int DESCRIPCION = 2;
		final int INCLUIR = 3;
		final int ACTIVO = 4;
		final int TIPO = 5;
		final int ORDEN = 6;
		final int OID_OBS_COD = 7;

		ObsCodifVtas pers = (ObsCodifVtas) objetoPersistente;

		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append(" update veObsCodVtasCab set " + "codigo=?" + ",descripcion=?" + ",incluir=?" + ",activo=?" + ",tipo=?"
				+ ",orden=?" + " where " + " oid_obs_cod=? ");

		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_OBS_COD, pers.getOID());
		qUpdate.setString(CODIGO, pers.getCodigo());
		qUpdate.setString(DESCRIPCION, pers.getDescripcion());
		qUpdate.setBoolean(INCLUIR, pers.isIncluir().booleanValue());
		qUpdate.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		qUpdate.setString(TIPO, pers.getTipo());
		qUpdate.setInt(ORDEN, pers.getOrden().intValue());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_OBS_COD = 1;
		ObsCodifVtas pers = (ObsCodifVtas) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update veObsCodVtasCab " + " set activo=0 " + " where " + " oid_obs_cod=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_OBS_COD, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_OBS_COD = 1;
		ObsCodifVtas pers = (ObsCodifVtas) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update veObsCodVtasCab " + " set activo=1 " + " where " + " oid_obs_cod=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_OBS_COD, pers.getOID());
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
		case SELECT_BY_HELP_PRESUPUESTOS: {
			ps = this.selectAllHelpPresupuestos(aCondiciones);
			break;
		}
		case SELECT_BY_HELP_PEDIDOS: {
			ps = this.selectAllHelpPedidos(aCondiciones);
			break;
		}
		case SELECT_BY_VALIDAR_PRESU: {
			ps = this.selectByValidarPresu(aCondiciones);
			break;
		}
		case SELECT_BY_VALIDAR_PEDIDO: {
			ps = this.selectByValidarPedido(aCondiciones);
			break;
		}
		
		case SELECT_OBS_DEF_PRESU: {
			ps = this.selectByObsDefPresu(aCondiciones);
			break;
		}
		case SELECT_OBS_DEF_PEDIDO: {
			ps = this.selectByObsDefPedido(aCondiciones);
			break;
		}
		
		}
		return ps;
	}
	
	private PreparedStatement selectByObsDefPresu(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  veObsCodVtasCab ");
		textSQL.append(" WHERE tipo = 'PRESUPUESTO' and activo = 1 and oid_obs_cod in (select oid_obs_cod from veObsCodVtasSuc where oid_sucursal="+this.getSesion().getLogin().getOidSucursal()+") order by orden ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}
	
	private PreparedStatement selectByObsDefPedido(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  veObsCodVtasCab ");
		textSQL.append(" WHERE tipo = 'PEDIDO' and activo = 1 and oid_obs_cod in (select oid_obs_cod from veObsCodVtasSuc where oid_sucursal="+this.getSesion().getLogin().getOidSucursal()+") order by orden ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}
	

	
	
	

	private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

		final int OID_OBS_COD = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  veObsCodVtasCab ");
		textSQL.append(" WHERE oid_obs_cod = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		int oid = ((Integer) aCondiciones).intValue();
		querySelect.setInt(OID_OBS_COD, oid);
		return querySelect;
	}

	
	private PreparedStatement selectByValidarPresu(Object aCondiciones) throws BaseException, SQLException {

		final int CODIGO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  veObsCodVtasCab ");
		textSQL.append(" WHERE codigo = ? and tipo='PRESUPUESTO' ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		querySelect.setString(CODIGO, condiciones.getString("codigo"));
		return querySelect;
	}
	
	private PreparedStatement selectByValidarPedido(Object aCondiciones) throws BaseException, SQLException {

		final int CODIGO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  veObsCodVtasCab ");
		textSQL.append(" WHERE codigo = ? and tipo='PEDIDO' ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		querySelect.setString(CODIGO, condiciones.getString("codigo"));
		return querySelect;
	}
	
	
	private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

		final int CODIGO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  veObsCodVtasCab ");
		textSQL.append(" WHERE codigo = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		String codigo = (String) aCondiciones;
		querySelect.setString(CODIGO, codigo);
		return querySelect;
	}

	private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();

		textSQL.append("SELECT oid_obs_cod oid,codigo codigo, descripcion descripcion ,activo ");
		textSQL.append(" from veObsCodVtasCab");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}

	private PreparedStatement selectAllHelpPresupuestos(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();

		textSQL.append("SELECT oid_obs_cod oid,codigo codigo, descripcion descripcion ,activo ");
		textSQL.append(" from veObsCodVtasCab where tipo = 'PRESUPUESTO' ");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}

	private PreparedStatement selectAllHelpPedidos(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();

		textSQL.append("SELECT oid_obs_cod oid,codigo codigo, descripcion descripcion ,activo ");
		textSQL.append(" from veObsCodVtasCab where tipo = 'PEDIDO' ");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}
	
	  public static List getObsDefaultPresupuesto(ISesion aSesion) throws BaseException {
		return (List) ObjetoLogico
				.getObjects(ObsCodifVtas.NICKNAME, DBObsCodifVtas.SELECT_OBS_DEF_PRESU, null, new ListObserver(), aSesion);
	}
	
	  public static List getObsDefaultPedido(ISesion aSesion) throws BaseException {
			return (List) ObjetoLogico
					.getObjects(ObsCodifVtas.NICKNAME, DBObsCodifVtas.SELECT_OBS_DEF_PEDIDO, null, new ListObserver(), aSesion);
		}

}
