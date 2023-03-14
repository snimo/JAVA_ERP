package com.srn.erp.ventas.op;

import com.srn.erp.compras.bm.InformeControlCalidadDet;
import com.srn.erp.compras.bm.MotivoRechazoCC;
import com.srn.erp.compras.bm.OrdenDeCompraDet;
import com.srn.erp.compras.bm.Proveedor;
import com.srn.erp.general.bm.ComproCab;
import com.srn.erp.general.bm.InformarComprobante;
import com.srn.erp.general.bm.LugarEmision;
import com.srn.erp.general.bm.Pais;
import com.srn.erp.general.bm.Provincia;
import com.srn.erp.general.bm.Talonario;
import com.srn.erp.general.bm.TipoComprobante;
import com.srn.erp.general.bm.UnidadOrganizativa;
import com.srn.erp.stock.bm.Deposito;
import com.srn.erp.stock.bm.EstadoStock;
import com.srn.erp.stock.bm.Partida;
import com.srn.erp.stock.bm.PedMercDepoDet;
import com.srn.erp.stock.bm.Producto;
import com.srn.erp.stock.bm.Serie;
import com.srn.erp.stock.bm.TipoConfMovStkTalonario;
import com.srn.erp.stock.bm.UbicacionDeposito;
import com.srn.erp.stock.bm.UnidadMedida;
import com.srn.erp.ventas.bm.CompoStkTalonarioRto;
import com.srn.erp.ventas.bm.PedidoDet;
import com.srn.erp.ventas.bm.RemitoCab;
import com.srn.erp.ventas.bm.RemitoCabMovStock;
import com.srn.erp.ventas.bm.RemitoDet;
import com.srn.erp.ventas.bm.RemitoDetMovStock;
import com.srn.erp.ventas.bm.RemitoDetPartidaSerie;
import com.srn.erp.ventas.bm.Sujeto;
import com.srn.erp.ventas.bm.UnidadEdilicia;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveRemito extends Operation {

	private RemitoCab	remitocab;

	public SaveRemito() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		IDataSet dataset = mapaDatos.getDataSet("TRemitoCab");
		procesarRegistros(dataset,mapaDatos);
	}

	private void procesarRegistros(IDataSet dataset,MapDatos mapaDatos) throws BaseException {
		dataset.first();
		while (!dataset.EOF()) {
			remitocab = RemitoCab.findByOid(dataset.getInteger("oid_remito_cab"), getSesion());
			
			
			// Analizar si se trata de una Anulacion del Remito
			if ((remitocab.isNew()==false) && 
					(remitocab.isActivo().booleanValue()) && 
					(dataset.getBoolean("activo").booleanValue()==false)) {
				remitocab.delete();
				this.addTransaccion(remitocab);
				return;
			}
			
			if ((mapaDatos.containsKey("sys_rollback")) && (mapaDatos.getString("sys_rollback").equals("s")))
				remitocab.setNoValidarNroExt(true);
			
			remitocab.setContabiliza(false);
			remitocab.setTipoRemito(dataset.getString("tipo_remito"));
			remitocab.setTalonario(Talonario.findByOidProxy(dataset.getInteger("oid_talonario"), getSesion()));
			remitocab.setTipoCompro(TipoComprobante.findByOidProxy(dataset.getInteger("oid_tc"), getSesion()));
			remitocab.setLetra(dataset.getString("letra"));
			remitocab.setLugarEmision(LugarEmision.findByOidProxy(dataset.getInteger("oid_lug_emi"), getSesion()));
			remitocab.setNroext(dataset.getInteger("nro_ext"));
			remitocab.setEmision(dataset.getDate("fecha"));
			remitocab.setComentario(dataset.getString("comentario"));
			remitocab.setComportamientoRto(dataset.getString("compo_rto"));
			Deposito depositoDestino = null;
			if (dataset.getString("compo_rto").equals(RemitoCab.DESPACHO_DEV_PROVEEDOR)) {
				remitocab.setProveedor(Proveedor.findByOidProxy(dataset.getInteger("oid_sujeto"), getSesion()));
				remitocab.setSujeto(null);
			} if (dataset.getString("compo_rto").equals(RemitoCab.DESPACHO_PED_PARA_DEPO)) {
				depositoDestino = Deposito.findByOid(dataset.getInteger("oid_sujeto"), this.getSesion());
				remitocab.setSujeto(null);
				remitocab.setProveedor(null);
			}
			else {
				remitocab.setSujeto(Sujeto.findByOidProxy(dataset.getInteger("oid_sujeto"), getSesion()));
				remitocab.setProveedor(null);
			}
			
			remitocab.setDestinatario(dataset.getString("destinatario"));
			remitocab.setDestino(dataset.getString("destino"));
			
			
			//remitocab.setDepo_destino(Deposito.findByOidProxy(dataset.getInteger("oid_depo"), getSesion()));
			remitocab.setDepo_destino(depositoDestino);
			//remitocab.setUni_edi_dest(UnidadEdilicia.findByOid(dataset.getInteger("oid_dom_ent"), getSesion()));
			remitocab.setUni_org_dest(UnidadOrganizativa.findByOid(dataset.getInteger("oid_uni_org_dest"), getSesion()));
			remitocab.setCalle_y_nro(dataset.getString("calle_y_nro"));
			remitocab.setLocalidad(dataset.getString("localidad"));
			remitocab.setCodigo_postal(dataset.getString("codigo_postal"));
			remitocab.setComentario(dataset.getString("comentario"));
			remitocab.setProvincia(Provincia.findByOidProxy(dataset.getInteger("oid_provincia"), getSesion()));
			remitocab.setPais(Pais.findByOidProxy(dataset.getInteger("oid_pais"), getSesion()));
			remitocab.setActivo(dataset.getBoolean("activo"));
			remitocab.setCompoStkTalRto(CompoStkTalonarioRto.findByOidProxy(dataset.getInteger("oid_compo_stk_rto"),
					getSesion()));
			
			remitocab.setTipoConfMovStk(TipoConfMovStkTalonario.findByOidProxy(dataset.getInteger("oid_tipo_conf_mov"),
					getSesion()));
			remitocab.setActuStock(true);
			remitocab.setNroInterno(dataset.getInteger("nro_interno"));
			remitocab.setReferencia1(dataset.getString("oc"));
			remitocab.setReferencia2(dataset.getString("pedido"));

			IDataSet dsDet = dataset.getDataSet("TRemitoDet");
			dsDet.first();
			while (!dsDet.EOF()) {
				
				// Los Detalles que estan en cero se descartan
				if (dsDet.getDouble("cant_desp")==null)
					throw new ExceptionValidation(null,"Debe ingresar la cantidad a despachar");
				
				if (dsDet.getInteger("oid_um_desp")==null)
					throw new ExceptionValidation(null,"Debe ingresar la unidad de despacho");
				
				if (dsDet.getDouble("cant_desp").doubleValue()==0) {
					dsDet.next();
					continue;
				}
				
				RemitoDet remitoDet = RemitoDet.findByOid(dsDet.getInteger("oid_remito_det"), getSesion());
				remitoDet.setRemito_cab(remitocab);
				remitoDet.setProducto(Producto.findByOidProxy(dsDet.getInteger("oid_producto"), getSesion()));
								
				remitoDet.setCant_desp(dsDet.getDouble("cant_desp"));
				CompoStkTalonarioRto compoStkTalRto = CompoStkTalonarioRto.findByOid(dsDet.getInteger("oid_compo_stk_rto"),
						getSesion());
				if (compoStkTalRto == null)
					compoStkTalRto = remitocab.getCompoStkTalRto();
				remitoDet.setCompoStkTalonarioRto(compoStkTalRto);
				remitoDet.setUnidad_desp(UnidadMedida.findByOidProxy(dsDet.getInteger("oid_um_desp"), getSesion()));
				remitoDet.setMotivoDevolucion(MotivoRechazoCC.findByOidProxy(dsDet.getInteger("oid_motivo_devolucion"), getSesion()));
				remitoDet.setOCDetPorDevolucion(OrdenDeCompraDet.findByOidProxy(dsDet.getInteger("oid_oc_det"), getSesion()));
				
				remitoDet.setComentario(dsDet.getString("comentario"));
				remitoDet.setActivo(dsDet.getBoolean("activo"));
				remitoDet.setPedidoDet(PedidoDet.findByOidProxy(dsDet.getInteger("oid_ped_det"), getSesion()));
				remitoDet.setInformeControlCalidadDet(InformeControlCalidadDet.findByOidProxy(dsDet.getInteger("oid_cc_det"),getSesion()));
				remitoDet.setPedidoDepositoDet(PedMercDepoDet.findByOidProxy(dsDet.getInteger("oid_ped_depo_det"),getSesion()));

				remitocab.addDetalle(remitoDet);

				// Gragar Partidas y Series
				IDataSet dsPartidaSerie = dsDet.getDataSet("TPartidaSerieDet");
				dsPartidaSerie.first();
				while (!dsPartidaSerie.EOF()) {
					RemitoDetPartidaSerie remitoDetPartidaSerie = RemitoDetPartidaSerie.findByOid(dsPartidaSerie
							.getInteger("oid_partida_serie_det"), getSesion());
					remitoDetPartidaSerie.setRemito_detalle(remitoDet);
					remitoDetPartidaSerie.setPartida(Partida
							.findByOidProxy(dsPartidaSerie.getInteger("oid_partida"), getSesion()));
					remitoDetPartidaSerie.setSerie(Serie.findByOidProxy(dsPartidaSerie.getInteger("oid_serie"), getSesion()));
					remitoDetPartidaSerie.setCantidad(dsPartidaSerie.getDouble("cantidad"));
					remitoDetPartidaSerie.setActivo(new Boolean(true));
					remitoDet.addDetallePartidaSerie(remitoDetPartidaSerie);
					dsPartidaSerie.next();
				}

				// Grabar Movimientos Stock Detalles
				IDataSet dsDetMovStock = dsDet.getDataSet("TMovStkTalDet");
				dsDetMovStock.first();
				while (!dsDetMovStock.EOF()) {
					RemitoDetMovStock remitoDetMovStock = RemitoDetMovStock.findByOid(dsDetMovStock.getInteger("oid"),
							getSesion());
					remitoDetMovStock.setProducto(remitoDet.getProducto());
					remitoDetMovStock.setRemito_detalle(remitoDet);
					remitoDetMovStock.setDeposito(Deposito.findByOid(dsDetMovStock.getInteger("oid_deposito"), getSesion()));
					remitoDetMovStock.setTipo_mov(dsDetMovStock.getString("tipo_movi"));
					remitoDetMovStock.setEstado_stock(EstadoStock.findByOid(dsDetMovStock.getInteger("oid_estado_stock"),
							getSesion()));
					remitoDetMovStock.setUbicacion_deposito(UbicacionDeposito.findByOid(dsDetMovStock.getInteger("oid_ubi_depo"),
							getSesion()));
					remitoDetMovStock.setActivo(new Boolean(true));
					remitoDetMovStock.setAfectaStkFisico(dsDetMovStock.getBoolean("afecta_stk_fisico"));
					remitoDet.addDetalleMovStock(remitoDetMovStock);
					dsDetMovStock.next();
				}
				dsDet.next();
			}

			// Grabar los Movimientos de Stock Sugeridos
			IDataSet dsRtoCabMovStk = dataset.getDataSet("TMovStkTalCab");
			dsRtoCabMovStk.first();
			while (!dsRtoCabMovStk.EOF()) {
				RemitoCabMovStock rtoCabMovStk = RemitoCabMovStock.findByOid(dsRtoCabMovStk.getInteger("oid_rto_cab_stk"),
						getSesion());
				rtoCabMovStk.setRemito_cabecera(remitocab);
				rtoCabMovStk.setDeposito(Deposito.findByOidProxy(dsRtoCabMovStk.getInteger("oid_deposito"), getSesion()));
				rtoCabMovStk.setTipo_movi(dsRtoCabMovStk.getString("tipo_movi"));
				rtoCabMovStk.setEstado_stock(EstadoStock.findByOidProxy(dsRtoCabMovStk.getInteger("oid_estado_stock"),
						getSesion()));
				rtoCabMovStk.setUbicacion_deposito(UbicacionDeposito.findByOidProxy(dsRtoCabMovStk.getInteger("oid_ubi_depo"),
						getSesion()));
				rtoCabMovStk.setActivo(new Boolean(true));
				rtoCabMovStk.setAfectaStockFisico(dsRtoCabMovStk.getBoolean("afecta_stk_fisico"));
				remitocab.addDetMovStock(rtoCabMovStk);
				dsRtoCabMovStk.next();
			}

			addTransaccion(remitocab);
			dataset.next();
		}
	}

	protected void afterSave() throws BaseException {

		ComproCab informarCompro = null;
		
		if (remitocab == null) return;
		
		if (this.remitocab.getComprobanteAnulacion()!=null)
			informarCompro = this.remitocab.getComprobanteAnulacion();
		else
			informarCompro = remitocab;
		
		InformarComprobante infoCompro = 
			new InformarComprobante(informarCompro.getOIDInteger(), informarCompro.getDescripcion());

		writeCliente(infoCompro.getDataSetInfoCompro());

	}

}
