package com.srn.erp.general.bm;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.general.da.DBCotizacion;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.Fecha;
import framework.applicarionServer.bm.Parametros.ValorParametro;
import framework.applicarionServer.bm.Varios.CalculadorCotizacion;
import framework.applicarionServer.bm.Varios.CalculadorMoney;
import framework.applicarionServer.bm.Varios.Money;
import framework.applicarionServer.bm.Varios.ValorCotizacion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.Validar;

public class Cotizacion extends ObjetoLogico {

  public Cotizacion() {
  }

  public static String NICKNAME = "ge.Cotizacion";

  private Date fechaVig;
  private TipoCambio tipoCambio;
  private ValorCotizacion cotizacion;
  private Moneda moneda;
  private Boolean activo;

  public Date getFechavig() throws BaseException {
    supportRefresh();
    return fechaVig;
  }

  public void setFechavig(Date aFechavig) {
    this.fechaVig =  aFechavig;
  }

  public TipoCambio getTipocambio() throws BaseException {
    supportRefresh();
    return tipoCambio;
  }

  public void setTipocambio(TipoCambio aTipocambio) {
    this.tipoCambio =  aTipocambio;
  }

  public ValorCotizacion getCotizacion() throws BaseException {
    supportRefresh();
    return cotizacion;
  }

  public void setCotizacion(ValorCotizacion aCotizacion) {
    this.cotizacion =  aCotizacion;
  }

  public Moneda getMoneda() throws BaseException {
    supportRefresh();
    return moneda;
  }

  public void setMoneda(Moneda aMoneda) {
    this.moneda =  aMoneda;
  }

  public Boolean isActivo() throws BaseException {
    supportRefresh();
    return activo;
  }

  public void setActivo(Boolean aActivo) {
    this.activo =  aActivo;
  }

  public String getNickName() {
    return NICKNAME;
  }

 public static Cotizacion findByOid(Integer oid , ISesion aSesion) throws BaseException {
   return (Cotizacion) getObjectByOid(NICKNAME,oid,aSesion);
  }

 public static Cotizacion findByCodigo(String codigo , ISesion aSesion) throws BaseException {
   return (Cotizacion) getObjectByCodigo(NICKNAME,codigo,aSesion);
  }

 public void beforeSave() throws BaseException {
    Validar.noNulo(fechaVig, "Debe ingresar la Fecha");
    Validar.noNulo(tipoCambio, "Debe ingresar el tipo de cambio");
    Validar.noNulo(cotizacion, "Debe ingresar la cotización");
    Validar.noNulo(moneda, "Debe ingresar la moneda");
    if (isNew() && (isActivo().booleanValue() == false))
      Validar.mensajeValidacion("La cotización debe ingresarse en modo activo");
 }

  /**
   * getDescripcion
   *
   * @return String
   */
  public String getDescripcion() {
    return "";
  }

  /**
   * getCodigo
   *
   * @return String
   */
  public String getCodigo() {
    return "";
  }

  public static Cotizacion getCotizacionByFechaTipoMoneda(Date fechaVig,
                                                          TipoCambio tipoCambio,
                                                          Moneda moneda,
                                                          ISesion aSesion)
                                                          throws BaseException {
    return DBCotizacion.getCotizacionByFechaTipoMoneda(fechaVig,tipoCambio,moneda,aSesion);
  }


  public static Money getImporteCotizado(Date fecha,
                                         TipoCambio tipoCambio,
                                         Moneda monedaOrigen,
                                         Money importeOrigen,
                                         Moneda monedaAConvertir,
                                         ISesion aSesion) throws BaseException {
    ValorCotizacion valorCotizacion = getCotizacion(fecha,
                           tipoCambio,
                           monedaOrigen,
                           monedaAConvertir,
                           aSesion);
    CalculadorMoney importeCotiz = new CalculadorMoney(importeOrigen);
    importeCotiz.multiplicarPor(valorCotizacion);
    Money money = new Money(importeCotiz.getResult());
    return money;
  }

  public static Money getImporteCotizado(Date fecha,
                                         TipoCambio tipoCambio,
                                         Moneda monedaOrigen,
                                         ValorCotizacion cotizMonOri,
                                         Money importeOrigen,
                                         Moneda monedaAConvertir,
                                         ISesion aSesion) throws BaseException {
    ValorCotizacion valorCotizacion =
        getCotizacion(fecha,
                      tipoCambio,
        monedaOrigen,
        cotizMonOri,
        monedaAConvertir,
        aSesion);

    CalculadorMoney calcImpoCoti = new CalculadorMoney(importeOrigen);
    calcImpoCoti.multiplicarPor(valorCotizacion);

    Money money = new Money(calcImpoCoti.getResult());
    return money;
  }

