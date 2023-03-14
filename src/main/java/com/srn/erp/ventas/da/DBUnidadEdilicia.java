package com.srn.erp.ventas.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import com.srn.erp.ventas.bm.Sujeto;
import com.srn.erp.ventas.bm.UnidadEdilicia;

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

public class DBUnidadEdilicia extends DBObjetoPersistente {

  public static final String OID_UNI_EDI = "oid_uni_edi";
  public static final String CODIGO = "codigo";
  public static final String CALLE_Y_NRO = "calle_y_nro";
  public static final String LOCALIDAD = "localidad";
  public static final String CODIGO_POSTAL = "codigo_postal";
  public static final String OID_TIPO_UNIDAD = "oid_tipo_unidad";
  public static final String TELEFONOS = "telefonos";
  public static final String OID_PROVINCIA = "oid_provincia";
  public static final String DOM_ENT = "dom_ent";
  public static final String CONTACTO = "contacto";
  public static final String OID_SUJETO_ALTA = "oid_sujeto_alta";
  public static final String OID_PAIS = "oid_pais";
  public static final String OID_ZONA = "oid_zona";
  public static final String ACTIVO = "activo";
  public static final String DIR_COMPLETA = "dir_completa";
  public static final String DOM_COBRANZA = "dom_cobranza";

  public static final int SELECT_BY_SUJETO_ALTA = 100;
  public static final int SELECT_BY_CODIGO_SUJETO = 101;

