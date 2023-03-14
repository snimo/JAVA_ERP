package com.srn.erp.compras.da;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import com.srn.erp.compras.bm.CotizacionProveedorCab;
import com.srn.erp.compras.bm.MotivoDecisionAdjudicacion;
import com.srn.erp.compras.bm.Proveedor;
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

public class DBCotizacionProveedorCab extends DBObjetoPersistente {

	public static final String OID_COTIZ_PROV_CAB = "oid_cotiz_prov_cab";

	public static final String OID_SOL_COTIZ_PROV = "oid_sol_cotiz_prov";

	public static final String OID_PROVEEDOR = "oid_proveedor";

	public static final String VIGENCIA_DESDE = "vigencia_desde";

	public static final String VIGENCIA_HASTA = "vigencia_hasta";

	public static final String OID_COND_PAGO_1 = "oid_cond_pago_1";

	public static final String DTO_COND_PAGO_1 = "dto_cond_pago_1";

	public static final String OID_COND_PAGO_2 = "oid_cond_pago_2";

	public static final String DTO_COND_PAGO_2 = "dto_cond_pago_2";

	public static final String ESTADO_ADJU = "estado_adju";

	public static final String FECHA_ESTADO_ADJU = "fecha_estado_adju";

	public static final String OID_USU_ADJU = "oid_usu_adju";

	public static final String OID_MOT_DECISION = "oid_mot_decision";

	public static final String COMEN_ADJU = "comen_adju";
	
	public static final String COT_ABIERTA = "cot_abierta";
	

	public static final int SELECT_BY_CONDICIONES = 100;
	
	public static final String OID_MONEDA = "oid_moneda";

	public DBCotizacionProveedorCab() {
	}

	protected void insert(IObjetoPersistente objetoPersistente)
			throws BaseException, SQLException {

		final int OID_COTIZ_PROV_CAB = 1;
		final int OID_SOL_COTIZ_PROV = 2;
		final int OID_PROVEEDOR = 3;
		final int VIGENCIA_DESDE = 4;
		final int VIGENCIA_HASTA = 5;
		final int OID_COND_PAGO_1 = 6;
		final int DTO_COND_PAGO_1 = 7;
		final int OID_COND_PAGO_2 = 8;
		final int DTO_COND_PAGO_2 = 9;
		final int ESTADO_ADJU = 10;
		final int FECHA_ESTADO_ADJU = 11;
		final int OID_USU_ADJU = 12;
		final int OID_MOT_DECISION = 13;
		final int COMEN_ADJU = 14;
		final int OID_MONEDA = 15;
		final int COT_ABIERTA = 16;

		CotizacionProveedorCab pers = (CotizacionProveedorCab) objetoPersistente;

		StringBuffer sqlInsert = new StringBuffer();
		sqlInsert
				.append(" insert into CPCOTIZPROVCAB "
						+ " ( "
						+ "OID_COTIZ_PROV_CAB,"
						+ "OID_SOL_COTIZ_PROV,"
						+ "OID_PROVEEDOR,"
						+ "VIGENCIA_DESDE,"
						+ "VIGENCIA_HASTA,"
						+ "OID_COND_PAGO_1,"
						+ "DTO_COND_PAGO_1,"
						+ "OID_COND_PAGO_2,"
						+ "DTO_COND_PAGO_2,"
						+ "ESTADO_ADJU,FECHA_ESTADO_ADJU,OID_USU_ADJU,OID_MOT_DECISION,COMEN_ADJU,OID_MONEDA,cot_abierta)"
						+ " values " + "(" + "?," + "?," + "?," + "?," + "?,"
						+ "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?,"+ "?,"
						+ "?,?) ");

		PreparedStatement qInsert = getSesion().getConexionBD()
				.prepareStatement(sqlInsert.toString());
		qInsert.setInt(OID_COTIZ_PROV_CAB, pers.getOID());
		if (pers.getSolicitud_cotiz_prov() != null)
			qInsert.setInt(OID_SOL_COTIZ_PROV, pers.getSolicitud_cotiz_prov()
					.getOID());
		else
			qInsert.setNull(OID_SOL_COTIZ_PROV, java.sql.Types.INTEGER);
		qInsert.setInt(OID_PROVEEDOR, pers.getProveedor().getOID());
		qInsert.setDate(VIGENCIA_DESDE, new Date(pers.getVigencia_desde()
				.getTime()));
		qInsert.setDate(VIGENCIA_HASTA, new Date(pers.getVigencia_hasta()
				.getTime()));
		if (pers.getCond_pago_1() != null)
			qInsert.setInt(OID_COND_PAGO_1, pers.getCond_pago_1().getOID());
		else
			qInsert.setNull(OID_COND_PAGO_1, java.sql.Types.INTEGER);

		if (pers.getDto_cond_pago_1() != null)
			qInsert.setDouble(DTO_COND_PAGO_1, pers.getDto_cond_pago_1()
					.doubleValue());
		else
			qInsert.setDouble(DTO_COND_PAGO_1, 0);
		if (pers.getCond_pago_2() != null)
			qInsert.setInt(OID_COND_PAGO_2, pers.getCond_pago_2().getOID());
		else
			qInsert.setInt(OID_COND_PAGO_2, java.sql.Types.INTEGER);
		if (pers.getDto_cond_pago_2() != null)
			qInsert.setDouble(DTO_COND_PAGO_2, pers.getDto_cond_pago_2()
					.doubleValue());
		else
			qInsert.setDouble(DTO_COND_PAGO_2, 0);
		qInsert.setInt(ESTADO_ADJU, pers.getEstadoAdjudicacion().intValue());
		if (pers.getFechaEstadoAdjudicacion() != null)
			qInsert.setDate(FECHA_ESTADO_ADJU, new Date(pers
					.getFechaEstadoAdjudicacion().getTime()));
		else
			qInsert.setNull(FECHA_ESTADO_ADJU, Types.DATE);
		if (pers.getUsuarioAdjudicacion() != null)
			qInsert
					.setInt(OID_USU_ADJU, pers.getUsuarioAdjudicacion()
							.getOID());
		else
			qInsert.setNull(OID_USU_ADJU, Types.INTEGER);
		if (pers.getMotivoDecisionAdjudicacion() != null)
			qInsert.setInt(OID_MOT_DECISION, pers
					.getMotivoDecisionAdjudicacion().getOID());
		else
			qInsert.setNull(OID_MOT_DECISION, Types.INTEGER);
		if (pers.getComentarioAdjudicacion() != null)
			qInsert.setString(COMEN_ADJU, pers.getComentarioAdjudicacion());
		else
			qInsert.setNull(COMEN_ADJU, Types.VARCHAR);
		qInsert.setInt(OID_MONEDA,pers.getMoneda().getOID());
		qInsert.setBoolean(COT_ABIERTA, pers.isCotizacionAbierta());
			
		qInsert.executeUpdate();
		qInsert.close();
	}

