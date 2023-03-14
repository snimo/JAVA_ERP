package com.srn.erp.compras.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.compras.bm.InformeControlCalidad;
import com.srn.erp.compras.bm.InformeControlCalidadDet;
import com.srn.erp.compras.bm.InformeRecepcion;
import com.srn.erp.compras.bm.Proveedor;
import com.srn.erp.general.bm.ComproCab;
import com.srn.erp.general.bm.Talonario;
import com.srn.erp.stock.bm.Producto;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;

public class DBInformeControlCalidadDet extends DBObjetoPersistente {

	public static final String	OID_CC_DET						= "oid_cc_det";

	public static final String	OID_CC								= "oid_cc";

	public static final String	OID_INF_REC_DET				= "oid_inf_rec_det";

	public static final String	CANT_OK_US						= "cant_ok_us";

	public static final String	CANT_OK_UC						= "cant_ok_uc";

	public static final String	CANT_MAL_US						= "cant_mal_us";

	public static final String	CANT_MAL_UC						= "cant_mal_uc";

	public static final String	OBSERVACIONES					= "observaciones";

	public static final String	CANT_RET_PROV_UC			= "cant_ret_prov_uc";

	public static final String	CANT_RET_PROV_US			= "cant_ret_prov_us";

	public static final String	PEND_RET_PROV					= "pend_ret_prov";

	public static final String	ANULADO								= "anulado";

	public static final int			SELECT_BY_INF_CC			= 100;

	public static final int			SELECT_BY_CONDICIONES	= 101;
	
	public static final int     SELECT_BY_OID_DETALLES_INF_CC = 102; 

	public DBInformeControlCalidadDet() {
	}

	protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_CC_DET = 1;
		final int OID_CC = 2;
		final int OID_INF_REC_DET = 3;
		final int CANT_OK_US = 4;
		final int CANT_OK_UC = 5;
		final int CANT_MAL_US = 6;
		final int CANT_MAL_UC = 7;
		final int OBSERVACIONES = 8;
		final int CANT_RET_PROV_UC = 9;
		final int CANT_RET_PROV_US = 10;
		final int PEND_RET_PROV = 11;
		final int ANULADO = 12;

		InformeControlCalidadDet pers = (InformeControlCalidadDet) objetoPersistente;

		StringBuffer sqlInsert = new StringBuffer();
		sqlInsert.append(" insert into cpCtrlCalidadDet " + " ( " + "OID_CC_DET," + "OID_CC," + "OID_INF_REC_DET,"
				+ "CANT_OK_US," + "CANT_OK_UC," + "CANT_MAL_US," + "CANT_MAL_UC," + "OBSERVACIONES," + "CANT_RET_PROV_UC,"
				+ "CANT_RET_PROV_US," + "PEND_RET_PROV," + "ANULADO)" + " values " + "(" + "?," + "?," + "?," + "?," + "?,"
				+ "?," + "?," + "?," + "?," + "?," + "?," + "?) ");

		PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
		qInsert.setInt(OID_CC_DET, pers.getOID());
		qInsert.setInt(OID_CC, pers.getInforme_cc().getOID());
		qInsert.setInt(OID_INF_REC_DET, pers.getInforme_recepcion_det().getOID());
		qInsert.setDouble(CANT_OK_US, pers.getCant_ok_us().doubleValue());
		qInsert.setDouble(CANT_OK_UC, pers.getCant_ok_uc().doubleValue());
		qInsert.setDouble(CANT_MAL_US, pers.getCant_mal_us().doubleValue());
		qInsert.setDouble(CANT_MAL_UC, pers.getCant_mal_uc().doubleValue());
		qInsert.setString(OBSERVACIONES, pers.getObservaciones());
		qInsert.setDouble(CANT_RET_PROV_UC, pers.getCant_ret_prov_uc().doubleValue());
		qInsert.setDouble(CANT_RET_PROV_US, pers.getCant_ret_prov_us().doubleValue());
		qInsert.setBoolean(PEND_RET_PROV, pers.isPend_ret_prov().booleanValue());
		qInsert.setBoolean(ANULADO, pers.isAnulado().booleanValue());
		qInsert.executeUpdate();
		qInsert.close();
	}

	protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_CC = 1;
		final int OID_INF_REC_DET = 2;
		final int CANT_OK_US = 3;
		final int CANT_OK_UC = 4;
		final int CANT_MAL_US = 5;
		final int CANT_MAL_UC = 6;
		final int OBSERVACIONES = 7;
		final int CANT_RET_PROV_UC = 8;
		final int CANT_RET_PROV_US = 9;
		final int PEND_RET_PROV = 10;
		final int ANULADO = 11;
		final int OID_CC_DET = 12;

		InformeControlCalidadDet pers = (InformeControlCalidadDet) objetoPersistente;

		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append(" update cpCtrlCalidadDet set " + "oid_cc=?" + ",oid_inf_rec_det=?" + ",cant_ok_us=?"
				+ ",cant_ok_uc=?" + ",cant_mal_us=?" + ",cant_mal_uc=?" + ",observaciones=?" + ",cant_ret_prov_uc=?"
				+ ",cant_ret_prov_us=?" + ",pend_ret_prov=?" + ",anulado=?" + " where " + " oid_cc_det=? ");

		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_CC_DET, pers.getOID());
		qUpdate.setInt(OID_CC, pers.getInforme_cc().getOID());
		qUpdate.setInt(OID_INF_REC_DET, pers.getInforme_recepcion_det().getOID());
		qUpdate.setDouble(CANT_OK_US, pers.getCant_ok_us().doubleValue());
		qUpdate.setDouble(CANT_OK_UC, pers.getCant_ok_uc().doubleValue());
		qUpdate.setDouble(CANT_MAL_US, pers.getCant_mal_us().doubleValue());
		qUpdate.setDouble(CANT_MAL_UC, pers.getCant_mal_uc().doubleValue());
		qUpdate.setString(OBSERVACIONES, pers.getObservaciones());
		qUpdate.setDouble(CANT_RET_PROV_UC, pers.getCant_ret_prov_uc().doubleValue());
		qUpdate.setDouble(CANT_RET_PROV_US, pers.getCant_ret_prov_us().doubleValue());
		qUpdate.setBoolean(PEND_RET_PROV, pers.isPend_ret_prov().booleanValue());
		qUpdate.setBoolean(ANULADO, pers.isAnulado().booleanValue());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_CC_DET = 1;
		InformeControlCalidadDet pers = (InformeControlCalidadDet) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update cpCtrlCalidadDet " + " set anulado=1 " + " where " + " oid_cc_det=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_CC_DET, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_CC_DET = 1;
		InformeControlCalidadDet pers = (InformeControlCalidadDet) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update cpCtrlCalidadDet " + " set anulado=0 " + " where " + " oid_cc_det=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_CC_DET, pers.getOID());
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
		case SELECT_BY_INF_CC: {
			ps = this.selectByInfCC(aCondiciones);
			break;
		}
		case SELECT_BY_CONDICIONES: {
			ps = this.selectByCondiciones(aCondiciones);
			break;
		}
		case SELECT_BY_OID_DETALLES_INF_CC: {
			ps = this.selectByOidDetInfCC(aCondiciones);
			break;
		}
		}
		return ps;
	}

	private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

		final int OID_CC_DET = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cpCtrlCalidadDet ");
		textSQL.append(" WHERE oid_cc_det = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		int oid = ((Integer) aCondiciones).intValue();
		querySelect.setInt(OID_CC_DET, oid);
		return querySelect;
	}

	private PreparedStatement selectByInfCC(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cpCtrlCalidadDet ");
		textSQL.append(" WHERE oid_cc = ? and anulado=0");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		InformeControlCalidad infCC = (InformeControlCalidad) aCondiciones;
		querySelect.setInt(1, infCC.getOID());
		return querySelect;
	}

	private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

		final int CODIGO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cpCtrlCalidadDet ");
		textSQL.append(" WHERE  = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		String codigo = (String) aCondiciones;
		querySelect.setString(CODIGO, codigo);
		return querySelect;
	}
	
	private PreparedStatement selectByOidDetInfCC(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer inOidDetInfCC = new StringBuffer();
		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		Iterator iterOidDetInfCC = condiciones.values().iterator();
		while (iterOidDetInfCC.hasNext()) {
			Integer oidInfCCDet = (Integer) iterOidDetInfCC.next();
			if (inOidDetInfCC.length() == 0)
				inOidDetInfCC.append("("+oidInfCCDet.toString());
			else
				inOidDetInfCC.append(","+oidInfCCDet.toString());
		}
		inOidDetInfCC.append(")");

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cpCtrlCalidadDet ");
		textSQL.append(" WHERE oid_cc_det in "+inOidDetInfCC.toString());
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}
	
	private PreparedStatement selectByCondiciones(Object aCondiciones) throws BaseException, SQLException {
		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT a.*,b.* FROM geComproCab a , cpCtrlCalidadDet b , cpCtrlCalidad c ");
		textSQL.append(" WHERE a.oid_cco = c.oid_cc and b.oid_cc = c.oid_cc ");
		
		// Filtrar por proveedor
		Proveedor proveedor = (Proveedor) condiciones.get(Proveedor.NICKNAME);
		if (proveedor!=null) {
			textSQL.append(" and b.oid_cc_det in "); 
			textSQL.append(" (select calDet.oid_cc_det from cpInfRecep infrec , cpInfRecepdet infrecDet , cpCtrlCalidadDet calDet "); 
			textSQL.append(" where "); 
			textSQL.append(" infrec.oid_proveedor = "+proveedor.getOIDInteger().toString()+" and "); 
			textSQL.append(" infrec.oid_inf_rec =  infrecDet.oid_inf_rec and ");
			textSQL.append(" calDet.oid_inf_rec_det = infrecDet.oid_inf_rec_det) ");
		}
		
		// Filtrar por producto
		Producto producto = (Producto) condiciones.get(Producto.NICKNAME);
		if (producto!=null) {
			textSQL.append(" and b.oid_cc_det in "); 
			textSQL.append(" (select calDet.oid_cc_det from cpInfRecepdet infrecDet , cpCtrlCalidadDet calDet "); 
			textSQL.append(" where "); 
			textSQL.append(" infrecDet.oid_producto = "+producto.getOIDInteger().toString()+" and "); 
			textSQL.append(" calDet.oid_inf_rec_det = infrecDet.oid_inf_rec_det) ");
		}
		
		// Filtro por Fechas
		Date fechaDesde = (java.util.Date) condiciones.get("FEC_EMI_DESDE");
		Date fechaHasta = (java.util.Date) condiciones.get("FEC_EMI_HASTA");
		if ((fechaDesde!=null) && (fechaHasta!=null)) {
			textSQL.append(" and a.emision>=? and a.emision<=? ");
		}
		
		// Filtrar por Estado}
		String estado = (String) condiciones.get("estado");
		if (estado!=null) {
		  if (estado.equals("OK")) 
			  textSQL.append(" and b.cant_mal_us = 0 ");
	    else if (estado.equals("MAL")) 
				    textSQL.append(" and b.cant_mal_us > 0 ");
		}
		
		// Talonario
		Talonario talonario = (Talonario) condiciones.get(Talonario.NICKNAME);
		if (talonario!=null) 
			textSQL.append(" and a.oid_talonario = "+talonario.getOIDInteger().toString());
		
		//	 Nro. desde y nro. hasta
		Integer nroDesde = (Integer) condiciones.get("NRO_DESDE");
		Integer nroHasta = (Integer) condiciones.get("NRO_HASTA");
		if ((nroDesde!=null) && (nroHasta!=null)) {
			textSQL.append(" and a.nro_ext>="+nroDesde.toString()+" and a.nro_ext<="+nroHasta.toString()+" ");
		}
		
		// Informe Control de calidad
		ComproCab infCC = (ComproCab) condiciones.get(InformeControlCalidad.NICKNAME);
		if (infCC!=null) 
			textSQL.append(" and b.oid_cc = "+infCC.getOIDInteger().toString());
		
		// Informe Control de calidad
		ComproCab infRec = (ComproCab) condiciones.get(InformeRecepcion.NICKNAME);
		if (infRec!=null) {
			textSQL.append(" and b.oid_cc_det in "); 
			textSQL.append(" (select calDet.oid_cc_det from cpInfRecep infrec , cpInfRecepdet infrecDet , cpCtrlCalidadDet calDet "); 
			textSQL.append(" where "); 
			textSQL.append(" infrec.oid_inf_rec = "+infRec.getOIDInteger().toString()+" and "); 
			textSQL.append(" infrec.oid_inf_rec =  infrecDet.oid_inf_rec and ");
			textSQL.append(" calDet.oid_inf_rec_det = infrecDet.oid_inf_rec_det) ");

		}
		
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		if ((fechaDesde!=null) && (fechaHasta!=null)) {
			querySelect.setDate(1,new java.sql.Date(fechaDesde.getTime()));
			querySelect.setDate(2,new java.sql.Date(fechaHasta.getTime()));
		}
		return querySelect;
	}

	private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();

		textSQL.append("SELECT oid_cc_det oid, codigo,  descripcion ,activo ");
		textSQL.append(" from cpCtrlCalidadDet");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}

	public static List getDetallesInfCC(InformeControlCalidad infCC, ISesion aSesion) throws BaseException {
		return (List) ObjetoLogico.getObjects(InformeControlCalidadDet.NICKNAME,
				DBInformeControlCalidadDet.SELECT_BY_INF_CC, infCC, new ListObserver(), aSesion);
	}
	
	public static List getDetallesInfCCByCondiciones(HashTableDatos condiciones, ISesion aSesion) throws BaseException {
		return (List) ObjetoLogico.getObjects(InformeControlCalidadDet.NICKNAME,
				DBInformeControlCalidadDet.SELECT_BY_CONDICIONES, condiciones, new ListObserver(), aSesion);
	}
	
	public static List getDetallesInfCCByListaOids(HashTableDatos condiciones, ISesion aSesion) throws BaseException {
		return (List) ObjetoLogico.getObjects(InformeControlCalidadDet.NICKNAME,
				DBInformeControlCalidadDet.SELECT_BY_OID_DETALLES_INF_CC, condiciones, new ListObserver(), aSesion);
	}
	
	

}
