package com.srn.erp.turnos.op;

import java.util.Iterator;

import com.srn.erp.ventas.bm.Sujeto;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerSujInviTurnos extends Operation { 

  public TraerSujInviTurnos() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    String filtro = mapaDatos.getString("filtro");
    
    HashTableDatos condiciones = new HashTableDatos();
    condiciones.put("razon_social", filtro);
    condiciones.put("CATEG_INVITADO", "");
    
    IDataSet ds = this.getDSSujInv();
    Iterator iterSujetos = Sujeto.getHelpClientes(condiciones, this.getSesion()).iterator();
    while (iterSujetos.hasNext()) {
    	Sujeto sujeto = (Sujeto) iterSujetos.next();
    	cargarRegistro(ds, sujeto);
    }
    writeCliente(ds);
  }

  private void cargarRegistro(IDataSet dataset, 
                         Sujeto sujeto) throws BaseException {
    dataset.append();
    dataset.fieldValue("sel", new Boolean(false));
    dataset.fieldValue("oid_sujeto", sujeto.getOIDInteger());
    dataset.fieldValue("cod_sujeto", sujeto.getCodigo());
    dataset.fieldValue("desc_sujeto", sujeto.getRazon_social());
  }
  
  private IDataSet getDSSujInv() {
	IDataSet dataset = new TDataSet();
	dataset.create("TSujetosInvitados");
	dataset.fieldDef(new Field("sel", Field.BOOLEAN, 0));
	dataset.fieldDef(new Field("oid_sujeto", Field.INTEGER, 0));
	dataset.fieldDef(new Field("cod_sujeto", Field.STRING, 50));
	dataset.fieldDef(new Field("desc_sujeto", Field.STRING, 100));
	return dataset;
  }
  
}
