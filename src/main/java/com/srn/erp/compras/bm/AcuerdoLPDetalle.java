package com.srn.erp.compras.bm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.compras.da.DBAcuerdoLPDetalle;
import com.srn.erp.general.bm.Moneda;
import com.srn.erp.stock.bm.Producto;
import com.srn.erp.stock.bm.ProductoProveedor;
import com.srn.erp.stock.bm.UnidadMedida;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bm.Varios.Money;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class AcuerdoLPDetalle extends ObjetoLogico {

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public AcuerdoLPDetalle() {
	}

	public static String NICKNAME = "cp.AcuerdoLPDetalle";

	private AcuerdoLP Acuerdo_LP;

	private Producto producto;

	private java.util.Date vigencia_desde;

	private java.util.Date vigencia_hasta;

	private Double cantidad;

	private UnidadMedida unidad_medida;

	private Moneda moneda;

	private Money precio;

	private String comentario;

	private Boolean activo;

	private List detallesAcuerdosDtos = new ArrayList();

	private boolean readDetallesAcuerdosDtos = true;

	private String codProdProv;

	private String descProdProv;

	public void setDescProdProv(String aDescProdProv) throws BaseException {
		this.descProdProv = aDescProdProv;
	}

	public String getDescProdProv() throws BaseException {
		supportRefresh();
		return descProdProv;
	}

	public AcuerdoLP getAcuerdo_lp() throws BaseException {
		supportRefresh();
		return Acuerdo_LP;
	}

	public void setAcuerdo_lp(AcuerdoLP aAcuerdo_lp) {
		this.Acuerdo_LP = aAcuerdo_lp;
	}

	public String getCodProdProv() throws BaseException {
		supportRefresh();
		return codProdProv;
	}

	public void setCodProdProv(String aCodProdProv) {
		this.codProdProv = aCodProdProv;
	}

	public Producto getProducto() throws BaseException {
		supportRefresh();
		return producto;
	}

	public void setProducto(Producto aProducto) {
		this.producto = aProducto;
	}

	public java.util.Date getVigencia_desde() throws BaseException {
		supportRefresh();
		return vigencia_desde;
	}

	public void setVigencia_desde(java.util.Date aVigencia_desde) {
		this.vigencia_desde = aVigencia_desde;
	}

	public java.util.Date getVigencia_hasta() throws BaseException {
		supportRefresh();
		return vigencia_hasta;
	}

	public void setVigencia_hasta(java.util.Date aVigencia_hasta) {
		this.vigencia_hasta = aVigencia_hasta;
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

	public Moneda getMoneda() throws BaseException {
		supportRefresh();
		return moneda;
	}

	public void setMoneda(Moneda aMoneda) {
		this.moneda = aMoneda;
	}

	public Money getPrecio() throws BaseException {
		supportRefresh();
		return precio;
	}

	public void setPrecio(Money aPrecio) {
		this.precio = aPrecio;
	}

	public String getComentario() throws BaseException {
		supportRefresh();
		return comentario;
	}

	public void setComentario(String aComentario) {
		this.comentario = aComentario;
	}

	public Boolean isActivo() throws BaseException {
		supportRefresh();
		return activo;
	}

	public void setActivo(Boolean aActivo) throws BaseException {
		this.activo = aActivo;
		if (aActivo.booleanValue() == false)
			this.delete();
	}

	public String getNickName() {
		return NICKNAME;
	}

	public static AcuerdoLPDetalle findByOid(Integer oid, ISesion aSesion)
			throws BaseException {
		return (AcuerdoLPDetalle) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static AcuerdoLPDetalle findByOidProxy(Integer oid, ISesion aSesion)
			throws BaseException {
		return (AcuerdoLPDetalle) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}

	public static AcuerdoLPDetalle findByCodigo(String codigo, ISesion aSesion)
			throws BaseException {
		return (AcuerdoLPDetalle) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(Acuerdo_LP, "Debe ingresar el acuerdo");
		Validar.noNulo(vigencia_desde, "Debe ingresar la vigencia desde");
		Validar.noNulo(vigencia_hasta, "Debe ingresar la vigencia hasta");
		Validar.noNulo(cantidad, "Debe ingresar la cantidad");
		Validar.noNulo(unidad_medida, "Debe ingresar la Unidad de Medida");
		Validar.noNulo(moneda, "Debe ingresar la Moneda");
		Validar.noNulo(precio, "Debe ingresar el Precio");
		Validar.noNulo(codProdProv,
				"Debe ingresar el código de producto de proveedor");
	}

	public static List getAcuerdosLPDetalles(AcuerdoLP acuerdoLP,
			ISesion aSesion) throws BaseException {
		return DBAcuerdoLPDetalle.getAcuerdosLPDetalles(acuerdoLP, aSesion);
	}

	public List getAcuerdosDetallesDtos() throws BaseException {
		if (readDetallesAcuerdosDtos) {
			List listaDetallesAcuerdosDtos = AcuerdoLPDetalleDto
					.getAcuerdosLPDetallesDtos(this, getSesion());
			detallesAcuerdosDtos.addAll(listaDetallesAcuerdosDtos);
			readDetallesAcuerdosDtos = false;
		}
		return detallesAcuerdosDtos;
	}

	public void addAcuerdoLPDetalleDto(AcuerdoLPDetalleDto aAcuerdoLPDetalleDto)
			throws BaseException {
		aAcuerdoLPDetalleDto.setAcuerdo_lp_detalle(this);
		detallesAcuerdosDtos.add(aAcuerdoLPDetalleDto);
	}

	public void afterSave() throws BaseException {
		Iterator iterDetallesAcuerdosDetDtos = detallesAcuerdosDtos.iterator();
		while (iterDetallesAcuerdosDetDtos.hasNext()) {
			AcuerdoLPDetalleDto acuerdoLPDetalleDto = (AcuerdoLPDetalleDto) iterDetallesAcuerdosDetDtos
					.next();
			acuerdoLPDetalleDto.save();
			acuerdoLPDetalleDto = null;
		}
		iterDetallesAcuerdosDetDtos = null;

		grabarRelacionProductoProveedor();
	}

	private void grabarRelacionProductoProveedor() throws BaseException {
		if (getProducto() != null) {
			ProductoProveedor productoProveedor = ProductoProveedor
					.getProductoProveedor(getProducto(), getAcuerdo_lp()
							.getProveedor(), getCodProdProv(),
							getUnidad_medida(), getSesion());
			if (productoProveedor == null) {
				productoProveedor = (ProductoProveedor) ProductoProveedor
						.getNew(ProductoProveedor.NICKNAME, getSesion());
				productoProveedor.setProducto(getProducto());
				productoProveedor.setProveedor(getAcuerdo_lp().getProveedor());
				productoProveedor.setCod_prod_prov(getCodProdProv());
				productoProveedor.setUmcpra(getUnidad_medida());
				productoProveedor.setLote_minimo(new Money(0));
				productoProveedor.setLt_ent_dias(new Integer(0));
				productoProveedor.setMultiplo(new Money(0));
				productoProveedor.save();
			}

		}

	}

	public static List getAcuerdosLPDetalles(AcuerdoLP acuerdoLP,
			Producto producto, 
			ISesion aSesion) throws BaseException {
		return DBAcuerdoLPDetalle.getAcuerdosLPDetalles(acuerdoLP,producto,aSesion);
	}

}
