package com.srn.erp.tesoreria.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.general.bm.PeriodoInc;
import com.srn.erp.general.bm.PeriodoIncDet;
import com.srn.erp.general.da.DBPeriodoIncDet;
import com.srn.erp.tesoreria.bm.LiquidacionTarCab;
import com.srn.erp.tesoreria.bm.LiquidacionTarjetaValor;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;

public class DBLiquidacionTarjetaValor extends DBObjetoPersistente {

  public static final String OID_LIQ_TAR_VAL = "oid_liq_tar_val";
  public static final String OID_LIQUI_TAR = "oid_liqui_tar";
  public static final String OID_VALOR = "oid_valor";
  public static final String IMPORTE = "importe";
  public static final String IMPORTE_MON_LOC = "importe_mon_loc";
  public static final String COTIZACION = "cotizacion";
  public static final String NRO = "nro";
  public static final String OID_TARJETA = "oid_tarjeta";
  public static final String OID_ANA_CON = "oid_ana_con";
  public static final String OID_BANCO = "oid_banco";
  public static final String ACTIVO = "activo";
  
  public static final int SELECT_BY_LIQUIDACION_TARJETA = 100;

  public DBLiquidacionTarjetaValor() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_LIQ_TAR_VAL = 1;
    final int OID_LIQUI_TAR = 2;
    final int OID_VALOR = 3;
    final int IMPORTE = 4;
    final int IMPORTE_MON_LOC = 5;
    final int COTIZACION = 6;
    final int NRO = 7;
    final int OID_TARJETA = 8;
    final int OID_ANA_CON = 9;
    final int OID_BANCO = 10;
    final int ACTIVO = 11;

    LiquidacionTarjetaValor pers = (LiquidacionTarjetaValor) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into vaLiquiTarValores "+
                     " ( "+
                      "OID_LIQ_TAR_VAL,"+
                      "OID_LIQUI_TAR,"+
                      "OID_VALOR,"+
                      "IMPORTE,"+
                      "IMPORTE_MON_LOC,"+
                      "COTIZACION,"+
                      "NRO,"+
                      "OID_TARJETA,"+
                      "OID_ANA_CON,"+
                      "OID_BANCO,"+
                      "ACTIVO)"+ 
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
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_LIQ_TAR_VAL,pers.getOID());
    qInsert.setInt(OID_LIQUI_TAR,pers.getLiquidacion_tarjeta().getOID());
    qInsert.setInt(OID_VALOR,pers.getValor().getOID());
    qInsert.setDouble(IMPORTE,pers.getImporte().doubleValue());
    qInsert.setDouble(IMPORTE_MON_LOC,pers.getImporte_mon_loc().doubleValue());
    qInsert.setDouble(COTIZACION,pers.getCotizacion().doubleValue());
    qInsert.setInt(NRO,pers.getNro().intValue());
    if (pers.getTarjeta()!=null) 
      qInsert.setInt(OID_TARJETA,pers.getTarjeta().getOID());
    else
      qInsert.setNull(OID_TARJETA,java.sql.Types.INTEGER);
    if (pers.getCuenta()!=null) 
      qInsert.setInt(OID_ANA_CON,pers.getCuenta().getOID());
    else
      qInsert.setNull(OID_ANA_CON,java.sql.Types.INTEGER);
    if (pers.getBanco()!=null) 
      qInsert.setInt(OID_BANCO,pers.getBanco().getOID());
    else
      qInsert.setNull(OID_BANCO,java.sql.Types.INTEGER);
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_LIQUI_TAR = 1;
    final int OID_VALOR = 2;
    final int IMPORTE = 3;
    final int IMPORTE_MON_LOC = 4;
    final int COTIZACION = 5;
    final int NRO = 6;
    final int OID_TARJETA = 7;
    final int OID_ANA_CON = 8;
    final int OID_BANCO = 9;
    final int ACTIVO = 10;
    final int OID_LIQ_TAR_VAL = 11;

    LiquidacionTarjetaValor pers = (LiquidacionTarjetaValor) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update vaLiquiTarValores set "+
              "oid_liqui_tar=?"+ 
              ",oid_valor=?"+ 
              ",importe=?"+ 
              ",importe_mon_loc=?"+ 
              ",cotizacion=?"+ 
              ",nro=?"+ 
              ",oid_tarjeta=?"+ 
              ",oid_ana_con=?"+ 
              ",oid_banco=?"+ 
              ",activo=?"+ 
                 " where " +
                 " oid_liq_tar_val=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_LIQ_TAR_VAL,pers.getOID());
    qUpdate.setInt(OID_LIQUI_TAR,pers.getLiquidacion_tarjeta().getOID());
    qUpdate.setInt(OID_VALOR,pers.getValor().getOID());
    qUpdate.setDouble(IMPORTE,pers.getImporte().doubleValue());
    qUpdate.setDouble(IMPORTE_MON_LOC,pers.getImporte_mon_loc().doubleValue());
    qUpdate.setDouble(COTIZACION,pers.getCotizacion().doubleValue());
    qUpdate.setInt(NRO,pers.getNro().intValue());
    if (pers.getTarjeta()!=null) 
      qUpdate.setInt(OID_TARJETA,pers.getTarjeta().getOID());
    else
      qUpdate.setNull
      (OID_TARJETA,java.sql.Types.INTEGER);
    if (pers.getCuenta()!=null) 
      qUpdate.setInt(OID_ANA_CON,pers.getCuenta().getOID());
    else
      qUpdate.setNull(OID_ANA_CON,java.sql.Types.INTEGER);
    if (pers.getBanco()!=null) 
      qUpdate.setInt(OID_BANCO,pers.getBanco().getOID());
    else
      qUpdate.setNull(OID_BANCO,java.sql.Types.INTEGER);
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_LIQ_TAR_VAL = 1; 
    LiquidacionTarjetaValor pers = (LiquidacionTarjetaValor) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update vaLiquiTarValores "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_liq_tar_val=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_LIQ_TAR_VAL, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_LIQ_TAR_VAL = 1; 
    LiquidacionTarjetaValor pers = (LiquidacionTarjetaValor) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update vaLiquiTarValores "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_liq_tar_val=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_LIQ_TAR_VAL, pers.getOID()); 
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

    final int OID_LIQ_TAR_VAL = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  vaLiquiTarValores "); 
    textSQL.append(" WHERE oid_liq_tar_val = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_LIQ_TAR_VAL, oid); 
    return querySelect; 
  }
  
  
  private PreparedStatement selectByLiquidacionTarjeta(Object aCondiciones) throws BaseException, SQLException { 
	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM  vaLiquiTarValores "); 
	    textSQL.append(" WHERE oid_liq_tar = ? ");
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
	    LiquidacionTarCab liquidacion = (LiquidacionTarCab) aCondiciones; 
	    querySelect.setInt(1, liquidacion.getOID()); 
	    return querySelect; 
  }

  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  vaLiquiTarValores "); 
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_liq_tar_val oid, codigo,  descripcion ,activo ");
    textSQL.append(" from vaLiquiTarValores");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  }
  
  public static List getLiquidacionesTarjetasValor(
		  LiquidacionTarCab liquidacionTarCab,
          ISesion aSesion) throws BaseException {
	  return (List) ObjetoLogico.getObjects(LiquidacionTarjetaValor.NICKNAME,
             DBLiquidacionTarjetaValor.SELECT_BY_LIQUIDACION_TARJETA,
             liquidacionTarCab,
             new ListObserver(),
             aSesion);
  }
  
  
} 
