package com.srn.erp.presupuesto.op;

import java.util.ArrayList;
import java.util.List;

import com.srn.erp.presupuesto.bm.MatrizValoresVarEsce;
import com.srn.erp.presupuesto.bm.PeriodoPresupuestario;
import com.srn.erp.presupuesto.bm.VarEscenarioCab;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class TraerValoresVarEscenario extends Operation {

	public TraerValoresVarEscenario() {
	}
	
	List listaPeriodos = new ArrayList();

	public void execute(MapDatos mapaDatos) throws BaseException {
		
		  PeriodoPresupuestario periodoDesde = null;
		  PeriodoPresupuestario periodoHasta = null;
		
			VarEscenarioCab varEscenarioCab = VarEscenarioCab.findByOidProxy(mapaDatos.getInteger("oid_var_escenario"),this.getSesion());
			if (varEscenarioCab.tienePeriodos()) {
					if (mapaDatos.containsKey("oid_peri_desde"))
						periodoDesde = PeriodoPresupuestario.findByOidProxy(mapaDatos.getInteger("oid_peri_desde"),this.getSesion());
					if (mapaDatos.containsKey("oid_peri_hasta"))
						periodoHasta = PeriodoPresupuestario.findByOidProxy(mapaDatos.getInteger("oid_peri_hasta"),this.getSesion());
			}
					
			// Traer la lista de los Periodos comprendidos entre los dos periodos
			MatrizValoresVarEsce matriz = new MatrizValoresVarEsce(this.getSesion());
			matriz.setVariableEscenario(varEscenarioCab);
			matriz.setPeriodoDesde(periodoDesde);
			matriz.setPeriodoHasta(periodoHasta);
			  	
			// Devolver los datos de la estructura de tabla
			IDataSet ds = matriz.getDSCamposValoresVarEsce("TValoresVariable");
			matriz.cargarDatosValoresVarEsce(ds);
			writeCliente(ds);

			
			
		
	}


}
