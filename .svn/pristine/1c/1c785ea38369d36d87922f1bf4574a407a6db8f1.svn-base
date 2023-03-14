package com.srn.erp.compras.op;

import com.srn.erp.compras.bm.CotizacionProveedorCab;
import com.srn.erp.compras.bm.OrdenDeCompraCab;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class ValidarCotizProv extends Operation { 

  public ValidarCotizProv() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    CotizacionProveedorCab cotizProvCab = null;
    String identificador = mapaDatos.getString("identificador");
   // ordendecompracab = OrdenDeCompraCab.getOrdeDeCompra(identificador,getSesion());
  //  IDataSet dsValOC = getDataSetOrdenDeCompraCab();
  //  if (ordendecompracab != null)  
  //      cargarRegistroOrdenDeCompraCab(dsValOC,ordendecompracab);
    //writeCliente(dsValOC);
  }

  private IDataSet getDataSetOrdenDeCompraCab() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TValidadorOC");
    dataset.fieldDef(new Field("oid_oc", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("codigo", Field.STRING, 50));
    dataset.fieldDef(new Field("oid_tc", Field.INTEGER, 0));
    dataset.fieldDef(new Field("letra", Field.STRING, 1));
    dataset.fieldDef(new Field("oid_lug_emi", Field.INTEGER, 0));
    dataset.fieldDef(new Field("nro_ext", Field.INTEGER, 0));
    dataset.fieldDef(new Field("fec_emi", Field.DATE, 0));
    dataset.fieldDef(new Field("oid_prov", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_prov", Field.STRING, 50));
    dataset.fieldDef(new Field("rs_prov", Field.STRING, 100));
    dataset.fieldDef(new Field("anulado", Field.BOOLEAN, 0));
    return dataset;
  }

  private void cargarRegistroOrdenDeCompraCab(IDataSet dataset, 
                         OrdenDeCompraCab ordenCompra) throws BaseException {
	    dataset.append(); 
	    dataset.fieldValue("oid_oc", ordenCompra.getOIDInteger()); 
	    dataset.fieldValue("codigo", ordenCompra.getCodigo());
	    dataset.fieldValue("oid_tc", ordenCompra.getTipoCompro().getOIDInteger());
	    dataset.fieldValue("letra", ordenCompra.getLetra());
	    dataset.fieldValue("oid_lug_emi", ordenCompra.getLugarEmision().getOIDInteger());
	    dataset.fieldValue("nro_ext", ordenCompra.getNroExt());
	    dataset.fieldValue("fec_emi", ordenCompra.getEmision());
	    dataset.fieldValue("oid_prov", ordenCompra.getProveedor().getOIDInteger());
	    dataset.fieldValue("cod_prov", ordenCompra.getProveedor().getCodigo());
	    dataset.fieldValue("rs_prov", ordenCompra.getProveedor().getRazonsocial());
	    dataset.fieldValue("anulado", new Boolean(!ordenCompra.isActivo().booleanValue()));
  }
}
