package com.srn.erp.ctasAPagar.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.compras.bm.OrdenDeCompraDet;
import com.srn.erp.compras.bm.Proveedor;
import com.srn.erp.ctasAPagar.bm.ComproProvInfRecOC;
import com.srn.erp.ctasAPagar.bm.ComproProveedorBase;
import com.srn.erp.general.bm.ClasificadorEntidad;
import com.srn.erp.general.bm.ValorClasificadorEntidad;
import com.srn.erp.stock.bm.Producto;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;

public class DBComproProvInfRecOC extends DBObjetoPersistente {

  public static final String OID_DET_IR_OC = "oid_det_ir_oc";
  public static final String OID_CCO = "oid_cco";
  public static final String OID_PRODUCTO = "oid_producto";
  public static final String OID_OC_DET = "oid_oc_det";
  public static final String OID_INF_REC_DET = "oid_inf_rec_det";
  public static final String CANT_FACTURADA = "cant_facturada";
  public static final String PRECIO_FACTURA = "precio_factura";
  public static final String PRECIO_OC = "precio_oc";
  public static final String OID_MON_OC = "oid_mon_oc";
  public static final String IMPO_DET_FACTURA = "impo_det_factura";
  public static final String ACTIVO = "activo";
  
  public static final int SELECT_BY_COMPRO_PROV = 100;
  public static final int SELECT_BY_PROV_PROD_GRAL_MAS_CERC_A_FECHA = 102;
  public static final int SELECT_BY_PRODUCTO_OC_DET_ACTIVA = 103;

  public DBComproProvInfRecOC() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_DET_IR_OC = 1;
    final int OID_CCO = 2;
    final int OID_PRODUCTO = 3;
    final int OID_OC_DET = 4;
    final int OID_INF_REC_DET = 5;
    final int CANT_FACTURADA = 6;
    final int PRECIO_FACTURA = 7;
    final int PRECIO_OC = 8;
    final int OID_MON_OC = 9;
    final int IMPO_DET_FACTURA = 10;
    final int ACTIVO = 11;
    final int CANT_VALORIZADA = 12;

