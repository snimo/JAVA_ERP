package com.srn.erp.contabilidad.bm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bm.Varios.CalculadorMoney;
import framework.applicarionServer.bm.Varios.Money;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.Validar;

public class FaseSubReparto extends ObjetoLogico {
	
  private List componentesOrigines = new ArrayList();
  private boolean readComponentesOrigenes = true;
	
  private List valoresComponentesOrigines = new ArrayList();
  private boolean readValoresComponentesOrigenes = true;
  
  private List cuentasOrigenes = new ArrayList();
  private boolean readCuentasOrigenes = true;
  
  private List valoresComponentesDestino = new ArrayList();
  private boolean readValoresComponentesDestino = true;
  
  
  public FaseSubReparto() { 
  }

  public static String NICKNAME = "cg.FaseSubReparto";

  private String codigo;
  private String descripcion;
  private Componente compo_destino;
  private Boolean activo;

  public String getCodigo() throws BaseException { 
    supportRefresh();
    return codigo;
  }

  public void setCodigo(String aCodigo) { 
    this.codigo =  aCodigo;
  }

  public String getDescripcion() throws BaseException { 
    supportRefresh();
    return descripcion;
  }

  public void setDescripcion(String aDescripcion) { 
    this.descripcion =  aDescripcion;
  }

  public Componente getCompo_destino() throws BaseException { 
    supportRefresh();
    return compo_destino;
  }

