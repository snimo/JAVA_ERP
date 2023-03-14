package com.srn.erp.compras.bm;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.compras.da.DBOrdenDeCompraCab;
import com.srn.erp.general.bm.ComproCab;
import com.srn.erp.general.bm.LugarEmision;
import com.srn.erp.general.bm.Moneda;
import com.srn.erp.general.bm.Talonario;
import com.srn.erp.general.bm.TipoComprobante;

import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.Fecha;
import framework.applicarionServer.bm.Parametros.ValorParametro;
import framework.applicarionServer.bm.Seguridad.Usuario;
import framework.applicarionServer.bm.Varios.CalculadorMoney;
import framework.applicarionServer.bm.Varios.Money;
import framework.applicarionServer.bm.Varios.NumeroBase;
import framework.applicarionServer.bm.Varios.Porcentaje;
import framework.applicarionServer.bm.Varios.ValorCotizacion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.Validar;

public class OrdenDeCompraCab extends ComproCab {
	
	public static String	MOT_AUT_MONTO				= "MONTO_OC";
	public static String  MOT_AUT_COND_PAGO   = "COND_PAGO"; 
	
	public static String	DESC_MOT_AUT_MONTO	= "Monto";
	public static String  DESC_MOT_COND_PAGO  = "Condición de Pago";
	
	public static String TIPO_OC_MANUAL = "MANUAL";
	public static String TIPO_OC_AUTO = "AUTO";
	

	public void afterSaveNew() throws BaseException {
		// TODO Auto-generated method stub
		super.afterSaveNew();

		// Cuando se grava la Orden de Compra Verificar los requerimientos de autorizacion
	}

	public void refreshDetOC() throws BaseException {
		this.readDetallesOC = true;
		this.detallesOC.clear();
	}

	public void refreshAutorizOC() throws BaseException {
		this.readDetallesAutoriz = true;
		this.detallesAutoriz.clear();
	}

	private void analizarAutorizacionOC() throws BaseException {

		refreshDetOC();

		boolean hayAutorizPendAprob = false;
		
		if (OrdenDeCompraCab.isControlaAutorizProdEnOC(this.getSesion()))  {
		
		EsquemaAutorizCompras esquemaAutoriz = OrdenDeCompraCab.getEsquemaAutorizCompras(this.getSesion());
		if (esquemaAutoriz == null)
			throw new ExceptionValidation(null, "No se encuentra parametrizado el esquema de configuración de compras");
		Collection rolesAutorizOC = esquemaAutoriz.getRolesAutorizMontoOC(this);
		
		if (rolesAutorizOC.size() == 0)
			throw new ExceptionValidation(null, "No se pudo determinar los roles autorizantes de la Orden de Compra ");

		// Se eliminar todas los puntos pendientes de decision
		Iterator iterAutorizYaCargadas = this.getAutorizacionesOC().iterator();
		while (iterAutorizYaCargadas.hasNext()) {
			AutorizacionOC autorizacionOC = (AutorizacionOC) (iterAutorizYaCargadas.next());
			if (autorizacionOC.getDecision_autoriz().intValue() == OrdenDeCompraCab.PEND_AUTORIZ) {
				autorizacionOC.delete();
				autorizacionOC.save();
			}
		}

		// Se regeneran los roles autorizadores por decision de autorizacion por monto
		boolean autorizSuficiente = false;
		Iterator iterRolesAutoriz = rolesAutorizOC.iterator();
		while (iterRolesAutoriz.hasNext()) {
			RolAutorizadorOC rolAutorizadorOC = (RolAutorizadorOC) iterRolesAutoriz.next();
			
			Usuario usuario = Usuario.findByOidProxy(this.getSesion().getLogin().getUsuario().getOID(),this.getSesion());
			if (rolAutorizadorOC.getRol_autorizador().tieneElRol(usuario)) {
				if (rolAutorizadorOC.getTipo_autoriz().equals(AutorizadorRequisicion.TIPO_AUTORIZ_SUFICIENTE)) {
					autorizSuficiente = true;
					break;
				}
					
			}
			
		}
		

		if (!autorizSuficiente) {
			// Si no es autorizacion suficiente entonces
			iterRolesAutoriz = rolesAutorizOC.iterator();
			while (iterRolesAutoriz.hasNext()) {
				RolAutorizadorOC rolAutorizadorOC = (RolAutorizadorOC) iterRolesAutoriz.next();
				
				Usuario usuario = Usuario.findByOidProxy(this.getSesion().getLogin().getUsuario().getOID(),this.getSesion());
				if (!rolAutorizadorOC.getRol_autorizador().tieneElRol(usuario)) {
					AutorizacionOC autorizacionOC = (AutorizacionOC) AutorizacionOC.getNew(AutorizacionOC.NICKNAME, this.getSesion());
					autorizacionOC.setOrden_de_compra(this);
					autorizacionOC.setDecision_autoriz(new Integer(OrdenDeCompraCab.PEND_AUTORIZ));
					autorizacionOC.setComentario("");
					autorizacionOC.setDesc_motivo(DESC_MOT_AUT_MONTO);
					autorizacionOC.setTipo_motivo(MOT_AUT_MONTO);
					autorizacionOC.setActivo(new Boolean(true));
					autorizacionOC.setRol_autorizador(rolAutorizadorOC.getRol_autorizador());
					autorizacionOC.setFec_alta(Fecha.getFechaActual());
					autorizacionOC.save();
					
					hayAutorizPendAprob = true;
				}
				
			}
			
		}
		}
		
		// Se genera el rol por autorizacion de condicion de pago

		if (OrdenDeCompraCab.isControlaAutorizCondPagoEnOC(this.getSesion())) {
		if (!this.getProveedor().isCondPagoAsignada(this.getCond_pago_1())) {
			// Grabar los motivos de decision
			AutorizacionOC autorizacionOC = (AutorizacionOC) AutorizacionOC.getNew(AutorizacionOC.NICKNAME, this.getSesion());
			autorizacionOC.setOrden_de_compra(this);
			autorizacionOC.setDecision_autoriz(new Integer(OrdenDeCompraCab.PEND_AUTORIZ));
			autorizacionOC.setComentario("");
			autorizacionOC.setDesc_motivo(OrdenDeCompraCab.DESC_MOT_COND_PAGO);
			autorizacionOC.setTipo_motivo(OrdenDeCompraCab.MOT_AUT_COND_PAGO);
			autorizacionOC.setActivo(new Boolean(true));
			autorizacionOC.setRol_autorizador(OrdenDeCompraCab.getRolAutorizCondPago(this.getSesion()));
			autorizacionOC.setFec_alta(Fecha.getFechaActual());
			autorizacionOC.save();
			
			hayAutorizPendAprob = true;
			
		}
		}
		
		if (hayAutorizPendAprob) 
			this.fijarEstadoDeAutorizacion(new Integer(OrdenDeCompraCab.PEND_AUTORIZ),Fecha.getFechaActual());
		 else 
			 this.fijarEstadoDeAutorizacion(new Integer(OrdenDeCompraCab.AUTORIZADA),Fecha.getFechaActual());
		
		

	}

