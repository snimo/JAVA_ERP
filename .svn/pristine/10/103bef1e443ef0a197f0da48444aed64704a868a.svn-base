package com.srn.erp.stock.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.stock.bm.AgrupadorDeposito;
import com.srn.erp.stock.bm.AgrupadorDepositoDet;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;

public class DBAgrupadorDepositoDet extends DBObjetoPersistente {

  public static final String OID_AGRUPADOR_DET = "oid_agrupador_det";
  public static final String OID_AGRUPADOR_DEPO = "oid_agrupador_depo";
  public static final String OID_DEPOSITO = "oid_deposito";
  public static final String ACTIVO = "activo";
  
  public static final int SELECT_BY_AGRUPADOR_DEPOSITO = 100;

  public DBAgrupadorDepositoDet() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_AGRUPADOR_DET = 1;
    final int OID_AGRUPADOR_DEPO = 2;
    final int OID_DEPOSITO = 3;
    final int ACTIVO = 4;

    AgrupadorDepositoDet pers = (AgrupadorDepositoDet) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into skAgrupadorDepDet "+
                     " ( "+
                      "OID_AGRUPADOR_DET,"+
                      "OID_AGRUPADOR_DEPO,"+
                      "OID_DEPOSITO,"+
                      "ACTIVO)"+ 
                      " values "+ 
                      "("+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_AGRUPADOR_DET,pers.getOID());
    qInsert.setInt(OID_AGRUPADOR_DEPO,pers.getAgrupador_deposito().getOID());
    qInsert.setInt(OID_DEPOSITO,pers.getDeposito().getOID());
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_AGRUPADOR_DEPO = 1;
    final int OID_DEPOSITO = 2;
    final int ACTIVO = 3;
    final int OID_AGRUPADOR_DET = 4;

    AgrupadorDepositoDet pers = (AgrupadorDepositoDet) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update skAgrupadorDepDet set "+
              "oid_agrupador_depo=?"+ 
              ",oid_deposito=?"+ 
              ",activo=?"+ 
                 " where " +
                 " oid_agrupador_det=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_AGRUPADOR_DET,pers.getOID());
    qUpdate.setInt(OID_AGRUPADOR_DEPO,pers.getAgrupador_deposito().getOID());
    qUpdate.setInt(OID_DEPOSITO,pers.getDeposito().getOID());
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_AGRUPADOR_DET = 1; 
    AgrupadorDepositoDet pers = (AgrupadorDepositoDet) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("delete from skAgrupadorDepDet "+
                     " where " + 
                     " oid_agrupador_det=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_AGRUPADOR_DET, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_AGRUPADOR_DET = 1; 
    AgrupadorDepositoDet pers = (AgrupadorDepositoDet) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update skAgrupadorDepDet "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_agrupador_det=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_AGRUPADOR_DET, pers.getOID()); 
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
      case SELECT_BY_AGRUPADOR_DEPOSITO : {
        ps = this.selectByAgrupadorDeposito(aCondiciones); 
        break; 
      }
    } 
    return ps;
  } 

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_AGRUPADOR_DET = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  skAgrupadorDepDet "); 
    textSQL.append(" WHERE oid_agrupador_det = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_AGRUPADOR_DET, oid); 
    return querySelect; 
  }
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  skAgrupadorDepDet "); 
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }
  
  private PreparedStatement selectByAgrupadorDeposito(Object aCondiciones) throws BaseException, SQLException { 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  skAgrupadorDepDet "); 
    textSQL.append(" WHERE oid_agrupador_depo = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    AgrupadorDeposito agrupadorDeposito = (AgrupadorDeposito) aCondiciones; 
    querySelect.setInt(1, agrupadorDeposito.getOID()); 
    return querySelect; 
  }
  

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_agrupador_det oid, codigo,  descripcion ,activo ");
    textSQL.append(" from skAgrupadorDepDet");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  }
  
  public static List getDetallesAgrupadorDeposito(AgrupadorDeposito aAgrupadorDeposito,
      ISesion aSesion) throws BaseException {
  	return (List) ObjetoLogico.getObjects(AgrupadorDepositoDet.NICKNAME,
        DBAgrupadorDepositoDet.SELECT_BY_AGRUPADOR_DEPOSITO,
        aAgrupadorDeposito,
        new ListObserver(),
        aSesion);
  }
  
  
} 
