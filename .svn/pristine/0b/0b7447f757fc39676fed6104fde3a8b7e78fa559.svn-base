package com.srn.erp.rrhh.bm;

import java.util.List;

import com.srn.erp.rrhh.da.DBServicioMedicoRRHH;
import com.srn.erp.sueldos.bm.Legajo;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.Validar;

public class ServicioMedicoRRHH extends ObjetoLogico {

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public ServicioMedicoRRHH() {
	}

	public static String NICKNAME = "rh.ServicioMedicoRRHH";

	public static final String SM_PEDMED = "PED_MED";
	public static final String SM_ATEMED = "ATE_MED";
	public static final String SM_ENFFAM = "ENF_FAM";
	public static final String SM_ACCLAB = "ACC_LAB";

	private Legajo legajo;
	private String tipo_serv_med;
	private Integer nro_nov_sist_ext;
	private java.util.Date fec_inicio;
	private java.util.Date fec_final;
	private Integer dias;
	private MotVisFalRRHH motivo_visita_fallo;
	private AparatoRRHH aparato;
	private EnfermedadRRHH enfermedad;
	private PrestMedidoRRHH prestador_medico;
	private String sintoma;
	private String observacion;
	private Boolean justifica;
	private Boolean activo;
	private java.util.Date fecAteMed;
	private MedicoRRHH medico;
	private FamiliarRRHH familiar;
	private java.util.Date fecAccidente;
	private String descAccidente;
	private java.util.Date fecControl;

	public String getTipo_serv_med() throws BaseException {
		supportRefresh();
		return tipo_serv_med;
	}

	public java.util.Date getFecControl() throws BaseException {
		supportRefresh();
		return this.fecControl;
	}

	public String getDescAccidente() throws BaseException {
		supportRefresh();
		return this.descAccidente;
	}

	public void setDescAccidente(String aDescAccidente) {
		this.descAccidente = aDescAccidente;
	}

	public void setFecControl(java.util.Date aFecControl) {
		this.fecControl = aFecControl;
	}

	public void setTipo_serv_med(String aTipo_serv_med) {
		this.tipo_serv_med = aTipo_serv_med;
	}

	public java.util.Date getFecAccidente() throws BaseException {
		supportRefresh();
		return this.fecAccidente;
	}

	public void setFecAccidente(java.util.Date aFecAccidente) {
		this.fecAccidente = aFecAccidente;
	}

	public FamiliarRRHH getFamiliar() throws BaseException {
		supportRefresh();
		return familiar;
	}

	public void setFamiliar(FamiliarRRHH aFamiliar) {
		this.familiar = aFamiliar;
	}

	public MedicoRRHH getMedico() throws BaseException {
		supportRefresh();
		return this.medico;
	}

	public void setMedico(MedicoRRHH aMedico) {
		this.medico = aMedico;
	}

	public java.util.Date getFecAteMed() throws BaseException {
		supportRefresh();
		return this.fecAteMed;
	}

	public void setFecAteMed(java.util.Date aFecAteMed) {
		this.fecAteMed = aFecAteMed;
	}

	public Legajo getLegajo() throws BaseException {
		supportRefresh();
		return legajo;
	}

	public void setLegajo(Legajo aLegajo) {
		this.legajo = aLegajo;
	}

	public Integer getNro_nov_sist_ext() throws BaseException {
		supportRefresh();
		return nro_nov_sist_ext;
	}

	public void setNro_nov_sist_ext(Integer aNro_nov_sist_ext) {
		this.nro_nov_sist_ext = aNro_nov_sist_ext;
	}

	public java.util.Date getFec_inicio() throws BaseException {
		supportRefresh();
		return fec_inicio;
	}

	public void setFec_inicio(java.util.Date aFec_inicio) {
		this.fec_inicio = aFec_inicio;
	}

	public java.util.Date getFec_final() throws BaseException {
		supportRefresh();
		return fec_final;
	}

