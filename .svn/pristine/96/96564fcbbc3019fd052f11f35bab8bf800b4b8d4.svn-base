package com.srn.erp.ctasACobrar.bm;

import java.util.List;

import com.srn.erp.ctacte.bm.TipoCtaCteClie;
import com.srn.erp.ctasACobrar.da.DBConsultaAplicCtaCteClie;
import com.srn.erp.general.bm.ComproCab;
import com.srn.erp.general.bm.Moneda;
import com.srn.erp.ventas.bm.Sujeto;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;

public class ConsultaAplicCtaCteClie extends ObjetoLogico {

	public ConsultaAplicCtaCteClie() {
	}

	public static String NICKNAME = "cac.ConsultaAplicCtaCteClie";

	private Sujeto sujeto;

	private Integer oid_cco_apl;

	private String tc_ext_apl;

	private String letra_apl;

	private Integer lug_emi_apl;

	private Integer nro_ext_apl;

	private java.util.Date emision;

	private java.util.Date imputac;

	private Integer oid_cco_apl_aux;

	private String tc_ext_apl_aux;

	private String letra_apl_aux;

	private Integer lug_emi_apl_aux;

	private Integer nro_ext_apl_aux;

	private TranClieVto tran_vto;

	private TipoCtaCteClie tipo_cta_clie;

	private Double importe;
	
	private Moneda moneda;
	
	private Boolean allowDesaplicar;
	
	public Moneda getMoneda() throws BaseException {
		supportRefresh();
		return moneda;
	}

	public void setMoneda(Moneda aMoneda) {
		this.moneda = aMoneda;
	}
	
	public void setAllowDesaplicar(Boolean aAllowDesaplicar) {
		this.allowDesaplicar = aAllowDesaplicar;
	}
	
	

	public Sujeto getSujeto() throws BaseException {
		supportRefresh();
		return sujeto;
	}

	public void setSujeto(Sujeto aSujeto) {
		this.sujeto = aSujeto;
	}

	public Integer getOid_cco_apl() throws BaseException {
		supportRefresh();
		return oid_cco_apl;
	}

	public void setOid_cco_apl(Integer aOid_cco_apl) {
		this.oid_cco_apl = aOid_cco_apl;
	}

	public String getTc_ext_apl() throws BaseException {
		supportRefresh();
		return tc_ext_apl;
	}

	public void setTc_ext_apl(String aTc_ext_apl) {
		this.tc_ext_apl = aTc_ext_apl;
	}

	public String getLetra_apl() throws BaseException {
		supportRefresh();
		return letra_apl;
	}

	public void setLetra_apl(String aLetra_apl) {
		this.letra_apl = aLetra_apl;
	}

	public Integer getLug_emi_apl() throws BaseException {
		supportRefresh();
		return lug_emi_apl;
	}

	public void setLug_emi_apl(Integer aLug_emi_apl) {
		this.lug_emi_apl = aLug_emi_apl;
	}

	public Integer getNro_ext_apl() throws BaseException {
		supportRefresh();
		return nro_ext_apl;
	}

	public void setNro_ext_apl(Integer aNro_ext_apl) {
		this.nro_ext_apl = aNro_ext_apl;
	}

	public java.util.Date getEmision() throws BaseException {
		supportRefresh();
		return emision;
	}

	public void setEmision(java.util.Date aEmision) {
		this.emision = aEmision;
	}

	public java.util.Date getImputac() throws BaseException {
		supportRefresh();
		return imputac;
	}

	public void setImputac(java.util.Date aImputac) {
		this.imputac = aImputac;
	}

	public Integer getOid_cco_apl_aux() throws BaseException {
		supportRefresh();
		return oid_cco_apl_aux;
	}

	public void setOid_cco_apl_aux(Integer aOid_cco_apl_aux) {
		this.oid_cco_apl_aux = aOid_cco_apl_aux;
	}

	public String getTc_ext_apl_aux() throws BaseException {
		supportRefresh();
		return tc_ext_apl_aux;
	}

	public void setTc_ext_apl_aux(String aTc_ext_apl_aux) {
		this.tc_ext_apl_aux = aTc_ext_apl_aux;
	}

	public String getLetra_apl_aux() throws BaseException {
		supportRefresh();
		return letra_apl_aux;
	}

	public void setLetra_apl_aux(String aLetra_apl_aux) {
		this.letra_apl_aux = aLetra_apl_aux;
	}

	public Integer getLug_emi_apl_aux() throws BaseException {
		supportRefresh();
		return lug_emi_apl_aux;
	}

	public void setLug_emi_apl_aux(Integer aLug_emi_apl_aux) {
		this.lug_emi_apl_aux = aLug_emi_apl_aux;
	}

	public Integer getNro_ext_apl_aux() throws BaseException {
		supportRefresh();
		return nro_ext_apl_aux;
	}

	public void setNro_ext_apl_aux(Integer aNro_ext_apl_aux) {
		this.nro_ext_apl_aux = aNro_ext_apl_aux;
	}

	public TranClieVto getTran_vto() throws BaseException {
		supportRefresh();
		return tran_vto;
	}

	public void setTran_vto(TranClieVto aTran_vto) {
		this.tran_vto = aTran_vto;
	}

	public TipoCtaCteClie getTipo_cta_clie() throws BaseException {
		supportRefresh();
		return tipo_cta_clie;
	}

	public void setTipo_cta_clie(TipoCtaCteClie aTipo_cta_clie) {
		this.tipo_cta_clie = aTipo_cta_clie;
	}

	public Double getImporte() throws BaseException {
		supportRefresh();
		return importe;
	}

	public void setImporte(Double aImporte) {
		this.importe = aImporte;
	}

	public String getNickName() {
		return NICKNAME;
	}

	public static ConsultaAplicCtaCteClie findByOid(Integer oid, ISesion aSesion)
			throws BaseException {
		return (ConsultaAplicCtaCteClie) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static ConsultaAplicCtaCteClie findByCodigo(String codigo,
			ISesion aSesion) throws BaseException {
		return (ConsultaAplicCtaCteClie) getObjectByCodigo(NICKNAME, codigo,
				aSesion);
	}

	public void beforeSave() throws BaseException {
	}

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

	public static List getConsAplic(Sujeto sujeto,
			TipoCtaCteClie tipoCtaCteClie, java.util.Date fechaDesde,
			java.util.Date fechaHasta, ISesion aSesion) throws BaseException {
		return DBConsultaAplicCtaCteClie.getConsAplic(sujeto,
				tipoCtaCteClie, fechaDesde, fechaHasta, aSesion);
	}

	public String getCodigoAplicacion() throws BaseException {
		return ComproCab.getFormatoCompro(getTc_ext_apl(), getLetra_apl(),
				getLug_emi_apl(), getNro_ext_apl());
	}
	
	public String getCodigoAplicacionAux() throws BaseException {
		return ComproCab.getFormatoCompro(getTc_ext_apl_aux(), getLetra_apl_aux(),
				getLug_emi_apl_aux(), getNro_ext_apl_aux());
	}	
	
	public Boolean isAllowDesaplicar() throws BaseException {
		supportRefresh();
		return this.allowDesaplicar;
	}

}
