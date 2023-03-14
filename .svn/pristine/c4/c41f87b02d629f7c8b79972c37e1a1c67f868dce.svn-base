package com.srn.erp.compras.bm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.compras.da.DBInformeControlCalidadDet;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bm.Varios.CalculadorMoney;
import framework.applicarionServer.bm.Varios.Money;
import framework.applicarionServer.bm.Varios.NumeroBase;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.Validar;

public class InformeControlCalidadDet extends ObjetoLogico {

	private List		motivosRechazos			= new ArrayList();

	private boolean	readMotivosRechazos	= true;

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

	public InformeControlCalidadDet() {
	}

	public static String					NICKNAME	= "cp.InformeControlCalidadDet";

	private InformeControlCalidad	informe_cc;

	private InformeRecepcionDet		informe_recepcion_det;

	private Double								cant_ok_us;

	private Double								cant_ok_uc;

	private Double								cant_mal_us;

	private Double								cant_mal_uc;

	private String								observaciones;

	private Double								cant_ret_prov_uc;

	private Double								cant_ret_prov_us;

	private Boolean								pend_ret_prov;

	private Boolean								anulado;

	public InformeControlCalidad getInforme_cc() throws BaseException {
		supportRefresh();
		return informe_cc;
	}

	public void setInforme_cc(InformeControlCalidad aInforme_cc) {
		this.informe_cc = aInforme_cc;
	}

	public InformeRecepcionDet getInforme_recepcion_det() throws BaseException {
		supportRefresh();
		return informe_recepcion_det;
	}

	public void setInforme_recepcion_det(InformeRecepcionDet aInforme_recepcion_det) {
		this.informe_recepcion_det = aInforme_recepcion_det;
	}

	public Double getCant_ok_us() throws BaseException {
		supportRefresh();
		return cant_ok_us;
	}

	public void setCant_ok_us(Double aCant_ok_us) {
		this.cant_ok_us = aCant_ok_us;
	}

	public Double getCant_ok_uc() throws BaseException {
		supportRefresh();
		return cant_ok_uc;
	}

	public void setCant_ok_uc(Double aCant_ok_uc) {
		this.cant_ok_uc = aCant_ok_uc;
	}

	public Double getCant_mal_us() throws BaseException {
		supportRefresh();
		return cant_mal_us;
	}

	public void setCant_mal_us(Double aCant_mal_us) {
		this.cant_mal_us = aCant_mal_us;
	}

	public Double getCant_mal_uc() throws BaseException {
		supportRefresh();
		return cant_mal_uc;
	}

	public void setCant_mal_uc(Double aCant_mal_uc) {
		this.cant_mal_uc = aCant_mal_uc;
	}

	public String getObservaciones() throws BaseException {
		supportRefresh();
		return observaciones;
	}

	public void setObservaciones(String aObservaciones) {
		this.observaciones = aObservaciones;
	}

	public Double getCant_ret_prov_uc() throws BaseException {
		supportRefresh();
		return cant_ret_prov_uc;
	}

	public void setCant_ret_prov_uc(Double aCant_ret_prov_uc) {
		this.cant_ret_prov_uc = aCant_ret_prov_uc;
	}

	public Double getCant_ret_prov_us() throws BaseException {
		supportRefresh();
		return cant_ret_prov_us;
	}

	public void setCant_ret_prov_us(Double aCant_ret_prov_us) {
		this.cant_ret_prov_us = aCant_ret_prov_us;
	}

	public Boolean isPend_ret_prov() throws BaseException {
		supportRefresh();
		return pend_ret_prov;
	}

	public void setPend_ret_prov(Boolean aPend_ret_prov) {
		this.pend_ret_prov = aPend_ret_prov;
	}

	public Boolean isAnulado() throws BaseException {
		supportRefresh();
		return anulado;
	}

	public void setAnulado(Boolean aAnulado) {
		this.anulado = aAnulado;
	}

	public String getNickName() {
		return NICKNAME;
	}

