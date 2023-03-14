package com.srn.erp.cip.bm;

import com.srn.erp.sueldos.bm.Legajo;

import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;

public class TransaccionPermisoCIP {

	ISesion sesion = null;
	Integer identifEquipo = null;
	Integer identifPtoAcceso = null;
	Integer identifDir = null;
	String identifLegajo = null;
	boolean puedePasar = false;
	Puerta puerta = null;
	Legajo legajo = null;
	Visita visita = null;
	boolean transaccionOK = false;
	TarjetaCIP tarjetaCIP = null; 

	public void validar() throws BaseException {
		
		if (obtenerPuerta() == null)
			return;

		if ((getLegajoTransaccion() == null) && (getVisitaTransaccion() == null))
			return;
		

		transaccionOK = true;
	}

	public boolean isTransaccionOK() {
		return this.transaccionOK;
	}

	public ISesion getSesion() {
		return sesion;
	}

	public void setSesion(ISesion sesion) {
		this.sesion = sesion;
	}

	public Integer getIdentifEquipo() {
		return identifEquipo;
	}

	public void setIdentifEquipo(Integer identifEquipo) {
		this.identifEquipo = identifEquipo;
	}

	public Integer getIdentifPtoAcceso() {
		return identifPtoAcceso;
	}

	public void setIdentifPtoAcceso(Integer identifPtoAcceso) {
		this.identifPtoAcceso = identifPtoAcceso;
	}

	public Integer getIdentifDir() {
		return identifDir;
	}

	public void setIdentifDir(Integer identifDir) {
		this.identifDir = identifDir;
	}

	public String getIdentifLegajo() {
		return identifLegajo;
	}

	public void setIdentifLegajo(String identifLegajo) {
		this.identifLegajo = identifLegajo;
	}

	public boolean isPuedePasar() {
		return puedePasar;
	}

	public void setPuedePasar(boolean puedePasar) {
		this.puedePasar = puedePasar;
	}

	public Puerta getPuerta() {
		return puerta;
	}

	public void setPuerta(Puerta puerta) {
		this.puerta = puerta;
	}

	public Legajo getLegajo() {
		return legajo;
	}

	public void setLegajo(Legajo legajo) {
		this.legajo = legajo;
	}

	private Puerta obtenerPuerta() throws BaseException {
		puerta = Puerta.getPuertaByIdentif(this.getIdentifEquipo(), this.getSesion());
		return puerta;
	}

	private Legajo getLegajoTransaccion() throws BaseException {

		if (esEntrada()) {
			if (this.getPuerta().getIdentifLegEntrada().equals(IdentificadoresDeLegajosCIP.IDENTIF_LEGAJO))
				legajo = Legajo.getLegajoByIdentificacion(new Integer(this.getIdentifLegajo()), this.getSesion());
			else if (this.getPuerta().getIdentifLegEntrada().equals(IdentificadoresDeLegajosCIP.NRO_TARJETA)) {
				
				if (this.getPuerta().getInterpretarNroEnt().equals(InterpretarNroValCIP.B1FC_U2DBNRO)) 
					this.setIdentifLegajo(InterpretarNroValCIP.getB1FCYU2BNRO(this.getIdentifLegajo()));
				else if (this.getPuerta().getInterpretarNroEnt().equals(InterpretarNroValCIP.HID37BITS))
					this.setIdentifLegajo(InterpretarNroValCIP.getHID37Bits(this.getIdentifLegajo()));
				
				TarjetaLegajo tarjetaLegajo = TarjetaLegajo.getTarjetaLegajo(this.getIdentifLegajo().toString(), this.getSesion());
				if (tarjetaLegajo != null)
					legajo = tarjetaLegajo.getLegajo();
			}
		} else if (esSalida()) {
			if (this.getPuerta().getIdentifLegSal().equals(IdentificadoresDeLegajosCIP.IDENTIF_LEGAJO))
				legajo = Legajo.getLegajoByIdentificacion(new Integer(this.getIdentifLegajo()), this.getSesion());
			else if (this.getPuerta().getIdentifLegSal().equals(IdentificadoresDeLegajosCIP.NRO_TARJETA)) {
				
				if (this.getPuerta().getInterpretarNroSal().equals(InterpretarNroValCIP.B1FC_U2DBNRO)) 
					this.setIdentifLegajo(InterpretarNroValCIP.getB1FCYU2BNRO(this.getIdentifLegajo()));
				else if (this.getPuerta().getInterpretarNroSal().equals(InterpretarNroValCIP.HID37BITS))
						this.setIdentifLegajo(InterpretarNroValCIP.getHID37Bits(this.getIdentifLegajo()));
				
				
				TarjetaLegajo tarjetaLegajo = TarjetaLegajo.getTarjetaLegajo(this.getIdentifLegajo().toString(), this.getSesion());
				if (tarjetaLegajo != null)
					legajo = tarjetaLegajo.getLegajo();
			}
		}

		return legajo;
	}
	
	private Visita getVisitaTransaccion() throws BaseException {

		if (esEntrada()) {
			if (!this.getPuerta().getIdentifLegEntrada().equals(IdentificadoresDeLegajosCIP.NRO_TARJETA)) return null;
			
			
			if (this.getPuerta().getInterpretarNroEnt().equals(InterpretarNroValCIP.B1FC_U2DBNRO)) 
				this.setIdentifLegajo(InterpretarNroValCIP.getB1FCYU2BNRO(this.getIdentifLegajo()));
			else if (this.getPuerta().getInterpretarNroEnt().equals(InterpretarNroValCIP.HID37BITS))
				this.setIdentifLegajo(InterpretarNroValCIP.getHID37Bits(this.getIdentifLegajo()));
			String nroAInterpretar = "";
			try {
				nroAInterpretar = this.getIdentifLegajo();
			} catch (Exception e) {
				
			}
			
			tarjetaCIP = TarjetaCIP.getTarjetaCIPActiva(nroAInterpretar, this.getSesion());
			if (tarjetaCIP!=null)
				visita = tarjetaCIP.getVisita();
			
		} else if (esSalida()) {
			
			if (!this.getPuerta().getIdentifLegSal().equals(IdentificadoresDeLegajosCIP.NRO_TARJETA)) return null;
			
			if (this.getPuerta().getInterpretarNroEnt().equals(InterpretarNroValCIP.B1FC_U2DBNRO)) 
				this.setIdentifLegajo(InterpretarNroValCIP.getB1FCYU2BNRO(this.getIdentifLegajo()));
			else if (this.getPuerta().getInterpretarNroEnt().equals(InterpretarNroValCIP.HID37BITS))
				this.setIdentifLegajo(InterpretarNroValCIP.getHID37Bits(this.getIdentifLegajo()));						
						
			String nroAInterpretar = this.getIdentifLegajo();
			
			tarjetaCIP = TarjetaCIP.getTarjetaCIPActiva(nroAInterpretar, this.getSesion());
			if (tarjetaCIP!=null)
				visita = tarjetaCIP.getVisita();			
			
		}
		return visita;
	}
	

	public boolean esEntrada() throws BaseException {
		if ((puerta.getIdentifEntrada().equals(this.getIdentifPtoAcceso().toString()))
				&& (puerta.getDirPtoEnt().equals(this.getIdentifDir())))
			return true;
		else
			return false;
	}

	public boolean esSalida() throws BaseException {
		if ((puerta.getIdentifSal().equals(this.getIdentifPtoAcceso().toString())) && (puerta.getDirPtoSal().equals(this.getIdentifDir())))
			return true;
		else
			return false;
	}

}
