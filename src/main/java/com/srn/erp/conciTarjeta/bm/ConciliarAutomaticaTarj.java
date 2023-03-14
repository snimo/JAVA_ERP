package com.srn.erp.conciTarjeta.bm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.cip.bm.UtilCIP;

import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.Fecha;
import framework.applicarionServer.bm.Seguridad.Usuario;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;

public class ConciliarAutomaticaTarj {
	
	public static String CA_VISA = "VISA";
	public static String CA_VISA_DEBITO = "VISA DEBITO";
	public static String CA_AMERICAN  = "AMEX";
	public static String CA_MASTERCARD  = "MASTERCARD";
	public static String CA_MAESTRO  = "MAESTRO";
	public static String CA_ARGENCARD  = "ARGENCARD";
	
	ISesion sesion;
	EmpresaConciTar empresa;
	List listaTarjAConci = new ArrayList();
	Integer nroCorrida = new Integer(0);
	int nroCuponesConci = 0;
	int cupProcesados = 0;
	
	public Integer getNroCorrida() {
		return this.nroCorrida;
	}
	
	public int getNroCuponesConci() {
		return nroCuponesConci;
	}
	
	public int getNroCuponesProcesados() {
		return cupProcesados;
	}	
	
	public void addTarjAConci(String codigo) {
		listaTarjAConci.add(codigo);
	}

	public EmpresaConciTar getEmpresa() {
		return empresa;
	}

	public void setEmpresa(EmpresaConciTar empresa) {
		this.empresa = empresa;
	}

	public ISesion getSesion() {
		return sesion;
	}

	public void setSesion(ISesion sesion) {
		this.sesion = sesion;
	}
	
	public boolean conciliar() throws BaseException {
		
		CabConciAutomatica cabConciAut = 
			(CabConciAutomatica)CabConciAutomatica.getNew(CabConciAutomatica.NICKNAME, this.getSesion());
		cabConciAut.setFecha(UtilCIP.getFechaHoraActual(this.getSesion()));
		cabConciAut.setHora(Fecha.getHoraActual());
		Usuario usuario = Usuario.findByOidProxy(this.getSesion().getLogin().getUsuario().getOIDInteger(), this.getSesion());
		cabConciAut.setUsuario(usuario);
		cabConciAut.setActivo(true);
		cabConciAut.save();
		
		nroCorrida =  cabConciAut.getOIDInteger();
		
		if (this.listaTarjAConci.contains(CA_VISA))
			conciliarVISA(cabConciAut);
		
		if (this.listaTarjAConci.contains(CA_VISA_DEBITO))
			conciliarVISADEBITO(cabConciAut);
		
		if (this.listaTarjAConci.contains(CA_AMERICAN))
			conciliarAmericanExpress(cabConciAut);		
		
		if (this.listaTarjAConci.contains(CA_MASTERCARD))
			conciliarMastercard(cabConciAut);		
		
		if (this.listaTarjAConci.contains(CA_MAESTRO))
			conciliarMaestro(cabConciAut);		
		
		if (this.listaTarjAConci.contains(CA_ARGENCARD))
			conciliarArgencard(cabConciAut);		
		
		
		return true;
	}
	
