package com.srn.erp.presupuesto.op;

import com.srn.erp.presupuesto.bm.AtriCompoPresu;
import com.srn.erp.presupuesto.bm.CompoPresupuestario;
import com.srn.erp.presupuesto.bm.GrupoComponente;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveCompoPresupuestario extends Operation { 

  public SaveCompoPresupuestario() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    IDataSet dataset = mapaDatos.getDataSet("TCompoPresupuestario"); 
    procesarRegistros(dataset); 
  } 

  private void procesarRegistros(IDataSet dataset) throws BaseException { 
    dataset.first(); 
      while (!dataset.EOF()) { 
        CompoPresupuestario compopresupuestario = CompoPresupuestario.findByOid(dataset.getInteger("oid_compo_presu"),getSesion());
        compopresupuestario.setOID(dataset.getInteger("oid_compo_presu"));
        compopresupuestario.setCodigo(dataset.getString("codigo"));	
        compopresupuestario.setDescripcion(dataset.getString("descripcion"));
        compopresupuestario.setTipo(CompoPresupuestario.TIPO_COMPO_ESTANDAR);
        compopresupuestario.setGrupo_compo(GrupoComponente.findByOidProxy(dataset.getInteger("oid_grupo_compo"),this.getSesion()));
        compopresupuestario.setActivo(dataset.getBoolean("activo"));
        
        IDataSet dsDefAtri = dataset.getDataSet("TAtriCompoPresu");
        dsDefAtri.first();
        while (!dsDefAtri.EOF()) {
          AtriCompoPresu atricompopresu = AtriCompoPresu.findByOid(dsDefAtri.getInteger("oid_atri_presu"),getSesion());
          atricompopresu.setCompo_presu(compopresupuestario);
          atricompopresu.setTipo_atributo(dsDefAtri.getString("tipo_atributo"));
          atricompopresu.setNombre_logico(dsDefAtri.getString("nombre_logico"));
          atricompopresu.setNro_orden(dsDefAtri.getInteger("nro_orden"));
          atricompopresu.setCompo_presu_atri(CompoPresupuestario.findByOidProxy(dsDefAtri.getInteger("oid_compo_atri"),this.getSesion()));
          atricompopresu.setActivo(dsDefAtri.getBoolean("activo"));
          atricompopresu.setObligatorio(dsDefAtri.getBoolean("obligatorio"));
          atricompopresu.setNroInternoAtri(dsDefAtri.getInteger("nro_interno_atri"));
          atricompopresu.setFormato(dsDefAtri.getString("formato"));
          compopresupuestario.addAtriCompoPresu(atricompopresu);
          
        	dsDefAtri.next();
        }               
        
        addTransaccion(compopresupuestario);
        dataset.next();
    }
  }
  
}
