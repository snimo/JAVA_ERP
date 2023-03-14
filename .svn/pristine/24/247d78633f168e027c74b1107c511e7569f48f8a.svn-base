package com.srn.erp.stock.bm;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.stock.da.DBUbicacionDeposito;
import com.srn.erp.ventas.bm.Sujeto;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class UbicacionDeposito extends ObjetoLogico {

	public UbicacionDeposito() {
	}

	public static String NICKNAME = "st.UbicacionDeposito";

	private String codigo;

	private Integer oid;

	private String descripcion;

	private Deposito deposito;

	private Integer oid_padre;

	private Boolean solo_sku_habi;

	private Sujeto sujeto;

	private Transporte transporte;

	private Deposito deposito_destino;

	private Boolean allow_almacenar;

	private String tipo;
	
	private boolean isUbicacionPorDefecto;

	private Boolean activo;

	private Integer secu;

	private List prodHabilitados = new ArrayList();

	private boolean readProdHabilitados = true;

	// Para manejo especial
	private boolean habilitada = false;

	private boolean incSubUbi = false;

	private boolean usar_por_defecto = false;

	public void setHabilitada(boolean habilitada) {
		this.habilitada = habilitada;
	}

	public boolean getHabilitada() {
		return habilitada;
	}

	public void setIncSubUbi(boolean incSubUbi) {
		this.incSubUbi = incSubUbi;
	}

	public boolean getIncSubUbi() throws BaseException {
		return this.incSubUbi;
	}

	public void setUsarPorDefecto(boolean usarPorDefecto) throws BaseException {
		this.usar_por_defecto = usarPorDefecto;
	}

	public boolean getUsarPorDefecto() throws BaseException {
		return usar_por_defecto;
	}

	public static final String TIPO_UBICACION = "UBICACION";

	public static final String TIPO_CONSIGNACION = "CONSIGNACION";

	public static final String TIPO_TRANSPORTE = "TRANSPORTE";

	public static final String TIPO_TRANS_DEPO = "TRANS_DEPO";

	public String getCodigo() throws BaseException {
		supportRefresh();
		return codigo;
	}

	public void setCodigo(String aCodigo) {
		this.codigo = aCodigo;
	}

	public Integer getSecu() throws BaseException {
		supportRefresh();
		return secu;
	}
	
	public void setEsUbicacionPorDefecto(boolean aEsUbicacionPorDefecto) {
		this.isUbicacionPorDefecto = aEsUbicacionPorDefecto;
	}

	public boolean isUbicacionPorDefecto() throws BaseException {
		supportRefresh();
		return this.isUbicacionPorDefecto;
	}
	

	public void setSecu(Integer aSecu) {
		this.secu = aSecu;
	}

	public Integer getOid() throws BaseException {
		supportRefresh();
		return oid;
	}

	public void setOid(Integer aOid) {
		this.oid = aOid;
	}

	public String getDescripcion() throws BaseException {
		supportRefresh();
		return descripcion;
	}

	public void setDescripcion(String aDescripcion) {
		this.descripcion = aDescripcion;
	}

	public Deposito getDeposito() throws BaseException {
		supportRefresh();
		return deposito;
	}

	public void setDeposito(Deposito aDeposito) {
		this.deposito = aDeposito;
	}

	public Integer getOid_padre() throws BaseException {
		supportRefresh();
		return oid_padre;
	}

	public void setOid_padre(Integer aOid_padre) {
		this.oid_padre = aOid_padre;
	}

	public Boolean isSolo_sku_habi() throws BaseException {
		supportRefresh();
		return solo_sku_habi;
	}

	public void setSolo_sku_habi(Boolean aSolo_sku_habi) {
		this.solo_sku_habi = aSolo_sku_habi;
	}

	public Sujeto getSujeto() throws BaseException {
		supportRefresh();
		return sujeto;
	}

	public void setSujeto(Sujeto aSujeto) {
		this.sujeto = aSujeto;
	}

	public Transporte getTransporte() throws BaseException {
		supportRefresh();
		return transporte;
	}

	public void setTransporte(Transporte aTransporte) {
		this.transporte = aTransporte;
	}

	public Deposito getDeposito_destino() throws BaseException {
		supportRefresh();
		return deposito_destino;
	}

	public void setDeposito_destino(Deposito aDeposito_destino) {
		this.deposito_destino = aDeposito_destino;
	}

	public Boolean isAllow_almacenar() throws BaseException {
		supportRefresh();
		return allow_almacenar;
	}

	public void setAllow_almacenar(Boolean aAllow_almacenar) {
		this.allow_almacenar = aAllow_almacenar;
	}

	public String getTipo() throws BaseException {
		supportRefresh();
		return tipo;
	}

	public void setTipo(String aTipo) {
		this.tipo = aTipo;
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

	public static UbicacionDeposito findByOid(Integer oid, ISesion aSesion)
			throws BaseException {
		return (UbicacionDeposito) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static UbicacionDeposito findByOidProxy(Integer oid, ISesion aSesion)
			throws BaseException {
		return (UbicacionDeposito) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}

	public static UbicacionDeposito findByCodigo(String codigo, ISesion aSesion)
			throws BaseException {
		return (UbicacionDeposito) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(codigo, "Debe ingresar el código de la Ubicación");
		Validar.noNulo(oid, "Debe ingresar la Identificación de la Ubicación");
		Validar.noNulo(descripcion,
				"Debe ingresar la descripción de la Ubicación");
		Validar.noNulo(deposito, "Debe ingresar el Depósito");
		Validar.noNulo(oid_padre, "Debe ingresar la Identificación Padre");
		Validar.noNulo(solo_sku_habi,
				"Debe indicar si solo almacena SKU habilitados");
		Validar.noNulo(allow_almacenar,
				"Debe indicar si se pueden almacenar SKU");
		Validar.noNulo(tipo, "Debe indicar el Tipo");
		Validar.noNulo(secu, "Debe ingresar el Número de secuencia");
		if (getTipo().equals(TIPO_CONSIGNACION))
			Validar.noNulo(sujeto, "Debe ingresar el Cliente");
		if (getTipo().equals(TIPO_TRANSPORTE))
			Validar.noNulo(transporte, "Debe ingresar el Transporte");
		if (getTipo().equals(TIPO_TRANS_DEPO))
			Validar.noNulo(deposito_destino,
					"Debe ingresar el Depósito de Transferencia");
	}

	public static List getUbicacionesDeposito(Deposito deposito, ISesion aSesion)
			throws BaseException {
		return DBUbicacionDeposito.getUbicacionesDeposito(deposito, aSesion);
	}

	public static Hashtable getTiposUbicaciones() throws BaseException {
		Hashtable lista = new Hashtable();
		lista.put(TIPO_UBICACION, "Ubicación Depósito");
		lista.put(TIPO_CONSIGNACION, "En Consignación");
		lista.put(TIPO_TRANSPORTE, "En Transporte");
		lista.put(TIPO_TRANS_DEPO, "Transferencia Depósito");
		return lista;
	}

	public List getProductosHabilitados() throws BaseException {
		if (readProdHabilitados) {
			List listaProdHabi = ProdHabUbiDepo.getProductosHabilitados(this,
					getSesion());
			prodHabilitados.addAll(listaProdHabi);
			readProdHabilitados = false;
		}
		return prodHabilitados;
	}

	public void addProductoHabilitado(ProdHabUbiDepo prodHabUbiDepo)
			throws BaseException {
		prodHabUbiDepo.setUbicacion_deposito(this);
		prodHabilitados.add(prodHabUbiDepo);
	}

	public void afterSave() throws BaseException {
		Iterator iterProdHab = prodHabilitados.iterator();
		while (iterProdHab.hasNext()) {
			ProdHabUbiDepo prodHabUbiDepo = (ProdHabUbiDepo) iterProdHab.next();
			prodHabUbiDepo.save();
			prodHabUbiDepo = null;
		}
		iterProdHab = null;
	}

	public boolean isNodoBase() throws BaseException {
		if (this.getOid_padre().intValue() == -1)
			return true;
		else
			return false;
	}

	public static UbicacionDeposito getUbicacionDeposito(Deposito deposito,
			String codigo, ISesion aSesion) throws BaseException {
		return DBUbicacionDeposito.getUbicacionDeposito(deposito,codigo,aSesion);
	}
	
	public ProdHabUbiDepo getProductoHabilitado(Producto producto) throws BaseException {
		return ProdHabUbiDepo.getProdHab(this,producto,getSesion());
	}

}
