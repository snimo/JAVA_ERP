package com.srn.erp.contabilidad.bm;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.contabilidad.da.DBAsientoManual;
import com.srn.erp.contabilidad.da.DBAsientoManualDet;
import com.srn.erp.general.bm.ComproCab;
import com.srn.erp.general.bm.LugarEmision;
import com.srn.erp.general.bm.Moneda;
import com.srn.erp.general.bm.TipoCambio;
import com.srn.erp.general.bm.TipoComprobante;
import com.srn.erp.pagos.bm.AnuladorRendFF;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.Fecha;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.applicarionServer.bm.Parametros.ValorParametro;
import framework.applicarionServer.bm.Varios.ValorCotizacion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;
import framework.request.bl.Utils.HashTableDatos;

public class AsientoManual extends ComproCab implements IContabilizable {

  public static String NICKNAME = "cg.AsientoManual";

  private TipoCambio        tipoCambio;
  private Moneda            moneda;
  private Boolean           noContaOtrasMonedas;
  private ValorCotizacion   cotizacion;
  private Date              imputacionAnulacion;
  private String            comentarioAnulacion;
  private ComproConta       comproConta;
  private ComproCab         comprobante;
  
  private AnuladorAsientoManual anuAsiMan = null;

  private List detalles = new ArrayList();

  public AsientoManual() throws BaseException {
  }

  public String getNickName() {
    return NICKNAME;
  }

  // Atributos del Asiento Manual

  public Date getImputacion() throws BaseException {
    supportRefresh();
    return this.getImputac();
  }

  public void setImputacion(Date aImputacion) throws BaseException {
	setImputac(aImputacion);
  }

  public ComproCab getComprobante() throws BaseException {
    supportRefresh();
    return comprobante;
  }

  public void setComprobante(ComproCab aComprobante) {
    this.comprobante = aComprobante;
  }

  public void setTipoCambio(TipoCambio tipoCambio) throws BaseException {
    this.tipoCambio = tipoCambio;
  }

  public TipoCambio getTipoCambio() throws BaseException {
    supportRefresh();
    return tipoCambio;
  }

  public void setNoContaOtrasMonedas(Boolean noContaOtrasMonedas) {
    this.noContaOtrasMonedas = noContaOtrasMonedas;
  }

  public Boolean getNoContaOtrasMonedas() throws BaseException {
    supportRefresh();
    return noContaOtrasMonedas;
  }

  public void setMoneda(Moneda moneda) throws BaseException {
    this.moneda = moneda;
    if ((getMoneda()!=null) && (getCotizacion()!=null))
    	addCotizacionMoneda(getMoneda(),getCotizacion());    
  }

  public Moneda getMoneda() throws BaseException {
      supportRefresh();
      return moneda;
  }

  public void setComproConta(ComproConta comproConta) {
    this.comproConta = comproConta;
  }

  public ComproConta getComproConta() throws BaseException {
      supportRefresh();
      return comproConta;
  }

  public void setCotizacion(ValorCotizacion cotizacion) throws BaseException {	 
    this.cotizacion = cotizacion;
    if ((getMoneda()!=null) && (getCotizacion()!=null))
    	addCotizacionMoneda(getMoneda(),getCotizacion());
  }

  public ValorCotizacion getCotizacion() {
    return cotizacion;
  }

  // Buscar Comprobante

  public static AsientoManual getNewComprobante(ISesion aSesion)
      throws BaseException {
    return (AsientoManual)ComproCab.getNew(NICKNAME,aSesion);
  }

  public static AsientoManual findByOid(Integer oid , ISesion aSesion) throws BaseException {
    return (AsientoManual) getObjectByOid(NICKNAME,oid,aSesion);
  }

  public static AsientoManual findByOidProxy(Integer oid , ISesion aSesion) throws BaseException {
     return (AsientoManual) getObjectByOidProxy(NICKNAME,oid,aSesion);
  }



  // Agregar Detalles

  public AsientoManualDet addDetalle() throws BaseException {
    AsientoManualDet asiManDet =
        (AsientoManualDet)AsientoManualDet.getNew(AsientoManualDet.NICKNAME,getSesion());
    asiManDet.setComprobante(this);
    detalles.add(asiManDet);
    return asiManDet;
  }

