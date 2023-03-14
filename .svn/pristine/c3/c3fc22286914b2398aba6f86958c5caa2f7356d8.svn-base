package com.srn.erp.stock.bl.Factory;

import com.srn.erp.compras.bm.Proveedor;
import com.srn.erp.contabilidad.bm.Cuenta;
import com.srn.erp.contabilidad.bm.CuentaImputable;
import com.srn.erp.ctasAPagar.bm.ConcFactProv;
import com.srn.erp.stock.bm.Producto;
import com.srn.erp.stock.bm.TipoProducto;
import com.srn.erp.stock.bm.UnidadMedida;
import com.srn.erp.stock.da.DBProducto;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryProducto extends FactoryObjetoLogico {

  public FactoryProducto() {
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    Producto producto = (Producto) objLog;
    producto.setOID(db.getInteger(DBProducto.OID_PRODUCTO));
    producto.setCodigo(db.getString(DBProducto.CODIGO));
    producto.setDescripcion(db.getString(DBProducto.DESCRIPCION));
    producto.setDesc_abrev(db.getString(DBProducto.DESC_ABREV));
    producto.setComprable(db.getBoolean(DBProducto.COMPRABLE));
    producto.setVendible(db.getBoolean(DBProducto.VENDIBLE));
    producto.setStockeable(db.getBoolean(DBProducto.STOCKEABLE));
    producto.setProd_propia(db.getBoolean(DBProducto.PROD_PROPIA));
    producto.setImportado(db.getBoolean(DBProducto.IMPORTADO));
    producto.setSinonimo(db.getString(DBProducto.SINONIMO));
    producto.setCodigo_barra(db.getString(DBProducto.CODIGO_BARRA));
    producto.setUm_vta(UnidadMedida.findByOidProxy(db.getInteger(DBProducto.OID_UM_VTA),getSesion()));
    producto.setUm_stk(UnidadMedida.findByOidProxy(db.getInteger(DBProducto.OID_UM_STK),getSesion()));
    producto.setUm_stk_alt(UnidadMedida.findByOidProxy(db.getInteger(DBProducto.OID_UM_STK_ALT),getSesion()));
    producto.setUm_cpra(UnidadMedida.findByOidProxy(db.getInteger(DBProducto.OID_UM_CPRA),getSesion()));
    producto.setUm_prod(UnidadMedida.findByOidProxy(db.getInteger(DBProducto.OID_UM_PROD),getSesion()));
    producto.setTolerancia_recep(db.getMoney(DBProducto.TOLERANCIA_RECEP));
    producto.setPorc_cump_oc(db.getMoney(DBProducto.PORC_CUMP_OC));
    producto.setSistema_calidad(db.getBoolean(DBProducto.SISTEMA_CALIDAD));
    producto.setCuenta_cpra(Cuenta.findByOidProxy(db.getInteger(DBProducto.OID_ANA_CON_CPRA),getSesion()));
    producto.setModif_ai_cpra(db.getBoolean(DBProducto.MODIF_AI_CPRA));
    producto.setActivo(db.getBoolean(DBProducto.ACTIVO));
    producto.setTipoproducto(TipoProducto.findByOidProxy(db.getInteger(DBProducto.OID_TIPO_PROD),getSesion()));
    producto.setLt_entrega(db.getInteger(DBProducto.LT_ENTREGA));
    producto.setConcFactProv(ConcFactProv.findByOidProxy(db.getInteger(DBProducto.OID_CONC_FACT_PROV),getSesion()));
    producto.setLlevaPartida(db.getBoolean(DBProducto.LLEVA_PARTIDA));
    producto.setLlevaSerie(db.getBoolean(DBProducto.LLEVA_SERIE));
    producto.addOidValorClasif(new Integer(1),db.getInteger(DBProducto.OID_CLASIF_01));
    producto.addOidValorClasif(new Integer(2),db.getInteger(DBProducto.OID_CLASIF_02));
    producto.addOidValorClasif(new Integer(3),db.getInteger(DBProducto.OID_CLASIF_03));
    producto.addOidValorClasif(new Integer(4),db.getInteger(DBProducto.OID_CLASIF_04));
    producto.addOidValorClasif(new Integer(5),db.getInteger(DBProducto.OID_CLASIF_05));
    producto.addOidValorClasif(new Integer(6),db.getInteger(DBProducto.OID_CLASIF_06));
    producto.addOidValorClasif(new Integer(7),db.getInteger(DBProducto.OID_CLASIF_07));
    producto.addOidValorClasif(new Integer(8),db.getInteger(DBProducto.OID_CLASIF_08));
    producto.addOidValorClasif(new Integer(9),db.getInteger(DBProducto.OID_CLASIF_09));
    producto.addOidValorClasif(new Integer(10),db.getInteger(DBProducto.OID_CLASIF_10));
    producto.addOidValorClasif(new Integer(11),db.getInteger(DBProducto.OID_CLASIF_11));
    producto.addOidValorClasif(new Integer(12),db.getInteger(DBProducto.OID_CLASIF_12));
    producto.addOidValorClasif(new Integer(13),db.getInteger(DBProducto.OID_CLASIF_13));
    producto.addOidValorClasif(new Integer(14),db.getInteger(DBProducto.OID_CLASIF_14));
    producto.addOidValorClasif(new Integer(15),db.getInteger(DBProducto.OID_CLASIF_15));
    producto.addOidValorClasif(new Integer(16),db.getInteger(DBProducto.OID_CLASIF_16));
    producto.addOidValorClasif(new Integer(17),db.getInteger(DBProducto.OID_CLASIF_17));
    producto.addOidValorClasif(new Integer(18),db.getInteger(DBProducto.OID_CLASIF_18));
    producto.addOidValorClasif(new Integer(19),db.getInteger(DBProducto.OID_CLASIF_19));
    producto.addOidValorClasif(new Integer(20),db.getInteger(DBProducto.OID_CLASIF_20));
    producto.setNro(db.getInteger(DBProducto.NRO));
    producto.setCuentaVenta(CuentaImputable.findByOidProxy(db.getInteger(DBProducto.OID_ANA_CON_VTA),getSesion()));
    producto.setCantDecPrecioVta(db.getInteger(DBProducto.CANT_DEC_PV));
    producto.setLeadTimeVta(db.getInteger(DBProducto.LEAD_TIME_VTA));
    producto.setDesc_abrev(db.getString(DBProducto.DESC_ABREV));
    producto.setPrecioNoDefLP(db.getBoolean(DBProducto.PRECIO_NO_DEF_LP).booleanValue());
    producto.setHabilitadaNotaDebitoInterna(db.getBoolean(DBProducto.HAB_ND_INT).booleanValue());
    producto.setHabilitadaNotaCreditoInterna(db.getBoolean(DBProducto.HAB_NC_INT).booleanValue());
    producto.setCalcPercIBBsAs(db.getBoolean(DBProducto.CALC_PERC_IB_BA).booleanValue());
    producto.setCalcPercIBCapFed(db.getBoolean(DBProducto.CALC_PERC_IB_CF).booleanValue());
    producto.setCalcPercIVA(db.getBoolean(DBProducto.CALC_PERC_IVA).booleanValue());
    producto.setModifPrecioFactura(db.getBoolean(DBProducto.MODIF_PRECIO_FACT).booleanValue());
    producto.setSeguimientoStock(db.getBoolean(DBProducto.SEGUI_STOCK).booleanValue());
    producto.setUsaParaSaldoPendFactSenia(db.getBoolean(DBProducto.ES_SALDO_PEND_SENIA).booleanValue());
    producto.setIsSeniaFactura(db.getBoolean(DBProducto.ES_SENIA_FACTURA).booleanValue());
    producto.setTomarPrecioOC1(db.getString(DBProducto.TOMAR_PRECIO_OC_1));
    producto.setTomarPrecioOC2(db.getString(DBProducto.TOMAR_PRECIO_OC_2));
    producto.setTomarPrecioOC3(db.getString(DBProducto.TOMAR_PRECIO_OC_3));
    producto.setTomarPrecioOC4(db.getString(DBProducto.TOMAR_PRECIO_OC_4));
    producto.setFormaCalcCosto(db.getString(DBProducto.FORMA_CALC_COSTO));
    producto.setProveedorCosto(Proveedor.findByOidProxy(db.getInteger(DBProducto.OID_PROV_COSTO),getSesion()));
    
  }
}
