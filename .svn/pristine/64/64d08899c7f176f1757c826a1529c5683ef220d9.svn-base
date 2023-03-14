package com.srn.erp.turnos.op;

import com.srn.erp.turnos.bm.EntidadParteTableroTurnos;
import com.srn.erp.turnos.bm.EntidadTurno;
import com.srn.erp.turnos.bm.MotivoReservaTurno;
import com.srn.erp.turnos.bm.ParteHorarioTurno;
import com.srn.erp.turnos.bm.ParteTablero;
import com.srn.erp.turnos.bm.ReservaParteTablero;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveParteTablero extends Operation { 
	
  HashTableDatos horarios = new HashTableDatos();

  public SaveParteTablero() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    IDataSet dataset = mapaDatos.getDataSet("TParteTablero"); 
    procesarRegistros(mapaDatos,dataset); 
  } 

  private void procesarRegistros(MapDatos mapaDatos,IDataSet dataset) throws BaseException {
	int i = 1;
    dataset.first(); 
      while (!dataset.EOF()) { 
        ParteTablero parteTablero = ParteTablero.findByOid(dataset.getInteger("oid_parte_tablero"),getSesion());
        parteTablero.setDescripcion(dataset.getString("descripcion"));
        parteTablero.setLunes(dataset.getBoolean("lunes"));
        parteTablero.setMartes(dataset.getBoolean("martes"));
        parteTablero.setMiercoles(dataset.getBoolean("miercoles"));
        parteTablero.setJueves(dataset.getBoolean("jueves"));
        parteTablero.setViernes(dataset	.getBoolean("viernes"));
        parteTablero.setSabado(dataset.getBoolean("sabado"));
        parteTablero.setDomingo(dataset.getBoolean("domingo"));
        parteTablero.setActivo(dataset.getBoolean("activo"));
        addTransaccion(parteTablero);
        
        IDataSet dsTablero = mapaDatos.getDataSet("Tablero");
        dsTablero.first();
        while (!dsTablero.EOF()) {
        	
        	if (dsTablero.getBoolean("es_titulo_horarios")) {
        		for (i=1;i<=100;++i) {
        			if (dsTablero.containstAttribute("horario_"+i)) {
        				ParteHorarioTurno parteHorario = null;
        				if (!parteTablero.isNew())
        					parteHorario = parteTablero.getHorario(dsTablero.getString("horario_"+i));
        				if (parteHorario == null)
        					parteHorario = (ParteHorarioTurno) ParteHorarioTurno.getNew(ParteHorarioTurno.NICKNAME, this.getSesion());
        				parteHorario.setParte_tablero(parteTablero);
        				String horario = dsTablero.getString("horario_"+i);
        				parteHorario.setHorario(horario);
        				parteHorario.setActivo(true);
        				if ((horario!=null) && (horario.length()>0)) {
        					parteTablero.addHorario(parteHorario);
        					horarios.put("horario_"+i, parteHorario);
        				}
        				
        				
        			}
        		}
        		
        	}
        	
        	
        	if (dsTablero.getBoolean("es_turno")) {
        		
        		EntidadTurno entidadTurno = EntidadTurno.findByOidProxy(dsTablero.getInteger("oid_entidad"), this.getSesion());
        		EntidadParteTableroTurnos entidadParteTablero = parteTablero.getEntidadParteTablero(entidadTurno, this.getSesion());
        		if (entidadParteTablero == null)
        			entidadParteTablero = (EntidadParteTableroTurnos) EntidadParteTableroTurnos.getNew(EntidadParteTableroTurnos.NICKNAME, this.getSesion());
        		entidadParteTablero.setEntidad_turno(entidadTurno);
        		entidadParteTablero.setParte_tablero(parteTablero);
        		entidadParteTablero.setActivo(dsTablero.getBoolean("activo"));
        		entidadParteTablero.setOrden(dsTablero.getInteger("secu"));
        		entidadParteTablero.setCambiarHorarioAlPonerTurno(dsTablero.getBoolean("cam_hor_al_pon_tur"));
        		entidadParteTablero.setMinutosTurno1Suj(dsTablero.getInteger("minu_1_suj"));
        		entidadParteTablero.setMinutosTurno2Suj(dsTablero.getInteger("minu_2_suj"));
        		entidadParteTablero.setMinutosTurno3Suj(dsTablero.getInteger("minu_3_suj"));
        		entidadParteTablero.setMinutosTurno4Suj(dsTablero.getInteger("minu_4_suj"));
        		
        		
        		if (!entidadParteTablero.isActivo())
        			entidadParteTablero.delete();
        		
        		parteTablero.addEntidad(entidadParteTablero);
        		
        		for (i=1;i<=100;++i) {
        			if ((dsTablero.containstAttribute("oid_motivo_"+i)) && (entidadParteTablero.isActivo())) {
        				ParteHorarioTurno parteHorario = (ParteHorarioTurno)horarios.get("horario_"+i);
        				String horario = "";
        				if (parteHorario!=null)
        					horario = parteHorario.getHorario();
        				
        				ReservaParteTablero reserva = parteTablero.getReserva(entidadTurno, horario, this.getSesion());
        				if (reserva == null)
        					reserva = (ReservaParteTablero) ReservaParteTablero.getNew(ReservaParteTablero.NICKNAME, this.getSesion()); 
        				reserva.setParte_tablero(parteTablero);
        				reserva.setParte_entidad(entidadParteTablero);
        				reserva.setParte_horario(parteHorario);
        				reserva.setMotivo(MotivoReservaTurno.findByOidProxy(dsTablero.getInteger("oid_motivo_"+i), this.getSesion()));
        				reserva.setComentario("");
        				reserva.setActivo(true);
        				if ((reserva.getMotivo()==null) && (!reserva.isNew())) {
        					reserva.delete();
        					parteTablero.addReserva(reserva);
        				} else if (reserva.getMotivo()!=null)
        						parteTablero.addReserva(reserva);
        				
        				
        				
        				
        			}
        		}
        		
        		
        		
        		
        	}
        	
        	dsTablero.next();
        }
        
        
        dataset.next();
    }
  }
  
}
