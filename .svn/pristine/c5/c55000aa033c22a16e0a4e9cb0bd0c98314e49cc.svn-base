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
import com.srn.erp.ventas.bm.FormaEntrega;
import com.srn.erp.ventas.bm.ListaPrecios;
import com.srn.erp.ventas.bm.PedidoCab;
import com.srn.erp.ventas.bm.Proyecto;
import com.srn.erp.ventas.bm.Sujeto;
import com.srn.erp.ventas.bm.UnidadEdilicia;
import com.srn.erp.ventas.bm.Vendedor;
import com.srn.erp.ventas.da.DBCondicionPago;
import com.srn.erp.ventas.da.DBPedidoCab;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bm.Seguridad.Usuario;
import framework.request.bl.Utils.BaseException;

public class FactoryPedidoCab extends FactoryObjetoLogico {

  public FactoryPedidoCab() {
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    PedidoCab pedidocab = (PedidoCab) objLog;
    pedidocab.setOID(db.getInteger(DBPedidoCab.OID_CCO_PED));

    // Por comproCab
    pedidocab.setTalonario(Talonario.findByOidProxy(db.getInteger(DBComproCab.OID_TALONARIO),getSesion()));
    pedidocab.setTipoCompro(TipoComprobante.findByOidProxy(db.getInteger(DBComproCab.OID_TC),getSesion()));
    pedidocab.setTcExt(db.getString(DBComproCab.TC_EXT));
    pedidocab.setLetra(db.getString(DBComproCab.LETRA));
    pedidocab.setLugarEmision(LugarEmision.findByOidProxy(db.getInteger(DBComproCab.OID_LUG_EMI),getSesion()));
    pedidocab.setNrolugemision(db.getInteger(DBComproCab.LUG_EMI));
    pedidocab.setNroext(db.getInteger(DBComproCab.NROEXT));
    pedidocab.setEmision(db.getDate(DBComproCab.EMISION));
    pedidocab.setEstado(db.getString(DBComproCab.ESTADO));
    pedidocab.setComentario(db.getString(DBComproCab.COMENTARIO));
    pedidocab.setFecAlta(db.getDate(DBComproCab.FEC_ALTA));
    pedidocab.setUsuario(Usuario.findByOidProxy(db.getInteger(DBComproCab.OID_USUARIO),getSesion()));
    pedidocab.setActivo(db.getBoolean(DBComproCab.ACTIVO));
    pedidocab.setSucursal(Sucursal.findByOidProxy(db.getInteger(DBComproCab.OID_SUCURSAL),getSesion()));
    pedidocab.setComportamiento(db.getString(DBComproCab.COMPORTAMIENTO));
    

    pedidocab.setSujeto(Sujeto.findByOidProxy(db.getInteger(DBPedidoCab.OID_SUJETO),getSesion()));
    pedidocab.setMoneda(Moneda.findByOidProxy(db.getInteger(DBPedidoCab.OID_MONEDA),getSesion()));
    pedidocab.setCotizacion(db.getValorCotizacion(DBPedidoCab.COTIZACION));
    pedidocab.setCotizMonFact(db.getValorCotizacion(DBPedidoCab.COTIZ_MON_FACT));
    pedidocab.setMercado(db.getString(DBPedidoCab.MERCADO));
    pedidocab.setPorc_bonif_cli(db.getDouble(DBPedidoCab.PORC_BONIF_CLI));
    pedidocab.setPorc_reca_cli(db.getDouble(DBPedidoCab.PORC_RECA_CLI));
    pedidocab.setBonif_cli_cascada(db.getBoolean(DBPedidoCab.BONIF_CLI_CASCADA));
    pedidocab.setReca_cli_cascada(db.getBoolean(DBPedidoCab.RECA_CLI_CASCADA));
    pedidocab.setLista_precios(ListaPrecios.findByOidProxy(db.getInteger(DBPedidoCab.OID_PRECIO_CAB),getSesion()));
    pedidocab.setCondicionPago(CondicionPago.findByOidProxy(db.getInteger(DBCondicionPago.OID_COND_PAGO),getSesion()));
    pedidocab.setVendedor(Vendedor.findByOidProxy(db.getInteger(DBPedidoCab.OID_VENDEDOR),getSesion()));
    pedidocab.setDomicilio_entrega(UnidadEdilicia.findByOidProxy(db.getInteger(DBPedidoCab.OID_UNI_EDI),getSesion()));
    pedidocab.setProyecto(Proyecto.findByOidProxy(db.getInteger(DBPedidoCab.OID_PROYECTO),getSesion()));
    pedidocab.setPorc_bonif_cp(db.getDouble(DBPedidoCab.PORC_BONIF_CP));
    pedidocab.setPorc_reca_cp(db.getDouble(DBPedidoCab.PORC_RECA_CP));
    pedidocab.setBonif_cp_cascada(db.getBoolean(DBPedidoCab.BONIF_CP_CASCADA));
    pedidocab.setOrdenDeCompra(db.getString(DBPedidoCab.ORDEN_COMPRA));
    pedidocab.setReca_cp_cascada(db.getBoolean(DBPedidoCab.RECA_CP_CASCADA));
    pedidocab.setObservado(db.getBoolean(DBPedidoCab.OBSERVADO));
    pedidocab.setComentario(db.getString(DBPedidoCab.COMENTARIO));
    pedidocab.setPendEnt(db.getBoolean(DBPedidoCab.PEND_ENT));
    pedidocab.setPendFact(db.getBoolean(DBPedidoCab.PEND_FACT));
    pedidocab.setTransporte(Transporte.findByOidProxy(db.getInteger(DBPedidoCab.OID_TRANSPORTE),getSesion()));
    pedidocab.setFormaEntrega(FormaEntrega.findByOidProxy(db.getInteger(DBPedidoCab.OID_FORMA_ENTREGA),getSesion()));
    pedidocab.setMonedaFact(Moneda.findByOidProxy(db.getInteger(DBPedidoCab.OID_MONEDA_FACT),getSesion()));
    pedidocab.setPendDesp(db.getBoolean(DBPedidoCab.PEND_DESP));
    pedidocab.setContactoSujeto(ContactoSujeto.findByOidProxy(db.getInteger(DBPedidoCab.OID_CONTACTO),getSesion()));
    pedidocab.setPuedeAnularSinControl(db.getBoolean(DBPedidoCab.PUEDE_ANULAR_SC));
    
    pedidocab.setBruto(db.getMoney(DBPedidoCab.BRUTO));
    pedidocab.setPorc_dto(db.getPorcentaje(DBPedidoCab.PORC_DTO));
    pedidocab.setDescuento(db.getMoney(DBPedidoCab.DESCUENTO));
    pedidocab.setPorc_recar(db.getPorcentaje(DBPedidoCab.PORC_RECAR));
    pedidocab.setRecargo(db.getMoney(DBPedidoCab.RECARGO));
    pedidocab.setNeto(db.getMoney(DBPedidoCab.NETO));
    pedidocab.setIva(db.getMoney(DBPedidoCab.IVA));
    pedidocab.setPerc_iva(db.getMoney(DBPedidoCab.PERC_IVA));
    pedidocab.setImp_internos(db.getMoney(DBPedidoCab.IMP_INTERNOS));
    pedidocab.setPerc_ib(db.getMoney(DBPedidoCab.PERC_IB));
    pedidocab.setTotal(db.getMoney(DBPedidoCab.TOTAL));
    pedidocab.setImpre_bruto(db.getMoney(DBPedidoCab.IMPRE_BRUTO));
    pedidocab.setImpre_bonif(db.getMoney(DBPedidoCab.IMPRE_BONIF));
    pedidocab.setImpre_recar(db.getMoney(DBPedidoCab.IMPRE_RECAR));
    pedidocab.setImpre_neto(db.getMoney(DBPedidoCab.IMPRE_NETO));
    pedidocab.setImpre_iva(db.getMoney(DBPedidoCab.IMPRE_IVA));
    pedidocab.setImpre_perc_iva(db.getMoney(DBPedidoCab.IMPRE_PERC_IVA));
    pedidocab.setImpre_perc_ib(db.getMoney(DBPedidoCab.IMPRE_PERC_IB));
    pedidocab.setImpre_imp_int(db.getMoney(DBPedidoCab.IMPRE_IMP_INT));
    pedidocab.setImpre_total(db.getMoney(DBPedidoCab.IMPRE_TOTAL));
    pedidocab.setImprePorcBonif(db.getMoney(DBPedidoCab.IMPRE_PORC_BONIF));
    pedidocab.setImprePorcRecar(db.getMoney(DBPedidoCab.IMPRE_PORC_RECAR));
    pedidocab.setConcImpIVA(ConceptoImpuesto.findByOidProxy(db.getInteger(DBPedidoCab.OID_CONC_IVA),getSesion()));
    pedidocab.setConcImpPercIVA(ConceptoImpuesto.findByOidProxy(db.getInteger(DBPedidoCab.OID_CONC_PERC_IVA),getSesion()));
    pedidocab.setConcImpPercIB(ConceptoImpuesto.findByOidProxy(db.getInteger(DBPedidoCab.OID_CONC_PERC_IB),getSesion()));
    pedidocab.setConcImpInt(ConceptoImpuesto.findByOidProxy(db.getInteger(DBPedidoCab.OID_CONC_IMP_INT),getSesion()));
    pedidocab.setNetoGravado(db.getMoney(DBPedidoCab.NETO_GRAVADO));
    pedidocab.setNetoNoGravado(db.getMoney(DBPedidoCab.NETO_NO_GRAVADO));
    pedidocab.setNetoGravadoMonLoc(db.getMoney(DBPedidoCab.NETO_GRAV_LOC));
    pedidocab.setNetoNoGravadoMonLoc(db.getMoney(DBPedidoCab.NETO_NO_GRAV_LOC));
    pedidocab.setComporCotizFact(db.getString(DBPedidoCab.COMPOR_COTIZ_FACT));
    
    pedidocab.setIva2(db.getMoney(DBPedidoCab.IVA_2));
    pedidocab.setIvaMonLoc2(db.getMoney(DBPedidoCab.IVA_2_MON_LOC));
    pedidocab.setConcImpIVA2(ConceptoImpuesto.findByOidProxy(db.getInteger(DBPedidoCab.OID_CONC_IVA_2),getSesion()));
    pedidocab.setImpre_iva2(db.getMoney(DBPedidoCab.IMPRE_IVA_2));
    
    
    
    
    
    
  }
}
  