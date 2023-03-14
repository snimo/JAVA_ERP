package com.srn.erp.general.bm;

import java.util.ArrayList;
import java.util.List;

import com.srn.erp.general.da.DBImpresoraFiscal;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.Validar;



public class ImpresoraFiscal extends ObjetoLogico {

	
	public static final String MODO_IMP_DIREC = "IMPRESION_DIRECTA";
	public static final String MODO_NO_IMP = "NO_IMPRIMIR";
	public static final String MODO_ARCHIVO_FISCAL = "ARCHIVO_FISCAL";
	
	
	public static final String DRIVER_UNIVERSAL = "UNIVERSAL";
	public static final String DRIVER_HASAR = "HASAR";
	
	
	public static final String	MODELO_EPSON_Tm2000AF = "TM2000";
	public static final String	MODELO_EPSON_Tm2000AFPlus = "TM2000";
	public static final String	MODELO_EPSON_TMU950 = "TMU950";
	public static final String	MODELO_EPSON_TM300AF = "TM300";
	public static final String	MODELO_EPSON_TMT285F = "TMT285";
	public static final String	MODELO_EPSON_LX300F = "LX300";
	public static final String	MODELO_EPSON_LX300FPlus = "LX300";
	public static final String	MODELO_EPSON_FX880F = "FX880";

	public static final String	MODELO_HASAR_PJ20F = "HJ20";
	public static final String	MODELO_HASAR_320F = "H320";
	public static final String	MODELO_HASAR_321F = "H321";
	public static final String	MODELO_HASAR_322Fo330F = "H322";
	public static final String	MODELO_HASAR_PL8F = "HPL8";
	public static final String	MODELO_HASAR_PL1200F = "HPL1200";
	public static final String	MODELO_HASAR_615F = "H615";
	public static final String	MODELO_HASAR_715F = "H715";
	public static final String	MODELO_HASAR_PR4F = "HPR4";
	public static final String	MODELO_HASAR_PR5F = "HPR4";
	public static final String	MODELO_HASAR_930F = "H930";
	public static final String	MODELO_HASAR_951F = "H951";

	public static final String	MODELO_NCR_2008 = "NCR2008";
	public static final String	MODELO_NCR_3140_H715 = "H715";
	public static final String	MODELO_NCR_3150_H615 = "H615";
	public static final String	MODELO_NCR_TM2000 = "TM2000";


	public ImpresoraFiscal() {
	}

	public static String				NICKNAME	= "ge.ImpresoraFiscal";

	private String							codigo;

	private String							descripcion;

	private String							compo_imp_fiscal;

	private Boolean							activo;
	
	private String compoImpre;
	
	private String pathGenArchivo;

	private UnidadOrganizativa	uniOrg;
	
	private String driver;
	
	private Integer puerto;
	
	private Integer baudios;

	public String getCodigo() throws BaseException {
		supportRefresh();
		return codigo;
	}

	public void setComportamiento(String aComportamiento) {
		this.compoImpre = aComportamiento;
	}
	
	public String getComportamiento() throws BaseException {
		supportRefresh();
		return compoImpre;
	}
	
	public void setPathGenArchivo(String aPathGenArch) {
		this.pathGenArchivo = aPathGenArch;
	}
	
	public String getPathGenArch() throws BaseException {
		supportRefresh();
		return this.pathGenArchivo;
	}
	

	public void setCodigo(String aCodigo) {
		this.codigo = aCodigo;
	}
	
	
	public String getDriver() throws BaseException {
		supportRefresh();
		return driver;
	}

	public void setDriver(String aDriver) {
		this.driver = aDriver;
	}
	
	
	
	
	public Integer getPuerto() throws BaseException {
		supportRefresh();
		return puerto;
	}

	public void setPuerto(Integer aPuerto) {
		this.puerto = aPuerto;
	}
	
