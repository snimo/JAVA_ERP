package com.srn.erp.impuestos.bm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.general.bm.ComproCab;
import com.srn.erp.general.bm.Talonario;
import com.srn.erp.impuestos.da.DBListadoIVACab;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bm.Varios.Money;
import framework.request.bl.Utils.BaseException;

public class ListadoIVACab extends ObjetoLogico {

	private List conceptosImpuestos = new ArrayList();
	private boolean readConcImpu = true;

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public Boolean isActivo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public ListadoIVACab() {
	}

	public static String NICKNAME = "im.ListadoIVACab";

	private ComproCab comprobante;
	private String razon_social;
	private CategoriaIVA categoria_iva;
	private String cuit;
	private Money neto_gravado;
	private Money neto_no_gravado;
	private Money total;
	private String tipo_listado;
	private SujetoImpositivo sujetoImpositivo;

	public SujetoImpositivo getSujetoImpositivo() throws BaseException {
		supportRefresh();
		return sujetoImpositivo;
	}

	public void setSujetoImpositivo(SujetoImpositivo aSujetoImpositivo) {
		this.sujetoImpositivo = aSujetoImpositivo;
	}

	public ComproCab getComprobante() throws BaseException {
		supportRefresh();
		return comprobante;
	}

	public void setComprobante(ComproCab aComprobante) {
		this.comprobante = aComprobante;
	}

	public String getRazon_social() throws BaseException {
		supportRefresh();
		return razon_social;
	}

	public void setRazon_social(String aRazon_social) {
		this.razon_social = aRazon_social;
	}

	public CategoriaIVA getCategoria_iva() throws BaseException {
		supportRefresh();
		return categoria_iva;
	}

	public void setCategoria_iva(CategoriaIVA aCategoria_iva) {
		this.categoria_iva = aCategoria_iva;
	}

	public String getCuit() throws BaseException {
		supportRefresh();
		return cuit;
	}

	public void setCuit(String aCuit) {
		this.cuit = aCuit;
	}

	public Money getNeto_gravado() throws BaseException {
		supportRefresh();
		return neto_gravado;
	}

	public void setNeto_gravado(Money aNeto_gravado) {
		this.neto_gravado = aNeto_gravado;
	}

	public Money getNeto_no_gravado() throws BaseException {
		supportRefresh();
		return neto_no_gravado;
	}

	public void setNeto_no_gravado(Money aNeto_no_gravado) {
		this.neto_no_gravado = aNeto_no_gravado;
	}

	public Money getTotal() throws BaseException {
		supportRefresh();
		return total;
	}

	public void setTotal(Money aTotal) {
		this.total = aTotal;
	}

	public String getTipo_listado() throws BaseException {
		supportRefresh();
		return tipo_listado;
	}

	public void setTipo_listado(String aTipo_listado) {
		this.tipo_listado = aTipo_listado;
	}

	public String getNickName() {
		return NICKNAME;
	}

	public static ListadoIVACab findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (ListadoIVACab) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static ListadoIVACab findByOidProxy(Integer oid, ISesion aSesion) throws BaseException {
		return (ListadoIVACab) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}

	public static ListadoIVACab findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (ListadoIVACab) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
	}

	public List getConceptosImpuestos() throws BaseException {
		if (readConcImpu) {
			List listaConcImpu = ListadoIVAConcImpu.getConcImpuestos(this, getSesion());
			conceptosImpuestos.addAll(listaConcImpu);
			readConcImpu = false;
		}
		return conceptosImpuestos;
	}

	public void addLibroIVAConcImpu(ListadoIVAConcImpu aLibroIVAConcImpu) throws BaseException {
		aLibroIVAConcImpu.setListado_iva(this);
		conceptosImpuestos.add(aLibroIVAConcImpu);
	}

	public void afterSave() throws BaseException {
		Iterator iterConcImpu = conceptosImpuestos.iterator();
		while (iterConcImpu.hasNext()) {
			ListadoIVAConcImpu listadoIVAConcImpu = (ListadoIVAConcImpu) iterConcImpu.next();
			listadoIVAConcImpu.save();
			listadoIVAConcImpu = null;
		}
		iterConcImpu = null;
	}

	public static List getLibroIVACompras(java.util.Date fechaDesde, java.util.Date fechaHasta, SujetoImpositivo sujetoImpositivo,
			ISesion aSesion) throws BaseException {
		return DBListadoIVACab.getLibroIVACompras(fechaDesde, fechaHasta, sujetoImpositivo, aSesion);
	}

	public static List getLibroIVAVentas(java.util.Date fechaDesde, java.util.Date fechaHasta, SujetoImpositivo sujetoImpositivo,
			ISesion aSesion) throws BaseException {
		return DBListadoIVACab.getLibroIVAVentas(fechaDesde, fechaHasta, sujetoImpositivo, aSesion);
	}

	public static List getLibroIVAVentasByTalonarioFecDesdeHasta(java.util.Date fechaDesde, java.util.Date fechaHasta, Talonario talonario,
			ISesion aSesion) throws BaseException {
		return DBListadoIVACab.getLibroIVAVentasByTalonarioFecDesdeHasta(fechaDesde, fechaHasta, talonario, aSesion);
	}

	public static int getMaxNroExtDeTalonarioEnFechas(ISesion aSesion, Talonario talonario, java.util.Date fecDesde, java.util.Date fecHasta)
			throws BaseException {

		return DBListadoIVACab.getMaxNroExtDeTalonarioEnFechas(aSesion, talonario, fecDesde, fecHasta);

	}
	
	public static int getMinNroExtDeTalonarioEnFechas(ISesion aSesion, Talonario talonario, java.util.Date fecDesde, java.util.Date fecHasta)
	throws BaseException {

		return DBListadoIVACab.getMinNroExtDeTalonarioEnFechas(aSesion, talonario, fecDesde, fecHasta);

	}
	

}
