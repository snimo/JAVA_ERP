package com.srn.erp.general.da;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.StringTokenizer;

import com.srn.erp.general.bm.ClasificadorEntidad;
import com.srn.erp.general.bm.ValorClasifEntProdGen;
import com.srn.erp.general.bm.ValorClasificadorEntidad;
import com.srn.erp.stock.bm.Producto;
import com.srn.erp.ventas.bm.ListaPrecios;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.ObjetoObservado;

public class DBValorClasificadorEntidad extends DBObjetoPersistente {

	public static final String	OID_VAL_CLASIF_ENT										= "oid_val_clasif_ent";

	public static final String	OID_CLASIF_ENT												= "oid_clasif_ent";

	public static final String	OID_ITEM															= "oid_item";

	public static final String	CODIGO																= "codigo";

	public static final String	DESCRIPCION														= "descripcion";

	public static final String	OID_ITEM_PADRE												= "oid_item_padre";

	public static final String	ACTIVO																= "activo";

	public static final String	ORDEN																	= "orden";

	public static final String	TIPO																	= "tipo";

	public static final String	CODIGO_DESDE													= "codigo_desde";

	public static final String	CODIGO_HASTA													= "codigo_hasta";
	
	public static final	String	OID_EXTENSION_PG = "oid_extension_pg";	

	public static final int			SELECT_BY_CLASIFICADOR_ENTIDAD				= 100;

	public static final int			SELECR_BY_CLASIF_ENT_OID_ITEM					= 101;

	public static final int			SELECT_BY_CLASIF_ENT_CODIGO						= 102;

	public static final int			SELECT_BY_RANGOS											= 103;

	public static final int			SELECT_BY_CLASIF_SOLO_TITU						= 104;

	public static final int			SELECT_BY_CLASIFICADOR_ENTIDAD_C_Y_D	= 105;
	
	public static final int 		SELECT_BY_PROF_GRAL_NOT_IN_LP_GRAL = 106;
	
	public static final int			SELECT_BY_ALL_PROD_GRALES = 107;
	

	public DBValorClasificadorEntidad() {
	}

	protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_VAL_CLASIF_ENT = 1;
		final int OID_CLASIF_ENT = 2;
		final int OID_ITEM = 3;
		final int CODIGO = 4;
		final int DESCRIPCION = 5;
		final int OID_ITEM_PADRE = 6;
		final int ACTIVO = 7;
		final int ORDEN = 8;
		final int TIPO = 9;
		final int CODIGO_DESDE = 10;
		final int CODIGO_HASTA = 11;

		ValorClasificadorEntidad pers = (ValorClasificadorEntidad) objetoPersistente;

		StringBuffer sqlInsert = new StringBuffer();
		sqlInsert.append(" insert into geValClasifEnt " + " ( " + "OID_VAL_CLASIF_ENT," + "OID_CLASIF_ENT," + "OID_ITEM,"
				+ "CODIGO," + "DESCRIPCION," + "OID_ITEM_PADRE," + "ACTIVO," + "ORDEN," + "TIPO," + "CODIGO_DESDE,"
				+ "CODIGO_HASTA)" + " values " + "(" + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?,"
				+ "?) ");

		PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
		qInsert.setInt(OID_VAL_CLASIF_ENT, pers.getOID());
		qInsert.setInt(OID_CLASIF_ENT, pers.getClasificador_entidad().getOID());
		if (pers.getOid_item().intValue() == -1)
			qInsert.setInt(OID_ITEM, pers.getOID());
		else
			qInsert.setInt(OID_ITEM, pers.getOid_item().intValue());
		if (pers.getCodigo() != null)
			qInsert.setString(CODIGO, pers.getCodigo());
		else
			qInsert.setString(CODIGO, "");
		if (pers.getDescripcion() != null)
			qInsert.setString(DESCRIPCION, pers.getDescripcion());
		else
			qInsert.setString(DESCRIPCION, "");
		qInsert.setInt(OID_ITEM_PADRE, pers.getOid_item_padre().intValue());
		qInsert.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		if (pers.getOrden() != null)
			qInsert.setInt(ORDEN, pers.getOrden().intValue());
		else
			qInsert.setNull(ORDEN, java.sql.Types.INTEGER);
		qInsert.setString(TIPO, pers.getTipo());
		if (pers.getCodigoDesde() != null)
			qInsert.setString(CODIGO_DESDE, pers.getCodigoDesde());
		else
			qInsert.setString(CODIGO_DESDE, "0");
		if (pers.getCodigoHasta() != null)
			qInsert.setString(CODIGO_HASTA, pers.getCodigoHasta());
		else
			qInsert.setString(CODIGO_HASTA, "0");
		qInsert.executeUpdate();
		qInsert.close();
		
		
	}

	protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_CLASIF_ENT = 1;
		final int OID_ITEM = 2;
		final int CODIGO = 3;
		final int DESCRIPCION = 4;
		final int OID_ITEM_PADRE = 5;
		final int ACTIVO = 6;
		final int ORDEN = 7;
		final int TIPO = 8;
		final int CODIGO_DESDE = 9;
		final int CODIGO_HASTA = 10;
		final int OID_VAL_CLASIF_ENT = 11;

		ValorClasificadorEntidad pers = (ValorClasificadorEntidad) objetoPersistente;

		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append(" update geValClasifEnt set " + "oid_clasif_ent=?" + ",oid_item=?" + ",codigo=?"
				+ ",descripcion=?" + ",oid_item_padre=?" + ",activo=?" + ",orden=?" + ",tipo=?" + ",codigo_desde=?"
				+ ",codigo_hasta=?" + " where " + " oid_val_clasif_ent=? ");

		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_VAL_CLASIF_ENT, pers.getOID());
		qUpdate.setInt(OID_CLASIF_ENT, pers.getClasificador_entidad().getOID());
		qUpdate.setInt(OID_ITEM, pers.getOid_item().intValue());
		if (pers.getCodigo() != null)
			qUpdate.setString(CODIGO, pers.getCodigo());
		else
			qUpdate.setString(CODIGO, "");
		if (pers.getDescripcion() != null)
			qUpdate.setString(DESCRIPCION, pers.getDescripcion());
		else
			qUpdate.setString(DESCRIPCION, "");
		qUpdate.setInt(OID_ITEM_PADRE, pers.getOid_item_padre().intValue());
		qUpdate.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		if (pers.getOrden() != null)
			qUpdate.setInt(ORDEN, pers.getOrden().intValue());
		else
			qUpdate.setNull(ORDEN, java.sql.Types.INTEGER);
		qUpdate.setString(TIPO, pers.getTipo());
		if (pers.getCodigoDesde() != null)
			qUpdate.setString(CODIGO_DESDE, pers.getCodigoDesde());
		else
			qUpdate.setString(CODIGO_DESDE, "0");
		if (pers.getCodigoHasta() != null)
			qUpdate.setString(CODIGO_HASTA, pers.getCodigoHasta());
		else
			qUpdate.setString(CODIGO_HASTA, "0");
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_VAL_CLASIF_ENT = 1;
		ValorClasificadorEntidad pers = (ValorClasificadorEntidad) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update geValClasifEnt set activo = 0 " + " where " + " oid_val_clasif_ent=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_VAL_CLASIF_ENT, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_VAL_CLASIF_ENT = 1;
		ValorClasificadorEntidad pers = (ValorClasificadorEntidad) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update geValClasifEnt " + " set activo=1 " + " where " + " oid_val_clasif_ent=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_VAL_CLASIF_ENT, pers.getOID());
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
		case SELECT_BY_CLASIFICADOR_ENTIDAD: {
			ps = this.selectByClasificadorEntidad(aCondiciones);
			break;
		}
		case SELECT_BY_CLASIFICADOR_ENTIDAD_C_Y_D: {
			ps = this.selectByClasificadorEntidadCyD(aCondiciones);
			break;
		}
		case SELECR_BY_CLASIF_ENT_OID_ITEM: {
			ps = this.selectByClasifEntOidItem(aCondiciones);
			break;
		}
		case SELECT_BY_ALL_PROD_GRALES: {
			ps = this.selectByAllProductosGrales(aCondiciones);
			break;
		}
		case SELECT_BY_CLASIF_ENT_CODIGO: {
			ps = this.selectByClasifEntCodigo(aCondiciones);
			break;
		}
		case SELECT_BY_RANGOS: {
			ps = this.selectByRangos(aCondiciones);
			break;
		}
		case SELECT_BY_CLASIF_SOLO_TITU: {
			ps = this.selectByClasificadorSoloTitu(aCondiciones);
			break;
		}
		case SELECT_BY_PROF_GRAL_NOT_IN_LP_GRAL: {
			ps = this.selectByProdGralNotInLPGral(aCondiciones);
			break;
		}
		}
		return ps;
	}

	private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

		final int OID_VAL_CLASIF_ENT = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  geValClasifEnt ");
		textSQL.append(" WHERE oid_val_clasif_ent = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		int oid = ((Integer) aCondiciones).intValue();
		querySelect.setInt(OID_VAL_CLASIF_ENT, oid);
		return querySelect;
	}

	private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

		final int CODIGO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  geValClasifEnt ");
		textSQL.append(" WHERE codigo = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		String codigo = (String) aCondiciones;
		querySelect.setString(CODIGO, codigo);
		return querySelect;
	}
	
	private PreparedStatement selectByAllProductosGrales(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  geValClasifEnt ");
		textSQL.append(" WHERE oid_clasif_ent = "+Producto.getClasifProductoGeneral(this.getSesion()).getOIDInteger());
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}
	
	private PreparedStatement selectByProdGralNotInLPGral(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		ListaPrecios listaPrecios = (ListaPrecios) condiciones.get(ListaPrecios.NICKNAME);
		textSQL.append("SELECT * FROM  geValClasifEnt ");
		
		ClasificadorEntidad clasif = ClasificadorEntidad.getClasifTitulosLPProdGral(this.getSesion());
		textSQL.append(" WHERE oid_clasif_ent = "+Producto.getClasifProductoGeneral(this.getSesion()).getOIDInteger()+" ");
		textSQL.append(" and oid_val_clasif_ent not in (select oid_clasif_art_2 from vePreciosEstLP where oid_precio_cab = "+listaPrecios.getOIDInteger()+") ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}
	
	private PreparedStatement selectByClasifEntCodigo(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  geValClasifEnt ");
		textSQL.append(" WHERE codigo = ? and oid_clasif_ent = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		String codigo = (String) condiciones.get("codigo");
		ClasificadorEntidad clasifEnt = (ClasificadorEntidad) condiciones.get(ClasificadorEntidad.NICKNAME);
		querySelect.setString(1, codigo);
		querySelect.setInt(2, clasifEnt.getOID());
		return querySelect;
	}

	private PreparedStatement selectByRangos(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  geValClasifEnt ");
		textSQL.append(" WHERE oid_clasif_ent = ? and tipo = 'RANGO' and activo = 1 ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		ClasificadorEntidad clasifEnt = (ClasificadorEntidad) aCondiciones;
		querySelect.setInt(1, clasifEnt.getOID());
		return querySelect;
	}

	private PreparedStatement selectByClasifEntOidItem(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  geValClasifEnt ");
		textSQL.append(" WHERE oid_clasif_ent = ? and oid_item = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		ClasificadorEntidad clasificadorEntidad = (ClasificadorEntidad) condiciones.get(ClasificadorEntidad.NICKNAME);
		Integer oidItem = (Integer) condiciones.get("oid_item");
		querySelect.setInt(1, clasificadorEntidad.getOID());
		querySelect.setInt(2, oidItem.intValue());

		return querySelect;
	}

	private PreparedStatement selectByClasificadorEntidad(Object aCondiciones) throws BaseException, SQLException {

		final int CODIGO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  geValClasifEnt ");
		textSQL.append(" WHERE oid_clasif_ent = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		ClasificadorEntidad clasificadorEntidad = (ClasificadorEntidad) aCondiciones;
		querySelect.setInt(1, clasificadorEntidad.getOID());
		return querySelect;
	}

	private PreparedStatement selectByClasificadorEntidadCyD(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  geValClasifEnt ");
		textSQL.append(" WHERE oid_clasif_ent = ? ");
		
		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		String filtroCodigo = null;
		if (condiciones.containsKey("FILTRO_CODIGO"))
			filtroCodigo = condiciones.getString("FILTRO_CODIGO");
		if ((filtroCodigo!=null) && 
			 (filtroCodigo.length()>0)) {			
			StringTokenizer st = new StringTokenizer(filtroCodigo, " ");
			while (st.hasMoreTokens()) {
				String next = st.nextToken().toUpperCase();
				textSQL.append(" and codigo like '%" + next + "%' ");
			}
		}			
		
		String filtroDescripcion = null;
		if (condiciones.containsKey("FILTRO_DESCRIPCION"))
				filtroDescripcion = condiciones.getString("FILTRO_DESCRIPCION");
		if ((filtroDescripcion!=null) && 
			 (filtroDescripcion.length()>0)) {			
			StringTokenizer st = new StringTokenizer(filtroDescripcion, " ");
			while (st.hasMoreTokens()) {
				String next = st.nextToken().toUpperCase();
				textSQL.append(" and descripcion like '%" + next + "%' ");
			}
		}			
		
		
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		ClasificadorEntidad clasificadorEntidad = (ClasificadorEntidad) condiciones.get(ClasificadorEntidad.NICKNAME);
		querySelect.setInt(1, clasificadorEntidad.getOID());
		return querySelect;
	}

	private PreparedStatement selectByClasificadorSoloTitu(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  geValClasifEnt ");
		textSQL.append(" WHERE oid_clasif_ent = ? and tipo='TITULO' ");
		
		
		
		
		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		
		if (condiciones.containsKey("SOLO_ACTIVOS")) 
			textSQL.append(" and activo=1 ");
		
		if (condiciones.containsKey("FILTRO_CODIGO")) {
		String filtroCodigo = condiciones.getString("FILTRO_CODIGO");
		if ((filtroCodigo!=null) && 
			 (filtroCodigo.length()>0)) {			
			StringTokenizer st = new StringTokenizer(filtroCodigo, " ");
			while (st.hasMoreTokens()) {
				String next = st.nextToken().toUpperCase();
				textSQL.append(" and codigo like '%" + next + "%' ");
			}
		}			
		}
		
		if (condiciones.containsKey("FILTRO_DESCRIPCION")) {
		String filtroDescripcion = condiciones.getString("FILTRO_DESCRIPCION");
		if ((filtroDescripcion!=null) && 
			 (filtroDescripcion.length()>0)) {			
			StringTokenizer st = new StringTokenizer(filtroDescripcion, " ");
			while (st.hasMoreTokens()) {
				String next = st.nextToken().toUpperCase();
				textSQL.append(" and descripcion like '%" + next + "%' ");
			}
		}			
		}
		
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		
		ClasificadorEntidad clasificadorEntidad = (ClasificadorEntidad) condiciones.get(ClasificadorEntidad.NICKNAME);
		querySelect.setInt(1, clasificadorEntidad.getOID());
		return querySelect;
	}

	private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();

		textSQL.append("SELECT oid_val_clasif_ent oid,codigo codigo, descripcion descripcion ,activo ");
		textSQL.append(" from geValClasifEnt");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}

	public static List getValoresClasifEntidad(ClasificadorEntidad clasificadorEntidad, String filtroCodigo,
			String filtroDescripcion, ISesion aSesion) throws BaseException {

		HashTableDatos condiciones = new HashTableDatos();

		if (filtroCodigo != null)
			condiciones.put("FILTRO_CODIGO", filtroCodigo);
		if (filtroDescripcion != null)
			condiciones.put("FILTRO_DESCRIPCION", filtroDescripcion);
		condiciones.put(ClasificadorEntidad.NICKNAME,clasificadorEntidad);

		return (List) ObjetoLogico.getObjects(ValorClasificadorEntidad.NICKNAME,
				DBValorClasificadorEntidad.SELECT_BY_CLASIFICADOR_ENTIDAD_C_Y_D, condiciones, new ListObserver(), aSesion);
	}

	public static List getValoresClasifEntidad(ClasificadorEntidad clasificadorEntidad, ISesion aSesion)
			throws BaseException {
		return (List) ObjetoLogico.getObjects(ValorClasificadorEntidad.NICKNAME,
				DBValorClasificadorEntidad.SELECT_BY_CLASIFICADOR_ENTIDAD, clasificadorEntidad, new ListObserver(), aSesion);
	}

	public static List getValoresClasifEntidadSoloTitulos(ClasificadorEntidad clasificadorEntidad, boolean soloActivos, ISesion aSesion)
			throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put(ClasificadorEntidad.NICKNAME,clasificadorEntidad);
		if (soloActivos)
			condiciones.put("SOLO_ACTIVOS","");
		return (List) ObjetoLogico.getObjects(ValorClasificadorEntidad.NICKNAME,
				DBValorClasificadorEntidad.SELECT_BY_CLASIF_SOLO_TITU, condiciones, new ListObserver(), aSesion);
	}
	
	public static List getValoresClasifEntidadSoloTitulos(ClasificadorEntidad clasificadorEntidad, 
			String buscarPorCodigo,
			String buscarPorDescripcion,
			boolean soloActivos,
			ISesion aSesion)
	throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put(ClasificadorEntidad.NICKNAME,clasificadorEntidad);
		if (buscarPorCodigo!=null)
			condiciones.put("FILTRO_CODIGO",buscarPorCodigo);
		if (buscarPorDescripcion!=null)
			condiciones.put("FILTRO_DESCRIPCION",buscarPorDescripcion);
		if (soloActivos)
			condiciones.put("SOLO_ACTIVOS","");
		return (List) ObjetoLogico.getObjects(ValorClasificadorEntidad.NICKNAME,
		DBValorClasificadorEntidad.SELECT_BY_CLASIF_SOLO_TITU, condiciones, new ListObserver(), aSesion);
}
	

	public static ValorClasificadorEntidad getValorClasificadorEntidad(ClasificadorEntidad clasifEnt, Integer oidItem,
			ISesion aSesion) throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put(ClasificadorEntidad.NICKNAME, clasifEnt);
		condiciones.put("oid_item", oidItem);
		return (ValorClasificadorEntidad) ObjetoLogico.getObjects(ValorClasificadorEntidad.NICKNAME,
				DBValorClasificadorEntidad.SELECR_BY_CLASIF_ENT_OID_ITEM, condiciones, new ObjetoObservado(), aSesion);
	}

	public static ValorClasificadorEntidad getValorClasifEnt(ClasificadorEntidad clasifEnt, String codigo, ISesion aSesion)
			throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put("codigo", codigo);
		condiciones.put(ClasificadorEntidad.NICKNAME, clasifEnt);
		return (ValorClasificadorEntidad) ObjetoLogico.getObjects(ValorClasificadorEntidad.NICKNAME,
				DBValorClasificadorEntidad.SELECT_BY_CLASIF_ENT_CODIGO, condiciones, new ObjetoObservado(), aSesion);
	}

	public static List getRangosValoresClasifEntidad(ClasificadorEntidad clasificadorEntidad, ISesion aSesion)
			throws BaseException {
		return (List) ObjetoLogico.getObjects(ValorClasificadorEntidad.NICKNAME,
				DBValorClasificadorEntidad.SELECT_BY_RANGOS, clasificadorEntidad, new ListObserver(), aSesion);
	}
	
	public static List getValoresClasifProdGralNotInLP(ListaPrecios listaPrecios, ISesion aSesion)
	throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put(ListaPrecios.NICKNAME, listaPrecios);
		return (List) ObjetoLogico.getObjects(ValorClasificadorEntidad.NICKNAME,
											  DBValorClasificadorEntidad.SELECT_BY_PROF_GRAL_NOT_IN_LP_GRAL, 
											  condiciones, 
											  new ListObserver(), 
											  aSesion);
	}
	
	public static List getAllValoresClasifProdGrales(ISesion aSesion)
	throws BaseException {
		return (List) ObjetoLogico.getObjects(ValorClasifEntProdGen.NICKNAME,
											  DBValorClasificadorEntidad.SELECT_BY_ALL_PROD_GRALES, 
											  null, 
											  new ListObserver(), 
											  aSesion);
	}
	
	public static int getUltimoNroItem(ISesion aSesion , ClasificadorEntidad clasif) throws BaseException {

			 try { 
			    StringBuffer textSQL = new StringBuffer();

			    textSQL.append("SELECT max(oid_item) max_nro_item FROM  geValClasifEnt ");
			    textSQL.append(" WHERE oid_clasif_ent = "+clasif.getOIDInteger());

			    PreparedStatement querySelect = aSesion.getConexionBD().prepareStatement(textSQL.toString());
			    
			    ResultSet rs = querySelect.executeQuery();
			    int ultimoNro = 0;
			    if (rs.next())
			    	ultimoNro = rs.getInt(1);
			    rs.close();
			    querySelect.close();	    
			    
			    return ultimoNro;
			 }
			 catch(Exception e) {
				 throw new BaseException(null,e.getMessage());
			 }
			 
	}
	
	
	

}
