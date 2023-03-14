package com.srn.erp.compras.op;

import com.srn.erp.compras.bm.Proveedor;
import com.srn.erp.compras.bm.RequisicionCab;
import com.srn.erp.compras.bm.RequisicionDet;
import com.srn.erp.compras.bm.RequisicionDetAutorizacion;
import com.srn.erp.compras.bm.SectorCompra;
import com.srn.erp.general.bm.InformarComprobante;
import com.srn.erp.general.bm.Talonario;
import com.srn.erp.stock.bm.Producto;
import com.srn.erp.stock.bm.UnidadMedida;
import com.srn.erp.ventas.bm.PedidoCab;

import framework.applicarionServer.bl.Utils.Fecha;
import framework.applicarionServer.bm.Seguridad.Usuario;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveAltaItemRequisicion extends Operation {
	
	RequisicionCab requisicion = null;

	public SaveAltaItemRequisicion() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		IDataSet dataset = mapaDatos.getDataSet("TInput");
		String tipo = mapaDatos.getString("TIPO");
		procesarRegistros(dataset,tipo,mapaDatos);
	}

	private void procesarRegistros(IDataSet dataset,String tipo , MapDatos mapaDatos) throws BaseException {

		Talonario talonario = RequisicionCab.getTalonatioDefaultRequisiciones(this.getSesion());
		
		dataset.first();
		while (!dataset.EOF()) {

			
			Integer nroRenglon = new Integer(1);
			
			if (dataset.getString("usar").equals("NUEVA")) {
				requisicion = (RequisicionCab) RequisicionCab.getNew(RequisicionCab.NICKNAME, this.getSesion());
				requisicion.setOID(new Integer(-1));
				requisicion.setActivo(new Boolean(true));
				requisicion.setContabiliza(false);
				requisicion.setTalonario(talonario);
				requisicion.setTipoCompro(talonario.getTipo_comprobante());
				requisicion.setLetra(talonario.getLetra());
		        requisicion.setLugarEmision(talonario.getLugar_emision());
		        requisicion.setEmision(Fecha.getFechaActual());
		        requisicion.setComentario(dataset.getString("comentario"));
		        requisicion.setUsuario(Usuario.findByOidProxy(this.getSesion().getLogin().getUsuario().getOIDInteger(),getSesion()));
		        requisicion.setSectorCompra(SectorCompra.findByOidProxy(dataset.getInteger("oid_sector"),getSesion()));
			} else {
				requisicion = RequisicionCab.findByOid(dataset.getInteger("oid_cco"), this.getSesion());
				requisicion.setComentario(dataset.getString("comentario"));
				nroRenglon = new Integer(requisicion.getMaxNroRenglon());
			}
			
			if (tipo.equals("ITEM"))
				agregarUnItem(dataset,nroRenglon);
			else if (tipo.equals("CANASTA")) {
				IDataSet dsItemsRequi = mapaDatos.getDataSet("TItemsRequisicion");
				agregarCanasta(dsItemsRequi,nroRenglon);
			}
			
			
			

			addTransaccion(requisicion);
			dataset.next();
		}
	}
	
	private void agregarCanasta(IDataSet dataset,Integer nroRenglon) throws BaseException {
		int nuevoNroRenglon = nroRenglon.intValue();
		IDataSet dsItemsCanasta = dataset;
		dsItemsCanasta.first();
		while (!dsItemsCanasta.EOF()) {
			agregarUnItem(dsItemsCanasta,new Integer(nuevoNroRenglon));
			++nuevoNroRenglon;
			dsItemsCanasta.next();
		}
		
		

	}
	
	private void agregarUnItem(IDataSet dataset,Integer nroRenglon) throws BaseException {
		
		// Agregar el Item a la requisicion
		RequisicionDet requiDet = (RequisicionDet) RequisicionDet.getNew(RequisicionDet.NICKNAME, this.getSesion());
		requiDet.setOID(new Integer(-1));
		requiDet.setRequisicion(requisicion);
		requiDet.setProducto(Producto.findByOidProxy(dataset.getInteger("oid_producto"),getSesion()));
		requiDet.setDesc_adic_sku(dataset.getString("desc_adic_producto"));
		requiDet.setRenglon(nroRenglon);
		requiDet.setCant_solicitada(dataset.getDouble("cantidad"));
		requiDet.setUnidad_medida_req(UnidadMedida.findByOidProxy(dataset.getInteger("oid_um"),getSesion()));
		requiDet.setFec_emision(requisicion.getEmision());
		requiDet.setFec_requerida(dataset.getDate("fec_requerida"));
		requiDet.setDecision_autoriz(RequisicionDetAutorizacion.PEND_AUTORIZ); // Este valor debe obtener en forma logica dentro de la clase Requisicion Cab
		requiDet.setSolo_cotizar(new Boolean(false));
		requiDet.setComentario("");
		requiDet.setProveedor(Proveedor.findByOidProxy(dataset.getInteger("oid_proveedor"),getSesion()));
		requiDet.setPend_sol_cotiz(new Boolean(false)); // Tambien hay que procesarlo dentro de la clase
    	
		requiDet.setOidComproRef(dataset.getInteger("oid_cco_referencia"));
		requiDet.setOidComproRefDet(dataset.getInteger("oid_cco_referencia_det"));
		if ((dataset.getInteger("oid_cco_referencia")!=null) && (dataset.getInteger("oid_cco_referencia").intValue()>0))
			requiDet.setNickNameTipoComproRef(PedidoCab.NICKNAME);
    	
		requiDet.marcarSiEstaPendCompra();
		requisicion.addRequisicionDet(requiDet);
				
	}
	
	@Override
	protected void afterSave() throws BaseException {
		// TODO Auto-generated method stub
		super.afterSave();
		
		if (requisicion!=null) {
			InformarComprobante infoCompro = 
				new InformarComprobante(requisicion.getOIDInteger(), 
						requisicion.getDescripcion());
			writeCliente(infoCompro.getDataSetInfoCompro());
		}
		
	}
		
	

}
