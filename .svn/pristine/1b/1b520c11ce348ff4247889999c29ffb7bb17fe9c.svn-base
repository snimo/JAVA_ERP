package com.srn.erp.compras.op;

import java.util.Iterator;

import com.srn.erp.compras.bm.AcuerdoLP;
import com.srn.erp.compras.bm.Proveedor;
import com.srn.erp.compras.bm.TipoAcuerdo;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerHelpAcuerdosPrecioProv extends Operation { 

  public TraerHelpAcuerdosPrecioProv() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
	  
	Proveedor proveedor = null;
	TipoAcuerdo tipoAcuerdo = null;
	
	if (mapaDatos.containsKey("oid_proveedor"))
		proveedor = Proveedor.findByOidProxy(mapaDatos.getInteger("oid_proveedor"),getSesion());
	if (mapaDatos.containsKey("oid_tipo_acuerdo"))
		tipoAcuerdo = TipoAcuerdo.findByOidProxy(mapaDatos.getInteger("oid_tipo_acuerdo"),getSesion());	

    IDataSet datasetAcuerdoLP = getDataSetAcuerdoLP();
    Iterator iterAcuerdos = AcuerdoLP.getAcuerdosLP(proveedor,tipoAcuerdo,getSesion()).iterator();
    while (iterAcuerdos.hasNext()) {
    	AcuerdoLP acuerdolp = (AcuerdoLP) iterAcuerdos.next();
    	cargarRegistroAcuerdoLP(datasetAcuerdoLP,
    			acuerdolp.getOIDInteger(),
    			acuerdolp.getDescripcion(),
        		acuerdolp.getProveedor(),
        		acuerdolp.isActivo(),
        		acuerdolp.getTipo_acuerdo().getDescripcion());
    }
    writeCliente(datasetAcuerdoLP);
  }

  private IDataSet getDataSetAcuerdoLP() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("THelpAcuerdoPrecios");
    dataset.fieldDef(new Field("oid", Field.INTEGER, 0));
    dataset.fieldDef(new Field("descripcion", Field.STRING, 50));
    dataset.fieldDef(new Field("oid_proveedor", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("cod_proveedor", Field.STRING, 30));
    dataset.fieldDef(new Field("rs_proveedor", Field.STRING, 100));
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0)); 
    dataset.fieldDef(new Field("tipo_acuerdo", Field.STRING, 50));
    return dataset;
  }

  private void cargarRegistroAcuerdoLP(IDataSet dataset,
		  							   Integer oid,
		  							   String descripcion,
                         			   Proveedor proveedor,
                         			   Boolean activo,
                         			   String tipoAcuerdo) throws BaseException {
    dataset.append();
    dataset.fieldValue("oid", oid);
    dataset.fieldValue("descripcion", descripcion);
    dataset.fieldValue("oid_proveedor", proveedor.getOIDInteger());
    dataset.fieldValue("cod_proveedor", proveedor.getCodigo());
    dataset.fieldValue("rs_proveedor", proveedor.getRazonsocial());
    dataset.fieldValue("activo", activo);
    dataset.fieldValue("tipo_acuerdo", tipoAcuerdo);
    
  }
}
