package com.srn.erp.general.da;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.general.bm.ClasificadorEntidad;

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

public class DBClasificadorEntidad extends DBObjetoPersistente {

	public static final String OID_CLASIF_ENT = "oid_clasif_ent";

	public static final String CODIGO = "codigo";

	public static final String DESCRIPCION = "descripcion";

	public static final String NICKNAME = "nickname";

	public static final String OBLIGATORIO = "obligatorio";

	public static final String OID_VAL_DEFAULT = "oid_val_default";

	public static final String ACTIVO = "activo";

	public static final String NRO_CLASIF = "nro_clasif";

	public static final String OID_GRUPO_CLASIF = "oid_grupo_clasif";

	public static final int SELECT_BY_NICKNAME = 100;

	public static final int SELECT_BY_NICKNAME_NRO = 101;

	public static final int SELECT_HELP_BY_NICKNAME = 102;

	public static final int SELECT_BY_CODIGO_NICKNAME = 103;

	public static final int SELECT_BY_NICKNAME_ACTIVOS = 104;
	
	public static final int SELECT_HELP_BY_NICKNAME_ACTIVOS = 105;
	
	public static final int SELECT_HELP_BY_PROD_STK_Y_GRAL_ACTIVOS = 106;
	
	public static final int SELECT_BY_PROD_STK_Y_GRAL_ACTIVOS = 107;
	
	public static final int SELECT_HELP_BY_LEGAJOS_ACTIVOS = 108;
	
	public static final int SELECT_HELP_BY_VISITAS_ACTIVOS = 109;

	public DBClasificadorEntidad() {
	}

	protected void insert(IObjetoPersistente objetoPersistente)
			throws BaseException, SQLException {

		final int OID_CLASIF_ENT = 1;
		final int CODIGO = 2;
		final int DESCRIPCION = 3;
		final int NICKNAME = 4;
		final int OBLIGATORIO = 5;
		final int OID_VAL_DEFAULT = 6;
		final int ACTIVO = 7;
		final int NRO_CLASIF = 8;
		final int OID_GRUPO_CLASIF = 9;

		ClasificadorEntidad pers = (ClasificadorEntidad) objetoPersistente;

		StringBuffer sqlInsert = new StringBuffer();
		sqlInsert.append(" insert into geClasifEntidades " + " ( "
				+ "OID_CLASIF_ENT," + "CODIGO," + "DESCRIPCION," + "NICKNAME,"
				+ "OBLIGATORIO," + "OID_VAL_DEFAULT," + "ACTIVO,"
				+ "NRO_CLASIF," + "OID_GRUPO_CLASIF)" + " values " + "(" + "?,"
				+ "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?) ");

		PreparedStatement qInsert = getSesion().getConexionBD()
				.prepareStatement(sqlInsert.toString());
		qInsert.setInt(OID_CLASIF_ENT, pers.getOID());
		qInsert.setString(CODIGO, pers.getCodigo());
		qInsert.setString(DESCRIPCION, pers.getDescripcion());
		qInsert.setString(NICKNAME, pers.getNickname());
		qInsert.setBoolean(OBLIGATORIO, pers.isObligatorio().booleanValue());
		qInsert.setInt(OID_VAL_DEFAULT, pers.getValor_default().intValue());
		qInsert.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		qInsert.setInt(NRO_CLASIF, pers.getNroClasif().intValue());
		qInsert.setInt(OID_GRUPO_CLASIF, pers.getGrupo().getOID());

		qInsert.executeUpdate();
		qInsert.close();
	}

