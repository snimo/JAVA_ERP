package com.srn.erp.ventas.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.general.bm.UnidadOrganizativa;
import com.srn.erp.ventas.bm.ListaPrecios;
import com.srn.erp.ventas.bm.ListaPreciosPorUniOrg;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;

public class DBListaPreciosPorUniOrg extends DBObjetoPersistente {

  public static final String OID_PRECIO_UNI_ORG = "oid_precio_uni_org";
  public static final String OID_UNI_ORG = "oid_uni_org";
  public static final String OID_PRECIO_CAB = "oid_precio_cab";

  public static final int SELECT_BY_LISTA_PRECIO = 100;
  public static final int SELECT_BY_UNI_ORG      = 101;

  public DBListaPreciosPorUniOrg() {
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

    final int OID_PRECIO_UNI_ORG = 1;
    final int OID_UNI_ORG = 2;
    final int OID_PRECIO_CAB = 3;

    ListaPreciosPorUniOrg pers = (ListaPreciosPorUniOrg) objetoPersistente;

    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into vePrecioCabUniOrg "+
                     " ( "+
                      "OID_PRECIO_UNI_ORG,"+
                      "OID_UNI_ORG,"+
                      "OID_PRECIO_CAB)"+
                      " values "+
                      "("+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
    qInsert.setInt(OID_PRECIO_UNI_ORG,pers.getOID());
    qInsert.setInt(OID_UNI_ORG,pers.getUnidad_organizativa().getOID());
    qInsert.setInt(OID_PRECIO_CAB,pers.getLista_precios().getOID());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

    final int OID_UNI_ORG = 1;
    final int OID_PRECIO_CAB = 2;
    final int OID_PRECIO_UNI_ORG = 3;

    ListaPreciosPorUniOrg pers = (ListaPreciosPorUniOrg) objetoPersistente;

    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update vePrecioCabUniOrg set "+
              "oid_uni_org=?"+
              ",oid_precio_cab=?"+
                 " where " +
                 " oid_precio_uni_org=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_PRECIO_UNI_ORG,pers.getOID());
    qUpdate.setInt(OID_UNI_ORG,pers.getUnidad_organizativa().getOID());
    qUpdate.setInt(OID_PRECIO_CAB,pers.getLista_precios().getOID());
    qUpdate.executeUpdate();
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    final int OID_PRECIO_UNI_ORG = 1;
    ListaPreciosPorUniOrg pers = (ListaPreciosPorUniOrg) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("delete from vePrecioCabUniOrg "+
                     " where " +
                     " oid_precio_uni_org=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_PRECIO_UNI_ORG, pers.getOID());
    qUpdate.executeUpdate();
    qUpdate.close();
  }

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    final int OID_PRECIO_UNI_ORG = 1;
    ListaPreciosPorUniOrg pers = (ListaPreciosPorUniOrg) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("update vePrecioCabUniOrg "+
                     " set activo=1 " +
                     " where " +
                     " oid_precio_uni_org=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_PRECIO_UNI_ORG, pers.getOID());
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
      case SELECT_BY_LISTA_PRECIO: {
        ps = this.selectByListaPrecio(aCondiciones);
        break;
      }
      case SELECT_BY_UNI_ORG: {
        ps = this.selectByUniOrg(aCondiciones);
        break;
      }
    }
    return ps;
  }

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

    final int OID_PRECIO_UNI_ORG = 1;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  vePrecioCabUniOrg ");
    textSQL.append(" WHERE oid_precio_uni_org = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    int oid = ( (Integer) aCondiciones).intValue();
    querySelect.setInt(OID_PRECIO_UNI_ORG, oid);
    return querySelect;
  }

  private PreparedStatement selectByUniOrg(Object aCondiciones) throws BaseException, SQLException {
    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  vePrecioCabUniOrg ");
    textSQL.append(" WHERE oid_uni_org = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    UnidadOrganizativa uniOrg = (UnidadOrganizativa) aCondiciones;
    querySelect.setInt(1, uniOrg.getOID());
    return querySelect;
  }




  private PreparedStatement selectByListaPrecio(Object aCondiciones) throws BaseException, SQLException {
    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  vePrecioCabUniOrg ");
    textSQL.append(" WHERE oid_precio_cab = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    ListaPrecios listaPrecios = (ListaPrecios) aCondiciones;
    querySelect.setInt(1, listaPrecios.getOID());
    return querySelect;
  }


  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

    final int CODIGO = 1;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  vePrecioCabUniOrg ");
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    String codigo = (String) aCondiciones;
    querySelect.setString(CODIGO, codigo);
    return querySelect;
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_precio_uni_org oid, codigo,  descripcion ,activo ");
    textSQL.append(" from vePrecioCabUniOrg");

    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    return querySelect;
  }

  public static List getUniOrgPorLP(ListaPrecios listaPrecios,
                                    ISesion aSesion) throws BaseException {
    return (List) ObjetoLogico.getObjects(ListaPreciosPorUniOrg.NICKNAME,
                                          DBListaPreciosPorUniOrg.SELECT_BY_LISTA_PRECIO,
                                          listaPrecios,
                                          new ListObserver(),
                                          aSesion);
  }

  public static List getUniOrgPorLP(UnidadOrganizativa uniOrg,
                                    ISesion aSesion) throws BaseException {
    return (List) ObjetoLogico.getObjects(ListaPreciosPorUniOrg.NICKNAME,
                                          DBListaPreciosPorUniOrg.SELECT_BY_UNI_ORG,
                                          uniOrg,
                                          new ListObserver(),
                                          aSesion);
  }



}
