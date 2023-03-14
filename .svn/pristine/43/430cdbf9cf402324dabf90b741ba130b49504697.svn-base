package com.srn.erp.ventas.op;

import com.srn.erp.ventas.bm.Sujeto;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerValCliente extends Operation {

  public TraerValCliente() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {

    IDataSet datasetCliente = getDataSetCliente();
    traerClientes(datasetCliente,mapaDatos);
    writeCliente(datasetCliente);
  }

  private void traerClientes(IDataSet dataSet ,MapDatos mapaDatos) throws BaseException {

	boolean encontro = false;  
    HashTableDatos condiciones = new HashTableDatos();
    String codigo = mapaDatos.getString("codigo");
    
    Sujeto sujeto = Sujeto.getSujetoByCodigo(codigo,getSesion());
    if (sujeto == null)
    	throw new ExceptionValidation(null,"Código de Sujeto inexistente");
    
    if (mapaDatos.containsKey("es_prospecto"))
    	if (sujeto.isEs_prospecto().booleanValue())
    		encontro = true;
    
    if (mapaDatos.containsKey("es_cliente"))
    	if (sujeto.isEs_cliente().booleanValue())
    		encontro = true;    
    
    if (mapaDatos.containsKey("es_contacto"))
    	if (sujeto.isEs_contacto().booleanValue())
    		encontro = true;
    
    if (mapaDatos.containsKey("es_socio"))
    	if (sujeto.isEs_socio().booleanValue())
    		encontro = true;   
    
    if (encontro == false)
    	throw new ExceptionValidation(null,"Código de Sujeto inexistente");
    
      cargarRegistroCliente(dataSet,
                            sujeto.getOIDInteger(),
                            sujeto.getCodigo(),
                            sujeto.getRazon_social(),
                            sujeto.isEs_socio(),
                            sujeto.isEs_cliente(),
                            sujeto.isEs_prospecto(),
                            sujeto.isEs_prospecto(),
                            sujeto.isActivo());

  }

  private IDataSet getDataSetCliente() {
    IDataSet dataset = new TDataSet();
    dataset.create("TValClientes");
    dataset.fieldDef(new Field("oid", Field.INTEGER, 0));
    dataset.fieldDef(new Field("codigo", Field.STRING, 50));
    dataset.fieldDef(new Field("razon_social", Field.STRING, 100));
    dataset.fieldDef(new Field("es_socio", Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("es_cliente", Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("es_prospecto", Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("es_contacto", Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
    return dataset;
  }

  private void cargarRegistroCliente(IDataSet dataset,
                                       Integer oid,
                                       String codigo,
                                       String descripcion,
                                       Boolean esSocio,
                                       Boolean esCliente,
                                       Boolean esProspecto,
                                       Boolean esContacto,
                                       Boolean activo) throws BaseException  {
    dataset.append();
    dataset.fieldValue("oid", oid);
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("razon_social", descripcion);
    dataset.fieldValue("es_socio", esSocio);
    dataset.fieldValue("es_cliente", esCliente);
    dataset.fieldValue("es_prospecto", esProspecto);
    dataset.fieldValue("es_contacto", esContacto);
    dataset.fieldValue("activo", activo);        
  }

}