	public OrdenDeCompraCab() {
	}

	private ComproCab							comprobante;

	private List									detallesOC					= new ArrayList();

	private boolean								readDetallesOC			= true;

	private List									detallesAutoriz			= new ArrayList();

	private boolean								readDetallesAutoriz	= true;

	public static final int				PEND_AUTORIZ				= 0;

	public static final int				AUTORIZADA					= 1;

	public static final int				RECHAZADA						= 2;

	public static String					NICKNAME						= "cp.OrdenDeCompraCab";

	private Proveedor							proveedor;

	private Boolean								importacion;

	private Boolean								enviada;

	private java.util.Date				fecha_envio;

	private Boolean								confirmo_recepcion;

	private java.util.Date				fecha_confirmo_recepcion;

	private ViaDespacho						viaDespacho;

	private CondCompraImportacion	cond_compra_importacion;

	private java.util.Date				fec_estado_autorizacion;

	private CondicionCompra				cond_pago_2;

	private CondicionCompra				cond_pago_1;

	private Double								dto_1_1;

	private Double								dto_1_2;

	private Double								dto_1_3;

	private String								observaciones_generales;

	private Double								dto_2_1;

	private Double								dto_2_2;

	private Double								dto_2_3;

	private Integer								estado_autorizacion;

	private Moneda								moneda;

	private Boolean								abierta;

	private String								tipo;

	private String								tomar_precio_de;

	private Boolean								dtoEnCascada;

	private Porcentaje						porcRecargo;

	public static final String		OC_PEND_EXT					= "OC_PEND_ENT";

	public static final String		TODAS_LAS_OS				= "TODAS";

	private ValorCotizacion				cotizacion;

	private SectorCompra					sectorCompra;
	
	private LugarEntrega 					lugarEntrega;
	
	private Boolean agrupaItemsImpre;
	
	public LugarEntrega getLugarEntrega() throws BaseException {
		supportRefresh();
		return this.lugarEntrega;
	}
	
	public void setLugarEntrega(LugarEntrega aLugarEntrega) throws BaseException {
		this.lugarEntrega = aLugarEntrega;
	}

	public ComproCab getComprobante() throws BaseException {
		return this.comprobante;
	}

	public Proveedor getProveedor() throws BaseException {
		supportRefresh();
		return proveedor;
	}

	public ValorCotizacion getCotizacion() throws BaseException {
		supportRefresh();
		return this.cotizacion;
	}

	public void setCotizacion(ValorCotizacion aCotizacion) throws BaseException {
		supportRefresh();
		cotizacion = aCotizacion;
	}

