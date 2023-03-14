package com.srn.erp.conciTarjeta.da;

import java.sql.*;
import java.util.List;

import com.srn.erp.conciTarjeta.bm.*;
import com.srn.erp.general.bm.PeriodoInc;
import com.srn.erp.general.bm.PeriodoIncDet;
import com.srn.erp.general.da.DBPeriodoIncDet;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.*;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.*;

public class DBArcImpErrorPOSNET extends DBObjetoPersistente {

  public static final String OID_ERROR_IMP = "oid_error_imp";
  public static final String TIPO_ARCH = "tipo_arch";
  public static final String FECHA = "fecha";
  public static final String HORA = "hora";
  public static final String CARPETA = "carpeta";
  public static final String NOMBRE_ARCHIVO = "nombre_archivo";
  public static final String OID_TERMINAL = "oid_terminal";
  public static final String OID_EMPRESA = "oid_empresa";
  public static final String PROBLEMA = "problema";
  public static final String ACTIVO = "activo";
  
  public static final int SELECT_BY_CONDICIONES = 100;

  public DBArcImpErrorPOSNET() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_ERROR_IMP = 1;
    final int TIPO_ARCH = 2;
    final int FECHA = 3;
    final int HORA = 4;
    final int CARPETA = 5;
    final int NOMBRE_ARCHIVO = 6;
    final int OID_TERMINAL = 7;
    final int OID_EMPRESA = 8;
    final int PROBLEMA = 9;
    final int ACTIVO = 10;

