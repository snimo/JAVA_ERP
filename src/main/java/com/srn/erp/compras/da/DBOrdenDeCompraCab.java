package com.srn.erp.compras.da;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import com.srn.erp.compras.bm.OrdenDeCompraCab;
import com.srn.erp.compras.bm.Proveedor;
import com.srn.erp.general.bm.Periodo;
import com.srn.erp.general.bm.Talonario;
import com.srn.erp.general.da.DBPeriodo;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.ObjetoObservado;

public class DBOrdenDeCompraCab extends DBObjetoPersistente {

	public static final String	OID_OC								= "OID_OC";

	public static final String	OID_PROVEEDOR					= "OID_PROVEEDOR";

	public static final String	IMPORTACION						= "IMPORTACION";

	public static final String	ENVIADA								= "ENVIADA";

	public static final String	FEC_ENVIO							= "FEC_ENVIO";

	public static final String	CONFIRMO_RECEP				= "CONFIRMO_RECEP";

	public static final String	FEC_CONFIRMO_RECEP		= "FEC_CONFIRMO_RECEP";

	public static final String	OID_VIA_DESPACHO			= "OID_VIA_DESPACHO";

	public static final String	OID_COND_CPRA_IMP			= "OID_COND_CPRA_IMP";

	public static final String	FEC_EST_AUTORIZ				= "FEC_EST_AUTORIZ";

	public static final String	OID_COND_PAGO_2				= "OID_COND_PAGO_2";

	public static final String	OID_COND_PAGO_1				= "OID_COND_PAGO_1";

	public static final String	OBS_GENERALES					= "OBS_GENERALES";

	public static final String	ESTADO_AUTORIZ				= "ESTADO_AUTORIZ";

	public static final String	OID_MONEDA						= "OID_MONEDA";

	public static final String	ABIERTA								= "ABIERTA";

	public static final String	TIPO_OC								= "TIPO_OC";

	public static final String	TOMAR_PRECIOS_DE			= "TOMAR_PRECIOS_DE";

	public static final String	DTO_1_1								= "DTO_1_1";

	public static final String	DTO_1_2								= "DTO_1_2";

	public static final String	DTO_1_3								= "DTO_1_3";

	public static final String	DTO_2_1								= "DTO_2_1";

	public static final String	DTO_2_2								= "DTO_2_2";

	public static final String	DTO_2_3								= "DTO_2_3";

	public static final String	DTO_EN_CASCADA				= "dto_en_cascada";

	public static final String	PORC_RECARGO					= "porc_recargo";

	public static final String	COTIZACION						= "cotizacion";

	public static final String	OID_SECTOR_COMPRA			= "oid_sector_compra";
	
	public static final String 	OID_LUGAR_ENT					= "oid_lugar_ent";
	
	public static final String 	AGRUPA_ITEMS_IMPRE		        = "agrupa_items_impre";
	
	
	public static final int			SELECT_BY_CONDICIONES	= 100;
	
	public static final int			SELECT_BY_NRO_EXT = 101;
	
	public static final int 		UPDATE_ESTADO_AUTORIZ_Y_FECHA = 102;

	public DBOrdenDeCompraCab() {
	}

	protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_OC = 1;
		final int OID_PROVEEDOR = 2;
		final int IMPORTACION = 3;
		final int ENVIADA = 4;
		final int FEC_ENVIO = 5;
		final int CONFIRMO_RECEP = 6;
		final int FEC_CONFIRMO_RECEP = 7;
		final int OID_VIA_DESPACHO = 8;
		final int OID_COND_CPRA_IMP = 9;
		final int FEC_EST_AUTORIZ = 10;
		final int OID_COND_PAGO_2 = 11;
		final int OID_COND_PAGO_1 = 12;
		final int OBS_GENERALES = 13;
		final int ESTADO_AUTORIZ = 14;
		final int OID_MONEDA = 15;
		final int ABIERTA = 16;
		final int TIPO_OC = 17;
		final int TOMAR_PRECIOS_DE = 18;
		final int DTO_1_1 = 19;
		final int DTO_1_2 = 20;
		final int DTO_1_3 = 21;
		final int DTO_2_1 = 22;
		final int DTO_2_2 = 23;
		final int DTO_2_3 = 24;
		final int DTO_EN_CASCADA = 25;
		final int PORC_RECARGO = 26;
		final int COTIZACION = 27;
		final int OID_SECTOR_COMPRA = 28;
		final int OID_LUGAR_ENT = 29;
		final int AGRUPA_ITEMS_IMPRE = 30;

