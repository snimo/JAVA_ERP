package com.srn.erp.contabilidad.da;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.contabilidad.bm.Cuenta;
import com.srn.erp.contabilidad.bm.ReporteContable;
import com.srn.erp.contabilidad.bm.ReporteContableDet;
import com.srn.erp.ventas.bm.Sujeto;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.ObjetoObservado;

public class DBReporteContableDet extends DBObjetoPersistente {

  public static final String OID_REP_CONTA_DET = "oid_rep_conta_det";
  public static final String OID_REP_CONTA = "oid_rep_conta";
  public static final String OID_TITU = "oid_titu";
  public static final String OID_TITU_PADRE = "oid_titu_padre";
  public static final String DESC_TITULO = "desc_titulo";
  public static final String OID_ANA_CON = "oid_ana_con";
  public static final String CODIGO_DESDE = "codigo_desde";
  public static final String CODIGO_HASTA = "codigo_hasta";
  public static final String TIPO = "tipo";
  public static final String ACTIVO = "activo";
  public static final String ORDEN = "orden";

  public static final int SELECT_BY_REPORTE = 100;
  public static final int SELECT_BY_OID_TITU_OID_REP_CONTA = 101;
  public static final int SELECT_BY_TITULOS_REPORTE = 102;
  public static final int SELECT_BY_REPORTE_CTA_ACTIVO = 103;
  public DBReporteContableDet() {
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

    final int OID_REP_CONTA_DET = 1;
    final int OID_REP_CONTA = 2;
    final int OID_TITU = 3;
    final int OID_TITU_PADRE = 4;
    final int DESC_TITULO = 5;
    final int OID_ANA_CON = 6;
    final int CODIGO_DESDE = 7;
    final int CODIGO_HASTA = 8;
    final int TIPO = 9;
    final int ORDEN = 10;
    final int ACTIVO = 11;

    ReporteContableDet pers = (ReporteContableDet) objetoPersistente;

    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into cgRepContaDet "+
                     " ( "+
                      "OID_REP_CONTA_DET,"+
                      "OID_REP_CONTA,"+
                      "OID_TITU,"+
                      "OID_TITU_PADRE,"+
                      "DESC_TITULO,"+
                      "OID_ANA_CON,"+
                      "CODIGO_DESDE,"+
                      "CODIGO_HASTA,"+
                      "TIPO,"+
                      "ORDEN,"+
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
    qInsert.setInt(OID_REP_CONTA_DET,pers.getOID());
    qInsert.setInt(OID_REP_CONTA,pers.getReporteContable().getOID());
    qInsert.setInt(OID_TITU,pers.getOidtitulo().intValue());
    qInsert.setInt(OID_TITU_PADRE,pers.getOidtitulopadre().intValue());
    qInsert.setString(DESC_TITULO,pers.getDesctitulo());
    if (pers.getCuenta()!=null)
      qInsert.setInt(OID_ANA_CON,pers.getCuenta().getOID());
    else
      qInsert.setNull(OID_ANA_CON,java.sql.Types.INTEGER);
    qInsert.setString(CODIGO_DESDE,pers.getCodigodesde());
    qInsert.setString(CODIGO_HASTA,pers.getCodigohasta());
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qInsert.setInt(ORDEN,pers.getOrden().intValue());
    qInsert.setString(TIPO,pers.getTipo());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

    final int OID_REP_CONTA = 1;
    final int OID_TITU = 2;
    final int OID_TITU_PADRE = 3;
    final int DESC_TITULO = 4;
    final int OID_ANA_CON = 5;
    final int CODIGO_DESDE = 6;
    final int CODIGO_HASTA = 7;
    final int ACTIVO = 8;
    final int TIPO = 9;
    final int ORDEN = 10;
    final int OID_REP_CONTA_DET = 11;

    ReporteContableDet pers = (ReporteContableDet) objetoPersistente;

    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update cgRepContaDet set "+
              "oid_rep_conta=?"+
              ",oid_titu=?"+
              ",oid_titu_padre=?"+
              ",desc_titulo=?"+
              ",oid_ana_con=?"+
              ",codigo_desde=?"+
              ",codigo_hasta=?"+
              ",activo=?"+
              ",tipo=?"+
              ",orden=?"+
                 " where " +
                 " oid_rep_conta_det=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_REP_CONTA_DET,pers.getOID());
    qUpdate.setInt(OID_REP_CONTA,pers.getReporteContable().getOID());
    qUpdate.setInt(OID_TITU,pers.getOidtitulo().intValue());
    qUpdate.setInt(OID_TITU_PADRE,pers.getOidtitulopadre().intValue());
    qUpdate.setString(DESC_TITULO,pers.getDesctitulo());
    if (pers.getCuenta()!=null)
      qUpdate.setInt(OID_ANA_CON,pers.getCuenta().getOID());
    else
      qUpdate.setNull(OID_ANA_CON,java.sql.Types.INTEGER);
    qUpdate.setString(CODIGO_DESDE,pers.getCodigodesde());
    qUpdate.setString(CODIGO_HASTA,pers.getCodigohasta());
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.setString(TIPO,pers.getTipo());
    qUpdate.setInt(ORDEN,pers.getOrden().intValue());
    qUpdate.executeUpdate();
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    final int OID_REP_CONTA_DET = 1;
    ReporteContableDet pers = (ReporteContableDet) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("delete from cgRepContaDet "+
                     " where " +
                     " oid_rep_conta_det=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_REP_CONTA_DET, pers.getOID());
    qUpdate.executeUpdate();
    qUpdate.close();
  }

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    final int OID_REP_CONTA_DET = 1;
    ReporteContableDet pers = (ReporteContableDet) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("update cgRepContaDet "+
                     " set activo=1 " +
                     " where " +
                     " oid_rep_conta_det=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_REP_CONTA_DET, pers.getOID());
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
      case SELECT_BY_REPORTE: {
        ps = this.selectByReporte(aCondiciones);
        break;
      }
      case SELECT_BY_OID_TITU_OID_REP_CONTA: {
          ps = this.selectByOIDTituOIDRepConta(aCondiciones);
          break;
      }
      case SELECT_BY_TITULOS_REPORTE: {
          ps = this.selectByTitulosReporte(aCondiciones);
          break;
      }
      case SELECT_BY_REPORTE_CTA_ACTIVO: {
          ps = this.selectByReporteCtaActivo(aCondiciones);
          break;
      }
    }
    return ps;
  }

