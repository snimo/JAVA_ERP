package com.srn.erp.general.da;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.general.bm.Periodo;
import com.srn.erp.general.bm.PeriodoInc;
import com.srn.erp.general.bm.PeriodoIncDet;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.Utils.ObjetoObservado;

public class DBPeriodo extends DBObjetoPersistente {

  public static final String OID_PERI = "oid_peri";
  public static final String CODIGO = "codigo";
  public static final String DESCRIPCION = "descripcion";
  public static final String FECHA_DESDE = "fecha_desde";
  public static final String FECHA_HASTA = "fecha_hasta";
  public static final String TIPO = "tipo";
  public static final String ACTIVO = "activo";

  public final static int SELECT_BY_FECHA_EJERCICIO = 100;
  public final static int SELECT_BY_CODIGO_PERI_MENSUAL = 101;
  public final static int SELECT_PERIODO_MENSUAL_BY_FECHA_DESDE = 102;
  public final static int SELECT_PERIODO_MENSUAL_BY_FECHA = 103; 
  public final static int SELECT_PERIODOS_MENSUAL_ENTRE_FEC = 104;
  

  public DBPeriodo() {
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

    final int OID_PERI = 1;
    final int CODIGO = 2;
    final int DESCRIPCION = 3;
    final int FECHA_DESDE = 4;
    final int FECHA_HASTA = 5;
    final int TIPO = 6;
    final int ACTIVO = 7;

    Periodo pers = (Periodo) objetoPersistente;

    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into gePeriodos "+
                     " ( "+
                      "OID_PERI,"+
                      "CODIGO,"+
                      "DESCRIPCION,"+
                      "FECHA_DESDE,"+
                      "FECHA_HASTA,"+
                      "TIPO,"+
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
    qInsert.setInt(OID_PERI,pers.getOID());
    qInsert.setString(CODIGO,pers.getCodigo());
    qInsert.setString(DESCRIPCION,pers.getDescripcion());
    qInsert.setDate(FECHA_DESDE,new java.sql.Date(pers.getFechadesde().getTime()));
    qInsert.setDate(FECHA_HASTA,new java.sql.Date(pers.getFechahasta().getTime()));
    qInsert.setString(TIPO,pers.getTipo());
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

    final int CODIGO = 1;
    final int DESCRIPCION = 2;
    final int FECHA_DESDE = 3;
    final int FECHA_HASTA = 4;
    final int TIPO = 5;
    final int ACTIVO = 6;
    final int OID_PERI = 7;

    Periodo pers = (Periodo) objetoPersistente;

    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update gePeriodos set "+
              "codigo=?"+
              ",descripcion=?"+
              ",fecha_desde=?"+
              ",fecha_hasta=?"+
              ",tipo=?"+
              ",activo=?"+
                 " where " +
                 " oid_peri=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_PERI,pers.getOID());
    qUpdate.setString(CODIGO,pers.getCodigo());
    qUpdate.setString(DESCRIPCION,pers.getDescripcion());
    qUpdate.setDate(FECHA_DESDE,new java.sql.Date(pers.getFechadesde().getTime()));
    qUpdate.setDate(FECHA_HASTA,new java.sql.Date(pers.getFechahasta().getTime()));
    qUpdate.setString(TIPO,pers.getTipo());
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.executeUpdate();
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    final int OID_PERI = 1;
    Periodo pers = (Periodo) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("update gePeriodos "+
                     " set activo=0 " +
                     " where " +
                     " oid_peri=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_PERI, pers.getOID());
    qUpdate.executeUpdate();
    qUpdate.close();
  }

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    final int OID_PERI = 1;
    Periodo pers = (Periodo) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("update gePeriodos "+
                     " set activo=1 " +
                     " where " +
                     " oid_peri=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_PERI, pers.getOID());
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
      case SELECT_BY_FECHA_EJERCICIO : {
        ps = this.selectByFechaEjercicio(aCondiciones);
        break;
      }
      case SELECT_BY_CODIGO_PERI_MENSUAL: {
    	ps = this.selectByCodPeriMensual(aCondiciones);
    	break;
      }
      case SELECT_PERIODO_MENSUAL_BY_FECHA_DESDE : {
      	ps = this.selectByPeriMensualByFechaDesde(aCondiciones);
    	break;
      }
      case SELECT_PERIODO_MENSUAL_BY_FECHA: {
        	ps = this.selectByPeriMensualByFecha(aCondiciones);
        	break;
      }
      case SELECT_PERIODOS_MENSUAL_ENTRE_FEC: {
      	ps = this.selectByPeriMensualEntreFechas(aCondiciones);
    	break;    	  
      }

    }
    return ps;
  }

