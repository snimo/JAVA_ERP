package com.srn.erp.contabilidad.bm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class ConceptoCtaContable extends ObjetoLogico {

	private List criterios = new ArrayList();

	private boolean readCriterios = true;

	public ConceptoCtaContable() {
	}

	public static String NICKNAME = "cg.ConceptoCtaContable";

	private String codigo;

	private String descripcion;

	private String nickname;

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

	public String getNickname() throws BaseException {
		supportRefresh();
		return nickname;
	}

	public void setNickname(String aNickname) {
		this.nickname = aNickname;
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

	public static ConceptoCtaContable findByOid(Integer oid, ISesion aSesion)
			throws BaseException {
		return (ConceptoCtaContable) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static ConceptoCtaContable findByOidProxy(Integer oid,
			ISesion aSesion) throws BaseException {
		return (ConceptoCtaContable) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}

	public static ConceptoCtaContable findByCodigo(String codigo,
			ISesion aSesion) throws BaseException {
		return (ConceptoCtaContable) getObjectByCodigo(NICKNAME, codigo,
				aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(codigo, "Debe ingresar el código");
		Validar.noNulo(descripcion, "Debe ingresar la Descripción");
		Validar.noNulo(nickname, "Debe ingresar el Comprobante");
	}

    public List getCriteriosSelCuenta() throws BaseException {
		    if (readCriterios) {
		      List listaCriterios = CriterioSelCuenta.getCriteriosByConcCta(this,getSesion());
		      criterios.addAll(listaCriterios);
		      readCriterios = false;
		    }
		    return criterios;
		  }	public void addCriterioSelCuenta(CriterioSelCuenta criterioSelCuenta)
			throws BaseException {
		criterioSelCuenta.setConcepto_cuenta(this);
		criterios.add(criterioSelCuenta);
	}

	public void afterSave() throws BaseException {
		Iterator iterCriteriosSelCuenta = criterios.iterator();
		while (iterCriteriosSelCuenta.hasNext()) {
			CriterioSelCuenta criterio = (CriterioSelCuenta) iterCriteriosSelCuenta
					.next();
			criterio.save();
			criterio = null;
		}
		iterCriteriosSelCuenta = null;
	}

}
