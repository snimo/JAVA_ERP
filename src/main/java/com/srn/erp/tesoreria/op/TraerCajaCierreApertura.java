package com.srn.erp.tesoreria.op;

import java.util.Date;

import com.srn.erp.tesoreria.bm.Caja;
import com.srn.erp.tesoreria.bm.CajaCierreApertura;

import framework.applicarionServer.bl.Utils.Fecha;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerCajaCierreApertura extends Operation {

  public TraerCajaCierreApertura() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    CajaCierreApertura cajacierreapertura = null;
    if (mapaDatos.containsKey("oid")) {
       Integer oid = mapaDatos.getInteger("oid");
       cajacierreapertura = CajaCierreApertura.findByOid(oid, getSesion());
    }
    else {
       String codigo = mapaDatos.getString("codigo");
       cajacierreapertura = CajaCierreApertura.findByCodigo(codigo, getSesion());
    }

    IDataSet datasetCajaCierreApertura = getDataSetCajaCierreApertura();
    if (cajacierreapertura != null) {
        cargarRegistroCajaCierreApertura(datasetCajaCierreApertura,
                         cajacierreapertura.getOIDInteger(),
                         cajacierreapertura.getCaja(),
                         cajacierreapertura.getFeccierreant(),
                         cajacierreapertura.getNuefecaper(),
                         cajacierreapertura.isActivo());
    }
    writeCliente(datasetCajaCierreApertura);
  }

  private IDataSet getDataSetCajaCierreApertura() {
    IDataSet dataset = new TDataSet();
    dataset.create("TCajaCierreApertura");
    dataset.fieldDef(new Field("oid_caja_ape_cie", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_caja", Field.INTEGER, 0));
    dataset.fieldDef(new Field("codigo_caja", Field.STRING, 15));
    dataset.fieldDef(new Field("desc_caja", Field.STRING, 50));
    dataset.fieldDef(new Field("fec_cie_ant", Field.STRING, 10));
    dataset.fieldDef(new Field("nue_fec_aper", Field.STRING, 10));
    dataset.fieldDef(new Field("nueva_fecha", Field.STRING, 10));
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
    return dataset;
  }

  private void cargarRegistroCajaCierreApertura(IDataSet dataset,
                         Integer oid_caja_ape_cie,
                         Caja caja,
                         Date fec_cie_ant,
                         Date nue_fec_aper,
                         Boolean activo) throws BaseException {
    dataset.append();
    dataset.fieldValue("oid_caja_ape_cie", oid_caja_ape_cie);
    dataset.fieldValue("oid_caja", caja.getOID());
    dataset.fieldValue("codigo_caja", caja.getCodigo());
    dataset.fieldValue("desc_caja", caja.getDescripcion());
    dataset.fieldValue("fec_cie_ant",Fecha.getddmmyyyy(fec_cie_ant));
    dataset.fieldValue("nue_fec_aper", Fecha.getddmmyyyy(nue_fec_aper));
    dataset.fieldValue("nueva_fecha", "");
    dataset.fieldValue("activo", activo);
  }
}
