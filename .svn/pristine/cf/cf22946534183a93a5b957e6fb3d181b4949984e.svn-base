package com.srn.erp.conciTarjeta.bm;

import java.util.List;

import com.srn.erp.conciTarjeta.da.DBTerminalConciTar;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class TerminalConciTar extends ObjetoLogico {

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public TerminalConciTar() {
	}

	public static String NICKNAME = "ctar.TerminalConciTar";

	private String nro_terminal;
	private String descripcion;
	private UniNegConciTar uni_neg;
	private String Folder_IN_CieLot;
	private Boolean activo;
	private String folderLoteProcesado;
	private String folderLoteError;

	public String getNro_terminal() throws BaseException {
		supportRefresh();
		return nro_terminal;
	}
	
	public String getFolderLoteError() throws BaseException {
		supportRefresh();
		if (this.folderLoteError == null)
			return "";
		else
			return this.folderLoteError;
	}	

	public void setNro_terminal(String aNro_terminal) {
		this.nro_terminal = aNro_terminal;
	}
	
	public void setFolderLoteError(String aFolderLoteError) {
		this.folderLoteError = aFolderLoteError;
	}	

	public String getFolderLoteProcesado() throws BaseException {
		supportRefresh();
		if (this.folderLoteProcesado == null)
			return "";
		else
			return this.folderLoteProcesado;
	}

	public void setFolderLoteProcesado(String aFolderLoteProcesado) {
		this.folderLoteProcesado = aFolderLoteProcesado;
	}

	public String getDescripcion() throws BaseException {
		supportRefresh();
		return descripcion;
	}

	public void setDescripcion(String aDescripcion) {
		this.descripcion = aDescripcion;
	}

	public UniNegConciTar getUni_neg() throws BaseException {
		supportRefresh();
		return uni_neg;
	}

	public void setUni_neg(UniNegConciTar aUni_neg) {
		this.uni_neg = aUni_neg;
	}

	public String getFolder_in_cielot() throws BaseException {
		supportRefresh();
		return Folder_IN_CieLot;
	}

	public void setFolder_in_cielot(String aFolder_in_cielot) {
		this.Folder_IN_CieLot = aFolder_in_cielot;
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

	public static TerminalConciTar findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (TerminalConciTar) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static TerminalConciTar findByOidProxy(Integer oid, ISesion aSesion) throws BaseException {
		return (TerminalConciTar) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}

	public static TerminalConciTar findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (TerminalConciTar) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(nro_terminal, "Debe ingresar el Nro. de Terminal");
		Validar.noNulo(descripcion, "Debe ingresar la Descripción");
		Validar.noNulo(uni_neg, "Debe ingresar la Unidad de Negocio");
	}

	public static List getAllActivos(ISesion aSesion) throws BaseException {
		return DBTerminalConciTar.getAllActivos(aSesion);
	}

	public static TerminalConciTar getTerminal(String folderIN, ISesion aSesion) throws BaseException {
		return DBTerminalConciTar.getTerminal(folderIN, aSesion);
	}

	public static TerminalConciTar getTerminalByNro(String nroTerminal, ISesion aSesion) throws BaseException {
		return DBTerminalConciTar.getTerminalByNro(nroTerminal, aSesion);
	}

}
