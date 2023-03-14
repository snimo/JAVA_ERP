package com.srn.erp.ventas.op;

import com.srn.erp.general.bm.ClasificadorEntidad;
import com.srn.erp.ventas.bm.ListaPrecios;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerInicioArmadoEstrucLP extends Operation {

  public TraerInicioArmadoEstrucLP() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
  	
  	ClasificadorEntidad clasifProd1 = ListaPrecios.getClasifNro1EstrucLP(this.getSesion());
  	ClasificadorEntidad clasifProd2 = ListaPrecios.getClasifNro2EstrucLP(this.getSesion());
  	
    IDataSet ds = this.getDataSetClasifArtLP();
    cargarRegistro(ds,clasifProd1,clasifProd2);
    writeCliente(ds);
  }

  private IDataSet getDataSetClasifArtLP() {
  	
    IDataSet dataset = new TDataSet();
    dataset.create("TEstrucLP");
    dataset.fieldDef(new Field("secu", Field.INTEGER, 0));
    
    dataset.fieldDef(new Field("oid_clasif_1", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_clasif_1", Field.STRING, 50));
    dataset.fieldDef(new Field("desc_clasif_1", Field.STRING, 100));
    dataset.fieldDef(new Field("nro_clasif_1", Field.INTEGER, 0));
    
    dataset.fieldDef(new Field("oid_clasif_2", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_clasif_2", Field.STRING, 50));
    dataset.fieldDef(new Field("desc_clasif_2", Field.STRING, 100));
    dataset.fieldDef(new Field("nro_clasif_2", Field.INTEGER, 0));
    
    return dataset;
  }

  private void cargarRegistro(IDataSet dataset,
                              ClasificadorEntidad clasifEnt1,
                              ClasificadorEntidad clasifEnt2) throws BaseException  {
    dataset.append();

    dataset.fieldValue("secu", new Integer(1));
    
    dataset.fieldValue("oid_clasif_1", clasifEnt1.getOIDInteger());
    dataset.fieldValue("cod_clasif_1", clasifEnt1.getCodigo());
    dataset.fieldValue("desc_clasif_1", clasifEnt1.getDescripcion());
    dataset.fieldValue("nro_clasif_1", clasifEnt1.getNroClasif());
    
    dataset.fieldValue("oid_clasif_2", clasifEnt2.getOIDInteger());
    dataset.fieldValue("cod_clasif_2", clasifEnt2.getCodigo());
    dataset.fieldValue("desc_clasif_2", clasifEnt2.getDescripcion());
    dataset.fieldValue("nro_clasif_2", clasifEnt2.getNroClasif());
    
  }
}
