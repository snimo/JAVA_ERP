package com.srn.erp.stock.op;

import com.srn.erp.general.bm.ClasificadorEntidad;
import com.srn.erp.general.bm.ValorClasifEntProdGen;
import com.srn.erp.stock.bm.Producto;

import framework.applicarionServer.bm.Varios.Money;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class ValidarProducto extends Operation {

	
	private boolean comprable  = false;
	private boolean vendible   = false;
	private boolean stockeable = false;
	private boolean prodPropia = false;
	private boolean importado  = false;
	private boolean nd_int = false;
	private boolean nc_int = false;
	
	private boolean noDispararException = false;
	private boolean soloActivos = false;
	
	public ValidarProducto() {
	}
	
	private void determinarTiposHabilitados(MapDatos mapaDatos) throws BaseException {
		
		
		if (mapaDatos.containsKey("NO_DISPARAR_EXCEPTION"))
			noDispararException = true;
		
		if (mapaDatos.containsKey("SOLO_ACTIVOS"))
			soloActivos = true;
		
		if (mapaDatos.containsKey("comprable"))
			comprable = true;
		if (mapaDatos.containsKey("vendible"))
			vendible = true;
		if (mapaDatos.containsKey("stockeable"))
			stockeable = true;
		if (mapaDatos.containsKey("propPropia") || mapaDatos.containsKey("producible"))
			prodPropia = true;		
		if (mapaDatos.containsKey("importado"))
			importado = true;
		if (mapaDatos.containsKey("nd_int"))
			nd_int = true;		
		if (mapaDatos.containsKey("nc_int"))
			nc_int = true;		
		
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		Producto producto = null;
		determinarTiposHabilitados(mapaDatos);
		
		if (mapaDatos.containsKey("codigo")) {
			String codigo = mapaDatos.getString("codigo");
			Producto.validarComposicionCodigo(codigo,getSesion());
			producto = Producto.findByCodigo(codigo,getSesion());
		} else if (mapaDatos.containsKey("oid")) 
			producto = Producto.findByOid(mapaDatos.getInteger("oid"),getSesion());
		
		verificarTipoProducto(producto);
		IDataSet dsValProducto = getDataSetValProducto();
		if (producto!=null)
			cargarProducto(dsValProducto,producto);
		writeCliente(dsValProducto);
	}

	private void cargarProducto(IDataSet ds,
			Producto producto) throws BaseException {
		ds.append();
		ds.fieldValue("oid", producto.getOIDInteger());
		ds.fieldValue("codigo", producto.getCodigo());
		ds.fieldValue("descripcion", producto.getDescripcion());
		if (producto.getDesc_abrev()!=null)
		  ds.fieldValue("desc_abrev", producto.getDesc_abrev());
		else
		  ds.fieldValue("desc_abrev", "");	
		ds.fieldValue("comprable", producto.isComprable());
		ds.fieldValue("vendible", producto.isVendible());
		ds.fieldValue("stockeable", producto.isStockeable());
		ds.fieldValue("prodPropia", producto.isProd_propia());
		ds.fieldValue("importado", producto.isImportado());
		if (producto.getSinonimo()!=null)
		  ds.fieldValue("sinonimo", producto.getSinonimo());
		else
		  ds.fieldValue("sinonimo", "");
		if (producto.getCodigo_barra()!=null)	
		  ds.fieldValue("codigo_barra", producto.getCodigo_barra());
		else
		  ds.fieldValue("codigo_barra", "");
		if (producto.getUm_vta()!=null)
		  ds.fieldValue("oid_um_vta", producto.getUm_vta().getOIDInteger());
		else
		  ds.fieldValue("oid_um_vta", 0);
		if (producto.getUm_stk()!=null)
		  ds.fieldValue("oid_um_stk", producto.getUm_stk().getOIDInteger());
		else
		  ds.fieldValue("oid_um_stk", 0);
		if (producto.getUm_stk_alt()!=null)
		  ds.fieldValue("oid_um_stk_alt", producto.getUm_stk_alt().getOIDInteger());
		else
		  ds.fieldValue("oid_um_stk_alt", 0);
		if (producto.getUm_cpra()!=null)
		  ds.fieldValue("oid_um_cpra", producto.getUm_cpra().getOIDInteger());
		else
		  ds.fieldValue("oid_um_cpra", 0);
		if (producto.getUm_prod()!=null)	
		  ds.fieldValue("oid_um_prod", producto.getUm_prod().getOIDInteger());
		else
		  ds.fieldValue("oid_um_prod", 0);
		if (producto.getTolerancia_recep()!=null)
		  ds.fieldValue("tol_recep", producto.getTolerancia_recep());
		else
		  ds.fieldValue("tol_recep", new Money(0));	
		if (producto.getPorc_cump_oc()!=null)	
		  ds.fieldValue("porc_cump_oc", producto.getPorc_cump_oc());
		else
		  ds.fieldValue("porc_cump_oc", new Money(0));
		if (producto.isSistema_calidad()!=null)
		  ds.fieldValue("sistema_calidad", producto.isSistema_calidad());
		else
		  ds.fieldValue("sistema_calidad", new Boolean(false));	
		if (producto.getCuenta_cpra()!=null)	
		  ds.fieldValue("oid_ana_con_cpra", producto.getCuenta_cpra().getOID());
		else
		  ds.fieldValue("oid_ana_con_cpra", 0);
		if (producto.isModif_ai_cpra()!=null)
		  ds.fieldValue("modif_ai_cpra",producto.isModif_ai_cpra());
		else
		  ds.fieldValue("modif_ai_cpra",new Boolean(false));			
		ds.fieldValue("activo", producto.isActivo());
		if (producto.getTipoproducto()!=null)
		  ds.fieldValue("oid_tipo_producto", producto.getTipoproducto().getOIDInteger());
		else
		  ds.fieldValue("oid_tipo_producto", 0);
		if (producto.getLt_entrega()!=null)
		  ds.fieldValue("lt_entrega", producto.getLt_entrega());
		else
		  ds.fieldValue("lt_entrega", 0);
		
		if (producto.getConcFactProv()!=null)
		  ds.fieldValue("oid_conc_fact_prov", producto.getConcFactProv().getOIDInteger());
		else
		  ds.fieldValue("oid_conc_fact_prov", 0);
		ds.fieldValue("lleva_partida", producto.isLlevaPartida());
		ds.fieldValue("lleva_serie", producto.isLlevaSerie());
		ds.fieldValue("nro", producto.getNro());
		ds.fieldValue("modif_precio_factura", producto.isModifPrecioFactura());
	}

	private IDataSet getDataSetValProducto() {
		IDataSet dataset = new TDataSet();
		dataset.create("TValProducto");
		dataset.fieldDef(new Field("oid", Field.INTEGER, 0));
		dataset.fieldDef(new Field("codigo", Field.STRING, 50));
		dataset.fieldDef(new Field("descripcion", Field.STRING, 100));
		dataset.fieldDef(new Field("desc_abrev", Field.STRING, 50));
		dataset.fieldDef(new Field("comprable", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("vendible", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("stockeable", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("prodPropia", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("importado", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("sinonimo", Field.STRING, 50));
		dataset.fieldDef(new Field("codigo_barra", Field.STRING, 50));
		dataset.fieldDef(new Field("oid_um_vta", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_um_stk", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_um_stk_alt", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_um_cpra", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_um_prod", Field.INTEGER, 0));
		dataset.fieldDef(new Field("tol_recep", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("porc_cump_oc", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("sistema_calidad", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("ai_cpra", Field.INTEGER, 0));
		dataset.fieldDef(new Field("modif_ai_cpra", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("oid_tipo_producto", Field.INTEGER, 0));
		dataset.fieldDef(new Field("lt_entrega", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_conc_fact_prov", Field.INTEGER, 0));
		dataset.fieldDef(new Field("lleva_partida", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("lleva_serie", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("nro", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("modif_precio_factura", Field.BOOLEAN, 0));
		return dataset;
	}
	
	private void verificarTipoProducto(Producto producto) throws BaseException {
		
		if (producto == null)
			if (noDispararException == false) 
				throw new ExceptionValidation(null,"Código de Producto inexistente");
		
		if ((noDispararException) && (producto==null))
			return ;
			
		
		if ((soloActivos) && (noDispararException == false)) {
			if (!producto.isActivo())
				throw new ExceptionValidation(null,"El producto se encuentra inhabilitado.");
			
			ValorClasifEntProdGen valorClasifProdGral = producto.getValorClasifProdGen();
			if (valorClasifProdGral != null) 
				if (!valorClasifProdGral.isActivo())
					throw new ExceptionValidation(null,"El producto general se encuentra deshabilitado:"+
							valorClasifProdGral.getCodigo()+"-"+valorClasifProdGral.getDescripcion());
			
			
			
			
		}
			
		

		
		//	Verificar que sea comprable
		if (comprable) { 
			if (!producto.isComprable().booleanValue())
				if (noDispararException == false)
					throw new ExceptionValidation(null,"El producto seleccionado no es comprable");
		}	
		// Verificar que sea vendible
		if (vendible) { 
			if (!producto.isVendible().booleanValue())
				if (noDispararException == false)
					throw new ExceptionValidation(null,"El producto seleccionado no es vendible");
		}
			
		// Verificar que el producto sea stockeable
		if (stockeable) { 
			if (!producto.isStockeable().booleanValue())
				if (noDispararException == false)
					throw new ExceptionValidation(null,"El producto seleccionado no es stockeable");
		}
			
		// Verificar que el producto sea de produccion propia
		if (prodPropia) { 
			if (!producto.isProd_propia().booleanValue())
				if (noDispararException == false)
					throw new ExceptionValidation(null,"El producto seleccionado no es de producción propia");
		}
			
		// Verificar que el producto sea Importado
			if (importado) { 
				if (!producto.isImportado().booleanValue())
					if (noDispararException == false)
					throw new ExceptionValidation(null,"El producto seleccionado no es Importado");
		}	
				
		if (this.nc_int) {
			if (!producto.isHabilitadaNotaCreditoInterna())
				if (noDispararException == false)
				throw new ExceptionValidation(null,"El producto no esta habilitado para se utilizado en una Nota de Crédito Interna");
		}
		
		if (this.nd_int) {
			if (!producto.isHabilitadaNotaDebitoInterna())
				if (noDispararException == false)
				throw new ExceptionValidation(null,"El producto no esta habilitado para se utilizado en una Nota de Débito Interna");
		}
		
			
	}

}
