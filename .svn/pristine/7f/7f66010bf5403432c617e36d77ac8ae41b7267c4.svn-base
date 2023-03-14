package com.srn.erp.ventas.bl.Factory;

import com.srn.erp.general.bm.LugarEmision;
import com.srn.erp.general.bm.Moneda;
import com.srn.erp.general.bm.Sucursal;
import com.srn.erp.general.bm.Talonario;
import com.srn.erp.general.bm.TipoComprobante;
import com.srn.erp.general.da.DBComproCab;
import com.srn.erp.impuestos.bm.ConceptoImpuesto;
import com.srn.erp.stock.bm.Transporte;
import com.srn.erp.ventas.bm.CondicionPago;
import com.srn.erp.ventas.bm.ContactoSujeto;
import com.srn.erp.ventas.bm.CotizacionCab;
import com.srn.erp.ventas.bm.EstadoPresupuestoCliente;
import com.srn.erp.ventas.bm.FormaEntrega;
import com.srn.erp.ventas.bm.ListaPrecios;
import com.srn.erp.ventas.bm.MotivoEstadoPresuCliente;
import com.srn.erp.ventas.bm.Sujeto;
import com.srn.erp.ventas.bm.UnidadEdilicia;
import com.srn.erp.ventas.bm.Vendedor;
import com.srn.erp.ventas.da.DBCondicionPago;
import com.srn.erp.ventas.da.DBCotizacionCab;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bm.Seguridad.Usuario;
import framework.request.bl.Utils.BaseException;

public class FactoryCotizacionCab extends FactoryObjetoLogico {

