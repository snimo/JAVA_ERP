package com.srn.erp.general.bm;

import java.util.Date;
import java.util.List;

import com.srn.erp.general.da.DBEmpresa;
import com.srn.erp.impuestos.bm.CategoriaIB;
import com.srn.erp.impuestos.bm.CategoriaIVA;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bm.Parametros.ValorParametro;
import framework.applicarionServer.bm.Seguridad.IEmpresa;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class Empresa extends ObjetoLogico implements IEmpresa {

	public Empresa() {
	}

	public static String NICKNAME = "ge.Empresa";

	private String codigo;
	private String razon_social;
	private String nombre_fantasia;
	private String calle_y_nro;
	private String localidad;
	private String codigo_postal;
	private Provincia provincia;
	private Pais pais;
	private CategoriaIVA categoria_iva;
	private CategoriaIB categoria_ib;
	private String CUIT;
	private String nro_ing_brutos;
	private Boolean agen_ret_iva;
	private Boolean agen_ret_gan;
	private Boolean agen_ret_ib;
	private String archivo_logo;
	private Boolean activo;
	private String archXMLPoolBD;
	private Date inicioActividad;
	private boolean esAgentePercIBBsAs;
	private boolean esAgentePercIBCapFed;
	private boolean esAgentePercIVA;
	
	
	public void setArchXMLPoolBD(String aArchXMLPoolBD) throws BaseException {
		this.archXMLPoolBD = aArchXMLPoolBD;
	}

	public String getArchXMLPoolBD() throws BaseException {
		supportRefresh();
		return archXMLPoolBD;
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

	public void setAgentePercIBCapFed(boolean aAgentePercIBCapFed)
			throws BaseException {
		this.esAgentePercIBCapFed = aAgentePercIBCapFed;
	}

	public String getCodigo() throws BaseException {
		supportRefresh();
		return codigo;
	}

	public void setCodigo(String aCodigo) throws BaseException {
		this.codigo = aCodigo;
	}

	public Date getInicioActividad() throws BaseException {
		supportRefresh();
		return this.inicioActividad;
	}

	public void setInicioActividad(Date aInicioActividad) throws BaseException {
		this.inicioActividad = aInicioActividad;
	}

	public String getRazon_social() throws BaseException {
		supportRefresh();
		return razon_social;
	}

	public void setRazon_social(String aRazon_social) {
		this.razon_social = aRazon_social;
	}

	public String getNombre_fantasia() throws BaseException {
		supportRefresh();
		return nombre_fantasia;
	}

	public void setNombre_fantasia(String aNombre_fantasia) {
		this.nombre_fantasia = aNombre_fantasia;
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

	public CategoriaIVA getCategoria_iva() throws BaseException {
		supportRefresh();
		return categoria_iva;
	}

	public void setCategoria_iva(CategoriaIVA aCategoria_iva) {
		this.categoria_iva = aCategoria_iva;
	}

	public CategoriaIB getCategoria_ib() throws BaseException {
		supportRefresh();
		return categoria_ib;
	}

	public void setCategoria_ib(CategoriaIB aCategoria_ib) {
		this.categoria_ib = aCategoria_ib;
	}

	public String getCuit() throws BaseException {
		supportRefresh();
		return CUIT;
	}

	public void setCuit(String aCuit) {
		this.CUIT = aCuit;
	}

	public String getNro_ing_brutos() throws BaseException {
		supportRefresh();
		return nro_ing_brutos;
	}

	public void setNro_ing_brutos(String aNro_ing_brutos) {
		this.nro_ing_brutos = aNro_ing_brutos;
	}

	public Boolean isAgen_ret_iva() throws BaseException {
		supportRefresh();
		return agen_ret_iva;
	}

	public void setAgen_ret_iva(Boolean aAgen_ret_iva) {
		this.agen_ret_iva = aAgen_ret_iva;
	}

	public Boolean isAgen_ret_gan() throws BaseException {
		supportRefresh();
		return agen_ret_gan;
	}

	public void setAgen_ret_gan(Boolean aAgen_ret_gan) {
		this.agen_ret_gan = aAgen_ret_gan;
	}

	public Boolean isAgen_ret_ib() throws BaseException {
		supportRefresh();
		return agen_ret_ib;
	}

	public void setAgen_ret_ib(Boolean aAgen_ret_ib) {
		this.agen_ret_ib = aAgen_ret_ib;
	}

	public String getArchivo_logo() throws BaseException {
		supportRefresh();
		return archivo_logo;
	}

	public void setArchivo_logo(String aArchivo_logo) {
		this.archivo_logo = aArchivo_logo;
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

	public static Empresa findByOid(Integer oid, ISesion aSesion)
			throws BaseException {
		return (Empresa) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static Empresa findByOidProxy(Integer oid, ISesion aSesion)
			throws BaseException {
		return (Empresa) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}

	public static Empresa findByCodigo(String codigo, ISesion aSesion)
			throws BaseException {
		return (Empresa) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(razon_social, "Debe ingresar la Razón Social");
		Validar.noNulo(nombre_fantasia, "Debe ingresar un nombre de Fantasía");
		Validar.noNulo(calle_y_nro, "Debe ingresar la calle y nro.");
		Validar.noNulo(localidad, "Debe ingresar la Localidad");
		Validar.noNulo(provincia, "Debe ingresar la Provincia");
		Validar.noNulo(pais, "Debe ingresar el País");
		Validar.noNulo(categoria_iva, "Debe ingresar la Categoría de IVA");
		Validar.noNulo(categoria_ib, "Debe ingresar la Categoría de IB");
		Validar.noNulo(CUIT, "Debe ingresar el Nro. de C.U.I.T.");
		Validar.noNulo(nro_ing_brutos, "Debe ingresar el Nro. de IB");
		Validar.noNulo(agen_ret_iva,
				"Debe indicar si es agente de Retención de IVA");
		Validar.noNulo(agen_ret_gan,
				"Debe indicar si es agente de Retención de IB");
		Validar.noNulo(agen_ret_ib,
				"Debe indicar si es agente de Retención de Gan.");
		Validar.noNulo(codigo, "Debe ingresar el Código");
	}

	/**
	 * getDescripcion
	 * 
	 * @return String
	 */
	public String getDescripcion() {
		return "";
	}

	public static List getEmpresas(ISesion aSesion) throws BaseException {
		return DBEmpresa.getEmpresas(aSesion);
	}

	public static final Empresa getEmpresa(ISesion aSesion)
			throws BaseException {
		return Empresa.findByOidProxy(aSesion.getLogin().getOidEmpresa(),
				aSesion);
	}

	public static String getPathLogoEmpresa(ISesion aSesion)
			throws BaseException {
		ValorParametro valorPath = ValorParametro
				.findByCodigoParametro("PATH_LOGO_EMPRESAS", aSesion);
		return valorPath.getValorCadena();
	}

	/**
	 * getCodigo
	 * 
	 * @return String
	 */
}
