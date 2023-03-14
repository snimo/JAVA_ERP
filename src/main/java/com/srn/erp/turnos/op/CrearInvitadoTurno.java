package com.srn.erp.turnos.op;

import com.srn.erp.turnos.bm.CategoriaSujetoTurno;
import com.srn.erp.turnos.bm.RelacionSujetoTurno;
import com.srn.erp.turnos.bm.TableroTurnos;
import com.srn.erp.ventas.bm.Sujeto;
import com.srn.erp.ventas.bm.TipoDocumento;

import framework.applicarionServer.bl.Utils.Fecha;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;

public class CrearInvitadoTurno extends Operation { 
	
  public CrearInvitadoTurno() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
	  
	String nombre = mapaDatos.getString("nombre");
	
	
	Integer secu = this.getSesion().getNewOIDByKey(TableroTurnos.SECU_INVI_TUR);
	Integer minimo = TableroTurnos.getNroMinimoInvitado(this.getSesion());
	
	Sujeto sujeto = null;
	sujeto = (Sujeto)Sujeto.getNew(Sujeto.NICKNAME, this.getSesion());
	Integer codigo = secu.intValue() + minimo.intValue();
	sujeto.setCodigo(codigo.toString());
	sujeto.setNroTarjeta(codigo.toString());
	sujeto.setActivo(new Boolean(true));
	sujeto.setFisica_juridica("F");
	sujeto.setTipo_documento(TipoDocumento.getTipoDocumentoImportacionSujTurnos(this.getSesion()));
	sujeto.setDeshabilitarCodigoAutomatico(true);
	sujeto.setEs_cliente(new Boolean(true));
	sujeto.setCategoriaSujetoTurno(CategoriaSujetoTurno.getCategSujTurnoInvitado(this.getSesion()));
	sujeto.setFecha_ingreso(Fecha.getFechaActual());
	sujeto.setRazon_social(nombre);
	sujeto.setRelacionSujetoTurno(RelacionSujetoTurno.getRelacionSujetoTurno(this.getSesion()));
	sujeto.setActivo(new Boolean(true));
	
	this.addTransaccion(sujeto);
	
	
	
	
  } 

    
}
