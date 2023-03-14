package com.srn.erp.ctasAPagar.bm;

import java.util.Date;
import java.util.Hashtable;
import java.util.Iterator;

import com.srn.erp.compras.bm.CondicionCompra;
import com.srn.erp.compras.bm.CondicionCompraDet;
import com.srn.erp.compras.bm.Proveedor;
import com.srn.erp.ctacte.bm.TipoCtaCteProv;
import com.srn.erp.general.bm.ComproCab;
import com.srn.erp.general.bm.Moneda;

import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.Fecha;
import framework.applicarionServer.bm.Varios.CalculadorMoney;
import framework.applicarionServer.bm.Varios.Money;
import framework.applicarionServer.bm.Varios.ValorCotizacion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;

public class GrabarCtaCteProv  {

  private ISesion         sesion;
  private ComproCab       comprobante;
  private TipoCtaCteProv  tipoCtaCteProv;
  private Proveedor       proveedor;
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
  private CondicionCompra  condicionPago;
  private Hashtable vtosFechaFija = new Hashtable();
  private Integer   signo = new Integer(1);
  private TranProv tranProv = null;
  private boolean grabarAutorizacion = false;


  public void setGrabarAutorizacion(boolean aGrabarAutorizacion) throws BaseException {
    this.grabarAutorizacion = aGrabarAutorizacion;
  }

  public boolean getGrabarAutorizacion() throws BaseException {
    return grabarAutorizacion;
  }

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

  public void setCondPago(CondicionCompra condPago) throws BaseException {
    this.condicionPago = condPago;
  }

  public CondicionCompra getCondPago() throws BaseException {
    return condicionPago;
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

  public Proveedor getProveedor() {
    return proveedor;
  }

  public ValorCotizacion getCotizMonOriCon() {
    return cotizMonOriCon;
  }

  public TipoCtaCteProv getTipoCtaCteProv() {
    return tipoCtaCteProv;
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

  public void setProveedor(Proveedor proveedor) {
    this.proveedor = proveedor;
  }

  public void setCotizMonOriCon(ValorCotizacion cotizMonOriCon) {
    this.cotizMonOriCon = cotizMonOriCon;
  }

  public void setTipoCtaCteProv(TipoCtaCteProv tipoCtaCteProv) {
    this.tipoCtaCteProv = tipoCtaCteProv;
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

  public GrabarCtaCteProv(ISesion sesion) {
    this.sesion = sesion;
  }

  public void save() throws BaseException {
    tranProv =
        (TranProv) TranProv.getNew(TranProv.NICKNAME,sesion);
    grabarTranProv(tranProv);
    grabarTranVto(tranProv);
  }

  public TranProv getTranProv() throws BaseException {
    return tranProv;
  }

  private void grabarTranProv(TranProv tranProv) throws BaseException {
    tranProv.setComprobante(getComprobante());
    tranProv.setTipocuenta(getTipoCtaCteProv());
    tranProv.setProveedor(getProveedor());
    tranProv.setMoneda(getMoneda());
    CalculadorMoney calcImporteConSigno = new CalculadorMoney(getImporte());
    calcImporteConSigno.multiplicarPor(new Money(getSigno().intValue()));
    tranProv.setImporte(calcImporteConSigno.getResultMoney());
    tranProv.setSaldo(calcImporteConSigno.getResultMoney());
    tranProv.setPendiente(new Boolean(true));
    tranProv.setImputac(getImputac());
    tranProv.setEmision(getEmision());
    tranProv.setBase(getBase());
    tranProv.setCotizmonedaori(getCotizMonOri());
    tranProv.setCotizmonedaext1(getCotizMonExt1());
    tranProv.setCotizmonedaext2(getCotizMonExt2());
    tranProv.setCotizmonedaoricon(getCotizMonOriCon());
    tranProv.setCotizmonedaext1con(getCotizMonExt1Con());
    tranProv.setCotizmonedaext2con(getCotizMonExt2Con());
    tranProv.save();
  }

  private void grabarTranVto(TranProv tranProv) throws BaseException {
	int nroCuota = 1;
    CalculadorMoney totalCuotas = new CalculadorMoney(new Money(0));
    if ((condicionPago!=null) && (!condicionPago.isVtofijo().booleanValue())) {
      Iterator iterCondCompraDet =
          condicionPago.getCondicionesCompraDet().iterator();
      nroCuota = 1;
      while (iterCondCompraDet.hasNext()) {
        CondicionCompraDet condCompraDet =
            (CondicionCompraDet) iterCondCompraDet.next();
        java.util.Date vencimiento = null;
         if (condCompraDet.isDias()==true)
           vencimiento = Fecha.getFechaMasDias(getBase(),condCompraDet.getCantidad().intValue());
         else
           vencimiento = Fecha.getFechaMasMeses(getBase(),condCompraDet.getCantidad().intValue());
         TranProvVto tranProvVto = (TranProvVto)
             TranProvVto.getNew(TranProvVto.NICKNAME,sesion);
         tranProvVto.setGrabarAutorizacion(getGrabarAutorizacion());
         tranProvVto.setTranprov(tranProv);
         tranProvVto.setVencimiento(vencimiento);
         tranProvVto.setMoneda(getMoneda());
         tranProvVto.setPendiente(new Boolean(true));
         Money cuota = calcularCuota(getImporte(),condCompraDet.getPorcentaje().doubleValue());
         totalCuotas.sumar(cuota);

         // Si es la ultima cuota realizar Ajuste
         if (iterCondCompraDet.hasNext() == false) {
           if (totalCuotas.getResultMoney().getBigDecimal().compareTo(getImporte().getBigDecimal())!=0) {
             CalculadorMoney valorCuotaAjus = new CalculadorMoney(cuota);
             valorCuotaAjus.sumar(getImporte());
             valorCuotaAjus.restar(totalCuotas.getResultMoney());
             cuota = valorCuotaAjus.getResultMoney();
           }
         }

         CalculadorMoney calcCuotaConSigno = new CalculadorMoney(cuota);
         calcCuotaConSigno.multiplicarPor(new Money(getSigno().intValue()));
         tranProvVto.setImporte(calcCuotaConSigno.getResultMoney());
         tranProvVto.setSaldo(calcCuotaConSigno.getResultMoney());
         tranProvVto.setNroCuota(nroCuota);
         tranProvVto.save();
         ++nroCuota;
       }
    }
    else {
    	
      // Agrego esta linea como no se esta mandando del lado de Delphi los Vencimientos Fijos	
      if ((vtosFechaFija==null) || (vtosFechaFija.isEmpty()))
    	  throw new ExceptionValidation("No se han ingresado fechas para el vencimiento fijo");
      Iterator iterVtosFijos = vtosFechaFija.keySet().iterator();
      nroCuota = 1;
      while (iterVtosFijos.hasNext()) {
        java.util.Date fecha = (java.util.Date) iterVtosFijos.next();
        Money monto = (Money)vtosFechaFija.get(fecha);
        TranProvVto tranProvVto = (TranProvVto)
             TranProvVto.getNew(TranProvVto.NICKNAME,sesion);
        tranProvVto.setGrabarAutorizacion(getGrabarAutorizacion());
        tranProvVto.setTranprov(tranProv);
        tranProvVto.setVencimiento(fecha);
        tranProvVto.setMoneda(getMoneda());
        tranProvVto.setPendiente(new Boolean(true));
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
        tranProvVto.setImporte(calcCuotaConSigno.getResultMoney());
        tranProvVto.setSaldo(calcCuotaConSigno.getResultMoney());
        tranProvVto.setNroCuota(nroCuota);
        tranProvVto.save();
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
