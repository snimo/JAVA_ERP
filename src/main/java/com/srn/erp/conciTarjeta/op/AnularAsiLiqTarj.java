package com.srn.erp.conciTarjeta.op;

import java.util.Iterator;

import com.srn.erp.conciTarjeta.bm.ArchLoteConciDet;
import com.srn.erp.conciTarjeta.bm.CabAsiLiquiTarj;
import com.srn.erp.conciTarjeta.bm.DetAsiLiquiTarj;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;
import framework.request.bl.Utils.MapDatos;

public class AnularAsiLiqTarj extends Operation {

	public AnularAsiLiqTarj() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {

		CabAsiLiquiTarj cabAsiLiquiTarj = 
			CabAsiLiquiTarj.findByOid(mapaDatos.getInteger("oid_cab_asi_liq"), this.getSesion());
				
		if (cabAsiLiquiTarj == null)
			throw new ExceptionValidation(null,"Debe seleccionar un asiento de Liquidación");
		
		if (!cabAsiLiquiTarj.isActivo())
			throw new ExceptionValidation(null,"El asiento de liquidación "+cabAsiLiquiTarj.getNro_liquidacion()+" ya se encuentra anulado.");
		
		cabAsiLiquiTarj.supportRefresh();
		
		Iterator iterCabAsiLiquiTarj =
			cabAsiLiquiTarj.getDetalles().iterator();
		while (iterCabAsiLiquiTarj.hasNext()) {
			DetAsiLiquiTarj detAsiLiquiTarj = (DetAsiLiquiTarj) iterCabAsiLiquiTarj.next();
			detAsiLiquiTarj.supportRefresh();
			if (!detAsiLiquiTarj.isActivo())
				throw new ExceptionValidation(null,"El asiento ya se encuentra anulado.");
			detAsiLiquiTarj.delete();
		}
		
		Iterator iterArchLoteDetAsiLiq = 
			cabAsiLiquiTarj.getArchLoteDetAsiLiq().iterator();
		while (iterArchLoteDetAsiLiq.hasNext()) {
			ArchLoteConciDet archLoteConciDet = (ArchLoteConciDet) iterArchLoteDetAsiLiq.next();
			if (!archLoteConciDet.isActivo()) continue;
			archLoteConciDet.supportRefresh();
			archLoteConciDet.setContaAsiLiq(false);
			archLoteConciDet.setNroLiquidacion(null);
			archLoteConciDet.setCabAsiLiquiTarj(null);
			archLoteConciDet.setRefSistExt1(null);
			archLoteConciDet.save();
		}
		
		cabAsiLiquiTarj.delete();
		
	}

}
