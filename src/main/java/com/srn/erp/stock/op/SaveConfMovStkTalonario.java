package com.srn.erp.stock.op;

import com.srn.erp.general.bm.Talonario;
import com.srn.erp.stock.bm.ConfMovStkTalonario;
import com.srn.erp.stock.bm.Deposito;
import com.srn.erp.stock.bm.EstadoStock;
import com.srn.erp.stock.bm.MovStockTalonarioDeposito;
import com.srn.erp.stock.bm.TipoConfMovStkTalonario;
import com.srn.erp.stock.bm.UbiDepoHabTalonario;
import com.srn.erp.stock.bm.UbicacionDeposito;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveConfMovStkTalonario extends Operation {



  public SaveConfMovStkTalonario() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    IDataSet dataset = mapaDatos.getDataSet("TConfMovStkTalonario");
    procesarRegistros(dataset);
  }

  private void procesarRegistros(IDataSet dataset) throws BaseException {

    boolean borrarTipos = false;
    boolean borrarMov = false;
    boolean borrarUbi = false;
    dataset.first();
      while (!dataset.EOF()) {
        ConfMovStkTalonario confmovstktalonario = ConfMovStkTalonario.findByOid(dataset.getInteger("oid_conf_mov_stk"),getSesion());
        confmovstktalonario.setOID(dataset.getInteger("oid_conf_mov_stk"));
        confmovstktalonario.setTalonario(Talonario.findByOidProxy(dataset.getInteger("oid_talonario"),getSesion()));
        confmovstktalonario.setActivo(dataset.getBoolean("activo"));
        if (confmovstktalonario.isActivo().booleanValue()==false) {
          confmovstktalonario.delete();
          borrarTipos = true;
        }
        else borrarTipos = false;
        setRefreshObjNeg(dataset.getInteger("oid_talonario"));
        IDataSet dsTipoConfMovStk = dataset.getDataSet("TTipoConfMovStk");
        dsTipoConfMovStk.first();
        while (!dsTipoConfMovStk.EOF()) {
          TipoConfMovStkTalonario tipoConfMovStkTal =
             TipoConfMovStkTalonario.findByOid(dsTipoConfMovStk.getInteger("oid_tipo_conf_mov"),getSesion());
          tipoConfMovStkTal.setConf_mov_stk(confmovstktalonario);
          tipoConfMovStkTal.setCodigo(dsTipoConfMovStk.getString("codigo"));
          tipoConfMovStkTal.setDescripcion(dsTipoConfMovStk.getString("descripcion"));
          tipoConfMovStkTal.setTipoMovimiento(dsTipoConfMovStk.getString("tipo_mov"));
          if (borrarTipos == true)
            tipoConfMovStkTal.setActivo(new Boolean(false));
          else
            tipoConfMovStkTal.setActivo(dsTipoConfMovStk.getBoolean("activo"));
          if (tipoConfMovStkTal.isActivo().booleanValue()==false) {
            tipoConfMovStkTal.delete();
            borrarMov = true;
          }
          else borrarMov = false;
          confmovstktalonario.addTipoConfMovStk(tipoConfMovStkTal);
          IDataSet dsMovStkTal = dsTipoConfMovStk.getDataSet("TMovStkTalonario");
          dsMovStkTal.first();
          while (!dsMovStkTal.EOF()) {
            MovStockTalonarioDeposito movStkTalDepo =
                MovStockTalonarioDeposito.findByOid(dsMovStkTal.getInteger("oid_mov_stk_tal"),getSesion());
            movStkTalDepo.setTipo_conf_mov(tipoConfMovStkTal);
            movStkTalDepo.setSecu(dsMovStkTal.getInteger("secu"));
            movStkTalDepo.setDeposito(Deposito.findByOidProxy(dsMovStkTal.getInteger("oid_deposito"),getSesion()));
            movStkTalDepo.setEstado_stock(EstadoStock.findByOidProxy(dsMovStkTal.getInteger("oid_estado_stock"),getSesion()));
            movStkTalDepo.setTipo_movimiento(dsMovStkTal.getString("tipo_movimiento"));
            movStkTalDepo.setAfectaStockFisico(dsMovStkTal.getBoolean("afecta_stk_fisico"));
            if (borrarMov == true)
              movStkTalDepo.setActivo(new Boolean(false));
            else
              movStkTalDepo.setActivo(dsMovStkTal.getBoolean("activo"));
            if (movStkTalDepo.isActivo().booleanValue()==false) {
              movStkTalDepo.delete();
              borrarUbi = true;
            }
            else borrarUbi = false;
            tipoConfMovStkTal.addMoviStockTalonario(movStkTalDepo);
            IDataSet dsUbicacionDeposito = dsMovStkTal.getDataSet("TUbicacionDeposito");
            dsUbicacionDeposito.first();
            while (!dsUbicacionDeposito.EOF()) {
              UbiDepoHabTalonario ubiDepoHabTal = UbiDepoHabTalonario.findByOid(dsUbicacionDeposito.getInteger("oid_ubi_depo_tal"),getSesion());
              ubiDepoHabTal.setMov_stk_tal(movStkTalDepo);
              ubiDepoHabTal.setUbicacion_deposito(UbicacionDeposito.findByOidProxy(dsUbicacionDeposito.getInteger("oid_ubi_depo"),getSesion()));
              ubiDepoHabTal.setHabilitado(dsUbicacionDeposito.getBoolean("habilitado"));
              ubiDepoHabTal.setIncluye_hijos(dsUbicacionDeposito.getBoolean("incluye_hijos"));
              ubiDepoHabTal.setUsar_por_defecto(dsUbicacionDeposito.getBoolean("usar_por_defecto"));
              if (borrarUbi == true)
                ubiDepoHabTal.setActivo(new Boolean(false));
              else
                ubiDepoHabTal.setActivo(dsUbicacionDeposito.getBoolean("activo"));
              if (ubiDepoHabTal.isActivo().booleanValue() == false)
                ubiDepoHabTal.delete();
              movStkTalDepo.addUbicacionHabilitada(ubiDepoHabTal);
              dsUbicacionDeposito.next();
            }

            dsMovStkTal.next();
          }
          dsTipoConfMovStk.next();
        }
        addTransaccion(confmovstktalonario);
        dataset.next();
    }
  }


}
