package com.srn.erp.stock.op;

import java.util.Iterator;

import com.srn.erp.general.bm.Pais;
import com.srn.erp.general.bm.Provincia;
import com.srn.erp.stock.bm.Deposito;
import com.srn.erp.stock.bm.EstadoDeposito;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerDeposito extends Operation {

  public TraerDeposito() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    Deposito deposito = null;
    if (mapaDatos.containsKey("oid")) {
       Integer oid = mapaDatos.getInteger("oid");
       deposito = Deposito.findByOid(oid, getSesion());
    }
    else {
       String codigo = mapaDatos.getString("codigo");
       deposito = Deposito.findByCodigo(codigo, getSesion());
    }

    IDataSet datasetDeposito = getDataSetDeposito();
    IDataSet datasetEstados = getDataSetEstadoDeposito();
    if (deposito != null) {
        cargarRegistroDeposito(datasetDeposito,
                         deposito.getOIDInteger(),
                         deposito.getCodigo(),
                         deposito.getDescripcion(),
                         deposito.getCompoDepo(),
                         deposito.isActivo(),
                         deposito.getCalleyNro(),
                         deposito.getLocalidad(),
                         deposito.getCodigoPostal(),
                         deposito.getProvincia(),
                         deposito.getPais()
                         );
        Iterator iterEstados = deposito.getEstadosDeposito().iterator();
        while (iterEstados.hasNext()) {
          EstadoDeposito estadoDeposito = (EstadoDeposito) iterEstados.next();
          cargarRegistroEstadoDeposito(datasetEstados,estadoDeposito);
        }
    }
    writeCliente(datasetDeposito);
    writeCliente(datasetEstados);
  }

  private IDataSet getDataSetDeposito() {
    IDataSet dataset = new TDataSet();
    dataset.create("TDeposito");
    dataset.fieldDef(new Field("oid_deposito", Field.INTEGER, 0));
    dataset.fieldDef(new Field("codigo", Field.STRING, 30));
    dataset.fieldDef(new Field("descripcion", Field.STRING, 50));
    dataset.fieldDef(new Field("compo_depo", Field.STRING, 50));
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("calle_y_nro", Field.STRING, 100));
    dataset.fieldDef(new Field("localidad", Field.STRING, 100));
    dataset.fieldDef(new Field("codigo_postal", Field.STRING, 50));
    dataset.fieldDef(new Field("oid_provincia", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_provincia", Field.STRING, 50));
    dataset.fieldDef(new Field("desc_provincia", Field.STRING, 100));
    dataset.fieldDef(new Field("oid_pais", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_pais", Field.STRING, 50));
    dataset.fieldDef(new Field("desc_pais", Field.STRING, 100));
    
    return dataset;
  }

  private void cargarRegistroEstadoDeposito(IDataSet dataset,
                                            EstadoDeposito estadoDeposito) throws BaseException {
    dataset.append();
    dataset.fieldValue("oid_estado_depo", estadoDeposito.getOIDInteger());
    dataset.fieldValue("oid_deposito", estadoDeposito.getDeposito().getOIDInteger());
    dataset.fieldValue("oid_estado_stock", estadoDeposito.getEstado_stock().getOIDInteger());
    dataset.fieldValue("allow_saldo_neg", estadoDeposito.isAllow_saldo_neg());
    dataset.fieldValue("oid_agrup_estado", estadoDeposito.getAgrupadorEstadoStock().getOIDInteger());
    dataset.fieldValue("activo",new Boolean(true));
  }


  private IDataSet getDataSetEstadoDeposito() {
    IDataSet dataset = new TDataSet();
    dataset.create("TEstadosDeposito");
    dataset.fieldDef(new Field("oid_estado_depo", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_deposito", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_estado_stock", Field.INTEGER, 0));
    dataset.fieldDef(new Field("allow_saldo_neg", Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("oid_agrup_estado", Field.INTEGER, 0));
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
    
    return dataset;
  }


  private void cargarRegistroDeposito(IDataSet dataset,
                         Integer oid_deposito,
                         String codigo,
                         String descripcion,
                         String compoDepo,
                         Boolean activo,
                         String calleyNro,
                         String localidad,
                         String codigoPostal,
                         Provincia provincia,
                         Pais pais) throws BaseException {
    dataset.append();
    dataset.fieldValue("oid_deposito", oid_deposito);
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("descripcion", descripcion);
    dataset.fieldValue("compo_depo", compoDepo);
    dataset.fieldValue("activo", activo);
    dataset.fieldValue("calle_y_nro", calleyNro);
    dataset.fieldValue("localidad", localidad);
    dataset.fieldValue("codigo_postal", codigoPostal);
    if (provincia!=null) {
    	dataset.fieldValue("oid_provincia", provincia.getOIDInteger());
    	dataset.fieldValue("cod_provincia", provincia.getCodigo());
    	dataset.fieldValue("desc_provincia", provincia.getDescripcion());
    } else {
    	dataset.fieldValue("oid_provincia", "");
    	dataset.fieldValue("cod_provincia", "");
    	dataset.fieldValue("desc_provincia", "");
    }
    if (pais!=null) {
    	dataset.fieldValue("oid_pais", pais.getOIDInteger());
    	dataset.fieldValue("cod_pais", pais.getCodigo());
    	dataset.fieldValue("desc_pais", pais.getDescripcion());
    } else {
    	dataset.fieldValue("oid_pais", "");
    	dataset.fieldValue("cod_pais", "");
    	dataset.fieldValue("desc_pais", "");
    }
    
  }


}
