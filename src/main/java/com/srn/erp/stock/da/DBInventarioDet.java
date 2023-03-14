package com.srn.erp.stock.da;

import java.sql.*;
import java.util.List;

import com.srn.erp.stock.bm.*;
import com.srn.erp.ventas.bm.PedidoCab;
import com.srn.erp.ventas.bm.PedidoDet;
import com.srn.erp.ventas.da.DBPedidoDet;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.*;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.*;

public class DBInventarioDet extends DBObjetoPersistente {

  public static final String OID_INVENTARIO_DET = "oid_inventario_det";
  public static final String OID_INVENTARIO_CAB = "oid_inventario_cab";
  public static final String OID_PRODUCTO = "oid_producto";
  public static final String FISICO = "fisico";
  public static final String CONTEO = "conteo";
  public static final String SIN_STOCK = "sin_stock";
  public static final String AJU_STOCK = "aju_stock";
  public static final String OBSERVACION = "observacion";
  
  public static final int SELECT_BY_INVENTARIO_CAB = 100;

  public DBInventarioDet() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_INVENTARIO_DET = 1;
    final int OID_INVENTARAIO_CAB = 2;
    final int OID_PRODUCTO = 3;
    final int FISICO = 4;
    final int CONTEO = 5;
    final int SIN_STOCK = 6;
    final int AJU_STOCK = 7;
    final int OBSERVACION = 8;

    InventarioDet pers = (InventarioDet) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into skInventarioDet "+
                     " ( "+
                      "OID_INVENTARIO_DET,"+
                      "OID_INVENTARIO_CAB,"+
                      "OID_PRODUCTO,"+
                      "FISICO,"+
                      "CONTEO,"+
                      "SIN_STOCK,"+
                      "AJU_STOCK,"+
                      "OBSERVACION)"+ 
                      " values "+ 
                      "("+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_INVENTARIO_DET,pers.getOID());
    qInsert.setInt(OID_INVENTARAIO_CAB,pers.getInventario_cab().getOID());
    qInsert.setInt(OID_PRODUCTO,pers.getProducto().getOID());
    qInsert.setDouble(FISICO,pers.getFisico().doubleValue());
    qInsert.setDouble(CONTEO,pers.getConteo().doubleValue());
    qInsert.setBoolean(SIN_STOCK,pers.isSin_stock().booleanValue());
    qInsert.setDouble(AJU_STOCK,pers.getAju_stock().doubleValue());
    qInsert.setString(OBSERVACION,pers.getObservacion());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_INVENTARAIO_CAB = 1;
    final int OID_PRODUCTO = 2;
    final int FISICO = 3;
    final int CONTEO = 4;
    final int SIN_STOCK = 5;
    final int AJU_STOCK = 6;
    final int OBSERVACION = 7;
    final int OID_INVENTARIO_DET = 8;

    InventarioDet pers = (InventarioDet) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update skInventarioDet set "+
              "oid_inventario_cab=?"+ 
              ",oid_producto=?"+ 
              ",fisico=?"+ 
              ",conteo=?"+ 
              ",sin_stock=?"+ 
              ",aju_stock=?"+ 
              ",observacion=?"+ 
                 " where " +
                 " oid_inventario_det=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_INVENTARIO_DET,pers.getOID());
    qUpdate.setInt(OID_INVENTARAIO_CAB,pers.getInventario_cab().getOID());
    qUpdate.setInt(OID_PRODUCTO,pers.getProducto().getOID());
    qUpdate.setDouble(FISICO,pers.getFisico().doubleValue());
    qUpdate.setDouble(CONTEO,pers.getConteo().doubleValue());
    qUpdate.setBoolean(SIN_STOCK,pers.isSin_stock().booleanValue());
    qUpdate.setDouble(AJU_STOCK,pers.getAju_stock().doubleValue());
    qUpdate.setString(OBSERVACION,pers.getObservacion());
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_INVENTARIO_DET = 1; 
    InventarioDet pers = (InventarioDet) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update skInventarioDet "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_inventario_det=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_INVENTARIO_DET, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_INVENTARIO_DET = 1; 
    InventarioDet pers = (InventarioDet) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update skInventarioDet "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_inventario_det=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_INVENTARIO_DET, pers.getOID()); 
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
      case SELECT_BY_INVENTARIO_CAB: {
          ps = this.selectByInventarioCab(aCondiciones); 
          break; 
      }
    } 
    return ps;
  } 

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_INVENTARIO_DET = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  skInventarioDet "); 
    textSQL.append(" WHERE oid_inventario_det = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_INVENTARIO_DET, oid); 
    return querySelect; 
  }
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  skInventarioDet "); 
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }
  
  private PreparedStatement selectByInventarioCab(Object aCondiciones) throws BaseException, SQLException { 

	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM  skInventarioDet "); 
	    textSQL.append(" WHERE oid_inventario_cab  = ? ");
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
	    InventarioCab inventarioCab = (InventarioCab) aCondiciones; 
	    querySelect.setInt(1, inventarioCab.getOID()); 
	    return querySelect; 
  }
  
  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_inventario_det oid, codigo,  descripcion ,activo ");
    textSQL.append(" from skInventarioDet");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  } 
  
	public static List getDetallesByInventario(InventarioCab inventario, ISesion aSesion) throws BaseException {
		return (List) ObjetoLogico.getObjects(InventarioDet.NICKNAME, DBInventarioDet.SELECT_BY_INVENTARIO_CAB, inventario, new ListObserver(),
				aSesion);
	}
  
  
} 
