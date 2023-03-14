package com.srn.erp.ventas.bm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.general.bm.ComproCab;
import com.srn.erp.pagos.bm.AnuladorRendFF;
import com.srn.erp.stock.bm.Producto;
import com.srn.erp.ventas.da.DBDevolucionVtasCab;

import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.Validar;

public class DevolucionVtasCab extends ComproCab {

	public static final String DEV_CLIENTE = "DEVCLI";
	private AnulacionDevolucionCab	anulacionDevCab = null;

	private ComproCab comprobante;
	
	private List devolucionesDet = new ArrayList();
	private boolean readDevolucionesDet = true;

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return super.getDescripcion();
	}

	public DevolucionVtasCab() {
	}

	public static HashTableDatos getTiposDevoluciones() throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put(DEV_CLIENTE, "Devolución de Cliente");
		return condiciones;
	}

	public static String NICKNAME = "ve.DevolucionVtasCab";

	private Sujeto sujeto;
	private String tipoDevolucion;
	private FacturaCab factura;
	private PedidoCab pedido;
	private RemitoCab remito;
	private String tipoOper;
	
	private List detallesDev = new ArrayList();
	private boolean readDetallesDev = true;
	

	public Sujeto getSujeto() throws BaseException {
		supportRefresh();
		return sujeto;
	}

	public void setSujeto(Sujeto aSujeto) {
		this.sujeto = aSujeto;
	}

	public FacturaCab getFacturaCab() throws BaseException {
		supportRefresh();
		return this.factura;
	}

	public void setFacturaCab(FacturaCab aFacturaCab) {
		this.factura = aFacturaCab;
	}

	public PedidoCab getPedidoCab() throws BaseException {
		supportRefresh();
		return this.pedido;
	}

	public void setPedidoCab(PedidoCab aPedidoCab) {
		this.pedido = aPedidoCab;
	}

	public RemitoCab getRemitoCab() throws BaseException {
		supportRefresh();
		return this.remito;
	}

	public void setRemitoCab(RemitoCab aRemitoCab) {
		this.remito = aRemitoCab;
	}

	public String getTipoDevolucion() throws BaseException {
		supportRefresh();
		return this.tipoDevolucion;
	}

	public void setTipoOperacion(String aTipoOperacion) {
		this.tipoOper = aTipoOperacion;
	}

	public String getTipoOperacion() throws BaseException {
		supportRefresh();
		return this.tipoOper;
	}

	public void setTipoDevolucion(String aTipoDevolucion) {
		this.tipoDevolucion = aTipoDevolucion;
	}

	public String getNickName() {
		return NICKNAME;
	}

	public static DevolucionVtasCab findByOid(Integer oid, ISesion aSesion)
			throws BaseException {
		return (DevolucionVtasCab) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static DevolucionVtasCab findByOidProxy(Integer oid, ISesion aSesion)
			throws BaseException {
		return (DevolucionVtasCab) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}

	public static DevolucionVtasCab findByCodigo(String codigo, ISesion aSesion)
			throws BaseException {
		return (DevolucionVtasCab) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {

		if (this.isNew()) {
			this.setComprobante(this);
			this.setEstado(ComproCab.ESTADO_ALTA);
			this.setActivo(new Boolean(true));
		}

		beforeSaveComprobante(this);

		validarDatos();

	}
	
	private void validarDatos() throws BaseException {

		Validar.noNulo(this.sujeto, "Debe ingresar el cliente");
		Validar.noNulo(this.tipoOper, "Debe ingresar el Tipo de Operación");
		Validar.noNulo(this.tipoDevolucion,"Debe ingresar el Tipo de Devolución");
		
	}
	
	public void setComprobante(ComproCab aComprobante) {
		this.comprobante = aComprobante;
	}
	
	public List getDetallesDev() throws BaseException {
		if (this.readDetallesDev) {
		   List listaDetallesDev = DevolucionVtasDet.getDevolucionesVtasDet(this,getSesion());
		   detallesDev.addAll(listaDetallesDev);
		   readDetallesDev = false;
		}
		return detallesDev;
	}

	public void addDetalleDev(DevolucionVtasDet devolucionDet) throws BaseException {
		devolucionDet.setDevolucion_cab(this);
		detallesDev.add(devolucionDet);
	}

	public void afterSave() throws BaseException {
		Iterator iterDevolucionesDet = detallesDev.iterator();
		while (iterDevolucionesDet.hasNext()) {
		  DevolucionVtasDet devVtasDet = (DevolucionVtasDet) iterDevolucionesDet.next();
		  devVtasDet.save();
		  devVtasDet = null;
		}
		iterDevolucionesDet = null;
	}
	
	public static List getDevolucionesCab(
			Integer nroExtDesde, 
			Integer nroExtHasta, 
			java.util.Date fecDesde,
			java.util.Date fecHasta, 
			Sujeto sujeto, 
			Producto producto, 
			FacturaCab factura,
			PedidoCab pedido,
			RemitoCab remito,
			ISesion aSesion) throws BaseException {
		return DBDevolucionVtasCab.getDevolucionesCab(nroExtDesde, nroExtHasta, fecDesde, fecHasta, sujeto, producto, factura, pedido, remito, aSesion);
	}
	
	public void anular() throws BaseException {

		anulacionDevCab = (AnulacionDevolucionCab) anulacionDevCab.getNew(AnulacionDevolucionCab.NICKNAME, getSesion());
		anulacionDevCab.setDevolucion_cab(this);
		anulacionDevCab.generarComproAnulacion();
		anulacionDevCab.save();

	}
	
	


}
