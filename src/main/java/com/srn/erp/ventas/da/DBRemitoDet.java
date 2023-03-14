package com.srn.erp.ventas.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import com.srn.erp.stock.bm.Deposito;
import com.srn.erp.stock.bm.Producto;
import com.srn.erp.ventas.bm.RemitoCab;
import com.srn.erp.ventas.bm.RemitoDet;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;

public class DBRemitoDet extends DBObjetoPersistente {

	public static final String OID_REMITO_DET = "oid_remito_det";
	public static final String OID_REMITO_CAB = "oid_remito_cab";
	public static final String OID_PRODUCTO = "oid_producto";
	public static final String CANT_DESP = "cant_desp";
	public static final String OID_DEPOSITO = "oid_deposito";
	public static final String CANT_FACT = "cant_fact";
	public static final String PEND_FACT = "pend_fact";
	public static final String OID_UM_DESP = "oid_um_desp";
	public static final String COMENTARIO = "comentario";
	public static final String ACTIVO = "activo";
	public static final String OID_COMPO_STK_RTO = "oid_compo_stk_rto";
	public static final String OID_PED_DET = "oid_ped_det";
	public static final String OID_CC_DET = "oid_cc_det";
	public static final String CANT_NC = "cant_nc";
	public static final String OID_MOTIVO_DEVOLUCION = "oid_motivo_cc";
	public static final String OC_DET_POR_DEVOLUCION = "oid_oc_det_dev";
	public static final String CANT_DEVUELTA = "cant_devuelta";
	public static final String OID_PEDIDO_DEPO_DET = "oid_ped_depo_det";
	public static final String CANT_RECEP = "cant_recep";
	public static final String PEND_RECEP = "pend_recep";

	public static final int SELECT_BY_REMITO_CAB = 100;
	public static final int SELECT_BY_RTO_CAB_PEND_FACT = 101;
	public static final int UPDATE_APLIC_CANT_DEVUELTAS = 102;
	public static final int SELECT_BY_RTO_CAB_PEND_RECEP = 103;
	public static final int UPDATE_CANT_RECEPCIONADAS = 104;
	

	public DBRemitoDet() {
	}

	protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_REMITO_DET = 1;
		final int OID_REMITO_CAB = 2;
		final int OID_PRODUCTO = 3;
		final int CANT_DESP = 4;
		final int CANT_FACT = 5;
		final int PEND_FACT = 6;
		final int OID_UM_DESP = 7;
		final int COMENTARIO = 8;
		final int ACTIVO = 9;
		final int OID_COMPO_STK_RTO = 10;
		final int OID_PED_DET = 11;
		final int OID_CC_DET = 12;
		final int CANT_NC = 13;
		final int OID_MOTIVO_DEVOLUCION = 14;
		final int OID_OC_DET_POR_DEV = 15;
		final int CANT_DEVUELTA = 16;
		final int OID_PEDIDO_DEPO_DET = 17;
		final int CANT_RECEP = 18;
		final int PEND_RECEP = 19;

		RemitoDet pers = (RemitoDet) objetoPersistente;

		StringBuffer sqlInsert = new StringBuffer();
		sqlInsert.append(" insert into veRemitoDet " + " ( " + "OID_REMITO_DET," + "OID_REMITO_CAB," + "OID_PRODUCTO," + "CANT_DESP,"
				+ "CANT_FACT," + "PEND_FACT," + "OID_UM_DESP," + "COMENTARIO," + "ACTIVO," + "OID_COMPO_STK_RTO," + "OID_PED_DET,"
				+ "OID_CC_DET, CANT_NC , OID_MOTIVO_CC , OID_OC_DET_DEV , CANT_DEVUELTA , OID_PED_DEPO_DET , CANT_RECEP , PEND_RECEP)" + " values " + "(" + "?," + "?," + "?," + "?,"
				+ "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?,"+ "?," + "?,"+ "?,"+ "?," + "?," + "?) ");

		PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
		qInsert.setInt(OID_REMITO_DET, pers.getOID());
		qInsert.setInt(OID_REMITO_CAB, pers.getRemito_cab().getOID());
		qInsert.setInt(OID_PRODUCTO, pers.getProducto().getOID());
		qInsert.setDouble(CANT_DESP, pers.getCant_desp().doubleValue());
		qInsert.setDouble(CANT_FACT, pers.getCant_fact().doubleValue());
		qInsert.setBoolean(PEND_FACT, pers.isPend_fact().booleanValue());
		qInsert.setInt(OID_UM_DESP, pers.getUnidad_desp().getOID());
		qInsert.setString(COMENTARIO, pers.getComentario());
		qInsert.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		qInsert.setInt(OID_COMPO_STK_RTO, pers.getCompoStkTalonarioRto().getOID());
		if (pers.getPedidoDet() != null)
			qInsert.setInt(OID_PED_DET, pers.getPedidoDet().getOID());
		else
			qInsert.setNull(OID_PED_DET, Types.INTEGER);
		if (pers.getInfCCDet() != null)
			qInsert.setInt(OID_CC_DET, pers.getInfCCDet().getOID());
		else
			qInsert.setNull(OID_CC_DET, Types.INTEGER);
		if (pers.getCant_NC() != null)
			qInsert.setDouble(CANT_NC, pers.getCant_NC().doubleValue());
		else
			qInsert.setDouble(CANT_NC, 0);

		if (pers.getMotivoDevolucion() != null)
			qInsert.setInt(OID_MOTIVO_DEVOLUCION, pers.getMotivoDevolucion().getOID());
		else
			qInsert.setNull(OID_MOTIVO_DEVOLUCION, java.sql.Types.INTEGER);

		if (pers.getOCDetPorDevolucion() != null)
			qInsert.setInt(OID_OC_DET_POR_DEV, pers.getOCDetPorDevolucion().getOID());
		else
			qInsert.setNull(OID_OC_DET_POR_DEV, java.sql.Types.INTEGER);

		if (pers.getCantDevuelta() != null)
			qInsert.setDouble(CANT_DEVUELTA, pers.getCantDevuelta().doubleValue());
		else
			qInsert.setDouble(CANT_DEVUELTA, 0);

		if (pers.getPedidoDepositoDet() != null)
			qInsert.setDouble(OID_PEDIDO_DEPO_DET, pers.getPedidoDepositoDet().getOIDInteger());
		else
			qInsert.setNull(OID_PEDIDO_DEPO_DET, java.sql.Types.INTEGER);
		
		if (pers.getCantRecep() != null)
			qInsert.setDouble(CANT_RECEP, pers.getCantRecep().doubleValue());
		else
			qInsert.setNull(CANT_RECEP, java.sql.Types.DOUBLE);
		
