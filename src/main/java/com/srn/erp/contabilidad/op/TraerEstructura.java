package com.srn.erp.contabilidad.op;

import java.util.Iterator;

import com.srn.erp.contabilidad.bm.Estructura;
import com.srn.erp.contabilidad.bm.EstructuraCompo;

import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerEstructura extends Operation {

  public TraerEstructura() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    Estructura estructura = null;
    if (mapaDatos.containsKey("oid")) {
       Integer oid = mapaDatos.getInteger("oid");
       estructura = Estructura.findByOid(oid, getSesion());
    }
    else {
       String codigo = mapaDatos.getString("codigo");
       estructura = Estructura.findByCodigo(codigo, getSesion());
    }

    IDataSet datasetEstructura = getDataSetEstructura();
    IDataSet datasetEstructuraCompo =  getDataSetEstructuraCompo();

    if (estructura != null) {

        cargarRegistroEstructura(datasetEstructura,
                         estructura.getOIDInteger(),
                         estructura.getCodigo(),
                         estructura.getDescripcion(),
                         estructura.isActivo());

        Iterator iterEstrucCompo =
            estructura.getEstrucComponenentes().iterator();
        while (iterEstrucCompo.hasNext()) {
          EstructuraCompo estructuraCompo = (EstructuraCompo) iterEstrucCompo.next();
          cargarRegistroEstructuraCompo(datasetEstructuraCompo,
                                        estructuraCompo.getOIDInteger(),
                                        estructuraCompo.getEstructura().getOIDInteger(),
                                        estructuraCompo.getSecu(),
                                        estructuraCompo.getComponente().getOIDInteger(),
                                        estructuraCompo.getComponente().getCodigo(),
                                        estructuraCompo.getComponente().getDescripcion(),
                                        estructuraCompo.isActivo(),
                                        estructuraCompo.getValorDefault());

        }

    }

    writeCliente(datasetEstructura);
    writeCliente(datasetEstructuraCompo);
  }

  private IDataSet getDataSetEstructura() {
    IDataSet dataset = new TDataSet();
    dataset.create("TEstructura");
    dataset.fieldDef(new Field("oid_estruc", Field.INTEGER, 0));
    dataset.fieldDef(new Field("codigo", Field.STRING, 15));
    dataset.fieldDef(new Field("descripcion", Field.STRING, 30));
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
    return dataset;
  }

  private IDataSet getDataSetEstructuraCompo() {
    IDataSet dataset = new TDataSet();
    dataset.create("TEstrucCompo");
    dataset.fieldDef(new Field("oid_estruc_compo", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_estruc", Field.INTEGER, 0));
    dataset.fieldDef(new Field("secu", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_compo", Field.INTEGER, 0));
    dataset.fieldDef(new Field("codigo_compo", Field.STRING, 6));
    dataset.fieldDef(new Field("desc_compo", Field.STRING, 50));
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("oid_valor_default",Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_valor_default",Field.STRING, 50));
    dataset.fieldDef(new Field("desc_valor_default",Field.STRING, 100));
    return dataset;
  }


  private void cargarRegistroEstructura(IDataSet dataset,
                         Integer oid_estruc,
                         String codigo,
                         String descripcion,
                         Boolean activo) {
    dataset.append();
    dataset.fieldValue("oid_estruc", oid_estruc);
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("descripcion", descripcion);
    dataset.fieldValue("activo", activo);
  }

  private void cargarRegistroEstructuraCompo(IDataSet dataset,
                         Integer oid_estruc_compo,
                         Integer oid_estruc,
                         Integer secu,
                         Integer oid_compo,
                         String codigo_compo,
                         String desc_compo,
                         Boolean activo,
                         IObjetoLogico valorDefault) throws BaseException {
    dataset.append();
    dataset.fieldValue("oid_estruc_compo", oid_estruc_compo);
    dataset.fieldValue("oid_estruc",oid_estruc);
    dataset.fieldValue("secu",secu);
    dataset.fieldValue("oid_compo",oid_compo);
    dataset.fieldValue("codigo_compo",codigo_compo);
    dataset.fieldValue("desc_compo",desc_compo);
    dataset.fieldValue("activo",activo);
    if (valorDefault!=null) {
    	dataset.fieldValue("oid_valor_default",valorDefault.getOIDInteger());
    	dataset.fieldValue("cod_valor_default",valorDefault.getCodigo());
    	dataset.fieldValue("desc_valor_default",valorDefault.getDescripcion());
    } else {
    	dataset.fieldValue("oid_valor_default",new Integer(0));
    	dataset.fieldValue("cod_valor_default","");
    	dataset.fieldValue("desc_valor_default","");
    }

  }



}
