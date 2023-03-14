package com.srn.erp.ventas.da;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import com.srn.erp.general.bm.LugarEmision;
import com.srn.erp.general.bm.TipoComprobante;
import com.srn.erp.stock.bm.Producto;
import com.srn.erp.ventas.bm.PedidoCab;
import com.srn.erp.ventas.bm.RemitoCab;
import com.srn.erp.ventas.bm.Sujeto;
import com.srn.erp.ventas.bm.Vendedor;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.ObjetoObservado;

public class DBPedidoCab extends DBObjetoPersistente {

	public static final String	OID_CCO_PED											= "oid_cco_ped";

	public static final String	OID_SUJETO											= "oid_sujeto";

	public static final String	OID_MONEDA											= "oid_moneda";

	public static final String	COTIZACION											= "cotizacion";

	public static final String	MERCADO													= "mercado";

	public static final String	PORC_BONIF_CLI									= "porc_bonif_cli";

	public static final String	PORC_RECA_CLI										= "porc_reca_cli";

	public static final String	BONIF_CLI_CASCADA								= "bonif_cli_cascada";

	public static final String	RECA_CLI_CASCADA								= "reca_cli_cascada";

	public static final String	OID_PRECIO_CAB									= "oid_precio_cab";

	public static final String	OID_COND_PAGO										= "oid_cond_pago";

	public static final String	OID_VENDEDOR										= "oid_vendedor";

	public static final String	OID_UNI_EDI											= "oid_uni_edi";

	public static final String	PORC_BONIF_CP										= "porc_bonif_cp";

	public static final String	PORC_RECA_CP										= "porc_reca_cp";

	public static final String	BONIF_CP_CASCADA								= "bonif_cp_cascada";

	public static final String	RECA_CP_CASCADA									= "reca_cp_cascada";

	public static final String	OBSERVADO												= "observado";

	public static final String	COMENTARIO											= "comentario";

	public static final String	PEND_ENT												= "pend_ent";

	public static final String	OID_TRANSPORTE									= "oid_transporte";

	public static final String	OID_MONEDA_FACT									= "oid_moneda_fact";

	public static final String	PEND_DESP												= "pend_desp";

	public static final String	OID_FORMA_ENTREGA								= "oid_forma_entrega";

	public static final String	ORDEN_COMPRA										= "orden_compra";

	public static final String	PEND_FACT												= "pend_fact";

	public static final String	OID_CONTACTO										= "oid_contacto";

	public static final String	BRUTO														= "bruto";

	public static final String	PORC_DTO												= "porc_dto";

	public static final String	DESCUENTO												= "descuento";

	public static final String	PORC_RECAR											= "porc_recar";

	public static final String	RECARGO													= "recargo";

	public static final String	NETO														= "neto";

	public static final String	IVA															= "iva";

	public static final String	PERC_IVA												= "perc_iva";

	public static final String	IMP_INTERNOS										= "imp_internos";

	public static final String	PERC_IB													= "perc_ib";

	public static final String	TOTAL														= "total";

	public static final String	IMPRE_BRUTO											= "impre_bruto";

	public static final String	IMPRE_BONIF											= "impre_bonif";

	public static final String	IMPRE_RECAR											= "impre_recar";

	public static final String	IMPRE_NETO											= "impre_neto";

	public static final String	IMPRE_IVA												= "impre_iva";

	public static final String	IMPRE_PERC_IVA									= "impre_perc_iva";

	public static final String	IMPRE_PERC_IB										= "impre_perc_ib";

	public static final String	IMPRE_IMP_INT										= "impre_imp_int";

	public static final String	IMPRE_TOTAL											= "impre_total";

	public static final String	IMPRE_PORC_RECAR								= "impre_porc_recar";

	public static final String	IMPRE_PORC_BONIF								= "impre_porc_bonif";

	public static final String	NETO_GRAVADO										= "neto_gravado";

	public static final String	NETO_NO_GRAVADO									= "neto_no_gravado";

	public static final String	NETO_GRAV_LOC										= "neto_grav_loc";

	public static final String	NETO_NO_GRAV_LOC								= "neto_no_grav_loc";

	public static final String	BRUTO_MON_LOC										= "bruto_mon_loc";

	public static final String	PORC_DTO_MON_LOC								= "porc_dto_mon_loc";

	public static final String	DTO_MON_LOC											= "dto_mon_loc";

	public static final String	PORC_RECAR_MON_LOC							= "porc_recar_mon_loc";

	public static final String	RECARGO_MON_LOC									= "recargo_mon_loc";

	public static final String	NETO_MON_LOC										= "neto_mon_loc";

	public static final String	IVA_MON_LOC											= "iva_mon_loc";

	public static final String	PERC_IVA_MON_LOC								= "perc_iva_mon_loc";

	public static final String	IMP_INT_MON_LOC									= "imp_int_mon_loc";

	public static final String	PERC_IB_MON_LOC									= "perc_ib_mon_loc";

	public static final String	TOTAL_MON_LOC										= "tot_mon_loc";

	public static final String	OID_CONC_IVA										= "oid_conc_iva";

	public static final String	OID_CONC_PERC_IVA								= "oid_conc_perc_iva";

	public static final String	OID_CONC_IMP_INT								= "oid_conc_imp_int";

	public static final String	OID_CONC_PERC_IB								= "oid_conc_perc_ib";
	
	public static final String COTIZ_MON_FACT										= "cotiz_mon_fact";
	
	public static final String COMPOR_COTIZ_FACT								= "compor_cotiz_fact";
	
	public static final String PUEDE_ANULAR_SC									= "puede_anular_sc";
	
	public static final String IVA_2 = "iva_2";
	public static final String IMPRE_IVA_2 = "impre_iva_2";
	public static final String OID_CONC_IVA_2 = "oid_conc_iva_2";
	public static final String IVA_2_MON_LOC = "iva_2_mon_loc";
	public static final String OID_PROYECTO = "oid_proyecto";
	
	
	public static final int			SELECT_BY_CLIE_FEC_NRO					= 100;

	public static final int			SELECT_BY_PED_PEND_ENT					= 101;

	public static final int			SELECT_BY_TC_LETRA_LE_NROEXT		= 102;

	public static final int			SELECT_BY_CONDICIONES					= 103;

	public static final int			SELECT_BY_MARCAR_PED_COMO_NO_PEND_DESP	= 104;
	public static final int			SELECT_BY_MARCAR_PED_COMO_NO_PEND_FACT	= 105;
	
	public static final int			SELECT_BY_PED					= 106;
	
	public static final int 		SELECT_BY_TC_LETRA_LE_NRO = 107;
	
	public static final int			UPDATE_MARCAR_PUEDE_ANULAR_SC = 108;

	public DBPedidoCab() {
	}

	protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_CCO_PED = 1;
		final int OID_SUJETO = 2;
		final int OID_MONEDA = 3;
		final int COTIZACION = 4;
		final int MERCADO = 5;
		final int PORC_BONIF_CLI = 6;
		final int PORC_RECA_CLI = 7;
		final int BONIF_CLI_CASCADA = 8;
		final int RECA_CLI_CASCADA = 9;
		final int OID_PRECIO_CAB = 10;
		final int OID_COND_PAGO = 11;
		final int OID_VENDEDOR = 12;
		final int OID_UNI_EDI = 13;
		final int PORC_BONIF_CP = 14;
		final int PORC_RECA_CP = 15;
		final int BONIF_CP_CASCADA = 16;
		final int RECA_CP_CASCADA = 17;
		final int OBSERVADO = 18;
		final int COMENTARIO = 19;
		final int PEND_ENT = 20;
		final int OID_TRANSPORTE = 21;
		final int OID_MONEDA_FACT = 22;
		final int PEND_DESP = 23;
		final int OID_FORMA_ENTREGA = 24;
		final int ORDEN_COMPRA = 25;

		final int BRUTO = 26;
		final int PORC_DTO = 27;
		final int DESCUENTO = 28;
		final int PORC_RECAR = 29;
		final int RECARGO = 30;
		final int NETO = 31;
		final int IVA = 32;
		final int PERC_IVA = 33;
		final int IMP_INTERNOS = 34;
		final int PERC_IB = 35;
		final int TOTAL = 36;
		final int IMPRE_BRUTO = 37;
		final int IMPRE_BONIF = 38;
		final int IMPRE_RECAR = 39;
		final int IMPRE_NETO = 40;
		final int IMPRE_IVA = 41;
		final int IMPRE_PERC_IVA = 42;
		final int IMPRE_PERC_IB = 43;
		final int IMPRE_IMP_INT = 44;
		final int IMPRE_TOTAL = 45;
		final int BRUTO_MON_LOC = 46;
		final int PORC_DTO_MON_LOC = 47;
		final int DTO_MON_LOC = 48;
		final int PORC_RECAR_MON_LOC = 49;
		final int RECARGO_MON_LOC = 50;
		final int NETO_MON_LOC = 51;
		final int IVA_MON_LOC = 52;
		final int PERC_IVA_MON_LOC = 53;
		final int IMP_INT_MON_LOC = 54;
		final int PERC_IB_MON_LOC = 55;
		final int TOTAL_MON_LOC = 56;
		final int IMPRE_PORC_BONIF = 57;
		final int IMPRE_PORC_RECAR = 58;
		final int OID_CONC_IVA = 59;
		final int OID_CONC_PERC_IVA = 60;
		final int OID_CONC_PERC_IB = 61;
		final int OID_CONC_IMP_INT = 62;
		final int NETO_GRAVADO = 63;
		final int NETO_NO_GRAVADO = 64;
		final int NETO_GRAV_LOC = 65;
		final int NETO_NO_GRAV_LOC = 66;
		final int PEND_FACT = 67;
		final int OID_CONTACTO = 68;
		final int COTIZ_MON_FACT = 69;
		final int COMPOR_COTIZ_FACT = 70;
		final int IVA_2 = 71;
		final int IMPRE_IVA_2 = 72;
		final int OID_CONC_IVA_2 = 73;
		final int IVA_2_MON_LOC = 74;
		final int OID_PROYECTO = 75;
		final int PUEDE_ANULAR_SC = 76;
		
		

		PedidoCab pers = (PedidoCab) objetoPersistente;

		StringBuffer sqlInsert = new StringBuffer();
		sqlInsert.append(" insert into vePedidosCab " + " ( " + "OID_CCO_PED," + "OID_SUJETO," + "OID_MONEDA,"
				+ "COTIZACION," + "MERCADO," + "PORC_BONIF_CLI," + "PORC_RECA_CLI," + "BONIF_CLI_CASCADA,"
				+ "RECA_CLI_CASCADA," + "OID_PRECIO_CAB," + "OID_COND_PAGO," + "OID_VENDEDOR," + "OID_UNI_EDI,"
				+ "PORC_BONIF_CP," + "PORC_RECA_CP," + "BONIF_CP_CASCADA," + "RECA_CP_CASCADA," + "OBSERVADO," + "COMENTARIO,"
				+ "PEND_ENT,OID_TRANSPORTE,OID_MONEDA_FACT, PEND_DESP , OID_FORMA_ENTREGA, ORDEN_COMPRA," + "BRUTO,"
				+ "PORC_DTO," + "DESCUENTO," + "PORC_RECAR," + "RECARGO," + "NETO," + "IVA," + "PERC_IVA," + "IMP_INTERNOS,"
				+ "PERC_IB," + "TOTAL," + "IMPRE_BRUTO," + "IMPRE_BONIF," + "IMPRE_RECAR," + "IMPRE_NETO," + "IMPRE_IVA,"
				+ "IMPRE_PERC_IVA," + "IMPRE_PERC_IB," + "IMPRE_IMP_INT," + "IMPRE_TOTAL," + "BRUTO_MON_LOC,"
				+ "PORC_DTO_MON_LOC," + "DTO_MON_LOC," + "PORC_RECAR_MON_LOC," + "RECARGO_MON_LOC," + "NETO_MON_LOC,"
				+ "IVA_MON_LOC," + "PERC_IVA_MON_LOC," + "IMP_INT_MON_LOC," + "PERC_IB_MON_LOC," + "TOTAL_MON_LOC,"
				+ "IMPRE_PORC_BONIF," + "IMPRE_PORC_RECAR," + "OID_CONC_IVA," + "OID_CONC_PERC_IVA," + "OID_CONC_IMP_INT,"
				+ "OID_CONC_PERC_IB," + "NETO_GRAVADO," + "NETO_NO_GRAVADO," + "NETO_GRAV_LOC,"
				+ "NETO_NO_GRAV_LOC,PEND_FACT,OID_CONTACTO,COTIZ_MON_FACT , COMPOR_COTIZ_FACT" +
				",IVA_2,IMPRE_IVA_2,OID_CONC_IVA_2,IVA_2_MON_LOC , OID_PROYECTO , PUEDE_ANULAR_SC"+
				")" + " values " + "(" + "?," + "?," + "?," + "?," + "?," + "?,"+ "?," + "?," + "?," + "?,"+ "?,"+ "?,"
				+ "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?,"
				+ "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?,"
				+ "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?,"
				+ "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?,"+ "?,"+ "?," + "?) ");

		PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
		qInsert.setInt(OID_CCO_PED, pers.getOID());
		qInsert.setInt(OID_SUJETO, pers.getSujeto().getOID());
		qInsert.setInt(OID_MONEDA, pers.getMoneda().getOID());
		qInsert.setDouble(COTIZACION, pers.getCotizacion().doubleValue());
		qInsert.setString(MERCADO, pers.getMercado());
		qInsert.setDouble(PORC_BONIF_CLI, pers.getPorc_bonif_cli().doubleValue());
		qInsert.setDouble(PORC_RECA_CLI, pers.getPorc_reca_cli().doubleValue());
		qInsert.setBoolean(BONIF_CLI_CASCADA, pers.isBonif_cli_cascada().booleanValue());
		qInsert.setBoolean(RECA_CLI_CASCADA, pers.isReca_cli_cascada().booleanValue());
		qInsert.setInt(OID_PRECIO_CAB, pers.getLista_precios().getOID());
		qInsert.setInt(OID_COND_PAGO, pers.getCondicionPago().getOID());
		qInsert.setInt(OID_VENDEDOR, pers.getVendedor().getOID());
		if (pers.getDomicilio_entrega() != null)
			qInsert.setInt(OID_UNI_EDI, pers.getDomicilio_entrega().getOID());
		else
			qInsert.setNull(OID_UNI_EDI, Types.INTEGER);
		qInsert.setDouble(PORC_BONIF_CP, pers.getPorc_bonif_cp().doubleValue());
		qInsert.setDouble(PORC_RECA_CP, pers.getPorc_reca_cp().doubleValue());
		qInsert.setBoolean(BONIF_CP_CASCADA, pers.isBonif_cp_cascada().booleanValue());
		qInsert.setBoolean(RECA_CP_CASCADA, pers.isReca_cp_cascada().booleanValue());
		qInsert.setBoolean(OBSERVADO, pers.isObservado().booleanValue());
		qInsert.setString(COMENTARIO, pers.getComentario());
		qInsert.setBoolean(PEND_ENT, pers.isPendEnt().booleanValue());
		qInsert.setBoolean(PEND_FACT, pers.isPendFact().booleanValue());
		if (pers.getTransporte() != null)
			qInsert.setInt(OID_TRANSPORTE, pers.getTransporte().getOID());
		else
			qInsert.setNull(OID_TRANSPORTE, Types.INTEGER);
		qInsert.setInt(OID_MONEDA_FACT, pers.getMonedaFact().getOID());
		qInsert.setBoolean(PEND_DESP, pers.isPendDesp().booleanValue());
		if (pers.getFormaEntrega() != null)
			qInsert.setInt(OID_FORMA_ENTREGA, pers.getFormaEntrega().getOID());
		else
			qInsert.setNull(OID_FORMA_ENTREGA, Types.INTEGER);
		if (pers.getOrdenDeCompra() != null)
			qInsert.setString(ORDEN_COMPRA, pers.getOrdenDeCompra());
		else
			qInsert.setNull(ORDEN_COMPRA, Types.VARCHAR);

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
		if (pers.getContactoSujeto() != null)
			qInsert.setDouble(OID_CONTACTO, pers.getContactoSujeto().getOID());
		else
			qInsert.setNull(OID_CONTACTO, java.sql.Types.INTEGER);
		if (pers.getCotizMonFact() != null)
			qInsert.setDouble(COTIZ_MON_FACT, pers.getCotizMonFact().doubleValue());
		else
			qInsert.setNull(COTIZ_MON_FACT, java.sql.Types.DOUBLE);
		if (pers.getComporCotizFact() != null)
			qInsert.setString(COMPOR_COTIZ_FACT, pers.getComporCotizFact());
		else
			qInsert.setNull(COMPOR_COTIZ_FACT, java.sql.Types.VARCHAR);
		
		if (pers.getIva2() != null)
			qInsert.setDouble(IVA_2, pers.getIva2().doubleValue());
		else
			qInsert.setNull(IVA_2, java.sql.Types.DOUBLE);
		
		if (pers.getImpre_iva2() != null)
			qInsert.setDouble(IMPRE_IVA_2, pers.getImpre_iva2().doubleValue());
		else
			qInsert.setNull(IMPRE_IVA_2, java.sql.Types.DOUBLE);
		
		if (pers.getConcImpuIVA2() != null)
			qInsert.setInt(OID_CONC_IVA_2, pers.getConcImpuIVA2().getOID());
		else
			qInsert.setNull(OID_CONC_IVA_2, java.sql.Types.INTEGER);
		
		if (pers.getIVAMonLoc2() != null)
			qInsert.setDouble(IVA_2_MON_LOC, pers.getIVAMonLoc2().doubleValue());
		else
			qInsert.setNull(IVA_2_MON_LOC, java.sql.Types.DOUBLE);
		
		if (pers.getProyecto() != null)
			qInsert.setInt(OID_PROYECTO, pers.getProyecto().getOID());
		else
			qInsert.setNull(OID_PROYECTO, java.sql.Types.INTEGER);
		
