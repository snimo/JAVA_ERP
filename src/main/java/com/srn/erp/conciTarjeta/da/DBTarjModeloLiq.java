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

public class DBTarjModeloLiq extends DBObjetoPersistente {

  public static final String OID_TARJ_MOD_LIQ = "oid_tarj_mod_liq";
  public static final String OID_TAR_CONCI = "oid_tar_conci";
  public static final String OID_EMPRESA = "oid_empresa";
  public static final String OID_MODELO_LIQ = "oid_modelo_liq";
  public static final String ACTIVO = "activo";
  
  public static final int SELECT_BY_TARJETA = 100;
  
  public DBTarjModeloLiq() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_TARJ_MOD_LIQ = 1;
    final int OID_TAR_CONCI = 2;
    final int OID_EMPRESA = 3;
    final int OID_MODELO_LIQ = 4;
    final int ACTIVO = 5;

    TarjModeloLiq pers = (TarjModeloLiq) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into cTarTarjModLiq "+
                     " ( "+
                      "OID_TARJ_MOD_LIQ,"+
                      "OID_TAR_CONCI,"+
                      "OID_EMPRESA,"+
                      "OID_MODELO_LIQ,"+
                      "ACTIVO)"+ 
                      " values "+ 
                      "("+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_TARJ_MOD_LIQ,pers.getOID());
    qInsert.setInt(OID_TAR_CONCI,pers.getTarjeta().getOID());
    qInsert.setInt(OID_EMPRESA,pers.getEmpresa().getOID());
    qInsert.setInt(OID_MODELO_LIQ,pers.getModelo_liquidacion().getOID());
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_TAR_CONCI = 1;
    final int OID_EMPRESA = 2;
    final int OID_MODELO_LIQ = 3;
    final int ACTIVO = 4;
    final int OID_TARJ_MOD_LIQ = 5;

    TarjModeloLiq pers = (TarjModeloLiq) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update cTarTarjModLiq set "+
              "oid_tar_conci=?"+ 
              ",oid_empresa=?"+ 
              ",oid_modelo_liq=?"+ 
              ",activo=?"+ 
                 " where " +
                 " oid_tarj_mod_liq=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_TARJ_MOD_LIQ,pers.getOID());
    qUpdate.setInt(OID_TAR_CONCI,pers.getTarjeta().getOID());
    qUpdate.setInt(OID_EMPRESA,pers.getEmpresa().getOID());
    qUpdate.setInt(OID_MODELO_LIQ,pers.getModelo_liquidacion().getOID());
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_TARJ_MOD_LIQ = 1; 
    TarjModeloLiq pers = (TarjModeloLiq) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update cTarTarjModLiq "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_tarj_mod_liq=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_TARJ_MOD_LIQ, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_TARJ_MOD_LIQ = 1; 
    TarjModeloLiq pers = (TarjModeloLiq) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update cTarTarjModLiq "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_tarj_mod_liq=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_TARJ_MOD_LIQ, pers.getOID()); 
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
      case SELECT_BY_TARJETA: {
          ps = this.selectByTarjeta(aCondiciones); 
          break;    	  
      }
    } 
    return ps;
  } 

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_TARJ_MOD_LIQ = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  cTarTarjModLiq "); 
    textSQL.append(" WHERE oid_tarj_mod_liq = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_TARJ_MOD_LIQ, oid); 
    return querySelect; 
  }
  
  
  private PreparedStatement selectByTarjeta(Object aCondiciones) throws BaseException, SQLException { 
	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM cTarTarjModLiq "); 
	    textSQL.append(" WHERE oid_tar_conci = ? and activo=1 ");
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
	    TarjetaConciTar tarjeta = (TarjetaConciTar) aCondiciones; 
	    querySelect.setInt(1, tarjeta.getOID()); 
	    return querySelect; 
  }  
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  cTarTarjModLiq "); 
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_tarj_mod_liq oid, codigo,  descripcion ,activo ");
    textSQL.append(" from cTarTarjModLiq");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  }
  
  public static List getTarjetaModLiq(TarjetaConciTar tarjeta,
          ISesion aSesion) throws BaseException {
	  return (List) ObjetoLogico.getObjects(TarjModeloLiq.NICKNAME,
             DBTarjModeloLiq.SELECT_BY_TARJETA,
             tarjeta,
             new ListObserver(),
             aSesion);
  }
  
  
} 
