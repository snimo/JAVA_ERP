package com.srn.erp.stock.bm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.general.bm.ComproCab;
import com.srn.erp.stock.da.DBPedMercDep;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.Validar;

public class PedMercDep extends ComproCab {

	public PedMercDep() {
	}

	public static String NICKNAME = "st.PedMercDep";

	private SolicitarAPedMerc solicitar_a;
	private Deposito deposito_entrega;

	private ComproCab comprobante;

	private List detalles = new ArrayList();
	private boolean readDetalles = true;

	public SolicitarAPedMerc getSolicitar_a() throws BaseException {
		supportRefresh();
		return solicitar_a;
	}

	public void setSolicitar_a(SolicitarAPedMerc aSolicitar_a) {
		this.solicitar_a = aSolicitar_a;
	}

	public Deposito getDeposito_entrega() throws BaseException {
		supportRefresh();
		return deposito_entrega;
	}

	public void setDeposito_entrega(Deposito aDeposito_entrega) {
		this.deposito_entrega = aDeposito_entrega;
	}

	public String getNickName() {
		return NICKNAME;
	}

	public static PedMercDep findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (PedMercDep) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static PedMercDep findByOidProxy(Integer oid, ISesion aSesion) throws BaseException {
		return (PedMercDep) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}

	public static PedMercDep findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (PedMercDep) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {

		Validar.noNulo(this.solicitar_a, "Debe ingresar a quien se le solicita la Mercadería");
		Validar.noNulo(this.deposito_entrega, "Debe ingresar el Depósito");
		
		if (this.isNew()) {
			this.setComprobante(this);
			this.setEstado(ComproCab.ESTADO_ALTA);
			this.setActivo(new Boolean(true));
		}

		beforeSaveComprobante(this);

	}

	public void setComprobante(ComproCab aComprobante) {
		this.comprobante = aComprobante;
	}
	
	public List getDetalles() throws BaseException {
		if (this.readDetalles) {
		   List listaDetalles = PedMercDepoDet.getDetalles(this,getSesion());
		   detalles.addAll(listaDetalles);
		   readDetalles = false;
		}
		return detalles;
	}

	public void addDetalle(PedMercDepoDet aPedMercDepoDet) throws BaseException {
		aPedMercDepoDet.setPedido_mercaderia(this);
		detalles.add(aPedMercDepoDet);
	}

	public void afterSave() throws BaseException {
		Iterator iterDetalles = detalles.iterator();
		while (iterDetalles.hasNext()) {
		  PedMercDepoDet pedMercDepoDet = (PedMercDepoDet) iterDetalles.next();
		  pedMercDepoDet.save();
		  pedMercDepoDet = null;
		}
		iterDetalles = null;
	}
	
	public static List getPedidosParaDeposito(
			Integer nroExtDesde,
			Integer nroExtHasta, 
			java.util.Date fecDesde,
			java.util.Date fecHasta, 
			SolicitarAPedMerc solicitarA,
			Deposito deposito, ISesion aSesion) throws BaseException {
		return DBPedMercDep.getPedidosParaDeposito(nroExtDesde,nroExtHasta,fecDesde,fecHasta,solicitarA,deposito,aSesion);
	}
	
	
	

}
