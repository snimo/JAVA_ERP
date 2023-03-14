package com.srn.erp.ctasAPagar.op;

import java.util.Date;
import java.util.Hashtable;
import java.util.Iterator;

import com.srn.erp.compras.bm.Proveedor;
import com.srn.erp.general.bm.Provincia;
import com.srn.erp.general.bm.TipoComprobante;
import com.srn.erp.impuestos.bm.CategoriaIB;
import com.srn.erp.impuestos.bm.ConceptoImpuesto;

import framework.applicarionServer.bm.Varios.CalculadorMoney;
import framework.applicarionServer.bm.Varios.Money;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class CalculadorTotComproProv extends Operation {

  private Hashtable conceptosImpuestos = new Hashtable();
  private Hashtable netos = new Hashtable();
  private Proveedor proveedor = null;

  public CalculadorTotComproProv() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {

    int oidReg = 0;
    Date fecha = mapaDatos.getDate("fecha");
    
    proveedor = Proveedor.findByOid(mapaDatos.getInteger("oid_proveedor"),getSesion());
    IDataSet dsConceptosCompro = mapaDatos.getDataSet("TConceptosCompro");
    IDataSet dsTotCompro = getDataSetTotCompro();
    TipoComprobante tipoComprobante = TipoComprobante.findByOid(mapaDatos.getInteger("oid_tc"),getSesion());
    	
    dsConceptosCompro.first();
    while (!dsConceptosCompro.EOF()) {

      Integer oid               = dsConceptosCompro.getInteger("oid");
      Money importe             = dsConceptosCompro.getMoney("importe");
      Integer oidConcFactProv   = dsConceptosCompro.getInteger("oid_conc_fact_prov");

      Integer oidConcImpIVA = new Integer(0);
      if (dsConceptosCompro.getInteger("oid_conc_imp_iva")!=null)
        oidConcImpIVA     = dsConceptosCompro.getInteger("oid_conc_imp_iva");

      Integer oidConcImpPercIVA = new Integer(0);
      if (dsConceptosCompro.getInteger("oid_conc_imp_perc_iva")!=null)
         oidConcImpPercIVA = dsConceptosCompro.getInteger("oid_conc_imp_perc_iva");

      Integer oidConcImpPercIB = new Integer(0);
      if (dsConceptosCompro.getInteger("oid_conc_imp_perc_ib")!=null)
         oidConcImpPercIB  = dsConceptosCompro.getInteger("oid_conc_imp_perc_ib");

      Integer oidConcImpInterno = new Integer(0);
      if (dsConceptosCompro.getInteger("oid_conc_imp_internos")!=null)
         oidConcImpInterno = dsConceptosCompro.getInteger("oid_conc_imp_internos");

      Integer oidConcImpRetIVA = new Integer(0);
      if (dsConceptosCompro.getInteger("oid_conc_imp_ret_iva")!=null)
         oidConcImpRetIVA  = dsConceptosCompro.getInteger("oid_conc_imp_ret_iva");

      Integer  oidConcImpRetGan = new Integer(0);
      if (dsConceptosCompro.getInteger("oid_conc_imp_ret_gan")!=null)
         oidConcImpRetGan  = dsConceptosCompro.getInteger("oid_conc_imp_ret_gan");

      Integer oidConcImpRetIB = new Integer(0);
      if (dsConceptosCompro.getInteger("oid_conc_imp_ret_ib")!=null)
          oidConcImpRetIB   = dsConceptosCompro.getInteger("oid_conc_imp_ret_ib");

      // Calcular el Impuesto Correspondiente
      if (importe == null) {
        dsConceptosCompro.next();
        continue;
      }
      if ((tipoComprobante.esNotaDebitoInternoProveedor() || tipoComprobante.esNotaCreditoInternoProveedor()) 
      		||
      		(((oidConcImpIVA.intValue()==0) && (oidConcImpPercIVA.intValue()==0) &&
          (oidConcImpPercIB.intValue()==0) && (oidConcImpInterno.intValue()==0))))
        agregarNetoNOGravado(importe);
      else
        agregarNetoGravado(importe);

      if (!(tipoComprobante.esNotaDebitoInternoProveedor() || tipoComprobante.esNotaCreditoInternoProveedor()))      
      		procesarConcCompro(new Integer(++oidReg),
      											fecha,
      											importe,
      											oidConcImpIVA,
      											oidConcImpPercIVA,
      											oidConcImpPercIB,
      											oidConcImpInterno,
      											oidConcImpRetIVA,
      											oidConcImpRetGan,
      											oidConcImpRetIB);

      dsConceptosCompro.next();
    }


    enviarConceptosTotales(dsTotCompro);
    writeCliente(dsTotCompro);
  }

  private void enviarConceptosTotales(IDataSet dataSet) throws BaseException {
    int oid = 0;

    Money netoGravado =(Money)netos.get("netoGravado");
    if (netoGravado!=null)
      cargarRegistroDSTotCompro(dataSet,
                                new Integer(oid),
                                new Integer(oid),
                                new Integer(0),
                                "Neto Gravado",
                                netoGravado,
                                new Boolean(true),
                                new Boolean(false));


    Money netoNoGravado =(Money)netos.get("netoNOGravado");
    if (netoNoGravado!=null)
      cargarRegistroDSTotCompro(dataSet,
                                new Integer(oid),
                                new Integer(oid),
                                new Integer(0),
                                "Neto No Gravado",
                                netoNoGravado,
                                new Boolean(false),
                                new Boolean(true));

    Iterator iterConcImpu = conceptosImpuestos.keySet().iterator();
    while (iterConcImpu.hasNext()) {
      Integer oidConcImpu = (Integer) iterConcImpu.next();
      ConceptoImpuesto conceptoImpuesto = ConceptoImpuesto.findByOid(oidConcImpu,getSesion());
      cargarRegistroDSTotCompro(dataSet,
                                new Integer(oid),
                                new Integer(oid),
                                conceptoImpuesto.getOIDInteger(),
                                conceptoImpuesto.getDescripcion(),
                                (Money)conceptosImpuestos.get(oidConcImpu),
                                new Boolean(false),
                                new Boolean(false));
    }


  }

  private void procesarConcCompro(Integer oid,
                                  java.util.Date fecha,
                                  Money importe,
                                  Integer oidConcImpIVA,
                                  Integer oidConcImpPercIVA,
                                  Integer oidConcImpPercIB,
                                  Integer oidConcImpInt,
                                  Integer oidConcImpRetIVA,
                                  Integer oidConcImpRetGan,
                                  Integer oidConcImpRetIB) throws BaseException {

    // Calcular los Impuestos por el IVA
    if (oidConcImpIVA.intValue()!=0) {
      ConceptoImpuesto conceptoImpuesto =
          ConceptoImpuesto.findByOid(oidConcImpIVA,getSesion());
      Money impuesto = conceptoImpuesto.getImpuestoIVA(fecha,importe);
      agregarALista(impuesto,conceptoImpuesto.getOIDInteger());
    }

    // Calcular los Impuestos por la Perc IVA
    if (oidConcImpPercIVA.intValue()!=0) {
      ConceptoImpuesto conceptoImpuesto =
          ConceptoImpuesto.findByOid(oidConcImpPercIVA,getSesion());
      Money impuesto = conceptoImpuesto.getImpuestoPercIVA(fecha,importe);
      agregarALista(impuesto,conceptoImpuesto.getOIDInteger());
    }

    // Calcular la Percepcion de Ingresos Brutos
    if (oidConcImpPercIB.intValue()!=0) {
      if (proveedor.getSujetoimpositivo()==null)
        throw new ExceptionValidation(null,"Falta definir la Categoría de IB del proveedor");
      if (proveedor.getSujetoimpositivo().getCategib()==null)
        throw new ExceptionValidation(null,"Falta definir la Categoría de IB del proveedor");
      CategoriaIB categoriaIB =  proveedor.getSujetoimpositivo().getCategib();
      ConceptoImpuesto conceptoImpuesto =
          ConceptoImpuesto.findByOid(oidConcImpPercIB,getSesion());
      Provincia provincia = conceptoImpuesto.getProvincia();
      if (provincia == null)
         throw new ExceptionValidation(null,"El concepto Impuesto "+conceptoImpuesto.getDescripcion()+" no tiene una provincia asociada ");
      
      Money impuesto = conceptoImpuesto.getImpuestoPercIB(fecha,
          provincia,categoriaIB,importe);
      
      agregarALista(impuesto,conceptoImpuesto.getOIDInteger());
    }

    // Calcular los Impuestos Internos
    if (oidConcImpInt.intValue()!=0) {
      ConceptoImpuesto conceptoImpuesto =
          ConceptoImpuesto.findByOid(oidConcImpInt,getSesion());
      Money impuesto = conceptoImpuesto.getImpuestoInterno(fecha,importe);
      agregarALista(impuesto,conceptoImpuesto.getOIDInteger());
    }

  }

  private void agregarNetoGravado(Money neto) throws BaseException {
    if (netos.get("netoGravado")==null)
      netos.put("netoGravado",neto);
    else {
      Money netoAcum = (Money) netos.get("netoGravado");
      CalculadorMoney calcMoney = new CalculadorMoney(netoAcum);
      calcMoney.sumar(neto);
      netos.put("netoGravado",calcMoney.getResultMoney());
    }
  }

  private void agregarNetoNOGravado(Money neto) throws BaseException {
    if (netos.get("netoNOGravado")==null)
      netos.put("netoNOGravado",neto);
    else {
      Money netoAcum = (Money) netos.get("netoNOGravado");
      CalculadorMoney calcMoney = new CalculadorMoney(netoAcum);
      calcMoney.sumar(neto);
      netos.put("netoNOGravado",calcMoney.getResultMoney());
    }
  }


  private void agregarALista(Money impuesto,Integer oidConcImpu) throws BaseException {
    if (conceptosImpuestos.get(oidConcImpu)==null)
      conceptosImpuestos.put(oidConcImpu,impuesto);
    else {
      Money impuestoYaCalc      = (Money) conceptosImpuestos.get(oidConcImpu);
      CalculadorMoney calcMoney = new CalculadorMoney(impuestoYaCalc);
      calcMoney.sumar(impuesto);
      conceptosImpuestos.put(oidConcImpu,calcMoney.getResultMoney());
    }
  }

  private IDataSet getDataSetTotCompro() {
    IDataSet dataset = new TDataSet();
    dataset.create("TTotalesComproProv");
    dataset.fieldDef(new Field("oid",Field.INTEGER, 0));
    dataset.fieldDef(new Field("orden",Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_conc_imp",Field.INTEGER, 0));
    dataset.fieldDef(new Field("desc_conc_imp",Field.INTEGER, 0));
    dataset.fieldDef(new Field("importe",Field.CURRENCY, 0));
    dataset.fieldDef(new Field("es_neto_gravado", Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("es_neto_no_gravado", Field.BOOLEAN, 0));
    return dataset;
  }

  private void cargarRegistroDSTotCompro(IDataSet dataset,
                                         Integer oid,
                                         Integer orden,
                                         Integer oidConcImp,
                                         String descConcImp,
                                         Money importe,
                                         Boolean esNetoGravado,
                                         Boolean esNetoNoGravado) throws BaseException {
	//if (importe.doubleValue() == 0) return; 
    dataset.append();
    dataset.fieldValue("oid",oid);
    dataset.fieldValue("orden",orden);
    dataset.fieldValue("oid_conc_imp",oidConcImp);
    dataset.fieldValue("desc_conc_imp",descConcImp);
    dataset.fieldValue("importe",importe.doubleValue());
    dataset.fieldValue("es_neto_gravado",esNetoGravado);
    dataset.fieldValue("es_neto_no_gravado",esNetoNoGravado);
  }




}
