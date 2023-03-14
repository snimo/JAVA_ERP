package com.srn.erp.presupuesto.op;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.presupuesto.bm.MatrizValoresVarEsce;
import com.srn.erp.presupuesto.bm.PeriodoPresupuestario;
import com.srn.erp.presupuesto.bm.ValorVariableEscenario;
import com.srn.erp.presupuesto.bm.VarEscenarioCab;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveValoresVarEscenario extends Operation {

	public SaveValoresVarEscenario() {
	}
	
	List listaPeriodos = new ArrayList();

	public void execute(MapDatos mapaDatos) throws BaseException {
		
		  PeriodoPresupuestario periodoDesde = null;
		  PeriodoPresupuestario periodoHasta = null;
		
		  IDataSet dsVarEsce = mapaDatos.getDataSet("TVarEscenario");
		  dsVarEsce.first();
		  while (!dsVarEsce.EOF()) {
		  	VarEscenarioCab varEscenarioCab = 
		  		VarEscenarioCab.findByOid(dsVarEsce.getInteger("oid_var_escenario"),this.getSesion());
		  	if ((dsVarEsce.getInteger("oid_peri_desde")!=null) &&
		  	   (dsVarEsce.getInteger("oid_peri_desde").intValue()>0))
		  		 periodoDesde = PeriodoPresupuestario.findByOidProxy(dsVarEsce.getInteger("oid_peri_desde"),this.getSesion());
		  	if ((dsVarEsce.getInteger("oid_peri_hasta")!=null) &&
			  	   (dsVarEsce.getInteger("oid_peri_hasta").intValue()>0))
			  		 periodoHasta = PeriodoPresupuestario.findByOidProxy(dsVarEsce.getInteger("oid_peri_hasta"),this.getSesion());
		  	
		  	IDataSet dsValores = dsVarEsce.getDataSet("TValoresVariable");
		  	
		  	MatrizValoresVarEsce matriz = new MatrizValoresVarEsce(this.getSesion());
		  	matriz.setVariableEscenario(varEscenarioCab);
		  	matriz.setPeriodoDesde(periodoDesde);
		  	matriz.setPeriodoHasta(periodoHasta);
		  	List listaValVarEsce = matriz.grabarDatosValoresVarEsce(dsValores);
		  	
		  	Iterator iterValVarEsce = listaValVarEsce.iterator();
		  	while (iterValVarEsce.hasNext()) {
		  		ValorVariableEscenario valVarEsce = (ValorVariableEscenario) iterValVarEsce.next();
		  		this.addTransaccion(valVarEsce);
		  	}
		  	
		  	dsVarEsce.next();
		  }
		  
	}


}
