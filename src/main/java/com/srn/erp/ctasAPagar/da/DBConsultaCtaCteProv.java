package com.srn.erp.ctasAPagar.da;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.compras.bm.Proveedor;
import com.srn.erp.ctacte.bm.TipoCtaCteProv;
import com.srn.erp.ctasAPagar.bm.ConsultaCtaCteProv;
import com.srn.erp.general.bm.Moneda;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.Fecha;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;

public class DBConsultaCtaCteProv extends DBObjetoPersistente {

  public static final String ORDEN = "orden";
  public static final String OID_CCO = "oid_cco";
  public static final String TC_EXT  =  "tc_ext";
  public static final String LETRA   =  "letra";
  public static final String LUG_EMI =  "lug_emi";
  public static final String NRO_EXT =  "nro_ext";
  public static final String FEC_EMISION = "fec_emision";
  public static final String IMPUTAC = "imputac";
  public static final String OID_TRAN_PROV = "oid_tran_prov";
  public static final String OID_TRAN_VTO = "oid_tran_vto";
  public static final String VTO = "vto";
  public static final String IMPO_CUOTA = "impo_cuota";
  public static final String SALDO_CUOTA = "saldo_cuota";
  public static final String OID_TIPO_CTA_PROV = "oid_tipo_cta_prov";
  public static final String TIPO_CTA_PROV = "tipo_cta_prov";
  public static final String OID_PROVEEDOR = "oid_proveedor";
  public static final String RS_PROVEEDOR = "rs_proveedor";
  public static final String TOT_MON_ORI = "tot_mon_ori";
  public static final String SALDO_MON_ORI = "saldo_mon_ori";
  public static final String MONEDA = "moneda";
  public static final String OID_MONEDA = "oid_moneda";
  public static final String MONTO_AUTORIZADO = "monto_autorizado";
  public static final String COTIZ_MON_ORI  = "cotiz_mon_ori";
  public static final String COTIZ_MON_EXT1 = "cotiz_mon_ext1";
  public static final String COTIZ_MON_EXT2 = "cotiz_mon_ext2";
  public static final String COTIZ_MON_ORI_CO  = "cotiz_mon_ori_co";
  public static final String COTIZ_MON_EXT1_CO = "cotiz_mon_ext1_co";
  public static final String COTIZ_MON_EXT2_CO = "cotiz_mon_ext2_co";
  public static final String FEC_CONF_PAGO = "fec_conf_pago";

  public static final int  SELECT_BY_PROVEEDOR     = 100;
  public static final int  SELECT_BY_FECHA_ANT_HOY = 101;
  public static final int  SELECT_BY_PROVEEDOR_SOLO_FAC_Y_ND  = 102;
  public static final int  SELECT_BY_PROVEEDOR_IMPUTAC_DESDE_HASTA = 103;

