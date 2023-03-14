package com.srn.erp.sueldos.op;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;

import com.srn.erp.cip.bm.AccesoValClasif;
import com.srn.erp.cip.bm.Cacheo;
import com.srn.erp.cip.bm.LegajoRotaFecha;
import com.srn.erp.cip.bm.MotivoEntradasInterRota;
import com.srn.erp.cip.bm.MovimientoCIP;
import com.srn.erp.cip.bm.NovedadPermisoCIP;
import com.srn.erp.cip.bm.TiposEntradasRotas;
import com.srn.erp.cip.bm.UtilCIP;
import com.srn.erp.general.bm.ClasificadorEntidad;
import com.srn.erp.general.bm.FuncEspSegERP;
import com.srn.erp.general.bm.ValorClasificadorEntidad;
import com.srn.erp.sueldos.bm.Legajo;

import framework.applicarionServer.bl.Utils.Fecha;
import framework.applicarionServer.bm.Seguridad.AltaFuncEspSeg;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerLegajoCIP extends Operation {

	java.util.Date fechaActual = null;
	
	public TraerLegajoCIP() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		
		
		fechaActual = UtilCIP.getTruncDate(UtilCIP.getFechaHoraActual(this.getSesion()));
		
		int minEntAntes = 0;
		int minEntDespues = 0;
		
		IDataSet dsLegajoCIP 	= getDataSetLegajoCIP();
		IDataSet dsLegajoCIPDet = getDataSetLegajoCIPDet();
		IDataSet dsNovPermisos  = getDataSetNovPermisos();
		
		if (mapaDatos.containsKey("codigo")) {
			Legajo legajo = Legajo.findByCodigo(mapaDatos.getString("codigo"), this.getSesion());
			cargarRegistroLegajoCIP(dsLegajoCIP,legajo);
			
			Iterator iterClasifEntActivas = 
				legajo.getClasifEntidadesActivas().iterator();
			
			while (iterClasifEntActivas.hasNext()) {
				ClasificadorEntidad clasifEnt = (ClasificadorEntidad) iterClasifEntActivas.next();
				cargarRegistroLegajoCIPDet(
						dsLegajoCIPDet, 
						clasifEnt.getOIDInteger(), 
						legajo.getOIDInteger(), 
						clasifEnt.getDescripcion(), 
						legajo.getValorClasifEnt(clasifEnt));
				
				AccesoValClasif accesoValClasif = null;
				ValorClasificadorEntidad valorClasifLeg = legajo.getValorClasifEnt(clasifEnt);
				if (valorClasifLeg!=null)
					accesoValClasif = AccesoValClasif.getAccesoValClasif(valorClasifLeg, this.getSesion());
										
				if (accesoValClasif!=null) {
					
						if ((accesoValClasif.getMin_ent_antes()!=null) && (accesoValClasif.getMin_ent_antes()>minEntAntes))
							minEntAntes = accesoValClasif.getMin_ent_antes();
						
						if ((accesoValClasif.getMin_ent_despues()!=null) && (accesoValClasif.getMin_ent_despues()>minEntDespues))
							minEntDespues= accesoValClasif.getMin_ent_despues();
						
				}
				
			}
			
			// Traer Planificacion de Rotas
			int secu=0;
			

			int tempMinEntAntes = NovedadPermisoCIP.getMaximoMinEntAntes(fechaActual, legajo, this.getSesion());
			int tempMinEntDespues = NovedadPermisoCIP.getMaximoMinEntDespues(fechaActual, legajo, this.getSesion());
			
			if (tempMinEntAntes>minEntAntes)
				minEntAntes = tempMinEntAntes; 

			if (tempMinEntDespues>minEntDespues)
				minEntDespues = tempMinEntDespues; 
			
			// Traer Novedades de Pemiso del Legajo
			Iterator iterNovPerm = 
				NovedadPermisoCIP.getNovedadesPermisosCIP(legajo, fechaActual, this.getSesion()).iterator();
			while (iterNovPerm.hasNext()) {
				NovedadPermisoCIP novPermCIP = (NovedadPermisoCIP) iterNovPerm.next();				
				++secu;
				cargarRegistroNovPermLegajo(dsNovPermisos,secu,legajo,novPermCIP);
				
				/*if ((novPermCIP.getPermisoIngreso().equals(NovedadPermisoCIP.NA_ING)) && 
						(novPermCIP.getMotivo()!=null) && 
						(novPermCIP.getMotivo().getCompoExtIngreso().equals(TiposEntradasRotas.SEGUN_HORARIO))) {

						
							if (novPermCIP.getMotivo().getMinEntAnt().intValue()>minEntAntes)
								minEntAntes   = novPermCIP.getMotivo().getMinEntAnt();
						
							if (novPermCIP.getMotivo().getMinEntDes().intValue()>minEntDespues)
								minEntDespues = novPermCIP.getMotivo().getMinEntDes();
					}*/
				
				
			}
			
			
			if (legajo.getEstadoCIP()!=null) {
				
				if (legajo.getEstadoCIP().getMinEntAntEntrada()>minEntAntes)
					minEntAntes = legajo.getEstadoCIP().getMinEntAntEntrada();
				
				if (legajo.getEstadoCIP().getMinEntDesEntrada()>minEntDespues)
					minEntDespues = legajo.getEstadoCIP().getMinEntDesEntrada();
				
			}			
			
			
			LegajoRotaFecha legRotFec = 
				legajo.getLegajoRotaFecha(fechaActual);
			if (legRotFec!=null) {
				++secu;
				cargarRegistroLegajoRotaFecha(dsNovPermisos,secu,legajo,legRotFec,minEntAntes, minEntDespues);
			}
			
			// Traer Novedades de Entradas Intermedias
			java.util.Date fecHorActual = UtilCIP.getFechaHoraActual(this.getSesion());
			LegajoRotaFecha legRotaFechaActual = legajo.getLegajoRotaFecha(fechaActual);
			LegajoRotaFecha legRotaFechaDiaAnt = legajo.getLegajoRotaFecha(Fecha.getFechaDiaAnterior(fechaActual));
			
			for(int z=1;z<=2;++z) {
			
				LegajoRotaFecha legRotaFecha = null;
				if (z==1)
					legRotaFecha = legRotaFechaActual;
				else
					legRotaFecha = legRotaFechaDiaAnt;
				
				if ((legRotaFecha!=null) && (legRotaFecha.getRota()!=null) && (legRotaFecha.getRota().getTipo_acceso().equals(TiposEntradasRotas.SEGUN_HORARIO)) && (legRotaFecha.getRota().getHorario_desde()!=null) && (legRotaFecha.getRota().getHorario_hasta()!=null)) {
					
					int HorasDesde   = UtilCIP.getParteHoraEnHoras(legRotaFecha.getRota().getHorario_desde());
					int MinutosDesde = UtilCIP.getParteMinutosEnMinutos(legRotaFecha.getRota().getHorario_desde());
					int cantMinutosHorDesde = UtilCIP.getHoraEnMin(legRotaFecha.getRota().getHorario_desde());
					
					Calendar calFecHorDesde = GregorianCalendar.getInstance(); 
					calFecHorDesde.setTime(legRotaFecha.getFecha()); // set cal to date
					calFecHorDesde.add(Calendar.HOUR, HorasDesde);
					calFecHorDesde.add(Calendar.MINUTE, MinutosDesde);
					java.util.Date fecHorDesde = calFecHorDesde.getTime();
					
					int HorasHasta   = UtilCIP.getParteHoraEnHoras(legRotaFecha.getRota().getHorario_hasta());
					int MinutosHasta = UtilCIP.getParteMinutosEnMinutos(legRotaFecha.getRota().getHorario_hasta());
					int cantMinutosHorHasta = UtilCIP.getHoraEnMin(legRotaFecha.getRota().getHorario_hasta());
					
					Calendar calFecHorHasta = GregorianCalendar.getInstance(); 
					if (cantMinutosHorHasta<cantMinutosHorDesde)
						calFecHorHasta.setTime(Fecha.getFechaDiaPosterior(legRotaFecha.getFecha())); 
					else
						calFecHorHasta.setTime(legRotaFecha.getFecha()); // set cal to date
					calFecHorHasta.add(Calendar.HOUR, HorasHasta);
					calFecHorHasta.add(Calendar.MINUTE, MinutosHasta);
					java.util.Date fecHorHasta = calFecHorHasta.getTime();
				
					if ((!fecHorActual.before(fecHorDesde)) && (!fecHorActual.after((fecHorHasta)))) {
						
						Iterator iterMotInterRotasAsigFij = legajo.getMotEntInterSegunLegajo(legRotaFecha.getRota()).iterator();
						while (iterMotInterRotasAsigFij.hasNext()) {
							MotivoEntradasInterRota motivoEntradasInterRota = (MotivoEntradasInterRota) iterMotInterRotasAsigFij.next();
							
							int HorasDesdeMot          = UtilCIP.getParteHoraEnHoras(motivoEntradasInterRota.getHorario_desde());
							int MinutosDesdeMot        = UtilCIP.getParteMinutosEnMinutos(motivoEntradasInterRota.getHorario_desde());
							int cantMinutosHorDesdeMot = UtilCIP.getHoraEnMin(motivoEntradasInterRota.getHorario_desde());
							
							Calendar calFecHorDesdeMot = GregorianCalendar.getInstance();
							calFecHorDesdeMot.setTime(legRotaFecha.getFecha()); 
							calFecHorDesdeMot.add(Calendar.HOUR, HorasDesdeMot);
							calFecHorDesdeMot.add(Calendar.MINUTE, MinutosDesdeMot);
							java.util.Date fecHorDesdeMot = calFecHorDesdeMot.getTime();
							
							int HorasHastaMot          = UtilCIP.getParteHoraEnHoras(motivoEntradasInterRota.getHorario_hasta());
							int MinutosHastaMot        = UtilCIP.getParteMinutosEnMinutos(motivoEntradasInterRota.getHorario_hasta());
							int cantMinutosHorHastaMot = UtilCIP.getHoraEnMin(motivoEntradasInterRota.getHorario_hasta());
							
							Calendar calFecHorHastaMot = GregorianCalendar.getInstance(); 
							if (cantMinutosHorHastaMot<cantMinutosHorDesdeMot)
								calFecHorHastaMot.setTime(Fecha.getFechaDiaPosterior(legRotaFecha.getFecha())); 
							else
								calFecHorHastaMot.setTime(legRotaFecha.getFecha()); // set cal to date
							calFecHorHastaMot.add(Calendar.HOUR, HorasHastaMot);
							calFecHorHastaMot.add(Calendar.MINUTE, MinutosHastaMot);
							java.util.Date fecHorHastaMot = calFecHorHastaMot.getTime();	
							
							// Mostrar 6 horas antes
							Calendar calFecHorDesde1 = GregorianCalendar.getInstance(); 
							calFecHorDesde1.setTime(fecHorDesdeMot); // set cal to date
							calFecHorDesde1.add(Calendar.HOUR, -6);
							java.util.Date fecHorDesde1 = calFecHorDesde1.getTime();							
							
							if ((!fecHorActual.before(fecHorDesde1)) && (!fecHorActual.after((fecHorHastaMot)))) {
								++secu;
								String motivo = motivoEntradasInterRota.getMotivo().getDescripcion();
								String observacion = 
									"Puede ingresar de "+
									Fecha.getFormatoHoraMin(fecHorDesdeMot)+
									" a "+
									Fecha.getFormatoHoraMin(fecHorHastaMot);
								cargarRegistroEntradasIntermedias(dsNovPermisos, secu, -1, fecHorActual, motivo, observacion, legajo, legajo.getDescPuntoAcceso());
							}	
						
						}
						
					}
				}
			}			
			
			
			boolean mostrarCacheos =
				AltaFuncEspSeg.isFuncEspSegHabilitada(new Integer(FuncEspSegERP.SEG_2001), "", false, this.getSesion());

			if (mostrarCacheos) {
				
				Cacheo cacheoEnt = 
					Cacheo.getCacheoPend(legajo.getOIDInteger(), fechaActual, "E", this.getSesion());
				if (cacheoEnt!=null) {
					++secu;
					cargarRegistroCacheo(dsNovPermisos, secu, cacheoEnt);
				}
			
				Cacheo cacheoSal = 
					Cacheo.getCacheoPend(legajo.getOIDInteger(), fechaActual, "S", this.getSesion());
				if (cacheoSal!=null) {
					++secu;
					cargarRegistroCacheo(dsNovPermisos, secu, cacheoSal);
				}			
			}
			
		}
		
		writeCliente(dsLegajoCIP);
		writeCliente(dsLegajoCIPDet);
		writeCliente(dsNovPermisos);
		
		
	}

	private void cargarRegistroLegajoCIP(
			IDataSet dataset, 
			Legajo legajo) throws BaseException {
		dataset.append();
		dataset.fieldValue("oid_legajo", legajo.getOIDInteger());
		dataset.fieldValue("ape_y_nom", legajo.getApellidoyNombre());
		
		if (legajo.getEstadoCIP()!=null)
			dataset.fieldValue("estado_acceso", legajo.getEstadoCIP().getDescripcion());
		else
			dataset.fieldValue("estado_acceso", "");
		
		if (!legajo.isActivo())
			dataset.fieldValue("estado_legajo", "INHABILITADO");
		else
			dataset.fieldValue("estado_legajo", "");
		dataset.fieldValue("fec_ingreso", Fecha.getddmmyyyy(legajo.getFecIngreso()));
		dataset.fieldValue("fec_retiro", Fecha.getddmmyyyy(legajo.getFecRetiro()));
		dataset.fieldValue("fec_actual", fechaActual);
		dataset.fieldValue("act_anti_pass_back", legajo.isActivarAntiPassBack());
		dataset.fieldValue("fec_ult_paso", legajo.getFecUltPaso());
		dataset.fieldValue("hor_ult_paso", legajo.getHoraUltPaso());
		dataset.fieldValue("sentido_paso", legajo.getSentidoPaso());
		dataset.fieldValue("ult_movimiento", legajo.getUltimoMovimiento());
		if ((legajo.isIgnorarProxAntiPassBack()!=null) && (legajo.isIgnorarProxAntiPassBack().booleanValue()==true))
			dataset.fieldValue("leyenda_ignorar_prox_apb", "Ignorar proximo control Antipassback");
		else
			dataset.fieldValue("leyenda_ignorar_prox_apb", "");
		
		Integer oidZonaActual = 0;
		String descZonaActual = "";
		
		Iterator iterMovUltDia =
			MovimientoCIP.getMovimientosLegajoUltDia(legajo, this.getSesion()).iterator();
		while (iterMovUltDia.hasNext()) {
			MovimientoCIP movimiento = (MovimientoCIP) iterMovUltDia.next();
			
			if (movimiento.getZonaDestino()!=null) {
				oidZonaActual = movimiento.getZonaDestino().getOIDInteger();
				descZonaActual =  movimiento.getZonaDestino().getDescripcion();
			}
				
			break;
		}
		
		dataset.fieldValue("oid_zona_actual", oidZonaActual);
		dataset.fieldValue("desc_zona_actual", descZonaActual);
		

	}
	
	private void cargarRegistroLegajoRotaFecha(
			IDataSet dataset, 
			Integer secu,
			Legajo legajo,
			LegajoRotaFecha legajoRotaFecha,
			Integer minEntAntes,
			Integer minEntDespues) throws BaseException {
		dataset.append();
		dataset.fieldValue("orden", secu);
		dataset.fieldValue("oid_nov_perm", legajoRotaFecha.getOIDInteger() );
		dataset.fieldValue("fecha", fechaActual);
		dataset.fieldValue("motivo", "Rota: "+legajoRotaFecha.getRota().getDescripcion());
		dataset.fieldValue("observacion", legajoRotaFecha.getRota().getLeyendaPermisoRota(minEntAntes,minEntDespues));
		dataset.fieldValue("puntos_acceso",legajo.getDescPuntoAcceso());
		dataset.fieldValue("eliminar","Eliminar");
		dataset.fieldValue("nickname",LegajoRotaFecha.NICKNAME);
		dataset.fieldValue("peso_novedad",0);
	}
	
	private void cargarRegistroEntradasIntermedias(
			IDataSet dataset, 
			Integer secu,
			Integer oidNovPerm,
			java.util.Date fecha,
			String motivo,
			String observacion,
			Legajo legajo,
			String puntosAcceso) throws BaseException {
		dataset.append();
		dataset.fieldValue("orden", secu);
		dataset.fieldValue("oid_nov_perm", oidNovPerm);
		dataset.fieldValue("fecha", fecha);
		dataset.fieldValue("motivo", motivo);
		dataset.fieldValue("observacion", observacion);
		dataset.fieldValue("puntos_acceso",puntosAcceso);
		dataset.fieldValue("eliminar","Eliminar");
		dataset.fieldValue("nickname","");
		dataset.fieldValue("peso_novedad",0);
	}
	
	
	private void cargarRegistroCacheo(
			IDataSet dataset, 
			Integer secu,
			Cacheo cacheo) throws BaseException {
		dataset.append();
		dataset.fieldValue("orden", secu);
		dataset.fieldValue("oid_nov_perm", "");
		dataset.fieldValue("fecha", cacheo.getFec_planif_cacheo());
		dataset.fieldValue("motivo", "CACHEO a la "+cacheo.getDesc_Ent_o_sal());
		dataset.fieldValue("observacion", "");
		dataset.fieldValue("puntos_acceso",cacheo.getDescPuntoAcceso());
		dataset.fieldValue("eliminar","Eliminar");
		dataset.fieldValue("nickname",Cacheo.NICKNAME);
		dataset.fieldValue("peso_novedad",0);
	}
	
	
	private void cargarRegistroNovPermLegajo(
			IDataSet dataset, 
			Integer secu,
			Legajo legajo,
			NovedadPermisoCIP novedad) throws BaseException {
		dataset.append();
		dataset.fieldValue("orden", secu);
		dataset.fieldValue("oid_nov_perm", novedad.getOIDInteger() );
		dataset.fieldValue("fecha", novedad.getFecha());
		dataset.fieldValue("motivo", novedad.getMotivo().getDescripcion());
		dataset.fieldValue("observacion", novedad.getLeyendaPermisoNovedad());
		dataset.fieldValue("puntos_acceso",novedad.getGrupo_puerta().getDescripcion());
		dataset.fieldValue("eliminar","Eliminar");
		dataset.fieldValue("nickname",NovedadPermisoCIP.NICKNAME);
		dataset.fieldValue("peso_novedad",novedad.getPesoNovedad());
		
	}	
	
	
	private void cargarRegistroLegajoCIPDet(
					IDataSet dataset, 
					Integer oidClasif,
					Integer oidLegajo,
					String clasificador,
					ValorClasificadorEntidad valorClasif) throws BaseException {
		dataset.append();
		dataset.fieldValue("oid_clasif", oidClasif);
		dataset.fieldValue("oid_legajo", oidLegajo);
		dataset.fieldValue("clasificador", clasificador);
		if (valorClasif!=null)
			dataset.fieldValue("desc_valor_clasif", valorClasif.getDescripcion());
		else
			dataset.fieldValue("desc_valor_clasif", "");
	}	

	private IDataSet getDataSetLegajoCIP() {
		IDataSet dataset = new TDataSet();
		dataset.create("TDatosLegCab");
		dataset.fieldDef(new Field("oid_legajo", Field.INTEGER, 0));
		dataset.fieldDef(new Field("ape_y_nom", Field.STRING, 100));
		dataset.fieldDef(new Field("estado_acceso", Field.STRING, 100));
		dataset.fieldDef(new Field("estado_legajo", Field.STRING, 100));
		dataset.fieldDef(new Field("fec_ingreso", Field.DATE, 0));
		dataset.fieldDef(new Field("fec_retiro", Field.DATE, 0));
		dataset.fieldDef(new Field("fec_actual", Field.DATE, 0));
		dataset.fieldDef(new Field("act_anti_pass_back", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("fec_ult_paso", Field.DATE, 0));
		dataset.fieldDef(new Field("hor_ult_paso", Field.STRING, 5));
		dataset.fieldDef(new Field("sentido_paso", Field.STRING, 1));
		dataset.fieldDef(new Field("ult_movimiento", Field.STRING, 255));
		dataset.fieldDef(new Field("leyenda_ignorar_prox_apb", Field.STRING, 100));
		dataset.fieldDef(new Field("oid_zona_actual", Field.INTEGER, 0));
		dataset.fieldDef(new Field("desc_zona_actual", Field.STRING, 100));
		return dataset;
	}
	
	private IDataSet getDataSetLegajoCIPDet() {
		IDataSet dataset = new TDataSet();
		dataset.create("TDatosLegDet");
		dataset.fieldDef(new Field("oid_clasif", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_legajo", Field.INTEGER, 0));
		dataset.fieldDef(new Field("clasificador", Field.STRING, 100));
		dataset.fieldDef(new Field("desc_valor_clasif", Field.STRING, 100));
		return dataset;
	}	
	
	private IDataSet getDataSetNovPermisos() {
		IDataSet dataset = new TDataSet();
		dataset.create("TNovPermisos");
		dataset.fieldDef(new Field("orden", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_nov_perm", Field.INTEGER, 0));
		dataset.fieldDef(new Field("fecha", Field.DATE, 0));
		dataset.fieldDef(new Field("motivo", Field.STRING, 100));
		dataset.fieldDef(new Field("observacion", Field.STRING, 500));
		dataset.fieldDef(new Field("puntos_acceso", Field.STRING, 100));
		dataset.fieldDef(new Field("eliminar", Field.STRING, 100));
		dataset.fieldDef(new Field("nickname", Field.STRING, 100));
		dataset.fieldDef(new Field("peso_novedad", Field.INTEGER, 0));
		return dataset;		
	}
	
	
	

}
