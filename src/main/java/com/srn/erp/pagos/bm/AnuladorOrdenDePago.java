package com.srn.erp.pagos.bm;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.contabilidad.bm.ComproConta;
import com.srn.erp.contabilidad.bm.IContabilizable;
import com.srn.erp.contabilidad.bm.RenglonesAsiento;
import com.srn.erp.ctasAPagar.bm.AplicacionComproProv;
import com.srn.erp.general.bm.ComproCab;
import com.srn.erp.general.bm.Talonario;

import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.Fecha;
import framework.applicarionServer.bm.Seguridad.Usuario;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;
import framework.request.bl.Utils.Validar;

public class AnuladorOrdenDePago extends ComproCab implements IContabilizable {

	private List				valoresAnul			= new ArrayList();

	private boolean			readValoresAnu	= true;

	private Date				fecImputacion;

	private Usuario			usuario;

	private String			comentario;

	private ComproConta	comproConta;

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public AnuladorOrdenDePago() {
	}

	public static String				NICKNAME	= "pag.AnuladorOrdenDePago";

	private ComproOrdenPagoCab	ordenDePago;

	public ComproOrdenPagoCab getOrdenDePago() throws BaseException {
		supportRefresh();
		return this.ordenDePago;
	}

	public void setOrdenDePago(ComproOrdenPagoCab aOrdenPago) {
		this.ordenDePago = aOrdenPago;
	}

	public String getNickName() {
		return NICKNAME;
	}

	public static AnuladorOrdenDePago findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (AnuladorOrdenDePago) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static AnuladorOrdenDePago findByOidProxy(Integer oid, ISesion aSesion) throws BaseException {
		return (AnuladorOrdenDePago) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(this.ordenDePago, "Debe ingresar la Orden de Pago");

		beforeSaveComprobante(this);
		if (this.isNew()) {
			this.setEstado(ComproCab.ESTADO_ALTA);
		}

	}

	public ComproCab getComprobante() throws BaseException {
		// TODO Auto-generated method stub
		return this;
	}

	public Date getImputacion() throws BaseException {
		// TODO Auto-generated method stub
		return getImputac();
	}

	public RenglonesAsiento getRenglonesAsiento() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public static AnuladorOrdenDePago getNewComprobante(ISesion aSesion) throws BaseException {
		AnuladorOrdenDePago anuladorOrdenDePago = null;
		anuladorOrdenDePago = (AnuladorOrdenDePago) AnuladorOrdenDePago.getNew(NICKNAME, aSesion);
		return anuladorOrdenDePago;
	}

	public Date getFecImputacion() throws BaseException {
		supportRefresh();
		return fecImputacion;
	}

	public void setFecImputacion(Date aFecimputacion) {
		this.fecImputacion = aFecimputacion;
	}

	public Usuario getUsuario() throws BaseException {
		supportRefresh();
		return usuario;
	}

	public void setUsuario(Usuario aUsuario) {
		this.usuario = aUsuario;
	}

	public String getComentario() throws BaseException {
		supportRefresh();
		return comentario;
	}

	public void setComentario(String aComentario) {
		this.comentario = aComentario;
	}

	public void generarComproAnulacion() throws BaseException {
		// Set datos del comrobante
		setContabiliza(true);
		Talonario talonarioAnulacion = this.getOrdenDePago().getTalonario().getTalonarioAnulacion();
		if (talonarioAnulacion == null)
			throw new ExceptionValidation(null, "No existe talonario de anulación para el talonario "
					+ this.getOrdenDePago().getTalonario().getDescripcion());
		setTalonario(talonarioAnulacion);
		setTipoCompro(talonarioAnulacion.getTipo_comprobante());
		setLetra(talonarioAnulacion.getLetra());
		setLugarEmision(talonarioAnulacion.getLugar_emision());
		setNroext(new Integer(0));
		setEmision(Fecha.getFechaActual());
		setImputac(Fecha.getFechaActual());
		setComentario("Anulación Orden de Pago " + this.getOrdenDePago().getCodigo());
		setActivo(new Boolean(true));

		Iterator iterMediosPago = this.getOrdenDePago().getMediosPagos().iterator();
		while (iterMediosPago.hasNext()) {
			ComproOrdenPagoMediosPago comproOrdenPagoMedioPago = (ComproOrdenPagoMediosPago) iterMediosPago.next();

			AnuladorOPMedPago anuladorOPMedPago = (AnuladorOPMedPago) AnuladorOPMedPago.getNew(AnuladorOPMedPago.NICKNAME,
					this.getSesion());
			anuladorOPMedPago.setAnulador_op_cab(this);
			anuladorOPMedPago.setMedio_pago(comproOrdenPagoMedioPago);
			addAnuladorMedioPago(anuladorOPMedPago);
		}

	}

	public void afterSave() throws BaseException {

		afterSaveComprobante(this);

		anularComprobante(this.getOrdenDePago());

		Iterator iterValoresAnulados = this.valoresAnul.iterator();
		while (iterValoresAnulados.hasNext()) {
			AnuladorOPMedPago anuladorOPMedPago = (AnuladorOPMedPago) iterValoresAnulados.next();
			anuladorOPMedPago.save();
			anuladorOPMedPago = null;
		}
		iterValoresAnulados = null;

		// Anular aplicaciones realizadas a traves de la consulta de cuenta corriente
		Iterator iterAplicComproProv = 
			AplicacionComproProv.getAplicacionesActivasCompro(this.getOrdenDePago(), this.getSesion()).iterator();
		while (iterAplicComproProv.hasNext()) {
			AplicacionComproProv aplicComproProv = (AplicacionComproProv) iterAplicComproProv.next();
			aplicComproProv.setActivo(false);
			aplicComproProv.delete();
			aplicComproProv.save();
		}
		
	}

	public List getValoresAnulados() throws BaseException {
		if (this.readValoresAnu) {
			List listaValoresAnulados = AnuladorOPMedPago.getAnuladoresMediosPago(this, getSesion());
			this.valoresAnul.addAll(listaValoresAnulados);
			this.readValoresAnu = false;
		}
		return this.valoresAnul;
	}

	public void addAnuladorMedioPago(AnuladorOPMedPago anuladorOPMedPago) throws BaseException {
		anuladorOPMedPago.setAnulador_op_cab(this);
		this.valoresAnul.add(anuladorOPMedPago);
	}

}
