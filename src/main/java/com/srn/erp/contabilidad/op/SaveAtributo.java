package com.srn.erp.contabilidad.op;

import com.srn.erp.contabilidad.bm.Atributo;
import com.srn.erp.contabilidad.bm.Componente;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveAtributo extends Operation {

  public SaveAtributo() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    IDataSet dataset = mapaDatos.getDataSet("TAtributo");
    procesarRegistros(dataset);
  }

  private void procesarRegistros(IDataSet dataset) throws BaseException {
    dataset.first();
      while (!dataset.EOF()) {
        Atributo atributo = Atributo.findByOid(dataset.getInteger("oid_atributo"),getSesion());
        atributo.setOID(dataset.getInteger("oid_atributo"));
        atributo.setCodigo(dataset.getString("codigo"));
        atributo.setDescripcion(dataset.getString("descripcion"));
        atributo.setTipo(dataset.getString("tipo"));
        atributo.setCompo(Componente.findByOidProxy(dataset.getInteger(
            "oid_compo"), getSesion()));
        atributo.setActivo(dataset.getBoolean("activo"));
        addTransaccion(atributo);
        dataset.next();
    }
  }

}
