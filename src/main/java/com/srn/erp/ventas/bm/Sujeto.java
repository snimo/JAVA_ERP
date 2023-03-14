package com.srn.erp.ventas.bm;

import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.general.bm.ClasificadorEntidad;
import com.srn.erp.general.bm.IEntidadClasificable;
import com.srn.erp.general.bm.Idioma;
import com.srn.erp.general.bm.Moneda;
import com.srn.erp.general.bm.Pais;
import com.srn.erp.general.bm.Provincia;
import com.srn.erp.general.bm.ValorClasificadorEntidad;
import com.srn.erp.impuestos.bm.LiberacionImpuestoSujeto;
import com.srn.erp.impuestos.bm.SujetoImpositivo;
import com.srn.erp.stock.bm.Transporte;
import com.srn.erp.tesoreria.bm.CuentaBancaria;
import com.srn.erp.tesoreria.bm.TarjetaCredito;
import com.srn.erp.turnos.bm.CategoriaSujetoTurno;
import com.srn.erp.turnos.bm.RelacionSujetoTurno;
import com.srn.erp.turnos.bm.TableroTurnos;
import com.srn.erp.turnos.da.DBRelaConcSujTur;
import com.srn.erp.ventas.da.DBSujeto;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bm.Parametros.ValorParametro;
import framework.applicarionServer.bm.Varios.Money;
import framework.applicarionServer.bm.Varios.Porcentaje;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.ObjetoObservado;
import framework.request.bl.Utils.Validar;

public class Sujeto extends ObjetoLogico implements IEntidadClasificable {

	public Sujeto() {
	}

	public static String NICKNAME = "ve.Sujeto";

	private String codigo;
	private String razon_social;
	private TipoDocumento tipo_documento;
	private String nro_documento;
	private String sexo;
	private java.util.Date fecha_nacimiento;
	private java.util.Date fecha_ingreso;
	private String e_mail;
	private String nacionalidad;
	private String telefonos;
	private SujetoImpositivo sujeto_impositivo;
	private String fax;
	private String sector_empresa;
	private String cargo;
	private Vendedor vendedor_tecnico;
	private Vendedor vendedor_comercial;
	private String web;
	private EstadoSituacion estado_situacion;
	private com.srn.erp.general.bm.Zona zonaDireccion;
	private java.util.Date fec_est_situ_desde;
	private java.util.Date fec_est_situ_hasta;
	private String fisica_juridica;
	private String profesion;
	private Boolean es_cliente;
	private Boolean es_socio;
	private Boolean es_prospecto;
	private Boolean es_contacto;
	private String nroTarjeta;
	private String direccion_web;
	private Cobrador cobrador;
	private Rubro rubro;
	private EstadoCivil estado_civil;
	private String contacto;
	private String calle_y_nro;
	private SectorDireccion sector_domilicio;
	private String localidad;
	private String codigo_postal;
	private Provincia provincia;
	private Pais pais;
	private Boolean domicilio_entrega;
	private Zona zona_venta;
	private Canal canal;
	private ClasifSujeto clasificacionSujeto;
	private CuentaBancaria cuenta_bancaria;
	private TarjetaCredito tarjeta_credito;
	private String nro_medio_pago;
	private Integer responsable_ctacte;
	private String modalidad_pago;
	private Boolean permite_otras_modalidades_pago;
	private String sub_modalidad_pago;
	private CondicionPago condicionPago;
	private Boolean activo;
	private Boolean bonifEnCascada;
	private Transporte transporte;
	private Moneda monedaCotizacion;
	private Moneda monedaPedido;
	private Moneda monedaFactura;
	private Idioma idioma;
	private Boolean habilitarLimiteCredito;
	private Money montoLimiteCredito;
	private Moneda monedaLimiteCredito;
	private boolean esSusPercIBBsAs;
	private boolean esSusPercIBCapFed;
	private boolean esSusPercIVA;
	private boolean esDomicilioCobranza;
	private String reclamarPagos;
	private String pasarACobrar;
	private CategoriaSujetoTurno categoriaSujetoTurno;
	private RelacionSujetoTurno relacionSujetoTurno;
	private boolean suspendidoParaTurno;
	private Date fecSuspendidoDesde;
	private Date fecSuspendidoHasta;
	private String motivoTurnoSuspension;
	private String tipoImpresionFact;

	private boolean deshabilitarCodigoAutomatico;

	public boolean isDeshabilitarCodigoAutomatico() {
		return deshabilitarCodigoAutomatico;
	}

	public void setDeshabilitarCodigoAutomatico(boolean deshabilitarCodigoAutomatico) {
		this.deshabilitarCodigoAutomatico = deshabilitarCodigoAutomatico;
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
		return (Integer) listaOidValClasif.get(nroClasif);
	}

	public ValorClasificadorEntidad getValorClasifEnt(ClasificadorEntidad clasifEnt) throws BaseException {
		ValorClasificadorEntidad valClasifEnt = null;
		Integer oidValClasifEnt = (Integer) listaOidValClasif.get(clasifEnt.getNroClasif());
		if (oidValClasifEnt != null)
			valClasifEnt = ValorClasificadorEntidad.findByOid(oidValClasifEnt, getSesion());
		return valClasifEnt;
	}

	private List unidadesEdilicias = new ArrayList();
	private boolean readUnidadesEdicilias = true;

	private List contactos = new ArrayList();
	private boolean readContactos = true;

