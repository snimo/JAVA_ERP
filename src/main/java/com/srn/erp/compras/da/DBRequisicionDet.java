package com.srn.erp.compras.da;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.compras.bm.Proveedor;
import com.srn.erp.compras.bm.RequisicionCab;
import com.srn.erp.compras.bm.RequisicionDet;
import com.srn.erp.stock.bm.Producto;
import com.srn.erp.ventas.bm.PedidoDet;
import com.srn.erp.ventas.bm.Sujeto;
import com.srn.erp.ventas.da.DBPedidoDet;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;

public class DBRequisicionDet extends DBObjetoPersistente {

  public static final String OID_REQ_DET = "oid_req_det";
  public static final String OID_CCO_REQUI = "oid_cco_requi";
  public static final String OID_PRODUCTO = "oid_producto";
  public static final String NRO_RENGLON = "nro_renglon";
  public static final String CANT_SOLICITADA = "cant_solicitada";
  public static final String OID_UM_REQ = "oid_um_req";
  public static final String CANT_COMPRADA = "cant_comprada";
  public static final String FEC_REQUERIDA = "fec_requerida";
  public static final String FEC_ENTREGA = "fec_entrega";
  public static final String DECISION_AUTORIZ = "decision_autoriz";
  public static final String ANULADA = "anulada";
  public static final String SOLO_COTIZAR = "solo_cotizar";
  public static final String COMENTARIO = "comentario";
  public static final String DESC_ADIC_SKU = "desc_adic_sku";
  public static final String PEND_SOL_COTIZ = "pend_sol_cotiz";
  public static final String FEC_EMISION = "fec_emision";
  public static final String PEND_COMPRA = "pend_compra";
  public static final String OID_PROVEEDOR = "oid_proveedor";
  public static final String NICKNAME_REF_COMPRO = "ref_tipo_compro";
  public static final String OID_CCO_REF = "oid_cco_ref";
  public static final String OID_CCO_DET_REF = "oid_cco_det_ref";
  
  
  public static final int SELECT_BY_REQUISICION_CAB = 100;
  public static final int SELECT_BY_PEND_COMPRA = 101;
  public static final int SELECT_BY_TODOS = 102;

  public DBRequisicionDet() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_REQ_DET = 1;
    final int OID_CCO_REQUI = 2;
    final int OID_PRODUCTO = 3;
    final int NRO_RENGLON = 4;
    final int CANT_SOLICITADA = 5;
    final int OID_UM_REQ = 6;
    final int CANT_COMPRADA = 7;
    final int FEC_REQUERIDA = 8;
    final int FEC_ENTREGA = 9;
    final int DECISION_AUTORIZ = 10;
    final int ANULADA = 11;
    final int SOLO_COTIZAR = 12;
    final int COMENTARIO = 13;
    final int DESC_ADIC_SKU = 14;
    final int PEND_SOL_COTIZ = 15;
    final int FEC_EMISION = 16;
    final int PEND_COMPRA = 17;
    final int OID_PROVEEDOR = 18;
    final int OID_CCO_REF = 19;
    final int OID_CCO_DET_REF = 20;
    final int REF_TIPO_COMPRO = 21;

