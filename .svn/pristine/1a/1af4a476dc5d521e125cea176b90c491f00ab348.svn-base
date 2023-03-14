package com.srn.erp.stock.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

import com.srn.erp.general.bm.ClasificadorEntidad;
import com.srn.erp.general.bm.IValorClasificadorEntidad;
import com.srn.erp.stock.bm.ConsultaStock;
import com.srn.erp.stock.bm.Deposito;
import com.srn.erp.stock.bm.EstadoStock;
import com.srn.erp.stock.bm.ExtensionProdGen;
import com.srn.erp.stock.bm.Producto;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;

public class DBConsultaStock extends DBObjetoPersistente {

	public static final String OID_CONS_STOCK = "oid_cons_stock";
	public static final String OID_PRODUCTO = "oid_producto";
	public static final String COD_PRODUCTO = "cod_producto";
	public static final String DESC_PRODUCTO = "desc_producto";
	public static final String CANTIDAD = "cantidad";
	public static final String OID_UM = "oid_um";
	public static final String COD_UM = "cod_um";
	public static final String OID_DEPOSITO = "oid_deposito";

	public static final int SELECT_BY_CONS_MASIVA_A_FECHA = 100;
	public static final int SELECT_BY_SALDO_POR_ESTADO = 101;

	public DBConsultaStock() {
	}

	protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_CONS_STOCK = 1;
		final int OID_PRODUCTO = 2;
		final int COD_PRODUCTO = 3;
		final int DESC_PRODUCTO = 4;
		final int CANTIDAD = 5;
		final int OID_UM = 6;
		final int COD_UM = 7;
		final int OID_DEPOSITO = 8;

		ConsultaStock pers = (ConsultaStock) objetoPersistente;

		StringBuffer sqlInsert = new StringBuffer();
		sqlInsert.append(" insert into aaa " + " ( " + "OID_CONS_STOCK," + "OID_PRODUCTO," + "COD_PRODUCTO," + "DESC_PRODUCTO,"
				+ "CANTIDAD," + "OID_UM," + "COD_UM," + "OID_DEPOSITO)" + " values " + "(" + "?," + "?," + "?," + "?," + "?," + "?," + "?,"
				+ "?) ");

		PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
		qInsert.setInt(OID_CONS_STOCK, pers.getOID());
		qInsert.setInt(OID_PRODUCTO, pers.getOid_producto().intValue());
		qInsert.setString(COD_PRODUCTO, pers.getCod_producto());
		qInsert.setString(DESC_PRODUCTO, pers.getDesc_producto());
		qInsert.setDouble(CANTIDAD, pers.getCantidad().doubleValue());
		qInsert.setInt(OID_UM, pers.getOid_um().intValue());
		qInsert.setInt(OID_DEPOSITO, pers.getOid_deposito().intValue());
		qInsert.executeUpdate();
		qInsert.close();
	}

	protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_PRODUCTO = 1;
		final int COD_PRODUCTO = 2;
		final int DESC_PRODUCTO = 3;
		final int CANTIDAD = 4;
		final int OID_UM = 5;
		final int COD_UM = 6;
		final int OID_DEPOSITO = 7;
		final int OID_CONS_STOCK = 8;

		ConsultaStock pers = (ConsultaStock) objetoPersistente;

		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append(" update aaa set " + "oid_producto=?" + ",cod_producto=?" + ",desc_producto=?" + ",cantidad=?" + ",oid_um=?"
				+ ",cod_um=?" + ",oid_deposito=?" + " where " + " oid_cons_stock=? ");

		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_CONS_STOCK, pers.getOID());
		qUpdate.setInt(OID_PRODUCTO, pers.getOid_producto().intValue());
		qUpdate.setString(COD_PRODUCTO, pers.getCod_producto());
		qUpdate.setString(DESC_PRODUCTO, pers.getDesc_producto());
		qUpdate.setDouble(CANTIDAD, pers.getCantidad().doubleValue());
		qUpdate.setInt(OID_UM, pers.getOid_um().intValue());
		qUpdate.setInt(OID_DEPOSITO, pers.getOid_deposito().intValue());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_CONS_STOCK = 1;
		ConsultaStock pers = (ConsultaStock) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update aaa " + " set activo=0 " + " where " + " oid_cons_stock=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_CONS_STOCK, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_CONS_STOCK = 1;
		ConsultaStock pers = (ConsultaStock) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update aaa " + " set activo=1 " + " where " + " oid_cons_stock=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_CONS_STOCK, pers.getOID());
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
		case SELECT_BY_CONS_MASIVA_A_FECHA: {
			ps = this.selectByConsMasivaAFecha(aCondiciones);
			break;
		}
		case SELECT_BY_SALDO_POR_ESTADO: {
			ps = this.selectBySaldoPorEstado(aCondiciones);
			break;
		}
		}
		return ps;
	}

	private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

		final int OID_CONS_STOCK = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  aaa ");
		textSQL.append(" WHERE oid_cons_stock = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		int oid = ((Integer) aCondiciones).intValue();
		querySelect.setInt(OID_CONS_STOCK, oid);
		return querySelect;
	}

	private PreparedStatement selectBySaldoPorEstado(Object aCondiciones) throws BaseException, SQLException {

		HashTableDatos condiciones = (HashTableDatos) aCondiciones;

		List listaEstados = null;
		if (condiciones.containsKey("LISTA_ESTADOS"))
			listaEstados = (List) condiciones.get("LISTA_ESTADOS");

		List listaDepositos = null;
		if (condiciones.containsKey("LISTA_DEPOSITOS"))
			listaDepositos = (List) condiciones.get("LISTA_DEPOSITOS");
		
		HashTableDatos filtrosPorDescClasif = null;
		if (condiciones.containsKey("FILTROS_POR_DESC_CLASIF"))
			filtrosPorDescClasif = (HashTableDatos) condiciones.get("FILTROS_POR_DESC_CLASIF");
		
		String filtroPorDescProdStk = null;
		if (condiciones.containsKey("FILTROS_POR_DESC_PROD_STK"))
			filtroPorDescProdStk = (String) condiciones.get("FILTROS_POR_DESC_PROD_STK");
		
		HashTableDatos filtrosPorValorClasif = null;
		if (condiciones.containsKey("FILTROS_POR_VALOR_CLASIF"))
			filtrosPorValorClasif = (HashTableDatos) condiciones.get("FILTROS_POR_VALOR_CLASIF");
		
		Producto producto = null;
		if (condiciones.containsKey("PRODUCTO"))
			producto = (Producto) condiciones.get("PRODUCTO");
		
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT a.oid_producto,a.codigo cod_producto,a.descripcion desc_producto, ");
		textSQL.append(" a.oid_um_stk oid_um,b.oid_deposito,sum(b.saldo) cantidad ");
		textSQL.append(" FROM  stProducto a , skStockSaldoEstado b");
		textSQL.append(" WHERE a.oid_producto = b.oid_producto  ");

		if (producto!=null)
			textSQL.append(" and a.oid_producto = "+producto.getOIDInteger());

		if (filtrosPorValorClasif!=null) {
			Iterator iterClasif = 
				filtrosPorValorClasif.keySet().iterator();
			while (iterClasif.hasNext()) {
				ClasificadorEntidad clasifEnt = (ClasificadorEntidad) iterClasif.next();
				Integer oidValor = (Integer)filtrosPorValorClasif.get(clasifEnt);
				// Dame todos los oid_productos que correspondan al filtro ingresado
				if (clasifEnt.getNickname().equals(Producto.NICKNAME)) {
					textSQL.append(" and a.oid_producto in ");
					textSQL.append(" ( ");
					textSQL.append(" select a1.oid_producto from stProducto a1  ");
					textSQL.append(" where a1."+clasifEnt.getCampoFisico()+"="+oidValor);
					textSQL.append(" ) ");
				} else if (clasifEnt.getNickname().equals(ExtensionProdGen.NICKNAME)) {
							//Extension producto General
							ClasificadorEntidad clasifProdGral = 
								Producto.getClasifProductoGeneral(this.getSesion());
							textSQL.append(" and a.oid_producto in ");
							textSQL.append(" ( ");
							textSQL.append(" select a1.oid_producto from stProducto a1 , stExtensionPG a2 ");
							textSQL.append(" where a1."+clasifProdGral.getCampoFisico()+"=a2.oid_val_clasif_ent ");
							textSQL.append(" and a2."+ clasifEnt.getCampoFisico()+"="+oidValor);
							textSQL.append(" ) ");
							}
			}
		}
		
		
		if (filtrosPorDescClasif!=null) {
			Iterator iterClasif = 
				filtrosPorDescClasif.keySet().iterator();
			while (iterClasif.hasNext()) {
				ClasificadorEntidad clasifEnt = (ClasificadorEntidad) iterClasif.next();
				String descFiltro = (String)filtrosPorDescClasif.get(clasifEnt);
				// Dame todos los oid_productos que correspondan al filtro ingresado
				if (clasifEnt.getNickname().equals(Producto.NICKNAME)) {
					textSQL.append(" and a.oid_producto in ");
					textSQL.append(" ( ");
					textSQL.append(" select oid_producto from stProducto a1 , geValClasifEnt a2 ");
					textSQL.append(" where a1."+clasifEnt.getCampoFisico()+"=a2.oid_val_clasif_ent ");
					textSQL.append(" and a2.oid_clasif_ent="+clasifEnt.getOIDInteger());
					StringTokenizer st = new StringTokenizer(descFiltro, " ");
					while (st.hasMoreTokens()) {
						String next = st.nextToken();
						textSQL.append(" and a2.descripcion like '%" + next + "%' ");
					}
					textSQL.append(" ) ");
				} else if (clasifEnt.getNickname().equals(ExtensionProdGen.NICKNAME)) {
					//Extension producto General
					ClasificadorEntidad clasifProdGral = 
						Producto.getClasifProductoGeneral(this.getSesion());
					textSQL.append(" and a.oid_producto in ");
					textSQL.append(" ( ");
					textSQL.append(" select a1.oid_producto from stProducto a1 , stExtensionPG a2 , geValClasifEnt a3 ");
					textSQL.append(" where a1."+clasifProdGral.getCampoFisico()+"=a2.oid_val_clasif_ent ");
					textSQL.append(" and a2."+clasifEnt.getCampoFisico()+"=a3.oid_val_clasif_ent ");
					
					StringTokenizer st = new StringTokenizer(descFiltro, " ");
					while (st.hasMoreTokens()) {
						String next = st.nextToken();
						textSQL.append(" and a3.descripcion like '%" + next + "%' ");
					}

					textSQL.append(" ) ");
					}
					
			}
		}
		
		if (filtroPorDescProdStk!=null) {
			textSQL.append(" and a.oid_producto in ");
			textSQL.append(" ( ");
			textSQL.append(" select a1.oid_producto from stProducto a1 WHERE 1=1 ");
			StringTokenizer st = new StringTokenizer(filtroPorDescProdStk, " ");
			while (st.hasMoreTokens()) {
				String next = st.nextToken();		
				textSQL.append(" and a1.desc_search like '%" + next + "%' ");
			}
			textSQL.append(" ) ");
			
		}
		
		if (listaEstados != null) {
			Iterator iterEstados = listaEstados.iterator();
			StringBuffer listaDeOidEstados = new StringBuffer("");
			while (iterEstados.hasNext()) {
				EstadoStock estadoStock = (EstadoStock) iterEstados.next();
				if (listaDeOidEstados.length() == 0)
					listaDeOidEstados.append(estadoStock.getOIDInteger());
				else
					listaDeOidEstados.append("," + estadoStock.getOIDInteger());
			}
			if (listaEstados.size() > 0)
				textSQL.append(" and b.oid_estado_stock in( " + listaDeOidEstados.toString() + ") ");
		}

		if (listaDepositos != null) {
			Iterator iterDepositos = listaDepositos.iterator();
			StringBuffer listaDeOidDepositos = new StringBuffer("");
			while (iterDepositos.hasNext()) {
				Deposito deposito = (Deposito) iterDepositos.next();
				if (listaDeOidDepositos.length() == 0)
					listaDeOidDepositos.append(deposito.getOIDInteger());
				else
					listaDeOidDepositos.append("," + deposito.getOIDInteger());
			}
			if (listaDepositos.size() > 0)
				textSQL.append(" and b.oid_deposito in( " + listaDeOidDepositos.toString() + ") ");
		}
		textSQL.append(" group by a.oid_producto,a.codigo,a.descripcion, ");
		textSQL.append(" a.oid_um_stk,b.oid_deposito ");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}

	private PreparedStatement selectByConsMasivaAFecha(Object aCondiciones) throws BaseException, SQLException {

		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		java.util.Date fechaHasta = (java.util.Date) condiciones.get("FECHA_HASTA");
		Deposito deposito = (Deposito) condiciones.get(Deposito.NICKNAME);

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT a.oid_producto,a.codigo cod_producto,a.descripcion desc_producto, ");
		textSQL.append(" a.oid_um_stk oid_um,b.oid_deposito,sum(cantidad*signo) cantidad ");
		textSQL.append(" FROM  stProducto a , skStockMov b");
		textSQL.append(" WHERE a.oid_producto = b.oid_producto and 1=1 ");

		textSQL.append(" and b.oid_deposito = " + deposito.getOIDInteger());

		textSQL.append(" and b.fecha <= ? ");

		if (condiciones.containsKey("oid_producto"))
			textSQL.append(" and a.oid_producto = " + (Integer) (condiciones.get("oid_producto")));

		List listEstados = (List) condiciones.get("ESTADOS_STOCK");
		if (listEstados != null) {
			int i = 1;
			Iterator iterEstados = listEstados.iterator();
			while (iterEstados.hasNext()) {
				EstadoStock estadoStock = (EstadoStock) iterEstados.next();
				if (i == 1) {
					textSQL.append("and b.oid_estado_stock in (");
					textSQL.append(estadoStock.getOIDInteger());
				} else
					textSQL.append("," + estadoStock.getOIDInteger());
				++i;
			}
			if (i > 1)
				textSQL.append(") ");

		}

		// Descripcion del producto
		if (condiciones.containsKey("codigo_producto") && (condiciones.getString("codigo_producto").length() > 0)) {
			StringTokenizer st = new StringTokenizer(condiciones.getString("codigo_producto"), " ");
			while (st.hasMoreTokens()) {
				String next = st.nextToken().toUpperCase();
				textSQL.append(" and a.codigo like '%" + next + "%' ");
			}
		}

		// Descripcion del producto
		if (condiciones.containsKey("desc_producto") && (condiciones.getString("desc_producto").length() > 0)) {
			StringTokenizer st = new StringTokenizer(condiciones.getString("desc_producto"), " ");
			while (st.hasMoreTokens()) {
				String next = st.nextToken().toUpperCase();
				textSQL.append(" and a.desc_search like '%" + next + "%' ");
			}
		}

		if (condiciones.containsKey("LISTA_VAL_CLASIF")) {
			HashTableDatos listaValClasif = (HashTableDatos) condiciones.get("LISTA_VAL_CLASIF");
			Iterator iterValoresClasif = listaValClasif.keySet().iterator();
			while (iterValoresClasif.hasNext()) {
				ClasificadorEntidad clasifEnt = (ClasificadorEntidad) iterValoresClasif.next();
				IValorClasificadorEntidad valor = (IValorClasificadorEntidad) listaValClasif.get(clasifEnt);
				textSQL.append(" and a." + clasifEnt.getCampoFisico() + "=" + valor.getOID());
			}
		}

		textSQL.append(" group by a.oid_producto,a.codigo,a.descripcion,a.oid_um_stk,b.oid_deposito ");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		querySelect.setDate(1, new java.sql.Date(fechaHasta.getTime()));
		return querySelect;
	}

	private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

		final int CODIGO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  aaa ");
		textSQL.append(" WHERE  = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		String codigo = (String) aCondiciones;
		querySelect.setString(CODIGO, codigo);
		return querySelect;
	}

	private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();

		textSQL.append("SELECT oid_cons_stock oid, codigo,  descripcion ,activo ");
		textSQL.append(" from aaa");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}

	public static List getConsultaMasivaProductos(Integer oidProducto, String descProducto, String codigoProducto,
			HashTableDatos listaValoresClasif, Deposito deposito, java.util.Date fechaHasta, List estadosStock, ISesion aSesion)
			throws BaseException {

		HashTableDatos condiciones = new HashTableDatos();

		if ((oidProducto != null) && (oidProducto.intValue() > 0))
			condiciones.put("oid_producto", oidProducto);

		if ((descProducto != null) && (descProducto.length() > 0))
			condiciones.put("desc_producto", descProducto);

		if ((codigoProducto != null) && (codigoProducto.length() > 0))
			condiciones.put("codigo_producto", codigoProducto);

		if (estadosStock != null)
			condiciones.put("ESTADOS_STOCK", estadosStock);

		if ((listaValoresClasif != null) && (listaValoresClasif.keySet().size() > 0))
			condiciones.put("LISTA_VAL_CLASIF", listaValoresClasif);
		condiciones.put("FECHA_HASTA", fechaHasta);
		condiciones.put(Deposito.NICKNAME, deposito);

		return (List) ObjetoLogico.getObjects(ConsultaStock.NICKNAME, DBConsultaStock.SELECT_BY_CONS_MASIVA_A_FECHA, condiciones,
				new ListObserver(), aSesion);
	}
	
	public static List getConsultaSaldosEstadosStock(
			List listaDepositos, 
			List listaEstados, 
			HashTableDatos filtrosPorDescClasif,
			String filtroPorDescProdStock,
			HashTableDatos filtrosPorValorClasif,
			Producto producto,
			ISesion aSesion)
			throws BaseException {

		HashTableDatos condiciones = new HashTableDatos();
		
		if (listaDepositos!=null)
			condiciones.put("LISTA_DEPOSITOS", listaDepositos);
		
		if (listaEstados!=null)
			condiciones.put("LISTA_ESTADOS", listaEstados);
		
		if (filtrosPorDescClasif!=null)
			condiciones.put("FILTROS_POR_DESC_CLASIF", filtrosPorDescClasif);
		
		if (filtroPorDescProdStock!=null)
			condiciones.put("FILTROS_POR_DESC_PROD_STK", filtroPorDescProdStock);
		
		if (filtrosPorValorClasif!=null)
			condiciones.put("FILTROS_POR_VALOR_CLASIF",
					filtrosPorValorClasif);
		
		if (producto!=null)
			condiciones.put("PRODUCTO", producto);
		
		return (List) ObjetoLogico.getObjects(
				ConsultaStock.NICKNAME, 
				DBConsultaStock.SELECT_BY_SALDO_POR_ESTADO, 
				condiciones,
				new ListObserver(), 
				aSesion);
	}
	

}
