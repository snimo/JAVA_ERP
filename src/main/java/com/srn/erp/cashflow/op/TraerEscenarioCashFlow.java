package com.srn.erp.cashflow.op;

import java.util.Iterator;

import com.srn.erp.cashflow.bm.CajaSaldoIniCF;
import com.srn.erp.cashflow.bm.CajasHabDeudaFinanCF;
import com.srn.erp.cashflow.bm.CtaBcoSaldoIniCF;
import com.srn.erp.cashflow.bm.CtaSaldoIniCf;
import com.srn.erp.cashflow.bm.EscenarioCashFlow;
import com.srn.erp.cashflow.bm.TipoValorSICajaCF;
import com.srn.erp.general.bm.Moneda;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerEscenarioCashFlow extends Operation { 

  public TraerEscenarioCashFlow() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    EscenarioCashFlow escenariocashflow = null;
    if (mapaDatos.containsKey("oid")) { 
       Integer oid = mapaDatos.getInteger("oid"); 
       escenariocashflow = EscenarioCashFlow.findByOid(oid, getSesion()); 
    } 
    else { 
       String codigo = mapaDatos.getString("codigo"); 
       escenariocashflow = EscenarioCashFlow.findByCodigo(codigo, getSesion()); 
    } 

    IDataSet datasetEscenarioCashFlow = getDataSetEscenarioCashFlow();
    IDataSet datasetCtaBcoSaldoIni = this.getDataSetCtaBcoSaldoIni();
    IDataSet datasetCajasSaldoIni = this.getDataSetCajasSaldoIni();
    IDataSet datasetTiposValores = this.getDataSetTipoValoresCajaSI();
    IDataSet datasetCtaContaSaldoIni = this.getDataSetCtaContableSaldoIni();
    IDataSet datasetCajasHabDeudaFinan = this.getDataSetCajasHabDeudaFinanCF();
    
    if (escenariocashflow != null) { 
    	
        cargarRegistroEscenarioCashFlow(datasetEscenarioCashFlow, 
                         escenariocashflow.getOIDInteger(),
                         escenariocashflow.getCodigo(),
                         escenariocashflow.getDescripcion(),
                         escenariocashflow.isActivo(),
                         escenariocashflow.isVerDeudaClientes(),
                         escenariocashflow.getMoneda()
                         );
        
        Iterator iterSaldoIniCtasBco = 
        	escenariocashflow.getSaldoInicialCtasBancarias().iterator();
        while (iterSaldoIniCtasBco.hasNext()) {
        	CtaBcoSaldoIniCF  ctaBcoSaldoIni = (CtaBcoSaldoIniCF) iterSaldoIniCtasBco.next();
        	if (!ctaBcoSaldoIni.isActivo()) continue;
        	cargarRegistroCtaBco(datasetCtaBcoSaldoIni, ctaBcoSaldoIni);
        }
        
        Iterator iterSaldoIniCajas = 
        	escenariocashflow.getSaldoInicialCajas().iterator();
        while (iterSaldoIniCajas.hasNext()) {
        	CajaSaldoIniCF  cajaSaldoIniCF = (CajaSaldoIniCF) iterSaldoIniCajas.next();
        	if (!cajaSaldoIniCF.isActivo()) continue;
        	cargarRegistroCajaSaldoInicial(datasetCajasSaldoIni, cajaSaldoIniCF);
        	
        	Iterator iterTiposValoresCajaSI = 
        		cajaSaldoIniCF.getTiposValores().iterator();
        	while (iterTiposValoresCajaSI.hasNext()) {
        		TipoValorSICajaCF tipoValorSICaja = (TipoValorSICajaCF) iterTiposValoresCajaSI.next();
        		if (!tipoValorSICaja.isActivo()) continue;
        		cargarRegistroTipoValorCajaSI(datasetTiposValores, tipoValorSICaja);
        	}
        	
        }
        
        Iterator iterSaldoIniCtasConta = 
        	escenariocashflow.getSaldoInicialCtasContables().iterator();
        while (iterSaldoIniCtasConta.hasNext()) {
        	CtaSaldoIniCf  ctaSaldoIni = (CtaSaldoIniCf) iterSaldoIniCtasConta.next();
        	if (!ctaSaldoIni.isActivo()) continue;
        	cargarRegistroCtaContableSaldoIni(datasetCtaContaSaldoIni, ctaSaldoIni);
        }
        
        Iterator iterCajasHabDeudaFinan = 
        	escenariocashflow.getCajasHabDeudaFinan().iterator();
        while (iterCajasHabDeudaFinan.hasNext()) {
        	CajasHabDeudaFinanCF  cajaHabDeudaFinan = (CajasHabDeudaFinanCF) iterCajasHabDeudaFinan.next();
        	if (!cajaHabDeudaFinan.isActivo()) continue;
        	cargarRegistroCajasHabDeudaFinanCF(datasetCajasHabDeudaFinan, cajaHabDeudaFinan);
        }
        
        
        
        
    }
    
    writeCliente(datasetEscenarioCashFlow);
    writeCliente(datasetCtaBcoSaldoIni);
    writeCliente(datasetCajasSaldoIni);
    writeCliente(datasetTiposValores);
    writeCliente(datasetCtaContaSaldoIni);
    writeCliente(datasetCajasHabDeudaFinan);
  }

  private IDataSet getDataSetEscenarioCashFlow() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TEscenarioCashFlow");
    dataset.fieldDef(new Field("oid_escenario", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("codigo", Field.STRING, 20)); 
    dataset.fieldDef(new Field("descripcion", Field.STRING, 100)); 
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("ver_deuda_clientes", Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("oid_moneda", Field.INTEGER, 0));
    return dataset;
  }
  
  private IDataSet getDataSetCtaBcoSaldoIni() { 
	    IDataSet dataset = new TDataSet(); 
	    dataset.create("TCtaBcoSaldoIni");
	    dataset.fieldDef(new Field("oid_sal_ini_cta", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("oid_escenario",Field.INTEGER, 0));
	    dataset.fieldDef(new Field("oid_cta_bancaria",Field.INTEGER, 0));
	    dataset.fieldDef(new Field("cod_cta_bancaria",Field.STRING, 50));
	    dataset.fieldDef(new Field("desc_cta_bancaria",Field.STRING, 100));
	    dataset.fieldDef(new Field("activo",Field.BOOLEAN, 0));
	    return dataset;
  }
  
  private IDataSet getDataSetCajasSaldoIni() { 
	    IDataSet dataset = new TDataSet(); 
	    dataset.create("TCajasSaldoIni");
	    dataset.fieldDef(new Field("oid_sal_ini_caja", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("oid_escenario",Field.INTEGER, 0));
	    dataset.fieldDef(new Field("oid_caja",Field.INTEGER, 0));
	    dataset.fieldDef(new Field("cod_caja",Field.STRING, 50));
	    dataset.fieldDef(new Field("desc_caja",Field.STRING, 100));
	    dataset.fieldDef(new Field("activo",Field.BOOLEAN, 0));
	    return dataset;
  }
  
  private IDataSet getDataSetTipoValoresCajaSI() { 
	    IDataSet dataset = new TDataSet(); 
	    dataset.create("TTiposValoresSICaja");
	    dataset.fieldDef(new Field("oid_tv_sal_ini", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("oid_sal_ini_caja", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("oid_tipo_valor", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("cod_tipo_valor", Field.STRING, 50));
	    dataset.fieldDef(new Field("desc_tipo_valor", Field.STRING, 100));
	    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
	    return dataset;
  }
  
  private IDataSet getDataSetCtaContableSaldoIni() { 
	    IDataSet dataset = new TDataSet(); 
	    dataset.create("TCtasSaldoIni");
	    dataset.fieldDef(new Field("oid_saldo_ini_cta", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("oid_escenario", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("oid_ana_con", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("cod_ana_con", Field.STRING, 50));
	    dataset.fieldDef(new Field("desc_ana_con", Field.STRING, 100));
	    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
	    return dataset;
  }
  
  private void cargarRegistroCtaContableSaldoIni(IDataSet dataset,
		  CtaSaldoIniCf ctaSaldoIniCF) throws BaseException {
	  dataset.append();
	  dataset.fieldValue("oid_saldo_ini_cta", ctaSaldoIniCF.getOIDInteger());
	  dataset.fieldValue("oid_escenario", ctaSaldoIniCF.getEscenario().getOIDInteger());
	  dataset.fieldValue("oid_ana_con", ctaSaldoIniCF.getCuenta().getOIDInteger());
	  dataset.fieldValue("cod_ana_con", ctaSaldoIniCF.getCuenta().getCodigo());
	  dataset.fieldValue("desc_ana_con", ctaSaldoIniCF.getCuenta().getDescripcion());
	  dataset.fieldValue("activo", ctaSaldoIniCF.isActivo());
  }
  
  
  
  
  private void cargarRegistroTipoValorCajaSI(IDataSet dataset,
		  TipoValorSICajaCF tipoValorCajaSI) throws BaseException {
	  dataset.append();
	  dataset.fieldValue("oid_tv_sal_ini", tipoValorCajaSI.getOIDInteger());
	  dataset.fieldValue("oid_sal_ini_caja", tipoValorCajaSI.getSaldo_inicial_caja().getOIDInteger());
	  dataset.fieldValue("oid_tipo_valor", tipoValorCajaSI.getTipo_valor().getOIDInteger());
	  dataset.fieldValue("cod_tipo_valor", tipoValorCajaSI.getTipo_valor().getCodigo());
	  dataset.fieldValue("desc_tipo_valor", tipoValorCajaSI.getTipo_valor().getDescripcion());
	  dataset.fieldValue("activo", tipoValorCajaSI.isActivo());
  }
  
  
  private void cargarRegistroCtaBco(IDataSet dataset,
		  CtaBcoSaldoIniCF ctaBcoSaldoIniCF) throws BaseException {
	  dataset.append();
	  dataset.fieldValue("oid_sal_ini_cta", ctaBcoSaldoIniCF.getOIDInteger());
	  dataset.fieldValue("oid_escenario", ctaBcoSaldoIniCF.getEscenariocf().getOIDInteger());
	  dataset.fieldValue("oid_cta_bancaria", ctaBcoSaldoIniCF.getCuenta_bancaria().getOIDInteger());
	  dataset.fieldValue("cod_cta_bancaria", ctaBcoSaldoIniCF.getCuenta_bancaria().getCodigo());
	  dataset.fieldValue("desc_cta_bancaria", ctaBcoSaldoIniCF.getCuenta_bancaria().getDescripcion());
	  dataset.fieldValue("activo", ctaBcoSaldoIniCF.isActivo());
	  
  }
  
  private void cargarRegistroCajaSaldoInicial(IDataSet dataset,
		  CajaSaldoIniCF cajaSaldoIniCF) throws BaseException {
	  dataset.append();
	  dataset.fieldValue("oid_sal_ini_caja", cajaSaldoIniCF.getOIDInteger());
	  dataset.fieldValue("oid_escenario", cajaSaldoIniCF.getEscenariocf().getOIDInteger());
	  dataset.fieldValue("oid_caja",cajaSaldoIniCF.getCaja().getOIDInteger());
	  dataset.fieldValue("cod_caja",cajaSaldoIniCF.getCaja().getCodigo());
	  dataset.fieldValue("desc_caja",cajaSaldoIniCF.getCaja().getDescripcion());
	  dataset.fieldValue("activo",cajaSaldoIniCF.isActivo());
	  
  }
  
  
  private void cargarRegistroEscenarioCashFlow(IDataSet dataset, 
                         Integer oid_escenario,
                         String codigo,
                         String descripcion,
                         Boolean activo,
                         Boolean verDeudaFinanciera,
                         Moneda moneda) {
    dataset.append(); 
    dataset.fieldValue("oid_escenario", oid_escenario);
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("descripcion", descripcion);
    dataset.fieldValue("activo", activo);
    dataset.fieldValue("ver_deuda_clientes", verDeudaFinanciera);
    dataset.fieldValue("oid_moneda", moneda.getOIDInteger());
  }
  
  private IDataSet getDataSetCajasHabDeudaFinanCF() { 
	    IDataSet dataset = new TDataSet(); 
	    dataset.create("TCajasHabDeudaFinanCF");
	    dataset.fieldDef(new Field("oid_caja_deuda", Field.INTEGER, 0)); 
	    dataset.fieldDef(new Field("oid_escenario", Field.INTEGER, 0)); 
	    dataset.fieldDef(new Field("oid_caja", Field.INTEGER, 0)); 
	    dataset.fieldDef(new Field("cod_caja", Field.STRING, 50));
	    dataset.fieldDef(new Field("desc_caja", Field.STRING, 100));
	    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0)); 
	    return dataset;
  }

  private void cargarRegistroCajasHabDeudaFinanCF(
		  IDataSet dataset, 
		  CajasHabDeudaFinanCF cajaHabDeudaFinanCF) throws BaseException {
	    dataset.append(); 
	    dataset.fieldValue("oid_caja_deuda", cajaHabDeudaFinanCF.getOIDInteger());
	    dataset.fieldValue("oid_escenario", cajaHabDeudaFinanCF.getEscenario_cf().getOIDInteger());
	    dataset.fieldValue("oid_caja", cajaHabDeudaFinanCF.getCaja().getOIDInteger());
	    dataset.fieldValue("cod_caja", cajaHabDeudaFinanCF.getCaja().getCodigo());
	    dataset.fieldValue("desc_caja", cajaHabDeudaFinanCF.getCaja().getDescripcion());
	    dataset.fieldValue("activo", cajaHabDeudaFinanCF.isActivo());
  }  
  
}
