package com.srn.erp.conciTarjeta.da;

import java.sql.*;
import java.util.List;

import com.srn.erp.conciTarjeta.bm.*;
import com.srn.erp.general.bm.Periodo;
import com.srn.erp.general.bm.PeriodoInc;
import com.srn.erp.general.bm.PeriodoIncDet;
import com.srn.erp.general.da.DBPeriodo;
import com.srn.erp.general.da.DBPeriodoIncDet;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.*;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.*;

public class DBCabTarConciEnt extends DBObjetoPersistente {

  public static final String OID_TAR_INFO_CAB = "oid_tar_info_cab";
  public static final String FEC_IMP = "fec_imp";
  public static final String HORA_IMP = "hora_imp";
  public static final String NOM_ARCHIVO = "nom_archivo";
  public static final String OID_EMPRESA = "oid_empresa";
  public static final String ACTIVO = "activo";
  public static final String TIPO_ARCHIVO = "tipo_archivo";
  public static final String CARPETA_ARCHIVO = "carpeta_archivo";
  public static final String FEC_NOM_ARCH = "fec_nom_arch";
  public static final String OID_USU_ALTA = "oid_usu_alta";
  
  public static final int SELECT_BY_EMPRESA_TIPOARCH_FECHA = 100;
  public static final int SELECT_BY_CONSULTA			   = 101;
  
  public DBCabTarConciEnt() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_TAR_INFO_CAB = 1;
    final int FEC_IMP = 2;
    final int HORA_IMP = 3;
    final int NOM_ARCHIVO = 4;
    final int OID_EMPRESA = 5;
    final int ACTIVO = 6;
    final int TIPO_ARCHIVO = 7;
    final int CARPETA_ARCHIVO = 8;
    final int FEC_NOM_ARCH = 9;
    final int OID_USU_ALTA = 10;

    CabTarConciEnt pers = (CabTarConciEnt) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into cTarInfPorEntCab "+
                     " ( "+
                      "OID_TAR_INFO_CAB,"+
                      "FEC_IMP,"+
                      "HORA_IMP,"+
                      "NOM_ARCHIVO,"+
                      "OID_EMPRESA,"+
                      "ACTIVO,TIPO_ARCHIVO,CARPETA_ARCHIVO,FEC_NOM_ARCH,OID_USU_ALTA)"+ 
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
    qInsert.setInt(OID_TAR_INFO_CAB,pers.getOID());
    qInsert.setDate(FEC_IMP,new java.sql.Date(pers.getFec_imp().getTime()));
    qInsert.setString(HORA_IMP,pers.getHora_imp());
    qInsert.setString(NOM_ARCHIVO,pers.getNom_archivo());
    qInsert.setInt(OID_EMPRESA,pers.getEmpresa().getOID());
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qInsert.setString(TIPO_ARCHIVO, pers.getTipoArchivo());
    if (pers.getCarpetaArchivo()!=null)
    	qInsert.setString(CARPETA_ARCHIVO, pers.getCarpetaArchivo());
    else
    	qInsert.setNull(CARPETA_ARCHIVO, Types.VARCHAR);
    if (pers.getFecNomArchivo()!=null)
    	qInsert.setDate(FEC_NOM_ARCH, new java.sql.Date(pers.getFecNomArchivo().getTime()));
    else
    	qInsert.setNull(FEC_NOM_ARCH, Types.DATE);
    if (pers.getUsuarioAlta()!=null)
    	qInsert.setInt(OID_USU_ALTA, pers.getUsuarioAlta().getOID());
    else
    	qInsert.setNull(OID_USU_ALTA, Types.INTEGER);
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int FEC_IMP = 1;
    final int HORA_IMP = 2;
    final int NOM_ARCHIVO = 3;
    final int OID_EMPRESA = 4;
    final int ACTIVO = 5;
    final int TIPO_ARCHIVO = 6;
    final int CARPETA_ARCHIVO = 7;
    final int FEC_NOM_ARCH = 8;
    final int OID_USU_ALTA = 9;    
    final int OID_TAR_INFO_CAB = 10;

