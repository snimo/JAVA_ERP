package com.srn.erp.ctasACobrar.da;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.compras.bm.Proveedor;
import com.srn.erp.ctacte.bm.TipoCtaCteClie;
import com.srn.erp.ctacte.bm.TipoCtaCteProv;
import com.srn.erp.ctasACobrar.bm.ConsultaCtaCteClie;
import com.srn.erp.general.bm.ComproCab;
import com.srn.erp.general.bm.Moneda;
import com.srn.erp.ventas.bm.Sujeto;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.Fecha;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;
import framework.request.bl.Utils.HashTableDatos;

public class DBConsultaCtaCteClie extends DBObjetoPersistente {

  public static final String ORDEN = "orden";
  public static final String OID_CCO = "oid_cco";
  public static final String TC_EXT  =  "tc_ext";
  public static final String LETRA   =  "letra";
  public static final String LUG_EMI =  "lug_emi";
  public static final String NRO_EXT =  "nro_ext";
  public static final String FEC_EMISION = "fec_emision";
  public static final String IMPUTAC = "imputac";
  public static final String OID_TRAN_CLIE = "oid_tran_clie";
  public static final String OID_TRAN_VTO = "oid_tran_vto";
  public static final String VTO = "vto";
  public static final String IMPO_CUOTA = "impo_cuota";
  public static final String SALDO_CUOTA = "saldo_cuota";
  public static final String OID_TIPO_CTA_CLIE = "oid_tipo_cta_clie";
  public static final String TIPO_CTA_CLIE = "tipo_cta_clie";
  public static final String OID_SUJETO = "oid_sujeto";
  public static final String RS_SUJETO = "rs_sujeto";
  public static final String TOT_MON_ORI = "tot_mon_ori";
  public static final String SALDO_MON_ORI = "saldo_mon_ori";
  public static final String MONEDA = "moneda";
  public static final String OID_MONEDA = "oid_moneda";
  public static final String COTIZ_MON_ORI  = "cotiz_mon_ori";
  public static final String COTIZ_MON_EXT1 = "cotiz_mon_ext1";
  public static final String COTIZ_MON_EXT2 = "cotiz_mon_ext2";
  public static final String COTIZ_MON_ORI_CO  = "cotiz_mon_ori_co";
  public static final String COTIZ_MON_EXT1_CO = "cotiz_mon_ext1_co";
  public static final String COTIZ_MON_EXT2_CO = "cotiz_mon_ext2_co";
  public static final String FEC_CONF_COBRO = "fec_conf_cobro";

  public static final int  SELECT_BY_SUJETO     = 100;
  public static final int  SELECT_BY_FECHA_ANT_HOY = 101;
  public static final int  SELECT_BY_SUJETO_SOLO_FAC_Y_ND  = 102;
  public static final int  SELECT_BY_SUJETO_IMPUTAC_DESDE_HASTA = 103;
  public static final int  SELECT_BY_COMPROBANTE = 104;