	public Integer getBaudios() throws BaseException {
		supportRefresh();
		return baudios;
	}

	public void setBaudios(Integer aBaudios) {
		this.baudios = aBaudios;
	}
	
	

	public UnidadOrganizativa getUnidadOrganizativa() throws BaseException {
		supportRefresh();
		return uniOrg;
	}

	public void setUnidadOrganizativa(UnidadOrganizativa aUniOrg) {
		this.uniOrg = aUniOrg;
	}

	public String getDescripcion() throws BaseException {
		supportRefresh();
		return descripcion;
	}

	public void setDescripcion(String aDescripcion) {
		this.descripcion = aDescripcion;
	}

	public String getCompo_imp_fiscal() throws BaseException {
		supportRefresh();
		return compo_imp_fiscal;
	}

	public void setCompo_imp_fiscal(String aCompo_imp_fiscal) {
		this.compo_imp_fiscal = aCompo_imp_fiscal;
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

	public static ImpresoraFiscal findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (ImpresoraFiscal) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static ImpresoraFiscal findByOidProxy(Integer oid, ISesion aSesion) throws BaseException {
		return (ImpresoraFiscal) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}

	public static ImpresoraFiscal findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (ImpresoraFiscal) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(codigo, "Debe ingresar el Código");
		Validar.noNulo(descripcion, "Debe ingresar la Descripción");
		Validar.noNulo(compo_imp_fiscal, "Debe ingresar el Tipo de Impresora");
		Validar.noNulo(uniOrg, "Debe ingresar la Unidad Organizativa");
		Validar.noNulo(puerto, "Debe ingresar el Puerto");
		Validar.noNulo(baudios, "Debe ingresar los Baudios");
		Validar.noNulo(driver, "Debe ingresar el Driver");
		Validar.noNulo(this.compoImpre,"Debe ingresar el Modo de Impresión");
		if (this.isModoGenerarArchivo())
			Validar.noNulo(this.pathGenArchivo,"Debe ingresar el Path del Archivo");
	}

	public static List getTipos() throws BaseException {
		List lista = new ArrayList();
		lista.add(MODELO_EPSON_Tm2000AF);
		lista.add(MODELO_EPSON_Tm2000AFPlus);
		lista.add(MODELO_EPSON_TMU950);
		lista.add(MODELO_EPSON_TM300AF);
		lista.add(MODELO_EPSON_TMT285F);
		lista.add(MODELO_EPSON_LX300F);
		lista.add(MODELO_EPSON_LX300FPlus);
		lista.add(MODELO_EPSON_FX880F);

		lista.add(MODELO_HASAR_PJ20F);
		lista.add(MODELO_HASAR_320F);
		lista.add(MODELO_HASAR_321F);
		lista.add(MODELO_HASAR_322Fo330F);
		lista.add(MODELO_HASAR_PL8F);
		lista.add(MODELO_HASAR_PL1200F);
		lista.add(MODELO_HASAR_615F);
		lista.add(MODELO_HASAR_715F);
		lista.add(MODELO_HASAR_PR4F);
		lista.add(MODELO_HASAR_PR5F);
		lista.add(MODELO_HASAR_930F);
		lista.add(MODELO_HASAR_951F);

		lista.add(MODELO_NCR_2008);
		lista.add(MODELO_NCR_3140_H715);
		lista.add(MODELO_NCR_3150_H615);
		lista.add(MODELO_NCR_TM2000);
		return lista;
	}
	
	public static List getTiposDrivers() throws BaseException {
		List lista = new ArrayList();
		lista.add(DRIVER_UNIVERSAL);
		lista.add(DRIVER_HASAR);
		return lista;
	}
	

	public static List getImpresoras(Sucursal sucursal, ISesion aSesion) throws BaseException {
		return DBImpresoraFiscal.getImpresoras(sucursal, aSesion);
	}
	
