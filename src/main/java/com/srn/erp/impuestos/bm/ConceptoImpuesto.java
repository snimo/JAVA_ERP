package com.srn.erp.impuestos.bm;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.contabilidad.bm.CuentaImputable;
import com.srn.erp.general.bm.Provincia;
import com.srn.erp.impuestos.da.DBConceptoImpuesto;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.Fecha;
import framework.applicarionServer.bm.Parametros.ValorParametro;
import framework.applicarionServer.bm.Varios.CalculadorMoney;
import framework.applicarionServer.bm.Varios.Money;
import framework.applicarionServer.bm.Varios.NumeroBase;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.Validar;

public class ConceptoImpuesto extends ObjetoLogico {

  public ConceptoImpuesto() {
  }

  public static String NICKNAME = "im.ConceptoImpuesto";

  
  public static final String COL_IMPRE_IVA_1 = "IVA_1";
  public static final String COL_IMPRE_IVA_2 = "IVA_2";
  
  private String codigo;
  private String descripcion;
  private Impuesto impuesto;
  private ColumnaLibroIVA columnaLibroIVA;
  private String regimen;
  private CuentaImputable cuentaImputable;
  private Boolean activo;
  private Provincia provincia;
  private Money baseImponible;
  private Money impuestoMinimo;
  private String colImpreCompro;
  private Integer codigoAfip;

  private List tasasIVA = new ArrayList();
  private boolean readTasasIVA = true;

  private List tasasPercIVA = new ArrayList();
  private boolean readTasasPercIVA = true;

  private List tasasPercIB = new ArrayList();
  private boolean readTasasPercIB = true;

  private List tasasImpInt = new ArrayList();
  private boolean readTasasImpInt = true;

  public boolean isRetGan() throws BaseException {
    return getImpuesto().isRetGan();
  }
  
  public boolean isRetGanProv() throws BaseException {
	return getImpuesto().isRetGanPagos();
  }
  

  public boolean isRetencion() throws BaseException {
    return getImpuesto().isRetencion();
  }

  public String getCodigo() throws BaseException {
    supportRefresh();
    return codigo;
  }
  
  public Integer getCodigoAfip() throws BaseException {
	    supportRefresh();
	    return this.codigoAfip;
  }

  public void setCodigoAfip(Integer aCodigoAfip) {
	    this.codigoAfip =  aCodigoAfip;
  }
  
  
  public void setCodigo(String aCodigo) {
    this.codigo =  aCodigo;
  }

  public CuentaImputable getCuentaImputable() throws BaseException {
    supportRefresh();
    return cuentaImputable;
  }

  public void setCuentaImputable(CuentaImputable aCuentaimputable) {
    this.cuentaImputable =  aCuentaimputable;
  }
  
  public String getColImpreCompro() throws BaseException {
	    supportRefresh();
	    return this.colImpreCompro;
  }

  public void setColImpreCompro(String aColImpreCompro) {
	 this.colImpreCompro =  aColImpreCompro;
  }
  
  
  public Money getBaseImponible() throws BaseException {
    supportRefresh();
    return this.baseImponible;
  }

  public void setBaseImponible(Money aBaseImponible) {
    this.baseImponible =  aBaseImponible;
  }
  
  public Money getImpuestoMinimo() throws BaseException {
    supportRefresh();
    return this.impuestoMinimo;
  }

  public void setImpuestoMinimo(Money aImpuestoMinimo) {
    this.impuestoMinimo =  aImpuestoMinimo;
  }
  
  public Provincia getProvincia() throws BaseException {
    supportRefresh();
    return provincia;
  }

  public void setProvincia(Provincia aProvincia) {
    this.provincia =  aProvincia;
  }
  

  public String getDescripcion() throws BaseException {
    supportRefresh();
    return descripcion;
  }

  public void setDescripcion(String aDescripcion) {
    this.descripcion =  aDescripcion;
  }

  public Impuesto getImpuesto() throws BaseException {
    supportRefresh();
    return impuesto;
  }

