package com.srn.erp.turnos.op;

import java.util.Iterator;

import com.srn.erp.turnos.bm.CategoriaSujetoTurno;
import com.srn.erp.turnos.bm.ConcHabCateg;

import framework.applicarionServer.bm.Varios.Money;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerCategoriaSujetoTurno extends Operation { 

  public TraerCategoriaSujetoTurno() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    CategoriaSujetoTurno categoriasujetoturno = null;
    if (mapaDatos.containsKey("oid")) { 
       Integer oid = mapaDatos.getInteger("oid"); 
       categoriasujetoturno = CategoriaSujetoTurno.findByOid(oid, getSesion()); 
    } 
    else { 
       String codigo = mapaDatos.getString("codigo"); 
       categoriasujetoturno = CategoriaSujetoTurno.findByCodigo(codigo, getSesion()); 
    } 

    IDataSet datasetCategoriaSujetoTurno = getDataSetCategoriaSujetoTurno();
    IDataSet dsConcHab = getDataSetConcHab();
    
    if (categoriasujetoturno != null) { 
        cargarRegistroCategoriaSujetoTurno(datasetCategoriaSujetoTurno, 
                         categoriasujetoturno.getOIDInteger(),
                         categoriasujetoturno.getCodigo(),
                         categoriasujetoturno.getDescripcion(),
                         categoriasujetoturno.getComportamiento(),
                         categoriasujetoturno.isActivo(),
                         categoriasujetoturno.isNoPermitirTurno(),
                         categoriasujetoturno.getMontoMaxDeuda()
                         );
        
        Iterator iterConc = categoriasujetoturno.getConceptosHabilitados().iterator();
        while (iterConc.hasNext()) {
        	ConcHabCateg conc = (ConcHabCateg) iterConc.next();
        	cargarRegistroConc(dsConcHab, conc);
        }
        
        
    }
    
    writeCliente(datasetCategoriaSujetoTurno);
    writeCliente(dsConcHab);
    
  }

  private IDataSet getDataSetCategoriaSujetoTurno() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TCategoriaSujetoTurno");
    dataset.fieldDef(new Field("oid_categoria", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("codigo", Field.STRING, 20)); 
    dataset.fieldDef(new Field("descripcion", Field.STRING, 50)); 
    dataset.fieldDef(new Field("comportamiento", Field.STRING, 20)); 
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0)); 
    dataset.fieldDef(new Field("no_permitir_turno", Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("monto_max_deuda", Field.CURRENCY, 0));
    return dataset;
  }
  
  private IDataSet getDataSetConcHab() { 
	    IDataSet dataset = new TDataSet(); 
	    dataset.create("TConcHab");
	    dataset.fieldDef(new Field("oid_conc_hab_categ", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("oid_categoria", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("comportamiento", Field.STRING, 20));
	    dataset.fieldDef(new Field("concepto", Field.STRING, 20));
	    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
	    return dataset;
  }
  
  private void cargarRegistroConc(IDataSet dataset,
		  ConcHabCateg conc) throws BaseException {
	  dataset.append(); 
	  dataset.fieldValue("oid_conc_hab_categ", conc.getOIDInteger());
	  dataset.fieldValue("oid_categoria", conc.getOid_categoria().getOIDInteger());
	  dataset.fieldValue("comportamiento", conc.getComportamiento());
	  dataset.fieldValue("concepto",conc.getConcepto());
	  dataset.fieldValue("activo",true);
  }
  

  private void cargarRegistroCategoriaSujetoTurno(IDataSet dataset, 
                         Integer oid_categoria,
                         String codigo,
                         String descripcion,
                         String comportamiento,
                         Boolean activo,
                         Boolean noPermitirTurno,
                         Money montoMaxDeuda) {
    dataset.append(); 
    dataset.fieldValue("oid_categoria", oid_categoria);
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("descripcion", descripcion);
    dataset.fieldValue("comportamiento", comportamiento);
    dataset.fieldValue("activo", activo);
    dataset.fieldValue("no_permitir_turno", noPermitirTurno);
    dataset.fieldValue("monto_max_deuda",montoMaxDeuda);
  }
  
}
