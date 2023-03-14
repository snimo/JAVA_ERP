package com.srn.erp.pagos.bm;

import java.util.List;

import com.srn.erp.ctasAPagar.bm.ComproProveedorBase;
import com.srn.erp.pagos.da.DBAnuladorRendFFComproProv;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class AnuladorRendFFComproProv extends ObjetoLogico { 

	
  public void afterSaveNew() throws BaseException {
		// TODO Auto-generated method stub
		super.afterSaveNew();
		
		ComproProveedorBase comproProv = 
			this.getRendicion_ff_det().getComprobante_proveedor();
		// Refrescar para que despues se pueda hacer el delete
		comproProv.supportRefresh();
		comproProv.delete();
		comproProv.save();
		
		
	}

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public Boolean isActivo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public AnuladorRendFFComproProv() { 
  }

  public static String NICKNAME = "pag.AnuladorRendFFComproProv";

  private AnuladorRendFF anulador_rend_ff;
  private RendicionFondoFijoCompro rendicion_ff_det;

  public AnuladorRendFF getAnulador_rend_ff() throws BaseException { 
    supportRefresh();
    return anulador_rend_ff;
  }

  public void setAnulador_rend_ff(AnuladorRendFF aAnulador_rend_ff) { 
    this.anulador_rend_ff =  aAnulador_rend_ff;
  }

  public RendicionFondoFijoCompro getRendicion_ff_det() throws BaseException { 
    supportRefresh();
    return rendicion_ff_det;
  }

  public void setRendicion_ff_det(RendicionFondoFijoCompro aRendicion_ff_det) { 
    this.rendicion_ff_det =  aRendicion_ff_det;
  }

  public String getNickName() { 
    return NICKNAME; 
  } 

 public static AnuladorRendFFComproProv findByOid(Integer oid , ISesion aSesion) throws BaseException { 
   return (AnuladorRendFFComproProv) getObjectByOid(NICKNAME,oid,aSesion);
  } 

 public static AnuladorRendFFComproProv findByCodigo(String codigo , ISesion aSesion) throws BaseException { 
   return (AnuladorRendFFComproProv) getObjectByCodigo(NICKNAME,codigo,aSesion);
  } 

 public void beforeSave() throws BaseException { 
    Validar.noNulo(anulador_rend_ff, "Debe ingresar el Comprobanre de A. Rend. de Fondo");
    Validar.noNulo(rendicion_ff_det, "Debe ingresar el Comprobante Proveedor");
 }
 
 public static List getComproProvAnulados(AnuladorRendFF anuladorRendFF,
     ISesion aSesion) throws BaseException {
 	return DBAnuladorRendFFComproProv.getComproProvAnulados(anuladorRendFF,aSesion);
 }
 
 
 

}