	protected void update(IObjetoPersistente objetoPersistente)
			throws BaseException, SQLException {

		final int CODIGO = 1;
		final int DESCRIPCION = 2;
		final int NICKNAME = 3;
		final int OBLIGATORIO = 4;
		final int OID_VAL_DEFAULT = 5;
		final int ACTIVO = 6;
		final int NRO_CLASIF = 7;
		final int OID_GRUPO_CLASIF = 8;
		final int OID_CLASIF_ENT = 9;

		ClasificadorEntidad pers = (ClasificadorEntidad) objetoPersistente;

		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append(" update geClasifEntidades set " + "codigo=?"
				+ ",descripcion=?" + ",nickname=?" + ",obligatorio=?"
				+ ",oid_val_default=?" + ",activo=?" + ",nro_clasif=?"
				+ ",oid_grupo_clasif=?" + " where " + " oid_clasif_ent=? ");

		PreparedStatement qUpdate = getSesion().getConexionBD()
				.prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_CLASIF_ENT, pers.getOID());
		qUpdate.setString(CODIGO, pers.getCodigo());
		qUpdate.setString(DESCRIPCION, pers.getDescripcion());
		qUpdate.setString(NICKNAME, pers.getNickname());
		qUpdate.setBoolean(OBLIGATORIO, pers.isObligatorio().booleanValue());
		qUpdate.setInt(OID_VAL_DEFAULT, pers.getValor_default().intValue());
		qUpdate.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		qUpdate.setInt(NRO_CLASIF, pers.getNroClasif().intValue());
		qUpdate.setInt(OID_GRUPO_CLASIF, pers.getGrupo().getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void delete(IObjetoPersistente objetoPersistente)
			throws BaseException, SQLException {
		final int OID_CLASIF_ENT = 1;
		ClasificadorEntidad pers = (ClasificadorEntidad) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update geClasifEntidades " + " set activo=0 "
				+ " where " + " oid_clasif_ent=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD()
				.prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_CLASIF_ENT, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void rehabilitar(IObjetoPersistente objetoPersistente)
			throws BaseException, SQLException {
		final int OID_CLASIF_ENT = 1;
		ClasificadorEntidad pers = (ClasificadorEntidad) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update geClasifEntidades " + " set activo=1 "
				+ " where " + " oid_clasif_ent=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD()
				.prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_CLASIF_ENT, pers.getOID());
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
		case SELECT_HELP_BY_NICKNAME: {
			ps = this.selectHelpByNickName(aCondiciones);
			break;
		}
		case SELECT_HELP_BY_LEGAJOS_ACTIVOS: {
			ps = this.selectHelpLegajosActivos(aCondiciones);
			break;
		}
		
		case SELECT_HELP_BY_VISITAS_ACTIVOS: {
			ps = this.selectHelpVisitasActivos(aCondiciones);
			break;
		}
		case SELECT_HELP_BY_PROD_STK_Y_GRAL_ACTIVOS: {
			ps = this.selectHelpByProdStkyGral(aCondiciones);
			break;
		}
		case SELECT_BY_PROD_STK_Y_GRAL_ACTIVOS: {
			ps = this.selectByProdStkyGral(aCondiciones);
			break;
		}		
		case SELECT_HELP_BY_NICKNAME_ACTIVOS: {
			ps = this.selectHelpByNickNameActivos(aCondiciones);
			break;
		}
		case SELECT_BY_NICKNAME: {
			ps = this.selectByNickName(aCondiciones);
			break;
		}
		case SELECT_BY_NICKNAME_ACTIVOS: {
			ps = this.selectByNickNameActivos(aCondiciones);
			break;
		}
		case SELECT_BY_NICKNAME_NRO: {
			ps = this.selectByNickNameNro(aCondiciones);
			break;
		}
		case SELECT_BY_CODIGO_NICKNAME: {
			ps = this.selectByCodigoNickName(aCondiciones);
			break;
		}
		}
		return ps;
	}

