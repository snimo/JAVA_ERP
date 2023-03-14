package com.srn.erp.contabilidad.bm;

import java.util.Date;

import com.srn.erp.general.bm.ComproCab;
import com.srn.erp.general.bm.Talonario;

import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.Fecha;
import framework.applicarionServer.bm.Seguridad.Usuario;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;
import framework.request.bl.Utils.Validar;

public class AnuladorComproSubReparto extends ComproCab implements IContabilizable {

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

	public AnuladorComproSubReparto() {
	}

	public static String				NICKNAME	= "cg.AnuladorComproSubReparto";

	private ComproSubReparto	comproSubReparto;

	public ComproSubReparto getComproSubReparto() throws BaseException {
		supportRefresh();
		return this.comproSubReparto;
	}

	public void setComproSubReparto(ComproSubReparto aComproSubReparto) {
		this.comproSubReparto = aComproSubReparto;
	}

	public String getNickName() {
		return NICKNAME;
	}

	public static AnuladorComproSubReparto findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (AnuladorComproSubReparto) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static AnuladorComproSubReparto findByOidProxy(Integer oid, ISesion aSesion) throws BaseException {
		return (AnuladorComproSubReparto) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(this.comproSubReparto, "Debe ingresar el SubReparto");

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

	public static AnuladorComproSubReparto getNewComprobante(ISesion aSesion) throws BaseException {
		return (AnuladorComproSubReparto) AnuladorComproSubReparto.getNew(NICKNAME, aSesion);
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
		Talonario talonarioAnulacion = this.getComproSubReparto().getTalonario().getTalonarioAnulacion();
		if (talonarioAnulacion == null)
			throw new ExceptionValidation(null, "No existe talonario de anulación para el talonario "
					+ this.getComproSubReparto().getTalonario().getDescripcion());
		setTalonario(talonarioAnulacion);
		setTipoCompro(talonarioAnulacion.getTipo_comprobante());
		setLetra(talonarioAnulacion.getLetra());
		setLugarEmision(talonarioAnulacion.getLugar_emision());
		setNroext(new Integer(0));
		setEmision(Fecha.getFechaActual());
		setImputac(Fecha.getFechaActual());
		setComentario("Anulación SubReparto " + this.getComproSubReparto().getCodigo());
		setActivo(new Boolean(true));


	}

	public void afterSave() throws BaseException {

		afterSaveComprobante(this);

		anularComprobante(this.getComproSubReparto());

	}

}
