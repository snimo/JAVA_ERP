package com.srn.erp.ctasAPagar.op;

import java.util.Iterator;

import com.srn.erp.ctasAPagar.bm.AutorizRolesFactProv;
import com.srn.erp.ctasAPagar.bm.AutorizacionFactProv;
import com.srn.erp.ctasAPagar.bm.TranProvVto;

import framework.applicarionServer.bl.Utils.Fecha;
import framework.applicarionServer.bm.Seguridad.Usuario;
import framework.applicarionServer.bm.Varios.Money;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveAutorizComproProv extends Operation {

  public SaveAutorizComproProv() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {

	boolean huboCambioMontoAutoriz = false;  
    IDataSet dataseComproProv = mapaDatos.getDataSet("TVistaComproProvPendAprob");
    dataseComproProv.first();
    while (!dataseComproProv.EOF()) {            

      AutorizacionFactProv autorizFactProv =
          AutorizacionFactProv.findByOid(dataseComproProv.getInteger("oid_autoriz_fact"),getSesion());
      
      Money montoAutAnt = autorizFactProv.getMontoautoriz();
      if (montoAutAnt.doubleValue() == dataseComproProv.getMoney("monto_autoriz").doubleValue())
    	  huboCambioMontoAutoriz = false;
      else 
    	  huboCambioMontoAutoriz = true;
      
      autorizFactProv.setMontoautoriz(dataseComproProv.getMoney("monto_autoriz"));
      autorizFactProv.setPorcautoriz(dataseComproProv.getMoney("porc_autoriz"));
      autorizFactProv.setTranprovVto(TranProvVto.findByOidProxy(dataseComproProv.getInteger("oid_tran_vto"),getSesion()));
      
      if (huboCambioMontoAutoriz) {
    	  // Volver a solicitar la autorizacion de los roles involucrados
    	  // Si es que se modifico el monto autorizado
    	  Iterator iterAutorizRoles = autorizFactProv.getAutorizFPRoles().iterator();
    	  while (iterAutorizRoles.hasNext()) {
    		  AutorizRolesFactProv autorizRolesFactProv = (AutorizRolesFactProv) iterAutorizRoles.next();
    		  autorizRolesFactProv.setEstado(AutorizRolesFactProv.PEND_AUTORIZ);
    		  autorizRolesFactProv.setFecha_resp_aut(null);
    		  autorizRolesFactProv.setUsuario(null);
    	  }
      }
      
      IDataSet dsRolesAutoriz = dataseComproProv.getDataSet("TAutorizacionRoles");
      dsRolesAutoriz.first();
      while (!dsRolesAutoriz.EOF()) {
      	
      	if (dsRolesAutoriz.getInteger("oid_nuevo_estado")==null) {
      		dsRolesAutoriz.next();
      		continue;
      	}

      	//Ubicar el objeto rol que se modifico del lado del cliente
      	AutorizRolesFactProv autorizRolesFactProv = null;
  	    Iterator iterAutorizRoles = autorizFactProv.getAutorizFPRoles().iterator();
	    while (iterAutorizRoles.hasNext()) {
	    	autorizRolesFactProv = (AutorizRolesFactProv) iterAutorizRoles.next();
	    	if (dsRolesAutoriz.getInteger("oid_autoriz_fp_rol").intValue() == autorizRolesFactProv.getOID()) 
	    		break;
	    }
      	
      	
      	autorizRolesFactProv.setFecha_resp_aut(Fecha.getFechaActual());
      	autorizRolesFactProv.setEstado(dsRolesAutoriz.getInteger("oid_nuevo_estado"));
      	Usuario usuario = Usuario.findByOid(getSesion().getLogin().getUsuario().getOIDInteger(),getSesion());
        autorizRolesFactProv.setUsuario(usuario);
        autorizFactProv.addRolAutorizadorFactProv(autorizRolesFactProv);
      	dsRolesAutoriz.next();
      	
      }
      
      dataseComproProv.next();
      addTransaccion(autorizFactProv);
    }
    
    // Si se produjo un cambio de Monto autorizado , entonces volver a solicitar autorizacion el resto de los roles
    
    
    

  }


}
