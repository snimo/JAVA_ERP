package com.srn.erp.cip.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.StringTokenizer;

import com.srn.erp.cip.bm.EmpresaCIP;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ObjetoObservado;

public class DBEmpresaCIP extends DBObjetoPersistente {

  public static final String OID_EMPRESA = "oid_empresa";
  public static final String RAZON_SOCIAL = "razon_social";
  public static final String ACTIVO = "activo";
  
  public static final int SELECT_BY_RAZONSOCIAL = 100;
  public static final int SELECT_BY_LIKE_RAZONSOCIAL = 101;

  public DBEmpresaCIP() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_EMPRESA = 1;
    final int RAZON_SOCIAL = 2;
    final int ACTIVO = 3;

    EmpresaCIP pers = (EmpresaCIP) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into cipEmpresas "+
                     " ( "+
                      "OID_EMPRESA,"+
                      "RAZON_SOCIAL,"+
                      "ACTIVO)"+ 
                      " values "+ 
                      "("+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_EMPRESA,pers.getOID());
    qInsert.setString(RAZON_SOCIAL,pers.getRazon_social());
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int RAZON_SOCIAL = 1;
    final int ACTIVO = 2;
    final int OID_EMPRESA = 3;

    EmpresaCIP pers = (EmpresaCIP) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update cipEmpresas set "+
              "razon_social=?"+ 
              ",activo=?"+ 
                 " where " +
                 " oid_empresa=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_EMPRESA,pers.getOID());
    qUpdate.setString(RAZON_SOCIAL,pers.getRazon_social());
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_EMPRESA = 1; 
    EmpresaCIP pers = (EmpresaCIP) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update cipEmpresas "+
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
    EmpresaCIP pers = (EmpresaCIP) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update cipEmpresas "+
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
      case SELECT_BY_RAZONSOCIAL: {
          ps = this.selectByRazonSocial(aCondiciones); 
          break; 
      }
      case SELECT_BY_LIKE_RAZONSOCIAL: {
          ps = this.selectByLikeRazonSocial(aCondiciones); 
          break; 
      }
    } 
    return ps;
  } 

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_EMPRESA = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  cipEmpresas "); 
    textSQL.append(" WHERE oid_empresa = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_EMPRESA, oid); 
    return querySelect; 
  }

  private PreparedStatement selectByLikeRazonSocial(Object aCondiciones) throws BaseException, SQLException { 

	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM  cipEmpresas "); 
	    textSQL.append(" WHERE  activo = 1 ");
	     
	    String razonSocial = (String) aCondiciones;
	    
		StringTokenizer st = new StringTokenizer(razonSocial, " ");
		while (st.hasMoreTokens()) {
			String next = st.nextToken().toUpperCase();
			textSQL.append(" and razon_social like '%" + next + "%' ");
		}
	    
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
	    return querySelect; 
	  
}
  
  
  
  private PreparedStatement selectByRazonSocial(Object aCondiciones) throws BaseException, SQLException { 
	  
	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM  cipEmpresas "); 
	    textSQL.append(" WHERE  razon_social = ? ");
	     
	    String razonSocial = (String) aCondiciones; 
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
	    querySelect.setString(1, razonSocial); 
	    return querySelect; 	  
	  
  }
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  cipEmpresas "); 
    textSQL.append(" WHERE razon_social = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_empresa oid,oid_empresa codigo, razon_social descripcion , activo ");
    textSQL.append(" from cipEmpresas");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  } 
  
  public static EmpresaCIP getEmpresaCIP(
		  String razonSocial,
          ISesion aSesion)
          throws BaseException {
	  return (EmpresaCIP) ObjetoLogico.getObjects(
			  				EmpresaCIP.NICKNAME,
			  				DBEmpresaCIP.SELECT_BY_RAZONSOCIAL,
			  				razonSocial,
			  				new ObjetoObservado(),
			  				aSesion);
  }
  
  public static List getEmpresasCIP(
		  String empresa,
          ISesion aSesion) throws BaseException {
	  return (List) ObjetoLogico.getObjects(EmpresaCIP.NICKNAME,
             DBEmpresaCIP.SELECT_BY_LIKE_RAZONSOCIAL,
             empresa,
             new ListObserver(),
             aSesion);
  }
  
  
} 
