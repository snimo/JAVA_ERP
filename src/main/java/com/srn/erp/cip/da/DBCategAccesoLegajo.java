package com.srn.erp.cip.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.cip.bm.CategAccesoCIP;
import com.srn.erp.cip.bm.CategAccesoLegajo;
import com.srn.erp.general.bm.Periodo;
import com.srn.erp.general.da.DBPeriodo;
import com.srn.erp.sueldos.bm.Legajo;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.ObjetoObservado;

public class DBCategAccesoLegajo extends DBObjetoPersistente {

  public static final String OID_CAT_ACC_LEG = "oid_cat_acc_leg";
  public static final String OID_CATEG_ACCESO = "oid_categ_acceso";
  public static final String OID_LEGAJO = "oid_legajo";
  public static final String ACTIVO = "activo";
  
  public static final int SELECT_BY_LEGAJO = 100;
  public static final int SELECT_BY_CATEGORIA_LEGAJO = 101;
  

  public DBCategAccesoLegajo() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_CAT_ACC_LEG = 1;
    final int OID_CATEG_ACCESO = 2;
    final int OID_LEGAJO = 3;
    final int ACTIVO = 4;

    CategAccesoLegajo pers = (CategAccesoLegajo) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into cipCategAccLeg "+
                     " ( "+
                      "OID_CAT_ACC_LEG,"+
                      "OID_CATEG_ACCESO,"+
                      "OID_LEGAJO,"+
                      "ACTIVO)"+ 
                      " values "+ 
                      "("+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_CAT_ACC_LEG,pers.getOID());
    qInsert.setInt(OID_CATEG_ACCESO,pers.getCategoria().getOID());
    qInsert.setInt(OID_LEGAJO,pers.getLegajo().getOID());
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_CATEG_ACCESO = 1;
    final int OID_LEGAJO = 2;
    final int ACTIVO = 3;
    final int OID_CAT_ACC_LEG = 4;

    CategAccesoLegajo pers = (CategAccesoLegajo) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update cipCategAccLeg set "+
              "oid_categ_acceso=?"+ 
              ",oid_legajo=?"+ 
              ",activo=?"+ 
                 " where " +
                 " oid_cat_acc_leg=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_CAT_ACC_LEG,pers.getOID());
    qUpdate.setInt(OID_CATEG_ACCESO,pers.getCategoria().getOID());
    qUpdate.setInt(OID_LEGAJO,pers.getLegajo().getOID());
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_CAT_ACC_LEG = 1; 
    CategAccesoLegajo pers = (CategAccesoLegajo) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update cipCategAccLeg "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_cat_acc_leg=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_CAT_ACC_LEG, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_CAT_ACC_LEG = 1; 
    CategAccesoLegajo pers = (CategAccesoLegajo) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update cipCategAccLeg "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_cat_acc_leg=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_CAT_ACC_LEG, pers.getOID()); 
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
      case SELECT_BY_LEGAJO: {
          ps = this.selectByLegajo(aCondiciones); 
          break; 
      }
      case SELECT_BY_CATEGORIA_LEGAJO: {
          ps = this.selectByCategoriaLegajo(aCondiciones); 
          break; 
    	  
      }
    } 
    return ps;
  } 

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_CAT_ACC_LEG = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  cipCategAccLeg "); 
    textSQL.append(" WHERE oid_cat_acc_leg = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_CAT_ACC_LEG, oid); 
    return querySelect; 
  }

  private PreparedStatement selectByCategoriaLegajo(Object aCondiciones) throws BaseException, SQLException { 
	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM  cipCategAccLeg "); 
	    textSQL.append(" WHERE oid_legajo = ? and oid_categ_acceso = ? and activo = 1 ");
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
	    HashTableDatos condiciones = (HashTableDatos) aCondiciones;
	    Legajo legajo = (Legajo) condiciones.get(Legajo.NICKNAME);
	    CategAccesoCIP categoria = (CategAccesoCIP) condiciones.get(CategAccesoCIP.NICKNAME);
	    
	    querySelect.setInt(1, legajo.getOID()); 
	    querySelect.setInt(2, categoria.getOID());
	    
	    return querySelect; 
  }
  

  private PreparedStatement selectByLegajo(Object aCondiciones) throws BaseException, SQLException { 
	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM  cipCategAccLeg "); 
	    textSQL.append(" WHERE oid_legajo = ? ");
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
	    Legajo legajo = (Legajo) aCondiciones; 
	    querySelect.setInt(1, legajo.getOID()); 
	    return querySelect; 
  }
  
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  cipCategAccLeg "); 
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_cat_acc_leg oid, codigo,  descripcion ,activo ");
    textSQL.append(" from cipCategAccLeg");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  } 
  
  public static List getCategAccesosLegajo(Legajo aLegajo,
          ISesion aSesion) throws BaseException {
	  return (List) ObjetoLogico.getObjects(CategAccesoLegajo.NICKNAME,
             DBCategAccesoLegajo.SELECT_BY_LEGAJO,
             aLegajo,
             new ListObserver(),
             aSesion);
  }
  
  public static CategAccesoLegajo getCategAccesoLegajo(CategAccesoCIP aCategAccesoCIP,
		  											   Legajo legajo,	
		                                               ISesion aSesion)
          throws BaseException {
	  HashTableDatos condiciones = new HashTableDatos();
	  condiciones.put(CategAccesoCIP.NICKNAME, aCategAccesoCIP);
	  condiciones.put(Legajo.NICKNAME, legajo);
	  
	  return (CategAccesoLegajo) ObjetoLogico.getObjects(CategAccesoLegajo.NICKNAME,
			  				DBCategAccesoLegajo.SELECT_BY_CATEGORIA_LEGAJO,
			  				condiciones,
			  				new ObjetoObservado(),
			  				aSesion);
  }
  
  
  
} 
