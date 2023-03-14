package com.srn.erp.ventas.op;

import java.util.Iterator;

import com.srn.erp.general.bm.ClasificadorEntidad;
import com.srn.erp.general.bm.ValorClasificadorEntidad;
import com.srn.erp.impuestos.bm.ConceptoImpuesto;
import com.srn.erp.stock.bm.ConceptoImpuestoProducto;
import com.srn.erp.stock.bm.Producto;
import com.srn.erp.stock.bm.TipoProducto;
import com.srn.erp.stock.bm.UnidadMedida;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveConsultaMasivaProductos extends Operation {

	public SaveConsultaMasivaProductos() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		IDataSet dataset = mapaDatos.getDataSet("TProductos");
		procesarRegistros(dataset);
	}

	private void procesarRegistros(IDataSet dataset) throws BaseException {
		dataset.first();
		while (!dataset.EOF()) {

			Producto producto = getProducto(dataset);
			producto.setCodigo(dataset.getString("cod_producto"));
			producto.setDescripcion(dataset.getString("desc_producto"));
			producto.setDesc_abrev(dataset.getString("desc_abrev_producto"));
			producto.setTipoproducto(TipoProducto.findByOidProxy(dataset.getInteger("oid_tipo_producto"),this.getSesion()));
			producto.setComprable(dataset.getBoolean("comprable"));
			producto.setVendible(dataset.getBoolean("vendible"));
			producto.setStockeable(dataset.getBoolean("stockeable"));
			producto.setProd_propia(dataset.getBoolean("prod_propia"));
			producto.setImportado(dataset.getBoolean("importado"));
			producto.setSinonimo(dataset.getString("sinonimo"));
			producto.setCodigo_barra(dataset.getString("codigo_barra"));
			producto.setUm_cpra(UnidadMedida.findByOidProxy(dataset.getInteger("oid_um_compra"),this.getSesion()));
			producto.setPorc_cump_oc(dataset.getMoney("porc_cump_oc"));
			producto.setUm_vta(UnidadMedida.findByOidProxy(dataset.getInteger("oid_um_vta"),this.getSesion()));
			producto.setLeadTimeVta(dataset.getInteger("lead_time_ent_vta"));
			producto.setFormaCalcCosto(dataset.getString("cod_forma_calc_costo"));
			
			producto.setCalcPercIBBsAs(true);
			producto.setCalcPercIBCapFed(true);
			
			// Ver el Tema de los conceptos de Impuestos IVA
			
			ConceptoImpuestoProducto concImpuProd =
				(ConceptoImpuestoProducto) ConceptoImpuestoProducto.getNew(ConceptoImpuestoProducto.NICKNAME,this.getSesion());
			concImpuProd.setFecha_vigencia(dataset.getDate("fec_vig_imp_vtas"));
			concImpuProd.setConcepto_impuesto(ConceptoImpuesto.findByOidProxy(dataset.getInteger("oid_impu_iva"),this.getSesion()));
			concImpuProd.setProducto(producto);
			producto.addConceptoImpuesto(concImpuProd);
			
			producto.setUm_stk(UnidadMedida.findByOidProxy(dataset.getInteger("oid_um_stk_ppal"),this.getSesion()));
			producto.setUm_stk_alt(UnidadMedida.findByOidProxy(dataset.getInteger("oid_um_stk_alt"),this.getSesion()));
			producto.setUm_prod(UnidadMedida.findByOidProxy(dataset.getInteger("oid_um_stk_prod"),this.getSesion()));
			producto.setActivo(dataset.getBoolean("activo"));
			
			// Actualizar los clasificadores			
			Iterator iterClasifEnt = Producto.getClasificadoresEntidad(this.getSesion()).iterator();
			while (iterClasifEnt.hasNext()) {
				ClasificadorEntidad clasifEnt = (ClasificadorEntidad) iterClasifEnt.next();
				ValorClasificadorEntidad valor = ValorClasificadorEntidad.findByOidProxy(dataset.getInteger("oid_clasif_" + clasifEnt.getOIDInteger()),this.getSesion());
				if (valor!=null)
					producto.addOidValorClasif(clasifEnt.getNroClasif(),valor.getOIDInteger());
				else
					producto.addOidValorClasif(clasifEnt.getNroClasif(),null);
			}
			
			

			
			
			addTransaccion(producto);
			dataset.next();
		}
	}

	private Producto getProducto(IDataSet dataset) throws BaseException {
		Producto producto = null;
		if ((dataset.getInteger("oid_producto")!=null) && (dataset.getInteger("oid_producto").intValue() > 0))
			producto = Producto.findByOid(dataset.getInteger("oid_producto"), this.getSesion());
		else {
			// Buscar el producto por codigo, si no lo encuentra crear uno nuevo
			producto = Producto.findByCodigo(dataset.getString("cod_producto"), this.getSesion());
			if (producto == null)
				producto = (Producto) Producto.getNew(Producto.NICKNAME, this.getSesion());
		}
		return producto;
	}

}
