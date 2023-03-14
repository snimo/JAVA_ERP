package com.srn.erp.excluidos.bm;

import java.util.List;

import com.srn.erp.excluidos.da.DBEstadoPredioExc;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class EstadoPredioExc extends ObjetoLogico {

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public EstadoPredioExc() {
	}

	public static String NICKNAME = "exc.EstadoPredioExc";

	private EstadoExcluido estado;
	private PredioExcluido predio;
	private Boolean proponer_nro;
	private Integer ult_nro_propu;
	private Boolean nro_acta_obli;
	private Boolean permite_modif_nro;
	private Boolean activo;
	private Boolean conserva_nro;

	public EstadoExcluido getEstado() throws BaseException {
		supportRefresh();
		return estado;
	}

	public void setEstado(EstadoExcluido aEstado) {
		this.estado = aEstado;
	}

	public PredioExcluido getPredio() throws BaseException {
		supportRefresh();
		return predio;
	}

	public void setPredio(PredioExcluido aPredio) {
		this.predio = aPredio;
	}

	public Boolean getProponer_nro() throws BaseException {
		supportRefresh();
		return proponer_nro;
	}

	public void setProponer_nro(Boolean aProponer_nro) {
		this.proponer_nro = aProponer_nro;
	}

	public Integer getUlt_nro_propu() throws BaseException {
		supportRefresh();
		return ult_nro_propu;
	}

	public void setUlt_nro_propu(Integer aUlt_nro_propu) {
		this.ult_nro_propu = aUlt_nro_propu;
	}

	public Boolean getNro_acta_obli() throws BaseException {
		supportRefresh();
		return nro_acta_obli;
	}

	public void setNro_acta_obli(Boolean aNro_acta_obli) {
		this.nro_acta_obli = aNro_acta_obli;
	}

	public Boolean getPermite_modif_nro() throws BaseException {
		supportRefresh();
		return permite_modif_nro;
	}

	public void setPermite_modif_nro(Boolean aPermite_modif_nro) {
		this.permite_modif_nro = aPermite_modif_nro;
	}

	public Boolean isActivo() throws BaseException {
		supportRefresh();
		return activo;
	}

	public void setActivo(Boolean aActivo) {
		this.activo = aActivo;
	}

	public Boolean getConserva_nro() throws BaseException {
		supportRefresh();
		return conserva_nro;
	}

	public void setConserva_nro(Boolean aConserva_nro) {
		this.conserva_nro = aConserva_nro;
	}

	public String getNickName() {
		return NICKNAME;
	}

	public static EstadoPredioExc findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (EstadoPredioExc) getObjectByOid(NICKNAME, oid, aSesion);
	}
	
	public static EstadoPredioExc findByOidProxy(Integer oid, ISesion aSesion) throws BaseException {
		return (EstadoPredioExc) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}
	

	public static EstadoPredioExc findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (EstadoPredioExc) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(estado, "Debe ingresar el estado");
		Validar.noNulo(predio, "Debe ingresar el Predio");
	}
	
	public static List getEstadosExcluidos(
			  	EstadoExcluido estado,
			  	ISesion aSesion) throws BaseException {
		return DBEstadoPredioExc.getEstadosExcluidos(estado, aSesion);
	}
		

}
