package com.srn.erp.reclutamiento.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import com.srn.erp.reclutamiento.bm.RecluBusqueda;
import com.srn.erp.reclutamiento.bm.RecluProcDefEnBusq;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;

public class DBRecluProcDefEnBusq extends DBObjetoPersistente {

  public static final String OID_PROC_DEF_BUSQ = "oid_proc_def_busq";
  public static final String OID_BUSQUEDA_ACT = "oid_busqueda_act";
  public static final String ORDEN = "orden";
  public static final String OID_PROCESO = "oid_proceso";
  public static final String FECHA_ASIGNO = "fecha_asigno";
  public static final String OID_CONC_PROCESO = "oid_conc_proceso";
  public static final String ACTIVO = "activo";
  public static final String OID_TIPO_FORMULARIO = "oid_tipo_formu";
  
  private static final int SELECT_BY_BUSQUEDA = 100;

  public DBRecluProcDefEnBusq() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_PROC_DEF_BUSQ = 1;
    final int OID_BUSQUEDA_ACT = 2;
    final int ORDEN = 3;
    final int OID_PROCESO = 4;
    final int FECHA_ASIGNO = 5;
    final int ACTIVO = 6;
    final int OID_CONC_PROCESO = 7;
    final int OID_TIPO_FORMULARIO = 8;

    RecluProcDefEnBusq pers = (RecluProcDefEnBusq) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into rsProcDefBusq "+
                     " ( "+
                      "OID_PROC_DEF_BUSQ,"+
                      "OID_BUSQUEDA_ACT,"+
                      "ORDEN,"+
                      "OID_PROCESO,"+
                      "FECHA_ASIGNO,"+
                      "ACTIVO,"
                      + "OID_CONC_PROCESO,OID_TIPO_FORMU)"+ 
                      " values "+ 
                      "("+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_PROC_DEF_BUSQ,pers.getOID());
    qInsert.setInt(OID_BUSQUEDA_ACT,pers.getBusqueda().getOID());
    qInsert.setInt(ORDEN,pers.getOrden().intValue());
    qInsert.setInt(OID_PROCESO,pers.getProceso().getOID());
    qInsert.setDate(FECHA_ASIGNO,new java.sql.Date(pers.getFecha_asigno().getTime()));
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    if (pers.getConceptoProceso()!=null)
    	qInsert.setInt(OID_CONC_PROCESO,pers.getConceptoProceso().getOIDInteger());
    else
    	qInsert.setNull(OID_CONC_PROCESO,Types.INTEGER);
    if (pers.getTipoFormulario()!=null)
    	qInsert.setInt(OID_TIPO_FORMULARIO,pers.getTipoFormulario().getOIDInteger());
    else
    	qInsert.setNull(OID_TIPO_FORMULARIO,Types.INTEGER);    
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_BUSQUEDA_ACT = 1;
    final int ORDEN = 2;
    final int OID_PROCESO = 3;
    final int FECHA_ASIGNO = 4;
    final int ACTIVO = 5;
    final int OID_CONC_PROCESO = 6;
    final int OID_TIPO_FORMULARIO = 7;
    final int OID_PROC_DEF_BUSQ = 8;

    RecluProcDefEnBusq pers = (RecluProcDefEnBusq) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update rsProcDefBusq set "+
              "oid_busqueda_act=?"+ 
              ",orden=?"+ 
              ",oid_proceso=?"+ 
              ",fecha_asigno=?"+ 
              ",activo=?"+ 
              ",oid_conc_proceso=?"+
              ",oid_tipo_formu=?"+
                 " where " +
                 " oid_proc_def_busq=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_PROC_DEF_BUSQ,pers.getOID());
    qUpdate.setInt(OID_BUSQUEDA_ACT,pers.getBusqueda().getOID());
    qUpdate.setInt(ORDEN,pers.getOrden().intValue());
    qUpdate.setInt(OID_PROCESO,pers.getProceso().getOID());
    qUpdate.setDate(FECHA_ASIGNO,new java.sql.Date(pers.getFecha_asigno().getTime()));
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    if (pers.getConceptoProceso()!=null)
    	qUpdate.setInt(OID_CONC_PROCESO,pers.getConceptoProceso().getOIDInteger());
    else
    	qUpdate.setNull(OID_CONC_PROCESO,Types.INTEGER);
    if (pers.getTipoFormulario()!=null)
    	qUpdate.setInt(OID_TIPO_FORMULARIO,pers.getTipoFormulario().getOIDInteger());
    else
    	qUpdate.setNull(OID_TIPO_FORMULARIO,Types.INTEGER);    
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_PROC_DEF_BUSQ = 1; 
    RecluProcDefEnBusq pers = (RecluProcDefEnBusq) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update rsProcDefBusq "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_proc_def_busq=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_PROC_DEF_BUSQ, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_PROC_DEF_BUSQ = 1; 
    RecluProcDefEnBusq pers = (RecluProcDefEnBusq) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update rsProcDefBusq "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_proc_def_busq=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_PROC_DEF_BUSQ, pers.getOID()); 
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
      case SELECT_BY_BUSQUEDA: {
          ps = this.selectByBusqueda(aCondiciones); 
          break;    	  
      }
    } 
    return ps;
  } 

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_PROC_DEF_BUSQ = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  rsProcDefBusq "); 
    textSQL.append(" WHERE oid_proc_def_busq = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_PROC_DEF_BUSQ, oid); 
    return querySelect; 
  }
  
  
  private PreparedStatement selectByBusqueda(Object aCondiciones) throws BaseException, SQLException { 

	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM  rsProcDefBusq "); 
	    textSQL.append(" WHERE oid_busqueda_act = ? ");
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
	    RecluBusqueda recluBusqueda = (RecluBusqueda) aCondiciones; 
	    querySelect.setInt(1, recluBusqueda.getOID());
	    return querySelect;
	    
  }  
  
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  rsProcDefBusq "); 
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_proc_def_busq oid, codigo,  descripcion ,activo ");
    textSQL.append(" from rsProcDefBusq");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  }
  
  public static List getProcesosDefEnBusqueda(RecluBusqueda aRecluBusqueda,
          ISesion aSesion) throws BaseException {
	  return (List) ObjetoLogico.getObjects(RecluProcDefEnBusq.NICKNAME,
             DBRecluProcDefEnBusq.SELECT_BY_BUSQUEDA,
             aRecluBusqueda,
             new ListObserver(),
             aSesion);
  }  
  
} 
