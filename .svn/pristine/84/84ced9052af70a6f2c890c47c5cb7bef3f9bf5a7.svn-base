package com.srn.erp.cip.bm;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.cip.da.DBTarjetaCIP;
import com.srn.erp.sueldos.bm.Legajo;
import com.srn.erp.ventas.bm.Sujeto;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.Fecha;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.Validar;

public class TarjetaCIP extends ObjetoLogico {

	public TarjetaCIP() {
	}
	
	private List documentacionReq = new ArrayList();
	private boolean readDocumentacionReq = true;
	
	private List rotasVisitas = new ArrayList();
	private boolean readRotasVisitas = true;

	public static final String TAR_HAB = "HABI";
	public static final String TAR_DES_HAB = "DESH";

	public static String NICKNAME = "cip.TarjetaCIP";
	
	public static final String TIPO_VIS_DIA = "DIA";
	public static final String TIPO_VIS_PERIODOS = "PERIODO";

	private String tipo_tarjeta;
	private String nro_tarjeta;
	private GrupoTarjeta grupo_tarjeta;
	private Boolean tiene_vig;
	private java.util.Date vig_desde;
	private java.util.Date vig_hasta;
	private String hora_desde;
	private String hora_hasta;
	private String estado_tarjeta;
	private Boolean activo;
	private MotivoBajaTarjeta motivo_baja_tarjeta;
	private Legajo legajo;
	private Visita visita;
	private Sujeto cliente;
	private java.util.Date fec_asig;
	private String hora_asig;
	private boolean paraVisita;
	private GrupoPuerta grupoPueAccVisi;
	private GrupoPuerta grupoPueEgrVisi;
	private CategAccesoCIP categoriaAccVisita;
	private Integer toleIngVisMin;
	private String tipoVisita;
	private PermisoSemanalCIP permisoSemanal;
	private boolean controlarAntiPassBack;
	
	public boolean isTipoVisitaDia() throws BaseException {
		if ((this.getTipoVisita()!=null) && (this.getTipoVisita().equals(TIPO_VIS_DIA)))
			return true;
		else
			return false;
	}
	
	public boolean isTipoVisitaPlanificada() throws BaseException {
		if ((this.getTipoVisita()!=null) && (this.getTipoVisita().equals(TIPO_VIS_PERIODOS)))
			return true;
		else
			return false;
	}
	
	public GrupoPuerta getGrupoPueAccVisita() throws BaseException {
		supportRefresh();
		return this.grupoPueAccVisi;
	}
	
	public String getNomyApeTarjAsig() throws BaseException {
		if (this.isTarjetaAsignada()) {
			String nombre = "";
			if (this.getVisita()!=null) nombre = "Visita "+this.getVisita().getApeyNom()+" Docu. "+this.getVisita().getNroDocumento(); 
			if (this.getLegajo()!=null) nombre = "Legajo "+ this.getLegajo().getApellidoyNombre()+" Legajo "+this.getLegajo().getNro_legajo();
			if (this.getCliente()!=null) nombre = "Cliente "+ this.getCliente().getRazon_social()+" Código "+this.getCliente().getCodigo();
			TarjetaLegajo tarjetaLegajo = TarjetaLegajo.getTarjetaLegajo(this.getNro_tarjeta(), this.getSesion());
			if ((tarjetaLegajo!=null) && (tarjetaLegajo.isActivo())) nombre = "Legajo "+ tarjetaLegajo.getLegajo().getApellidoyNombre()+" Legajo "+tarjetaLegajo.getLegajo().getNro_legajo();
			
			return nombre;
		}
		else
			return "";
	}
	
	public boolean isControlarAntiPassBack() throws BaseException {
		supportRefresh();
		return this.controlarAntiPassBack;
	}
	
	
	public PermisoSemanalCIP getPermisoSemanal() throws BaseException {
		supportRefresh();
		return this.permisoSemanal;
	}	
	
	public String getTipoVisita() throws BaseException {
		supportRefresh();
		return this.tipoVisita;
	}
	
	
	public Integer getToleranciaIngVisMin() throws BaseException {
		supportRefresh();
		if (this.toleIngVisMin == null)
			return new Integer(0);
		else
			return this.toleIngVisMin;
	}
	
	public void setToleranciaIngVisMin(Integer aToleranciaIngVisMin) throws BaseException {
		this.toleIngVisMin = aToleranciaIngVisMin;
	}
	
	public void setControlarAntiPassBack(boolean aControlarAntiPassBack) throws BaseException {
		this.controlarAntiPassBack = aControlarAntiPassBack;
	}
	
	
	public void setPermisoSemanal(PermisoSemanalCIP aPermisoSemanalCIP) throws BaseException {
		this.permisoSemanal = aPermisoSemanalCIP;
	}
	
