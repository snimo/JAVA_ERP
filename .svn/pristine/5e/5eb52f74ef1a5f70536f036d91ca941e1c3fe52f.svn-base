package com.srn.erp.presupuesto.op;


import com.srn.erp.presupuesto.bm.MatrizValoresVarEsce;
import com.srn.erp.presupuesto.bm.PeriodoPresupuestario;
import com.srn.erp.presupuesto.bm.VarEscenarioCab;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class TraerDefCamposValVarEsce extends Operation { 

  public TraerDefCamposValVarEsce() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
  	
  	PeriodoPresupuestario periDesde = null;
  	PeriodoPresupuestario periHasta = null;
  	
  	VarEscenarioCab varEscenarioCab = VarEscenarioCab.findByOid(mapaDatos.getInteger("oid_var_escenario"), 
  			                                                        getSesion());
  	if (varEscenarioCab.getTipo_periodo()!=null) {
  		periDesde = PeriodoPresupuestario.findByOid(mapaDatos.getInteger("oid_peri_desde"),this.getSesion());
  		periHasta = PeriodoPresupuestario.findByOid(mapaDatos.getInteger("oid_peri_hasta"),this.getSesion());
  	}
  	
  	MatrizValoresVarEsce matriz = new MatrizValoresVarEsce(this.getSesion());
  	matriz.setVariableEscenario(varEscenarioCab);
  	matriz.setPeriodoDesde(periDesde);
  	matriz.setPeriodoHasta(periHasta);
  	
  	// Devolver los datos de la estructura de tabla
  	IDataSet ds = matriz.getEstructuraDataSet("TEstrucValoresVarEsce");
  	matriz.cargarCamposEstructuraDS(ds);
  	writeCliente(ds);
  	
  }

}
