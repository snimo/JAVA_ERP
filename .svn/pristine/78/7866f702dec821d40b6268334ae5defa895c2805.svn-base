package com.srn.erp.turnos.op;

import java.util.Iterator;

import com.srn.erp.turnos.bm.EntidadParteTableroTurnos;
import com.srn.erp.turnos.bm.ParteHorarioTurno;
import com.srn.erp.turnos.bm.ParteTablero;
import com.srn.erp.turnos.bm.ReservaParteTablero;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerParteTablero extends Operation { 

  public TraerParteTablero() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
	  
    ParteTablero parte = null;
    if (mapaDatos.containsKey("oid")) { 
       Integer oid = mapaDatos.getInteger("oid"); 
       parte = ParteTablero.findByOid(oid, getSesion()); 
    } 
    else { 
       String codigo = mapaDatos.getString("codigo"); 
       parte = ParteTablero.findByCodigo(codigo, getSesion()); 
    } 

    IDataSet ds = getDataSetParteTablero();    
    IDataSet dsTablero = getDataSetTablero();
    IDataSet dsHorarios = getDataSetHorario();
    
    if (parte != null) { 
        cargarRegistro(ds,parte);
        enviarTablero(dsTablero,parte);
        enviarHorarios(dsHorarios,parte);
    }
    
    writeCliente(ds);
    writeCliente(dsTablero);
    writeCliente(dsHorarios);
    
  }

  private IDataSet getDataSetParteTablero() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TParteTablero");
    dataset.fieldDef(new Field("oid_parte_tablero", Field.INTEGER, 0));
    dataset.fieldDef(new Field("descripcion", Field.STRING, 100));
    dataset.fieldDef(new Field("lunes", Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("martes", Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("miercoles", Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("jueves", Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("viernes", Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("sabado", Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("domingo", Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0)); 
    
    return dataset;
  }
  
  private IDataSet getDataSetHorario() { 
	 IDataSet dataset = new TDataSet(); 
	 dataset.create("THorariosFormateados");
	 dataset.fieldDef(new Field("horario", Field.STRING, 13));
	 return dataset;
  }
  
  private IDataSet getDataSetTablero() { 
	 IDataSet dataset = new TDataSet(); 
	 dataset.create("Tablero");
	 dataset.fieldDef(new Field("secu", Field.INTEGER, 0));
	 dataset.fieldDef(new Field("oid_entidad", Field.INTEGER, 0));
	 dataset.fieldDef(new Field("entidad", Field.STRING, 100));
	 dataset.fieldDef(new Field("es_titulo_horarios", Field.BOOLEAN, 0));
	 dataset.fieldDef(new Field("read_only", Field.BOOLEAN, 0));
	 dataset.fieldDef(new Field("es_turno", Field.BOOLEAN, 0));
	 dataset.fieldDef(new Field("oid_parte_entidad", Field.INTEGER, 0));
	 dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));

	 dataset.fieldDef(new Field("cam_hor_al_pon_tur", Field.BOOLEAN, 0));
	 dataset.fieldDef(new Field("minu_1_suj", Field.INTEGER, 0));
	 dataset.fieldDef(new Field("minu_2_suj", Field.INTEGER, 0));
	 dataset.fieldDef(new Field("minu_3_suj", Field.INTEGER, 0));
	 dataset.fieldDef(new Field("minu_4_suj", Field.INTEGER, 0));
	 
	 
	 int i=1;
	 for (i=1;i<=100;++i) 
		 dataset.fieldDef(new Field("horario_"+i, Field.STRING, 13));
	 
	 for (i=1;i<=100;++i) 
		 dataset.fieldDef(new Field("oid_motivo_"+i, Field.INTEGER, 0));
	 
	 return dataset;
  }
  
  private void enviarTablero(IDataSet dsTablero,ParteTablero parte) throws BaseException {
	  enviarRenglonHorarios(dsTablero,parte);
      enviarTurnos(dsTablero,parte);
  }
  
  private void enviarTurnos(IDataSet dsHorarios,ParteTablero parte) throws BaseException {
	  
	  Iterator iterEntidades = parte.getEntidades().iterator();
	  while (iterEntidades.hasNext()) {
		  EntidadParteTableroTurnos entidadParteTablero = (EntidadParteTableroTurnos) iterEntidades.next();
		  
		  dsHorarios.append();
		  dsHorarios.fieldValue("secu", entidadParteTablero.getOrden());
		  dsHorarios.fieldValue("oid_entidad", entidadParteTablero.getEntidad_turno().getOIDInteger());
		  dsHorarios.fieldValue("entidad", entidadParteTablero.getEntidad_turno().getCodigo());
		  dsHorarios.fieldValue("es_titulo_horarios", new Boolean(false));
		  dsHorarios.fieldValue("read_only", new Boolean(false));
		  dsHorarios.fieldValue("es_turno", new Boolean(true));
		  dsHorarios.fieldValue("oid_parte_entidad", entidadParteTablero.getOIDInteger());
		  dsHorarios.fieldValue("activo", new Boolean(true));
		  
		  dsHorarios.fieldValue("cam_hor_al_pon_tur", entidadParteTablero.isCambiarHorarioAlPonerTurno());
		  dsHorarios.fieldValue("minu_1_suj", entidadParteTablero.getMinutosTur1Suj());
		  dsHorarios.fieldValue("minu_2_suj", entidadParteTablero.getMinutosTur2Suj());
		  dsHorarios.fieldValue("minu_3_suj", entidadParteTablero.getMinutosTur3Suj());
		  dsHorarios.fieldValue("minu_4_suj", entidadParteTablero.getMinutosTur4Suj());
		  
		  
		  
		  int i , j = 1;
		  
		  i = 1;
		  Iterator iterHorarios = parte.getHorarios().iterator();
		  while (iterHorarios.hasNext()) {
			  ParteHorarioTurno parteHorario = (ParteHorarioTurno) iterHorarios.next();
			  
			  ReservaParteTablero reserva = parte.getReserva(entidadParteTablero.getEntidad_turno(), parteHorario.getHorario(), this.getSesion());
			  if ((reserva!=null) && (reserva.getMotivo()!=null))
				  dsHorarios.fieldValue("horario_"+i, reserva.getMotivo().getDescripcion());
			  else
				  dsHorarios.fieldValue("horario_"+i, "");
			  ++i;
		  }
		  for (j=i;j<=100;++j) {
			  dsHorarios.fieldValue("horario_"+j, "");
		  }

		  i = 1;
		  iterHorarios = parte.getHorarios().iterator();
		  while (iterHorarios.hasNext()) {
			  ParteHorarioTurno parteHorario = (ParteHorarioTurno) iterHorarios.next();
			  
			  ReservaParteTablero reserva = parte.getReserva(entidadParteTablero.getEntidad_turno(), parteHorario.getHorario(), this.getSesion());
			  if ((reserva!=null) && (reserva.getMotivo()!=null))
				  dsHorarios.fieldValue("oid_motivo_"+i, reserva.getMotivo().getOIDInteger());
			  else
				  dsHorarios.fieldValue("oid_motivo_"+i, "");
			  ++i;
		  }
		  for (j=i;j<=100;++j) {
			  dsHorarios.fieldValue("oid_motivo_"+j, new Integer(0));
		  }			  
		  
	  }
	  
	  
	  
	    
  }
  
  private void enviarRenglonHorarios(IDataSet dsHorario,ParteTablero parte) throws BaseException {

	  dsHorario.append();
	  dsHorario.fieldValue("secu", 1);
	  dsHorario.fieldValue("oid_entidad", new Integer(0));
	  dsHorario.fieldValue("entidad", "");
	  dsHorario.fieldValue("es_titulo_horarios", new Boolean(true));
	  dsHorario.fieldValue("read_only", new Boolean(true));
	  dsHorario.fieldValue("es_turno", new Boolean(false));
	  
	  dsHorario.fieldValue("oid_parte_entidad", new Integer(0));
	  dsHorario.fieldValue("activo", new Boolean(true));
	  
	  dsHorario.fieldValue("cam_hor_al_pon_tur", new Boolean(false));
	  dsHorario.fieldValue("minu_1_suj", new Integer(0));
	  dsHorario.fieldValue("minu_2_suj", new Integer(0));
	  dsHorario.fieldValue("minu_3_suj", new Integer(0));
	  dsHorario.fieldValue("minu_4_suj", new Integer(0));
	  
	  
	  int i , j = 1;
	  
	  i = 1;
	  Iterator iterHorarios = parte.getHorarios().iterator();
	  while (iterHorarios.hasNext()) {
		  ParteHorarioTurno parteHorario = (ParteHorarioTurno) iterHorarios.next();
		  dsHorario.fieldValue("horario_"+i, parteHorario.getHorario());
		  ++i;
	  }
	  for (j=i;j<=100;++j) {
		  dsHorario.fieldValue("horario_"+j, "");
	  }
	  
	  for (j=1;j<=100;++j) {
		  dsHorario.fieldValue("oid_motivo_"+j, new Integer(0));
	  }
	  
	  
  }
  
  private void enviarHorarios(IDataSet dsHorarios,ParteTablero parte) throws BaseException {

	  Iterator iterHorarios = parte.getHorarios().iterator();
	  while (iterHorarios.hasNext()) {
		  ParteHorarioTurno parteHorario = (ParteHorarioTurno) iterHorarios.next();
		  dsHorarios.append();
		  dsHorarios.fieldValue("horario", parteHorario.getHorario());
	  }
	  
  }
  

  private void cargarRegistro(IDataSet dataset,ParteTablero parte 
                         ) throws BaseException {
    dataset.append();
    dataset.fieldValue("oid_parte_tablero", parte.getOIDInteger());
    dataset.fieldValue("descripcion", parte.getDescripcion());
    dataset.fieldValue("lunes", parte.isLunes());
    dataset.fieldValue("martes", parte.isMartes());
    dataset.fieldValue("miercoles", parte.isMiercoles());
    dataset.fieldValue("jueves", parte.isJueves());
    dataset.fieldValue("viernes", parte.isViernes());
    dataset.fieldValue("sabado", parte.isSabado());
    dataset.fieldValue("domingo", parte.isDomingo());
    dataset.fieldValue("activo", parte.isActivo()); 
  }
}
