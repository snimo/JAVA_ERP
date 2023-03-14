package com.srn.erp.ctasAPagar.bm;

import java.util.List;

import com.srn.erp.contabilidad.bm.Cuenta;
import com.srn.erp.contabilidad.bm.CuentaImputable;
import com.srn.erp.ctasAPagar.da.DBEsqCuentaConcFactProv;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class EsqCuentaConcFactProv extends ObjetoLogico { 

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

	public EsqCuentaConcFactProv() { 
  }

  public static String NICKNAME = "cap.EsqCuentaConcFactProv";

  private ConcFactProv conc_fact_prov;
  private Cuenta cuenta_contable;

  public ConcFactProv getConc_fact_prov() throws BaseException { 
    supportRefresh();
    return conc_fact_prov;
  }

  public void setConc_fact_prov(ConcFactProv aConc_fact_prov) { 
    this.conc_fact_prov =  aConc_fact_prov;
  }

  public Cuenta getCuenta_contable() throws BaseException { 
    supportRefresh();
    return this.cuenta_contable;
  }

  public void setCuenta_contable(Cuenta aCuenta_contable) { 
    this.cuenta_contable =  aCuenta_contable;
  }

  public String getNickName() { 
    return NICKNAME; 
  } 

 public static EsqCuentaConcFactProv findByOid(Integer oid , ISesion aSesion) throws BaseException { 
   return (EsqCuentaConcFactProv) getObjectByOid(NICKNAME,oid,aSesion);
  } 

 public static EsqCuentaConcFactProv findByCodigo(String codigo , ISesion aSesion) throws BaseException { 
   return (EsqCuentaConcFactProv) getObjectByCodigo(NICKNAME,codigo,aSesion);
  } 

 public void beforeSave() throws BaseException { 
    Validar.noNulo(conc_fact_prov, "Debe ingresar el Concepto Factura Proveedor");
    Validar.noNulo(cuenta_contable, "Debe ingresar la Cuenta");
 }
 
 public static List getEsqCuentasConcFactProv(ConcFactProv concFactProv,
     ISesion aSesion) throws BaseException {
 	return DBEsqCuentaConcFactProv.getEsqCuentasConcFactProv(concFactProv,aSesion);
 }
 

}
