package com.srn.erp.stock.bm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.general.bm.ComproCab;
import com.srn.erp.general.bm.Talonario;

import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.Fecha;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;
import framework.request.bl.Utils.Validar;

public class ComproAjusteStkAnu extends ComproCab implements IStockeable {

	public ComproCab getComprobante() throws BaseException {
		// TODO Auto-generated method stub
		return this;
	}
	
	private ComproCab			comprobante;

	public RenglonesStock getRenglonesStock() throws BaseException {
		// TODO Auto-generated method stub
		return this.getComproajustestk().getStockCabecera().getRenglonesStockInvertidos(this);
	}

	public ComproAjusteStkAnu() {
	}

	private List						detalles		= new ArrayList();

	private boolean					readDetalle	= true;

	public static String		NICKNAME		= "st.ComproAjusteStkAnu";

	private ComproAjusteStk	comproAjusteStk;

	public ComproAjusteStk getComproajustestk() throws BaseException {
		supportRefresh();
		return comproAjusteStk;
	}

	public void setComproajustestk(ComproAjusteStk aComproajustestk) {
		this.comproAjusteStk = aComproajustestk;
	}

	public String getNickName() {
		return NICKNAME;
	}

	public static ComproAjusteStkAnu findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (ComproAjusteStkAnu) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static ComproAjusteStkAnu findByOidProxy(Integer oid, ISesion aSesion) throws BaseException {
		return (ComproAjusteStkAnu) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(comproAjusteStk, "Debe ingresar el Comprobante de Ajuste de Stock");
		
		beforeSaveComprobante(this);
		if (this.isNew()) {
					this.setComprobante(this);
					this.setEstado(ComproCab.ESTADO_ALTA);
	  }
			
		
		
	}
	
	public void setComprobante(ComproCab aComprobante) {
		this.comprobante = aComprobante;
	}
	

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return super.getCodigo();
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return super.getDescripcion();
	}

	public void afterSave() throws BaseException {

		Iterator iterDetalles = detalles.iterator();
		while (iterDetalles.hasNext()) {
			ComproAjusteStkDetAnu comproAjuDetAnu = (ComproAjusteStkDetAnu) iterDetalles.next();
			comproAjuDetAnu.save();
			comproAjuDetAnu = null;
		}
		iterDetalles = null;

		afterSaveComprobante(this);

		anularComprobante(this.getComproajustestk());

	}

	public void addDetalle(ComproAjusteStkDetAnu comproAjuDet) throws BaseException {
		this.detalles.add(comproAjuDet);
		comproAjuDet.setCompro_aju_stk_anu(this);
	}

	public void generarComproAnulacion() throws BaseException {

		// Set datos del comrobante
		setContabiliza(false);
		Talonario talonarioAnulacion = this.getComproajustestk().getTalonario().getTalonarioAnulacion();
		if (talonarioAnulacion == null)
			throw new ExceptionValidation(null, "No existe talonario de anulación para el talonario "
					+ this.getComproajustestk().getTalonario().getDescripcion());
		setTalonario(talonarioAnulacion);
		setTipoCompro(talonarioAnulacion.getTipo_comprobante());
		setLetra(talonarioAnulacion.getLetra());
		setLugarEmision(talonarioAnulacion.getLugar_emision());
		setNroext(new Integer(0));
		setEmision(Fecha.getFechaActual());
		setImputac(Fecha.getFechaActual());
		setComentario(" Anulación de " + this.getComproajustestk().getCodigo());
		setActivo(new Boolean(true));

		Iterator iterDetalles = this.getComproajustestk().getDetalles().iterator();
		while (iterDetalles.hasNext()) {
			ComproAjusteStkDet comproAjuStkDet = (ComproAjusteStkDet) iterDetalles.next();
			if (!comproAjuStkDet.isActivo().booleanValue())
				continue;
			ComproAjusteStkDetAnu comproAjuStkDetAnu = (ComproAjusteStkDetAnu) ComproAjusteStkDetAnu.getNew(
					ComproAjusteStkDetAnu.NICKNAME, getSesion());
			comproAjuStkDetAnu.setCompro_aju_stk_anu(this);
			comproAjuStkDetAnu.setCompro_aju_stk_det(comproAjuStkDet);
			addDetalle(comproAjuStkDetAnu);
		}

	}

}
