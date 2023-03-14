package com.srn.erp.tesoreria.da;

import java.sql.*;
import java.util.List;

import com.srn.erp.general.bm.PeriodoInc;
import com.srn.erp.general.bm.PeriodoIncDet;
import com.srn.erp.general.da.DBPeriodoIncDet;
import com.srn.erp.tesoreria.bm.*;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.*;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.*;

public class DBLiquidacionTarjetaDet extends DBObjetoPersistente {

  public static final String OID_LIQUI_DET = "oid_liqui_det";
  public static final String OID_LIQUI_TAR = "oid_liqui_tar";
  public static final String OID_VALOR = "oid_valor";
  public static final String IMPO_LIQUIDADO = "impo_liquidado";
  public static final String ACTIVO = "activo";
  public static final String NRO_CUOTA = "nro_cuota";
  
  public static final int SELECT_BY_LIQUIDACION_TARJETA = 100;

  public DBLiquidacionTarjetaDet() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_LIQUI_DET = 1;
    final int OID_LIQUI_TAR = 2;
    final int OID_VALOR = 3;
    final int IMPO_LIQUIDADO = 4;
    final int ACTIVO = 5;
    final int NRO_CUOTA = 6;

    LiquidacionTarjetaDet pers = (LiquidacionTarjetaDet) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into vaLiquiTarjetaDet "+
                     " ( "+
                      "OID_LIQUI_DET,"+
                      "OID_LIQUI_TAR,"+
                      "OID_VALOR,"+
                      "IMPO_LIQUIDADO,"+
                      "ACTIVO,NRO_CUOTA)"+ 
                      " values "+ 
                      "("+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_LIQUI_DET,pers.getOID());
    qInsert.setInt(OID_LIQUI_TAR,pers.getLiquidacion_tar().getOID());
    qInsert.setInt(OID_VALOR,pers.getValor().getOID());
    qInsert.setDouble(IMPO_LIQUIDADO,pers.getImporte_liquidado().doubleValue());
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    if (pers.getNroCuota()!=null)
    	qInsert.setInt(NRO_CUOTA,pers.getNroCuota().intValue());
    else
    	qInsert.setInt(NRO_CUOTA,0);
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_LIQUI_TAR = 1;
    final int OID_VALOR = 2;
    final int IMPO_LIQUIDADO = 3;
    final int ACTIVO = 4;
    final int NRO_CUOTA = 5;
    final int OID_LIQUI_DET = 6;

    LiquidacionTarjetaDet pers = (LiquidacionTarjetaDet) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update vaLiquiTarjetaDet set "+
              "oid_liqui_tar=?"+ 
              ",oid_valor=?"+ 
              ",impo_liquidado=?"+ 
              ",activo=?"+ 
              ",nro_cuota=?"+
                 " where " +
                 " oid_liqui_det=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_LIQUI_DET,pers.getOID());
    qUpdate.setInt(OID_LIQUI_TAR,pers.getLiquidacion_tar().getOID());
    qUpdate.setInt(OID_VALOR,pers.getValor().getOID());
    qUpdate.setDouble(IMPO_LIQUIDADO,pers.getImporte_liquidado().doubleValue());
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    if (pers.getNroCuota()!=null)
    	qUpdate.setInt(NRO_CUOTA,pers.getNroCuota().intValue());
    else
    	qUpdate.setInt(NRO_CUOTA,0);    
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_LIQUI_DET = 1; 
    LiquidacionTarjetaDet pers = (LiquidacionTarjetaDet) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update vaLiquiTarjetaDet "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_liqui_det=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_LIQUI_DET, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_LIQUI_DET = 1; 
    LiquidacionTarjetaDet pers = (LiquidacionTarjetaDet) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update vaLiquiTarjetaDet "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_liqui_det=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_LIQUI_DET, pers.getOID()); 
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
      case SELECT_BY_LIQUIDACION_TARJETA: {
          ps = this.selectByLiquidacionTarjeta(aCondiciones); 
          break; 
      }
    } 
    return ps;
  } 

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_LIQUI_DET = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  vaLiquiTarjetaDet "); 
    textSQL.append(" WHERE oid_liqui_det = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_LIQUI_DET, oid); 
    return querySelect; 
  }

  private PreparedStatement selectByLiquidacionTarjeta(Object aCondiciones) throws BaseException, SQLException { 

	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM  vaLiquiTarjetaDet "); 
	    textSQL.append(" WHERE oid_liqui_tar = ?  ");
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
	    LiquidacionTarCab liquidacion = (LiquidacionTarCab) aCondiciones; 
	    querySelect.setInt(1, liquidacion.getOID()); 
	    return querySelect; 
  }

  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  vaLiquiTarjetaDet "); 
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_liqui_det oid, codigo,  descripcion ,activo ");
    textSQL.append(" from vaLiquiTarjetaDet");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  }
  
  public static List getLiquidacionTarjetasDet(LiquidacionTarCab liquidacionTarCab,
          ISesion aSesion) throws BaseException {
	  return (List) ObjetoLogico.getObjects(LiquidacionTarjetaDet.NICKNAME,
             DBLiquidacionTarjetaDet.SELECT_BY_LIQUIDACION_TARJETA,
             liquidacionTarCab,
             new ListObserver(),
             aSesion);
  }
  
  
} 
