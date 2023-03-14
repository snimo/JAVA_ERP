package com.srn.erp.pagos.bm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.compras.bm.Proveedor;
import com.srn.erp.ctasAPagar.bm.ComproProveedorBase;
import com.srn.erp.impuestos.bm.ConceptoImpuesto;

import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bm.Varios.CalculadorMoney;
import framework.applicarionServer.bm.Varios.Money;
import framework.applicarionServer.bm.Varios.ValorCotizacion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;

public class CalculadorRetencionGanancias  {

  private java.util.Date fechaPago;
  private Proveedor proveedor;
  private ISesion sesion;
  private PeriRetGan periRetGan;
  private CatRetGan catRetGan;
  private Money porcLibRet;
  private Money totalPago;
  private List listaComproProvAPagar = new ArrayList();
  private CertificadoRetGanCab certRetGanCab;
  private List listaDetallesCertificado = new ArrayList();
  private Money retencionMonLoc = new Money(0);
  private Money retencionMonPago = new Money(0);
  private ValorCotizacion cotizacion;
  private int newOid = 0;

  public Money getTotalRetencionMonLoc() throws BaseException {
    return retencionMonLoc;
  }

  public Money getTotalRetencionMonPago() throws BaseException {
    return retencionMonPago;
  }

  public void setValorCotizacion(ValorCotizacion aValorCotizacion) throws BaseException {
    this.cotizacion = aValorCotizacion;
  }

  public ValorCotizacion getValorCotizacion() throws BaseException {
    return cotizacion;
  }

  public void setCertificadoRetGan(CertificadoRetGanCab certRetGanCab) throws BaseException {
    this.certRetGanCab = certRetGanCab;
  }

  public CertificadoRetGanCab getCertRetGanCab() throws BaseException {
    return certRetGanCab;
  }

  public void addComproProvAPagar(ComproProveedorBase aComproProv) throws BaseException {
    if (!listaComproProvAPagar.contains(aComproProv))
      listaComproProvAPagar.add(aComproProv);
  }

  public void setTotalPago(Money aTotalPago) {
    this.totalPago = aTotalPago;
  }

  public Money getTotalPago() throws BaseException {
    return totalPago;
  }

  public CatRetGan getCatRetGan() {
    return catRetGan;
  }

  public void setSesion(ISesion aSesion) throws BaseException {
    this.sesion = aSesion;
  }

  public ISesion getSesion() throws BaseException {
    return sesion;
  }

  public void setFechaPago(java.util.Date aFechaPago) throws BaseException {
    this.fechaPago = aFechaPago;
  }

  public java.util.Date getFechaPago() throws BaseException {
    return fechaPago;
  }

  public void setProveedor(Proveedor aProveedor) throws BaseException {
    this.proveedor = aProveedor;
  }

  public Proveedor getProveedor() throws BaseException {
    return proveedor;
  }

  public CalculadorRetencionGanancias() {

  }

  public PeriRetGan getPeriRetGan() {
    return periRetGan;
  }

  private Money getPorcLibRetGan() throws BaseException {
    Money porc = new Money(0);
    PorcLibRetGan porcLib = getProveedor().getSujetoimpositivo().getPorcLibRetGan(getFechaPago());
    if (porcLib!=null)
        porc = porcLib.getPorcentaje();
    return porc;
  }

  private String getDecreto() throws BaseException {
    String decreto = "";
    PorcLibRetGan porcLib = getProveedor().getSujetoimpositivo().getPorcLibRetGan(getFechaPago());
    if (porcLib!=null)
        decreto = porcLib.getDecreto();
    return decreto;

  }

  private boolean obtenerPeriRetGan() throws BaseException {
    periRetGan = PeriRetGan.getPeriRetGan(getFechaPago(),getSesion());
    if (periRetGan != null)
      return true;
    else
      return false;
  }

  private boolean obtenerLaCategRetGan() throws BaseException {
    if (proveedor.getSujetoimpositivo()!=null)
       this.catRetGan = proveedor.getSujetoimpositivo().getCatRetGan();
    if (this.catRetGan != null)
      return true;
    else
      return false;
  }

