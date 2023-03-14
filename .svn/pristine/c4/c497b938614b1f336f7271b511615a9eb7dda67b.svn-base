package com.srn.erp.presupuesto.bm;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class AtributoDiccionario extends ObjetoLogico {
	
	public static final String TIPO_ATRI_DATO = "DATO";
	public static final String TIPO_ATRI_TITU = "TITULO";

  public AtributoDiccionario() { 
  }

  public static String NICKNAME = "pl.AtributoDiccionario";

  private String codigo;
  private String descripcion;
  private String desc_adic;
  private String tipo_atributo;
  private java.util.Date campo_fecha;
  private Integer campo_integer;
  private Double campo_decimal;
  private String campo_string;
  private Boolean campo_boolean;
  private CompoPresupuestario compo_presu;
  private Boolean activo;
  private ValorCompoPresu valorCompoPresu;

  public String getCodigo() throws BaseException { 
    supportRefresh();
    return codigo;
  }

  public void setCodigo(String aCodigo) { 
    this.codigo =  aCodigo;
  }
  
  public ValorCompoPresu getValorCompoPresu() throws BaseException { 
    supportRefresh();
    return this.valorCompoPresu;
  }

  public void setValorCompoPresu(ValorCompoPresu aValorCompoPresu) { 
    this.valorCompoPresu =  aValorCompoPresu;
  }
  

  public String getDescripcion() throws BaseException { 
    supportRefresh();
    return descripcion;
  }

  public void setDescripcion(String aDescripcion) { 
    this.descripcion =  aDescripcion;
  }

  public String getDesc_adic() throws BaseException { 
    supportRefresh();
    return desc_adic;
  }

  public void setDesc_adic(String aDesc_adic) { 
    this.desc_adic =  aDesc_adic;
  }

  public String getTipo_atributo() throws BaseException { 
    supportRefresh();
    return tipo_atributo;
  }

  public void setTipo_atributo(String aTipo_atributo) { 
    this.tipo_atributo =  aTipo_atributo;
  }

  public java.util.Date getCampo_fecha() throws BaseException { 
    supportRefresh();
    return campo_fecha;
  }

  public void setCampo_fecha(java.util.Date aCampo_fecha) { 
    this.campo_fecha =  aCampo_fecha;
  }

  public Integer getCampo_integer() throws BaseException { 
    supportRefresh();
    return campo_integer;
  }

  public void setCampo_integer(Integer aCampo_integer) { 
    this.campo_integer =  aCampo_integer;
  }

  public Double getCampo_decimal() throws BaseException { 
    supportRefresh();
    return campo_decimal;
  }

  public void setCampo_decimal(Double aCampo_decimal) { 
    this.campo_decimal =  aCampo_decimal;
  }

  public String getCampo_string() throws BaseException { 
    supportRefresh();
    return campo_string;
  }

  public void setCampo_string(String aCampo_string) { 
    this.campo_string =  aCampo_string;
  }

  public Boolean getCampo_boolean() throws BaseException { 
    supportRefresh();
    return campo_boolean;
  }

  public void setCampo_boolean(Boolean aCampo_boolean) { 
    this.campo_boolean =  aCampo_boolean;
  }

  public CompoPresupuestario getCompo_presu() throws BaseException { 
    supportRefresh();
    return compo_presu;
  }

  public void setCompo_presu(CompoPresupuestario aCompo_presu) { 
    this.compo_presu =  aCompo_presu;
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

 public static AtributoDiccionario findByOid(Integer oid , ISesion aSesion) throws BaseException { 
   return (AtributoDiccionario) getObjectByOid(NICKNAME,oid,aSesion);
  } 

 public static AtributoDiccionario findByOidProxy(Integer oid , ISesion aSesion) throws BaseException { 
   return (AtributoDiccionario) getObjectByOidProxy(NICKNAME,oid,aSesion);
  }
 
 public static AtributoDiccionario findByCodigo(String codigo , ISesion aSesion) throws BaseException { 
   return (AtributoDiccionario) getObjectByCodigo(NICKNAME,codigo,aSesion);
  } 

 public void beforeSave() throws BaseException { 
    Validar.noNulo(codigo, "Debe ingresar el Código");
    Validar.noNulo(descripcion, "Debe ingresar la Descripción");
    Validar.noNulo(tipo_atributo, "Debe ingresar el Tipo de Atributo");
 }

}
