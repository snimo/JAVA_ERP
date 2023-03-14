package com.srn.erp.contabilidad.da;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.srn.erp.compras.bm.RequisicionCab;
import com.srn.erp.contabilidad.bm.CuentaImputable;
import com.srn.erp.contabilidad.bm.MayorPeri;
import com.srn.erp.general.bm.Periodo;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.Utils.ObjetoObservado;

public class DBMayorPeri extends DBObjetoPersistente {

  public static final String OID_MAY_PERI = "oid_may_peri";
  public static final String OID_ANA_IMP = "oid_ai";
  public static final String OID_PERI = "oid_peri";
  public static final String SIGNO = "signo";
  public static final String CANTIDAD = "cantidad";
  public static final String IMPO_LOC_HIS = "impo_loc_his";
  public static final String IMPO_LOC_AJU = "impo_loc_aju";
  public static final String IMPO_MON_EXT_1 = "impo_mon_ext_1";
  public static final String IMPO_MON_EXT_2 = "impo_mon_ext_2";

  public static final int SELECT_BY_IMPUTABLE_PERI_SIGNO = 100;

  public DBMayorPeri() {
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

    final int OID_MAY_PERI = 1;
    final int OID_ANA_IMP = 2;
    final int OID_PERI = 3;
    final int SIGNO = 4;
    final int CANTIDAD = 5;
    final int IMPO_LOC_HIS = 6;
    final int IMPO_LOC_AJU = 7;
    final int IMPO_MON_EXT_1 = 8;
    final int IMPO_MON_EXT_2 = 9;

    MayorPeri pers = (MayorPeri) objetoPersistente;

    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into cgMayorPeri "+
                     " ( "+
                      "OID_MAY_PERI,"+
                      "OID_AI,"+
                      "OID_PERI,"+
                      "SIGNO,"+
                      "CANTIDAD,"+
                      "IMPO_LOC_HIS,"+
                      "IMPO_LOC_AJU,"+
                      "IMPO_MON_EXT_1,"+
                      "IMPO_MON_EXT_2)"+
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
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
    qInsert.setInt(OID_MAY_PERI,pers.getOID());
    qInsert.setInt(OID_ANA_IMP,pers.getCuentaImputable().getOID());
    qInsert.setInt(OID_PERI,pers.getPeriodo().getOID());
    qInsert.setInt(SIGNO,pers.getSigno().intValue());
    qInsert.setInt(CANTIDAD,pers.getCantidad().intValue());
    qInsert.setDouble(IMPO_LOC_HIS,pers.getImpoLocHist().doubleValue());
    qInsert.setDouble(IMPO_LOC_AJU,pers.getImpoLocAju().doubleValue());
    qInsert.setDouble(IMPO_MON_EXT_1,pers.getImpoMonExt1().doubleValue());
    qInsert.setDouble(IMPO_MON_EXT_2,pers.getImpoMonExt2().doubleValue());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

    final int CANTIDAD = 1;
    final int IMPO_LOC_HIS = 2;
    final int IMPO_LOC_AJU = 3;
    final int IMPO_MON_EXT_1 = 4;
    final int IMPO_MON_EXT_2 = 5;
    final int OID_MAY_PERI = 6;

    MayorPeri pers = (MayorPeri) objetoPersistente;

    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update cgMayorPeri set "+
              "cantidad=cantidad+?"+
              ",impo_loc_his=impo_loc_his+?"+
              ",impo_loc_aju=impo_loc_aju+?"+
              ",impo_mon_ext_1=impo_mon_ext_1+?"+
              ",impo_mon_ext_2=impo_mon_ext_2+?"+
                 " where " +
                 " oid_may_peri=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(CANTIDAD,pers.getCantidad().intValue());
    qUpdate.setDouble(IMPO_LOC_HIS,pers.getImpoLocHist().doubleValue());
    qUpdate.setDouble(IMPO_LOC_AJU,pers.getImpoLocAju().doubleValue());
    qUpdate.setDouble(IMPO_MON_EXT_1,pers.getImpoMonExt1().doubleValue());
    qUpdate.setDouble(IMPO_MON_EXT_2,pers.getImpoMonExt2().doubleValue());
    qUpdate.setInt(OID_MAY_PERI,pers.getOID());
    qUpdate.executeUpdate();
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    final int OID_MAY_PERI = 1;
    MayorPeri pers = (MayorPeri) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("delete from cgMayorPeri "+
                     " where " +
                     " oid_may_peri=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_MAY_PERI, pers.getOID());
    qUpdate.executeUpdate();
    qUpdate.close();
  }
  
	public static void borrarTodo(ISesion aSesion)
	throws BaseException {

	try {

		StringBuffer sql = new StringBuffer(
				" delete from cgMayorPeri");
		PreparedStatement update = aSesion.getConexionBD().prepareStatement(sql.toString());
		update.executeUpdate();
		update.close();

	
	} catch (Exception e) {
		throw new BaseException(null, e.getMessage());
	}
	}


  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    final int OID_MAY_PERI = 1;
    MayorPeri pers = (MayorPeri) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("update cgMayorPeri "+
                     " set activo=1 " +
                     " where " +
                     " oid_may_peri=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_MAY_PERI, pers.getOID());
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
      case SELECT_BY_IMPUTABLE_PERI_SIGNO: {
        ps = this.selectByImputablePeriSigno(aCondiciones);
        break;
      }
    }
    return ps;
  }

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

    final int OID_MAY_PERI = 1;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  cgMayorPeri ");
    textSQL.append(" WHERE oid_may_peri = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    int oid = ( (Integer) aCondiciones).intValue();
    querySelect.setInt(OID_MAY_PERI, oid);
    return querySelect;
  }

  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

    final int CODIGO = 1;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  cgMayorPeri ");
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    String codigo = (String) aCondiciones;
    querySelect.setString(CODIGO, codigo);
    return querySelect;
  }

  private PreparedStatement selectByImputablePeriSigno(Object aCondiciones) throws BaseException, SQLException {

    MapDatos mapaDatos        = (HashTableDatos) aCondiciones;
    CuentaImputable cuentaImputable = (CuentaImputable) mapaDatos.get(CuentaImputable.NICKNAME);
    Periodo periodo = (Periodo) mapaDatos.get(Periodo.NICKNAME);
    Integer signo = (Integer)mapaDatos.get("signo");

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  cgMayorPeri ");
    textSQL.append(" WHERE  oid_ai=? and oid_peri=? and signo=?");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());

    querySelect.setInt(1,cuentaImputable.getOID());
    querySelect.setInt(2,periodo.getOID());
    querySelect.setInt(3,signo.intValue());

    return querySelect;

  }


  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_may_peri oid, codigo,  descripcion ,activo ");
    textSQL.append(" from cgMayorPeri");

    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    return querySelect;
  }

  public static MayorPeri getByImputablePeriSigno(CuentaImputable cuentaImputable,
                                                  Periodo periodo,
                                                  Integer signo,
                                                  ISesion aSesion)
                                                  throws BaseException {
    MapDatos mapaDatos = new HashTableDatos();
    mapaDatos.put(CuentaImputable.NICKNAME,cuentaImputable);
    mapaDatos.put(Periodo.NICKNAME,periodo);
    mapaDatos.put("signo",signo);
    return (MayorPeri) ObjetoLogico.getObjects(MayorPeri.NICKNAME,
                                               DBMayorPeri.SELECT_BY_IMPUTABLE_PERI_SIGNO,
                                               mapaDatos,
                                               new ObjetoObservado(),
                                               aSesion);

  }


}
