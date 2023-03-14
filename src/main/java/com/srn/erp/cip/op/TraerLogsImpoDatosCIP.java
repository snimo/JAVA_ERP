package com.srn.erp.cip.op;

import java.util.Iterator;

import com.srn.erp.cip.bm.LogImpDatosCIP;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerLogsImpoDatosCIP extends Operation {

	public TraerLogsImpoDatosCIP() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		IDataSet ds = this.getDataSetLogs();
		Iterator iterLogs = LogImpDatosCIP.getAll(this.getSesion()).iterator();
		while (iterLogs.hasNext()) {
			LogImpDatosCIP logImpDatosCIP = (LogImpDatosCIP) iterLogs.next();
			cargarRegistro(ds, logImpDatosCIP);
		}
		writeCliente(ds);
	}

	private IDataSet getDataSetLogs() {
		IDataSet dataset = new TDataSet();
		dataset.create("TLogs");
		dataset.fieldDef(new Field("OID_LOG_IMP", Field.INTEGER, 0));
		dataset.fieldDef(new Field("TIPO_IMP", Field.STRING, 20));
		dataset.fieldDef(new Field("FECHA" , Field.DATE, 0));
		dataset.fieldDef(new Field("SE_EJECUTO", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("HUBO_ERROR", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("MOT_NO_EJECUTO", Field.STRING, 100));
		dataset.fieldDef(new Field("OBSERVACION", Field.STRING, 100));
		dataset.fieldDef(new Field("DESC_ERROR", Field.MEMO, 0));
		dataset.fieldDef(new Field("HORA", Field.STRING, 8));
		return dataset;
	}

	private void cargarRegistro(IDataSet dataset, LogImpDatosCIP logImpDatosCIP) throws BaseException {
		
		dataset.append();
		dataset.fieldValue("OID_LOG_IMP", logImpDatosCIP.getOIDInteger());
		dataset.fieldValue("TIPO_IMP", logImpDatosCIP.getTipo_imp());
		dataset.fieldValue("FECHA" , logImpDatosCIP.getFecha());
		dataset.fieldValue("SE_EJECUTO", logImpDatosCIP.isSe_ejecuto());
		dataset.fieldValue("HUBO_ERROR", logImpDatosCIP.isHubo_error());
		dataset.fieldValue("MOT_NO_EJECUTO", logImpDatosCIP.getMot_no_ejecuto());
		dataset.fieldValue("OBSERVACION", logImpDatosCIP.getObservacion());
		dataset.fieldValue("DESC_ERROR", logImpDatosCIP.getDesc_error());
		dataset.fieldValue("HORA", logImpDatosCIP.getHora());
	}

}
