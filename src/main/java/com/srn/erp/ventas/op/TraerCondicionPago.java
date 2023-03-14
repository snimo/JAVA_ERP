package com.srn.erp.ventas.op;

import java.util.Iterator;

import com.srn.erp.compras.bm.CondicionVenta;
import com.srn.erp.general.bm.UnidadOrganizativa;
import com.srn.erp.tesoreria.bm.TarjetaCredito;
import com.srn.erp.tesoreria.bm.TipoValor;
import com.srn.erp.ventas.bm.CondPagoCheque;
import com.srn.erp.ventas.bm.CondPagoCuotas;
import com.srn.erp.ventas.bm.CondPagoTipoValor;
import com.srn.erp.ventas.bm.CondPagoUniOrg;
import com.srn.erp.ventas.bm.CondicionPago;
import com.srn.erp.ventas.bm.GrupoCondPago;
import com.srn.erp.ventas.bm.ListaPrecioCondPago;

import framework.applicarionServer.bm.Varios.Porcentaje;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerCondicionPago extends Operation {

  public TraerCondicionPago() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    CondicionPago condicionpago = null;
    if (mapaDatos.containsKey("oid")) {
       Integer oid = mapaDatos.getInteger("oid");
       condicionpago = CondicionPago.findByOid(oid, getSesion());
    }
    else {
       String codigo = mapaDatos.getString("codigo");
       condicionpago = CondicionPago.findByCodigo(codigo, getSesion());
    }

    IDataSet datasetCondicionPago = getDataSetCondicionPago();
    IDataSet datasetUniOrg = getDataSetCondPagoUniOrg();
    IDataSet datasetTipoVal = getDataSetCondPagoTipoValor();
    IDataSet datasetCuotas = getDataSetCondPagoCuotas();
    IDataSet datasetCheques = getDataSetCondPagoCheque();
    IDataSet datasetLPCondPago = getDataSetListaPrecioCondPago();


    if (condicionpago != null) {
        cargarRegistroCondicionPago(datasetCondicionPago,
                         condicionpago.getOIDInteger(),
                         condicionpago.getCodigo(),
                         condicionpago.getDescripcion(),
                         condicionpago.getComportamiento(),
                         condicionpago.getCondicion_vta(),
                         condicionpago.getPorc_desc(),
                         condicionpago.getPorc_reca(),
                         condicionpago.getTarjeta_credito(),
                         condicionpago.getGrupo_cond_pago(),
                         condicionpago.isActivo(),
                         new Boolean(condicionpago.isUsarEnVtas())
                         );

        Iterator iterUniOrgCondPago = condicionpago.getUniOrgCondPago().iterator();
        while (iterUniOrgCondPago.hasNext()) {
          CondPagoUniOrg condPagoUniOrg = (CondPagoUniOrg) iterUniOrgCondPago.next();
          cargarUniOrg(datasetUniOrg,
                       condPagoUniOrg.getOIDInteger(),condPagoUniOrg.getCondicion_pago(),condPagoUniOrg.getUnidad_organizativa());
        }

        Iterator iterTipoValorCondPago = condicionpago.getTipoValoresCondPago().iterator();
        while (iterTipoValorCondPago.hasNext()) {
          CondPagoTipoValor condPagoTipoValor = (CondPagoTipoValor) iterTipoValorCondPago.next();
          cargarRegistroCondPagoTipoValor(datasetTipoVal,
                       condPagoTipoValor.getOIDInteger(),
                       condPagoTipoValor.getCondicion_pago(),
                       condPagoTipoValor.getTipo_valor(),
                       condPagoTipoValor.isSugerir()
                       );
        }

        Iterator iterCuotasCondPago = condicionpago.getCuotasCondPago().iterator();
        while (iterCuotasCondPago.hasNext()) {
          CondPagoCuotas condPagoCuotas = (CondPagoCuotas) iterCuotasCondPago.next();
          cargarRegistroCondPagoCuotas(datasetCuotas,
                                       condPagoCuotas.getOIDInteger(),
                                       condPagoCuotas.getCondicion_pago(),
                                       condPagoCuotas.getCuota_desde(),
                                       condPagoCuotas.getCuota_hasta(),
                                       condPagoCuotas.getPorc_dto(),
                                       condPagoCuotas.getPorc_recar());
        }

        Iterator iterChequesCondPago = condicionpago.getChequesCondPago().iterator();
        while (iterChequesCondPago.hasNext()) {
          CondPagoCheque condPagoCheque = (CondPagoCheque) iterChequesCondPago.next();
          cargarRegistroCondPagoCheque(datasetCheques,
                                       condPagoCheque.getOIDInteger(),
                                       condPagoCheque.getCondicion_pago(),
                                       condPagoCheque.getDia_desde(),
                                       condPagoCheque.getDia_hasta(),
                                       condPagoCheque.getPorc_dto(),
                                       condPagoCheque.getPorc_recar());
        }
        
        Iterator iterLPCondPago = condicionpago.getListasPreciosCondPago().iterator();
        while (iterLPCondPago.hasNext()) {
          ListaPrecioCondPago listaPrecioCondPago = (ListaPrecioCondPago) iterLPCondPago.next();
          cargarRegistroListaPrecioCondPago(datasetLPCondPago,condicionpago,listaPrecioCondPago);
        }
        


    }
    writeCliente(datasetCondicionPago);
    writeCliente(datasetUniOrg);
    writeCliente(datasetTipoVal);
    writeCliente(datasetCuotas);
    writeCliente(datasetCheques);
    writeCliente(datasetLPCondPago);


  }

  private IDataSet getDataSetCondicionPago() {
    IDataSet dataset = new TDataSet();
    dataset.create("TCondicionPago");
    dataset.fieldDef(new Field("oid_cond_pago", Field.INTEGER, 0));
    dataset.fieldDef(new Field("codigo", Field.STRING, 30));
    dataset.fieldDef(new Field("descripcion", Field.STRING, 50));
    dataset.fieldDef(new Field("comportamiento", Field.STRING, 20));
    dataset.fieldDef(new Field("oid_cond_vta", Field.INTEGER, 0));
    dataset.fieldDef(new Field("porc_dto", Field.CURRENCY, 0));
    dataset.fieldDef(new Field("porc_reca", Field.CURRENCY, 0));
    dataset.fieldDef(new Field("oid_tar_credito", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_grupo_cp", Field.INTEGER, 0));
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("usar_en_vtas", Field.BOOLEAN, 0));
    return dataset;
  }

  private void cargarRegistroCondicionPago(IDataSet dataset,
                         Integer oid_cond_pago,
                         String codigo,
                         String descripcion,
                         String comportamiento,
                         CondicionVenta condVta,
                         Porcentaje porc_dto,
                         Porcentaje porc_reca,
                         TarjetaCredito tarCredito,
                         GrupoCondPago grupoCP,
                         Boolean activo,
                         Boolean usarEnVtas) {
    dataset.append();
    dataset.fieldValue("oid_cond_pago", oid_cond_pago);
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("descripcion", descripcion);
    dataset.fieldValue("comportamiento", comportamiento);
    if (condVta!=null)
      dataset.fieldValue("oid_cond_vta", condVta.getOIDInteger());
    else
      dataset.fieldValue("oid_cond_vta", 0);
    dataset.fieldValue("porc_dto", porc_dto.doubleValue());
    dataset.fieldValue("porc_reca", porc_reca.doubleValue());
    if (tarCredito!=null)
      dataset.fieldValue("oid_tar_credito", tarCredito.getOIDInteger());
    else
      dataset.fieldValue("oid_tar_credito", 0);
    dataset.fieldValue("oid_grupo_cp", grupoCP.getOID());
    dataset.fieldValue("activo", activo);
    dataset.fieldValue("usar_en_vtas",usarEnVtas);
  }

  private void cargarUniOrg(IDataSet dataset,
                            Integer oid_cp_uni_org,
                            CondicionPago condPago,
                            UnidadOrganizativa uniOrg) throws BaseException {
    dataset.append();
    dataset.fieldValue("oid_cp_uni_org", oid_cp_uni_org);
    dataset.fieldValue("oid_cond_pago", condPago.getOIDInteger());
    dataset.fieldValue("oid_uni_org", uniOrg.getOIDInteger());
    dataset.fieldValue("cod_uni_org", uniOrg.getCodigo());
    dataset.fieldValue("desc_uni_org", uniOrg.getDescripcion());
    dataset.fieldValue("activo", new Boolean(true));

  }


  private IDataSet getDataSetCondPagoUniOrg() {
    IDataSet dataset = new TDataSet();
    dataset.create("TCondPagoUniOrg");
    dataset.fieldDef(new Field("oid_cp_uni_org", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_cond_pago", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_uni_org", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_uni_org", Field.STRING, 30));
    dataset.fieldDef(new Field("desc_uni_org", Field.STRING, 50));
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
    return dataset;
  }

  private IDataSet getDataSetCondPagoTipoValor() {
    IDataSet dataset = new TDataSet();
    dataset.create("TCondPagoTipoValor");
    dataset.fieldDef(new Field("oid_cond_pago_tv", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_cond_pago", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_tipo_valor", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_tipo_valor", Field.STRING,50));
    dataset.fieldDef(new Field("desc_tipo_valor", Field.INTEGER, 100));
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("sugerir", Field.BOOLEAN, 0));
    return dataset;
  }

  private void cargarRegistroCondPagoTipoValor(IDataSet dataset,
                         Integer oid_cond_pago_tv,
                         CondicionPago condPago,
                         TipoValor tipoValor,
                         boolean sugerir) throws BaseException {
    dataset.append();
    dataset.fieldValue("oid_cond_pago_tv", oid_cond_pago_tv);
    dataset.fieldValue("oid_cond_pago", condPago.getOIDInteger());
    dataset.fieldValue("oid_tipo_valor", tipoValor.getOIDInteger());
    dataset.fieldValue("cod_tipo_valor", tipoValor.getCodigo());
    dataset.fieldValue("desc_tipo_valor", tipoValor.getDescripcion());
    dataset.fieldValue("activo", new Boolean(true));
    dataset.fieldValue("sugerir", new Boolean(sugerir));
  }

  private IDataSet getDataSetCondPagoCuotas() {
    IDataSet dataset = new TDataSet();
    dataset.create("TCondPagoCuotas");
    dataset.fieldDef(new Field("oid_cp_cuotas", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_cond_pago", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cuota_desde", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cuota_hasta", Field.INTEGER, 0));
    dataset.fieldDef(new Field("porc_dto", Field.CURRENCY, 0));
    dataset.fieldDef(new Field("porc_recar", Field.CURRENCY, 0));
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
    return dataset;
  }

  private void cargarRegistroCondPagoCuotas(IDataSet dataset,
                         Integer oid_cp_cuotas,
                         CondicionPago condPago,
                         Integer cuota_desde,
                         Integer cuota_hasta,
                         Porcentaje porc_dto,
                         Porcentaje porc_recar) {
    dataset.append();
    dataset.fieldValue("oid_cp_cuotas", oid_cp_cuotas);
    dataset.fieldValue("oid_cond_pago", condPago.getOIDInteger());
    dataset.fieldValue("cuota_desde", cuota_desde);
    dataset.fieldValue("cuota_hasta", cuota_hasta);
    dataset.fieldValue("porc_dto", porc_dto);
    dataset.fieldValue("porc_recar", porc_recar);
    dataset.fieldValue("activo", new Boolean(true));
  }

  private IDataSet getDataSetCondPagoCheque() {
    IDataSet dataset = new TDataSet();
    dataset.create("TCondPagoCheque");
    dataset.fieldDef(new Field("oid_cp_cheque", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_cond_pago", Field.INTEGER, 0));
    dataset.fieldDef(new Field("dia_desde", Field.INTEGER, 0));
    dataset.fieldDef(new Field("dia_hasta", Field.INTEGER, 0));
    dataset.fieldDef(new Field("porc_dto", Field.CURRENCY, 0));
    dataset.fieldDef(new Field("porc_recar", Field.CURRENCY, 0));
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
    return dataset;
  }

  private void cargarRegistroCondPagoCheque(IDataSet dataset,
                         Integer oid_cp_cheque,
                         CondicionPago condPago,
                         Integer dia_desde,
                         Integer dia_hasta,
                         Porcentaje porc_dto,
                         Porcentaje porc_recar) {
    dataset.append();
    dataset.fieldValue("oid_cp_cheque", oid_cp_cheque);
    dataset.fieldValue("oid_cond_pago", condPago.getOIDInteger());
    dataset.fieldValue("dia_desde", dia_desde);
    dataset.fieldValue("dia_hasta", dia_hasta);
    dataset.fieldValue("porc_dto", porc_dto);
    dataset.fieldValue("porc_recar", porc_recar);
    dataset.fieldValue("activo",new Boolean(true));

  }
  
  private IDataSet getDataSetListaPrecioCondPago() {
    IDataSet dataset = new TDataSet();
    dataset.create("TListaPrecioCondPago");
    dataset.fieldDef(new Field("oid_lp_cp", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_cond_pago", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_precio_cab", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_precio_cab", Field.STRING, 50));
    dataset.fieldDef(new Field("desc_precio_cab", Field.STRING, 100));
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
    return dataset;
  }

  private void cargarRegistroListaPrecioCondPago(IDataSet dataset,
                         CondicionPago condPago,
                         ListaPrecioCondPago listaPrecioCondPago) throws BaseException {
    dataset.append();
    dataset.fieldValue("oid_lp_cp", listaPrecioCondPago.getOIDInteger());
    dataset.fieldValue("oid_cond_pago", condPago.getOIDInteger());
    dataset.fieldValue("oid_precio_cab", listaPrecioCondPago.getListaprecio().getOIDInteger());
    dataset.fieldValue("cod_precio_cab", listaPrecioCondPago.getListaprecio().getCodigo());
    dataset.fieldValue("desc_precio_cab", listaPrecioCondPago.getListaprecio().getDescripcion());
    dataset.fieldValue("activo", new Boolean(true));
  }
  





}
