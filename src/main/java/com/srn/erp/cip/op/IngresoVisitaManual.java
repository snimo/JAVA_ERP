package com.srn.erp.cip.op;

import java.text.SimpleDateFormat;

import com.srn.erp.cip.bm.MaqPuertasVisita;
import com.srn.erp.cip.bm.MovVisitaCIP;
import com.srn.erp.cip.bm.MovimientoCIP;
import com.srn.erp.cip.bm.TarjetaCIP;
import com.srn.erp.cip.bm.UtilCIP;

import framework.applicarionServer.bl.Utils.Fecha;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;
import framework.request.bl.Utils.MapDatos;

public class IngresoVisitaManual extends Operation {

	public IngresoVisitaManual() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		
		String nroTarjeta = mapaDatos.getString("nro_tarjeta");
		String nomMaquina = mapaDatos.getString("nombre_maquina").toUpperCase();
		
		if (nroTarjeta==null) throw new ExceptionValidation(null,"Debe ingresar el Nro. de Tarjeta");
		TarjetaCIP tarjeta = TarjetaCIP.getTarjetaCIP(nroTarjeta, this.getSesion());
		if (tarjeta==null) throw new ExceptionValidation(null,"Debe ingresar la Tarjeta");
		
		if (tarjeta.isTarjetaDesHabilitada())
			throw new ExceptionValidation(null,"La tarjeta se encuentra DESHABILITADA");

		if (!tarjeta.isActivo())
			throw new ExceptionValidation(null,"La tarjeta NO se encuentra ACTIVA");
		
		if (tarjeta.getVisita()==null)
			throw new ExceptionValidation(null,"La tarjeta no se encuentra asignada a una Visita");
		
		if (!tarjeta.isParaVisita())
			throw new ExceptionValidation(null,"La tarjeta no esta habilitada para visitas");
		
		if (!tarjeta.isVigentaAFecHora(UtilCIP.getFechaHoraActual(this.getSesion())))
			throw new ExceptionValidation(null,"Tarjeta caduco su vigencia");
		
		if (!tarjeta.getVisita().isActivo())
			throw new ExceptionValidation(null,"La visita no se encuentra activa");
		
		if (!tarjeta.getVisita().isEnElExterior())
			throw new ExceptionValidation(null,"La visita ya se encuentra dentro del Predio");
		
		MovVisitaCIP movVisitaCIP = (MovVisitaCIP) MovVisitaCIP.getNew(MovVisitaCIP.NICKNAME, this.getSesion());
		movVisitaCIP.setVisita(tarjeta.getVisita());
		
		MaqPuertasVisita maqPuertasVisita = MaqPuertasVisita.findByCodigo(nomMaquina, this.getSesion());
		if (maqPuertasVisita==null)
			throw new ExceptionValidation(null,"No se pudo determinar la Puerta de Ingreso para la máquina "+nomMaquina);
		
		if (!maqPuertasVisita.isActivo())
			throw new ExceptionValidation(null,"No se pudo determinar la Puerta de Ingreso para la máquina "+nomMaquina);
		
		if (maqPuertasVisita.getPuerta_entrada()==null)
			throw new ExceptionValidation(null,"No se pudo determinar la Puerta de Ingreso para la máquina "+nomMaquina);
		
		movVisitaCIP.setPuerta(maqPuertasVisita.getPuerta_entrada());
		java.util.Date fecHorActual = UtilCIP.getFechaHoraActual(this.getSesion());
		movVisitaCIP.setFec_hor(fecHorActual);
		movVisitaCIP.setFecha(Fecha.getFechaTruncada(fecHorActual));
		
		SimpleDateFormat sdfHora = new SimpleDateFormat("HH:mm:ss");
		movVisitaCIP.setHora(sdfHora.format(fecHorActual));
		movVisitaCIP.setHora_en_min(UtilCIP.getHoraEnMin(sdfHora.format(fecHorActual)));
		
		movVisitaCIP.setZona_origen(maqPuertasVisita.getPuerta_entrada().getEntradaSaleDe());
		movVisitaCIP.setZona_destino(maqPuertasVisita.getPuerta_entrada().getEntradaEntraA());
		movVisitaCIP.setSentido(MovimientoCIP.MOV_ENT_CIP);
		movVisitaCIP.setTarjeta(tarjeta);
		
		if (maqPuertasVisita.getPuerta_entrada().isIngresoAlPredio()) {
			movVisitaCIP.setAutorizo(tarjeta.getVisita().getAutoriza());
			movVisitaCIP.setVisita_a(tarjeta.getVisita().getVisitaA());
		}
		
		movVisitaCIP.setActivo(true);
		
		this.addTransaccion(movVisitaCIP);
		
		// Actualizar los Datos de la Visita
		tarjeta.getVisita().setZonaActual(maqPuertasVisita.getPuerta_entrada().getEntradaEntraA());
		if (maqPuertasVisita.getPuerta_entrada().isRegMovUltEnt()) {
			if ((tarjeta.getVisita().getFecHorUltMov()==null) || 
				(tarjeta.getVisita().getFecHorUltMov().before(fecHorActual))) {
				tarjeta.getVisita().setFecHorUltMov(fecHorActual);
				tarjeta.getVisita().setSentido(MovimientoCIP.MOV_ENT_CIP);
				tarjeta.getVisita().setIgnorarProxAntiPassBack(false);
			}	
		}
		
		this.addTransaccion(tarjeta.getVisita());
		
	}
}
