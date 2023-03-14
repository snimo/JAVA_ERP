package com.srn.erp.presupuesto.bm;


import java.util.List;

import com.srn.erp.presupuesto.da.DBValorEscenario;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class ValorEscenario extends ObjetoLogico { 

  public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		supportRefresh();
		return this.descripcion;
	}
	
	

	public ValorEscenario() { 
  }

  public static String NICKNAME = "pl.ValorEscenario";

  private Escenario escenario;
  private String descripcion;
  private CompoPresupuestario compo_presu;
  private ValorCompoPresu valor_compo;
  private String nro_relacion;
  private String nro_relacion_padre;
  private Boolean activo;
  private Boolean ultimoNivel;
  

  public Escenario getEscenario() throws BaseException { 
    supportRefresh();
    return this.escenario;
  }

  public void setEscenario(Escenario aEscenario) { 
    this.escenario =  aEscenario;
  }
  
  public Boolean isUltimoNivel() throws BaseException { 
    supportRefresh();
    return this.ultimoNivel;
  }

  public void setUltimoNivel(Boolean aUltimoNivel) { 
    this.ultimoNivel =  aUltimoNivel;
  }
  

  public CompoPresupuestario getCompo_presu() throws BaseException { 
    supportRefresh();
    return compo_presu;
  }

  public void setCompo_presu(CompoPresupuestario aCompo_presu) { 
    this.compo_presu =  aCompo_presu;
  }
  
  public void setDescripcion(String aDescripcion) { 
    this.descripcion =  aDescripcion;
  }
  

  public ValorCompoPresu getValor_compo() throws BaseException { 
    supportRefresh();
    return valor_compo;
  }

  public void setValor_compo(ValorCompoPresu aValor_compo) { 
    this.valor_compo =  aValor_compo;
  }

  public String getNro_relacion() throws BaseException { 
    supportRefresh();
    return nro_relacion;
  }

  public void setNro_relacion(String aNro_relacion) { 
    this.nro_relacion =  aNro_relacion;
  }
  
  
  public String getNro_relacion_padre() throws BaseException { 
    supportRefresh();
    return nro_relacion_padre;
  }

  public void setNro_relacion_padre(String aNro_relacion_padre) { 
    this.nro_relacion_padre =  aNro_relacion_padre;
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

 public static ValorEscenario findByOid(Integer oid , ISesion aSesion) throws BaseException { 
   return (ValorEscenario) getObjectByOid(NICKNAME,oid,aSesion);
 }
 
 public static ValorEscenario findByOidProxy(Integer oid , ISesion aSesion) throws BaseException { 
   return (ValorEscenario) getObjectByOidProxy(NICKNAME,oid,aSesion);
 } 
 

 public static ValorEscenario findByCodigo(String codigo , ISesion aSesion) throws BaseException { 
   return (ValorEscenario) getObjectByCodigo(NICKNAME,codigo,aSesion);
  } 

 public void beforeSave() throws BaseException { 
    Validar.noNulo(escenario, "Debe ingresar un escenario");
    Validar.noNulo(compo_presu, "Debe ingresar el componente presupuestario");
    Validar.noNulo(valor_compo, "Debe ingresar el Valor de Componente");
    Validar.noNulo(nro_relacion, "Debe ingresar el Nro. de Relación");
    Validar.noNulo(nro_relacion_padre, "Debe ingresar el Nro. de Relación padre");
 }
 
 public static List getValoresByEscenario(Escenario escenario,
     ISesion aSesion) throws BaseException {
 	return DBValorEscenario.getValoresByEscenario(escenario,aSesion);
 }
 
 public static List getValoresByUltimoNivelActivos(ISesion aSesion) throws BaseException {
 	return DBValorEscenario.getValoresByUltimoNivelActivos(aSesion);
 }
 

}
