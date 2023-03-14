package com.srn.erp.cip.op;

import java.util.Iterator;

import com.srn.erp.cip.bm.CategAccesoCIP;
import com.srn.erp.cip.bm.DocumentacionVisitaCIP;
import com.srn.erp.cip.bm.EmpresaCIP;
import com.srn.erp.cip.bm.GrupoPuerta;
import com.srn.erp.cip.bm.GrupoVisita;
import com.srn.erp.cip.bm.MotEntIntVis;
import com.srn.erp.cip.bm.MotivoEntIntermedias;
import com.srn.erp.cip.bm.MotivoVisita;
import com.srn.erp.cip.bm.PermisoSemanalCIP;
import com.srn.erp.cip.bm.RotaVisita;
import com.srn.erp.cip.bm.TarjetaCIP;
import com.srn.erp.cip.bm.UtilCIP;
import com.srn.erp.cip.bm.Visita;
import com.srn.erp.general.bm.ClasificadorEntidad;
import com.srn.erp.general.bm.ValorClasificadorEntidad;
import com.srn.erp.sueldos.bm.Legajo;
import com.srn.erp.ventas.bm.TipoDocumento;

import framework.applicarionServer.bl.Utils.Fecha;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerVisitas extends Operation {

	public TraerVisitas() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {

		if (mapaDatos.containsKey("inicializarClasificadores")) {
			inicializarClasif(mapaDatos);
			return;
		}

		Visita visita = null;
		if (mapaDatos.containsKey("oid")) {
			Integer oid = mapaDatos.getInteger("oid");
			visita = Visita.findByOid(oid, getSesion());
		} else {
			String codigo = mapaDatos.getString("codigo");
			visita = Visita.findByCodigo(codigo, getSesion());
		}

		IDataSet datasetVisitas = getDataSetVisitas();
		IDataSet datasetValoresClasif = getDataSetValClasif();
		IDataSet datasetDocuVisita = getDataSetDocumentacionVisita();
		IDataSet datasetRotas = getDataSetRotas();
		IDataSet datasetAccInter = getDataSetMotAccesosIntermedios();

		if (visita != null) {

			cargarRegistroVisitas(
					datasetVisitas, visita.getOIDInteger(), visita.getApeyNom(), visita.isActivo(),
					visita.getTipoDocumento(), visita.getNroDocumento(), visita.getGrupoPuertaIngreso(), visita.getGrupoPuertaEgreso(),
					visita.getEmpresaCIP(), visita.getVisitaA(), visita.getAutoriza() , visita.isControlAntiPassBack() ,
					visita.isIgnorarProxAntiPassBack() , visita.getPermisoSemanal() , visita.getGrupoVisita() ,
					visita.isAplicVigencia() , visita.getFecVigenciaDesde() , visita.getFecVigenciaHasta() , visita.getCategoriaAcceso(),
					visita.getMotivoVisita() , visita.isLibAccesoAlPredio());

			traerValoresDatosClasif(datasetValoresClasif, visita);
			
			Iterator iterDocumentacion =	
				visita.getDocumentacion().iterator();
			while (iterDocumentacion.hasNext()) {
				DocumentacionVisitaCIP docuVisitaCIP = (DocumentacionVisitaCIP) iterDocumentacion.next();
				cargarRegistroDocumentacionVisita(datasetDocuVisita, docuVisitaCIP);
			}
			
			java.util.Date fecha = Fecha.getFechaTruncada(UtilCIP.getFechaHoraActual(this.getSesion()));
			java.util.Date fecha1 = Fecha.getFechaDiaAnterior(fecha);
			
			Iterator iterRotas = visita.getRotasVisita(fecha1).iterator();
			while (iterRotas.hasNext()) {
				RotaVisita rotaVisita = (RotaVisita) iterRotas.next();
				cargarRota(datasetRotas, rotaVisita);
			}
			
			traerMotivosAccesosIntermedios(datasetAccInter,visita);
			

		}

		writeCliente(datasetVisitas);
		writeCliente(datasetValoresClasif);
		writeCliente(datasetDocuVisita);
		writeCliente(datasetRotas);
		writeCliente(datasetAccInter);

	}
	
	  private void traerMotivosAccesosIntermedios(
			  IDataSet datasetMotivosLeg,
			  Visita visita) throws BaseException {
		  int secu = 1;
		  
		  Iterator iterMotivoEntIntermedias = 
			  MotivoEntIntermedias.getMotivoEntIntermedias(this.getSesion()).iterator();
		  while (iterMotivoEntIntermedias.hasNext()) {
			  MotivoEntIntermedias motivoEntIntermedias = (MotivoEntIntermedias) iterMotivoEntIntermedias.next();
			  ++secu;
			  datasetMotivosLeg.append();
			  datasetMotivosLeg.fieldValue("secu", secu);
			  datasetMotivosLeg.fieldValue("oid_visita", visita.getOID());
			  MotEntIntVis motEntInterVis =
				  MotEntIntVis.getMotEntIntVis(visita, motivoEntIntermedias, this.getSesion());
			  
			  if (motEntInterVis!=null) 		  
				  datasetMotivosLeg.fieldValue("habilitado", true);
			  else
				  datasetMotivosLeg.fieldValue("habilitado", false);
			  
			  datasetMotivosLeg.fieldValue("oid_motivo", motivoEntIntermedias.getOIDInteger());
			  datasetMotivosLeg.fieldValue("desc_motivo", motivoEntIntermedias.getDescripcion());

		  }
	  }
	
	
	private IDataSet getDataSetRotas() {
		IDataSet dataset = new TDataSet();
		dataset.create("TFechaRota");
		dataset.fieldDef(new Field("oid_rota_visita", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_visita", Field.INTEGER, 0));
		dataset.fieldDef(new Field("fecha", Field.DATE, 0));
		dataset.fieldDef(new Field("oid_rota",Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_rota",Field.STRING, 50));
		dataset.fieldDef(new Field("desc_rota",Field.STRING, 100));
		dataset.fieldDef(new Field("activo",Field.BOOLEAN, 0));
		return dataset;
	}
	
	private void cargarRota(
			IDataSet dataset, RotaVisita rotaVisita) throws BaseException {
		dataset.append();
		dataset.fieldValue("oid_rota_visita", rotaVisita.getOIDInteger());
		dataset.fieldValue("oid_visita", rotaVisita.getVisita().getOIDInteger());
		dataset.fieldValue("fecha", rotaVisita.getFecha());
		dataset.fieldValue("oid_rota",rotaVisita.getRota().getOIDInteger());
		dataset.fieldValue("cod_rota",rotaVisita.getRota().getCodigo());
		dataset.fieldValue("desc_rota",rotaVisita.getRota().getDescripcion());
		dataset.fieldValue("activo",rotaVisita.isActivo());
	}
	

	private IDataSet getDataSetVisitas() {
		IDataSet dataset = new TDataSet();
		dataset.create("TVisitas");
		dataset.fieldDef(new Field("oid_visita", Field.INTEGER, 0));
		dataset.fieldDef(new Field("ape_y_nom", Field.STRING, 100));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("oid_tipo_documento", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_tipo_documento", Field.STRING, 50));
		dataset.fieldDef(new Field("desc_tipo_documento", Field.STRING, 100));
		dataset.fieldDef(new Field("nro_documento", Field.STRING, 50));
		dataset.fieldDef(new Field("oid_grupo_puerta_ingreso", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_grupo_puerta_ingreso", Field.STRING, 50));
		dataset.fieldDef(new Field("desc_grupo_puerta_ingreso", Field.STRING, 100));
		dataset.fieldDef(new Field("oid_grupo_puerta_egreso", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_grupo_puerta_egreso", Field.STRING, 50));
		dataset.fieldDef(new Field("desc_grupo_puerta_egreso", Field.STRING, 100));
		dataset.fieldDef(new Field("oid_empresa", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_tarjeta", Field.INTEGER, 0));
		dataset.fieldDef(new Field("nro_tarjeta", Field.STRING, 50));
		dataset.fieldDef(new Field("oid_visita_a", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_visita_a", Field.STRING, 50));
		dataset.fieldDef(new Field("desc_visita_a", Field.STRING, 100));
		dataset.fieldDef(new Field("oid_autoriza", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_autoriza", Field.STRING, 50));
		dataset.fieldDef(new Field("desc_autoriza", Field.STRING, 100));
		dataset.fieldDef(new Field("antipass_vis", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("ignorar_prox_anti", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("oid_planif_sem", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_planif_sem", Field.STRING, 50));
		dataset.fieldDef(new Field("desc_planif_sem", Field.STRING, 100));
		dataset.fieldDef(new Field("oid_grupo_visita", Field.INTEGER, 0)); 
		dataset.fieldDef(new Field("cod_grupo_visita", Field.STRING, 50));
		dataset.fieldDef(new Field("desc_grupo_visita", Field.STRING, 100));
		dataset.fieldDef(new Field("aplic_vig", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("fec_desde_vig", Field.DATE, 0));
		dataset.fieldDef(new Field("fec_hasta_vig", Field.DATE, 0));
		dataset.fieldDef(new Field("oid_categ_acc_int", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_categ_acc_int", Field.STRING, 50));
		dataset.fieldDef(new Field("desc_categ_acc_int", Field.STRING, 010));
		dataset.fieldDef(new Field("oid_mot_visita", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_mot_visita", Field.STRING, 50));
		dataset.fieldDef(new Field("desc_mot_visita", Field.STRING, 100));
		dataset.fieldDef(new Field("lib_acc_al_predio", Field.BOOLEAN, 0));
		  		
		
		return dataset;
	}

	private void cargarRegistroVisitas(IDataSet dataset, Integer oidVisita, String apeyNom, Boolean activo,
			TipoDocumento tipoDocumento, String nroDocumento, GrupoPuerta grupoPuertaIngreso, GrupoPuerta grupoPuertaEgreso,
			EmpresaCIP empresa,Legajo legajoVisitaA,Legajo autoriza, boolean controlaAntiPassBack,
			boolean ignorarAntiPass,PermisoSemanalCIP permisoSemanal, GrupoVisita grupoVisita,
			boolean aplicVig, java.util.Date fecVigDesde, 
			java.util.Date fecVigHasta,CategAccesoCIP categAccesoInterno,
			MotivoVisita motivoVisita, boolean libIngAlPredio) throws BaseException {

		dataset.append();
		dataset.fieldValue("oid_visita", oidVisita);
		dataset.fieldValue("ape_y_nom", apeyNom);
		dataset.fieldValue("activo", activo);

		if (tipoDocumento != null) {
			dataset.fieldValue("oid_tipo_documento", tipoDocumento.getOIDInteger());
			dataset.fieldValue("cod_tipo_documento", tipoDocumento.getCodigo());
			dataset.fieldValue("desc_tipo_documento", tipoDocumento.getDescripcion());
		} else {
			dataset.fieldValue("oid_tipo_documento", "");
			dataset.fieldValue("cod_tipo_documento", "");
			dataset.fieldValue("desc_tipo_documento", "");
		}
		dataset.fieldValue("nro_documento", nroDocumento);

		if (grupoPuertaIngreso != null) {
			dataset.fieldValue("oid_grupo_puerta_ingreso", grupoPuertaIngreso.getOIDInteger());
			dataset.fieldValue("cod_grupo_puerta_ingreso", grupoPuertaIngreso.getCodigo());
			dataset.fieldValue("desc_grupo_puerta_ingreso", grupoPuertaIngreso.getDescripcion());
		} else {
			dataset.fieldValue("oid_grupo_puerta_ingreso", "");
			dataset.fieldValue("cod_grupo_puerta_ingreso", "");
			dataset.fieldValue("desc_grupo_puerta_ingreso", "");
		}

		if (grupoPuertaEgreso != null) {
			dataset.fieldValue("oid_grupo_puerta_egreso", grupoPuertaEgreso.getOIDInteger());
			dataset.fieldValue("cod_grupo_puerta_egreso", grupoPuertaEgreso.getCodigo());
			dataset.fieldValue("desc_grupo_puerta_egreso", grupoPuertaEgreso.getDescripcion());
		} else {
			dataset.fieldValue("oid_grupo_puerta_egreso", "");
			dataset.fieldValue("cod_grupo_puerta_egreso", "");
			dataset.fieldValue("desc_grupo_puerta_egreso", "");
		}

		if (empresa != null)
			dataset.fieldValue("oid_empresa", empresa.getOIDInteger());
		else
			dataset.fieldValue("oid_empresa", "");
		
		Visita visita = Visita.findByOidProxy(oidVisita, this.getSesion());
		TarjetaCIP tarjetaCIP = TarjetaCIP.getTarjetaCIP(visita, this.getSesion());
		
		if (tarjetaCIP!=null) {
			dataset.fieldValue("oid_tarjeta", tarjetaCIP.getOIDInteger());
			dataset.fieldValue("nro_tarjeta", tarjetaCIP.getNro_tarjeta());
		} else {
			dataset.fieldValue("oid_tarjeta", "");
			dataset.fieldValue("nro_tarjeta", "");
		}
		
		if (legajoVisitaA!=null) {
			dataset.fieldValue("oid_visita_a", legajoVisitaA.getOIDInteger());
			dataset.fieldValue("cod_visita_a", legajoVisitaA.getNro_legajo());
			dataset.fieldValue("desc_visita_a", legajoVisitaA.getApellidoyNombre());
		} else {
			dataset.fieldValue("oid_visita_a", "");
			dataset.fieldValue("cod_visita_a", "");
			dataset.fieldValue("desc_visita_a", "");
		}
		
		if (autoriza!=null) {
			dataset.fieldValue("oid_autoriza", autoriza.getOIDInteger());
			dataset.fieldValue("cod_autoriza", autoriza.getNro_legajo());
			dataset.fieldValue("desc_autoriza", autoriza.getApellidoyNombre());
		} else {
			dataset.fieldValue("oid_autoriza", "");
			dataset.fieldValue("cod_autoriza", "");
			dataset.fieldValue("desc_autoriza", "");
		}
		
		dataset.fieldValue("antipass_vis", controlaAntiPassBack);
		dataset.fieldValue("ignorar_prox_anti", ignorarAntiPass);
		
		if (permisoSemanal!=null) {
			dataset.fieldValue("oid_planif_sem", permisoSemanal.getOIDInteger());
			dataset.fieldValue("cod_planif_sem", permisoSemanal.getCodigo());
			dataset.fieldValue("desc_planif_sem", permisoSemanal.getDescripcion());
		} else {
			dataset.fieldValue("oid_planif_sem", "");
			dataset.fieldValue("cod_planif_sem", "");
			dataset.fieldValue("desc_planif_sem", "");
		}
		
		if (grupoVisita!=null) {
			dataset.fieldValue("oid_grupo_visita", grupoVisita.getOIDInteger());
			dataset.fieldValue("cod_grupo_visita", grupoVisita.getCodigo());
			dataset.fieldValue("desc_grupo_visita", grupoVisita.getDescripcion());
		} else {
			dataset.fieldValue("oid_grupo_visita", "");
			dataset.fieldValue("cod_grupo_visita", "");
			dataset.fieldValue("desc_grupo_visita", "");
		}

		dataset.fieldValue("aplic_vig", aplicVig);
		dataset.fieldValue("fec_desde_vig", fecVigDesde);
		dataset.fieldValue("fec_hasta_vig", fecVigHasta);
		
		if (categAccesoInterno!=null) {
			dataset.fieldValue("oid_categ_acc_int", categAccesoInterno.getOIDInteger());
			dataset.fieldValue("cod_categ_acc_int", categAccesoInterno.getCodigo());
			dataset.fieldValue("desc_categ_acc_int", categAccesoInterno.getDescripcion());
		} else {
			dataset.fieldValue("oid_categ_acc_int", "");
			dataset.fieldValue("cod_categ_acc_int", "");
			dataset.fieldValue("desc_categ_acc_int", "");
		}
		
		if (motivoVisita!=null) {
			dataset.fieldValue("oid_mot_visita", motivoVisita.getOIDInteger());
			dataset.fieldValue("cod_mot_visita", motivoVisita.getCodigo());
			dataset.fieldValue("desc_mot_visita", motivoVisita.getDescripcion());
		} else {
			dataset.fieldValue("oid_mot_visita", "");
			dataset.fieldValue("cod_mot_visita", "");
			dataset.fieldValue("desc_mot_visita", "");
		}
		
		dataset.fieldValue("lib_acc_al_predio", libIngAlPredio);

	}

	private IDataSet getDataSetValClasif() {
		IDataSet dataset = new TDataSet();
		dataset.create("TValoresClasificadores");
		dataset.fieldDef(new Field("oid_valor_clasif", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_visita", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_clasif_ent", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_val_clasif_ent", Field.INTEGER, 0));
		dataset.fieldDef(new Field("nro_clasif", Field.INTEGER, 0));
		dataset.fieldDef(new Field("desc_grupo_clasif", Field.STRING, 100));
		dataset.fieldDef(new Field("cod_valor", Field.STRING, 30));
		dataset.fieldDef(new Field("desc_valor", Field.STRING, 100));
		dataset.fieldDef(new Field("nickname", Field.STRING, 100));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("desc_clasificador", Field.STRING, 100));

		return dataset;
	}

	private void cargarDSValClasif(IDataSet dataset, Integer oidValorClasif, Integer oidLegajo, Integer oidClasifEnt,
			Integer oidValClasifEnt, Integer nroClasif, String descGrupoClasif, String codValor, String descValor, String nickname,
			Boolean activo, String descClasificador) throws BaseException {
		dataset.append();
		dataset.fieldValue("oid_valor_clasif", oidValorClasif);
		dataset.fieldValue("oid_visita", oidLegajo);
		dataset.fieldValue("oid_clasif_ent", oidClasifEnt);
		dataset.fieldValue("oid_val_clasif_ent", oidValClasifEnt);
		dataset.fieldValue("nro_clasif", nroClasif);
		dataset.fieldValue("desc_grupo_clasif", descGrupoClasif);
		dataset.fieldValue("cod_valor", codValor);
		dataset.fieldValue("desc_valor", descValor);
		dataset.fieldValue("nickname", nickname);
		dataset.fieldValue("activo", activo);
		dataset.fieldValue("desc_clasificador", descClasificador);
	}

	private void traerValoresDatosClasif(IDataSet ds, Visita aVisita) throws BaseException {
		int oid = 0;
		Iterator iterClasifEnt = aVisita.getClasifEntidadesActivas().iterator();
		while (iterClasifEnt.hasNext()) {
			ClasificadorEntidad clasifEnt = (ClasificadorEntidad) iterClasifEnt.next();
			ValorClasificadorEntidad valClasifEntidad = aVisita.getValorClasifEnt(clasifEnt);
			if (valClasifEntidad != null)
				cargarDSValClasif(ds, new Integer(++oid), aVisita.getOIDInteger(), clasifEnt.getOIDInteger(), valClasifEntidad
						.getOIDInteger(), clasifEnt.getNroClasif(), clasifEnt.getGrupo().getDescripcion(), valClasifEntidad.getCodigo(),
						valClasifEntidad.getDescripcion(), clasifEnt.getNickname(), new Boolean(true), clasifEnt.getDescripcion());
			else
				cargarDSValClasif(ds, new Integer(++oid), aVisita.getOIDInteger(), clasifEnt.getOIDInteger(), new Integer(-1), clasifEnt
						.getNroClasif(), clasifEnt.getGrupo().getDescripcion(), "", "", clasifEnt.getNickname(), new Boolean(true),
						clasifEnt.getDescripcion());
		}

	}
	
	private IDataSet getDataSetMotAccesosIntermedios() { 
		    IDataSet dataset = new TDataSet(); 
		    dataset.create("TMotAccesosIntermedios");
		    dataset.fieldDef(new Field("secu", Field.INTEGER, 0));
		    dataset.fieldDef(new Field("oid_visita", Field.INTEGER, 0));
			dataset.fieldDef(new Field("habilitado", Field.BOOLEAN, 0));		
			dataset.fieldDef(new Field("oid_motivo", Field.INTEGER, 0));
			dataset.fieldDef(new Field("desc_motivo", Field.STRING, 100));		
		    return dataset;
	}
	

	private IDataSet getDataSetClasificadorEntidad() {
		IDataSet dataset = new TDataSet();
		dataset.create("TClasificadorEntidad");
		dataset.fieldDef(new Field("oid_clasif_ent", Field.INTEGER, 0));
		dataset.fieldDef(new Field("codigo", Field.STRING, 20));
		dataset.fieldDef(new Field("descripcion", Field.STRING, 50));
		dataset.fieldDef(new Field("nickname", Field.STRING, 30));
		dataset.fieldDef(new Field("obligatorio", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("nro_clasif", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_grupo_clasif", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_grupo_clasif", Field.STRING, 50));
		dataset.fieldDef(new Field("desc_grupo_clasif", Field.STRING, 100));
		return dataset;
	}

	private IDataSet getDataSetDocumentacionVisita() {
		IDataSet dataset = new TDataSet();
		dataset.create("TDocumentacionVisita");
		dataset.fieldDef(new Field("oid_docu_visita", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_visita", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_tipo_docu", Field.INTEGER, 0));
		dataset.fieldDef(new Field("controla_fecha", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("fec_vto", Field.DATE, 0));
		dataset.fieldDef(new Field("observacion", Field.STRING, 255));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("presentado", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("fec_present", Field.DATE, 0));
		dataset.fieldDef(new Field("fec_emision", Field.DATE, 0));
		return dataset;
	}

	private void inicializarClasif(MapDatos mapaDatos) throws BaseException {
		IDataSet dsClasifEnt = getDataSetClasificadorEntidad();
		Iterator iterClasifEnt = Visita.getClasificadoresEntidadActivos(getSesion()).iterator();
		while (iterClasifEnt.hasNext()) {
			ClasificadorEntidad clasifEnt = (ClasificadorEntidad) iterClasifEnt.next();
			cargarRegistroClasificadorEntidad(dsClasifEnt, clasifEnt);
		}
		writeCliente(dsClasifEnt);
	}

	private void cargarRegistroClasificadorEntidad(IDataSet dataset, ClasificadorEntidad clasifEnt) throws BaseException {
		dataset.append();
		dataset.fieldValue("oid_clasif_ent", clasifEnt.getOIDInteger());
		dataset.fieldValue("codigo", clasifEnt.getCodigo());
		dataset.fieldValue("descripcion", clasifEnt.getDescripcion());
		dataset.fieldValue("nickname", clasifEnt.getNickname());
		dataset.fieldValue("obligatorio", clasifEnt.isObligatorio());
		dataset.fieldValue("activo", clasifEnt.isActivo());
		dataset.fieldValue("nro_clasif", clasifEnt.getNroClasif());
		dataset.fieldValue("oid_grupo_clasif", clasifEnt.getGrupo().getOIDInteger());
		dataset.fieldValue("cod_grupo_clasif", clasifEnt.getGrupo().getCodigo());
		dataset.fieldValue("desc_grupo_clasif", clasifEnt.getGrupo().getDescripcion());

	}
	
	private void cargarRegistroDocumentacionVisita(
			IDataSet dataset, 
			DocumentacionVisitaCIP documentacion) throws BaseException {
		dataset.append();
		dataset.fieldValue("oid_docu_visita", documentacion.getOIDInteger());
		dataset.fieldValue("oid_visita", documentacion.getVistat().getOIDInteger());
		dataset.fieldValue("oid_tipo_docu", documentacion.getTipo_documentacion().getOIDInteger());
		dataset.fieldValue("controla_fecha", documentacion.isControla_fecha());
		dataset.fieldValue("fec_vto", documentacion.getFec_vto());
		dataset.fieldValue("observacion", documentacion.getObservacion());
		dataset.fieldValue("activo", documentacion.isActivo());
		dataset.fieldValue("presentado", documentacion.isPresentado());
		dataset.fieldValue("fec_present", documentacion.getFecPresentacion());
		dataset.fieldValue("fec_emision", documentacion.getFecEmision());
		
	}
	

}
