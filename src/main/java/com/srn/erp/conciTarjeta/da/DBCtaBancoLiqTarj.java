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

public class DBCtaBancoLiqTarj extends DBObjetoPersistente {

  public static final String OID_CTA_BANCO = "oid_cta_banco";
  public static final String CODIGO = "codigo";
  public static final String DESCRIPCION = "descripcion";
  public static final String COD_INTERFAZ = "cod_interfaz";
  public static final String ACTIVO = "activo";
  public static final String OID_EMPRESA = "oid_empresa";
  
  public static final int SELECT_BY_EMPRESA = 100;

  public DBCtaBancoLiqTarj() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_CTA_BANCO = 1;
    final int CODIGO = 2;
    final int DESCRIPCION = 3;
    final int COD_INTERFAZ = 4;
    final int ACTIVO = 5;
    final int OID_EMPRESA = 6;

    CtaBancoLiqTarj pers = (CtaBancoLiqTarj) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into cTarCtasBancarias "+
                     " ( "+
                      "OID_CTA_BANCO,"+
                      "CODIGO,"+
                      "DESCRIPCION,"+
                      "COD_INTERFAZ,"+
                      "ACTIVO,OID_EMPRESA)"+ 
                      " values "+ 
                      "("+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_CTA_BANCO,pers.getOID());
    qInsert.setString(CODIGO,pers.getCodigo());
    qInsert.setString(DESCRIPCION,pers.getDescripcion());
    qInsert.setString(COD_INTERFAZ,pers.getCod_interfaz());
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    if (pers.getEmpresa()!=null)
    	qInsert.setInt(OID_EMPRESA, pers.getEmpresa().getOID());
    else
    	qInsert.setNull(OID_EMPRESA, Types.INTEGER);
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int CODIGO = 1;
    final int DESCRIPCION = 2;
    final int COD_INTERFAZ = 3;
    final int ACTIVO = 4;
    final int OID_EMPRESA = 5;
    final int OID_CTA_BANCO = 6;

    CtaBancoLiqTarj pers = (CtaBancoLiqTarj) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update cTarCtasBancarias set "+
              "codigo=?"+ 
              ",descripcion=?"+ 
              ",cod_interfaz=?"+ 
              ",activo=?"+ 
              ",oid_empresa=?"+
                 " where " +
                 " oid_cta_banco=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_CTA_BANCO,pers.getOID());
    qUpdate.setString(CODIGO,pers.getCodigo());
    qUpdate.setString(DESCRIPCION,pers.getDescripcion());
    qUpdate.setString(COD_INTERFAZ,pers.getCod_interfaz());
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    if (pers.getEmpresa()!=null)
    	qUpdate.setInt(OID_EMPRESA, pers.getEmpresa().getOID());
    else
    	qUpdate.setNull(OID_EMPRESA, Types.INTEGER);
    
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_CTA_BANCO = 1; 
    CtaBancoLiqTarj pers = (CtaBancoLiqTarj) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update cTarCtasBancarias "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_cta_banco=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_CTA_BANCO, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_CTA_BANCO = 1; 
    CtaBancoLiqTarj pers = (CtaBancoLiqTarj) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update cTarCtasBancarias "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_cta_banco=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_CTA_BANCO, pers.getOID()); 
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
      case SELECT_BY_EMPRESA: {
        ps = this.selectByEmpresa(aCondiciones); 
        break; 
      }
    } 
    return ps;
  } 

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_CTA_BANCO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  cTarCtasBancarias "); 
    textSQL.append(" WHERE oid_cta_banco = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_CTA_BANCO, oid); 
    return querySelect; 
  }

  private PreparedStatement selectByEmpresa(Object aCondiciones) throws BaseException, SQLException { 
	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM  cTarCtasBancarias "); 
	    textSQL.append(" WHERE oid_empresa = ? ");
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
	    EmpresaConciTar empresa = (EmpresaConciTar) aCondiciones; 
	    querySelect.setInt(1, empresa.getOID()); 
	    return querySelect; 
  }
  
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  cTarCtasBancarias "); 
    textSQL.append(" WHERE codigo = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_cta_banco oid,codigo codigo, descripcion descripcion ,activo ");
    textSQL.append(" from cTarCtasBancarias");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  }
  
  public static List getCtasByEmpresa(EmpresaConciTar empresa,ISesion aSesion) throws BaseException {
	  return (List) ObjetoLogico.getObjects(CtaBancoLiqTarj.NICKNAME,
             DBCtaBancoLiqTarj.SELECT_BY_EMPRESA,
             empresa,
             new ListObserver(),
             aSesion);
  }
  
  
} 