  // Grabacion

  public void beforeSave() throws BaseException {
    beforeSaveComprobante(this);
    if (this.isNew()) {
      this.setComprobante(this);
      this.setEstado(ComproCab.ESTADO_ALTA);
    }
  }

  public void afterSave() throws BaseException {
    Iterator iterDetalles = detalles.iterator();
    while (iterDetalles.hasNext()) {
      AsientoManualDet asiManDet = (AsientoManualDet) iterDetalles.next();
      asiManDet.save();
      asiManDet = null;
    }
    iterDetalles = null;
    afterSaveComprobante(this);
  }

  // Contabilizacion
  public RenglonesAsiento getRenglonesAsiento() throws BaseException {
    RenglonesAsiento renglones = new RenglonesAsiento();
    Iterator iterDetalles = detalles.iterator();
    while (iterDetalles.hasNext()) {
      AsientoManualDet asiManDet = (AsientoManualDet) iterDetalles.next();
      RenglonAsiento renglon = renglones.addRenglonAsiento();
      renglon.setCuentaImputable(asiManDet.getCuentaImputable());
      if (asiManDet.getSigno().intValue()==RenglonAsiento.DEBE)
        renglon.setD_H(RenglonAsiento.DEBE);
      else
        renglon.setD_H(RenglonAsiento.HABER);
      
      
      CalcImportesContables impoContable = new CalcImportesContables(getSesion(),getImputacion());
      impoContable.setTipoCambio(getTipoCambio());
      impoContable.addCotizaciones(getCotizaciones());
      ImportesContables importeContable = impoContable.getImportesContables(asiManDet.getImporte(),getMoneda());
      
      renglon.setMonedaOri(getMoneda());
      renglon.setImporteOri(asiManDet.getImporte());      
      renglon.setComentario(asiManDet.getComentario());
      renglon.setImpoLocHist(importeContable.getImpoMonLoc());
      renglon.setImpoLocAju(importeContable.getImpoMonLocAju());      
      renglon.setImpoMonExt1(importeContable.getImpoMonExt1());
      renglon.setImpoMonExt2(importeContable.getImpoMonExt2());
      renglon.setCotizOri(getCotizacion());
      renglon.setCotizMonExt1(importeContable.getValorCotizMonExt1());
      renglon.setCotizMonExt2(importeContable.getValorCotizMonExt2());
      
    }
    return renglones;
  }

  public void setImputacionAnulacion(Date imputacionAnulacion) {
    this.imputacionAnulacion = imputacionAnulacion;
  }

  public Date getImputacionAnulacion() {
    return imputacionAnulacion;
  }

  public String getComentarioAnulacion() {
    return comentarioAnulacion;
  }

  public void setComentarioAnulacion(String comentarioAnulacion) {
    this.comentarioAnulacion = comentarioAnulacion;
  }

  public static boolean contabilizarComprobante(ISesion aSesion) throws BaseException {
    ValorParametro valorParamContabilizaIngAsi =
          ValorParametro.findByCodigoParametro("CONTA_ING_ASI_MAN",aSesion);
    return valorParamContabilizaIngAsi.getBoolean();
  }

  private List getDetallesComproContaDet() throws BaseException {
    return ComproContaDet.getDetallesByComproConta(getComproConta(),getSesion());
  }

  private static TipoComprobante getTipoComproAnulacion(ISesion aSesion) throws BaseException {
    Integer oidTipoComprobante =
        ValorParametro.findByCodigoParametro("TC_ANULACION_ING_MAN_ASI",aSesion).getOidObjNeg();
    TipoComprobante tipoComprobante = TipoComprobante.findByOid(oidTipoComprobante,aSesion);
    return tipoComprobante;
  }

