package com.srn.erp.stock.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.stock.bm.Deposito;
import com.srn.erp.stock.bm.PedMercDep;
import com.srn.erp.stock.bm.PedMercDepoDet;
import com.srn.erp.stock.bm.Producto;
import com.srn.erp.stock.bm.SolicitarAPedMerc;
import com.srn.erp.ventas.bm.PedidoCab;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.ObjetoObservado;

public class DBPedMercDepoDet extends DBObjetoPersistente {

	public static final String OID_PED_MERC_DET = "oid_ped_merc_det";
	public static final String OID_PED_MERC = "oid_ped_merc";
	public static final String OID_PRODUCTO = "oid_producto";
	public static final String OID_UM = "oid_um";
	public static final String CANTIDAD = "cantidad";
	public static final String OBSERVACION = "observacion";
	public static final String FEC_NECESIDAD = "fec_necesidad";
	public static final String OID_CCO_PED = "oid_cco_ped";
	public static final String OID_PED_DET = "oid_ped_det";
	public static final String CANT_ENVIADA = "cant_enviada";
	public static final String PEND_ENVIO = "pend_envio";
	public static final String CANT_RECEP = "cant_recep";
	public static final String PEND_RECEP = "pend_recep";
	public static final String ACTIVO = "activo";

	public static final int SELECT_BY_PEDIDO_MERCADERIA = 100;
	public static final int SELECT_BY_PEDIDOS_PEND_ENVIO = 101;
	public static final int UPDATE_CANT_ENVIADAS = 102;

	public DBPedMercDepoDet() {
	}

	protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_PED_MERC_DET = 1;
		final int OID_PED_MERC = 2;
		final int OID_PRODUCTO = 3;
		final int OID_UM = 4;
		final int CANTIDAD = 5;
		final int OBSERVACION = 6;
		final int FEC_NECESIDAD = 7;
		final int OID_CCO_PED = 8;
		final int OID_PED_DET = 9;
		final int ACTIVO = 10;
		final int CANT_ENVIADA = 11;
		final int PEND_ENVIO = 12;
		final int CANT_RECEP = 13;
		final int PEND_RECEP = 14;

		PedMercDepoDet pers = (PedMercDepoDet) objetoPersistente;

		StringBuffer sqlInsert = new StringBuffer();
		sqlInsert.append(" insert into vePedMercDepoDet " + " ( " + "OID_PED_MERC_DET," + "OID_PED_MERC," + "OID_PRODUCTO," + "OID_UM,"
				+ "CANTIDAD," + "OBSERVACION," + "FEC_NECESIDAD," + "OID_CCO_PED," + "OID_PED_DET,"
				+ "ACTIVO , CANT_ENVIADA,PEND_ENVIO,CANT_RECEP,PEND_RECEP)" + " values " + "(" + "?," + "?," + "?," + "?," + "?," + "?,"
				+ "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?) ");

		PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
		qInsert.setInt(OID_PED_MERC_DET, pers.getOID());
		qInsert.setInt(OID_PED_MERC, pers.getPedido_mercaderia().getOID());
		qInsert.setInt(OID_PRODUCTO, pers.getProducto().getOID());
		qInsert.setInt(OID_UM, pers.getUnidad_medida().getOID());
		qInsert.setDouble(CANTIDAD, pers.getCantidad().doubleValue());
		qInsert.setString(OBSERVACION, pers.getObservacion());
		qInsert.setDate(FEC_NECESIDAD, new java.sql.Date(pers.getFec_necesidad().getTime()));
		if (pers.getPedido() != null)
			qInsert.setInt(OID_CCO_PED, pers.getPedido().getOID());
		else
			qInsert.setNull(OID_CCO_PED, java.sql.Types.INTEGER);
		if (pers.getPedido_det() != null)
			qInsert.setInt(OID_PED_DET, pers.getPedido_det().getOID());
		else
			qInsert.setNull(OID_PED_DET, java.sql.Types.INTEGER);
		qInsert.setBoolean(ACTIVO, pers.isActivo().booleanValue());

		if (pers.getCantEnviada() != null)
			qInsert.setDouble(CANT_ENVIADA, pers.getCantEnviada().doubleValue());
		else
			qInsert.setDouble(CANT_ENVIADA, 0);
		if (pers.isPendEnvio() != null)
			qInsert.setBoolean(PEND_ENVIO, pers.isPendEnvio().booleanValue());
		else
			qInsert.setBoolean(PEND_ENVIO, true);

