package com.srn.erp.general.op;

import java.util.Iterator;

import com.srn.erp.general.bm.ImpresoraFiscal;
import com.srn.erp.general.bm.Talonario;
import com.srn.erp.general.bm.UnidadOrganizativa;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerImpresoraFiscal extends Operation {

  public TraerImpresoraFiscal() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    ImpresoraFiscal impresorafiscal = null;
    if (mapaDatos.containsKey("oid")) {
       Integer oid = mapaDatos.getInteger("oid");
       impresorafiscal = ImpresoraFiscal.findByOid(oid, getSesion());
       enviarImpresoraFiscal(impresorafiscal);
    }
    else if (mapaDatos.containsKey("codigo")) {
       			String codigo = mapaDatos.getString("codigo");
       			impresorafiscal = ImpresoraFiscal.findByCodigo(codigo, getSesion());
       			enviarImpresoraFiscal(impresorafiscal);
    			} else {
    				enviarTodasLasImpresoraFiscales();
    			}

  }
  
  private void enviarTodasLasImpresoraFiscales() throws BaseException {
  	IDataSet datasetImpresoraFiscal = getDataSetImpresoraFiscal();
  	Iterator iterImpFisAct = ImpresoraFiscal.getAllImpresorasActivas(this.getSesion()).iterator();
  	while (iterImpFisAct.hasNext()) {
  		ImpresoraFiscal impresorafiscal = (ImpresoraFiscal) iterImpFisAct.next();
      cargarRegistroImpresoraFiscal(datasetImpresoraFiscal,
          impresorafiscal.getOIDInteger(),
          impresorafiscal.getCodigo(),
          impresorafiscal.getDescripcion(),
          impresorafiscal.getCompo_imp_fiscal(),
          impresorafiscal.isActivo(),
          impresorafiscal.getUnidadOrganizativa(),
          impresorafiscal.getPuerto(),
          impresorafiscal.getBaudios(),
          impresorafiscal.getDriver(),
          impresorafiscal.getComportamiento(),
          impresorafiscal.getPathGenArch(),
          Talonario.getModoImpresionControladorFiscal(impresorafiscal.getComportamiento())          
          );
  		
  		
  	}
  	writeCliente(datasetImpresoraFiscal);  	
  }
  
  private void enviarImpresoraFiscal(ImpresoraFiscal impresorafiscal) throws BaseException {
    IDataSet datasetImpresoraFiscal = getDataSetImpresoraFiscal();
    if (impresorafiscal != null) {
        cargarRegistroImpresoraFiscal(datasetImpresoraFiscal,
                         impresorafiscal.getOIDInteger(),
                         impresorafiscal.getCodigo(),
                         impresorafiscal.getDescripcion(),
                         impresorafiscal.getCompo_imp_fiscal(),
                         impresorafiscal.isActivo(),
                         impresorafiscal.getUnidadOrganizativa(),
                         impresorafiscal.getPuerto(),
                         impresorafiscal.getBaudios(),
                         impresorafiscal.getDriver(),
                         impresorafiscal.getComportamiento(),
                         impresorafiscal.getPathGenArch(),
                         Talonario.getModoImpresionControladorFiscal(impresorafiscal.getComportamiento())
                         );
    }
    writeCliente(datasetImpresoraFiscal);  	
  }

  private IDataSet getDataSetImpresoraFiscal() {
    IDataSet dataset = new TDataSet();
    dataset.create("TImpresoraFiscal");
    dataset.fieldDef(new Field("oid_imp_fiscal", Field.INTEGER, 0));
    dataset.fieldDef(new Field("codigo", Field.STRING, 30));
    dataset.fieldDef(new Field("descripcion", Field.STRING, 100));
    dataset.fieldDef(new Field("compo_imp_fiscal", Field.STRING, 15));
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("oid_uni_org", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_uni_org", Field.STRING, 50));
    dataset.fieldDef(new Field("desc_uni_org", Field.STRING, 100));
    dataset.fieldDef(new Field("puerto", Field.INTEGER, 0));
    dataset.fieldDef(new Field("baudios", Field.INTEGER, 0));
    dataset.fieldDef(new Field("driver", Field.STRING, 100));
    dataset.fieldDef(new Field("compo_impresion", Field.STRING, 50));
    dataset.fieldDef(new Field("path_gen_arch_imp", Field.STRING, 255));
    dataset.fieldDef(new Field("nro_modo_impresion", Field.INTEGER, 0));
    
        
    return dataset;
  }

  private void cargarRegistroImpresoraFiscal(IDataSet dataset,
                         Integer oid_imp_fiscal,
                         String codigo,
                         String descripcion,
                         String compo_imp_fiscal,
                         Boolean activo,
                         UnidadOrganizativa uniOrg,
                         Integer puerto,
                         Integer baudios,
                         String driver,
                         String compoImpresion,
                         String pathGenArchImp,
                         Integer nroModoImpresion) throws BaseException {
    dataset.append();
    dataset.fieldValue("oid_imp_fiscal", oid_imp_fiscal);
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("descripcion", descripcion);
    dataset.fieldValue("compo_imp_fiscal", compo_imp_fiscal);
    dataset.fieldValue("activo", activo);
    if (uniOrg!=null) {
      dataset.fieldValue("oid_uni_org", uniOrg.getOID());
      dataset.fieldValue("cod_uni_org", uniOrg.getCodigo());
      dataset.fieldValue("desc_uni_org", uniOrg.getDescripcion());
    }
    else {
      dataset.fieldValue("oid_uni_org", 0);
      dataset.fieldValue("cod_uni_org", "");
      dataset.fieldValue("desc_uni_org", "");
    }
    dataset.fieldValue("puerto", puerto);
    dataset.fieldValue("baudios", baudios);
    dataset.fieldValue("driver", driver);
    dataset.fieldValue("compo_impresion", compoImpresion);
    dataset.fieldValue("path_gen_arch_imp", pathGenArchImp);
    dataset.fieldValue("nro_modo_impresion", nroModoImpresion);
    
    
  }
}
