package com.srn.erp.conciTarjeta.bm;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.conciTarjeta.da.DBCabTarConciEnt;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.Util;
import framework.applicarionServer.bm.Parametros.ValorParametro;
import framework.applicarionServer.bm.Seguridad.Usuario;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class CabTarConciEnt extends ObjetoLogico {

	public CabTarConciEnt() {
	}

	public static String NICKNAME = "ctar.CabTarConciEnt";

	private List detalles = new ArrayList();
	private boolean readDetalles = true;

	private java.util.Date fec_imp;
	private String hora_imp;
	private String nom_archivo;
	private EmpresaConciTar empresa;
	private Boolean activo;
	private String tipoArchivo;
	private String carpetaArchivo;
	private java.util.Date fecNomArchivo;
	private Usuario usuarioAlta;

	public java.util.Date getFec_imp() throws BaseException {
		supportRefresh();
		return fec_imp;
	}

	public java.util.Date getFecNomArchivo() throws BaseException {
		supportRefresh();
		return this.fecNomArchivo;
	}

	public String getCarpetaArchivo() throws BaseException {
		supportRefresh();
		return this.carpetaArchivo;
	}

	public Usuario getUsuarioAlta() throws BaseException {
		supportRefresh();
		return this.usuarioAlta;
	}

	public void setFec_imp(java.util.Date aFec_imp) {
		this.fec_imp = aFec_imp;
	}

	public void setUsuarioAlta(Usuario aUsuarioAlta) {
		this.usuarioAlta = aUsuarioAlta;
	}

	public void setFecNomArchivo(java.util.Date aFecNomArchivo) {
		this.fecNomArchivo = aFecNomArchivo;
	}

	public void setCarpetaArchivo(String aCarpetaArchivo) {
		this.carpetaArchivo = aCarpetaArchivo;
	}

	public String getTipoArchivo() throws BaseException {
		supportRefresh();
		return this.tipoArchivo;
	}

	public void setTipoArchivo(String aTipoArchivo) {
		this.tipoArchivo = aTipoArchivo;
	}

	public String getHora_imp() throws BaseException {
		supportRefresh();
		return hora_imp;
	}

	public void setHora_imp(String aHora_imp) {
		this.hora_imp = aHora_imp;
	}

	public String getNom_archivo() throws BaseException {
		supportRefresh();
		return nom_archivo;
	}

	public void setNom_archivo(String aNom_archivo) {
		this.nom_archivo = aNom_archivo;
	}

	public EmpresaConciTar getEmpresa() throws BaseException {
		supportRefresh();
		return empresa;
	}

	public void setEmpresa(EmpresaConciTar aEmpresa) {
		this.empresa = aEmpresa;
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

	public static CabTarConciEnt findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (CabTarConciEnt) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static CabTarConciEnt findByOidProxy(Integer oid, ISesion aSesion) throws BaseException {
		return (CabTarConciEnt) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}

	public static CabTarConciEnt findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (CabTarConciEnt) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(fec_imp, "Debe ingresar la Fecha");
		Validar.noNulo(hora_imp, "Debe ingresar la Hora");
		Validar.noNulo(nom_archivo, "Debe ingresar el Nombre del Archivo");
		Validar.noNulo(empresa, "Debe ingresar la Empresa");
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
			List listaDetalles = DetTarConciEnt.getDetalles(this, getSesion());
			this.detalles.addAll(listaDetalles);
			this.readDetalles = false;
		}
		return this.detalles;
	}

	public void addDetalle(DetTarConciEnt aDetTarConciEnt) throws BaseException {
		aDetTarConciEnt.setTar_info_cab(this);
		this.detalles.add(aDetTarConciEnt);
	}

	public void afterSave() throws BaseException {
		Iterator iterCabTarConciEnt = this.detalles.iterator();
		while (iterCabTarConciEnt.hasNext()) {
			DetTarConciEnt detTarConciEnt = (DetTarConciEnt) iterCabTarConciEnt.next();
			detTarConciEnt.save();
			detTarConciEnt = null;
		}
		iterCabTarConciEnt = null;
	}

	public static String getCarpetaArchImpCobranzas(ISesion aSesion) throws BaseException {
		return ValorParametro.findByCodigoParametro("CARPETA_ARCH_COB_TAR", aSesion).getValorCadena();
	}

	public static CabTarConciEnt getCabTarConciEnt(EmpresaConciTar empresa, String tipoArchivo, java.util.Date fecha, ISesion aSesion)
			throws BaseException {
		return DBCabTarConciEnt.getCabTarConciEnt(empresa, tipoArchivo, fecha, aSesion);
	}

	public static List getCabTarConciEnt(EmpresaConciTar empresa, java.util.Date fecDesde, java.util.Date fecHasta, ISesion aSesion)
			throws BaseException {

		return DBCabTarConciEnt.getCabTarConciEnt(empresa, fecDesde, fecHasta, aSesion);
	}

	public StringBuffer getArchivoTexto() throws BaseException {

		try {
			String archivo = CabTarConciEnt.getCarpetaArchImpCobranzas(this.getSesion()) + this.getOIDInteger().toString() + ".txt";

			// ...checks on aFile are elided
			StringBuffer contents = new StringBuffer();

			try {
				// use buffering, reading one line at a time
				// FileReader always assumes default encoding is OK!
				BufferedReader input = new BufferedReader(new FileReader(archivo));
				try {
					String line = null; // not declared within while loop
					/*
					 * readLine is a bit quirky : it returns the content of a
					 * line MINUS the newline. it returns null only for the END
					 * of the stream. it returns an empty String if two newlines
					 * appear in a row.
					 */
					while ((line = input.readLine()) != null) {
						contents.append(line);
						contents.append(Util.ENTER());
					}
				} finally {
					input.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}

			return contents;
		} catch (Exception e) {
			return new StringBuffer("");
		}

	}

}
