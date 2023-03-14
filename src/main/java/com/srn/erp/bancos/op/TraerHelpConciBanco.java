package com.srn.erp.bancos.op;

import java.util.Iterator;
import java.util.List;

import com.srn.erp.bancos.bm.ConciliacionCab;
import com.srn.erp.tesoreria.bm.CuentaBancaria;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerHelpConciBanco extends Operation {

  public TraerHelpConciBanco() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    IDataSet ds = getDataSetConciBanco();
    traer(ds,mapaDatos);
    writeCliente(ds);
  }

  private void traer(IDataSet dataSet ,MapDatos mapaDatos) throws BaseException {

    Integer nroExtDesde = null;
    Integer nroExtHasta = null;
    java.util.Date fecDesde = null;
    java.util.Date fecHasta = null;
    CuentaBancaria cuentaBancaria = null;
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
    if (mapaDatos.containsKey("oid_cta_bancaria")) {
      cuentaBancaria = CuentaBancaria.findByOidProxy(mapaDatos.getInteger("oid_cta_bancaria"),getSesion());
      condiciones.put(CuentaBancaria.NICKNAME,cuentaBancaria);
    }
    
    List listaConciliacionesBancarias =
        ConciliacionCab.getConciliacionesBancarias(cuentaBancaria, fecDesde, fecHasta,nroExtDesde , nroExtHasta, this.getSesion());
    Iterator iterConciBco = listaConciliacionesBancarias.iterator();
    while (iterConciBco.hasNext()) {
      ConciliacionCab conciliacion = (ConciliacionCab) iterConciBco.next();
      cargarRegistroConciliacion(dataSet,conciliacion);
    }

  }

  private IDataSet getDataSetConciBanco() {
    IDataSet dataset = new TDataSet();
    dataset.create("THelpConciliacionBanco");
    dataset.fieldDef(new Field("oid", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_cco", Field.INTEGER, 0));
    dataset.fieldDef(new Field("nro_ext", Field.INTEGER, 0));
    dataset.fieldDef(new Field("fec_emision", Field.DATE, 0));
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("oid_cta_banco", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_cta_banco", Field.STRING, 50));
    dataset.fieldDef(new Field("desc_cta_banco", Field.STRING, 100));
    dataset.fieldDef(new Field("fecha_desde", Field.DATE, 0));
    dataset.fieldDef(new Field("fecha_hasta", Field.DATE, 0));
    return dataset;
  }

  private void cargarRegistroConciliacion(IDataSet dataset,
                                		ConciliacionCab conciliacion) throws BaseException {
    dataset.append();
    dataset.fieldValue("oid", conciliacion.getOIDInteger());
    dataset.fieldValue("oid_cco", conciliacion.getOIDInteger());
    dataset.fieldValue("nro_ext", conciliacion.getNroExt());
    dataset.fieldValue("fec_emision", conciliacion.getEmision());
    dataset.fieldValue("activo", conciliacion.isActivo());
    dataset.fieldValue("oid_cta_banco", conciliacion.getCuenta_bancaria().getOIDInteger());
    dataset.fieldValue("cod_cta_banco", conciliacion.getCuenta_bancaria().getCodigo());
    dataset.fieldValue("desc_cta_banco", conciliacion.getCuenta_bancaria().getDescripcion());
    dataset.fieldValue("fecha_desde", conciliacion.getFec_desde());
    dataset.fieldValue("fecha_hasta", conciliacion.getConciliado_al());
  }

}
