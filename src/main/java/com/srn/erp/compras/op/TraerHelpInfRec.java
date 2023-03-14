package com.srn.erp.compras.op;

import java.util.Iterator;
import java.util.List;

import com.srn.erp.compras.bm.InformeRecepcion;
import com.srn.erp.compras.bm.OrdenDeCompraCab;
import com.srn.erp.compras.bm.Proveedor;
import com.srn.erp.general.bm.Talonario;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerHelpInfRec extends Operation {

  public TraerHelpInfRec() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    IDataSet dsInfRec = getDataSetInfRec();
    traerInfRec(dsInfRec,mapaDatos);
    writeCliente(dsInfRec);
  }

  private void traerInfRec(IDataSet dataSet ,MapDatos mapaDatos) throws BaseException {

    Integer nroExtDesde = null;
    Integer nroExtHasta = null;
    java.util.Date fecDesde = null;
    java.util.Date fecHasta = null;
    Talonario talonario = null;
    Proveedor proveedor = null;
    OrdenDeCompraCab oc = null;
    HashTableDatos condiciones = new HashTableDatos();
    
    if (mapaDatos.containsKey("nro_ext_desde")) {
      nroExtDesde = mapaDatos.getInteger("nro_ext_desde");
      condiciones.put("NRO_DESDE",nroExtDesde);
    }
    if (mapaDatos.containsKey("nro_ext_hasta")) {
      nroExtHasta = mapaDatos.getInteger("nro_ext_hasta");
      condiciones.put("NRO_HASTA",nroExtHasta);
    }
    if (mapaDatos.containsKey("fec_desde")) {
      fecDesde = mapaDatos.getDate("fec_desde");
      condiciones.put("FEC_DESDE",fecDesde);
    }
    if (mapaDatos.containsKey("fec_hasta")) {
        fecHasta = mapaDatos.getDate("fec_hasta");
        condiciones.put("FEC_HASTA",fecHasta);
    }    

    if (mapaDatos.containsKey("oid_proveedor")) {
        proveedor = Proveedor.findByOidProxy(mapaDatos.getInteger("oid_proveedor"),getSesion());
        condiciones.put(Proveedor.NICKNAME,proveedor);
    }
    if (mapaDatos.containsKey("oid_oc")) {
        oc = OrdenDeCompraCab.findByOidProxy(mapaDatos.getInteger("oid_oc"),getSesion());
        condiciones.put(OrdenDeCompraCab.NICKNAME,oc);
    }
    
    if (mapaDatos.containsKey("remito")) {
        condiciones.put("remito",mapaDatos.getString("remito"));
    }    
    
    
    List listaInfRec =
        InformeRecepcion.getInformesRecepcion(condiciones,getSesion());
    Iterator iterInfRec = listaInfRec.iterator();
    while (iterInfRec.hasNext()) {
      InformeRecepcion informeRecepcion = (InformeRecepcion) iterInfRec.next();
      cargarRegistroInfRec(dataSet,informeRecepcion);
    }

  }

  private IDataSet getDataSetInfRec() {
    IDataSet dataset = new TDataSet();
    dataset.create("THelpInfRec");
    dataset.fieldDef(new Field("oid", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_cco", Field.INTEGER, 0));
    dataset.fieldDef(new Field("comprobante", Field.STRING, 50));
    dataset.fieldDef(new Field("nro_ext", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_cco_oc", Field.INTEGER, 0));
    dataset.fieldDef(new Field("comprobante_oc", Field.STRING, 50));
    dataset.fieldDef(new Field("fec_emision", Field.DATE, 0));
    dataset.fieldDef(new Field("oid_proveedor", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_proveedor", Field.STRING, 50));
    dataset.fieldDef(new Field("rs_proveedor", Field.STRING, 255));
    dataset.fieldDef(new Field("remito", Field.STRING, 50));
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
    return dataset;
  }

  private void cargarRegistroInfRec(IDataSet dataset,
                                    InformeRecepcion informeRecepcion) throws BaseException {
    dataset.append();
    dataset.fieldValue("oid", informeRecepcion.getOIDInteger());
    dataset.fieldValue("oid_cco", informeRecepcion.getOIDInteger());
    dataset.fieldValue("comprobante", informeRecepcion.getCodigo());
    dataset.fieldValue("nro_ext", informeRecepcion.getNroExt());
    OrdenDeCompraCab oc = informeRecepcion.getOrdenDeCompra();
    if (oc!=null) {
      dataset.fieldValue("oid_cco_oc", oc.getOIDInteger());
      dataset.fieldValue("comprobante_oc", oc.getCodigo());
    } else {
        dataset.fieldValue("oid_cco_oc", new Integer(0));
        dataset.fieldValue("comprobante_oc", "");
    }
    dataset.fieldValue("fec_emision", informeRecepcion.getEmision());
    dataset.fieldValue("oid_proveedor", informeRecepcion.getProveedor().getOIDInteger());
    dataset.fieldValue("cod_proveedor", informeRecepcion.getProveedor().getCodigo());
    dataset.fieldValue("rs_proveedor", informeRecepcion.getProveedor().getRazonsocial());
    dataset.fieldValue("remito", informeRecepcion.getRemito_prov());
    dataset.fieldValue("activo", informeRecepcion.isActivo());
    
  }

}
