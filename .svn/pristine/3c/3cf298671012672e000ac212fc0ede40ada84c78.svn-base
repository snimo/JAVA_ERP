package com.srn.erp.ventas.op;

import com.srn.erp.tesoreria.bm.TipoValor;
import com.srn.erp.ventas.bm.CondicionPago;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerSugTipoValorParaFormaPago extends Operation {

  public TraerSugTipoValorParaFormaPago() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    
  	Integer oid = new Integer(0);
  	if (mapaDatos.containsKey("oid_forma_pago"))
  	   oid = mapaDatos.getInteger("oid_forma_pago");
  	
  	CondicionPago condPago =  null;
  	if (oid.intValue()>0)
  		condPago = CondicionPago.findByOid(oid, getSesion());
  	else
  		condPago = CondicionPago.getCondicionPagoDefaultRecibo(this.getSesion());
    
    IDataSet ds = this.getDSCondPagoSugerido();
    
    if (condPago.isContado()) {
    	TipoValor tipoVal = condPago.getTipoValorSugerido();
    	if (tipoVal!=null)
    		cargarRegistroTipoValor(ds,tipoVal);
    }
       
    
    
    
    writeCliente(ds);
  }

  private IDataSet getDSCondPagoSugerido() {
    IDataSet dataset = new TDataSet();
    dataset.create("TTipoValorSugerido");
    dataset.fieldDef(new Field("oid_tipo_valor", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_tipo_valor", Field.STRING, 50));
    dataset.fieldDef(new Field("desc_tipo_valor", Field.STRING, 100));
    dataset.fieldDef(new Field("oid_moneda", Field.INTEGER, 0));
    return dataset;
  }

  private void cargarRegistroTipoValor(IDataSet dataset,
                         TipoValor tipoValor) throws BaseException {
    dataset.append();
    dataset.fieldValue("oid_tipo_valor", tipoValor.getOIDInteger());
    dataset.fieldValue("cod_tipo_valor", tipoValor.getCodigo());
    dataset.fieldValue("desc_tipo_valor", tipoValor.getDescripcion());
    dataset.fieldValue("oid_moneda", tipoValor.getMoneda().getOIDInteger());
  }
}
