package com.srn.erp.contabilidad.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.contabilidad.bm.CompoAtributo;
import com.srn.erp.contabilidad.bm.Componente;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;

public class DBCompoAtributo extends DBObjetoPersistente {

  public static final String OID_COMPO_ATRI = "oid_compo_atri";
  public static final String OID_COMPO = "oid_compo";
  public static final String SECU = "secu";
  public static final String OID_ATRIBUTO = "oid_atributo";
  public static final String ACTIVO = "activo";

  public static final int SELECT_BY_COMPONENTE = 100;

  public DBCompoAtributo() {
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

    final int OID_COMPO_ATRI = 1;
    final int OID_COMPO = 2;
    final int SECU = 3;
    final int OID_ATRIBUTO = 4;
    final int ACTIVO = 5;

    CompoAtributo pers = (CompoAtributo) objetoPersistente;

    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into cgCompoAtri "+
                     " ( "+
                      "OID_COMPO_ATRI,"+
                      "OID_COMPO,"+
                      "SECU,"+
                      "OID_ATRIBUTO,"+
                      "ACTIVO)"+
                      " values "+
                      "("+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
    qInsert.setInt(OID_COMPO_ATRI,pers.getOID());
    qInsert.setInt(OID_COMPO,pers.getCompo().getOID());
    qInsert.setInt(SECU,pers.getSecu().intValue());
    qInsert.setInt(OID_ATRIBUTO,pers.getAtributo().getOID());
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qInsert.executeUpdate();
    qInsert.close();

    StringBuffer sqlAddCampo = new StringBuffer();
    sqlAddCampo.append(pers.getSQLScriptAddCampo());
    PreparedStatement qAddTable = getSesion().getConexionBD().prepareStatement(sqlAddCampo.toString());
    qAddTable.executeUpdate();
    qAddTable.close();


  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

    final int OID_COMPO = 1;
    final int SECU = 2;
    final int OID_ATRIBUTO = 3;
    final int ACTIVO = 4;
    final int OID_COMPO_ATRI = 5;

    CompoAtributo pers = (CompoAtributo) objetoPersistente;

    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update cgCompoAtri set "+
              "oid_compo=?"+
              ",secu=?"+
              ",oid_atributo=?"+
              ",activo=?"+
                 " where " +
                 " oid_compo_atri=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_COMPO_ATRI,pers.getOID());
    qUpdate.setInt(OID_COMPO,pers.getCompo().getOID());
    qUpdate.setInt(SECU,pers.getSecu().intValue());
    qUpdate.setInt(OID_ATRIBUTO,pers.getAtributo().getOID());
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.executeUpdate();
    qUpdate.close();


  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    final int OID_COMPO_ATRI = 1;
    CompoAtributo pers = (CompoAtributo) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("update cgCompoAtri "+
                     " set activo=0 " +
                     " where " +
                     " oid_compo_atri=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_COMPO_ATRI, pers.getOID());
    qUpdate.executeUpdate();
    qUpdate.close();
  }

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    final int OID_COMPO_ATRI = 1;
    CompoAtributo pers = (CompoAtributo) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("update cgCompoAtri "+
                     " set activo=1 " +
                     " where " +
                     " oid_compo_atri=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_COMPO_ATRI, pers.getOID());
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
      case SELECT_BY_COMPONENTE: {
        ps = this.selectByComponente(aCondiciones);
        break;
      }
    }
    return ps;
  }

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

    final int OID_COMPO_ATRI = 1;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  cgCompoAtri ");
    textSQL.append(" WHERE oid_compo_atri = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    int oid = ( (Integer) aCondiciones).intValue();
    querySelect.setInt(OID_COMPO_ATRI, oid);
    return querySelect;
  }
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

    final int CODIGO = 1;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  cgCompoAtri ");
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    String codigo = (String) aCondiciones;
    querySelect.setString(CODIGO, codigo);
    return querySelect;
  }

  private PreparedStatement selectByComponente(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();
    Componente componente = (Componente) aCondiciones;

    textSQL.append("SELECT * ");
    textSQL.append(" from cgCompoAtri where oid_compo = ?");

    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    querySelect.setInt(1,componente.getOID());
    return querySelect;

  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_compo_atri oid, codigo,  descripcion ,activo ");
    textSQL.append(" from cgCompoAtri");

    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    return querySelect;
  }

  public static List getAtributosByCompo(Componente componente,
                                         ISesion aSesion) throws BaseException {
    return (List) ObjetoLogico.getObjects(CompoAtributo.NICKNAME,
                                          DBCompoAtributo.SELECT_BY_COMPONENTE,
                                          componente,
                                          new ListObserver(),
                                          aSesion);
  }


}
