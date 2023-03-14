package com.srn.erp.general.bm;

import java.util.Date;
import java.util.Hashtable;
import java.util.List;

import com.srn.erp.general.da.DBMoneda;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bm.Parametros.ValorParametro;
import framework.applicarionServer.bm.Varios.ValorCotizacion;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

//

public class Moneda extends ObjetoLogico {

	public Moneda() {
	}

	public static String NICKNAME = "ge.Moneda";

	private String codigo;
	private String descripcion;
	private ValorCotizacion base;
	private Boolean activo;
	private String simbolo;

	public String getCodigo() throws BaseException {
		supportRefresh();
		return codigo;
	}

	public boolean isMonedaCursoLegal() throws BaseException {
		return (Moneda.getMonedaCursoLegal(getSesion()).getOID() == getOID());
	}
	
	public boolean isMonedaExt1() throws BaseException {
		return (Moneda.getMonedaExt1(getSesion()).getOID() == getOID());
	}
	
	public boolean isMonedaExt2() throws BaseException {
		return (Moneda.getMonedaExt2(getSesion()).getOID() == getOID());
	}	

	public void setCodigo(String aCodigo) {
		this.codigo = aCodigo;
	}

	public String getDescripcion() throws BaseException {
		supportRefresh();
		return descripcion;
	}

	public void setSimbolo(String aSimbolo) {
		this.simbolo = aSimbolo;
	}

	public String getSimbolo() throws BaseException {
		supportRefresh();
		return simbolo;
	}

	public void setDescripcion(String aDescripcion) {
		this.descripcion = aDescripcion;
	}

	public ValorCotizacion getBase() throws BaseException {
		supportRefresh();
		return base;
	}

