package com.srn.erp.tesoreria.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.general.bm.PeriodoIncDet;
import com.srn.erp.general.da.DBPeriodoIncDet;
import com.srn.erp.tesoreria.bm.TransferenciaEfectivo;
import com.srn.erp.tesoreria.bm.TransferenciaValores;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;

public class DBTransferenciaEfectivo extends DBObjetoPersistente {

  public static final String OID_TRANS_EFE = "oid_trans_efe";
  public static final String OID_TRANSF_VAL = "oid_transf_val";
  public static final String OID_TIPO_VALOR = "oid_tipo_valor";
  public static final String SALDO = "saldo";
  public static final String TRANSFERIDO = "transferido";
  
  public static final int SELECT_BY_COMPRO_TRANSFERENCIA = 100;

  public DBTransferenciaEfectivo() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_TRANS_EFE = 1;
    final int OID_TRANSF_VAL = 2;
    final int OID_TIPO_VALOR = 3;
    final int SALDO = 4;
    final int TRANSFERIDO = 5;

    TransferenciaEfectivo pers = (TransferenciaEfectivo) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into teTransfEfe "+
                     " ( "+
                      "OID_TRANS_EFE,"+
                      "OID_TRANSF_VAL,"+
                      "OID_TIPO_VALOR,"+
                      "SALDO,"+
                      "TRANSFERIDO)"+ 
                      " values "+ 
                      "("+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_TRANS_EFE,pers.getOID());
    qInsert.setInt(OID_TRANSF_VAL,pers.getTransferencia_valores().getOID());
    qInsert.setInt(OID_TIPO_VALOR,pers.getTipo_valor().getOID());
    if (pers.getSaldo()!=null) 
      qInsert.setDouble(SALDO,pers.getSaldo().doubleValue());
    else
      qInsert.setNull(SALDO,java.sql.Types.DOUBLE);
    if (pers.getTransferido()!=null) 
      qInsert.setDouble(TRANSFERIDO,pers.getTransferido().doubleValue());
    else
      qInsert.setNull(TRANSFERIDO,java.sql.Types.DOUBLE);
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_TRANSF_VAL = 1;
    final int OID_TIPO_VALOR = 2;
    final int SALDO = 3;
    final int TRANSFERIDO = 4;
    final int OID_TRANS_EFE = 5;

    TransferenciaEfectivo pers = (TransferenciaEfectivo) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update teTransfEfe set "+
              "oid_transf_val=?"+ 
              ",oid_tipo_valor=?"+ 
              ",saldo=?"+ 
              ",transferido=?"+ 
                 " where " +
                 " oid_trans_efe=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_TRANS_EFE,pers.getOID());
    qUpdate.setInt(OID_TRANSF_VAL,pers.getTransferencia_valores().getOID());
    qUpdate.setInt(OID_TIPO_VALOR,pers.getTipo_valor().getOID());
    if (pers.getSaldo()!=null) 
      qUpdate.setDouble(SALDO,pers.getSaldo().doubleValue());
    else
      qUpdate.setNull(SALDO,java.sql.Types.DOUBLE);
    if (pers.getTransferido()!=null) 
      qUpdate.setDouble(TRANSFERIDO,pers.getTransferido().doubleValue());
    else
      qUpdate.setNull(TRANSFERIDO,java.sql.Types.DOUBLE);
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_TRANS_EFE = 1; 
    TransferenciaEfectivo pers = (TransferenciaEfectivo) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update teTransfEfe "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_trans_efe=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_TRANS_EFE, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_TRANS_EFE = 1; 
    TransferenciaEfectivo pers = (TransferenciaEfectivo) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update teTransfEfe "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_trans_efe=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_TRANS_EFE, pers.getOID()); 
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
      case SELECT_BY_COMPRO_TRANSFERENCIA: {
        ps = this.selectByComproTransferencia(aCondiciones); 
        break; 
      }
    } 
    return ps;
  } 

  private PreparedStatement selectByComproTransferencia(Object aCondiciones) throws BaseException, SQLException { 
    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  teTransfEfe "); 
    textSQL.append(" WHERE oid_transf_val = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    
    TransferenciaValores transferencia = (TransferenciaValores) aCondiciones;
    querySelect.setInt(1, transferencia.getOID()); 
    return querySelect; 
  }
  
  
  
  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_TRANS_EFE = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  teTransfEfe "); 
    textSQL.append(" WHERE oid_trans_efe = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_TRANS_EFE, oid); 
    return querySelect; 
  }
  
  
  
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  teTransfEfe "); 
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_trans_efe oid, codigo,  descripcion ,activo ");
    textSQL.append(" from teTransfEfe");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  } 
  
  public static List getTransferenciasEfectivo(TransferenciaValores transferencia,
      ISesion aSesion) throws BaseException {
  	return (List) ObjetoLogico.getObjects(TransferenciaEfectivo.NICKNAME,
         DBTransferenciaEfectivo.SELECT_BY_COMPRO_TRANSFERENCIA,
         transferencia,
         new ListObserver(),
         aSesion);
  }
  
  
} 