	public SectorCompra getSectorCompra() throws BaseException {
		supportRefresh();
		return this.sectorCompra;
	}
	
	public void setAgrupaItemsImpresion(Boolean aAgrupaItemsImpresion) throws BaseException {
		supportRefresh();
		this.agrupaItemsImpre = aAgrupaItemsImpresion;
	}

	public Boolean isAgrupaItemsImpresion() throws BaseException {
		supportRefresh();
		return this.agrupaItemsImpre;
	}
	

	public void setSectorCompra(SectorCompra aSectorCompra) throws BaseException {
		supportRefresh();
		sectorCompra = aSectorCompra;
	}

	public void setDtoEnCasacada(Boolean aDtoEnCascada) throws BaseException {
		this.dtoEnCascada = aDtoEnCascada;
	}

	public Boolean isDtoEnCascada() throws BaseException {
		supportRefresh();
		return this.dtoEnCascada;
	}

	public Porcentaje getPorcRecargo() throws BaseException {
		return this.porcRecargo;
	}

	public void setPorcRecargo(Porcentaje aPorcRecargo) {
		this.porcRecargo = aPorcRecargo;
	}

	public void setProveedor(Proveedor aProveedor) {
		this.proveedor = aProveedor;
	}

	public Boolean isImportacion() throws BaseException {
		supportRefresh();
		return importacion;
	}

	public void setImportacion(Boolean aImportacion) {
		this.importacion = aImportacion;
	}

	public Boolean isEnviada() throws BaseException {
		supportRefresh();
		return enviada;
	}

	public void setEnviada(Boolean aEnviada) {
		this.enviada = aEnviada;
	}

	public java.util.Date getFecha_envio() throws BaseException {
		supportRefresh();
		return fecha_envio;
	}

	public void setFecha_envio(java.util.Date aFecha_envio) {
		this.fecha_envio = aFecha_envio;
	}

	public Boolean isConfirmo_recepcion() throws BaseException {
		supportRefresh();
		return confirmo_recepcion;
	}

	public void setConfirmo_recepcion(Boolean aConfirmo_recepcion) {
		this.confirmo_recepcion = aConfirmo_recepcion;
	}

	public java.util.Date getFecha_confirmo_recepcion() throws BaseException {
		supportRefresh();
		return fecha_confirmo_recepcion;
	}

	public void setFecha_confirmo_recepcion(java.util.Date aFecha_confirmo_recepcion) {
		this.fecha_confirmo_recepcion = aFecha_confirmo_recepcion;
	}

	public ViaDespacho getVia_despacho() throws BaseException {
		supportRefresh();
		return viaDespacho;
	}

	public void setVia_despacho(ViaDespacho aViaDespacho) {
		this.viaDespacho = aViaDespacho;
	}

	public CondCompraImportacion getCond_compra_importacion() throws BaseException {
		supportRefresh();
		return cond_compra_importacion;
	}

	public void setCond_compra_importacion(CondCompraImportacion aCond_compra_importacion) {
		this.cond_compra_importacion = aCond_compra_importacion;
	}

	public java.util.Date getFec_estado_autorizacion() throws BaseException {
		supportRefresh();
		return fec_estado_autorizacion;
	}

	public void setFec_estado_autorizacion(java.util.Date aFec_estado_autorizacion) {
		this.fec_estado_autorizacion = aFec_estado_autorizacion;
	}

	public CondicionCompra getCond_pago_2() throws BaseException {
		supportRefresh();
		return cond_pago_2;
	}

	public void setCond_pago_2(CondicionCompra aCond_pago_2) {
		this.cond_pago_2 = aCond_pago_2;
	}

	public CondicionCompra getCond_pago_1() throws BaseException {
		supportRefresh();
		return cond_pago_1;
	}

	public void setCond_pago_1(CondicionCompra aCond_pago_1) {
		this.cond_pago_1 = aCond_pago_1;
	}

	public String getObservaciones_generales() throws BaseException {
		supportRefresh();
		return observaciones_generales;
	}

	public void setObservaciones_generales(String aObservaciones_generales) {
		this.observaciones_generales = aObservaciones_generales;
	}

	public Integer getEstado_autorizacion() throws BaseException {
		supportRefresh();
		return estado_autorizacion;
	}

	public void setEstado_autorizacion(Integer aEstado_autorizacion) {
		this.estado_autorizacion = aEstado_autorizacion;
	}

	public Moneda getMoneda() throws BaseException {
		supportRefresh();
		return moneda;
	}

	public void setMoneda(Moneda aMoneda) {
		this.moneda = aMoneda;
	}

	public Boolean isAbierta() throws BaseException {
		supportRefresh();
		return abierta;
	}

	public void setAbierta(Boolean aAbierta) {
		this.abierta = aAbierta;
	}

	public String getTipo() throws BaseException {
		supportRefresh();
		return tipo;
	}

