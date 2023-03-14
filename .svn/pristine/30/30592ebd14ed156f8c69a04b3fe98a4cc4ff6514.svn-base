package com.srn.erp.stock.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.general.bm.ValorClasificadorEntidad;
import com.srn.erp.impuestos.bm.ConceptoImpuesto;
import com.srn.erp.stock.bm.ConceptoImpuestoProducto;
import com.srn.erp.stock.bm.Producto;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.ObjetoObservado;

public class DBConceptoImpuestoProducto extends DBObjetoPersistente {

	public static final String	OID_CONC_IMPU_PROD							= "oid_conc_impu_prod";

	public static final String	OID_PRODUCTO										= "oid_producto";

	public static final String	OID_CONC_IMPU										= "oid_conc_impu";

	public static final String	FECHA_VIGENCIA									= "fecha_vigencia";
	
	public static final String	OID_VAL_CLASIF_ENT									= "oid_val_clasif_ent";
	
	public static final int			SELECT_BY_PRODUCTO							= 100;

	public static final int			SELECT_BY_PROD_FEC_VIG_IVA			= 101;

	public static final int			SELECT_BY_PROD_FEC_VIG_IMP_INT	= 102;

	public static final int			SELECT_BY_PROD_FEC_VIG_PERC_IB	= 103;

	public static final int			SELECT_BY_PROD_FEC_VIG_PERC_IVA	= 104;
	
	public static final int			SELECT_BY_VAL_CLASIF_ENT	= 105;
	
	public static final int			SELECT_BY_PROD_FEC_IMPU	= 106;
	
	public static final int			SELECT_BY_PROD_GEN_FEC_VIG_IVA			= 107;
	
	public static final int			SELECT_BY_PROD_GEN_FEC_VIG_PERC_IVA			= 108;
	
	public static final int			SELECT_BY_PROD_GEN_FEC_VIG_IMP_INT			= 109;
	
	public static final int			SELECT_BY_PROD_GEN_FEC_VIG_PERC_IB			= 110;
	
	
	
	
	
	
	
	

	public DBConceptoImpuestoProducto() {
	}

	protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_CONC_IMPU_PROD = 1;
		final int OID_PRODUCTO = 2;
		final int OID_CONC_IMPU = 3;
		final int FECHA_VIGENCIA = 4;
		final int OID_VAL_CLASIF_ENT = 5;

		ConceptoImpuestoProducto pers = (ConceptoImpuestoProducto) objetoPersistente;

		StringBuffer sqlInsert = new StringBuffer();
		sqlInsert.append(" insert into stConcImpuProd " + " ( " + "OID_CONC_IMPU_PROD," + "OID_PRODUCTO,"
				+ "OID_CONC_IMPU," + "FECHA_VIGENCIA , OID_VAL_CLASIF_ENT)" + " values " + "(" + "?,"+ "?," + "?," + "?," + "?) ");

		PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
		qInsert.setInt(OID_CONC_IMPU_PROD, pers.getOID());
		if (pers.getProducto()!=null)
			qInsert.setInt(OID_PRODUCTO, pers.getProducto().getOID());
		else
			qInsert.setNull(OID_PRODUCTO, java.sql.Types.INTEGER);
		qInsert.setInt(OID_CONC_IMPU, pers.getConcepto_impuesto().getOID());
		qInsert.setDate(FECHA_VIGENCIA, new java.sql.Date(pers.getFecha_vigencia().getTime()));
		if (pers.getValClasifEnt()!=null)
			qInsert.setInt(OID_VAL_CLASIF_ENT, pers.getValClasifEnt().getOID());
		else
			qInsert.setNull(OID_VAL_CLASIF_ENT, java.sql.Types.INTEGER);
		qInsert.executeUpdate();
		qInsert.close();
	}

	protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_PRODUCTO = 1;
		final int OID_CONC_IMPU = 2;
		final int FECHA_VIGENCIA = 3;
		final int OID_VAL_CLASIF_ENT = 4;
		final int OID_CONC_IMPU_PROD = 5;

		ConceptoImpuestoProducto pers = (ConceptoImpuestoProducto) objetoPersistente;

		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append(" update stConcImpuProd set " + "oid_producto=?" + ",oid_conc_impu=?" + ",fecha_vigencia=? , oid_val_clasif_ent = ? "
				+ " where " + " oid_conc_impu_prod=? ");

		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_CONC_IMPU_PROD, pers.getOID());
		
		if (pers.getProducto()!=null)
			qUpdate.setInt(OID_PRODUCTO, pers.getProducto().getOID());
		else
			qUpdate.setNull(OID_PRODUCTO, java.sql.Types.INTEGER);		
		
		qUpdate.setInt(OID_CONC_IMPU, pers.getConcepto_impuesto().getOID());
		qUpdate.setDate(FECHA_VIGENCIA, new java.sql.Date(pers.getFecha_vigencia().getTime()));
		if (pers.getValClasifEnt()!=null)
			qUpdate.setInt(OID_VAL_CLASIF_ENT, pers.getValClasifEnt().getOID());
		else
			qUpdate.setNull(OID_VAL_CLASIF_ENT, java.sql.Types.INTEGER);
		
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_CONC_IMPU_PROD = 1;
		ConceptoImpuestoProducto pers = (ConceptoImpuestoProducto) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("delete from stConcImpuProd " + " where " + " oid_conc_impu_prod=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_CONC_IMPU_PROD, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_CONC_IMPU_PROD = 1;
		ConceptoImpuestoProducto pers = (ConceptoImpuestoProducto) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update stConcImpuProd " + " set activo=1 " + " where " + " oid_conc_impu_prod=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_CONC_IMPU_PROD, pers.getOID());
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
		case SELECT_BY_PRODUCTO: {
			ps = this.selectByProducto(aCondiciones);
			break;
		}
		case SELECT_BY_PROD_FEC_VIG_IVA: {
			ps = this.selectByProductoFecVigIVA(aCondiciones);
			break;
		}
		case SELECT_BY_PROD_GEN_FEC_VIG_IVA: {
			ps = this.selectByProductoGralFecVigIVA(aCondiciones);
			break;
		}
		
		case SELECT_BY_PROD_GEN_FEC_VIG_PERC_IB: {
			ps = this.selectByProductoGralFecPercIB(aCondiciones);
			break;
		}
		case SELECT_BY_PROD_GEN_FEC_VIG_PERC_IVA: {
			ps = this.selectByProductoGenFecVigPercIVA(aCondiciones);
			break;
		}
		case SELECT_BY_PROD_GEN_FEC_VIG_IMP_INT: {
			ps = this.selectByProductoGenFecVigImpInt(aCondiciones);
			break;
		}
		case SELECT_BY_PROD_FEC_VIG_PERC_IVA: {
			ps = this.selectByProductoFecVigPercIVA(aCondiciones);
			break;
		}

		case SELECT_BY_PROD_FEC_VIG_IMP_INT: {
			ps = this.selectByProductoFecVigImpInt(aCondiciones);
			break;
		}
		case SELECT_BY_PROD_FEC_VIG_PERC_IB: {
			ps = this.selectByProductoFecVigPercIB(aCondiciones);
			break;
		}
		case SELECT_BY_VAL_CLASIF_ENT: {
			ps = this.selectByValClasifEnt(aCondiciones);
			break;
		}
		case SELECT_BY_PROD_FEC_IMPU: {
			ps = this.selectByProdFechaImpu(aCondiciones);
			break;
		}
		}
		return ps;
	}

	private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

		final int OID_CONC_IMPU_PROD = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  stConcImpuProd ");
		textSQL.append(" WHERE oid_conc_impu_prod = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		int oid = ((Integer) aCondiciones).intValue();
		querySelect.setInt(OID_CONC_IMPU_PROD, oid);
		return querySelect;
	}
	
	private PreparedStatement selectByValClasifEnt(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  stConcImpuProd ");
		textSQL.append(" WHERE oid_val_clasif_ent = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		ValorClasificadorEntidad valClasifEnt = (ValorClasificadorEntidad) aCondiciones;
		querySelect.setInt(1, valClasifEnt.getOID());
		return querySelect;
	}
	
	
	private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

		final int CODIGO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  stConcImpuProd ");
		textSQL.append(" WHERE  = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		String codigo = (String) aCondiciones;
		querySelect.setString(CODIGO, codigo);
		return querySelect;
	}

	private PreparedStatement selectByProducto(Object aCondiciones) throws BaseException, SQLException {

		final int CODIGO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  stConcImpuProd ");
		textSQL.append(" WHERE oid_producto = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		Producto producto = (Producto) aCondiciones;
		querySelect.setInt(CODIGO, producto.getOID());
		return querySelect;
	}
	
	private PreparedStatement selectByProdFechaImpu(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  stConcImpuProd ");
		textSQL.append(" WHERE oid_producto = ? and fecha_vigencia = ? and oid_conc_impu = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		
		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		Producto producto = (Producto) condiciones.get(Producto.NICKNAME);
		java.util.Date fecha = (java.util.Date) condiciones.get("FECHA");
		ConceptoImpuesto concImpu = (ConceptoImpuesto) condiciones.get(ConceptoImpuesto.NICKNAME);
		
		querySelect.setInt(1, producto.getOID());
		querySelect.setDate(2, new java.sql.Date(fecha.getTime()));
		querySelect.setInt(3, concImpu.getOID());
		
		return querySelect;
	}	
	
	private PreparedStatement selectByProductoGralFecPercIB(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  stConcImpuProd ");
		textSQL.append(" WHERE oid_val_clasif_ent = ? ");
		textSQL.append(" and fecha_vigencia <= ? and oid_conc_impu ");
		textSQL.append(" in ");
		textSQL.append("  (select oid_conc_impu from imconcimpu where oid_impuesto in ");
		textSQL.append("  (select oid_impuesto from imimpuestos where compo='PERC_IB')) ");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		ValorClasificadorEntidad valorClasifEnt = (ValorClasificadorEntidad) condiciones.get(ValorClasificadorEntidad.NICKNAME);
		java.util.Date fecha = (java.util.Date) condiciones.get("fecha");
		querySelect.setInt(1, valorClasifEnt.getOIDInteger().intValue());
		querySelect.setDate(2, new java.sql.Date(fecha.getTime()));
		return querySelect;
	}
	

	private PreparedStatement selectByProductoGralFecVigIVA(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  stConcImpuProd ");
		textSQL.append(" WHERE oid_val_clasif_ent = ? ");
		textSQL.append(" and fecha_vigencia <= ? and oid_conc_impu ");
		textSQL.append(" in ");
		textSQL.append("  (select oid_conc_impu from imconcimpu where oid_impuesto in ");
		textSQL.append("  (select oid_impuesto from imimpuestos where compo='IVA')) ");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		ValorClasificadorEntidad valorClasifEnt = (ValorClasificadorEntidad) condiciones.get(ValorClasificadorEntidad.NICKNAME);
		java.util.Date fecha = (java.util.Date) condiciones.get("fecha");
		querySelect.setInt(1, valorClasifEnt.getOIDInteger().intValue());
		querySelect.setDate(2, new java.sql.Date(fecha.getTime()));
		return querySelect;
	}
	
	private PreparedStatement selectByProductoFecVigIVA(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  stConcImpuProd ");
		textSQL.append(" WHERE oid_producto = ? and fecha_vigencia <= ? and oid_conc_impu ");
		textSQL.append(" in ");
		textSQL.append("  (select oid_conc_impu from imconcimpu where oid_impuesto in ");
		textSQL.append("  (select oid_impuesto from imimpuestos where compo='IVA')) ");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		Producto producto = (Producto) condiciones.get(Producto.NICKNAME);
		java.util.Date fecha = (java.util.Date) condiciones.get("fecha");
		if (producto.getOIDInteger()!=null)
			querySelect.setInt(1, producto.getOIDInteger().intValue());
		else
			querySelect.setInt(1, 0);
		querySelect.setDate(2, new java.sql.Date(fecha.getTime()));
		return querySelect;
	}
	
	private PreparedStatement selectByProductoGenFecVigImpInt(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  stConcImpuProd ");
		textSQL.append(" WHERE oid_val_clasif_ent = ? and fecha_vigencia <= ? and oid_conc_impu ");
		textSQL.append(" in ");
		textSQL.append("  (select oid_conc_impu from imconcimpu where oid_impuesto in ");
		textSQL.append("  (select oid_impuesto from imimpuestos where compo='IMP_INT')) ");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		ValorClasificadorEntidad valClasifEnt = (ValorClasificadorEntidad) condiciones.get(ValorClasificadorEntidad.NICKNAME);
		java.util.Date fecha = (java.util.Date) condiciones.get("fecha");
		querySelect.setInt(1, valClasifEnt.getOID());
		querySelect.setDate(2, new java.sql.Date(fecha.getTime()));
		return querySelect;
	}
	
	
	
	private PreparedStatement selectByProductoGenFecVigPercIVA(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  stConcImpuProd ");
		textSQL.append(" WHERE oid_val_clasif_ent = ? and fecha_vigencia <= ? and oid_conc_impu ");
		textSQL.append(" in ");
		textSQL.append("  (select oid_conc_impu from imconcimpu where oid_impuesto in ");
		textSQL.append("  (select oid_impuesto from imimpuestos where compo='PERC_IVA')) ");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		ValorClasificadorEntidad valClasifEnt = (ValorClasificadorEntidad) condiciones.get(ValorClasificadorEntidad.NICKNAME);
		java.util.Date fecha = (java.util.Date) condiciones.get("fecha");
		querySelect.setInt(1, valClasifEnt.getOID());
		querySelect.setDate(2, new java.sql.Date(fecha.getTime()));
		return querySelect;
	}
	

	private PreparedStatement selectByProductoFecVigPercIVA(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  stConcImpuProd ");
		textSQL.append(" WHERE oid_producto = ? and fecha_vigencia <= ? and oid_conc_impu ");
		textSQL.append(" in ");
		textSQL.append("  (select oid_conc_impu from imconcimpu where oid_impuesto in ");
		textSQL.append("  (select oid_impuesto from imimpuestos where compo='PERC_IVA')) ");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		Producto producto = (Producto) condiciones.get(Producto.NICKNAME);
		java.util.Date fecha = (java.util.Date) condiciones.get("fecha");
		querySelect.setInt(1, producto.getOID());
		querySelect.setDate(2, new java.sql.Date(fecha.getTime()));
		return querySelect;
	}

	private PreparedStatement selectByProductoFecVigImpInt(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  stConcImpuProd ");
		textSQL.append(" WHERE oid_producto = ? and fecha_vigencia <= ? and oid_conc_impu ");
		textSQL.append(" in ");
		textSQL.append("  (select oid_conc_impu from imconcimpu where oid_impuesto in ");
		textSQL.append("  (select oid_impuesto from imimpuestos where compo='IMP_INT')) ");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		Producto producto = (Producto) condiciones.get(Producto.NICKNAME);
		java.util.Date fecha = (java.util.Date) condiciones.get("fecha");
		querySelect.setInt(1, producto.getOID());
		querySelect.setDate(2, new java.sql.Date(fecha.getTime()));
		return querySelect;
	}

	private PreparedStatement selectByProductoFecVigPercIB(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  stConcImpuProd ");
		textSQL.append(" WHERE oid_producto = ? and fecha_vigencia <= ? and oid_conc_impu ");
		textSQL.append(" in ");
		textSQL.append("  (select oid_conc_impu from imconcimpu where oid_impuesto in ");
		textSQL.append("  (select oid_impuesto from imimpuestos where compo='PERC_IB')) ");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		Producto producto = (Producto) condiciones.get(Producto.NICKNAME);
		java.util.Date fecha = (java.util.Date) condiciones.get("fecha");
		querySelect.setInt(1, producto.getOID());
		querySelect.setDate(2, new java.sql.Date(fecha.getTime()));
		return querySelect;
	}

	private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();

		textSQL.append("SELECT oid_conc_impu_prod oid, codigo,  descripcion ,activo ");
		textSQL.append(" from stConcImpuProd");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}

	public static List getConceptosImpuestosProducto(Producto producto, ISesion aSesion) throws BaseException {
		return (List) ObjetoLogico.getObjects(ConceptoImpuestoProducto.NICKNAME,
				DBConceptoImpuestoProducto.SELECT_BY_PRODUCTO, producto, new ListObserver(), aSesion);
	}
	
	public static List getConceptosImpuestos(ValorClasificadorEntidad valorClasifEnt, ISesion aSesion) throws BaseException {
		return (List) ObjetoLogico.getObjects(ConceptoImpuestoProducto.NICKNAME,
				DBConceptoImpuestoProducto.SELECT_BY_VAL_CLASIF_ENT, valorClasifEnt, new ListObserver(), aSesion);
	}
	

	public static ConceptoImpuestoProducto getConcImpuProdIVA(Producto producto, java.util.Date fecha, ISesion aSesion)
			throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put(Producto.NICKNAME, producto);
		condiciones.put("fecha", fecha);
		List listaConcImpuProdIVA = (List) ObjetoLogico.getObjects(ConceptoImpuestoProducto.NICKNAME,
				DBConceptoImpuestoProducto.SELECT_BY_PROD_FEC_VIG_IVA, condiciones, new ListObserver(), aSesion);
		ConceptoImpuestoProducto concImpuProdVig = null;
		Iterator iterConcImpuProdIVA = listaConcImpuProdIVA.iterator();
		while (iterConcImpuProdIVA.hasNext()) {
			ConceptoImpuestoProducto concImpuProd = (ConceptoImpuestoProducto) iterConcImpuProdIVA.next();
			if (concImpuProdVig == null)
				concImpuProdVig = concImpuProd;
			else if (concImpuProd.getFecha_vigencia().after(concImpuProdVig.getFecha_vigencia()))
				concImpuProdVig = concImpuProd;
		}
		return concImpuProdVig;
	}
	
	
	
	
	public static ConceptoImpuestoProducto getConcImpuProdGralPercIVA(
			ValorClasificadorEntidad valClasifEnt, 
			java.util.Date fecha, ISesion aSesion)
		throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put(ValorClasificadorEntidad.NICKNAME, valClasifEnt);
		condiciones.put("fecha", fecha);
		List listaConcImpuProdIVA = (List) ObjetoLogico.getObjects(ConceptoImpuestoProducto.NICKNAME,
				DBConceptoImpuestoProducto.SELECT_BY_PROD_GEN_FEC_VIG_PERC_IVA, condiciones, new ListObserver(), aSesion);
		ConceptoImpuestoProducto concImpuProdVig = null;
		Iterator iterConcImpuProdIVA = listaConcImpuProdIVA.iterator();
		while (iterConcImpuProdIVA.hasNext()) {
			ConceptoImpuestoProducto concImpuProd = (ConceptoImpuestoProducto) iterConcImpuProdIVA.next();
			if (concImpuProdVig == null)
				concImpuProdVig = concImpuProd;
			else if (concImpuProd.getFecha_vigencia().after(concImpuProdVig.getFecha_vigencia()))
				concImpuProdVig = concImpuProd;
		}
		return concImpuProdVig;
	}
	
	
	

	public static ConceptoImpuestoProducto getConcImpuProdGralPercIB(
			ValorClasificadorEntidad valClasifEnt, 
			java.util.Date fecha, ISesion aSesion)
		throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put(ValorClasificadorEntidad.NICKNAME, valClasifEnt);
		condiciones.put("fecha", fecha);
		List listaConcImpuProdIVA = (List) ObjetoLogico.getObjects(ConceptoImpuestoProducto.NICKNAME,
				DBConceptoImpuestoProducto.SELECT_BY_PROD_GEN_FEC_VIG_PERC_IB, condiciones, new ListObserver(), aSesion);
		ConceptoImpuestoProducto concImpuProdVig = null;
		Iterator iterConcImpuProdIVA = listaConcImpuProdIVA.iterator();
		while (iterConcImpuProdIVA.hasNext()) {
			ConceptoImpuestoProducto concImpuProd = (ConceptoImpuestoProducto) iterConcImpuProdIVA.next();
			if (concImpuProdVig == null)
				concImpuProdVig = concImpuProd;
			else if (concImpuProd.getFecha_vigencia().after(concImpuProdVig.getFecha_vigencia()))
				concImpuProdVig = concImpuProd;
		}
		return concImpuProdVig;
	}
	
	
	
	public static ConceptoImpuestoProducto getConcImpuProdGralImpInt(
			ValorClasificadorEntidad valClasifEnt, 
			java.util.Date fecha, ISesion aSesion)
		throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put(ValorClasificadorEntidad.NICKNAME, valClasifEnt);
		condiciones.put("fecha", fecha);
		List listaConcImpuProdIVA = (List) ObjetoLogico.getObjects(ConceptoImpuestoProducto.NICKNAME,
				DBConceptoImpuestoProducto.SELECT_BY_PROD_GEN_FEC_VIG_IMP_INT, condiciones, new ListObserver(), aSesion);
		ConceptoImpuestoProducto concImpuProdVig = null;
		Iterator iterConcImpuProdIVA = listaConcImpuProdIVA.iterator();
		while (iterConcImpuProdIVA.hasNext()) {
			ConceptoImpuestoProducto concImpuProd = (ConceptoImpuestoProducto) iterConcImpuProdIVA.next();
			if (concImpuProdVig == null)
				concImpuProdVig = concImpuProd;
			else if (concImpuProd.getFecha_vigencia().after(concImpuProdVig.getFecha_vigencia()))
				concImpuProdVig = concImpuProd;
		}
		return concImpuProdVig;
	}
	
	
	public static ConceptoImpuestoProducto getConcImpuProdGralIVA(
			ValorClasificadorEntidad valClasifEnt, 
			java.util.Date fecha, ISesion aSesion)
		throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put(ValorClasificadorEntidad.NICKNAME, valClasifEnt);
		condiciones.put("fecha", fecha);
		List listaConcImpuProdIVA = (List) ObjetoLogico.getObjects(ConceptoImpuestoProducto.NICKNAME,
				DBConceptoImpuestoProducto.SELECT_BY_PROD_GEN_FEC_VIG_IVA, condiciones, new ListObserver(), aSesion);
		ConceptoImpuestoProducto concImpuProdVig = null;
		Iterator iterConcImpuProdIVA = listaConcImpuProdIVA.iterator();
		while (iterConcImpuProdIVA.hasNext()) {
			ConceptoImpuestoProducto concImpuProd = (ConceptoImpuestoProducto) iterConcImpuProdIVA.next();
			if (concImpuProdVig == null)
				concImpuProdVig = concImpuProd;
			else if (concImpuProd.getFecha_vigencia().after(concImpuProdVig.getFecha_vigencia()))
				concImpuProdVig = concImpuProd;
		}
		return concImpuProdVig;
	}
	

	public static ConceptoImpuestoProducto getConcImpuProdPercIVA(Producto producto, java.util.Date fecha, ISesion aSesion)
			throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put(Producto.NICKNAME, producto);
		condiciones.put("fecha", fecha);
		List listaConcImpuProdPercIVA = (List) ObjetoLogico.getObjects(ConceptoImpuestoProducto.NICKNAME,
				DBConceptoImpuestoProducto.SELECT_BY_PROD_FEC_VIG_PERC_IVA, condiciones, new ListObserver(), aSesion);
		ConceptoImpuestoProducto concImpuProdVig = null;
		Iterator iterConcImpuProdPercIVA = listaConcImpuProdPercIVA.iterator();
		while (iterConcImpuProdPercIVA.hasNext()) {
			ConceptoImpuestoProducto concImpuProd = (ConceptoImpuestoProducto) iterConcImpuProdPercIVA.next();
			if (concImpuProdVig == null)
				concImpuProdVig = concImpuProd;
			else if (concImpuProd.getFecha_vigencia().after(concImpuProdVig.getFecha_vigencia()))
				concImpuProdVig = concImpuProd;
		}
		return concImpuProdVig;
	}

	public static ConceptoImpuestoProducto getConcImpuProdImpInt(Producto producto, java.util.Date fecha, ISesion aSesion)
			throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put(Producto.NICKNAME, producto);
		condiciones.put("fecha", fecha);
		List listaConcImpuProdImpInt = (List) ObjetoLogico.getObjects(ConceptoImpuestoProducto.NICKNAME,
				DBConceptoImpuestoProducto.SELECT_BY_PROD_FEC_VIG_IMP_INT, condiciones, new ListObserver(), aSesion);
		ConceptoImpuestoProducto concImpuProdVig = null;
		Iterator iterConcImpuProdImpInt = listaConcImpuProdImpInt.iterator();
		while (iterConcImpuProdImpInt.hasNext()) {
			ConceptoImpuestoProducto concImpuProd = (ConceptoImpuestoProducto) iterConcImpuProdImpInt.next();
			if (concImpuProdVig == null)
				concImpuProdVig = concImpuProd;
			else if (concImpuProd.getFecha_vigencia().after(concImpuProdVig.getFecha_vigencia()))
				concImpuProdVig = concImpuProd;
		}
		return concImpuProdVig;
	}

	public static ConceptoImpuestoProducto getConcImpuProdPercIB(Producto producto, java.util.Date fecha, ISesion aSesion)
			throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put(Producto.NICKNAME, producto);
		condiciones.put("fecha", fecha);
		List listaConcImpuProdPercIB = (List) ObjetoLogico.getObjects(ConceptoImpuestoProducto.NICKNAME,
				DBConceptoImpuestoProducto.SELECT_BY_PROD_FEC_VIG_PERC_IB, condiciones, new ListObserver(), aSesion);
		ConceptoImpuestoProducto concImpuProdVig = null;
		Iterator iterConcImpuProdPercIB = listaConcImpuProdPercIB.iterator();
		while (iterConcImpuProdPercIB.hasNext()) {
			ConceptoImpuestoProducto concImpuProd = (ConceptoImpuestoProducto) iterConcImpuProdPercIB.next();
			if (concImpuProdVig == null)
				concImpuProdVig = concImpuProd;
			else if (concImpuProd.getFecha_vigencia().after(concImpuProdVig.getFecha_vigencia()))
				concImpuProdVig = concImpuProd;
		}
		return concImpuProdVig;
	}
	
	public static ConceptoImpuestoProducto getConcImpuProd(
			Producto producto, 
			java.util.Date fecha, 
			ConceptoImpuesto concImpu, ISesion aSesion)
		throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put(Producto.NICKNAME, producto);
		condiciones.put("FECHA", fecha);
		condiciones.put(ConceptoImpuesto.NICKNAME, concImpu);
		
		return (ConceptoImpuestoProducto) ObjetoLogico.getObjects(ConceptoImpuestoProducto.NICKNAME,
				DBConceptoImpuestoProducto.SELECT_BY_PROD_FEC_IMPU, condiciones, new ObjetoObservado(), aSesion);
		
		
	}
	

}
