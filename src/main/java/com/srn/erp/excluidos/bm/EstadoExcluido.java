package com.srn.erp.excluidos.bm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.excluidos.da.DBEstadoExcluido;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bm.Parametros.ValorParametro;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.Validar;

public class EstadoExcluido extends ObjetoLogico {

	public EstadoExcluido() {
	}

	private List estadosPredio = new ArrayList();
	private boolean readEstadosPredio = true;
	
	
	public static String NICKNAME = "exc.EstadoExcluido";

	public static final String COLOR_ROJO = "ROJO";
	public static final String COLOR_VERDE = "VERDE";
	public static final String COLOR_AMARILLO = "AMAR";
	public static final String COLOR_BLANCO = "BLA";
	public static final String COLOR_AZUL = "AZU";
	public static final String COLOR_PURPURA = "PUR";
	public static final String COLOR_GRIS = "GRIS";
	public static final String COLOR_VIOLETA = "VIO";
	public static final String COLOR_ROSA = "ROSA";
	public static final String COLOR_MARRON = "MARRON";

	private String codigo;
	private String descripcion;
	private Integer peso;
	private String color;
	private Boolean activo;
	private Boolean proponerNro;
	private Integer ultNroPropu;
	private Boolean nroActaObligatorio;
	private Boolean permiteModifNro;
	private Boolean conservaNro;
	private Boolean publicarEnFiltro;
	private Boolean restriccionAcceso;

	public Boolean isProponerNro() throws BaseException {
		supportRefresh();
		return this.proponerNro;
	}
	
	public Boolean isPublicarEnFiltro() throws BaseException {
		supportRefresh();
		return this.publicarEnFiltro;
	}
	

	public void setProponerNro(Boolean aProponerNro) {
		this.proponerNro = aProponerNro;
	}
	
	public void setPublicarEnFiltro(Boolean aPublicarEnFiltro) {
		this.publicarEnFiltro = aPublicarEnFiltro;
	}
	

	public Boolean isConservaNro() throws BaseException {
		supportRefresh();
		return this.conservaNro;
	}

	public void setConservaNro(Boolean aConservaNro) {
		this.conservaNro = aConservaNro;
	}

	public Boolean isPermiteModifNro() throws BaseException {
		supportRefresh();
		return this.permiteModifNro;
	}

	public void setPermiteModifNro(Boolean aPermiteModifNro) {
		this.permiteModifNro = aPermiteModifNro;
	}

	public Boolean isNroActaObligatorio() throws BaseException {
		supportRefresh();
		return this.nroActaObligatorio;
	}

	public void setNroActaObligatorio(Boolean aNroActaObligatorio) {
		this.nroActaObligatorio = aNroActaObligatorio;
	}

	public String getCodigo() throws BaseException {
		supportRefresh();
		return codigo;
	}

	public void setCodigo(String aCodigo) {
		this.codigo = aCodigo;
	}

	public Integer getUltNroPropuesto() throws BaseException {
		supportRefresh();
		return this.ultNroPropu;
	}

	public void setUltNroPropuesto(Integer aUltNroPropuesto) {
		this.ultNroPropu = aUltNroPropuesto;
	}

	public String getDescripcion() throws BaseException {
		supportRefresh();
		return descripcion;
	}

	public void setDescripcion(String aDescripcion) {
		this.descripcion = aDescripcion;
	}

	public Integer getPeso() throws BaseException {
		supportRefresh();
		return peso;
	}

	public void setPeso(Integer aPeso) {
		this.peso = aPeso;
	}

	public String getColor() throws BaseException {
		supportRefresh();
		return color;
	}

	public void setColor(String aColor) {
		this.color = aColor;
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

	public static EstadoExcluido findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (EstadoExcluido) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static EstadoExcluido findByOidProxy(Integer oid, ISesion aSesion) throws BaseException {
		return (EstadoExcluido) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}

	public static EstadoExcluido findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (EstadoExcluido) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(codigo, "Debe ingresar el código");
		Validar.noNulo(descripcion, "Debe ingresar la descripción");
		Validar.noNulo(peso, "Debe ingresar el peso");
		Validar.noNulo(color, "Debe ingresar el color");
	}

	public static HashTableDatos getColores() throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put(COLOR_ROJO, "Rojo");
		condiciones.put(COLOR_VERDE, "Verde");
		condiciones.put(COLOR_AMARILLO, "Amarillo");
		condiciones.put(COLOR_BLANCO, "Blanco");
		condiciones.put(COLOR_AZUL, "Azul");
		condiciones.put(COLOR_PURPURA, "Purpura");
		condiciones.put(COLOR_GRIS, "Gris");
		condiciones.put(COLOR_VIOLETA, "Violeta");
		condiciones.put(COLOR_ROSA, "Rosa");
		condiciones.put(COLOR_MARRON, "Marrón");
		return condiciones;
	}

	public static HashTableDatos getCodigosColores() throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put(COLOR_ROJO, "$000000FD");
		condiciones.put(COLOR_VERDE, "$00008400");
		condiciones.put(COLOR_AMARILLO, "$0046FFFF");
		condiciones.put(COLOR_BLANCO, "$00FCFCFC");
		condiciones.put(COLOR_AZUL, "$00FF2222");
		condiciones.put(COLOR_PURPURA, "$009D009D");
		condiciones.put(COLOR_GRIS, "$00868686");
		condiciones.put(COLOR_VIOLETA, "$00400040");
		condiciones.put(COLOR_ROSA, "$008080FF");
		condiciones.put(COLOR_MARRON, "$00004080");
		return condiciones;
	}

	public static List getAllActivos(ISesion aSesion) throws BaseException {
		return DBEstadoExcluido.getAllActivos(aSesion);
	}

	public List getNovedadesEstadoyNroActa(Integer nroActa) throws BaseException {
		return NovedadExcluido.getNovedadesEstadoyNroActa(this, nroActa, this.getSesion());
	}

	public static EstadoExcluido getEstadoConAntecedentes(ISesion aSesion) throws BaseException {
		Integer oidEstado = ValorParametro.findByCodigoParametro("ESTADO_CON_NOVEDAD", aSesion).getOidObjNeg();
		EstadoExcluido estadoExcluido = EstadoExcluido.findByOid(oidEstado, aSesion);
		return estadoExcluido;
	}
	

	  public List getEstadosPredio() throws BaseException {
		    if (this.readEstadosPredio) {
 		      List listaEstadosPredio = EstadoPredioExc.getEstadosExcluidos(this,getSesion());
		      this.estadosPredio.addAll(listaEstadosPredio);
		      this.readEstadosPredio = false;
		    }
		    return estadosPredio;
		  }

		  public void addEstadoPredio(EstadoPredioExc aEstadoPredioExc) throws BaseException {
		    aEstadoPredioExc.setEstado(this);
		    estadosPredio.add(aEstadoPredioExc);
		  }

		  public void afterSave() throws BaseException {
		    Iterator iterEstadosPredio = estadosPredio.iterator();
		    while (iterEstadosPredio.hasNext()) {
		      EstadoPredioExc estadoPredioExc = (EstadoPredioExc) iterEstadosPredio.next();
		      estadoPredioExc.save();
		      estadoPredioExc = null;
		    }
		    iterEstadosPredio = null;
		  }

		public Boolean isRestriccionAcceso() {
			return restriccionAcceso;
		}

		public void setRestriccionAcceso(Boolean restriccionAcceso) {
			this.restriccionAcceso = restriccionAcceso;
		}
	
	
	
	

}
