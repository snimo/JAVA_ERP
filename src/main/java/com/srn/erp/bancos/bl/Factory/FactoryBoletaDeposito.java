package com.srn.erp.bancos.bl.Factory;

import com.srn.erp.bancos.bm.BoletaDeposito;
import com.srn.erp.bancos.da.DBBoletaDeposito;
import com.srn.erp.general.bm.LugarEmision;
import com.srn.erp.general.bm.Moneda;
import com.srn.erp.general.bm.Sucursal;
import com.srn.erp.general.bm.Talonario;
import com.srn.erp.general.bm.TipoComprobante;
import com.srn.erp.general.da.DBComproCab;
import com.srn.erp.tesoreria.bm.Caja;
import com.srn.erp.tesoreria.bm.CuentaBancaria;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bm.Seguridad.Usuario;
import framework.request.bl.Utils.BaseException;

public class FactoryBoletaDeposito extends FactoryObjetoLogico {

	public FactoryBoletaDeposito() {
	}

	public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
		BoletaDeposito boletadeposito = (BoletaDeposito) objLog;
		boletadeposito.setOID(db.getInteger(DBBoletaDeposito.OID_BOLETA_DEP));
		
		
    // Por comproCab
		boletadeposito.setTalonario(Talonario.findByOidProxy(db.getInteger(DBComproCab.OID_TALONARIO),getSesion()));
		boletadeposito.setTipoCompro(TipoComprobante.findByOidProxy(db.getInteger(DBComproCab.OID_TC),getSesion()));
		boletadeposito.setTcExt(db.getString(DBComproCab.TC_EXT));
		boletadeposito.setLetra(db.getString(DBComproCab.LETRA));
		boletadeposito.setLugarEmision(LugarEmision.findByOidProxy(db.getInteger(DBComproCab.OID_LUG_EMI),getSesion()));
		boletadeposito.setNrolugemision(db.getInteger(DBComproCab.LUG_EMI));
		boletadeposito.setNroext(db.getInteger(DBComproCab.NROEXT));
		boletadeposito.setEmision(db.getDate(DBComproCab.EMISION));
		boletadeposito.setEstado(db.getString(DBComproCab.ESTADO));
		boletadeposito.setComentario(db.getString(DBComproCab.COMENTARIO));
		boletadeposito.setFecAlta(db.getDate(DBComproCab.FEC_ALTA));
		boletadeposito.setUsuario(Usuario.findByOidProxy(db.getInteger(DBComproCab.OID_USUARIO),getSesion()));
		boletadeposito.setActivo(db.getBoolean(DBComproCab.ACTIVO));
		boletadeposito.setSucursal(Sucursal.findByOidProxy(db.getInteger(DBComproCab.OID_SUCURSAL),getSesion()));
		
		
		
		boletadeposito.setCaja(Caja.findByOidProxy(db.getInteger(DBBoletaDeposito.OID_CAJA),getSesion()));
		boletadeposito.setFec_deposito(db.getDate(DBBoletaDeposito.FEC_DEPOSITO));
		boletadeposito.setClearing(db.getInteger(DBBoletaDeposito.CLEARING));
		boletadeposito.setCuenta_bancaria(CuentaBancaria.findByOidProxy(db.getInteger(DBBoletaDeposito.OID_CTA_BANCARIA),
				getSesion()));
		boletadeposito.setMoneda(Moneda.findByOidProxy(db.getInteger(DBBoletaDeposito.OID_MONEDA), getSesion()));
		boletadeposito.setCotizacion(db.getValorCotizacion(DBBoletaDeposito.COTIZACION));
		boletadeposito.setMontoDeposito(db.getMoney(DBBoletaDeposito.MONTO_DEPOSITO));
		boletadeposito.setGastos(db.getMoney(DBBoletaDeposito.GASTOS));
		boletadeposito.setNetoDeposito(db.getMoney(DBBoletaDeposito.NETO_DEPOSITO));
	}
}
