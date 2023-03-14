package com.srn.erp.tesoreria.op;

import java.util.Date;

import com.srn.erp.general.bm.Cotizacion;
import com.srn.erp.general.bm.InformarComprobante;
import com.srn.erp.general.bm.Talonario;
import com.srn.erp.general.bm.TipoCambio;
import com.srn.erp.tesoreria.bm.Caja;
import com.srn.erp.tesoreria.bm.TipoValor;
import com.srn.erp.tesoreria.bm.TransferenciaEfectivo;
import com.srn.erp.tesoreria.bm.TransferenciaValor;
import com.srn.erp.tesoreria.bm.TransferenciaValores;
import com.srn.erp.tesoreria.bm.Valor;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveTransferenciasEntreCajas extends Operation {

	public SaveTransferenciasEntreCajas() {
	}
	
	private TransferenciaValores transferencia = null;

	public void execute(MapDatos mapaDatos) throws BaseException {
		
		IDataSet dsTransferencia = mapaDatos.getDataSet("TTransValores");
		dsTransferencia.first();
		while (!dsTransferencia.EOF()) {
			
			transferencia =
				TransferenciaValores.findByOid(dsTransferencia.getInteger("oid_transf_val"),this.getSesion());
			procesarTransferencia(transferencia,dsTransferencia);
			
			this.addTransaccion(transferencia);
			
			
			dsTransferencia.next();
		}
		
	}

	private void procesarTransferencia(
			TransferenciaValores transferencia,
			IDataSet dsTransferencia) throws BaseException {
		
		Date fecha = dsTransferencia.getDate("fecha");
		HashTableDatos listaCotizaciones = 
			Cotizacion.getListaCotizaciones(fecha,TipoCambio.getTipoCambioTransferenciaValores(this.getSesion()),this.getSesion());
		
		transferencia.addCotizacionesMonedas(listaCotizaciones);
		transferencia.setContabiliza(true);
		Talonario talonario = 
			Talonario.findByOidProxy(dsTransferencia.getInteger("oid_talonario"), getSesion());
		transferencia.setTalonario(talonario);
		if (talonario == null)
			throw new ExceptionValidation(null,"Debe ingresar un talonario");
		transferencia.setActivo(new Boolean(true));
		transferencia.setTipoCompro(talonario.getTipo_comprobante());
		transferencia.setLetra(talonario.getLetra());
		transferencia.setLugarEmision(talonario.getLugar_emision());
		transferencia.setNrolugemision(talonario.getLugar_emision().getLugemi());
		transferencia.setEmision(fecha);
		transferencia.setImputac(fecha);
		transferencia.setComentario(dsTransferencia.getString("comentario"));
		transferencia.setImputac(fecha);
		transferencia.setCajaOrigen(Caja.findByOidProxy(dsTransferencia.getInteger("oid_caja_origen"), getSesion()));
		transferencia.setCajaDestino(Caja.findByOidProxy(dsTransferencia.getInteger("oid_caja_destino"), getSesion()));
		
		IDataSet dsTransfEfectivo = 
			dsTransferencia.getDataSet("TTransferenciaEfectivo");
		dsTransfEfectivo.first();
		while (!dsTransfEfectivo.EOF()) {
			
			if ((dsTransfEfectivo.getMoney("transferido")==null) || 
					(dsTransfEfectivo.getMoney("transferido").doubleValue()==0)) {
				dsTransfEfectivo.next();
				continue;
			}
			
			TransferenciaEfectivo transfEfectivo =
				TransferenciaEfectivo.findByOidProxy(dsTransfEfectivo.getInteger("oid_trans_efe"),this.getSesion());
			transfEfectivo.setTransferencia_valores(transferencia);
			transfEfectivo.setTipo_valor(TipoValor.findByOidProxy(dsTransfEfectivo.getInteger("oid_tipo_valor"), this.getSesion()));
			transfEfectivo.setSaldo(dsTransfEfectivo.getMoney("saldo"));
			transfEfectivo.setTransferido(dsTransfEfectivo.getMoney("transferido"));
			transferencia.addTransferenciaEfectivo(transfEfectivo);
			dsTransfEfectivo.next();
			
		}
		
		IDataSet dsValoresATransf = 
			dsTransferencia.getDataSet("TValoresATransf");
		dsValoresATransf.first();
		while (!dsValoresATransf.EOF()) {
			
			if (dsValoresATransf.getBoolean("sel").booleanValue()==false) {
				dsValoresATransf.next();
				continue;
			}
			
			TransferenciaValor transferenciaValor =
				TransferenciaValor.findByOidProxy(dsValoresATransf.getInteger("oid_val_transf"),this.getSesion());
			transferenciaValor.setTransferencia_valores(transferencia);
			transferenciaValor.setValor(Valor.findByOidProxy(dsValoresATransf.getInteger("oid_valor"), this.getSesion()));
			transferenciaValor.setImporte(dsValoresATransf.getMoney("importe"));
			transferenciaValor.setTransferido(dsValoresATransf.getMoney("importe"));
			transferencia.addTransferenciaValor(transferenciaValor);
			dsValoresATransf.next();
		}
		
	}

	protected void afterSave() throws BaseException {

		InformarComprobante infoCompro = 
			new InformarComprobante(transferencia.getOIDInteger(), 
					transferencia.getDescripcion());

		writeCliente(infoCompro.getDataSetInfoCompro());

	}
	

}
