package com.srn.erp.cip.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.cip.bm.Visita;
import com.srn.erp.general.bm.ValorClasificadorEntidad;
import com.srn.erp.sueldos.bm.Legajo;
import com.srn.erp.sueldos.da.DBLegajo;
import com.srn.erp.ventas.bm.TipoDocumento;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.ObjetoObservado;

public class DBVisita extends DBObjetoPersistente {

  public static final String OID_VISITA = "oid_visita";
  public static final String APE_Y_NOM = "ape_y_nom";
  public static final String ACTIVO = "activo";
  
  public static final String OID_CLASIF_01 = "oid_clasif_01";
  public static final String OID_CLASIF_02 = "oid_clasif_02";
  public static final String OID_CLASIF_03 = "oid_clasif_03";
  public static final String OID_CLASIF_04 = "oid_clasif_04";
  public static final String OID_CLASIF_05 = "oid_clasif_05";
  public static final String OID_CLASIF_06 = "oid_clasif_06";
  public static final String OID_CLASIF_07 = "oid_clasif_07";
  public static final String OID_CLASIF_08 = "oid_clasif_08";
  public static final String OID_CLASIF_09 = "oid_clasif_09";
  public static final String OID_CLASIF_10 = "oid_clasif_10";
  public static final String OID_CLASIF_11 = "oid_clasif_11";
  public static final String OID_CLASIF_12 = "oid_clasif_12";
  public static final String OID_CLASIF_13 = "oid_clasif_13";
  public static final String OID_CLASIF_14 = "oid_clasif_14";
  public static final String OID_CLASIF_15 = "oid_clasif_15";
  public static final String OID_CLASIF_16 = "oid_clasif_16";
  public static final String OID_CLASIF_17 = "oid_clasif_17";
  public static final String OID_CLASIF_18 = "oid_clasif_18";
  public static final String OID_CLASIF_19 = "oid_clasif_19";
  public static final String OID_CLASIF_20 = "oid_clasif_20";
  public static final String OID_TIPO_DOCUMENTO = "oid_tipo_documento";
  public static final String NRO_DOCUMENTO = "nro_documento";
  public static final String OID_GRUPO_PUE_ING = "oid_grupo_pue_ing";
  public static final String OID_GRUPO_PUE_EGR = "oid_grupo_pue_egr";
  public static final String EMPRESA_CIP = "oid_empresa";
  public static final String OID_ZONA_ACTUAL = "oid_zona_actual";
  public static final String OID_VISITA_A = "oid_visita_a";
  public static final String OID_AUTORIZA = "oid_autoriza";
  
  public static final String FEC_HOR_ULT_MOV = "fec_hor_ult_mov";
  public static final String SENTIDO = "sentido";
  public static final String CONTROL_ANTI_PASSBACK = "antipass_vis";
  public static final String IGNORAR_PROX_ANTIPASS = "ignorar_prox_anti";
  public static final String OID_PLANIF_SEM = "oid_planif_sem";  
  public static final String OID_GRUPO_VISITA = "oid_grupo_visita";
  public static final String APLIC_VIG = "aplic_vig";
  public static final String FEC_DESDE_VIG = "fec_desde_vig";
  public static final String FEC_HASTA_VIG = "fec_hasta_vig";
  public static final String OID_CATEG_ACC_INT = "oid_categ_acc_int";
  public static final String OID_MOT_VISITA = "oid_mot_visita";
  public static final String LIB_ACC_AL_PREDIO = "lib_acc_al_predio";
  
  
  public static final int SELECT_BY_CONDICIONES = 100;
  public static final int SELECT_BY_TIPODOCU_NRO = 101;
  public static final int SELECT_BY_NRODOCU = 103;
  public static final int SELECT_HELP_VISITA_CON_TARJ = 104;
  public static final int SELECT_BY_VISITAS_EN_PREDIO = 105;
  
  public DBVisita() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_VISITA = 1;
    final int APE_Y_NOM = 2;
    final int ACTIVO = 3;
    
