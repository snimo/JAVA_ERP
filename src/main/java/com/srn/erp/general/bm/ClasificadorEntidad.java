package com.srn.erp.general.bm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.general.da.DBClasificadorEntidad;
import com.srn.erp.stock.bm.ConfGenMasProd;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bm.Parametros.ValorParametro;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class ClasificadorEntidad extends ObjetoLogico {

	public ClasificadorEntidad() {
	}

	private boolean isRangoNumerico = true;

	public void setIsRangoNumerico(boolean isRangoNumerico)
			throws BaseException {
		this.isRangoNumerico = isRangoNumerico;
	}

	public static final String PREFIJO_TITULO = "TITU_";

	List listaRangosValores = null;

	public static String NICKNAME = "ge.ClasificadorEntidad";

	private List valorClasificador = new ArrayList();
	private boolean readValoresClasificador = true;

	private List valoresTitulos = new ArrayList();
	private boolean readValoresTitulos = true;

	private String codigo;
	private String descripcion;
	private String nickname;
	private Boolean obligatorio;
	private Integer valor_default;
	private Boolean activo;
	private Integer nroClasif;
	private GrupoClasificadorEntidad grupoClasifEnt;

	public GrupoClasificadorEntidad getGrupo() throws BaseException {
		supportRefresh();
		return grupoClasifEnt;
	}

	public void setGrupoClasificadorEntidad(GrupoClasificadorEntidad aGrupo) {
		this.grupoClasifEnt = aGrupo;
	}

	public Integer getNroClasif() throws BaseException {
		supportRefresh();
		return nroClasif;
	}

	public void setNroClasif(Integer aNroClasif) {
		this.nroClasif = aNroClasif;
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

	public String getNickname() throws BaseException {
		supportRefresh();
		return nickname;
	}

	public void setNickname(String aNickname) {
		this.nickname = aNickname;
	}

	public Boolean isObligatorio() throws BaseException {
		supportRefresh();
		return obligatorio;
	}

	public void setObligatorio(Boolean aObligatorio) {
		this.obligatorio = aObligatorio;
	}

	public Integer getValor_default() throws BaseException {
		supportRefresh();
		return valor_default;
	}

	public void setValor_default(Integer aValor_default) {
		this.valor_default = aValor_default;
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

	public static ClasificadorEntidad findByOid(Integer oid, ISesion aSesion)
			throws BaseException {
		return (ClasificadorEntidad) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static ClasificadorEntidad findByOidProxy(Integer oid,
			ISesion aSesion) throws BaseException {
		return (ClasificadorEntidad) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}

	public static ClasificadorEntidad findByCodigo(String codigo,
			ISesion aSesion) throws BaseException {
		return (ClasificadorEntidad) getObjectByCodigo(NICKNAME, codigo,
				aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(codigo, "Debe ingresar el Código");
		Validar.noNulo(descripcion, "Debe ingresar la Descripción");
		Validar.noNulo(nickname, "Debe ingresar la Entidad");
		Validar.noNulo(obligatorio, "Debe ingresar si es o no obligatorio");
		Validar.noNulo(valor_default, "Debe ingresar el Valor por Defecto");
		Validar.noNulo(grupoClasifEnt, "Debe ingresar el Grupo");

	}

	public List getValoresClasificador() throws BaseException {
		if (readValoresClasificador) {
			List listaValoresClasificador = ValorClasificadorEntidad
					.getValoresClasifEntidad(this, getSesion());
			valorClasificador.addAll(listaValoresClasificador);
			readValoresClasificador = false;
		}
		return valorClasificador;
	}

	public List getValoresClasificador(String filtroCodigo,
			String filtroDescripcion) throws BaseException {
		if (readValoresClasificador) {
			List listaValoresClasificador = ValorClasificadorEntidad
					.getValoresClasifEntidad(this, filtroCodigo,
							filtroDescripcion, getSesion());
			valorClasificador.addAll(listaValoresClasificador);
			readValoresClasificador = false;
		}
		return valorClasificador;
	}

	public List getValoresClasificadorTitulos(boolean soloActivos) throws BaseException {
		if (readValoresTitulos) {
			List listaValoresTitulos = ValorClasificadorEntidad
					.getValoresClasifEntidadSoloTitulos(this, soloActivos,  getSesion());
			valoresTitulos.addAll(listaValoresTitulos);
			readValoresTitulos = false;
		}
		return valoresTitulos;
	}

	public List getValoresClasificadorTitulos(String buscarPorCodigo,
			String buscarPorDesc, boolean soloActivos) throws BaseException {
		if (readValoresTitulos) {
			List listaValoresTitulos = ValorClasificadorEntidad
					.getValoresClasifEntidadSoloTitulos(this, buscarPorCodigo,
							buscarPorDesc, soloActivos,getSesion());
			valoresTitulos.addAll(listaValoresTitulos);
			readValoresTitulos = false;
		}
		return valoresTitulos;
	}

	public void addValorClasificador(ValorClasificadorEntidad aValorClasificador)
			throws BaseException {
		aValorClasificador.setClasificador_entidad(this);
		valorClasificador.add(aValorClasificador);
	}

	public void afterSave() throws BaseException {
		Iterator iterValorClasificador = valorClasificador.iterator();
		while (iterValorClasificador.hasNext()) {
			ValorClasificadorEntidad valorClasificadorEntidad = (ValorClasificadorEntidad) iterValorClasificador
					.next();
			valorClasificadorEntidad.save();
			valorClasificadorEntidad = null;
		}
		iterValorClasificador = null;
	}

	public ValorClasificadorEntidad getValorDfault() throws BaseException {
		ValorClasificadorEntidad valClasifEnt = ValorClasificadorEntidad
				.getValorClasificadorEntidad(this, this.getValor_default(),
						getSesion());
		return valClasifEnt;
	}

	public static List getClasificadoresEntidad(String nickname,
			boolean orderByOidClasifEnt, ISesion aSesion) throws BaseException {
		return DBClasificadorEntidad.getClasificadoresEntidad(nickname, false,
				aSesion);
	}

	public int getUltNroClasifCreado() throws BaseException {
		Iterator iterClasif = this.getClasificadoresEntidad(getNickname(),
				false, getSesion()).iterator();
		int maxNro = 0;
		while (iterClasif.hasNext()) {
			ClasificadorEntidad clasifEnt = (ClasificadorEntidad) iterClasif
					.next();
			if (clasifEnt.getNroClasif().intValue() > maxNro)
				maxNro = clasifEnt.getNroClasif().intValue();
		}
		return maxNro;
	}

	public ValorClasificadorEntidad getValorClasifEnt(String codigo)
			throws BaseException {
		return ValorClasificadorEntidad.getValorClasifEnt(this, codigo,
				getSesion());
	}

	public ValorClasificadorEntidad getValorClasifEnt(Integer oidItem)
			throws BaseException {
		return ValorClasificadorEntidad.getValorClasificadorEntidad(this,
				oidItem, getSesion());
	}

	public static ClasificadorEntidad getClasificadorEntidad(String nickname,
			Integer nroClasificador, ISesion aSesion) throws BaseException {
		return DBClasificadorEntidad.getClasificadorEntidad(nickname,
				nroClasificador, aSesion);
	}

	public List getListaRangosValores() throws BaseException {
		if (listaRangosValores == null)
			listaRangosValores = ValorClasificadorEntidad
					.getRangosValoresClasifEntidad(this, getSesion());
		return listaRangosValores;
	}

	public IValorClasificadorEntidad getValorClasificador(
			IEntidadClasificable entidadClasificable) throws BaseException {

		// Buscar si la entidad se encuentra clasificada
		IValorClasificadorEntidad valClasif = entidadClasificable
				.getValorClasifEnt(this);
		if (valClasif != null)
			return valClasif;

		// Buscar si la entidad se encuentra clasificada en algun Rango
		Iterator iterRangoValores = getListaRangosValores().iterator();
		while (iterRangoValores.hasNext()) {
			ValorClasificadorEntidad valorClasifEntidad = (ValorClasificadorEntidad) iterRangoValores
					.next();
			if (isRangoNumerico) {
				Integer codigoDesde = new Integer(valorClasifEntidad
						.getCodigoDesde());
				Integer codigoHasta = new Integer(valorClasifEntidad
						.getCodigoHasta());
				Integer codigoNum = new Integer(entidadClasificable.getCodigo());
				if ((codigoNum.intValue() >= codigoDesde.intValue())
						&& (codigoNum.intValue() <= codigoHasta.intValue()))
					return valorClasifEntidad;
			} else {
				// Falta Implementar que si no es condigo Numero

			}
		}
		return null;
	}

	public String getNroClasifFomateado() throws BaseException {
		if (this.getNroClasif().toString().length() == 1)
			return "0" + this.getNroClasif().toString();
		else
			return this.getNroClasif().toString();
	}

	public String getCampoFisico() throws BaseException {
		return "OID_CLASIF_" + this.getNroClasifFomateado();
	}

	public static ClasificadorEntidad getClasifProd1ParaContaVta(ISesion aSesion)
			throws BaseException {
		Integer oidClasifProd = ValorParametro.findByCodigoParametro(
				"CLASIF_PROD_1_VTAS", aSesion).getOidObjNeg();
		ClasificadorEntidad clasifEnt = ClasificadorEntidad.findByOid(
				oidClasifProd, aSesion);
		return clasifEnt;
	}

	public static ClasificadorEntidad getClasifTitulosLPProdGral(ISesion aSesion)
			throws BaseException {
		Integer oidClasifProd = ValorParametro.findByCodigoParametro(
				"CLASIF_TIT_LP_PROD_GRAL", aSesion).getOidObjNeg();
		ClasificadorEntidad clasifEnt = ClasificadorEntidad.findByOid(
				oidClasifProd, aSesion);
		return clasifEnt;
	}

	public int getUltNroItem() throws BaseException {
		return DBClasificadorEntidad.getUltimoNroItem(this.getSesion(), this
				.getOIDInteger());
	}

	public static List getClasificadoresEntidadActivos(String nickname,
			boolean orderByOidClasifEnt, ISesion aSesion) throws BaseException {
		return DBClasificadorEntidad.getClasificadoresEntidadActivos(nickname,
				orderByOidClasifEnt, aSesion);
	}
	
	public ConfGenMasProd getConfGenMasProd()
		throws BaseException {
		return ConfGenMasProd.getConfGenMasProd(this,this.getSesion());
	}
	
	public static List getClasifProdStockYGralActivos(ISesion aSesion) throws BaseException {
		return DBClasificadorEntidad.getClasifProdStockYGralActivos(aSesion);
	}
	
	public static ClasificadorEntidad getClasif1ImpOCMatriz(ISesion aSesion)
	throws BaseException {
		Integer oidClasifProd = ValorParametro.findByCodigoParametro(
				"CLASIF_ART_1_IMP_OC_MATRI", aSesion).getOidObjNeg();
		ClasificadorEntidad clasifEnt = ClasificadorEntidad.findByOid(
				oidClasifProd, aSesion);
		return clasifEnt;
	}
	
	public static ClasificadorEntidad getClasif2ImpOCMatriz(ISesion aSesion)
	throws BaseException {
		Integer oidClasifProd = ValorParametro.findByCodigoParametro(
				"CLASIF_ART_2_IMP_OC_MATRI", aSesion).getOidObjNeg();
		ClasificadorEntidad clasifEnt = ClasificadorEntidad.findByOid(
				oidClasifProd, aSesion);
		return clasifEnt;
	}	
	
	
	

}
