package com.srn.erp.pagos.op;

import com.srn.erp.pagos.bm.FormaPago;
import com.srn.erp.pagos.bm.TipoValorFormaPago;
import com.srn.erp.tesoreria.bm.TipoValor;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveFormaPago extends Operation {

  public SaveFormaPago() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    IDataSet dataset = mapaDatos.getDataSet("TFormaPago");
    procesarRegistros(dataset);
  }

  private void procesarRegistros(IDataSet dataset) throws BaseException {
    dataset.first();
      while (!dataset.EOF()) {
        FormaPago formapago = FormaPago.findByOid(dataset.getInteger("oid_forma_pago"),getSesion());
        formapago.setOID(dataset.getInteger("oid_forma_pago"));
        formapago.setCodigo(dataset.getString("codigo"));
        formapago.setDescripcion(dataset.getString("descripcion"));
        

        formapago.setActivo(dataset.getBoolean("activo"));

        // Recorrer los Tipos de Valores
        IDataSet dataSetTiposValor = dataset.getDataSet("TTipoValorFormaPago");
        dataSetTiposValor.first();

        while (!dataSetTiposValor.EOF()) {
          TipoValorFormaPago tipoValorFormaPago =
              TipoValorFormaPago.findByOid(dataSetTiposValor.getInteger("oid_forma_pago_tv"),getSesion());
          tipoValorFormaPago.setFormapago(formapago);
          tipoValorFormaPago.setTipovalor(TipoValor.findByOidProxy(dataSetTiposValor.getInteger("oid_tipo_valor"),getSesion()));
          tipoValorFormaPago.setActivo(dataSetTiposValor.getBoolean("activo"));

          if (dataSetTiposValor.getBoolean("activo").booleanValue()==false)
            tipoValorFormaPago.delete();

          formapago.addTipoValor(tipoValorFormaPago);
          dataSetTiposValor.next();
        }

        addTransaccion(formapago);
        dataset.next();
    }
  }

}