    final int OID_CLASIF_01 = 4;
    final int OID_CLASIF_02 = 5;
    final int OID_CLASIF_03 = 6;
    final int OID_CLASIF_04 = 7;
    final int OID_CLASIF_05 = 8;
    final int OID_CLASIF_06 = 9;
    final int OID_CLASIF_07 = 10;
    final int OID_CLASIF_08 = 11;
    final int OID_CLASIF_09 = 12;
    final int OID_CLASIF_10 = 13;
    final int OID_CLASIF_11 = 14;
    final int OID_CLASIF_12 = 15;
    final int OID_CLASIF_13 = 16;
    final int OID_CLASIF_14 = 17;
    final int OID_CLASIF_15 = 18;
    final int OID_CLASIF_16 = 19;
    final int OID_CLASIF_17 = 20;
    final int OID_CLASIF_18 = 21;
    final int OID_CLASIF_19 = 22;
    final int OID_CLASIF_20 = 23;
    
    final int OID_TIPO_DOCUMENTO = 24;
    final int NRO_DOCUMENTO = 25;
    
    final int OID_GRUPO_PUE_ING = 26;
    final int OID_GRUPO_PUE_EGR = 27;
    final int OID_EMPRESA = 28;
    final int OID_ZONA_ACTUAL = 29;
    final int OID_VISITA_A = 30;
    final int OID_AUTORIZA = 31;
    final int FEC_HOR_ULT_MOV = 32;
    final int SENTIDO = 33;
    final int CONTROL_ANTIPASSBACK = 34;
    final int IGNORAR_PROX_ANTI = 35;
    final int OID_PLANIF_SEM = 36;
    final int OID_GRUPO_VISITA = 37;
    final int APLIC_VIG = 38;
    final int FEC_DESDE_VIG = 39;
    final int FEC_HASTA_VIG = 40;
    final int OID_CATEG_ACC_INT = 41;
    final int OID_MOT_VISITA = 42;
    final int LIB_ACC_AL_PREDIO = 43;
    
    Visita pers = (Visita) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into cipVisita "+
                     " ( "+
                      "OID_VISITA,"+
                      "APE_Y_NOM,"+
                      "ACTIVO,"+
                      "OID_CLASIF_01,"+
                      "OID_CLASIF_02,"+
                      "OID_CLASIF_03,"+
                      "OID_CLASIF_04,"+
                      "OID_CLASIF_05,"+
                      "OID_CLASIF_06,"+
                      "OID_CLASIF_07,"+
                      "OID_CLASIF_08,"+
                      "OID_CLASIF_09,"+
                      "OID_CLASIF_10,"+
                      "OID_CLASIF_11,"+
                      "OID_CLASIF_12,"+
                      "OID_CLASIF_13,"+
                      "OID_CLASIF_14,"+
                      "OID_CLASIF_15,"+
                      "OID_CLASIF_16,"+
                      "OID_CLASIF_17,"+
                      "OID_CLASIF_18,"+
                      "OID_CLASIF_19,"+
                      "OID_CLASIF_20,OID_TIPO_DOCUMENTO,NRO_DOCUMENTO,OID_GRUPO_PUE_ING,OID_GRUPO_PUE_EGR,OID_EMPRESA,OID_ZONA_ACTUAL,OID_VISITA_A,OID_AUTORIZA,FEC_HOR_ULT_MOV,SENTIDO,antipass_vis,ignorar_prox_anti,oid_planif_sem,oid_grupo_visita,aplic_vig,fec_desde_vig,fec_hasta_vig,oid_categ_acc_int,oid_mot_visita,lib_acc_al_predio) "+
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
                      "?"+
                      ") ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_VISITA,pers.getOID());
    qInsert.setString(APE_Y_NOM,pers.getApeyNom());
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    
    qInsert.setInt(OID_CLASIF_01,pers.getOidValorClasif(new Integer(1)).intValue());
    qInsert.setInt(OID_CLASIF_02,pers.getOidValorClasif(new Integer(2)).intValue());
    qInsert.setInt(OID_CLASIF_03,pers.getOidValorClasif(new Integer(3)).intValue());
    qInsert.setInt(OID_CLASIF_04,pers.getOidValorClasif(new Integer(4)).intValue());
    qInsert.setInt(OID_CLASIF_05,pers.getOidValorClasif(new Integer(5)).intValue());
    qInsert.setInt(OID_CLASIF_06,pers.getOidValorClasif(new Integer(6)).intValue());
    qInsert.setInt(OID_CLASIF_07,pers.getOidValorClasif(new Integer(7)).intValue());
    qInsert.setInt(OID_CLASIF_08,pers.getOidValorClasif(new Integer(8)).intValue());
    qInsert.setInt(OID_CLASIF_09,pers.getOidValorClasif(new Integer(9)).intValue());
    qInsert.setInt(OID_CLASIF_10,pers.getOidValorClasif(new Integer(10)).intValue());
    qInsert.setInt(OID_CLASIF_11,pers.getOidValorClasif(new Integer(11)).intValue());
    qInsert.setInt(OID_CLASIF_12,pers.getOidValorClasif(new Integer(12)).intValue());
    qInsert.setInt(OID_CLASIF_13,pers.getOidValorClasif(new Integer(13)).intValue());
    qInsert.setInt(OID_CLASIF_14,pers.getOidValorClasif(new Integer(14)).intValue());
    qInsert.setInt(OID_CLASIF_15,pers.getOidValorClasif(new Integer(15)).intValue());
    qInsert.setInt(OID_CLASIF_16,pers.getOidValorClasif(new Integer(16)).intValue());
    qInsert.setInt(OID_CLASIF_17,pers.getOidValorClasif(new Integer(17)).intValue());
    qInsert.setInt(OID_CLASIF_18,pers.getOidValorClasif(new Integer(18)).intValue());
    qInsert.setInt(OID_CLASIF_19,pers.getOidValorClasif(new Integer(19)).intValue());
    qInsert.setInt(OID_CLASIF_20,pers.getOidValorClasif(new Integer(20)).intValue());
    
