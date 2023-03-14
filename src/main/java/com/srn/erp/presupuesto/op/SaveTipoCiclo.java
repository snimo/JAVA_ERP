package com.srn.erp.presupuesto.op;

import com.srn.erp.presupuesto.bm.EstructuraPlanificacion;
import com.srn.erp.presupuesto.bm.EstructuraTipoCiclo;
import com.srn.erp.presupuesto.bm.GrupoTipoUPC;
import com.srn.erp.presupuesto.bm.GrupoUPCTipoCiclo;
import com.srn.erp.presupuesto.bm.TipoCiclo;
import com.srn.erp.presupuesto.bm.ValorEscenario;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveTipoCiclo extends Operation { 

  public SaveTipoCiclo() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    IDataSet dataset = mapaDatos.getDataSet("TTipoCiclo"); 
    procesarRegistros(dataset); 
  } 

  private void procesarRegistros(IDataSet dataset) throws BaseException { 
    dataset.first(); 
      while (!dataset.EOF()) {
      	
        TipoCiclo tipoCiclo = TipoCiclo.findByOid(dataset.getInteger("oid_tipo_ciclo"),getSesion());
        tipoCiclo.setCodigo(dataset.getString("codigo"));
        tipoCiclo.setDescripcion(dataset.getString("descripcion"));
        tipoCiclo.setValor_escenario(ValorEscenario.findByOidProxy(dataset.getInteger("oid_val_escenario"),this.getSesion()));
        tipoCiclo.setActivo(dataset.getBoolean("activo"));
        
        IDataSet dsEstrucTipoCiclo = dataset.getDataSet("TEstructuraTipoCiclo");
        dsEstrucTipoCiclo.first();
        while (!dsEstrucTipoCiclo.EOF()) {
        	
        	EstructuraPlanificacion estructura =
        		EstructuraPlanificacion.findByOidProxy(dsEstrucTipoCiclo.getInteger("oid_estruc_planif"),this.getSesion());
        	
        	EstructuraTipoCiclo estrucTipoCiclo = 
        		EstructuraTipoCiclo.getEstructuraTipoCiclo(tipoCiclo,estructura,this.getSesion());
        	
        	if (estrucTipoCiclo == null) 
        		estrucTipoCiclo = (EstructuraTipoCiclo) EstructuraTipoCiclo.getNew(EstructuraTipoCiclo.NICKNAME,this.getSesion()); 
        	
        	estrucTipoCiclo.setTipo_ciclo(tipoCiclo);
        	estrucTipoCiclo.setEstructura_planificacion(EstructuraPlanificacion.findByOidProxy(dsEstrucTipoCiclo.getInteger("oid_estruc_planif"),this.getSesion()));
        	estrucTipoCiclo.setActivo(dsEstrucTipoCiclo.getBoolean("activo"));
        	tipoCiclo.addEstructuraTipoCiclo(estrucTipoCiclo);
        	dsEstrucTipoCiclo.next();
        }
        
        IDataSet dsGrupoUPCTipoCiclo = dataset.getDataSet("TGrupoUPCTipoCiclo");
        dsGrupoUPCTipoCiclo.first();
        while (!dsGrupoUPCTipoCiclo.EOF()) {
        	
        	GrupoTipoUPC grupoTipoUPC = 
        		GrupoTipoUPC.findByOidProxy(dsGrupoUPCTipoCiclo.getInteger("oid_grupo_tipo_upc"),this.getSesion());
        	
        	GrupoUPCTipoCiclo grupoUPCTipoCiclo =
        		GrupoUPCTipoCiclo.getGrupoUPCTipoCiclo(tipoCiclo,grupoTipoUPC,this.getSesion());
        	
        	if (grupoUPCTipoCiclo == null)
        		grupoUPCTipoCiclo = (GrupoUPCTipoCiclo) GrupoUPCTipoCiclo.getNew(GrupoUPCTipoCiclo.NICKNAME,this.getSesion());
        	
        	grupoUPCTipoCiclo.setTipo_ciclo(tipoCiclo);
        	grupoUPCTipoCiclo.setGrupo_tipo_upc(GrupoTipoUPC.findByOidProxy(dsGrupoUPCTipoCiclo.getInteger("oid_grupo_tipo_upc"),this.getSesion()));
        	grupoUPCTipoCiclo.setActivo(dsGrupoUPCTipoCiclo.getBoolean("activo"));
        	tipoCiclo.addGrupoUPCTipoCiclo(grupoUPCTipoCiclo);
        	dsGrupoUPCTipoCiclo.next();
        }
                
        addTransaccion(tipoCiclo);
        dataset.next();
    }
  }
  
}
