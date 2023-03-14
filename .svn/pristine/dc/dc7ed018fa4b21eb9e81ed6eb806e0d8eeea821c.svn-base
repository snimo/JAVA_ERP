package com.srn.erp.pagos.bm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.compras.bm.Proveedor;
import com.srn.erp.ctasAPagar.bm.ComproAnticipoProveedor;
import com.srn.erp.ctasAPagar.bm.ComproProveedorBase;
import com.srn.erp.ctasAPagar.bm.TranProvVto;
import com.srn.erp.general.bm.ComproCab;
import com.srn.erp.general.bm.CotizacionesConta;
import com.srn.erp.general.bm.Moneda;
import com.srn.erp.impuestos.bm.ConceptoImpuesto;

import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bm.Varios.Money;
import framework.applicarionServer.bm.Varios.ValorCotizacion;
import framework.request.bl.Utils.BaseException;

public class CalculadorRetencionesOP  {

  ValorCotizacion cotizMonPago;
  Moneda monedaPago;
  ISesion sesion;
  List listaConcRetImp = new ArrayList();
  ComproCab comprobante;
  CotizacionesConta cotizacionesConta;
  Money pagoACuentaMonPago;
  List listaCuotasPagadas = new ArrayList();
  java.util.Date fecha;
  Proveedor proveedor;
  Money totalPago;

  CalculadorRetencionGanancias calcRetGan = new CalculadorRetencionGanancias();

  public void setTotalPago(Money aTotalPago) throws BaseException {
    this.totalPago = aTotalPago;
  }

  public CalculadorRetencionGanancias getCalcRetGan() throws BaseException {
    return calcRetGan;
  }

  public boolean tieneRetencionDeGanancias() throws BaseException {
    return getCalcRetGan().tieneRetenciones();
  }

  public Money getTotalPago() throws BaseException {
    return totalPago;
  }

  public void setFecha(java.util.Date fecha) throws BaseException {
    this.fecha = fecha;
  }

  public void setProveedor(Proveedor aProveedor) throws BaseException {
    this.proveedor = aProveedor;
  }

  public java.util.Date getFecha() throws BaseException {
    return fecha;
  }

  public void setPagoACuentaMonPago(Money aPagoACuentaMonPago) {
    this.pagoACuentaMonPago = aPagoACuentaMonPago;
  }

  public Money getPagoACuentaMonPago() throws BaseException {
    return pagoACuentaMonPago;
  }

  public CalculadorRetencionesOP() {
  }

  public void setCotizacionesConta(CotizacionesConta cotizacionesConta) {
    this.cotizacionesConta = cotizacionesConta;
  }

  public CotizacionesConta getCotizacionesConta() throws BaseException {
    return cotizacionesConta;
  }

  public void setSesion(ISesion sesion) {
    this.sesion = sesion;
  }

  public void setCotizMonPago(ValorCotizacion cotizMonPago) {
    this.cotizMonPago = cotizMonPago;
  }

  public void setMonedaPago(Moneda monedaPago) {
    this.monedaPago = monedaPago;
  }

  public void setComprobante(ComproCab comprobante) {
    this.comprobante = comprobante;
  }

  public ISesion getSesion() {
    return sesion;
  }

  public ValorCotizacion getCotizMonPago() {
    return cotizMonPago;
  }

  public Moneda getMonedaPago() {
    return monedaPago;
  }

  public ComproCab getComprobante() {
    return comprobante;
  }

  public void addPagoCuotaComprobante(TranProvVto tranProvVto,
  		                                ComproAnticipoProveedor comproAnticipo,
                                      Money saldoCuota,
                                      Money descuento,
                                      Money pagado) throws BaseException {
    CuotaComproPagada cuotaPagada = new CuotaComproPagada();
    cuotaPagada.setSaldoCuota(saldoCuota);
    cuotaPagada.setComproAnticipoProv(comproAnticipo);
    cuotaPagada.setTranProvVto(tranProvVto);
    cuotaPagada.setDescuento(descuento);
    cuotaPagada.setPagado(pagado);
    listaCuotasPagadas.add(cuotaPagada);
  }