  private PreparedStatement selectByOIDTituOIDRepConta(Object aCondiciones) throws BaseException, SQLException {

	    StringBuffer textSQL = new StringBuffer();
	    textSQL.append("SELECT * FROM  cgRepContaDet ");
	    textSQL.append(" WHERE oid_rep_conta = ? and oid_titu = ? ");
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
	    
	    HashTableDatos condiciones = (HashTableDatos) aCondiciones;
	    Integer oidTitu = (Integer)condiciones.get("OID_TITU");
	    Integer oidRepConta = (Integer)condiciones.get("OID_REP_CONTA");
	    
	    querySelect.setInt(1, oidRepConta);
	    querySelect.setInt(2, oidTitu);
	    return querySelect;
	  }


  private PreparedStatement selectByReporteCtaActivo(Object aCondiciones) throws BaseException, SQLException {

	    StringBuffer textSQL = new StringBuffer();
	    textSQL.append("SELECT * FROM  cgRepContaDet ");
	    textSQL.append(" where tipo in ('CTA','COMPO','NCOMP') and activo=1 and oid_rep_conta=? and oid_ana_con=? ");
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
	    
	    HashTableDatos condiciones = (HashTableDatos) aCondiciones;
	    ReporteContable reporte = (ReporteContable) condiciones.get(ReporteContable.NICKNAME);
	    Cuenta cuenta = (Cuenta) condiciones.get(Cuenta.NICKNAME);
	    querySelect.setInt(1, reporte.getOID());
	    querySelect.setInt(2, cuenta.getOID());
	    return querySelect;
	  }

  private PreparedStatement selectByTitulosReporte(Object aCondiciones) throws BaseException, SQLException {

	    StringBuffer textSQL = new StringBuffer();
	    textSQL.append("SELECT * FROM  cgRepContaDet ");
	    textSQL.append(" where tipo='TITU' and activo=1 and oid_rep_conta=? ");
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
	    
	    ReporteContable reporte = (ReporteContable) aCondiciones;
	    querySelect.setInt(1, reporte.getOID());
	    return querySelect;
	  }

  
  
  
  
  
  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