  public static Money getImpoMonedaCursoLegal(Date fecha,
                                               TipoCambio tipoCambio,
                                               Moneda monedaOrigen,
                                               Money importeOrigen,
                                               ValorCotizacion cotizacion,
                                               ISesion aSesion) throws BaseException {
    ValorCotizacion valorCotizacion =
      getCotizacion(fecha,
                    tipoCambio,
                    monedaOrigen,
                    cotizacion,
                    Moneda.getMonedaCursoLegal(aSesion),
                    aSesion);
     CalculadorMoney importeCotizado = new CalculadorMoney(importeOrigen);
     importeCotizado.multiplicarPor(valorCotizacion);

     Money money = new Money(importeCotizado.getResult());
     return money;

  }

  public static Money getImpoMonedaExt1(Date fecha,
                                        TipoCambio tipoCambio,
                                        Moneda monedaOrigen,
                                        Money importeOrigen,
                                        ValorCotizacion cotizacion,
                                        ISesion aSesion) throws BaseException {
     if (tipoCambio == null)
         tipoCambio = tipoCambio.getTipoCambioDefaultConta(aSesion);
     ValorCotizacion valorCotizacion =
       getCotizacion(fecha,
                     tipoCambio,
                     monedaOrigen,
                     cotizacion,
                     Moneda.getMonedaExt1(aSesion),
                     aSesion);
      CalculadorMoney importeCotizado = new CalculadorMoney(importeOrigen);
      importeCotizado.multiplicarPor(valorCotizacion);

      Money money = new Money(importeCotizado.getResult());
      return money;

  }

  public static Money getImpoMonedaExt1(Date fecha,
                                        TipoCambio tipoCambio,
                                        Moneda monedaOrigen,
                                        Money importeOrigen,
                                        ValorCotizacion cotizacion,
                                        ValorCotizacion valorCotizMonExt1,
                                        ISesion aSesion) throws BaseException {
     if (tipoCambio == null)
         tipoCambio = tipoCambio.getTipoCambioDefaultConta(aSesion);
     ValorCotizacion valorCotizacion =
       getCotizacion(fecha,
                     tipoCambio,
                     monedaOrigen,
                     cotizacion,
                     Moneda.getMonedaExt1(aSesion),
                     valorCotizMonExt1,
                     aSesion);
      CalculadorMoney importeCotizado = new CalculadorMoney(importeOrigen);
      importeCotizado.multiplicarPor(valorCotizacion);

      Money money = new Money(importeCotizado.getResult());
      return money;

  }


  public static Money getImpoMonedaExt2(Date fecha,
                                        TipoCambio tipoCambio,
                                        Moneda monedaOrigen,
                                        Money importeOrigen,
                                        ValorCotizacion cotizacion,
                                        ISesion aSesion) throws BaseException {

    if (tipoCambio == null)
         tipoCambio = tipoCambio.getTipoCambioDefaultConta(aSesion);

    ValorCotizacion valorCotizacion =
        getCotizacion(fecha,
                      tipoCambio,
                      monedaOrigen,
                      cotizacion,
                      Moneda.getMonedaExt2(aSesion),
                      aSesion);
    CalculadorMoney importeCotizado = new CalculadorMoney(importeOrigen);
    importeCotizado.multiplicarPor(valorCotizacion);

    Money money = new Money(importeCotizado.getResult());
    return money;
  }

  public static Money getImpoMonedaExt2(Date fecha,
                                        TipoCambio tipoCambio,
                                        Moneda monedaOrigen,
                                        Money importeOrigen,
                                        ValorCotizacion cotizacion,
                                        ValorCotizacion valorCotizMoneExt2,
                                        ISesion aSesion) throws BaseException {

    if (tipoCambio == null)
         tipoCambio = tipoCambio.getTipoCambioDefaultConta(aSesion);

    ValorCotizacion valorCotizacion =
        getCotizacion(fecha,
                      tipoCambio,
                      monedaOrigen,
                      cotizacion,
                      Moneda.getMonedaExt2(aSesion),
                      valorCotizMoneExt2,
                      aSesion);
    CalculadorMoney importeCotizado = new CalculadorMoney(importeOrigen);
    importeCotizado.multiplicarPor(valorCotizacion);

    Money money = new Money(importeCotizado.getResult());
    return money;
  }

  



