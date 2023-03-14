package com.srn.erp.ctasACobrar.bm;

import java.util.Date;

import com.srn.erp.contabilidad.bm.IContabilizable;
import com.srn.erp.contabilidad.bm.RenglonesAsiento;
import com.srn.erp.general.bm.ComproCab;
import com.srn.erp.general.bm.Talonario;

import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.Fecha;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;
import framework.request.bl.Utils.Validar;

public class AnuladorComproClieAplic extends ComproCab implements
		IContabilizable {

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public AnuladorComproClieAplic() {
	}

	public static String NICKNAME = "cac.AnuladorComproClieAplic";

	private AplicacionComproClie compro_aplic_cliente;

	public AplicacionComproClie getCompro_aplic_cliente() throws BaseException {
		supportRefresh();
		return compro_aplic_cliente;
	}

	public void setCompro_aplic_cliente(
			AplicacionComproClie aCompro_aplic_cliente) {
		this.compro_aplic_cliente = aCompro_aplic_cliente;
	}

	public String getNickName() {
		return NICKNAME;
	}

	public static AnuladorComproClieAplic findByOid(Integer oid, ISesion aSesion)
			throws BaseException {
		return (AnuladorComproClieAplic) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static AnuladorComproClieAplic findByCodigo(String codigo,
			ISesion aSesion) throws BaseException {
		return (AnuladorComproClieAplic) getObjectByCodigo(NICKNAME, codigo,
				aSesion);
	}

	public void beforeSave() throws BaseException {

		Validar
				.noNulo(this.compro_aplic_cliente,
						"Debe ingresar la Aplicación");

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

	public void afterSave() throws BaseException {

		afterSaveComprobante(this);

		anularComprobante(this.getCompro_aplic_cliente());

	}
	
	public void generarComproAnulacion() throws BaseException {
		// Set datos del comrobante
		setContabiliza(true);
		Talonario talonarioAnulacion = this.getCompro_aplic_cliente().getTalonario().getTalonarioAnulacion();
		if (talonarioAnulacion == null)
			throw new ExceptionValidation(null, "No existe talonario de anulación para el talonario "
					+ this.getCompro_aplic_cliente().getTalonario().getDescripcion());
		setTalonario(talonarioAnulacion);
		setTipoCompro(talonarioAnulacion.getTipo_comprobante());
		setLetra(talonarioAnulacion.getLetra());
		setLugarEmision(talonarioAnulacion.getLugar_emision());
		setNroext(new Integer(0));
		setEmision(Fecha.getFechaActual());
		setImputac(Fecha.getFechaActual());
		setComentario("Anulación Aplicación " + this.getCompro_aplic_cliente().getCodigo());
		setActivo(new Boolean(true));

	}
	
	protected void beforeSaveNew() throws BaseException {

		// TODO Auto-generated method stub
		super.beforeSaveNew();
		
		DesAplicarCtaCteClie desAplicarCtaCteClie =
			new DesAplicarCtaCteClie(this.getSesion());
		desAplicarCtaCteClie.desaplicar(this.getCompro_aplic_cliente());
		
		
	}

	
	

}
