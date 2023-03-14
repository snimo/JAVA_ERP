package com.srn.erp.rrhh.bm;

import java.util.List;

import com.srn.erp.general.bm.ValorClasificadorEntidad;
import com.srn.erp.rrhh.da.DBDetConsPlanDesa;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;

public class DetConsPlanDesa extends ObjetoLogico {

	public DetConsPlanDesa() {
	}

	public static String NICKNAME = "rh.DetConsPlanDesa";

	private Integer oidCronograma;
	private String cronograma;
	private Integer oidAccion;
	private String accion;
	private Integer oidLegajo;
	private String legajo;
	private String apellido;
	private String nombre;
	private ValorClasificadorEntidad valClasifEmp;
	private ValorClasificadorEntidad valClasifSec;
	private ValorClasificadorEntidad valClasifPue;
	private Integer cantJuegosA;
	private Integer cantJuegosB;
	private ValorClasificadorEntidad puestoSugerido;
	private java.util.Date fecIngreso;
	private java.util.Date fecAntReco;
	private int antiguedadEmpEnMeses;
	private String LeyendaAntiguedadEmp;
	private java.util.Date fecRecateg;
	private int antiguedadCategEnMeses;
	private String LeyendaAntiguedadCateg;
	private Integer orden;
	private GradoLegajo gradoLegajo;
	private EstadoDesarrollo estadoDesarrollo;
	ValorClasificadorEntidad posibleCategoria;
	private Integer cantMinJuegosA;
	private Integer cantAniosHC;
	private Integer cantMesesHC;
	private Integer ultMesEvalPot;
	private Boolean pendEvalSinFaltaEvalDesemp;
	private Boolean pendEvalSinFaltaJuegos;
	private Boolean pendEvalSinIRL;
	private Boolean pendEvalSinPot;
	private Integer ultMesesIRL;
	private Boolean desaSiIRLNeg;

	public String getCodigo() throws BaseException {
		supportRefresh();
		return "";
	}
	
	public Boolean isPendEvalSinIRL() throws BaseException {
		supportRefresh();
		return this.pendEvalSinIRL;
	}	
	
	public Boolean isPendEvalSinPot() throws BaseException {
		supportRefresh();
		return this.pendEvalSinPot;
	}	
	
	public void setPendEvalSinIRL(Boolean aPendEvalSinIRL) {
		this.pendEvalSinIRL = aPendEvalSinIRL;
	}
	
	public void setPendEvalSinPot(Boolean aPendEvalSinPot) {
		this.pendEvalSinPot = aPendEvalSinPot;
	}	
	
	public Integer getUltMesesIRL() throws BaseException {
		supportRefresh();
		if (this.ultMesesIRL==null)
			return 0;
		else
			return this.ultMesesIRL;
	}	
	
	public void setUltMesesIRL(Integer aUltMesesIRL) {
		this.ultMesesIRL = aUltMesesIRL;
	}
	
	public Boolean isDesapSiIRLNeg() throws BaseException {
		supportRefresh();
		return this.desaSiIRLNeg;
	}	
	
	public void setDesapSiIRLNeg(Boolean aDesapSiIRLNeg) {
		this.desaSiIRLNeg = aDesapSiIRLNeg;
	}	
	
	public Integer getUltMesesEvalPot() throws BaseException {
		supportRefresh();
		if (ultMesEvalPot==null)
			return 0;
		else
			return this.ultMesEvalPot;
	}
	
	public void setUltMesesEvalPot(Integer aUltMesesEvalPot) {
		this.ultMesEvalPot = aUltMesesEvalPot;
	}	
	
	public Boolean isPendEvalSiFaltaEvalDesemp() throws BaseException {
		supportRefresh();
		return this.pendEvalSinFaltaEvalDesemp;
	}
	
	public void setPendEvalSiFaltaEvalDesemp(Boolean aPendEvalSiFaltaEvalDesemp) {
		this.pendEvalSinFaltaEvalDesemp = aPendEvalSiFaltaEvalDesemp;
	}	
	
	public Boolean isPendEvalSiFaltaJuego() throws BaseException {
		supportRefresh();
		return this.pendEvalSinFaltaJuegos;
	}
	
