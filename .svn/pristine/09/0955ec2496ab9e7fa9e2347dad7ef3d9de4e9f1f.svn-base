package com.srn.erp.conciTarjeta.bl.Factory;

import com.srn.erp.conciTarjeta.bm.ArchLoteConciCab;
import com.srn.erp.conciTarjeta.bm.ArchLoteConciDet;
import com.srn.erp.conciTarjeta.bm.CabAsiLiquiTarj;
import com.srn.erp.conciTarjeta.bm.CabAsiTarjACobrar;
import com.srn.erp.conciTarjeta.bm.CabConciAutomatica;
import com.srn.erp.conciTarjeta.bm.EmpresaConciTar;
import com.srn.erp.conciTarjeta.bm.TarjetaConciTar;
import com.srn.erp.conciTarjeta.bm.UniNegConciTar;
import com.srn.erp.conciTarjeta.da.DBArchLoteConciDet;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bm.Seguridad.Usuario;
import framework.request.bl.Utils.BaseException;

public class FactoryArchLoteConciDet extends FactoryObjetoLogico { 

  public FactoryArchLoteConciDet() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    ArchLoteConciDet archloteconcidet = (ArchLoteConciDet) objLog;
    archloteconcidet.setOID(db.getInteger(DBArchLoteConciDet.OID_ARCH_LOT_DET));
    archloteconcidet.setArch_lot_cab(ArchLoteConciCab.findByOidProxy(db.getInteger(DBArchLoteConciDet.OID_ARCH_LOT_CAB),getSesion()));
    archloteconcidet.setModo_transmision(db.getString(DBArchLoteConciDet.MODO_TRANSMISION));
    archloteconcidet.setTipo_operacion(db.getString(DBArchLoteConciDet.TIPO_OPERACION));
    archloteconcidet.setFecha_oper(db.getString(DBArchLoteConciDet.FECHA_OPER));
    archloteconcidet.setHora_oper(db.getString(DBArchLoteConciDet.HORA_OPER));
    archloteconcidet.setTipo_tarjeta(db.getString(DBArchLoteConciDet.TIPO_TARJETA));
    archloteconcidet.setTarjeta(db.getString(DBArchLoteConciDet.TARJETA));
    archloteconcidet.setNro_tarjeta(db.getString(DBArchLoteConciDet.NRO_TARJETA));
    archloteconcidet.setBanda_manual(db.getString(DBArchLoteConciDet.BANDA_MANUAL));
    archloteconcidet.setCod_autoriz(db.getString(DBArchLoteConciDet.COD_AUTORIZ));
    archloteconcidet.setTicket(db.getString(DBArchLoteConciDet.TICKET));
    archloteconcidet.setMoneda(db.getString(DBArchLoteConciDet.MONEDA));
    archloteconcidet.setMonto(db.getDouble(DBArchLoteConciDet.MONTO));
    archloteconcidet.setTipo_cta_deb(db.getString(DBArchLoteConciDet.TIPO_CTA_DEB));
    archloteconcidet.setPlan_y_cuota(db.getString(DBArchLoteConciDet.PLAN_Y_CUOTA));
    archloteconcidet.setCod_comercio(db.getString(DBArchLoteConciDet.COD_COMERCIO));
    archloteconcidet.setNro_terminal(db.getString(DBArchLoteConciDet.NRO_TERMINAL));
    archloteconcidet.setTicket_sec(db.getString(DBArchLoteConciDet.TICKET_SEC));
    archloteconcidet.setCodigo_lista(db.getString(DBArchLoteConciDet.CODIGO_LISTA));
    archloteconcidet.setMonto_sec(db.getDouble(DBArchLoteConciDet.MONTO_SEC));
    archloteconcidet.setFecha_sec(db.getString(DBArchLoteConciDet.FECHA_SEC));
    archloteconcidet.setFactura(db.getString(DBArchLoteConciDet.FACTURA));
    archloteconcidet.setNro_host(db.getString(DBArchLoteConciDet.NRO_HOST));
    archloteconcidet.setNro_lote(db.getInteger(DBArchLoteConciDet.NRO_LOTE));
    archloteconcidet.setActivo(db.getBoolean(DBArchLoteConciDet.ACTIVO));
    archloteconcidet.setPresentado(db.getBoolean(DBArchLoteConciDet.PRESENTADO));
    archloteconcidet.setEmpresa(EmpresaConciTar.findByOidProxy(db.getInteger(DBArchLoteConciDet.OID_EMPRESA),getSesion()));
    archloteconcidet.setUnidad_negocio(UniNegConciTar.findByOidProxy(db.getInteger(DBArchLoteConciDet.OID_UNI_NEG),getSesion()));
    archloteconcidet.setFecOperDate(db.getDate(DBArchLoteConciDet.FEC_OPER_DATE));
    archloteconcidet.setFecCierre(db.getDate(DBArchLoteConciDet.FEC_CIERRE));
    
