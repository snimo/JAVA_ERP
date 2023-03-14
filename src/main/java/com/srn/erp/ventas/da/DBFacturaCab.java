package com.srn.erp.ventas.da;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import com.srn.erp.general.bm.LugarEmision;
import com.srn.erp.general.bm.TipoComprobante;
import com.srn.erp.stock.bm.Producto;
import com.srn.erp.ventas.bm.FacturaCab;
import com.srn.erp.ventas.bm.PedidoCab;
import com.srn.erp.ventas.bm.Sujeto;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.ObjetoObservado;

public class DBFacturaCab extends DBObjetoPersistente {

	public static final String	OID_CCO_FACT						= "oid_cco_fact";

	public static final String	OID_SUJETO							= "oid_sujeto";

	public static final String	TIPO_OPER								= "tipo_oper";

	public static final String	TIPO_CLIENTE						= "tipo_cliente";

	public static final String	OID_CAJA								= "oid_caja";

	public static final String	FEC_CAJA								= "fec_caja";

	public static final String	PORC_BONIF_CLI					= "porc_bonif_cli";

	public static final String	PORC_RECAR_CLI					= "porc_recar_cli";

	public static final String	OID_TALONARIO						= "oid_talonario";

	public static final String	OID_LISTA_PRECIOS				= "oid_lista_precios";

	public static final String	OID_PROVINCIA						= "oid_provincia";

	public static final String	OID_MONEDA							= "oid_moneda";

	public static final String	COTIZACION							= "cotizacion";

	public static final String	OID_VENDEDOR						= "oid_vendedor";

	public static final String	OID_COND_PAGO						= "oid_cond_pago";

	public static final String	OID_COMPO_STK_FACT			= "oid_compo_stk_fact";

	public static final String	PORC_BONIF_CP						= "porc_bonif_cp";

	public static final String	PORC_RECAR_CP						= "porc_recar_cp";

	public static final String	FEC_BASE								= "fec_base";

	public static final String	OID_SUJ_IMP							= "oid_suj_imp";

	public static final String	SIGNO										= "signo";

	public static final String	BRUTO										= "bruto";

	public static final String	PORC_DTO								= "porc_dto";

	public static final String	DESCUENTO								= "descuento";

	public static final String	PORC_RECAR							= "porc_recar";

	public static final String	RECARGO									= "recargo";

	public static final String	NETO										= "neto";

	public static final String	IVA											= "iva";

	public static final String	PERC_IVA								= "perc_iva";

	public static final String	IMP_INTERNOS						= "imp_internos";

	public static final String	PERC_IB									= "perc_ib";

	public static final String	TOTAL										= "total";

	public static final String	IMPRE_BRUTO							= "impre_bruto";

	public static final String	IMPRE_BONIF							= "impre_bonif";

	public static final String	IMPRE_RECAR							= "impre_recar";

	public static final String	IMPRE_NETO							= "impre_neto";

	public static final String	IMPRE_IVA								= "impre_iva";
	
	public static final String	IMPRE_IVA_2								= "impre_iva_2";

	public static final String	IMPRE_PERC_IVA					= "impre_perc_iva";

	public static final String	IMPRE_PERC_IB						= "impre_perc_ib";

	public static final String	IMPRE_IMP_INT						= "impre_imp_int";

	public static final String	IMPRE_TOTAL							= "impre_total";

	public static final String	IMPRE_PORC_RECAR				= "impre_porc_recar";

	public static final String	IMPRE_PORC_BONIF				= "impre_porc_bonif";

	public static final String	NETO_GRAVADO						= "neto_gravado";

	public static final String	NETO_NO_GRAVADO					= "neto_no_gravado";

	public static final String	NETO_GRAV_LOC						= "neto_grav_loc";

	public static final String	NETO_NO_GRAV_LOC				= "neto_no_grav_loc";

	public static final String	BRUTO_MON_LOC						= "bruto_mon_loc";

	public static final String	PORC_DTO_MON_LOC				= "porc_dto_mon_loc";

	public static final String	DTO_MON_LOC							= "dto_mon_loc";

	public static final String	PORC_RECAR_MON_LOC			= "porc_recar_mon_loc";

	public static final String	RECARGO_MON_LOC					= "recargo_mon_loc";

	public static final String	NETO_MON_LOC						= "neto_mon_loc";

	public static final String	IVA_MON_LOC							= "iva_mon_loc";

	public static final String	PERC_IVA_MON_LOC				= "perc_iva_mon_loc";

	public static final String	IMP_INT_MON_LOC					= "imp_int_mon_loc";

	public static final String	PERC_IB_MON_LOC					= "perc_ib_mon_loc";

	public static final String	TOTAL_MON_LOC						= "tot_mon_loc";

	public static final String	OID_CONC_IVA						= "oid_conc_iva";
	
	public static final String	OID_CONC_IVA_2						= "oid_conc_iva_2";

	public static final String	OID_CONC_PERC_IVA				= "oid_conc_perc_iva";

	public static final String	OID_CONC_IMP_INT				= "oid_conc_imp_int";

	public static final String	OID_CONC_PERC_IB				= "oid_conc_perc_ib";

	public static final String	OID_TIPO_CONF_MOV_STK		= "oid_conf_mov_stk";
	
	public static final String  OC = "oc";
	
	public static final String	PERC_IB_BA = "perc_ib_ba";
	
	public static final String  PERC_IB_CF = "perc_ib_cf";
	
	public static final String IMPRE_PERC_IB_BA = "impre_perc_ib_ba";
	
	public static final String IMPRE_PERC_IB_CF = "impre_perc_ib_cf";
	
	public static final String PERC_IB_BA_MON_LOC = "perc_ib_ba_mon_loc";
	
	public static final String PERC_IB_CF_MON_LOC = "perc_ib_cf_mon_loc";
	
	public static final String FACTURA = "factura";
	
	public static final String IVA_2 = "iva_2";
	
	public static final String IVA_2_MON_LOC = "iva_2_mon_loc";
	
	public static final String OID_CCO_FACT_SENIA = "oid_cco_fact_senia";
	
	public static final String OID_PROYECTO = "oid_proyecto";
	
	public static final String TIPO_IMPRESION = "tipo_impresion";
	
	public static final String HOMOLOGADA_FE = "homologada_fe";
	
	public static final String FECHORA_HOMOLOGADA_FE =  "fechora_homologada_fe";
	
	public static final String USU_HOMOLOGADA_FE =  "usu_homologada_fe";
	
	public static final String CAE_FE =  "cae_fe";
	
	public static final String FEC_VTO_CAE_FE =  "fec_vto_cae_fe";

	public static final int			SELECT_BY_CLIE_FEC_NRO	= 100;

	public static final int			SELECT_BY_FACT_Y_ND			= 101;
	
	public static final int			SELECT_BY_FACT_SENIA_O_ANTICIPO			= 102;
	
	public static final int 		SELECT_BY_TC_LETRA_LE_NRO = 103;
	
	public static final int			UPDATE_TIPO_IMPRESION = 104;
	
	
	

	public DBFacturaCab() {
	}

	protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_CCO_FACT = 1;
		final int OID_SUJETO = 2;
		final int TIPO_OPER = 3;
		final int TIPO_CLIENTE = 4;
		final int OID_CAJA = 5;
		final int FEC_CAJA = 6;
		final int PORC_BONIF_CLI = 7;
		final int PORC_RECAR_CLI = 8;
		final int OID_TALONARIO = 9;
		final int OID_LISTA_PRECIOS = 10;
		final int OID_PROVINCIA = 11;
		final int OID_MONEDA = 12;
		final int COTIZACION = 13;
		final int OID_VENDEDOR = 14;
		final int OID_COND_PAGO = 15;
		final int OID_COMPO_STK_FACT = 16;
		final int PORC_BONIF_CP = 17;
		final int PORC_RECAR_CP = 18;
		final int FEC_BASE = 19;
		final int OID_SUJ_IMP = 20;
		final int SIGNO = 21;
		final int BRUTO = 22;
		final int PORC_DTO = 23;
		final int DESCUENTO = 24;
		final int PORC_RECAR = 25;
		final int RECARGO = 26;
		final int NETO = 27;
		final int IVA = 28;
		final int PERC_IVA = 29;
		final int IMP_INTERNOS = 30;
		final int PERC_IB = 31;
		final int TOTAL = 32;
		final int IMPRE_BRUTO = 33;
		final int IMPRE_BONIF = 34;
		final int IMPRE_RECAR = 35;
		final int IMPRE_NETO = 36;
		final int IMPRE_IVA = 37;
		final int IMPRE_PERC_IVA = 38;
		final int IMPRE_PERC_IB = 39;
		final int IMPRE_IMP_INT = 40;
		final int IMPRE_TOTAL = 41;
		final int BRUTO_MON_LOC = 42;
		final int PORC_DTO_MON_LOC = 43;
		final int DTO_MON_LOC = 44;
		final int PORC_RECAR_MON_LOC = 45;
		final int RECARGO_MON_LOC = 46;
		final int NETO_MON_LOC = 47;
		final int IVA_MON_LOC = 48;
		final int PERC_IVA_MON_LOC = 49;
		final int IMP_INT_MON_LOC = 50;
		final int PERC_IB_MON_LOC = 51;
		final int TOTAL_MON_LOC = 52;
		final int IMPRE_PORC_BONIF = 53;
		final int IMPRE_PORC_RECAR = 54;
		final int OID_CONC_IVA = 55;		
		final int OID_CONC_PERC_IVA = 56;
		final int OID_CONC_PERC_IB = 57;
		final int OID_CONC_IMP_INT = 58;
		final int NETO_GRAVADO = 59;
		final int NETO_NO_GRAVADO = 60;
		final int NETO_GRAV_LOC = 61;
		final int NETO_NO_GRAV_LOC = 62;
		final int OID_TIPO_CONF_MOV_STK = 63;
		final int	PERC_IB_BA = 64;
		final int PERC_IB_CF = 65;
		final int IMPRE_PERC_IB_BA = 66;
		final int IMPRE_PERC_IB_CF = 67;
		final int PERC_IB_BA_MON_LOC = 68;
		final int PERC_IB_CF_MON_LOC = 69;
		final int OC = 70;
		final int FACTURA = 71;
		final int OID_CONC_IVA_2 = 72;
		final int IMPRE_IVA_2 = 73;
		final int IVA_2 = 74;
		final int IVA_2_MON_LOC = 75;
		final int OID_CCO_FACT_SENIA = 76;
		final int OID_PROYECTO = 77;
		final int TIPO_IMPRESION = 78;

		FacturaCab pers = (FacturaCab) objetoPersistente;

		StringBuffer sqlInsert = new StringBuffer();
		sqlInsert.append(" insert into veFacturasCab " + " ( " + "OID_CCO_FACT," + "OID_SUJETO," + "TIPO_OPER,"
				+ "TIPO_CLIENTE," + "OID_CAJA," + "FEC_CAJA," + "PORC_BONIF_CLI," + "PORC_RECAR_CLI," + "OID_TALONARIO,"
				+ "OID_LISTA_PRECIOS," + "OID_PROVINCIA," + "OID_MONEDA," + "COTIZACION," + "OID_VENDEDOR," + "OID_COND_PAGO,"
				+ "OID_COMPO_STK_FACT," + "PORC_BONIF_CP," + "PORC_RECAR_CP," + "FEC_BASE," + "OID_SUJ_IMP," + "SIGNO,"
				+ "BRUTO," + "PORC_DTO," + "DESCUENTO," + "PORC_RECAR," + "RECARGO," + "NETO," + "IVA," + "PERC_IVA,"
				+ "IMP_INTERNOS," + "PERC_IB," + "TOTAL," + "IMPRE_BRUTO," + "IMPRE_BONIF," + "IMPRE_RECAR," + "IMPRE_NETO,"
				+ "IMPRE_IVA," + "IMPRE_PERC_IVA," + "IMPRE_PERC_IB," + "IMPRE_IMP_INT," + "IMPRE_TOTAL," + "BRUTO_MON_LOC,"
				+ "PORC_DTO_MON_LOC," + "DTO_MON_LOC," + "PORC_RECAR_MON_LOC," + "RECARGO_MON_LOC," + "NETO_MON_LOC,"
				+ "IVA_MON_LOC," + "PERC_IVA_MON_LOC," + "IMP_INT_MON_LOC," + "PERC_IB_MON_LOC," + "TOTAL_MON_LOC,"
				+ "IMPRE_PORC_BONIF," + "IMPRE_PORC_RECAR," + "OID_CONC_IVA," + "OID_CONC_PERC_IVA," + "OID_CONC_IMP_INT,"
				+ "OID_CONC_PERC_IB," + "NETO_GRAVADO," + "NETO_NO_GRAVADO," + "NETO_GRAV_LOC,"
				+ "NETO_NO_GRAV_LOC,OID_CONF_MOV_STK,PERC_IB_BA,PERC_IB_CF,IMPRE_PERC_IB_BA,IMPRE_PERC_IB_CF,PERC_IB_BA_MON_LOC,PERC_IB_CF_MON_LOC,OC,FACTURA,OID_CONC_IVA_2,IMPRE_IVA_2,IVA_2,IVA_2_MON_LOC,OID_CCO_FACT_SENIA , OID_PROYECTO , TIPO_IMPRESION" + ")" + " values " + "(" + "?,"+"?,"+ "?,"+ "?,"+ "?,"+ "?,"+ "?," + "?," + "?," + "?," + "?," + "?," + "?,"
				+ "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?,"
				+ "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?,"+ "?,"
				+ "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?,"
				+ "?," + "?," + "?," + "?," + "?," + "?," 
				+ "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?) ");

		PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
		qInsert.setInt(OID_CCO_FACT, pers.getOID());
		qInsert.setInt(OID_SUJETO, pers.getSujeto().getOID());
		qInsert.setString(TIPO_OPER, pers.getTipo_oper());
		qInsert.setString(TIPO_CLIENTE, pers.getTipo_cliente());
		if (pers.getCaja() != null)
			qInsert.setInt(OID_CAJA, pers.getCaja().getOID());
		else
			qInsert.setNull(OID_CAJA, Types.INTEGER);
		if (pers.getFec_caja() != null)
			qInsert.setDate(FEC_CAJA, new Date(pers.getFec_caja().getTime()));
		else
			qInsert.setNull(FEC_CAJA, Types.DATE);
		if (pers.getPorc_bonif_cli() != null)
			qInsert.setDouble(PORC_BONIF_CLI, pers.getPorc_bonif_cli().doubleValue());
		else
			qInsert.setNull(PORC_BONIF_CLI, Types.DOUBLE);
		if (pers.getPorc_recar_cli() != null)
			qInsert.setDouble(PORC_RECAR_CLI, pers.getPorc_recar_cli().doubleValue());
		else
			qInsert.setNull(PORC_RECAR_CLI, Types.DOUBLE);
		qInsert.setInt(OID_TALONARIO, pers.getTalonario().getOID());
		if (pers.getLista_precios() != null)
			qInsert.setInt(OID_LISTA_PRECIOS, pers.getLista_precios().getOID());
		else
			qInsert.setNull(OID_LISTA_PRECIOS, Types.INTEGER);
		qInsert.setInt(OID_PROVINCIA, pers.getProvincia().getOID());
		qInsert.setInt(OID_MONEDA, pers.getMoneda().getOID());
		qInsert.setDouble(COTIZACION, pers.getCotizacion().doubleValue());
		qInsert.setInt(OID_VENDEDOR, pers.getVendedor().getOID());
		qInsert.setInt(OID_COND_PAGO, pers.getCond_pago().getOID());
		if (pers.getCompo_stk_fact() != null)
			qInsert.setInt(OID_COMPO_STK_FACT, pers.getCompo_stk_fact().getOID());
		else
			qInsert.setNull(OID_COMPO_STK_FACT, Types.INTEGER);
		if (pers.getPorc_bonif_cp() != null)
			qInsert.setDouble(PORC_BONIF_CP, pers.getPorc_bonif_cp().doubleValue());
		else
			qInsert.setNull(PORC_BONIF_CP, Types.DOUBLE);
		if (pers.getPorc_recar_cp() != null)
			qInsert.setDouble(PORC_RECAR_CP, pers.getPorc_recar_cp().doubleValue());
		else
			qInsert.setNull(PORC_RECAR_CP, Types.DOUBLE);
		qInsert.setDate(FEC_BASE, new java.sql.Date(pers.getFec_base().getTime()));
		qInsert.setInt(OID_SUJ_IMP, pers.getSujeto_impositivo().getOID());
		qInsert.setInt(SIGNO, pers.getSigno().intValue());
		if (pers.getBruto() != null)
			qInsert.setDouble(BRUTO, pers.getBruto().doubleValue());
		else
			qInsert.setNull(BRUTO, java.sql.Types.DOUBLE);
		if (pers.getPorc_dto() != null)
			qInsert.setDouble(PORC_DTO, pers.getPorc_dto().doubleValue());
		else
			qInsert.setNull(PORC_DTO, java.sql.Types.DOUBLE);
		if (pers.getDescuento() != null)
			qInsert.setDouble(DESCUENTO, pers.getDescuento().doubleValue());
		else
			qInsert.setNull(DESCUENTO, java.sql.Types.DOUBLE);
		if (pers.getPorc_recar() != null)
			qInsert.setDouble(PORC_RECAR, pers.getPorc_recar().doubleValue());
		else
			qInsert.setNull(PORC_RECAR, java.sql.Types.DOUBLE);
		if (pers.getRecargo() != null)
			qInsert.setDouble(RECARGO, pers.getRecargo().doubleValue());
		else
			qInsert.setNull(RECARGO, java.sql.Types.DOUBLE);
		if (pers.getNeto() != null)
			qInsert.setDouble(NETO, pers.getNeto().doubleValue());
		else
			qInsert.setNull(NETO, java.sql.Types.DOUBLE);
		if (pers.getIva() != null)
			qInsert.setDouble(IVA, pers.getIva().doubleValue());
		else
			qInsert.setNull(IVA, java.sql.Types.DOUBLE);
		if (pers.getPerc_iva() != null)
			qInsert.setDouble(PERC_IVA, pers.getPerc_iva().doubleValue());
		else
			qInsert.setNull(PERC_IVA, java.sql.Types.DOUBLE);
		if (pers.getImp_internos() != null)
			qInsert.setDouble(IMP_INTERNOS, pers.getImp_internos().doubleValue());
		else
			qInsert.setNull(IMP_INTERNOS, java.sql.Types.DOUBLE);
		if (pers.getPerc_ib() != null)
			qInsert.setDouble(PERC_IB, pers.getPerc_ib().doubleValue());
		else
			qInsert.setNull(PERC_IB, java.sql.Types.DOUBLE);
		if (pers.getTotal() != null)
			qInsert.setDouble(TOTAL, pers.getTotal().doubleValue());
		else
			qInsert.setNull(TOTAL, java.sql.Types.DOUBLE);
		if (pers.getImpre_bruto() != null)
			qInsert.setDouble(IMPRE_BRUTO, pers.getImpre_bruto().doubleValue());
		else
			qInsert.setNull(IMPRE_BRUTO, java.sql.Types.DOUBLE);
		if (pers.getImpre_bonif() != null)
			qInsert.setDouble(IMPRE_BONIF, pers.getImpre_bonif().doubleValue());
		else
			qInsert.setNull(IMPRE_BONIF, java.sql.Types.DOUBLE);
		if (pers.getImpre_recar() != null)
			qInsert.setDouble(IMPRE_RECAR, pers.getImpre_recar().doubleValue());
		else
			qInsert.setNull(IMPRE_RECAR, java.sql.Types.DOUBLE);
		if (pers.getImpre_neto() != null)
			qInsert.setDouble(IMPRE_NETO, pers.getImpre_neto().doubleValue());
		else
			qInsert.setNull(IMPRE_NETO, java.sql.Types.DOUBLE);
		if (pers.getImpre_iva() != null)
			qInsert.setDouble(IMPRE_IVA, pers.getImpre_iva().doubleValue());
		else
			qInsert.setNull(IMPRE_IVA, java.sql.Types.DOUBLE);
		if (pers.getImpre_iva2() != null)
			qInsert.setDouble(IMPRE_IVA_2, pers.getImpre_iva2().doubleValue());
		else
			qInsert.setNull(IMPRE_IVA_2, java.sql.Types.DOUBLE);
		
		if (pers.getImpre_perc_iva() != null)
			qInsert.setDouble(IMPRE_PERC_IVA, pers.getImpre_perc_iva().doubleValue());
		else
			qInsert.setNull(IMPRE_PERC_IVA, java.sql.Types.DOUBLE);
		if (pers.getImpre_perc_ib() != null)
			qInsert.setDouble(IMPRE_PERC_IB, pers.getImpre_perc_ib().doubleValue());
		else
			qInsert.setNull(IMPRE_PERC_IB, java.sql.Types.DOUBLE);
		if (pers.getImpre_imp_int() != null)
			qInsert.setDouble(IMPRE_IMP_INT, pers.getImpre_imp_int().doubleValue());
		else
			qInsert.setNull(IMPRE_IMP_INT, java.sql.Types.DOUBLE);
		if (pers.getImpre_total() != null)
			qInsert.setDouble(IMPRE_TOTAL, pers.getImpre_total().doubleValue());
		else
			qInsert.setNull(IMPRE_TOTAL, Types.DOUBLE);

