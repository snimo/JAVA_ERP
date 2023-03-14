package com.srn.erp.excluidos.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.excluidos.bm.SeguridadEmpresaPredio;
import com.srn.erp.general.bm.PeriodoInc;
import com.srn.erp.general.bm.PeriodoIncDet;
import com.srn.erp.general.da.DBPeriodoIncDet;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.applicarionServer.bm.Seguridad.PerfilFuncional;
import framework.request.bl.Utils.BaseException;

public class DBSeguridadEmpresaPredio extends DBObjetoPersistente {

  public static final String OID_SEG_EMP_PREDIO = "oid_seg_emp_predio";
  public static final String OID_PERFIL = "oid_perfil";
  public static final String OID_EMPRESA = "oid_empresa";
  public static final String ACTIVO = "activo";
  
  public static final int SELECT_BY_PERFIL = 100;

  public DBSeguridadEmpresaPredio() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_SEG_EMP_PREDIO = 1;
    final int OID_PERFIL = 2;
    final int OID_EMPRESA = 3;
    final int ACTIVO = 4;

    SeguridadEmpresaPredio pers = (SeguridadEmpresaPredio) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into excSeguEmpPredio "+
                     " ( "+
                      "OID_SEG_EMP_PREDIO,"+
                      "OID_PERFIL,"+
                      "OID_EMPRESA,"+
                      "ACTIVO)"+ 
                      " values "+ 
                      "("+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_SEG_EMP_PREDIO,pers.getOID());
    qInsert.setInt(OID_PERFIL,pers.getPerfil().getOID());
    qInsert.setInt(OID_EMPRESA,pers.getEmpresa().getOID());
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_PERFIL = 1;
    final int OID_EMPRESA = 2;
    final int ACTIVO = 3;
    final int OID_SEG_EMP_PREDIO = 4;

    SeguridadEmpresaPredio pers = (SeguridadEmpresaPredio) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update excSeguEmpPredio set "+
              "oid_perfil=?"+ 
              ",oid_empresa=?"+ 
              ",activo=?"+ 
                 " where " +
                 " oid_seg_emp_predio=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_SEG_EMP_PREDIO,pers.getOID());
    qUpdate.setInt(OID_PERFIL,pers.getPerfil().getOID());
    qUpdate.setInt(OID_EMPRESA,pers.getEmpresa().getOID());
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_SEG_EMP_PREDIO = 1; 
    SeguridadEmpresaPredio pers = (SeguridadEmpresaPredio) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update excSeguEmpPredio "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_seg_emp_predio=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_SEG_EMP_PREDIO, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_SEG_EMP_PREDIO = 1; 
    SeguridadEmpresaPredio pers = (SeguridadEmpresaPredio) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update excSeguEmpPredio "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_seg_emp_predio=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_SEG_EMP_PREDIO, pers.getOID()); 
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
      case SELECT_BY_PERFIL: {
          ps = this.selectByPerfil(aCondiciones); 
          break;    	  
      }
    } 
    return ps;
  } 

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_SEG_EMP_PREDIO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  excSeguEmpPredio "); 
    textSQL.append(" WHERE oid_seg_emp_predio = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_SEG_EMP_PREDIO, oid); 
    return querySelect; 
  }
  
  private PreparedStatement selectByPerfil(Object aCondiciones) throws BaseException, SQLException { 

	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM  excSeguEmpPredio "); 
	    textSQL.append(" WHERE oid_perfil = ? ");
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
	    PerfilFuncional perfil = (PerfilFuncional) aCondiciones; 
	    querySelect.setInt(1, perfil.getOID()); 
	    return querySelect; 
	    
  }  
  
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  excSeguEmpPredio "); 
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_seg_emp_predio oid, codigo,  descripcion ,activo ");
    textSQL.append(" from excSeguEmpPredio");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  }
  
  public static List getSeguridadEmpresaPredio(
		  PerfilFuncional perfil,
          ISesion aSesion) throws BaseException {
	  return (List) ObjetoLogico.getObjects(SeguridadEmpresaPredio.NICKNAME,
             DBSeguridadEmpresaPredio.SELECT_BY_PERFIL,
             perfil,
             new ListObserver(),
             aSesion);
  }  
  
} 