	protected void update(IObjetoPersistente objetoPersistente)
			throws BaseException, SQLException {

		final int OID_SOL_COTIZ_PROV = 1;
		final int OID_PROVEEDOR = 2;
		final int VIGENCIA_DESDE = 3;
		final int VIGENCIA_HASTA = 4;
		final int OID_COND_PAGO_1 = 5;
		final int DTO_COND_PAGO_1 = 6;
		final int OID_COND_PAGO_2 = 7;
		final int DTO_COND_PAGO_2 = 8;
		final int ESTADO_ADJU = 9;
		final int FECHA_ESTADO_ADJU = 10;
		final int OID_USU_ADJU = 11;
		final int OID_MOT_DECISION = 12;
		final int COMEN_ADJU = 13;
		final int OID_MONEDA = 14;
		final int COT_ABIERTA = 15;
		final int OID_COTIZ_PROV_CAB = 16;

		CotizacionProveedorCab pers = (CotizacionProveedorCab) objetoPersistente;

		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate
				.append(" update CPCOTIZPROVCAB set "
						+ "oid_sol_cotiz_prov=?"
						+ ",oid_proveedor=?"
						+ ",vigencia_desde=?"
						+ ",vigencia_hasta=?"
						+ ",oid_cond_pago_1=?"
						+ ",dto_cond_pago_1=?"
						+ ",oid_cond_pago_2=?"
						+ ",dto_cond_pago_2=?"
						+ ",ESTADO_ADJU=?,FECHA_ESTADO_ADJU=?,OID_USU_ADJU=?,OID_MOT_DECISION=?,COMEN_ADJU=?,OID_MONEDA=?,COT_ABIERTA=? "
						+ " where " + " oid_cotiz_prov_cab=? ");

		PreparedStatement qUpdate = getSesion().getConexionBD()
				.prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_COTIZ_PROV_CAB, pers.getOID());
		if (pers.getSolicitud_cotiz_prov() != null)
			qUpdate.setInt(OID_SOL_COTIZ_PROV, pers.getSolicitud_cotiz_prov()
					.getOID());
		else
			qUpdate.setNull(OID_SOL_COTIZ_PROV, java.sql.Types.INTEGER);
		qUpdate.setInt(OID_PROVEEDOR, pers.getProveedor().getOID());
		qUpdate.setDate(VIGENCIA_DESDE, new Date(pers.getVigencia_desde()
				.getTime()));
		qUpdate.setDate(VIGENCIA_HASTA, new Date(pers.getVigencia_hasta()
				.getTime()));
		if (pers.getCond_pago_1() != null)
			qUpdate.setInt(OID_COND_PAGO_1, pers.getCond_pago_1().getOID());
		else
			qUpdate.setInt(OID_COND_PAGO_1, java.sql.Types.INTEGER);
		if (pers.getDto_cond_pago_1() != null)
			qUpdate.setDouble(DTO_COND_PAGO_1, pers.getDto_cond_pago_1()
					.doubleValue());
		else
			qUpdate.setDouble(DTO_COND_PAGO_1, 0);
		if (pers.getCond_pago_2() != null)
			qUpdate.setInt(OID_COND_PAGO_2, pers.getCond_pago_2().getOID());
		else
			qUpdate.setNull(OID_COND_PAGO_2, Types.INTEGER);
		if (pers.getDto_cond_pago_2() != null)
			qUpdate.setDouble(DTO_COND_PAGO_2, pers.getDto_cond_pago_2()
					.doubleValue());
		else
			qUpdate.setDouble(DTO_COND_PAGO_2, 0);
		qUpdate.setInt(ESTADO_ADJU, pers.getEstadoAdjudicacion().intValue());
		if (pers.getFechaEstadoAdjudicacion() != null)
			qUpdate.setDate(FECHA_ESTADO_ADJU, new Date(pers
					.getFechaEstadoAdjudicacion().getTime()));
		else
			qUpdate.setNull(FECHA_ESTADO_ADJU, Types.DATE);
		if (pers.getUsuarioAdjudicacion() != null)
			qUpdate
					.setInt(OID_USU_ADJU, pers.getUsuarioAdjudicacion()
							.getOID());
		else
			qUpdate.setNull(OID_USU_ADJU, Types.INTEGER);
		if (pers.getMotivoDecisionAdjudicacion() != null)
			qUpdate.setInt(OID_MOT_DECISION, pers
					.getMotivoDecisionAdjudicacion().getOID());
		else
			qUpdate.setNull(OID_MOT_DECISION, Types.INTEGER);
		if (pers.getComentarioAdjudicacion() != null)
			qUpdate.setString(COMEN_ADJU, pers.getComentarioAdjudicacion());
		else
			qUpdate.setNull(COMEN_ADJU, Types.VARCHAR);
		qUpdate.setInt(OID_MONEDA,pers.getMoneda().getOID());
		qUpdate.setBoolean(COT_ABIERTA, pers.isCotizacionAbierta());

		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void delete(IObjetoPersistente objetoPersistente)
			throws BaseException, SQLException {
		final int OID_COTIZ_PROV_CAB = 1;
		CotizacionProveedorCab pers = (CotizacionProveedorCab) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update geComproCab " + " set activo=0 " + " where "
				+ " oid_cco=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD()
				.prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_COTIZ_PROV_CAB, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void rehabilitar(IObjetoPersistente objetoPersistente)
			throws BaseException, SQLException {
		final int OID_COTIZ_PROV_CAB = 1;
		CotizacionProveedorCab pers = (CotizacionProveedorCab) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update geComproCab " + " set activo=1 " + " where "
				+ " oid_cco=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD()
				.prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_COTIZ_PROV_CAB, pers.getOID());
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
		case SELECT_BY_CONDICIONES: {
			ps = this.selectByCondiciones(aCondiciones);
			break;
		}
		}
		return ps;
	}

	private PreparedStatement selectByOID(Object aCondiciones)
			throws BaseException, SQLException {

		final int OID_COTIZ_PROV_CAB = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append(" SELECT * FROM  geComproCab a,");
		textSQL.append(" CPCOTIZPROVCAB b ");
		textSQL
				.append(" WHERE a.oid_cco = b.oid_cotiz_prov_cab and b.oid_cotiz_prov_cab = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD()
				.prepareStatement(textSQL.toString());
		int oid = ((Integer) aCondiciones).intValue();
		querySelect.setInt(OID_COTIZ_PROV_CAB, oid);
		return querySelect;
	}

	private PreparedStatement selectByCondiciones(Object aCondiciones)
			throws BaseException, SQLException {
		final int CODIGO = 1;
		StringBuffer textSQL = new StringBuffer();
		textSQL.append(" SELECT * FROM  geComproCab a,");
		textSQL.append(" CPCOTIZPROVCAB b ");
		textSQL.append(" WHERE a.oid_cco = b.oid_cotiz_prov_cab  ");

		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		if (condiciones.containsKey(Proveedor.NICKNAME))
			textSQL.append(" and b.oid_proveedor="
					+ ((Proveedor) condiciones.get(Proveedor.NICKNAME))
							.getOID());
		
		
		if (condiciones.containsKey(MotivoDecisionAdjudicacion.NICKNAME))
			textSQL.append(" and b.oid_mot_decision="
					+ ((MotivoDecisionAdjudicacion) condiciones.get(MotivoDecisionAdjudicacion.NICKNAME))
							.getOID());
		
		
		if (condiciones.containsKey("NRO_DESDE"))
			textSQL.append(" and a.nro_ext>="
					+ ((Integer) condiciones.get("NRO_DESDE")).toString());
		if (condiciones.containsKey("NRO_HASTA"))
			textSQL.append(" and a.nro_ext<="
					+ ((Integer) condiciones.get("NRO_HASTA")).toString());
		
		if (condiciones.containsKey("abierto_cerrado")) {
			if (condiciones.getString("abierto_cerrado").equals("A"))
				textSQL.append(" and b.cot_abierta=1 ");
			else if (condiciones.getString("abierto_cerrado").equals("C"))
					textSQL.append(" and b.cot_abierta=0 ");
		}
		
		
		if (condiciones.containsKey("FEC_EMI_DESDE"))
			textSQL.append(" and a.emision>=?");
		if (condiciones.containsKey("FEC_EMI_HASTA"))
			textSQL.append(" and a.emision<=?");
		if (condiciones.containsKey("FEC_VIG_AL"))
			textSQL.append(" and b.vigencia_desde<=? and b.vigencia_hasta>=? ");
		if (condiciones.containsKey(Producto.NICKNAME)) {
			Producto producto = (Producto) condiciones.get(Producto.NICKNAME); 
			textSQL.append(" and b.oid_cotiz_prov_cab in (select oid_cotiz_prov_cab from cpCotizProvDet where oid_producto = "+producto.getOIDInteger().toString()+") ");
		}		
		if (condiciones.containsKey("ESTADO_COTIZACION")) {
			Integer estadoCotizacion = (Integer) condiciones.get("ESTADO_COTIZACION"); 
			textSQL.append(" and b.estado_adju="+estadoCotizacion.toString());
		}
		if (condiciones.containsKey(Talonario.NICKNAME)) {
			Talonario talonario = (Talonario) condiciones.get(Talonario.NICKNAME); 
			textSQL.append(" and a.oid_talonario = "+talonario.getOIDInteger().toString());
		}
		if (condiciones.containsKey("oid_cco")) {
			Integer oidCCO = (Integer) condiciones.get("oid_cco"); 
			textSQL.append(" and b.oid_cotiz_prov_cab="+oidCCO.toString());
		}		
		
		
		PreparedStatement querySelect = getSesion().getConexionBD()
				.prepareStatement(textSQL.toString());
		int nroParam = 0;
		if (condiciones.containsKey("FEC_EMI_DESDE"))
			querySelect.setDate(++nroParam, new java.sql.Date(
					((java.util.Date) condiciones.get("FEC_EMI_DESDE"))
							.getTime()));
		if (condiciones.containsKey("FEC_EMI_HASTA"))
			querySelect.setDate(++nroParam, new java.sql.Date(
					((java.util.Date) condiciones.get("FEC_EMI_HASTA"))
							.getTime()));
		if (condiciones.containsKey("FEC_VIG_AL")) {
			querySelect
					.setDate(++nroParam, new java.sql.Date(
							((java.util.Date) condiciones.get("FEC_VIG_AL"))
									.getTime()));
			querySelect
					.setDate(++nroParam, new java.sql.Date(
							((java.util.Date) condiciones.get("FEC_VIG_AL"))
									.getTime()));
		}
		
		
		
		  
		
		return querySelect;
	}

	private PreparedStatement selectByCodigo(Object aCondiciones)
			throws BaseException, SQLException {

		final int CODIGO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  CPCOTIZPROVCAB ");
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

		textSQL
				.append("SELECT oid_cotiz_prov_cab oid, codigo,  descripcion ,activo ");
		textSQL.append(" from CPCOTIZPROVCAB");

		PreparedStatement querySelect = getSesion().getConexionBD()
				.prepareStatement(textSQL.toString());
		return querySelect;
	}

	public static List getCotizacionesProvCab(HashTableDatos condiciones,
			ISesion aSesion) throws BaseException {
		return (List) ObjetoLogico.getObjects(CotizacionProveedorCab.NICKNAME,
				DBCotizacionProveedorCab.SELECT_BY_CONDICIONES, condiciones,
				new ListObserver(), aSesion);
	}

	}
