package com.srn.erp.contabilidad.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.srn.erp.contabilidad.bm.Ejercicio;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Servicios.ServicioPoolBD;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.PoolBD.IPoolBD;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ObjetoObservado;

public class DBEjercicio extends DBObjetoPersistente {

  public static final String OID_EJERCICIO = "oid_ejercicio";
  public static final String NRO_EJER = "nro_ejer";
  public static final String FECHA_DESDE = "fecha_desde";
  public static final String FECHA_HASTA = "fecha_hasta";
  public static final String ACTIVO = "activo";
  public static final String LIB_DIA_COMPRO = "lib_dia_compro";
  public static final String FEC_GEN_LIB_DIA = "fec_gen_lib_dia";
  public static final String ULT_PRES_LIB_DIARIO = "ult_pres_lib_dia";

  public static final int SELECT_BY_FECHA = 100;

  public DBEjercicio() {
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

    final int OID_EJERCICIO = 1;
    final int NRO_EJER = 2;
    final int FECHA_DESDE = 3;
    final int FECHA_HASTA = 4;
    final int ACTIVO = 5;
    final int LIB_DIA_COMPRO = 6;
    final int FEC_GEN_LIB_DIA = 7;
    final int ULT_PRES_LIB_DIARIO = 8;

    Ejercicio pers = (Ejercicio) objetoPersistente;

    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into cgEjercicio "+
                     " ( "+
                      "OID_EJERCICIO,"+
                      "NRO_EJER,"+
                      "FECHA_DESDE,"+
                      "FECHA_HASTA,"+
                      "ACTIVO,"+
                      "LIB_DIA_COMPRO,FEC_GEN_LIB_DIA,ult_pres_lib_dia)"+
                      " values "+
                      "("+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
    qInsert.setInt(OID_EJERCICIO,pers.getOID());
    qInsert.setInt(NRO_EJER,pers.getNroejer().intValue());
    qInsert.setDate(FECHA_DESDE,new java.sql.Date(pers.getFechadesde().getTime()));
    qInsert.setDate(FECHA_HASTA,new java.sql.Date(pers.getFechahasta().getTime()));
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    
    if (pers.getLibroDiarioPorComprobante()!=null)
    	qInsert.setString(LIB_DIA_COMPRO, pers.getLibroDiarioPorComprobante());
    else
    	qInsert.setNull(LIB_DIA_COMPRO, java.sql.Types.VARCHAR);
    if (pers.getFechaGenLibDiario()!=null)
    	qInsert.setDate(FEC_GEN_LIB_DIA, new java.sql.Date(pers.getFechaGenLibDiario().getTime()));
    else
    	qInsert.setNull(FEC_GEN_LIB_DIA, java.sql.Types.DATE);
    
    if (pers.getUltimaPresentacionLibroDiario()!=null)
    	qInsert.setString(ULT_PRES_LIB_DIARIO, pers.getUltimaPresentacionLibroDiario());
    else
    	qInsert.setNull(ULT_PRES_LIB_DIARIO, java.sql.Types.VARCHAR);
        
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

    final int NRO_EJER = 1;
    final int FECHA_DESDE = 2;
    final int FECHA_HASTA = 3;
    final int ACTIVO = 4;
    final int LIB_DIA_COMPRO = 5;
    final int FEC_GEN_LIB_DIA = 6;
    final int ULT_PRES_LIB_DIARIO = 7;
    final int OID_EJERCICIO = 8;

    Ejercicio pers = (Ejercicio) objetoPersistente;

    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update cgEjercicio set "+
              "nro_ejer=?"+
              ",fecha_desde=?"+
              ",fecha_hasta=?"+
              ",activo=?"+
              ",lib_dia_compro=?"+
              ",fec_gen_lib_dia=?"+
              ",ult_pres_lib_dia=? "+
                 " where " +
                 " oid_ejercicio=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_EJERCICIO,pers.getOID());
    qUpdate.setInt(NRO_EJER,pers.getNroejer().intValue());
    qUpdate.setDate(FECHA_DESDE,new java.sql.Date(pers.getFechadesde().getTime()));
    qUpdate.setDate(FECHA_HASTA,new java.sql.Date(pers.getFechahasta().getTime()));
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    
    if (pers.getLibroDiarioPorComprobante()!=null)
    	qUpdate.setString(LIB_DIA_COMPRO, pers.getLibroDiarioPorComprobante());
    else
    	qUpdate.setNull(LIB_DIA_COMPRO, java.sql.Types.VARCHAR);
    if (pers.getFechaGenLibDiario()!=null)
    	qUpdate.setDate(FEC_GEN_LIB_DIA, new java.sql.Date(pers.getFechaGenLibDiario().getTime()));
    else
    	qUpdate.setNull(FEC_GEN_LIB_DIA, java.sql.Types.DATE);
    if (pers.getUltimaPresentacionLibroDiario()!=null)
    	qUpdate.setString(ULT_PRES_LIB_DIARIO, pers.getUltimaPresentacionLibroDiario());
    else
    	qUpdate.setNull(ULT_PRES_LIB_DIARIO, java.sql.Types.VARCHAR);
    
    
    qUpdate.executeUpdate();
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    final int OID_EJERCICIO = 1;
    Ejercicio pers = (Ejercicio) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("update cgEjercicio "+
                     " set activo=0 " +
                     " where " +
                     " oid_ejercicio=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_EJERCICIO, pers.getOID());
    qUpdate.executeUpdate();
    qUpdate.close();
  }

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    final int OID_EJERCICIO = 1;
    Ejercicio pers = (Ejercicio) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("update cgEjercicio "+
                     " set activo=1 " +
                     " where " +
                     " oid_ejercicio=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_EJERCICIO, pers.getOID());
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
      case SELECT_BY_FECHA: {
        ps = this.selectByFecha(aCondiciones);
        break;
      }

    }
    return ps;
  }

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

