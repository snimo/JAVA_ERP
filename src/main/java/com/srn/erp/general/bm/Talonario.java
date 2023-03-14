package com.srn.erp.general.bm;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.general.da.DBTalonario;
import com.srn.erp.stock.bm.ConfMovStkTalonario;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bm.Parametros.ValorParametro;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.Validar;

public class Talonario extends ObjetoLogico {

	public static final String MODO_IMP_DIREC = "IMPRESION_DIRECTA";
	public static final String MODO_NO_IMP = "NO_IMPRIMIR";
	public static final String MODO_FORM_IMP = "MODO_FORM_IMPRESION";
	public static final String MODO_ARCHIVO_FISCAL = "ARCHIVO_FISCAL";

	public Talonario() {
	}

	public static String NICKNAME = "ge.Talonario";

	private String codigo;

	private String descripcion;

	private String impo_imp_asoc;

	private ImpresoraFiscal impresora_fiscal;

	private ImpresoraComun impresora_comun;

	private TipoComprobante tipo_comprobante;

	private String letra;

	private LugarEmision lugar_emision;

	private String nombre_archivo_impresion;

	private Integer primer_nro;

	private Integer nro_actual;

	private Integer ultimo_nro;

	private Boolean nro_automatica;

	private Date fec_vto;

	private String cai;

	private UnidadOrganizativa unidad_organizativa;

	private Boolean activo;

	private Talonario talonarioAnulacion;

	private Integer oidTalonarioAnulacion;

	private Integer cantCopias;

	private Boolean intercalar;

	private String orientacion;

	private Boolean generarArchivo;

	private String tipoArchivo;

	private String archivoRTM;

	private String identifArchVistaPreliminar;

	private String identifArchImpresion;

	private String identifArchGeneracionArchivo;

	private String codigoLetra;

	private String comportamientoImpresion;

	private String pathGeneracionArchImpresion;
	
	private String tipoImpresion;
	
	private Boolean esFactEle;
	
	private Integer codigoTCFactEle;

	private List rtmTalonarios = new ArrayList();
	private boolean readRTMTalonarios = true;

	private List unidadesOrganizativas = new ArrayList();
	private boolean readUnidadesOrganizativas = true;

	public void setPathGeneracionArchImpresion(String aPathGenArchImpresion) throws BaseException {
		this.pathGeneracionArchImpresion = aPathGenArchImpresion;
	}
	
	public void setTipoImpresion(String aTipoImpresion) throws BaseException {
		this.tipoImpresion = aTipoImpresion;
	}

	public String getPathGeneracionArchImpresion() throws BaseException {
		this.supportRefresh();
		return this.pathGeneracionArchImpresion;
	}
	
	public String getTipoImpresion() throws BaseException {
		this.supportRefresh();
		return this.tipoImpresion;
	}
	

	public void setCantCopias(Integer aCantCopias) throws BaseException {
		this.cantCopias = aCantCopias;
	}

	public String getIdentifArchVistaPreliminar() throws BaseException {
		this.supportRefresh();
		return this.identifArchVistaPreliminar;
	}

	public void setIdentifArchVistaPreliminar(String aIdentifArchVistaPreliminar) {
		this.identifArchVistaPreliminar = aIdentifArchVistaPreliminar;
	}

	public String getIdentifArchImpresion() throws BaseException {
		this.supportRefresh();
		return this.identifArchImpresion;
	}

	public void setIdentifArchImpresion(String aIdentifArchImpresion) {
		this.identifArchImpresion = aIdentifArchImpresion;
	}

	public String getComportamientoImpresion() throws BaseException {
		this.supportRefresh();
		return this.comportamientoImpresion;
	}

	public void setComportamientoImpresion(String aComportamientoImpresion) {
		this.comportamientoImpresion = aComportamientoImpresion;
	}

	public String getCodigoLetra() throws BaseException {
		this.supportRefresh();
		return this.codigoLetra;
	}

	public void setCodigoLetra(String aCodigoLetra) {
		this.codigoLetra = aCodigoLetra;
	}

	public String getIdentifArchGeneracionArchivo() throws BaseException {
		this.supportRefresh();
		return this.identifArchGeneracionArchivo;
	}

	public void setIdentifArchGeneracionArchivo(String aIdentifArchGeneracionArchivo) {
		this.identifArchGeneracionArchivo = aIdentifArchGeneracionArchivo;
	}

