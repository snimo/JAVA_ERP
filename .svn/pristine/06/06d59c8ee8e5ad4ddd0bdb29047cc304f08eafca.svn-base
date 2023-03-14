package com.srn.erp.reclutamiento.op;

import com.srn.erp.reclutamiento.bm.RecluOperacion;
import com.srn.erp.reclutamiento.bm.RecluPermisosOper;

import framework.applicarionServer.bm.Seguridad.PerfilFuncional;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveRecluOperacion extends Operation { 

  public SaveRecluOperacion() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    IDataSet dataset = mapaDatos.getDataSet("TRecluOperacion"); 
    procesarRegistros(dataset); 
  } 

  private void procesarRegistros(IDataSet dataset) throws BaseException { 
    dataset.first(); 
      while (!dataset.EOF()) { 
        RecluOperacion recluoperacion = RecluOperacion.findByOid(dataset.getInteger("oid_operacion"),getSesion());
        recluoperacion.setOID(dataset.getInteger("oid_operacion"));
        recluoperacion.setCodigo(dataset.getString("codigo"));
        recluoperacion.setDescripcion(dataset.getString("descripcion"));
        recluoperacion.setActivo(dataset.getBoolean("activo"));
        
        IDataSet dsPermisos = dataset.getDataSet("TRecluPermisosOper");
        dsPermisos.first();
        while (!dsPermisos.EOF()) {
        	RecluPermisosOper recluPermisosOper = RecluPermisosOper.findByOid(dsPermisos.getInteger("oid_oper_hab"), this.getSesion());
        	recluPermisosOper.setPerfil_funcional(PerfilFuncional.findByOidProxy(dsPermisos.getInteger("oid_perf_func"), this.getSesion()));
        	recluPermisosOper.setOperacion(RecluOperacion.findByOidProxy(dsPermisos.getInteger("oid_operacion"), this.getSesion()));
        	recluPermisosOper.setTipo_oper(dsPermisos.getString("tipo_oper"));
        	recluPermisosOper.setActivo(dsPermisos.getBoolean("activo"));
        	recluoperacion.addPermisoOperacion(recluPermisosOper);
        	dsPermisos.next();
        }
        
        addTransaccion(recluoperacion);
        dataset.next();
    }
  }
  
}
