package com.srn.erp.general.op;

import java.util.Iterator;

import com.srn.erp.general.bm.ImpresoraComun;
import com.srn.erp.general.bm.ImpresoraFiscal;
import com.srn.erp.general.bm.LugarEmision;
import com.srn.erp.general.bm.RTMTalonario;
import com.srn.erp.general.bm.Talonario;
import com.srn.erp.general.bm.TipoComprobante;
import com.srn.erp.general.bm.UniOrgTalonario;
import com.srn.erp.general.bm.UnidadOrganizativa;

import framework.applicarionServer.bl.Utils.Fecha;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerTalonario extends Operation {

  public TraerTalonario() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    Talonario talonario = null;
    if (mapaDatos.containsKey("oid")) {
       Integer oid = mapaDatos.getInteger("oid");
       talonario = Talonario.findByOid(oid, getSesion());
    }
    else {
       String codigo = mapaDatos.getString("codigo");
       talonario = Talonario.findByCodigo(codigo, getSesion());
    }

    IDataSet datasetTalonario = getDataSetTalonario();
    IDataSet datasetTalorarioRTM = getDataSetRTMTalonario();
    IDataSet datasetUniOrgTal = this.getDataSetUniOrgTalonario();
    
    if (talonario != null) {
        cargarRegistroTalonario(datasetTalonario,
                         talonario.getOIDInteger(),
                         talonario.getCodigo(),
                         talonario.getDescripcion(),
                         talonario.getImpo_imp_asoc(),
                         talonario.getImpresora_fiscal(),
                         talonario.getImpresora_comun(),
                         talonario.getTipo_comprobante(),
                         talonario.getLetra(),
                         talonario.getLugar_emision(),
                         talonario.getNombre_archivo_impresion(),
                         talonario.getPrimer_nro(),
                         talonario.getNro_actual(),
                         talonario.getUltimo_nro(),
                         talonario.isNro_automatica(),
                         talonario.getFec_vto(),
                         talonario.getCai(),
                         talonario.getUnidad_organizativa(),
                         talonario.isActivo(),
                         talonario.getTalonarioAnulacion(),
                         talonario.getCantCopias(),
                         talonario.isIntercalar(),
                         talonario.getOrientacion(),
                         talonario.isGenerararchivo(),
                         talonario.getTipoArchivo(),
                         talonario.getArchivoRTM(),
                         talonario.getIdentifArchVistaPreliminar(),
                         talonario.getIdentifArchImpresion(),
                         talonario.getIdentifArchGeneracionArchivo(),
                         talonario.getCodigoLetra(),
                         talonario.getComportamientoImpresion(),
                         talonario.getPathGeneracionArchImpresion(),
                         talonario.getTipoImpresion(),
                         talonario.isFactElec(),
                         talonario.getCodigoTCFactEle()
                         );
        
        Iterator iterRTMTalonarios = talonario.getRTMTalonarios().iterator();
        while (iterRTMTalonarios.hasNext()) {
        	RTMTalonario rtmTalonario = (RTMTalonario) iterRTMTalonarios.next();
        	cargarRegistroRTM(rtmTalonario,datasetTalorarioRTM);
        }
        
        Iterator iterUniOrgTal = talonario.getUnidadesOrganizativasTalonario().iterator();
        while (iterUniOrgTal.hasNext()) {
        	UniOrgTalonario uniOrgTalonario = (UniOrgTalonario) iterUniOrgTal.next();
        	cargarRegistroUniOrgTalonario(uniOrgTalonario,datasetUniOrgTal);
        }
        
        
        
    }
    writeCliente(datasetTalonario);
    writeCliente(datasetTalorarioRTM);
    writeCliente(datasetUniOrgTal);
  }
  
  private void cargarRegistroRTM(RTMTalonario rtmTalonario,IDataSet dsTalonario) throws BaseException {
  	dsTalonario.append();
  	dsTalonario.fieldValue("oid_rtm_talonario", rtmTalonario.getOIDInteger());
  	dsTalonario.fieldValue("oid_talonario", rtmTalonario.getTalonario().getOIDInteger());
  	dsTalonario.fieldValue("condicion_compro", rtmTalonario.getCondicion());
  	dsTalonario.fieldValue("archivo_rtm", rtmTalonario.getArchivo_rtm());
  	dsTalonario.fieldValue("activo" , rtmTalonario.isActivo());
  }
  
  private void cargarRegistroUniOrgTalonario(UniOrgTalonario uniOrgTal,IDataSet dsTalonario) throws BaseException {
  	dsTalonario.append();
  	
  	dsTalonario.fieldValue("oid_uni_org_tal", uniOrgTal.getOIDInteger());
  	dsTalonario.fieldValue("oid_talonario", uniOrgTal.getTalonario().getOIDInteger());
  	dsTalonario.fieldValue("oid_uni_org", uniOrgTal.getUnidad_organizativa().getOIDInteger());
  	dsTalonario.fieldValue("cod_uni_org", uniOrgTal.getUnidad_organizativa().getCodigo());
  	dsTalonario.fieldValue("desc_uni_org", uniOrgTal.getUnidad_organizativa().getDescripcion());
  	dsTalonario.fieldValue("activo" , uniOrgTal.isActivo());
  }
  

  private IDataSet getDataSetTalonario() {
    IDataSet dataset = new TDataSet();
    dataset.create("TTalonario");
    dataset.fieldDef(new Field("oid_talonario", Field.INTEGER, 0));
    dataset.fieldDef(new Field("codigo", Field.STRING, 30));
    dataset.fieldDef(new Field("descripcion", Field.STRING, 50));
    dataset.fieldDef(new Field("tipo_imp_asoc", Field.STRING, 15));
    dataset.fieldDef(new Field("oid_imp_fiscal", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_imp_fiscal", Field.STRING, 30));
    dataset.fieldDef(new Field("desc_imp_fiscal", Field.STRING, 100));
    dataset.fieldDef(new Field("oid_imp_comun", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_imp_comun", Field.STRING, 30));
    dataset.fieldDef(new Field("desc_imp_comun", Field.STRING, 100));
    dataset.fieldDef(new Field("oid_tc", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_tc", Field.STRING, 30));
    dataset.fieldDef(new Field("desc_tc", Field.STRING, 100));
    dataset.fieldDef(new Field("letra", Field.STRING, 1));
    dataset.fieldDef(new Field("oid_lug_emi", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_lug_emi", Field.STRING, 30));
    dataset.fieldDef(new Field("desc_lug_emi", Field.STRING, 100));
    dataset.fieldDef(new Field("nom_arch_imp", Field.STRING, 100));
    dataset.fieldDef(new Field("primer_nro", Field.INTEGER, 0));
    dataset.fieldDef(new Field("nro_actual", Field.INTEGER, 0));
    dataset.fieldDef(new Field("ultimo_nro", Field.INTEGER, 0));
    dataset.fieldDef(new Field("nro_automatica", Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("fec_vto", Field.STRING, 10));
    dataset.fieldDef(new Field("cai", Field.STRING, 100));
    dataset.fieldDef(new Field("oid_uni_org", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_uni_org", Field.STRING, 30));
    dataset.fieldDef(new Field("desc_uni_org", Field.STRING, 100));
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("oid_tal_anu",Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_tal_anu",Field.STRING, 50));
    dataset.fieldDef(new Field("desc_tal_anu",Field.STRING, 100));
	dataset.fieldDef(new Field("cant_copias",Field.INTEGER, 0));
	dataset.fieldDef(new Field("intercalar",Field.BOOLEAN, 0));
	dataset.fieldDef(new Field("orientacion",Field.STRING, 20));
	dataset.fieldDef(new Field("generar_archivo",Field.BOOLEAN, 0));
	dataset.fieldDef(new Field("tipo_archivo",Field.STRING, 20));
	dataset.fieldDef(new Field("archivo_rtm",Field.STRING, 255));		
	dataset.fieldDef(new Field("identif_arch_vp",Field.STRING, 20));
	dataset.fieldDef(new Field("identif_arch_im",Field.STRING, 20));
	dataset.fieldDef(new Field("identif_arch_ga",Field.STRING, 20));
	dataset.fieldDef(new Field("codigo_letra",Field.STRING, 20));
	dataset.fieldDef(new Field("compo_impresion",Field.STRING, 20));
	dataset.fieldDef(new Field("path_gen_arch_imp",Field.STRING, 255));
	dataset.fieldDef(new Field("tipo_impresion",Field.STRING, 50));	
	dataset.fieldDef(new Field("es_fe",Field.BOOLEAN, 0));
	dataset.fieldDef(new Field("codigo_tc_fe",Field.INTEGER, 0));
	
    return dataset;
  }
  
  private IDataSet getDataSetRTMTalonario() {
    IDataSet dataset = new TDataSet();
    dataset.create("TRTMTalonario");
    dataset.fieldDef(new Field("oid_rtm_talonario", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_talonario", Field.INTEGER, 0));
    dataset.fieldDef(new Field("condicion_compro", Field.STRING, 255));
    dataset.fieldDef(new Field("archivo_rtm", Field.STRING, 255));
    dataset.fieldDef(new Field("activo" , Field.BOOLEAN, 0));
    return dataset;
  }
  
  private IDataSet getDataSetUniOrgTalonario() {
    IDataSet dataset = new TDataSet();
    dataset.create("TUniOrgTalonario");
    dataset.fieldDef(new Field("oid_uni_org_tal", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_talonario", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_uni_org", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_uni_org", Field.STRING, 50));
    dataset.fieldDef(new Field("desc_uni_org", Field.STRING, 100));
    dataset.fieldDef(new Field("activo" , Field.BOOLEAN, 0));
    return dataset;
  }
  
  

  private void cargarRegistroTalonario(IDataSet dataset,
                         Integer oid_talonario,
                         String codigo,
                         String descripcion,
                         String tipo_imp_asoc,
                         ImpresoraFiscal imp_fiscal,
                         ImpresoraComun imp_comun,
                         TipoComprobante tc,
                         String letra,
                         LugarEmision lug_emi,
                         String nom_arch_imp,
                         Integer primer_nro,
                         Integer nro_actual,
                         Integer ultimo_nro,
                         Boolean nro_automatica,
                         java.util.Date fec_vto,
                         String cai,
                         UnidadOrganizativa uni_org,
                         Boolean activo,
                         Talonario talonarioAnulacion,
                         Integer cantCopias,
                         Boolean intercalar,
                         String orientacion,
                         Boolean generarArchivo,
                         String tipoArchivo,
                         String archivoRTM,
                         String identifArchVP,
                         String identifArchIM,
                         String identifArchGA,
                         String codigoLetra,
                         String compoImpresion,
                         String pathGenArchImp,
                         String tipoImpresion,
                         Boolean esFactEle,
                         Integer codigoTCFe) throws BaseException  {
    dataset.append();
    dataset.fieldValue("oid_talonario", oid_talonario);
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("descripcion", descripcion);
    dataset.fieldValue("tipo_imp_asoc", tipo_imp_asoc);
    if (imp_fiscal!=null) {
      dataset.fieldValue("oid_imp_fiscal", imp_fiscal.getOIDInteger());
      dataset.fieldValue("cod_imp_fiscal", imp_fiscal.getCodigo());
      dataset.fieldValue("desc_imp_fiscal", imp_fiscal.getDescripcion());
    }
    else {
      dataset.fieldValue("oid_imp_fiscal", 0);
      dataset.fieldValue("cod_imp_fiscal", "");
      dataset.fieldValue("desc_imp_fiscal", "");
    }

    if (imp_comun!=null) {
      dataset.fieldValue("oid_imp_comun", imp_comun.getOIDInteger());
      dataset.fieldValue("cod_imp_comun", imp_comun.getCodigo());
      dataset.fieldValue("desc_imp_comun", imp_comun.getDescripcion());
    }
    else {
      dataset.fieldValue("oid_imp_comun", 0);
      dataset.fieldValue("cod_imp_comun", "");
      dataset.fieldValue("desc_imp_comun", "");
    }

    if (tc!=null) {
      dataset.fieldValue("oid_tc", tc.getOIDInteger());
      dataset.fieldValue("cod_tc", tc.getCodigo());
      dataset.fieldValue("desc_tc", tc.getDescripcion());
    }
    else {
      dataset.fieldValue("oid_tc", 0);
      dataset.fieldValue("cod_tc", "");
      dataset.fieldValue("desc_tc", "");
    }

    dataset.fieldValue("letra", letra);

    if (lug_emi!=null) {
      dataset.fieldValue("oid_lug_emi", lug_emi.getOIDInteger());
      dataset.fieldValue("cod_lug_emi", lug_emi.getCodigo());
      dataset.fieldValue("desc_lug_emi", lug_emi.getDescripcion());
    }
    else {
      dataset.fieldValue("oid_lug_emi", 0);
      dataset.fieldValue("cod_lug_emi", "");
      dataset.fieldValue("desc_lug_emi", "");
    }

    if (nom_arch_imp!=null)
      dataset.fieldValue("nom_arch_imp", nom_arch_imp);
    else
      dataset.fieldValue("nom_arch_imp", "");

    dataset.fieldValue("primer_nro", primer_nro);
    dataset.fieldValue("nro_actual", nro_actual);
    dataset.fieldValue("ultimo_nro", ultimo_nro);

    dataset.fieldValue("nro_automatica", nro_automatica);
    dataset.fieldValue("fec_vto", Fecha.getddmmyyyy(fec_vto));
    dataset.fieldValue("cai", cai);

    if (uni_org!=null) {
      dataset.fieldValue("oid_uni_org", uni_org.getOIDInteger());
      dataset.fieldValue("cod_uni_org", uni_org.getCodigo());
      dataset.fieldValue("desc_uni_org", uni_org.getDescripcion());
    }
    else {
      dataset.fieldValue("oid_uni_org", 0);
      dataset.fieldValue("cod_uni_org", "");
      dataset.fieldValue("desc_uni_org", "");
    }

    dataset.fieldValue("activo", activo);
    
    if (talonarioAnulacion!=null) {
    	dataset.fieldValue("oid_tal_anu",talonarioAnulacion.getOID());
    	dataset.fieldValue("cod_tal_anu",talonarioAnulacion.getCodigo());
    	dataset.fieldValue("desc_tal_anu",talonarioAnulacion.getDescripcion());
    }
    else {
    	dataset.fieldValue("oid_tal_anu",0);
    	dataset.fieldValue("cod_tal_anu","");
    	dataset.fieldValue("desc_tal_anu","");
    }
    
    dataset.fieldValue("cant_copias", cantCopias);
    dataset.fieldValue("intercalar", intercalar);
    dataset.fieldValue("orientacion", orientacion);
    dataset.fieldValue("generar_archivo", generarArchivo);
    dataset.fieldValue("tipo_archivo", tipoArchivo);
    
    dataset.fieldValue("archivo_rtm", archivoRTM);
    
    dataset.fieldValue("identif_arch_vp",identifArchVP);
    dataset.fieldValue("identif_arch_im",identifArchIM);
    dataset.fieldValue("identif_arch_ga",identifArchGA);
    
    dataset.fieldValue("codigo_letra", codigoLetra);    
    dataset.fieldValue("compo_impresion", compoImpresion);
    dataset.fieldValue("path_gen_arch_imp", pathGenArchImp);
    dataset.fieldValue("tipo_impresion", tipoImpresion);
    dataset.fieldValue("es_fe",esFactEle);
    dataset.fieldValue("codigo_tc_fe",codigoTCFe);

  }
}
