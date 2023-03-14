package com.srn.erp.stock.bm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.general.bm.Talonario;
import com.srn.erp.stock.da.DBConfMovStkTalonario;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class ConfMovStkTalonario extends ObjetoLogico {

  public ConfMovStkTalonario() {
  }

  public static String NICKNAME = "st.ConfMovStkTalonario";

  private Talonario talonario;
  private Boolean activo;

  private List tiposConfMov = new ArrayList();
  private boolean readTiposConfMov = true;

  public Talonario getTalonario() throws BaseException {
    supportRefresh();
    return talonario;
  }

  public void setTalonario(Talonario aTalonario) {
    this.talonario =  aTalonario;
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

 public static ConfMovStkTalonario findByOid(Integer oid , ISesion aSesion) throws BaseException {
   return (ConfMovStkTalonario) getObjectByOid(NICKNAME,oid,aSesion);
  }

 public static ConfMovStkTalonario findByOidProxy(Integer oid , ISesion aSesion) throws BaseException {
    return (ConfMovStkTalonario) getObjectByOidProxy(NICKNAME,oid,aSesion);
 }

 public static ConfMovStkTalonario findByCodigo(String codigo , ISesion aSesion) throws BaseException {
   return (ConfMovStkTalonario) getObjectByCodigo(NICKNAME,codigo,aSesion);
  }

 public void beforeSave() throws BaseException {
    Validar.noNulo(talonario, "Debe ingresar el Talonario");
 }

 public String getDescripcion() throws BaseException {
   return "";
 }

 public String getCodigo() throws BaseException {
   return "";
 }

 public List getTiposConfMov() throws BaseException {
   if (readTiposConfMov) {
     List listaTiposConfMov = TipoConfMovStkTalonario.getTiposMovimientos(this,getSesion());
     tiposConfMov.addAll(listaTiposConfMov);
     readTiposConfMov = false;
   }
   return tiposConfMov;
 }

 public void addTipoConfMovStk(TipoConfMovStkTalonario tipoConfMovStkTalonario) throws BaseException {
   tipoConfMovStkTalonario.setConf_mov_stk(this);
   tiposConfMov.add(tipoConfMovStkTalonario);
 }

 public void afterSave() throws BaseException {
   Iterator iterTiposConfMovStk = tiposConfMov.iterator();
   while (iterTiposConfMovStk.hasNext()) {
     TipoConfMovStkTalonario tipoConfMovStkTalonario = (TipoConfMovStkTalonario) iterTiposConfMovStk.next();
     tipoConfMovStkTalonario.save();
     tipoConfMovStkTalonario = null;
   }
   iterTiposConfMovStk = null;
 }

 public static ConfMovStkTalonario getConfMovStkByTalonario(Talonario talonario,
                                                          ISesion aSesion)
                                                          throws BaseException {
   return DBConfMovStkTalonario.getConfMovStkByTalonario(talonario,aSesion);
 }
 
 public TipoConfMovStkTalonario getTipoConfMovStkTalonarioControlCalidad() throws BaseException {
	 List listaMovControlCalidad = TipoConfMovStkTalonario.getTiposMovimientosByTipoCC(this,getSesion());
	 if (listaMovControlCalidad.isEmpty())
		 return null;
	 else
		return (TipoConfMovStkTalonario) listaMovControlCalidad.get(0);
 }
 
 public TipoConfMovStkTalonario getTipoConfMovStkTalonarioInfRec() throws BaseException {
	 List listaMovControlCalidad = TipoConfMovStkTalonario.getTiposMovimientosByTipoInfRec(this,getSesion());
	 if (listaMovControlCalidad.isEmpty())
		 return null;
	 else
		return (TipoConfMovStkTalonario) listaMovControlCalidad.get(0);
 } 
 
 public TipoConfMovStkTalonario getTipoConfMovStkCCOK() throws BaseException {
	 List listaMovControlCalidadOK = TipoConfMovStkTalonario.getTiposMovimientosByTipoCCOK(this,getSesion());
	 if (listaMovControlCalidadOK.isEmpty())
		 return null;
	 else
		return (TipoConfMovStkTalonario) listaMovControlCalidadOK.get(0);
 } 
 
 public TipoConfMovStkTalonario getTipoConfMovStkCCMal() throws BaseException {
	 List listaMovControlCalidadMal = TipoConfMovStkTalonario.getTiposMovimientosByTipoCCMal(this,getSesion());
	 if (listaMovControlCalidadMal.isEmpty())
		 return null;
	 else
		return (TipoConfMovStkTalonario) listaMovControlCalidadMal.get(0);
 } 


}
