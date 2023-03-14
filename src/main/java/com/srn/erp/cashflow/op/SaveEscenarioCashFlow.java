package com.srn.erp.cashflow.op;

import com.srn.erp.cashflow.bm.CajaSaldoIniCF;
import com.srn.erp.cashflow.bm.CajasHabDeudaFinanCF;
import com.srn.erp.cashflow.bm.CtaBcoSaldoIniCF;
import com.srn.erp.cashflow.bm.CtaSaldoIniCf;
import com.srn.erp.cashflow.bm.EscenarioCashFlow;
import com.srn.erp.cashflow.bm.TipoValorSICajaCF;
import com.srn.erp.contabilidad.bm.Cuenta;
import com.srn.erp.general.bm.Moneda;
import com.srn.erp.tesoreria.bm.Caja;
import com.srn.erp.tesoreria.bm.CuentaBancaria;
import com.srn.erp.tesoreria.bm.TipoValor;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveEscenarioCashFlow extends Operation { 

  public SaveEscenarioCashFlow() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    IDataSet dataset = mapaDatos.getDataSet("TEscenarioCashFlow"); 
    procesarRegistros(dataset); 
  } 

  private void procesarRegistros(IDataSet dataset) throws BaseException { 
    dataset.first(); 
      while (!dataset.EOF()) { 
        EscenarioCashFlow escenariocashflow = EscenarioCashFlow.findByOid(dataset.getInteger("oid_escenario"),getSesion());
        escenariocashflow.setOID(dataset.getInteger("oid_escenario"));
        escenariocashflow.setCodigo(dataset.getString("codigo"));
        escenariocashflow.setDescripcion(dataset.getString("descripcion"));
        escenariocashflow.setActivo(dataset.getBoolean("activo"));
        escenariocashflow.setVerDeudaClientes(dataset.getBoolean("ver_deuda_clientes"));
        escenariocashflow.setMoneda(Moneda.findByOidProxy(dataset.getInteger("oid_moneda"), this.getSesion()));
        
        IDataSet dsCtaBcoSaldoIni = dataset.getDataSet("TCtaBcoSaldoIni");
        dsCtaBcoSaldoIni.first();
        while (!dsCtaBcoSaldoIni.EOF()) {
        	CtaBcoSaldoIniCF ctaBcoSaldoIniCF = 
        		CtaBcoSaldoIniCF.findByOid(dsCtaBcoSaldoIni.getInteger("oid_sal_ini_cta"), this.getSesion());
        	ctaBcoSaldoIniCF.setEscenariocf(escenariocashflow);
        	ctaBcoSaldoIniCF.setCuenta_bancaria(CuentaBancaria.findByOidProxy(dsCtaBcoSaldoIni.getInteger("oid_cta_bancaria"), this.getSesion()));
        	ctaBcoSaldoIniCF.setActivo(dsCtaBcoSaldoIni.getBoolean("activo"));
        	escenariocashflow.addCtaBcoSaldoIni(ctaBcoSaldoIniCF);
        	dsCtaBcoSaldoIni.next();
        }
        
        IDataSet dsCajasHabDeudaFinan = dataset.getDataSet("TCajasHabDeudaFinanCF");
        dsCajasHabDeudaFinan.first();
        while (!dsCajasHabDeudaFinan.EOF()) {
        	CajasHabDeudaFinanCF cajaHabDeudaFinanCF = 
        		CajasHabDeudaFinanCF.findByOid(dsCajasHabDeudaFinan.getInteger("oid_caja_deuda"), this.getSesion());
        	cajaHabDeudaFinanCF.setEscenario_cf(escenariocashflow);
        	cajaHabDeudaFinanCF.setCaja(Caja.findByOidProxy(dsCajasHabDeudaFinan.getInteger("oid_caja"), this.getSesion()));
        	cajaHabDeudaFinanCF.setActivo(dsCajasHabDeudaFinan.getBoolean("activo"));
        	escenariocashflow.addCajaHabDeudaFinan(cajaHabDeudaFinanCF);
        	dsCajasHabDeudaFinan.next();
        }
        
        
        IDataSet dsCajasSaldoIni = dataset.getDataSet("TCajasSaldoIni");
        dsCajasSaldoIni.first();
        while (!dsCajasSaldoIni.EOF()) {
        	CajaSaldoIniCF cajaSaldoIniCF = 
        		CajaSaldoIniCF.findByOid(dsCajasSaldoIni.getInteger("oid_sal_ini_caja"), this.getSesion());
        	cajaSaldoIniCF.setEscenariocf(escenariocashflow);
        	cajaSaldoIniCF.setCaja(Caja.findByOidProxy(dsCajasSaldoIni.getInteger("oid_caja"), this.getSesion()));
        	cajaSaldoIniCF.setActivo(dsCajasSaldoIni.getBoolean("activo"));
        	escenariocashflow.addSaldoInicialCaja(cajaSaldoIniCF);
        	
        	IDataSet dsTiposValores = dsCajasSaldoIni.getDataSet("TTiposValoresSICaja");
        	dsTiposValores.first();
        	while (!dsTiposValores.EOF()) {
        		TipoValorSICajaCF tipoValorSICaja = TipoValorSICajaCF.findByOid(dsTiposValores.getInteger("oid_tv_sal_ini"), this.getSesion());
        		tipoValorSICaja.setSaldo_inicial_caja(cajaSaldoIniCF);
        		tipoValorSICaja.setTipo_valor(TipoValor.findByOidProxy(dsTiposValores.getInteger("oid_tipo_valor"), this.getSesion()));
        		tipoValorSICaja.setActivo(dsTiposValores.getBoolean("activo"));
        		cajaSaldoIniCF.addTipoValor(tipoValorSICaja);
        		dsTiposValores.next();
        	}
        	
        	
        	dsCajasSaldoIni.next();
        }
        
        IDataSet dsCtaContaSaldoIni = dataset.getDataSet("TCtasSaldoIni");
        dsCtaContaSaldoIni.first();
        while (!dsCtaContaSaldoIni.EOF()) {
        	CtaSaldoIniCf ctaSaldoIniCF = 
        		CtaSaldoIniCf.findByOid(dsCtaContaSaldoIni.getInteger("oid_saldo_ini_cta"), this.getSesion());
        	ctaSaldoIniCF.setEscenario(escenariocashflow);
        	ctaSaldoIniCF.setCuenta(Cuenta.findByOidProxy(dsCtaContaSaldoIni.getInteger("oid_ana_con"), this.getSesion()));
        	ctaSaldoIniCF.setActivo(dsCtaContaSaldoIni.getBoolean("activo"));
        	escenariocashflow.addCtaContableSaldoIni(ctaSaldoIniCF);
        	dsCtaContaSaldoIni.next();
        }
        
        
        
        addTransaccion(escenariocashflow);
        dataset.next();
    }
  }
  
}
