package com.srn.erp.proveedoresMaterials.op;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.srn.erp.proveedoresMaterials.bm.GrupoProveedor;
import com.srn.erp.proveedoresMaterials.bm.ProveedorMaterialsControl;

import framework.applicarionServer.bl.Utils.Util;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerProveedorMatContByFiltros extends Operation {

	private int oidKeyUnico = 1;
	
	public TraerProveedorMatContByFiltros() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		List<ProveedorMaterialsControl> proveedoresUte = new ArrayList<ProveedorMaterialsControl>();
		List<ProveedorMaterialsControl> proveedoresBinbaires = new ArrayList<ProveedorMaterialsControl>();
		List<ProveedorMaterialsControl> proveedoresAlavera = new ArrayList<ProveedorMaterialsControl>();
		List<ProveedorMaterialsControl> proveedoresMagic = new ArrayList<ProveedorMaterialsControl>();
		String cuits = "";
		Hashtable<String, Hashtable> hashProveedores = new Hashtable<String, Hashtable>();
		if (!mapaDatos.getString("cuit").isEmpty()) {
			cuits = mapaDatos.getString("cuit");
			if (cuits.length()<=5)
				throw new ExceptionValidation(null,"Se ingreso un número de CUIT incompleto.");
		} else if (!mapaDatos.getString("razon_social").isEmpty()) {
			String razonSocial = mapaDatos.getString("razon_social");
			if (razonSocial.length()<3)
				throw new ExceptionValidation(null,"Para buscar por razón social debe ingresar mínimamente 3 caracteres");			
			List<ProveedorMaterialsControl> proveedores = new ArrayList<ProveedorMaterialsControl>();
			proveedores.addAll(ProveedorMaterialsControl.findByRazonSocialUte(razonSocial, getSesion()));
			proveedores.addAll(ProveedorMaterialsControl.findByRazonSocialBinbaires(razonSocial, getSesion()));
			proveedores.addAll(ProveedorMaterialsControl.findByRazonSocialAlavera(razonSocial, getSesion()));
			proveedores.addAll(ProveedorMaterialsControl.findByRazonSocialMagic(razonSocial, getSesion()));
			cuits = cargarCuits(proveedores);
		} else {
			throw new ExceptionValidation(null, "Es nesesario ingresar un Cuit o Razon Social");
		}
		if (!cuits.isEmpty()) {
			List<ProveedorMaterialsControl> ute = ProveedorMaterialsControl.findByCuitUte(cuits, getSesion());
			if (ute != null) {
				proveedoresUte.addAll(ute);
			}
			List<ProveedorMaterialsControl> binbaires = ProveedorMaterialsControl.findByCuitBinbaires(cuits, getSesion());
			if (binbaires != null) {
				proveedoresBinbaires.addAll(binbaires);
			}
			List<ProveedorMaterialsControl> alavera = ProveedorMaterialsControl.findByCuitAlavera(cuits, getSesion());
			if (alavera != null) {
				proveedoresAlavera.addAll(alavera);
			}
			List<ProveedorMaterialsControl> magic = ProveedorMaterialsControl.findByCuitMagic(cuits, getSesion());
			if (magic != null) {
				proveedoresMagic.addAll(magic);
			}
			cargarHash(proveedoresUte, hashProveedores, "UTE");
			cargarHash(proveedoresBinbaires, hashProveedores, "BINBAIRES");
			cargarHash(proveedoresAlavera, hashProveedores, "ALAVERA");
			cargarHash(proveedoresMagic, hashProveedores, "MAGIC");

		}
		IDataSet datasetProveedores = getDataSetProveedores();
		if (hashProveedores != null) {
			cargarRegistroProveedoresUte(datasetProveedores, hashProveedores);
		}
		writeCliente(datasetProveedores);
	}

	private IDataSet getDataSetProveedores() {
		IDataSet dataset = new TDataSet();
		dataset.create("TProveedoresMaterial");
		dataset.fieldDef(new Field("oid_proveedor", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_padre", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cuit", Field.STRING, 60));
		dataset.fieldDef(new Field("cuit_empresa", Field.STRING, 60));
		dataset.fieldDef(new Field("estado", Field.STRING, 60));
		dataset.fieldDef(new Field("razon_social", Field.STRING, 60));
		dataset.fieldDef(new Field("direccion", Field.STRING, 1000));
		dataset.fieldDef(new Field("contacto", Field.STRING, 60));
		dataset.fieldDef(new Field("comercial", Field.STRING, 60));
		dataset.fieldDef(new Field("telefono", Field.STRING, 30));
		dataset.fieldDef(new Field("email", Field.STRING, 254));
		dataset.fieldDef(new Field("id_grupo_proveedor", Field.INTEGER, 0));
		dataset.fieldDef(new Field("nombre_grupo", Field.STRING, 200));
		dataset.fieldDef(new Field("condicion_de_pago", Field.STRING, 60));
		dataset.fieldDef(new Field("oid_key_unico", Field.INTEGER, 0));
		return dataset;
	}

	private void cargarRegistroProveedoresUte(IDataSet dataset, Hashtable<String, Hashtable> hashProveedores) throws BaseException {
		String bien = "Bien";
		String mal = "Mal";
		Iterator itKeys = hashProveedores.keySet().iterator();
		int idPadre = -1;
		while (itKeys.hasNext()) {
			String key = (String) itKeys.next();
			Hashtable<String, ProveedorMaterialsControl> hasCuit = hashProveedores.get(key);

			dataset.append();
			dataset.fieldValue("oid_proveedor", idPadre);
			dataset.fieldValue("oid_padre", "");
			dataset.fieldValue("cuit", key);
			dataset.fieldValue("cuit_empresa", key);
			dataset.fieldValue("estado", "");
			if (capmosIguales(hasCuit, "razonSocial")) {
				dataset.fieldValue("razon_social", bien);
			} else {
				dataset.fieldValue("razon_social", mal);
			}

			if (capmosIguales(hasCuit, "direccion")) {
				dataset.fieldValue("direccion", bien);
			} else {
				dataset.fieldValue("direccion", mal);
			}

			if (capmosIguales(hasCuit, "contacto")) {
				dataset.fieldValue("contacto", bien);
			} else {
				dataset.fieldValue("contacto", mal);
			}

			if (capmosIguales(hasCuit, "comercail")) {
				dataset.fieldValue("comercial", bien);
			} else {
				dataset.fieldValue("comercial", mal);
			}

			if (capmosIguales(hasCuit, "telefono")) {
				dataset.fieldValue("telefono", bien);
			} else {
				dataset.fieldValue("telefono", mal);
			}

			if (capmosIguales(hasCuit, "email")) {
				dataset.fieldValue("email", bien);
			} else {
				dataset.fieldValue("email", mal);
			}

			// TODO ID GRUPO PROVEEDOR
			dataset.fieldValue("id_grupo_proveedor", "");

			if (capmosIguales(hasCuit, "grupoProveedor")) {
				dataset.fieldValue("nombre_grupo", bien);
			} else {
				dataset.fieldValue("nombre_grupo", mal);
			}

			if (capmosIguales(hasCuit, "condicionPago")) {
				dataset.fieldValue("condicion_de_pago", bien);
			} else {
				dataset.fieldValue("condicion_de_pago", mal);
			}

			dataset.fieldValue("oid_key_unico", idPadre);
			
			Iterator itEmpresa = hasCuit.keySet().iterator();
			while (itEmpresa.hasNext()) {
				String keyCuits = (String) itEmpresa.next();
				if (hasCuit.get(keyCuits) != null) {
					ProveedorMaterialsControl proveedor = hasCuit.get(keyCuits);
					GrupoProveedor GruProv = GrupoProveedor.findByOidBase(keyCuits, proveedor.getGrupoproveedor(), getSesion());
					cargarDatasetHijo(dataset, hasCuit.get(keyCuits), idPadre, keyCuits, GruProv);
				}
			}

			idPadre--;
		}
	}

	private void cargarDatasetHijo(IDataSet dataset, ProveedorMaterialsControl proveedor, Integer idPadre, String empresa, GrupoProveedor GruProv) throws BaseException {
		if (proveedor != null) {
			dataset.append();
			dataset.fieldValue("oid_proveedor", proveedor.getOID());
			dataset.fieldValue("oid_padre", idPadre);
			dataset.fieldValue("cuit", proveedor.getCuit().trim());
			dataset.fieldValue("cuit_empresa", empresa);
			if (proveedor.getActivo().equals("S")) {
				dataset.fieldValue("estado", "INACTIVO");
			} else {
				dataset.fieldValue("estado", "ACTIVO");
			}
			dataset.fieldValue("razon_social", proveedor.getRazonsocial());
			if (proveedor.getDireccion() != null) {
				String direccion = Util.convertTextHTMLToDelphi(proveedor.getDireccion());
				dataset.fieldValue("direccion", direccion);
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
			if (GruProv != null) {
				dataset.fieldValue("id_grupo_proveedor", GruProv.getOID());
			} else {
				dataset.fieldValue("id_grupo_proveedor", "");
			}
			if (GruProv != null) {
				dataset.fieldValue("nombre_grupo", GruProv.getDescripcion());
			} else {
				dataset.fieldValue("nombre_grupo", "");
			}
			if (proveedor.getCondicionpago() != null) {
				dataset.fieldValue("condicion_de_pago", proveedor.getCondicionpago());
			} else {
				dataset.fieldValue("condicion_de_pago", "");
			}
			
			dataset.fieldValue("oid_key_unico", ++oidKeyUnico);
		}
	}

	private Boolean capmosIguales(Hashtable<String, ProveedorMaterialsControl> hasCuit, String get) throws BaseException {
		Iterator itEmpresa = hasCuit.keySet().iterator();
		boolean primero = true;
		if (get.equals("grupoProveedor")) {
			Integer oidGrupo = null;
			while (itEmpresa.hasNext()) {
				String key = (String) itEmpresa.next();
				ProveedorMaterialsControl proveedor = hasCuit.get(key);
				Integer oidBase = proveedor.getGrupoproveedor();
				GrupoProveedor GruProv = GrupoProveedor.findByOidBase(key, oidBase, getSesion());
				if (GruProv != null) {
					if (primero) {
						oidGrupo = GruProv.getOID();
						primero = false;
					}
					if (!oidGrupo.equals(GruProv.getOID())) {
						return false;
					}
				}
			}
			return true;
		} else {
			String valor = "";
			while (itEmpresa.hasNext()) {
				String key = (String) itEmpresa.next();
				ProveedorMaterialsControl proveedor = hasCuit.get(key);
				if (primero) {
					valor = proveedor.get(get);
					primero = false;
				}
				if (valor != null) {
					if (!valor.equals(proveedor.get(get))) {
						return false;
					}
				}
			}
			return true;
		}
	}

	@SuppressWarnings({ "rawtypes", "unused", "unchecked" })
	private void cargarHash(List<ProveedorMaterialsControl> listaProveedores, Hashtable<String, Hashtable> hashProveedores, String base) throws BaseException {

		if (!listaProveedores.isEmpty()) {
			Iterator itProveedores = listaProveedores.iterator();
			while (itProveedores.hasNext()) {
				ProveedorMaterialsControl proveedor = (ProveedorMaterialsControl) itProveedores.next();
				if (proveedor != null) {
					if (proveedor.getCuit() != null) {
						if (hashProveedores.containsKey(proveedor.getCuit().trim())) {
							hashProveedores.get(proveedor.getCuit().trim()).put(base, proveedor);
						} else {
							Hashtable<String, ProveedorMaterialsControl> hasCuit = new Hashtable<String, ProveedorMaterialsControl>();
							hasCuit.put(base, proveedor);
							hashProveedores.put(proveedor.getCuit().trim(), hasCuit);
						}
					}
				}
			}
		}
	}

	@SuppressWarnings({ "rawtypes", "unused", "unchecked" })
	private String cargarCuits(List<ProveedorMaterialsControl> listaProveedores) throws BaseException {
		Hashtable<String, String> cuits = new Hashtable<String, String>();

		String cuitsABuscar = "";

		if (!listaProveedores.isEmpty()) {
			Iterator itProveedores = listaProveedores.iterator();
			while (itProveedores.hasNext()) {
				ProveedorMaterialsControl proveedor = (ProveedorMaterialsControl) itProveedores.next();
				if (proveedor != null) {
					if (proveedor.getCuit() != null) {
						if (!cuits.containsKey(proveedor.getCuit().trim())) {
							cuits.put(proveedor.getCuit().trim(), proveedor.getCuit().trim());
						}
					}
				}
			}
			Set<String> keys = cuits.keySet();
			Iterator itKeys = keys.iterator();
			boolean primera = true;
			while (itKeys.hasNext()) {
				String cuit = (String) itKeys.next();
				if (primera) {
					cuitsABuscar = cuit;
					primera = false;
				} else {
					cuitsABuscar = cuitsABuscar + "', '" + cuit;
				}
			}
		}
		return cuitsABuscar;

	}
}
