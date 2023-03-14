package com.srn.erp.contabilidad.bm;

import java.util.List;

import com.srn.erp.contabilidad.da.DBAtributoEnGrupo;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class AtributoEnGrupo extends ObjetoLogico { 

  public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public AtributoEnGrupo() { 
  }

  public static String NICKNAME = "cg.AtributoEnGrupo";

  private GrupoDeAtributos grupoAtri;
  private Atributo atributo;
  private Integer secu;
  private String formato;
  private Boolean obligatorio;
  private Integer max_longitud;
  private Boolean activo;

  public GrupoDeAtributos getGrupoatri() throws BaseException { 
    supportRefresh();
    return grupoAtri;
  }

  public void setGrupoatri(GrupoDeAtributos aGrupoatri) { 
    this.grupoAtri =  aGrupoatri;
  }

  public Atributo getAtributo() throws BaseException { 
    supportRefresh();
    return atributo;
  }

  public void setAtributo(Atributo aAtributo) { 
    this.atributo =  aAtributo;
  }

  public Integer getSecu() throws BaseException { 
    supportRefresh();
    return secu;
  }

  public void setSecu(Integer aSecu) { 
    this.secu =  aSecu;
  }

  public String getFormato() throws BaseException { 
    supportRefresh();
    return formato;
  }

  public void setFormato(String aFormato) { 
    this.formato =  aFormato;
  }

  public Boolean isObligatorio() throws BaseException { 
    supportRefresh();
    return obligatorio;
  }

  public void setObligatorio(Boolean aObligatorio) { 
    this.obligatorio =  aObligatorio;
  }

  public Integer getMax_longitud() throws BaseException { 
    supportRefresh();
    return max_longitud;
  }

  public void setMax_longitud(Integer aMax_longitud) { 
    this.max_longitud =  aMax_longitud;
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

 public static AtributoEnGrupo findByOid(Integer oid , ISesion aSesion) throws BaseException { 
   return (AtributoEnGrupo) getObjectByOid(NICKNAME,oid,aSesion);
  } 

 public static AtributoEnGrupo findByCodigo(String codigo , ISesion aSesion) throws BaseException { 
   return (AtributoEnGrupo) getObjectByCodigo(NICKNAME,codigo,aSesion);
  } 

 public void beforeSave() throws BaseException { 
    Validar.noNulo(grupoAtri, "Debe ingresar el Grupo de Atributos");
    Validar.noNulo(atributo, "Debe ingresar el Atributo");
    Validar.noNulo(secu, "Debe ingresar el Orden");
 }
 
	public static List getAtributosEnGrupo(GrupoDeAtributos grupoDeAtributos, ISesion aSesion)
	throws BaseException {
		return DBAtributoEnGrupo.getAtributosEnGrupo(grupoDeAtributos, aSesion);
	}
 

}
