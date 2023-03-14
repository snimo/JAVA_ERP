package com.srn.erp.general.bm;

import java.util.List;

import com.srn.erp.general.da.DBValorClasificadorEntidad;
import com.srn.erp.stock.bm.ExtensionProdGen;
import com.srn.erp.stock.bm.Producto;
import com.srn.erp.ventas.bm.ListaPrecios;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class ValorClasificadorEntidad extends ObjetoLogico implements IValorClasificadorEntidad  {

	public ValorClasificadorEntidad() {
	}

	public static final String	TIPO_TITULO	= "TITULO";

	public static final String	TIPO_RANGO	= "RANGO";

	public static final int			SIN_PADRE		= -1;

	public static String				NICKNAME		= "ge.ValorClasificadorEntidad";

	private ClasificadorEntidad	clasificador_entidad;

	private Integer							oid_item;

	private String							codigo;

	private String							descripcion;

	private Integer							oid_item_padre;

	private Boolean							activo;

	private Integer							orden;

	private String							tipo;

	private String							codigoDesde;

	private String							codigoHasta;

	public void setOrden(Integer aOrden) throws BaseException {
		this.orden = aOrden;
	}

	public Integer getOrden() throws BaseException {
		return this.orden;
	}

	public void setCodigoDesde(String aCodigoDesde) throws BaseException {
		this.codigoDesde = aCodigoDesde;
	}

	public String getCodigoDesde() throws BaseException {
		return this.codigoDesde;
	}

	public void setCodigoHasta(String aCodigoHasta) throws BaseException {
		this.codigoHasta = aCodigoHasta;
	}

	public String getCodigoHasta() throws BaseException {
		return this.codigoHasta;
	}

	public void setTipo(String aTipo) throws BaseException {
		this.tipo = aTipo;
	}

	public String getTipo() throws BaseException {
		return this.tipo;
	}

	public ClasificadorEntidad getClasificador_entidad() throws BaseException {
		supportRefresh();
		return clasificador_entidad;
	}

	public void setClasificador_entidad(ClasificadorEntidad aClasificador_entidad) {
		this.clasificador_entidad = aClasificador_entidad;
	}

	public Integer getOid_item() throws BaseException {
		supportRefresh();
		return oid_item;
	}

	public void setOid_item(Integer aOid_item) {
		this.oid_item = aOid_item;
	}

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

	public Integer getOid_item_padre() throws BaseException {
		supportRefresh();
		return oid_item_padre;
	}

	public void setOid_item_padre(Integer aOid_item_padre) {
		this.oid_item_padre = aOid_item_padre;
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

	public static ValorClasificadorEntidad findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (ValorClasificadorEntidad) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static ValorClasificadorEntidad findByOidProxy(Integer oid, ISesion aSesion) throws BaseException {
		return (ValorClasificadorEntidad) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}

	public static ValorClasificadorEntidad findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (ValorClasificadorEntidad) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(clasificador_entidad, "Debe ingresar el Clasificador");
		Validar.noNulo(oid_item, "Debe ingresar el Item");
		Validar.noNulo(codigo, "Debe ingresar el Código");
		Validar.noNulo(descripcion, "Debe ingresar la Descripción");
		Validar.noNulo(oid_item_padre, "Debe ingresar el Item Padre");
		Validar.noNulo(tipo, "Debe ingresar el Tipo");
	}

	public static List getValoresClasifEntidad(ClasificadorEntidad clasificadorEntidad, ISesion aSesion)
			throws BaseException {
		return DBValorClasificadorEntidad.getValoresClasifEntidad(clasificadorEntidad, aSesion);
	}

	public static List getValoresClasifEntidad(ClasificadorEntidad clasificadorEntidad, String filtroCodigo,
			String filtroDescripcion, ISesion aSesion) throws BaseException {

		return DBValorClasificadorEntidad.getValoresClasifEntidad(clasificadorEntidad, filtroCodigo, filtroDescripcion,
				aSesion);
	}

	public static List getValoresClasifEntidadSoloTitulos(ClasificadorEntidad clasificadorEntidad,
			String buscarPorCodigo, String buscarPorDesc, boolean soloActivos,ISesion aSesion) throws BaseException {
		return DBValorClasificadorEntidad.getValoresClasifEntidadSoloTitulos(clasificadorEntidad, buscarPorCodigo, 
				buscarPorDesc, soloActivos, aSesion);
	}

	public static List getValoresClasifEntidadSoloTitulos(ClasificadorEntidad clasificadorEntidad, boolean soloActivos, ISesion aSesion)
			throws BaseException {
		return DBValorClasificadorEntidad.getValoresClasifEntidadSoloTitulos(clasificadorEntidad, soloActivos, aSesion);
	}

	public static ValorClasificadorEntidad getValorClasificadorEntidad(ClasificadorEntidad clasifEnt, Integer oidItem,
			ISesion aSesion) throws BaseException {

		if (oidItem == null)
			return null;
		else
			return DBValorClasificadorEntidad.getValorClasificadorEntidad(clasifEnt, oidItem, aSesion);
	}

	public static ValorClasificadorEntidad getValorClasifEnt(ClasificadorEntidad clasifEnt, String codigo, ISesion aSesion)
			throws BaseException {
		return DBValorClasificadorEntidad.getValorClasifEnt(clasifEnt, codigo, aSesion);
	}

	public static List getRangosValoresClasifEntidad(ClasificadorEntidad clasificadorEntidad, ISesion aSesion)
			throws BaseException {
		return DBValorClasificadorEntidad.getRangosValoresClasifEntidad(clasificadorEntidad, aSesion);
	}

	public String getIDTitulo() throws BaseException {
		return ClasificadorEntidad.PREFIJO_TITULO + "_" + getOid_item();
	}

	public String getIDTituloPadre() throws BaseException {
		return ClasificadorEntidad.PREFIJO_TITULO + "_" + getOid_item_padre();
	}

	public boolean isTitulo() throws BaseException {
		return getTipo().equals(TIPO_TITULO);
	}
	
	public static int getUltimoNroItem(ISesion aSesion , ClasificadorEntidad clasif) throws BaseException {

		 return DBValorClasificadorEntidad.getUltimoNroItem(aSesion,clasif);
		 
	}
	
	@Override
	public void afterSave() throws BaseException {
		// TODO Auto-generated method stub
		super.afterSave();
		
			
		grabarExtProdGral();
		
	}
	
	private void grabarExtProdGral() throws BaseException {
		
		// Si se trata del clasificaldor correspondiente al Producto general , grabar tambien la table de Extension
		ClasificadorEntidad clasifProdGen = null;
		try {
			clasifProdGen = Producto.getClasifProductoGeneral(this.getSesion());
		}  catch(Exception e) {
			
		}
		
		if (clasifProdGen == null) return;
		
		if (this.getClasificador_entidad().getOID() == clasifProdGen.getOID()) {
			
			if (this instanceof ValorClasifEntProdGen) {
				if (((ValorClasifEntProdGen)this).getExtensionProdGen()!=null)
					((ValorClasifEntProdGen)this).getExtensionProdGen().save();
			}
			
			ExtensionProdGen extProdGral = ExtensionProdGen.getExtensionProdGral(this, this.getSesion());
			if (extProdGral == null) {
				extProdGral = (ExtensionProdGen) ExtensionProdGen.getNew(ExtensionProdGen.NICKNAME, this.getSesion());
				extProdGral.setClasificador(clasifProdGen);
				extProdGral.setValor_clasif_ent(this);
				extProdGral.save();
				
			}
				
			
		}
		
		
	}
	
	public static List getValoresClasifProdGralNotInLP(ListaPrecios listaPrecios, ISesion aSesion)
	throws BaseException {
		return DBValorClasificadorEntidad.getValoresClasifProdGralNotInLP(listaPrecios,aSesion); 
	}
	
	
	
	

}
