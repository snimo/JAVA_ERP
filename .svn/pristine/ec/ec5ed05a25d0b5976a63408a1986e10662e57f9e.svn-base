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

public class DBTipoArchConciTar extends DBObjetoPersistente {

  public static final String OID_TIPO_ARCHIVO = "oid_tipo_archivo";
  public static final String CODIGO = "codigo";
  public static final String DESCRIPCION = "descripcion";
  public static final String COMPORTAMIENTO = "comportamiento";
  public static final String ANT_ULT_FOLDER_EMP = "ant_ult_folder_emp";
  public static final String ULT_FOLDER_TIPO = "ult_folder_tipo";
  public static final String ACTIVO = "activo";
  public static final String COD_ARCH_IMP_TARJ = "cod_arch_imp_tarj";
  

  public DBTipoArchConciTar() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_TIPO_ARCHIVO = 1;
    final int CODIGO = 2;
    final int DESCRIPCION = 3;
    final int COMPORTAMIENTO = 4;
    final int ANT_ULT_FOLDER_EMP = 5;
    final int ULT_FOLDER_TIPO = 6;
    final int ACTIVO = 7;
    final int COD_ARCH_IMP_TARJ = 8;

    TipoArchConciTar pers = (TipoArchConciTar) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into cTarTiposArch "+
                     " ( "+
                      "OID_TIPO_ARCHIVO,"+
                      "CODIGO,"+
                      "DESCRIPCION,"+
                      "COMPORTAMIENTO,"+
                      "ANT_ULT_FOLDER_EMP,"+
                      "ULT_FOLDER_TIPO,"+
                      "ACTIVO,COD_ARCH_IMP_TARJ)"+ 
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
    qInsert.setInt(OID_TIPO_ARCHIVO,pers.getOID());
    qInsert.setString(CODIGO,pers.getCodigo());
    qInsert.setString(DESCRIPCION,pers.getDescripcion());
    qInsert.setString(COMPORTAMIENTO,pers.getComportamiento());
    qInsert.setString(ANT_ULT_FOLDER_EMP,pers.getAnt_ult_folder_emp());
    qInsert.setString(ULT_FOLDER_TIPO,pers.getUlt_folder_tipo());
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    if (pers.getCodArchImpTarj()!=null)
    	qInsert.setString(COD_ARCH_IMP_TARJ,pers.getCodArchImpTarj());
    else
    	qInsert.setNull(COD_ARCH_IMP_TARJ,Types.VARCHAR);
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int CODIGO = 1;
    final int DESCRIPCION = 2;
    final int COMPORTAMIENTO = 3;
    final int ANT_ULT_FOLDER_EMP = 4;
    final int ULT_FOLDER_TIPO = 5;
    final int ACTIVO = 6;
    final int COD_ARCH_IMP_TARJ = 7;
    final int OID_TIPO_ARCHIVO = 8;

    TipoArchConciTar pers = (TipoArchConciTar) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update cTarTiposArch set "+
              "codigo=?"+ 
              ",descripcion=?"+ 
              ",comportamiento=?"+ 
              ",ant_ult_folder_emp=?"+ 
              ",ult_folder_tipo=?"+ 
              ",activo=?"+ 
              ",cod_arch_imp_tarj=?"+
                 " where " +
                 " oid_tipo_archivo=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_TIPO_ARCHIVO,pers.getOID());
    qUpdate.setString(CODIGO,pers.getCodigo());
    qUpdate.setString(DESCRIPCION,pers.getDescripcion());
    qUpdate.setString(COMPORTAMIENTO,pers.getComportamiento());
    qUpdate.setString(ANT_ULT_FOLDER_EMP,pers.getAnt_ult_folder_emp());
    qUpdate.setString(ULT_FOLDER_TIPO,pers.getUlt_folder_tipo());
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    if (pers.getCodArchImpTarj()!=null)
    	qUpdate.setString(COD_ARCH_IMP_TARJ,pers.getCodArchImpTarj());
    else
    	qUpdate.setNull(COD_ARCH_IMP_TARJ,Types.VARCHAR);    
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_TIPO_ARCHIVO = 1; 
    TipoArchConciTar pers = (TipoArchConciTar) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update cTarTiposArch "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_tipo_archivo=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_TIPO_ARCHIVO, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_TIPO_ARCHIVO = 1; 
    TipoArchConciTar pers = (TipoArchConciTar) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update cTarTiposArch "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_tipo_archivo=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_TIPO_ARCHIVO, pers.getOID()); 
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
      case IDBObjetoPersistente.SELECT_ALL_ACTIVOS: { 
          ps = this.selectAllActivos(aCondiciones); 
          break; 
        }      
    } 
    return ps;
  } 

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_TIPO_ARCHIVO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  cTarTiposArch "); 
    textSQL.append(" WHERE oid_tipo_archivo = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_TIPO_ARCHIVO, oid); 
    return querySelect; 
  }
  
  private PreparedStatement selectAllActivos(Object aCondiciones) throws BaseException, SQLException { 
	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM  cTarTiposArch "); 
	    textSQL.append(" WHERE activo=1 ");
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
	    return querySelect; 
   }  
  
  
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  cTarTiposArch "); 
    textSQL.append(" WHERE codigo = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_tipo_archivo oid,codigo codigo, descripcion descripcion ,activo ");
    textSQL.append(" from cTarTiposArch");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  }
  
  public static List getAllActivos(ISesion aSesion) throws BaseException {
	  return (List) ObjetoLogico.getObjects(TipoArchConciTar.NICKNAME,
             DBTipoArchConciTar.SELECT_ALL_ACTIVOS,
             null,
             new ListObserver(),
             aSesion);
  }  
  
} 
