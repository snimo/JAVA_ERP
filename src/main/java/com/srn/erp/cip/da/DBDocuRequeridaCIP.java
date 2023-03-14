package com.srn.erp.cip.da;

import java.sql.*;
import java.util.List;

import com.srn.erp.cip.bm.*;
import com.srn.erp.general.bm.PeriodoInc;
import com.srn.erp.general.bm.PeriodoIncDet;
import com.srn.erp.general.da.DBPeriodoIncDet;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.*;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.*;

public class DBDocuRequeridaCIP extends DBObjetoPersistente {

  public static final String OID_TIPO_DOCU_REQ = "oid_tipo_docu_req";
  public static final String OID_TARJETA = "oid_tarjeta";
  public static final String OID_TIPO_DOCU = "oid_tipo_docu";
  public static final String ACTIVO = "activo";
  
  public static final int SELECT_BY_TARJETA = 100;

  public DBDocuRequeridaCIP() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_TIPO_DOCU_REQ = 1;
    final int OID_TARJETA = 2;
    final int OID_TIPO_DOCU = 3;
    final int ACTIVO = 4;

    DocuRequeridaCIP pers = (DocuRequeridaCIP) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into cipTipoDocuReq "+
                     " ( "+
                      "OID_TIPO_DOCU_REQ,"+
                      "OID_TARJETA,"+
                      "OID_TIPO_DOCU,"+
                      "ACTIVO)"+ 
                      " values "+ 
                      "("+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_TIPO_DOCU_REQ,pers.getOID());
    qInsert.setInt(OID_TARJETA,pers.getTarjeta().getOID());
    qInsert.setInt(OID_TIPO_DOCU,pers.getTipo_docu().getOID());
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_TARJETA = 1;
    final int OID_TIPO_DOCU = 2;
    final int ACTIVO = 3;
    final int OID_TIPO_DOCU_REQ = 4;

    DocuRequeridaCIP pers = (DocuRequeridaCIP) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update cipTipoDocuReq set "+
              "oid_tarjeta=?"+ 
              ",oid_tipo_docu=?"+ 
              ",activo=?"+ 
                 " where " +
                 " oid_tipo_docu_req=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_TIPO_DOCU_REQ,pers.getOID());
    qUpdate.setInt(OID_TARJETA,pers.getTarjeta().getOID());
    qUpdate.setInt(OID_TIPO_DOCU,pers.getTipo_docu().getOID());
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_TIPO_DOCU_REQ = 1; 
    DocuRequeridaCIP pers = (DocuRequeridaCIP) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update cipTipoDocuReq "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_tipo_docu_req=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_TIPO_DOCU_REQ, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_TIPO_DOCU_REQ = 1; 
    DocuRequeridaCIP pers = (DocuRequeridaCIP) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update cipTipoDocuReq "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_tipo_docu_req=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_TIPO_DOCU_REQ, pers.getOID()); 
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
      case SELECT_BY_TARJETA: {
          ps = this.selectByTarjeta(aCondiciones); 
          break; 
      }
    } 
    return ps;
  } 

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_TIPO_DOCU_REQ = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  cipTipoDocuReq "); 
    textSQL.append(" WHERE oid_tipo_docu_req = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_TIPO_DOCU_REQ, oid); 
    return querySelect; 
  }

  private PreparedStatement selectByTarjeta(Object aCondiciones) throws BaseException, SQLException { 
	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM  cipTipoDocuReq "); 
	    textSQL.append(" WHERE oid_tarjeta  = ? and activo = 1 ");
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
	    TarjetaCIP tarjeta = (TarjetaCIP) aCondiciones;
	    querySelect.setInt(1, tarjeta.getOID()); 
	    return querySelect; 
  }
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  cipTipoDocuReq "); 
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_tipo_docu_req oid, codigo,  descripcion ,activo ");
    textSQL.append(" from cipTipoDocuReq");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  }
  
  public static List getDocuRequerida(
		  TarjetaCIP tarjeta,
          ISesion aSesion) throws BaseException {
	  return (List) ObjetoLogico.getObjects(DocuRequeridaCIP.NICKNAME,
             DBDocuRequeridaCIP.SELECT_BY_TARJETA,
             tarjeta,
             new ListObserver(),
             aSesion);
  }
  
  
} 
