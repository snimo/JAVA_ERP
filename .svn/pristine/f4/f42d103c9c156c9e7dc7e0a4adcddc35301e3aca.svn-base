package com.srn.erp.proveedoresMaterials.bl.Factory;

import framework.applicarionServer.bl.ObjetosAplicacion.*;
import framework.applicarionServer.bl.Persistencia.*;
import framework.request.bl.Utils.*;
import com.srn.erp.proveedoresMaterials.bm.ProveedorMaterialsControl;
import com.srn.erp.proveedoresMaterials.da.DBProveedorMaterialControl;

public class FactoryProveedorMaterialControl extends FactoryObjetoLogico {

	public FactoryProveedorMaterialControl() {
	}

	public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
		ProveedorMaterialsControl proveedoresute = (ProveedorMaterialsControl) objLog;
		proveedoresute.setOID(db.getInteger(DBProveedorMaterialControl.OID_PROVEEDOR_UTE));
		proveedoresute.setCuit(db.getString(DBProveedorMaterialControl.CUIT));
		proveedoresute.setCuit2(db.getString(DBProveedorMaterialControl.CUIT2));
		proveedoresute.setRazonsocial(db.getString(DBProveedorMaterialControl.RAZON_SOCIAL));
		proveedoresute.setRazonSocial2(db.getString(DBProveedorMaterialControl.RAZON_SOCIAL2));
		proveedoresute.setDireccion(db.getString(DBProveedorMaterialControl.DIRECCION));
		proveedoresute.setContacto(db.getString(DBProveedorMaterialControl.CONTACTO));
		proveedoresute.setComercail(db.getString(DBProveedorMaterialControl.COMERCIAL));
		proveedoresute.setTelefono(db.getString(DBProveedorMaterialControl.TELEFONO));
		proveedoresute.setEmail(db.getString(DBProveedorMaterialControl.EMAIL));
		proveedoresute.setGrupoproveedor(db.getInteger(DBProveedorMaterialControl.GRUPO_PROVEEDOR));
		proveedoresute.setCondicionpago(db.getString(DBProveedorMaterialControl.CONDICION_PAGO));
		proveedoresute.setActivo(db.getString(DBProveedorMaterialControl.ACTIVO));

	}
}
