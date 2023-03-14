package com.srn.erp.contabilidad.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.contabilidad.bm.Estructura;
import com.srn.erp.contabilidad.bm.EstructuraCompo;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;

public class DBEstructuraCompo extends DBObjetoPersistente {

  public static final String OID_ESTRUC_COMPO = "oid_estruc_compo";
  public static final String OID_ESTRUC = "oid_estruc";
  public static final String SECU = "secu";
  public static final String OID_COMPO = "oid_compo";
  public static final String ACTIVO = "activo";
  public static final String OID_VALOR_DEFAULT = "oid_valor_default";

  public static final int SELECT_BY_ESTRUCTURA = 100;

  public DBEstructuraCompo() {
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

    final int OID_ESTRUC_COMPO = 1;
    final int OID_ESTRUC = 2;
    final int SECU = 3;
    final int OID_COMPO = 4;
    final int ACTIVO = 5;
    final int OID_VALOR_DEFAULT = 6;

    EstructuraCompo pers = (EstructuraCompo) objetoPersistente;

    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into cgEstrucCompo "+
                     " ( "+
                      "OID_ESTRUC_COMPO,"+
                      "OID_ESTRUC,"+
                      "SECU,"+
                      "OID_COMPO,"+
                      "ACTIVO,OID_VALOR_DEFAULT)"+
                      " values "+
                      "("+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
    qInsert.setInt(OID_ESTRUC_COMPO,pers.getOID());
    qInsert.setInt(OID_ESTRUC,pers.getEstructura().getOID());
    qInsert.setInt(SECU,pers.getSecu().intValue());
    qInsert.setInt(OID_COMPO,pers.getComponente().getOID());
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    if (pers.getValorDefault()!=null)
    	qInsert.setInt(OID_VALOR_DEFAULT, pers.getValorDefault().getOIDInteger());
    else
    	qInsert.setNull(OID_VALOR_DEFAULT, java.sql.Types.INTEGER);
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

    final int OID_ESTRUC = 1;
    final int SECU = 2;
    final int OID_COMPO = 3;
    final int ACTIVO = 4;
    final int OID_VALOR_DEFAULT = 5;
    final int OID_ESTRUC_COMPO = 6;
    

    EstructuraCompo pers = (EstructuraCompo) objetoPersistente;

    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update cgEstrucCompo set "+
              "oid_estruc=?"+
              ",secu=?"+
              ",oid_compo=?"+
              ",activo=?"+
              ",oid_valor_default=?"+
                 " where " +
                 " oid_estruc_compo=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_ESTRUC_COMPO,pers.getOID());
    qUpdate.setInt(OID_ESTRUC,pers.getEstructura().getOID());
    qUpdate.setInt(SECU,pers.getSecu().intValue());
    qUpdate.setInt(OID_COMPO,pers.getComponente().getOID());
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    if (pers.getValorDefault()!=null)
    	qUpdate.setInt(OID_VALOR_DEFAULT, pers.getValorDefault().getOIDInteger());
    else
    	qUpdate.setNull(OID_VALOR_DEFAULT, java.sql.Types.INTEGER);    
    qUpdate.executeUpdate();
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    final int OID_ESTRUC_COMPO = 1;
    EstructuraCompo pers = (EstructuraCompo) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("delete from cgEstrucCompo "+
                     " where " +
                     " oid_estruc_compo=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_ESTRUC_COMPO, pers.getOID());
    qUpdate.executeUpdate();
    qUpdate.close();
  }

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    final int OID_ESTRUC_COMPO = 1;
    EstructuraCompo pers = (EstructuraCompo) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("update cgEstrucCompo "+
                     " set activo=1 " +
                     " where " +
                     " oid_estruc_compo=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_ESTRUC_COMPO, pers.getOID());
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
      case SELECT_BY_ESTRUCTURA: {
        ps = this.selectByEstructura(aCondiciones);
        break;
      }
    }
    return ps;
  }

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

    final int OID_ESTRUC_COMPO = 1;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  cgEstrucCompo ");
    textSQL.append(" WHERE oid_estruc_compo = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    int oid = ( (Integer) aCondiciones).intValue();
    querySelect.setInt(OID_ESTRUC_COMPO, oid);
    return querySelect;
  }
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

    final int CODIGO = 1;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  cgEstrucCompo ");
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    String codigo = (String) aCondiciones;
    querySelect.setString(CODIGO, codigo);
    return querySelect;
  }

  private PreparedStatement selectByEstructura(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT * ");
    textSQL.append(" from cgEstrucCompo where oid_estruc = ? order by secu ");

    Estructura estructura = (Estructura) aCondiciones;

    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    querySelect.setInt(1,estructura.getOID());
    return querySelect;
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT * ");
    textSQL.append(" from cgEstrucCompo where oid_estruc = ? ");

    Estructura estructura = (Estructura) aCondiciones;

    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    querySelect.setInt(1,estructura.getOID());
    return querySelect;
  }


  public static List getEstrucCompoByEstruc(Estructura estructura,
                                            ISesion aSesion) throws BaseException {
    return (List) ObjetoLogico.getObjects(EstructuraCompo.NICKNAME,
                                          DBEstructuraCompo.SELECT_BY_ESTRUCTURA,
                                          estructura,
                                          new ListObserver(),
                                          aSesion);
  }



}
