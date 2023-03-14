package com.srn.erp.stock.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.compras.bm.Proveedor;
import com.srn.erp.general.bm.ClasificadorEntidad;
import com.srn.erp.general.bm.ValorClasificadorEntidad;
import com.srn.erp.stock.bm.Producto;
import com.srn.erp.stock.bm.ProductoProveedor;
import com.srn.erp.stock.bm.UnidadMedida;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.ObjetoObservado;

public class DBProductoProveedor extends DBObjetoPersistente {

  public static final String OID_PROD_PROV = "oid_prod_prov";
  public static final String OID_PRODUCTO = "oid_producto";
  public static final String OID_PROVEEDOR = "oid_proveedor";
  public static final String COD_PROD_PROV = "cod_prod_prov";
  public static final String OID_UM_CPRA = "oid_um_cpra";
  public static final String LOTE_MINIMO = "lote_minimo";
  public static final String MULTIPLO = "multiplo";
  public static final String LT_ENT_DIAS = "lt_ent_dias";
  public static final String PRIORIDAD = "prioridad";
  public static final String OID_CLASIF = "oid_clasif";
  public static final String OID_VAL_CLASIF = "oid_val_clasif";
  public static final String OID_TIPO_ACUERDO = "oid_tipo_acuerdo";

  public static final int SELECT_BY_PRODUCTO = 100;
  public static final int SELECT_BY_PROV_COD_PROD_PROV_PROD_UM = 101;
  public static final int SELECT_BY_PRODUCTO_PROVEEDOR = 102;
  public static final int SELECT_BY_VAL_CLASIF = 103;
  public static final int SELECT_BY_PROD_SUG_PROV = 104;