	public Integer getCantCopias() throws BaseException {
		this.supportRefresh();
		return this.cantCopias;
	}

	public void setArchivoRTM(String aArchivoRTM) throws BaseException {
		this.archivoRTM = aArchivoRTM;
	}

	public String getArchivoRTM() throws BaseException {
		this.supportRefresh();
		return this.archivoRTM;
	}

	public void setIntercalar(Boolean aIntercalar) throws BaseException {
		this.intercalar = aIntercalar;
	}

	public Boolean isIntercalar() throws BaseException {
		this.supportRefresh();
		return this.intercalar;
	}

	public void setOrientacion(String aOrientacion) throws BaseException {
		this.orientacion = aOrientacion;
	}

	public String getOrientacion() throws BaseException {
		this.supportRefresh();
		return this.orientacion;
	}

	public void setGenerarArchivo(Boolean aGenerarArchivo) throws BaseException {
		this.generarArchivo = aGenerarArchivo;
	}

	public Boolean isGenerararchivo() throws BaseException {
		this.supportRefresh();
		return this.generarArchivo;
	}

	public void setTipoArchivo(String aTiporchivo) throws BaseException {
		this.tipoArchivo = aTiporchivo;
	}

	public String getTipoArchivo() throws BaseException {
		this.supportRefresh();
		return this.tipoArchivo;
	}

	public void setOidTalonarioAnulacion(Integer aOidTalonarioAnulacion) throws BaseException {
		this.oidTalonarioAnulacion = aOidTalonarioAnulacion;
	}
	

	public Integer getCodigoTCFactEle() throws BaseException {
		supportRefresh();
		return this.codigoTCFactEle;
	}
	
	public void setCodigoTCFactEle(Integer aCodigoTCFactEle) throws BaseException {
		this.codigoTCFactEle = aCodigoTCFactEle;
	}

	
	public Integer getOidTalonarioAnulacion() throws BaseException {
		supportRefresh();
		return oidTalonarioAnulacion;
	}

	public Talonario getTalonarioAnulacion() throws BaseException {
		supportRefresh();
		if (talonarioAnulacion == null)
			talonarioAnulacion = Talonario.findByOidProxy(getOidTalonarioAnulacion(), getSesion());
		return this.talonarioAnulacion;
	}

	public void setTalonarioAnulacion(Talonario aTalonarioAnulacion) throws BaseException {
		this.talonarioAnulacion = aTalonarioAnulacion;
	}

	public String getCodigo() throws BaseException {
		supportRefresh();
		return codigo;
	}

	public void setCodigo(String aCodigo) {
		this.codigo = aCodigo;
	}

	public String getDescripcion() throws BaseException {
		supportRefresh();
		return descripcion;
	}

	public void setDescripcion(String aDescripcion) {
		this.descripcion = aDescripcion;
	}

	public String getImpo_imp_asoc() throws BaseException {
		supportRefresh();
		return impo_imp_asoc;
	}

	public void setImpo_imp_asoc(String aImpo_imp_asoc) {
		this.impo_imp_asoc = aImpo_imp_asoc;
	}

	public ImpresoraFiscal getImpresora_fiscal() throws BaseException {
		supportRefresh();
		return impresora_fiscal;
	}

	public void setImpresora_fiscal(ImpresoraFiscal aImpresora_fiscal) {
		this.impresora_fiscal = aImpresora_fiscal;
	}

	public ImpresoraComun getImpresora_comun() throws BaseException {
		supportRefresh();
		return impresora_comun;
	}

	public void setImpresora_comun(ImpresoraComun aImpresora_comun) {
		this.impresora_comun = aImpresora_comun;
	}

	public TipoComprobante getTipo_comprobante() throws BaseException {
		supportRefresh();
		return tipo_comprobante;
	}

	public void setTipo_comprobante(TipoComprobante aTipo_comprobante) {
		this.tipo_comprobante = aTipo_comprobante;
	}

	public String getLetra() throws BaseException {
		supportRefresh();
		return letra;
	}

	public void setLetra(String aLetra) {
		this.letra = aLetra;
	}

	public LugarEmision getLugar_emision() throws BaseException {
		supportRefresh();
		return lugar_emision;
	}

	public void setLugar_emision(LugarEmision aLugar_emision) {
		this.lugar_emision = aLugar_emision;
	}

