package com.srn.erp.tesoreria.op;

import java.util.Iterator;

import com.srn.erp.tesoreria.bm.TransferenciaEfectivo;
import com.srn.erp.tesoreria.bm.TransferenciaValor;
import com.srn.erp.tesoreria.bm.TransferenciaValores;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerTransferenciasEntreCajas extends Operation {

	public TraerTransferenciasEntreCajas() {
	}
	
	public void execute(MapDatos mapaDatos) throws BaseException {
		
		IDataSet dsTransferencia = getDSTransfValores();
		IDataSet dsTransfEfectivo = getDSTransfEfectivo();
		IDataSet dsTransfValor = getDSTransfValor();
		
		TransferenciaValores transfVal =
			TransferenciaValores.findByOid(mapaDatos.getInteger("oid"),this.getSesion());
		
		cargarTransferencia(dsTransferencia,transfVal);
		
		Iterator iterTransEfe = 
			transfVal.getTransferenciasEfectivo().iterator();
		while (iterTransEfe.hasNext()) {
			TransferenciaEfectivo transfEfectivo = (TransferenciaEfectivo) iterTransEfe.next();
			cargarTransferenciaEfectivo(dsTransfEfectivo,transfEfectivo);
		}
		
		Iterator iterTransVal = 
			transfVal.getTransferenciasValores().iterator();
		while (iterTransVal.hasNext()) {
			TransferenciaValor transfValor = (TransferenciaValor) iterTransVal.next();
			cargarTransferenciaValor(dsTransfValor,transfValor);
		}
		
		
		
		writeCliente(dsTransferencia);
		writeCliente(dsTransfEfectivo);
		writeCliente(dsTransfValor);
		
	}
	
	private void cargarTransferenciaValor(IDataSet dsTransfValor,TransferenciaValor transVal) throws BaseException {

		dsTransfValor.append();
		dsTransfValor.fieldValue("oid_val_transf", transVal.getOIDInteger());
		dsTransfValor.fieldValue("oid_transf_val", transVal.getTransferencia_valores().getOIDInteger());
		dsTransfValor.fieldValue("oid_valor", transVal.getValor().getOIDInteger());
		dsTransfValor.fieldValue("importe", transVal.getImporte());
		dsTransfValor.fieldValue("transferido", transVal.getTransferido());
		dsTransfValor.fieldValue("oid_tipo_valor", transVal.getValor().getTipovalor().getOIDInteger());
		dsTransfValor.fieldValue("desc_tipo_valor", transVal.getValor().getTipovalor().getDescripcion());
		dsTransfValor.fieldValue("desc_valor", transVal.getValor().getDescripcion());
		dsTransfValor.fieldValue("oid_moneda", transVal.getValor().getTipovalor().getMoneda().getOIDInteger());
		dsTransfValor.fieldValue("simbolo_moneda",transVal.getValor().getTipovalor().getMoneda().getSimbolo());
		dsTransfValor.fieldValue("sel",new Boolean(true));
	}
	
	
	private void cargarTransferenciaEfectivo(IDataSet dsTransfEfectivo,TransferenciaEfectivo transEfe) throws BaseException {
		dsTransfEfectivo.append();
		dsTransfEfectivo.fieldValue("oid_trans_efe", transEfe.getOIDInteger());
		dsTransfEfectivo.fieldValue("oid_transf_val",transEfe.getTransferencia_valores().getOIDInteger());
		dsTransfEfectivo.fieldValue("oid_tipo_valor",transEfe.getTipo_valor().getOIDInteger());
		dsTransfEfectivo.fieldValue("saldo",transEfe.getSaldo());
		dsTransfEfectivo.fieldValue("transferido",transEfe.getTransferido());
		dsTransfEfectivo.fieldValue("desc_tipo_valor",transEfe.getTipo_valor().getDescripcion());
	}
	
	private void cargarTransferencia(IDataSet dsTransferencia,TransferenciaValores transVal) throws BaseException {
		dsTransferencia.append();
		dsTransferencia.fieldValue("oid_transf_val",transVal.getOIDInteger());
		dsTransferencia.fieldValue("oid_talonario",transVal.getTalonario().getOIDInteger());
		dsTransferencia.fieldValue("fecha", transVal.getEmision());
		dsTransferencia.fieldValue("oid_caja_origen", transVal.getCajaOrigen().getOIDInteger());
		dsTransferencia.fieldValue("oid_caja_destino", transVal.getCajaDestino().getOIDInteger());
		dsTransferencia.fieldValue("comentario", transVal.getComentario());
	}

  private IDataSet getDSTransfValores() {
    IDataSet dataset = new TDataSet();
    dataset.create("TTransValores");
    dataset.fieldDef(new Field("oid_transf_val", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_talonario", Field.INTEGER, 0));
    dataset.fieldDef(new Field("fecha", Field.DATE, 0));
    dataset.fieldDef(new Field("oid_caja_origen", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_caja_destino", Field.INTEGER, 0));
    dataset.fieldDef(new Field("comentario", Field.MEMO, 0));
    return dataset;
  }
  
  private IDataSet getDSTransfEfectivo() {
    IDataSet dataset = new TDataSet();
    dataset.create("TTransferenciaEfectivo");
    dataset.fieldDef(new Field("oid_trans_efe", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_transf_val",Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_tipo_valor",Field.INTEGER, 0));
    dataset.fieldDef(new Field("saldo",Field.CURRENCY, 0));
    dataset.fieldDef(new Field("transferido",Field.CURRENCY, 0));
    dataset.fieldDef(new Field("desc_tipo_valor",Field.STRING, 100));
    return dataset;
  }
  
  private IDataSet getDSTransfValor() {
    IDataSet dataset = new TDataSet();
    dataset.create("TValoresATransf");
    dataset.fieldDef(new Field("oid_val_transf", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_transf_val", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_valor", Field.INTEGER, 0));
    dataset.fieldDef(new Field("importe", Field.CURRENCY, 0));
    dataset.fieldDef(new Field("transferido", Field.CURRENCY, 0));
    dataset.fieldDef(new Field("oid_tipo_valor", Field.INTEGER, 0));
    dataset.fieldDef(new Field("desc_tipo_valor", Field.STRING, 100));
    dataset.fieldDef(new Field("desc_valor", Field.STRING, 1000));
    dataset.fieldDef(new Field("oid_moneda", Field.INTEGER, 0));
    dataset.fieldDef(new Field("simbolo_moneda",Field.STRING, 20));
    dataset.fieldDef(new Field("sel",Field.BOOLEAN, 0));
    return dataset;
  }
	

}
