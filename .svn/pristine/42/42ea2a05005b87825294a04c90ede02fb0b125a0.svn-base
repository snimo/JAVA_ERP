package com.srn.erp.ctasACobrar.op;

import framework.applicarionServer.bm.Varios.CalculadorCotizacion;
import framework.applicarionServer.bm.Varios.Money;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;


public class SugerirAplicVtoClie extends Operation {

  public SugerirAplicVtoClie() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {

    // El importe
    Money saldo1               = mapaDatos.getMoney("saldo_1");
    Money saldo2               = mapaDatos.getMoney("saldo_2");
    Money devolverAplic1MonOri = null;
    Money devolverAplic2MonOri = null;

    // Obtener el Saldo 1 en Pesos
    CalculadorCotizacion calcCotizador1 = new CalculadorCotizacion(saldo1);
    calcCotizador1.restar(mapaDatos.getMoney("importe_ya_aplicado_1"));
    calcCotizador1.multiplicarPor(mapaDatos.getCotizacion("cotiz_mon_ori_hoy_1"));
    Money saldoEnPesos1 = new Money(calcCotizador1.getResult());

    // Obtener el Saldo 2 en Pesos
    CalculadorCotizacion calcCotizador2 = new CalculadorCotizacion(saldo2);
    calcCotizador2.restar(mapaDatos.getMoney("importe_ya_aplicado_2"));
    calcCotizador2.multiplicarPor(mapaDatos.getCotizacion("cotiz_mon_ori_hoy_2"));
    Money saldoEnPesos2 = new Money(calcCotizador2.getResult());

    // Obtener el Saldo Minimo
    double minSaldo =
        Math.min(Math.abs(saldoEnPesos1.doubleValue()),
                 Math.abs(saldoEnPesos2.doubleValue()));

    // Obtener el Saldo
       // Aplicar todo por el saldo 1 y convertir el saldo 2
    CalculadorCotizacion CalculadorAplic1 = new CalculadorCotizacion(new Money(minSaldo));
    CalculadorAplic1.dividirPor(mapaDatos.getCotizacion("cotiz_mon_ori_hoy_1"));
    if (saldoEnPesos1.doubleValue()<0)
       CalculadorAplic1.multiplicarPor(new Money(-1));
    devolverAplic1MonOri = new Money(CalculadorAplic1.getResult());
    CalculadorCotizacion CalculadorAplic2 = new CalculadorCotizacion(new Money(minSaldo));
    CalculadorAplic2.dividirPor(mapaDatos.getCotizacion("cotiz_mon_ori_hoy_2"));
    if (saldoEnPesos2.doubleValue()<0)
       CalculadorAplic2.multiplicarPor(new Money(-1));
    devolverAplic2MonOri = new Money(CalculadorAplic2.getResult());

    IDataSet dsSugerenciaAplic = getDataSetSugAplic();

    cargarRegistroSugAplic(dsSugerenciaAplic,
                           mapaDatos.getInteger("oid_tran_vto_1"),
                           devolverAplic1MonOri);

    cargarRegistroSugAplic(dsSugerenciaAplic,
                           mapaDatos.getInteger("oid_tran_vto_2"),
                           devolverAplic2MonOri);

    writeCliente(dsSugerenciaAplic);

  }

  private IDataSet getDataSetSugAplic() throws BaseException {
    IDataSet dataset = new TDataSet();
    dataset.create("TSugerenciaAplicClie");
    dataset.fieldDef(new Field("oid_tran_vto", Field.INTEGER, 0));
    dataset.fieldDef(new Field("importe", Field.CURRENCY, 0));
    return dataset;
  }


  private void cargarRegistroSugAplic(IDataSet dataset,
                                      Integer oidTranVto,
                                      Money importeAAplicar) throws BaseException {
    dataset.append();
    dataset.fieldValue("oid_tran_vto", oidTranVto);
    dataset.fieldValue("importe", importeAAplicar);
  }


}
