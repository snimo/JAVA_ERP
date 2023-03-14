package com.srn.erp.ventas.op;

import com.srn.erp.ventas.bm.UnidadEdilicia;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerDomicilioSujeto extends Operation {

  public TraerDomicilioSujeto() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
  	
  	UnidadEdilicia uniEdi =
  		UnidadEdilicia.findByOid(mapaDatos.getInteger("oid_uni_edi"),this.getSesion());
    IDataSet ds = this.getDataSetDomicilio();
    cargarRegistro(ds,uniEdi);
    writeCliente(ds);
  }

  private IDataSet getDataSetDomicilio() {
    IDataSet dataset = new TDataSet();
    dataset.create("TDomicilioEntrega");
    dataset.fieldDef(new Field("oid_uni_edi" , Field.INTEGER, 0));
    dataset.fieldDef(new Field("codigo" , Field.STRING, 20));
    dataset.fieldDef(new Field("calle_y_nro" , Field.STRING, 30));
    dataset.fieldDef(new Field("localidad" , Field.STRING, 20));
    dataset.fieldDef(new Field("codigo_postal" , Field.STRING, 20));
    dataset.fieldDef(new Field("oid_tipo_unidad" , Field.INTEGER, 0));
    dataset.fieldDef(new Field("telefonos" , Field.STRING, 30));
    dataset.fieldDef(new Field("oid_sujeto_alta" , Field.INTEGER, 0));
    dataset.fieldDef(new Field("desc_pais" , Field.STRING, 100));
    dataset.fieldDef(new Field("cod_pais" , Field.STRING, 50));
    dataset.fieldDef(new Field("oid_pais" , Field.INTEGER, 0));
    dataset.fieldDef(new Field("desc_provincia" , Field.STRING, 100));
    dataset.fieldDef(new Field("cod_provincia" , Field.STRING, 50));
    dataset.fieldDef(new Field("oid_provincia" , Field.INTEGER, 0));
    dataset.fieldDef(new Field("dom_ent" , Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("contacto" , Field.STRING, 50));
    dataset.fieldDef(new Field("oid_zona" , Field.INTEGER, 0));
    dataset.fieldDef(new Field("activo" , Field.INTEGER, 0));
    return dataset;
  }

  private void cargarRegistro(IDataSet dataset,
                         UnidadEdilicia uniEdi) throws BaseException {
    dataset.append();
    dataset.fieldValue("oid_uni_edi" , uniEdi.getOIDInteger());
    dataset.fieldValue("codigo" , uniEdi.getCodigo());
    dataset.fieldValue("calle_y_nro" , uniEdi.getCalle_y_mro());
    dataset.fieldValue("localidad" , uniEdi.getLocalidad());
    dataset.fieldValue("codigo_postal" , uniEdi.getCodigo_postal());
    if (uniEdi.getTipo_unidad()!=null)
    	dataset.fieldValue("oid_tipo_unidad" , uniEdi.getTipo_unidad().getOIDInteger());
    else
    	dataset.fieldValue("oid_tipo_unidad" , new Integer(0));
    dataset.fieldValue("telefonos" , uniEdi.getTelefonos());
    dataset.fieldValue("oid_sujeto_alta" , uniEdi.getSujeto_alta().getOIDInteger());
    if (uniEdi.getPais()!=null) {
      dataset.fieldValue("desc_pais" , uniEdi.getPais().getDescripcion());
      dataset.fieldValue("cod_pais" , uniEdi.getPais().getCodigo());
      dataset.fieldValue("oid_pais" , uniEdi.getPais().getOIDInteger());
    } else {
      dataset.fieldValue("desc_pais" , "");
      dataset.fieldValue("cod_pais" , "");
      dataset.fieldValue("oid_pais" , new Integer(0));
    }
    if (uniEdi.getProvincia().getDescripcion()!=null) {
      dataset.fieldValue("desc_provincia" , uniEdi.getProvincia().getDescripcion());
      dataset.fieldValue("cod_provincia" , uniEdi.getProvincia().getCodigo());
      dataset.fieldValue("oid_provincia" , uniEdi.getProvincia().getOIDInteger());
    } else {
      dataset.fieldValue("desc_provincia" , "");
      dataset.fieldValue("cod_provincia" , "");
      dataset.fieldValue("oid_provincia" , new Integer(0));
    }
    dataset.fieldValue("dom_ent" , uniEdi.isDom_ent());
    dataset.fieldValue("contacto" , uniEdi.getContacto());
    if (uniEdi.getZona()!=null)
    	dataset.fieldValue("oid_zona" , uniEdi.getZona().getOIDInteger());
    else
    	dataset.fieldValue("oid_zona" , new Integer(0));
    dataset.fieldValue("activo" , uniEdi.isActivo());
  }
}
