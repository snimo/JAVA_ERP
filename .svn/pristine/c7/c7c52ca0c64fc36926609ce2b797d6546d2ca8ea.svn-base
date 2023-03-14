package com.srn.erp.turnos.op;

import java.util.Iterator;

import com.srn.erp.turnos.bm.EstrucTableroTurnosCab;
import com.srn.erp.turnos.bm.EstrucTableroTurnosDet;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerEstrucTableroTurnosCab extends Operation { 

  public TraerEstrucTableroTurnosCab() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    EstrucTableroTurnosCab estructableroturnoscab = null;
    if (mapaDatos.containsKey("oid")) { 
       Integer oid = mapaDatos.getInteger("oid"); 
       estructableroturnoscab = EstrucTableroTurnosCab.findByOid(oid, getSesion()); 
    } 
    else { 
       String codigo = mapaDatos.getString("codigo"); 
       estructableroturnoscab = EstrucTableroTurnosCab.findByCodigo(codigo, getSesion()); 
    } 

    IDataSet datasetEstrucTableroTurnosCab = getDataSetEstrucTableroTurnosCab();
    IDataSet datasetEstrucTableroTurnosDet = getDataSetEstrucTableroTurnosDet(); 
    
    if (estructableroturnoscab != null) { 
        cargarRegistroEstrucTableroTurnosCab(datasetEstrucTableroTurnosCab, 
                         estructableroturnoscab.getOIDInteger(),
                         estructableroturnoscab.getDescripcion(),
                         estructableroturnoscab.isActivo(),
                         estructableroturnoscab.getComportamiento()
                         );
        
        Iterator iterEstrucTurCab = estructableroturnoscab.getDetalles().iterator();
        while (iterEstrucTurCab.hasNext()) {
        	EstrucTableroTurnosDet estrucDet = (EstrucTableroTurnosDet) iterEstrucTurCab.next();
        	cargarRegistroEstrucTableroTurnosDet(datasetEstrucTableroTurnosDet, estrucDet);
        }
        
    }
    
    writeCliente(datasetEstrucTableroTurnosCab);
    writeCliente(datasetEstrucTableroTurnosDet);
  }

  private IDataSet getDataSetEstrucTableroTurnosCab() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TEstrucTableroTurnosCab");
    dataset.fieldDef(new Field("oid_estruc_tab_tur", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("descripcion", Field.STRING, 100)); 
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0)); 
    dataset.fieldDef(new Field("comportamiento", Field.STRING, 20));
    return dataset;
  }
  
  private IDataSet getDataSetEstrucTableroTurnosDet() { 
	IDataSet dataset = new TDataSet(); 
	dataset.create("TEstrucTableroTurnosDet");
	dataset.fieldDef(new Field("oid_estruc_det", Field.INTEGER, 0));
	dataset.fieldDef(new Field("oid_estruc_tab_tur", Field.INTEGER, 0));
	dataset.fieldDef(new Field("oid_parte_tablero", Field.INTEGER, 0));
	dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
	dataset.fieldDef(new Field("secu", Field.INTEGER, 0));
	return dataset;
  }
  
  private void cargarRegistroEstrucTableroTurnosDet(IDataSet dataset, 
          EstrucTableroTurnosDet estrucTabDet) throws BaseException {
	  dataset.append();
	  dataset.fieldValue("oid_estruc_det", estrucTabDet.getOIDInteger());
	  dataset.fieldValue("oid_estruc_tab_tur", estrucTabDet.getEstruc_tab_cab().getOIDInteger());
	  dataset.fieldValue("oid_parte_tablero", estrucTabDet.getParte_tablero().getOIDInteger());
	  dataset.fieldValue("activo", estrucTabDet.isActivo());
	  dataset.fieldValue("secu", estrucTabDet.getSecu());
  }
  
  

  private void cargarRegistroEstrucTableroTurnosCab(IDataSet dataset, 
                         Integer oid_estruc_tab_tur,
                         String descripcion,
                         Boolean activo,
                         String comportamiento) {
    dataset.append(); 
    dataset.fieldValue("oid_estruc_tab_tur", oid_estruc_tab_tur);
    dataset.fieldValue("descripcion", descripcion);
    dataset.fieldValue("activo", activo);
    dataset.fieldValue("comportamiento", comportamiento);
    
  }
}