	public String getNombre_archivo_impresion() throws BaseException {
		supportRefresh();
		return nombre_archivo_impresion;
	}

	public void setNombre_archivo_impresion(String aNombre_archivo_impresion) {
		this.nombre_archivo_impresion = aNombre_archivo_impresion;
	}

	public Integer getPrimer_nro() throws BaseException {
		supportRefresh();
		return primer_nro;
	}

	public void setPrimer_nro(Integer aPrimer_nro) {
		this.primer_nro = aPrimer_nro;
	}

	public Integer getNro_actual() throws BaseException {
		supportRefresh();
		return nro_actual;
	}

	public void setNro_actual(Integer aNro_actual) {
		this.nro_actual = aNro_actual;
	}

	public Integer getUltimo_nro() throws BaseException {
		supportRefresh();
		return ultimo_nro;
	}

	public void setUltimo_nro(Integer aUltimo_nro) {
		this.ultimo_nro = aUltimo_nro;
	}

	public Boolean isNro_automatica() throws BaseException {
		supportRefresh();
		return nro_automatica;
	}
	
	public Boolean isFactElec() throws BaseException {
		supportRefresh();
		return this.esFactEle;
	}
	
	public void setEsFactElec(Boolean aEsFactEle) {
		this.esFactEle = aEsFactEle;
	}


	public void setNro_automatica(Boolean aNro_automatica) {
		this.nro_automatica = aNro_automatica;
	}

	public Date getFec_vto() throws BaseException {
		supportRefresh();
		return fec_vto;
	}

	public void setFec_vto(Date aFec_vto) {
		this.fec_vto = aFec_vto;
	}

	public String getCai() throws BaseException {
		supportRefresh();
		return cai;
	}

	public void setCai(String aCai) {
		this.cai = aCai;
	}

	public UnidadOrganizativa getUnidad_organizativa() throws BaseException {
		supportRefresh();
		return unidad_organizativa;
	}

	public void setUnidad_organizativa(UnidadOrganizativa aUnidad_organizativa) {
		this.unidad_organizativa = aUnidad_organizativa;
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

	public static Talonario findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (Talonario) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static Talonario findByOidProxy(Integer oid, ISesion aSesion) throws BaseException {
		return (Talonario) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}

	public static Talonario findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (Talonario) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(codigo, "Debe ingresar el Código");
		Validar.noNulo(descripcion, "Debe ingresar la Descripción");
		Validar.noNulo(impo_imp_asoc, "Debe ingresar el Tipo de Asociación");
		Validar.noNulo(tipo_comprobante, "Debe Ingresar el Tipo de Comprobante");
		Validar.noNulo(letra, "Debe Ingresar la Letra");
		Validar.noNulo(lugar_emision, "Debe Ingresar el Lugar de Emisión");
		Validar.noNulo(primer_nro, "Debe Ingresar el Primer Nro. del Talonario");
		Validar.noNulo(nro_actual, "Debe Ingresar el Nro. Actual");
		Validar.noNulo(ultimo_nro, "Debe Ingresar el Ultimo Nro.");
		Validar.noNulo(nro_automatica, "Debe Ingresar si Numera o No en Forma Automática");
		Validar.noNulo(fec_vto, "Debe Ingresar la Fecha de Vencimiento");
		Validar.noNulo(unidad_organizativa, "Debe Ingresar la Unidad Organizativa");
	}

	public static List getTalonariosRemito(ISesion aSesion) throws BaseException {
		return DBTalonario.getTalonariosRemito(aSesion);
	}

	public static List getTalonariosAjuStk(ISesion aSesion) throws BaseException {
		return DBTalonario.getTalonariosAjuStk(aSesion);
	}

	public static List getTalonariosFactuClie(UnidadOrganizativa uniOrg, ISesion aSesion) throws BaseException {
		return DBTalonario.getTalonariosFactuClie(uniOrg, aSesion);

	}

	public static List getTalonariosNDClie(UnidadOrganizativa uniOrg, ISesion aSesion) throws BaseException {
		return DBTalonario.getTalonariosNDClie(uniOrg, aSesion);
	}

	public static List getTalonariosNDIClie(UnidadOrganizativa uniOrg, ISesion aSesion) throws BaseException {
		return DBTalonario.getTalonariosNDIClie(uniOrg, aSesion);
	}