		OrdenDeCompraCab pers = (OrdenDeCompraCab) objetoPersistente;

		StringBuffer sqlInsert = new StringBuffer();
		sqlInsert.append(" insert into CPOCCAB " + " ( " + "OID_OC," + "OID_PROVEEDOR," + "IMPORTACION," + "ENVIADA,"
				+ "FEC_ENVIO," + "CONFIRMO_RECEP," + "FEC_CONFIRMO_RECEP," + "OID_VIA_DESPACHO," + "OID_COND_CPRA_IMP,"
				+ "FEC_EST_AUTORIZ," + "OID_COND_PAGO_2," + "OID_COND_PAGO_1," + "OBS_GENERALES," + "ESTADO_AUTORIZ,"
				+ "OID_MONEDA," + "ABIERTA," + "TIPO_OC," + "TOMAR_PRECIOS_DE," + "DTO_1_1," + "DTO_1_2," + "DTO_1_3,"
				+ "DTO_2_1," + "DTO_2_2," + "DTO_2_3,DTO_EN_CASCADA,PORC_RECARGO,COTIZACION,OID_SECTOR_COMPRA ,OID_LUGAR_ENT,AGRUPA_ITEMS_IMPRE)" + " values "
				+ "(" + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?,"
				+ "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?,"+ "?,"+ "?," + "?) ");

		PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
		qInsert.setInt(OID_OC, pers.getOID());
		qInsert.setInt(OID_PROVEEDOR, pers.getProveedor().getOID());
		qInsert.setBoolean(IMPORTACION, pers.isImportacion().booleanValue());
		qInsert.setBoolean(ENVIADA, pers.isEnviada().booleanValue());
		if (pers.getFecha_envio() != null)
			qInsert.setDate(FEC_ENVIO, new Date(pers.getFecha_envio().getTime()));
		else
			qInsert.setNull(FEC_ENVIO, java.sql.Types.DATE);
		qInsert.setBoolean(CONFIRMO_RECEP, pers.isConfirmo_recepcion().booleanValue());
		if (pers.getFecha_confirmo_recepcion() != null)
			qInsert.setDate(FEC_CONFIRMO_RECEP, new Date(pers.getFecha_confirmo_recepcion().getTime()));
		else
			qInsert.setNull(FEC_CONFIRMO_RECEP, java.sql.Types.INTEGER);
		if (pers.getVia_despacho() != null)
			qInsert.setInt(OID_VIA_DESPACHO, pers.getVia_despacho().getOID());
		else
			qInsert.setNull(OID_VIA_DESPACHO, java.sql.Types.INTEGER);

		if (pers.getCond_compra_importacion() != null)
			qInsert.setInt(OID_COND_CPRA_IMP, pers.getCond_compra_importacion().getOID());
		else
			qInsert.setNull(OID_COND_CPRA_IMP, java.sql.Types.INTEGER);

