package com.srn.erp.conciTarjeta.bm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.conciTarjeta.da.DBCabAsiTarjACobrar;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;
import framework.request.bl.Utils.Validar;

public class CabAsiTarjACobrar extends ObjetoLogico {

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public CabAsiTarjACobrar() {
	}

	private List detallesAsiento = new ArrayList();
	private boolean readDetallesAsientos = true;

	public static String NICKNAME = "ctar.CabAsiTarjACobrar";

	private java.util.Date fec_asiento;
	private String comentario;
	private Integer nro_liquidacion;
	private Boolean arch_interfaz_gen;
	private java.util.Date fec_arch_interfaz;
	private Boolean activo;
	private String hora_arch_interfaz;
	private Boolean conta_sist_ext;
	private java.util.Date fec_conta_sist_ext;
	private String hor_conta_sist_ext;
	private EmpresaConciTar empresa; 

	public java.util.Date getFec_asiento() throws BaseException {
		supportRefresh();
		return fec_asiento;
	}

	public void setFec_asiento(java.util.Date aFec_asiento) {
		this.fec_asiento = aFec_asiento;
	}
	
	public EmpresaConciTar getEmpresa() throws BaseException {
		supportRefresh();
		return this.empresa;
	}

	public void setEmpresa(EmpresaConciTar aEmpresa) {
		this.empresa = aEmpresa;
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

	public Boolean isActivo() throws BaseException {
		supportRefresh();
		return activo;
	}

	public void setActivo(Boolean aActivo) {
		this.activo = aActivo;
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

	public String getNickName() {
		return NICKNAME;
	}

	public static CabAsiTarjACobrar findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (CabAsiTarjACobrar) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static CabAsiTarjACobrar findByOidProxy(Integer oid, ISesion aSesion) throws BaseException {
		return (CabAsiTarjACobrar) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}

	public static CabAsiTarjACobrar findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (CabAsiTarjACobrar) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(fec_asiento, "Debe ingresar la Fecha");
	}

	public List getDetallesAsiento() throws BaseException {
		if (this.readDetallesAsientos) {
			List listaDetalles = DetAsiTarjACobrar.getDetallesAsiento(this, getSesion());
			this.detallesAsiento.clear();
			this.detallesAsiento.addAll(listaDetalles);
			readDetallesAsientos = false;
		}
		return detallesAsiento;
	}

	public void addDetalle(DetAsiTarjACobrar aDetAsiTarjACobrar) throws BaseException {
		aDetAsiTarjACobrar.setCab_asi_acob(this);
		detallesAsiento.add(aDetAsiTarjACobrar);
	}

	public void afterSave() throws BaseException {
		Iterator iterDetalles = detallesAsiento.iterator();
		while (iterDetalles.hasNext()) {
			DetAsiTarjACobrar detAsiTarjACobrar = (DetAsiTarjACobrar) iterDetalles.next();
			detAsiTarjACobrar.save();
			detAsiTarjACobrar = null;
		}
		iterDetalles = null;
	}

	public void anularAsiento() throws BaseException {

		// Desmacar los cupones del POSNET asociados al siento

		if (!this.isActivo())
			throw new ExceptionValidation(null, "El asiento de cobranza seleccionado ya se encuentra anulado.");

		Iterator iterDetCupo = ArchLoteConciDet.getArchLoteDetContaConSegunNroAsi(this.getOIDInteger(), this.getSesion()).iterator();
		while (iterDetCupo.hasNext()) {
			ArchLoteConciDet archLoteConciDet = (ArchLoteConciDet) iterDetCupo.next();

			if (!archLoteConciDet.isActivo())
				continue;

			if (archLoteConciDet.isContaAsiLiq())
				throw new ExceptionValidation(null, "No se puede anular el asiento porque se encuentra contabilizada la liquidación.");

			archLoteConciDet.setAsientoACobrar(null);
			archLoteConciDet.setContaAsiACobrar(false);
			archLoteConciDet.setRefSistExt("");
			archLoteConciDet.save();
		}

		if (!this.isActivo())
			throw new ExceptionValidation(null, "El asiento ya se encuentra anulado.");

		// Anular asiento
		this.delete();
		this.save();

		// Anular los Detalles del Asiento
		Iterator iterDetAsientos = this.getDetallesAsiento().iterator();
		while (iterDetAsientos.hasNext()) {
			DetAsiTarjACobrar detAsiTarjACobrar = (DetAsiTarjACobrar) iterDetAsientos.next();
			detAsiTarjACobrar.delete();
			detAsiTarjACobrar.save();
		}

	}

	public static List getAsientosByFechas(java.util.Date fecDesde, java.util.Date fecHasta, ISesion aSesion) throws BaseException {
		return DBCabAsiTarjACobrar.getAsientosByFechas(fecDesde, fecHasta, aSesion);
	}
	

}
