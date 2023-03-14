package com.srn.erp.ventas.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;
import java.util.StringTokenizer;

import com.srn.erp.turnos.bm.CategoriaSujetoTurno;
import com.srn.erp.turnos.bm.TableroTurnos;
import com.srn.erp.ventas.bm.Sujeto;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.ObjetoObservado;

public class DBSujeto extends DBObjetoPersistente {

  public static final String OID_SUJETO = "oid_sujeto";
  public static final String CODIGO = "codigo";
  public static final String RAZON_SOCIAL = "razon_social";
  public static final String OID_TIPO_DOCUMENTO = "oid_tipo_documento";
  public static final String NRO_DOCUMENTO = "nro_documento";
  public static final String SEXO = "sexo";
  public static final String FEC_NAC = "fec_nac";
  public static final String FEC_INGRESO = "fec_ingreso";
  public static final String E_MAIL = "e_mail";
  public static final String NACIONALIDAD = "nacionalidad";
  public static final String TELEFONOS = "telefonos";
  public static final String OID_SUJ_IMP = "oid_suj_imp";
  public static final String FAX = "fax";
  public static final String SECTOR = "sector";
  public static final String CARGO = "cargo";
  public static final String OID_VEND_TEC = "oid_vend_tec";
  public static final String OID_VEND_COM = "oid_vend_com";
  public static final String WEB = "web";
  public static final String OID_EST_SITUACION = "oid_est_situacion";
  public static final String OID_ZONA = "oid_zona";
  public static final String FEC_EST_DESDE = "fec_est_desde";
  public static final String FEC_EST_HASTA = "fec_est_hasta";
  public static final String FISICA_JURIDICA = "fisica_juridica";
  public static final String PROFESION = "profesion";
  public static final String ES_CLIENTE = "es_cliente";
  public static final String ES_SOCIO = "es_socio";
  public static final String ES_PROSPECTO = "es_prospecto";
  public static final String ES_CONTACTO = "es_contacto";
  public static final String DIRECCION_WEB = "direccion_web";
  public static final String OID_COBRADOR = "oid_cobrador";
  public static final String OID_RUBRO = "oid_rubro";
  public static final String OID_ESTADO_CIVIL = "oid_estado_civil";
  public static final String CONTACTO = "contacto";
  public static final String CALLE_Y_NRO = "calle_y_nro";
  public static final String OID_SECTOR_DIR = "oid_sector_dir";
  public static final String LOCALIDAD = "localidad";
  public static final String CODIGO_POSTAL = "codigo_postal";
  public static final String OID_PROVINCIA = "oid_provincia";
  public static final String OID_PAIS = "oid_pais";
  public static final String DOM_ENTREGA = "dom_entrega";
  public static final String OID_ZONA_VTA = "oid_zona_vta";
  public static final String OID_CANAL = "oid_canal";
  public static final String OID_CLASIF_SUJETO = "oid_clasif_suj";
  public static final String OID_CTA_BANCARIA = "oid_cta_bancaria";
  public static final String OID_TAR_CREDITO = "oid_tar_credito";
  public static final String NRO_MEDIO_PAGO = "nro_medio_pago";
  public static final String OID_SUJ_RESP_CC = "oid_suj_resp_cc";
  public static final String MODA_PAGO = "moda_pago";
  public static final String PERMITE_OTRAS_MP = "permite_otras_mp";
  public static final String SUB_MODA_PAGO = "sub_moda_pago";
  public static final String COND_PAGO = "oid_cond_pago";
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
  public static final String BONIF_EN_CASCADA = "bonif_en_cascada";
  public static final String OID_TRANSPORTE = "oid_transporte";
  public static final String OID_MONEDA_COTIZACION = "oid_moneda_cotiz";
  public static final String OID_MONEDA_PEDIDO = "oid_moneda_pedido";
  public static final String OID_MONEDA_FACTURA = "oid_moneda_factura";
  public static final String OID_IDIOMA = "oid_idioma";
  public static final String RAZON_SOCIAL_SEARCH = "razon_social_search";
  public static final String HAB_LIM_CRE = "hab_lim_cre";
  public static final String MONTO_LIM_CRE = "monto_lim_cre";
  public static final String OID_MON_LIM_CRE = "oid_mon_lim_cre";
  public static final String ES_SUS_PERC_IB_BA = "es_sus_perc_ib_ba";
  public static final String ES_SUS_PERC_IB_CF = "es_sus_perc_ib_cf";
  public static final String ES_SUS_PERC_IVA = "es_sus_perc_iva";
  public static final String DOM_COBRANZA = "dom_cobranza";
  public static final String RECLAMAR_PAGO = "reclamar_pago";
  public static final String PASAR_A_COBRAR = "pasar_a_cobrar";
  public static final String OID_TURNO_CATEG = "oid_turno_categ";
  public static final String OID_TURNO_RELACION = "oid_turno_relacion";
  public static final String SUSPEND_PARA_TURNO = "suspend_para_turno";
  public static final String FEC_SUSP_DESDE = "fec_susp_desde";
  public static final String FEC_SUSP_HASTA = "fec_susp_hasta";
  public static final String MOTIVO_TURNO_SUSP = "motivo_turno_susp";
  public static final String NRO_TARJETA = "nro_tarjeta";
  public static final String TIPO_IMPRESION_FACT = "tipo_impresion_fact";
  
  public static final int SELECT_BY_HELP_CLIENTES = 100;
  public static final int SELECT_BY_CODIGO_CLIENTE = 101;
  public static final int SELECT_VAL_SUJETO        = 102;
  public static final int SELECT_BY_CODIGO_DESDE_HASTA = 103;
  public static final int SELECT_BY_HELP_CLIENTES_NO_INVI = 104;
  public static final int SELECT_BY_TABLERO_INVITADOS = 105;
  public static final int SELECT_BY_FEC_ING_INVITADOS = 106;
  public static final int SELECT_BY_NRO_TARJETA = 107;

