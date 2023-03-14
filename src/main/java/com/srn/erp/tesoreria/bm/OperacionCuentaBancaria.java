package com.srn.erp.tesoreria.bm;

import java.util.Date;

import com.srn.erp.bancos.bm.ConciliacionCab;
import com.srn.erp.contabilidad.bm.CuentaImputable;
import com.srn.erp.general.bm.ComproCab;
import com.srn.erp.general.bm.Periodo;

import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bm.Varios.CalculadorMoney;
import framework.applicarionServer.bm.Varios.Money;
import framework.applicarionServer.bm.Varios.ValorCotizacion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;

public class OperacionCuentaBancaria {

  private CuentaBancaria ctaBancaria;
  private Integer nroValor;
  private String tipoMov;
  private Date fechaOperativa;
  private Date fechaContable;
  private Date fechaEmision;
  private Date fechaVto;
  private Integer signo;
  private Money importe;
  private ComproCab comprobante;
  private Boolean activo;
  private Money importeHist;
  private Money importeAju;
  private Money importeExt1;
  private Money importeExt2;
  private ISesion sesion;
  private ValorCotizacion cotizMonOri;
  private ValorCotizacion cotizMonExt1;
  private ValorCotizacion cotizMonExt2;
  private ValorCotizacion cotizMonOriCon;
  private ValorCotizacion cotizMonExt1Con;
  private ValorCotizacion cotizMonExt2Con;
  private MovimientoCtaBancaria movCtaBanco;
  private Valor valor;
  private TipoValor tipoValor;
  private CuentaImputable cuenta;
  private Boolean conciliado;
  private ConciliacionCab conciliacion; 
  

  public ValorCotizacion getCotizMonOri() throws BaseException {
    return cotizMonOri;
  }
  
  public void setConciliado(Boolean aConciliado) throws BaseException {
	  this.conciliado = aConciliado;
  }
  
  public void setConciliacionCab(ConciliacionCab aConciliacionCab) throws BaseException {
	  this.conciliacion = aConciliacionCab;
  }  
  
  public ConciliacionCab getConciliacionCab() throws BaseException {
	  return this.conciliacion;
  }  
  
  public Boolean getConciliado() throws BaseException {
	  return conciliado;
  }

  public void setCotizMonOri(ValorCotizacion aValorCotizacion) throws BaseException {
    this.cotizMonOri = aValorCotizacion;
  }

  public ValorCotizacion getCotizMonExt1() throws BaseException {
    return cotizMonExt1;
  }

  public void setCotizMonExt1(ValorCotizacion aValorCotizacion) throws BaseException {
    this.cotizMonExt1 = aValorCotizacion;
  }

  public ValorCotizacion getCotizMonExt2() throws BaseException {
    return cotizMonExt2;
  }

  public void setCotizMonExt2(ValorCotizacion aValorCotizacion) throws BaseException {
    this.cotizMonExt2 = aValorCotizacion;
  }

  public ValorCotizacion getCotizMonOriCon() throws BaseException {
    return cotizMonOriCon;
  }

  public void setCotizMonOriCon(ValorCotizacion aValorCotizacion) throws BaseException {
    this.cotizMonOriCon = aValorCotizacion;
  }


  public ValorCotizacion getCotizMonExt1Con() throws BaseException {
    return cotizMonExt1Con;
  }

  public void setCotizMonExt1Con(ValorCotizacion aValorCotizacion) throws BaseException {
    this.cotizMonExt1Con = aValorCotizacion;
  }

  public ValorCotizacion getCotizMonExt2Con() throws BaseException {
    return cotizMonExt2Con;
  }

  public void setCotizMonExt2Con(ValorCotizacion aValorCotizacion) throws BaseException {
    this.cotizMonExt2Con = aValorCotizacion;
  }


  public ISesion getSesion() throws BaseException {
    return sesion;
  }

  public void setSesion(ISesion aSesion) throws BaseException {
    this.sesion = aSesion;
  }


  public Money getImporte() {
  	if (importe == null)
  		return new Money(0);
  	else
  		return importe;
  }

  public Money getImporteAju() {
  	if (importeAju == null)
  		return new Money(0);
  	else
  		return importeAju;
  }

  public Date getFechaEmision() {
    return fechaEmision;
  }

  public Date getFechaContable() {
    return fechaContable;
  }
  
  public Date getFechaOperativa() {
	return fechaOperativa;
  }
  

  public Money getImporteExt1() {
  	if (importeExt1 == null)
  		return new Money(0);
  	else
  		return importeExt1;
  }

  public Integer getSigno() {
    return signo;
  }

  public Boolean getActivo() {
    return activo;
  }

  public Money getImporteHist() {
  	if (importeHist == null)
  		return new Money(0);
  	else
  		return importeHist;
  }

