package com.srn.erp.compras.bl.Factory;

import com.srn.erp.compras.bm.ConsultaEstadoRequisiciones;
import com.srn.erp.compras.bm.SectorCompra;
import com.srn.erp.compras.da.DBConsultaEstadoRequisiciones;
import com.srn.erp.general.bm.LugarEmision;
import com.srn.erp.general.bm.Sucursal;
import com.srn.erp.general.bm.Talonario;
import com.srn.erp.general.bm.TipoComprobante;
import com.srn.erp.stock.bm.Producto;
import com.srn.erp.stock.bm.UnidadMedida;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bm.Seguridad.Usuario;
import framework.request.bl.Utils.BaseException;

public class FactoryConsultaEstadoRequisiciones extends FactoryObjetoLogico { 

  public FactoryConsultaEstadoRequisiciones() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    ConsultaEstadoRequisiciones consultaestadorequisiciones = (ConsultaEstadoRequisiciones) objLog;
    consultaestadorequisiciones.setOID(db.getInteger(DBConsultaEstadoRequisiciones.OID_CCO));
    consultaestadorequisiciones.setTipo_comprobante(TipoComprobante.findByOidProxy(db.getInteger(DBConsultaEstadoRequisiciones.OID_TC),getSesion()));
    consultaestadorequisiciones.setTc_ext(db.getString(DBConsultaEstadoRequisiciones.TC_EXT));
    consultaestadorequisiciones.setLetra(db.getString(DBConsultaEstadoRequisiciones.LETRA));
    consultaestadorequisiciones.setLugar_emi(LugarEmision.findByOidProxy(db.getInteger(DBConsultaEstadoRequisiciones.OID_LUG_EMI),getSesion()));
    consultaestadorequisiciones.setNro_lugar_emi(db.getInteger(DBConsultaEstadoRequisiciones.LUG_EMI));
    consultaestadorequisiciones.setNroExt(db.getInteger(DBConsultaEstadoRequisiciones.NRO_EXT));
    consultaestadorequisiciones.setComen_requi(db.getString(DBConsultaEstadoRequisiciones.COMENTARIO_REQUI));
    consultaestadorequisiciones.setUsuario(Usuario.findByOidProxy(db.getInteger(DBConsultaEstadoRequisiciones.OID_USUARIO),getSesion()));
    consultaestadorequisiciones.setTalonario(Talonario.findByOidProxy(db.getInteger(DBConsultaEstadoRequisiciones.OID_TALONARIO),getSesion()));
    consultaestadorequisiciones.setSucursal(Sucursal.findByOidProxy(db.getInteger(DBConsultaEstadoRequisiciones.OID_SUCURSAL),getSesion()));
    consultaestadorequisiciones.setOid_req_det(db.getInteger(DBConsultaEstadoRequisiciones.OID_REQ_DET));
    consultaestadorequisiciones.setProducto(Producto.findByOidProxy(db.getInteger(DBConsultaEstadoRequisiciones.OID_PRODUCTO),getSesion()));
    consultaestadorequisiciones.setSectorCompra(SectorCompra.findByOidProxy(db.getInteger(DBConsultaEstadoRequisiciones.OID_SECTOR_COMPRA),getSesion()));
    consultaestadorequisiciones.setCod_producto(db.getString(DBConsultaEstadoRequisiciones.COD_PRODUCTO));
    consultaestadorequisiciones.setDesc_producto(db.getString(DBConsultaEstadoRequisiciones.DESC_PRODUCTO));
    consultaestadorequisiciones.setDesc_adic_sku(db.getString(DBConsultaEstadoRequisiciones.DESC_ADIC_SKU));
    consultaestadorequisiciones.setNro_renglon(db.getInteger(DBConsultaEstadoRequisiciones.NRO_RENGLON));
    consultaestadorequisiciones.setCant_solictada(db.getDouble(DBConsultaEstadoRequisiciones.CANT_SOLICITADA));
    consultaestadorequisiciones.setCant_comprada(db.getDouble(DBConsultaEstadoRequisiciones.CANT_COMPRADA));
    consultaestadorequisiciones.setUnidad_medida(UnidadMedida.findByOidProxy(db.getInteger(DBConsultaEstadoRequisiciones.OID_UM_REQ),getSesion()));
    consultaestadorequisiciones.setFec_emision(db.getDate(DBConsultaEstadoRequisiciones.FEC_EMISION));
    consultaestadorequisiciones.setFec_requerida(db.getDate(DBConsultaEstadoRequisiciones.FEC_REQUERIDA));
    consultaestadorequisiciones.setDecision_autoriz(db.getInteger(DBConsultaEstadoRequisiciones.DECISION_AUTORIZ));
    consultaestadorequisiciones.setAnulada(db.getBoolean(DBConsultaEstadoRequisiciones.ANULADA));
    consultaestadorequisiciones.setSolo_cotizar(db.getBoolean(DBConsultaEstadoRequisiciones.SOLO_COTIZAR));
    consultaestadorequisiciones.setComen_detalle(db.getString(DBConsultaEstadoRequisiciones.COMENTARIO_DET));
    consultaestadorequisiciones.setPend_sol_cotiz(db.getBoolean(DBConsultaEstadoRequisiciones.PEND_SOL_COTIZ));
    consultaestadorequisiciones.setPendCompra(db.getBoolean(DBConsultaEstadoRequisiciones.PEND_COMPRA));
  }
}