    if (pers.getTipoDocumento()!=null)
    	qInsert.setInt(OID_TIPO_DOCUMENTO,pers.getTipoDocumento().getOID());
    else 
    	qInsert.setNull(OID_TIPO_DOCUMENTO,java.sql.Types.INTEGER);
    
    if (pers.getNroDocumento()!=null)
    	qInsert.setString(NRO_DOCUMENTO,pers.getNroDocumento());
    else 
    	qInsert.setNull(NRO_DOCUMENTO,java.sql.Types.VARCHAR);    
    
    if (pers.getGrupoPuertaIngreso()!=null)
    	qInsert.setInt(OID_GRUPO_PUE_ING,pers.getGrupoPuertaIngreso().getOID());
    else 
    	qInsert.setNull(OID_GRUPO_PUE_ING,java.sql.Types.INTEGER);    
    
    if (pers.getGrupoPuertaEgreso()!=null)
    	qInsert.setInt(OID_GRUPO_PUE_EGR,pers.getGrupoPuertaEgreso().getOID());
    else 
    	qInsert.setNull(OID_GRUPO_PUE_EGR,java.sql.Types.INTEGER);    
    
    if (pers.getEmpresaCIP()!=null)
    	qInsert.setInt(OID_EMPRESA,pers.getEmpresaCIP().getOID());
    else 
    	qInsert.setNull(OID_EMPRESA,java.sql.Types.INTEGER);    
    
    if (pers.getZonaActual()!=null)
    	qInsert.setInt(OID_ZONA_ACTUAL, pers.getZonaActual().getOID());
    else
    	qInsert.setNull(OID_ZONA_ACTUAL, Types.INTEGER);
    
    if (pers.getVisitaA()!=null)
    	qInsert.setInt(OID_VISITA_A, pers.getVisitaA().getOID());
    else
    	qInsert.setNull(OID_VISITA_A, Types.INTEGER);
    
    if (pers.getAutoriza()!=null)
    	qInsert.setInt(OID_AUTORIZA, pers.getAutoriza().getOID());
    else
    	qInsert.setNull(OID_AUTORIZA, Types.INTEGER);
    
    if (pers.getFecHorUltMov()!=null)
    	qInsert.setTimestamp(FEC_HOR_ULT_MOV, new java.sql.Timestamp(pers.getFecHorUltMov().getTime()));
    else
    	qInsert.setNull(FEC_HOR_ULT_MOV, Types.TIMESTAMP);
    
    if (pers.getSentido()!=null)
    	qInsert.setString(SENTIDO, pers.getSentido());
    else
    	qInsert.setNull(SENTIDO, Types.VARCHAR);
    
