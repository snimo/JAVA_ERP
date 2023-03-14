package com.srn.erp.general.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.general.bm.Empresa;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;

public class DBEmpresa extends DBObjetoPersistente {

  public static final String OID_EMPRESA = "oid_empresa";
  public static final String CODIGO = "codigo";
  public static final String RAZON_SOCIAL = "razon_social";
  public static final String NOMBRE_FANTASIA = "nombre_fantasia";
  public static final String CALLE_Y_NRO = "calle_y_nro";
  public static final String LOCALIDAD = "localidad";
  public static final String CODIGO_POSTAL = "codigo_postal";
  public static final String OID_PROVINCIA = "oid_provincia";
  public static final String OID_PAIS = "oid_pais";
  public static final String OID_CAT_IVA = "oid_cat_iva";
  public static final String OID_CAT_IB = "oid_cat_ib";
  public static final String CUIT = "CUIT";
  public static final String NRO_ING_BRUTOS = "nro_ing_brutos";
  public static final String AGEN_RET_IVA = "agen_ret_iva";
  public static final String AGEN_RET_GAN = "agen_ret_gan";
  public static final String AGEN_RET_IB = "agen_ret_ib";
  public static final String ARCHIVO_LOGO = "archivo_logo";
  public static final String ACTIVO = "activo";
  public static final String ARCH_XML_POOL_BD = "arch_xml_pool_bd";
  public static final String INICIO_ACTIVIDAD = "inicio_actividad";
  public static final String ES_AGE_PERC_IB_BA = "es_age_perc_ib_ba";
  public static final String ES_AGE_PERC_IB_CF = "es_age_perc_ib_cf";
  public static final String ES_AGE_PERC_IVA = "es_age_perc_iva";
  
