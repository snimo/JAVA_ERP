package com.srn.erp.ctasAPagar.bm;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.contabilidad.bm.IContabilizable;
import com.srn.erp.contabilidad.bm.RenglonesAsiento;
import com.srn.erp.general.bm.ComproCab;

import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.Fecha;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;
import framework.request.bl.Utils.Validar;

public class ComproProveedorAnulador extends ComproCab implements IContabilizable {

	public ComproCab getComprobante() throws BaseException {
		// TODO Auto-generated method stub
		return this;
	}

	public ComproProveedorAnulador() {
	}

	public static String NICKNAME = "cap.ComproProveedorAnulador";

	private ComproProveedorBase comprobanteBase;

	public ComproCab getComprobanteBase() throws BaseException {
		supportRefresh();
		return comprobanteBase;
	}

	public void setComprobanteBase(ComproProveedorBase aComprobanteBase) {
		this.comprobanteBase = aComprobanteBase;
	}

	public String getNickName() {
		return NICKNAME;
	}

	public static ComproProveedorAnulador findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (ComproProveedorAnulador) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(comprobanteBase, "Debe ingresar el Comprobante del Proveedor");

		beforeSaveComprobante(this);
		if (this.isNew()) {
			this.setEstado(ComproCab.ESTADO_ALTA);
		}

	}

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public void generarComproAnulacion() throws BaseException {
		// Set datos del comrobante
		setContabiliza(true);
		setTipoCompro(ComproProveedorBase.getTipoComproAnulaComproProv(this.getSesion()));
		setLetra(this.getComprobanteBase().getLetra());
		setLugarEmision(this.getComprobanteBase().getLugarEmision());
		setNrolugemision(this.getComprobanteBase().getNroLugEmision());
		setNroext(this.getComprobanteBase().getNroExt());
		setEmision(Fecha.getFechaActual());
		setImputac(Fecha.getFechaActual());
		setComentario("Anulación Compro. Proveedor " + this.getComprobanteBase().getCodigo());
		setActivo(new Boolean(true));

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

		anularComprobante(this.getComprobanteBase());

		// Anular aplicaciones
		Iterator iterAplicComproProv = AplicacionComproProv.getAplicacionesActivasCompro(this.getComprobanteBase(), this.getSesion())
				.iterator();
		while (iterAplicComproProv.hasNext()) {
			AplicacionComproProv aplicComproProv = (AplicacionComproProv) iterAplicComproProv.next();
			aplicComproProv.setActivo(false);
			aplicComproProv.delete();
			aplicComproProv.save();
		}

		// Validar que no tenga aplicaciones activas
		List aplicacionesActivas = this.comprobanteBase.getAplicacionesActivasCompro();
		if (!aplicacionesActivas.isEmpty()) {

			StringBuffer listaComprobantes = new StringBuffer("");
			Iterator iterAplicActivas = aplicacionesActivas.iterator();
			while (iterAplicActivas.hasNext()) {
				AplProv aplProv = (AplProv) iterAplicActivas.next();
				listaComprobantes.append(" " + aplProv.getComprobanteori().getCodigo());
			}
			throw new ExceptionValidation(null, "El comprobante no puede anularse debido a que tiene comprobantes asociados:"
					+ listaComprobantes.toString());
		}

		aplicacionesActivas = this.comprobanteBase.getAplicacionesActivasDelCompro();
		if (!aplicacionesActivas.isEmpty()) {

			StringBuffer listaComprobantes = new StringBuffer("");
			Iterator iterAplicActivas = aplicacionesActivas.iterator();
			while (iterAplicActivas.hasNext()) {
				AplProv aplProv = (AplProv) iterAplicActivas.next();
				listaComprobantes.append(" " + aplProv.getComprobanteapl().getCodigo());
			}

			throw new ExceptionValidation(null, "El comprobante no puede anularse debido a que tiene comprobantes asociados:"
					+ listaComprobantes.toString());
		}

	}

	protected void beforeSaveNew() throws BaseException {
		// TODO Auto-generated method stub
		super.beforeSaveNew();

	}

}