    RequisicionDet pers = (RequisicionDet) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into cpRequiDet "+
                     " ( "+
                      "OID_REQ_DET,"+
                      "OID_CCO_REQUI,"+
                      "OID_PRODUCTO,"+
                      "NRO_RENGLON,"+
                      "CANT_SOLICITADA,"+
                      "OID_UM_REQ,"+
                      "CANT_COMPRADA,"+
                      "FEC_REQUERIDA,"+
                      "FEC_ENTREGA,"+
                      "DECISION_AUTORIZ,"+
                      "ANULADA,"+
                      "SOLO_COTIZAR,"+
                      "COMENTARIO,"+
                      "DESC_ADIC_SKU,"+
                      "PEND_SOL_COTIZ,"+
                      "FEC_EMISION,"+
                      "PEND_COMPRA,OID_PROVEEDOR,OID_CCO_REF,OID_CCO_DET_REF,REF_TIPO_COMPRO)"+ 
                      " values "+ 
                      "("+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_REQ_DET,pers.getOID());
    qInsert.setInt(OID_CCO_REQUI,pers.getRequisicion().getOID());
    qInsert.setInt(OID_PRODUCTO,pers.getProducto().getOID());
    qInsert.setInt(NRO_RENGLON,pers.getRenglon().intValue());
    qInsert.setDouble(CANT_SOLICITADA,pers.getCant_solicitada().doubleValue());
    qInsert.setInt(OID_UM_REQ,pers.getUnidad_medida_req().getOID());
    if (pers.getCan_comprada()!=null)
      qInsert.setDouble(CANT_COMPRADA,pers.getCan_comprada().doubleValue());
    else
      qInsert.setDouble(CANT_COMPRADA,new Double(0).doubleValue());	    	  
    qInsert.setDate(FEC_REQUERIDA,new java.sql.Date(pers.getFec_requerida().getTime()));
    if (pers.getFec_entrega()!=null) 
      qInsert.setDate(FEC_ENTREGA,new Date(pers.getFec_entrega().getTime()));
    else
      qInsert.setNull(FEC_ENTREGA,java.sql.Types.DATE);
    qInsert.setInt(DECISION_AUTORIZ,pers.getDecision_autoriz().intValue());
    qInsert.setBoolean(ANULADA,pers.isAnulada().booleanValue());
    qInsert.setBoolean(SOLO_COTIZAR,pers.isSolo_cotizar().booleanValue());
    if (pers.getComentario()!=null)
      qInsert.setString(COMENTARIO,pers.getComentario());
    else
      qInsert.setString(COMENTARIO,"");
    if (pers.getDesc_adic_sku()!=null)
      qInsert.setString(DESC_ADIC_SKU,pers.getDesc_adic_sku());
    else
      qInsert.setString(DESC_ADIC_SKU,"");
    qInsert.setBoolean(PEND_SOL_COTIZ,pers.isPend_sol_cotiz().booleanValue());
    qInsert.setDate(FEC_EMISION,new Date(pers.getFec_emision().getTime()));
    qInsert.setBoolean(PEND_COMPRA,pers.getPendCompra().booleanValue());
    if (pers.getProveedor()!=null)
    	qInsert.setInt(OID_PROVEEDOR, pers.getProveedor().getOID());
    else
    	qInsert.setNull(OID_PROVEEDOR, java.sql.Types.INTEGER);
    
    if (pers.getOidComproRef()!=null)
    	qInsert.setInt(OID_CCO_REF, pers.getOidComproRef().intValue());
    else
    	qInsert.setNull(OID_CCO_REF, java.sql.Types.INTEGER);
    
    if (pers.getOidComproRefDet()!=null)
    	qInsert.setInt(OID_CCO_DET_REF, pers.getOidComproRefDet().intValue());
    else
    	qInsert.setNull(OID_CCO_DET_REF, java.sql.Types.INTEGER);
    
    if (pers.getNickNameTipoComproRef()!=null)
    	qInsert.setString(REF_TIPO_COMPRO, pers.getNickNameTipoComproRef());
    else
    	qInsert.setNull(REF_TIPO_COMPRO, java.sql.Types.VARCHAR);
    
    
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_CCO_REQUI = 1;
    final int OID_PRODUCTO = 2;
    final int NRO_RENGLON = 3;
    final int CANT_SOLICITADA = 4;
    final int OID_UM_REQ = 5;
    final int CANT_COMPRADA = 6;
    final int FEC_REQUERIDA = 7;
    final int FEC_ENTREGA = 8;
    final int DECISION_AUTORIZ = 9;
    final int ANULADA = 10;
    final int SOLO_COTIZAR = 11;
    final int COMENTARIO = 12;
    final int DESC_ADIC_SKU = 13;
    final int PEND_SOL_COTIZ = 14;
    final int FEC_EMISION = 15;    
    final int PEND_COMPRA = 16;
    final int OID_PROVEEDOR = 17;
    final int OID_CCO_REF = 18;
    final int OID_CCO_DET_REF = 19;
    final int REF_TIPO_COMPRO = 20;
    final int OID_REQ_DET = 21;

    RequisicionDet pers = (RequisicionDet) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update cpRequiDet set "+
              "oid_cco_requi=?"+ 
              ",oid_producto=?"+ 
              ",nro_renglon=?"+ 
              ",cant_solicitada=?"+ 
              ",oid_um_req=?"+ 
              ",cant_comprada=?"+ 
              ",fec_requerida=?"+ 
              ",fec_entrega=?"+ 
              ",decision_autoriz=?"+ 
              ",anulada=?"+ 
              ",solo_cotizar=?"+ 
              ",comentario=?"+ 
              ",desc_adic_sku=?"+ 
              ",pend_sol_cotiz=?"+ 
              ",fec_emision=?"+
              ",pend_compra=?"+
              ",oid_proveedor=?"+
              ",OID_CCO_REF=?"+
              ",OID_CCO_DET_REF=?"+
              ",REF_TIPO_COMPRO=?"+
                 " where " +
                 " oid_req_det=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_REQ_DET,pers.getOID());
    qUpdate.setInt(OID_CCO_REQUI,pers.getRequisicion().getOID());
    qUpdate.setInt(OID_PRODUCTO,pers.getProducto().getOID());
    qUpdate.setInt(NRO_RENGLON,pers.getRenglon().intValue());
    qUpdate.setDouble(CANT_SOLICITADA,pers.getCant_solicitada().doubleValue());
    qUpdate.setInt(OID_UM_REQ,pers.getUnidad_medida_req().getOID());
    if (pers.getCan_comprada()!=null)
      qUpdate.setDouble(CANT_COMPRADA,pers.getCan_comprada().doubleValue());
    else
      qUpdate.setDouble(CANT_COMPRADA,new Double(0).doubleValue());	    	
    qUpdate.setDate(FEC_REQUERIDA,new java.sql.Date(pers.getFec_requerida().getTime()));
    if (pers.getFec_entrega()!=null) 
      qUpdate.setDate(FEC_ENTREGA,new java.sql.Date(pers.getFec_entrega().getTime()));
    else
      qUpdate.setNull(FEC_ENTREGA,java.sql.Types.INTEGER);
    qUpdate.setInt(DECISION_AUTORIZ,pers.getDecision_autoriz().intValue());
    qUpdate.setBoolean(ANULADA,pers.isAnulada().booleanValue());
    qUpdate.setBoolean(SOLO_COTIZAR,pers.isSolo_cotizar().booleanValue());
    if (pers.getComentario()!=null)
      qUpdate.setString(COMENTARIO,pers.getComentario());
    else
      qUpdate.setString(COMENTARIO,"");
    if (pers.getDesc_adic_sku()!=null)
      qUpdate.setString(DESC_ADIC_SKU,pers.getDesc_adic_sku());
    else
      qUpdate.setString(DESC_ADIC_SKU,"");
    qUpdate.setBoolean(PEND_SOL_COTIZ,pers.isPend_sol_cotiz().booleanValue());
    qUpdate.setDate(FEC_EMISION,new Date(pers.getFec_emision().getTime()));
    qUpdate.setBoolean(PEND_COMPRA,pers.getPendCompra().booleanValue());
    if (pers.getProveedor()!=null)
    	qUpdate.setInt(OID_PROVEEDOR, pers.getProveedor().getOID());
    else
    	qUpdate.setNull(OID_PROVEEDOR, java.sql.Types.INTEGER);
    
    if (pers.getOidComproRef()!=null)
    	qUpdate.setInt(OID_CCO_REF, pers.getOidComproRef().intValue());
    else
    	qUpdate.setNull(OID_CCO_REF, java.sql.Types.INTEGER);
    
    if (pers.getOidComproRefDet()!=null)
    	qUpdate.setInt(OID_CCO_DET_REF, pers.getOidComproRefDet().intValue());
    else
    	qUpdate.setNull(OID_CCO_DET_REF, java.sql.Types.INTEGER);
    
    if (pers.getNickNameTipoComproRef()!=null)
    	qUpdate.setString(REF_TIPO_COMPRO, pers.getNickNameTipoComproRef());
    else
    	qUpdate.setNull(REF_TIPO_COMPRO, java.sql.Types.VARCHAR);
    
    
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_REQ_DET = 1; 
    RequisicionDet pers = (RequisicionDet) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update cpRequiDet "+
                     " set anulada=1 " + 
                     " where " + 
                     " oid_req_det=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_REQ_DET, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_REQ_DET = 1; 
    RequisicionDet pers = (RequisicionDet) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update cpRequiDet "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_req_det=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_REQ_DET, pers.getOID()); 
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
      case SELECT_BY_REQUISICION_CAB: {
        ps = this.selectByRequisicionCab(aCondiciones); 
        break; 
      }
      case SELECT_BY_PEND_COMPRA: {
        ps = this.selectByPendCompra(aCondiciones); 
        break;     	  
      }
      case SELECT_BY_TODOS: {
          ps = this.selectByTodos(aCondiciones); 
          break;     	  
      }
    } 
    return ps;
  } 

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_REQ_DET = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  cpRequiDet "); 
    textSQL.append(" WHERE oid_req_det = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_REQ_DET, oid); 
    return querySelect; 
  }
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  cpRequiDet "); 
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }
  
	private PreparedStatement selectByTodos(Object aCondiciones) throws BaseException, SQLException {
		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		StringBuffer textSQL = new StringBuffer();
		textSQL.append(" select ");
		textSQL.append("  a.* ");
		textSQL.append(" from ");
		textSQL.append("  cpRequiDet a, ");
		textSQL.append("  cpRequiCab b, ");
		textSQL.append("  geComproCab c ");
		textSQL.append(" where ");
		textSQL.append("  a.oid_cco_requi = b.oid_cco_requi and b.oid_cco_requi = c.oid_cco ");
		textSQL.append("  and a.anulada = 0 and c.activo= 1");

		java.util.Date fecDesde = (java.util.Date) condiciones.get("FEC_DESDE");
		if (fecDesde != null)
			textSQL.append(" and c.emision>=?");

		java.util.Date fecHasta = (java.util.Date) condiciones.get("FEC_HASTA");
		if (fecHasta != null)
			textSQL.append(" and c.emision<=?");


		java.util.Date fecEntDesde = (java.util.Date) condiciones.get("FEC_ENT_DESDE");
		if (fecEntDesde != null)
			textSQL.append(" and a.fec_requerida>=?");

		java.util.Date fecEntHasta = (java.util.Date) condiciones.get("FEC_ENT_HASTA");
		if (fecEntHasta != null)
			textSQL.append(" and a.fec_requerida<=?");
		
		
		Proveedor proveedor = (Proveedor) condiciones.get(Proveedor.NICKNAME);
		if (proveedor != null)
			textSQL.append(" and a.oid_proveedor=" + proveedor.getOIDInteger());

		Integer nroDesde = (Integer) condiciones.get("NRO_DESDE");
		if (nroDesde != null)
			textSQL.append(" and c.nro_ext>=" + nroDesde);

		Integer nroHasta = (Integer) condiciones.get("NRO_HASTA");
		if (nroHasta != null)
			textSQL.append(" and c.nro_ext<=" + nroHasta);

		Producto producto = (Producto) condiciones.get(Producto.NICKNAME);
		if (producto != null)
			textSQL.append(" and a.oid_producto=" + producto.getOIDInteger());

		int nroParam = 0;
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());

		if (fecDesde != null) {
			++nroParam;
			querySelect.setDate(nroParam, new Date(fecDesde.getTime()));
		}

		if (fecHasta != null) {
			++nroParam;
			querySelect.setDate(nroParam, new Date(fecHasta.getTime()));
		}
		
		if (fecEntDesde != null) {
			++nroParam;
			querySelect.setDate(nroParam, new Date(fecEntDesde.getTime()));
		}
		
		if (fecEntHasta != null) {
			++nroParam;
			querySelect.setDate(nroParam, new Date(fecEntHasta.getTime()));
		}
		

		return querySelect;
	}
  
  
  private PreparedStatement selectByRequisicionCab(Object aCondiciones) throws BaseException, SQLException { 
	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM  cpRequiDet "); 
	    textSQL.append(" WHERE oid_cco_requi = ? and anulada=0");
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
	    RequisicionCab requisicionCab = (RequisicionCab) aCondiciones; 
	    querySelect.setInt(1, requisicionCab.getOID()); 
	    return querySelect; 
  }  
  
  private PreparedStatement selectByPendCompra(Object aCondiciones) throws BaseException, SQLException {
	    HashTableDatos condiciones = (HashTableDatos) aCondiciones;
	    Producto producto = (Producto) condiciones.get(Producto.NICKNAME);
	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM  cpRequiDet a , geComproCab b "); 
	    textSQL.append(" WHERE a.oid_cco_requi = b.oid_cco and b.activo=1 and a.anulada=0 and a.pend_compra=1 and a.solo_cotizar = 0 ");
	    
	    if (producto!=null)
	    	textSQL.append(" and a.oid_producto="+producto.getOIDInteger());
	    
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
	    return querySelect; 
}  
  
  
  

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_req_det oid, codigo,  descripcion ,activo ");
    textSQL.append(" from cpRequiDet");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  }
  
  public static List getRequisicionesDet(RequisicionCab requisicionCab,
			ISesion aSesion) throws BaseException {
		return (List) ObjetoLogico.getObjects(RequisicionDet.NICKNAME,
				DBRequisicionDet.SELECT_BY_REQUISICION_CAB, requisicionCab,
				new ListObserver(), aSesion);
  }
  
  public static List getRequisicionesPendCompra(Producto producto,
			ISesion aSesion) throws BaseException {
	  HashTableDatos condiciones = new HashTableDatos();
	  if (producto!=null)
		  condiciones.put(Producto.NICKNAME, producto);
		return (List) ObjetoLogico.getObjects(RequisicionDet.NICKNAME,
				DBRequisicionDet.SELECT_BY_PEND_COMPRA, condiciones,
				new ListObserver(), aSesion);
  }
  
	public static int getMaxNroRenglon(ISesion aSesion, RequisicionCab requisicion)
	throws BaseException {

	try {

		StringBuffer sqlUltNroItem = new StringBuffer(
				" select max(nro_renglon) from cpRequiDet where oid_cco_requi="
				+ requisicion.getOIDInteger().toString());
		PreparedStatement querySelect = aSesion.getConexionBD().prepareStatement(sqlUltNroItem.toString());
		ResultSet rs = querySelect.executeQuery();
		int ultimoNro = 0;
		if (rs.next())
			ultimoNro = rs.getInt(1);
		rs.close();
		querySelect.close();

	return ultimoNro;
	
	} catch (Exception e) {
		throw new BaseException(null, e.getMessage());
	}
	}
	
	public static List getAllDetalles(Proveedor proveedor, 
			Integer nroDesde, 
			Integer nroHasta, 
			java.util.Date fecDesde,
			java.util.Date fecHasta,
			java.util.Date fecEntDesde,
			java.util.Date fecEntHasta, 
			Producto producto, ISesion aSesion) throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();

		if (proveedor != null)
			condiciones.put(Proveedor.NICKNAME, proveedor);

		if (nroDesde != null)
			condiciones.put("NRO_DESDE", nroDesde);

		if (nroHasta != null)
			condiciones.put("NRO_HASTA", nroHasta);

		if (fecDesde != null)
			condiciones.put("FEC_DESDE", fecDesde);

		if (fecHasta != null)
			condiciones.put("FEC_HASTA", fecHasta);
		
		if (fecEntDesde != null)
			condiciones.put("FEC_ENT_DESDE", fecEntDesde);

		if (fecEntHasta != null)
			condiciones.put("FEC_ENT_HASTA", fecEntHasta);
		

		if (producto != null)
			condiciones.put(Producto.NICKNAME, producto);

		return (List) ObjetoLogico.getObjects(RequisicionDet.NICKNAME, DBRequisicionDet.SELECT_BY_TODOS, condiciones,
				new ListObserver(), aSesion);
	}
	
  
  
} 
