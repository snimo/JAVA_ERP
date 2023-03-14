package com.srn.erp.contabilidad.op;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.contabilidad.bm.Cuenta;
import com.srn.erp.contabilidad.bm.CuentaImputable;
import com.srn.erp.contabilidad.bm.ReporteContable;
import com.srn.erp.contabilidad.bm.ReporteContableDet;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerReporteContableCubo extends Operation {

  public TraerReporteContableCubo() {
  }

  Hashtable tituloRamaPadreyCuenta = new Hashtable();

  public void execute(MapDatos mapaDatos) throws BaseException {

    Integer oidReporte = mapaDatos.getInteger("oid_reporte");
    ReporteContable reporteContable = ReporteContable.findByOid(oidReporte,getSesion());
    IDataSet dataSetReporteConta = getDataReporteContable();

    Iterator iterReportes = reporteContable.getItemsReporte().iterator();
    while (iterReportes.hasNext()) {
      ReporteContableDet repContaDet = (ReporteContableDet) iterReportes.next();

      // Si es un titulo
      if (repContaDet.isTitulo())
        tratarTitulo(dataSetReporteConta,repContaDet);
        else // Si es una cuenta con Componentes
      if (repContaDet.isCuentaConComponentes())
        tratarCuentaConComponentes(dataSetReporteConta,repContaDet);
      else // Trartar Rango de Cuentas
      if (repContaDet.isRangoCuentas())
        tratarRangoCuentas(dataSetReporteConta,repContaDet);
      else // Si es una cuenta que se quiere exluir los componentes
      if (repContaDet.isCuentaSinComponentes())
        tratarCuentaSinCompo(dataSetReporteConta,repContaDet);
      else // Si es una cuenta sola
      if (repContaDet.isCuenta())
        tratarCuentaSola(dataSetReporteConta,repContaDet);
    }

    writeCliente(dataSetReporteConta);
  }

  private void tratarCuentaSola(IDataSet ds,
                                ReporteContableDet repContaDet) throws BaseException {
    traerInfoCuenta(ds,
    				repContaDet,
                    new Integer(repContaDet.getOidtitulopadre().intValue()*-1),
                    repContaDet.getCuenta());
  }

  private void tratarRangoCuentas(IDataSet ds,
                                  ReporteContableDet repContaDet) throws BaseException {
    List listaCuentas = Cuenta.getCuentas(repContaDet.getCodigodesde(),
                                          repContaDet.getCodigohasta(),
                                          getSesion());
    Iterator iterCuentas = listaCuentas.iterator();
    while (iterCuentas.hasNext()) {
      Cuenta cuenta = (Cuenta) iterCuentas.next();
      traerInfoCuenta(ds,
    		          repContaDet,
                      new Integer(repContaDet.getOidtitulopadre().intValue()*-1),
                      cuenta);
      }
  }

  private void tratarCuentaSinCompo(IDataSet ds,
                                    ReporteContableDet repContaDet) throws BaseException {

    HashTableDatos listaValoresComponentes = repContaDet.getValoresComponentes();
    Iterator iterCtasImputables =
        repContaDet.getCuenta().getImputablesByNotInValoresCompo(listaValoresComponentes).iterator();
    while (iterCtasImputables.hasNext()) {
      CuentaImputable cuentaImputable =
          (CuentaImputable) iterCtasImputables.next();
      cargarDataSetReporteContable(ds,
                                   new Integer(cuentaImputable.getOID()).
                                   toString(),
                                   new Integer(repContaDet.getOidtitulopadre().
                                               intValue() * -1).toString(),
                                   cuentaImputable.getDescCuentaMasDescValCompo());
    }
  }


  private void tratarTitulo(IDataSet ds,
                            ReporteContableDet repContaDet) throws BaseException {
    cargarDataSetReporteContable(ds,
                                 new Integer(repContaDet.getOidtitulo().intValue()*-1).toString(),
                                 new Integer(repContaDet.getOidtitulopadre().intValue()*-1).toString(),
                                 repContaDet.getDesctitulo());
  }

  private void tratarCuentaConComponentes(IDataSet ds ,
                                          ReporteContableDet repContaDet)
      throws BaseException {
    HashTableDatos listaValoresComponentes = repContaDet.getValoresComponentes();
    Iterator iterCtasImputables =
      repContaDet.getCuenta().getImputablesByValoresCompo(listaValoresComponentes).iterator();
    while (iterCtasImputables.hasNext()) {
          CuentaImputable cuentaImputable = (CuentaImputable) iterCtasImputables.next();
             cargarDataSetReporteContable(ds,
                                          new Integer(cuentaImputable.getOID()).toString(),
                                          new Integer(repContaDet.getOidtitulopadre().intValue()*-1).toString(),
                                          cuentaImputable.getDescCuentaMasDescValCompo());
           }
  }



  private String getClave(Cuenta cuenta,Integer oidTituPadre) throws BaseException {
    String claveOidTituRamaPadreyCuenta =
        "OID_PADRE_"+oidTituPadre.toString()+"_CTA_"+
        cuenta.getOIDInteger().toString();
    return claveOidTituRamaPadreyCuenta;
  }


  private void traerInfoCuenta(IDataSet dataSetReporteConta,
		                       ReporteContableDet reporteContaDet,
                               Integer oidTituPadre,
                               Cuenta cuenta) throws BaseException {

    // Devolver la lista de Imputables
    Iterator iterCtasImputables =
        cuenta.getImputables().iterator();
    
    while (iterCtasImputables.hasNext()) {
      CuentaImputable cuentaImputable =
          (CuentaImputable) iterCtasImputables.next();
      cargarDataSetReporteContable(dataSetReporteConta,
                                   new Integer(cuentaImputable.getOID()).toString(),
                                   oidTituPadre.toString(),
                                   cuentaImputable.getCuenta().getCodigo()+" - "+cuentaImputable.getCuenta().getDescripcion());
    }
    
    
    /*String clave = getClave(cuenta,oidTituPadre);
    if (tituloRamaPadreyCuenta.get(clave)==null) {
      tituloRamaPadreyCuenta.put(clave,clave);
      cargarDataSetReporteContable(dataSetReporteConta,
                                   clave,
                                   oidTituPadre.toString(),
                                   cuenta.getDescripcion());
    }
    while (iterCtasImputables.hasNext()) {
      CuentaImputable cuentaImputable =
          (CuentaImputable) iterCtasImputables.next();
      cargarDataSetReporteContable(dataSetReporteConta,
                                   new Integer(cuentaImputable.getOID()).toString(),
                                   clave,
                                   cuentaImputable.getDescCuentaMasDescValCompo());
    }*/
  }

  private IDataSet getDataReporteContable() {
    IDataSet dataset = new TDataSet();
    dataset.create("TReporteConta");
    dataset.fieldDef(new Field("oid", Field.STRING, 100));
    dataset.fieldDef(new Field("oid_padre", Field.STRING, 100));
    dataset.fieldDef(new Field("descripcion", Field.STRING, 255));
    return dataset;
  }

  private void cargarDataSetReporteContable(IDataSet dataset,
                                            String oid,
                                            String oidPadre,
                                            String descripcion) {
    dataset.append();
    dataset.fieldValue("oid", oid);
    dataset.fieldValue("oid_padre", oidPadre);
    dataset.fieldValue("descripcion", descripcion);
  }
}
