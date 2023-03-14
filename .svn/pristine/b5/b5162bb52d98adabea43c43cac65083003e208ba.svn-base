package com.srn.erp.contabilidad.op;

import com.srn.erp.contabilidad.bm.AtributoEntidadSeleccionado;
import com.srn.erp.contabilidad.bm.Componente;
import com.srn.erp.contabilidad.bm.ConceptoCtaContable;
import com.srn.erp.contabilidad.bm.CriterioSelCuenta;
import com.srn.erp.contabilidad.bm.Cuenta;
import com.srn.erp.contabilidad.bm.CuentaImputable;
import com.srn.erp.contabilidad.bm.GenerarValorCompoCriImpu;
import com.srn.erp.contabilidad.bm.ValoresAtriCriterioImpu;
import com.srn.erp.general.bm.DefinicionAtributoEntidad;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveConceptoCtaContable extends Operation { 

  public SaveConceptoCtaContable() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    IDataSet dataset = mapaDatos.getDataSet("TConceptoCtaContable"); 
    procesarRegistros(dataset); 
  } 

  private void procesarRegistros(IDataSet dataset) throws BaseException { 
    dataset.first(); 
      while (!dataset.EOF()) { 
        ConceptoCtaContable conceptoctacontable = ConceptoCtaContable.findByOid(dataset.getInteger("oid_conc_ctca"),getSesion());
        conceptoctacontable.setOID(dataset.getInteger("oid_conc_ctca"));
        conceptoctacontable.setCodigo(dataset.getString("codigo"));
        conceptoctacontable.setDescripcion(dataset.getString("descripcion"));
        conceptoctacontable.setNickname(dataset.getString("nickname"));
        conceptoctacontable.setActivo(dataset.getBoolean("activo"));
        
        IDataSet dsCriterios = dataset.getDataSet("TCriterioSelCta");
        dsCriterios.first();
        while (!dsCriterios.EOF()) {
        	CriterioSelCuenta criterioSelCuenta = CriterioSelCuenta.findByOid(dsCriterios.getInteger("oid_cri_sel_cta"),getSesion());
        	criterioSelCuenta.setConcepto_cuenta(conceptoctacontable);
        	criterioSelCuenta.setOrden(dsCriterios.getInteger("orden"));
        	criterioSelCuenta.setCriterio(dsCriterios.getString("criterio"));
        	criterioSelCuenta.setActivo(dsCriterios.getBoolean("activo"));
        	conceptoctacontable.addCriterioSelCuenta(criterioSelCuenta);
        	
        	IDataSet dsAtriEntSel = dsCriterios.getDataSet("TAtriEntSel");
        	dsAtriEntSel.first();
        	while (!dsAtriEntSel.EOF()) {
        		AtributoEntidadSeleccionado atriEntSel = AtributoEntidadSeleccionado.findByOid(dsAtriEntSel.getInteger("oid_atri_ent_sel"),getSesion());
        		atriEntSel.setOrden(dsAtriEntSel.getInteger("orden"));
        		atriEntSel.setCriterio_seleccion_cta(criterioSelCuenta);
        		atriEntSel.setAtributo_entidad(DefinicionAtributoEntidad.findByOid(dsAtriEntSel.getInteger("oid_atri_ent"),getSesion()));
        		if (!dsAtriEntSel.getBoolean("activo").booleanValue())
        			atriEntSel.delete();
        		criterioSelCuenta.addAtributoEntSel(atriEntSel);
        		dsAtriEntSel.next();
        	}
        	
        	IDataSet dsValoresAtriCriImpu = dsCriterios.getDataSet("TValoresAtriCriterioImpu");
        	dsValoresAtriCriImpu.first();
        	while (!dsValoresAtriCriImpu.EOF()) {
        	
        		ValoresAtriCriterioImpu valAtriCriImpu = ValoresAtriCriterioImpu.findByOid(dsValoresAtriCriImpu.getInteger("oid_val_atri_ent"),getSesion());
        		if (!dsValoresAtriCriImpu.getBoolean("activo").booleanValue())
        		    valAtriCriImpu.delete();
        		valAtriCriImpu.setCriterio_sel_cta(criterioSelCuenta);    
        		if (!dsValoresAtriCriImpu.getString("nickname_1").trim().equals("")) 
        		  	valAtriCriImpu.setVal_atri_1((ObjetoLogico) ObjetoLogico.getObjectByOid(dsValoresAtriCriImpu.getString("nickname_1"),
        									dsValoresAtriCriImpu.getInteger("oid_val_atri_1"),
        									getSesion()));
        									        
        		if (!dsValoresAtriCriImpu.getString("nickname_2").trim().equals("")) 
        			valAtriCriImpu.setVal_atri_2((ObjetoLogico) ObjetoLogico.getObjectByOid(dsValoresAtriCriImpu.getString("nickname_2"),
        									dsValoresAtriCriImpu.getInteger("oid_val_atri_2"),
        									getSesion()));
        									
        		if (!dsValoresAtriCriImpu.getString("nickname_3").trim().equals(""))							
        			valAtriCriImpu.setVal_atri_3((ObjetoLogico) ObjetoLogico.getObjectByOid(dsValoresAtriCriImpu.getString("nickname_3"),
        									dsValoresAtriCriImpu.getInteger("oid_val_atri_3"),
        									getSesion()));
        									
        		if (!dsValoresAtriCriImpu.getString("nickname_4").trim().equals(""))
        			valAtriCriImpu.setVal_atri_1((ObjetoLogico) ObjetoLogico.getObjectByOid(dsValoresAtriCriImpu.getString("nickname_4"),
        									dsValoresAtriCriImpu.getInteger("oid_val_atri_4"),
        									getSesion()));
        									
				if (!dsValoresAtriCriImpu.getString("nickname_5").trim().equals(""))        									
        		valAtriCriImpu.setVal_atri_1((ObjetoLogico) ObjetoLogico.getObjectByOid(dsValoresAtriCriImpu.getString("nickname_5"),
        									dsValoresAtriCriImpu.getInteger("oid_val_atri_5"),
        									getSesion()));
        									
        		valAtriCriImpu.setTomar_cuenta(dsValoresAtriCriImpu.getString("tomar_cuenta"));
        		valAtriCriImpu.setCuenta_contable(Cuenta.findByOidProxy(dsValoresAtriCriImpu.getInteger("oid_ana_con"),getSesion()));
        		valAtriCriImpu.setCuenta_imputable(CuentaImputable.findByOidProxy(dsValoresAtriCriImpu.getInteger("oid_ai"),getSesion()));
        		         		
        		DefinicionAtributoEntidad defAtriEnt1 = 
        		  DefinicionAtributoEntidad.findByOidProxy(dsValoresAtriCriImpu.getInteger("oid_atri_ent_1"),getSesion());
        		valAtriCriImpu.setAtri_ent_1(defAtriEnt1);
        		DefinicionAtributoEntidad defAtriEnt2 = 
        		  DefinicionAtributoEntidad.findByOidProxy(dsValoresAtriCriImpu.getInteger("oid_atri_ent_2"),getSesion());
        		valAtriCriImpu.setAtri_ent_2(defAtriEnt2);   
        		DefinicionAtributoEntidad defAtriEnt3 = 
        		  DefinicionAtributoEntidad.findByOidProxy(dsValoresAtriCriImpu.getInteger("oid_atri_ent_3"),getSesion());
        		valAtriCriImpu.setAtri_ent_3(defAtriEnt3); 
        		DefinicionAtributoEntidad defAtriEnt4 = 
        		  DefinicionAtributoEntidad.findByOidProxy(dsValoresAtriCriImpu.getInteger("oid_atri_ent_4"),getSesion());
        		valAtriCriImpu.setAtri_ent_4(defAtriEnt4); 
        		DefinicionAtributoEntidad defAtriEnt5 = 
        		  DefinicionAtributoEntidad.findByOidProxy(dsValoresAtriCriImpu.getInteger("oid_atri_ent_5"),getSesion());
        		valAtriCriImpu.setAtri_ent_5(defAtriEnt5); 
        		criterioSelCuenta.addValAtriCriImpu(valAtriCriImpu);   

        		// Grabar los componentes a generar en base a atributos
        		IDataSet dsGenValCompo = dsValoresAtriCriImpu.getDataSet("TGenValCompoCriImpu");
        		dsGenValCompo.first();
        		while (!dsGenValCompo.EOF()) {
        			GenerarValorCompoCriImpu generarValor = GenerarValorCompoCriImpu.findByOid(dsGenValCompo.getInteger("oid_gen_val_compo"),getSesion());
        			generarValor.setValoresatricriterioimputacion(valAtriCriImpu);
        			generarValor.setComponente(Componente.findByOid(dsGenValCompo.getInteger("oid_compo"),getSesion()));
        			generarValor.setAtributo_entidad(DefinicionAtributoEntidad.findByOid(dsGenValCompo.getInteger("oid_atri_ent"),getSesion()));
        			if (generarValor.getAtributo_entidad() == null)
        				generarValor.delete();
        			valAtriCriImpu.addGenerarValorCompo(generarValor);
        			dsGenValCompo.next();
        		}
        		
        		dsValoresAtriCriImpu.next();
        	}
        	
        	
        	dsCriterios.next();
        }
        
        addTransaccion(conceptoctacontable);
        dataset.next();
    }
  }
  
}
