package com.srn.erp.turnos.bm;

import java.util.List;

import com.srn.erp.turnos.da.DBRelaConcSujTur;
import com.srn.erp.ventas.bm.Sujeto;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.applicarionServer.bm.Parametros.ValorParametro;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;

public class RelaConcSujTur extends ObjetoLogico { 

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

public RelaConcSujTur() { 
  }

  public static String NICKNAME = "tu.RelaConcSujTur";

  private String concepto;
  private Integer nro_socio;
  private Integer cantidad;
  private Integer numero;
  private java.util.Date desde;
  private java.util.Date hasta;

  public String getConcepto() throws BaseException { 
    supportRefresh();
    return concepto;
  }

  public void setConcepto(String aConcepto) { 
    this.concepto =  aConcepto;
  }

  public Integer getNro_socio() throws BaseException { 
    supportRefresh();
    return nro_socio;
  }

  public void setNro_socio(Integer aNro_socio) { 
    this.nro_socio =  aNro_socio;
  }

  public Integer getCantidad() throws BaseException { 
    supportRefresh();
    return cantidad;
  }

  public void setCantidad(Integer aCantidad) { 
    this.cantidad =  aCantidad;
  }

  public Integer getNumero() throws BaseException { 
    supportRefresh();
    return numero;
  }

  public void setNumero(Integer aNumero) { 
    this.numero =  aNumero;
  }

  public java.util.Date getDesde() throws BaseException { 
    supportRefresh();
    return desde;
  }

  public void setDesde(java.util.Date aDesde) { 
    this.desde =  aDesde;
  }

  public java.util.Date getHasta() throws BaseException { 
    supportRefresh();
    return hasta;
  }

  public void setHasta(java.util.Date aHasta) { 
    this.hasta =  aHasta;
  }

  public String getNickName() { 
    return NICKNAME; 
  } 

 public static RelaConcSujTur findByOid(Integer oid , ISesion aSesion) throws BaseException { 
   return (RelaConcSujTur) getObjectByOid(NICKNAME,oid,aSesion);
  } 

 public static RelaConcSujTur findByCodigo(String codigo , ISesion aSesion) throws BaseException { 
   return (RelaConcSujTur) getObjectByCodigo(NICKNAME,codigo,aSesion);
  } 

 public void beforeSave() throws BaseException { 
 }
 
 public static String getArchDBFRelaConcSocio(ISesion aSesion)
	throws BaseException {
		return ValorParametro.findByCodigoParametro(
				"ARCH_DBF_RELA_CONC_SOCIO", aSesion).getValorCadena();
 }
 
 public static void deleteAll(ISesion aSesion)
      throws BaseException {
	 DBRelaConcSujTur.deleteAllRegistros(aSesion); 
 }
 
 public static List getConcHab(Sujeto sujeto,String comportamiento,
         ISesion aSesion) throws BaseException {
	  return DBRelaConcSujTur.getConcHab(sujeto,comportamiento,aSesion);
 }
 

}