	private void conciliarVISA(CabConciAutomatica cabConciAut) throws BaseException {
			
		int diaTolConci = 0;
		int diasTolConciOK = 0;
		
		TarjetaConciTar tarjVISA = 
			TarjetaConciTar.getTarjetaVISACREDITO(this.getSesion());
		if (tarjVISA!=null) { 
			if (tarjVISA.getToleranciaDiasFecConci()!=null)
				diaTolConci = tarjVISA.getToleranciaDiasFecConci();
			if (tarjVISA.getTolDiasConciOK()!=null)
				diasTolConciOK = tarjVISA.getTolDiasConciOK();			
		}
		
		Iterator iterTarjPendPreconci = 
			this.getEmpresa().getTarjEntidadesPendPreconci(CA_VISA).iterator();
		while (iterTarjPendPreconci.hasNext()) {
			
			// Obtener cupon pendiente de conciliar 
			DetTarConciEnt detTarConciEnt = (DetTarConciEnt) iterTarjPendPreconci.next();
			
			++cupProcesados;
			
			boolean dudoso = false;
			
			// Obtener el cupon del POSNET que machea con el de la tarjeta de credito
			ArchLoteConciDet archLoteConciDet  =
				ArchLoteConciDet.getArchLoteConciDet(
						this.getEmpresa(),
						"*",
						detTarConciEnt.getTipoTarjeta(),
						detTarConciEnt.getFec_origen(),
						detTarConciEnt.getTarjeta(),
						detTarConciEnt.getNro_tarjeta(),
						detTarConciEnt.getImporte().doubleValue(),
						detTarConciEnt.getLote(),
						diasTolConciOK,
						this.getSesion());
			
			if (archLoteConciDet==null) { 
				archLoteConciDet  =
					ArchLoteConciDet.getArchLoteConciDet(
							this.getEmpresa(),
							"*",
							TarjetaConciTar.TIPO_TARJ_DEB,
							detTarConciEnt.getFec_origen(),
							ConciliarAutomaticaTarj.CA_VISA_DEBITO,
							detTarConciEnt.getNro_tarjeta(),
							detTarConciEnt.getImporte().doubleValue(),
							detTarConciEnt.getLote(),
							diaTolConci,
							this.getSesion());
				dudoso = true;
			}
			
			if (archLoteConciDet!=null) {
				// Si entra aca es porque hay coincidencia en la conciliacion
				int proxNroConciliacion = empresa.getProxNroConci();
				++nroCuponesConci;
				detTarConciEnt.generarPreconciliacion(proxNroConciliacion,cabConciAut,dudoso);
				archLoteConciDet.generarPreconciliacion(proxNroConciliacion,cabConciAut,dudoso);
			}
		}
	}
	
	
	
	private void conciliarArgencard(CabConciAutomatica cabConciAut) throws BaseException {
		
		int diaTolConci = 0;
		int diasTolConciOK = 0;
		
		TarjetaConciTar tarjARGENCARD = 
			TarjetaConciTar.getTarjetaARGENCARD(this.getSesion());
		if (tarjARGENCARD!=null) { 
			if (tarjARGENCARD.getToleranciaDiasFecConci()!=null)
				diaTolConci = tarjARGENCARD.getToleranciaDiasFecConci();
			if (tarjARGENCARD.getTolDiasConciOK()!=null)
				diasTolConciOK = tarjARGENCARD.getTolDiasConciOK();						
		}
		
		// Conciliacion MASTERCARD
		Iterator iterTarjPendPreconci = 
			this.getEmpresa().getTarjEntidadesPendPreconci(CA_ARGENCARD).iterator();
		while (iterTarjPendPreconci.hasNext()) {
			
			// Obtener cupon pendiente de conciliar 
			DetTarConciEnt detTarConciEnt = (DetTarConciEnt) iterTarjPendPreconci.next();
			
			++cupProcesados;
			
			boolean dudoso = false;
			
			// Obtener el cupon del POSNET que machea con el de la tarjeta de credito
			ArchLoteConciDet archLoteConciDet  =
				ArchLoteConciDet.getArchLoteConciDet(
						this.getEmpresa(),
						"*",
						detTarConciEnt.getTipoTarjeta(),
						detTarConciEnt.getFec_origen(),
						detTarConciEnt.getTarjeta(),
						detTarConciEnt.getNro_tarjeta(),
						detTarConciEnt.getImporte().doubleValue(),
						diasTolConciOK,
						this.getSesion());
			
			
			if (archLoteConciDet == null) { 
				archLoteConciDet  =
					ArchLoteConciDet.getArchLoteConciDet(
							this.getEmpresa(),
							"*",
							detTarConciEnt.getTipoTarjeta(),
							detTarConciEnt.getFec_origen(),
							detTarConciEnt.getTarjeta(),
							detTarConciEnt.getImporte().doubleValue(),
							diaTolConci,
							this.getSesion());
				dudoso = true;
			}
			
			if (archLoteConciDet!=null) {
				// Si entra aca es porque hay coincidencia en la conciliacion
				int proxNroConciliacion = empresa.getProxNroConci();
				++nroCuponesConci;
				detTarConciEnt.generarPreconciliacion(proxNroConciliacion,cabConciAut,dudoso);
				archLoteConciDet.generarPreconciliacion(proxNroConciliacion,cabConciAut,dudoso);
			}
			
		}
		
	}	
	
