package com.srn.erp.stock.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.StringTokenizer;

import com.srn.erp.stock.bm.AgrupadorDeposito;
import com.srn.erp.stock.bm.ConsSalEstStkPorAgrupDepo;
import com.srn.erp.stock.bm.EstadoStock;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;

public class DBConsSalEstStkPorAgrupDepo extends DBObjetoPersistente {

  public static final String OID_PRODUCTO = "oid_producto";
  public static final String COD_PRODUCTO = "cod_producto";
  public static final String DESC_PRODUCTO = "desc_producto";
  public static final String CANTIDAD = "cantidad";
  public static final String OID_UM = "oid_um";
  public static final String COD_UM = "cod_um";
  public static final String OID_ESTADO_STOCK = "oid_estado_stock";
  
  public static final int SELECT_HELP_PROD_AGRUP_DEP = 100; 

  public DBConsSalEstStkPorAgrupDepo() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_AGRUPADOR_DEPO = 1;
    final int OID_PRODUCTO = 2;
    final int COD_PRODUCTO = 3;
    final int DESC_PRODUCTO = 4;
    final int CANTIDAD = 5;
    final int OID_UM = 6;
    final int COD_UM = 7;
    final int OID_ESTADO_STOCK = 8;

    ConsSalEstStkPorAgrupDepo pers = (ConsSalEstStkPorAgrupDepo) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into aaaaaa "+
                     " ( "+
                      "OID_AGRUPADOR_DEPO,"+
                      "OID_PRODUCTO,"+
                      "COD_PRODUCTO,"+
                      "DESC_PRODUCTO,"+
                      "CANTIDAD,"+
                      "OID_UM,"+
                      "COD_UM,"+
                      "OID_ESTADO_STOCK)"+ 
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
    qInsert.setInt(OID_PRODUCTO,pers.getOid_producto().intValue());
    qInsert.setString(COD_PRODUCTO,pers.getCod_producto());
    qInsert.setString(DESC_PRODUCTO,pers.getDesc_producto());
    qInsert.setDouble(CANTIDAD,pers.getCantidad().doubleValue());
    qInsert.setInt(OID_UM,pers.getOid_um().intValue());
    qInsert.setString(COD_UM,pers.getCod_um());
    qInsert.setInt(OID_ESTADO_STOCK,pers.getOid_estado_stock().intValue());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_AGRUPADOR_DEPO = 1;
    final int OID_PRODUCTO = 2;
    final int COD_PRODUCTO = 3;
    final int DESC_PRODUCTO = 4;
    final int CANTIDAD = 5;
    final int OID_UM = 6;
    final int COD_UM = 7;
    final int OID_ESTADO_STOCK = 8;

