package com.srn.erp.excluidos.op;

import java.util.List;

import com.srn.erp.excluidos.bm.EstadoExcluido;
import com.srn.erp.excluidos.bm.NovedadExcluido;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;
import framework.request.bl.Utils.MapDatos;

public class ValidarNroActaUnicoExc extends Operation {

	public ValidarNroActaUnicoExc() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		
		Integer oidIndividuo = mapaDatos.getInteger("oid_individuo");
		EstadoExcluido estado = EstadoExcluido.findByOidProxy(mapaDatos.getInteger("oid_estado"), this.getSesion());
		Integer nroActa = mapaDatos.getInteger("nro_acta");
		
		
		List lista = 
			NovedadExcluido.getNovedadesDistIndEstadoyNroActa(oidIndividuo, estado, nroActa, this.getSesion());
		if (lista.size()>0) {
			NovedadExcluido novedad = (NovedadExcluido)lista.get(0); 
			throw new ExceptionValidation(null,"Nro. "+nroActa+" del estado "+estado.getDescripcion()+" ya esta siendo utilizado por el ID-Interno="+novedad.getIndividuoExcluido().getOIDInteger());
		}
		
	}
	


}