  public DBUnidadEdilicia() {
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

    final int OID_UNI_EDI = 1;
    final int CODIGO = 2;
    final int CALLE_Y_NRO = 3;
    final int LOCALIDAD = 4;
    final int CODIGO_POSTAL = 5;
    final int OID_TIPO_UNIDAD = 6;
    final int TELEFONOS = 7;
    final int OID_PROVINCIA = 8;
    final int DOM_ENT = 9;
    final int CONTACTO = 10;
    final int OID_SUJETO_ALTA = 11;
    final int OID_PAIS = 12;
    final int OID_ZONA = 13;
    final int ACTIVO = 14;
    final int DIR_COMPLETA = 15;
    final int DOM_COBRANZA = 16;

    UnidadEdilicia pers = (UnidadEdilicia) objetoPersistente;

    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into veUnidadEdilicia "+
                     " ( "+
                      "OID_UNI_EDI,"+
                      "CODIGO,"+
                      "CALLE_Y_NRO,"+
                      "LOCALIDAD,"+
                      "CODIGO_POSTAL,"+
                      "OID_TIPO_UNIDAD,"+
                      "TELEFONOS,"+
                      "OID_PROVINCIA,"+
                      "DOM_ENT,"+
                      "CONTACTO,"+
                      "OID_SUJETO_ALTA,"+
                      "OID_PAIS,"+
                      "OID_ZONA,"+
                      "ACTIVO,"+
                      "DIR_COMPLETA,DOM_COBRANZA)"+
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
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
    qInsert.setInt(OID_UNI_EDI,pers.getOID());
    qInsert.setString(CODIGO,pers.getCodigo());
    qInsert.setString(CALLE_Y_NRO,pers.getCalle_y_mro());
    qInsert.setString(LOCALIDAD,pers.getLocalidad());
    if (pers.getCodigo_postal()!=null)
      qInsert.setString(CODIGO_POSTAL,pers.getCodigo_postal());
    else
      qInsert.setNull(CODIGO_POSTAL,java.sql.Types.VARCHAR);

    if (pers.getTipo_unidad()!=null)
    	qInsert.setInt(OID_TIPO_UNIDAD,pers.getTipo_unidad().getOID());
    else
    	qInsert.setNull(OID_TIPO_UNIDAD,Types.INTEGER);

    if (pers.getTelefonos()!=null)
      qInsert.setString(TELEFONOS,pers.getTelefonos());
    else
      qInsert.setNull(TELEFONOS,java.sql.Types.VARCHAR);

    if (pers.getProvincia()!=null)
      qInsert.setInt(OID_PROVINCIA,pers.getProvincia().getOID());
    else
      qInsert.setNull(OID_PROVINCIA,java.sql.Types.INTEGER);

    if (pers.isDom_ent()!=null)
      qInsert.setBoolean(DOM_ENT,pers.isDom_ent().booleanValue());
    else
      qInsert.setNull(DOM_ENT,java.sql.Types.BOOLEAN);

    if (pers.getContacto()!=null)
      qInsert.setString(CONTACTO,pers.getContacto());
    else
      qInsert.setNull(CONTACTO,java.sql.Types.VARCHAR);

    if (pers.getSujeto_alta()!=null)
      qInsert.setInt(OID_SUJETO_ALTA,pers.getSujeto_alta().getOID());
    else
      qInsert.setNull(OID_SUJETO_ALTA,java.sql.Types.INTEGER);

    if (pers.getPais()!=null)
      qInsert.setInt(OID_PAIS,pers.getPais().getOID());
    else
      qInsert.setNull(OID_PAIS,java.sql.Types.INTEGER);

    if (pers.getZona()!=null)
      qInsert.setInt(OID_ZONA,pers.getZona().getOID());
    else
      qInsert.setNull(OID_ZONA,java.sql.Types.INTEGER);

    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    
    if (pers.getDirCompleta()!=null)
      qInsert.setString(DIR_COMPLETA,pers.getDirCompleta());
    else
      qInsert.setNull(DIR_COMPLETA,java.sql.Types.VARCHAR);
    
    if (pers.isDomicilioCobranza()!=null)
        qInsert.setBoolean(DOM_COBRANZA,pers.isDomicilioCobranza());
      else
        qInsert.setNull(DOM_COBRANZA,java.sql.Types.BOOLEAN);
    
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

    final int CODIGO = 1;
    final int CALLE_Y_NRO = 2;
    final int LOCALIDAD = 3;
    final int CODIGO_POSTAL = 4;
    final int OID_TIPO_UNIDAD = 5;
    final int TELEFONOS = 6;
    final int OID_PROVINCIA = 7;
    final int DOM_ENT = 8;
    final int CONTACTO = 9;
    final int OID_SUJETO_ALTA = 10;
    final int OID_PAIS = 11;
    final int OID_ZONA = 12;
    final int ACTIVO = 13;
    final int DIR_COMPLETA = 14;
    final int DOM_COBRANZA = 15;
    final int OID_UNI_EDI = 16;

    UnidadEdilicia pers = (UnidadEdilicia) objetoPersistente;

    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update veUnidadEdilicia set "+
              "codigo=?"+
              ",calle_y_nro=?"+
              ",localidad=?"+
              ",codigo_postal=?"+
              ",oid_tipo_unidad=?"+
              ",telefonos=?"+
              ",oid_provincia=?"+
              ",dom_ent=?"+
              ",contacto=?"+
              ",oid_sujeto_alta=?"+
              ",oid_pais=?"+
              ",oid_zona=?"+
              ",activo=?"+
              ",dir_completa=?"+
              ",dom_cobranza=?"+
                 " where " +
                 " oid_uni_edi=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_UNI_EDI,pers.getOID());
    qUpdate.setString(CODIGO,pers.getCodigo());
    qUpdate.setString(CALLE_Y_NRO,pers.getCalle_y_mro());
    qUpdate.setString(LOCALIDAD,pers.getLocalidad());

    if (pers.getCodigo_postal()!=null)
      qUpdate.setString(CODIGO_POSTAL,pers.getCodigo_postal());
    else
      qUpdate.setNull(CODIGO_POSTAL,java.sql.Types.VARCHAR);

    if (pers.getTipo_unidad()!=null)
      qUpdate.setInt(OID_TIPO_UNIDAD,pers.getTipo_unidad().getOID());
    else
      qUpdate.setNull(OID_TIPO_UNIDAD,java.sql.Types.INTEGER);

    if (pers.getTelefonos()!=null)
      qUpdate.setString(TELEFONOS,pers.getTelefonos());
    else
      qUpdate.setNull(TELEFONOS,java.sql.Types.VARCHAR);

    if (pers.getProvincia()!=null)
      qUpdate.setInt(OID_PROVINCIA,pers.getProvincia().getOID());
    else
      qUpdate.setNull(OID_PROVINCIA,java.sql.Types.INTEGER);

    if (pers.isDom_ent()!=null)
      qUpdate.setBoolean(DOM_ENT,pers.isDom_ent().booleanValue());
    else
      qUpdate.setNull(DOM_ENT,java.sql.Types.BOOLEAN);

    if (pers.getContacto()!=null)
      qUpdate.setString(CONTACTO,pers.getContacto());
    else
      qUpdate.setNull(CONTACTO,java.sql.Types.VARCHAR);

    if (pers.getSujeto_alta()!=null)
      qUpdate.setInt(OID_SUJETO_ALTA,pers.getSujeto_alta().getOID());
    else
      qUpdate.setNull(OID_SUJETO_ALTA,java.sql.Types.INTEGER);

    if (pers.getPais()!=null)
      qUpdate.setInt(OID_PAIS,pers.getPais().getOID());
    else
      qUpdate.setNull(OID_PAIS,java.sql.Types.INTEGER);

    if (pers.getZona()!=null)
      qUpdate.setInt(OID_ZONA,pers.getZona().getOID());
    else
      qUpdate.setNull(OID_ZONA,java.sql.Types.INTEGER);

    if (pers.getDirCompleta()!=null)
    	qUpdate.setString(DIR_COMPLETA,pers.getDirCompleta());
    else
    	qUpdate.setNull(DIR_COMPLETA,java.sql.Types.VARCHAR);

    if (pers.isDomicilioCobranza()!=null)
    	qUpdate.setBoolean(DOM_COBRANZA,pers.isDomicilioCobranza());
      else
    	qUpdate.setNull(DOM_COBRANZA,java.sql.Types.BOOLEAN);
    
    
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.executeUpdate();
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    final int OID_UNI_EDI = 1;
    UnidadEdilicia pers = (UnidadEdilicia) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("update veUnidadEdilicia "+
                     " set activo=0 " +
                     " where " +
                     " oid_uni_edi=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_UNI_EDI, pers.getOID());
    qUpdate.executeUpdate();
    qUpdate.close();
  }

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    final int OID_UNI_EDI = 1;
    UnidadEdilicia pers = (UnidadEdilicia) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("update veUnidadEdilicia "+
                     " set activo=1 " +
                     " where " +
                     " oid_uni_edi=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_UNI_EDI, pers.getOID());
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
      case SELECT_BY_SUJETO_ALTA: {
        ps = this.selectBySujetoAlta(aCondiciones);
        break;
      }
      case SELECT_BY_CODIGO_SUJETO: {
        ps = this.selectByCodigoSujeto(aCondiciones);
        break;
      }
    }
    return ps;
  }

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