  public static ValorCotizacion getCotizacion(Date fecha,
                                              TipoCambio tipoCambio,
                                              Moneda monedaOrigen,
                                              ValorCotizacion cotizMonedaOri,
                                              Moneda monedaAConvertir,
                                              ISesion aSesion) throws BaseException {

    if ((cotizMonedaOri == null) || (cotizMonedaOri.doubleValue()==0))
      throw new ExceptionValidation(null,"No existe cotización para la moneda "+
                                         monedaOrigen.getDescripcion());

    // Obtener la cotizacion convertida
    Cotizacion cotizacionMonConv = null;
    if (monedaAConvertir.isMonedaCursoLegal()==true)
      cotizacionMonConv = Cotizacion.getCotizMonCurLeg(aSesion);
    else
      cotizacionMonConv =
        DBCotizacion.getCotizacionByFechaTipoMoneda(fecha,
                                                    tipoCambio,
                                                    monedaAConvertir,
                                                    aSesion
                                                    );
    if ((cotizacionMonConv == null) || (cotizacionMonConv.getCotizacion().doubleValue()==0))
      throw new ExceptionValidation(null,"No existe cotización para la moneda "+
                                         monedaAConvertir.getDescripcion()+
                                         " y tipo de cambio "+tipoCambio.getDescripcion()+
                                         " correspondiente a la fecha "+
                                        Fecha.getddmmyyyy(fecha));
    CalculadorCotizacion calcCotizConv =
        new CalculadorCotizacion(cotizacionMonConv.getCotizacion());
    calcCotizConv.dividirPor(cotizacionMonConv.getMoneda().getBase());

    CalculadorCotizacion calcCotizacion =
        new CalculadorCotizacion(cotizMonedaOri);
    calcCotizacion.dividirPor(calcCotizConv.getResultNroBase());
    ValorCotizacion cotizacion = new ValorCotizacion(calcCotizacion.getResult());
    return cotizacion;
  }

  public static ValorCotizacion getCotizacion(Date fecha,
                                              TipoCambio tipoCambio,
                                              Moneda monedaOrigen,
                                              ValorCotizacion cotizMonedaOri,
                                              Moneda monedaAConvertir,
                                              ValorCotizacion cotizMonedaConv,
                                              ISesion aSesion) throws BaseException {

    if ((cotizMonedaOri == null) || (cotizMonedaOri.doubleValue()==0))
      throw new ExceptionValidation(null,"No existe cotización para la moneda "+
                                         monedaOrigen.getDescripcion());

    if ((cotizMonedaConv == null) || (cotizMonedaConv.doubleValue()==0))
        throw new ExceptionValidation(null,"No existe cotización para la moneda "+
        		monedaAConvertir.getDescripcion());
    
    
    CalculadorCotizacion calcCotizConv =
        new CalculadorCotizacion(cotizMonedaConv);

    CalculadorCotizacion calcCotizacion =
        new CalculadorCotizacion(cotizMonedaOri);
    calcCotizacion.dividirPor(calcCotizConv.getResultNroBase());
    ValorCotizacion cotizacion = new ValorCotizacion(calcCotizacion.getResult());
    return cotizacion;
  }


  public static ValorCotizacion getCotizacion(Date fecha,
                                              TipoCambio tipoCambio,
                                              Moneda monedaOrigen,
                                              Moneda monedaAConvertir,
                                              ISesion aSesion)
      throws BaseException {

    // Obtener la cotizacion origen
    Cotizacion cotizacionMonOri =
        DBCotizacion.getCotizacionByFechaTipoMoneda(fecha,
                                                    tipoCambio,
                                                    monedaOrigen,
                                                    aSesion
                                                    );


    if ((cotizacionMonOri == null) || (cotizacionMonOri.getCotizacion().doubleValue()==0))
      throw new ExceptionValidation(null,"No existe cotización para la moneda "+
                                         monedaOrigen.getDescripcion()+
                                         " y tipo de cambio "+tipoCambio.getDescripcion()+
                                         " correspondiente a la fecha "+
                                        Fecha.getddmmyyyy(fecha));

    // Obtener la cotizacion convertida
    Cotizacion cotizacionMonConv =
        DBCotizacion.getCotizacionByFechaTipoMoneda(fecha,
                                                    tipoCambio,
                                                    monedaAConvertir,
                                                    aSesion
                                                    );
    if ((cotizacionMonConv == null) || (cotizacionMonConv.getCotizacion().doubleValue()==0))
      throw new ExceptionValidation(null,"No existe cotización para la moneda "+
                                         monedaAConvertir.getDescripcion()+
                                         " y tipo de cambio "+tipoCambio.getDescripcion()+
                                         " correspondiente a la fecha "+
                                        Fecha.getddmmyyyy(fecha));

    CalculadorCotizacion calcCotizOri =
        new  CalculadorCotizacion(cotizacionMonOri.getCotizacion());
    calcCotizOri.dividirPor(cotizacionMonOri.getMoneda().getBase());
    CalculadorCotizacion calcCotizConv =
        new  CalculadorCotizacion(cotizacionMonConv.getCotizacion());
    calcCotizConv.dividirPor(cotizacionMonConv.getMoneda().getBase());
    ValorCotizacion cotizacion = new ValorCotizacion(calcCotizConv.getResult());
    return cotizacion;
  }
  
