package com.srn.erp.contabilidad.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.contabilidad.bm.Componente;
import com.srn.erp.contabilidad.bm.DriverCuentaComponente;
import com.srn.erp.contabilidad.bm.DriverCuentaSubreparto;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.ObjetoObservado;

public class DBDriverCuentaComponente extends DBObjetoPersistente {

  public static final String OID_DRIVER_COMPO = "oid_driver_compo";
  public static final String OID_DRIVER_CTA = "oid_driver_cta";
  public static final String OID_COMPO = "oid_compo";
  public static final String OID_VAL_COMPO = "oid_val_compo";
  public static final String ACTIVO = "activo";
  
  public static final int SELECT_BY_DRIVER_CTA = 100;
  public static final int SELECT_BY_DRIVER_CTA_COMPO = 101;

  public DBDriverCuentaComponente() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_DRIVER_COMPO = 1;
    final int OID_DRIVER_CTA = 2;
    final int OID_COMPO = 3;
    final int OID_VAL_COMPO = 4;
    final int ACTIVO = 5;

    DriverCuentaComponente pers = (DriverCuentaComponente) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into cgDriverCtaCompo "+
                     " ( "+
                      "OID_DRIVER_COMPO,"+
                      "OID_DRIVER_CTA,"+
                      "OID_COMPO,"+
                      "OID_VAL_COMPO,"+
                      "ACTIVO)"+ 
                      " values "+ 
                      "("+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_DRIVER_COMPO,pers.getOID());
    qInsert.setInt(OID_DRIVER_CTA,pers.getDriver_cta().getOID());
    qInsert.setInt(OID_COMPO,pers.getComponente().getOID());
    qInsert.setInt(OID_VAL_COMPO,pers.getValor_componente().getOIDInteger().intValue());
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_DRIVER_CTA = 1;
    final int OID_COMPO = 2;
    final int OID_VAL_COMPO = 3;
    final int ACTIVO = 4;
    final int OID_DRIVER_COMPO = 5;

    DriverCuentaComponente pers = (DriverCuentaComponente) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update cgDriverCtaCompo set "+
              "oid_driver_cta=?"+ 
              ",oid_compo=?"+ 
              ",oid_val_compo=?"+ 
              ",activo=?"+ 
                 " where " +
                 " oid_driver_compo=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_DRIVER_COMPO,pers.getOID());
    qUpdate.setInt(OID_DRIVER_CTA,pers.getDriver_cta().getOID());
    qUpdate.setInt(OID_COMPO,pers.getComponente().getOID());
    qUpdate.setInt(OID_VAL_COMPO,pers.getValor_componente().getOIDInteger().intValue());
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_DRIVER_COMPO = 1; 
    DriverCuentaComponente pers = (DriverCuentaComponente) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("delete from cgDriverCtaCompo "+
                     " where " + 
                     " oid_driver_compo=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_DRIVER_COMPO, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_DRIVER_COMPO = 1; 
    DriverCuentaComponente pers = (DriverCuentaComponente) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update cgDriverCtaCompo "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_driver_compo=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_DRIVER_COMPO, pers.getOID()); 
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
      case SELECT_BY_DRIVER_CTA: {
          ps = this.selectByDriverCta(aCondiciones); 
          break; 
      }
      case SELECT_BY_DRIVER_CTA_COMPO: {
          ps = this.selectByDriverCtaCompo(aCondiciones); 
          break; 
      }
    } 
    return ps;
  }
  
  private PreparedStatement selectByDriverCta(Object aCondiciones) throws BaseException, SQLException { 

	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM  cgDriverCtaCompo "); 
	    textSQL.append(" WHERE oid_driver_cta = ? "); 
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
	    
	    DriverCuentaSubreparto driverCuentaSubreparto = (DriverCuentaSubreparto) aCondiciones;
	    querySelect.setInt(1, driverCuentaSubreparto.getOID()); 
	    return querySelect; 
  }
  

  private PreparedStatement selectByDriverCtaCompo(Object aCondiciones) throws BaseException, SQLException { 

	  
	    HashTableDatos condiciones = (HashTableDatos) aCondiciones;
	    DriverCuentaSubreparto driverCuenta = (DriverCuentaSubreparto) condiciones.get(DriverCuentaSubreparto.NICKNAME);
	    Componente componente = (Componente) condiciones.get(Componente.NICKNAME);
	    
	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM  cgDriverCtaCompo "); 
	    textSQL.append(" WHERE oid_driver_cta = ? and oid_compo = ?"); 
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
	    
	    querySelect.setInt(1, driverCuenta.getOID());
	    querySelect.setInt(2, componente.getOID());
	    return querySelect; 
  }
  
  
  

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_DRIVER_COMPO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  cgDriverCtaCompo "); 
    textSQL.append(" WHERE oid_driver_compo = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_DRIVER_COMPO, oid); 
    return querySelect; 
  }
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  cgDriverCtaCompo "); 
    textSQL.append(" WHERE oid_compo = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_driver_compo oid,oid_compo codigo,  descripcion ,activo ");
    textSQL.append(" from cgDriverCtaCompo");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  }
  
  public static List getDriverComponentesCta(DriverCuentaSubreparto driverCuenta,
          ISesion aSesion) throws BaseException {
	  return (List) ObjetoLogico.getObjects(DriverCuentaComponente.NICKNAME,
             DBDriverCuentaComponente.SELECT_BY_DRIVER_CTA,
             driverCuenta,
             new ListObserver(),
             aSesion);
  }
  
  public static DriverCuentaComponente getDriverCuentaComponente(
		  DriverCuentaSubreparto driverCuenta,
		  Componente componente,
          ISesion aSesion)
          throws BaseException {
	  HashTableDatos condiciones = new HashTableDatos();
	  condiciones.put(DriverCuentaSubreparto.NICKNAME, driverCuenta);
	  condiciones.put(Componente.NICKNAME, componente);
	  return (DriverCuentaComponente) ObjetoLogico.getObjects(DriverCuentaComponente.NICKNAME,
			  				DBDriverCuentaComponente.SELECT_BY_DRIVER_CTA_COMPO,
			  				condiciones,
			  				new ObjetoObservado(),
			  				aSesion);
  }
  
  
  
} 
