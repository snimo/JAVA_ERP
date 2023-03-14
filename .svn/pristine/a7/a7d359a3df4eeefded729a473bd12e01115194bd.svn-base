package com.srn.erp.ventas.bl.Factory;

import com.srn.erp.general.bm.LugarEmision;
import com.srn.erp.general.bm.Talonario;
import com.srn.erp.general.bm.TipoComprobante;
import com.srn.erp.general.da.DBComproCab;
import com.srn.erp.ventas.bm.PedidoCab;
import com.srn.erp.ventas.bm.PedidoCabAnulacion;
import com.srn.erp.ventas.da.DBPedidoCabAnulacion;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bm.Seguridad.Usuario;
import framework.request.bl.Utils.BaseException;

public class FactoryPedidoCabAnulacion extends FactoryObjetoLogico {

	public FactoryPedidoCabAnulacion() {
	}

	public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
		
		PedidoCabAnulacion pedidocabanulacion = (PedidoCabAnulacion) objLog;
		pedidocabanulacion.setOID(db.getInteger(DBPedidoCabAnulacion.OID));
		
    // Por comproCab
		pedidocabanulacion.setTipoCompro(TipoComprobante.findByOidProxy(db.getInteger(DBComproCab.OID_TC),getSesion()));
		pedidocabanulacion.setTalonario(Talonario.findByOidProxy(db.getInteger(DBComproCab.OID_TALONARIO),getSesion()));
		pedidocabanulacion.setTcExt(db.getString(DBComproCab.TC_EXT));
		pedidocabanulacion.setLetra(db.getString(DBComproCab.LETRA));
		pedidocabanulacion.setLugarEmision(LugarEmision.findByOidProxy(db.getInteger(DBComproCab.OID_LUG_EMI),getSesion()));
		pedidocabanulacion.setNrolugemision(db.getInteger(DBComproCab.LUG_EMI));
		pedidocabanulacion.setNroext(db.getInteger(DBComproCab.NROEXT));
		pedidocabanulacion.setEmision(db.getDate(DBComproCab.EMISION));
		pedidocabanulacion.setEstado(db.getString(DBComproCab.ESTADO));
		pedidocabanulacion.setComentario(db.getString(DBComproCab.COMENTARIO));
		pedidocabanulacion.setFecAlta(db.getDate(DBComproCab.FEC_ALTA));
		pedidocabanulacion.setUsuario(Usuario.findByOidProxy(db.getInteger(DBComproCab.OID_USUARIO),getSesion()));
		pedidocabanulacion.setActivo(db.getBoolean(DBComproCab.ACTIVO));    
		pedidocabanulacion.setImputac(db.getDate(DBComproCab.IMPUTAC));
		
		pedidocabanulacion.setPedido_cab((PedidoCab) PedidoCab.findByOidProxy(db
				.getInteger(DBPedidoCabAnulacion.OID_PEDIDO_CAB), getSesion()));

	}
}
