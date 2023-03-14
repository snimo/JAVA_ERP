package com.srn.erp.proveedoresMaterials.op;

import java.util.Hashtable;
import java.util.List;

import com.srn.erp.proveedoresMaterials.bm.GrupoProveedor;
import com.srn.erp.proveedoresMaterials.bm.ProveedorMaterialsControl;

import framework.applicarionServer.bl.Utils.Util;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerProveedorMaterialControl extends Operation {

	public TraerProveedorMaterialControl() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		if (mapaDatos.containsKey("cuit")) {
			Hashtable<String, ProveedorMaterialsControl> hashProveedor = new Hashtable<String, ProveedorMaterialsControl>();
			String cuit = mapaDatos.getString("cuit");
			String empresa = mapaDatos.getString("cuit_empresa");
			List<ProveedorMaterialsControl> ute = ProveedorMaterialsControl.findByCuitUte(cuit, getSesion());
			List<ProveedorMaterialsControl> binbaires = ProveedorMaterialsControl.findByCuitBinbaires(cuit, getSesion());
			List<ProveedorMaterialsControl> alavera = ProveedorMaterialsControl.findByCuitAlavera(cuit, getSesion());
			List<ProveedorMaterialsControl> magic = ProveedorMaterialsControl.findByCuitMagic(cuit, getSesion());

			if (!ute.isEmpty()) {
				hashProveedor.put("UTE", ute.get(0));
			}
			if (!binbaires.isEmpty()) {
				hashProveedor.put("BINBAIRES", binbaires.get(0));
			}
			if (!alavera.isEmpty()) {
				hashProveedor.put("ALAVERA", alavera.get(0));
			}
			if (!magic.isEmpty()) {
				hashProveedor.put("MAGIC", magic.get(0));
			}

			IDataSet datasetProveedores = getDataSetProveedores();
			if (hashProveedor != null) {
				cargarDataset(datasetProveedores, hashProveedor, empresa);
			}
			writeCliente(datasetProveedores);
		}

	}

	private IDataSet getDataSetProveedores() {
		IDataSet dataset = new TDataSet();
		dataset.create("TProveedor");
		dataset.fieldDef(new Field("oid_proveedor", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cuit", Field.STRING, 60));
		dataset.fieldDef(new Field("razon_social", Field.STRING, 60));
		dataset.fieldDef(new Field("direccion", Field.STRING, 1000));
		dataset.fieldDef(new Field("contacto", Field.STRING, 60));
		dataset.fieldDef(new Field("comercial", Field.STRING, 60));
		dataset.fieldDef(new Field("telefono", Field.STRING, 30));
		dataset.fieldDef(new Field("email", Field.STRING, 254));
		dataset.fieldDef(new Field("id_grupo_proveedor", Field.INTEGER, 0));
		dataset.fieldDef(new Field("nombre_grupo", Field.STRING, 200));
		dataset.fieldDef(new Field("condicion_de_pago", Field.STRING, 60));
		dataset.fieldDef(new Field("activo_ute", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("activo_alavera", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("activo_binbaires", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("activo_magic", Field.BOOLEAN, 0));
		return dataset;
	}

	private void cargarDataset(IDataSet dataset, Hashtable<String, ProveedorMaterialsControl> hashProveedores, String empresa) throws BaseException {
		ProveedorMaterialsControl proveedor = hashProveedores.get(empresa);
		if (proveedor != null) {
			dataset.append();
			dataset.fieldValue("oid_proveedor", proveedor.getOID());
			dataset.fieldValue("cuit", proveedor.getCuit());
			dataset.fieldValue("razon_social", proveedor.getRazonsocial());
			if (proveedor.getDireccion() != null) {
				dataset.fieldValue("direccion", Util.convertTextHTMLToDelphi(proveedor.getDireccion()));
			} else {
				dataset.fieldValue("direccion", "");
			}
			if (proveedor.getContacto() != null) {
				dataset.fieldValue("contacto", proveedor.getContacto());
			} else {
				dataset.fieldValue("contacto", "");
			}
			if (proveedor.getComercail() != null) {
				dataset.fieldValue("comercial", proveedor.getComercail());
			} else {
				dataset.fieldValue("comercial", "");
			}
			if (proveedor.getTelefono() != null) {
				dataset.fieldValue("telefono", proveedor.getTelefono());
			} else {
				dataset.fieldValue("telefono", "");
			}
			if (proveedor.getEmail() != null) {
				dataset.fieldValue("email", proveedor.getEmail());
			} else {
				dataset.fieldValue("email", "");
			}

			GrupoProveedor grupo = GrupoProveedor.findByOidBase(empresa, proveedor.getGrupoproveedor(), getSesion());

			if (grupo != null) {
				dataset.fieldValue("id_grupo_proveedor", grupo.getOID());
				dataset.fieldValue("nombre_grupo", proveedor.getDescripcion());
			} else {
				dataset.fieldValue("id_grupo_proveedor", "");
				dataset.fieldValue("nombre_grupo", "");
			}
			if (proveedor.getCondicionpago() != null) {
				dataset.fieldValue("condicion_de_pago", proveedor.getCondicionpago());
			} else {
				dataset.fieldValue("condicion_de_pago", "");
			}
			if (hashProveedores.get("UTE") != null) {
				if (hashProveedores.get("UTE").getActivo().equals("S")) {
					dataset.fieldValue("activo_ute", false);
				} else {
					dataset.fieldValue("activo_ute", true);
				}
			} else {
				dataset.fieldValue("activo_ute", false);
			}
			if (hashProveedores.get("ALAVERA") != null) {
				if (hashProveedores.get("ALAVERA").getActivo().equals("S")) {
					dataset.fieldValue("activo_alavera", false);
				} else {
					dataset.fieldValue("activo_alavera", true);
				}
			} else {
				dataset.fieldValue("activo_alavera", false);
			}
			if (hashProveedores.get("BINBAIRES") != null) {
				if (hashProveedores.get("BINBAIRES").getActivo().equals("S")) {
					dataset.fieldValue("activo_binbaires", false);
				} else {
					dataset.fieldValue("activo_binbaires", true);
				}
			} else {
				dataset.fieldValue("activo_binbaires", false);
			}
			if (hashProveedores.get("MAGIC") != null) {
				if (hashProveedores.get("MAGIC").getActivo().equals("S")) {
					dataset.fieldValue("activo_magic", false);
				} else {
					dataset.fieldValue("activo_magic", true);
				}
			} else {
				dataset.fieldValue("activo_magic", false);
			}
		}
	}
}
