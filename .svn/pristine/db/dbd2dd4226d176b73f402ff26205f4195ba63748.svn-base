package com.srn.erp.cip.op;

import java.util.Iterator;

import com.srn.erp.cip.bm.TipoDocumentacionCIP;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class SaveNuevoMotivo extends Operation {

	public SaveNuevoMotivo() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		Integer oidMotivo = mapaDatos.getInteger("oid_motivo");
		cargarDocumentos(oidMotivo);
	}

	private void cargarDocumentos(Integer oidMotivo) throws BaseException {
		IDataSet ds = this.getDataSetAltaDocu();
		Iterator iterTipoDocu = TipoDocumentacionCIP.getAllActivos(this.getSesion()).iterator();
		int secu = 0;
		while (iterTipoDocu.hasNext()) {
			++secu;
			TipoDocumentacionCIP tipoDocu = (TipoDocumentacionCIP) iterTipoDocu.next();
			cargarRegistroNuevo(ds, secu, oidMotivo, tipoDocu.getOIDInteger(), 0, false, tipoDocu.getDescripcion());
		}
		writeCliente(ds);
	}
	
	  private IDataSet getDataSetAltaDocu() {
		    IDataSet dataset = new TDataSet();
		    dataset.create("TMotivoVisitaDoc");
		    dataset.fieldDef(new Field("oid_mot_vis_doc", Field.INTEGER, 0));
		    dataset.fieldDef(new Field("oid_mot_visita", Field.INTEGER, 0)); 
		    dataset.fieldDef(new Field("oid_tipo_docu", Field.INTEGER, 0));
		    dataset.fieldDef(new Field("dias_aviso_venc", Field.INTEGER, 0)); 
		    dataset.fieldDef(new Field("activo" , Field.BOOLEAN, 0));
		    dataset.fieldDef(new Field("desc_motivo" , Field.STRING, 100));
		    return dataset;
	  }

	  private void cargarRegistroNuevo(
			  IDataSet dataset,
		      Integer oidMotVisDoc,
		      Integer oidMotVisita,
		      Integer oidTipoDocu,
		      Integer diasAvisoVenc,
		      boolean activo,
		      String descMotivo) {
		    dataset.append();
		    dataset.fieldValue("oid_mot_vis_doc", oidMotVisDoc);
		    dataset.fieldValue("oid_mot_visita", oidMotVisita); 
		    dataset.fieldValue("oid_tipo_docu", oidTipoDocu);
		    dataset.fieldValue("dias_aviso_venc", diasAvisoVenc); 
		    dataset.fieldValue("activo" , activo);
		    dataset.fieldValue("desc_motivo" , descMotivo);
	  }
	

}
