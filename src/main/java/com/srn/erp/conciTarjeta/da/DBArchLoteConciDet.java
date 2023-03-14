package com.srn.erp.conciTarjeta.da;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import com.srn.erp.cip.bm.UtilCIP;
import com.srn.erp.conciTarjeta.bm.ArchLoteConciCab;
import com.srn.erp.conciTarjeta.bm.ArchLoteConciDet;
import com.srn.erp.conciTarjeta.bm.CabAsiLiquiTarj;
import com.srn.erp.conciTarjeta.bm.CabAsiTarjACobrar;
import com.srn.erp.conciTarjeta.bm.CabConciAutomatica;
import com.srn.erp.conciTarjeta.bm.CabModeloLiq;
import com.srn.erp.conciTarjeta.bm.EmpresaConciTar;
import com.srn.erp.conciTarjeta.bm.TarjetaConciTar;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.Fecha;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.applicarionServer.bm.Seguridad.Usuario;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.ObjetoObservado;

public class DBArchLoteConciDet extends DBObjetoPersistente {

	public static final String OID_ARCH_LOT_DET = "oid_arch_lot_det";
	public static final String OID_ARCH_LOT_CAB = "oid_arch_lot_cab";
	public static final String MODO_TRANSMISION = "modo_transmision";
	public static final String TIPO_OPERACION = "tipo_operacion";
	public static final String FECHA_OPER = "fecha_oper";
	public static final String HORA_OPER = "hora_oper";
	public static final String TIPO_TARJETA = "tipo_tarjeta";
	public static final String TARJETA = "tarjeta";
	public static final String NRO_TARJETA = "nro_tarjeta";
	public static final String BANDA_MANUAL = "banda_manual";
	public static final String COD_AUTORIZ = "cod_autoriz";
	public static final String TICKET = "ticket";
	public static final String MONEDA = "moneda";
	public static final String MONTO = "Monto";
	public static final String TIPO_CTA_DEB = "tipo_cta_deb";
	public static final String PLAN_Y_CUOTA = "plan_y_cuota";
	public static final String COD_COMERCIO = "cod_comercio";
	public static final String NRO_TERMINAL = "nro_terminal";
	public static final String TICKET_SEC = "ticket_sec";
	public static final String CODIGO_LISTA = "codigo_lista";
	public static final String MONTO_SEC = "monto_sec";
	public static final String FECHA_SEC = "fecha_sec";
	public static final String FACTURA = "factura";
	public static final String NRO_HOST = "nro_host";
	public static final String NRO_LOTE = "nro_lote";
	public static final String ACTIVO = "activo";
	public static final String PRESENTADO = "presentado";
	public static final String OID_EMPRESA = "oid_empresa";
	public static final String OID_UNI_NEG = "oid_uni_neg";
	public static final String FEC_OPER_DATE = "fec_oper_date";
	public static final String FEC_CIERRE = "fec_cierre";

	public static final String FEC_PRESEN_CUPO = "fec_presen_cupo";
	public static final String CONCILIADO = "conciliado";
	public static final String FEC_CONCI = "fec_conciliado";
	public static final String LIQUIDADO = "liquidado";
	public static final String FEC_LIQUI = "fec_liqui";
	public static final String PRE_CONTABILIZADO = "pre_contabilizado";
	public static final String FEC_PRECONTA = "fec_preconta";
	public static final String CONTABILIZADO = "contabilizado";
	public static final String FEC_CONTABILIZADO = "fec_contabilizado";

	public static final String OID_TAR_CONCI = "oid_tar_conci";
	public static final String NRO_TAR_ULT_NROS = "nro_tar_ult_nros";
	public static final String NRO_CONCILIACION = "nro_conciliacion";
	public static final String MARCAR_PRECONCI = "marcar_preconci";
	public static final String PRECONCI = "preconci";
	public static final String OID_USU_MAR_PRE = "oid_usu_mar_pre";
	public static final String FEC_PRECONCI = "fec_preconci";

	public static final String OID_CAB_CONCI_AUT = "oid_cab_conci_aut";
	public static final String PRECONCI_DUDOSO = "preconci_dudoso";
	public static final String ALTA_MANUAL = "alta_manual";
	public static final String OID_USU_PRECONCI = "oid_usu_preconci";
	
	public static final String OID_CAB_ASI_ACOB = "oid_cab_asi_acob";
	public static final String ASI_ACOB_CONTA = "asi_acob_conta";
	public static final String TARJETA_ORI = "tarjeta_ori";
	
	public static final String MARCA_ASI_ACOB = "marca_asi_acob";
	public static final String CUPON_PERDIDO = "cupon_perdido";
	public static final String OID_CAB_ASI_LIQ = "oid_cab_asi_liq";
	public static final String MARCA_ASI_LIQ = "marca_asi_liq";
	
	public static final String NRO_LIQUIDACION = "nro_liquidacion";
	public static final String CONTA_ASI_LIQ = "conta_asi_liq";
	public static final String REF_SIST_EXT = "ref_sist_ext";
	
	public static final String REF_SIST_EXT_1 = "ref_sist_ext_1";
	
	public static final String OID_USU_MAR_COB = "oid_usu_mar_cob";
	public static final String OID_USU_MAR_LIQ = "oid_usu_mar_liq";
	
	public static final int SELECT_BY_ARCH_CONC_CAB = 100;
	public static final int SELECT_BY_CONDICIONES = 101;
	public static final int UPDATE_PRESENTADO = 102;
	public static final int SELECT_VERIF_SI_EXISTE = 103;
	public static final int UPDATE_ANULAR_ARCH = 104;
	public static final int MARCAR_COMO_PRECONCI = 105;
	public static final int MARCAR_COMO_NO_PRECONCI = 106;
	public static final int SELECT_MARCADA_BY_EMPRESA_USU = 107;
	public static final int GENERAR_PRECONCILIACION = 108;
	public static final int SELECT_PRECONCI_EMPRESA_USU = 109;
	public static final int MARCAR_COMO_CONCILIADO = 110;
	public static final int BUSCAR_PARA_CONCILIAR = 111;
	public static final int SELECT_BY_EMP_NRO_CONCI = 112;
	public static final int SELECT_BY_EMP_ACTIVO_CONCI_NRO = 113;
	public static final int SELECT_BY_EMP_ACTIVO_CONCI_AUT = 114;
	public static final int MARCAR_COMO_PERDIDO = 115;
	public static final int MARCAR_COMO_NO_PERDIDO = 116;
	public static final int MARCAR_ASI_PARA_COB = 117;
	public static final int DESMARCAR_ASI_PARA_COB = 118;
	public static final int SELECT_MARCA_ASI_ACOB_NO_CONTA = 119;
	public static final int SELECT_ASI_COB_CONTA_SEGUN_NRO = 120;
	public static final int MARCAR_ASI_PARA_LIQ = 121;
	public static final int DESMARCAR_ASI_PARA_LIQ = 122;
	public static final int SELECT_MARCAR_ASI_LIQ_NO_CONTA = 123;
	public static final int SELECT_BY_CONTA_ASI_LIQ = 124;
	public static final int SELECT_ASI_LIQ_CONTA_SEGUN_NRO = 125;
	public static final int SELECT_BY_ASI_COB = 126;
	public static final int SELECT_BY_ASI_LIQ = 127;

	public DBArchLoteConciDet() {
	}

	protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_ARCH_LOT_DET = 1;
		final int OID_ARCH_LOT_CAB = 2;
		final int MODO_TRANSMISION = 3;
		final int TIPO_OPERACION = 4;
		final int FECHA_OPER = 5;
		final int HORA_OPER = 6;
		final int TIPO_TARJETA = 7;
		final int TARJETA = 8;
		final int NRO_TARJETA = 9;
		final int BANDA_MANUAL = 10;
		final int COD_AUTORIZ = 11;
		final int TICKET = 12;
		final int MONEDA = 13;
		final int MONTO = 14;
		final int TIPO_CTA_DEB = 15;
		final int PLAN_Y_CUOTA = 16;
		final int COD_COMERCIO = 17;
		final int NRO_TERMINAL = 18;
		final int TICKET_SEC = 19;
		final int CODIGO_LISTA = 20;
		final int MONTO_SEC = 21;
		final int FECHA_SEC = 22;
		final int FACTURA = 23;
		final int NRO_HOST = 24;
		final int NRO_LOTE = 25;
		final int ACTIVO = 26;
		final int PRESENTADO = 27;
		final int OID_EMPRESA = 28;
		final int OID_UNI_NEG = 29;
		final int FEC_OPER_DATE = 30;
		final int FEC_CIERRE = 31;
		final int FEC_PRESEN_CUPO = 32;
		final int CONCILIADO = 33;
		final int FEC_CONCI = 34;
		final int LIQUIDADO = 35;
		final int FEC_LIQUI = 36;
		final int PRE_CONTABILIZADO = 37;
		final int FEC_PRECONTA = 38;
		final int CONTABILIZADO = 39;
		final int FEC_CONTABILIZADO = 40;
		final int OID_TAR_CONCI = 41;
		final int NRO_TAR_ULT_NROS = 42;
		final int NRO_CONCILIACION = 43;
		final int MARCAR_PRECONCI = 44;
		final int PRECONCI = 45;
		final int OID_USU_MAR_PRE = 46;
		final int OID_CAB_CONCI_AUT = 47;
		final int PRECONCI_DUDOSO = 48;
		final int ALTA_MANUAL = 49;
		final int OID_USU_PRECONCI = 50;
		final int OID_CAB_ASI_ACOB = 51;
		final int ASI_ACOB_CONTA = 52;
		final int TARJETA_ORI = 53;
		final int MARCA_ASI_ACOB = 54;
		final int CUPON_PERDIDO = 55;
		final int OID_CAB_ASI_LIQ = 56;
		final int MARCA_ASI_LIQ = 57;
		final int NRO_LIQUIDACION = 58;
		final int CONTA_ASI_LIQ = 59;
		final int REF_SIST_EXT = 60;
		final int REF_SIST_EXT_1 = 61;

		ArchLoteConciDet pers = (ArchLoteConciDet) objetoPersistente;