	public void setTipo(String aTipo) {
		this.tipo = aTipo;
	}

	public String getTomar_precio_de() throws BaseException {
		supportRefresh();
		return tomar_precio_de;
	}

	public void setTomar_precio_de(String aTomar_precio_de) {
		this.tomar_precio_de = aTomar_precio_de;
	}

	public String getNickName() {
		return NICKNAME;
	}

	public static OrdenDeCompraCab findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (OrdenDeCompraCab) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static OrdenDeCompraCab findByOidProxy(Integer oid, ISesion aSesion) throws BaseException {
		return (OrdenDeCompraCab) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}

	public void beforeSave() throws BaseException {

		Validar.noNulo(proveedor, "Debe ingresar el Proveedor");
		Validar.noNulo(importacion, "Debe ingresar si es una Importación");
		Validar.noNulo(enviada, "Debe ingresar si fue enviada");
		Validar.noNulo(confirmo_recepcion, "Debe ingresar si se confirmo la Recepción");
		Validar.noNulo(cond_pago_1, "Debe ingresar la condición de Pago");
		Validar.noNulo(moneda, "Debe ingresar la Moneda");
		Validar.noNulo(tipo, "Debe ingresar el Tipo de O.C.");
		Validar.noNulo(sectorCompra, "Debe ingresar el sector Compra");

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

	protected void onNew() throws BaseException {
		// TODO Auto-generated method stub
		super.onNew();
		importacion = new Boolean(false);
		enviada = new Boolean(false);
		fecha_envio = null;
		confirmo_recepcion = new Boolean(false);
		fecha_confirmo_recepcion = null;
		abierta = new Boolean(false);
		estado_autorizacion = new Integer(OrdenDeCompraCab.PEND_AUTORIZ);
	}

	public Double getDto_1_1() throws BaseException {
		supportRefresh();
		return dto_1_1;
	}

	public void setDto_1_1(Double dto_1_1) {
		this.dto_1_1 = dto_1_1;
	}

	public Double getDto_1_2() throws BaseException {
		supportRefresh();
		return dto_1_2;
	}

	public void setDto_1_2(Double dto_1_2) {
		this.dto_1_2 = dto_1_2;
	}

	public Double getDto_1_3() throws BaseException {
		supportRefresh();
		return dto_1_3;
	}

	public void setDto_1_3(Double dto_1_3) {
		this.dto_1_3 = dto_1_3;
	}

	public Double getDto_2_1() throws BaseException {
		supportRefresh();
		return dto_2_1;
	}

	public void setDto_2_1(Double dto_2_1) {
		this.dto_2_1 = dto_2_1;
	}

	public Double getDto_2_2() throws BaseException {
		supportRefresh();
		return dto_2_2;
	}

	public void setDto_2_2(Double dto_2_2) {
		this.dto_2_2 = dto_2_2;
	}

	public Double getDto_2_3() throws BaseException {
		supportRefresh();
		return dto_2_3;
	}

	public void setDto_2_3(Double dto_2_3) {
		this.dto_2_3 = dto_2_3;
	}

	public List getDetallesOC() throws BaseException {
		if (readDetallesOC) {
			List listaDetallesOC = OrdenDeCompraDet.getDetallesOC(this, getSesion());
			detallesOC.addAll(listaDetallesOC);
			readDetallesOC = false;
		}
		return detallesOC;
	}

	public List getDetallesAutorizacionOC() throws BaseException {
		if (this.readDetallesAutoriz) {
			List detallesAutorizacion = AutorizacionOC.getAutorizacionesOC(this, getSesion());
			this.detallesAutoriz.addAll(detallesAutorizacion);
			readDetallesAutoriz = false;
		}
		return detallesAutoriz;
	}

	public void addDetalleOC(OrdenDeCompraDet ordenDeCompraDet) throws BaseException {
		ordenDeCompraDet.setOrden_de_compra(this);
		detallesOC.add(ordenDeCompraDet);
	}

	public void afterSave() throws BaseException {
		Iterator iterOrdeneDeCompraDet = detallesOC.iterator();
		while (iterOrdeneDeCompraDet.hasNext()) {
			OrdenDeCompraDet ordenDeCompraDet = (OrdenDeCompraDet) iterOrdeneDeCompraDet.next();
			ordenDeCompraDet.save();
			ordenDeCompraDet = null;
		}
		iterOrdeneDeCompraDet = null;
		
		
		analizarAutorizacionOC();

	}

	public static List getOrdenDeCompraCab(HashTableDatos aCondiciones, ISesion aSesion) throws BaseException {
		return DBOrdenDeCompraCab.getOrdenDeCompraCab(aCondiciones, aSesion);
	}

	public static HashTableDatos getFiltros() throws BaseException {
		HashTableDatos filtros = new HashTableDatos();
		filtros.put(OC_PEND_EXT, "Pendientes de Recepción");
		filtros.put(TODAS_LAS_OS, "Todas");
		return filtros;
	}

	public static HashTableDatos getFiltrosAutoriz() throws BaseException {
		HashTableDatos filtros = new HashTableDatos();
		filtros.put("MIS_PEND_AUT", "Mi pendientes de Autotización");
		filtros.put("TODOS_PEND_AUT", "Todos los Pend. de Autotización");
		filtros.put("TODOS", "Todos");
		return filtros;
	}

	public static HashTableDatos getEstadosAutorizacion() throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put(new Integer(PEND_AUTORIZ), "Pendiente");
		condiciones.put(new Integer(AUTORIZADA), "Autorizada");
		condiciones.put(new Integer(RECHAZADA), "Rechazada");
		return condiciones;
	}
	
