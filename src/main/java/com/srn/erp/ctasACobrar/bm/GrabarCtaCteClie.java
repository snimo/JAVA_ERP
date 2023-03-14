package com.srn.erp.ctasACobrar.bm;

import java.util.Date;
import java.util.Hashtable;
import java.util.Iterator;

import com.srn.erp.compras.bm.CondicionVenta;
import com.srn.erp.compras.bm.CondicionVentaDet;
import com.srn.erp.ctacte.bm.TipoCtaCteClie;
import com.srn.erp.general.bm.ComproCab;
import com.srn.erp.general.bm.Moneda;
import com.srn.erp.ventas.bm.Sujeto;

import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.Fecha;
import framework.applicarionServer.bm.Varios.CalculadorMoney;
import framework.applicarionServer.bm.Varios.Money;
import framework.applicarionServer.bm.Varios.ValorCotizacion;
import framework.request.bl.Utils.BaseException;

public class GrabarCtaCteClie  {

  private ISesion         sesion;
  private ComproCab       comprobante;
  private TipoCtaCteClie  tipoCtaCteClie;
  private Sujeto          sujeto;
  private Moneda          moneda;
  private Money           importe;
  private java.util.Date  emision;
  private java.util.Date  imputac;
  private java.util.Date  base;
  private ValorCotizacion cotizMonOri;
  private ValorCotizacion cotizMonExt1;
  private ValorCotizacion cotizMonExt2;
  private ValorCotizacion cotizMonOriCon;
  private ValorCotizacion cotizMonExt1Con;
  private ValorCotizacion cotizMonExt2Con;
  private CondicionVenta  condicionVenta;
  private Hashtable vtosFechaFija = new Hashtable();
  private Integer   signo = new Integer(1);
  private TranClie tranClie = null;


  public void setSigno(Integer signo) throws BaseException {
    this.signo = signo;
  }

  public Integer getSigno() throws BaseException {
    return signo;
  }

  public void addVtoFijo(java.util.Date vto,Money monto) throws BaseException {
    vtosFechaFija.put(vto,monto);
  }

  public void addVtoFechaFija(java.util.Date fecha,Money monto) throws BaseException {
    vtosFechaFija.put(fecha,monto);
  }

  public void setCondVenta(CondicionVenta condVenta) throws BaseException {
    this.condicionVenta = condVenta;
  }

  public CondicionVenta getCondVenta() throws BaseException {
    return condicionVenta;
  }

  public Money getImporte() {
    return importe;
  }

  public ValorCotizacion getCotizMonExt2() {
    return cotizMonExt2;
  }

  public Date getEmision() {
    return emision;
  }

  public Sujeto getSujeto() {
    return sujeto;
  }

  public ValorCotizacion getCotizMonOriCon() {
    return cotizMonOriCon;
  }

  public TipoCtaCteClie getTipoCtaCteClie() {
    return tipoCtaCteClie;
  }

  public Date getBase() {
    return base;
  }

  public ComproCab getComprobante() {
    return comprobante;
  }

  public Moneda getMoneda() {
    return moneda;
  }

  public ValorCotizacion getCotizMonExt1Con() {
    return cotizMonExt1Con;
  }

  public ValorCotizacion getCotizMonOri() {
    return cotizMonOri;
  }

  public ValorCotizacion getCotizMonExt2Con() {
    return cotizMonExt2Con;
  }

  public Date getImputac() {
    return imputac;
  }

  public void setCotizMonExt1(ValorCotizacion cotizMonExt1) {
    this.cotizMonExt1 = cotizMonExt1;
  }

  public void setImporte(Money importe) {
    this.importe = importe;
  }

  public void setCotizMonExt2(ValorCotizacion cotizMonExt2) {
    this.cotizMonExt2 = cotizMonExt2;
  }

  public void setEmision(Date emision) {
    this.emision = emision;
  }

  public void setSujeto(Sujeto sujeto) {
    this.sujeto = sujeto;
  }

  public void setCotizMonOriCon(ValorCotizacion cotizMonOriCon) {
    this.cotizMonOriCon = cotizMonOriCon;
  }

  public void setTipoCtaCteClie(TipoCtaCteClie tipoCtaCteClie) {
    this.tipoCtaCteClie = tipoCtaCteClie;
  }

  public void setBase(Date base) {
    this.base = base;
  }

  public void setComprobante(ComproCab comprobante) {
    this.comprobante = comprobante;
  }

  public void setMoneda(Moneda moneda) {
    this.moneda = moneda;
  }

  public void setCotizMonExt1Con(ValorCotizacion cotizMonExt1Con) {
    this.cotizMonExt1Con = cotizMonExt1Con;
  }

  public void setCotizMonOri(ValorCotizacion cotizMonOri) {
    this.cotizMonOri = cotizMonOri;
  }

  public void setCotizMonExt2Con(ValorCotizacion cotizMonExt2Con) {
    this.cotizMonExt2Con = cotizMonExt2Con;
  }

  public void setImputac(Date imputac) {
    this.imputac = imputac;
  }

  public ValorCotizacion getCotizMonExt1() {
    return cotizMonExt1;
  }

  public GrabarCtaCteClie(ISesion sesion) {
    this.sesion = sesion;
  }

  public void save() throws BaseException {
    tranClie =
        (TranClie) TranClie.getNew(TranClie.NICKNAME,sesion);
    grabarTranClie(tranClie);
    grabarTranClieVto(tranClie);
  }

  public TranClie getTranClie() throws BaseException {
    return tranClie;
  }

