package com.srn.erp.compras.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import com.srn.erp.compras.bm.Proveedor;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;

public class DBProveedor extends DBObjetoPersistente {

  public static final String OID_PROVEEDOR = "oid_proveedor";
  public static final String CODIGO = "codigo";
  public static final String RAZON_SOCIAL = "razon_social";
  public static final String DIRECCION = "direccion";
  public static final String LOCALIDAD = "localidad";
  public static final String CODIGO_POSTAL = "codigo_postal";
  public static final String OID_PROVINCIA = "oid_provincia";
  public static final String HABITUAL = "habitual";
  public static final String ORDENCHEQUE = "ordencheque";
  public static final String ENV_OC_MAIL = "env_oc_mail";
  public static final String ENV_OC_CORREO = "env_oc_correo";
  public static final String ENV_OC_FAX = "env_oc_fax";
  public static final String OID_CERT_PROV = "oid_cert_prov";
  public static final String OID_MONEDA_OC = "oid_moneda_oc";
  public static final String OID_PAIS = "oid_pais";
  public static final String OID_IDIOMA = "oid_idioma";
  public static final String OID_SUJ_IMP = "oid_suj_imp";
  public static final String ACTIVO = "activo";
  public static final String FECHA_INHA = "fecha_inha";
  public static final String FORMA_PAGO = "oid_forma_pago";
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
  public static final String TOMAR_PRECIO_OC = "tomar_precio_oc";
  public static final String PERM_CAMBIAR_TP = "perm_cambiar_tp";
  public static final String OID_VIA_DESPACHO = "oid_via_despacho";
  public static final String OID_COND_COMPRA_IMPO = "oid_cond_comp_imp";
  public static final String DTO_EN_CASCADA = "dto_en_cascada";
  public static final String OID_TIPO_DOCU = "oid_tipo_docu";
  public static final String TOMAR_PRECIO_OC_1 = "tomar_precio_oc_1";
  public static final String TOMAR_PRECIO_OC_2 = "tomar_precio_oc_2";
  public static final String TOMAR_PRECIO_OC_3 = "tomar_precio_oc_3";
  public static final String TOMAR_PRECIO_OC_4 = "tomar_precio_oc_4";
  public static final String TOMAR_PRECIO_OC_5 = "tomar_precio_oc_5";
  public static final String PERMITIR_RECEP_PROD_SIN_OC = "inf_rec_sin_oc";
  public static final String DOM_DEV_MERC = "dom_dev_merca";


  public static final int SELECT_BY_HELP_PROVEEDOR = 100;

