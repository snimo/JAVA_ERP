package com.srn.erp.stock.bl.Factory;

import com.srn.erp.compras.bm.Proveedor;
import com.srn.erp.contabilidad.bm.Cuenta;
import com.srn.erp.contabilidad.bm.CuentaImputable;
import com.srn.erp.ctasAPagar.bm.ConcFactProv;
import com.srn.erp.general.bm.ClasificadorEntidad;
import com.srn.erp.general.bm.ValorClasificadorEntidad;
import com.srn.erp.stock.bm.ExtensionProdGen;
import com.srn.erp.stock.bm.TipoProducto;
import com.srn.erp.stock.bm.UnidadMedida;
import com.srn.erp.stock.da.DBExtensionProdGen;
import com.srn.erp.stock.da.DBProducto;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryExtensionProdGen extends FactoryObjetoLogico { 

  public FactoryExtensionProdGen() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
	  
    ExtensionProdGen extensionprodgen = (ExtensionProdGen) objLog;
    extensionprodgen.setOID(db.getInteger(DBExtensionProdGen.OID_EXTENSION_PG));
    extensionprodgen.setValor_clasif_ent(ValorClasificadorEntidad.findByOidProxy(db.getInteger(DBExtensionProdGen.OID_VAL_CLASIF_ENT),getSesion()));
    extensionprodgen.setClasificador(ClasificadorEntidad.findByOidProxy(db.getInteger(DBExtensionProdGen.OID_CLASIF_ENT),getSesion()));
    extensionprodgen.setConc_fact_prov(ConcFactProv.findByOidProxy(db.getInteger(DBExtensionProdGen.OID_CONC_FACT_PROV),getSesion()));
    
    extensionprodgen.setUMVta(UnidadMedida.findByOidProxy(db.getInteger(DBExtensionProdGen.OID_UM_VTAS),getSesion()));
    extensionprodgen.setUMCompra(UnidadMedida.findByOidProxy(db.getInteger(DBExtensionProdGen.OID_UM_COMPRA),getSesion()));
    extensionprodgen.setLTEntrega(db.getInteger(DBExtensionProdGen.LT_ENTREGA));
    extensionprodgen.setPrecioNoDefEnLP(db.getBoolean(DBExtensionProdGen.PRECIO_NO_DEF_LP));
    extensionprodgen.setModifPrecioFact(db.getBoolean(DBExtensionProdGen.MODIF_PREC_FACT));
    extensionprodgen.setCantDecPrecio(db.getInteger(DBExtensionProdGen.CANT_DEC_PRECIO));
    
    extensionprodgen.addOidValorClasif(new Integer(1),db.getInteger(DBProducto.OID_CLASIF_01));
    extensionprodgen.addOidValorClasif(new Integer(2),db.getInteger(DBProducto.OID_CLASIF_02));
    extensionprodgen.addOidValorClasif(new Integer(3),db.getInteger(DBProducto.OID_CLASIF_03));
    extensionprodgen.addOidValorClasif(new Integer(4),db.getInteger(DBProducto.OID_CLASIF_04));
    extensionprodgen.addOidValorClasif(new Integer(5),db.getInteger(DBProducto.OID_CLASIF_05));
    extensionprodgen.addOidValorClasif(new Integer(6),db.getInteger(DBProducto.OID_CLASIF_06));
    extensionprodgen.addOidValorClasif(new Integer(7),db.getInteger(DBProducto.OID_CLASIF_07));
    extensionprodgen.addOidValorClasif(new Integer(8),db.getInteger(DBProducto.OID_CLASIF_08));
    extensionprodgen.addOidValorClasif(new Integer(9),db.getInteger(DBProducto.OID_CLASIF_09));
    extensionprodgen.addOidValorClasif(new Integer(10),db.getInteger(DBProducto.OID_CLASIF_10));
    extensionprodgen.addOidValorClasif(new Integer(11),db.getInteger(DBProducto.OID_CLASIF_11));
    extensionprodgen.addOidValorClasif(new Integer(12),db.getInteger(DBProducto.OID_CLASIF_12));
    extensionprodgen.addOidValorClasif(new Integer(13),db.getInteger(DBProducto.OID_CLASIF_13));
    extensionprodgen.addOidValorClasif(new Integer(14),db.getInteger(DBProducto.OID_CLASIF_14));
    extensionprodgen.addOidValorClasif(new Integer(15),db.getInteger(DBProducto.OID_CLASIF_15));
    extensionprodgen.addOidValorClasif(new Integer(16),db.getInteger(DBProducto.OID_CLASIF_16));
    extensionprodgen.addOidValorClasif(new Integer(17),db.getInteger(DBProducto.OID_CLASIF_17));
    extensionprodgen.addOidValorClasif(new Integer(18),db.getInteger(DBProducto.OID_CLASIF_18));
    extensionprodgen.addOidValorClasif(new Integer(19),db.getInteger(DBProducto.OID_CLASIF_19));
    extensionprodgen.addOidValorClasif(new Integer(20),db.getInteger(DBProducto.OID_CLASIF_20));
    
    extensionprodgen.setTipoProducto(TipoProducto.findByOidProxy(db.getInteger(DBExtensionProdGen.OID_TIPO_PROD),getSesion()));
    extensionprodgen.setComprable(db.getBoolean(DBExtensionProdGen.COMPRABLE));
    extensionprodgen.setVendible(db.getBoolean(DBExtensionProdGen.VENDIBLE));
    extensionprodgen.setStockeable(db.getBoolean(DBExtensionProdGen.STOCKEABLE));
    extensionprodgen.setProdPropia(db.getBoolean(DBExtensionProdGen.PROD_PROPIA));
    extensionprodgen.setImportado(db.getBoolean(DBExtensionProdGen.IMPORTADO));
    
    extensionprodgen.setUMStockPpal(UnidadMedida.findByOidProxy(db.getInteger(DBExtensionProdGen.OID_UM_STOCK_PPAL),getSesion()));
    extensionprodgen.setUMStockAlt(UnidadMedida.findByOidProxy(db.getInteger(DBExtensionProdGen.OID_UM_STOCK_ALT),getSesion()));
    extensionprodgen.setLlevaSerie(db.getBoolean(DBExtensionProdGen.LLEVA_SERIE));
    extensionprodgen.setLlevaPartida(db.getBoolean(DBExtensionProdGen.LLEVA_PARTIDA));
    extensionprodgen.setSeguiStock(db.getBoolean(DBExtensionProdGen.SEGUI_STOCK));
    
    extensionprodgen.setUMProd(UnidadMedida.findByOidProxy(db.getInteger(DBExtensionProdGen.OID_UM_PROD),getSesion()));
    
    extensionprodgen.setSaldoFacturaSenia(db.getBoolean(DBExtensionProdGen.ES_SALDO_FACT_SENIA));
    extensionprodgen.setEsSenia(db.getBoolean(DBExtensionProdGen.ES_SENIA));
    extensionprodgen.setCuentaImputableVentas(CuentaImputable.findByOidProxy(db.getInteger(DBExtensionProdGen.OID_IMPU_VTA),getSesion()));
    
    extensionprodgen.setHabNCInt(db.getBoolean(DBExtensionProdGen.HAB_NC_INT));
    extensionprodgen.setHabNDInt(db.getBoolean(DBExtensionProdGen.HAB_ND_INT));
    
    extensionprodgen.setSuscPercIBBsAs(db.getBoolean(DBExtensionProdGen.CALC_PERC_IB_BA));
    extensionprodgen.setSuscPercIBCapFed(db.getBoolean(DBExtensionProdGen.CALC_PERC_IB_CF));
    extensionprodgen.setSuscPercIVA(db.getBoolean(DBExtensionProdGen.CALC_PERC_IVA));
    extensionprodgen.setSistemaCalidad(db.getBoolean(DBExtensionProdGen.SISTEMA_CALIDAD));
    
    extensionprodgen.setPorcCumpOC(db.getDouble(DBExtensionProdGen.PORC_CUMP_OC));
    extensionprodgen.setCuentaCompras(Cuenta.findByOidProxy(db.getInteger(DBExtensionProdGen.OID_CUENTA_COMPRAS),getSesion()));
    extensionprodgen.setPorcTolRecep(db.getDouble(DBExtensionProdGen.PORC_TOL_RECEP));
    extensionprodgen.setLTProveedor(db.getInteger(DBExtensionProdGen.LT_ENTREGA_PROV));
    
    extensionprodgen.setTomarPrecioOC1(db.getString(DBExtensionProdGen.TOMAR_PRECIO_OC_1));
    extensionprodgen.setTomarPrecioOC2(db.getString(DBExtensionProdGen.TOMAR_PRECIO_OC_2));
    extensionprodgen.setTomarPrecioOC3(db.getString(DBExtensionProdGen.TOMAR_PRECIO_OC_3));
    extensionprodgen.setTomarPrecioOC4(db.getString(DBExtensionProdGen.TOMAR_PRECIO_OC_4));
    
    extensionprodgen.setFormaCalcCosto(db.getString(DBExtensionProdGen.FORMA_CALC_COSTO));
    extensionprodgen.setProveedorCosto(Proveedor.findByOidProxy(db.getInteger(DBExtensionProdGen.OID_PROV_COSTO),getSesion()));
    extensionprodgen.setComoObtenerCosto(db.getString(DBExtensionProdGen.COMO_OBTENER_COSTO));
    
  }
}