	public static List getTalonariosNCIClie(UnidadOrganizativa uniOrg, ISesion aSesion) throws BaseException {
		return DBTalonario.getTalonariosNCIClie(uniOrg, aSesion);
	}

	public static List getTalonariosNCClie(UnidadOrganizativa uniOrg, ISesion aSesion) throws BaseException {
		return DBTalonario.getTalonariosNCClie(uniOrg, aSesion);
	}

	public static List getTalonariosFacturaHab(ISesion aSesion) throws BaseException {

		List talonariosHabilitados = new ArrayList();

		Integer oidSucursal = aSesion.getLogin().getOidSucursal();
		Sucursal sucursal = Sucursal.findByOid(oidSucursal, aSesion);

		Integer oidEmpresa = aSesion.getLogin().getOidEmpresa();
		Empresa empresa = Empresa.findByOid(oidEmpresa, aSesion);

		List listaUniOrg = sucursal.getUniOrgHabilitadas(empresa);
		Iterator iterUniOrg = listaUniOrg.iterator();
		while (iterUniOrg.hasNext()) {
			UnidadOrganizativa uniOrg = (UnidadOrganizativa) iterUniOrg.next();
			List talonariosFactuClie = getTalonariosFactuClie(uniOrg, aSesion);
			talonariosHabilitados.addAll(talonariosFactuClie);
		}

		return talonariosHabilitados;

	}

	public static List getTalonariosNDHab(ISesion aSesion) throws BaseException {

		List talonariosHabilitados = new ArrayList();

		Integer oidSucursal = aSesion.getLogin().getOidSucursal();
		Sucursal sucursal = Sucursal.findByOid(oidSucursal, aSesion);

		Integer oidEmpresa = aSesion.getLogin().getOidEmpresa();
		Empresa empresa = Empresa.findByOid(oidEmpresa, aSesion);

		List listaUniOrg = sucursal.getUniOrgHabilitadas(empresa);
		Iterator iterUniOrg = listaUniOrg.iterator();
		while (iterUniOrg.hasNext()) {
			UnidadOrganizativa uniOrg = (UnidadOrganizativa) iterUniOrg.next();
			List talonariosFactuClie = getTalonariosNDClie(uniOrg, aSesion);
			talonariosHabilitados.addAll(talonariosFactuClie);
		}
		return talonariosHabilitados;

	}

	public static List getTalonariosNCHab(ISesion aSesion) throws BaseException {

		List talonariosHabilitados = new ArrayList();

		Integer oidSucursal = aSesion.getLogin().getOidSucursal();
		Sucursal sucursal = Sucursal.findByOid(oidSucursal, aSesion);

		Integer oidEmpresa = aSesion.getLogin().getOidEmpresa();
		Empresa empresa = Empresa.findByOid(oidEmpresa, aSesion);

		List listaUniOrg = sucursal.getUniOrgHabilitadas(empresa);
		Iterator iterUniOrg = listaUniOrg.iterator();
		while (iterUniOrg.hasNext()) {
			UnidadOrganizativa uniOrg = (UnidadOrganizativa) iterUniOrg.next();
			List talonariosFactuClie = getTalonariosNCClie(uniOrg, aSesion);
			talonariosHabilitados.addAll(talonariosFactuClie);
		}
		return talonariosHabilitados;

	}

	public static List getTalonariosNCIHab(ISesion aSesion) throws BaseException {

		List talonariosHabilitados = new ArrayList();

		Integer oidSucursal = aSesion.getLogin().getOidSucursal();
		Sucursal sucursal = Sucursal.findByOid(oidSucursal, aSesion);

		Integer oidEmpresa = aSesion.getLogin().getOidEmpresa();
		Empresa empresa = Empresa.findByOid(oidEmpresa, aSesion);

		List listaUniOrg = sucursal.getUniOrgHabilitadas(empresa);
		Iterator iterUniOrg = listaUniOrg.iterator();
		while (iterUniOrg.hasNext()) {
			UnidadOrganizativa uniOrg = (UnidadOrganizativa) iterUniOrg.next();
			List talonariosFactuClie = getTalonariosNCIClie(uniOrg, aSesion);
			talonariosHabilitados.addAll(talonariosFactuClie);
		}
		return talonariosHabilitados;

	}

