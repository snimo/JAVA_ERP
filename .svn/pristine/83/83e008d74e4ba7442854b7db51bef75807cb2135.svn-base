package com.srn.erp.contabilidad.bm;

import java.util.List;

import com.srn.erp.contabilidad.da.DBComproSubRepartoDet;
import com.srn.erp.general.bm.Moneda;

import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bm.Varios.ValorCotizacion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class ComproSubRepartoDet extends ObjetoLogico {

	public ComproSubRepartoDet() {
	}

	public static String NICKNAME = "cg.ComproSubRepartoDet";

	private ComproSubReparto compro_subreparto;

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	private CuentaImputable cuenta_imputable;

	private Integer signo;
	private Double impoLocHist;
	private Double impoLocAju;
	private Double impoMonExt1;
	private Double impoMonExt2;
	private Boolean activo;
	private FaseSubReparto faseSubReparto;
	private Moneda monedaOri;
	private Double importeOri;
	private ValorCotizacion valorCotizOri;
	private ValorCotizacion valorCotizMonExt1;
	private ValorCotizacion valorCotizMonExt2;
	private ComproContaDet comproContaDet;
	private Double proporcion;
	private Componente componente;
	private IObjetoLogico valorCompo;

	public ComproSubReparto getCompro_subreparto() throws BaseException {
		supportRefresh();
		return compro_subreparto;
	}

	public void setCompro_subreparto(ComproSubReparto aCompro_subreparto) {
		this.compro_subreparto = aCompro_subreparto;
	}
	
	public ComproContaDet getComproContaDet() throws BaseException {
		supportRefresh();
		return this.comproContaDet;
	}

	public void setComproContaDet(ComproContaDet aComproContaDet) {
		this.comproContaDet = aComproContaDet;
	}
	

	public Moneda getMonedaOri() throws BaseException {
		supportRefresh();
		return monedaOri;
	}

	public void setMonedaOri(Moneda aMonedaOri) {
		this.monedaOri = aMonedaOri;
	}
	
	public Double getProporcion() throws BaseException {
		supportRefresh();
		return proporcion;
	}

	public void setProporcion(Double aProporcion) {
		this.proporcion = aProporcion;
	}
	
	public Componente getComponente() throws BaseException {
		supportRefresh();
		return componente;
	}

	public void setComponente(Componente aComponente) {
		this.componente = aComponente;
	}
	
	public IObjetoLogico getValorComponente() throws BaseException {
		supportRefresh();
		return this.valorCompo;
	}

	public void setValorCompo(IObjetoLogico aValorCompo) {
		this.valorCompo = aValorCompo;
	}
	
	
	

	public Double getImporteOri() throws BaseException {
		supportRefresh();
		return importeOri;
	}

	public void setImporteOri(Double aImporteOri) {
		this.importeOri = aImporteOri;
	}

	public ValorCotizacion getValorCotizMonOri() throws BaseException {
		supportRefresh();
		return this.valorCotizOri;
	}

	public void setValorCotizMonori(ValorCotizacion aValorCotizMonOri) {
		this.valorCotizOri = aValorCotizMonOri;
	}

	public ValorCotizacion getValorCotizMonMonExt1() throws BaseException {
		supportRefresh();
		return this.valorCotizMonExt1;
	}

	public void setValorCotizMonExt1(ValorCotizacion aValorCotizMonExt1) {
		this.valorCotizMonExt1 = aValorCotizMonExt1;
	}

	public ValorCotizacion getValorCotizMonMonExt2() throws BaseException {
		supportRefresh();
		return this.valorCotizMonExt2;
	}

	public void setValorCotizMonExt2(ValorCotizacion aValorCotizMonExt2) {
		this.valorCotizMonExt2 = aValorCotizMonExt2;
	}

	public FaseSubReparto getFaseSubReparto() throws BaseException {
		supportRefresh();
		return this.faseSubReparto;
	}

	public void setFaseSubReparto(FaseSubReparto aFaseSubReparto) {
		this.faseSubReparto = aFaseSubReparto;
	}

	public CuentaImputable getCuenta_imputable() throws BaseException {
		supportRefresh();
		return cuenta_imputable;
	}

	public void setCuenta_imputable(CuentaImputable aCuenta_imputable) {
		this.cuenta_imputable = aCuenta_imputable;
	}

	public Integer getSigno() throws BaseException {
		supportRefresh();
		return signo;
	}

	public void setSigno(Integer aSigno) {
		this.signo = aSigno;
	}

	public Double getImpoLocAju() throws BaseException {
		supportRefresh();
		return this.impoLocAju;
	}

	public void setImporteLocAju(Double aImporte) {
		this.impoLocAju = aImporte;
	}

	public Double getImpoLocHist() throws BaseException {
		supportRefresh();
		return this.impoLocHist;
	}

	public void setImporteLocHist(Double aImporte) {
		this.impoLocHist = aImporte;
	}

	public Double getImpoMonExt1() throws BaseException {
		supportRefresh();
		return this.impoMonExt1;
	}

	public void setImpoMonExt1(Double aImporte) {
		this.impoMonExt1 = aImporte;
	}

	public Double getImpoMonExt2() throws BaseException {
		supportRefresh();
		return this.impoMonExt2;
	}

	public void setImpoMonExt2(Double aImporte) {
		this.impoMonExt2 = aImporte;
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

	public static ComproSubRepartoDet findByOid(Integer oid, ISesion aSesion)
			throws BaseException {
		return (ComproSubRepartoDet) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static ComproSubRepartoDet findByCodigo(String codigo,
			ISesion aSesion) throws BaseException {
		return (ComproSubRepartoDet) getObjectByCodigo(NICKNAME, codigo,
				aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(compro_subreparto, "Debe ingresar el SubReparto");
		Validar.noNulo(cuenta_imputable, "Debe ingresar la Cuenta Imputable");
		Validar.noNulo(signo, "Debe ingresar el Signo");
	}

	public static List getDetalles(ComproSubReparto compro, ISesion aSesion)
			throws BaseException {
		return DBComproSubRepartoDet.getDetalles(compro, aSesion);
	}

}