  private boolean obtenerPorcLibRetGan() throws BaseException {
    if (proveedor.getSujetoimpositivo()!=null)
      if (proveedor.getSujetoimpositivo().getPorcLibRetGan(getFechaPago())!=null)
        porcLibRet = proveedor.getSujetoimpositivo().getPorcLibRetGan(getFechaPago()).getPorcentaje();
    if (porcLibRet == null)
        porcLibRet = new Money(0);
    return true;
  }

  private void calcularRetencionesPorConcepto() throws BaseException {

    CalculadorMoney totRetMonLoc = new CalculadorMoney(new Money(0));

    Iterator iterConcRetGan = getConceptosRetencionesGanancias().iterator();
    int newOid = 0;
    while (iterConcRetGan.hasNext()) {
      ConceptoImpuesto conceptoImpuesto = (ConceptoImpuesto) iterConcRetGan.next();
      Money totalMontoGravadoPagoActual = getTotMontosGravadosPorConceptoRetencionMonLocal(conceptoImpuesto);

      CalculadorMoney calcProporcionalDelPago = new CalculadorMoney(totalMontoGravadoPagoActual);
      calcProporcionalDelPago.multiplicarPor(getTotalPago());
      calcProporcionalDelPago.dividirPor(getImpoTotalComprobantes());

      Money montoNOImponible = getMontoNoImponible(conceptoImpuesto);
      Money retencionMinima = getRetencionMinima(conceptoImpuesto);
      Money pagoAcumMontoGravados = getPagoAcumNetoGravadoPeriFiscal(conceptoImpuesto);
      Money pagoAcumMontoRetenidos = getPagoAcumMontosRetenidosPeriFiscal(conceptoImpuesto);

      CalculadorMoney calcMontoBaseARetener = new CalculadorMoney(new Money(0));
      calcMontoBaseARetener.sumar(pagoAcumMontoGravados);
      calcMontoBaseARetener.sumar(calcProporcionalDelPago.getResultMoney());
      calcMontoBaseARetener.restar(montoNOImponible);

      RetCabGan retCabGan = getRetCabGan(getCatRetGan(),conceptoImpuesto);
      RetCabGanDet retCabGanDet = retCabGan.getRetGanDet(calcMontoBaseARetener.getResultMoney());

      if (retCabGanDet == null) throw new ExceptionValidation(null,"No se ha encontrado un rango de Retención "+
          "para "+calcMontoBaseARetener.getResultMoney().doubleValue()+" correspondiente a la categoría "+getCatRetGan().getDescripcion()+
          " y el impuesto "+conceptoImpuesto.getDescripcion());

      CalculadorMoney calcPorcLib = new CalculadorMoney(new Money(0));
      Money porcLib = getPorcLibRetGan();
      calcPorcLib.sumar(new Money(1));
      calcPorcLib.restar(new Money(porcLib.doubleValue()/100.0));

      Money retencion = new Money(0);
      CalculadorMoney montoRetencion = new CalculadorMoney(new Money(0));
      montoRetencion.sumar(calcMontoBaseARetener.getResultMoney());
      montoRetencion.restar(retCabGanDet.getMontodesde());
      montoRetencion.multiplicarPor(retCabGanDet.getPorc());
      montoRetencion.dividirPor(new Money(100));
      montoRetencion.sumar(retCabGanDet.getMontofijo());
      
      montoRetencion.multiplicarPor(calcPorcLib.getResultMoney());
      montoRetencion.restar(pagoAcumMontoRetenidos);
      if (montoRetencion.getResultMoney().doubleValue()>retencionMinima.doubleValue())
        retencion = montoRetencion.getResultMoney();

     CertificadoRetGanDet certRetGanDet = addCertificadoDetalle();
     --newOid;
     certRetGanDet.setOID(new Integer(newOid));
     certRetGanDet.setConceptoimpuesto(conceptoImpuesto);
     certRetGanDet.setMontonoimponible(montoNOImponible);
     certRetGanDet.setCertificado(getCertRetGanCab());
     certRetGanDet.setMontogravado(totalMontoGravadoPagoActual);
     certRetGanDet.setPorcentaje(retCabGanDet.getPorc());
     certRetGanDet.setMontoretminima(retencionMinima);
     certRetGanDet.setBasepararetener(calcMontoBaseARetener.getResultMoney());
     certRetGanDet.setPagoacum(pagoAcumMontoGravados);
     certRetGanDet.setRetacum(pagoAcumMontoRetenidos);
     certRetGanDet.setPagoneto(totalMontoGravadoPagoActual);
     certRetGanDet.setImpuestoretenido(retencion);
     certRetGanDet.setMontofijo(retCabGanDet.getMontofijo());

     totRetMonLoc.sumar(retencion);

    }

    retencionMonLoc = totRetMonLoc.getResultMoney();
    CalculadorMoney calcRetMonPago = new CalculadorMoney(retencionMonLoc);
    calcRetMonPago.multiplicarPor(getValorCotizacion());
    retencionMonPago = calcRetMonPago.getResultMoney();
  }

