package com.srn.erp.stock.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.general.bm.ValorClasificadorEntidad;
import com.srn.erp.stock.bm.AgrupadorDeposito;
import com.srn.erp.stock.bm.Producto;
import com.srn.erp.stock.bm.SeguimientoStock;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.ObjetoObservado;

public class DBSeguimientoStock extends DBObjetoPersistente {

  public static final String OID_SEGUI_STOCK = "oid_segui_stock";
  public static final String OID_PRODUCTO = "oid_producto";
  public static final String OID_AGRUPADOR_DEPO = "oid_agrupador_depo";
  public static final String PUNTO_PEDIDO = "punto_pedido";
  public static final String STOCK_DESEADO = "stock_deseado";
  public static final String OID_VAL_CLASIF_ENT = "oid_val_clasif_ent";
  
  
  public static final int SELECT_BY_PRODUCTO = 100;
  public static final int SELECT_BY_VAL_CLASIF = 101;
  public static final int SELECT_PROD_AGRUP = 102;

  public DBSeguimientoStock() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_SEGUI_STOCK = 1;
    final int OID_PRODUCTO = 2;
    final int OID_AGRUPADOR_DEPO = 3;
    final int PUNTO_PEDIDO = 4;
    final int STOCK_DESEADO = 5;
    final int OID_VAL_CLASIF_ENT = 6;

