package com.srn.erp.cip.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.cip.bm.PuntoFichadaCIP;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;

public class DBPuntoFichadaCIP extends DBObjetoPersistente {

  public static final String OID_PTO_FICHADA = "oid_pto_fichada";
  public static final String CODIGO = "codigo";
  public static final String DESCRIPCION = "descripcion";
  public static final String ACTIVO = "activo";
  public static final String ANTIPASSBACK_ENT = "antipassback_ent";
  public static final String ANTIPASSBACK_SAL = "antipassback_sal";

  public DBPuntoFichadaCIP() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_PTO_FICHADA = 1;
    final int CODIGO = 2;
    final int DESCRIPCION = 3;
    final int ACTIVO = 4;
    final int ANTIPASSBACK_ENT = 5;
    final int ANTIPASSBACK_SAL = 6;

    PuntoFichadaCIP pers = (PuntoFichadaCIP) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into cipPtoFichada "+
                     " ( "+
                      "OID_PTO_FICHADA,"+
                      "CODIGO,"+
                      "DESCRIPCION,"+
                      "ACTIVO , antipassback_ent , antipassback_sal)"+ 
                      " values "+ 
                      "("+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_PTO_FICHADA,pers.getOID());
    qInsert.setString(CODIGO,pers.getCodigo());
    qInsert.setString(DESCRIPCION,pers.getDescripcion());
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    if (pers.isAntipassbackEnt()!=null)
    	qInsert.setBoolean(ANTIPASSBACK_ENT,pers.isAntipassbackEnt().booleanValue());
    else
    	qInsert.setBoolean(ANTIPASSBACK_ENT,false);
    if (pers.isAntipassbackSal()!=null)
    	qInsert.setBoolean(ANTIPASSBACK_SAL,pers.isAntipassbackSal().booleanValue());
    else
    	qInsert.setBoolean(ANTIPASSBACK_SAL,false);
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int CODIGO = 1;
    final int DESCRIPCION = 2;
    final int ACTIVO = 3;
    final int ANTIPASSBACK_ENT = 4;
    final int ANTIPASSBACK_SAL = 5;    
    final int OID_PTO_FICHADA = 6;

    PuntoFichadaCIP pers = (PuntoFichadaCIP) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update cipPtoFichada set "+
              "codigo=?"+ 
              ",descripcion=?"+ 
              ",activo=?"+
              ",antipassback_ent=?"+
              ",antipassback_sal=?"+
                 " where " +
                 " oid_pto_fichada=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_PTO_FICHADA,pers.getOID());
    qUpdate.setString(CODIGO,pers.getCodigo());
    qUpdate.setString(DESCRIPCION,pers.getDescripcion());
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    if (pers.isAntipassbackEnt()!=null)
    	qUpdate.setBoolean(ANTIPASSBACK_ENT,pers.isAntipassbackEnt().booleanValue());
    else
    	qUpdate.setBoolean(ANTIPASSBACK_ENT,false);
    if (pers.isAntipassbackSal()!=null)
    	qUpdate.setBoolean(ANTIPASSBACK_SAL,pers.isAntipassbackSal().booleanValue());
    else
    	qUpdate.setBoolean(ANTIPASSBACK_SAL,false);    
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_PTO_FICHADA = 1; 
    PuntoFichadaCIP pers = (PuntoFichadaCIP) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update cipPtoFichada "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_pto_fichada=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_PTO_FICHADA, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_PTO_FICHADA = 1; 
    PuntoFichadaCIP pers = (PuntoFichadaCIP) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update cipPtoFichada "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_pto_fichada=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_PTO_FICHADA, pers.getOID()); 
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
      case IDBObjetoPersistente.SELECT_ALL: { 
          ps = this.selectAll(aCondiciones); 
          break; 
        }      
    } 
    return ps;
  } 

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_PTO_FICHADA = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  cipPtoFichada "); 
    textSQL.append(" WHERE oid_pto_fichada = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_PTO_FICHADA, oid); 
    return querySelect; 
  }
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  cipPtoFichada "); 
    textSQL.append(" WHERE codigo = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }
  
  private PreparedStatement selectAll(Object aCondiciones) throws BaseException, SQLException { 

	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM  cipPtoFichada "); 
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
	    return querySelect;
	    
  }  

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_pto_fichada oid,codigo codigo, descripcion descripcion ,activo ");
    textSQL.append(" from cipPtoFichada");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  }
  
  public static List getAllPuntosFichada(ISesion aSesion) throws BaseException {
	  
	  return (List) ObjetoLogico.getObjects(PuntoFichadaCIP.NICKNAME,
             DBPuntoFichadaCIP.SELECT_ALL,
             null,
             new ListObserver(),
             aSesion);
  }
  
  
} 
