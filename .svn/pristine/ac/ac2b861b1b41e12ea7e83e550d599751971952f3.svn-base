package com.srn.erp.turnos.op;

import java.util.Iterator;

import com.srn.erp.turnos.bm.DeudaPorConcTurno;
import com.srn.erp.turnos.bm.GrupoConceptoTurno;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerDeudaPorConcTurno extends Operation { 

  public TraerDeudaPorConcTurno() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    DeudaPorConcTurno deudaporconcturno = null;
    if (mapaDatos.containsKey("oid")) { 
       Integer oid = mapaDatos.getInteger("oid"); 
       deudaporconcturno = DeudaPorConcTurno.findByOid(oid, getSesion()); 
    } 
    else { 
       String codigo = mapaDatos.getString("codigo"); 
       deudaporconcturno = DeudaPorConcTurno.findByCodigo(codigo, getSesion()); 
    } 

    int i = 0;
    IDataSet datasetDeudaPorConcTurno = getDataSetDeudaPorConcTurno();
    IDataSet datasetConceptos = getDSConceptos();
    
    if (deudaporconcturno != null) { 
        
    	cargarRegistroDeudaPorConcTurno(datasetDeudaPorConcTurno, 
                         deudaporconcturno.getOIDInteger(),
                         deudaporconcturno.getDescripcion(),
                         deudaporconcturno.getComportamiento(),
                         deudaporconcturno.getMax_dias_atraso(),
                         deudaporconcturno.getMax_deuda(),
                         deudaporconcturno.isActivo(),
                         deudaporconcturno.getCantMaxPeriDeuda()
                         );
        
    	
    	HashTableDatos conceptos = GrupoConceptoTurno.getConceptosSisteClubes(this.getSesion());
    	Iterator iterCodConc = conceptos.keySet().iterator();
    	while (iterCodConc.hasNext()) {
    		String codigo = (String) iterCodConc.next();
    		String descripcion = (String) conceptos.get(codigo);
    		GrupoConceptoTurno grupoConcepto = GrupoConceptoTurno.getGrupoConceptoTurno(deudaporconcturno, codigo, this.getSesion());
    		boolean encontro = false;
    		if (grupoConcepto!=null)
    			encontro = true;
    		cargarConcepto(datasetConceptos, ++i, deudaporconcturno.getOIDInteger(), codigo, descripcion, encontro);
    	}
    	
        
    }
    
    writeCliente(datasetDeudaPorConcTurno);
    writeCliente(datasetConceptos);
    
  }

  private IDataSet getDataSetDeudaPorConcTurno() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TDeudaPorConcTurno");
    dataset.fieldDef(new Field("oid_deuda_conc", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("descripcion", Field.STRING, 50)); 
    dataset.fieldDef(new Field("comportamiento", Field.STRING, 20)); 
    dataset.fieldDef(new Field("max_dias_atraso", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("max_deuda", Field.CURRENCY, 0)); 
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0)); 
    dataset.fieldDef(new Field("cant_max_peri_deu", Field.INTEGER, 0));
    return dataset;
  }
  
  private IDataSet getDSConceptos() { 
	    IDataSet dataset = new TDataSet(); 
	    dataset.create("TConceptos");
	    dataset.fieldDef(new Field("oid_grupo_conc", Field.INTEGER, 0)); 
	    dataset.fieldDef(new Field("oid_deuda_conc", Field.INTEGER, 50));
	    dataset.fieldDef(new Field("concepto", Field.STRING, 20));
	    dataset.fieldDef(new Field("desc_concepto", Field.STRING, 50));
	    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
	    return dataset;
  }
  
  private void cargarConcepto(IDataSet ds,
		  					  Integer oidGrupoConc,
		  					  Integer oidDeudaConc,
		  					  String concepto,
		  					  String descConcepto,
		  					  Boolean activo) throws BaseException {
	  ds.append();
	  ds.fieldValue("oid_grupo_conc", oidGrupoConc); 
	  ds.fieldValue("oid_deuda_conc", oidDeudaConc);
	  ds.fieldValue("concepto", concepto);
	  ds.fieldValue("desc_concepto", descConcepto);
	  ds.fieldValue("activo", activo);
  }
  

  private void cargarRegistroDeudaPorConcTurno(IDataSet dataset, 
                         Integer oid_deuda_conc,
                         String descripcion,
                         String comportamiento,
                         Integer max_dias_atraso,
                         Double max_deuda,
                         Boolean activo,
                         Integer maxCantPeriAdeu) {
    dataset.append(); 
    dataset.fieldValue("oid_deuda_conc", oid_deuda_conc);
    dataset.fieldValue("descripcion", descripcion);
    dataset.fieldValue("comportamiento", comportamiento);
    dataset.fieldValue("max_dias_atraso", max_dias_atraso);
    dataset.fieldValue("max_deuda", max_deuda);
    dataset.fieldValue("activo", activo);
    dataset.fieldValue("cant_max_peri_deu", maxCantPeriAdeu);
  }
}
