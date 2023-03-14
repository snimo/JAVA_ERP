package com.srn.erp.rrhh.bm;

import java.util.List;

import com.srn.erp.general.bm.ValorClasificadorEntidad;
import com.srn.erp.rrhh.da.DBEstadoAccCroDesa;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class EstadoAccCroDesa extends ObjetoLogico {

	public EstadoAccCroDesa() {
	}

	public static String NICKNAME = "rh.EstadoAccCroDesa";

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	private AccCronoDesa accion;
	private ValorClasificadorEntidad valor_clasif_estado;
	private Boolean activo;

	public AccCronoDesa getAccion() throws BaseException {
		supportRefresh();
		return accion;
	}

	public void setAccion(AccCronoDesa aAccion) {
		this.accion = aAccion;
	}

	public ValorClasificadorEntidad getValor_clasif_estado() throws BaseException {
		supportRefresh();
		return valor_clasif_estado;
	}

	public void setValor_clasif_estado(ValorClasificadorEntidad aValor_clasif_estado) {
		this.valor_clasif_estado = aValor_clasif_estado;
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

	public static EstadoAccCroDesa findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (EstadoAccCroDesa) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static EstadoAccCroDesa findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (EstadoAccCroDesa) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(accion, "Debe ingresar la Acción");
		Validar.noNulo(valor_clasif_estado, "Debe ingresar el Estado");
	}
	
	  
	public static EstadoAccCroDesa getEstadoAccCroDesa(AccCronoDesa accCronoDesa,
			  ValorClasificadorEntidad valorClasifEntEst,
	          ISesion aSesion)
	          throws BaseException {
		  return DBEstadoAccCroDesa.getEstadoAccCroDesa(accCronoDesa,valorClasifEntEst,aSesion);
	}
	
	public static List getEstados(AccCronoDesa aAccCronoDesa,
	          ISesion aSesion) throws BaseException {
		  return DBEstadoAccCroDesa.getEstados(aAccCronoDesa,aSesion);
	}
	  	

}
