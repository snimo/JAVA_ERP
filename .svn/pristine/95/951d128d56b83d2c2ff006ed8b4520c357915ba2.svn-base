package com.srn.erp.stock.bm;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.general.bm.Pais;
import com.srn.erp.general.bm.Provincia;
import com.srn.erp.stock.da.DBDeposito;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class Deposito extends ObjetoLogico {

	public Deposito() {
	}

	public static String NICKNAME = "st.Deposito";

	public static final String COMPO_ALMACEN = "ALMACEN";

	public static final String COMPO_CONSIG = "CONSIGNACION";

	public static final String COMPO_TRANSF = "TRANSF_INT";

	private String codigo;

	private String descripcion;

	private Boolean activo;

	private String compoDepo;
	
	private String calleyNro;
	private String localidad;
	private String codigoPostal;
	private Provincia provincia;
	private Pais pais;

	private List listaUbicacionesDeposito = null;

	private List estadosDeposito = new ArrayList();

	private boolean readEstadosDeposito = true;

	public String getCodigo() throws BaseException {
		supportRefresh();
		return codigo;
	}

	public void setCodigo(String aCodigo) {
		this.codigo = aCodigo;
	}
	
	public String getCalleyNro() throws BaseException {
		supportRefresh();
		return this.calleyNro;
	}

	public void setCalleyNro(String aCalleyNro) {
		this.calleyNro = aCalleyNro;
	}
	
	public String getLocalidad() throws BaseException {
		supportRefresh();
		return this.localidad;
	}

	public void setLocalidad(String aLocalidad) {
		this.localidad = aLocalidad;
	}

	public String getCodigoPostal() throws BaseException {
		supportRefresh();
		return this.codigoPostal;
	}

	public void setCodigoPostal(String aCodigoPostal) {
		this.codigoPostal = aCodigoPostal;
	}
	
	public Pais getPais() throws BaseException {
		supportRefresh();
		return this.pais;
	}

	public void setPais(Pais aPais) {
		this.pais = aPais;
	}
	
	public Provincia getProvincia() throws BaseException {
		supportRefresh();
		return this.provincia;
	}

	public void setProvincia(Provincia aProvincia) {
		this.provincia = aProvincia;
	}
	
	
	public String getCompoDepo() throws BaseException {
		supportRefresh();
		return compoDepo;
	}

	public void setCompoDepo(String aCompoDepo) {
		this.compoDepo = aCompoDepo;
	}

	public String getDescripcion() throws BaseException {
		supportRefresh();
		return descripcion;
	}

	public void setDescripcion(String aDescripcion) {
		this.descripcion = aDescripcion;
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

	public static Deposito findByOid(Integer oid, ISesion aSesion)
			throws BaseException {
		return (Deposito) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static Deposito findByOidProxy(Integer oid, ISesion aSesion)
			throws BaseException {
		return (Deposito) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}

	public static Deposito findByCodigo(String codigo, ISesion aSesion)
			throws BaseException {
		return (Deposito) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(codigo, "Debe ingresar el Código");
		Validar.noNulo(descripcion, "Debe ingresar la Descripción");
		Validar.noNulo(compoDepo, "Debe ingresar el comportamiento");
	}

	public void afterSave() throws BaseException {
		Iterator iterEstadosDeposito = estadosDeposito.iterator();
		while (iterEstadosDeposito.hasNext()) {
			EstadoDeposito estadoDeposito = (EstadoDeposito) iterEstadosDeposito
					.next();
			estadoDeposito.save();
			estadoDeposito = null;
		}
		iterEstadosDeposito = null;
	}

	public void addEstado(EstadoDeposito estadoDeposito) throws BaseException {
		this.estadosDeposito.add(estadoDeposito);
		estadoDeposito.setDeposito(this);
	}

	public List getEstadosDeposito() throws BaseException {
		if (readEstadosDeposito == true) {
			estadosDeposito.addAll(EstadoDeposito.getEstadosByDeposito(this,
					getSesion()));
			readEstadosDeposito = false;
			return estadosDeposito;
		} else
			return estadosDeposito;
	}

	public static Hashtable getComportamienos() throws BaseException {
		Hashtable comportamientos = new Hashtable();
		comportamientos.put(COMPO_ALMACEN, "Almacén");
		comportamientos.put(COMPO_CONSIG, "En consignación");
		comportamientos.put(COMPO_TRANSF, "Transferencias Internas");
		return comportamientos;
	}

	public List getUbicaciones() throws BaseException {
		if (listaUbicacionesDeposito == null)
			listaUbicacionesDeposito = UbicacionDeposito
					.getUbicacionesDeposito(this, getSesion());
		return listaUbicacionesDeposito;
	}
	
	public UbicacionDeposito getUbicacionDepositoDefault() throws BaseException {
		Iterator iterUbi = this.getUbicaciones().iterator();
		while (iterUbi.hasNext()) {
			UbicacionDeposito ubiDepo = (UbicacionDeposito) iterUbi.next();
			if (ubiDepo.isUbicacionPorDefecto()) 
				return ubiDepo; 
		}
		return null;
	}

	public List getUbicacionesHijo(UbicacionDeposito ubicacionDepositoPadre)
			throws BaseException {
		List ubicacionesHijo = new ArrayList();
		List ubicaciones = getUbicaciones();
		Iterator iterUbicaciones = ubicaciones.iterator();
		while (iterUbicaciones.hasNext()) {
			UbicacionDeposito ubicacionDeposito = (UbicacionDeposito) iterUbicaciones
					.next();
			if (ubicacionDeposito.getOid_padre().intValue() == ubicacionDepositoPadre
					.getOid().intValue()) {
				ubicacionesHijo.add(ubicacionDeposito);
				// System.out.println(ubicacionDeposito.getCodigo()+"
				// "+ubicacionDeposito.getDescripcion());
			}
		}
		return ubicacionesHijo;
	}

	private List getUbicacionesBase() throws BaseException {
		List ubicacionesBase = new ArrayList();
		List ubicaciones = getUbicaciones();
		Iterator iterUbicaciones = ubicaciones.iterator();
		while (iterUbicaciones.hasNext()) {
			UbicacionDeposito ubicacionDeposito = (UbicacionDeposito) iterUbicaciones
					.next();
			if (ubicacionDeposito.isNodoBase())
				ubicacionesBase.add(ubicacionDeposito);
		}
		return ubicacionesBase;
	}

	public List getUbicacionesHabilitadas(
			TipoConfMovStkTalonario tipoConfMovStkTal) throws BaseException {

		Hashtable ubicacionesHabilitadas = new Hashtable();
		List listaUbicacionesDeposito = new ArrayList();
		MovStockTalonarioDeposito movStkTalDepo = null;
		if (tipoConfMovStkTal != null)
			movStkTalDepo = MovStockTalonarioDeposito
					.getMovStockTalonarioDeposito(tipoConfMovStkTal, this,
							getSesion());
		// Obtener las Ubicaciones Habilitadas
		if (movStkTalDepo != null) {
			Iterator iterUbiHabi = movStkTalDepo.getUbicacionesHabilitadas()
					.iterator();
			while (iterUbiHabi.hasNext()) {
				UbiDepoHabTalonario ubiDepoHabTal = (UbiDepoHabTalonario) iterUbiHabi
						.next();
				ubicacionesHabilitadas
						.put(ubiDepoHabTal.getUbicacion_deposito()
								.getOIDInteger(), ubiDepoHabTal);
			}
		}

		// Leer las Ubicaciones del Deposito y habilitar o no las ubicaciones
		// segun corresponda
		List ubicacionesBase = getUbicacionesBase();
		Iterator iterUbiBase = ubicacionesBase.iterator();
		while (iterUbiBase.hasNext()) {
			UbicacionDeposito ubicacionBase = (UbicacionDeposito) iterUbiBase
					.next();
			habilitarUbicacion(ubicacionBase, ubicacionesHabilitadas);
			listaUbicacionesDeposito.add(ubicacionBase);
			traerSubUbicaciones(ubicacionBase, listaUbicacionesDeposito,
					ubicacionesHabilitadas);
		}
		return listaUbicacionesDeposito;
	}

	private void traerSubUbicaciones(UbicacionDeposito ubicacionPadre,
			List listaUbicacionesDeposito, Hashtable ubicacionesHabilitadas)
			throws BaseException {
		List ubicacionesHijo = getUbicacionesHijo(ubicacionPadre);
		Iterator iterUbicacionesHijo = ubicacionesHijo.iterator();
		while (iterUbicacionesHijo.hasNext()) {
			UbicacionDeposito ubicacionHijo = (UbicacionDeposito) iterUbicacionesHijo
					.next();
			habilitarUbicacion(ubicacionHijo, ubicacionesHabilitadas);
			habiUbiSiPadreLoPermite(ubicacionPadre, ubicacionHijo);
			listaUbicacionesDeposito.add(ubicacionHijo);
			traerSubUbicaciones(ubicacionHijo, listaUbicacionesDeposito,
					ubicacionesHabilitadas);
		}
	}

	private void habiUbiSiPadreLoPermite(UbicacionDeposito ubiDepoPadre,
			UbicacionDeposito ubiDepoActual) throws BaseException {
		if ((ubiDepoPadre.getHabilitada()) && (ubiDepoPadre.getIncSubUbi())) {
			ubiDepoActual.setHabilitada(true);
			ubiDepoActual.setIncSubUbi(true);
		}
	}

	private void habilitarUbicacion(UbicacionDeposito ubiDepo,
			Hashtable listaUbiHabi) throws BaseException {
		UbiDepoHabTalonario ubiDepoHabTal = (UbiDepoHabTalonario) listaUbiHabi
				.get(ubiDepo.getOIDInteger());
		if (ubiDepoHabTal != null) {
			ubiDepo.setHabilitada(ubiDepoHabTal.isHabilitado().booleanValue());
			ubiDepo
					.setIncSubUbi(ubiDepoHabTal.isIncluye_hijos()
							.booleanValue());
			ubiDepo.setUsarPorDefecto(ubiDepoHabTal.isUsar_por_defecto()
					.booleanValue());
		}
	}

	public SaldoStockProducto getSaldoStockProducto(Producto producto)
			throws BaseException {
		return SaldoStockProducto.getSaldoStockProducto(producto, this,
				getSesion());
	}

	public UbicacionDeposito getUbicacionDeposito(String codUbi)
			throws BaseException {
		return UbicacionDeposito
				.getUbicacionDeposito(this, codUbi, getSesion());
	}

	public EstadoDeposito getEstadoDeposito(EstadoStock estadoStock)
			throws BaseException {
		return EstadoDeposito.getEstadoDeposito(this, estadoStock, getSesion());
	}

	public static List getDepositos(ISesion aSesion) throws BaseException {
		return DBDeposito.getDepositos(aSesion);
	}
	
	public String getDireccionCompleta() throws BaseException {

		StringBuffer dir = new StringBuffer();
		if (this.getCalleyNro() != null) {
			if (!this.getCalleyNro().equals("."))
				dir.append(this.getCalleyNro());
		}

		if ((this.getLocalidad() != null) && !(this.getLocalidad().equals("."))) {

			if ((this.getLocalidad() != null)
					&& (this.getLocalidad().length() > 0)) {
				if ((dir.toString().trim().length() != 0))
					dir.append(", ");
			}

			dir.append(this.getLocalidad());

		}

		if ((this.getCodigo() != null) && (!this.getCodigo().equals("."))) {

			if ((this.getCodigo() != null) && (this.getCodigo().length() > 0)) {
				if ((dir.toString().trim().length() != 0))
					dir.append(" ");
			}

			if ((this.getCodigo() != null) && (this.getCodigo().length() > 0))
				dir.append("(" + this.getCodigo() + ")");

		}
		if (this.getProvincia() != null) {
			if ((dir.toString().trim().length() != 0))
				dir.append(", ");
			dir.append(this.getProvincia().getDescripcion());
		}
		if (this.getPais() != null) {
			if ((dir.toString().trim().length() != 0))
				dir.append(", ");

			dir.append(this.getPais().getDescripcion());
		}

		return dir.toString();
	}
	
	

}
