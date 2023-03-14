package com.srn.erp.tesoreria.op;

import java.util.Iterator;

import com.srn.erp.general.bm.Moneda;
import com.srn.erp.tesoreria.bm.TipoValor;

import framework.applicarionServer.bm.Varios.Money;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerInicioBoletaDeposito extends Operation {

	Moneda monedaLocal = null;
	
  public TraerInicioBoletaDeposito() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
  	
  	if (mapaDatos.getString("TIPO").equals("TIPO_VALORES_DEPO"))
  		traerTipoValoresDepositables();
  	
  }
  
  private void traerTipoValoresDepositables() throws BaseException {
  	
  	IDataSet ds = this.getDataSetTipoValores();
  	Iterator iterTiposValores = 
  		TipoValor.getTiposValoresDepositables(this.getSesion()).iterator();
  	while (iterTiposValores.hasNext()) {
  		TipoValor tipoValor = (TipoValor) iterTiposValores.next();
  		cargarRegistro(ds,tipoValor);
  	}
  	writeCliente(ds); 
  	
  }

  private IDataSet getDataSetTipoValores() {
    IDataSet dataset = new TDataSet();
    dataset.create("TTiposValores");
    dataset.fieldDef(new Field("sel", Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("oid_tipo_valor", Field.INTEGER, 0));
    dataset.fieldDef(new Field("desc_tipo_valor", Field.STRING, 100));
    dataset.fieldDef(new Field("oid_moneda", Field.INTEGER, 0));
    dataset.fieldDef(new Field("desc_moneda", Field.STRING, 100));
    dataset.fieldDef(new Field("cotizacion", Field.CURRENCY, 100));
    dataset.fieldDef(new Field("modif_cotizacion", Field.BOOLEAN, 0));
    return dataset;
  }

  private void cargarRegistro(IDataSet dataset,
                         TipoValor tipoValor) throws BaseException {
    dataset.append();
    dataset.fieldValue("sel", new Boolean(false));
    dataset.fieldValue("oid_tipo_valor", tipoValor.getOIDInteger());
    dataset.fieldValue("desc_tipo_valor", tipoValor.getDescripcion());
    dataset.fieldValue("oid_moneda", tipoValor.getMoneda().getOIDInteger());
    dataset.fieldValue("desc_moneda", tipoValor.getMoneda().getDescripcion());
    dataset.fieldValue("cotizacion", new Money(0));
    
    if (getMonedaLocal().getOID() == tipoValor.getMoneda().getOID())
    	dataset.fieldValue("modif_cotizacion", new Boolean(false));
    else
    	dataset.fieldValue("modif_cotizacion", new Boolean(true));
  }
  
  private Moneda getMonedaLocal() throws BaseException {
  	if (this.monedaLocal != null)
  		return monedaLocal;
  	
  	monedaLocal = Moneda.getMonedaCursoLegal(this.getSesion());
  	return monedaLocal; 
  		
  }
  
}
