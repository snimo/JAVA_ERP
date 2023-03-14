package com.srn.erp.excluidos.bm;

import java.util.List;

import com.srn.erp.excluidos.da.DBDifImporteExcluido;
import com.srn.erp.general.bm.Moneda;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class DifImporteExcluido extends ObjetoLogico {

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public DifImporteExcluido() {
	}

	public static String NICKNAME = "exc.DifImporteExcluido";

	private IndividuoExcluido individuo;
	private java.util.Date fecha;
	private MotDifPagoExc motivo;
	private Moneda moneda;
	private Double monto;
	private String observacion;
	private Integer orden;
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

	public MotDifPagoExc getMotivo() throws BaseException {
		supportRefresh();
		return motivo;
	}

	public void setMotivo(MotDifPagoExc aMotivo) {
		this.motivo = aMotivo;
	}

	public Moneda getMoneda() throws BaseException {
		supportRefresh();
		return moneda;
	}

	public void setMoneda(Moneda aMoneda) {
		this.moneda = aMoneda;
	}

	public Double getMonto() throws BaseException {
		supportRefresh();
		return monto;
	}

	public void setMonto(Double aMonto) {
		this.monto = aMonto;
	}

	public String getObservacion() throws BaseException {
		supportRefresh();
		return observacion;
	}

	public void setObservacion(String aObservacion) {
		this.observacion = aObservacion;
	}

	public Integer getOrden() throws BaseException {
		supportRefresh();
		return orden;
	}

	public void setOrden(Integer aOrden) {
		this.orden = aOrden;
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

	public static DifImporteExcluido findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (DifImporteExcluido) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static DifImporteExcluido findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (DifImporteExcluido) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(individuo, " ");
		Validar.noNulo(predio, "Debe ingresar el predio en la Diferencia de Importes ");
	}

	public static List getDifImportesExcluidos(IndividuoExcluido individuo, ISesion aSesion) throws BaseException {
		return DBDifImporteExcluido.getDifImportesExcluidos(individuo, aSesion);
	}

}
