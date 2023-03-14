package com.srn.erp.ventas.bm;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.contabilidad.bm.IContabilizable;
import com.srn.erp.contabilidad.bm.RenglonesAsiento;
import com.srn.erp.ctasACobrar.bm.AplicClieVto;
import com.srn.erp.ctasACobrar.bm.AplicacionComproClie;
import com.srn.erp.general.bm.ComproCab;
import com.srn.erp.general.bm.Talonario;
import com.srn.erp.stock.bm.IStockeable;
import com.srn.erp.stock.bm.RenglonesStock;

import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.Fecha;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;
import framework.request.bl.Utils.Validar;

public class AnuladorFactCab extends ComproCab implements IStockeable , IContabilizable {

	private ComproCab comprobante;
	private List detallesFactAnu = new ArrayList();
	private List valoresAnu = new ArrayList();

	public AnuladorFactCab() {
	}

	public static String NICKNAME = "ve.AnuladorFactCab";

	private FacturaCab factura_cab;

	public FacturaCab getFactura_cab() throws BaseException {
		supportRefresh();
		return factura_cab;
	}

	public void setFactura_cab(FacturaCab aFactura_cab) {
		this.factura_cab = aFactura_cab;
	}

	public String getNickName() {
		return NICKNAME;
	}

	public static AnuladorFactCab findByOid(Integer oid, ISesion aSesion)
			throws BaseException {
		return (AnuladorFactCab) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static AnuladorFactCab findByOidProxy(Integer oid, ISesion aSesion)
			throws BaseException {
		return (AnuladorFactCab) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}

	public static AnuladorFactCab findByCodigo(String codigo, ISesion aSesion)
			throws BaseException {
		return (AnuladorFactCab) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void setComprobante(ComproCab aComprobante) {
		this.comprobante = aComprobante;
	}

	public void beforeSave() throws BaseException {

		if (this.isNew()) {

			this.setComprobante(this);
			this.setEstado(ComproCab.ESTADO_ALTA);
			this.setActivo(new Boolean(true));

		}

		beforeSaveComprobante(this);

		Validar.noNulo(factura_cab, "Debe ingresar la Factura");

	}

	public ComproCab getComprobante() throws BaseException {
		return comprobante;
	}

	public void generarComproAnulacion() throws BaseException {
		// Set datos del comrobante
		setContabiliza(true);
		Talonario talonarioAnulacion = this.getFactura_cab().getTalonario().getTalonarioAnulacion();
		if (talonarioAnulacion == null)
			throw new ExceptionValidation(null,
					"No existe talonario de anulación para el talonario "
							+ this.getFactura_cab().getTalonario()
									.getDescripcion());
		setTalonario(talonarioAnulacion);
		setTipoCompro(talonarioAnulacion.getTipo_comprobante());
		setLetra(talonarioAnulacion.getLetra());
		setLugarEmision(talonarioAnulacion.getLugar_emision());
		setNroext(new Integer(0));
		setEmision(Fecha.getFechaActual());
		setImputac(Fecha.getFechaActual());
		setComentario("Anulación  " + this.getFactura_cab().getCodigo());
		setActivo(new Boolean(true));

		Iterator iterFacturaDet = this.getFactura_cab().getItemsFactura()
				.iterator();
		while (iterFacturaDet.hasNext()) {
			FacturaDet factDet = (FacturaDet) iterFacturaDet.next();
			AnuladorFactCabDet anuFactDet = (AnuladorFactCabDet) AnuladorFactCabDet
					.getNew(AnuladorFactCabDet.NICKNAME, this.getSesion());
			anuFactDet.setAnulador_factura_cab(this);
			anuFactDet.setFactura_det(factDet);
			addFacturaDetAnulador(anuFactDet);
		}
		
		Iterator iterCobVtaMos =
			this.getFactura_cab().getCobranzasMostrador().iterator();
		while (iterCobVtaMos.hasNext()) {
			CobranzaVtaMostrador cobVtaMos = (CobranzaVtaMostrador) iterCobVtaMos.next();
			AnuladorCobVtaMos anuCobVtaMos = (AnuladorCobVtaMos) AnuladorCobVtaMos.getNew(AnuladorCobVtaMos.NICKNAME, this.getSesion());
			anuCobVtaMos.setCobranza_vta_mos(cobVtaMos);
			anuCobVtaMos.setAnuladorFactura_cab(this);
			addValorCobradoAnulador(anuCobVtaMos);
		}

	}

	public void addFacturaDetAnulador(AnuladorFactCabDet anuladorFactDet)
			throws BaseException {
		anuladorFactDet.setAnulador_factura_cab(this);
		this.detallesFactAnu.add(anuladorFactDet);
	}
	
	public void addValorCobradoAnulador(AnuladorCobVtaMos aAnuladorCobVtaMos) throws BaseException {
		aAnuladorCobVtaMos.setAnuladorFactura_cab(this);
		this.valoresAnu.add(aAnuladorCobVtaMos);
	}
	
	
	public void afterSave() throws BaseException {

		afterSaveComprobante(this);

		anularComprobante(this.getFactura_cab());
		
		Iterator iterDetAnu = this.detallesFactAnu.iterator();
		while (iterDetAnu.hasNext()) {
			AnuladorFactCabDet anuFactCabDet = (AnuladorFactCabDet) iterDetAnu.next();
			anuFactCabDet.save();
			anuFactCabDet = null;
		}
		iterDetAnu = null;
		
		Iterator iterAnuValCob = this.valoresAnu.iterator();
		while (iterAnuValCob.hasNext()) {
			AnuladorCobVtaMos anuCobVtaMos = (AnuladorCobVtaMos) iterAnuValCob.next();
			anuCobVtaMos.save();
			anuCobVtaMos = null;
		}
		iterAnuValCob = null;
		
		// Anular aplicaciones
		Iterator iterAplicComproClie = AplicacionComproClie.getAplicacionesActivasCompro(this.getFactura_cab(), this.getSesion())
				.iterator();
		while (iterAplicComproClie.hasNext()) {
			AplicacionComproClie aplicComproClie = (AplicacionComproClie) iterAplicComproClie.next();
			aplicComproClie.setActivo(false);
			aplicComproClie.delete();
			aplicComproClie.save();
		}

		// Validar que no tenga aplicaciones activas
		List aplicacionesActivas = this.getFactura_cab().getAplicacionesActivasCompro();
		if (!aplicacionesActivas.isEmpty()) {

			StringBuffer listaComprobantes = new StringBuffer("");
			Iterator iterAplicActivas = aplicacionesActivas.iterator();
			while (iterAplicActivas.hasNext()) {
				AplicClieVto aplClie = (AplicClieVto) iterAplicActivas.next();
				listaComprobantes.append(" " + aplClie.getCompro_ori().getCodigo());
			}
			throw new ExceptionValidation(null, "El comprobante no puede anularse debido a que tiene comprobantes asociados:"
					+ listaComprobantes.toString());
		}

		aplicacionesActivas = this.getFactura_cab().getAplicacionesActivasDelCompro();
		if (!aplicacionesActivas.isEmpty()) {

			StringBuffer listaComprobantes = new StringBuffer("");
			Iterator iterAplicActivas = aplicacionesActivas.iterator();
			while (iterAplicActivas.hasNext()) {
				AplicClieVto aplClie = (AplicClieVto) iterAplicActivas.next();
				listaComprobantes.append(" " + aplClie.getComprobante().getCodigo());
			}

			throw new ExceptionValidation(null, "El comprobante no puede anularse debido a que tiene comprobantes asociados:"
					+ listaComprobantes.toString());
		}
		
		
					

	}
	
	public RenglonesStock getRenglonesStock() throws BaseException {
		if (this.getFactura_cab().getStockCabecera()==null)
			return null;
		else
			return this.getFactura_cab().getStockCabecera().getRenglonesStockInvertidos(this);
	}
	
	public RenglonesAsiento getRenglonesAsiento() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public Date getImputacion() throws BaseException {
		// TODO Auto-generated method stub
		return getImputac();
	}
	

}
