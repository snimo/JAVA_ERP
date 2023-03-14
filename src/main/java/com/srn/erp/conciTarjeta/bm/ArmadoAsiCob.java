package com.srn.erp.conciTarjeta.bm;

import java.util.Iterator;

import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bm.Varios.Money;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;

public class ArmadoAsiCob {
	
	private EmpresaConciTar empresa;
	private AsientoCobTarj asiento = new AsientoCobTarj();
	private ISesion sesion; 
	
	public AsientoCobTarj getAsiento() {
		return asiento;
	}

	public void setAsiento(AsientoCobTarj asiento) {
		this.asiento = asiento;
	}

	public ISesion getSesion() {
		return sesion;
	}

	public void setSesion(ISesion sesion) {
		this.sesion = sesion;
	}

	public EmpresaConciTar getEmpresa() {
		return empresa;
	}

	public void setEmpresa(EmpresaConciTar aEmpresa) {
		this.empresa = aEmpresa;
	}
	
	public void addDetalle(ArchLoteConciDet aArchLoteConciDet) throws BaseException {
		if (empresa.getTipoAsiCob() == null) return;
		
		if (empresa.getTipoAsiCob().equals(TipoAsientoTarjetas.TIPO_ASI_COB_1)) {
			acumularTipoAsiCob1(aArchLoteConciDet);
		}
	}
	
	private void acumularTipoAsiCob1(ArchLoteConciDet archLoteConciDet) throws BaseException {
		
		if (archLoteConciDet.getTarjetaConciTar().getCtaTarjetaACobrar()==null)
			throw new ExceptionValidation(null,"Falta configurar la cuenta para la tarjeta "+
										 archLoteConciDet.getTarjetaConciTar().getDescripcion());
		
		if (archLoteConciDet.getTarjetaConciTar().getCtaTarjetaACobrar().trim().equals(""))
			throw new ExceptionValidation(null,"Falta configurar la cuenta para la tarjeta "+
					 archLoteConciDet.getTarjetaConciTar().getDescripcion());			
		
		// Verifificar si existe un reglon con esa clave.
		
		if (archLoteConciDet.getMonto().doubleValue()<0)
			asiento.AddDetalle(
					archLoteConciDet.getTarjetaConciTar().getCtaTarjetaACobrar(),
					archLoteConciDet.getTarjetaConciTar().getCtaTarjetaACobrarC1(),
					archLoteConciDet.getTarjetaConciTar().getCtaTarjetaACobrarC2(),
					"H",
					new Money(Math.abs(archLoteConciDet.getMonto())));			
		else
			asiento.AddDetalle(
					archLoteConciDet.getTarjetaConciTar().getCtaTarjetaACobrar(),
					archLoteConciDet.getTarjetaConciTar().getCtaTarjetaACobrarC1(),
					archLoteConciDet.getTarjetaConciTar().getCtaTarjetaACobrarC2(),
					"D",
					new Money(archLoteConciDet.getMonto()));
		
		TerminalConciTar terminal = TerminalConciTar.getTerminalByNro(
				archLoteConciDet.getNro_terminal(), 
				this.getSesion());
		
		if (terminal == null)
			throw new ExceptionValidation(null,"No se pudo encontrar la terminal POSNET Nro. "+archLoteConciDet.getNro_terminal());
		
		if (terminal.getUni_neg() == null)
			throw new ExceptionValidation(null,"Falta definir la Unidad de Negocio para la terminal "+archLoteConciDet.getNro_terminal());
		
		
		if (archLoteConciDet.getMonto().doubleValue()<0)
			asiento.AddDetalle(
					terminal.getUni_neg().getCtaTarjetaACobrar(),
					terminal.getUni_neg().getCtaTarjetaACobrarC1(),
					terminal.getUni_neg().getCtaTarjetaACobrarC2(),
					"D",
					new Money(Math.abs(archLoteConciDet.getMonto())));			
		else
			asiento.AddDetalle(
					terminal.getUni_neg().getCtaTarjetaACobrar(),
					terminal.getUni_neg().getCtaTarjetaACobrarC1(),
					terminal.getUni_neg().getCtaTarjetaACobrarC2(),
					"H",
					new Money(archLoteConciDet.getMonto()));
				
	}
	
	public int getCantRenglones() throws BaseException {
		return this.asiento.getCantRenglones();
	}
	
	public int getCantRenglonesResu() throws BaseException {
		return this.asiento.getCantRenglonesResu();
	}	
	
	public Iterator getRenglones() throws BaseException {
		return this.asiento.getRenglones();
	}
	
	public Iterator getRenglonesResu() throws BaseException {
		return this.asiento.getRenglonesResu();
	}	
	

}