  public void setCompo_destino(Componente aCompo_destino) { 
    this.compo_destino =  aCompo_destino;
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

 public static FaseSubReparto findByOid(Integer oid , ISesion aSesion) throws BaseException { 
   return (FaseSubReparto) getObjectByOid(NICKNAME,oid,aSesion);
  } 
 
 public static FaseSubReparto findByOidProxy(Integer oid , ISesion aSesion) throws BaseException { 
	   return (FaseSubReparto) getObjectByOidProxy(NICKNAME,oid,aSesion);
	  } 

 public static FaseSubReparto findByCodigo(String codigo , ISesion aSesion) throws BaseException { 
   return (FaseSubReparto) getObjectByCodigo(NICKNAME,codigo,aSesion);
  } 

 public void beforeSave() throws BaseException { 
    Validar.noNulo(codigo, "Debe ingresar el código");
    Validar.noNulo(descripcion, "Debe ingresar la descripción");
    Validar.noNulo(compo_destino, "Debe ingresar el Componente");
 }
 
 public List getComponentesOrigenes() throws BaseException {
	if (this.readComponentesOrigenes) {
		List listaCompoOri = FaseCompoOriginal.getComponentesOrigen(this,getSesion());
	    componentesOrigines.addAll(listaCompoOri);
	    readComponentesOrigenes = false;
	}
	return componentesOrigines;
 }
 
 public List getCuentasOrigenes() throws BaseException {
		if (this.readCuentasOrigenes) {
			List listaCuentasOri = FaseCuentaOrigen.getCuentasOrigen(this,getSesion());
		    cuentasOrigenes.addAll(listaCuentasOri);
		    readCuentasOrigenes= false;
		}
		return cuentasOrigenes;
 } 
 
 public void addComponenteOrigen(FaseCompoOriginal aFaseCompoOriginal) throws BaseException {
	 aFaseCompoOriginal.setFase(this);
	 componentesOrigines.add(aFaseCompoOriginal);
 }
 
 public void addCuentaOrigen(FaseCuentaOrigen aFaseCuentaOrigen) throws BaseException {
	 aFaseCuentaOrigen.setFase(this);
	 cuentasOrigenes.add(aFaseCuentaOrigen);
 } 
 
 public void addValorComponenteOrigen(FaseValorCompoOriginal aFaseValorCompoOriginal) throws BaseException {
	 aFaseValorCompoOriginal.setFase(this);
	 valoresComponentesOrigines.add(aFaseValorCompoOriginal);
 }
 
 public void addValorComponenteDestino(FaseValCompoDest aFaseValCompoDest) throws BaseException {
	 aFaseValCompoDest.setFase(this);
	 valoresComponentesDestino.add(aFaseValCompoDest);
 } 
 
 public void afterSave() throws BaseException {
	 
	Iterator iterFaseCompoOri = componentesOrigines.iterator();
	while (iterFaseCompoOri.hasNext()) {
	      FaseCompoOriginal faseCompoOri = (FaseCompoOriginal) iterFaseCompoOri.next();
	      faseCompoOri.save();
	      faseCompoOri = null;
	}
	iterFaseCompoOri = null;
	
	Iterator iterFaseValCompoOri = valoresComponentesOrigines.iterator();
	while (iterFaseValCompoOri.hasNext()) {
	      FaseValorCompoOriginal faseValorCompoOri = (FaseValorCompoOriginal) iterFaseValCompoOri.next();
	      faseValorCompoOri.save();
	      faseValorCompoOri = null;
	}
	iterFaseValCompoOri = null;
	
	Iterator iterCuentasOrigen = cuentasOrigenes.iterator();
	while (iterCuentasOrigen.hasNext()) {
	      FaseCuentaOrigen faseCuentaOrigen = (FaseCuentaOrigen) iterCuentasOrigen.next();
	      faseCuentaOrigen.save();
	      faseCuentaOrigen = null;
	}
	iterCuentasOrigen = null;
	
	Iterator iterFaseValCompoDest = valoresComponentesDestino.iterator();
	while (iterFaseValCompoDest.hasNext()) {
	      FaseValCompoDest faseValorCompoDest = (FaseValCompoDest) iterFaseValCompoDest.next();
	      faseValorCompoDest.save();
	      faseValorCompoDest = null;
	}
	iterFaseValCompoDest = null;
	
 }
 
 public List getValoresComponentesDestino() throws BaseException {
	 return FaseValCompoDest.getValoresCompoDestino(this, this.getSesion());
 }
 
 public List getListaCuentasOrigenes() throws BaseException {
	 List cuentas = new ArrayList();
	 Iterator iterCtasOri = 
		 this.getCuentasOrigenes().iterator();
	 while (iterCtasOri.hasNext()) {
		 FaseCuentaOrigen faseCuentaOrigen = (FaseCuentaOrigen) iterCtasOri.next();
		 cuentas.add(faseCuentaOrigen.getCuenta());
	 }
	 return cuentas;
 }
 
 public List getValoresCompo(Componente componente) throws BaseException {
	  return FaseValorCompoOriginal.getValoresCompo(this,componente,this.getSesion());
}
 
 
 public HashTableDatos getListaValoresDeComponentes() throws BaseException {
	HashTableDatos listaCompo = new HashTableDatos();
	Iterator iterCompoOri = 
		this.getComponentesOrigenes().iterator();
	while (iterCompoOri.hasNext()) {
		FaseCompoOriginal faseCompoOri = (FaseCompoOriginal) iterCompoOri.next();
		Componente compo = faseCompoOri.getComponente();
		List listaValoresCompo = new ArrayList();
		listaCompo.put(compo, listaValoresCompo);
		Iterator iterFaseValorCompoOriginal =  
			getValoresCompo(compo).iterator();
		while (iterFaseValorCompoOriginal.hasNext()) {
			FaseValorCompoOriginal faseValorCompoOri =
				(FaseValorCompoOriginal) iterFaseValorCompoOriginal.next();
			listaValoresCompo.add(faseValorCompoOri.getValor_componente());
		}
	}
	return listaCompo;
 }
 
 public HashTableDatos getProporcionesPorCompoDestino(
		 java.util.Date fechaDesde,
		 java.util.Date fechaHasta
		 ) throws BaseException {
	 
	HashTableDatos proporciones = new HashTableDatos();
	HashTableDatos cantidadesPorValorCompo = new HashTableDatos();
	
	// Obtener las cantidad de los valores de componentes destino
	CalculadorMoney totCantidades = new CalculadorMoney(new Money(0)); 
	Iterator iterValoresCompoDestino = 
		this.getValoresComponentesDestino().iterator();
	while (iterValoresCompoDestino.hasNext()) {
		FaseValCompoDest faseValCompoDest = (FaseValCompoDest) iterValoresCompoDestino.next();
		Double cantidad = faseValCompoDest.getDriver().getCantidad(fechaDesde, fechaHasta);
		cantidadesPorValorCompo.put(faseValCompoDest.getValor_compo(), cantidad);
		totCantidades.sumar(new Money(cantidad));
	}
	
	// Obtener las Proporciones para cada valor de componentes
	CalculadorMoney acumProporcion = new CalculadorMoney(new Money(0));
	Iterator iterCantPorValorCompo =
		cantidadesPorValorCompo.keySet().iterator();
	while (iterCantPorValorCompo.hasNext()) {
		IObjetoLogico objLog = (IObjetoLogico) iterCantPorValorCompo.next();
		Double cantidad = (Double) cantidadesPorValorCompo.get(objLog);
		
		CalculadorMoney calcProporcion = new CalculadorMoney(new Money(cantidad));
		calcProporcion.dividirPor(totCantidades.getResultMoney());
		Money resultadoProporcion = new Money(calcProporcion.getResult(2));
		acumProporcion.sumar(resultadoProporcion);
		
		proporciones.put(objLog, resultadoProporcion);
		
		if (iterCantPorValorCompo.hasNext()==false) {
			// Calcular la Proporcion del Ultimo Componente
			Money ultProporcion = new Money(0);
			CalculadorMoney calcUltPropor = new CalculadorMoney(new Money(1));
			calcUltPropor.restar(acumProporcion.getResultMoney());
			calcUltPropor.sumar(resultadoProporcion);
			ultProporcion = new Money(calcUltPropor.getResult(2)); 
			proporciones.remove(objLog);
			proporciones.put(objLog,ultProporcion);
		}
		
	}
	
	return proporciones;
 }

 

}