    final int OID_UNI_EDI = 1;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  veUnidadEdilicia ");
    textSQL.append(" WHERE oid_uni_edi = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    int oid = ( (Integer) aCondiciones).intValue();
    querySelect.setInt(OID_UNI_EDI, oid);
    return querySelect;
  }

  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

    final int CODIGO = 1;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  veUnidadEdilicia ");
    textSQL.append(" WHERE codigo = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    String codigo = (String) aCondiciones;
    querySelect.setString(CODIGO, codigo);
    return querySelect;
  }

  private PreparedStatement selectByCodigoSujeto(Object aCondiciones) throws BaseException, SQLException {
    MapDatos mapaDatos = (MapDatos) aCondiciones;
    String codigo = mapaDatos.getString("codigo");
    Integer oidSujAlta = mapaDatos.getInteger("oid_sujeto");
    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  veUnidadEdilicia ");
    textSQL.append(" WHERE codigo = ? and oid_sujeto_alta = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    querySelect.setString(1, codigo);
    querySelect.setInt(2, oidSujAlta.intValue());
    return querySelect;
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_uni_edi oid,codigo codigo, dir_completa descripcion ,activo ");
    textSQL.append(" from veUnidadEdilicia");

    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    return querySelect;
  }

  private PreparedStatement selectBySujetoAlta(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    Sujeto sujeto = (Sujeto) aCondiciones;
    textSQL.append("SELECT * ");
    textSQL.append(" from veUnidadEdilicia where oid_sujeto_alta = ? ");

    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    querySelect.setInt(1,sujeto.getOID());
    return querySelect;
  }

  public static List getUnidadesEdilicias(Sujeto sujeto,
                                          ISesion aSesion) throws BaseException {
    return (List) ObjetoLogico.getObjects(UnidadEdilicia.NICKNAME,
                                          DBUnidadEdilicia.SELECT_BY_SUJETO_ALTA,
                                          sujeto,
                                          new ListObserver(),
                                          aSesion);
  }
  
  public static UnidadEdilicia getUnidadEdilicia(
 		 String codigo,
 		 Sujeto sujeto,
      ISesion aSesion)
      throws BaseException {
 	 HashTableDatos condiciones = new HashTableDatos();
 	 condiciones.put("codigo",codigo);
 	 condiciones.put("oid_sujeto",sujeto.getOIDInteger()+"");
 	 return (UnidadEdilicia) ObjetoLogico.getObjects(UnidadEdilicia.NICKNAME,
 	  				DBUnidadEdilicia.SELECT_BY_CODIGO_SUJETO,
 	  				condiciones,
 	  				new ObjetoObservado(),
 	  				aSesion);
  }
  


}
