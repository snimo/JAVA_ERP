package com.srn.erp.conciTarjeta.bm;

import java.util.Date;
import java.util.List;

import com.srn.erp.conciTarjeta.da.DBDetTarConciEnt;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.Fecha;
import framework.applicarionServer.bm.Seguridad.Usuario;
import framework.applicarionServer.bm.Varios.Money;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;

public class DetTarConciEnt extends ObjetoLogico {

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public DetTarConciEnt() {
	}

	public static String NICKNAME = "ctar.DetTarConciEnt";

	private CabTarConciEnt tar_info_cab;
	private String tipo_operacion;
	private java.util.Date fec_present;
	private Integer lote;
	private java.util.Date fec_pago;
	private String descripcion;
	private EmpresaConciTar empresa;
	private Integer nro_comprobante;
	private java.util.Date fec_origen;
	private String plan;
	private Integer nro_tarjeta;
	private String cuota;
	private String moneda;
	private String comercio;
	private Money importe;
	private Integer nro_cupon;
	private Boolean activo;
	private String tipoTarjeta;
	private Boolean conciliado;
	private Date fecConciliado;
	private String tarjeta;
	private Boolean preconci;
	private java.util.Date fecPreconci;
	private Usuario usuPreconci;
	private Integer nroConciliacion;
	private Boolean marcarPreconci;
	private Usuario usuarioMarcaPreconci;
	private CabConciAutomatica cabConciAut;
	private Boolean preconciDudoso;
	private String nomArchivo;
	private Boolean altaManual;

	public Integer getNroConciliacion() throws BaseException {
		supportRefresh();
		return this.nroConciliacion;
	}
	
	public Boolean isAltaManual() throws BaseException {
		supportRefresh();
		if (this.altaManual == null)
			return false;
		else
			return this.altaManual;
	}	
	
	public String getNomArchivo() throws BaseException {
		supportRefresh();
		if (this.nomArchivo == null)
			return "";
		else
			return this.nomArchivo;
	}	
	
	public Boolean isPreconciDudoso() throws BaseException {
		supportRefresh();
		if (this.preconciDudoso!=null)
			return this.preconciDudoso;
		else
			return false;
	}	
	
	public CabConciAutomatica getCabConciAut() throws BaseException {
		supportRefresh();
		return this.cabConciAut;
	}	

	public Usuario getUsuarioMarcaPreconci() throws BaseException {
		supportRefresh();
		return this.usuarioMarcaPreconci;
	}

	public Boolean isMarcarPreconci() throws BaseException {
		supportRefresh();
		return this.marcarPreconci;
	}

	public void setNroConciliacion(Integer aNroConciliacion) {
		this.nroConciliacion = aNroConciliacion;
	}
	
	public void setNomArchivo(String aNomArchivo) {
		this.nomArchivo = aNomArchivo;
	}	
	
	public void setAltaManual(Boolean aAltaManual) {
		this.altaManual = aAltaManual;
	}
	
	public void setPreconciDudoso(Boolean aPreconciDudoso) {
		this.preconciDudoso = aPreconciDudoso;
	}	
	
	public void setCabConciAut(CabConciAutomatica aCabConciAut) {
		this.cabConciAut = aCabConciAut;
	}	

	public void setUsuarioMarcaPreconci(Usuario aUsuarioMarcaPreconci) {
		this.usuarioMarcaPreconci = aUsuarioMarcaPreconci;
	}

	public void setMarcarPreconci(Boolean aMarcarPreconci) {
		this.marcarPreconci = aMarcarPreconci;
	}

	public Boolean isPreConciliado() throws BaseException {
		supportRefresh();
		return this.preconci;
	}

	public void setPreConciliado(Boolean aPreconciliado) {
		this.preconci = aPreconciliado;
	}

	public java.util.Date getFecPreconci() throws BaseException {
		supportRefresh();
		return this.fecPreconci;
	}

	public void setFecPreconci(java.util.Date aFecPreconci) {
		this.fecPreconci = aFecPreconci;
	}

	public Usuario getUsuPreConci() throws BaseException {
		supportRefresh();
		return this.usuPreconci;
	}

	public void setUsuPreConci(Usuario aUsuario) {
		this.usuPreconci = aUsuario;
	}