	private List bonifRecar = new ArrayList();
	private boolean readBonifRecar = true;

	private List listasDePrecios = new ArrayList();
	private boolean readListaDePrecios = true;

	private List liberacionesImpuestos = new ArrayList();
	private boolean readLiberacionesImpuestos = true;

	private List listasEsqBonifSuj = new ArrayList();
	private boolean readListasEsqBonifSuj = true;

	public Boolean isBonifEnCascada() throws BaseException {
		supportRefresh();
		return bonifEnCascada;
	}

	public void setBonifEnCascada(Boolean aBonifEnCascada) throws BaseException {
		this.bonifEnCascada = aBonifEnCascada;
	}
	
	public void setTipoImpresionFact(String aTipoImpresionFact) throws BaseException {
		this.tipoImpresionFact = aTipoImpresionFact;
	}

	public CondicionPago getCondicionPago() throws BaseException {
		supportRefresh();
		return condicionPago;
	}
	
	public String getTipoImpresionFact() throws BaseException {
		supportRefresh();
		return this.tipoImpresionFact;
	}
	
	public void setNroTarjeta(String aNroTarjeta) throws BaseException {
		this.nroTarjeta = aNroTarjeta;
	}

	public String getNroTarjeta() throws BaseException {
		supportRefresh();
		return this.nroTarjeta;
	}
	

	public void setCondicionPago(CondicionPago aCondicionPago) throws BaseException {
		this.condicionPago = aCondicionPago;
	}

	public String getMotivoTurnoSuspension() throws BaseException {
		supportRefresh();
		if (this.motivoTurnoSuspension == null)
			this.motivoTurnoSuspension = "";
		return this.motivoTurnoSuspension;
	}

	public void setMotivoTurnoSuspension(String aMotivoTurnoSuspension) throws BaseException {
		this.motivoTurnoSuspension = aMotivoTurnoSuspension;
	}

	public CategoriaSujetoTurno getCategoriaSujetoTurno() throws BaseException {
		supportRefresh();
		return this.categoriaSujetoTurno;
	}

	public void setCategoriaSujetoTurno(CategoriaSujetoTurno aCategoriaSujetoTurno) throws BaseException {
		this.categoriaSujetoTurno = aCategoriaSujetoTurno;
	}

	public RelacionSujetoTurno getRelacionSujetoTurno() throws BaseException {
		supportRefresh();
		return this.relacionSujetoTurno;
	}

	public void setRelacionSujetoTurno(RelacionSujetoTurno aRelacionSujetoTurno) throws BaseException {
		this.relacionSujetoTurno = aRelacionSujetoTurno;
	}

	public boolean isSuspendidoParaTurno() throws BaseException {
		supportRefresh();
		return this.suspendidoParaTurno;
	}

	public void setSuspendidoParaTurno(boolean aSuspendidoParaTurno) throws BaseException {
		this.suspendidoParaTurno = aSuspendidoParaTurno;
	}

	public java.util.Date getFecSuspendidoDesde() throws BaseException {
		supportRefresh();
		return this.fecSuspendidoDesde;
	}

	public void setFecSuspendidoDesde(java.util.Date aFecSuspendidoDesde) throws BaseException {
		this.fecSuspendidoDesde = aFecSuspendidoDesde;
	}

	public java.util.Date getFecSuspendidoHasta() throws BaseException {
		supportRefresh();
		return this.fecSuspendidoHasta;
	}

	public void setFecSuspendidoHasta(java.util.Date aFecSuspendidoHasta) throws BaseException {
		this.fecSuspendidoHasta = aFecSuspendidoHasta;
	}

	public boolean isSusceptiblePercIVA() throws BaseException {
		supportRefresh();
		return this.esSusPercIVA;
	}

	public void setEsSusceptiblePercIVA(boolean aEsSusceptiblePercIVA) throws BaseException {
		this.esSusPercIVA = aEsSusceptiblePercIVA;
	}

	public boolean isSusceptiblePercIBBsAs() throws BaseException {
		supportRefresh();
		return this.esSusPercIBBsAs;
	}

	public void setSusceptiblePercIBBsAs(boolean esSusceptiblePercIBBsAs) throws BaseException {
		this.esSusPercIBBsAs = esSusceptiblePercIBBsAs;
	}

	public boolean isSusceptiblePercIBCapFed() throws BaseException {
		supportRefresh();
		return this.esSusPercIBCapFed;
	}

	public void setSusceptiblePercIBCapFed(boolean esSusceptiblePercCapFed) throws BaseException {
		this.esSusPercIBCapFed = esSusceptiblePercCapFed;
	}

	public Boolean isHabilitarLimiteCredito() throws BaseException {
		supportRefresh();
		return this.habilitarLimiteCredito;
	}

	public void setHabilitarLimiteCredito(Boolean aHabilitarLimiteCredito) throws BaseException {
		this.habilitarLimiteCredito = aHabilitarLimiteCredito;
	}

	public Money getMontoLimiteCredito() throws BaseException {
		supportRefresh();
		return this.montoLimiteCredito;
	}

	public void setMontoLimiteCredito(Money aMontoLimiteCredito) throws BaseException {
		this.montoLimiteCredito = aMontoLimiteCredito;
	}

	public Boolean isDomicilioCobraza() throws BaseException {
		supportRefresh();
		return this.esDomicilioCobranza;
	}

