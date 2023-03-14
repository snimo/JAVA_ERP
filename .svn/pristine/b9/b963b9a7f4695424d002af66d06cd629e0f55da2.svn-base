package com.srn.erp.contabilidad.op;

import java.util.Iterator;

import com.srn.erp.contabilidad.bm.Atributo;
import com.srn.erp.contabilidad.bm.CompoAtributo;
import com.srn.erp.contabilidad.bm.Componente;
import com.srn.erp.contabilidad.bm.ValorCompo;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveValorComponente extends Operation {

  public SaveValorComponente() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {

    Integer oidCompo = mapaDatos.getInteger("oid_compo");

    IDataSet dataset = mapaDatos.getDataSet("TValorComponente");
    procesarRegistros(oidCompo,dataset);
  }

  private void procesarRegistros(Integer oidCompo,IDataSet dataset) throws BaseException {

    Componente componente = Componente.findByOid(oidCompo,getSesion());
    dataset.first();
      while (!dataset.EOF()) {
        ValorCompo valorCompo = ValorCompo.findByOid(componente,dataset.getInteger("oid_compo"),getSesion());
        valorCompo.setCodigo(dataset.getString("codigo"));
        valorCompo.setDescripcion(dataset.getString("descripcion"));
        valorCompo.setActivo(dataset.getBoolean("activo"));

        Iterator iterCompoAtri = componente.getCompoAtributos().iterator();
        while (iterCompoAtri.hasNext()) {

          CompoAtributo compoAtributo = (CompoAtributo) iterCompoAtri.next();

          if (compoAtributo.getAtributo().getCompo()!=null) {
            Integer oid = dataset.getInteger(compoAtributo.getAtributo().getCampoFisico());
            if (oid == null)
              throw new ExceptionValidation(null,"Debe ingresar un valor de componente "+compoAtributo.getAtributo().getDescripcion());
            ValorCompo valorCompoAtri = ValorCompo.findByOid(compoAtributo.getAtributo().getCompo(),
                                                             oid,
                                                             getSesion());
            valorCompo.addAtributo(compoAtributo.getAtributo().getCampoFisico(),valorCompoAtri);
          }
          else
            if (compoAtributo.getAtributo().getTipo().equals(Atributo.TIPO_ENTERO)) {
              Integer valorEntero = new Integer(0);
              if (dataset.getInteger(compoAtributo.getAtributo().getCampoFisico())!=null)
                valorEntero =  dataset.getInteger(compoAtributo.getAtributo().getCampoFisico());
              valorCompo.addAtributo(
                    compoAtributo.getAtributo().getCampoFisico(),
                    valorEntero);
            }
          else
            if (compoAtributo.getAtributo().getTipo().equals(Atributo.TIPO_DECIMAL)) {
              Double valorDouble = new Double(0.0);
              if (dataset.getDouble(compoAtributo.getAtributo().getCampoFisico())!=null)
                valorDouble = dataset.getDouble(compoAtributo.getAtributo().getCampoFisico());
              valorCompo.addAtributo(
                   compoAtributo.getAtributo().getCampoFisico(),
                   valorDouble);
            }
          else
          if (compoAtributo.getAtributo().getTipo().equals(Atributo.TIPO_FECHA))
            valorCompo.addAtributo(
              compoAtributo.getAtributo().getCampoFisico(),
              dataset.getDate(compoAtributo.getAtributo().getCampoFisico()));
          else
          if (compoAtributo.getAtributo().getTipo().equals(Atributo.TIPO_STRING))
            valorCompo.addAtributo(
              compoAtributo.getAtributo().getCampoFisico(),
              dataset.getString(compoAtributo.getAtributo().getCampoFisico()));


        }


        addTransaccion(valorCompo);
        dataset.next();
    }
  }

}
