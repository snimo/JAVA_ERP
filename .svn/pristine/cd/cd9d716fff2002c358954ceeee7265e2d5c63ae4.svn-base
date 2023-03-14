package com.srn.erp.cashflow.bm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.Fecha;
import framework.request.bl.Utils.BaseException;

public class ProgramadorCashFlow  {

	ISesion sesion = null;
	ProgFechasCF progFechasCF = null;
	
	public ProgramadorCashFlow(ISesion aSesion) {
		sesion = aSesion;
	}
	
	public ProgFechasCF getProgFechasCF() {
		return progFechasCF;
	}


	public void setProgFechasCF(ProgFechasCF progFechasCF) {
		this.progFechasCF = progFechasCF;
	}


	private ISesion getSesion() throws BaseException {
		return this.sesion;
	}
	
	public List getConceptosAProgramar() throws BaseException {
		
		// Armar Fechas Dia a Dia
		List listaNodosVista = new ArrayList();
		int anio , mes , dia = 0;
		
		java.util.Date fechaActual = this.getProgFechasCF().getFec_desde();
		while (this.getProgFechasCF().getFec_hasta().after(fechaActual)) {
			
			anio = Fecha.getAnio(fechaActual);
			mes = Fecha.getMes(fechaActual);
			dia = Fecha.getDia(fechaActual);
			
			List confProg =
				ConfProgConcCF.getConfProgConcCF(mes, dia, this.getProgFechasCF().getEscenario(), this.getSesion());
			Iterator iterConfProg = confProg.iterator();
			while (iterConfProg.hasNext()) {
				ConfProgConcCF confProgConcCF = (ConfProgConcCF) iterConfProg.next();
				java.util.Date formarFecha = Fecha.getFecha(confProgConcCF.getDia(), confProgConcCF.getNro_mes(), anio);
				
				VistaCashFlow vistaCashFlow = (VistaCashFlow) VistaCashFlow.getNew(VistaCashFlow.NICKNAME, this.getSesion());
				vistaCashFlow.setProg_cf(this.getProgFechasCF());
				vistaCashFlow.setConcepto_cf(confProgConcCF.getConcepto());
				vistaCashFlow.setFecha(formarFecha);
				vistaCashFlow.setFecha_original(formarFecha);
				vistaCashFlow.setImporte(confProgConcCF.getMonto());
				vistaCashFlow.setMoneda(confProgConcCF.getMoneda());
				vistaCashFlow.setGrupo_concepto(confProgConcCF.getConcepto().getGrupo_concepto());
				vistaCashFlow.setEscenario_cf(this.getProgFechasCF().getEscenario());
				vistaCashFlow.setActivo(new Boolean(true));
				listaNodosVista.add(vistaCashFlow);
			}
				
			fechaActual = Fecha.getFechaDiaPosterior(fechaActual);
		}
		
		return listaNodosVista;
	}
	


}