	public static List getTalonariosNDIHab(ISesion aSesion) throws BaseException {

		List talonariosHabilitados = new ArrayList();

		Integer oidSucursal = aSesion.getLogin().getOidSucursal();
		Sucursal sucursal = Sucursal.findByOid(oidSucursal, aSesion);

		Integer oidEmpresa = aSesion.getLogin().getOidEmpresa();
		Empresa empresa = Empresa.findByOid(oidEmpresa, aSesion);

		List listaUniOrg = sucursal.getUniOrgHabilitadas(empresa);
		Iterator iterUniOrg = listaUniOrg.iterator();
		while (iterUniOrg.hasNext()) {
			UnidadOrganizativa uniOrg = (UnidadOrganizativa) iterUniOrg.next();
			List talonariosFactuClie = getTalonariosNDIClie(uniOrg, aSesion);
			talonariosHabilitados.addAll(talonariosFactuClie);
		}
		return talonariosHabilitados;

	}

	public static List getTalonariosByIdentifTCySucursal(String identificacion, Sucursal sucursal, ISesion aSesion) throws BaseException {
		return DBTalonario.getTalonariosByIdentifTCySucursal(identificacion, sucursal, aSesion);
	}

	public static List getTalonariosByIdentifTC(String identificacion, ISesion aSesion) throws BaseException {
		return DBTalonario.getTalonariosByIdentifTC(identificacion, aSesion);

	}

	public ConfMovStkTalonario getConfMovStock() throws BaseException {
		return ConfMovStkTalonario.getConfMovStkByTalonario(this, getSesion());
	}

	public static Talonario getTalonatioAplicComproProv(ISesion aSesion) throws BaseException {
		ValorParametro valorParamContabilizaComproProv = ValorParametro.findByCodigoParametro("TALONATIO_APLIC_PROV", aSesion);
		Talonario talonario = Talonario.findByOidProxy(valorParamContabilizaComproProv.getOidObjNeg(), aSesion);
		return talonario;
	}

	public static Talonario getTalonatioConciliacionBanco(ISesion aSesion) throws BaseException {
		ValorParametro valorParamContabilizaComproProv = ValorParametro.findByCodigoParametro("TALONARIO_CONCI_BCO", aSesion);
		Talonario talonario = Talonario.findByOidProxy(valorParamContabilizaComproProv.getOidObjNeg(), aSesion);
		return talonario;
	}

	public static Talonario getTalonatioAsientoConciliacionBanco(ISesion aSesion) throws BaseException {
		ValorParametro valorParamContabilizaComproProv = ValorParametro.findByCodigoParametro("TALONARIO_ASI_CONCI_BCO", aSesion);
		Talonario talonario = Talonario.findByOidProxy(valorParamContabilizaComproProv.getOidObjNeg(), aSesion);
		return talonario;
	}

	public static Talonario getTalonatioInventario(ISesion aSesion) throws BaseException {
		ValorParametro valorParam = ValorParametro.findByCodigoParametro("TALONARIO_INVENTARIO", aSesion);
		Talonario talonario = Talonario.findByOidProxy(valorParam.getOidObjNeg(), aSesion);
		return talonario;
	}

	public static Talonario getTalonatioSubreparto(ISesion aSesion) throws BaseException {
		ValorParametro valorParam = ValorParametro.findByCodigoParametro("TALONARIO_SUBREPARTO", aSesion);
		Talonario talonario = Talonario.findByOidProxy(valorParam.getOidObjNeg(), aSesion);
		return talonario;
	}

	public static Talonario getTalonatioDefOC(ISesion aSesion) throws BaseException {
		ValorParametro valorParam = ValorParametro.findByCodigoParametro("TALONARIO_DEF_OC", aSesion);
		Talonario talonario = Talonario.findByOidProxy(valorParam.getOidObjNeg(), aSesion);
		return talonario;
	}

	public static Talonario getTalonatioAplicComproClie(ISesion aSesion) throws BaseException {
		ValorParametro valorParamContabilizaComproClie = ValorParametro.findByCodigoParametro("TALONATIO_APLIC_CLIE", aSesion);
		Talonario talonario = Talonario.findByOidProxy(valorParamContabilizaComproClie.getOidObjNeg(), aSesion);
		return talonario;
	}

