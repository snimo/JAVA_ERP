package com.srn.erp.turnos.da;

import java.sql.*;
import java.util.List;

import com.srn.erp.general.bm.Periodo;
import com.srn.erp.general.bm.PeriodoInc;
import com.srn.erp.general.bm.PeriodoIncDet;
import com.srn.erp.general.da.DBPeriodo;
import com.srn.erp.general.da.DBPeriodoIncDet;
import com.srn.erp.turnos.bm.*;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.*;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.*;

public class DBImpoDeudaSujetoTurnos extends DBObjetoPersistente {

  public static final String OID_DEUDA_SOCIO = "oid_deuda_socio";
  public static final String NRO_SOCIO = "nro_socio";
  public static final String FECHA = "fecha";
  public static final String COD_MOV = "cod_mov";
  public static final String NRO = "nro";
  public static final String SALDO = "saldo";
  public static final String CONCEPTO = "concepto";
  
  public static final int DELETE_ALL = 100; 
  public static final int SELECT_BY_NRO_SOCIO = 101;

  public DBImpoDeudaSujetoTurnos() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_DEUDA_SOCIO = 1;
    final int NRO_SOCIO = 2;
    final int FECHA = 3;
    final int COD_MOV = 4;
    final int NRO = 5;
    final int SALDO = 6;
    final int CONCEPTO = 7;

    ImpoDeudaSujetoTurnos pers = (ImpoDeudaSujetoTurnos) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into tuDeudaSocio "+
                     " ( "+
                      "OID_DEUDA_SOCIO,"+
                      "NRO_SOCIO,"+
                      "FECHA,"+
                      "COD_MOV,"+
                      "NRO,"+
                      "SALDO,"+
                      "CONCEPTO)"+ 
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
    qInsert.setInt(OID_DEUDA_SOCIO,pers.getOID());
    qInsert.setInt(NRO_SOCIO,pers.getNro_socio().intValue());
    qInsert.setDate(FECHA,new java.sql.Date(pers.getFecha().getTime()));
    qInsert.setString(COD_MOV,pers.getCod_mov());
    qInsert.setInt(NRO,pers.getNro().intValue());
    qInsert.setDouble(SALDO,pers.getSaldo().doubleValue());
    qInsert.setString(CONCEPTO,pers.getConcepto());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int NRO_SOCIO = 1;
    final int FECHA = 2;
    final int COD_MOV = 3;
    final int NRO = 4;
    final int SALDO = 5;
    final int CONCEPTO = 6;
    final int OID_DEUDA_SOCIO = 7;

    ImpoDeudaSujetoTurnos pers = (ImpoDeudaSujetoTurnos) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update tuDeudaSocio set "+
              "nro_socio=?"+ 
              ",fecha=?"+ 
              ",cod_mov=?"+ 
              ",nro=?"+ 
              ",saldo=?"+ 
              ",concepto=?"+ 
                 " where " +
                 " oid_deuda_socio=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_DEUDA_SOCIO,pers.getOID());
    qUpdate.setInt(NRO_SOCIO,pers.getNro_socio().intValue());
    qUpdate.setDate(FECHA,new java.sql.Date(pers.getFecha().getTime()));
    qUpdate.setString(COD_MOV,pers.getCod_mov());
    qUpdate.setInt(NRO,pers.getNro().intValue());
    qUpdate.setDouble(SALDO,pers.getSaldo().doubleValue());
    qUpdate.setString(CONCEPTO,pers.getConcepto());
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void deleteAll(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
	    StringBuffer sqlUpdate = new StringBuffer(); 
	    sqlUpdate.append("delete from tuDeudaSocio ");
	    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
	    qUpdate.executeUpdate();
	    qUpdate.close();
	  } 
  
  
  
  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_DEUDA_SOCIO = 1; 
    ImpoDeudaSujetoTurnos pers = (ImpoDeudaSujetoTurnos) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update tuDeudaSocio "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_deuda_socio=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_DEUDA_SOCIO, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_DEUDA_SOCIO = 1; 
    ImpoDeudaSujetoTurnos pers = (ImpoDeudaSujetoTurnos) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update tuDeudaSocio "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_deuda_socio=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_DEUDA_SOCIO, pers.getOID()); 
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
      case DELETE_ALL: {
           this.deleteAll(null); 
          break; 
      }
      case SELECT_BY_NRO_SOCIO: {
          ps = this.selectByNroSocio(aCondiciones); 
          break; 
      }
    } 
    return ps;
  } 

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_DEUDA_SOCIO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  tuDeudaSocio "); 
    textSQL.append(" WHERE oid_deuda_socio = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_DEUDA_SOCIO, oid); 
    return querySelect; 
  }
  
  
  private PreparedStatement selectByNroSocio(Object aCondiciones) throws BaseException, SQLException { 
	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM  tuDeudaSocio "); 
	    textSQL.append(" WHERE nro_socio = ? ");
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
	    Integer nroSocio = (Integer) aCondiciones; 
	    querySelect.setInt(1, nroSocio.intValue()); 
	    return querySelect; 
	  }
  
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  tuDeudaSocio "); 
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_deuda_socio oid, codigo,  descripcion ,activo ");
    textSQL.append(" from tuDeudaSocio");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  } 
  
  public static void borrarTodo(
          ISesion aSesion)
          throws BaseException {
	  ObjetoLogico.getObjects(ImpoDeudaSujetoTurnos.NICKNAME,
			  				DBImpoDeudaSujetoTurnos.DELETE_ALL,
			  				null,
			  				new ObjetoObservado(),
			  				aSesion);
  }
  
  public static List getDeuda(Integer nroSocio,
          ISesion aSesion) throws BaseException {
	  return (List) ObjetoLogico.getObjects(ImpoDeudaSujetoTurnos.NICKNAME,
             DBImpoDeudaSujetoTurnos.SELECT_BY_NRO_SOCIO,
             nroSocio,
             new ListObserver(),
             aSesion);
  }
  
  
  
} 
