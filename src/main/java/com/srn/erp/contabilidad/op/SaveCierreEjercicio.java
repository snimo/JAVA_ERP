package com.srn.erp.contabilidad.op;

import com.srn.erp.contabilidad.bm.ComproCierreEjercicio;
import com.srn.erp.contabilidad.bm.CuentaImputable;
import com.srn.erp.contabilidad.bm.Ejercicio;
import com.srn.erp.general.bm.Moneda;
import com.srn.erp.general.bm.Talonario;

import framework.applicarionServer.bm.Varios.CalculadorMoney;
import framework.applicarionServer.bm.Varios.Money;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveCierreEjercicio extends Operation {

  public SaveCierreEjercicio() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    IDataSet dataset = mapaDatos.getDataSet("TCierreContable");
    procesarRegistros(dataset);
  }

  private void procesarRegistros(IDataSet dataset) throws BaseException {
	  
	  Moneda monedaCursoLegal =   
		  Moneda.getMonedaCursoLegal(this.getSesion());  
	  
    dataset.first();
      while (!dataset.EOF()) {    	  
    	ComproCierreEjercicio comproCierreEjercicio =
    		ComproCierreEjercicio.findByOid(dataset.getInteger("oid_cierre_contable"), this.getSesion());
    	
    	Talonario talonario = ComproCierreEjercicio.getTalonatioAsientoCierreEjercicio(this.getSesion());
    	comproCierreEjercicio.setTalonario(talonario);
    	comproCierreEjercicio.setContabiliza(true);
    	comproCierreEjercicio.setEmision(dataset.getDate("fec_emision"));
    	comproCierreEjercicio.setImputac(dataset.getDate("fec_imputacion"));
    	comproCierreEjercicio.setTipoCompro(talonario.getTipo_comprobante());
    	comproCierreEjercicio.setLetra(talonario.getLetra());
    	comproCierreEjercicio.setLugarEmision(talonario.getLugar_emision());
    	comproCierreEjercicio.setNrolugemision(talonario.getLugar_emision().getLugemi());
    	comproCierreEjercicio.setComentario("");
    	comproCierreEjercicio.setEjercicio(Ejercicio.findByOidProxy(dataset.getInteger("oid_ejercicio"), this.getSesion()));
    	comproCierreEjercicio.setCierreDe(dataset.getString("cierre_de"));
    	comproCierreEjercicio.setActivo(dataset.getBoolean("activo"));
    	if (!comproCierreEjercicio.isActivo()) {
    		comproCierreEjercicio.delete();
    		addTransaccion(comproCierreEjercicio);
    		return;
      	}
    	
    	
    	IDataSet dsCierreEjerDet = dataset.getDataSet("TCierreContableDet");
    	dsCierreEjerDet.first();
    	while ((!dsCierreEjerDet.EOF()) && (comproCierreEjercicio.isActivo())) {
    		
    		
    		// Calcular el Signo segun el Saldo
    		int signoAsientoMonLoc = 1;
    		CalculadorMoney saldoMonLoc = new CalculadorMoney(new Money(0));
    		saldoMonLoc.sumar(dsCierreEjerDet.getMoney("debe_mon_loc"));
    		saldoMonLoc.restar(dsCierreEjerDet.getMoney("haber_mon_loc"));
    		if (saldoMonLoc.getResult()>0)
    			signoAsientoMonLoc = 1;
    		else if (saldoMonLoc.getResult()<0) {
    			signoAsientoMonLoc = -1;
    			saldoMonLoc.multiplicarPor(new Money(-1));
    		}
    		
    		// Moneda Ajustado
    		int signoAsientoMonAju = 1;
    		CalculadorMoney saldoMonAju = new CalculadorMoney(new Money(0));
    		saldoMonAju.sumar(dsCierreEjerDet.getMoney("debe_mon_aju"));
    		saldoMonAju.restar(dsCierreEjerDet.getMoney("haber_mon_aju"));
    		if (saldoMonAju.getResult()>0)
    			signoAsientoMonAju = 1;
    		else if (saldoMonAju.getResult()<0) {
    			signoAsientoMonAju = -1;
    			saldoMonAju.multiplicarPor(new Money(-1));
    		}
    		
    		// Moneda Ext 1
    		int signoAsientoMonExt1 = 1;
    		CalculadorMoney saldoMonExt1 = new CalculadorMoney(new Money(0));
    		saldoMonExt1.sumar(dsCierreEjerDet.getMoney("debe_mon_ext_1"));
    		saldoMonExt1.restar(dsCierreEjerDet.getMoney("haber_mon_ext_1"));
    		if (saldoMonExt1.getResult()>0)
    			signoAsientoMonExt1 = 1;
    		else if (saldoMonExt1.getResult()<0) {
    			signoAsientoMonExt1 = -1;
    			saldoMonExt1.multiplicarPor(new Money(-1));
    		}
    		
    		// Moneda Ext 2
    		int signoAsientoMonExt2 = 1;
    		CalculadorMoney saldoMonExt2 = new CalculadorMoney(new Money(0));
    		saldoMonExt2.sumar(dsCierreEjerDet.getMoney("debe_mon_ext_2"));
    		saldoMonExt2.restar(dsCierreEjerDet.getMoney("haber_mon_ext_2"));
    		if (saldoMonExt2.getResult()>0)
    			signoAsientoMonExt2 = 1;
    		else if (saldoMonExt2.getResult()<0) {
    			signoAsientoMonExt2 = -1;    		
    			saldoMonExt2.multiplicarPor(new Money(-1));
    		}
    		
    		/*
    		if (dsCierreEjerDet.getInteger("signo").intValue() == RenglonAsiento.DEBE) {
    			impoMonLocHist = dsCierreEjerDet.getMoney("debe_mon_loc");
        		impoMonLocAju = dsCierreEjerDet.getMoney("debe_mon_aju");
        		impoMonExt1 = dsCierreEjerDet.getMoney("debe_mon_ext_1");
        		impoMonExt2 = dsCierreEjerDet.getMoney("debe_mon_ext_2");
    		} else {
    			impoMonLocHist = dsCierreEjerDet.getMoney("haber_mon_loc");
        		impoMonLocAju = dsCierreEjerDet.getMoney("haber_mon_aju");
        		impoMonExt1 = dsCierreEjerDet.getMoney("haber_mon_ext_1");
        		impoMonExt2 = dsCierreEjerDet.getMoney("haber_mon_ext_2");
    		}*/
    		
    		CuentaImputable cuentaImputable = CuentaImputable.findByOidProxy(dsCierreEjerDet.getInteger("oid_ai"), this.getSesion());
    		comproCierreEjercicio.addRenglonCierre(cuentaImputable,
    				signoAsientoMonLoc,
    				saldoMonLoc.getResultMoney(),
    				new Money(0),
    				new Money(0),
    				new Money(0),
    				monedaCursoLegal,
    				saldoMonLoc.getResultMoney(),
    				null,
    				null,
    				null
    				);
    		comproCierreEjercicio.addRenglonCierre(cuentaImputable,
    				signoAsientoMonAju,
    				new Money(0),
    				saldoMonAju.getResultMoney(),
    				new Money(0),
    				new Money(0),
    				monedaCursoLegal,
    				new Money(0),
    				null,
    				null,
    				null
    				);
    		comproCierreEjercicio.addRenglonCierre(cuentaImputable,
    				signoAsientoMonExt1,
    				new Money(0),
    				new Money(0),
    				saldoMonExt1.getResultMoney(),
    				new Money(0),
    				monedaCursoLegal,
    				new Money(0),
    				null,
    				null,
    				null
    				);
    		comproCierreEjercicio.addRenglonCierre(cuentaImputable,
    				signoAsientoMonExt2,
    				new Money(0),
    				new Money(0),
    				new Money(0),
    				saldoMonExt2.getResultMoney(),
    				monedaCursoLegal,
    				new Money(0),
    				null,
    				null,
    				null
    				);    		
    		
    			
    		dsCierreEjerDet.next();
    	}
    	
    	
    	
        addTransaccion(comproCierreEjercicio);
        dataset.next();
    }
  }

}
