package com.srn.erp.conciTarjeta.bm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.conciTarjeta.da.DBTarjetaConciTar;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.Validar;

public class TarjetaConciTar extends ObjetoLogico {

	public static final String VISA_DEBITO = "VISAD";
	public static final String VISA_CREDITO = "VISAC";
	public static final String MASTER = "MASTER";
	public static final String MAESTRO = "MAESTRO";
	public static final String ARGENCARD = "ARGENCARD";
	public static final String AME = "AME";

	public static final String TIPO_TARJ_DEB = "DEB";
	public static final String TIPO_TARJ_CRE = "CRED";

	public TarjetaConciTar() {
	}

	public static String NICKNAME = "ctar.TarjetaConciTar";

	private String codigo;
	private String descripcion;
	private String identif_tarj;
	private Boolean activo;
	private String codigoPOSNET;
	private AgrupadorTarjConci agrupador;
	private Integer toleraciaDiasfecConci;
	private Integer tolDiasConcOK;
	private String cuentaTarjACobrar;
	private String cuentaTarjACobrarC1;
	private String cuentaTarjACobrarC2;
	private Boolean ignorarMovPOSNET;
	private String liquidacion;
	private CabModeloLiq cabModeloLiq;

	private List detallesModLiq = new ArrayList();
	private boolean readDetallesModLiq = true;	
	
	public String getEquivIdentif() throws BaseException {
		String equiv = getEquivAutTarjConi(this.getIdentif_tarj());
		return equiv;
	}
	
	public String getLiquidacion() throws BaseException {
		supportRefresh();
		return liquidacion;
	}	
	
	public CabModeloLiq getCabModeloLiq() throws BaseException {
		supportRefresh();
		return this.cabModeloLiq;
	}	

	public String getCodigo() throws BaseException {
		supportRefresh();
		return codigo;
	}
	
	public Boolean isIgnorarMovPOSNET() throws BaseException {
		supportRefresh();
		return this.ignorarMovPOSNET;
	}	
	
	public String getCtaTarjetaACobrar() throws BaseException {
		supportRefresh();
		return this.cuentaTarjACobrar;
	}	
	
	public String getCtaTarjetaACobrarC1() throws BaseException {
		supportRefresh();
		return this.cuentaTarjACobrarC1;
	}	
	
	public String getCtaTarjetaACobrarC2() throws BaseException {
		supportRefresh();
		return this.cuentaTarjACobrarC2;
	}	
	
	public Integer getTolDiasConciOK() throws BaseException {
		supportRefresh();
		if (this.tolDiasConcOK == null)
			return new Integer(0);
		else
			return this.tolDiasConcOK;
	}	

	public Integer getToleranciaDiasFecConci() throws BaseException {
		supportRefresh();
		return this.toleraciaDiasfecConci;
	}

	public AgrupadorTarjConci getAgrupador() throws BaseException {
		supportRefresh();
		return this.agrupador;
	}

	public void setCodigo(String aCodigo) {
		this.codigo = aCodigo;
	}
	
	public void setCabModeloLiq(CabModeloLiq aCabModeloLiq) {
		this.cabModeloLiq = aCabModeloLiq;
	}	
	
	public void setLiquidacion(String aLiquidacion) {
		this.liquidacion = aLiquidacion;
	}	
	
	public void setCtaTarjetaACobrarC1(String aCtaTarjetaACobrarC1) {
		this.cuentaTarjACobrarC1 = aCtaTarjetaACobrarC1;
	}	
	
	public void setIgnorarMovPOSNET(Boolean aIgnorarMovPOSNET) {
		this.ignorarMovPOSNET = aIgnorarMovPOSNET;
	}	
	
	public void setCtaTarjetaACobrarC2(String aCtaTarjetaACobrarC2) {
		this.cuentaTarjACobrarC2 = aCtaTarjetaACobrarC2;
	}	
	
	public void setCtaTarjetaACobrar(String aCtaTarjetaACobrar) {
		this.cuentaTarjACobrar = aCtaTarjetaACobrar;
	}	
	
	public void setTolDiasConciOK(Integer aTolDiasConciOK) {
		this.tolDiasConcOK = aTolDiasConciOK;
	}	

	public void setToleranciaDiasFecConci(Integer aToleranciaDiasFecConci) {
		this.toleraciaDiasfecConci = aToleranciaDiasFecConci;
	}

	public void setAgrupador(AgrupadorTarjConci aAgrupador) {
		this.agrupador = aAgrupador;
	}

	public String getCodigoPosnet() throws BaseException {
		supportRefresh();
		if (codigoPOSNET != null)
			return this.codigoPOSNET;
		else
			return "";
	}

	public void setCodigoPosNet(String aCodPosnet) {
		this.codigoPOSNET = aCodPosnet;
	}

	public String getDescripcion() throws BaseException {
		supportRefresh();
		return descripcion;
	}

	public void setDescripcion(String aDescripcion) {
		this.descripcion = aDescripcion;
	}

	public String getIdentif_tarj() throws BaseException {
		supportRefresh();
		return identif_tarj;
	}

	public void setIdentif_tarj(String aIdentif_tarj) {
		this.identif_tarj = aIdentif_tarj;
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

	public static TarjetaConciTar findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (TarjetaConciTar) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static TarjetaConciTar findByOidProxy(Integer oid, ISesion aSesion) throws BaseException {
		return (TarjetaConciTar) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}

	public static TarjetaConciTar findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (TarjetaConciTar) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(codigo, "Debe ingresar el código");
		Validar.noNulo(descripcion, "Debe ingresar la descripción");
		Validar.noNulo(identif_tarj, "Debe ingresar la identificación");
		Validar.noNulo(this.agrupador, "Debe ingresar el Agrupador");
	}

