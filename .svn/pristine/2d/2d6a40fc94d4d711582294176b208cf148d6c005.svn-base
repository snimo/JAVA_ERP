package com.srn.erp.presupuesto.bm;

import java.util.Iterator;
import java.util.List;

import com.srn.erp.presupuesto.da.DBCombinacionValoresCompo;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;

public class CombinacionValoresCompo extends ObjetoLogico { 

	HashTableDatos valoresCompoPresu = new HashTableDatos();
	
	public void addValorCompo(Integer nroIntCompo,ValorCompoPresu valorCompoPresu) {
		valoresCompoPresu.put(nroIntCompo,valorCompoPresu);
	}
	
	public ValorCompoPresu getValorCompo(Integer aNroInternoCompo) {
		return (ValorCompoPresu)valoresCompoPresu.get(aNroInternoCompo);
	}
	
	public ValorCompoPresu getValorCompo(CompoPresupuestario aCompoPresu) {
		Iterator iterNrosInternos = valoresCompoPresu.keySet().iterator();
		while (iterNrosInternos.hasNext()) {
			Integer nroInterno = (Integer) iterNrosInternos.next();
			CompoPresupuestario compo = (CompoPresupuestario) valoresCompoPresu.get(nroInterno);
			if (compo.getOID() == aCompoPresu.getOID())
				return this.getValorCompo(nroInterno);
		}
		return null;
	}
	
	
  public Boolean isActivo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public CombinacionValoresCompo() { 
  }

  public static String NICKNAME = "pl.CombinacionValoresCompo";

  public String getNickName() { 
    return NICKNAME; 
  } 

 public static CombinacionValoresCompo findByOid(Integer oid , ISesion aSesion) throws BaseException { 
   return null;
  } 

 public static CombinacionValoresCompo findByCodigo(String codigo , ISesion aSesion) throws BaseException { 
   return null;
  } 

 public void beforeSave() throws BaseException { 
 }
 
 public static List getCombinacionesValoresCompo(HashTableDatos aCompoPreuConNroInterno,ISesion aSesion) throws BaseException {
	 return DBCombinacionValoresCompo.getCombinacionesValCompo(aCompoPreuConNroInterno,aSesion);
 }
 
 public static String getAliasFieldByNroIntCompo(Integer aNroInternoCompo) {
 	return DBCombinacionValoresCompo.getAliasFieldByNroIntCompo(aNroInternoCompo);
 }
 

}
