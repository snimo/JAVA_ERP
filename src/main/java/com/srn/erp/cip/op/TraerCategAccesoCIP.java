package com.srn.erp.cip.op;

import java.util.Iterator;

import com.srn.erp.cip.bm.CategAccesoCIP;
import com.srn.erp.cip.bm.CategAccesoPuertaCIP;
import com.srn.erp.cip.bm.HabilitadorCategAcc;
import com.srn.erp.cip.bm.PlanoCIP;
import com.srn.erp.cip.bm.Puerta;
import com.srn.erp.cip.bm.PuertaPlanoCIP;
import com.srn.erp.cip.bm.SubGrupoCategAcceso;

import framework.applicarionServer.bm.Seguridad.PerfilFuncional;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerCategAccesoCIP extends Operation { 

  public TraerCategAccesoCIP() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    CategAccesoCIP categaccesocip = null;
    if (mapaDatos.containsKey("oid")) { 
       Integer oid = mapaDatos.getInteger("oid"); 
       categaccesocip = CategAccesoCIP.findByOid(oid, getSesion()); 
    } 
    else { 
       String codigo = mapaDatos.getString("codigo"); 
       categaccesocip = CategAccesoCIP.findByCodigo(codigo, getSesion()); 
    } 

    IDataSet datasetCategAccesoCIP  = getDataSetCategAccesoCIP();
    IDataSet datasetPuertasEnPlanos = getDataSetPuertasEnPlanos(); 
    IDataSet datasetHabilitadorCategAcc = getDataSetHabilitadorCategAcc();
    
    
    if (categaccesocip != null) {
    	
        cargarRegistroCategAccesoCIP(
        		         datasetCategAccesoCIP, 
                         categaccesocip.getOIDInteger(),
                         categaccesocip.getCodigo(),
                         categaccesocip.getDescripcion(),
                         categaccesocip.isActivo(),
                         categaccesocip.getSubGrupo()
                         );
        
        int i = 0;
        Iterator iterPerfilFuncional = 
        	PerfilFuncional.getAllActivos(this.getSesion()).iterator();
        while (iterPerfilFuncional.hasNext()) {
        	PerfilFuncional perfilFuncional = (PerfilFuncional) iterPerfilFuncional.next();
        	++i;
        	HabilitadorCategAcc habilitadorCategAcc = 
        		HabilitadorCategAcc.getHabilitadorCategAcc(categaccesocip, perfilFuncional , this.getSesion());
        	boolean habilitado = false;
        	if (habilitadorCategAcc!=null)
        		habilitado = true;
        	cargarHabilitador(datasetHabilitadorCategAcc, i, perfilFuncional, categaccesocip, habilitado);
        }
        
        int secu = 1;
        Iterator iterPlanos = 
        	PlanoCIP.getAllPlanos(this.getSesion()).iterator();
        while (iterPlanos.hasNext()) {
        	PlanoCIP planoCIP = (PlanoCIP) iterPlanos.next();
        	
        	Iterator iterPuertasPlano = 
        		planoCIP.getPuertasPlano().iterator();
        	
        	while (iterPuertasPlano.hasNext()) {
        		PuertaPlanoCIP puertaPlano = (PuertaPlanoCIP) iterPuertasPlano.next();
        		
        		CategAccesoPuertaCIP categAccesoPuerta =
        			CategAccesoPuertaCIP.getCategAccesoPuerta(categaccesocip, puertaPlano.getPuerta(), this.getSesion());
        		++secu;
        		
        		if (categAccesoPuerta != null) {
        			
        			cargarPuertasEnPlanos(datasetPuertasEnPlanos,
        								  categaccesocip,
        					              secu,
        					              planoCIP.getGrupo_plano().getDescripcion(),
        					              planoCIP,
        					              puertaPlano.getOrden(),
        					              puertaPlano.getPuerta(),
        					              categAccesoPuerta.isHab_entrada(),
        					              categAccesoPuerta.isHab_salida());
        					              
        		} else {
        			
        			cargarPuertasEnPlanos(datasetPuertasEnPlanos,
        				      categaccesocip,
				              secu,
				              planoCIP.getGrupo_plano().getDescripcion(),
				              planoCIP,
				              puertaPlano.getOrden(),
				              puertaPlano.getPuerta(),
				              false,
				              false);
        			
        		}
        		
        	}
        }
        
    }
    
    writeCliente(datasetCategAccesoCIP);
    writeCliente(datasetPuertasEnPlanos);
    writeCliente(datasetHabilitadorCategAcc);
    
  }

  private IDataSet getDataSetCategAccesoCIP() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TCategAccesoCIP");
    dataset.fieldDef(new Field("oid_categ_acceso", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("codigo", Field.STRING, 20)); 
    dataset.fieldDef(new Field("descripcion", Field.STRING, 100)); 
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0)); 
    dataset.fieldDef(new Field("oid_sub_grupo_categ", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_sub_grupo_categ", Field.STRING, 50));
    dataset.fieldDef(new Field("desc_sub_grupo_categ", Field.STRING, 100));
    return dataset;
  }
  
  private IDataSet getDataSetPuertasEnPlanos() { 
	    IDataSet dataset = new TDataSet(); 
	    dataset.create("TPuertasEnZonas");
	    dataset.fieldDef(new Field("secu", Field.INTEGER, 0)); 
	    dataset.fieldDef(new Field("agrupador_plano", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("oid_categ_acceso", Field.STRING, 100)); 
	    dataset.fieldDef(new Field("oid_plano", Field.INTEGER, 0)); 
	    dataset.fieldDef(new Field("cod_plano", Field.STRING, 50));
	    dataset.fieldDef(new Field("desc_plano", Field.STRING, 100));
	    dataset.fieldDef(new Field("orden", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("oid_puerta", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("cod_puerta", Field.STRING, 50));
	    dataset.fieldDef(new Field("desc_puerta", Field.STRING, 100));
	    dataset.fieldDef(new Field("hab_entrada", Field.BOOLEAN, 0));
	    dataset.fieldDef(new Field("hab_salida", Field.BOOLEAN, 0));
	    return dataset;
  }
  
  private void cargarHabilitador(IDataSet ds,
		  Integer oidHabCategUsu,
		  PerfilFuncional perfil,
		  CategAccesoCIP categoria,
		  boolean activo) throws BaseException {
	ds.append();
	ds.fieldValue("oid_hab_categ_usu", oidHabCategUsu);
	ds.fieldValue("oid_perfil_func", perfil.getOIDInteger());
	ds.fieldValue("cod_perfil_func", perfil.getCodigo());
	ds.fieldValue("desc_perfil_func", perfil.getDescripcion());
	ds.fieldValue("oid_categ_acceso", categoria.getOIDInteger());
	ds.fieldValue("activo", activo); 
  }
  
  private IDataSet getDataSetHabilitadorCategAcc() { 
	    IDataSet dataset = new TDataSet(); 
	    dataset.create("THabilitadorCategAcc");
	    dataset.fieldDef(new Field("oid_hab_categ_usu", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("oid_perfil_func", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("cod_perfil_func", Field.STRING, 50));
	    dataset.fieldDef(new Field("desc_perfil_func", Field.STRING, 100));
	    dataset.fieldDef(new Field("oid_categ_acceso", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
	    return dataset;
  }
  
  
  private void cargarPuertasEnPlanos(
		  			IDataSet dsCategAcceso,
		  			CategAccesoCIP categAccesoCIP,
		  			Integer secu,
		  			String agrupadorPlano,
		  			PlanoCIP plano,
		  			Integer orden,
		  			Puerta puerta,
		  			boolean habEntrada,
		  			boolean habSalida) throws BaseException {
	  
	  dsCategAcceso.append();
	  dsCategAcceso.fieldValue("secu", secu);
	  dsCategAcceso.fieldValue("agrupador_plano", agrupadorPlano);
	  dsCategAcceso.fieldValue("oid_categ_acceso" , categAccesoCIP.getOID()); 
	  dsCategAcceso.fieldValue("oid_plano", plano.getOIDInteger());
	  dsCategAcceso.fieldValue("cod_plano", plano.getCodigo());
	  dsCategAcceso.fieldValue("desc_plano", plano.getDescripcion());
	  dsCategAcceso.fieldValue("orden", orden);
	  dsCategAcceso.fieldValue("oid_puerta", puerta.getOIDInteger());
	  dsCategAcceso.fieldValue("cod_puerta", puerta.getCodigo());
	  dsCategAcceso.fieldValue("desc_puerta", puerta.getDescripcion());
	  dsCategAcceso.fieldValue("hab_entrada",habEntrada);
	  dsCategAcceso.fieldValue("hab_salida", habSalida);
	  
  }

  private void cargarRegistroCategAccesoCIP(IDataSet dataset, 
                         Integer oid_categ_acceso,
                         String codigo,
                         String descripcion,
                         Boolean activo,
                         SubGrupoCategAcceso subGrupo) throws BaseException {
    dataset.append(); 
    dataset.fieldValue("oid_categ_acceso", oid_categ_acceso);
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("descripcion", descripcion);
    dataset.fieldValue("activo", activo);
    if (subGrupo!=null) {
    	dataset.fieldValue("oid_sub_grupo_categ", subGrupo.getOID());
    	dataset.fieldValue("cod_sub_grupo_categ", subGrupo.getCodigo());
    	dataset.fieldValue("desc_sub_grupo_categ", subGrupo.getDescripcion());
    } else {
    	dataset.fieldValue("oid_sub_grupo_categ", "");
    	dataset.fieldValue("cod_sub_grupo_categ", "");
    	dataset.fieldValue("desc_sub_grupo_categ", "");
    }
    
  }
}
