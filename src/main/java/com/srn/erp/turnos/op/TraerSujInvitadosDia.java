package com.srn.erp.turnos.op;

import java.util.Iterator;

import com.srn.erp.turnos.bm.TableroTurnos;
import com.srn.erp.ventas.bm.Sujeto;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerSujInvitadosDia extends Operation { 

	
  private HashTableDatos listaSujetos = new HashTableDatos();
  
  public TraerSujInvitadosDia() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
	  
	// Obtener invitados del Tablero
	TableroTurnos tablero = 
		TableroTurnos.findByOid(mapaDatos.getInteger("oid_tablero"), this.getSesion());
	Iterator iterSujInvitados = 
		tablero.getSujetosInvitados().iterator();
	while (iterSujInvitados.hasNext()) {
		Sujeto sujeto = (Sujeto) iterSujInvitados.next();
		listaSujetos.put(sujeto.getOIDInteger(), sujeto);
	}
	
	// Obtener sujetos dados de alta a la Fecha
	iterSujInvitados =
		Sujeto.getSujetosInvitadosConFecIng(tablero.getFecha(), this.getSesion()).iterator();
	while (iterSujInvitados.hasNext()) {
		Sujeto sujeto = (Sujeto) iterSujInvitados.next();
		if (listaSujetos.get(sujeto.getOIDInteger())==null)
			listaSujetos.put(sujeto.getOIDInteger(), sujeto);
	}
	
	IDataSet ds = this.getDSInvitadosDia();
	
	iterSujInvitados = listaSujetos.values().iterator();
	while (iterSujInvitados.hasNext()) {
		Sujeto sujeto = (Sujeto) iterSujInvitados.next();
		cargarRegistro(ds, sujeto);
	}
	writeCliente(ds);
	
  }
	

  private IDataSet getDSInvitadosDia() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TInvitadosDia");
    dataset.fieldDef(new Field("sel", Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("oid_sujeto", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_sujeto", Field.STRING, 50));
    dataset.fieldDef(new Field("desc_sujeto", Field.STRING, 100));
    return dataset;
  }

  private void cargarRegistro(IDataSet dataset, 
                         Sujeto sujeto) throws BaseException {
    dataset.append(); 
    dataset.fieldValue("sel", new Boolean(false));
    dataset.fieldValue("oid_sujeto", sujeto.getOIDInteger());
    dataset.fieldValue("cod_sujeto", sujeto.getCodigo());
    dataset.fieldValue("desc_sujeto", sujeto.getRazon_social());
  }
}