  public AnuladorAsientoCab anularAsiento() throws BaseException {

    int contadorDebe = ComproConta.min_secu_debe;
    int contadorHaber = ComproConta.min_secu_haber;
    AnuladorAsientoCab anuladorAsientoCab =
        AnuladorAsientoCab.findByOid(new Integer(-1),getSesion());
    if ((getComentarioAnulacion()==null) || (getComentarioAnulacion().trim().equals("")))
      setComentarioAnulacion("Contra asiento del Comprobate "+this.getComprobante().getCodigo());

    if (this.getTalonario()==null)
    	throw new ExceptionValidation(null,"No se pudo obtener el talonario del comprobante "+this.getCodigo());
    if (this.getTalonario().getTalonarioAnulacion() == null)
    	throw new ExceptionValidation(null,"No se pudo obtener el talonario de Anulación del comprobante "+this.getCodigo());
    anuladorAsientoCab.setTalonario(this.getTalonario().getTalonarioAnulacion());
    anuladorAsientoCab.setTipoCompro(this.getTalonario().getTalonarioAnulacion().getTipo_comprobante());
    anuladorAsientoCab.setLetra(this.getTalonario().getTalonarioAnulacion().getLetra());
    anuladorAsientoCab.setLugarEmision(this.getTalonario().getTalonarioAnulacion().getLugar_emision());    
    anuladorAsientoCab.setComentario(getComentarioAnulacion());
    anuladorAsientoCab.setComprobanteAnulado(this);
    anuladorAsientoCab.setFecImputacion(getImputacionAnulacion());
    anuladorAsientoCab.setUsuario(getSesion().getLogin().getUsuario());
    anuladorAsientoCab.setFecReal(Fecha.getFechaActual());
    anuladorAsientoCab.setContabiliza(true);
    anuladorAsientoCab.setEmision(Fecha.getFechaActual());
    anuladorAsientoCab.setActivo(new Boolean(true));
    

    Iterator iterDetallesComproContaDet =
        getDetallesComproContaDet().iterator();
    while (iterDetallesComproContaDet.hasNext()) {
      ComproContaDet comproContaDet =
          (ComproContaDet) iterDetallesComproContaDet.next();
      AnuladorAsientoDet anuladorAsientoDet =  anuladorAsientoCab.addDetalle();
      anuladorAsientoDet.setCuentaimputable(comproContaDet.getCuentaImputable());
      anuladorAsientoDet.setSigno(comproContaDet.getSingoInvertido());
      anuladorAsientoDet.setImpoLocAju(comproContaDet.getImpoLocAju());
      anuladorAsientoDet.setImpoLocHist(comproContaDet.getImpoLocHist());
      anuladorAsientoDet.setImpoMonExt1(comproContaDet.getImpoMonExt1());
      anuladorAsientoDet.setImpoMonExt2(comproContaDet.getImpoMonExt2());
      if (anuladorAsientoDet.getSigno().intValue()==RenglonAsiento.DEBE) {
        anuladorAsientoDet.setSecu(new Integer(contadorDebe));
        ++contadorDebe;
      }
      else {
        anuladorAsientoDet.setSecu(new Integer(contadorHaber));
        ++contadorHaber;
      }
    }
    anuladorAsientoCab.save();
    marcarEstadoCompro();
    return anuladorAsientoCab;
  }

  public void marcarEstadoCompro() throws BaseException {
    this.getComprobante().getEstado();
    this.getComprobante().setEstado(ComproCab.ESTADO_ANULADO);
    this.getComprobante().save();
  }
  
  public static List getAsientosByHelp(
  		Integer nroDesde,
  		Integer nroHasta,
  		java.util.Date fecDesde,
  		java.util.Date fecHasta,
  		java.util.Date fecImputacDesde,
  		java.util.Date fecImputacHasta,
  		CuentaImputable cuenta,
      ISesion aSesion) throws BaseException {
  	return DBAsientoManual.getAsientosByHelp(nroDesde,nroHasta,fecDesde,fecHasta,fecImputacDesde,fecImputacHasta,cuenta,aSesion);
  }
  
  public List getDetalles() throws BaseException {
  	return DBAsientoManualDet.getDetalles(this,this.getSesion());
  }
  
	public void anular() throws BaseException {

		anuAsiMan = (AnuladorAsientoManual) AnuladorAsientoManual.getNew(AnuladorAsientoManual.NICKNAME, getSesion());
		anuAsiMan.setAsiento_manual(this);
		anuAsiMan.generarComproAnulacion();
		anuAsiMan.save();

	}
  


}
