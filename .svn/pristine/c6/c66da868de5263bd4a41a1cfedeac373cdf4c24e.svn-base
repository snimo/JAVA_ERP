package com.srn.erp.bienUso.op;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.bienUso.bm.Bien;
import com.srn.erp.bienUso.bm.BienImputacion;
import com.srn.erp.bienUso.bm.ComposicionValorOrigen;
import com.srn.erp.bienUso.bm.GrupoBien;
import com.srn.erp.bienUso.bm.SistemaValuacion;
import com.srn.erp.bienUso.bm.SubBien;
import com.srn.erp.bienUso.bm.SubBienVidaUtil;
import com.srn.erp.contabilidad.bm.ComproContaDet;
import com.srn.erp.contabilidad.bm.CuentaImputable;
import com.srn.erp.general.bm.InformarComprobante;
import com.srn.erp.general.bm.Moneda;
import com.srn.erp.general.bm.Periodo;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveBien extends Operation { 

  private List listaVO = new ArrayList();
	
  public SaveBien() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    IDataSet dataset = mapaDatos.getDataSet("TBien"); 
    procesarRegistros(dataset); 
  } 

  private void procesarRegistros(IDataSet dataset) throws BaseException { 
    dataset.first(); 
      while (!dataset.EOF()) { 
        Bien bien = Bien.findByOid(dataset.getInteger("oid_bien_uso"),getSesion());
        bien.setOID(dataset.getInteger("oid_bien_uso"));
        bien.setCodigo(dataset.getString("codigo"));
        bien.setDescripcion(dataset.getString("descripcion"));
        bien.setAmortizable(dataset.getBoolean("amortizable"));
        bien.setEstado(dataset.getString("estado"));
        bien.setFec_alta(dataset.getDate("fec_alta"));
        bien.setGrupo_bien_uso(GrupoBien.findByOidProxy(dataset.getInteger("oid_grupo_bien_uso"),getSesion()));
        bien.setAi_vo(CuentaImputable.findByOidProxy(dataset.getInteger("oid_ai_vo"),getSesion()));
        bien.setAi_aa(CuentaImputable.findByOidProxy(dataset.getInteger("oid_ai_aa"),getSesion()));
        bien.setAi_rvo(CuentaImputable.findByOidProxy(dataset.getInteger("oid_ai_rvo"),getSesion()));
        bien.setAi_raa(CuentaImputable.findByOidProxy(dataset.getInteger("oid_ai_raa"),getSesion()));
        bien.setActivo(dataset.getBoolean("activo"));
        
        IDataSet dsBienImputacion = dataset.getDataSet("TBienImputacion");
        dsBienImputacion.first();
        while (!dsBienImputacion.EOF()) {
        	BienImputacion bienImputacion = BienImputacion.findByOid(dsBienImputacion.getInteger("oid_bien_impu"),getSesion());
        	bienImputacion.setBien_uso(Bien.findByOidProxy(dsBienImputacion.getInteger("oid_bien_uso"),getSesion()));
        	bienImputacion.setVigencia_desde(dsBienImputacion.getDate("vigencia_desde"));
        	bienImputacion.setCuenta_imputable(CuentaImputable.findByOidProxy(dsBienImputacion.getInteger("oid_ai"),getSesion()));
        	bienImputacion.setPorc(dsBienImputacion.getDouble("porc"));
        	bienImputacion.setActivo(dsBienImputacion.getBoolean("activo"));
        	bien.addBienImputacion(bienImputacion);
        	dsBienImputacion.next();
        }
        
        IDataSet dsSubBien = dataset.getDataSet("TSubBien");
        dsSubBien.first();
        while (!dsSubBien.EOF()) {
          SubBien subBien = SubBien.findByOid(dsSubBien.getInteger("oid_bien_alta"),getSesion());
          subBien.setBien_uso(bien);
          subBien.setNro_alta(dsSubBien.getInteger("nro_alta"));
          subBien.setDescripcion(dsSubBien.getString("descripcion"));
          subBien.setSigue_bien_ppal(dsSubBien.getBoolean("sigue_bien_ppal"));
          subBien.setPeri_ini_amort(Periodo.findByOidProxy(dsSubBien.getInteger("oid_peri_ini_amort"),getSesion()));
          subBien.setActivo(dsSubBien.getBoolean("activo"));
          bien.addSubBien(subBien);
          
          IDataSet dsSubBienVidaUtil = dsSubBien.getDataSet("TSubBienesVidaUtil");
          dsSubBienVidaUtil.first();
          while (!dsSubBienVidaUtil.EOF()) {
        	  java.util.Date fecImputacVO = null;
        	  if ((dsSubBienVidaUtil.getInteger("vida_util")==null) || ((dsSubBienVidaUtil.getInteger("vida_util")!=null) && (dsSubBienVidaUtil.getInteger("vida_util").intValue()==0)))
        	  {
        		  dsSubBienVidaUtil.next();
        		  continue;
        	  }
        	  
        	  SubBienVidaUtil subBienVidaUtil =
        		  SubBienVidaUtil.findByOid(dsSubBienVidaUtil.getInteger("oid_bien_vu"),getSesion());
        	  subBienVidaUtil.setSubbien(subBien);
        	  subBienVidaUtil.setSistema_valuacion(SistemaValuacion.findByOidProxy(dsSubBienVidaUtil.getInteger("oid_sist_val"),getSesion()));        	  
        	  subBienVidaUtil.setVidal_util(dsSubBienVidaUtil.getInteger("vida_util"));
        	  fecImputacVO = dsSubBienVidaUtil.getDate("fec_imputac");
        	  subBien.addSubBienVidaUtil(subBienVidaUtil);
        	  
        	
        	  IDataSet dsVO = dsSubBienVidaUtil.getDataSet("TBuComproVO");
        	  dsVO.first();
        	  while (!dsVO.EOF()) {
        		ComposicionValorOrigen compoValorOrigen = ComposicionValorOrigen.findByOid(dsVO.getInteger("oid_comp_vo"),getSesion());
        		compoValorOrigen.setSubbienVidaUtil(subBienVidaUtil);
        		compoValorOrigen.setCompro_conta_det(ComproContaDet.findByOidProxy(dsVO.getInteger("oid_dco"),getSesion()));
        		compoValorOrigen.setPorcentaje(dsVO.getDouble("porc"));
        		compoValorOrigen.setImpo_valor(dsVO.getDouble("impo_valor"));
        		compoValorOrigen.setMoneda(Moneda.findByOidProxy(dsVO.getInteger("oid_moneda"),getSesion()));
        		compoValorOrigen.setFecImputac(fecImputacVO);
        		subBienVidaUtil.addValorOrigen(compoValorOrigen);
        		listaVO.add(compoValorOrigen);
        		dsVO.next();  
        	  }
        	  
        	  dsSubBienVidaUtil.next();
          }
          dsSubBien.next();
        }
        
        addTransaccion(bien);
        dataset.next();
    }
  }
  
  protected void afterSave() throws BaseException {
	    // Mostrar los comprobantes de Valor Origen generados
	    InformarComprobante infoCompro = new InformarComprobante();
	  	Iterator iterListaVO = listaVO.iterator();
	  	while (iterListaVO.hasNext()) {
	  		ComposicionValorOrigen valorOrigen = (ComposicionValorOrigen) iterListaVO.next();
	  		infoCompro.cargarInfoCompro(valorOrigen.getComprobanteVO());
	  	}
	  	writeCliente(infoCompro.getDataSet());
  }
  
  

}
