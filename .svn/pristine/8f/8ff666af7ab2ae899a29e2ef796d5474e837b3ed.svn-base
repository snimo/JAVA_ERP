package com.srn.erp.conciTarjeta.bm;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.conciTarjeta.da.DBArchLoteConciCab;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.Util;
import framework.request.bl.Utils.BaseException;

public class ArchLoteConciCab extends ObjetoLogico {

	private List detallesArch = new ArrayList();
	private boolean readDetallesArch = true;

	@Override
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

	public ArchLoteConciCab() {
	}

	public static String NICKNAME = "ctar.ArchLoteConciCab";

	private Integer estado;
	private String proveedor_host;
	private String nro_host;
	private String nom_host;
	private Integer nro_lote;
	private Integer cant_transac;
	private String nro_terminal;
	private Integer anio;
	private Integer activo;
	private Integer mes;
	private String archivo;
	private java.util.Date fec_creacion;
	private Integer dia;
	private java.util.Date fec_importacion;
	private java.util.Date fec_cierre;
	private String hora_importacion;
	private EmpresaConciTar empresa;

	public Integer getEstado() throws BaseException {
		supportRefresh();
		return estado;
	}

	public void setEstado(Integer aEstado) {
		this.estado = aEstado;
	}

	public EmpresaConciTar getEmpresa() throws BaseException {
		supportRefresh();
		return this.empresa;
	}

	public void setEmpresaConciTar(EmpresaConciTar aEmpresa) {
		this.empresa = aEmpresa;
	}

	public String getProveedor_host() throws BaseException {
		supportRefresh();
		return proveedor_host;
	}

	public void setProveedor_host(String aProveedor_host) {
		this.proveedor_host = aProveedor_host;
	}

	public String getNro_host() throws BaseException {
		supportRefresh();
		return nro_host;
	}

	public void setNro_host(String aNro_host) {
		this.nro_host = aNro_host;
	}

	public String getNom_host() throws BaseException {
		supportRefresh();
		return nom_host;
	}

	public void setNom_host(String aNom_host) {
		this.nom_host = aNom_host;
	}

	public Integer getNro_lote() throws BaseException {
		supportRefresh();
		return nro_lote;
	}

	public void setNro_lote(Integer aNro_lote) {
		this.nro_lote = aNro_lote;
	}

	public Integer getCant_transac() throws BaseException {
		supportRefresh();
		return cant_transac;
	}

	public void setCant_transac(Integer aCant_transac) {
		this.cant_transac = aCant_transac;
	}

	public String getNro_terminal() throws BaseException {
		supportRefresh();
		return nro_terminal;
	}

	public void setNro_terminal(String aNro_terminal) {
		this.nro_terminal = aNro_terminal;
	}

	public Integer getAnio() throws BaseException {
		supportRefresh();
		return anio;
	}

	public void setAnio(Integer aAnio) {
		this.anio = aAnio;
	}

	public Integer getActivo() throws BaseException {
		supportRefresh();
		return activo;
	}

	public void setActivo(Integer aActivo) {
		this.activo = aActivo;
	}

	public Integer getMes() throws BaseException {
		supportRefresh();
		return mes;
	}

	public void setMes(Integer aMes) {
		this.mes = aMes;
	}

	public String getArchivo() throws BaseException {
		supportRefresh();
		return archivo;
	}

	public void setArchivo(String aArchivo) {
		this.archivo = aArchivo;
	}

	public java.util.Date getFec_creacion() throws BaseException {
		supportRefresh();
		return fec_creacion;
	}

	public void setFec_creacion(java.util.Date aFec_creacion) {
		this.fec_creacion = aFec_creacion;
	}

	public Integer getDia() throws BaseException {
		supportRefresh();
		return dia;
	}

	public void setDia(Integer aDia) {
		this.dia = aDia;
	}

	public java.util.Date getFec_importacion() throws BaseException {
		supportRefresh();
		return fec_importacion;
	}

	public void setFec_importacion(java.util.Date aFec_importacion) {
		this.fec_importacion = aFec_importacion;
	}

	public java.util.Date getFec_cierre() throws BaseException {
		supportRefresh();
		return fec_cierre;
	}

	public void setFec_cierre(java.util.Date aFec_cierre) {
		this.fec_cierre = aFec_cierre;
	}

	public String getHora_importacion() throws BaseException {
		supportRefresh();
		return hora_importacion;
	}

	public void setHora_importacion(String aHora_importacion) {
		this.hora_importacion = aHora_importacion;
	}

	public String getNickName() {
		return NICKNAME;
	}

	public static ArchLoteConciCab findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (ArchLoteConciCab) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static ArchLoteConciCab findByOidProxy(Integer oid, ISesion aSesion) throws BaseException {
		return (ArchLoteConciCab) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}

	public static ArchLoteConciCab findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (ArchLoteConciCab) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
	}

	public List getDetallesArch() throws BaseException {
		if (this.readDetallesArch) {
			List listaDetArch = ArchLoteConciDet.getArchLoteconciDet(this, getSesion());
			this.detallesArch.addAll(listaDetArch);
			this.readDetallesArch = false;
		}
		return this.detallesArch;
	}

	public void addArchConciDet(ArchLoteConciDet archLoteConciDet) throws BaseException {
		archLoteConciDet.setArch_lot_cab(this);
		this.detallesArch.add(archLoteConciDet);
	}

	public void afterSave() throws BaseException {
		Iterator iterArchConciDet = this.detallesArch.iterator();
		while (iterArchConciDet.hasNext()) {
			ArchLoteConciDet archConciDet = (ArchLoteConciDet) iterArchConciDet.next();
			archConciDet.save();
			archConciDet = null;
		}
		iterArchConciDet = null;
	}

	public static ArchLoteConciCab getArchivoCabecera(Integer nroLote, String nroTerminal, Integer anio, Integer mes, String archivo,
			ISesion aSesion) throws BaseException {
		return DBArchLoteConciCab.getArchivoCabecera(nroLote, nroTerminal, anio, mes, archivo, aSesion);
	}

	public static List getUltimosArchImportados(EmpresaConciTar empresa, Integer dias, ISesion aSesion) throws BaseException {
		return DBArchLoteConciCab.getUltimosArchImportados(empresa, dias, aSesion);
	}

	public static List getArchLoteDet(EmpresaConciTar empresa, java.util.Date fecDesde, java.util.Date fecHasta, ISesion aSesion)
			throws BaseException {
		return DBArchLoteConciCab.getArchLoteDet(empresa, fecDesde, fecHasta, aSesion);
	}

	public StringBuffer getArchivoTexto() throws BaseException {

		try {
			TerminalConciTar terminal = TerminalConciTar.getTerminalByNro(this.getNro_terminal(), this.getSesion());
			if (terminal == null)
				return new StringBuffer("");

			String archivo = terminal.getFolderLoteProcesado() + this.getOIDInteger().toString() + ".txt";

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
