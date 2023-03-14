package com.srn.erp.ventas.bm;

import com.srn.erp.ventas.da.DBFactElectronicaCab;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.applicarionServer.bm.Varios.Money;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.Validar;

public class FactElectronicaCab extends ObjetoLogico { 

  @Override
	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean isActivo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

public FactElectronicaCab() { 
  }

  public static String NICKNAME = "ve.FactElectronicaCab";

  private Integer oid_tc;
  private String tc_ext;
  private String letra;
  private Integer nro_ext;
  private Integer lug_emi;
  private java.util.Date fec_homologada;
  private String usu_homologo;
  private Boolean homologado_ok;
  private Integer oid_cco_asignado_a;
  private String cae;
  private java.util.Date vto_cae;
  private String respuesta_ws_homo;
  private String cuit_empresa;
  private Integer tc_fe;
  private Integer tipo_docu_fe;
  private String nro_docu_fe;
  private java.util.Date fec_fe;
  private Money imp_total_fe;
  private Money imp_neto_fe;
  private Money imp_iva_fe;

  public Integer getOid_tc() throws BaseException { 
    supportRefresh();
    return oid_tc;
  }

  public void setOid_tc(Integer aOid_tc) { 
    this.oid_tc =  aOid_tc;
  }

  public String getTc_ext() throws BaseException { 
    supportRefresh();
    return tc_ext;
  }

  public void setTc_ext(String aTc_ext) { 
    this.tc_ext =  aTc_ext;
  }

  public String getLetra() throws BaseException { 
    supportRefresh();
    return letra;
  }

  public void setLetra(String aLetra) { 
    this.letra =  aLetra;
  }

  public Integer getNro_ext() throws BaseException { 
    supportRefresh();
    return nro_ext;
  }

  public void setNro_ext(Integer aNro_ext) { 
    this.nro_ext =  aNro_ext;
  }

  public Integer getLug_emi() throws BaseException { 
    supportRefresh();
    return lug_emi;
  }

  public void setLug_emi(Integer aLug_emi) { 
    this.lug_emi =  aLug_emi;
  }

  public java.util.Date getFec_homologada() throws BaseException { 
    supportRefresh();
    return fec_homologada;
  }

  public void setFec_homologada(java.util.Date aFec_homologada) { 
    this.fec_homologada =  aFec_homologada;
  }

  public String getUsu_homologo() throws BaseException { 
    supportRefresh();
    return usu_homologo;
  }

  public void setUsu_homologo(String aUsu_homologo) { 
    this.usu_homologo =  aUsu_homologo;
  }

  public Boolean isHomologado_ok() throws BaseException { 
    supportRefresh();
    return homologado_ok;
  }

  public void setHomologado_ok(Boolean aHomologado_ok) { 
    this.homologado_ok =  aHomologado_ok;
  }

  public Integer getOid_cco_asignado_a() throws BaseException { 
    supportRefresh();
    return oid_cco_asignado_a;
  }

  public void setOid_cco_asignado_a(Integer aOid_cco_asignado_a) { 
    this.oid_cco_asignado_a =  aOid_cco_asignado_a;
  }

  public String getCae() throws BaseException { 
    supportRefresh();
    return cae;
  }

  public void setCae(String aCae) { 
    this.cae =  aCae;
  }

  public java.util.Date getVto_cae() throws BaseException { 
    supportRefresh();
    return vto_cae;
  }

  public void setVto_cae(java.util.Date aVto_cae) { 
    this.vto_cae =  aVto_cae;
  }

  public String getRespuesta_ws_homo() throws BaseException { 
    supportRefresh();
    return respuesta_ws_homo;
  }

  public void setRespuesta_ws_homo(String aRespuesta_ws_homo) { 
    this.respuesta_ws_homo =  aRespuesta_ws_homo;
  }

  public String getCuit_empresa() throws BaseException { 
    supportRefresh();
    return cuit_empresa;
  }

  public void setCuit_empresa(String aCuit_empresa) { 
    this.cuit_empresa =  aCuit_empresa;
  }

  public Integer getTc_fe() throws BaseException { 
    supportRefresh();
    return tc_fe;
  }

  public void setTc_fe(Integer aTc_fe) { 
    this.tc_fe =  aTc_fe;
  }

  public Integer getTipo_docu_fe() throws BaseException { 
    supportRefresh();
    return tipo_docu_fe;
  }

  public void setTipo_docu_fe(Integer aTipo_docu_fe) { 
    this.tipo_docu_fe =  aTipo_docu_fe;
  }

  public String getNro_docu_fe() throws BaseException { 
    supportRefresh();
    return nro_docu_fe;
  }

  public void setNro_docu_fe(String aNro_docu_fe) { 
    this.nro_docu_fe =  aNro_docu_fe;
  }

  public java.util.Date getFec_fe() throws BaseException { 
    supportRefresh();
    return fec_fe;
  }

  public void setFec_fe(java.util.Date aFec_fe) { 
    this.fec_fe =  aFec_fe;
  }

  public Money getImp_total_fe() throws BaseException { 
    supportRefresh();
    return imp_total_fe;
  }

  public void setImp_total_fe(Money aImp_total_fe) { 
    this.imp_total_fe =  aImp_total_fe;
  }

  public Money getImp_neto_fe() throws BaseException { 
    supportRefresh();
    return imp_neto_fe;
  }

  public void setImp_neto_fe(Money aImp_neto_fe) { 
    this.imp_neto_fe =  aImp_neto_fe;
  }

  public Money getImp_iva_fe() throws BaseException { 
    supportRefresh();
    return imp_iva_fe;
  }

  public void setImp_iva_fe(Money aImp_iva_fe) { 
    this.imp_iva_fe =  aImp_iva_fe;
  }

  public String getNickName() { 
    return NICKNAME; 
  } 

 public static FactElectronicaCab findByOid(Integer oid , ISesion aSesion) throws BaseException { 
   return (FactElectronicaCab) getObjectByOid(NICKNAME,oid,aSesion);
  } 

 public static FactElectronicaCab findByCodigo(String codigo , ISesion aSesion) throws BaseException { 
   return (FactElectronicaCab) getObjectByCodigo(NICKNAME,codigo,aSesion);
  } 
 
 public static void actualizarFactElectronica(
			Integer oidCCO,
			Integer oidCCOAsig,
			ISesion aSesion) throws BaseException {

	    DBFactElectronicaCab.actualizarFactElectronica(oidCCO, oidCCOAsig, aSesion);
	 
 }


 public void beforeSave() throws BaseException { 
	 
	  Validar.noNulo(tc_ext,"Debe seleccionar el tipo de comprobante");
	  Validar.noNulo(letra,"Debe seleccionar la letra");
	  Validar.noNulo(nro_ext,"Debe seleccionar el nro. de comprobante");
	  Validar.noNulo(lug_emi,"Debe ingresar el lugar de emisiòn");
	  Validar.noNulo(fec_homologada,"Debe ingresar la fecha homologada");
	  Validar.noNulo(usu_homologo,"Debe ingresar el usuario");
	  Validar.noNulo(homologado_ok,"Debe ingresar si se homologo o no");
	  Validar.noNulo(cuit_empresa,"Debe seleccionar el CUIT Empresa");
	  Validar.noNulo(tc_fe,"Debe seleccionar el tipo de comprobante");
	  Validar.noNulo(tipo_docu_fe,"Debe seleccionar el tipo de documento");
	  Validar.noNulo(nro_docu_fe,"Debe seleccionar el numero de documento");
	 
 }

}