		StringBuffer sqlInsert = new StringBuffer();
		sqlInsert
				.append(" insert into cTarArchLotDet "
						+ " ( "
						+ "OID_ARCH_LOT_DET,"
						+ "OID_ARCH_LOT_CAB,"
						+ "MODO_TRANSMISION,"
						+ "TIPO_OPERACION,"
						+ "FECHA_OPER,"
						+ "HORA_OPER,"
						+ "TIPO_TARJETA,"
						+ "TARJETA,"
						+ "NRO_TARJETA,"
						+ "BANDA_MANUAL,"
						+ "COD_AUTORIZ,"
						+ "TICKET,"
						+ "MONEDA,"
						+ "MONTO,"
						+ "TIPO_CTA_DEB,"
						+ "PLAN_Y_CUOTA,"
						+ "COD_COMERCIO,"
						+ "NRO_TERMINAL,"
						+ "TICKET_SEC,"
						+ "CODIGO_LISTA,"
						+ "MONTO_SEC,"
						+ "FECHA_SEC,"
						+ "FACTURA,"
						+ "NRO_HOST,"
						+ "NRO_LOTE,"
						+ "ACTIVO,"
						+ "PRESENTADO,"
						+ "OID_EMPRESA,"
						+ "OID_UNI_NEG,FEC_OPER_DATE,FEC_CIERRE,"
						+ "FEC_PRESEN_CUPO,"
						+ "CONCILIADO,"
						+ "FEC_CONCILIADO,"
						+ "LIQUIDADO,"
						+ "FEC_LIQUI,"
						+ "PRE_CONTABILIZADO,"
						+ "FEC_PRECONTA,"
						+ "CONTABILIZADO,"
						+ "FEC_CONTABILIZADO,OID_TAR_CONCI,NRO_TAR_ULT_NROS,NRO_CONCILIACION,MARCAR_PRECONCI,PRECONCI,OID_USU_MAR_PRE,OID_CAB_CONCI_AUT,PRECONCI_DUDOSO,ALTA_MANUAL,OID_USU_PRECONCI,OID_CAB_ASI_ACOB,ASI_ACOB_CONTA,TARJETA_ORI,MARCA_ASI_ACOB,CUPON_PERDIDO,OID_CAB_ASI_LIQ,MARCA_ASI_LIQ, NRO_LIQUIDACION, CONTA_ASI_LIQ,REF_SIST_EXT,REF_SIST_EXT_1)"
						+ " values " + "(" + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?,"
						+ "?,"+ "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?,"+ "?,"+ "?," + "?,"+ "?,"+ "?,"
						+ "?,"+ "?,"+ "?,"+ "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?,"+ "?,"+ "?,"+"?,"
						+ "?," + "?," + "?," + "?," + "?" + ") ");

		PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
		qInsert.setInt(OID_ARCH_LOT_DET, pers.getOID());
		if (pers.getArch_lot_cab() != null)
			qInsert.setInt(OID_ARCH_LOT_CAB, pers.getArch_lot_cab().getOID());
		else
			qInsert.setNull(OID_ARCH_LOT_CAB, Types.INTEGER);
		qInsert.setString(MODO_TRANSMISION, pers.getModo_transmision());
		qInsert.setString(TIPO_OPERACION, pers.getTipo_operacion());
		qInsert.setString(FECHA_OPER, pers.getFecha_oper());
		qInsert.setString(HORA_OPER, pers.getHora_oper());
		qInsert.setString(TIPO_TARJETA, pers.getTipo_tarjeta());
		qInsert.setString(TARJETA, pers.getTarjeta());
		qInsert.setString(NRO_TARJETA, pers.getNro_tarjeta());
		qInsert.setString(BANDA_MANUAL, pers.getBanda_manual());
		qInsert.setString(COD_AUTORIZ, pers.getCod_autoriz());
		qInsert.setString(TICKET, pers.getTicket());
		qInsert.setString(MONEDA, pers.getMoneda());
		qInsert.setDouble(MONTO, pers.getMonto().doubleValue());
		qInsert.setString(TIPO_CTA_DEB, pers.getTipo_cta_deb());
		qInsert.setString(PLAN_Y_CUOTA, pers.getPlan_y_cuota());
		qInsert.setString(COD_COMERCIO, pers.getCod_comercio());
		qInsert.setString(NRO_TERMINAL, pers.getNro_terminal());
		qInsert.setString(TICKET_SEC, pers.getTicket_sec());
		qInsert.setString(CODIGO_LISTA, pers.getCodigo_lista());
		qInsert.setDouble(MONTO_SEC, pers.getMonto_sec().doubleValue());
		qInsert.setString(FECHA_SEC, pers.getFecha_sec());
		qInsert.setString(FACTURA, pers.getFactura());
		qInsert.setString(NRO_HOST, pers.getNro_host());
		if (pers.getNro_lote() != null)
			qInsert.setInt(NRO_LOTE, pers.getNro_lote().intValue());
		else
			qInsert.setNull(NRO_LOTE, Types.INTEGER);
		qInsert.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		qInsert.setBoolean(PRESENTADO, pers.isPresentado().booleanValue());
		qInsert.setInt(OID_EMPRESA, pers.getEmpresa().getOID());
		if (pers.getUnidad_negocio() != null)
			qInsert.setInt(OID_UNI_NEG, pers.getUnidad_negocio().getOID());
		else
			qInsert.setNull(OID_UNI_NEG, Types.INTEGER);
		if (pers.getFecOperDate() != null)
			qInsert.setDate(FEC_OPER_DATE, new java.sql.Date(pers.getFecOperDate().getTime()));
		else
			qInsert.setNull(FEC_OPER_DATE, Types.DATE);
		qInsert.setDate(FEC_CIERRE, new java.sql.Date(pers.getFecCierre().getTime()));

		if (pers.getFecPresenCupo() != null)
			qInsert.setDate(FEC_PRESEN_CUPO, new java.sql.Date(pers.getFecPresenCupo().getTime()));
		else
			qInsert.setNull(FEC_PRESEN_CUPO, Types.DATE);

		qInsert.setBoolean(CONCILIADO, pers.isConciliado());

		if (pers.getFecConciliado() != null)
			qInsert.setDate(FEC_CONCI, new java.sql.Date(pers.getFecConciliado().getTime()));
		else
			qInsert.setNull(FEC_CONCI, Types.DATE);

		qInsert.setBoolean(LIQUIDADO, pers.isLiquidado());

		if (pers.getFecLiquidado() != null)
			qInsert.setDate(FEC_LIQUI, new java.sql.Date(pers.getFecLiquidado().getTime()));
		else
			qInsert.setNull(FEC_LIQUI, Types.DATE);

		qInsert.setBoolean(PRE_CONTABILIZADO, pers.isPreContabilizado());

		if (pers.getFecPreContabilizado() != null)
			qInsert.setDate(FEC_PRECONTA, new java.sql.Date(pers.getFecPreContabilizado().getTime()));
		else
			qInsert.setNull(FEC_PRECONTA, Types.DATE);

		qInsert.setBoolean(CONTABILIZADO, pers.isContabilizado());

		if (pers.getFecContabilizado() != null)
			qInsert.setDate(FEC_CONTABILIZADO, new java.sql.Date(pers.getFecContabilizado().getTime()));
		else
			qInsert.setNull(FEC_CONTABILIZADO, Types.DATE);

		if (pers.getTarjetaConciTar() != null)
			qInsert.setInt(OID_TAR_CONCI, pers.getTarjetaConciTar().getOID());
		else
			qInsert.setNull(OID_TAR_CONCI, Types.INTEGER);

		if (pers.getUltimosNrosTarjeta() != null)
			qInsert.setInt(NRO_TAR_ULT_NROS, pers.getUltimosNrosTarjeta().intValue());
		else
			qInsert.setInt(NRO_TAR_ULT_NROS, 0);

		if (pers.getNroConciliacion() != null)
			qInsert.setInt(NRO_CONCILIACION, pers.getNroConciliacion().intValue());
		else
			qInsert.setInt(NRO_CONCILIACION, 0);

		if (pers.isMarcarPreconci() != null)
			qInsert.setBoolean(MARCAR_PRECONCI, pers.isMarcarPreconci());
		else
			qInsert.setBoolean(MARCAR_PRECONCI, false);

		if (pers.isPreconci() != null)
			qInsert.setBoolean(PRECONCI, pers.isPreconci());
		else
			qInsert.setBoolean(PRECONCI, false);

		if (pers.getUsuarioMarcaPreconci() != null)
			qInsert.setInt(OID_USU_MAR_PRE, pers.getUsuarioMarcaPreconci().getOID());
		else
			qInsert.setNull(OID_USU_MAR_PRE, Types.INTEGER);

		if (pers.getCabConciAut() != null)
			qInsert.setInt(OID_CAB_CONCI_AUT, pers.getCabConciAut().getOID());
		else
			qInsert.setNull(OID_CAB_CONCI_AUT, Types.INTEGER);

		if (pers.isPreconciDudoso() != null)
			qInsert.setBoolean(PRECONCI_DUDOSO, pers.isPreconciDudoso().booleanValue());
		else
			qInsert.setBoolean(PRECONCI_DUDOSO, false);
		qInsert.setBoolean(ALTA_MANUAL, pers.isAltaManual().booleanValue());
		if (pers.getUsuarioPreconci() == null)
			qInsert.setNull(OID_USU_PRECONCI, java.sql.Types.INTEGER);
		else
			qInsert.setInt(OID_USU_PRECONCI, pers.getUsuarioPreconci().getOID());
		
		if (pers.getAsientoACobrar()!=null)
			qInsert.setInt(OID_CAB_ASI_ACOB, pers.getAsientoACobrar().getOID());
		else
			qInsert.setNull(OID_CAB_ASI_ACOB, Types.INTEGER);
		
		if (pers.isContaAsientoACobrar()!=null)
			qInsert.setBoolean(ASI_ACOB_CONTA, pers.isContaAsientoACobrar().booleanValue());
		else
			qInsert.setBoolean(ASI_ACOB_CONTA, false);
		
		if (pers.getTarjetaOri()!=null)
			qInsert.setString(TARJETA_ORI, pers.getTarjetaOri());
		else
			qInsert.setString(TARJETA_ORI, "");
		
		if (pers.isMarcaAsiACobrar()!=null)
			qInsert.setBoolean(MARCA_ASI_ACOB, pers.isMarcaAsiACobrar().booleanValue());
		else
			qInsert.setBoolean(MARCA_ASI_ACOB, false);
		
		if (pers.isCuponPerdido()!=null)
			qInsert.setBoolean(CUPON_PERDIDO, pers.isCuponPerdido().booleanValue());
		else
			qInsert.setBoolean(CUPON_PERDIDO, false);
		
