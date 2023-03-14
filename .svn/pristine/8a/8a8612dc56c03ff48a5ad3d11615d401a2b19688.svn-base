package com.srn.erp.conciTarjeta.bm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.conciTarjeta.da.DBArchLoteConciDet;
import com.srn.erp.conciTarjeta.da.DBCabAsiLiquiTarj;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class CabAsiLiquiTarj extends ObjetoLogico {

	public CabAsiLiquiTarj() {
	}

	public static String NICKNAME = "ctar.CabAsiLiquiTarj";

	private java.util.Date fec_asiento;
	private String comentario;
	private Integer nro_liquidacion;
	private Boolean arch_interfaz_gen;
	private java.util.Date fec_arch_interfaz;
	private String hora_arch_interfaz;
	private Boolean conta_sist_ext;
	private java.util.Date fec_conta_sist_ext;
	private String hor_conta_sist_ext;
	private TipoArchConciTar tipo_archivo;
	private Boolean activo;
	private CtaBancoLiqTarj ctaBcoLiqTarj;
	private CabModeloLiq cabModeloLiq;
	private EmpresaConciTar empresa;

	private List detalles = new ArrayList();
	private boolean readDetalles = true;

	public CabModeloLiq getCabModeloLiq() throws BaseException {
		supportRefresh();
		return this.cabModeloLiq;
	}

	public void setCabModeloLiq(CabModeloLiq aCabModeloLiq) throws BaseException {
		this.cabModeloLiq = aCabModeloLiq;
	}

	public java.util.Date getFec_asiento() throws BaseException {
		supportRefresh();
		return fec_asiento;
	}
	
	public void setEmpresa(EmpresaConciTar aEmpresa) throws BaseException {
		this.empresa = aEmpresa;
	}

	public EmpresaConciTar getEmpresa() throws BaseException {
		supportRefresh();
		return this.empresa;
	}	

	public CtaBancoLiqTarj getCtaBancoLiqTarj() throws BaseException {
		supportRefresh();
		return this.ctaBcoLiqTarj;
	}

	public void setFec_asiento(java.util.Date aFec_asiento) {
		this.fec_asiento = aFec_asiento;
	}

	public void setCtaBancoLiqTarj(CtaBancoLiqTarj aCtaBancoLiqTarj) {
		this.ctaBcoLiqTarj = aCtaBancoLiqTarj;
	}

	public String getComentario() throws BaseException {
		supportRefresh();
		return comentario;
	}

	public void setComentario(String aComentario) {
		this.comentario = aComentario;
	}

	public Integer getNro_liquidacion() throws BaseException {
		supportRefresh();
		return nro_liquidacion;
	}

	public void setNro_liquidacion(Integer aNro_liquidacion) {
		this.nro_liquidacion = aNro_liquidacion;
	}

	public Boolean isArch_interfaz_gen() throws BaseException {
		supportRefresh();
		return arch_interfaz_gen;
	}

	public void setArch_interfaz_gen(Boolean aArch_interfaz_gen) {
		this.arch_interfaz_gen = aArch_interfaz_gen;
	}

	public java.util.Date getFec_arch_interfaz() throws BaseException {
		supportRefresh();
		return fec_arch_interfaz;
	}

	public void setFec_arch_interfaz(java.util.Date aFec_arch_interfaz) {
		this.fec_arch_interfaz = aFec_arch_interfaz;
	}

	public String getHora_arch_interfaz() throws BaseException {
		supportRefresh();
		return hora_arch_interfaz;
	}

	public void setHora_arch_interfaz(String aHora_arch_interfaz) {
		this.hora_arch_interfaz = aHora_arch_interfaz;
	}

	public Boolean isConta_sist_ext() throws BaseException {
		supportRefresh();
		return conta_sist_ext;
	}

	public void setConta_sist_ext(Boolean aConta_sist_ext) {
		this.conta_sist_ext = aConta_sist_ext;
	}

	public java.util.Date getFec_conta_sist_ext() throws BaseException {
		supportRefresh();
		return fec_conta_sist_ext;
	}

	public void setFec_conta_sist_ext(java.util.Date aFec_conta_sist_ext) {
		this.fec_conta_sist_ext = aFec_conta_sist_ext;
	}

	public String getHor_conta_sist_ext() throws BaseException {
		supportRefresh();
		return hor_conta_sist_ext;
	}

	public void setHor_conta_sist_ext(String aHor_conta_sist_ext) {
		this.hor_conta_sist_ext = aHor_conta_sist_ext;
	}

	public TipoArchConciTar getTipo_archivo() throws BaseException {
		supportRefresh();
		return tipo_archivo;
	}

	public void setTipo_archivo(TipoArchConciTar aTipo_archivo) {
		this.tipo_archivo = aTipo_archivo;
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

	public static CabAsiLiquiTarj findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (CabAsiLiquiTarj) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static CabAsiLiquiTarj findByOidProxy(Integer oid, ISesion aSesion) throws BaseException {
		return (CabAsiLiquiTarj) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}

	public static CabAsiLiquiTarj findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (CabAsiLiquiTarj) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(fec_asiento, "Debe ingresar la Fecha");
		Validar.noNulo(nro_liquidacion, "Debe ingresar el Nro. de Liquidación");
		Validar.noNulo(ctaBcoLiqTarj, "Debe ingresar la Cuenta Bancaria");
	}

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public List getDetalles() throws BaseException {
		if (this.readDetalles) {
			List listaDetalles = DetAsiLiquiTarj.getDetAsiLiquiTarj(this, getSesion());
			detalles.addAll(listaDetalles);
			this.readDetalles = false;
		}
		return detalles;
	}

	public void addDetalle(DetAsiLiquiTarj aDetAsiLiquiTarj) throws BaseException {
		aDetAsiLiquiTarj.setCabasiliqtarj(this);
		detalles.add(aDetAsiLiquiTarj);
	}

	public void afterSave() throws BaseException {

		Iterator iterDetalles = detalles.iterator();
		while (iterDetalles.hasNext()) {
			DetAsiLiquiTarj detAsiLiquiTarj = (DetAsiLiquiTarj) iterDetalles.next();
			detAsiLiquiTarj.save();
			detAsiLiquiTarj = null;
		}
		iterDetalles = null;

	}

	public List getArchLoteDetAsiLiq() throws BaseException {
		return DBArchLoteConciDet.getArchLoteDetAsiLiq(this, this.getSesion());
	}

	public static List getAsientos(CabModeloLiq cabModeloLiq, java.util.Date fecha, Integer nroLiquidacion, ISesion aSesion)
			throws BaseException {
		return DBCabAsiLiquiTarj.getAsientos(cabModeloLiq, fecha, nroLiquidacion, aSesion);
	}

	public static List getAsientosByFechas(java.util.Date fechaDesde, java.util.Date fechaHasta, ISesion aSesion) throws BaseException {
		return DBCabAsiLiquiTarj.getAsientosByFechas(fechaDesde, fechaHasta, aSesion);
	}

}
