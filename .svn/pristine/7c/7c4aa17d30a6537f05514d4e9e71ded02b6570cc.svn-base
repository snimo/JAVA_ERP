package com.srn.erp.contabilidad.bm;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class AnuladorAsientoManualDet extends ObjetoLogico { 

  public AnuladorAsientoManualDet() { 
  }

  public static String NICKNAME = "cg.AnuladorAsientoManualDet";

  private AnuladorAsientoManual anulador_asiento_manual;
  private AsientoManualDet det_asiento_manual;

  public AnuladorAsientoManual getAnulador_asiento_manual() throws BaseException { 
    supportRefresh();
    return anulador_asiento_manual;
  }

  public void setAnulador_asiento_manual(AnuladorAsientoManual aAnulador_asiento_manual) { 
    this.anulador_asiento_manual =  aAnulador_asiento_manual;
  }

  public AsientoManualDet getDet_asiento_manual() throws BaseException { 
    supportRefresh();
    return det_asiento_manual;
  }

  public void setDet_asiento_manual(AsientoManualDet aDet_asiento_manual) { 
    this.det_asiento_manual =  aDet_asiento_manual;
  }

  public String getNickName() { 
    return NICKNAME; 
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

public static AnuladorAsientoManualDet findByOid(Integer oid , ISesion aSesion) throws BaseException { 
   return (AnuladorAsientoManualDet) getObjectByOid(NICKNAME,oid,aSesion);
  } 

 public static AnuladorAsientoManualDet findByCodigo(String codigo , ISesion aSesion) throws BaseException { 
   return (AnuladorAsientoManualDet) getObjectByCodigo(NICKNAME,codigo,aSesion);
  } 

 public void beforeSave() throws BaseException { 
    Validar.noNulo(anulador_asiento_manual, "Debe ingresar el Anulador Asiento Manual");
    Validar.noNulo(det_asiento_manual, "Debe ingresar el Detalle del Asiento");
 }

}
