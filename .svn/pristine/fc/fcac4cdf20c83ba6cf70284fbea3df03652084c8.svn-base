package com.srn.erp.ventas.op;

import java.util.Date;
import java.util.Iterator;

import com.srn.erp.general.bm.Cotizacion;
import com.srn.erp.general.bm.Moneda;
import com.srn.erp.stock.bm.Producto;
import com.srn.erp.ventas.bm.CalculadorFactura;
import com.srn.erp.ventas.bm.CalculadorItemFactura;
import com.srn.erp.ventas.bm.CalculadorItemVenta;
import com.srn.erp.ventas.bm.ConceptoTotales;
import com.srn.erp.ventas.bm.CondicionPago;
import com.srn.erp.ventas.bm.ListaPrecios;
import com.srn.erp.ventas.bm.ListaPreciosDet;
import com.srn.erp.ventas.bm.PrecioEnLP;
import com.srn.erp.ventas.bm.Sujeto;
import com.srn.erp.ventas.bm.UnidadEdilicia;

import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bm.Parametros.ValorParametro;
import framework.applicarionServer.bm.Varios.CalculadorCotizacion;
import framework.applicarionServer.bm.Varios.CalculadorMoney;
import framework.applicarionServer.bm.Varios.Money;
import framework.applicarionServer.bm.Varios.NumeroBase;
import framework.applicarionServer.bm.Varios.Porcentaje;
import framework.applicarionServer.bm.Varios.ValorCotizacion;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class CalculadorVentas extends Operation {

	public static final String	PRECIO_A_MOSTRA					= "PRECIO_A_MOSTRAR";

	
	
	public static final String	LEAD_TIME_VTA						= "LEAD_TIME_VTA";

	public static final String	BONIFICACIONES					= "BONIFICACIONES";

	public static final String	CALC_PRECIO_NETO_BONIF	= "CALC_PRECIO_NETO_BONIF";

	public static final String	CALC_TOT_COMPRO_VTAS		= "CALC_TOT_COMPRO_VTAS";
	
	public static final String	BONIF_RECAR_FORMA_PAGO	= "BONIF_RECAR_FORMA_PAGO";

	public CalculadorVentas() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {

		if (mapaDatos.containsKey(PRECIO_A_MOSTRA))
			enviarPrecioAMostrar(mapaDatos);
		if (mapaDatos.containsKey(LEAD_TIME_VTA))
			enviarLeadTimeVta(mapaDatos);
		if (mapaDatos.containsKey(BONIFICACIONES))
			enviarBonificaciones(mapaDatos);
		if (mapaDatos.containsKey(CALC_PRECIO_NETO_BONIF))
			enviarPrecioNetoBonif(mapaDatos);
		if (mapaDatos.containsKey(CALC_TOT_COMPRO_VTAS))
			enviarCalcTotalesComproVtas(mapaDatos);
		if (mapaDatos.containsKey(BONIF_RECAR_FORMA_PAGO))
			enviarBonifRecarFormaPago(mapaDatos);

	}

	private HashTableDatos getCotizaciones(IDataSet ds) throws BaseException {
		HashTableDatos lista = new HashTableDatos();
		ds.first();
		while (!ds.EOF()) {
			if (ds.getInteger("oid_moneda").intValue() == Moneda.getMonedaCursoLegal(this.getSesion()).getOID())
				lista.put(ds.getInteger("oid_moneda"), new ValorCotizacion(1));
			else
				lista.put(ds.getInteger("oid_moneda"), ds.getCotizacion("cotizacion"));
			ds.next();
		}
		return lista;
	}

	private void enviarLeadTimeVta(MapDatos mapaDatos) throws BaseException {
		Producto producto = Producto.findByOidProxy(mapaDatos.getInteger("oid_producto"), this.getSesion());
		IDataSet ds = this.getDataSetEntregaVta();
		ds.append();
		ds.fieldValue("oid_art", producto.getOIDInteger());
		ds.fieldValue("lead_time", producto.getLeadTimeVta());
		writeCliente(ds);
	}

	private void enviarBonificaciones(MapDatos mapaDatos) throws BaseException {

		Sujeto sujeto = Sujeto.findByOid(mapaDatos.getInteger("oid_sujeto"), this.getSesion());
		Producto producto = Producto.findByOid(mapaDatos.getInteger("oid_producto"), this.getSesion());
		CondicionPago formaPago = CondicionPago.findByOid(mapaDatos.getInteger("oid_forma_pago"), this.getSesion());
		Date fecha = mapaDatos.getDate("fecha");
		int cuotas = mapaDatos.getInteger("cuotas").intValue();
		int dias = mapaDatos.getInteger("dias").intValue();

		Porcentaje porcBonif1 = CalculadorItemVenta.getPorcBonif(1, sujeto, producto, formaPago, cuotas, dias, fecha, this
				.getSesion());
		Porcentaje porcBonif2 = CalculadorItemVenta.getPorcBonif(2, sujeto, producto, formaPago, cuotas, dias, fecha, this
				.getSesion());
		Porcentaje porcBonif3 = CalculadorItemVenta.getPorcBonif(3, sujeto, producto, formaPago, cuotas, dias, fecha, this
				.getSesion());

		IDataSet dsPorcBonificaciones = getDataSetBonificaciones();
		dsPorcBonificaciones.create("TBonificaciones");
		dsPorcBonificaciones.append();
		dsPorcBonificaciones.fieldValue("oid_producto", producto.getOIDInteger());
		dsPorcBonificaciones.fieldValue("porc_bonif_1", porcBonif1);
		dsPorcBonificaciones.fieldValue("porc_bonif_2", porcBonif2);
		dsPorcBonificaciones.fieldValue("porc_bonif_3", porcBonif3);

		writeCliente(dsPorcBonificaciones);

		/*
		 * Porcentaje porcBonififEsqProd = new Porcentaje(0); Sujeto sujeto =
		 * Sujeto.findByOid(mapaDatos.getInteger("oid_sujeto"), this.getSesion()); Producto producto =
		 * Producto.findByOid(mapaDatos.getInteger("oid_producto"), this.getSesion()); Date fecha =
		 * mapaDatos.getDate("emision"); porcBonifEsqProd = sujeto.getPorcDtoProducto(producto,fecha);
		 */
	}

	private Porcentaje getPorcBonifDirecta(Porcentaje porc1, Porcentaje porc2, Porcentaje porc3) throws BaseException {
		CalculadorMoney calc = new CalculadorMoney(new NumeroBase(porc1.doubleValue()));
		calc.sumar(new NumeroBase(porc2.doubleValue()));
		calc.sumar(new NumeroBase(porc3.doubleValue()));
		return new Porcentaje(calc.getResult());
	}

	private Porcentaje getPorcBonifEnCascada(Porcentaje porc1, Porcentaje porc2, Porcentaje porc3) throws BaseException {
		CalculadorCotizacion calcPorcBonif1 = new CalculadorCotizacion(new NumeroBase(1 - (porc1.doubleValue() / 100)));
		CalculadorCotizacion calcPorcBonif2 = new CalculadorCotizacion(new NumeroBase(1 - (porc2.doubleValue() / 100)));
		CalculadorCotizacion calcPorcBonif3 = new CalculadorCotizacion(new NumeroBase(1 - (porc3.doubleValue() / 100)));
		CalculadorCotizacion calc = new CalculadorCotizacion(new NumeroBase(1.0));
		calc.multiplicarPor(calcPorcBonif1.getResultNroBase());
		calc.multiplicarPor(calcPorcBonif2.getResultNroBase());
		calc.multiplicarPor(calcPorcBonif3.getResultNroBase());
		CalculadorMoney porcentajeBonif = new CalculadorMoney(new NumeroBase(1.0));
		porcentajeBonif.restar(calc.getResultNroBase());
		porcentajeBonif.multiplicarPor(new NumeroBase(100));
		return new Porcentaje(porcentajeBonif.getResult());
	}

	private void enviarPrecioNetoBonif(MapDatos mapaDatos) throws BaseException {

		Money precioLista = mapaDatos.getMoney("precio_lista");
		Porcentaje porcBonif1 = mapaDatos.getPorcentaje("porc_bonif_1");
		Porcentaje porcBonif2 = mapaDatos.getPorcentaje("porc_bonif_2");
		Porcentaje porcBonif3 = mapaDatos.getPorcentaje("porc_bonif_3");

		Porcentaje porc = null;

		if (isBonifEnCascada(this.getSesion()))
			porc = this.getPorcBonifEnCascada(porcBonif1, porcBonif2, porcBonif3);
		else
			porc = this.getPorcBonifDirecta(porcBonif1, porcBonif2, porcBonif3);

		CalculadorMoney calcBonificacion = new CalculadorMoney(precioLista);
		calcBonificacion.multiplicarPor(porc);
		calcBonificacion.dividirPor(new Money(100));
		Money bonificacion = calcBonificacion.getResultMoney();

		CalculadorMoney calcPrecioNetoBonif = new CalculadorMoney(precioLista);
		calcPrecioNetoBonif.restar(bonificacion);
		Money precioNetoBonif = calcPrecioNetoBonif.getResultMoney();

		IDataSet dsPrecioBonif = getDataSetPrecioBonif();
		dsPrecioBonif.create("TPrecioNetoBonif");
		dsPrecioBonif.append();
		dsPrecioBonif.fieldValue("precio_lista", precioLista);
		dsPrecioBonif.fieldValue("porc_bonif_1", porcBonif1);
		dsPrecioBonif.fieldValue("porc_bonif_2", porcBonif2);
		dsPrecioBonif.fieldValue("porc_bonif_3", porcBonif3);
		dsPrecioBonif.fieldValue("porc_bonif", porc);
		dsPrecioBonif.fieldValue("bonificacion", bonificacion);
		dsPrecioBonif.fieldValue("precio_neto_bonif", precioNetoBonif);

		writeCliente(dsPrecioBonif);

	}

	private void enviarCalcTotalesComproVtas(MapDatos mapaDatos) throws BaseException {

		IDataSet dsCab = mapaDatos.getDataSet("TCabVentas");
		IDataSet dsDet = mapaDatos.getDataSet("TDetVentas");

		dsCab.first();
		CalculadorFactura calcFactura = new CalculadorFactura(this.getSesion());
		calcFactura.setFecha(dsCab.getDate("fecha"));
		calcFactura.setSujeto(Sujeto.findByOidProxy(dsCab.getInteger("oid_sujeto"), this.getSesion()));
		
		if (dsCab.containstAttribute("oid_moneda"))
			calcFactura.setMoneda(Moneda.findByOid(dsCab.getInteger("oid_moneda"),this.getSesion()));
		if (dsCab.containstAttribute("cotizacion"))
		  calcFactura.setCotizacion(dsCab.getCotizacion("cotizacion"));
		UnidadEdilicia unidadEdilicia = UnidadEdilicia.findByOidProxy(dsCab.getInteger("oid_lugar_entrega"), this
				.getSesion());
		calcFactura.setProvincia(unidadEdilicia.getProvincia());

		dsDet.first();
		while (!dsDet.EOF()) {

			CalculadorItemFactura itemFactura = calcFactura.addItemFact();
			itemFactura.setProducto(Producto.findByOidProxy(dsDet.getInteger("oid_producto"), this.getSesion()));
			itemFactura.setCantidad(dsDet.getMoney("cantidad"));
			itemFactura.setPrecioLista(dsDet.getMoney("precio_lista"));
			itemFactura.setPorcBonif1(dsDet.getPorcentaje("porc_bonif_1"));
			itemFactura.setPorcBonif2(dsDet.getPorcentaje("porc_bonif_2"));
			itemFactura.setPorcBonif3(dsDet.getPorcentaje("porc_bonif_3"));
			itemFactura.setPrecioNetoBonif(dsDet.getMoney("precio_bonif"));
			//itemFactura.setImporte(dsDet.getMoney("total"));

			dsDet.next();
		}

		calcFactura.calcular();

		IDataSet dsTotales = this.getDataSetTotalesVta();
		Iterator iterConceptosTotales = calcFactura.getConceptosTotales().iterator();
		while (iterConceptosTotales.hasNext()) {
			ConceptoTotales concTotales = (ConceptoTotales) iterConceptosTotales.next();
			dsTotales.append();
			dsTotales.fieldValue("secu", concTotales.getSecu());
			dsTotales.fieldValue("comportamiento", concTotales.getComportamiento());
			if (concTotales.getConceptoImpuesto() != null)
				dsTotales.fieldValue("oid_conc_impu", concTotales.getConceptoImpuesto().getOIDInteger());
			else
				dsTotales.fieldValue("oid_conc_impu", 0);
			dsTotales.fieldValue("concepto", concTotales.getDescConcepto());
			dsTotales.fieldValue("importe", concTotales.getImporte());

		}

		writeCliente(dsTotales);

	}
	
	private ValorCotizacion getCotizacion(Moneda moneda , HashTableDatos cotizaciones) throws BaseException {
		if (moneda.isMonedaCursoLegal())
			return new ValorCotizacion(1);
		ValorCotizacion cotizacion = (ValorCotizacion) cotizaciones.get(moneda.getOIDInteger());
		return cotizacion;
	}

	private void enviarPrecioAMostrar(MapDatos mapaDatos) throws BaseException {

		ListaPrecios listaPrecios = ListaPrecios.findByOidProxy(mapaDatos.getInteger("oid_lp"), this.getSesion());
		Producto producto = Producto.findByOidProxy(mapaDatos.getInteger("oid_producto"), this.getSesion());
		Sujeto sujeto = Sujeto.findByOidProxy(mapaDatos.getInteger("oid_sujeto"), this.getSesion());
		Date fecha = mapaDatos.getDate("fecha");
		Moneda moneda = Moneda.findByOidProxy(mapaDatos.getInteger("oid_moneda"), this.getSesion());
		IDataSet dsCotiz = mapaDatos.getDataSet("TCotizaciones");

		PrecioEnLP precioAMostrar = 
			producto.getPrecioFactura(listaPrecios, sujeto, fecha);
		
		HashTableDatos cotizaciones = this.getCotizaciones(dsCotiz);
		
		ValorCotizacion cotizOri = getCotizacion(precioAMostrar.getMoneda(),cotizaciones);
		ValorCotizacion cotizDest = getCotizacion(moneda,cotizaciones);
		
		Money precioConvertido = Cotizacion.convertir(precioAMostrar.getPrecio(), cotizOri, cotizDest); 
		
		IDataSet dsPrecioAMostrar = this.getDataSetPrecioAMostrar();
		dsPrecioAMostrar.append();
		dsPrecioAMostrar.fieldValue("precio", precioConvertido);
		dsPrecioAMostrar.fieldValue("oid_um", precioAMostrar.getUm().getOIDInteger());
		dsPrecioAMostrar.fieldValue("cod_um", precioAMostrar.getUm().getCodigo());
		dsPrecioAMostrar.fieldValue("cantidad", precioAMostrar.getCantidad());
		writeCliente(dsPrecioAMostrar);
	}

	private IDataSet getDataSetPrecioAMostrar() {
		IDataSet dataset = new TDataSet();
		dataset.create("TPrecioAMostrar");
		dataset.fieldDef(new Field("precio", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("oid_um", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_um", Field.STRING, 20));
		dataset.fieldDef(new Field("cantidad", Field.CURRENCY, 0));
		return dataset;
	}

	private IDataSet getDataSetEntregaVta() {
		IDataSet dataset = new TDataSet();
		dataset.create("TLeadTimeEntregaVta");
		dataset.fieldDef(new Field("oid_art", Field.INTEGER, 0));
		dataset.fieldDef(new Field("lead_time", Field.INTEGER, 0));
		return dataset;
	}

	private IDataSet getDataSetBonificaciones() {
		IDataSet dataset = new TDataSet();
		dataset.create("TBonificaciones");
		dataset.fieldDef(new Field("oid_producto", Field.INTEGER, 0));
		dataset.fieldDef(new Field("porc_bonif_1", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("porc_bonif_2", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("porc_bonif_3", Field.CURRENCY, 0));
		return dataset;
	}

	private IDataSet getDataSetTotalesVta() {
		IDataSet dataset = new TDataSet();
		dataset.create("TTotalesVta");
		dataset.fieldDef(new Field("secu", Field.INTEGER, 0));
		dataset.fieldDef(new Field("comportamiento", Field.STRING, 100));
		dataset.fieldDef(new Field("oid_conc_impu", Field.INTEGER, 0));
		dataset.fieldDef(new Field("concepto", Field.STRING, 100));
		dataset.fieldDef(new Field("importe", Field.CURRENCY, 0));
		return dataset;
	}

	private IDataSet getDataSetPrecioBonif() {
		IDataSet dataset = new TDataSet();
		dataset.create("TPrecioNetoBonif");
		dataset.fieldDef(new Field("precio_lista", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("porc_bonif_1", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("porc_bonif_2", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("porc_bonif_3", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("porc_bonif", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("bonificacion", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("precio_neto_bonif", Field.CURRENCY, 0));
		return dataset;
	}

	public static boolean isBonifEnCascada(ISesion aSesion) throws BaseException {
		return ValorParametro.findByCodigoParametro("BONIF_EN_CASCADA_VTAS", aSesion).getBoolean();
	}

	private void enviarBonifRecarFormaPago(MapDatos mapaDatos) throws BaseException {

		Integer cuotas = mapaDatos.getInteger("cuotas");
		Integer dias = mapaDatos.getInteger("dias");
		Integer oidFormaPago = mapaDatos.getInteger("oid_forma_pago");
		
		CondicionPago condPago = CondicionPago.findByOid(oidFormaPago,this.getSesion());
		
		IDataSet dataset = new TDataSet();
		dataset.create("TBonifRecarFormaPago");
		dataset.fieldDef(new Field("secu", Field.INTEGER, 0));
		dataset.fieldDef(new Field("bonificacion", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("recargo", Field.CURRENCY, 0));

		dataset.append();
		dataset.fieldValue("secu", new Integer(1));
		dataset.fieldValue("bonificacion", condPago.getPorcBonif(cuotas.intValue(), dias.intValue()));
		dataset.fieldValue("recargo", condPago.getPorcRecar(cuotas.intValue(), dias.intValue()));

		writeCliente(dataset);

	}

}