  public DBProductoProveedor() {
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

    final int OID_PROD_PROV = 1;
    final int OID_PRODUCTO = 2;
    final int OID_PROVEEDOR = 3;
    final int COD_PROD_PROV = 4;
    final int OID_UM_CPRA = 5;
    final int LOTE_MINIMO = 6;
    final int MULTIPLO = 7;
    final int LT_ENT_DIAS = 8;
    final int PRIORIDAD = 9;
    final int OID_CLASIF = 10;
    final int OID_VAL_CLASIF = 11;
    final int OID_TIPO_ACUERDO = 12;

    ProductoProveedor pers = (ProductoProveedor) objetoPersistente;

    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into stProdProveedor "+
                     " ( "+
                      "OID_PROD_PROV,"+
                      "OID_PRODUCTO,"+
                      "OID_PROVEEDOR,"+
                      "COD_PROD_PROV,"+
                      "OID_UM_CPRA,"+
                      "LOTE_MINIMO,"+
                      "MULTIPLO,"+
                      "LT_ENT_DIAS,"+
                      "PRIORIDAD,"+
                      "OID_CLASIF,"+
                      "OID_VAL_CLASIF,OID_TIPO_ACUERDO"+
                      ")"+
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
    qInsert.setInt(OID_PROD_PROV,pers.getOID());
    if (pers.getProducto()!=null)
    	qInsert.setInt(OID_PRODUCTO,pers.getProducto().getOID());
    else
    	qInsert.setNull(OID_PRODUCTO,java.sql.Types.INTEGER);
    qInsert.setInt(OID_PROVEEDOR,pers.getProveedor().getOID());
    if (pers.getCod_prod_prov()!=null)
    	qInsert.setString(COD_PROD_PROV,pers.getCod_prod_prov());
    else
    	qInsert.setNull(COD_PROD_PROV,java.sql.Types.VARCHAR);
    if (pers.getUmcpra()!=null)
    	qInsert.setInt(OID_UM_CPRA,pers.getUmcpra().getOID());
    else
    	qInsert.setNull(OID_UM_CPRA, java.sql.Types.INTEGER);
    if (pers.getLote_minimo()!=null)
    	qInsert.setDouble(LOTE_MINIMO,pers.getLote_minimo().doubleValue());
    else
    	qInsert.setNull(LOTE_MINIMO,java.sql.Types.DOUBLE);
    if (pers.getMultiplo()!=null)
    	qInsert.setDouble(MULTIPLO,pers.getMultiplo().doubleValue());
    else
    	qInsert.setNull(MULTIPLO,java.sql.Types.DOUBLE);
    if (pers.getLt_ent_dias()!=null)
    	qInsert.setInt(LT_ENT_DIAS,pers.getLt_ent_dias().intValue());
    else
    	qInsert.setNull(LT_ENT_DIAS,java.sql.Types.INTEGER);
    if (pers.getPrioridadCompra()!=null)
    	qInsert.setInt(PRIORIDAD, pers.getPrioridadCompra().intValue());
    else
    	qInsert.setInt(PRIORIDAD, 0);
    
    if (pers.getClasifProdGeneral()!=null) 
    	qInsert.setInt(OID_CLASIF, pers.getClasifProdGeneral().getOID());
    else
    	qInsert.setNull(OID_CLASIF, java.sql.Types.INTEGER);
    
    if (pers.getValClasifProdGeneral()!=null) 
    	qInsert.setInt(OID_VAL_CLASIF, pers.getValClasifProdGeneral().getOID());
    else
    	qInsert.setNull(OID_VAL_CLASIF, java.sql.Types.INTEGER);
    
    if (pers.getTipoAcuerdo()!=null) 
    	qInsert.setInt(OID_TIPO_ACUERDO, pers.getTipoAcuerdo().getOID());
    else
    	qInsert.setNull(OID_TIPO_ACUERDO, java.sql.Types.INTEGER);
    
    
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

    final int OID_PRODUCTO = 1;
    final int OID_PROVEEDOR = 2;
    final int COD_PROD_PROV = 3;
    final int OID_UM_CPRA = 4;
    final int LOTE_MINIMO = 5;
    final int MULTIPLO = 6;
    final int LT_ENT_DIAS = 7;
    final int PRIORIDAD = 8;
    final int OID_CLASIF = 9;
    final int OID_VAL_CLASIF = 10;
    final int OID_TIPO_ACUERDO = 11;
    final int OID_PROD_PROV = 12;

    ProductoProveedor pers = (ProductoProveedor) objetoPersistente;

    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update stProdProveedor set "+
              "oid_producto=?"+
              ",oid_proveedor=?"+
              ",cod_prod_prov=?"+
              ",oid_um_cpra=?"+
              ",lote_minimo=?"+
              ",multiplo=?"+
              ",lt_ent_dias=?"+
              ",prioridad=?"+
              ",oid_clasif=?"+
              ",oid_val_clasif=?"+
              ",oid_tipo_acuerdo=?"+
                 " where " +
                 " oid_prod_prov=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_PROD_PROV,pers.getOID());
    if (pers.getProducto()!=null)
    	qUpdate.setInt(OID_PRODUCTO,pers.getProducto().getOID());
    else
    	qUpdate.setNull(OID_PRODUCTO,java.sql.Types.INTEGER);
    qUpdate.setInt(OID_PROVEEDOR,pers.getProveedor().getOID());
    if (pers.getCod_prod_prov()!=null)
    	qUpdate.setString(COD_PROD_PROV,pers.getCod_prod_prov());
    else
    	qUpdate.setNull(COD_PROD_PROV,java.sql.Types.VARCHAR);
    if (pers.getUmcpra()!=null)
    	qUpdate.setInt(OID_UM_CPRA,pers.getUmcpra().getOID());
    else
    	qUpdate.setNull(OID_UM_CPRA,java.sql.Types.INTEGER);
    if (pers.getLote_minimo()!=null)
    	qUpdate.setDouble(LOTE_MINIMO,pers.getLote_minimo().doubleValue());
    else
    	qUpdate.setNull(LOTE_MINIMO,java.sql.Types.DOUBLE);
    if (pers.getMultiplo()!=null)
    	qUpdate.setDouble(MULTIPLO,pers.getMultiplo().doubleValue());
    else
    	qUpdate.setNull(MULTIPLO,java.sql.Types.DOUBLE);
    if (pers.getLt_ent_dias()!=null)
    	qUpdate.setInt(LT_ENT_DIAS,pers.getLt_ent_dias().intValue());
    else
    	qUpdate.setNull(LT_ENT_DIAS,java.sql.Types.INTEGER);
    if (pers.getPrioridadCompra()!=null)
    	qUpdate.setInt(PRIORIDAD, pers.getPrioridadCompra().intValue());
    else
    	qUpdate.setInt(PRIORIDAD, 0);
    
    if (pers.getClasifProdGeneral()!=null) 
    	qUpdate.setInt(OID_CLASIF, pers.getClasifProdGeneral().getOID());
    else
    	qUpdate.setNull(OID_CLASIF, java.sql.Types.INTEGER);
    
    if (pers.getValClasifProdGeneral()!=null) 
    	qUpdate.setInt(OID_VAL_CLASIF, pers.getValClasifProdGeneral().getOID());
    else
    	qUpdate.setNull(OID_VAL_CLASIF, java.sql.Types.INTEGER);

    if (pers.getTipoAcuerdo()!=null) 
    	qUpdate.setInt(OID_TIPO_ACUERDO, pers.getTipoAcuerdo().getOID());
    else
    	qUpdate.setNull(OID_TIPO_ACUERDO, java.sql.Types.INTEGER);
    
    
    qUpdate.executeUpdate();
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    final int OID_PROD_PROV = 1;
    ProductoProveedor pers = (ProductoProveedor) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("delete from stProdProveedor "+
                     " where " +
                     " oid_prod_prov=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_PROD_PROV, pers.getOID());
    qUpdate.executeUpdate();
    qUpdate.close();
  }

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    final int OID_PROD_PROV = 1;
    ProductoProveedor pers = (ProductoProveedor) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("update stProdProveedor "+
                     " set activo=1 " +
                     " where " +
                     " oid_prod_prov=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_PROD_PROV, pers.getOID());
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
      case SELECT_BY_PROV_COD_PROD_PROV_PROD_UM: {
          ps = this.selectByProvCodProdUMProd(aCondiciones);
          break;
      }
      case SELECT_BY_PRODUCTO_PROVEEDOR: {
          ps = this.selectByProductoProveedor(aCondiciones);
          break;
      }
      case SELECT_BY_VAL_CLASIF: {
          ps = this.selectByValClasif(aCondiciones);
          break;
      }
      case SELECT_BY_PROD_SUG_PROV: {
          ps = this.selectByProductoSugProveedor(aCondiciones);
          break;
      }
      
    }
    return ps;
  }

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

