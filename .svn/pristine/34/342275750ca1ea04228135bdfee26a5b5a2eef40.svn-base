package com.srn.erp.presupuesto.bm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class TipoCiclo extends ObjetoLogico { 

  public TipoCiclo() { 
  }

  public static String NICKNAME = "pl.TipoCiclo";

  private String codigo;
  private String descripcion;
  private ValorEscenario valor_escenario;
  private Boolean activo;
  
  private List estructuras = new ArrayList();
  private boolean readEstructuras = true;
  
  private List gruposUPC = new ArrayList();
  private boolean readGruposUPC = true;

  public String getCodigo() throws BaseException { 
    supportRefresh();
    return codigo;
  }

  public void setCodigo(String aCodigo) { 
    this.codigo =  aCodigo;
  }

  public String getDescripcion() throws BaseException { 
    supportRefresh();
    return descripcion;
  }

  public void setDescripcion(String aDescripcion) { 
    this.descripcion =  aDescripcion;
  }

  public ValorEscenario getValor_escenario() throws BaseException { 
    supportRefresh();
    return valor_escenario;
  }

  public void setValor_escenario(ValorEscenario aValor_escenario) { 
    this.valor_escenario =  aValor_escenario;
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

 public static TipoCiclo findByOid(Integer oid , ISesion aSesion) throws BaseException { 
   return (TipoCiclo) getObjectByOid(NICKNAME,oid,aSesion);
  } 

 public static TipoCiclo findByOidProxy(Integer oid , ISesion aSesion) throws BaseException { 
   return (TipoCiclo) getObjectByOidProxy(NICKNAME,oid,aSesion);
  } 
 
 
 public static TipoCiclo findByCodigo(String codigo , ISesion aSesion) throws BaseException { 
   return (TipoCiclo) getObjectByCodigo(NICKNAME,codigo,aSesion);
  } 

 public void beforeSave() throws BaseException { 
    Validar.noNulo(codigo, "Debe ingresar el código");
    Validar.noNulo(descripcion, "Debe ingresar la Descripción");
    Validar.noNulo(valor_escenario, "Debe ingresar el Valor de Escenario");
 }
 
 public List getEstructurasTipoCiclo() throws BaseException {
   if (this.readEstructuras) {
     List listaEstructurasTipoCiclo = EstructuraTipoCiclo.getEstructurasTipoCiclo(this,getSesion());
     estructuras.addAll(listaEstructurasTipoCiclo);
     this.readEstructuras = false;
   }
   return estructuras;
 }
 
 public List getGruposUPCTipoCiclo() throws BaseException {
   if (this.readGruposUPC) {
     List listaGruposUPCTipoCiclo = GrupoUPCTipoCiclo.getGruposUPCByTipoCiclo(this,getSesion());
     gruposUPC.addAll(listaGruposUPCTipoCiclo);
     this.readGruposUPC = false;
   }
   return gruposUPC;
 }
 

 public void addEstructuraTipoCiclo(EstructuraTipoCiclo aEstructuraTipoCiclo) throws BaseException {
	 aEstructuraTipoCiclo.setTipo_ciclo(this);
   estructuras.add(aEstructuraTipoCiclo);
 }
 
 public void addGrupoUPCTipoCiclo(GrupoUPCTipoCiclo aGrupoUPCTipoCiclo) throws BaseException {
	 aGrupoUPCTipoCiclo.setTipo_ciclo(this);
   gruposUPC.add(aGrupoUPCTipoCiclo);
 }
 

 public void afterSave() throws BaseException {
	 
   Iterator iterEstructurasTipoCiclo = estructuras.iterator();
   while (iterEstructurasTipoCiclo.hasNext()) {
     EstructuraTipoCiclo estructuraTipoCiclo = (EstructuraTipoCiclo) iterEstructurasTipoCiclo.next();
     estructuraTipoCiclo.save();
     estructuraTipoCiclo = null;
   }
   iterEstructurasTipoCiclo = null;
   
   Iterator iterGruposUPCTipoCiclo = gruposUPC.iterator();
   while (iterGruposUPCTipoCiclo.hasNext()) {
     GrupoUPCTipoCiclo grupoUPCTipoCiclo = (GrupoUPCTipoCiclo) iterGruposUPCTipoCiclo.next();
     grupoUPCTipoCiclo.save();
     grupoUPCTipoCiclo = null;
   }
   iterGruposUPCTipoCiclo = null;
   
 }
 
 public EstructuraTipoCiclo getEstructuraTipoCiclo(EstructuraPlanificacion estructura) throws BaseException {
	 return EstructuraTipoCiclo.getEstructuraTipoCiclo(this,estructura,this.getSesion());
 }
 
 public GrupoUPCTipoCiclo getGrupoUPCTipoCiclo(GrupoTipoUPC grupoTipoUPC) throws BaseException {
	 return GrupoUPCTipoCiclo.getGrupoUPCTipoCiclo(this,grupoTipoUPC,this.getSesion());
 }

 
 public boolean istTipoUPCAsociado(TipoUPC aTipoUPC) throws BaseException {
   Iterator iterGruposUPCTipoCiclo = this.getGruposUPCTipoCiclo().iterator();
   while (iterGruposUPCTipoCiclo.hasNext()) {
	 GrupoUPCTipoCiclo grupoUPCTipoCiclo = (GrupoUPCTipoCiclo) iterGruposUPCTipoCiclo.next();
	 GrupoTipoUPC grupotipoUPC = grupoUPCTipoCiclo.getGrupo_tipo_upc();
	 Iterator iterGrupoTipoUPC = grupotipoUPC.getDetalles().iterator();
	 while (iterGrupoTipoUPC.hasNext()) {
		 GrupoTipoUPCDet grupoTipoUPCDet = (GrupoTipoUPCDet) iterGrupoTipoUPC.next();
		 TipoUPC tipoUPC = grupoTipoUPCDet.getTipo_upc();
		 if (tipoUPC.getOID() == aTipoUPC.getOID())
			  return true;
	 }
   }
   return false;
 }
 

}
