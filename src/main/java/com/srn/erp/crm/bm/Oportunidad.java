package com.srn.erp.crm.bm;

import com.srn.erp.general.bm.Moneda;
import com.srn.erp.ventas.bm.ListaPrecios;
import com.srn.erp.ventas.bm.Sujeto;
import com.srn.erp.ventas.bm.Vendedor;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.Fecha;
import framework.applicarionServer.bm.Seguridad.Usuario;
import framework.applicarionServer.bm.Varios.Money;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class Oportunidad extends ObjetoLogico { 

  public Oportunidad() { 
  }

  public static String NICKNAME = "crm.Oportunidad";

  private String tema;
  private Sujeto sujeto_potencial;
  private ListaPrecios ListaPrecios;
  private String tipo_resultado;
  private Moneda moneda;
  private Money estimacion_ingreso;
  private Money estimacion_egreso;
  private java.util.Date fecha_alta;
  private Usuario usuario_alta;
  private Integer probabilidad;
  private java.util.Date est_fec_cierre;
  private SensacionCierreOportunidad sensacion_cierre;
  private String descripcion;
  private Usuario usuario_owner;
  private EstadoOportunidad estado_oportunidad;
  private Campania campania;
  private Sujeto sujeto_generador;
  private Vendedor vendedor_tecnico;
  private Vendedor vendedor_comercial;
  private MotivoEstadoOportunidad motivo;
  private ClasificacionOportunidad clasificacion;
  private Boolean activo;
  private String codigo;

  public String getTema() throws BaseException { 
    supportRefresh();
    return tema;
  }

  public void setTema(String aTema) { 
    this.tema =  aTema;
  }

  public Sujeto getSujeto_potencial() throws BaseException { 
    supportRefresh();
    return sujeto_potencial;
  }

  public void setSujeto_potencial(Sujeto aSujeto_potencial) { 
    this.sujeto_potencial =  aSujeto_potencial;
  }

  public ListaPrecios getListaprecios() throws BaseException { 
    supportRefresh();
    return ListaPrecios;
  }

  public void setListaprecios(ListaPrecios aListaprecios) { 
    this.ListaPrecios =  aListaprecios;
  }

  public String getTipo_resultado() throws BaseException { 
    supportRefresh();
    return tipo_resultado;
  }

  public void setTipo_resultado(String aTipo_resultado) { 
    this.tipo_resultado =  aTipo_resultado;
  }

  public Moneda getMoneda() throws BaseException { 
    supportRefresh();
    return moneda;
  }

  public void setMoneda(Moneda aMoneda) { 
    this.moneda =  aMoneda;
  }

  public Money getEstimacion_ingreso() throws BaseException { 
    supportRefresh();
    return estimacion_ingreso;
  }

  public void setEstimacion_ingreso(Money aEstimacion_ingreso) { 
    this.estimacion_ingreso =  aEstimacion_ingreso;
  }

  public Money getEstimacion_egreso() throws BaseException { 
    supportRefresh();
    return estimacion_egreso;
  }

  public void setEstimacion_egreso(Money aEstimacion_egreso) { 
    this.estimacion_egreso =  aEstimacion_egreso;
  }

  public java.util.Date getFecha_alta() throws BaseException { 
    supportRefresh();
    return fecha_alta;
  }

  public void setFecha_alta(java.util.Date aFecha_alta) { 
    this.fecha_alta =  aFecha_alta;
  }

  public Usuario getUsuario_alta() throws BaseException { 
    supportRefresh();
    return usuario_alta;
  }

  public void setUsuario_alta(Usuario aUsuario_alta) { 
    this.usuario_alta =  aUsuario_alta;
  }

  public Integer getProbabilidad() throws BaseException { 
    supportRefresh();
    return probabilidad;
  }

  public void setProbabilidad(Integer aProbabilidad) { 
    this.probabilidad =  aProbabilidad;
  }

  public java.util.Date getEst_fec_cierre() throws BaseException { 
    supportRefresh();
    return est_fec_cierre;
  }

  public void setEst_fec_cierre(java.util.Date aEst_fec_cierre) { 
    this.est_fec_cierre =  aEst_fec_cierre;
  }

  public SensacionCierreOportunidad getSensacion_cierre() throws BaseException { 
    supportRefresh();
    return sensacion_cierre;
  }

  public void setSensacion_cierre(SensacionCierreOportunidad aSensacion_cierre) { 
    this.sensacion_cierre =  aSensacion_cierre;
  }

  public String getDescripcion() throws BaseException { 
    supportRefresh();
    return descripcion;
  }

  public void setDescripcion(String aDescripcion) { 
    this.descripcion =  aDescripcion;
  }

  public Usuario getUsuario_owner() throws BaseException { 
    supportRefresh();
    return usuario_owner;
  }

  public void setUsuario_owner(Usuario aUsuario_owner) { 
    this.usuario_owner =  aUsuario_owner;
  }

  public EstadoOportunidad getEstado_oportunidad() throws BaseException { 
    supportRefresh();
    return estado_oportunidad;
  }

  public void setEstado_oportunidad(EstadoOportunidad aEstado_oportunidad) { 
    this.estado_oportunidad =  aEstado_oportunidad;
  }

  public Campania getCampania() throws BaseException { 
    supportRefresh();
    return campania;
  }

  public void setCampania(Campania aCampania) { 
    this.campania =  aCampania;
  }

  public Sujeto getSujeto_generador() throws BaseException { 
    supportRefresh();
    return sujeto_generador;
  }

  public void setSujeto_generador(Sujeto aSujeto_generador) { 
    this.sujeto_generador =  aSujeto_generador;
  }

  public Vendedor getVendedor_tecnico() throws BaseException { 
    supportRefresh();
    return vendedor_tecnico;
  }

  public void setVendedor_tecnico(Vendedor aVendedor_tecnico) { 
    this.vendedor_tecnico =  aVendedor_tecnico;
  }

  public Vendedor getVendedor_comercial() throws BaseException { 
    supportRefresh();
    return vendedor_comercial;
  }

  public void setVendedor_comercial(Vendedor aVendedor_comercial) { 
    this.vendedor_comercial =  aVendedor_comercial;
  }

  public MotivoEstadoOportunidad getMotivo() throws BaseException { 
    supportRefresh();
    return motivo;
  }

  public void setMotivo(MotivoEstadoOportunidad aMotivo) { 
    this.motivo =  aMotivo;
  }

  public ClasificacionOportunidad getClasificacion() throws BaseException { 
    supportRefresh();
    return clasificacion;
  }

  public void setClasificacion(ClasificacionOportunidad aClasificacion) { 
    this.clasificacion =  aClasificacion;
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

 public static Oportunidad findByOid(Integer oid , ISesion aSesion) throws BaseException { 
   return (Oportunidad) getObjectByOid(NICKNAME,oid,aSesion);
  } 

 public static Oportunidad findByCodigo(String codigo , ISesion aSesion) throws BaseException { 
   return (Oportunidad) getObjectByCodigo(NICKNAME,codigo,aSesion);
  } 

 public void beforeSave() throws BaseException { 
    Validar.noNulo(tema, "Debe ingresar el Tema");
    Validar.noNulo(sujeto_potencial, "Debe ingresar el Sujeto Potencial");
    Validar.noNulo(fecha_alta, "Debe ingresar la Fecha de Alta");
    Validar.noNulo(usuario_alta, "Debe ingresar el Usuario Alta");
    Validar.noNulo(usuario_owner, "Debe ingresar el Usuario Administrador");
    
 }

public void setCodigo(String aCodigo) throws BaseException {
	this.codigo = aCodigo;
}
 
public String getCodigo() throws BaseException {
	supportRefresh();
	return codigo;
}

public void onNew() throws BaseException {
	Usuario usuario = Usuario.findByOidProxy(getSesion().getLogin().getUsuario().getOIDInteger(),getSesion());
    setUsuario_alta(usuario);
    setFecha_alta(Fecha.getFechaActual());
  }

}
