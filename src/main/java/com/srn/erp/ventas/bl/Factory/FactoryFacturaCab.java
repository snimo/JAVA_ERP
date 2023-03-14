package com.srn.erp.ventas.bl.Factory;

import com.srn.erp.general.bm.ComproCab;
import com.srn.erp.general.bm.LugarEmision;
import com.srn.erp.general.bm.Moneda;
import com.srn.erp.general.bm.Provincia;
import com.srn.erp.general.bm.Sucursal;
import com.srn.erp.general.bm.Talonario;
import com.srn.erp.general.bm.TipoComprobante;
import com.srn.erp.general.da.DBComproCab;
import com.srn.erp.impuestos.bm.ConceptoImpuesto;
import com.srn.erp.impuestos.bm.SujetoImpositivo;
import com.srn.erp.stock.bm.TipoConfMovStkTalonario;
import com.srn.erp.tesoreria.bm.Caja;
import com.srn.erp.ventas.bm.CompoStkTalonarioFactClie;
import com.srn.erp.ventas.bm.CondicionPago;
import com.srn.erp.ventas.bm.FacturaCab;
import com.srn.erp.ventas.bm.ListaPrecios;
import com.srn.erp.ventas.bm.Proyecto;
import com.srn.erp.ventas.bm.Sujeto;
import com.srn.erp.ventas.bm.Vendedor;
import com.srn.erp.ventas.da.DBFacturaCab;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bm.Seguridad.Usuario;
import framework.request.bl.Utils.BaseException;

public class FactoryFacturaCab extends FactoryObjetoLogico { 

  public FactoryFacturaCab() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    FacturaCab facturacab = (FacturaCab) objLog;
    
    
    // Por comproCab
    facturacab.setTalonario(Talonario.findByOidProxy(db.getInteger(DBComproCab.OID_TALONARIO),getSesion()));
    facturacab.setTipoCompro(TipoComprobante.findByOidProxy(db.getInteger(DBComproCab.OID_TC),getSesion()));
    facturacab.setTcExt(db.getString(DBComproCab.TC_EXT));
    facturacab.setLetra(db.getString(DBComproCab.LETRA));
    facturacab.setLugarEmision(LugarEmision.findByOidProxy(db.getInteger(DBComproCab.OID_LUG_EMI),getSesion()));
    facturacab.setNrolugemision(db.getInteger(DBComproCab.LUG_EMI));
    facturacab.setNroext(db.getInteger(DBComproCab.NROEXT));
    facturacab.setEmision(db.getDate(DBComproCab.EMISION));
    facturacab.setEstado(db.getString(DBComproCab.ESTADO));
    facturacab.setComentario(db.getString(DBComproCab.COMENTARIO));
    facturacab.setFecAlta(db.getDate(DBComproCab.FEC_ALTA));
    facturacab.setUsuario(Usuario.findByOidProxy(db.getInteger(DBComproCab.OID_USUARIO),getSesion()));
    facturacab.setActivo(db.getBoolean(DBComproCab.ACTIVO));
    facturacab.setSucursal(Sucursal.findByOidProxy(db.getInteger(DBComproCab.OID_SUCURSAL),getSesion()));
    facturacab.setComportamiento(db.getString(DBComproCab.COMPORTAMIENTO));
    
