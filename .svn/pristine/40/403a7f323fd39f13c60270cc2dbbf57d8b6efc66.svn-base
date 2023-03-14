package com.srn.erp.reclutamiento.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.reclutamiento.bm.RecluConceptoProceso;
import com.srn.erp.reclutamiento.bm.RecluProceso;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;

public class DBRecluConceptoProceso extends DBObjetoPersistente {

  public static final String OID_CONC_PROCESO = "oid_conc_proceso";
  public static final String OID_PROCESO = "oid_proceso";
  public static final String DESCRIPCION = "descripcion";
  public static final String COSTO = "costo";
  public static final String ACTIVO = "activo";
  public static final String ALTA_EN_BUSQUEDA = "alta_en_busqueda";
  
  private static final int SELECT_BY_PROCESO = 100;  
  private static final int SELECT_HELP_BY_PROCESO = 101;

  public DBRecluConceptoProceso() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_CONC_PROCESO = 1;
    final int OID_PROCESO = 2;
    final int DESCRIPCION = 3;
    final int COSTO = 4;
    final int ACTIVO = 5;
    final int ALTA_EN_BUSQUEDA = 6;

    RecluConceptoProceso pers = (RecluConceptoProceso) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into rsConcProceso "+
                     " ( "+
                      "OID_CONC_PROCESO,"+
                      "OID_PROCESO,"+
                      "DESCRIPCION,"+
                      "COSTO,"+
                      "ACTIVO,ALTA_EN_BUSQUEDA)"+ 
                      " values "+ 
                      "("+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_CONC_PROCESO,pers.getOID());
    qInsert.setInt(OID_PROCESO,pers.getProceso().getOID());
    qInsert.setString(DESCRIPCION,pers.getDescripcion());
    if (pers.getCosto()!=null)
    	qInsert.setDouble(COSTO,pers.getCosto().doubleValue());
    else
    	qInsert.setDouble(COSTO,0);
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    if (pers.isAltaEnBusqueda()!=null)
    	qInsert.setBoolean(ALTA_EN_BUSQUEDA, pers.isAltaEnBusqueda().booleanValue());
    else
    	qInsert.setBoolean(ALTA_EN_BUSQUEDA, false);    
    
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_PROCESO = 1;
    final int DESCRIPCION = 2;
    final int COSTO = 3;
    final int ACTIVO = 4;
    final int ALTA_EN_BUSQUEDA = 5;
    final int OID_CONC_PROCESO = 6;

    RecluConceptoProceso pers = (RecluConceptoProceso) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update rsConcProceso set "+
              "oid_proceso=?"+ 
              ",descripcion=?"+ 
              ",costo=?"+ 
              ",activo=?"+ 
                 " where " +
                 " oid_conc_proceso=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_CONC_PROCESO,pers.getOID());
    qUpdate.setInt(OID_PROCESO,pers.getProceso().getOID());
    qUpdate.setString(DESCRIPCION,pers.getDescripcion());
    if (pers.getCosto()!=null)
    	qUpdate.setDouble(COSTO,pers.getCosto().doubleValue());
    else
    	qUpdate.setDouble(COSTO,0);
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    if (pers.isAltaEnBusqueda()!=null)
    	qUpdate.setBoolean(ALTA_EN_BUSQUEDA, pers.isAltaEnBusqueda().booleanValue());
    else
    	qUpdate.setBoolean(ALTA_EN_BUSQUEDA, false);    
    
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_CONC_PROCESO = 1; 
    RecluConceptoProceso pers = (RecluConceptoProceso) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update rsConcProceso "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_conc_proceso=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_CONC_PROCESO, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_CONC_PROCESO = 1; 
    RecluConceptoProceso pers = (RecluConceptoProceso) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update rsConcProceso "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_conc_proceso=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_CONC_PROCESO, pers.getOID()); 
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
      case SELECT_HELP_BY_PROCESO: {
          ps = this.selectHelpByProceso(aCondiciones); 
          break;    	  
      }
      case SELECT_BY_PROCESO: {
          ps = this.selectByProceso(aCondiciones); 
          break;    	  
      }
    } 
    return ps;
  } 

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_CONC_PROCESO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  rsConcProceso "); 
    textSQL.append(" WHERE oid_conc_proceso = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_CONC_PROCESO, oid); 
    return querySelect; 
  }
  
  private PreparedStatement selectByProceso(Object aCondiciones) throws BaseException, SQLException { 
	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM  rsConcProceso "); 
	    textSQL.append(" WHERE oid_proceso  = ? and activo=1 ");
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
	    RecluProceso proceso = (RecluProceso) aCondiciones;
	    querySelect.setInt(1, proceso.getOID()); 
	    return querySelect; 
  }  
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  rsConcProceso "); 
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  
  private PreparedStatement selectHelpByProceso(Object aCondiciones) throws BaseException, SQLException {

	    StringBuffer textSQL = new StringBuffer();

	    HashTableDatos condiciones = (HashTableDatos) aCondiciones;
	    String oidProceso = condiciones.getString("oid_proceso");
	    
	    textSQL.append("SELECT oid_conc_proceso oid, '' codigo,  descripcion ,activo ");
	    textSQL.append(" from rsConcProceso where oid_proceso = "+oidProceso);
	    
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
	    return querySelect; 
  }  
  
  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();
    
    

    textSQL.append("SELECT oid_conc_proceso oid, '' codigo,  descripcion ,activo ");
    textSQL.append(" from rsConcProceso ");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  }
  
  public static List getConceptos(RecluProceso aRecluProceso,
          ISesion aSesion) throws BaseException {
	  return (List) ObjetoLogico.getObjects(RecluConceptoProceso.NICKNAME,
             DBRecluConceptoProceso.SELECT_BY_PROCESO,
             aRecluProceso,
             new ListObserver(),
             aSesion);
  }  
  
} 
