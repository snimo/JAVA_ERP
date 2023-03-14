package com.srn.erp.conciTarjeta.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import com.srn.erp.conciTarjeta.bm.CabModeloLiq;
import com.srn.erp.conciTarjeta.bm.DetModeloLiq;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;

public class DBDetModeloLiq extends DBObjetoPersistente {

  public static final String OID_MODELO_DET = "oid_modelo_det";
  public static final String OID_MODELO_LIQ = "oid_modelo_liq";
  public static final String ORDEN = "orden";
  public static final String CUENTA = "cuenta";
  public static final String DESC_CUENTA = "desc_cuenta";
  public static final String COMPO1 = "compo1";
  public static final String COMPO2 = "compo2";
  public static final String DEBE = "debe";
  public static final String HABER = "haber";
  public static final String ACTIVO = "activo";
  public static final String COD_IMPUESTO = "cod_impuesto";
  public static final String PORC_IMP = "porc_imp";
  
  public static final int SELECT_BY_MODELO_LIQ = 100;

  public DBDetModeloLiq() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_MODELO_DET = 1;
    final int OID_MODELO_LIQ = 2;
    final int ORDEN = 3;
    final int CUENTA = 4;
    final int DESC_CUENTA = 5;
    final int COMPO1 = 6;
    final int COMPO2 = 7;
    final int DEBE = 8;
    final int HABER = 9;
    final int ACTIVO = 10;
    final int COD_IMPUESTO = 11;
    final int PORC_IMP = 12;

    DetModeloLiq pers = (DetModeloLiq) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into cTarDetModLiq "+
                     " ( "+
                      "OID_MODELO_DET,"+
                      "OID_MODELO_LIQ,"+
                      "ORDEN,"+
                      "CUENTA,"+
                      "DESC_CUENTA,"+
                      "COMPO1,"+
                      "COMPO2,"+
                      "DEBE,"+
                      "HABER,"+
                      "ACTIVO,"+
                      "COD_IMPUESTO,"+
                      "PORC_IMP)"+
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
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_MODELO_DET,pers.getOID());
    qInsert.setInt(OID_MODELO_LIQ,pers.getModelo().getOID());
    qInsert.setInt(ORDEN,pers.getOrden().intValue());
    qInsert.setString(CUENTA,pers.getCuenta());
    qInsert.setString(DESC_CUENTA,pers.getDesc_cuenta());
    qInsert.setString(COMPO1,pers.getCompo1());
    qInsert.setString(COMPO2,pers.getCompo2());
    if (pers.getDebe()!=null)
    	qInsert.setDouble(DEBE,pers.getDebe().doubleValue());
    else
    	qInsert.setNull(DEBE,Types.DOUBLE);
    if (pers.getHaber()!=null)
    	qInsert.setDouble(HABER,pers.getHaber().doubleValue());
    else
    	qInsert.setNull(HABER,Types.DOUBLE);
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    
    if (pers.getCodImpuesto()!=null)
    	qInsert.setString(COD_IMPUESTO, pers.getCodImpuesto());
    else
    	qInsert.setNull(COD_IMPUESTO, Types.VARCHAR);
    
    if (pers.getPorcImp()!=null)
    	qInsert.setDouble(PORC_IMP, pers.getPorcImp().doubleValue());
    else
    	qInsert.setNull(PORC_IMP, Types.DOUBLE);    
    
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_MODELO_LIQ = 1;
    final int ORDEN = 2;
    final int CUENTA = 3;
    final int DESC_CUENTA = 4;
    final int COMPO1 = 5;
    final int COMPO2 = 6;
    final int DEBE = 7;
    final int HABER = 8;
    final int ACTIVO = 9;
    final int COD_IMPUESTO = 10;
    final int PORC_IMP = 11;    
    final int OID_MODELO_DET = 12;

    DetModeloLiq pers = (DetModeloLiq) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update cTarDetModLiq set "+
              "oid_modelo_liq=?"+ 
              ",orden=?"+ 
              ",cuenta=?"+ 
              ",desc_cuenta=?"+ 
              ",compo1=?"+ 
              ",compo2=?"+ 
              ",debe=?"+ 
              ",haber=?"+ 
              ",activo=?"+ 
              ",cod_impuesto=?"+
              ",porc_imp=?"+
                 " where " +
                 " oid_modelo_det=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_MODELO_DET,pers.getOID());
    qUpdate.setInt(OID_MODELO_LIQ,pers.getModelo().getOID());
    qUpdate.setInt(ORDEN,pers.getOrden().intValue());
    qUpdate.setString(CUENTA,pers.getCuenta());
    qUpdate.setString(DESC_CUENTA,pers.getDesc_cuenta());
    qUpdate.setString(COMPO1,pers.getCompo1());
    qUpdate.setString(COMPO2,pers.getCompo2());
    if (pers.getDebe()!=null)
    	qUpdate.setDouble(DEBE,pers.getDebe().doubleValue());
    else
    	qUpdate.setNull(DEBE,Types.DOUBLE);
    if (pers.getHaber()!=null)
    	qUpdate.setDouble(HABER,pers.getHaber().doubleValue());
    else
    	qUpdate.setNull(HABER,Types.DOUBLE);    
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    if (pers.getCodImpuesto()!=null)
    	qUpdate.setString(COD_IMPUESTO, pers.getCodImpuesto());
    else
    	qUpdate.setNull(COD_IMPUESTO, Types.VARCHAR);
    
    if (pers.getPorcImp()!=null)
    	qUpdate.setDouble(PORC_IMP, pers.getPorcImp().doubleValue());
    else
    	qUpdate.setNull(PORC_IMP, Types.DOUBLE);    
    
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_MODELO_DET = 1; 
    DetModeloLiq pers = (DetModeloLiq) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update cTarDetModLiq "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_modelo_det=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_MODELO_DET, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_MODELO_DET = 1; 
    DetModeloLiq pers = (DetModeloLiq) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update cTarDetModLiq "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_modelo_det=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_MODELO_DET, pers.getOID()); 
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
      case SELECT_BY_MODELO_LIQ: {
          ps = this.selectByModeloLiqui(aCondiciones); 
          break;    	  
      }
    } 
    return ps;
  } 

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_MODELO_DET = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  cTarDetModLiq "); 
    textSQL.append(" WHERE oid_modelo_det = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_MODELO_DET, oid); 
    return querySelect; 
  }
  
  private PreparedStatement selectByModeloLiqui(Object aCondiciones) throws BaseException, SQLException { 
	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM  cTarDetModLiq "); 
	    textSQL.append(" WHERE oid_modelo_liq = ? and activo = 1 ");
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
	    CabModeloLiq cabModeloLiq = (CabModeloLiq) aCondiciones; 
	    querySelect.setInt(1, cabModeloLiq.getOID()); 
	    return querySelect; 
  }  
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  cTarDetModLiq "); 
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_modelo_det oid, codigo,  descripcion ,activo ");
    textSQL.append(" from cTarDetModLiq");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  }
  
  public static List getDetallesModLiq(
		  CabModeloLiq cabModeloLiq,
          ISesion aSesion) throws BaseException {
	  
	  return (List) ObjetoLogico.getObjects(DetModeloLiq.NICKNAME,
             DBDetModeloLiq.SELECT_BY_MODELO_LIQ,
             cabModeloLiq,
             new ListObserver(),
             aSesion);
  }
  
  
} 
