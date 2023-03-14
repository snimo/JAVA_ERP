package com.srn.erp.stock.bm;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.contabilidad.bm.Atributo;
import com.srn.erp.contabilidad.bm.GrupoAtributoEntidadVar;
import com.srn.erp.contabilidad.bm.GrupoDeAtributos;
import com.srn.erp.stock.da.DBAtributosProducto;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class AtributosProducto extends ObjetoLogico {

	Hashtable	valoresAtributos	= new Hashtable();

	Hashtable	gruposDeAtributos	= new Hashtable();

	List			atributosNulos		= new ArrayList();

	public AtributosProducto() {
	}

	public static String	NICKNAME	= "st.AtributosProducto";

	private Producto			producto;

	public Producto getProducto() throws BaseException {
		supportRefresh();
		return producto;
	}

	public void setProducto(Producto aProducto) {
		this.producto = aProducto;
	}

	public String getNickName() {
		return NICKNAME;
	}

	public static AtributosProducto findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (AtributosProducto) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static AtributosProducto findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (AtributosProducto) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(producto, "Debe ingresar el Producto");
	}

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public Boolean isActivo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public static AtributosProducto getAtributosProducto(Producto producto, ISesion aSesion) throws BaseException {
		return DBAtributosProducto.getAtributosProducto(producto, aSesion);
	}

	public void addValor(Atributo atributo, Object valor) throws BaseException {
		boolean encontro = false;
		Iterator iterKeyAtri = valoresAtributos.keySet().iterator();
		while (iterKeyAtri.hasNext()) {
			Atributo atributoActual = (Atributo) iterKeyAtri.next();
			if (atributoActual.getOIDInteger().intValue() == atributo.getOIDInteger().intValue()) {
				// Setear el atributo con el Nuevo Valor
				valoresAtributos.remove(atributoActual);
				if (valor != null)
					valoresAtributos.put(atributoActual, valor);
				encontro = true;
				break;
			}
		}
		if (!encontro)
			if (valor != null)
				valoresAtributos.put(atributo, valor);
	}

	public Hashtable getValoresAtributos() {
		return this.valoresAtributos;
	}
	
	public GrupoDeAtributos getGrupoDeAtributos(GrupoAtributoEntidadVar grupoAtriEntVar) throws BaseException {
		GrupoDeAtributos grupoDeAtriSel = null;
		Iterator iterGruposDeAtributosVar = this.gruposDeAtributos.keySet().iterator();
		while (iterGruposDeAtributosVar.hasNext()) {
			GrupoAtributoEntidadVar grupoAtriEntVarIte = (GrupoAtributoEntidadVar) iterGruposDeAtributosVar.next();
			if (grupoAtriEntVarIte.getOID() == grupoAtriEntVar.getOID()) {
				grupoDeAtriSel = (GrupoDeAtributos)this.gruposDeAtributos.get(grupoAtriEntVarIte);
				break;
			}
		}
		return grupoDeAtriSel;
	}

	public Object getValor(Atributo atributo) throws BaseException {
		Object valorAtri = null;
		Iterator iterAtri = this.valoresAtributos.keySet().iterator();
		while (iterAtri.hasNext()) {
			Atributo atributoActual = (Atributo) iterAtri.next();
			if (atributoActual.getOID() == atributo.getOID()) {
				valorAtri = this.valoresAtributos.get(atributoActual);
				break;
			}
		}
		return valorAtri;
	}

	public void addGrupoAtributoEntidadVar(GrupoAtributoEntidadVar grupoAtriEntVar, GrupoDeAtributos grupoDeAtributos)
			throws BaseException {
		boolean encontro = false;
		
		if (grupoDeAtributos == null) {
			return;
		}
		
		Iterator iterKeyAtri = this.gruposDeAtributos.keySet().iterator();
		while (iterKeyAtri.hasNext()) {
			GrupoAtributoEntidadVar grupoAtriEntVarSet = (GrupoAtributoEntidadVar) iterKeyAtri.next();
			if (grupoDeAtributos.getOIDInteger().intValue() == grupoAtriEntVarSet.getOIDInteger().intValue()) {
				this.gruposDeAtributos.remove(grupoAtriEntVarSet);
				if (grupoDeAtributos != null)
					this.gruposDeAtributos.put(grupoAtriEntVar, grupoDeAtributos);
				encontro = true;
				break;
			}
		}
		if (!encontro)
			if (grupoDeAtributos != null)
				this.gruposDeAtributos.put(grupoAtriEntVar, grupoDeAtributos);
	}

}