	public static HashTableDatos getTiposTarjetas() {
		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put(VISA_DEBITO, "VISA DEBITO");
		condiciones.put(VISA_CREDITO, "VISA");
		condiciones.put(MASTER, "MASTER");
		condiciones.put(MAESTRO, "MAESTRO");
		condiciones.put(ARGENCARD, "ARGENCARD");
		condiciones.put(AME, "AME");
		return condiciones;
	}
	
	public static HashTableDatos getEquivTarjetaConConci() throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put(VISA_DEBITO, ConciliarAutomaticaTarj.CA_VISA_DEBITO);
		condiciones.put(VISA_CREDITO, ConciliarAutomaticaTarj.CA_VISA);
		condiciones.put(MASTER, ConciliarAutomaticaTarj.CA_MASTERCARD);
		condiciones.put(MAESTRO, ConciliarAutomaticaTarj.CA_MAESTRO);
		condiciones.put(ARGENCARD, ConciliarAutomaticaTarj.CA_ARGENCARD);
		condiciones.put(AME, ConciliarAutomaticaTarj.CA_AMERICAN);
		return condiciones;
	}
	
	public static String getEquivAutTarjConi(String aIdentifTarj) throws BaseException {
		HashTableDatos compoTarj = getEquivTarjetaConConci();
		return (String) compoTarj.get(aIdentifTarj);
	}

	public static TarjetaConciTar getTarjetaConciliacion(String codigoPOSNET, ISesion aSesion) throws BaseException {
		return DBTarjetaConciTar.getTarjetaConciliacion(codigoPOSNET, aSesion);
	}

	public static TarjetaConciTar getTarjetaByIdentif(String identif, ISesion aSesion) throws BaseException {
		return DBTarjetaConciTar.getTarjetaByIdentif(identif, aSesion);
	}
	
	public static TarjetaConciTar getTarjetaVISADEBITO(ISesion sesion) throws BaseException {
		return TarjetaConciTar.getTarjetaByIdentif(VISA_DEBITO,sesion);
	}
	
	public static TarjetaConciTar getTarjetaVISACREDITO(ISesion sesion) throws BaseException {
		return TarjetaConciTar.getTarjetaByIdentif(VISA_CREDITO,sesion);
	}	
	
	public static TarjetaConciTar getTarjetaMASTER(ISesion sesion) throws BaseException {
		return TarjetaConciTar.getTarjetaByIdentif(MASTER,sesion);
	}	
	
	public static TarjetaConciTar getTarjetaMAESTRO(ISesion sesion) throws BaseException {
		return TarjetaConciTar.getTarjetaByIdentif(MAESTRO,sesion);
	}	
	
	public static TarjetaConciTar getTarjetaARGENCARD(ISesion sesion) throws BaseException {
		return TarjetaConciTar.getTarjetaByIdentif(ARGENCARD,sesion);
	}	
	
	public static TarjetaConciTar getTarjetaAMEX(ISesion sesion) throws BaseException {
		return TarjetaConciTar.getTarjetaByIdentif(AME,sesion);
	}
	
	public static HashTableDatos getTipos() throws BaseException {
		HashTableDatos tipos = new HashTableDatos();
		tipos.put(TIPO_TARJ_DEB, "Débito");
		tipos.put(TIPO_TARJ_CRE, "Crédito");
		return tipos;
	}
	
	public static String getTipo(String tarjeta) {
		if (tarjeta == null) return "";
		if (tarjeta.equals(VISA_DEBITO))
			return TIPO_TARJ_DEB;
		else
			if (tarjeta.equals(VISA_CREDITO))
				return TIPO_TARJ_CRE;			
			else
				if (tarjeta.equals(MASTER))
					return TIPO_TARJ_CRE;		
				else
					if (tarjeta.equals(MAESTRO))
						return TIPO_TARJ_DEB;		
					else
						if (tarjeta.equals(ARGENCARD))
							return TIPO_TARJ_CRE;		
						else
							if (tarjeta.equals(AME))
								return TIPO_TARJ_CRE;
							else
								return "";
	}
	
	public String getTipoTarjeta() throws BaseException {
		return getTipo(this.getIdentif_tarj());	
	}
	
	public List getModelosLiq() throws BaseException {
		    if (this.readDetallesModLiq) {
		      List listaDetModLiq = TarjModeloLiq.getTarjetaModLiq(this,getSesion());
		      this.detallesModLiq.addAll(listaDetModLiq);
		      this.readDetallesModLiq = false;
		    }
		    return this.detallesModLiq;
	}

	public void addModeloLiq(TarjModeloLiq aTarjModeloLiq) throws BaseException {
		aTarjModeloLiq.setTarjeta(this);
		this.detallesModLiq.add(aTarjModeloLiq);
	}

	public void afterSave() throws BaseException {
		Iterator iterModLiq = this.detallesModLiq.iterator();
		while (iterModLiq.hasNext()) {
		      TarjModeloLiq tarjModeloLiq = (TarjModeloLiq) iterModLiq.next();
		      tarjModeloLiq.save();
		      tarjModeloLiq = null;
		}
		iterModLiq = null;
	}	
	

}
