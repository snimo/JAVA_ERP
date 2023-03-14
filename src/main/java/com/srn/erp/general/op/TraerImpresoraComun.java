package com.srn.erp.general.op;

import java.util.Iterator;

import com.srn.erp.general.bm.ImpresoraComun;
import com.srn.erp.general.bm.UnidadOrganizativa;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerImpresoraComun extends Operation {

  public TraerImpresoraComun() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    ImpresoraComun impresoracomun = null;
    if (mapaDatos.containsKey("oid")) {
       Integer oid = mapaDatos.getInteger("oid");
       impresoracomun = ImpresoraComun.findByOid(oid, getSesion());
       enviarImpresora(impresoracomun);
    }
    else if ((mapaDatos.containsKey("codigo"))) {
       String codigo = mapaDatos.getString("codigo");
       impresoracomun = ImpresoraComun.findByCodigo(codigo, getSesion());
       enviarImpresora(impresoracomun);
    } else {
    	enviarTodasLasImpresoras();
    }

  }
  
  private void enviarTodasLasImpresoras() throws BaseException {
  	IDataSet datasetImpresoraComun = getDataSetImpresoraComun();
  	Iterator iterImpresorasComun = ImpresoraComun.getAllImpresoras(this.getSesion()).iterator();
  	while (iterImpresorasComun.hasNext()) {
  		ImpresoraComun impresoracomun = (ImpresoraComun) iterImpresorasComun.next();
      cargarRegistroImpresoraComun(datasetImpresoraComun,
          impresoracomun.getOIDInteger(),
          impresoracomun.getCodigo(),
          impresoracomun.getDescripcion(),
          impresoracomun.getImpresora_sistema(),
          impresoracomun.isActivo(),
          impresoracomun.getUnidadOrganizativa());

  	}
  	writeCliente(datasetImpresoraComun);
  	
  }
  
  private void enviarImpresora(ImpresoraComun impresoracomun) throws BaseException {
    IDataSet datasetImpresoraComun = getDataSetImpresoraComun();
    if (impresoracomun != null) {
        cargarRegistroImpresoraComun(datasetImpresoraComun,
                         impresoracomun.getOIDInteger(),
                         impresoracomun.getCodigo(),
                         impresoracomun.getDescripcion(),
                         impresoracomun.getImpresora_sistema(),
                         impresoracomun.isActivo(),
                         impresoracomun.getUnidadOrganizativa());
    }
    writeCliente(datasetImpresoraComun);
  }

  private IDataSet getDataSetImpresoraComun() {
    IDataSet dataset = new TDataSet();
    dataset.create("TImpresoraComun");
    dataset.fieldDef(new Field("oid_imp_comun", Field.INTEGER, 0));
    dataset.fieldDef(new Field("codigo", Field.STRING, 30));
    dataset.fieldDef(new Field("descripcion", Field.STRING, 100));
    dataset.fieldDef(new Field("impresora_sistema", Field.STRING, 100));
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("oid_uni_org", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_uni_org", Field.STRING, 50));
    dataset.fieldDef(new Field("desc_uni_org", Field.STRING, 100));
    return dataset;
  }

  private void cargarRegistroImpresoraComun(IDataSet dataset,
                         Integer oid_imp_comun,
                         String codigo,
                         String descripcion,
                         String impresora_sistema,
                         Boolean activo,
                         UnidadOrganizativa uniOrg) throws BaseException {
    dataset.append();
    dataset.fieldValue("oid_imp_comun", oid_imp_comun);
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("descripcion", descripcion);
    dataset.fieldValue("impresora_sistema", impresora_sistema);
    dataset.fieldValue("activo", activo);
    if (uniOrg!=null) {
      dataset.fieldValue("oid_uni_org", uniOrg.getOIDInteger());
      dataset.fieldValue("cod_uni_org", uniOrg.getCodigo());
      dataset.fieldValue("desc_uni_org", uniOrg.getDescripcion());
    } else {
      dataset.fieldValue("oid_uni_org", 0);
      dataset.fieldValue("cod_uni_org", "");
      dataset.fieldValue("desc_uni_org", "");
    }
    
  }
}
