package com.srn.erp.cubo.op;

import com.srn.erp.cubo.bm.DimensionCubo;
import com.srn.erp.general.bm.ClasificadorEntidad;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.xlook.bm.Select;

public class SaveDimensionCubo extends Operation { 

  public SaveDimensionCubo() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    IDataSet dataset = mapaDatos.getDataSet("TDimensionCubo"); 
    procesarRegistros(dataset); 
  } 

  private void procesarRegistros(IDataSet dataset) throws BaseException { 
    dataset.first(); 
      while (!dataset.EOF()) { 
        DimensionCubo dimensioncubo = DimensionCubo.findByOid(dataset.getInteger("oid_dimension"),getSesion());
        dimensioncubo.setOID(dataset.getInteger("oid_dimension"));
        dimensioncubo.setCodigo(dataset.getString("codigo"));
        dimensioncubo.setDescripcion(dataset.getString("descripcion"));
        dimensioncubo.setTipo_dimension(dataset.getString("tipo_dimension"));
        dimensioncubo.setSelect(Select.findByOidProxy(dataset.getInteger("oid_select"),getSesion()));
        dimensioncubo.setNombre_oper(dataset.getString("nombre_oper"));
        dimensioncubo.setClasificador_entidad(ClasificadorEntidad.findByOidProxy(dataset.getInteger("oid_clasif_ent"),getSesion()));
        dimensioncubo.setActivo(dataset.getBoolean("activo"));
        addTransaccion(dimensioncubo);
        dataset.next();
    }
  }
  
}
