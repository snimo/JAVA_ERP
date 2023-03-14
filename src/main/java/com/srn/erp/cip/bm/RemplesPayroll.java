package com.srn.erp.cip.bm;

import java.util.List;

import com.srn.erp.cip.da.DBRemplesPayroll;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;

public class RemplesPayroll extends ObjetoLogico {

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public RemplesPayroll() {
	}

	public static String NICKNAME = "cip.RemplesPayroll";

	private String empresa;
	private String codigo;
	private String nombre;
	private String estado;
	private java.util.Date fecha_ing;
	private java.util.Date fecha_ret;
	private Integer cencos;
	private Boolean activo;
	private String credenc;
	private Integer cargo;
	private String rut;
	private String sexo;
	private String direccion;
	private String estadoCivil;
	private java.util.Date fecNacimiento;
	private Integer tipoDocumento;
	private String nroDocumento;
	private String telParticular;
	private String telCelular;
	private Integer claseSindicato;
	private java.util.Date fecAntReco;
	private Integer motivoEgreso;
	private java.util.Date fecVencProt;
	private java.util.Date fecIngUTE;
	private Integer grado;
	private Integer ubica;
	private Integer clasif;
	private Integer catego;
	private Integer cargoUnificado;
	private Integer seccion;

	public java.util.Date getFecVencProt() throws BaseException {
		supportRefresh();
		return this.fecVencProt;
	}
	
	public Integer getUbica() throws BaseException {
		supportRefresh();
		return this.ubica;
	}	
	
	public Integer getSeccion() throws BaseException {
		supportRefresh();
		return this.seccion;
	}
	
	
	public Integer getCatego() throws BaseException {
		supportRefresh();
		return this.catego;
	}	
	
	public Integer getClasif() throws BaseException {
		supportRefresh();
		return this.clasif;
	}	
	
	public Integer getCargoUnificado() throws BaseException {
		supportRefresh();
		return this.cargoUnificado;
	}	
	
	public Integer getGrado() throws BaseException {
		supportRefresh();
		return this.grado;
	}
	
	
	public void setUbica(Integer aUbica) throws BaseException {
		this.ubica = aUbica;
	}
	
	public void setSeccion(Integer aSeccion) throws BaseException {
		this.seccion = aSeccion;
	}	
	
	public void setCargoUnificado(Integer aCargoUnificado) throws BaseException {
		this.cargoUnificado = aCargoUnificado;
	}	
	
	public void setCatego(Integer aCatego) throws BaseException {
		this.catego = aCatego;
	}	
	
	public void setClasif(Integer aClasif) throws BaseException {
		this.clasif = aClasif;
	}	
	
	public void setFecVencProt(java.util.Date aFecVencProt) throws BaseException {
		this.fecVencProt = aFecVencProt;
	}
	
	public void setGrado(Integer aGrado) throws BaseException {
		this.grado = aGrado;
	}
	
	
	public java.util.Date getFecIngUTE() throws BaseException {
		supportRefresh();
		return this.fecIngUTE;
	}
	
	public void setFecIngUTE(java.util.Date aFecIngUTE) throws BaseException {
		this.fecIngUTE = aFecIngUTE;
	}
	
	public Integer getClaseSindicato() throws BaseException {
		supportRefresh();
		return this.claseSindicato;
	}
	
	public void setClaseSindicato(Integer aClaseSindicato) throws BaseException {
		this.claseSindicato = aClaseSindicato;
	}
	
	public Integer getMotivoEgresoEmp() throws BaseException {
		supportRefresh();
		return this.motivoEgreso;
	}
	
	public void setMotivoEgresoEmp(Integer aMotivoEgresoEmp) throws BaseException {
		this.motivoEgreso = aMotivoEgresoEmp;
	}

	public java.util.Date getFecAntReconocida() throws BaseException {
		supportRefresh();
		return this.fecAntReco;
	}
	
	public void setFecAntReconocida(java.util.Date aFecAntRec) throws BaseException {
		this.fecAntReco = aFecAntRec;
	}
	
	
	public Integer getTipoDocumento() throws BaseException {
		supportRefresh();
		return this.tipoDocumento;
	}
	
