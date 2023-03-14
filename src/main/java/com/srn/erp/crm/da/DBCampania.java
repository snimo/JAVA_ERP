package com.srn.erp.crm.da;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.srn.erp.crm.bm.Campania;

import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Utils.Fecha;
import framework.applicarionServer.bm.Seguridad.Usuario;
import framework.request.bl.Utils.BaseException;

public class DBCampania extends DBObjetoPersistente {

  public static final String OID_CAMPANIA = "oid_campania";
  public static final String CODIGO = "codigo";
  public static final String NOMBRE = "nombre";
  public static final String OID_EST_CAMP = "oid_est_camp";
  public static final String OID_PRECIO_CAB = "oid_precio_cab";
  public static final String CANT_RESP_ESP = "cant_resp_esp";
  public static final String FEC_DESDE = "fec_desde";
  public static final String FEC_HASTA = "fec_hasta";
  public static final String DESCRIPCION = "descripcion";
  public static final String COMENTARIO = "comentario";
  public static final String OID_USU_ALTA = "oid_usu_alta";
  public static final String FEC_ALTA = "fec_alta";
  public static final String ACTIVO = "activo";
  public static final String OID_TIPO_CAMP = "oid_tipo_camp";

  public DBCampania() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_CAMPANIA = 1;
    final int CODIGO = 2;
    final int NOMBRE = 3;
    final int OID_EST_CAMP = 4;
    final int OID_PRECIO_CAB = 5;
    final int CANT_RESP_ESP = 6;
    final int FEC_DESDE = 7;
    final int FEC_HASTA = 8;
    final int DESCRIPCION = 9;
    final int COMENTARIO = 10;
    final int OID_USU_ALTA = 11;
    final int FEC_ALTA = 12;
    final int ACTIVO = 13;
    final int TIPO_CAMPANIA =14;

    Campania pers = (Campania) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into crmCampania "+
                     " ( "+
                      "OID_CAMPANIA,"+
                      "CODIGO,"+
                      "NOMBRE,"+
                      "OID_EST_CAMP,"+
                      "OID_PRECIO_CAB,"+
                      "CANT_RESP_ESP,"+
                      "FEC_DESDE,"+
                      "FEC_HASTA,"+
                      "DESCRIPCION,"+
                      "COMENTARIO,"+
                      "OID_USU_ALTA,"+
                      "FEC_ALTA,"+
                      "ACTIVO,"+
                      "OID_TIPO_CAMP)"+ 
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
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_CAMPANIA,pers.getOID());
    qInsert.setString(CODIGO,pers.getCodigo());
    qInsert.setString(NOMBRE,pers.getNombre());
    qInsert.setInt(OID_EST_CAMP,pers.getEstado().getOID());
    qInsert.setInt(OID_PRECIO_CAB,pers.getLista_precios().getOID());
    qInsert.setInt(CANT_RESP_ESP,pers.getCant_resp_esp().intValue());
    qInsert.setDate(FEC_DESDE,new Date(pers.getFecha_desde().getTime()));
    qInsert.setDate(FEC_HASTA,new Date(pers.getFecha_hasta().getTime()));
    qInsert.setString(DESCRIPCION,pers.getDescripcion());
    qInsert.setString(COMENTARIO,pers.getComentario());
    
    Usuario usuario = Usuario.findByOidProxy(getSesion().getLogin().getUsuario().getOIDInteger(),getSesion());
    qInsert.setInt(OID_USU_ALTA,usuario.getOID());
    qInsert.setDate(FEC_ALTA,new java.sql.Date(Fecha.getFechaActual().getTime()));
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qInsert.setInt(TIPO_CAMPANIA,pers.getTipoCampania().getOID());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int CODIGO = 1;
    final int NOMBRE = 2;
    final int OID_EST_CAMP = 3;
    final int OID_PRECIO_CAB = 4;
    final int CANT_RESP_ESP = 5;
    final int FEC_DESDE = 6;
    final int FEC_HASTA = 7;
    final int DESCRIPCION = 8;
    final int COMENTARIO = 9;
    final int OID_USU_ALTA = 10;
    final int FEC_ALTA = 11;
    final int ACTIVO = 12;
    final int TIPO_CAMPANIA =13;
    final int OID_CAMPANIA = 14;

    Campania pers = (Campania) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update crmCampania set "+
              "codigo=?"+ 
              ",nombre=?"+ 
              ",oid_est_camp=?"+ 
              ",oid_precio_cab=?"+ 
              ",cant_resp_esp=?"+ 
              ",fec_desde=?"+ 
              ",fec_hasta=?"+ 
              ",descripcion=?"+ 
              ",comentario=?"+ 
              ",oid_usu_alta=?"+ 
              ",fec_alta=?"+ 
              ",activo=?"+ 
              ",oid_tipo_camp=?"+
                 " where " +
                 " oid_campania=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_CAMPANIA,pers.getOID());
    qUpdate.setString(CODIGO,pers.getCodigo());
    qUpdate.setString(NOMBRE,pers.getNombre());
    qUpdate.setInt(OID_EST_CAMP,pers.getEstado().getOID());
    qUpdate.setInt(OID_PRECIO_CAB,pers.getLista_precios().getOID());
    qUpdate.setInt(CANT_RESP_ESP,pers.getCant_resp_esp().intValue());
    qUpdate.setDate(FEC_DESDE,new Date(pers.getFecha_desde().getTime()));
    qUpdate.setDate(FEC_HASTA,new Date(pers.getFecha_hasta().getTime()));
    qUpdate.setString(DESCRIPCION,pers.getDescripcion());
    qUpdate.setString(COMENTARIO,pers.getComentario());
    qUpdate.setInt(OID_USU_ALTA,pers.getUsuario_alta().getOID());
    qUpdate.setDate(FEC_ALTA,new Date(pers.getFec_usu_alta().getTime()));
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.setInt(TIPO_CAMPANIA,pers.getTipoCampania().getOID());
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_CAMPANIA = 1; 
    Campania pers = (Campania) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update crmCampania "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_campania=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_CAMPANIA, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_CAMPANIA = 1; 
    Campania pers = (Campania) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update crmCampania "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_campania=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_CAMPANIA, pers.getOID()); 
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
    } 
    return ps;
  } 

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_CAMPANIA = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  crmCampania "); 
    textSQL.append(" WHERE oid_campania = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_CAMPANIA, oid); 
    return querySelect; 
  }
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  crmCampania "); 
    textSQL.append(" WHERE codigo = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_campania oid,codigo codigo, descripcion descripcion ,activo ");
    textSQL.append(" from crmCampania");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  } 
  
} 
