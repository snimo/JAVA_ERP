package com.srn.erp.cip.op;

import com.srn.erp.cip.bm.LegajoRotaFecha;
import com.srn.erp.cip.bm.NovedadPermisoCIP;
import com.srn.erp.general.bm.FuncEspSegERP;

import framework.applicarionServer.bm.Seguridad.AltaFuncEspSeg;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;
import framework.request.bl.Utils.MapDatos;

public class SaveEliminarPermisoNov extends Operation {

	public SaveEliminarPermisoNov() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {

		String nickNameObj = mapaDatos.getString("nickname");
		Integer oid = mapaDatos.getInteger("oid");

		eliminarNovPermiso(nickNameObj, oid);
	}

	private void eliminarNovPermiso(String aNickName, Integer oid) throws BaseException {
		
		if (LegajoRotaFecha.NICKNAME.equals(aNickName)) {
			
			
			if (AltaFuncEspSeg.isFuncEspSegHabilitada(1010,"",false,this.getSesion())==false)
				throw new ExceptionValidation(null,"No tiene permiso para eliminar la rota");
			
			LegajoRotaFecha legRotaFecha =
				LegajoRotaFecha.findByOid(oid, this.getSesion());
			legRotaFecha.delete();
			this.addTransaccion(legRotaFecha);
			
		} else if (NovedadPermisoCIP.NICKNAME.equals(aNickName)) {
			
			NovedadPermisoCIP novPerm = NovedadPermisoCIP.findByOid(oid, this.getSesion());
			
			if (novPerm.isNovedadExterna().booleanValue()) {
				if (AltaFuncEspSeg.isFuncEspSegHabilitada(FuncEspSegERP.SEG_1010,"",false,this.getSesion())==false)
					throw new ExceptionValidation(null,"No tiene permiso para eliminar la Novedad");				
			} else {
				if (AltaFuncEspSeg.isFuncEspSegHabilitada(FuncEspSegERP.SEG_1011,"",false,this.getSesion())==false)
					throw new ExceptionValidation(null,"No tiene permiso para eliminar la Novedad");				
			}
			
			novPerm.delete();
			this.addTransaccion(novPerm);
			
		}
		
	}

}