	public void setPendEvalSiFaltaJuego(Boolean aPendEvalSiFaltaJuego) {
		this.pendEvalSinFaltaJuegos = aPendEvalSiFaltaJuego;
	}	
	
	public Integer getCantAniosHC() throws BaseException {
		supportRefresh();
		return this.cantAniosHC;
	}
	
	public void setCantAniosHC(Integer aCantAniosHC) {
		this.cantAniosHC = aCantAniosHC;
	}
	
	public Integer getCantMesesHC() throws BaseException {
		supportRefresh();
		return this.cantMesesHC;
	}
	
	public void setCantMesesHC(Integer aCantMesesHC) {
		this.cantMesesHC = aCantMesesHC;
	}
	
	
	
	public ValorClasificadorEntidad getPosibleCategoria() throws BaseException {
		supportRefresh();
		return this.posibleCategoria;
	}
	
	public Integer getCantMinJuegosA() throws BaseException {
		supportRefresh();
		return this.cantMinJuegosA;
	}
	
	
	public EstadoDesarrollo getEstadoDesarrollo() throws BaseException {
		supportRefresh();
		return this.estadoDesarrollo;
	}
	
	
	public GradoLegajo getGradoLegajo() throws BaseException {
		supportRefresh();
		return gradoLegajo;
	}
	

	public Integer getOrden() throws BaseException {
		supportRefresh();
		return this.orden;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return "";
	}

	@Override
	public String getNickName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean isActivo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer getOidCronograma() throws BaseException {
		supportRefresh();
		return oidCronograma;
	}

	public void setEstadoDesarrollo(EstadoDesarrollo aEstadoDesarrollo) {
		this.estadoDesarrollo = aEstadoDesarrollo;
	}
	
	public void setCantMinJuegosA(Integer aCantMinJuegosA) {
		this.cantMinJuegosA = aCantMinJuegosA;
	}
	
	
	public void setOidCronograma(Integer oidCronograma) {
		this.oidCronograma = oidCronograma;
	}
	
	public void setPosibleCategoria(ValorClasificadorEntidad aValorClasificadorEntidad) {
		this.posibleCategoria = aValorClasificadorEntidad;
	}
	
	public void setGradoLegajo(GradoLegajo aGradoLegajo) {
		this.gradoLegajo = aGradoLegajo;
	}
	

	public void setOrden(Integer aOrden) {
		this.orden = aOrden;
	}

	public String getCronograma() throws BaseException {
		supportRefresh();
		return cronograma;
	}

	public void setCronograma(String cronograma) {
		this.cronograma = cronograma;
	}

	public Integer getOidAccion() throws BaseException {
		supportRefresh();
		return oidAccion;
	}

	public void setOidAccion(Integer oidAccion) {
		this.oidAccion = oidAccion;
	}

	public String getAccion() throws BaseException {
		supportRefresh();
		return accion;
	}

	public void setAccion(String accion) {
		this.accion = accion;
	}

	public Integer getOidLegajo() throws BaseException {
		supportRefresh();
		return oidLegajo;
	}

	public void setOidLegajo(Integer oidLegajo) {
		this.oidLegajo = oidLegajo;
	}

	public String getLegajo() throws BaseException {
		supportRefresh();
		return legajo;
	}

	public void setLegajo(String legajo) {
		this.legajo = legajo;
	}

	public String getApellido() throws BaseException {
		supportRefresh();
		return apellido;
	}

	public String getNombre() throws BaseException {
		supportRefresh();
		return nombre;
	}

	public void setApellido(String aApellido) {
		this.apellido = aApellido;
	}

	public void setNombre(String aNombre) {
		this.nombre = aNombre;
	}

	public ValorClasificadorEntidad getValClasifEmp() throws BaseException {
		supportRefresh();
		return valClasifEmp;
	}

	public void setValClasifEmp(ValorClasificadorEntidad valClasifEmp) {
		this.valClasifEmp = valClasifEmp;
	}

	public ValorClasificadorEntidad getValClasifSec() throws BaseException {
		supportRefresh();
		return valClasifSec;
	}

	public void setValClasifSec(ValorClasificadorEntidad valClasifSec) {
		this.valClasifSec = valClasifSec;
	}

