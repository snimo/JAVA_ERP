package com.srn.erp.ventas.op;

import java.util.Iterator;

import com.srn.erp.impuestos.bm.SujetoImpositivo;
import com.srn.erp.turnos.bm.CategoriaSujetoTurno;
import com.srn.erp.ventas.bm.Sujeto;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerHelpClientes extends Operation {

  public TraerHelpClientes() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {

    IDataSet datasetCliente = getDataSetCliente();
    traerClientes(datasetCliente,mapaDatos);
    writeCliente(datasetCliente);
  }

  private void traerClientes(IDataSet dataSet ,MapDatos mapaDatos) throws BaseException {

    HashTableDatos condiciones = new HashTableDatos();

    if (mapaDatos.containsKey("codigo"))
      condiciones.put("codigo",mapaDatos.getString("codigo"));

    if (mapaDatos.containsKey("razon_social"))
      condiciones.put("razon_social",mapaDatos.getString("razon_social"));

    if (mapaDatos.containsKey("cuit"))
      condiciones.put("cuit",mapaDatos.getString("cuit"));
   
    if (mapaDatos.containsKey("tipo_busc_socios")) 
    	condiciones.put("tipo_busc_socio",mapaDatos.getInteger("tipo_busc_socios"));
    
    if (mapaDatos.containsKey("cliente"))
    	condiciones.put("cliente","");
    if (mapaDatos.containsKey("prospecto"))
    	condiciones.put("prospecto","");    
    if (mapaDatos.containsKey("socio"))
    	condiciones.put("socio","");    	
    if (mapaDatos.containsKey("contacto"))
    	condiciones.put("contacto","");
    if (mapaDatos.containsKey("CATEG_INVITADO"))
    	condiciones.put("CATEG_INVITADO","");    
    
    Integer categTurno = new Integer(-1);
    
    try {
    	categTurno = CategoriaSujetoTurno.getCategSujTurnoInvitado(this.getSesion()).getOIDInteger();
    } catch(Exception e) {}
    
    if (categTurno == null)
    	categTurno = new Integer(-1);
    
    Iterator iterClientes =
        Sujeto.getHelpClientes(condiciones,getSesion()).iterator();
    while (iterClientes.hasNext()) {
      Sujeto sujeto = (Sujeto) iterClientes.next();
      boolean invitado = false;
      if ((sujeto.getCategoriaSujetoTurno()!=null) && (sujeto.getCategoriaSujetoTurno().getOID() == categTurno.intValue()))
    	  invitado = true;
      cargarRegistroCliente(dataSet,
                            sujeto.getOIDInteger(),
                            sujeto.getCodigo(),
                            sujeto.getRazon_social(),
                            sujeto.getSujeto_impositivo(),
                            sujeto.isActivo(),
                            new Boolean(invitado));
    }

  }

  private IDataSet getDataSetCliente() {
    IDataSet dataset = new TDataSet();
    dataset.create("TClientes");
    dataset.fieldDef(new Field("oid_sujeto", Field.INTEGER, 0));
    dataset.fieldDef(new Field("codigo", Field.STRING, 15));
    dataset.fieldDef(new Field("razon_social_cliente", Field.STRING, 50));
    dataset.fieldDef(new Field("cuit_cliente", Field.STRING, 30));
    dataset.fieldDef(new Field("activo", Field.BOOLEAN,0));
    dataset.fieldDef(new Field("invitado", Field.BOOLEAN,0));
    return dataset;
  }

  private void cargarRegistroCliente(IDataSet dataset,
                                       Integer oid,
                                       String codigo,
                                       String descripcion,
                                       SujetoImpositivo sujetoImpositivo,
                                       Boolean activo,
                                       Boolean invitado) throws BaseException  {
    dataset.append();
    dataset.fieldValue("oid_sujeto", oid);
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("razon_social_cliente", descripcion);
    if (sujetoImpositivo!=null)
      dataset.fieldValue("cuit_cliente",sujetoImpositivo.getCuit());
    else
      dataset.fieldValue("cuit_cliente","");
    dataset.fieldValue("activo", activo);
    dataset.fieldValue("invitado", invitado);
  }

}