	public CabTarConciEnt getTar_info_cab() throws BaseException {
		supportRefresh();
		return tar_info_cab;
	}

	public Boolean isConciliado() throws BaseException {
		supportRefresh();
		return this.conciliado;
	}

	public java.util.Date getFecConciliado() throws BaseException {
		supportRefresh();
		return this.fecConciliado;
	}

	public void setFecConciliado(java.util.Date aFecConci) {
		this.fecConciliado = aFecConci;
	}

	public void setConciliado(boolean aConciliado) {
		this.conciliado = aConciliado;
	}

	public String getTipoTarjeta() throws BaseException {
		supportRefresh();
		return this.tipoTarjeta;
	}

	public void setTarjeta(String aTarjeta) {
		this.tarjeta = aTarjeta;
	}

	public String getTarjeta() throws BaseException {
		supportRefresh();
		return this.tarjeta;
	}

	public void setTar_info_cab(CabTarConciEnt aTar_info_cab) {
		this.tar_info_cab = aTar_info_cab;
	}

	public void setTipoTarjeta(String aTipoTarjeta) {
		this.tipoTarjeta = aTipoTarjeta;
	}

	public String getTipo_operacion() throws BaseException {
		supportRefresh();
		return tipo_operacion;
	}

	public void setTipo_operacion(String aTipo_operacion) {
		this.tipo_operacion = aTipo_operacion;
	}

	public java.util.Date getFec_present() throws BaseException {
		supportRefresh();
		return fec_present;
	}

	public void setFec_present(java.util.Date aFec_present) {
		this.fec_present = aFec_present;
	}

	public Integer getLote() throws BaseException {
		supportRefresh();
		return lote;
	}

	public void setLote(Integer aLote) {
		this.lote = aLote;
	}

	public java.util.Date getFec_pago() throws BaseException {
		supportRefresh();
		return fec_pago;
	}

	public void setFec_pago(java.util.Date aFec_pago) {
		this.fec_pago = aFec_pago;
	}

	public String getDescripcion() throws BaseException {
		supportRefresh();
		return descripcion;
	}

	public void setDescripcion(String aDescripcion) {
		this.descripcion = aDescripcion;
	}

	public EmpresaConciTar getEmpresa() throws BaseException {
		supportRefresh();
		return empresa;
	}

	public void setEmpresa(EmpresaConciTar aEmpresa) {
		this.empresa = aEmpresa;
	}

	public Integer getNro_comprobante() throws BaseException {
		supportRefresh();
		return nro_comprobante;
	}

	public void setNro_comprobante(Integer aNro_comprobante) {
		this.nro_comprobante = aNro_comprobante;
	}

	public java.util.Date getFec_origen() throws BaseException {
		supportRefresh();
		return fec_origen;
	}

	public void setFec_origen(java.util.Date aFec_origen) {
		this.fec_origen = aFec_origen;
	}

	public String getPlan() throws BaseException {
		supportRefresh();
		return plan;
	}

	public void setPlan(String aPlan) {
		this.plan = aPlan;
	}

	public Integer getNro_tarjeta() throws BaseException {
		supportRefresh();
		return nro_tarjeta;
	}

	public void setNro_tarjeta(Integer aNro_tarjeta) {
		this.nro_tarjeta = aNro_tarjeta;
	}

	public String getCuota() throws BaseException {
		supportRefresh();
		return cuota;
	}

	public void setCuota(String aCuota) {
		this.cuota = aCuota;
	}

	public String getMoneda() throws BaseException {
		supportRefresh();
		return moneda;
	}

	public void setMoneda(String aMoneda) {
		this.moneda = aMoneda;
	}

	public String getComercio() throws BaseException {
		supportRefresh();
		return comercio;
	}

	public void setComercio(String aComercio) {
		this.comercio = aComercio;
	}

	public Money getImporte() throws BaseException {
		supportRefresh();
		return importe;
	}

	public void setImporte(Money aImporte) {
		this.importe = aImporte;
	}

	public Integer getNro_cupon() throws BaseException {
		supportRefresh();
		return nro_cupon;
	}

