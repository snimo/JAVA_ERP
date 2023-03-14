package com.srn.erp.compras.bm;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.compras.da.DBProveedor;
import com.srn.erp.general.bm.ClasificadorEntidad;
import com.srn.erp.general.bm.IEntidadClasificable;
import com.srn.erp.general.bm.Idioma;
import com.srn.erp.general.bm.Moneda;
import com.srn.erp.general.bm.Pais;
import com.srn.erp.general.bm.Provincia;
import com.srn.erp.general.bm.ValorClasificadorEntidad;
import com.srn.erp.impuestos.bm.SujetoImpositivo;
import com.srn.erp.pagos.bm.FormaPago;
import com.srn.erp.ventas.bm.TipoDocumento;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bm.Parametros.ValorParametro;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.Validar;

public class Proveedor extends ObjetoLogico implements IEntidadClasificable {

	public Proveedor() {
	}
	
	boolean generarCodigoAut = false;

	public static String NICKNAME = "cp.Proveedor";

	private String codigo;

	private String razonSocial;

	private String direccion;

	private String localidad;

	private String codigoPostal;

	private Provincia provincia;

	private Boolean habitual;

	private String ordencheque;

	private Boolean envOCMail;

	private Boolean encOCCorreo;

	private Boolean encOCFax;

	private CertificacionProveedor certProv;

	private Moneda monedaOC;

	private Pais pais;

	private Idioma idioma;

	private SujetoImpositivo sujetoImpositivo;

	private java.util.Date fechaInhabilitacion;

	private FormaPago formaPago;

	private Boolean activo;

	private String tomarPrecioOC;

	private String tomarPrecioOC1;
	private String tomarPrecioOC2;
	private String tomarPrecioOC3;
	private String tomarPrecioOC4;
	private String tomarPrecioOC5;

	private Boolean permitirRecepProdSinOC;

	private Boolean permitirCambiarTomarPrecio;

	private Boolean dtoEnCascada;

	private Boolean domDevMerc;

	private ViaDespacho viaDespacho;

	private CondCompraImportacion condCompraImpo;

	private TipoDocumento tipoDocumento;

	private List condicionesCompra = new ArrayList();

	private boolean readListaCondCompra = true;

	private List contactosProveedor = new ArrayList();

	private boolean readListaContactos = true;

	private List otrasDirecciones = new ArrayList();

	private boolean readOtrasDirecciones = true;

	public Boolean isPermitirRecepProdSinOC() throws BaseException {
		supportRefresh();
		return this.permitirRecepProdSinOC;
	}

	public void setPermitirRecepProdSinOC(Boolean aPermitirRecepProdSinOC) {
		this.permitirRecepProdSinOC = aPermitirRecepProdSinOC;
	}

	public Boolean isPermitirCambioTomarPrecioOC() throws BaseException {
		supportRefresh();
		return this.permitirCambiarTomarPrecio;
	}

	public Boolean isDomicilioDevolucionMerc() throws BaseException {
		supportRefresh();
		return this.domDevMerc;
	}

	public void setPermitirCambioTomarPrecioOC(Boolean aPermitirCambio) {
		this.permitirCambiarTomarPrecio = aPermitirCambio;
	}

	public void setDomicilioDevolucionMerc(Boolean aDomicilioDevolucionMerc) {
		this.domDevMerc = aDomicilioDevolucionMerc;
	}

	public TipoDocumento getTipoDocumento() throws BaseException {
		supportRefresh();
		return this.tipoDocumento;
	}

	public String getTipoDocuImpFiscal() throws BaseException {
		if (this.getTipoDocumento() != null)
			return this.getTipoDocumento().getTipoDocuParaImpFiscal();
		else
			throw new ExceptionValidation(null,
					"Falta definir el Tipo de Documento para impresora fiscal "
							+ "para el proveedor " + this.getCodigo() + "-"
							+ this.getRazonsocial());
	}

	public void setTipoDocumento(TipoDocumento aTipoDocumento) {
		this.tipoDocumento = aTipoDocumento;
	}

	public Boolean isDtoEnCascada() throws BaseException {
		supportRefresh();
		return this.dtoEnCascada;
	}

