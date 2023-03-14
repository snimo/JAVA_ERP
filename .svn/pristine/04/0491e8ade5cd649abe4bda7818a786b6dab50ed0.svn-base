package com.srn.erp.ventas.da;

import java.sql.*;
import java.util.List;

import com.srn.erp.ventas.bm.*;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.*;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.*;

public class DBAplicFacturadoRemito extends DBObjetoPersistente {

  public static final String OID_FACT_REM = "oid_fact_rem";
  public static final String OID_REMITO_DET = "oid_remito_det";
  public static final String CANT_FACT = "cant_fact";
  public static final String COMPO_COMPRO = "compo_compro";
  public static final String OID_CCO_FACT = "oid_cco_fact";
  public static final String OID_CCO_FACT_DET = "oid_cco_fact_det";
  public static final String ACTIVO = "activo";
  
  public static final int SELECT_BY_CCO_FACT = 100;

  public DBAplicFacturadoRemito() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_FACT_REM = 1;
    final int OID_REMITO_DET = 2;
    final int CANT_FACT = 3;
    final int COMPO_COMPRO = 4;
    final int OID_CCO_FACT = 5;
    final int OID_CCO_FACT_DET = 6;
    final int ACTIVO = 7;

    AplicFacturadoRemito pers = (AplicFacturadoRemito) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into veFacturadoRemito "+
                     " ( "+
                      "OID_FACT_REM,"+
                      "OID_REMITO_DET,"+
                      "CANT_FACT,"+
                      "COMPO_COMPRO,"+
                      "OID_CCO_FACT,"+
                      "OID_CCO_FACT_DET,"+
                      "ACTIVO)"+ 
                      " values "+ 
                      "("+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_FACT_REM,pers.getOID());
    qInsert.setInt(OID_REMITO_DET,pers.getRemito_det().getOID());
    qInsert.setDouble(CANT_FACT,pers.getCant_fact().doubleValue());
    qInsert.setString(COMPO_COMPRO,pers.getCompo_compro());
    qInsert.setInt(OID_CCO_FACT,pers.getFactura().getOID());
    qInsert.setInt(OID_CCO_FACT_DET,pers.getFactura_det().getOID());
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_REMITO_DET = 1;
    final int CANT_FACT = 2;
    final int COMPO_COMPRO = 3;
    final int OID_CCO_FACT = 4;
    final int OID_CCO_FACT_DET = 5;
    final int ACTIVO = 6;
    final int OID_FACT_REM = 7;

    AplicFacturadoRemito pers = (AplicFacturadoRemito) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update veFacturadoRemito set "+
              "oid_remito_det=?"+ 
              ",cant_fact=?"+ 
              ",compo_compro=?"+ 
              ",oid_cco_fact=?"+ 
              ",oid_cco_fact_det=?"+ 
              ",activo=?"+ 
                 " where " +
                 " oid_fact_rem=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_FACT_REM,pers.getOID());
    qUpdate.setInt(OID_REMITO_DET,pers.getRemito_det().getOID());
    qUpdate.setDouble(CANT_FACT,pers.getCant_fact().doubleValue());
    qUpdate.setString(COMPO_COMPRO,pers.getCompo_compro());
    qUpdate.setInt(OID_CCO_FACT,pers.getFactura().getOID());
    qUpdate.setInt(OID_CCO_FACT_DET,pers.getFactura_det().getOID());
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_FACT_REM = 1; 
    AplicFacturadoRemito pers = (AplicFacturadoRemito) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update veFacturadoRemito "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_fact_rem=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_FACT_REM, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_FACT_REM = 1; 
    AplicFacturadoRemito pers = (AplicFacturadoRemito) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update veFacturadoRemito "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_fact_rem=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_FACT_REM, pers.getOID()); 
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
      case SELECT_BY_CCO_FACT: {
        ps = this.selectByFactura(aCondiciones); 
        break; 
      }
    } 
    return ps;
  } 

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_FACT_REM = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  veFacturadoRemito "); 
    textSQL.append(" WHERE oid_fact_rem = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_FACT_REM, oid); 
    return querySelect; 
  }
  
  private PreparedStatement selectByFactura(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_FACTURA = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  veFacturadoRemito "); 
    textSQL.append(" WHERE oid_cco_fact = ? and activo = 1 "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    FacturaCab factura = (FacturaCab) aCondiciones;
    querySelect.setInt(OID_FACTURA, factura.getOID()); 
    return querySelect; 
  }
  
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  veFacturadoRemito "); 
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_fact_rem oid, codigo,  descripcion ,activo ");
    textSQL.append(" from veFacturadoRemito");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  } 
  
  public static List getAplicRemitosFact(FacturaCab factura,
      ISesion aSesion) throws BaseException {
  	return (List) ObjetoLogico.getObjects(AplicFacturadoRemito.NICKNAME,
        DBAplicFacturadoRemito.SELECT_BY_CCO_FACT,
        factura,
        new ListObserver(),
        aSesion);
  }
  
  
} 
