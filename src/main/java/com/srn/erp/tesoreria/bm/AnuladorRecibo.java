package com.srn.erp.tesoreria.bm;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.contabilidad.bm.ComproConta;
import com.srn.erp.contabilidad.bm.IContabilizable;
import com.srn.erp.contabilidad.bm.RenglonesAsiento;
import com.srn.erp.ctasACobrar.bm.AplicacionComproClie;
import com.srn.erp.general.bm.ComproCab;
import com.srn.erp.general.bm.Talonario;

import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.Fecha;
import framework.applicarionServer.bm.Seguridad.Usuario;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;
import framework.request.bl.Utils.Validar;

public class AnuladorRecibo extends ComproCab implements IContabilizable {

	private List valoresRecAnul = new ArrayList();
	private boolean readValoresRecAnu = true;

	private Date fecImputacion;

	private Usuario usuario;

	private String comentario;

	private ComproConta comproConta;

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public AnuladorRecibo() {
	}

	public static String NICKNAME = "te.AnuladorRecibo";

	private Recibo recibo;

	public Recibo getRecibo() throws BaseException {
		supportRefresh();
		return recibo;
	}

	public void setRecibo(Recibo aRecibo) {
		this.recibo = aRecibo;
	}

	public String getNickName() {
		return NICKNAME;
	}

	public static AnuladorRecibo findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (AnuladorRecibo) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static AnuladorRecibo findByOidProxy(Integer oid, ISesion aSesion) throws BaseException {
		return (AnuladorRecibo) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(recibo, "Debe ingresar el Recibo");

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

	public static AnuladorRecibo getNewComprobante(ISesion aSesion) throws BaseException {
		AnuladorRecibo anuladorRecibo = null;
		anuladorRecibo = (AnuladorRecibo) AnuladorRecibo.getNew(NICKNAME, aSesion);
		return anuladorRecibo;
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
		Talonario talonarioAnulacion = this.getRecibo().getTalonario().getTalonarioAnulacion();
		if (talonarioAnulacion == null)
			throw new ExceptionValidation(null, "No existe talonario de anulación para el talonario "
					+ this.getRecibo().getTalonario().getDescripcion());
		setTalonario(talonarioAnulacion);
		setTipoCompro(talonarioAnulacion.getTipo_comprobante());
		setLetra(talonarioAnulacion.getLetra());
		setLugarEmision(talonarioAnulacion.getLugar_emision());
		setNroext(new Integer(0));
		setEmision(Fecha.getFechaActual());
		setImputac(Fecha.getFechaActual());
		setComentario("Anulación Recibo " + this.getRecibo().getCodigo());
		setActivo(new Boolean(true));

		Iterator iterValRecibo = this.getRecibo().getValoresRecibo().iterator();
		while (iterValRecibo.hasNext()) {
			ValoresRecibo valorRecibo = (ValoresRecibo) iterValRecibo.next();
			ValoresReciboAnulado valRecAnu = (ValoresReciboAnulado) ValoresReciboAnulado.getNew(ValoresReciboAnulado.NICKNAME, this
					.getSesion());
			valRecAnu.setAnulador_recibo(this);
			valRecAnu.setValor_recibo(valorRecibo);
			addValorReciboAnulado(valRecAnu);
		}

	}

	public void afterSave() throws BaseException {

		afterSaveComprobante(this);

		anularComprobante(this.getRecibo());

		Iterator iterValoresRecAnu = this.valoresRecAnul.iterator();
		while (iterValoresRecAnu.hasNext()) {
			ValoresReciboAnulado valRecAnu = (ValoresReciboAnulado) iterValoresRecAnu.next();
			valRecAnu.save();
			valRecAnu = null;
		}
		iterValoresRecAnu = null;

		// Anular aplicaciones
		Iterator iterAplicComproClie = AplicacionComproClie.getAplicacionesActivasCompro(this.getRecibo(), this.getSesion()).iterator();
		while (iterAplicComproClie.hasNext()) {
			AplicacionComproClie aplicComproClie = (AplicacionComproClie) iterAplicComproClie.next();
			aplicComproClie.setActivo(false);
			aplicComproClie.delete();
			aplicComproClie.save();
		}

	}

	public List getValoresReciboAnulado() throws BaseException {
		if (this.readValoresRecAnu) {
			List listaValoresRecAnu = ValoresReciboAnulado.getValoresReciboAnulados(this, getSesion());
			this.valoresRecAnul.addAll(listaValoresRecAnu);
			readValoresRecAnu = false;
		}
		return valoresRecAnul;
	}

	public void addValorReciboAnulado(ValoresReciboAnulado valorReciboAnulado) throws BaseException {
		valorReciboAnulado.setAnulador_recibo(this);
		this.valoresRecAnul.add(valorReciboAnulado);
	}

}