    final int OID_PROD_PROV = 1;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  stProdProveedor ");
    textSQL.append(" WHERE oid_prod_prov = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    int oid = ( (Integer) aCondiciones).intValue();
    querySelect.setInt(OID_PROD_PROV, oid);
    return querySelect;
  }
  
  private PreparedStatement selectByProductoSugProveedor(Object aCondiciones) throws BaseException, SQLException {
	    
		 HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		 Producto producto = (Producto) condiciones.get(Producto.NICKNAME);
	   
		 StringBuffer textSQL = new StringBuffer();
		 textSQL.append("SELECT * FROM  stProdProveedor ");
		 textSQL.append(" WHERE  oid_producto = "+producto.getOIDInteger());
		 textSQL.append(" and prioridad = (select min(prioridad) from stProdProveedor where oid_producto=?) ");
		 PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		 querySelect.setInt(1,producto.getOID());
		 return querySelect;	  
 }
  
  private PreparedStatement selectByProductoProveedor(Object aCondiciones) throws BaseException, SQLException {
	 StringBuffer textSQL = new StringBuffer();
	 textSQL.append("SELECT * FROM  stProdProveedor ");
	 textSQL.append(" WHERE  oid_producto = ? and oid_proveedor = ? ");
	 HashTableDatos condiciones = (HashTableDatos) aCondiciones;
	 Producto producto = (Producto) condiciones.get(Producto.NICKNAME);
	 Proveedor proveedor = (Proveedor) condiciones.get(Proveedor.NICKNAME);
	 PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
	 querySelect.setInt(1,producto.getOID());
	 querySelect.setInt(2,proveedor.getOID());
	 return querySelect;	  
  }
  
  private PreparedStatement selectByValClasif(Object aCondiciones) throws BaseException, SQLException {
	 StringBuffer textSQL = new StringBuffer();
	 textSQL.append("SELECT * FROM  stProdProveedor ");
	 textSQL.append(" WHERE  oid_clasif = ? and oid_val_clasif = ?  ");
	 HashTableDatos condiciones = (HashTableDatos) aCondiciones;
	 ClasificadorEntidad clasificador = (ClasificadorEntidad) condiciones.get(ClasificadorEntidad.NICKNAME);
	 ValorClasificadorEntidad valClasifEnt = (ValorClasificadorEntidad) condiciones.get(ValorClasificadorEntidad.NICKNAME);
	 PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
	 querySelect.setInt(1,clasificador.getOID());
	 querySelect.setInt(2,valClasifEnt.getOID());
	 return querySelect;	  
  }
  
  
  private PreparedStatement selectByProvTipoAcuerdoProdGral(Object aCondiciones) throws BaseException, SQLException {
	    StringBuffer textSQL = new StringBuffer();
	    textSQL.append("SELECT * FROM  stProdProveedor ");
	    textSQL.append(" WHERE  oid_tipo_acuerdo = ? and oid_proveedor = ? and cod_prod_prov=? and oid_um_cpra = ? ");
	    HashTableDatos condiciones = (HashTableDatos) aCondiciones;
	    Producto producto = (Producto) condiciones.get(Producto.NICKNAME);
	    Proveedor proveedor = (Proveedor) condiciones.get(Proveedor.NICKNAME);
	    String codProdProv = (String) condiciones.get("COD_PROD_PROV");
	    UnidadMedida umCpra = (UnidadMedida) condiciones.get(UnidadMedida.NICKNAME);
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
	    querySelect.setInt(1,producto.getOID());
	    querySelect.setInt(2,proveedor.getOID());
	    querySelect.setString(3,codProdProv);
	    querySelect.setInt(4,umCpra.getOID());
	    return querySelect;	  
}
  
  
  
