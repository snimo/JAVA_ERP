package com.srn.erp.tesoreria.da;

import java.sql.*;
import java.util.List;

import com.srn.erp.general.bm.PeriodoInc;
import com.srn.erp.general.bm.PeriodoIncDet;
import com.srn.erp.general.da.DBPeriodoIncDet;
import com.srn.erp.tesoreria.bm.*;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.*;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.*;

public class DBTransferenciaValor extends DBObjetoPersistente {

  public static final String OID_VAL_TRANSF = "oid_val_transf";
  public static final String OID_VALOR = "oid_valor";
  public static final String IMPORTE = "importe";
  public static final String OID_TRANSF_VAL = "oid_transf_val";
  public static final String TRANSFERIDO = "transferido";
  
  public static final int SELECT_BY_COMPRO_TRANSFERENCIA = 100;

  public DBTransferenciaValor() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_VAL_TRANSF = 1;
    final int OID_VALOR = 2;
    final int IMPORTE = 3;
    final int OID_TRANSF_VAL = 4;
    final int TRANSFERIDO = 5;

    TransferenciaValor pers = (TransferenciaValor) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into teTransfVal "+
                     " ( "+
                      "OID_VAL_TRANSF,"+
                      "OID_VALOR,"+
                      "IMPORTE,"+
                      "OID_TRANSF_VAL,"+
                      "TRANSFERIDO)"+ 
                      " values "+ 
                      "("+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_VAL_TRANSF,pers.getOID());
    qInsert.setInt(OID_VALOR,pers.getValor().getOID());
    if (pers.getImporte()!=null)
    	qInsert.setDouble(IMPORTE,pers.getImporte().doubleValue());
    else
    	qInsert.setNull(IMPORTE,Types.DOUBLE);
    qInsert.setInt(OID_TRANSF_VAL,pers.getTransferencia_valores().getOID());
    if (pers.getTransferido()!=null) 
      qInsert.setDouble(TRANSFERIDO,pers.getTransferido().doubleValue());
    else
      qInsert.setNull(TRANSFERIDO,java.sql.Types.DOUBLE);
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_VALOR = 1;
    final int IMPORTE = 2;
    final int OID_TRANSF_VAL = 3;
    final int TRANSFERIDO = 4;
    final int OID_VAL_TRANSF = 5;

    TransferenciaValor pers = (TransferenciaValor) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update teTransfVal set "+
              "oid_valor=?"+ 
              ",importe=?"+ 
              ",oid_transf_val=?"+ 
              ",transferido=?"+ 
                 " where " +
                 " oid_val_transf=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_VAL_TRANSF,pers.getOID());
    qUpdate.setDouble(OID_VALOR,pers.getValor().getOID());
    if (pers.getImporte()!=null)
    	qUpdate.setDouble(IMPORTE,pers.getImporte().doubleValue());
    else
    	qUpdate.setNull(IMPORTE,Types.DOUBLE);
    qUpdate.setInt(OID_TRANSF_VAL,pers.getTransferencia_valores().getOID());
    if (pers.getTransferido()!=null) 
      qUpdate.setDouble(TRANSFERIDO,pers.getTransferido().doubleValue());
    else
      qUpdate.setNull(TRANSFERIDO,java.sql.Types.DOUBLE);
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_VAL_TRANSF = 1; 
    TransferenciaValor pers = (TransferenciaValor) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update teTransfVal "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_val_transf=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_VAL_TRANSF, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_VAL_TRANSF = 1; 
    TransferenciaValor pers = (TransferenciaValor) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update teTransfVal "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_val_transf=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_VAL_TRANSF, pers.getOID()); 
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

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_VAL_TRANSF = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  teTransfVal "); 
    textSQL.append(" WHERE oid_val_transf = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_VAL_TRANSF, oid); 
    return querySelect; 
  }
  
  private PreparedStatement selectByComproTransferencia(Object aCondiciones) throws BaseException, SQLException { 
    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  teTransfVal "); 
    textSQL.append(" WHERE oid_transf_val = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    TransferenciaValores transferenciaValores = (TransferenciaValores) aCondiciones; 
    querySelect.setInt(1, transferenciaValores.getOID()); 
    return querySelect; 
  }
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  teTransfVal "); 
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_val_transf oid, codigo,  descripcion ,activo ");
    textSQL.append(" from teTransfVal");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  } 
  
  public static List getTransferenciasValor(TransferenciaValores transferencia,
      ISesion aSesion) throws BaseException {
  	return (List) ObjetoLogico.getObjects(TransferenciaValor.NICKNAME,
         DBTransferenciaValor.SELECT_BY_COMPRO_TRANSFERENCIA,
         transferencia,
         new ListObserver(),
         aSesion);
  }
  
  
} 
