package com.srn.erp.general.op;

import java.util.Date;

import com.srn.erp.general.bm.ComprobanteImpreso;

import framework.applicarionServer.bl.Utils.Fecha;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;

public class SaveMarcarComproImpreso extends Operation {

  public SaveMarcarComproImpreso() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
	
	  ComprobanteImpreso comproImpreso = ComprobanteImpreso.findByOid(mapaDatos.getInteger("oid_cco"), this.getSesion());
	  String congelarVersion = mapaDatos.getString("congelar_version");
	  
	  // Marca el comprobante como impresor
	  comproImpreso.setImpre_generada(new Boolean(true));
	  comproImpreso.setImpre_fecha(Fecha.getFechaActual());
	  comproImpreso.setImpre_hora(Fecha.getHoraActual());
	  comproImpreso.setImpre_usu(this.getSesion().getLogin().getUsuario().getOID());
	  
	  int cantVecesImpreso = 0;
	  if (comproImpreso.getImpre_cant()!=null)
		  cantVecesImpreso = comproImpreso.getImpre_cant().intValue();
	  
	  comproImpreso.setImpre_cant(new Integer(++cantVecesImpreso));
	  
	  if (congelarVersion.equals("s")) 
		  if (comproImpreso.isVersionCongelada().booleanValue()==false) {
			  comproImpreso.setCongelarVersion(new Boolean(true));
			  comproImpreso.setVersion_fecha(Fecha.getFechaActual());
			  comproImpreso.setVersion_hora(Fecha.getHoraActual());
			  comproImpreso.setVersion_usu(this.getSesion().getLogin().getUsuario().getOID());
		  }
	  
	  this.addTransaccion(comproImpreso);
	  
	
  }


}
