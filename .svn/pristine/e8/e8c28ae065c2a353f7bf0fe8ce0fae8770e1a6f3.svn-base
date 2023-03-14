package com.srn.erp.general.op;

import java.util.Iterator;

import com.srn.erp.general.bm.ClasificadorEntidad;
import com.srn.erp.general.bm.GrupoClasificadorEntidad;
import com.srn.erp.general.bm.ValorClasificadorEntidad;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerClasificadorEntidad extends Operation {

	private String buscarPorCodigo = null;
	private String buscarPorDesc = null;
	private boolean soloActivos = false;
	
  public TraerClasificadorEntidad() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    ClasificadorEntidad clasificadorentidad = null;
    boolean soloTitulos = false;
    
    if (mapaDatos.containsKey("buscar_por_codigo"))
    	buscarPorCodigo = mapaDatos.getString("buscar_por_codigo");

    if (mapaDatos.containsKey("SOLO_ACTIVOS"))
    	soloActivos = true;
    
    if (mapaDatos.containsKey("buscar_por_descripcion"))
    	buscarPorDesc = mapaDatos.getString("buscar_por_descripcion");
    
    
    if (mapaDatos.containsKey("oid")) {
       Integer oid = mapaDatos.getInteger("oid");
       clasificadorentidad = ClasificadorEntidad.findByOid(oid, getSesion());
              
    }
    else if (mapaDatos.containsKey("codigo")) {
             String codigo = mapaDatos.getString("codigo");
             clasificadorentidad = ClasificadorEntidad.findByCodigo(codigo, getSesion());
             }
             else if (mapaDatos.containsKey("nickname")) {
                      String nickname = mapaDatos.getString("nickname");
                      Integer nroClasif = mapaDatos.getInteger("nro_clasificador");
                      clasificadorentidad = ClasificadorEntidad.getClasificadorEntidad(nickname,nroClasif,getSesion());
                     }
    if (mapaDatos.containsKey("solo_titulos")) 
    	soloTitulos = true;

    IDataSet datasetClasificadorEntidad = getDataSetClasificadorEntidad();
    IDataSet dsValorClasif = getDataSetValorClasif();

    if (clasificadorentidad != null) {
        cargarRegistroClasificadorEntidad(datasetClasificadorEntidad,
                         clasificadorentidad.getOIDInteger(),
                         clasificadorentidad.getCodigo(),
                         clasificadorentidad.getDescripcion(),
                         clasificadorentidad.getNickname(),
                         clasificadorentidad.isObligatorio(),
                         clasificadorentidad.getValor_default(),
                         clasificadorentidad.isActivo(),
                         clasificadorentidad.getNroClasif(),
                         clasificadorentidad.getValorDfault(),
                         clasificadorentidad.getGrupo()
                         );

        Iterator iterValoresClasif = null;
        if (soloTitulos)
        	iterValoresClasif = clasificadorentidad.getValoresClasificadorTitulos(buscarPorCodigo,buscarPorDesc,soloActivos).iterator();
        else
            iterValoresClasif = clasificadorentidad.getValoresClasificador(buscarPorCodigo,buscarPorDesc).iterator();
        while (iterValoresClasif.hasNext()) {
          ValorClasificadorEntidad valorClasificadorEntidad =
              (ValorClasificadorEntidad) iterValoresClasif.next();
          cargarValorClasif(dsValorClasif,valorClasificadorEntidad);
        }

    }

    writeCliente(datasetClasificadorEntidad);
    writeCliente(dsValorClasif);

  }

  private IDataSet getDataSetClasificadorEntidad() {
    IDataSet dataset = new TDataSet();
    dataset.create("TClasificadorEntidad");
    dataset.fieldDef(new Field("oid_clasif_ent", Field.INTEGER, 0));
    dataset.fieldDef(new Field("codigo", Field.STRING, 20));
    dataset.fieldDef(new Field("descripcion", Field.STRING, 255));
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

  private IDataSet getDataSetValorClasif() {
    IDataSet dataset = new TDataSet();
    dataset.create("TValorClasificador");
    dataset.fieldDef(new Field("oid_val_clasif_ent", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_clasif_ent", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_item", Field.INTEGER, 0));
    dataset.fieldDef(new Field("codigo", Field.STRING, 30));
    dataset.fieldDef(new Field("descripcion", Field.STRING, 100));
    dataset.fieldDef(new Field("oid_item_padre", Field.INTEGER, 0));
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("orden", Field.INTEGER, 0));
    dataset.fieldDef(new Field("tipo", Field.STRING, 30));
    dataset.fieldDef(new Field("codigo_desde", Field.STRING, 50));
    dataset.fieldDef(new Field("codigo_hasta", Field.STRING, 50));
    return dataset;
  }

  private void cargarValorClasif(IDataSet dataset,
                                 ValorClasificadorEntidad valorClasifEnt) throws BaseException {
    dataset.append();
    dataset.fieldValue("oid_val_clasif_ent", valorClasifEnt.getOIDInteger());
    dataset.fieldValue("oid_clasif_ent", valorClasifEnt.getClasificador_entidad().getOIDInteger());
    dataset.fieldValue("oid_item", valorClasifEnt.getOid_item());
    dataset.fieldValue("codigo", valorClasifEnt.getCodigo());
    dataset.fieldValue("descripcion", valorClasifEnt.getDescripcion());
    dataset.fieldValue("oid_item_padre", valorClasifEnt.getOid_item_padre());
    dataset.fieldValue("activo", valorClasifEnt.isActivo());
    dataset.fieldValue("orden", valorClasifEnt.getOrden());
    dataset.fieldValue("tipo", valorClasifEnt.getTipo());
    dataset.fieldValue("codigo_desde", valorClasifEnt.getCodigoDesde());
    dataset.fieldValue("codigo_hasta", valorClasifEnt.getCodigoHasta());
  }



  private void cargarRegistroClasificadorEntidad(IDataSet dataset,
                                                 Integer oid_clasif_ent,
                                                 String codigo,
                                                 String descripcion,
                                                 String nickname,
                                                 Boolean obligatorio,
                                                 Integer oid_val_default,
                                                 Boolean activo,
                                                 Integer nroClasif,
                                                 ValorClasificadorEntidad valorDefault,
                                                 GrupoClasificadorEntidad grupo) throws BaseException {
    dataset.append();
    dataset.fieldValue("oid_clasif_ent", oid_clasif_ent);
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("descripcion", descripcion);
    dataset.fieldValue("nickname", nickname);
    dataset.fieldValue("obligatorio", obligatorio);
    dataset.fieldValue("oid_val_default", oid_val_default);
    dataset.fieldValue("activo", activo);
    dataset.fieldValue("nro_clasif", nroClasif);
    if (valorDefault!=null) {
      dataset.fieldValue("cod_valor_default", valorDefault.getCodigo());
      dataset.fieldValue("desc_valor_default", valorDefault.getDescripcion());
    }
    else {
      dataset.fieldValue("cod_valor_default", "");
      dataset.fieldValue("desc_valor_default", "");
    }
    dataset.fieldValue("oid_grupo_clasif", grupo.getOIDInteger());
    dataset.fieldValue("cod_grupo_clasif", grupo.getCodigo());
    dataset.fieldValue("desc_grupo_clasif", grupo.getDescripcion());


  }



}
