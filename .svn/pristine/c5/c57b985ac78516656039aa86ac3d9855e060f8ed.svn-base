package com.srn.erp.contabilidad.bm;

import java.util.List;

import com.srn.erp.contabilidad.da.DBAtributoEntidadSeleccionado;
import com.srn.erp.general.bm.DefinicionAtributoEntidad;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class AtributoEntidadSeleccionado extends ObjetoLogico {

	public Boolean isActivo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public AtributoEntidadSeleccionado() {
	}

	public static String NICKNAME = "cg.AtributoEntidadSeleccionado";

	private CriterioSelCuenta criterio_seleccion_cta;

	private DefinicionAtributoEntidad atributo_entidad;
	
    private Integer orden;

    
	public Integer getOrden() throws BaseException {
		supportRefresh();
		return orden;
	}

	public void setOrden(Integer aOrden) {
		this.orden = aOrden;
	}    
    
	public CriterioSelCuenta getCriterio_seleccion_cta() throws BaseException {
		supportRefresh();
		return criterio_seleccion_cta;
	}

	public void setCriterio_seleccion_cta(
			CriterioSelCuenta aCriterio_seleccion_cta) {
		this.criterio_seleccion_cta = aCriterio_seleccion_cta;
	}

	public DefinicionAtributoEntidad getAtributo_entidad() throws BaseException {
		supportRefresh();
		return atributo_entidad;
	}

	public void setAtributo_entidad(DefinicionAtributoEntidad aAtributo_entidad) {
		this.atributo_entidad = aAtributo_entidad;
	}

	public String getNickName() {
		return NICKNAME;
	}

	public static AtributoEntidadSeleccionado findByOid(Integer oid,
			ISesion aSesion) throws BaseException {
		return (AtributoEntidadSeleccionado) getObjectByOid(NICKNAME, oid,
				aSesion);
	}

	public static AtributoEntidadSeleccionado findByCodigo(String codigo,
			ISesion aSesion) throws BaseException {
		return (AtributoEntidadSeleccionado) getObjectByCodigo(NICKNAME,
				codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(criterio_seleccion_cta,
				"Debe ingresar el criterio de Selección");
		Validar.noNulo(atributo_entidad, "Debe ingresar el Atributo");
		Validar.noNulo(orden,"Debe ingresar el Nro. de Orden");
	}

	public static List getAtributosSeleccionados(
			CriterioSelCuenta criterioSelCuenta, ISesion aSesion)
			throws BaseException {
		return DBAtributoEntidadSeleccionado.getAtributosSeleccionados(
				criterioSelCuenta, aSesion);
	}

}
