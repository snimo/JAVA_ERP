package com.srn.erp.bienUso.bm;

import java.util.List;

import com.srn.erp.bienUso.da.DBComproBienUsoDet;
import com.srn.erp.contabilidad.bm.ComproContaDet;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bm.Varios.Money;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class ComproBienUsoDet extends ObjetoLogico { 

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

public ComproBienUsoDet() { 
  }

  public static String NICKNAME = "bu.ComproBienUsoDet";

  private ComproBienUsoCab compro_bien_uso_cab;
  private Double porc;
  private Integer meses_amort;
  private Double tasa_amort;
  private ComproContaDet compro_conta_det;
  private Double importe;
  private boolean altaMovimiento = false;

  public ComproBienUsoCab getCompro_bien_uso_cab() throws BaseException { 
    supportRefresh();
    return compro_bien_uso_cab;
  }

  public void setCompro_bien_uso_cab(ComproBienUsoCab aCompro_bien_uso_cab) { 
    this.compro_bien_uso_cab =  aCompro_bien_uso_cab;
  }

  public Double getPorc() throws BaseException { 
    supportRefresh();
    return porc;
  }

  public void setPorc(Double aPorc) { 
    this.porc =  aPorc;
  }

  public Integer getMeses_amort() throws BaseException { 
    supportRefresh();
    return meses_amort;
  }

  public void setMeses_amort(Integer aMeses_amort) { 
    this.meses_amort =  aMeses_amort;
  }

  public Double getTasa_amort() throws BaseException { 
    supportRefresh();
    return tasa_amort;
  }

  public void setTasa_amort(Double aTasa_amort) { 
    this.tasa_amort =  aTasa_amort;
  }

  public ComproContaDet getCompro_conta_det() throws BaseException { 
    supportRefresh();
    return compro_conta_det;
  }

  public void setCompro_conta_det(ComproContaDet aCompro_conta_det) { 
    this.compro_conta_det =  aCompro_conta_det;
  }

  public Double getImporte() throws BaseException { 
    supportRefresh();
    return importe;
  }

  public void setImporte(Double aImporte) { 
    this.importe =  aImporte;
  }

  public String getNickName() { 
    return NICKNAME; 
  } 

 public static ComproBienUsoDet findByOid(Integer oid , ISesion aSesion) throws BaseException { 
   return (ComproBienUsoDet) getObjectByOid(NICKNAME,oid,aSesion);
  } 
 
  public static ComproBienUsoDet findByOidProxy(Integer oid , ISesion aSesion) throws BaseException { 
	return (ComproBienUsoDet) getObjectByOidProxy(NICKNAME,oid,aSesion);
 }
 
 public static ComproBienUsoDet findByCodigo(String codigo , ISesion aSesion) throws BaseException { 
   return (ComproBienUsoDet) getObjectByCodigo(NICKNAME,codigo,aSesion);
  } 

 public void beforeSave() throws BaseException { 
    Validar.noNulo(compro_bien_uso_cab, "Debe ingresar el Comrpobante Bien Uso");
    Validar.noNulo(porc, "Debe ingresar el Porcentaje");
    Validar.noNulo(meses_amort, "Debe ingresar la cant. de Meses Amort.");
    Validar.noNulo(tasa_amort, "Debe ingresar la tasa de Amort.");
    Validar.noNulo(importe, "Debe ingresar el Importe");
    if (isNew())
    	altaMovimiento = true;
    else
    	altaMovimiento = false;
    	
 }
 
 public static List getDetalles(ComproBienUsoCab comproBienUsoCab,
         ISesion aSesion) throws BaseException {
	  return DBComproBienUsoDet.getDetalles(comproBienUsoCab,aSesion);
 }
 
 public void afterSave() throws BaseException {
	 
	 if (altaMovimiento) {
		 MovimientoBienUso movBienUso = (MovimientoBienUso)MovimientoBienUso.getNew(MovimientoBienUso.NICKNAME,getSesion());
		 movBienUso.setSub_bien(getCompro_bien_uso_cab().getSub_bien());
		 movBienUso.setFec_imputac(getCompro_bien_uso_cab().getImputac());
		 movBienUso.setTipo_mov(getCompro_bien_uso_cab().getTipo_mov());
		 movBienUso.setPeriodo(getCompro_bien_uso_cab().getPeriodo());
		 movBienUso.setCompro_conta_det(getCompro_conta_det());
		 movBienUso.setSistemaValuacion(getCompro_bien_uso_cab().getSistema_valuacion());
		 movBienUso.setMesesAmortizados(getMeses_amort());
		 movBienUso.setTasaAmortizacion(new Money(getTasa_amort().doubleValue()));
		 movBienUso.setImporte(new Money(getImporte().doubleValue()));
		 movBienUso.setComproBienUsoDet(this);
		 movBienUso.setSigno(MovimientoBienUso.getSigno(getCompro_bien_uso_cab().getTipo_mov()));
		 movBienUso.save();
	 }
	 
	   
 } 
 
 
 

}