	private PreparedStatement selectByOID(Object aCondiciones)
			throws BaseException, SQLException {

		final int OID_CLASIF_ENT = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  geClasifEntidades ");
		textSQL.append(" WHERE oid_clasif_ent = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD()
				.prepareStatement(textSQL.toString());
		int oid = ((Integer) aCondiciones).intValue();
		querySelect.setInt(OID_CLASIF_ENT, oid);
		return querySelect;
	}

	private PreparedStatement selectByCodigo(Object aCondiciones)
			throws BaseException, SQLException {

		final int CODIGO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  geClasifEntidades ");
		textSQL.append(" WHERE codigo  = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD()
				.prepareStatement(textSQL.toString());
		String codigo = (String) aCondiciones;
		querySelect.setString(CODIGO, codigo);
		return querySelect;
	}

	private PreparedStatement selectByNickNameActivos(Object aCondiciones)
			throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  geClasifEntidades ");
		textSQL.append(" WHERE nickname = ? and activo = 1 ");
		HashTableDatos cond = (HashTableDatos) aCondiciones;

		if (cond.containsKey("ORDER_BY_OID_CLASIF_ENT"))
			textSQL.append(" order by oid_clasif_ent ");

		String nickName = cond.getString("NICKNAME");
		PreparedStatement querySelect = getSesion().getConexionBD()
				.prepareStatement(textSQL.toString());
		querySelect.setString(1, nickName);
		return querySelect;
	}

	private PreparedStatement selectByNickName(Object aCondiciones)
			throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  geClasifEntidades ");
		textSQL.append(" WHERE nickname = ? ");
		HashTableDatos cond = (HashTableDatos) aCondiciones;

		if (cond.containsKey("ORDER_BY_OID_CLASIF_ENT"))
			textSQL.append(" order by oid_clasif_ent ");

		String nickName = cond.getString("NICKNAME");
		PreparedStatement querySelect = getSesion().getConexionBD()
				.prepareStatement(textSQL.toString());
		querySelect.setString(1, nickName);
		return querySelect;
	}

	private PreparedStatement selectByCodigoNickName(Object aCondiciones)
			throws BaseException, SQLException {
		MapDatos mapaDatos = (MapDatos) aCondiciones;
		String nickName = mapaDatos.getString("nickname");
		String codigo = mapaDatos.getString("codigo");
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  geClasifEntidades ");
		textSQL.append(" WHERE codigo = ? and nickname = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD()
				.prepareStatement(textSQL.toString());
		querySelect.setString(1, codigo);
		querySelect.setString(2, nickName);
		return querySelect;
	}

	private PreparedStatement selectByNickNameNro(Object aCondiciones)
			throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  geClasifEntidades ");
		textSQL.append(" WHERE nickname = ? and nro_clasif = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD()
				.prepareStatement(textSQL.toString());
		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		String nickname = (String) condiciones.get("nickname");
		Integer nroClasif = (Integer) condiciones.get("nro_clasif");
		querySelect.setString(1, nickname);
		querySelect.setInt(2, nroClasif.intValue());
		return querySelect;
	}
	

	private PreparedStatement selectHelpVisitasActivos(Object aCondiciones)
	throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT oid_clasif_ent oid, codigo,  descripcion ,activo ");
		textSQL.append(" from geClasifEntidades where nickname='cip.Visita' ");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}
	
	
	
