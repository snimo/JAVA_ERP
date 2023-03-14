package com.srn.erp.conciTarjeta.op;

import com.srn.erp.conciTarjeta.bm.ConciliarAutomaticaTarj;
import com.srn.erp.conciTarjeta.bm.EmpresaConciTar;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class ConciliacionAutomatica extends Operation {

	public ConciliacionAutomatica() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {

		Integer oidEmpresa = mapaDatos.getInteger("oid_empresa");
		EmpresaConciTar empresa = EmpresaConciTar.findByOidProxy(oidEmpresa, this.getSesion());
		
		ConciliarAutomaticaTarj conciliacionAutomatica =
			new ConciliarAutomaticaTarj();		
		
		IDataSet dsTarjetas = mapaDatos.getDataSet("TTarjetas");
		dsTarjetas.first();
		while (!dsTarjetas.EOF()) {
			
			String codigo = dsTarjetas.getString("codigo");
			conciliacionAutomatica.addTarjAConci(codigo);
			
			dsTarjetas.next();
		}
		

		conciliacionAutomatica.setSesion(this.getSesion());
		conciliacionAutomatica.setEmpresa(empresa);
		conciliacionAutomatica.conciliar();
		
		IDataSet ds = this.getDSInfoConciAut();
		cargarRegistro(ds, 
				conciliacionAutomatica.getNroCorrida(), 
				conciliacionAutomatica.getNroCuponesProcesados(), 
				conciliacionAutomatica.getNroCuponesConci());
		writeCliente(ds);
		
	}
	
	  private IDataSet getDSInfoConciAut() {
		    IDataSet dataset = new TDataSet();
		    dataset.create("TInfoConciAut");
		    dataset.fieldDef(new Field("nro_corrida", Field.INTEGER, 0));
		    dataset.fieldDef(new Field("procesados", Field.INTEGER, 0));
		    dataset.fieldDef(new Field("conciliados", Field.INTEGER, 0));
		    return dataset;
	  }

	  private void cargarRegistro(IDataSet dataset,
		                         Integer nroCorrida,
		                         Integer procesados,
		                         Integer conciliados) {
		    dataset.append();
		    dataset.fieldValue("nro_corrida", nroCorrida);
		    dataset.fieldValue("procesados", procesados);
		    dataset.fieldValue("conciliados", conciliados);
	  }	
	
	

}