  public void setImpuesto(Impuesto aImpuesto) {
    this.impuesto =  aImpuesto;
  }

  public ColumnaLibroIVA getColumnalibroiva() throws BaseException {
    supportRefresh();
    return columnaLibroIVA;
  }

  public void setColumnalibroiva(ColumnaLibroIVA aColumnalibroiva) {
    this.columnaLibroIVA =  aColumnalibroiva;
  }

  public String getRegimen() throws BaseException {
    supportRefresh();
    return regimen;
  }

  public void setRegimen(String aRegimen) {
    this.regimen =  aRegimen;
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

 public static ConceptoImpuesto findByOid(Integer oid , ISesion aSesion) throws BaseException {
   return (ConceptoImpuesto) getObjectByOid(NICKNAME,oid,aSesion);
  }

 public static ConceptoImpuesto findByOidProxy(Integer oid , ISesion aSesion) throws BaseException {
    return (ConceptoImpuesto) getObjectByOidProxy(NICKNAME,oid,aSesion);
 }


 public static ConceptoImpuesto findByCodigo(String codigo , ISesion aSesion) throws BaseException {
   return (ConceptoImpuesto) getObjectByCodigo(NICKNAME,codigo,aSesion);
  }

 public void beforeSave() throws BaseException {
    Validar.noNulo(codigo, "Debe ingresar el Código");
    Validar.noNulo(descripcion, "Debe ingresar la Descripción");
    Validar.noNulo(impuesto, "Debe ingresar el Impuesto");

   if (isNew() && (isActivo().booleanValue() == false))
     Validar.mensajeValidacion("El Concepto de Impuesto debe ingresarse en modo Activo");

 }

 public List getTasasIVA() throws BaseException {
   if (readTasasIVA) {
     tasasIVA.addAll(TasaIVA.getTasasIVAByConceptoImpu(this,getSesion()));
     readTasasIVA = false;
   }
   return tasasIVA;
 }

 public List getTasasPercIVA() throws BaseException {
   if (readTasasPercIVA) {
     tasasPercIVA.addAll(TasaPercIVA.getTasasPercIVAByConceptoImpu(this,getSesion()));
     readTasasPercIVA = false;
   }
   return tasasPercIVA;
 }

 public List getTasasPercIB() throws BaseException {
   if (readTasasPercIB) {
     tasasPercIB.addAll(TasaPercIB.getTasasPercIBByConcImpu(this,getSesion()));
     readTasasPercIB = false;
   }
   return tasasPercIB;
 }

 public List getTasasImpInt() throws BaseException {
   if (readTasasImpInt) {
     tasasImpInt.addAll(TasaImpInt.getTasasImpIntByConcImpu(this,getSesion()));
     readTasasImpInt = false;
   }
   return tasasImpInt;
 }


 public void addTasaIVA(TasaIVA tasaIVA) throws BaseException {
   tasaIVA.setConcimpuesto(this);
   tasasIVA.add(tasaIVA);
 }

 public void addTasaImpInt(TasaImpInt tasaImpInt) throws BaseException {
   tasaImpInt.setConceptoimpuesto(this);
   tasasImpInt.add(tasaImpInt);
 }


 public void addTasaPercIB(TasaPercIB tasaPercIB) throws BaseException {
   tasaPercIB.setConceptoImpuesto(this);
   tasasPercIB.add(tasaPercIB);
 }


 public void addTasaPercIVA(TasaPercIVA tasaPercIVA) throws BaseException {
   tasaPercIVA.setConcimpuesto(this);
   tasasPercIVA.add(tasaPercIVA);
 }


 public void afterSave() throws BaseException {
   Iterator iterTasasIVA = tasasIVA.iterator();
   while (iterTasasIVA.hasNext()) {
     TasaIVA tasaIVA = (TasaIVA) iterTasasIVA.next();
     tasaIVA.save();
     tasaIVA = null;
   }
   iterTasasIVA = null;

   Iterator iterTasasPercIVA = tasasPercIVA.iterator();
   while (iterTasasPercIVA.hasNext()) {
     TasaPercIVA tasaPercIVA = (TasaPercIVA) iterTasasPercIVA.next();
     tasaPercIVA.save();
     tasaPercIVA = null;
   }
   iterTasasPercIVA = null;

   Iterator iterTasasPercIB = tasasPercIB.iterator();
   while (iterTasasPercIB.hasNext()) {
     TasaPercIB tasaPercIB = (TasaPercIB) iterTasasPercIB.next();
     tasaPercIB.save();
     tasaPercIB = null;
   }
   iterTasasPercIB = null;

   Iterator iterTasasImpInt = tasasImpInt.iterator();
   while (iterTasasImpInt.hasNext()) {
     TasaImpInt tasaImpInt = (TasaImpInt) iterTasasImpInt.next();
     tasaImpInt.save();
     tasaImpInt = null;
   }
   iterTasasImpInt = null;
 }

 public static List getConcImpuByTipo(String comportamientoImpuesto,
                                      ISesion aSesion) throws BaseException {
   if (comportamientoImpuesto.equals(Impuesto.CODIGO_IVA))
      return DBConceptoImpuesto.getConcImpuIVA(aSesion);
   else
   if (comportamientoImpuesto.equals(Impuesto.CODIGO_IVA_C))
       return DBConceptoImpuesto.getConcImpuIVACompras(aSesion);
   else
   if (comportamientoImpuesto.equals(Impuesto.CODIGO_PERC_IVA))
      return DBConceptoImpuesto.getConcImpuPercIVA(aSesion);
   else
     if (comportamientoImpuesto.equals(Impuesto.CODIGO_PERC_IVA_C))
       return DBConceptoImpuesto.getConcImpuPercIVACompras(aSesion);
    else
   if (comportamientoImpuesto.equals(Impuesto.CODIGO_PERC_IB_BA))
      return DBConceptoImpuesto.getConcImpuPercIB(aSesion);
   else
     if (comportamientoImpuesto.equals(Impuesto.CODIGO_PERC_IB_CF))
        return DBConceptoImpuesto.getConcImpuPercIB(aSesion);
   else
   if ((comportamientoImpuesto.equals(Impuesto.CODIGO_PERC_IB_C)))
        return DBConceptoImpuesto.getConcImpuPercIBCompras(aSesion);
     else
   if (comportamientoImpuesto.equals(Impuesto.CODIGO_RET_IVA))
      return DBConceptoImpuesto.getConcImpuRetIVA(aSesion);
   else
   if (comportamientoImpuesto.equals(Impuesto.CODIGO_RET_GAN))
      return DBConceptoImpuesto.getConcImpuRetGan(aSesion);
    else
   if (comportamientoImpuesto.equals(Impuesto.CODIGO_RET_IB))
      return DBConceptoImpuesto.getConcImpuRetIB(aSesion);
    else
   if (comportamientoImpuesto.equals(Impuesto.CODIGO_IMP_INT))
      return DBConceptoImpuesto.getConcImpuInt(aSesion);
   else
     if (comportamientoImpuesto.equals(Impuesto.CODIGO_IMP_INT_C))
        return DBConceptoImpuesto.getConcImpuIntCompras(aSesion);
   else
   if (comportamientoImpuesto.equals(Impuesto.CODIGO_RET_IVA_P))
     return DBConceptoImpuesto.getConcImpuRetIVAPagos(aSesion);
   else
   if (comportamientoImpuesto.equals(Impuesto.CODIGO_RET_GAN_P))
     return DBConceptoImpuesto.getConcImpuRetGanPagos(aSesion);
   else
   if (comportamientoImpuesto.equals(Impuesto.CODIGO_RET_IB_P))
     return DBConceptoImpuesto.getConcImpuRetIBPagos(aSesion);  
   else
     return new ArrayList();
 }


 public Money getImpuestoIVA(Date fecha,Money netoGravado) throws BaseException {
   CalculadorMoney calc = new CalculadorMoney(netoGravado);
   TasaIVA tasaIVA = TasaIVA.getTasaVigenteIVA(this,fecha,getSesion());
   if (tasaIVA == null) return null;
   calc.multiplicarPor(new NumeroBase(tasaIVA.getPorcentaje().doubleValue()));
   calc.dividirPor(new NumeroBase(100));
   return calc.getResultMoney();
 }
 
 public Money getPrecioSinIVA(Date fecha,Money precioConIVA) throws BaseException {
   
	 CalculadorMoney calc = new CalculadorMoney(precioConIVA);
	 
   TasaIVA tasaIVA = TasaIVA.getTasaVigenteIVA(this,fecha,getSesion());
   if (tasaIVA == null) return null;
   
   CalculadorMoney calcDenominadorIVA = 
  	 new CalculadorMoney(new NumeroBase(tasaIVA.getPorcentaje()));
   calcDenominadorIVA.dividirPor(new NumeroBase(100));
   calcDenominadorIVA.sumar(new NumeroBase(1));
   
   calc.dividirPor(calcDenominadorIVA.getResultMoney());
   return calc.getResultMoney();
 }
 
 public Money getMontoIVADePrecioIVAIncluido(
		 Date fecha,
		 Money precioConIVA) throws BaseException {
	 CalculadorMoney montoIVA = new CalculadorMoney(precioConIVA);
	 montoIVA.restar(this.getPrecioSinIVA(fecha,precioConIVA));
	 return montoIVA.getResultMoney();
 }
 
 public Money getMontoImpIntDePrecioIVAIncluido(
		 Date fecha,
		 Money precioConIVA) throws BaseException {
	 CalculadorMoney montoIVA = new CalculadorMoney(precioConIVA);
	 montoIVA.restar(this.getPrecioSinIVA(fecha,precioConIVA));
	 return montoIVA.getResultMoney();
 }
 

 public Money getImpuestoPercIVA(Date fecha,Money netoGravado) throws BaseException {
   CalculadorMoney calc = new CalculadorMoney(netoGravado);
   TasaPercIVA tasaPercIVA = TasaPercIVA.getTasaVigentePercIVA(this,fecha,getSesion());
   if (tasaPercIVA == null)
     throw new ExceptionValidation(null,
                                   "No se pudo obtener la tasa de Perc. IVA para la fecha "+
                                   Fecha.getddmmyyyy(fecha));
   calc.multiplicarPor(new NumeroBase(tasaPercIVA.getPorcentaje().doubleValue()));
   calc.dividirPor(new NumeroBase(100));
   return calc.getResultMoney();
 }

 public Money getImpuestoInterno(Date fecha,Money netoGravado) throws BaseException {
   CalculadorMoney calc = new CalculadorMoney(netoGravado);
   TasaImpInt tasaImpInt = TasaImpInt.getTasaVigenteImpInt(this,fecha,getSesion());
   if (tasaImpInt == null)
     throw new ExceptionValidation(null,
                                   "No se pudo obtener la tasa de Impuestos Internos para la fecha "+
                                   Fecha.getddmmyyyy(fecha));
   if (netoGravado.doubleValue()>= tasaImpInt.getMontominimo().doubleValue()) {
     calc.multiplicarPor(new NumeroBase(tasaImpInt.getPorc().doubleValue()));
     calc.dividirPor(new NumeroBase(100));
     return calc.getResultMoney();
   }
   else
     return new Money(0);
 }


 public Money getImpuestoPercIB(Date fecha,
                                Provincia provincia,
                                CategoriaIB categoriaIB,
                                Money netoGravado) throws BaseException {
   CalculadorMoney calc = new CalculadorMoney(netoGravado);
   TasaPercIB tasaPercIB = TasaPercIB.getTasaVigentePercIB(this,
                                                           fecha,
                                                           provincia,
                                                           categoriaIB,
                                                           getSesion());
   if (tasaPercIB == null)
     return new Money(0);
   if (netoGravado.doubleValue()>=tasaPercIB.getMontoMinimo().doubleValue()) {
	 calc.restar(new Money(tasaPercIB.getMontoMinimo().doubleValue()));  
     calc.multiplicarPor(new NumeroBase(tasaPercIB.getPorc().doubleValue()));
     calc.dividirPor(new NumeroBase(100));
     return calc.getResultMoney();
   }
   else return new Money(0);
 }

 public Money getCalcImpuesto(java.util.Date fecha, Money importe) throws BaseException {
   if (this.getImpuesto().isIVA())
     return getImpuestoIVA(fecha,importe);
   else {
	   if (this.getImpuesto().isImpInterno())
		   return getImpuestoInterno(fecha,importe);
	   else {
		   if (this.getImpuesto().isPercIVA())
			   return getImpuestoPercIVA(fecha,importe);
		   else
			   return null;
	   }   
   }
 }

 public TasaIVA getTasaVigenteIVA(java.util.Date fecha,
		 						  ISesion aSesion) throws BaseException {
	 return TasaIVA.getTasaVigenteIVA(this,fecha,getSesion());
 }
 
 public static List getConcImpIVAVtas(ISesion aSesion) throws BaseException {
   return DBConceptoImpuesto.getConcImpuIVAVtas(aSesion);
 }
 
 public static List getConcImpPercIVAVtas(ISesion aSesion) throws BaseException {
	return DBConceptoImpuesto.getConcImpuPercIVAVtas(aSesion);
 }
 
 public static List getConcImpIntVtas(ISesion aSesion) throws BaseException {
	return DBConceptoImpuesto.getConcImpuIntVtas(aSesion);
 }
 
 public static List getConcImpPercIBVtas(ISesion aSesion) throws BaseException {
	return DBConceptoImpuesto.getConcImpuPercIBVtas(aSesion);
 }
 
 public static ConceptoImpuesto getSugerenciaConcImpIVA(ISesion aSesion) throws BaseException {
   Integer oidConcImpu =
       ValorParametro.findByCodigoParametro("CONC_IMP_IVA_DEF_ABM_PROD",aSesion).getOidObjNeg();
   ConceptoImpuesto conceptoImpuesto = ConceptoImpuesto.findByOid(oidConcImpu,aSesion);
   return conceptoImpuesto;
 } 
 
 
 public static ConceptoImpuesto getPercIBBsAs(ISesion aSesion) throws BaseException {
   Integer oidConcImpu =
       ValorParametro.findByCodigoParametro("CONC_IMPU_PERC_IB_BS_AS",aSesion).getOidObjNeg();
   ConceptoImpuesto conceptoImpuesto = ConceptoImpuesto.findByOid(oidConcImpu,aSesion);
   return conceptoImpuesto;
 }
 
 public static ConceptoImpuesto getPercIBCapFed(ISesion aSesion) throws BaseException {
   Integer oidConcImpu =
       ValorParametro.findByCodigoParametro("CONC_IMPU_PERC_IB_CF",aSesion).getOidObjNeg();
   ConceptoImpuesto conceptoImpuesto = ConceptoImpuesto.findByOid(oidConcImpu,aSesion);
   return conceptoImpuesto;
 }
 
 public static HashTableDatos getColumnasImpreCompro() throws BaseException {
	 HashTableDatos colImpreCompro = new HashTableDatos();
	 colImpreCompro.put(ConceptoImpuesto.COL_IMPRE_IVA_1,"IVA 1");
	 colImpreCompro.put(ConceptoImpuesto.COL_IMPRE_IVA_2,"IVA 2");
	 return colImpreCompro;  	 
 }
 
 public boolean isUbiColIVA1() throws BaseException {
	 if (this.getColImpreCompro()==null) return false;
	 if (this.getColImpreCompro().equals(COL_IMPRE_IVA_1))
		 return true;
	 else
		 return false;
 }
 
 public boolean isUbiColIVA2() throws BaseException {
	 if (this.getColImpreCompro()==null) return false;
	 if (this.getColImpreCompro().equals(COL_IMPRE_IVA_2))
		 return true;
	 else
		 return false;
 }
 
 
 
 

}
