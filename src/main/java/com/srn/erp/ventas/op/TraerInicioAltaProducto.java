package com.srn.erp.ventas.op;

import com.srn.erp.compras.bm.Proveedor;
import com.srn.erp.general.bm.Precio;
import com.srn.erp.impuestos.bm.ConceptoImpuesto;
import com.srn.erp.stock.bm.Producto;
import com.srn.erp.stock.bm.UnidadMedida;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerInicioAltaProducto extends Operation {

  public TraerInicioAltaProducto() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    IDataSet datasetValoresDefault = this.getDataSetValoresDefalutProducto();
    cargarRegistro(datasetValoresDefault);
    writeCliente(datasetValoresDefault);
  }

  private IDataSet getDataSetValoresDefalutProducto() {
    IDataSet dataset = new TDataSet();
    dataset.create("TValoresDefProducto");
    dataset.fieldDef(new Field("oid_tipo_producto", Field.INTEGER, 0));
    dataset.fieldDef(new Field("es_comprable", Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("es_vendible", Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("es_stockeable", Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("oid_um_compra", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_um_venta", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_um_stk_ppal", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_um_stk_alt", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_um_prod", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cant_dec", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_conc_impu_iva", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_conc_impu_iva", Field.STRING, 50));
    dataset.fieldDef(new Field("desc_conc_impu_iva", Field.STRING, 100));
    dataset.fieldDef(new Field("forma_default_calc_costo", Field.STRING, 50));
    dataset.fieldDef(new Field("oid_prov_form_calc_costo", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_prov_form_calc_costo", Field.STRING, 50));
    dataset.fieldDef(new Field("desc_prov_form_calc_costo", Field.STRING, 100));
    dataset.fieldDef(new Field("forma_tomar_precio_oc_opc_1", Field.STRING, 100));
    dataset.fieldDef(new Field("forma_tomar_precio_oc_opc_2", Field.STRING, 100));
    dataset.fieldDef(new Field("forma_tomar_precio_oc_opc_3", Field.STRING, 100));
    dataset.fieldDef(new Field("forma_tomar_precio_oc_opc_4", Field.STRING, 100));
    
    
    
    
    return dataset;
  }

  private void cargarRegistro(IDataSet dataset) throws BaseException  {
    dataset.append();
    
    dataset.fieldValue("oid_tipo_producto", Producto.getTipoProductoDefault(this.getSesion()).getOID());
    dataset.fieldValue("es_comprable", new Boolean(Producto.isSugerirProdComprable(this.getSesion())));
    dataset.fieldValue("es_vendible", new Boolean(Producto.isSugerirProdVendible(this.getSesion())));
    dataset.fieldValue("es_stockeable", new Boolean(Producto.isSugerirProdStockeable(this.getSesion())));
    dataset.fieldValue("oid_um_compra", UnidadMedida.getSugerenciaUMCompra(this.getSesion()).getOIDInteger());
    dataset.fieldValue("oid_um_venta", UnidadMedida.getSugerenciaUMVenta(this.getSesion()).getOIDInteger());
    dataset.fieldValue("oid_um_stk_ppal", UnidadMedida.getSugerenciaUMStockPPal(this.getSesion()).getOIDInteger());
    dataset.fieldValue("oid_um_stk_alt", UnidadMedida.getSugerenciaUMStockAlt(this.getSesion()).getOIDInteger());
    dataset.fieldValue("oid_um_prod", UnidadMedida.getSugerenciaUMProduccion(this.getSesion()).getOIDInteger());
    dataset.fieldValue("cant_dec", Precio.getSugerenciaCantDecPrecioVenta(this.getSesion()));
    dataset.fieldValue("oid_conc_impu_iva", ConceptoImpuesto.getSugerenciaConcImpIVA(this.getSesion()).getOIDInteger());
    dataset.fieldValue("cod_conc_impu_iva", ConceptoImpuesto.getSugerenciaConcImpIVA(this.getSesion()).getCodigo());
    dataset.fieldValue("desc_conc_impu_iva", ConceptoImpuesto.getSugerenciaConcImpIVA(this.getSesion()).getDescripcion());
    dataset.fieldValue("forma_default_calc_costo", Producto.getFormaDefaultCalcCosto(this.getSesion()));
    
    Proveedor proveedor = Producto.getProveedorDefaultCalcCosto(this.getSesion());
    
    if (proveedor!=null) {
    	dataset.fieldValue("oid_prov_form_calc_costo", proveedor.getOIDInteger());
    	dataset.fieldValue("cod_prov_form_calc_costo", proveedor.getCodigo());
    	dataset.fieldValue("desc_prov_form_calc_costo", proveedor.getDescripcion());
    } else {
    	dataset.fieldValue("oid_prov_form_calc_costo", new Integer(0));
    	dataset.fieldValue("cod_prov_form_calc_costo", "");
    	dataset.fieldValue("desc_prov_form_calc_costo", "");
    }
    
    dataset.fieldValue("forma_tomar_precio_oc_opc_1", Producto.getFormaDefaultTomarPrecioOCOpcion(1, this.getSesion()));
    dataset.fieldValue("forma_tomar_precio_oc_opc_2", Producto.getFormaDefaultTomarPrecioOCOpcion(2, this.getSesion()));
    dataset.fieldValue("forma_tomar_precio_oc_opc_3", Producto.getFormaDefaultTomarPrecioOCOpcion(3, this.getSesion()));
    dataset.fieldValue("forma_tomar_precio_oc_opc_4", Producto.getFormaDefaultTomarPrecioOCOpcion(4, this.getSesion()));
    
  }
}