    qInsert.setBoolean(CONTROL_ANTIPASSBACK, pers.isControlAntiPassBack());
    qInsert.setBoolean(IGNORAR_PROX_ANTI , pers.isIgnorarProxAntiPassBack());
    
    if (pers.getPermisoSemanal()!=null)
    	qInsert.setInt(OID_PLANIF_SEM, pers.getPermisoSemanal().getOID());
    else
    	qInsert.setNull(OID_PLANIF_SEM, Types.INTEGER);
    if (pers.getGrupoVisita()!=null)
    	qInsert.setInt(OID_GRUPO_VISITA, pers.getGrupoVisita().getOID());
    else
    	qInsert.setNull(OID_GRUPO_VISITA, Types.INTEGER);
    qInsert.setBoolean(APLIC_VIG, pers.isAplicVigencia());
    if (pers.getFecVigenciaDesde()!=null)
    	qInsert.setDate(FEC_DESDE_VIG, new java.sql.Date(pers.getFecVigenciaDesde().getTime()));
    else
    	qInsert.setNull(FEC_DESDE_VIG, Types.DATE);
    if (pers.getFecVigenciaHasta()!=null)
    	qInsert.setDate(FEC_HASTA_VIG, new java.sql.Date(pers.getFecVigenciaHasta().getTime()));
    else
    	qInsert.setNull(FEC_HASTA_VIG, Types.DATE);
    if (pers.getCategoriaAcceso()!=null)
    	qInsert.setInt(OID_CATEG_ACC_INT, pers.getCategoriaAcceso().getOID());
    else
    	qInsert.setNull(OID_CATEG_ACC_INT, Types.INTEGER);
    if (pers.getMotivoVisita()!=null)
    	qInsert.setInt(OID_MOT_VISITA, pers.getMotivoVisita().getOID());
    else
    	qInsert.setNull(OID_MOT_VISITA, Types.INTEGER);
    qInsert.setBoolean(LIB_ACC_AL_PREDIO, pers.isLibAccesoAlPredio());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int APE_Y_NOM = 1;
    final int ACTIVO = 2;
    
    final int OID_CLASIF_01 = 3;
    final int OID_CLASIF_02 = 4;
    final int OID_CLASIF_03 = 5;
    final int OID_CLASIF_04 = 6;
    final int OID_CLASIF_05 = 7;
    final int OID_CLASIF_06 = 8;
    final int OID_CLASIF_07 = 9;
    final int OID_CLASIF_08 = 10;
    final int OID_CLASIF_09 = 11;
    final int OID_CLASIF_10 = 12;
    final int OID_CLASIF_11 = 13;
    final int OID_CLASIF_12 = 14;
    final int OID_CLASIF_13 = 15;
    final int OID_CLASIF_14 = 16;
    final int OID_CLASIF_15 = 17;
    final int OID_CLASIF_16 = 18;
    final int OID_CLASIF_17 = 19;
    final int OID_CLASIF_18 = 20;
    final int OID_CLASIF_19 = 21;
    final int OID_CLASIF_20 = 22;

    final int TIPO_DOCUMENTO = 23;
    final int NRO_DOCUMENTO = 24;
    final int OID_GRUPO_PUE_ING = 25;
    final int OID_GRUPO_PUE_EGR = 26;
    final int OID_EMPRESA = 27;
    final int OID_ZONA_ACTUAL = 28;
    final int OID_VISITA_A = 29;
    final int OID_AUTORIZA = 30;
    final int FEC_HOR_ULT_MOV = 31;
    final int SENTIDO = 32;
    final int CONTROL_ANTIPASSBACK = 33;
    final int IGNORAR_PROX_ANTI = 34;
    final int OID_PLANIF_SEM = 35;
    final int OID_GRUPO_VISITA = 36;
    final int APLIC_VIG = 37;
    final int FEC_DESDE_VIG = 38;
    final int FEC_HASTA_VIG = 39;
    final int OID_CATEG_ACC_INT = 40;
    final int OID_MOT_VISITA = 41;
    final int LIB_ACC_AL_PREDIO = 42;
    final int OID_VISITA = 43;

