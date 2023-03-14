package com.srn.erp.conciTarjeta.op;

import java.util.Iterator;
import java.util.List;

import com.srn.erp.conciTarjeta.bm.ArchLoteConciDet;
import com.srn.erp.conciTarjeta.bm.DetAsiLiquiTarj;
import com.srn.erp.conciTarjeta.bm.DetAsiTarjACobrar;
import com.srn.erp.conciTarjeta.bm.EmpresaConciTar;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerConsMayorTarjDebCre extends Operation {

	public TraerConsMayorTarjDebCre() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		IDataSet ds = this.getDataSetMayor();
		
		String cuenta = mapaDatos.getString("cuenta");
		java.util.Date fecDesde  = mapaDatos.getDate("fec_desde");
		java.util.Date fecHasta  = mapaDatos.getDate("fec_hasta");
		EmpresaConciTar empresa = EmpresaConciTar.findByOidProxy(mapaDatos.getInteger("oid_empresa"), this.getSesion()); 
		
		int secu = 0;
		double saldo = getSaldo(empresa,cuenta,fecDesde);
		
		if (saldo<0)
			cargarRegistroMayor(ds, secu, fecDesde, "Saldo Inicial", "", "", "", 0, saldo*-1);
		else
			cargarRegistroMayor(ds, secu, fecDesde, "Saldo Inicial", "", "", "", saldo, 0);
		
		Iterator iterDetAsiTarjACobrar = 
			DetAsiTarjACobrar.getDetAsiACob(empresa,cuenta, fecDesde, fecHasta, this.getSesion()).iterator();
		while (iterDetAsiTarjACobrar.hasNext()) {
			DetAsiTarjACobrar detAsiTarjACobrar = (DetAsiTarjACobrar) iterDetAsiTarjACobrar.next();
			++secu;
			String referencia = "";
			
			List listaArchLoteDet = 
				ArchLoteConciDet.getArchLoteDetByAsiCob(detAsiTarjACobrar.getCab_asi_acob(), this.getSesion());
			
			if (listaArchLoteDet.size()>0) {
				ArchLoteConciDet archLoteConciDet = (ArchLoteConciDet) listaArchLoteDet.get(0);
				if (archLoteConciDet.getRefSistExt()!=null)
					referencia = archLoteConciDet.getRefSistExt();
			}
			
			cargarRegistroMayor(ds, 
					secu, 
					detAsiTarjACobrar.getCab_asi_acob().getFec_asiento(),
					referencia, 
					detAsiTarjACobrar.getCompo1(),
					detAsiTarjACobrar.getCompo2(), 
					detAsiTarjACobrar.getCab_asi_acob().getComentario(), 
					detAsiTarjACobrar.getDebe(),
					detAsiTarjACobrar.getHaber());
		}
		
		Iterator iterDetAsiLiquiTarj = 
			DetAsiLiquiTarj.getDetAsiLiqTarj(empresa,cuenta, fecDesde, fecHasta, this.getSesion()).iterator();
		while (iterDetAsiLiquiTarj.hasNext()) {
			DetAsiLiquiTarj detAsiLiquiTarj = (DetAsiLiquiTarj) iterDetAsiLiquiTarj.next();
			++secu;
			String referencia = "";
			
			List listaArchLoteDet = 
				ArchLoteConciDet.getArchLoteDetAsiLiq(detAsiLiquiTarj.getCabasiliqtarj(), this.getSesion());
			
			if (listaArchLoteDet.size()>0) {
				ArchLoteConciDet archLoteConciDet = (ArchLoteConciDet) listaArchLoteDet.get(0);
				if (archLoteConciDet.getRefSistExt1()!=null)
					referencia = archLoteConciDet.getRefSistExt1();
			}			
			
			cargarRegistroMayor(ds, 
					secu, 
					detAsiLiquiTarj.getCabasiliqtarj().getFec_asiento(),
					referencia, 
					detAsiLiquiTarj.getCompo1(),
					detAsiLiquiTarj.getCompo2(), 
					detAsiLiquiTarj.getCabasiliqtarj().getComentario(), 
					detAsiLiquiTarj.getDebe(),
					detAsiLiquiTarj.getHaber());			
		}
		
		writeCliente(ds);
	}

	private IDataSet getDataSetMayor() {
		IDataSet dataset = new TDataSet();
		dataset.create("TMovConsMayor");
		dataset.fieldDef(new Field("secu", Field.INTEGER, 0));
		dataset.fieldDef(new Field("fecha", Field.DATE, 0));
		dataset.fieldDef(new Field("referencia", Field.STRING, 100));
		dataset.fieldDef(new Field("compo1", Field.STRING, 50));
		dataset.fieldDef(new Field("compo2", Field.STRING, 50));
		dataset.fieldDef(new Field("comentario", Field.STRING, 255));
		dataset.fieldDef(new Field("debe", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("haber", Field.CURRENCY, 0));
		return dataset;
	}
	
	private double getSaldo(EmpresaConciTar empresa, String cuenta,java.util.Date fecha) throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put("CUENTA", cuenta);
		condiciones.put("FECHA", fecha);
		condiciones.put(EmpresaConciTar.NICKNAME, empresa);
		
		double asiCobranza = DetAsiTarjACobrar.getSaldoAUnaFecha(condiciones, this.getSesion());
		double asiLiquidacion = DetAsiLiquiTarj.getSaldoAUnaFecha(condiciones, this.getSesion());
		double totSaldo = asiCobranza + asiLiquidacion;
		return totSaldo;
	}

	private void cargarRegistroMayor(IDataSet dataset, Integer secu, java.util.Date fecha, String referencia, String compo1, String compo2,
			String comentario, double debe, double haber) {
		dataset.append();
		dataset.fieldValue("secu", secu);
		dataset.fieldValue("fecha", fecha);
		dataset.fieldValue("referencia", referencia);
		dataset.fieldValue("compo1", compo1);
		dataset.fieldValue("compo2", compo2);
		dataset.fieldValue("comentario", comentario);
		dataset.fieldValue("debe", debe);
		dataset.fieldValue("haber", haber);
	}
}