	public void setIsDomicilioCobranza(Boolean aEsDomicilioCobranza) throws BaseException {
		this.esDomicilioCobranza = aEsDomicilioCobranza;
	}

	public String getReclamarPagos() throws BaseException {
		supportRefresh();
		return this.reclamarPagos;
	}

	public void setReclamarPagos(String aReclamarPagos) throws BaseException {
		this.reclamarPagos = aReclamarPagos;
	}

	public String getPasarACobrar() throws BaseException {
		supportRefresh();
		return this.pasarACobrar;
	}

	public void setPasarACobrar(String aPasarACobrar) throws BaseException {
		this.pasarACobrar = aPasarACobrar;
	}

	public Moneda getMonedaLimiteCredito() throws BaseException {
		supportRefresh();
		return this.monedaLimiteCredito;
	}

	public void setMonedaLimiteCredito(Moneda aMonedaLimiteCredito) throws BaseException {
		this.monedaLimiteCredito = aMonedaLimiteCredito;
	}

	public Idioma getIdioma() throws BaseException {
		supportRefresh();
		return this.idioma;
	}

	public void setIdioma(Idioma aIdioma) throws BaseException {
		this.idioma = aIdioma;
	}

	public Moneda getMonedaCotizacion() throws BaseException {
		supportRefresh();
		return this.monedaCotizacion;
	}

	public void setMonedaCotizacion(Moneda aMonedaCotizacion) throws BaseException {
		this.monedaCotizacion = aMonedaCotizacion;
	}

	public Moneda getMonedaPedido() throws BaseException {
		supportRefresh();
		return this.monedaPedido;
	}

	public void setMonedaPedido(Moneda aMonedaPedido) throws BaseException {
		this.monedaPedido = aMonedaPedido;
	}

	public Moneda getMonedaFactura() throws BaseException {
		supportRefresh();
		return this.monedaFactura;
	}

	public void setMonedaFactura(Moneda aMonedaFactura) throws BaseException {
		this.monedaFactura = aMonedaFactura;
	}

	public String getCodigo() throws BaseException {
		supportRefresh();
		return codigo;
	}

	public void setCodigo(String aCodigo) {
		this.codigo = aCodigo;
	}

	public String getRazon_social() throws BaseException {
		supportRefresh();
		return razon_social;
	}

	public String getRazon_social_search() throws BaseException {
		supportRefresh();
		if (razon_social != null)
			return razon_social.toUpperCase();
		else
			return null;
	}

	public void setRazon_social(String aRazon_social) {
		this.razon_social = aRazon_social;
	}

	public TipoDocumento getTipo_documento() throws BaseException {
		supportRefresh();
		return tipo_documento;
	}

	public void setTipo_documento(TipoDocumento aTipo_documento) {
		this.tipo_documento = aTipo_documento;
	}

	public String getNro_documento() throws BaseException {
		supportRefresh();
		return nro_documento;
	}

	public void setNro_documento(String aNro_documento) {
		this.nro_documento = aNro_documento;
	}

	public Transporte getTransporte() throws BaseException {
		supportRefresh();
		return this.transporte;
	}

	public void setTransporte(Transporte aTransporte) {
		this.transporte = aTransporte;
	}

	public String getSexo() throws BaseException {
		supportRefresh();
		return sexo;
	}

	public void setSexo(String aSexo) {
		this.sexo = aSexo;
	}

	public java.util.Date getFecha_nacimiento() throws BaseException {
		supportRefresh();
		return fecha_nacimiento;
	}

	public void setFecha_nacimiento(java.util.Date aFecha_nacimiento) {
		this.fecha_nacimiento = aFecha_nacimiento;
	}

	public java.util.Date getFecha_ingreso() throws BaseException {
		supportRefresh();
		return fecha_ingreso;
	}

	public void setFecha_ingreso(java.util.Date aFecha_ingreso) {
		this.fecha_ingreso = aFecha_ingreso;
	}

	public String getE_mail() throws BaseException {
		supportRefresh();
		return e_mail;
	}

	public void setE_mail(String aE_mail) {
		this.e_mail = aE_mail;
	}

	public String getNacionalidad() throws BaseException {
		supportRefresh();
		return nacionalidad;
	}

	public void setNacionalidad(String aNacionalidad) {
		this.nacionalidad = aNacionalidad;
	}

	public String getTelefonos() throws BaseException {
		supportRefresh();
		return telefonos;
	}

	public void setTelefonos(String aTelefonos) {
		this.telefonos = aTelefonos;
	}

	public SujetoImpositivo getSujeto_impositivo() throws BaseException {
		supportRefresh();
		return sujeto_impositivo;
	}

	public void setSujeto_impositivo(SujetoImpositivo aSujeto_impositivo) {
		this.sujeto_impositivo = aSujeto_impositivo;
	}

	public String getFax() throws BaseException {
		supportRefresh();
		return fax;
	}

	public void setFax(String aFax) {
		this.fax = aFax;
	}

	public String getSector_empresa() throws BaseException {
		supportRefresh();
		return sector_empresa;
	}

	public void setSector_empresa(String aSector_empresa) {
		this.sector_empresa = aSector_empresa;
	}

	public String getCargo() throws BaseException {
		supportRefresh();
		return cargo;
	}

	public void setCargo(String aCargo) {
		this.cargo = aCargo;
	}

	public Vendedor getVendedor_tecnico() throws BaseException {
		supportRefresh();
		return vendedor_tecnico;
	}

