package com.srn.erp.contabilidad.op;

import java.util.Iterator;

import com.srn.erp.contabilidad.bm.CompoAtributo;
import com.srn.erp.contabilidad.bm.Componente;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerAtributosCompo extends Operation {

  public TraerAtributosCompo() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {

    Integer oidCompo = mapaDatos.getInteger("oid_compo");
    Componente componente = Componente.findByOid(oidCompo,getSesion());
    IDataSet datasetAtriCompo = getDataSetAtributosCompo();

    Iterator iterCompoAtri = componente.getCompoAtributos().iterator();
    while (iterCompoAtri.hasNext()) {
      CompoAtributo compoAtributo = (CompoAtributo) iterCompoAtri.next();

      Integer oidCompoCampo   = new Integer(0);
      String codigoCompoCampo = "";
      String descCompoCampo   = "";

      if (compoAtributo.getAtributo().getCompo()!=null) {
        oidCompoCampo = compoAtributo.getAtributo().getCompo().getOIDInteger();
        codigoCompoCampo = compoAtributo.getAtributo().getCompo().getCodigo();
        descCompoCampo = compoAtributo.getAtributo().getCompo().getDescripcion();
      }

      cargarRegistroAtributoCompo(datasetAtriCompo,
                                  compoAtributo.getOIDInteger(),
                                  compoAtributo.getCompo().getOIDInteger(),
                                  compoAtributo.getSecu(),
                                  compoAtributo.getAtributo().getOIDInteger(),
                                  compoAtributo.getAtributo().getCodigo(),
                                  compoAtributo.getAtributo().getDescripcion(),
                                  compoAtributo.getAtributo().getTipo(),
                                  oidCompoCampo,
                                  codigoCompoCampo,
                                  descCompoCampo,
                                  compoAtributo.getAtributo().getCampoFisico(),
                                  "cod_"+compoAtributo.getAtributo().getCampoFisico(),
                                  "desc_"+compoAtributo.getAtributo().getCampoFisico()
                                  );
    }

    writeCliente(datasetAtriCompo);
  }


  private IDataSet getDataSetAtributosCompo() {
    IDataSet dataset = new TDataSet();
    dataset.create("TAtributosCompo");
    dataset.fieldDef(new Field("oid_compo_atri", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_compo", Field.INTEGER, 0));
    dataset.fieldDef(new Field("secu", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_atributo", Field.INTEGER, 0));
    dataset.fieldDef(new Field("codigo_atri", Field.STRING, 10));
    dataset.fieldDef(new Field("desc_atri",Field.STRING, 30));
    dataset.fieldDef(new Field("tipo",Field.STRING, 10));
    dataset.fieldDef(new Field("oid_compo_campo", Field.INTEGER, 0));
    dataset.fieldDef(new Field("codigo_compo_campo",Field.STRING, 6));
    dataset.fieldDef(new Field("desc_compo_campo",Field.STRING, 50));
    dataset.fieldDef(new Field("campo_fisico",Field.STRING, 30));
    dataset.fieldDef(new Field("codigo_campo_fisico",Field.STRING, 30));
    dataset.fieldDef(new Field("desc_campo_fisico",Field.STRING, 30));



    return dataset;
  }

  private void cargarRegistroAtributoCompo(IDataSet dataset,
                         Integer oid_compo_atri,
                         Integer oid_compo,
                         Integer secu,
                         Integer oid_atributo,
                         String codigo_atri,
                         String desc_atri,
                         String tipo,
                         Integer oid_compo_campo,
                         String codigo_compo_campo,
                         String desc_compo_campo,
                         String campoFisico,
                         String codigoCampoFisico,
                         String descCampoFisico) {
    dataset.append();
    dataset.fieldValue("oid_compo_atri", oid_compo_atri);
    dataset.fieldValue("oid_compo",oid_compo);
    dataset.fieldValue("secu",secu);
    dataset.fieldValue("oid_atributo",oid_atributo);
    dataset.fieldValue("codigo_atri",codigo_atri);
    dataset.fieldValue("desc_atri",desc_atri);
    dataset.fieldValue("tipo",tipo);
    dataset.fieldValue("oid_compo_campo",oid_compo_campo);
    dataset.fieldValue("codigo_compo_campo",codigo_compo_campo);
    dataset.fieldValue("desc_compo_campo",desc_compo_campo);
    dataset.fieldValue("campo_fisico",campoFisico);
    dataset.fieldValue("codigo_campo_fisico",codigoCampoFisico);
    dataset.fieldValue("desc_campo_fisico",descCampoFisico);


  }



}