	public CategAccesoCIP getCategAccesoVisita() throws BaseException {
		supportRefresh();
		return this.categoriaAccVisita;
	}
	
	
	public void setGrupoPueAccVisita(GrupoPuerta aGrupoPuertaAccVisita) throws BaseException {
		this.grupoPueAccVisi = aGrupoPuertaAccVisita;
	}

	public void setTipoVisita(String aTipoVisita) throws BaseException {
		this.tipoVisita = aTipoVisita;
	}
	
	public void setCategAccesoVisita(CategAccesoCIP aCategAccesoCIP) throws BaseException {
		this.categoriaAccVisita = aCategAccesoCIP;
	}
	
	
	public GrupoPuerta getGrupoPueEgrVisita() throws BaseException {
		supportRefresh();
		return this.grupoPueEgrVisi;
	}
	
	public void setGrupoPueEgrVisita(GrupoPuerta aGrupoPuertaEgrVisita) throws BaseException {
		this.grupoPueEgrVisi = aGrupoPuertaEgrVisita;
	}
	
	public String getTipo_tarjeta() throws BaseException {
		supportRefresh();
		return tipo_tarjeta;
	}
	
	public boolean isParaVisita() throws BaseException {
		supportRefresh();
		return this.paraVisita;
	}
	

	public void setTipo_tarjeta(String aTipo_tarjeta) {
		this.tipo_tarjeta = aTipo_tarjeta;
	}
	
	public void setIsParaVisita(boolean aIsParaVisita) {
		this.paraVisita = aIsParaVisita;
	}
	

	public String getNro_tarjeta() throws BaseException {
		supportRefresh();
		return nro_tarjeta;
	}

	public void setNro_tarjeta(String aNro_tarjeta) throws ExceptionValidation {
		if (nro_tarjeta!=null) {
			try {
			int pasadoANro = Integer.parseInt(aNro_tarjeta);
			this.nro_tarjeta = pasadoANro+"";
			} catch (Exception e) {
				throw new ExceptionValidation(null,"La tarjeta debe ser un valor numérico");
			}
		} else
			this.nro_tarjeta = aNro_tarjeta;
		
		
	}

	public GrupoTarjeta getGrupo_tarjeta() throws BaseException {
		supportRefresh();
		return grupo_tarjeta;
	}

	public void setGrupo_tarjeta(GrupoTarjeta aGrupo_tarjeta) {
		this.grupo_tarjeta = aGrupo_tarjeta;
	}

	public Boolean isTiene_vig() throws BaseException {
		supportRefresh();
		if (tiene_vig==null)
			return false;
		else
			return tiene_vig;
	}

	public void setTiene_vig(Boolean aTiene_vig) {
		this.tiene_vig = aTiene_vig;
	}

	public java.util.Date getVig_desde() throws BaseException {
		supportRefresh();
		return vig_desde;
	}

	public void setVig_desde(java.util.Date aVig_desde) {
		this.vig_desde = aVig_desde;
	}

	public java.util.Date getVig_hasta() throws BaseException {
		supportRefresh();
		return vig_hasta;
	}

	public void setVig_hasta(java.util.Date aVig_hasta) {
		this.vig_hasta = aVig_hasta;
	}

	public String getHora_desde() throws BaseException {
		supportRefresh();
		return hora_desde;
	}

	public void setHora_desde(String aHora_desde) {
		this.hora_desde = aHora_desde;
	}

	public String getHora_hasta() throws BaseException {
		supportRefresh();
		return hora_hasta;
	}

	public void setHora_hasta(String aHora_hasta) {
		this.hora_hasta = aHora_hasta;
	}

	public String getEstado_tarjeta() throws BaseException {
		supportRefresh();
		return estado_tarjeta;
	}

	public void setEstado_tarjeta(String aEstado_tarjeta) {
		this.estado_tarjeta = aEstado_tarjeta;
	}

	public Boolean isActivo() throws BaseException {
		supportRefresh();
		return activo;
	}

	public void setActivo(Boolean aActivo) {
		this.activo = aActivo;
	}

	public MotivoBajaTarjeta getMotivo_baja_tarjeta() throws BaseException {
		supportRefresh();
		return motivo_baja_tarjeta;
	}

	public void setMotivo_baja_tarjeta(MotivoBajaTarjeta aMotivo_baja_tarjeta) {
		this.motivo_baja_tarjeta = aMotivo_baja_tarjeta;
	}

	public Legajo getLegajo() throws BaseException {
		supportRefresh();
		return legajo;
	}

	public void setLegajo(Legajo aLegajo) {
		this.legajo = aLegajo;
	}

	public Visita getVisita() throws BaseException {
		supportRefresh();
		return visita;
	}

