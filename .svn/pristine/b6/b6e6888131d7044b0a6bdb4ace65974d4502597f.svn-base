package com.srn.erp.compras.op;

import java.util.Iterator;

import com.srn.erp.compras.bm.ConsultaEstadoRequisiciones;
import com.srn.erp.compras.bm.RequisicionDet;
import com.srn.erp.compras.bm.SectorCompra;
import com.srn.erp.general.bm.ClasificadorEntidad;
import com.srn.erp.general.bm.ComproCab;
import com.srn.erp.general.bm.IValorClasificadorEntidad;
import com.srn.erp.general.bm.Sucursal;
import com.srn.erp.general.bm.Talonario;
import com.srn.erp.stock.bm.Producto;

import framework.applicarionServer.bl.Utils.Fecha;
import framework.applicarionServer.bm.Seguridad.Usuario;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerConsultaEstadoRequisiciones extends Operation {

	boolean usarClasifCompras = false;
	ClasificadorEntidad clasifGrupoCompras = null;
	String GRUPO_COMPRAS  = "Grupo Compras";
	HashTableDatos condiciones = new HashTableDatos();
	Usuario usuarioDefault = null;
	String nombreTabla = null;
	
	public TraerConsultaEstadoRequisiciones() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		cargarParametros(mapaDatos);
		traerConsultaEstadosRequisiciones();
	}

	public void traerConsultaEstadosRequisiciones() throws BaseException {

		usarClasifCompras = ConsultaEstadoRequisiciones.usaClasificadorComprasParaRequisicion(getSesion());
		clasifGrupoCompras = ConsultaEstadoRequisiciones.getClasifGrupoCompras(getSesion());
	
		if (usarClasifCompras == false)
			if (clasifGrupoCompras == null)
				throw new ExceptionValidation(null,"Falta definir el clasificador de Grupo de Compras para las requisiciones");
			
		IDataSet dataSetConsulta = getDataSetConsultaEstadoRequisiciones();
		Iterator iterConsEstReq = ConsultaEstadoRequisiciones.getEstadosRequisiciones(condiciones,getSesion()).iterator();
		while (iterConsEstReq.hasNext()) {
			ConsultaEstadoRequisiciones consEstReq = (ConsultaEstadoRequisiciones) iterConsEstReq.next();
			cargarRegistroConsultaEstadoRequisiciones(dataSetConsulta,consEstReq);
		} 
		
		
		writeCliente(dataSetConsulta);

	}
	
	private void cargarParametros(MapDatos mapaDatos) throws BaseException {
		
		usuarioDefault = Usuario.findByOidProxy(this.getSesion().getLogin().getUsuario().getOIDInteger(), this.getSesion());
		
		if (mapaDatos.containsKey("nombreTabla")) 
			nombreTabla = mapaDatos.getString("nombreTabla"); 
		
		if (mapaDatos.containsKey("oid_sucursal")) {
			Integer oidSucursal = mapaDatos.getInteger("oid_sucursal");
			Sucursal sucursal = Sucursal.findByOidProxy(oidSucursal,getSesion());
			condiciones.put(Sucursal.NICKNAME,sucursal);
		}
		if (mapaDatos.containsKey("oid_sector")) {
			Integer oidSector = mapaDatos.getInteger("oid_sector");
			SectorCompra sectorCompra = SectorCompra.findByOidProxy(oidSector,getSesion());
			condiciones.put(SectorCompra.NICKNAME,sectorCompra);
		}		
		if (mapaDatos.containsKey("oid_usuario")) {
			Integer oidUsuario = mapaDatos.getInteger("oid_usuario");
			Usuario usuario = Usuario.findByOidProxy(oidUsuario,getSesion());
			condiciones.put(Usuario.NICKNAME,usuario);
		}		
		if (mapaDatos.containsKey("fec_emi_desde")) {
			java.util.Date fecEmiDesde = mapaDatos.getDate("fec_emi_desde");
			condiciones.put("FEC_EMI_DESDE",fecEmiDesde);
		}
		if (mapaDatos.containsKey("fec_emi_hasta")) {
			java.util.Date fecEmiHasta = mapaDatos.getDate("fec_emi_hasta");
			condiciones.put("FEC_EMI_HASTA",fecEmiHasta);
		}
		if (mapaDatos.containsKey("fec_req_desde")) {
			java.util.Date fecEmiDesde = mapaDatos.getDate("fec_req_desde");
			condiciones.put("FEC_REQ_DESDE",fecEmiDesde);
		}
		if (mapaDatos.containsKey("fec_req_hasta")) {
			java.util.Date fecEmiHasta = mapaDatos.getDate("fec_req_hasta");
			condiciones.put("FEC_REQ_HASTA",fecEmiHasta);
		}
		if (mapaDatos.containsKey("oid_talonario")) {
			Integer oidTalonario = mapaDatos.getInteger("oid_talonario");
			Talonario talonario = Talonario.findByOidProxy(oidTalonario,getSesion());
			condiciones.put(Talonario.NICKNAME,talonario);
		}	
		if (mapaDatos.containsKey("nro_desde")) {
			Integer nro = mapaDatos.getInteger("nro_desde");
			condiciones.put("NRO_DESDE",nro);
		}	
		if (mapaDatos.containsKey("nro_hasta")) {
			Integer nro = mapaDatos.getInteger("nro_hasta");
			condiciones.put("NRO_HASTA",nro);
		}
		if (mapaDatos.containsKey("oid_producto")) {
			Integer oidProducto = mapaDatos.getInteger("oid_producto");
			Producto producto = Producto.findByOidProxy(oidProducto,getSesion());
			condiciones.put(Producto.NICKNAME,producto);
		}
		if (mapaDatos.containsKey("solo_pend_cotiz")) {
			Boolean soloPendCotiz = mapaDatos.getBoolean("solo_pend_cotiz");
			condiciones.put("SOLO_PEND_COTIZ",soloPendCotiz);
		}
		if (mapaDatos.containsKey("mis_pend_autoriz")) {
			Boolean misPendAutoriz = mapaDatos.getBoolean("mis_pend_autoriz");
			condiciones.put("MIS_PEND_AUTORIZ",misPendAutoriz);
		}		
		if (mapaDatos.containsKey("todos_los_pend_autoriz")) {
			Boolean todosLosPendAutoriz = mapaDatos.getBoolean("todos_los_pend_autoriz");
			condiciones.put("TODOS_PEND_AUTORIZ",todosLosPendAutoriz);
		}		
		if (mapaDatos.containsKey("solo_pend_compra")) {
			Boolean soloPendCompra = mapaDatos.getBoolean("solo_pend_compra");
			condiciones.put("SOLO_PEND_COMPRA",soloPendCompra);
		}
		
		if (mapaDatos.containsKey("oid_req_det")) {
			RequisicionDet requisicionDet = RequisicionDet.findByOidProxy(mapaDatos.getInteger("oid_req_det"), this.getSesion());
			condiciones.put(RequisicionDet.NICKNAME,requisicionDet);
		}		
		
	}

	
	private IDataSet getDataSetConsultaEstadoRequisiciones() {
		IDataSet dataset = new TDataSet();
		
		if (nombreTabla!=null)
			dataset.create(nombreTabla);
		else
			dataset.create("TConsEstadoRequisiciones");
		
		dataset.fieldDef(new Field("oid_req_det", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_cco_req", Field.INTEGER, 0));
		dataset.fieldDef(new Field("comprobante", Field.STRING, 50));
		dataset.fieldDef(new Field("oid_usuario", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_talonario", Field.INTEGER, 0));		
		dataset.fieldDef(new Field("oid_sucursal", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_sector", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_sector", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_producto", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_producto", Field.STRING, 50));
		dataset.fieldDef(new Field("desc_producto", Field.STRING, 100));
		dataset.fieldDef(new Field("desc_adic_sku", Field.STRING, 255));
		dataset.fieldDef(new Field("nro_renglon", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cant_solicitada", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("cant_comprada", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("cant_pend_compra", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("oid_um_req", Field.INTEGER, 0));
		dataset.fieldDef(new Field("fec_emision", Field.DATE, 0));
		dataset.fieldDef(new Field("fec_requerida", Field.DATE, 0));
		dataset.fieldDef(new Field("decision_autoriz", Field.INTEGER, 0));
		dataset.fieldDef(new Field("anulada", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("solo_cotizar", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("comentario_det", Field.STRING, 255));
		dataset.fieldDef(new Field("pend_sol_cotiz", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("comentario_requi", Field.STRING, 255));
		dataset.fieldDef(new Field("desc_grupo_compra", Field.STRING, 100));
		dataset.fieldDef(new Field("pend_compra", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("roles_autorizadores", Field.STRING, 1000));
		dataset.fieldDef(new Field("referencia", Field.STRING, 100));
		dataset.fieldDef(new Field("oid_proveedor", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_proveedor", Field.STRING, 50));
		dataset.fieldDef(new Field("rs_proveedor", Field.STRING, 100));
		dataset.fieldDef(new Field("read_only", Field.BOOLEAN, 0));
		return dataset;
	}

	private void cargarRegistroConsultaEstadoRequisiciones(IDataSet dataset,
			ConsultaEstadoRequisiciones consRequi) throws BaseException {
		
		dataset.append();
		dataset.fieldValue("oid_req_det", consRequi.getOid_req_det());
		dataset.fieldValue("oid_cco_req", consRequi.getOID());
		dataset.fieldValue("comprobante",ComproCab.getFormatoCompro(consRequi.getTc_ext(),consRequi.getLetra(),consRequi.getNro_lugar_emi(),consRequi.getNroExt()));
		dataset.fieldValue("oid_usuario", consRequi.getUsuario().getOIDInteger());
		dataset.fieldValue("oid_talonario",consRequi.getTalonario().getOIDInteger());
		dataset.fieldValue("oid_sucursal", consRequi.getSucursal().getOIDInteger());
		dataset.fieldValue("oid_sector", consRequi.getSectorCompra().getOIDInteger());
		dataset.fieldValue("oid_producto",consRequi.getProducto().getOIDInteger());
		dataset.fieldValue("cod_producto", consRequi.getCod_producto());
		dataset.fieldValue("desc_producto",consRequi.getDesc_producto());
		if (consRequi.getDesc_adic_sku()!=null)
			  dataset.fieldValue("desc_adic_sku", consRequi.getDesc_adic_sku());
			else
			  dataset.fieldValue("desc_adic_sku", "");
		dataset.fieldValue("nro_renglon", consRequi.getNro_renglon());
		dataset.fieldValue("cant_solicitada", consRequi.getCant_solicitada());
		dataset.fieldValue("cant_comprada", consRequi.getCant_comprada());
		dataset.fieldValue("cant_pend_compra",consRequi.getcantPendCompra());
		dataset.fieldValue("oid_um_req", consRequi.getUnidad_medida().getOIDInteger());
		dataset.fieldValue("fec_emision", Fecha.getddmmyyyy(consRequi.getFec_emision()));
		dataset.fieldValue("fec_requerida", Fecha.getddmmyyyy(consRequi.getFec_requerida()));
		dataset.fieldValue("decision_autoriz", consRequi.getDecision_autoriz());
		dataset.fieldValue("anulada", consRequi.isAnulada());
		dataset.fieldValue("solo_cotizar", consRequi.isSolo_cotizar());
		dataset.fieldValue("comentario_det", consRequi.getComen_detalle());
		dataset.fieldValue("pend_sol_cotiz", consRequi.isPend_sol_cotiz());
		dataset.fieldValue("comentario_requi", consRequi.getComen_requi());
		String descGrupoCompras = GRUPO_COMPRAS;
		if (usarClasifCompras) {
			IValorClasificadorEntidad valorClasif = consRequi.getProducto().getValorClasifEnt(clasifGrupoCompras);
			if (valorClasif!=null) descGrupoCompras = valorClasif.getDescripcion(); 
		}
		dataset.fieldValue("desc_grupo_compra", descGrupoCompras);
		dataset.fieldValue("pend_compra", consRequi.isPendCompra());
		
		// Mostrar los roles autorizantes
		RequisicionDet requiDet = RequisicionDet.findByOidProxy(consRequi.getOid_req_det(),getSesion());
		dataset.fieldValue("roles_autorizadores", requiDet.getRolesAutorizadores());
		
		dataset.fieldValue("referencia", requiDet.getReferencia());
		if (requiDet.getProveedor()!=null) {
			dataset.fieldValue("oid_proveedor", requiDet.getProveedor().getOIDInteger()); 
			dataset.fieldValue("cod_proveedor", requiDet.getProveedor().getCodigo());
			dataset.fieldValue("rs_proveedor", requiDet.getProveedor().getRazonsocial());
		} else {
			dataset.fieldValue("oid_proveedor", ""); 
			dataset.fieldValue("cod_proveedor", "");
			dataset.fieldValue("rs_proveedor", "");
		}
		
		
		dataset.fieldValue("read_only", true);
		/*
		if (requiDet.isRechazado()) {
			if (requiDet.isAutorizable(usuarioDefault))
				dataset.fieldValue("read_only", false);
			else
				dataset.fieldValue("read_only", true);
		}
		else if (requiDet.isAnulada())
			dataset.fieldValue("read_only", true);
		else if (requiDet.isAutorizado())
			dataset.fieldValue("read_only", false);
		else if (requiDet.isPendAutoriz() && requiDet.isAutorizable(usuarioDefault))
			dataset.fieldValue("read_only", false);
		else dataset.fieldValue("read_only", true);*/
		
		
	}
}
