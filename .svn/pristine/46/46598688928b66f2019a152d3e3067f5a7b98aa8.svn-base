package com.srn.erp.stock.bm;

import com.srn.erp.general.bm.ClasificadorEntidad;
import com.srn.erp.stock.da.DBConfGenMasProd;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ObjetoObservado;
import framework.request.bl.Utils.Validar;

public class ConfGenMasProd extends ObjetoLogico { 

  public ConfGenMasProd() { 
  }

  public static String NICKNAME = "st.ConfGenMasProd";

  private ClasificadorEntidad clasificador;
  private Boolean incluir_codigo;
  private Integer orden_codigo;
  private String pre_codigo;
  private String suf_codigo;
  private Boolean incluir_desc;
  private Integer orden_desc;
  private String pre_desc;
  private String suf_desc;
  private Boolean incluir_sino;
  private Integer orden_sino;
  private String pre_sino;
  private String suf_sino;
  private Boolean incluir_barra;
  private Integer orden_barra;
  private String pre_barra;
  private String suf_barra;

  public ClasificadorEntidad getClasificador() throws BaseException { 
    supportRefresh();
    return clasificador;
  }

  public void setClasificador(ClasificadorEntidad aClasificador) { 
    this.clasificador =  aClasificador;
  }

  public Boolean isIncluir_codigo() throws BaseException { 
    supportRefresh();
    return incluir_codigo;
  }

  public void setIncluir_codigo(Boolean aIncluir_codigo) { 
    this.incluir_codigo =  aIncluir_codigo;
  }

  public Integer getOrden_codigo() throws BaseException { 
    supportRefresh();
    return orden_codigo;
  }

  public void setOrden_codigo(Integer aOrden_codigo) { 
    this.orden_codigo =  aOrden_codigo;
  }

  public String getPre_codigo() throws BaseException { 
    supportRefresh();
    return pre_codigo;
  }

  public void setPre_codigo(String aPre_codigo) { 
    this.pre_codigo =  aPre_codigo;
  }

  public String getSuf_codigo() throws BaseException { 
    supportRefresh();
    return suf_codigo;
  }

  public void setSuf_codigo(String aSuf_codigo) { 
    this.suf_codigo =  aSuf_codigo;
  }

  public Boolean isIncluir_desc() throws BaseException { 
    supportRefresh();
    return incluir_desc;
  }

  public void setIncluir_desc(Boolean aIncluir_desc) { 
    this.incluir_desc =  aIncluir_desc;
  }

  public Integer getOrden_desc() throws BaseException { 
    supportRefresh();
    return orden_desc;
  }

  public void setOrden_desc(Integer aOrden_desc) { 
    this.orden_desc =  aOrden_desc;
  }

  public String getPre_desc() throws BaseException { 
    supportRefresh();
    return pre_desc;
  }

  public void setPre_desc(String aPre_desc) { 
    this.pre_desc =  aPre_desc;
  }

  public String getSuf_desc() throws BaseException { 
    supportRefresh();
    return suf_desc;
  }

  public void setSuf_desc(String aSuf_desc) { 
    this.suf_desc =  aSuf_desc;
  }

  public Boolean isIncluir_sino() throws BaseException { 
    supportRefresh();
    return incluir_sino;
  }

  public void setIncluir_sino(Boolean aIncluir_sino) { 
    this.incluir_sino =  aIncluir_sino;
  }

  public Integer getOrden_sino() throws BaseException { 
    supportRefresh();
    return orden_sino;
  }

  public void setOrden_sino(Integer aOrden_sino) { 
    this.orden_sino =  aOrden_sino;
  }

  public String getPre_sino() throws BaseException { 
    supportRefresh();
    return pre_sino;
  }

  public void setPre_sino(String aPre_sino) { 
    this.pre_sino =  aPre_sino;
  }

  public String getSuf_sino() throws BaseException { 
    supportRefresh();
    return suf_sino;
  }

  public void setSuf_sino(String aSuf_sino) { 
    this.suf_sino =  aSuf_sino;
  }

  public Boolean isIncluir_barra() throws BaseException { 
    supportRefresh();
    return incluir_barra;
  }

  public void setIncluir_barra(Boolean aIncluir_barra) { 
    this.incluir_barra =  aIncluir_barra;
  }

  public Integer getOrden_barra() throws BaseException { 
    supportRefresh();
    return orden_barra;
  }

  public void setOrden_barra(Integer aOrden_barra) { 
    this.orden_barra =  aOrden_barra;
  }

  public String getPre_barra() throws BaseException { 
    supportRefresh();
    return pre_barra;
  }

  public void setPre_barra(String aPre_barra) { 
    this.pre_barra =  aPre_barra;
  }

  public String getSuf_barra() throws BaseException { 
    supportRefresh();
    return suf_barra;
  }

  public void setSuf_barra(String aSuf_barra) { 
    this.suf_barra =  aSuf_barra;
  }

  public String getNickName() { 
    return NICKNAME; 
  } 

 public static ConfGenMasProd findByOid(Integer oid , ISesion aSesion) throws BaseException { 
   return (ConfGenMasProd) getObjectByOid(NICKNAME,oid,aSesion);
  } 

 public Boolean isActivo() throws BaseException {
	// TODO Auto-generated method stub
	return null;
}

public String getCodigo() throws BaseException {
	// TODO Auto-generated method stub
	return null;
}

public String getDescripcion() throws BaseException {
	// TODO Auto-generated method stub
	return null;
}

public static ConfGenMasProd findByCodigo(String codigo , ISesion aSesion) throws BaseException { 
   return (ConfGenMasProd) getObjectByCodigo(NICKNAME,codigo,aSesion);
  } 

 public void beforeSave() throws BaseException { 
    Validar.noNulo(clasificador, "Debe ingresar el Clasificador");
 }
 
 public static ConfGenMasProd getConfGenMasProd(ClasificadorEntidad clasificadorEntidad,
     ISesion aSesion)
     throws BaseException {
 	return DBConfGenMasProd.getConfGenMasProd(clasificadorEntidad,aSesion);
 }
 

}