	private void conciliarMaestro(CabConciAutomatica cabConciAut) throws BaseException {
		
		int diaTolConci = 0;
		int diasTolConciOK = 0;
		
		TarjetaConciTar tarjMAESTRO = 
			TarjetaConciTar.getTarjetaMAESTRO(this.getSesion());
		if (tarjMAESTRO!=null) { 
			if (tarjMAESTRO.getToleranciaDiasFecConci()!=null)
				diaTolConci = tarjMAESTRO.getToleranciaDiasFecConci();
			if (tarjMAESTRO.getTolDiasConciOK()!=null)
				diasTolConciOK = tarjMAESTRO.getTolDiasConciOK();			
		}
		
		// Conciliacion MAESTRO
		Iterator iterTarjPendPreconci = 
			this.getEmpresa().getTarjEntidadesPendPreconci(CA_MAESTRO).iterator();
		while (iterTarjPendPreconci.hasNext()) {
			
			// Obtener cupon pendiente de conciliar 
			DetTarConciEnt detTarConciEnt = (DetTarConciEnt) iterTarjPendPreconci.next();
			
			++cupProcesados;
			
			boolean dudoso = false;
			
			// Obtener el cupon del POSNET que machea con el de la tarjeta de Debito
			ArchLoteConciDet archLoteConciDet  =
				ArchLoteConciDet.getArchLoteConciDet(
						this.getEmpresa(),
						"*",
						detTarConciEnt.getTipoTarjeta(),
						detTarConciEnt.getFec_origen(),
						detTarConciEnt.getTarjeta(),
						detTarConciEnt.getNro_tarjeta(),
						detTarConciEnt.getImporte().doubleValue(),
						diasTolConciOK,
						this.getSesion());
			
			
			if (archLoteConciDet == null) {
				
				archLoteConciDet  =
					// Buscar sin utilizar el Nro. de tarjeta
					ArchLoteConciDet.getArchLoteConciDet(
							this.getEmpresa(),
							"*",
							detTarConciEnt.getTipoTarjeta(),
							detTarConciEnt.getFec_origen(),
							detTarConciEnt.getTarjeta(),
							detTarConciEnt.getImporte().doubleValue(),
							diasTolConciOK,
							this.getSesion());
				
				if (archLoteConciDet==null) {
					archLoteConciDet  =
					// Buscar sin utilizar el Nro. de tarjeta
					ArchLoteConciDet.getArchLoteConciDet(
							this.getEmpresa(),
							"*",
							detTarConciEnt.getTipoTarjeta(),
							detTarConciEnt.getFec_origen(),
							detTarConciEnt.getTarjeta(),
							detTarConciEnt.getImporte().doubleValue(),
							diaTolConci,
							this.getSesion());				
				
							dudoso = true;
				}
				
			}
				
			
			
			if (archLoteConciDet!=null) {
				// Si entra aca es porque hay coincidencia en la conciliacion
				int proxNroConciliacion = empresa.getProxNroConci();
				++nroCuponesConci;
				detTarConciEnt.generarPreconciliacion(proxNroConciliacion,cabConciAut,dudoso);
				archLoteConciDet.generarPreconciliacion(proxNroConciliacion,cabConciAut,dudoso);
			}
			
		}
		
	}	
	
	
	