  private Money getPagoAcumNetoGravadoPeriFiscal(ConceptoImpuesto conceptoImpuesto) throws BaseException {
    Money pagoAcum = new Money(0);
    PagoAcumRetGan pagoAcumMontoGravadoRetGan =
        PagoAcumRetGan.getPagoAcumRetGan(getProveedor().getSujetoimpositivo(),
        getPeriRetGan(),
        conceptoImpuesto,
        getSesion());
    if (pagoAcumMontoGravadoRetGan != null)
       pagoAcum = pagoAcumMontoGravadoRetGan.getPagoacum();

    return pagoAcum;
  }

  private Money getPagoAcumMontosRetenidosPeriFiscal(ConceptoImpuesto conceptoImpuesto) throws BaseException {
    Money pagoAcum = new Money(0);
    PagoAcumRetGan pagoAcumMontoGravadoRetGan =
        PagoAcumRetGan.getPagoAcumRetGan(getProveedor().getSujetoimpositivo(),
        getPeriRetGan(),
        conceptoImpuesto,
        getSesion());
    if (pagoAcumMontoGravadoRetGan!=null)
        pagoAcum = pagoAcumMontoGravadoRetGan.getPagoretenido();
    return pagoAcum;
  }


  private RetCabGan getRetCabGan(CatRetGan categRetGab,ConceptoImpuesto concImpu) throws BaseException {
    return RetCabGan.getRetGanCab(categRetGab,concImpu,getFechaPago(),getSesion());
  }

  private Money getMontoNoImponible(ConceptoImpuesto conceptoImpuesto) throws BaseException {
    RetCabGan retCabGan = getRetCabGan(getCatRetGan(),conceptoImpuesto);
    return retCabGan.getMontonoimpo();
  }

  private Money getRetencionMinima(ConceptoImpuesto conceptoImpuesto) throws BaseException {
    RetCabGan retCabGan = getRetCabGan(getCatRetGan(),conceptoImpuesto);
    return retCabGan.getMontoretmin();
  }


  private Money getTotMontosGravadosPorConceptoRetencionMonLocal(ConceptoImpuesto conceptoImpuesto) throws BaseException {
    CalculadorMoney totMontosGravadosPorConcRet = new CalculadorMoney(new Money(0));
    Iterator iterComprobantesProveedor = listaComproProvAPagar.iterator();
    while (iterComprobantesProveedor.hasNext()) {
      ComproProveedorBase comproProveedor =
          (ComproProveedorBase) iterComprobantesProveedor.next();
      Money totComproRet =
          comproProveedor.getTotMontoGravadoPorConceptoRetencionMonLocal(conceptoImpuesto);
      totMontosGravadosPorConcRet.sumar(totComproRet);
    }
    return totMontosGravadosPorConcRet.getResultMoney();
  }

  private List getConceptosRetencionesGanancias() throws BaseException {
    List listaConcRetGan = new ArrayList();
    Iterator iterComprobantesProveedor = listaComproProvAPagar.iterator();
    while (iterComprobantesProveedor.hasNext()) {
      ComproProveedorBase comproProveedor =
          (ComproProveedorBase) iterComprobantesProveedor.next();
      Iterator iterImpuRetGan = comproProveedor.getImpuestosRetencionGan().iterator();
      while (iterImpuRetGan.hasNext()) {
        ConceptoImpuesto conceptoImpuesto =
            (ConceptoImpuesto) iterImpuRetGan.next();
        if (!listaConcRetGan.contains(conceptoImpuesto))
          listaConcRetGan.add(conceptoImpuesto);
      }
    }
    return listaConcRetGan;
  }

