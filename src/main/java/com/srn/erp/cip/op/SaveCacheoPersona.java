package com.srn.erp.cip.op;

import com.srn.erp.cip.bm.Cacheo;
import com.srn.erp.cip.bm.CacheoPersona;
import com.srn.erp.cip.bm.PersonalSeguridad;
import com.srn.erp.cip.bm.ResultadoCacheo;
import com.srn.erp.cip.bm.UtilCIP;
import com.srn.erp.sueldos.bm.Legajo;

import framework.applicarionServer.bl.Utils.Fecha;
import framework.applicarionServer.bm.Seguridad.Usuario;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;

public class SaveCacheoPersona extends Operation {

	public SaveCacheoPersona() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		
		boolean actuEntrada = false;
		boolean actuSalida = false;
		
		// Alta de Cacheo
		CacheoPersona cacheoPersona = 
			(CacheoPersona) CacheoPersona.getNew(CacheoPersona.NICKNAME, this.getSesion());
		cacheoPersona.setLegajo(Legajo.findByOidProxy(mapaDatos.getInteger("oid_legajo"), this.getSesion()));
		cacheoPersona.setFecha(Fecha.getFechaActual());
		cacheoPersona.setHora(Fecha.getHoraActual());
		cacheoPersona.setObservacion(mapaDatos.getString("observacion"));
		cacheoPersona.setPersonalSeguridad(PersonalSeguridad.findByOidProxy(mapaDatos.getInteger("oid_pers_seg"), this.getSesion()));
		cacheoPersona.setResultadoCacheo(ResultadoCacheo.findByOidProxy(mapaDatos.getInteger("oid_resultado"), this.getSesion()));
		
		cacheoPersona.setActivo(true);
		
		this.addTransaccion(cacheoPersona);
		
		// Marcar los cacheos como realizados
		Cacheo cacheoEntrada = 
			Cacheo.getCacheoPend(
				mapaDatos.getInteger("oid_legajo"), 
				UtilCIP.getFechaHoraActual(this.getSesion()), 
				"E", 
				this.getSesion());
		
		Cacheo cacheoSalida = 
			Cacheo.getCacheoPend(
				mapaDatos.getInteger("oid_legajo"), 
				UtilCIP.getFechaHoraActual(this.getSesion()), 
				"S", 
				this.getSesion());
		
		if ((cacheoEntrada!=null) && (cacheoEntrada.isIntentoDePase())) {
			cacheoEntrada.setCacheoPersona(cacheoPersona);
			cacheoEntrada.setRealizado(true);
			cacheoEntrada.setNo_realizado(false);
			cacheoEntrada.setFec_cacheo(Fecha.getFechaActual());
			cacheoEntrada.setHora_cacheo(Fecha.getHoraActual());
			cacheoEntrada.setUsuario_cacheo(Usuario.findByOidProxy(this.getSesion().getLogin().getUsuario().getOIDInteger(),this.getSesion()));
			this.addTransaccion(cacheoEntrada);
			actuEntrada = true;
		}
		
		
		if ((cacheoSalida!=null) && (cacheoSalida.isIntentoDePase())) {
			cacheoSalida.setCacheoPersona(cacheoPersona);
			cacheoSalida.setRealizado(true);
			cacheoSalida.setNo_realizado(false);
			cacheoSalida.setFec_cacheo(Fecha.getFechaActual());
			cacheoSalida.setHora_cacheo(Fecha.getHoraActual());
			cacheoSalida.setUsuario_cacheo(Usuario.findByOidProxy(this.getSesion().getLogin().getUsuario().getOIDInteger(),this.getSesion()));
			this.addTransaccion(cacheoSalida);
			actuSalida = true;
		}

		// Si no hubo intento de pase, entonces que actualice todos los que encuentre 
		if ((actuEntrada==false) && (actuSalida==false)) {
			
			if (cacheoEntrada!=null) {
				cacheoEntrada.setCacheoPersona(cacheoPersona);
				cacheoEntrada.setRealizado(true);
				cacheoEntrada.setNo_realizado(false);
				cacheoEntrada.setFec_cacheo(Fecha.getFechaActual());
				cacheoEntrada.setHora_cacheo(Fecha.getHoraActual());
				cacheoEntrada.setUsuario_cacheo(Usuario.findByOidProxy(this.getSesion().getLogin().getUsuario().getOIDInteger(),this.getSesion()));
				this.addTransaccion(cacheoEntrada);
			}
			
			if (cacheoSalida!=null)  {
				cacheoSalida.setCacheoPersona(cacheoPersona);
				cacheoSalida.setRealizado(true);
				cacheoSalida.setNo_realizado(false);
				cacheoSalida.setFec_cacheo(Fecha.getFechaActual());
				cacheoSalida.setHora_cacheo(Fecha.getHoraActual());
				cacheoSalida.setUsuario_cacheo(Usuario.findByOidProxy(this.getSesion().getLogin().getUsuario().getOIDInteger(),this.getSesion()));
				this.addTransaccion(cacheoSalida);
			}
			
		}
		
		
		
	}

}