	private PreparedStatement selectHelpLegajosActivos(Object aCondiciones)
	throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT oid_clasif_ent oid, codigo,  descripcion ,activo ");
		textSQL.append(" from geClasifEntidades where nickname='su.Legajo' ");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}

	private PreparedStatement selectAllHelp(Object aCondiciones)
			throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();

		textSQL
				.append("SELECT oid_clasif_ent oid, codigo,  descripcion ,activo ");
		textSQL.append(" from geClasifEntidades");

		PreparedStatement querySelect = getSesion().getConexionBD()
				.prepareStatement(textSQL.toString());
		return querySelect;
	}

	private PreparedStatement selectHelpByNickName(Object aCondiciones)
			throws BaseException, SQLException {
		MapDatos mapaDatos = (MapDatos) aCondiciones;
		String nickname = mapaDatos.getString("nickname");
		StringBuffer textSQL = new StringBuffer();
		textSQL
				.append("SELECT oid_clasif_ent oid, codigo,  descripcion ,activo ");
		textSQL.append(" from geClasifEntidades where nickname = ?");
		PreparedStatement querySelect = getSesion().getConexionBD()
				.prepareStatement(textSQL.toString());
		querySelect.setString(1, nickname);
		return querySelect;
	}
	
	private PreparedStatement selectHelpByProdStkyGral(Object aCondiciones)
		throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT oid_clasif_ent oid, codigo,  descripcion ,activo ");
		textSQL.append(" from geClasifEntidades where nickname in ('st.Producto','st.ExtensionProdGen') and activo = 1 ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}
	
	private PreparedStatement selectByProdStkyGral(Object aCondiciones)
		throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * ");
		textSQL.append(" from geClasifEntidades where nickname in ('st.Producto','st.ExtensionProdGen') and activo = 1 ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}	
	
	private PreparedStatement selectHelpByNickNameActivos(Object aCondiciones)
	throws BaseException, SQLException {
		MapDatos mapaDatos = (MapDatos) aCondiciones;
		String nickname = mapaDatos.getString("nickname");
		StringBuffer textSQL = new StringBuffer();
		textSQL
		.append("SELECT oid_clasif_ent oid, codigo,  descripcion ,activo ");
		textSQL.append(" from geClasifEntidades where nickname = ? and activo = 1 ");
		PreparedStatement querySelect = getSesion().getConexionBD()
		.prepareStatement(textSQL.toString());
		querySelect.setString(1, nickname);
		return querySelect;
	}
	

	public static List getClasificadoresEntidad(String nickname,
			boolean orderByOidClasifEnt, ISesion aSesion) throws BaseException {
		HashTableDatos cond = new HashTableDatos();
		cond.put("NICKNAME", nickname);
		if (orderByOidClasifEnt)
			cond.put("ORDER_BY_OID_CLASIF_ENT", "");
		return (List) ObjetoLogico.getObjects(ClasificadorEntidad.NICKNAME,
				DBClasificadorEntidad.SELECT_BY_NICKNAME, cond,
				new ListObserver(), aSesion);
	}
	
	public static List getClasificadoresEntidadActivos(String nickname,
			boolean orderByOidClasifEnt, ISesion aSesion) throws BaseException {
		HashTableDatos cond = new HashTableDatos();
		cond.put("NICKNAME", nickname);
		if (orderByOidClasifEnt)
			cond.put("ORDER_BY_OID_CLASIF_ENT", "");
		return (List) ObjetoLogico.getObjects(ClasificadorEntidad.NICKNAME,
				DBClasificadorEntidad.SELECT_BY_NICKNAME_ACTIVOS, cond,
				new ListObserver(), aSesion);
	}
	
	public static List getClasifProdStockYGralActivos(ISesion aSesion) throws BaseException {
		return (List) ObjetoLogico.getObjects(ClasificadorEntidad.NICKNAME,
				DBClasificadorEntidad.SELECT_BY_PROD_STK_Y_GRAL_ACTIVOS, null,
				new ListObserver(), aSesion);
	}
	
	
	public static ClasificadorEntidad getClasificadorEntidad(String nickname,
			Integer nroClasificador, ISesion aSesion) throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put("nickname", nickname);
		condiciones.put("nro_clasif", nroClasificador);
		return (ClasificadorEntidad) ObjetoLogico.getObjects(
				ClasificadorEntidad.NICKNAME,
				DBClasificadorEntidad.SELECT_BY_NICKNAME_NRO, condiciones,
				new ObjetoObservado(), aSesion);
	}

	public static int getUltimoNroItem(ISesion aSesion, Integer oidClasifEnt)
			throws BaseException {

		try {

			StringBuffer sqlUltNroItem = new StringBuffer(
					" select max(oid_item) from geValClasifEnt where oid_clasif_ent="
							+ oidClasifEnt.toString());
			PreparedStatement querySelect = aSesion.getConexionBD()
					.prepareStatement(sqlUltNroItem.toString());

			ResultSet rs = querySelect.executeQuery();
			int ultimoNro = 0;
			if (rs.next())
				ultimoNro = rs.getInt(1);
			rs.close();
			querySelect.close();

			StringBuffer sqlUltNroItemPadre = new StringBuffer(
					" select max(oid_item_padre) from geValClasifEnt where oid_clasif_ent="
							+ oidClasifEnt.toString());
			PreparedStatement querySelectItemPadre = aSesion.getConexionBD()
					.prepareStatement(sqlUltNroItemPadre.toString());

			ResultSet rsItemPadre = querySelectItemPadre.executeQuery();
			int ultimoNroPadre = 0;
			if (rsItemPadre.next())
				ultimoNroPadre = rsItemPadre.getInt(1);
			rsItemPadre.close();
			querySelectItemPadre.close();

			if (ultimoNro >= ultimoNroPadre)
				return ultimoNro;
			else
				return ultimoNroPadre;
		} catch (Exception e) {
			throw new BaseException(null, e.getMessage());
		}
	}

}
