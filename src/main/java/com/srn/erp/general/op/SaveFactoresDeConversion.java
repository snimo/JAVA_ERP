package com.srn.erp.general.op;

import com.srn.erp.general.bm.FactorConversion;
import com.srn.erp.stock.bm.UnidadMedida;

import framework.applicarionServer.bm.Varios.CalculadorCotizacion;
import framework.applicarionServer.bm.Varios.NumeroBase;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveFactoresDeConversion extends Operation {

  public SaveFactoresDeConversion() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    IDataSet ds = mapaDatos.getDataSet("TInput");
    ds.first();
    IDataSet dataset = ds.getDataSet("TFactoresDeConversion");
    procesarRegistros(dataset);
  }

  private void procesarRegistros(IDataSet dataset) throws BaseException {
    dataset.first();
      while (!dataset.EOF()) {

        Integer oidUmOri  = dataset.getInteger("oid_um_ori");
        Integer oidUmDest = dataset.getInteger("oid_um_dest");

        UnidadMedida unidadMedidaOri  = UnidadMedida.findByOid(oidUmOri,getSesion());
        UnidadMedida unidadMedidaDest = UnidadMedida.findByOid(oidUmDest,getSesion());

        FactorConversion factorconversion =
            FactorConversion.getFactConv(unidadMedidaOri,
                                         unidadMedidaDest,
                                         getSesion());

        if ((dataset.getBoolean("activo").booleanValue()==true) && (dataset.getDouble("factor").doubleValue()==0))
           throw new ExceptionValidation(null,"El Factor de conversión debe ser mayor a cero");

        if (factorconversion == null) {

          if (dataset.getDouble("factor").doubleValue()==0.0) return;

          FactorConversion factConv =
              (FactorConversion) FactorConversion.getNew(FactorConversion.NICKNAME,getSesion());
          factConv.setUni_med_ori(unidadMedidaOri);
          factConv.setUni_med_dest(unidadMedidaDest);
          factConv.setFactor(dataset.getDouble("factor"));
          factConv.setActivo(new Boolean(true));
          addTransaccion(factConv);

          FactorConversion factConvInv =
              (FactorConversion) FactorConversion.getNew(FactorConversion.NICKNAME,getSesion());
          factConvInv.setUni_med_ori(unidadMedidaDest);
          factConvInv.setUni_med_dest(unidadMedidaOri);
          CalculadorCotizacion calcCotiz = new CalculadorCotizacion(new NumeroBase(1.0));
          calcCotiz.dividirPor(new NumeroBase(dataset.getDouble("factor")));
          factConvInv.setFactor(new Double(calcCotiz.getResult()));
          factConvInv.setActivo(new Boolean(true));
          addTransaccion(factConvInv);

        }
        else {

          factorconversion.setFactor(dataset.getDouble("factor"));
          if (dataset.getBoolean("activo").booleanValue()==false)
              factorconversion.delete();
          addTransaccion(factorconversion);

          // Buscar el Inverso que tiene que existir
          FactorConversion factConvInv =
              FactorConversion.getFactConv(unidadMedidaDest,
                                           unidadMedidaOri,
                                           getSesion());


          if (factConvInv == null) return;
          CalculadorCotizacion calcCotiz = new CalculadorCotizacion(new NumeroBase(1.0));
          calcCotiz.dividirPor(new NumeroBase(dataset.getDouble("factor")));
          factConvInv.setFactor(new Double(calcCotiz.getResult()));
          if (dataset.getBoolean("activo").booleanValue()==false)
             factConvInv.delete();
          addTransaccion(factConvInv);


        }

        dataset.next();
    }
  }

}
