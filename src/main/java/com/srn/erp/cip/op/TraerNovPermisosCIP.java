package com.srn.erp.cip.op;

import java.util.Date;
import java.util.List;

import com.srn.erp.cip.bm.GrupoPuerta;
import com.srn.erp.cip.bm.NovedadPermisoCIP;
import com.srn.erp.sueldos.bm.Legajo;

import framework.applicarionServer.bl.Utils.Fecha;
import framework.applicarionServer.bm.Seguridad.Usuario;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerNovPermisosCIP extends Operation {

	@Override
	public void execute(MapDatos mapaDatos) throws BaseException {
		Date fecDesde = mapaDatos.getDate("fec_desde");
		Date fecHasta = mapaDatos.getDate("fec_hasta");

		if (fecHasta.before(fecDesde))
			throw new ExceptionValidation("La fecha desde debe ser mayor a la fecha hasta.");
		
		
		int dias = Fecha.fechasDiferenciaEnDias(fecDesde, fecHasta);
		if (dias>6)
			throw new ExceptionValidation(null,"No se permite una diferencia mayor a 7 dias entre la fecha desde y hasta");

		Legajo legajo = null;
		if (mapaDatos.containsKey("oid_legajo"))
			legajo = Legajo.findByOidProxy(mapaDatos.getInteger("oid_legajo"), this.getSesion());

		List<NovedadPermisoCIP> novedades = null;

		if (legajo != null)
			novedades = NovedadPermisoCIP.getNovedadesByLegFechaDesdeFechaHasta(legajo, fecDesde, fecHasta, this.getSesion());
		else
			novedades = NovedadPermisoCIP.getNovedadesByFechaDesdeFechaHasta(fecDesde, fecHasta, this.getSesion());

		IDataSet dsNov = this.crearDSNov();

		for (NovedadPermisoCIP novedad : novedades) {
			this.cargarDSNov(dsNov, novedad);
		}

		writeCliente(dsNov);

	}

	private void cargarDSNov(IDataSet dataset, NovedadPermisoCIP novedad) throws BaseException {
		dataset.append();
		dataset.fieldValue("oid_nov_permiso", novedad.getOIDInteger());
		dataset.fieldValue("oid_motivo", novedad.getMotivo().getOIDInteger());
		dataset.fieldValue("descripcion_motivo", novedad.getMotivo().getDescripcion());
		dataset.fieldValue("fecha", novedad.getFecha());
		dataset.fieldValue("hora_desde", novedad.getHora_desde());
		dataset.fieldValue("hora_hasta", novedad.getHora_hasta());
		dataset.fieldValue("observacion", novedad.getObservacion());
		dataset.fieldValue("permiso_ingreso", (String) NovedadPermisoCIP.getHabilitacionesYAmbos().get((novedad.getPermisoIngreso())));
		dataset.fieldValue("permiso_egreso", (String) NovedadPermisoCIP.getHabilitacionesYAmbos().get((novedad.getPermisoEgreso())));

		Legajo legajo = novedad.getLegajo();
		if (legajo!=null) {
			dataset.fieldValue("oid_legajo", legajo.getOIDInteger());
			dataset.fieldValue("legajo", legajo.getNro_legajo());
			dataset.fieldValue("ape_y_nom", legajo.getApellidoyNombre());
		} else {
			dataset.fieldValue("oid_legajo", "");
			dataset.fieldValue("legajo", "");
			dataset.fieldValue("ape_y_nom", "");			
		}

		Usuario usu = novedad.getUsu_asig_permiso();
		if (usu!=null) {
			dataset.fieldValue("oid_usu_asig_perm", usu.getOIDInteger());
			dataset.fieldValue("ape_y_nom_usu_asig_perm", usu.getApellidoyNombre());
			dataset.fieldValue("fec_usu_asig_perm", novedad.getFec_usu_asig_perm());
		} else {
			dataset.fieldValue("oid_usu_asig_perm", "");
			dataset.fieldValue("ape_y_nom_usu_asig_perm", "");
			dataset.fieldValue("fec_usu_asig_perm", "");			
		}
		dataset.fieldValue("hor_usu_asig_perm", novedad.getHor_usu_asig_perm());

		GrupoPuerta grupoPuerta = novedad.getGrupo_puerta();
		if (grupoPuerta!=null) {
			dataset.fieldValue("oid_grupo_puerta", grupoPuerta.getOIDInteger());
			dataset.fieldValue("descripcion_grupo_puerta", grupoPuerta.getDescripcion());
		} else {
			dataset.fieldValue("oid_grupo_puerta", "");
			dataset.fieldValue("descripcion_grupo_puerta", "");			
		}

		dataset.fieldValue("activo", novedad.isActivo());
	}

	private IDataSet crearDSNov() {
		IDataSet dataset = new TDataSet();
		dataset.create("TNovedades");
		dataset.fieldDef(new Field("oid_nov_permiso", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_motivo", Field.INTEGER, 0));
		dataset.fieldDef(new Field("descripcion_motivo", Field.STRING, 100));
		dataset.fieldDef(new Field("fecha", Field.DATE, 0));
		dataset.fieldDef(new Field("hora_desde", Field.STRING, 5));
		dataset.fieldDef(new Field("hora_hasta", Field.STRING, 5));
		dataset.fieldDef(new Field("observacion", Field.STRING, 100));
		dataset.fieldDef(new Field("permiso_ingreso", Field.STRING, 50));
		dataset.fieldDef(new Field("permiso_egreso", Field.STRING, 50));
		dataset.fieldDef(new Field("oid_legajo", Field.INTEGER, 0));
		dataset.fieldDef(new Field("legajo", Field.STRING, 50));
		dataset.fieldDef(new Field("ape_y_nom", Field.STRING, 100));
		dataset.fieldDef(new Field("oid_usu_asig_perm", Field.STRING, 100));
		dataset.fieldDef(new Field("ape_y_nom_usu_asig_perm", Field.STRING, 100));
		dataset.fieldDef(new Field("fec_usu_asig_perm", Field.DATE, 0));
		dataset.fieldDef(new Field("hor_usu_asig_perm", Field.STRING, 5));
		dataset.fieldDef(new Field("oid_grupo_puerta", Field.INTEGER, 0));
		dataset.fieldDef(new Field("descripcion_grupo_puerta", Field.STRING, 50));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		return dataset;
	}

}
