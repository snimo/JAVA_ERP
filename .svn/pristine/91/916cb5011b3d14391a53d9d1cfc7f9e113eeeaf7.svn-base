package com.srn.erp.general.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.general.bm.MotivoTC;
import com.srn.erp.general.bm.TipoComprobante;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;

public class DBMotivoTC extends DBObjetoPersistente {

  public static final String OID_MOTIVO_TC = "oid_motivo_tc";
  public static final String OID_MOTIVO_COMPRO = "oid_motivo_compro";
  public static final String OID_TC = "oid_tc";
  public static final String ACTIVO = "activo";
  
  public static final int SELECT_BY_COMPO_RBO = 100;  
  public static final int SELECT_BY_TC = 101; 

  public DBMotivoTC() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_MOTIVO_TC = 1;
    final int OID_MOTIVO_COMPRO = 2;
    final int OID_TC = 3;
    final int ACTIVO = 4;

    MotivoTC pers = (MotivoTC) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into geMotivosTC "+
                     " ( "+
                      "OID_MOTIVO_TC,"+
                      "OID_MOTIVO_COMPRO,"+
                      "OID_TC,"+
                      "ACTIVO)"+ 
                      " values "+ 
                      "("+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_MOTIVO_TC,pers.getOID());
    qInsert.setInt(OID_MOTIVO_COMPRO,pers.getMotivo_comprobante().getOID());
    qInsert.setInt(OID_TC,pers.getTipo_comprobate().getOID());
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_MOTIVO_COMPRO = 1;
    final int OID_TC = 2;
    final int ACTIVO = 3;
    final int OID_MOTIVO_TC = 4;

    MotivoTC pers = (MotivoTC) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update geMotivosTC set "+
              "oid_motivo_compro=?"+ 
              ",oid_tc=?"+ 
              ",activo=?"+ 
                 " where " +
                 " oid_motivo_tc=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_MOTIVO_TC,pers.getOID());
    qUpdate.setInt(OID_MOTIVO_COMPRO,pers.getMotivo_comprobante().getOID());
    qUpdate.setInt(OID_TC,pers.getTipo_comprobate().getOID());
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_MOTIVO_TC = 1; 
    MotivoTC pers = (MotivoTC) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update geMotivosTC "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_motivo_tc=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_MOTIVO_TC, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_MOTIVO_TC = 1; 
    MotivoTC pers = (MotivoTC) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update geMotivosTC "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_motivo_tc=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_MOTIVO_TC, pers.getOID()); 
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
      case SELECT_BY_TC: {
          ps = this.selectByTC(aCondiciones); 
          break; 
      }
      case SELECT_BY_COMPO_RBO: {
        ps = this.selectByComportamientoRBO(aCondiciones); 
        break; 
      }
    } 
    return ps;
  } 

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_MOTIVO_TC = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  geMotivosTC "); 
    textSQL.append(" WHERE oid_motivo_tc = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_MOTIVO_TC, oid); 
    return querySelect; 
  }
  
  private PreparedStatement selectByTC(Object aCondiciones) throws BaseException, SQLException { 
	 StringBuffer textSQL = new StringBuffer(); 
	 textSQL.append("SELECT * FROM  geMotivosTC "); 
	 textSQL.append(" WHERE oid_tc = ? ");
	 PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
	 TipoComprobante tipoComprobante = (TipoComprobante) aCondiciones; 
	 querySelect.setInt(1, tipoComprobante.getOID()); 
	 return querySelect; 
  }
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  geMotivosTC "); 
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }
      
  private PreparedStatement selectByComportamientoRBO(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append(" select * ");
    textSQL.append(" from geMotivosTC where oid_tc in (select oid_tc from geTipoCompro where identificacion='RECIB')  ");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  } 

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_motivo_tc oid, codigo, oid_tc descripcion ,activo ");
    textSQL.append(" from geMotivosTC");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  } 
  
  public static List getMotivosPorTC(TipoComprobante tipoComprobante,
          ISesion aSesion) throws BaseException {
    return (List) ObjetoLogico.getObjects(MotivoTC.NICKNAME,
             DBMotivoTC.SELECT_BY_TC,
             tipoComprobante,
             new ListObserver(),
             aSesion);
  }
  
  public static List getMotivosRecibos(
      ISesion aSesion) throws BaseException {
  	return (List) ObjetoLogico.getObjects(MotivoTC.NICKNAME,
         DBMotivoTC.SELECT_BY_COMPO_RBO,
         null,
         new ListObserver(),
         aSesion);
  }
   
  
  
  
} 
