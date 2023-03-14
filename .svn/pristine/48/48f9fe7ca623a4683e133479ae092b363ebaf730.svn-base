package com.srn.erp.cashflow.bm;

import framework.applicarionServer.bl.Utils.Fecha;
import framework.request.bl.Utils.BaseException;

public class RangoFechasCF {
	
	private java.util.Date fecDesde;
	private java.util.Date fecHasta;
	
	public java.util.Date getFecDesde() {
		return fecDesde;
	}
	public void setFecDesde(java.util.Date fecDesde) {
		this.fecDesde = fecDesde;
	}
	public java.util.Date getFecHasta() {
		return fecHasta;
	}
	public void setFecHasta(java.util.Date fecHasta) {
		this.fecHasta = fecHasta;
	}
	
	public String getDescripcion() throws BaseException {
		return Fecha.getyyyymmdd(getFecDesde())+" al "+Fecha.getyyyymmdd(getFecHasta());
	}
	

}
