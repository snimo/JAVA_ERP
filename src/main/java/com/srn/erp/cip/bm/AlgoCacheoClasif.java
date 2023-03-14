package com.srn.erp.cip.bm;

import java.util.List;

import com.srn.erp.cip.da.DBAlgoCacheoClasif;
import com.srn.erp.general.bm.ClasificadorEntidad;
import com.srn.erp.general.bm.ValorClasificadorEntidad;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class AlgoCacheoClasif extends ObjetoLogico {

	public AlgoCacheoClasif() {
	}

	public static String NICKNAME = "cip.AlgoCacheoClasif";

	private AlgoritmoCacheo algoritmo_cacheo;
	private ClasificadorEntidad clasificador;
	private ValorClasificadorEntidad valor_clasif;
	private String inc_exc;
	private Boolean activo;

	public AlgoritmoCacheo getAlgoritmo_cacheo() throws BaseException {
		supportRefresh();
		return algoritmo_cacheo;
	}

	public void setAlgoritmo_cacheo(AlgoritmoCacheo aAlgoritmo_cacheo) {
		this.algoritmo_cacheo = aAlgoritmo_cacheo;
	}

	public ClasificadorEntidad getClasificador() throws BaseException {
		supportRefresh();
		return clasificador;
	}

	public void setClasificador(ClasificadorEntidad aClasificador) {
		this.clasificador = aClasificador;
	}

	public ValorClasificadorEntidad getValor_clasif() throws BaseException {
		supportRefresh();
		return valor_clasif;
	}

	public void setValor_clasif(ValorClasificadorEntidad aValor_clasif) {
		this.valor_clasif = aValor_clasif;
	}

	public String getInc_exc() throws BaseException {
		supportRefresh();
		return inc_exc;
	}

	public void setInc_exc(String aInc_exc) {
		this.inc_exc = aInc_exc;
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

	public static AlgoCacheoClasif findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (AlgoCacheoClasif) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static AlgoCacheoClasif findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (AlgoCacheoClasif) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(algoritmo_cacheo, "Debe ingresar el Algoritmo Cacheo");
		Validar.noNulo(clasificador, "Debe ingresar el Clasificador");
		Validar.noNulo(valor_clasif, "Debe ingresar el Valor del Clasificador");
		Validar.noNulo(inc_exc, "Debe ingresar si es ingreso o egreso");
	}

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public static List getAlgoCacheoClasif(AlgoritmoCacheo algoritmo, ISesion aSesion) throws BaseException {
		return DBAlgoCacheoClasif.getAlgoCacheoClasif(algoritmo, aSesion);
	}
	
	public static List getAlgoCacheoClasifIncluidos(AlgoritmoCacheo algoritmo, ISesion aSesion) throws BaseException {
		return DBAlgoCacheoClasif.getAlgoCacheoClasifIncluidos(algoritmo, aSesion);
	}	
	
	public static List getAlgoCacheoClasifExcluidos(AlgoritmoCacheo algoritmo, ISesion aSesion) throws BaseException {
		return DBAlgoCacheoClasif.getAlgoCacheoClasifExcluidos(algoritmo, aSesion);
	}	
	

}
