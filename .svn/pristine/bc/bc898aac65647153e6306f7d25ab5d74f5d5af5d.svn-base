package com.srn.erp.compras.op;

import java.util.Iterator;

import com.srn.erp.compras.bm.SectorCompra;
import com.srn.erp.compras.bm.UsuarioHabilitadoRequisicion;
import com.srn.erp.general.bm.Sucursal;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerSectorCompra extends Operation { 

  public TraerSectorCompra() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    SectorCompra sectorcompra = null;
    if (mapaDatos.containsKey("oid")) { 
       Integer oid = mapaDatos.getInteger("oid"); 
       sectorcompra = SectorCompra.findByOid(oid, getSesion()); 
    } 
    else { 
       String codigo = mapaDatos.getString("codigo"); 
       sectorcompra = SectorCompra.findByCodigo(codigo, getSesion()); 
    } 

    IDataSet datasetSectorCompra = getDataSetSectorCompra();
    IDataSet datasetUsuariosHabReq = getDataSetUsuarioHabilitadoRequisicion();
    
    
    if (sectorcompra != null) { 
        cargarRegistroSectorCompra(datasetSectorCompra, 
                         sectorcompra.getOIDInteger(),
                         sectorcompra.getCodigo(),
                         sectorcompra.getDescripcion(),
                         sectorcompra.getSucursal(),
                         sectorcompra.isActivo());
        
        Iterator iterUsuHabReq = sectorcompra.getUsuariosHabReq().iterator();
        while (iterUsuHabReq.hasNext()) {
        	UsuarioHabilitadoRequisicion usuHabReq = (UsuarioHabilitadoRequisicion) iterUsuHabReq.next();
        	cargarRegistroUsuarioHabilitadoRequisicion(datasetUsuariosHabReq,usuHabReq);
        }
        
    }
    writeCliente(datasetSectorCompra);
    writeCliente(datasetUsuariosHabReq);
  }

  private IDataSet getDataSetSectorCompra() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TSectorCompra");
    dataset.fieldDef(new Field("oid_sector_compra", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("codigo", Field.STRING, 30)); 
    dataset.fieldDef(new Field("descripcion", Field.STRING, 50)); 
    dataset.fieldDef(new Field("oid_sucursal", Field.INTEGER, 0));
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0)); 
    return dataset;
  }

  private void cargarRegistroSectorCompra(IDataSet dataset, 
                         Integer oid,
                         String codigo,
                         String descripcion,
                         Sucursal sucursal,
                         Boolean activo) {
    dataset.append(); 
    dataset.fieldValue("oid_sector_compra", oid);
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("descripcion", descripcion);
    dataset.fieldValue("oid_sucursal", sucursal.getOIDInteger());
    dataset.fieldValue("activo", activo);
  }
  
  private IDataSet getDataSetUsuarioHabilitadoRequisicion() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TUsuarioHabilitadoRequisicion");
    dataset.fieldDef(new Field("oid_usu_hab_req", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("oid_sector_compra", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("oid_usuario", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_usuario", Field.STRING, 50));
    dataset.fieldDef(new Field("nombre_usuario", Field.STRING, 100));
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
    return dataset;
  }

  private void cargarRegistroUsuarioHabilitadoRequisicion(IDataSet dataset, 
                         UsuarioHabilitadoRequisicion usuHabReq) throws BaseException {
    dataset.append(); 
    dataset.fieldValue("oid_usu_hab_req", usuHabReq.getOIDInteger());
    dataset.fieldValue("oid_sector_compra", usuHabReq.getSector_compra().getOIDInteger());
    dataset.fieldValue("oid_usuario", usuHabReq.getUsuario().getOIDInteger());
    dataset.fieldValue("cod_usuario", usuHabReq.getUsuario().getLogin());
    dataset.fieldValue("nombre_usuario", usuHabReq.getUsuario().getApellido()+" - "+usuHabReq.getUsuario().getNombre());
    dataset.fieldValue("activo", new Boolean(true));
  }  
  
  
}
