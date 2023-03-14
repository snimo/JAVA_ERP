package com.srn.erp.reclutamiento.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.general.bm.PeriodoInc;
import com.srn.erp.general.bm.PeriodoIncDet;
import com.srn.erp.general.da.DBPeriodoIncDet;
import com.srn.erp.reclutamiento.bm.RecluProcTipoFormu;
import com.srn.erp.reclutamiento.bm.RecluTipoContrato;
import com.srn.erp.reclutamiento.bm.RecluTipoFormuProceso;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;

public class DBRecluProcTipoFormu extends DBObjetoPersistente {

  public static final String OID_PROC_TIPO_FORMU = "oid_proc_tipo_formu";
  public static final String OID_TIPO_FORMU = "oid_tipo_formu";
  public static final String OID_PROCESO = "oid_proceso";
  public static final String ACTIVO = "activo";
  
  private static final int SELECT_BY_TIPO_FORMULARIO = 100;

  public DBRecluProcTipoFormu() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_PROC_TIPO_FORMU = 1;
    final int OID_TIPO_FORMU = 2;
    final int OID_PROCESO = 3;
    final int ACTIVO = 4;

    RecluProcTipoFormu pers = (RecluProcTipoFormu) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into RSPROCTIPOFORMU "+
                     " ( "+
                      "OID_PROC_TIPO_FORMU,"+
                      "OID_TIPO_FORMU,"+
                      "OID_PROCESO,"+
                      "ACTIVO)"+ 
                      " values "+ 
                      "("+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_PROC_TIPO_FORMU,pers.getOID());
    qInsert.setInt(OID_TIPO_FORMU,pers.getTipo_formulario().getOID());
    qInsert.setInt(OID_PROCESO,pers.getProceso().getOID());
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_TIPO_FORMU = 1;
    final int OID_PROCESO = 2;
    final int ACTIVO = 3;
    final int OID_PROC_TIPO_FORMU = 4;

    RecluProcTipoFormu pers = (RecluProcTipoFormu) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update RSPROCTIPOFORMU set "+
              "oid_tipo_formu=?"+ 
              ",oid_proceso=?"+ 
              ",activo=?"+ 
                 " where " +
                 " oid_proc_tipo_formu=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_PROC_TIPO_FORMU,pers.getOID());
    qUpdate.setInt(OID_TIPO_FORMU,pers.getTipo_formulario().getOID());
    qUpdate.setInt(OID_PROCESO,pers.getProceso().getOID());
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_PROC_TIPO_FORMU = 1; 
    RecluProcTipoFormu pers = (RecluProcTipoFormu) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update RSPROCTIPOFORMU "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_proc_tipo_formu=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_PROC_TIPO_FORMU, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_PROC_TIPO_FORMU = 1; 
    RecluProcTipoFormu pers = (RecluProcTipoFormu) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update RSPROCTIPOFORMU "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_proc_tipo_formu=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_PROC_TIPO_FORMU, pers.getOID()); 
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
      case SELECT_BY_TIPO_FORMULARIO: {
          ps = this.selectTipoFormulario(aCondiciones); 
          break;    	  
      }
    } 
    return ps;
  } 

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_PROC_TIPO_FORMU = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  RSPROCTIPOFORMU "); 
    textSQL.append(" WHERE oid_proc_tipo_formu = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_PROC_TIPO_FORMU, oid); 
    return querySelect; 
  }
  
  private PreparedStatement selectTipoFormulario(Object aCondiciones) throws BaseException, SQLException { 
	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM  RSPROCTIPOFORMU "); 
	    textSQL.append(" WHERE oid_tipo_formu = ? and activo=1 ");
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
	    RecluTipoFormuProceso tipo = (RecluTipoFormuProceso) aCondiciones; 
	    querySelect.setInt(1, tipo.getOIDInteger()); 
	    return querySelect; 
	  }  
  
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  RSPROCTIPOFORMU "); 
    textSQL.append(" WHERE oid_tipo_formu = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_proc_tipo_formu oid,oid_tipo_formu codigo,  descripcion ,activo ");
    textSQL.append(" from RSPROCTIPOFORMU");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  }
  
  public static List getProcesosTipoFormu(RecluTipoFormuProceso tipoFormulario,
          ISesion aSesion) throws BaseException {
	  return (List) ObjetoLogico.getObjects(RecluProcTipoFormu.NICKNAME,
             DBRecluProcTipoFormu.SELECT_BY_TIPO_FORMULARIO,
             tipoFormulario,
             new ListObserver(),
             aSesion);
  }  
  
} 
