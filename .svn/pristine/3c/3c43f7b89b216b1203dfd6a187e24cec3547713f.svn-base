package com.srn.erp.ctasAPagar.bm;

import java.util.Date;

import com.srn.erp.contabilidad.bm.IContabilizable;
import com.srn.erp.contabilidad.bm.RenglonesAsiento;
import com.srn.erp.general.bm.ComproCab;
import com.srn.erp.general.bm.Talonario;

import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.Fecha;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;
import framework.request.bl.Utils.Validar;

public class AnuladorComproProvAplic  extends ComproCab implements
	IContabilizable { 

  public AnuladorComproProvAplic() { 
  }

  public String getCodigo() throws BaseException {
	// TODO Auto-generated method stub
	return null;
}

public String getDescripcion() throws BaseException {
	// TODO Auto-generated method stub
	return null;
}

 public static String NICKNAME = "cap.AnuladorComproProvAplic";

  private AplicacionComproProv compro_apl_prov;

  public AplicacionComproProv getCompro_apl_prov() throws BaseException { 
    supportRefresh();
    return compro_apl_prov;
  }

  public void setCompro_apl_prov(AplicacionComproProv aCompro_apl_prov) { 
    this.compro_apl_prov =  aCompro_apl_prov;
  }

  public String getNickName() { 
    return NICKNAME; 
  } 

 public static AnuladorComproProvAplic findByOid(Integer oid , ISesion aSesion) throws BaseException { 
   return (AnuladorComproProvAplic) getObjectByOid(NICKNAME,oid,aSesion);
  } 

 public static AnuladorComproProvAplic findByCodigo(String codigo , ISesion aSesion) throws BaseException { 
   return (AnuladorComproProvAplic) getObjectByCodigo(NICKNAME,codigo,aSesion);
  } 

	public void beforeSave() throws BaseException {

	    Validar.noNulo(compro_apl_prov, "Debe ingresar la Aplicación");

		beforeSaveComprobante(this);
		if (this.isNew()) {
			this.setEstado(ComproCab.ESTADO_ALTA);
		}

	}
	
	public ComproCab getComprobante() throws BaseException {
		// TODO Auto-generated method stub
		return this;
	}

	public Date getImputacion() throws BaseException {
		// TODO Auto-generated method stub
		return getImputac();
	}

	public RenglonesAsiento getRenglonesAsiento() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public void afterSave() throws BaseException {

		afterSaveComprobante(this);

		anularComprobante(this.getCompro_apl_prov());

	}
	
	public void generarComproAnulacion() throws BaseException {
		// Set datos del comrobante
		setContabiliza(true);
		Talonario talonarioAnulacion = this.getCompro_apl_prov().getTalonario().getTalonarioAnulacion();
		if (talonarioAnulacion == null)
			throw new ExceptionValidation(null, "No existe talonario de anulación para el talonario "
					+ this.getCompro_apl_prov().getTalonario().getDescripcion());
		setTalonario(talonarioAnulacion);
		setTipoCompro(talonarioAnulacion.getTipo_comprobante());
		setLetra(talonarioAnulacion.getLetra());
		setLugarEmision(talonarioAnulacion.getLugar_emision());
		setNroext(new Integer(0));
		setEmision(Fecha.getFechaActual());
		setImputac(Fecha.getFechaActual());
		setComentario("Anulación Aplicación " + this.getCompro_apl_prov().getCodigo());
		setActivo(new Boolean(true));

	}
	
	protected void beforeSaveNew() throws BaseException {

		// TODO Auto-generated method stub
		super.beforeSaveNew();
		
		DesAplicarCtaCteProv desAplicarCtaCteProv =
			new DesAplicarCtaCteProv(this.getSesion());
		desAplicarCtaCteProv.desaplicar(this.getCompro_apl_prov());
		
		
	}

	
	


 

}
