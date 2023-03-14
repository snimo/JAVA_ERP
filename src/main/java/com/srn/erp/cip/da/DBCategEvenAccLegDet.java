package com.srn.erp.cip.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.cip.bm.CategEvenAccLegDet;
import com.srn.erp.cip.bm.CategEvenAccesoLeg;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;

public class DBCategEvenAccLegDet extends DBObjetoPersistente {

  public static final String OID_ACC_EVE_DET = "oid_acc_eve_det";
  public static final String OID_CATEG_EVE_LEG = "oid_categ_eve_leg";
  public static final String OID_CATEG_ACCESO = "oid_categ_acceso";
  public static final String ACTIVO = "activo";
  
  public static final int SELECT_BY_CATEGEVELEG = 100;

  public DBCategEvenAccLegDet() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_ACC_EVE_DET = 1;
    final int OID_CATEG_EVE_LEG = 2;
    final int OID_CATEG_ACCESO = 3;
    final int ACTIVO = 4;

    CategEvenAccLegDet pers = (CategEvenAccLegDet) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into cipCategLegEveDet "+
                     " ( "+
                      "OID_ACC_EVE_DET,"+
                      "OID_CATEG_EVE_LEG,"+
                      "OID_CATEG_ACCESO,"+
                      "ACTIVO)"+ 
                      " values "+ 
                      "("+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_ACC_EVE_DET,pers.getOID());
    qInsert.setInt(OID_CATEG_EVE_LEG,pers.getCateg_eventual_leg().getOID());
    qInsert.setInt(OID_CATEG_ACCESO,pers.getCategoria().getOID());
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_CATEG_EVE_LEG = 1;
    final int OID_CATEG_ACCESO = 2;
    final int ACTIVO = 3;
    final int OID_ACC_EVE_DET = 4;

    CategEvenAccLegDet pers = (CategEvenAccLegDet) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update cipCategLegEveDet set "+
              "oid_categ_eve_leg=?"+ 
              ",oid_categ_acceso=?"+ 
              ",activo=?"+ 
                 " where " +
                 " oid_acc_eve_det=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_ACC_EVE_DET,pers.getOID());
    qUpdate.setInt(OID_CATEG_EVE_LEG,pers.getCateg_eventual_leg().getOID());
    qUpdate.setInt(OID_CATEG_ACCESO,pers.getCategoria().getOID());
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_ACC_EVE_DET = 1; 
    CategEvenAccLegDet pers = (CategEvenAccLegDet) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update cipCategLegEveDet "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_acc_eve_det=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_ACC_EVE_DET, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_ACC_EVE_DET = 1; 
    CategEvenAccLegDet pers = (CategEvenAccLegDet) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update cipCategLegEveDet "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_acc_eve_det=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_ACC_EVE_DET, pers.getOID()); 
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
      case SELECT_BY_CATEGEVELEG: {
          ps = this.selectByCategEventualLeg(aCondiciones); 
          break; 
      }
    } 
    return ps;
  } 

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_ACC_EVE_DET = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  cipCategLegEveDet "); 
    textSQL.append(" WHERE oid_acc_eve_det = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_ACC_EVE_DET, oid); 
    return querySelect; 
  }

  
  private PreparedStatement selectByCategEventualLeg(Object aCondiciones) throws BaseException, SQLException { 
	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM  cipCategLegEveDet "); 
	    textSQL.append(" WHERE oid_categ_eve_leg = ? and activo = 1 ");
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
	    CategEvenAccesoLeg categEvenAccesoLeg = (CategEvenAccesoLeg) aCondiciones; 
	    querySelect.setInt(1, categEvenAccesoLeg.getOID()); 
	    return querySelect; 
  }
  
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  cipCategLegEveDet "); 
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_acc_eve_det oid, codigo,  descripcion ,activo ");
    textSQL.append(" from cipCategLegEveDet");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  }
  
  public static List getCategEventualesDet(CategEvenAccesoLeg categEvenAccesoLeg,
          ISesion aSesion) throws BaseException {
	  return (List) ObjetoLogico.getObjects(CategEvenAccLegDet.NICKNAME,
             DBCategEvenAccLegDet.SELECT_BY_CATEGEVELEG,
             categEvenAccesoLeg,
             new ListObserver(),
             aSesion);
  }

  
  
} 
