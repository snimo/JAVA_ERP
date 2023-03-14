package com.srn.erp.tesoreria.bm;

import java.util.Date;
import java.util.List;

import com.srn.erp.general.bm.Moneda;
import com.srn.erp.general.bm.TipoComprobante;
import com.srn.erp.tesoreria.da.DBMovCajaDiaTipoCompro;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bm.Varios.Money;
import framework.request.bl.Utils.BaseException;

public class MovCajaDiaTipoCompro extends ObjetoLogico { 

  public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public Boolean isActivo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

public MovCajaDiaTipoCompro() { 
  }

  public static String NICKNAME = "te.MovCajaDiaTipoCompro";

  private TipoValor tipo_valor;
  private Moneda moneda;
  private TipoComprobante tipo_comprobante;
  private Money importe;
  private Caja caja;

  public TipoValor getTipo_valor() throws BaseException { 
    supportRefresh();
    return tipo_valor;
  }

  public void setTipo_valor(TipoValor aTipo_valor) { 
    this.tipo_valor =  aTipo_valor;
  }

  public Moneda getMoneda() throws BaseException { 
    supportRefresh();
    return moneda;
  }

  public void setMoneda(Moneda aMoneda) { 
    this.moneda =  aMoneda;
  }

  public TipoComprobante getTipo_comprobante() throws BaseException { 
    supportRefresh();
    return tipo_comprobante;
  }

  public void setTipo_comprobante(TipoComprobante aTipo_comprobante) { 
    this.tipo_comprobante =  aTipo_comprobante;
  }

  public Money getImporte() throws BaseException { 
    supportRefresh();
    return importe;
  }

  public void setImporte(Money aImporte) { 
    this.importe =  aImporte;
  }

  public Caja getCaja() throws BaseException { 
    supportRefresh();
    return caja;
  }

  public void setCaja(Caja aCaja) { 
    this.caja =  aCaja;
  }

  public String getNickName() { 
    return NICKNAME; 
  } 

 public static MovCajaDiaTipoCompro findByOid(Integer oid , ISesion aSesion) throws BaseException { 
   return (MovCajaDiaTipoCompro) getObjectByOid(NICKNAME,oid,aSesion);
  } 

 public static MovCajaDiaTipoCompro findByCodigo(String codigo , ISesion aSesion) throws BaseException { 
   return (MovCajaDiaTipoCompro) getObjectByCodigo(NICKNAME,codigo,aSesion);
  } 

  public void beforeSave() throws BaseException { 
  }
  
  public static List getMovDiaTiposComprobantes(Caja caja,TipoValor tipoValor,Date fecha,ISesion aSesion) throws BaseException {
	return DBMovCajaDiaTipoCompro.getMovDiaTiposComprobantes(caja,tipoValor,fecha,aSesion);
  }
  
  public static List getMovDiaTiposComproEntreFechas(Caja caja,
		  											TipoValor tipoValor,
		  											Date fechaDesde,
		  											Date fechaHasta,
		  											ISesion aSesion) throws BaseException {
	return DBMovCajaDiaTipoCompro.getMovDiaTiposComprobantesEntreFechas(caja,tipoValor,fechaDesde,fechaHasta,aSesion);
  }  
  

}
