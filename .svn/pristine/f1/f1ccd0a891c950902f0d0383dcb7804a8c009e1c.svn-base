package com.srn.erp.turnos.bm;

import framework.applicarionServer.bl.ObjetosAplicacion.*;
import framework.request.bl.Utils.*;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;

import java.util.List;

import com.srn.erp.turnos.da.DBImpoDeudaSujetoTurnos;

public class ImpoDeudaSujetoTurnos extends ObjetoLogico { 

  @Override
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

public ImpoDeudaSujetoTurnos() { 
  }

  public static String NICKNAME = "tu.ImpoDeudaSujetoTurnos";

  private Integer nro_socio;
  private java.util.Date fecha;
  private String cod_mov;
  private Integer nro;
  private Double saldo;
  private String concepto;

  public Integer getNro_socio() throws BaseException { 
    supportRefresh();
    return nro_socio;
  }

  public void setNro_socio(Integer aNro_socio) { 
    this.nro_socio =  aNro_socio;
  }

  public java.util.Date getFecha() throws BaseException { 
    supportRefresh();
    return fecha;
  }

  public void setFecha(java.util.Date aFecha) { 
    this.fecha =  aFecha;
  }

  public String getCod_mov() throws BaseException { 
    supportRefresh();
    return cod_mov;
  }

  public void setCod_mov(String aCod_mov) { 
    this.cod_mov =  aCod_mov;
  }

  public Integer getNro() throws BaseException { 
    supportRefresh();
    return nro;
  }

  public void setNro(Integer aNro) { 
    this.nro =  aNro;
  }

  public Double getSaldo() throws BaseException { 
    supportRefresh();
    return saldo;
  }

  public void setSaldo(Double aSaldo) { 
    this.saldo =  aSaldo;
  }

  public String getConcepto() throws BaseException { 
    supportRefresh();
    return concepto;
  }

  public void setConcepto(String aConcepto) { 
    this.concepto =  aConcepto;
  }

  public String getNickName() { 
    return NICKNAME; 
  } 

 public static ImpoDeudaSujetoTurnos findByOid(Integer oid , ISesion aSesion) throws BaseException { 
   return (ImpoDeudaSujetoTurnos) getObjectByOid(NICKNAME,oid,aSesion);
  } 

 public static ImpoDeudaSujetoTurnos findByCodigo(String codigo , ISesion aSesion) throws BaseException { 
   return (ImpoDeudaSujetoTurnos) getObjectByCodigo(NICKNAME,codigo,aSesion);
  } 

 public void beforeSave() throws BaseException { 
 }
 
 public static void borrarTodo(
         ISesion aSesion)
         throws BaseException {
	 DBImpoDeudaSujetoTurnos.borrarTodo(aSesion);
 }
 
 public static List getDeuda(Integer nroSocio,
         ISesion aSesion) throws BaseException {
	  return DBImpoDeudaSujetoTurnos.getDeuda(nroSocio,aSesion);
 }
 
 

}
