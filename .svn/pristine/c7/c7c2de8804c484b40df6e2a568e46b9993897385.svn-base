package com.srn.erp.tesoreria.op;

import java.util.Iterator;

import com.srn.erp.general.bm.Cotizacion;
import com.srn.erp.general.bm.IdentificacionTipoComprobante;
import com.srn.erp.general.bm.Moneda;
import com.srn.erp.general.bm.Talonario;
import com.srn.erp.tesoreria.bm.Banco;
import com.srn.erp.tesoreria.bm.Caja;
import com.srn.erp.tesoreria.bm.TarjetaCredito;
import com.srn.erp.tesoreria.bm.TipoValor;
import com.srn.erp.tesoreria.bm.Valor;

import framework.applicarionServer.bm.Varios.Money;
import framework.applicarionServer.bm.Varios.ValorCotizacion;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerValoresTarjetasALiq extends Operation {

	private int secu = -1;
	HashTableDatos listaCotizaciones = null;

	public TraerValoresTarjetasALiq() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {

		Moneda moneda = Moneda.findByOid(mapaDatos.getInteger("oid_moneda"), this.getSesion());
		ValorCotizacion cotizacion = mapaDatos.getCotizacion("cotizacion");

		listaCotizaciones = cargarCotizaciones(mapaDatos.getDataSet("TCotizaciones"), moneda, cotizacion);

		Integer oidLiquiTar = mapaDatos.getInteger("oid_liqui_tar");
		Talonario talonario = Talonario.findByOidProxy(mapaDatos.getInteger("oid_talonario"), this.getSesion());
		TipoValor tipoValor = TipoValor.findByOidProxy(mapaDatos.getInteger("oid_tipo_valor"), this.getSesion());
		Integer oidEntidad = mapaDatos.getInteger("oid_entidad");
		TarjetaCredito tarjetaCredito = null;
		Banco banco = null;

		if (talonario.getTipo_comprobante().getIdentificacion().equals(IdentificacionTipoComprobante.LIQUIDACION_TAR_CREDITO)) {
			tarjetaCredito = TarjetaCredito.findByOid(oidEntidad, this.getSesion());
		} else if (talonario.getTipo_comprobante().getIdentificacion().equals(IdentificacionTipoComprobante.LIQUIDACION_TAR_DEBITO)) {
			banco = Banco.findByOid(oidEntidad, this.getSesion());
		}

		Caja caja = null;
		if (mapaDatos.containsKey("oid_caja"))
			caja = Caja.findByOidProxy(mapaDatos.getInteger("oid_caja"), this.getSesion());

		java.util.Date fechaDesde = null;
		if (mapaDatos.containsKey("busc_fec_desde"))
			fechaDesde = mapaDatos.getDate("busc_fec_desde");

		java.util.Date fechaHasta = null;
		if (mapaDatos.containsKey("busc_fec_hasta"))
			fechaHasta = mapaDatos.getDate("busc_fec_hasta");

		IDataSet ds = this.getDataSetValALiqui();

		Iterator iterValores = Valor.getTarjetasPendLiquidar(tipoValor, tarjetaCredito, banco, caja, fechaDesde, fechaHasta,
				this.getSesion()).iterator();
		while (iterValores.hasNext()) {
			Valor valor = (Valor) iterValores.next();
			cargarRegistroValALiquidar(ds, oidLiquiTar, valor , moneda , cotizacion);
		}

		writeCliente(ds);

	}

	private IDataSet getDataSetValALiqui() {
		IDataSet dataset = new TDataSet();
		dataset.create("TValoresALiquidar");
		dataset.fieldDef(new Field("sel", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("oid_valor", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_liquidar_tar", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_caja", Field.INTEGER, 0));
		dataset.fieldDef(new Field("desc_caja", Field.STRING, 50));
		dataset.fieldDef(new Field("nro_tarjeta", Field.STRING, 50));
		dataset.fieldDef(new Field("fec_emision", Field.DATE, 0));
		dataset.fieldDef(new Field("fec_vto", Field.DATE, 0));
		dataset.fieldDef(new Field("importe", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("saldo", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("nro_lote", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cupon", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_autoriz", Field.STRING, 50));
		dataset.fieldDef(new Field("importe_liquidado", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("oid_det", Field.INTEGER, 0));
		dataset.fieldDef(new Field("moneda", Field.STRING, 20));
		dataset.fieldDef(new Field("oid_moneda", Field.INTEGER, 0));
		dataset.fieldDef(new Field("importe_liquidado_mon_valor", Field.CURRENCY, 0));
		return dataset;
	}

	private void cargarRegistroValALiquidar(IDataSet dataset, Integer oidLiquiTar, Valor valor , Moneda monedaLiquidacion, ValorCotizacion cotizacion) throws BaseException {
		dataset.append();
		dataset.fieldValue("sel", new Boolean(false));
		dataset.fieldValue("oid_valor", valor.getOIDInteger());
		dataset.fieldValue("oid_liquidar_tar", oidLiquiTar);
		if (valor.getCaja() != null) {
			dataset.fieldValue("oid_caja", valor.getCaja().getOIDInteger());
			dataset.fieldValue("desc_caja", valor.getCaja().getDescripcion());
		} else {
			dataset.fieldValue("oid_caja", "");
			dataset.fieldValue("desc_caja", "");
		}
		dataset.fieldValue("nro_tarjeta", valor.getNro_tarjeta());
		dataset.fieldValue("fec_emision", valor.getFechaemision());
		dataset.fieldValue("fec_vto", valor.getFechavto());
		dataset.fieldValue("importe", valor.getImporte());
		dataset.fieldValue("saldo", valor.getSaldo());
		dataset.fieldValue("nro_lote", valor.getLote());
		dataset.fieldValue("cupon", valor.getCupon());
		dataset.fieldValue("cod_autoriz", valor.getCodigoAutorizacion());
		
		//ValorCotizacion valorCotizOri = this.getCotizacionMoneda(valor.getTipovalor().getMoneda());
		//Money nuevoImporte = getImporteLiqMonLiq(valor.getSaldo(),valorCotizOri,cotizacion);
		
		dataset.fieldValue("importe_liquidado", 0);
		
		dataset.fieldValue("oid_det", --secu);
		dataset.fieldValue("moneda", valor.getTipovalor().getMoneda().getCodigo());
		dataset.fieldValue("oid_moneda", valor.getTipovalor().getMoneda().getOIDInteger());
		dataset.fieldValue("importe_liquidado_mon_valor",0);
		
	}

	private HashTableDatos cargarCotizaciones(IDataSet dsCotizaciones, Moneda monedaLiq, ValorCotizacion cotizacion) throws BaseException {
		HashTableDatos listaCotizaciones = new HashTableDatos();
		dsCotizaciones.first();
		while (!dsCotizaciones.EOF()) {
			Moneda moneda = Moneda.findByOidProxy(dsCotizaciones.getInteger("oid_moneda"), getSesion());

			if (monedaLiq.getOID() == moneda.getOID())
				listaCotizaciones.put(monedaLiq, cotizacion);
			else {
				ValorCotizacion valorCotiz = dsCotizaciones.getCotizacion("cotizacion");
				listaCotizaciones.put(moneda, valorCotiz);
			}
			dsCotizaciones.next();
		}
		return listaCotizaciones;
	}
	
	public Money getImporteLiqMonLiq(Money importe, ValorCotizacion valorCotizOrigen,ValorCotizacion valorCotizDestino) throws BaseException {
		return Cotizacion.convertir(importe, valorCotizOrigen, valorCotizDestino); 
	}

	public ValorCotizacion getCotizacionMoneda(Moneda aMoneda) throws BaseException {
		if (aMoneda == null)
			throw new ExceptionValidation(null, "Debe ingresar una moneda para poder obtener la cotización");
		if (aMoneda.getOID() == Moneda.getMonedaCursoLegal(getSesion()).getOID())
			return new ValorCotizacion(1);
		Iterator iterMonedas = this.listaCotizaciones.keySet().iterator();
		while (iterMonedas.hasNext()) {
			Moneda moneda = (Moneda) iterMonedas.next();
			if (moneda.getOID() == aMoneda.getOID()) {
				ValorCotizacion valor = (ValorCotizacion) this.listaCotizaciones.get(moneda);
				if (valor.doubleValue() == 0)
					throw new ExceptionValidation(null, "Debe ingresar la cotización de la moneda " + aMoneda.getDescripcion());
				return valor;
			}
		}
		throw new ExceptionValidation(null, "No se encontro cotización para la moneda " + aMoneda.getDescripcion());
	}

}
