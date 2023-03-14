package com.srn.erp.bienUso.bm;

import java.util.List;

import com.srn.erp.bienUso.da.DBComposicionValorOrigen;
import com.srn.erp.contabilidad.bm.ComproContaDet;
import com.srn.erp.general.bm.ComproCab;
import com.srn.erp.general.bm.Moneda;
import com.srn.erp.general.bm.Periodo;
import com.srn.erp.general.bm.Talonario;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bm.Parametros.ValorParametro;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class ComposicionValorOrigen extends ObjetoLogico { 

  ComproBienUsoCab comproBienUsoCab = null; 	
	
   public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}
   
    public static Talonario getTalonarioAltaValorOrigen(ISesion aSesion) throws BaseException {
      ValorParametro valorParametro = ValorParametro.findByCodigoParametro("TALONARIO_ALTA_VO_BIEN_USO",aSesion);
      Talonario talonario = Talonario.findByOid(valorParametro.getOidObjNeg(),aSesion);
      return talonario;
    }
    
    public ComproCab getComprobanteVO() throws BaseException {
    	return comproBienUsoCab;
    }

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public Boolean isActivo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

  public ComposicionValorOrigen() { 
  }

  public static String NICKNAME = "bu.ComposicionValorOrigen";

  private ComproContaDet compro_conta_det;
  private SubBienVidaUtil subbienVidaUtil;
  private Double porcentaje;
  private Double impo_valor;
  private Moneda moneda;
  private java.util.Date fecImputac;

  public ComproContaDet getCompro_conta_det() throws BaseException { 
    supportRefresh();
    return compro_conta_det;
  }

  public void setCompro_conta_det(ComproContaDet aCompro_conta_det) { 
    this.compro_conta_det =  aCompro_conta_det;
  }

  public java.util.Date getFecImputac() throws BaseException { 
	supportRefresh();
	return fecImputac;
  }

  public void setFecImputac(java.util.Date aFecImputac) { 
	this.fecImputac =  aFecImputac;
  }
  
  public SubBienVidaUtil getSubbienVidaUtil() throws BaseException { 
    supportRefresh();
    return subbienVidaUtil;
  }

  public void setSubbienVidaUtil(SubBienVidaUtil aSubbienVidaUtil) { 
    this.subbienVidaUtil =  aSubbienVidaUtil;
  }

  public Double getPorcentaje() throws BaseException { 
    supportRefresh();
    return porcentaje;
  }

  public void setPorcentaje(Double aPorcentaje) { 
    this.porcentaje =  aPorcentaje;
  }

  public Double getImpo_valor() throws BaseException { 
    supportRefresh();
    return impo_valor;
  }

  public void setImpo_valor(Double aImpo_valor) { 
    this.impo_valor =  aImpo_valor;
  }

  public Moneda getMoneda() throws BaseException { 
    supportRefresh();
    return moneda;
  }

  public void setMoneda(Moneda aMoneda) { 
    this.moneda =  aMoneda;
  }

  public String getNickName() { 
    return NICKNAME; 
  } 

 public static ComposicionValorOrigen findByOid(Integer oid , ISesion aSesion) throws BaseException { 
   return (ComposicionValorOrigen) getObjectByOid(NICKNAME,oid,aSesion);
  } 

 public static ComposicionValorOrigen findByCodigo(String codigo , ISesion aSesion) throws BaseException { 
   return (ComposicionValorOrigen) getObjectByCodigo(NICKNAME,codigo,aSesion);
  } 

 public void beforeSave() throws BaseException { 
    Validar.noNulo(compro_conta_det, "Debe ingresar un Comprobante Contable Detalle");
    Validar.noNulo(subbienVidaUtil, "Debe ingresar el SubBien");
    Validar.noNulo(porcentaje, "Debe ingresar el Porcentaje");
    Validar.noNulo(impo_valor, "Debe ingresar el Importe Valor Origen");
    Validar.noNulo(moneda, "Debe ingresar la Moneda");
    Validar.noNulo(fecImputac,"Debe ingresar la fecha de Imputación");
 }
 
 public static List getValoresOrigen(SubBienVidaUtil subBienVidaUtil,
         ISesion aSesion) throws BaseException {
	return DBComposicionValorOrigen.getValoresOrigen(subBienVidaUtil,aSesion);
 } 
 
 public void afterSave() throws BaseException {
	 
  comproBienUsoCab = (ComproBienUsoCab)ComproBienUsoCab.getNew(ComproBienUsoCab.NICKNAME,getSesion());
  
  Talonario talonario = getTalonarioAltaValorOrigen(getSesion());
  // Set datos del comrobante
  comproBienUsoCab.setContabiliza(true);
  comproBienUsoCab.setTalonario(talonario);
  comproBienUsoCab.setTipoCompro(talonario.getTipo_comprobante());
  comproBienUsoCab.setLetra(talonario.getLetra());
  comproBienUsoCab.setLugarEmision(talonario.getLugar_emision());
  comproBienUsoCab.setEmision(fecImputac);
  comproBienUsoCab.setComentario("");
  comproBienUsoCab.setSub_bien(getSubbienVidaUtil().getSubbien());
  comproBienUsoCab.setTipo_mov(MovimientoBienUso.getTipoMovValorOrigen());
  comproBienUsoCab.setPeriodo(Periodo.getPeriodoByFechaDelEjercicio(fecImputac,getSesion()));
  comproBienUsoCab.setSistema_valuacion(getSubbienVidaUtil().getSistema_valuacion());
  comproBienUsoCab.setImputac(getFecImputac());
	  
  ComproBienUsoDet compoBienUsoDet = (ComproBienUsoDet)ComproBienUsoDet.getNew(ComproBienUsoDet.NICKNAME,getSesion());
  compoBienUsoDet.setCompro_bien_uso_cab(comproBienUsoCab);
  compoBienUsoDet.setCompro_conta_det(getCompro_conta_det());
  compoBienUsoDet.setPorc(getPorcentaje());
  compoBienUsoDet.setMeses_amort(new Integer(0));
  compoBienUsoDet.setTasa_amort(new Double(0));
  compoBienUsoDet.setImporte(getImpo_valor());
  comproBienUsoCab.addDetComproBienUsoDet(compoBienUsoDet);
  comproBienUsoCab.save();
	  
 } 
 

}
