package com.srn.erp.excluidos.bm;

import com.srn.erp.excluidos.da.DBExcluidoConsMas;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bm.Parametros.ValorParametro;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class ExcluidoConsMas extends ObjetoLogico {

	public static final String NRO_LOTE_CONS_EXC = "NRO_LOTE_CONS_EXC";

	public ExcluidoConsMas() {
	}

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public static String NICKNAME = "exc.ExcluidoConsMas";

	private IndividuoExcluido individuo;
	private Integer nro_lote;
	private Integer nro_orden;
	private java.util.Date fecha;
	private Boolean activo;

	public IndividuoExcluido getIndividuo() throws BaseException {
		supportRefresh();
		return individuo;
	}

	public void setIndividuo(IndividuoExcluido aIndividuo) {
		this.individuo = aIndividuo;
	}

	public Integer getNro_lote() throws BaseException {
		supportRefresh();
		return nro_lote;
	}

	public void setNro_lote(Integer aNro_lote) {
		this.nro_lote = aNro_lote;
	}

	public Integer getNro_orden() throws BaseException {
		supportRefresh();
		return nro_orden;
	}

	public void setNro_orden(Integer aNro_orden) {
		this.nro_orden = aNro_orden;
	}

	public java.util.Date getFecha() throws BaseException {
		supportRefresh();
		return fecha;
	}

	public void setFecha(java.util.Date aFecha) {
		this.fecha = aFecha;
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

	public static ExcluidoConsMas findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (ExcluidoConsMas) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static ExcluidoConsMas findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (ExcluidoConsMas) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(individuo, "Debe ingresar el Individuo");
		Validar.noNulo(nro_lote, "Debe ingresar el Nro. de Lote");
		Validar.noNulo(nro_orden, "Debe ingresar el Nro. de Orden");
		Validar.noNulo(fecha, "Debe ingresar la Fecha");
	}

	public static Integer getCantRegLote(ISesion aSesion) throws BaseException {
		return ValorParametro.findByCodigoParametro("CANT_REG_LOTE_CONS_EXC", aSesion).getValorEntero();
	}

	public static void borrarConsultasViejas(java.util.Date fecha, ISesion aSesion) throws BaseException {
		DBExcluidoConsMas.borrarConsultasViejas(fecha, aSesion);
	}

}
