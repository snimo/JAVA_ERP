package com.srn.erp.excluidos.bm;

import java.util.List;

import com.srn.erp.excluidos.da.DBImagenesExcluido;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.Fecha;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class ImagenesExcluido extends ObjetoLogico {

	@Override
	protected void onNew() throws BaseException {
		// TODO Auto-generated method stub
		super.onNew();
		this.setFecha(Fecha.getFechaActual());
	}

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public ImagenesExcluido() {
	}

	public static String NICKNAME = "exc.ImagenesExcluido";

	private IndividuoExcluido individuo;
	private java.util.Date fecha;
	private String comentario;
	private Integer orden;
	private Boolean activo;
	private PredioExcluido predio;

	public IndividuoExcluido getIndividuo() throws BaseException {
		supportRefresh();
		return individuo;
	}
	
	public PredioExcluido getPredio() throws BaseException {
		supportRefresh();
		return predio;
	}	

	public void setIndividuo(IndividuoExcluido aIndividuo) {
		this.individuo = aIndividuo;
	}
	
 	public void setPredio(PredioExcluido aPredioExcluido) {
		this.predio = aPredioExcluido;
	}	

	public java.util.Date getFecha() throws BaseException {
		supportRefresh();
		return fecha;
	}

	public void setFecha(java.util.Date aFecha) {
		this.fecha = aFecha;
	}

	public String getComentario() throws BaseException {
		supportRefresh();
		return comentario;
	}

	public void setComentario(String aComentario) {
		this.comentario = aComentario;
	}

	public Integer getOrden() throws BaseException {
		supportRefresh();
		return orden;
	}

	public void setOrden(Integer aOrden) {
		this.orden = aOrden;
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

	public static ImagenesExcluido findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (ImagenesExcluido) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static ImagenesExcluido findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (ImagenesExcluido) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(individuo, "Debe ingresar el Individuo");
		Validar.noNulo(predio, "Debe ingresar el Predio correspondiente a la Foto del Cliente");
	}

	public static List getImagenesExcluido(IndividuoExcluido individuo, ISesion aSesion) throws BaseException {
		return DBImagenesExcluido.getImagenesExcluido(individuo, aSesion);
	}

	public static ImagenesExcluido getImagenExcluido(ISesion aSesion, IndividuoExcluido individuo, Integer orden) throws BaseException {
		return DBImagenesExcluido.getImagenExcluido(aSesion, individuo, orden);
	}

}
