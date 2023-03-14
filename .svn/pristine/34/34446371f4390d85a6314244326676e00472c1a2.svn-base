package com.srn.erp.general.op;

import com.srn.erp.general.bm.ClasificadorEntidad;
import com.srn.erp.general.bm.ValorClasificadorEntidad;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerValorClasifEntidad extends Operation {

  public TraerValorClasifEntidad() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
	boolean soloTitulos = false;
	
	
	if (mapaDatos.containsKey("VALIDAR_CODIGO_UNICO")) {
		validarCodidoUnico(mapaDatos);
		return;
	}
	
    ClasificadorEntidad clasifEnt =
        ClasificadorEntidad.findByOid(mapaDatos.getInteger("oid_clasif_ent"),getSesion());
    String codigo = mapaDatos.getString("codigo");
    
    if (mapaDatos.containsKey("solo_titulos"))
    	soloTitulos = true;
    
    ValorClasificadorEntidad valorClasificadorEntidad = clasifEnt.getValorClasifEnt(codigo);
    if (valorClasificadorEntidad == null)
      throw new ExceptionValidation(null,"Código de Valor de Clasificador inexistente");
    
    if (soloTitulos)
    	if (!valorClasificadorEntidad.isTitulo())
    		throw new ExceptionValidation(null,"Código de Valor de Clasificador inexistente");
    	

    IDataSet ds = getDataSetValorClasifEnt();
    cargarRegistroValorClasifEnt(ds,valorClasificadorEntidad.getOIDInteger(),
                                 valorClasificadorEntidad.getCodigo(),
                                 valorClasificadorEntidad.getDescripcion(),
                                 clasifEnt.getOIDInteger());
    writeCliente(ds);
  }
  
  private void validarCodidoUnico(MapDatos mapaDatos) throws BaseException {

	ClasificadorEntidad clasifEnt =
	        ClasificadorEntidad.findByOid(mapaDatos.getInteger("oid_clasif_ent"),getSesion());
	String codigo = mapaDatos.getString("codigo");
	    
	ValorClasificadorEntidad valorClasificadorEntidad = clasifEnt.getValorClasifEnt(codigo);
	if (valorClasificadorEntidad != null)
	      throw new ExceptionValidation(null,"Código de Valor de Clasificador existente");
	  	  
  }

  private IDataSet getDataSetValorClasifEnt() {
    IDataSet dataset = new TDataSet();
    dataset.create("TValorClaifEntidad");
    dataset.fieldDef(new Field("oid_valor_clasif_ent", Field.INTEGER, 0));
    dataset.fieldDef(new Field("codigo", Field.STRING, 30));
    dataset.fieldDef(new Field("descripcion", Field.STRING, 100));
    dataset.fieldDef(new Field("oid_clasif_entidad", Field.INTEGER, 0));
    return dataset;
  }

  private void cargarRegistroValorClasifEnt(IDataSet dataset,
                         Integer oid_valor_clasif_ent,
                         String codigo,
                         String descripcion,
                         Integer oidClasifEnt) throws BaseException {
    dataset.append();
    dataset.fieldValue("oid_valor_clasif_ent", oid_valor_clasif_ent);
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("descripcion", descripcion);
    dataset.fieldValue("oid_clasif_entidad", oidClasifEnt);
  }

}