    facturacab.setOID(db.getInteger(DBFacturaCab.OID_CCO_FACT));
    facturacab.setSujeto(Sujeto.findByOidProxy(db.getInteger(DBFacturaCab.OID_SUJETO),getSesion()));
    facturacab.setTipo_oper(db.getString(DBFacturaCab.TIPO_OPER));
    facturacab.setTipo_cliente(db.getString(DBFacturaCab.TIPO_CLIENTE));
    facturacab.setCaja(Caja.findByOidProxy(db.getInteger(DBFacturaCab.OID_CAJA),getSesion()));
    facturacab.setFec_caja(db.getDate(DBFacturaCab.FEC_CAJA));
    facturacab.setPorc_bonif_cli(db.getDouble(DBFacturaCab.PORC_BONIF_CLI));
    facturacab.setPorc_recar_cli(db.getDouble(DBFacturaCab.PORC_RECAR_CLI));
    facturacab.setTalonario(Talonario.findByOidProxy(db.getInteger(DBFacturaCab.OID_TALONARIO),getSesion()));
    facturacab.setLista_precios(ListaPrecios.findByOidProxy(db.getInteger(DBFacturaCab.OID_LISTA_PRECIOS),getSesion()));
    facturacab.setProvincia(Provincia.findByOidProxy(db.getInteger(DBFacturaCab.OID_PROVINCIA),getSesion()));
    facturacab.setMoneda(Moneda.findByOidProxy(db.getInteger(DBFacturaCab.OID_MONEDA),getSesion()));
    facturacab.setCotizacion(db.getValorCotizacion(DBFacturaCab.COTIZACION));
    facturacab.setVendedor(Vendedor.findByOidProxy(db.getInteger(DBFacturaCab.OID_VENDEDOR),getSesion()));
    facturacab.setCond_pago(CondicionPago.findByOidProxy(db.getInteger(DBFacturaCab.OID_COND_PAGO),getSesion()));
    facturacab.setCompo_stk_fact(CompoStkTalonarioFactClie.findByOidProxy(db.getInteger(DBFacturaCab.OID_COMPO_STK_FACT),getSesion()));
    facturacab.setPorc_bonif_cp(db.getDouble(DBFacturaCab.PORC_BONIF_CP));
    facturacab.setPorc_recar_cp(db.getDouble(DBFacturaCab.PORC_RECAR_CP));
    facturacab.setFec_base(db.getDate(DBFacturaCab.FEC_BASE));
    facturacab.setSujeto_impositivo(SujetoImpositivo.findByOidProxy(db.getInteger(DBFacturaCab.OID_SUJ_IMP),getSesion()));
    facturacab.setSigno(db.getInteger(DBFacturaCab.SIGNO));
    facturacab.setBruto(db.getMoney(DBFacturaCab.BRUTO));
    
