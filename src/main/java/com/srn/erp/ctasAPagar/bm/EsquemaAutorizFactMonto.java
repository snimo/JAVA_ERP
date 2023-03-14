package com.srn.erp.ctasAPagar.bm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.compras.bm.SectorCompra;
import com.srn.erp.ctasAPagar.da.DBEsquemaAutorizFactMonto;
import com.srn.erp.ctasAPagar.da.DBEsquemaAutorizFactSector;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.applicarionServer.bm.Varios.Money;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.ObjetoObservado;
import framework.request.bl.Utils.Validar;

public class EsquemaAutorizFactMonto extends ObjetoLogico {
	
	private List					esquemasAutFactSectores			= new ArrayList();
	private boolean				readEsquemasAutFactSectores	= true;
	

	public Boolean isActivo() throws BaseException {
		// TODO Auto-generated method stub
		return new Boolean(true);
	}

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public EsquemaAutorizFactMonto() {
	}

	public static String						NICKNAME	= "cap.EsquemaAutorizFactMonto";

	private EsquemaAutorizFactProv	esquema_autoriz_factura;

	private Integer									orden;

	private Money										monto_desde;

	private Money										monto_hasta;

	public EsquemaAutorizFactProv getEsquema_autoriz_factura() throws BaseException {
		supportRefresh();
		return esquema_autoriz_factura;
	}

	public void setEsquema_autoriz_factura(EsquemaAutorizFactProv aEsquema_autoriz_factura) {
		this.esquema_autoriz_factura = aEsquema_autoriz_factura;
	}

	public Integer getOrden() throws BaseException {
		supportRefresh();
		return orden;
	}

	public void setOrden(Integer aOrden) {
		this.orden = aOrden;
	}

	public Money getMonto_desde() throws BaseException {
		supportRefresh();
		return monto_desde;
	}

	public void setMonto_desde(Money aMonto_desde) {
		this.monto_desde = aMonto_desde;
	}

	public Money getMonto_hasta() throws BaseException {
		supportRefresh();
		return monto_hasta;
	}

	public void setMonto_hasta(Money aMonto_hasta) {
		this.monto_hasta = aMonto_hasta;
	}

	public String getNickName() {
		return NICKNAME;
	}

	public static EsquemaAutorizFactMonto findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (EsquemaAutorizFactMonto) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static EsquemaAutorizFactMonto findByOidProxy(Integer oid, ISesion aSesion) throws BaseException {
		return (EsquemaAutorizFactMonto) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}

	public static EsquemaAutorizFactMonto findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (EsquemaAutorizFactMonto) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(esquema_autoriz_factura, "Debe ingresar el Esquema de Autorización");
		Validar.noNulo(orden, "Debe ingresar el Orden");
		Validar.noNulo(monto_desde, "Debe ingresar el monto desde");
		Validar.noNulo(monto_hasta, "Debe ingresar el mono hasta");
	}

	public static List getEsqAutorizMontos(EsquemaAutorizFactProv aEsquemaAutorizFactProv, ISesion aSesion)
			throws BaseException {
		return DBEsquemaAutorizFactMonto.getEsqAutorizMontos(aEsquemaAutorizFactProv, aSesion);
	}
	
	public List getEsquemasSectores() throws BaseException {
		if (this.readEsquemasAutFactSectores) {
			List listaEsquemasSectores = EsquemaAutorizFactSector.getEsquemasAutorizFactSector(this, getSesion());
			this.esquemasAutFactSectores.addAll(listaEsquemasSectores);
			this.readEsquemasAutFactSectores = false;
		}
		return this.esquemasAutFactSectores;
	}

	public void addEsquemaAutorizFactSector(EsquemaAutorizFactSector esquemaAutorizFactSector) throws BaseException {
		esquemaAutorizFactSector.setEsquema_autoriz_factura_monto(this);
		this.esquemasAutFactSectores.add(esquemaAutorizFactSector);
	}

	public void afterSave() throws BaseException {
		Iterator iterEsquemasAutorizFactSectores = this.esquemasAutFactSectores.iterator();
		while (iterEsquemasAutorizFactSectores.hasNext()) {
			EsquemaAutorizFactSector esqAutorizFactSector = (EsquemaAutorizFactSector) iterEsquemasAutorizFactSectores.next();
			esqAutorizFactSector.save();
			esqAutorizFactSector = null;
		}
		iterEsquemasAutorizFactSectores = null;
	}
	
	public static EsquemaAutorizFactMonto getEsqAutorizFactMonto(Money monto, EsquemaAutorizFactProv esquemaAutoriz,ISesion aSesion) throws BaseException {
		return DBEsquemaAutorizFactMonto.getEsqAutorizFactMonto(monto,esquemaAutoriz,aSesion);
	}
	
	public List getEsquemasAutorizSectoresRoles(SectorCompra sectorCompra,ISesion aSesion) throws BaseException {
		return DBEsquemaAutorizFactSector.getEsquemasAutorizFactSector(this,sectorCompra,aSesion);
	}
	
	


}