		if (pers.getBrutoMonLoc() != null)
			qInsert.setDouble(BRUTO_MON_LOC, pers.getBrutoMonLoc().doubleValue());
		else
			qInsert.setNull(BRUTO_MON_LOC, Types.DOUBLE);
		if (pers.getPorcDtoMonLoc() != null)
			qInsert.setDouble(PORC_DTO_MON_LOC, pers.getPorcDtoMonLoc().doubleValue());
		else
			qInsert.setNull(PORC_DTO_MON_LOC, Types.DOUBLE);
		if (pers.getDtoMonLoc() != null)
			qInsert.setDouble(DTO_MON_LOC, pers.getDtoMonLoc().doubleValue());
		else
			qInsert.setNull(DTO_MON_LOC, Types.DOUBLE);
		if (pers.getPorcRecarMonLoc() != null)
			qInsert.setDouble(PORC_RECAR_MON_LOC, pers.getPorcRecarMonLoc().doubleValue());
		else
			qInsert.setNull(PORC_RECAR_MON_LOC, Types.DOUBLE);
		if (pers.getRecargoMonLoc() != null)
			qInsert.setDouble(RECARGO_MON_LOC, pers.getRecargoMonLoc().doubleValue());
		else
			qInsert.setNull(RECARGO_MON_LOC, Types.DOUBLE);
		if (pers.getNetoMonedaLocal() != null)
			qInsert.setDouble(NETO_MON_LOC, pers.getNetoMonedaLocal().doubleValue());
		else
			qInsert.setNull(NETO_MON_LOC, Types.DOUBLE);
		if (pers.getIVAMonLoc() != null)
			qInsert.setDouble(IVA_MON_LOC, pers.getIVAMonLoc().doubleValue());
		else
			qInsert.setNull(IVA_MON_LOC, Types.DOUBLE);
		if (pers.getPercIVAMonLoc() != null)
			qInsert.setDouble(PERC_IVA_MON_LOC, pers.getPercIVAMonLoc().doubleValue());
		else
			qInsert.setNull(PERC_IVA_MON_LOC, Types.DOUBLE);
		if (pers.getImpuIntMonLoc() != null)
			qInsert.setDouble(IMP_INT_MON_LOC, pers.getImpuIntMonLoc().doubleValue());
		else
			qInsert.setNull(IMP_INT_MON_LOC, Types.DOUBLE);
		if (pers.getPercIBMonLoc() != null)
			qInsert.setDouble(PERC_IB_MON_LOC, pers.getPercIBMonLoc().doubleValue());
		else
			qInsert.setNull(PERC_IB_MON_LOC, Types.DOUBLE);
		if (pers.getTotMonLoc() != null)
			qInsert.setDouble(TOTAL_MON_LOC, pers.getTotMonLoc().doubleValue());
		else
			qInsert.setNull(TOTAL_MON_LOC, Types.DOUBLE);
		if (pers.getImprePorcBonif() != null)
			qInsert.setDouble(IMPRE_PORC_BONIF, pers.getImprePorcBonif().doubleValue());
		else
			qInsert.setNull(IMPRE_PORC_BONIF, Types.DOUBLE);
		if (pers.getImprePorcRecar() != null)
			qInsert.setDouble(IMPRE_PORC_RECAR, pers.getImprePorcRecar().doubleValue());
		else
			qInsert.setNull(IMPRE_PORC_RECAR, Types.DOUBLE);
		if (pers.getConcImpuIVA() != null)
			qInsert.setInt(OID_CONC_IVA, pers.getConcImpuIVA().getOID());
		else
			qInsert.setNull(OID_CONC_IVA, Types.INTEGER);
		if (pers.getConcImpuPercIVA() != null)
			qInsert.setInt(OID_CONC_PERC_IVA, pers.getConcImpuPercIVA().getOID());
		else
			qInsert.setNull(OID_CONC_PERC_IVA, Types.INTEGER);
		if (pers.getConcImpuPercIB() != null)
			qInsert.setInt(OID_CONC_PERC_IB, pers.getConcImpuPercIB().getOID());
		else
			qInsert.setNull(OID_CONC_PERC_IB, Types.INTEGER);
		if (pers.getConcImpInt() != null)
			qInsert.setInt(OID_CONC_IMP_INT, pers.getConcImpInt().getOID());
		else
			qInsert.setNull(OID_CONC_IMP_INT, Types.INTEGER);
		if (pers.getNetoGravado() != null)
			qInsert.setDouble(NETO_GRAVADO, pers.getNetoGravado().doubleValue());
		else
			qInsert.setNull(NETO_GRAVADO, Types.DOUBLE);
		if (pers.getNetoNoGravado() != null)
			qInsert.setDouble(NETO_NO_GRAVADO, pers.getNetoNoGravado().doubleValue());
		else
			qInsert.setNull(NETO_NO_GRAVADO, Types.DOUBLE);
		if (pers.getNetoGravadoMonLoc() != null)
			qInsert.setDouble(NETO_GRAV_LOC, pers.getNetoGravadoMonLoc().doubleValue());
		else
			qInsert.setNull(NETO_GRAV_LOC, Types.DOUBLE);
		if (pers.getNetoNoGravadoMonLoc() != null)
			qInsert.setDouble(NETO_NO_GRAV_LOC, pers.getNetoNoGravadoMonLoc().doubleValue());
		else
			qInsert.setNull(NETO_NO_GRAV_LOC, Types.DOUBLE);
		if (pers.getTipoConfMovStkTalonario() != null)
			qInsert.setInt(OID_TIPO_CONF_MOV_STK, pers.getTipoConfMovStkTalonario().getOID());
		else
			qInsert.setNull(OID_TIPO_CONF_MOV_STK, Types.INTEGER);

		if (pers.getPercIBBsAs()!=null)
			qInsert.setDouble(PERC_IB_BA , pers.getPercIBBsAs().doubleValue());
		else
			qInsert.setDouble(PERC_IB_BA , 0);
		
		if (pers.getPercIBCapFed()!=null)
			qInsert.setDouble(PERC_IB_CF , pers.getPercIBCapFed().doubleValue());
		else
			qInsert.setDouble(PERC_IB_CF , 0);
		
		if (pers.getImprePercIBBsAs()!=null)
			qInsert.setDouble(IMPRE_PERC_IB_BA , pers.getImprePercIBBsAs().doubleValue());
		else
			qInsert.setDouble(IMPRE_PERC_IB_BA, 0);
		
		if (pers.getImprePercIBCapFed()!=null)
			qInsert.setDouble(IMPRE_PERC_IB_CF , pers.getImprePercIBCapFed().doubleValue());
		else
			qInsert.setDouble(IMPRE_PERC_IB_CF, 0);
		
		if (pers.getPercIBBsAsMonLoc()!=null)
			qInsert.setDouble(PERC_IB_BA_MON_LOC , pers.getPercIBBsAsMonLoc().doubleValue());
		else
			qInsert.setDouble(PERC_IB_BA_MON_LOC , 0);
		
		if (pers.getPercIBCapFedMonLoc()!=null)
			qInsert.setDouble(PERC_IB_CF_MON_LOC , pers.getPercIBCapFedMonLoc().doubleValue());
		else
			qInsert.setDouble(PERC_IB_CF_MON_LOC , 0);
		
		if (pers.getOC()!=null)
			qInsert.setString(OC , pers.getOC());
		else
			qInsert.setNull(OC , java.sql.Types.VARCHAR);
				
		if (pers.getFactura()!=null)
			qInsert.setString(FACTURA, pers.getFactura());
		else
			qInsert.setNull(FACTURA , java.sql.Types.VARCHAR);
		
		if (pers.getConcImpuIVA2()!=null)
			qInsert.setInt(OID_CONC_IVA_2, pers.getConcImpuIVA2().getOID());
		else
			qInsert.setNull(OID_CONC_IVA_2, java.sql.Types.INTEGER);
		
		if (pers.getIva2()!=null)
			qInsert.setDouble(IVA_2, pers.getIva2().doubleValue());
		else
			qInsert.setNull(IVA_2, java.sql.Types.DOUBLE);
		
		if (pers.getIVA2MonLoc()!=null)
			qInsert.setDouble(IVA_2_MON_LOC, pers.getIVA2MonLoc().doubleValue());
		else
			qInsert.setNull(IVA_2_MON_LOC, java.sql.Types.DOUBLE);
		
		if (pers.getFacturaSenia()!=null)
			qInsert.setDouble(OID_CCO_FACT_SENIA, pers.getFacturaSenia().getOIDInteger());
		else
			qInsert.setNull(OID_CCO_FACT_SENIA, java.sql.Types.DOUBLE);
		
		if (pers.getProyecto()!=null)
			qInsert.setInt(OID_PROYECTO, pers.getProyecto().getOID());
		else
			qInsert.setNull(OID_PROYECTO, java.sql.Types.INTEGER);
		