		if (pers.getFec_estado_autorizacion() != null)
			qInsert.setDate(FEC_EST_AUTORIZ, new Date(pers.getFec_estado_autorizacion().getTime()));
		else
			qInsert.setNull(FEC_EST_AUTORIZ, java.sql.Types.DATE);
		if (pers.getCond_pago_2() != null)
			qInsert.setInt(OID_COND_PAGO_2, pers.getCond_pago_2().getOID());
		else
			qInsert.setNull(OID_COND_PAGO_2, java.sql.Types.INTEGER);
		if (pers.getCond_pago_1() != null)
			qInsert.setInt(OID_COND_PAGO_1, pers.getCond_pago_1().getOID());
		else
			qInsert.setNull(OID_COND_PAGO_1, java.sql.Types.INTEGER);
		if (pers.getObservaciones_generales() != null)
			qInsert.setString(OBS_GENERALES, pers.getObservaciones_generales());
		else
			qInsert.setNull(OBS_GENERALES, Types.VARCHAR);
		qInsert.setInt(ESTADO_AUTORIZ, pers.getEstado_autorizacion().intValue());
		qInsert.setInt(OID_MONEDA, pers.getMoneda().getOID());
		qInsert.setBoolean(ABIERTA, pers.isAbierta().booleanValue());
		qInsert.setString(TIPO_OC, pers.getTipo());
		if (pers.getTomar_precio_de()!=null)
			qInsert.setString(TOMAR_PRECIOS_DE, pers.getTomar_precio_de());
		else
			qInsert.setNull(TOMAR_PRECIOS_DE, java.sql.Types.VARCHAR);
		if (pers.getDto_1_1() != null)
			qInsert.setDouble(DTO_1_1, pers.getDto_1_1().doubleValue());
		else
			qInsert.setNull(DTO_1_1, Types.DOUBLE);
		if (pers.getDto_1_2() != null)
			qInsert.setDouble(DTO_1_2, pers.getDto_1_2().doubleValue());
		else
			qInsert.setNull(DTO_1_2, Types.DOUBLE);
		if (pers.getDto_1_3() != null)
			qInsert.setDouble(DTO_1_3, pers.getDto_1_3().doubleValue());
		else
			qInsert.setNull(DTO_1_3, Types.DOUBLE);
		if (pers.getDto_2_1() != null)
			qInsert.setDouble(DTO_2_1, pers.getDto_2_1().doubleValue());
		else
			qInsert.setNull(DTO_2_1, Types.DOUBLE);
		if (pers.getDto_2_2() != null)
			qInsert.setDouble(DTO_2_2, pers.getDto_2_2().doubleValue());
		else
			qInsert.setNull(DTO_2_2, Types.DOUBLE);
		if (pers.getDto_2_3() != null)
			qInsert.setDouble(DTO_2_3, pers.getDto_2_3().doubleValue());
		else
			qInsert.setNull(DTO_2_3, Types.DOUBLE);
		if (pers.isDtoEnCascada() != null)
			qInsert.setBoolean(DTO_EN_CASCADA, pers.isDtoEnCascada().booleanValue());
		else
			qInsert.setNull(DTO_EN_CASCADA, Types.BOOLEAN);
		if (pers.getPorcRecargo() != null)
			qInsert.setDouble(PORC_RECARGO, pers.getPorcRecargo().doubleValue());
		else
			qInsert.setNull(PORC_RECARGO, Types.DOUBLE);
		if (pers.getCotizacion() != null)
			qInsert.setDouble(COTIZACION, pers.getCotizacion().doubleValue());
		else
			qInsert.setNull(COTIZACION, Types.DOUBLE);
		if (pers.getSectorCompra() != null)
			qInsert.setInt(OID_SECTOR_COMPRA, pers.getSectorCompra().getOID());
		else
			qInsert.setNull(OID_SECTOR_COMPRA, Types.INTEGER);
		if (pers.getLugarEntrega()!=null)
			qInsert.setInt(OID_LUGAR_ENT,pers.getLugarEntrega().getOID());
		else
			qInsert.setNull(OID_LUGAR_ENT,Types.INTEGER);
		if (pers.isAgrupaItemsImpresion()!=null)
			qInsert.setBoolean(AGRUPA_ITEMS_IMPRE,pers.isAgrupaItemsImpresion().booleanValue());
		else
			qInsert.setBoolean(OID_LUGAR_ENT,false);
		