		if (pers.getCabAsiLiquiTarj()!=null)
			qInsert.setInt(OID_CAB_ASI_LIQ, pers.getCabAsiLiquiTarj().getOID());
		else
			qInsert.setNull(OID_CAB_ASI_LIQ, Types.INTEGER);
		
		if (pers.isMarcaAsiLiq()!=null)
			qInsert.setBoolean(MARCA_ASI_LIQ, pers.isMarcaAsiLiq().booleanValue());
		else
			qInsert.setBoolean(MARCA_ASI_LIQ, false);
		
		if (pers.getNroLiquidacion()!=null)
			qInsert.setInt(NRO_LIQUIDACION, pers.getNroLiquidacion());
		else
			qInsert.setNull(NRO_LIQUIDACION, Types.INTEGER);
		
		if (pers.isContaAsiLiq()!=null)
			qInsert.setBoolean(CONTA_ASI_LIQ, pers.isContaAsiLiq().booleanValue());
		else
			qInsert.setBoolean(CONTA_ASI_LIQ, false);
		
		if (pers.getRefSistExt()!=null)
			qInsert.setString(REF_SIST_EXT, pers.getRefSistExt());
		else
			qInsert.setNull(REF_SIST_EXT, Types.VARCHAR);
		
		if (pers.getRefSistExt1()!=null)
			qInsert.setString(REF_SIST_EXT_1, pers.getRefSistExt1());
		else
			qInsert.setNull(REF_SIST_EXT_1, Types.VARCHAR);		
		
