package com.srn.erp.general.bm;

import java.util.List;

import com.srn.erp.general.da.DBTipoCambio;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bm.Parametros.ValorParametro;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class TipoCambio extends ObjetoLogico {

	public TipoCambio() {
	}

	public static String NICKNAME = "ge.TipoCambio";

	private String codigo;
	private String descripcion;
	private Boolean activo;

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

	public static TipoCambio findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (TipoCambio) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static TipoCambio findByOidProxy(Integer oid, ISesion aSesion) throws BaseException {
		return (TipoCambio) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}

	public static TipoCambio findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (TipoCambio) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(codigo, "Debe ingresar un código");
		Validar.noNulo(descripcion, "Debe ingresar la descripción");

		if (isNew() && (isActivo().booleanValue() == false))
			Validar.mensajeValidacion("El Tipo de Cambio debe estar em modo activo");

	}

	public static List getAllActivos(ISesion aSesion) throws BaseException {
		return DBTipoCambio.getAllActivos(aSesion);
	}

	public static TipoCambio getTipoCambioDefaultConta(ISesion aSesion) throws BaseException {
		ValorParametro valorTipoCambioConta = ValorParametro.findByCodigoParametro("TIPO_CAMBIO_CONTABILIDAD", aSesion);
		TipoCambio tipoCambio = TipoCambio.findByOid(valorTipoCambioConta.getOidObjNeg(), aSesion);
		return tipoCambio;
	}

	public static TipoCambio getTipoCambioTransferenciaValores(ISesion aSesion) throws BaseException {
		ValorParametro valorTipoCambio = ValorParametro.findByCodigoParametro("TIPO_CAMBIO_TRANS_VAL", aSesion);
		TipoCambio tipoCambio = TipoCambio.findByOid(valorTipoCambio.getOidObjNeg(), aSesion);
		return tipoCambio;
	}

	public static TipoCambio getTipoCambioVentaMostrador(ISesion aSesion) throws BaseException {
		ValorParametro valorTipoCambio = ValorParametro.findByCodigoParametro("TIPO_CAMBIO_VTA_MOSTRADOR", aSesion);
		TipoCambio tipoCambio = TipoCambio.findByOid(valorTipoCambio.getOidObjNeg(), aSesion);
		return tipoCambio;
	}

	public static TipoCambio getTipoCambioValorizStock(ISesion aSesion) throws BaseException {
		ValorParametro valorTipoCambio = ValorParametro.findByCodigoParametro("TIPO_CAMBIO_VALORIZ_STOCK", aSesion);
		TipoCambio tipoCambio = TipoCambio.findByOid(valorTipoCambio.getOidObjNeg(), aSesion);
		return tipoCambio;
	}

	public static TipoCambio getTipoCambioFormacionPrecio(ISesion aSesion) throws BaseException {
		ValorParametro valorTipoCambio = ValorParametro.findByCodigoParametro("TIPO_CAMBIO_FORM_PRECIO", aSesion);
		TipoCambio tipoCambio = TipoCambio.findByOid(valorTipoCambio.getOidObjNeg(), aSesion);
		return tipoCambio;
	}
	
	public static TipoCambio getTipoCambioOC(ISesion aSesion) throws BaseException {
		ValorParametro valorTipoCambio = ValorParametro.findByCodigoParametro("TIPO_CAMBIO_OC", aSesion);
		TipoCambio tipoCambio = TipoCambio.findByOid(valorTipoCambio.getOidObjNeg(), aSesion);
		return tipoCambio;
	}
	

	public static TipoCambio getTipoCambioCtaCteClie(ISesion aSesion) throws BaseException {
		ValorParametro valorTipoCambio = ValorParametro.findByCodigoParametro("TIPO_CAMBIO_CC_CLIE", aSesion);
		TipoCambio tipoCambio = TipoCambio.findByOid(valorTipoCambio.getOidObjNeg(), aSesion);
		return tipoCambio;
	}

	public static TipoCambio getTipoCambioCtaCteProv(ISesion aSesion) throws BaseException {
		ValorParametro valorTipoCambio = ValorParametro.findByCodigoParametro("TIPO_CAMBIO_CC_PROV", aSesion);
		TipoCambio tipoCambio = TipoCambio.findByOid(valorTipoCambio.getOidObjNeg(), aSesion);
		return tipoCambio;
	}

}