  public ComproCab getComprobante() {
    return comprobante;
  }

  public String getTipoMov() {
    return tipoMov;
  }

  public Date getFechaVto() {
    return fechaVto;
  }

  public Integer getNroValor() {
    return nroValor;
  }

  public Money getImporteExt2() {
  	if (importeExt2 == null)
  		return new Money(0);
  	else
  		return importeExt2;
  }

  public void setCtaBancaria(CuentaBancaria ctaBancaria) {
    this.ctaBancaria = ctaBancaria;
  }

  public void setImporte(Money importe) {
    this.importe = importe;
  }
  
  public void AcumImporte(Money importe) throws BaseException {
  	CalculadorMoney calcImporte = 
  		new CalculadorMoney(this.getImporte());
  	calcImporte.sumar(importe);
  	this.setImporte(calcImporte.getResultMoney());
  }

  public void setImporteAju(Money importeAju) {
    this.importeAju = importeAju;
  }
  
  public void AcumImporteAju(Money importe) throws BaseException {
  	CalculadorMoney calcImporte = 
  		new CalculadorMoney(this.getImporteAju());
  	calcImporte.sumar(importe);
  	this.setImporteAju(calcImporte.getResultMoney());
  }  
  

  public void setFechaEmision(Date fechaEmision) {
    this.fechaEmision = fechaEmision;
  }

  public void setFechaContable(Date fechaContable) {
    this.fechaContable = fechaContable;
  }
  
  public void setFechaOperativa(Date fechaOperativa) {
	this.fechaOperativa = fechaOperativa;
  }
  

  public void setImporteExt1(Money importeExt1) {
    this.importeExt1 = importeExt1;
  }
  
  public void AcumImporteExt1(Money importe) throws BaseException {
  	CalculadorMoney calcImporte = 
  		new CalculadorMoney(this.getImporteExt1());
  	calcImporte.sumar(importe);
  	this.setImporteExt1(calcImporte.getResultMoney());
  }
  
  public void AcumImporteExt2(Money importe) throws BaseException {
  	CalculadorMoney calcImporte = 
  		new CalculadorMoney(this.getImporteExt2());
  	calcImporte.sumar(importe);
  	this.setImporteExt2(calcImporte.getResultMoney());
  }  
  
  

  public void setSigno(Integer signo) {
    this.signo = signo;
  }

  public void setActivo(Boolean activo) {
    this.activo = activo;
  }

  public void setImporteHist(Money importeHist) {
    this.importeHist = importeHist;
  }
  
  public void AcumImporteHist(Money importe) throws BaseException {
  	CalculadorMoney calcImporte = 
  		new CalculadorMoney(this.getImporteHist());
  	calcImporte.sumar(importe);
  	this.setImporteHist(calcImporte.getResultMoney());
  }  

  public void setComprobante(ComproCab comprobante) {
    this.comprobante = comprobante;
  }

  public void setTipoMov(String tipoMov) {
    this.tipoMov = tipoMov;
  }

  public void setFechaVto(Date fechaVto) {
    this.fechaVto = fechaVto;
  }

  public void setNroValor(Integer nroValor) {
    this.nroValor = nroValor;
  }

  public void setImporteExt2(Money importeExt2) {
    this.importeExt2 = importeExt2;
  }

  public CuentaBancaria getCtaBancaria() {
    return ctaBancaria;
  }

  public OperacionCuentaBancaria() {
  }

  private void grabarMovimiento() throws BaseException {
    movCtaBanco =
        (MovimientoCtaBancaria) MovimientoCtaBancaria.getNew(MovimientoCtaBancaria.NICKNAME,getSesion());
    movCtaBanco.setCtabancaria(getCtaBancaria());
    movCtaBanco.setValor(getValor());
    movCtaBanco.setTipoValor(getTipoValor());
    movCtaBanco.setNrovalor(getNroValor());
    movCtaBanco.setTipomov(getTipoMov());
    movCtaBanco.setFechacontable(getFechaContable());
    movCtaBanco.setFechaOperativa(getFechaOperativa());
    movCtaBanco.setFechaemision(getFechaEmision());
    movCtaBanco.setFechavto(getFechaVto());
    movCtaBanco.setSigno(getSigno());
    movCtaBanco.setCuenta(getCuenta());
    movCtaBanco.setImporte(getImporte());
    movCtaBanco.setComprobante(getComprobante());
    movCtaBanco.setImportehist(getImporteHist());
    movCtaBanco.setImporteaju(getImporteAju());
    movCtaBanco.setImporteext1(getImporteExt1());
    movCtaBanco.setImporteext2(getImporteExt2());
    movCtaBanco.setActivo(getActivo());
    movCtaBanco.setCotizMonOri(getCotizMonOri());
    movCtaBanco.setCotizMonExt1(getCotizMonExt1());
    movCtaBanco.setCotizMonExt2(getCotizMonExt2());
    movCtaBanco.setCotizMonOriCon(getCotizMonOriCon());
    movCtaBanco.setCotizMonExt1Con(getCotizMonExt1Con());
    movCtaBanco.setCotizMonExt2Con(getCotizMonExt2Con());
    movCtaBanco.setConciliado(getConciliado());
    movCtaBanco.setConciliacionCab(getConciliacionCab());
    movCtaBanco.save();
  }


