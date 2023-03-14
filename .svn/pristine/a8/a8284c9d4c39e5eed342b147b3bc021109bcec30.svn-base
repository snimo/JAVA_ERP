package com.srn.erp.general.op;

import com.srn.erp.general.bm.LugarEmision;
import com.srn.erp.general.bm.UnidadOrganizativa;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerLugarEmision extends Operation {

  public TraerLugarEmision() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    LugarEmision lugaremision = null;
    if (mapaDatos.containsKey("oid")) {
       Integer oid = mapaDatos.getInteger("oid");
       lugaremision = LugarEmision.findByOid(oid, getSesion());
    }
    else {
       String codigo = mapaDatos.getString("codigo");
       lugaremision = LugarEmision.findByCodigo(codigo, getSesion());
    }

    IDataSet datasetLugarEmision = getDataSetLugarEmision();
    if (lugaremision != null) {
        cargarRegistroLugarEmision(datasetLugarEmision,
                         lugaremision.getOIDInteger(),
                         lugaremision.getLugemi(),
                         lugaremision.getDescripcion(),
                         lugaremision.getUnidadorganizativa(),
                         lugaremision.isActivo());
    }
    writeCliente(datasetLugarEmision);
  }

  private IDataSet getDataSetLugarEmision() {
    IDataSet dataset = new TDataSet();
    dataset.create("TLugarEmision");
    dataset.fieldDef(new Field("oid_lug_emi", Field.INTEGER, 0));
    dataset.fieldDef(new Field("lug_emi", Field.INTEGER, 0));
    dataset.fieldDef(new Field("descripcion", Field.STRING, 30));
    dataset.fieldDef(new Field("oid_uni_org", Field.INTEGER, 0));
    dataset.fieldDef(new Field("codigo_oid_uni_org", Field.STRING, 15));
    dataset.fieldDef(new Field("desc_oid_uni_org", Field.STRING, 50));
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
    return dataset;
  }

  private void cargarRegistroLugarEmision(IDataSet dataset,
                         Integer oid_lug_emi,
                         Integer lug_emi,
                         String descripcion,
                         UnidadOrganizativa uniOrg,
                         Boolean activo) throws BaseException {
    dataset.append();
    dataset.fieldValue("oid_lug_emi", oid_lug_emi);
    dataset.fieldValue("lug_emi", lug_emi);
    dataset.fieldValue("descripcion", descripcion);
    if (uniOrg!=null) {
    	dataset.fieldValue("oid_uni_org", uniOrg.getOIDInteger());
    	dataset.fieldValue("codigo_oid_uni_org", uniOrg.getCodigo());
    	dataset.fieldValue("desc_oid_uni_org", uniOrg.getDescripcion());
    } else {
    	dataset.fieldValue("oid_uni_org", "");
    	dataset.fieldValue("codigo_oid_uni_org", "");
    	dataset.fieldValue("desc_oid_uni_org", "");    	
    }
    dataset.fieldValue("activo", activo);
  }
}
