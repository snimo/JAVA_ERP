package com.srn.erp.tesoreria.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.compras.bm.Proveedor;
import com.srn.erp.tesoreria.bm.Banco;
import com.srn.erp.tesoreria.bm.Caja;
import com.srn.erp.tesoreria.bm.TarjetaCredito;
import com.srn.erp.tesoreria.bm.TipoValor;
import com.srn.erp.tesoreria.bm.Valor;
import com.srn.erp.ventas.bm.Sujeto;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.Fecha;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.applicarionServer.bm.Varios.Money;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;

public class DBValor extends DBObjetoPersistente {

	public static final String	OID_VALOR										= "oid_valor";

	public static final String	OID_TIPO_VALOR							= "oid_tipo_valor";

	public static final String	OID_TAR_CREDITO							= "oid_tar_credito";

	public static final String	OID_TICKET									= "oid_ticket";

	public static final String	OID_BANCO										= "oid_banco";

	public static final String	NRO_CHEQUE									= "nro_cheque";

	public static final String	FEC_EMISION									= "fec_emision";

	public static final String	FEC_VTO											= "fec_vto";

	public static final String	ANULADO											= "anulado";

	public static final String	ENDOSADO										= "endosado";

	public static final String	OID_CTA_BANCARIA						= "oid_cta_bancaria";

	public static final String	DEPOSITADO									= "depositado";

	public static final String	RECHAZADO										= "rechazado";

	public static final String	COBRADO											= "cobrado";

	public static final String	TITULAR											= "titular";

	public static final String	RECIBIDO										= "recibido";

	public static final String	CUPON												= "cupon";

	public static final String	NRO_TARJETA									= "nro_tarjeta";

	public static final String	NRO_VALOR										= "nro_valor";

	public static final String	OID_CAJA										= "oid_caja";

	public static final String	ES_CAJA											= "es_caja";

	public static final String	SALDO												= "saldo";

	public static final String	IMPORTE											= "importe";

	public static final String	OID_USUARIO									= "oid_usuario";

	public static final String	COTIZACION									= "cotizacion";

	public static final String	OID_SUJETO									= "oid_sujeto";

	public static final String	LOTE												= "lote";

	public static final String	CUOTAS											= "cuotas";
	
	public static final String  NRO_CERTIFICADO             = "nro_certificado";
	
	public static final String  OID_PROVINCIA               = "oid_provincia";
	
	public static final String  DEVUELTO										= "devuelto";
	
	public static final String  CUIT										= "cuit";
	
	public static final String NUE_FEC_VTO = "nue_fec_vto";
	
	public static final String CODIGO_AUTORIZ = "codigo_autoriz";
	
	public static final String OID_PROVEEDOR = "oid_proveedor";
	
	public static final String LIQUIDADO = "liquidado";

	public static final int			SELECT_BY_CHEQUES_EN_CAJA		= 100;

	public static final int			SELECT_BY_CUPONES_TAR_CRED	= 101;

	public static final int			SELECT_BY_CUPONES_TICKET		= 102;

	public static final int			SELECT_BY_DOC_CLIENTES			= 103;

	public static final int			SELECT_BY_CUP_TAR_DEB				= 104;

	public static final int			SELECT_BY_CHEQUE_CLIENTES		= 105;

	public static final int			SELECT_BY_CHEQUES_TERCEROS	= 106;

	public static final int			SELECT_BY_VALORES_EN_CAJA		= 107;
	
	public static final int			SELECT_BY_VALORES_EN_CAJA_SUJETO		= 108;
	
	public static final int 		UPDATE_CAJA = 109;
	
	public static final int 		SELECT_BY_DEUDA_FINAN_PROV = 110;
	
	public static final int 		UPDATE_NUEVA_FEC_VTO = 111;
	
	public static final int 		SELECT_BY_BUSQUEDA_VALOR = 112;
	
	public static final int 		SELECT_BY_DEUDA_FINAN_CLIE = 113;
	
	public static final int			SELECT_BY_TARJETAS_PEND_LIQ = 114;

	public DBValor() {
	}

	protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_VALOR = 1;
		final int OID_TIPO_VALOR = 2;
		final int OID_TAR_CREDITO = 3;
		final int OID_TICKET = 4;
		final int OID_BANCO = 5;
		final int NRO_CHEQUE = 6;
		final int FEC_EMISION = 7;
		final int FEC_VTO = 8;
		final int ANULADO = 9;
		final int ENDOSADO = 10;
		final int OID_CTA_BANCARIA = 11;
		final int DEPOSITADO = 12;
		final int RECHAZADO = 13;
		final int COBRADO = 14;
		final int TITULAR = 15;
		final int RECIBIDO = 16;
		final int CUPON = 17;
		final int NRO_TARJETA = 18;
		final int NRO_VALOR = 19;
		final int OID_CAJA = 20;
		final int ES_CAJA = 21;
		final int SALDO = 22;
		final int IMPORTE = 23;
		final int USUARIO = 24;
		final int COTIZACION = 25;
		final int OID_SUJETO = 26;
		final int LOTE = 27;
		final int CUOTA = 28;
		final int NRO_CERTIFICADO = 29;
		final int OID_PROVINCIA = 30;
		final int DEVUELTO = 31;
		final int CODIGO_AUTORIZ = 32;
		final int CUIT = 33;
		final int NUE_FEC_VTO = 34;
		final int OID_PROVEEDOR = 35;
		final int LIQUIDADO = 36;

		Valor pers = (Valor) objetoPersistente;

		StringBuffer sqlInsert = new StringBuffer();
		sqlInsert.append(" insert into vaValores " + " ( " + "OID_VALOR," + "OID_TIPO_VALOR," + "OID_TAR_CREDITO,"
				+ "OID_TICKET," + "OID_BANCO," + "NRO_CHEQUE," + "FEC_EMISION," + "FEC_VTO," + "ANULADO," + "ENDOSADO,"
				+ "OID_CTA_BANCARIA," + "DEPOSITADO," + "RECHAZADO," + "COBRADO," + "TITULAR," + "RECIBIDO," + "CUPON,"
				+ "NRO_TARJETA," + "NRO_VALOR," + "OID_CAJA," + "ES_CAJA," + "SALDO," + "IMPORTE," + "OID_USUARIO,"
				+ "COTIZACION,OID_SUJETO,LOTE,CUOTAS,NRO_CERTIFICADO,OID_PROVINCIA , DEVUELTO , CODIGO_AUTORIZ , CUIT , NUE_FEC_VTO , OID_PROVEEDOR , LIQUIDADO)" + " values " + "(" + "?,"+ "?," + "?," + "?," + "?," + "?," + "?," + "?,"
				+ "?," + "?," + "?," + "?," + "?," + "?," + "?,"+ "?," + "?," + "?," + "?," + "?," +"?," + "?,"+ "?,"+ "?," + "?," + "?," + "?,"+ "?," + "?,"+ "?," + "?,"
				+ "?," + "?," + "?," + "?," + "?) ");

		PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
		qInsert.setInt(OID_VALOR, pers.getOID());
		qInsert.setInt(OID_TIPO_VALOR, pers.getTipovalor().getOID());

		if (pers.getTarjetacredito() != null)
			qInsert.setInt(OID_TAR_CREDITO, pers.getTarjetacredito().getOID());
		else
			qInsert.setNull(OID_TAR_CREDITO, java.sql.Types.INTEGER);

		if (pers.getTicket() != null)
			qInsert.setInt(OID_TICKET, pers.getTicket().getOID());
		else
			qInsert.setNull(OID_TICKET, java.sql.Types.INTEGER);

		if (pers.getBanco() != null)
			qInsert.setInt(OID_BANCO, pers.getBanco().getOID());
		else
			qInsert.setNull(OID_BANCO, java.sql.Types.INTEGER);

		if (pers.getNrocheque() != null)
			qInsert.setInt(NRO_CHEQUE, pers.getNrocheque().intValue());
		else
			qInsert.setNull(NRO_CHEQUE, java.sql.Types.INTEGER);

		if (pers.getFechaemision() != null)
			qInsert.setDate(FEC_EMISION, new java.sql.Date(pers.getFechaemision().getTime()));
		else
			qInsert.setNull(FEC_EMISION, java.sql.Types.DATE);

		if (pers.getFechavto() != null)
			qInsert.setDate(FEC_VTO, new java.sql.Date(pers.getFechavto().getTime()));
		else
			qInsert.setNull(FEC_VTO, java.sql.Types.DATE);

		if (pers.isAnulado() != null)
			qInsert.setBoolean(ANULADO, pers.isAnulado().booleanValue());
		else
			qInsert.setBoolean(ANULADO, false);

		if (pers.isEndosado() != null)
			qInsert.setBoolean(ENDOSADO, pers.isEndosado().booleanValue());
		else
			qInsert.setBoolean(ENDOSADO, false);

		if (pers.getCuentabancaria() != null)
			qInsert.setInt(OID_CTA_BANCARIA, pers.getCuentabancaria().getOID());
		else
			qInsert.setNull(OID_CTA_BANCARIA, java.sql.Types.INTEGER);

		if (pers.isDepositado() != null)
			qInsert.setBoolean(DEPOSITADO, pers.isDepositado().booleanValue());
		else
			qInsert.setBoolean(DEPOSITADO, false);

		if (pers.isRechazado() != null)
			qInsert.setBoolean(RECHAZADO, pers.isRechazado().booleanValue());
		else
			qInsert.setBoolean(RECHAZADO, false);

		if (pers.isCobrado() != null)
			qInsert.setBoolean(COBRADO, pers.isCobrado().booleanValue());
		else
			qInsert.setBoolean(COBRADO, false);

		if (pers.getTitular() != null)
			qInsert.setString(TITULAR, pers.getTitular());
		else
			qInsert.setString(TITULAR, "");

		if (pers.isRecibido() != null)
			qInsert.setBoolean(RECIBIDO, pers.isRecibido().booleanValue());
		else
			qInsert.setBoolean(RECIBIDO, false);

		if (pers.getCupon() != null)
			qInsert.setInt(CUPON, pers.getCupon().intValue());
		else
			qInsert.setNull(CUPON, java.sql.Types.INTEGER);

		if (pers.getNro_tarjeta() != null)
			qInsert.setString(NRO_TARJETA, pers.getNro_tarjeta());
		else
			qInsert.setString(NRO_TARJETA, "");

		if (pers.getNro_valor() != null)
			qInsert.setInt(NRO_VALOR, pers.getNro_valor().intValue());
		else
			qInsert.setNull(NRO_VALOR, java.sql.Types.INTEGER);

		if (pers.getCaja() != null)
			qInsert.setInt(OID_CAJA, pers.getCaja().getOID());
		else
			qInsert.setNull(OID_CAJA, java.sql.Types.INTEGER);

		if (pers.getUsuario() != null)
			qInsert.setInt(USUARIO, pers.getUsuario().getOID());
		else
			qInsert.setNull(USUARIO, java.sql.Types.INTEGER);

		if (pers.getSujeto() != null)
			qInsert.setInt(OID_SUJETO, pers.getSujeto().getOID());
		else
			qInsert.setNull(OID_SUJETO, java.sql.Types.INTEGER);

		qInsert.setBoolean(ES_CAJA, pers.isEstaencaja().booleanValue());
		qInsert.setDouble(SALDO, pers.getSaldo().doubleValue());
		qInsert.setDouble(IMPORTE, pers.getImporte().doubleValue());
		qInsert.setDouble(COTIZACION, pers.getCotizacion().doubleValue());
		
		if (pers.getLote() != null)
			qInsert.setInt(LOTE, pers.getLote().intValue());
		else
			qInsert.setNull(LOTE, Types.INTEGER);
		
		if (pers.getCuotas() != null)
			qInsert.setInt(CUOTA, pers.getCuotas().intValue());
		else
			qInsert.setNull(CUOTA, Types.INTEGER);
		
		if (pers.getNroCertificado()!=null)
			qInsert.setString(NRO_CERTIFICADO, pers.getNroCertificado());
		else
			qInsert.setNull(NRO_CERTIFICADO, Types.VARCHAR);
		
		if (pers.getProvincia()!=null)
			qInsert.setInt(OID_PROVINCIA, pers.getProvincia().getOID());
		else
			qInsert.setNull(OID_PROVINCIA, Types.INTEGER);
		
		qInsert.setBoolean(DEVUELTO , pers.isDevuelto());
		
		if (pers.getCodigoAutorizacion()!=null)
			qInsert.setString(CODIGO_AUTORIZ, pers.getCodigoAutorizacion());
		else
			qInsert.setNull(CODIGO_AUTORIZ, Types.VARCHAR);
		
		if (pers.getCUIT()!=null)
			qInsert.setString(CUIT, pers.getCUIT());
		else
			qInsert.setNull(CUIT, Types.VARCHAR);
		if (pers.getNuevaFecVto()!= null)
			qInsert.setDate(NUE_FEC_VTO, new java.sql.Date(pers.getNuevaFecVto().getTime()));
		else
			qInsert.setNull(NUE_FEC_VTO, java.sql.Types.DATE);
		
		if (pers.getProveedor()!= null)
			qInsert.setInt(OID_PROVEEDOR, pers.getProveedor().getOID());
		else
			qInsert.setNull(OID_PROVEEDOR, java.sql.Types.INTEGER);

