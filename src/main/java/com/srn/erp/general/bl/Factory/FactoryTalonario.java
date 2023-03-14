package com.srn.erp.general.bl.Factory;

import com.srn.erp.general.bm.ImpresoraComun;
import com.srn.erp.general.bm.ImpresoraFiscal;
import com.srn.erp.general.bm.LugarEmision;
import com.srn.erp.general.bm.Talonario;
import com.srn.erp.general.bm.TipoComprobante;
import com.srn.erp.general.bm.UnidadOrganizativa;
import com.srn.erp.general.da.DBTalonario;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryTalonario extends FactoryObjetoLogico {

  public FactoryTalonario() {
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    Talonario talonario = (Talonario) objLog;
    talonario.setOID(db.getInteger(DBTalonario.OID_TALONARIO));
    talonario.setCodigo(db.getString(DBTalonario.CODIGO));
    talonario.setDescripcion(db.getString(DBTalonario.DESCRIPCION));
    talonario.setImpo_imp_asoc(db.getString(DBTalonario.TIPO_IMP_ASOC));
    talonario.setImpresora_fiscal(ImpresoraFiscal.findByOidProxy(db.getInteger(DBTalonario.OID_IMP_FISCAL),getSesion()));
    talonario.setImpresora_comun(ImpresoraComun.findByOidProxy(db.getInteger(DBTalonario.OID_IMP_COMUN),getSesion()));
    talonario.setTipo_comprobante(TipoComprobante.findByOidProxy(db.getInteger(DBTalonario.OID_TC),getSesion()));
    talonario.setLetra(db.getString(DBTalonario.LETRA));
    talonario.setLugar_emision(LugarEmision.findByOidProxy(db.getInteger(DBTalonario.OID_LUG_EMI),getSesion()));
    talonario.setNombre_archivo_impresion(db.getString(DBTalonario.NOM_ARCH_IMP));
    talonario.setPrimer_nro(db.getInteger(DBTalonario.PRIMER_NRO));
    talonario.setNro_actual(db.getInteger(DBTalonario.NRO_ACTUAL));
    talonario.setUltimo_nro(db.getInteger(DBTalonario.ULTIMO_NRO));
    talonario.setNro_automatica(db.getBoolean(DBTalonario.NRO_AUTOMATICA));
    talonario.setFec_vto(db.getDate(DBTalonario.FEC_VTO));
    talonario.setCai(db.getString(DBTalonario.CAI));
    talonario.setUnidad_organizativa(UnidadOrganizativa.findByOidProxy(db.getInteger(DBTalonario.OID_UNI_ORG),getSesion()));
    talonario.setOidTalonarioAnulacion(db.getInteger(DBTalonario.OID_TAL_ANU));
    talonario.setActivo(db.getBoolean(DBTalonario.ACTIVO));
    talonario.setCantCopias(db.getInteger(DBTalonario.CANT_COPIAS));
    talonario.setIntercalar(db.getBoolean(DBTalonario.INTERCALAR));
    talonario.setOrientacion(db.getString(DBTalonario.ORIENTACION));
    talonario.setGenerarArchivo(db.getBoolean(DBTalonario.GENERAR_ARCHIVO));
    talonario.setTipoArchivo(db.getString(DBTalonario.TIPO_ARCHIVO));
    talonario.setArchivoRTM(db.getString(DBTalonario.ARCHIVO_RTM));
    talonario.setIdentifArchGeneracionArchivo(db.getString(DBTalonario.IDENTIF_ARCH_GA));
    talonario.setIdentifArchImpresion(db.getString(DBTalonario.IDENTIF_ARCH_IM));
    talonario.setIdentifArchVistaPreliminar(db.getString(DBTalonario.IDENTIF_ARCH_VP));
    talonario.setCodigoLetra(db.getString(DBTalonario.CODIGO_LETRA));
    talonario.setComportamientoImpresion(db.getString(DBTalonario.COMPO_IMPRESION));
    talonario.setPathGeneracionArchImpresion(db.getString(DBTalonario.PATH_GEN_ARCH_IMPRESION));
    talonario.setTipoImpresion(db.getString(DBTalonario.TIPO_IMPRESION));
    talonario.setEsFactElec(db.getBoolean(DBTalonario.ES_FE));
    talonario.setCodigoTCFactEle(db.getInteger(DBTalonario.CODIGO_TC_FE));
  }
}
