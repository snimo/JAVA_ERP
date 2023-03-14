package com.srn.erp.ventas.op;

import com.srn.erp.general.bm.UnidadOrganizativa;
import com.srn.erp.ventas.bm.ListaPrecios;
import com.srn.erp.ventas.bm.ListaPreciosPorUniOrg;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveListaPrecios extends Operation {

  public SaveListaPrecios() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    IDataSet dataset = mapaDatos.getDataSet("TListaPrecios");
    procesarRegistros(dataset);
  }

  private void procesarRegistros(IDataSet dataset) throws BaseException {
    dataset.first();
      while (!dataset.EOF()) {
        ListaPrecios listaprecios = ListaPrecios.findByOid(dataset.getInteger("oid_precio_cab"),getSesion());
        listaprecios.setOID(dataset.getInteger("oid_precio_cab"));
        listaprecios.setCodigo(dataset.getString("codigo"));
        listaprecios.setDescripcion(dataset.getString("descripcion"));
        listaprecios.setComentario(dataset.getString("comentario"));
        listaprecios.setFec_vig_desde(dataset.getDate("fec_vig_desde"));
        listaprecios.setFec_vig_hasta(dataset.getDate("fec_vig_hasta"));
        listaprecios.setActivo(dataset.getBoolean("activo"));
        listaprecios.setIncluyeIVA(dataset.getBoolean("incluye_iva"));

        IDataSet dsUniOrg = dataset.getDataSet("TUniOrg");
        dsUniOrg.first();
        while (!dsUniOrg.EOF()) {

          ListaPreciosPorUniOrg listaPreciosPorUniOrg =
              ListaPreciosPorUniOrg.findByOid(dsUniOrg.getInteger("oid_precio_uni_org"),getSesion());
          listaPreciosPorUniOrg.setUnidad_organizativa(UnidadOrganizativa.findByOidProxy(dsUniOrg.getInteger("oid_uni_org"),getSesion()));
          listaPreciosPorUniOrg.setLista_precios(ListaPrecios.findByOidProxy(dsUniOrg.getInteger("oid_precio_cab"),getSesion()));
          listaprecios.addUnidadOrganizativa(listaPreciosPorUniOrg);
          if (dsUniOrg.getBoolean("activo").booleanValue()==false) listaPreciosPorUniOrg.delete();

          dsUniOrg.next();
        }

        addTransaccion(listaprecios);
        dataset.next();
    }
  }

}
