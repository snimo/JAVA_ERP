package com.srn.erp.general.bm;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.general.da.DBSucursal;
import com.srn.erp.tesoreria.bm.Caja;
import com.srn.erp.tesoreria.bm.GrupoCajas;
import com.srn.erp.tesoreria.da.DBCaja;
import com.srn.erp.ventas.bm.FechaFacturacionSucursal;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bm.Parametros.ValorParametro;
import framework.applicarionServer.bm.Seguridad.ISucursal;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class Sucursal extends ObjetoLogico implements ISucursal {

	public Sucursal() {
	}

	public static String NICKNAME = "ge.Sucursal";

	private String codigo;
	private String descripcion;
	private String calle_y_nro;
	private String localidad;
	private String codigo_postal;
	private Provincia provincia;
	private Pais pais;
	private Boolean activo;
	private String telefonos;
	private String pathLogo;
	private String fax;
	private boolean esAgentePercIBBsAs;
	private boolean esAgentePercIBCapFed;
	private boolean esAgentePercIVA;

	public String getCodigo() throws BaseException {
		supportRefresh();
		return codigo;
	}

	public String getFax() throws BaseException {
		supportRefresh();
		return this.fax;
	}

	public void setFax(String aFax) throws BaseException {
		this.fax = aFax;
	}

	public boolean isAgentePercIBBsAs() throws BaseException {
		supportRefresh();
		return this.esAgentePercIBBsAs;
	}

	public void setAgentePercIBBsAs(boolean aAgentePercIB) throws BaseException {
		this.esAgentePercIBBsAs = aAgentePercIB;
	}

	public boolean isAgentePercIVA() throws BaseException {
		supportRefresh();
		return this.esAgentePercIVA;
	}

	public void setAgentePercIVA(boolean aAgentePercIVA) throws BaseException {
		this.esAgentePercIVA = aAgentePercIVA;
	}

	public boolean isAgentePercIBCapFed() throws BaseException {
		supportRefresh();
		return this.esAgentePercIBCapFed;
	}

	public void setAgentePercIBCapFed(boolean aAgentePercIBCapFed) throws BaseException {
		this.esAgentePercIBCapFed = aAgentePercIBCapFed;
	}

	public String getPathLogo() throws BaseException {
		supportRefresh();
		return this.pathLogo;
	}

	public void setPathLogo(String aPathLogo) {
		this.pathLogo = aPathLogo;
	}

	public void setCodigo(String aCodigo) {
		this.codigo = aCodigo;
	}

	public String getTelefonos() throws BaseException {
		supportRefresh();
		return telefonos;
	}

	public void setTelefonos(String aTelefonos) {
		this.telefonos = aTelefonos;
	}

	public String getDescripcion() throws BaseException {
		supportRefresh();
		return descripcion;
	}

	public void setDescripcion(String aDescripcion) {
		this.descripcion = aDescripcion;
	}

	public String getCalle_y_nro() throws BaseException {
		supportRefresh();
		return calle_y_nro;
	}

	public void setCalle_y_nro(String aCalle_y_nro) {
		this.calle_y_nro = aCalle_y_nro;
	}

	public String getLocalidad() throws BaseException {
		supportRefresh();
		return localidad;
	}

	public void setLocalidad(String aLocalidad) {
		this.localidad = aLocalidad;
	}

	public String getCodigo_postal() throws BaseException {
		supportRefresh();
		return codigo_postal;
	}

	public void setCodigo_postal(String aCodigo_postal) {
		this.codigo_postal = aCodigo_postal;
	}

	public Provincia getProvincia() throws BaseException {
		supportRefresh();
		return provincia;
	}

	public void setProvincia(Provincia aProvincia) {
		this.provincia = aProvincia;
	}

	public Pais getPais() throws BaseException {
		supportRefresh();
		return pais;
	}

	public void setPais(Pais aPais) {
		this.pais = aPais;
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

	public static Sucursal findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (Sucursal) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static Sucursal findByOidProxy(Integer oid, ISesion aSesion) throws BaseException {
		return (Sucursal) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}

	public static Sucursal findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (Sucursal) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(codigo, "Debe ingresar el Código Sucursal");
		Validar.noNulo(descripcion, "Debe ingresar la Descripción");
		Validar.noNulo(calle_y_nro, "Debe ingresar la Dirección");
		Validar.noNulo(localidad, "Debe ingresar la Localidad");
		Validar.noNulo(provincia, "Debe ingresar la Provincia");
		Validar.noNulo(pais, "Debe ingresar el País");
	}

	public static List getSucursales(ISesion aSesion) throws BaseException {
		return DBSucursal.getSucursales(aSesion);
	}

	public List getUnidadesOrganizacionales() throws BaseException {
		return UnidadOrganizativa.getUnidadesOrganizativas(this, getSesion());
	}

	public List getUniOrgHabilitadas(Empresa empresa) throws BaseException {
		List listaUnidadesOrganizativas = new ArrayList();
		List listaUniOrgHabUsu = UniOrgHabUsu.getUniOrgHabUsu(empresa, this, getSesion().getLogin().getUsuario(), getSesion());
		Iterator iterUniOrgHabUsu = listaUniOrgHabUsu.iterator();
		while (iterUniOrgHabUsu.hasNext()) {
			UniOrgHabUsu uniOrgHabUsu = (UniOrgHabUsu) iterUniOrgHabUsu.next();
			listaUnidadesOrganizativas.add(uniOrgHabUsu.getUnidad_organizacion());
		}
		return listaUnidadesOrganizativas;
	}

	public static Sucursal getSucursal(ISucursal aSucursal, ISesion aSesion) throws BaseException {
		return Sucursal.findByOid(aSucursal.getOIDInteger(), aSesion);
	}

	public static Sucursal getSucursal(ISesion aSesion) throws BaseException {
		return Sucursal.findByOidProxy(aSesion.getLogin().getOidSucursal(), aSesion);
	}

	public Date getFechaFacturacion() throws BaseException {
		FechaFacturacionSucursal fecFactuSuc = FechaFacturacionSucursal.getFechaFacturacion(this, this.getSesion());
		if (fecFactuSuc != null)
			return fecFactuSuc.getFecha_actual();
		else
			return null;
	}

	public String getCodigoPostalYLocalidad() throws BaseException {
		StringBuffer codPostalYLoc = new StringBuffer();
		if ((this.getCodigo_postal() != null) && (this.getCodigo_postal().length() != 0)) {
			codPostalYLoc.append("(" + this.getCodigo_postal() + ") ");
		}
		codPostalYLoc.append(this.getLocalidad());
		return codPostalYLoc.toString();
	}

	public static String getPathLogoSucursal(ISesion aSesion) throws BaseException {
		ValorParametro valorPath = ValorParametro.findByCodigoParametro("PATH_LOGO_SUCURSAL", aSesion);
		return valorPath.getValorCadena();
	}

	public static List getSucursales(GrupoCajas grupoCajas, ISesion aSesion) throws BaseException {
		return DBSucursal.getSucursales(grupoCajas, aSesion);
	}
	
	public List getCajas() throws BaseException {
		return DBCaja.getCajas(this, this.getSesion());
	}
	
	public int getCantCajas() throws BaseException {
		int cantidad = 0;
		Iterator iteratorCajas = 
			getCajas().iterator();
		while (iteratorCajas.hasNext()) {
			iteratorCajas.next();
			cantidad++;
		}
		return cantidad;
	}
	
	public int getCantCajasGrupo(GrupoCajas grupoCajas) throws BaseException {
		int cantidad = 0;
		Iterator iteratorCajas = 
			getCajas().iterator();
		while (iteratorCajas.hasNext()) {
			Caja caja = (Caja)iteratorCajas.next();
			if (grupoCajas.getGrupoCajasDet(caja)!=null)
				cantidad++;
		}
		return cantidad;
	}
	
	

}
