package com.srn.erp.excluidos.op;

import java.util.Iterator;

import com.srn.erp.excluidos.bm.IndividuoExcluido;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class ValidarNroDocuExc extends Operation {

	public ValidarNroDocuExc() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		
		Integer oidIndividuo = mapaDatos.getInteger("oid_individuo");
		String nroDocu = mapaDatos.getString("nro_documento");

		IDataSet ds = this.getDataSetNroDocu();
		
		Iterator iterTiposDocu = 
			IndividuoExcluido.getAllByTipoDocu(this.getSesion(), oidIndividuo, nroDocu).iterator();
		while (iterTiposDocu.hasNext()) {
			IndividuoExcluido individuo = (IndividuoExcluido) iterTiposDocu.next();
			cargarRegistro(ds, individuo.getOIDInteger(), individuo.getOIDInteger(), individuo.getApeyNom(), individuo.getNroPrincipal1());
		}
		
		writeCliente(ds);
		
	}
	
	  private IDataSet getDataSetNroDocu() {
		    IDataSet dataset = new TDataSet();
		    dataset.create("TNroDocuAVal");
		    dataset.fieldDef(new Field("oid_individuo", Field.INTEGER, 0));
		    dataset.fieldDef(new Field("nro_interno", Field.INTEGER, 0));
		    dataset.fieldDef(new Field("ape_y_nom", Field.STRING, 100));
		    dataset.fieldDef(new Field("estado", Field.STRING, 100));
		    return dataset;
	  }
	  
	  private void cargarRegistro(
              IDataSet dataset,
              Integer oidIndividuo,
              Integer nroInterno,
              String apeyNom,
              String estado) throws BaseException  {
            dataset.append();
            dataset.fieldValue("oid_individuo", oidIndividuo);
            dataset.fieldValue("nro_interno", nroInterno);
            dataset.fieldValue("ape_y_nom", apeyNom);
            dataset.fieldValue("estado", estado);
}
	  

}
