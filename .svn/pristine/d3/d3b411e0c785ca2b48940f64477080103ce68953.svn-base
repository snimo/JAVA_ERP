package com.srn.erp.conciTarjeta.op;

import com.srn.erp.conciTarjeta.bm.ArchLoteConciDet;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class MarcarDesAsiCobPOSNET extends Operation {

	public MarcarDesAsiCobPOSNET() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {

		
		ArchLoteConciDet archLoteConciDet = 
			ArchLoteConciDet.findByOid(mapaDatos.getInteger("oid_arch_lote_det"),this.getSesion());
		
		IDataSet ds = this.getDSAsiCob();
		
		if (archLoteConciDet == null)
			throw new ExceptionValidation(null,"No se encontró el cupon seleccionado");
		
		if (archLoteConciDet.isMarcaAsiACobrar()) {
			archLoteConciDet.desmarcarAsientoParaCobranza();
			ArchLoteConciDet archLoteConciDetInformar =
				ArchLoteConciDet.findByOid(archLoteConciDet.getOIDInteger(), this.getSesion());
			cargarEstadoAsiCob(ds, 
					archLoteConciDetInformar.getOIDInteger() , 
					archLoteConciDetInformar.getEstadoAsientoCobranza());
		}
		else {
			archLoteConciDet.marcarAsientoParaCobranza();
			ArchLoteConciDet archLoteConciDetInformar =
				ArchLoteConciDet.findByOid(archLoteConciDet.getOIDInteger(), this.getSesion());			
			cargarEstadoAsiCob(ds, 
					archLoteConciDetInformar.getOIDInteger() , 
					archLoteConciDetInformar.getEstadoAsientoCobranza());			
		}
		
		writeCliente(ds);
			
	}
	
	private IDataSet getDSAsiCob() {
		IDataSet dataset = new TDataSet();
		dataset.create("TEstadoAsiCob");
		dataset.fieldDef(new Field("oid_arch_lote_det", Field.INTEGER, 0));
		dataset.fieldDef(new Field("estado_asiento", Field.STRING, 50));
		return dataset;
	}	
	
	private void cargarEstadoAsiCob(
			IDataSet ds,
			Integer oidArchLotDet,
			String estadoAsiento) throws BaseException {
		ds.append();
		ds.fieldValue("oid_arch_lote_det", oidArchLotDet);
		ds.fieldValue("estado_asiento", estadoAsiento);
	}

}
