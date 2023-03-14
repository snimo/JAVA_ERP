package com.srn.erp.compras.op;

import java.util.Iterator;

import com.srn.erp.compras.bm.OtrasDireccionesProveedor;
import com.srn.erp.compras.bm.Proveedor;
import com.srn.erp.general.bm.Pais;
import com.srn.erp.general.bm.Provincia;
import com.srn.erp.ventas.bm.UnidadEdilicia;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerDomDevMercProveedor extends Operation {

  public TraerDomDevMercProveedor() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    Proveedor proveedor = null;
    String tableName = mapaDatos.getString("tableName");
    IDataSet datasetDomEntrega = getDataSetDomEntrega(tableName);
    if (mapaDatos.containsKey("oid")==true) {
      Integer oid = mapaDatos.getInteger("oid");
      if (oid.intValue() == 0)
        throw new ExceptionValidation(null, "Debe seleccionar un Proveedor");
      proveedor = Proveedor.findByOidProxy(oid, getSesion());
      traerDomEnt(proveedor, datasetDomEntrega);
    }
    else {
      Integer oidDomEnt = mapaDatos.getInteger("oid_direccion");
      OtrasDireccionesProveedor unidadEdilicia = OtrasDireccionesProveedor.findByOid(oidDomEnt,getSesion());
      cargarRegistroDomEntrega(datasetDomEntrega,
                               unidadEdilicia.getOIDInteger(),
                               unidadEdilicia.getCodigo(),
                               unidadEdilicia.getDescripcion(),
                               unidadEdilicia.getCalle_y_nro(),
                               unidadEdilicia.getLocalidad(),
                               unidadEdilicia.getCodigo_postal(),
                               unidadEdilicia.getProvincia(),
                               unidadEdilicia.getPais(),
                               unidadEdilicia.isActivo());
    }
    writeCliente(datasetDomEntrega);
  }

  private void traerDomEnt(Proveedor proveedor,IDataSet ds) throws BaseException {
	  
/*	if (proveedor.isDomicilioDevolucionMerc()) {
	      cargarRegistroDomEntrega(ds,
	    		  new Integer(-1),
	    		  proveedor.getCodigo(),
	    		  proveedor.getDireccionCompleta(),
	    		  proveedor.getDireccion(),
	    		  proveedor.getLocalidad(),
	    		  proveedor.getCodigopostal(),
	    		  proveedor.getProvincia(),
	    		  proveedor.getPais(),
	    		  proveedor.isActivo());
	}*/
	  
    Iterator iterDomEnt =
        proveedor.getOtrasDirecciones().iterator();
    while (iterDomEnt.hasNext()) {
      OtrasDireccionesProveedor otrasDirecciones = (OtrasDireccionesProveedor) iterDomEnt.next();
      if (!otrasDirecciones.isDom_dev_mercaderia().booleanValue()) continue;
      cargarRegistroDomEntrega(ds,
    		  otrasDirecciones.getOIDInteger(),
    		  otrasDirecciones.getCodigo(),
    		  otrasDirecciones.getDescripcion(),
    		  otrasDirecciones.getCalle_y_nro(),
    		  otrasDirecciones.getLocalidad(),
    		  otrasDirecciones.getCodigo_postal(),
    		  otrasDirecciones.getProvincia(),
    		  otrasDirecciones.getPais(),
    		  otrasDirecciones.isActivo());
    }
  }

  private IDataSet getDataSetDomEntrega(String tableName) {
    IDataSet dataset = new TDataSet();
    dataset.create(tableName);
    dataset.fieldDef(new Field("oid_uni_edi", Field.INTEGER, 0));
    dataset.fieldDef(new Field("codigo", Field.STRING, 20));
    dataset.fieldDef(new Field("descripcion", Field.STRING, 20));
    dataset.fieldDef(new Field("calle_y_nro", Field.STRING, 20));
    dataset.fieldDef(new Field("localidad", Field.STRING, 20));
    dataset.fieldDef(new Field("codigo_postal", Field.STRING, 20));
    dataset.fieldDef(new Field("provincia", Field.STRING, 50));
    dataset.fieldDef(new Field("pais", Field.STRING, 50));
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("oid_provincia", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_pais", Field.INTEGER, 0));
    return dataset;
  }

  private void cargarRegistroDomEntrega(IDataSet dataset,
                         Integer oid_uni_edi,
                         String codigo,
                         String descripcion,
                         String calle_y_nro,
                         String localidad,
                         String codigoPostal,
                         Provincia provincia,
                         Pais pais,
                         Boolean activo) throws BaseException {
    dataset.append();
    dataset.fieldValue("oid_uni_edi", oid_uni_edi);
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("descripcion", descripcion);
    dataset.fieldValue("calle_y_nro", calle_y_nro);
    dataset.fieldValue("localidad", localidad);
    if (codigoPostal!=null)
      dataset.fieldValue("codigo_postal", codigoPostal);
    else
      dataset.fieldValue("codigo_postal", "");
    if (provincia!=null)
      dataset.fieldValue("provincia", provincia.getDescripcion());
    else
      dataset.fieldValue("provincia", "");
    if (pais!=null)
      dataset.fieldValue("pais", pais.getDescripcion());
    else
      dataset.fieldValue("pais", "");
    dataset.fieldValue("activo", activo);
    if (provincia!=null)
      dataset.fieldValue("oid_provincia", provincia.getOIDInteger());
    else
      dataset.fieldValue("oid_provincia", 0);
    if (pais!=null)
      dataset.fieldValue("oid_pais", pais.getOIDInteger());
    else
      dataset.fieldValue("oid_pais", 0);
  }
}