	public static Talonario getTalonatioAsientoCierreEjercicio(ISesion aSesion) throws BaseException {
		ValorParametro valorParamContabilizaComproClie = ValorParametro.findByCodigoParametro("TALO_COMPRO_CIERRE_ASI_CONTABLE", aSesion);
		Talonario talonario = Talonario.findByOidProxy(valorParamContabilizaComproClie.getOidObjNeg(), aSesion);
		return talonario;
	}

	public static Talonario getTalonatioAsientoAperturaEjercicio(ISesion aSesion) throws BaseException {
		ValorParametro valorParamContabilizaComproClie = ValorParametro.findByCodigoParametro("TALO_COMPRO_APER_ASI_CONTABLE", aSesion);
		Talonario talonario = Talonario.findByOidProxy(valorParamContabilizaComproClie.getOidObjNeg(), aSesion);
		return talonario;
	}

	public static Talonario getTalonatioDefaultRequisiciones(ISesion aSesion) throws BaseException {
		ValorParametro valorParamContabilizaComproClie = ValorParametro.findByCodigoParametro("TALONARIO_DEF_REQUISICIONES", aSesion);
		Talonario talonario = Talonario.findByOidProxy(valorParamContabilizaComproClie.getOidObjNeg(), aSesion);
		return talonario;
	}

	public List getRTMTalonarios() throws BaseException {
		if (this.readRTMTalonarios) {
			List listaRTMTalonarios = RTMTalonario.getRTMTalonarios(this, getSesion());
			rtmTalonarios.addAll(listaRTMTalonarios);
			this.readRTMTalonarios = false;
		}
		return rtmTalonarios;
	}

	public List getUnidadesOrganizativasTalonario() throws BaseException {
		if (this.readUnidadesOrganizativas) {
			List listaUniOrgTal = UniOrgTalonario.getUnidadesOrgTalonario(this, getSesion());
			this.unidadesOrganizativas.addAll(listaUniOrgTal);
			this.readUnidadesOrganizativas = false;
		}
		return this.unidadesOrganizativas;
	}

	public void addRTMTalonario(RTMTalonario rtmTalonario) throws BaseException {
		rtmTalonario.setTalonario(this);
		rtmTalonarios.add(rtmTalonario);
	}

	public void addUniOrgTalonario(UniOrgTalonario aUniOrgTalonrio) throws BaseException {
		aUniOrgTalonrio.setTalonario(this);
		this.unidadesOrganizativas.add(aUniOrgTalonrio);
	}

	public static List getTalonariosByTipoAjuStkyOidTipoConfMov(String tipoAjuStk, Integer oidTipoConfMov, ISesion aSesion) throws BaseException {
		return DBTalonario.getTalonariosByTipoAjuStkyOidTipoConfMov(tipoAjuStk, oidTipoConfMov, aSesion);
	}

	public void afterSave() throws BaseException {

		Iterator iterRTMTalonarios = rtmTalonarios.iterator();
		while (iterRTMTalonarios.hasNext()) {
			RTMTalonario rtmTalonario = (RTMTalonario) iterRTMTalonarios.next();
			rtmTalonario.save();
			rtmTalonario = null;
		}
		iterRTMTalonarios = null;

		Iterator iterUniOrgTal = unidadesOrganizativas.iterator();
		while (iterUniOrgTal.hasNext()) {
			UniOrgTalonario uniOrgTalonario = (UniOrgTalonario) iterUniOrgTal.next();
			uniOrgTalonario.save();
			uniOrgTalonario = null;
		}
		iterUniOrgTal = null;

	}

	public static HashTableDatos getModosImpresion() {

		HashTableDatos modosImpresion = new HashTableDatos();
		modosImpresion.put(MODO_IMP_DIREC, "Impresión directa");
		modosImpresion.put(MODO_NO_IMP, "No imprimir");
		modosImpresion.put(MODO_FORM_IMP, "Formulario de Impresión");
		modosImpresion.put(MODO_ARCHIVO_FISCAL, "Archivo Fiscal");

		return modosImpresion;

	}

	public static int getModoImpresionControladorFiscal(String modo) throws BaseException {
		if (modo == null)
			return 0;

		if (modo.equals(MODO_ARCHIVO_FISCAL))
			return 1;
		if (modo.equals(MODO_NO_IMP))
			return 2;
		else
			return 0;
	}