  public DBConsultaCtaCteProv() {
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
      case SELECT_BY_PROVEEDOR: {
        ps = this.selectByProveedor(aCondiciones);
        break;
      }
      case SELECT_BY_PROVEEDOR_SOLO_FAC_Y_ND: {
        ps = this.selectByProveedorSoloFacyND(aCondiciones);
        break;
      }
      case SELECT_BY_FECHA_ANT_HOY: {
        ps = this.selectByFechaAntHoy(aCondiciones);
        break;
      }
      case SELECT_BY_PROVEEDOR_IMPUTAC_DESDE_HASTA: {
    	  ps = this.selectByProveedorImputacDesdeHasta(aCondiciones);
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
  Proveedor proveedor        = (Proveedor) condiciones.get(Proveedor.NICKNAME);
  java.util.Date fecha       = (java.util.Date) condiciones.get("fecha");
  TipoCtaCteProv tipoCta     = (TipoCtaCteProv) condiciones.get(TipoCtaCteProv.NICKNAME);
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
  textSQL.append("   tranProv.imputac,");
  textSQL.append("   tranProv.oid_tran_prov,  ");  
  textSQL.append("   tranProvVto.oid_tran_vto,  ");
  textSQL.append("   tranProvVto.vto,  ");
  textSQL.append("   tranProvVto.importe*-1 impo_cuota,  ");
  textSQL.append("   tranProvVto.importe*-1 saldo_cuota,  ");
  textSQL.append("   tranProv.oid_tipo_cta_prov,  ");
  textSQL.append("   tipoCta.descripcion tipo_cta_prov, ");
  textSQL.append("   Prov.oid_proveedor,  ");
  textSQL.append("   Prov.razon_social rs_proveedor,  ");
  textSQL.append("   tranProv.importe*-1 tot_mon_ori,  ");
  textSQL.append("   tranProv.saldo*-1 saldo_mon_ori,  ");
  textSQL.append("   monedas.codigo moneda,  ");
  textSQL.append("   monedas.oid_moneda, ");
  textSQL.append("   tranProv.cotiz_mon_ori, ");
  textSQL.append("   tranProv.cotiz_mon_ext1, ");
  textSQL.append("   tranProv.cotiz_mon_ext2, ");
  textSQL.append("   tranProv.cotiz_mon_ori_co, ");
  textSQL.append("   tranProv.cotiz_mon_ext1_co, ");
  textSQL.append("   tranProv.cotiz_mon_ext2_co,  ");
  textSQL.append("   tranProvVto.fec_conf_pago ");
  textSQL.append("  from  ");
  textSQL.append("   geComproCab compcab,  ");
  textSQL.append("   cpTranProv tranProv,  ");
  textSQL.append("   ccTipoCtaProv tipoCta,  ");
  textSQL.append("   cpProveedores Prov,  ");
  textSQL.append("   cpTranProvVto tranProvVto,  ");
  textSQL.append("   geMonedas monedas  ");
  textSQL.append("  where  ");
  textSQL.append("   compcab.activo = 1 and  ");
  textSQL.append("   tranProv.oid_cco = compcab.oid_cco and  ");
  textSQL.append("   cpTranProv.oid_tipo_cta_prov = tipoCta.oid_tipo_cta_prov and  ");
  textSQL.append("   tranProv.oid_proveedor = Prov.oid_proveedor and  ");
  textSQL.append("   tranProv.oid_tran_prov = tranProvVto.oid_tran_prov and  ");
  textSQL.append("   cpTranProv.oid_moneda = monedas.oid_moneda and  ");
  textSQL.append("   cpTranProv.imputac <= ?  ");
  if (proveedor!=null)
	  textSQL.append("   and tranProv.oid_proveedor = "+proveedor.getOIDInteger());
  if (tipoCta!=null)
    textSQL.append(" and tranProv.oid_tipo_cta_prov="+tipoCta.getOIDInteger().toString()+" ");
  if (moneda!=null)
    textSQL.append(" and tranProv.oid_moneda="+moneda.getOIDInteger().toString()+" ");

  textSQL.append(" union all  ");
  textSQL.append("  select  ");
  textSQL.append("   2 orden,  ");
  textSQL.append("   comproCab.oid_cco,  ");
  textSQL.append("   comproCab.tc_ext,  ");
  textSQL.append("   comproCab.letra,  ");
  textSQL.append("   comproCab.lug_emi,  ");
  textSQL.append("   comproCab.nro_ext,  ");
  textSQL.append("   comproCab.emision fec_emision,  ");
  textSQL.append("   tranProv.imputac,");
  textSQL.append("   tranProvVto.oid_tran_prov, ");
  textSQL.append("   tranProvVto.oid_tran_vto, ");
  textSQL.append("   tranProvVto.vto,  ");
  textSQL.append("   tranProvVto.importe*-1 impo_cuota,  ");
  textSQL.append("   aplProv.importe*-1 saldo_cuota,  ");
  textSQL.append("   tranProv.oid_tipo_cta_prov,  ");
  textSQL.append("   tipoCta.descripcion tipo_cta_prov,  ");
  textSQL.append("   Prov.oid_proveedor,  ");
  textSQL.append("   Prov.razon_social rs_proveedor,  ");
  textSQL.append("   tranProv.importe*-1 tot_mon_ori,  ");
  textSQL.append("   tranProv.saldo*-1 saldo_mon_ori,  ");
  textSQL.append("   monedas.codigo moneda,  ");
  textSQL.append("   monedas.oid_moneda,  ");
  // El campo aplProv.importe es simplemente para que no cancele el query
  // Le puse cero y no anda entonces mande un campo cualquiera
  textSQL.append("   aplProv.importe cotiz_mon_ori, ");
  textSQL.append("   aplProv.importe cotiz_mon_ext1, ");
  textSQL.append("   aplProv.importe cotiz_mon_ext2, ");
  textSQL.append("   aplProv.importe cotiz_mon_ori_co, ");
  textSQL.append("   aplProv.importe cotiz_mon_ext1_co, ");
  textSQL.append("   aplProv.importe cotiz_mon_ext2_co,  ");
  textSQL.append("   tranProvVto.fec_conf_pago ");
  textSQL.append("  from  ");
  textSQL.append("   cpAplProv aplProv, ");
  textSQL.append("   geComproCab comproCab,  ");
  textSQL.append("   cpTranProvVto tranProvVto,  ");
  textSQL.append("   cpTranProv tranProv,  ");
  textSQL.append("   cpProveedores Prov,  ");
  textSQL.append("   geMonedas monedas,  ");
  textSQL.append("   ccTipoCtaProv tipoCta  ");
  textSQL.append("  where  ");
  textSQL.append("   tranProv.oid_tran_prov = tranProvVto.oid_tran_Prov and  ");
  textSQL.append("   tranProv.oid_cco = comproCab.oid_cco and  ");
  textSQL.append("   tranProvVto.oid_tran_vto = aplProv.oid_tran_vto and  ");
  textSQL.append("   aplProv.oid_proveedor = Prov.oid_proveedor and  ");
  textSQL.append("   aplProv.oid_moneda = monedas.oid_moneda and  ");
  textSQL.append("   aplProv.oid_tipo_cta_prov = tipoCta.oid_tipo_cta_prov  and ");
  textSQL.append("   aplProv.imputac<=?  ");
  if (proveedor!=null)
	  textSQL.append("   and aplProv.oid_proveedor="+proveedor.getOIDInteger());
  if (tipoCta!=null)
    textSQL.append(" and tranProv.oid_tipo_cta_prov="+tipoCta.getOIDInteger().toString()+" ");
  if (moneda!=null)
    textSQL.append(" and tranProv.oid_moneda="+moneda.getOIDInteger().toString()+" ");

  textSQL.append("  order by 2,8,1 ");

  PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
  querySelect.setDate(1,new java.sql.Date(fecha.getTime()));
  querySelect.setDate(2,new java.sql.Date(fecha.getTime()));

  return querySelect;

}

  private PreparedStatement selectByProveedorSoloFacyND(Object aCondiciones) throws BaseException, SQLException {

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
        textSQL.append("                 tranProv.oid_tran_prov, ");
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
        textSQL.append("                 monedas.codigo moneda, ");
        textSQL.append("                 monedas.oid_moneda, ");
        textSQL.append("                 tranProv.cotiz_mon_ori,");
        textSQL.append("                 tranProv.cotiz_mon_ext1,");
        textSQL.append("                 tranProv.cotiz_mon_ext2,");
        textSQL.append("                 tranProv.cotiz_mon_ori_co,");
        textSQL.append("                 tranProv.cotiz_mon_ext1_co,");
        textSQL.append("                 tranProv.cotiz_mon_ext2_co, ");
        textSQL.append("                 tranProvVto.fec_conf_pago ");
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
  
  private PreparedStatement selectByProveedorImputacDesdeHasta(Object aCondiciones) throws BaseException, SQLException {
	  
	  HashTableDatos condiciones = (HashTableDatos) aCondiciones;
      Proveedor proveedor = (Proveedor) condiciones.get(Proveedor.NICKNAME);
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
      textSQL.append("                 tranProv.imputac,");
      textSQL.append("                 tranProv.oid_tran_prov, ");
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
      textSQL.append("                 monedas.codigo moneda, ");
      textSQL.append("                 monedas.oid_moneda, ");
      textSQL.append("                 tranProv.cotiz_mon_ori,");
      textSQL.append("                 tranProv.cotiz_mon_ext1,");
      textSQL.append("                 tranProv.cotiz_mon_ext2,");
      textSQL.append("                 tranProv.cotiz_mon_ori_co,");
      textSQL.append("                 tranProv.cotiz_mon_ext1_co,");
      textSQL.append("                 tranProv.cotiz_mon_ext2_co, ");
      textSQL.append("                 tranProvVto.fec_conf_pago ");
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
      textSQL.append("                 tranProv.oid_proveedor = ? and ");
      textSQL.append("                 tipoCompro.oid_tc = compCab.oid_tc and ");
      textSQL.append("                 tranProv.imputac>=? and tranProv.imputac<=? "); 
      PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());      
      querySelect.setInt(1,proveedor.getOID());
      querySelect.setDate(2, new Date(fechaDesde.getTime()));
      querySelect.setDate(3, new Date(fechaHasta.getTime()));
      return querySelect;
	  
  }


  private PreparedStatement selectByProveedor(Object aCondiciones) throws BaseException, SQLException {

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
    textSQL.append("                 tranProv.oid_tran_prov, ");
    textSQL.append("                 tranProvVto.oid_tran_vto, ");
    textSQL.append("                 tranProvVto.vto, ");
    textSQL.append("                 tranProvVto.importe*-1 impo_cuota, ");
    textSQL.append("                 tranProvVto.saldo*-1 saldo_cuota, ");
    textSQL.append("                 tranProv.oid_tipo_cta_prov, ");
    textSQL.append("                 tipoCta.descripcion tipo_cta_prov, ");
    textSQL.append("                 Prov.oid_proveedor, ");
    textSQL.append("                 Prov.razon_social rs_proveedor, ");
    textSQL.append("                 tranProv.importe*-1 tot_mon_ori, ");
    textSQL.append("                 tranProv.saldo*-1 saldo_mon_ori, ");
    textSQL.append("                 monedas.codigo moneda, ");
    textSQL.append("                 monedas.oid_moneda, ");
    textSQL.append("                 tranProv.cotiz_mon_ori,");
    textSQL.append("                 tranProv.cotiz_mon_ext1,");
    textSQL.append("                 tranProv.cotiz_mon_ext2,");
    textSQL.append("                 tranProv.cotiz_mon_ori_co,");
    textSQL.append("                 tranProv.cotiz_mon_ext1_co,");
    textSQL.append("                 tranProv.cotiz_mon_ext2_co, ");
    textSQL.append("                 tranProvVto.fec_conf_pago ");
    textSQL.append("               from ");
    textSQL.append("                 geComproCab compcab, ");
    textSQL.append("                 cpTranProv tranProv, ");
    textSQL.append("                 ccTipoCtaProv tipoCta, ");
    textSQL.append("                 cpProveedores Prov, ");
    textSQL.append("                 cpTranProvVto tranProvVto, ");
    textSQL.append("                 geMonedas monedas ");
    textSQL.append("               where ");
    textSQL.append("                 compcab.activo = 1 and ");
    textSQL.append("                 tranProv.oid_cco = compcab.oid_cco and ");
    textSQL.append("                 cpTranProv.oid_tipo_cta_prov = tipoCta.oid_tipo_cta_prov and ");
    textSQL.append("                 tranProv.oid_proveedor = Prov.oid_proveedor and ");
    textSQL.append("                 tranProv.oid_tran_prov = tranProvVto.oid_tran_prov and ");
    textSQL.append("                 cpTranProv.oid_moneda = monedas.oid_moneda and ");
    textSQL.append("                 tranProvVto.pendiente = 1 ");
    if (proveedor!=null)
    	textSQL.append("                 and tranProv.oid_proveedor = "+proveedor.getOIDInteger());
    if (tipoCta!=null)
      textSQL.append("                and tranProv.oid_tipo_cta_prov="+tipoCta.getOIDInteger().toString()+" ");
    if (moneda!=null)
      textSQL.append("                and tranProv.oid_moneda="+moneda.getOIDInteger().toString()+" ");
    textSQL.append("               order by compcab.oid_cco , tranProvVto.vto ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    return querySelect;

  }

  public static List getVtosCtaCteByProveedor(HashTableDatos condiciones,
                                              ISesion aSesion) throws BaseException {
    java.util.Date fecha = (java.util.Date) condiciones.get("fecha");
    if (Fecha.getFechaActual().equals(fecha))
       return (List) ObjetoLogico.getObjects(ConsultaCtaCteProv.NICKNAME,
                                          DBConsultaCtaCteProv.SELECT_BY_PROVEEDOR,
                                          condiciones,
                                          new ListObserver(),
                                          aSesion);
  else
    return (List) ObjetoLogico.getObjects(ConsultaCtaCteProv.NICKNAME,
                                          DBConsultaCtaCteProv.SELECT_BY_FECHA_ANT_HOY,
                                          condiciones,
                                          new ListObserver(),
                                          aSesion);

  }

  public static List getVtosCtaCteByProveedorSoloFactyND(HashTableDatos condiciones,
                                                         ISesion aSesion) throws BaseException {
    return (List) ObjetoLogico.getObjects(ConsultaCtaCteProv.NICKNAME,
                                          DBConsultaCtaCteProv.SELECT_BY_PROVEEDOR_SOLO_FAC_Y_ND,
                                          condiciones,
                                          new ListObserver(),
                                          aSesion);
  }

  public static List getVtosCtaCteByProveedorImputacDesdeHasta(Proveedor proveedor,
		                                                       java.util.Date fechaDesde,
		                                                       java.util.Date fechaHasta,
		                                                       ISesion aSesion) throws BaseException {
	  HashTableDatos condiciones = new HashTableDatos();
	  condiciones.put(Proveedor.NICKNAME,proveedor);
	  condiciones.put("FECHA_DESDE",fechaDesde);
	  condiciones.put("FECHA_HASTA",fechaHasta);
	  return (List) ObjetoLogico.getObjects(ConsultaCtaCteProv.NICKNAME,
			  								DBConsultaCtaCteProv.SELECT_BY_PROVEEDOR_IMPUTAC_DESDE_HASTA,
			  								condiciones,
			  								new ListObserver(),
			  								aSesion);
  }



}
