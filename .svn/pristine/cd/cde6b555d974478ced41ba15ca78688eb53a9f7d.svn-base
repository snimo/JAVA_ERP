package com.srn.erp.general.op;

import com.srn.erp.general.bm.Pais;
import com.srn.erp.general.bm.Provincia;
import com.srn.erp.general.bm.Sucursal;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveSucursal extends Operation {

  public SaveSucursal() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    IDataSet dataset = mapaDatos.getDataSet("TSucursal");
    procesarRegistros(dataset);
  }

  private void procesarRegistros(IDataSet dataset) throws BaseException {
    dataset.first();
      while (!dataset.EOF()) {
        Sucursal sucursal = Sucursal.findByOid(dataset.getInteger("oid_sucursal"),getSesion());
        sucursal.setOID(dataset.getInteger("oid_sucursal"));
        sucursal.setCodigo(dataset.getString("codigo"));
        sucursal.setDescripcion(dataset.getString("descripcion"));
        sucursal.setCalle_y_nro(dataset.getString("calle_y_nro"));
        sucursal.setLocalidad(dataset.getString("localidad"));
        sucursal.setCodigo_postal(dataset.getString("codigo_postal"));
        sucursal.setProvincia(Provincia.findByOidProxy(dataset.getInteger("oid_provincia"),getSesion()));
        sucursal.setPais(Pais.findByOidProxy(dataset.getInteger("oid_pais"),getSesion()));
        sucursal.setActivo(dataset.getBoolean("activo"));
        sucursal.setTelefonos(dataset.getString("telefonos"));
        sucursal.setPathLogo(dataset.getString("path_logo"));
        sucursal.setFax(dataset.getString("fax"));
        sucursal.setAgentePercIBBsAs(dataset.getBoolean("es_age_perc_ib_ba").booleanValue());
        sucursal.setAgentePercIBCapFed(dataset.getBoolean("es_age_perc_ib_cf").booleanValue());
        sucursal.setAgentePercIVA(dataset.getBoolean("es_age_perc_iva").booleanValue());
        
        addTransaccion(sucursal);
        dataset.next();
    }
  }

}
