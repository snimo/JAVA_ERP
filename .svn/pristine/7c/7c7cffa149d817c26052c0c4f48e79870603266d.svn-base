package com.srn.erp.ventas.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.general.bm.UnidadOrganizativa;
import com.srn.erp.ventas.bm.CondPagoUniOrg;
import com.srn.erp.ventas.bm.CondicionPago;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.ObjetoObservado;

public class DBCondPagoUniOrg extends DBObjetoPersistente {

  public static final String OID_CP_UNI_ORG = "oid_cp_uni_org";
  public static final String OID_COND_PAGO = "oid_cond_pago";
  public static final String OID_UNI_ORG = "oid_uni_org";

  public static final int SELECT_BY_COND_PAGO = 100;
  public static final int SELECT_BY_COND_PAGO_UNI_ORG = 101;

  public DBCondPagoUniOrg() {
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

    final int OID_CP_UNI_ORG = 1;
    final int OID_COND_PAGO = 2;
    final int OID_UNI_ORG = 3;

    CondPagoUniOrg pers = (CondPagoUniOrg) objetoPersistente;

    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into veCondPagoUniOrg "+
                     " ( "+
                      "OID_CP_UNI_ORG,"+
                      "OID_COND_PAGO,"+
                      "OID_UNI_ORG)"+
                      " values "+
                      "("+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
    qInsert.setInt(OID_CP_UNI_ORG,pers.getOID());
    qInsert.setInt(OID_COND_PAGO,pers.getCondicion_pago().getOID());
    qInsert.setInt(OID_UNI_ORG,pers.getUnidad_organizativa().getOID());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

    final int OID_COND_PAGO = 1;
    final int OID_UNI_ORG = 2;
    final int OID_CP_UNI_ORG = 3;

    CondPagoUniOrg pers = (CondPagoUniOrg) objetoPersistente;

    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update veCondPagoUniOrg set "+
              "oid_cond_pago=?"+
              ",oid_uni_org=?"+
                 " where " +
                 " oid_cp_uni_org=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_CP_UNI_ORG,pers.getOID());
    qUpdate.setInt(OID_COND_PAGO,pers.getCondicion_pago().getOID());
    qUpdate.setInt(OID_UNI_ORG,pers.getUnidad_organizativa().getOID());
    qUpdate.executeUpdate();
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    final int OID_CP_UNI_ORG = 1;
    CondPagoUniOrg pers = (CondPagoUniOrg) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("delete from veCondPagoUniOrg "+
                     " where " +
                     " oid_cp_uni_org=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_CP_UNI_ORG, pers.getOID());
    qUpdate.executeUpdate();
    qUpdate.close();
  }

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    final int OID_CP_UNI_ORG = 1;
    CondPagoUniOrg pers = (CondPagoUniOrg) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("update veCondPagoUniOrg "+
                     " set activo=1 " +
                     " where " +
                     " oid_cp_uni_org=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_CP_UNI_ORG, pers.getOID());
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
      case SELECT_BY_COND_PAGO: {
        ps = this.selectByCondPago(aCondiciones);
        break;
      }
      case SELECT_BY_COND_PAGO_UNI_ORG: {
        ps = this.selectByCondPagoUniOrg(aCondiciones);
        break;
      }
    }
    return ps;
  }

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

    final int OID_CP_UNI_ORG = 1;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  veCondPagoUniOrg ");
    textSQL.append(" WHERE oid_cp_uni_org = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    int oid = ( (Integer) aCondiciones).intValue();
    querySelect.setInt(OID_CP_UNI_ORG, oid);
    return querySelect;
  }

  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

    final int CODIGO = 1;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  veCondPagoUniOrg ");
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    String codigo = (String) aCondiciones;
    querySelect.setString(CODIGO, codigo);
    return querySelect;
  }

  private PreparedStatement selectByCondPago(Object aCondiciones) throws BaseException, SQLException {
    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  veCondPagoUniOrg ");
    textSQL.append(" WHERE oid_cond_pago = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    CondicionPago condicionPago = (CondicionPago) aCondiciones;
    querySelect.setInt(1, condicionPago.getOID());
    return querySelect;
  }

  private PreparedStatement selectByCondPagoUniOrg(Object aCondiciones) throws BaseException, SQLException {
    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  veCondPagoUniOrg ");
    textSQL.append(" WHERE oid_cond_pago = ? and oid_uni_org = ?");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    HashTableDatos condiciones = (HashTableDatos) aCondiciones;
    CondicionPago condPago = (CondicionPago) condiciones.get(CondicionPago.NICKNAME);
    UnidadOrganizativa uniOrg = (UnidadOrganizativa) condiciones.get(UnidadOrganizativa.NICKNAME);
    querySelect.setInt(1, condPago.getOID());
    querySelect.setInt(2,uniOrg.getOID());
    return querySelect;
  }




  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_cp_uni_org oid, codigo,  descripcion ,activo ");
    textSQL.append(" from veCondPagoUniOrg");

    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    return querySelect;
  }

  public static List getUniOrgCondPago(CondicionPago condicionPago,
                                       ISesion aSesion) throws BaseException {
    return (List) ObjetoLogico.getObjects(CondPagoUniOrg.NICKNAME,
                                          DBCondPagoUniOrg.SELECT_BY_COND_PAGO,
                                          condicionPago,
                                          new ListObserver(),
                                          aSesion);
  }

  public static CondPagoUniOrg getCondPagoUniOrg(CondicionPago condPago,
                                                 UnidadOrganizativa uniOrg,
                                                 ISesion aSesion)
                                                      throws BaseException {
    HashTableDatos condiciones = new HashTableDatos();
    condiciones.put(CondicionPago.NICKNAME,condPago);
    condiciones.put(UnidadOrganizativa.NICKNAME,uniOrg);

    return (CondPagoUniOrg) ObjetoLogico.getObjects(CondPagoUniOrg.NICKNAME,
                                             DBCondPagoUniOrg.SELECT_BY_COND_PAGO_UNI_ORG,
                                             condiciones,
                                             new ObjetoObservado(),
                                             aSesion);
  }



}