    SeguimientoStock pers = (SeguimientoStock) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into stSeguiStock "+
                     " ( "+
                      "OID_SEGUI_STOCK,"+
                      "OID_PRODUCTO,"+
                      "OID_AGRUPADOR_DEPO,"+
                      "PUNTO_PEDIDO,"+
                      "STOCK_DESEADO,OID_VAL_CLASIF_ENT)"+ 
                      " values "+ 
                      "("+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_SEGUI_STOCK,pers.getOID());
    if (pers.getProducto()!=null)
    	qInsert.setInt(OID_PRODUCTO,pers.getProducto().getOID());
    else
    	qInsert.setInt(OID_PRODUCTO,new Integer(0));
    qInsert.setInt(OID_AGRUPADOR_DEPO,pers.getAgrupador_deposito().getOID());
    qInsert.setDouble(PUNTO_PEDIDO,pers.getPunto_pedido().doubleValue());
    qInsert.setDouble(STOCK_DESEADO,pers.getStock_deseado().doubleValue());
    if (pers.getValClasifEnt()!=null)
    	qInsert.setInt(OID_VAL_CLASIF_ENT,pers.getValClasifEnt().getOID());
    else
    	qInsert.setInt(OID_VAL_CLASIF_ENT,new Integer(0));
    
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_PRODUCTO = 1;
    final int OID_AGRUPADOR_DEPO = 2;
    final int PUNTO_PEDIDO = 3;
    final int STOCK_DESEADO = 4;
    final int OID_VAL_CLASIF_ENT = 5;
    final int OID_SEGUI_STOCK = 6;

    SeguimientoStock pers = (SeguimientoStock) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update stSeguiStock set "+
              "oid_producto=?"+ 
              ",oid_agrupador_depo=?"+ 
              ",punto_pedido=?"+ 
              ",stock_deseado=?"+ 
              ",oid_val_clasif_ent=?"+
                 " where " +
                 " oid_segui_stock=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_SEGUI_STOCK,pers.getOID());
    if (pers.getProducto()!=null)
    	qUpdate.setDouble(OID_PRODUCTO,pers.getProducto().getOID());
    else
    	qUpdate.setDouble(OID_PRODUCTO,new Integer(0));
    qUpdate.setInt(OID_AGRUPADOR_DEPO,pers.getAgrupador_deposito().getOID());
    qUpdate.setDouble(PUNTO_PEDIDO,pers.getPunto_pedido().doubleValue());
    qUpdate.setDouble(STOCK_DESEADO,pers.getStock_deseado().doubleValue());
    if (pers.getValClasifEnt()!=null)
    	qUpdate.setInt(OID_VAL_CLASIF_ENT,pers.getValClasifEnt().getOID());
    else
    	qUpdate.setInt(OID_VAL_CLASIF_ENT,new Integer(0));    
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_SEGUI_STOCK = 1; 
    SeguimientoStock pers = (SeguimientoStock) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("delete from stSeguiStock "+
                     " where " + 
                     " oid_segui_stock=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_SEGUI_STOCK, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_SEGUI_STOCK = 1; 
    SeguimientoStock pers = (SeguimientoStock) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update stSeguiStock "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_segui_stock=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_SEGUI_STOCK, pers.getOID()); 
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
      case SELECT_BY_VAL_CLASIF: {
          ps = this.selectByValClasif(aCondiciones); 
          break; 
      }
      case SELECT_PROD_AGRUP: {
          ps = this.selectByProdAgrupDepo(aCondiciones); 
          break; 
      }
    } 
    return ps;
  } 

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_SEGUI_STOCK = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  stSeguiStock "); 
    textSQL.append(" WHERE oid_segui_stock = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_SEGUI_STOCK, oid); 
    return querySelect; 
  }
  
  private PreparedStatement selectByProdAgrupDepo(Object aCondiciones) throws BaseException, SQLException { 

	    HashTableDatos condiciones = (HashTableDatos) aCondiciones;
	    Producto producto = (Producto)condiciones.get(Producto.NICKNAME);
	    AgrupadorDeposito agruDepo = (AgrupadorDeposito) condiciones.get(AgrupadorDeposito.NICKNAME);

	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM  stSeguiStock "); 
	    textSQL.append(" WHERE oid_producto = ? and oid_agrupador_depo = ? "); 
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
	    querySelect.setInt(1, producto.getOID()); 
	    querySelect.setInt(2, agruDepo.getOID());
	    return querySelect; 
}
  
  
  private PreparedStatement selectByProducto(Object aCondiciones) throws BaseException, SQLException { 

	    HashTableDatos condiciones = (HashTableDatos) aCondiciones;
	    Producto producto = (Producto)condiciones.get(Producto.NICKNAME);

	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM  stSeguiStock "); 
	    textSQL.append(" WHERE oid_producto = ? "); 
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
	    querySelect.setInt(1, producto.getOID()); 
	    return querySelect; 
 }
  
  private PreparedStatement selectByValClasif(Object aCondiciones) throws BaseException, SQLException { 

	    HashTableDatos condiciones = (HashTableDatos) aCondiciones;
	    ValorClasificadorEntidad valClasifEnt = (ValorClasificadorEntidad)condiciones.get(ValorClasificadorEntidad.NICKNAME);

	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM  stSeguiStock "); 
	    textSQL.append(" WHERE oid_val_clasif_ent = ? "); 
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
	    querySelect.setInt(1, valClasifEnt.getOID()); 
	    return querySelect; 
}
  
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  stSeguiStock "); 
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_segui_stock oid, codigo,  descripcion ,activo ");
    textSQL.append(" from stSeguiStock");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  } 
  
  public static List getSeguimientosStock(Producto producto,
          ISesion aSesion) throws BaseException {
	  HashTableDatos condiciones = new HashTableDatos();
	  condiciones.put(Producto.NICKNAME, producto);
	  return (List) ObjetoLogico.getObjects(SeguimientoStock.NICKNAME,
             DBSeguimientoStock.SELECT_BY_PRODUCTO,
             condiciones,
             new ListObserver(),
             aSesion);
  }
  
  public static List getSeguimientosStock(ValorClasificadorEntidad valClasifEnt,
          ISesion aSesion) throws BaseException {
	  HashTableDatos condiciones = new HashTableDatos();
	  condiciones.put(ValorClasificadorEntidad.NICKNAME, valClasifEnt);
	  return (List) ObjetoLogico.getObjects(SeguimientoStock.NICKNAME,
             DBSeguimientoStock.SELECT_BY_VAL_CLASIF,
             condiciones,
             new ListObserver(),
             aSesion);
  }
  
  public static SeguimientoStock getSeguimientoStock(
		  Producto producto,
		  AgrupadorDeposito agrupadorDeposito,
          ISesion aSesion) throws BaseException {
	  HashTableDatos condiciones = new HashTableDatos();
	  condiciones.put(Producto.NICKNAME, producto);
	  condiciones.put(AgrupadorDeposito.NICKNAME, agrupadorDeposito);
	  
	  return (SeguimientoStock) ObjetoLogico.getObjects(SeguimientoStock.NICKNAME,
             DBSeguimientoStock.SELECT_PROD_AGRUP,
             condiciones,
             new ObjetoObservado(),
             aSesion);
  }
  
  
  
  
} 
