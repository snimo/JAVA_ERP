package com.srn.erp.ventas.bm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.general.bm.PeriodoIncDet;
import com.srn.erp.ventas.da.DBOperHabiTalonarioDevVtas;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.ObjetoObservado;
import framework.request.bl.Utils.Validar;

public class OperHabiTalonarioDevVtas extends ObjetoLogico {
	
	private List comportamientosStock = new ArrayList();
	private boolean readComportamientosStock	 = true;
	

  public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean isActivo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

public OperHabiTalonarioDevVtas() { 
  }

  public static String NICKNAME = "ve.OperHabiTalonarioDevVtas";

  private ConfigTalonarioDevVtas conf_tal_dev;
  private String tipo_devolucion;
  private Boolean usar_por_defecto;

  public ConfigTalonarioDevVtas getConf_tal_dev() throws BaseException { 
    supportRefresh();
    return conf_tal_dev;
  }

  public void setConf_tal_dev(ConfigTalonarioDevVtas aConf_tal_dev) { 
    this.conf_tal_dev =  aConf_tal_dev;
  }

  public String getTipo_devolucion() throws BaseException { 
    supportRefresh();
    return tipo_devolucion;
  }

  public void setTipo_devolucion(String aTipo_devolucion) { 
    this.tipo_devolucion =  aTipo_devolucion;
  }

  public Boolean isUsar_por_defecto() throws BaseException { 
    supportRefresh();
    return usar_por_defecto;
  }

  public void setUsar_por_defecto(Boolean aUsar_por_defecto) { 
    this.usar_por_defecto =  aUsar_por_defecto;
  }

  public String getNickName() { 
    return NICKNAME; 
  } 

 public static OperHabiTalonarioDevVtas findByOid(Integer oid , ISesion aSesion) throws BaseException { 
   return (OperHabiTalonarioDevVtas) getObjectByOid(NICKNAME,oid,aSesion);
  }
 
 public static OperHabiTalonarioDevVtas findByOidProxy(Integer oid , ISesion aSesion) throws BaseException { 
	   return (OperHabiTalonarioDevVtas) getObjectByOidProxy(NICKNAME,oid,aSesion);
 } 
 

 public static OperHabiTalonarioDevVtas findByCodigo(String codigo , ISesion aSesion) throws BaseException { 
   return (OperHabiTalonarioDevVtas) getObjectByCodigo(NICKNAME,codigo,aSesion);
  } 

 public void beforeSave() throws BaseException { 
    Validar.noNulo(conf_tal_dev, "Debe ingresar el Talonario");
    Validar.noNulo(tipo_devolucion, "Debe ingresar el Tipo de Devolución");
    Validar.noNulo(usar_por_defecto, "Debe ingresar si se usa o no por defecto");
 }
 
 public static List getOperHabilitadasPorConfTalonario(ConfigTalonarioDevVtas configTalDevVtas,
         ISesion aSesion) throws BaseException {
	  return DBOperHabiTalonarioDevVtas.getOperHabilitadasPorConfTalonario(configTalDevVtas, aSesion);
 }
 
 public List getCompoStockTalonario() throws BaseException {
	if (readComportamientosStock) {
	      List listaCompoStock = CompoStkTalonarioDevVtas.getCompoStockTalonario(this,getSesion());
	      comportamientosStock.addAll(listaCompoStock);
	      readComportamientosStock = false;
	}
	return comportamientosStock;
 }

 public void addCompoStockTalonario(CompoStkTalonarioDevVtas aCompoStkTalonarioDevVtas) throws BaseException {
	 aCompoStkTalonarioDevVtas.setOper_hab_tal_dev(this);
	 comportamientosStock.add(aCompoStkTalonarioDevVtas);
 }

 public void afterSave() throws BaseException {
	Iterator iterCompoStock = comportamientosStock.iterator();
	while (iterCompoStock.hasNext()) {
	      CompoStkTalonarioDevVtas compoStk = (CompoStkTalonarioDevVtas) iterCompoStock.next();
	      compoStk.save();
	      compoStk = null;
	}
	iterCompoStock = null;
 }
 
 public static OperHabiTalonarioDevVtas getOperHabiTalonarioDevVtas(ConfigTalonarioDevVtas confTalDevVtas,
		  String tipoDevolucion,
         ISesion aSesion)
         throws BaseException {

	  return DBOperHabiTalonarioDevVtas.getOperHabiTalonarioDevVtas(confTalDevVtas,tipoDevolucion,aSesion);
 }
 
 
 

}