    Visita pers = (Visita) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update cipVisita set "+
              "ape_y_nom=?"+ 
              ",activo=?,"+ 
              "oid_clasif_01 = ?,"+
              "oid_clasif_02 = ?,"+
              "oid_clasif_03 = ?,"+
              "oid_clasif_04 = ?,"+
              "oid_clasif_05 = ?,"+
              "oid_clasif_06 = ?,"+
              "oid_clasif_07 = ?,"+
              "oid_clasif_08 = ?,"+
              "oid_clasif_09 = ?,"+
              "oid_clasif_10 = ?,"+
              "oid_clasif_11 = ?,"+
              "oid_clasif_12 = ?,"+
              "oid_clasif_13 = ?,"+
              "oid_clasif_14 = ?,"+
              "oid_clasif_15 = ?,"+
              "oid_clasif_16 = ?,"+
              "oid_clasif_17 = ?,"+
              "oid_clasif_18 = ?,"+
              "oid_clasif_19 = ?,"+
              "oid_clasif_20 = ?, "+
              "oid_tipo_documento = ?, "+
              "nro_documento = ?, "+
              "oid_grupo_pue_ing = ?,"+
              "oid_grupo_pue_egr = ?, "+
              "oid_empresa = ?, "+
              "oid_zona_actual = ?, "+
              "oid_visita_a = ? ,"+
              "oid_autoriza=?, "+
              "fec_hor_ult_mov=?, "+
              "sentido=?, "+
              "antipass_vis=?, "+
              "ignorar_prox_anti=?, "+
              "oid_planif_sem=?, "+
              "oid_grupo_visita=?, aplic_vig = ?,fec_desde_vig = ?,fec_hasta_vig = ? , oid_categ_acc_int = ? , oid_mot_visita = ? , lib_acc_al_predio = ? "+
                 " where " +
                 " oid_visita=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_VISITA,pers.getOID());
    qUpdate.setString(APE_Y_NOM,pers.getApeyNom());
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    
    qUpdate.setInt(OID_CLASIF_01,pers.getOidValorClasif(new Integer(1)).intValue());
    qUpdate.setInt(OID_CLASIF_02,pers.getOidValorClasif(new Integer(2)).intValue());
    qUpdate.setInt(OID_CLASIF_03,pers.getOidValorClasif(new Integer(3)).intValue());
    qUpdate.setInt(OID_CLASIF_04,pers.getOidValorClasif(new Integer(4)).intValue());
    qUpdate.setInt(OID_CLASIF_05,pers.getOidValorClasif(new Integer(5)).intValue());
    qUpdate.setInt(OID_CLASIF_06,pers.getOidValorClasif(new Integer(6)).intValue());
    qUpdate.setInt(OID_CLASIF_07,pers.getOidValorClasif(new Integer(7)).intValue());
    qUpdate.setInt(OID_CLASIF_08,pers.getOidValorClasif(new Integer(8)).intValue());
    qUpdate.setInt(OID_CLASIF_09,pers.getOidValorClasif(new Integer(9)).intValue());
    qUpdate.setInt(OID_CLASIF_10,pers.getOidValorClasif(new Integer(10)).intValue());
    qUpdate.setInt(OID_CLASIF_11,pers.getOidValorClasif(new Integer(11)).intValue());
    qUpdate.setInt(OID_CLASIF_12,pers.getOidValorClasif(new Integer(12)).intValue());
    qUpdate.setInt(OID_CLASIF_13,pers.getOidValorClasif(new Integer(13)).intValue());
    qUpdate.setInt(OID_CLASIF_14,pers.getOidValorClasif(new Integer(14)).intValue());
    qUpdate.setInt(OID_CLASIF_15,pers.getOidValorClasif(new Integer(15)).intValue());
    qUpdate.setInt(OID_CLASIF_16,pers.getOidValorClasif(new Integer(16)).intValue());
    qUpdate.setInt(OID_CLASIF_17,pers.getOidValorClasif(new Integer(17)).intValue());
    qUpdate.setInt(OID_CLASIF_18,pers.getOidValorClasif(new Integer(18)).intValue());
    qUpdate.setInt(OID_CLASIF_19,pers.getOidValorClasif(new Integer(19)).intValue());
    qUpdate.setInt(OID_CLASIF_20,pers.getOidValorClasif(new Integer(20)).intValue());
    
    if (pers.getTipoDocumento()!=null)
    	qUpdate.setInt(TIPO_DOCUMENTO,pers.getTipoDocumento().getOID());
    else 
    	qUpdate.setNull(TIPO_DOCUMENTO,java.sql.Types.INTEGER);
    
