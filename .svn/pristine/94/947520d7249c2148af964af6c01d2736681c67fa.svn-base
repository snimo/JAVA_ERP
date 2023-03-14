package com.srn.erp.produccion.bm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.produccion.da.DBAlternativaFabricacion;
import com.srn.erp.stock.bm.Producto;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class AlternativaFabricacion extends ObjetoLogico {

	public AlternativaFabricacion() {
	}

	private List operAltFab = new ArrayList();
	private boolean readOperAltFab = true;

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public static String NICKNAME = "pr.AlternativaFabricacion";

	private RecetaCab receta;
	private String alternativa;
	private Boolean activo;

	public RecetaCab getReceta() throws BaseException {
		supportRefresh();
		return receta;
	}

	public void setReceta(RecetaCab aReceta) {
		this.receta = aReceta;
	}

	public String getAlternativa() throws BaseException {
		supportRefresh();
		return alternativa;
	}

	public void setAlternativa(String aAlternativa) {
		this.alternativa = aAlternativa;
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

	public static AlternativaFabricacion findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (AlternativaFabricacion) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static AlternativaFabricacion findByOidProxy(Integer oid, ISesion aSesion) throws BaseException {
		return (AlternativaFabricacion) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}

	public static AlternativaFabricacion findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (AlternativaFabricacion) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(receta, "Debe ingresar al Receta");
		Validar.noNulo(alternativa, "Debe ingresar al alternativa");
	}

	public static List getAlternativasFabricacion(Producto producto, ISesion aSesion) throws BaseException {
		return DBAlternativaFabricacion.getAlternativasFabricacion(producto, aSesion);
	}

	public List getOperAltFab() throws BaseException {
		if (this.readOperAltFab) {
			List listaOperAltFab = OperAlterFab.getOperAltFab(this, getSesion());
			this.operAltFab.addAll(listaOperAltFab);
			this.readOperAltFab = false;
		}
		return this.operAltFab;
	}

	public void addOperAltFab(OperAlterFab operAltFab) throws BaseException {
		operAltFab.setAlternativa_fabricacion(this);
		this.operAltFab.add(operAltFab);
	}

	public void afterSave() throws BaseException {
		Iterator iterOperAltFab = this.operAltFab.iterator();
		while (iterOperAltFab.hasNext()) {
			OperAlterFab operAltFab = (OperAlterFab) iterOperAltFab.next();
			operAltFab.save();
			operAltFab = null;
		}
		iterOperAltFab = null;
	}

}
