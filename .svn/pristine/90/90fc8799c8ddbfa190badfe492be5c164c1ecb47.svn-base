package com.srn.erp.general.op;

import com.srn.erp.general.bm.Pais;
import com.srn.erp.general.bm.Provincia;
import com.srn.erp.general.bm.Sucursal;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerSucursal extends Operation {

  public TraerSucursal() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    Sucursal sucursal = null;
    if (mapaDatos.containsKey("oid")) {
       Integer oid = mapaDatos.getInteger("oid");
       sucursal = Sucursal.findByOid(oid, getSesion());
    }
    else {
       String codigo = mapaDatos.getString("codigo");
       sucursal = Sucursal.findByCodigo(codigo, getSesion());
    }

    IDataSet datasetSucursal = getDataSetSucursal();
    if (sucursal != null) {
        cargarRegistroSucursal(datasetSucursal,
                         sucursal.getOIDInteger(),
                         sucursal.getCodigo(),
                         sucursal.getDescripcion(),
                         sucursal.getCalle_y_nro(),
                         sucursal.getLocalidad(),
                         sucursal.getCodigo_postal(),
                         sucursal.getProvincia(),
                         sucursal.getPais(),
                         sucursal.isActivo(),
                         sucursal.getTelefonos(),
                         sucursal.getPathLogo(),
                         sucursal.getFax(),
                         sucursal.isAgentePercIBBsAs(),
                         sucursal.isAgentePercIBCapFed(),
                         sucursal.isAgentePercIVA());
    }
    writeCliente(datasetSucursal);
  }

  private IDataSet getDataSetSucursal() {
    IDataSet dataset = new TDataSet();
    dataset.create("TSucursal");
    dataset.fieldDef(new Field("oid_sucursal", Field.INTEGER, 0));
    dataset.fieldDef(new Field("codigo", Field.STRING, 50));
    dataset.fieldDef(new Field("descripcion", Field.STRING, 50));
    dataset.fieldDef(new Field("calle_y_nro", Field.STRING, 50));
    dataset.fieldDef(new Field("localidad", Field.STRING, 30));
    dataset.fieldDef(new Field("codigo_postal", Field.STRING, 20));
    dataset.fieldDef(new Field("oid_provincia", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_provincia", Field.STRING, 30));
    dataset.fieldDef(new Field("desc_provincia", Field.STRING, 50));
    dataset.fieldDef(new Field("oid_pais", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_pais", Field.STRING, 30));
    dataset.fieldDef(new Field("desc_pais", Field.STRING, 50));
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("telefonos", Field.STRING, 50));
    dataset.fieldDef(new Field("path_logo", Field.STRING, 255));
    dataset.fieldDef(new Field("fax", Field.STRING, 100));
    dataset.fieldDef(new Field("es_age_perc_ib_ba", Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("es_age_perc_ib_cf", Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("es_age_perc_iva", Field.BOOLEAN, 0));
    return dataset;
  }

  private void cargarRegistroSucursal(IDataSet dataset,
                         Integer oid_sucursal,
                         String codigo,
                         String descripcion,
                         String calle_y_nro,
                         String localidad,
                         String codigo_postal,
                         Provincia provincia,
                         Pais pais,
                         Boolean activo,
                         String telefonos,
                         String pathLogo,
                         String fax,
                         boolean percIBBsAs,
                         boolean percIBCapFed,
                         boolean percIVA
                         ) throws BaseException {
    dataset.append();
    dataset.fieldValue("oid_sucursal", oid_sucursal);
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("descripcion", descripcion);
    dataset.fieldValue("calle_y_nro", calle_y_nro);
    dataset.fieldValue("localidad", localidad);
    dataset.fieldValue("codigo_postal", codigo_postal);
    dataset.fieldValue("oid_provincia", provincia.getOID());
    dataset.fieldValue("cod_provincia", provincia.getCodigo());
    dataset.fieldValue("desc_provincia", provincia.getDescripcion());
    dataset.fieldValue("oid_pais", pais.getOID());
    dataset.fieldValue("cod_pais", pais.getCodigo());
    dataset.fieldValue("desc_pais", pais.getDescripcion());
    dataset.fieldValue("activo", activo);
    dataset.fieldValue("telefonos", telefonos);
    dataset.fieldValue("path_logo", pathLogo);
    dataset.fieldValue("fax", fax);
    dataset.fieldValue("es_age_perc_ib_ba", new Boolean(percIBBsAs));
    dataset.fieldValue("es_age_perc_ib_cf", new Boolean(percIBCapFed));
    dataset.fieldValue("es_age_perc_iva",new Boolean(percIVA));
    
  }
}
