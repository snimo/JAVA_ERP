package com.srn.erp.proveedoresMaterials.bm;

import java.util.List;

import com.srn.erp.proveedoresMaterials.da.DBProveedorMaterialControl;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class ProveedorMaterialsControl extends ObjetoLogico {

	public ProveedorMaterialsControl() {
	}

	public static String NICKNAME = "ma.proveedorMaterialControl";

	private String cuit;
	private String cuit2;
	private String razonSocial;
	private String razonSocial2;
	private String direccion;
	private String contacto;
	private String comercail;
	private String telefono;
	private String email;
	private Integer grupoProveedor;
	private String condicionPago;
	private String activo;

	private String owner;
	private String dbLink;

	public void beforeSave() throws BaseException {
		Validar.noNulo(cuit, "Es nesesario cargar un Cuit");
		Validar.noNulo(cuit2, "Es nesesario cargar un Cuit");
		Validar.noNulo(razonSocial, "Es nesesario cargar una Razon Social");
		Validar.noNulo(razonSocial2, "Es nesesario cargar una Razon Social");
		Validar.noNulo(direccion, "Es nesesario cargar una Direccion");
		Validar.noNulo(contacto, "Es nesesario cargar un Contacto");
		Validar.noNulo(comercail, "Es nesesario cargar un Comercial");
		Validar.noNulo(telefono, "Es nesesario cargar un Telefono");
		Validar.noNulo(email, "Es nesesario cargar un Email");
		Validar.noNulo(grupoProveedor, "Es nesesario cargar un Grupo de Proveedor");
		Validar.noNulo(condicionPago, "Es nesesario cargar una Condicion de Pago");
	}

	public String getCuit() throws BaseException {
		supportRefresh();
		return cuit;
	}

	public void setCuit(String cuit) {
		this.cuit = cuit;
	}

	public String getCuit2() throws BaseException {
		supportRefresh();
		return cuit2;
	}

	public void setCuit2(String cuit2) {
		this.cuit2 = cuit2;
	}

	public String getRazonsocial() throws BaseException {
		supportRefresh();
		return razonSocial;
	}

	public void setRazonsocial(String aRazonsocial) {
		this.razonSocial = aRazonsocial;
	}

	public String getRazonSocial2() throws BaseException {
		supportRefresh();
		return razonSocial2;
	}

	public void setRazonSocial2(String razonSocial2) {
		this.razonSocial2 = razonSocial2;
	}

	public String getDireccion() throws BaseException {
		supportRefresh();
		return direccion;
	}

	public void setDireccion(String aDireccion) {
		this.direccion = aDireccion;
	}

	public String getContacto() throws BaseException {
		supportRefresh();
		return contacto;
	}

	public void setContacto(String aContacto) {
		this.contacto = aContacto;
	}

	public String getComercail() throws BaseException {
		supportRefresh();
		return comercail;
	}

	public void setComercail(String aComercail) {
		this.comercail = aComercail;
	}

	public String getTelefono() throws BaseException {
		supportRefresh();
		return telefono;
	}

	public void setTelefono(String aTelefono) {
		this.telefono = aTelefono;
	}

	public String getEmail() throws BaseException {
		supportRefresh();
		return email;
	}

	public void setEmail(String aEmail) {
		this.email = aEmail;
	}

	public Integer getGrupoproveedor() throws BaseException {
		supportRefresh();
		return grupoProveedor;
	}

	public void setGrupoproveedor(Integer aGrupoproveedor) {
		this.grupoProveedor = aGrupoproveedor;
	}

	public String getCondicionpago() throws BaseException {
		supportRefresh();
		return condicionPago;
	}

	public void setCondicionpago(String aCondicionpago) {
		this.condicionPago = aCondicionpago;
	}

	public String getActivo() throws BaseException {
		supportRefresh();
		return activo;
	}

	public void setActivo(String aActivo) {
		this.activo = aActivo;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getDbLink() {
		return dbLink;
	}

	public void setDbLink(String dbLink) {
		this.dbLink = dbLink;
	}

	public String getNickName() {
		return NICKNAME;
	}

	public String get(String propiedad) {
		if (propiedad.equals("cuit")) {
			return cuit;
		} else if (propiedad.equals("razonSocial")) {
			return razonSocial;
		} else if (propiedad.equals("direccion")) {
			return direccion;
		} else if (propiedad.equals("contacto")) {
			return contacto;
		} else if (propiedad.equals("comercail")) {
			return comercail;
		} else if (propiedad.equals("telefono")) {
			return telefono;
		} else if (propiedad.equals("email")) {
			return email;
		} else if (propiedad.equals("condicionPago")) {
			return condicionPago;
		} else {
			return activo;
		}
	}

	public static ProveedorMaterialsControl findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (ProveedorMaterialsControl) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static ProveedorMaterialsControl findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (ProveedorMaterialsControl) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public static List<ProveedorMaterialsControl> findByCuitUte(String cuit, ISesion aSesion) throws BaseException {
		return (List<ProveedorMaterialsControl>) DBProveedorMaterialControl.getByCuitUte(cuit, aSesion);
	}

	public static List<ProveedorMaterialsControl> findByCuitBinbaires(String cuit, ISesion aSesion) throws BaseException {
		return (List<ProveedorMaterialsControl>) DBProveedorMaterialControl.getByCuitBinbaires(cuit, aSesion);
	}

	public static List<ProveedorMaterialsControl> findByCuitAlavera(String cuit, ISesion aSesion) throws BaseException {
		return (List<ProveedorMaterialsControl>) DBProveedorMaterialControl.getByCuitAlavera(cuit, aSesion);
	}

	public static List<ProveedorMaterialsControl> findByCuitMagic(String cuit, ISesion aSesion) throws BaseException {
		return (List<ProveedorMaterialsControl>) DBProveedorMaterialControl.getByCuitMagic(cuit, aSesion);
	}

	public static List<ProveedorMaterialsControl> findByRazonSocialUte(String razonSocial, ISesion aSesion) throws BaseException {
		return (List<ProveedorMaterialsControl>) DBProveedorMaterialControl.getByRazonSocialUte(razonSocial, aSesion);
	}

	public static List<ProveedorMaterialsControl> findByRazonSocialBinbaires(String razonSocial, ISesion aSesion) throws BaseException {
		return (List<ProveedorMaterialsControl>) DBProveedorMaterialControl.getByRazonSocialBinbaires(razonSocial, aSesion);
	}

	public static List<ProveedorMaterialsControl> findByRazonSocialAlavera(String razonSocial, ISesion aSesion) throws BaseException {
		return (List<ProveedorMaterialsControl>) DBProveedorMaterialControl.getByRazonSocialAlavera(razonSocial, aSesion);
	}

	public static List<ProveedorMaterialsControl> findByRazonSocialMagic(String razonSocial, ISesion aSesion) throws BaseException {
		return (List<ProveedorMaterialsControl>) DBProveedorMaterialControl.getByRazonSocialMagic(razonSocial, aSesion);
	}
	
	public static List<ProveedorMaterialsControl> findByRazonSocialNoCuitUte(String razonSocial, String cuit, ISesion aSesion) throws BaseException {
		return (List<ProveedorMaterialsControl>) DBProveedorMaterialControl.getByRazonSocialNoCuitUte(razonSocial, cuit, aSesion);
	}

	public static List<ProveedorMaterialsControl> findByRazonSocialNoCuitBinbaires(String razonSocial, String cuit, ISesion aSesion) throws BaseException {
		return (List<ProveedorMaterialsControl>) DBProveedorMaterialControl.getByRazonSocialNoCuitBinbaires(razonSocial, cuit, aSesion);
	}

	public static List<ProveedorMaterialsControl> findByRazonSocialNoCuitAlavera(String razonSocial, String cuit, ISesion aSesion) throws BaseException {
		return (List<ProveedorMaterialsControl>) DBProveedorMaterialControl.getByRazonSocialNoCuitAlavera(razonSocial, cuit, aSesion);
	}

	public static List<ProveedorMaterialsControl> findByRazonSocialNoCuitMagic(String razonSocial, String cuit, ISesion aSesion) throws BaseException {
		return (List<ProveedorMaterialsControl>) DBProveedorMaterialControl.getByRazonSocialNoCuitMagic(razonSocial, cuit, aSesion);
	}

	@Override
	public String getCodigo() throws BaseException {
		return null;
	}

	@Override
	public String getDescripcion() throws BaseException {
		return null;
	}

	@Override
	public Boolean isActivo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

}