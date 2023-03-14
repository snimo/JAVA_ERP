package com.srn.erp.conciTarjeta.op;


import java.util.Iterator;

import com.srn.erp.cip.bm.UtilCIP;
import com.srn.erp.conciTarjeta.bm.ArchLoteConciDet;
import com.srn.erp.conciTarjeta.bm.ArmadoAsiCob;
import com.srn.erp.conciTarjeta.bm.EmpresaConciTar;
import com.srn.erp.conciTarjeta.bm.RenglonAsiCobTarj;

import framework.applicarionServer.bm.Varios.Money;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class ProponerAsiCobTarj extends Operation {

	private ArmadoAsiCob armadoAsiCob;
	private boolean misMarcados = false;
	
	public ProponerAsiCobTarj() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {

		armadoAsiCob = new ArmadoAsiCob();
		Integer oidEmpresa = mapaDatos.getInteger("oid_empresa");
		if (((mapaDatos.containsKey("mis_marcados") && (mapaDatos.getString("mis_marcados").equals("SI"))))) {
			misMarcados = true;
		}
		
		EmpresaConciTar empresa = EmpresaConciTar.findByOidProxy(oidEmpresa, this.getSesion());
		
		armadoAsiCob.setSesion(this.getSesion());
		armadoAsiCob.setEmpresa(empresa);
		
		IDataSet dsAsiCab = this.getDSAsientoCab();
		IDataSet ds = getDSArchLoteDet();
		IDataSet dsAsiento = this.getDSAsientoGenCob();
		
		cargarAsientoCab(dsAsiCab, UtilCIP.getFechaHoraActual(this.getSesion()), "");
		
		Iterator iterArchLoteDet = 
			ArchLoteConciDet.getArchLoteDetMarcadosAsiACobNoConta(empresa,misMarcados,this.getSesion()).iterator();
		while (iterArchLoteDet.hasNext()) {
			ArchLoteConciDet archLoteConciDet = (ArchLoteConciDet) iterArchLoteDet.next();
			armadoAsiCob.addDetalle(archLoteConciDet);
			cargar(ds, archLoteConciDet);
		}
		
		Iterator iterRenglones = armadoAsiCob.getRenglonesResu();
		while (iterRenglones.hasNext()) {
			RenglonAsiCobTarj renglon = (RenglonAsiCobTarj) iterRenglones.next();
			if (renglon.getImporte().doubleValue()>0)
				cargarAsiento(dsAsiento, renglon.getCuenta(), renglon.getCompo1(), renglon.getCompo2(), renglon.getImporte().doubleValue(), new Money(0).doubleValue());
			else
				cargarAsiento(dsAsiento, renglon.getCuenta(), renglon.getCompo1(), renglon.getCompo2(), new Money(0).doubleValue() , Math.abs(renglon.getImporte().doubleValue()));
		}
		
		writeCliente(dsAsiCab);
		writeCliente(ds);
		writeCliente(dsAsiento);
		

	}

	private IDataSet getDSArchLoteDet() {
		IDataSet dataset = new TDataSet();
		dataset.create("TDetAsiCobAGenerar");
		dataset.fieldDef(new Field("oid_arch_lote_det", Field.INTEGER, 0));
		return dataset;
	}
	
	private IDataSet getDSAsientoCab() {
		IDataSet dataset = new TDataSet();
		dataset.create("TAsientoCab");
		dataset.fieldDef(new Field("fecha", Field.DATE, 0));
		dataset.fieldDef(new Field("comentario", Field.STRING, 100));
		return dataset;
	}	
	
	private IDataSet getDSAsientoGenCob() {
		IDataSet dataset = new TDataSet();
		dataset.create("TAsiento");
		dataset.fieldDef(new Field("cuenta", Field.STRING, 50));
		dataset.fieldDef(new Field("compo1", Field.STRING, 50));
		dataset.fieldDef(new Field("compo2", Field.STRING, 50));
		dataset.fieldDef(new Field("debe", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("haber", Field.CURRENCY, 0));
		return dataset;
	}	

	private void cargar(IDataSet dataset, ArchLoteConciDet archLoteConciDet) {
		dataset.append();
		dataset.fieldValue("oid_arch_lote_det", archLoteConciDet.getOIDInteger());
	}
	
	private void cargarAsientoCab(IDataSet dataset, java.util.Date fecha,String comentario) {
		dataset.append();
		dataset.fieldValue("fecha", fecha);
		dataset.fieldValue("comentario", comentario);
	}	
	
	private void cargarAsiento(IDataSet dataset, 
			String cuenta,
			String compo1,
			String compo2,
			double debe,
			double haber) {
		dataset.append();
		dataset.fieldValue("cuenta", cuenta);
		dataset.fieldValue("compo1", compo1);
		dataset.fieldValue("compo2", compo2);
		dataset.fieldValue("debe", debe);
		dataset.fieldValue("haber", haber);		
	}	

}