  private PreparedStatement selectByProvCodProdUMProd(Object aCondiciones) throws BaseException, SQLException {
	    StringBuffer textSQL = new StringBuffer();
	    textSQL.append("SELECT * FROM  stProdProveedor ");
	    textSQL.append(" WHERE  oid_producto = ? and oid_proveedor = ? and cod_prod_prov=? and oid_um_cpra = ? ");
	    HashTableDatos condiciones = (HashTableDatos) aCondiciones;
	    Producto producto = (Producto) condiciones.get(Producto.NICKNAME);
	    Proveedor proveedor = (Proveedor) condiciones.get(Proveedor.NICKNAME);
	    String codProdProv = (String) condiciones.get("COD_PROD_PROV");
	    UnidadMedida umCpra = (UnidadMedida) condiciones.get(UnidadMedida.NICKNAME);
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
	    querySelect.setInt(1,producto.getOID());
	    querySelect.setInt(2,proveedor.getOID());
	    querySelect.setString(3,codProdProv);
	    querySelect.setInt(4,umCpra.getOID());
	    return querySelect;	  
  }
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

    final int CODIGO = 1;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  stProdProveedor ");
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    String codigo = (String) aCondiciones;
    querySelect.setString(CODIGO, codigo);
    return querySelect;
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_prod_prov oid, codigo,  descripcion ,activo ");
    textSQL.append(" from stProdProveedor");

    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    return querySelect;
  }

  private PreparedStatement selectByProducto(Object aCondiciones) throws BaseException, SQLException {

    final int CODIGO = 1;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  stProdProveedor ");
    textSQL.append(" WHERE  oid_producto = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    Producto producto = (Producto) aCondiciones;
    querySelect.setInt(1, producto.getOID());
    return querySelect;
  }

  public static List getProductosProveedor(Producto producto,
                                           ISesion aSesion) throws BaseException {
    return (List) ObjetoLogico.getObjects(ProductoProveedor.NICKNAME,
                                          DBProductoProveedor.SELECT_BY_PRODUCTO,
                                          producto,
                                          new ListObserver(),
                                          aSesion);
  }
  
  public static ProductoProveedor getProductoProveedor(Producto producto,
		  											   Proveedor proveedor,
		  											   String codProdProv,
		  											   UnidadMedida uniMed,
		  											   ISesion aSesion)
          throws BaseException {
	  HashTableDatos condiciones = new HashTableDatos();
	  condiciones.put(Producto.NICKNAME,producto);
	  condiciones.put(Proveedor.NICKNAME,proveedor);
	  condiciones.put(UnidadMedida.NICKNAME,uniMed);
	  condiciones.put("COD_PROD_PROV",codProdProv);
	  return (ProductoProveedor) ObjetoLogico.getObjects(ProductoProveedor.NICKNAME,
			  DBProductoProveedor.SELECT_BY_PROV_COD_PROD_PROV_PROD_UM,
			  condiciones,
			  new ObjetoObservado(),
			  aSesion);
  }
  

  public static List getProductosProveedor(Producto producto,
		  Proveedor proveedor,
          ISesion aSesion) throws BaseException {
	  HashTableDatos condiciones = new HashTableDatos();
	  condiciones.put(Producto.NICKNAME,producto);
	  condiciones.put(Proveedor.NICKNAME,proveedor);
	  return (List) ObjetoLogico.getObjects(ProductoProveedor.NICKNAME,
             DBProductoProveedor.SELECT_BY_PRODUCTO_PROVEEDOR,
             condiciones,
             new ListObserver(),
             aSesion);
  }
  
  public static List getProductosProveedor(
		  ClasificadorEntidad clasificadorEntidad,
		  ValorClasificadorEntidad valClasifEnt,
          ISesion aSesion) throws BaseException {
	  HashTableDatos condiciones = new HashTableDatos();
	  condiciones.put(ClasificadorEntidad.NICKNAME,clasificadorEntidad);
	  condiciones.put(ValorClasificadorEntidad.NICKNAME,valClasifEnt);
	  return (List) ObjetoLogico.getObjects(ProductoProveedor.NICKNAME,
             DBProductoProveedor.SELECT_BY_VAL_CLASIF,
             condiciones,
             new ListObserver(),
             aSesion);
  }
  
  public static ProductoProveedor getProveedorMenorPrioridad(Producto producto,
			    ISesion aSesion)
  throws BaseException {
	  HashTableDatos condiciones = new HashTableDatos();
	  condiciones.put(Producto.NICKNAME,producto);
	  return (ProductoProveedor) ObjetoLogico.getObjects(ProductoProveedor.NICKNAME,
			  DBProductoProveedor.SELECT_BY_PROD_SUG_PROV,
			  condiciones,
			  new ObjetoObservado(),
			  aSesion);
  }
  
  


}