		if (pers.getCantRecepcionada() != null)
			qInsert.setDouble(CANT_RECEP, pers.getCantRecepcionada().doubleValue());
		else
			qInsert.setDouble(CANT_RECEP, 0);
		if (pers.isPendRecep() != null)
			qInsert.setBoolean(PEND_RECEP, pers.isPendRecep().booleanValue());
		else
			qInsert.setBoolean(PEND_RECEP, true);

		qInsert.executeUpdate();
		qInsert.close();
	}

	protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_PED_MERC = 1;
		final int OID_PRODUCTO = 2;
		final int OID_UM = 3;
		final int CANTIDAD = 4;
		final int OBSERVACION = 5;
		final int FEC_NECESIDAD = 6;
		final int OID_CCO_PED = 7;
		final int OID_PED_DET = 8;
		final int ACTIVO = 9;
		final int CANT_ENVIADA = 10;
		final int PEND_ENVIO = 11;
		final int CANT_RECEP = 12;
		final int PEND_RECEP = 13;
		final int OID_PED_MERC_DET = 14;

		PedMercDepoDet pers = (PedMercDepoDet) objetoPersistente;

		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append(" update vePedMercDepoDet set " + "oid_ped_merc=?" + ",oid_producto=?" + ",oid_um=?" + ",cantidad=?"
				+ ",observacion=?" + ",fec_necesidad=?" + ",oid_cco_ped=?" + ",oid_ped_det=?" + ",activo=?"
				+ ",cant_enviada=?, pend_envio=?, cant_recep=?,pend_recep=? " + " where " + " oid_ped_merc_det=? ");

		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_PED_MERC_DET, pers.getOID());
		qUpdate.setInt(OID_PED_MERC, pers.getPedido_mercaderia().getOID());
		qUpdate.setInt(OID_PRODUCTO, pers.getProducto().getOID());
		qUpdate.setInt(OID_UM, pers.getUnidad_medida().getOID());
		qUpdate.setDouble(CANTIDAD, pers.getCantidad().doubleValue());
		qUpdate.setString(OBSERVACION, pers.getObservacion());
		qUpdate.setDate(FEC_NECESIDAD, new java.sql.Date(pers.getFec_necesidad().getTime()));
		if (pers.getPedido() != null)
			qUpdate.setInt(OID_CCO_PED, pers.getPedido().getOID());
		else
			qUpdate.setNull(OID_CCO_PED, java.sql.Types.INTEGER);
		if (pers.getPedido_det() != null)
			qUpdate.setInt(OID_PED_DET, pers.getPedido_det().getOID());
		else
			qUpdate.setNull(OID_PED_DET, java.sql.Types.INTEGER);
		qUpdate.setBoolean(ACTIVO, pers.isActivo().booleanValue());

		if (pers.getCantEnviada() != null)
			qUpdate.setDouble(CANT_ENVIADA, pers.getCantEnviada().doubleValue());
		else
			qUpdate.setDouble(CANT_ENVIADA, 0);
		if (pers.isPendEnvio() != null)
			qUpdate.setBoolean(PEND_ENVIO, pers.isPendEnvio().booleanValue());
		else
			qUpdate.setBoolean(PEND_ENVIO, true);

		if (pers.getCantRecepcionada() != null)
			qUpdate.setDouble(CANT_RECEP, pers.getCantRecepcionada().doubleValue());
		else
			qUpdate.setDouble(CANT_RECEP, 0);
		if (pers.isPendRecep() != null)
			qUpdate.setBoolean(PEND_RECEP, pers.isPendRecep().booleanValue());
		else
			qUpdate.setBoolean(PEND_RECEP, true);

		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_PED_MERC_DET = 1;
		PedMercDepoDet pers = (PedMercDepoDet) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update vePedMercDepoDet " + " set activo=0 " + " where " + " oid_ped_merc_det=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_PED_MERC_DET, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_PED_MERC_DET = 1;
		PedMercDepoDet pers = (PedMercDepoDet) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update vePedMercDepoDet " + " set activo=1 " + " where " + " oid_ped_merc_det=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_PED_MERC_DET, pers.getOID());
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
		case SELECT_BY_PEDIDO_MERCADERIA: {
			ps = this.selectByPedidoMercaderia(aCondiciones);
			break;
		}
		case SELECT_BY_PEDIDOS_PEND_ENVIO: {
			ps = this.selectByPedidoPendEnvio(aCondiciones);
			break;
		}
		case UPDATE_CANT_ENVIADAS: {
			ps = this.updateCantEnviadas(aCondiciones);
			break;
		}
		}
		return ps;
	}

	private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

		final int OID_PED_MERC_DET = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  vePedMercDepoDet ");
		textSQL.append(" WHERE oid_ped_merc_det = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		int oid = ((Integer) aCondiciones).intValue();
		querySelect.setInt(OID_PED_MERC_DET, oid);
		return querySelect;
	}

	private PreparedStatement selectByPedidoMercaderia(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  vePedMercDepoDet ");
		textSQL.append(" WHERE oid_ped_merc = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		PedMercDep pedMercDepo = (PedMercDep) aCondiciones;
		querySelect.setInt(1, pedMercDepo.getOID());
		return querySelect;
	}

	private PreparedStatement selectByPedidoPendEnvio(Object aCondiciones) throws BaseException, SQLException {

		HashTableDatos condiciones = (HashTableDatos) aCondiciones;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  vePedMercDepoDet a , vePedMercDepo b , geComproCab c ");
		textSQL
				.append(" WHERE a.oid_ped_merc = b.oid_ped_merc and b.oid_ped_merc = c.oid_cco and c.activo = 1 and a.activo = 1 and a.pend_envio = 1 ");

		if (condiciones.containsKey("NRO_EXT_DESDE")) {
			Integer nroExtDesde = (Integer) condiciones.get("NRO_EXT_DESDE");
			textSQL.append(" and c.nro_ext>=" + nroExtDesde.toString());
		}

		if (condiciones.containsKey("NRO_EXT_HASTA")) {
			Integer nroExtHasta = (Integer) condiciones.get("NRO_EXT_HASTA");
			textSQL.append(" and c.nro_ext<=" + nroExtHasta.toString());
		}

		if (condiciones.containsKey("FEC_DESDE"))
			textSQL.append(" and c.emision>=?");

		if (condiciones.containsKey("FEC_HASTA"))
			textSQL.append(" and c.emision<=?");

		if (condiciones.containsKey("FEC_REQ_DESDE"))
			textSQL.append(" and a.fec_necesidad>=?");

		if (condiciones.containsKey("FEC_REQ_HASTA"))
			textSQL.append(" and a.fec_necesidad<=?");

		if (condiciones.containsKey(PedidoCab.NICKNAME)) {
			PedidoCab pedido = (PedidoCab) condiciones.get(PedidoCab.NICKNAME);
			textSQL.append(" and a.oid_cco_ped=" + pedido.getOID());
		}
		if (condiciones.containsKey(Deposito.NICKNAME)) {
			Deposito deposito = (Deposito) condiciones.get(Deposito.NICKNAME);
			textSQL.append(" and b.oid_depo_ent=" + deposito.getOID());
		}
		if (condiciones.containsKey(Producto.NICKNAME)) {
			Producto producto = (Producto) condiciones.get(Producto.NICKNAME);
			textSQL.append(" and a.oid_producto=" + producto.getOID());
		}
		
		if (condiciones.containsKey(SolicitarAPedMerc.NICKNAME)) {
			SolicitarAPedMerc solicitarA = (SolicitarAPedMerc) condiciones.get(SolicitarAPedMerc.NICKNAME);
			textSQL.append(" and b.oid_sol_ped_merc=" + solicitarA.getOID());
		}

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());

		int nroParam = 0;

		if (condiciones.containsKey("FEC_DESDE")) {
			++nroParam;
			java.util.Date fecha = (java.util.Date) condiciones.get("FEC_DESDE");
			querySelect.setDate(nroParam, new java.sql.Date(fecha.getTime()));
		}

		if (condiciones.containsKey("FEC_HASTA")) {
			++nroParam;
			java.util.Date fecha = (java.util.Date) condiciones.get("FEC_HASTA");
			querySelect.setDate(nroParam, new java.sql.Date(fecha.getTime()));
		}

		if (condiciones.containsKey("FEC_REQ_DESDE")) {
			++nroParam;
			java.util.Date fecha = (java.util.Date) condiciones.get("FEC_REQ_DESDE");
			querySelect.setDate(nroParam, new java.sql.Date(fecha.getTime()));
		}

		if (condiciones.containsKey("FEC_REQ_HASTA")) {
			++nroParam;
			java.util.Date fecha = (java.util.Date) condiciones.get("FEC_REQ_HASTA");
			querySelect.setDate(nroParam, new java.sql.Date(fecha.getTime()));
		}

		return querySelect;
	}
	
	
	
	private PreparedStatement updateCantEnviadas(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("update vePedMercDepoDet set cant_enviada = ? , pend_envio = ? ");
		textSQL.append(" WHERE oid_ped_merc_det = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		
		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		Double cantEnviada = (Double) condiciones.get("CANT_ENVIADA");
		Boolean pendEnvio = (Boolean) condiciones.get("PEND_ENVIO");
		PedMercDepoDet pedMercDepoDet = (PedMercDepoDet) condiciones.get(PedMercDepoDet.NICKNAME);
		
		querySelect.setDouble(1, cantEnviada.doubleValue());
		querySelect.setBoolean(2, pendEnvio.booleanValue());
		querySelect.setInt(3, pedMercDepoDet.getOID());
		
		querySelect.executeUpdate();
		querySelect.close();
		
		return null;
	}
	

	private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

		final int CODIGO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  vePedMercDepoDet ");
		textSQL.append(" WHERE  = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		String codigo = (String) aCondiciones;
		querySelect.setString(CODIGO, codigo);
		return querySelect;
	}

	private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();

		textSQL.append("SELECT oid_ped_merc_det oid, codigo,  descripcion ,activo ");
		textSQL.append(" from vePedMercDepoDet");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}

	public static List getDetalles(PedMercDep pedidoMercDepo, ISesion aSesion) throws BaseException {
		return (List) ObjetoLogico.getObjects(PedMercDepoDet.NICKNAME, DBPedMercDepoDet.SELECT_BY_PEDIDO_MERCADERIA, pedidoMercDepo,
				new ListObserver(), aSesion);
	}

	public static List getDetallesPendientesDeEnvio(
			Integer nroExtDesde, 
			Integer nroExtHasta, 
			java.util.Date fecDesde,
			java.util.Date fecHasta, java.util.Date fecReqDesde, java.util.Date fecReqHasta, PedidoCab pedido, Deposito deposito,
			SolicitarAPedMerc solicitarA, Producto producto,ISesion aSesion) throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		if (nroExtDesde != null)
			condiciones.put("NRO_EXT_DESDE", nroExtDesde);
		if (nroExtHasta != null)
			condiciones.put("NRO_EXT_HASTA", nroExtHasta);
		if (fecDesde != null)
			condiciones.put("FEC_DESDE", fecDesde);
		if (fecHasta != null)
			condiciones.put("FEC_HASTA", fecHasta);
		if (fecReqDesde != null)
			condiciones.put("FEC_REQ_DESDE", fecDesde);
		if (fecReqHasta != null)
			condiciones.put("FEC_REQ_HASTA", fecHasta);
		if (pedido != null)
			condiciones.put(PedidoCab.NICKNAME, pedido);
		if (deposito != null)
			condiciones.put(Deposito.NICKNAME, deposito);
		if (solicitarA != null)
			condiciones.put(SolicitarAPedMerc.NICKNAME, solicitarA);
		if (producto != null)
			condiciones.put(Producto.NICKNAME, producto);

		return (List) ObjetoLogico.getObjects(PedMercDepoDet.NICKNAME, DBPedMercDepoDet.SELECT_BY_PEDIDOS_PEND_ENVIO, condiciones,
				new ListObserver(), aSesion);
	}

	  public static void actuCantidadEnviada(
			  PedMercDepoDet pedDepoDet,
			  Double cantidad,
			  boolean pendEnvio,
	          ISesion aSesion)
	          throws BaseException {
		  HashTableDatos condiciones = new HashTableDatos();
		  condiciones.put("CANT_ENVIADA", cantidad);
		  condiciones.put("PEND_ENVIO", pendEnvio);
		  condiciones.put(PedMercDepoDet.NICKNAME,pedDepoDet); 
		  
		  ObjetoLogico.getObjects(PedMercDepoDet.NICKNAME,
				  				DBPedMercDepoDet.UPDATE_CANT_ENVIADAS,
				  				condiciones,
				  				new ObjetoObservado(),
				  				aSesion);
	  }
	
	
}