    archloteconcidet.setFecPresenCupo(db.getDate(DBArchLoteConciDet.FEC_PRESEN_CUPO));
    archloteconcidet.setConciliado(db.getBoolean(DBArchLoteConciDet.CONCILIADO));
    archloteconcidet.setFecConciliado(db.getDate(DBArchLoteConciDet.FEC_CONCI));
    archloteconcidet.setLiquidado(db.getBoolean(DBArchLoteConciDet.LIQUIDADO));
    archloteconcidet.setFecLiquidado(db.getDate(DBArchLoteConciDet.FEC_LIQUI));
    archloteconcidet.setPreContabilizado(db.getBoolean(DBArchLoteConciDet.PRE_CONTABILIZADO));
    archloteconcidet.setFecPreContabilizado(db.getDate(DBArchLoteConciDet.FEC_PRECONTA));
    archloteconcidet.setContabilizado(db.getBoolean(DBArchLoteConciDet.CONTABILIZADO));
    archloteconcidet.setFecContabilizado(db.getDate(DBArchLoteConciDet.FEC_CONTABILIZADO));
    archloteconcidet.setTarjetaConciliacion(TarjetaConciTar.findByOidProxy(db.getInteger(DBArchLoteConciDet.OID_TAR_CONCI), this.getSesion()));
    archloteconcidet.setUltimosNrosTarjeta(db.getInteger(DBArchLoteConciDet.NRO_TAR_ULT_NROS));
    archloteconcidet.setNroConciliacion(db.getInteger(DBArchLoteConciDet.NRO_CONCILIACION));
    archloteconcidet.setMarcarPreconci(db.getBoolean(DBArchLoteConciDet.MARCAR_PRECONCI));
    archloteconcidet.setPreconci(db.getBoolean(DBArchLoteConciDet.PRECONCI));
    archloteconcidet.setUsuarioMarcaPreconci(Usuario.findByOidProxy(db.getInteger(DBArchLoteConciDet.OID_USU_MAR_PRE), this.getSesion()));
    archloteconcidet.setFecPreconci(db.getDate(DBArchLoteConciDet.FEC_PRECONCI));
    archloteconcidet.setCabConciAut(CabConciAutomatica.findByOidProxy(db.getInteger(DBArchLoteConciDet.OID_CAB_CONCI_AUT), this.getSesion()));
    archloteconcidet.setPreconciDudoso(db.getBoolean(DBArchLoteConciDet.PRECONCI_DUDOSO));
    archloteconcidet.setAltaManual(db.getBoolean(DBArchLoteConciDet.ALTA_MANUAL));
    archloteconcidet.setUsuarioPreconci(Usuario.findByOidProxy(db.getInteger(DBArchLoteConciDet.OID_USU_PRECONCI), this.getSesion()));    
    archloteconcidet.setAsientoACobrar(CabAsiTarjACobrar.findByOidProxy(db.getInteger(DBArchLoteConciDet.OID_CAB_ASI_ACOB), this.getSesion()));
    archloteconcidet.setContaAsiACobrar(db.getBoolean(DBArchLoteConciDet.ASI_ACOB_CONTA));
    archloteconcidet.setTarjetaOri(db.getString(DBArchLoteConciDet.TARJETA_ORI));
    archloteconcidet.setMarcaAsiACobrar(db.getBoolean(DBArchLoteConciDet.MARCA_ASI_ACOB));
    archloteconcidet.setCuponPerdido(db.getBoolean(DBArchLoteConciDet.CUPON_PERDIDO));
    archloteconcidet.setCabAsiLiquiTarj(CabAsiLiquiTarj.findByOidProxy(db.getInteger(DBArchLoteConciDet.OID_CAB_ASI_LIQ), this.getSesion()));
    archloteconcidet.setMarcaAsiLiq(db.getBoolean(DBArchLoteConciDet.MARCA_ASI_LIQ));
    archloteconcidet.setNroLiquidacion(db.getInteger(DBArchLoteConciDet.NRO_LIQUIDACION));
    archloteconcidet.setContaAsiLiq(db.getBoolean(DBArchLoteConciDet.CONTA_ASI_LIQ));
    archloteconcidet.setRefSistExt(db.getString(DBArchLoteConciDet.REF_SIST_EXT));
    archloteconcidet.setRefSistExt1(db.getString(DBArchLoteConciDet.REF_SIST_EXT_1));
  }
}