		qInsert.executeUpdate();
		qInsert.close();
	}

	protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_PROVEEDOR = 1;
		final int IMPORTACION = 2;
		final int ENVIADA = 3;
		final int FEC_ENVIO = 4;
		final int CONFIRMO_RECEP = 5;
		final int FEC_CONFIRMO_RECEP = 6;
		final int OID_VIA_DESPACHO = 7;
		final int OID_COND_CPRA_IMP = 8;
		final int FEC_EST_AUTORIZ = 9;
		final int OID_COND_PAGO_2 = 10;
		final int OID_COND_PAGO_1 = 11;
		final int OBS_GENERALES = 12;
		final int ESTADO_AUTORIZ = 13;
		final int OID_MONEDA = 14;
		final int ABIERTA = 15;
		final int TIPO_OC = 16;
		final int TOMAR_PRECIOS_DE = 17;
		final int DTO_1_1 = 18;
		final int DTO_1_2 = 19;
		final int DTO_1_3 = 20;
		final int DTO_2_1 = 21;
		final int DTO_2_2 = 22;
		final int DTO_2_3 = 23;
		final int DTO_EN_CASCADA = 24;
		final int PORC_RECARGO = 25;
		final int COTIZACION = 26;
		final int OID_SECTOR_COMPRA = 27;
		final int OID_LUGAR_ENT = 28;
		final int AGRUPA_ITEMS_IMPRE = 29;
		final int OID_OC = 30;

		OrdenDeCompraCab pers = (OrdenDeCompraCab) objetoPersistente;

		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append(" update CPOCCAB set " + "OID_PROVEEDOR=?" + ",IMPORTACION=?" + ",ENVIADA=?" + ",FEC_ENVIO=?"
				+ ",CONFIRMO_RECEP=?" + ",FEC_CONFIRMO_RECEP=?" + ",OID_VIA_DESPACHO=?" + ",OID_COND_CPRA_IMP=?"
				+ ",FEC_EST_AUTORIZ=?" + ",OID_COND_PAGO_2=?" + ",OID_COND_PAGO_1=?" + ",OBS_GENERALES=?" + ",ESTADO_AUTORIZ=?"
				+ ",OID_MONEDA=?" + ",ABIERTA=?" + ",TIPO_OC=?" + ",TOMAR_PRECIOS_DE=?" + ",DTO_1_1=?" + ",DTO_1_2=?"
				+ ",DTO_1_3=?" + ",DTO_2_1=?" + ",DTO_2_2=?" + ",DTO_2_3=?" + ",DTO_EN_CASCADA=?" + ",PORC_RECARGO=?"
				+ ",COTIZACION=?" + ",OID_SECTOR_COMPRA=? , OID_LUGAR_ENT = ? , AGRUPA_ITEMS_IMPRE = ? " + " where " + " oid_oc=? ");

		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_OC, pers.getOID());
		qUpdate.setInt(OID_PROVEEDOR, pers.getProveedor().getOID());
		qUpdate.setBoolean(IMPORTACION, pers.isImportacion().booleanValue());
		qUpdate.setBoolean(ENVIADA, pers.isEnviada().booleanValue());
		if (pers.getFecha_envio() != null)
			qUpdate.setDate(FEC_ENVIO, new Date(pers.getFecha_envio().getTime()));
		else
			qUpdate.setNull(FEC_ENVIO, java.sql.Types.INTEGER);
		qUpdate.setBoolean(CONFIRMO_RECEP, pers.isConfirmo_recepcion().booleanValue());
		if (pers.getFecha_confirmo_recepcion() != null)
			qUpdate.setDate(FEC_CONFIRMO_RECEP, new Date(pers.getFecha_confirmo_recepcion().getTime()));
		else
			qUpdate.setNull(FEC_CONFIRMO_RECEP, java.sql.Types.DATE);
		if (pers.getVia_despacho() != null)
			qUpdate.setInt(OID_VIA_DESPACHO, pers.getVia_despacho().getOID());
		else
			qUpdate.setNull(OID_VIA_DESPACHO, Types.INTEGER);
		if (pers.getCond_compra_importacion() != null)
			qUpdate.setInt(OID_COND_CPRA_IMP, pers.getCond_compra_importacion().getOID());
		else
			qUpdate.setNull(OID_COND_CPRA_IMP, Types.INTEGER);
		if (pers.getFec_estado_autorizacion() != null)
			qUpdate.setDate(FEC_EST_AUTORIZ, new Date(pers.getFec_estado_autorizacion().getTime()));
		else
			qUpdate.setNull(FEC_EST_AUTORIZ, java.sql.Types.DATE);
		if (pers.getCond_pago_2() != null)
			qUpdate.setInt(OID_COND_PAGO_2, pers.getCond_pago_2().getOID());
		else
			qUpdate.setNull(OID_COND_PAGO_2, java.sql.Types.INTEGER);

		qUpdate.setInt(OID_COND_PAGO_1, pers.getCond_pago_1().getOID());

		if (pers.getObservaciones_generales() != null)
			qUpdate.setString(OBS_GENERALES, pers.getObservaciones_generales());
		else
			qUpdate.setNull(OBS_GENERALES, Types.VARCHAR);
		qUpdate.setInt(ESTADO_AUTORIZ, pers.getEstado_autorizacion().intValue());
		qUpdate.setInt(OID_MONEDA, pers.getMoneda().getOID());
		if (pers.isAbierta() != null)
			qUpdate.setBoolean(ABIERTA, pers.isAbierta().booleanValue());
		else
			qUpdate.setBoolean(ABIERTA, true);
		qUpdate.setString(TIPO_OC, pers.getTipo());
		
		if (pers.getTomar_precio_de()!=null)
			qUpdate.setString(TOMAR_PRECIOS_DE, pers.getTomar_precio_de());
		else
			qUpdate.setNull(TOMAR_PRECIOS_DE, java.sql.Types.VARCHAR);
		
		if (pers.getDto_1_1() != null)
			qUpdate.setDouble(DTO_1_1, pers.getDto_1_1().doubleValue());
		else
			qUpdate.setNull(DTO_1_1, Types.DOUBLE);
		if (pers.getDto_1_2() != null)
			qUpdate.setDouble(DTO_1_2, pers.getDto_1_2().doubleValue());
		else
			qUpdate.setNull(DTO_1_2, Types.DOUBLE);
		if (pers.getDto_1_3() != null)
			qUpdate.setDouble(DTO_1_3, pers.getDto_1_3().doubleValue());
		else
			qUpdate.setNull(DTO_1_3, Types.DOUBLE);
		if (pers.getDto_1_1() != null)
			qUpdate.setDouble(DTO_2_1, pers.getDto_2_1().doubleValue());
		else
			qUpdate.setNull(DTO_2_1, Types.DOUBLE);
		if (pers.getDto_1_2() != null)
			qUpdate.setDouble(DTO_2_2, pers.getDto_2_2().doubleValue());
		else
			qUpdate.setNull(DTO_2_2, Types.DOUBLE);
		if (pers.getDto_2_3() != null)
			qUpdate.setDouble(DTO_2_3, pers.getDto_2_3().doubleValue());
		else
			qUpdate.setNull(DTO_2_3, Types.DOUBLE);

		if (pers.isDtoEnCascada() != null)
			qUpdate.setBoolean(DTO_EN_CASCADA, pers.isDtoEnCascada().booleanValue());
		else
			qUpdate.setNull(DTO_EN_CASCADA, Types.BOOLEAN);
		if (pers.getPorcRecargo() != null)
			qUpdate.setDouble(PORC_RECARGO, pers.getPorcRecargo().doubleValue());
		else
			qUpdate.setNull(PORC_RECARGO, Types.DOUBLE);
		if (pers.getCotizacion() != null)
			qUpdate.setDouble(COTIZACION, pers.getCotizacion().doubleValue());
		else
			qUpdate.setNull(COTIZACION, Types.DOUBLE);
		if (pers.getSectorCompra() != null)
			qUpdate.setInt(OID_SECTOR_COMPRA, pers.getSectorCompra().getOID());
		else
			qUpdate.setNull(OID_SECTOR_COMPRA, Types.INTEGER);
		if (pers.getLugarEntrega()!=null)
			qUpdate.setInt(OID_LUGAR_ENT,pers.getLugarEntrega().getOID());
		else
			qUpdate.setNull(OID_LUGAR_ENT,Types.INTEGER);
		if (pers.isAgrupaItemsImpresion()!=null)
			qUpdate.setBoolean(AGRUPA_ITEMS_IMPRE,pers.isAgrupaItemsImpresion().booleanValue());
		else
			qUpdate.setBoolean(OID_LUGAR_ENT,false);
		
		qUpdate.executeUpdate();
		qUpdate.close();
	}


	protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_OC = 1;
		OrdenDeCompraCab pers = (OrdenDeCompraCab) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update geComproCab " + " set activo=0 " + " where " + " oid_cco=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_OC, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_OC = 1;
		OrdenDeCompraCab pers = (OrdenDeCompraCab) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update geComproCab " + " set activo=1 " + " where " + " oid_cco=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_OC, pers.getOID());
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
		case SELECT_BY_CONDICIONES: {
			ps = this.selectByCondiciones(aCondiciones);
			break;
		}
		case SELECT_BY_NRO_EXT: {
			ps = this.selectByNroExt(aCondiciones);
			break;
		}
		case UPDATE_ESTADO_AUTORIZ_Y_FECHA: {
			ps = this.selectByEstadoAutorizyFecha(aCondiciones);
			break;
		}
		}
		return ps;
	}

	private PreparedStatement selectByCondiciones(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT a.*,b.* FROM  CPOCCAB a, GECOMPROCAB b where a.oid_oc = b.oid_cco ");
		textSQL.append(" AND 1=1 ");

		HashTableDatos condiciones = (HashTableDatos) aCondiciones;

		if (condiciones.containsKey(Proveedor.NICKNAME)) {
			Proveedor proveedor = (Proveedor) condiciones.get(Proveedor.NICKNAME);
			textSQL.append(" and a.oid_proveedor = " + proveedor.getOIDInteger().toString());
		}

		if (condiciones.containsKey(Talonario.NICKNAME)) {
			Talonario talonario = (Talonario) condiciones.get(Talonario.NICKNAME);
			textSQL.append(" and b.oid_talonario = " + talonario.getOIDInteger().toString());
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
			textSQL.append(" and b.emision >= ? ");

		if (condiciones.containsKey("FEC_HASTA"))
			textSQL.append(" and b.emision <= ? ");
		
		if (condiciones.containsKey("PEND_RECEP")) { // Pendiente de Recepción
			textSQL.append(" and oid_oc in ");
			textSQL.append(" ( ");
			textSQL.append(" select ");
			textSQL.append("   oid_cco_cpra ");
			textSQL.append(" from ");
			textSQL.append("   cpOCDet z1,cpOCCab z2,geComproCab z3 ");
			textSQL.append(" where ");
			textSQL.append("   z2.oid_oc = z1.oid_cco_cpra ");
			textSQL.append("   and z3.oid_cco = z2.oid_oc ");
			textSQL.append("   and z3.activo=1");
			textSQL.append("   and z1.anulado=0 and z1.pend_recep=1");
			textSQL.append(")   ");
		}
		
		
		if (condiciones.containsKey("FILTRO_OC")) {
			
			String filtroOC = condiciones.getString("FILTRO_OC");
			if (filtroOC.equals("TODOS_PEND_AUT")) {
				textSQL.append(" and a.estado_autoriz = 0 and b.activo = 1 ");
			}
			
			
			
			if (filtroOC.equals("MIS_PEND_AUT")) {
				textSQL.append(" and a.oid_oc in (");
				textSQL.append("   select "); 
				textSQL.append("     a.oid_oc "); 
				textSQL.append("   from "); 
				textSQL.append("     cpOCCab a , ");
				textSQL.append("     geComproCab b, ");
				textSQL.append("     cpOCCabAutoriz c, ");
				textSQL.append("     cpRolAurotiz d, ");
				textSQL.append("     cpUsuRolAutoriz e ");
				textSQL.append("   where ");
				textSQL.append("     a.oid_oc = b.oid_cco and ");
				textSQL.append("     b.activo = 1 and ");  
				textSQL.append("     a.estado_autoriz = 0  and "); 
				textSQL.append("     c.oid_cco_cpra = a.oid_oc and ");
				textSQL.append("     d.oid_rol_autoriz = c.oid_rol_autoriz and ");
				textSQL.append("     e.oid_rol_autoriz = d.oid_rol_autoriz and e.oid_usuario = "+this.getSesion().getLogin().getUsuario().getOIDInteger().toString()+" and ");
				textSQL.append("     c.decision_autoriz = 0 ) ");				
			}
			
			
			
		}
		

		int nroParam = 0;

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());

		if (condiciones.containsKey("FEC_DESDE")) {
			java.util.Date fecha = (java.util.Date) condiciones.get("FEC_DESDE");
			++nroParam;
			querySelect.setDate(nroParam, new Date(fecha.getTime()));
		}

		if (condiciones.containsKey("FEC_HASTA")) {
			java.util.Date fecha = (java.util.Date) condiciones.get("FEC_HASTA");
			++nroParam;
			querySelect.setDate(nroParam, new Date(fecha.getTime()));
		}
		
		
		//MIS_PEND_AUT // Mostrar solo mis pendientes de autorizacion

		return querySelect;
	}

	private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

		final int OID_OC = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  CPOCCAB a, GECOMPROCAB b where a.oid_oc = b.oid_cco ");
		textSQL.append(" and a.oid_oc = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		int oid = ((Integer) aCondiciones).intValue();
		querySelect.setInt(OID_OC, oid);
		return querySelect;
	}

	private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

		final int CODIGO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  CPOCCAB a, GECOMPROCAB b where a.oid_oc = b.oid_cco ");
		textSQL.append(" WHERE  = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		String codigo = (String) aCondiciones;
		querySelect.setString(CODIGO, codigo);
		return querySelect;
	}
	
	private PreparedStatement selectByEstadoAutorizyFecha(Object aCondiciones) throws BaseException, SQLException {

		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		Integer estadoAutorizacion = (Integer) condiciones.get("ESTADO_AUTORIZACION");
		java.util.Date fecha = (java.util.Date) condiciones.get("FECHA");
		OrdenDeCompraCab oc = (OrdenDeCompraCab) condiciones.get(OrdenDeCompraCab.NICKNAME);

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("update CPOCCAB set ESTADO_AUTORIZ=? , FEC_EST_AUTORIZ = ? where OID_OC = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		querySelect.setInt(1, estadoAutorizacion.intValue());
		querySelect.setDate(2, new java.sql.Date(fecha.getTime()));
		querySelect.setInt(3, oc.getOID());
		
		querySelect.executeUpdate();
		querySelect.close();
		
		return null;
		
	}
	
	
	
	
	private PreparedStatement selectByNroExt(Object aCondiciones) throws BaseException, SQLException {

		final int CODIGO = 1;
		
		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		Integer nroExt = (Integer) condiciones.get("NRO_EXT");
		Proveedor proveedor = (Proveedor) condiciones.get(Proveedor.NICKNAME);
		

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  CPOCCAB a, GECOMPROCAB b where a.oid_oc = b.oid_cco ");
		textSQL.append(" and b.nro_ext = ? and b.activo = 1  ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		querySelect.setInt(1, nroExt.intValue());
		return querySelect;
	}
	
	
	private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();

		textSQL.append("SELECT OID_OC oid, codigo,  descripcion ,activo ");
		textSQL.append(" from CPOCCAB");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}

	public static List getOrdenDeCompraCab(HashTableDatos aCondiciones, ISesion aSesion) throws BaseException {
		return (List) ObjetoLogico.getObjects(OrdenDeCompraCab.NICKNAME, DBOrdenDeCompraCab.SELECT_BY_CONDICIONES,
				aCondiciones, new ListObserver(), aSesion);
	}
	
	public static OrdenDeCompraCab getOrdenDeCompra(Integer nroExt,
	          										ISesion aSesion)
	          										throws BaseException {
		  HashTableDatos condiciones = new HashTableDatos();
		  condiciones.put("NRO_EXT", nroExt);
		  return (OrdenDeCompraCab) ObjetoLogico.getObjects(OrdenDeCompraCab.NICKNAME,
				  				DBOrdenDeCompraCab.SELECT_BY_NRO_EXT,
				  				condiciones,
				  				new ObjetoObservado(),
				  				aSesion);
	}
	
	public static void fijarEstadoDeAutorizacion(
				Integer estado,
				OrdenDeCompraCab oc,
				java.util.Date fecha,
				ISesion aSesion)
				throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put("ESTADO_AUTORIZACION", estado);
		condiciones.put("FECHA", fecha);
		condiciones.put(OrdenDeCompraCab.NICKNAME, oc);
		ObjetoLogico.getObjects(OrdenDeCompraCab.NICKNAME,
				DBOrdenDeCompraCab.UPDATE_ESTADO_AUTORIZ_Y_FECHA,
				condiciones,
				new ObjetoObservado(),
				aSesion);
	}
	
	

}