		if (pers.isPuedeAnularSinControl() != null)
			qInsert.setBoolean(PUEDE_ANULAR_SC, pers.isPuedeAnularSinControl().booleanValue());
		else
			qInsert.setNull(PUEDE_ANULAR_SC, java.sql.Types.BOOLEAN);
		
		
		qInsert.executeUpdate();
		qInsert.close();
	}

	protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_SUJETO = 1;
		final int OID_MONEDA = 2;
		final int COTIZACION = 3;
		final int MERCADO = 4;
		final int PORC_BONIF_CLI = 5;
		final int PORC_RECA_CLI = 6;
		final int BONIF_CLI_CASCADA = 7;
		final int RECA_CLI_CASCADA = 8;
		final int OID_PRECIO_CAB = 9;
		final int OID_COND_PAGO = 10;
		final int OID_VENDEDOR = 11;
		final int OID_UNI_EDI = 12;
		final int PORC_BONIF_CP = 13;
		final int PORC_RECA_CP = 14;
		final int BONIF_CP_CASCADA = 15;
		final int RECA_CP_CASCADA = 16;
		final int OBSERVADO = 17;
		final int COMENTARIO = 18;
		final int PEND_ENT = 19;
		final int OID_TRANSPORTE = 20;
		final int OID_MONEDA_FACT = 21;
		final int PEND_DESP = 22;
		final int OID_FORMA_ENTREGA = 23;
		final int ORDEN_COMPRA = 24;

		final int BRUTO = 25;
		final int PORC_DTO = 26;
		final int DESCUENTO = 27;
		final int PORC_RECAR = 28;
		final int RECARGO = 29;
		final int NETO = 30;
		final int IVA = 31;
		final int PERC_IVA = 32;
		final int IMP_INTERNOS = 33;
		final int PERC_IB = 34;
		final int TOTAL = 35;
		final int IMPRE_BRUTO = 36;
		final int IMPRE_BONIF = 37;
		final int IMPRE_RECAR = 38;
		final int IMPRE_NETO = 39;
		final int IMPRE_IVA = 40;
		final int IMPRE_PERC_IVA = 41;
		final int IMPRE_PERC_IB = 42;
		final int IMPRE_IMP_INT = 43;
		final int IMPRE_TOTAL = 44;
		final int BRUTO_MON_LOC = 45;
		final int PORC_DTO_MON_LOC = 46;
		final int DTO_MON_LOC = 47;
		final int PORC_RECAR_MON_LOC = 48;
		final int RECARGO_MON_LOC = 49;
		final int NETO_MON_LOC = 50;
		final int IVA_MON_LOC = 51;
		final int PERC_IVA_MON_LOC = 52;
		final int IMP_INT_MON_LOC = 53;
		final int PERC_IB_MON_LOC = 54;
		final int TOTAL_MON_LOC = 55;
		final int IMPRE_PORC_BONIF = 56;
		final int IMPRE_PORC_RECAR = 57;
		final int OID_CONC_IVA = 58;
		final int OID_CONC_PERC_IVA = 59;
		final int OID_CONC_PERC_IB = 60;
		final int OID_CONC_IMP_INT = 61;
		final int NETO_GRAVADO = 62;
		final int NETO_NO_GRAVADO = 63;
		final int NETO_GRAV_LOC = 64;
		final int NETO_NO_GRAV_LOC = 65;
		final int PEND_FACT = 66;
		final int OID_CONTACTO = 67;
		final int COTIZ_MON_FACT = 68;
		final int COMPOR_COTIZ_FACT = 69;
		final int IVA_2 = 70;
		final int IMPRE_IVA_2 = 71;
		final int OID_CONC_IVA_2 = 72;
		final int IVA_2_MON_LOC = 73;	
		final int OID_PROYECTO = 74;
		final int PUEDE_ANULAR_SC = 75;
		final int OID_CCO_PED = 76;

		PedidoCab pers = (PedidoCab) objetoPersistente;

		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append(" update vePedidosCab set " + "oid_sujeto=?" + ",oid_moneda=?" + ",cotizacion=?" + ",mercado=?"
				+ ",porc_bonif_cli=?" + ",porc_reca_cli=?" + ",bonif_cli_cascada=?" + ",reca_cli_cascada=?"
				+ ",oid_precio_cab=?" + ",oid_cond_pago=?" + ",oid_vendedor=?" + ",oid_uni_edi=?" + ",porc_bonif_cp=?"
				+ ",porc_reca_cp=?" + ",bonif_cp_cascada=?" + ",reca_cp_cascada=?" + ",observado=?" + ",comentario=?"
				+ ",pend_ent=?" + ",oid_transporte=?" + ",oid_moneda_fact=?" + ",pend_desp=?" + ",oid_forma_entrega=?"
				+ ",orden_compra=?," + "BRUTO=?," + "PORC_DTO=?," + "DESCUENTO=?," + "PORC_RECAR=?," + "RECARGO=?," + "NETO=?,"
				+ "IVA=?," + "PERC_IVA=?," + "IMP_INTERNOS=?," + "PERC_IB=?," + "TOTAL=?," + "IMPRE_BRUTO=?,"
				+ "IMPRE_BONIF=?," + "IMPRE_RECAR=?," + "IMPRE_NETO=?," + "IMPRE_IVA=?," + "IMPRE_PERC_IVA=?,"
				+ "IMPRE_PERC_IB=?," + "IMPRE_IMP_INT=?," + "IMPRE_TOTAL=?," + "BRUTO_MON_LOC=?," + "PORC_DTO_MON_LOC=?,"
				+ "DTO_MON_LOC=?," + "PORC_RECAR_MON_LOC=?," + "RECARGO_MON_LOC=?," + "NETO_MON_LOC=?," + "IVA_MON_LOC=?,"
				+ "PERC_IVA_MON_LOC=?," + "IMP_INT_MON_LOC=?," + "PERC_IB_MON_LOC=?," + "TOTAL_MON_LOC=?,"
				+ "IMPRE_PORC_BONIF=?," + "IMPRE_PORC_RECAR=?," + "OID_CONC_IVA=?," + "OID_CONC_PERC_IVA=?,"
				+ "OID_CONC_IMP_INT=?," + "OID_CONC_PERC_IB=?," + "NETO_GRAVADO=?," + "NETO_NO_GRAVADO=?," + "NETO_GRAV_LOC=?,"
				+ "NETO_NO_GRAV_LOC=?," + "PEND_FACT=?," + "oid_contacto=? , COTIZ_MON_FACT=? , COMPOR_COTIZ_FACT=?" +
				",IVA_2=?,IMPRE_IVA_2=?,OID_CONC_IVA_2=?,IVA_2_MON_LOC=?,OID_PROYECTO=?,PUEDE_ANULAR_SC=? where " + " oid_cco_ped=? ");

		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_CCO_PED, pers.getOID());
		qUpdate.setInt(OID_SUJETO, pers.getSujeto().getOID());
		qUpdate.setInt(OID_MONEDA, pers.getMoneda().getOID());
		qUpdate.setDouble(COTIZACION, pers.getCotizacion().doubleValue());
		qUpdate.setString(MERCADO, pers.getMercado());
		qUpdate.setDouble(PORC_BONIF_CLI, pers.getPorc_bonif_cli().doubleValue());
		qUpdate.setDouble(PORC_RECA_CLI, pers.getPorc_reca_cli().doubleValue());
		qUpdate.setBoolean(BONIF_CLI_CASCADA, pers.isBonif_cli_cascada().booleanValue());
		qUpdate.setBoolean(RECA_CLI_CASCADA, pers.isReca_cli_cascada().booleanValue());
		qUpdate.setInt(OID_PRECIO_CAB, pers.getLista_precios().getOID());
		qUpdate.setInt(OID_COND_PAGO, pers.getCondicionPago().getOID());
		qUpdate.setInt(OID_VENDEDOR, pers.getVendedor().getOID());
		if (pers.getDomicilio_entrega() != null)
			qUpdate.setInt(OID_UNI_EDI, pers.getDomicilio_entrega().getOID());
		else
			qUpdate.setNull(OID_UNI_EDI, Types.INTEGER);

		qUpdate.setDouble(PORC_BONIF_CP, pers.getPorc_bonif_cp().doubleValue());
		qUpdate.setDouble(PORC_RECA_CP, pers.getPorc_reca_cp().doubleValue());
		qUpdate.setBoolean(BONIF_CP_CASCADA, pers.isBonif_cp_cascada().booleanValue());
		qUpdate.setBoolean(RECA_CP_CASCADA, pers.isReca_cp_cascada().booleanValue());
		qUpdate.setBoolean(OBSERVADO, pers.isObservado().booleanValue());
		qUpdate.setString(COMENTARIO, pers.getComentario());
		qUpdate.setBoolean(PEND_ENT, pers.isPendEnt().booleanValue());
		if (pers.getTransporte() != null)
			qUpdate.setInt(OID_TRANSPORTE, pers.getTransporte().getOID());
		else
			qUpdate.setNull(OID_TRANSPORTE, Types.INTEGER);
		qUpdate.setBoolean(PEND_DESP, pers.isPendDesp().booleanValue());
		qUpdate.setInt(OID_MONEDA_FACT, pers.getMonedaFact().getOID());
		if (pers.getFormaEntrega() != null)
			qUpdate.setInt(OID_FORMA_ENTREGA, pers.getFormaEntrega().getOID());
		else
			qUpdate.setNull(OID_FORMA_ENTREGA, Types.INTEGER);
		if (pers.getOrdenDeCompra() != null)
			qUpdate.setString(ORDEN_COMPRA, pers.getOrdenDeCompra());
		else
			qUpdate.setNull(ORDEN_COMPRA, Types.VARCHAR);

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
			qUpdate.setNull(IMPRE_TOTAL, Types.DOUBLE);

		if (pers.getBrutoMonLoc() != null)
			qUpdate.setDouble(BRUTO_MON_LOC, pers.getBrutoMonLoc().doubleValue());
		else
			qUpdate.setNull(BRUTO_MON_LOC, Types.DOUBLE);
		if (pers.getPorcDtoMonLoc() != null)
			qUpdate.setDouble(PORC_DTO_MON_LOC, pers.getPorcDtoMonLoc().doubleValue());
		else
			qUpdate.setNull(PORC_DTO_MON_LOC, Types.DOUBLE);
		if (pers.getDtoMonLoc() != null)
			qUpdate.setDouble(DTO_MON_LOC, pers.getDtoMonLoc().doubleValue());
		else
			qUpdate.setNull(DTO_MON_LOC, Types.DOUBLE);
		if (pers.getPorcRecarMonLoc() != null)
			qUpdate.setDouble(PORC_RECAR_MON_LOC, pers.getPorcRecarMonLoc().doubleValue());
		else
			qUpdate.setNull(PORC_RECAR_MON_LOC, Types.DOUBLE);
		if (pers.getRecargoMonLoc() != null)
			qUpdate.setDouble(RECARGO_MON_LOC, pers.getRecargoMonLoc().doubleValue());
		else
			qUpdate.setNull(RECARGO_MON_LOC, Types.DOUBLE);
		if (pers.getNetoMonedaLocal() != null)
			qUpdate.setDouble(NETO_MON_LOC, pers.getNetoMonedaLocal().doubleValue());
		else
			qUpdate.setNull(NETO_MON_LOC, Types.DOUBLE);
		if (pers.getIVAMonLoc() != null)
			qUpdate.setDouble(IVA_MON_LOC, pers.getIVAMonLoc().doubleValue());
		else
			qUpdate.setNull(IVA_MON_LOC, Types.DOUBLE);
		if (pers.getPercIVAMonLoc() != null)
			qUpdate.setDouble(PERC_IVA_MON_LOC, pers.getPercIVAMonLoc().doubleValue());
		else
			qUpdate.setNull(PERC_IVA_MON_LOC, Types.DOUBLE);
		if (pers.getImpuIntMonLoc() != null)
			qUpdate.setDouble(IMP_INT_MON_LOC, pers.getImpuIntMonLoc().doubleValue());
		else
			qUpdate.setNull(IMP_INT_MON_LOC, Types.DOUBLE);
		if (pers.getPercIBMonLoc() != null)
			qUpdate.setDouble(PERC_IB_MON_LOC, pers.getPercIBMonLoc().doubleValue());
		else
			qUpdate.setNull(PERC_IB_MON_LOC, Types.DOUBLE);
		if (pers.getTotMonLoc() != null)
			qUpdate.setDouble(TOTAL_MON_LOC, pers.getTotMonLoc().doubleValue());
		else
			qUpdate.setNull(TOTAL_MON_LOC, Types.DOUBLE);
		if (pers.getImprePorcBonif() != null)
			qUpdate.setDouble(IMPRE_PORC_BONIF, pers.getImprePorcBonif().doubleValue());
		else
			qUpdate.setNull(IMPRE_PORC_BONIF, Types.DOUBLE);
		if (pers.getImprePorcRecar() != null)
			qUpdate.setDouble(IMPRE_PORC_RECAR, pers.getImprePorcRecar().doubleValue());
		else
			qUpdate.setNull(IMPRE_PORC_RECAR, Types.DOUBLE);
		if (pers.getConcImpuIVA() != null)
			qUpdate.setInt(OID_CONC_IVA, pers.getConcImpuIVA().getOID());
		else
			qUpdate.setNull(OID_CONC_IVA, Types.INTEGER);
		if (pers.getConcImpuPercIVA() != null)
			qUpdate.setInt(OID_CONC_PERC_IVA, pers.getConcImpuPercIVA().getOID());
		else
			qUpdate.setNull(OID_CONC_PERC_IVA, Types.INTEGER);
		if (pers.getConcImpuPercIB() != null)
			qUpdate.setInt(OID_CONC_PERC_IB, pers.getConcImpuPercIB().getOID());
		else
			qUpdate.setNull(OID_CONC_PERC_IB, Types.INTEGER);
		if (pers.getConcImpInt() != null)
			qUpdate.setInt(OID_CONC_IMP_INT, pers.getConcImpInt().getOID());
		else
			qUpdate.setNull(OID_CONC_IMP_INT, Types.INTEGER);
		if (pers.getNetoGravado() != null)
			qUpdate.setDouble(NETO_GRAVADO, pers.getNetoGravado().doubleValue());
		else
			qUpdate.setNull(NETO_GRAVADO, Types.DOUBLE);
		if (pers.getNetoNoGravado() != null)
			qUpdate.setDouble(NETO_NO_GRAVADO, pers.getNetoNoGravado().doubleValue());
		else
			qUpdate.setNull(NETO_NO_GRAVADO, Types.DOUBLE);
		if (pers.getNetoGravadoMonLoc() != null)
			qUpdate.setDouble(NETO_GRAV_LOC, pers.getNetoGravadoMonLoc().doubleValue());
		else
			qUpdate.setNull(NETO_GRAV_LOC, Types.DOUBLE);
		if (pers.getNetoNoGravadoMonLoc() != null)
			qUpdate.setDouble(NETO_NO_GRAV_LOC, pers.getNetoNoGravadoMonLoc().doubleValue());
		else
			qUpdate.setNull(NETO_NO_GRAV_LOC, Types.DOUBLE);

		qUpdate.setBoolean(PEND_FACT, pers.isPendFact().booleanValue());

		if (pers.getContactoSujeto() != null)
			qUpdate.setDouble(OID_CONTACTO, pers.getContactoSujeto().getOID());
		else
			qUpdate.setNull(OID_CONTACTO, java.sql.Types.INTEGER);
		if (pers.getCotizMonFact() != null)
			qUpdate.setDouble(COTIZ_MON_FACT, pers.getCotizMonFact().doubleValue());
		else
			qUpdate.setNull(COTIZ_MON_FACT, java.sql.Types.DOUBLE);

		if (pers.getComporCotizFact() != null)
			qUpdate.setString(COMPOR_COTIZ_FACT, pers.getComporCotizFact());
		else
			qUpdate.setNull(COMPOR_COTIZ_FACT, java.sql.Types.VARCHAR);
		
		if (pers.getIva2() != null)
			qUpdate.setDouble(IVA_2, pers.getIva2().doubleValue());
		else
			qUpdate.setNull(IVA_2, java.sql.Types.DOUBLE);
		
		if (pers.getImpre_iva2() != null)
			qUpdate.setDouble(IMPRE_IVA_2, pers.getImpre_iva2().doubleValue());
		else
			qUpdate.setNull(IMPRE_IVA_2, java.sql.Types.DOUBLE);
		
		if (pers.getConcImpuIVA2() != null)
			qUpdate.setInt(OID_CONC_IVA_2, pers.getConcImpuIVA2().getOID());
		else
			qUpdate.setNull(OID_CONC_IVA_2, java.sql.Types.INTEGER);
		
		if (pers.getIVAMonLoc2() != null)
			qUpdate.setDouble(IVA_2_MON_LOC, pers.getIVAMonLoc2().doubleValue());
		else
			qUpdate.setNull(IVA_2_MON_LOC, java.sql.Types.DOUBLE);
		
		if (pers.getProyecto() != null)
			qUpdate.setDouble(OID_PROYECTO, pers.getProyecto().getOID());
		else
			qUpdate.setNull(OID_PROYECTO, java.sql.Types.INTEGER);
		if (pers.isPuedeAnularSinControl() != null)
			qUpdate.setBoolean(PUEDE_ANULAR_SC, pers.isPuedeAnularSinControl().booleanValue());
		else
			qUpdate.setNull(PUEDE_ANULAR_SC, java.sql.Types.BOOLEAN);
		
		
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void marcarPedidosComoNoPendDesp(Object aCondiciones) throws BaseException, SQLException {
		final int OID_CCO_PED = 1;
		PedidoCab pers = (PedidoCab) aCondiciones;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update vePedidosCab " + " set PEND_DESP=0 " + " where " + " oid_cco_ped=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_CCO_PED, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}
	
	protected void marcarPedidosComoNoPendFact(Object aCondiciones) throws BaseException, SQLException {
		final int OID_CCO_PED = 1;
		PedidoCab pers = (PedidoCab) aCondiciones;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update vePedidosCab " + " set PEND_FACT=0 " + " where " + " oid_cco_ped=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_CCO_PED, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}
	

	protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_CCO_PED = 1;
		PedidoCab pers = (PedidoCab) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update geComproCab " + " set activo=0 " + " where " + " oid_cco=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_CCO_PED, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_CCO_PED = 1;
		PedidoCab pers = (PedidoCab) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update geComproCab " + " set activo=1 " + " where " + " oid_cco=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_CCO_PED, pers.getOID());
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
			ps = this.selectByClieFecNro(aCondiciones);
			break;
		}
		case SELECT_BY_PED_PEND_ENT: {
			ps = this.selectByPedPendEnt(aCondiciones);
			break;
		}
		case SELECT_BY_TC_LETRA_LE_NROEXT: {
			ps = this.selectByTC_Letra_LE_NroExt(aCondiciones);
			break;
		}
		case SELECT_BY_CONDICIONES: {
			ps = this.selectByCondiciones(aCondiciones);
			break;
		}
		case SELECT_BY_PED: {
			ps = this.selectByPed(aCondiciones);
			break;
		}
		case SELECT_BY_MARCAR_PED_COMO_NO_PEND_DESP: {
			this.marcarPedidosComoNoPendDesp(aCondiciones);
			ps = null;
			break;
		}
		case SELECT_BY_MARCAR_PED_COMO_NO_PEND_FACT: {
			this.marcarPedidosComoNoPendFact(aCondiciones);
			ps = null;
			break;
		}
		case SELECT_BY_TC_LETRA_LE_NRO: {
			ps = this.selectByTCLetraLENro(aCondiciones);
			break;
		}
		case UPDATE_MARCAR_PUEDE_ANULAR_SC: {
			ps = this.selectByMarcarPuedeAnularSC(aCondiciones);
			break;
		}
		
		
		}
		return ps;
	}

	private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

		final int OID_CCO_PED = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT a.* , b.* FROM  vePedidosCab a  , geComproCab b ");
		textSQL.append(" WHERE a.oid_cco_ped = b.oid_cco and a.oid_cco_ped = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		int oid = ((Integer) aCondiciones).intValue();
		querySelect.setInt(OID_CCO_PED, oid);
		return querySelect;
	}

	private PreparedStatement selectByPedPendEnt(Object aCondiciones) throws BaseException, SQLException {

		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		Sujeto sujeto = (Sujeto) condiciones.get(Sujeto.NICKNAME);
		Vendedor vendedor = (Vendedor) condiciones.get(Vendedor.NICKNAME);
		java.util.Date fecEntHasta = (java.util.Date) condiciones.get("fec_ent_hasta");
		Integer nroDesde = (Integer) condiciones.get("nro_desde");
		Integer nroHasta = (Integer) condiciones.get("nro_hasta");

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT a.* , b.* FROM  vePedidosCab a  , geComproCab b ");
		textSQL.append(" WHERE a.oid_cco_ped = b.oid_cco and b.activo = 1 and a.pend_ent = 1 and a.observado = 0 ");

		if ((nroDesde != null) && (nroHasta == null))
			textSQL.append(" and b.nro_ext = " + nroDesde.toString() + " ");
		else if ((nroDesde != null) && (nroHasta != null))
			textSQL.append(" and b.nro_ext >= " + nroDesde.toString() + " and b.nro_ext <= " + nroHasta.toString());

		if (sujeto != null)
			textSQL.append(" and a.oid_sujeto =" + sujeto.getOIDInteger().toString());
		if (vendedor != null)
			textSQL.append(" and a.oid_vendedor =" + vendedor.getOIDInteger().toString());
		if (fecEntHasta != null)
			textSQL
					.append(" and a.oid_cco_ped in (select oid_cco_ped from vePedidosDet where pend_ent = 1 and anulado=0 and fec_entrega<=? ) ");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		if (fecEntHasta != null)
			querySelect.setDate(1, new java.sql.Date(fecEntHasta.getTime()));
		return querySelect;
	}

	private PreparedStatement selectByCondiciones(Object aCondiciones) throws BaseException, SQLException {

		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		Sujeto sujeto = (Sujeto) condiciones.get(Sujeto.NICKNAME);
		Vendedor vendedor = (Vendedor) condiciones.get(Vendedor.NICKNAME);
		java.util.Date fecEntHasta = (java.util.Date) condiciones.get("fec_ent_hasta");
		Integer nroDesde = (Integer) condiciones.get("nro_desde");
		Integer nroHasta = (Integer) condiciones.get("nro_hasta");
		Producto producto = (Producto) condiciones.get(Producto.NICKNAME);
		String tipo = (String) condiciones.get("TIPO");

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT a.* , b.* FROM  vePedidosCab a  , geComproCab b ");
		textSQL.append(" WHERE a.oid_cco_ped = b.oid_cco and b.activo = 1 ");
		
		
		if (tipo!=null) {
			if (tipo.equals("PEND_DESP"))
				textSQL.append(" and a.observado = 0 and a.oid_cco_ped in (");
				textSQL.append(" select ");
				textSQL.append("  a1.oid_cco_ped  ");
				textSQL.append(" from ");
				textSQL.append("  vePedidosDet a1, ");
				textSQL.append("  vePedidosCab b1, ");
				textSQL.append("  geComproCab c1 ");
				textSQL.append(" where ");
				textSQL.append("  a1.oid_cco_ped = b1.oid_cco_ped and b1.oid_cco_ped = c1.oid_cco ");
				textSQL.append("  and a1.anulado = 0 and a1.pend_desp=1 and c1.activo=1) ");			
		}

		if ((nroDesde != null) && (nroHasta == null))
			textSQL.append(" and b.nro_ext = " + nroDesde.toString() + " ");
		else if ((nroDesde != null) && (nroHasta != null))
			textSQL.append(" and b.nro_ext >= " + nroDesde.toString() + " and b.nro_ext <= " + nroHasta.toString());

		if (sujeto != null)
			textSQL.append(" and a.oid_sujeto =" + sujeto.getOIDInteger().toString());
		if (vendedor != null)
			textSQL.append(" and a.oid_vendedor =" + vendedor.getOIDInteger().toString());
		if (fecEntHasta != null)
			textSQL.append(" and a.oid_cco_ped in (select oid_cco_ped from vePedidosDet where pend_desp = 1 and anulado=0 and fec_entrega<=? ) ");
		
		if (producto != null)
			textSQL.append(" and a.oid_cco_ped in (select oid_cco_ped from vePedidosDet where pend_desp = 1 and anulado=0 and oid_producto="+producto.getOIDInteger()+" ) ");
		

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		if (fecEntHasta != null)
			querySelect.setDate(1, new java.sql.Date(fecEntHasta.getTime()));
		return querySelect;
	}
	
	private PreparedStatement selectByPed(Object aCondiciones) throws BaseException, SQLException {

		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		Sujeto sujeto = (Sujeto) condiciones.get(Sujeto.NICKNAME);
		Vendedor vendedor = (Vendedor) condiciones.get(Vendedor.NICKNAME);
		java.util.Date fecEntHasta = (java.util.Date) condiciones.get("fec_ent_hasta");
		Integer nroDesde = (Integer) condiciones.get("nro_desde");
		Integer nroHasta = (Integer) condiciones.get("nro_hasta");
		Producto producto = (Producto) condiciones.get(Producto.NICKNAME);

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT a.* , b.* FROM  vePedidosCab a  , geComproCab b ");
		textSQL.append(" WHERE a.oid_cco_ped = b.oid_cco and b.activo = 1 ");

		if ((nroDesde != null) && (nroHasta == null))
			textSQL.append(" and b.nro_ext = " + nroDesde.toString() + " ");
		else if ((nroDesde != null) && (nroHasta != null))
			textSQL.append(" and b.nro_ext >= " + nroDesde.toString() + " and b.nro_ext <= " + nroHasta.toString());

		if (sujeto != null)
			textSQL.append(" and a.oid_sujeto =" + sujeto.getOIDInteger().toString());
		if (vendedor != null)
			textSQL.append(" and a.oid_vendedor =" + vendedor.getOIDInteger().toString());
		if (fecEntHasta != null)
			textSQL.append(" and a.oid_cco_ped in (select oid_cco_ped from vePedidosDet where pend_desp = 1 and anulado=0 and fec_entrega<=? ) ");
		
		if (producto != null)
			textSQL.append(" and a.oid_cco_ped in (select oid_cco_ped from vePedidosDet where pend_desp = 1 and anulado=0 and oid_producto="+producto.getOIDInteger()+" ) ");
		

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		if (fecEntHasta != null)
			querySelect.setDate(1, new java.sql.Date(fecEntHasta.getTime()));
		return querySelect;
	}
	

	private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT a.*,b.* FROM  vePedidosCab a , geComproCab b ");
		textSQL.append(" WHERE a.oid_cco_ped = b.oid_cco and b.nro_ext = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		String nroExt = (String) aCondiciones;
		querySelect.setInt(1, (new Integer(nroExt)).intValue());
		return querySelect;
	}

	private PreparedStatement selectByTC_Letra_LE_NroExt(Object aCondiciones) throws BaseException, SQLException {

		final int OID_TC = 1;
		final int LETRA = 2;
		final int LUG_EMI = 3;
		final int NRO_EXT = 4;

		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		TipoComprobante tipoComprobante = (TipoComprobante) condiciones.get(TipoComprobante.NICKNAME);
		String letra = (String) condiciones.get("letra");
		Integer lugEmi = (Integer) condiciones.get("lug_emi");
		Integer nroExt = (Integer) condiciones.get("nro_ext");

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT a.*,b.* FROM  vePedidosCab a , geComproCab b ");
		textSQL.append(" WHERE a.oid_cco_ped = b.oid_cco and b.oid_tc=? and b.letra=? and b.lug_emi=? and b.nro_ext=? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		querySelect.setInt(OID_TC, tipoComprobante.getOID());
		querySelect.setString(LETRA, letra);
		querySelect.setInt(LUG_EMI, lugEmi.intValue());
		querySelect.setInt(NRO_EXT, nroExt.intValue());
		return querySelect;
	}

	private PreparedStatement selectByClieFecNro(Object aCondiciones) throws BaseException, SQLException {

		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		int nroParam = 0;

		Producto producto = null;
		if (condiciones.containsKey(Producto.NICKNAME)) 
			producto = (Producto) condiciones.get(Producto.NICKNAME);
		
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT a.*,b.* FROM  vePedidosCab a, geComproCab b ");
		
		if (producto!=null)
			textSQL.append(" , vePedidosDet c ");
			
		
		textSQL.append(" WHERE  a.oid_cco_ped = b.oid_cco ");
		
		if (producto!=null)
			textSQL.append(" and a.oid_cco_ped = c.oid_cco_ped and c.oid_producto = "+producto.getOIDInteger()+" ");

		if (condiciones.containsKey(Sujeto.NICKNAME)) {
			Sujeto sujeto = (Sujeto) condiciones.get(Sujeto.NICKNAME);
			textSQL.append(" and a.oid_sujeto = " + sujeto.getOIDInteger().toString());
		}
		
		if (condiciones.containsKey(Vendedor.NICKNAME)) {
			Vendedor vendedor = (Vendedor) condiciones.get(Vendedor.NICKNAME);
			textSQL.append(" and a.oid_vendedor = " + vendedor.getOIDInteger().toString());
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

	private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();

		textSQL.append("SELECT oid_cco_ped oid, codigo,  descripcion ,activo ");
		textSQL.append(" from vePedidosCab");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}

	public static List getPedidos(Integer nroExtDesde, Integer nroExtHasta, java.util.Date fecDesde,
			java.util.Date fecHasta, Sujeto sujeto, Producto producto, Vendedor vendedor, ISesion aSesion) throws BaseException {
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
		if (vendedor != null)
			condiciones.put(Vendedor.NICKNAME, vendedor);
		
		
		return (List) ObjetoLogico.getObjects(PedidoCab.NICKNAME, DBPedidoCab.SELECT_BY_CLIE_FEC_NRO, condiciones,
				new ListObserver(), aSesion);
	}

	public static List getPedidosPendEnt(Integer nroDesde, Integer nroHasta, Sujeto sujeto, Vendedor vendedor,
			java.util.Date fecEntHasta, ISesion aSesion) throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		if (sujeto != null)
			condiciones.put(Sujeto.NICKNAME, sujeto);
		if (vendedor != null)
			condiciones.put(Vendedor.NICKNAME, vendedor);
		if (fecEntHasta != null)
			condiciones.put("fec_ent_hasta", fecEntHasta);
		if (nroDesde != null)
			condiciones.put("nro_desde", nroDesde);
		if (nroHasta != null)
			condiciones.put("nro_hasta", nroHasta);
		return (List) ObjetoLogico.getObjects(PedidoCab.NICKNAME, DBPedidoCab.SELECT_BY_PED_PEND_ENT, condiciones,
				new ListObserver(), aSesion);
	}

	public static List getPedidosByCondiciones(Integer nroDesde, Integer nroHasta, Sujeto sujeto, Vendedor vendedor,
			java.util.Date fecEntHasta, Producto producto, String tipo,ISesion aSesion) throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		if (sujeto != null)
			condiciones.put(Sujeto.NICKNAME, sujeto);
		if (vendedor != null)
			condiciones.put(Vendedor.NICKNAME, vendedor);
		if (fecEntHasta != null)
			condiciones.put("fec_ent_hasta", fecEntHasta);
		if (nroDesde != null)
			condiciones.put("nro_desde", nroDesde);
		if (nroHasta != null)
			condiciones.put("nro_hasta", nroHasta);
		if (producto != null)
			condiciones.put(Producto.NICKNAME, producto);
		if (tipo!=null)
			condiciones.put("TIPO", tipo);
		
		return (List) ObjetoLogico.getObjects(PedidoCab.NICKNAME, DBPedidoCab.SELECT_BY_CONDICIONES, condiciones,
				new ListObserver(), aSesion);
	}
	
	public static List getPedidos(Integer nroDesde, Integer nroHasta, Sujeto sujeto, Vendedor vendedor,
			java.util.Date fecEntHasta, Producto producto, ISesion aSesion) throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		if (sujeto != null)
			condiciones.put(Sujeto.NICKNAME, sujeto);
		if (vendedor != null)
			condiciones.put(Vendedor.NICKNAME, vendedor);
		if (fecEntHasta != null)
			condiciones.put("fec_ent_hasta", fecEntHasta);
		if (nroDesde != null)
			condiciones.put("nro_desde", nroDesde);
		if (nroHasta != null)
			condiciones.put("nro_hasta", nroHasta);
		if (producto != null)
			condiciones.put(Producto.NICKNAME, producto);
		
		return (List) ObjetoLogico.getObjects(PedidoCab.NICKNAME, DBPedidoCab.SELECT_BY_PED, condiciones,
				new ListObserver(), aSesion);
	}
	

	public static PedidoCab getPedidoTC_Letra_LE_NroExt(TipoComprobante tipoComprobante, String letra, Integer nroLugEmi,
			Integer nroExt, ISesion aSesion) throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put(TipoComprobante.NICKNAME, tipoComprobante);
		condiciones.put("letra", letra);
		condiciones.put("lug_emi", nroLugEmi);
		condiciones.put("nro_ext", nroExt);
		return (PedidoCab) ObjetoLogico.getObjects(PedidoCab.NICKNAME, DBPedidoCab.SELECT_BY_TC_LETRA_LE_NROEXT,
				condiciones, new ObjetoObservado(), aSesion);
	}

	public int getCantItemsPendDesp(PedidoCab pedidoCab, ISesion aSesion) throws BaseException {
		try {
			return DBPedidoCab.getQueryCantItemsPendDesp(pedidoCab, aSesion);
		}
		catch (Exception e) {
			throw new BaseException(null, e.getMessage());
		}
	}

	public static int getQueryCantItemsPendDesp(Object aCondiciones, ISesion aSesion) throws BaseException {

		try {
			PedidoCab pedidoCab = (PedidoCab) aCondiciones;
			StringBuffer textSQL = new StringBuffer();

			textSQL.append("SELECT count(*) ");
			textSQL.append(" from VEPEDIDOSDET where  anulado = 0 and pend_desp = 1 and oid_cco_ped = ? ");

			PreparedStatement querySelect = aSesion.getConexionBD().prepareStatement(textSQL.toString());

			querySelect.setInt(1, pedidoCab.getOID());
			ResultSet rs = querySelect.executeQuery();
			int cantItemsPendDesp = 0;
			if (rs.next())
				cantItemsPendDesp = rs.getInt(1);
			rs.close();
			querySelect.close();

			return cantItemsPendDesp;
		}
		catch (Exception e) {
			throw new BaseException(null, e.getMessage());
		}
	}

	public static int getQueryCantItemsPendFact(Object aCondiciones, ISesion aSesion) throws BaseException {

		try {
			PedidoCab pedidoCab = (PedidoCab) aCondiciones;
			StringBuffer textSQL = new StringBuffer();

			textSQL.append("SELECT count(*) ");
			textSQL.append(" from VEPEDIDOSDET where  anulado = 0 and pend_fact = 1 and oid_cco_ped = ? ");

			PreparedStatement querySelect = aSesion.getConexionBD().prepareStatement(textSQL.toString());

			querySelect.setInt(1, pedidoCab.getOID());
			ResultSet rs = querySelect.executeQuery();
			int cantItemsPendFact = 0;
			if (rs.next())
				cantItemsPendFact = rs.getInt(1);
			rs.close();
			querySelect.close();

			return cantItemsPendFact;
		}
		catch (Exception e) {
			throw new BaseException(null, e.getMessage());
		}
	}
	
  public static void marcarPedidoComoNoPendDesp(PedidoCab pedidoCab,
      ISesion aSesion)
  throws BaseException {
  	ObjetoLogico.getObjects(PedidoCab.NICKNAME,
	  				DBPedidoCab.SELECT_BY_MARCAR_PED_COMO_NO_PEND_DESP,
	  				pedidoCab,
	  				null,
	  				aSesion);
  }
	
  public static void marcarPedidoComoNoPendFact(PedidoCab pedidoCab,
      ISesion aSesion)
  throws BaseException {
  	ObjetoLogico.getObjects(PedidoCab.NICKNAME,
	  				DBPedidoCab.SELECT_BY_MARCAR_PED_COMO_NO_PEND_FACT,
	  				pedidoCab,
	  				null,
	  				aSesion);
  }
  
  
	private PreparedStatement selectByMarcarPuedeAnularSC(Object aCondiciones) throws BaseException, SQLException {

		final int OID_CCO_PED = 1;
		PedidoCab pers = (PedidoCab) aCondiciones;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update vePedidosCab " + " set puede_anular_sc=1 " + " where " + " oid_cco_ped=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_CCO_PED, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
		return null;
		
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
		textSQL.append("SELECT a.* , b.* FROM  vePedidosCab a  , geComproCab b ");
		textSQL.append(" WHERE a.oid_cco_ped = b.oid_cco ");
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
	
	public static PedidoCab getPedidoCab(
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
		  return (PedidoCab) ObjetoLogico.getObjects(PedidoCab.NICKNAME,
				  				DBPedidoCab.SELECT_BY_TC_LETRA_LE_NRO,
				  				condiciones,
				  				new ObjetoObservado(),
				  				aSesion);
	  }
	
	  public static void marcarPedidoPuedeAnularSinControl(PedidoCab pedidoCab,
		      ISesion aSesion)
		  throws BaseException {
		  	ObjetoLogico.getObjects(PedidoCab.NICKNAME,
			  				DBPedidoCab.UPDATE_MARCAR_PUEDE_ANULAR_SC,
			  				pedidoCab,
			  				null,
			  				aSesion);
	  }
  

}