	public void setVendedor_tecnico(Vendedor aVendedor_tecnico) {
		this.vendedor_tecnico = aVendedor_tecnico;
	}

	public Vendedor getVendedor_comercial() throws BaseException {
		supportRefresh();
		return vendedor_comercial;
	}

	public void setVendedor_comercial(Vendedor aVendedor_comercial) {
		this.vendedor_comercial = aVendedor_comercial;
	}

	public String getWeb() throws BaseException {
		supportRefresh();
		return web;
	}

	public void setWeb(String aWeb) {
		this.web = aWeb;
	}

	public EstadoSituacion getEstado_situacion() throws BaseException {
		supportRefresh();
		return estado_situacion;
	}

	public void setEstado_situacion(EstadoSituacion aEstado_situacion) {
		this.estado_situacion = aEstado_situacion;
	}

	public com.srn.erp.general.bm.Zona getZonadireccion() throws BaseException {
		supportRefresh();
		return zonaDireccion;
	}

	public void setZonadireccion(com.srn.erp.general.bm.Zona aZonadireccion) {
		this.zonaDireccion = aZonadireccion;
	}

	public java.util.Date getFec_est_situ_desde() throws BaseException {
		supportRefresh();
		return fec_est_situ_desde;
	}

	public void setFec_est_situ_desde(java.util.Date aFec_est_situ_desde) {
		this.fec_est_situ_desde = aFec_est_situ_desde;
	}

	public java.util.Date getFec_est_situ_hasta() throws BaseException {
		supportRefresh();
		return fec_est_situ_hasta;
	}

	public void setFec_est_situ_hasta(java.util.Date aFec_est_situ_hasta) {
		this.fec_est_situ_hasta = aFec_est_situ_hasta;
	}

	public String getFisica_juridica() throws BaseException {
		supportRefresh();
		return fisica_juridica;
	}

	public void setFisica_juridica(String aFisica_juridica) {
		this.fisica_juridica = aFisica_juridica;
	}

	public String getProfesion() throws BaseException {
		supportRefresh();
		return profesion;
	}

	public void setProfesion(String aProfesion) {
		this.profesion = aProfesion;
	}

	public Boolean isEs_cliente() throws BaseException {
		supportRefresh();
		return es_cliente;
	}

	public void setEs_cliente(Boolean aEs_cliente) {
		this.es_cliente = aEs_cliente;
	}

	public Boolean isEs_prospecto() throws BaseException {
		supportRefresh();
		return es_prospecto;
	}

	public void setEs_prospecto(Boolean aEs_prospecto) {
		this.es_prospecto = aEs_prospecto;
	}

	public Boolean isEs_contacto() throws BaseException {
		supportRefresh();
		return es_contacto;
	}

	public void setEs_contacto(Boolean aEs_contacto) {
		this.es_contacto = aEs_contacto;
	}

	public Boolean isEs_socio() throws BaseException {
		supportRefresh();
		return es_socio;
	}

	public void setEs_socio(Boolean aEs_socio) {
		this.es_socio = aEs_socio;
	}

	public String getDireccion_web() throws BaseException {
		supportRefresh();
		return direccion_web;
	}

	public void setDireccion_web(String aDireccion_web) {
		this.direccion_web = aDireccion_web;
	}

	public Cobrador getCobrador() throws BaseException {
		supportRefresh();
		return cobrador;
	}

	public void setCobrador(Cobrador aCobrador) {
		this.cobrador = aCobrador;
	}

	public Rubro getRubro() throws BaseException {
		supportRefresh();
		return rubro;
	}

	public void setRubro(Rubro aRubro) {
		this.rubro = aRubro;
	}

	public EstadoCivil getEstado_civil() throws BaseException {
		supportRefresh();
		return estado_civil;
	}

	public void setEstado_civil(EstadoCivil aEstado_civil) {
		this.estado_civil = aEstado_civil;
	}

	public String getContacto() throws BaseException {
		supportRefresh();
		return contacto;
	}

	public void setContacto(String aContacto) {
		this.contacto = aContacto;
	}

	public String getCalle_y_nro() throws BaseException {
		supportRefresh();
		return calle_y_nro;
	}

	public void setCalle_y_nro(String aCalle_y_nro) {
		this.calle_y_nro = aCalle_y_nro;
	}

	public SectorDireccion getSector_domilicio() throws BaseException {
		supportRefresh();
		return sector_domilicio;
	}

	public void setSector_domilicio(SectorDireccion aSector_domilicio) {
		this.sector_domilicio = aSector_domilicio;
	}

	public String getLocalidad() throws BaseException {
		supportRefresh();
		return localidad;
	}

	public String getLocalidadyCP() throws BaseException {
		StringBuffer locyCP = new StringBuffer();
		if (this.getLocalidad() != null)
			locyCP.append(this.getLocalidad() + " ");
		if (this.getCodigo_postal() != null)
			locyCP.append("(" + this.getCodigo_postal() + ")");
		return locyCP.toString();

	}

