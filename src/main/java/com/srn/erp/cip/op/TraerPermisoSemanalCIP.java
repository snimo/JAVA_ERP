package com.srn.erp.cip.op;

import java.util.Iterator;

import com.srn.erp.cip.bm.MotEntInterPlanifS;
import com.srn.erp.cip.bm.PermisoSemanalCIP;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerPermisoSemanalCIP extends Operation {

	public TraerPermisoSemanalCIP() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		PermisoSemanalCIP permisosemanalcip = null;
		if (mapaDatos.containsKey("oid")) {
			Integer oid = mapaDatos.getInteger("oid");
			permisosemanalcip = PermisoSemanalCIP.findByOid(oid, getSesion());
		} else {
			String codigo = mapaDatos.getString("codigo");
			permisosemanalcip = PermisoSemanalCIP.findByCodigo(codigo, getSesion());
		}

		IDataSet datasetPermisoSemanalCIP = getDataSetPermisoSemanalCIP();
		IDataSet datasetMotAccInterLunes  = getDataSetMotAccInter("TMotivoEntradasInterLUN"); 
		IDataSet datasetMotAccInterMartes  = getDataSetMotAccInter("TMotivoEntradasInterMAR");
		IDataSet datasetMotAccInterMiercoles  = getDataSetMotAccInter("TMotivoEntradasInterMIE");
		IDataSet datasetMotAccInterJueves  = getDataSetMotAccInter("TMotivoEntradasInterJUE");
		IDataSet datasetMotAccInterViernes  = getDataSetMotAccInter("TMotivoEntradasInterVIE");
		IDataSet datasetMotAccInterSabado  = getDataSetMotAccInter("TMotivoEntradasInterSAB");
		IDataSet datasetMotAccInterDomingo  = getDataSetMotAccInter("TMotivoEntradasInterDOM");
		
		if (permisosemanalcip != null) {
			
			cargarRegistroPermisoSemanalCIP(datasetPermisoSemanalCIP, permisosemanalcip.getOIDInteger(), permisosemanalcip.getCodigo(),
					permisosemanalcip.getDescripcion(), permisosemanalcip.isActivo(), permisosemanalcip.getEnt_hora_lun(),
					permisosemanalcip.getMin_ent_ant_lun(), permisosemanalcip.getMin_ent_des_lun(),
					permisosemanalcip.getTipo_per_ent_lun(), permisosemanalcip.getSal_hora_lun(), permisosemanalcip.getMin_sal_ant_lun(),
					permisosemanalcip.getMin_sal_des_lun(), permisosemanalcip.getTipo_per_sal_lun(), permisosemanalcip.getEnt_hora_mar(),
					permisosemanalcip.getMin_ent_ant_mar(), permisosemanalcip.getMin_ent_des_mar(),
					permisosemanalcip.getTipo_per_ent_mar(), permisosemanalcip.getSal_hora_mar(), permisosemanalcip.getMin_sal_ant_mar(),
					permisosemanalcip.getMin_sal_des_mar(), permisosemanalcip.getTipo_per_sal_mar(), permisosemanalcip.getEnt_hora_mie(),
					permisosemanalcip.getMin_ent_ant_mie(), permisosemanalcip.getMin_ent_des_mie(),
					permisosemanalcip.getTipo_per_ent_mie(), permisosemanalcip.getSal_hora_mie(), permisosemanalcip.getMin_sal_ant_mie(),
					permisosemanalcip.getMin_sal_des_mie(), permisosemanalcip.getTipo_per_sal_mie(), permisosemanalcip.getEnt_hora_juv(),
					permisosemanalcip.getMin_ent_ant_jue(), permisosemanalcip.getMin_ent_des_jue(),
					permisosemanalcip.getTipo_per_ent_jue(), permisosemanalcip.getSal_hora_jue(), permisosemanalcip.getMin_sal_ant_jue(),
					permisosemanalcip.getMin_sal_des_jue(), permisosemanalcip.getTipo_per_sal_jue(), permisosemanalcip.getEnt_hora_vie(),
					permisosemanalcip.getMin_ent_ant_vie(), permisosemanalcip.getMin_ent_des_vie(),
					permisosemanalcip.getTipo_per_ent_vie(), permisosemanalcip.getSal_hora_vie(), permisosemanalcip.getMin_sal_ant_vie(),
					permisosemanalcip.getMin_sal_des_vie(), permisosemanalcip.getTipo_per_sal_vie(), permisosemanalcip.getEnt_hora_sab(),
					permisosemanalcip.getMin_ent_ant_sab(), permisosemanalcip.getMin_ent_des_sab(),
					permisosemanalcip.getTipo_per_ent_sab(), permisosemanalcip.getSal_hora_sab(), permisosemanalcip.getMin_sal_ant_sab(),
					permisosemanalcip.getMin_sal_des_sab(), permisosemanalcip.getTipo_per_sal_sab(), permisosemanalcip.getEnt_hor_dom(),
					permisosemanalcip.getMin_ent_ant_dom(), permisosemanalcip.getMin_ent_des_dom(),
					permisosemanalcip.getTipo_per_ent_dom(), permisosemanalcip.getSal_hor_dom(), permisosemanalcip.getMin_sal_ant_dom(),
					permisosemanalcip.getMin_sal_des_dom(), permisosemanalcip.getTipo_per_sal_dom(),
					permisosemanalcip.getLunLeyNoIngresa(),permisosemanalcip.getMarLeyNoIngresa(),permisosemanalcip.getMieLeyNoIngresa(),
					permisosemanalcip.getJueLeyNoIngresa(),permisosemanalcip.getVieLeyNoIngresa(),permisosemanalcip.getSabLeyNoIngresa(),
					permisosemanalcip.getDomLeyNoIngresa(),permisosemanalcip.getLunLeyNoEgresa(),permisosemanalcip.getMarLeyNoEgresa(),
					permisosemanalcip.getMieLeyNoEgresa(),permisosemanalcip.getJueLeyNoEgresa(),permisosemanalcip.getVieLeyNoEgresa(),
					permisosemanalcip.getSabLeyNoEgresa(),permisosemanalcip.getDomLeyNoEgresa()
					);
			
			cargarMotivosAccInter(datasetMotAccInterLunes,permisosemanalcip,MotEntInterPlanifS.LUNES);
			cargarMotivosAccInter(datasetMotAccInterMartes,permisosemanalcip,MotEntInterPlanifS.MARTES);
			cargarMotivosAccInter(datasetMotAccInterMiercoles,permisosemanalcip,MotEntInterPlanifS.MIERCOLES);
			cargarMotivosAccInter(datasetMotAccInterJueves,permisosemanalcip,MotEntInterPlanifS.JUEVES);
			cargarMotivosAccInter(datasetMotAccInterViernes,permisosemanalcip,MotEntInterPlanifS.VIERNES);
			cargarMotivosAccInter(datasetMotAccInterSabado,permisosemanalcip,MotEntInterPlanifS.SABADO);
			cargarMotivosAccInter(datasetMotAccInterDomingo,permisosemanalcip,MotEntInterPlanifS.DOMINGO);
			
		}
		
		
		
		writeCliente(datasetPermisoSemanalCIP);
		writeCliente(datasetMotAccInterLunes); 
		writeCliente(datasetMotAccInterMartes);
		writeCliente(datasetMotAccInterMiercoles);
		writeCliente(datasetMotAccInterJueves);
		writeCliente(datasetMotAccInterViernes);
		writeCliente(datasetMotAccInterSabado);
		writeCliente(datasetMotAccInterDomingo);
		
	}
	
	private void cargarMotivosAccInter(
			IDataSet aDataSet,
			PermisoSemanalCIP permisoSemanal, 
			String dia) throws BaseException {
		Iterator iterMotAccInt = 
			permisoSemanal.getMotivosAccInter(dia).iterator();
		while (iterMotAccInt.hasNext()) {
			MotEntInterPlanifS motEntInterPlanifS = (MotEntInterPlanifS) iterMotAccInt.next();
			aDataSet.append();
			aDataSet.fieldValue("oid", motEntInterPlanifS.getOIDInteger());
			aDataSet.fieldValue("oid_motivo", motEntInterPlanifS.getMotivo().getOIDInteger());
			aDataSet.fieldValue("oid_perm_semanal", permisoSemanal.getOIDInteger());
			aDataSet.fieldValue("horario_desde", motEntInterPlanifS.getHorario_desde());
			aDataSet.fieldValue("horario_hasta", motEntInterPlanifS.getHorario_hasta());
			aDataSet.fieldValue("asignacion", motEntInterPlanifS.getAsignacion());
			aDataSet.fieldValue("activo", motEntInterPlanifS.isActivo());
		}
	}

	private IDataSet getDataSetMotAccInter(String tableName) {
		IDataSet dataset = new TDataSet();
		dataset.create(tableName);
		dataset.fieldDef(new Field("oid", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_motivo", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_perm_semanal", Field.INTEGER, 0));
		dataset.fieldDef(new Field("horario_desde", Field.STRING, 5));
		dataset.fieldDef(new Field("horario_hasta", Field.STRING, 5));
		dataset.fieldDef(new Field("asignacion", Field.STRING, 20));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		return dataset;
	}	
	
	private IDataSet getDataSetPermisoSemanalCIP() {
		IDataSet dataset = new TDataSet();
		dataset.create("TPermisoSemanalCIP");
		dataset.fieldDef(new Field("oid_perm_semanal", Field.INTEGER, 0));
		dataset.fieldDef(new Field("codigo", Field.STRING, 50));
		dataset.fieldDef(new Field("descripcion", Field.STRING, 100));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("ent_hora_lun", Field.STRING, 5));
		dataset.fieldDef(new Field("min_ent_ant_lun", Field.INTEGER, 0));
		dataset.fieldDef(new Field("min_ent_des_lun", Field.INTEGER, 0));
		dataset.fieldDef(new Field("tipo_per_ent_lun", Field.STRING, 20));
		dataset.fieldDef(new Field("sal_hora_lun", Field.STRING, 5));
		dataset.fieldDef(new Field("min_sal_ant_lun", Field.INTEGER, 0));
		dataset.fieldDef(new Field("min_sal_des_lun", Field.INTEGER, 0));
		dataset.fieldDef(new Field("tipo_per_sal_lun", Field.STRING, 20));
		dataset.fieldDef(new Field("ent_hora_mar", Field.STRING, 5));
		dataset.fieldDef(new Field("min_ent_ant_mar", Field.INTEGER, 0));
		dataset.fieldDef(new Field("min_ent_des_mar", Field.INTEGER, 0));
		dataset.fieldDef(new Field("tipo_per_ent_mar", Field.STRING, 20));
		dataset.fieldDef(new Field("sal_hora_mar", Field.STRING, 5));
		dataset.fieldDef(new Field("min_sal_ant_mar", Field.INTEGER, 0));
		dataset.fieldDef(new Field("min_sal_des_mar", Field.INTEGER, 0));
		dataset.fieldDef(new Field("tipo_per_sal_mar", Field.STRING, 20));
		dataset.fieldDef(new Field("ent_hora_mie", Field.STRING, 5));
		dataset.fieldDef(new Field("min_ent_ant_mie", Field.INTEGER, 0));
		dataset.fieldDef(new Field("min_ent_des_mie", Field.INTEGER, 0));
		dataset.fieldDef(new Field("tipo_per_ent_mie", Field.STRING, 20));
		dataset.fieldDef(new Field("sal_hora_mie", Field.STRING, 5));
		dataset.fieldDef(new Field("min_sal_ant_mie", Field.INTEGER, 0));
		dataset.fieldDef(new Field("min_sal_des_mie", Field.INTEGER, 0));
		dataset.fieldDef(new Field("tipo_per_sal_mie", Field.STRING, 20));
		dataset.fieldDef(new Field("ent_hora_jue", Field.STRING, 5));
		dataset.fieldDef(new Field("min_ent_ant_jue", Field.INTEGER, 0));
		dataset.fieldDef(new Field("min_ent_des_jue", Field.INTEGER, 0));
		dataset.fieldDef(new Field("tipo_per_ent_jue", Field.STRING, 20));
		dataset.fieldDef(new Field("sal_hora_jue", Field.STRING, 5));
		dataset.fieldDef(new Field("min_sal_ant_jue", Field.INTEGER, 0));
		dataset.fieldDef(new Field("min_sal_des_jue", Field.INTEGER, 0));
		dataset.fieldDef(new Field("tipo_per_sal_jue", Field.STRING, 20));
		dataset.fieldDef(new Field("ent_hora_vie", Field.STRING, 5));
		dataset.fieldDef(new Field("min_ent_ant_vie", Field.INTEGER, 0));
		dataset.fieldDef(new Field("min_ent_des_vie", Field.INTEGER, 0));
		dataset.fieldDef(new Field("tipo_per_ent_vie", Field.STRING, 20));
		dataset.fieldDef(new Field("sal_hora_vie", Field.STRING, 5));
		dataset.fieldDef(new Field("min_sal_ant_vie", Field.INTEGER, 0));
		dataset.fieldDef(new Field("min_sal_des_vie", Field.INTEGER, 0));
		dataset.fieldDef(new Field("tipo_per_sal_vie", Field.STRING, 20));
		dataset.fieldDef(new Field("ent_hora_sab", Field.STRING, 5));
		dataset.fieldDef(new Field("min_ent_ant_sab", Field.INTEGER, 0));
		dataset.fieldDef(new Field("min_ent_des_sab", Field.INTEGER, 0));
		dataset.fieldDef(new Field("tipo_per_ent_sab", Field.STRING, 20));
		dataset.fieldDef(new Field("sal_hora_sab", Field.STRING, 5));
		dataset.fieldDef(new Field("min_sal_ant_sab", Field.INTEGER, 0));
		dataset.fieldDef(new Field("min_sal_des_sab", Field.INTEGER, 0));
		dataset.fieldDef(new Field("tipo_per_sal_sab", Field.STRING, 20));
		dataset.fieldDef(new Field("ent_hora_dom", Field.STRING, 5));
		dataset.fieldDef(new Field("min_ent_ant_dom", Field.INTEGER, 0));
		dataset.fieldDef(new Field("min_ent_des_dom", Field.INTEGER, 0));
		dataset.fieldDef(new Field("tipo_per_ent_dom", Field.STRING, 20));
		dataset.fieldDef(new Field("sal_hora_dom", Field.STRING, 5));
		dataset.fieldDef(new Field("min_sal_ant_dom", Field.INTEGER, 0));
		dataset.fieldDef(new Field("min_sal_des_dom", Field.INTEGER, 0));
		dataset.fieldDef(new Field("tipo_per_sal_dom", Field.STRING, 20));
        
		dataset.fieldDef(new Field("lun_ley_no_ing", Field.STRING, 50));
		dataset.fieldDef(new Field("mar_ley_no_ing", Field.STRING, 50));
		dataset.fieldDef(new Field("mie_ley_no_ing", Field.STRING, 50));
		dataset.fieldDef(new Field("jue_ley_no_ing", Field.STRING, 50));
		dataset.fieldDef(new Field("vie_ley_no_ing", Field.STRING, 50));
		dataset.fieldDef(new Field("sab_ley_no_ing", Field.STRING, 50));
		dataset.fieldDef(new Field("dom_ley_no_ing", Field.STRING, 50));
        
		dataset.fieldDef(new Field("lun_ley_no_egr", Field.STRING, 50));
		dataset.fieldDef(new Field("mar_ley_no_egr", Field.STRING, 50));
		dataset.fieldDef(new Field("mie_ley_no_egr", Field.STRING, 50));
		dataset.fieldDef(new Field("jue_ley_no_egr", Field.STRING, 50));
		dataset.fieldDef(new Field("vie_ley_no_egr", Field.STRING, 50));
		dataset.fieldDef(new Field("sab_ley_no_egr", Field.STRING, 50));
		dataset.fieldDef(new Field("dom_ley_no_egr", Field.STRING, 50));
		
		
		return dataset;
	}

	private void cargarRegistroPermisoSemanalCIP(IDataSet dataset, Integer oid_perm_semanal, String codigo, String descripcion,
			Boolean activo, String ent_hora_lun, Integer min_ent_ant_lun, Integer min_ent_des_lun, String tipo_per_ent_lun,
			String sal_hora_lun, Integer min_sal_ant_lun, Integer min_sal_des_lun, String tipo_per_sal_lun, String ent_hora_mar,
			Integer min_ent_ant_mar, Integer min_ent_des_mar, String tipo_per_ent_mar, String sal_hora_mar, Integer min_sal_ant_mar,
			Integer min_sal_des_mar, String tipo_per_sal_mar, String ent_hora_mie, Integer min_ent_ant_mie, Integer min_ent_des_mie,
			String tipo_per_ent_mie, String sal_hora_mie, Integer min_sal_ant_mie, Integer min_sal_des_mie, String tipo_per_sal_mie,
			String ent_hora_juv, Integer min_ent_ant_jue, Integer min_ent_des_jue, String tipo_per_ent_jue, String sal_hora_jue,
			Integer min_sal_ant_jue, Integer min_sal_des_jue, String tipo_per_sal_jue, String ent_hora_vie, Integer min_ent_ant_vie,
			Integer min_ent_des_vie, String tipo_per_ent_vie, String sal_hora_vie, Integer min_sal_ant_vie, Integer min_sal_des_vie,
			String tipo_per_sal_vie, String ent_hora_sab, Integer min_ent_ant_sab, Integer min_ent_des_sab, String tipo_per_ent_sab,
			String sal_hora_sab, Integer min_sal_ant_sab, Integer min_sal_des_sab, String tipo_per_sal_sab, String ent_hor_dom,
			Integer min_ent_ant_dom, Integer min_ent_des_dom, String tipo_per_ent_dom, String sal_hor_dom, Integer min_sal_ant_dom,
			Integer min_sal_des_dom, String tipo_per_sal_dom,
			String lun_ley_no_ing,String mar_ley_no_ing,String mie_ley_no_ing,String jue_ley_no_ing,String vie_ley_no_ing,
			String sab_ley_no_ing,String dom_ley_no_ing,String lun_ley_no_egr,String mar_ley_no_egr,String mie_ley_no_egr,
			String jue_ley_no_egr,String vie_ley_no_egr,String sab_ley_no_egr,String dom_ley_no_egr) {
		dataset.append();
		dataset.fieldValue("oid_perm_semanal", oid_perm_semanal);
		dataset.fieldValue("codigo", codigo);
		dataset.fieldValue("descripcion", descripcion);
		dataset.fieldValue("activo", activo);
		dataset.fieldValue("ent_hora_lun", ent_hora_lun);
		dataset.fieldValue("min_ent_ant_lun", min_ent_ant_lun);
		dataset.fieldValue("min_ent_des_lun", min_ent_des_lun);
		dataset.fieldValue("tipo_per_ent_lun", tipo_per_ent_lun);
		dataset.fieldValue("sal_hora_lun", sal_hora_lun);
		dataset.fieldValue("min_sal_ant_lun", min_sal_ant_lun);
		dataset.fieldValue("min_sal_des_lun", min_sal_des_lun);
		dataset.fieldValue("tipo_per_sal_lun", tipo_per_sal_lun);
		dataset.fieldValue("ent_hora_mar", ent_hora_mar);
		dataset.fieldValue("min_ent_ant_mar", min_ent_ant_mar);
		dataset.fieldValue("min_ent_des_mar", min_ent_des_mar);
		dataset.fieldValue("tipo_per_ent_mar", tipo_per_ent_mar);
		dataset.fieldValue("sal_hora_mar", sal_hora_mar);
		dataset.fieldValue("min_sal_ant_mar", min_sal_ant_mar);
		dataset.fieldValue("min_sal_des_mar", min_sal_des_mar);
		dataset.fieldValue("tipo_per_sal_mar", tipo_per_sal_mar);
		dataset.fieldValue("ent_hora_mie", ent_hora_mie);
		dataset.fieldValue("min_ent_ant_mie", min_ent_ant_mie);
		dataset.fieldValue("min_ent_des_mie", min_ent_des_mie);
		dataset.fieldValue("tipo_per_ent_mie", tipo_per_ent_mie);
		dataset.fieldValue("sal_hora_mie", sal_hora_mie);
		dataset.fieldValue("min_sal_ant_mie", min_sal_ant_mie);
		dataset.fieldValue("min_sal_des_mie", min_sal_des_mie);
		dataset.fieldValue("tipo_per_sal_mie", tipo_per_sal_mie);
		dataset.fieldValue("ent_hora_jue", ent_hora_juv);
		dataset.fieldValue("min_ent_ant_jue", min_ent_ant_jue);
		dataset.fieldValue("min_ent_des_jue", min_ent_des_jue);
		dataset.fieldValue("tipo_per_ent_jue", tipo_per_ent_jue);
		dataset.fieldValue("sal_hora_jue", sal_hora_jue);
		dataset.fieldValue("min_sal_ant_jue", min_sal_ant_jue);
		dataset.fieldValue("min_sal_des_jue", min_sal_des_jue);
		dataset.fieldValue("tipo_per_sal_jue", tipo_per_sal_jue);
		dataset.fieldValue("ent_hora_vie", ent_hora_vie);
		dataset.fieldValue("min_ent_ant_vie", min_ent_ant_vie);
		dataset.fieldValue("min_ent_des_vie", min_ent_des_vie);
		dataset.fieldValue("tipo_per_ent_vie", tipo_per_ent_vie);
		dataset.fieldValue("sal_hora_vie", sal_hora_vie);
		dataset.fieldValue("min_sal_ant_vie", min_sal_ant_vie);
		dataset.fieldValue("min_sal_des_vie", min_sal_des_vie);
		dataset.fieldValue("tipo_per_sal_vie", tipo_per_sal_vie);
		dataset.fieldValue("ent_hora_sab", ent_hora_sab);
		dataset.fieldValue("min_ent_ant_sab", min_ent_ant_sab);
		dataset.fieldValue("min_ent_des_sab", min_ent_des_sab);
		dataset.fieldValue("tipo_per_ent_sab", tipo_per_ent_sab);
		dataset.fieldValue("sal_hora_sab", sal_hora_sab);
		dataset.fieldValue("min_sal_ant_sab", min_sal_ant_sab);
		dataset.fieldValue("min_sal_des_sab", min_sal_des_sab);
		dataset.fieldValue("tipo_per_sal_sab", tipo_per_sal_sab);
		dataset.fieldValue("ent_hora_dom", ent_hor_dom);
		dataset.fieldValue("min_ent_ant_dom", min_ent_ant_dom);
		dataset.fieldValue("min_ent_des_dom", min_ent_des_dom);
		dataset.fieldValue("tipo_per_ent_dom", tipo_per_ent_dom);
		dataset.fieldValue("sal_hora_dom", sal_hor_dom);
		dataset.fieldValue("min_sal_ant_dom", min_sal_ant_dom);
		dataset.fieldValue("min_sal_des_dom", min_sal_des_dom);
		dataset.fieldValue("tipo_per_sal_dom", tipo_per_sal_dom);
		
		dataset.fieldValue("lun_ley_no_ing", lun_ley_no_ing);
		dataset.fieldValue("mar_ley_no_ing", mar_ley_no_ing);
		dataset.fieldValue("mie_ley_no_ing", mie_ley_no_ing);
		dataset.fieldValue("jue_ley_no_ing", jue_ley_no_ing);
		dataset.fieldValue("vie_ley_no_ing", vie_ley_no_ing);
		dataset.fieldValue("sab_ley_no_ing", sab_ley_no_ing);
		dataset.fieldValue("dom_ley_no_ing", dom_ley_no_ing);
        
		dataset.fieldValue("lun_ley_no_egr", lun_ley_no_egr);
		dataset.fieldValue("mar_ley_no_egr", mar_ley_no_egr);
		dataset.fieldValue("mie_ley_no_egr", mie_ley_no_egr);
		dataset.fieldValue("jue_ley_no_egr", jue_ley_no_egr);
		dataset.fieldValue("vie_ley_no_egr", vie_ley_no_egr);
		dataset.fieldValue("sab_ley_no_egr", sab_ley_no_egr);
		dataset.fieldValue("dom_ley_no_egr", dom_ley_no_egr);
		
		
	}
}
