package com.srn.erp.reclutamiento.bm;

import java.util.List;

import com.srn.erp.reclutamiento.da.DBRecluPuestoAplica;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class RecluPuestoAplica extends ObjetoLogico {

	public RecluPuestoAplica() {
	}

	public static String NICKNAME = "rs.RecluPuestoAplica";

	@Override
	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	private RecluPostulante postulante;
	private RecluPuesto puesto;
	private Boolean activo;

	public RecluPostulante getPostulante() throws BaseException {
		supportRefresh();
		return postulante;
	}

	public void setPostulante(RecluPostulante aPostulante) {
		this.postulante = aPostulante;
	}

	public RecluPuesto getPuesto() throws BaseException {
		supportRefresh();
		return puesto;
	}

	public void setPuesto(RecluPuesto aPuesto) {
		this.puesto = aPuesto;
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

	public static RecluPuestoAplica findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (RecluPuestoAplica) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static RecluPuestoAplica findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (RecluPuestoAplica) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(postulante, "Debe ingresar el Postulante");
		Validar.noNulo(puesto, "Debe ingresar el Puesto");
	}
	
	public static List getPuestosAplica(RecluPostulante postulante,
	          ISesion aSesion) throws BaseException {
		  return DBRecluPuestoAplica.getPuestosAplica(postulante,aSesion);
	}	

}
