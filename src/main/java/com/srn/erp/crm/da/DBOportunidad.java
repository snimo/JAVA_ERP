package com.srn.erp.crm.da;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.srn.erp.crm.bm.Oportunidad;

import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class DBOportunidad extends DBObjetoPersistente {

  public static final String OID_OPORTUNIDAD = "oid_oportunidad";
  public static final String TEMA = "tema";
  public static final String OID_SUJ_POT = "oid_suj_pot";
  public static final String OID_PRECIO_CAB = "oid_precio_cab";
  public static final String TIPO_RESULTADO = "tipo_resultado";
  public static final String OID_MONEDA = "oid_moneda";
  public static final String EST_ING = "est_ing";
  public static final String EST_EGR = "est_egr";
  public static final String FEC_ALTA = "fec_alta";
  public static final String OID_USU_ALTA = "oid_usu_alta";
  public static final String PROBABILIDAD = "probabilidad";
  public static final String EST_FEC_CIERRE = "est_fec_cierre";
  public static final String OID_SENSA_CIERRE = "oid_sensa_cierre";
  public static final String DESCRIPCION = "descripcion";
  public static final String OID_USU_OWNER = "oid_usu_owner";
  public static final String OID_ESTADO_OPOR = "oid_estado_opor";
  public static final String OID_CAMPANIA = "oid_campania";
  public static final String OID_SUJ_GEN_OPOR = "oid_suj_gen_opor";
  public static final String OID_VEND_TEC = "oid_vend_tec";
  public static final String OID_VEND_COMER = "oid_vend_comer";
  public static final String OID_EST_MOT_OPOR = "oid_est_mot_opor";
  public static final String OID_CLASIF_OPOR = "oid_clasif_opor";
  public static final String ACTIVO = "activo";
  public static final String CODIGO = "codigo";

  public DBOportunidad() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_OPORTUNIDAD = 1;
    final int TEMA = 2;
    final int OID_SUJ_POT = 3;
    final int OID_PRECIO_CAB = 4;
    final int TIPO_RESULTADO = 5;
    final int OID_MONEDA = 6;
    final int EST_ING = 7;
    final int EST_EGR = 8;
    final int FEC_ALTA = 9;
    final int OID_USU_ALTA = 10;
    final int PROBABILIDAD = 11;
    final int EST_FEC_CIERRE = 12;
    final int OID_SENSA_CIERRE = 13;
    final int DESCRIPCION = 14;
    final int OID_USU_OWNER = 15;
    final int OID_ESTADO_OPOR = 16;
    final int CAMPANIA = 17;
    final int OID_SUJ_GEN_OPOR = 18;
    final int OID_VEND_TEC = 19;
    final int OID_VEND_COMER = 20;
    final int OID_EST_MOT_OPOR = 21;
    final int OID_CLASIF_OPOR = 22;
    final int ACTIVO = 23;
    final int CODIGO = 24;

    Oportunidad pers = (Oportunidad) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into crmOportunidades "+
                     " ( "+
                      "OID_OPORTUNIDAD,"+
                      "TEMA,"+
                      "OID_SUJ_POT,"+
                      "OID_PRECIO_CAB,"+
                      "TIPO_RESULTADO,"+
                      "OID_MONEDA,"+
                      "EST_ING,"+
                      "EST_EGR,"+
                      "FEC_ALTA,"+
                      "OID_USU_ALTA,"+
                      "PROBABILIDAD,"+
                      "EST_FEC_CIERRE,"+
                      "OID_SENSA_CIERRE,"+
                      "DESCRIPCION,"+
                      "OID_USU_OWNER,"+
                      "OID_ESTADO_OPOR,"+
                      "OID_CAMPANIA,"+
                      "OID_SUJ_GEN_OPOR,"+
                      "OID_VEND_TEC,"+
                      "OID_VEND_COMER,"+
                      "OID_EST_MOT_OPOR,"+
                      "OID_CLASIF_OPOR,"+
                      "ACTIVO,"+
                      "CODIGO)"+ 
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
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_OPORTUNIDAD,pers.getOID());
    qInsert.setString(TEMA,pers.getTema());
    qInsert.setInt(OID_SUJ_POT,pers.getSujeto_potencial().getOID());
    if (pers.getListaprecios()!=null) 
      qInsert.setInt(OID_PRECIO_CAB,pers.getListaprecios().getOID());
    else
      qInsert.setNull(OID_PRECIO_CAB,java.sql.Types.INTEGER);
    qInsert.setString(TIPO_RESULTADO,pers.getTipo_resultado());
    if (pers.getMoneda()!=null) 
      qInsert.setInt(OID_MONEDA,pers.getMoneda().getOID());
    else
      qInsert.setNull(OID_MONEDA,java.sql.Types.INTEGER);
    if (pers.getEstimacion_ingreso()!=null) 
      qInsert.setDouble(EST_ING,pers.getEstimacion_ingreso().doubleValue());
    else
      qInsert.setNull(EST_ING,java.sql.Types.DOUBLE);
    if (pers.getEstimacion_egreso()!=null) 
      qInsert.setDouble(EST_EGR,pers.getEstimacion_egreso().doubleValue());
    else
      qInsert.setNull(EST_EGR,java.sql.Types.DOUBLE);
    qInsert.setDate(FEC_ALTA,new Date(pers.getFecha_alta().getTime()));
    qInsert.setInt(OID_USU_ALTA,pers.getUsuario_alta().getOID());
    if (pers.getProbabilidad()!=null)
      qInsert.setInt(PROBABILIDAD,pers.getProbabilidad().intValue());
    else
      qInsert.setNull(PROBABILIDAD,java.sql.Types.INTEGER);	
    if (pers.getEst_fec_cierre()!=null) 
      qInsert.setDate(EST_FEC_CIERRE,new java.sql.Date(pers.getEst_fec_cierre().getTime()));
    else
      qInsert.setNull(EST_FEC_CIERRE,java.sql.Types.DATE);
    if (pers.getSensacion_cierre()!=null) 
      qInsert.setInt(OID_SENSA_CIERRE,pers.getSensacion_cierre().getOID());
    else
      qInsert.setNull(OID_SENSA_CIERRE,java.sql.Types.INTEGER);
    qInsert.setString(DESCRIPCION,pers.getDescripcion());
    qInsert.setInt(OID_USU_OWNER,pers.getUsuario_owner().getOID());
    if (pers.getEstado_oportunidad()!=null) 
      qInsert.setInt(OID_ESTADO_OPOR,pers.getEstado_oportunidad().getOID());
    else
      qInsert.setNull(OID_ESTADO_OPOR,java.sql.Types.INTEGER);
    if (pers.getCampania()!=null) 
      qInsert.setInt(CAMPANIA,pers.getCampania().getOID());
    else
      qInsert.setNull(CAMPANIA,java.sql.Types.INTEGER);
    if (pers.getSujeto_generador()!=null) 
      qInsert.setInt(OID_SUJ_GEN_OPOR,pers.getSujeto_generador().getOID());
    else
      qInsert.setNull(OID_SUJ_GEN_OPOR,java.sql.Types.INTEGER);
    if (pers.getVendedor_tecnico()!=null) 
      qInsert.setInt(OID_VEND_TEC,pers.getVendedor_tecnico().getOID());
    else
      qInsert.setNull(OID_VEND_TEC,java.sql.Types.INTEGER);
    if (pers.getVendedor_comercial()!=null) 
      qInsert.setInt(OID_VEND_COMER,pers.getVendedor_comercial().getOID());
    else
      qInsert.setNull(OID_VEND_COMER,java.sql.Types.INTEGER);
    if (pers.getMotivo()!=null) 
      qInsert.setInt(OID_EST_MOT_OPOR,pers.getMotivo().getOID());
    else
      qInsert.setNull(OID_EST_MOT_OPOR,java.sql.Types.INTEGER);
    if (pers.getClasificacion()!=null) 
      qInsert.setInt(OID_CLASIF_OPOR,pers.getClasificacion().getOID());
    else
      qInsert.setNull(OID_CLASIF_OPOR,java.sql.Types.INTEGER);
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qInsert.setString(CODIGO,"OP"+pers.getOIDInteger().toString());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int TEMA = 1;
    final int OID_SUJ_POT = 2;
    final int OID_PRECIO_CAB = 3;
    final int TIPO_RESULTADO = 4;
    final int OID_MONEDA = 5;
    final int EST_ING = 6;
    final int EST_EGR = 7;
    final int FEC_ALTA = 8;
    final int OID_USU_ALTA = 9;
    final int PROBABILIDAD = 10;
    final int EST_FEC_CIERRE = 11;
    final int OID_SENSA_CIERRE = 12;
    final int DESCRIPCION = 13;
    final int OID_USU_OWNER = 14;
    final int OID_ESTADO_OPOR = 15;
    final int CAMPANIA = 16;
    final int OID_SUJ_GEN_OPOR = 17;
    final int OID_VEND_TEC = 18;
    final int OID_VEND_COMER = 19;
    final int OID_EST_MOT_OPOR = 20;
    final int OID_CLASIF_OPOR = 21;
    final int ACTIVO = 22;
    final int CODIGO = 23;
    final int OID_OPORTUNIDAD = 24;

    Oportunidad pers = (Oportunidad) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update crmOportunidades set "+
              "tema=?"+ 
              ",oid_suj_pot=?"+ 
              ",oid_precio_cab=?"+ 
              ",tipo_resultado=?"+ 
              ",oid_moneda=?"+ 
              ",est_ing=?"+ 
              ",est_egr=?"+ 
              ",fec_alta=?"+ 
              ",oid_usu_alta=?"+ 
              ",probabilidad=?"+ 
              ",est_fec_cierre=?"+ 
              ",oid_sensa_cierre=?"+ 
              ",descripcion=?"+ 
              ",oid_usu_owner=?"+ 
              ",oid_estado_opor=?"+ 
              ",oid_campania=?"+ 
              ",oid_suj_gen_opor=?"+ 
              ",oid_vend_tec=?"+ 
              ",oid_vend_comer=?"+ 
              ",oid_est_mot_opor=?"+ 
              ",oid_clasif_opor=?"+               
              ",activo=?"+
              ",codigo=?"+
                 " where " +
                 " oid_oportunidad=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_OPORTUNIDAD,pers.getOID());
    qUpdate.setString(TEMA,pers.getTema());
    qUpdate.setInt(OID_SUJ_POT,pers.getSujeto_potencial().getOID());
    if (pers.getListaprecios()!=null) 
      qUpdate.setInt(OID_PRECIO_CAB,pers.getListaprecios().getOID());
    else
      qUpdate.setNull(OID_PRECIO_CAB,java.sql.Types.INTEGER);
    qUpdate.setString(TIPO_RESULTADO,pers.getTipo_resultado());
    if (pers.getMoneda()!=null) 
      qUpdate.setInt(OID_MONEDA,pers.getMoneda().getOID());
    else
      qUpdate.setNull(OID_MONEDA,java.sql.Types.INTEGER);
    if (pers.getEstimacion_ingreso()!=null) 
      qUpdate.setDouble(EST_ING,pers.getEstimacion_ingreso().doubleValue());
    else
      qUpdate.setNull(EST_ING,java.sql.Types.DOUBLE);
    if (pers.getEstimacion_egreso()!=null) 
      qUpdate.setDouble(EST_EGR,pers.getEstimacion_egreso().doubleValue());
    else
      qUpdate.setNull(EST_EGR,java.sql.Types.DOUBLE);
    qUpdate.setDate(FEC_ALTA,new java.sql.Date(pers.getFecha_alta().getTime()));
    qUpdate.setInt(OID_USU_ALTA,pers.getUsuario_alta().getOID());    
    if (pers.getProbabilidad()!=null)
    	qUpdate.setInt(PROBABILIDAD,pers.getProbabilidad().intValue());
      else
    	qUpdate.setNull(PROBABILIDAD,java.sql.Types.INTEGER);        
    if (pers.getEst_fec_cierre()!=null) 
      qUpdate.setDate(EST_FEC_CIERRE,new Date(pers.getEst_fec_cierre().getTime()));
    else
      qUpdate.setNull(EST_FEC_CIERRE,java.sql.Types.DATE);
    if (pers.getSensacion_cierre()!=null) 
      qUpdate.setInt(OID_SENSA_CIERRE,pers.getSensacion_cierre().getOID());
    else
      qUpdate.setNull(OID_SENSA_CIERRE,java.sql.Types.INTEGER);
    qUpdate.setString(DESCRIPCION,pers.getDescripcion());
    qUpdate.setInt(OID_USU_OWNER,pers.getUsuario_owner().getOID());
    if (pers.getEstado_oportunidad()!=null) 
      qUpdate.setInt(OID_ESTADO_OPOR,pers.getEstado_oportunidad().getOID());
    else
      qUpdate.setNull(OID_ESTADO_OPOR,java.sql.Types.INTEGER);
    if (pers.getCampania()!=null) 
      qUpdate.setInt(CAMPANIA,pers.getCampania().getOID());
    else
      qUpdate.setNull(CAMPANIA,java.sql.Types.INTEGER);
    if (pers.getSujeto_generador()!=null) 
      qUpdate.setInt(OID_SUJ_GEN_OPOR,pers.getSujeto_generador().getOID());
    else
      qUpdate.setNull(OID_SUJ_GEN_OPOR,java.sql.Types.INTEGER);
    if (pers.getVendedor_tecnico()!=null) 
      qUpdate.setInt(OID_VEND_TEC,pers.getVendedor_tecnico().getOID());
    else
      qUpdate.setNull(OID_VEND_TEC,java.sql.Types.INTEGER);
    if (pers.getVendedor_comercial()!=null) 
      qUpdate.setInt(OID_VEND_COMER,pers.getVendedor_comercial().getOID());
    else
      qUpdate.setNull(OID_VEND_COMER,java.sql.Types.INTEGER);
    if (pers.getMotivo()!=null) 
      qUpdate.setInt(OID_EST_MOT_OPOR,pers.getMotivo().getOID());
    else
      qUpdate.setNull(OID_EST_MOT_OPOR,java.sql.Types.INTEGER);
    if (pers.getClasificacion()!=null) 
      qUpdate.setInt(OID_CLASIF_OPOR,pers.getClasificacion().getOID());
    else
      qUpdate.setNull(OID_CLASIF_OPOR,java.sql.Types.INTEGER);
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.setString(CODIGO,pers.getCodigo());
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_OPORTUNIDAD = 1; 
    Oportunidad pers = (Oportunidad) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update crmOportunidades "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_oportunidad=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_OPORTUNIDAD, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_OPORTUNIDAD = 1; 
    Oportunidad pers = (Oportunidad) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update crmOportunidades "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_oportunidad=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_OPORTUNIDAD, pers.getOID()); 
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

    final int OID_OPORTUNIDAD = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  crmOportunidades "); 
    textSQL.append(" WHERE oid_oportunidad = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_OPORTUNIDAD, oid); 
    return querySelect; 
  }
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  crmOportunidades "); 
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_oportunidad oid, codigo,  tema descripcion ,activo ");
    textSQL.append(" from crmOportunidades");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  } 
  
} 