	public void setBase(ValorCotizacion aBase) {
		this.base = aBase;
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

	public static Moneda findByOid(Integer oid, ISesion aSesion)
			throws BaseException {
		return (Moneda) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static Moneda findByOidProxy(Integer oid, ISesion aSesion)
			throws BaseException {
		return (Moneda) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}

	public static Moneda findByCodigo(String codigo, ISesion aSesion)
			throws BaseException {
		return (Moneda) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(codigo, "Debe ingresar un Código");
		Validar.noNulo(descripcion, "Debe ingresar la Descripción");
		Validar.noNulo(base, "Debe ingresar la Base");
		Validar.noNulo(simbolo, "Debe ingresar el Símbolo");

		if (isNew() && (isActivo().booleanValue() == false))
			Validar.mensajeValidacion("La moneda debe estar activa");

	}

	public static List getAllActivos(ISesion aSesion) throws BaseException {
		return DBMoneda.getAllActivos(aSesion);
	}

	public static List getAll(ISesion aSesion) throws BaseException {
		return DBMoneda.getAll(aSesion);
	}

	public static Moneda getMonedaCursoLegal(ISesion aSesion)
			throws BaseException {
		Integer oidMoneda = ValorParametro.findByCodigoParametro(
				"MONEDA_CURSO_LEGAL", aSesion).getOidObjNeg();
		Moneda moneda = Moneda.findByOid(oidMoneda, aSesion);
		return moneda;
	}

	public static Moneda getMonedaExt1(ISesion aSesion) throws BaseException {
		Integer oidMoneda = ValorParametro.findByCodigoParametro(
				"MONEDA_EXT_PRINCIPAL", aSesion).getOidObjNeg();
		Moneda moneda = Moneda.findByOid(oidMoneda, aSesion);
		return moneda;
	}

	public static Moneda getMonedaExt2(ISesion aSesion) throws BaseException {
		Integer oidMoneda = ValorParametro.findByCodigoParametro(
				"MONEDA_EXT_SECUNDARIA", aSesion).getOidObjNeg();
		Moneda moneda = Moneda.findByOid(oidMoneda, aSesion);
		return moneda;
	}

	public static Hashtable getListMonedasContables(ISesion aSesion)
			throws BaseException {
		Moneda monedaCursoLegal = getMonedaCursoLegal(aSesion);
		Moneda monedaExt1 = getMonedaExt1(aSesion);
		Moneda monedaExt2 = getMonedaExt2(aSesion);
		Hashtable lista = new Hashtable();
		lista.put("MONENDA_LOCAL", monedaCursoLegal);
		lista.put("MONENDA_EXT_1", monedaExt1);
		lista.put("MONENDA_EXT_2", monedaExt2);
		return lista;
	}

	public static IDataSet enviarMonedasContables(ISesion aSesion)
			throws BaseException {

		IDataSet dataset = new TDataSet();
		dataset.create("TMonedasContables");
		dataset.fieldDef(new Field("oid_mon_hist", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_mon_hist", Field.STRING, 15));
		dataset.fieldDef(new Field("desc_mon_hist", Field.STRING, 50));

		dataset.fieldDef(new Field("oid_mon_aju", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_mon_aju", Field.STRING, 15));
		dataset.fieldDef(new Field("desc_mon_aju", Field.STRING, 50));

		dataset.fieldDef(new Field("oid_mon_ext1", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_mon_ext1", Field.STRING, 15));
		dataset.fieldDef(new Field("desc_mon_ext1", Field.STRING, 50));

		dataset.fieldDef(new Field("oid_mon_ext2", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_mon_ext2", Field.STRING, 15));
		dataset.fieldDef(new Field("desc_mon_ext2", Field.STRING, 50));

		Moneda monedaCursoLegal = getMonedaCursoLegal(aSesion);
		Moneda monedaExt1 = getMonedaExt1(aSesion);
		Moneda monedaExt2 = getMonedaExt2(aSesion);

		dataset.append();
		dataset.fieldValue("oid_mon_hist", monedaCursoLegal.getOIDInteger());
		dataset.fieldValue("cod_mon_hist", monedaCursoLegal.getCodigo());
		dataset.fieldValue("desc_mon_hist", monedaCursoLegal.getDescripcion());

		dataset.fieldValue("oid_mon_aju", monedaCursoLegal.getOIDInteger());
		dataset.fieldValue("cod_mon_aju", monedaCursoLegal.getCodigo());
		dataset.fieldValue("desc_mon_aju", monedaCursoLegal.getDescripcion()
				+ " (Ajus.) ");

		dataset.fieldValue("oid_mon_ext1", monedaExt1.getOIDInteger());
		dataset.fieldValue("cod_mon_ext1", monedaExt1.getCodigo());
		dataset.fieldValue("desc_mon_ext1", monedaExt1.getDescripcion());

		dataset.fieldValue("oid_mon_ext2", monedaExt2.getOIDInteger());
		dataset.fieldValue("cod_mon_ext2", monedaExt2.getCodigo());
		dataset.fieldValue("desc_mon_ext2", monedaExt2.getDescripcion());

		return dataset;
	}

	public static IDataSet getLas3MonedasContables(ISesion aSesion)
			throws BaseException {

		IDataSet dataset = new TDataSet();
		dataset.create("TMonedasContables");
		dataset.fieldDef(new Field("oid_moneda", Field.INTEGER, 0));
		dataset.fieldDef(new Field("codigo", Field.STRING, 15));
		dataset.fieldDef(new Field("descripcion", Field.STRING, 50));
		dataset.fieldDef(new Field("es_curso_legal", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("es_mon_ext_1", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("es_mon_ext_2", Field.BOOLEAN, 0));

		Moneda monedaCursoLegal = getMonedaCursoLegal(aSesion);
		Moneda monedaExt1 = getMonedaExt1(aSesion);
		Moneda monedaExt2 = getMonedaExt2(aSesion);

		dataset.append();
		dataset.fieldValue("oid_moneda", monedaCursoLegal.getOIDInteger());
		dataset.fieldValue("codigo", monedaCursoLegal.getCodigo());
		dataset.fieldValue("descripcion", monedaCursoLegal.getDescripcion());
		dataset.fieldValue("es_curso_legal", new Boolean(true));
		dataset.fieldValue("es_mon_ext_1", new Boolean(false));
		dataset.fieldValue("es_mon_ext_2", new Boolean(false));

		dataset.append();
		dataset.fieldValue("oid_moneda", monedaExt1.getOIDInteger());
		dataset.fieldValue("codigo", monedaExt1.getCodigo());
		dataset.fieldValue("descripcion", monedaExt1.getDescripcion());
		dataset.fieldValue("es_curso_legal", new Boolean(false));
		dataset.fieldValue("es_mon_ext_1", new Boolean(true));
		dataset.fieldValue("es_mon_ext_2", new Boolean(false));

		dataset.append();
		dataset.fieldValue("oid_moneda", monedaExt2.getOIDInteger());
		dataset.fieldValue("codigo", monedaExt2.getCodigo());
		dataset.fieldValue("descripcion", monedaExt2.getDescripcion());
		dataset.fieldValue("es_curso_legal", new Boolean(false));
		dataset.fieldValue("es_mon_ext_1", new Boolean(false));
		dataset.fieldValue("es_mon_ext_2", new Boolean(true));

		return dataset;
	}

	public static IDataSet getLas3MonedasContablesMasTodos(ISesion aSesion)
			throws BaseException {

		IDataSet dataset = new TDataSet();
		dataset.create("TMonedasContables");
		dataset.fieldDef(new Field("oid_moneda", Field.INTEGER, 0));
		dataset.fieldDef(new Field("codigo", Field.STRING, 15));
		dataset.fieldDef(new Field("descripcion", Field.STRING, 50));
		dataset.fieldDef(new Field("es_curso_legal", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("es_mon_ext_1", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("es_mon_ext_2", Field.BOOLEAN, 0));

		Moneda monedaCursoLegal = getMonedaCursoLegal(aSesion);
		Moneda monedaExt1 = getMonedaExt1(aSesion);
		Moneda monedaExt2 = getMonedaExt2(aSesion);

		dataset.append();
		dataset.fieldValue("oid_moneda", 0);
		dataset.fieldValue("codigo", "TODOS");
		dataset.fieldValue("descripcion", "--- TODAS ---");
		dataset.fieldValue("es_curso_legal", new Boolean(false));
		dataset.fieldValue("es_mon_ext_1", new Boolean(false));
		dataset.fieldValue("es_mon_ext_2", new Boolean(false));

		dataset.append();
		dataset.fieldValue("oid_moneda", monedaCursoLegal.getOIDInteger());
		dataset.fieldValue("codigo", monedaCursoLegal.getCodigo());
		dataset.fieldValue("descripcion", monedaCursoLegal.getDescripcion());
		dataset.fieldValue("es_curso_legal", new Boolean(true));
		dataset.fieldValue("es_mon_ext_1", new Boolean(false));
		dataset.fieldValue("es_mon_ext_2", new Boolean(false));

		dataset.append();
		dataset.fieldValue("oid_moneda", monedaExt1.getOIDInteger());
		dataset.fieldValue("codigo", monedaExt1.getCodigo());
		dataset.fieldValue("descripcion", monedaExt1.getDescripcion());
		dataset.fieldValue("es_curso_legal", new Boolean(false));
		dataset.fieldValue("es_mon_ext_1", new Boolean(true));
		dataset.fieldValue("es_mon_ext_2", new Boolean(false));

		dataset.append();
		dataset.fieldValue("oid_moneda", monedaExt2.getOIDInteger());
		dataset.fieldValue("codigo", monedaExt2.getCodigo());
		dataset.fieldValue("descripcion", monedaExt2.getDescripcion());
		dataset.fieldValue("es_curso_legal", new Boolean(false));
		dataset.fieldValue("es_mon_ext_1", new Boolean(false));
		dataset.fieldValue("es_mon_ext_2", new Boolean(true));

		return dataset;
	}

	public ValorCotizacion getCotizacionNotFoundCero(TipoCambio tipoCambio,
			Date fecha) throws BaseException {
		return Cotizacion.getCotizacionNotFoundCero(fecha, tipoCambio, this,
				getSesion());
	}

	public static Moneda getMonedaDefaultCostoProducto(ISesion aSesion)
			throws BaseException {
		Integer oidMoneda = ValorParametro.findByCodigoParametro(
				"MODEDA_DEF_COSTO_PROD", aSesion).getOidObjNeg();
		Moneda moneda = Moneda.findByOid(oidMoneda, aSesion);
		return moneda;
	}
	
	public static Moneda getMonedaDefaultPrecioVta(ISesion aSesion)
	throws BaseException {
		Integer oidMoneda = ValorParametro.findByCodigoParametro(
				"MON_DEF_PREC_VTA", aSesion).getOidObjNeg();
		Moneda moneda = Moneda.findByOid(oidMoneda, aSesion);
		return moneda;
	}
	
	public static Moneda getMonedaTotalResuCtaCteClie(ISesion aSesion)
	throws BaseException {
		Integer oidMoneda = ValorParametro.findByCodigoParametro(
				"MON_TOT_RES_CTA_CTE_CLIE", aSesion).getOidObjNeg();
		Moneda moneda = Moneda.findByOid(oidMoneda, aSesion);
		return moneda;
	}
	
	public static Moneda getMonedaTotalResuCtaCteProv(ISesion aSesion)
	throws BaseException {
		Integer oidMoneda = ValorParametro.findByCodigoParametro(
				"MON_TOT_RES_CTA_CTE_PROV", aSesion).getOidObjNeg();
		Moneda moneda = Moneda.findByOid(oidMoneda, aSesion);
		return moneda;
	}
	
	
	

}
