package com.srn.erp.stock.bl.Factory;

import java.util.Iterator;

import com.srn.erp.contabilidad.bm.Atributo;
import com.srn.erp.contabilidad.bm.GrupoAtributoEntidadVar;
import com.srn.erp.contabilidad.bm.GrupoDeAtributos;
import com.srn.erp.stock.bm.AtributosProducto;
import com.srn.erp.stock.bm.Producto;
import com.srn.erp.stock.da.DBAtributosProducto;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryAtributosProducto extends FactoryObjetoLogico { 

  public FactoryAtributosProducto() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
  	
    AtributosProducto atributosproducto = (AtributosProducto) objLog;
    atributosproducto.setOID(db.getInteger(DBAtributosProducto.OID_PRODUCTO_ATRI));
    atributosproducto.setProducto(Producto.findByOidProxy(db.getInteger(DBAtributosProducto.OID_PRODUCTO),getSesion()));
    
    // Leer la Informacion de atributos
    Iterator iterAtributos = atributosproducto.getProducto().getAtributos().iterator();
    while (iterAtributos.hasNext()) {
    	Atributo atributo = (Atributo) iterAtributos.next();
    	// Leer dato de la Base
    	if (atributo.isValorCompo()) {
    		  IObjetoLogico objLogAtri = (IObjetoLogico)atributo.getCompo().getValorCompo(db.getInteger(atributo.getCampoFisico()));
    		  atributosproducto.addValor(atributo,objLogAtri);	
    	} else if (atributo.isString()) 
      					  atributosproducto.addValor(atributo,db.getString(atributo.getCampoFisico()));	
    	  else if (atributo.isDecimal())			    		
    	  					atributosproducto.addValor(atributo,db.getDouble(atributo.getCampoFisico()));
    	  else if (atributo.isEntero())			    		
					atributosproducto.addValor(atributo,db.getInteger(atributo.getCampoFisico()));
    	  else if (atributo.isFecha())			    		
					atributosproducto.addValor(atributo,db.getDate(atributo.getCampoFisico()));
    }
    
    // Leer Informacion correspondiente a los grupos Variables
    Iterator iterGruAtriVar = atributosproducto.getProducto().getGruposAtributosVariables().iterator();
    while (iterGruAtriVar.hasNext()) {
    	GrupoAtributoEntidadVar grupoAtriEntVar = (GrupoAtributoEntidadVar) iterGruAtriVar.next();
    	Integer oidGrupoDeAtributos = db.getInteger(grupoAtriEntVar.getCampoFisico());
    	if ((oidGrupoDeAtributos!=null) && (oidGrupoDeAtributos.intValue()>0)) {
    		GrupoDeAtributos grupoDeAtributos = GrupoDeAtributos.findByOidProxy(oidGrupoDeAtributos,this.getSesion());
    		atributosproducto.addGrupoAtributoEntidadVar(grupoAtriEntVar,grupoDeAtributos);
    	}
    	else atributosproducto.addGrupoAtributoEntidadVar(grupoAtriEntVar,null);
    }
    

  }
}