	public ValorClasificadorEntidad getValClasifPue() throws BaseException {
		supportRefresh();
		return valClasifPue;
	}

	public void setValClasifPue(ValorClasificadorEntidad valClasifPue) {
		this.valClasifPue = valClasifPue;
	}

	public Integer getCantJuegosA() throws BaseException {
		supportRefresh();
		return cantJuegosA;
	}

	public void setCantJuegosA(Integer cantJuegosA) {
		this.cantJuegosA = cantJuegosA;
	}

	public Integer getCantJuegosB() throws BaseException {
		supportRefresh();
		return cantJuegosB;
	}

	public void setCantJuegosB(Integer cantJuegosB) {
		this.cantJuegosB = cantJuegosB;
	}

	public ValorClasificadorEntidad getPuestoSugerido() throws BaseException {
		supportRefresh();
		return puestoSugerido;
	}

	public void setPuestoSugerido(ValorClasificadorEntidad puestoSugerido) {
		this.puestoSugerido = puestoSugerido;
	}

	public java.util.Date getFecIngreso() throws BaseException {
		supportRefresh();
		return fecIngreso;
	}
	
	public java.util.Date getFecAntReconocida() throws BaseException {
		supportRefresh();
		return fecAntReco;
	}
	

	public void setFecIngreso(java.util.Date fecIngreso) {
		this.fecIngreso = fecIngreso;
	}
	
	public void setFecAntReconocida(java.util.Date aFecAntReconocida) {
		this.fecAntReco = aFecAntReconocida;
	}
	

	public int getAntiguedadEmpEnMeses() throws BaseException {
		supportRefresh();
		return antiguedadEmpEnMeses;
	}

	public void setAntiguedadEmpEnMeses(int antiguedadEmpEnMeses) {
		this.antiguedadEmpEnMeses = antiguedadEmpEnMeses;
	}

	public String getLeyendaAntiguedadEmp() throws BaseException {
		supportRefresh();
		return LeyendaAntiguedadEmp;
	}

	public void setLeyendaAntiguedadEmp(String leyendaAntiguedadEmp) {
		LeyendaAntiguedadEmp = leyendaAntiguedadEmp;
	}

	public java.util.Date getFecRecateg() throws BaseException {
		supportRefresh();
		return fecRecateg;
	}

	public void setFecRecateg(java.util.Date fecRecateg) {
		this.fecRecateg = fecRecateg;
	}

	public int getAntiguedadCategEnMeses() throws BaseException {
		supportRefresh();
		return antiguedadCategEnMeses;
	}

	public void setAntiguedadCategEnMeses(int antiguedadCategEnMeses) {
		this.antiguedadCategEnMeses = antiguedadCategEnMeses;
	}

	public String getLeyendaAntiguedadCateg() throws BaseException {
		supportRefresh();
		return LeyendaAntiguedadCateg;
	}

	public void setLeyendaAntiguedadCateg(String leyendaAntiguedadCateg) {
		LeyendaAntiguedadCateg = leyendaAntiguedadCateg;
	}

	public static List getListaDetConsPlanDesa(CronogramaDesa cronograma, String mes, List acciones, ISesion aSesion) throws BaseException {
		return DBDetConsPlanDesa.getListaDetConsPlanDesa(cronograma, mes, acciones, aSesion);
	}
	
	public String getAntiguedadHorCarrera() throws BaseException {
		String antiguedad = "";
		if (this.getCantAniosHC()!=null) {
			String anios = "Años "+ this.getCantAniosHC().intValue()+ " ";
			antiguedad = antiguedad + anios; 
		}
		if (this.getCantAniosHC()!=null) {
			String meses = "Meses "+ this.getCantMesesHC().intValue();
			antiguedad = antiguedad + meses;
		}
		return antiguedad;
	}
	
	public int getMesesHoriCarrera() throws BaseException {
		
		int cant1 = 0;
		int cant2 = 0;
		
		if (this.getCantAniosHC()!=null)
			cant1 = this.getCantAniosHC().intValue()*12;
		if (this.getCantMesesHC()!=null)
			cant2 = this.getCantMesesHC();
		
		return cant1 + cant2;
		
	}

}
