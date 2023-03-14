package com.srn.erp.presupuesto.op;

import java.util.Iterator;

import com.srn.erp.presupuesto.bm.CompoPresupuestario;
import com.srn.erp.presupuesto.bm.GrupoComponente;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerArbolComponentes extends Operation { 

  public TraerArbolComponentes() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 

    IDataSet datasetArbolCompo = this.getDataSetArbolComponentes();
    
    Iterator iterGrupos = GrupoComponente.getAllGrupos(this.getSesion()).iterator();
    while (iterGrupos.hasNext()) {
    	GrupoComponente grupoCompo = (GrupoComponente) iterGrupos.next();
    	if (grupoCompo.isActivo().booleanValue())
    		cargarCompoGrupo(datasetArbolCompo,grupoCompo);
    }
    
    writeCliente(datasetArbolCompo);
    
  }
  
  private void cargarCompoGrupo(IDataSet ds,GrupoComponente grupoCompo) throws BaseException {
  	Integer oidRelacionGrupo = new Integer(grupoCompo.getOIDInteger().intValue()*-1);
  	Integer sinPadre = new Integer(0);
  	Integer nroImagenGrupo = new Integer(0);
  	Integer nroImagenCompo = new Integer(1);
  	
  	cargarRegArbolCompo(ds,
  											oidRelacionGrupo,
  			                sinPadre,
  			                grupoCompo.getDescripcion(),
  			                nroImagenGrupo);
  	
  	Iterator iterCompoPresu = grupoCompo.getComponentesPresupuestarios().iterator();
  	while (iterCompoPresu.hasNext()) {
  		CompoPresupuestario compoPresu = (CompoPresupuestario) iterCompoPresu.next();
  		if (compoPresu.isActivo().booleanValue()) {
  	  	cargarRegArbolCompo(ds,
            compoPresu.getOIDInteger(),
            oidRelacionGrupo,
            compoPresu.getDescripcion(),
            nroImagenCompo);
  		}  		
  	}
  }
  
  private IDataSet getDataSetArbolComponentes() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TArbolComponentes");
    dataset.fieldDef(new Field("oid_relacion", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_relacion_padre", Field.INTEGER, 0));
    dataset.fieldDef(new Field("descripcion", Field.STRING, 100));
    dataset.fieldDef(new Field("nro_icono", Field.INTEGER, 100));
    return dataset;
  }

  private void cargarRegArbolCompo(IDataSet dataset, 
                         Integer oidRelacion,
                         Integer oidRelacionPadre,
                         String descripcion,
                         Integer nroIcono) {
    dataset.append(); 
    dataset.fieldValue("oid_relacion", oidRelacion);
    dataset.fieldValue("oid_relacion_padre", oidRelacionPadre);
    dataset.fieldValue("descripcion", descripcion);
    dataset.fieldValue("nro_icono", nroIcono);
  }
}
