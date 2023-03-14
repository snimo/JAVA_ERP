package com.srn.erp.contabilidad.op;

import java.util.Iterator;

import com.srn.erp.contabilidad.bm.CompoAtributo;
import com.srn.erp.contabilidad.bm.Componente;
import com.srn.erp.general.bm.ClasificadorEntidad;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerComponente extends Operation {

  public TraerComponente() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {

    Componente componente = null;
    if (mapaDatos.containsKey("oid")) {
       Integer oid = mapaDatos.getInteger("oid");
       componente = Componente.findByOid(oid, getSesion());
    }
    else {
       String codigo = mapaDatos.getString("codigo");
       componente = Componente.findByCodigo(codigo, getSesion());
    }

    IDataSet datasetComponente = getDataSetComponente();
    IDataSet datasetCompoAtributos = getDataSetCompoAtributo();
    IDataSet datasetClasif = getDataSetClasif(); 

    if (componente != null) {
    	
        cargarRegistroComponente(datasetComponente,
                         componente.getOIDInteger(),
                         componente.getCodigo(),
                         componente.getDescripcion(),
                         componente.getTipo(),
                         componente.isActivo(),
                         componente.getNombreNickName(),
                         componente.getNroClasificador(),
                         componente.getLongitud(),
                         componente.getPrecision()
                         );
        
        if (componente.getNombreNickName()!=null) {
        	
        	Iterator iterClasifEnt =
        		ClasificadorEntidad.getClasificadoresEntidadActivos(componente.getNombreNickName(), true, this.getSesion()).iterator();
        	while (iterClasifEnt.hasNext()) {
        		ClasificadorEntidad clasifEnt = (ClasificadorEntidad) iterClasifEnt.next();
        		traerClasif(datasetClasif,clasifEnt);
        	}
        	
        	if ((componente.getNroClasificador()!=null) &&
        	   (componente.getNroClasificador().intValue()>0)) {

            	ClasificadorEntidad clasifEnt =
            		ClasificadorEntidad.getClasificadorEntidad(
            			componente.getNombreNickName(), componente.getNroClasificador(), this.getSesion());
            	
            	if (!clasifEnt.isActivo())
            		traerClasif(datasetClasif, clasifEnt);
        		
        	}

        	
        	
        	
        }
        
        Iterator iterCompoAtri = componente.getCompoAtributos().iterator();
        while (iterCompoAtri.hasNext()) {

          CompoAtributo compoAtributo = (CompoAtributo) iterCompoAtri.next();

          cargarRegistroAtriCompo(datasetCompoAtributos,compoAtributo.getOIDInteger(),
                                  compoAtributo.getCompo().getOIDInteger(),
                                  compoAtributo.getSecu(),
                                  compoAtributo.getAtributo().getOIDInteger(),
                                  compoAtributo.getAtributo().getCodigo(),
                                  compoAtributo.getAtributo().getDescripcion(),
                                  compoAtributo.isActivo());
        }




    }
    
    writeCliente(datasetComponente);
    writeCliente(datasetCompoAtributos);
    writeCliente(datasetClasif);
    
  }

  private IDataSet getDataSetComponente() {
    IDataSet dataset = new TDataSet();
    dataset.create("TComponente");
    dataset.fieldDef(new Field("oid_compo", Field.INTEGER, 0));
    dataset.fieldDef(new Field("codigo", Field.STRING, 6));
    dataset.fieldDef(new Field("descripcion", Field.STRING, 50));
    dataset.fieldDef(new Field("tipo", Field.STRING, 10));
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("nombre_nickname", Field.STRING, 50));
    dataset.fieldDef(new Field("nro_clasificador", Field.INTEGER, 0));
    dataset.fieldDef(new Field("longitud",Field.INTEGER, 0));
    dataset.fieldDef(new Field("precision",Field.INTEGER, 0));
    return dataset;
  }
  
  private IDataSet getDataSetClasif() {
	    IDataSet dataset = new TDataSet();
	    dataset.create("TClasificadoresEntidad");
	    dataset.fieldDef(new Field("oid_clasif_ent", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("codigo", Field.STRING, 50));
	    dataset.fieldDef(new Field("descripcion", Field.STRING, 50));
	    dataset.fieldDef(new Field("nro_clasif", Field.INTEGER, 0));
	    return dataset;
  }
  
  private void traerClasif(
		  IDataSet ds,
		  ClasificadorEntidad clasifEnt) throws BaseException {
	  ds.append();
	  ds.fieldValue("oid_clasif_ent", clasifEnt.getOIDInteger());
	  ds.fieldValue("codigo", clasifEnt.getCodigo());
	  ds.fieldValue("descripcion", clasifEnt.getDescripcion());
	  ds.fieldValue("nro_clasif", clasifEnt.getNroClasif());
  }

  private IDataSet getDataSetCompoAtributo() {
    IDataSet dataset = new TDataSet();
    dataset.create("TAtributos");
    dataset.fieldDef(new Field("oid_compo_atri", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_compo", Field.INTEGER, 0));
    dataset.fieldDef(new Field("secu", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_atributo", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_atributo", Field.STRING, 10));
    dataset.fieldDef(new Field("desc_atributo", Field.STRING, 30));
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
    return dataset;
  }


  private void cargarRegistroComponente(IDataSet dataset,
                         Integer oid_compo,
                         String codigo,
                         String descripcion,
                         String tipo,
                         Boolean activo,
                         String nombreNickname,
                         Integer nroClasificador,
                         Integer longitud,
                         Integer precision) {
    dataset.append();
    dataset.fieldValue("oid_compo", oid_compo);
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("descripcion", descripcion);
    dataset.fieldValue("tipo", tipo);
    dataset.fieldValue("activo", activo);
    if (nombreNickname!=null)
      dataset.fieldValue("nombre_nickname", nombreNickname);
    else
      dataset.fieldValue("nombre_nickname", "");
    if (nroClasificador!=null)
      dataset.fieldValue("nro_clasificador", nroClasificador);
    else
      dataset.fieldValue("nro_clasificador", "");
    if (longitud!=null)
      dataset.fieldValue("longitud", longitud);
    else
      dataset.fieldValue("longitud", 0);
    if (precision!=null)
      dataset.fieldValue("precision", precision);
    else
      dataset.fieldValue("precicion", 0);    
  }

  private void cargarRegistroAtriCompo(IDataSet dataset,
                         Integer oidCompoAtri,
                         Integer oidCompo,
                         Integer secu,
                         Integer oidAtributo,
                         String codAtributo,
                         String descAtributo,
                         Boolean activo) {
    dataset.append();
    dataset.fieldValue("oid_compo_atri", oidCompoAtri);
    dataset.fieldValue("oid_compo",oidCompo);
    dataset.fieldValue("secu",secu);
    dataset.fieldValue("oid_atributo",oidAtributo);
    dataset.fieldValue("cod_atributo",codAtributo);
    dataset.fieldValue("desc_atributo",descAtributo);
    dataset.fieldValue("activo", activo);


  }


}
