package com.srn.erp.cip.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.cip.bm.EquivalenciaRotasCIP;
import com.srn.erp.cip.bm.Rota;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;

public class DBEquivalenciaRotasCIP extends DBObjetoPersistente {

  public static final String OID_ROTA_EQUIV = "oid_rota_equiv";
  public static final String OID_ROTA = "oid_rota";
  public static final String CODIGO_EXTERNO = "codigo_externo";
  public static final String ACTIVO = "activo";
  
  public static final int SELECT_BY_ROTA = 100;

  public DBEquivalenciaRotasCIP() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_ROTA_EQUIV = 1;
    final int OID_ROTA = 2;
    final int CODIGO_EXTERNO = 3;
    final int ACTIVO = 4;

    EquivalenciaRotasCIP pers = (EquivalenciaRotasCIP) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into cipRotasEquiv "+
                     " ( "+
                      "OID_ROTA_EQUIV,"+
                      "OID_ROTA,"+
                      "CODIGO_EXTERNO,"+
                      "ACTIVO)"+ 
                      " values "+ 
                      "("+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_ROTA_EQUIV,pers.getOID());
    qInsert.setInt(OID_ROTA,pers.getRota().getOID());
    qInsert.setString(CODIGO_EXTERNO,pers.getCodigo_externo());
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_ROTA = 1;
    final int CODIGO_EXTERNO = 2;
    final int ACTIVO = 3;
    final int OID_ROTA_EQUIV = 4;

    EquivalenciaRotasCIP pers = (EquivalenciaRotasCIP) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update cipRotasEquiv set "+
              "oid_rota=?"+ 
              ",codigo_externo=?"+ 
              ",activo=?"+ 
                 " where " +
                 " oid_rota_equiv=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_ROTA_EQUIV,pers.getOID());
    qUpdate.setInt(OID_ROTA,pers.getRota().getOID());
    qUpdate.setString(CODIGO_EXTERNO,pers.getCodigo_externo());
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_ROTA_EQUIV = 1; 
    EquivalenciaRotasCIP pers = (EquivalenciaRotasCIP) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update cipRotasEquiv "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_rota_equiv=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_ROTA_EQUIV, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_ROTA_EQUIV = 1; 
    EquivalenciaRotasCIP pers = (EquivalenciaRotasCIP) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update cipRotasEquiv "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_rota_equiv=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_ROTA_EQUIV, pers.getOID()); 
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
      case SELECT_BY_ROTA: {
          ps = this.selectByRota(aCondiciones); 
          break;    	  
      }
    } 
    return ps;
  } 

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_ROTA_EQUIV = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  cipRotasEquiv "); 
    textSQL.append(" WHERE oid_rota_equiv = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_ROTA_EQUIV, oid); 
    return querySelect; 
  }
  
  private PreparedStatement selectByRota(Object aCondiciones) throws BaseException, SQLException { 

	StringBuffer textSQL = new StringBuffer(); 
	textSQL.append("SELECT * FROM  cipRotasEquiv "); 
	textSQL.append(" WHERE oid_rota = ? and activo=1 ");
	PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
	Rota rota = (Rota) aCondiciones; 
	querySelect.setInt(1, rota.getOID()); 
	return querySelect; 
	
  }

  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  cipRotasEquiv "); 
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_rota_equiv oid, codigo,  descripcion ,activo ");
    textSQL.append(" from cipRotasEquiv");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  }
  
  public static List getRotasEquivalentes(Rota rota,
          ISesion aSesion) throws BaseException {
	  return (List) ObjetoLogico.getObjects(EquivalenciaRotasCIP.NICKNAME,
             DBEquivalenciaRotasCIP.SELECT_BY_ROTA,
             rota,
             new ListObserver(),
             aSesion);
  }
  
  
} 