  private SaldoCtaBancoDia grabarNewSaldoDia() throws BaseException {
    SaldoCtaBancoDia saldoCtaBancoDia =
        (SaldoCtaBancoDia)SaldoCtaBancoDia.getNew(SaldoCtaBancoDia.NICKNAME,
                                                  getSesion());
    saldoCtaBancoDia.setCuentabancaria(getCtaBancaria());
    saldoCtaBancoDia.setFecha(getFechaContable());
    actuSaldoDia(saldoCtaBancoDia);
    saldoCtaBancoDia.save();
    return saldoCtaBancoDia;
  }
  
    private void actuSaldoDia(SaldoCtaBancoDia saldoCtaBancoDia) throws BaseException {
  	
  	Money debito 	   = new Money(0);
  	Money debitoHist = new Money(0);
  	Money debitoAjus = new Money(0);
  	Money debitoExt1 = new Money(0);
  	Money debitoExt2 = new Money(0);
  	
  	Money credito     = new Money(0);
  	Money creditoHist = new Money(0);
  	Money creditoAjus = new Money(0);
  	Money creditoExt1 = new Money(0);
  	Money creditoExt2 = new Money(0);
  
  	if (this.getSigno().intValue() == MovimientoCtaBancaria.ENTRADA) {
    	debito = getImporte();
    	debitoHist = getImporteHist();
    	debitoAjus = getImporteAju() ;
    	debitoExt1 = getImporteExt1();
    	debitoExt2 = getImporteExt2();
  	} else {
    	credito = getImporte();
    	creditoHist = getImporteHist();
    	creditoAjus = getImporteAju();
    	creditoExt1 = getImporteExt1();
    	creditoExt2 = getImporteExt2();
  	}
  		
    saldoCtaBancoDia.setDebitos(debito);
    saldoCtaBancoDia.setDebitoshist(debitoHist);
    saldoCtaBancoDia.setDebitosaju(debitoAjus);
    saldoCtaBancoDia.setDebitosext1(debitoExt1);
    saldoCtaBancoDia.setDebitosext2(debitoExt2);
    saldoCtaBancoDia.setCreditos(credito);
    saldoCtaBancoDia.setCreditoshist(creditoHist);
    saldoCtaBancoDia.setCreditosaju(creditoAjus);
    saldoCtaBancoDia.setCreditosext1(creditoExt1);
    saldoCtaBancoDia.setCreditosext2(creditoExt2);  	
    saldoCtaBancoDia.save();
  }
  
  private void actuSaldoPeriodo(SaldoCtaBancoPeriodo saldoCtaBancoPeriodo) throws BaseException {
  	
  	Money debito 	   = new Money(0);
  	Money debitoHist = new Money(0);
  	Money debitoAjus = new Money(0);
  	Money debitoExt1 = new Money(0);
  	Money debitoExt2 = new Money(0);
  	
  	Money credito     = new Money(0);
  	Money creditoHist = new Money(0);
  	Money creditoAjus = new Money(0);
  	Money creditoExt1 = new Money(0);
  	Money creditoExt2 = new Money(0);
  
  	if (this.getSigno().intValue() == MovimientoCtaBancaria.ENTRADA) {
    	debito = getImporte();
    	debitoHist = getImporteHist();
    	debitoAjus = getImporteAju() ;
    	debitoExt1 = getImporteExt1();
    	debitoExt2 = getImporteExt2();
  	} else {
    	credito = getImporte();
    	creditoHist = getImporteHist();
    	creditoAjus = getImporteAju();
    	creditoExt1 = getImporteExt1();
    	creditoExt2 = getImporteExt2();
  	}

  	saldoCtaBancoPeriodo.setDebitos(debito);
  	saldoCtaBancoPeriodo.setDebitoshist(debitoHist);
  	saldoCtaBancoPeriodo.setDebitosaju(debitoAjus);
  	saldoCtaBancoPeriodo.setDebitosext1(debitoExt1);
  	saldoCtaBancoPeriodo.setDebitosext2(debitoExt2);
  	saldoCtaBancoPeriodo.setCreditos(credito);
  	saldoCtaBancoPeriodo.setCreditoshist(creditoHist);
  	saldoCtaBancoPeriodo.setCreditosaju(creditoAjus);
  	saldoCtaBancoPeriodo.setCreditosext1(creditoExt1);
  	saldoCtaBancoPeriodo.setCreditosext2(creditoExt2);  	
  	saldoCtaBancoPeriodo.save();
  	
  }


