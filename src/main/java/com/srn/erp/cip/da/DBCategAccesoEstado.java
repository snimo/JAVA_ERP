package com.srn.erp.cip.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.cip.bm.CategAccesoCIP;
import com.srn.erp.cip.bm.CategAccesoEstado;
import com.srn.erp.cip.bm.EstadoCIP;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.ObjetoObservado;

public class DBCategAccesoEstado extends DBObjetoPersistente {

  public static final String OID_ACC_EST = "oid_acc_est";
  public static final String OID_ESTADO = "oid_estado";
  public static final String OID_CATEG_ACCESO = "oid_categ_acceso";
  public static final String ACTIVO = "activo";
  
  public static final int SELECT_BY_ESTADO = 100;
  public static final int SELECT_BY_ESTADO_CATEGORIA = 101;

  public DBCategAccesoEstado() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_ACC_EST = 1;
    final int OID_ESTADO = 2;
    final int OID_CATEG_ACCESO = 3;
    final int ACTIVO = 4;

    CategAccesoEstado pers = (CategAccesoEstado) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into cipCategAccEstado "+
                     " ( "+
                      "OID_ACC_EST,"+
                      "OID_ESTADO,"+
                      "OID_CATEG_ACCESO,"+
                      "ACTIVO)"+ 
                      " values "+ 
                      "("+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_ACC_EST,pers.getOID());
    qInsert.setInt(OID_ESTADO,pers.getEstado().getOID());
    qInsert.setInt(OID_CATEG_ACCESO,pers.getCategoria().getOID());
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_ESTADO = 1;
    final int OID_CATEG_ACCESO = 2;
    final int ACTIVO = 3;
    final int OID_ACC_EST = 4;

    CategAccesoEstado pers = (CategAccesoEstado) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update cipCategAccEstado set "+
              "oid_estado=?"+ 
              ",oid_categ_acceso=?"+ 
              ",activo=?"+ 
                 " where " +
                 " oid_acc_est=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_ACC_EST,pers.getOID());
    qUpdate.setInt(OID_ESTADO,pers.getEstado().getOID());
    qUpdate.setInt(OID_CATEG_ACCESO,pers.getCategoria().getOID());
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_ACC_EST = 1; 
    CategAccesoEstado pers = (CategAccesoEstado) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update cipCategAccEstado "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_acc_est=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_ACC_EST, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_ACC_EST = 1; 
    CategAccesoEstado pers = (CategAccesoEstado) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update cipCategAccEstado "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_acc_est=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_ACC_EST, pers.getOID()); 
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
      case SELECT_BY_ESTADO: {
          ps = this.selectByEstado(aCondiciones); 
          break; 
      }
      case SELECT_BY_ESTADO_CATEGORIA: {
          ps = this.selectByEstadoCategoria(aCondiciones); 
          break; 
      }
    } 
    return ps;
  } 

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_ACC_EST = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  cipCategAccEstado "); 
    textSQL.append(" WHERE oid_acc_est = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_ACC_EST, oid); 
    return querySelect; 
  }

  private PreparedStatement selectByEstadoCategoria(Object aCondiciones) throws BaseException, SQLException { 
	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM  cipCategAccEstado "); 
	    textSQL.append(" WHERE oid_estado = ? and oid_categ_acceso = ? and activo = 1 ");
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
	    HashTableDatos condiciones = (HashTableDatos) aCondiciones;
	    EstadoCIP estado = (EstadoCIP) condiciones.get(EstadoCIP.NICKNAME);
	    CategAccesoCIP categoria = (CategAccesoCIP) condiciones.get(CategAccesoCIP.NICKNAME);
	    querySelect.setInt(1, estado.getOID()); 
	    querySelect.setInt(2, categoria.getOID());
	    return querySelect; 
  }
  
  private PreparedStatement selectByEstado(Object aCondiciones) throws BaseException, SQLException { 
	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM  cipCategAccEstado "); 
	    textSQL.append(" WHERE oid_estado = ? and activo = 1 ");
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
	    EstadoCIP estado = (EstadoCIP) aCondiciones;
	    querySelect.setInt(1, estado.getOID()); 
	    return querySelect; 
  }
  
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  cipCategAccEstado "); 
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_acc_est oid, codigo,  descripcion ,activo ");
    textSQL.append(" from cipCategAccEstado");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  }
  
  public static List getCategAccesoEstados(
		  EstadoCIP estado,
          ISesion aSesion) throws BaseException {
	  return (List) ObjetoLogico.getObjects(CategAccesoEstado.NICKNAME,
             DBCategAccesoEstado.SELECT_BY_ESTADO,
             estado,
             new ListObserver(),
             aSesion);
  }
  
  public static CategAccesoEstado getCategAccesoEstado(
		  EstadoCIP estado,
		  CategAccesoCIP categoria,
          ISesion aSesion)
          throws BaseException {
	  HashTableDatos condiciones = new HashTableDatos();
	  condiciones.put(EstadoCIP.NICKNAME, estado);
	  condiciones.put(CategAccesoCIP.NICKNAME, categoria);
	  return (CategAccesoEstado) ObjetoLogico.getObjects(CategAccesoEstado.NICKNAME,
			  				DBCategAccesoEstado.SELECT_BY_ESTADO_CATEGORIA,
			  				condiciones,
			  				new ObjetoObservado(),
			  				aSesion);
  }
  
  
  
  
  
  
} 
