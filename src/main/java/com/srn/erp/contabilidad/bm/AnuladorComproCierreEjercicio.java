package com.srn.erp.contabilidad.bm;

import java.util.Date;

import com.srn.erp.general.bm.ComproCab;
import com.srn.erp.general.bm.Talonario;

import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.Fecha;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;
import framework.request.bl.Utils.Validar;

public class AnuladorComproCierreEjercicio extends ComproCab implements IContabilizable {

	private ComproConta	comproConta;

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public AnuladorComproCierreEjercicio() {
	}

	public static String				NICKNAME	= "cg.AnuladorComproCierreEjercicio";

	private ComproCierreEjercicio	comproCierreEjercicio;

	public ComproCierreEjercicio getComproCierreEjericicio() throws BaseException {
		supportRefresh();
		return this.comproCierreEjercicio;
	}

	public void setComproCierreEjercicio(ComproCierreEjercicio aComproCierreEjercicio) {
		this.comproCierreEjercicio = aComproCierreEjercicio;
	}

	public String getNickName() {
		return NICKNAME;
	}

	public static AnuladorComproCierreEjercicio findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (AnuladorComproCierreEjercicio) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static AnuladorComproCierreEjercicio findByOidProxy(Integer oid, ISesion aSesion) throws BaseException {
		return (AnuladorComproCierreEjercicio) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(this.comproCierreEjercicio, "Debe ingresar el Cierre del Ejercicio");

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

	public static AnuladorComproCierreEjercicio getNewComprobante(ISesion aSesion) throws BaseException {
		return (AnuladorComproCierreEjercicio) AnuladorComproCierreEjercicio.getNew(NICKNAME, aSesion);
	}

	public void generarComproAnulacion() throws BaseException {
		// Set datos del comrobante
		setContabiliza(true);
		Talonario talonarioAnulacion = this.getComproCierreEjericicio().getTalonario().getTalonarioAnulacion();
		if (talonarioAnulacion == null)
			throw new ExceptionValidation(null, "No existe talonario de anulación para el talonario "
					+ this.getComproCierreEjericicio().getTalonario().getDescripcion());
		setTalonario(talonarioAnulacion);
		setTipoCompro(talonarioAnulacion.getTipo_comprobante());
		setLetra(talonarioAnulacion.getLetra());
		setLugarEmision(talonarioAnulacion.getLugar_emision());
		setNroext(new Integer(0));
		setEmision(Fecha.getFechaActual());
		setImputac(this.getComproCierreEjericicio().getImputac());
		setComentario("Anulación Cierre Ejercicio " + this.getComproCierreEjericicio().getCodigo());
		setActivo(new Boolean(true));


	}

	public void afterSave() throws BaseException {

		afterSaveComprobante(this);

		anularComprobante(this.getComproCierreEjericicio());

	}

}
