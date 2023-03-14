package com.srn.erp.ctasAPagar.bl.Factory;

import com.srn.erp.ctasAPagar.bm.AutorizacionFactProv;
import com.srn.erp.ctasAPagar.bm.ComproProvAAutorizar;
import com.srn.erp.ctasAPagar.bm.ComproProveedor;
import com.srn.erp.ctasAPagar.bm.TranProv;
import com.srn.erp.ctasAPagar.bm.TranProvVto;
import com.srn.erp.ctasAPagar.da.DBComproProvAAutorizar;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bm.Seguridad.Usuario;
import framework.request.bl.Utils.BaseException;

public class FactoryComproProvAAutorizar extends FactoryObjetoLogico {

  public FactoryComproProvAAutorizar() {
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    ComproProvAAutorizar comproProvAAutorizar = (ComproProvAAutorizar) objLog;
    comproProvAAutorizar.setOID(db.getInteger(DBComproProvAAutorizar.OID_TRAN_VTO));
    comproProvAAutorizar.setComprobante(ComproProveedor.findByOidProxy(db.getInteger(DBComproProvAAutorizar.OID_CCO),getSesion()));
    comproProvAAutorizar.setTcext(db.getString(DBComproProvAAutorizar.TC_EXT));
    comproProvAAutorizar.setLetra(db.getString(DBComproProvAAutorizar.LETRA));
    comproProvAAutorizar.setLugemi(db.getInteger(DBComproProvAAutorizar.LUG_EMI));
    comproProvAAutorizar.setNroext(db.getInteger(DBComproProvAAutorizar.NRO_EXT));
    comproProvAAutorizar.setEmision(db.getDate(DBComproProvAAutorizar.EMISION));
    comproProvAAutorizar.setImputac(db.getDate(DBComproProvAAutorizar.IMPUTAC));
    comproProvAAutorizar.setMoneda(db.getString(DBComproProvAAutorizar.MONEDA));
    comproProvAAutorizar.setVto(db.getDate(DBComproProvAAutorizar.VTO));
    comproProvAAutorizar.setTranprov(TranProv.findByOidProxy(db.getInteger(DBComproProvAAutorizar.OID_TRAN_PROV),getSesion()));
    comproProvAAutorizar.setTranprovVto(TranProvVto.findByOidProxy(db.getInteger(DBComproProvAAutorizar.OID_TRAN_VTO),getSesion()));
    comproProvAAutorizar.setImporte(db.getMoney(DBComproProvAAutorizar.IMPORTE));
    comproProvAAutorizar.setSaldo(db.getMoney(DBComproProvAAutorizar.SALDO));
    comproProvAAutorizar.setImportecuota(db.getMoney(DBComproProvAAutorizar.IMPORTECUOTA));
    comproProvAAutorizar.setSaldocuota(db.getMoney(DBComproProvAAutorizar.SALDOCUOTA));
    comproProvAAutorizar.setAutorizfactprov(AutorizacionFactProv.findByOidProxy(db.getInteger(DBComproProvAAutorizar.OID_AUTORIZ_FACT),getSesion()));
    comproProvAAutorizar.setPorcautoriz(db.getMoney(DBComproProvAAutorizar.PORC_AUTORIZ));
    comproProvAAutorizar.setMontoAutorizado(db.getMoney(DBComproProvAAutorizar.MONTO_AUTORIZ));
    comproProvAAutorizar.setUsuario(Usuario.findByOidProxy(db.getInteger(DBComproProvAAutorizar.OID_USUARIO),getSesion()));
    comproProvAAutorizar.setApellido(db.getString(DBComproProvAAutorizar.APELLIDO));
    comproProvAAutorizar.setNombre(db.getString(DBComproProvAAutorizar.NOMBRE));
    comproProvAAutorizar.setFecautoriz(db.getDate(DBComproProvAAutorizar.FEC_AUTORIZ));
    comproProvAAutorizar.setMoneda(db.getString(DBComproProvAAutorizar.MONEDA));
    comproProvAAutorizar.setCodigoProveedor(db.getString(DBComproProvAAutorizar.COD_PROVEEDOR));
    comproProvAAutorizar.setRSProveedor(db.getString(DBComproProvAAutorizar.RS_PROVEEDOR));
    comproProvAAutorizar.setEstado(db.getInteger(DBComproProvAAutorizar.ESTADO));
  }
}
