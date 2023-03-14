package com.srn.erp.stock.op;

import com.srn.erp.general.bm.Pais;
import com.srn.erp.general.bm.Provincia;
import com.srn.erp.stock.bm.AgrupadorEstadoStock;
import com.srn.erp.stock.bm.Deposito;
import com.srn.erp.stock.bm.EstadoDeposito;
import com.srn.erp.stock.bm.EstadoStock;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveDeposito extends Operation {

  public SaveDeposito() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    IDataSet dataset = mapaDatos.getDataSet("TDeposito");
    procesarRegistros(dataset);
  }

  private void procesarRegistros(IDataSet dataset) throws BaseException {
    dataset.first();
      while (!dataset.EOF()) {
        Deposito deposito = Deposito.findByOid(dataset.getInteger("oid_deposito"),getSesion());
        deposito.setOID(dataset.getInteger("oid_deposito"));
        deposito.setCodigo(dataset.getString("codigo"));
        deposito.setDescripcion(dataset.getString("descripcion"));
        deposito.setCompoDepo(dataset.getString("compo_depo"));
        deposito.setActivo(dataset.getBoolean("activo"));
        deposito.setCalleyNro(dataset.getString("calle_y_nro"));
        deposito.setLocalidad(dataset.getString("localidad"));
        deposito.setCodigoPostal(dataset.getString("codigo_postal"));
        deposito.setPais(Pais.findByOidProxy(dataset.getInteger("oid_pais"),getSesion()));
        deposito.setProvincia(Provincia.findByOidProxy(dataset.getInteger("oid_provincia"),getSesion()));
        

        IDataSet estados = dataset.getDataSet("TEstadosDeposito");
        estados.first();
        while (!estados.EOF()) {
          EstadoDeposito estadoDeposito = EstadoDeposito.findByOid(estados.getInteger("oid_estado_depo"),getSesion());
          estadoDeposito.setDeposito(deposito);
          estadoDeposito.setEstado_stock(EstadoStock.findByOidProxy(estados.getInteger("oid_estado_stock"),getSesion()));
          estadoDeposito.setAllow_saldo_neg(estados.getBoolean("allow_saldo_neg"));
          estadoDeposito.setAgrupadorEstadoStock(AgrupadorEstadoStock.findByOidProxy(estados.getInteger("oid_agrup_estado"),getSesion()));
          if (estados.getBoolean("activo").booleanValue()==false)
              estadoDeposito.delete();
          deposito.addEstado(estadoDeposito);
          estados.next();
        }
        addTransaccion(deposito);
        dataset.next();
    }
  }

}
