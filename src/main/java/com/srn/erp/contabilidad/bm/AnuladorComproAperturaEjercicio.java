package com.srn.erp.contabilidad.bm;

import java.util.Date;

import com.srn.erp.general.bm.ComproCab;
import com.srn.erp.general.bm.Talonario;

import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.Fecha;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;
import framework.request.bl.Utils.Validar;

public class AnuladorComproAperturaEjercicio extends ComproCab implements IContabilizable {

	private ComproConta	comproConta;

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public AnuladorComproAperturaEjercicio() {
	}

	public static String				NICKNAME	= "cg.AnuladorComproAperturaEjercicio";

	private ComproAperturaEjercicio	comproAperturaEjercicio;

	public ComproAperturaEjercicio getComproAperturaEjericicio() throws BaseException {
		supportRefresh();
		return this.comproAperturaEjercicio;
	}

	public void setComproAperturaEjercicio(ComproAperturaEjercicio aComproAperturaEjercicio) {
		this.comproAperturaEjercicio = aComproAperturaEjercicio;
	}

	public String getNickName() {
		return NICKNAME;
	}

	public static AnuladorComproAperturaEjercicio findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (AnuladorComproAperturaEjercicio) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static AnuladorComproAperturaEjercicio findByOidProxy(Integer oid, ISesion aSesion) throws BaseException {
		return (AnuladorComproAperturaEjercicio) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(this.comproAperturaEjercicio, "Debe ingresar el Asiento Apertura del Ejercicio");

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

	public static AnuladorComproAperturaEjercicio getNewComprobante(ISesion aSesion) throws BaseException {
		return (AnuladorComproAperturaEjercicio) AnuladorComproAperturaEjercicio.getNew(NICKNAME, aSesion);
	}

	public void generarComproAnulacion() throws BaseException {
		// Set datos del comrobante
		setContabiliza(true);
		Talonario talonarioAnulacion = this.getComproAperturaEjericicio().getTalonario().getTalonarioAnulacion();
		if (talonarioAnulacion == null)
			throw new ExceptionValidation(null, "No existe talonario de anulación para el talonario "
					+ this.getComproAperturaEjericicio().getTalonario().getDescripcion());
		setTalonario(talonarioAnulacion);
		setTipoCompro(talonarioAnulacion.getTipo_comprobante());
		setLetra(talonarioAnulacion.getLetra());
		setLugarEmision(talonarioAnulacion.getLugar_emision());
		setNroext(new Integer(0));
		setEmision(Fecha.getFechaActual());
		setImputac(this.getComproAperturaEjericicio().getImputac());
		setComentario("Anulación Asiento de Apertura Ejercicio " + this.getComproAperturaEjericicio().getCodigo());
		setActivo(new Boolean(true));


	}

	public void afterSave() throws BaseException {

		afterSaveComprobante(this);

		anularComprobante(this.getComproAperturaEjericicio());

	}

}
