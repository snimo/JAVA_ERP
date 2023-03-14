package com.srn.erp.ventas.op;

import com.srn.erp.ventas.bm.ContactoSujeto;
import com.srn.erp.ventas.bm.Sujeto;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerContactoSujeto extends Operation {

  public TraerContactoSujeto() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
	  
	Sujeto sujeto =
		Sujeto.findByOidProxy(mapaDatos.getInteger("oid_sujeto"), this.getSesion());
	String descripcion = mapaDatos.getString("descripcion");
	  
	ContactoSujeto contactoSujeto = 
		ContactoSujeto.getContactoSujeto(sujeto, descripcion, this.getSesion());
	
	IDataSet ds = this.getDataSet();
	if (contactoSujeto!=null) {
		cargarRegistro(ds, contactoSujeto.getOIDInteger(), contactoSujeto.getDescripcion(), contactoSujeto.getNombreYApellido(), contactoSujeto.isActivo());
	}
	writeCliente(ds);
	
  }

  private IDataSet getDataSet() {
    IDataSet dataset = new TDataSet();
    dataset.create("TValContactoSujeto");
    dataset.fieldDef(new Field("oid", Field.INTEGER, 0));
    dataset.fieldDef(new Field("codigo", Field.STRING, 20));
    dataset.fieldDef(new Field("descripcion", Field.STRING, 50));
    dataset.fieldDef(new Field("ativo", Field.BOOLEAN, 0));
    return dataset;
  }

  private void cargarRegistro(IDataSet dataset,
                         Integer oid,
                         String codigo,
                         String descripcion,
                         Boolean ativo) {
    dataset.append();
    dataset.fieldValue("oid", oid);
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("descripcion", descripcion);
    dataset.fieldValue("ativo", ativo);
  }
}
