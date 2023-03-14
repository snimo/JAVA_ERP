 	package com.srn.erp.contabilidad.op;

import com.srn.erp.contabilidad.bm.GrupoAtributoEntidadVar;
import com.srn.erp.contabilidad.bm.GrupoDeAtributos;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class ValidarGrupoAtributoVar extends Operation {

  public ValidarGrupoAtributoVar() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
  	GrupoAtributoEntidadVar grupoAtriEntVar = 
  		GrupoAtributoEntidadVar.findByOid(mapaDatos.getInteger("oid_grupo_atri_var"),getSesion());
  	String codigo = mapaDatos.getString("codigo");
  	
  	IDataSet ds = this.getDataSetGrupoAtriVar();
  	GrupoDeAtributos grupoDeAtri = GrupoDeAtributos.getGrupoDeAtributos(codigo,grupoAtriEntVar,getSesion());
  	
  	if (grupoDeAtri!=null) 
  		cargarRegistro(ds,grupoDeAtri.getOIDInteger(),grupoDeAtri.getCodigo(),grupoDeAtri.getDescripcion(),grupoDeAtri.isActivo());
  	
    writeCliente(ds);
  }

  private IDataSet getDataSetGrupoAtriVar() {
    IDataSet dataset = new TDataSet();
    dataset.create("TValidarGrupoAtributoVar");
    dataset.fieldDef(new Field("oid", Field.INTEGER, 0));
    dataset.fieldDef(new Field("codigo", Field.STRING, 50));
    dataset.fieldDef(new Field("descripcion", Field.STRING, 100));
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
    return dataset;
  }


  private void cargarRegistro(IDataSet dataset,
                         Integer oid,
                         String codigo,
                         String descripcion,
                         Boolean activo) {
    dataset.append();
    dataset.fieldValue("oid", oid);
    dataset.fieldValue("codigo",codigo);
    dataset.fieldValue("descripcion", descripcion);
    dataset.fieldValue("activo", activo);


  }


}