    CabTarConciEnt pers = (CabTarConciEnt) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update cTarInfPorEntCab set "+
              "fec_imp=?"+ 
              ",hora_imp=?"+ 
              ",nom_archivo=?"+ 
              ",oid_empresa=?"+ 
              ",activo=?"+ 
              ",tipo_archivo=?"+
              ",carpeta_archivo=?"+
              ",fec_nom_arch=?"+
              ",oid_usu_alta=? "+
                 " where " +
                 " oid_tar_info_cab=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_TAR_INFO_CAB,pers.getOID());
    qUpdate.setDate(FEC_IMP,new java.sql.Date(pers.getFec_imp().getTime()));
    qUpdate.setString(HORA_IMP,pers.getHora_imp());
    qUpdate.setString(NOM_ARCHIVO,pers.getNom_archivo());
    qUpdate.setInt(OID_EMPRESA,pers.getEmpresa().getOID());
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.setString(TIPO_ARCHIVO, pers.getTipoArchivo());
    if (pers.getCarpetaArchivo()!=null)
    	qUpdate.setString(CARPETA_ARCHIVO, pers.getCarpetaArchivo());
    else
    	qUpdate.setNull(CARPETA_ARCHIVO, Types.VARCHAR);
    if (pers.getFecNomArchivo()!=null)
    	qUpdate.setDate(FEC_NOM_ARCH, new java.sql.Date(pers.getFecNomArchivo().getTime()));
    else
    	qUpdate.setNull(FEC_NOM_ARCH, Types.DATE);
    if (pers.getUsuarioAlta()!=null)
    	qUpdate.setInt(OID_USU_ALTA, pers.getUsuarioAlta().getOID());
    else
    	qUpdate.setNull(OID_USU_ALTA, Types.INTEGER);    
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_TAR_INFO_CAB = 1; 
    CabTarConciEnt pers = (CabTarConciEnt) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update cTarInfPorEntCab "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_tar_info_cab=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_TAR_INFO_CAB, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_TAR_INFO_CAB = 1; 
    CabTarConciEnt pers = (CabTarConciEnt) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update cTarInfPorEntCab "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_tar_info_cab=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_TAR_INFO_CAB, pers.getOID()); 
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
      case SELECT_BY_EMPRESA_TIPOARCH_FECHA: {
          ps = this.selectByEmpresaTipoArchFecha(aCondiciones); 
          break;    	  
      }
      case SELECT_BY_CONSULTA: {
          ps = this.selectByConsulta(aCondiciones); 
          break;    	  
      }
    } 
    return ps;
  } 

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_TAR_INFO_CAB = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  cTarInfPorEntCab "); 
    textSQL.append(" WHERE oid_tar_info_cab = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_TAR_INFO_CAB, oid); 
    return querySelect; 
  }
  
  private PreparedStatement selectByConsulta(Object aCondiciones) throws BaseException, SQLException { 

	    HashTableDatos condiciones = (HashTableDatos) aCondiciones;
	    EmpresaConciTar empresa = (EmpresaConciTar) condiciones.get(EmpresaConciTar.NICKNAME);
	    java.util.Date fecDesde = (java.util.Date) condiciones.get("FEC_DESDE");
	    java.util.Date fecHasta = (java.util.Date) condiciones.get("FEC_HASTA");
	    
	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM  cTarInfPorEntCab "); 
	    textSQL.append(" WHERE  activo=1  ");
	    textSQL.append(" and oid_empresa = ?  ");
	    textSQL.append(" and fec_imp >= ? ");
	    textSQL.append(" and fec_imp <= ? ");	    
	    
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
	    querySelect.setInt(1, empresa.getOID());
	    querySelect.setDate(2, new java.sql.Date(fecDesde.getTime()));
	    querySelect.setDate(3, new java.sql.Date(fecHasta.getTime()));
	    
	    return querySelect; 
  }  
  
  
  
  private PreparedStatement selectByEmpresaTipoArchFecha(Object aCondiciones) throws BaseException, SQLException { 

	    HashTableDatos condiciones = (HashTableDatos) aCondiciones;
	    EmpresaConciTar empresa = (EmpresaConciTar) condiciones.get(EmpresaConciTar.NICKNAME);
	    String tipoArchivo = (String) condiciones.get("TIPO_ARCHIVO");
	    java.util.Date fecha = (java.util.Date) condiciones.get("FECHA");
	    

	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM  cTarInfPorEntCab "); 
	    textSQL.append(" WHERE  activo=1  ");
	    textSQL.append(" and oid_empresa = ?  ");
	    textSQL.append(" and tipo_archivo = ?  ");
	    textSQL.append(" and fec_nom_arch = ? ");
	    
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
	    querySelect.setInt(1, empresa.getOID());
	    querySelect.setString(2, tipoArchivo);
	    querySelect.setDate(3, new java.sql.Date(fecha.getTime()));
	    
	    return querySelect; 
  }  
  
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  cTarInfPorEntCab "); 
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_tar_info_cab oid, codigo,  descripcion ,activo ");
    textSQL.append(" from cTarInfPorEntCab");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  }
  
  public static CabTarConciEnt getCabTarConciEnt(
		  EmpresaConciTar empresa,
		  String tipoArchivo,
		  java.util.Date fecha,
          ISesion aSesion)
          throws BaseException {
	  HashTableDatos condiciones = new HashTableDatos();
	  condiciones.put(EmpresaConciTar.NICKNAME, empresa);
	  condiciones.put("FECHA", fecha);
	  condiciones.put("TIPO_ARCHIVO",tipoArchivo);
	  
	  return (CabTarConciEnt) ObjetoLogico.getObjects(CabTarConciEnt.NICKNAME,
			  				DBCabTarConciEnt.SELECT_BY_EMPRESA_TIPOARCH_FECHA,
			  				condiciones,
			  				new ObjetoObservado(),
			  				aSesion);
  }
  
  public static List getCabTarConciEnt(
		  EmpresaConciTar empresa,
		  java.util.Date fecDesde,
		  java.util.Date fecHasta,
          ISesion aSesion) throws BaseException {
	  HashTableDatos condiciones = new HashTableDatos();
	  condiciones.put(EmpresaConciTar.NICKNAME, empresa);
	  condiciones.put("FEC_DESDE", fecDesde);
	  condiciones.put("FEC_HASTA", fecHasta);
	  
	  return (List) ObjetoLogico.getObjects(CabTarConciEnt.NICKNAME,
             DBCabTarConciEnt.SELECT_BY_CONSULTA,
             condiciones,
             new ListObserver(),
             aSesion);
  }  
  
} 
