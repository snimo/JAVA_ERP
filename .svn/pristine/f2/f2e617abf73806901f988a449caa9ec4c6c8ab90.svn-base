package com.srn.erp.cip.op;

import java.util.Iterator;

import com.srn.erp.cip.bm.MotivosEquivCIP;
import com.srn.erp.cip.bm.MotivosNovCIP;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerMotivosNovCIP extends Operation {

	public TraerMotivosNovCIP() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException { 
    MotivosNovCIP motivosnovcip = null;
    if (mapaDatos.containsKey("oid")) { 
       Integer oid = mapaDatos.getInteger("oid"); 
       motivosnovcip = MotivosNovCIP.findByOid(oid, getSesion()); 
    } 
    else { 
       String codigo = mapaDatos.getString("codigo"); 
       motivosnovcip = MotivosNovCIP.findByCodigo(codigo, getSesion()); 
    } 

    IDataSet datasetMotivosNovCIP = getDataSetMotivosNovCIP();
    IDataSet datasetMotivosEquiv = getDataSetMotivosEquivCIP();
    
    if (motivosnovcip != null) { 
    	
        cargarRegistroMotivosNovCIP(datasetMotivosNovCIP, 
                         motivosnovcip.getOIDInteger(),
                         motivosnovcip.getCodigo(),
                         motivosnovcip.getDescripcion(),
                         motivosnovcip.isActivo(),
                         motivosnovcip.isHabilitadoParaIngresos(),
                         motivosnovcip.isHabilitadoParaEgresos(),
                         motivosnovcip.getCompoExtIngreso(),
                         motivosnovcip.getCompoExtEgreso(),
                         motivosnovcip.getMinEntAnt(),
                         motivosnovcip.getMinEntDes(),
                         motivosnovcip.isAnulaRotaDelDia(),
                         motivosnovcip.getHoraDesdeIng(),
                         motivosnovcip.getHoraHastaIng(),
                         motivosnovcip.getHoraDesdeEgr(),
                         motivosnovcip.getHoraHastaEgr()
                         );
        
        Iterator iterEquivalencias = 
        	motivosnovcip.getEquivalencias().iterator();
        while (iterEquivalencias.hasNext()) {
        	MotivosEquivCIP motivosEquivCIP = (MotivosEquivCIP) iterEquivalencias.next();
        	cargarRegistroMotivosEquivCIP(datasetMotivosEquiv, motivosEquivCIP);
        }
        
    }
    
    writeCliente(datasetMotivosNovCIP);
    writeCliente(datasetMotivosEquiv);
    
  }

	private IDataSet getDataSetMotivosNovCIP() {
		IDataSet dataset = new TDataSet();
		dataset.create("TMotivosNovCIP");
		dataset.fieldDef(new Field("oid_motivo", Field.INTEGER, 0));
		dataset.fieldDef(new Field("codigo", Field.STRING, 20));
		dataset.fieldDef(new Field("descripcion", Field.STRING, 100));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("hab_para_ingreso", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("hab_para_egreso", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("compo_ext_ing", Field.STRING, 50));
		dataset.fieldDef(new Field("compo_ext_egr", Field.STRING, 50));
		dataset.fieldDef(new Field("min_ent_ant", Field.INTEGER, 0));
		dataset.fieldDef(new Field("min_ent_des", Field.INTEGER, 0));
		dataset.fieldDef(new Field("anula_rota_del_dia", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("hora_desde_ing", Field.STRING, 5));
		dataset.fieldDef(new Field("hora_hasta_ing", Field.STRING, 5));
		dataset.fieldDef(new Field("hora_desde_egr", Field.STRING, 5));
		dataset.fieldDef(new Field("hora_hasta_egr", Field.STRING, 5));
		return dataset;
	}

	private void cargarRegistroMotivosNovCIP(
			IDataSet dataset, 
			Integer oid_motivo, 
			String codigo, 
			String descripcion, 
			Boolean activo,
			Boolean habParaIngreso,
			Boolean habParaEgreso,
			String compoExtIng,
			String compoExtEgr,
			Integer minEntAntes,
			Integer minEntDespues,
			boolean anulaRotaDelDia,
			String horaDesdeIng,
			String horaHastaIng,
			String horaDesdeEgr,
			String horaHastaEgr) {
		
		dataset.append();
		dataset.fieldValue("oid_motivo", oid_motivo);
		dataset.fieldValue("codigo", codigo);
		dataset.fieldValue("descripcion", descripcion);
		dataset.fieldValue("activo", activo);
		dataset.fieldValue("hab_para_ingreso", habParaIngreso);
		dataset.fieldValue("hab_para_egreso", habParaEgreso);
		dataset.fieldValue("compo_ext_ing",compoExtIng);
		dataset.fieldValue("compo_ext_egr",compoExtEgr);
		dataset.fieldValue("min_ent_ant", minEntAntes);
		dataset.fieldValue("min_ent_des", minEntDespues);
		dataset.fieldValue("anula_rota_del_dia", anulaRotaDelDia);
		if (horaDesdeIng!=null) 
			dataset.fieldValue("hora_desde_ing", horaDesdeIng);
		else
			dataset.fieldValue("hora_desde_ing", "00:00");
		if (horaHastaIng!=null)
			dataset.fieldValue("hora_hasta_ing", horaHastaIng);
		else
			dataset.fieldValue("hora_hasta_ing", "00:00");
		if (horaDesdeEgr!=null)
			dataset.fieldValue("hora_desde_egr", horaDesdeEgr);
		else
			dataset.fieldValue("hora_desde_egr", "00:00");
		if (horaHastaEgr!=null)
			dataset.fieldValue("hora_hasta_egr", horaHastaEgr);
		else
			dataset.fieldValue("hora_hasta_egr", "00:00");
		
	}

	private void cargarRegistroMotivosEquivCIP(IDataSet dataset, MotivosEquivCIP motivosEquiv) throws BaseException {
		dataset.append();
		dataset.fieldValue("oid_mot_equiv", motivosEquiv.getOIDInteger());
		dataset.fieldValue("oid_motivo", motivosEquiv.getMotivo().getOIDInteger());
		dataset.fieldValue("codigo_externo", motivosEquiv.getCodigo_externo());
		dataset.fieldValue("activo", motivosEquiv.isActivo());
	}

	private IDataSet getDataSetMotivosEquivCIP() {
		IDataSet dataset = new TDataSet();
		dataset.create("TMotivosEquivCIP");
		dataset.fieldDef(new Field("oid_mot_equiv", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_motivo", Field.INTEGER, 0));
		dataset.fieldDef(new Field("codigo_externo", Field.STRING, 50));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		return dataset;
	}

}
