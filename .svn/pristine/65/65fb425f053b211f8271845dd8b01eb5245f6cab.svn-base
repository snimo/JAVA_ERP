package com.srn.erp.ventas.da;

import java.sql.*;
import java.util.List;

import com.srn.erp.general.bm.PeriodoInc;
import com.srn.erp.general.bm.PeriodoIncDet;
import com.srn.erp.general.da.DBPeriodoIncDet;
import com.srn.erp.ventas.bm.*;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.*;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.*;

public class DBLogImpresoraFiscal extends DBObjetoPersistente {

  public static final String OID_LOG_IMP_FIS = "oid_log_imp_fis";
  public static final String OID_CCO = "oid_cco";
  public static final String NRO_IMPRESION = "nro_impresion";
  public static final String FECHA = "fecha";
  public static final String HORA = "hora";
  public static final String OID_USUARIO = "oid_usuario";
  public static final String LINEA = "linea";
  public static final String NRO_ERROR = "nro_error";
  public static final String OID_SUCURSAL = "oid_sucursal";
  
  public static final int SELECT_BY_RANGO_FECHAS = 100;

  public DBLogImpresoraFiscal() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_LOG_IMP_FIS = 1;
    final int OID_CCO = 2;
    final int NRO_IMPRESION = 3;
    final int FECHA = 4;
    final int HORA = 5;
    final int OID_USUARIO = 6;
    final int LINEA = 7;
    final int NRO_ERROR = 8;
    final int OID_SUCURSAL = 9;

    LogImpresoraFiscal pers = (LogImpresoraFiscal) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into veLogsImpFis "+
                     " ( "+
                      "OID_LOG_IMP_FIS,"+
                      "OID_CCO,"+
                      "NRO_IMPRESION,"+
                      "FECHA,"+
                      "HORA,"+
                      "OID_USUARIO,"+
                      "LINEA,"+
                      "NRO_ERROR,"+
                      "OID_SUCURSAL)"+ 
                      " values "+ 
                      "("+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_LOG_IMP_FIS,pers.getOID());
    if (pers.getOid_cco()!=null)
    	qInsert.setInt(OID_CCO,pers.getOid_cco().intValue());
    else
    	qInsert.setInt(OID_CCO,0);
    qInsert.setInt(NRO_IMPRESION,pers.getNro_impresion().intValue());
    qInsert.setDate(FECHA,new Date(pers.getFecha().getTime()));
    qInsert.setString(HORA,pers.getHora());
    qInsert.setInt(OID_USUARIO,pers.getOid_usuario().intValue());
    qInsert.setString(LINEA,pers.getLinea());
    qInsert.setInt(NRO_ERROR,pers.getNro_error().intValue());
    qInsert.setInt(OID_SUCURSAL,pers.getOid_sucursal().intValue());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_CCO = 1;
    final int NRO_IMPRESION = 2;
    final int FECHA = 3;
    final int HORA = 4;
    final int OID_USUARIO = 5;
    final int LINEA = 6;
    final int NRO_ERROR = 7;
    final int OID_SUCURSAL = 8;
    final int OID_LOG_IMP_FIS = 9;

    LogImpresoraFiscal pers = (LogImpresoraFiscal) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update veLogsImpFis set "+
              "oid_cco=?"+ 
              ",nro_impresion=?"+ 
              ",fecha=?"+ 
              ",hora=?"+ 
              ",oid_usuario=?"+ 
              ",linea=?"+ 
              ",nro_error=?"+ 
              ",oid_sucursal=?"+ 
                 " where " +
                 " oid_log_imp_fis=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_LOG_IMP_FIS,pers.getOID());
    qUpdate.setInt(OID_CCO,pers.getOid_cco().intValue());
    qUpdate.setInt(NRO_IMPRESION,pers.getNro_impresion().intValue());
    qUpdate.setDate(FECHA,new Date(pers.getFecha().getTime()));
    qUpdate.setString(HORA,pers.getHora());
    qUpdate.setInt(OID_USUARIO,pers.getOid_usuario().intValue());
    qUpdate.setString(LINEA,pers.getLinea());
    qUpdate.setInt(NRO_ERROR,pers.getNro_error().intValue());
    qUpdate.setInt(OID_SUCURSAL,pers.getOid_sucursal().intValue());
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_LOG_IMP_FIS = 1; 
    LogImpresoraFiscal pers = (LogImpresoraFiscal) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update veLogsImpFis "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_log_imp_fis=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_LOG_IMP_FIS, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_LOG_IMP_FIS = 1; 
    LogImpresoraFiscal pers = (LogImpresoraFiscal) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update veLogsImpFis "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_log_imp_fis=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_LOG_IMP_FIS, pers.getOID()); 
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
      case SELECT_BY_RANGO_FECHAS: {
        ps = this.selectByRangoFechas(aCondiciones); 
        break; 
      }
    } 
    return ps;
  } 

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_LOG_IMP_FIS = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  veLogsImpFis "); 
    textSQL.append(" WHERE oid_log_imp_fis = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_LOG_IMP_FIS, oid); 
    return querySelect; 
  }
  
  private PreparedStatement selectByRangoFechas(Object aCondiciones) throws BaseException, SQLException { 

    HashTableDatos condiciones = (HashTableDatos) aCondiciones;
    java.util.Date fecDesde = (java.util.Date)condiciones.get("fec_desde");
    java.util.Date fecHasta = (java.util.Date)condiciones.get("fec_hasta");

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  veLogsImpFis "); 
    textSQL.append(" WHERE fecha >= ? and fecha<=? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    querySelect.setDate(1,new Date(fecDesde.getTime()));
    querySelect.setDate(2,new Date(fecHasta.getTime()));
    return querySelect; 
  }
  
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  veLogsImpFis "); 
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_log_imp_fis oid, codigo,  descripcion ,activo ");
    textSQL.append(" from veLogsImpFis");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  } 
  
  public static List getLogsByFecha(java.util.Date fechaDesde,java.util.Date fechaHasta,
      ISesion aSesion) throws BaseException {
  	HashTableDatos condiciones = new HashTableDatos();
  	condiciones.put("fec_desde",fechaDesde);
  	condiciones.put("fec_hasta",fechaHasta);
  	return (List) ObjetoLogico.getObjects(LogImpresoraFiscal.NICKNAME,
         DBLogImpresoraFiscal.SELECT_BY_RANGO_FECHAS,
         condiciones,
         new ListObserver(),
         aSesion);
  }
  
  
} 
