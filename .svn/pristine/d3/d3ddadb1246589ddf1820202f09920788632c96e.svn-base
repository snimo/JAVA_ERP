package com.srn.erp.ventas.bl.Factory;

import com.srn.erp.general.bm.LugarEmision;
import com.srn.erp.general.bm.Talonario;
import com.srn.erp.general.bm.TipoComprobante;
import com.srn.erp.general.da.DBComproCab;
import com.srn.erp.ventas.bm.CotizacionCab;
import com.srn.erp.ventas.bm.CotizacionCabAnulacion;
import com.srn.erp.ventas.da.DBCotizacionCabAnulacion;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bm.Seguridad.Usuario;
import framework.request.bl.Utils.BaseException;

public class FactoryCotizacionCabAnulacion extends FactoryObjetoLogico {

	public FactoryCotizacionCabAnulacion() {
	}

	public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
		
		CotizacionCabAnulacion cotizacioncabanulacion = (CotizacionCabAnulacion) objLog;
		cotizacioncabanulacion.setOID(db.getInteger(DBCotizacionCabAnulacion.OID));
		
    // Por comproCab
		cotizacioncabanulacion.setTipoCompro(TipoComprobante.findByOidProxy(db.getInteger(DBComproCab.OID_TC),getSesion()));
		cotizacioncabanulacion.setTalonario(Talonario.findByOidProxy(db.getInteger(DBComproCab.OID_TALONARIO),getSesion()));
		cotizacioncabanulacion.setTcExt(db.getString(DBComproCab.TC_EXT));
		cotizacioncabanulacion.setLetra(db.getString(DBComproCab.LETRA));
		cotizacioncabanulacion.setLugarEmision(LugarEmision.findByOidProxy(db.getInteger(DBComproCab.OID_LUG_EMI),getSesion()));
		cotizacioncabanulacion.setNrolugemision(db.getInteger(DBComproCab.LUG_EMI));
		cotizacioncabanulacion.setNroext(db.getInteger(DBComproCab.NROEXT));
		cotizacioncabanulacion.setEmision(db.getDate(DBComproCab.EMISION));
		cotizacioncabanulacion.setEstado(db.getString(DBComproCab.ESTADO));
		cotizacioncabanulacion.setComentario(db.getString(DBComproCab.COMENTARIO));
		cotizacioncabanulacion.setFecAlta(db.getDate(DBComproCab.FEC_ALTA));
		cotizacioncabanulacion.setUsuario(Usuario.findByOidProxy(db.getInteger(DBComproCab.OID_USUARIO),getSesion()));
		cotizacioncabanulacion.setActivo(db.getBoolean(DBComproCab.ACTIVO));    
		cotizacioncabanulacion.setImputac(db.getDate(DBComproCab.IMPUTAC));
		
		cotizacioncabanulacion.setCotizacion_cab((CotizacionCab) CotizacionCab.findByOidProxy(db
				.getInteger(DBCotizacionCabAnulacion.OID_COTIZACION_CAB), getSesion()));

	}
}
