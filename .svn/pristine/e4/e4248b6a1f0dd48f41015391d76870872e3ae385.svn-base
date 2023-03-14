package com.srn.erp.contabilidad.bl.Factory;

import java.util.Date;
import java.util.Iterator;

import com.srn.erp.contabilidad.bm.Atributo;
import com.srn.erp.contabilidad.bm.CompoAtributo;
import com.srn.erp.contabilidad.bm.ValorCompo;
import com.srn.erp.contabilidad.da.DBValorCompo;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Utils.Fecha;
import framework.request.bl.Utils.BaseException;

public class FactoryValorCompo extends FactoryObjetoLogico {

  public FactoryValorCompo() {
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {

    ValorCompo valorCompo = (ValorCompo) objLog;
    valorCompo.setComponente(((DBValorCompo)db).getComponente());

    valorCompo.setOID(db.getInteger(DBValorCompo.OID_COMPO));
    valorCompo.setCodigo(db.getString(DBValorCompo.CODIGO));
    valorCompo.setDescripcion(db.getString(DBValorCompo.DESCRIPCION));
    valorCompo.setActivo(db.getBoolean(DBValorCompo.ACTIVO));



    Iterator iterCompoAtri =
        valorCompo.getComponente().getCompoAtributos().iterator();
    while (iterCompoAtri.hasNext()) {
      CompoAtributo compoAtributo = (CompoAtributo) iterCompoAtri.next();

      if (compoAtributo.getAtributo().getCompo()!=null) {
        ValorCompo valorCompoAtri = ValorCompo.findByOid(
          compoAtributo.getAtributo().getCompo(),
          db.getInteger(compoAtributo.getAtributo().getCampoFisico()),
          getSesion());
          valorCompo.addAtributo(compoAtributo.getAtributo().getCampoFisico(),valorCompoAtri);
      }
      else
        if (compoAtributo.getAtributo().getTipo().equals(Atributo.TIPO_ENTERO)) {
          Integer atrInteger =  db.getInteger(compoAtributo.getAtributo().
                                               getCampoFisico());
          if (atrInteger==null) atrInteger = new Integer(0);
          valorCompo.addAtributo(compoAtributo.getAtributo().getCampoFisico(),
                                 atrInteger);
        }
      else
        if (compoAtributo.getAtributo().getTipo().equals(Atributo.TIPO_DECIMAL))
          valorCompo.addAtributo(compoAtributo.getAtributo().getCampoFisico(),
                                  db.getDouble(compoAtributo.getAtributo().getCampoFisico()));
      else
      if (compoAtributo.getAtributo().getTipo().equals(Atributo.TIPO_FECHA)) {
        Date fecha = db.getDate(compoAtributo.getAtributo().getCampoFisico());
        if (fecha == null)
            valorCompo.addAtributo(compoAtributo.getAtributo().getCampoFisico(),
                                 Fecha.getFechaActual());
          else
            valorCompo.addAtributo(compoAtributo.getAtributo().getCampoFisico(),
                                  fecha);
      }
      else
      if (compoAtributo.getAtributo().getTipo().equals(Atributo.TIPO_STRING)) {
        String atriString = db.getString(compoAtributo.getAtributo().getCampoFisico());
        if (atriString==null) atriString = "";
        valorCompo.addAtributo(compoAtributo.getAtributo().getCampoFisico(),
                               atriString);
      }
    }
  }
}
