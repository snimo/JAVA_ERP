package com.srn.erp.compras.op;

import java.util.Iterator;
import java.util.List;

import com.srn.erp.compras.bm.RequisicionCab;
import com.srn.erp.compras.bm.SectorCompra;

import framework.applicarionServer.bl.Utils.Fecha;
import framework.applicarionServer.bm.Seguridad.Usuario;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerHelpRequisiciones extends Operation {

  public TraerHelpRequisiciones() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    IDataSet dsRequisiciones = getDataSetRequisiciones();
    traerRequisiciones(dsRequisiciones,mapaDatos);
    writeCliente(dsRequisiciones);
  }

  private void traerRequisiciones(IDataSet dataSet ,MapDatos mapaDatos) throws BaseException {

    Integer nroExtDesde = null;
    Integer nroExtHasta = null;
    java.util.Date fecDesde = null;
    java.util.Date fecHasta = null;
    Usuario usuario = null;
    SectorCompra sectorCompra = null;

    if (mapaDatos.containsKey("nro_ext_desde"))
      nroExtDesde = mapaDatos.getInteger("nro_ext_desde");
    if (mapaDatos.containsKey("nro_ext_hasta"))
      nroExtHasta = mapaDatos.getInteger("nro_ext_hasta");
    if (mapaDatos.containsKey("fec_desde"))
      fecDesde = mapaDatos.getDate("fec_desde");
    if (mapaDatos.containsKey("fec_hasta"))
      fecHasta = mapaDatos.getDate("fec_hasta");
    if (mapaDatos.containsKey("oid_usuario"))
      usuario = Usuario.findByOidProxy(mapaDatos.getInteger("oid_usuario"),getSesion());
    if (mapaDatos.containsKey("oid_sector"))
        sectorCompra = SectorCompra.findByOidProxy(mapaDatos.getInteger("oid_sector"),getSesion());
    
    List listaRequisiciones =
        RequisicionCab.getRequisiciones(nroExtDesde,nroExtHasta,fecDesde,fecHasta,usuario,sectorCompra,getSesion());
    Iterator iterRequisiciones = listaRequisiciones.iterator();
    while (iterRequisiciones.hasNext()) {
      RequisicionCab requisicionCab = (RequisicionCab) iterRequisiciones.next();
      cargarRegistroRequisicion(dataSet,requisicionCab);
    }

  }

  private IDataSet getDataSetRequisiciones() {
    IDataSet dataset = new TDataSet();
    dataset.create("THelpRequisiciones");
    dataset.fieldDef(new Field("oid", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_cco", Field.INTEGER, 0));
    dataset.fieldDef(new Field("comprobante", Field.STRING, 50));
    dataset.fieldDef(new Field("fec_emision", Field.STRING, 10));
    dataset.fieldDef(new Field("emisor", Field.STRING, 100));
    dataset.fieldDef(new Field("sector", Field.STRING, 100));
    dataset.fieldDef(new Field("nro_ext", Field.INTEGER,0));
    dataset.fieldDef(new Field("activo", Field.BOOLEAN,0));
    return dataset;
  }

  private void cargarRegistroRequisicion(IDataSet dataset,
                                         RequisicionCab requisicionCab) throws BaseException {
    dataset.append();
    dataset.fieldValue("oid", requisicionCab.getOID());
    dataset.fieldValue("oid_cco", requisicionCab.getOID());
    dataset.fieldValue("comprobante", requisicionCab.getCodigo());
    dataset.fieldValue("fec_emision", Fecha.getddmmyyyy(requisicionCab.getEmision()));
    dataset.fieldValue("emisor", requisicionCab.getUsuario().getApellido()+" - "+requisicionCab.getUsuario().getNombre());
    dataset.fieldValue("sector", requisicionCab.getSectorCompra().getDescripcion());
    dataset.fieldValue("nro_ext", requisicionCab.getNroExt());     
    dataset.fieldValue("activo", requisicionCab.isActivo());
  }

}