	public static List getAllImpresorasActivas(ISesion aSesion) throws BaseException {
		return DBImpresoraFiscal.getAllImpresorasActivas(aSesion);
	}
	
	public String getModeloParaImpresor() throws BaseException {
		if (this.getCompo_imp_fiscal().equals(MODELO_EPSON_Tm2000AF)) 
				return "TM2000";
		else		
		if (this.getCompo_imp_fiscal().equals(MODELO_EPSON_Tm2000AFPlus))
				return  "TM2000";
		else
		if (this.getCompo_imp_fiscal().equals(MODELO_EPSON_TMU950))
				return "TMU950";
		else
		if (this.getCompo_imp_fiscal().equals(MODELO_EPSON_TM300AF))
				return  "TM300";
		else
		if (this.getCompo_imp_fiscal().equals(MODELO_EPSON_TMT285F))
			return  "TMT285";
		else
		if (this.getCompo_imp_fiscal().equals(MODELO_EPSON_LX300F))
			return  "LX300";
		else
		if (this.getCompo_imp_fiscal().equals(MODELO_EPSON_LX300FPlus))
			return "LX300";
		else
		if (this.getCompo_imp_fiscal().equals(MODELO_EPSON_FX880F))
			return "FX880";
		else
		if (this.getCompo_imp_fiscal().equals(MODELO_HASAR_PJ20F))
			return "HJ20";
		else
		if (this.getCompo_imp_fiscal().equals(MODELO_HASAR_320F))
			return "H320";
		else
		if (this.getCompo_imp_fiscal().equals(MODELO_HASAR_321F))
			return "H321";
		else
		if (this.getCompo_imp_fiscal().equals(MODELO_HASAR_322Fo330F))
			return "H322";
		else
		if (this.getCompo_imp_fiscal().equals(MODELO_HASAR_PL8F))
			return "HPL8";
		else
		if (this.getCompo_imp_fiscal().equals(MODELO_HASAR_PL1200F))
			return "HPL1200";
		else
		if (this.getCompo_imp_fiscal().equals(MODELO_HASAR_615F))
			return "H615";
		else
		if (this.getCompo_imp_fiscal().equals(MODELO_HASAR_715F))
			return "H715";
		else
		if (this.getCompo_imp_fiscal().equals(MODELO_HASAR_PR4F))
			return "HPR4";
		else
		if (this.getCompo_imp_fiscal().equals(MODELO_HASAR_PR5F))
			return "HPR4";
		else
		if (this.getCompo_imp_fiscal().equals(MODELO_HASAR_930F))
			return "H930";
		else
		if (this.getCompo_imp_fiscal().equals(MODELO_HASAR_951F))
			return "H951";
		else
		if (this.getCompo_imp_fiscal().equals(MODELO_NCR_2008))
			return "NCR2008";
		else
		if (this.getCompo_imp_fiscal().equals(MODELO_NCR_3140_H715))
			return "H715";
		else
		if (this.getCompo_imp_fiscal().equals(MODELO_NCR_3150_H615))
			return "H615";
		else
		if (this.getCompo_imp_fiscal().equals(MODELO_NCR_TM2000))
			return "TM2000";
		else
			throw new ExceptionValidation(null,"No se pudo encontrar el Modelo para el impresor fiscal correspondiente a "+this.getCompo_imp_fiscal());
		
	}
	
	public static HashTableDatos getModosImpresion() throws BaseException {
		HashTableDatos modos = new HashTableDatos();
		modos.put(MODO_IMP_DIREC,"Impresión Directa");
		modos.put(MODO_NO_IMP,"No Imprimir");
		modos.put(MODO_ARCHIVO_FISCAL,"Generar Archivo");
		return modos;
	}
	
	public boolean isModoGenerarArchivo() throws BaseException {
		if ((this.getComportamiento()!=null) && (this.getComportamiento().equals(MODO_ARCHIVO_FISCAL)))
			return true;
		return false;
	}
	

}