    if (pers.getNroDocumento()!=null)
    	qUpdate.setString(NRO_DOCUMENTO,pers.getNroDocumento());
    else 
    	qUpdate.setNull(NRO_DOCUMENTO,java.sql.Types.VARCHAR);
    
    if (pers.getGrupoPuertaIngreso()!=null)
    	qUpdate.setInt(OID_GRUPO_PUE_ING,pers.getGrupoPuertaIngreso().getOID());
    else 
    	qUpdate.setNull(OID_GRUPO_PUE_ING,java.sql.Types.INTEGER);    
    
    if (pers.getGrupoPuertaEgreso()!=null)
    	qUpdate.setInt(OID_GRUPO_PUE_EGR,pers.getGrupoPuertaEgreso().getOID());
    else 
    	qUpdate.setNull(OID_GRUPO_PUE_EGR,java.sql.Types.INTEGER);
    
    if (pers.getEmpresaCIP()!=null)
    	qUpdate.setInt(OID_EMPRESA,pers.getEmpresaCIP().getOID());
    else 
    	qUpdate.setNull(OID_EMPRESA,java.sql.Types.INTEGER);    
    
    if (pers.getZonaActual()!=null)
    	qUpdate.setInt(OID_ZONA_ACTUAL, pers.getZonaActual().getOID());
    else
    	qUpdate.setNull(OID_ZONA_ACTUAL, Types.INTEGER);
    
    if (pers.getVisitaA()!=null)
    	qUpdate.setInt(OID_VISITA_A, pers.getVisitaA().getOID());
    else
    	qUpdate.setNull(OID_VISITA_A, Types.INTEGER);
    
    if (pers.getAutoriza()!=null)
    	qUpdate.setInt(OID_AUTORIZA, pers.getAutoriza().getOID());
    else
    	qUpdate.setNull(OID_AUTORIZA, Types.INTEGER);

    if (pers.getFecHorUltMov()!=null)
    	qUpdate.setTimestamp(FEC_HOR_ULT_MOV, new java.sql.Timestamp(pers.getFecHorUltMov().getTime()));
    else
    	qUpdate.setNull(FEC_HOR_ULT_MOV, Types.TIMESTAMP);
    
    if (pers.getSentido()!=null)
    	qUpdate.setString(SENTIDO, pers.getSentido());
    else
    	qUpdate.setNull(SENTIDO, Types.VARCHAR);
    qUpdate.setBoolean(CONTROL_ANTIPASSBACK, pers.isControlAntiPassBack());
    qUpdate.setBoolean(IGNORAR_PROX_ANTI , pers.isIgnorarProxAntiPassBack());
    if (pers.getPermisoSemanal()!=null)
    	qUpdate.setInt(OID_PLANIF_SEM, pers.getPermisoSemanal().getOID());
    else
    	qUpdate.setNull(OID_PLANIF_SEM, Types.INTEGER);
    if (pers.getGrupoVisita()!=null)
    	qUpdate.setInt(OID_GRUPO_VISITA, pers.getGrupoVisita().getOID());
    else
    	qUpdate.setNull(OID_GRUPO_VISITA, Types.INTEGER);
    