	public void setVisita(Visita aVisita) {
		this.visita = aVisita;
	}

	public Sujeto getCliente() throws BaseException {
		supportRefresh();
		return cliente;
	}

	public void setCliente(Sujeto aCliente) {
		this.cliente = aCliente;
	}

	public java.util.Date getFec_asig() throws BaseException {
		supportRefresh();
		return fec_asig;
	}

	public void setFec_asig(java.util.Date aFec_asig) {
		this.fec_asig = aFec_asig;
	}

	public String getHora_asig() throws BaseException {
		supportRefresh();
		return hora_asig;
	}

	public void setHora_asig(String aHora_asig) {
		this.hora_asig = aHora_asig;
	}

	public String getNickName() {
		return NICKNAME;
	}

	public static TarjetaCIP findByOid(Integer oid, ISesion aSesion)
			throws BaseException {
		return (TarjetaCIP) getObjectByOid(NICKNAME, oid, aSesion);
	}
	
	public static TarjetaCIP findByOidProxy(Integer oid, ISesion aSesion)
	throws BaseException {
		return (TarjetaCIP) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}
	

	public static TarjetaCIP findByCodigo(String codigo, ISesion aSesion)
			throws BaseException {
		return (TarjetaCIP) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(tipo_tarjeta, "Debe ingresar el Tipo de Tarjeta");
		Validar.noNulo(nro_tarjeta, "Debe ingresar el Nro. de Tarjeta");
		Validar.noNulo(grupo_tarjeta, "Debe ingresar el Grupo de Tarjeta");
		Validar.noNulo(estado_tarjeta, "Debe ingresar el estado");
		if (this.isParaVisita())
			if ((this.getTipoVisita()==null) || (this.getTipoVisita().length()==0))
				throw new ExceptionValidation(null,"Debe seleccionar el tipo de Visita.");
	}
	

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public static HashTableDatos getHabilitaciones() throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put(TAR_HAB, "Habilitada");
		condiciones.put(TAR_DES_HAB, "Inhabilitada");
		return condiciones;
	}

	public static TarjetaCIP getTarjetaCIP(String nroTarjeta, ISesion aSesion)
			throws BaseException {
		return DBTarjetaCIP.getTarjetaCIP(nroTarjeta, aSesion);
	}
	
	public boolean isTarjetaHabilitada() throws BaseException {
		if (this.getEstado_tarjeta()==null) return false;
		if (this.getEstado_tarjeta().equals(TAR_HAB))
			return true;
		else
			return false;
	}
	
	public boolean isTarjetaDesHabilitada() throws BaseException {
		if (this.getEstado_tarjeta()==null) return false;
		if (this.getEstado_tarjeta().equals(TAR_DES_HAB) || (this.isActivo()==false))
			return true;
		else
			return false;
	}
	
	public List getDocumentacionRequerida() throws BaseException {
		if (this.readDocumentacionReq) {
		      List listaDocuReq = DocuRequeridaCIP.getDocuRequerida(this,getSesion());
		      this.documentacionReq.addAll(listaDocuReq);
		      this.readDocumentacionReq = false;
		}
		return documentacionReq;
	}

	public void addDocuReque(DocuRequeridaCIP aDocuRequeridaCIP) throws BaseException {
		aDocuRequeridaCIP.setTarjeta(this);
		this.documentacionReq.add(aDocuRequeridaCIP);
	}
	
	public void addRotaVisita(TarjetaRotaVisita aTarjetaRotaVisita) throws BaseException {
		aTarjetaRotaVisita.setTarjeta(this);
		this.rotasVisitas.add(aTarjetaRotaVisita);
	}
	

	public void afterSave() throws BaseException {
		
		Iterator iterDocuReq = this.documentacionReq.iterator();
		while (iterDocuReq.hasNext()) {
		      DocuRequeridaCIP docuReq = (DocuRequeridaCIP) iterDocuReq.next();
		      docuReq.save();
		      docuReq = null;
		}
		iterDocuReq = null;
		Iterator iterRotas = this.rotasVisitas.iterator();
		while (iterRotas.hasNext()) {
		      TarjetaRotaVisita tarjetaRotaVisita = (TarjetaRotaVisita) iterRotas.next();
		      tarjetaRotaVisita.save();
		      tarjetaRotaVisita = null;
		}
		iterRotas = null;
		
	}
	
	public static HashTableDatos getTiposVisitas() throws BaseException {
		HashTableDatos tipos= new HashTableDatos();
		tipos.put(TIPO_VIS_DIA,"Visita del día");
		tipos.put(TIPO_VIS_PERIODOS,"Visita del período de Vigencia de la Tarjeta");
		return tipos;
	}
	
	public List getTarjetasRotaVisita(java.util.Date fecha) throws BaseException {
		  return TarjetaRotaVisita.getTarjetasRotaVisita(this,fecha,this.getSesion());
	}

	public static TarjetaCIP getTarjetaCIP(Visita visita,
	          ISesion aSesion)
	          throws BaseException {
		  return DBTarjetaCIP.getTarjetaCIP(visita,aSesion);
	}
	
	public boolean isVigentaAFecHora(java.util.Date aFecHor) throws BaseException {
		if (isTiene_vig()==false) return true;
		
		if ((getVig_desde() == null) || 
				(getVig_hasta() == null) || 
				(getHora_desde() == null) || 
				(getHora_hasta() == null)) return true;
		
		int hora1 = UtilCIP.getParteHoraEnHoras(getHora_desde());
		int minuto1 = UtilCIP.getParteMinutosEnMinutos(getHora_desde());

		int hora2 = UtilCIP.getParteHoraEnHoras(getHora_hasta());
		int minuto2 = UtilCIP.getParteMinutosEnMinutos(getHora_hasta());

		Calendar calFecVigDesde = GregorianCalendar.getInstance(); 
		calFecVigDesde.setTime(getVig_desde()); 
		calFecVigDesde.set(Calendar.HOUR_OF_DAY, hora1); // 
		calFecVigDesde.set(Calendar.MINUTE, minuto1); // 
		calFecVigDesde.set(Calendar.SECOND, 0); // 
		calFecVigDesde.set(Calendar.MILLISECOND, 0); 

		Calendar calFecVigHasta = GregorianCalendar.getInstance(); 
		calFecVigHasta.setTime(getVig_hasta()); 
		calFecVigHasta.set(Calendar.HOUR_OF_DAY, hora2); 
		calFecVigHasta.set(Calendar.MINUTE, minuto2); 
		calFecVigHasta.set(Calendar.SECOND, 0); 
		calFecVigHasta.set(Calendar.MILLISECOND, 0); 
		
		if (Fecha.isFechaEntre(aFecHor, calFecVigDesde.getTime(), calFecVigHasta.getTime())) return true;
		
		return false;
	}
	
	public boolean isTarjetaAsignada() throws BaseException {
		if (this.getVisita()!=null) return true;
		if (this.getLegajo()!=null) return true;
		if (this.getCliente()!=null) return true;
		TarjetaLegajo tarjetaLegajo = TarjetaLegajo.getTarjetaLegajo(this.getNro_tarjeta(), this.getSesion());
		if ((tarjetaLegajo!=null) && (tarjetaLegajo.isActivo())) return true;
		return false;
	}

	
	public static TarjetaCIP getTarjetaCIPActiva(String nroTarjeta,
	          ISesion aSesion)
	          throws BaseException {
		  return DBTarjetaCIP.getTarjetaCIPActiva(nroTarjeta,aSesion);
	}
	
	public TarjetaRotaVisita getTarjetaRotaVisita(
			  java.util.Date fecha)
	          throws BaseException {
		  return TarjetaRotaVisita.getTarjetaRotaVisita(this,fecha,this.getSesion());
	}
	
	public void devolverla(boolean ejecutarValidaciones) throws BaseException {
	
		if (this.getVisita()!=null)
			devolverTarjVisita(ejecutarValidaciones);
	}
	
	private void devolverTarjVisita(boolean ejecutarValidaciones) throws BaseException {
		
		// Verificar que la visita se encuentre afuera
		if (ejecutarValidaciones) {
			if ((this.getVisita().getZonaActual()!=null) && (!this.getVisita().getZonaActual().esExterna())) 
				throw new ExceptionValidation(null,"Para poder devolver la tarjeta la Visita debe salir del predio.");
		}
		
		// Desasignar la tarjeta de la Visita
	    this.setVisita(null);
	    this.save();

	    // Desactivar los permisos de la Tarjeta
	    PermisoVisita.desactivarPermisosTarjeta(this, this.getSesion());
	    
	}
	
	public void informarTarjPerdida() throws BaseException {

		// Verificar que la visita se encuentre afuera
		if ((this.getVisita().getZonaActual()!=null) && (!this.getVisita().getZonaActual().esExterna())) 
			throw new ExceptionValidation(null,"Para poder informar una tarjeta como perdida la Visita debe salir del predio.");

	    // Desactivar los permisos de la Tarjeta
	    PermisoVisita.desactivarPermisosTarjeta(this, this.getSesion());
		
		// Desasignar la tarjeta de la Visita
	    this.setVisita(null);
	    this.setEstado_tarjeta(TAR_DES_HAB);
	    this.setMotivo_baja_tarjeta(MotivoBajaTarjeta.getMotivoPerdioTarjeta(this.getSesion()));
	    this.save();
		
	}
	
	
}