	public void setDtoEnCascada(Boolean aDtoEnCascada) {
		this.dtoEnCascada = aDtoEnCascada;
	}

	public ViaDespacho getViaDespacho() throws BaseException {
		supportRefresh();
		return this.viaDespacho;
	}

	public void setViaDespacho(ViaDespacho aViaDespacho) {
		this.viaDespacho = aViaDespacho;
	}

	public CondCompraImportacion getCondCompraImpo() throws BaseException {
		supportRefresh();
		return this.condCompraImpo;
	}

	public void setCondCompraImportacion(
			CondCompraImportacion aCondCompraImportacion) {
		this.condCompraImpo = aCondCompraImportacion;
	}

	public String getCodigo() throws BaseException {
		supportRefresh();
		return codigo;
	}

	public void setCodigo(String aCodigo) {
		this.codigo = aCodigo;
	}

	public String getTomarPrecioOC() throws BaseException {
		supportRefresh();
		return this.tomarPrecioOC;
	}

	public void setTomarPrecioOC(String aTomarPrecioOC) {
		this.tomarPrecioOC = aTomarPrecioOC;
	}

	public String getTomarPrecioOC1() throws BaseException {
		supportRefresh();
		return this.tomarPrecioOC1;
	}

	public void setTomarPrecioOC1(String aTomarPrecioOC) {
		this.tomarPrecioOC1 = aTomarPrecioOC;
	}

	public String getTomarPrecioOC2() throws BaseException {
		supportRefresh();
		return this.tomarPrecioOC2;
	}

	public void setTomarPrecioOC2(String aTomarPrecioOC) {
		this.tomarPrecioOC2 = aTomarPrecioOC;
	}

	public String getTomarPrecioOC3() throws BaseException {
		supportRefresh();
		return this.tomarPrecioOC3;
	}

	public void setTomarPrecioOC3(String aTomarPrecioOC) {
		this.tomarPrecioOC3 = aTomarPrecioOC;
	}

	public String getTomarPrecioOC4() throws BaseException {
		supportRefresh();
		return this.tomarPrecioOC4;
	}

	public void setTomarPrecioOC4(String aTomarPrecioOC) {
		this.tomarPrecioOC4 = aTomarPrecioOC;
	}

	public String getTomarPrecioOC5() throws BaseException {
		supportRefresh();
		return this.tomarPrecioOC5;
	}

	public void setTomarPrecioOC5(String aTomarPrecioOC) {
		this.tomarPrecioOC5 = aTomarPrecioOC;
	}

	public FormaPago getFormaPago() throws BaseException {
		supportRefresh();
		return formaPago;
	}

	public void setFormaPago(FormaPago aFormaPago) {
		this.formaPago = aFormaPago;
	}

	public String getRazonsocial() throws BaseException {
		supportRefresh();
		return razonSocial;
	}

	public void setRazonsocial(String aRazonsocial) {
		this.razonSocial = aRazonsocial;
	}

	public String getDireccion() throws BaseException {
		supportRefresh();
		return direccion;
	}

	public void setDireccion(String aDireccion) {
		this.direccion = aDireccion;
	}

	public String getLocalidad() throws BaseException {
		supportRefresh();
		return localidad;
	}

	public void setLocalidad(String aLocalidad) {
		this.localidad = aLocalidad;
	}

	public String getCodigopostal() throws BaseException {
		supportRefresh();
		return codigoPostal;
	}

	public void setCodigopostal(String aCodigopostal) {
		this.codigoPostal = aCodigopostal;
	}

	public Provincia getProvincia() throws BaseException {
		supportRefresh();
		return provincia;
	}

	public void setProvincia(Provincia aProvincia) {
		this.provincia = aProvincia;
	}

	public Boolean isHabitual() throws BaseException {
		supportRefresh();
		return habitual;
	}

	public void setHabitual(Boolean aHabitual) {
		this.habitual = aHabitual;
	}

	public String getOrdencheque() throws BaseException {
		supportRefresh();
		return ordencheque;
	}

	public void setOrdencheque(String aOrdencheque) {
		this.ordencheque = aOrdencheque;
	}

