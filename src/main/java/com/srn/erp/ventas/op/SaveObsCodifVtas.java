package com.srn.erp.ventas.op;

import com.srn.erp.general.bm.Idioma;
import com.srn.erp.general.bm.Sucursal;
import com.srn.erp.ventas.bm.ObsCodifVtas;
import com.srn.erp.ventas.bm.ObsCodifVtasIdioma;
import com.srn.erp.ventas.bm.ObsCodifVtasSucursal;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveObsCodifVtas extends Operation { 

  public SaveObsCodifVtas() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    IDataSet dataset = mapaDatos.getDataSet("TObsCodifVtas"); 
    procesarRegistros(dataset); 
  } 

  private void procesarRegistros(IDataSet dataset) throws BaseException { 
    dataset.first(); 
      while (!dataset.EOF()) { 
        
    	ObsCodifVtas obscodifvtas = ObsCodifVtas.findByOid(dataset.getInteger("oid_obs_cod"),getSesion());
        obscodifvtas.setOID(dataset.getInteger("oid_obs_cod"));
        obscodifvtas.setCodigo(dataset.getString("codigo"));
        obscodifvtas.setDescripcion(dataset.getString("descripcion"));
        obscodifvtas.setIncluir(dataset.getBoolean("incluir"));
        obscodifvtas.setActivo(dataset.getBoolean("activo"));
        obscodifvtas.setTipo(dataset.getString("tipo"));
        obscodifvtas.setOrden(dataset.getInteger("orden"));
        
        IDataSet dsObsIdioma = dataset.getDataSet("TObsCodifVtasIdioma");
        dsObsIdioma.first();
        while (!dsObsIdioma.EOF()) {
        	ObsCodifVtasIdioma obsCodifIdioma =
        		ObsCodifVtasIdioma.findByOid(dsObsIdioma.getInteger("oid_obs_idioma"), this.getSesion());
        	obsCodifIdioma.setCodigo_observacion(obscodifvtas);
        	obsCodifIdioma.setIdioma(Idioma.findByOidProxy(dsObsIdioma.getInteger("oid_idioma"), this.getSesion()));
        	obsCodifIdioma.setActivo(dsObsIdioma.getBoolean("activo"));
        	obsCodifIdioma.setDescripcion(dsObsIdioma.getString("descripcion"));
        	if (!obsCodifIdioma.isActivo())
        		obsCodifIdioma.delete();
        	obscodifvtas.addObservacionIdioma(obsCodifIdioma);        	
        	dsObsIdioma.next();
        }
        
        IDataSet dsObsSucursal = dataset.getDataSet("TObsCodifVtasSucursal");
        dsObsSucursal.first();
        while (!dsObsSucursal.EOF()) {
        	ObsCodifVtasSucursal obsCodifSucursal =
        		ObsCodifVtasSucursal.findByOid(dsObsSucursal.getInteger("oid_obs_cod_uo"), this.getSesion());
        	obsCodifSucursal.setCodigo_observacion(obscodifvtas);
        	obsCodifSucursal.setSucursal(Sucursal.findByOidProxy(dsObsSucursal.getInteger("oid_sucursal"), this.getSesion()));
        	obsCodifSucursal.setActivo(dsObsSucursal.getBoolean("activo"));
        	if (!obsCodifSucursal.isActivo())
        		obsCodifSucursal.delete();
        	obscodifvtas.addObservacionSucursal(obsCodifSucursal);        	
        	dsObsSucursal.next();
        }
        
        
        addTransaccion(obscodifvtas);
        dataset.next();
    }
  }
  
}