	public void setNro_cupon(Integer aNro_cupon) {
		this.nro_cupon = aNro_cupon;
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

	public static DetTarConciEnt findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (DetTarConciEnt) getObjectByOid(NICKNAME, oid, aSesion);
	}
	
	public static DetTarConciEnt findByOidProxy(Integer oid, ISesion aSesion) throws BaseException {
		return (DetTarConciEnt) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}	

	public static DetTarConciEnt findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (DetTarConciEnt) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		//Validar.noNulo(tar_info_cab, "Debe ingresar la cabecera");
	}

	public static List getDetalles(CabTarConciEnt cabecera, ISesion aSesion) throws BaseException {
		return DBDetTarConciEnt.getDetalles(cabecera, aSesion);
	}

	public static List getDetEmpPendConci(EmpresaConciTar empresa, ISesion aSesion) throws BaseException {
		return DBDetTarConciEnt.getDetEmpPendConci(empresa, aSesion);
	}

	public static void marcarComoPreconci(DetTarConciEnt detTarConciEnt, ISesion aSesion) throws BaseException {
		DBDetTarConciEnt.marcarComoPreconci(detTarConciEnt, aSesion);
	}

	public static void marcarComoNoPreconci(DetTarConciEnt detTarConciEnt, ISesion aSesion) throws BaseException {
		DBDetTarConciEnt.marcarComoNoPreconci(detTarConciEnt, aSesion);
	}

	public void marcarComoPreconci() throws BaseException {
		DBDetTarConciEnt.marcarComoPreconci(this, this.getSesion());
	}

	public void marcarComoNoPreconci() throws BaseException {
		DBDetTarConciEnt.marcarComoNoPreconci(this, this.getSesion());
	}

	public static List getMarcadosPorEmpresaUsu(EmpresaConciTar empresa, Usuario usuario, ISesion aSesion) throws BaseException {
		return DBDetTarConciEnt.getMarcadosPorEmpresaUsu(empresa, usuario, aSesion);
	}

	public void generarPreconciliacion(
			Integer nroConciliacion , 
			CabConciAutomatica cabConciAut,
			boolean dudoso) throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put(DetTarConciEnt.NICKNAME, this);
		condiciones.put("NRO_CONCILIACION", nroConciliacion);
		condiciones.put("DUDOSO", new Boolean(dudoso));
		if (cabConciAut!=null)
			condiciones.put(CabConciAutomatica.NICKNAME, cabConciAut);
		ObjetoLogico.getObjects(DetTarConciEnt.NICKNAME, DBDetTarConciEnt.GENERAR_PRECONCILIACION, condiciones, null, this.getSesion());
	}

	public void marcarComoConciliado() throws BaseException {
		DBDetTarConciEnt.marcarComoConciliado(this, this.getSesion());
	}

	public static List getPreconciliadosByNro(EmpresaConciTar empresa, Integer nroConciliacion, ISesion aSesion) throws BaseException {
		return DBDetTarConciEnt.getPreconciliadosByNro(empresa, nroConciliacion, aSesion);
	}

	public static List getTarjPendPreconci(
				EmpresaConciTar empresa, 
				String tarjeta, 
				ISesion aSesion) throws BaseException {
		return DBDetTarConciEnt.getTarjPendPreconci(
				empresa, 
				tarjeta, 
				aSesion);
	}
	
	public static List getTarjConciliadas(
			EmpresaConciTar empresa, 
			Integer nroConciliacion, 
			ISesion aSesion) throws BaseException {
		return DBDetTarConciEnt.getTarjConciliadas(empresa,nroConciliacion,aSesion); 
	}
	
	public static List getTarjConciliadasAutomaticamente(
			EmpresaConciTar empresa, 
			CabConciAutomatica cabConciAutomatica, 
			ISesion aSesion) throws BaseException {
		return DBDetTarConciEnt.getTarjConciliadasAutomaticamente(empresa,cabConciAutomatica,aSesion); 
	}	
	
	public String getDesc() throws BaseException {
		return "Fecha:"+Fecha.getddmmyyyy(this.getFec_origen())+" "+this.getTarjeta()+" Nro. "+this.getNro_tarjeta()+" importe "+this.getImporte().doubleValue();
		
	}

}