	public static InformeControlCalidadDet findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (InformeControlCalidadDet) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static InformeControlCalidadDet findByOidProxy(Integer oid, ISesion aSesion) throws BaseException {
		return (InformeControlCalidadDet) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}

	public static InformeControlCalidadDet findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (InformeControlCalidadDet) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(informe_cc, "Debe ingresar el Informe de Control de Calidad");
		Validar.noNulo(informe_recepcion_det, "Debe ingresar el Detalle del Informe de Recepción");
		
		marcarComoNoPendRetProv();
	}

	public static List getDetallesInfCC(InformeControlCalidad infCC, ISesion aSesion) throws BaseException {
		return DBInformeControlCalidadDet.getDetallesInfCC(infCC, aSesion);
	}

	protected void onNew() throws BaseException {
		// TODO Auto-generated method stub
		super.onNew();

		this.setAnulado(new Boolean(false));
		this.setCant_mal_uc(new Double(0));
		this.setCant_mal_us(new Double(0));
		this.setCant_ok_uc(new Double(0));
		this.setCant_ok_us(new Double(0));
		this.setCant_ret_prov_uc(new Double(0));
		this.setCant_ret_prov_us(new Double(0));
		this.setPend_ret_prov(new Boolean(false));
	}

	public Money getImpoRechazoMonLoc() throws BaseException {
		CalculadorMoney calcImpoRechazo = new CalculadorMoney(getInforme_recepcion_det().getPrecio_mon_local());
		calcImpoRechazo.multiplicarPor(new NumeroBase(getCant_mal_uc()));
		return calcImpoRechazo.getResultMoney();
	}

	public Money getImpoRechazoMonExt1() throws BaseException {
		CalculadorMoney calcImpoRechazo = new CalculadorMoney(getInforme_recepcion_det().getPrecio_mon_ext1());
		calcImpoRechazo.multiplicarPor(new NumeroBase(getCant_mal_uc()));
		return calcImpoRechazo.getResultMoney();
	}

	public Money getImpoRechazoMonExt2() throws BaseException {
		CalculadorMoney calcImpoRechazo = new CalculadorMoney(getInforme_recepcion_det().getPrecio_mon_ext2());
		calcImpoRechazo.multiplicarPor(new NumeroBase(getCant_mal_uc()));
		return calcImpoRechazo.getResultMoney();
	}

	public Money getImpoRechazoMonOri() throws BaseException {
		CalculadorMoney calcImpoRechazo = new CalculadorMoney(getInforme_recepcion_det().getPrecio_ori());
		calcImpoRechazo.multiplicarPor(new NumeroBase(getCant_mal_uc()));
		return calcImpoRechazo.getResultMoney();
	}

	public List getMotivosRechazos() throws BaseException {
		if (readMotivosRechazos) {
			List listaMotivosRechazos = MotivoRechazoInfCC.getMotivosRechazoInfCCDet(this, getSesion());
			motivosRechazos.addAll(listaMotivosRechazos);
			readMotivosRechazos = false;
		}
		return motivosRechazos;
	}

	public void addMotivoRechazo(MotivoRechazoInfCC motRechaInfCC) throws BaseException {
		motRechaInfCC.setInf_cc_det(this);
		motivosRechazos.add(motRechaInfCC);
	}

	public void afterSave() throws BaseException {
		
	}
	
	private void marcarComoNoPendRetProv() throws BaseException {
		// Marcar como no pendiente de retirar por el proveedor si de despachan la totalidad de los productos defectuosos
		if (this.isPend_ret_prov().booleanValue()==false) return;
		boolean actuPendiente = false;
		if ((this.getCant_mal_uc()!=null) && (this.getCant_ret_prov_uc()!=null)) 
			if (this.getCant_ret_prov_uc().doubleValue()>=this.getCant_mal_uc().doubleValue()) actuPendiente = true;
		if ((this.getCant_mal_us()!=null) && (this.getCant_ret_prov_us()!=null)) 
			if (this.getCant_ret_prov_us().doubleValue()>=this.getCant_mal_us().doubleValue()) actuPendiente = true;
		if (actuPendiente)
			this.setPend_ret_prov(new Boolean(false));
	}

	public void afterSaveNew() throws BaseException {
		
		Iterator iterMotivosRechazos = motivosRechazos.iterator();
		while (iterMotivosRechazos.hasNext()) {
			MotivoRechazoInfCC motRechazoInfCC = (MotivoRechazoInfCC) iterMotivosRechazos.next();
			motRechazoInfCC.save();
			motRechazoInfCC = null;
		}
		iterMotivosRechazos = null;

		// Marcar en el informe de recepcion las cantidades OK y los rechazos
		if (getInforme_recepcion_det() != null) {
			if ((getCant_ok_uc() != null) && (getCant_ok_uc().doubleValue() > 0))
				getInforme_recepcion_det().setCantControladaOKInfCCEnUC(getCant_ok_uc());
			if ((getCant_ok_us() != null) && (getCant_ok_us().doubleValue() > 0))
				getInforme_recepcion_det().setCantControladaOKInfCCEnUS(getCant_ok_us());
			if ((getCant_mal_uc() != null) && (getCant_mal_uc().doubleValue() > 0))
				getInforme_recepcion_det().setCantControladaMalInfCCEnUC(getCant_mal_uc());
			if ((getCant_mal_us() != null) && (getCant_mal_us().doubleValue() > 0))
				getInforme_recepcion_det().setCantControladaMalInfCCEnUS(getCant_mal_us());
			getInforme_recepcion_det().determinarMarcaPendCC();
			getInforme_recepcion_det().save();
		}

	}

	public void anular() throws BaseException {

		// Dismininuir las cantidades controlaes en el Informe de Recepción
		// de las Ordenes de compra
		if (getInforme_recepcion_det() != null) {
			if ((getCant_ok_uc() != null) && (getCant_ok_uc().doubleValue() > 0))
				getInforme_recepcion_det().setCantControladaOKInfCCEnUC(new Double(getCant_ok_uc().doubleValue() * -1));
			if ((getCant_ok_us() != null) && (getCant_ok_us().doubleValue() > 0))
				getInforme_recepcion_det().setCantControladaOKInfCCEnUS(new Double(getCant_ok_us().doubleValue() * -1));
			if ((getCant_mal_uc() != null) && (getCant_mal_uc().doubleValue() > 0))
				getInforme_recepcion_det().setCantControladaMalInfCCEnUC(new Double(getCant_mal_uc().doubleValue() * -1));
			if ((getCant_mal_us() != null) && (getCant_mal_us().doubleValue() > 0))
				getInforme_recepcion_det().setCantControladaMalInfCCEnUS(new Double(getCant_mal_us().doubleValue() * -1));
			getInforme_recepcion_det().determinarMarcaPendCC();
			getInforme_recepcion_det().save();
		}

	}

	public static List getDetallesInfCCByCondiciones(HashTableDatos condiciones, ISesion aSesion) throws BaseException {
		return DBInformeControlCalidadDet.getDetallesInfCCByCondiciones(condiciones, aSesion);
	}

	public Money getCantPendDevEnUS() throws BaseException {
		CalculadorMoney calcCantPendDev = new CalculadorMoney(new Money(this.getCant_mal_us().doubleValue()));
		calcCantPendDev.restar(new Money(this.getCant_ret_prov_us().doubleValue()));
		return calcCantPendDev.getResultMoney();
	}

	public Money getCantPendDevEnUC() throws BaseException {
		CalculadorMoney calcCantPendDev = new CalculadorMoney(new Money(this.getCant_mal_uc().doubleValue()));
		calcCantPendDev.restar(new Money(this.getCant_ret_prov_uc().doubleValue()));
		return calcCantPendDev.getResultMoney();
	}

	public static List getDetallesInfCCByListaOids(HashTableDatos condiciones, ISesion aSesion) throws BaseException {
		return DBInformeControlCalidadDet.getDetallesInfCCByListaOids(condiciones, aSesion);
	}

}
