package com.srn.erp.compras.op;

import java.util.Iterator;
import java.util.List;

import com.srn.erp.compras.bm.Proveedor;
import com.srn.erp.compras.bm.SolicitudCotizProvCab;

import framework.applicarionServer.bl.Utils.Fecha;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerHelpSolCotizProv extends Operation {

  public TraerHelpSolCotizProv() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    IDataSet dsSolCotizProv = getDataSetSolCotizProv();
    traerSolCotizProv(dsSolCotizProv,mapaDatos);
    writeCliente(dsSolCotizProv);
  }

  private void traerSolCotizProv(IDataSet dataSet ,MapDatos mapaDatos) throws BaseException {

    HashTableDatos condiciones = new HashTableDatos();
    
    if (mapaDatos.containsKey("nro_ext_desde"))
      condiciones.put("NRO_DESDE",mapaDatos.getInteger("nro_ext_desde"));
    if (mapaDatos.containsKey("nro_ext_hasta"))
      condiciones.put("NRO_HASTA",mapaDatos.getInteger("nro_ext_hasta"));
    if (mapaDatos.containsKey("fec_emi_desde"))
    	condiciones.put("FEC_EMI_DESDE",mapaDatos.getDate("fec_emi_desde"));
    if (mapaDatos.containsKey("fec_emi_hasta"))
    	condiciones.put("FEC_EMI_HASTA",mapaDatos.getDate("fec_emi_hasta"));    
    if (mapaDatos.containsKey("fec_ent_desde"))
    	condiciones.put("FEC_ENT_DESDE",mapaDatos.getDate("fec_ent_desde"));
    if (mapaDatos.containsKey("fec_ent_hasta"))
    	condiciones.put("FEC_ENT_HASTA",mapaDatos.getDate("fec_ent_hasta"));
    if (mapaDatos.containsKey("oid_proveedor"))
    	condiciones.put(Proveedor.NICKNAME,Proveedor.findByOidProxy(mapaDatos.getInteger("oid_proveedor"),getSesion()));
    
    List listaSolCotizProv =
        SolicitudCotizProvCab.getSolicitudesCotizProvCab(condiciones,getSesion());
    Iterator iterSolCotizProvCab = listaSolCotizProv.iterator();
    while (iterSolCotizProvCab.hasNext()) {
      SolicitudCotizProvCab solCotizProvCab = (SolicitudCotizProvCab) iterSolCotizProvCab.next();
      cargarRegistroSolCotizProvCab(dataSet,solCotizProvCab);
    }

  }

  private IDataSet getDataSetSolCotizProv() {
    IDataSet dataset = new TDataSet();
    dataset.create("THelpSolicitudCotizProv");
    dataset.fieldDef(new Field("oid_cco_sol_cotiz", Field.INTEGER, 0));
    dataset.fieldDef(new Field("fec_tope_ent_sol", Field.DATE, 0));
    dataset.fieldDef(new Field("observacion", Field.STRING, 255));
    dataset.fieldDef(new Field("obs_detalladas", Field.STRING, 5000));
    dataset.fieldDef(new Field("comprobante", Field.STRING, 50));
    dataset.fieldDef(new Field("fec_emision", Field.DATE, 10));
    dataset.fieldDef(new Field("nro", Field.INTEGER,0));
    return dataset;
  }

  private void cargarRegistroSolCotizProvCab(IDataSet dataset,
		  		SolicitudCotizProvCab solCotizProvCab) throws BaseException {
    dataset.append();
    dataset.fieldValue("oid_cco_sol_cotiz", solCotizProvCab.getOIDInteger());
    dataset.fieldValue("fec_tope_ent_sol",Fecha.getddmmyyyy(solCotizProvCab.getFec_tope_ent_sol()));
    dataset.fieldValue("observacion", solCotizProvCab.getComentario());
    dataset.fieldValue("obs_detalladas", solCotizProvCab.getObs_detalladas());
    dataset.fieldValue("comprobante", solCotizProvCab.getCodigo());
    dataset.fieldValue("fec_emision", Fecha.getddmmyyyy(solCotizProvCab.getEmision()));
    dataset.fieldValue("nro", solCotizProvCab.getNroExt());
  }

}