		qInsert.executeUpdate();
		qInsert.close();
	}

	protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_ARCH_LOT_CAB = 1;
		final int MODO_TRANSMISION = 2;
		final int TIPO_OPERACION = 3;
		final int FECHA_OPER = 4;
		final int HORA_OPER = 5;
		final int TIPO_TARJETA = 6;
		final int TARJETA = 7;
		final int NRO_TARJETA = 8;
		final int BANDA_MANUAL = 9;
		final int COD_AUTORIZ = 10;
		final int TICKET = 11;
		final int MONEDA = 12;
		final int MONTO = 13;
		final int TIPO_CTA_DEB = 14;
		final int PLAN_Y_CUOTA = 15;
		final int COD_COMERCIO = 16;
		final int NRO_TERMINAL = 17;
		final int TICKET_SEC = 18;
		final int CODIGO_LISTA = 19;
		final int MONTO_SEC = 20;
		final int FECHA_SEC = 21;
		final int FACTURA = 22;
		final int NRO_HOST = 23;
		final int NRO_LOTE = 24;
		final int ACTIVO = 25;
		final int PRESENTADO = 26;
		final int OID_EMPRESA = 27;
		final int OID_UNI_NEG = 28;
		final int FEC_OPER_DATE = 29;
		final int FEC_CIERRE = 30;
		final int FEC_PRESEN_CUPO = 31;
		final int CONCILIADO = 32;
		final int FEC_CONCI = 33;
		final int LIQUIDADO = 34;
		final int FEC_LIQUI = 35;
		final int PRE_CONTABILIZADO = 36;
		final int FEC_PRECONTA = 37;
		final int CONTABILIZADO = 38;
		final int FEC_CONTABILIZADO = 39;
		final int OID_TAR_CONCI = 40;
		final int NRO_TAR_ULT_NROS = 41;
		final int NRO_CONCILIACION = 42;
		final int MARCAR_PRECONCI = 43;
		final int PRECONCI = 44;
		final int OID_USU_MAR_PRE = 45;
		final int OID_CAB_CONCI_AUT = 46;
		final int PRECONCI_DUDOSO = 47;
		final int ALTA_MANUAL = 48;
		final int OID_USU_PRECONCI = 49;
		final int FEC_PRECONCI = 50;
		final int OID_CAB_ASI_ACOB = 51;
		final int ASI_ACOB_CONTA = 52;		
		final int TARJETA_ORI = 53;
		final int MARCA_ASI_ACOB = 54;
		final int CUPON_PERDIDO = 55;
		final int OID_CAB_ASI_LIQ = 56;
		final int MARCA_ASI_LIQ = 57;		
		final int NRO_LIQUIDACION = 58;
		final int CONTA_ASI_LIQ = 59;
		final int REF_SIST_EXT = 60;
		final int REF_SIST_EXT_1 = 61;
		final int OID_ARCH_LOT_DET = 62;

		ArchLoteConciDet pers = (ArchLoteConciDet) objetoPersistente;

		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate
				.append(" update cTarArchLotDet set "
						+ "oid_arch_lot_cab=?"
						+ ",modo_transmision=?"
						+ ",tipo_operacion=?"
						+ ",fecha_oper=?"
						+ ",hora_oper=?"
						+ ",tipo_tarjeta=?"
						+ ",tarjeta=?"
						+ ",nro_tarjeta=?"
						+ ",banda_manual=?"
						+ ",cod_autoriz=?"
						+ ",ticket=?"
						+ ",moneda=?"
						+ ",Monto=?"
						+ ",tipo_cta_deb=?"
						+ ",plan_y_cuota=?"
						+ ",cod_comercio=?"
						+ ",nro_terminal=?"
						+ ",ticket_sec=?"
						+ ",codigo_lista=?"
						+ ",monto_sec=?"
						+ ",fecha_sec=?"
						+ ",factura=?"
						+ ",nro_host=?"
						+ ",nro_lote=?"
						+ ",activo=?"
						+ ",presentado=?"
						+ ",oid_empresa=?"
						+ ",oid_uni_neg=?"
						+ ",fec_oper_date=?"
						+ ",fec_cierre=?"
						+ ",fec_presen_cupo=?"
						+ ",conciliado=?"
						+ ",fec_conciliado=?"
						+ ",liquidado=?"
						+ ",fec_liqui=?"
						+ ",pre_contabilizado=?"
						+ ",fec_preconta=?"
						+ ",contabilizado=?"
						+ ",fec_contabilizado=? "
						+ ",oid_tar_conci=? "
						+ ",nro_tar_ult_nros=? "
						+ ",nro_conciliacion=? "
						+ ",marcar_preconci=? "
						+ ",preconci=? , OID_USU_MAR_PRE = ? ,oid_cab_conci_aut = ? , preconci_dudoso=? , alta_manual = ? , oid_usu_preconci = ? , FEC_PRECONCI = ? , OID_CAB_ASI_ACOB = ?,ASI_ACOB_CONTA = ? , tarjeta_ori = ? , marca_asi_acob = ? , cupon_perdido = ? , oid_cab_asi_liq = ? , marca_asi_liq = ? , nro_liquidacion = ? , conta_asi_liq = ? , ref_sist_ext = ? , ref_sist_ext_1 = ? "
						+ " where " + " oid_arch_lot_det=? ");

		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_ARCH_LOT_DET, pers.getOID());
		if (pers.getArch_lot_cab() != null)
			qUpdate.setInt(OID_ARCH_LOT_CAB, pers.getArch_lot_cab().getOID());
		else
			qUpdate.setNull(OID_ARCH_LOT_CAB, Types.INTEGER);
		qUpdate.setString(MODO_TRANSMISION, pers.getModo_transmision());
		qUpdate.setString(TIPO_OPERACION, pers.getTipo_operacion());
		qUpdate.setString(FECHA_OPER, pers.getFecha_oper());
		qUpdate.setString(HORA_OPER, pers.getHora_oper());
		qUpdate.setString(TIPO_TARJETA, pers.getTipo_tarjeta());
		qUpdate.setString(TARJETA, pers.getTarjeta());
		qUpdate.setString(NRO_TARJETA, pers.getNro_tarjeta());
		qUpdate.setString(BANDA_MANUAL, pers.getBanda_manual());
		qUpdate.setString(COD_AUTORIZ, pers.getCod_autoriz());
		qUpdate.setString(TICKET, pers.getTicket());
		qUpdate.setString(MONEDA, pers.getMoneda());
		qUpdate.setDouble(MONTO, pers.getMonto().doubleValue());
		qUpdate.setString(TIPO_CTA_DEB, pers.getTipo_cta_deb());
		qUpdate.setString(PLAN_Y_CUOTA, pers.getPlan_y_cuota());
		qUpdate.setString(COD_COMERCIO, pers.getCod_comercio());
		qUpdate.setString(NRO_TERMINAL, pers.getNro_terminal());
		qUpdate.setString(TICKET_SEC, pers.getTicket_sec());
		qUpdate.setString(CODIGO_LISTA, pers.getCodigo_lista());
		qUpdate.setDouble(MONTO_SEC, pers.getMonto_sec().doubleValue());
		qUpdate.setString(FECHA_SEC, pers.getFecha_sec());
		qUpdate.setString(FACTURA, pers.getFactura());
		qUpdate.setString(NRO_HOST, pers.getNro_host());
		if (pers.getNro_lote() != null)
			qUpdate.setInt(NRO_LOTE, pers.getNro_lote().intValue());
		else
			qUpdate.setNull(NRO_LOTE, Types.INTEGER);
		qUpdate.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		qUpdate.setBoolean(PRESENTADO, pers.isPresentado().booleanValue());
		qUpdate.setInt(OID_EMPRESA, pers.getEmpresa().getOID());
		if (pers.getUnidad_negocio() != null)
			qUpdate.setInt(OID_UNI_NEG, pers.getUnidad_negocio().getOID());
		else
			qUpdate.setNull(OID_UNI_NEG, Types.INTEGER);

		if (pers.getFecOperDate() != null)
			qUpdate.setDate(FEC_OPER_DATE, new java.sql.Date(pers.getFecOperDate().getTime()));
		else
			qUpdate.setNull(FEC_OPER_DATE, Types.DATE);

		qUpdate.setDate(FEC_CIERRE, new java.sql.Date(pers.getFecCierre().getTime()));

		if (pers.getFecPresenCupo() != null)
			qUpdate.setDate(FEC_PRESEN_CUPO, new java.sql.Date(pers.getFecPresenCupo().getTime()));
		else
			qUpdate.setNull(FEC_PRESEN_CUPO, Types.DATE);

		qUpdate.setBoolean(CONCILIADO, pers.isConciliado());

		if (pers.getFecConciliado() != null)
			qUpdate.setDate(FEC_CONCI, new java.sql.Date(pers.getFecConciliado().getTime()));
		else
			qUpdate.setNull(FEC_CONCI, Types.DATE);

		qUpdate.setBoolean(LIQUIDADO, pers.isLiquidado());

		if (pers.getFecLiquidado() != null)
			qUpdate.setDate(FEC_LIQUI, new java.sql.Date(pers.getFecLiquidado().getTime()));
		else
			qUpdate.setNull(FEC_LIQUI, Types.DATE);

		qUpdate.setBoolean(PRE_CONTABILIZADO, pers.isPreContabilizado());

		if (pers.getFecPreContabilizado() != null)
			qUpdate.setDate(FEC_PRECONTA, new java.sql.Date(pers.getFecPreContabilizado().getTime()));
		else
			qUpdate.setNull(FEC_PRECONTA, Types.DATE);

		qUpdate.setBoolean(CONTABILIZADO, pers.isContabilizado());

		if (pers.getFecContabilizado() != null)
			qUpdate.setDate(FEC_CONTABILIZADO, new java.sql.Date(pers.getFecContabilizado().getTime()));
		else
			qUpdate.setNull(FEC_CONTABILIZADO, Types.DATE);

		if (pers.getTarjetaConciTar() != null)
			qUpdate.setInt(OID_TAR_CONCI, pers.getTarjetaConciTar().getOID());
		else
			qUpdate.setNull(OID_TAR_CONCI, Types.INTEGER);

		if (pers.getUltimosNrosTarjeta() != null)
			qUpdate.setInt(NRO_TAR_ULT_NROS, pers.getUltimosNrosTarjeta().intValue());
		else
			qUpdate.setInt(NRO_TAR_ULT_NROS, 0);

		if (pers.getNroConciliacion() != null)
			qUpdate.setInt(NRO_CONCILIACION, pers.getNroConciliacion().intValue());
		else
			qUpdate.setInt(NRO_CONCILIACION, 0);
		if (pers.isMarcarPreconci() != null)
			qUpdate.setBoolean(MARCAR_PRECONCI, pers.isMarcarPreconci());
		else
			qUpdate.setBoolean(MARCAR_PRECONCI, false);
		if (pers.isPreconci() != null)
			qUpdate.setBoolean(PRECONCI, pers.isPreconci());
		else
			qUpdate.setBoolean(PRECONCI, false);
		if (pers.getUsuarioMarcaPreconci() != null)
			qUpdate.setInt(OID_USU_MAR_PRE, pers.getUsuarioMarcaPreconci().getOID());
		else
			qUpdate.setNull(OID_USU_MAR_PRE, Types.INTEGER);
		if (pers.getCabConciAut() != null)
			qUpdate.setInt(OID_CAB_CONCI_AUT, pers.getCabConciAut().getOID());
		else
			qUpdate.setNull(OID_CAB_CONCI_AUT, Types.INTEGER);

		if (pers.isPreconciDudoso() != null)
			qUpdate.setBoolean(PRECONCI_DUDOSO, pers.isPreconciDudoso().booleanValue());
		else
			qUpdate.setBoolean(PRECONCI_DUDOSO, false);
		qUpdate.setBoolean(ALTA_MANUAL, pers.isAltaManual().booleanValue());
		if (pers.getUsuarioPreconci() == null)
			qUpdate.setNull(OID_USU_PRECONCI, java.sql.Types.INTEGER);
		else
			qUpdate.setInt(OID_USU_PRECONCI, pers.getUsuarioPreconci().getOID());
		if (pers.getFecPreconci() == null)
			qUpdate.setNull(FEC_PRECONCI, java.sql.Types.DATE);
		else
			qUpdate.setDate(FEC_PRECONCI, new java.sql.Date(pers.getFecPreconci().getTime()));
		
		if (pers.getAsientoACobrar()!=null)
			qUpdate.setInt(OID_CAB_ASI_ACOB, pers.getAsientoACobrar().getOID());
		else
			qUpdate.setNull(OID_CAB_ASI_ACOB, Types.INTEGER);
		
		if (pers.isContaAsientoACobrar()!=null)
			qUpdate.setBoolean(ASI_ACOB_CONTA, pers.isContaAsientoACobrar().booleanValue());
		else
			qUpdate.setBoolean(ASI_ACOB_CONTA, false);
		
		if (pers.getTarjetaOri()!=null)
			qUpdate.setString(TARJETA_ORI, pers.getTarjetaOri());
		else
			qUpdate.setString(TARJETA_ORI, "");
		
		if (pers.isMarcaAsiACobrar()!=null)
			qUpdate.setBoolean(MARCA_ASI_ACOB, pers.isMarcaAsiACobrar().booleanValue());
		else
			qUpdate.setBoolean(MARCA_ASI_ACOB, false);
		
		if (pers.isCuponPerdido()!=null)
			qUpdate.setBoolean(CUPON_PERDIDO, pers.isCuponPerdido().booleanValue());
		else
			qUpdate.setBoolean(CUPON_PERDIDO, false);
		
		if (pers.getCabAsiLiquiTarj()!=null)
			qUpdate.setInt(OID_CAB_ASI_LIQ, pers.getCabAsiLiquiTarj().getOID());
		else
			qUpdate.setNull(OID_CAB_ASI_LIQ, Types.INTEGER);
		
		if (pers.isMarcaAsiLiq()!=null)
			qUpdate.setBoolean(MARCA_ASI_LIQ, pers.isMarcaAsiLiq().booleanValue());
		else
			qUpdate.setBoolean(MARCA_ASI_LIQ, false);
		
		if (pers.getNroLiquidacion()!=null)
			qUpdate.setInt(NRO_LIQUIDACION, pers.getNroLiquidacion());
		else
			qUpdate.setNull(NRO_LIQUIDACION, Types.INTEGER);
		
		if (pers.isContaAsiLiq()!=null)
			qUpdate.setBoolean(CONTA_ASI_LIQ, pers.isContaAsiLiq().booleanValue());
		else
			qUpdate.setBoolean(CONTA_ASI_LIQ, false);
		
		if (pers.getRefSistExt()!=null)
			qUpdate.setString(REF_SIST_EXT, pers.getRefSistExt());
		else
			qUpdate.setNull(REF_SIST_EXT, Types.VARCHAR);	
		
		if (pers.getRefSistExt1()!=null)
			qUpdate.setString(REF_SIST_EXT_1, pers.getRefSistExt1());
		else
			qUpdate.setNull(REF_SIST_EXT_1, Types.VARCHAR);		

		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_ARCH_LOT_DET = 1;
		ArchLoteConciDet pers = (ArchLoteConciDet) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update cTarArchLotDet " + " set activo=0 " + " where " + " oid_arch_lot_det=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_ARCH_LOT_DET, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_ARCH_LOT_DET = 1;
		ArchLoteConciDet pers = (ArchLoteConciDet) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update cTarArchLotDet " + " set activo=1 " + " where " + " oid_arch_lot_det=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_ARCH_LOT_DET, pers.getOID());
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
		case SELECT_BY_ARCH_CONC_CAB: {
			ps = this.selectByArchConciCAB(aCondiciones);
			break;
		}
		case SELECT_BY_CONDICIONES: {
			ps = this.selectByCondiciones(aCondiciones);
			break;
		}
		case UPDATE_PRESENTADO: {
			ps = this.updatePresentadoEn(aCondiciones);
			break;
		}
		case UPDATE_ANULAR_ARCH: {
			ps = this.updateAnularArchivo(aCondiciones);
			break;
		}
		case MARCAR_COMO_PRECONCI: {
			ps = this.marcarComoPreconci(aCondiciones);
			break;
		}
		case MARCAR_COMO_NO_PRECONCI: {
			ps = this.marcarComoNoPreconci(aCondiciones);
			break;
		}
		case SELECT_MARCADA_BY_EMPRESA_USU: {
			ps = this.marcadaEmpresaUsu(aCondiciones);
			break;
		}
		case GENERAR_PRECONCILIACION: {
			ps = this.generarPreconciliacion(aCondiciones);
			break;
		}
		case SELECT_PRECONCI_EMPRESA_USU: {
			ps = this.selectByPreConciEmpresaUsu(aCondiciones);
			break;
		}
		case MARCAR_COMO_CONCILIADO: {
			ps = this.marcarComoConciliado(aCondiciones);
			break;
		}
		case BUSCAR_PARA_CONCILIAR: {
			ps = this.buscarParaConciliar(aCondiciones);
			break;
		}
		case MARCAR_COMO_PERDIDO: {
			ps = this.marcarComoPerdido(aCondiciones);
			break;
		}		
		case MARCAR_COMO_NO_PERDIDO: {
			ps = this.marcarComoNoPerdido(aCondiciones);
			break;
		}		
		case SELECT_BY_EMP_NRO_CONCI: {
			ps = this.selectByEmpyNroConci(aCondiciones);
			break;
		}
		case SELECT_BY_EMP_ACTIVO_CONCI_NRO: {
			ps = this.selectByEmpActivoConciNro(aCondiciones);
			break;
		}
		case SELECT_BY_EMP_ACTIVO_CONCI_AUT: {
			ps = this.selectByEmpActivoConciAut(aCondiciones);
			break;
		}
		case MARCAR_ASI_PARA_COB: {
			ps = this.marcarAsiParaCobranza(aCondiciones);
			break;			
		}
		case MARCAR_ASI_PARA_LIQ: {
			ps = this.marcarAsiParaLiquidacion(aCondiciones);
			break;			
		}		
		case DESMARCAR_ASI_PARA_COB: {
			ps = this.desmarcarAsiParaCobranza(aCondiciones);
			break;			
		}	
		case DESMARCAR_ASI_PARA_LIQ: {
			ps = this.desmarcarAsiParaLiquidacion(aCondiciones);
			break;			
		}		
		case SELECT_MARCA_ASI_ACOB_NO_CONTA: {
			ps = this.marcarAsiACobNoConta(aCondiciones);
			break;			
		}
		case SELECT_ASI_COB_CONTA_SEGUN_NRO  : {
			ps = this.selectAsiCobContaSegunNro(aCondiciones);
			break;			
		}
		case SELECT_MARCAR_ASI_LIQ_NO_CONTA: {
			ps = this.selectMarcarAsiLiqNoConta(aCondiciones);
			break;			
		}
		case SELECT_BY_CONTA_ASI_LIQ: {
			ps = this.selectByContaAsiLiq(aCondiciones);
			break;			
		}
		case SELECT_ASI_LIQ_CONTA_SEGUN_NRO  : {
			ps = this.selectAsiLiqContaSegunNro(aCondiciones);
			break;			
		}	
		case SELECT_BY_ASI_COB: {
			ps = this.selectByAsiCobranza(aCondiciones);
			break;			
		}
		case SELECT_BY_ASI_LIQ: {
			ps = this.selectByAsiLiquidacion(aCondiciones);
			break;			
		}		
		}
		return ps;
	}

	private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

		final int OID_ARCH_LOT_DET = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cTarArchLotDet ");
		textSQL.append(" WHERE oid_arch_lot_det = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		int oid = ((Integer) aCondiciones).intValue();
		querySelect.setInt(OID_ARCH_LOT_DET, oid);
		return querySelect;
	}

	private PreparedStatement selectByCondiciones(Object aCondiciones) throws BaseException, SQLException {
		int param = 0;
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cTarArchLotDet ");
		textSQL.append(" WHERE activo=1 ");

		HashTableDatos condiciones = (HashTableDatos) aCondiciones;

		java.util.Date fecCierreDesde = (java.util.Date) condiciones.get("FEC_CIERRE_DESDE");
		if (fecCierreDesde != null)
			textSQL.append(" and fec_cierre>=? ");

		java.util.Date fecCierreHasta = (java.util.Date) condiciones.get("FEC_CIERRE_HASTA");
		if (fecCierreHasta != null)
			textSQL.append(" and fec_cierre<=? ");

		java.util.Date fecOperDesde = (java.util.Date) condiciones.get("FEC_OPER_DESDE");
		if (fecOperDesde != null)
			textSQL.append(" and fec_oper_date>=? ");

		java.util.Date fecOperHasta = (java.util.Date) condiciones.get("FEC_OPER_HASTA");
		if (fecOperHasta != null)
			textSQL.append(" and fec_oper_date<=? ");

		java.util.Date fecPresenDesde = (java.util.Date) condiciones.get("FEC_PRESEN_DESDE");
		if (fecPresenDesde != null)
			textSQL.append(" and fec_presen_cupo>=? ");

		java.util.Date fecPresenHasta = (java.util.Date) condiciones.get("FEC_PRESEN_HASTA");
		if (fecPresenHasta != null)
			textSQL.append(" and fec_presen_cupo<=? ");

		TarjetaConciTar tarjeta = (TarjetaConciTar) condiciones.get(TarjetaConciTar.NICKNAME);
		if (tarjeta != null)
			textSQL.append(" and oid_tar_conci=" + tarjeta.getOIDInteger() + " ");

		if (condiciones.containsKey(EmpresaConciTar.NICKNAME)) {
			EmpresaConciTar empresa = (EmpresaConciTar) condiciones.get(EmpresaConciTar.NICKNAME);
			textSQL.append(" and oid_empresa=" + empresa.getOIDInteger() + " ");
		}

		String pendGenAsiCob = (String) condiciones.get("PEND_GEN_ASI_COB");
		if (pendGenAsiCob!=null) {
			if (pendGenAsiCob.equals("SI"))
				textSQL.append(" and asi_acob_conta=0 ");
			else if (pendGenAsiCob.equals("NO"))
				textSQL.append(" and asi_acob_conta=1 ");
		}	
		
		
		
		String cupoPresentado = (String) condiciones.get("CUPO_PRESENTADO");
		if (cupoPresentado.equals("SI"))
			textSQL.append(" and presentado=1 ");
		else if (cupoPresentado.equals("NO"))
			textSQL.append(" and presentado=0 ");

		if (condiciones.containsKey("PEND_CONCI") || condiciones.containsKey("CONCI_SIN_CONF") || condiciones.containsKey("CONCI_CONF")) {

			textSQL.append(" and ( ");

			boolean condPrevia = false;

			if (condiciones.containsKey("PEND_CONCI")) {

				textSQL.append(" ( ");
				textSQL.append(" preconci=0 ");
				textSQL.append(" ) ");

				condPrevia = true;
			}

			if (condiciones.containsKey("CONCI_SIN_CONF")) {
				if (condPrevia)
					textSQL.append(" or ");
				condPrevia = true;
				textSQL.append(" ( ");
				textSQL.append(" preconci=1 and conciliado=0 ");

				if (condiciones.containsKey("FEC_DESDE_CONCI_SIN_CONF")) {
					textSQL.append(" and fec_preconci>=? ");
				}
				if (condiciones.containsKey("FEC_HASTA_CONCI_SIN_CONF")) {
					textSQL.append(" and fec_preconci<=? ");
				}

				textSQL.append(" ) ");

			}

			if (condiciones.containsKey("CONCI_CONF")) {
				if (condPrevia)
					textSQL.append(" or ");
				condPrevia = true;
				textSQL.append(" ( ");
				textSQL.append(" conciliado=1 ");
				if (condiciones.containsKey("FEC_DESDE_CONF")) {
					textSQL.append(" and fec_conciliado>=? ");
				}
				if (condiciones.containsKey("FEC_HASTA_CONF")) {
					textSQL.append(" and fec_conciliado<=? ");
				}
				textSQL.append(" ) ");
			}

			textSQL.append(" ) ");

			if (condiciones.containsKey("ORDER_BY_NRO_CONCI"))
				textSQL.append(" order by nro_conciliacion ");

		}

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());

		if (fecCierreDesde != null) {
			++param;
			querySelect.setDate(param, new java.sql.Date(fecCierreDesde.getTime()));
		}

		if (fecCierreHasta != null) {
			++param;
			querySelect.setDate(param, new java.sql.Date(fecCierreHasta.getTime()));
		}

		if (fecOperDesde != null) {
			++param;
			querySelect.setDate(param, new java.sql.Date(fecOperDesde.getTime()));
		}

		if (fecOperHasta != null) {
			++param;
			querySelect.setDate(param, new java.sql.Date(fecOperHasta.getTime()));
		}

		if (fecPresenDesde != null) {
			++param;
			querySelect.setDate(param, new java.sql.Date(fecPresenDesde.getTime()));
		}

		if (fecPresenHasta != null) {
			++param;
			querySelect.setDate(param, new java.sql.Date(fecPresenHasta.getTime()));
		}

		if (condiciones.containsKey("CONCI_SIN_CONF")) {
			if (condiciones.containsKey("FEC_DESDE_CONCI_SIN_CONF")) {
				++param;
				querySelect.setDate(param, new java.sql.Date(((java.util.Date) condiciones.get("FEC_DESDE_CONCI_SIN_CONF")).getTime()));
			}
			if (condiciones.containsKey("FEC_HASTA_CONCI_SIN_CONF")) {
				++param;
				querySelect.setDate(param, new java.sql.Date(((java.util.Date) condiciones.get("FEC_HASTA_CONCI_SIN_CONF")).getTime()));
			}
		}

		if (condiciones.containsKey("CONCI_CONF")) {
			if (condiciones.containsKey("FEC_DESDE_CONF")) {
				++param;
				querySelect.setDate(param, new java.sql.Date(((java.util.Date) condiciones.get("FEC_DESDE_CONF")).getTime()));
			}
			if (condiciones.containsKey("FEC_HASTA_CONF")) {
				++param;
				querySelect.setDate(param, new java.sql.Date(((java.util.Date) condiciones.get("FEC_HASTA_CONF")).getTime()));
			}
		}

		return querySelect;
	}

	private PreparedStatement selectByArchConciCAB(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cTarArchLotDet ");
		textSQL.append(" WHERE oid_arch_lot_cab = ? and activo=1 ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		ArchLoteConciCab archLoteConciCab = (ArchLoteConciCab) aCondiciones;
		querySelect.setInt(1, archLoteConciCab.getOID());
		return querySelect;
	}
	
	private PreparedStatement selectMarcarAsiLiqNoConta(Object aCondiciones) throws BaseException, SQLException {
		
		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT a.* FROM  cTarArchLotDet a ");
		textSQL.append(" WHERE a.activo=1 and a.oid_empresa = ? and a.marca_asi_liq=1 and a.conta_asi_liq=0 "); //and a.asi_acob_conta=1  ");
		
		if (condiciones.containsKey("SOLO_MIS_MARCADOS")) {
			textSQL.append(" and oid_usu_mar_liq="+this.getSesion().getLogin().getUsuario().getOIDInteger()+" "); 
		}
		
		textSQL.append(" and a.oid_tar_conci in (select oid_tar_conci from cTarTarjModLiq where activo=1 and oid_empresa=? and oid_modelo_liq=?) "); 
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		
		EmpresaConciTar empresa = (EmpresaConciTar) condiciones.get(EmpresaConciTar.NICKNAME);
		CabModeloLiq cabModeloLiq = (CabModeloLiq) condiciones.get(CabModeloLiq.NICKNAME);
		querySelect.setInt(1, empresa.getOID());
		querySelect.setInt(2, empresa.getOID());
		querySelect.setInt(3, cabModeloLiq.getOID());
		return querySelect;
	}	
	
	private PreparedStatement selectByAsiCobranza(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cTarArchLotDet ");
		textSQL.append(" WHERE oid_cab_asi_acob = ? and activo=1 "); 
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		CabAsiTarjACobrar cabAsiCob = (CabAsiTarjACobrar) aCondiciones;
		querySelect.setInt(1, cabAsiCob.getOID());
		return querySelect;
	}	
	
	private PreparedStatement selectByAsiLiquidacion(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cTarArchLotDet ");
		textSQL.append(" WHERE oid_cab_asi_liq = ? and activo=1 "); 
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		CabAsiLiquiTarj cabAsiLiq = (CabAsiLiquiTarj) aCondiciones;
		querySelect.setInt(1, cabAsiLiq.getOID());
		return querySelect;
	}	
	
	
	
	private PreparedStatement selectAsiLiqContaSegunNro(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cTarArchLotDet ");
		textSQL.append(" WHERE oid_cab_asi_liq = ? and activo=1 ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		Integer oidCabAsiLiq = (Integer) aCondiciones;
		querySelect.setInt(1, oidCabAsiLiq.intValue());
		return querySelect;
	}	
	
	private PreparedStatement selectAsiCobContaSegunNro(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cTarArchLotDet ");
		textSQL.append(" WHERE oid_cab_asi_acob = ? and activo=1 ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		Integer oidCabAsiACob = (Integer) aCondiciones;
		querySelect.setInt(1, oidCabAsiACob.intValue());
		return querySelect;
	}	
	
	
	private PreparedStatement selectByContaAsiLiq(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cTarArchLotDet ");
		textSQL.append(" WHERE activo=1 and conta_asi_liq=1 and oid_cab_asi_liq=? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		CabAsiLiquiTarj cabAsiLiqTarj = (CabAsiLiquiTarj) aCondiciones;
		querySelect.setInt(1, cabAsiLiqTarj.getOID());
		return querySelect;
	}	
	
	

	private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

		final int CODIGO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cTarArchLotDet ");
		textSQL.append(" WHERE  = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		String codigo = (String) aCondiciones;
		querySelect.setString(CODIGO, codigo);
		return querySelect;
	}

	private PreparedStatement generarPreconciliacion(Object aCondiciones) throws BaseException, SQLException {

		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		ArchLoteConciDet archLoteConciDet = (ArchLoteConciDet) condiciones.get(ArchLoteConciDet.NICKNAME);
		Integer nroConciliacion = (Integer) condiciones.get("NRO_CONCILIACION");
		Boolean dudoso = (Boolean) condiciones.get("DUDOSO");

		StringBuffer textSQL = new StringBuffer();
		textSQL.append(" update cTarArchLotDet ");
		textSQL.append(" 	set preconci = 1 , ");
		textSQL.append(" 	oid_usu_preconci=" + this.getSesion().getLogin().getUsuario().getOID() + ",");
		textSQL.append(" 	fec_preconci=?,");
		if (dudoso.booleanValue())
			textSQL.append(" 	preconci_dudoso=1,");
		else
			textSQL.append(" 	preconci_dudoso=0,");
		textSQL.append("    nro_conciliacion=" + nroConciliacion);

		if (condiciones.containsKey(CabConciAutomatica.NICKNAME)) {
			CabConciAutomatica cabConciAutomatica = (CabConciAutomatica) condiciones.get(CabConciAutomatica.NICKNAME);
			textSQL.append("  , oid_cab_conci_aut=" + cabConciAutomatica.getOID() + " ");
		}

		textSQL.append(" where ");
		textSQL.append("  oid_arch_lot_det=" + archLoteConciDet.getOIDInteger());
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		querySelect.setDate(1, new java.sql.Date(UtilCIP.getFechaHoraActual(this.getSesion()).getTime()));
		querySelect.executeUpdate();
		querySelect.close();

		return null;
	}

	private PreparedStatement marcarComoConciliado(Object aCondiciones) throws BaseException, SQLException {

		ArchLoteConciDet archLoteConciDet = (ArchLoteConciDet) aCondiciones;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update cTarArchLotDet " + " set conciliado=1 , fec_conciliado = ? " + " where " + " oid_arch_lot_det="
				+ archLoteConciDet.getOIDInteger());
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setDate(1, new java.sql.Date(UtilCIP.getFechaHoraActual(this.getSesion()).getTime()));
		qUpdate.executeUpdate();
		qUpdate.close();
		return null;
	}

	private PreparedStatement marcadaEmpresaUsu(Object aCondiciones) throws BaseException, SQLException {

		HashTableDatos condiciones = (HashTableDatos) aCondiciones;

		EmpresaConciTar empresa = (EmpresaConciTar) condiciones.get(EmpresaConciTar.NICKNAME);
		Usuario usuario = (Usuario) condiciones.get(Usuario.NICKNAME);

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cTarArchLotDet ");
		textSQL.append(" WHERE ");
		textSQL.append(" marcar_preconci = 1 and preconci=0 ");
		textSQL.append(" and oid_empresa = " + empresa.getOIDInteger());
		if (usuario != null)
			textSQL.append(" and oid_usu_mar_pre = " + usuario.getOIDInteger());
		textSQL.append(" and activo=1 ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}

	private PreparedStatement buscarParaConciliar(Object aCondiciones) throws BaseException, SQLException {

		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		EmpresaConciTar empresa = (EmpresaConciTar) condiciones.get(EmpresaConciTar.NICKNAME);
		String tipoOperacion = (String) condiciones.get("TIPO_OPERACION");
		String tipoTarjeta = (String) condiciones.get("TIPO_TARJETA");
		java.util.Date fecha = (java.util.Date) condiciones.get("FECHA_ORIGEN");
		String tarjeta = (String) condiciones.get("TARJETA");
		Integer nroTarjeta = (Integer) condiciones.get("NRO_TARJETA");
		Double monto = (Double) condiciones.get("MONTO");
		Integer lote = (Integer) condiciones.get("LOTE");
		Integer diasTolerancia = (Integer) condiciones.get("DIAS_TOL_FEC_CONCI");

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * ");
		textSQL.append(" from cTarArchLotDet where activo=1 and preconci=0 ");
		textSQL.append(" and oid_empresa=" + empresa.getOIDInteger() + " ");

		if ((tipoOperacion != null) && (!tipoOperacion.equals("*")))
			textSQL.append(" and tipo_operacion=? ");

		textSQL.append(" and tipo_tarjeta=? ");

		textSQL.append(" and tarjeta=? ");

		if (nroTarjeta != null) {
			if ((tarjeta != null) && (!tarjeta.equals(TarjetaConciTar.MAESTRO))) {
				textSQL.append(" and nro_tar_ult_nros=" + nroTarjeta.intValue() + " ");
			} else {
				// ARMAR ALGORITMO
				String sinUltDig = nroTarjeta.toString().substring(0, nroTarjeta.toString().length() - 1);
				int nroTarjEntero = 0;
				try {
					nroTarjEntero = new Integer(sinUltDig);
				} catch (Exception e) {
				}
				textSQL.append(" and abs(((trunc(nro_tar_ult_nros/100,0)-(nro_tar_ult_nros/100))*100))= " + nroTarjEntero + " ");
			}
		}

		textSQL.append(" and monto=? ");
		if (lote != null)
			textSQL.append(" and nro_lote=" + lote.intValue() + " ");
		if (diasTolerancia.intValue() == 0)
			textSQL.append(" and fec_oper_date=? ");
		else {
			textSQL.append(" and fec_oper_date>=? ");
			textSQL.append(" and fec_oper_date<=? ");
		}
		textSQL.append(" order by fec_oper_date desc ");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		int params = 0;

		if ((tipoOperacion != null) && (!tipoOperacion.equals("*"))) {
			++params;
			querySelect.setString(params, tipoOperacion);
		}

		++params;
		querySelect.setString(params, tipoTarjeta);
		++params;
		querySelect.setString(params, tarjeta);
		++params;
		querySelect.setDouble(params, monto);
		if (diasTolerancia.intValue() == 0) {
			++params;
			querySelect.setDate(params, new java.sql.Date(fecha.getTime()));
		} else {

			java.util.Date fecDesde = Fecha.getFechaMasDias(fecha, diasTolerancia.intValue() * -1);
			java.util.Date fecHasta = Fecha.getFechaMasDias(fecha, diasTolerancia);

			++params;
			querySelect.setDate(params, new java.sql.Date(fecDesde.getTime()));
			++params;
			querySelect.setDate(params, new java.sql.Date(fecHasta.getTime()));
		}

		return querySelect;
	}

	
	private PreparedStatement marcarAsiACobNoConta(Object aCondiciones) throws BaseException, SQLException {

		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		EmpresaConciTar empresa = (EmpresaConciTar) condiciones.get(EmpresaConciTar.NICKNAME);
		
		boolean soloMisMarcados = false;
		if (condiciones.containsKey("SOLO_MIS_MARCADOS"))
			soloMisMarcados = true;
		
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * ");
		textSQL.append(" from cTarArchLotDet where activo=1 ");
		textSQL.append(" and oid_empresa=" + empresa.getOIDInteger() + " and marca_asi_acob = 1 and asi_acob_conta = 0 ");
		if (soloMisMarcados)
			textSQL.append("  and oid_usu_mar_cob="+this.getSesion().getLogin().getUsuario().getOIDInteger().toString()+" ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;

	}	
	
	
	private PreparedStatement selectByEmpActivoConciAut(Object aCondiciones) throws BaseException, SQLException {

		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		EmpresaConciTar empresa = (EmpresaConciTar) condiciones.get(EmpresaConciTar.NICKNAME);
		CabConciAutomatica cabConciAut = (CabConciAutomatica) condiciones.get(CabConciAutomatica.NICKNAME);

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * ");
		textSQL.append(" from cTarArchLotDet where activo=1 ");
		textSQL.append(" and oid_empresa=" + empresa.getOIDInteger() + " and oid_cab_conci_aut =" + cabConciAut.getOID()
				+ " and preconci=1 ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;

	}

	private PreparedStatement selectByEmpActivoConciNro(Object aCondiciones) throws BaseException, SQLException {

		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		EmpresaConciTar empresa = (EmpresaConciTar) condiciones.get(EmpresaConciTar.NICKNAME);
		Integer nroConciliacion = (Integer) condiciones.get("NRO_CONCILIACION");

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * ");
		textSQL.append(" from cTarArchLotDet where activo=1 ");
		textSQL.append(" and oid_empresa=" + empresa.getOIDInteger() + " and nro_conciliacion =" + nroConciliacion.intValue()
				+ " and preconci=1 ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}

	private PreparedStatement selectByEmpyNroConci(Object aCondiciones) throws BaseException, SQLException {

		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		EmpresaConciTar empresa = (EmpresaConciTar) condiciones.get(EmpresaConciTar.NICKNAME);
		Integer nroConciliacion = (Integer) condiciones.get("NRO_CONCILIACION");

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * ");
		textSQL.append(" from cTarArchLotDet where activo=1 ");
		textSQL.append(" and oid_empresa=" + empresa.getOIDInteger() + " and nro_conciliacion =" + nroConciliacion.intValue());
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}

	private PreparedStatement selectByPreConciEmpresaUsu(Object aCondiciones) throws BaseException, SQLException {

		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		EmpresaConciTar empresa = (EmpresaConciTar) condiciones.get(EmpresaConciTar.NICKNAME);
		Usuario usuario = (Usuario) condiciones.get(Usuario.NICKNAME);

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * ");
		textSQL.append(" from cTarArchLotDet where activo=1 and preconci=1 and conciliado=0 ");
		textSQL.append(" and oid_empresa=" + empresa.getOIDInteger() + " ");
		if (usuario != null)
			textSQL.append(" and oid_usu_preconci=" + usuario.getOIDInteger() + " ");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}

	private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();

		textSQL.append("SELECT oid_arch_lot_det oid, codigo,  descripcion ,activo ");
		textSQL.append(" from cTarArchLotDet");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}

	public static List getArchLoteconciDet(ArchLoteConciCab archLoteConciCab, ISesion aSesion) throws BaseException {
		return (List) ObjetoLogico.getObjects(ArchLoteConciDet.NICKNAME, DBArchLoteConciDet.SELECT_BY_ARCH_CONC_CAB, archLoteConciCab,
				new ListObserver(), aSesion);
	}

	public static List getAllByCondiciones(HashTableDatos condiciones, ISesion aSesion) throws BaseException {
		return (List) ObjetoLogico.getObjects(ArchLoteConciDet.NICKNAME, DBArchLoteConciDet.SELECT_BY_CONDICIONES, condiciones,
				new ListObserver(), aSesion);
	}

	private PreparedStatement marcarComoPreconci(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update cTarArchLotDet set marcar_preconci=1 , oid_usu_mar_pre="
				+ this.getSesion().getLogin().getUsuario().getOID() + " " + " where oid_arch_lot_det=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		ArchLoteConciDet archivoDet = (ArchLoteConciDet) aCondiciones;
		qUpdate.setInt(1, archivoDet.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
		return null;
	}
	
	private PreparedStatement marcarComoPerdido(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update cTarArchLotDet set cupon_perdido=1 where oid_arch_lot_det=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		ArchLoteConciDet archivoDet = (ArchLoteConciDet) aCondiciones;
		qUpdate.setInt(1, archivoDet.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
		return null;
	}	
	
	private PreparedStatement marcarAsiParaLiquidacion(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update cTarArchLotDet set marca_asi_liq=1 , oid_usu_mar_liq="+this.getSesion().getLogin().getUsuario().getOIDInteger().toString()+" where oid_arch_lot_det=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		ArchLoteConciDet archivoDet = (ArchLoteConciDet) aCondiciones;
		qUpdate.setInt(1, archivoDet.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
		return null;
	}	
	
	
	private PreparedStatement marcarAsiParaCobranza(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update cTarArchLotDet set marca_asi_acob=1 , oid_usu_mar_cob="+this.getSesion().getLogin().getUsuario().getOIDInteger().toString()+" where oid_arch_lot_det=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		ArchLoteConciDet archivoDet = (ArchLoteConciDet) aCondiciones;
		qUpdate.setInt(1, archivoDet.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
		return null;
	}	

	private PreparedStatement desmarcarAsiParaLiquidacion(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update cTarArchLotDet set marca_asi_liq=0 , oid_usu_mar_liq = null  where oid_arch_lot_det=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		ArchLoteConciDet archivoDet = (ArchLoteConciDet) aCondiciones;
		qUpdate.setInt(1, archivoDet.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
		return null;
	}	
	
	
	
	
	private PreparedStatement desmarcarAsiParaCobranza(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update cTarArchLotDet set marca_asi_acob=0 , oid_usu_mar_cob = null  where oid_arch_lot_det=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		ArchLoteConciDet archivoDet = (ArchLoteConciDet) aCondiciones;
		qUpdate.setInt(1, archivoDet.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
		return null;
	}	
	
	
	private PreparedStatement marcarComoNoPerdido(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update cTarArchLotDet set cupon_perdido=0 where oid_arch_lot_det=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		ArchLoteConciDet archivoDet = (ArchLoteConciDet) aCondiciones;
		qUpdate.setInt(1, archivoDet.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
		return null;
	}	

	private PreparedStatement marcarComoNoPreconci(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update cTarArchLotDet set marcar_preconci=0 , oid_usu_mar_pre="
				+ this.getSesion().getLogin().getUsuario().getOID() + " where oid_arch_lot_det=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		ArchLoteConciDet archivoDet = (ArchLoteConciDet) aCondiciones;
		qUpdate.setInt(1, archivoDet.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
		return null;
	}

	private PreparedStatement updateAnularArchivo(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update cTarArchLotDet set activo=0 where oid_arch_lot_cab=? and activo = 1 ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		ArchLoteConciCab archivoCab = (ArchLoteConciCab) aCondiciones;
		qUpdate.setInt(1, archivoCab.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
		return null;
	}

	private PreparedStatement updatePresentadoEn(Object aCondiciones) throws BaseException, SQLException {
		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update cTarArchLotDet " + " set presentado=? , fec_presen_cupo = ? " + " where " + " oid_arch_lot_det=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		Integer presentado = (Integer) condiciones.get("PRESENTADO");
		ArchLoteConciDet archLoteConciDet = (ArchLoteConciDet) condiciones.get(ArchLoteConciDet.NICKNAME);
		qUpdate.setInt(1, presentado);
		if (presentado.intValue() == 1)
			qUpdate.setDate(2, new java.sql.Date(Fecha.getFechaActual().getTime()));
		else
			qUpdate.setNull(2, Types.DATE);
		qUpdate.setInt(3, archLoteConciDet.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
		return null;

	}

	public static void actuMarcaPresentado(ArchLoteConciDet archLoteConciDet, boolean presentado, ISesion aSesion) throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();

		Integer valor = 0;
		if (presentado)
			valor = 1;
		condiciones.put("PRESENTADO", valor);
		condiciones.put(ArchLoteConciDet.NICKNAME, archLoteConciDet);
		ObjetoLogico.getObjects(ArchLoteConciDet.NICKNAME, DBArchLoteConciDet.UPDATE_PRESENTADO, condiciones, null, aSesion);
	}

	public static void generarPreconciliacion(ArchLoteConciDet archLoteConciDet, HashTableDatos condiciones, ISesion aSesion)
			throws BaseException {
		condiciones.put(ArchLoteConciDet.NICKNAME, archLoteConciDet);
		ObjetoLogico.getObjects(ArchLoteConciDet.NICKNAME, DBArchLoteConciDet.GENERAR_PRECONCILIACION, condiciones, null, aSesion);
	}

	public static void anularDetallesDelArchivo(ArchLoteConciCab archLoteConciCab, ISesion aSesion) throws BaseException {
		ObjetoLogico.getObjects(ArchLoteConciDet.NICKNAME, DBArchLoteConciDet.UPDATE_ANULAR_ARCH, archLoteConciCab, null, aSesion);
	}

	public static void marcarComoPreconci(ArchLoteConciDet archLoteConciDet, ISesion aSesion) throws BaseException {
		ObjetoLogico.getObjects(ArchLoteConciDet.NICKNAME, DBArchLoteConciDet.MARCAR_COMO_PRECONCI, archLoteConciDet, null, aSesion);
	}
	
	public static void marcarAsientoParaCobranza(ArchLoteConciDet archLoteConciDet, ISesion aSesion) throws BaseException {
		ObjetoLogico.getObjects(ArchLoteConciDet.NICKNAME, DBArchLoteConciDet.MARCAR_ASI_PARA_COB, archLoteConciDet, null, aSesion);
	}
	
	public static void marcarAsientoParaLiquidacion(ArchLoteConciDet archLoteConciDet, ISesion aSesion) throws BaseException {
		ObjetoLogico.getObjects(ArchLoteConciDet.NICKNAME, DBArchLoteConciDet.MARCAR_ASI_PARA_LIQ, archLoteConciDet, null, aSesion);
	}	
	
	
	
	public static void desmarcarAsientoParaCobranza(ArchLoteConciDet archLoteConciDet, ISesion aSesion) throws BaseException {
		ObjetoLogico.getObjects(ArchLoteConciDet.NICKNAME, DBArchLoteConciDet.DESMARCAR_ASI_PARA_COB, archLoteConciDet, null, aSesion);
	}		
	
	public static void desmarcarAsientoParaLiquidacion(ArchLoteConciDet archLoteConciDet, ISesion aSesion) throws BaseException {
		ObjetoLogico.getObjects(ArchLoteConciDet.NICKNAME, DBArchLoteConciDet.DESMARCAR_ASI_PARA_LIQ, archLoteConciDet, null, aSesion);
	}	
	
	
	
	public static void marcarComoPerdido(ArchLoteConciDet archLoteConciDet, ISesion aSesion) throws BaseException {
		ObjetoLogico.getObjects(ArchLoteConciDet.NICKNAME, DBArchLoteConciDet.MARCAR_COMO_PERDIDO, archLoteConciDet, null, aSesion);
	}
	
	public static void marcarComoNoPerdido(ArchLoteConciDet archLoteConciDet, ISesion aSesion) throws BaseException {
		ObjetoLogico.getObjects(ArchLoteConciDet.NICKNAME, DBArchLoteConciDet.MARCAR_COMO_NO_PERDIDO, archLoteConciDet, null, aSesion);
	}		

	public static void marcarComoConciliado(ArchLoteConciDet archLoteConciDet, ISesion aSesion) throws BaseException {
		ObjetoLogico.getObjects(ArchLoteConciDet.NICKNAME, DBArchLoteConciDet.MARCAR_COMO_CONCILIADO, archLoteConciDet, null, aSesion);
	}

	public static void marcarComoNoPreconci(ArchLoteConciDet archLoteConciDet, ISesion aSesion) throws BaseException {
		ObjetoLogico.getObjects(ArchLoteConciDet.NICKNAME, DBArchLoteConciDet.MARCAR_COMO_NO_PRECONCI, archLoteConciDet, null, aSesion);
	}

	public static List getMarcadosPorEmpresaUsu(EmpresaConciTar empresa, Usuario usuario, ISesion aSesion) throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put(EmpresaConciTar.NICKNAME, empresa);
		condiciones.put(Usuario.NICKNAME, usuario);
		return (List) ObjetoLogico.getObjects(ArchLoteConciDet.NICKNAME, DBArchLoteConciDet.SELECT_MARCADA_BY_EMPRESA_USU, condiciones,
				new ListObserver(), aSesion);
	}

	public static List getPreconciliadosPorEmpresaUsu(EmpresaConciTar empresa, Usuario usuario, ISesion aSesion) throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put(EmpresaConciTar.NICKNAME, empresa);
		condiciones.put(Usuario.NICKNAME, usuario);
		return (List) ObjetoLogico.getObjects(ArchLoteConciDet.NICKNAME, DBArchLoteConciDet.SELECT_PRECONCI_EMPRESA_USU, condiciones,
				new ListObserver(), aSesion);
	}

	public static List getPreconciliadosPorEmpresayNroConci(EmpresaConciTar empresa, Integer nroConciliacion, ISesion aSesion)
			throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put(EmpresaConciTar.NICKNAME, empresa);
		condiciones.put("NRO_CONCILIACION", nroConciliacion);
		return (List) ObjetoLogico.getObjects(ArchLoteConciDet.NICKNAME, DBArchLoteConciDet.SELECT_BY_EMP_NRO_CONCI, condiciones,
				new ListObserver(), aSesion);
	}

	public static List getConciliadosPorConciAutomatica(EmpresaConciTar empresa, CabConciAutomatica cabConciAutomatica, ISesion aSesion)
			throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put(EmpresaConciTar.NICKNAME, empresa);
		condiciones.put(CabConciAutomatica.NICKNAME, cabConciAutomatica);
		return (List) ObjetoLogico.getObjects(ArchLoteConciDet.NICKNAME, DBArchLoteConciDet.SELECT_BY_EMP_ACTIVO_CONCI_AUT, condiciones,
				new ListObserver(), aSesion);
	}

	public static List getConciliadosPorEmpresayNroConci(EmpresaConciTar empresa, Integer nroConciliacion, ISesion aSesion)
			throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put(EmpresaConciTar.NICKNAME, empresa);
		condiciones.put("NRO_CONCILIACION", nroConciliacion);
		return (List) ObjetoLogico.getObjects(ArchLoteConciDet.NICKNAME, DBArchLoteConciDet.SELECT_BY_EMP_ACTIVO_CONCI_NRO, condiciones,
				new ListObserver(), aSesion);
	}

	public static ArchLoteConciDet getArchLoteConciDet(EmpresaConciTar empresa, String tipoOperacion, String tipoTarjeta,
			java.util.Date fechaOrigen, String tarjeta, Integer nroTarjeta, Double monto, Integer nroLote, Integer diasTolFecConci,
			ISesion aSesion) throws BaseException {

		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put(EmpresaConciTar.NICKNAME, empresa);
		condiciones.put("TIPO_OPERACION", tipoOperacion);
		condiciones.put("TIPO_TARJETA", tipoTarjeta);
		condiciones.put("FECHA_ORIGEN", fechaOrigen);
		condiciones.put("TARJETA", tarjeta);
		condiciones.put("NRO_TARJETA", nroTarjeta);
		condiciones.put("MONTO", monto);
		condiciones.put("LOTE", nroLote);

		if (diasTolFecConci == null)
			diasTolFecConci = new Integer(0);
		condiciones.put("DIAS_TOL_FEC_CONCI", diasTolFecConci);

		return (ArchLoteConciDet) ObjetoLogico.getObjects(ArchLoteConciDet.NICKNAME, DBArchLoteConciDet.BUSCAR_PARA_CONCILIAR, condiciones,
				new ObjetoObservado(), aSesion);
	}

	public static ArchLoteConciDet getArchLoteConciDet(EmpresaConciTar empresa, String tipoOperacion, String tipoTarjeta,
			java.util.Date fechaOrigen, String tarjeta, Integer nroTarjeta, Double monto, Integer diasTolFecConci, ISesion aSesion)
			throws BaseException {

		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put(EmpresaConciTar.NICKNAME, empresa);
		condiciones.put("TIPO_OPERACION", tipoOperacion);
		condiciones.put("TIPO_TARJETA", tipoTarjeta);
		condiciones.put("FECHA_ORIGEN", fechaOrigen);
		condiciones.put("TARJETA", tarjeta);
		condiciones.put("NRO_TARJETA", nroTarjeta);
		condiciones.put("MONTO", monto);

		if (diasTolFecConci == null)
			diasTolFecConci = new Integer(0);
		condiciones.put("DIAS_TOL_FEC_CONCI", diasTolFecConci);

		return (ArchLoteConciDet) ObjetoLogico.getObjects(ArchLoteConciDet.NICKNAME, DBArchLoteConciDet.BUSCAR_PARA_CONCILIAR, condiciones,
				new ObjetoObservado(), aSesion);
	}

	public static ArchLoteConciDet getArchLoteConciDet(
			EmpresaConciTar empresa, 
			String tipoOperacion, 
			String tipoTarjeta,
			java.util.Date fechaOrigen, 
			String tarjeta, 
			Double monto, 
			Integer diasTolFecConci, 
			ISesion aSesion) throws BaseException {

		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put(EmpresaConciTar.NICKNAME, empresa);
		condiciones.put("TIPO_OPERACION", tipoOperacion);
		condiciones.put("TIPO_TARJETA", tipoTarjeta);
		condiciones.put("FECHA_ORIGEN", fechaOrigen);
		condiciones.put("TARJETA", tarjeta);
		condiciones.put("MONTO", monto);

		if (diasTolFecConci == null)
			diasTolFecConci = new Integer(0);
		condiciones.put("DIAS_TOL_FEC_CONCI", diasTolFecConci);

		return (ArchLoteConciDet) ObjetoLogico.getObjects(ArchLoteConciDet.NICKNAME, DBArchLoteConciDet.BUSCAR_PARA_CONCILIAR, condiciones,
				new ObjetoObservado(), aSesion);
	}
	
	public static List getArchLoteconciDetPorConciAut(
			EmpresaConciTar empresa,
			ArchLoteConciCab archLoteConciCab,
			ISesion aSesion) throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put(EmpresaConciTar.NICKNAME, empresa);
		condiciones.put(ArchLoteConciCab.NICKNAME, archLoteConciCab);
		return (List) ObjetoLogico.getObjects(
				ArchLoteConciDet.NICKNAME, 
				DBArchLoteConciDet.SELECT_BY_EMP_ACTIVO_CONCI_AUT, 
				condiciones,
				new ListObserver(), 
				aSesion);
	}	
	
	public static List getArchLoteDetMarcadosAsiACobNoConta(
			HashTableDatos condiciones,
			ISesion aSesion) throws BaseException {
		return (List) ObjetoLogico.getObjects(
				ArchLoteConciDet.NICKNAME, 
				DBArchLoteConciDet.SELECT_MARCA_ASI_ACOB_NO_CONTA, 
				condiciones,
				new ListObserver(), 
				aSesion);
	}	
	
	public static List getArchLoteDetContaConSegunNroAsi(
			Integer nroAsiCobranza,
			ISesion aSesion) throws BaseException {
		return (List) ObjetoLogico.getObjects(
				ArchLoteConciDet.NICKNAME, 
				DBArchLoteConciDet.SELECT_ASI_COB_CONTA_SEGUN_NRO, 
				nroAsiCobranza,
				new ListObserver(), 
				aSesion);
	}
	
	public static List getArchLoteDetContaLiqSegunNroAsi(
			Integer nroAsiLiquidacion,
			ISesion aSesion) throws BaseException {
		return (List) ObjetoLogico.getObjects(
				ArchLoteConciDet.NICKNAME, 
				DBArchLoteConciDet.SELECT_ASI_LIQ_CONTA_SEGUN_NRO, 
				nroAsiLiquidacion,
				new ListObserver(), 
				aSesion);
	}	
	
	public static List getArchLoteDetNoContaLiq(
			EmpresaConciTar empresa,
			CabModeloLiq cabModeloLiq,
			boolean misMarcados,
			ISesion aSesion) throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put(EmpresaConciTar.NICKNAME, empresa);
		condiciones.put(CabModeloLiq.NICKNAME, cabModeloLiq);
		if (misMarcados)
			condiciones.put("SOLO_MIS_MARCADOS", "");
		return (List) ObjetoLogico.getObjects(
				ArchLoteConciDet.NICKNAME, 
				DBArchLoteConciDet.SELECT_MARCAR_ASI_LIQ_NO_CONTA, 
				condiciones,
				new ListObserver(), 
				aSesion);
	}	
	
	public static List getArchLoteDetAsiLiq(
			CabAsiLiquiTarj cabAsiLiquiTarj,
			ISesion aSesion) throws BaseException {
		return (List) ObjetoLogico.getObjects(
				ArchLoteConciDet.NICKNAME, 
				DBArchLoteConciDet.SELECT_BY_CONTA_ASI_LIQ, 
				cabAsiLiquiTarj,
				new ListObserver(), 
				aSesion);
	}	
	
	public static List getArchLoteDetByAsiCob(
			CabAsiTarjACobrar cabAsiTarjACobrar,
			ISesion aSesion) throws BaseException {
		return (List) ObjetoLogico.getObjects(
				ArchLoteConciDet.NICKNAME, 
				DBArchLoteConciDet.SELECT_BY_ASI_COB, 
				cabAsiTarjACobrar,
				new ListObserver(), 
				aSesion);
	}	
	
	public static List getArchLoteDetByAsiLiq(
			CabAsiLiquiTarj aCabAsiLiquiTarj,
			ISesion aSesion) throws BaseException {
		return (List) ObjetoLogico.getObjects(
				ArchLoteConciDet.NICKNAME, 
				DBArchLoteConciDet.SELECT_BY_ASI_LIQ, 
				aCabAsiLiquiTarj,
				new ListObserver(), 
				aSesion);
	}
	
	public static double getSaldoAUnaFecha(Object aCondiciones, ISesion aSesion) throws BaseException {

		try {
			HashTableDatos condiciones = (HashTableDatos) aCondiciones;
			String cuenta = (String) condiciones.get("CUENTA");
			java.util.Date fecha = (java.util.Date) condiciones.get("FECHA");
			StringBuffer textSQL = new StringBuffer();
			textSQL.append(" select ");
			textSQL.append("   sum(debe)-sum(haber)  saldo ");
			textSQL.append(" from ");
			textSQL.append("   cTarDetAsiLiq a , ctarcabasiliq b ");
			textSQL.append(" where ");
			textSQL.append("  a.oid_cab_asi_liq = b.oid_cab_asi_liq and ");
			textSQL.append("    a.activo=1 and ");
			textSQL.append("    b.activo=1 and ");
			textSQL.append("    a.cuenta=? and ");
			textSQL.append("    b.fec_asiento < ? ");

			PreparedStatement querySelect = aSesion.getConexionBD().prepareStatement(textSQL.toString());

			querySelect.setString(1, cuenta);
			querySelect.setDate(2, new java.sql.Date(fecha.getTime()));

			ResultSet rs = querySelect.executeQuery();
			double saldo = 0;
			if (rs.next())
				saldo = rs.getDouble(1);
			rs.close();
			querySelect.close();

			return saldo;
		} catch (Exception e) {
			throw new BaseException(null, e.getMessage());
		}
	}	
	

}