	public Boolean isEnvocmail() throws BaseException {
		supportRefresh();
		return envOCMail;
	}

	public void setEnvocmail(Boolean aEnvocmail) {
		this.envOCMail = aEnvocmail;
	}

	public Boolean isEncoccorreo() throws BaseException {
		supportRefresh();
		return encOCCorreo;
	}

	public void setEncoccorreo(Boolean aEncoccorreo) {
		this.encOCCorreo = aEncoccorreo;
	}

	public Boolean isEncocfax() throws BaseException {
		supportRefresh();
		return encOCFax;
	}

	public void setEncocfax(Boolean aEncocfax) {
		this.encOCFax = aEncocfax;
	}

	public CertificacionProveedor getCertprov() throws BaseException {
		supportRefresh();
		return certProv;
	}

	public void setCertprov(CertificacionProveedor aCertprov) {
		this.certProv = aCertprov;
	}

	public Moneda getMonedaoc() throws BaseException {
		supportRefresh();
		return monedaOC;
	}

	public void setMonedaoc(Moneda aMonedaoc) {
		this.monedaOC = aMonedaoc;
	}

	public Pais getPais() throws BaseException {
		supportRefresh();
		return pais;
	}

	public void setPais(Pais aPais) {
		this.pais = aPais;
	}

	public Idioma getIdioma() throws BaseException {
		supportRefresh();
		return idioma;
	}

	public void setIdioma(Idioma aIdioma) {
		this.idioma = aIdioma;
	}

	public SujetoImpositivo getSujetoimpositivo() throws BaseException {
		supportRefresh();
		return sujetoImpositivo;
	}

	public void setSujetoimpositivo(SujetoImpositivo aSujetoimpositivo) {
		this.sujetoImpositivo = aSujetoimpositivo;
	}

	public java.util.Date getFechainhabilitacion() throws BaseException {
		supportRefresh();
		return fechaInhabilitacion;
	}