	private void conciliarMastercard(CabConciAutomatica cabConciAut) throws BaseException {
		
		int diaTolConci = 0;
		int diasTolConciOK = 0;
		
		TarjetaConciTar tarjMASTER = 
			TarjetaConciTar.getTarjetaMASTER(this.getSesion());
		if (tarjMASTER!=null) { 
			if (tarjMASTER.getToleranciaDiasFecConci()!=null)
				diaTolConci = tarjMASTER.getToleranciaDiasFecConci();
			if (tarjMASTER.getTolDiasConciOK()!=null)
				diasTolConciOK = tarjMASTER.getTolDiasConciOK();			
		}
		
		// Conciliacion MASTERCARD
		Iterator iterTarjPendPreconci = 
			this.getEmpresa().getTarjEntidadesPendPreconci(CA_MASTERCARD).iterator();
		while (iterTarjPendPreconci.hasNext()) {
			
			// Obtener cupon pendiente de conciliar 
			DetTarConciEnt detTarConciEnt = (DetTarConciEnt) iterTarjPendPreconci.next();
			
			++cupProcesados;
			
			boolean dudoso = false;
			
			// Obtener el cupon del POSNET que machea con el de la tarjeta de credito
			ArchLoteConciDet archLoteConciDet  =
				ArchLoteConciDet.getArchLoteConciDet(
						this.getEmpresa(),
						"*",
						detTarConciEnt.getTipoTarjeta(),
						detTarConciEnt.getFec_origen(),
						detTarConciEnt.getTarjeta(),
						detTarConciEnt.getNro_tarjeta(),
						detTarConciEnt.getImporte().doubleValue(),
						diasTolConciOK,
						this.getSesion());
			
			
			if (archLoteConciDet == null) {
				
				archLoteConciDet  =
					ArchLoteConciDet.getArchLoteConciDet(
							this.getEmpresa(),
							"*",
							detTarConciEnt.getTipoTarjeta(),
							detTarConciEnt.getFec_origen(),
							detTarConciEnt.getTarjeta(),
							detTarConciEnt.getImporte().doubleValue(),
							diasTolConciOK,
							this.getSesion());
				
				if (archLoteConciDet == null) {
					
					archLoteConciDet  =
						ArchLoteConciDet.getArchLoteConciDet(
								this.getEmpresa(),
								"*",
								detTarConciEnt.getTipoTarjeta(),
								detTarConciEnt.getFec_origen(),
								detTarConciEnt.getTarjeta(),
								detTarConciEnt.getImporte().doubleValue(),
								diaTolConci,
								this.getSesion());
					dudoso = true;
					
				}
				
				dudoso = true;
				
			}
			
			
			if (archLoteConciDet!=null) {
				// Si entra aca es porque hay coincidencia en la conciliacion
				int proxNroConciliacion = empresa.getProxNroConci();
				++nroCuponesConci;
				detTarConciEnt.generarPreconciliacion(proxNroConciliacion,cabConciAut,dudoso);
				archLoteConciDet.generarPreconciliacion(proxNroConciliacion,cabConciAut,dudoso);
			}
			
		}
		
	}	
	
	
	private void conciliarAmericanExpress(CabConciAutomatica cabConciAut) throws BaseException {
		
		int diaTolConci = 0;
		int diasTolConciOK = 0;
		
		TarjetaConciTar tarjAMEX = 
			TarjetaConciTar.getTarjetaAMEX(this.getSesion());
		if (tarjAMEX!=null) { 
			if (tarjAMEX.getToleranciaDiasFecConci()!=null)
				diaTolConci = tarjAMEX.getToleranciaDiasFecConci();
			if (tarjAMEX.getTolDiasConciOK()!=null)
				diasTolConciOK = tarjAMEX.getTolDiasConciOK();			
		}
		
		// Conciliacion de AMERICAN EXPRESS
		Iterator iterTarjPendPreconci = 
			this.getEmpresa().getTarjEntidadesPendPreconci(CA_AMERICAN).iterator();
		while (iterTarjPendPreconci.hasNext()) {
			
			// Obtener cupon pendiente de conciliar 
			DetTarConciEnt detTarConciEnt = (DetTarConciEnt) iterTarjPendPreconci.next();
			
			++cupProcesados;
			
			boolean dudoso = false;
			
			// Obtener el cupon del POSNET que machea con el de la tarjeta de credito
			ArchLoteConciDet archLoteConciDet  =
				ArchLoteConciDet.getArchLoteConciDet(
						this.getEmpresa(),
						"*",
						detTarConciEnt.getTipoTarjeta(),
						detTarConciEnt.getFec_origen(),
						detTarConciEnt.getTarjeta(),
						detTarConciEnt.getNro_tarjeta(),
						detTarConciEnt.getImporte().doubleValue(),
						diasTolConciOK,
						this.getSesion());
			
			
			if (archLoteConciDet == null) {
				dudoso = true;
				ArchLoteConciDet.getArchLoteConciDet(
						this.getEmpresa(),
						"*",
						detTarConciEnt.getTipoTarjeta(),
						detTarConciEnt.getFec_origen(),
						detTarConciEnt.getTarjeta(),
						detTarConciEnt.getNro_tarjeta(),
						detTarConciEnt.getImporte().doubleValue(),
						diaTolConci,
						this.getSesion());
			}			
			
			if (archLoteConciDet!=null) {
				// Si entra aca es porque hay coincidencia en la conciliacion
				int proxNroConciliacion = empresa.getProxNroConci();
				++nroCuponesConci;
				detTarConciEnt.generarPreconciliacion(proxNroConciliacion,cabConciAut,dudoso);
				archLoteConciDet.generarPreconciliacion(proxNroConciliacion,cabConciAut,dudoso);
			}
			
		}
		
	}
	
