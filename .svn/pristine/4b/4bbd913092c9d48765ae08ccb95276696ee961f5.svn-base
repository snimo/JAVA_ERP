package com.srn.erp.excluidos.bm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.cip.bm.UtilCIP;

import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bm.Parametros.ValorParametro;
import framework.request.bl.Utils.BaseException;

public class ManagerEstadoExcluido {

	private ISesion sesion;
	private IndividuoExcluido individuo;
	private EstadoExcluido nuevaEstado;
	private NovedadExcluido nuevaNovEstExc;
	private EstadoExcluido estadoConAnt = null;
	private EstadoExcluido estadoSinAnt = null;
	private AdmEstadoExcluido admEstadoExcluido = null;
	
	public ISesion getSesion() {
		return sesion;
	}

	public void setSesion(ISesion sesion) {
		this.sesion = sesion;
	}

	public IndividuoExcluido getIndividuo() {
		return individuo;
	}

	public void setIndividuo(IndividuoExcluido individuo) {
		this.individuo = individuo;
	}

	public EstadoExcluido getNuevoEstado() throws BaseException {
		return nuevaEstado;
	}

	public void setNuevoEstado(EstadoExcluido aEstadoExcluido) throws BaseException {
		this.nuevaEstado = aEstadoExcluido;
	}

	public NovedadExcluido getNuevaNovedadExcluido() throws BaseException {
		return this.nuevaNovEstExc;
	}

	public void setNuevaNovedadExcluido(NovedadExcluido aNovedadExcluido) throws BaseException {
		this.nuevaNovEstExc = aNovedadExcluido;
	}

	public EstadoExcluido getEstadoExcluidoConNovedad() throws BaseException {

		if (estadoConAnt == null) {
			Integer oidEstado = ValorParametro.findByCodigoParametro("ESTADO_CON_NOVEDAD", this.sesion).getOidObjNeg();
			estadoConAnt = EstadoExcluido.findByOid(oidEstado, this.sesion);
		}
		return estadoConAnt;
	}

	public EstadoExcluido getEstadoExcluidoSinNovedad() throws BaseException {
		if (estadoSinAnt == null) {
			Integer oidEstado = ValorParametro.findByCodigoParametro("ESTADO_SIN_NOVEDAD", this.sesion).getOidObjNeg();
			estadoSinAnt = EstadoExcluido.findByOid(oidEstado, this.sesion);
		}
		return estadoSinAnt;
	}

	public void determinarEstado() throws BaseException {
		
		int pesoActual = -1;
		int oidUltNov = -1;
		admEstadoExcluido = null;
		NovedadExcluido novActualConMayorPeso = null;
		
		if (!this.getIndividuo().isActuAutoEstInd()) return;
		List listaNovedadesActivas = new ArrayList();
		List todasLasNov = new ArrayList(); 
		boolean tieneAlgunaNov = false;
		
		Iterator iterNovedades = 
			this.getIndividuo().getNovedades().iterator();
		while (iterNovedades.hasNext()) {
			NovedadExcluido novedad = (NovedadExcluido) iterNovedades.next();
			if (!novedad.isActivo().booleanValue()) continue;
			tieneAlgunaNov = true;
			if  ((novedad.isDejar_sin_efecto().booleanValue()==false) && (novedad.isVigente())) 
				listaNovedadesActivas.add(novedad);
			todasLasNov.add(novedad);
		}
		
		// Definir la novedad de Mayor peso
		Iterator iterNovedadesActivas = 
			listaNovedadesActivas.iterator();
		while (iterNovedadesActivas.hasNext()) {
			NovedadExcluido novExc = (NovedadExcluido) iterNovedadesActivas.next();
			if (novExc.getEstado().getPeso().intValue()>pesoActual) {
				// Si el peso es mayor se toma
				novActualConMayorPeso = novExc;
				pesoActual = novExc.getEstado().getPeso();
				oidUltNov = novExc.getOID();
			} else if (novExc.getEstado().getPeso().intValue()==pesoActual) {
				// A igual peso, se toma la ultima novedad
				if (novExc.getOID()>oidUltNov) {
					novActualConMayorPeso = novExc;
					pesoActual = novExc.getEstado().getPeso();
					oidUltNov = novExc.getOID();					
				}
			}
		}
		
		if (novActualConMayorPeso!=null) {
			admEstadoExcluido = AdmEstadoExcluido.findByOid(this.getIndividuo().getOIDInteger(), this.getSesion());
			admEstadoExcluido.setEstado(novActualConMayorPeso.getEstado());
			admEstadoExcluido.setFec_estado(UtilCIP.getFechaHoraActual(this.getSesion()));
			admEstadoExcluido.setNovedad(novActualConMayorPeso);
			admEstadoExcluido.setEstado_anterior(this.getIndividuo().getEstado());
			admEstadoExcluido.setFec_estado_ant(this.getIndividuo().getFec_estado());
			
		
			
		} else {
			// No hay novedad actual activa
			admEstadoExcluido = AdmEstadoExcluido.findByOid(this.getIndividuo().getOIDInteger(), this.getSesion());
			if (tieneAlgunaNov) 
				admEstadoExcluido.setEstado(getEstadoExcluidoConNovedad());
			else 
				admEstadoExcluido.setEstado(getEstadoExcluidoSinNovedad());
			
			admEstadoExcluido.setFec_estado(UtilCIP.getFechaHoraActual(this.getSesion()));
			
			// Guardar la Novedad Activa, que tenga mayor peso
			
			if (todasLasNov.size() == 0)
				admEstadoExcluido.setNovedad(null);
			else {
				int mayorPesoNov = -1;
				NovedadExcluido novMayorPeso = null;
				Iterator iterTodasLasNov = 
					todasLasNov.iterator();
				while (iterTodasLasNov.hasNext()) {
					NovedadExcluido nov =
						(NovedadExcluido)iterTodasLasNov.next();
					if (nov.getEstado().getPeso().intValue()>mayorPesoNov) {
						novMayorPeso = nov;
						mayorPesoNov = nov.getEstado().getPeso().intValue(); 
					}
				}
				admEstadoExcluido.setNovedad(novMayorPeso);
			}
			admEstadoExcluido.setEstado_anterior(this.getIndividuo().getEstado());
			admEstadoExcluido.setFec_estado_ant(this.getIndividuo().getFec_estado());				
			
		}
		
	}
	
	public AdmEstadoExcluido getAdmEstadoExcluido() throws BaseException {
		return admEstadoExcluido;
	}


}