  public DBSujeto() {
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

    final int OID_SUJETO = 1;
    final int CODIGO = 2;
    final int RAZON_SOCIAL = 3;
    final int OID_TIPO_DOCUMENTO = 4;
    final int NRO_DOCUMENTO = 5;
    final int SEXO = 6;
    final int FEC_NAC = 7;
    final int FEC_INGRESO = 8;
    final int E_MAIL = 9;
    final int NACIONALIDAD = 10;
    final int TELEFONOS = 11;
    final int OID_SUJ_IMP = 12;
    final int FAX = 13;
    final int SECTOR = 14;
    final int CARGO = 15;
    final int OID_VEND_TEC = 16;
    final int OID_VEND_COM = 17;
    final int WEB = 18;
    final int OID_EST_SITUACION = 19;
    final int OID_ZONA = 20;
    final int FEC_EST_DESDE = 21;
    final int FEC_EST_HASTA = 22;
    final int FISICA_JURIDICA = 23;
    final int PROFESION = 24;
    final int ES_CLIENTE = 25;
    final int ES_SOCIO = 26;
    final int DIRECCION_WEB = 27;
    final int OID_COBRADOR = 28;
    final int OID_RUBRO = 29;
    final int OID_ESTADO_CIVIL = 30;
    final int CONTACTO = 31;
    final int CALLE_Y_NRO = 32;
    final int OID_SECTOR_DIR = 33;
    final int LOCALIDAD = 34;
    final int CODIGO_POSTAL = 35;
    final int OID_PROVINCIA = 36;
    final int OID_PAIS = 37;
    final int DOM_ENTREGA = 38;
    final int OID_ZONA_VTA = 39;
    final int OID_CANAL = 40;
    final int OID_CLASIF_SUJETO = 41;
    final int OID_CTA_BANCARIA = 42;
    final int OID_TAR_CREDITO = 43;
    final int NRO_MEDIO_PAGO = 44;
    final int OID_SUJ_RESP_CC = 45;
    final int MODA_PAGO = 46;
    final int PERMITE_OTRAS_MP = 47;
    final int SUB_MODA_PAGO = 48;
    final int OID_COND_PAGO = 49;
    final int ACTIVO = 50;
    final int OID_CLASIF_01 = 51;
    final int OID_CLASIF_02 = 52;
    final int OID_CLASIF_03 = 53;
    final int OID_CLASIF_04 = 54;
    final int OID_CLASIF_05 = 55;
    final int OID_CLASIF_06 = 56;
    final int OID_CLASIF_07 = 57;
    final int OID_CLASIF_08 = 58;
    final int OID_CLASIF_09 = 59;
    final int OID_CLASIF_10 = 60;
    final int OID_CLASIF_11 = 61;
    final int OID_CLASIF_12 = 62;
    final int OID_CLASIF_13 = 63;
    final int OID_CLASIF_14 = 64;
    final int OID_CLASIF_15 = 65;
    final int OID_CLASIF_16 = 66;
    final int OID_CLASIF_17 = 67;
    final int OID_CLASIF_18 = 68;
    final int OID_CLASIF_19 = 69;
    final int OID_CLASIF_20 = 70;
    final int ES_CONTACTO = 71;
    final int ES_PROSPECTO = 72;
    final int BONIF_EN_CASCADA = 73;
    final int OID_TRANSPORTE = 74;
    final int OID_MONEDA_COTIZ = 75;
    final int OID_MONEDA_PEDIDO = 76;
    final int OID_MONEDA_FACTURA = 77;
    final int OID_IDIOMA = 78;
    final int RAZON_SOCIAL_SEARCH = 79;
    final int HAB_LIM_CRE = 80;
    final int MON_LIM_CRE = 81;
    final int OID_MON_LIM_CRE = 82;
    final int ES_SUS_PERC_IB_BA = 83;
    final int ES_SUS_PERC_IB_CF = 84;
    final int ES_SUS_PERC_IVA = 85;
    final int DOM_COBRANZA = 86;
    final int RECLAMAR_PAGO = 87;
    final int PASAR_A_COBRAR = 88;
    
    final int OID_TURNO_CATEG = 89;
    final int OID_TURNO_RELACION = 90;
    final int SUSPEND_PARA_TURNO = 91;
    final int FEC_SUSP_DESDE = 92;
    final int FEC_SUSP_HASTA = 93;
    final int MOTIVO_TURNO_SUSP = 94;
    final int NRO_TARJETA = 95;
    final int TIPO_IMPRESION_FACT = 96;


    Sujeto pers = (Sujeto) objetoPersistente;
    
    if ((pers.getCodigo()==null) || (pers.getCodigo().length()==0))
    	throw new ExceptionValidation(null,"Debe ingresar el código de cliente");
    
    

    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into veSujeto "+
                     " ( "+
                      "OID_SUJETO,"+
                      "CODIGO,"+
                      "RAZON_SOCIAL,"+
                      "OID_TIPO_DOCUMENTO,"+
                      "NRO_DOCUMENTO,"+
                      "SEXO,"+
                      "FEC_NAC,"+
                      "FEC_INGRESO,"+
                      "E_MAIL,"+
                      "NACIONALIDAD,"+
                      "TELEFONOS,"+
                      "OID_SUJ_IMP,"+
                      "FAX,"+
                      "SECTOR,"+
                      "CARGO,"+
                      "OID_VEND_TEC,"+
                      "OID_VEND_COM,"+
                      "WEB,"+
                      "OID_EST_SITUACION,"+
                      "OID_ZONA,"+
                      "FEC_EST_DESDE,"+
                      "FEC_EST_HASTA,"+
                      "FISICA_JURIDICA,"+
                      "PROFESION,"+
                      "ES_CLIENTE,"+
                      "ES_SOCIO,"+
                      "DIRECCION_WEB,"+
                      "OID_COBRADOR,"+
                      "OID_RUBRO,"+
                      "OID_ESTADO_CIVIL,"+
                      "CONTACTO,"+
                      "CALLE_Y_NRO,"+
                      "OID_SECTOR_DIR,"+
                      "LOCALIDAD,"+
                      "CODIGO_POSTAL,"+
                      "OID_PROVINCIA,"+
                      "OID_PAIS,"+
                      "DOM_ENTREGA,"+
                      "OID_ZONA_VTA,"+
                      "OID_CANAL,"+
                      "OID_CLASIF_SUJ,"+
                      "OID_CTA_BANCARIA,"+
                      "OID_TAR_CREDITO,"+
                      "NRO_MEDIO_PAGO,"+
                      "OID_SUJ_RESP_CC,"+
                      "MODA_PAGO,"+
                      "PERMITE_OTRAS_MP,"+
                      "SUB_MODA_PAGO,"+
                      "OID_COND_PAGO,"+
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
                      "OID_CLASIF_20,"+
                      "ES_CONTACTO,"+
                      "ES_PROSPECTO,"+
                      "BONIF_EN_CASCADA,"+
                      "OID_TRANSPORTE,"+
                      "OID_MONEDA_COTIZ,"+
                      "OID_MONEDA_PEDIDO,"+
                      "OID_MONEDA_FACTURA,"+
                      "OID_IDIOMA,"+
                      "RAZON_SOCIAL_SEARCH,"+
                      "HAB_LIM_CRE,"+
                      "MONTO_LIM_CRE,"+
                      "OID_MON_LIM_CRE,"+
                      "ES_SUS_PERC_IB_BA,"+
                      "ES_SUS_PERC_IB_CF,"+
                      "ES_SUS_PERC_IVA,"+
                      "DOM_COBRANZA,"+
                      "RECLAMAR_PAGO,"+
                      "PASAR_A_COBRAR,"+
                      "OID_TURNO_CATEG,"+
                      "OID_TURNO_RELACION,"+
                      "SUSPEND_PARA_TURNO,"+
                      "FEC_SUSP_DESDE,"+
                      "FEC_SUSP_HASTA,"+
                      "MOTIVO_TURNO_SUSP,NRO_TARJETA,TIPO_IMPRESION_FACT"+
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
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
    qInsert.setInt(OID_SUJETO,pers.getOID());
    
    qInsert.setString(CODIGO,pers.getCodigo());
    qInsert.setString(RAZON_SOCIAL,pers.getRazon_social());

    if (pers.getTipo_documento()!=null)
      qInsert.setInt(OID_TIPO_DOCUMENTO,pers.getTipo_documento().getOID());
    else
      qInsert.setNull(OID_TIPO_DOCUMENTO,java.sql.Types.INTEGER);

    if (pers.getNro_documento()!=null)
      qInsert.setString(NRO_DOCUMENTO,pers.getNro_documento().trim());
    else
      qInsert.setNull(NRO_DOCUMENTO,java.sql.Types.VARCHAR);

    if (pers.getSexo()!=null)
      qInsert.setString(SEXO,pers.getSexo());
    else
      qInsert.setNull(SEXO,java.sql.Types.VARCHAR);

    if (pers.getFecha_nacimiento()!=null)
      qInsert.setDate(FEC_NAC,new java.sql.Date(pers.getFecha_nacimiento().getTime()));
    else
      qInsert.setNull(FEC_NAC,java.sql.Types.DATE);

    if (pers.getFecha_ingreso()!=null)
      qInsert.setDate(FEC_INGRESO,new java.sql.Date(pers.getFecha_ingreso().getTime()));
    else
      qInsert.setNull(FEC_INGRESO,java.sql.Types.DATE);

    if (pers.getE_mail()!=null)
      qInsert.setString(E_MAIL,pers.getE_mail());
    else
      qInsert.setNull(E_MAIL,java.sql.Types.VARCHAR);

    if (pers.getNacionalidad()!=null)
      qInsert.setString(NACIONALIDAD,pers.getNacionalidad());
    else
      qInsert.setNull(NACIONALIDAD,java.sql.Types.VARCHAR);

    if (pers.getTelefonos()!=null)
      qInsert.setString(TELEFONOS,pers.getTelefonos());
    else
      qInsert.setNull(TELEFONOS,java.sql.Types.VARCHAR);

    if (pers.getSujeto_impositivo()!=null)
      qInsert.setInt(OID_SUJ_IMP,pers.getSujeto_impositivo().getOID());
    else
      qInsert.setNull(OID_SUJ_IMP,java.sql.Types.VARCHAR);

    if (pers.getFax()!=null)
      qInsert.setString(FAX,pers.getFax());
    else
      qInsert.setNull(FAX,java.sql.Types.VARCHAR);

    if (pers.getSector_empresa()!=null)
      qInsert.setString(SECTOR,pers.getSector_empresa());
    else
      qInsert.setNull(SECTOR,java.sql.Types.VARCHAR);

    if (pers.getCargo()!=null)
      qInsert.setString(CARGO,pers.getCargo());
    else
      qInsert.setNull(CARGO,java.sql.Types.VARCHAR);

    if (pers.getVendedor_tecnico()!=null)
      qInsert.setInt(OID_VEND_TEC,pers.getVendedor_tecnico().getOID());
    else
      qInsert.setNull(OID_VEND_TEC,java.sql.Types.INTEGER);

    if (pers.getVendedor_comercial()!=null)
      qInsert.setInt(OID_VEND_COM,pers.getVendedor_comercial().getOID());
    else
      qInsert.setNull(OID_VEND_COM,java.sql.Types.INTEGER);

    if (pers.getWeb()!=null)
      qInsert.setString(WEB,pers.getWeb());
    else
      qInsert.setNull(WEB,java.sql.Types.VARCHAR);

    if (pers.getEstado_situacion()!=null)
      qInsert.setInt(OID_EST_SITUACION,pers.getEstado_situacion().getOID());
    else
      qInsert.setNull(OID_EST_SITUACION,java.sql.Types.INTEGER);

    if (pers.getZonadireccion()!=null)
      qInsert.setInt(OID_ZONA,pers.getZonadireccion().getOID());
    else
      qInsert.setNull(OID_ZONA,java.sql.Types.INTEGER);

    if (pers.getFec_est_situ_desde()!=null)
      qInsert.setDate(FEC_EST_DESDE,new java.sql.Date(pers.getFec_est_situ_desde().getTime()));
    else
      qInsert.setNull(FEC_EST_DESDE,java.sql.Types.DATE);

    if (pers.getFec_est_situ_hasta()!=null)
      qInsert.setDate(FEC_EST_HASTA,new java.sql.Date(pers.getFec_est_situ_hasta().getTime()));
    else
      qInsert.setNull(FEC_EST_HASTA,java.sql.Types.DATE);

    if (pers.getFisica_juridica()!=null)
      qInsert.setString(FISICA_JURIDICA,pers.getFisica_juridica());
    else
      qInsert.setNull(FISICA_JURIDICA,java.sql.Types.VARCHAR);

    if (pers.getProfesion()!=null)
      qInsert.setString(PROFESION,pers.getProfesion());
    else
      qInsert.setNull(PROFESION,java.sql.Types.VARCHAR);

    if (pers.isEs_cliente()!=null)
      qInsert.setBoolean(ES_CLIENTE,pers.isEs_cliente().booleanValue());
    else
      qInsert.setNull(ES_CLIENTE,java.sql.Types.BOOLEAN);

    if (pers.isEs_socio()!=null)
      qInsert.setBoolean(ES_SOCIO,pers.isEs_socio().booleanValue());
    else
      qInsert.setNull(ES_SOCIO,java.sql.Types.BOOLEAN);

    if (pers.getDireccion_web()!=null)
      qInsert.setString(DIRECCION_WEB,pers.getDireccion_web());
    else
      qInsert.setNull(DIRECCION_WEB,java.sql.Types.VARCHAR);

    if (pers.getCobrador()!=null)
      qInsert.setInt(OID_COBRADOR,pers.getCobrador().getOID());
    else
      qInsert.setNull(OID_COBRADOR,java.sql.Types.INTEGER);

    if (pers.getRubro()!=null)
      qInsert.setInt(OID_RUBRO,pers.getRubro().getOID());
    else
      qInsert.setNull(OID_RUBRO,java.sql.Types.INTEGER);

    if (pers.getEstado_civil()!=null)
      qInsert.setInt(OID_ESTADO_CIVIL,pers.getEstado_civil().getOID());
    else
      qInsert.setNull(OID_ESTADO_CIVIL,java.sql.Types.INTEGER);

    if (pers.getContacto()!=null)
      qInsert.setString(CONTACTO,pers.getContacto());
    else
      qInsert.setNull(CONTACTO,java.sql.Types.VARCHAR);

    if (pers.getCalle_y_nro()!=null)
      qInsert.setString(CALLE_Y_NRO,pers.getCalle_y_nro());
    else
      qInsert.setNull(CALLE_Y_NRO,java.sql.Types.VARCHAR);

    if (pers.getSector_domilicio()!=null)
      qInsert.setInt(OID_SECTOR_DIR,pers.getSector_domilicio().getOID());
    else
      qInsert.setNull(OID_SECTOR_DIR,java.sql.Types.INTEGER);

    if (pers.getLocalidad()!=null)
      qInsert.setString(LOCALIDAD,pers.getLocalidad());
    else
      qInsert.setNull(LOCALIDAD,java.sql.Types.VARCHAR);

    if (pers.getCodigo_postal()!=null)
      qInsert.setString(CODIGO_POSTAL,pers.getCodigo_postal());
    else
      qInsert.setNull(CODIGO_POSTAL,java.sql.Types.VARCHAR);

    if (pers.getProvincia()!=null)
      qInsert.setInt(OID_PROVINCIA,pers.getProvincia().getOID());
    else
      qInsert.setNull(OID_PROVINCIA,java.sql.Types.INTEGER);

    if (pers.getPais()!=null)
      qInsert.setInt(OID_PAIS,pers.getPais().getOID());
    else
      qInsert.setNull(OID_PAIS,java.sql.Types.INTEGER);

    if (pers.isDomicilio_entrega()!=null)
      qInsert.setBoolean(DOM_ENTREGA,pers.isDomicilio_entrega().booleanValue());
    else
      qInsert.setNull(DOM_ENTREGA,java.sql.Types.BOOLEAN);

    if (pers.getZona_venta()!=null)
      qInsert.setInt(OID_ZONA_VTA,pers.getZona_venta().getOID());
    else
      qInsert.setNull(OID_ZONA_VTA,java.sql.Types.INTEGER);

    if (pers.getCanal()!=null)
      qInsert.setInt(OID_CANAL,pers.getCanal().getOID());
    else
      qInsert.setNull(OID_CANAL,java.sql.Types.INTEGER);

    if (pers.getClasificacionsujeto()!=null)
      qInsert.setInt(OID_CLASIF_SUJETO,pers.getClasificacionsujeto().getOID());
    else
      qInsert.setNull(OID_CLASIF_SUJETO,java.sql.Types.INTEGER);

    if (pers.getCuenta_bancaria()!=null)
      qInsert.setInt(OID_CTA_BANCARIA,pers.getCuenta_bancaria().getOID());
    else
      qInsert.setNull(OID_CTA_BANCARIA,java.sql.Types.INTEGER);

    if (pers.getTarjeta_credito()!=null)
      qInsert.setInt(OID_TAR_CREDITO,pers.getTarjeta_credito().getOID());
    else
      qInsert.setNull(OID_TAR_CREDITO,java.sql.Types.INTEGER);

    if (pers.getNro_medio_pago()!=null)
      qInsert.setString(NRO_MEDIO_PAGO,pers.getNro_medio_pago());
    else
      qInsert.setNull(NRO_MEDIO_PAGO,java.sql.Types.VARCHAR);

    if (pers.getResponsable_ctacte()!=null)
      qInsert.setInt(OID_SUJ_RESP_CC,pers.getResponsable_ctacte().intValue());
    else
      qInsert.setNull(OID_SUJ_RESP_CC,java.sql.Types.INTEGER);

    if (pers.getModalidad_pago()!=null)
      qInsert.setString(MODA_PAGO,pers.getModalidad_pago());
    else
      qInsert.setNull(MODA_PAGO,java.sql.Types.VARCHAR);

    if (pers.isPermite_otras_modalidades_pago()!=null)
      qInsert.setBoolean(PERMITE_OTRAS_MP,pers.isPermite_otras_modalidades_pago().booleanValue());
    else
      qInsert.setNull(PERMITE_OTRAS_MP,java.sql.Types.BOOLEAN);

    if (pers.getSub_modalidad_pago()!=null)
      qInsert.setString(SUB_MODA_PAGO,pers.getSub_modalidad_pago());
    else
      qInsert.setNull(SUB_MODA_PAGO,java.sql.Types.VARCHAR);

    if (pers.getCondicionPago()!=null)
      qInsert.setInt(OID_COND_PAGO,pers.getCondicionPago().getOID());
    else
      qInsert.setNull(OID_COND_PAGO,java.sql.Types.INTEGER);

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
    if (pers.isEs_prospecto()!=null)
    	qInsert.setBoolean(ES_PROSPECTO,pers.isEs_prospecto().booleanValue());
    else
    	qInsert.setBoolean(ES_PROSPECTO,false);
    if (pers.isEs_contacto()!=null)
    	qInsert.setBoolean(ES_CONTACTO,pers.isEs_contacto().booleanValue());
    else
    	qInsert.setBoolean(ES_CONTACTO,false);
    if (pers.isBonifEnCascada()!=null)
    	qInsert.setBoolean(BONIF_EN_CASCADA,pers.isBonifEnCascada().booleanValue());
    else
    	qInsert.setNull(BONIF_EN_CASCADA,Types.BOOLEAN);
    
    if (pers.getTransporte()!=null)
    	qInsert.setInt(OID_TRANSPORTE,pers.getTransporte().getOID());
    else
    	qInsert.setNull(OID_TRANSPORTE,java.sql.Types.INTEGER);
    
    if (pers.getMonedaCotizacion()!=null)
    	qInsert.setInt(OID_MONEDA_COTIZ,pers.getMonedaCotizacion().getOID());
    else
    	qInsert.setNull(OID_MONEDA_COTIZ,Types.INTEGER);
    
    if (pers.getMonedaPedido()!=null)
    	qInsert.setInt(OID_MONEDA_PEDIDO,pers.getMonedaPedido().getOID());
    else
    	qInsert.setNull(OID_MONEDA_PEDIDO,Types.INTEGER);
    
    if (pers.getMonedaFactura()!=null)
    	qInsert.setInt(OID_MONEDA_FACTURA,pers.getMonedaFactura().getOID());
    else
    	qInsert.setNull(OID_MONEDA_FACTURA,Types.INTEGER);
    
    if (pers.getIdioma()!=null)
    	qInsert.setInt(OID_IDIOMA,pers.getIdioma().getOID());
    else
    	qInsert.setNull(OID_IDIOMA,Types.INTEGER);
    
    if (pers.getRazon_social_search()!=null)
    	qInsert.setString(RAZON_SOCIAL_SEARCH,pers.getRazon_social_search());
    else
    	qInsert.setNull(RAZON_SOCIAL_SEARCH,Types.VARCHAR);
    
    if (pers.isHabilitarLimiteCredito()!=null)
    	qInsert.setBoolean(HAB_LIM_CRE,pers.isHabilitarLimiteCredito().booleanValue());
    else
    	qInsert.setBoolean(HAB_LIM_CRE,false);
    
    if (pers.getMontoLimiteCredito()!=null)
    	qInsert.setDouble(MON_LIM_CRE,pers.getMontoLimiteCredito().doubleValue());
    else
    	qInsert.setDouble(MON_LIM_CRE,0);
    
    if (pers.getMonedaLimiteCredito()!=null)
    	qInsert.setDouble(OID_MON_LIM_CRE,pers.getMonedaLimiteCredito().getOID());
    else
    	qInsert.setNull(OID_MON_LIM_CRE,Types.INTEGER);
    
    qInsert.setBoolean(ES_SUS_PERC_IB_BA,pers.isSusceptiblePercIBBsAs());
    qInsert.setBoolean(ES_SUS_PERC_IB_CF,pers.isSusceptiblePercIBCapFed());
    qInsert.setBoolean(ES_SUS_PERC_IVA, pers.isSusceptiblePercIVA());
    
    if (pers.isDomicilioCobraza()!=null)
    	qInsert.setBoolean(DOM_COBRANZA, pers.isDomicilioCobraza().booleanValue());
    else
    	qInsert.setBoolean(DOM_COBRANZA, new Boolean(false));
    
    if (pers.getReclamarPagos()!=null)
    	qInsert.setString(RECLAMAR_PAGO, pers.getReclamarPagos());
    else
    	qInsert.setNull(RECLAMAR_PAGO, java.sql.Types.VARCHAR);
    
    if (pers.getPasarACobrar()!=null)
    	qInsert.setString(PASAR_A_COBRAR, pers.getPasarACobrar());
    else
    	qInsert.setNull(PASAR_A_COBRAR, java.sql.Types.VARCHAR);
    
    if (pers.getCategoriaSujetoTurno()!=null)
    	qInsert.setInt(OID_TURNO_CATEG, pers.getCategoriaSujetoTurno().getOID());
    else
    	qInsert.setNull(OID_TURNO_CATEG, java.sql.Types.INTEGER);
    
    if (pers.getRelacionSujetoTurno()!=null)
    	qInsert.setInt(OID_TURNO_RELACION, pers.getRelacionSujetoTurno().getOID());
    else
    	qInsert.setNull(OID_TURNO_RELACION, java.sql.Types.INTEGER);
    
    qInsert.setBoolean(SUSPEND_PARA_TURNO, pers.isSuspendidoParaTurno());
    
    if (pers.getFecSuspendidoDesde()!=null)
    	qInsert.setDate(FEC_SUSP_DESDE, new java.sql.Date(pers.getFecSuspendidoDesde().getTime()));
    else
    	qInsert.setNull(FEC_SUSP_DESDE, java.sql.Types.DATE);
    
    if (pers.getFecSuspendidoHasta()!=null)
    	qInsert.setDate(FEC_SUSP_HASTA, new java.sql.Date(pers.getFecSuspendidoHasta().getTime()));
    else
    	qInsert.setNull(FEC_SUSP_HASTA, java.sql.Types.DATE);
    
    if (pers.getMotivoTurnoSuspension()!=null)
    	qInsert.setString(MOTIVO_TURNO_SUSP, pers.getMotivoTurnoSuspension());
    else
    	qInsert.setNull(MOTIVO_TURNO_SUSP, java.sql.Types.VARCHAR);
    
    if (pers.getNroTarjeta()!=null)
        qInsert.setString(NRO_TARJETA,pers.getNroTarjeta());
      else
        qInsert.setNull(NRO_TARJETA,java.sql.Types.VARCHAR);
    
    if (pers.getTipoImpresionFact()!=null)
    	qInsert.setString(TIPO_IMPRESION_FACT, pers.getTipoImpresionFact());
    else
    	qInsert.setNull(TIPO_IMPRESION_FACT, Types.VARCHAR);
    
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {


    final int CODIGO = 1;
    final int RAZON_SOCIAL = 2;
    final int OID_TIPO_DOCUMENTO = 3;
    final int NRO_DOCUMENTO = 4;
    final int SEXO = 5;
    final int FEC_NAC = 6;
    final int FEC_INGRESO = 7;
    final int E_MAIL = 8;
    final int NACIONALIDAD = 9;
    final int TELEFONOS = 10;
    final int OID_SUJ_IMP = 11;
    final int FAX = 12;
    final int SECTOR = 13;
    final int CARGO = 14;
    final int OID_VEND_TEC = 15;
    final int OID_VEND_COM = 16;
    final int WEB = 17;
    final int OID_EST_SITUACION = 18;
    final int OID_ZONA = 19;
    final int FEC_EST_DESDE = 20;
    final int FEC_EST_HASTA = 21;
    final int FISICA_JURIDICA = 22;
    final int PROFESION = 23;
    final int ES_CLIENTE = 24;
    final int ES_SOCIO = 25;
    final int DIRECCION_WEB = 26;
    final int OID_COBRADOR = 27;
    final int OID_RUBRO = 28;
    final int OID_ESTADO_CIVIL = 29;
    final int CONTACTO = 30;
    final int CALLE_Y_NRO = 31;
    final int OID_SECTOR_DIR = 32;
    final int LOCALIDAD = 33;
    final int CODIGO_POSTAL = 34;
    final int OID_PROVINCIA = 35;
    final int OID_PAIS = 36;
    final int DOM_ENTREGA = 37;
    final int OID_ZONA_VTA = 38;
    final int OID_CANAL = 39;
    final int OID_CLASIF_SUJETO = 40;
    final int OID_CTA_BANCARIA = 41;
    final int OID_TAR_CREDITO = 42;
    final int NRO_MEDIO_PAGO = 43;
    final int OID_SUJ_RESP_CC = 44;
    final int MODA_PAGO = 45;
    final int PERMITE_OTRAS_MP = 46;
    final int SUB_MODA_PAGO = 47;
    final int OID_COND_PAGO = 48;
    final int ACTIVO = 49;
    final int OID_CLASIF_01 = 50;
    final int OID_CLASIF_02 = 51;
    final int OID_CLASIF_03 = 52;
    final int OID_CLASIF_04 = 53;
    final int OID_CLASIF_05 = 54;
    final int OID_CLASIF_06 = 55;
    final int OID_CLASIF_07 = 56;
    final int OID_CLASIF_08 = 57;
    final int OID_CLASIF_09 = 58;
    final int OID_CLASIF_10 = 59;
    final int OID_CLASIF_11 = 60;
    final int OID_CLASIF_12 = 61;
    final int OID_CLASIF_13 = 62;
    final int OID_CLASIF_14 = 63;
    final int OID_CLASIF_15 = 64;
    final int OID_CLASIF_16 = 65;
    final int OID_CLASIF_17 = 66;
    final int OID_CLASIF_18 = 67;
    final int OID_CLASIF_19 = 68;
    final int OID_CLASIF_20 = 69;    
    final int ES_PROSPECTO = 70;
    final int ES_CONTACTO = 71;    
    final int BONIF_EN_CASCADA = 72;
    final int OID_TRANSPORTE = 73;
    final int OID_MONEDA_COTIZ = 74;
    final int OID_MONEDA_PEDIDO = 75;
    final int OID_MONEDA_FACTURA = 76;
    final int OID_IDIOMA = 77;
    final int RAZON_SOCIAL_SEARCH = 78;
    final int HAB_LIM_CRE = 79;
    final int MON_LIM_CRE = 80;
    final int OID_MON_LIM_CRE = 81;    
    final int ES_SUS_PERC_IB_BA = 82;
    final int ES_SUS_PERC_IB_CF = 83;
    final int ES_SUS_PERC_IVA = 84;
    final int DOM_COBRANZA = 85;
    final int RECLAMAR_PAGO = 86;
    final int PASAR_A_COBRAR = 87;
    final int OID_TURNO_CATEG = 88;
    final int OID_TURNO_RELACION = 89;
    final int SUSPEND_PARA_TURNO = 90;
    final int FEC_SUSP_DESDE = 91;
    final int FEC_SUSP_HASTA = 92;
    final int MOTIVO_TURNO_SUSP = 93;
    final int NRO_TARJETA = 94;
    final int TIPO_IMPRESION_FACT = 95;
    final int OID_SUJETO = 96;


    Sujeto pers = (Sujeto) objetoPersistente;
    
    if ((pers.getCodigo()==null) || (pers.getCodigo().length()==0))
    	throw new ExceptionValidation(null,"Debe ingresar el código de cliente");
    

    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" update veSujeto set "+
                      "CODIGO = ?,"+
                      "RAZON_SOCIAL = ?,"+
                      "OID_TIPO_DOCUMENTO = ?,"+
                      "NRO_DOCUMENTO = ?,"+
                      "SEXO = ?,"+
                      "FEC_NAC = ?,"+
                      "FEC_INGRESO = ?,"+
                      "E_MAIL = ?,"+
                      "NACIONALIDAD = ?,"+
                      "TELEFONOS = ?,"+
                      "OID_SUJ_IMP = ?,"+
                      "FAX = ?,"+
                      "SECTOR = ?,"+
                      "CARGO = ?,"+
                      "OID_VEND_TEC = ?,"+
                      "OID_VEND_COM = ?,"+
                      "WEB = ?,"+
                      "OID_EST_SITUACION = ?,"+
                      "OID_ZONA = ?,"+
                      "FEC_EST_DESDE = ?,"+
                      "FEC_EST_HASTA = ?,"+
                      "FISICA_JURIDICA = ?,"+
                      "PROFESION = ?,"+
                      "ES_CLIENTE = ?,"+
                      "ES_SOCIO = ?,"+
                      "DIRECCION_WEB = ?,"+
                      "OID_COBRADOR = ?,"+
                      "OID_RUBRO = ?,"+
                      "OID_ESTADO_CIVIL = ?,"+
                      "CONTACTO = ?,"+
                      "CALLE_Y_NRO = ?,"+
                      "OID_SECTOR_DIR = ?,"+
                      "LOCALIDAD = ?,"+
                      "CODIGO_POSTAL = ?,"+
                      "OID_PROVINCIA = ?,"+
                      "OID_PAIS = ?,"+
                      "DOM_ENTREGA = ?,"+
                      "OID_ZONA_VTA = ?,"+
                      "OID_CANAL = ?,"+
                      "OID_CLASIF_SUJ = ?,"+
                      "OID_CTA_BANCARIA = ?,"+
                      "OID_TAR_CREDITO = ?,"+
                      "NRO_MEDIO_PAGO = ?,"+
                      "OID_SUJ_RESP_CC = ?,"+
                      "MODA_PAGO = ?,"+
                      "PERMITE_OTRAS_MP = ?,"+
                      "SUB_MODA_PAGO = ?,"+
                      "OID_COND_PAGO = ?,"+
                      "ACTIVO = ?,"+
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
                      "es_prospecto = ?, "+
                      "es_contacto = ?, "+   
                      "bonif_en_cascada = ?, "+
                      "oid_transporte = ?, "+                      
                      "oid_moneda_cotiz = ?, "+
                      "oid_moneda_pedido = ?, "+
                      "oid_moneda_factura = ?, "+
                      "oid_idioma = ? ,"+
                      "razon_social_search = ?, "+
                      "hab_lim_cre=?,"+
                      "monto_lim_cre=?,"+
                      "oid_mon_lim_cre=?,"+
                      "es_sus_perc_ib_ba=?,"+
                      "es_sus_perc_ib_cf=?, "+
                      "es_sus_perc_iva=?, "+
                      "dom_cobranza=?, "+
                      "reclamar_pago=?, "+
                      "pasar_a_cobrar=?, "+                      
                      "oid_turno_categ=?, "+
                      "oid_turno_relacion=?, "+
                      "suspend_para_turno=?, "+
                      "fec_susp_desde=?, "+
                      "fec_susp_hasta=?, "+
                      "motivo_turno_susp=?, "+
                      "nro_tarjeta=? , tipo_impresion_fact = ? "+
                      " WHERE OID_SUJETO =? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
    qUpdate.setInt(OID_SUJETO,pers.getOID());
    qUpdate.setString(CODIGO,pers.getCodigo());
    qUpdate.setString(RAZON_SOCIAL,pers.getRazon_social());

    if (pers.getTipo_documento()!=null)
      qUpdate.setInt(OID_TIPO_DOCUMENTO,pers.getTipo_documento().getOID());
    else
      qUpdate.setNull(OID_TIPO_DOCUMENTO,java.sql.Types.INTEGER);

    if (pers.getNro_documento()!=null)
      qUpdate.setString(NRO_DOCUMENTO,pers.getNro_documento().trim());
    else
      qUpdate.setNull(NRO_DOCUMENTO,java.sql.Types.VARCHAR);

    if (pers.getSexo()!=null)
      qUpdate.setString(SEXO,pers.getSexo());
    else
      qUpdate.setNull(SEXO,java.sql.Types.VARCHAR);

    if (pers.getFecha_nacimiento()!=null)
      qUpdate.setDate(FEC_NAC,new java.sql.Date(pers.getFecha_nacimiento().getTime()));
    else
      qUpdate.setNull(FEC_NAC,java.sql.Types.DATE);

    if (pers.getFecha_ingreso()!=null)
      qUpdate.setDate(FEC_INGRESO,new java.sql.Date(pers.getFecha_ingreso().getTime()));
    else
      qUpdate.setNull(FEC_INGRESO,java.sql.Types.DATE);

    if (pers.getE_mail()!=null)
      qUpdate.setString(E_MAIL,pers.getE_mail());
    else
      qUpdate.setNull(E_MAIL,java.sql.Types.VARCHAR);

    if (pers.getNacionalidad()!=null)
      qUpdate.setString(NACIONALIDAD,pers.getNacionalidad());
    else
      qUpdate.setNull(NACIONALIDAD,java.sql.Types.VARCHAR);

    if (pers.getTelefonos()!=null)
      qUpdate.setString(TELEFONOS,pers.getTelefonos());
    else
      qUpdate.setNull(TELEFONOS,java.sql.Types.VARCHAR);

    if (pers.getSujeto_impositivo()!=null)
      qUpdate.setInt(OID_SUJ_IMP,pers.getSujeto_impositivo().getOID());
    else
      qUpdate.setNull(OID_SUJ_IMP,java.sql.Types.VARCHAR);

    if (pers.getFax()!=null)
      qUpdate.setString(FAX,pers.getFax());
    else
      qUpdate.setNull(FAX,java.sql.Types.VARCHAR);

    if (pers.getSector_empresa()!=null)
      qUpdate.setString(SECTOR,pers.getSector_empresa());
    else
      qUpdate.setNull(SECTOR,java.sql.Types.VARCHAR);

    if (pers.getCargo()!=null)
      qUpdate.setString(CARGO,pers.getCargo());
    else
      qUpdate.setNull(CARGO,java.sql.Types.VARCHAR);

    if (pers.getVendedor_tecnico()!=null)
      qUpdate.setInt(OID_VEND_TEC,pers.getVendedor_tecnico().getOID());
    else
      qUpdate.setNull(OID_VEND_TEC,java.sql.Types.INTEGER);

    if (pers.getVendedor_comercial()!=null)
      qUpdate.setInt(OID_VEND_COM,pers.getVendedor_comercial().getOID());
    else
      qUpdate.setNull(OID_VEND_COM,java.sql.Types.INTEGER);

    if (pers.getWeb()!=null)
      qUpdate.setString(WEB,pers.getWeb());
    else
      qUpdate.setNull(WEB,java.sql.Types.VARCHAR);

    if (pers.getEstado_situacion()!=null)
      qUpdate.setInt(OID_EST_SITUACION,pers.getEstado_situacion().getOID());
    else
      qUpdate.setNull(OID_EST_SITUACION,java.sql.Types.INTEGER);

    if (pers.getZonadireccion()!=null)
      qUpdate.setInt(OID_ZONA,pers.getZonadireccion().getOID());
    else
      qUpdate.setNull(OID_ZONA,java.sql.Types.INTEGER);

    if (pers.getFec_est_situ_desde()!=null)
      qUpdate.setDate(FEC_EST_DESDE,new java.sql.Date(pers.getFec_est_situ_desde().getTime()));
    else
      qUpdate.setNull(FEC_EST_DESDE,java.sql.Types.DATE);

    if (pers.getFec_est_situ_hasta()!=null)
      qUpdate.setDate(FEC_EST_HASTA,new java.sql.Date(pers.getFec_est_situ_hasta().getTime()));
    else
      qUpdate.setNull(FEC_EST_HASTA,java.sql.Types.DATE);

    if (pers.getFisica_juridica()!=null)
      qUpdate.setString(FISICA_JURIDICA,pers.getFisica_juridica());
    else
      qUpdate.setNull(FISICA_JURIDICA,java.sql.Types.VARCHAR);

    if (pers.getProfesion()!=null)
      qUpdate.setString(PROFESION,pers.getProfesion());
    else
      qUpdate.setNull(PROFESION,java.sql.Types.VARCHAR);

    if (pers.isEs_cliente()!=null)
      qUpdate.setBoolean(ES_CLIENTE,pers.isEs_cliente().booleanValue());
    else
      qUpdate.setNull(ES_CLIENTE,java.sql.Types.BOOLEAN);

    if (pers.isEs_socio()!=null)
      qUpdate.setBoolean(ES_SOCIO,pers.isEs_socio().booleanValue());
    else
      qUpdate.setNull(ES_SOCIO,java.sql.Types.BOOLEAN);

    if (pers.getDireccion_web()!=null)
      qUpdate.setString(DIRECCION_WEB,pers.getDireccion_web());
    else
      qUpdate.setNull(DIRECCION_WEB,java.sql.Types.VARCHAR);

    if (pers.getCobrador()!=null)
      qUpdate.setInt(OID_COBRADOR,pers.getCobrador().getOID());
    else
      qUpdate.setNull(OID_COBRADOR,java.sql.Types.INTEGER);

    if (pers.getRubro()!=null)
      qUpdate.setInt(OID_RUBRO,pers.getRubro().getOID());
    else
      qUpdate.setNull(OID_RUBRO,java.sql.Types.INTEGER);

    if (pers.getEstado_civil()!=null)
      qUpdate.setInt(OID_ESTADO_CIVIL,pers.getEstado_civil().getOID());
    else
      qUpdate.setNull(OID_ESTADO_CIVIL,java.sql.Types.INTEGER);

    if (pers.getContacto()!=null)
      qUpdate.setString(CONTACTO,pers.getContacto());
    else
      qUpdate.setNull(CONTACTO,java.sql.Types.VARCHAR);

    if (pers.getCalle_y_nro()!=null)
      qUpdate.setString(CALLE_Y_NRO,pers.getCalle_y_nro());
    else
      qUpdate.setNull(CALLE_Y_NRO,java.sql.Types.VARCHAR);

    if (pers.getSector_domilicio()!=null)
      qUpdate.setInt(OID_SECTOR_DIR,pers.getSector_domilicio().getOID());
    else
      qUpdate.setNull(OID_SECTOR_DIR,java.sql.Types.INTEGER);

    if (pers.getLocalidad()!=null)
      qUpdate.setString(LOCALIDAD,pers.getLocalidad());
    else
      qUpdate.setNull(LOCALIDAD,java.sql.Types.VARCHAR);

    if (pers.getCodigo_postal()!=null)
      qUpdate.setString(CODIGO_POSTAL,pers.getCodigo_postal());
    else
      qUpdate.setNull(CODIGO_POSTAL,java.sql.Types.VARCHAR);

    if (pers.getProvincia()!=null)
      qUpdate.setInt(OID_PROVINCIA,pers.getProvincia().getOID());
    else
      qUpdate.setNull(OID_PROVINCIA,java.sql.Types.INTEGER);

    if (pers.getPais()!=null)
      qUpdate.setInt(OID_PAIS,pers.getPais().getOID());
    else
      qUpdate.setNull(OID_PAIS,java.sql.Types.INTEGER);

    if (pers.isDomicilio_entrega()!=null)
      qUpdate.setBoolean(DOM_ENTREGA,pers.isDomicilio_entrega().booleanValue());
    else
      qUpdate.setNull(DOM_ENTREGA,java.sql.Types.BOOLEAN);

    if (pers.getZona_venta()!=null)
      qUpdate.setInt(OID_ZONA_VTA,pers.getZona_venta().getOID());
    else
      qUpdate.setNull(OID_ZONA_VTA,java.sql.Types.INTEGER);

    if (pers.getCanal()!=null)
      qUpdate.setInt(OID_CANAL,pers.getCanal().getOID());
    else
      qUpdate.setNull(OID_CANAL,java.sql.Types.INTEGER);

    if (pers.getClasificacionsujeto()!=null)
      qUpdate.setInt(OID_CLASIF_SUJETO,pers.getClasificacionsujeto().getOID());
    else
      qUpdate.setNull(OID_CLASIF_SUJETO,java.sql.Types.INTEGER);

    if (pers.getCuenta_bancaria()!=null)
      qUpdate.setInt(OID_CTA_BANCARIA,pers.getCuenta_bancaria().getOID());
    else
      qUpdate.setNull(OID_CTA_BANCARIA,java.sql.Types.INTEGER);

    if (pers.getTarjeta_credito()!=null)
      qUpdate.setInt(OID_TAR_CREDITO,pers.getTarjeta_credito().getOID());
    else
      qUpdate.setNull(OID_TAR_CREDITO,java.sql.Types.INTEGER);

    if (pers.getNro_medio_pago()!=null)
      qUpdate.setString(NRO_MEDIO_PAGO,pers.getNro_medio_pago());
    else
      qUpdate.setNull(NRO_MEDIO_PAGO,java.sql.Types.VARCHAR);

    if (pers.getResponsable_ctacte()!=null)
      qUpdate.setInt(OID_SUJ_RESP_CC,pers.getResponsable_ctacte().intValue());
    else
      qUpdate.setNull(OID_SUJ_RESP_CC,java.sql.Types.INTEGER);

    if (pers.getModalidad_pago()!=null)
      qUpdate.setString(MODA_PAGO,pers.getModalidad_pago());
    else
      qUpdate.setNull(MODA_PAGO,java.sql.Types.VARCHAR);

    if (pers.isPermite_otras_modalidades_pago()!=null)
      qUpdate.setBoolean(PERMITE_OTRAS_MP,pers.isPermite_otras_modalidades_pago().booleanValue());
    else
      qUpdate.setNull(PERMITE_OTRAS_MP,java.sql.Types.BOOLEAN);

    if (pers.getSub_modalidad_pago()!=null)
      qUpdate.setString(SUB_MODA_PAGO,pers.getSub_modalidad_pago());
    else
      qUpdate.setNull(SUB_MODA_PAGO,java.sql.Types.VARCHAR);

    if (pers.getCondicionPago()!=null)
      qUpdate.setInt(OID_COND_PAGO,pers.getCondicionPago().getOID());
    else
      qUpdate.setNull(OID_COND_PAGO,java.sql.Types.INTEGER);

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
    if (pers.isEs_prospecto()!=null)
    	qUpdate.setBoolean(ES_PROSPECTO,pers.isEs_prospecto().booleanValue());
    else
    	qUpdate.setBoolean(ES_PROSPECTO,false);
    if (pers.isEs_contacto()!=null)
    	qUpdate.setBoolean(ES_CONTACTO,pers.isEs_contacto().booleanValue());
    else
    	qUpdate.setBoolean(ES_CONTACTO,false);
    if (pers.isBonifEnCascada()!=null)
    	qUpdate.setBoolean(BONIF_EN_CASCADA,pers.isBonifEnCascada().booleanValue());
    else
    	qUpdate.setNull(BONIF_EN_CASCADA,Types.BOOLEAN);
    
    if (pers.getTransporte()!=null)
      qUpdate.setInt(OID_TRANSPORTE,pers.getTransporte().getOID());
    else
      qUpdate.setNull(OID_TRANSPORTE,java.sql.Types.INTEGER);

    if (pers.getMonedaCotizacion()!=null)
    	qUpdate.setInt(OID_MONEDA_COTIZ,pers.getMonedaCotizacion().getOID());
    else
    	qUpdate.setNull(OID_MONEDA_COTIZ,Types.INTEGER);
    
    if (pers.getMonedaPedido()!=null)
    	qUpdate.setInt(OID_MONEDA_PEDIDO,pers.getMonedaPedido().getOID());
    else
    	qUpdate.setNull(OID_MONEDA_PEDIDO,Types.INTEGER);
    
    if (pers.getMonedaFactura()!=null)
    	qUpdate.setInt(OID_MONEDA_FACTURA,pers.getMonedaFactura().getOID());
    else
    	qUpdate.setNull(OID_MONEDA_FACTURA,Types.INTEGER);
    
    if (pers.getIdioma()!=null)
    	qUpdate.setInt(OID_IDIOMA,pers.getIdioma().getOID());
    else
    	qUpdate.setNull(OID_IDIOMA,Types.INTEGER);
    
    if (pers.getRazon_social_search()!=null)
    	qUpdate.setString(RAZON_SOCIAL_SEARCH,pers.getRazon_social_search());
    else
    	qUpdate.setNull(RAZON_SOCIAL_SEARCH,Types.VARCHAR);

    if (pers.isHabilitarLimiteCredito()!=null)
    	qUpdate.setBoolean(HAB_LIM_CRE,pers.isHabilitarLimiteCredito().booleanValue());
    else
    	qUpdate.setBoolean(HAB_LIM_CRE,false);
    
    if (pers.getMontoLimiteCredito()!=null)
    	qUpdate.setDouble(MON_LIM_CRE,pers.getMontoLimiteCredito().doubleValue());
    else
    	qUpdate.setDouble(MON_LIM_CRE,0);
    
    if (pers.getMonedaLimiteCredito()!=null)
    	qUpdate.setInt(OID_MON_LIM_CRE,pers.getMonedaLimiteCredito().getOID());
    else
    	qUpdate.setNull(OID_MON_LIM_CRE,Types.INTEGER);
    
    qUpdate.setBoolean(ES_SUS_PERC_IB_BA,pers.isSusceptiblePercIBBsAs());
    qUpdate.setBoolean(ES_SUS_PERC_IB_CF,pers.isSusceptiblePercIBCapFed());
    qUpdate.setBoolean(ES_SUS_PERC_IVA, pers.isSusceptiblePercIVA());    

    if (pers.isDomicilioCobraza()!=null)
    	qUpdate.setBoolean(DOM_COBRANZA, pers.isDomicilioCobraza().booleanValue());
    else
    	qUpdate.setBoolean(DOM_COBRANZA, new Boolean(false));
    
    if (pers.getReclamarPagos()!=null)
    	qUpdate.setString(RECLAMAR_PAGO, pers.getReclamarPagos());
    else
    	qUpdate.setNull(RECLAMAR_PAGO, java.sql.Types.VARCHAR);
    
    if (pers.getPasarACobrar()!=null)
    	qUpdate.setString(PASAR_A_COBRAR, pers.getPasarACobrar());
    else
    	qUpdate.setNull(PASAR_A_COBRAR, java.sql.Types.VARCHAR);
    
    if (pers.getCategoriaSujetoTurno()!=null)
    	qUpdate.setInt(OID_TURNO_CATEG, pers.getCategoriaSujetoTurno().getOID());
    else
    	qUpdate.setNull(OID_TURNO_CATEG, java.sql.Types.INTEGER);
    
    if (pers.getRelacionSujetoTurno()!=null)
    	qUpdate.setInt(OID_TURNO_RELACION, pers.getRelacionSujetoTurno().getOID());
    else
    	qUpdate.setNull(OID_TURNO_RELACION, java.sql.Types.INTEGER);
    
    qUpdate.setBoolean(SUSPEND_PARA_TURNO, pers.isSuspendidoParaTurno());
    
    if (pers.getFecSuspendidoDesde()!=null)
    	qUpdate.setDate(FEC_SUSP_DESDE, new java.sql.Date(pers.getFecSuspendidoDesde().getTime()));
    else
    	qUpdate.setNull(FEC_SUSP_DESDE, java.sql.Types.DATE);
    
    if (pers.getFecSuspendidoHasta()!=null)
    	qUpdate.setDate(FEC_SUSP_HASTA, new java.sql.Date(pers.getFecSuspendidoHasta().getTime()));
    else
    	qUpdate.setNull(FEC_SUSP_HASTA, java.sql.Types.DATE);
    
    if (pers.getMotivoTurnoSuspension()!=null)
    	qUpdate.setString(MOTIVO_TURNO_SUSP, pers.getMotivoTurnoSuspension());
    else
    	qUpdate.setNull(MOTIVO_TURNO_SUSP, java.sql.Types.VARCHAR);    
    
    if (pers.getNroTarjeta()!=null)
    	qUpdate.setString(NRO_TARJETA,pers.getNroTarjeta());
      else
    	qUpdate.setNull(NRO_TARJETA,java.sql.Types.VARCHAR);
    
    if (pers.getTipoImpresionFact()!=null)
    	qUpdate.setString(TIPO_IMPRESION_FACT, pers.getTipoImpresionFact());
    else
    	qUpdate.setNull(TIPO_IMPRESION_FACT, Types.VARCHAR);
    
    
    qUpdate.executeUpdate();
    qUpdate.close();

  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    final int OID_SUJETO = 1;
    Sujeto pers = (Sujeto) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("update veSujeto "+
                     " set activo=0 " +
                     " where " +
                     " oid_sujeto=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_SUJETO, pers.getOID());
    qUpdate.executeUpdate();
    qUpdate.close();
  }

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    final int OID_SUJETO = 1;
    Sujeto pers = (Sujeto) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("update veSujeto "+
                     " set activo=1 " +
                     " where " +
                     " oid_sujeto=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_SUJETO, pers.getOID());
    qUpdate.executeUpdate();
    qUpdate.close();
  }

  public PreparedStatement prepararSelect(int aSelect, Object aCondiciones) throws BaseException, SQLException {
    PreparedStatement ps = null;
    switch (aSelect) {
      case IDBObjetoPersistente.SELECT_ALL: {
        ps = this.selectAll(aCondiciones);
        break;
      }
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
      case SELECT_BY_HELP_CLIENTES_NO_INVI: {
          ps = this.selectAllHelpNoInvitados(aCondiciones);
          break;
      }
      case SELECT_BY_HELP_CLIENTES: {
        ps = this.selectByHelpClientes(aCondiciones);
        break;
      }
      case SELECT_BY_CODIGO_CLIENTE: {
        ps = this.selectByCodigoCliente(aCondiciones);
        break;
      }
      case SELECT_VAL_SUJETO: {
    	  ps = this.selectByValidadorSujeto(aCondiciones);
          break;    	  
      }
      case SELECT_BY_CODIGO_DESDE_HASTA: {
    	ps = this.selectByCodigoDesdeHasta(aCondiciones);
        break;    	  
      }
      case SELECT_BY_TABLERO_INVITADOS: {
      	ps = this.selectByTableroInvitados(aCondiciones);
        break;    	  
      }
      case SELECT_BY_FEC_ING_INVITADOS: {
        	ps = this.selectByFecIngInvitados(aCondiciones);
            break;    	  
      }
      case SELECT_BY_NRO_TARJETA: {
      	ps = this.selectByNroTarjeta(aCondiciones);
        break;    	  
      }
    }
    return ps;
  }

  private PreparedStatement selectAll(Object aCondiciones) throws BaseException, SQLException {
    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  veSujeto ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    return querySelect;
  }


  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

    final int OID_SUJETO = 1;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  veSujeto ");
    textSQL.append(" WHERE oid_sujeto = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    int oid = ( (Integer) aCondiciones).intValue();
    querySelect.setInt(OID_SUJETO, oid);
    return querySelect;
  }
  
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

	final int CODIGO = 1;

	StringBuffer textSQL = new StringBuffer();
	textSQL.append("SELECT * FROM  veSujeto ");
	textSQL.append(" WHERE codigo = ? ");
	PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
	String codigo = (String) aCondiciones;
	querySelect.setString(CODIGO, codigo);
	return querySelect;
  }
  
  
  private PreparedStatement selectByNroTarjeta(Object aCondiciones) throws BaseException, SQLException {

	    String nroTarjeta = (String) aCondiciones;
	    StringBuffer textSQL = new StringBuffer();
	    textSQL.append("SELECT * FROM  veSujeto ");
	    textSQL.append(" WHERE nro_tarjeta = ? ");

	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
	    querySelect.setString(1, nroTarjeta);
	    return querySelect;
}

  
  private PreparedStatement selectByFecIngInvitados(Object aCondiciones) throws BaseException, SQLException {

	    java.util.Date fecha = (java.util.Date) aCondiciones;
	    StringBuffer textSQL = new StringBuffer();
	    textSQL.append("SELECT * FROM  veSujeto ");
	    textSQL.append(" WHERE fec_ingreso = ? and oid_turno_categ = ? ");
	    
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
	    querySelect.setDate(1, new java.sql.Date(fecha.getTime()));
	    querySelect.setInt(2, CategoriaSujetoTurno.getCategSujTurnoInvitado(this.getSesion()).getOID());
	    return querySelect;
  }
  
  private PreparedStatement selectByTableroInvitados(Object aCondiciones) throws BaseException, SQLException {

    final int CODIGO = 1;

    HashTableDatos condiciones = (HashTableDatos) aCondiciones;
    TableroTurnos tablero = (TableroTurnos) condiciones.get(TableroTurnos.NICKNAME); 
    	
    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  veSujeto ");
    textSQL.append(" WHERE ");
    textSQL.append(" oid_sujeto in (select oid_sujeto_1 from tuReservaTablero where oid_tablero_cab="+tablero.getOIDInteger()+" and invitado_1=1) ");
    textSQL.append(" or ");
    textSQL.append(" oid_sujeto in (select oid_sujeto_2 from tuReservaTablero where oid_tablero_cab="+tablero.getOIDInteger()+" and invitado_2=1) ");
    textSQL.append(" or ");
    textSQL.append(" oid_sujeto in (select oid_sujeto_3 from tuReservaTablero where oid_tablero_cab="+tablero.getOIDInteger()+" and invitado_3=1) ");
    textSQL.append(" or ");
    textSQL.append(" oid_sujeto in (select oid_sujeto_4 from tuReservaTablero where oid_tablero_cab="+tablero.getOIDInteger()+" and invitado_4=1) ");    
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    return querySelect;
  }
  
  private PreparedStatement selectByCodigoDesdeHasta(Object aCondiciones) throws BaseException, SQLException {
    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT max(codigo) max_codigo FROM  veSujeto ");
    textSQL.append(" WHERE codigo >= ? and codigo <= ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    HashTableDatos condiciones = (HashTableDatos) aCondiciones;
    String codigoDesde = (String) condiciones.get("CODIGO_DESDE");
    String codigoHasta = (String) condiciones.get("CODIGO_HASTA");
    querySelect.setString(1, codigoDesde);
    querySelect.setString(2, codigoHasta);
    return querySelect;
  }
  
  private PreparedStatement selectByCodigoCliente(Object aCondiciones) throws BaseException, SQLException {

    final int CODIGO = 1;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  veSujeto ");
    textSQL.append(" WHERE es_cliente=1 and codigo = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    String codigo = (String) aCondiciones;
    querySelect.setString(CODIGO, codigo);
    return querySelect;

  }


  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_sujeto oid,codigo codigo, razon_social descripcion ,activo ");
    textSQL.append(" from veSujeto");

    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    return querySelect;
  }
  
  private PreparedStatement selectAllHelpNoInvitados(Object aCondiciones) throws BaseException, SQLException {

	    StringBuffer textSQL = new StringBuffer();
	    textSQL.append("SELECT oid_sujeto oid,codigo codigo, razon_social descripcion ,activo ");
	    textSQL.append(" from veSujeto where oid_turno_categ<> "+CategoriaSujetoTurno.getCategSujTurnoInvitado(this.getSesion()).getOIDInteger());

	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
	    return querySelect;
	  }
  
  
  private PreparedStatement selectByValidadorSujeto(Object aCondiciones) throws BaseException, SQLException {
	    String codigo = (String) aCondiciones;
	    StringBuffer textSQL = new StringBuffer();
	    textSQL.append("SELECT * FROM  veSujeto ");
	    textSQL.append(" where 1=1 and codigo = ? ");	    
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
	    querySelect.setString(1,codigo);
	    return querySelect;	  
  }

  private PreparedStatement selectByHelpClientes(Object aCondiciones) throws BaseException, SQLException {

    HashTableDatos condiciones = (HashTableDatos) aCondiciones;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT a.* FROM  veSujeto a ");
    if (condiciones.containsKey("cuit"))
      textSQL.append(" ,imSujetoImpositivo b ");
    textSQL.append(" where 1=1 ");
    if (condiciones.containsKey("cuit"))
      textSQL.append(" and a.oid_suj_imp = b.oid_suj_imp and b.cuit like '%"+condiciones.getString("cuit")+"%'");
    if (condiciones.containsKey("codigo"))
      textSQL.append(" and a.codigo like '%"+condiciones.getString("codigo")+"%' ");
    if (condiciones.containsKey("razon_social")) {
    	
    	if ((condiciones.containsKey("tipo_busc_socio")) && (condiciones.getInteger("tipo_busc_socio").intValue()==2)) 
    		textSQL.append(" and a.razon_social_search>='"+condiciones.getString("razon_social").toUpperCase()+"' and a.razon_social_search<='"+condiciones.getString("razon_social").toUpperCase()+"ZZZZZZZZZZZ' ");
    	else {
    	
    		StringTokenizer st =  new StringTokenizer(condiciones.getString("razon_social"), " ");
    		while(st.hasMoreTokens()){
    			String next = st.nextToken().toUpperCase();
    			textSQL.append(" and a.razon_social_search like '%"+next+"%' ");
    		}
    		
    	}        
        
    }
    
    if (condiciones.containsKey("CATEG_INVITADO")) {
    	textSQL.append(" and a.oid_turno_categ="+CategoriaSujetoTurno.getCategSujTurnoInvitado(this.getSesion()).getOID());
    }
    	
    
    
    StringBuffer filtroTipoPers = new StringBuffer();
    
    
    if (condiciones.containsKey("cliente")) {
    	if (filtroTipoPers.length()>0) filtroTipoPers.append(" or ");
    	filtroTipoPers.append(" a.es_cliente = 1 ");
    }	
    if (condiciones.containsKey("prospecto")) {
    	if (filtroTipoPers.length()>0) filtroTipoPers.append(" or ");
    	filtroTipoPers.append(" a.es_prospecto = 1 ");
    }
    if (condiciones.containsKey("contacto")) {
    	if (filtroTipoPers.length()>0) filtroTipoPers.append(" or ");
    	filtroTipoPers.append(" a.es_contacto = 1 ");
    }
    if (condiciones.containsKey("socio")) {
    	if (filtroTipoPers.length()>0) filtroTipoPers.append(" or ");
    	filtroTipoPers.append(" a.es_socio = 1 ");
    }
    
    if (filtroTipoPers.length()>0) {
    	textSQL.append(" and (");
    	textSQL.append(filtroTipoPers);
    	textSQL.append(")");
    }
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    return querySelect;

  }

  public static List getHelpClientes(HashTableDatos condiciones,
                                     ISesion aSesion) throws BaseException {
    return (List) ObjetoLogico.getObjects(Sujeto.NICKNAME,
                                          DBSujeto.SELECT_BY_HELP_CLIENTES,
                                          condiciones,
                                          new ListObserver(),
                                          aSesion);
  }
  
  public static List getSujetosInvitadosTablero(TableroTurnos tablero,
          ISesion aSesion) throws BaseException {
	  HashTableDatos condiciones = new HashTableDatos();
	  condiciones.put(TableroTurnos.NICKNAME, tablero);
	  return (List) ObjetoLogico.getObjects(Sujeto.NICKNAME,
               DBSujeto.SELECT_BY_TABLERO_INVITADOS,
               condiciones,
               new ListObserver(),
               aSesion);
  }
  
  public static List getSujetosInvitadosConFecIng(java.util.Date fecha,
          ISesion aSesion) throws BaseException {
	  return (List) ObjetoLogico.getObjects(Sujeto.NICKNAME,
               DBSujeto.SELECT_BY_FEC_ING_INVITADOS,
               fecha,
               new ListObserver(),
               aSesion);
  }
  
  

  public static Sujeto getSujetoByCodigo(String aCodigo,
          								 ISesion aSesion)
          throws BaseException {
	  return (Sujeto) Sujeto.getObjects(Sujeto.NICKNAME,
			  DBSujeto.SELECT_VAL_SUJETO,
			  aCodigo,
			  new ObjetoObservado(),
			  aSesion);
  }
  
  public static Sujeto getSujetoByNroTarjeta(String aNroTarjeta,
			 ISesion aSesion)
  throws BaseException {
	  return (Sujeto) Sujeto.getObjects(Sujeto.NICKNAME,
			  DBSujeto.SELECT_BY_NRO_TARJETA,
			  aNroTarjeta,
			  new ObjetoObservado(),
			  aSesion);
  }
  
  
  public static String getProxCodCliente(ISesion sesion) throws BaseException  {

    try {

        Integer nroDesde = Sujeto.getNroDesdeCliente(sesion);
        Integer nroHasta = Sujeto.getNroHastaCliente(sesion);
        
        // Obtener la maxima cantidad de caracteres del codigo
        Integer maxCantCarac = Sujeto.getMaximaCantCaracteresCodClie(sesion);
        
        StringBuffer formatoNumero = new StringBuffer("");
        for (int i=1;i<=maxCantCarac.intValue();++i)
        	formatoNumero.append("0");
        
        NumberFormat formatCodigoDesde = new DecimalFormat(formatoNumero.toString());
        String codigoNroDesde = formatCodigoDesde.format(nroDesde);
        
        NumberFormat formatCodigoHasta = new DecimalFormat(formatoNumero.toString());
        String codigoNroHasta = formatCodigoHasta.format(nroHasta);
        
        HashTableDatos condiciones = new HashTableDatos();
        condiciones.put("CODIGO_DESDE",codigoNroDesde);
        condiciones.put("CODIGO_HASTA",codigoNroHasta);
        
        java.sql.ResultSet rs = null;
        
        StringBuffer textSQL = new StringBuffer();
        textSQL.append("SELECT max(codigo) max_codigo FROM  veSujeto ");
        textSQL.append(" WHERE codigo >= ? and codigo <= ? ");
        PreparedStatement ps = sesion.getConexionBD().prepareStatement(textSQL.toString());
        String codigoDesde = (String) condiciones.get("CODIGO_DESDE");
        String codigoHasta = (String) condiciones.get("CODIGO_HASTA");
        ps.setString(1, codigoDesde);
        ps.setString(2, codigoHasta);
        
        rs = ps.executeQuery();

        String maxCodigo = "";
        while (rs.next()) {
        	maxCodigo = rs.getString("max_codigo");
        }
        
        String nuevoCodigo = null;
        if ((maxCodigo==null) || (maxCodigo.length() == 0))
        	nuevoCodigo = formatCodigoDesde.format(nroDesde);
        else {
        	
        	boolean salir = false;
        	Integer nroCliente = new Integer(maxCodigo);
        	
        	while (salir==false) {
        		
          	nuevoCodigo = formatCodigoDesde.format(nroCliente.intValue()+1);
          	
          	// Verificar que no existe un cliente con ese codigo
          	Sujeto existeSujeto = Sujeto.findByCodigo(nuevoCodigo,sesion);
          	if (existeSujeto == null)
          		salir = true;
          	else
          		nroCliente = new Integer(nroCliente.intValue()+1);
          	
          	// Si no se pudo encontrar un rango dispoible en rango disparar un mensaje
          	if (nroCliente.intValue()+1>nroHasta.intValue()) 
          		throw new ExceptionValidation(null,"No se pudo dar de alta un código automática de cliente debido a que "+
          				                               "se alcanzo el máximo Nro. "+nroHasta.toString());
          	
        	}
        	
        }
        
        ps.close();
        rs.close();
        rs = null;
        ps = null;
        
        
        return nuevoCodigo;
        
    }
        catch (SQLException ex) {
          throw new BaseException(null,ex.getMessage());
    }
  }
  

}
