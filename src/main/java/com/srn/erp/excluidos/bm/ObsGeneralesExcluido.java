package com.srn.erp.excluidos.bm;

import java.util.List;

import com.srn.erp.excluidos.da.DBObsGeneralesExcluido;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class ObsGeneralesExcluido extends ObjetoLogico {

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public ObsGeneralesExcluido() {
	}

	public static String NICKNAME = "exc.ObsGeneralesExcluido";

	private IndividuoExcluido individuo;
	private java.util.Date fecha;
	private String observacion;
	private Boolean activo;
	private PredioExcluido predio;

	public IndividuoExcluido getIndividuo() throws BaseException {
		supportRefresh();
		return individuo;
	}
	
	public PredioExcluido getPredioExcluido() throws BaseException {
		supportRefresh();
		return predio;
	}	

	public void setIndividuo(IndividuoExcluido aIndividuo) {
		this.individuo = aIndividuo;
	}
	
	public void setPredioExcluido(PredioExcluido aPredio) {
		this.predio = aPredio;
	}	

	public java.util.Date getFecha() throws BaseException {
		supportRefresh();
		return fecha;
	}

	public void setFecha(java.util.Date aFecha) {
		this.fecha = aFecha;
	}

	public String getObservacion() throws BaseException {
		String result = "";
		supportRefresh();
		if (observacion==null)
			return "";
		else {
			result = observacion.replaceAll("\n", "¬c¬n");
			result = result.replaceAll("\r", "");
			return result;
		}
	}

	public void setObservacion(String aObservacion) {
		this.observacion = aObservacion;
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

	public static ObsGeneralesExcluido findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (ObsGeneralesExcluido) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static ObsGeneralesExcluido findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (ObsGeneralesExcluido) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(fecha, "Debe ingresar la Fecha");
		Validar.noNulo(predio, "Debe ingresar el Predio de la Observación General");
	}

	public static List getObsGenerales(IndividuoExcluido individuo, ISesion aSesion) throws BaseException {
		return DBObsGeneralesExcluido.getObsGenerales(individuo, aSesion);
	}

}
