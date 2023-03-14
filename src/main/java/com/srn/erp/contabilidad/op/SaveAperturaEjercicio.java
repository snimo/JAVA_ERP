package com.srn.erp.contabilidad.op;

import com.srn.erp.contabilidad.bm.ComproAperturaEjercicio;
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

public class SaveAperturaEjercicio extends Operation {

  public SaveAperturaEjercicio() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    IDataSet dataset = mapaDatos.getDataSet("TAperturaContable");
    procesarRegistros(dataset);
  }

  private void procesarRegistros(IDataSet dataset) throws BaseException {
	  
	Moneda monedaCursoLegal =   
		  Moneda.getMonedaCursoLegal(this.getSesion());
	  
    dataset.first();
      while (!dataset.EOF()) {    	  
    	ComproAperturaEjercicio comproAperturaEjercicio =
    		ComproAperturaEjercicio.findByOid(dataset.getInteger("oid_apertura_contable"), this.getSesion());
    	
    	Talonario talonario = ComproAperturaEjercicio.getTalonatioAsientoAperturaEjercicio(this.getSesion());
    	comproAperturaEjercicio.setTalonario(talonario);
    	comproAperturaEjercicio.setContabiliza(true);
    	comproAperturaEjercicio.setEmision(dataset.getDate("fec_emision"));
    	comproAperturaEjercicio.setImputac(dataset.getDate("fec_imputacion"));
    	comproAperturaEjercicio.setTipoCompro(talonario.getTipo_comprobante());
    	comproAperturaEjercicio.setLetra(talonario.getLetra());
    	comproAperturaEjercicio.setLugarEmision(talonario.getLugar_emision());
    	comproAperturaEjercicio.setNrolugemision(talonario.getLugar_emision().getLugemi());
    	comproAperturaEjercicio.setComentario("");
    	comproAperturaEjercicio.setEjercicio(Ejercicio.findByOidProxy(dataset.getInteger("oid_ejercicio"), this.getSesion()));
    	comproAperturaEjercicio.setActivo(dataset.getBoolean("activo"));
    	if (!comproAperturaEjercicio.isActivo()) {
    		comproAperturaEjercicio.delete();
    		addTransaccion(comproAperturaEjercicio);
    		return;
      	}
    	
    	
    	IDataSet dsAperturaEjerDet = dataset.getDataSet("TAperturaContableDet");
    	dsAperturaEjerDet.first();
    	while ((!dsAperturaEjerDet.EOF()) && (comproAperturaEjercicio.isActivo())) {
    		
    		
    		// Calcular el Signo segun el Saldo
    		int signoAsientoMonLoc = 1;
    		CalculadorMoney saldoMonLoc = new CalculadorMoney(new Money(0));
    		saldoMonLoc.sumar(dsAperturaEjerDet.getMoney("debe_mon_loc"));
    		saldoMonLoc.restar(dsAperturaEjerDet.getMoney("haber_mon_loc"));
    		if (saldoMonLoc.getResult()>0)
    			signoAsientoMonLoc = 1;
    		else if (saldoMonLoc.getResult()<0) {
    			signoAsientoMonLoc = -1;
    			saldoMonLoc.multiplicarPor(new Money(-1));
    		}
    		
    		// Moneda Ajustado
    		int signoAsientoMonAju = 1;
    		CalculadorMoney saldoMonAju = new CalculadorMoney(new Money(0));
    		saldoMonAju.sumar(dsAperturaEjerDet.getMoney("debe_mon_aju"));
    		saldoMonAju.restar(dsAperturaEjerDet.getMoney("haber_mon_aju"));
    		if (saldoMonAju.getResult()>0)
    			signoAsientoMonAju = 1;
    		else if (saldoMonAju.getResult()<0) {
    			signoAsientoMonAju = -1;
    			saldoMonAju.multiplicarPor(new Money(-1));
    		}
    		
    		// Moneda Ext 1
    		int signoAsientoMonExt1 = 1;
    		CalculadorMoney saldoMonExt1 = new CalculadorMoney(new Money(0));
    		saldoMonExt1.sumar(dsAperturaEjerDet.getMoney("debe_mon_ext_1"));
    		saldoMonExt1.restar(dsAperturaEjerDet.getMoney("haber_mon_ext_1"));
    		if (saldoMonExt1.getResult()>0)
    			signoAsientoMonExt1 = 1;
    		else if (saldoMonExt1.getResult()<0) {
    			signoAsientoMonExt1 = -1;
    			saldoMonExt1.multiplicarPor(new Money(-1));
    		}
    		
    		// Moneda Ext 2
    		int signoAsientoMonExt2 = 1;
    		CalculadorMoney saldoMonExt2 = new CalculadorMoney(new Money(0));
    		saldoMonExt2.sumar(dsAperturaEjerDet.getMoney("debe_mon_ext_2"));
    		saldoMonExt2.restar(dsAperturaEjerDet.getMoney("haber_mon_ext_2"));
    		if (saldoMonExt2.getResult()>0)
    			signoAsientoMonExt2 = 1;
    		else if (saldoMonExt2.getResult()<0) {
    			signoAsientoMonExt2 = -1;    		
    			saldoMonExt2.multiplicarPor(new Money(-1));
    		}    		
    		
    		CuentaImputable cuentaImputable = CuentaImputable.findByOidProxy(dsAperturaEjerDet.getInteger("oid_ai"), this.getSesion());
    		
    		comproAperturaEjercicio.addRenglonCierre(cuentaImputable,
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
    		comproAperturaEjercicio.addRenglonCierre(cuentaImputable,
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
    		comproAperturaEjercicio.addRenglonCierre(cuentaImputable,
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
    		comproAperturaEjercicio.addRenglonCierre(cuentaImputable,
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
    		
    			
    		dsAperturaEjerDet.next();
    	}
    	
    	
    	
        addTransaccion(comproAperturaEjercicio);
        dataset.next();
    }
  }

}
