package com.srn.erp.costos.bm;

import java.util.Iterator;

import com.srn.erp.compras.bm.InformeRecepcion;
import com.srn.erp.compras.bm.InformeRecepcionDet;
import com.srn.erp.ctasAPagar.bm.ComproProvInfRecOC;
import com.srn.erp.general.bm.ComproCab;
import com.srn.erp.stock.bm.StockMovimiento;

import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;

public class ValorizarMovStock {

	private ISesion aSesion;
	private java.util.Date fecDesde;
	private java.util.Date fecHasta;
	
	public 	ValorizarMovStock(ISesion sesion) {
		aSesion = sesion;
	}
	
	private ISesion getSesion() throws BaseException {
		return aSesion;
	}
	
	public void setFecDesde(java.util.Date aFecDesde) throws BaseException {
		this.fecDesde = aFecDesde;
	}
	
	public void setFecHasta(java.util.Date aFecHasta) throws BaseException {
		this.fecHasta = aFecHasta;
	}
	
	public void valorizar() throws BaseException {
	
		// Valorizar movimiento de Stock
		valorizarEntradas();
		
	}
	
	private void valorizarEntradas() throws BaseException {
	
		Iterator iterMovIngFis = 
			StockMovimiento.getMovimientosIngresoFisico(this.getSesion(), fecDesde, fecHasta).iterator();
		while (iterMovIngFis.hasNext()) {
			StockMovimiento stockMov = (StockMovimiento) iterMovIngFis.next();
			valorizarMovimientoEntrada(stockMov);
		}
		
	}
	
	private void valorizarMovimientoEntrada(StockMovimiento stockMov) throws BaseException {
		
		// Determinar si es una entrada por informe de Recepcion
		if (stockMov.getComprobante().getTipoCompro().esInformeRecepcion())
			valorizarEntradaPorInfRec(stockMov.getComprobante(),stockMov);
		
	}
	
	private void valorizarEntradaPorInfRec(ComproCab comproCab,StockMovimiento stockMov) throws BaseException {
		
		InformeRecepcion informeRecepcion = InformeRecepcion.findByOid(comproCab.getOIDInteger(), this.getSesion());
		if (!informeRecepcion.isActivo()) return;
		
		// Obtener el detalle del informe de recepcion
		InformeRecepcionDet infRecDet =
			InformeRecepcionDet.findByOid(stockMov.getOidComproDet(), this.getSesion());
		
		Iterator iterComproProvInfRecOC = 
			infRecDet.getOrdenDeCompraDet().getComproProvInfRecOC().iterator();
		while (iterComproProvInfRecOC.hasNext()) {
			ComproProvInfRecOC comproProvInfRecOC = (ComproProvInfRecOC) iterComproProvInfRecOC.next();
			
		}
		
		
		
		
	}
	
}
