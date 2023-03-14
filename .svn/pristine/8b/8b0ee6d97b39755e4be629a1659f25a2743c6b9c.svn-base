package com.srn.erp.ctasAPagar.op;

import com.srn.erp.compras.bm.Proveedor;
import com.srn.erp.ctasAPagar.bm.ComproProveedorBase;
import com.srn.erp.general.bm.TipoComprobante;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;
import framework.request.bl.Utils.MapDatos;

public class ValidarComproProvUnico extends Operation {

  public ValidarComproProvUnico() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
	  
	TipoComprobante tc = TipoComprobante.findByOidProxy(mapaDatos.getInteger("oid_tc"), this.getSesion());
	String letra = mapaDatos.getString("letra");
	Integer lug_emi = mapaDatos.getInteger("lug_emi");
	Integer nroExt = mapaDatos.getInteger("nro_ext");
	Proveedor proveedor = Proveedor.findByOidProxy(mapaDatos.getInteger("oid_proveedor"), this.getSesion());
	ComproProveedorBase comproProv = 
		ComproProveedorBase.getComproProveedor(tc, letra, lug_emi, nroExt, proveedor, this.getSesion());
	
	if (comproProv!=null)
		throw new ExceptionValidation(null,"Comprobante de Proveedor "+comproProv.getCodigo()+" ya ingresado ");
	
	
  }


}
