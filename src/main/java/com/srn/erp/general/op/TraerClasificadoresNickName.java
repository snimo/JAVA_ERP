package com.srn.erp.general.op;

import java.util.Iterator;
import java.util.List;

import com.srn.erp.general.bm.ClasificadorEntidad;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerClasificadoresNickName extends Operation {

  public TraerClasificadoresNickName() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    String nickname = mapaDatos.getString("nickname");
    IDataSet ds = getDataSetClasificadorEntidad();
    List listaClasifEnt = null;
    if (mapaDatos.containsKey("SOLO_ACTIVO"))
    	listaClasifEnt = ClasificadorEntidad.getClasificadoresEntidadActivos(nickname,true,getSesion());
    else
    	listaClasifEnt = ClasificadorEntidad.getClasificadoresEntidad(nickname,true,getSesion());
    Iterator iterClasifEnt = listaClasifEnt.iterator();
    while (iterClasifEnt.hasNext()) {
      ClasificadorEntidad clasifEnt = (ClasificadorEntidad) iterClasifEnt.next();
      cargarClasif(ds,clasifEnt);
    }
    writeCliente(ds);
  }

  private IDataSet getDataSetClasificadorEntidad() {
    IDataSet dataset = new TDataSet();
    dataset.create("TClasificadoresEntidad");
    dataset.fieldDef(new Field("oid_clasif_ent", Field.INTEGER, 0));
    dataset.fieldDef(new Field("codigo", Field.STRING, 20));
    dataset.fieldDef(new Field("descripcion", Field.STRING, 50));
    dataset.fieldDef(new Field("nro_clasif", Field.INTEGER, 0));
    return dataset;
  }

  private void cargarClasif(IDataSet dataset,
                            ClasificadorEntidad clasifEnt) throws BaseException {
    dataset.append();
    dataset.fieldValue("oid_clasif_ent", clasifEnt.getOIDInteger());
    dataset.fieldValue("codigo", clasifEnt.getCodigo());
    dataset.fieldValue("descripcion", clasifEnt.getDescripcion());
    dataset.fieldValue("nro_clasif", clasifEnt.getNroClasif());
  }


}
