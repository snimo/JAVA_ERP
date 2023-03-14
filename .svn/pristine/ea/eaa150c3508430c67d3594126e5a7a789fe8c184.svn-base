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

public class DBEscenarioCashFlow extends DBObjetoPersistente {

  public static final String OID_ESCENARIO = "oid_escenario";
  public static final String CODIGO = "codigo";
  public static final String DESCRIPCION = "descripcion";
  public static final String ACTIVO = "activo";
  public static final String VER_DEUDA_CLIENTES = "ver_deuda_clientes";
  public static final String OID_MONEDA = "oid_moneda";

  public DBEscenarioCashFlow() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_ESCENARIO = 1;
    final int CODIGO = 2;
    final int DESCRIPCION = 3;
    final int ACTIVO = 4;
    final int VER_DEUDA_CLIENTES = 5;
    final int OID_MONEDA = 6;

    EscenarioCashFlow pers = (EscenarioCashFlow) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into cfEscenario "+
                     " ( "+
                      "OID_ESCENARIO,"+
                      "CODIGO,"+
                      "DESCRIPCION,"+
                      "ACTIVO,VER_DEUDA_CLIENTES,OID_MONEDA)"+ 
                      " values "+ 
                      "("+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_ESCENARIO,pers.getOID());
    qInsert.setString(CODIGO,pers.getCodigo());
    qInsert.setString(DESCRIPCION,pers.getDescripcion());
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    if (pers.isVerDeudaClientes()!=null)
    	qInsert.setBoolean(VER_DEUDA_CLIENTES,pers.isVerDeudaClientes().booleanValue());
    else
    	qInsert.setBoolean(VER_DEUDA_CLIENTES,false);
    qInsert.setInt(OID_MONEDA,pers.getMoneda().getOID());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int CODIGO = 1;
    final int DESCRIPCION = 2;
    final int ACTIVO = 3;
    final int VER_DEUDA_CLIENTES = 4;
    final int OID_MONEDA = 5;
    final int OID_ESCENARIO = 6;

    EscenarioCashFlow pers = (EscenarioCashFlow) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update cfEscenario set "+
              "codigo=?"+ 
              ",descripcion=?"+ 
              ",activo=?"+
              ",ver_deuda_clientes=?"+
              ",oid_moneda=?"+
                 " where " +
                 " oid_escenario=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_ESCENARIO,pers.getOID());
    qUpdate.setString(CODIGO,pers.getCodigo());
    qUpdate.setString(DESCRIPCION,pers.getDescripcion());
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    if (pers.isVerDeudaClientes()!=null)
    	qUpdate.setBoolean(VER_DEUDA_CLIENTES,pers.isVerDeudaClientes().booleanValue());
    else
    	qUpdate.setBoolean(VER_DEUDA_CLIENTES,false);
    qUpdate.setInt(OID_MONEDA,pers.getMoneda().getOID());
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_ESCENARIO = 1; 
    EscenarioCashFlow pers = (EscenarioCashFlow) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update cfEscenario "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_escenario=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_ESCENARIO, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_ESCENARIO = 1; 
    EscenarioCashFlow pers = (EscenarioCashFlow) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update cfEscenario "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_escenario=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_ESCENARIO, pers.getOID()); 
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
      case IDBObjetoPersistente.SELECT_ALL: { 
          ps = this.selectAll(aCondiciones); 
          break; 
        } 
      
    } 
    return ps;
  } 

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_ESCENARIO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  cfEscenario "); 
    textSQL.append(" WHERE oid_escenario = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_ESCENARIO, oid); 
    return querySelect; 
  }
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  cfEscenario "); 
    textSQL.append(" WHERE codigo = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_escenario oid,codigo codigo, descripcion descripcion ,activo ");
    textSQL.append(" from cfEscenario");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  }
  
  private PreparedStatement selectAll(Object aCondiciones) throws BaseException, SQLException {

	    StringBuffer textSQL = new StringBuffer();

	    textSQL.append("SELECT * ");
	    textSQL.append(" from cfEscenario");
	    
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
	    return querySelect; 
	  } 
  
  
  public static List getEscenariosCF(ISesion aSesion) throws BaseException {
	  return (List) ObjetoLogico.getObjects(EscenarioCashFlow.NICKNAME,
             DBEscenarioCashFlow.SELECT_ALL,
             null,
             new ListObserver(),
             aSesion);
  }
  
  
} 
