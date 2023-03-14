package com.srn.erp.cip.op;

import java.util.Iterator;

import com.srn.erp.cip.bm.MotivoVisita;
import com.srn.erp.cip.bm.MotivoVisitaDoc;
import com.srn.erp.cip.bm.TipoDocumentacionCIP;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerMotivoVisita extends Operation { 

  public TraerMotivoVisita() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    MotivoVisita motivovisita = null;
    if (mapaDatos.containsKey("oid")) { 
       Integer oid = mapaDatos.getInteger("oid"); 
       motivovisita = MotivoVisita.findByOid(oid, getSesion()); 
    } 
    else { 
       String codigo = mapaDatos.getString("codigo"); 
       motivovisita = MotivoVisita.findByCodigo(codigo, getSesion()); 
    } 
    
    IDataSet datasetMotivoVisita = getDataSetMotivoVisita();
    IDataSet datasetTipoDocu = getDataSetDocu();
    
    if (motivovisita != null) { 
    	
        cargarRegistroMotivoVisita(datasetMotivoVisita, 
                         motivovisita.getOIDInteger(),
                         motivovisita.getCodigo(),
                         motivovisita.getDescripcion(),
                         motivovisita.isActivo(),
                         motivovisita.isHabEnIngPermiso()
                         );
        
        int secu = 0;
        Iterator iterTipoDocumentacionCIP = TipoDocumentacionCIP.getAllActivos(this.getSesion()).iterator();
        while (iterTipoDocumentacionCIP.hasNext()) {
        	TipoDocumentacionCIP tipoDocu = (TipoDocumentacionCIP) iterTipoDocumentacionCIP.next();
        	MotivoVisitaDoc motivoVisitaDoc = MotivoVisitaDoc.getMotivoVisitaDoc(motivovisita, tipoDocu, this.getSesion());
        	int diasVenc = 0;
        	boolean activo = false;
        	if (motivoVisitaDoc!=null) {
        		diasVenc = motivoVisitaDoc.getDias_aviso_venc();
        		activo = true;
        	}
        	++secu;
        	cargarRegistroNuevo(datasetTipoDocu,secu,motivovisita.getOID(),tipoDocu.getOIDInteger(),diasVenc,activo,tipoDocu.getDescripcion());
        }
        
    }
    
    writeCliente(datasetMotivoVisita);
    writeCliente(datasetTipoDocu);
    
  }

  private IDataSet getDataSetMotivoVisita() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TMotivoVisita");
    dataset.fieldDef(new Field("oid_mot_visita", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("codigo", Field.STRING, 50)); 
    dataset.fieldDef(new Field("descripcion", Field.STRING, 100)); 
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0)); 
    dataset.fieldDef(new Field("hab_en_ing_perm", Field.BOOLEAN, 0));
    return dataset;
  }

  private void cargarRegistroMotivoVisita(IDataSet dataset, 
                         Integer oid_mot_visita,
                         String codigo,
                         String descripcion,
                         Boolean activo,
                         boolean habEntIngPerm) {
    dataset.append(); 
    dataset.fieldValue("oid_mot_visita", oid_mot_visita);
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("descripcion", descripcion);
    dataset.fieldValue("activo", activo);
    dataset.fieldValue("hab_en_ing_perm", habEntIngPerm);
  }
  
  private IDataSet getDataSetDocu() {
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
