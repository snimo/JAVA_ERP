package com.srn.erp.produccion.bm;

import java.util.List;

import com.srn.erp.general.bm.ComproCab;
import com.srn.erp.produccion.da.DBOrdenFabricacion;
import com.srn.erp.stock.bm.Producto;
import com.srn.erp.stock.bm.UnidadMedida;

import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.Fecha;
import framework.applicarionServer.bm.Seguridad.Usuario;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.Validar;

public class OrdenFabricacion extends ComproCab {

	@Override
	protected void onNew() throws BaseException {
		// TODO Auto-generated method stub
		super.onNew();
		
        // Asignar Valores por Defecto en el Alta de la Orden de Producción
        setUsuario_aprobacion(Usuario.findByOidProxy(this.getSesion().getLogin().getUsuario().getOIDInteger(), this.getSesion()));
        setFecha_aprobacion(Fecha.getFechaActual());
        setCant_producida(new Double(0));
        setPend_producir(new Boolean(true));
        setCerrada(new Boolean(false));
        setEstado_aprobacion(true);

		
	}

	public static final String TIPO_ORDEN_ESTANDAR_SIN_RES = "STD_SIN_RES";
	public static final String TIPO_ORDEN_PROYECTO = "PROY";

	public OrdenFabricacion() {
	}

	public static String NICKNAME = "pr.OrdenFabricacion";

	private Producto producto;
	private Double cantidad;
	private UnidadMedida unidad_medida;
	private Usuario usuario_aprobacion;
	private java.util.Date fecha_aprobacion;
	private java.util.Date fec_ini_est;
	private java.util.Date fec_fin_est;
	private String obs_ord_fab;
	private Planta planta;
	private AlternativaFabricacion alternativa_fabricacion;
	private Double cant_producida;
	private Boolean cerrada;
	private Boolean pend_producir;
	private Boolean estado_aprobacion;
	private String tipoOrden;
	private ComproCab comprobante;

	public Producto getProducto() throws BaseException {
		supportRefresh();
		return producto;
	}

	public void setProducto(Producto aProducto) {
		this.producto = aProducto;
	}

	public String getTipoOrden() throws BaseException {
		supportRefresh();
		return this.tipoOrden;
	}

	public void setTipoOrden(String aTipoOrden) {
		this.tipoOrden = aTipoOrden;
	}

	public Double getCantidad() throws BaseException {
		supportRefresh();
		return cantidad;
	}

	public void setCantidad(Double aCantidad) {
		this.cantidad = aCantidad;
	}

	public UnidadMedida getUnidad_medida() throws BaseException {
		supportRefresh();
		return unidad_medida;
	}

	public void setUnidad_medida(UnidadMedida aUnidad_medida) {
		this.unidad_medida = aUnidad_medida;
	}

	public Usuario getUsuario_aprobacion() throws BaseException {
		supportRefresh();
		return usuario_aprobacion;
	}

	public void setUsuario_aprobacion(Usuario aUsuario_aprobacion) {
		this.usuario_aprobacion = aUsuario_aprobacion;
	}

	public java.util.Date getFecha_aprobacion() throws BaseException {
		supportRefresh();
		return fecha_aprobacion;
	}

	public void setFecha_aprobacion(java.util.Date aFecha_aprobacion) {
		this.fecha_aprobacion = aFecha_aprobacion;
	}

	public java.util.Date getFec_ini_est() throws BaseException {
		supportRefresh();
		return fec_ini_est;
	}

	public void setFec_ini_est(java.util.Date aFec_ini_est) {
		this.fec_ini_est = aFec_ini_est;
	}

	public java.util.Date getFec_fin_est() throws BaseException {
		supportRefresh();
		return fec_fin_est;
	}

	public void setFec_fin_est(java.util.Date aFec_fin_est) {
		this.fec_fin_est = aFec_fin_est;
	}

	public String getObs_ord_fab() throws BaseException {
		supportRefresh();
		return obs_ord_fab;
	}

