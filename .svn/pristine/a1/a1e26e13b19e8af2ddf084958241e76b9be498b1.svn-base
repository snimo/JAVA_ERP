package com.srn.erp.turnos.bm;

import framework.applicarionServer.bl.ObjetosAplicacion.*;
import framework.request.bl.Utils.*;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.general.bm.PeriodoIncDet;
import com.srn.erp.turnos.da.DBConcHabCateg;

public class ConcHabCateg extends ObjetoLogico { 
	
	

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean isActivo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

public ConcHabCateg() { 
  }

  public static String NICKNAME = "tu.ConcHabCateg";

  private String comportamiento;
  private String concepto;
  private CategoriaSujetoTurno oid_categoria;

  public String getComportamiento() throws BaseException { 
    supportRefresh();
    return comportamiento;
  }

  public void setComportamiento(String aComportamiento) { 
    this.comportamiento =  aComportamiento;
  }

  public String getConcepto() throws BaseException { 
    supportRefresh();
    return concepto;
  }

  public void setConcepto(String aConcepto) { 
    this.concepto =  aConcepto;
  }

  public CategoriaSujetoTurno getOid_categoria() throws BaseException { 
    supportRefresh();
    return oid_categoria;
  }

  public void setOid_categoria(CategoriaSujetoTurno aOid_categoria) { 
    this.oid_categoria =  aOid_categoria;
  }

  public String getNickName() { 
    return NICKNAME; 
  } 

 public static ConcHabCateg findByOid(Integer oid , ISesion aSesion) throws BaseException { 
   return (ConcHabCateg) getObjectByOid(NICKNAME,oid,aSesion);
  } 

 public static ConcHabCateg findByCodigo(String codigo , ISesion aSesion) throws BaseException { 
   return (ConcHabCateg) getObjectByCodigo(NICKNAME,codigo,aSesion);
  } 

 public void beforeSave() throws BaseException { 
 }
 
 public static List getConceptosHabCateg(CategoriaSujetoTurno categoria,
         ISesion aSesion) throws BaseException {
	  return DBConcHabCateg.getConceptosHabCateg(categoria,aSesion);
 }
 

}
