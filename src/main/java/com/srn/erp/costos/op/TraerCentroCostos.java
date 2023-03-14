package com.srn.erp.costos.op;

import java.util.Iterator;

import com.srn.erp.costos.bm.CentroCostos;
import com.srn.erp.general.bm.ClasificadorEntidad;
import com.srn.erp.general.bm.ValorClasificadorEntidad;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerCentroCostos extends Operation { 

  public TraerCentroCostos() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
	  
	if (mapaDatos.containsKey("inicializarClasificadores")) {
	  inicializarClasif(mapaDatos);
	  return;
	}
	  
    CentroCostos centrocostos = null;
    if (mapaDatos.containsKey("oid")) { 
       Integer oid = mapaDatos.getInteger("oid"); 
       centrocostos = CentroCostos.findByOid(oid, getSesion()); 
    } 
    else { 
       String codigo = mapaDatos.getString("codigo"); 
       centrocostos = CentroCostos.findByCodigo(codigo, getSesion()); 
    } 

    IDataSet datasetCentroCostos = getDataSetCentroCostos();
    IDataSet datasetValoresClasif = getDataSetValClasif();
    
    if (centrocostos != null) { 
        cargarRegistroCentroCostos(datasetCentroCostos, 
                         centrocostos.getOIDInteger(),
                         centrocostos.getCodigo(),
                         centrocostos.getDescripcion(),
                         centrocostos.isActivo());
        
        traerValoresDatosClasif(datasetValoresClasif,centrocostos);
        
    }
    
    writeCliente(datasetCentroCostos);
    writeCliente(datasetValoresClasif);
  }

  private IDataSet getDataSetCentroCostos() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TCentroCostos");
    dataset.fieldDef(new Field("oid_centro", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("codigo", Field.STRING, 50)); 
    dataset.fieldDef(new Field("descripcion", Field.STRING, 100)); 
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0)); 
    return dataset;
  }

  private void cargarRegistroCentroCostos(IDataSet dataset, 
                         Integer oid_centro,
                         String codigo,
                         String descripcion,
                         Boolean activo) {
    dataset.append(); 
    dataset.fieldValue("oid_centro", oid_centro);
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("descripcion", descripcion);
    dataset.fieldValue("activo", activo);
  }
  
  private IDataSet getDataSetValClasif() {
	    IDataSet dataset = new TDataSet();
	    dataset.create("TValoresClasificadores");
	    dataset.fieldDef(new Field("oid_valor_clasif", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("oid_centro", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("oid_clasif_ent", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("oid_val_clasif_ent", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("nro_clasif", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("desc_grupo_clasif", Field.STRING, 100));
	    dataset.fieldDef(new Field("cod_valor", Field.STRING, 30));
	    dataset.fieldDef(new Field("desc_valor", Field.STRING, 100));
	    dataset.fieldDef(new Field("nickname", Field.STRING, 100));
	    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
	    dataset.fieldDef(new Field("desc_clasificador", Field.STRING, 100));

	    return dataset;
  }

	  private void cargarDSValClasif(IDataSet dataset,
	                                 Integer oidValorClasif,
	                                 Integer oidCentroCostos,
	                                 Integer oidClasifEnt,
	                                 Integer oidValClasifEnt,
	                                 Integer nroClasif,
	                                 String descGrupoClasif,
	                                 String codValor,
	                                 String descValor,
	                                 String nickname,
	                                 Boolean activo,
	                                 String descClasificador) throws BaseException {
	    dataset.append();
	    dataset.fieldValue("oid_valor_clasif", oidValorClasif);
	    dataset.fieldValue("oid_centro", oidCentroCostos);
	    dataset.fieldValue("oid_clasif_ent", oidClasifEnt);
	    dataset.fieldValue("oid_val_clasif_ent", oidValClasifEnt);
	    dataset.fieldValue("nro_clasif", nroClasif);
	    dataset.fieldValue("desc_grupo_clasif", descGrupoClasif);
	    dataset.fieldValue("cod_valor", codValor);
	    dataset.fieldValue("desc_valor", descValor);
	    dataset.fieldValue("nickname", nickname);
	    dataset.fieldValue("activo", activo);
	    dataset.fieldValue("desc_clasificador", descClasificador);
	  }

	  private void traerValoresDatosClasif(IDataSet ds,CentroCostos aCentroCostos) throws BaseException {
	    int oid = 0;
	    Iterator iterClasifEnt = aCentroCostos.getClasifEntidadesActivas().iterator();
	    while (iterClasifEnt.hasNext()) {
	      ClasificadorEntidad clasifEnt =
	          (ClasificadorEntidad) iterClasifEnt.next();
	      ValorClasificadorEntidad valClasifEntidad =
	          aCentroCostos.getValorClasifEnt(clasifEnt);
	      if (valClasifEntidad!=null)
	        cargarDSValClasif(ds,new Integer(++oid),aCentroCostos.getOIDInteger(),
	                       clasifEnt.getOIDInteger(),valClasifEntidad.getOIDInteger(),
	                       clasifEnt.getNroClasif(),clasifEnt.getGrupo().getDescripcion(),
	                       valClasifEntidad.getCodigo(),valClasifEntidad.getDescripcion(),
	                       clasifEnt.getNickname(),
	                       new Boolean(true),
	                       clasifEnt.getDescripcion());
	     else
	       cargarDSValClasif(ds,new Integer(++oid),aCentroCostos.getOIDInteger(),
	                      clasifEnt.getOIDInteger(),new Integer(-1),
	                      clasifEnt.getNroClasif(),clasifEnt.getGrupo().getDescripcion(),
	                      "","",
	                      clasifEnt.getNickname(),
	                      new Boolean(true),
	                      clasifEnt.getDescripcion());
	    }

	  }

	  private IDataSet getDataSetClasificadorEntidad() {
	    IDataSet dataset = new TDataSet();
	    dataset.create("TClasificadorEntidad");
	    dataset.fieldDef(new Field("oid_clasif_ent", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("codigo", Field.STRING, 20));
	    dataset.fieldDef(new Field("descripcion", Field.STRING, 50));
	    dataset.fieldDef(new Field("nickname", Field.STRING, 30));
	    dataset.fieldDef(new Field("obligatorio", Field.BOOLEAN, 0));
	    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
	    dataset.fieldDef(new Field("nro_clasif", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("oid_grupo_clasif", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("cod_grupo_clasif", Field.STRING, 50));
	    dataset.fieldDef(new Field("desc_grupo_clasif", Field.STRING, 100));
	    return dataset;
	  }
	  
	  private void inicializarClasif(MapDatos mapaDatos) throws BaseException {
		    IDataSet dsClasifEnt = getDataSetClasificadorEntidad();
		    Iterator iterClasifEnt = CentroCostos.getClasificadoresEntidadActivos(getSesion()).iterator();
		    while (iterClasifEnt.hasNext()) {
		      ClasificadorEntidad clasifEnt = (ClasificadorEntidad) iterClasifEnt.next();
		      cargarRegistroClasificadorEntidad(dsClasifEnt,clasifEnt);
		    }
		    writeCliente(dsClasifEnt);
	  }
	  
	  private void cargarRegistroClasificadorEntidad(IDataSet dataset,
              ClasificadorEntidad clasifEnt) throws BaseException {
		  dataset.append();
		  dataset.fieldValue("oid_clasif_ent", clasifEnt.getOIDInteger());
		  dataset.fieldValue("codigo", clasifEnt.getCodigo());
		  dataset.fieldValue("descripcion", clasifEnt.getDescripcion());
		  dataset.fieldValue("nickname", clasifEnt.getNickname());
		  dataset.fieldValue("obligatorio", clasifEnt.isObligatorio());
		  dataset.fieldValue("activo", clasifEnt.isActivo());
		  dataset.fieldValue("nro_clasif", clasifEnt.getNroClasif());
		  dataset.fieldValue("oid_grupo_clasif", clasifEnt.getGrupo().getOIDInteger());
		  dataset.fieldValue("cod_grupo_clasif", clasifEnt.getGrupo().getCodigo());
		  dataset.fieldValue("desc_grupo_clasif", clasifEnt.getGrupo().getDescripcion());

	  }
	  

	  
  
  
}