	public void setTipoDocumento(Integer aTipoDocumento) throws BaseException {
		this.tipoDocumento = aTipoDocumento;
	}
	
	public String getNroDocumento() throws BaseException {
		supportRefresh();
		return this.nroDocumento;
	}
	
	public void setNroDocumento(String aNroDocumento) throws BaseException {
		this.nroDocumento = aNroDocumento;
	}
	
	public String getTelParticular() throws BaseException {
		supportRefresh();
		return this.telParticular;
	}
	
	public void setTelParticular(String aTelParticular) throws BaseException {
		this.telParticular = aTelParticular;
	}
	
	public String getCelParticular() throws BaseException {
		supportRefresh();
		return this.telCelular;
	}
	
	public void setTelCelular(String aTelCelular) throws BaseException {
		this.telCelular = aTelCelular;
	}

	public java.util.Date getFecNacimiento() throws BaseException {
		supportRefresh();
		return this.fecNacimiento;
	}
	
	public void setFecNacimiento(java.util.Date aFecNacimiento) throws BaseException {
		this.fecNacimiento = aFecNacimiento;
	}
	
	public String getEstadoCivil() throws BaseException {
		supportRefresh();
		return this.estadoCivil;
	}
	
	public void setEstadoCivil(String aEstadoCivil) throws BaseException {
		this.estadoCivil = aEstadoCivil;
	}
	
	public String getDireccion() throws BaseException {
		supportRefresh();
		return direccion;
	}
	
	public void setDireccion(String aDireccion) throws BaseException {
		this.direccion = aDireccion;
	}
	
	public String getRUT() throws BaseException {
		supportRefresh();
		return rut;
	}
	
	public void setRUT(String aRut) throws BaseException {
		this.rut = aRut;
	}
	
	public String getSexo() throws BaseException {
		supportRefresh();
		return sexo;
	}
	
	public void setSexo(String aSexo) throws BaseException {
		this.sexo = aSexo;
	}
	
	
	
	public String getEmpresa() throws BaseException {
		supportRefresh();
		return empresa;
	}
	
	public String getCredenc() throws BaseException {
		supportRefresh();
		return this.credenc;
	}
	
	public int getCargo() throws BaseException {
		supportRefresh();
		return cargo;
	}
	
	public void setEmpresa(String aEmpresa) {
		this.empresa = aEmpresa;
	}
	
	public void setCargo(Integer aCargo) {
		this.cargo = aCargo;
	}
	
	
	public void setCredenc(String aCredenc) {
		this.credenc = aCredenc;
	}
	

	public String getCodigo() throws BaseException {
		supportRefresh();
		return codigo;
	}

	public void setCodigo(String aCodigo) {
		this.codigo = aCodigo;
	}

	public String getNombre() throws BaseException {
		supportRefresh();
		return nombre;
	}

	public void setNombre(String aNombre) {
		this.nombre = aNombre;
	}

	public String getEstado() throws BaseException {
		supportRefresh();
		return estado;
	}

	public void setEstado(String aEstado) {
		this.estado = aEstado;
	}

	public java.util.Date getFecha_ing() throws BaseException {
		supportRefresh();
		return fecha_ing;
	}

	public void setFecha_ing(java.util.Date aFecha_ing) {
		this.fecha_ing = aFecha_ing;
	}

	public java.util.Date getFecha_ret() throws BaseException {
		supportRefresh();
		return fecha_ret;
	}

	public void setFecha_ret(java.util.Date aFecha_ret) {
		this.fecha_ret = aFecha_ret;
	}

	public Integer getCencos() throws BaseException {
		supportRefresh();
		return cencos;
	}

	public void setCencos(Integer aCencos) {
		this.cencos = aCencos;
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

	public static RemplesPayroll findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (RemplesPayroll) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static RemplesPayroll findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (RemplesPayroll) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
	}
	
	public static void truncarTablaRemplesPayroll(ISesion aSesion)
	  throws BaseException {
	  	 DBRemplesPayroll.truncarTablaRemplesPayroll(aSesion);
	}
	
	public static List getAll(ISesion aSesion) throws BaseException {
		  return DBRemplesPayroll.getAll(aSesion);
	}

}
