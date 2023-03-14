package com.srn.erp.ventas.op;

import java.util.Iterator;

import com.srn.erp.ventas.bm.ListaPrecios;
import com.srn.erp.ventas.bm.ListaPreciosPorUniOrg;

import framework.applicarionServer.bl.Utils.Fecha;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerListaPrecios extends Operation {

  public TraerListaPrecios() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    ListaPrecios listaprecios = null;
    if (mapaDatos.containsKey("oid")) {
       Integer oid = mapaDatos.getInteger("oid");
       listaprecios = ListaPrecios.findByOid(oid, getSesion());
    }
    else {
       String codigo = mapaDatos.getString("codigo");
       listaprecios = ListaPrecios.findByCodigo(codigo, getSesion());
    }

    IDataSet datasetListaPrecios = getDataSetListaPrecios();
    IDataSet datasetUniOrg = getDataSetUniOrg();

    if (listaprecios != null) {
        cargarRegistroListaPrecios(datasetListaPrecios,
                         listaprecios.getOIDInteger(),
                         listaprecios.getCodigo(),
                         listaprecios.getDescripcion(),
                         listaprecios.getComentario(),
                         listaprecios.getFec_vig_desde(),
                         listaprecios.getFec_vig_hasta(),
                         listaprecios.isActivo(),
                         listaprecios.isIncluyeIVA()
                         );

        Iterator iterUniOrg = listaprecios.getUnidadesOrganizativas().iterator();
        while (iterUniOrg.hasNext()) {
          ListaPreciosPorUniOrg listaPreciosPorUniOrg =
              (ListaPreciosPorUniOrg) iterUniOrg.next();
          cargarRegistroUniOrg(datasetUniOrg,
                               listaPreciosPorUniOrg.getOIDInteger(),
                               listaPreciosPorUniOrg.getUnidad_organizativa().getOIDInteger(),
                               listaPreciosPorUniOrg.getUnidad_organizativa().getCodigo(),
                               listaPreciosPorUniOrg.getUnidad_organizativa().getDescripcion(),
                               listaprecios.getOIDInteger()
                               );
        }
    }
    writeCliente(datasetListaPrecios);
    writeCliente(datasetUniOrg);
  }

  private IDataSet getDataSetListaPrecios() {
    IDataSet dataset = new TDataSet();
    dataset.create("TListaPrecios");
    dataset.fieldDef(new Field("oid_precio_cab", Field.INTEGER, 0));
    dataset.fieldDef(new Field("codigo", Field.STRING, 20));
    dataset.fieldDef(new Field("descripcion", Field.STRING, 50));
    dataset.fieldDef(new Field("comentario", Field.STRING, 255));
    dataset.fieldDef(new Field("fec_vig_desde", Field.STRING, 10));
    dataset.fieldDef(new Field("fec_vig_hasta", Field.STRING, 10));
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("incluye_iva", Field.BOOLEAN, 0));
    return dataset;
  }

  private IDataSet getDataSetUniOrg() {
    IDataSet dataset = new TDataSet();
    dataset.create("TUniOrg");
    dataset.fieldDef(new Field("oid_precio_uni_org", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_uni_org", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_uni_org", Field.STRING, 50));
    dataset.fieldDef(new Field("desc_uni_org", Field.STRING, 100));
    dataset.fieldDef(new Field("oid_precio_cab", Field.INTEGER, 0));
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
    return dataset;
  }

  private void cargarRegistroUniOrg(IDataSet dataset,
                         Integer oidPrecioUniOrg,
                         Integer oidUniOrg,
                         String codUniOrg,
                         String descUniOrg,
                         Integer oidPrecioCab) {
    dataset.append();
    dataset.fieldValue("oid_precio_uni_org", oidPrecioUniOrg);
    dataset.fieldValue("oid_uni_org", oidUniOrg);
    dataset.fieldValue("cod_uni_org", codUniOrg);
    dataset.fieldValue("desc_uni_org", descUniOrg);
    dataset.fieldValue("oid_precio_cab", oidPrecioCab);
    dataset.fieldValue("activo", new Boolean(true));
    
  }



  private void cargarRegistroListaPrecios(IDataSet dataset,
                         Integer oid_precio_cab,
                         String codigo,
                         String descripcion,
                         String comentario,
                         java.util.Date fec_vig_desde,
                         java.util.Date fec_vig_hasta,
                         Boolean activo,
                         Boolean incluyeIVA) {
    dataset.append();
    dataset.fieldValue("oid_precio_cab", oid_precio_cab);
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("descripcion", descripcion);
    dataset.fieldValue("comentario", comentario);
    dataset.fieldValue("fec_vig_desde",Fecha.getddmmyyyy(fec_vig_desde));
    dataset.fieldValue("fec_vig_hasta", Fecha.getddmmyyyy(fec_vig_hasta));
    dataset.fieldValue("activo", activo);
    dataset.fieldValue("incluye_iva", incluyeIVA);
    
  }
}
