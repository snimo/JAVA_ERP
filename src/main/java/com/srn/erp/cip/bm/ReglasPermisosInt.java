package com.srn.erp.cip.bm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.cip.da.DBReglasPermisosInt;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class ReglasPermisosInt extends ObjetoLogico {

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public ReglasPermisosInt() {
	}

	public static String NICKNAME = "cip.ReglasPermisosInt";

	private PermisosInternos permisosInternos;
	private Integer prioridad;
	private String descripcion;
	private Boolean es_una_vista;
	private Boolean activo;

	private List accesosInternosPuertas = new ArrayList();
	private boolean readAccesosInternosPuertas = true;
	
	private List accesosInternosLegajos = new ArrayList();
	private boolean readAccesosInternosLegajos = true;
	
	private List accesosInternosEmpresas = new ArrayList();
	private boolean readAccesosInternosEmpresas = true;
	
	private List accesosInternosSectores = new ArrayList();
	private boolean readAccesosInternosSectores = true;	
	
	private List accesosInternosPuestos = new ArrayList();
	private boolean readAccesosInternosPuestos = true;	
	
	private List accesosInternosEstados = new ArrayList();
	private boolean readAccesosInternosEstados= true;	
	
		public PermisosInternos getPermisosinternos() throws BaseException {
		supportRefresh();
		return permisosInternos;
	}

	public void setPermisosinternos(PermisosInternos aPermisosinternos) {
		this.permisosInternos = aPermisosinternos;
	}

	public Integer getPrioridad() throws BaseException {
		supportRefresh();
		return prioridad;
	}

	public void setPrioridad(Integer aPrioridad) {
		this.prioridad = aPrioridad;
	}

	public String getDescripcion() throws BaseException {
		supportRefresh();
		return descripcion;
	}

	public void setDescripcion(String aDescripcion) {
		this.descripcion = aDescripcion;
	}

	public Boolean isEs_una_vista() throws BaseException {
		supportRefresh();
		return es_una_vista;
	}

	public void setEs_una_vista(Boolean aEs_una_vista) {
		this.es_una_vista = aEs_una_vista;
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

	public static ReglasPermisosInt findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (ReglasPermisosInt) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static ReglasPermisosInt findByOidProxy(Integer oid, ISesion aSesion) throws BaseException {
		return (ReglasPermisosInt) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}

	public static ReglasPermisosInt findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (ReglasPermisosInt) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(permisosInternos, "Debe ingresar los permisos Internos");
		Validar.noNulo(descripcion, "Debe ingresar la Descripción");
	}

	public static List getReglasPermisosInt(PermisosInternos permisos, ISesion aSesion) throws BaseException {
		return DBReglasPermisosInt.getReglasPermisosInt(permisos, aSesion);
	}

	public List getAccesosInternosPuertas() throws BaseException {
		if (this.readAccesosInternosPuertas) {
			List listaAccesosInternos = AccesoInternoPuerta.getAccesosInternosPuertas(this, getSesion());
			accesosInternosPuertas.addAll(listaAccesosInternos);
			this.readAccesosInternosPuertas = false;
		}
		return accesosInternosPuertas;
	}
	
	
	public List getAccesosInternosLegajos() throws BaseException {
		if (this.readAccesosInternosLegajos) {
			List listaAccesosInternosLeg = PermisoInternoLegajo.getPermisosInternosLegajos(this, getSesion());
			this.accesosInternosLegajos.addAll(listaAccesosInternosLeg);
			this.readAccesosInternosLegajos = false;
		}
		return this.accesosInternosLegajos;
	}
	
	public List getAccesosInternosEmpresas() throws BaseException {
		if (this.readAccesosInternosEmpresas) {
			List listaAccesosInternosEmp = PermisoInternoEmpresa.getPermisosIntEmpresa(this, getSesion());
			this.accesosInternosEmpresas.addAll(listaAccesosInternosEmp);
			this.readAccesosInternosEmpresas = false;
		}
		return this.accesosInternosEmpresas;
	}	
	
	public List getAccesosInternosSectores() throws BaseException {
		if (this.readAccesosInternosSectores) {
			List listaAccesosInternosSec = PermisoInternoSector.getPermisosInternosSec(this, getSesion());
			this.accesosInternosSectores.addAll(listaAccesosInternosSec);
			this.readAccesosInternosSectores = false;
		}
		return this.accesosInternosSectores;
	}	
	
	public List getAccesosInternosPuestos() throws BaseException {
		if (this.readAccesosInternosPuestos) {
			List listaAccesosInternosPue = PermisoInternoPuesto.getPermisosIternosPuesto(this, getSesion());
			this.accesosInternosPuestos.addAll(listaAccesosInternosPue);
			this.readAccesosInternosPuestos = false;
		}
		return this.accesosInternosPuestos;
	}	
	
	
	public List getAccesosInternosEstados() throws BaseException {
		if (this.readAccesosInternosEstados) {
			List listaAccesosInternosEst = PermisoInternoEstado.getPermisoInternosEstado(this, getSesion());
			this.accesosInternosEstados.addAll(listaAccesosInternosEst);
			this.readAccesosInternosEstados = false;
		}
		return this.accesosInternosEstados;
	}	
	

	public void addAccesoInternoPuerta(AccesoInternoPuerta aAccesoInternoPuerta) throws BaseException {
		aAccesoInternoPuerta.setRegla(this);
		this.accesosInternosPuertas.add(aAccesoInternoPuerta);
	}
	
	public void addAccesoInternoPuesto(PermisoInternoPuesto aPermisoInternoPuesto) throws BaseException {
		aPermisoInternoPuesto.setRegla_permiso(this);
		this.accesosInternosPuestos.add(aPermisoInternoPuesto);
	}	
	
	public void addAccesoInternoLegajo(PermisoInternoLegajo aPermisoInternoLegajo) throws BaseException {
		aPermisoInternoLegajo.setRegla_permiso(this);
		this.accesosInternosLegajos.add(aPermisoInternoLegajo);
	}	
	
	public void addAccesoInternoEmpresa(PermisoInternoEmpresa aPermisoInternoEmpresa) throws BaseException {
		aPermisoInternoEmpresa.setRegla_permiso(this);
		this.accesosInternosEmpresas.add(aPermisoInternoEmpresa);
	}	
	
	public void addAccesoInternoSector(PermisoInternoSector aPermisoInternoSector) throws BaseException {
		aPermisoInternoSector.setRegla_permiso(this);
		this.accesosInternosSectores.add(aPermisoInternoSector);
	}	
	
	
	public void addAccesoInternoEstado(PermisoInternoEstado aPermisoInternoEstado) throws BaseException {
		aPermisoInternoEstado.setRegla_permiso(this);
		this.accesosInternosEstados.add(aPermisoInternoEstado);
	}	

	public void afterSave() throws BaseException {
		
		Iterator iterAccesosInternasPuertas = this.accesosInternosPuertas.iterator();
		while (iterAccesosInternasPuertas.hasNext()) {
			AccesoInternoPuerta accesoInternoPuerta = (AccesoInternoPuerta) iterAccesosInternasPuertas.next();
			accesoInternoPuerta.save();
			accesoInternoPuerta = null;
		}
		iterAccesosInternasPuertas = null;
		
		Iterator iterAccesosInternosLegajos = this.accesosInternosLegajos.iterator();
		while (iterAccesosInternosLegajos.hasNext()) {
			PermisoInternoLegajo permisoInternoLegajo = (PermisoInternoLegajo) iterAccesosInternosLegajos.next();
			permisoInternoLegajo.save();
			permisoInternoLegajo = null;
		}
		iterAccesosInternosLegajos = null;
		
		Iterator iterAccesosInternosSectores = this.accesosInternosSectores.iterator();
		while (iterAccesosInternosSectores.hasNext()) {
			PermisoInternoSector permisoInternoSector = (PermisoInternoSector) iterAccesosInternosSectores.next();
			permisoInternoSector.save();
			permisoInternoSector = null;
		}
		iterAccesosInternosSectores = null;		
		
		Iterator iterAccesosInternosEmpresas = this.accesosInternosEmpresas.iterator();
		while (iterAccesosInternosEmpresas.hasNext()) {
			PermisoInternoEmpresa permisoInternoEmpresa = (PermisoInternoEmpresa) iterAccesosInternosEmpresas.next();
			permisoInternoEmpresa.save();
			permisoInternoEmpresa = null;
		}
		iterAccesosInternosEmpresas = null;		
		
		
		Iterator iterAccesosInternosPuestos = this.accesosInternosPuestos.iterator();
		while (iterAccesosInternosPuestos.hasNext()) {
			PermisoInternoPuesto permisoInternoPuesto = (PermisoInternoPuesto) iterAccesosInternosPuestos.next();
			permisoInternoPuesto.save();
			permisoInternoPuesto = null;
		}
		iterAccesosInternosPuestos = null;		
		
		
		Iterator iterAccesosInternosEstados = this.accesosInternosEstados.iterator();
		while (iterAccesosInternosEstados.hasNext()) {
			PermisoInternoEstado permisoInternoEstado= (PermisoInternoEstado) iterAccesosInternosEstados.next();
			permisoInternoEstado.save();
			permisoInternoEstado = null;
		}
		iterAccesosInternosEstados = null;		
		
		
		
	}

}