  private void grabarSaldoDia() throws BaseException {

    SaldoCtaBancoDia saldoCtaBancoDia =
        SaldoCtaBancoDia.getSaldoByFechayCuenta(getCtaBancaria(),
                                                getFechaContable(),
                                                getSesion());
    if (saldoCtaBancoDia == null)
      saldoCtaBancoDia = grabarNewSaldoDia();
    else
      actuSaldoDia(saldoCtaBancoDia);
  }

  private void grabarSaldoPeriodo() throws BaseException {

    Periodo periodo = Periodo.getPeriodoByFechaDelEjercicio(getFechaContable(),getSesion());
    if (periodo == null)
      throw new ExceptionValidation(null,"Falta definir un ejercicio contable para la fecha ingresada");

    SaldoCtaBancoPeriodo saldoCtaBancoPeriodo =
        SaldoCtaBancoPeriodo.getSaldoByPeriodoyCuenta(getCtaBancaria(),
                                                      periodo,
                                                      getSesion());
    if (saldoCtaBancoPeriodo == null)
      saldoCtaBancoPeriodo = grabarNewSaldoPeriodo();
    else
      actuSaldoPeriodo(saldoCtaBancoPeriodo);
  }

  private SaldoCtaBancoPeriodo grabarNewSaldoPeriodo() throws BaseException {

    Periodo periodo = Periodo.getPeriodoByFechaDelEjercicio(getFechaContable(),getSesion());
    if (periodo == null)
      throw new ExceptionValidation(null,"Falta definir un ejercicio contable para la fecha ingresada");

    SaldoCtaBancoPeriodo saldoCtaBancoPeriodo =
        (SaldoCtaBancoPeriodo)SaldoCtaBancoPeriodo.getNew(SaldoCtaBancoPeriodo.NICKNAME,
                                                  getSesion());
    saldoCtaBancoPeriodo.setCuentabancaria(getCtaBancaria());
    saldoCtaBancoPeriodo.setPeriodo(periodo);
    
  	Money debito 	   = new Money(0);
  	Money debitoHist = new Money(0);
  	Money debitoAjus = new Money(0);
  	Money debitoExt1 = new Money(0);
  	Money debitoExt2 = new Money(0);
  	
  	Money credito     = new Money(0);
  	Money creditoHist = new Money(0);
  	Money creditoAjus = new Money(0);
  	Money creditoExt1 = new Money(0);
  	Money creditoExt2 = new Money(0);

  	if (this.getSigno().intValue() == MovimientoCtaBancaria.ENTRADA) {
    	debito = getImporte();
    	debitoHist = getImporteHist();
    	debitoAjus = getImporteAju() ;
    	debitoExt1 = getImporteExt1();
    	debitoExt2 = getImporteExt2();
  	} else {
    	credito = getImporte();
    	creditoHist = getImporteHist();
    	creditoAjus = getImporteAju();
    	creditoExt1 = getImporteExt1();
    	creditoExt2 = getImporteExt2();
  	}
  	
  	saldoCtaBancoPeriodo.setDebitos(debito);
  	saldoCtaBancoPeriodo.setDebitoshist(debitoHist);
  	saldoCtaBancoPeriodo.setDebitosaju(debitoAjus);
  	saldoCtaBancoPeriodo.setDebitosext1(debitoExt1);
  	saldoCtaBancoPeriodo.setDebitosext2(debitoExt2);
  	saldoCtaBancoPeriodo.setCreditos(credito);
  	saldoCtaBancoPeriodo.setCreditoshist(creditoHist);
  	saldoCtaBancoPeriodo.setCreditosaju(creditoAjus);
  	saldoCtaBancoPeriodo.setCreditosext1(creditoExt1);
  	saldoCtaBancoPeriodo.setCreditosext2(creditoExt2);  	
  	saldoCtaBancoPeriodo.save();
  	    
    saldoCtaBancoPeriodo.save();
    return saldoCtaBancoPeriodo;
  }

  public void save() throws BaseException {
    grabarMovimiento();
    grabarSaldoDia();
    grabarSaldoPeriodo();
  }

	public CuentaImputable getCuenta() {
		return cuenta;
	}

	public void setCuenta(CuentaImputable cuenta) {
		this.cuenta = cuenta;
	}

	public TipoValor getTipoValor() {
		return tipoValor;
	}

	public void setTipoValor(TipoValor tipoValor) {
		this.tipoValor = tipoValor;
	}

	public Valor getValor() {
		return valor;
	}

	public void setValor(Valor valor) {
		this.valor = valor;
	}


}
