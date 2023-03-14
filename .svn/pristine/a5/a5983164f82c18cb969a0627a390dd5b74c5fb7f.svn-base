package com.srn.erp.ventas.op;

import java.util.Iterator;

import com.srn.erp.costos.bm.FormaCalcCosto;
import com.srn.erp.general.bm.ClasificadorEntidad;
import com.srn.erp.general.bm.IValorClasificadorEntidad;
import com.srn.erp.general.bm.ValorClasificadorEntidad;
import com.srn.erp.stock.bm.ConceptoImpuestoProducto;
import com.srn.erp.stock.bm.Producto;
import com.srn.erp.stock.bm.TipoProducto;

import framework.applicarionServer.bl.Presentacion.Grilla;
import framework.applicarionServer.bl.Utils.Fecha;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerConsultaMasivaProductos extends Operation {

	
	HashTableDatos formasCalcCosto = null; 
	
	public TraerConsultaMasivaProductos() {

	}

	public void execute(MapDatos mapaDatos) throws BaseException {

		formasCalcCosto = FormaCalcCosto.getFormasCalcCostos();
		
		if (mapaDatos.containsKey("TRAER_EST_TAB_PROD"))
			enviarEstrucTablaProductos();
		else if (mapaDatos.containsKey("TRAER_COL_GRILLA"))
			enviarColumnasGrilla();
		else if (mapaDatos.containsKey("TRAER_DATOS_PRODUCTOS"))
			enviarDatosProductos(mapaDatos);
		else if (mapaDatos.containsKey("TRAER_DATO_PRODUCTO_EXISTENTE"))
			enviarDatosProductoExistente(mapaDatos);
		

	}
	
	private String getDescFormaCalcCosto(String codigo) throws BaseException {
		if (codigo == null)
			return null;
		String desc = (String)formasCalcCosto.get(codigo);
		if (desc == null)
			desc = "";
		return desc;
	}
	
	private void enviarDatosProductoExistente(MapDatos mapaDatos) throws BaseException {
		Integer oidProducto = mapaDatos.getInteger("oid_producto");
		Producto producto = Producto.findByOid(oidProducto,this.getSesion());
		
		IDataSet ds = getDataConsMasivaProductos("TDatosProducto");
		cargarRegistro(ds,producto);
		writeCliente(ds);
		
	}

	private void enviarDatosProductos(MapDatos mapaDatos) throws BaseException {

		IDataSet ds = this.getDataConsMasivaProductos("TProductos");

		TipoProducto tipoProd = null;
		if ((mapaDatos.getInteger("oid_tipo_producto")!=null) && 
				(mapaDatos.getInteger("oid_tipo_producto").intValue()>0)) {
			tipoProd = 
				TipoProducto.findByOid(mapaDatos.getInteger("oid_tipo_producto"),
						this.getSesion());
		}

		boolean comprable = false;
		if (mapaDatos.containsKey("es_comprable") && (mapaDatos.getBoolean("es_comprable").booleanValue()))
			comprable = true;

		boolean vendible = false;
		if (mapaDatos.containsKey("es_vendible") && (mapaDatos.getBoolean("es_vendible").booleanValue()))
			vendible = true;

		boolean stockeable = false;
		if (mapaDatos.containsKey("es_stockeable") && (mapaDatos.getBoolean("es_stockeable").booleanValue()))
			stockeable = true;
		
		boolean prodPropia = false;
		if (mapaDatos.containsKey("es_prod_propia") && (mapaDatos.getBoolean("es_prod_propia").booleanValue()))
			prodPropia = true;
		
		boolean importado = false;
		if (mapaDatos.containsKey("es_importado") && (mapaDatos.getBoolean("es_importado").booleanValue()))
			importado = true;
		
		
		HashTableDatos listaValClasif = new HashTableDatos();
		IDataSet dsValClasif = mapaDatos.getDataSet("TClasificadorEntidad");
		dsValClasif.first();
		while (!dsValClasif.EOF()) {
			
			Integer oidClasifEnt = dsValClasif.getInteger("oid_clasif_ent");
			ClasificadorEntidad clasifEnt = ClasificadorEntidad.findByOidProxy(oidClasifEnt,this.getSesion());
			
			if ((dsValClasif.getInteger("oid_valor_clasif")!=null) && 
					(dsValClasif.getInteger("oid_valor_clasif").intValue()>0)) {
				ValorClasificadorEntidad valorClasifEnt = 
					ValorClasificadorEntidad.findByOidProxy(dsValClasif.getInteger("oid_valor_clasif"),this.getSesion());
				listaValClasif.put(clasifEnt, valorClasifEnt);
			}		
			
			dsValClasif.next();
		}
		
		
		
		if (mapaDatos.containsKey("vacia")) {
			writeCliente(ds);
			return;
		}
		
		Iterator iterProductos = Producto
				.getConsultaMasivaProductos(
						null,
						mapaDatos.getString("desc_producto"),  
						mapaDatos.getString("desc_abreviada"),
						mapaDatos.getString("codigo_producto"),
						tipoProd,
						comprable,
						vendible,
						stockeable,
						prodPropia,
						importado,
						listaValClasif,
						this.getSesion()).iterator();
		while (iterProductos.hasNext()) {
			Producto producto = (Producto) iterProductos.next();
			cargarRegistro(ds, producto);
		}

		writeCliente(ds);

	}

	private void enviarColumnasGrilla() throws BaseException {
		int i = 0;
		IDataSet ds = this.getDataSetColGrilla();

		Integer BANDA_INDEX_0 = new Integer(0);
		Integer BANDA_INDEX_1 = new Integer(1);
		Integer ANCHO_COL_200 = new Integer(200);
		Boolean READ_ONLY = new Boolean(true);
		Boolean NOT_READ_ONLY = new Boolean(false);
		Boolean CAN_FOCUS = new Boolean(true);
		Boolean NO_FOCUS = new Boolean(false);
		String SIN_FORMATO = "";
		Boolean SIN_EVENTO_HELP = new Boolean(false);
		Boolean CON_EVENTO_HELP = new Boolean(true);
		String SCRIPT_EVENTO_HELP = "";
		Boolean NO_AGRUPAR = new Boolean(false);
		Integer SIN_NRO_GRUPO = new Integer(0);

		cargaColGrillaProd(ds, new Integer(++i), Grilla.TIPO_COL_BUTTON_EDIT, "Cod. Producto", "cod_producto",
				BANDA_INDEX_0, ANCHO_COL_200, NOT_READ_ONLY, CAN_FOCUS, SIN_FORMATO, CON_EVENTO_HELP, "begin "
						+ " HelpProductos.Mostrar();" + "end. ", NO_AGRUPAR, SIN_NRO_GRUPO);

		cargaColGrillaProd(ds, new Integer(++i), Grilla.TIPO_COL_ESTANDAR, "Descripción Producto", "desc_producto",
				BANDA_INDEX_0, new Integer(400), NOT_READ_ONLY, CAN_FOCUS, SIN_FORMATO, SIN_EVENTO_HELP, SCRIPT_EVENTO_HELP,
				NO_AGRUPAR, SIN_NRO_GRUPO);

		cargaColGrillaProd(ds, new Integer(++i), Grilla.TIPO_COL_ESTANDAR, "Desc. Abrev. Producto", "desc_abrev_producto",
				BANDA_INDEX_1, new Integer(400), NOT_READ_ONLY, CAN_FOCUS, SIN_FORMATO, SIN_EVENTO_HELP, SCRIPT_EVENTO_HELP,
				NO_AGRUPAR, SIN_NRO_GRUPO);

		cargaColGrillaProd(ds, new Integer(++i), Grilla.TIPO_COL_BUTTON_EDIT, "Tipo Prod.", "cod_tipo_producto",
				BANDA_INDEX_1, new Integer(60), NOT_READ_ONLY, CAN_FOCUS, SIN_FORMATO, CON_EVENTO_HELP, "begin "
						+ " HelpTipoProducto.Mostrar();" + "end. ", NO_AGRUPAR, SIN_NRO_GRUPO);

		cargaColGrillaProd(ds, new Integer(++i), Grilla.TIPO_COL_ESTANDAR, "Descripción Tipo Producto",
				"desc_tipo_producto", BANDA_INDEX_1, new Integer(120), READ_ONLY, NO_FOCUS, SIN_FORMATO, SIN_EVENTO_HELP,
				SCRIPT_EVENTO_HELP, NO_AGRUPAR, SIN_NRO_GRUPO);

		cargaColGrillaProd(ds, new Integer(++i), Grilla.TIPO_COL_CHECK_BOX, "Comprable?", "comprable", BANDA_INDEX_1,
				new Integer(50), NOT_READ_ONLY, CAN_FOCUS, SIN_FORMATO, SIN_EVENTO_HELP, SCRIPT_EVENTO_HELP, NO_AGRUPAR,
				SIN_NRO_GRUPO);

		cargaColGrillaProd(ds, new Integer(++i), Grilla.TIPO_COL_CHECK_BOX, "Vendible?", "vendible", BANDA_INDEX_1,
				new Integer(50), NOT_READ_ONLY, CAN_FOCUS, SIN_FORMATO, SIN_EVENTO_HELP, SCRIPT_EVENTO_HELP, NO_AGRUPAR,
				SIN_NRO_GRUPO);

		cargaColGrillaProd(ds, new Integer(++i), Grilla.TIPO_COL_CHECK_BOX, "Stockeable?", "stockeable", BANDA_INDEX_1,
				new Integer(50), NOT_READ_ONLY, CAN_FOCUS, SIN_FORMATO, SIN_EVENTO_HELP, SCRIPT_EVENTO_HELP, NO_AGRUPAR,
				SIN_NRO_GRUPO);

		cargaColGrillaProd(ds, new Integer(++i), Grilla.TIPO_COL_CHECK_BOX, "Prod. Propia?", "prod_propia", BANDA_INDEX_1,
				new Integer(50), NOT_READ_ONLY, CAN_FOCUS, SIN_FORMATO, SIN_EVENTO_HELP, SCRIPT_EVENTO_HELP, NO_AGRUPAR,
				SIN_NRO_GRUPO);

		cargaColGrillaProd(ds, new Integer(++i), Grilla.TIPO_COL_CHECK_BOX, "Importado?", "importado", BANDA_INDEX_1,
				new Integer(50), NOT_READ_ONLY, CAN_FOCUS, SIN_FORMATO, SIN_EVENTO_HELP, SCRIPT_EVENTO_HELP, NO_AGRUPAR,
				SIN_NRO_GRUPO);

		cargaColGrillaProd(ds, new Integer(++i), Grilla.TIPO_COL_ESTANDAR, "Sinónimo", "sinonimo", BANDA_INDEX_1,
				new Integer(100), NOT_READ_ONLY, CAN_FOCUS, SIN_FORMATO, SIN_EVENTO_HELP, SCRIPT_EVENTO_HELP, NO_AGRUPAR,
				SIN_NRO_GRUPO);

		cargaColGrillaProd(ds, new Integer(++i), Grilla.TIPO_COL_ESTANDAR, "Cod. Barra", "codigo_barra", BANDA_INDEX_1,
				new Integer(100), NOT_READ_ONLY, CAN_FOCUS, SIN_FORMATO, SIN_EVENTO_HELP, SCRIPT_EVENTO_HELP, NO_AGRUPAR,
				SIN_NRO_GRUPO);

		cargaColGrillaProd(ds, new Integer(++i), Grilla.TIPO_COL_BUTTON_EDIT, "U.M. Compra", "cod_um_compra",
				BANDA_INDEX_1, new Integer(50), NOT_READ_ONLY, CAN_FOCUS, SIN_FORMATO, CON_EVENTO_HELP, "begin "
						+ " HelpUMCompras.Mostrar();" + "end. ", NO_AGRUPAR, SIN_NRO_GRUPO);

		cargaColGrillaProd(ds, new Integer(++i), Grilla.TIPO_COL_CURRENCY_EDIT, "% Cump. O.C.", "porc_cump_oc",
				BANDA_INDEX_1, new Integer(50), NOT_READ_ONLY, CAN_FOCUS, "###.##", SIN_EVENTO_HELP, SCRIPT_EVENTO_HELP,
				NO_AGRUPAR, SIN_NRO_GRUPO);

		cargaColGrillaProd(ds, new Integer(++i), Grilla.TIPO_COL_BUTTON_EDIT, "U.M. Venta", "cod_um_vta", BANDA_INDEX_1,
				new Integer(50), NOT_READ_ONLY, CAN_FOCUS, SIN_FORMATO, CON_EVENTO_HELP, "begin " + " HelpUMVentas.Mostrar();"
						+ "end. ", NO_AGRUPAR, SIN_NRO_GRUPO);

		cargaColGrillaProd(ds, new Integer(++i), Grilla.TIPO_COL_ESTANDAR, "L.T.Entrega", "lead_time_ent_vta",
				BANDA_INDEX_1, new Integer(100), NOT_READ_ONLY, CAN_FOCUS, SIN_FORMATO, SIN_EVENTO_HELP, SCRIPT_EVENTO_HELP,
				NO_AGRUPAR, SIN_NRO_GRUPO);

		cargaColGrillaProd(ds, new Integer(++i), Grilla.TIPO_COL_BUTTON_EDIT, "Impu. IVA", "cod_impu_iva", BANDA_INDEX_1,
				new Integer(50), NOT_READ_ONLY, CAN_FOCUS, SIN_FORMATO, CON_EVENTO_HELP, "begin "
						+ " HelpConceptoImpuesto.Mostrar();" + "end. ", NO_AGRUPAR, SIN_NRO_GRUPO);

		cargaColGrillaProd(ds, new Integer(++i), Grilla.TIPO_COL_ESTANDAR, "Desc. Impu. IVA", "desc_impu_iva",
				BANDA_INDEX_1, new Integer(100), READ_ONLY, NO_FOCUS, SIN_FORMATO, SIN_EVENTO_HELP, SCRIPT_EVENTO_HELP,
				NO_AGRUPAR, SIN_NRO_GRUPO);

		cargaColGrillaProd(ds, new Integer(++i), Grilla.TIPO_COL_DATE_EDIT, "Fec. Vig. Impu. IVA", "fec_vig_imp_vtas",
				BANDA_INDEX_1, new Integer(50), NOT_READ_ONLY, CAN_FOCUS, SIN_FORMATO, SIN_EVENTO_HELP, SCRIPT_EVENTO_HELP,
				NO_AGRUPAR, SIN_NRO_GRUPO);

		cargaColGrillaProd(ds, new Integer(++i), Grilla.TIPO_COL_BUTTON_EDIT, "U.M. Stk. PPal.", "cod_um_stk_ppal",
				BANDA_INDEX_1, new Integer(50), NOT_READ_ONLY, CAN_FOCUS, SIN_FORMATO, CON_EVENTO_HELP, "begin "
						+ " HelpUMStockPrincipal.Mostrar();" + "end. ", NO_AGRUPAR, SIN_NRO_GRUPO);

		cargaColGrillaProd(ds, new Integer(++i), Grilla.TIPO_COL_BUTTON_EDIT, "U.M. Stk. Alt.", "cod_um_stk_alt",
				BANDA_INDEX_1, new Integer(50), NOT_READ_ONLY, CAN_FOCUS, SIN_FORMATO, CON_EVENTO_HELP, "begin "
						+ " HelpUMStockAlternativa.Mostrar();" + "end. ", NO_AGRUPAR, SIN_NRO_GRUPO);

		cargaColGrillaProd(ds, new Integer(++i), Grilla.TIPO_COL_BUTTON_EDIT, "U.M. Producción", "cod_um_stk_prod",
				BANDA_INDEX_1, new Integer(50), NOT_READ_ONLY, CAN_FOCUS, SIN_FORMATO, CON_EVENTO_HELP, "begin "
						+ " HelpUMProduccion.Mostrar();" + "end. ", NO_AGRUPAR, SIN_NRO_GRUPO);

		cargaColGrillaProd(ds, new Integer(++i), Grilla.TIPO_COL_CHECK_BOX, "Activo", "activo", BANDA_INDEX_1, new Integer(
				50), NOT_READ_ONLY, CAN_FOCUS, SIN_FORMATO, SIN_EVENTO_HELP, SCRIPT_EVENTO_HELP, NO_AGRUPAR, SIN_NRO_GRUPO);

		cargaColGrillaProd(ds, new Integer(++i), Grilla.TIPO_COL_BUTTON_EDIT, "Forma. Calc. Costo", "cod_forma_calc_costo", BANDA_INDEX_1,
				new Integer(50), NOT_READ_ONLY, CAN_FOCUS, SIN_FORMATO, CON_EVENTO_HELP, "begin "
						+ " HelpFormCalcCosto.asignarValColACampo('codigo','TProductos','cod_forma_calc_costo'); HelpFormCalcCosto.TableHelp := TFormaCalcCosto; HelpFormCalcCosto.Mostrar();" + "end. ", NO_AGRUPAR, SIN_NRO_GRUPO);

		cargaColGrillaProd(ds, new Integer(++i), Grilla.TIPO_COL_ESTANDAR, "Desc. Calc. Costo", "desc_forma_calc_costo",
				BANDA_INDEX_1, new Integer(100), READ_ONLY, NO_FOCUS, SIN_FORMATO, SIN_EVENTO_HELP, SCRIPT_EVENTO_HELP,
				NO_AGRUPAR, SIN_NRO_GRUPO);


		
		
		
		Iterator iterClasifEnt = Producto.getClasificadoresEntidad(this.getSesion()).iterator();
		while (iterClasifEnt.hasNext()) {
			ClasificadorEntidad clasifEnt = (ClasificadorEntidad) iterClasifEnt.next();

			StringBuffer scriptHelp = new StringBuffer();
			scriptHelp.append(" begin ");
			scriptHelp.append("  HelpValoresClasificador.AsignarCampoCodigo := TProductos.FieldName('" + "cod_clasif_"
					+ clasifEnt.getOIDInteger() + "')");
			scriptHelp.append("  HelpValoresClasificador.NickName :=  '" + clasifEnt.getNickname() + "'; ");
			scriptHelp
					.append("  HelpValoresClasificador.NroClasificador    := " + clasifEnt.getNroClasif().toString() + "; ");
			scriptHelp.append("  HelpValoresClasificador.Mostrar(); ");
			scriptHelp.append(" end. ");

			cargaColGrillaProd(ds, new Integer(++i), Grilla.TIPO_COL_BUTTON_EDIT, "Cod. " + clasifEnt.getDescripcion(),
					"cod_clasif_" + clasifEnt.getOIDInteger(), BANDA_INDEX_1, new Integer(75), NOT_READ_ONLY, CAN_FOCUS,
					SIN_FORMATO, CON_EVENTO_HELP, scriptHelp.toString(), NO_AGRUPAR, SIN_NRO_GRUPO);

			cargaColGrillaProd(ds, new Integer(++i), Grilla.TIPO_COL_ESTANDAR, "Desc. " + clasifEnt.getDescripcion(),
					"desc_clasif_" + clasifEnt.getOIDInteger(), BANDA_INDEX_1, new Integer(200), READ_ONLY, NO_FOCUS,
					SIN_FORMATO, SIN_EVENTO_HELP, SCRIPT_EVENTO_HELP, NO_AGRUPAR, SIN_NRO_GRUPO);

		}

		writeCliente(ds);
	}

	private void enviarEstrucTablaProductos() throws BaseException {
		IDataSet dsEstrucTablaProd = getDataSetCamposEstrucTablaProductos();
		int i = 0;
		cargaCampoTabProd(dsEstrucTablaProd, new Integer(++i), Field.INTEGER, "oid_producto", new Integer(0), new Boolean(
				true), new Boolean(true), getOnValidateOidProducto(), "TProductos", "oid_producto");
		cargaCampoTabProd(dsEstrucTablaProd, new Integer(++i), Field.STRING, "cod_producto", new Integer(50), new Boolean(
				false), new Boolean(true), getOnValidateCodProducto(), "TProductos", "cod_producto");
		cargaCampoTabProd(dsEstrucTablaProd, new Integer(++i), Field.STRING, "desc_producto", new Integer(200),
				new Boolean(false), new Boolean(false), "", "", "");
		cargaCampoTabProd(dsEstrucTablaProd, new Integer(++i), Field.STRING, "desc_abrev_producto", new Integer(200),
				new Boolean(false), new Boolean(false), "", "", "");

		cargaCampoTabProd(dsEstrucTablaProd, new Integer(++i), Field.INTEGER, "oid_tipo_producto", new Integer(0),
				new Boolean(false), new Boolean(false), "", "", "");
		cargaCampoTabProd(dsEstrucTablaProd, new Integer(++i), Field.STRING, "cod_tipo_producto", new Integer(50),
				new Boolean(false), new Boolean(true), getOnValidateTipoProducto(), "TProductos", "cod_tipo_producto");
		cargaCampoTabProd(dsEstrucTablaProd, new Integer(++i), Field.STRING, "desc_tipo_producto", new Integer(100),
				new Boolean(false), new Boolean(false), "", "", "");

		cargaCampoTabProd(dsEstrucTablaProd, new Integer(++i), Field.BOOLEAN, "comprable", new Integer(0), new Boolean(
				false), new Boolean(false), "", "", "");
		cargaCampoTabProd(dsEstrucTablaProd, new Integer(++i), Field.BOOLEAN, "vendible", new Integer(0),
				new Boolean(false), new Boolean(false), "", "", "");
		cargaCampoTabProd(dsEstrucTablaProd, new Integer(++i), Field.BOOLEAN, "stockeable", new Integer(0), new Boolean(
				false), new Boolean(false), "", "", "");
		cargaCampoTabProd(dsEstrucTablaProd, new Integer(++i), Field.BOOLEAN, "prod_propia", new Integer(0), new Boolean(
				false), new Boolean(false), "", "", "");
		cargaCampoTabProd(dsEstrucTablaProd, new Integer(++i), Field.BOOLEAN, "importado", new Integer(0), new Boolean(
				false), new Boolean(false), "", "", "");
		cargaCampoTabProd(dsEstrucTablaProd, new Integer(++i), Field.STRING, "sinonimo", new Integer(50),
				new Boolean(false), new Boolean(false), "", "", "");
		cargaCampoTabProd(dsEstrucTablaProd, new Integer(++i), Field.STRING, "codigo_barra", new Integer(50), new Boolean(
				false), new Boolean(false), "", "", "");
		cargaCampoTabProd(dsEstrucTablaProd, new Integer(++i), Field.INTEGER, "oid_um_compra", new Integer(0), new Boolean(
				false), new Boolean(false), "", "", "");
		cargaCampoTabProd(dsEstrucTablaProd, new Integer(++i), Field.STRING, "cod_um_compra", new Integer(50), new Boolean(
				false), new Boolean(true), getOnValidateUMCompra(), "TProductos", "cod_um_compra");
		cargaCampoTabProd(dsEstrucTablaProd, new Integer(++i), Field.CURRENCY, "porc_cump_oc", new Integer(0), new Boolean(
				false), new Boolean(false), "", "", "");
		cargaCampoTabProd(dsEstrucTablaProd, new Integer(++i), Field.INTEGER, "oid_um_vta", new Integer(0), new Boolean(
				false), new Boolean(false), "", "", "");
		cargaCampoTabProd(dsEstrucTablaProd, new Integer(++i), Field.STRING, "cod_um_vta", new Integer(50), new Boolean(
				false), new Boolean(true), getOnValidateUMVenta(), "TProductos", "cod_um_vta");
		cargaCampoTabProd(dsEstrucTablaProd, new Integer(++i), Field.INTEGER, "lead_time_ent_vta", new Integer(0),
				new Boolean(false), new Boolean(false), "", "", "");
		cargaCampoTabProd(dsEstrucTablaProd, new Integer(++i), Field.INTEGER, "oid_impu_iva", new Integer(0), new Boolean(
				false), new Boolean(false), "", "", "");
		cargaCampoTabProd(dsEstrucTablaProd, new Integer(++i), Field.STRING, "cod_impu_iva", new Integer(50), new Boolean(
				false), new Boolean(true), getOnValidateConceptoImpuestoIVA(), "TProductos", "cod_impu_iva");

		cargaCampoTabProd(dsEstrucTablaProd, new Integer(++i), Field.STRING, "desc_impu_iva", new Integer(100),
				new Boolean(false), new Boolean(false), "", "", "");
		cargaCampoTabProd(dsEstrucTablaProd, new Integer(++i), Field.DATE, "fec_vig_imp_vtas", new Integer(0), new Boolean(
				false), new Boolean(false), "", "", "");
		cargaCampoTabProd(dsEstrucTablaProd, new Integer(++i), Field.INTEGER, "oid_um_stk_ppal", new Integer(0),
				new Boolean(false), new Boolean(false), "", "", "");
		cargaCampoTabProd(dsEstrucTablaProd, new Integer(++i), Field.STRING, "cod_um_stk_ppal", new Integer(50),
				new Boolean(false), new Boolean(true), this.getOnValidateUMStockPrincipal(), "TProductos", "cod_um_stk_ppal");

		cargaCampoTabProd(dsEstrucTablaProd, new Integer(++i), Field.INTEGER, "oid_um_stk_alt", new Integer(0),
				new Boolean(false), new Boolean(false), "", "", "");
		cargaCampoTabProd(dsEstrucTablaProd, new Integer(++i), Field.STRING, "cod_um_stk_alt", new Integer(50),
				new Boolean(false), new Boolean(true), this.getOnValidateUMStockAlternativa(), "TProductos", "cod_um_stk_alt");
		cargaCampoTabProd(dsEstrucTablaProd, new Integer(++i), Field.INTEGER, "oid_um_stk_prod", new Integer(0),
				new Boolean(false), new Boolean(false), "", "", "");
		cargaCampoTabProd(dsEstrucTablaProd, new Integer(++i), Field.STRING, "cod_um_stk_prod", new Integer(50),
				new Boolean(false), new Boolean(true), this.getOnValidateUMProduccion(), "TProductos", "cod_um_stk_prod");
		cargaCampoTabProd(dsEstrucTablaProd, new Integer(++i), Field.BOOLEAN, "activo", new Integer(0), new Boolean(false),
				new Boolean(false), "", "", "");
		cargaCampoTabProd(dsEstrucTablaProd, new Integer(++i), Field.STRING, "cod_forma_calc_costo", new Integer(50), new Boolean(
				false), new Boolean(true), getOnValidateFormCalcCosto(), "TProductos", "cod_forma_calc_costo");

		cargaCampoTabProd(dsEstrucTablaProd, new Integer(++i), Field.STRING, "desc_forma_calc_costo", new Integer(100),
				new Boolean(false), new Boolean(false), "", "", "");
		
		
		Iterator iterClasifEnt = Producto.getClasificadoresEntidad(this.getSesion()).iterator();
		while (iterClasifEnt.hasNext()) {
			ClasificadorEntidad clasifEnt = (ClasificadorEntidad) iterClasifEnt.next();

			cargaCampoTabProd(dsEstrucTablaProd, new Integer(++i), Field.INTEGER, "oid_clasif_" + clasifEnt.getOIDInteger(),
					new Integer(0), new Boolean(false), new Boolean(false), "", "", "");

			cargaCampoTabProd(dsEstrucTablaProd, new Integer(++i), Field.STRING, "cod_clasif_" + clasifEnt.getOIDInteger(),
					new Integer(50), new Boolean(false), new Boolean(true), getOnValidateValorClasif(clasifEnt), "TProductos", "cod_clasif_" + clasifEnt.getOIDInteger());

			cargaCampoTabProd(dsEstrucTablaProd, new Integer(++i), Field.STRING, "desc_clasif_" + clasifEnt.getOIDInteger(),
					new Integer(100), new Boolean(false), new Boolean(false), "", "", "");

		}

		writeCliente(dsEstrucTablaProd);
	}

	private IDataSet getDataConsMasivaProductos(String nombreTabla) throws BaseException {
		IDataSet dataset = new TDataSet();
		dataset.create(nombreTabla);
		dataset.fieldDef(new Field("oid_producto", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_producto", Field.STRING, 50));
		dataset.fieldDef(new Field("desc_producto", Field.STRING, 100));
		dataset.fieldDef(new Field("desc_abrev_producto", Field.STRING, 100));
		dataset.fieldDef(new Field("oid_tipo_producto", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_tipo_producto", Field.STRING, 50));
		dataset.fieldDef(new Field("desc_tipo_producto", Field.STRING, 100));
		dataset.fieldDef(new Field("comprable", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("vendible", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("stockeable", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("prod_propia", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("importado", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("sinonimo", Field.STRING, 50));
		dataset.fieldDef(new Field("codigo_barra", Field.STRING, 50));
		dataset.fieldDef(new Field("oid_um_compra", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_um_compra", Field.STRING, 50));
		dataset.fieldDef(new Field("porc_cump_oc", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("oid_um_vta", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_um_vta", Field.STRING, 50));
		dataset.fieldDef(new Field("lead_time_ent_vta", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_impu_iva", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_impu_iva", Field.STRING, 50));
		dataset.fieldDef(new Field("desc_impu_iva", Field.STRING, 100));
		dataset.fieldDef(new Field("fec_vig_imp_vtas", Field.DATE, 0));
		dataset.fieldDef(new Field("oid_um_stk_ppal", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_um_stk_ppal", Field.STRING, 50));
		dataset.fieldDef(new Field("oid_um_stk_alt", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_um_stk_alt", Field.STRING, 50));
		dataset.fieldDef(new Field("oid_um_stk_prod", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_um_stk_prod", Field.STRING, 50));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("cod_forma_calc_costo", Field.STRING, 50));
		dataset.fieldDef(new Field("desc_forma_calc_costo", Field.STRING, 100));
		

		Iterator iterClasifEnt = Producto.getClasificadoresEntidad(this.getSesion()).iterator();
		while (iterClasifEnt.hasNext()) {
			ClasificadorEntidad clasifEnt = (ClasificadorEntidad) iterClasifEnt.next();

			dataset.fieldDef(new Field("oid_clasif_" + clasifEnt.getOIDInteger(), Field.INTEGER, 0));
			dataset.fieldDef(new Field("cod_clasif_" + clasifEnt.getOIDInteger(), Field.STRING, 50));
			dataset.fieldDef(new Field("desc_clasif_" + clasifEnt.getOIDInteger(), Field.STRING, 100));

		}

		return dataset;
	}

	private void cargarRegistro(IDataSet dataset, Producto producto) throws BaseException {
		dataset.append();
		dataset.fieldValue("oid_producto", producto.getOIDInteger());
		dataset.fieldValue("cod_producto", producto.getCodigo());
		dataset.fieldValue("desc_producto", producto.getDescripcion());
		dataset.fieldValue("desc_abrev_producto", producto.getDesc_abrev());
		if (producto.getTipoproducto() != null) {
			dataset.fieldValue("oid_tipo_producto", producto.getTipoproducto().getOIDInteger());
			dataset.fieldValue("cod_tipo_producto", producto.getTipoproducto().getCodigo());
			dataset.fieldValue("desc_tipo_producto", producto.getTipoproducto().getDescripcion());
		}
		else {
			dataset.fieldValue("oid_tipo_producto", new Integer(0));
			dataset.fieldValue("cod_tipo_producto", "");
			dataset.fieldValue("desc_tipo_producto", "");
		}
		dataset.fieldValue("comprable", producto.isComprable());
		dataset.fieldValue("vendible", producto.isVendible());
		dataset.fieldValue("stockeable", producto.isStockeable());
		dataset.fieldValue("prod_propia", producto.isProd_propia());
		dataset.fieldValue("importado", producto.isImportado());
		dataset.fieldValue("sinonimo", producto.getSinonimo());
		dataset.fieldValue("codigo_barra", producto.getCodigo_barra());

		if (producto.getUm_cpra() != null) {
			dataset.fieldValue("oid_um_compra", producto.getUm_cpra().getOIDInteger());
			dataset.fieldValue("cod_um_compra", producto.getUm_cpra().getCodigo());
		}
		else {
			dataset.fieldValue("oid_um_compra", new Integer(0));
			dataset.fieldValue("cod_um_compra", "");
		}

		dataset.fieldValue("porc_cump_oc", producto.getPorc_cump_oc());

		if (producto.getUm_vta() != null) {
			dataset.fieldValue("oid_um_vta", producto.getUm_vta().getOIDInteger());
			dataset.fieldValue("cod_um_vta", producto.getUm_vta().getCodigo());
		}
		else {
			dataset.fieldValue("oid_um_vta", new Integer(0));
			dataset.fieldValue("cod_um_vta", "");
		}

		dataset.fieldValue("lead_time_ent_vta", producto.getLeadTimeVta());

		ConceptoImpuestoProducto concImpuIVAProducto = producto.getConcImpuIVAProducto(Fecha.getFechaActual());
		

		if (concImpuIVAProducto != null) {
			dataset.fieldValue("oid_impu_iva",concImpuIVAProducto.getConcepto_impuesto().getOIDInteger());
			dataset.fieldValue("cod_impu_iva", concImpuIVAProducto.getConcepto_impuesto().getCodigo());
			dataset.fieldValue("desc_impu_iva", concImpuIVAProducto.getConcepto_impuesto().getDescripcion());
			dataset.fieldValue("fec_vig_imp_vtas", concImpuIVAProducto.getFecha_vigencia());
		}
		else {
			dataset.fieldValue("oid_impu_iva", new Integer(0));
			dataset.fieldValue("cod_impu_iva", "");
			dataset.fieldValue("desc_impu_iva", "");
			dataset.fieldValue("fec_vig_imp_vtas", Fecha.FECHA_NULA());

		}

		if (producto.getUm_stk() != null) {
			dataset.fieldValue("oid_um_stk_ppal", producto.getUm_stk().getOIDInteger());
			dataset.fieldValue("cod_um_stk_ppal", producto.getUm_stk().getCodigo());
		}
		else {
			dataset.fieldValue("oid_um_stk_ppal", new Integer(0));
			dataset.fieldValue("cod_um_stk_ppal", "");
		}

		if (producto.getUm_stk() != null) {
			dataset.fieldValue("oid_um_stk_alt", producto.getUm_stk().getOIDInteger());
			dataset.fieldValue("cod_um_stk_alt", producto.getUm_stk().getCodigo());
		}
		else {
			dataset.fieldValue("oid_um_stk_alt", new Integer(0));
			dataset.fieldValue("cod_um_stk_alt", "");
		}

		if (producto.getUm_prod() != null) {
			dataset.fieldValue("oid_um_stk_prod", producto.getUm_prod().getOIDInteger());
			dataset.fieldValue("cod_um_stk_prod", producto.getUm_prod().getCodigo());
		}
		else {
			dataset.fieldValue("oid_um_stk_prod", new Integer(0));
			dataset.fieldValue("cod_um_stk_prod", "");
		}

		dataset.fieldValue("activo", producto.isActivo());
		dataset.fieldValue("cod_forma_calc_costo", producto.getFormaCalcCosto());
		dataset.fieldValue("desc_forma_calc_costo", getDescFormaCalcCosto(producto.getFormaCalcCosto()));
		
		

		Iterator iterClasifEnt = Producto.getClasificadoresEntidad(this.getSesion()).iterator();
		while (iterClasifEnt.hasNext()) {
			ClasificadorEntidad clasifEnt = (ClasificadorEntidad) iterClasifEnt.next();

			IValorClasificadorEntidad valClasifEnt = producto.getValorClasifEnt(clasifEnt);

			if (valClasifEnt != null) {
				dataset.fieldValue("oid_clasif_" + clasifEnt.getOIDInteger(), valClasifEnt.getOID());
				dataset.fieldValue("cod_clasif_" + clasifEnt.getOIDInteger(), valClasifEnt.getCodigo());
				dataset.fieldValue("desc_clasif_" + clasifEnt.getOIDInteger(), valClasifEnt.getDescripcion());
			}
			else {
				dataset.fieldValue("oid_clasif_" + clasifEnt.getOIDInteger(), new Integer(0));
				dataset.fieldValue("cod_clasif_" + clasifEnt.getOIDInteger(), "");
				dataset.fieldValue("desc_clasif_" + clasifEnt.getOIDInteger(), "");
			}

		}

	}

	private IDataSet getDataSetCamposEstrucTablaProductos() {
		IDataSet dataset = new TDataSet();
		dataset.create("TCamposTablaProducto");

		// Aspectos Fisicos
		dataset.fieldDef(new Field("secu", Field.INTEGER, 0));
		dataset.fieldDef(new Field("tipo", Field.STRING, 50));
		dataset.fieldDef(new Field("nombre_fisico", Field.STRING, 50));
		dataset.fieldDef(new Field("longitud", Field.INTEGER, 0));
		dataset.fieldDef(new Field("primaryKey", Field.BOOLEAN, 0));

		// Agregar campos on Validate
		dataset.fieldDef(new Field("habOnValidate", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("scriptOnValidate", Field.STRING, 5000));
		dataset.fieldDef(new Field("tableName", Field.STRING, 50));
		dataset.fieldDef(new Field("fieldName", Field.STRING, 50));

		return dataset;
	}

	private void cargaCampoTabProd(IDataSet dataset, Integer secu, String tipo, String nombreFisico, Integer longitud,
			Boolean primaryKey, Boolean habilitarOnValidate, String scriptOnValidate, String tableName, String fieldName) {

		dataset.append();
		dataset.fieldValue("secu", secu);
		dataset.fieldValue("tipo", tipo);
		dataset.fieldValue("nombre_fisico", nombreFisico);
		dataset.fieldValue("longitud", longitud);
		dataset.fieldValue("primaryKey", primaryKey);

		dataset.fieldValue("habOnValidate", habilitarOnValidate);
		dataset.fieldValue("scriptOnValidate", scriptOnValidate);
		dataset.fieldValue("tableName", tableName);
		dataset.fieldValue("fieldName", fieldName);

	}

	private IDataSet getDataSetColGrilla() {
		IDataSet dataset = new TDataSet();
		dataset.create("TColGrillaProducto");

		// Aspectos Fisicos
		dataset.fieldDef(new Field("secu", Field.INTEGER, 0));
		dataset.fieldDef(new Field("tipo_columna", Field.STRING, 50));
		dataset.fieldDef(new Field("titulo", Field.STRING, 50));
		dataset.fieldDef(new Field("field_name", Field.STRING, 50));
		dataset.fieldDef(new Field("band_index", Field.INTEGER, 0));
		dataset.fieldDef(new Field("ancho_col", Field.INTEGER, 0));
		dataset.fieldDef(new Field("read_only", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("can_focus", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("formato", Field.STRING, 50));
		dataset.fieldDef(new Field("evento_help", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("script_help", Field.STRING, 5000));
		dataset.fieldDef(new Field("agrupar", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("nro_agrupador", Field.INTEGER, 0));
		dataset.fieldDef(new Field("nombre_columna", Field.STRING, 50));

		return dataset;
	}

	private void cargaColGrillaProd(IDataSet dataset, Integer secu, String tipoColumna, String titulo, String fieldName,
			Integer bandIndex, Integer anchoCol, Boolean readonly, Boolean canFocus, String formato, Boolean eventoHelp,
			String scriptHelp, Boolean agrupar, Integer nroAgrupador) {

		dataset.append();
		dataset.fieldValue("secu", secu);
		dataset.fieldValue("tipo_columna", tipoColumna);
		dataset.fieldValue("titulo", titulo);
		dataset.fieldValue("field_name", fieldName);
		dataset.fieldValue("band_index", bandIndex);
		dataset.fieldValue("ancho_col", anchoCol);
		dataset.fieldValue("read_only", readonly);
		dataset.fieldValue("can_focus", canFocus);
		dataset.fieldValue("formato", formato);
		dataset.fieldValue("evento_help", eventoHelp);
		dataset.fieldValue("script_help", scriptHelp);
		dataset.fieldValue("agrupar", agrupar);
		dataset.fieldValue("nro_agrupador", nroAgrupador);
		dataset.fieldValue("nombre_columna", "CG_" + fieldName);
	}

	private String getOnValidateCodProducto() {
		StringBuffer script = new StringBuffer();
		script.append(" begin ");
		script.append(" if (Trim(Sender.AsString)='') ");
		script.append("    then begin ");
		script.append("         TProductos.EditRecord; ");
		script.append("         TProductos.FieldName('oid_producto').Clear; ");
		script.append("         TProductos.FieldName('desc_producto').Clear; ");
		script.append("         end ");
		script.append("    else begin ");
		script.append("         operacion.InicioOperacion; ");
		script.append("         operacion.setOper('ValidarProducto'); ");
		script.append("         operacion.addAtribute('NO_DISPARAR_EXCEPTION',''); ");
		script.append("         operacion.addAtribute('vendible',''); ");
		script.append("         operacion.addAtribute('codigo',Sender.AsString); ");
		script.append("         operacion.execute; ");
		script.append("         if (not TValProducto.isEmpty()) ");
		script.append("          then begin ");
		script.append("               TProductos.EditRecord; ");
		script.append("               TProductos.FieldName('oid_producto').AsInteger := ");
		script.append("                   TValProducto.FieldName('oid').AsInteger; ");
		script.append("               TProductos.FieldName('desc_producto').AsString := ");
		script.append("                    TValProducto.FieldName('descripcion').AsString; ");
		script.append("               end; ");        
		script.append("         end; ");
		script.append(" end. ");
		return script.toString();

	}

	private String getOnValidateTipoProducto() {
		StringBuffer script = new StringBuffer();
		script.append(" begin ");
		script.append("  ValidadorTipoProducto.Value := Sender.AsString; ");
		script.append("  ValidadorTipoProducto.Validar; ");
		script.append(" end. ");
		return script.toString();
	}

	private String getOnValidateUMCompra() {
		StringBuffer script = new StringBuffer();
		script.append(" begin ");
		script.append("  ValidadorUMCompras.Value := Sender.AsString; ");
		script.append("  ValidadorUMCompras.Validar; ");
		script.append(" end. ");
		return script.toString();
	}

	private String getOnValidateUMVenta() {
		StringBuffer script = new StringBuffer();
		script.append(" begin ");
		script.append("  ValidadorUMVentas.Value := Sender.AsString; ");
		script.append("  ValidadorUMVentas.Validar; ");
		script.append(" end. ");
		return script.toString();
	}

	private String getOnValidateConceptoImpuestoIVA() {
		StringBuffer script = new StringBuffer();
		script.append(" begin ");
		script.append("  ValidadorConceptoImpuesto.Value := Sender.AsString; ");
		script.append("  ValidadorConceptoImpuesto.Validar; ");
		script.append(" end. ");
		return script.toString();
	}

	private String getOnValidateUMStockPrincipal() {
		StringBuffer script = new StringBuffer();
		script.append(" begin ");
		script.append("  ValidadorUMStockPrincipal.Value := Sender.AsString; ");
		script.append("  ValidadorUMStockPrincipal.Validar; ");
		script.append(" end. ");
		return script.toString();
	}

	private String getOnValidateUMStockAlternativa() {
		StringBuffer script = new StringBuffer();
		script.append(" begin ");
		script.append("  ValidadorUMStockAlternativa.Value := Sender.AsString; ");
		script.append("  ValidadorUMStockAlternativa.Validar; ");
		script.append(" end. ");
		return script.toString();
	}
	
	private String getOnValidateFormCalcCosto() {
		StringBuffer script = new StringBuffer();
		script.append(" begin ");
		
		script.append("  if (Sender.AsString = '') ");
		script.append("     then begin ");
		script.append("     	 TProductos.EditRecord; ");
		script.append("     	 TProductos.FieldName('desc_forma_calc_costo').AsString := ''; ");
		script.append("     	 exit; ");
		script.append("     	 end; ");
		
		script.append("  TFormaCalcCosto.First; ");
		script.append("  if (not TFormaCalcCosto.Locate('codigo',Sender.AsString,[])) ");
		script.append("     then raiseException(erCustomError,'Código de Forma de Calc. Costo desconocido') ");
		script.append("     else begin ");
		script.append("          TProductos.EditRecord; ");
		script.append("          TProductos.FieldName('desc_forma_calc_costo').AsString := TFormaCalcCosto.FieldName('descripcion').AsString; ");
		script.append("          end; ");
		script.append(" end. ");
		
		return script.toString();
	}

	private String getOnValidateUMProduccion() {
		StringBuffer script = new StringBuffer();
		script.append(" begin ");
		script.append("  ValidadorUMProduccion.Value := Sender.AsString; ");
		script.append("  ValidadorUMProduccion.Validar; ");
		script.append(" end. ");
		return script.toString();
	}

	private String getOnValidateValorClasif(ClasificadorEntidad clasifEnt) {
		StringBuffer script = new StringBuffer();
		script.append(" begin ");
		script.append("   if (Sender.AsString = '') ");
		script.append("      then begin ");
		script.append("           TProductos.FieldName('oid_clasif_"+clasifEnt.getOIDInteger()+"').AsInteger := 0; ");
		script.append("           TProductos.FieldName('desc_clasif_"+clasifEnt.getOIDInteger()+"').AsString := ''; ");
		script.append("           exit; ");
		script.append("      end; ");

		script.append(" operacion.inicioOperacion; ");
		script.append(" operacion.setOper('TraerValorClasifEntidad'); ");
		script.append(" operacion.addAtribute('oid_clasif_ent',IntToStr("+clasifEnt.getOIDInteger()+")); ");
		script.append(" operacion.addAtribute('codigo',Sender.AsString); ");
		script.append(" operacion.addAtribute('solo_titulos',''); ");
		script.append(" operacion.execute; ");

		script.append(" TProductos.FieldName('oid_clasif_"+clasifEnt.getOIDInteger()+"').AsInteger := ");
		script.append("    TValorClaifEntidad.FieldName('oid_valor_clasif_ent').AsInteger; ");
		script.append(" TProductos.FieldName('desc_clasif_"+clasifEnt.getOIDInteger()+"').AsString := ");
		script.append("    TValorClaifEntidad.FieldName('descripcion').AsString; ");

		script.append(" end. ");
		return script.toString();
	}
	
	private String getOnValidateOidProducto() {
		StringBuffer script = new StringBuffer();
		script.append(" begin ");
		script.append("   if (Sender.AsInteger = 0) then exit; ");
		script.append("   operacion.inicioOperacion; ");
		script.append("   operacion.setOper('TraerConsultaMasivaProductos'); ");
		script.append("   operacion.addAtribute('TRAER_DATO_PRODUCTO_EXISTENTE',''); ");
		script.append("   operacion.addAtribute('oid_producto',Sender.AsString); ");
		script.append("   operacion.execute; ");
		script.append("   CopiarRegistro(); ");
		script.append(" end. ");
		return script.toString();
	}
	
	

}
