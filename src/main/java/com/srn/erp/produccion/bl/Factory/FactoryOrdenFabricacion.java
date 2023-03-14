package com.srn.erp.produccion.bl.Factory;

import com.srn.erp.general.bm.LugarEmision;
import com.srn.erp.general.bm.Sucursal;
import com.srn.erp.general.bm.Talonario;
import com.srn.erp.general.bm.TipoComprobante;
import com.srn.erp.general.da.DBComproCab;
import com.srn.erp.produccion.bm.AlternativaFabricacion;
import com.srn.erp.produccion.bm.OrdenFabricacion;
import com.srn.erp.produccion.bm.Planta;
import com.srn.erp.produccion.da.DBOrdenFabricacion;
import com.srn.erp.stock.bm.Producto;
import com.srn.erp.stock.bm.UnidadMedida;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bm.Seguridad.Usuario;
import framework.request.bl.Utils.BaseException;

public class FactoryOrdenFabricacion extends FactoryObjetoLogico { 

  public FactoryOrdenFabricacion() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    OrdenFabricacion ordenfabricacion = (OrdenFabricacion) objLog;
    ordenfabricacion.setOID(db.getInteger(DBOrdenFabricacion.OID_ORDEN_FAB));
    
    // Por comproCab
    ordenfabricacion.setTalonario(Talonario.findByOidProxy(db.getInteger(DBComproCab.OID_TALONARIO),getSesion()));
    ordenfabricacion.setTipoCompro(TipoComprobante.findByOidProxy(db.getInteger(DBComproCab.OID_TC),getSesion()));
    ordenfabricacion.setTcExt(db.getString(DBComproCab.TC_EXT));
    ordenfabricacion.setLetra(db.getString(DBComproCab.LETRA));
    ordenfabricacion.setLugarEmision(LugarEmision.findByOidProxy(db.getInteger(DBComproCab.OID_LUG_EMI),getSesion()));
    ordenfabricacion.setNrolugemision(db.getInteger(DBComproCab.LUG_EMI));
    ordenfabricacion.setNroext(db.getInteger(DBComproCab.NROEXT));
    ordenfabricacion.setEmision(db.getDate(DBComproCab.EMISION));
    ordenfabricacion.setEstado(db.getString(DBComproCab.ESTADO));
    ordenfabricacion.setComentario(db.getString(DBComproCab.COMENTARIO));
    ordenfabricacion.setFecAlta(db.getDate(DBComproCab.FEC_ALTA));
    ordenfabricacion.setUsuario(Usuario.findByOidProxy(db.getInteger(DBComproCab.OID_USUARIO),getSesion()));
    ordenfabricacion.setActivo(db.getBoolean(DBComproCab.ACTIVO));
    ordenfabricacion.setSucursal(Sucursal.findByOidProxy(db.getInteger(DBComproCab.OID_SUCURSAL),getSesion()));
    ordenfabricacion.setComportamiento(db.getString(DBComproCab.COMPORTAMIENTO));
    
    
    ordenfabricacion.setProducto(Producto.findByOidProxy(db.getInteger(DBOrdenFabricacion.OID_PRODUCTO),getSesion()));
    ordenfabricacion.setCantidad(db.getDouble(DBOrdenFabricacion.CANTIDAD));
    ordenfabricacion.setUnidad_medida(UnidadMedida.findByOidProxy(db.getInteger(DBOrdenFabricacion.OID_UM),getSesion()));
    ordenfabricacion.setUsuario_aprobacion(Usuario.findByOidProxy(db.getInteger(DBOrdenFabricacion.OID_USU_APROB),getSesion()));
    ordenfabricacion.setFecha_aprobacion(db.getDate(DBOrdenFabricacion.FEC_APROB));
    ordenfabricacion.setFec_ini_est(db.getDate(DBOrdenFabricacion.FEC_INI_EST));
    ordenfabricacion.setFec_fin_est(db.getDate(DBOrdenFabricacion.FEC_FIN_EST));
    ordenfabricacion.setObs_ord_fab(db.getString(DBOrdenFabricacion.OBS_ORD_FAB));
    ordenfabricacion.setPlanta(Planta.findByOidProxy(db.getInteger(DBOrdenFabricacion.OID_PLANTA),getSesion()));
    ordenfabricacion.setAlternativa_fabricacion(AlternativaFabricacion.findByOidProxy(db.getInteger(DBOrdenFabricacion.OID_ALTER_FABRI),getSesion()));
    ordenfabricacion.setCant_producida(db.getDouble(DBOrdenFabricacion.CANT_PRODUCIDA));
    ordenfabricacion.setCerrada(db.getBoolean(DBOrdenFabricacion.CERRADA));
    ordenfabricacion.setPend_producir(db.getBoolean(DBOrdenFabricacion.PEND_PRODUCIR));
    ordenfabricacion.setEstado_aprobacion(db.getBoolean(DBOrdenFabricacion.ESTADO_APROBACION));
    ordenfabricacion.setTipoOrden(db.getString(DBOrdenFabricacion.TIPO_ORDEN));

  }
}
