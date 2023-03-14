package com.srn.erp.contabilidad.op;

import com.srn.erp.contabilidad.bm.Ejercicio;
import com.srn.erp.contabilidad.bm.EjercicioPeri;
import com.srn.erp.general.bm.Periodo;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveEjercicio extends Operation {

  public SaveEjercicio() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    IDataSet dataset = mapaDatos.getDataSet("TEjercicio");
    procesarRegistros(dataset);
  }

  private void procesarRegistros(IDataSet dataset) throws BaseException {
    dataset.first();
      while (!dataset.EOF()) {

        Ejercicio ejercicio = Ejercicio.findByOid(dataset.getInteger("oid_ejercicio"),getSesion());
        ejercicio.setOID(dataset.getInteger("oid_ejercicio"));
        ejercicio.setNroejer(dataset.getInteger("nro_ejer"));
        ejercicio.setFechadesde(dataset.getDate("fecha_desde"));
        ejercicio.setFechahasta(dataset.getDate("fecha_hasta"));
        ejercicio.setActivo(dataset.getBoolean("activo"));
        ejercicio.setLibroDiarioPorComprobante(dataset.getString("lib_dia_compro"));
        ejercicio.setFechaGenLibDiario(dataset.getDate("fec_gen_lib_dia"));
        

        IDataSet dataSetEjerPeri = dataset.getDataSet("TEjercicioPeri");
        dataSetEjerPeri.first();
        while (!dataSetEjerPeri.EOF()) {
          EjercicioPeri ejercicioPeri = EjercicioPeri.findByOid(dataSetEjerPeri.getInteger("oid_ejercicio_peri"),getSesion());
          ejercicioPeri.setEjercicio(ejercicio);
          ejercicioPeri.setSecu(dataSetEjerPeri.getInteger("secu"));
          ejercicioPeri.setPeriodo(Periodo.findByOidProxy(dataSetEjerPeri.getInteger("oid_peri"),getSesion()));
          ejercicioPeri.setCerrado(dataSetEjerPeri.getBoolean("cerrado"));
          ejercicioPeri.setActivo(dataSetEjerPeri.getBoolean("activo"));
          ejercicio.addEjercicioPeri(ejercicioPeri);
          dataSetEjerPeri.next();
        }

        addTransaccion(ejercicio);
        dataset.next();
    }
  }

}
