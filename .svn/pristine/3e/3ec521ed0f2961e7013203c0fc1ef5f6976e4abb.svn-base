package com.srn.erp.bancos.op;

import java.util.Date;
import java.util.Iterator;

import com.srn.erp.bancos.bm.BoletaDeposito;
import com.srn.erp.tesoreria.bm.CuentaBancaria;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerHelpBoletasDeposito extends Operation {

	
	Integer nroDesde = null;
	Integer nroHasta = null;
	Date fecDesde = null;
	Date fecHasta = null;
	CuentaBancaria cuenta = null;
	
  public TraerHelpBoletasDeposito() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
  	
  	IDataSet dsBolDep = this.getDataSetBoleta();
  	
  	Iterator iterBolDep = 
  		BoletaDeposito.getHelpBoletasDeposito(nroDesde,nroHasta,fecDesde,fecHasta,cuenta,this.getSesion()).iterator();
  	while (iterBolDep.hasNext()) {
  		BoletaDeposito boletaDeposito = (BoletaDeposito) iterBolDep.next();
  		cargarRegistroBoleta(dsBolDep,boletaDeposito);
  	}
  	
  	writeCliente(dsBolDep);  	
  	
  }

  private IDataSet getDataSetBoleta() {
    IDataSet dataset = new TDataSet();
    dataset.create("THelpBoletasDeposito");
    dataset.fieldDef(new Field("oid", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_cco", Field.INTEGER, 0));
    dataset.fieldDef(new Field("comprobante", Field.STRING, 50));
    dataset.fieldDef(new Field("fec_emision", Field.DATE, 0));
    dataset.fieldDef(new Field("comentario", Field.MEMO, 0));
    dataset.fieldDef(new Field("monto", Field.CURRENCY, 0));
    dataset.fieldDef(new Field("moneda", Field.STRING, 50));
    dataset.fieldDef(new Field("gastos", Field.CURRENCY, 0));
    dataset.fieldDef(new Field("neto", Field.CURRENCY, 0));
    dataset.fieldDef(new Field("cuenta", Field.STRING, 100));
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
    return dataset;
  }
  

  public void cargarRegistroBoleta(IDataSet dataset,
  															   BoletaDeposito boleta) throws BaseException {
    dataset.append();
    dataset.fieldValue("oid", boleta.getOIDInteger());
    dataset.fieldValue("oid_cco", boleta.getOIDInteger());
    dataset.fieldValue("comprobante", boleta.getCodigo());
    dataset.fieldValue("fec_emision", boleta.getEmision());
    dataset.fieldValue("comentario", boleta.getComentario());
    dataset.fieldValue("monto", boleta.getMontoDeposito());
    dataset.fieldValue("moneda", boleta.getMoneda().getDescripcion());
    dataset.fieldValue("gastos", boleta.getGastos());
    dataset.fieldValue("neto", boleta.getNetoDeposito());
    dataset.fieldValue("cuenta", boleta.getCuenta_bancaria().getDescripcion());
    dataset.fieldValue("activo", boleta.isActivo());
    }

	public void beforeExecute(MapDatos mapaDatos) throws BaseException {
		// TODO Auto-generated method stub
		super.beforeExecute(mapaDatos);
		
		if (mapaDatos.containsKey("nro_ext_desde"))
			this.nroDesde = mapaDatos.getInteger("nro_ext_desde"); 
		
		if (mapaDatos.containsKey("nro_ext_hasta"))
			this.nroHasta = mapaDatos.getInteger("nro_ext_hasta");

		if (mapaDatos.containsKey("fec_desde"))
			this.fecDesde = mapaDatos.getDate("fec_desde"); 
		
		if (mapaDatos.containsKey("fec_hasta"))
			this.fecHasta = mapaDatos.getDate("fec_hasta");
		
		if (mapaDatos.containsKey("oid_cuenta")) 
			this.cuenta = CuentaBancaria.findByOidProxy(mapaDatos.getInteger("oid_cuenta"),this.getSesion());
		
		
		
	}
  
}
