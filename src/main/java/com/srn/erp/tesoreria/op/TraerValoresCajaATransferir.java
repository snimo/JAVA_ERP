package com.srn.erp.tesoreria.op;

import java.util.Iterator;

import com.srn.erp.tesoreria.bm.Caja;
import com.srn.erp.tesoreria.bm.TipoValor;
import com.srn.erp.tesoreria.bm.Valor;

import framework.applicarionServer.bm.Varios.Money;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerValoresCajaATransferir extends Operation {

	public TraerValoresCajaATransferir() {
	}
	
	int secu = 0;

	public void execute(MapDatos mapaDatos) throws BaseException {

		Caja caja = Caja.findByOid(mapaDatos.getInteger("oid_caja"), getSesion());
		Integer oidTransferencia =  mapaDatos.getInteger("oid_transferencia");
		
		IDataSet ds = getDSValCajaATransferir();
	  Iterator iterValores = Valor.getValoresEnCaja(caja,null,(TipoValor)null,null,this.getSesion()).iterator();
	  while (iterValores.hasNext()) {
	  	Valor valor = (Valor) iterValores.next();
	  	cargarValor(ds,oidTransferencia,valor);
	  }
		
		writeCliente(ds);

	}
	
	private void cargarValor(IDataSet ds,
													 Integer oidTransferencia,	
			                     Valor valor) throws BaseException {
		ds.append();
		ds.fieldValue("oid_val_transf", new Integer(--secu));
		ds.fieldValue("oid_transf_val", oidTransferencia);
		ds.fieldValue("oid_valor", valor.getOIDInteger());
		ds.fieldValue("importe", valor.getImporte());
		ds.fieldValue("transferido", new Money(0));
		ds.fieldValue("oid_tipo_valor", valor.getTipovalor().getOIDInteger());
		ds.fieldValue("desc_tipo_valor", valor.getTipovalor().getDescripcion());
		ds.fieldValue("desc_valor", valor.getDescripcion());
		ds.fieldValue("oid_moneda", valor.getTipovalor().getMoneda().getOIDInteger());
		ds.fieldValue("simbolo_moneda", valor.getTipovalor().getMoneda().getSimbolo());
		ds.fieldValue("sel", new Boolean(false));
	}

	private IDataSet getDSValCajaATransferir() {
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
		dataset.fieldDef(new Field("simbolo_moneda", Field.STRING, 100));
		dataset.fieldDef(new Field("sel", Field.BOOLEAN, 0));
		return dataset;
	}

}
