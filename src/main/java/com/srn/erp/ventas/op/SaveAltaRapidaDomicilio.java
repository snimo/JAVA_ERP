package com.srn.erp.ventas.op;

import com.srn.erp.general.bm.Pais;
import com.srn.erp.general.bm.Provincia;
import com.srn.erp.ventas.bm.Sujeto;
import com.srn.erp.ventas.bm.TipoUnidadEdilicia;
import com.srn.erp.ventas.bm.UnidadEdilicia;
import com.srn.erp.ventas.bm.Zona;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class SaveAltaRapidaDomicilio extends Operation {

	UnidadEdilicia uniEdi = null;
	
  public SaveAltaRapidaDomicilio() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
  	
    IDataSet dataset = mapaDatos.getDataSet("TDomicilioEntrega");
    procesarRegistros(dataset);
  }
  
  private void procesarRegistros(IDataSet dataset) throws BaseException {
    dataset.first();
      while (!dataset.EOF()) {
      	
        uniEdi = UnidadEdilicia.findByOid(dataset.getInteger("oid_uni_edi"),this.getSesion());
        Sujeto sujeto = Sujeto.findByOidProxy(dataset.getInteger("oid_sujeto_alta"), getSesion());
        uniEdi.setSujeto_alta(sujeto);
        
        UnidadEdilicia existeUniEdit = UnidadEdilicia.getUnidadEdilicia(dataset.getString("codigo"),sujeto,this.getSesion());
        if (uniEdi.isNew())
        	if (existeUniEdit != null)
        		throw new ExceptionValidation(null,"Código de domicilio de entrega existente:"+dataset.getString("codigo")+". Modifique el código ingresado.");
        
        if ((existeUniEdit!=null)&& (!uniEdi.isNew())) {
        	if (existeUniEdit.getOID()!=uniEdi.getOID())
        		throw new ExceptionValidation(null,"Código de domicilio de entrega existente:"+dataset.getString("codigo")+". Modifique el código ingresado.");
        }
        	
        
        uniEdi.setCodigo(dataset.getString("codigo"));
        uniEdi.setCalle_y_mro(dataset.getString("calle_y_nro"));
        uniEdi.setLocalidad(dataset.getString("localidad"));
        uniEdi.setCodigo_postal(dataset.getString("codigo_postal"));
        uniEdi.setTipo_unidad(TipoUnidadEdilicia.findByOidProxy(dataset.getInteger("oid_tipo_unidad"), getSesion()));
        uniEdi.setTelefonos(dataset.getString("telefonos"));
        uniEdi.setProvincia(Provincia.findByOidProxy(dataset.getInteger("oid_provincia"), getSesion()));
        uniEdi.setPais(Pais.findByOidProxy(dataset.getInteger("oid_pais"), getSesion()));
        uniEdi.setContacto(dataset.getString("contacto"));
        uniEdi.setZona(Zona.findByOidProxy(dataset.getInteger("oid_zona"), getSesion()));
        uniEdi.setDom_ent(new Boolean(true));
        uniEdi.setActivo(new Boolean(true));
        
        addTransaccion(uniEdi);
        dataset.next();
    }
  }
  
	protected void afterSave() throws BaseException {
		
		IDataSet ds = this.getDataSetNuevoDomicilio();
		if (this.uniEdi!=null)
			enviarDomicilio(ds,this.uniEdi);
		writeCliente(ds);
		
	}
  
  
  private void enviarDomicilio(IDataSet ds,UnidadEdilicia uniEdi) throws BaseException {
  	
  	ds.append();
  	ds.fieldValue("oid_uni_edi",uniEdi.getOIDInteger());
  	ds.fieldValue("codigo",uniEdi.getCodigo());
  	ds.fieldValue("descripcion",uniEdi.getDescripcion());
  }
  
  private IDataSet getDataSetNuevoDomicilio() {
		IDataSet dataset = new TDataSet();
		dataset.create("TNuevoDomicilioEntrega");
		dataset.fieldDef(new Field("oid_uni_edi", Field.INTEGER, 0));
		dataset.fieldDef(new Field("codigo", Field.STRING, 50));
		dataset.fieldDef(new Field("descripcion", Field.STRING, 100));
		return dataset;
	}
  
  



}
