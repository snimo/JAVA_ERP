package com.srn.erp.conciTarjeta.op;

import com.srn.erp.conciTarjeta.bm.*;
import framework.request.bl.Operaciones.*;
import framework.request.bl.Tablas.*;
import framework.request.bl.Utils.*;
import framework.request.bl.XML.*;

public class TraerTerminalConciTar extends Operation { 

  public TraerTerminalConciTar() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    TerminalConciTar terminalconcitar = null;
    if (mapaDatos.containsKey("oid")) { 
       Integer oid = mapaDatos.getInteger("oid"); 
       terminalconcitar = TerminalConciTar.findByOid(oid, getSesion()); 
    } 
    else { 
       String codigo = mapaDatos.getString("codigo"); 
       terminalconcitar = TerminalConciTar.findByCodigo(codigo, getSesion()); 
    } 

    IDataSet datasetTerminalConciTar = getDataSetTerminalConciTar();
    if (terminalconcitar != null) { 
        cargarRegistroTerminalConciTar(datasetTerminalConciTar, 
                         terminalconcitar.getOIDInteger(),
                         terminalconcitar.getNro_terminal(),
                         terminalconcitar.getDescripcion(),
                         terminalconcitar.getUni_neg(),
                         terminalconcitar.getFolder_in_cielot(),
                         terminalconcitar.isActivo(),
                         terminalconcitar.getFolderLoteProcesado(),
                         terminalconcitar.getFolderLoteError()
                         );
    }
    writeCliente(datasetTerminalConciTar);
  }

  private IDataSet getDataSetTerminalConciTar() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TTerminalConciTar");
    dataset.fieldDef(new Field("oid_terminal", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("nro_terminal", Field.STRING, 20)); 
    dataset.fieldDef(new Field("descripcion", Field.STRING, 100)); 
    dataset.fieldDef(new Field("oid_uni_neg", Field.STRING, 0)); 
    dataset.fieldDef(new Field("Folder_IN_CieLot", Field.STRING, 100)); 
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0)); 
    dataset.fieldDef(new Field("folder_arch_proc", Field.STRING, 100));
    dataset.fieldDef(new Field("folder_lote_error", Field.STRING, 255));
    
    return dataset;
  }

  private void cargarRegistroTerminalConciTar(IDataSet dataset, 
                         Integer oid_terminal,
                         String nro_terminal,
                         String descripcion,
                         UniNegConciTar uniNeg,
                         String Folder_IN_CieLot,
                         Boolean activo,
                         String folderArchProc,
                         String folderLoteError) {
    dataset.append(); 
    dataset.fieldValue("oid_terminal", oid_terminal);
    dataset.fieldValue("nro_terminal", nro_terminal);
    dataset.fieldValue("descripcion", descripcion);
    dataset.fieldValue("oid_uni_neg", uniNeg.getOIDInteger());
    dataset.fieldValue("Folder_IN_CieLot", Folder_IN_CieLot);
    dataset.fieldValue("activo", activo);
    dataset.fieldValue("folder_arch_proc", folderArchProc);
    dataset.fieldValue("folder_lote_error", folderLoteError);
  }
}
