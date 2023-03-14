package com.srn.erp.cip.op;

import com.srn.erp.cip.bm.MotivoVisita;
import com.srn.erp.cip.bm.MotivoVisitaDoc;
import com.srn.erp.cip.bm.TipoDocumentacionCIP;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveMotivoVisita extends Operation { 

  public SaveMotivoVisita() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    IDataSet dataset = mapaDatos.getDataSet("TMotivoVisita"); 
    procesarRegistros(dataset); 
  } 

  private void procesarRegistros(IDataSet dataset) throws BaseException { 
    dataset.first(); 
      while (!dataset.EOF()) { 
        MotivoVisita motivovisita = MotivoVisita.findByOid(dataset.getInteger("oid_mot_visita"),getSesion());
        motivovisita.setCodigo(dataset.getString("codigo"));
        motivovisita.setDescripcion(dataset.getString("descripcion"));
        motivovisita.setActivo(dataset.getBoolean("activo"));
        motivovisita.setHabEnIngPermiso(dataset.getBoolean("hab_en_ing_perm"));
        
        IDataSet dsTipoDocu = dataset.getDataSet("TMotivoVisitaDoc");
        dsTipoDocu.first();
        while (!dsTipoDocu.EOF()) {
        	
        	TipoDocumentacionCIP tipoDocuCIP = TipoDocumentacionCIP.findByOidProxy(dsTipoDocu.getInteger("oid_tipo_docu"), this.getSesion());
        	if (dsTipoDocu.getBoolean("activo")) {
        		MotivoVisitaDoc motivoVisitaDoc = MotivoVisitaDoc.getMotivoVisitaDoc(motivovisita, tipoDocuCIP, this.getSesion());
        		if (motivoVisitaDoc == null) {
        			MotivoVisitaDoc motivoVisitaDocNew = (MotivoVisitaDoc) MotivoVisitaDoc.getNew(MotivoVisitaDoc.NICKNAME, this.getSesion());
        			motivoVisitaDocNew.setMotivo(motivovisita);
        			motivoVisitaDocNew.setTipo_docu(tipoDocuCIP);
        			motivoVisitaDocNew.setActivo(true);
        			motivoVisitaDocNew.setDias_aviso_venc(dsTipoDocu.getInteger("dias_aviso_venc"));
        			motivovisita.addDocuMotivo(motivoVisitaDocNew);
        		} else {
        			motivoVisitaDoc.setDias_aviso_venc(dsTipoDocu.getInteger("dias_aviso_venc"));
        			motivovisita.addDocuMotivo(motivoVisitaDoc);
        		}
        	} else {
        		MotivoVisitaDoc motivoVisitaDel = MotivoVisitaDoc.getMotivoVisitaDoc(motivovisita, tipoDocuCIP, this.getSesion());
        		if (motivoVisitaDel!=null) {
        			motivoVisitaDel.delete();
        			motivovisita.addDocuMotivo(motivoVisitaDel);
        		}
        	}
        	
        	
        	dsTipoDocu.next();
        }
        
        
        addTransaccion(motivovisita);
        dataset.next();
    }
  }
  
}