  public static Money getImporteEnMoneda(HashTableDatos cotizaciones,Money importe,Moneda monedaOrigen,Moneda monedaDestino) throws BaseException {
	
	  if (monedaOrigen == null)
		  throw new ExceptionValidation("Debe ingresar la Moneda Origen");
	  if (monedaDestino == null)
		  throw new ExceptionValidation("Debe ingresar la Moneda Destino");
	  
	  if (monedaOrigen.getOID() == monedaDestino.getOID())
		  return importe;
	  
	  ValorCotizacion valorCotizMonOri = (ValorCotizacion)cotizaciones.get(monedaOrigen.getOIDInteger());
	  if (valorCotizMonOri == null) throw new ExceptionValidation(null,"No se pudo encontrar cotización para la moneda "+monedaOrigen.getDescripcion());
	  
	  ValorCotizacion valorCotizMonDest = (ValorCotizacion)cotizaciones.get(monedaDestino.getOIDInteger());
	  if (valorCotizMonDest == null) throw new ExceptionValidation(null,"No se pudo encontrar cotización para la moneda "+monedaDestino.getDescripcion());
	  
	  return convertir(importe, valorCotizMonOri, valorCotizMonDest);
	  
  }

  public static ValorCotizacion getCotizacion(Date fecha,
                                              Moneda moneda,
                                              ISesion aSesion) throws BaseException {
    ValorParametro valorTipoCambioConta =
        ValorParametro.findByCodigoParametro("TIPO_CAMBIO_CONTABILIDAD",aSesion);
    TipoCambio tipoCambio =
        TipoCambio.findByOid(valorTipoCambioConta.getOidObjNeg(),
                             aSesion);
    return getCotizacion(fecha,
                         tipoCambio,
                         moneda,
                         aSesion);

  }

  public static ValorCotizacion getCotizacion(Date fecha,
                                              TipoCambio tipoCambio,
                                              Moneda moneda,
                                              ISesion aSesion)
      throws BaseException {

    // Obtener la cotizacion origen
    ValorParametro vpMonCurLeg =
        ValorParametro.findByCodigoParametro("MONEDA_CURSO_LEGAL",aSesion);
    if (vpMonCurLeg.getOidObjNeg().intValue() == moneda.getOID())
      return new ValorCotizacion(1.0);

    Cotizacion cotizacionMonOri =
        DBCotizacion.getCotizacionByFechaTipoMoneda(fecha,
                                                    tipoCambio,
                                                    moneda,
                                                    aSesion
                                                    );


    if ((cotizacionMonOri == null) || (cotizacionMonOri.getCotizacion().doubleValue()==0))
      throw new ExceptionValidation(null,"No existe cotización para la moneda "+
                                         moneda.getDescripcion()+
                                         " y tipo de cambio "+tipoCambio.getDescripcion()+
                                         " correspondiente a la fecha "+
                                        Fecha.getddmmyyyy(fecha));

    return cotizacionMonOri.getCotizacion();
  }
  
  public static ValorCotizacion getCotizacionNotFoundCero(Date fecha,
          TipoCambio tipoCambio,
          Moneda moneda,
          ISesion aSesion)
  throws BaseException {

	  // Obtener la cotizacion origen
	  Moneda monedaCursoLegal = Moneda.getMonedaCursoLegal(aSesion);
	  if (monedaCursoLegal.getOID() == moneda.getOID())
		  return new ValorCotizacion(1.0);

	  Cotizacion cotizacionMonOri =
		  DBCotizacion.getCotizacionByFechaTipoMoneda(fecha,
                tipoCambio,
                moneda,
                aSesion
                );

	  if (cotizacionMonOri == null)
		  return new ValorCotizacion(0);
	  
	  if (cotizacionMonOri.getCotizacion()== null)
		  return new ValorCotizacion(0);
		  
	  return cotizacionMonOri.getCotizacion();
}  

