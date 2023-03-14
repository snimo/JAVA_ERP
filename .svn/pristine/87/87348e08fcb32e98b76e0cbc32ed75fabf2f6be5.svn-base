package com.srn.erp.tesoreria.op;

import java.util.Iterator;

import com.srn.erp.tesoreria.bm.Caja;
import com.srn.erp.tesoreria.bm.SaldoEfectivo;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerEfectivoEnCaja extends Operation {

  public TraerEfectivoEnCaja() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
  	
  	
  	IDataSet ds = this.getDSEfectivoEnCaja();
	  Caja caja = Caja.findByOid(mapaDatos.getInteger("oid_caja"),getSesion());
	  Iterator iterSaldoEfectivo = SaldoEfectivo.getSaldosEfectivo(caja,getSesion()).iterator();
	  while (iterSaldoEfectivo.hasNext()) {
		  SaldoEfectivo saldoEfectivo = (SaldoEfectivo) iterSaldoEfectivo.next();
		  cargarEfectivo(ds,saldoEfectivo);
	  }
	  writeCliente(ds);
	  
  }

  private IDataSet getDSEfectivoEnCaja() {
    IDataSet dataset = new TDataSet();
    dataset.create("TEfectivoEnCaja");
    dataset.fieldDef(new Field("oid_tipo_valor", Field.INTEGER, 0));
    dataset.fieldDef(new Field("desc_tipo_valor",  Field.STRING, 100));
    dataset.fieldDef(new Field("oid_moneda",  Field.INTEGER, 0));
    dataset.fieldDef(new Field("simbolo_moneda",  Field.STRING, 20));
    dataset.fieldDef(new Field("saldo",  Field.CURRENCY, 0));
    return dataset;
  }
  
  private void cargarEfectivo(IDataSet ds,
  		SaldoEfectivo saldoEfectivo) throws BaseException {
  	ds.append();
    ds.fieldValue("oid_tipo_valor", saldoEfectivo.getTipo_valor().getOIDInteger());
    ds.fieldValue("desc_tipo_valor",  saldoEfectivo.getTipo_valor().getDescripcion());
    ds.fieldValue("oid_moneda",  saldoEfectivo.getMoneda().getOIDInteger());
    ds.fieldValue("simbolo_moneda",  saldoEfectivo.getMoneda().getSimbolo());
    ds.fieldValue("saldo",  saldoEfectivo.getSaldo());

  }
  
  
  
}
