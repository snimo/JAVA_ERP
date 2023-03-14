package com.srn.erp.compras.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.compras.bm.AutorizacionMontoCompra;
import com.srn.erp.compras.bm.AutorizadorCompra;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.applicarionServer.bm.Varios.Money;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.ObjetoObservado;

public class DBAutorizacionMontoCompra extends DBObjetoPersistente {

  public static final String OID_AUTORIZ_MONTO = "oid_autoriz_monto";
  public static final String MONTO_DESDE = "monto_desde";
  public static final String MONTO_HASTA = "monto_hasta";
  public static final String SECU = "secu";
  public static final String OID_AUTORIZ_CPRA = "oid_autoriz_cpra";
  public static final String CUALQUIER_SECTOR = "cualquier_sector";
  
  public static final int SELECT_BY_AUTORIZACION_COMPRA = 100;
  public static final int SELECT_BY_BUSCAR_EN_RANGO = 101;

  public DBAutorizacionMontoCompra() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_AUTORIZ_MONTO = 1;
    final int MONTO_DESDE = 2;
    final int MONTO_HASTA = 3;
    final int SECU = 4;
    final int OID_AUTORIZ_CPRA = 5;
    final int CUALQUIER_SECTOR = 6;

    AutorizacionMontoCompra pers = (AutorizacionMontoCompra) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into cpAutorizCpraMonto "+
                     " ( "+
                      "OID_AUTORIZ_MONTO,"+
                      "MONTO_DESDE,"+
                      "MONTO_HASTA,"+
                      "SECU,"+
                      "OID_AUTORIZ_CPRA,"+
                      "CUALQUIER_SECTOR)"+ 
                      " values "+ 
                      "("+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_AUTORIZ_MONTO,pers.getOID());
    qInsert.setDouble(MONTO_DESDE,pers.getMonto_desde().doubleValue());
    qInsert.setDouble(MONTO_HASTA,pers.getMonto_hasta().doubleValue());
    qInsert.setInt(SECU,pers.getSecu().intValue());
    qInsert.setInt(OID_AUTORIZ_CPRA,pers.getAutorizacion_compra().getOID());
    qInsert.setBoolean(CUALQUIER_SECTOR,pers.isCualquier_sector().booleanValue());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int MONTO_DESDE = 1;
    final int MONTO_HASTA = 2;
    final int SECU = 3;
    final int OID_AUTORIZ_CPRA = 4;
    final int CUALQUIER_SECTOR = 5;
    final int OID_AUTORIZ_MONTO = 6;

    AutorizacionMontoCompra pers = (AutorizacionMontoCompra) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update cpAutorizCpraMonto set "+
              "monto_desde=?"+ 
              ",monto_hasta=?"+ 
              ",secu=?"+ 
              ",oid_autoriz_cpra=?"+ 
              ",cualquier_sector=?"+ 
                 " where " +
                 " oid_autoriz_monto=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_AUTORIZ_MONTO,pers.getOID());
    qUpdate.setDouble(MONTO_DESDE,pers.getMonto_desde().doubleValue());
    qUpdate.setDouble(MONTO_HASTA,pers.getMonto_hasta().doubleValue());
    qUpdate.setInt(SECU,pers.getSecu().intValue());
    qUpdate.setInt(OID_AUTORIZ_CPRA,pers.getAutorizacion_compra().getOID());
    qUpdate.setBoolean(CUALQUIER_SECTOR,pers.isCualquier_sector().booleanValue());
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_AUTORIZ_MONTO = 1; 
    AutorizacionMontoCompra pers = (AutorizacionMontoCompra) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("delete from cpAutorizCpraMonto "+
                     " where " + 
                     " oid_autoriz_monto=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_AUTORIZ_MONTO, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_AUTORIZ_MONTO = 1; 
    AutorizacionMontoCompra pers = (AutorizacionMontoCompra) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update cpAutorizCpraMonto "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_autoriz_monto=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_AUTORIZ_MONTO, pers.getOID()); 
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
      case SELECT_BY_AUTORIZACION_COMPRA: {
        ps = this.selectByAutorizacionCompra(aCondiciones); 
        break; 
      }
      case SELECT_BY_BUSCAR_EN_RANGO: {
        ps = this.selectByBuscarEnRango(aCondiciones); 
        break; 
      }
    } 
    return ps;
  } 

  private  PreparedStatement selectByAutorizacionCompra(Object aCondiciones) throws BaseException, SQLException { 
	StringBuffer textSQL = new StringBuffer(); 
	textSQL.append("SELECT * FROM  cpAutorizCpraMonto "); 
	textSQL.append(" WHERE oid_autoriz_cpra = ? "); 
	PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
	AutorizadorCompra autorizadorCompra = ( (AutorizadorCompra) aCondiciones); 
	querySelect.setInt(1, autorizadorCompra.getOID()); 
	return querySelect; 
  }
  
  private PreparedStatement selectByBuscarEnRango(Object aCondiciones) throws BaseException, SQLException { 
    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  cpAutorizCpraMonto "); 
    textSQL.append(" WHERE oid_autoriz_cpra = ? and monto_desde<=? and monto_hasta>=? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    HashTableDatos condiciones = (HashTableDatos) aCondiciones;
    AutorizadorCompra autorizadorCompra = (AutorizadorCompra) condiciones.get(AutorizadorCompra.NICKNAME);
    Money monto = (Money) condiciones.get("MONTO");
    querySelect.setInt(1, autorizadorCompra.getOID()); 
    querySelect.setDouble(2, monto.doubleValue());
    querySelect.setDouble(3, monto.doubleValue());
    return querySelect; 
  }
  
  
  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_AUTORIZ_MONTO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  cpAutorizCpraMonto "); 
    textSQL.append(" WHERE oid_autoriz_monto = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_AUTORIZ_MONTO, oid); 
    return querySelect; 
  }
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  cpAutorizCpraMonto "); 
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_autoriz_monto oid, codigo,  descripcion ,activo ");
    textSQL.append(" from cpAutorizCpraMonto");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  } 
  
  public static List getAutorizacionesPorMonto(AutorizadorCompra autorizadorCompra,
          ISesion aSesion) throws BaseException {
	  return (List) ObjetoLogico.getObjects(AutorizacionMontoCompra.NICKNAME,
			  DBAutorizacionMontoCompra.SELECT_BY_AUTORIZACION_COMPRA,
             autorizadorCompra,
             new ListObserver(),
             aSesion);
  }
  
  public static AutorizacionMontoCompra getAutorizMonCpraByMonto(AutorizadorCompra autorizadorCompra, Money monto,
			ISesion aSesion) throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put(AutorizadorCompra.NICKNAME, autorizadorCompra);
		condiciones.put("MONTO", monto);
		return (AutorizacionMontoCompra) ObjetoLogico.getObjects(AutorizacionMontoCompra.NICKNAME,
				DBAutorizacionMontoCompra.SELECT_BY_BUSCAR_EN_RANGO, condiciones, new ObjetoObservado(), aSesion);
	}
  
  
  
} 