  public static Money getImporteMonedaLocal(ValorCotizacion valorCotizacion,
                                            Money importe) throws BaseException {
    CalculadorMoney calcMoney = new CalculadorMoney(importe);
    calcMoney.multiplicarPor(valorCotizacion);
    return calcMoney.getResultMoney();
  }

  public static Money convertir(Money montoOrigen,
                                ValorCotizacion valorCotizOri,
                                ValorCotizacion valorCotizDest) throws BaseException {
  	
  	if (valorCotizOri == null)
  		throw new ExceptionValidation(null,"Debe ingresar el Valor de la cotización Origen");
  	
  	if (valorCotizOri.doubleValue() == 0)
  		throw new ExceptionValidation(null,"El valor de la cotización origen no puede ser cero");
  	
  	if (valorCotizDest==null)
  		throw new ExceptionValidation(null,"Debe ingresar el valor de la cotización destino");
  	
  	if (valorCotizDest.doubleValue() == 0)
  		throw new ExceptionValidation(null,"El valor de la cotización destino no puede ser cero");
  	
    CalculadorMoney calcMoney = new CalculadorMoney(montoOrigen);
    calcMoney.multiplicarPor(valorCotizOri);
    if (valorCotizDest!=null)
        calcMoney.dividirPor(valorCotizDest);
    else
        throw new ExceptionValidation(null,"Debe ingresar el Valor de Cotización Destino");
    return calcMoney.getResultMoney();
  }

  public static Cotizacion getCotizMonCurLeg(ISesion aSesion) throws BaseException {
    Cotizacion cotizacion = (Cotizacion)Cotizacion.getNew(Cotizacion.NICKNAME,aSesion);
    cotizacion.setCotizacion(new ValorCotizacion(1.0));
    cotizacion.setFechavig(Fecha.getFechaActual());
    cotizacion.setTipocambio(TipoCambio.getTipoCambioDefaultConta(aSesion));
    cotizacion.setMoneda(Moneda.getMonedaCursoLegal(aSesion));
    cotizacion.setActivo(new Boolean(true));
    return cotizacion;
  }
  
  public static List getListaCotizacionesByFechayTipoCambio(
  			Date fechaVig,
  			TipoCambio tipoCambio,	
  			ISesion aSesion) throws BaseException {
  	return DBCotizacion.getCotizacionesByFechayTipoCambio(fechaVig,tipoCambio,aSesion);
  }
  
	public static HashTableDatos getListaCotizaciones(
			Date fecha , 
			TipoCambio tipoCambio, 
			ISesion aSesion) throws BaseException {
		HashTableDatos lista = new HashTableDatos();
		List cotizaciones = 
			Cotizacion.getListaCotizacionesByFechayTipoCambio(
					fecha,
					tipoCambio,
					aSesion);
		Iterator iterCotizaciones = cotizaciones.iterator();
		while (iterCotizaciones.hasNext()) {
			Cotizacion cotizacion = (Cotizacion) iterCotizaciones.next();
			lista.put(cotizacion.getMoneda(),cotizacion.getCotizacion());
		}
		return lista;
	}
	
	public static HashTableDatos getListaCotizacionesPorOidMoneda(
			Date fecha , 
			TipoCambio tipoCambio, 
			ISesion aSesion) throws BaseException {
		HashTableDatos lista = new HashTableDatos();
		List cotizaciones = 
			Cotizacion.getListaCotizacionesByFechayTipoCambio(
					fecha,
					tipoCambio,
					aSesion);
		Iterator iterCotizaciones = cotizaciones.iterator();
		while (iterCotizaciones.hasNext()) {
			Cotizacion cotizacion = (Cotizacion) iterCotizaciones.next();
			lista.put(cotizacion.getMoneda().getOIDInteger(),cotizacion.getCotizacion());
		}
		
		// Si no esta la Moneda Defaul agregarla
		Moneda moneda = Moneda.getMonedaCursoLegal(aSesion);
		if (lista.get(moneda.getOIDInteger())==null)
			lista.put(moneda.getOIDInteger(), new ValorCotizacion(1));
		
		return lista;
	}
	
  
  
  
  



}
