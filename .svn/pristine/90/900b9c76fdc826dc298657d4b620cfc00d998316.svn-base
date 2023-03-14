package com.srn.erp.reclutamiento.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.srn.erp.reclutamiento.bm.RecluResultBusqCandi;

import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class DBRecluResultBusqCandi extends DBObjetoPersistente {

  public static final String OID_RESULT_BUSQ = "oid_result_busq";
  public static final String NRO_LOTE = "nro_lote";
  public static final String OID_OBJ_NEG = "oid_obj_neg";
  public static final String FEC_ALTA = "fec_alta";
  public static final String ACTIVO = "activo";
  public static final String NRO_ORDEN = "nro_orden";

  public DBRecluResultBusqCandi() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_RESULT_BUSQ = 1;
    final int NRO_LOTE = 2;
    final int OID_OBJ_NEG = 3;
    final int FEC_ALTA = 4;
    final int ACTIVO = 5;
    final int NRO_ORDEN = 6;

    RecluResultBusqCandi pers = (RecluResultBusqCandi) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into rsResulBusq "+
                     " ( "+
                      "OID_RESULT_BUSQ,"+
                      "NRO_LOTE,"+
                      "OID_OBJ_NEG,"+
                      "FEC_ALTA,"+
                      "ACTIVO,NRO_ORDEN)"+ 
                      " values "+ 
                      "("+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_RESULT_BUSQ,pers.getOID());
    qInsert.setInt(NRO_LOTE,pers.getNro_lote().intValue());
    qInsert.setInt(OID_OBJ_NEG,pers.getOid_obj_neg().intValue());
    qInsert.setDate(FEC_ALTA,new java.sql.Date(pers.getFec_alta().getTime()));
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qInsert.setInt(NRO_ORDEN, pers.getNro_Orden());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int NRO_LOTE = 1;
    final int OID_OBJ_NEG = 2;
    final int FEC_ALTA = 3;
    final int ACTIVO = 4;
    final int NRO_ORDEN = 5;
    final int OID_RESULT_BUSQ = 6;

    RecluResultBusqCandi pers = (RecluResultBusqCandi) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update rsResulBusq set "+
              "nro_lote=?"+ 
              ",oid_obj_neg=?"+ 
              ",fec_alta=?"+ 
              ",activo=?"+ 
              ",nro_orden=?"+
                 " where " +
                 " oid_result_busq=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_RESULT_BUSQ,pers.getOID());
    qUpdate.setInt(NRO_LOTE,pers.getNro_lote().intValue());
    qUpdate.setInt(OID_OBJ_NEG,pers.getOid_obj_neg().intValue());
    qUpdate.setDate(FEC_ALTA,new java.sql.Date(pers.getFec_alta().getTime()));
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.setInt(NRO_ORDEN, pers.getNro_Orden());
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_RESULT_BUSQ = 1; 
    RecluResultBusqCandi pers = (RecluResultBusqCandi) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update rsResulBusq "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_result_busq=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_RESULT_BUSQ, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_RESULT_BUSQ = 1; 
    RecluResultBusqCandi pers = (RecluResultBusqCandi) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update rsResulBusq "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_result_busq=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_RESULT_BUSQ, pers.getOID()); 
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
    } 
    return ps;
  } 

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_RESULT_BUSQ = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  rsResulBusq "); 
    textSQL.append(" WHERE oid_result_busq = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_RESULT_BUSQ, oid); 
    return querySelect; 
  }
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  rsResulBusq "); 
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_result_busq oid, codigo,  descripcion ,activo ");
    textSQL.append(" from rsResulBusq");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  } 
  
} 
