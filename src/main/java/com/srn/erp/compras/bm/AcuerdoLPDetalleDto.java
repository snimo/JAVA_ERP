package com.srn.erp.compras.bm;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.compras.da.DBAcuerdoLPDetalleDto;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class AcuerdoLPDetalleDto extends ObjetoLogico {

	public static final String DTO_POR_PRODUCTO = "PRODUCTO";

	public static final String DTO_POR_CANTIDADES = "CANTIDAD";

	private List dtosPorCantidades = new ArrayList();

	private boolean readDtosPorCantidades = true;

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public AcuerdoLPDetalleDto() {
	}

	public static String NICKNAME = "cp.AcuerdoLPDetalleDto";

	private AcuerdoLPDetalle acuerdo_lp_detalle;

	private CondicionCompra condicion_pago;

	private Double dto_1;

	private Double dto_2;

	private Double dto_3;

	private Double dto_4;

	private Double dto_5;

	private String tipo_dto;

	private Boolean en_cascada;

	private Boolean activo;

	public AcuerdoLPDetalle getAcuerdo_lp_detalle() throws BaseException {
		supportRefresh();
		return acuerdo_lp_detalle;
	}

	public void setAcuerdo_lp_detalle(AcuerdoLPDetalle aAcuerdo_lp_detalle) {
		this.acuerdo_lp_detalle = aAcuerdo_lp_detalle;
	}

	public CondicionCompra getCondicion_pago() throws BaseException {
		supportRefresh();
		return condicion_pago;
	}

	public void setCondicion_pago(CondicionCompra aCondicion_pago) {
		this.condicion_pago = aCondicion_pago;
	}

	public Double getDto_1() throws BaseException {
		supportRefresh();
		return dto_1;
	}

	public void setDto_1(Double aDto_1) {
		if (aDto_1 == null)
			this.dto_1 = new Double(0);
		else
			this.dto_1 = aDto_1;
	}

	public Double getDto_2() throws BaseException {
		supportRefresh();
		return dto_2;
	}

	public void setDto_2(Double aDto_2) {
		if (aDto_2 == null)
			this.dto_2 = new Double(0);
		else
			this.dto_2 = aDto_2;
	}

	public Double getDto_3() throws BaseException {
		supportRefresh();
		return dto_3;
	}

	public void setDto_3(Double aDto_3) {
		if (aDto_3 == null)
			this.dto_3 = new Double(0);
		else
			this.dto_3 = aDto_3;
	}

	public Double getDto_4() throws BaseException {
		supportRefresh();
		return dto_4;
	}

	public void setDto_4(Double aDto_4) {
		if (aDto_4 == null)
			this.dto_4 = new Double(0);
		else
			this.dto_4 = aDto_4;
	}

	public Double getDto_5() throws BaseException {
		supportRefresh();
		return dto_5;
	}

	public void setDto_5(Double aDto_5) {
		if (aDto_5 == null)
			this.dto_5 = new Double(0);
		else
			this.dto_5 = aDto_5;
	}

	public String getTipo_dto() throws BaseException {
		supportRefresh();
		return tipo_dto;
	}

	public void setTipo_dto(String aTipo_dto) {
		this.tipo_dto = aTipo_dto;
	}

	public Boolean isEn_cascada() throws BaseException {
		supportRefresh();
		return en_cascada;
	}

	public void setEn_cascada(Boolean aEn_cascada) {
		this.en_cascada = aEn_cascada;
	}

	public Boolean isActivo() throws BaseException {
		supportRefresh();
		return activo;
	}

	public void setActivo(Boolean aActivo) {
		this.activo = aActivo;
	}

	public String getNickName() {
		return NICKNAME;
	}

	public static AcuerdoLPDetalleDto findByOid(Integer oid, ISesion aSesion)
			throws BaseException {
		return (AcuerdoLPDetalleDto) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static AcuerdoLPDetalleDto findByOidProxy(Integer oid,
			ISesion aSesion) throws BaseException {
		return (AcuerdoLPDetalleDto) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}

	public static AcuerdoLPDetalleDto findByCodigo(String codigo,
			ISesion aSesion) throws BaseException {
		return (AcuerdoLPDetalleDto) getObjectByCodigo(NICKNAME, codigo,
				aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(acuerdo_lp_detalle, "Debe ingresar el acuerdo detalle");
		Validar.noNulo(condicion_pago, "Debe ingresar la condición de Pago");
		Validar.noNulo(tipo_dto, "Debe ingresar el Tipo de descuento");
		Validar.noNulo(en_cascada, "Debe ingresar si es o no en cascada");
	}

	public static List getAcuerdosLPDetallesDtos(
			AcuerdoLPDetalle acuerdoLPDetalle, ISesion aSesion)
			throws BaseException {
		return DBAcuerdoLPDetalleDto.getAcuerdosLPDetallesDtos(
				acuerdoLPDetalle, aSesion);
	}

	public static Hashtable getTiposDtos() throws BaseException {
		Hashtable tipos = new Hashtable();
		tipos.put(DTO_POR_PRODUCTO, "Dto. por Producto");
		tipos.put(DTO_POR_CANTIDADES, "Dto. por cantidades");
		return tipos;
	}

	public List getDtosPorCantidades() throws BaseException {
		if (readDtosPorCantidades) {
			List listaDtosPorCantidades = AcuerdoLPDetalleDtoCant
					.getAcuerdosLPDetallesDtoCant(this, getSesion());
			dtosPorCantidades.addAll(listaDtosPorCantidades);
			readDtosPorCantidades = false;
		}
		return dtosPorCantidades;
	}

	public void addAcuerdoLPDetalleDtoCant(
			AcuerdoLPDetalleDtoCant acuerdoLPDetalleDtoCant)
			throws BaseException {
		acuerdoLPDetalleDtoCant.setAcu_lp_det_dto(this);
		dtosPorCantidades.add(acuerdoLPDetalleDtoCant);
	}

	public void afterSave() throws BaseException {
		Iterator iterDtosCantidades = dtosPorCantidades.iterator();
		while (iterDtosCantidades.hasNext()) {
			AcuerdoLPDetalleDtoCant acuerdoLPDetalleDtoCant = (AcuerdoLPDetalleDtoCant) iterDtosCantidades
					.next();
			acuerdoLPDetalleDtoCant.save();
			acuerdoLPDetalleDtoCant = null;
		}
		iterDtosCantidades = null;
	}

}
