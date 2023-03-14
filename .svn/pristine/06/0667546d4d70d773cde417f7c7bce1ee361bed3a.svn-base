package com.srn.erp.compras.op;

import com.srn.erp.compras.bm.Proveedor;
import com.srn.erp.general.bm.Provincia;
import com.srn.erp.impuestos.bm.CategoriaIB;
import com.srn.erp.impuestos.bm.CategoriaIVA;
import com.srn.erp.impuestos.bm.SujetoImpositivo;
import com.srn.erp.ventas.bm.TipoDocumento;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class SaveAltaRapidaProveedor extends Operation {

	private Proveedor proveedor = null;
	
	public SaveAltaRapidaProveedor() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		IDataSet dataset = mapaDatos.getDataSet("TProveedor");
		procesarRegistros(dataset);
	}

	private void procesarRegistros(IDataSet dataset) throws BaseException {

		dataset.first();
		while (!dataset.EOF()) {

			String cuit = dataset.getString("nro_documento");
			proveedor = (Proveedor) Proveedor.getNew(Proveedor.NICKNAME, this.getSesion());
			proveedor.setGenerarCodigoAutomatico(dataset.getBoolean("alta_codigo_automatico"));			
			proveedor.setCodigo(dataset.getString("codigo"));
			proveedor.setRazonsocial(dataset.getString("razon_social"));
			proveedor.setDireccion(dataset.getString("direccion"));
			proveedor.setLocalidad(dataset.getString("localidad"));
			proveedor.setCodigopostal(dataset.getString("codigo_postal"));
			proveedor.setActivo(new Boolean(true));
			proveedor.setProvincia(Provincia.findByOidProxy(dataset.getInteger("oid_provincia"), getSesion()));
			proveedor.setHabitual(new Boolean(false));
			
			TipoDocumento tipoDocu = TipoDocumento.findByOidProxy(dataset.getInteger("oid_tipo_docu"), getSesion());
			if (tipoDocu == null)
				throw new ExceptionValidation(null, "Debe ingresar el tipo de documento");
			proveedor.setTipoDocumento(tipoDocu);

			SujetoImpositivo sujetoImpositivo = SujetoImpositivo.findByCodigo(cuit, getSesion());
			if (sujetoImpositivo == null)
				sujetoImpositivo = SujetoImpositivo.getNew(this.getSesion());
			sujetoImpositivo.setRazon(dataset.getString("razon_social"));
			sujetoImpositivo.setCuit(cuit);
			sujetoImpositivo.setExentoretiva(new Boolean(false));
			sujetoImpositivo.setExentoretib(new Boolean(false));
			sujetoImpositivo.setExentoretgan(new Boolean(false));
			sujetoImpositivo.setIngbrutos("");
			sujetoImpositivo.setDnrp("");
			sujetoImpositivo.setCategiva(CategoriaIVA.findByOidProxy(dataset.getInteger("oid_categ_iva"), getSesion()));
			sujetoImpositivo.setCategib(CategoriaIB.findByOidProxy(dataset.getInteger("oid_categ_ib"), getSesion()));
			sujetoImpositivo.setCateggan(null);
			sujetoImpositivo.setActivo(new Boolean(true));
			sujetoImpositivo.setCatRetGan(null);
			sujetoImpositivo.setCatRetIB(null);
			sujetoImpositivo.setCatRetIVA(null);
			proveedor.setSujetoimpositivo(sujetoImpositivo);

			addTransaccion(proveedor);
			dataset.next();
		}
	}
	
  private IDataSet getDataSetProveedor() {
    IDataSet dataset = new TDataSet();
    dataset.create("TAltaProveedor");
    dataset.fieldDef(new Field("oid_proveedor", Field.INTEGER, 0));
    dataset.fieldDef(new Field("codigo", Field.STRING, 50));
    dataset.fieldDef(new Field("razon_social", Field.STRING, 100));
    return dataset;
  }

  private void cargarRegistroProv(IDataSet dataset,
                         Proveedor proveedor) throws BaseException {
    dataset.append();
    dataset.fieldValue("oid_proveedor", proveedor.getOIDInteger());
    dataset.fieldValue("codigo", proveedor.getCodigo());
    dataset.fieldValue("razon_social", proveedor.getRazonsocial());
  }

	protected void afterSave() throws BaseException {
		// TODO Auto-generated method stub
		super.afterSave();
		
		if (proveedor==null) return;
		IDataSet ds = this.getDataSetProveedor();
		cargarRegistroProv(ds,proveedor);
		writeCliente(ds);
		
	}
	

}
