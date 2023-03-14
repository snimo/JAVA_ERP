package com.srn.erp.general.op;

import com.srn.erp.general.bm.Empresa;
import com.srn.erp.general.bm.Sucursal;

import framework.applicarionServer.bl.Servicios.ServicioPoolBD;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class LoginEmpresaSucursal extends Operation {

  private int oid = 0;	
  public LoginEmpresaSucursal() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
	  
	  
    Empresa empresa = null;
    if (mapaDatos.containsKey("oid_empresa"))
    	empresa = Empresa.findByOid(mapaDatos.getInteger("oid_empresa"),getSesion());
    else if (mapaDatos.containsKey("cod_empresa")) 
    	empresa = Empresa.findByCodigo(mapaDatos.getString("cod_empresa"),getSesion());
    
    Sucursal sucursal = null;    
    
    if (mapaDatos.containsKey("oid_sucursal"))
    	sucursal = Sucursal.findByOid(mapaDatos.getInteger("oid_sucursal"),getSesion());
    else if (mapaDatos.containsKey("cod_sucursal"))
    	sucursal = Sucursal.findByCodigo(mapaDatos.getString("cod_sucursal"),getSesion());
    
    	
    if ((empresa.getArchXMLPoolBD()!=null) && (empresa.getArchXMLPoolBD().trim().length()!=0)) {
      getServicios().cargarServicioPoolBD(empresa.getArchXMLPoolBD());
      getSesion().getLogin().setArchXMLPoolBD(empresa.getArchXMLPoolBD());
    }
    else {
      getServicios().cargarServicioPoolBD(ServicioPoolBD.FILE_POOL_BD);
      getSesion().getLogin().setArchXMLPoolBD(ServicioPoolBD.FILE_POOL_BD);
    }
    getSesion().getLogin().setOidEmpresa(empresa.getOIDInteger());
    getSesion().getLogin().setOidSucursal(sucursal.getOIDInteger());
    getSesion().setOidEmpresa(empresa.getOIDInteger());
    getSesion().setOidSucursal(sucursal.getOIDInteger());
    // SE COMENTO EL 23 DE MAYO POR NO SABER PARA QUE ESTA
    //getSesion().regenerarIDSesion();
    
    IDataSet ds = getDataSet();
    cargarEmpresaSistema(ds,new Integer(++oid),getSesion().getSesionID());
    writeCliente(ds);
  }

  private IDataSet getDataSet() {
    IDataSet dataset = new TDataSet();
    dataset.create("TNuevoIDSesion");
    dataset.fieldDef(new Field("oid",Field.INTEGER, 0));
    dataset.fieldDef(new Field("id_sesion", Field.STRING, 500));
    return dataset;
  }
  
  private void cargarEmpresaSistema(IDataSet dataset,
		  							Integer oid,
		  							String idSesion) throws BaseException {
	  dataset.append();
	  dataset.fieldValue("oid",oid);
	  dataset.fieldValue("id_sesion", idSesion);
  }

}