		if (pers.isLiquidado()!= null)
			qInsert.setBoolean(LIQUIDADO, pers.isLiquidado().booleanValue());
		else
			qInsert.setBoolean(LIQUIDADO, false);
		
		
		qInsert.executeUpdate();
		qInsert.close();
	}

	protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_TIPO_VALOR = 1;
		final int OID_TAR_CREDITO = 2;
		final int OID_TICKET = 3;
		final int OID_BANCO = 4;
		final int NRO_CHEQUE = 5;
		final int FEC_EMISION = 6;
		final int FEC_VTO = 7;
		final int ANULADO = 8;
		final int ENDOSADO = 9;
		final int OID_CTA_BANCARIA = 10;
		final int DEPOSITADO = 11;
		final int RECHAZADO = 12;
		final int COBRADO = 13;
		final int TITULAR = 14;
		final int RECIBIDO = 15;
		final int CUPON = 16;
		final int NRO_TARJETA = 17;
		final int NRO_VALOR = 18;
		final int OID_CAJA = 19;
		final int ES_CAJA = 20;
		final int SALDO = 21;
		final int IMPORTE = 22;
		final int USUARIO = 23;
		final int COTIZACION = 24;
		final int OID_SUJETO = 25;
		final int LOTE = 26;
		final int CUOTA = 27;
		final int NRO_CERTIFICADO = 28;
		final int OID_PROVINCIA = 29;
		final int DEVUELTO = 30;
		final int CODIGO_AUTORIZ = 31;
		final int CUIT = 32;
		final int NUE_FEC_VTO = 33;
		final int OID_PROVEEDOR = 34;
		final int LIQUIDADO = 35;
		final int OID_VALOR = 36;

		Valor pers = (Valor) objetoPersistente;

		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append(" update vaValores set " + "oid_tipo_valor=?" + ",oid_tar_credito=?" + ",oid_ticket=?"
				+ ",oid_banco=?" + ",nro_cheque=?" + ",fec_emision=?" + ",fec_vto=?" + ",anulado=?" + ",endosado=?"
				+ ",oid_cta_bancaria=?" + ",depositado=?" + ",rechazado=?" + ",cobrado=?" + ",titular=?" + ",recibido=?"
				+ ",cupon=?" + ",nro_tarjeta=?" + ",nro_valor=?" + ",oid_caja=?" + ",es_caja=?" + ",saldo=?" + ",importe=?"
				+ ",oid_usuario=?" + ",cotizacion=?" + ",oid_sujeto=?" + ",lote=?" + ",cuotas=? , nro_certificado=? , "+
				" oid_provincia = ? , devuelto = ? , codigo_autoriz = ? , cuit = ? , nue_fec_vto = ? , oid_proveedor = ? , liquidado=? " + " where " + " oid_valor=? ");

		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_VALOR, pers.getOID());
		qUpdate.setInt(OID_TIPO_VALOR, pers.getTipovalor().getOID());
		if (pers.getTarjetacredito() != null)
			qUpdate.setInt(OID_TAR_CREDITO, pers.getTarjetacredito().getOID());
		else
			qUpdate.setNull(OID_TAR_CREDITO, Types.INTEGER);
		if (pers.getTicket() != null)
			qUpdate.setInt(OID_TICKET, pers.getTicket().getOID());
		else
			qUpdate.setNull(OID_TICKET, Types.INTEGER);
		if (pers.getBanco() != null)
			qUpdate.setInt(OID_BANCO, pers.getBanco().getOID());
		else
			qUpdate.setNull(OID_BANCO, Types.INTEGER);
		if (pers.getNrocheque() != null)
			qUpdate.setInt(NRO_CHEQUE, pers.getNrocheque().intValue());
		else
			qUpdate.setNull(NRO_CHEQUE, Types.INTEGER);
		if (pers.getFechaemision() != null)
			qUpdate.setDate(FEC_EMISION, new java.sql.Date(pers.getFechaemision().getTime()));
		else
			qUpdate.setNull(FEC_EMISION, Types.DATE);
		if (pers.getFechavto() != null)
			qUpdate.setDate(FEC_VTO, new java.sql.Date(pers.getFechavto().getTime()));
		else
			qUpdate.setNull(FEC_VTO, Types.DATE);
		if (pers.isAnulado() != null)
			qUpdate.setBoolean(ANULADO, pers.isAnulado().booleanValue());
		else
			qUpdate.setNull(ANULADO, Types.BOOLEAN);
		if (pers.isEndosado() != null)
			qUpdate.setBoolean(ENDOSADO, pers.isEndosado().booleanValue());
		else
			qUpdate.setNull(ENDOSADO, Types.BOOLEAN);
		if (pers.getCuentabancaria() != null)
			qUpdate.setInt(OID_CTA_BANCARIA, pers.getCuentabancaria().getOID());
		else
			qUpdate.setNull(OID_CTA_BANCARIA, Types.INTEGER);
		if (pers.isDepositado() != null)
			qUpdate.setBoolean(DEPOSITADO, pers.isDepositado().booleanValue());
		else
			qUpdate.setNull(DEPOSITADO, Types.BOOLEAN);
		if (pers.isRechazado() != null)
			qUpdate.setBoolean(RECHAZADO, pers.isRechazado().booleanValue());
		else
			qUpdate.setNull(RECHAZADO, Types.BOOLEAN);
		if (pers.isCobrado() != null)
			qUpdate.setBoolean(COBRADO, pers.isCobrado().booleanValue());
		else
			qUpdate.setNull(COBRADO, Types.BOOLEAN);
		if (pers.getTitular() != null)
			qUpdate.setString(TITULAR, pers.getTitular());
		else
			qUpdate.setNull(TITULAR, Types.VARCHAR);
		if (pers.isRecibido() != null)
			qUpdate.setBoolean(RECIBIDO, pers.isRecibido().booleanValue());
		else
			qUpdate.setNull(RECIBIDO, Types.BOOLEAN);
		if (pers.getCupon() != null)
			qUpdate.setInt(CUPON, pers.getCupon().intValue());
		else
			qUpdate.setNull(CUPON, Types.INTEGER);
		if (pers.getNro_tarjeta() != null)
			qUpdate.setString(NRO_TARJETA, pers.getNro_tarjeta());
		else
			qUpdate.setNull(NRO_TARJETA, Types.VARCHAR);
		if (pers.getNro_valor() != null)
			qUpdate.setInt(NRO_VALOR, pers.getNro_valor().intValue());
		else
			qUpdate.setNull(NRO_VALOR, Types.INTEGER);
		if (pers.getCaja() != null)
			qUpdate.setInt(OID_CAJA, pers.getCaja().getOID());
		else
			qUpdate.setNull(OID_CAJA, Types.INTEGER);
		if (pers.isEstaencaja() != null)
			qUpdate.setBoolean(ES_CAJA, pers.isEstaencaja().booleanValue());
		else
			qUpdate.setNull(ES_CAJA, Types.BOOLEAN);
		if (pers.getSaldo() != null)
			qUpdate.setDouble(SALDO, pers.getSaldo().doubleValue());
		else
			qUpdate.setNull(SALDO, Types.DOUBLE);
		if (pers.getImporte() != null)
			qUpdate.setDouble(IMPORTE, pers.getImporte().doubleValue());
		else
			qUpdate.setNull(IMPORTE, Types.DOUBLE);
		if (pers.getUsuario() != null)
			qUpdate.setInt(USUARIO, pers.getUsuario().getOID());
		else
			qUpdate.setNull(USUARIO, Types.INTEGER);
		if (pers.getCotizacion() != null)
			qUpdate.setDouble(COTIZACION, pers.getCotizacion().doubleValue());
		else
			qUpdate.setNull(COTIZACION, Types.DOUBLE);
		if (pers.getSujeto()!=null)
			qUpdate.setInt(OID_SUJETO, pers.getSujeto().getOID());
		else
			qUpdate.setNull(OID_SUJETO, Types.INTEGER);
		if (pers.getLote() != null)
			qUpdate.setInt(LOTE, pers.getLote().intValue());
		else
			qUpdate.setNull(LOTE, Types.INTEGER);
		if (pers.getCuotas() != null)
			qUpdate.setInt(CUOTA, pers.getCuotas().intValue());
		else
			qUpdate.setNull(CUOTA, Types.INTEGER);
		
		if (pers.getNroCertificado()!=null)
			qUpdate.setString(NRO_CERTIFICADO, pers.getNroCertificado());
		else
			qUpdate.setNull(NRO_CERTIFICADO, Types.VARCHAR);
		
		if (pers.getProvincia()!=null)
			qUpdate.setInt(OID_PROVINCIA, pers.getProvincia().getOID());
		else
			qUpdate.setNull(OID_PROVINCIA, Types.INTEGER);
		
		qUpdate.setBoolean(DEVUELTO, pers.isDevuelto());
		
		if (pers.getCodigoAutorizacion()!=null)
			qUpdate.setString(CODIGO_AUTORIZ, pers.getCodigoAutorizacion());
		else
			qUpdate.setNull(CODIGO_AUTORIZ, Types.VARCHAR);
		
		if (pers.getCUIT()!=null)
			qUpdate.setString(CUIT, pers.getCUIT());
		else
			qUpdate.setNull(CUIT, Types.VARCHAR);		
		
		if (pers.getNuevaFecVto()!= null)
			qUpdate.setDate(NUE_FEC_VTO, new java.sql.Date(pers.getNuevaFecVto().getTime()));
		else
			qUpdate.setNull(NUE_FEC_VTO, java.sql.Types.DATE);
		
		if (pers.getProveedor()!= null)
			qUpdate.setInt(OID_PROVEEDOR, pers.getProveedor().getOID());
		else
			qUpdate.setNull(OID_PROVEEDOR, java.sql.Types.INTEGER);
		
		if (pers.isLiquidado()!= null)
			qUpdate.setBoolean(LIQUIDADO, pers.isLiquidado().booleanValue());
		else
			qUpdate.setBoolean(LIQUIDADO, false);
		
		
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_VALOR = 1;
		Valor pers = (Valor) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update vaValores " + " set activo=0 " + " where " + " oid_valor=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_VALOR, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_VALOR = 1;
		Valor pers = (Valor) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update vaValores " + " set activo=1 " + " where " + " oid_valor=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_VALOR, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	public PreparedStatement prepararSelect(int aSelect, Object aCondiciones) throws BaseException, SQLException {
		PreparedStatement ps = null;
		switch (aSelect) {
		case IDBObjetoPersistente.SELECT_BY_OID: {
			ps = this.selectByOID(aCondiciones);
			break;
		}
		case IDBObjetoPersistente.SELECT_BY_CODIGO: {
			ps = this.selectByCodigo(aCondiciones);
			break;
		}
		case IDBObjetoPersistente.SELECT_ALL_HELP: {
			ps = this.selectAllHelp(aCondiciones);
			break;
		}
		case SELECT_BY_CHEQUES_EN_CAJA: {
			ps = this.selectChequesEnCaja(aCondiciones);
			break;
		}
		case SELECT_BY_VALORES_EN_CAJA: {
			ps = this.selectValoresEnCaja(aCondiciones);
			break;
		}
		case SELECT_BY_VALORES_EN_CAJA_SUJETO: {
			ps = this.selectValoresEnCajaSujeto(aCondiciones);
			break;
		}
		case SELECT_BY_CHEQUE_CLIENTES: {
			ps = this.selectByChequesClientes(aCondiciones);
			break;
		}
		case SELECT_BY_CHEQUES_TERCEROS: {
			ps = this.selectByChequesTerceros(aCondiciones);
			break;
		}
		case SELECT_BY_CUPONES_TAR_CRED: {
			ps = this.selectByCuponesEnCartera(aCondiciones);
			break;
		}
		case SELECT_BY_CUPONES_TICKET: {
			ps = this.selectByCuponesTicket(aCondiciones);
			break;
		}
		case SELECT_BY_DOC_CLIENTES: {
			ps = this.selectByDocuClientes(aCondiciones);
			break;
		}
		case SELECT_BY_CUP_TAR_DEB: {
			ps = this.selectByCuponesTarDebito(aCondiciones);
			break;
		}
		case UPDATE_CAJA: {
			ps = this.updateCaja(aCondiciones);
			break;
		}
		case SELECT_BY_DEUDA_FINAN_PROV: {
			ps = this.selectByDeudaFinanProv(aCondiciones);
			break;
		}
		case UPDATE_NUEVA_FEC_VTO: {
			ps = this.updateNuevaFecVto(aCondiciones);
			break;
		}
		case SELECT_BY_BUSQUEDA_VALOR: {
			ps = this.selectByBusquedaValor(aCondiciones);
			break;
		}
		case SELECT_BY_DEUDA_FINAN_CLIE : {
			ps = this.selectByDeudaFinanClie(aCondiciones);
			break;
		}
		case SELECT_BY_TARJETAS_PEND_LIQ: {
			ps = this.selectByTarjetasPendLiquidar(aCondiciones);
			break;
		}
		}
		return ps;
	}

	private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

		final int OID_VALOR = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  vaValores ");
		textSQL.append(" WHERE oid_valor = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		int oid = ((Integer) aCondiciones).intValue();
		querySelect.setInt(OID_VALOR, oid);
		return querySelect;
	}
	
	private PreparedStatement selectByBusquedaValor(Object aCondiciones) throws BaseException, SQLException {
		final int OID_VALOR = 1;

		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  vaValores ");
		textSQL.append(" WHERE 1=1 ");
		
		if (condiciones.containsKey(Caja.NICKNAME)) {
			Caja caja = (Caja) condiciones.get(Caja.NICKNAME);
			textSQL.append(" and oid_caja = "+caja.getOIDInteger());
		}
		
		if (condiciones.containsKey("FEC_EMI_DESDE")) 
			textSQL.append(" and fec_emision >= ?");

		if (condiciones.containsKey("FEC_EMI_HASTA")) 
			textSQL.append(" and fec_emision <= ?");
		
		if (condiciones.containsKey("FEC_VTO_DESDE")) 
			textSQL.append(" and fec_vto >= ?");

		if (condiciones.containsKey("FEC_VTO_HASTA")) 
			textSQL.append(" and fec_vto <= ?");
		
		if (condiciones.containsKey(TipoValor.NICKNAME)) {
			TipoValor tipoValor = (TipoValor) condiciones.get(TipoValor.NICKNAME); 
			textSQL.append(" and oid_tipo_valor = "+tipoValor.getOIDInteger());
		}
		
		if (condiciones.containsKey(Sujeto.NICKNAME)) {
			Sujeto sujeto = (Sujeto) condiciones.get(Sujeto.NICKNAME); 
			textSQL.append(" and oid_sujeto = "+sujeto.getOIDInteger());
		}
		
		if (condiciones.containsKey("CUIT")) {
			String cuit = (String) condiciones.get("CUIT"); 
			textSQL.append(" and cuit = '"+cuit+"' ");
		}
		
		if (condiciones.containsKey("NRO_CHEQUE")) {
			Integer nroCheque = (Integer) condiciones.get("NRO_CHEQUE"); 
			textSQL.append(" and nro_cheque = "+nroCheque.toString());
		}
		
		if (condiciones.containsKey("NRO_TARJETA")) {
			String nroTarjeta = (String) condiciones.get("NRO_TARJETA"); 
			textSQL.append(" and nro_tarjeta = '"+nroTarjeta.toString()+"'");
		}
		
		if (condiciones.containsKey("IMPORTE")) {
			Money importe = (Money) condiciones.get("IMPORTE"); 
			textSQL.append(" and importe = "+importe.doubleValue());
		}

		if (condiciones.containsKey(Banco.NICKNAME)) {
			Banco banco = (Banco) condiciones.get(Banco.NICKNAME); 
			textSQL.append(" and oid_banco = "+banco.getOIDInteger());
		}
		
		if (condiciones.containsKey(TarjetaCredito.NICKNAME)) {
			TarjetaCredito tarjeta = (TarjetaCredito) condiciones.get(TarjetaCredito.NICKNAME); 
			textSQL.append(" and oid_tar_credito = "+tarjeta.getOIDInteger());
		}
		
		if (condiciones.containsKey("NRO_LOTE")) {
			Integer nroLote = (Integer) condiciones.get("NRO_LOTE"); 
			textSQL.append(" and lote = "+nroLote);
		}
		
		if (condiciones.containsKey("NRO_CUPON")) {
			Integer nroCupon = (Integer) condiciones.get("NRO_CUPON"); 
			textSQL.append(" and cupon = "+nroCupon.toString());
		}
		
		if (condiciones.containsKey("COD_AUTORIZACION")) {
			String codAutorizacion = (String) condiciones.get("COD_AUTORIZACION"); 
			textSQL.append(" and codigo_autoriz = '"+codAutorizacion.toString()+"'");
		}
		
		
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		
		int nroParam = 0;
		if (condiciones.containsKey("FEC_EMI_DESDE")) {
			++nroParam;
			java.util.Date fecha = (java.util.Date) condiciones.get("FEC_EMI_DESDE");
			querySelect.setDate(nroParam, new java.sql.Date(fecha.getTime()));
		}

		if (condiciones.containsKey("FEC_EMI_HASTA")) {
			++nroParam;
			java.util.Date fecha = (java.util.Date) condiciones.get("FEC_EMI_HASTA");
			querySelect.setDate(nroParam, new java.sql.Date(fecha.getTime()));
		}
			
		
		if (condiciones.containsKey("FEC_VTO_DESDE")) {
			++nroParam;
			java.util.Date fecha = (java.util.Date) condiciones.get("FEC_VTO_DESDE");
			querySelect.setDate(nroParam, new java.sql.Date(fecha.getTime()));
		}
			

		if (condiciones.containsKey("FEC_VTO_HASTA")) {
			++nroParam;
			java.util.Date fecha = (java.util.Date) condiciones.get("FEC_VTO_HASTA");
			querySelect.setDate(nroParam, new java.sql.Date(fecha.getTime()));
		}
			
		return querySelect;
	}
	
	
	private PreparedStatement updateCaja(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("update vaValores set oid_caja = ? where oid_valor = ?  ");
		PreparedStatement updateCaja = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		Caja caja = (Caja) condiciones.get(Caja.NICKNAME);
		Valor valor = (Valor) condiciones.get(Valor.NICKNAME);
		
		updateCaja.setInt(1, caja.getOID());
		updateCaja.setInt(2, valor.getOID());
		updateCaja.executeUpdate();
		updateCaja.close();
		
		return null;
	}
	
	private PreparedStatement updateNuevaFecVto(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("update  vaValores set nue_fec_vto = ? ");
		textSQL.append(" where oid_valor = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		
		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		java.util.Date fecha = (java.util.Date) condiciones.get("FECHA");
		Valor valor = (Valor) condiciones.get(Valor.NICKNAME);
		
		querySelect.setDate(1, new java.sql.Date(fecha.getTime()));
		querySelect.setInt(2, valor.getOIDInteger());
		querySelect.execute();
		querySelect.close();
		
		return null;
	}
	
	private PreparedStatement selectByDeudaFinanProv(Object aCondiciones) throws BaseException, SQLException {
		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  vaValores ");
		textSQL.append(" where anulado = 0 and devuelto = 0 and endosado = 0 and depositado = 0 and es_caja = 0 and fec_vto>=? ");
		
		java.util.Date fecEmisionHasta = null;
		if (condiciones.containsKey("fecha_emision_hasta"))
			fecEmisionHasta = (java.util.Date) condiciones.get("fecha_emision_hasta");
		if (fecEmisionHasta!=null)
			textSQL.append(" and fec_emision<=? "); 
		
		textSQL.append(" and oid_tipo_valor in (select oid_tipo_valor from vaTipoValores where es_deu_fin_prov=1 and activo=1) ");
		
		java.util.Date fecha = (java.util.Date) condiciones.get("fecha");
		if (condiciones.containsKey(Proveedor.NICKNAME)) {
			Proveedor proveedor = (Proveedor) condiciones.get(Proveedor.NICKNAME);
			textSQL.append(" and oid_proveedor="+proveedor.getOIDInteger());
		}
		
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
			
		querySelect.setDate(1, new java.sql.Date(fecha.getTime()));
		if (fecEmisionHasta!=null)
			querySelect.setDate(2, new java.sql.Date(fecEmisionHasta.getTime()));
		
		return querySelect;
	}
	

	private PreparedStatement selectByChequesTerceros(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  vaValores ");
		textSQL
				.append(" where anulado = 0 and devuelto=0 and endosado = 0 and depositado = 0 and es_caja = 1 and oid_caja = ? and oid_tipo_valor in (select oid_tipo_valor from vaTipoValores where compo='CHE_TER') ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		Caja caja = (Caja) aCondiciones;
		querySelect.setInt(1, caja.getOID());
		return querySelect;
	}

	private PreparedStatement selectChequesEnCaja(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  vaValores ");
		textSQL.append(" where anulado = 0 and devuelto=0 and endosado = 0 and depositado = 0 and es_caja = 1 and oid_caja = ? and oid_tipo_valor in (select oid_tipo_valor from vaTipoValores where compo='CHE_TER' or compo='CHE_CLI') ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		Caja caja = (Caja) aCondiciones;
		querySelect.setInt(1, caja.getOID());
		return querySelect;
	}

	private PreparedStatement selectValoresEnCaja(Object aCondiciones) throws BaseException, SQLException {
		
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  vaValores ");
		textSQL.append(" where anulado = 0 and devuelto=0 and endosado = 0 and depositado = 0 and rechazado=0 and cobrado=0 and liquidado=0 and es_caja = 1 ");
		
		
		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		
		Caja caja = (Caja)condiciones.get(Caja.NICKNAME);
		if (caja!=null)
			textSQL.append(" and oid_caja = "+caja.getOIDInteger());
		
		Sujeto sujeto = (Sujeto)condiciones.get(Sujeto.NICKNAME);
		if (sujeto!=null)
			textSQL.append(" and oid_sujeto = "+sujeto.getOIDInteger());

		if (condiciones.containsKey(TipoValor.NICKNAME)) {
			TipoValor tipoValor = (TipoValor)condiciones.get(TipoValor.NICKNAME);
			if (tipoValor!=null)
				textSQL.append(" and oid_tipo_valor = "+tipoValor.getOIDInteger());
		}
		
		if (condiciones.containsKey("LISTA_TIPOS_VALORES")) {
			List listaTiposValores = (List) condiciones.get("LISTA_TIPOS_VALORES");
			if (listaTiposValores.size()>0) {
				textSQL.append(" and oid_tipo_valor in (-1");
				Iterator iterTiposValores = listaTiposValores.iterator();
				while (iterTiposValores.hasNext()) {
					TipoValor tipoValor = (TipoValor) iterTiposValores.next();
					textSQL.append(","+tipoValor.getOIDInteger());
				}
				textSQL.append(") "); 	
			}
		}
		
		
		
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}
	
	private PreparedStatement selectByTarjetasPendLiquidar(Object aCondiciones) throws BaseException, SQLException {
		
		java.util.Date fecEmiDesde = null;
		java.util.Date fecEmiHasta = null;
		int nroParam = 0;
		
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT a.* FROM  vaValores a , vaTipoValores b");
		textSQL.append(" where a.oid_tipo_valor = b.oid_tipo_valor and a.anulado = 0 and a.liquidado=0 ");
		
		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		
		TipoValor tipoValor = (TipoValor)condiciones.get(TipoValor.NICKNAME);
		if (tipoValor!=null) 
			textSQL.append(" and a.oid_tipo_valor="+tipoValor.getOIDInteger());
		
		TarjetaCredito tarjetaCredito = (TarjetaCredito)condiciones.get(TarjetaCredito.NICKNAME);
		if (tarjetaCredito!=null) 
			textSQL.append(" and a.oid_tar_credito="+tarjetaCredito.getOIDInteger());
		
		Banco banco = (Banco)condiciones.get(Banco.NICKNAME);
		if (banco!=null) 
			textSQL.append(" and a.oid_banco="+banco.getOIDInteger());
		
		Caja caja = (Caja)condiciones.get(Caja.NICKNAME);
		if (caja!=null) 
			textSQL.append(" and a.oid_caja="+caja.getOIDInteger());

		fecEmiDesde = (java.util.Date)condiciones.get("FEC_EMI_DESDE");
		fecEmiHasta = (java.util.Date)condiciones.get("FEC_EMI_HASTA");
		
		if (fecEmiDesde!=null)
			textSQL.append(" and a.fec_emision>=? ");

		if (fecEmiHasta!=null)
			textSQL.append(" and a.fec_emision<=? ");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		
		if (fecEmiDesde!=null) {
			++nroParam;
			querySelect.setDate(nroParam, new java.sql.Date(fecEmiDesde.getTime()));
		}
			
		if (fecEmiHasta!=null) {
			++nroParam;
			querySelect.setDate(nroParam, new java.sql.Date(fecEmiHasta.getTime()));
		}
				
		return querySelect;
	}
	
	
	

	private PreparedStatement selectByDeudaFinanClie(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT a.* FROM  vaValores a , vaTipoValores b");
		textSQL.append(" where a.oid_tipo_valor = b.oid_tipo_valor and b.es_deuda_finan=1 and a.anulado = 0 and a.es_caja = 1 ");
		
		HashTableDatos condiciones = (HashTableDatos) aCondiciones;

		java.util.Date fecha = null;
		textSQL.append(" and a.fec_vto>? ");		
		
		java.util.Date fecEmisionHasta = null;
		boolean valEnCajaFecParaAtras = false;
		if (condiciones.containsKey("fecha_emision_hasta")) {
			fecEmisionHasta = (java.util.Date) condiciones.get("fecha_emision_hasta");
			
			if (fecEmisionHasta.before(Fecha.getFechaActual())) {
				// Traer los valores que estaban en caja de una fecha para atras
				valEnCajaFecParaAtras = true;
				textSQL.append(" and exists ( ");
				textSQL.append(" select "); 
				textSQL.append("   a1.oid_valor,sum(a1.signo) "); 
				textSQL.append(" from "); 
				textSQL.append("   vaArqueo a1 , geComproCab b1 "); 
				textSQL.append(" where ");
				textSQL.append("   a1.oid_cco = b1.oid_cco and a1.fecha_caja<=? and a.oid_valor = a1.oid_valor ");
				textSQL.append("   and b1.activo=1 ");
				textSQL.append(" group by ");
				textSQL.append("   a1.oid_valor having sum(a1.signo)=1) ");
			}
				else
					textSQL.append(" and a.devuelto=0 and a.endosado = 0 and a.depositado = 0 ");
		} else
			textSQL.append(" and a.devuelto=0 and a.endosado = 0 and a.depositado = 0 ");
		
		if (condiciones.containsKey(Caja.NICKNAME)) {
			Caja caja = (Caja) condiciones.get(Caja.NICKNAME);
			textSQL.append(" and a.oid_caja = "+caja.getOIDInteger());
		}
		
		if (condiciones.containsKey(Sujeto.NICKNAME)) {
			Sujeto sujeto = (Sujeto) condiciones.get(Sujeto.NICKNAME);
			textSQL.append(" and a.oid_sujeto = "+sujeto.getOIDInteger());
		}
		
		if (condiciones.containsKey(TipoValor.NICKNAME)) {
			TipoValor tipoValor = (TipoValor) condiciones.get(TipoValor.NICKNAME);
			textSQL.append(" and a.oid_tipo_valor = "+tipoValor.getOIDInteger());
		}
		
		
		
		
		if (condiciones.containsKey("fecha")) 
			fecha = (java.util.Date) condiciones.get("fecha");
		else 
			fecha = Valor.getFechaDeudaFinan(this.getSesion());
		
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		
		int nroParam = 0;
		++nroParam;
		querySelect.setDate(nroParam, new java.sql.Date(fecha.getTime()));
		if (valEnCajaFecParaAtras) {
			++nroParam;
			querySelect.setDate(nroParam, new java.sql.Date(fecEmisionHasta.getTime()));
		//	++nroParam;
			//querySelect.setDate(nroParam, new java.sql.Date(fecEmisionHasta.getTime()));
		}
		
		return querySelect;
	}
	
	
	
	
	
	
	private PreparedStatement selectValoresEnCajaSujeto(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  vaValores ");
		textSQL.append(" where anulado = 0 and devuelto=0 and endosado = 0 and depositado = 0 and es_caja = 1 and oid_caja = ? and oid_sujeto = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		
		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		Caja caja = (Caja) condiciones.get(Caja.NICKNAME);
		Sujeto sujeto = (Sujeto) condiciones.get(Sujeto.NICKNAME);
		
		querySelect.setInt(1, caja.getOID());
		querySelect.setInt(2, sujeto.getOID());
		return querySelect;
	}
	

	private PreparedStatement selectByCuponesEnCartera(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  vaValores ");
		textSQL.append(" where anulado = 0 and devuelto=0 and endosado = 0 and depositado = 0 and es_caja = 1 and liquidado=0 and oid_caja = ? and oid_tipo_valor in (select oid_tipo_valor from vaTipoValores where compo='TAR_CRE') ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		Caja caja = (Caja) aCondiciones;
		querySelect.setInt(1, caja.getOID());
		return querySelect;
	}

	private PreparedStatement selectByCuponesTarDebito(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  vaValores ");
		textSQL
				.append(" where anulado = 0 and endosado = 0 and devuelto=0 and depositado = 0 and liquidado=0 and es_caja = 1 and oid_caja = ? and oid_tipo_valor in (select oid_tipo_valor from vaTipoValores where compo='TAR_DEB') ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		Caja caja = (Caja) aCondiciones;
		querySelect.setInt(1, caja.getOID());
		return querySelect;
	}

	private PreparedStatement selectByCuponesTicket(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  vaValores ");
		textSQL
				.append(" where anulado = 0 and endosado = 0 and devuelto=0 and depositado = 0 and liquidado=0 and es_caja = 1 and oid_caja = ? and oid_tipo_valor in (select oid_tipo_valor from vaTipoValores where compo='TICKET') ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		Caja caja = (Caja) aCondiciones;
		querySelect.setInt(1, caja.getOID());
		return querySelect;
	}

	private PreparedStatement selectByDocuClientes(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  vaValores ");
		textSQL
				.append(" where anulado = 0 and endosado = 0 and devuelto=0 and depositado = 0 and liquidado=0 and es_caja = 1 and oid_caja = ? and oid_tipo_valor in (select oid_tipo_valor from vaTipoValores where compo='DOC_CLI') ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		Caja caja = (Caja) aCondiciones;
		querySelect.setInt(1, caja.getOID());
		return querySelect;
	}
	
	private PreparedStatement selectByChequesClientes(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  vaValores ");
		textSQL
				.append(" where anulado = 0 and endosado = 0 and depositado = 0 and es_caja = 1 and liquidado=0 and oid_caja = ? and oid_tipo_valor in (select oid_tipo_valor from vaTipoValores where compo='CHE_CLI') ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		Caja caja = (Caja) aCondiciones;
		querySelect.setInt(1, caja.getOID());
		return querySelect;
	}
	

	private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

		final int CODIGO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  vaValores ");
		textSQL.append(" WHERE oid_valor = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		Integer codigo = new Integer((String)aCondiciones);
		querySelect.setInt(CODIGO, codigo);
		return querySelect;
	}

	private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();

		textSQL.append("SELECT oid_valor oid, oid_valor codigo, oid_valor descripcion , 1 activo ");
		textSQL.append(" from vaValores");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}

	public static List getChequesEnCartera(Caja caja, ISesion aSesion) throws BaseException {
		return (List) ObjetoLogico.getObjects(Valor.NICKNAME, DBValor.SELECT_BY_CHEQUES_EN_CAJA, caja, new ListObserver(),
				aSesion);
	}
	
	public static List getValoresEnCartera(
			Caja caja, 
			Sujeto sujeto , 
			TipoValor tipoValor,
			List tiposValores,
			ISesion aSesion) throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		if (sujeto!=null)
			condiciones.put(Sujeto.NICKNAME,sujeto);
		if (caja!=null)
			condiciones.put(Caja.NICKNAME,caja);
		if (tipoValor!=null)
			condiciones.put(TipoValor.NICKNAME,tipoValor);
		if (tiposValores!=null)
			condiciones.put("LISTA_TIPOS_VALORES",tiposValores);
		return (List) ObjetoLogico.getObjects(Valor.NICKNAME, DBValor.SELECT_BY_VALORES_EN_CAJA, condiciones, new ListObserver(),
				aSesion);
	}
	
	public static List getValoresEnCartera(Caja caja, Sujeto sujeto , List listaTiposValores,ISesion aSesion) throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		if (sujeto!=null)
			condiciones.put(Sujeto.NICKNAME,sujeto);
		if (caja!=null)
			condiciones.put(Caja.NICKNAME,caja);
		if (listaTiposValores!=null)
			condiciones.put("LISTA_TIPOS_VALORES",listaTiposValores);
		return (List) ObjetoLogico.getObjects(Valor.NICKNAME, DBValor.SELECT_BY_VALORES_EN_CAJA, condiciones, new ListObserver(),
				aSesion);
	}
	
	
	
	public static List getValoresEnCartera(Caja caja, Sujeto sujeto , ISesion aSesion) throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put(Caja.NICKNAME,caja);
		condiciones.put(Sujeto.NICKNAME,sujeto);
		return (List) ObjetoLogico.getObjects(Valor.NICKNAME, 
				DBValor.SELECT_BY_VALORES_EN_CAJA, condiciones, new ListObserver(),
				aSesion);
	}

	public static List getCuponesTarCredEnCartera(Caja caja, ISesion aSesion) throws BaseException {
		return (List) ObjetoLogico.getObjects(Valor.NICKNAME, DBValor.SELECT_BY_CUPONES_TAR_CRED, caja, new ListObserver(),
				aSesion);
	}

	public static List getCuponesTicket(Caja caja, ISesion aSesion) throws BaseException {
		return (List) ObjetoLogico.getObjects(Valor.NICKNAME, DBValor.SELECT_BY_CUPONES_TICKET, caja, new ListObserver(),
				aSesion);
	}

	public static List getDocumentosClientes(Caja caja, ISesion aSesion) throws BaseException {
		return (List) ObjetoLogico.getObjects(Valor.NICKNAME, DBValor.SELECT_BY_DOC_CLIENTES, caja, new ListObserver(),
				aSesion);
	}

	public static List getCuponesTarDebito(Caja caja, ISesion aSesion) throws BaseException {
		return (List) ObjetoLogico.getObjects(Valor.NICKNAME, DBValor.SELECT_BY_CUP_TAR_DEB, caja, new ListObserver(),
				aSesion);
	}

	public static List getChequesClientes(Caja caja, ISesion aSesion) throws BaseException {
		return (List) ObjetoLogico.getObjects(Valor.NICKNAME, DBValor.SELECT_BY_CHEQUE_CLIENTES, caja, new ListObserver(),
				aSesion);
	}

	public static List getChequesTerceros(Caja caja, ISesion aSesion) throws BaseException {
		return (List) ObjetoLogico.getObjects(Valor.NICKNAME, DBValor.SELECT_BY_CHEQUES_TERCEROS, caja, new ListObserver(),
				aSesion);
	}
	
	public static List getValoresDeudaFinanProv(
			java.util.Date fecha, 
			Proveedor proveedor,
			java.util.Date fechaEmisionHasta,
			ISesion aSesion) throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		if (fecha!=null)
			condiciones.put("fecha", fecha);
		if (fechaEmisionHasta!=null)
			condiciones.put("fecha_emision_hasta", fechaEmisionHasta);
		if (proveedor!=null)
			condiciones.put(Proveedor.NICKNAME, proveedor);
		return (List) ObjetoLogico.getObjects(
					Valor.NICKNAME, 
					DBValor.SELECT_BY_DEUDA_FINAN_PROV, 
					condiciones, 
					new ListObserver(),
				aSesion);
	}
	
	public static List getValoresDeudaFinanClie(java.util.Date fecha,
			Sujeto sujeto,
			Caja caja,
			TipoValor tipoValor,
			java.util.Date fechaEmisionHasta,
			ISesion aSesion) throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		if (fecha!=null)
			condiciones.put("fecha", fecha);
		if (sujeto!=null)
			condiciones.put(Sujeto.NICKNAME, sujeto);
		if (caja!=null)
			condiciones.put(Caja.NICKNAME, caja);
		if (tipoValor!=null)
			condiciones.put(TipoValor.NICKNAME, tipoValor);
		if (fechaEmisionHasta!=null)
			condiciones.put("fecha_emision_hasta", fechaEmisionHasta);
		
		return (List) ObjetoLogico.getObjects(
					Valor.NICKNAME, 
					DBValor.SELECT_BY_DEUDA_FINAN_CLIE, 
					condiciones, 
					new ListObserver(),
				aSesion);
	}
	
	
	
	public static List getBusquedaValores(
			 Caja caja,
			 java.util.Date fecEmiDesde,
			 java.util.Date fecEmiHasta,
			 java.util.Date fecVtoDesde,
			 java.util.Date fecVtoHasta,
			 TipoValor tipoValor,
			 Sujeto sujeto,
			 String cuit,
			 Integer nroCheque,
			 String nroTarjeta,
			 Money importe,
			 Banco banco,
			 TarjetaCredito tarjeta,
			 Integer nroLote,
			 Integer nroCupon,
			 String codAutorizacion, 
			 ISesion aSesion) throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		if (caja!=null)
			condiciones.put(Caja.NICKNAME, caja);
		if (fecEmiDesde!=null)
			condiciones.put("FEC_EMI_DESDE", fecEmiDesde);
		if (fecEmiHasta!=null)
			condiciones.put("FEC_EMI_HASTA", fecEmiHasta);
		if (fecVtoDesde!=null)
			condiciones.put("FEC_VTO_DESDE", fecVtoDesde);
		if (fecVtoHasta!=null)
			condiciones.put("FEC_VTO_HASTA", fecVtoHasta);
		if (tipoValor!=null)
			condiciones.put(TipoValor.NICKNAME, tipoValor);
		if (sujeto!=null)
			condiciones.put(Sujeto.NICKNAME, sujeto);
		if (cuit!=null)
			condiciones.put("CUIT", cuit);
		if (nroCheque!=null)
			condiciones.put("NRO_CHEQUE", nroCheque);
		if (nroTarjeta!=null)
			condiciones.put("NRO_TARJETA", nroTarjeta);
		if (importe!=null)
			condiciones.put("IMPORTE", importe);
		if (banco!=null)
			condiciones.put(Banco.NICKNAME, banco);
		if (tarjeta!=null)
			condiciones.put(TarjetaCredito.NICKNAME, tarjeta);
		if (nroLote!=null)
			condiciones.put("NRO_LOTE", nroLote);
		if (nroCupon!=null)
			condiciones.put("NRO_CUPON", nroCupon);
		if (codAutorizacion!=null)
			condiciones.put("COD_AUTORIZACION", codAutorizacion);
		
		return (List) ObjetoLogico.getObjects(
					Valor.NICKNAME, 
					DBValor.SELECT_BY_BUSQUEDA_VALOR, 
					condiciones, 
					new ListObserver(),
				aSesion);
	}
	
	
	
	public static void cambiarCaja(Valor valor,
			                           Caja caja, 
			                           ISesion aSesion) throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put(Valor.NICKNAME,valor);
		condiciones.put(Caja.NICKNAME,caja);
		ObjetoLogico.getObjects(Valor.NICKNAME, DBValor.UPDATE_CAJA, condiciones , null, aSesion);
	}
	
	public static void cambiarNuevaFecVto(Valor valor,
            java.util.Date fecha, 
            ISesion aSesion) throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put(Valor.NICKNAME,valor);
		condiciones.put("FECHA",fecha);
		ObjetoLogico.getObjects(Valor.NICKNAME, DBValor.UPDATE_NUEVA_FEC_VTO, condiciones , null, aSesion);
	}
	
	public static List getTarjetasPendLiquidar(
			TipoValor tipoValor,
			TarjetaCredito tarjetaCredito,
			Banco banco,
			Caja caja,
			java.util.Date fecEmiDesde,
			java.util.Date fecEmiHasta,
			ISesion aSesion) throws BaseException {
		
		HashTableDatos condiciones = new HashTableDatos();
		if (tipoValor!=null)
			condiciones.put(TipoValor.NICKNAME, tipoValor);
		if (tarjetaCredito!=null)
			condiciones.put(TarjetaCredito.NICKNAME, tarjetaCredito);
		if (banco!=null)
			condiciones.put(Banco.NICKNAME, banco);
		if (caja!=null)
			condiciones.put(Caja.NICKNAME, caja);
		if (fecEmiDesde!=null)
			condiciones.put("FEC_EMI_DESDE", fecEmiDesde);
		if (fecEmiHasta!=null)
			condiciones.put("FEC_EMI_HASTA", fecEmiHasta);
		
		return (List) ObjetoLogico.getObjects(
					Valor.NICKNAME, 
					DBValor.SELECT_BY_TARJETAS_PEND_LIQ, 
					condiciones, 
					new ListObserver(),
					aSesion);
	}
	
	

}