	public String getDescEstadoAutoriz() throws BaseException {
		HashTableDatos  estados = getEstadosAutorizacion();
		String desc = (String) estados.get(getEstado_autorizacion());
		if (desc == null)
			return "";
		else
			return desc;
	}

	public static OrdenDeCompraCab getOrdeDeCompra(String identificador, ISesion aSesion) throws BaseException {
		ComproCab comproCab = ComproCab.getComproCab(identificador, aSesion);
		if (comproCab == null)
			throw new ExceptionValidation(null, "Orden de Compra inexistente");
		OrdenDeCompraCab oc = OrdenDeCompraCab.findByOid(comproCab.getOIDInteger(), aSesion);
		if (oc == null)
			throw new ExceptionValidation(null, "Orden de Compra inexistente");
		return oc;
	}
	
	public boolean isPendienteDeRecepcion() throws BaseException {
		
		boolean pendiente = false;
		
		if (this.isActivo().booleanValue()==false) return false;
		
		Iterator iterDetalles = this.getDetallesOC().iterator();
		while (iterDetalles.hasNext()) {
			OrdenDeCompraDet ocDet = (OrdenDeCompraDet) iterDetalles.next();
			if (ocDet.isAnulado().booleanValue()) continue;
			if (ocDet.isPendienteRecepcion().booleanValue())
				if (ocDet.getCantPendRecepUC().doubleValue()>0)
					return true;
		}
		
		return pendiente;
	}
	
	public static List getOrdenesDeCompraPendRecep(Proveedor proveedor,String tc,String letra,Integer lugEmi,String identificador, ISesion aSesion) throws BaseException {

		List comprobantes = ComproCab.getComprobantes(tc,letra,lugEmi,identificador, aSesion);
		List ordenesDeCompra = new ArrayList(); 
		
		// Validar que los comprobantes sean O.C.
		Iterator iterCompro = comprobantes.iterator();
		while (iterCompro.hasNext()) {
			ComproCab compro = (ComproCab) iterCompro.next();
			
			if (!compro.getTipoCompro().esOrdenDeCompra())
				throw new ExceptionValidation(null,"Comprobante Inexistente:"+compro.getCodigo());
			
			if (!compro.isActivo().booleanValue())
				throw new ExceptionValidation(null,"La O.C. "+compro.getCodigo()+" se encuentra anulada.");
			
			// Instanciar la O.C.
			OrdenDeCompraCab oc = (OrdenDeCompraCab)OrdenDeCompraCab.findByOid(compro.getOIDInteger(),aSesion);
			
			// La Orden de Compra se encuentra deshabilitada
			if (oc.isActivo().booleanValue()==false)
				throw new ExceptionValidation(null,"La Orden de Compra "+oc.getCodigo()+" se encuentra deshabilitada.");
			
			if (!oc.isPendienteDeRecepcion())
				throw new ExceptionValidation(null,"La Orden de Compra "+oc.getCodigo()+" NO se encuentra pendiente de recepción de productos.  ");
			
			if (proveedor!=null)
				if (oc.getProveedor().getOID() != proveedor.getOID())
					throw new ExceptionValidation(null,
							"La O.C. "+
							oc.getCodigo()+
							" no corresponde al proveedor "+
							proveedor.getCodigo()+
							"-"+
							proveedor.getRazonsocial());
			
			ordenesDeCompra.add(oc);
			
		}
		
		return ordenesDeCompra;
	}
	

	public void anular() throws BaseException {
		Iterator iterDetOC = getDetallesOC().iterator();
		while (iterDetOC.hasNext()) {
			OrdenDeCompraDet ocDet = (OrdenDeCompraDet) iterDetOC.next();
			ocDet.delete();
			ocDet.save();
		}
	}

	public List getLugaresEntrega() throws BaseException {
		ArrayList lugares = new ArrayList();
		Iterator iterDetOC = this.getDetallesOC().iterator();
		while (iterDetOC.hasNext()) {
			OrdenDeCompraDet ocDet = (OrdenDeCompraDet) iterDetOC.next();
			if (!ocDet.isActivo().booleanValue())
				continue;
			/*Iterator iterEntregas = ocDet.getEntregas().iterator();
			while (iterEntregas.hasNext()) {
				OrdenDeCompraEnt ocEnt = (OrdenDeCompraEnt) iterEntregas.next();
				if (!ocEnt.isActivo().booleanValue())
					continue;
				if (!existeEnLista(lugares, ocEnt.getLugar_entrega()))
					lugares.add(ocEnt.getLugar_entrega());
			}*/
		}
		return lugares;
	}