  public DBEmpresa() {
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

    final int OID_EMPRESA = 1;
    final int RAZON_SOCIAL = 2;
    final int NOMBRE_FANTASIA = 3;
    final int CALLE_Y_NRO = 4;
    final int LOCALIDAD = 5;
    final int CODIGO_POSTAL = 6;
    final int OID_PROVINCIA = 7;
    final int OID_PAIS = 8;
    final int OID_CAT_IVA = 9;
    final int OID_CAT_IB = 10;
    final int CUIT = 11;
    final int NRO_ING_BRUTOS = 12;
    final int AGEN_RET_IVA = 13;
    final int AGEN_RET_GAN = 14;
    final int AGEN_RET_IB = 15;
    final int ARCHIVO_LOGO = 16;
    final int ACTIVO = 17;
    final int CODIGO = 18;
    final int ARCH_XML_POOL_BD = 19;
    final int INICIO_ACTIVIDAD = 20;
    final int ES_AGE_PERC_IB_BA = 21;
    final int ES_AGE_PERC_IB_CF = 22;
    final int ES_AGE_PERC_IVA = 23;

    Empresa pers = (Empresa) objetoPersistente;

    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into geEmpresas "+
                     " ( "+
                      "OID_EMPRESA,"+
                      "RAZON_SOCIAL,"+
                      "NOMBRE_FANTASIA,"+
                      "CALLE_Y_NRO,"+
                      "LOCALIDAD,"+
                      "CODIGO_POSTAL,"+
                      "OID_PROVINCIA,"+
                      "OID_PAIS,"+
                      "OID_CAT_IVA,"+
                      "OID_CAT_IB,"+
                      "CUIT,"+
                      "NRO_ING_BRUTOS,"+
                      "AGEN_RET_IVA,"+
                      "AGEN_RET_GAN,"+
                      "AGEN_RET_IB,"+
                      "ARCHIVO_LOGO,"+
                      "ACTIVO,CODIGO,"+
                      "ARCH_XML_POOL_BD,"+
                      "INICIO_ACTIVIDAD,"+
                      "ES_AGE_PERC_IB_BA,"+
                      "ES_AGE_PERC_IB_CF,"+
                      "ES_AGE_PERC_IVA"+
                      ")"+
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
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
    qInsert.setInt(OID_EMPRESA,pers.getOID());
    qInsert.setString(RAZON_SOCIAL,pers.getRazon_social());
    qInsert.setString(NOMBRE_FANTASIA,pers.getNombre_fantasia());
    qInsert.setString(CALLE_Y_NRO,pers.getCalle_y_nro());
    qInsert.setString(LOCALIDAD,pers.getLocalidad());
    qInsert.setString(CODIGO_POSTAL,pers.getCodigo_postal());
    qInsert.setInt(OID_PROVINCIA,pers.getProvincia().getOID());
    qInsert.setInt(OID_PAIS,pers.getPais().getOID());
    qInsert.setInt(OID_CAT_IVA,pers.getCategoria_iva().getOID());
    qInsert.setInt(OID_CAT_IB,pers.getCategoria_ib().getOID());
    qInsert.setString(CUIT,pers.getCuit());
    qInsert.setString(NRO_ING_BRUTOS,pers.getNro_ing_brutos());
    qInsert.setBoolean(AGEN_RET_IVA,pers.isAgen_ret_iva().booleanValue());
    qInsert.setBoolean(AGEN_RET_GAN,pers.isAgen_ret_gan().booleanValue());
    qInsert.setBoolean(AGEN_RET_IB,pers.isAgen_ret_ib().booleanValue());
    qInsert.setString(ARCHIVO_LOGO,pers.getArchivo_logo());
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qInsert.setString(CODIGO,pers.getCodigo());
    if (pers.getArchXMLPoolBD()!=null)
      qInsert.setString(ARCH_XML_POOL_BD,pers.getArchXMLPoolBD());
    else
      qInsert.setNull(ARCH_XML_POOL_BD,java.sql.Types.VARCHAR);
    if (pers.getInicioActividad()!=null)
      qInsert.setDate(INICIO_ACTIVIDAD,new java.sql.Date(pers.getInicioActividad().getTime()));
    else
      qInsert.setNull(INICIO_ACTIVIDAD,java.sql.Types.DATE);
    
    qInsert.setBoolean(ES_AGE_PERC_IB_BA,pers.isAgentePercIBBsAs());
    qInsert.setBoolean(ES_AGE_PERC_IB_CF,pers.isAgentePercIBCapFed());
    qInsert.setBoolean(ES_AGE_PERC_IVA,pers.isAgentePercIVA());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

    final int RAZON_SOCIAL = 1;
    final int NOMBRE_FANTASIA = 2;
    final int CALLE_Y_NRO = 3;
    final int LOCALIDAD = 4;
    final int CODIGO_POSTAL = 5;
    final int OID_PROVINCIA = 6;
    final int OID_PAIS = 7;
    final int OID_CAT_IVA = 8;
    final int OID_CAT_IB = 9;
    final int CUIT = 10;
    final int NRO_ING_BRUTOS = 11;
    final int AGEN_RET_IVA = 12;
    final int AGEN_RET_GAN = 13;
    final int AGEN_RET_IB = 14;
    final int ARCHIVO_LOGO = 15;
    final int ACTIVO = 16;
    final int CODIGO = 17;
    final int ARCH_XML_POOL_BD = 18;
    final int INICIO_ACTIVIDAD = 19;
    final int ES_AGE_PERC_IB_BA = 20;
    final int ES_AGE_PERC_IB_CF = 21;
    final int ES_AGE_PERC_IVA = 22;
    final int OID_EMPRESA = 23;

    Empresa pers = (Empresa) objetoPersistente;

    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update geEmpresas set "+
              "razon_social=?"+
              ",nombre_fantasia=?"+
              ",calle_y_nro=?"+
              ",localidad=?"+
              ",codigo_postal=?"+
              ",oid_provincia=?"+
              ",oid_pais=?"+
              ",oid_cat_iva=?"+
              ",oid_cat_ib=?"+
              ",CUIT=?"+
              ",nro_ing_brutos=?"+
              ",agen_ret_iva=?"+
              ",agen_ret_gan=?"+
              ",agen_ret_ib=?"+
              ",archivo_logo=?"+
              ",activo=?"+
              ",codigo=?"+
              ",arch_xml_pool_bd=?"+
              ",inicio_actividad=?"+
              ",es_age_perc_ib_ba=?"+
              ",es_age_perc_ib_cf=?"+
              ",es_age_perc_iva=?"+
                 " where " +
                 " oid_empresa=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_EMPRESA,pers.getOID());
    qUpdate.setString(RAZON_SOCIAL,pers.getRazon_social());
    qUpdate.setString(NOMBRE_FANTASIA,pers.getNombre_fantasia());
    qUpdate.setString(CALLE_Y_NRO,pers.getCalle_y_nro());
    qUpdate.setString(LOCALIDAD,pers.getLocalidad());
    qUpdate.setString(CODIGO_POSTAL,pers.getCodigo_postal());
    qUpdate.setInt(OID_PROVINCIA,pers.getProvincia().getOID());
    qUpdate.setInt(OID_PAIS,pers.getPais().getOID());
    qUpdate.setInt(OID_CAT_IVA,pers.getCategoria_iva().getOID());
    qUpdate.setInt(OID_CAT_IB,pers.getCategoria_ib().getOID());
    qUpdate.setString(CUIT,pers.getCuit());
    qUpdate.setString(NRO_ING_BRUTOS,pers.getNro_ing_brutos());
    qUpdate.setBoolean(AGEN_RET_IVA,pers.isAgen_ret_iva().booleanValue());
    qUpdate.setBoolean(AGEN_RET_GAN,pers.isAgen_ret_gan().booleanValue());
    qUpdate.setBoolean(AGEN_RET_IB,pers.isAgen_ret_ib().booleanValue());
    qUpdate.setString(ARCHIVO_LOGO,pers.getArchivo_logo());
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.setString(CODIGO,pers.getCodigo());
    if (pers.getArchXMLPoolBD()!=null)
      qUpdate.setString(ARCH_XML_POOL_BD,pers.getArchXMLPoolBD());
    else
      qUpdate.setNull(ARCH_XML_POOL_BD,java.sql.Types.VARCHAR);
    if (pers.getInicioActividad()!=null)
    	qUpdate.setDate(INICIO_ACTIVIDAD,new java.sql.Date(pers.getInicioActividad().getTime()));
    else
    	qUpdate.setNull(INICIO_ACTIVIDAD,java.sql.Types.DATE);
    qUpdate.setBoolean(ES_AGE_PERC_IB_BA,pers.isAgentePercIBBsAs());
    qUpdate.setBoolean(ES_AGE_PERC_IB_CF,pers.isAgentePercIBCapFed());
    qUpdate.setBoolean(ES_AGE_PERC_IVA,pers.isAgentePercIVA());
    qUpdate.executeUpdate();
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    final int OID_EMPRESA = 1;
    Empresa pers = (Empresa) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("update geEmpresas "+
                     " set activo=0 " +
                     " where " +
                     " oid_empresa=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_EMPRESA, pers.getOID());
    qUpdate.executeUpdate();
    qUpdate.close();
  }

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    final int OID_EMPRESA = 1;
    Empresa pers = (Empresa) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("update geEmpresas "+
                     " set activo=1 " +
                     " where " +
                     " oid_empresa=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_EMPRESA, pers.getOID());
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
      case SELECT_ALL: {
        ps = this.selectAll(aCondiciones);
        break;
      }
    }
    return ps;
  }

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

    final int OID_EMPRESA = 1;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  geEmpresas ");
    textSQL.append(" WHERE oid_empresa = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    int oid = ( (Integer) aCondiciones).intValue();
    querySelect.setInt(OID_EMPRESA, oid);
    return querySelect;
  }

  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

    final int CODIGO = 1;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  geEmpresas ");
    textSQL.append(" WHERE codigo = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    String codigo = (String) aCondiciones;
    querySelect.setString(CODIGO, codigo);
    return querySelect;
  }

  private PreparedStatement selectAll(Object aCondiciones) throws BaseException, SQLException {
    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  geEmpresas ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    return querySelect;
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_empresa oid, codigo, razon_social  descripcion ,activo ");
    textSQL.append(" from geEmpresas");

    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    return querySelect;
  }

  public static List getEmpresas(ISesion aSesion) throws BaseException {
    return (List) ObjetoLogico.getObjects(Empresa.NICKNAME,
                                          DBEmpresa.SELECT_ALL,
                                          null,
                                          new ListObserver(),
                                          aSesion);
  }


}