	public String getProvinciayPais() throws BaseException {
		StringBuffer provinciayPais = new StringBuffer();
		if (this.getProvincia() != null)
			provinciayPais.append(this.getProvincia().getDescripcion());
		if (this.getPais() != null) {
			if (provinciayPais.length() > 0)
				provinciayPais.append(", ");
			provinciayPais.append(this.getPais().getDescripcion());
		}
		return provinciayPais.toString();
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

	public Boolean isDomicilio_entrega() throws BaseException {
		supportRefresh();
		return domicilio_entrega;
	}

	public void setDomicilio_entrega(Boolean aDomicilio_entrega) {
		this.domicilio_entrega = aDomicilio_entrega;
	}

	public Zona getZona_venta() throws BaseException {
		supportRefresh();
		return zona_venta;
	}

	public void setZona_venta(Zona aZona_venta) {
		this.zona_venta = aZona_venta;
	}

	public Canal getCanal() throws BaseException {
		supportRefresh();
		return canal;
	}

	public void setCanal(Canal aCanal) {
		this.canal = aCanal;
	}

	public ClasifSujeto getClasificacionsujeto() throws BaseException {
		supportRefresh();
		return clasificacionSujeto;
	}

	public void setClasificacionsujeto(ClasifSujeto aClasificacionsujeto) {
		this.clasificacionSujeto = aClasificacionsujeto;
	}

	public CuentaBancaria getCuenta_bancaria() throws BaseException {
		supportRefresh();
		return cuenta_bancaria;
	}

	public void setCuenta_bancaria(CuentaBancaria aCuenta_bancaria) {
		this.cuenta_bancaria = aCuenta_bancaria;
	}

	public TarjetaCredito getTarjeta_credito() throws BaseException {
		supportRefresh();
		return tarjeta_credito;
	}

	public void setTarjeta_credito(TarjetaCredito aTarjeta_credito) {
		this.tarjeta_credito = aTarjeta_credito;
	}

	public String getNro_medio_pago() throws BaseException {
		supportRefresh();
		return nro_medio_pago;
	}

	public void setNro_medio_pago(String aNro_medio_pago) {
		this.nro_medio_pago = aNro_medio_pago;
	}

	public Integer getResponsable_ctacte() throws BaseException {
		supportRefresh();
		return responsable_ctacte;
	}

	public void setResponsable_ctacte(Integer aResponsable_ctacte) {
		this.responsable_ctacte = aResponsable_ctacte;
	}

	public String getModalidad_pago() throws BaseException {
		supportRefresh();
		return modalidad_pago;
	}

	public void setModalidad_pago(String aModalidad_pago) {
		this.modalidad_pago = aModalidad_pago;
	}

	public Boolean isPermite_otras_modalidades_pago() throws BaseException {
		supportRefresh();
		return permite_otras_modalidades_pago;
	}

	public void setPermite_otras_modalidades_pago(Boolean aPermite_otras_modalidades_pago) {
		this.permite_otras_modalidades_pago = aPermite_otras_modalidades_pago;
	}

	public String getSub_modalidad_pago() throws BaseException {
		supportRefresh();
		return sub_modalidad_pago;
	}

	public void setSub_modalidad_pago(String aSub_modalidad_pago) {
		this.sub_modalidad_pago = aSub_modalidad_pago;
	}

	public String getNickName() {
		return NICKNAME;
	}

	public static Sujeto findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (Sujeto) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static Sujeto findByOidProxy(Integer oid, ISesion aSesion) throws BaseException {
		return (Sujeto) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}

	public static Sujeto findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (Sujeto) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {

		boolean generarCodigoAut = Sujeto.isGenerarCodigoAutomaticamente(this.getSesion());

		if (generarCodigoAut == false)
			Validar.noNulo(codigo, "Debe ingresar el código");

		Validar.noNulo(razon_social, "Debe ingresar la Razón Social");
		Validar.noNulo(fisica_juridica, "Debe ingresar si es una persona física o jurídica");
		Validar.noNulo(this.tipo_documento, "Debe ingresar un Tipo de Documento");

		if (!this.getTipo_documento().isCUIT()) {
			if ((this.getNro_documento() == null) || this.getNro_documento().trim().equals(""))
				this.setNro_documento(new Integer(Sujeto.getNroDocuDefaultCF(this.getSesion())).toString());
		}

		if (!(isDeshabilitarCodigoAutomatico() == true))
			if (generarCodigoAut && (this.isNew()))
				this.setCodigo(getGenerarCodigo());

		if (this.getTipo_documento() != null)
			if (!this.getTipo_documento().isCUIT())
				if ((this.getNro_documento() == null) || (this.getNro_documento().trim().equals("")))
					throw new ExceptionValidation(null, "Debe ingresar un número de Documento");

		if (getSujeto_impositivo() != null) {

			// Verificar que si el tipo de Documento es CUIT la Categoria de IVA
			// sea una que requiera CUIT
			if (this.getTipo_documento().isCUIT())
				if (getSujeto_impositivo().getCategiva() != null)
					if (getSujeto_impositivo().getCategiva().isRequiereCUIT() == false)
						throw new ExceptionValidation(null, "La categoría de IVA ingresada no es compatible con el tipo de documento CUIT");

			// Si el tipo de Documento no es CUIT , que no utilice una categoria
			// que no requiera CUIT
			if (!this.getTipo_documento().isCUIT())
				if (this.getSujeto_impositivo().getCategiva() != null)
					if (this.getSujeto_impositivo().getCategiva().isRequiereCUIT())
						throw new ExceptionValidation(null,
								"La categoría de IVA ingresada requiere que el tipo de documento ingresado sea CUIT");

			getSujeto_impositivo().save();
		}

		Iterator iterClasifAct = this.getClasificadoresEntidadActivos().iterator();
		while (iterClasifAct.hasNext()) {
			ClasificadorEntidad clasif = (ClasificadorEntidad) iterClasifAct.next();
			if (clasif.isObligatorio()) {

				if (this.getValorClasifEnt(clasif) == null) {

					ValorClasificadorEntidad valorClasif = clasif.getValorDfault();

					if (valorClasif == null)
						throw new ExceptionValidation(null, "Debe ingresar el valor del clasificador " + clasif.getDescripcion()
								+ " del Ciente " + this.getCodigo() + " - " + this.getDescripcion());
					else
						addOidValorClasif(clasif.getNroClasif(), valorClasif.getOIDInteger());
				}
			}
		}

	}

	public static int getNroDocuDefaultCF(ISesion aSesion) throws BaseException {
		return ValorParametro.findByCodigoParametro("NRO_DOC_DEF_CLIE_CF", aSesion).getValorEntero().intValue();
	}

	public String getGenerarCodigo() throws BaseException {
		return DBSujeto.getProxCodCliente(this.getSesion());
	}

	/**
	 * isActivo
	 * 
	 * @return Boolean
	 */
	public Boolean isActivo() throws BaseException {
		supportRefresh();
		return activo;
	}

	public void setActivo(Boolean aActivo) {
		this.activo = aActivo;
	}

	/**
	 * getDescripcion
	 * 
	 * @return String
	 */
	public String getDescripcion() throws BaseException {
		supportRefresh();
		return getRazon_social();
	}

	public List getUnidadesEdilicias() throws BaseException {
		if (readUnidadesEdicilias) {
			List listaUnidadesEdilicias = UnidadEdilicia.getUnidadesEdilicias(this, getSesion());
			unidadesEdilicias.addAll(listaUnidadesEdilicias);
			readUnidadesEdicilias = false;
		}
		return unidadesEdilicias;
	}

	public List getListasDePrecios() throws BaseException {
		if (readListaDePrecios) {
			List lista = ListaPrecioSujeto.getListaPreciosBySujeto(this, getSesion());
			listasDePrecios.addAll(lista);
			readListaDePrecios = false;
		}
		return listasDePrecios;
	}

	public List getLiberacionesImpuestos() throws BaseException {
		if (this.readLiberacionesImpuestos) {
			List lista = LiberacionImpuestoSujeto.getLiberacionesSujeto(this, getSesion());
			liberacionesImpuestos.addAll(lista);
			this.readLiberacionesImpuestos = false;
		}
		return liberacionesImpuestos;
	}

	public List getListasBonifVigSuj() throws BaseException {
		if (readListasEsqBonifSuj) {
			List lista = EsquemaBonificacionVigSuj.getEsquemasBonifVigSuj(this, getSesion());
			listasEsqBonifSuj.addAll(lista);
			readListasEsqBonifSuj = false;
		}
		return listasEsqBonifSuj;
	}

	public List getContactos() throws BaseException {
		if (readContactos) {
			List listaContactos = ContactoSujeto.getContactos(this, getSesion());
			contactos.addAll(listaContactos);
			readContactos = false;
		}
		return contactos;
	}

	public List getBonifRecar() throws BaseException {
		if (readBonifRecar) {
			List listaBonifRecar = BonifRecarSujeto.getBonifRecar(this, getSesion());
			bonifRecar.addAll(listaBonifRecar);
			readBonifRecar = false;
		}
		return bonifRecar;
	}

	public void addUnidadEdilicia(UnidadEdilicia unidadEdilicia) throws BaseException {
		unidadEdilicia.setSujeto_alta(this);
		unidadesEdilicias.add(unidadEdilicia);
	}

	public void addLiberacionImpuesto(LiberacionImpuestoSujeto aLiberacionImpuestoSujeto) throws BaseException {
		aLiberacionImpuestoSujeto.setSujeto(this);
		liberacionesImpuestos.add(aLiberacionImpuestoSujeto);
	}

	public void addContacto(ContactoSujeto aContacto) throws BaseException {
		aContacto.setSujeto(this);
		contactos.add(aContacto);
	}

	public void addBonifRecar(BonifRecarSujeto aBonifRecarSujeto) throws BaseException {
		aBonifRecarSujeto.setSujeto(this);
		bonifRecar.add(aBonifRecarSujeto);
	}

	public void addListaPrecioSujeto(ListaPrecioSujeto aListaPrecioSujeto) throws BaseException {
		aListaPrecioSujeto.setSujeto(this);
		listasDePrecios.add(aListaPrecioSujeto);
	}

	public void addEsquemaBonifVigSuj(EsquemaBonificacionVigSuj aEsquemaBonifVigSuj) throws BaseException {
		aEsquemaBonifVigSuj.setSujeto(this);
		listasEsqBonifSuj.add(aEsquemaBonifVigSuj);
	}

	public void afterSave() throws BaseException {

		Iterator iterUnidadesEdilicias = unidadesEdilicias.iterator();
		while (iterUnidadesEdilicias.hasNext()) {
			UnidadEdilicia unidadEdilicia = (UnidadEdilicia) iterUnidadesEdilicias.next();
			unidadEdilicia.save();
			unidadEdilicia = null;
		}
		iterUnidadesEdilicias = null;

		Iterator iterContactos = contactos.iterator();
		while (iterContactos.hasNext()) {
			ContactoSujeto contactoSujeto = (ContactoSujeto) iterContactos.next();
			contactoSujeto.save();
			contactoSujeto = null;
		}
		iterContactos = null;

		Iterator iterBonifRecar = bonifRecar.iterator();
		while (iterBonifRecar.hasNext()) {
			BonifRecarSujeto bonifRecarSujeto = (BonifRecarSujeto) iterBonifRecar.next();
			bonifRecarSujeto.save();
			bonifRecarSujeto = null;
		}
		iterBonifRecar = null;

		Iterator iterListaPrecios = listasDePrecios.iterator();
		while (iterListaPrecios.hasNext()) {
			ListaPrecioSujeto listaPrecioSujeto = (ListaPrecioSujeto) iterListaPrecios.next();
			listaPrecioSujeto.save();
			listaPrecioSujeto = null;
		}
		iterListaPrecios = null;

		Iterator iterEsqBonifVigSuj = listasEsqBonifSuj.iterator();
		while (iterEsqBonifVigSuj.hasNext()) {
			EsquemaBonificacionVigSuj esqBonifVigSuj = (EsquemaBonificacionVigSuj) iterEsqBonifVigSuj.next();
			esqBonifVigSuj.save();
			esqBonifVigSuj = null;
		}
		iterEsqBonifVigSuj = null;

		Iterator iterLibImpuestos = liberacionesImpuestos.iterator();
		while (iterLibImpuestos.hasNext()) {
			LiberacionImpuestoSujeto libImpuSuj = (LiberacionImpuestoSujeto) iterLibImpuestos.next();
			libImpuSuj.save();
			libImpuSuj = null;
		}
		iterLibImpuestos = null;

	}

	public static List getHelpClientes(HashTableDatos condiciones, ISesion aSesion) throws BaseException {

		return DBSujeto.getHelpClientes(condiciones, aSesion);
	}

	public List getListasDePreciosVigentes(java.util.Date fecha) throws BaseException {
		List listasDePrecios = new ArrayList();
		List lpSujeto = ListaPrecioSujeto.getListaPreciosBySujetoFecha(this, fecha, getSesion());
		Iterator iterListaPreciosVig = lpSujeto.iterator();
		while (iterListaPreciosVig.hasNext()) {
			ListaPrecioSujeto listaPrecioSujeto = (ListaPrecioSujeto) iterListaPreciosVig.next();
			listasDePrecios.add(listaPrecioSujeto.getLista_precio());
		}
		return listasDePrecios;
	}

	public List getListasPreciosVigentesMasHab(java.util.Date aFecha) throws BaseException {
		return ListaPrecios.getListasPreciosVigentesCliente(getSesion(), aFecha, this);
	}

	public ListaPrecios getListasDePreciosVigente(java.util.Date fecha) throws BaseException {
		List lpSujeto = ListaPrecioSujeto.getListaPreciosBySujetoFecha(this, fecha, getSesion());
		// De todas las listas de Precios se asume como vigente la Primera
		if (!lpSujeto.isEmpty())
			return ((ListaPrecioSujeto) lpSujeto.get(0)).getLista_precio();
		else
			return null;
	}

	public UnidadEdilicia getDomicilioEntrega() throws BaseException {
		Iterator iterUnidadesEdilicias = getUnidadesEdilicias().iterator();
		while (iterUnidadesEdilicias.hasNext()) {
			UnidadEdilicia unidadEdilicia = (UnidadEdilicia) iterUnidadesEdilicias.next();
			if (unidadEdilicia.isDom_ent().booleanValue())
				return unidadEdilicia;
		}
		return null;
	}

	public BonifRecarSujeto getBonifRecar(java.util.Date aFecha) throws BaseException {
		return BonifRecarSujeto.getBonificacion(this, aFecha, getSesion());
	}

	public Porcentaje getPorcBonificacion(java.util.Date aFecha) throws BaseException {
		BonifRecarSujeto bonifRecarSuj = BonifRecarSujeto.getBonificacion(this, aFecha, getSesion());
		if (bonifRecarSuj != null)
			return bonifRecarSuj.getPorcDto();
		else
			return new Porcentaje(0);
	}

	protected void onNew() throws BaseException {
	}

	{
		for (int i = 1; i <= 20; ++i)
			addOidValorClasif(new Integer(i), new Integer(0));
	}

	public List getClasificadoresEntidad() throws BaseException {
		return ClasificadorEntidad.getClasificadoresEntidad(Sujeto.NICKNAME, true, getSesion());
	}

	public List getClasificadoresEntidadActivos() throws BaseException {
		return ClasificadorEntidad.getClasificadoresEntidadActivos(Sujeto.NICKNAME, true, getSesion());
	}

	public static List getClasificadoresEntidad(ISesion aSesion) throws BaseException {
		return ClasificadorEntidad.getClasificadoresEntidad(Sujeto.NICKNAME, true, aSesion);
	}

	public static Sujeto getSujetoByCodigo(String aCodigo, ISesion aSesion) throws BaseException {
		return DBSujeto.getSujetoByCodigo(aCodigo, aSesion);
	}

	public EsquemaBonificacionVigSuj getEsquemaBonifVigSuj(Date fecha) throws BaseException {
		return EsquemaBonificacionVigSuj.getEsquemaBonifVigSuj(this, fecha, getSesion());
	}

	public static boolean isGenerarCodigoAutomaticamente(ISesion aSesion) throws BaseException {
		return ValorParametro.findByCodigoParametro("GENERAR_COD_CLI_AUT", aSesion).getBoolean();
	}

	public static boolean isCompletarCodClienteConCerosAIzq(ISesion aSesion) throws BaseException {
		return ValorParametro.findByCodigoParametro("COMPLETAR_COD_CLIE_CEROS_IZQ", aSesion).getBoolean();
	}

	public static Integer getNroDesdeCliente(ISesion aSesion) throws BaseException {
		Integer nroDesdeCliente = ValorParametro.findByCodigoParametro("NRO_DESDE_CLIENTE", aSesion).getValorEntero();
		return nroDesdeCliente;
	}

	public static Integer getNroHastaCliente(ISesion aSesion) throws BaseException {
		Integer nroHastaCliente = ValorParametro.findByCodigoParametro("NRO_HASTA_CLIENTE", aSesion).getValorEntero();
		return nroHastaCliente;
	}

	public static Integer getMaximaCantCaracteresCodClie(ISesion aSesion) throws BaseException {
		Integer maxCantCaracCodClie = ValorParametro.findByCodigoParametro("MAX_CANT_CARAC_COD_CLIE", aSesion).getValorEntero();
		return maxCantCaracCodClie;
	}

	public String getDireccionCompleta() throws BaseException {

		StringBuffer dir = new StringBuffer();
		if (this.getCalle_y_nro() != null) {
			if (!this.getCalle_y_nro().equals("."))
				dir.append(this.getCalle_y_nro());
		}

		if ((this.getLocalidad() != null) && !(this.getLocalidad().equals("."))) {

			if ((this.getLocalidad() != null) && (this.getLocalidad().length() > 0)) {
				if ((dir.toString().trim().length() != 0))
					dir.append(", ");
			}

			dir.append(this.getLocalidad());

		}

		if ((this.getCodigo_postal() != null) && (!this.getCodigo_postal().equals("."))) {

			if ((this.getCodigo_postal() != null) && (this.getCodigo_postal().length() > 0)) {
				if ((dir.toString().trim().length() != 0))
					dir.append(" ");
			}

			if ((this.getCodigo_postal() != null) && (this.getCodigo_postal().length() > 0))
				dir.append("(" + this.getCodigo_postal() + ")");

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

	public String getTipoDocuImpFiscal() throws BaseException {
		if (this.getTipo_documento() != null)
			return this.getTipo_documento().getTipoDocuParaImpFiscal();
		else
			throw new ExceptionValidation(null, "Falta definir el Tipo de Documento para impresora fiscal " + "para el cliente "
					+ this.getCodigo() + "-" + this.getRazon_social());
	}

	public String getNroDocuImpFiscal() throws BaseException {
		if (this.getTipo_documento().isCUIT() || this.getTipo_documento().isCUIL()) {
			if (this.getSujeto_impositivo() == null)
				throw new ExceptionValidation(null, "Falta definir el sujeto impositivo para " + this.getCodigo() + " - "
						+ this.getDescripcion());
			return this.getSujeto_impositivo().getCuit();
		} else
			return this.getNro_documento();
	}

	public static List getSujetosInvitadosTablero(TableroTurnos tablero, ISesion aSesion) throws BaseException {
		return DBSujeto.getSujetosInvitadosTablero(tablero, aSesion);
	}

	public static List getSujetosInvitadosConFecIng(java.util.Date fecha, ISesion aSesion) throws BaseException {
		return DBSujeto.getSujetosInvitadosConFecIng(fecha, aSesion);
	}

	public boolean isCategoriaInvitado() throws BaseException {
		if (this.getCategoriaSujetoTurno() == null)
			return false;
		if (CategoriaSujetoTurno.getCategSujTurnoInvitado(this.getSesion()).getOID() == this.getCategoriaSujetoTurno().getOID())
			return true;
		else
			return false;
	}

	public List getConcHabCategTurnos(String comportamiento) throws BaseException {
		return DBRelaConcSujTur.getConcHab(this, comportamiento, this.getSesion());
	}

	public List getProyectosActivos() throws BaseException {
		return Proyecto.getProyectosDelSujeto(this, true, this.getSesion());
	}

	public static Sujeto getSujetoDefaultConsFinal(ISesion aSesion) throws BaseException {
		Integer oidSujeto = ValorParametro.findByCodigoParametro("CLIENTE_DEF_VTA_MOS", aSesion).getOidObjNeg();
		Sujeto sujeto = Sujeto.findByOid(oidSujeto, aSesion);
		return sujeto;
	}
	
	  public static Sujeto getSujetoByNroTarjeta(String aNroTarjeta,
				 ISesion aSesion)
	  throws BaseException {
		  return DBSujeto.getSujetoByNroTarjeta(aNroTarjeta,aSesion);
	  }
	  
	  public String getNroDocuParaAfip() throws BaseException {		   
		   if ((this.getTipo_documento().getComportamieno().equals(TipoDocumento.TIPO_DOCU_CUIL)) || (this.getTipo_documento().getComportamieno().equals(TipoDocumento.TIPO_DOCU_CUIT))) {
			   if (this.getSujeto_impositivo()==null)
				   throw new ExceptionValidation(null,"Falta cargar sujeto impositivo para el cliente "+this.getRazon_social());
			   return this.getSujeto_impositivo().getCuit();
			   
		   }
		   return this.getNro_documento();
	  }
	

}