	private boolean existeEnLista(List listaLugaresEnt, LugarEntrega lugarEntrega) throws BaseException {
		Iterator iterLugaresent = listaLugaresEnt.iterator();
		while (iterLugaresent.hasNext()) {
			LugarEntrega lugarEntregaLista = (LugarEntrega) iterLugaresent.next();
			if (lugarEntregaLista.getOID() == lugarEntrega.getOID()) {
				return true;
			}
		}
		return false;
	}

	public List getDetallesOC(LugarEntrega lugarEntrega) throws BaseException {
		return OrdenDeCompraDet.getDetallesOC(this, lugarEntrega, getSesion());
	}

	public static EsquemaAutorizCompras getEsquemaAutorizCompras(ISesion aSesion) throws BaseException {
		ValorParametro valorParametro = ValorParametro.findByCodigoParametro("ESQUEMA_AUTORIZ_CPRAS", aSesion);
		EsquemaAutorizCompras esquemaAutorizCompras = EsquemaAutorizCompras.findByOid(valorParametro.getOidObjNeg(),
				aSesion);
		return esquemaAutorizCompras;
	}

	public List getAutorizacionesOC() throws BaseException {
		return AutorizacionOC.getAutorizacionesOC(this, this.getSesion());
	}

	public String getAutorizadoresOC() throws BaseException {
		StringBuffer rolesAutorizadores = new StringBuffer("");
		Iterator iterAutorizacionesOC = getAutorizacionesOC().iterator();
		while (iterAutorizacionesOC.hasNext()) {
			AutorizacionOC autorizacionOC = (AutorizacionOC) iterAutorizacionesOC.next();
			rolesAutorizadores.append(autorizacionOC.getRolAutorizador());
		}
		return rolesAutorizadores.toString();

	}
	
	public String getRolesOCPendAut() throws BaseException {
		StringBuffer rolesAutorizadores = new StringBuffer("");
		Iterator iterAutorizacionesOC = getAutorizacionesOC().iterator();
		while (iterAutorizacionesOC.hasNext()) {
			AutorizacionOC autorizacionOC = (AutorizacionOC) iterAutorizacionesOC.next();
			if (autorizacionOC.getDecision_autoriz().intValue() == PEND_AUTORIZ)
				rolesAutorizadores.append(autorizacionOC.getRolAutorizador());
		}
		return rolesAutorizadores.toString();

	}
	

	public void realizarAutorizacionesOC() throws BaseException {

		if (this.getEstado_autorizacion().intValue() != OrdenDeCompraCab.PEND_AUTORIZ)
			return;

		if (!this.isActivo().booleanValue())
			return;

		Integer oidUsuario = this.getSesion().getLogin().getUsuario().getOIDInteger();
		Usuario usuario = (Usuario) Usuario.findByOidProxy(oidUsuario, getSesion());

		refreshAutorizOC();

		Iterator iterDetAutorizOC = this.getDetallesAutorizacionOC().iterator();
		while (iterDetAutorizOC.hasNext()) {
			AutorizacionOC autorizOC = (AutorizacionOC) iterDetAutorizOC.next();
			if (autorizOC.getRol_autorizador().tieneElRol(usuario)) {
				autorizOC.setUsuario(usuario);
				autorizOC.setFec_dec_autoriz(Fecha.getFechaActual());
				autorizOC.setDecision_autoriz(new Integer(OrdenDeCompraCab.AUTORIZADA));
				autorizOC.save();
			}
		}

		// Verificar si Existen detalles sin autorizar con la marca que sea suficiente
		refreshAutorizOC();

		boolean hayUnPendAutoriz = false;
		Iterator iterDetAutoriz = this.getDetallesAutorizacionOC().iterator();
		while (iterDetAutoriz.hasNext()) {
			AutorizacionOC autorizOC = (AutorizacionOC) iterDetAutoriz.next();
			if ((autorizOC.isActivo().booleanValue())
					&& (autorizOC.getDecision_autoriz().intValue() == OrdenDeCompraCab.PEND_AUTORIZ)) {
				hayUnPendAutoriz = true;
				break;
			}
		}

		if (!hayUnPendAutoriz) {
			// Si se encuentran todos los items actualizados autorizar la cabecera
			this.setEstado_autorizacion(new Integer(OrdenDeCompraCab.AUTORIZADA));
			this.setFec_estado_autorizacion(Fecha.getFechaActual());
			this.save();
		}

	}
	
