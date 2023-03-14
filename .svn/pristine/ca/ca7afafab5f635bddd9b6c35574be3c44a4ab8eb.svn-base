package com.srn.erp.contabilidad.op;

import java.util.Iterator;

import com.srn.erp.contabilidad.bm.Componente;
import com.srn.erp.contabilidad.bm.DriverComponente;
import com.srn.erp.contabilidad.bm.DriverComponenteCta;
import com.srn.erp.contabilidad.bm.DriverCuentaComponente;
import com.srn.erp.contabilidad.bm.DriverCuentaSubreparto;
import com.srn.erp.contabilidad.bm.DriverSubreparto;

import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerDriverSubreparto extends Operation { 

  private int secu = 0;	
  public TraerDriverSubreparto() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    DriverSubreparto driversubreparto = null;
    if (mapaDatos.containsKey("oid")) { 
       Integer oid = mapaDatos.getInteger("oid"); 
       driversubreparto = DriverSubreparto.findByOid(oid, getSesion()); 
    } 
    else { 
       String codigo = mapaDatos.getString("codigo"); 
       driversubreparto = DriverSubreparto.findByCodigo(codigo, getSesion()); 
    } 

    IDataSet datasetDriverSubreparto = getDataSetDriverSubreparto();
    IDataSet datasetDriverCuenta = getDataSetDriverCuenta();
    IDataSet datasetDriverCuentaCompo = getDataSetDriverCuentaCompo();
    IDataSet datasetCompoDriver = getDataSetComponenteDriver();
    IDataSet datasetCompoDriverCta = getDataSetComponenteDriverCTA();
    
    if (driversubreparto != null) { 
    	
        cargarRegistroDriverSubreparto(datasetDriverSubreparto, 
        		driversubreparto);
        
        // Driver componentes
        Iterator iterDriverCompo =
        	driversubreparto.getDriversComponentes().iterator();
        while (iterDriverCompo.hasNext()) {
        	DriverComponente driverCompo = (DriverComponente) iterDriverCompo.next();
        	cargarRegistroDriverCompo(datasetCompoDriver,driverCompo);
        	
        	Iterator iterCtasCompo = 
        		driverCompo.getCuentasCompo().iterator();
        	while (iterCtasCompo.hasNext()) {
        		DriverComponenteCta driverCompoCta = 
        			(DriverComponenteCta) iterCtasCompo.next();
        		cargarCompoDriverCta(datasetCompoDriverCta, driverCompoCta);
        	}
        	
        }
        
        // Driver cuentas
        Iterator iterDriverCuentas =
        	driversubreparto.getDriversCuentas().iterator();
        while (iterDriverCuentas.hasNext()) {
        	
        	DriverCuentaSubreparto driverCuenta = (DriverCuentaSubreparto) iterDriverCuentas.next();
        	cargarRegistroDriverCuentaSubreparto(datasetDriverCuenta,driverCuenta);
        	
        	if (driverCuenta.getCuenta().getEstructura()!=null) {
        		Iterator iterComponentes =
        			driverCuenta.getCuenta().getEstructura().getComponenentesConAux().iterator();
        		while (iterComponentes.hasNext()) {
        			
        			Componente componente = (Componente) iterComponentes.next();
        			DriverCuentaComponente driverCtaCompo =
        				DriverCuentaComponente.getDriverCuentaComponente(
        						driverCuenta, 
        						componente, 
        						this.getSesion());
        		
        			IObjetoLogico valorCompo = null;
        			if (driverCtaCompo!=null)
        				valorCompo = driverCtaCompo.getValor_componente();
        			
        			cargarRegistroDriverCuentaCompo(
            				datasetDriverCuentaCompo,
            				new Integer(++secu),
            				componente.getOIDInteger(),
            				driverCuenta.getOIDInteger(),
            				componente.getCodigo(),
            				componente.getDescripcion(),
            				componente.getTipo(),
            				valorCompo,
            				componente.getNombreNickName(),
            				componente.getNroClasificador(),
            				new Boolean(false)); 
            				
        		}
        	}
        	
        }
    }
    
    writeCliente(datasetDriverSubreparto);
    writeCliente(datasetDriverCuenta);
    writeCliente(datasetDriverCuentaCompo);
    writeCliente(datasetCompoDriver);
    writeCliente(datasetCompoDriverCta);
    
  }

  private IDataSet getDataSetDriverSubreparto() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TDriver");
    dataset.fieldDef(new Field("oid_driver", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("codigo", Field.STRING, 50)); 
    dataset.fieldDef(new Field("descripcion", Field.STRING, 255)); 
    dataset.fieldDef(new Field("tipo_valor", Field.STRING, 20)); 
    dataset.fieldDef(new Field("valor", Field.CURRENCY, 0));
    
    dataset.fieldDef(new Field("oid_compo", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_compo", Field.STRING, 50));
    dataset.fieldDef(new Field("desc_compo", Field.STRING, 100));
    dataset.fieldDef(new Field("tipo_saldo", Field.STRING, 20));
    
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0)); 
    return dataset;
  }
  
  private IDataSet getDataSetDriverCuenta() { 
	    IDataSet dataset = new TDataSet(); 
	    dataset.create("TDriverCuenta");
	    dataset.fieldDef(new Field("oid_driver_cta", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("oid_driver", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("oid_ana_con", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("cod_ana_con", Field.STRING, 50));
	    dataset.fieldDef(new Field("desc_ana_con", Field.STRING, 100));
	    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
	    return dataset;
  }
  
  private IDataSet getDataSetComponenteDriver() { 
	    IDataSet dataset = new TDataSet(); 
	    dataset.create("TComponenteDriver");
	    dataset.fieldDef(new Field("oid_compo_driver", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("oid_driver", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("oid_valor_compo", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("cod_valor_compo", Field.STRING, 50));
	    dataset.fieldDef(new Field("desc_valor_compo", Field.STRING, 100));
	    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
	    return dataset;
  }
  
  private IDataSet getDataSetComponenteDriverCTA() { 
	    IDataSet dataset = new TDataSet(); 
	    dataset.create("TComponenteDriverCta");
	    dataset.fieldDef(new Field("oid_compo_d_cta", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("oid_compo_driver", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("oid_ana_con", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("cod_ana_con", Field.STRING, 50));
	    dataset.fieldDef(new Field("desc_ana_con", Field.STRING, 100));
	    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
	    return dataset;
  }
  
  private void cargarCompoDriverCta(IDataSet ds,
		                           DriverComponenteCta driverCompoCta) throws BaseException {
	 ds.append();
	 ds.fieldValue("oid_compo_d_cta", driverCompoCta.getOIDInteger());
	 ds.fieldValue("oid_compo_driver", driverCompoCta.getComponente_driver().getOIDInteger());
	 ds.fieldValue("oid_ana_con", driverCompoCta.getCuenta().getOIDInteger());
	 ds.fieldValue("cod_ana_con", driverCompoCta.getCuenta().getCodigo());
	 ds.fieldValue("desc_ana_con", driverCompoCta.getCuenta().getDescripcion());
	 ds.fieldValue("activo", driverCompoCta.isActivo()); 
	 
  }
  
  
  private void cargarRegistroDriverCompo(IDataSet dataset, 
          DriverComponente driverCompo
          ) throws BaseException {
	  dataset.append();
	  dataset.fieldValue("oid_compo_driver", driverCompo.getOIDInteger());
	  dataset.fieldValue("oid_driver", driverCompo.getDriver().getOIDInteger());
	  dataset.fieldValue("oid_valor_compo", driverCompo.getValor_compo().getOIDInteger());
	  dataset.fieldValue("cod_valor_compo", driverCompo.getValor_compo().getCodigo());
	  dataset.fieldValue("desc_valor_compo", driverCompo.getValor_compo().getDescripcion());
	  dataset.fieldValue("activo", driverCompo.isActivo());
  }
  
  
  
  
  private IDataSet getDataSetDriverCuentaCompo() { 
	    IDataSet dataset = new TDataSet(); 
	    dataset.create("TDriverCtaCompo");
	    dataset.fieldDef(new Field("oid_driver_compo", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("oid_compo", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("oid_driver_cta", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("codigo", Field.STRING, 50));
	    dataset.fieldDef(new Field("descripcion", Field.STRING, 100));
	    dataset.fieldDef(new Field("tipo", Field.STRING, 50));
	    dataset.fieldDef(new Field("oid_valor_compo", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("codigo_valor_compo", Field.STRING, 50));
	    dataset.fieldDef(new Field("desc_valor_compo", Field.STRING, 100));
	    dataset.fieldDef(new Field("nombre_nickname", Field.STRING, 100));
	    dataset.fieldDef(new Field("nro_clasificador", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("es_ultimo", Field.BOOLEAN, 0));
	    return dataset;
  }
  
  private void cargarRegistroDriverCuentaCompo(IDataSet dataset, 
          Integer oidDriverCompo,
          Integer oidCompo,
          Integer oidDriverCta,
          String codigo,
          String descripcion,
          String tipo,
          IObjetoLogico obj,
          String nombreNickName,
          Integer nroClasificador,
          Boolean esUltimo
          ) throws BaseException {
	  dataset.append();
	  dataset.fieldValue("oid_driver_compo", oidDriverCompo);
	  dataset.fieldValue("oid_compo", oidCompo);
	  dataset.fieldValue("oid_driver_cta", oidDriverCta);
	  dataset.fieldValue("codigo", codigo);
	  dataset.fieldValue("descripcion", descripcion);
	  dataset.fieldValue("tipo", tipo);
	  if (obj!=null) {
		  dataset.fieldValue("oid_valor_compo", obj.getOIDInteger());
		  dataset.fieldValue("codigo_valor_compo", obj.getCodigo());
		  dataset.fieldValue("desc_valor_compo", obj.getDescripcion());
	  } else {
		  dataset.fieldValue("oid_valor_compo", "");
		  dataset.fieldValue("codigo_valor_compo", "");
		  dataset.fieldValue("desc_valor_compo", "");
	  }
	  dataset.fieldValue("nombre_nickname", nombreNickName);
	  dataset.fieldValue("nro_clasificador", nroClasificador);
	  dataset.fieldValue("es_ultimo", esUltimo);
  }
  
  
  
  
  private void cargarRegistroDriverCuentaSubreparto(IDataSet dataset, 
          DriverCuentaSubreparto driverCuenta) throws BaseException {
	  dataset.append();
	  dataset.fieldValue("oid_driver_cta", driverCuenta.getOIDInteger());
	  dataset.fieldValue("oid_driver", driverCuenta.getDriver().getOIDInteger());
	  dataset.fieldValue("oid_ana_con", driverCuenta.getCuenta().getOIDInteger());
	  dataset.fieldValue("cod_ana_con", driverCuenta.getCuenta().getCodigo());
	  dataset.fieldValue("desc_ana_con", driverCuenta.getCuenta().getDescripcion());
	  dataset.fieldValue("activo", driverCuenta.getCuenta().isActivo());
  }
  
  
  private void cargarRegistroDriverSubreparto(IDataSet dataset, 
                         DriverSubreparto driver) throws BaseException {
    dataset.append(); 
    dataset.fieldValue("oid_driver", driver.getOIDInteger());
    dataset.fieldValue("codigo", driver.getCodigo());
    dataset.fieldValue("descripcion", driver.getDescripcion());
    dataset.fieldValue("tipo_valor", driver.getTipo_valor());
    dataset.fieldValue("valor", driver.getValor());
    if (driver.getComponente()!=null) {
    	dataset.fieldValue("oid_compo", driver.getComponente().getOIDInteger());
    	dataset.fieldValue("cod_compo", driver.getComponente().getCodigo());
    	dataset.fieldValue("desc_compo", driver.getComponente().getDescripcion());
    } else {
    	dataset.fieldValue("oid_compo", new Integer(0));
    	dataset.fieldValue("cod_compo", "");
    	dataset.fieldValue("desc_compo", "");
    }
    dataset.fieldValue("tipo_saldo", driver.getTipoSaldo());
    dataset.fieldValue("activo", driver.isActivo());
  }
}