	private void conciliarVISADEBITO(CabConciAutomatica cabConciAut) throws BaseException {
		
		
		int diaTolConci = 0;
		int diasTolConciOK = 0;
		
		TarjetaConciTar tarjVISA = 
			TarjetaConciTar.getTarjetaVISADEBITO(this.getSesion());
		if (tarjVISA!=null) { 
			if (tarjVISA.getToleranciaDiasFecConci()!=null)
				diaTolConci = tarjVISA.getToleranciaDiasFecConci();
			if (tarjVISA.getTolDiasConciOK()!=null)
				diasTolConciOK = tarjVISA.getTolDiasConciOK();			
		}
		
		
		// Conciliacion de VISA DEBITO
		Iterator iterTarjPendPreconci = 
			this.getEmpresa().getTarjEntidadesPendPreconci(CA_VISA_DEBITO).iterator();
		while (iterTarjPendPreconci.hasNext()) {
			
			// Obtener cupon pendiente de conciliar 
			DetTarConciEnt detTarConciEnt = (DetTarConciEnt) iterTarjPendPreconci.next();
			
			++cupProcesados;
			
			boolean dudoso = false;
			
			// Obtener el cupon del POSNET que machea con el de la tarjeta de credito
			ArchLoteConciDet archLoteConciDet  =
				ArchLoteConciDet.getArchLoteConciDet(
						this.getEmpresa(),
						"*",
						detTarConciEnt.getTipoTarjeta(),
						detTarConciEnt.getFec_origen(),
						detTarConciEnt.getTarjeta(),
						detTarConciEnt.getNro_tarjeta(),
						detTarConciEnt.getImporte().doubleValue(),
						detTarConciEnt.getLote(),
						diasTolConciOK,
						this.getSesion());
			
			
			if (archLoteConciDet==null) { 
				archLoteConciDet  =
					ArchLoteConciDet.getArchLoteConciDet(
							this.getEmpresa(),
							"*",
							TarjetaConciTar.TIPO_TARJ_CRE,
							detTarConciEnt.getFec_origen(),
							ConciliarAutomaticaTarj.CA_VISA,
							detTarConciEnt.getNro_tarjeta(),
							detTarConciEnt.getImporte().doubleValue(),
							detTarConciEnt.getLote(),
							diaTolConci,
							this.getSesion());
				dudoso = true;
			}
				
			if (archLoteConciDet!=null) {
				// Si entra aca es porque hay coincidencia en la conciliacion
				int proxNroConciliacion = empresa.getProxNroConci();
				++nroCuponesConci;
				detTarConciEnt.generarPreconciliacion(proxNroConciliacion,cabConciAut,dudoso);
				archLoteConciDet.generarPreconciliacion(proxNroConciliacion,cabConciAut,dudoso);
			}
			
		}
	}	
	
	public static HashTableDatos getTarjetas() throws BaseException {
		HashTableDatos tarjetas = new HashTableDatos();
		tarjetas.put(CA_VISA, "Visa");
		tarjetas.put(CA_VISA_DEBITO,"Visa Debito");
		tarjetas.put(CA_AMERICAN,"American Express");
		tarjetas.put(CA_MASTERCARD,"Mastercard");
		tarjetas.put(CA_MAESTRO,"Maestro");
		tarjetas.put(CA_ARGENCARD,"Argencard");
		return tarjetas;
	}
	
}