    final int OID_EJERCICIO = 1;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  cgEjercicio ");
    textSQL.append(" WHERE oid_ejercicio = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    int oid = ( (Integer) aCondiciones).intValue();
    querySelect.setInt(OID_EJERCICIO, oid);
    return querySelect;
  }
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

    final int CODIGO = 1;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  cgEjercicio ");
    textSQL.append(" WHERE nro_ejer = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    String codigo = (String) aCondiciones;
    querySelect.setString(CODIGO, codigo);
    return querySelect;
  }

  private PreparedStatement selectByFecha(Object aCondiciones) throws BaseException, SQLException {
    StringBuffer textSQL = new StringBuffer();
    java.util.Date fecha = (java.util.Date) aCondiciones;
    textSQL.append("SELECT * ");
    textSQL.append(" from cgEjercicio ");
    textSQL.append(" where ");
    textSQL.append("   ?>=fecha_desde and ?<=fecha_hasta");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    querySelect.setDate(1,new java.sql.Date(fecha.getTime()));
    querySelect.setDate(2,new java.sql.Date(fecha.getTime()));
    return querySelect;
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

	String caracter = "||";
	if (this.getSesion().getServicios().getServPoolBD(ServicioPoolBD.FILE_POOL_BD).getPoolBD().getTipoBD().equals(IPoolBD.MSSQLServer))
		caracter = "+";
    
    textSQL.append("SELECT oid_ejercicio oid,nro_ejer codigo, fecha_desde"+caracter+"' '"+caracter+"fecha_hasta descripcion ,activo ");
    textSQL.append(" from cgEjercicio");

    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    return querySelect;
  }

  public static Ejercicio getEjercicioByFecha(java.util.Date fecha,
                                       ISesion aSesion) throws BaseException {
     return (Ejercicio) ObjetoLogico.getObjects(Ejercicio.NICKNAME,
                                                DBEjercicio.SELECT_BY_FECHA,
                                                fecha,
                                                new ObjetoObservado(),
                                                aSesion);
  }


}
