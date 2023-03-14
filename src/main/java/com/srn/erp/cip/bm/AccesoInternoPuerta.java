package com.srn.erp.cip.bm;

import java.util.List;

import com.srn.erp.cip.da.DBAccesoInternoPuerta;
import com.srn.erp.sueldos.bm.Legajo;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.Validar;

public class AccesoInternoPuerta extends ObjetoLogico {

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}
	
	public static String PRECOND_NINGUNA = "NINGUNA";
	public static String PRECOND_EN_PREDIO = "EN_PREDIO";
	public static String PRECOND_FUERA_DE_PREDIO = "FUERA_PREDIO";
	public static String PRECOND_EN_ZONA= "EN_ZONA_VECINA";
	
	public static String ACCION_PASE= "Pase";
	public static String ACCION_DENEGADO= "Denegado";
	public static String ACCION_NADA= "Ninguna";
	public static String CONTROLA = "CONTROLA";
	public static String NO_CONTROLA="NO_CONTROLA";
	
	public static final String SEXO_FEM= "F";
	public static final String SEXO_MASC = "M";
	public static final String SEXO_AMBOS="AMBOS";
	
		
	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public AccesoInternoPuerta() {
	}

	public static String NICKNAME = "cip.AccesoInternoPuerta";

	private Integer secu;
	private ReglasPermisosInt regla;
	private Puerta puerta;
	private String precond_entrada;
	private String tipo_compo_entra;
	private String precond_salida;
	private String tipo_compo_sali;
	private Boolean activo;
	private String mensaje_entrada;
	private String mensaje_salida;
	private String tipoCtrlFhEnt;
	private String tipoCtrlFhSal;
	private Integer minEntAntFhEnt;
	private Integer minEntDesFhEnt;
	private Integer minEntAntFhSal;
	private Integer minEntDesFhSal;
	private String entSexo;
	private String salSexo;
	
	public Integer getSecu() throws BaseException {
		supportRefresh();
		return secu;
	}
	
	public String getMensajeEntrada() throws BaseException {
		supportRefresh();
		return this.mensaje_entrada;
	}
	
	public void setMensajeEntrada(String aMensajeEntrada) {
		this.mensaje_entrada = aMensajeEntrada;
	}	
	
	public String getMensajeSalida() throws BaseException {
		supportRefresh();
		return this.mensaje_salida;
	}
	
	public void setMensajeSalida(String aMensajeSalida) {
		this.mensaje_salida = aMensajeSalida;
	}	

	public void setSecu(Integer aSecu) {
		this.secu = aSecu;
	}

	public ReglasPermisosInt getRegla() throws BaseException {
		supportRefresh();
		return regla;
	}

	public void setRegla(ReglasPermisosInt aRegla) {
		this.regla = aRegla;
	}

	public Puerta getPuerta() throws BaseException {
		supportRefresh();
		return puerta;
	}

	public void setPuerta(Puerta aPuerta) {
		this.puerta = aPuerta;
	}

	public String getPrecond_entrada() throws BaseException {
		supportRefresh();
		return precond_entrada;
	}

	public void setPrecond_entrada(String aPrecond_entrada) {
		this.precond_entrada = aPrecond_entrada;
	}

	public String getTipo_compo_entra() throws BaseException {
		supportRefresh();
		return tipo_compo_entra;
	}

	public void setTipo_compo_entra(String aTipo_compo_entra) {
		this.tipo_compo_entra = aTipo_compo_entra;
	}

	public String getPrecond_salida() throws BaseException {
		supportRefresh();
		return precond_salida;
	}

	public void setPrecond_salida(String aPrecond_salida) {
		this.precond_salida = aPrecond_salida;
	}

	public String getTipo_compo_sali() throws BaseException {
		supportRefresh();
		return tipo_compo_sali;
	}

	public void setTipo_compo_sali(String aTipo_compo_sali) {
		this.tipo_compo_sali = aTipo_compo_sali;
	}
	
	public Boolean isActivo() throws BaseException {
		supportRefresh();
		return activo;
	}

	public void setActivo(Boolean aActivo) {
		this.activo = aActivo;
	}

	public String getNickName() {
		return NICKNAME;
	}
	
	public String getTipoCtrlFhEnt() throws BaseException {
		supportRefresh();
		return tipoCtrlFhEnt;
	}

	public void setTipoCtrlFhEnt(String tipoCtrlFhEnt) {
		this.tipoCtrlFhEnt = tipoCtrlFhEnt;
	}

	public String getTipoCtrlFhSal() throws BaseException {
		supportRefresh();
		return tipoCtrlFhSal;
	}

	public void setTipoCtrlFhSal(String tipoCtrlFhSal) {
		this.tipoCtrlFhSal = tipoCtrlFhSal;
	}

	public Integer getMinEntAntFhEnt() throws BaseException {
		supportRefresh();
		return minEntAntFhEnt;
	}

	public void setMinEntAntFhEnt(Integer minEntAntFhEnt) {
		this.minEntAntFhEnt = minEntAntFhEnt;
	}

	public Integer getMinEntDesFhEnt() throws BaseException {
		supportRefresh();
		return minEntDesFhEnt;
	}

	public void setMinEntDesFhEnt(Integer minEntDesFhEnt) {
		this.minEntDesFhEnt = minEntDesFhEnt;
	}

	public Integer getMinEntAntFhSal() throws BaseException {
		supportRefresh();
		return minEntAntFhSal;
	}

	public void setMinEntAntFhSal(Integer minEntAntFhSal) {
		this.minEntAntFhSal = minEntAntFhSal;
	}

	public Integer getMinEntDesFhSal() throws BaseException {
		supportRefresh();
		return minEntDesFhSal;
	}

	public void setMinEntDesFhSal(Integer minEntDesFhSal) {
		this.minEntDesFhSal = minEntDesFhSal;
	}
	
	public String getEntSexo() throws BaseException {
		supportRefresh();
		if(this.entSexo == null)
			return SEXO_AMBOS;
		
		return entSexo;
	}

	public void setEntSexo(String entSexo) {
		this.entSexo = entSexo;
	}

	public String getSalSexo() throws BaseException {
		supportRefresh();
		if(this.salSexo == null)
			return SEXO_AMBOS;
		
		return salSexo;
	}

	public void setSalSexo(String salSexo) {
		this.salSexo = salSexo;
	}
	
	public static AccesoInternoPuerta findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (AccesoInternoPuerta) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static AccesoInternoPuerta findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (AccesoInternoPuerta) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}
	
	public void beforeSave() throws BaseException {
		Validar.noNulo(secu, "Debe ingresar el Nro. de Orden");
		Validar.noNulo(regla, "Debe ingresar la Regla");
		Validar.noNulo(puerta, "Debe ingresar la Puerta");
		Validar.noNulo(precond_entrada, "Debe ingresar la precondición de entrada");
		Validar.noNulo(tipo_compo_entra, "Debe ingresar el Tipo de Entrada");
		Validar.noNulo(precond_salida, "Debe ingresar la precondición de Salida");
		Validar.noNulo(tipo_compo_sali, "Debe ingresar el Tipo de Salida");
		Validar.noNulo(entSexo, "Debe indicar el sexo del pase de Entrada");
		Validar.noNulo(salSexo, "Debe indicar el sexo del pase de Salida");
	}

	public static List getAccesosInternosPuertas(ReglasPermisosInt regla, ISesion aSesion) throws BaseException {
		return DBAccesoInternoPuerta.getAccesosInternosPuertas(regla, aSesion);
	}
	
	public static HashTableDatos getPrecondiciones() throws BaseException {
		HashTableDatos precondiciones = new HashTableDatos();
		precondiciones.put(PRECOND_NINGUNA, "Ninguna");
		precondiciones.put(PRECOND_EN_PREDIO,"En predio");
		precondiciones.put(PRECOND_FUERA_DE_PREDIO,"Fuera de predio");
		precondiciones.put(PRECOND_EN_ZONA,"Zona Lindera");
		return precondiciones; 
	}
	
	public static HashTableDatos getAcciones() throws BaseException {
		HashTableDatos acciones = new HashTableDatos();
		acciones.put(ACCION_PASE, "Pase");
		acciones.put(ACCION_DENEGADO,"Denegado");
		acciones.put(ACCION_NADA,"Ninguna");
		return acciones;		
	}
	
	public static List getAccesosInternosPuertasByLegajoPuerta(
			Puerta puerta,
			Legajo legajo,
			ISesion aSesion) throws BaseException {
		return DBAccesoInternoPuerta.getAccesosInternosPuertasByLegajoPuerta(puerta,legajo,aSesion);
	}	
	
	public boolean controlaHorarioEntrada() throws BaseException{
		if (this.getTipoCtrlFhEnt()==null)
			return false;
		else if (this.getTipoCtrlFhEnt().equals(CONTROLA)) {
			return true;
		} else if (this.getTipoCtrlFhEnt().equals(NO_CONTROLA)) {
			return false;
		} else {
			return false;
		}
	}
	
	public boolean controlaHorarioSalida() throws BaseException{
		if (this.getTipoCtrlFhSal()==null)
			return false;
		else
		if (this.getTipoCtrlFhSal().equals(CONTROLA)) {
			return true;
		} else if (this.getTipoCtrlFhSal().equals(NO_CONTROLA)) {
			return false;
		} else {
			return false;
		}
	}

	public boolean isPuedeEntrarLegajoPorSexo(Legajo legajo) throws BaseException {
		if(this.getEntSexo() == null)
			return true;
		else if(this.getEntSexo().equals(SEXO_AMBOS))
			return true;
		else if((legajo.getSEXO() != null) && (!legajo.getSEXO().isEmpty()) && this.getEntSexo().equals(legajo.getSEXO()))
			return true;
		else
			return false;
	}
	
	public boolean isPuedeSalirLegajoPorSexo(Legajo legajo) throws BaseException {
		if(this.getSalSexo() == null)
			return true;
		else if(this.getSalSexo().equals(SEXO_AMBOS))
			return true;
		else if((legajo.getSEXO() != null) && (!legajo.getSEXO().isEmpty()) && this.getSalSexo().equals(legajo.getSEXO()))
			return true;
		else
			return false;
	}
	
	public boolean controlaSexoEntrada() throws BaseException{
		if(this.getEntSexo() == null)
			return false;
		else if (this.getEntSexo().equals(SEXO_AMBOS))
			return false;
		else 
			return true;
		
	}
	
	public boolean controlaSexoSalida() throws BaseException{
		if(this.getSalSexo() == null)
			return false;
		else if (this.getSalSexo().equals(SEXO_AMBOS))
			return false;
		else 
			return true;
	}
	
	public static HashTableDatos getMapaSexo() throws BaseException {
		HashTableDatos mapaSexo = new HashTableDatos();
		mapaSexo.put(SEXO_AMBOS, "Ambos");
		mapaSexo.put(SEXO_FEM,"Femenino");
		mapaSexo.put(SEXO_MASC,"Masculino");
		return mapaSexo;		
	}
	
	public String getDescripcionSalSexo() throws BaseException{
		String desc = getMapaSexo().getString(this.getSalSexo());
		if (desc!=null)
			return desc;
		else
			return "";
	}
	
	public String getDescripcionEntSexo() throws BaseException{
		String desc = getMapaSexo().getString(this.getEntSexo());
		if (desc!=null)
			return desc;
		else
			return "";
	}

}
