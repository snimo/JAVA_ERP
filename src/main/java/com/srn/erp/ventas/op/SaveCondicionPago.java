package com.srn.erp.ventas.op;

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
import com.srn.erp.ventas.bm.ListaPrecios;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveCondicionPago extends Operation {

  public SaveCondicionPago() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    IDataSet dataset = mapaDatos.getDataSet("TCondicionPago");
    procesarRegistros(dataset);
  }

  private void procesarRegistros(IDataSet dataset) throws BaseException {
    dataset.first();
      while (!dataset.EOF()) {
        CondicionPago condicionpago = CondicionPago.findByOid(dataset.getInteger("oid_cond_pago"),getSesion());
        condicionpago.setOID(dataset.getInteger("oid_cond_pago"));
        condicionpago.setCodigo(dataset.getString("codigo"));
        condicionpago.setDescripcion(dataset.getString("descripcion"));
        condicionpago.setComportamiento(dataset.getString("comportamiento"));
        CondicionVenta condVta = CondicionVenta.findByOid(dataset.getInteger("oid_cond_vta"),getSesion());
        condicionpago.setCondicion_vta(condVta);
        condicionpago.setPorc_desc(dataset.getPorcentaje("porc_dto"));
        condicionpago.setPorc_reca(dataset.getPorcentaje("porc_reca"));
        condicionpago.setTarjeta_credito(TarjetaCredito.findByOidProxy(dataset.getInteger("oid_tar_credito"),getSesion()));
        condicionpago.setGrupo_cond_pago(GrupoCondPago.findByOidProxy(dataset.getInteger("oid_grupo_cp"),getSesion()));
        condicionpago.setActivo(dataset.getBoolean("activo"));
        condicionpago.setUsarEnVtas(dataset.getBoolean("usar_en_vtas").booleanValue());

        IDataSet dsUniOrgCondPago = dataset.getDataSet("TCondPagoUniOrg");
        dsUniOrgCondPago.first();
        while (!dsUniOrgCondPago.EOF()) {
          CondPagoUniOrg condPagoUniOrg =
              CondPagoUniOrg.findByOid(dsUniOrgCondPago.getInteger("oid_cp_uni_org"),getSesion());
          condPagoUniOrg.setCondicion_pago(condicionpago);
          condPagoUniOrg.setUnidad_organizativa(UnidadOrganizativa.findByOidProxy(dsUniOrgCondPago.getInteger("oid_uni_org"),getSesion()));
          if (!dsUniOrgCondPago.getBoolean("activo").booleanValue())
          	condPagoUniOrg.delete();
          condicionpago.addUniOrgCondPago(condPagoUniOrg);
          dsUniOrgCondPago.next();
        }

        IDataSet dsTipoValCondPago = dataset.getDataSet("TCondPagoTipoValor");
        dsTipoValCondPago.first();
        while (!dsTipoValCondPago.EOF()) {
          CondPagoTipoValor condpagotipovalor = CondPagoTipoValor.findByOid(dsTipoValCondPago.getInteger("oid_cond_pago_tv"),getSesion());
          condpagotipovalor.setCondicion_pago(condicionpago);
          condpagotipovalor.setTipo_valor(TipoValor.findByOidProxy(dsTipoValCondPago.getInteger("oid_tipo_valor"),getSesion()));
          condpagotipovalor.setSugerir(dsTipoValCondPago.getBoolean("sugerir").booleanValue());
          if (dsTipoValCondPago.getBoolean("activo").booleanValue()==false)
          		condpagotipovalor.delete();
          
          condicionpago.addTipoValorCondPago(condpagotipovalor);
          dsTipoValCondPago.next();
        }

        IDataSet dsCuotasCondPago = dataset.getDataSet("TCondPagoCuotas");
        dsCuotasCondPago.first();
        while (!dsCuotasCondPago.EOF()) {
          CondPagoCuotas condpagocuotas = CondPagoCuotas.findByOid(dsCuotasCondPago.getInteger("oid_cp_cuotas"),getSesion());
          condpagocuotas.setCondicion_pago(condicionpago);
          condpagocuotas.setCuota_desde(dsCuotasCondPago.getInteger("cuota_desde"));
          condpagocuotas.setCuota_hasta(dsCuotasCondPago.getInteger("cuota_hasta"));
          condpagocuotas.setPorc_dto(dsCuotasCondPago.getPorcentaje("porc_dto"));
          condpagocuotas.setPorc_recar(dsCuotasCondPago.getPorcentaje("porc_recar"));
          
          if (!dsCuotasCondPago.getBoolean("activo").booleanValue())
          	condpagocuotas.delete();
          
          condicionpago.addCuotaCondPago(condpagocuotas);
          dsCuotasCondPago.next();
        }

        IDataSet dsChequesCondPago = dataset.getDataSet("TCondPagoCheque");
        dsChequesCondPago.first();
        while (!dsChequesCondPago.EOF()) {

          CondPagoCheque condpagocheque = CondPagoCheque.findByOid(dsChequesCondPago.getInteger("oid_cp_cheque"),getSesion());
          condpagocheque.setCondicion_pago(condicionpago);
          condpagocheque.setDia_desde(dsChequesCondPago.getInteger("dia_desde"));
          condpagocheque.setDia_hasta(dsChequesCondPago.getInteger("dia_hasta"));
          condpagocheque.setPorc_dto(dsChequesCondPago.getPorcentaje("porc_dto"));
          condpagocheque.setPorc_recar(dsChequesCondPago.getPorcentaje("porc_recar"));
          if (dsChequesCondPago.getBoolean("activo").booleanValue()==false)
          	condpagocheque.delete();
          condicionpago.addChequeCondPago(condpagocheque);

          dsChequesCondPago.next();
        }
        
        IDataSet dsLPCondPago = dataset.getDataSet("TListaPrecioCondPago");
        dsLPCondPago.first();
        while (!dsLPCondPago.EOF()) {

          ListaPrecioCondPago listaPrecioCondPago = ListaPrecioCondPago.findByOid(dsLPCondPago.getInteger("oid_lp_cp"),getSesion());
          listaPrecioCondPago.setCondicionpago(condicionpago);
          listaPrecioCondPago.setListaprecio(ListaPrecios.findByOidProxy(dsLPCondPago.getInteger("oid_precio_cab"),getSesion()));
          if (dsLPCondPago.getBoolean("activo").booleanValue()==false)
          	listaPrecioCondPago.delete();
          
          condicionpago.addListaPrecioCondPago(listaPrecioCondPago);
          

          dsLPCondPago.next();
        }
        



        addTransaccion(condicionpago);
        dataset.next();
    }
  }

}
