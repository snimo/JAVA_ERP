package com.srn.erp.pagos.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.pagos.bm.RendicionFondoFijo;
import com.srn.erp.pagos.bm.RendicionFondoFijoMedioPago;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;

public class DBRendicionFondoFijoMedioPago extends DBObjetoPersistente {

  public static final String OID_REND_MED_PAGO = "oid_rend_med_pago";
  public static final String OID_REND_FONDO = "oid_rend_fondo";
  public static final String OID_VALOR = "oid_valor";
  public static final String OID_TIPO_VALOR = "oid_tipo_valor";
  public static final String COTIZACION = "cotizacion";
  public static final String IMPORTE = "importe";
  public static final String IMPO_MON_REND_FF = "impo_mon_rend_ff";
  public static final String IMPO_MON_LOC = "impo_mon_loc";
  public static final String INGRESO_EGRESO = "ingreso_egreso";
  public static final String OID_CAJA = "oid_caja";
  
  public static final int SELECT_BY_REND_FF = 100;

  public DBRendicionFondoFijoMedioPago() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_REND_MED_PAGO = 1;
    final int OID_REND_FONDO = 2;
    final int OID_VALOR = 3;
    final int OID_TIPO_VALOR = 4;
    final int COTIZACION = 5;
    final int IMPORTE = 6;
    final int IMPO_MON_REND_FF = 7;
    final int IMPO_MON_LOC = 8;
    final int INGRESO_EGRESO = 9;
    final int OID_CAJA = 10;

    RendicionFondoFijoMedioPago pers = (RendicionFondoFijoMedioPago) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into opRendFFMedPago "+
                     " ( "+
                      "OID_REND_MED_PAGO,"+
                      "OID_REND_FONDO,"+
                      "OID_VALOR,"+
                      "OID_TIPO_VALOR,"+
                      "COTIZACION,"+
                      "IMPORTE,"+
                      "IMPO_MON_REND_FF,"+
                      "IMPO_MON_LOC,INGRESO_EGRESO,OID_CAJA)"+ 
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
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_REND_MED_PAGO,pers.getOID());
    qInsert.setInt(OID_REND_FONDO,pers.getRendicion_fondo().getOID());
    if (pers.getValor()!=null) 
      qInsert.setInt(OID_VALOR,pers.getValor().getOID());
    else
      qInsert.setNull(OID_VALOR,java.sql.Types.INTEGER);
    qInsert.setInt(OID_TIPO_VALOR,pers.getTipo_valor().getOID());
    qInsert.setDouble(COTIZACION,pers.getCotizacion().doubleValue());
    qInsert.setDouble(IMPORTE,pers.getImporte().doubleValue());
    qInsert.setDouble(IMPO_MON_REND_FF,pers.getImpo_mon_rend_ff().doubleValue());
    qInsert.setDouble(IMPO_MON_LOC,pers.getImpo_mon_loc().doubleValue());
    qInsert.setString(INGRESO_EGRESO,pers.getIngresoEgreso());
    qInsert.setInt(OID_CAJA, pers.getCaja().getOID());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_REND_FONDO = 1;
    final int OID_VALOR = 2;
    final int OID_TIPO_VALOR = 3;
    final int COTIZACION = 4;
    final int IMPORTE = 5;
    final int IMPO_MON_REND_FF = 6;
    final int IMPO_MON_LOC = 7;
    final int INGRESO_EGRESO = 8;
    final int OID_CAJA = 9;
    final int OID_REND_MED_PAGO = 10;

    RendicionFondoFijoMedioPago pers = (RendicionFondoFijoMedioPago) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update opRendFFMedPago set "+
              "oid_rend_fondo=?"+ 
              ",oid_valor=?"+ 
              ",oid_tipo_valor=?"+ 
              ",cotizacion=?"+ 
              ",importe=?"+ 
              ",impo_mon_rend_ff=?"+ 
              ",impo_mon_loc=?"+
              ",ingreso_egreso=?"+
              ",oid_caja=?"+
                 " where " +
                 " oid_rend_med_pago=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_REND_MED_PAGO,pers.getOID());
    qUpdate.setInt(OID_REND_FONDO,pers.getRendicion_fondo().getOID());
    if (pers.getValor()!=null) 
      qUpdate.setInt(OID_VALOR,pers.getValor().getOID());
    else
      qUpdate.setNull(OID_VALOR,java.sql.Types.INTEGER);
    qUpdate.setInt(OID_TIPO_VALOR,pers.getTipo_valor().getOID());
    qUpdate.setDouble(COTIZACION,pers.getCotizacion().doubleValue());
    qUpdate.setDouble(IMPORTE,pers.getImporte().doubleValue());
    qUpdate.setDouble(IMPO_MON_REND_FF,pers.getImpo_mon_rend_ff().doubleValue());
    qUpdate.setDouble(IMPO_MON_LOC,pers.getImpo_mon_loc().doubleValue());
    qUpdate.setString(INGRESO_EGRESO,pers.getIngresoEgreso());
    qUpdate.setInt(OID_CAJA, pers.getCaja().getOID());
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_REND_MED_PAGO = 1; 
    RendicionFondoFijoMedioPago pers = (RendicionFondoFijoMedioPago) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update opRendFFMedPago "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_rend_med_pago=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_REND_MED_PAGO, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_REND_MED_PAGO = 1; 
    RendicionFondoFijoMedioPago pers = (RendicionFondoFijoMedioPago) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update opRendFFMedPago "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_rend_med_pago=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_REND_MED_PAGO, pers.getOID()); 
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
      case SELECT_BY_REND_FF: {
        ps = this.selectByRendFF(aCondiciones); 
        break; 
      }
    } 
    return ps;
  } 

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_REND_MED_PAGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  opRendFFMedPago "); 
    textSQL.append(" WHERE oid_rend_med_pago = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_REND_MED_PAGO, oid); 
    return querySelect; 
  }
  
  
  private PreparedStatement selectByRendFF(Object aCondiciones) throws BaseException, SQLException { 
	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM  opRendFFMedPago "); 
	    textSQL.append(" WHERE OID_REND_FONDO = ? ");
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
	    RendicionFondoFijo rendFondoFijo = (RendicionFondoFijo) aCondiciones; 
	    querySelect.setInt(1, rendFondoFijo.getOID()); 
	    return querySelect; 
  }
  
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  opRendFFMedPago "); 
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_rend_med_pago oid, codigo,  descripcion ,activo ");
    textSQL.append(" from opRendFFMedPago");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  } 
  
  public static List getValores(RendicionFondoFijo rendFondoFijo,
          ISesion aSesion) throws BaseException {
    return (List) ObjetoLogico.getObjects(RendicionFondoFijoMedioPago.NICKNAME,
             DBRendicionFondoFijoMedioPago.SELECT_BY_REND_FF,
             rendFondoFijo,
             new ListObserver(),
             aSesion);
  }
  
  
} 
