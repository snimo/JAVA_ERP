package com.srn.erp.turnos.op;

import com.srn.erp.turnos.bm.*;
import framework.request.bl.Operaciones.*;
import framework.request.bl.Utils.*;
import framework.request.bl.XML.IDataSet;

public class SaveCategoriaSujetoTurno extends Operation { 

  public SaveCategoriaSujetoTurno() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    IDataSet dataset = mapaDatos.getDataSet("TCategoriaSujetoTurno"); 
    procesarRegistros(dataset); 
  } 

  private void procesarRegistros(IDataSet dataset) throws BaseException { 
    dataset.first(); 
      while (!dataset.EOF()) { 
        CategoriaSujetoTurno categoriasujetoturno = CategoriaSujetoTurno.findByOid(dataset.getInteger("oid_categoria"),getSesion());
        categoriasujetoturno.setOID(dataset.getInteger("oid_categoria"));
        categoriasujetoturno.setCodigo(dataset.getString("codigo"));
        categoriasujetoturno.setDescripcion(dataset.getString("descripcion"));
        categoriasujetoturno.setComportamiento(dataset.getString("comportamiento"));
        categoriasujetoturno.setActivo(dataset.getBoolean("activo"));
        categoriasujetoturno.setNoPermitirTurno(dataset.getBoolean("no_permitir_turno"));
        categoriasujetoturno.setMontoMaxDeuda(dataset.getMoney("monto_max_deuda"));
        
        IDataSet ds = dataset.getDataSet("TConcHab");
        ds.first();
        while (!ds.EOF()) {
        	ConcHabCateg conc = ConcHabCateg.findByOid(ds.getInteger("oid_conc_hab_categ"), this.getSesion());
        	conc.setComportamiento(ds.getString("comportamiento"));
        	conc.setOid_categoria(categoriasujetoturno);
        	conc.setConcepto(ds.getString("concepto"));
        	if (ds.getBoolean("activo")==false)
        		conc.delete();
        	categoriasujetoturno.addConceptoHab(conc);
        		
        	ds.next();
        }
        
        addTransaccion(categoriasujetoturno);
        dataset.next();
    }
  }
  
}
