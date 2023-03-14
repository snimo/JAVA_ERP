package com.srn.erp.pagos.op;

import com.srn.erp.general.bm.InformarComprobante;
import com.srn.erp.general.bm.Moneda;
import com.srn.erp.general.bm.Talonario;
import com.srn.erp.pagos.bm.ComproOrdenPagoCab;
import com.srn.erp.pagos.bm.ComproOrdenPagoDet;
import com.srn.erp.pagos.bm.ConceptoOPVarias;
import com.srn.erp.pagos.bm.MotivoPago;
import com.srn.erp.tesoreria.bm.Caja;
import com.srn.erp.tesoreria.bm.MedioPago;
import com.srn.erp.tesoreria.bm.TipoValor;

import framework.applicarionServer.bm.Varios.ValorCotizacion;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SavePagosVariosEfectivo extends Operation {

	private ComproOrdenPagoCab	comproordenpagocab	= null;

	public SavePagosVariosEfectivo() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {

		IDataSet dataset = mapaDatos.getDataSet("TOrdPagoCab");
		IDataSet dsCotizaciones = null;
		if (mapaDatos.containsKey("TCotizaciones"))
			dsCotizaciones = mapaDatos.getDataSet("TCotizaciones");
		procesarRegistros(dataset, dsCotizaciones);
	}

	private void procesarRegistros(IDataSet dataset, IDataSet dsCotizaciones) throws BaseException {
		dataset.first();
		while (!dataset.EOF()) {
			
			comproordenpagocab = ComproOrdenPagoCab.findByOid(dataset.getInteger("oid"), getSesion());
			
			if ((!comproordenpagocab.isNew()) && (comproordenpagocab.isActivo().booleanValue())) {
				if (dataset.getBoolean("activo").booleanValue()==false) {
					comproordenpagocab.delete();
					this.addTransaccion(comproordenpagocab);
					return;
				}
			}
			
			comproordenpagocab.cargarCotizaciones(dsCotizaciones);
			comproordenpagocab.setContabiliza(ComproOrdenPagoCab.getContabilizarOPVariasEfectivo(getSesion()));
			Talonario talonario = Talonario.findByOidProxy(dataset.getInteger("oid_talonario"), this.getSesion());
			comproordenpagocab.setTalonario(talonario);
			comproordenpagocab.setTipoCompro(talonario.getTipo_comprobante());
			comproordenpagocab.setLetra(talonario.getLetra());
			comproordenpagocab.setLugarEmision(talonario.getLugar_emision());
			comproordenpagocab.setComentario("");
			comproordenpagocab.setEmision(dataset.getDate("fecha"));
			comproordenpagocab.setImputac(dataset.getDate("fecha"));
			comproordenpagocab.setFecemision(dataset.getDate("fecha"));
			comproordenpagocab.setMotivopago(MotivoPago.findByOid(dataset.getInteger("oid_motivo_pago"), getSesion()));
			comproordenpagocab.setMoneda(Moneda.findByOid(dataset.getInteger("oid_moneda"), getSesion()));
			comproordenpagocab.setCotizacion(dataset.getDouble("cotizacion"));
			comproordenpagocab.setCaja(Caja.findByOid(dataset.getInteger("oid_caja"), getSesion()));
			comproordenpagocab.setTotalPago(dataset.getMoney("total_pago"));
			comproordenpagocab.setActivo(new Boolean(true));

			Moneda moneda = Moneda.findByOidProxy(dataset.getInteger("oid_moneda"), getSesion());
			ValorCotizacion cotizacionMonOP = dataset.getCotizacion("cotizacion");
			comproordenpagocab.addCotizacionMoneda(moneda, cotizacionMonOP);

			IDataSet dsConceptos = dataset.getDataSet("TConceptosPagosVarios");
			dsConceptos.first();
			while (!dsConceptos.EOF()) {

				ComproOrdenPagoDet comproOrdenPagoDet = ComproOrdenPagoDet.findByOid(dsConceptos
						.getInteger("oid_compro_det_op"), getSesion());

				comproOrdenPagoDet.setComprobante(comproordenpagocab);
				comproOrdenPagoDet.setMoneda(comproordenpagocab.getMoneda());
				comproOrdenPagoDet.setConceptoOPVarias(ConceptoOPVarias.findByOidProxy(dsConceptos.getInteger("oid_conc_pv"),
						this.getSesion()));

        comproOrdenPagoDet.setValorCotizOriHoy(comproordenpagocab.getCotizacionMoneda(comproordenpagocab.getMoneda()));
        comproOrdenPagoDet.setValorCotizExt1Hoy(comproordenpagocab.getCotizMonExt1());
        comproOrdenPagoDet.setValorCotizExt2Hoy(comproordenpagocab.getCotizMonExt2());
				
				comproOrdenPagoDet.setNetopagomonpago(dsConceptos.getMoney("importe"));
				comproOrdenPagoDet.setNetopagomonori(dsConceptos.getMoney("importe"));
				comproOrdenPagoDet.setNetoPagoMonLoc(comproordenpagocab.getImporteEnMonLoc(dsConceptos.getMoney("importe"),
						comproordenpagocab.getMoneda()));
				comproOrdenPagoDet.setComentario(dsConceptos.getString("comentario"));
				comproordenpagocab.addOrdenPagoDet(comproOrdenPagoDet);

				dsConceptos.next();
			}

			MedioPago medioPago = comproordenpagocab.addMedioPago();
			medioPago.setIngresoEgreso(MedioPago.EGRESO);
			medioPago.setFechaContable(comproordenpagocab.getFecemision());

			TipoValor tipoValor = null;
			if (comproordenpagocab.getMoneda().isMonedaCursoLegal())
				tipoValor = TipoValor.getTipoValorEfectivoPesos(this.getSesion());
			else
				throw new ExceptionValidation(null, "La moneda ingresada debe ser la Moneda "
						+ Moneda.getMonedaCursoLegal(this.getSesion()).getDescripcion());
			medioPago.setCaja(Caja.findByOidProxy(dataset.getInteger("oid_caja"),this.getSesion()));
			medioPago.setTipoValor(tipoValor);
			medioPago.setImporteMonedaPago(dataset.getMoney("total_pago"));
			medioPago.setImporteMonedaValor(dataset.getMoney("total_pago"));
			medioPago.setCotizMonedaValor(dataset.getCotizacion("cotizacion"));
			medioPago.setImportesContables(comproordenpagocab.getImportesContables(dataset.getMoney("total_pago"), medioPago
					.getTipoValor().getMoneda(), comproordenpagocab.getFecemision()));

			addTransaccion(comproordenpagocab);
			dataset.next();
		}
	}

	protected void afterSave() throws BaseException {

		InformarComprobante infoCompro = new InformarComprobante(comproordenpagocab.getOIDInteger(), comproordenpagocab
				.getDescripcion());

		writeCliente(infoCompro.getDataSetInfoCompro());

	}

}
