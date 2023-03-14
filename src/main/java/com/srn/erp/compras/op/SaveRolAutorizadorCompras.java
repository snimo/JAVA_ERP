package com.srn.erp.compras.op;

import com.srn.erp.compras.bm.RolAutorizadorCompras;
import com.srn.erp.compras.bm.UsuarioRolAutorizadorCompras;

import framework.applicarionServer.bm.Seguridad.Usuario;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveRolAutorizadorCompras extends Operation { 

  public SaveRolAutorizadorCompras() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    IDataSet dataset = mapaDatos.getDataSet("TRolAutorizadorCompras"); 
    procesarRegistros(dataset); 
  } 

  private void procesarRegistros(IDataSet dataset) throws BaseException { 
    dataset.first(); 
      while (!dataset.EOF()) { 
        RolAutorizadorCompras rolautorizadorcompras = RolAutorizadorCompras.findByOid(dataset.getInteger("oid_rol_autoriz"),getSesion());
        rolautorizadorcompras.setOID(dataset.getInteger("oid_rol_autoriz"));
        rolautorizadorcompras.setCodigo(dataset.getString("codigo"));
        rolautorizadorcompras.setDescripcion(dataset.getString("descripcion"));
        rolautorizadorcompras.setActivo(dataset.getBoolean("activo"));
        
        IDataSet dsUsuariosRol = dataset.getDataSet("TUsuarioRolAutorizadorCompras");
        dsUsuariosRol.first();
        while (!dsUsuariosRol.EOF()) {
        	UsuarioRolAutorizadorCompras usuRol = UsuarioRolAutorizadorCompras.findByOid(dsUsuariosRol.getInteger("oid_usu_autoriz"),getSesion());
        	usuRol.setRol_autorizador(rolautorizadorcompras);
        	usuRol.setUsuario(Usuario.findByOid(dsUsuariosRol.getInteger("oid_usuario"),getSesion()));
        	if (!dsUsuariosRol.getBoolean("activo").booleanValue())
        		usuRol.delete();
        	rolautorizadorcompras.addUsuarioRolAutorizador(usuRol);
        	dsUsuariosRol.next();
        }
        addTransaccion(rolautorizadorcompras);
        dataset.next();
    }
  }
  
}
