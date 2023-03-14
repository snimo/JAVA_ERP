package com.srn.erp.ventas.bm;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.compras.bm.CondicionVenta;
import com.srn.erp.general.bm.Empresa;
import com.srn.erp.general.bm.Sucursal;
import com.srn.erp.general.bm.UnidadOrganizativa;
import com.srn.erp.tesoreria.bm.TarjetaCredito;
import com.srn.erp.tesoreria.bm.TipoValor;
import com.srn.erp.ventas.da.DBCondicionPago;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bm.Parametros.ValorParametro;
import framework.applicarionServer.bm.Seguridad.Usuario;
import framework.applicarionServer.bm.Varios.Porcentaje;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class CondicionPago extends ObjetoLogico {

	public CondicionPago() {
	}

	public static String		CONTADO										= "CONTADO";

	public static String		TARJETA_CREDITO						= "TAR_CRE";

	public static String		CHEQUE_CLIENTE						= "CHE_CLI";

	public static String		CTA_CTE										= "CTA_CTE";

	public static String		NICKNAME									= "ve.CondicionPago";

	private List						unidadesOrganizacionales	= new ArrayList();

	private boolean					readUniOrg								= true;

	private List						tiposValores							= new ArrayList();

	private boolean					readTiposValores					= true;

	private List						cuotas										= new ArrayList();

	private boolean					readCuotas								= true;

	private List						cheques										= new ArrayList();

	private boolean					readCheques								= true;

	private String					codigo;

	private String					descripcion;

	private String					comportamiento;

	private CondicionVenta	condicion_vta;

	private Porcentaje			porc_desc;

	private Porcentaje			porc_reca;

	private TarjetaCredito	tarjeta_credito;

	private GrupoCondPago		grupo_cond_pago;

	private Boolean					activo;

	private boolean					usarEnVtas								= false;
	
  private List listasPreciosCondPago = new ArrayList();
  private boolean readListasPreciosCondPago = true;
	

	public static Hashtable getComportamientos() throws BaseException {
		Hashtable comportamientos = new Hashtable();
		comportamientos.put(CONTADO, "Contado");
		comportamientos.put(TARJETA_CREDITO, "Tarjeta Crédito");
		comportamientos.put(CHEQUE_CLIENTE, "Cheque Cliente");
		comportamientos.put(CTA_CTE, "Cuenta Corriente");
		return comportamientos;
	}

	public String getCodigo() throws BaseException {
		supportRefresh();
		return codigo;
	}

	public void setCodigo(String aCodigo) {
		this.codigo = aCodigo;
	}

	public boolean isUsarEnVtas() throws BaseException {
		supportRefresh();
		return this.usarEnVtas;
	}

	public void setUsarEnVtas(boolean aUsarEnVtas) {
		this.usarEnVtas = aUsarEnVtas;
	}

	public String getDescripcion() throws BaseException {
		supportRefresh();
		return descripcion;
	}

	public void setDescripcion(String aDescripcion) {
		this.descripcion = aDescripcion;
	}

	public String getComportamiento() throws BaseException {
		supportRefresh();
		return comportamiento;
	}

	public void setComportamiento(String aComportamiento) {
		this.comportamiento = aComportamiento;
	}

	public CondicionVenta getCondicion_vta() throws BaseException {
		supportRefresh();
		return condicion_vta;
	}

	public void setCondicion_vta(CondicionVenta aCondicion_vta) {
		this.condicion_vta = aCondicion_vta;
	}

	public Porcentaje getPorc_desc() throws BaseException {
		supportRefresh();
		return porc_desc;
	}

	public void setPorc_desc(Porcentaje aPorc_desc) {
		this.porc_desc = aPorc_desc;
	}

	public Porcentaje getPorc_reca() throws BaseException {
		supportRefresh();
		return porc_reca;
	}

	public void setPorc_reca(Porcentaje aPorc_reca) {
		this.porc_reca = aPorc_reca;
	}

	public TarjetaCredito getTarjeta_credito() throws BaseException {
		supportRefresh();
		return tarjeta_credito;
	}

	public void setTarjeta_credito(TarjetaCredito aTarjeta_credito) {
		this.tarjeta_credito = aTarjeta_credito;
	}

	public GrupoCondPago getGrupo_cond_pago() throws BaseException {
		supportRefresh();
		return grupo_cond_pago;
	}

	public void setGrupo_cond_pago(GrupoCondPago aGrupo_cond_pago) {
		this.grupo_cond_pago = aGrupo_cond_pago;
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

	public static CondicionPago findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (CondicionPago) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static CondicionPago findByOidProxy(Integer oid, ISesion aSesion) throws BaseException {
		return (CondicionPago) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}

	public static CondicionPago findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (CondicionPago) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(codigo, "Debe ingresar el código");
		Validar.noNulo(descripcion, "Debe ingresar la Descripción");
		Validar.noNulo(comportamiento, "Debe ingresar el Comportamiento");
		Validar.noNulo(grupo_cond_pago, "Debe ingresar el Grupo Condición de Pago");

		if (isCtaCte())
			Validar.noNulo(condicion_vta, "Debe ingresar la Cuenta Corriente");
		else if (isTarjetaCredito())
			Validar.noNulo(tarjeta_credito, "Debe ingresar la Tarjeta de Crédito");

	}

	public List getTipoValoresCondPago() throws BaseException {
		if (readTiposValores) {
			List listaTiposValores = CondPagoTipoValor.getTipoValCondPago(this, getSesion());
			tiposValores.addAll(listaTiposValores);
			readTiposValores = false;
		}
		return tiposValores;
	}

	public List getUniOrgCondPago() throws BaseException {
		if (readUniOrg) {
			List listaUniOrgCondPago = CondPagoUniOrg.getUniOrgCondPago(this, getSesion());
			unidadesOrganizacionales.addAll(listaUniOrgCondPago);
			readUniOrg = false;
		}
		return unidadesOrganizacionales;
	}

	public List getCuotasCondPago() throws BaseException {
		if (readCuotas) {
			List listaCuotasCondPago = CondPagoCuotas.getCuotasCondPago(this, getSesion());
			cuotas.addAll(listaCuotasCondPago);
			readCuotas = false;
		}
		return cuotas;
	}

	public List getChequesCondPago() throws BaseException {
		if (readCheques) {
			List listaChequesCondPago = CondPagoCheque.getChequesCondPago(this, getSesion());
			cheques.addAll(listaChequesCondPago);
			readCheques = false;
		}
		return cheques;
	}

	public void addUniOrgCondPago(CondPagoUniOrg condPagoUniOrg) throws BaseException {
		condPagoUniOrg.setCondicion_pago(this);
		unidadesOrganizacionales.add(condPagoUniOrg);
	}

	public void addTipoValorCondPago(CondPagoTipoValor condPagoTipoValor) throws BaseException {
		condPagoTipoValor.setCondicion_pago(this);
		tiposValores.add(condPagoTipoValor);
	}

	public void addChequeCondPago(CondPagoCheque condPagoCheque) throws BaseException {
		condPagoCheque.setCondicion_pago(this);
		cheques.add(condPagoCheque);
	}

	public void addCuotaCondPago(CondPagoCuotas condPagoCuotas) throws BaseException {
		condPagoCuotas.setCondicion_pago(this);
		cuotas.add(condPagoCuotas);
	}

	public void afterSave() throws BaseException {
		
		Iterator iterUniOrgCondPago = unidadesOrganizacionales.iterator();
		while (iterUniOrgCondPago.hasNext()) {
			CondPagoUniOrg condPagoUniOrg = (CondPagoUniOrg) iterUniOrgCondPago.next();
			condPagoUniOrg.save();
			condPagoUniOrg = null;
		}
		iterUniOrgCondPago = null;

		Iterator iterTipoValorCondPago = tiposValores.iterator();
		while (iterTipoValorCondPago.hasNext()) {
			CondPagoTipoValor condPagoTipoValor = (CondPagoTipoValor) iterTipoValorCondPago.next();
			condPagoTipoValor.save();
			condPagoTipoValor = null;
		}
		iterTipoValorCondPago = null;

		Iterator iterCuotasCondPago = cuotas.iterator();
		while (iterCuotasCondPago.hasNext()) {
			CondPagoCuotas condPagoCuotas = (CondPagoCuotas) iterCuotasCondPago.next();
			condPagoCuotas.save();
			condPagoCuotas = null;
		}
		iterCuotasCondPago = null;

		Iterator iterChequesCondPago = cheques.iterator();
		while (iterChequesCondPago.hasNext()) {
			CondPagoCheque condPagoCheque = (CondPagoCheque) iterChequesCondPago.next();
			condPagoCheque.save();
			condPagoCheque = null;
		}
		iterChequesCondPago = null;
		
    Iterator iterListaPreciosCondPago = this.listasPreciosCondPago.iterator();
    while (iterListaPreciosCondPago.hasNext()) {
      ListaPrecioCondPago listaPrecioCondPago = (ListaPrecioCondPago) iterListaPreciosCondPago.next();
      listaPrecioCondPago.save();
      listaPrecioCondPago = null;
    }
    iterListaPreciosCondPago = null;		

	}

	public boolean isChequeCliente() throws BaseException {
		return getComportamiento().equals(CHEQUE_CLIENTE);
	}

	public boolean isContado() throws BaseException {
		return getComportamiento().equals(CONTADO);
	}

	public boolean isTarjetaCredito() throws BaseException {
		return getComportamiento().equals(TARJETA_CREDITO);
	}

	public boolean isCtaCte() throws BaseException {
		return getComportamiento().equals(CTA_CTE);
	}

	public static List getCondicionesDePago(ISesion aSesion) throws BaseException {
		return DBCondicionPago.getCondicionesDePago(aSesion);
	}

	public static List getCondPagoHabSuc(ISesion aSesion) throws BaseException {

		Sucursal sucursal = Sucursal.findByOid(aSesion.getLogin().getOidSucursal(), aSesion);
		Empresa empresa = Empresa.findByOid(aSesion.getLogin().getOidEmpresa(), aSesion);

		List listaCondPagoHab = new ArrayList();
		List listaUniOrgHab = sucursal.getUniOrgHabilitadas(empresa);
		List listaCondPago = getCondicionesDePago(aSesion);
		Iterator iterCondPago = listaCondPago.iterator();
		while (iterCondPago.hasNext()) {
			CondicionPago condPago = (CondicionPago) iterCondPago.next();
			if (condPago.asignadaAUniOrg(listaUniOrgHab))
				listaCondPagoHab.add(condPago);
		}
		return listaCondPagoHab;
	}

	public boolean asignadaAUniOrg(List listaUniOrg) throws BaseException {
		Iterator iterListaUniOrg = listaUniOrg.iterator();
		while (iterListaUniOrg.hasNext()) {
			UnidadOrganizativa uniOrg = (UnidadOrganizativa) iterListaUniOrg.next();
			CondPagoUniOrg condPagoUniOrg = CondPagoUniOrg.getCondPagoUniOrg(this, uniOrg, getSesion());
			if (condPagoUniOrg != null)
				return true;
		}
		return false;
	}

	public Porcentaje getPorcBonif(int cuotas, int dias) throws BaseException {
		if (this.getComportamiento().equals(CONTADO))
			return new Porcentaje(this.getPorc_desc().doubleValue());
		else if (this.getComportamiento().equals(TARJETA_CREDITO))
			return new Porcentaje(this.getPorcDtoTarjetaCredito(cuotas));
		else if (this.getComportamiento().equals(CHEQUE_CLIENTE))
			return this.getPorcDtoChequeCliente(dias);
		else if (this.getComportamiento().equals(CTA_CTE))
			return new Porcentaje(this.getCondicion_vta().getPorcDto().doubleValue());
		else
			return new Porcentaje(0);
	}

	public Porcentaje getPorcRecar(int cuotas, int dias) throws BaseException {
		if (this.getComportamiento().equals(CONTADO))
			return this.getPorc_reca();
		else if (this.getComportamiento().equals(TARJETA_CREDITO))
			return this.getPorcRecarTarjetaCredito(cuotas);
		else if (this.getComportamiento().equals(CHEQUE_CLIENTE))
			return this.getPorcRecarChequeCliente(dias);
		else if (this.getComportamiento().equals(CTA_CTE))
			return this.getCondicion_vta().getPorcRecar();
		else
			return new Porcentaje(0);

	}

	private double getPorcDtoTarjetaCredito(int cantCuotas) throws BaseException {
		Iterator iterCondPago = getCuotasCondPago().iterator();
		while (iterCondPago.hasNext()) {
			CondPagoCuotas condPagoCuotas = (CondPagoCuotas) iterCondPago.next();
			if ((cantCuotas >= condPagoCuotas.getCuota_desde().intValue())
					&& (cantCuotas <= condPagoCuotas.getCuota_hasta().intValue()))
				return condPagoCuotas.getPorc_dto().doubleValue();
		}
		return 0;
	}

	private Porcentaje getPorcRecarTarjetaCredito(int cantCuotas) throws BaseException {
		Iterator iterCondPago = getCuotasCondPago().iterator();
		while (iterCondPago.hasNext()) {
			CondPagoCuotas condPagoCuotas = (CondPagoCuotas) iterCondPago.next();
			if ((cantCuotas >= condPagoCuotas.getCuota_desde().intValue())
					&& (cantCuotas <= condPagoCuotas.getCuota_hasta().intValue()))
				return condPagoCuotas.getPorc_recar();
		}
		return new Porcentaje(0);
	}

	private Porcentaje getPorcDtoChequeCliente(int dias) throws BaseException {
		Iterator iterChequesCondPago = getChequesCondPago().iterator();
		while (iterChequesCondPago.hasNext()) {
			CondPagoCheque condPagoCheque = (CondPagoCheque) iterChequesCondPago.next();
			if ((dias >= condPagoCheque.getDia_desde().intValue()) && (dias <= condPagoCheque.getDia_hasta().intValue()))
				return condPagoCheque.getPorc_dto();
		}
		return new Porcentaje(0);
	}

	private Porcentaje getPorcRecarChequeCliente(int dias) throws BaseException {
		Iterator iterChequesCondPago = getChequesCondPago().iterator();
		while (iterChequesCondPago.hasNext()) {
			CondPagoCheque condPagoCheque = (CondPagoCheque) iterChequesCondPago.next();
			if ((dias >= condPagoCheque.getDia_desde().intValue()) && (dias <= condPagoCheque.getDia_hasta().intValue()))
				return condPagoCheque.getPorc_recar();
		}
		return new Porcentaje(0);
	}

	public static List getCondicionesDePago(ISesion aSesion,
																					Empresa empresa,		
			                                    Sucursal sucursal,
			                                    Usuario usuario) throws BaseException {
		return DBCondicionPago.getCondicionesDePago(aSesion,empresa,sucursal,usuario);
	}
	
  public List getListasPreciosCondPago() throws BaseException {
    if (this.readListasPreciosCondPago) {
      List listaPreciosCondPago = ListaPrecioCondPago.getDetallesListaPreciosCondPago(this,getSesion());
      listasPreciosCondPago.addAll(listaPreciosCondPago);
      readListasPreciosCondPago = false;
    }
    return listasPreciosCondPago;
  }
  
  public void addListaPrecioCondPago(ListaPrecioCondPago listaPrecioCondPago) throws BaseException {
  	listaPrecioCondPago.setCondicionpago(this);
  	listasPreciosCondPago.add(listaPrecioCondPago);
  }
  
  public static CondicionPago getCondicionPagoDefaultVtaMostrador(ISesion aSesion) throws BaseException {
    Integer oidCondPago =
        ValorParametro.findByCodigoParametro("FORMA_PAGO_DEF_VTA_MOS",aSesion).getOidObjNeg();
    CondicionPago condPago = CondicionPago.findByOid(oidCondPago,aSesion);
    return condPago;
  }
  
  public static CondicionPago getCondicionPagoDefaultRecibo(ISesion aSesion) throws BaseException {
    Integer oidCondPago =
        ValorParametro.findByCodigoParametro("COND_PAGO_DEF_RECIBO",aSesion).getOidObjNeg();
    CondicionPago condPago = CondicionPago.findByOid(oidCondPago,aSesion);
    return condPago;
  }
  
  public static CondicionPago getCondicionPagoDefaultFactRto(ISesion aSesion) throws BaseException {
    Integer oidCondPago =
        ValorParametro.findByCodigoParametro("COND_PAGO_DEF_FACT_RTO",aSesion).getOidObjNeg();
    CondicionPago condPago = CondicionPago.findByOid(oidCondPago,aSesion);
    return condPago;
  }
  
  public TipoValor getTipoValorSugerido() throws BaseException {
  	Iterator iterTiposValCondPago = this.getTipoValoresCondPago().iterator();
  	while (iterTiposValCondPago.hasNext()) {
  		CondPagoTipoValor condPagoTipoValor = (CondPagoTipoValor) iterTiposValCondPago.next();
  		if (condPagoTipoValor.isSugerir())
  			return condPagoTipoValor.getTipo_valor();
  	}
  	return null;
  }
	

}