  private Money getMontoBaseParaRetener(Money montoPagoAcum,
                                        Money montoPagoActual,
                                        Money montoNoImponible) throws BaseException {
    CalculadorMoney calcMontoBaseParaRetener = new CalculadorMoney(montoPagoAcum);
    calcMontoBaseParaRetener.sumar(montoPagoActual);
    calcMontoBaseParaRetener.restar(montoNoImponible);
    return calcMontoBaseParaRetener.getResultMoney();
  }

  private Money getMontoPagadoAcum(ConceptoImpuesto concImpu) throws BaseException {
    PagoAcumRetGan pagoAcumRetGan = PagoAcumRetGan.getPagoAcumRetGan(getProveedor().getSujetoimpositivo(),
                                                                     getPeriRetGan(),
                                                                     concImpu,
                                                                     getSesion());
    if (pagoAcumRetGan == null)
      return new Money(0);
    else
      return pagoAcumRetGan.getPagoacum();
  }

  private Money getMontoRetenidoAcum(ConceptoImpuesto concImpu) throws BaseException {
    PagoAcumRetGan pagoAcumRetGan = PagoAcumRetGan.getPagoAcumRetGan(getProveedor().getSujetoimpositivo(),
                                                                     getPeriRetGan(),
                                                                     concImpu,
                                                                     getSesion());
    if (pagoAcumRetGan == null)
      return new Money(0);
    else
      return pagoAcumRetGan.getPagoretenido();
  }

  private Money getImpoTotalComprobantes() throws BaseException {
    CalculadorMoney totalBrutoComprobantes = new CalculadorMoney(new Money(0));
    Iterator iterComprobantesProveedor = listaComproProvAPagar.iterator();
    while (iterComprobantesProveedor.hasNext()) {
      ComproProveedorBase comproProveedor =
          (ComproProveedorBase) iterComprobantesProveedor.next();
      totalBrutoComprobantes.sumar(comproProveedor.getTotMonedaLoc());
    }
    return totalBrutoComprobantes.getResultMoney();
  }

  public void calcular() throws BaseException {
    if (obtenerPeriRetGan()==false) return;
    if (obtenerLaCategRetGan()==false) return;
    if (obtenerPorcLibRetGan()==false) return;

    altaCertificadorRetGanCab();
    calcularRetencionesPorConcepto();
  }

  private void altaCertificadorRetGanCab() throws BaseException {
    CertificadoRetGanCab certifRetGanCab = (CertificadoRetGanCab) CertificadoRetGanCab.getNew(CertificadoRetGanCab.NICKNAME,getSesion());
    --newOid;
    certifRetGanCab.setOID(new Integer(newOid));
    certifRetGanCab.setOrdendepago(null);
    certifRetGanCab.setProveedor(getProveedor());
    certifRetGanCab.setPeriretgan(getPeriRetGan());
    certifRetGanCab.setCatretgan(getCatRetGan());
    certifRetGanCab.setPorclib(getPorcLibRetGan());
    certifRetGanCab.setDecreto(getDecreto());
    setCertificadoRetGan(certifRetGanCab);
  }

  public CertificadoRetGanDet addCertificadoDetalle() throws BaseException {
    --newOid;
    CertificadoRetGanDet certRetGanDet = (CertificadoRetGanDet) CertificadoRetGanDet.getNew(CertificadoRetGanDet.NICKNAME,getSesion());
    certRetGanDet.setOID(new Integer(newOid));
    listaDetallesCertificado.add(certRetGanDet);
    return certRetGanDet;
  }

  public List getDetallesCertificado() throws BaseException {
    return listaDetallesCertificado;
  }

  public boolean tieneRetenciones() throws BaseException {
    if (listaDetallesCertificado.size()>0)
      return true;
    else
      return false;
  }



}



