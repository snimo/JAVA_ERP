package com.srn.erp.contabilidad.da;

import java.sql.*;
import java.util.List;

import com.srn.erp.contabilidad.bm.*;
import com.srn.erp.general.bm.PeriodoInc;
import com.srn.erp.general.bm.PeriodoIncDet;
import com.srn.erp.general.da.DBPeriodoIncDet;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.*;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.*;

public class DBDriverComponente extends DBObjetoPersistente {

  public static final String OID_COMPO_DRIVER = "oid_compo_driver";
  public static final String OID_DRIVER = "oid_driver";
  public static final String OID_VALOR_COMPO = "oid_valor_compo";
  public static final String ACTIVO = "activo";
  
  public static final int SELECT_BY_DRIVER = 100;

  public DBDriverComponente() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_COMPO_DRIVER = 1;
    final int OID_DRIVER = 2;
    final int OID_VALOR_COMPO = 3;
    final int ACTIVO = 4;

    DriverComponente pers = (DriverComponente) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into cgCompoDriver "+
                     " ( "+
                      "OID_COMPO_DRIVER,"+
                      "OID_DRIVER,"+
                      "OID_VALOR_COMPO,"+
                      "ACTIVO)"+ 
                      " values "+ 
                      "("+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_COMPO_DRIVER,pers.getOID());
    qInsert.setInt(OID_DRIVER,pers.getDriver().getOID());
    qInsert.setInt(OID_VALOR_COMPO,pers.getValor_compo().getOIDInteger().intValue());
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_DRIVER = 1;
    final int OID_VALOR_COMPO = 2;
    final int ACTIVO = 3;
    final int OID_COMPO_DRIVER = 4;

    DriverComponente pers = (DriverComponente) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update cgCompoDriver set "+
              "oid_driver=?"+ 
              ",oid_valor_compo=?"+ 
              ",activo=?"+ 
                 " where " +
                 " oid_compo_driver=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_COMPO_DRIVER,pers.getOID());
    qUpdate.setInt(OID_DRIVER,pers.getDriver().getOID());
    qUpdate.setInt(OID_VALOR_COMPO,pers.getValor_compo().getOIDInteger().intValue());
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_COMPO_DRIVER = 1; 
    DriverComponente pers = (DriverComponente) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("delete from cgCompoDriver "+
                     " where " + 
                     " oid_compo_driver=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_COMPO_DRIVER, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_COMPO_DRIVER = 1; 
    DriverComponente pers = (DriverComponente) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update cgCompoDriver "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_compo_driver=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_COMPO_DRIVER, pers.getOID()); 
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
      case SELECT_BY_DRIVER: {
          ps = this.selectByDriver(aCondiciones); 
          break;    	  
      }
    } 
    return ps;
  } 

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_COMPO_DRIVER = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  cgCompoDriver "); 
    textSQL.append(" WHERE oid_compo_driver = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_COMPO_DRIVER, oid); 
    return querySelect; 
  }
  
  private PreparedStatement selectByDriver(Object aCondiciones) throws BaseException, SQLException { 

	    DriverSubreparto driver = (DriverSubreparto) aCondiciones;
	  	StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM  cgCompoDriver "); 
	    textSQL.append(" WHERE oid_driver = ? ");
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
	    querySelect.setInt(1, driver.getOID()); 
	    return querySelect;
	    
  }
  
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  cgCompoDriver "); 
    textSQL.append(" WHERE oid_valor_compo = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_compo_driver oid,oid_valor_compo codigo,  descripcion ,activo ");
    textSQL.append(" from cgCompoDriver");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  } 
  
  public static List getComponentesDriver(DriverSubreparto driver,
          ISesion aSesion) throws BaseException {
	  return (List) ObjetoLogico.getObjects(DriverComponente.NICKNAME,
             DBDriverComponente.SELECT_BY_DRIVER,
             driver,
             new ListObserver(),
             aSesion);
  }
  
  
} 
