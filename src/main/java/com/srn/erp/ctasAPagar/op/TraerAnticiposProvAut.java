package com.srn.erp.ctasAPagar.op;

import java.util.Iterator;

import com.srn.erp.compras.bm.Proveedor;
import com.srn.erp.ctasAPagar.bm.ComproProveedor;
import com.srn.erp.ctasAPagar.bm.ComproProveedorBase;
import com.srn.erp.general.bm.Moneda;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerAnticiposProvAut extends Operation {

  public TraerAnticiposProvAut() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {

    Proveedor      proveedor      = null;
    Moneda         moneda         = null;

    if (!mapaDatos.containsKey("oid_proveedor"))
      proveedor = null;
    else
      proveedor = Proveedor.findByOidProxy(mapaDatos.getInteger("oid_proveedor"),getSesion());
    
    
    if (!mapaDatos.containsKey("oid_moneda"))
      moneda = null;
    else
      moneda = Moneda.findByOidProxy(mapaDatos.getInteger("oid_moneda"),getSesion());


    IDataSet ds = getDataSetAutorizAnticipo();
    Iterator iterAntProv = 
    	ComproProveedor.getAnticiposProvAutori(proveedor,moneda,getSesion()).iterator();
    while (iterAntProv.hasNext()) {
    	ComproProveedorBase comproProvBase = (ComproProveedorBase) iterAntProv.next();
    	cargarRegistroAnticipoProv(ds,comproProvBase);
    }
    writeCliente(ds);
  }

  private IDataSet getDataSetAutorizAnticipo() {
    IDataSet dataset = new TDataSet();
    dataset.create("TConsultaAnticiposAutoriz");
    dataset.fieldDef(new Field("oid_cco",Field.INTEGER, 0));
    dataset.fieldDef(new Field("tc_ext",Field.STRING, 10));
    dataset.fieldDef(new Field("letra",Field.STRING, 1));
    dataset.fieldDef(new Field("lug_emi",Field.INTEGER, 0));
    dataset.fieldDef(new Field("nro_ext",Field.INTEGER, 0));
    dataset.fieldDef(new Field("fec_emision",Field.STRING,10));
    dataset.fieldDef(new Field("oid_tipo_cta_prov",Field.INTEGER, 0));
    dataset.fieldDef(new Field("tipo_cta_prov",Field.STRING,50));
    dataset.fieldDef(new Field("oid_proveedor",Field.INTEGER, 0));
    dataset.fieldDef(new Field("rs_proveedor",Field.STRING,50));
    dataset.fieldDef(new Field("tot_mon_ori",Field.CURRENCY,0));
    dataset.fieldDef(new Field("saldo_mon_ori",Field.CURRENCY,0));
    dataset.fieldDef(new Field("oid_moneda",Field.INTEGER,0));
    dataset.fieldDef(new Field("moneda",Field.STRING,30));
    dataset.fieldDef(new Field("comprobante",Field.STRING,30));
    dataset.fieldDef(new Field("cotiz_mon_ori",Field.CURRENCY,0));
    dataset.fieldDef(new Field("cotiz_mon_ext1",Field.CURRENCY,0));
    dataset.fieldDef(new Field("cotiz_mon_ext2",Field.CURRENCY,0));
    dataset.fieldDef(new Field("cotiz_mon_ori_co",Field.CURRENCY,0));
    dataset.fieldDef(new Field("cotiz_mon_ext1_co",Field.CURRENCY,0));
    dataset.fieldDef(new Field("cotiz_mon_ext2_co",Field.CURRENCY,0));
    dataset.fieldDef(new Field("oid_cco_ant_prov",Field.INTEGER,0));
    return dataset;
  }

  private void cargarRegistroAnticipoProv(IDataSet dataset,
                                          ComproProveedorBase comproAnticipoProv)
                                             throws BaseException {

    dataset.append();
    dataset.fieldValue("oid_cco", comproAnticipoProv.getOIDInteger());
    dataset.fieldValue("tc_ext", comproAnticipoProv.getTcExt());
    dataset.fieldValue("letra", comproAnticipoProv.getLetra());
    dataset.fieldValue("lug_emi", comproAnticipoProv.getLugarEmision().getLugemi());
    dataset.fieldValue("nro_ext", comproAnticipoProv.getNroExt());
    dataset.fieldValue("fec_emision", comproAnticipoProv.getEmision());
    dataset.fieldValue("oid_tipo_cta_prov", comproAnticipoProv.getTipoCtaCteProv().getOIDInteger());
    dataset.fieldValue("tipo_cta_prov", comproAnticipoProv.getTipoCtaCteProv().getDescripcion());
    dataset.fieldValue("oid_proveedor", comproAnticipoProv.getProveedor().getOIDInteger());
    dataset.fieldValue("rs_proveedor", comproAnticipoProv.getProveedor().getRazonsocial());
    dataset.fieldValue("tot_mon_ori", comproAnticipoProv.getTotMonedaOri());
    dataset.fieldValue("saldo_mon_ori", comproAnticipoProv.getSaldoAnticipoProveedor());
    dataset.fieldValue("oid_moneda", comproAnticipoProv.getMoneda().getOIDInteger());
    dataset.fieldValue("moneda",comproAnticipoProv.getMoneda().getCodigo());
    dataset.fieldValue("comprobante",comproAnticipoProv.getCodigo());
    dataset.fieldValue("cotiz_mon_ori", comproAnticipoProv.getCotizacion());
    dataset.fieldValue("cotiz_mon_ext1",comproAnticipoProv.getValorCotizExt1());
    dataset.fieldValue("cotiz_mon_ext2",comproAnticipoProv.getValorCotizExt2());
    dataset.fieldValue("cotiz_mon_ori_co",comproAnticipoProv.getCotizacion());
    dataset.fieldValue("cotiz_mon_ext1_co",comproAnticipoProv.getValorCotizExt1());
    dataset.fieldValue("cotiz_mon_ext2_co",comproAnticipoProv.getValorCotizExt2());
    dataset.fieldValue("oid_cco_ant_prov",comproAnticipoProv.getOIDInteger());
  }



}

