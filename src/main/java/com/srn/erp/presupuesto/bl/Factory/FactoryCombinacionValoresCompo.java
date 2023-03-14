package com.srn.erp.presupuesto.bl.Factory;

import java.util.Iterator;

import com.srn.erp.presupuesto.bm.CombinacionValoresCompo;
import com.srn.erp.presupuesto.bm.ValorCompoPresu;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;

public class FactoryCombinacionValoresCompo extends FactoryObjetoLogico { 

	HashTableDatos mapaCompoPresu = null;
	
  public void newNotifyCondiciones(Object condiciones) throws BaseException {
  	mapaCompoPresu = (HashTableDatos) condiciones;
	}
	
  public FactoryCombinacionValoresCompo() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    CombinacionValoresCompo combinacion = (CombinacionValoresCompo) objLog;
    Iterator iterNrosIntCompo = mapaCompoPresu.keySet().iterator();
    while (iterNrosIntCompo.hasNext()) {
    	Integer nroInterno = (Integer) iterNrosIntCompo.next();
    	ValorCompoPresu valorCompo = ValorCompoPresu.findByOidProxy(db.getInteger("oid_val_compo_"+nroInterno),this.getSesion()); 
    	combinacion.addValorCompo(nroInterno,valorCompo);
    }
    
  }
  
  
}
