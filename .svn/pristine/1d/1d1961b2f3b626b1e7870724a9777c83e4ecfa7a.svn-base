package com.srn.erp.compras.bm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.general.bm.ClasificadorEntidad;
import com.srn.erp.general.bm.IValorClasificadorEntidad;
import com.srn.erp.stock.bm.Producto;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bm.Seguridad.Usuario;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class EsquemaHabilitacionProducto extends ObjetoLogico {

	public EsquemaHabilitacionProducto() {
	}
	
  private List detalles = new ArrayList();
  private boolean readDetalles = true;
	

	public static String				NICKNAME	= "cp.EsquemaHabilitacionProducto";

	private String							codigo;

	private String							descripcion;

	private String							ambito_esquema;

	private Boolean							activo;

	private ClasificadorEntidad	clasificador;

	public String getCodigo() throws BaseException {
		supportRefresh();
		return codigo;
	}

	public void setCodigo(String aCodigo) {
		this.codigo = aCodigo;
	}

	public String getDescripcion() throws BaseException {
		supportRefresh();
		return descripcion;
	}

	public void setDescripcion(String aDescripcion) {
		this.descripcion = aDescripcion;
	}

	public String getAmbito_esquema() throws BaseException {
		supportRefresh();
		return ambito_esquema;
	}

	public void setAmbito_esquema(String aAmbito_esquema) {
		this.ambito_esquema = aAmbito_esquema;
	}

	public Boolean isActivo() throws BaseException {
		supportRefresh();
		return activo;
	}

	public void setActivo(Boolean aActivo) {
		this.activo = aActivo;
	}

	public ClasificadorEntidad getClasificador() throws BaseException {
		supportRefresh();
		return clasificador;
	}

	public void setClasificador(ClasificadorEntidad aClasificador) {
		this.clasificador = aClasificador;
	}

	public String getNickName() {
		return NICKNAME;
	}

	public static EsquemaHabilitacionProducto findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (EsquemaHabilitacionProducto) getObjectByOid(NICKNAME, oid, aSesion);
	}
	
	public static EsquemaHabilitacionProducto findByOidProxy(Integer oid, ISesion aSesion) throws BaseException {
		return (EsquemaHabilitacionProducto) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}
	

	public static EsquemaHabilitacionProducto findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (EsquemaHabilitacionProducto) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(codigo, "Debe ingresar el Código");
		Validar.noNulo(descripcion, "Debe ingresar la Descripción");
		Validar.noNulo(ambito_esquema, "Debe ingresar el Esquena");
		Validar.noNulo(clasificador, "Debe ingresar el Clasificador Entidad");
	}
	
  public List getDetalles() throws BaseException {
    if (readDetalles) {
      List listaDetalles = EsqHabProdUsu.getHabilitacionesProductoUsuario(this,getSesion());
      detalles.addAll(listaDetalles);
      readDetalles = false;
    }
    return detalles;
  }

  public void addDetalle(EsqHabProdUsu aEsqHabProdUsu) throws BaseException {
  	aEsqHabProdUsu.setEsquema_habilitacion(this);
    detalles.add(aEsqHabProdUsu);
  }

  public void afterSave() throws BaseException {
    Iterator iterDetalles = detalles.iterator();
    while (iterDetalles.hasNext()) {
      EsqHabProdUsu esqHabProdUsu = (EsqHabProdUsu) iterDetalles.next();
      esqHabProdUsu.save();
      esqHabProdUsu = null;
    }
    iterDetalles = null;
  }
  
  public boolean isProductoHabilitado(Producto producto) throws BaseException {
  	IValorClasificadorEntidad valClasifEnt = producto.getValorClasifEnt(this.getClasificador());
  	if (valClasifEnt == null) return false;
  	Usuario usuario = Usuario.findByOid(this.getSesion().getLogin().getUsuario().getOIDInteger(),getSesion());
  	EsqHabProdUsu esqHabProdUsu = EsqHabProdUsu.getEsqHabProdUsu(this,valClasifEnt,usuario,getSesion());
  	if (esqHabProdUsu!=null)
  		return true;
  	else
  		return false;
  }
	

}