  private List getComprobantesProveedorPagados() throws BaseException {
    List listaComproProvPagados = new ArrayList();
    Iterator iterCuotasPagadas = listaCuotasPagadas.iterator();
    while (iterCuotasPagadas.hasNext()) {
      CuotaComproPagada cuotaPagada = (CuotaComproPagada) iterCuotasPagadas.next();
      ComproProveedorBase comproProBase = null;
      if (cuotaPagada.getAnticipoProveedor()!=null)
      	comproProBase = cuotaPagada.getAnticipoProveedor();
      else {
        Integer oidComproProv =
          cuotaPagada.getTranProvVto().getTranprov().getComprobante().getOIDInteger();
        comproProBase = ComproProveedorBase.findByOid(oidComproProv,getSesion());
      }
      if (!listaComproProvPagados.contains(comproProBase))
        listaComproProvPagados.add(comproProBase);
    }
    return listaComproProvPagados;
  }

  public void calcularRetenciones() throws BaseException {
    calcularRetencionesGanancias();
  }

  public List getListaRetImpu() throws BaseException {

    listaConcRetImp.clear();

    RetencionConcImpuOP retConcImpuOPRetIVA =
        (RetencionConcImpuOP) RetencionConcImpuOP.getNew(RetencionConcImpuOP.NICKNAME,sesion);
    retConcImpuOPRetIVA.setComprobante(getComprobante());
    retConcImpuOPRetIVA.setConcimpuesto(ConceptoImpuesto.findByOid(new Integer(26),sesion));
    retConcImpuOPRetIVA.setImpomonlocal(new Money(0));
    retConcImpuOPRetIVA.setImpomonpago(new Money(0));
    retConcImpuOPRetIVA.setMonedaPago(getMonedaPago());
    retConcImpuOPRetIVA.setCotizacionesConta(getCotizacionesConta());
    listaConcRetImp.add(retConcImpuOPRetIVA);

    RetencionConcImpuOP retConcImpuOPRetGan =
        (RetencionConcImpuOP) RetencionConcImpuOP.getNew(RetencionConcImpuOP.NICKNAME,sesion);
    retConcImpuOPRetGan.setComprobante(getComprobante());
    retConcImpuOPRetGan.setConcimpuesto(ConceptoImpuesto.findByOid(new Integer(26),sesion));
    retConcImpuOPRetGan.setImpomonlocal(new Money(0));
    retConcImpuOPRetGan.setImpomonpago(new Money(0));
    retConcImpuOPRetGan.setMonedaPago(getMonedaPago());
    retConcImpuOPRetGan.setCotizacionesConta(getCotizacionesConta());
    listaConcRetImp.add(retConcImpuOPRetGan);

    RetencionConcImpuOP retConcImpuOPRetIB =
        (RetencionConcImpuOP) RetencionConcImpuOP.getNew(RetencionConcImpuOP.NICKNAME,sesion);
    retConcImpuOPRetIB.setComprobante(getComprobante());
    retConcImpuOPRetIB.setConcimpuesto(ConceptoImpuesto.findByOid(new Integer(27),sesion));
    retConcImpuOPRetIB.setImpomonlocal(new Money(0));
    retConcImpuOPRetIB.setImpomonpago(new Money(0));
    retConcImpuOPRetIB.setMonedaPago(getMonedaPago());
    retConcImpuOPRetIB.setCotizacionesConta(getCotizacionesConta());
    listaConcRetImp.add(retConcImpuOPRetIB);

    return listaConcRetImp;
  }

  public Money getRetIVAMonPago() throws BaseException {
    return new Money(0);
  }

  public Money getRetGanMonPago() throws BaseException {
    return calcRetGan.getTotalRetencionMonPago();
  }

  public Money getRetGanMonLocal() throws BaseException {
    return calcRetGan.getTotalRetencionMonLoc();
  }


  public Money getRetIBMonPago() throws BaseException {
    return new Money(0);
  }

  public Money getRetIVAMonLocal() throws BaseException {
    return new Money(0);
  }

  public Money getRetIBMonLocal() throws BaseException {
    return new Money(0);
  }

  public Proveedor getProveedor() throws BaseException {
    return proveedor;
  }

  private void calcularRetencionesGanancias() throws BaseException {

    calcRetGan.setSesion(getSesion());
    calcRetGan.setFechaPago(getFecha());
    calcRetGan.setProveedor(getProveedor());
    calcRetGan.setTotalPago(getTotalPago());
    calcRetGan.setValorCotizacion(getCotizMonPago());

    Iterator iterComproProvPagados = getComprobantesProveedorPagados().iterator();
    while (iterComproProvPagados.hasNext()) {
      ComproProveedorBase comproProveedor = (ComproProveedorBase) iterComproProvPagados.next();
      calcRetGan.addComproProvAPagar(comproProveedor);
    }

    calcRetGan.calcular();
  }



}



