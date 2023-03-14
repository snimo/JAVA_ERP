package com.srn.erp.compras.op;

import java.util.Iterator;
import java.util.List;

import com.srn.erp.compras.bm.InformeControlCalidad;
import com.srn.erp.compras.bm.InformeRecepcion;
import com.srn.erp.compras.bm.Proveedor;
import com.srn.erp.general.bm.Talonario;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerHelpInfCC extends Operation {

  public TraerHelpInfCC() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    IDataSet dsInfCC = getDataSetInfCC();
    traerInfCC(dsInfCC,mapaDatos);
    writeCliente(dsInfCC);
  }

  private void traerInfCC(IDataSet dataSet ,MapDatos mapaDatos) throws BaseException {

    Integer nroExtDesde = null;
    Integer nroExtHasta = null;
    java.util.Date fecDesde = null;
    java.util.Date fecHasta = null;
    Talonario talonario = null;
    Proveedor proveedor = null;
    InformeRecepcion infRec = null;
    HashTableDatos condiciones = new HashTableDatos();
    
    if (mapaDatos.containsKey("nro_ext_desde")) {
      nroExtDesde = mapaDatos.getInteger("nro_ext_desde");
      condiciones.put("NRO_DESDE",nroExtDesde);
    }
    if (mapaDatos.containsKey("nro_ext_hasta")) {
      nroExtHasta = mapaDatos.getInteger("nro_ext_hasta");
      condiciones.put("NRO_HASTA",nroExtHasta);
    }
    if (mapaDatos.containsKey("fec_emi_desde")) {
      fecDesde = mapaDatos.getDate("fec_emi_desde");
      condiciones.put("FEC_DESDE",fecDesde);
    }
    if (mapaDatos.containsKey("fec_emi_hasta")) {
        fecHasta = mapaDatos.getDate("fec_emi_hasta");
        condiciones.put("FEC_HASTA",fecHasta);
    }    
    if (mapaDatos.containsKey("oid_talonario")) {
      talonario = Talonario.findByOidProxy(mapaDatos.getInteger("oid_talonario"),getSesion());
      condiciones.put(Talonario.NICKNAME,talonario);
    }
    if (mapaDatos.containsKey("oid_proveedor")) {
        proveedor = Proveedor.findByOidProxy(mapaDatos.getInteger("oid_proveedor"),getSesion());
        condiciones.put(Proveedor.NICKNAME,proveedor);
    }
    if (mapaDatos.containsKey("oid_inf_rec")) {
        infRec = InformeRecepcion.findByOidProxy(mapaDatos.getInteger("oid_inf_rec"),getSesion());
        condiciones.put(InformeRecepcion.NICKNAME,infRec);
    }    
    
    List listaInfCC =
        InformeControlCalidad.getInformesCC(condiciones,getSesion());
    Iterator iterInfcc = listaInfCC.iterator();
    while (iterInfcc.hasNext()) {
      InformeControlCalidad informeControlCalidad = (InformeControlCalidad) iterInfcc.next();
      cargarRegistroInfCC(dataSet,informeControlCalidad);
    }

  }

  private IDataSet getDataSetInfCC() {
    IDataSet dataset = new TDataSet();
    dataset.create("THelpInfCC");
    dataset.fieldDef(new Field("oid", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_co", Field.INTEGER, 0));
    dataset.fieldDef(new Field("codigo", Field.STRING, 50));
    dataset.fieldDef(new Field("comentario", Field.STRING, 255));
    dataset.fieldDef(new Field("nro_ext", Field.INTEGER, 0));
    dataset.fieldDef(new Field("fec_emision", Field.DATE, 0));
    dataset.fieldDef(new Field("anulado", Field.BOOLEAN, 0));
    return dataset;
  }

  private void cargarRegistroInfCC(IDataSet dataset,
                                    InformeControlCalidad infCC) throws BaseException {
    dataset.append();
    dataset.fieldValue("oid", infCC.getOIDInteger());
    dataset.fieldValue("oid_co", infCC.getOIDInteger());
    dataset.fieldValue("codigo", infCC.getCodigo());
    dataset.fieldValue("comentario", infCC.getComentario());
    dataset.fieldValue("nro_ext", infCC.getNroExt());
    dataset.fieldValue("fec_emision", infCC.getImputac());
    dataset.fieldValue("anulado", new Boolean(!infCC.isActivo().booleanValue()));
  }

}