	public void setObs_ord_fab(String aObs_ord_fab) {
		this.obs_ord_fab = aObs_ord_fab;
	}

	public Planta getPlanta() throws BaseException {
		supportRefresh();
		return planta;
	}

	public void setPlanta(Planta aPlanta) {
		this.planta = aPlanta;
	}

	public AlternativaFabricacion getAlternativa_fabricacion() throws BaseException {
		supportRefresh();
		return alternativa_fabricacion;
	}

	public void setAlternativa_fabricacion(AlternativaFabricacion aAlternativa_fabricacion) {
		this.alternativa_fabricacion = aAlternativa_fabricacion;
	}

	public Double getCant_producida() throws BaseException {
		supportRefresh();
		return cant_producida;
	}

	public void setCant_producida(Double aCant_producida) {
		this.cant_producida = aCant_producida;
	}

	public Boolean isCerrada() throws BaseException {
		supportRefresh();
		return cerrada;
	}

	public void setCerrada(Boolean aCerrada) {
		this.cerrada = aCerrada;
	}

	public Boolean isPend_producir() throws BaseException {
		supportRefresh();
		return pend_producir;
	}

	public void setPend_producir(Boolean aPend_producir) {
		this.pend_producir = aPend_producir;
	}

	public Boolean isEstado_aprobacion() throws BaseException {
		supportRefresh();
		return estado_aprobacion;
	}

	public void setEstado_aprobacion(Boolean aEstado_aprobacion) {
		this.estado_aprobacion = aEstado_aprobacion;
	}

	public String getNickName() {
		return NICKNAME;
	}

	public static OrdenFabricacion findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (OrdenFabricacion) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static OrdenFabricacion findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (OrdenFabricacion) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {

		if (this.isNew()) {
			this.setComprobante(this);
			this.setEstado(ComproCab.ESTADO_ALTA);
			this.setActivo(new Boolean(true));
		}

		beforeSaveComprobante(this);

		Validar.noNulo(producto, "Debe ingresar el Producto");
		Validar.noNulo(cantidad, "Debe ingresar la Cantidad");
		Validar.noNulo(unidad_medida, "Debe ingresar la Unidad de Medida");
		Validar.noNulo(fec_ini_est, "Debe ingresar la fecha de inicio");
		Validar.noNulo(fec_fin_est, "Debe ingresar la fecha de fin estimado");
		Validar.noNulo(planta, "Debe ingresar la Planta");
		Validar.noNulo(alternativa_fabricacion, "Debe ingresar la alternativa de Fabricación");
		Validar.noNulo(tipoOrden, "Tipo de Orden");
	}

	public static HashTableDatos getTiposOrdenes() throws BaseException {
		HashTableDatos tiposOrdenes = new HashTableDatos();
		tiposOrdenes.put(TIPO_ORDEN_ESTANDAR_SIN_RES, "Orden Estandar sin reserva");
		tiposOrdenes.put(TIPO_ORDEN_PROYECTO, "Orden por Proyecto");
		return tiposOrdenes;
	}

	public void setComprobante(ComproCab aComprobante) {
		this.comprobante = aComprobante;
	}

	public void afterSave() throws BaseException {

		afterSaveComprobante(this);
	}
	
	public static List getOrdenes(
			Integer nroExtDesde, 
			Integer nroExtHasta, 
			java.util.Date fecDesde,
			java.util.Date fecHasta, 
			Producto producto,
			java.util.Date fecIniDesde,
			java.util.Date fecIniHasta,
			java.util.Date fecFinDesde,
			java.util.Date fecFinHasta,
			String tipoOrden,
			Boolean soloProdAbiertas,
			ISesion aSesion) throws BaseException {
		return DBOrdenFabricacion.getOrdenes(
				nroExtDesde, nroExtHasta, fecDesde, fecHasta, producto ,
				fecIniDesde,fecIniHasta,fecFinDesde,fecFinHasta,tipoOrden,soloProdAbiertas,
				aSesion);
	}
	

}
