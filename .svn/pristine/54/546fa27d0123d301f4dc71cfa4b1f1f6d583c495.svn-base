package com.srn.erp.turnos.op;

import com.srn.erp.ventas.bm.Sujeto;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerInfoSujturno extends Operation { 

  public TraerInfoSujturno() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException {

	  IDataSet ds = this.getDSInfoSujTurno();
	  Sujeto sujeto = Sujeto.findByOid(mapaDatos.getInteger("oid_sujeto"), this.getSesion());
	  cargarReg(ds, sujeto);
	  writeCliente(ds);
  }

  private IDataSet getDSInfoSujTurno() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TInfoSujetoTurno");
    dataset.fieldDef(new Field("oid_sujeto", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("cod_sujeto", Field.STRING, 50));
    dataset.fieldDef(new Field("desc_sujeto", Field.STRING, 100));
    dataset.fieldDef(new Field("es_invitado", Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("categoria", Field.STRING, 50));
    return dataset;
  }

  private void cargarReg(IDataSet dataset, 
                         Sujeto sujeto) throws BaseException {
    dataset.append();
    dataset.fieldValue("oid_sujeto", sujeto.getOID()); 
    dataset.fieldValue("cod_sujeto", sujeto.getCodigo());
    dataset.fieldValue("desc_sujeto", sujeto.getRazon_social());
    dataset.fieldValue("es_invitado", sujeto.isCategoriaInvitado());
    if (sujeto.getCategoriaSujetoTurno()!=null)
    	dataset.fieldValue("categoria", sujeto.getCategoriaSujetoTurno().getDescripcion());
    else
    	dataset.fieldValue("categoria", "");
    
  }
  
}
