package com.srn.erp.ctasAPagar.bm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.ctasAPagar.da.DBComproProveedorDet;
import com.srn.erp.impuestos.bm.ConceptoImpuesto;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bm.Varios.Money;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class ComproProveedorDet extends ObjetoLogico {

  public ComproProveedorDet() {
  }

  private List detallesConcProvImpu = new ArrayList();
  private boolean readDetallesConcProvImpu = true;

  public static String NICKNAME = "cap.ComproProveedorDet";

  private ComproProveedorBase comprobanteBase;
  private Integer secu;
  private ConcFactProv concFactProv;
  private Money impoMonedaOri;
  private Money impoMonedaLoc;

  private List detallesCtasImpu = new ArrayList();
  private boolean readImputaciones = true;

  public ComproProveedorBase getComprobanteBase() throws BaseException {
    supportRefresh();
    return comprobanteBase;
  }

  public void setComprobante(ComproProveedorBase aComprobanteBase) {
    this.comprobanteBase =  aComprobanteBase;
  }

  public Integer getSecu() throws BaseException {
    supportRefresh();
    return secu;
  }

  public void setSecu(Integer aSecu) {
    this.secu =  aSecu;
  }

  public ConcFactProv getConcFactProv() throws BaseException {
    supportRefresh();
    return concFactProv;
  }

  public void setConcFactProv(ConcFactProv aConcfactprov) {
    this.concFactProv =  aConcfactprov;
  }

  public Money getImpoMonedaOri() throws BaseException {
    supportRefresh();
    return impoMonedaOri;
  }

  public void setImpoMonedaOri(Money aImpomonedaori) throws BaseException {
    this.impoMonedaOri =  aImpomonedaori;
  }

  public Money getImpoMonedaLoc() throws BaseException {
    supportRefresh();
    return impoMonedaLoc;
  }

  public void setImpoMonedaLoc(Money aImpomonedaloc) {
    this.impoMonedaLoc =  aImpomonedaloc;
  }

  public String getNickName() {
    return NICKNAME;
  }

 public static ComproProveedorDet findByOid(Integer oid , ISesion aSesion) throws BaseException {
   return (ComproProveedorDet) getObjectByOid(NICKNAME,oid,aSesion);
  }

 public static ComproProveedorDet findByOidProxy(Integer oid , ISesion aSesion) throws BaseException {
    return (ComproProveedorDet) getObjectByOidProxy(NICKNAME,oid,aSesion);
 }


 public static ComproProveedorDet findByCodigo(String codigo , ISesion aSesion) throws BaseException {
   return (ComproProveedorDet) getObjectByCodigo(NICKNAME,codigo,aSesion);
  }

 public void beforeSave() throws BaseException {
	 Validar.noNulo(concFactProv, "Debe ingresar el concepto de Proveedor");	
	 Validar.noNulo(impoMonedaOri,"Debe ingresar el importe");
 }

  /**
   * isActivo
   *
   * @return Boolean
   */
  public Boolean isActivo() {
    return null;
  }

  /**
   * getCodigo
   *
   * @return String
   */
  public String getCodigo() {
    return "";
  }

  /**
   * getDescripcion
   *
   * @return String
   */
  public String getDescripcion() {
    return "";
  }

  // Agregar Detalle
  public ComproProveedorImpu addComproProvImpu() throws BaseException {
    ComproProveedorImpu comproProvImpu =
        (ComproProveedorImpu) ComproProveedorImpu.getNew(ComproProveedorImpu.NICKNAME,getSesion());
    comproProvImpu.setComproProveedorDet(this);
    detallesConcProvImpu.add(comproProvImpu);
    return comproProvImpu;
  }

  // Agregar el After Save
  public void afterSave() throws BaseException {
    Iterator iterDetallesImpu = detallesConcProvImpu.iterator();
    while (iterDetallesImpu.hasNext()) {
      ComproProveedorImpu comproProvImpu = (ComproProveedorImpu) iterDetallesImpu.next();
      comproProvImpu.save();
      comproProvImpu = null;
    }
    iterDetallesImpu = null;

    Iterator iterDetallesCtasImpu = detallesCtasImpu.iterator();
    while (iterDetallesCtasImpu.hasNext()) {
      ComproProvDetCtaImpu comproProvDetCtaImpu =
          (ComproProvDetCtaImpu) iterDetallesCtasImpu.next();
      comproProvDetCtaImpu.save();
      comproProvDetCtaImpu = null;
    }

  }

  // Agregar Detalle
  public ComproProvDetCtaImpu addCuentaImputable() throws BaseException {
    ComproProvDetCtaImpu comproProvDetCtaImpu =
        (ComproProvDetCtaImpu)ComproProveedorDet.getNew(
               ComproProvDetCtaImpu.NICKNAME,
               getSesion());
    comproProvDetCtaImpu.setComproprovdet(this);
    detallesCtasImpu.add(comproProvDetCtaImpu);
    return comproProvDetCtaImpu;
  }

  public List getDetalleImputacionesConc() throws BaseException {
    return detallesCtasImpu;
  }
  
  public List getDetalleImputaciones() throws BaseException {
    if (this.readImputaciones) {
    	detallesCtasImpu.addAll(ComproProvDetCtaImpu.getImputacionesContablesConcepto(this,getSesion()));
    	this.readImputaciones = false;
      return detallesCtasImpu;
  }
  else
    return detallesCtasImpu;
  }
  

  public ComproProveedorImpu getImpuestoIVA() throws BaseException {
  	Iterator iterConcImpu  = getConceptosComprobanteImpuestos().iterator();
  	while (iterConcImpu.hasNext()) {
  		ComproProveedorImpu comproProvImpu = (ComproProveedorImpu) iterConcImpu.next();
  		if (comproProvImpu.getConceptoImpuesto().getImpuesto().isIVACompras()) {
  			return comproProvImpu;
  		}
  	}
  	return null;
  }
  
  public ComproProveedorImpu getImpuestoPercIVA() throws BaseException {
  	Iterator iterConcImpu  = getConceptosComprobanteImpuestos().iterator();
  	while (iterConcImpu.hasNext()) {
  		ComproProveedorImpu comproProvImpu = (ComproProveedorImpu) iterConcImpu.next();
  		if (comproProvImpu.getConceptoImpuesto().getImpuesto().isPercIVACompras()) {
  			return comproProvImpu;
  		}
  	}
  	return null;
  }
  
  public ComproProveedorImpu getImpuestoPercIB() throws BaseException {
  	Iterator iterConcImpu  = getConceptosComprobanteImpuestos().iterator();
  	while (iterConcImpu.hasNext()) {
  		ComproProveedorImpu comproProvImpu = (ComproProveedorImpu) iterConcImpu.next();
  		if (comproProvImpu.getConceptoImpuesto().getImpuesto().isPercIBCompras()) {
  			return comproProvImpu;
  		}
  	}
  	return null;
  }
  
  public ComproProveedorImpu getImpuestoInterno() throws BaseException {
  	Iterator iterConcImpu  = getConceptosComprobanteImpuestos().iterator();
  	while (iterConcImpu.hasNext()) {
  		ComproProveedorImpu comproProvImpu = (ComproProveedorImpu) iterConcImpu.next();
  		if (comproProvImpu.getConceptoImpuesto().getImpuesto().isImpInternoCompras()) {
  			return comproProvImpu;
  		}
  	}
  	return null;
  }
  
  public ComproProveedorImpu getImpuestoRetGan() throws BaseException {
  	Iterator iterConcImpu  = getConceptosComprobanteImpuestos().iterator();
  	while (iterConcImpu.hasNext()) {
  		ComproProveedorImpu comproProvImpu = (ComproProveedorImpu) iterConcImpu.next();
  		if (comproProvImpu.getConceptoImpuesto().getImpuesto().isRetGanPagos()) {
  			return comproProvImpu;
  		}
  	}
  	return null;
  }
  
  public ComproProveedorImpu getImpuestoRetIB() throws BaseException {
  	Iterator iterConcImpu  = getConceptosComprobanteImpuestos().iterator();
  	while (iterConcImpu.hasNext()) {
  		ComproProveedorImpu comproProvImpu = (ComproProveedorImpu) iterConcImpu.next();
  		if (comproProvImpu.getConceptoImpuesto().getImpuesto().isRetIBPagos()) {
  			return comproProvImpu;
  		}
  	}
  	return null;
  }
  
  public ComproProveedorImpu getImpuestoRetIVA() throws BaseException {
  	Iterator iterConcImpu  = getConceptosComprobanteImpuestos().iterator();
  	while (iterConcImpu.hasNext()) {
  		ComproProveedorImpu comproProvImpu = (ComproProveedorImpu) iterConcImpu.next();
  		if (comproProvImpu.getConceptoImpuesto().getImpuesto().isRetIVAPagos()) {
  			return comproProvImpu;
  		}
  	}
  	return null;
  }  
  
  
  
  
  
  
  public List getConceptosComprobanteImpuestos() throws BaseException {
    if (readDetallesConcProvImpu) {
        detallesConcProvImpu.addAll(ComproProveedorImpu.getImpuestosComprobanteByConcepto(this,getSesion()));
        readDetallesConcProvImpu = false;
        return detallesConcProvImpu;
    }
    else
      return detallesConcProvImpu;
  }
  
  

  public boolean aplicaRetencion(ConceptoImpuesto buscarConceptoImpuesto) throws BaseException {
    List listaConcComproImpuestos = getConceptosComprobanteImpuestos();
    return listaConcComproImpuestos.contains(buscarConceptoImpuesto);
  }

  public List getImpuestosRetenciones() throws BaseException {
    List listaImpuestos = getConceptosComprobanteImpuestos();
    List listaImpuestosRetenciones = new ArrayList();
    Iterator iterComproProvImpu = listaImpuestos.iterator();
    while (iterComproProvImpu.hasNext()) {
      ComproProveedorImpu comproProveedorImpu =
          (ComproProveedorImpu) iterComproProvImpu.next();

      if (comproProveedorImpu.getConceptoImpuesto().isRetencion())
        if (!listaImpuestosRetenciones.contains(comproProveedorImpu))
           if (getImpoMonedaLoc().doubleValue()>0)
             listaImpuestosRetenciones.add(comproProveedorImpu);
    }
    return listaImpuestosRetenciones;
  }

  public List getImpuestosRetencionesGan() throws BaseException {
    List listaImpuestos = getConceptosComprobanteImpuestos();
    List listaImpuestosRetenciones = new ArrayList();
    Iterator iterComproProvImpu = listaImpuestos.iterator();
    while (iterComproProvImpu.hasNext()) {
      ComproProveedorImpu comproProveedorImpu =
          (ComproProveedorImpu) iterComproProvImpu.next();

      if (comproProveedorImpu.getConceptoImpuesto().isRetGanProv())
        if (!listaImpuestosRetenciones.contains(comproProveedorImpu.getConceptoImpuesto()))
           if (getImpoMonedaLoc().doubleValue()>0)
             listaImpuestosRetenciones.add(comproProveedorImpu.getConceptoImpuesto());
    }
    return listaImpuestosRetenciones;
  }

  public static List getDetallesByComproProv(ComproProveedorBase comproProveedorBase,
                                             ISesion aSesion) throws BaseException {
    return DBComproProveedorDet.getDetallesByComproProv(comproProveedorBase,aSesion);
  }
  
    







}
