package com.srn.erp.bancos.op;

import java.util.Date;
import java.util.Iterator;

import com.srn.erp.bancos.bm.NotaBancaria;
import com.srn.erp.tesoreria.bm.CuentaBancaria;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerHelpNotasBancarias extends Operation {

	
	Integer nroDesde = null;
	Integer nroHasta = null;
	Date fecDesde = null;
	Date fecHasta = null;
	CuentaBancaria cuenta = null;
	
  public TraerHelpNotasBancarias() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
  	
  	IDataSet dsNota = this.getDataSetNotaBancaria();
  	
  	Iterator iterNotasBancarias = 
  		NotaBancaria.getHelpNotasBancarias(nroDesde,nroHasta,fecDesde,fecHasta,cuenta,this.getSesion()).iterator();
  	while (iterNotasBancarias.hasNext()) {
  		NotaBancaria notaBancaria = (NotaBancaria) iterNotasBancarias.next();
  		cargarRegistro(dsNota,notaBancaria);
  	}
  	
  	writeCliente(dsNota);  	
  	
  }

  private IDataSet getDataSetNotaBancaria() {
    IDataSet dataset = new TDataSet();
    dataset.create("THelpNotasBancarias");
    dataset.fieldDef(new Field("oid", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_cco", Field.INTEGER, 0));
    dataset.fieldDef(new Field("comprobante", Field.STRING, 50));
    dataset.fieldDef(new Field("fec_emision", Field.DATE, 0));
    dataset.fieldDef(new Field("comentario", Field.MEMO, 0));
    dataset.fieldDef(new Field("moneda", Field.STRING, 50));
    dataset.fieldDef(new Field("monto", Field.CURRENCY, 0));
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("cuenta", Field.STRING, 100));
    return dataset;
  }
  

  public void cargarRegistro(IDataSet dataset,
  													NotaBancaria nota) throws BaseException {
    dataset.append();
    dataset.fieldValue("oid", nota.getOIDInteger());
    dataset.fieldValue("oid_cco", nota.getOIDInteger());
    dataset.fieldValue("comprobante", nota.getCodigo());
    dataset.fieldValue("fec_emision", nota.getEmision());
    dataset.fieldValue("comentario", nota.getComentario());
    dataset.fieldValue("moneda", nota.getMoneda_cta().getDescripcion());
    dataset.fieldValue("monto", nota.getTot_mon_cta());
    dataset.fieldValue("activo", nota.isActivo());
    dataset.fieldValue("cuenta", nota.getCuenta_bancaria().getDescripcion());
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
