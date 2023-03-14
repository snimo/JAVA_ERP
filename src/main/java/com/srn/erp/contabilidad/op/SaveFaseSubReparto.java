package com.srn.erp.contabilidad.op;

import com.srn.erp.contabilidad.bm.Componente;
import com.srn.erp.contabilidad.bm.Cuenta;
import com.srn.erp.contabilidad.bm.DriverSubreparto;
import com.srn.erp.contabilidad.bm.FaseCompoOriginal;
import com.srn.erp.contabilidad.bm.FaseCuentaOrigen;
import com.srn.erp.contabilidad.bm.FaseSubReparto;
import com.srn.erp.contabilidad.bm.FaseValCompoDest;
import com.srn.erp.contabilidad.bm.FaseValorCompoOriginal;

import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveFaseSubReparto extends Operation { 

  public SaveFaseSubReparto() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    IDataSet dataset = mapaDatos.getDataSet("TFaseSubReparto"); 
    procesarRegistros(dataset); 
  } 

  private void procesarRegistros(IDataSet dataset) throws BaseException { 
    dataset.first(); 
      while (!dataset.EOF()) { 
        FaseSubReparto fasesubreparto = FaseSubReparto.findByOid(dataset.getInteger("oid_fase"),getSesion());
        fasesubreparto.setOID(dataset.getInteger("oid_fase"));
        fasesubreparto.setCodigo(dataset.getString("codigo"));
        fasesubreparto.setDescripcion(dataset.getString("descripcion"));
        fasesubreparto.setCompo_destino(Componente.findByOidProxy(dataset.getInteger("oid_compo_destino"),this.getSesion()));
        fasesubreparto.setActivo(dataset.getBoolean("activo"));
        
        // Componentes Destino
        IDataSet dsCompoDest = dataset.getDataSet("TFaseValorCompoDest");
        dsCompoDest.first();
        while (!dsCompoDest.EOF()) {
        	
        	Componente compoDestino =
        		fasesubreparto.getCompo_destino();
        	if (compoDestino == null) {
        		dsCompoDest.next();
        		continue;
        	}
        	
        	IObjetoLogico valorDest =
        		compoDestino.getValorCompo(dsCompoDest.getInteger("oid_valor_compo"));
        	
        	FaseValCompoDest faseValCompoDest =
        		FaseValCompoDest.getFaseValCompoDest(fasesubreparto, valorDest, this.getSesion());
        	if (faseValCompoDest == null) {
        		faseValCompoDest = (FaseValCompoDest) FaseValCompoDest.getNew(FaseValCompoDest.NICKNAME, this.getSesion());
        		faseValCompoDest.setOID(new Integer(-1));
        	}
        	
        	faseValCompoDest.setFase(fasesubreparto);
        	faseValCompoDest.setValor_compo(valorDest);
        	faseValCompoDest.setActivo(dsCompoDest.getBoolean("activo"));
        	faseValCompoDest.setDriver(DriverSubreparto.findByOidProxy(dsCompoDest.getInteger("oid_driver"), this.getSesion()));
        	if (!faseValCompoDest.isActivo())
        		faseValCompoDest.delete();
        	
        	fasesubreparto.addValorComponenteDestino(faseValCompoDest);
        		
        	
        	dsCompoDest.next();
        }
        
        
        
        // Cuentas Origen
        IDataSet dsCuentasOri = dataset.getDataSet("TFaseCtaOri");
        dsCuentasOri.first();
        while (!dsCuentasOri.EOF()) {
        	Cuenta cuenta = Cuenta.findByOidProxy(dsCuentasOri.getInteger("oid_ana_con"), this.getSesion());
        	FaseCuentaOrigen faseCuentaOrigen =
        		FaseCuentaOrigen.getFaseCuentaOrigen(fasesubreparto, cuenta, this.getSesion());
        	if (faseCuentaOrigen == null) {
        		faseCuentaOrigen = (FaseCuentaOrigen)FaseCuentaOrigen.getNew(FaseCuentaOrigen.NICKNAME, this.getSesion());
        		faseCuentaOrigen.setOID(new Integer(-1));
        	}
        	faseCuentaOrigen.setFase(fasesubreparto);
        	faseCuentaOrigen.setCuenta(cuenta);
        	faseCuentaOrigen.setActivo(dsCuentasOri.getBoolean("activo"));
        	if (!faseCuentaOrigen.isActivo())
        		faseCuentaOrigen.delete();
        	
        	fasesubreparto.addCuentaOrigen(faseCuentaOrigen);
        	
        	dsCuentasOri.next();
        }
        
        
        IDataSet dsFaseCompoOri = dataset.getDataSet("TFaseCompoOri");
        dsFaseCompoOri.first();
        while (!dsFaseCompoOri.EOF()) {
        	Componente compo = Componente.findByOidProxy(dsFaseCompoOri.getInteger("oid_compo"), this.getSesion());
        	FaseCompoOriginal faseCompoOri = FaseCompoOriginal.getFaseCompoOriginal(fasesubreparto, compo, this.getSesion());
        	if (faseCompoOri == null) {
        		faseCompoOri = (FaseCompoOriginal) FaseCompoOriginal.getNew(FaseCompoOriginal.NICKNAME, this.getSesion());
        		faseCompoOri.setOID(new Integer(-1));
        	}
        	faseCompoOri.setFase(fasesubreparto);
        	faseCompoOri.setComponente(Componente.findByOidProxy(dsFaseCompoOri.getInteger("oid_compo"), this.getSesion()));
        	faseCompoOri.setActivo(dsFaseCompoOri.getBoolean("activo"));
        	if (!faseCompoOri.isActivo())
        		faseCompoOri.delete();
        	
        	IDataSet dsFaseValorCompoOri = dsFaseCompoOri.getDataSet("TFaseValorCompoOri");
        	dsFaseValorCompoOri.first();
        	while (!dsFaseValorCompoOri.EOF()) {
        		IObjetoLogico objLog =
        			compo.getValorCompo(dsFaseValorCompoOri.getInteger("oid_val_compo"));
        		FaseValorCompoOriginal faseValorCompoOri =
        			FaseValorCompoOriginal.getFaseValorCompoOri(fasesubreparto, compo, objLog, this.getSesion());
        		if (faseValorCompoOri == null) {
        			faseValorCompoOri = (FaseValorCompoOriginal) FaseValorCompoOriginal.getNew(FaseValorCompoOriginal.NICKNAME, this.getSesion());
        			faseValorCompoOri.setOID(new Integer(-1));
        		}
        		faseValorCompoOri.setFase(fasesubreparto);
        		faseValorCompoOri.setComponente(compo);
        		faseValorCompoOri.setValor_componente(objLog);
        		faseValorCompoOri.setActivo(dsFaseValorCompoOri.getBoolean("activo"));
        		
        		if (!faseValorCompoOri.isActivo())
        			faseValorCompoOri.delete();
        		
        		fasesubreparto.addValorComponenteOrigen(faseValorCompoOri);
        		
        		dsFaseValorCompoOri.next();
        	}
        	
        	
        	
        	fasesubreparto.addComponenteOrigen(faseCompoOri);
        	
        	dsFaseCompoOri.next();
        }
        
        
        
        addTransaccion(fasesubreparto);
        dataset.next();
    }
  }
  
}
