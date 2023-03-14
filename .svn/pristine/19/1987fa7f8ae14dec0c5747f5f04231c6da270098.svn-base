package com.srn.erp.contabilidad.op;

import com.srn.erp.compras.bm.InformeRecepcion;
import com.srn.erp.compras.bm.InformeRecepcionDet;
import com.srn.erp.compras.bm.Proveedor;
import com.srn.erp.costos.bm.CentroCostos;
import com.srn.erp.costos.bm.CentroImputacion;
import com.srn.erp.general.bm.Pais;
import com.srn.erp.general.bm.Provincia;
import com.srn.erp.general.bm.Sucursal;
import com.srn.erp.stock.bm.Producto;
import com.srn.erp.sueldos.bm.Legajo;
import com.srn.erp.tesoreria.bm.CuentaBancaria;
import com.srn.erp.tesoreria.bm.TarjetaCredito;
import com.srn.erp.tesoreria.bm.Valor;
import com.srn.erp.ventas.bm.Proyecto;
import com.srn.erp.ventas.bm.Sujeto;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerEntidadesContables extends Operation {

  public TraerEntidadesContables()  {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    IDataSet ds = getDataSetEntidadesContables();
    cargarRegistroComproContaCab(ds,new Integer(1),Sujeto.NICKNAME,"Cliente");
    cargarRegistroComproContaCab(ds,new Integer(2),Producto.NICKNAME,"Producto");
    cargarRegistroComproContaCab(ds,new Integer(3),Proveedor.NICKNAME,"Proveedor");
    cargarRegistroComproContaCab(ds,new Integer(4),CuentaBancaria.NICKNAME,"Cuenta Bancaria");
    cargarRegistroComproContaCab(ds,new Integer(5),InformeRecepcion.NICKNAME,"Informe de Recepción");    
    cargarRegistroComproContaCab(ds,new Integer(6),InformeRecepcionDet.NICKNAME,"Det. Informe de Recepción");
    cargarRegistroComproContaCab(ds,new Integer(7),Sucursal.NICKNAME,"Sucursal");    
    cargarRegistroComproContaCab(ds,new Integer(8),Provincia.NICKNAME,"Provincia");    
    cargarRegistroComproContaCab(ds,new Integer(9),Pais.NICKNAME,"Países");
    cargarRegistroComproContaCab(ds,new Integer(10),CentroCostos.NICKNAME,"Centro de Costos");
    cargarRegistroComproContaCab(ds,new Integer(11),Proyecto.NICKNAME,"Proyecto");
    cargarRegistroComproContaCab(ds,new Integer(12),Valor.NICKNAME,"Valor");
    cargarRegistroComproContaCab(ds,new Integer(13),TarjetaCredito.NICKNAME,"Tarjetas de Crédito");
    cargarRegistroComproContaCab(ds,new Integer(14),CentroImputacion.NICKNAME,"Centro de Imputación");
    cargarRegistroComproContaCab(ds,new Integer(15),Legajo.NICKNAME,"Legajo");
    
    writeCliente(ds);
  }



  private IDataSet getDataSetEntidadesContables() {
    IDataSet dataset = new TDataSet();
    dataset.create("TEntidadesContables");
    dataset.fieldDef(new Field("oid", Field.INTEGER, 0));
    dataset.fieldDef(new Field("nickname",Field.STRING, 50));
    dataset.fieldDef(new Field("descripcion",Field.STRING, 50));
    return dataset;
  }

  private void cargarRegistroComproContaCab(IDataSet dataset,
                         Integer oid,
                         String nickname,
                         String descripcion) throws BaseException {
    dataset.append();
    dataset.fieldValue("oid", oid);
    dataset.fieldValue("nickname", nickname);
    dataset.fieldValue("descripcion", descripcion);
  }

}