  private PreparedStatement selectByCodPeriMensual(Object aCondiciones) throws BaseException, SQLException {
	  MapDatos mapaDatos = (MapDatos) aCondiciones;
	  StringBuffer textSQL = new StringBuffer();
	  textSQL.append("SELECT * FROM  gePeriodos ");
	  textSQL.append(" WHERE codigo = ? and tipo='M' ");
	  PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
	  String codigo = (String) mapaDatos.getString("codigo");
	  querySelect.setString(1, codigo);
	  return querySelect;
  }  

  
  private PreparedStatement selectByPeriMensualEntreFechas(Object aCondiciones) throws BaseException, SQLException {

	    StringBuffer textSQL = new StringBuffer();
	    textSQL.append("SELECT * FROM  gePeriodos ");
	    textSQL.append(" WHERE fecha_desde >= ? and fecha_hasta<=? and tipo = 'M' order by codigo ");
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
	    
	    HashTableDatos condiciones = (HashTableDatos) aCondiciones;
	    
	    
	    java.util.Date fechaDesde = (java.util.Date) condiciones.get("FEC_DESDE");
	    java.util.Date fechaHasta = (java.util.Date) condiciones.get("FEC_HASTA");
	    
	    querySelect.setDate(1, new Date(fechaDesde.getTime()));
	    querySelect.setDate(2, new Date(fechaHasta.getTime()));
	    return querySelect;
  }  
  
  

  
  private PreparedStatement selectByPeriMensualByFecha(Object aCondiciones) throws BaseException, SQLException {

	    StringBuffer textSQL = new StringBuffer();
	    textSQL.append("SELECT * FROM  gePeriodos ");
	    textSQL.append(" WHERE fecha_desde <= ? and fecha_hasta>=? and tipo = 'M' ");
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
	    java.util.Date fecha = ( (java.util.Date) aCondiciones);
	    querySelect.setDate(1, new Date(fecha.getTime()));
	    querySelect.setDate(2, new Date(fecha.getTime()));
	    return querySelect;
  }  
  
  
  
  
  private PreparedStatement selectByPeriMensualByFechaDesde(Object aCondiciones) throws BaseException, SQLException {

	    StringBuffer textSQL = new StringBuffer();
	    textSQL.append("SELECT * FROM  gePeriodos ");
	    textSQL.append(" WHERE fecha_desde = ? and tipo = 'M' ");
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
	    java.util.Date fecha = ( (java.util.Date) aCondiciones);
	    querySelect.setDate(1, new Date(fecha.getTime()));
	    return querySelect;
 }  
  
  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

    final int OID_PERI = 1;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  gePeriodos ");
    textSQL.append(" WHERE oid_peri = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    int oid = ( (Integer) aCondiciones).intValue();
    querySelect.setInt(OID_PERI, oid);
    return querySelect;
  }
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

    final int CODIGO = 1;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  gePeriodos ");
    textSQL.append(" WHERE codigo = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    String codigo = (String) aCondiciones;
    querySelect.setString(CODIGO, codigo);
    return querySelect;
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_peri oid,codigo codigo, descripcion descripcion ,activo ");
    textSQL.append(" from gePeriodos");

    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    return querySelect;
  }

  private PreparedStatement selectByFechaEjercicio(Object aCondiciones) throws BaseException, SQLException {

    java.util.Date fecha = (java.util.Date) aCondiciones;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  gePeriodos p , cgEjercicioPeri e ");
    textSQL.append(" WHERE  p.oid_peri = e.oid_peri and p.fecha_Desde<=? and p.fecha_hasta>=? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    querySelect.setDate(1,new java.sql.Date(fecha.getTime()));
    querySelect.setDate(2,new java.sql.Date(fecha.getTime()));
    return querySelect;

  }

  public static Periodo getPeriodoByFechaDelEjercicio(java.util.Date fecha,
                                                      ISesion aSesion)
                                                      throws BaseException {
    return (Periodo) ObjetoLogico.getObjects(Periodo.NICKNAME,
                                             DBPeriodo.SELECT_BY_FECHA_EJERCICIO,
                                             fecha,
                                             new ObjetoObservado(),
                                             aSesion);
  }

  public static Periodo getPeriodoMensual(java.util.Date fechaDesde,
          ISesion aSesion)
          throws BaseException {
	  return (Periodo) ObjetoLogico.getObjects(Periodo.NICKNAME,
			  				DBPeriodo.SELECT_PERIODO_MENSUAL_BY_FECHA_DESDE,
			  				fechaDesde,
			  				new ObjetoObservado(),
			  				aSesion);
  }
  
  public static Periodo getPeriodoMensualByFecha(java.util.Date fecha,
          ISesion aSesion)
          throws BaseException {
	  return (Periodo) ObjetoLogico.getObjects(Periodo.NICKNAME,
			  				DBPeriodo.SELECT_PERIODO_MENSUAL_BY_FECHA,
			  				fecha,
			  				new ObjetoObservado(),
			  				aSesion);
  }
  
  public static List getPeriodosEntreFechas(
		  java.util.Date fecDesde,
		  java.util.Date fecHasta,
          ISesion aSesion) throws BaseException {
	  HashTableDatos condiciones = new HashTableDatos();
	  condiciones.put("FEC_DESDE", fecDesde);
	  condiciones.put("FEC_HASTA", fecHasta);
	  return (List) ObjetoLogico.getObjects(Periodo.NICKNAME,
             DBPeriodo.SELECT_PERIODOS_MENSUAL_ENTRE_FEC,
             condiciones,
             new ListObserver(),
             aSesion);
  }  
  
  

}