  public FactoryCotizacionCab() {
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    CotizacionCab cotizacioncab = (CotizacionCab) objLog;
    cotizacioncab.setOID(db.getInteger(DBCotizacionCab.OID_CCO_PRESU));

    // Por comproCab
    cotizacioncab.setTalonario(Talonario.findByOidProxy(db.getInteger(DBComproCab.OID_TALONARIO),getSesion()));
    cotizacioncab.setTipoCompro(TipoComprobante.findByOidProxy(db.getInteger(DBComproCab.OID_TC),getSesion()));
    cotizacioncab.setTcExt(db.getString(DBComproCab.TC_EXT));
    cotizacioncab.setLetra(db.getString(DBComproCab.LETRA));
    cotizacioncab.setLugarEmision(LugarEmision.findByOidProxy(db.getInteger(DBComproCab.OID_LUG_EMI),getSesion()));
    cotizacioncab.setNrolugemision(db.getInteger(DBComproCab.LUG_EMI));
    cotizacioncab.setNroext(db.getInteger(DBComproCab.NROEXT));
    cotizacioncab.setEmision(db.getDate(DBComproCab.EMISION));
    cotizacioncab.setEstado(db.getString(DBComproCab.ESTADO));
    cotizacioncab.setComentario(db.getString(DBComproCab.COMENTARIO));
    cotizacioncab.setFecAlta(db.getDate(DBComproCab.FEC_ALTA));
    cotizacioncab.setUsuario(Usuario.findByOidProxy(db.getInteger(DBComproCab.OID_USUARIO),getSesion()));
    cotizacioncab.setActivo(db.getBoolean(DBComproCab.ACTIVO));
    cotizacioncab.setSucursal(Sucursal.findByOidProxy(db.getInteger(DBComproCab.OID_SUCURSAL),getSesion()));
    

    cotizacioncab.setSujeto(Sujeto.findByOidProxy(db.getInteger(DBCotizacionCab.OID_SUJETO),getSesion()));
    cotizacioncab.setMoneda(Moneda.findByOidProxy(db.getInteger(DBCotizacionCab.OID_MONEDA),getSesion()));
    cotizacioncab.setCotizacion(db.getValorCotizacion(DBCotizacionCab.COTIZACION));
    cotizacioncab.setMercado(db.getString(DBCotizacionCab.MERCADO));
    cotizacioncab.setPorc_bonif_cli(db.getDouble(DBCotizacionCab.PORC_BONIF_CLI));
    cotizacioncab.setPorc_reca_cli(db.getDouble(DBCotizacionCab.PORC_RECA_CLI));
    cotizacioncab.setBonif_cli_cascada(db.getBoolean(DBCotizacionCab.BONIF_CLI_CASCADA));
    cotizacioncab.setReca_cli_cascada(db.getBoolean(DBCotizacionCab.RECA_CLI_CASCADA));
    cotizacioncab.setLista_precios(ListaPrecios.findByOidProxy(db.getInteger(DBCotizacionCab.OID_PRECIO_CAB),getSesion()));
    cotizacioncab.setCondicionPago(CondicionPago.findByOidProxy(db.getInteger(DBCondicionPago.OID_COND_PAGO),getSesion()));
    cotizacioncab.setVendedor(Vendedor.findByOidProxy(db.getInteger(DBCotizacionCab.OID_VENDEDOR),getSesion()));
    cotizacioncab.setDomicilio_entrega(UnidadEdilicia.findByOidProxy(db.getInteger(DBCotizacionCab.OID_UNI_EDI),getSesion()));
    cotizacioncab.setPorc_bonif_cp(db.getDouble(DBCotizacionCab.PORC_BONIF_CP));
    cotizacioncab.setPorc_reca_cp(db.getDouble(DBCotizacionCab.PORC_RECA_CP));
    cotizacioncab.setBonif_cp_cascada(db.getBoolean(DBCotizacionCab.BONIF_CP_CASCADA));
    cotizacioncab.setOrdenDeCompra(db.getString(DBCotizacionCab.ORDEN_COMPRA));
    cotizacioncab.setReca_cp_cascada(db.getBoolean(DBCotizacionCab.RECA_CP_CASCADA));
    cotizacioncab.setObservado(db.getBoolean(DBCotizacionCab.OBSERVADO));
    cotizacioncab.setComentario(db.getString(DBCotizacionCab.COMENTARIO));
    cotizacioncab.setPendEnt(db.getBoolean(DBCotizacionCab.PEND_ENT));
    cotizacioncab.setPendFact(db.getBoolean(DBCotizacionCab.PEND_FACT));
    cotizacioncab.setTransporte(Transporte.findByOidProxy(db.getInteger(DBCotizacionCab.OID_TRANSPORTE),getSesion()));
    cotizacioncab.setFormaEntrega(FormaEntrega.findByOidProxy(db.getInteger(DBCotizacionCab.OID_FORMA_ENTREGA),getSesion()));
    cotizacioncab.setMonedaFact(Moneda.findByOidProxy(db.getInteger(DBCotizacionCab.OID_MONEDA_FACT),getSesion()));
    cotizacioncab.setPendDesp(db.getBoolean(DBCotizacionCab.PEND_DESP));
    cotizacioncab.setContactoSujeto(ContactoSujeto.findByOidProxy(db.getInteger(DBCotizacionCab.OID_CONTACTO),getSesion()));
    
    cotizacioncab.setBruto(db.getMoney(DBCotizacionCab.BRUTO));
    cotizacioncab.setPorc_dto(db.getPorcentaje(DBCotizacionCab.PORC_DTO));
    cotizacioncab.setDescuento(db.getMoney(DBCotizacionCab.DESCUENTO));
    cotizacioncab.setPorc_recar(db.getPorcentaje(DBCotizacionCab.PORC_RECAR));
    cotizacioncab.setRecargo(db.getMoney(DBCotizacionCab.RECARGO));
    cotizacioncab.setNeto(db.getMoney(DBCotizacionCab.NETO));
    cotizacioncab.setIva(db.getMoney(DBCotizacionCab.IVA));
    cotizacioncab.setPerc_iva(db.getMoney(DBCotizacionCab.PERC_IVA));
    cotizacioncab.setImp_internos(db.getMoney(DBCotizacionCab.IMP_INTERNOS));
    cotizacioncab.setPerc_ib(db.getMoney(DBCotizacionCab.PERC_IB));
    cotizacioncab.setTotal(db.getMoney(DBCotizacionCab.TOTAL));
    cotizacioncab.setImpre_bruto(db.getMoney(DBCotizacionCab.IMPRE_BRUTO));
    cotizacioncab.setImpre_bonif(db.getMoney(DBCotizacionCab.IMPRE_BONIF));
    cotizacioncab.setImpre_recar(db.getMoney(DBCotizacionCab.IMPRE_RECAR));
    cotizacioncab.setImpre_neto(db.getMoney(DBCotizacionCab.IMPRE_NETO));
    cotizacioncab.setImpre_iva(db.getMoney(DBCotizacionCab.IMPRE_IVA));
    cotizacioncab.setImpre_perc_iva(db.getMoney(DBCotizacionCab.IMPRE_PERC_IVA));
    cotizacioncab.setImpre_perc_ib(db.getMoney(DBCotizacionCab.IMPRE_PERC_IB));
    cotizacioncab.setImpre_imp_int(db.getMoney(DBCotizacionCab.IMPRE_IMP_INT));
    cotizacioncab.setImpre_total(db.getMoney(DBCotizacionCab.IMPRE_TOTAL));
    cotizacioncab.setImprePorcBonif(db.getMoney(DBCotizacionCab.IMPRE_PORC_BONIF));
    cotizacioncab.setImprePorcRecar(db.getMoney(DBCotizacionCab.IMPRE_PORC_RECAR));
    cotizacioncab.setConcImpIVA(ConceptoImpuesto.findByOidProxy(db.getInteger(DBCotizacionCab.OID_CONC_IVA),getSesion()));
    cotizacioncab.setConcImpPercIVA(ConceptoImpuesto.findByOidProxy(db.getInteger(DBCotizacionCab.OID_CONC_PERC_IVA),getSesion()));
    cotizacioncab.setConcImpPercIB(ConceptoImpuesto.findByOidProxy(db.getInteger(DBCotizacionCab.OID_CONC_PERC_IB),getSesion()));
    cotizacioncab.setConcImpInt(ConceptoImpuesto.findByOidProxy(db.getInteger(DBCotizacionCab.OID_CONC_IMP_INT),getSesion()));
    cotizacioncab.setNetoGravado(db.getMoney(DBCotizacionCab.NETO_GRAVADO));
    cotizacioncab.setNetoNoGravado(db.getMoney(DBCotizacionCab.NETO_NO_GRAVADO));
    cotizacioncab.setNetoGravadoMonLoc(db.getMoney(DBCotizacionCab.NETO_GRAV_LOC));
    cotizacioncab.setNetoNoGravadoMonLoc(db.getMoney(DBCotizacionCab.NETO_NO_GRAV_LOC));
    cotizacioncab.setFecValidez(db.getDate(DBCotizacionCab.FEC_VALIDEZ));
    cotizacioncab.setCotizMonFact(db.getValorCotizacion(DBCotizacionCab.COTIZ_MONEDA_FACT));
    cotizacioncab.setComporCotizFact(db.getString(DBCotizacionCab.COMPOR_COTIZ_FACT));
    
    cotizacioncab.setIva2(db.getMoney(DBCotizacionCab.IVA_2));
    cotizacioncab.setImpre_iva2(db.getMoney(DBCotizacionCab.IMPRE_IVA_2));
    cotizacioncab.setConcImpIVA2(ConceptoImpuesto.findByOidProxy(db.getInteger(DBCotizacionCab.OID_CONC_IVA_2),getSesion()));
    cotizacioncab.setIva2MonLoc(db.getMoney(DBCotizacionCab.IVA_2_MON_LOC));
    cotizacioncab.setEstadoPresupuesto(EstadoPresupuestoCliente.findByOidProxy(db.getInteger(DBCotizacionCab.OID_ESTADO_PRESU),getSesion()));
    cotizacioncab.setMotivoEstadoPresuCliente(MotivoEstadoPresuCliente.findByOidProxy(db.getInteger(DBCotizacionCab.OID_MOTIVO_PRESU),getSesion()));
    
  }
}
