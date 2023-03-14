package com.srn.erp.ventas.op;

import com.srn.erp.general.bm.ValorClasificadorEntidad;
import com.srn.erp.ventas.bm.DefEstrucLPCab;
import com.srn.erp.ventas.bm.DefEstrucLPDet;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveDefEstrucLPCab extends Operation { 

  public SaveDefEstrucLPCab() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    IDataSet dataset = mapaDatos.getDataSet("TDefEstrucLPCab"); 
    procesarRegistros(dataset); 
  } 

  private void procesarRegistros(IDataSet dataset) throws BaseException { 
    dataset.first(); 
      while (!dataset.EOF()) { 
        DefEstrucLPCab defestruclpcab = DefEstrucLPCab.findByOid(dataset.getInteger("oid_def_estruc_lp"),getSesion());
        
        addTransaccion(defestruclpcab);
        
        defestruclpcab.setOID(dataset.getInteger("oid_def_estruc_lp"));
        defestruclpcab.setCodigo(dataset.getString("codigo"));  
        defestruclpcab.setDescripcion(dataset.getString("descripcion"));
        defestruclpcab.setActivo(dataset.getBoolean("activo"));
        
        IDataSet dsDet = dataset.getDataSet("TDefEstrucLPDet"); 
        
        dsDet.first();
        while (!dsDet.EOF()) { 
          DefEstrucLPDet defestruclpdet = DefEstrucLPDet.findByOid(dsDet.getInteger("oid_def_det_lp"),getSesion());
          defestruclpdet.setOID(dsDet.getInteger("oid_def_det_lp"));
          defestruclpdet.setDef_estruc_lp(DefEstrucLPCab.findByOidProxy(dsDet.getInteger("oid_def_estruc_lp"),this.getSesion()));
          defestruclpdet.setValor_clasif_art_1(ValorClasificadorEntidad.findByOidProxy(dsDet.getInteger("oid_clasif_art_1"),this.getSesion()));
          defestruclpdet.setValor_clasif_art_2(ValorClasificadorEntidad.findByOidProxy(dsDet.getInteger("oid_clasif_art_2"),this.getSesion()));
          defestruclpdet.setOrden(dsDet.getInteger("orden"));
          defestruclpdet.setActivo(dsDet.getBoolean("activo"));
          
          
          if (dsDet.getBoolean("activo").booleanValue()==false)
          	defestruclpdet.delete();
          else {
          	
          	// Modificacion desripcion del clasificador 2
          	ValorClasificadorEntidad valClasifEnt2 = 
          		ValorClasificadorEntidad.findByOid(dsDet.getInteger("oid_clasif_art_2"),this.getSesion());
          	
          	if (!valClasifEnt2.getDescripcion().equals(dsDet.getString("desc_clasif_art_2"))) {
          		valClasifEnt2.setDescripcion(dsDet.getString("desc_clasif_art_2"));
          		this.addTransaccion(valClasifEnt2);
          	}
          		
            // Modificacion desripcion del clasificador 1
            ValorClasificadorEntidad valClasifEnt1 = 
            		ValorClasificadorEntidad.findByOid(dsDet.getInteger("oid_clasif_art_1"),this.getSesion());
            	
            if (!valClasifEnt1.getDescripcion().equals(dsDet.getString("desc_clasif_art_1"))) {
            		valClasifEnt1.setDescripcion(dsDet.getString("desc_clasif_art_1"));
            		this.addTransaccion(valClasifEnt1);
            }
          		
          	
          }
          
          
          defestruclpcab.addDefEstrucLPDet(defestruclpdet);  
          dsDet.next();         
         }

        
        
        dataset.next();
    }
  }
  
}