    facturacab.setPorc_dto(db.getPorcentaje(DBFacturaCab.PORC_DTO));
    facturacab.setDescuento(db.getMoney(DBFacturaCab.DESCUENTO));
    facturacab.setPorc_recar(db.getPorcentaje(DBFacturaCab.PORC_RECAR));
    facturacab.setRecargo(db.getMoney(DBFacturaCab.RECARGO));
    facturacab.setNeto(db.getMoney(DBFacturaCab.NETO));
    facturacab.setIva(db.getMoney(DBFacturaCab.IVA));
    facturacab.setIva2(db.getMoney(DBFacturaCab.IVA_2));
    facturacab.setPerc_iva(db.getMoney(DBFacturaCab.PERC_IVA));
    facturacab.setImp_internos(db.getMoney(DBFacturaCab.IMP_INTERNOS));
    facturacab.setPerc_ib(db.getMoney(DBFacturaCab.PERC_IB));
    facturacab.setTotal(db.getMoney(DBFacturaCab.TOTAL));
    facturacab.setImpre_bruto(db.getMoney(DBFacturaCab.IMPRE_BRUTO));
    facturacab.setImpre_bonif(db.getMoney(DBFacturaCab.IMPRE_BONIF));
    facturacab.setImpre_recar(db.getMoney(DBFacturaCab.IMPRE_RECAR));
    facturacab.setImpre_neto(db.getMoney(DBFacturaCab.IMPRE_NETO));
    facturacab.setImpre_iva(db.getMoney(DBFacturaCab.IMPRE_IVA));
    facturacab.setImpre_iva2(db.getMoney(DBFacturaCab.IMPRE_IVA_2));
    facturacab.setImpre_perc_iva(db.getMoney(DBFacturaCab.IMPRE_PERC_IVA));
    facturacab.setImpre_perc_ib(db.getMoney(DBFacturaCab.IMPRE_PERC_IB));
    facturacab.setImpre_imp_int(db.getMoney(DBFacturaCab.IMPRE_IMP_INT));
    facturacab.setImpre_total(db.getMoney(DBFacturaCab.IMPRE_TOTAL));
    facturacab.setImprePorcBonif(db.getMoney(DBFacturaCab.IMPRE_PORC_BONIF));
    facturacab.setImprePorcRecar(db.getMoney(DBFacturaCab.IMPRE_PORC_RECAR));
    facturacab.setConcImpIVA(ConceptoImpuesto.findByOidProxy(db.getInteger(DBFacturaCab.OID_CONC_IVA),getSesion()));
    facturacab.setConcImpIVA2(ConceptoImpuesto.findByOidProxy(db.getInteger(DBFacturaCab.OID_CONC_IVA_2),getSesion()));
    facturacab.setConcImpPercIVA(ConceptoImpuesto.findByOidProxy(db.getInteger(DBFacturaCab.OID_CONC_PERC_IVA),getSesion()));
    facturacab.setConcImpPercIB(ConceptoImpuesto.findByOidProxy(db.getInteger(DBFacturaCab.OID_CONC_PERC_IB),getSesion()));
    facturacab.setConcImpInt(ConceptoImpuesto.findByOidProxy(db.getInteger(DBFacturaCab.OID_CONC_IMP_INT),getSesion()));
    facturacab.setNetoGravado(db.getMoney(DBFacturaCab.NETO_GRAVADO));
    facturacab.setNetoNoGravado(db.getMoney(DBFacturaCab.NETO_NO_GRAVADO));
    facturacab.setNetoGravadoMonLoc(db.getMoney(DBFacturaCab.NETO_GRAV_LOC));
    facturacab.setNetoNoGravadoMonLoc(db.getMoney(DBFacturaCab.NETO_NO_GRAV_LOC));
    facturacab.setIvaMonLoc(db.getMoney(DBFacturaCab.IVA_MON_LOC));
    facturacab.setIVA2MonLoc(db.getMoney(DBFacturaCab.IVA_2_MON_LOC));
    facturacab.setOC(db.getString(DBFacturaCab.OC));
    facturacab.setFactura(db.getString(DBFacturaCab.FACTURA));

    
    facturacab.setPercIBBsAs(db.getMoney(DBFacturaCab.PERC_IB_BA));
    facturacab.setPercIBCapFed(db.getMoney(DBFacturaCab.PERC_IB_CF));
    
    facturacab.setPercIBBsAsMonLoc(db.getMoney(DBFacturaCab.PERC_IB_BA_MON_LOC));
    facturacab.setPercIBCapFedMonLoc(db.getMoney(DBFacturaCab.PERC_IB_CF_MON_LOC));
    
    facturacab.setImprePercIBBsAs(db.getMoney(DBFacturaCab.IMPRE_PERC_IB_BA));
    facturacab.setImprePercIBCapFed(db.getMoney(DBFacturaCab.IMPRE_PERC_IB_CF));
    
    facturacab.setFacturaSenia(ComproCab.findByOidProxyCompro(db.getInteger(DBFacturaCab.OID_CCO_FACT_SENIA), this.getSesion()));
    
    
    facturacab.setTipoConfMovStkTalonario(TipoConfMovStkTalonario.findByOidProxy(db.getInteger(DBFacturaCab.OID_TIPO_CONF_MOV_STK),getSesion()));
    facturacab.setProyecto(Proyecto.findByOidProxy(db.getInteger(DBFacturaCab.OID_PROYECTO),getSesion()));
    facturacab.setTipoImpresion(db.getString(DBFacturaCab.TIPO_IMPRESION));
    
    facturacab.setHomologadaFE(db.getBoolean(DBFacturaCab.HOMOLOGADA_FE));
    facturacab.setFecHorHomologadaFE(db.getDate(DBFacturaCab.FECHORA_HOMOLOGADA_FE));
    facturacab.setUsuHomologadaFE(db.getString(DBFacturaCab.USU_HOMOLOGADA_FE));
    facturacab.setCaeFE(db.getString(DBFacturaCab.CAE_FE));
    facturacab.setFecVtoCaeFE(db.getDate(DBFacturaCab.FEC_VTO_CAE_FE));
    
    
    
  }
}
