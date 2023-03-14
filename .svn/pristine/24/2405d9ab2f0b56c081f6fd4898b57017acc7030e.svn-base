package com.srn.erp.excluidos.op;

import java.util.Iterator;

import com.srn.erp.excluidos.bm.AdmEstadoExcluido;
import com.srn.erp.excluidos.bm.IndividuoExcluido;
import com.srn.erp.excluidos.bm.ManagerEstadoExcluido;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;

public class SaveActuEstadosExc extends Operation {

	public SaveActuEstadosExc() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {

		try {
			String ignorarProceso = this.getServicios().getValueParameter("IgnorarProcActuEstadoExc");
			if ((ignorarProceso!=null) && (ignorarProceso.equals("SI"))) return;
		} catch(Exception e) {
			
		}
		
		// Actualizar el estado de todos los individuos
		ManagerEstadoExcluido managerEstadoExc = new ManagerEstadoExcluido();
		managerEstadoExc.setSesion(this.getSesion());

		Iterator iterIndExc = IndividuoExcluido.getAllIndividuosExcluidos(this.getSesion()).iterator();

		while (iterIndExc.hasNext()) {
			IndividuoExcluido individuoExcluido = (IndividuoExcluido) iterIndExc.next();
			managerEstadoExc.setIndividuo(individuoExcluido);
			managerEstadoExc.determinarEstado();

			AdmEstadoExcluido admEstadoExcluido = managerEstadoExc.getAdmEstadoExcluido();
			if (admEstadoExcluido != null) {
				
				// Verificar si hubo un cambio en el estado o Novedad del Individuo
				if ( 
				((individuoExcluido.getNovedadExcluido()==null) && (admEstadoExcluido.getNovedad()!=null)) ||
				((individuoExcluido.getNovedadExcluido()!=null) && (admEstadoExcluido.getNovedad()==null)) ||
				((individuoExcluido.getNovedadExcluido()!=null) && (admEstadoExcluido.getNovedad()!=null) && (individuoExcluido.getNovedadExcluido().getOID()!=admEstadoExcluido.getNovedad().getOID())) ||
				((individuoExcluido.getEstado()==null) && (admEstadoExcluido.getEstado()!=null)) ||
				((individuoExcluido.getEstado()!=null) && (admEstadoExcluido.getEstado()==null)) ||
				((individuoExcluido.getEstado()!=null) && (admEstadoExcluido.getEstado()!=null) && (individuoExcluido.getEstado().getOID()!=admEstadoExcluido.getEstado().getOID())) 
				) 
					admEstadoExcluido.setActuNroSinc(true);
				else
					admEstadoExcluido.setActuNroSinc(false);
				
				admEstadoExcluido.save();
				try { this.getSesion().commitTransaction(); } catch(Exception e) {};
			}
			

		}

	}

}
