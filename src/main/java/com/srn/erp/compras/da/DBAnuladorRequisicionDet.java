package com.srn.erp.compras.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.compras.bm.AnuladorRequisicionCab;
import com.srn.erp.compras.bm.AnuladorRequisicionDet;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;

public class DBAnuladorRequisicionDet extends DBObjetoPersistente {

  public static final String OID_ANU_REQ_DET = "oid_anu_req_det";
  public static final String OID_ANU_REQ_CAB = "oid_anu_req_cab";
  public static final String OID_REQ_DET = "oid_req_det";
  
  public static final int SELECT_BY_ANU_REQUI_CAB = 100;

  public DBAnuladorRequisicionDet() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_ANU_REQ_DET = 1;
    final int OID_ANU_REQ_CAB = 2;
    final int OID_REQ_DET = 3;

    AnuladorRequisicionDet pers = (AnuladorRequisicionDet) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into cpAnuRequiDet "+
                     " ( "+
                      "OID_ANU_REQ_DET,"+
                      "OID_ANU_REQ_CAB,"+
                      "OID_REQ_DET)"+ 
                      " values "+ 
                      "("+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_ANU_REQ_DET,pers.getOID());
    qInsert.setInt(OID_ANU_REQ_CAB,pers.getAnulador_req_cab().getOID());
    qInsert.setInt(OID_REQ_DET,pers.getRequisicion_det().getOID());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_ANU_REQ_CAB = 1;
    final int OID_REQ_DET = 2;
    final int OID_ANU_REQ_DET = 3;

    AnuladorRequisicionDet pers = (AnuladorRequisicionDet) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update cpAnuRequiDet set "+
              "oid_anu_req_cab=?"+ 
              ",oid_req_det=?"+ 
                 " where " +
                 " oid_anu_req_det=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_ANU_REQ_DET,pers.getOID());
    qUpdate.setInt(OID_ANU_REQ_CAB,pers.getAnulador_req_cab().getOID());
    qUpdate.setInt(OID_REQ_DET,pers.getRequisicion_det().getOID());
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_ANU_REQ_DET = 1; 
    AnuladorRequisicionDet pers = (AnuladorRequisicionDet) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update cpAnuRequiDet "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_anu_req_det=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_ANU_REQ_DET, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_ANU_REQ_DET = 1; 
    AnuladorRequisicionDet pers = (AnuladorRequisicionDet) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update cpAnuRequiDet "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_anu_req_det=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_ANU_REQ_DET, pers.getOID()); 
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
      case SELECT_BY_ANU_REQUI_CAB: {
          ps = this.selectByRequisicionCab(aCondiciones); 
          break; 
      }
    } 
    return ps;
  } 

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_ANU_REQ_DET = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  cpAnuRequiDet "); 
    textSQL.append(" WHERE oid_anu_req_det = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_ANU_REQ_DET, oid); 
    return querySelect; 
  }
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  cpAnuRequiDet "); 
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }
  
  private PreparedStatement selectByRequisicionCab(Object aCondiciones) throws BaseException, SQLException { 

	    AnuladorRequisicionCab anuladorRequiCab = (AnuladorRequisicionCab) aCondiciones;
	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM  cpAnuRequiDet "); 
	    textSQL.append(" WHERE oid_anu_req_cab = ? ");
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
	    querySelect.setInt(1, anuladorRequiCab.getOID()); 
	    return querySelect; 
  }
  

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_anu_req_det oid, codigo,  descripcion ,activo ");
    textSQL.append(" from cpAnuRequiDet");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  }
  
  public static List getDetalles(AnuladorRequisicionCab anuladorRequisicionCab,
          ISesion aSesion) throws BaseException {
	  return (List) ObjetoLogico.getObjects(AnuladorRequisicionDet.NICKNAME,
             DBAnuladorRequisicionDet.SELECT_BY_ANU_REQUI_CAB,
             anuladorRequisicionCab,
             new ListObserver(),
             aSesion);
  }
  
  
} 