  public DBConsultaCtaCteClie() {
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
  }

  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
  }

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
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
      case SELECT_BY_COMPROBANTE: {
    	  ps = this.selectByComprobante(aCondiciones);
          break;  	  
      }
      case SELECT_BY_SUJETO: {
        ps = this.selectBySujeto(aCondiciones);
        break;
      }
      case SELECT_BY_SUJETO_SOLO_FAC_Y_ND: {
        ps = this.selectBySujetoSoloFacyND(aCondiciones);
        break;
      }
      case SELECT_BY_FECHA_ANT_HOY: {
        ps = this.selectByFechaAntHoy(aCondiciones);
        break;
      }
      case SELECT_BY_SUJETO_IMPUTAC_DESDE_HASTA: {
    	  ps = this.selectBySujetoImputacDesdeHasta(aCondiciones);
          break;    	  
      }
    }
    return ps;
  }

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {
    return null;
  }

  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {
    return null;
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {
    return null;
  }

  private PreparedStatement selectByFechaAntHoy(Object aCondiciones) throws BaseException, SQLException {

  HashTableDatos condiciones = (HashTableDatos) aCondiciones;
  Sujeto sujeto              = (Sujeto) condiciones.get(Sujeto.NICKNAME);
  java.util.Date fecha       = (java.util.Date) condiciones.get("fecha");
  TipoCtaCteClie tipoCta     = (TipoCtaCteClie) condiciones.get(TipoCtaCteClie.NICKNAME);
  Moneda moneda              = (Moneda) condiciones.get(Moneda.NICKNAME);

  StringBuffer textSQL = new StringBuffer();
  textSQL.append("  select  ");
  textSQL.append("   1 orden,  ");
  textSQL.append("   compcab.oid_cco,  ");
  textSQL.append("   compcab.tc_ext,  ");
  textSQL.append("   compcab.letra,  ");
  textSQL.append("   compcab.lug_emi,  ");
  textSQL.append("   compcab.nro_ext,  ");
  textSQL.append("   compcab.emision fec_emision,  ");
  textSQL.append("   tranClie.imputac,");
  textSQL.append("   tranClie.oid_tran_clie,  ");  
  textSQL.append("   tranClieVto.oid_tran_vto,  ");
  textSQL.append("   tranClieVto.vto,  ");
  textSQL.append("   tranClieVto.importe impo_cuota,  ");
  textSQL.append("   tranClieVto.importe saldo_cuota,  ");
  textSQL.append("   tranClie.oid_tipo_cta_clie,  ");
  textSQL.append("   tipoCta.descripcion tipo_cta_clie, ");
  textSQL.append("   Sujeto.oid_sujeto,  ");
  textSQL.append("   Sujeto.razon_social rs_sujeto,  ");
  textSQL.append("   tranClie.importe tot_mon_ori,  ");
  textSQL.append("   tranClie.saldo saldo_mon_ori,  ");
  textSQL.append("   monedas.descripcion moneda,  ");
  textSQL.append("   monedas.oid_moneda, ");
  textSQL.append("   tranClie.cotiz_mon_ori, ");
  textSQL.append("   tranClie.cotiz_mon_ext1, ");
  textSQL.append("   tranClie.cotiz_mon_ext2, ");
  textSQL.append("   tranClie.cotiz_mon_ori_co, ");
  textSQL.append("   tranClie.cotiz_mon_ext1_co, ");
  textSQL.append("   tranClie.cotiz_mon_ext2_co,  ");
  textSQL.append("   tranClieVto.fec_conf_cobro ");
  textSQL.append("  from  ");
  textSQL.append("   geComproCab compcab,  ");
  textSQL.append("   veTranClie tranClie,  ");
  textSQL.append("   ccTipoCtaClie tipoCta,  ");
  textSQL.append("   veSujeto Sujeto,  ");
  textSQL.append("   veTranClieVto tranClieVto,  ");
  textSQL.append("   geMonedas monedas  ");
  textSQL.append("  where  ");
  textSQL.append("   compcab.activo = 1 and  ");
  textSQL.append("   tranClie.oid_cco = compcab.oid_cco and  ");
  textSQL.append("   tranClie.oid_tipo_cta_clie = tipoCta.oid_tipo_cta_clie and  ");
  textSQL.append("   tranClie.oid_sujeto = sujeto.oid_sujeto and  ");
  textSQL.append("   tranClie.oid_tran_clie = tranClieVto.oid_tran_clie and  ");
  textSQL.append("   tranClie.oid_moneda = monedas.oid_moneda and  ");
  textSQL.append("   tranClie.imputac <= ? ");
  if (sujeto!=null)
	  textSQL.append("   and tranClie.oid_sujeto = "+sujeto.getOID());
  if (tipoCta!=null)
    textSQL.append(" and tranClie.oid_tipo_cta_clie="+tipoCta.getOIDInteger().toString()+" ");
  if (moneda!=null)
    textSQL.append(" and tranClie.oid_moneda="+moneda.getOIDInteger().toString()+" ");

  textSQL.append(" union all  ");
  textSQL.append("  select  ");
  textSQL.append("   2 orden,  ");
  textSQL.append("   comproCab.oid_cco,  ");
  textSQL.append("   comproCab.tc_ext,  ");
  textSQL.append("   comproCab.letra,  ");
  textSQL.append("   comproCab.lug_emi,  ");
  textSQL.append("   comproCab.nro_ext,  ");
  textSQL.append("   comproCab.emision fec_emision,  ");
  textSQL.append("   tranClie.imputac,");
  textSQL.append("   tranClieVto.oid_tran_clie, ");
  textSQL.append("   tranClieVto.oid_tran_vto, ");
  textSQL.append("   tranClieVto.vto,  ");
  textSQL.append("   tranClieVto.importe impo_cuota,  ");
  textSQL.append("   aplClie.importe saldo_cuota,  ");
  textSQL.append("   tranClie.oid_tipo_cta_clie,  ");
  textSQL.append("   tipoCta.descripcion tipo_cta_clie,  ");
  textSQL.append("   sujeto.oid_sujeto,  ");
  textSQL.append("   sujeto.razon_social rs_sujeto,  ");
  textSQL.append("   tranClie.importe tot_mon_ori,  ");
  textSQL.append("   tranClie.saldo saldo_mon_ori,  ");
  textSQL.append("   monedas.descripcion moneda,  ");
  textSQL.append("   monedas.oid_moneda,  ");
  // El campo aplProv.importe es simplemente para que no cancele el query
  // Le puse cero y no anda entonces mande un campo cualquiera
  textSQL.append("   aplClie.importe cotiz_mon_ori, ");
  textSQL.append("   aplClie.importe cotiz_mon_ext1, ");
  textSQL.append("   aplClie.importe cotiz_mon_ext2, ");
  textSQL.append("   aplClie.importe cotiz_mon_ori_co, ");
  textSQL.append("   aplClie.importe cotiz_mon_ext1_co, ");
  textSQL.append("   aplClie.importe cotiz_mon_ext2_co,  ");
  textSQL.append("   tranClieVto.fec_conf_cobro ");
  textSQL.append("  from  ");
  textSQL.append("   veAplClie aplClie, ");
  textSQL.append("   geComproCab comproCab,  ");
  textSQL.append("   veTranClieVto tranClieVto,  ");
  textSQL.append("   veTranClie tranClie,  ");
  textSQL.append("   veSujeto Sujeto,  ");
  textSQL.append("   geMonedas monedas,  ");
  textSQL.append("   ccTipoCtaClie tipoCta  ");
  textSQL.append("  where  ");
  textSQL.append("   tranClie.oid_tran_Clie = tranClieVto.oid_tran_clie and  ");
  textSQL.append("   tranClie.oid_cco = comproCab.oid_cco and  ");
  textSQL.append("   tranClieVto.oid_tran_vto = aplClie.oid_tran_vto and  ");
  textSQL.append("   aplClie.oid_sujeto = Sujeto.oid_sujeto and  ");
  textSQL.append("   aplClie.oid_moneda = monedas.oid_moneda and  ");
  textSQL.append("   aplClie.oid_tipo_cta_clie = tipoCta.oid_tipo_cta_clie  and ");
  textSQL.append("   aplClie.imputac<=?  ");
  if (sujeto!=null)
	  textSQL.append("   and aplClie.oid_sujeto="+sujeto.getOIDInteger());
  if (tipoCta!=null)
    textSQL.append(" and tranClie.oid_tipo_cta_clie="+tipoCta.getOIDInteger().toString()+" ");
  if (moneda!=null)
    textSQL.append(" and tranClie.oid_moneda="+moneda.getOIDInteger().toString()+" ");

  textSQL.append("  order by 2,8,1 ");

  PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
  querySelect.setDate(1,new java.sql.Date(fecha.getTime()));
  querySelect.setDate(2,new java.sql.Date(fecha.getTime()));
  
  return querySelect;

}

  private PreparedStatement selectBySujetoSoloFacyND(Object aCondiciones) throws BaseException, SQLException {

        HashTableDatos condiciones = (HashTableDatos) aCondiciones;
        Proveedor proveedor = (Proveedor) condiciones.get(Proveedor.NICKNAME);
        TipoCtaCteProv tipoCta = (TipoCtaCteProv) condiciones.get(TipoCtaCteProv.NICKNAME);
        Moneda moneda = (Moneda) condiciones.get(Moneda.NICKNAME);

        StringBuffer textSQL = new StringBuffer();
        textSQL.append("");
        textSQL.append("               select ");
        textSQL.append("                 1 orden,");
        textSQL.append("                 compcab.oid_cco, ");
        textSQL.append("                 compcab.tc_ext, ");
        textSQL.append("                 compcab.letra, ");
        textSQL.append("                 compcab.lug_emi, ");
        textSQL.append("                 compcab.nro_ext, ");
        textSQL.append("                 compcab.emision fec_emision, ");
        textSQL.append("                 tranProv.imputac,");
        textSQL.append("                 tranProv.oid_tran_clie, ");
        textSQL.append("                 tranProvVto.oid_tran_vto, ");
        textSQL.append("                 tranProvVto.vto, ");
        textSQL.append("                 tranProvVto.importe impo_cuota, ");
        textSQL.append("                 tranProvVto.saldo saldo_cuota, ");
        textSQL.append("                 tranProv.oid_tipo_cta_prov, ");
        textSQL.append("                 tipoCta.descripcion tipo_cta_prov, ");
        textSQL.append("                 Prov.oid_proveedor, ");
        textSQL.append("                 Prov.razon_social rs_proveedor, ");
        textSQL.append("                 tranProv.importe tot_mon_ori, ");
        textSQL.append("                 tranProv.saldo saldo_mon_ori, ");
        textSQL.append("                 monedas.descripcion moneda, ");
        textSQL.append("                 monedas.oid_moneda, ");
        textSQL.append("                 tranProv.cotiz_mon_ori,");
        textSQL.append("                 tranProv.cotiz_mon_ext1,");
        textSQL.append("                 tranProv.cotiz_mon_ext2,");
        textSQL.append("                 tranProv.cotiz_mon_ori_co,");
        textSQL.append("                 tranProv.cotiz_mon_ext1_co,");
        textSQL.append("                 tranProv.cotiz_mon_ext2_co ");
        textSQL.append("               from ");
        textSQL.append("                 geComproCab compcab, ");
        textSQL.append("                 cpTranProv tranProv, ");
        textSQL.append("                 ccTipoCtaProv tipoCta, ");
        textSQL.append("                 cpProveedores Prov, ");
        textSQL.append("                 cpTranProvVto tranProvVto, ");
        textSQL.append("                 geMonedas monedas, ");
        textSQL.append("                 geTipoCompro tipoCompro ");
        textSQL.append("               where ");
        textSQL.append("                 compcab.activo = 1 and ");
        textSQL.append("                 tranProv.oid_cco = compcab.oid_cco and ");
        textSQL.append("                 cpTranProv.oid_tipo_cta_prov = tipoCta.oid_tipo_cta_prov and ");
        textSQL.append("                 tranProv.oid_proveedor = Prov.oid_proveedor and ");
        textSQL.append("                 tranProv.oid_tran_prov = tranProvVto.oid_tran_prov and ");
        textSQL.append("                 cpTranProv.oid_moneda = monedas.oid_moneda and ");
        textSQL.append("                 tranProvVto.pendiente = 1 and ");
        textSQL.append("                 tranProv.oid_proveedor = ? and ");
        textSQL.append("                 tipoCompro.oid_tc = compCab.oid_tc and ");
        textSQL.append("                 (tipoCompro.identificacion='FAPRO' or tipoCompro.identificacion='NDPRO') ");
        if (tipoCta!=null)
          textSQL.append("                and tranProv.oid_tipo_cta_prov="+tipoCta.getOIDInteger().toString()+" ");
        if (moneda!=null)
          textSQL.append("                and tranProv.oid_moneda="+moneda.getOIDInteger().toString()+" ");
        textSQL.append("               order by compcab.oid_cco , tranProvVto.vto ");
        PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
        querySelect.setInt(1,proveedor.getOID());
        return querySelect;

  }
  
  private PreparedStatement selectBySujetoImputacDesdeHasta(Object aCondiciones) throws BaseException, SQLException {
	  
	  HashTableDatos condiciones = (HashTableDatos) aCondiciones;
      Sujeto sujeto = (Sujeto) condiciones.get(Sujeto.NICKNAME);
      java.util.Date fechaDesde = (java.util.Date) condiciones.get("FECHA_DESDE");
      java.util.Date fechaHasta = (java.util.Date) condiciones.get("FECHA_HASTA");

      StringBuffer textSQL = new StringBuffer();
      textSQL.append("");
      textSQL.append("               select ");
      textSQL.append("                 1 orden,");
      textSQL.append("                 compcab.oid_cco, ");
      textSQL.append("                 compcab.tc_ext, ");
      textSQL.append("                 compcab.letra, ");
      textSQL.append("                 compcab.lug_emi, ");
      textSQL.append("                 compcab.nro_ext, ");
      textSQL.append("                 compcab.emision fec_emision, ");
      textSQL.append("                 tranClie.imputac,");
      textSQL.append("                 tranClie.oid_tran_clie, ");
      textSQL.append("                 tranClieVto.oid_tran_vto, ");
      textSQL.append("                 tranClieVto.vto, ");
      textSQL.append("                 tranClieVto.importe impo_cuota, ");
      textSQL.append("                 tranClieVto.saldo saldo_cuota, ");
      textSQL.append("                 tranClie.oid_tipo_cta_clie, ");
      textSQL.append("                 tipoCta.descripcion tipo_cta_clie, ");
      textSQL.append("                 Sujeto.oid_sujeto, ");
      textSQL.append("                 Sujeto.razon_social rs_sujeto, ");
      textSQL.append("                 tranClie.importe tot_mon_ori, ");
      textSQL.append("                 tranClie.saldo saldo_mon_ori, ");
      textSQL.append("                 monedas.descripcion moneda, ");
      textSQL.append("                 monedas.oid_moneda, ");
      textSQL.append("                 tranClie.cotiz_mon_ori,");
      textSQL.append("                 tranClie.cotiz_mon_ext1,");
      textSQL.append("                 tranClie.cotiz_mon_ext2,");
      textSQL.append("                 tranClie.cotiz_mon_ori_co,");
      textSQL.append("                 tranClie.cotiz_mon_ext1_co,");
      textSQL.append("                 tranClie.cotiz_mon_ext2_co, ");
      textSQL.append("                 tranClieVto.fec_conf_cobro ");
      textSQL.append("               from ");
      textSQL.append("                 geComproCab compcab, ");
      textSQL.append("                 veTranClie tranClie, ");
      textSQL.append("                 ccTipoCtaClie tipoCta, ");
      textSQL.append("                 veSujeto Sujeto, ");
      textSQL.append("                 veTranClieVto tranClieVto, ");
      textSQL.append("                 geMonedas monedas, ");
      textSQL.append("                 geTipoCompro tipoCompro ");
      textSQL.append("               where ");
      textSQL.append("                 compcab.activo = 1 and ");
      textSQL.append("                 tranClie.oid_cco = compcab.oid_cco and ");
      textSQL.append("                 tranClie.oid_tipo_cta_clie = tipoCta.oid_tipo_cta_clie and ");
      textSQL.append("                 tranClie.oid_sujeto = sujeto.oid_sujeto and ");
      textSQL.append("                 tranClie.oid_tran_clie = tranClieVto.oid_tran_clie and ");
      textSQL.append("                 TranClie.oid_moneda = monedas.oid_moneda and ");
      textSQL.append("                 tranClie.oid_sujeto = ? and ");
      textSQL.append("                 tipoCompro.oid_tc = compCab.oid_tc and ");
      textSQL.append("                 tranClie.imputac>=? and tranClie.imputac<=? "); 
      PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());      
      querySelect.setInt(1,sujeto.getOID());
      querySelect.setDate(2, new Date(fechaDesde.getTime()));
      querySelect.setDate(3, new Date(fechaHasta.getTime()));
      return querySelect;
	  
  }


  private PreparedStatement selectBySujeto(Object aCondiciones) throws BaseException, SQLException {

    HashTableDatos condiciones = (HashTableDatos) aCondiciones;
    Sujeto sujeto = (Sujeto) condiciones.get(Sujeto.NICKNAME);
    TipoCtaCteClie tipoCta = (TipoCtaCteClie) condiciones.get(TipoCtaCteClie.NICKNAME);
    Moneda moneda = (Moneda) condiciones.get(Moneda.NICKNAME);

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("");
    textSQL.append("               select ");
    textSQL.append("                 1 orden,");
    textSQL.append("                 compcab.oid_cco, ");
    textSQL.append("                 compcab.tc_ext, ");
    textSQL.append("                 compcab.letra, ");
    textSQL.append("                 compcab.lug_emi, ");
    textSQL.append("                 compcab.nro_ext, ");
    textSQL.append("                 compcab.emision fec_emision, ");
    textSQL.append("                 tranClie.imputac,");
    textSQL.append("                 tranClie.oid_tran_clie, ");
    textSQL.append("                 tranClieVto.oid_tran_vto, ");
    textSQL.append("                 tranClieVto.vto, ");
    textSQL.append("                 tranClieVto.importe impo_cuota, ");
    textSQL.append("                 tranClieVto.saldo saldo_cuota, ");
    textSQL.append("                 tranClie.oid_tipo_cta_clie, ");
    textSQL.append("                 tipoCta.descripcion tipo_cta_clie, ");
    textSQL.append("                 Sujeto.oid_sujeto, ");
    textSQL.append("                 Sujeto.razon_social rs_sujeto, ");
    textSQL.append("                 tranClie.importe tot_mon_ori, ");
    textSQL.append("                 tranClie.saldo saldo_mon_ori, ");
    textSQL.append("                 monedas.descripcion moneda, ");
    textSQL.append("                 monedas.oid_moneda, ");
    textSQL.append("                 tranClie.cotiz_mon_ori,");
    textSQL.append("                 tranClie.cotiz_mon_ext1,");
    textSQL.append("                 tranClie.cotiz_mon_ext2,");
    textSQL.append("                 tranClie.cotiz_mon_ori_co,");
    textSQL.append("                 tranClie.cotiz_mon_ext1_co,");
    textSQL.append("                 tranClie.cotiz_mon_ext2_co, ");
    textSQL.append("                 tranClieVto.fec_conf_cobro ");
    textSQL.append("               from ");
    textSQL.append("                 geComproCab compcab, ");
    textSQL.append("                 veTranClie tranClie, ");
    textSQL.append("                 ccTipoCtaClie tipoCta, ");
    textSQL.append("                 veSujeto Sujeto, ");
    textSQL.append("                 veTranClieVto tranClieVto, ");
    textSQL.append("                 geMonedas monedas ");
    textSQL.append("               where ");
    textSQL.append("                 compcab.activo = 1 and ");
    textSQL.append("                 tranClie.oid_cco = compcab.oid_cco and ");
    textSQL.append("                 tranClie.oid_tipo_cta_clie = tipoCta.oid_tipo_cta_clie and ");
    textSQL.append("                 tranClie.oid_sujeto = sujeto.oid_sujeto and ");
    textSQL.append("                 tranClie.oid_tran_clie = tranClieVto.oid_tran_clie and ");
    textSQL.append("                 tranClie.oid_moneda = monedas.oid_moneda and ");
    textSQL.append("                 tranClieVto.pendiente = 1  ");
    if (sujeto!=null)
    	textSQL.append("               and tranClie.oid_sujeto = "+sujeto.getOID()+" ");
    if (tipoCta!=null)
      textSQL.append("                and tranClie.oid_tipo_cta_clie="+tipoCta.getOIDInteger().toString()+" ");
    if (moneda!=null)
      textSQL.append("                and tranClie.oid_moneda="+moneda.getOIDInteger().toString()+" ");
    textSQL.append("               order by compcab.oid_cco , tranClieVto.vto ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    return querySelect;
  }
  
  private PreparedStatement selectByComprobante(Object aCondiciones) throws BaseException, SQLException {

	    HashTableDatos condiciones = (HashTableDatos) aCondiciones;
	    ComproCab compro = (ComproCab) condiciones.get(ComproCab.NICKNAME);
	  
	    StringBuffer textSQL = new StringBuffer();
	    textSQL.append("");
	    textSQL.append("               select ");
	    textSQL.append("                 1 orden,");
	    textSQL.append("                 compcab.oid_cco, ");
	    textSQL.append("                 compcab.tc_ext, ");
	    textSQL.append("                 compcab.letra, ");
	    textSQL.append("                 compcab.lug_emi, ");
	    textSQL.append("                 compcab.nro_ext, ");
	    textSQL.append("                 compcab.emision fec_emision, ");
	    textSQL.append("                 tranClie.imputac,");
	    textSQL.append("                 tranClie.oid_tran_clie, ");
	    textSQL.append("                 tranClieVto.oid_tran_vto, ");
	    textSQL.append("                 tranClieVto.vto, ");
	    textSQL.append("                 tranClieVto.importe impo_cuota, ");
	    textSQL.append("                 tranClieVto.saldo saldo_cuota, ");
	    textSQL.append("                 tranClie.oid_tipo_cta_clie, ");
	    textSQL.append("                 tipoCta.descripcion tipo_cta_clie, ");
	    textSQL.append("                 Sujeto.oid_sujeto, ");
	    textSQL.append("                 Sujeto.razon_social rs_sujeto, ");
	    textSQL.append("                 tranClie.importe tot_mon_ori, ");
	    textSQL.append("                 tranClie.saldo saldo_mon_ori, ");
	    textSQL.append("                 monedas.descripcion moneda, ");
	    textSQL.append("                 monedas.oid_moneda, ");
	    textSQL.append("                 tranClie.cotiz_mon_ori,");
	    textSQL.append("                 tranClie.cotiz_mon_ext1,");
	    textSQL.append("                 tranClie.cotiz_mon_ext2,");
	    textSQL.append("                 tranClie.cotiz_mon_ori_co,");
	    textSQL.append("                 tranClie.cotiz_mon_ext1_co,");
	    textSQL.append("                 tranClie.cotiz_mon_ext2_co, ");
	    textSQL.append("                 tranClieVto.fec_conf_cobro ");
	    textSQL.append("               from ");
	    textSQL.append("                 geComproCab compcab, ");
	    textSQL.append("                 veTranClie tranClie, ");
	    textSQL.append("                 ccTipoCtaClie tipoCta, ");
	    textSQL.append("                 veSujeto Sujeto, ");
	    textSQL.append("                 veTranClieVto tranClieVto, ");
	    textSQL.append("                 geMonedas monedas ");
	    textSQL.append("               where ");
	    textSQL.append("                 compcab.activo = 1 and ");
	    textSQL.append("                 tranClie.oid_cco = compcab.oid_cco and ");
	    textSQL.append("                 tranClie.oid_tipo_cta_clie = tipoCta.oid_tipo_cta_clie and ");
	    textSQL.append("                 tranClie.oid_sujeto = sujeto.oid_sujeto and ");
	    textSQL.append("                 tranClie.oid_tran_clie = tranClieVto.oid_tran_clie and ");
	    textSQL.append("                 tranClie.oid_moneda = monedas.oid_moneda and ");
	    textSQL.append("                 tranClieVto.pendiente = 1  ");
	    textSQL.append("               and tranClie.oid_cco = "+compro.getOID()+" ");
	    textSQL.append("               order by compcab.oid_cco , tranClieVto.vto ");
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
	    return querySelect;
	  }

  public static List getVtosCtaCteBySujeto(HashTableDatos condiciones,
                                           ISesion aSesion) throws BaseException {
    java.util.Date fecha = (java.util.Date) condiciones.get("fecha");
    if (Fecha.getFechaActual().equals(fecha))
       return (List) ObjetoLogico.getObjects(ConsultaCtaCteClie.NICKNAME,
                                          DBConsultaCtaCteClie.SELECT_BY_SUJETO,
                                          condiciones,
                                          new ListObserver(),
                                          aSesion);
  else
    return (List) ObjetoLogico.getObjects(ConsultaCtaCteClie.NICKNAME,
                                          DBConsultaCtaCteClie.SELECT_BY_FECHA_ANT_HOY,
                                          condiciones,
                                          new ListObserver(),
                                          aSesion);

  }
  
  public static List getVtosCtaCteByComprobante(HashTableDatos condiciones,
          ISesion aSesion) throws BaseException {
	  	ComproCab compro = (ComproCab) condiciones.get(ComproCab.NICKNAME);
	  	return (List) ObjetoLogico.getObjects(ConsultaCtaCteClie.NICKNAME,
	         DBConsultaCtaCteClie.SELECT_BY_COMPROBANTE,
	         condiciones,
	         new ListObserver(),
	         aSesion);

  }

  public static List getVtosCtaCteBySujetoSoloFactyND(HashTableDatos condiciones,
                                                         ISesion aSesion) throws BaseException {
    return (List) ObjetoLogico.getObjects(ConsultaCtaCteClie.NICKNAME,
                                          DBConsultaCtaCteClie.SELECT_BY_SUJETO_SOLO_FAC_Y_ND,
                                          condiciones,
                                          new ListObserver(),
                                          aSesion);
  }

  public static List getVtosCtaCteBySujetoImputacDesdeHasta(Sujeto sujeto,
		                                                    java.util.Date fechaDesde,
		                                                    java.util.Date fechaHasta,
		                                                    ISesion aSesion) throws BaseException {
	  HashTableDatos condiciones = new HashTableDatos();
	  if (sujeto == null)
	  	throw new ExceptionValidation(null,"Debe ingresar el cliente");
	  condiciones.put(Sujeto.NICKNAME,sujeto);
	  condiciones.put("FECHA_DESDE",fechaDesde);
	  condiciones.put("FECHA_HASTA",fechaHasta);
	  return (List) ObjetoLogico.getObjects(ConsultaCtaCteClie.NICKNAME,
			  								DBConsultaCtaCteClie.SELECT_BY_SUJETO_IMPUTAC_DESDE_HASTA,
			  								condiciones,
			  								new ListObserver(),
			  								aSesion);
  }



}
