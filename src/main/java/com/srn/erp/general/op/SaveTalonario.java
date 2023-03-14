package com.srn.erp.general.op;

import com.srn.erp.general.bm.ImpresoraComun;
import com.srn.erp.general.bm.ImpresoraFiscal;
import com.srn.erp.general.bm.LugarEmision;
import com.srn.erp.general.bm.RTMTalonario;
import com.srn.erp.general.bm.Talonario;
import com.srn.erp.general.bm.TipoComprobante;
import com.srn.erp.general.bm.UniOrgTalonario;
import com.srn.erp.general.bm.UnidadOrganizativa;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveTalonario extends Operation {

  public SaveTalonario() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    IDataSet dataset = mapaDatos.getDataSet("TTalonario");
    procesarRegistros(dataset);
  }

  private void procesarRegistros(IDataSet dataset) throws BaseException {
    dataset.first();
      while (!dataset.EOF()) {
        Talonario talonario = Talonario.findByOid(dataset.getInteger("oid_talonario"),getSesion());
        talonario.setOID(dataset.getInteger("oid_talonario"));
        talonario.setCodigo(dataset.getString("codigo"));
        talonario.setDescripcion(dataset.getString("descripcion"));
        talonario.setImpo_imp_asoc(dataset.getString("tipo_imp_asoc"));
        talonario.setImpresora_fiscal(ImpresoraFiscal.findByOidProxy(dataset.getInteger("oid_imp_fiscal"),getSesion()));
        talonario.setImpresora_comun(ImpresoraComun.findByOidProxy(dataset.getInteger("oid_imp_comun"),getSesion()));
        talonario.setTipo_comprobante(TipoComprobante.findByOidProxy(dataset.getInteger("oid_tc"),getSesion()));
        talonario.setLetra(dataset.getString("letra"));
        talonario.setLugar_emision(LugarEmision.findByOidProxy(dataset.getInteger("oid_lug_emi"),getSesion()));
        talonario.setNombre_archivo_impresion(dataset.getString("nom_arch_imp"));
        talonario.setPrimer_nro(dataset.getInteger("primer_nro"));
        talonario.setNro_actual(dataset.getInteger("nro_actual"));
        talonario.setUltimo_nro(dataset.getInteger("ultimo_nro"));
        talonario.setNro_automatica(dataset.getBoolean("nro_automatica"));
        talonario.setFec_vto(dataset.getDate("fec_vto"));
        talonario.setCai(dataset.getString("cai"));
        talonario.setUnidad_organizativa(UnidadOrganizativa.findByOidProxy(dataset.getInteger("oid_uni_org"),getSesion()));
        talonario.setTalonarioAnulacion(Talonario.findByOidProxy(dataset.getInteger("oid_tal_anu"),getSesion()));
        talonario.setActivo(dataset.getBoolean("activo"));
        talonario.setCantCopias(dataset.getInteger("cant_copias"));
        talonario.setIntercalar(dataset.getBoolean("intercalar"));
        talonario.setOrientacion(dataset.getString("orientacion"));
        talonario.setGenerarArchivo(dataset.getBoolean("generar_archivo"));
        talonario.setTipoArchivo(dataset.getString("tipo_archivo"));
        talonario.setArchivoRTM(dataset.getString("archivo_rtm"));
        talonario.setIdentifArchGeneracionArchivo(dataset.getString("identif_arch_ga"));
        talonario.setIdentifArchImpresion(dataset.getString("identif_arch_im"));
        talonario.setIdentifArchVistaPreliminar(dataset.getString("identif_arch_vp"));
        talonario.setCodigoLetra(dataset.getString("codigo_letra"));
        talonario.setComportamientoImpresion(dataset.getString("compo_impresion"));
        talonario.setPathGeneracionArchImpresion(dataset.getString("path_gen_arch_imp"));
        talonario.setTipoImpresion(dataset.getString("tipo_impresion"));
        talonario.setEsFactElec(dataset.getBoolean("es_fe"));
        talonario.setCodigoTCFactEle(dataset.getInteger("codigo_tc_fe"));
        
        IDataSet dsRTMTalonario = dataset.getDataSet("TRTMTalonario");
        dsRTMTalonario.first();
        while (!dsRTMTalonario.EOF()) {
        	RTMTalonario rtmTalonario = RTMTalonario.findByOid(dsRTMTalonario.getInteger("oid_rtm_talonario"),this.getSesion());
        	rtmTalonario.setTalonario(Talonario.findByOidProxy(dsRTMTalonario.getInteger("oid_talonario"),getSesion()));
        	rtmTalonario.setCondicion(dsRTMTalonario.getString("condicion_compro"));
        	rtmTalonario.setArchivo_rtm(dsRTMTalonario.getString("archivo_rtm"));
        	rtmTalonario.setActivo(dsRTMTalonario.getBoolean("activo"));
        	
        	if (rtmTalonario.isActivo().booleanValue() == false)
        		rtmTalonario.delete();
        	
        	talonario.addRTMTalonario(rtmTalonario);
        	dsRTMTalonario.next();
        }
        
        IDataSet dsUniOrgTal = dataset.getDataSet("TUniOrgTalonario");
        dsUniOrgTal.first();
        while (!dsUniOrgTal.EOF()) {
        	
        	UniOrgTalonario uniOrgTal = UniOrgTalonario.findByOid(dsUniOrgTal.getInteger("oid_uni_org_tal"),this.getSesion());
        	uniOrgTal.setTalonario(Talonario.findByOidProxy(dsUniOrgTal.getInteger("oid_talonario"),getSesion()));
        	uniOrgTal.setUnidad_organizativa(UnidadOrganizativa.findByOidProxy(dsUniOrgTal.getInteger("oid_uni_org"),getSesion()));
        	uniOrgTal.setActivo(dsUniOrgTal.getBoolean("activo"));
        	
        	if (uniOrgTal.isActivo().booleanValue() == false)
        		uniOrgTal.delete();
        	
        	talonario.addUniOrgTalonario(uniOrgTal);
        	dsUniOrgTal.next();
        }
        
        
        addTransaccion(talonario);
        dataset.next();
    }
  }

}
