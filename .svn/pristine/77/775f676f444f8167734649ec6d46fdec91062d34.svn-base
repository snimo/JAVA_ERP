package com.srn.erp.cip.da;

import java.sql.*;
import java.util.List;

import com.srn.erp.cip.bm.*;
import com.srn.erp.general.bm.PeriodoInc;
import com.srn.erp.general.bm.PeriodoIncDet;
import com.srn.erp.general.da.DBPeriodoIncDet;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.*;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.*;

public class DBEmpresaPayroll extends DBObjetoPersistente {

  public static final String OID_EMPRESA = "oid_empresa";
  public static final String EMPRESA = "empresa";
  public static final String NOMBRE = "nombre";
  public static final String ACTIVO = "activo";
  
  public static final int TRUNCATE_TABLE_EMPRESA = 100;

  public DBEmpresaPayroll() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_EMPRESA = 1;
    final int EMPRESA = 2;
    final int NOMBRE = 3;
    final int ACTIVO = 4;

    EmpresaPayroll pers = (EmpresaPayroll) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into payEmpresa "+
                     " ( "+
                      "OID_EMPRESA,"+
                      "EMPRESA,"+
                      "NOMBRE,"+
                      "ACTIVO)"+ 
                      " values "+ 
                      "("+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_EMPRESA,pers.getOID());
    qInsert.setString(EMPRESA,pers.getEmpresa());
    qInsert.setString(NOMBRE,pers.getNombre());
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int EMPRESA = 1;
    final int NOMBRE = 2;
    final int ACTIVO = 3;
    final int OID_EMPRESA = 4;

    EmpresaPayroll pers = (EmpresaPayroll) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update payEmpresa set "+
              "empresa=?"+ 
              ",nombre=?"+ 
              ",activo=?"+ 
                 " where " +
                 " oid_empresa=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_EMPRESA,pers.getOID());
    qUpdate.setString(EMPRESA,pers.getEmpresa());
    qUpdate.setString(NOMBRE,pers.getNombre());
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_EMPRESA = 1; 
    EmpresaPayroll pers = (EmpresaPayroll) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update payEmpresa "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_empresa=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_EMPRESA, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_EMPRESA = 1; 
    EmpresaPayroll pers = (EmpresaPayroll) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update payEmpresa "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_empresa=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_EMPRESA, pers.getOID()); 
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
      case IDBObjetoPersistente.SELECT_ALL: { 
          ps = this.selectAll(aCondiciones); 
          break; 
     } 
      case TRUNCATE_TABLE_EMPRESA: {
          ps = this.truncarTablaPayEmpresa(aCondiciones); 
          break; 
      }
    } 
    return ps;
  } 

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_EMPRESA = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  payEmpresa "); 
    textSQL.append(" WHERE oid_empresa = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_EMPRESA, oid); 
    return querySelect; 
  }

  private PreparedStatement selectAll(Object aCondiciones) throws BaseException, SQLException { 
	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM  payEmpresa "); 
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
	    return querySelect; 
  }
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  payEmpresa "); 
    textSQL.append(" WHERE empresa = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_empresa oid,empresa codigo, nombre descripcion ,activo ");
    textSQL.append(" from payEmpresa");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  }
  
  private PreparedStatement truncarTablaPayEmpresa(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("truncate table payEmpresa ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.executeUpdate();
		qUpdate.close();
		return null;
		
  }

public static void truncarTablaEmpresaPayroll(ISesion aSesion)
	  throws BaseException {
	  	ObjetoLogico.getObjects(EmpresaPayroll.NICKNAME,
		  				DBEmpresaPayroll.TRUNCATE_TABLE_EMPRESA,
		  				null,
		  				null,
		  				aSesion);
}

public static List getAll(ISesion aSesion) throws BaseException {
	return (List) ObjetoLogico.getObjects(EmpresaPayroll.NICKNAME,
           DBEmpresaPayroll.SELECT_ALL,
           null,
           new ListObserver(),
           aSesion);
}

  
} 
