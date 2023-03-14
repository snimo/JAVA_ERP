package com.srn.erp.ventas.bm;

import java.util.Date;
import java.util.List;

import com.srn.erp.ventas.da.DBTablaPercIBBsAs;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.applicarionServer.bm.Varios.Porcentaje;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.ObjetoObservado;
import framework.request.bl.Utils.Validar;

public class TablaPercIBBsAs extends ObjetoLogico { 

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

	public TablaPercIBBsAs() { 
  }

  public static String NICKNAME = "ve.TablaPercIBBsAs";

  private Date fec_public;
  private Date fec_vig_desde;
  private Date fec_vig_hasta;
  private String cuit;
  private String tipo;
  private String marca_ab_sujeto;
  private String marca_cambio_ali;
  private Porcentaje ali_percepcion;
  private Porcentaje ali_retencion;
  private Integer nro_gr_ret;
  private Integer nro_gr_per;

  public Date getFec_public() throws BaseException { 
    supportRefresh();
    return fec_public;
  }

  public void setFec_public(Date aFec_public) { 
    this.fec_public =  aFec_public;
  }

  public Date getFec_vig_desde() throws BaseException { 
    supportRefresh();
    return fec_vig_desde;
  }

  public void setFec_vig_desde(Date aFec_vig_desde) { 
    this.fec_vig_desde =  aFec_vig_desde;
  }

  public Date getFec_vig_hasta() throws BaseException { 
    supportRefresh();
    return fec_vig_hasta;
  }

  public void setFec_vig_hasta(Date aFec_vig_hasta) { 
    this.fec_vig_hasta =  aFec_vig_hasta;
  }

  public String getCuit() throws BaseException { 
    supportRefresh();
    return cuit;
  }

  public void setCuit(String aCuit) { 
    this.cuit =  aCuit;
  }

  public String getTipo() throws BaseException { 
    supportRefresh();
    return tipo;
  }

  public void setTipo(String aTipo) { 
    this.tipo =  aTipo;
  }

  public String getMarca_ab_sujeto() throws BaseException { 
    supportRefresh();
    return marca_ab_sujeto;
  }

  public void setMarca_ab_sujeto(String aMarca_ab_sujeto) { 
    this.marca_ab_sujeto =  aMarca_ab_sujeto;
  }

  public String getMarca_cambio_ali() throws BaseException { 
    supportRefresh();
    return marca_cambio_ali;
  }

  public void setMarca_cambio_ali(String aMarca_cambio_ali) { 
    this.marca_cambio_ali =  aMarca_cambio_ali;
  }

  public Porcentaje getAli_percepcion() throws BaseException { 
    supportRefresh();
    return ali_percepcion;
  }

  public void setAli_percepcion(Porcentaje aAli_percepcion) { 
    this.ali_percepcion =  aAli_percepcion;
  }

  public Porcentaje getAli_retencion() throws BaseException { 
    supportRefresh();
    return ali_retencion;
  }

  public void setAli_retencion(Porcentaje aAli_retencion) { 
    this.ali_retencion =  aAli_retencion;
  }

  public Integer getNro_gr_ret() throws BaseException { 
    supportRefresh();
    return nro_gr_ret;
  }

  public void setNro_gr_ret(Integer aNro_gr_ret) { 
    this.nro_gr_ret =  aNro_gr_ret;
  }

  public Integer getNro_gr_per() throws BaseException { 
    supportRefresh();
    return nro_gr_per;
  }

  public void setNro_gr_per(Integer aNro_gr_per) { 
    this.nro_gr_per =  aNro_gr_per;
  }

  public String getNickName() { 
    return NICKNAME; 
  } 

 public static TablaPercIBBsAs findByOid(Integer oid , ISesion aSesion) throws BaseException { 
   return (TablaPercIBBsAs) getObjectByOid(NICKNAME,oid,aSesion);
  } 

 public static TablaPercIBBsAs findByCodigo(String codigo , ISesion aSesion) throws BaseException { 
   return (TablaPercIBBsAs) getObjectByCodigo(NICKNAME,codigo,aSesion);
  } 

 public void beforeSave() throws BaseException {
	 
	 Validar.noNulo(this.fec_public, "Debe ingresar la Fecha de Publicación");
	 Validar.noNulo(this.fec_vig_desde, "Debe ingresar la Fecha de Vigencia Desde");
	 Validar.noNulo(this.fec_vig_hasta, "Debe ingresar la Fecha de Vigencia Hasta");
	 
 }
 
 public static TablaPercIBBsAs getTablaPercIBBsAs(String cuit,java.util.Date fecha,
     ISesion aSesion)
     throws BaseException {
 	return DBTablaPercIBBsAs.getTablePercIBBsAs(cuit,fecha,aSesion);
 }
 
 public static TablaPercIBBsAs getRegistroPorCUITyFecPub(String cuit,java.util.Date fecha,
         ISesion aSesion)
         throws BaseException {
	  return DBTablaPercIBBsAs.getRegistroPorCUITyFecPub(cuit,fecha,aSesion);
 }
 
 public static List getConsultaMasiva(String cuit,
		  java.util.Date fecVigDesde,
		  java.util.Date fecVigHasta,
		  ISesion aSesion) throws BaseException {
	  
	  return DBTablaPercIBBsAs.getConsultaMasiva(cuit,fecVigDesde,fecVigHasta,aSesion);
 } 
  
 

}
