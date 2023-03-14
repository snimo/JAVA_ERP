package com.srn.erp.contabilidad.op;

import java.util.Iterator;
import java.util.List;

import com.srn.erp.contabilidad.bm.Componente;
import com.srn.erp.contabilidad.bm.ComproContaConsulta;
import com.srn.erp.contabilidad.bm.Cuenta;
import com.srn.erp.contabilidad.bm.ValorCompo;
import com.srn.erp.general.bm.ComproCab;
import com.srn.erp.general.bm.TipoComprobante;

import framework.applicarionServer.bl.Utils.Fecha;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerComproContables extends Operation {

  private Cuenta cuenta = null;
  private Componente componente = null;
  private ValorCompo valorCompo = null;
  private java.util.Date fecImputacDesde = null;
  private java.util.Date fecImputacHasta = null;
  private String identificadorCompro = null;
  private Integer oidCCO = null;
  private ComproCab comproCab = null;
  private TipoComprobante tipoComprobante = null;

  public TraerComproContables() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    tomarParametros(mapaDatos);
    traerComproContables();
  }


  public void tomarParametros(MapDatos mapaDatos) throws BaseException {

    // Tomar la cuenta
    if (mapaDatos.containsKey(Cuenta.NICKNAME))
      cuenta = Cuenta.findByOid(mapaDatos.getInteger(Cuenta.NICKNAME),getSesion());

    // Tomar el Componente y su valor
    if ((mapaDatos.containsKey(Componente.NICKNAME)) &&
        (mapaDatos.containsKey(ValorCompo.NICKNAME))) {
      componente = Componente.findByOid(mapaDatos.getInteger(Componente.NICKNAME),getSesion());
      valorCompo = ValorCompo.findByOid(componente,mapaDatos.getInteger(ValorCompo.NICKNAME),getSesion());
    }

    // Fecha de Imputacion Desde y Hasta
    if ((mapaDatos.containsKey("fec_imputac_desde")) &&
        (mapaDatos.containsKey("fec_imputac_hasta"))) {
      fecImputacDesde = mapaDatos.getDate("fec_imputac_desde");
      fecImputacHasta = mapaDatos.getDate("fec_imputac_hasta");
    }

    // Traer Comprobante
    if (mapaDatos.containsKey(ComproCab.NICKNAME))
      identificadorCompro = mapaDatos.getString(ComproCab.NICKNAME);

    // Traer Comprobante
    if (mapaDatos.containsKey(ComproCab.NICKNAME)) {
        identificadorCompro = mapaDatos.getString(ComproCab.NICKNAME);
        comproCab = ComproCab.getComproCab(identificadorCompro,getSesion());
        if (comproCab == null)
          throw new ExceptionValidation(null,"Comprobante Inexistente:"+identificadorCompro);
    }
    
    // Leer por el oid_cco
    if (mapaDatos.containsKey("oid_cco")) 
        comproCab = ComproCab.findByOidProxyCompro(mapaDatos.getInteger("oid_cco"), this.getSesion());

    // Traer tipo de Comprobante
    if (mapaDatos.containsKey(TipoComprobante.NICKNAME))
      tipoComprobante = TipoComprobante.findByOid(mapaDatos.getInteger(TipoComprobante.NICKNAME),getSesion());

  }

  public void traerComproContables() throws BaseException {
    IDataSet dataSetComproConta = getDataComproContaCab();
    List listaComproConta = ComproContaConsulta.getComprobantes(cuenta,
                                                                componente,
                                                                valorCompo,
                                                                fecImputacDesde,
                                                                fecImputacHasta,
                                                                comproCab,
                                                                tipoComprobante,
                                                                getSesion());
    Iterator iterListaComproConta = listaComproConta.iterator();
    while (iterListaComproConta.hasNext()) {
      ComproContaConsulta comproContaConsulta =
          (ComproContaConsulta) iterListaComproConta.next();
      cargarRegistroComproContaCab(dataSetComproConta,
                                   comproContaConsulta.getOIDInteger(),
                                   comproContaConsulta.getEmision(),
                                   comproContaConsulta.getImputacion(),
                                   ComproCab.getFormatoCompro(comproContaConsulta.getTC(),
                                                              comproContaConsulta.getLetra(),
                                                              comproContaConsulta.getLugEmi(),
                                                              comproContaConsulta.getNroExt()),
                                   comproContaConsulta.getComentario(),
                                   comproContaConsulta.isAnulado(),
                                   comproContaConsulta.getTC(),
                                   comproContaConsulta.getLetra(),
                                   comproContaConsulta.getLugEmi(),
                                   comproContaConsulta.getNroExt());
    }
    writeCliente(dataSetComproConta);
  }

  private IDataSet getDataComproContaCab() {
    IDataSet dataset = new TDataSet();
    dataset.create("TComprobantesContables");
    dataset.fieldDef(new Field("oid_cco", Field.INTEGER, 0));
    dataset.fieldDef(new Field("fec_emision",Field.STRING, 10));
    dataset.fieldDef(new Field("fec_imputacion",Field.STRING, 10));
    dataset.fieldDef(new Field("comprobante",Field.STRING, 30));
    dataset.fieldDef(new Field("comentario",Field.STRING, 255));
    dataset.fieldDef(new Field("anulado",Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("tc_ext",Field.STRING,6));
    dataset.fieldDef(new Field("letra",Field.STRING,1));
    dataset.fieldDef(new Field("lug_emi",Field.INTEGER,0));
    dataset.fieldDef(new Field("nro_ext",Field.INTEGER,0));
    return dataset;
  }

  private void cargarRegistroComproContaCab(IDataSet dataset,
                         Integer oidCCO,
                         java.util.Date fecEmision,
                         java.util.Date fecImputacion,
                         String identifCompro,
                         String comentario,
                         Boolean anulado,
                         String tcExt,
                         String letra,
                         Integer lugEmi,
                         Integer nroExt) {
    dataset.append();
    dataset.fieldValue("oid_cco", oidCCO);
    dataset.fieldValue("fec_emision", Fecha.getddmmyyyy(fecEmision));
    dataset.fieldValue("fec_imputacion", Fecha.getddmmyyyy(fecImputacion));
    dataset.fieldValue("comprobante", identifCompro);
    dataset.fieldValue("comentario",comentario);
    dataset.fieldValue("anulado", anulado);
    dataset.fieldValue("tc_ext", tcExt);
    dataset.fieldValue("letra",letra);
    dataset.fieldValue("lug_emi",lugEmi);
    dataset.fieldValue("nro_ext",nroExt);
  }

}
