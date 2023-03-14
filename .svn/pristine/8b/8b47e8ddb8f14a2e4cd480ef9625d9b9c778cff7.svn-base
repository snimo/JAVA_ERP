package com.srn.erp.contabilidad.bm;

import java.util.List;

import com.srn.erp.contabilidad.da.DBReporteContaCompo;
import com.srn.erp.contabilidad.da.DBReporteContableDet;

import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.ObjetoObservado;

public class ReporteContaCompo extends ObjetoLogico {

  public ReporteContaCompo() {
  }

  public static String NICKNAME = "cg.ReporteContaCompo";

  private ReporteContableDet reporteContaDet;
  private Componente componente;
  private IObjetoLogico valorComponente;

  public ReporteContableDet getReportecontadet() throws BaseException {
    supportRefresh();
    return reporteContaDet;
  }

  public void setReportecontadet(ReporteContableDet aReportecontadet) {
    this.reporteContaDet =  aReportecontadet;
  }

  public Componente getComponente() throws BaseException {
    supportRefresh();
    return componente;
  }

  public void setComponente(Componente aComponente) {
    this.componente =  aComponente;
  }

  public IObjetoLogico getValorcomponente() throws BaseException {
    supportRefresh();
    return valorComponente;
  }

  public void setValorcomponente(IObjetoLogico aValorcomponente) {
    this.valorComponente =  aValorcomponente;
  }

  public String getNickName() {
    return NICKNAME;
  }

 public static ReporteContaCompo findByOid(Integer oid , ISesion aSesion) throws BaseException {
   return (ReporteContaCompo) getObjectByOid(NICKNAME,oid,aSesion);
  }

 public static ReporteContaCompo findByCodigo(String codigo , ISesion aSesion) throws BaseException {
   return (ReporteContaCompo) getObjectByCodigo(NICKNAME,codigo,aSesion);
  }

 public void beforeSave() throws BaseException {
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

  public static List getReportesContaCompoByReporteDet(ReporteContableDet reporteContableDet,
                                                      ISesion aSesion) throws BaseException {

    return DBReporteContaCompo.getReportesContaCompoByReporteDet(reporteContableDet,aSesion);
  }
  
  public static ReporteContaCompo getReporteContaCompo(
		  ReporteContableDet reporteContableDet,
		  Componente compo,
          ISesion aSesion) throws BaseException {
	  return DBReporteContaCompo.getReporteContaCompo(reporteContableDet, compo, aSesion);

  }
  



}
