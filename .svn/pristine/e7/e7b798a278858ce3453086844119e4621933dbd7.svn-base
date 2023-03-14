package com.srn.erp.cip.op;

import com.srn.erp.cip.bm.*;
import framework.request.bl.Operaciones.*;
import framework.request.bl.Utils.*;
import framework.request.bl.XML.IDataSet;

public class SaveMotivoEntIntermedias extends Operation { 

  public SaveMotivoEntIntermedias() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    IDataSet dataset = mapaDatos.getDataSet("TMotivoEntIntermedias"); 
    procesarRegistros(dataset); 
  } 

  private void procesarRegistros(IDataSet dataset) throws BaseException { 
    dataset.first(); 
      while (!dataset.EOF()) { 
        MotivoEntIntermedias motivoentintermedias = MotivoEntIntermedias.findByOid(dataset.getInteger("oid_motivo"),getSesion());
        motivoentintermedias.setOID(dataset.getInteger("oid_motivo"));
        motivoentintermedias.setCodigo(dataset.getString("codigo"));
        motivoentintermedias.setDescripcion(dataset.getString("descripcion"));
        motivoentintermedias.setActivo(dataset.getBoolean("activo"));
        
        IDataSet dsEquiv = 
        	dataset.getDataSet("TEquivMotEntIntermedias");
        dsEquiv.first();
        while (!dsEquiv.EOF()) {
        	EquivMotEntIntermedias equivMotEntIntermedias =
        		EquivMotEntIntermedias.findByOid(dsEquiv.getInteger("oid_equiv_mot"), this.getSesion());
        	equivMotEntIntermedias.setMotivo(motivoentintermedias);
        	equivMotEntIntermedias.setCodigo(dsEquiv.getString("codigo"));
        	equivMotEntIntermedias.setActivo(dsEquiv.getBoolean("activo"));
        	if (!equivMotEntIntermedias.isActivo())
        		equivMotEntIntermedias.delete();
        	motivoentintermedias.addEquivalencia(equivMotEntIntermedias);
        	dsEquiv.next();
        }
        
        addTransaccion(motivoentintermedias);
        dataset.next();
    }
  }
  
}
