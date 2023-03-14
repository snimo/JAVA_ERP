package com.srn.erp.contabilidad.op;

import com.srn.erp.contabilidad.bm.Componente;
import com.srn.erp.contabilidad.bm.Cuenta;
import com.srn.erp.contabilidad.bm.DriverComponente;
import com.srn.erp.contabilidad.bm.DriverComponenteCta;
import com.srn.erp.contabilidad.bm.DriverCuentaComponente;
import com.srn.erp.contabilidad.bm.DriverCuentaSubreparto;
import com.srn.erp.contabilidad.bm.DriverSubreparto;

import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveDriverSubreparto extends Operation { 

  public SaveDriverSubreparto() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    IDataSet dataset = mapaDatos.getDataSet("TDriver"); 
    procesarRegistros(dataset); 
  } 

  private void procesarRegistros(IDataSet dataset) throws BaseException { 
    dataset.first(); 
      while (!dataset.EOF()) { 
        DriverSubreparto driversubreparto = DriverSubreparto.findByOid(dataset.getInteger("oid_driver"),getSesion());
        driversubreparto.setOID(dataset.getInteger("oid_driver"));
        driversubreparto.setCodigo(dataset.getString("codigo"));
        driversubreparto.setDescripcion(dataset.getString("descripcion"));
        driversubreparto.setTipo_valor(dataset.getString("tipo_valor"));
        driversubreparto.setValor(dataset.getDouble("valor"));
        driversubreparto.setComponente(Componente.findByOidProxy(dataset.getInteger("oid_compo"),this.getSesion()));
        driversubreparto.setActivo(dataset.getBoolean("activo"));
        driversubreparto.setTipoSaldo(dataset.getString("tipo_saldo"));
        
        IDataSet dsDriverCompo = dataset.getDataSet("TComponenteDriver");
        dsDriverCompo.first();
        while (!dsDriverCompo.EOF()) {
        	DriverComponente driverCompo =
        		DriverComponente.findByOid(dsDriverCompo.getInteger("oid_compo_driver"), this.getSesion());
        	driverCompo.setDriver(driversubreparto);
        	
        	IObjetoLogico valorCompo =
        		driversubreparto.getComponente().getValorCompo(dsDriverCompo.getInteger("oid_valor_compo"));
        	driverCompo.setValor_compo(valorCompo);
        	driverCompo.setActivo(dsDriverCompo.getBoolean("activo"));
        	if (!driverCompo.isActivo())
        		driverCompo.delete();
        	
        	IDataSet dsCompoDriverCta = dsDriverCompo.getDataSet("TComponenteDriverCta");
        	dsCompoDriverCta.first();
        	while (!dsCompoDriverCta.EOF()) {
        		DriverComponenteCta driverCompoCta =
        			DriverComponenteCta.findByOid(dsCompoDriverCta.getInteger("oid_compo_d_cta"), this.getSesion());
        		driverCompoCta.setComponente_driver(driverCompo);
        		driverCompoCta.setCuenta(Cuenta.findByOidProxy(dsCompoDriverCta.getInteger("oid_ana_con"), this.getSesion()));
        		driverCompoCta.setActivo(dsCompoDriverCta.getBoolean("activo"));
        		if (!driverCompoCta.isActivo())
        			driverCompoCta.delete();
        		driverCompo.addCuentaCompro(driverCompoCta);
        		
        		dsCompoDriverCta.next();
        	}
        	
        	driversubreparto.addDriverComponente(driverCompo);
        	dsDriverCompo.next();
        }
        
        
        
        IDataSet dsCuentaDriver = dataset.getDataSet("TDriverCuenta");
        dsCuentaDriver.first();
        while (!dsCuentaDriver.EOF()) {
        	DriverCuentaSubreparto driverCuenta =
        		DriverCuentaSubreparto.findByOid(dsCuentaDriver.getInteger("oid_driver_cta"), this.getSesion());
        	driverCuenta.setDriver(driversubreparto);
        	driverCuenta.setCuenta(Cuenta.findByOidProxy(dsCuentaDriver.getInteger("oid_ana_con"), this.getSesion()));
        	driverCuenta.setActivo(dsCuentaDriver.getBoolean("activo"));
        	if (!driverCuenta.isActivo())
        		driverCuenta.delete();
        	dsCuentaDriver.next();
        	driversubreparto.addDriverCuenta(driverCuenta);
        	
        	IDataSet dsComponentesCta = dsCuentaDriver.getDataSet("TDriverCtaCompo");
        	dsComponentesCta.first();
        	while (!dsComponentesCta.EOF()) {
        		Componente compo = Componente.findByOidProxy(dsComponentesCta.getInteger("oid_compo"), this.getSesion());
        		DriverCuentaComponente driverCtaCompo =
        			DriverCuentaComponente.getDriverCuentaComponente(driverCuenta,compo,this.getSesion());
        		if (driverCtaCompo == null)
        			driverCtaCompo = (DriverCuentaComponente) DriverCuentaComponente.getNew(DriverCuentaComponente.NICKNAME, this.getSesion());
        		driverCtaCompo.setDriver_cta(driverCuenta);
        		driverCtaCompo.setComponente(compo);
        		
        		IObjetoLogico objLog =
        			compo.getValorCompo(dsComponentesCta.getInteger("oid_valor_compo"));
        		driverCtaCompo.setValor_componente(objLog);
        		driverCtaCompo.setActivo(new Boolean(true));
        		if (driverCtaCompo.getValor_componente()==null)
        			driverCtaCompo.delete();
        		driverCuenta.addComponenteCuentaDriver(driverCtaCompo);
        		
        		dsComponentesCta.next();
        	}
        	
        }
        
        addTransaccion(driversubreparto);
        dataset.next();
    }
  }
  
}