		if (pers.getTipoImpresion()!=null)
			qInsert.setString(TIPO_IMPRESION, pers.getTipoImpresion());
		else
			qInsert.setNull(TIPO_IMPRESION, Types.VARCHAR);
		
		qInsert.executeUpdate();
		qInsert.close();
	}

	protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_SUJETO = 1;
		final int TIPO_OPER = 2;
		final int TIPO_CLIENTE = 3;
		final int OID_CAJA = 4;
		final int FEC_CAJA = 5;
		final int PORC_BONIF_CLI = 6;
		final int PORC_RECAR_CLI = 7;
		final int OID_TALONARIO = 8;
		final int OID_LISTA_PRECIOS = 9;
		final int OID_PROVINCIA = 10;
		final int OID_MONEDA = 11;
		final int COTIZACION = 12;
		final int OID_VENDEDOR = 13;
		final int OID_COND_PAGO = 14;
		final int OID_COMPO_STK_FACT = 15;
		final int PORC_BONIF_CP = 16;
		final int PORC_RECAR_CP = 17;
		final int FEC_BASE = 18;
		final int OID_SUJ_IMP = 19;
		final int SIGNO = 20;
		final int BRUTO = 21;
		final int PORC_DTO = 22;
		final int DESCUENTO = 23;
		final int PORC_RECAR = 24;
		final int RECARGO = 25;
		final int NETO = 26;
		final int IVA = 27;
		final int PERC_IVA = 28;
		final int IMP_INTERNOS = 29;
		final int PERC_IB = 30;
		final int TOTAL = 31;
		final int IMPRE_BRUTO = 32;
		final int IMPRE_BONIF = 33;
		final int IMPRE_RECAR = 34;
		final int IMPRE_NETO = 35;
		final int IMPRE_IVA = 36;
		final int IMPRE_PERC_IVA = 37;
		final int IMPRE_PERC_IB = 38;
		final int IMPRE_IMP_INT = 39;
		final int IMPRE_TOTAL = 40;
		final int	PERC_IB_BA = 41;
		final int PERC_IB_CF = 42;
		final int IMPRE_PERC_IB_BA = 43;
		final int IMPRE_PERC_IB_CF = 44;
		final int PERC_IB_BA_MON_LOC = 45;
		final int PERC_IB_CF_MON_LOC = 46;
		final int OC = 47;
		final int OID_CONC_IVA_2 = 48;
		final int OID_TIPO_CONF_MOV_STK = 49;
		final int IMPRE_IVA_2 = 50;
		final int IVA_2 = 51;
		final int OID_CCO_FACT_SENIA = 52;
		final int IVA_2_MON_LOC = 53;		
		final int OID_PROYECTO = 54;
		final int TIPO_IMPRESION = 55;
		final int OID_CCO_FACT = 56;

		FacturaCab pers = (FacturaCab) objetoPersistente;

		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append(" update veFacturasCab set " + "oid_sujeto=?" + ",tipo_oper=?" + ",tipo_cliente=?" + ",oid_caja=?"
				+ ",fec_caja=?" + ",porc_bonif_cli=?" + ",porc_recar_cli=?" + ",oid_talonario=?" + ",oid_lista_precios=?"
				+ ",oid_provincia=?" + ",oid_moneda=?" + ",cotizacion=?" + ",oid_vendedor=?" + ",oid_cond_pago=?"
				+ ",oid_compo_stk_fact=?" + ",porc_bonif_cp=?" + ",porc_recar_cp=?" + ",fec_base=?" + ",oid_suj_imp=?"
				+ ",signo=?" + ",bruto=?" + ",porc_dto=?" + ",descuento=?" + ",porc_recar=?" + ",recargo=?" + ",neto=?"
				+ ",iva=?" + ",perc_iva=?" + ",imp_internos=?" + ",perc_ib=?" + ",total=?" + ",impre_bruto=?"
				+ ",impre_bonif=?" + ",impre_recar=?" + ",impre_neto=?" + ",impre_iva=?" + ",impre_perc_iva=?"
				+ ",impre_perc_ib=?" + ",impre_imp_int=?" + ",impre_total=?" + ",oid_conf_mov_stk=?" 
				+  "PERC_IB_BA=?,PERC_IB_CF=?,IMPRE_PERC_IB_BA=?,IMPRE_PERC_IB_CF=?,PERC_IB_BA_MON_LOC=?,PERC_IB_CF_MON_LOC=?,OC=? , oid_conc_iva_2 = ? , impre_iva_2 = ? , iva_2 = ? , iva_2_mon_loc = ? , oid_cco_fact_senia = ? , oid_proyecto = ? , tipo_impresion = ? "+
				" where "
				+ " oid_cco_fact=? ");

		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_CCO_FACT, pers.getOID());
		qUpdate.setInt(OID_SUJETO, pers.getSujeto().getOID());
		qUpdate.setString(TIPO_OPER, pers.getTipo_oper());
		qUpdate.setString(TIPO_CLIENTE, pers.getTipo_cliente());
		if (pers.getCaja() != null)
			qUpdate.setInt(OID_CAJA, pers.getCaja().getOID());
		else
			qUpdate.setNull(OID_CAJA, Types.INTEGER);
		if (pers.getFec_caja() != null)
			qUpdate.setDate(FEC_CAJA, new java.sql.Date(pers.getFec_caja().getTime()));
		else
			qUpdate.setNull(FEC_CAJA, Types.DATE);
		qUpdate.setDouble(PORC_BONIF_CLI, pers.getPorc_bonif_cli().doubleValue());
		qUpdate.setDouble(PORC_RECAR_CLI, pers.getPorc_recar_cli().doubleValue());
		qUpdate.setInt(OID_TALONARIO, pers.getTalonario().getOID());
		if (pers.getLista_precios() != null)
			qUpdate.setInt(OID_LISTA_PRECIOS, pers.getLista_precios().getOID());
		else
			qUpdate.setNull(OID_LISTA_PRECIOS, Types.INTEGER);
		qUpdate.setInt(OID_PROVINCIA, pers.getProvincia().getOID());
		qUpdate.setInt(OID_MONEDA, pers.getMoneda().getOID());
		qUpdate.setDouble(COTIZACION, pers.getCotizacion().doubleValue());
		qUpdate.setInt(OID_VENDEDOR, pers.getVendedor().getOID());
		qUpdate.setInt(OID_COND_PAGO, pers.getCond_pago().getOID());
		if (pers.getCompo_stk_fact() != null)
			qUpdate.setInt(OID_COMPO_STK_FACT, pers.getCompo_stk_fact().getOID());
		else
			qUpdate.setNull(OID_COMPO_STK_FACT, Types.INTEGER);
		if (pers.getPorc_bonif_cp() != null)
			qUpdate.setDouble(PORC_BONIF_CP, pers.getPorc_bonif_cp().doubleValue());
		else
			qUpdate.setNull(PORC_BONIF_CP, Types.DOUBLE);
		if (pers.getPorc_recar_cp() != null)
			qUpdate.setDouble(PORC_RECAR_CP, pers.getPorc_recar_cp().doubleValue());
		else
			qUpdate.setNull(PORC_RECAR_CP, Types.NULL);
		qUpdate.setDate(FEC_BASE, new Date(pers.getFec_base().getTime()));
		qUpdate.setInt(OID_SUJ_IMP, pers.getSujeto_impositivo().getOID());
		qUpdate.setInt(SIGNO, pers.getSigno().intValue());
		if (pers.getBruto() != null)
			qUpdate.setDouble(BRUTO, pers.getBruto().doubleValue());
		else
			qUpdate.setNull(BRUTO, java.sql.Types.DOUBLE);
		if (pers.getPorc_dto() != null)
			qUpdate.setDouble(PORC_DTO, pers.getPorc_dto().doubleValue());
		else
			qUpdate.setNull(PORC_DTO, java.sql.Types.DOUBLE);
		if (pers.getDescuento() != null)
			qUpdate.setDouble(DESCUENTO, pers.getDescuento().doubleValue());
		else
			qUpdate.setNull(DESCUENTO, java.sql.Types.DOUBLE);
		if (pers.getPorc_recar() != null)
			qUpdate.setDouble(PORC_RECAR, pers.getPorc_recar().doubleValue());
		else
			qUpdate.setNull(PORC_RECAR, java.sql.Types.DOUBLE);
		if (pers.getRecargo() != null)
			qUpdate.setDouble(RECARGO, pers.getRecargo().doubleValue());
		else
			qUpdate.setNull(RECARGO, java.sql.Types.DOUBLE);
		if (pers.getNeto() != null)
			qUpdate.setDouble(NETO, pers.getNeto().doubleValue());
		else
			qUpdate.setNull(NETO, java.sql.Types.DOUBLE);
		if (pers.getIva() != null)
			qUpdate.setDouble(IVA, pers.getIva().doubleValue());
		else
			qUpdate.setNull(IVA, java.sql.Types.DOUBLE);
		if (pers.getPerc_iva() != null)
			qUpdate.setDouble(PERC_IVA, pers.getPerc_iva().doubleValue());
		else
			qUpdate.setNull(PERC_IVA, java.sql.Types.DOUBLE);
		if (pers.getImp_internos() != null)
			qUpdate.setDouble(IMP_INTERNOS, pers.getImp_internos().doubleValue());
		else
			qUpdate.setNull(IMP_INTERNOS, java.sql.Types.DOUBLE);
		if (pers.getPerc_ib() != null)
			qUpdate.setDouble(PERC_IB, pers.getPerc_ib().doubleValue());
		else
			qUpdate.setNull(PERC_IB, java.sql.Types.DOUBLE);
		if (pers.getTotal() != null)
			qUpdate.setDouble(TOTAL, pers.getTotal().doubleValue());
		else
			qUpdate.setNull(TOTAL, java.sql.Types.DOUBLE);
		if (pers.getImpre_bruto() != null)
			qUpdate.setDouble(IMPRE_BRUTO, pers.getImpre_bruto().doubleValue());
		else
			qUpdate.setNull(IMPRE_BRUTO, java.sql.Types.DOUBLE);
		if (pers.getImpre_bonif() != null)
			qUpdate.setDouble(IMPRE_BONIF, pers.getImpre_bonif().doubleValue());
		else
			qUpdate.setNull(IMPRE_BONIF, java.sql.Types.DOUBLE);
		if (pers.getImpre_recar() != null)
			qUpdate.setDouble(IMPRE_RECAR, pers.getImpre_recar().doubleValue());
		else
			qUpdate.setNull(IMPRE_RECAR, java.sql.Types.DOUBLE);
		if (pers.getImpre_neto() != null)
			qUpdate.setDouble(IMPRE_NETO, pers.getImpre_neto().doubleValue());
		else
			qUpdate.setNull(IMPRE_NETO, java.sql.Types.DOUBLE);
		if (pers.getImpre_iva() != null)
			qUpdate.setDouble(IMPRE_IVA, pers.getImpre_iva().doubleValue());
		else
			qUpdate.setNull(IMPRE_IVA, java.sql.Types.DOUBLE);
		if (pers.getImpre_iva2() != null)
			qUpdate.setDouble(IMPRE_IVA_2, pers.getImpre_iva2().doubleValue());
		else
			qUpdate.setNull(IMPRE_IVA_2, java.sql.Types.DOUBLE);
		
		if (pers.getImpre_perc_iva() != null)
			qUpdate.setDouble(IMPRE_PERC_IVA, pers.getImpre_perc_iva().doubleValue());
		else
			qUpdate.setNull(IMPRE_PERC_IVA, java.sql.Types.DOUBLE);
		if (pers.getImpre_perc_ib() != null)
			qUpdate.setDouble(IMPRE_PERC_IB, pers.getImpre_perc_ib().doubleValue());
		else
			qUpdate.setNull(IMPRE_PERC_IB, java.sql.Types.DOUBLE);
		if (pers.getImpre_imp_int() != null)
			qUpdate.setDouble(IMPRE_IMP_INT, pers.getImpre_imp_int().doubleValue());
		else
			qUpdate.setNull(IMPRE_IMP_INT, java.sql.Types.DOUBLE);
		if (pers.getImpre_total() != null)
			qUpdate.setDouble(IMPRE_TOTAL, pers.getImpre_total().doubleValue());
		else
			qUpdate.setDouble(IMPRE_TOTAL, Types.NULL);

		if (pers.getTipoConfMovStkTalonario() != null)
			qUpdate.setInt(OID_TIPO_CONF_MOV_STK, pers.getTipoConfMovStkTalonario().getOID());
		else
			qUpdate.setNull(OID_TIPO_CONF_MOV_STK, Types.INTEGER);
		
		if (pers.getPercIBBsAs()!=null)
			qUpdate.setDouble(PERC_IB_BA , pers.getPercIBBsAs().doubleValue());
		else
			qUpdate.setDouble(PERC_IB_BA , 0);
		
		if (pers.getPercIBCapFed()!=null)
			qUpdate.setDouble(PERC_IB_CF , pers.getPercIBCapFed().doubleValue());
		else
			qUpdate.setDouble(PERC_IB_CF , 0);
		
		if (pers.getImprePercIBBsAs()!=null)
			qUpdate.setDouble(IMPRE_PERC_IB_BA , pers.getImprePercIBBsAs().doubleValue());
		else
			qUpdate.setDouble(IMPRE_PERC_IB_BA, 0);
		
		if (pers.getImprePercIBCapFed()!=null)
			qUpdate.setDouble(IMPRE_PERC_IB_CF , pers.getImprePercIBCapFed().doubleValue());
		else
			qUpdate.setDouble(IMPRE_PERC_IB_CF, 0);
		
		if (pers.getPercIBBsAsMonLoc()!=null)
			qUpdate.setDouble(PERC_IB_BA_MON_LOC , pers.getPercIBBsAsMonLoc().doubleValue());
		else
			qUpdate.setDouble(PERC_IB_BA_MON_LOC , 0);
		
		if (pers.getPercIBCapFedMonLoc()!=null)
			qUpdate.setDouble(PERC_IB_CF_MON_LOC , pers.getPercIBCapFedMonLoc().doubleValue());
		else
			qUpdate.setDouble(PERC_IB_CF_MON_LOC , 0);
		
		if (pers.getOC()!=null)
			qUpdate.setString(OC , pers.getOC());
		else
			qUpdate.setNull(OC , java.sql.Types.VARCHAR);
		
		if (pers.getConcImpuIVA2()!=null)
			qUpdate.setInt(OID_CONC_IVA_2, pers.getConcImpuIVA2().getOID());
		else
			qUpdate.setNull(OID_CONC_IVA_2, java.sql.Types.INTEGER);
		
		if (pers.getIva2()!=null)
			qUpdate.setDouble(IVA_2, pers.getIva2().doubleValue());
		else
			qUpdate.setNull(IVA_2, java.sql.Types.DOUBLE);
		
		if (pers.getIVA2MonLoc()!=null)
			qUpdate.setDouble(IVA_2_MON_LOC, pers.getIVA2MonLoc().doubleValue());
		else
			qUpdate.setNull(IVA_2_MON_LOC, java.sql.Types.DOUBLE);

		if (pers.getFacturaSenia()!=null)
			qUpdate.setDouble(OID_CCO_FACT_SENIA, pers.getFacturaSenia().getOIDInteger());
		else
			qUpdate.setNull(OID_CCO_FACT_SENIA, java.sql.Types.DOUBLE);
		
		if (pers.getProyecto()!=null)
			qUpdate.setInt(OID_PROYECTO, pers.getProyecto().getOID());
		else
			qUpdate.setNull(OID_PROYECTO, java.sql.Types.INTEGER);
		
		if (pers.getTipoImpresion()!=null)
			qUpdate.setString(TIPO_IMPRESION, pers.getTipoImpresion());
		else
			qUpdate.setNull(TIPO_IMPRESION, Types.VARCHAR);
		
		
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_CCO_FACT = 1;
		FacturaCab pers = (FacturaCab) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update geComproCab " + " set activo=0 " + " where " + " oid_cco=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_CCO_FACT, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_CCO_FACT = 1;
		FacturaCab pers = (FacturaCab) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update veFacturasCab " + " set activo=1 " + " where " + " oid_cco_fact=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_CCO_FACT, pers.getOID());
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
		case SELECT_BY_CLIE_FEC_NRO: {
			ps = this.selectByClienteFechaNro(aCondiciones);
			break;
		}
		case SELECT_BY_FACT_Y_ND: {
			ps = this.selectByFacturaYND(aCondiciones);
			break;
		}
		case SELECT_BY_FACT_SENIA_O_ANTICIPO: {
			ps = this.selectByFacturaSeniaOAnticipo(aCondiciones);
			break;
		}
		case SELECT_BY_TC_LETRA_LE_NRO: {
			ps = this.selectByTCLetraLENro(aCondiciones);
			break;
		}
		case UPDATE_TIPO_IMPRESION: {
			ps = this.updateTipoImpresion(aCondiciones);
			break;
		}
		
		
		}
		return ps;
	}
	
	
	private PreparedStatement selectByTCLetraLENro(Object aCondiciones) throws BaseException, SQLException {

		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		TipoComprobante tc = (TipoComprobante) condiciones.get(TipoComprobante.NICKNAME);
		String letra = condiciones.getString("LETRA");
		LugarEmision lugEmi = (LugarEmision) condiciones.get(LugarEmision.NICKNAME);
		Integer nroExt = condiciones.getInteger("NRO_EXT");
		
		boolean activo = true;
		if (condiciones.containsKey("ACTIVO"))
			activo = true;
		else if (condiciones.containsKey("ANULADO"))
			activo = false;
				
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT a.* , b.* FROM  veFacturasCab a  , geComproCab b ");
		textSQL.append(" WHERE a.oid_cco_fact = b.oid_cco ");
		textSQL.append(" and b.oid_tc = ? ");
		textSQL.append(" and b.letra = ? ");
		textSQL.append(" and b.oid_lug_emi = ? ");
		textSQL.append(" and b.nro_ext = ? ");
		textSQL.append(" and b.activo = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		querySelect.setInt(1, tc.getOID());
		querySelect.setString(2, letra);
		querySelect.setInt(3, lugEmi.getOID());
		querySelect.setInt(4, nroExt.intValue());
		querySelect.setBoolean(5, activo);
		return querySelect;
		
	}

	private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

		final int OID_CCO_FACT = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT a.* , b.* FROM  veFacturasCab a  , geComproCab b ");
		textSQL.append(" WHERE a.oid_cco_fact = b.oid_cco and a.oid_cco_fact = ? ");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		int oid = ((Integer) aCondiciones).intValue();
		querySelect.setInt(OID_CCO_FACT, oid);
		return querySelect;
	}

	private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

		final int CODIGO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  veFacturasCab ");
		textSQL.append(" WHERE  = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		String codigo = (String) aCondiciones;
		querySelect.setString(CODIGO, codigo);
		return querySelect;
	}

	private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();

		textSQL.append("SELECT oid_cco_fact oid, codigo,  descripcion ,activo ");
		textSQL.append(" from veFacturasCab");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}

	public static List getFacturas(Integer nroExtDesde, Integer nroExtHasta, java.util.Date fecDesde,
			java.util.Date fecHasta, Sujeto sujeto, Producto producto, ISesion aSesion) throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		if (nroExtDesde != null)
			condiciones.put("nro_desde", nroExtDesde);
		if (nroExtHasta != null)
			condiciones.put("nro_hasta", nroExtHasta);
		if (fecDesde != null)
			condiciones.put("fec_desde", fecDesde);
		if (fecHasta != null)
			condiciones.put("fec_hasta", fecHasta);
		if (sujeto != null)
			condiciones.put(Sujeto.NICKNAME, sujeto);
		if (producto != null)
			condiciones.put(Producto.NICKNAME, producto);		
		return (List) ObjetoLogico.getObjects(FacturaCab.NICKNAME, DBFacturaCab.SELECT_BY_CLIE_FEC_NRO, condiciones,
				new ListObserver(), aSesion);
	}
	
	public static List getFacturasYND(Integer nroExtDesde, Integer nroExtHasta, java.util.Date fecDesde,
			java.util.Date fecHasta, Sujeto sujeto, ISesion aSesion) throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		if (nroExtDesde != null)
			condiciones.put("nro_desde", nroExtDesde);
		if (nroExtHasta != null)
			condiciones.put("nro_hasta", nroExtHasta);
		if (fecDesde != null)
			condiciones.put("fec_desde", fecDesde);
		if (fecHasta != null)
			condiciones.put("fec_hasta", fecHasta);
		if (sujeto != null)
			condiciones.put(Sujeto.NICKNAME, sujeto);
		return (List) ObjetoLogico.getObjects(FacturaCab.NICKNAME, DBFacturaCab.SELECT_BY_FACT_Y_ND, condiciones,
				new ListObserver(), aSesion);
	}
	
	public static List getFacturasPorSeniaOAnticipo(Integer nroExtDesde, Integer nroExtHasta, java.util.Date fecDesde,
			java.util.Date fecHasta, Sujeto sujeto, Producto producto,String oc,ISesion aSesion) throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		if (nroExtDesde != null)
			condiciones.put("nro_desde", nroExtDesde);
		if (nroExtHasta != null)
			condiciones.put("nro_hasta", nroExtHasta);
		if (fecDesde != null)
			condiciones.put("fec_desde", fecDesde);
		if (fecHasta != null)
			condiciones.put("fec_hasta", fecHasta);
		if (sujeto != null)
			condiciones.put(Sujeto.NICKNAME, sujeto);
		if (producto != null)
			condiciones.put(Producto.NICKNAME, producto);
		if (oc != null)
			condiciones.put("oc", oc);
		
		
		return (List) ObjetoLogico.getObjects(FacturaCab.NICKNAME, DBFacturaCab.SELECT_BY_FACT_SENIA_O_ANTICIPO, condiciones,
				new ListObserver(), aSesion);
	}
	
	
	private PreparedStatement selectByFacturaSeniaOAnticipo(Object aCondiciones) throws BaseException, SQLException {

		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		int nroParam = 0;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT a.*,b.* FROM  veFacturasCab a, geComproCab b ");
		textSQL.append(" WHERE  a.oid_cco_fact = b.oid_cco and b.comportamiento in ('FACLI') and a.tipo_oper='FACT_ANT' ");

		if (condiciones.containsKey(Sujeto.NICKNAME)) {
			Sujeto sujeto = (Sujeto) condiciones.get(Sujeto.NICKNAME);
			textSQL.append(" and a.oid_sujeto = " + sujeto.getOIDInteger().toString());
		}

		if (condiciones.containsKey("nro_desde")) {
			Integer nroDesde = (Integer) condiciones.get("nro_desde");
			textSQL.append(" and b.nro_Ext >= " + nroDesde.toString());
		}
		
		if (condiciones.containsKey("oc")) {
			String oc = (String) condiciones.get("oc");
			textSQL.append(" and a.oc like '%"+oc+"%'");
		}
		
		if (condiciones.containsKey(Producto.NICKNAME)) {
			Producto producto = (Producto) condiciones.get(Producto.NICKNAME);
			textSQL.append(" and a.oid_cco_fact in (select oid_cco_fact from veFacturasDet where oid_producto = "+producto.getOIDInteger()+")");
		}
		
		
		if (condiciones.containsKey("nro_hasta")) {
			Integer nroHasta = (Integer) condiciones.get("nro_hasta");
			textSQL.append(" and b.nro_Ext <= " + nroHasta.toString());
		}

		if (condiciones.containsKey("fec_desde"))
			textSQL.append(" and b.emision >= ? ");

		if (condiciones.containsKey("fec_hasta"))
			textSQL.append(" and b.emision <= ? ");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		if (condiciones.containsKey("fec_desde")) {
			java.util.Date fecDesde = (java.util.Date) condiciones.get("fec_desde");
			++nroParam;
			querySelect.setDate(nroParam, new java.sql.Date(fecDesde.getTime()));
		}
		if (condiciones.containsKey("fec_hasta")) {
			java.util.Date fecHasta = (java.util.Date) condiciones.get("fec_hasta");
			++nroParam;
			querySelect.setDate(nroParam, new java.sql.Date(fecHasta.getTime()));
		}
		return querySelect;
	}
	
	

	private PreparedStatement selectByFacturaYND(Object aCondiciones) throws BaseException, SQLException {

		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		int nroParam = 0;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT a.*,b.* FROM  veFacturasCab a, geComproCab b ");
		textSQL.append(" WHERE  a.oid_cco_fact = b.oid_cco and b.comportamiento in ('FACLI','NDCLI') ");

		if (condiciones.containsKey(Sujeto.NICKNAME)) {
			Sujeto sujeto = (Sujeto) condiciones.get(Sujeto.NICKNAME);
			textSQL.append(" and a.oid_sujeto = " + sujeto.getOIDInteger().toString());
		}

		if (condiciones.containsKey("nro_desde")) {
			Integer nroDesde = (Integer) condiciones.get("nro_desde");
			textSQL.append(" and b.nro_Ext >= " + nroDesde.toString());
		}

		if (condiciones.containsKey("nro_hasta")) {
			Integer nroHasta = (Integer) condiciones.get("nro_hasta");
			textSQL.append(" and b.nro_Ext <= " + nroHasta.toString());
		}

		if (condiciones.containsKey("fec_desde"))
			textSQL.append(" and b.emision >= ? ");

		if (condiciones.containsKey("fec_hasta"))
			textSQL.append(" and b.emision <= ? ");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		if (condiciones.containsKey("fec_desde")) {
			java.util.Date fecDesde = (java.util.Date) condiciones.get("fec_desde");
			++nroParam;
			querySelect.setDate(nroParam, new java.sql.Date(fecDesde.getTime()));
		}
		if (condiciones.containsKey("fec_hasta")) {
			java.util.Date fecHasta = (java.util.Date) condiciones.get("fec_hasta");
			++nroParam;
			querySelect.setDate(nroParam, new java.sql.Date(fecHasta.getTime()));
		}
		return querySelect;
	}
	
	private PreparedStatement updateTipoImpresion(Object aCondiciones) throws BaseException, SQLException {

		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		FacturaCab factura = (FacturaCab) condiciones.get(FacturaCab.NICKNAME);
		String tipoImpresion = (String) condiciones.get("TIPO_IMPRESION");
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update veFacturasCab " + " set tipo_impresion=? " + " where " + " oid_cco_fact=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setString(1, tipoImpresion);
		qUpdate.setInt(2, factura.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
		return null;
		
	}
	

	private PreparedStatement selectByClienteFechaNro(Object aCondiciones) throws BaseException, SQLException {

		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		int nroParam = 0;
		
		Producto producto = null;
		if (condiciones.containsKey(Producto.NICKNAME)) 
			producto = (Producto) condiciones.get(Producto.NICKNAME);

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT a.*,b.* FROM  veFacturasCab a, geComproCab b ");
		
		if (producto!=null)
			textSQL.append(" ,veFacturasDet c ");
		
		textSQL.append(" WHERE  a.oid_cco_fact = b.oid_cco ");

		if (producto!=null)
			textSQL.append(" and a.oid_cco_fact = c.oid_cco_fact and c.oid_producto = "+producto.getOIDInteger()+" ");
		
		if (condiciones.containsKey(Sujeto.NICKNAME)) {
			Sujeto sujeto = (Sujeto) condiciones.get(Sujeto.NICKNAME);
			textSQL.append(" and a.oid_sujeto = " + sujeto.getOIDInteger().toString());
		}
		

		if (condiciones.containsKey("nro_desde")) {
			Integer nroDesde = (Integer) condiciones.get("nro_desde");
			textSQL.append(" and b.nro_Ext >= " + nroDesde.toString());
		}

		if (condiciones.containsKey("nro_hasta")) {
			Integer nroHasta = (Integer) condiciones.get("nro_hasta");
			textSQL.append(" and b.nro_Ext <= " + nroHasta.toString());
		}

		if (condiciones.containsKey("fec_desde"))
			textSQL.append(" and b.emision >= ? ");

		if (condiciones.containsKey("fec_hasta"))
			textSQL.append(" and b.emision <= ? ");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		if (condiciones.containsKey("fec_desde")) {
			java.util.Date fecDesde = (java.util.Date) condiciones.get("fec_desde");
			++nroParam;
			querySelect.setDate(nroParam, new java.sql.Date(fecDesde.getTime()));
		}
		if (condiciones.containsKey("fec_hasta")) {
			java.util.Date fecHasta = (java.util.Date) condiciones.get("fec_hasta");
			++nroParam;
			querySelect.setDate(nroParam, new java.sql.Date(fecHasta.getTime()));
		}
		return querySelect;
	}
	
	public static FacturaCab getFacturaCab(
			TipoComprobante tc,
			String letra,
			LugarEmision le,
			Integer nroExt,
			boolean activo,
	        ISesion aSesion)
	        throws BaseException {
		
		  HashTableDatos condiciones = new HashTableDatos();
		  condiciones.put(TipoComprobante.NICKNAME, tc);
		  condiciones.put("LETRA", letra);
		  condiciones.put(LugarEmision.NICKNAME, le);
		  condiciones.put("NRO_EXT", nroExt.intValue());
		  if (activo)
			  condiciones.put("ACTIVO","");
		  else
			  condiciones.put("NO_ACTIVO","");
		  return (FacturaCab) ObjetoLogico.getObjects(FacturaCab.NICKNAME,
				  				DBFacturaCab.SELECT_BY_TC_LETRA_LE_NRO,
				  				condiciones,
				  				new ObjetoObservado(),
				  				aSesion);
	  }
	
	  public static void updateTipoImpresion(FacturaCab factura,
			  String tipoImpresion,
		      ISesion aSesion)
		  throws BaseException {
		   HashTableDatos condiciones = new HashTableDatos();
		   condiciones.put("TIPO_IMPRESION", tipoImpresion);
		   condiciones.put(FacturaCab.NICKNAME, factura);
		   
		  	ObjetoLogico.getObjects(FacturaCab.NICKNAME,
			  				DBFacturaCab.UPDATE_TIPO_IMPRESION,
			  				condiciones,
			  				null,
			  				aSesion);
	  }

}
