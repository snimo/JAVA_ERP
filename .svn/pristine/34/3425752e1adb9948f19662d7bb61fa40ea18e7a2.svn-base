package com.srn.erp.compras.op;

import com.srn.erp.compras.bm.SectorCompra;
import com.srn.erp.compras.bm.UsuarioHabilitadoRequisicion;
import com.srn.erp.general.bm.Sucursal;

import framework.applicarionServer.bm.Seguridad.Usuario;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveSectorCompra extends Operation { 

  public SaveSectorCompra() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    IDataSet dataset = mapaDatos.getDataSet("TSectorCompra"); 
    procesarRegistros(dataset); 
  } 

  private void procesarRegistros(IDataSet dataset) throws BaseException { 
    dataset.first(); 
      while (!dataset.EOF()) { 
        SectorCompra sectorcompra = SectorCompra.findByOid(dataset.getInteger("oid_sector_compra"),getSesion());
        sectorcompra.setOID(dataset.getInteger("oid_sector_compra"));
        sectorcompra.setCodigo(dataset.getString("codigo"));
        sectorcompra.setDescripcion(dataset.getString("descripcion"));
        sectorcompra.setActivo(dataset.getBoolean("activo"));
        sectorcompra.setSucursal(Sucursal.findByOidProxy(dataset.getInteger("oid_sucursal"),getSesion()));
        
        IDataSet dsUsuHabReq = dataset.getDataSet("TUsuarioHabilitadoRequisicion");
        dsUsuHabReq.first();
        while (!dsUsuHabReq.EOF()) {
        	UsuarioHabilitadoRequisicion usuHabReq = 
        		UsuarioHabilitadoRequisicion.findByOid(dsUsuHabReq.getInteger("oid_usu_hab_req"),getSesion());
        	usuHabReq.setSector_compra(sectorcompra);
        	usuHabReq.setUsuario(Usuario.findByOidProxy(dsUsuHabReq.getInteger("oid_usuario"),getSesion()));
        	if (!dsUsuHabReq.getBoolean("activo").booleanValue())
        		usuHabReq.delete();
        	sectorcompra.addUsuarioHabilitadoRequisicion(usuHabReq);
        	dsUsuHabReq.next();
        }
        addTransaccion(sectorcompra);
        dataset.next();
    }
  }
  
}