	public boolean isAutorizada() throws BaseException {
		if (this.getEstado_autorizacion().intValue() == OrdenDeCompraCab.AUTORIZADA)
			return true;
		else
			return false;
	}
	
	public boolean isPendAutorizar() throws BaseException {
		if (this.getEstado_autorizacion().intValue() == OrdenDeCompraCab.PEND_AUTORIZ)
			return true;
		else
			return false;
	}
	
	public boolean isRechazada() throws BaseException {
		if (this.getEstado_autorizacion().intValue() == OrdenDeCompraCab.RECHAZADA)
			return true;
		else
			return false;
	}
	
	public String getLeyendaImpresionEstadoAutoriz() throws BaseException {
		if (!this.isActivo())
			return "ANULADA";
		else if (this.isRechazada())
				return "RECHAZADA";
		else if (this.isPendAutorizar())
			return "PENDIENTE DE AUTORIZACION";
		else
			return "";
	}
	
	

	public void rechazarAutorizacionesOC() throws BaseException {

		if (this.getEstado_autorizacion().intValue() != OrdenDeCompraCab.PEND_AUTORIZ)
			return;

		if (!this.isActivo().booleanValue())
			return;

		Integer oidUsuario = this.getSesion().getLogin().getUsuario().getOIDInteger();
		Usuario usuario = (Usuario) Usuario.findByOidProxy(oidUsuario, getSesion());

		refreshAutorizOC();

		boolean huboRechazo = false;
		Iterator iterDetAutorizOC = this.getDetallesAutorizacionOC().iterator();
		while (iterDetAutorizOC.hasNext()) {
			AutorizacionOC autorizOC = (AutorizacionOC) iterDetAutorizOC.next();
			if (autorizOC.getRol_autorizador().tieneElRol(usuario)) {
				autorizOC.setUsuario(usuario);
				autorizOC.setFec_dec_autoriz(Fecha.getFechaActual());
				autorizOC.setDecision_autoriz(new Integer(OrdenDeCompraCab.RECHAZADA));
				autorizOC.save();
				huboRechazo = true;
			}
		}

		// Hubo algun rechazado
		if (huboRechazo) {
			this.setEstado_autorizacion(new Integer(OrdenDeCompraCab.RECHAZADA));
			this.setFec_estado_autorizacion(Fecha.getFechaActual());
			this.save();
		}

	}

	public Money getTotMontoOC() throws BaseException {
		CalculadorMoney totOC = new CalculadorMoney(new NumeroBase(0));
		Iterator iterOrdenesDeCompraDet = this.getDetallesOC().iterator();
		while (iterOrdenesDeCompraDet.hasNext()) {
			OrdenDeCompraDet ocDet = (OrdenDeCompraDet) iterOrdenesDeCompraDet.next();
			totOC.sumar(new Money(ocDet.getTotal().doubleValue()));
		}
		return totOC.getResultMoney();
	}
	
	public static RolAutorizadorCompras getRolAutorizCondPago(ISesion aSesion) throws BaseException {
		ValorParametro valorParametro = ValorParametro.findByCodigoParametro("ROL_AUTORIZ_COND_PAGO_PROV", aSesion);
		RolAutorizadorCompras rolAutorizadorCompras = RolAutorizadorCompras.findByOid(valorParametro.getOidObjNeg(),
				aSesion);
		return rolAutorizadorCompras;
	}
	
