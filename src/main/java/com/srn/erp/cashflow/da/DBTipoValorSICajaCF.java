package com.srn.erp.cashflow.da;

import java.sql.*;
import java.util.List;

import com.srn.erp.cashflow.bm.*;
import com.srn.erp.general.bm.PeriodoInc;
import com.srn.erp.general.bm.PeriodoIncDet;
import com.srn.erp.general.da.DBPeriodoIncDet;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.*;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.*;

public class DBTipoValorSICajaCF extends DBObjetoPersistente {

  public static final String OID_TV_SAL_INI = "oid_tv_sal_ini";
  public static final String OID_SAL_INI_CAJA = "oid_sal_ini_caja";
  public static final String OID_TIPO_VALOR = "oid_tipo_valor";
  public static final String ACTIVO = "activo";
  
  public static final int SELECT_BY_SALDO_INI_CAJA = 100;

  public DBTipoValorSICajaCF() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_TV_SAL_INI = 1;
    final int OID_SAL_INI_CAJA = 2;
    final int OID_TIPO_VALOR = 3;
    final int ACTIVO = 4;

    TipoValorSICajaCF pers = (TipoValorSICajaCF) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into cfTVSalIniCaja "+
                     " ( "+
                      "OID_TV_SAL_INI,"+
                      "OID_SAL_INI_CAJA,"+
                      "OID_TIPO_VALOR,"+
                      "ACTIVO)"+ 
                      " values "+ 
                      "("+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_TV_SAL_INI,pers.getOID());
    qInsert.setInt(OID_SAL_INI_CAJA,pers.getSaldo_inicial_caja().getOID());
    qInsert.setInt(OID_TIPO_VALOR,pers.getTipo_valor().getOID());
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_SAL_INI_CAJA = 1;
    final int OID_TIPO_VALOR = 2;
    final int ACTIVO = 3;
    final int OID_TV_SAL_INI = 4;

    TipoValorSICajaCF pers = (TipoValorSICajaCF) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update cfTVSalIniCaja set "+
              "oid_sal_ini_caja=?"+ 
              ",oid_tipo_valor=?"+ 
              ",activo=?"+ 
                 " where " +
                 " oid_tv_sal_ini=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_TV_SAL_INI,pers.getOID());
    qUpdate.setInt(OID_SAL_INI_CAJA,pers.getSaldo_inicial_caja().getOID());
    qUpdate.setInt(OID_TIPO_VALOR,pers.getTipo_valor().getOID());
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_TV_SAL_INI = 1; 
    TipoValorSICajaCF pers = (TipoValorSICajaCF) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update cfTVSalIniCaja "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_tv_sal_ini=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_TV_SAL_INI, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_TV_SAL_INI = 1; 
    TipoValorSICajaCF pers = (TipoValorSICajaCF) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update cfTVSalIniCaja "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_tv_sal_ini=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_TV_SAL_INI, pers.getOID()); 
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
      case SELECT_BY_SALDO_INI_CAJA: {
          ps = this.selectBySaldoInicialCaja(aCondiciones); 
          break; 
      }
    } 
    return ps;
  } 

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_TV_SAL_INI = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  cfTVSalIniCaja "); 
    textSQL.append(" WHERE oid_tv_sal_ini = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_TV_SAL_INI, oid); 
    return querySelect; 
  }
  
  private PreparedStatement selectBySaldoInicialCaja(Object aCondiciones) throws BaseException, SQLException { 

	    final int CODIGO = 1; 

	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM  cfTVSalIniCaja "); 
	    textSQL.append(" WHERE oid_sal_ini_caja = ? ");
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
	    CajaSaldoIniCF cajaSaldoIniCF = (CajaSaldoIniCF) aCondiciones; 
	    querySelect.setInt(1, cajaSaldoIniCF.getOID()); 
	    return querySelect;
	    
  }
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  cfTVSalIniCaja "); 
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_tv_sal_ini oid, codigo,  descripcion ,activo ");
    textSQL.append(" from cfTVSalIniCaja");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  }
  
  public static List getTiposValoresSICaja(CajaSaldoIniCF cajaSaldoIniCF,
          ISesion aSesion) throws BaseException {
	    return (List) ObjetoLogico.getObjects(TipoValorSICajaCF.NICKNAME,
                DBTipoValorSICajaCF.SELECT_BY_SALDO_INI_CAJA,
                cajaSaldoIniCF,
                new ListObserver(),
                aSesion);
  }
  
  
} 
