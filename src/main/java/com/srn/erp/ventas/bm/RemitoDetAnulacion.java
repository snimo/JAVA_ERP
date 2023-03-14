package com.srn.erp.ventas.bm;

import java.util.ArrayList;
import java.util.List;

import com.srn.erp.general.bm.ComproCab;
import com.srn.erp.ventas.da.DBRemitoDetAnulacion;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class RemitoDetAnulacion extends ObjetoLogico {

	public void afterSaveNew() throws BaseException {
		// TODO Auto-generated method stub
		super.afterSaveNew();
		
		// Si es un remito en Base a un pedido volver a activar las cantidades del pedido
		
		AplicDespachoPedido.anularAplicion(this.getRemito_det().getRemito_cab(),
				 this.getRemito_det().getOIDInteger(), 
				 this.getSesion());
		
		
	}


	public RemitoDetAnulacion() {
	}

	private List								detalles		= new ArrayList();

	private boolean							readDetalle	= true;

	private ComproCab						comprobante;

	public static String				NICKNAME		= "ve.RemitoDetAnulacion";

	private RemitoCabAnulacion	remito_cab_anu;

	private RemitoDet						remito_det;

	public RemitoCabAnulacion getRemito_cab_anu() throws BaseException {
		supportRefresh();
		return remito_cab_anu;
	}

	public void setRemito_cab_anu(RemitoCabAnulacion aRemito_cab_anu) {
		this.remito_cab_anu = aRemito_cab_anu;
	}

	public RemitoDet getRemito_det() throws BaseException {
		supportRefresh();
		return remito_det;
	}

	public void setRemito_det(RemitoDet aRemito_det) {
		this.remito_det = aRemito_det;
	}

	public String getNickName() {
		return NICKNAME;
	}

	public static RemitoDetAnulacion findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (RemitoDetAnulacion) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static RemitoDetAnulacion findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (RemitoDetAnulacion) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(remito_cab_anu, "Debe ingresar el Remito Anulación");
		Validar.noNulo(remito_det, "Debe ingresar el Detalle del Remito");
	}

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

	public static List getDetalles(RemitoCabAnulacion remitoCabAnulacion, ISesion aSesion) throws BaseException {
		return DBRemitoDetAnulacion.getDetalles(remitoCabAnulacion, aSesion);
	}

}
