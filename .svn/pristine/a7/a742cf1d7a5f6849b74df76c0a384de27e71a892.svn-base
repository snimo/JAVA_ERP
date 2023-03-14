package com.srn.erp.ventas.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.srn.erp.stock.bm.Producto;
import com.srn.erp.ventas.bm.ConfProdPorLP;
import com.srn.erp.ventas.bm.ListaPrecios;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.ObjetoObservado;

public class DBConfProdPorLP extends DBObjetoPersistente {

  public static final String OID_CONF_PROD_LP = "oid_conf_prod_lp";
  public static final String OID_PRODUCTO = "oid_producto";
  public static final String OID_PRECIO_CAB = "oid_precio_cab";
  public static final String PORC_RENT_SUG = "porc_rent_sug";
  
  public static final int SELECT_BY_PRODUCTO_PRECIO_CAB = 100;
  
  public DBConfProdPorLP() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_CONF_PROD_LP = 1;
    final int OID_PRODUCTO = 2;
    final int OID_PRECIO_CAB = 3;
    final int PORC_RENT_SUG = 4;

    ConfProdPorLP pers = (ConfProdPorLP) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into veConfProdPorLP "+
                     " ( "+
                      "OID_CONF_PROD_LP,"+
                      "OID_PRODUCTO,"+
                      "OID_PRECIO_CAB,"+
                      "PORC_RENT_SUG)"+ 
                      " values "+ 
                      "("+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_CONF_PROD_LP,pers.getOID());
    qInsert.setInt(OID_PRODUCTO,pers.getProducto().getOID());
    qInsert.setInt(OID_PRECIO_CAB,pers.getLista_precios().getOID());
    if (pers.getPorc_rent_sug()!=null)
    	qInsert.setDouble(PORC_RENT_SUG,pers.getPorc_rent_sug().doubleValue());
    else
    	qInsert.setNull(PORC_RENT_SUG,java.sql.Types.DOUBLE);
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_PRODUCTO = 1;
    final int OID_PRECIO_CAB = 2;
    final int PORC_RENT_SUG = 3;
    final int OID_CONF_PROD_LP = 4;

    ConfProdPorLP pers = (ConfProdPorLP) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update veConfProdPorLP set "+
              "oid_producto=?"+ 
              ",oid_precio_cab=?"+ 
              ",porc_rent_sug=?"+ 
                 " where " +
                 " oid_conf_prod_lp=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_CONF_PROD_LP,pers.getOID());
    qUpdate.setInt(OID_PRODUCTO,pers.getProducto().getOID());
    qUpdate.setInt(OID_PRECIO_CAB,pers.getLista_precios().getOID());
    if (pers.getPorc_rent_sug()!=null)
    	qUpdate.setDouble(PORC_RENT_SUG,pers.getPorc_rent_sug().doubleValue());
    else
    	qUpdate.setNull(PORC_RENT_SUG,java.sql.Types.DOUBLE);
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_CONF_PROD_LP = 1; 
    ConfProdPorLP pers = (ConfProdPorLP) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update veConfProdPorLP "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_conf_prod_lp=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_CONF_PROD_LP, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_CONF_PROD_LP = 1; 
    ConfProdPorLP pers = (ConfProdPorLP) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update veConfProdPorLP "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_conf_prod_lp=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_CONF_PROD_LP, pers.getOID()); 
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
      case SELECT_BY_PRODUCTO_PRECIO_CAB: {
          ps = this.selectByProductoPrecioCab(aCondiciones); 
          break; 
      }
    } 
    return ps;
  } 

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_CONF_PROD_LP = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  veConfProdPorLP "); 
    textSQL.append(" WHERE oid_conf_prod_lp = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_CONF_PROD_LP, oid); 
    return querySelect; 
  }
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  veConfProdPorLP "); 
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }
  
  private PreparedStatement selectByProductoPrecioCab(Object aCondiciones) throws BaseException, SQLException { 
	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM  veConfProdPorLP "); 
	    textSQL.append(" WHERE oid_producto = ? and oid_precio_cab = ? ");
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
	    HashTableDatos condiciones = (HashTableDatos) aCondiciones;
	    Producto producto = (Producto) condiciones.get(Producto.NICKNAME);
	    ListaPrecios listaPrecios = (ListaPrecios) condiciones.get(ListaPrecios.NICKNAME);
	    querySelect.setInt(1, producto.getOID());
	    querySelect.setInt(2, listaPrecios.getOID());
	    return querySelect; 
	  }
  

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_conf_prod_lp oid, codigo,  descripcion ,activo ");
    textSQL.append(" from veConfProdPorLP");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  }
  
  public static ConfProdPorLP getConfProdLP(Producto producto,
		  									ListaPrecios listaPrecios,
		  									ISesion aSesion)
          throws BaseException {
	  HashTableDatos condiciones = new HashTableDatos();
	  condiciones.put(Producto.NICKNAME, producto);
	  condiciones.put(ListaPrecios.NICKNAME, listaPrecios);
	  return (ConfProdPorLP) ObjetoLogico.getObjects(ConfProdPorLP.NICKNAME,
			  				DBConfProdPorLP.SELECT_BY_PRODUCTO_PRECIO_CAB,
			  				condiciones,
			  				new ObjetoObservado(),
			  				aSesion);
  }
  
  
} 