    ConsSalEstStkPorAgrupDepo pers = (ConsSalEstStkPorAgrupDepo) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update aaaaaa set "+
              "oid_agrupador_depo=?"+ 
              ",oid_producto=?"+ 
              ",cod_producto=?"+ 
              ",desc_producto=?"+ 
              ",cantidad=?"+ 
              ",oid_um=?"+ 
              ",cod_um=?"+ 
              ",oid_estado_stock=?"+ 
                 " where " +
                 " =? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_PRODUCTO,pers.getOid_producto().intValue());
    qUpdate.setString(COD_PRODUCTO,pers.getCod_producto());
    qUpdate.setString(DESC_PRODUCTO,pers.getDesc_producto());
    qUpdate.setDouble(CANTIDAD,pers.getCantidad().doubleValue());
    qUpdate.setInt(OID_UM,pers.getOid_um().intValue());
    qUpdate.setString(COD_UM,pers.getCod_um());
    qUpdate.setInt(OID_ESTADO_STOCK,pers.getOid_estado_stock().intValue());
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    ConsSalEstStkPorAgrupDepo pers = (ConsSalEstStkPorAgrupDepo) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update aaaaaa "+
                     " set activo=0 " + 
                     " where " + 
                     " =? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(1, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    ConsSalEstStkPorAgrupDepo pers = (ConsSalEstStkPorAgrupDepo) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update aaaaaa "+
                     " set activo=1 " + 
                     " where " + 
                     " =? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(1, pers.getOID()); 
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
      case SELECT_HELP_PROD_AGRUP_DEP: {
        ps = this.selectByAgrupDepo(aCondiciones); 
        break; 
      }
    } 
    return ps;
  } 

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 


    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  aaaaaa "); 
    textSQL.append(" WHERE  = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(1, oid); 
    return querySelect; 
  }
  
  private PreparedStatement selectByAgrupDepo(Object aCondiciones) throws BaseException, SQLException { 

  	HashTableDatos condiciones = (HashTableDatos) aCondiciones;
  	
  	AgrupadorDeposito agrupDepo = (AgrupadorDeposito) condiciones.get(AgrupadorDeposito.NICKNAME);
  	
  	EstadoStock estadoStock = (EstadoStock) condiciones.get(EstadoStock.NICKNAME);
  	
  	String codigo = null;
  	if (condiciones.containsKey("codigo"))
  		codigo = condiciones.getString("codigo");
  	
  	String descripcion = null;
  	if (condiciones.containsKey("descripcion"))
  		descripcion = condiciones.getString("descripcion");
  	
    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT ");
    textSQL.append(" b.oid_producto, ");
    textSQL.append(" b.codigo cod_producto, ");
    textSQL.append(" b.descripcion desc_producto, ");
    textSQL.append(" b.oid_um_stk oid_um, ");
    textSQL.append(" c.codigo cod_um, ");
      
    textSQL.append(" a.oid_estado_stock, ");
    textSQL.append(" sum(a.saldo) cantidad ");
    textSQL.append("FROM  ");
    textSQL.append(" skStockSaldoEstado a, stProducto b , stUniMed c "); 
    textSQL.append("WHERE	");
    textSQL.append(" a.oid_producto = b.oid_producto ");
    textSQL.append(" and c.oid_um = b.oid_um_stk ");
    textSQL.append(" and a.oid_estado_stock = "+estadoStock.getOIDInteger().toString());
    textSQL.append(" and a.oid_deposito in (select oid_deposito from skAgrupadorDepDet where oid_agrupador_depo = "+agrupDepo.getOIDInteger().toString()+" and activo=1 ) ");
    
    if (condiciones.containsKey("nd_int"))
    	textSQL.append(" and b.HAB_ND_INT = 1");

    if (condiciones.containsKey("nc_int"))
    	textSQL.append(" and b.HAB_NC_INT = 1");

    // Filtrar por codigo y descripcion producto
    
    if (condiciones.containsKey("descripcion")) {
  		StringTokenizer st =  new StringTokenizer(descripcion, " ");
      while(st.hasMoreTokens()){
      	String next = st.nextToken().toUpperCase();
      	textSQL.append(" and b.desc_search like '%"+next+"%' ");
      }
    }
    
    if (condiciones.containsKey("codigo")) {
  		StringTokenizer st =  new StringTokenizer(codigo, " ");
      while(st.hasMoreTokens()){
      	String next = st.nextToken().toUpperCase();
      	textSQL.append(" and b.codigo like '%"+next+"%' ");
      }
    }
    
    
    
    textSQL.append(" group by ");
    textSQL.append(" b.oid_producto, ");
    textSQL.append(" b.codigo, ");
    textSQL.append(" b.descripcion, ");
    textSQL.append(" b.oid_um_stk, ");
    textSQL.append(" c.codigo , ");
    textSQL.append(" a.oid_estado_stock ");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  }
  
  
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  aaaaaa "); 
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT  oid, codigo,  descripcion ,activo ");
    textSQL.append(" from aaaaaa");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  } 
  
  public static List getConsSalStkPorAgrupDepo(AgrupadorDeposito agrupadorDeposito,
  																						 EstadoStock estadoStock,
  																						 HashTableDatos aCondiciones,
  																						 ISesion aSesion) throws BaseException {
  	HashTableDatos condiciones = new HashTableDatos();
  	condiciones.put(AgrupadorDeposito.NICKNAME,agrupadorDeposito);
  	condiciones.put(EstadoStock.NICKNAME,estadoStock);
  	
  	if (aCondiciones.containsKey("codigo"))
  		condiciones.put("codigo", aCondiciones.getString("codigo"));
  	
  	if (aCondiciones.containsKey("descripcion"))
  		condiciones.put("descripcion", aCondiciones.getString("descripcion"));
  	
  	if (aCondiciones.containsKey("nd_int"))
  		condiciones.put("nd_int", "");
  	
  	if (aCondiciones.containsKey("nc_int"))
  		condiciones.put("nc_int", "");
  	
  	
  	return (List) ObjetoLogico.getObjects(ConsSalEstStkPorAgrupDepo.NICKNAME,
         DBConsSalEstStkPorAgrupDepo.SELECT_HELP_PROD_AGRUP_DEP,
         condiciones,
         new ListObserver(),
         aSesion);
  }
  
  
} 