	public void setFechainhabilitacion(java.util.Date aFechainhabilitacion) {
		this.fechaInhabilitacion = aFechainhabilitacion;
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

	public static Proveedor findByOid(Integer oid, ISesion aSesion)
			throws BaseException {
		return (Proveedor) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static Proveedor findByOidProxy(Integer oid, ISesion aSesion)
			throws BaseException {
		return (Proveedor) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}

	public static Proveedor findByCodigo(String codigo, ISesion aSesion)
			throws BaseException {
		return (Proveedor) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		
		
		if (this.isNew()) {
			if (generarCodigoAut==false)
				Validar.noNulo(codigo, "Debe ingresar el Código de Proveedor");
			else
				this.codigo = getNewCodAutoDeProveedor();
		}
		
		Validar.noNulo(codigo, "Debe ingresar el Código de Proveedor");
		
		Validar.noNulo(razonSocial,
				"Debe ingresar la Razón Social del Proveedor");
		Validar
				.noNulo(this.tipoDocumento,
						"Debe ingresar el Tipo de Documento");

		if (isNew() && (isActivo().booleanValue() == false))
			Validar
					.mensajeValidacion("El Proveedor debe ingresarse en modo activo");

		if (getSujetoimpositivo() != null) {
			getSujetoimpositivo().save();
		}
	}

	public void afterSave() throws BaseException {
		Iterator iterCondicionesCompra = condicionesCompra.iterator();
		while (iterCondicionesCompra.hasNext()) {
			CondCompraProv condCompraProv = (CondCompraProv) iterCondicionesCompra
					.next();
			condCompraProv.save();
			condCompraProv = null;
		}
		iterCondicionesCompra = null;

		Iterator iterContactos = contactosProveedor.iterator();
		while (iterContactos.hasNext()) {
			ContactoProveedor contactoProveedor = (ContactoProveedor) iterContactos
					.next();
			contactoProveedor.save();
			contactoProveedor = null;
		}
		iterContactos = null;

		Iterator iterOtrasDirecciones = otrasDirecciones.iterator();
		while (iterOtrasDirecciones.hasNext()) {
			OtrasDireccionesProveedor otraDireccionProveedor = (OtrasDireccionesProveedor) iterOtrasDirecciones
					.next();
			otraDireccionProveedor.save();
			otraDireccionProveedor = null;
		}
		iterOtrasDirecciones = null;

	}

	/**
	 * getDescripcion
	 * 
	 * @return String
	 */
	public String getDescripcion() throws BaseException {
		return getRazonsocial();
	}

	public List getCondicionesDeCompra() throws BaseException {
		if (readListaCondCompra) {
			List listaCondicionesDeCpmpra = CondCompraProv
					.getCondCompraByProveedor(this, getSesion());
			condicionesCompra.addAll(listaCondicionesDeCpmpra);
			readListaCondCompra = false;
		}
		return condicionesCompra;
	}

	public List getOtrasDirecciones() throws BaseException {
		if (this.readOtrasDirecciones) {
			List listaOtrasDirecciones = OtrasDireccionesProveedor
					.getOtrasDireccionesProveedor(this, getSesion());
			otrasDirecciones.addAll(listaOtrasDirecciones);
			readOtrasDirecciones = false;
		}
		return otrasDirecciones;
	}

	public void addCondicionCompra(CondCompraProv condCompraProv)
			throws BaseException {
		condCompraProv.setProveedor(this);
		condicionesCompra.add(condCompraProv);
	}
	
	public void setGenerarCodigoAutomatico(Boolean aGenerarCodigoAutomatico) throws BaseException {
		this.generarCodigoAut = aGenerarCodigoAutomatico;
	}

	public List getContactos() throws BaseException {
		if (readListaContactos) {
			List listaContactos = ContactoProveedor.getContactosByProveedor(
					this, getSesion());
			contactosProveedor.addAll(listaContactos);
			readListaContactos = false;
		}
		return contactosProveedor;
	}

	public void addContacto(ContactoProveedor contactoProveedor)
			throws BaseException {
		contactoProveedor.setProveedor(this);
		contactosProveedor.add(contactoProveedor);
	}

	public void addOtrasDirecciones(
			OtrasDireccionesProveedor otrasDireccionesProveedor)
			throws BaseException {
		otrasDireccionesProveedor.setProveedor(this);
		otrasDirecciones.add(otrasDireccionesProveedor);
	}

	public List getCondCompraByProveedor() throws BaseException {
		return CondCompraProv.getCondCompraByProveedor(this, getSesion());
	}

	public static List getHelpProveedores(HashTableDatos condiciones,
			ISesion aSesion) throws BaseException {

		return DBProveedor.getHelpProveedores(condiciones, aSesion);
	}

	private Hashtable listaOidValClasif = new Hashtable();

	public void addOidValorClasif(Integer nroClasif, Integer aValor) {
		if (aValor == null)
			listaOidValClasif.put(nroClasif, new Integer(0));
		else
			listaOidValClasif.put(nroClasif, aValor);
	}

	public Integer getOidValorClasif(Integer nroClasif) throws BaseException {
		supportRefresh();
		Integer oidValorClasif = (Integer) listaOidValClasif.get(nroClasif);
		if (oidValorClasif != null)
			return (Integer) listaOidValClasif.get(nroClasif);
		else
			return new Integer(0);
	}

	public ValorClasificadorEntidad getValorClasifEnt(
			ClasificadorEntidad clasifEnt) throws BaseException {
		ValorClasificadorEntidad valClasifEnt = null;
		Integer oidValClasifEnt = (Integer) listaOidValClasif.get(clasifEnt
				.getNroClasif());
		if (oidValClasifEnt != null)
			valClasifEnt = ValorClasificadorEntidad.findByOid(oidValClasifEnt,
					getSesion());
		return valClasifEnt;
	}

	public List getClasificadoresEntidad() throws BaseException {
		return ClasificadorEntidad.getClasificadoresEntidad(Proveedor.NICKNAME,
				true, getSesion());
	}

	public static List getClasificadoresEntidad(ISesion aSesion)
			throws BaseException {
		return ClasificadorEntidad.getClasificadoresEntidad(Proveedor.NICKNAME,
				true, aSesion);
	}

	public CondCompraProv getCondPagoDefaultProv() throws BaseException {
		Iterator iterCondPago = this.getCondicionesDeCompra().iterator();
		while (iterCondPago.hasNext()) {
			CondCompraProv condPagoProv = (CondCompraProv) iterCondPago.next();

			if ((condPagoProv.isActivo().booleanValue())
					&& (condPagoProv.isPorDefecto().booleanValue()))
				return condPagoProv;
		}
		return null;
	}

	public boolean isCondPagoAsignada(CondicionCompra condPago)
			throws BaseException {
		Iterator iterCondPago = this.getCondicionesDeCompra().iterator();
		while (iterCondPago.hasNext()) {
			CondCompraProv condPagoProv = (CondCompraProv) iterCondPago.next();

			if ((condPagoProv.isActivo().booleanValue())
					&& (condPagoProv.getCondcompra().getOID() == condPago
							.getOID()))
				return true;
		}
		return false;
	}

	public InformeRecepcion getInformeRecepcion(String nroRtoProvedor)
			throws BaseException {
		return InformeRecepcion.getInformeRecepcion(nroRtoProvedor, this, this
				.getSesion());
	}

	public String getDireccionCompleta() throws BaseException {

		StringBuffer dir = new StringBuffer();
		if (this.getDireccion() != null) {
			if (!this.getDireccion().equals("."))
				dir.append(this.getDireccion());
		}

		if ((this.getLocalidad() != null) && !(this.getLocalidad().equals("."))) {

			if ((this.getLocalidad() != null)
					&& (this.getLocalidad().length() > 0)) {
				if ((dir.toString().trim().length() != 0))
					dir.append(", ");
			}

			dir.append(this.getLocalidad());

		}

		if ((this.getCodigo() != null) && (!this.getCodigo().equals("."))) {

			if ((this.getCodigo() != null) && (this.getCodigo().length() > 0)) {
				if ((dir.toString().trim().length() != 0))
					dir.append(" ");
			}

			if ((this.getCodigo() != null) && (this.getCodigo().length() > 0))
				dir.append("(" + this.getCodigo() + ")");

		}
		if (this.getProvincia() != null) {
			if ((dir.toString().trim().length() != 0))
				dir.append(", ");
			dir.append(this.getProvincia().getDescripcion());
		}
		if (this.getPais() != null) {
			if ((dir.toString().trim().length() != 0))
				dir.append(", ");

			dir.append(this.getPais().getDescripcion());
		}

		return dir.toString();
	}

	public String getNroDocuImpFiscal() throws BaseException {
		if (this.getTipoDocumento().isCUIT()
				|| this.getTipoDocumento().isCUIL()) {
			if (this.getSujetoimpositivo() == null)
				throw new ExceptionValidation(null,
						"Falta definir el sujeto impositivo para "
								+ this.getCodigo() + " - "
								+ this.getDescripcion());
			return this.getSujetoimpositivo().getCuit();
		} else
			return "";
	}
	
	public String getNewCodAutoDeProveedor() throws BaseException {
		int nroPropuesto = this.getSesion().getNewOIDByKey("COD_AUT_PROV");
		StringBuffer ceros = new StringBuffer("");
		
		Integer nroBase = ValorParametro.findByCodigoParametro(
				"NRO_BASE_GEN_AUT_COD_PROV", this.getSesion()).getValorEntero();
		int nuevoNro = 0;
		
		Integer cantDigitos = ValorParametro.findByCodigoParametro(
				"CANT_DIG_NRO_AUT_PROV", this.getSesion()).getValorEntero();
		
		for(int i=1;i<=cantDigitos;++i) 
			ceros.append("0");
				
		nuevoNro = nroPropuesto + nroBase.intValue();
		NumberFormat formatNroCodProv = new DecimalFormat(ceros.toString());
		String codigoProveedor = formatNroCodProv.format(nuevoNro);
		
		// Verificar que el codigo de Proveedor no exista
		Proveedor proveedor = Proveedor.findByCodigo(codigoProveedor, this.getSesion());
		if (proveedor != null)
			throw new ExceptionValidation(null,"El código de proveedor a genrar es "+codigoProveedor+" el mismo corresponde a un proveedor existente.");
		
		return codigoProveedor;

	}

}