    ArcImpErrorPOSNET pers = (ArcImpErrorPOSNET) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into cTarErrorImpArch "+
                     " ( "+
                      "OID_ERROR_IMP,"+
                      "TIPO_ARCH,"+
                      "FECHA,"+
                      "HORA,"+
                      "CARPETA,"+
                      "NOMBRE_ARCHIVO,"+
                      "OID_TERMINAL,"+
                      "OID_EMPRESA,"+
                      "PROBLEMA,"+
                      "ACTIVO)"+ 
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
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_ERROR_IMP,pers.getOID());
    qInsert.setString(TIPO_ARCH,pers.getTipo_arch());
    qInsert.setDate(FECHA,new java.sql.Date(pers.getFecha().getTime()));
    qInsert.setString(HORA,pers.getHora());
    qInsert.setString(CARPETA,pers.getCarpeta());
    qInsert.setString(NOMBRE_ARCHIVO,pers.getNombre_archivo());
    if (pers.getTerminal()!=null)
    	qInsert.setInt(OID_TERMINAL,pers.getTerminal().getOID());
    else
    	qInsert.setNull(OID_TERMINAL,Types.INTEGER);
    if (pers.getEmpresa()!=null)
    	qInsert.setInt(OID_EMPRESA,pers.getEmpresa().getOID());
    else
    	qInsert.setNull(OID_EMPRESA,Types.INTEGER);
    qInsert.setString(PROBLEMA,pers.getProblema());
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int TIPO_ARCH = 1;
    final int FECHA = 2;
    final int HORA = 3;
    final int CARPETA = 4;
    final int NOMBRE_ARCHIVO = 5;
    final int OID_TERMINAL = 6;
    final int OID_EMPRESA = 7;
    final int PROBLEMA = 8;
    final int ACTIVO = 9;
    final int OID_ERROR_IMP = 10;

    ArcImpErrorPOSNET pers = (ArcImpErrorPOSNET) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update cTarErrorImpArch set "+
              "tipo_arch=?"+ 
              ",fecha=?"+ 
              ",hora=?"+ 
              ",carpeta=?"+ 
              ",nombre_archivo=?"+ 
              ",oid_terminal=?"+ 
              ",oid_empresa=?"+ 
              ",problema=?"+ 
              ",activo=?"+ 
                 " where " +
                 " oid_error_imp=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_ERROR_IMP,pers.getOID());
    qUpdate.setString(TIPO_ARCH,pers.getTipo_arch());
    qUpdate.setDate(FECHA,new java.sql.Date(pers.getFecha().getTime()));
    qUpdate.setString(HORA,pers.getHora());
    qUpdate.setString(CARPETA,pers.getCarpeta());
    qUpdate.setString(NOMBRE_ARCHIVO,pers.getNombre_archivo());
    if (pers.getTerminal()!=null)
    	qUpdate.setInt(OID_TERMINAL,pers.getTerminal().getOID());
    else
    	qUpdate.setNull(OID_TERMINAL,Types.INTEGER);
    if (pers.getEmpresa()!=null)
    	qUpdate.setInt(OID_EMPRESA,pers.getEmpresa().getOID());
    else
    	qUpdate.setNull(OID_EMPRESA,Types.INTEGER);
    qUpdate.setString(PROBLEMA,pers.getProblema());
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_ERROR_IMP = 1; 
    ArcImpErrorPOSNET pers = (ArcImpErrorPOSNET) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update cTarErrorImpArch "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_error_imp=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_ERROR_IMP, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_ERROR_IMP = 1; 
    ArcImpErrorPOSNET pers = (ArcImpErrorPOSNET) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update cTarErrorImpArch "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_error_imp=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_ERROR_IMP, pers.getOID()); 
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
      case SELECT_BY_CONDICIONES: {
          ps = this.selectByCondiciones(aCondiciones); 
          break;    	  
      }
    } 
    return ps;
  } 

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_ERROR_IMP = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  cTarErrorImpArch "); 
    textSQL.append(" WHERE oid_error_imp = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_ERROR_IMP, oid); 
    return querySelect; 
  }
  
  private PreparedStatement selectByCondiciones(Object aCondiciones) throws BaseException, SQLException { 
	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM  cTarErrorImpArch "); 
	    textSQL.append(" WHERE  1=1 ");
	    
	    
	    HashTableDatos condiciones = (HashTableDatos) aCondiciones;
	    
	    java.util.Date fecDesde = null;
	    if (condiciones.containsKey("FEC_DESDE")) {
	    	fecDesde = (java.util.Date) condiciones.get("FEC_DESDE");
	    	textSQL.append(" and fecha>=? ");
	    }
	    java.util.Date fecHasta = null;
	    if (condiciones.containsKey("FEC_HASTA")) {
	    	fecHasta = (java.util.Date) condiciones.get("FEC_HASTA");
	    	textSQL.append(" and fecha<=? ");
	    }	    
	    
	    String tipoArchivo = null;
	    if (condiciones.containsKey("TIPO_ARCHIVO")) {
	    	tipoArchivo = (String) condiciones.get("TIPO_ARCHIVO");
	    	textSQL.append(" and tipo_arch='"+tipoArchivo+"' ");	    	
	    }
	    
	    EmpresaConciTar empresa = null;
	    if (condiciones.containsKey(EmpresaConciTar.NICKNAME)) {
	    	empresa = (EmpresaConciTar) condiciones.get(EmpresaConciTar.NICKNAME);
	    	textSQL.append(" and oid_empresa="+empresa.getOIDInteger()+" ");
	    }
	    
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
	    
	    int params = 0;
	    if (fecDesde!=null) {
	    	++params;
	    	querySelect.setDate(params, new java.sql.Date(fecDesde.getTime()));
	    }
	    if (fecHasta!=null) {
	    	++params;
	    	querySelect.setDate(params, new java.sql.Date(fecHasta.getTime()));
	    }	    
	    
	    return querySelect; 
	  }  
  
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  cTarErrorImpArch "); 
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_error_imp oid, codigo,  descripcion ,activo ");
    textSQL.append(" from cTarErrorImpArch");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  }
  
  public static List getArchImpoConErrores(
		  java.util.Date fecDesde,
		  java.util.Date fecHasta,
		  EmpresaConciTar empresa,
		  String tipoArchivo,
          ISesion aSesion) throws BaseException {
	  HashTableDatos condiciones = new HashTableDatos();
	  if (fecDesde!=null)
		  condiciones.put("FEC_DESDE", fecDesde);
	  if (fecHasta!=null)
		  condiciones.put("FEC_HASTA", fecHasta);
	  if (tipoArchivo!=null)
		  condiciones.put("TIPO_ARCHIVO", tipoArchivo);
	  if (empresa!=null)
		  condiciones.put(EmpresaConciTar.NICKNAME, empresa);
	  
	  return (List) ObjetoLogico.getObjects(ArcImpErrorPOSNET.NICKNAME,
             DBArcImpErrorPOSNET.SELECT_BY_CONDICIONES,
             condiciones,
             new ListObserver(),
             aSesion);
  }  
  
} 
