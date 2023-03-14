package com.srn.erp.pagos.bm;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.contabilidad.bm.IContabilizable;
import com.srn.erp.contabilidad.bm.RenglonesAsiento;
import com.srn.erp.general.bm.ComproCab;
import com.srn.erp.general.bm.Talonario;

import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.Fecha;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;
import framework.request.bl.Utils.Validar;

public class AnuladorRendFF extends ComproCab implements IContabilizable {

	private List		comprobantesProveedores			= new ArrayList();
	private boolean	readComprobantesProveedores	= true;
	
	private List    valoresFondoFijo = new ArrayList();
	private boolean readValoresFondoFijo = true;

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return super.getCodigo();
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return super.getCodigo();

	}

	public AnuladorRendFF() {
	}

	public static String				NICKNAME	= "pag.AnuladorRendFF";

	private RendicionFondoFijo	rendicion_ff;

	public RendicionFondoFijo getRendicion_ff() throws BaseException {
		supportRefresh();
		return rendicion_ff;
	}

	public void setRendicion_ff(RendicionFondoFijo aRendicion_ff) {
		this.rendicion_ff = aRendicion_ff;
	}

	public String getNickName() {
		return NICKNAME;
	}

	public static AnuladorRendFF findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (AnuladorRendFF) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static AnuladorRendFF findByOidProxy(Integer oid, ISesion aSesion) throws BaseException {
		return (AnuladorRendFF) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(rendicion_ff, "Debe ingresar el Comprobanre Rend. de Fondo");
		beforeSaveComprobante(this);
		if (this.isNew())
			this.setEstado(ComproCab.ESTADO_ALTA);
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

	public void generarComproAnulacion() throws BaseException {
		// Set datos del comrobante
		setContabiliza(true);
		Talonario talonarioAnulacion = this.getRendicion_ff().getTalonario().getTalonarioAnulacion();
		if (talonarioAnulacion == null)
			throw new ExceptionValidation(null, "No existe talonario de anulación para el talonario "
					+ this.getRendicion_ff().getTalonario().getDescripcion());
		setTalonario(talonarioAnulacion);
		setTipoCompro(talonarioAnulacion.getTipo_comprobante());
		setLetra(talonarioAnulacion.getLetra());
		setLugarEmision(talonarioAnulacion.getLugar_emision());
		setNroext(new Integer(0));
		setEmision(Fecha.getFechaActual());
		setImputac(Fecha.getFechaActual());
		setComentario("Anulación Rend. F.F. " + this.getRendicion_ff().getCodigo());
		setActivo(new Boolean(true));
		
		Iterator iterRendFFComproProv = this.getRendicion_ff().getComproProvRendFF().iterator();
		while (iterRendFFComproProv.hasNext()) {
			RendicionFondoFijoCompro rendFFCompro = 
				(RendicionFondoFijoCompro)iterRendFFComproProv.next();
			AnuladorRendFFComproProv anuladorRendFFComproProv =
				(AnuladorRendFFComproProv) AnuladorRendFFComproProv.getNew(AnuladorRendFFComproProv.NICKNAME,this.getSesion());
			anuladorRendFFComproProv.setAnulador_rend_ff(this);
			anuladorRendFFComproProv.setRendicion_ff_det(rendFFCompro);
			this.addAnuladorRendFFComproProv(anuladorRendFFComproProv);
		}
		
		Iterator iterRendFFValores = this.getRendicion_ff().getDetallesMediosPago().iterator();
		while (iterRendFFValores.hasNext()) {
			RendicionFondoFijoMedioPago rendFFValor = 
				(RendicionFondoFijoMedioPago)iterRendFFValores.next();
			AnuladorRendFFValores anuladorRendFFValores =
				(AnuladorRendFFValores) AnuladorRendFFValores.getNew(AnuladorRendFFValores.NICKNAME,this.getSesion());
			anuladorRendFFValores.setAnulador_rend_ff(this);
			anuladorRendFFValores.setRend_medio_pago(rendFFValor);
			this.addAnuladorRendFFValor(anuladorRendFFValores);
		}
		

		
		/*
		 * Iterator iterValRecibo = this.getRecibo().getValoresRecibo().iterator(); while (iterValRecibo.hasNext()) {
		 * ValoresRecibo valorRecibo = (ValoresRecibo) iterValRecibo.next(); ValoresReciboAnulado valRecAnu =
		 * (ValoresReciboAnulado)ValoresReciboAnulado.getNew(ValoresReciboAnulado.NICKNAME,this.getSesion());
		 * valRecAnu.setAnulador_recibo(this); valRecAnu.setValor_recibo(valorRecibo); addValorReciboAnulado(valRecAnu); }
		 */

	}

	public void afterSave() throws BaseException {

		afterSaveComprobante(this);

		anularComprobante(this.getRendicion_ff());

		Iterator iterComproProv = this.comprobantesProveedores.iterator();
		while (iterComproProv.hasNext()) {
			AnuladorRendFFComproProv anuladorRendFFComproProv =
				(AnuladorRendFFComproProv) iterComproProv.next();
			anuladorRendFFComproProv.save();
			anuladorRendFFComproProv = null;
		}
		iterComproProv = null;
		
		Iterator iterValores = this.valoresFondoFijo.iterator();
		while (iterValores.hasNext()) {
			AnuladorRendFFValores anuladorRendFFValores =
				(AnuladorRendFFValores) iterValores.next();
			anuladorRendFFValores.save();
			anuladorRendFFValores = null;
		}
		iterValores = null;
		

	}

	public void addAnuladorRendFFComproProv(AnuladorRendFFComproProv anuladorRendFFComproProv) throws BaseException {
		anuladorRendFFComproProv.setAnulador_rend_ff(this);
		this.comprobantesProveedores.add(anuladorRendFFComproProv);
	}
	
	public void addAnuladorRendFFValor(AnuladorRendFFValores anuladorRendFFValor) throws BaseException {
		anuladorRendFFValor.setAnulador_rend_ff(this);
		this.valoresFondoFijo.add(anuladorRendFFValor);
	}
	

	public List getComproProvRendFFAnu() throws BaseException {
		if (this.readComprobantesProveedores) {
			List listaComproProvAnu = AnuladorRendFFComproProv.getComproProvAnulados(this, getSesion());
			this.comprobantesProveedores.addAll(listaComproProvAnu);
			this.readComprobantesProveedores = false;
		}
		return this.comprobantesProveedores;
	}

}
