package com.srn.erp.ventas.bl.Factory;

import com.srn.erp.compras.bm.Proveedor;
import com.srn.erp.general.bm.LugarEmision;
import com.srn.erp.general.bm.Pais;
import com.srn.erp.general.bm.Provincia;
import com.srn.erp.general.bm.Talonario;
import com.srn.erp.general.bm.TipoComprobante;
import com.srn.erp.general.bm.UnidadOrganizativa;
import com.srn.erp.general.da.DBComproCab;
import com.srn.erp.stock.bm.Deposito;
import com.srn.erp.stock.bm.TipoConfMovStkTalonario;
import com.srn.erp.ventas.bm.CompoStkTalonarioRto;
import com.srn.erp.ventas.bm.RemitoCab;
import com.srn.erp.ventas.bm.Sujeto;
import com.srn.erp.ventas.bm.UnidadEdilicia;
import com.srn.erp.ventas.da.DBRemitoCab;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bm.Seguridad.Usuario;
import framework.request.bl.Utils.BaseException;

public class FactoryRemitoCab extends FactoryObjetoLogico {

	public FactoryRemitoCab() {
	}

	public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
		RemitoCab remitocab = (RemitoCab) objLog;
		remitocab.setOID(db.getInteger(DBRemitoCab.OID_REMITO_CAB));

		// Por comproCab
		remitocab.setTipoCompro(TipoComprobante.findByOidProxy(db.getInteger(DBComproCab.OID_TC), getSesion()));
		remitocab.setTalonario(Talonario.findByOidProxy(db.getInteger(DBComproCab.OID_TALONARIO), getSesion()));
		remitocab.setTcExt(db.getString(DBComproCab.TC_EXT));
		remitocab.setLetra(db.getString(DBComproCab.LETRA));
		remitocab.setLugarEmision(LugarEmision.findByOidProxy(db.getInteger(DBComproCab.OID_LUG_EMI), getSesion()));
		remitocab.setNrolugemision(db.getInteger(DBComproCab.LUG_EMI));
		remitocab.setNroext(db.getInteger(DBComproCab.NROEXT));
		remitocab.setEmision(db.getDate(DBComproCab.EMISION));
		remitocab.setEstado(db.getString(DBComproCab.ESTADO));
		remitocab.setComentario(db.getString(DBComproCab.COMENTARIO));
		remitocab.setFecAlta(db.getDate(DBComproCab.FEC_ALTA));
		remitocab.setUsuario(Usuario.findByOidProxy(db.getInteger(DBComproCab.OID_USUARIO), getSesion()));
		remitocab.setActivo(db.getBoolean(DBComproCab.ACTIVO));
		
		remitocab.setTipoRemito(db.getString(DBRemitoCab.TIPO_REMITO));
		remitocab.setComportamientoRto(db.getString(DBRemitoCab.COMPO_RTO));
		remitocab.setSujeto(Sujeto.findByOidProxy(db.getInteger(DBRemitoCab.OID_SUJETO), getSesion()));
		remitocab.setDestinatario(db.getString(DBRemitoCab.DESTINATARIO));
		remitocab.setDestino(db.getString(DBRemitoCab.DESTINO));
		remitocab.setDepo_destino(Deposito.findByOidProxy(db.getInteger(DBRemitoCab.OID_DEPO_DEST), getSesion()));
		remitocab.setUni_edi_dest(UnidadEdilicia.findByOidProxy(db.getInteger(DBRemitoCab.OID_UNI_EDI_DEST), getSesion()));
		remitocab.setUni_org_dest(UnidadOrganizativa.findByOidProxy(db.getInteger(DBRemitoCab.OID_UNI_ORG_DEST),
				getSesion()));
		remitocab.setPend_fact(db.getBoolean(DBRemitoCab.PEND_FACT));
		remitocab.setCalle_y_nro(db.getString(DBRemitoCab.CALLE_Y_NRO));
		remitocab.setLocalidad(db.getString(DBRemitoCab.LOCALIDAD));
		remitocab.setCodigo_postal(db.getString(DBRemitoCab.CODIGO_POSTAL));
		remitocab.setProvincia(Provincia.findByOidProxy(db.getInteger(DBRemitoCab.OID_PROVINCIA), getSesion()));
		remitocab.setPais(Pais.findByOidProxy(db.getInteger(DBRemitoCab.OID_PAIS), getSesion()));
		remitocab.setCompoStkTalRto(CompoStkTalonarioRto.findByOid(db.getInteger(DBRemitoCab.OID_COMPO_STK_RTO),
				getSesion()));
		remitocab.setTipoConfMovStk(TipoConfMovStkTalonario.findByOidProxy(db.getInteger(DBRemitoCab.OID_TIPO_CONF_MOV),
				getSesion()));
		remitocab.setProveedor(Proveedor.findByOid(db.getInteger(DBRemitoCab.OID_PROVEEDOR), getSesion()));
		remitocab.setComentario(db.getString(DBRemitoCab.COMENTARIO));
		remitocab.setReferencia1(db.getString(DBRemitoCab.REFERENCIA1));
		remitocab.setReferencia2(db.getString(DBRemitoCab.REFERENCIA2));
		
		
		
	}
}