    final int OID_REP_CONTA_DET = 1;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  cgRepContaDet ");
    textSQL.append(" WHERE oid_rep_conta_det = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    int oid = ( (Integer) aCondiciones).intValue();
    querySelect.setInt(OID_REP_CONTA_DET, oid);
    return querySelect;
  }

  private PreparedStatement selectByReporte(Object aCondiciones) throws BaseException, SQLException {
    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  cgRepContaDet ");
    textSQL.append(" WHERE  oid_rep_conta = ?  ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    ReporteContable reporteContable = (ReporteContable) aCondiciones;
    querySelect.setInt(1, reporteContable.getOID());
    return querySelect;

  }

  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

    final int CODIGO = 1;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  cgRepContaDet ");
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    String codigo = (String) aCondiciones;
    querySelect.setString(CODIGO, codigo);
    return querySelect;
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_rep_conta_det oid, codigo,  descripcion ,activo ");
    textSQL.append(" from cgRepContaDet");

    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    return querySelect;
  }

  public static List getItemsReporte(ReporteContable reporteContable,
                                     ISesion aSesion) throws BaseException {
    return (List) ObjetoLogico.getObjects(ReporteContableDet.NICKNAME,
                                          SELECT_BY_REPORTE,
                                          reporteContable,
                                          new ListObserver(),
                                          aSesion);
  }
  
  public static ReporteContableDet getReporteContableDetByRepyTitu(
		  Integer oidRepConta,
		  Integer oidTitu,
          ISesion aSesion)
          throws BaseException {
	  HashTableDatos condiciones = new HashTableDatos();
	  condiciones.put("OID_TITU", oidTitu);
	  condiciones.put("OID_REP_CONTA", oidRepConta);
	  return (ReporteContableDet) ObjetoLogico.getObjects(ReporteContableDet.NICKNAME,
			  				DBReporteContableDet.SELECT_BY_OID_TITU_OID_REP_CONTA,
			  				condiciones,
			  				new ObjetoObservado(),
			  				aSesion);
  }
  
  public static List getSoloTitulosReporte(ReporteContable reporteContable,
          ISesion aSesion) throws BaseException {
	  return (List) ObjetoLogico.getObjects(ReporteContableDet.NICKNAME,
               SELECT_BY_TITULOS_REPORTE,
               reporteContable,
               new ListObserver(),
               aSesion);
  }
  
  public static List getSoloReporteDetCtaActiva(
		  ReporteContable reporteContable,
		  Cuenta cuenta,
          ISesion aSesion) throws BaseException {
	  HashTableDatos condiciones = new HashTableDatos();
	  condiciones.put(ReporteContable.NICKNAME,reporteContable);
	  condiciones.put(Cuenta.NICKNAME,cuenta);
	  return (List) ObjetoLogico.getObjects(ReporteContableDet.NICKNAME,
               SELECT_BY_REPORTE_CTA_ACTIVO,
               condiciones,
               new ListObserver(),
               aSesion);
  }
  
  public static int getMaxOidTituReporte(ReporteContable reporte,ISesion sesion) throws BaseException  {

	    try {

	        StringBuffer textSQL = new StringBuffer();
	        textSQL.append("SELECT max(oid_titu) oid_titu FROM  cgRepContaDet ");
	        textSQL.append(" WHERE oid_rep_conta=? ");
	        PreparedStatement ps = sesion.getConexionBD().prepareStatement(textSQL.toString());
	        ps.setInt(1, reporte.getOID());
	        ResultSet rs = ps.executeQuery();

	        int nro = 0;
	        while (rs.next()) {
	        	nro = rs.getInt("oid_titu");
	        }
	        
	        
	        ps.close();
	        rs.close();
	        rs = null;
	        ps = null;
	        
	        
	        return nro;
	        
	    }
	        catch (SQLException ex) {
	          throw new BaseException(null,ex.getMessage());
	    }
	  }
  
  
  
  


}
