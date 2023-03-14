package com.srn.erp.compras.op;

import java.util.Iterator;
import java.util.List;

import com.srn.erp.compras.bm.CotizacionProveedorCab;
import com.srn.erp.compras.bm.Proveedor;

import framework.applicarionServer.bl.Utils.Fecha;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerHelpCotizProv extends Operation {

  public TraerHelpCotizProv() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    IDataSet dsCotizProv = getDataSetCotizProv();
    traerCotizProv(dsCotizProv,mapaDatos);
    writeCliente(dsCotizProv);
  }

  private void traerCotizProv(IDataSet dataSet ,MapDatos mapaDatos) throws BaseException {

    Integer nroExtDesde = null;
    Integer nroExtHasta = null;
    java.util.Date fecEmiDesde = null;
    java.util.Date fecEmiHasta = null;
    java.util.Date fecVigAl = null;
    Proveedor proveedor = null;
    
    HashTableDatos condiciones = new HashTableDatos();
    
    if (mapaDatos.containsKey("nro_ext_desde"))
      condiciones.put("NRO_DESDE",mapaDatos.getInteger("nro_ext_desde"));
    if (mapaDatos.containsKey("nro_ext_hasta"))
      condiciones.put("NRO_HASTA",mapaDatos.getInteger("nro_ext_hasta"));
    if (mapaDatos.containsKey("fec_emi_desde"))
    	condiciones.put("FEC_EMI_DESDE",mapaDatos.getDate("fec_emi_desde"));
    if (mapaDatos.containsKey("fec_emi_hasta"))
    	condiciones.put("FEC_EMI_HASTA",mapaDatos.getDate("fec_emi_hasta"));    
    if (mapaDatos.containsKey("fec_vig_al"))
    	condiciones.put("FEC_VIG_AL",mapaDatos.getDate("fec_vig_al"));
    if (mapaDatos.containsKey("oid_proveedor"))
    	condiciones.put(Proveedor.NICKNAME,Proveedor.findByOidProxy(mapaDatos.getInteger("oid_proveedor"),getSesion()));    
    
    List listaCotizProv =
        CotizacionProveedorCab.getCotizacionesProvCab(condiciones,getSesion());
    Iterator iterCotizProvCab = listaCotizProv.iterator();
    while (iterCotizProvCab.hasNext()) {
      CotizacionProveedorCab cotizProvCab = (CotizacionProveedorCab) iterCotizProvCab.next();
      cargarRegistroCotizProvCab(dataSet,cotizProvCab);
    }

  }

  private IDataSet getDataSetCotizProv() {
    IDataSet dataset = new TDataSet();
    dataset.create("THelpCotizProv");
    dataset.fieldDef(new Field("oid_cotiz_prov_cab", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_sol_cotiz_prov", Field.INTEGER, 0));
    dataset.fieldDef(new Field("codigo_cotiz_prov", Field.STRING, 50));
    dataset.fieldDef(new Field("nro_cotiz_prov", Field.INTEGER, 0));
    dataset.fieldDef(new Field("codigo_solicitud_cotiz", Field.STRING, 50));
    dataset.fieldDef(new Field("oid_proveedor",Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_proveedor",Field.STRING, 50));
    dataset.fieldDef(new Field("rz_proveedor",Field.STRING, 100));
    dataset.fieldDef(new Field("vig_desde",Field.DATE, 0));
    dataset.fieldDef(new Field("vig_hasta",Field.DATE, 0));
    dataset.fieldDef(new Field("activo",Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("observacion",Field.STRING, 255));
    return dataset;
  }

  private void cargarRegistroCotizProvCab(IDataSet dataset,
		  		CotizacionProveedorCab cotizProvCab) throws BaseException {
    dataset.append();
    dataset.fieldValue("oid_cotiz_prov_cab", cotizProvCab.getOIDInteger());
    if (cotizProvCab.getSolicitud_cotiz_prov()!=null)
      dataset.fieldValue("oid_sol_cotiz_prov", cotizProvCab.getSolicitud_cotiz_prov().getOIDInteger());
    else
      dataset.fieldValue("oid_sol_cotiz_prov", 0);    	
    dataset.fieldValue("codigo_cotiz_prov", cotizProvCab.getCodigo());
    dataset.fieldValue("nro_cotiz_prov", cotizProvCab.getNroExt());
    if (cotizProvCab.getSolicitud_cotiz_prov()!=null)
      dataset.fieldValue("codigo_solicitud_cotiz", cotizProvCab.getSolicitud_cotiz_prov().getCodigo());
    else
      dataset.fieldValue("codigo_solicitud_cotiz", "");    	
    dataset.fieldValue("oid_proveedor",cotizProvCab.getProveedor().getOIDInteger());
    dataset.fieldValue("cod_proveedor",cotizProvCab.getProveedor().getCodigo());
    dataset.fieldValue("rz_proveedor",cotizProvCab.getProveedor().getRazonsocial());
    dataset.fieldValue("vig_desde",Fecha.getddmmyyyy(cotizProvCab.getVigencia_desde()));
    dataset.fieldValue("vig_hasta",Fecha.getddmmyyyy(cotizProvCab.getVigencia_hasta()));
    dataset.fieldValue("activo",cotizProvCab.isActivo());
    if (cotizProvCab.getComentario()!=null)
      dataset.fieldValue("observacion",cotizProvCab.getComentario());
    else
      dataset.fieldValue("observacion","");
  }

}
