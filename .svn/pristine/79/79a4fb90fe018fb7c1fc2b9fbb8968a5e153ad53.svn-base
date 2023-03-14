package com.srn.erp.crm.bm;

import com.srn.erp.ventas.bm.ListaPrecios;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bm.Seguridad.Usuario;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class Campania extends ObjetoLogico { 

  public Campania() { 
  }

  public static String NICKNAME = "crm.Campania";

  private String codigo;
  private String nombre;
  private EstadoCampania estado;
  private ListaPrecios lista_precios;
  private Integer cant_resp_esp;
  private java.util.Date fecha_desde;
  private java.util.Date fecha_hasta;
  private String descripcion;
  private String comentario;
  private Usuario usuario_alta;
  private java.util.Date fec_usu_alta;
  private Boolean activo;
  private TipoCampania tipoCampania;

  public String getCodigo() throws BaseException { 
    supportRefresh();
    return codigo;
  }

  public void setCodigo(String aCodigo) { 
    this.codigo =  aCodigo;
  }

  public TipoCampania getTipoCampania() throws BaseException { 
	    supportRefresh();
	    return tipoCampania;
	  }

  public void setTipoCampania(TipoCampania aTipoCampania) { 
	    this.tipoCampania =  aTipoCampania;
  }  
  
  public String getNombre() throws BaseException { 
    supportRefresh();
    return nombre;
  }

  public void setNombre(String aNombre) { 
    this.nombre =  aNombre;
  }

  public EstadoCampania getEstado() throws BaseException { 
    supportRefresh();
    return estado;
  }

  public void setEstado(EstadoCampania aEstado) { 
    this.estado =  aEstado;
  }

  public ListaPrecios getLista_precios() throws BaseException { 
    supportRefresh();
    return lista_precios;
  }

  public void setLista_precios(ListaPrecios aLista_precios) { 
    this.lista_precios =  aLista_precios;
  }

  public Integer getCant_resp_esp() throws BaseException { 
    supportRefresh();
    return cant_resp_esp;
  }

  public void setCant_resp_esp(Integer aCant_resp_esp) { 
    this.cant_resp_esp =  aCant_resp_esp;
  }

  public java.util.Date getFecha_desde() throws BaseException { 
    supportRefresh();
    return fecha_desde;
  }

  public void setFecha_desde(java.util.Date aFecha_desde) { 
    this.fecha_desde =  aFecha_desde;
  }

  public java.util.Date getFecha_hasta() throws BaseException { 
    supportRefresh();
    return fecha_hasta;
  }

  public void setFecha_hasta(java.util.Date aFecha_hasta) { 
    this.fecha_hasta =  aFecha_hasta;
  }

  public String getDescripcion() throws BaseException { 
    supportRefresh();
    return descripcion;
  }

  public void setDescripcion(String aDescripcion) { 
    this.descripcion =  aDescripcion;
  }

  public String getComentario() throws BaseException { 
    supportRefresh();
    return comentario;
  }

  public void setComentario(String aComentario) { 
    this.comentario =  aComentario;
  }

  public Usuario getUsuario_alta() throws BaseException { 
    supportRefresh();
    return usuario_alta;
  }

  public void setUsuario_alta(Usuario aUsuario_alta) { 
    this.usuario_alta =  aUsuario_alta;
  }

  public java.util.Date getFec_usu_alta() throws BaseException { 
    supportRefresh();
    return fec_usu_alta;
  }

  public void setFec_usu_alta(java.util.Date aFec_usu_alta) { 
    this.fec_usu_alta =  aFec_usu_alta;
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

 public static Campania findByOid(Integer oid , ISesion aSesion) throws BaseException { 
   return (Campania) getObjectByOid(NICKNAME,oid,aSesion);
  } 

 public static Campania findByOidProxy(Integer oid , ISesion aSesion) throws BaseException { 
	   return (Campania) getObjectByOidProxy(NICKNAME,oid,aSesion);
 } 
 
 public static Campania findByCodigo(String codigo , ISesion aSesion) throws BaseException { 
   return (Campania) getObjectByCodigo(NICKNAME,codigo,aSesion);
  } 

 public void beforeSave() throws BaseException { 
    Validar.noNulo(codigo, "Debe ingresar el código");
    Validar.noNulo(nombre, "Debe ingresar el nombre de la Campaña");
    Validar.noNulo(estado, "Debe ingresar el Estado de la Campaña");
    Validar.noNulo(lista_precios, "Debe ingresar la Lista de Precios");
    Validar.noNulo(cant_resp_esp, "Debe ingresar la cantidad de respuestas esperadas");
    Validar.noNulo(fecha_desde, "Debe ingresar la fecha de vigencia desde");
    Validar.noNulo(fecha_hasta, "Debe ingresar la fecha de vigencia hasta");
    Validar.noNulo(descripcion, "Debe ingresar la Descripción");
    Validar.noNulo(tipoCampania, "Debe ingresar el Tipo de Campaña");
 }

 
 
}