  public DBProveedor() {
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

    final int OID_PROVEEDOR = 1;
    final int CODIGO = 2;
    final int RAZON_SOCIAL = 3;
    final int DIRECCION = 4;
    final int LOCALIDAD = 5;
    final int CODIGO_POSTAL = 6;
    final int OID_PROVINCIA = 7;
    final int HABITUAL = 8;
    final int ORDENCHEQUE = 9;
    final int ENV_OC_MAIL = 10;
    final int ENV_OC_CORREO = 11;
    final int ENV_OC_FAX = 12;
    final int OID_CERT_PROV = 13;
    final int OID_MONEDA_OC = 14;
    final int OID_PAIS = 15;
    final int OID_IDIOMA = 16;
    final int OID_SUJ_IMP = 17;
    final int FECHA_INHA = 18;
    final int FORMA_PAGO = 19;
    final int ACTIVO = 20;
    final int OID_CLASIF_01 = 21;
    final int OID_CLASIF_02 = 22;
    final int OID_CLASIF_03 = 23;
    final int OID_CLASIF_04 = 24;
    final int OID_CLASIF_05 = 25;
    final int OID_CLASIF_06 = 26;
    final int OID_CLASIF_07 = 27;
    final int OID_CLASIF_08 = 28;
    final int OID_CLASIF_09 = 29;
    final int OID_CLASIF_10 = 30;
    final int OID_CLASIF_11 = 31;
    final int OID_CLASIF_12 = 32;
    final int OID_CLASIF_13 = 33;
    final int OID_CLASIF_14 = 34;
    final int OID_CLASIF_15 = 35;
    final int OID_CLASIF_16 = 36;
    final int OID_CLASIF_17 = 37;
    final int OID_CLASIF_18 = 38;
    final int OID_CLASIF_19 = 39;
    final int OID_CLASIF_20 = 40;
    final int TOMAR_PRECIO_OC = 41;
    final int PERMITIR_CAMBIAR_TP = 42;
    final int VIA_DESPACHO = 43;
    final int COND_COMPRA_IMP = 44;
    final int DTO_EN_CASCADA = 45;
    final int OID_TIPO_DOCU = 46;
    final int TOMAR_PRECIO_OC_1 = 47;
    final int TOMAR_PRECIO_OC_2 = 48;
    final int TOMAR_PRECIO_OC_3 = 49;
    final int TOMAR_PRECIO_OC_4 = 50;
    final int TOMAR_PRECIO_OC_5 = 51;
    final int PERM_RECEP_PROD_SIN_OC = 52;
    final int DOM_DEV_MERC = 53;

    Proveedor pers = (Proveedor) objetoPersistente;

    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into cpProveedores "+
                     " ( "+
                      "OID_PROVEEDOR,"+
                      "CODIGO,"+
                      "RAZON_SOCIAL,"+
                      "DIRECCION,"+
                      "LOCALIDAD,"+
                      "CODIGO_POSTAL,"+
                      "OID_PROVINCIA,"+
                      "HABITUAL,"+
                      "ORDENCHEQUE,"+
                      "ENV_OC_MAIL,"+
                      "ENV_OC_CORREO,"+
                      "ENV_OC_FAX,"+
                      "OID_CERT_PROV,"+
                      "OID_MONEDA_OC,"+
                      "OID_PAIS,"+
                      "OID_IDIOMA,"+
                      "OID_SUJ_IMP,"+
                      "FECHA_INHA,"+
                      "OID_FORMA_PAGO,"+
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
                      "TOMAR_PRECIO_OC,"+
                      "PERM_CAMBIAR_TP,"+
                      "OID_VIA_DESPACHO,"+
                      "OID_COND_COMP_IMP,"+
                      "DTO_EN_CASCADA,"+
                      "OID_TIPO_DOCU,"+
                      "TOMAR_PRECIO_OC_1,"+
                      "TOMAR_PRECIO_OC_2,"+
                      "TOMAR_PRECIO_OC_3,"+
                      "TOMAR_PRECIO_OC_4,"+
                      "TOMAR_PRECIO_OC_5,"+
                      "INF_REC_SIN_OC,DOM_DEV_MERCA"+
                      ") "+
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
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
    qInsert.setInt(OID_PROVEEDOR,pers.getOID());
    qInsert.setString(CODIGO,pers.getCodigo());
    qInsert.setString(RAZON_SOCIAL,pers.getRazonsocial());
    qInsert.setString(DIRECCION,pers.getDireccion());
    qInsert.setString(LOCALIDAD,pers.getLocalidad());
    qInsert.setString(CODIGO_POSTAL,pers.getCodigopostal());

    if (pers.getProvincia()!=null)
      qInsert.setInt(OID_PROVINCIA,pers.getProvincia().getOID());
    else
      qInsert.setNull(OID_PROVINCIA,java.sql.Types.INTEGER);

    qInsert.setBoolean(HABITUAL,pers.isHabitual().booleanValue());
    qInsert.setString(ORDENCHEQUE,pers.getOrdencheque());
    if (pers.isEnvocmail()!=null)
    	qInsert.setBoolean(ENV_OC_MAIL,pers.isEnvocmail().booleanValue());
    else
    	qInsert.setBoolean(ENV_OC_MAIL,false);
    if (pers.isEncoccorreo()!=null)
    	qInsert.setBoolean(ENV_OC_CORREO,pers.isEncoccorreo().booleanValue());
    else
    	qInsert.setBoolean(ENV_OC_CORREO,false);
    
    if (pers.isEncocfax()!=null)
    	qInsert.setBoolean(ENV_OC_FAX,pers.isEncocfax().booleanValue());
    else
    	qInsert.setBoolean(ENV_OC_FAX,false);

    if (pers.getCertprov()!=null)
      qInsert.setInt(OID_CERT_PROV,pers.getCertprov().getOID());
    else
      qInsert.setNull(OID_CERT_PROV,java.sql.Types.INTEGER);

    if (pers.getMonedaoc()!=null)
      qInsert.setInt(OID_MONEDA_OC,pers.getMonedaoc().getOID());
    else
      qInsert.setNull(OID_MONEDA_OC,java.sql.Types.INTEGER);

    if (pers.getPais()!=null)
      qInsert.setInt(OID_PAIS,pers.getPais().getOID());
    else
      qInsert.setNull(OID_PAIS,java.sql.Types.INTEGER);

    if (pers.getIdioma()!=null)
      qInsert.setInt(OID_IDIOMA,pers.getIdioma().getOID());
    else
      qInsert.setNull(OID_IDIOMA,java.sql.Types.INTEGER);

    if (pers.getSujetoimpositivo()!=null)
      qInsert.setInt(OID_SUJ_IMP,pers.getSujetoimpositivo().getOID());
    else
      qInsert.setNull(OID_SUJ_IMP,java.sql.Types.INTEGER);

    if (pers.getFechainhabilitacion()!=null)
      qInsert.setDate(FECHA_INHA,new java.sql.Date(pers.getFechainhabilitacion().getTime()));
    else
      qInsert.setNull(FECHA_INHA,java.sql.Types.DATE);

    if (pers.getFormaPago()!=null)
      qInsert.setInt(FORMA_PAGO,pers.getFormaPago().getOID());
    else
      qInsert.setNull(FORMA_PAGO,java.sql.Types.INTEGER);

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

    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    if (pers.getTomarPrecioOC()!=null)
    	qInsert.setString(TOMAR_PRECIO_OC,pers.getTomarPrecioOC());
    else
    	qInsert.setNull(TOMAR_PRECIO_OC,Types.VARCHAR);
    if (pers.isPermitirCambioTomarPrecioOC()!=null)
    	qInsert.setBoolean(PERMITIR_CAMBIAR_TP,pers.isPermitirCambioTomarPrecioOC().booleanValue());
    else
    	qInsert.setBoolean(PERMITIR_CAMBIAR_TP,false);
    if (pers.getViaDespacho()!=null)
    	qInsert.setInt(VIA_DESPACHO,pers.getViaDespacho().getOID());
    else
    	qInsert.setNull(VIA_DESPACHO,Types.INTEGER);
    if (pers.getCondCompraImpo()!=null)
    	qInsert.setInt(COND_COMPRA_IMP,pers.getCondCompraImpo().getOID());
    else
    	qInsert.setNull(COND_COMPRA_IMP,Types.INTEGER);
    if (pers.isDtoEnCascada()!=null)
    	qInsert.setBoolean(DTO_EN_CASCADA,pers.isDtoEnCascada().booleanValue());
    else
    	qInsert.setBoolean(DTO_EN_CASCADA,false);
    if (pers.getTipoDocumento()!=null)
    	qInsert.setInt(OID_TIPO_DOCU,pers.getTipoDocumento().getOID());
    else
    	qInsert.setNull(OID_TIPO_DOCU,Types.INTEGER);
    
   if (pers.getTomarPrecioOC1()!=null)
	   qInsert.setString(TOMAR_PRECIO_OC_1, pers.getTomarPrecioOC1());
   else
	   qInsert.setNull(TOMAR_PRECIO_OC_1, java.sql.Types.VARCHAR);
   
   if (pers.getTomarPrecioOC2()!=null)
	   qInsert.setString(TOMAR_PRECIO_OC_2, pers.getTomarPrecioOC2());
   else
	   qInsert.setNull(TOMAR_PRECIO_OC_2, java.sql.Types.VARCHAR);
   
   if (pers.getTomarPrecioOC3()!=null)
	   qInsert.setString(TOMAR_PRECIO_OC_3, pers.getTomarPrecioOC3());
   else
	   qInsert.setNull(TOMAR_PRECIO_OC_3, java.sql.Types.VARCHAR);
   
   if (pers.getTomarPrecioOC4()!=null)
	   qInsert.setString(TOMAR_PRECIO_OC_4, pers.getTomarPrecioOC4());
   else
	   qInsert.setNull(TOMAR_PRECIO_OC_4, java.sql.Types.VARCHAR);
   
   if (pers.getTomarPrecioOC5()!=null)
	   qInsert.setString(TOMAR_PRECIO_OC_5, pers.getTomarPrecioOC5());
   else
	   qInsert.setNull(TOMAR_PRECIO_OC_5, java.sql.Types.VARCHAR);
   
   if (pers.isPermitirRecepProdSinOC()!=null)
	   qInsert.setBoolean(PERM_RECEP_PROD_SIN_OC, pers.isPermitirRecepProdSinOC());
   else
	   qInsert.setNull(PERM_RECEP_PROD_SIN_OC, java.sql.Types.BOOLEAN);
   
   if (pers.isDomicilioDevolucionMerc()!=null)
	   qInsert.setBoolean(DOM_DEV_MERC, pers.isDomicilioDevolucionMerc().booleanValue());
   else
	   qInsert.setNull(DOM_DEV_MERC, java.sql.Types.BOOLEAN);
   
    
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

    final int CODIGO = 1;
    final int RAZON_SOCIAL = 2;
    final int DIRECCION = 3;
    final int LOCALIDAD = 4;
    final int CODIGO_POSTAL = 5;
    final int OID_PROVINCIA = 6;
    final int HABITUAL = 7;
    final int ORDENCHEQUE = 8;
    final int ENV_OC_MAIL = 9;
    final int ENV_OC_CORREO = 10;
    final int ENV_OC_FAX = 11;
    final int OID_CERT_PROV = 12;
    final int OID_MONEDA_OC = 13;
    final int OID_PAIS = 14;
    final int OID_IDIOMA = 15;
    final int OID_SUJ_IMP = 16;
    final int FECHA_INHA = 17;
    final int FORMA_PAGO = 18;
    final int ACTIVO = 19;
    final int OID_CLASIF_01 = 20;
    final int OID_CLASIF_02 = 21;
    final int OID_CLASIF_03 = 22;
    final int OID_CLASIF_04 = 23;
    final int OID_CLASIF_05 = 24;
    final int OID_CLASIF_06 = 25;
    final int OID_CLASIF_07 = 26;
    final int OID_CLASIF_08 = 27;
    final int OID_CLASIF_09 = 28;
    final int OID_CLASIF_10 = 29;
    final int OID_CLASIF_11 = 30;
    final int OID_CLASIF_12 = 31;
    final int OID_CLASIF_13 = 32;
    final int OID_CLASIF_14 = 33;
    final int OID_CLASIF_15 = 34;
    final int OID_CLASIF_16 = 35;
    final int OID_CLASIF_17 = 36;
    final int OID_CLASIF_18 = 37;
    final int OID_CLASIF_19 = 38;
    final int OID_CLASIF_20 = 39;
    final int TOMAR_PRECIO_OC = 40;
    final int PERMITIR_CAMBIAR_TP = 41;
    final int VIA_DESPACHO = 42;
    final int COND_COMPRA_IMP = 43;
    final int DTO_EN_CASCADA = 44;
    final int OID_TIPO_DOCU = 45;
    final int TOMAR_PRECIO_OC_1 = 46;
    final int TOMAR_PRECIO_OC_2 = 47;
    final int TOMAR_PRECIO_OC_3 = 48;
    final int TOMAR_PRECIO_OC_4 = 49;
    final int TOMAR_PRECIO_OC_5 = 50;
    final int PERM_RECEP_PROD_SIN_OC = 51;
    final int DOM_DEV_MERC = 52;
    final int OID_PROVEEDOR = 53;


    Proveedor pers = (Proveedor) objetoPersistente;

    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update cpProveedores set "+
              "codigo=?"+
              ",razon_social=?"+
              ",direccion=?"+
              ",localidad=?"+
              ",codigo_postal=?"+
              ",oid_provincia=?"+
              ",habitual=?"+
              ",ordencheque=?"+
              ",env_oc_mail=?"+
              ",env_oc_correo=?"+
              ",env_oc_fax=?"+
              ",oid_cert_prov=?"+
              ",oid_moneda_oc=?"+
              ",oid_pais=?"+
              ",oid_idioma=?"+
              ",oid_suj_imp=?"+
              ",fecha_inha=?"+
              ",oid_forma_pago=?"+
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
              "tomar_precio_oc = ?, "+
              "perm_cambiar_tp = ?, "+
              "oid_via_despacho = ?, "+
              "oid_cond_comp_imp = ?, "+
              "dto_en_cascada=?,"+
              "oid_tipo_docu=?,"+
              "tomar_precio_oc_1=?,"+
              "tomar_precio_oc_2=?,"+
              "tomar_precio_oc_3=?,"+
              "tomar_precio_oc_4=?,"+
              "tomar_precio_oc_5=?, "+
              "inf_rec_sin_oc=?, "+
              "dom_dev_merca=? "+
                 " where " +
                 " oid_proveedor=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_PROVEEDOR,pers.getOID());
    qUpdate.setString(CODIGO,pers.getCodigo());
    qUpdate.setString(RAZON_SOCIAL,pers.getRazonsocial());
    qUpdate.setString(DIRECCION,pers.getDireccion());
    qUpdate.setString(LOCALIDAD,pers.getLocalidad());
    qUpdate.setString(CODIGO_POSTAL,pers.getCodigopostal());

    if (pers.getProvincia()!=null)
      qUpdate.setInt(OID_PROVINCIA,pers.getProvincia().getOID());
    else
      qUpdate.setNull(OID_PROVINCIA,java.sql.Types.INTEGER);

    qUpdate.setBoolean(HABITUAL,pers.isHabitual().booleanValue());
    qUpdate.setString(ORDENCHEQUE,pers.getOrdencheque());
    if (pers.isEnvocmail()!=null)
    	qUpdate.setBoolean(ENV_OC_MAIL,pers.isEnvocmail().booleanValue());
    else
    	qUpdate.setBoolean(ENV_OC_MAIL,false);
    if (pers.isEncoccorreo()!=null)
    	qUpdate.setBoolean(ENV_OC_CORREO,pers.isEncoccorreo().booleanValue());
    else
    	qUpdate.setBoolean(ENV_OC_CORREO,false);
    
    if (pers.isEncocfax()!=null)
    	qUpdate.setBoolean(ENV_OC_FAX,pers.isEncocfax().booleanValue());
    else
    	qUpdate.setBoolean(ENV_OC_FAX,false);

    if (pers.getCertprov()!=null)
      qUpdate.setInt(OID_CERT_PROV,pers.getCertprov().getOID());
    else
      qUpdate.setNull(OID_CERT_PROV,java.sql.Types.INTEGER);

    if (pers.getMonedaoc()!=null)
      qUpdate.setInt(OID_MONEDA_OC,pers.getMonedaoc().getOID());
    else
      qUpdate.setNull(OID_MONEDA_OC,java.sql.Types.INTEGER);

    if (pers.getPais()!=null)
      qUpdate.setInt(OID_PAIS,pers.getPais().getOID());
    else
      qUpdate.setNull(OID_PAIS,java.sql.Types.INTEGER);

    if (pers.getIdioma()!=null)
      qUpdate.setInt(OID_IDIOMA,pers.getIdioma().getOID());
    else
      qUpdate.setNull(OID_IDIOMA,java.sql.Types.INTEGER);

    if (pers.getSujetoimpositivo()!=null)
      qUpdate.setInt(OID_SUJ_IMP,pers.getSujetoimpositivo().getOID());
    else
      qUpdate.setNull(OID_SUJ_IMP,java.sql.Types.INTEGER);

    if (pers.getFechainhabilitacion()!=null)
      qUpdate.setDate(FECHA_INHA,new java.sql.Date(pers.getFechainhabilitacion().getTime()));
    else
      qUpdate.setNull(FECHA_INHA,java.sql.Types.DATE);

    if (pers.getFormaPago()!=null)
      qUpdate.setInt(FORMA_PAGO,pers.getFormaPago().getOID());
    else
      qUpdate.setNull(FORMA_PAGO,java.sql.Types.INTEGER);

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

    if (pers.getTomarPrecioOC()!=null)
    	qUpdate.setString(TOMAR_PRECIO_OC,pers.getTomarPrecioOC());
    else
    	qUpdate.setNull(TOMAR_PRECIO_OC,Types.VARCHAR);

    if (pers.isPermitirCambioTomarPrecioOC()!=null)
    	qUpdate.setBoolean(PERMITIR_CAMBIAR_TP,pers.isPermitirCambioTomarPrecioOC().booleanValue());
    else
    	qUpdate.setBoolean(PERMITIR_CAMBIAR_TP,false);
    if (pers.getViaDespacho()!=null)
    	qUpdate.setInt(VIA_DESPACHO,pers.getViaDespacho().getOID());
    else
    	qUpdate.setNull(VIA_DESPACHO,Types.INTEGER);
    if (pers.getCondCompraImpo()!=null)
    	qUpdate.setInt(COND_COMPRA_IMP,pers.getCondCompraImpo().getOID());
    else
    	qUpdate.setNull(COND_COMPRA_IMP,Types.INTEGER);
    if (pers.isDtoEnCascada()!=null)
    	qUpdate.setBoolean(DTO_EN_CASCADA,pers.isDtoEnCascada().booleanValue());
    else
    	qUpdate.setBoolean(DTO_EN_CASCADA,false);
    if (pers.getTipoDocumento()!=null)
    	qUpdate.setInt(OID_TIPO_DOCU,pers.getTipoDocumento().getOID());
    else
    	qUpdate.setNull(OID_TIPO_DOCU,Types.INTEGER);
    
    if (pers.getTomarPrecioOC1()!=null)
    	qUpdate.setString(TOMAR_PRECIO_OC_1, pers.getTomarPrecioOC1());
    else
    	qUpdate.setNull(TOMAR_PRECIO_OC_1, java.sql.Types.VARCHAR);
    
    if (pers.getTomarPrecioOC2()!=null)
    	qUpdate.setString(TOMAR_PRECIO_OC_2, pers.getTomarPrecioOC2());
    else
    	qUpdate.setNull(TOMAR_PRECIO_OC_2, java.sql.Types.VARCHAR);
    
    if (pers.getTomarPrecioOC3()!=null)
    	qUpdate.setString(TOMAR_PRECIO_OC_3, pers.getTomarPrecioOC3());
    else
    	qUpdate.setNull(TOMAR_PRECIO_OC_3, java.sql.Types.VARCHAR);
    
    if (pers.getTomarPrecioOC4()!=null)
    	qUpdate.setString(TOMAR_PRECIO_OC_4, pers.getTomarPrecioOC4());
    else
    	qUpdate.setNull(TOMAR_PRECIO_OC_4, java.sql.Types.VARCHAR);
    
    if (pers.getTomarPrecioOC5()!=null)
    	qUpdate.setString(TOMAR_PRECIO_OC_5, pers.getTomarPrecioOC5());
    else
    	qUpdate.setNull(TOMAR_PRECIO_OC_5, java.sql.Types.VARCHAR);
    
    if (pers.isPermitirRecepProdSinOC()!=null)
    	qUpdate.setBoolean(PERM_RECEP_PROD_SIN_OC, pers.isPermitirRecepProdSinOC());
    else
    	qUpdate.setNull(PERM_RECEP_PROD_SIN_OC, java.sql.Types.BOOLEAN);

    if (pers.isDomicilioDevolucionMerc()!=null)
    	qUpdate.setBoolean(DOM_DEV_MERC, pers.isDomicilioDevolucionMerc().booleanValue());
    else
    	qUpdate.setNull(DOM_DEV_MERC, java.sql.Types.BOOLEAN);
    
    qUpdate.executeUpdate();
    qUpdate.close();

  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    final int OID_PROVEEDOR = 1;
    Proveedor pers = (Proveedor) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("update cpProveedores "+
                     " set activo=0 " +
                     " where " +
                     " oid_proveedor=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_PROVEEDOR, pers.getOID());
    qUpdate.executeUpdate();
    qUpdate.close();
  }

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    final int OID_PROVEEDOR = 1;
    Proveedor pers = (Proveedor) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("update cpProveedores "+
                     " set activo=1 " +
                     " where " +
                     " oid_proveedor=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_PROVEEDOR, pers.getOID());
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
        ps = this.selectByHelpSimpleProveedor(aCondiciones);
        break;
      }
      case SELECT_BY_HELP_PROVEEDOR: {
        ps = this.selectByHelpProveedor(aCondiciones);
        break;
      }
    }
    return ps;
  }

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

    final int OID_PROVEEDOR = 1;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  cpProveedores ");
    textSQL.append(" WHERE oid_proveedor = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    int oid = ( (Integer) aCondiciones).intValue();
    querySelect.setInt(OID_PROVEEDOR, oid);
    return querySelect;
  }

  private PreparedStatement selectAll(Object aCondiciones) throws BaseException, SQLException {
    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  cpProveedores ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    return querySelect;
  }


  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

    final int CODIGO = 1;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  cpProveedores ");
    textSQL.append(" WHERE codigo = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    String codigo = (String) aCondiciones;
    querySelect.setString(CODIGO, codigo);
    return querySelect;

  }

  private PreparedStatement selectByHelpSimpleProveedor(Object aCondiciones) throws BaseException, SQLException {
    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT oid_proveedor oid,codigo,razon_social descripcion,activo FROM  cpProveedores ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    return querySelect;

  }

  private PreparedStatement selectByHelpProveedor(Object aCondiciones) throws BaseException, SQLException {


    HashTableDatos condiciones = (HashTableDatos) aCondiciones;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT a.* FROM  cpProveedores a ");
    if (condiciones.containsKey("cuit"))
      textSQL.append(" ,imSujetoImpositivo b ");
    textSQL.append(" where 1=1 ");
    if (condiciones.containsKey("cuit"))
      textSQL.append(" and a.oid_suj_imp = b.oid_suj_imp and b.cuit like '%"+condiciones.getString("cuit")+"%'");
    if (condiciones.containsKey("codigo"))
      textSQL.append(" and a.codigo like '%"+condiciones.getString("codigo")+"%' ");
    if (condiciones.containsKey("razon_social"))
      textSQL.append(" and a.razon_social like '%"+condiciones.getString("razon_social")+"%' ");

    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    return querySelect;

  }


  
  public static List getHelpProveedores(HashTableDatos condiciones,
                                        ISesion aSesion) throws BaseException {
    return (List) ObjetoLogico.getObjects(Proveedor.NICKNAME,
                                          DBProveedor.SELECT_BY_HELP_PROVEEDOR,
                                          condiciones,
                                          new ListObserver(),
                                          aSesion);
  }


}