	public void setFec_final(java.util.Date aFec_final) {
		this.fec_final = aFec_final;
	}

	public Integer getDias() throws BaseException {
		supportRefresh();
		return dias;
	}

	public void setDias(Integer aDias) {
		this.dias = aDias;
	}

	public MotVisFalRRHH getMotivo_visita_fallo() throws BaseException {
		supportRefresh();
		return motivo_visita_fallo;
	}

	public void setMotivo_visita_fallo(MotVisFalRRHH aMotivo_visita_fallo) {
		this.motivo_visita_fallo = aMotivo_visita_fallo;
	}

	public AparatoRRHH getAparato() throws BaseException {
		supportRefresh();
		return aparato;
	}

	public void setAparato(AparatoRRHH aAparato) {
		this.aparato = aAparato;
	}

	public EnfermedadRRHH getEnfermedad() throws BaseException {
		supportRefresh();
		return enfermedad;
	}

	public void setEnfermedad(EnfermedadRRHH aEnfermedad) {
		this.enfermedad = aEnfermedad;
	}

	public PrestMedidoRRHH getPrestador_medico() throws BaseException {
		supportRefresh();
		return prestador_medico;
	}

	public void setPrestador_medico(PrestMedidoRRHH aPrestador_medico) {
		this.prestador_medico = aPrestador_medico;
	}

	public String getSintoma() throws BaseException {
		supportRefresh();
		return sintoma;
	}

	public void setSintoma(String aSintoma) {
		this.sintoma = aSintoma;
	}

	public String getObservacion() throws BaseException {
		supportRefresh();
		return observacion;
	}

	public void setObservacion(String aObservacion) {
		this.observacion = aObservacion;
	}

	public Boolean isJustifica() throws BaseException {
		supportRefresh();
		return justifica;
	}

	public void setJustifica(Boolean aJustifica) {
		this.justifica = aJustifica;
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

	public static ServicioMedicoRRHH findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (ServicioMedicoRRHH) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static ServicioMedicoRRHH findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (ServicioMedicoRRHH) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(tipo_serv_med, "Debe ingresar el Tipo");
	}

	public static List getServMedByLegajo(Legajo aLegajo, ISesion aSesion) throws BaseException {
		return DBServicioMedicoRRHH.getServMedByLegajo(aLegajo, aSesion);
	}

	public static List getServMedByLegajoPedMed(Legajo aLegajo, ISesion aSesion) throws BaseException {
		return DBServicioMedicoRRHH.getServMedByLegajoPedMed(aLegajo, aSesion);
	}

	public static List getServMedByLegajoAteMed(Legajo aLegajo, ISesion aSesion) throws BaseException {
		return DBServicioMedicoRRHH.getServMedByLegajoAteMed(aLegajo, aSesion);
	}

	public static List getServMedByLegajoEnfFam(Legajo aLegajo, ISesion aSesion) throws BaseException {
		return DBServicioMedicoRRHH.getServMedByLegajoEnfFam(aLegajo, aSesion);
	}

	public static List getServMedByLegajoAccLab(Legajo aLegajo, ISesion aSesion) throws BaseException {
		return DBServicioMedicoRRHH.getServMedByLegajoAccLab(aLegajo, aSesion);
	}

	public static HashTableDatos getTiposServMedido() throws BaseException {
		HashTableDatos tipos = new HashTableDatos();
		tipos.put(SM_PEDMED, "Pedido Médico");
		tipos.put(SM_ATEMED, "Atención Médica");
		tipos.put(SM_ENFFAM, "Enfermedad Familiar");
		tipos.put(SM_ACCLAB, "Accidente Laboral");
		return tipos;

	}

	public static List getServMedByFiltroFecDesdeFecHasta(FiltroLegCab filtro, java.util.Date fecDesde, java.util.Date fecHasta, ISesion aSesion) throws BaseException {

		return DBServicioMedicoRRHH.getServMedByFiltroFecDesdeFecHasta(filtro, fecDesde, fecHasta, aSesion);
	}

}
