package com.srn.erp.stock.op;

import com.srn.erp.stock.bm.Producto;
import com.srn.erp.stock.bm.UnidadMedida;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerUMStockProducto extends Operation {

  Producto producto = null;	
  IDataSet datasetUnidadMedida  = null;
  UnidadMedida unidadMedida = null;
	
  public TraerUMStockProducto() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
	
	tomarParametros(mapaDatos);
	datasetUnidadMedida = getDataSetUnidadMedida();  
	enviarUMStock();
	writeCliente(datasetUnidadMedida);
  }
  
  private void tomarParametros(MapDatos mapaDatos) throws BaseException {
    Integer oidProducto = mapaDatos.getInteger("oid_producto");
    producto = Producto.findByOid(oidProducto,getSesion());
  }
  
  private void enviarUMStock() throws BaseException {
	  if (producto.getUm_stk()==null)
		  throw new ExceptionValidation(null,"El producto no tiene asignada la unidad de stock principal");
	  cargarRegistroUnidadMedida(datasetUnidadMedida,
			  					 producto.getUm_stk().getOIDInteger(),
			  					 producto.getUm_stk().getCodigo(),
			  				  	 producto.getUm_stk().getDescripcion(),
			  					 new Boolean(true));
  }

  private IDataSet getDataSetUnidadMedida() {
    IDataSet dataset = new TDataSet();
    dataset.create("TUnidadMedidaStock");
    dataset.fieldDef(new Field("oid_um", Field.INTEGER, 0));
    dataset.fieldDef(new Field("codigo", Field.STRING, 10));
    dataset.fieldDef(new Field("descripcion", Field.STRING, 30));
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
    return dataset;
  }

  private void cargarRegistroUnidadMedida(IDataSet dataset,
                         Integer oid_um,
                         String codigo,
                         String descripcion,
                         Boolean activo) {
    dataset.append();
    dataset.fieldValue("oid_um", oid_um);
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("descripcion", descripcion);
    dataset.fieldValue("activo", activo);
  }
}
