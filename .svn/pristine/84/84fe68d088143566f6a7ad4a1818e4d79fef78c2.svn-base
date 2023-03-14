package com.srn.erp.compras.bl.Factory;

import com.srn.erp.compras.bm.CondCompraImportacion;
import com.srn.erp.compras.bm.CondicionCompra;
import com.srn.erp.compras.bm.LugarEntrega;
import com.srn.erp.compras.bm.OrdenDeCompraCab;
import com.srn.erp.compras.bm.Proveedor;
import com.srn.erp.compras.bm.SectorCompra;
import com.srn.erp.compras.bm.ViaDespacho;
import com.srn.erp.compras.da.DBOrdenDeCompraCab;
import com.srn.erp.general.bm.LugarEmision;
import com.srn.erp.general.bm.Moneda;
import com.srn.erp.general.bm.Sucursal;
import com.srn.erp.general.bm.Talonario;
import com.srn.erp.general.bm.TipoComprobante;
import com.srn.erp.general.da.DBComproCab;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bm.Seguridad.Usuario;
import framework.request.bl.Utils.BaseException;

public class FactoryOrdenDeCompraCab extends FactoryObjetoLogico { 

  public FactoryOrdenDeCompraCab() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    OrdenDeCompraCab ordendecompracab = (OrdenDeCompraCab) objLog;
    ordendecompracab.setOID(db.getInteger(DBOrdenDeCompraCab.OID_OC));
    
    
    // Por comproCab
    ordendecompracab.setTipoCompro(TipoComprobante.findByOidProxy(db.getInteger(DBComproCab.OID_TC),getSesion()));
    ordendecompracab.setTalonario(Talonario.findByOidProxy(db.getInteger(DBComproCab.OID_TALONARIO),getSesion()));
    ordendecompracab.setTcExt(db.getString(DBComproCab.TC_EXT));
    ordendecompracab.setLetra(db.getString(DBComproCab.LETRA));
    ordendecompracab.setLugarEmision(LugarEmision.findByOidProxy(db.getInteger(DBComproCab.OID_LUG_EMI),getSesion()));
    ordendecompracab.setNrolugemision(db.getInteger(DBComproCab.LUG_EMI));
    ordendecompracab.setNroext(db.getInteger(DBComproCab.NROEXT));
    ordendecompracab.setEmision(db.getDate(DBComproCab.EMISION));
    ordendecompracab.setEstado(db.getString(DBComproCab.ESTADO));
    ordendecompracab.setComentario(db.getString(DBComproCab.COMENTARIO));
    ordendecompracab.setFecAlta(db.getDate(DBComproCab.FEC_ALTA));
    ordendecompracab.setUsuario(Usuario.findByOidProxy(db.getInteger(DBComproCab.OID_USUARIO),getSesion()));
    ordendecompracab.setActivo(db.getBoolean(DBComproCab.ACTIVO));    
    ordendecompracab.setSucursal(Sucursal.findByOidProxy(db.getInteger(DBComproCab.OID_SUCURSAL),getSesion()));
    
    ordendecompracab.setAgrupaItemsImpresion(db.getBoolean(DBOrdenDeCompraCab.AGRUPA_ITEMS_IMPRE));
    ordendecompracab.setProveedor(Proveedor.findByOidProxy(db.getInteger(DBOrdenDeCompraCab.OID_PROVEEDOR),getSesion()));
    ordendecompracab.setImportacion(db.getBoolean(DBOrdenDeCompraCab.IMPORTACION));
    ordendecompracab.setEnviada(db.getBoolean(DBOrdenDeCompraCab.ENVIADA));
    ordendecompracab.setFecha_envio(db.getDate(DBOrdenDeCompraCab.FEC_ENVIO));
    ordendecompracab.setConfirmo_recepcion(db.getBoolean(DBOrdenDeCompraCab.CONFIRMO_RECEP));
    ordendecompracab.setFecha_confirmo_recepcion(db.getDate(DBOrdenDeCompraCab.FEC_CONFIRMO_RECEP));
    ordendecompracab.setVia_despacho(ViaDespacho.findByOidProxy(db.getInteger(DBOrdenDeCompraCab.OID_VIA_DESPACHO),getSesion()));
    ordendecompracab.setCond_compra_importacion(CondCompraImportacion.findByOidProxy(db.getInteger(DBOrdenDeCompraCab.OID_COND_CPRA_IMP),getSesion()));
    ordendecompracab.setFec_estado_autorizacion(db.getDate(DBOrdenDeCompraCab.FEC_EST_AUTORIZ));
    ordendecompracab.setCond_pago_2(CondicionCompra.findByOidProxy(db.getInteger(DBOrdenDeCompraCab.OID_COND_PAGO_2),getSesion()));
    ordendecompracab.setCond_pago_1(CondicionCompra.findByOidProxy(db.getInteger(DBOrdenDeCompraCab.OID_COND_PAGO_1),getSesion()));
    ordendecompracab.setObservaciones_generales(db.getString(DBOrdenDeCompraCab.OBS_GENERALES));
    ordendecompracab.setEstado_autorizacion(db.getInteger(DBOrdenDeCompraCab.ESTADO_AUTORIZ));
    ordendecompracab.setMoneda(Moneda.findByOidProxy(db.getInteger(DBOrdenDeCompraCab.OID_MONEDA),getSesion()));
    ordendecompracab.setTipo(db.getString(DBOrdenDeCompraCab.TIPO_OC));
    ordendecompracab.setTomar_precio_de(db.getString(DBOrdenDeCompraCab.TOMAR_PRECIOS_DE));
    ordendecompracab.setDto_1_1(db.getDouble(DBOrdenDeCompraCab.DTO_1_1));
    ordendecompracab.setDto_1_2(db.getDouble(DBOrdenDeCompraCab.DTO_1_2));
    ordendecompracab.setDto_1_3(db.getDouble(DBOrdenDeCompraCab.DTO_1_3));
    ordendecompracab.setDto_2_1(db.getDouble(DBOrdenDeCompraCab.DTO_2_1));
    ordendecompracab.setDto_2_2(db.getDouble(DBOrdenDeCompraCab.DTO_2_2));
    ordendecompracab.setDto_2_3(db.getDouble(DBOrdenDeCompraCab.DTO_2_3));
    ordendecompracab.setDtoEnCasacada(db.getBoolean(DBOrdenDeCompraCab.DTO_EN_CASCADA));
    ordendecompracab.setPorcRecargo(db.getPorcentaje(DBOrdenDeCompraCab.PORC_RECARGO));
    ordendecompracab.setCotizacion(db.getValorCotizacion(DBOrdenDeCompraCab.COTIZACION));
    ordendecompracab.setSectorCompra(SectorCompra.findByOidProxy(db.getInteger(DBOrdenDeCompraCab.OID_SECTOR_COMPRA),getSesion()));
    ordendecompracab.setLugarEntrega(LugarEntrega.findByOidProxy(db.getInteger(DBOrdenDeCompraCab.OID_LUGAR_ENT),getSesion()));
  }
  
}
