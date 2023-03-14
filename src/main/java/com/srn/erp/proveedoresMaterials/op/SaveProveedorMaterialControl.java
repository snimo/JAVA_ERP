package com.srn.erp.proveedoresMaterials.op;

import java.util.List;

import com.srn.erp.proveedoresMaterials.bm.GrupoProveedor;
import com.srn.erp.proveedoresMaterials.bm.ProveedorMaterialsControl;

import framework.applicarionServer.bl.Utils.Util;
import framework.applicarionServer.bm.Parametros.ValorParametro;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class SaveProveedorMaterialControl extends Operation {

	public SaveProveedorMaterialControl() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		
		IDataSet dataset = mapaDatos.getDataSet("TProveedor");
		
		String operacion = "MODIFICACION";
		if (mapaDatos.containsKey("ALTA"))
			operacion = "ALTA";
		else if (mapaDatos.containsKey("MODIFICACION"))
				operacion = "MODIFICACION";
		
		IDataSet datasetErrores = getDataSetEmpleadoRG();
		procesarRegistros(dataset, datasetErrores , operacion);
		writeCliente(datasetErrores);
	}
	
	private IDataSet getDataSetEmpleadoRG() {
		IDataSet dataset = new TDataSet();
		dataset.create("TErrores");
		dataset.fieldDef(new Field("mensaje", Field.STRING, 500));
		return dataset;
	}
	
	private void procesarRegistros(IDataSet dataset, IDataSet datasetErrores , String operacion) throws BaseException {
		dataset.first();
		if(dataset.EOF()){
			throw new ExceptionValidation(null, "Es nesesario cargar un Cuit");
		}
		while (!dataset.EOF()) {
			GrupoProveedor grupoProveedor = GrupoProveedor.findByOid(dataset.getInteger("id_grupo_proveedor"), getSesion());
			
			if(grupoProveedor == null){
				throw new ExceptionValidation(null, "Es nesesario cargar un Grupo Proveedor");
			}
			
			if(!dataset.getString("email").contains("@")){
				throw new ExceptionValidation(null, "El Mail debe contener el símbolo @ ");
			}
			
			List<ProveedorMaterialsControl> proveedorNoCuitUte = ProveedorMaterialsControl.findByRazonSocialNoCuitUte(dataset.getString("razon_social"), dataset.getString("cuit"), getSesion());
			if(proveedorNoCuitUte.isEmpty()){
				
				List<ProveedorMaterialsControl> proveedoresUte = ProveedorMaterialsControl.findByCuitUte(dataset.getString("cuit"), getSesion());
				ProveedorMaterialsControl proveedorUte = null;
				if (!proveedoresUte.isEmpty()) {
					proveedorUte = proveedoresUte.get(0);
				}
				
				if (proveedorUte == null) {
					proveedorUte = (ProveedorMaterialsControl) ProveedorMaterialsControl.getNew(ProveedorMaterialsControl.NICKNAME, this.getSesion());
					proveedorUte.setOID(dataset.getInteger("oid_proveedor"));
				} else {
					proveedorUte.setOID(proveedorUte.getOIDInteger());
				}
				proveedorUte.setCuit(dataset.getString("cuit"));
				proveedorUte.setCuit2(dataset.getString("cuit"));
				proveedorUte.setRazonsocial(dataset.getString("razon_social"));
				proveedorUte.setRazonSocial2(dataset.getString("razon_social"));
				
				String razonSocial = dataset.getString("razon_social");
				String direccion = "";
				if (operacion.equals("ALTA")) {
					if (razonSocial!=null)
						direccion = direccion + razonSocial + "\r\n";				
					if (dataset.getString("direccion")!=null)
						direccion = direccion + Util.convertTextDelphiToHTMLTags(dataset.getString("direccion").trim());
				} else if (operacion.equals("MODIFICACION")) {
					direccion = Util.convertTextDelphiToHTMLTags(dataset.getString("direccion").trim());
				}
				proveedorUte.setDireccion(direccion);
				
				proveedorUte.setContacto(dataset.getString("contacto"));
				proveedorUte.setComercail(dataset.getString("comercial"));
				proveedorUte.setTelefono(dataset.getString("telefono"));
				proveedorUte.setEmail(dataset.getString("email"));
				proveedorUte.setGrupoproveedor(grupoProveedor.getGrupoute());
				proveedorUte.setCondicionpago(dataset.getString("condicion_de_pago"));
				if (dataset.getBoolean("activo_ute")) {
					proveedorUte.setActivo(" ");
				} else {
					proveedorUte.setActivo("S");
				}
				String esquemaUte = ValorParametro.findByCodigoParametro("ESQUEMA_MATERIAL_UTE", this.getSesion()).getValorCadena();
				if (!("").equals(esquemaUte) && esquemaUte != null) {
					esquemaUte = esquemaUte + ".";
				} else {
					esquemaUte = "";
				}
				String dbLlinkUte = ValorParametro.findByCodigoParametro("DB_LINK_UTE_MATERIAL", this.getSesion()).getValorCadena();
				if (!("").equals(dbLlinkUte) && dbLlinkUte != null) {
					dbLlinkUte = "@" + dbLlinkUte;
				} else {
					dbLlinkUte = "";
				}
				proveedorUte.setOwner(esquemaUte);
				proveedorUte.setDbLink(dbLlinkUte);
				addTransaccion(proveedorUte);
			}else{
				ProveedorMaterialsControl proveedor = proveedorNoCuitUte.get(0);
				String error = "No se pudo guardar el proveedor en UTE ya que existe un proveedor con la misma razon social pero tiene el cuit: " + proveedor.getCuit();
				datasetErrores.append();
				datasetErrores.fieldValue("mensaje", error);
			}

			List<ProveedorMaterialsControl> proveedorNoCuitBinbaires = ProveedorMaterialsControl.findByRazonSocialNoCuitBinbaires(dataset.getString("razon_social"), dataset.getString("cuit"), getSesion());
			if(proveedorNoCuitBinbaires.isEmpty()){
				
				List<ProveedorMaterialsControl> proveedoresBinbaires = ProveedorMaterialsControl.findByCuitBinbaires(dataset.getString("cuit"), getSesion());
				ProveedorMaterialsControl proveedorBinbaires = null;
				if (!proveedoresBinbaires.isEmpty()) {
					proveedorBinbaires = proveedoresBinbaires.get(0);
				}
				
				if (proveedorBinbaires == null) {
					proveedorBinbaires = (ProveedorMaterialsControl) ProveedorMaterialsControl.getNew(ProveedorMaterialsControl.NICKNAME, this.getSesion());
					proveedorBinbaires.setOID(dataset.getInteger("oid_proveedor"));
				} else {
					proveedorBinbaires.setOID(proveedorBinbaires.getOIDInteger());
				}
				proveedorBinbaires.setCuit(dataset.getString("cuit"));
				proveedorBinbaires.setCuit2(dataset.getString("cuit"));
				proveedorBinbaires.setRazonsocial(dataset.getString("razon_social"));
				proveedorBinbaires.setRazonSocial2(dataset.getString("razon_social"));
				
				
				String razonSocial = dataset.getString("razon_social");
				String direccion = "";
				if (operacion.equals("ALTA")) {
					if (razonSocial!=null)
						direccion = direccion + razonSocial + "\r\n";				
					if (dataset.getString("direccion")!=null)
						direccion = direccion + Util.convertTextDelphiToHTMLTags(dataset.getString("direccion").trim());
				} else if (operacion.equals("MODIFICACION")) {
					direccion = Util.convertTextDelphiToHTMLTags(dataset.getString("direccion").trim());
				}
				proveedorBinbaires.setDireccion(direccion);
				
				
				proveedorBinbaires.setContacto(dataset.getString("contacto"));
				proveedorBinbaires.setComercail(dataset.getString("comercial"));
				proveedorBinbaires.setTelefono(dataset.getString("telefono"));
				proveedorBinbaires.setEmail(dataset.getString("email"));
				proveedorBinbaires.setGrupoproveedor(grupoProveedor.getGrupobinbaires());
				proveedorBinbaires.setCondicionpago(dataset.getString("condicion_de_pago"));
				if (dataset.getBoolean("activo_binbaires")) {
					proveedorBinbaires.setActivo(" ");
				} else {
					proveedorBinbaires.setActivo("S");
				}
				String esquemaBinbaires = ValorParametro.findByCodigoParametro("ESQUEMA_MATERIAL_BINBAIRES", this.getSesion()).getValorCadena();
				if (!("").equals(esquemaBinbaires) && esquemaBinbaires != null) {
					esquemaBinbaires = esquemaBinbaires + ".";
				} else {
					esquemaBinbaires = "";
				}
				String dbLlinkBinbaires = ValorParametro.findByCodigoParametro("DB_LINK_BINBAIRES_MATERIAL", this.getSesion()).getValorCadena();
				if (!("").equals(dbLlinkBinbaires) && dbLlinkBinbaires != null) {
					dbLlinkBinbaires = "@" + dbLlinkBinbaires;
				} else {
					dbLlinkBinbaires = "";
				}
				proveedorBinbaires.setOwner(esquemaBinbaires);
				proveedorBinbaires.setDbLink(dbLlinkBinbaires);
				addTransaccion(proveedorBinbaires);
			}else{
				ProveedorMaterialsControl proveedor = proveedorNoCuitBinbaires.get(0);
				String error = "No se pudo guardar el proveedor en BINBAIRES ya que existe un proveedor con la misma razon social pero tiene el cuit: " + proveedor.getCuit();
				datasetErrores.append();
				datasetErrores.fieldValue("mensaje", error);
			}

			List<ProveedorMaterialsControl> proveedorNoCuitAlavera = ProveedorMaterialsControl.findByRazonSocialNoCuitAlavera(dataset.getString("razon_social"), dataset.getString("cuit"), getSesion());
			if(proveedorNoCuitAlavera.isEmpty()){
				
				List<ProveedorMaterialsControl> proveedoresAlavera = ProveedorMaterialsControl.findByCuitAlavera(dataset.getString("cuit"), getSesion());
				ProveedorMaterialsControl proveedorAlavera = null;
				if (!proveedoresAlavera.isEmpty()) {
					proveedorAlavera = proveedoresAlavera.get(0);
				}
				
				if (proveedorAlavera == null) {
					proveedorAlavera = (ProveedorMaterialsControl) ProveedorMaterialsControl.getNew(ProveedorMaterialsControl.NICKNAME, this.getSesion());
					proveedorAlavera.setOID(dataset.getInteger("oid_proveedor"));
				} else {
					proveedorAlavera.setOID(proveedorAlavera.getOIDInteger());
				}
				proveedorAlavera.setCuit(dataset.getString("cuit"));
				proveedorAlavera.setCuit2(dataset.getString("cuit"));
				proveedorAlavera.setRazonsocial(dataset.getString("razon_social"));
				proveedorAlavera.setRazonSocial2(dataset.getString("razon_social"));
				
				String razonSocial = dataset.getString("razon_social");
				String direccion = "";
				if (operacion.equals("ALTA")) {
					if (razonSocial!=null)
						direccion = direccion + razonSocial + "\r\n";				
					if (dataset.getString("direccion")!=null)
						direccion = direccion + Util.convertTextDelphiToHTMLTags(dataset.getString("direccion").trim());
				} else if (operacion.equals("MODIFICACION")) {
					direccion = Util.convertTextDelphiToHTMLTags(dataset.getString("direccion").trim());
				}
				proveedorAlavera.setDireccion(direccion);
				
				proveedorAlavera.setContacto(dataset.getString("contacto"));
				proveedorAlavera.setComercail(dataset.getString("comercial"));
				proveedorAlavera.setTelefono(dataset.getString("telefono"));
				proveedorAlavera.setEmail(dataset.getString("email"));
				proveedorAlavera.setGrupoproveedor(grupoProveedor.getGrupoalavera());
				proveedorAlavera.setCondicionpago(dataset.getString("condicion_de_pago"));
				if (dataset.getBoolean("activo_alavera")) {
					proveedorAlavera.setActivo(" ");
				} else {
					proveedorAlavera.setActivo("S");
				}
				String esquemaAlavera = ValorParametro.findByCodigoParametro("ESQUEMA_MATERIAL_ALAVERA", this.getSesion()).getValorCadena();
				if (!("").equals(esquemaAlavera) && esquemaAlavera != null) {
					esquemaAlavera = esquemaAlavera + ".";
				} else {
					esquemaAlavera = "";
				}
				String dbLlinkAlavera = ValorParametro.findByCodigoParametro("DB_LINK_ALAVERA_MATERIAL", this.getSesion()).getValorCadena();
				if (!("").equals(dbLlinkAlavera) && dbLlinkAlavera != null) {
					dbLlinkAlavera = "@" + dbLlinkAlavera;
				} else {
					dbLlinkAlavera = "";
				}
				proveedorAlavera.setOwner(esquemaAlavera);
				proveedorAlavera.setDbLink(dbLlinkAlavera);
				addTransaccion(proveedorAlavera);
			}else{
				ProveedorMaterialsControl proveedor = proveedorNoCuitAlavera.get(0);
				String error = "No se pudo guardar el proveedor en ALAVERA ya que existe un proveedor con la misma razon social pero tiene el cuit: " + proveedor.getCuit();
				datasetErrores.append();
				datasetErrores.fieldValue("mensaje", error);
			}

			List<ProveedorMaterialsControl> proveedorNoCuitMagic = ProveedorMaterialsControl.findByRazonSocialNoCuitMagic(dataset.getString("razon_social"), dataset.getString("cuit"), getSesion());
			if(proveedorNoCuitMagic.isEmpty()){
				List<ProveedorMaterialsControl> proveedoresMagic = ProveedorMaterialsControl.findByCuitMagic(dataset.getString("cuit"), getSesion());
				ProveedorMaterialsControl proveedorMagic = null;
				if (!proveedoresMagic.isEmpty()) {
					proveedorMagic = proveedoresMagic.get(0);
				}
				
				if (proveedorMagic == null) {
					proveedorMagic = (ProveedorMaterialsControl) ProveedorMaterialsControl.getNew(ProveedorMaterialsControl.NICKNAME, this.getSesion());
					proveedorMagic.setOID(dataset.getInteger("oid_proveedor"));
				} else {
					proveedorMagic.setOID(proveedorMagic.getOIDInteger());
				}
				proveedorMagic.setCuit(dataset.getString("cuit"));
				proveedorMagic.setCuit2(dataset.getString("cuit"));
				proveedorMagic.setRazonsocial(dataset.getString("razon_social"));
				proveedorMagic.setRazonSocial2(dataset.getString("razon_social"));
				
				String razonSocial = dataset.getString("razon_social");
				String direccion = "";
				if (operacion.equals("ALTA")) {
					if (razonSocial!=null)
						direccion = direccion + razonSocial + "\r\n";				
					if (dataset.getString("direccion")!=null)
						direccion = direccion + Util.convertTextDelphiToHTMLTags(dataset.getString("direccion").trim());
				} else if (operacion.equals("MODIFICACION")) {
					direccion = Util.convertTextDelphiToHTMLTags(dataset.getString("direccion").trim());
				}
				proveedorMagic.setDireccion(direccion);
				
				
				proveedorMagic.setContacto(dataset.getString("contacto"));
				proveedorMagic.setComercail(dataset.getString("comercial"));
				proveedorMagic.setTelefono(dataset.getString("telefono"));
				proveedorMagic.setEmail(dataset.getString("email"));
				proveedorMagic.setGrupoproveedor(grupoProveedor.getGrupomagic());
				proveedorMagic.setCondicionpago(dataset.getString("condicion_de_pago"));
				if (dataset.getBoolean("activo_magic")) {
					proveedorMagic.setActivo(" ");
				} else {
					proveedorMagic.setActivo("S");
				}
				String esquemaMagic = ValorParametro.findByCodigoParametro("ESQUEMA_MATERIAL_MAGIC", this.getSesion()).getValorCadena();
				if (!("").equals(esquemaMagic) && esquemaMagic != null) {
					esquemaMagic = esquemaMagic + ".";
				} else {
					esquemaMagic = "";
				}
				String dbLlinkMagic = ValorParametro.findByCodigoParametro("DB_LINK_MAGIC_MATERIAL", this.getSesion()).getValorCadena();
				if (!("").equals(dbLlinkMagic) && dbLlinkMagic != null) {
					dbLlinkMagic = "@" + dbLlinkMagic;
				} else {
					dbLlinkMagic = "";
				}
				proveedorMagic.setOwner(esquemaMagic);
				proveedorMagic.setDbLink(dbLlinkMagic);
				addTransaccion(proveedorMagic);
			}else{
				ProveedorMaterialsControl proveedor = proveedorNoCuitMagic.get(0);
				String error = "No se pudo guardar el proveedor en MAGIC ya que existe un proveedor con la misma razon social pero tiene el cuit: " + proveedor.getCuit();
				datasetErrores.append();
				datasetErrores.fieldValue("mensaje", error);
			}
			
			dataset.next();
		}
	}

}
