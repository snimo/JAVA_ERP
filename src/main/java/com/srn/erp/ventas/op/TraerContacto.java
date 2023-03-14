package com.srn.erp.ventas.op;

import com.srn.erp.ventas.bm.ContactoSujeto;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerContacto extends Operation {

  public TraerContacto() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    Integer oidContacto = mapaDatos.getInteger("oid_contacto");
    ContactoSujeto contacto = ContactoSujeto.findByOid(oidContacto, getSesion());
    IDataSet dataset = getDataSet();
    if (contacto != null) 
        cargarRegistro(dataset,contacto);
    writeCliente(dataset);
  }

  private IDataSet getDataSet() {
    IDataSet dataset = new TDataSet();
    dataset.create("TContactos");
    dataset.fieldDef(new Field("oid_contacto", Field.INTEGER, 0));
    dataset.fieldDef(new Field("descripcion", Field.STRING, 20));
    dataset.fieldDef(new Field("oid_provincia", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_provincia", Field.STRING, 50));
    dataset.fieldDef(new Field("desc_provincia", Field.STRING, 100));
    dataset.fieldDef(new Field("oid_pais", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_pais", Field.STRING, 50));
    dataset.fieldDef(new Field("desc_pais", Field.STRING, 100));
    dataset.fieldDef(new Field("apellido", Field.STRING, 25));
    dataset.fieldDef(new Field("nombre", Field.STRING, 25));
    dataset.fieldDef(new Field("telefonos", Field.STRING, 25));
    dataset.fieldDef(new Field("fax", Field.STRING, 25));
    dataset.fieldDef(new Field("direccion", Field.INTEGER, 50));
    dataset.fieldDef(new Field("localidad", Field.STRING, 20));
    dataset.fieldDef(new Field("codigo_postal", Field.STRING, 20));
    dataset.fieldDef(new Field("sector", Field.STRING, 30));
    dataset.fieldDef(new Field("cargo", Field.STRING, 30));
    dataset.fieldDef(new Field("oid_sujeto", Field.INTEGER, 0));
    dataset.fieldDef(new Field("mail", Field.STRING, 50));
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
    return dataset;
  }

  private void cargarRegistro(IDataSet dataset,
                         ContactoSujeto contacto) throws BaseException {
    dataset.append();
    dataset.fieldValue("oid_contacto", contacto.getOIDInteger());
    dataset.fieldValue("descripcion", contacto.getDescripcion());
    if (contacto.getProvincia()!=null) {
      dataset.fieldValue("oid_provincia", contacto.getProvincia().getOIDInteger());
      dataset.fieldValue("cod_provincia", contacto.getProvincia().getCodigo());
      dataset.fieldValue("desc_provincia", contacto.getProvincia().getDescripcion());
    } else {
      dataset.fieldValue("oid_provincia", new Integer(0));
      dataset.fieldValue("cod_provincia", "");
      dataset.fieldValue("desc_provincia", "");
    }
    if (contacto.getPais()!=null) {
      dataset.fieldValue("oid_pais", contacto.getPais().getOIDInteger());
      dataset.fieldValue("cod_pais", contacto.getPais().getCodigo());
      dataset.fieldValue("desc_pais", contacto.getPais().getDescripcion());
    } else {
      dataset.fieldValue("oid_pais", new Integer(0));
      dataset.fieldValue("cod_pais", "");
      dataset.fieldValue("desc_pais", "");
    }
    dataset.fieldValue("apellido", contacto.getApellido());
    dataset.fieldValue("nombre", contacto.getNombre());
    dataset.fieldValue("telefonos", contacto.getTelefonos());
    dataset.fieldValue("fax", contacto.getFax());
    dataset.fieldValue("direccion", contacto.getDireccion());
    dataset.fieldValue("localidad", contacto.getLocalidad());
    dataset.fieldValue("codigo_postal", contacto.getCodigo_postal());
    dataset.fieldValue("sector", contacto.getSector());
    dataset.fieldValue("cargo", contacto.getCargo());
    dataset.fieldValue("oid_sujeto", contacto.getSujeto().getOIDInteger());
    dataset.fieldValue("mail", contacto.getMail());
    dataset.fieldValue("activo", contacto.isActivo());
  }
}
