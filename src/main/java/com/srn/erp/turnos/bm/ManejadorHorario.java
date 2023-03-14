package com.srn.erp.turnos.bm;

import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;


public class ManejadorHorario  {
	
	private String horario;
	
	public void setHorario(String aHorario) {
		this.horario = aHorario.trim();
	}
	
	public String getHorario() {
		return this.horario;
	}
	
	public static String getHoraDesde(String horarioDesdeHasta) {
		return horarioDesdeHasta.substring(0, 5);
	}
	
	public static String getHoraHasta(String horarioDesdeHasta) {
		return horarioDesdeHasta.substring(8, 13);
	}
	
	public static int getHoraEnMinutos(String hora) {
		String horaString = hora.substring(0,2);
		String minuString = hora.substring(3,5);
		
		int totMinutos = (new Integer(horaString).intValue() * 60) +  new Integer(minuString).intValue();
		return totMinutos;
		
	}
	
	public int getHoraDesdeEnMinutos() {
		return getHoraEnMinutos(this.getHoraDesde(this.horario));
	}
	
	public int getHoraHastaEnMinutos() {
		return getHoraEnMinutos(this.getHoraHasta(this.horario));
	}	
	
	public static String getHoraString(int cantidadMinutos) {
		int horas = cantidadMinutos / 60;
		int minutos = cantidadMinutos - (horas * 60);
		
		StringBuffer horaString = new StringBuffer("");
		if (horas<=9)
			horaString.append("0"+horas+":");
		else
			horaString.append(horas+":");
		
		if (minutos<=9)
			horaString.append("0"+minutos);
		else
			horaString.append(minutos);
			
		return horaString.toString();
	}
	
	public static int getDifEnMinutos(String hora1,String hora2) {
		int minutosHora1 = getHoraEnMinutos(hora1);
		int minutosHora2 = getHoraEnMinutos(hora2);
		return minutosHora1 - minutosHora2 ;
	}
	
	public static String getNuevaHora(String hora,int cantMinutos) {
		int minutos = getHoraEnMinutos(hora);
		minutos = minutos + cantMinutos;
		return getHoraString(minutos);
	}
	
	public static String getNuevaHoraDesdeHasta(String horaDesdeHasta, int cantMinutos) {
		String horaDesde = getNuevaHora(getHoraDesde(horaDesdeHasta),cantMinutos);
		String horaHasta = getNuevaHora(getHoraHasta(horaDesdeHasta),cantMinutos);
		return getFormatoHoraDesdeHasta(horaDesde,horaHasta);
	}
	
	public static String getNuevaHoraCambioHasta(String horaDesdeHasta, int cantMinutos) {
		String horaDesde = getNuevaHora(getHoraDesde(horaDesdeHasta),0);
		String horaHasta = getNuevaHora(getHoraHasta(horaDesdeHasta),cantMinutos);
		return getFormatoHoraDesdeHasta(horaDesde,horaHasta);
	}
	
	
	public static String getFormatoHoraDesdeHasta(String horaDesde , String horaHasta) {
		return horaDesde+" a "+horaHasta;
	}
	
	public static boolean isHoraValida(String hora) throws BaseException {
		
		String horaString = hora.substring(0,2);
		String minuString = hora.substring(3,5);
		
		
		if (!((new Integer(horaString).intValue()>=0) && ((new Integer(horaString).intValue()<=24))))
			throw new ExceptionValidation(null,"La hora debe estar comprendida entre 0 y 24");
		
		if (!((new Integer(minuString).intValue()>=0) && ((new Integer(minuString).intValue()<=59))))
			throw new ExceptionValidation(null,"Los minutos deben estar comprendidos entre 0 y 59");		
			
		
		return true;
	}
	
  
}
