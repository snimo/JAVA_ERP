package com.srn.erp.presupuesto.op;

import java.util.Iterator;

import com.srn.erp.presupuesto.bm.GrupoTipoUPC;
import com.srn.erp.presupuesto.bm.GrupoTipoUPCDet;
import com.srn.erp.presupuesto.bm.TipoUPC;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerGrupoTipoUPC extends Operation { 

	int oidNegativoAlta = 0;
	
  public TraerGrupoTipoUPC() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    

    IDataSet datasetGrupoTipoUPC = getDataSetGrupoTipoUPC();
    IDataSet datasetDetalle = this.getDataSetGrupoTipoUPCDet();

    if (mapaDatos.containsKey("es_nuevo_grupo")) 
  			traerDetallesParaGrupoNuevo(datasetDetalle,
  																	mapaDatos.getInteger("oid_grupo"));
    		else if (mapaDatos.containsKey("oid")) 
    						TraerGrupoByOid(datasetGrupoTipoUPC,
    														datasetDetalle,
    														mapaDatos.getInteger("oid"));
    
  }
  
  private void TraerGrupoByOid(IDataSet datasetGrupoTipoUPC, 
  		                         IDataSet datasetDetalle,
  		                         Integer oidGrupo) throws BaseException {
  	GrupoTipoUPC grupotipoupc = null;
    Integer oid = oidGrupo; 
    grupotipoupc = GrupoTipoUPC.findByOid(oid, getSesion());
    cargarRegistroGrupoTipoUPC(datasetGrupoTipoUPC, 
				 grupotipoupc);
    cargarDetalles(datasetDetalle,grupotipoupc);
    writeCliente(datasetGrupoTipoUPC);
    writeCliente(datasetDetalle);
  	
  }
  
  private void traerDetallesParaGrupoNuevo( 
      IDataSet datasetDetalle,
      Integer oidNuevoGrupo) throws BaseException {
		cargarDetallesNuevoGrupo(datasetDetalle,oidNuevoGrupo);
    writeCliente(datasetDetalle);  	
  }
  
  
  
  private void cargarDetalles(IDataSet dsDetalle,GrupoTipoUPC grupoTipoUPC) throws BaseException {
    Iterator iterTiposUPC = TipoUPC.getAllActivos(this.getSesion()).iterator();
    while (iterTiposUPC.hasNext()) {
    	TipoUPC tipoUPC = (TipoUPC) iterTiposUPC.next();
    	GrupoTipoUPCDet grupoTipoUPCDet = getGrupoTipoUPCDet(grupoTipoUPC,tipoUPC);
    	cargarRegistroGrupoTipoUPCDet(dsDetalle,grupoTipoUPCDet);
    }
    
  }
  
  private GrupoTipoUPCDet getGrupoTipoUPCDet(GrupoTipoUPC grupoTipoUPC,TipoUPC tipoUPC) throws BaseException {
  	GrupoTipoUPCDet grupoTipoUPCDet = grupoTipoUPC.getGrupoTipoUPCDet(tipoUPC);
  	if (grupoTipoUPCDet==null) {
  		--oidNegativoAlta;
  		grupoTipoUPCDet = 
  			(GrupoTipoUPCDet)GrupoTipoUPCDet.getNew(GrupoTipoUPCDet.NICKNAME,this.getSesion());
  		grupoTipoUPCDet.setOID(new Integer(oidNegativoAlta));
  		grupoTipoUPCDet.setGrupo_tipo_upc(grupoTipoUPC);
  		grupoTipoUPCDet.setTipo_upc(tipoUPC);
  		grupoTipoUPCDet.setActivo(new Boolean(false));
  	};
  	return grupoTipoUPCDet;
  }
  
  private void cargarDetallesNuevoGrupo(IDataSet dsDetalle,Integer oidNuevoGrupo) throws BaseException {
  	
  	GrupoTipoUPC grupoTipoUPC = (GrupoTipoUPC) GrupoTipoUPC.getNew(GrupoTipoUPC.NICKNAME,this.getSesion());
  	grupoTipoUPC.setOID(oidNuevoGrupo);
  	cargarDetalles(dsDetalle,grupoTipoUPC);
    
  }  

  private IDataSet getDataSetGrupoTipoUPC() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TGrupoTipoUPC");
    dataset.fieldDef(new Field("oid_grupo_tipo_upc", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("codigo", Field.STRING, 50)); 
    dataset.fieldDef(new Field("descripcion", Field.STRING, 100)); 
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0)); 
    return dataset;
  }

  private void cargarRegistroGrupoTipoUPC(IDataSet dataset,
  																				GrupoTipoUPC grupoTipoUPC) throws BaseException {
    dataset.append(); 
    dataset.fieldValue("oid_grupo_tipo_upc", grupoTipoUPC.getOIDInteger());
    dataset.fieldValue("codigo", grupoTipoUPC.getCodigo());
    dataset.fieldValue("descripcion", grupoTipoUPC.getDescripcion());
    dataset.fieldValue("activo", grupoTipoUPC.isActivo());
  }
  
  private IDataSet getDataSetGrupoTipoUPCDet() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TGrupoTipoUPCDet");
    dataset.fieldDef(new Field("oid_grupo_det", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("oid_grupo_tipo_upc", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("oid_tipo_upc", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("cod_tipo_upc", Field.STRING, 50));
    dataset.fieldDef(new Field("desc_tipo_upc", Field.STRING, 100));
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0)); 
    return dataset;
  }

  private void cargarRegistroGrupoTipoUPCDet(IDataSet dataset, 
                         GrupoTipoUPCDet grupoTipoUPCDet) throws BaseException {
    dataset.append(); 
    dataset.fieldValue("oid_grupo_det", grupoTipoUPCDet.getOIDInteger());
    dataset.fieldValue("oid_grupo_tipo_upc", grupoTipoUPCDet.getGrupo_tipo_upc().getOIDInteger());
    dataset.fieldValue("oid_tipo_upc", grupoTipoUPCDet.getTipo_upc().getOIDInteger());
    dataset.fieldValue("cod_tipo_upc", grupoTipoUPCDet.getTipo_upc().getCodigo());
    dataset.fieldValue("desc_tipo_upc", grupoTipoUPCDet.getTipo_upc().getDescripcion());
    dataset.fieldValue("activo", grupoTipoUPCDet.isActivo());
  }  
}
