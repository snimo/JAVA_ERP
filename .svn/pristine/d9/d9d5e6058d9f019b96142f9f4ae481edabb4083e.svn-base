package com.srn.erp.pagos.da;

import java.sql.*;
import java.util.List;

import com.srn.erp.general.bm.PeriodoInc;
import com.srn.erp.general.bm.PeriodoIncDet;
import com.srn.erp.general.da.DBPeriodoIncDet;
import com.srn.erp.pagos.bm.*;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.*;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.*;

public class DBAnuladorRendFFComproProv extends DBObjetoPersistente {

  public static final String OID_ANU_FF_PROV = "oid_anu_ff_prov";
  public static final String OID_ANU_REND_FF = "oid_anu_rend_ff";
  public static final String OID_REND_FF_DET = "oid_rend_ff_det";
  
  public static final int SELECT_BY_ANU_REND_FF = 100;

  public DBAnuladorRendFFComproProv() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_ANU_FF_PROV = 1;
    final int OID_ANU_REND_FF = 2;
    final int OID_REND_FF_DET = 3;

    AnuladorRendFFComproProv pers = (AnuladorRendFFComproProv) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into opAnuFFProv "+
                     " ( "+
                      "OID_ANU_FF_PROV,"+
                      "OID_ANU_REND_FF,"+
                      "OID_REND_FF_DET)"+ 
                      " values "+ 
                      "("+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_ANU_FF_PROV,pers.getOID());
    qInsert.setInt(OID_ANU_REND_FF,pers.getAnulador_rend_ff().getOID());
    qInsert.setInt(OID_REND_FF_DET,pers.getRendicion_ff_det().getOID());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_ANU_REND_FF = 1;
    final int OID_REND_FF_DET = 2;
    final int OID_ANU_FF_PROV = 3;

    AnuladorRendFFComproProv pers = (AnuladorRendFFComproProv) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update opAnuFFProv set "+
              "oid_anu_rend_ff=?"+ 
              ",oid_rend_ff_det=?"+ 
                 " where " +
                 " oid_anu_ff_prov=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_ANU_FF_PROV,pers.getOID());
    qUpdate.setInt(OID_ANU_REND_FF,pers.getAnulador_rend_ff().getOID());
    qUpdate.setInt(OID_REND_FF_DET,pers.getRendicion_ff_det().getOID());
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_ANU_FF_PROV = 1; 
    AnuladorRendFFComproProv pers = (AnuladorRendFFComproProv) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update opAnuFFProv "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_anu_ff_prov=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_ANU_FF_PROV, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_ANU_FF_PROV = 1; 
    AnuladorRendFFComproProv pers = (AnuladorRendFFComproProv) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update opAnuFFProv "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_anu_ff_prov=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_ANU_FF_PROV, pers.getOID()); 
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
      case SELECT_BY_ANU_REND_FF: {
        ps = this.selectByAnuRendFF(aCondiciones); 
        break; 
      }
    } 
    return ps;
  } 

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_ANU_FF_PROV = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  opAnuFFProv "); 
    textSQL.append(" WHERE oid_anu_ff_prov = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_ANU_FF_PROV, oid); 
    return querySelect; 
  }
  
  private PreparedStatement selectByAnuRendFF(Object aCondiciones) throws BaseException, SQLException { 
    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  opAnuFFProv "); 
    textSQL.append(" WHERE oid_anu_rend_ff = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    AnuladorRendFF anuladorRendFF = ( (AnuladorRendFF) aCondiciones); 
    querySelect.setInt(1, anuladorRendFF.getOID()); 
    return querySelect; 
  }
  
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  opAnuFFProv "); 
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_anu_ff_prov oid, codigo,  descripcion ,activo ");
    textSQL.append(" from opAnuFFProv");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  } 
  
  public static List getComproProvAnulados(AnuladorRendFF anuladorRendFF,
      ISesion aSesion) throws BaseException {
  	return (List) ObjetoLogico.getObjects(AnuladorRendFFComproProv.NICKNAME,
         DBAnuladorRendFFComproProv.SELECT_BY_ANU_REND_FF,
         anuladorRendFF,
         new ListObserver(),
         aSesion);
  }
  
  
} 