    qUpdate.setBoolean(APLIC_VIG, pers.isAplicVigencia());
    if (pers.getFecVigenciaDesde()!=null)
    	qUpdate.setDate(FEC_DESDE_VIG, new java.sql.Date(pers.getFecVigenciaDesde().getTime()));
    else
    	qUpdate.setNull(FEC_DESDE_VIG, Types.DATE);
    if (pers.getFecVigenciaHasta()!=null)
    	qUpdate.setDate(FEC_HASTA_VIG, new java.sql.Date(pers.getFecVigenciaHasta().getTime()));
    else
    	qUpdate.setNull(FEC_HASTA_VIG, Types.DATE);
    if (pers.getCategoriaAcceso()!=null)
    	qUpdate.setInt(OID_CATEG_ACC_INT, pers.getCategoriaAcceso().getOID());
    else
    	qUpdate.setNull(OID_CATEG_ACC_INT, Types.INTEGER);
    if (pers.getMotivoVisita()!=null)
    	qUpdate.setInt(OID_MOT_VISITA, pers.getMotivoVisita().getOID());
    else
    	qUpdate.setNull(OID_MOT_VISITA, Types.INTEGER);
    qUpdate.setBoolean(LIB_ACC_AL_PREDIO, pers.isLibAccesoAlPredio());
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_VISITA = 1; 
    Visita pers = (Visita) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update cipVisita "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_visita=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_VISITA, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_LEGAJO = 1; 
    Visita pers = (Visita) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update cipVisita "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_visita=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_LEGAJO, pers.getOID()); 
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
      case SELECT_BY_CONDICIONES: {
          ps = this.selectByCondiciones(aCondiciones); 
          break; 
      }
      case SELECT_BY_TIPODOCU_NRO: {
          ps = this.selectByTipoDocuNro(aCondiciones); 
          break; 
      }
      case SELECT_BY_NRODOCU: {
          ps = this.selectByNroDocu(aCondiciones); 
          break; 
      }
      case SELECT_HELP_VISITA_CON_TARJ: {
          ps = this.selectByVisitaConTarj(aCondiciones); 
          break; 
      }
      case SELECT_BY_VISITAS_EN_PREDIO: {
          ps = this.selectByVisitasEnPredio(aCondiciones); 
          break; 
      }
    } 
    return ps;
  } 

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_VISITA = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  cipVisita "); 
    textSQL.append(" WHERE oid_visita = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_VISITA, oid); 
    return querySelect; 
  }
  
  private PreparedStatement selectByCondiciones(Object aCondiciones) throws BaseException, SQLException { 

	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM  cipVisita "); 
	    textSQL.append(" WHERE 1=1 ");
	    
	    HashTableDatos condiciones = (HashTableDatos) aCondiciones;
	    
	    // Filtrar por legajo
	    List legajos = (List) condiciones.get("LEGAJOS");
	    StringBuffer condOIDLegajo = new StringBuffer("");
	    if ((legajos!=null) && (legajos.size()>0)) {
	    	Iterator iterLegajos = legajos.iterator();
	    	while (iterLegajos.hasNext()) {
	    		Integer oidLegajo = (Integer) iterLegajos.next();
	    		if (condOIDLegajo.length()==0)
	    			condOIDLegajo.append(oidLegajo.toString());
	    		else
	    			condOIDLegajo.append(","+oidLegajo.toString());
	    	}
	    	textSQL.append(" and oid_legajo in ("+condOIDLegajo.toString()+") ");
	    }
	    
	    // Filtrar por Valores de clasificador
	    HashTableDatos hashTableClasif = new HashTableDatos();
	    List listaValClasif = (List) condiciones.get("VALORES_CLASIF");
	    if (listaValClasif!=null) {
	    	
	    	Iterator iterValClasif = listaValClasif.iterator();
	    	while (iterValClasif.hasNext()) {
	    		ValorClasificadorEntidad valClasifEnt = (ValorClasificadorEntidad) iterValClasif.next();
	    		HashTableDatos htValClasif = (HashTableDatos)hashTableClasif.get(valClasifEnt.getClasificador_entidad().getOIDInteger());
	    		if (htValClasif == null) {
	    			htValClasif  = new HashTableDatos();
	    			hashTableClasif.put(valClasifEnt.getClasificador_entidad().getOIDInteger(), htValClasif);
	    		}
	    		htValClasif.put(valClasifEnt.getOIDInteger(), valClasifEnt);
	    	}
	    	
	    	Iterator iterGrupoValClasif = 
	    		hashTableClasif.values().iterator();
	    	while (iterGrupoValClasif.hasNext()) {
	    		HashTableDatos datos = (HashTableDatos) iterGrupoValClasif.next();
	    		Iterator iterValClasif1 = datos.values().iterator();
	    		int j=1;
	    		while (iterValClasif1.hasNext()) {
	    			ValorClasificadorEntidad valClasifEnt = (ValorClasificadorEntidad) iterValClasif1.next();
	    			if (j==1)
	    				textSQL.append(" and (");
	    			else
	    				textSQL.append(" or ");
	    	    	textSQL.append(		
	     				   valClasifEnt.getClasificador_entidad().getCampoFisico()+
	     				   "="+
	     				   valClasifEnt.getOIDInteger());
	    	    	++j;
	    			
	    		}
	    		if (j>1) textSQL.append(" ) ");
	    	}
	    	
	    }
	    
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
	    return querySelect; 
  }
  
  private PreparedStatement selectByNroDocu(Object aCondiciones) throws BaseException, SQLException { 

	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM  cipVisita "); 
	    textSQL.append(" WHERE nro_documento = ? and activo = 1  ");
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
	    String nroDocumento = (String) aCondiciones;
	    querySelect.setString(1, nroDocumento);
	    
	    return querySelect; 
}   
  
  
  

  private PreparedStatement selectByTipoDocuNro(Object aCondiciones) throws BaseException, SQLException { 

	  	HashTableDatos condiciones = (HashTableDatos) aCondiciones;
	  	TipoDocumento tipoDocumento = (TipoDocumento) condiciones.get(TipoDocumento.NICKNAME);
	  	String nroDocumento = (String) condiciones.get("NRO_DOCUMENTO"); 
	  	
	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM  cipVisita "); 
	    textSQL.append(" WHERE oid_tipo_documento = ? and nro_documento = ? ");
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
	    querySelect.setInt(1, tipoDocumento.getOID());
	    querySelect.setString(2, nroDocumento);
	    
	    return querySelect; 
  }   
  
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  cipVisita "); 
    textSQL.append(" WHERE nro_documento = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }
  
  
  private PreparedStatement selectByVisitasEnPredio(Object aCondiciones) throws BaseException, SQLException {
	    StringBuffer textSQL = new StringBuffer();
	    textSQL.append("SELECT * FROM  cipVisita a , cipZona b "); 
	    textSQL.append(" WHERE a.oid_zona_actual = b.oid_zona and b.es_externa = 0 and a.activo = 1 and b.activo = 1  ");
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
	    return querySelect; 
  }
  
  private PreparedStatement selectByVisitaConTarj(Object aCondiciones) throws BaseException, SQLException {

	    StringBuffer textSQL = new StringBuffer();

	    textSQL.append("SELECT a.oid_visita oid,b.nro_tarjeta codigo, a.ape_y_nom descripcion ,a.activo ");
	    textSQL.append(" from cipVisita a, cipTarjetas b where a.oid_visita = b.oid_visita and a.activo=1 and b.activo=1 ");
	    
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
	    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_visita oid,nro_documento codigo, ape_y_nom descripcion ,activo ");
    textSQL.append(" from cipVisita");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  }
  
  public static List getLegajosByCondiciones(
		  List listaLegajos,
		  List valoresClasificadores,
          ISesion aSesion) throws BaseException {
	  HashTableDatos condiciones = new HashTableDatos();
	  if (listaLegajos!=null)
		  condiciones.put("LEGAJOS", listaLegajos);
	  if (valoresClasificadores!=null)
		  condiciones.put("VALORES_CLASIF", valoresClasificadores);
	  return (List) ObjetoLogico.getObjects(Legajo.NICKNAME,
             DBLegajo.SELECT_BY_CONDICIONES,
             condiciones,
             new ListObserver(),
             aSesion);
  }
  
  public static Visita getVisita(
		  TipoDocumento tipo,
		  String nroDocu,
          ISesion aSesion)
          throws BaseException {
	  HashTableDatos condiciones = new HashTableDatos();
	  condiciones.put(TipoDocumento.NICKNAME, tipo);
	  condiciones.put("NRO_DOCUMENTO", nroDocu);
	  return (Visita) ObjetoLogico.getObjects(Visita.NICKNAME,
			  				DBVisita.SELECT_BY_TIPODOCU_NRO,
			  				condiciones,
			  				new ObjetoObservado(),
			  				aSesion);
  }
  
  public static List getVisitasPorNroDocu(
		  String nroDocumento,
          ISesion aSesion) throws BaseException {
	  return (List) ObjetoLogico.getObjects(Visita.NICKNAME,
             DBVisita.SELECT_BY_NRODOCU,
             nroDocumento,
             new ListObserver(),
             aSesion);
  }
  
  public static List getVisitasEnPredio(
          ISesion aSesion) throws BaseException {
	  return (List) ObjetoLogico.getObjects(Visita.NICKNAME,
             DBVisita.SELECT_BY_VISITAS_EN_PREDIO,
             null,
             new ListObserver(),
             aSesion);
  }
  

  
  
  
} 
