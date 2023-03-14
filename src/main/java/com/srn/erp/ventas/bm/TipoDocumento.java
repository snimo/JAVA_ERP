package com.srn.erp.ventas.bm;

import java.util.ArrayList;
import java.util.List;

import com.srn.erp.ventas.da.DBTipoDocumento;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bm.Parametros.ValorParametro;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;
import framework.request.bl.Utils.Validar;

public class TipoDocumento extends ObjetoLogico {

	public static final String TIPO_DOCU_CUIT = "CUIT";
	public static final String TIPO_DOCU_CUIL = "CUIL";
	public static final String TIPO_DOCU_LIBRETA_ENROLAMIENTO = "LE";
	public static final String TIPO_DOCU_LIBRETA_CIVICA = "LC";
	public static final String TIPO_DOCU_DNI = "DNI";
	public static final String TIPO_DOCU_PASAPORTE = "PAS";
	public static final String TIPO_DOCU_CEDULA_IDENTIDAD = "CI";
	public static final String TIPO_DOCU_SIN_CALIFICAR = "NA";
	public static final String CODIGO_FE = "CODIGO_FE";

	public TipoDocumento() {
	}

	public static String NICKNAME = "ve.TipoDocumento";

	private String codigo;
	private String descripcion;
	private Boolean activo;
	private String comportamiento;
	private Integer codigoFE;

	public String getComportamieno() throws BaseException {
		supportRefresh();
		return comportamiento;
	}
	
	public Integer getCodigoFE() throws BaseException {
		supportRefresh();
		return this.codigoFE;
	}	

	public void setComportamiento(String aComportamiento) {
		this.comportamiento = aComportamiento;
	}
	
	public void setCodigoFE(Integer aCodigoFE) {
		this.codigoFE = aCodigoFE;
	}

	public String getCodigo() throws BaseException {
		supportRefresh();
		return codigo;
	}

	public void setCodigo(String aCodigo) {
		this.codigo = aCodigo;
	}

	public String getDescripcion() throws BaseException {
		supportRefresh();
		return descripcion;
	}

	public void setDescripcion(String aDescripcion) {
		this.descripcion = aDescripcion;
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

	public static TipoDocumento findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (TipoDocumento) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static TipoDocumento findByOidProxy(Integer oid, ISesion aSesion) throws BaseException {
		return (TipoDocumento) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}

	public static TipoDocumento findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (TipoDocumento) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(codigo, "Debe ingresar el código");
		Validar.noNulo(descripcion, "Debe ingresar la descrición");
		Validar.noNulo(this.comportamiento, "Debe ingresar el Tipo");
	}

	public static List getComportamientos() {
		List lista = new ArrayList();

		lista.add(TIPO_DOCU_CUIT);
		lista.add(TIPO_DOCU_CUIL);
		lista.add(TIPO_DOCU_LIBRETA_ENROLAMIENTO);
		lista.add(TIPO_DOCU_LIBRETA_CIVICA);
		lista.add(TIPO_DOCU_DNI);
		lista.add(TIPO_DOCU_PASAPORTE);
		lista.add(TIPO_DOCU_CEDULA_IDENTIDAD);
		lista.add(TIPO_DOCU_SIN_CALIFICAR);
		return lista;
	}

	public String getTipoDocuParaImpFiscal() throws BaseException {
		if (this.getComportamieno().equals(TIPO_DOCU_CUIT))
			return "CUIT";
		else if (this.getComportamieno().equals(TIPO_DOCU_CUIL))
			return "CUIL";
		else if (this.getComportamieno().equals(TIPO_DOCU_LIBRETA_ENROLAMIENTO))
			return "LE";
		else if (this.getComportamieno().equals(TIPO_DOCU_LIBRETA_CIVICA))
			return "LC";
		else if (this.getComportamieno().equals(TIPO_DOCU_DNI))
			return "DNI";
		else if (this.getComportamieno().equals(TIPO_DOCU_PASAPORTE))
			return "PAS";
		else if (this.getComportamieno().equals(TIPO_DOCU_CEDULA_IDENTIDAD))
			return "CI";
		else if (this.getComportamieno().equals(TIPO_DOCU_SIN_CALIFICAR))
			return "SC";
		else
			throw new ExceptionValidation(null, "No se encuentra el tipo de doc. para la imp. fiscal correspondiente al tipo de documento "
					+ this.getComportamieno());

	}

	public static String getTipoDocuCUITImpFiscal() {
		return "CUIT";
	}

	public boolean isCUIT() throws BaseException {
		if (this.getComportamieno().equals(TIPO_DOCU_CUIT))
			return true;
		else
			return false;
	}

	public boolean isCUIL() throws BaseException {
		if (this.getComportamieno().equals(TIPO_DOCU_CUIL))
			return true;
		else
			return false;
	}

	public static TipoDocumento getTipoDocumentoImportacionSujTurnos(ISesion aSesion) throws BaseException {
		Integer oidtTipoDocu = ValorParametro.findByCodigoParametro("TIPO_DOCU_IMP_SUJ_TUR", aSesion).getOidObjNeg();
		TipoDocumento tipoDocumento = TipoDocumento.findByOid(oidtTipoDocu, aSesion);
		return tipoDocumento;
	}

	public static List getAllTiposDocumentosActivos(ISesion aSesion) throws BaseException {
		return DBTipoDocumento.getAllTiposDocumentosActivos(aSesion);
	}

}
