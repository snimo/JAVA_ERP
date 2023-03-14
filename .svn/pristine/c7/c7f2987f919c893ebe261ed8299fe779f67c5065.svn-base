package com.srn.erp.contabilidad.op;

import com.srn.erp.contabilidad.bm.Atributo;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerAtributo extends Operation {

  public TraerAtributo() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {

    int    oidCompo;
    String codCompo = null;
    String descCompo = null;

    Atributo atributo = null;
    if (mapaDatos.containsKey("oid")) {
       Integer oid = mapaDatos.getInteger("oid");
       atributo = Atributo.findByOid(oid, getSesion());
    }
    else {
       String codigo = mapaDatos.getString("codigo");
       atributo = Atributo.findByCodigo(codigo, getSesion());
    }

    if (atributo.getCompo()==null) {
      oidCompo = 0;
      codCompo = "";
      descCompo = "";
    }
    else {
      oidCompo = atributo.getCompo().getOID();
      codCompo = atributo.getCompo().getCodigo();
      descCompo = atributo.getCompo().getDescripcion();
    }

    IDataSet datasetAtributo = getDataSetAtributo();
    if (atributo != null) {
        cargarRegistroAtributo(datasetAtributo,
                         atributo.getOIDInteger(),
                         atributo.getCodigo(),
                         atributo.getDescripcion(),
                         atributo.getTipo(),
                         new Integer(oidCompo),
                         codCompo,
                         descCompo,
                         atributo.isActivo());
    }
    writeCliente(datasetAtributo);
  }

  private IDataSet getDataSetAtributo() {
    IDataSet dataset = new TDataSet();
    dataset.create("TAtributo");
    dataset.fieldDef(new Field("oid_atributo", Field.INTEGER, 0));
    dataset.fieldDef(new Field("codigo", Field.STRING, 10));
    dataset.fieldDef(new Field("descripcion", Field.STRING, 30));
    dataset.fieldDef(new Field("tipo", Field.STRING, 10));
    dataset.fieldDef(new Field("oid_compo", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_compo", Field.STRING, 10));
    dataset.fieldDef(new Field("desc_compo", Field.STRING, 30));
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
    return dataset;
  }

  private void cargarRegistroAtributo(IDataSet dataset,
                         Integer oid_atributo,
                         String codigo,
                         String descripcion,
                         String tipo,
                         Integer oid_compo,
                         String cod_compo,
                         String desc_compo,
                         Boolean activo) {
    dataset.append();
    dataset.fieldValue("oid_atributo", oid_atributo);
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("descripcion", descripcion);
    dataset.fieldValue("tipo", tipo);
    dataset.fieldValue("oid_compo", oid_compo);
    dataset.fieldValue("cod_compo", cod_compo);
    dataset.fieldValue("desc_compo", desc_compo);
    dataset.fieldValue("activo", activo);
  }
}
