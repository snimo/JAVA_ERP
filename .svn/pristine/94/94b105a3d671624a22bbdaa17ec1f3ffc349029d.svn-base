package com.srn.erp.contabilidad.op;

import com.srn.erp.contabilidad.bm.Atributo;
import com.srn.erp.contabilidad.bm.CompoAtributo;
import com.srn.erp.contabilidad.bm.Componente;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveComponente extends Operation {

  public SaveComponente() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    IDataSet dataset = mapaDatos.getDataSet("TComponente");
    procesarRegistros(dataset);
  }

  private void procesarRegistros(IDataSet dataset) throws BaseException {
    dataset.first();
      while (!dataset.EOF()) {
        Componente componente = Componente.findByOid(dataset.getInteger("oid_compo"),getSesion());
        componente.setOID(dataset.getInteger("oid_compo"));
        componente.setCodigo(dataset.getString("codigo"));
        componente.setDescripcion(dataset.getString("descripcion"));
        componente.setTipo(dataset.getString("tipo"));
        componente.setActivo(dataset.getBoolean("activo"));
        componente.setNroClasificador(dataset.getInteger("nro_clasificador"));
        componente.setNombreNickName(dataset.getString("nombre_nickname"));
        componente.setLongitud(dataset.getInteger("longitud"));
        componente.setPrecision(dataset.getInteger("precision"));

        IDataSet datasetCompoAtributos = dataset.getDataSet(
          "TAtributos");
        datasetCompoAtributos.first();
        while (!datasetCompoAtributos.EOF()) {
          CompoAtributo compoAtributo = CompoAtributo.findByOid(
            datasetCompoAtributos.getInteger("oid_compo_atri"),getSesion());
          compoAtributo.setCompo(Componente.findByOidProxy(datasetCompoAtributos.getInteger("oid_compo"),getSesion()));
          compoAtributo.setSecu(datasetCompoAtributos.getInteger("secu"));
          compoAtributo.setAtributo(Atributo.findByOidProxy(datasetCompoAtributos.getInteger("oid_atributo"),getSesion()));
          compoAtributo.setActivo(datasetCompoAtributos.getBoolean("activo"));
          componente.addCompoAtributo(compoAtributo);
          datasetCompoAtributos.next();
        }
        addTransaccion(componente);
        dataset.next();
    }
  }

}
