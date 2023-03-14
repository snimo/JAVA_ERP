package com.srn.erp.cip.bm;

import java.util.List;

import com.srn.erp.cip.da.DBDocuRequeridaCIP;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class DocuRequeridaCIP extends ObjetoLogico {

	public DocuRequeridaCIP() {
	}

	public static String NICKNAME = "cip.DocuRequeridaCIP";

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	private TarjetaCIP tarjeta;
	private TipoDocumentacionCIP tipo_docu;
	private Boolean activo;

	public TarjetaCIP getTarjeta() throws BaseException {
		supportRefresh();
		return tarjeta;
	}

	public void setTarjeta(TarjetaCIP aTarjeta) {
		this.tarjeta = aTarjeta;
	}

	public TipoDocumentacionCIP getTipo_docu() throws BaseException {
		supportRefresh();
		return tipo_docu;
	}

	public void setTipo_docu(TipoDocumentacionCIP aTipo_docu) {
		this.tipo_docu = aTipo_docu;
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

	public static DocuRequeridaCIP findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (DocuRequeridaCIP) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static DocuRequeridaCIP findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (DocuRequeridaCIP) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(tarjeta, "Debe ingresar la Tarjeta");
		Validar.noNulo(tipo_docu, "Debe ingresar el Tipo de Documentación");
	}
	
	public static List getDocuRequerida(
			  TarjetaCIP tarjeta,
	          ISesion aSesion) throws BaseException {
		  return DBDocuRequeridaCIP.getDocuRequerida(tarjeta,aSesion);
	}

}
