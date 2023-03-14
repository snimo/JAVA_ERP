package com.srn.erp.presupuesto.op;

import com.srn.erp.presupuesto.bm.*;
import framework.request.bl.Operaciones.*;
import framework.request.bl.Utils.*;
import framework.request.bl.XML.IDataSet;

public class SaveRepositorioReal extends Operation { 

  public SaveRepositorioReal() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    IDataSet dataset = mapaDatos.getDataSet("TRepositorioReal"); 
    procesarRegistros(dataset); 
  } 

  private void procesarRegistros(IDataSet dataset) throws BaseException { 
    dataset.first(); 
      while (!dataset.EOF()) { 
        RepositorioReal repositorioreal = RepositorioReal.findByOid(dataset.getInteger("oid_repo_real"),getSesion());
        repositorioreal.setOID(dataset.getInteger("oid_repo_real"));
        repositorioreal.setCodigo(dataset.getString("codigo"));
        repositorioreal.setDescripcion(dataset.getString("descripcion"));
        repositorioreal.setActivo(dataset.getBoolean("activo"));
        repositorioreal.setGrupoRepositorioReal(GrupoRepositorioReal.findByOidProxy(dataset.getInteger("oid_grupo_repo"),this.getSesion()));
        
        IDataSet dsRepoRealDet = dataset.getDataSet("TRepositorioRealDet");
        dsRepoRealDet.first(); 
        while (!dsRepoRealDet.EOF()) { 
          DefinicionRepositorioReal definicionrepositorioreal = DefinicionRepositorioReal.findByOid(dsRepoRealDet.getInteger("oid_repo_det"),getSesion());
          definicionrepositorioreal.setDescripcion(dsRepoRealDet.getString("descripcion"));
          definicionrepositorioreal.setRepositorio_real(repositorioreal);
          
          if (dsRepoRealDet.getString("tipo").equals(DefinicionRepositorioReal.TIPO_COMPO)) 
          	definicionrepositorioreal.setCompo_presupuestario(CompoPresupuestario.findByOidProxy(dsRepoRealDet.getInteger("oid_elemento"),this.getSesion()));
          else
          	if (dsRepoRealDet.getString("tipo").equals(DefinicionRepositorioReal.TIPO_PERI))
          		definicionrepositorioreal.setTipo_periodo(TipoPeriodo.findByOidProxy(dsRepoRealDet.getInteger("oid_elemento"),this.getSesion()));
          	else
          		if (dsRepoRealDet.getString("tipo").equals(DefinicionRepositorioReal.TIPO_METRICA))
          			definicionrepositorioreal.setMetrica(Metrica.findByOidProxy(dsRepoRealDet.getInteger("oid_elemento"),this.getSesion()));
          
          
          definicionrepositorioreal.setOrden(dsRepoRealDet.getInteger("orden"));
          definicionrepositorioreal.setTipo(dsRepoRealDet.getString("tipo"));
          definicionrepositorioreal.setActivo(dsRepoRealDet.getBoolean("activo"));
          definicionrepositorioreal.setObligatorio(dsRepoRealDet.getBoolean("obligatorio").booleanValue());
          
          if (definicionrepositorioreal.isActivo().booleanValue() == false)
          	definicionrepositorioreal.delete();
          
          repositorioreal.addDefinicionRepoReal(definicionrepositorioreal);
          dsRepoRealDet.next();
      }

      addTransaccion(repositorioreal);
      dataset.next();
    }
  }
  
}
