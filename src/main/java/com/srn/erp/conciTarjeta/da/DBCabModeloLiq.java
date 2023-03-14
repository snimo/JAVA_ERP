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

public class DBCabModeloLiq extends DBObjetoPersistente {

  public static final String OID_MODELO_LIQ = "oid_modelo_liq";
  public static final String CODIGO = "codigo";
  public static final String DESCRIPCION = "descripcion";
  public static final String ACTIVO = "activo";
  public static final String COMEN_ASIENTO = "comen_asiento";
  
  public static final int SELECT_BY_EMPRESA = 100;

  public DBCabModeloLiq() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_MODELO_LIQ = 1;
    final int CODIGO = 2;
    final int DESCRIPCION = 3;
    final int ACTIVO = 4;
    final int COMEN_ASIENTO = 5;

    CabModeloLiq pers = (CabModeloLiq) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into cTarCabModLiq "+
                     " ( "+
                      "OID_MODELO_LIQ,"+
                      "CODIGO,"+
                      "DESCRIPCION,"+
                      "ACTIVO,COMEN_ASIENTO)"+ 
                      " values "+ 
                      "("+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_MODELO_LIQ,pers.getOID());
    qInsert.setString(CODIGO,pers.getCodigo());
    qInsert.setString(DESCRIPCION,pers.getDescripcion());
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    if (pers.getComenAsiento()!=null)
    	qInsert.setString(COMEN_ASIENTO, pers.getComenAsiento());
    else
    	qInsert.setNull(COMEN_ASIENTO, Types.VARCHAR);
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int CODIGO = 1;
    final int DESCRIPCION = 2;
    final int ACTIVO = 3;
    final int COMEN_ASIENTO = 4;
    final int OID_MODELO_LIQ = 5;

    CabModeloLiq pers = (CabModeloLiq) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update cTarCabModLiq set "+
              "codigo=?"+ 
              ",descripcion=?"+ 
              ",activo=?"+ 
              ",comen_asiento=?"+
                 " where " +
                 " oid_modelo_liq=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_MODELO_LIQ,pers.getOID());
    qUpdate.setString(CODIGO,pers.getCodigo());
    qUpdate.setString(DESCRIPCION,pers.getDescripcion());
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    if (pers.getComenAsiento()!=null)
    	qUpdate.setString(COMEN_ASIENTO,pers.getComenAsiento());
    else
    	qUpdate.setNull(COMEN_ASIENTO,Types.VARCHAR);
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_MODELO_LIQ = 1; 
    CabModeloLiq pers = (CabModeloLiq) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update cTarCabModLiq "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_modelo_liq=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_MODELO_LIQ, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_MODELO_LIQ = 1; 
    CabModeloLiq pers = (CabModeloLiq) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update cTarCabModLiq "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_modelo_liq=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_MODELO_LIQ, pers.getOID()); 
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
      case IDBObjetoPersistente.SELECT_ALL_ACTIVOS_HELP: { 
          ps = this.selectAllHelpActivos(aCondiciones); 
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

    final int OID_MODELO_LIQ = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  cTarCabModLiq "); 
    textSQL.append(" WHERE oid_modelo_liq = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_MODELO_LIQ, oid); 
    return querySelect; 
  }
  
  private PreparedStatement selectByEmpresa(Object aCondiciones) throws BaseException, SQLException { 
	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM  cTarCabModLiq "); 
	    textSQL.append(" WHERE oid_modelo_liq in ");
	    textSQL.append(" (select a.oid_modelo_liq from cTarTarjModLiq a , cTarTarjConci b where a.oid_tar_conci=b.oid_tar_conci and a.activo=1 and b.activo=1 and a.oid_empresa=?) ");
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
	    EmpresaConciTar empresa = (EmpresaConciTar) aCondiciones; 
	    querySelect.setInt(1, empresa.getOID()); 
	    return querySelect;
  }  
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  cTarCabModLiq "); 
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }
  
  private PreparedStatement selectAllHelpActivos(Object aCondiciones) throws BaseException, SQLException {
	    StringBuffer textSQL = new StringBuffer();
	    textSQL.append("SELECT oid_modelo_liq oid, codigo,  descripcion ,activo ");
	    textSQL.append(" from cTarCabModLiq where activo = 1");
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
	    return querySelect; 
  }  
  
  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_modelo_liq oid, codigo,  descripcion ,activo ");
    textSQL.append(" from cTarCabModLiq");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  }
  
  public static List getCabModLiq(EmpresaConciTar empresa,
          ISesion aSesion) throws BaseException {
	  return (List) ObjetoLogico.getObjects(CabModeloLiq.NICKNAME,
             DBCabModeloLiq.SELECT_BY_EMPRESA,
             empresa,
             new ListObserver(),
             aSesion);
  }  
  
} 
