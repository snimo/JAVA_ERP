package com.srn.erp.cip.bm;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.cip.da.DBMotivoEntradasInterRota;
import com.srn.erp.cip.da.DBRota;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.Fecha;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class Rota extends ObjetoLogico {

	public Rota() {
	}

	public static String NICKNAME = "cip.Rota";

	private String codigo;
	private String descripcion;
	private String horario_desde;
	private String horario_hasta;
	private Integer min_ent_antes;
	private Boolean activo;
	private Integer min_ent_desp;
	private Integer min_sal_antes;
	private String tipo_acceso;
	private String tipo_egreso;
	private Integer min_sal_despues;
	private String leyendaNoIngresa;
	private String leyendaNoEgresa;

	private List equivalenciasRotas = new ArrayList();
	private boolean readEquivalenciasRotas = true;
	
	private List motivosEntIntermedios = new ArrayList();
	private boolean readMotivosEntIntermedios = true;	

	public String getCodigo() throws BaseException {
		supportRefresh();
		return codigo;
	}

	public void setCodigo(String aCodigo) {
		this.codigo = aCodigo;
	}
	
	public String getLeyendaNoIngresa() throws BaseException {
		supportRefresh();
		return this.leyendaNoIngresa;
	}

	public void setLeyendaNoIngresa(String aLeyendaNoIngresa) {
		this.leyendaNoIngresa = aLeyendaNoIngresa;
	}
	
	public String getLeyendaNoEgresa() throws BaseException {
		supportRefresh();
		return this.leyendaNoEgresa;
	}

	public void setLeyendaNoEgresa(String aLeyendaNoEgresa) {
		this.leyendaNoEgresa = aLeyendaNoEgresa;
	}
	
	

	public String getDescripcion() throws BaseException {
		supportRefresh();
		return descripcion;
	}

	public void setDescripcion(String aDescripcion) {
		this.descripcion = aDescripcion;
	}

	public String getHorario_desde() throws BaseException {
		supportRefresh();
		return horario_desde;
	}

	public void setHorario_desde(String aHorario_desde) {
		this.horario_desde = aHorario_desde;
	}

	public String getHorario_hasta() throws BaseException {
		supportRefresh();
		return horario_hasta;
	}

	public void setHorario_hasta(String aHorario_hasta) {
		this.horario_hasta = aHorario_hasta;
	}

	public Integer getMin_ent_antes() throws BaseException {
		supportRefresh();
		return min_ent_antes;
	}

	public void setMin_ent_antes(Integer aMin_ent_antes) {
		this.min_ent_antes = aMin_ent_antes;
	}

	public Boolean isActivo() throws BaseException {
		supportRefresh();
		return activo;
	}

	public void setActivo(Boolean aActivo) {
		this.activo = aActivo;
	}

	public Integer getMin_ent_desp() throws BaseException {
		supportRefresh();
		return min_ent_desp;
	}

	public void setMin_ent_desp(Integer aMin_ent_desp) {
		this.min_ent_desp = aMin_ent_desp;
	}

	public Integer getMin_sal_antes() throws BaseException {
		supportRefresh();
		return min_sal_antes;
	}

	public void setMin_sal_antes(Integer aMin_sal_antes) {
		this.min_sal_antes = aMin_sal_antes;
	}

	public String getTipo_acceso() throws BaseException {
		supportRefresh();
		return tipo_acceso;
	}

	public void setTipo_acceso(String aTipo_acceso) {
		this.tipo_acceso = aTipo_acceso;
	}

	public String getTipo_egreso() throws BaseException {
		supportRefresh();
		return tipo_egreso;
	}

	public void setTipo_egreso(String aTipo_egreso) {
		this.tipo_egreso = aTipo_egreso;
	}

	public Integer getMin_sal_despues() throws BaseException {
		supportRefresh();
		return min_sal_despues;
	}

	public void setMin_sal_despues(Integer aMin_sal_despues) {
		this.min_sal_despues = aMin_sal_despues;
	}

	public String getNickName() {
		return NICKNAME;
	}

	public static Rota findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (Rota) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static Rota findByOidProxy(Integer oid, ISesion aSesion) throws BaseException {
		return (Rota) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}

	public static Rota findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (Rota) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(codigo, "Debe ingresar el código de la Rota");
		Validar.noNulo(descripcion, "Debe ingresar la descripción de la Rota");
		Validar.noNulo(tipo_acceso, "Tipo acceso entrada");
		Validar.noNulo(tipo_egreso, "Tipo acceso salida");

		if (tipo_acceso.equals(TiposEntradasRotas.SEGUN_HORARIO)) {
			Validar.noNulo(horario_desde, "Debe ingresar el horario de entrada");
			Validar.noNulo(min_ent_antes, "Minutos entrada antes");
			Validar.noNulo(min_ent_desp, "Minutos entrada después");
		}
		if (tipo_egreso.equals(TiposSalidasRotas.SEGUN_HORARIO)) {
			Validar.noNulo(horario_hasta, "Debe ingresar el horario de salida");
			Validar.noNulo(min_sal_antes, "Minutos Salida antes");
			Validar.noNulo(min_sal_despues, "Minutos salida después");
		}
	}

	public static List getAllRotas(ISesion aSesion) throws BaseException {
		return DBRota.getAllRotas(aSesion);
	}

	public List getEquivalenciasRotas() throws BaseException {
		if (this.readEquivalenciasRotas) {
			List listaEquivalenciasRotas = EquivalenciaRotasCIP.getRotasEquivalentes(this, getSesion());
			this.equivalenciasRotas.addAll(listaEquivalenciasRotas);
			this.readEquivalenciasRotas = false;
		}
		return equivalenciasRotas;
	}
	
	public List getMotivosEntradasIntermedias() throws BaseException {
		if (this.readMotivosEntIntermedios) {
			List listaMotivosEntIntermedias = MotivoEntradasInterRota.getMotEntInterRotas(this, getSesion());
			this.motivosEntIntermedios.addAll(listaMotivosEntIntermedias);
			this.readMotivosEntIntermedios = false;
		}
		return this.motivosEntIntermedios;
	}	

	public void addEquivalenciaRota(EquivalenciaRotasCIP aEquivalenciaRota) throws BaseException {
		aEquivalenciaRota.setRota(this);
		this.equivalenciasRotas.add(aEquivalenciaRota);
	}
	
	public void addMotivoEntradaIntermedia(MotivoEntradasInterRota aMotivoEntradasInterRota) throws BaseException {
		aMotivoEntradasInterRota.setRota(this);
		this.motivosEntIntermedios.add(aMotivoEntradasInterRota);
	}	

	public void afterSave() throws BaseException {
		
		Iterator iterEquivalenciasRotas = equivalenciasRotas.iterator();
		while (iterEquivalenciasRotas.hasNext()) {
			EquivalenciaRotasCIP equivalencia = (EquivalenciaRotasCIP) iterEquivalenciasRotas.next();
			equivalencia.save();
			equivalencia = null;
		}
		iterEquivalenciasRotas = null;
		
		Iterator iterMotivosEntradasIntermedias = this.motivosEntIntermedios.iterator();
		while (iterMotivosEntradasIntermedias.hasNext()) {
			MotivoEntradasInterRota motivoEntradasInterRota = (MotivoEntradasInterRota) iterMotivosEntradasIntermedias.next();
			motivoEntradasInterRota.save();
			motivoEntradasInterRota = null;
		}
		iterMotivosEntradasIntermedias = null;
		
	}
	
	public String getLeyendaPermisoRota() throws BaseException {
		
		StringBuffer leyenda = new StringBuffer("");
		if ((this.getTipo_acceso().equals(TiposEntradasRotas.SEGUN_HORARIO))) {

			int horaEnMin = UtilCIP.getHoraEnMin(this.getHorario_desde());
			int horaDesde = horaEnMin - this.getMin_ent_antes(); 
			int horaHasta = horaEnMin + this.getMin_ent_desp();
			
			if (horaDesde<0)  
				horaDesde = (24*60)+horaDesde;
				else if (horaHasta>(24*60)) 
					horaHasta = horaHasta - (24*60);
			
			String horDesEnt = UtilCIP.getHoraHHMM(horaDesde);
			String horHasEnt = UtilCIP.getHoraHHMM(horaHasta);				
			leyenda.append("Puede ingresar de "+horDesEnt+" a "+horHasEnt);
			
		}
		
		if ((this.getTipo_acceso().equals(TiposEntradasRotas.PERMITIDO))) {
			leyenda.append("Puede ingresar de "+"00:00"+" a "+"24:00");
		}
		
		if ((this.getTipo_acceso().equals(TiposEntradasRotas.DENEGADO))) {
			leyenda.append("NO puede ingresar");
		}
		
		if ((this.getTipo_egreso().equals(TiposSalidasRotas.SEGUN_HORARIO))) {			
			if (leyenda.length()>0) leyenda.append(" y ");
			
			int horaEnMin = UtilCIP.getHoraEnMin(this.getHorario_hasta());
			int horaDesde = horaEnMin - this.getMin_sal_antes(); 
			int horaHasta = horaEnMin + this.getMin_sal_despues();
			
			if (horaDesde<0) 
				horaDesde = (24*60)+horaDesde;
			else if (horaHasta>(24*60))
				horaHasta = horaHasta - (24*60);
			
			String horDesSal = UtilCIP.getHoraHHMM(horaDesde);
			String horHasSal = UtilCIP.getHoraHHMM(horaHasta);
			leyenda.append("Puede salir de "+horDesSal+" a "+horHasSal);			
			
		}
		
		if ((this.getTipo_egreso().equals(TiposSalidasRotas.LIBRE))) {
			if (leyenda.length()>0) leyenda.append(" y ");
			leyenda.append("Puede salir de "+"00:00"+" a "+"24:00");			
		}
		
		if ((this.getTipo_egreso().equals(TiposSalidasRotas.NO_EGRESA))) {
			if (leyenda.length()>0) leyenda.append(" y ");
			leyenda.append("NO puede salir ");			
		}
		
		return leyenda.toString();
	}
	
	public String getLeyendaPermisoRota(Integer minEntAntes,Integer minEntDespues) throws BaseException {
		
		int nuevoMinAntes = this.getMin_ent_antes();
		int nuevoMinDespues = this.getMin_ent_desp();
		
		if (minEntAntes>this.getMin_ent_antes())
			nuevoMinAntes = minEntAntes; 
			
		if (minEntDespues>this.getMin_ent_desp())
			nuevoMinDespues = minEntDespues; 
		
		StringBuffer leyenda = new StringBuffer("");
		if ((this.getTipo_acceso().equals(TiposEntradasRotas.SEGUN_HORARIO))) {

			int horaEnMin = UtilCIP.getHoraEnMin(this.getHorario_desde());
			int horaDesde = horaEnMin - nuevoMinAntes; 
			int horaHasta = horaEnMin + nuevoMinDespues;
			
			if (horaDesde<0)  
				horaDesde = (24*60)+horaDesde;
				else if (horaHasta>(24*60)) 
					horaHasta = horaHasta - (24*60);
			
			String horDesEnt = UtilCIP.getHoraHHMM(horaDesde);
			String horHasEnt = UtilCIP.getHoraHHMM(horaHasta);				
			leyenda.append("Puede ingresar de "+horDesEnt+" a "+horHasEnt);
			
		}
		
		if ((this.getTipo_acceso().equals(TiposEntradasRotas.PERMITIDO))) {
			leyenda.append("Puede ingresar de "+"00:00"+" a "+"24:00");
		}
		
		if ((this.getTipo_acceso().equals(TiposEntradasRotas.DENEGADO))) {
			leyenda.append("NO puede ingresar");
		}
		
		if ((this.getTipo_egreso().equals(TiposSalidasRotas.SEGUN_HORARIO))) {			
			if (leyenda.length()>0) leyenda.append(" y ");
			
			int horaEnMin = UtilCIP.getHoraEnMin(this.getHorario_hasta());
			int horaDesde = horaEnMin - this.getMin_sal_antes(); 
			int horaHasta = horaEnMin + this.getMin_sal_despues();
			
			if (horaDesde<0) 
				horaDesde = (24*60)+horaDesde;
			else if (horaHasta>(24*60))
				horaHasta = horaHasta - (24*60);
			
			String horDesSal = UtilCIP.getHoraHHMM(horaDesde);
			String horHasSal = UtilCIP.getHoraHHMM(horaHasta);
			leyenda.append("Puede salir de "+horDesSal+" a "+horHasSal);			
			
		}
		
		if ((this.getTipo_egreso().equals(TiposSalidasRotas.LIBRE))) {
			if (leyenda.length()>0) leyenda.append(" y ");
			leyenda.append("Puede salir de "+"00:00"+" a "+"24:00");			
		}
		
		if ((this.getTipo_egreso().equals(TiposSalidasRotas.NO_EGRESA))) {
			if (leyenda.length()>0) leyenda.append(" y ");
			leyenda.append("NO puede salir ");			
		}
		
		return leyenda.toString();
	}
	
	
	public boolean isPermiteIngreso() throws BaseException {
		if (getTipo_acceso().equals(TiposEntradasRotas.PERMITIDO))
			return true;
		else
			return false;
	}
	
	public boolean isPermiteEgreso() throws BaseException {
		if (getTipo_egreso().equals(TiposSalidasRotas.LIBRE))
			return true;
		else
			return false;
	}
	
	public boolean isIngresoDenegado() throws BaseException {
		if (getTipo_acceso().equals(TiposEntradasRotas.DENEGADO))
			return true;
		else
			return false;
	}
	
	public boolean isEgresoDenegado() throws BaseException {
		if (getTipo_egreso().equals(TiposSalidasRotas.NO_EGRESA))
			return true;
		else
			return false;
	}	
	
	public boolean isSegunHorario() throws BaseException {
		if (getTipo_acceso().equals(TiposEntradasRotas.SEGUN_HORARIO))
			return true;
		else
			return false;
	}
	
	public boolean isEgresoSegunHorario() throws BaseException {
		if (getTipo_egreso().equals(TiposEntradasRotas.SEGUN_HORARIO))
			return true;
		else
			return false;
	}
	
	public boolean isRotaFranco() throws BaseException {
		if(this.getCodigo().equals("FRANCO"))
			return true;
	    return false;
	}
	
	public boolean isPuedeIngresarEnHorario(int horEnMin) throws BaseException {
		int horaEnMin = UtilCIP.getHoraEnMin(this.getHorario_desde());
		int horaDesde = horaEnMin - this.getMin_ent_antes(); 
		int horaHasta = horaEnMin + this.getMin_ent_desp();
		
		if (horaDesde<0) { 
			horaDesde = (24*60)+horaDesde;
			if ((horEnMin>=horaDesde) && (horEnMin<=(24*60)))
				return true;
			else if ((horEnMin>=0) && (horEnMin<=horaHasta))
				return true;
			else
				return false;			
		}
		
		if (horaHasta>(24*60)) {
			horaHasta = horaHasta - (24*60);
			if ((horEnMin>=0) && (horEnMin<=(horaHasta)))
				return true;
			else if ((horEnMin>=horaDesde) && (horEnMin<=(24*60)))
				return true;
			else
				return false;			
		}
		
		if ((horEnMin>=horaDesde) && (horEnMin<=horaHasta))
			return true;
		else
			return false;
	}
	
	public boolean isPuedeEgresarEnHorario(int horEnMin) throws BaseException {
		
		int horaEnMin = UtilCIP.getHoraEnMin(this.getHorario_hasta());
		int horaDesde = horaEnMin - this.getMin_sal_antes(); 
		int horaHasta = horaEnMin + this.getMin_sal_despues();		
		
		if (horaDesde<0) { 
			horaDesde = (24*60)+horaDesde;
			if ((horEnMin>=horaDesde) && (horEnMin<=(24*60)))
				return true;
			else if ((horEnMin>=0) && (horEnMin<=horaHasta))
				return true;
			else
				return false;			
		}
		
		if (horaHasta>(24*60)) {
			horaHasta = horaHasta - (24*60);
			if ((horEnMin>=0) && (horEnMin<=(horaHasta)))
				return true;
			else if ((horEnMin>=horaDesde) && (horEnMin<=(24*60)))
				return true;
			else
				return false;			
		}		
		
		if ((horEnMin>=horaDesde) && (horEnMin<=horaHasta))
			return true;
		else
			return false;
	}
	
    public List getMotEntInterRotasAsigFij() throws BaseException {
    	  return DBMotivoEntradasInterRota.getMotEntInterRotasAsigFij(this,this.getSesion());
    }
    
    public boolean isPuedeIngresarSegunHorario(java.util.Date fechaRota, java.util.Date fecHoraActual, int minEntAntes , int minEntDespues) throws BaseException {
    	
		int HorasDesde   = UtilCIP.getParteHoraEnHoras(this.getHorario_desde());
		int MinutosDesde = UtilCIP.getParteMinutosEnMinutos(this.getHorario_desde());
		
		Calendar calFecHor = GregorianCalendar.getInstance(); 
		calFecHor.setTime(fechaRota); // set cal to date
		calFecHor.add(Calendar.HOUR, HorasDesde);
		calFecHor.add(Calendar.MINUTE, MinutosDesde);
		java.util.Date fecHorIniRota = calFecHor.getTime();		
		
		// Obtener la hora entrada antes		
		Calendar calFecHorMinEntAnt = GregorianCalendar.getInstance();
		calFecHorMinEntAnt.setTime(fecHorIniRota);
		if (minEntAntes>this.getMin_ent_antes())
			calFecHorMinEntAnt.add(Calendar.MINUTE, minEntAntes*-1);
		else
			calFecHorMinEntAnt.add(Calendar.MINUTE, this.getMin_ent_antes()*-1);
		java.util.Date fecHorIniRotaEntAnt = calFecHorMinEntAnt.getTime();
		
		// Obtener la hora entrada despues		
		Calendar calFecHorMinEntDesp = GregorianCalendar.getInstance();
		calFecHorMinEntDesp.setTime(fecHorIniRota);
		if (minEntDespues>this.getMin_ent_desp())
			calFecHorMinEntDesp.add(Calendar.MINUTE, minEntDespues);
		else
			calFecHorMinEntDesp.add(Calendar.MINUTE, this.getMin_ent_desp());
		java.util.Date fecHorIniRotaEntDesp = calFecHorMinEntDesp.getTime();
		
		if ((!fecHoraActual.before(fecHorIniRotaEntAnt)) && (!fecHoraActual.after((fecHorIniRotaEntDesp)))) 
			return true;
		else
			return false;
		
    }
    
    public boolean isPuedeEgresarSegunHorario(java.util.Date fechaRota, java.util.Date fecHoraActual, int minSalAntes , int minSalDespues) throws BaseException {
    	
		int HorasDesde   = UtilCIP.getParteHoraEnHoras(this.getHorario_hasta());
		int MinutosDesde = UtilCIP.getParteMinutosEnMinutos(this.getHorario_hasta());
		
		// Significa que la evaluacion la tengo que hacer al dia siguiente porque el horario desde es mayor que el horario hasta, entonces
		// el contro se tiene que hacer al dia siguiente
		if ((UtilCIP.getHoraEnMin(this.getHorario_desde())>UtilCIP.getHoraEnMin(this.getHorario_hasta()))) 
			fechaRota = Fecha.getFechaDiaPosterior(fechaRota);
		
		
		
		Calendar calFecHor = GregorianCalendar.getInstance(); 
		calFecHor.setTime(fechaRota); // set cal to date
		calFecHor.add(Calendar.HOUR, HorasDesde);
		calFecHor.add(Calendar.MINUTE, MinutosDesde);
		java.util.Date fecHorIniRota = calFecHor.getTime();		
		
		// Obtener la hora entrada antes		
		Calendar calFecHorMinSalAnt = GregorianCalendar.getInstance();
		calFecHorMinSalAnt.setTime(fecHorIniRota);
		if (minSalAntes>this.getMin_sal_antes())
			calFecHorMinSalAnt.add(Calendar.MINUTE, minSalAntes*-1);
		else
			calFecHorMinSalAnt.add(Calendar.MINUTE, this.getMin_sal_antes()*-1);
		java.util.Date fecHorIniRotaSalAnt = calFecHorMinSalAnt.getTime();
		
		// Obtener la hora entrada despues		
		Calendar calFecHorMinSalDesp = GregorianCalendar.getInstance();
		calFecHorMinSalDesp.setTime(fecHorIniRota);
		if (minSalDespues>this.getMin_sal_despues())
			calFecHorMinSalDesp.add(Calendar.MINUTE, minSalDespues);
		else
			calFecHorMinSalDesp.add(Calendar.MINUTE, this.getMin_sal_despues());
		java.util.Date fecHorIniRotaSalDesp = calFecHorMinSalDesp.getTime();
		
		if ((!fecHoraActual.before(fecHorIniRotaSalAnt)) && (!fecHoraActual.after((fecHorIniRotaSalDesp)))) 
			return true;
		else
			return false;
		
    }
    
	

}