    ComproProvInfRecOC pers = (ComproProvInfRecOC) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into cpComproProvIROC "+
                     " ( "+
                      "OID_DET_IR_OC,"+
                      "OID_CCO,"+
                      "OID_PRODUCTO,"+
                      "OID_OC_DET,"+
                      "OID_INF_REC_DET,"+
                      "CANT_FACTURADA,"+
                      "PRECIO_FACTURA,"+
                      "PRECIO_OC,"+
                      "OID_MON_OC,"+
                      "IMPO_DET_FACTURA,"+
                      "ACTIVO,CANT_VALORIZADA)"+ 
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
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_DET_IR_OC,pers.getOID());
    qInsert.setInt(OID_CCO,pers.getComprobante_proveedorBase().getOID());
    qInsert.setInt(OID_PRODUCTO,pers.getProducto().getOID());
    if (pers.getOrdenDeCompraDet()!=null) 
      qInsert.setInt(OID_OC_DET,pers.getOrdenDeCompraDet().getOID());
    else
      qInsert.setNull(OID_OC_DET,java.sql.Types.INTEGER);
    if (pers.getInforme_rec_det()!=null) 
      qInsert.setInt(OID_INF_REC_DET,pers.getInforme_rec_det().getOID());
    else
      qInsert.setNull(OID_INF_REC_DET,java.sql.Types.INTEGER);
    qInsert.setDouble(CANT_FACTURADA,pers.getCant_facturada().doubleValue());
    qInsert.setDouble(PRECIO_FACTURA,pers.getPrecio_factura().doubleValue());
    qInsert.setDouble(PRECIO_OC,pers.getPrecio_oc().doubleValue());
    if (pers.getMoneda_oc()!=null) 
      qInsert.setInt(OID_MON_OC,pers.getMoneda_oc().getOID());
    else
      qInsert.setNull(OID_MON_OC,java.sql.Types.INTEGER);
    qInsert.setDouble(IMPO_DET_FACTURA,pers.getImpo_det_factura().doubleValue());
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    if (pers.getCantValorizada()!=null)
    	qInsert.setDouble(CANT_VALORIZADA, pers.getCantValorizada().doubleValue());
    else
    	qInsert.setDouble(CANT_VALORIZADA, 0);
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_CCO = 1;
    final int OID_PRODUCTO = 2;
    final int OID_OC_DET = 3;
    final int OID_INF_REC_DET = 4;
    final int CANT_FACTURADA = 5;
    final int PRECIO_FACTURA = 6;
    final int PRECIO_OC = 7;
    final int OID_MON_OC = 8;
    final int IMPO_DET_FACTURA = 9;
    final int ACTIVO = 10;
    final int CANT_VALORIZADA = 11;
    final int OID_DET_IR_OC = 12;

    ComproProvInfRecOC pers = (ComproProvInfRecOC) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update cpComproProvIROC set "+
              "oid_cco=?"+ 
              ",oid_producto=?"+ 
              ",oid_oc_det=?"+ 
              ",oid_inf_rec_det=?"+ 
              ",cant_facturada=?"+ 
              ",precio_factura=?"+ 
              ",precio_oc=?"+ 
              ",oid_mon_oc=?"+ 
              ",impo_det_factura=?"+ 
              ",activo=?,cant_valorizada=? "+ 
                 " where " +
                 " oid_det_ir_oc=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_DET_IR_OC,pers.getOID());
    qUpdate.setInt(OID_CCO,pers.getComprobante_proveedorBase().getOID());
    qUpdate.setInt(OID_PRODUCTO,pers.getProducto().getOID());
    if (pers.getOrdenDeCompraDet()!=null) 
      qUpdate.setInt(OID_OC_DET,pers.getOrdenDeCompraDet().getOID());
    else
      qUpdate.setNull(OID_OC_DET,java.sql.Types.INTEGER);
    if (pers.getInforme_rec_det()!=null) 
      qUpdate.setInt(OID_INF_REC_DET,pers.getInforme_rec_det().getOID());
    else
      qUpdate.setNull(OID_INF_REC_DET,java.sql.Types.INTEGER);
    qUpdate.setDouble(CANT_FACTURADA,pers.getCant_facturada().doubleValue());
    qUpdate.setDouble(PRECIO_FACTURA,pers.getPrecio_factura().doubleValue());
    qUpdate.setDouble(PRECIO_OC,pers.getPrecio_oc().doubleValue());
    if (pers.getMoneda_oc()!=null) 
      qUpdate.setInt(OID_MON_OC,pers.getMoneda_oc().getOID());
    else
      qUpdate.setNull(OID_MON_OC,java.sql.Types.INTEGER);
    qUpdate.setDouble(IMPO_DET_FACTURA,pers.getImpo_det_factura().doubleValue());
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    if (pers.getCantValorizada()!=null)
    	qUpdate.setDouble(CANT_VALORIZADA, pers.getCantValorizada().doubleValue());
    else
    	qUpdate.setDouble(CANT_VALORIZADA, 0);
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_DET_IR_OC = 1; 
    ComproProvInfRecOC pers = (ComproProvInfRecOC) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update cpComproProvIROC "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_det_ir_oc=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_DET_IR_OC, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_DET_IR_OC = 1; 
    ComproProvInfRecOC pers = (ComproProvInfRecOC) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update cpComproProvIROC "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_det_ir_oc=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_DET_IR_OC, pers.getOID()); 
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
      case SELECT_BY_PROV_PROD_GRAL_MAS_CERC_A_FECHA: {
          ps = this.selectByProvProdGralMasCercaAFecha(aCondiciones); 
          break; 
      }
      case IDBObjetoPersistente.SELECT_ALL_HELP: { 
        ps = this.selectAllHelp(aCondiciones); 
        break; 
      } 
      case SELECT_BY_COMPRO_PROV: {
    	ps = this.selectByComproProv(aCondiciones); 
        break;    	  
      }
      case SELECT_BY_PRODUCTO_OC_DET_ACTIVA: {
      	ps = this.selectByProductoOCDetActiva(aCondiciones); 
        break;    	  
      }
    } 
    return ps;
  } 

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_DET_IR_OC = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  cpComproProvIROC "); 
    textSQL.append(" WHERE oid_det_ir_oc = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_DET_IR_OC, oid); 
    return querySelect; 
  }
  
  private PreparedStatement selectByProductoOCDetActiva(Object aCondiciones) throws BaseException, SQLException { 
	    
	    HashTableDatos condiciones = (HashTableDatos) aCondiciones;
	    OrdenDeCompraDet ocDet = (OrdenDeCompraDet) condiciones.get(OrdenDeCompraDet.NICKNAME);
	    
	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT a.* FROM  ");
	    textSQL.append(" cpComproProvIROC a , geComproCab b  ");
	    
	    textSQL.append(" WHERE a.oid_cco = b.oid_cco and a.activo = 1 and b.activo = 1 and b.activo=1 ");
	    textSQL.append(" and a.oid_oc_det = ? ");
		
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
	    querySelect.setInt(1, ocDet.getOIDInteger());
	    return querySelect; 
	    
  }
  
  
  
  private PreparedStatement selectByProvProdGralMasCercaAFecha(Object aCondiciones) throws BaseException, SQLException { 
	    
	    HashTableDatos condiciones = (HashTableDatos) aCondiciones;
	    Proveedor proveedor = (Proveedor) condiciones.get(Proveedor.NICKNAME);
	    ValorClasificadorEntidad valClasifEnt = (ValorClasificadorEntidad) condiciones.get(ValorClasificadorEntidad.NICKNAME);
	    java.util.Date fecha = (java.util.Date) condiciones.get("FECHA");
	    
	    
  	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT a.* FROM  ");
	    textSQL.append(" cpComproProvIROC a , geComproCab b , stProducto c ");
	    
	    if (proveedor!=null)
	    	textSQL.append(", cpComproProv d ");
	    
	    textSQL.append(" WHERE a.oid_cco = b.oid_cco and a.activo = 1 and b.activo = 1 ");
	    textSQL.append(" and a.oid_producto = c.oid_producto and b.emision<=? ");
	    
	    if (proveedor!=null) 
	    	textSQL.append(" b.oid_cco = d.oid_cco and d.oid_proveedor = "+proveedor.getOIDInteger());
	    
		ClasificadorEntidad clasif = Producto.getClasifProductoGeneral(this.getSesion());
		textSQL.append("  and c."+clasif.getCampoFisico()+" = "+valClasifEnt.getOIDInteger());
		textSQL.append("  and b.emision = (");
		
	    textSQL.append("SELECT max(b.emision) FROM  ");
	    textSQL.append(" cpComproProvIROC a , geComproCab b , stProducto c ");
	    
	    if (proveedor!=null)
	    	textSQL.append(", cpComproProv d ");
	    
	    textSQL.append(" WHERE a.oid_cco = b.oid_cco and a.activo = 1 and b.activo = 1 ");
	    textSQL.append(" and a.oid_producto = c.oid_producto and b.emision<=? ");
	    
	    if (proveedor!=null) 
	    	textSQL.append(" b.oid_cco = d.oid_cco and d.oid_proveedor = "+proveedor.getOIDInteger());
	    
		textSQL.append("  and c."+clasif.getCampoFisico()+" = "+valClasifEnt.getOIDInteger());
		
		
		textSQL.append("  ) order by a.oid_det_ir_oc asc");
		
		
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
	    querySelect.setDate(1, new java.sql.Date(fecha.getTime())); 
	    querySelect.setDate(2, new java.sql.Date(fecha.getTime()));
	    return querySelect; 
  }
  
  
  private PreparedStatement selectByComproProv(Object aCondiciones) throws BaseException, SQLException { 
	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM  cpComproProvIROC "); 
	    textSQL.append(" WHERE oid_cco = ? ");
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
	    ComproProveedorBase comproProveedorBase = (ComproProveedorBase) aCondiciones; 
	    querySelect.setInt(1, comproProveedorBase.getOID()); 
	    return querySelect; 
  }

  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  cpComproProvIROC "); 
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_det_ir_oc oid, codigo,  descripcion ,activo ");
    textSQL.append(" from cpComproProvIROC");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  } 
  
  public static List getComproProvInfRecOCDet(ComproProveedorBase comproProveedorBase,
          ISesion aSesion) throws BaseException {
    return (List) ObjetoLogico.getObjects(ComproProvInfRecOC.NICKNAME,
             DBComproProvInfRecOC.SELECT_BY_COMPRO_PROV,
             comproProveedorBase,
             new ListObserver(),
             aSesion);
  }
  
  public static List getComproProvProdGralMasCercaAFecha(Proveedor proveedor,
		  java.util.Date fecha,
		  ValorClasificadorEntidad valorClasif,
          ISesion aSesion) throws BaseException {
	HashTableDatos condiciones = new HashTableDatos();
	if (proveedor!=null)
		condiciones.put(Proveedor.NICKNAME, proveedor);
	condiciones.put(ValorClasificadorEntidad.NICKNAME, valorClasif);
	condiciones.put("FECHA", fecha);
    return (List) ObjetoLogico.getObjects(ComproProvInfRecOC.NICKNAME,
             DBComproProvInfRecOC.SELECT_BY_PROV_PROD_GRAL_MAS_CERC_A_FECHA,
             condiciones,
             new ListObserver(),
             aSesion);
  }
  
  public static List getComproProvProductoOCDetActivo(
		  OrdenDeCompraDet ocDet,
          ISesion aSesion) throws BaseException {
	HashTableDatos condiciones = new HashTableDatos();
	condiciones.put(OrdenDeCompraDet.NICKNAME, ocDet);
    return (List) ObjetoLogico.getObjects(ComproProvInfRecOC.NICKNAME,
             DBComproProvInfRecOC.SELECT_BY_PRODUCTO_OC_DET_ACTIVA,
             condiciones,
             new ListObserver(),
             aSesion);
  }
  
    
  
} 
