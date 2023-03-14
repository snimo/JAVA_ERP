package com.srn.erp.pagos.bl.Factory;

import com.srn.erp.general.bm.ComproCab;
import com.srn.erp.pagos.bm.DtoComproEnOP;
import com.srn.erp.pagos.da.DBDtoComproEnOP;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryDtoComproEnOP extends FactoryObjetoLogico {

  public FactoryDtoComproEnOP() {
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    DtoComproEnOP dtocomproenop = (DtoComproEnOP) objLog;
    dtocomproenop.setOID(db.getInteger(DBDtoComproEnOP.OID_DTO_CPRO_PROV));
    dtocomproenop.setComproprov(ComproCab.findByOidCompro(db.getInteger(DBDtoComproEnOP.OID_CCO_PROV),getSesion()));
    dtocomproenop.setDtomonori(db.getMoney(DBDtoComproEnOP.DTO_MON_ORI));
    dtocomproenop.setDtomonloc(db.getMoney(DBDtoComproEnOP.DTO_MON_LOC));
    dtocomproenop.setFecha(db.getDate(DBDtoComproEnOP.FECHA));
    dtocomproenop.setComproop(ComproCab.findByOidCompro(db.getInteger(DBDtoComproEnOP.OID_CCO_OP),getSesion()));
    dtocomproenop.setActivo(db.getBoolean(DBDtoComproEnOP.ACTIVO));

  }
}
