package com.srn.erp.contabilidad.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.contabilidad.bm.Subdiario;
import com.srn.erp.contabilidad.bm.SubdiarioDet;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;

public class DBSubdiarioDet extends DBObjetoPersistente {

  public static final String OID_SUBDIARIO_DET = "oid_subdiario_det";
  public static final String OID_SUBDIARIO = "oid_subdiario";
  public static final String OID_ANA_CON = "oid_ana_con";
  public static final String ACTIVO = "activo";
  
  public static final int SELECT_BY_SUBDIARIO = 100;

  public DBSubdiarioDet() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_SUBDIARIO_DET = 1;
    final int OID_SUBDIARIO = 2;
    final int OID_ANA_CON = 3;
    final int ACTIVO = 4;

    SubdiarioDet pers = (SubdiarioDet) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into cgSubDiarioDet "+
                     " ( "+
                      "OID_SUBDIARIO_DET,"+
                      "OID_SUBDIARIO,"+
                      "OID_ANA_CON,"+
                      "ACTIVO)"+ 
                      " values "+ 
                      "("+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_SUBDIARIO_DET,pers.getOID());
    qInsert.setInt(OID_SUBDIARIO,pers.getSubdiario().getOID());
    qInsert.setInt(OID_ANA_CON,pers.getCuenta().getOID());
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_SUBDIARIO = 1;
    final int OID_ANA_CON = 2;
    final int ACTIVO = 3;
    final int OID_SUBDIARIO_DET = 4;

    SubdiarioDet pers = (SubdiarioDet) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update cgSubDiarioDet set "+
              "oid_subdiario=?"+ 
              ",oid_ana_con=?"+ 
              ",activo=?"+ 
                 " where " +
                 " oid_subdiario_det=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_SUBDIARIO_DET,pers.getOID());
    qUpdate.setInt(OID_SUBDIARIO,pers.getSubdiario().getOID());
    qUpdate.setInt(OID_ANA_CON,pers.getCuenta().getOID());
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_SUBDIARIO_DET = 1; 
    SubdiarioDet pers = (SubdiarioDet) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update cgSubDiarioDet "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_subdiario_det=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_SUBDIARIO_DET, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_SUBDIARIO_DET = 1; 
    SubdiarioDet pers = (SubdiarioDet) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update cgSubDiarioDet "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_subdiario_det=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_SUBDIARIO_DET, pers.getOID()); 
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
      case SELECT_BY_SUBDIARIO: {
          ps = this.selectBySubDiario(aCondiciones); 
          break; 
      }
    } 
    return ps;
  } 

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_SUBDIARIO_DET = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  cgSubDiarioDet "); 
    textSQL.append(" WHERE oid_subdiario_det = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_SUBDIARIO_DET, oid); 
    return querySelect; 
  }
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  cgSubDiarioDet "); 
    textSQL.append(" WHERE oid_subdiario = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }
  
  private PreparedStatement selectBySubDiario(Object aCondiciones) throws BaseException, SQLException { 
	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM  cgSubDiarioDet "); 
	    textSQL.append(" WHERE oid_subdiario = ? ");
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
	    Subdiario subdiario = (Subdiario) aCondiciones; 
	
	    querySelect.setInt(1, subdiario.getOID()); 
	    return querySelect; 
  }
  

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_subdiario_det oid,oid_subdiario codigo,  descripcion ,activo ");
    textSQL.append(" from cgSubDiarioDet");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  }
  
  public static List getSubDiariosDet(Subdiario subDiario,
          ISesion aSesion) throws BaseException {
	  return (List) ObjetoLogico.getObjects(SubdiarioDet.NICKNAME,
             DBSubdiarioDet.SELECT_BY_SUBDIARIO,
             subDiario,
             new ListObserver(),
             aSesion);
  }
  
  
} 
