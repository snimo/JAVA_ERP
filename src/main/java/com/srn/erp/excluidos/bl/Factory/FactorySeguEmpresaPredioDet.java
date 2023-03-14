package com.srn.erp.excluidos.bl.Factory;

import com.srn.erp.excluidos.bm.PredioExcluido;
import com.srn.erp.excluidos.bm.SeguEmpresaPredioDet;
import com.srn.erp.excluidos.bm.SeguridadEmpresaPredio;
import com.srn.erp.excluidos.da.DBSeguEmpresaPredioDet;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bm.Seguridad.PerfilFuncional;
import framework.request.bl.Utils.BaseException;

public class FactorySeguEmpresaPredioDet extends FactoryObjetoLogico { 

  public FactorySeguEmpresaPredioDet() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    SeguEmpresaPredioDet seguempresaprediodet = (SeguEmpresaPredioDet) objLog;
    seguempresaprediodet.setOID(db.getInteger(DBSeguEmpresaPredioDet.OID_SEG_EMP_PRE_D));
    seguempresaprediodet.setSegu_empresa_predio(SeguridadEmpresaPredio.findByOidProxy(db.getInteger(DBSeguEmpresaPredioDet.OID_SEG_EMP_PREDIO),getSesion()));
    seguempresaprediodet.setPredio(PredioExcluido.findByOidProxy(db.getInteger(DBSeguEmpresaPredioDet.OID_PREDIO_VISUALIZ),getSesion()));
    seguempresaprediodet.setPerfil_act(PerfilFuncional.findByOidProxy(db.getInteger(DBSeguEmpresaPredioDet.OID_PERFIL_ACT),getSesion()));
    seguempresaprediodet.setVis_dif_importes(db.getBoolean(DBSeguEmpresaPredioDet.VIS_DIF_IMPORTES));
    seguempresaprediodet.setVis_vehiculos(db.getBoolean(DBSeguEmpresaPredioDet.VIS_VEHICULOS));
    seguempresaprediodet.setVis_obs_generales(db.getBoolean(DBSeguEmpresaPredioDet.VIS_OBS_GENERALES));
    seguempresaprediodet.setVis_novedades(db.getBoolean(DBSeguEmpresaPredioDet.VIS_NOVEDADES));
    seguempresaprediodet.setVis_arch_adjuntos(db.getBoolean(DBSeguEmpresaPredioDet.VIS_ARCH_ADJUNTOS));
    seguempresaprediodet.setVis_pers_rel(db.getBoolean(DBSeguEmpresaPredioDet.VIS_PERS_REL));
    seguempresaprediodet.setPermitir_alta(db.getBoolean(DBSeguEmpresaPredioDet.PERMITIR_ALTA));
    seguempresaprediodet.setVer_nros_de_actas(db.getBoolean(DBSeguEmpresaPredioDet.VER_NROS_DE_ACTAS));
    seguempresaprediodet.setActivo(db.getBoolean(DBSeguEmpresaPredioDet.ACTIVO));

  }
}
