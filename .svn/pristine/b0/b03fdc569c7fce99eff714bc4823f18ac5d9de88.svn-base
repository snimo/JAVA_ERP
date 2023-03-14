package com.srn.erp.ventas.op;

import java.util.Iterator;

import com.srn.erp.general.bm.ClasificadorEntidad;
import com.srn.erp.general.bm.ValorClasificadorEntidad;
import com.srn.erp.stock.bm.Producto;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerClasificadoresProducto extends Operation {

  String nombreTabla = "";	
	
  public TraerClasificadoresProducto() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
  	
	if (mapaDatos.containsKey("nombreTabla"))
		nombreTabla = mapaDatos.getString("nombreTabla");  
	  
    IDataSet datasetClasificadorEntidad = getDataSetClasificadorEntidad();
    Iterator iterClasifEnt = null;
    
    if (mapaDatos.containsKey("TODOS")) 
        iterClasifEnt = 
        	ClasificadorEntidad.getClasifProdStockYGralActivos(this.getSesion()).iterator();
    else
    	iterClasifEnt = 
    		Producto.getClasificadoresEntidad(this.getSesion()).iterator();
    while (iterClasifEnt.hasNext()) {
    	ClasificadorEntidad clasifEnt = (ClasificadorEntidad) iterClasifEnt.next();
    	if (!clasifEnt.isActivo().booleanValue()) continue;
    	cargarRegistroClasificadorEntidad(datasetClasificadorEntidad,clasifEnt);
    }
    
    
    writeCliente(datasetClasificadorEntidad);

  }

  private IDataSet getDataSetClasificadorEntidad() {
    IDataSet dataset = new TDataSet();
    if ((nombreTabla!=null) && (nombreTabla.length()>0))
    	dataset.create(nombreTabla);
    else
    	dataset.create("TClasificadorEntidad");
    dataset.fieldDef(new Field("oid_clasif_ent", Field.INTEGER, 0));
    dataset.fieldDef(new Field("codigo", Field.STRING, 20));
    dataset.fieldDef(new Field("descripcion", Field.STRING, 50));
    dataset.fieldDef(new Field("nickname", Field.STRING, 30));
    dataset.fieldDef(new Field("obligatorio", Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("oid_val_default", Field.INTEGER, 0));
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("nro_clasif", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_valor_default", Field.STRING, 30));
    dataset.fieldDef(new Field("desc_valor_default", Field.STRING, 50));
    dataset.fieldDef(new Field("oid_grupo_clasif", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_grupo_clasif", Field.STRING, 50));
    dataset.fieldDef(new Field("desc_grupo_clasif", Field.STRING, 100));
    return dataset;
  }


  private void cargarRegistroClasificadorEntidad(IDataSet dataset,
                                                 ClasificadorEntidad clasifEntidad) throws BaseException {
    dataset.append();
    dataset.fieldValue("oid_clasif_ent", clasifEntidad.getOIDInteger());
    dataset.fieldValue("codigo", clasifEntidad.getCodigo());
    dataset.fieldValue("descripcion", clasifEntidad.getDescripcion());
    dataset.fieldValue("nickname", clasifEntidad.getNickname());
    dataset.fieldValue("obligatorio", clasifEntidad.isObligatorio());
    if (clasifEntidad.getValor_default()!=null)
    	dataset.fieldValue("oid_val_default", clasifEntidad.getValor_default());
    else
    	dataset.fieldValue("oid_val_default", new Integer(0));
    dataset.fieldValue("activo", clasifEntidad.isActivo());
    dataset.fieldValue("nro_clasif", clasifEntidad.getNroClasif());
    
    ValorClasificadorEntidad valClasifEnt = null;
    valClasifEnt = ValorClasificadorEntidad.findByOidProxy(clasifEntidad.getValor_default(),this.getSesion());
        
    if (valClasifEnt!=null) {
      dataset.fieldValue("cod_valor_default", valClasifEnt.getCodigo());
      dataset.fieldValue("desc_valor_default", valClasifEnt.getDescripcion());
    }
    else {
      dataset.fieldValue("cod_valor_default", "");
      dataset.fieldValue("desc_valor_default", "");
    }
    dataset.fieldValue("oid_grupo_clasif", clasifEntidad.getGrupo().getOIDInteger());
    dataset.fieldValue("cod_grupo_clasif", clasifEntidad.getGrupo().getCodigo());
    dataset.fieldValue("desc_grupo_clasif", clasifEntidad.getGrupo().getDescripcion());


  }



}
