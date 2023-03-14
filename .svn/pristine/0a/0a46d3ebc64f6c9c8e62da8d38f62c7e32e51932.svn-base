package com.srn.erp.cip.op;

import com.srn.erp.cip.bm.MotEntInterPlanifS;
import com.srn.erp.cip.bm.MotivoEntIntermedias;
import com.srn.erp.cip.bm.PermisoSemanalCIP;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SavePermisoSemanalCIP extends Operation { 

  public SavePermisoSemanalCIP() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    IDataSet dataset = mapaDatos.getDataSet("TPermisoSemanalCIP"); 
    procesarRegistros(dataset); 
  } 

  private void procesarRegistros(IDataSet dataset) throws BaseException { 
    dataset.first(); 
      while (!dataset.EOF()) { 
        PermisoSemanalCIP permisosemanalcip = PermisoSemanalCIP.findByOid(dataset.getInteger("oid_perm_semanal"),getSesion());
        permisosemanalcip.setOID(dataset.getInteger("oid_perm_semanal"));
        permisosemanalcip.setCodigo(dataset.getString("codigo"));
        permisosemanalcip.setDescripcion(dataset.getString("descripcion"));
        permisosemanalcip.setActivo(dataset.getBoolean("activo"));
        permisosemanalcip.setEnt_hora_lun(dataset.getString("ent_hora_lun"));
        permisosemanalcip.setMin_ent_ant_lun(dataset.getInteger("min_ent_ant_lun"));
        permisosemanalcip.setMin_ent_des_lun(dataset.getInteger("min_ent_des_lun"));
        permisosemanalcip.setTipo_per_ent_lun(dataset.getString("tipo_per_ent_lun"));
        permisosemanalcip.setSal_hora_lun(dataset.getString("sal_hora_lun"));
        permisosemanalcip.setMin_sal_ant_lun(dataset.getInteger("min_sal_ant_lun"));
        permisosemanalcip.setMin_sal_des_lun(dataset.getInteger("min_sal_des_lun"));
        permisosemanalcip.setTipo_per_sal_lun(dataset.getString("tipo_per_sal_lun"));
        permisosemanalcip.setEnt_hora_mar(dataset.getString("ent_hora_mar"));
        permisosemanalcip.setMin_ent_ant_mar(dataset.getInteger("min_ent_ant_mar"));
        permisosemanalcip.setMin_ent_des_mar(dataset.getInteger("min_ent_des_mar"));
        permisosemanalcip.setTipo_per_ent_mar(dataset.getString("tipo_per_ent_mar"));
        permisosemanalcip.setSal_hora_mar(dataset.getString("sal_hora_mar"));
        permisosemanalcip.setMin_sal_ant_mar(dataset.getInteger("min_sal_ant_mar"));
        permisosemanalcip.setMin_sal_des_mar(dataset.getInteger("min_sal_des_mar"));
        permisosemanalcip.setTipo_per_sal_mar(dataset.getString("tipo_per_sal_mar"));
        permisosemanalcip.setEnt_hora_mie(dataset.getString("ent_hora_mie"));
        permisosemanalcip.setMin_ent_ant_mie(dataset.getInteger("min_ent_ant_mie"));
        permisosemanalcip.setMin_ent_des_mie(dataset.getInteger("min_ent_des_mie"));
        permisosemanalcip.setTipo_per_ent_mie(dataset.getString("tipo_per_ent_mie"));
        permisosemanalcip.setSal_hora_mie(dataset.getString("sal_hora_mie"));
        permisosemanalcip.setMin_sal_ant_mie(dataset.getInteger("min_sal_ant_mie"));
        permisosemanalcip.setMin_sal_des_mie(dataset.getInteger("min_sal_des_mie"));
        permisosemanalcip.setTipo_per_sal_mie(dataset.getString("tipo_per_sal_mie"));
        permisosemanalcip.setEnt_hora_juv(dataset.getString("ent_hora_jue"));
        permisosemanalcip.setMin_ent_ant_jue(dataset.getInteger("min_ent_ant_jue"));
        permisosemanalcip.setMin_ent_des_jue(dataset.getInteger("min_ent_des_jue"));
        permisosemanalcip.setTipo_per_ent_jue(dataset.getString("tipo_per_ent_jue"));
        permisosemanalcip.setSal_hora_jue(dataset.getString("sal_hora_jue"));
        permisosemanalcip.setMin_sal_ant_jue(dataset.getInteger("min_sal_ant_jue"));
        permisosemanalcip.setMin_sal_des_jue(dataset.getInteger("min_sal_des_jue"));
        permisosemanalcip.setTipo_per_sal_jue(dataset.getString("tipo_per_sal_jue"));
        permisosemanalcip.setEnt_hora_vie(dataset.getString("ent_hora_vie"));
        permisosemanalcip.setMin_ent_ant_vie(dataset.getInteger("min_ent_ant_vie"));
        permisosemanalcip.setMin_ent_des_vie(dataset.getInteger("min_ent_des_vie"));
        permisosemanalcip.setTipo_per_ent_vie(dataset.getString("tipo_per_ent_vie"));
        permisosemanalcip.setSal_hora_vie(dataset.getString("sal_hora_vie"));
        permisosemanalcip.setMin_sal_ant_vie(dataset.getInteger("min_sal_ant_vie"));
        permisosemanalcip.setMin_sal_des_vie(dataset.getInteger("min_sal_des_vie"));
        permisosemanalcip.setTipo_per_sal_vie(dataset.getString("tipo_per_sal_vie"));
        permisosemanalcip.setEnt_hora_sab(dataset.getString("ent_hora_sab"));
        permisosemanalcip.setMin_ent_ant_sab(dataset.getInteger("min_ent_ant_sab"));
        permisosemanalcip.setMin_ent_des_sab(dataset.getInteger("min_ent_des_sab"));
        permisosemanalcip.setTipo_per_ent_sab(dataset.getString("tipo_per_ent_sab"));
        permisosemanalcip.setSal_hora_sab(dataset.getString("sal_hora_sab"));
        permisosemanalcip.setMin_sal_ant_sab(dataset.getInteger("min_sal_ant_sab"));
        permisosemanalcip.setMin_sal_des_sab(dataset.getInteger("min_sal_des_sab"));
        permisosemanalcip.setTipo_per_sal_sab(dataset.getString("tipo_per_sal_sab"));
        permisosemanalcip.setEnt_hor_dom(dataset.getString("ent_hora_dom"));
        permisosemanalcip.setMin_ent_ant_dom(dataset.getInteger("min_ent_ant_dom"));
        permisosemanalcip.setMin_ent_des_dom(dataset.getInteger("min_ent_des_dom"));
        permisosemanalcip.setTipo_per_ent_dom(dataset.getString("tipo_per_ent_dom"));
        permisosemanalcip.setSal_hor_dom(dataset.getString("sal_hora_dom"));
        permisosemanalcip.setMin_sal_ant_dom(dataset.getInteger("min_sal_ant_dom"));
        permisosemanalcip.setMin_sal_des_dom(dataset.getInteger("min_sal_des_dom"));
        permisosemanalcip.setTipo_per_sal_dom(dataset.getString("tipo_per_sal_dom"));
        
        permisosemanalcip.setLunLeyNoIngresa(dataset.getString("lun_ley_no_ing"));
        permisosemanalcip.setMarLeyNoIngresa(dataset.getString("mar_ley_no_ing"));
        permisosemanalcip.setMieLeyNoIngresa(dataset.getString("mie_ley_no_ing"));
        permisosemanalcip.setJueLeyNoIngresa(dataset.getString("jue_ley_no_ing"));
        permisosemanalcip.setVieLeyNoIngresa(dataset.getString("vie_ley_no_ing"));
        permisosemanalcip.setSabLeyNoIngresa(dataset.getString("sab_ley_no_ing"));
        permisosemanalcip.setDomLeyNoIngresa(dataset.getString("dom_ley_no_ing"));
        
        permisosemanalcip.setLunLeyNoEgresa(dataset.getString("lun_ley_no_egr"));
        permisosemanalcip.setMarLeyNoEgresa(dataset.getString("mar_ley_no_egr"));
        permisosemanalcip.setMieLeyNoEgresa(dataset.getString("mie_ley_no_egr"));
        permisosemanalcip.setJueLeyNoEgresa(dataset.getString("jue_ley_no_egr"));
        permisosemanalcip.setVieLeyNoEgresa(dataset.getString("vie_ley_no_egr"));
        permisosemanalcip.setSabLeyNoEgresa(dataset.getString("sab_ley_no_egr"));
        permisosemanalcip.setDomLeyNoEgresa(dataset.getString("dom_ley_no_egr"));
        
        
        addMotivosAccesosInter(dataset,permisosemanalcip,"TMotivoEntradasInterLUN", MotEntInterPlanifS.LUNES);
        addMotivosAccesosInter(dataset,permisosemanalcip,"TMotivoEntradasInterMAR", MotEntInterPlanifS.MARTES);
        addMotivosAccesosInter(dataset,permisosemanalcip,"TMotivoEntradasInterMIE", MotEntInterPlanifS.MIERCOLES);
        addMotivosAccesosInter(dataset,permisosemanalcip,"TMotivoEntradasInterJUE", MotEntInterPlanifS.JUEVES);
        addMotivosAccesosInter(dataset,permisosemanalcip,"TMotivoEntradasInterVIE", MotEntInterPlanifS.VIERNES);
        addMotivosAccesosInter(dataset,permisosemanalcip,"TMotivoEntradasInterSAB", MotEntInterPlanifS.SABADO);
        addMotivosAccesosInter(dataset,permisosemanalcip,"TMotivoEntradasInterDOM", MotEntInterPlanifS.DOMINGO);
        
        
        
        
        addTransaccion(permisosemanalcip);
        dataset.next();
    }
  }
  
  private void addMotivosAccesosInter(IDataSet dataset,
		                              PermisoSemanalCIP permisosemanalcip,
		                              String tableName,
		                              String diaSemana) throws BaseException {
	  
	  IDataSet dsMotivos = dataset.getDataSet(tableName);
	  dsMotivos.first();
      while (!dsMotivos.EOF()) {
      	MotivoEntIntermedias motivo = MotivoEntIntermedias.findByOidProxy(
      			dsMotivos.getInteger("oid_motivo"), 
      			this.getSesion());
      	String horarioDesde = dsMotivos.getString("horario_desde");
      	String horarioHasta = dsMotivos.getString("horario_hasta");
      	String asignacion   = dsMotivos.getString("asignacion");
      	MotEntInterPlanifS motEntInterPlanifS =
      		MotEntInterPlanifS.findByOid(dsMotivos.getInteger("oid"), this.getSesion()); 
      	motEntInterPlanifS.setMotivo(motivo);
      	motEntInterPlanifS.setPermiso_semanal(permisosemanalcip);
      	motEntInterPlanifS.setHorario_desde(horarioDesde);
      	motEntInterPlanifS.setHorario_hasta(horarioHasta);
      	motEntInterPlanifS.setAsignacion(asignacion);
      	motEntInterPlanifS.setDia(diaSemana);
      	motEntInterPlanifS.setActivo(dsMotivos.getBoolean("activo"));
      	permisosemanalcip.addMotivoAccesoInter(motEntInterPlanifS);
      	dsMotivos.next();
      }	  
	  
	  
  }
  
}
