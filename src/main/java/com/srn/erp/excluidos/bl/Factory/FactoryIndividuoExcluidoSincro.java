package com.srn.erp.excluidos.bl.Factory;

import com.srn.erp.excluidos.bm.IndividuoExcluidoSincro;
import com.srn.erp.excluidos.da.DBIndividuoExcluidoSincro;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryIndividuoExcluidoSincro extends FactoryObjetoLogico { 

  public FactoryIndividuoExcluidoSincro() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    IndividuoExcluidoSincro individuoexcluidosincro = (IndividuoExcluidoSincro) objLog;
    individuoexcluidosincro.setOID(db.getInteger(DBIndividuoExcluidoSincro.OID_SINCRO_EXC));
    individuoexcluidosincro.setNro_lote(db.getInteger(DBIndividuoExcluidoSincro.NRO_LOTE));
    individuoexcluidosincro.setId_cliente(db.getString(DBIndividuoExcluidoSincro.ID_CLIENTE));
    individuoexcluidosincro.setEstado_nro(db.getString(DBIndividuoExcluidoSincro.ESTADO_NRO));
    individuoexcluidosincro.setMotivo(db.getString(DBIndividuoExcluidoSincro.MOTIVO));
    individuoexcluidosincro.setColor_estado(db.getString(DBIndividuoExcluidoSincro.COLOR_ESTADO));
    individuoexcluidosincro.setObs_principal(db.getString(DBIndividuoExcluidoSincro.OBS_PRINCIPAL));
    individuoexcluidosincro.setPeriodo(db.getString(DBIndividuoExcluidoSincro.PERIODO));
    individuoexcluidosincro.setNro_documento(db.getString(DBIndividuoExcluidoSincro.NRO_DOCUMENTO));
    individuoexcluidosincro.setTipo_documento(db.getString(DBIndividuoExcluidoSincro.TIPO_DOCUMENTO));
    individuoexcluidosincro.setApe_y_nom(db.getString(DBIndividuoExcluidoSincro.APE_Y_NOM));
    individuoexcluidosincro.setFoto1(db.getString(DBIndividuoExcluidoSincro.FOTO1));
    individuoexcluidosincro.setFoto2(db.getString(DBIndividuoExcluidoSincro.FOTO2));
    individuoexcluidosincro.setFoto3(db.getString(DBIndividuoExcluidoSincro.FOTO3));
    individuoexcluidosincro.setId_estado(db.getString(DBIndividuoExcluidoSincro.ID_ESTADO));
    individuoexcluidosincro.setId_peligrosidad(db.getString(DBIndividuoExcluidoSincro.ID_PELIGROSIDAD));
    individuoexcluidosincro.setColor_peligrosidad(db.getString(DBIndividuoExcluidoSincro.COLOR_PELIGROSIDAD));
    individuoexcluidosincro.setId_raza(db.getString(DBIndividuoExcluidoSincro.ID_RAZA));
    individuoexcluidosincro.setId_altura(db.getString(DBIndividuoExcluidoSincro.ID_ALTURA));
    individuoexcluidosincro.setId_complexion(db.getString(DBIndividuoExcluidoSincro.ID_COMPLEXION));
    individuoexcluidosincro.setId_edad(db.getString(DBIndividuoExcluidoSincro.ID_EDAD));
    individuoexcluidosincro.setId_color_cabello(db.getString(DBIndividuoExcluidoSincro.ID_COLOR_CABELLO));
    individuoexcluidosincro.setId_sexo(db.getString(DBIndividuoExcluidoSincro.ID_SEXO));
    individuoexcluidosincro.setNro_orden_1(db.getString(DBIndividuoExcluidoSincro.NRO_ORDEN_1));
    individuoexcluidosincro.setNro_orden_2(db.getString(DBIndividuoExcluidoSincro.NRO_ORDEN_2));
    individuoexcluidosincro.setNro_version_foto_1(db.getString(DBIndividuoExcluidoSincro.NRO_VERSION_FOTO_1));
    individuoexcluidosincro.setNro_version_foto_2(db.getString(DBIndividuoExcluidoSincro.NRO_VERSION_FOTO_2));
    individuoexcluidosincro.setNro_version_foto_3(db.getString(DBIndividuoExcluidoSincro.NRO_VERSION_FOTO_3));
    individuoexcluidosincro.setActivo(db.getBoolean(DBIndividuoExcluidoSincro.ACTIVO));

  }
}
