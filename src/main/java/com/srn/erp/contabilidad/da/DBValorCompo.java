package com.srn.erp.contabilidad.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.srn.erp.contabilidad.bm.CompoAtributo;
import com.srn.erp.contabilidad.bm.Componente;
import com.srn.erp.contabilidad.bm.ValorCompo;

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

public class DBValorCompo extends DBObjetoPersistente {

  public static final String OID_COMPO = "oid_compo";
  public static final String CODIGO = "codigo";
  public static final String DESCRIPCION = "descripcion";
  public static final String ACTIVO = "activo";

  public static final int SELECT_BY_COMPO = 100;

  private Componente componente = null;

  public void setComponente(Componente componente) {
    this.componente = componente;
  }

  public Componente getComponente() {
    return componente;
  }

  public DBValorCompo() {
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

    final int OID_COMPO   = 1;
    final int CODIGO      = 2;
    final int DESCRIPCION = 3;
    final int ACTIVO      = 4;

    ValorCompo pers = (ValorCompo) objetoPersistente;
    Componente componente = pers.getComponente();

    // Agregar campos Dinamicamente al Query
    String camposSelect = "";
    String paramsCampos = "";
    Iterator iterCompoAtri = null;
    iterCompoAtri = componente.getCompoAtributos().iterator();
    while (iterCompoAtri.hasNext()) {
      CompoAtributo compoAtributo = (CompoAtributo)iterCompoAtri.next();
      if (!compoAtributo.isActivo().booleanValue()) continue;
      if (camposSelect.equals("")) {
        camposSelect = "," + compoAtributo.getAtributo().getCampoFisico();
        paramsCampos = ",?";
      }
      else {
        camposSelect = camposSelect + "," +
            compoAtributo.getAtributo().getCampoFisico();
        paramsCampos = paramsCampos + ",?";
      }
    }

    // Senetencia SQL Script
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into "+componente.getTableName()+
                     " ( "+
                      "OID_COMPO,"+
                      "CODIGO,"+
                      "DESCRIPCION,"+
                      "ACTIVO"+camposSelect+")"+
                      " values "+
                      "("+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?"+paramsCampos+") ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
    qInsert.setInt(OID_COMPO,pers.getOID());
    qInsert.setString(CODIGO,pers.getCodigo());
    qInsert.setString(DESCRIPCION,pers.getDescripcion());
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());

    // Setear parametros de Atributos

    int nroParam = 5;
    iterCompoAtri = componente.getCompoAtributos().iterator();
    while (iterCompoAtri.hasNext()) {
      CompoAtributo compoAtributo = (CompoAtributo)iterCompoAtri.next();
      if (!compoAtributo.isActivo().booleanValue()) continue;
      String nombreCampo = compoAtributo.getAtributo().getCampoFisico();
      if (compoAtributo.getAtributo().isEntero())
        qInsert.setInt(nroParam,pers.getAtributoInteger(nombreCampo).intValue());
      else
      if (compoAtributo.getAtributo().isString())
        qInsert.setString(nroParam,pers.getAtributoString(nombreCampo));
      else
      if (compoAtributo.getAtributo().isDecimal())
        qInsert.setDouble(nroParam,pers.getAtributoDouble(nombreCampo).doubleValue());
      else
      if (compoAtributo.getAtributo().isFecha())
        qInsert.setDate(nroParam,new java.sql.Date(pers.getAtributoDate(nombreCampo).getTime()));
      else
      if (compoAtributo.getAtributo().isValorCompo()) {
        qInsert.setInt(nroParam,
                       pers.getAtributoCompo(nombreCampo).getOID());
      }
      ++nroParam;
    }

    qInsert.executeUpdate();
    qInsert.close();


  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

    final int CODIGO = 1;
    final int DESCRIPCION = 2;
    final int ACTIVO = 3;

    ValorCompo pers = (ValorCompo) objetoPersistente;
    Componente componente = pers.getComponente();

    String camposUpdate = "";
    Iterator iterCompoAtri = componente.getCompoAtributos().iterator();
    while (iterCompoAtri.hasNext()) {
      CompoAtributo compoAtributo = (CompoAtributo)iterCompoAtri.next();
      if (camposUpdate.equals("")) {
        camposUpdate = "," + compoAtributo.getAtributo().getCampoFisico()+"=?";
      }
      else {
        camposUpdate = camposUpdate + "," +
            compoAtributo.getAtributo().getCampoFisico()+"=?";
      }
    }


    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update "+componente.getTableName()+" set "+
              "codigo=?"+
              ",descripcion=?"+
              ",activo=?"+camposUpdate+
                 " where " +
                 " oid_compo=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setString(CODIGO,pers.getCodigo());
    qUpdate.setString(DESCRIPCION,pers.getDescripcion());
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());

    // Setear parametros de Atributos

    int nroParam = 4;
    iterCompoAtri = componente.getCompoAtributos().iterator();
    while (iterCompoAtri.hasNext()) {
      CompoAtributo compoAtributo = (CompoAtributo)iterCompoAtri.next();
      if (!compoAtributo.isActivo().booleanValue()) continue;
      String nombreCampo = compoAtributo.getAtributo().getCampoFisico();
      if (compoAtributo.getAtributo().isEntero())
        qUpdate.setInt(nroParam,pers.getAtributoInteger(nombreCampo).intValue());
      else
      if (compoAtributo.getAtributo().isString())
        qUpdate.setString(nroParam,pers.getAtributoString(nombreCampo));
      else
      if (compoAtributo.getAtributo().isDecimal())
        qUpdate.setDouble(nroParam,pers.getAtributoDouble(nombreCampo).doubleValue());
      else
      if (compoAtributo.getAtributo().isFecha())
        qUpdate.setDate(nroParam,new java.sql.Date(pers.getAtributoDate(nombreCampo).getTime()));
      else
      if (compoAtributo.getAtributo().isValorCompo()) {
        qUpdate.setInt(nroParam,
                       pers.getAtributoCompo(nombreCampo).getOID());
      }

      ++nroParam;
    }

    qUpdate.setInt(nroParam,pers.getOID());



    qUpdate.executeUpdate();
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    final int OID_COMPO = 1;
    ValorCompo pers = (ValorCompo) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("update "+pers.getComponente().getTableName()+
                     " set activo=0 " +
                     " where " +
                     " oid_compo=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_COMPO, pers.getOID());
    qUpdate.executeUpdate();
    qUpdate.close();
  }

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    final int OID_COMPO = 1;
    ValorCompo pers = (ValorCompo) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("update "+pers.getComponente().getTableName()+
                     " set activo=1 " +
                     " where " +
                     " oid_compo=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_COMPO, pers.getOID());
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
      case SELECT_BY_COMPO: {
        ps = this.selectByCompo(aCondiciones);
        break;
      }
    }
    return ps;
  }

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

    final int OID_COMPO = 1;

    Map mapaDatos =(Map) aCondiciones;
    componente =(Componente) mapaDatos.get(Componente.NICKNAME);
    Integer oid = (Integer) mapaDatos.get("oid");

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  "+componente.getTableName());
    textSQL.append(" WHERE oid_compo = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());

    querySelect.setInt(OID_COMPO, oid.intValue());
    return querySelect;
  }

  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

    final int CODIGO = 1;

    MapDatos mapaDatos =(MapDatos) aCondiciones;

    if (mapaDatos.containsKey("oid_compo"))
      componente = Componente.findByOid(mapaDatos.getInteger("oid_compo"),getSesion());
    else
      componente =(Componente) mapaDatos.get(Componente.NICKNAME);
    String codigo = (String) mapaDatos.get("codigo");


    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  "+componente.getTableName());
    textSQL.append(" WHERE codigo = ? ");
    PreparedStatement querySelect =
        getSesion().getConexionBD().prepareStatement(textSQL.toString());
    querySelect.setString(CODIGO, codigo);
    return querySelect;
  }

  private PreparedStatement selectByCompo(Object aCondiciones) throws BaseException, SQLException {
    this.componente =(Componente) aCondiciones;
    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  "+this.componente.getTableName());
    PreparedStatement querySelect =
        getSesion().getConexionBD().prepareStatement(textSQL.toString());
    return querySelect;
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    MapDatos condiciones = (MapDatos) aCondiciones;
    Integer oidCompo = condiciones.getInteger("oid_compo");

    Componente componente = Componente.findByOid(oidCompo,getSesion());

    textSQL.append("SELECT oid_compo oid,codigo codigo, descripcion descripcion ,activo ");
    textSQL.append(" from "+componente.getTableName());

    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    return querySelect;
  }

  public static ValorCompo getValorCompoByOid(Componente aComponente,
                                              Integer aOid,
                                              ISesion aSesion) throws
    BaseException {
    Map mapaDatos = new HashTableDatos();
    mapaDatos.put(Componente.NICKNAME, aComponente);
    mapaDatos.put("oid", aOid);
    return (ValorCompo) ObjetoLogico.getNewObjects(ValorCompo.NICKNAME,
                                                   DBValorCompo.
                                                   SELECT_BY_OID,
                                                   mapaDatos,
                                                   new ObjetoObservado(),
                                                   aSesion);
  }

  public static ValorCompo getValorCompoByCodigo(Componente aComponente,
                                                 String aCodigo,
                                                 ISesion aSesion) throws
      BaseException {
    MapDatos mapaDatos = new HashTableDatos();
    mapaDatos.put(Componente.NICKNAME, aComponente);
    mapaDatos.put("codigo", aCodigo);
    return (ValorCompo) ObjetoLogico.getObjects(ValorCompo.NICKNAME,
                                                  DBValorCompo.
                                                  SELECT_BY_CODIGO,
                                                  mapaDatos,
                                                  new ObjetoObservado(),
                                                  aSesion);
  }


  public static List getValoresCompo(Componente componente,
                                     ISesion aSesion) throws BaseException {
    return (List) ObjetoLogico.getObjects(ValorCompo.NICKNAME,
                                          DBValorCompo.SELECT_BY_COMPO,
                                          componente,
                                          new ListObserver(),
                                          aSesion);

  }


}
