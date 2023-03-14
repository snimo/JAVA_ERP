package com.srn.erp.turnos.bm;

import java.util.Date;
import java.util.Iterator;

import framework.applicarionServer.bl.Utils.Fecha;
import framework.applicarionServer.bl.Utils.Util;
import framework.applicarionServer.bm.Varios.CalculadorMoney;
import framework.applicarionServer.bm.Varios.Money;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;

public class ItemDeudaGrupo {
	
	private boolean readConceptos = true;
	HashTableDatos conceptos = new HashTableDatos();
	private String descCompro = "";
	private DeudaSujetoTurno DeudaSujetoTurno;
	
	public DeudaSujetoTurno getDeudaSujetoTurno() {
		return DeudaSujetoTurno;
	}
	public void setDeudaSujetoTurno(DeudaSujetoTurno deudaSujetoTurno) {
		DeudaSujetoTurno = deudaSujetoTurno;
	}

	private DeudaPorConcTurno deudaPorConc;
	private Money deuda = new Money(0);
	private java.util.Date fecDeudaMasAnt;
	private java.util.Date fechaActual;
	
	
	public Money getDeuda() {
		return deuda;
	}
	public void setDeuda(Money deuda) {
		this.deuda = deuda;
	}
	public java.util.Date getFecDeudaMasAnt() {
		return this.fecDeudaMasAnt;
	}
	public void setFecDeudaMasAnt(java.util.Date aFecDeudaMasAnt) {
		this.fecDeudaMasAnt = aFecDeudaMasAnt;
	}
	
	public void setFecActual(java.util.Date aFecActual) {
		this.fechaActual = aFecActual;
		this.fecDeudaMasAnt = aFecActual;
	}	
	
	public DeudaPorConcTurno getDeudaPorConc() {
		return deudaPorConc;
	}
	public void setDeudaPorConc(DeudaPorConcTurno deudaPorConc) {
		this.deudaPorConc = deudaPorConc;
	}
	
	public void inicializar() throws BaseException {
		setDeuda(new Money(0));
		setFecDeudaMasAnt(Fecha.getFechaActual());
		descCompro = "";
	}
	
	private HashTableDatos getConceptos() throws BaseException {
		if (this.readConceptos) {
			Iterator iterConceptos = this.getDeudaPorConc().getConceptos().iterator();
			while (iterConceptos.hasNext()) {
				GrupoConceptoTurno grupoConcTurno = (GrupoConceptoTurno) iterConceptos.next();
				conceptos.put(grupoConcTurno.getConcepto().trim(),"");
			}
			readConceptos = false;
		}
		return conceptos;
	}
	
	public void addDeuda(java.util.Date fecha,String concepto,Money deuda,String aDescCompro) throws BaseException {
		if (this.getConceptos().get(concepto.trim())!=null) {
			
			//Calcular Deuda
			CalculadorMoney newDeuda = new CalculadorMoney(this.getDeuda());
			newDeuda.sumar(deuda);
			setDeuda(newDeuda.getResultMoney());
			
			//Calcular dias de atraso
			if (fecha.before(this.getFecDeudaMasAnt())) {
				descCompro = aDescCompro;
				setFecDeudaMasAnt(fecha);
			}
			
		}
	}
	
	public void validarDeuda(StringBuffer detalleErrores) throws BaseException {
	
		if (this.getDeuda()==null) return;
		
		if (this.getDeudaPorConc().getMax_deuda()==null) return ;

		if (this.getDeuda().doubleValue()>this.getDeudaPorConc().getMax_deuda()) {
			detalleErrores.append(this.getDeudaSujetoTurno().getNroSocioyNombre()+" tiene una deuda para el concepto "+this.getDeudaPorConc().getDescripcion()+" de "+this.getDeuda().doubleValue()+" que supera el máximo permitido "+ this.getDeudaPorConc().getMax_deuda()+Util.ENTER());
		}
		
	}
	
	public void validarPeriodosAtraso(java.util.Date fecha,StringBuffer detalleErrores) throws BaseException {
		
		if (this.getDeudaPorConc().getMax_dias_atraso() == null) return;
		
		if (this.getDeudaPorConc().getCantMaxPeriDeuda()==null) return;
		
		if (this.getFecDeudaMasAnt()==null) return;
		
		int diaFechaTablero = Fecha.getDia(fecha);
		
		int periodoAConsiderarHasta =(Fecha.getAnio(fecha)*12) + Fecha.getMes(fecha);
		if (diaFechaTablero<this.getDeudaPorConc().getMax_dias_atraso().intValue())
			--periodoAConsiderarHasta;
			
		int periodoAConsiderarDesde =(Fecha.getAnio(this.getFecDeudaMasAnt())*12) + Fecha.getMes(this.getFecDeudaMasAnt());
		
		int atrasoPeri = periodoAConsiderarHasta - periodoAConsiderarDesde;
		
		if (atrasoPeri>=this.getDeudaPorConc().getCantMaxPeriDeuda().intValue()) {
			
			
			if (this.getDeuda()==null) return;
			
			if (this.getDeudaPorConc().getMax_deuda()==null) return ;

			if (this.getDeuda().doubleValue()>this.getDeudaPorConc().getMax_deuda()) {
				detalleErrores.append(this.getDeudaSujetoTurno().getNroSocioyNombre().trim()+" tiene una deuda "+this.getDeudaPorConc().getDescripcion()+" de "+this.getDeuda().doubleValue()+Util.ENTER()+" con "+atrasoPeri+" meses de atraso. ");
			}			
			
			//detalleErrores.append(getDeudaSujetoTurno().getNroSocioyNombre()+ " tiene un concepto impago con "+atrasoPeri+" periodos de atraso. "+Util.ENTER());
		}
		
	}
	
	
}
