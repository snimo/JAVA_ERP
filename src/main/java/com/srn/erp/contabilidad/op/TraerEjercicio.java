package com.srn.erp.contabilidad.op;

import java.util.Date;
import java.util.Iterator;

import com.srn.erp.contabilidad.bm.Ejercicio;
import com.srn.erp.contabilidad.bm.EjercicioPeri;

import framework.applicarionServer.bl.Utils.Fecha;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerEjercicio extends Operation {

  public TraerEjercicio() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    Ejercicio ejercicio = null;
    if (mapaDatos.containsKey("oid")) {
       Integer oid = mapaDatos.getInteger("oid");
       ejercicio = Ejercicio.findByOid(oid, getSesion());
    }
    else {
       String codigo = mapaDatos.getString("codigo");
       ejercicio = Ejercicio.findByCodigo(codigo, getSesion());
    }

    IDataSet datasetEjercicio = getDataSetEjercicio();
    IDataSet datasetEjercicioPeri = getDataSetEjercicioPeriodo();

    if (ejercicio != null) {
        cargarRegistroEjercicio(datasetEjercicio,
                         ejercicio.getOIDInteger(),
                         ejercicio.getNroejer(),
                         ejercicio.getFechadesde(),
                         ejercicio.getFechahasta(),
                         ejercicio.isActivo(),
                         ejercicio.getLibroDiarioPorComprobante(),
                         ejercicio.getFechaGenLibDiario()
                         );

        Iterator iterPeriEjer = ejercicio.getPeriodosEjercicio().iterator();
        while (iterPeriEjer.hasNext()) {
          EjercicioPeri ejercicioPeri = (EjercicioPeri) iterPeriEjer.next();
          cargarRegistroEjercicioPeri(datasetEjercicioPeri,
                                      ejercicioPeri.getOIDInteger(),
                                      ejercicio.getOIDInteger(),
                                      ejercicioPeri.getSecu(),
                                      ejercicioPeri.getPeriodo().getOIDInteger(),
                                      ejercicioPeri.getPeriodo().getCodigo(),
                                      ejercicioPeri.isCerrado(),
                                      ejercicioPeri.isActivo()
                                      );
        }



    }
    writeCliente(datasetEjercicio);
    writeCliente(datasetEjercicioPeri);
  }

  private IDataSet getDataSetEjercicio() {
    IDataSet dataset = new TDataSet();
    dataset.create("TEjercicio");
    dataset.fieldDef(new Field("oid_ejercicio", Field.INTEGER, 0));
    dataset.fieldDef(new Field("nro_ejer", Field.INTEGER, 0));
    dataset.fieldDef(new Field("fecha_desde", Field.STRING, 10));
    dataset.fieldDef(new Field("fecha_hasta", Field.STRING, 10));
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("lib_dia_compro", Field.STRING, 20));
    dataset.fieldDef(new Field("fec_gen_lib_dia", Field.DATE, 0));
    return dataset;
  }

  private IDataSet getDataSetEjercicioPeriodo() {
    IDataSet dataset = new TDataSet();
    dataset.create("TEjercicioPeri");
    dataset.fieldDef(new Field("oid_ejercicio_peri", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_ejercicio", Field.INTEGER, 0));
    dataset.fieldDef(new Field("secu", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_peri", Field.INTEGER, 0));
    dataset.fieldDef(new Field("codigo_peri",Field.STRING, 50));
    dataset.fieldDef(new Field("cerrado", Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
    
    return dataset;
  }


  private void cargarRegistroEjercicio(IDataSet dataset,
                         Integer oid_ejercicio,
                         Integer nro_ejer,
                         Date fecha_desde,
                         Date fecha_hasta,
                         Boolean activo,
                         String libroDiarioCompro,
                         java.util.Date fecGenLibroDiario) {
    dataset.append();
    dataset.fieldValue("oid_ejercicio", oid_ejercicio);
    dataset.fieldValue("nro_ejer", nro_ejer);
    dataset.fieldValue("fecha_desde", Fecha.getddmmyyyy(fecha_desde));
    dataset.fieldValue("fecha_hasta", Fecha.getddmmyyyy(fecha_hasta));
    dataset.fieldValue("activo", activo);
    dataset.fieldValue("lib_dia_compro" , libroDiarioCompro);
    dataset.fieldValue("fec_gen_lib_dia",fecGenLibroDiario);
     
  }

  private void cargarRegistroEjercicioPeri(IDataSet dataset,
                         Integer oid_ejercicio_peri,
                         Integer oid_ejercicio,
                         Integer secu,
                         Integer oid_peri,
                         String codigoPeri,
                         Boolean cerrado,
                         Boolean activo) {
    dataset.append();
    dataset.fieldValue("oid_ejercicio_peri", oid_ejercicio_peri);
    dataset.fieldValue("oid_ejercicio", oid_ejercicio);
    dataset.fieldValue("secu", secu);
    dataset.fieldValue("oid_peri", oid_peri);
    dataset.fieldValue("codigo_peri", codigoPeri);
    dataset.fieldValue("cerrado", cerrado);
    dataset.fieldValue("activo", activo);
    
    
  }



}
