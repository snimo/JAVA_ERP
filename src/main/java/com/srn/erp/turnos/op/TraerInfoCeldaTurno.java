package com.srn.erp.turnos.op;

import com.srn.erp.turnos.bm.ReservaTableroTurno;
import com.srn.erp.turnos.bm.TableroEntidadTurnos;
import com.srn.erp.turnos.bm.TableroHorarioTurnos;
import com.srn.erp.turnos.bm.TableroTurnos;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerInfoCeldaTurno extends Operation { 

  public TraerInfoCeldaTurno() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
	  
	TableroTurnos 	tablero =  TableroTurnos.findByOidProxy(mapaDatos.getInteger("oid_tablero"), this.getSesion());
	TableroEntidadTurnos tableroEntidadTurnos =  TableroEntidadTurnos.findByOidProxy(mapaDatos.getInteger("oid_tablero_entidad"), this.getSesion());
	TableroHorarioTurnos tableroHorario = tableroEntidadTurnos.getHorario(mapaDatos.getString("horario").trim());
	IDataSet ds = this.getDSInfoCeldaTurno();
	if (tableroHorario == null) {
		writeCliente(ds);
		return;
	}
	
	ReservaTableroTurno reserva = tablero.getReserva(tableroEntidadTurnos, tableroHorario);
	
	cargarRegistro(ds, reserva, tablero, tableroEntidadTurnos, tableroHorario);
	writeCliente(ds);
	
	
  }

  private IDataSet getDSInfoCeldaTurno() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TInfoCeldaTurno");
    dataset.fieldDef(new Field("oid_reserva", Field.INTEGER, 0));
    dataset.fieldDef(new Field("contenido", Field.STRING, 500));
    dataset.fieldDef(new Field("observacion", Field.STRING, 5000));
    dataset.fieldDef(new Field("oid_tablero", Field.INTEGER, 0));
    dataset.fieldDef(new Field("desc_tablero", Field.STRING, 100));
    dataset.fieldDef(new Field("oid_tablero_entidad", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_entidad", Field.INTEGER, 0));
    dataset.fieldDef(new Field("desc_entidad", Field.STRING, 20));
    dataset.fieldDef(new Field("oid_tablero_horario", Field.INTEGER, 0));
    dataset.fieldDef(new Field("horario", Field.STRING, 20));
    dataset.fieldDef(new Field("oid_suj_1", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_suj_1", Field.STRING, 50));
    dataset.fieldDef(new Field("desc_suj_1", Field.STRING, 100));
    dataset.fieldDef(new Field("oid_suj_2", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_suj_2", Field.STRING, 50));
    dataset.fieldDef(new Field("desc_suj_2", Field.STRING, 100));
    dataset.fieldDef(new Field("oid_suj_3", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_suj_3", Field.STRING, 50));
    dataset.fieldDef(new Field("desc_suj_3", Field.STRING, 100));
    dataset.fieldDef(new Field("oid_suj_4", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_suj_4", Field.STRING, 50));
    dataset.fieldDef(new Field("desc_suj_4", Field.STRING, 100));
    dataset.fieldDef(new Field("comportamiento", Field.STRING, 20));
    dataset.fieldDef(new Field("presentacion", Field.STRING, 5000));
    dataset.fieldDef(new Field("oid_motivo", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_motivo", Field.STRING, 50));
    dataset.fieldDef(new Field("desc_motivo", Field.STRING, 100));
    
    dataset.fieldDef(new Field("autoriz_1",Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("autoriz_2",Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("autoriz_3",Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("autoriz_4",Field.BOOLEAN, 0));
    
    dataset.fieldDef(new Field("regla_act_1",Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("regla_act_2",Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("regla_act_3",Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("regla_act_4",Field.BOOLEAN, 0));
    
    
    
    return dataset;
  }

  private void cargarRegistro(IDataSet dataset,
		  				 ReservaTableroTurno reserva,
		  				 TableroTurnos tablero,
		  				 TableroEntidadTurnos tableroEntidad,
		  				 TableroHorarioTurnos tableroHorario	
                         ) throws BaseException {
    dataset.append();
    if (reserva!=null) {
    	dataset.fieldValue("oid_reserva", reserva.getOIDInteger());
    	dataset.fieldValue("contenido", reserva.getPresentacion());
    	dataset.fieldValue("observacion", reserva.getComentario());
    }
    else {
    	dataset.fieldValue("oid_reserva", new Integer(0));
    	dataset.fieldValue("contenido", "");
    	dataset.fieldValue("observacion", "");
    }
    dataset.fieldValue("oid_tablero", tablero.getOIDInteger());
    dataset.fieldValue("desc_tablero", tablero.getDescripcion());
    dataset.fieldValue("oid_tablero_entidad", tableroEntidad.getOIDInteger());
    dataset.fieldValue("oid_entidad", tableroEntidad.getEntidad_turno().getOIDInteger());
    dataset.fieldValue("desc_entidad", tableroEntidad.getEntidad_turno().getCodigo());
    dataset.fieldValue("oid_tablero_horario", tableroHorario.getOIDInteger());
    dataset.fieldValue("horario", tableroHorario.getHorario());
    if ((reserva!=null) && (reserva.getSujeto1()!=null)) {
    	dataset.fieldValue("oid_suj_1", reserva.getSujeto1().getOIDInteger()); 
    	dataset.fieldValue("cod_suj_1", reserva.getSujeto1().getCodigo());
    	dataset.fieldValue("desc_suj_1", reserva.getSujeto1().getRazon_social());
    } else {
    	dataset.fieldValue("oid_suj_1", new Integer(0)); 
    	dataset.fieldValue("cod_suj_1", "");
    	dataset.fieldValue("desc_suj_1", "");
    }
    if ((reserva!=null) && (reserva.getSujeto2()!=null)) {
    	dataset.fieldValue("oid_suj_2", reserva.getSujeto2().getOIDInteger()); 
    	dataset.fieldValue("cod_suj_2", reserva.getSujeto2().getCodigo());
    	dataset.fieldValue("desc_suj_2", reserva.getSujeto2().getRazon_social());
    } else {
    	dataset.fieldValue("oid_suj_2", new Integer(0)); 
    	dataset.fieldValue("cod_suj_2", "");
    	dataset.fieldValue("desc_suj_2", "");
    }
    
    if ((reserva!=null) && (reserva.getSujeto3()!=null)) {
    	dataset.fieldValue("oid_suj_3", reserva.getSujeto3().getOIDInteger()); 
    	dataset.fieldValue("cod_suj_3", reserva.getSujeto3().getCodigo());
    	dataset.fieldValue("desc_suj_3", reserva.getSujeto3().getRazon_social());
    } else {
    	dataset.fieldValue("oid_suj_3", new Integer(0)); 
    	dataset.fieldValue("cod_suj_3", "");
    	dataset.fieldValue("desc_suj_3", "");
    }
    
    if ((reserva!=null) && (reserva.getSujeto4()!=null)) {
    	dataset.fieldValue("oid_suj_4", reserva.getSujeto4().getOIDInteger()); 
    	dataset.fieldValue("cod_suj_4", reserva.getSujeto4().getCodigo());
    	dataset.fieldValue("desc_suj_4", reserva.getSujeto4().getRazon_social());
    } else {
    	dataset.fieldValue("oid_suj_4", new Integer(0)); 
    	dataset.fieldValue("cod_suj_4", "");
    	dataset.fieldValue("desc_suj_4", "");
    }
    
    if (reserva!=null) {
    	dataset.fieldValue("comportamiento", reserva.getCompo_tipo_res());
    	dataset.fieldValue("presentacion", reserva.getPresentacion());
    	if (reserva.getMotivo()!=null) {
    		dataset.fieldValue("oid_motivo", reserva.getMotivo().getOIDInteger());
    		dataset.fieldValue("cod_motivo", reserva.getMotivo().getCodigo());
    		dataset.fieldValue("desc_motivo", reserva.getMotivo().getDescripcion());
    	} else {
    		dataset.fieldValue("oid_motivo", new Integer(0));
    		dataset.fieldValue("cod_motivo", "");
    		dataset.fieldValue("desc_motivo", "");
    	}
    	
    }
    else {
    	dataset.fieldValue("comportamiento", "");
    	dataset.fieldValue("presentacion", "");
		dataset.fieldValue("oid_motivo", new Integer(0));
		dataset.fieldValue("cod_motivo", "");
		dataset.fieldValue("desc_motivo", "");
    	
    }
    
    if (reserva!=null) {
    	dataset.fieldValue("autoriz_1",reserva.isAutorizado1());
    	dataset.fieldValue("autoriz_2",reserva.isAutorizado2());
    	dataset.fieldValue("autoriz_3",reserva.isAutorizado3());
    	dataset.fieldValue("autoriz_4",reserva.isAutorizado4());
    	
    	dataset.fieldValue("regla_act_1",reserva.isReglaAct1());
    	dataset.fieldValue("regla_act_2",reserva.isReglaAct2());
    	dataset.fieldValue("regla_act_3",reserva.isReglaAct3());
    	dataset.fieldValue("regla_act_4",reserva.isReglaAct4());
    } else {
    	dataset.fieldValue("autoriz_1",false);
    	dataset.fieldValue("autoriz_2",false);
    	dataset.fieldValue("autoriz_3",false);
    	dataset.fieldValue("autoriz_4",false);
    	
    	dataset.fieldValue("regla_act_1",false);
    	dataset.fieldValue("regla_act_2",false);
    	dataset.fieldValue("regla_act_3",false);
    	dataset.fieldValue("regla_act_4",false);
    }
    
  }
}
