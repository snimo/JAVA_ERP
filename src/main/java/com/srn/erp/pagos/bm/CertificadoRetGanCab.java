package com.srn.erp.pagos.bm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.compras.bm.Proveedor;
import com.srn.erp.general.bm.ComproCab;
import com.srn.erp.general.bm.Talonario;
import com.srn.erp.general.bm.TipoComprobante;
import com.srn.erp.pagos.da.DBCertificadoRetGanCab;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bm.Parametros.ValorParametro;
import framework.applicarionServer.bm.Varios.Money;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ObjetoObservado;

public class CertificadoRetGanCab extends ComproCab {

  public CertificadoRetGanCab() {
  }

  public static String NICKNAME = "pag.CertificadoRetGanCab";

  private ComproCab ordenDePago;
  private Proveedor proveedor;
  private PeriRetGan periRetGan;
  private CatRetGan catRetGan;
  private Money porcLib;
  private String decreto;

  private List detallesCertificado = new ArrayList();
  private boolean readDetallesCertificado = true;


  public List getDetalles() throws BaseException {
    return detallesCertificado;
  }

  public List getDetallesCertificado() throws BaseException {
    if (readDetallesCertificado) {
      List listaDetallesCertificado = CertificadoRetGanDet.getDetallesCertificado(this,getSesion());
      detallesCertificado.addAll(listaDetallesCertificado);
      readDetallesCertificado = false;
    }
    return detallesCertificado;
  }

  public void addDetalle(CertificadoRetGanDet aCertRetGanDet) throws BaseException {
    aCertRetGanDet.setCertificado(this);
    detallesCertificado.add(aCertRetGanDet);
  }

  public void afterSave() throws BaseException {
    Iterator iterDetallesCertificado = detallesCertificado.iterator();
    while (iterDetallesCertificado.hasNext()) {
      CertificadoRetGanDet certRetGanDet = (CertificadoRetGanDet) iterDetallesCertificado.next();
      certRetGanDet.save();
      certRetGanDet = null;
    }
    iterDetallesCertificado = null;
  }

  public static TipoComprobante getTipoComproCertRet(ISesion aSesion) throws BaseException {
    ValorParametro valorParam =
          ValorParametro.findByCodigoParametro("TC_RET_GAN",aSesion);
    TipoComprobante tc = TipoComprobante.findByOidProxy(valorParam.getOidObjNeg(),aSesion);
    return tc;
  }


  public ComproCab getOrdendepago() throws BaseException {
    supportRefresh();
    return ordenDePago;
  }

  public void setOrdendepago(ComproCab aOrdendepago) {
    this.ordenDePago =  aOrdendepago;
  }

  public Proveedor getProveedor() throws BaseException {
    supportRefresh();
    return proveedor;
  }

  public void setProveedor(Proveedor aProveedor) {
    this.proveedor =  aProveedor;
  }

  public PeriRetGan getPeriretgan() throws BaseException {
    supportRefresh();
    return periRetGan;
  }

  public void setPeriretgan(PeriRetGan aPeriretgan) {
    this.periRetGan =  aPeriretgan;
  }

  public CatRetGan getCatretgan() throws BaseException {
    supportRefresh();
    return catRetGan;
  }

  public void setCatretgan(CatRetGan aCatretgan) {
    this.catRetGan =  aCatretgan;
  }

  public Money getPorclib() throws BaseException {
    supportRefresh();
    return porcLib;
  }

  public void setPorclib(Money aPorclib) {
    this.porcLib =  aPorclib;
  }

  public String getDecreto() throws BaseException {
    supportRefresh();
    return decreto;
  }

  public void setDecreto(String aDecreto) {
    this.decreto =  aDecreto;
  }

  public String getNickName() {
    return NICKNAME;
  }

 public static CertificadoRetGanCab findByOid(Integer oid , ISesion aSesion) throws BaseException {
   return (CertificadoRetGanCab) getObjectByOid(NICKNAME,oid,aSesion);
  }

 public static CertificadoRetGanCab findByOidProxy(Integer oid , ISesion aSesion) throws BaseException {
    return (CertificadoRetGanCab) getObjectByOidProxy(NICKNAME,oid,aSesion);
 }

 public void beforeSave() throws BaseException {

    beforeSaveComprobante(this);
    if (this.isNew()) {
      this.setEstado(ComproCab.ESTADO_ALTA);
    }

 }


  /**
   * isActivo
   *
   * @return Boolean
   */
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

  public static Talonario getTalonarioCertRetGan(ISesion aSesion) throws BaseException {
	   Integer oidTalonario =
	       ValorParametro.findByCodigoParametro("TALONARIO_CER_RET_GAN",aSesion).getOidObjNeg();
	   Talonario talonario = Talonario.findByOid(oidTalonario,aSesion);
	   return talonario;
	  
 }
  
 public void inicializar() throws BaseException {
	 Talonario talonario = CertificadoRetGanCab.getTalonarioCertRetGan(this.getSesion());
	 setTalonario(talonario);
     setTipoCompro(talonario.getTipo_comprobante());
     setLetra(talonario.getLetra());
     setLugarEmision(talonario.getLugar_emision());
     setComentario("");
     setActivo(new Boolean(true));
	 
 }
 
 public static CertificadoRetGanCab getCertificadoRetGan(ComproOrdenPagoCab op,
         ISesion aSesion)
         throws BaseException {
	  return DBCertificadoRetGanCab.getCertificadoRetGan(op,aSesion);
 }
 



}
