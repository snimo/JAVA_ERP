package com.srn.erp.pagos.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.pagos.bm.AnuladorOPMedPago;
import com.srn.erp.pagos.bm.AnuladorOrdenDePago;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;

public class DBAnuladorOPMedPago extends DBObjetoPersistente {

  public static final String OID_ANU_OP_MP = "oid_anu_op_mp";
  public static final String OID_ANU_OP_CAB = "oid_anu_op_cab";
  public static final String OID_OP_MEDIO_PAGO = "oid_op_medio_pago";
  
  public static final int SELECT_BY_ANU_OP_CAB = 100;

  public DBAnuladorOPMedPago() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_ANU_OP_MP = 1;
    final int OID_ANU_OP_CAB = 2;
    final int OID_OP_MEDIO_PAGO = 3;

    AnuladorOPMedPago pers = (AnuladorOPMedPago) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into opAnuOPMedPag "+
                     " ( "+
                      "OID_ANU_OP_MP,"+
                      "OID_ANU_OP_CAB,"+
                      "OID_OP_MEDIO_PAGO)"+ 
                      " values "+ 
                      "("+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_ANU_OP_MP,pers.getOID());
    qInsert.setInt(OID_ANU_OP_CAB,pers.getAnulador_op_cab().getOID());
    qInsert.setInt(OID_OP_MEDIO_PAGO,pers.getMedio_pago().getOID());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_ANU_OP_CAB = 1;
    final int OID_OP_MEDIO_PAGO = 2;
    final int OID_ANU_OP_MP = 3;

    AnuladorOPMedPago pers = (AnuladorOPMedPago) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update opAnuOPMedPag set "+
              "oid_anu_op_cab=?"+ 
              ",oid_op_medio_pago=?"+ 
                 " where " +
                 " oid_anu_op_mp=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_ANU_OP_MP,pers.getOID());
    qUpdate.setInt(OID_ANU_OP_CAB,pers.getAnulador_op_cab().getOID());
    qUpdate.setInt(OID_OP_MEDIO_PAGO,pers.getMedio_pago().getOID());
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_ANU_OP_MP = 1; 
    AnuladorOPMedPago pers = (AnuladorOPMedPago) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update opAnuOPMedPag "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_anu_op_mp=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_ANU_OP_MP, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_ANU_OP_MP = 1; 
    AnuladorOPMedPago pers = (AnuladorOPMedPago) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update opAnuOPMedPag "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_anu_op_mp=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_ANU_OP_MP, pers.getOID()); 
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
      case SELECT_BY_ANU_OP_CAB: {
        ps = this.selectAnuladorOPCab(aCondiciones); 
        break; 
      }
    } 
    return ps;
  } 

  private PreparedStatement selectAnuladorOPCab(Object aCondiciones) throws BaseException, SQLException { 

  	StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  opAnuOPMedPag "); 
    textSQL.append(" WHERE oid_anu_op_cab = ? "); 
    PreparedStatement querySelect = 
    	getSesion().getConexionBD().prepareStatement(textSQL.toString());
    
    AnuladorOrdenDePago anuOP = (AnuladorOrdenDePago) aCondiciones;
    
    querySelect.setInt(1, anuOP.getOID()); 
    return querySelect; 
  }
  
  
  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_ANU_OP_MP = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  opAnuOPMedPag "); 
    textSQL.append(" WHERE oid_anu_op_mp = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_ANU_OP_MP, oid); 
    return querySelect; 
  }
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  opAnuOPMedPag "); 
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_anu_op_mp oid, codigo,  descripcion ,activo ");
    textSQL.append(" from opAnuOPMedPag");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  } 
  
  public static List getAnuladoresMediosPago(AnuladorOrdenDePago anuladorOP,
      ISesion aSesion) throws BaseException {
  	return (List) ObjetoLogico.getObjects(AnuladorOrdenDePago.NICKNAME,
         DBAnuladorOPMedPago.SELECT_BY_ANU_OP_CAB,
         anuladorOP,
         new ListObserver(),
         aSesion);
  }
  
  
} 
