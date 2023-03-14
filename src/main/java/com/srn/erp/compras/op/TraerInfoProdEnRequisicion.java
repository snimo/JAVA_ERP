package com.srn.erp.compras.op;

import com.srn.erp.compras.bm.RequisicionCab;
import com.srn.erp.stock.bm.Producto;
import com.srn.erp.stock.bm.UnidadMedida;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerInfoProdEnRequisicion extends Operation { 

  public TraerInfoProdEnRequisicion() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
	IDataSet dsInfoProdEnRequi = getDataSetInfoProdEnRequi();
	Integer oidProducto = mapaDatos.getInteger("oid_producto");
	Producto producto = Producto.findByOid(oidProducto,getSesion());
	cargarRegistroInfoProdEnRequi(dsInfoProdEnRequi,new Integer(1),RequisicionCab.getUniMedSug(producto));
    writeCliente(dsInfoProdEnRequi);
  }

  private IDataSet getDataSetInfoProdEnRequi() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TInfoProdEnRequi");
    dataset.fieldDef(new Field("secu", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_um_requi", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_um_requi", Field.STRING, 50));
    return dataset;
  }

  private void cargarRegistroInfoProdEnRequi(IDataSet dataset, 
                         Integer secu,
                         UnidadMedida uniMedRequi) throws BaseException {
    dataset.append();
    dataset.fieldValue("secu", secu);
    dataset.fieldValueOID("oid_um_requi", uniMedRequi);
    dataset.fieldValueCodigo("cod_um_requi", uniMedRequi);
    
  }
}
