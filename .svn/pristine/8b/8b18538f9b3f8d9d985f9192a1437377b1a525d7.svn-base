package com.srn.erp.presupuesto.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.presupuesto.bm.NodoEstructuraPlanificacion;
import com.srn.erp.presupuesto.bm.UPCNodoEstructura;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;

public class DBUPCNodoEstructura extends DBObjetoPersistente {

  public static final String OID_UPC_NODO = "oid_upc_nodo";
  public static final String ORDEN = "orden";
  public static final String OID_NODO_ESTRUC = "oid_nodo_estruc";
  public static final String OID_UPC = "oid_upc";
  public static final String ACTIVO = "activo";
  
  public static final int SELECT_BY_NODO_ESTRUC = 100;

  public DBUPCNodoEstructura() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_UPC_NODO = 1;
    final int ORDEN = 2;
    final int OID_NODO_ESTRUC = 3;
    final int OID_UPC = 4;
    final int ACTIVO = 5;

    UPCNodoEstructura pers = (UPCNodoEstructura) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into plUPCNodo "+
                     " ( "+
                      "OID_UPC_NODO,"+
                      "ORDEN,"+
                      "OID_NODO_ESTRUC,"+
                      "OID_UPC,"+
                      "ACTIVO)"+ 
                      " values "+ 
                      "("+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_UPC_NODO,pers.getOID());
    qInsert.setInt(ORDEN,pers.getOrden().intValue());
    qInsert.setInt(OID_NODO_ESTRUC,pers.getNodo_estructura().getOID());
    qInsert.setInt(OID_UPC,pers.getUpc().getOID());
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int ORDEN = 1;
    final int OID_NODO_ESTRUC = 2;
    final int OID_UPC = 3;
    final int ACTIVO = 4;
    final int OID_UPC_NODO = 5;

    UPCNodoEstructura pers = (UPCNodoEstructura) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update plUPCNodo set "+
              "orden=?"+ 
              ",oid_nodo_estruc=?"+ 
              ",oid_upc=?"+ 
              ",activo=?"+ 
                 " where " +
                 " oid_upc_nodo=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_UPC_NODO,pers.getOID());
    qUpdate.setInt(ORDEN,pers.getOrden().intValue());
    qUpdate.setInt(OID_NODO_ESTRUC,pers.getNodo_estructura().getOID());
    qUpdate.setInt(OID_UPC,pers.getUpc().getOID());
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_UPC_NODO = 1; 
    UPCNodoEstructura pers = (UPCNodoEstructura) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update plUPCNodo "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_upc_nodo=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_UPC_NODO, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_UPC_NODO = 1; 
    UPCNodoEstructura pers = (UPCNodoEstructura) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update plUPCNodo "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_upc_nodo=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_UPC_NODO, pers.getOID()); 
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
      case SELECT_BY_NODO_ESTRUC: {
        ps = this.selectByNodoEstructura(aCondiciones); 
        break; 
      }
    } 
    return ps;
  } 

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_UPC_NODO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  plUPCNodo "); 
    textSQL.append(" WHERE oid_upc_nodo = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_UPC_NODO, oid); 
    return querySelect; 
  }
  
  private PreparedStatement selectByNodoEstructura(Object aCondiciones) throws BaseException, SQLException { 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  plUPCNodo "); 
    textSQL.append(" WHERE oid_nodo_estruc = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    NodoEstructuraPlanificacion nodo = (NodoEstructuraPlanificacion) aCondiciones; 
    querySelect.setInt(1, nodo.getOID()); 
    return querySelect;
    
  }  
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  plUPCNodo "); 
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_upc_nodo oid, codigo,  descripcion ,activo ");
    textSQL.append(" from plUPCNodo");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  } 
  
  public static List getUPCsByNodo(NodoEstructuraPlanificacion nodo,
      ISesion aSesion) throws BaseException {
  	return (List) ObjetoLogico.getObjects(UPCNodoEstructura.NICKNAME,
         DBUPCNodoEstructura.SELECT_BY_NODO_ESTRUC,
         nodo,
         new ListObserver(),
         aSesion);
  }
  
  
} 
