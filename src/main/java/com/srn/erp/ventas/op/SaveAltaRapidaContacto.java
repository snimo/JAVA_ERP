package com.srn.erp.ventas.op;

import com.srn.erp.general.bm.Pais;
import com.srn.erp.general.bm.Provincia;
import com.srn.erp.ventas.bm.ContactoSujeto;
import com.srn.erp.ventas.bm.Sujeto;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class SaveAltaRapidaContacto extends Operation {

	ContactoSujeto contacto = null;
	
  public SaveAltaRapidaContacto() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
  	
    IDataSet dataset = mapaDatos.getDataSet("TContactos");
    procesarRegistros(dataset);
  }
  
  private void procesarRegistros(IDataSet dataset) throws BaseException {
    dataset.first();
      while (!dataset.EOF()) {
      	
        contacto = ContactoSujeto.findByOid(dataset.getInteger("oid_contacto"),this.getSesion());
        contacto.setSujeto(Sujeto.findByOidProxy(dataset.getInteger("oid_sujeto"), getSesion()));
        contacto.setDescripcion(dataset.getString("descripcion"));
        contacto.setNombre(dataset.getString("nombre"));
        contacto.setApellido(dataset.getString("apellido"));
        contacto.setDireccion(dataset.getString("direccion"));
        contacto.setLocalidad(dataset.getString("localidad"));
        contacto.setCodigo_postal(dataset.getString("codigo_postal"));
        contacto.setProvincia(Provincia.findByOidProxy(dataset.getInteger("oid_provincia"), getSesion()));
        contacto.setPais(Pais.findByOidProxy(dataset.getInteger("oid_pais"), getSesion()));
        contacto.setTelefonos(dataset.getString("telefonos"));
        contacto.setFax(dataset.getString("fax"));
        contacto.setMail(dataset.getString("mail"));
        contacto.setSector(dataset.getString("sector"));
        contacto.setCargo(dataset.getString("cargo"));
        contacto.setActivo(new Boolean(true));
        
        addTransaccion(contacto);
        dataset.next();
    }
  }
  
	protected void afterSave() throws BaseException {
		
		IDataSet ds = this.getDataSetNuevoContacto();
		if (contacto!=null)
			enviarContacto(ds,contacto);
		writeCliente(ds);
		
	}
  
  
  private void enviarContacto(IDataSet ds,ContactoSujeto contacto) throws BaseException {
  	
  	StringBuffer nomyape = new StringBuffer();
  	if (contacto.getNombre()!=null) {
  		nomyape.append(contacto.getNombre());
  	}
  	
  	if (contacto.getApellido()!=null) {
  		if (nomyape.length()>0)
  			nomyape.append(" ");
  		nomyape.append(contacto.getApellido());
  	}
  	
  	ds.append();
  	ds.fieldValue("oid_contacto",contacto.getOIDInteger());
  	ds.fieldValue("cod_contacto",contacto.getDescripcion());
  	ds.fieldValue("nombre_y_apellido",nomyape.toString());
  }
  
  private IDataSet getDataSetNuevoContacto() {
		IDataSet dataset = new TDataSet();
		dataset.create("TNuevoContacto");
		dataset.fieldDef(new Field("oid_contacto", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_contacto", Field.STRING, 50));
		dataset.fieldDef(new Field("nombre_y_apellido", Field.STRING, 100));
		return dataset;
	}
  
  



}
