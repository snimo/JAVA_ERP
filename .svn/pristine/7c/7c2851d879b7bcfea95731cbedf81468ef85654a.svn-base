package com.srn.erp.turnos.op;

import com.srn.erp.turnos.bm.*;
import framework.request.bl.Operaciones.*;
import framework.request.bl.Tablas.*;
import framework.request.bl.Utils.*;
import framework.request.bl.XML.*;

public class TraerTableroTurnos extends Operation { 

  public TraerTableroTurnos() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    ParteTablero partetablero = null;
    if (mapaDatos.containsKey("oid")) { 
       Integer oid = mapaDatos.getInteger("oid"); 
       partetablero = ParteTablero.findByOid(oid, getSesion()); 
    } 
    else { 
       String codigo = mapaDatos.getString("codigo"); 
       partetablero = ParteTablero.findByCodigo(codigo, getSesion()); 
    } 

    IDataSet datasetParteTablero = getDataSetParteTablero();
    if (partetablero != null) { 
        cargarRegistroParteTablero(datasetParteTablero, 
                         partetablero.getOIDInteger(),
                         partetablero.getDescripcion(),
                         partetablero.isLunes(),
                         partetablero.isMartes(),
                         partetablero.isMiercoles(),
                         partetablero.isJueves(),
                         partetablero.isViernes(),
                         partetablero.isSabado(),
                         partetablero.isDomingo(),
                         partetablero.isActivo());
    }
    writeCliente(datasetParteTablero);
  }

  private IDataSet getDataSetParteTablero() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TParteTablero");
    dataset.fieldDef(new Field("oid_parte_tablero", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("descripcion", Field.STRING, 100)); 
    dataset.fieldDef(new Field("lunes", Field.BOOLEAN, 0)); 
    dataset.fieldDef(new Field("martes", Field.BOOLEAN, 0)); 
    dataset.fieldDef(new Field("miercoles", Field.BOOLEAN, 0)); 
    dataset.fieldDef(new Field("jueves", Field.BOOLEAN, 0)); 
    dataset.fieldDef(new Field("viernes", Field.BOOLEAN, 0)); 
    dataset.fieldDef(new Field("sabado", Field.BOOLEAN, 0)); 
    dataset.fieldDef(new Field("domingo", Field.BOOLEAN, 0)); 
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0)); 
    return dataset;
  }

  private void cargarRegistroParteTablero(IDataSet dataset, 
                         Integer oid_parte_tablero,
                         String descripcion,
                         Boolean lunes,
                         Boolean martes,
                         Boolean miercoles,
                         Boolean jueves,
                         Boolean viernes,
                         Boolean sabado,
                         Boolean domingo,
                         Boolean activo) {
    dataset.append(); 
    dataset.fieldValue("oid_parte_tablero", oid_parte_tablero);
    dataset.fieldValue("descripcion", descripcion);
    dataset.fieldValue("lunes", lunes);
    dataset.fieldValue("martes", martes);
    dataset.fieldValue("miercoles", miercoles);
    dataset.fieldValue("jueves", jueves);
    dataset.fieldValue("viernes", viernes);
    dataset.fieldValue("sabado", sabado);
    dataset.fieldValue("domingo", domingo);
    dataset.fieldValue("activo", activo);
  }
}