		if (pers.isPendRecep() != null)
			qInsert.setBoolean(PEND_RECEP, pers.isPendRecep().booleanValue());
		else
			qInsert.setBoolean(PEND_RECEP, false);
		
		
		qInsert.executeUpdate();
		qInsert.close();
	}

	protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_REMITO_CAB = 1;
		final int OID_PRODUCTO = 2;
		final int CANT_DESP = 3;
		final int CANT_FACT = 4;
		final int PEND_FACT = 5;
		final int OID_UM_DESP = 6;
		final int COMENTARIO = 7;
		final int ACTIVO = 8;
		final int OID_COMPO_STK_RTO = 9;
		final int OID_PED_DET = 10;
		final int OID_CC_DET = 11;
		final int CANT_NC = 12;
		final int OID_MOTIVO_DEVOLUCION = 13;
		final int OID_OC_DET_POR_DEV = 14;
		final int OID_PEDIDO_DEPO_DET = 15;
		final int OID_REMITO_DET = 16;

		RemitoDet pers = (RemitoDet) objetoPersistente;

		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append(" update veRemitoDet set " + "oid_remito_cab=?" + ",oid_producto=?" + ",cant_desp=?" + ",cant_fact=?"
				+ ",pend_fact=?" + ",oid_um_desp=?" + ",comentario=?" + ",activo=?" + ",oid_compo_stk_rto=?" + ",oid_ped_det=?"
				+ ",oid_cc_det=?" + ",cant_nc=?" + ",oid_motivo_cc=?" + ",OID_OC_DET_DEV=? , oid_ped_depo_det = ? " + " where " + " oid_remito_det=? ");

		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_REMITO_DET, pers.getOID());
		qUpdate.setInt(OID_REMITO_CAB, pers.getRemito_cab().getOID());
		qUpdate.setInt(OID_PRODUCTO, pers.getProducto().getOID());
		qUpdate.setDouble(CANT_DESP, pers.getCant_desp().doubleValue());
		qUpdate.setDouble(CANT_FACT, pers.getCant_fact().doubleValue());
		qUpdate.setBoolean(PEND_FACT, pers.isPend_fact().booleanValue());
		qUpdate.setInt(OID_UM_DESP, pers.getUnidad_desp().getOID());
		qUpdate.setInt(OID_COMPO_STK_RTO, pers.getCompoStkTalonarioRto().getOID());
		qUpdate.setString(COMENTARIO, pers.getComentario());
		qUpdate.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		if (pers.getPedidoDet() != null)
			qUpdate.setInt(OID_PED_DET, pers.getPedidoDet().getOID());
		else
			qUpdate.setNull(OID_PED_DET, Types.INTEGER);
		if (pers.getInfCCDet() != null)
			qUpdate.setInt(OID_CC_DET, pers.getInfCCDet().getOID());
		else
			qUpdate.setNull(OID_CC_DET, Types.INTEGER);
		if (pers.getCant_NC() != null)
			qUpdate.setDouble(CANT_NC, pers.getCant_NC().doubleValue());
		else
			qUpdate.setDouble(CANT_NC, 0);

		if (pers.getMotivoDevolucion() != null)
			qUpdate.setInt(OID_MOTIVO_DEVOLUCION, pers.getMotivoDevolucion().getOID());
		else
			qUpdate.setNull(OID_MOTIVO_DEVOLUCION, java.sql.Types.INTEGER);

		if (pers.getOCDetPorDevolucion() != null)
			qUpdate.setInt(OID_OC_DET_POR_DEV, pers.getOCDetPorDevolucion().getOID());
		else
			qUpdate.setNull(OID_OC_DET_POR_DEV, java.sql.Types.INTEGER);

		if (pers.getPedidoDepositoDet() != null)
			qUpdate.setDouble(OID_PEDIDO_DEPO_DET, pers.getPedidoDepositoDet().getOIDInteger());
		else
			qUpdate.setNull(OID_PEDIDO_DEPO_DET, java.sql.Types.INTEGER);
		
		
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_REMITO_DET = 1;
		RemitoDet pers = (RemitoDet) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update veRemitoDet " + " set activo=0 " + " where " + " oid_remito_det=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_REMITO_DET, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_REMITO_DET = 1;
		RemitoDet pers = (RemitoDet) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update veRemitoDet " + " set activo=1 " + " where " + " oid_remito_det=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_REMITO_DET, pers.getOID());
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
		case SELECT_BY_REMITO_CAB: {
			ps = this.selectByRemito(aCondiciones);
			break;
		}
		case SELECT_BY_RTO_CAB_PEND_FACT: {
			ps = this.selectByRtoCabPendFact(aCondiciones);
			break;
		}
		case SELECT_BY_RTO_CAB_PEND_RECEP: {
			ps = this.selectByRtoCabPendRecep(aCondiciones);
			break;
		}
		
		case UPDATE_APLIC_CANT_DEVUELTAS: {
			ps = this.aplicarCantidadesDevueltas(aCondiciones);
			break;
		}
		case UPDATE_CANT_RECEPCIONADAS: {
			ps = this.updateCantRecepcionadas(aCondiciones);
			break;
		}
		}
		return ps;
	}

	private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

		final int OID_REMITO_DET = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  veRemitoDet ");
		textSQL.append(" WHERE oid_remito_det = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		int oid = ((Integer) aCondiciones).intValue();
		querySelect.setInt(OID_REMITO_DET, oid);
		return querySelect;
	}

	private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {
		final int CODIGO = 1;
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  veRemitoDet ");
		textSQL.append(" WHERE  = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		String codigo = (String) aCondiciones;
		querySelect.setString(CODIGO, codigo);
		return querySelect;
	}

	private PreparedStatement selectByRemito(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  veRemitoDet ");
		textSQL.append(" WHERE  oid_remito_cab = ? and activo=1");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		RemitoCab remitoCab = (RemitoCab) aCondiciones;
		querySelect.setInt(1, remitoCab.getOID());
		return querySelect;
	}
	
	private PreparedStatement updateCantRecepcionadas(Object aCondiciones) throws BaseException, SQLException {

		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		RemitoDet remitoDet = (RemitoDet) condiciones.get(RemitoDet.NICKNAME);
		Double cantRecepcionada = (Double) condiciones.get("CANT_RECEPCIONADA");
		Boolean pendRecep = (Boolean) condiciones.get("PEND_RECEPCION");

		StringBuffer sqlUpdate = new StringBuffer()	;
		sqlUpdate.append(" update veRemitoDet set " + " cant_recep=? , pend_recep = ? " + " where " + " oid_remito_det=? ");

		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setDouble(1, cantRecepcionada.doubleValue());
		qUpdate.setBoolean(2, pendRecep.booleanValue());
		qUpdate.setDouble(3, remitoDet.getOID());

		qUpdate.executeUpdate();
		qUpdate.close();
		return null;
	}
	
	
	private PreparedStatement aplicarCantidadesDevueltas(Object aCondiciones) throws BaseException, SQLException {

		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		RemitoDet remitoDet = (RemitoDet) condiciones.get(RemitoDet.NICKNAME);
		Double cantDevuelta = (Double) condiciones.get("CANT_DEVUELTA");

		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append(" update veRemitoDet set " + " cant_devuelta=? " + " where " + " oid_remito_det=? ");

		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setDouble(1, cantDevuelta.doubleValue());
		qUpdate.setDouble(2, remitoDet.getOID());

		qUpdate.executeUpdate();
		qUpdate.close();
		return null;
	}

	private PreparedStatement selectByRtoCabPendFact(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT a.* FROM  veRemitoDet a, veRemitoCab b , geComproCab c  ");
		textSQL.append(" WHERE c.activo=1 and a.oid_remito_cab = b.oid_remito_cab and c.oid_cco = b.oid_remito_cab ");
		textSQL.append(" and a.oid_remito_cab = ? and a.pend_fact=1 and a.activo=1  ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		RemitoCab remitoCab = (RemitoCab) aCondiciones;
		querySelect.setInt(1, remitoCab.getOID());
		return querySelect;
	}
	
	private PreparedStatement selectByRtoCabPendRecep(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT a.* FROM  veRemitoDet a, veRemitoCab b , geComproCab c  ");
		textSQL.append(" WHERE c.activo=1 and a.oid_remito_cab = b.oid_remito_cab and c.oid_cco = b.oid_remito_cab ");
		textSQL.append(" and a.pend_recep=1 and a.activo=1 ");
		
		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		
		if (condiciones.containsKey(RemitoCab.NICKNAME)) {
			RemitoCab remito = (RemitoCab) condiciones.get(RemitoCab.NICKNAME);
			textSQL.append(" and a.oid_remito_cab = " +remito.getOIDInteger());
		}
		
		if (condiciones.containsKey(Deposito.NICKNAME)) {
			Deposito deposito = (Deposito) condiciones.get(Deposito.NICKNAME);
			textSQL.append(" and b.oid_depo_dest = " +deposito.getOIDInteger());
		}
		
		if (condiciones.containsKey(Producto.NICKNAME)) {
			Producto producto = (Producto) condiciones.get(Producto.NICKNAME);
			textSQL.append(" and a.oid_producto = " +producto.getOIDInteger());
		}
		
		if (condiciones.containsKey("NRO_EXT_DESDE")) {
			Integer nroExtDesde = (Integer) condiciones.get("NRO_EXT_DESDE");
			textSQL.append(" and c.nro_ext >= " +nroExtDesde.toString());
		}
		
		if (condiciones.containsKey("NRO_EXT_HASTA")) {
			Integer nroExtHasta = (Integer) condiciones.get("NRO_EXT_HASTA");
			textSQL.append(" and c.nro_ext <= " +nroExtHasta.toString());
		}
		
		if (condiciones.containsKey("FEC_EMI_DESDE")) {
			textSQL.append(" and c.emision >= ? ");
		}
		
		if (condiciones.containsKey("FEC_EMI_HASTA")) {
			textSQL.append(" and c.emision <= ? ");
		}
		
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		
		int param = 0;
		if (condiciones.containsKey("FEC_EMI_DESDE")) {
			++param;
			java.util.Date fecha = (java.util.Date) condiciones.get("FEC_EMI_DESDE");
			querySelect.setDate(param, new java.sql.Date(fecha.getTime()));
		}
		
		if (condiciones.containsKey("FEC_EMI_HASTA")) {
			++param;
			java.util.Date fecha = (java.util.Date) condiciones.get("FEC_EMI_HASTA");
			querySelect.setDate(param, new java.sql.Date(fecha.getTime()));
		}		
		
		
		
		return querySelect;
	}
	
	
	

	private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();

		textSQL.append("SELECT oid_remito_det oid, codigo,  descripcion ,activo ");
		textSQL.append(" from veRemitoDet");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}

	public static List getDetalles(RemitoCab remitoCab, ISesion aSesion) throws BaseException {
		return (List) ObjetoLogico.getObjects(RemitoDet.NICKNAME, DBRemitoDet.SELECT_BY_REMITO_CAB, remitoCab, new ListObserver(), aSesion);
	}

	public static List getDetallesPendFact(RemitoCab remitoCab, ISesion aSesion) throws BaseException {
		return (List) ObjetoLogico.getObjects(RemitoDet.NICKNAME, DBRemitoDet.SELECT_BY_RTO_CAB_PEND_FACT, remitoCab, new ListObserver(),
				aSesion);
	}
	
	public static List getDetallesPendRecep(RemitoCab remitoCab, 
			                                Deposito deposito,
			                                Producto producto,
			                                java.util.Date fecEmiDesde,
			                                java.util.Date fecEmiHasta,
			                                Integer nroExtDesde,
			                                Integer nroExtHasta,
			                                ISesion aSesion) throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		if (remitoCab!=null)
			condiciones.put(RemitoCab.NICKNAME, remitoCab);
		if (deposito!=null)
			condiciones.put(Deposito.NICKNAME, deposito);
		if (producto!=null)
			condiciones.put(Producto.NICKNAME, producto);
		if (fecEmiDesde!=null)
			condiciones.put("FEC_EMI_DESDE", fecEmiDesde);
		if (fecEmiHasta!=null)
			condiciones.put("FEC_EMI_HASTA", fecEmiHasta);
		if (nroExtDesde!=null)
			condiciones.put("NRO_EXT_DESDE", nroExtDesde);
		if (nroExtHasta!=null)
			condiciones.put("NRO_EXT_HASTA", nroExtHasta);
		
		return (List) ObjetoLogico.getObjects(RemitoDet.NICKNAME, DBRemitoDet.SELECT_BY_RTO_CAB_PEND_RECEP, condiciones, new ListObserver(),
				aSesion);
	}
	

	public static void aplicarCantidadDevuelta(RemitoDet remitoDet, Double cantDevuelta, ISesion aSesion) throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put("CANT_DEVUELTA", cantDevuelta);
		condiciones.put(RemitoDet.NICKNAME, remitoDet);
		ObjetoLogico.getObjects(RemitoDet.NICKNAME, DBRemitoDet.UPDATE_APLIC_CANT_DEVUELTAS, condiciones, new ListObserver(), aSesion);
	}
	
	public static void aplicarCantidadRecepcionada(RemitoDet remitoDet, Double cantRecepcionada, Boolean pendRecep, ISesion aSesion) throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put("CANT_RECEPCIONADA", cantRecepcionada);
		condiciones.put("PEND_RECEPCION", pendRecep);
		condiciones.put(RemitoDet.NICKNAME, remitoDet);
		ObjetoLogico.getObjects(RemitoDet.NICKNAME, DBRemitoDet.UPDATE_CANT_RECEPCIONADAS, condiciones, new ListObserver(), aSesion);
	}
	

}
