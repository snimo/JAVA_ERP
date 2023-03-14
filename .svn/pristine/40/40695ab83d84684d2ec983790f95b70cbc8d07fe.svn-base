package com.srn.erp.ventas.bm;

import java.util.List;

import com.srn.erp.stock.bm.TipoConfMovStkTalonario;
import com.srn.erp.ventas.da.DBCompoStkTalonarioDevVtas;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.ObjetoObservado;
import framework.request.bl.Utils.Validar;

public class CompoStkTalonarioDevVtas extends ObjetoLogico { 

  @Override
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

public CompoStkTalonarioDevVtas() { 
  }

  public static String NICKNAME = "ve.CompoStkTalonarioDevVtas";

  private OperHabiTalonarioDevVtas oper_hab_tal_dev;
  private TipoConfMovStkTalonario tipo_conf_mov;
  private Boolean usar_por_defecto;

  public OperHabiTalonarioDevVtas getOper_hab_tal_dev() throws BaseException { 
    supportRefresh();
    return oper_hab_tal_dev;
  }

  public void setOper_hab_tal_dev(OperHabiTalonarioDevVtas aOper_hab_tal_dev) { 
    this.oper_hab_tal_dev =  aOper_hab_tal_dev;
  }

  public TipoConfMovStkTalonario getTipo_conf_mov() throws BaseException { 
    supportRefresh();
    return tipo_conf_mov;
  }

  public void setTipo_conf_mov(TipoConfMovStkTalonario aTipo_conf_mov) { 
    this.tipo_conf_mov =  aTipo_conf_mov;
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

 public static CompoStkTalonarioDevVtas findByOid(Integer oid , ISesion aSesion) throws BaseException { 
   return (CompoStkTalonarioDevVtas) getObjectByOid(NICKNAME,oid,aSesion);
  } 

 public static CompoStkTalonarioDevVtas findByCodigo(String codigo , ISesion aSesion) throws BaseException { 
   return (CompoStkTalonarioDevVtas) getObjectByCodigo(NICKNAME,codigo,aSesion);
  } 

 public void beforeSave() throws BaseException { 
    Validar.noNulo(oper_hab_tal_dev, "Debe ingresar el Talonario");
    Validar.noNulo(tipo_conf_mov, "Debe ingresar el Tipo de Movimiento");
    Validar.noNulo(usar_por_defecto, "Debe ingresar si se usa o no por defecto");
 }
 
 public static List getCompoStockTalonario(OperHabiTalonarioDevVtas operHabDevVtas,
         ISesion aSesion) throws BaseException {
	  return DBCompoStkTalonarioDevVtas.getCompoStockTalonario(operHabDevVtas,aSesion);
 }
 
 public static CompoStkTalonarioDevVtas getCompoStkTalDevVtas(OperHabiTalonarioDevVtas operHabTalDev,
		  TipoConfMovStkTalonario tipoConfMovStok,
         ISesion aSesion)
         throws BaseException {

	  return DBCompoStkTalonarioDevVtas.getCompoStkTalDevVtas(operHabTalDev,tipoConfMovStok,aSesion);
 }
 
 

}
