package com.srn.erp.ventas.bl.Factory;

import com.srn.erp.general.bm.LugarEmision;
import com.srn.erp.general.bm.Talonario;
import com.srn.erp.general.bm.TipoComprobante;
import com.srn.erp.general.da.DBComproCab;
import com.srn.erp.ventas.bm.RemitoCab;
import com.srn.erp.ventas.bm.RemitoCabAnulacion;
import com.srn.erp.ventas.da.DBRemitoCabAnulacion;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bm.Seguridad.Usuario;
import framework.request.bl.Utils.BaseException;

public class FactoryRemitoCabAnulacion extends FactoryObjetoLogico {

	public FactoryRemitoCabAnulacion() {
	}

	public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
		RemitoCabAnulacion remitocabanulacion = (RemitoCabAnulacion) objLog;
		remitocabanulacion.setOID(db.getInteger(DBRemitoCabAnulacion.OID));
		
    // Por comproCab
		remitocabanulacion.setTipoCompro(TipoComprobante.findByOidProxy(db.getInteger(DBComproCab.OID_TC),getSesion()));
		remitocabanulacion.setTalonario(Talonario.findByOidProxy(db.getInteger(DBComproCab.OID_TALONARIO),getSesion()));
		remitocabanulacion.setTcExt(db.getString(DBComproCab.TC_EXT));
		remitocabanulacion.setLetra(db.getString(DBComproCab.LETRA));
		remitocabanulacion.setLugarEmision(LugarEmision.findByOidProxy(db.getInteger(DBComproCab.OID_LUG_EMI),getSesion()));
		remitocabanulacion.setNrolugemision(db.getInteger(DBComproCab.LUG_EMI));
		remitocabanulacion.setNroext(db.getInteger(DBComproCab.NROEXT));
		remitocabanulacion.setEmision(db.getDate(DBComproCab.EMISION));
		remitocabanulacion.setEstado(db.getString(DBComproCab.ESTADO));
		remitocabanulacion.setComentario(db.getString(DBComproCab.COMENTARIO));
		remitocabanulacion.setFecAlta(db.getDate(DBComproCab.FEC_ALTA));
		remitocabanulacion.setUsuario(Usuario.findByOidProxy(db.getInteger(DBComproCab.OID_USUARIO),getSesion()));
		remitocabanulacion.setActivo(db.getBoolean(DBComproCab.ACTIVO));    
		remitocabanulacion.setImputac(db.getDate(DBComproCab.IMPUTAC));
		
		remitocabanulacion.setRemito_cab((RemitoCab) RemitoCab.findByOidProxy(db
				.getInteger(DBRemitoCabAnulacion.OID_REMITO_CAB), getSesion()));

	}
}
