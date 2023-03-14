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

public class DBDriverCuentaSubreparto extends DBObjetoPersistente {

  public static final String OID_DRIVER_CTA = "oid_driver_cta";
  public static final String OID_DRIVER = "oid_driver";
  public static final String OID_ANA_CON = "oid_ana_con";
  public static final String ACTIVO = "activo";
  
  public static final int SELECT_BY_DRIVER = 100;

  public DBDriverCuentaSubreparto() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_DRIVER_CTA = 1;
    final int OID_DRIVER = 2;
    final int OID_ANA_CON = 3;
    final int ACTIVO = 4;

    DriverCuentaSubreparto pers = (DriverCuentaSubreparto) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into cgDriverCta "+
                     " ( "+
                      "OID_DRIVER_CTA,"+
                      "OID_DRIVER,"+
                      "OID_ANA_CON,"+
                      "ACTIVO)"+ 
                      " values "+ 
                      "("+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_DRIVER_CTA,pers.getOID());
    qInsert.setInt(OID_DRIVER,pers.getDriver().getOID());
    qInsert.setInt(OID_ANA_CON,pers.getCuenta().getOID());
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_DRIVER = 1;
    final int OID_ANA_CON = 2;
    final int ACTIVO = 3;
    final int OID_DRIVER_CTA = 4;

    DriverCuentaSubreparto pers = (DriverCuentaSubreparto) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update cgDriverCta set "+
              "oid_driver=?"+ 
              ",oid_ana_con=?"+ 
              ",activo=?"+ 
                 " where " +
                 " oid_driver_cta=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_DRIVER_CTA,pers.getOID());
    qUpdate.setInt(OID_DRIVER,pers.getDriver().getOID());
    qUpdate.setInt(OID_ANA_CON,pers.getCuenta().getOID());
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_DRIVER_CTA = 1; 
    DriverCuentaSubreparto pers = (DriverCuentaSubreparto) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("delete from cgDriverCta "+
                     " where " + 
                     " oid_driver_cta=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_DRIVER_CTA, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_DRIVER_CTA = 1; 
    DriverCuentaSubreparto pers = (DriverCuentaSubreparto) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update cgDriverCta "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_driver_cta=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_DRIVER_CTA, pers.getOID()); 
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
          ps = this.selectByDriverCuentaSubreporte(aCondiciones); 
          break;    	  
      }
    } 
    return ps;
  } 
  
  private PreparedStatement selectByDriverCuentaSubreporte(Object aCondiciones) throws BaseException, SQLException { 

	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM  cgDriverCta "); 
	    textSQL.append(" WHERE oid_driver = ? "); 
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
	    HashTableDatos condiciones = (HashTableDatos) aCondiciones;
	    DriverSubreparto driverSubreparto = (DriverSubreparto) condiciones.get(DriverSubreparto.NICKNAME);
	    querySelect.setInt(1, driverSubreparto.getOID()); 
	    return querySelect; 
  }
  
  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_DRIVER_CTA = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  cgDriverCta "); 
    textSQL.append(" WHERE oid_driver_cta = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_DRIVER_CTA, oid); 
    return querySelect; 
  }
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  cgDriverCta "); 
    textSQL.append(" WHERE oid_ana_con = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_driver_cta oid,oid_ana_con codigo,  descripcion ,activo ");
    textSQL.append(" from cgDriverCta");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  }
  
  public static List getDriverCuentasSubreparto(DriverSubreparto driver,
          ISesion aSesion) throws BaseException {
	  HashTableDatos condiciones = new HashTableDatos();
	  condiciones.put(DriverSubreparto.NICKNAME, driver);
	  return (List) ObjetoLogico.getObjects(DriverCuentaSubreparto.NICKNAME,
			  DBDriverCuentaSubreparto.SELECT_BY_DRIVER,
             condiciones,
             new ListObserver(),
             aSesion);
  }
  
  
} 
