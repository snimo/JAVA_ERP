package com.srn.erp.mensajero.bm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class GrupoMaquina extends ObjetoLogico {

	private List detMaquinas = new ArrayList();
	private boolean readDetMaquinas = true;

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return this.getNombre();
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return this.getNombre();
	}

	public GrupoMaquina() {
	}

	public static String NICKNAME = "ge.GrupoMaquina";

	private String nombre;
	private Boolean activo;

	public String getNombre() throws BaseException {
		supportRefresh();
		return nombre;
	}

	public void setNombre(String aNombre) {
		this.nombre = aNombre;
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

	public static GrupoMaquina findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (GrupoMaquina) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static GrupoMaquina findByOidProxy(Integer oid, ISesion aSesion) throws BaseException {
		return (GrupoMaquina) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}

	public static GrupoMaquina findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (GrupoMaquina) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(nombre, "Debe ingresar el Nombre");
	}

	public List getMaquinasDet() throws BaseException {
		if (this.readDetMaquinas) {
			List listaDetMaquinas = GrupoMaquinaDet.getMaquinasDetalle(this, getSesion());
			this.detMaquinas.addAll(listaDetMaquinas);
			readDetMaquinas = false;
		}
		return this.detMaquinas;
	}

	public void addMaquinaDet(GrupoMaquinaDet aGrupoMaquinaDet) throws BaseException {
		aGrupoMaquinaDet.setGrupo_maquina(this);
		this.detMaquinas.add(aGrupoMaquinaDet);
	}

	public void afterSave() throws BaseException {
		Iterator iterGrupoMaqDet = this.detMaquinas.iterator();
		while (iterGrupoMaqDet.hasNext()) {
			GrupoMaquinaDet grupoMaquinaDet = (GrupoMaquinaDet) iterGrupoMaqDet.next();
			grupoMaquinaDet.save();
			grupoMaquinaDet = null;
		}
		iterGrupoMaqDet = null;
	}

}
