package com.srn.erp.tesoreria.op;

import java.util.Iterator;

import com.srn.erp.tesoreria.bm.MovimientoCaja;
import com.srn.erp.tesoreria.bm.Valor;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerMovCajaValor extends Operation {

	public TraerMovCajaValor() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {

		Valor valor = Valor.findByOidProxy(mapaDatos.getInteger("oid_valor"), this.getSesion());

		IDataSet ds = this.getDataSetMovArqueo();
		Iterator iterMovCaja = MovimientoCaja.getMovCajaValor(valor, this.getSesion()).iterator();
		while (iterMovCaja.hasNext()) {
			MovimientoCaja mov = (MovimientoCaja) iterMovCaja.next();
			cargarRegistroMovArqueo(ds, mov);
		}

		writeCliente(ds);
	}

	private IDataSet getDataSetMovArqueo() {
		IDataSet dataset = new TDataSet();
		dataset.create("TMovArqueoValor");
		dataset.fieldDef(new Field("oid_mov_arqueo", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_caja", Field.INTEGER, 0));
		dataset.fieldDef(new Field("desc_caja", Field.STRING, 50));
		dataset.fieldDef(new Field("fecha", Field.DATE, 0));
		dataset.fieldDef(new Field("oid_cco", Field.INTEGER, 0));
		dataset.fieldDef(new Field("comprobante", Field.STRING, 50));
		dataset.fieldDef(new Field("movimiento", Field.STRING, 20));
		dataset.fieldDef(new Field("moneda", Field.STRING, 10));
		dataset.fieldDef(new Field("importe", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("oid_valor", Field.INTEGER, 0));
		dataset.fieldDef(new Field("desc_tipo_compro", Field.STRING, 50));
		dataset.fieldDef(new Field("desc_valor", Field.STRING, 500));
		return dataset;
	}

	private void cargarRegistroMovArqueo(IDataSet dataset, MovimientoCaja movimiento) throws BaseException {
		dataset.append();
		dataset.fieldValue("oid_mov_arqueo", movimiento.getOIDInteger());
		dataset.fieldValue("oid_caja", movimiento.getCaja().getOIDInteger());
		dataset.fieldValue("desc_caja", movimiento.getCaja().getDescripcion());
		dataset.fieldValue("fecha", movimiento.getFechacaja());
		dataset.fieldValue("oid_cco", movimiento.getComprobante().getOIDInteger());
		dataset.fieldValue("comprobante", movimiento.getComprobante().getCodigo());
		dataset.fieldValue("movimiento", this.getMovimiento(movimiento.getSigno()));
		dataset.fieldValue("moneda", movimiento.getMoneda().getCodigo());
		dataset.fieldValue("importe", movimiento.getImporte());
		dataset.fieldValue("activo", new Boolean(true));
		dataset.fieldValue("oid_valor", movimiento.getValor().getOIDInteger());
		dataset.fieldValue("desc_tipo_compro", movimiento.getComprobante().getTipoCompro().getDescripcion());
		if (movimiento.getValor()!=null)
			dataset.fieldValue("desc_valor", movimiento.getValor().getDescripcion());
		else
			dataset.fieldValue("desc_valor", movimiento.getTipovalor().getDescripcion());
	}

	private String getMovimiento(int signo) {
		if (signo == 1)
			return "Entrada";
		else
			return "Salida";
	}

}
