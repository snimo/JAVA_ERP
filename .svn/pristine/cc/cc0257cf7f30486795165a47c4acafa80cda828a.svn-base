package com.srn.erp.ventas.bm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.general.bm.PeriodoIncDet;
import com.srn.erp.general.bm.Talonario;
import com.srn.erp.ventas.da.DBConfigTalonarioDevVtas;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ObjetoObservado;
import framework.request.bl.Utils.Validar;

public class ConfigTalonarioDevVtas extends ObjetoLogico { 

  public ConfigTalonarioDevVtas() { 
  }

  public static String NICKNAME = "ve.ConfigTalonarioDevVtas";

  private Talonario talonario;
  private Boolean activo;
  
  private List operHabilitadas = new ArrayList();
  private boolean readOperHabilitadas = true;
  

  public Talonario getTalonario() throws BaseException { 
    supportRefresh();
    return talonario;
  }

  public String getCodigo() throws BaseException {
	// TODO Auto-generated method stub
	return null;
}

public String getDescripcion() throws BaseException {
	// TODO Auto-generated method stub
	return null;
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

 public static ConfigTalonarioDevVtas findByOid(Integer oid , ISesion aSesion) throws BaseException { 
   return (ConfigTalonarioDevVtas) getObjectByOid(NICKNAME,oid,aSesion);
  }
 
 public static ConfigTalonarioDevVtas findByOidProxy(Integer oid , ISesion aSesion) throws BaseException { 
	return (ConfigTalonarioDevVtas) getObjectByOidProxy(NICKNAME,oid,aSesion);
 } 
 

 public static ConfigTalonarioDevVtas findByCodigo(String codigo , ISesion aSesion) throws BaseException { 
   return (ConfigTalonarioDevVtas) getObjectByCodigo(NICKNAME,codigo,aSesion);
  } 

 public void beforeSave() throws BaseException { 
    Validar.noNulo(talonario, "Debe ingresar el Talonario");
 }
 
 public List getOperHabilitadas() throws BaseException {
	    if (this.readOperHabilitadas) {
	      List listaOperHabilitadas = OperHabiTalonarioDevVtas.getOperHabilitadasPorConfTalonario(this,getSesion());
	      operHabilitadas.addAll(listaOperHabilitadas);
	      this.readOperHabilitadas = false;
	    }
	    return operHabilitadas;
 }

 public void addOperHabilitada(OperHabiTalonarioDevVtas operHab) throws BaseException {
	 operHab.setConf_tal_dev(this);
	 operHabilitadas.add(operHab);
 }

 public void afterSave() throws BaseException {
	Iterator iterConfTalDev = operHabilitadas.iterator();
	while (iterConfTalDev.hasNext()) {
	      OperHabiTalonarioDevVtas OperHab = (OperHabiTalonarioDevVtas) iterConfTalDev.next();
	      OperHab.save();
	      OperHab = null;
	}
	iterConfTalDev = null;
 }
 
 public static ConfigTalonarioDevVtas getConfigTalolario(Talonario talonario,
	        ISesion aSesion)
	        throws BaseException {
	return DBConfigTalonarioDevVtas.getConfigTalDevVtas(talonario,aSesion);
 }
 
 

}