  private void grabarTranClie(TranClie tranClie) throws BaseException {
    tranClie.setComprobante(getComprobante());
    tranClie.setTipo_cta_cte(getTipoCtaCteClie());
    tranClie.setSujeto(getSujeto());
    tranClie.setMoneda(getMoneda());
    CalculadorMoney calcImporteConSigno = new CalculadorMoney(getImporte());
    calcImporteConSigno.multiplicarPor(new Money(getSigno().intValue()));
    tranClie.setImporte(calcImporteConSigno.getResultMoney());
    tranClie.setSaldo(calcImporteConSigno.getResultMoney());
    tranClie.setPendiente(new Boolean(true));
    tranClie.setImputac(getImputac());
    tranClie.setEmision(getEmision());
    tranClie.setBase(getBase());
    tranClie.setCotiz_mon_ori(getCotizMonOri());
    tranClie.setCotiz_mon_ext1(getCotizMonExt1());
    tranClie.setCotiz_mon_ext2(getCotizMonExt2());
    tranClie.setCotiz_mon_ori_co(getCotizMonOriCon());
    tranClie.setCotiz_mon_ext1_co(getCotizMonExt1Con());
    tranClie.setCotiz_mon_ext2_co(getCotizMonExt2Con());
    tranClie.save();
  }

  private void grabarTranClieVto(TranClie tranClie) throws BaseException {
	int nroCuota = 1;
    CalculadorMoney totalCuotas = new CalculadorMoney(new Money(0));
    if ((condicionVenta!=null) && (!condicionVenta.isVtofijo().booleanValue())) {
      Iterator iterCondVentaDet =
          condicionVenta.getCondicionesVentaDet().iterator();
      nroCuota = 1;
      while (iterCondVentaDet.hasNext()) {
        CondicionVentaDet condVentaDet =
            (CondicionVentaDet) iterCondVentaDet.next();
        java.util.Date vencimiento = null;
         if (condVentaDet.isDias()==true)
           vencimiento = Fecha.getFechaMasDias(getBase(),condVentaDet.getCantidad().intValue());
         else
           vencimiento = Fecha.getFechaMasMeses(getBase(),condVentaDet.getCantidad().intValue());
         TranClieVto tranClieVto = (TranClieVto)
             TranClieVto.getNew(TranClieVto.NICKNAME,sesion);
         tranClieVto.setTran_clie(tranClie);
         tranClieVto.setVto(vencimiento);
         tranClieVto.setMoneda(getMoneda());
         tranClieVto.setPendiente(new Boolean(true));
         Money cuota = calcularCuota(getImporte(),condVentaDet.getPorcentaje().doubleValue());
         totalCuotas.sumar(cuota);

         // Si es la ultima cuota realizar Ajuste
         if (iterCondVentaDet.hasNext() == false) {
           if (totalCuotas.getResultMoney().getBigDecimal().compareTo(getImporte().getBigDecimal())!=0) {
             CalculadorMoney valorCuotaAjus = new CalculadorMoney(cuota);
             valorCuotaAjus.sumar(getImporte());
             valorCuotaAjus.restar(totalCuotas.getResultMoney());
             cuota = valorCuotaAjus.getResultMoney();
           }
         }

         CalculadorMoney calcCuotaConSigno = new CalculadorMoney(cuota);
         calcCuotaConSigno.multiplicarPor(new Money(getSigno().intValue()));
         tranClieVto.setImporte(calcCuotaConSigno.getResultMoney());
         tranClieVto.setSaldo(calcCuotaConSigno.getResultMoney());
         tranClieVto.setNroCuota(new Integer(nroCuota));
         tranClieVto.save();
         
         ++nroCuota;
         
       }
    }
    else {
      nroCuota = 1; 
      Iterator iterVtosFijos = vtosFechaFija.keySet().iterator();
      while (iterVtosFijos.hasNext()) {
        java.util.Date fecha = (java.util.Date) iterVtosFijos.next();
        Money monto = (Money)vtosFechaFija.get(fecha);
        TranClieVto tranClieVto = (TranClieVto)
             TranClieVto.getNew(TranClieVto.NICKNAME,sesion);
        tranClieVto.setTran_clie(tranClie);
        tranClieVto.setVto(fecha);
        tranClieVto.setMoneda(getMoneda());
        tranClieVto.setPendiente(new Boolean(true));
        // Si es la ultima cuota realizar Ajuste
        Money cuota = monto;
        totalCuotas.sumar(cuota);

        if (iterVtosFijos.hasNext() == false) {
          if (totalCuotas.getResultMoney().getBigDecimal().compareTo(getImporte().
              getBigDecimal()) != 0) {
            CalculadorMoney valorCuotaAjus = new CalculadorMoney(cuota);
            valorCuotaAjus.sumar(getImporte());
            valorCuotaAjus.restar(totalCuotas.getResultMoney());
            cuota = valorCuotaAjus.getResultMoney();
          }
        }

        CalculadorMoney calcCuotaConSigno = new CalculadorMoney(cuota);
        calcCuotaConSigno.multiplicarPor(new Money(getSigno().intValue()));
        tranClieVto.setImporte(calcCuotaConSigno.getResultMoney());
        tranClieVto.setSaldo(calcCuotaConSigno.getResultMoney());
        tranClieVto.setNroCuota(new Integer(nroCuota));
        tranClieVto.save();
        ++nroCuota;
      }
    }
  }

  private Money calcularCuota(Money importe, double porc) throws BaseException {
    CalculadorMoney calcMoney = new CalculadorMoney(importe);
    calcMoney.multiplicarPor(new Money(porc));
    calcMoney.dividirPor(new Money(100));
    return calcMoney.getResultMoney();
  }

}