	public String getTipoComproImpFiscal() throws BaseException {
		if (this.getTipo_comprobante().esFacturacliente() && this.getLetra().equals("A"))
			return "FACTURA_A";
		else if (this.getTipo_comprobante().esFacturacliente() && this.getLetra().equals("B"))
			return "FACTURA_B";
		else if (this.getTipo_comprobante().esNotaCreditoCliente() && this.getLetra().equals("B"))
			return "NC_B";
		else if (this.getTipo_comprobante().esNotaCreditoCliente() && this.getLetra().equals("A"))
			return "NC_A";
		else if (this.getTipo_comprobante().esRemitocliente())
			return "REMITO";
		else if (this.getTipo_comprobante().esRecibo())
			return "RECIBO_X";

		throw new ExceptionValidation(null, "No se pudo obtener el comprobante para la impresora fiscal correspondiente a " + this.getTipo_comprobante().getIdentificacion());
	}

	public boolean isUsaImpresoraFiscal() throws BaseException {
		if (this.getImpo_imp_asoc().equals("Fiscal"))
			return true;
		else
			return false;
	}

	public int getProxNro() throws BaseException {
		return DBTalonario.getProxNroTalonario(this, this.getSesion());
	}

	public String getCodigoBarraImpresionFactura(String cuitEmisor) throws BaseException {

		if (!(((this.isFactElec()!=null) && (this.isFactElec()==true)))) return "";
		
		StringBuffer codigo = new StringBuffer("");

		// CUIT del emisor del comprobante (11 caracteres)
		if (cuitEmisor != null) {
			String nuevoCUIT = cuitEmisor.replaceAll("-", "").substring(0, 11);
			if (nuevoCUIT.length() != 11)
				return "";
			codigo.append(nuevoCUIT);
		} else
			return "";

		// Codigo del Tipo de comprobante (3 caracteres)
		if ((this.getCodigoTCFactEle() != null)) {  
			NumberFormat formatTC = new DecimalFormat("000");
			String tc = formatTC.format(this.getCodigoTCFactEle());
			codigo.append(tc);
		}
		else
			return "";

		// Punto de Venta (5 caracteres)
		if (this.getLugar_emision() != null)
			codigo.append(this.getLugar_emision().getLugEmiFormato5Digitos());
		else
			return "";

		// Deberian ser 14 caracteres
		if (this.getCai() != null) {
			if (this.getCai().length() == 14)
				codigo.append(this.getCai());
			else
				return "";
		} else
			return "";

		// Fecha Vencimiento
		if (this.getFec_vto() != null) {
			SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy");
			codigo.append(sdf.format(this.getFec_vto()).toString());
		} else
			return "";

		// Obtener el Digito verificador
		String codigoBarra = codigo.toString();
		int totalImpares = 0;
		boolean seSuma = true;
		// Sumar los numeros en posiciones impares
		for (int i = 0; i < codigoBarra.length(); ++i) {

			if (seSuma) {
				int numeroDigito = 0;
				try {
					numeroDigito = Integer.parseInt(codigoBarra.substring(i, i + 1));
				} catch (Exception e) {
					return "";
				}
				totalImpares = totalImpares + numeroDigito;
				seSuma = false;
			} else {
				seSuma = true;
			}
		}

		// Multiplicar el resultado por 3
		totalImpares = totalImpares * 3;

		// Sumar los numeros en posiciones pares
		seSuma = false;
		int totalPares = 0;
		for (int i = 0; i < codigoBarra.length(); ++i) {

			if (seSuma) {
				int numeroDigito = 0;
				try {
					numeroDigito = Integer.parseInt(codigoBarra.substring(i, i + 1));
				} catch (Exception e) {
					return "";
				}
				totalPares = totalPares + numeroDigito;
				seSuma = false;
			} else {
				seSuma = true;
			}
		}

		int totalParesMasImpares = totalPares + totalImpares;

		// Calcular el modulo 10
		int digitoVerificador = 10 - (totalParesMasImpares % 10);
		if (digitoVerificador == 10)
			digitoVerificador = 0;

		codigo.append(digitoVerificador);

		return codigo.toString();
	}

	public static List getTalonariosByLibroIVAVentas(ISesion aSesion) throws BaseException {
		return DBTalonario.getTalonariosByLibroIVAVentas(aSesion);
	}

	public static List getTalonariosLiquidacionesTarjetas(ISesion aSesion) throws BaseException {
		return DBTalonario.getTalonariosLiquidacionesTarjetas(aSesion);
	}

}