	public static HashTableDatos getTiposOC() throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put(TIPO_OC_MANUAL,"1-Manual");
		condiciones.put(TIPO_OC_AUTO,"2-Automótica");
		return condiciones;
	}
	
	public static HashTableDatos getEtiquetasImpresion() throws BaseException {
		HashTableDatos etiquetas = new HashTableDatos();
		etiquetas.put("SYS_LABEL_LINEA_1","Linea Nro. 1");
		etiquetas.put("SYS_LABEL_LINEA_2","Linea Nro. 2");
		etiquetas.put("SYS_LABEL_LINEA_3","Linea Nro. 3");
		etiquetas.put("SYS_LABEL_LINEA_4","Linea Nro. 4");
		etiquetas.put("SYS_LABEL_LINEA_5","Linea Nro. 5");
		etiquetas.put("SYS_LABEL_LINEA_6","Linea Nro. 6");
		etiquetas.put("SYS_LABEL_LINEA_7","Linea Nro. 7");
		etiquetas.put("SYS_LABEL_LINEA_8","Linea Nro. 8");
		etiquetas.put("SYS_LABEL_LINEA_9","Linea Nro. 9");
		etiquetas.put("SYS_LABEL_LINEA_10","Linea Nro. 10");
		etiquetas.put("SYS_LABEL_FECHA","Fecha O.C.");
		etiquetas.put("SYS_LABEL_ORDEN_COMPRA","ORDEN DE COMPRA");
		etiquetas.put("SYS_LABEL_COTIZACION","Cotización");
		etiquetas.put("SYS_LABEL_MONEDA","Moneda");
		etiquetas.put("SYS_LABEL_COND_PAGO","Condición Pago");
		etiquetas.put("SYS_LABEL_VIA_DESPACHO","Vía de despacho");
		etiquetas.put("SYS_LABEL_COND_VTA","Condición de Venta");
		etiquetas.put("SYS_LABEL_COND_COMPRA","Condición de Compra");
		etiquetas.put("SYS_LABEL_LUGAR_ENTREGA","Lugar de Entrega");
		etiquetas.put("SYS_LABEL_PROVEEDOR","Proveedor");
		etiquetas.put("SYS_LABEL_PARA","Para");
		etiquetas.put("SYS_LABEL_COD_PRODUCTO","Código Producto");
		etiquetas.put("SYS_LABEL_DESC_PRODUCTO","Descripción Producto");
		etiquetas.put("SYS_LABEL_FEC_REQ","Fecha Requerida");
		etiquetas.put("SYS_LABEL_UM","Unidad de Medida");
		etiquetas.put("SYS_LABEL_CANTIDAD","Cantidad");
		etiquetas.put("SYS_LABEL_PRECIO","Precio");
		etiquetas.put("SYS_LABEL_TOTAL","Total Item");
		etiquetas.put("SYS_LABEL_OBS_OC","Observación Orden de Compra");
		etiquetas.put("SYS_LABEL_TOTAL_OC","Total O.C.");
		return etiquetas;
	}
	
	public static String getLetraDefaultBusqueda(ISesion aSesion) throws BaseException {
		ValorParametro valorParametro = ValorParametro.findByCodigoParametro("LETRA_DEF_BUSC_OC", aSesion);
		return valorParametro.getValorCadena();
	}
	
	public static LugarEmision getLugEmiDefaultBusqueda(ISesion aSesion) throws BaseException {
		ValorParametro valorParametro = ValorParametro.findByCodigoParametro("LUG_EMI_DEF_BUSC_OC", aSesion);
		LugarEmision lugarEmision = LugarEmision.findByOidProxy(valorParametro.getOidObjNeg(), aSesion);
		return lugarEmision;
	}
	
	public static TipoComprobante getTCDefaultBusqueda(ISesion aSesion) throws BaseException {
		ValorParametro valorParametro = ValorParametro.findByCodigoParametro("TC_DEF_BUSC_OC", aSesion);
		TipoComprobante tc = TipoComprobante.findByOidProxy(valorParametro.getOidObjNeg(), aSesion);
		return tc;
	}
	
	public List getDetallesOCPendRecep() throws BaseException {
	  return OrdenDeCompraDet.getDetallesOCPendRecep(this,this.getSesion());
	}
	
	public static String getCarpetaRTMOC(ISesion aSesion) throws BaseException {
		return ValorParametro.findByCodigoParametro("CARPETA_REPO_RTM_OC",aSesion).getValorCadena();
	}  
	
	public static OrdenDeCompraCab getOrdenDeCompra(Integer nroExt,
				ISesion aSesion)
				throws BaseException {
		return DBOrdenDeCompraCab.getOrdenDeCompra(nroExt,aSesion);
	}
	
	public void afterSaveModified() throws BaseException {
		// TODO Auto-generated method stub
		super.afterSaveModified();

		// Verificar si se cambia la version de impresion
		this.getComprobanteImpreso().siEstaCongeladoGenerarNuevaVersion();

	}
	
	public static Talonario getTalonatioDefOC(ISesion aSesion) throws BaseException {
		return Talonario.getTalonatioDefOC(aSesion);
	}
	
	public int getMaxNroRenglon()
		throws BaseException {
		
		return OrdenDeCompraDet.getMaxNroRenglon(this.getSesion(),this);
		
	}
	
	public void fijarEstadoDeAutorizacion(
			Integer estado,
			java.util.Date fecha)
			throws BaseException {
			DBOrdenDeCompraCab.fijarEstadoDeAutorizacion(estado,this,fecha,this.getSesion());
	}
	
	public static void fijarEstadoDeAutorizacion(
			Integer estado,
			OrdenDeCompraCab oc,
			java.util.Date fecha,
			ISesion aSesion)
			throws BaseException {
			DBOrdenDeCompraCab.fijarEstadoDeAutorizacion(estado,oc,fecha,aSesion);
	}
	
	public static boolean isControlaAutorizProdEnOC(ISesion aSesion)
	throws BaseException {
		return ValorParametro.findByCodigoParametro(
		"CONTROLA_AUT_PROD_EN_OC", aSesion).getBoolean();
	}
	
	public static boolean isControlaAutorizCondPagoEnOC(ISesion aSesion)
	throws BaseException {
		return ValorParametro.findByCodigoParametro(
		"CONTROLA_AUT_COND_PAGO_EN_OC", aSesion).getBoolean();
	}	
	
	

}
