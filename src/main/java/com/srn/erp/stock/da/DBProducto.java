package com.srn.erp.stock.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

import com.srn.erp.general.bm.ClasificadorEntidad;
import com.srn.erp.general.bm.IValorClasificadorEntidad;
import com.srn.erp.general.bm.ValorClasificadorEntidad;
import com.srn.erp.stock.bm.Producto;
import com.srn.erp.stock.bm.TipoProducto;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.ObjetoObservado;

public class DBProducto extends DBObjetoPersistente {

	public static final String	OID_PRODUCTO							= "oid_producto";

	public static final String	CODIGO										= "codigo";

	public static final String	DESCRIPCION								= "descripcion";

	public static final String	DESC_ABREV								= "desc_abrev";

	public static final String	COMPRABLE									= "comprable";

	public static final String	VENDIBLE									= "vendible";

	public static final String	STOCKEABLE								= "stockeable";

	public static final String	PROD_PROPIA								= "prod_propia";

	public static final String	IMPORTADO									= "importado";

	public static final String	SINONIMO									= "sinonimo";

	public static final String	CODIGO_BARRA							= "codigo_barra";

	public static final String	OID_UM_VTA								= "oid_um_vta";

	public static final String	OID_UM_STK								= "oid_um_stk";

	public static final String	OID_UM_STK_ALT						= "oid_um_stk_alt";

	public static final String	OID_UM_CPRA								= "oid_um_cpra";

	public static final String	OID_UM_PROD								= "oid_um_prod";

	public static final String	TOLERANCIA_RECEP					= "tolerancia_recep";

	public static final String	PORC_CUMP_OC							= "porc_cump_oc";

	public static final String	SISTEMA_CALIDAD						= "sistema_calidad";

	public static final String	OID_ANA_CON_CPRA					= "oid_ana_con_cpra";

	public static final String	MODIF_AI_CPRA							= "modif_ai_cpra";

	public static final String	ACTIVO										= "activo";

	public static final String	OID_TIPO_PROD							= "oid_tipo_prod";

	public static final String	LT_ENTREGA								= "lt_entrega";

	public static final String	OID_CONC_FACT_PROV				= "oid_conc_fact_prov";

	public static final String	LLEVA_PARTIDA							= "lleva_partida";

	public static final String	LLEVA_SERIE								= "lleva_serie";

	public static final String	OID_CLASIF_01							= "oid_clasif_01";

	public static final String	OID_CLASIF_02							= "oid_clasif_02";

	public static final String	OID_CLASIF_03							= "oid_clasif_03";

	public static final String	OID_CLASIF_04							= "oid_clasif_04";

	public static final String	OID_CLASIF_05							= "oid_clasif_05";

	public static final String	OID_CLASIF_06							= "oid_clasif_06";

	public static final String	OID_CLASIF_07							= "oid_clasif_07";

	public static final String	OID_CLASIF_08							= "oid_clasif_08";

	public static final String	OID_CLASIF_09							= "oid_clasif_09";

	public static final String	OID_CLASIF_10							= "oid_clasif_10";

	public static final String	OID_CLASIF_11							= "oid_clasif_11";

	public static final String	OID_CLASIF_12							= "oid_clasif_12";

	public static final String	OID_CLASIF_13							= "oid_clasif_13";

	public static final String	OID_CLASIF_14							= "oid_clasif_14";

	public static final String	OID_CLASIF_15							= "oid_clasif_15";

	public static final String	OID_CLASIF_16							= "oid_clasif_16";

	public static final String	OID_CLASIF_17							= "oid_clasif_17";

	public static final String	OID_CLASIF_18							= "oid_clasif_18";

	public static final String	OID_CLASIF_19							= "oid_clasif_19";

	public static final String	OID_CLASIF_20							= "oid_clasif_20";

	public static final String	NRO												= "nro";

	public static final String	OID_ANA_CON_VTA						= "oid_ana_imp_vta";

	public static final String	CANT_DEC_PV								= "cant_dec_pv";

	public static final String	LEAD_TIME_VTA							= "lead_time_vta";

	public static final String	DESC_SEARH								= "desc_search";
	
	public static final String  PRECIO_NO_DEF_LP          = "precio_no_def_lp";
	
	public static final String  HAB_ND_INT								= "hab_nd_int";
	
	public static final String  HAB_NC_INT								= "hab_nc_int";
	
	public static final String  CALC_PERC_IB_BA						= "calc_perc_ib_ba";
	
	public static final String  CALC_PERC_IB_CF						= "calc_perc_ib_cf";
	
	public static final String  CALC_PERC_IVA		  				= "calc_perc_iva";
	
	public static final String  MODIF_PRECIO_FACT					= "modif_precio_fact";
	
	public static final String  SEGUI_STOCK					= "segui_stock";
	
	public static final String ES_SALDO_PEND_SENIA = "es_saldo_pend_senia";
	
	public static final String ES_SENIA_FACTURA = "es_senia_fact";
	
	public static final String TOMAR_PRECIO_OC_1 = "tomar_precio_oc_1";
	
	public static final String TOMAR_PRECIO_OC_2 = "tomar_precio_oc_2";
	
	public static final String TOMAR_PRECIO_OC_3 = "tomar_precio_oc_3";
	
	public static final String TOMAR_PRECIO_OC_4 = "tomar_precio_oc_4";
	
	public static final String FORMA_CALC_COSTO = "forma_calc_costo";
	
	public static final String OID_PROV_COSTO = "oid_prov_costo";
	
	public static final int			SELECT_BY_HELP_PRODUCTO		= 100;

	public static final int			SELECT_VALIDAR_VENDIBLE		= 101;

	public static final int			SELECT_VALIDAR_STOCKEABLE	= 102;

	public static final int			SELECT_BY_SINONIMO				= 103;

	public static final int			SELECT_BY_CODIGO_BARRA		= 104;

	public static final int			SELECT_BY_CONSULTA_MASIVA	= 105;
	
	public static final int     SELECT_BY_CODIGO_Y_DIS_OID = 106;
	
	public static final int 	SELECT_BY_VALOR_CLASIF = 107;
	
	public static final int			SELECT_BY_HELP_PRODUCTO_ALL		= 108;

	public DBProducto() {
	}

	protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_PRODUCTO = 1;
		final int CODIGO = 2;
		final int DESCRIPCION = 3;
		final int DESC_ABREV = 4;
		final int COMPRABLE = 5;
		final int VENDIBLE = 6;
		final int STOCKEABLE = 7;
		final int PROD_PROPIA = 8;
		final int IMPORTADO = 9;
		final int SINONIMO = 10;
		final int CODIGO_BARRA = 11;
		final int OID_UM_VTA = 12;
		final int OID_UM_STK = 13;
		final int OID_UM_STK_ALT = 14;
		final int OID_UM_CPRA = 15;
		final int OID_UM_PROD = 16;
		final int TOLERANCIA_RECEP = 17;
		final int PORC_CUMP_OC = 18;
		final int SISTEMA_CALIDAD = 19;
		final int OID_ANA_CON_CPRA = 20;
		final int MODIF_AI_CPRA = 21;
		final int ACTIVO = 22;
		final int OID_TIPO_PROD = 23;
		final int LT_ENTREGA = 24;
		final int OID_CONC_FACT_PROV = 25;
		final int LLEVA_PARTIDA = 26;
		final int LLEVA_SERIE = 27;
		final int OID_CLASIF_01 = 28;
		final int OID_CLASIF_02 = 29;
		final int OID_CLASIF_03 = 30;
		final int OID_CLASIF_04 = 31;
		final int OID_CLASIF_05 = 32;
		final int OID_CLASIF_06 = 33;
		final int OID_CLASIF_07 = 34;
		final int OID_CLASIF_08 = 35;
		final int OID_CLASIF_09 = 36;
		final int OID_CLASIF_10 = 37;
		final int OID_CLASIF_11 = 38;
		final int OID_CLASIF_12 = 39;
		final int OID_CLASIF_13 = 40;
		final int OID_CLASIF_14 = 41;
		final int OID_CLASIF_15 = 42;
		final int OID_CLASIF_16 = 43;
		final int OID_CLASIF_17 = 44;
		final int OID_CLASIF_18 = 45;
		final int OID_CLASIF_19 = 46;
		final int OID_CLASIF_20 = 47;
		final int NRO = 48;
		final int OID_ANA_CON_VTA = 49;
		final int CANT_DEC_PV = 50;
		final int LEAD_TIME_VTA = 51;
		final int DESC_SEARCH = 52;
		final int PRECIO_NO_DEF_LP = 53;
		final int HAB_ND_INT = 54;
		final int HAB_NC_INT = 55;
		final int CALC_PERC_IB_BA = 56;
		final int CALC_PERC_IB_CF = 57;
		final int CALC_PERC_IVA = 58;
		final int MODIF_PRECIO_FACT = 59;
		final int SEGUI_STOCK = 60;
		final int ES_SALDO_PEND_SENIA = 61;
		final int ES_SENIA_FACT = 62;
		final int TOMAR_PRECIO_OC_1 = 63;
		final int TOMAR_PRECIO_OC_2 = 64;
		final int TOMAR_PRECIO_OC_3 = 65;
		final int TOMAR_PRECIO_OC_4 = 66;
		final int FORMA_CALC_COSTO = 67;
		final int OID_PROV_COSTO = 68;

		Producto pers = (Producto) objetoPersistente;

		StringBuffer sqlInsert = new StringBuffer();
		sqlInsert.append(" insert into stProducto " + " ( " + "OID_PRODUCTO," + "CODIGO," + "DESCRIPCION," + "DESC_ABREV,"
				+ "COMPRABLE," + "VENDIBLE," + "STOCKEABLE," + "PROD_PROPIA," + "IMPORTADO," + "SINONIMO," + "CODIGO_BARRA,"
				+ "OID_UM_VTA," + "OID_UM_STK," + "OID_UM_STK_ALT," + "OID_UM_CPRA," + "OID_UM_PROD," + "TOLERANCIA_RECEP,"
				+ "PORC_CUMP_OC," + "SISTEMA_CALIDAD," + "OID_ANA_CON_CPRA," + "MODIF_AI_CPRA," + "ACTIVO," + "OID_TIPO_PROD,"
				+ "LT_ENTREGA," + "OID_CONC_FACT_PROV," + "LLEVA_PARTIDA," + "LLEVA_SERIE," + "OID_CLASIF_01,"
				+ "OID_CLASIF_02," + "OID_CLASIF_03," + "OID_CLASIF_04," + "OID_CLASIF_05," + "OID_CLASIF_06,"
				+ "OID_CLASIF_07," + "OID_CLASIF_08," + "OID_CLASIF_09," + "OID_CLASIF_10," + "OID_CLASIF_11,"
				+ "OID_CLASIF_12," + "OID_CLASIF_13," + "OID_CLASIF_14," + "OID_CLASIF_15," + "OID_CLASIF_16,"
				+ "OID_CLASIF_17," + "OID_CLASIF_18," + "OID_CLASIF_19," + "OID_CLASIF_20," + "NRO," + "OID_ANA_IMP_VTA,"
				+ "CANT_DEC_PV," + "LEAD_TIME_VTA," + "DESC_SEARCH , PRECIO_NO_DEF_LP , HAB_ND_INT , HAB_NC_INT , CALC_PERC_IB_BA , CALC_PERC_IB_CF , CALC_PERC_IVA , MODIF_PRECIO_FACT , SEGUI_STOCK , ES_SALDO_PEND_SENIA , ES_SENIA_FACT" +
				",TOMAR_PRECIO_OC_1,TOMAR_PRECIO_OC_2,TOMAR_PRECIO_OC_3,TOMAR_PRECIO_OC_4,FORMA_CALC_COSTO,OID_PROV_COSTO"+
				")" + " values " + "(" + "?," + "?," +"?," + "?," + "?," + "?,"+ "?,"+ "?,"+ "?,"+ "?,"+ "?,"
				+ "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?,"
				+ "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?,"+ "?,"+ "?,"
				+ "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?,"+ "?,"+ "?,"+"?,"+"?,"+"?,"+ "?,"+ "?," + "?) ");

		PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
		qInsert.setInt(OID_PRODUCTO, pers.getOID());
		qInsert.setString(CODIGO, pers.getCodigo());
		qInsert.setString(DESCRIPCION, pers.getDescripcion());
		qInsert.setString(DESC_ABREV, pers.getDesc_abrev());
		qInsert.setBoolean(COMPRABLE, pers.isComprable().booleanValue());
		qInsert.setBoolean(VENDIBLE, pers.isVendible().booleanValue());
		qInsert.setBoolean(STOCKEABLE, pers.isStockeable().booleanValue());
		qInsert.setBoolean(PROD_PROPIA, pers.isProd_propia().booleanValue());
		qInsert.setBoolean(IMPORTADO, pers.isImportado().booleanValue());

		if (pers.getSinonimo() != null)
			qInsert.setString(SINONIMO, pers.getSinonimo());
		else
			qInsert.setNull(SINONIMO, java.sql.Types.VARCHAR);

		if (pers.getCodigo_barra() != null)
			qInsert.setString(CODIGO_BARRA, pers.getCodigo_barra());
		else
			qInsert.setNull(CODIGO_BARRA, java.sql.Types.VARCHAR);

		if (pers.getUm_vta() != null)
			qInsert.setInt(OID_UM_VTA, pers.getUm_vta().getOID());
		else
			qInsert.setNull(OID_UM_VTA, java.sql.Types.INTEGER);

		if (pers.getUm_stk() != null)
			qInsert.setInt(OID_UM_STK, pers.getUm_stk().getOID());
		else
			qInsert.setNull(OID_UM_STK, java.sql.Types.INTEGER);

		if (pers.getUm_stk_alt() != null)
			qInsert.setInt(OID_UM_STK_ALT, pers.getUm_stk().getOID());
		else
			qInsert.setNull(OID_UM_STK_ALT, java.sql.Types.INTEGER);

		if (pers.getUm_cpra() != null)
			qInsert.setInt(OID_UM_CPRA, pers.getUm_cpra().getOID());
		else
			qInsert.setNull(OID_UM_CPRA, java.sql.Types.INTEGER);

		if (pers.getUm_prod() != null)
			qInsert.setInt(OID_UM_PROD, pers.getUm_prod().getOID());
		else
			qInsert.setNull(OID_UM_PROD, java.sql.Types.INTEGER);

		if (pers.getTolerancia_recep() != null)
			qInsert.setDouble(TOLERANCIA_RECEP, pers.getTolerancia_recep().doubleValue());
		else
			qInsert.setNull(TOLERANCIA_RECEP, java.sql.Types.DOUBLE);

		if (pers.getPorc_cump_oc() != null)
			qInsert.setDouble(PORC_CUMP_OC, pers.getPorc_cump_oc().doubleValue());
		else
			qInsert.setNull(PORC_CUMP_OC, java.sql.Types.DOUBLE);

		if (pers.isSistema_calidad() != null)
			qInsert.setBoolean(SISTEMA_CALIDAD, pers.isSistema_calidad().booleanValue());
		else
			qInsert.setNull(SISTEMA_CALIDAD, java.sql.Types.INTEGER);

		if (pers.getCuenta_cpra() != null)
			qInsert.setInt(OID_ANA_CON_CPRA, pers.getCuenta_cpra().getOID());
		else
			qInsert.setNull(OID_ANA_CON_CPRA, java.sql.Types.INTEGER);

		if (pers.isModif_ai_cpra() != null)
			qInsert.setBoolean(MODIF_AI_CPRA, pers.isModif_ai_cpra().booleanValue());
		else
			qInsert.setNull(MODIF_AI_CPRA, java.sql.Types.INTEGER);

		qInsert.setBoolean(ACTIVO, pers.isActivo().booleanValue());

		qInsert.setInt(OID_TIPO_PROD, pers.getTipoproducto().getOID());

		if (pers.getLt_entrega() != null)
			qInsert.setInt(LT_ENTREGA, pers.getLt_entrega().intValue());
		else
			qInsert.setNull(LT_ENTREGA, java.sql.Types.INTEGER);

		if (pers.getConcFactProv() != null)
			qInsert.setInt(OID_CONC_FACT_PROV, pers.getConcFactProv().getOID());
		else
			qInsert.setNull(OID_CONC_FACT_PROV, java.sql.Types.INTEGER);

		if (pers.isLlevaPartida()!=null)
			qInsert.setBoolean(LLEVA_PARTIDA, pers.isLlevaPartida().booleanValue());
		else
			qInsert.setBoolean(LLEVA_PARTIDA, false);
		if (pers.isLlevaSerie()!=null)
			qInsert.setBoolean(LLEVA_SERIE, pers.isLlevaSerie().booleanValue());
		else
			qInsert.setBoolean(LLEVA_SERIE, false);
		
		qInsert.setInt(OID_CLASIF_01, pers.getOidValorClasif(new Integer(1)).intValue());
		qInsert.setInt(OID_CLASIF_02, pers.getOidValorClasif(new Integer(2)).intValue());
		qInsert.setInt(OID_CLASIF_03, pers.getOidValorClasif(new Integer(3)).intValue());
		qInsert.setInt(OID_CLASIF_04, pers.getOidValorClasif(new Integer(4)).intValue());
		qInsert.setInt(OID_CLASIF_05, pers.getOidValorClasif(new Integer(5)).intValue());
		qInsert.setInt(OID_CLASIF_06, pers.getOidValorClasif(new Integer(6)).intValue());
		qInsert.setInt(OID_CLASIF_07, pers.getOidValorClasif(new Integer(7)).intValue());
		qInsert.setInt(OID_CLASIF_08, pers.getOidValorClasif(new Integer(8)).intValue());
		qInsert.setInt(OID_CLASIF_09, pers.getOidValorClasif(new Integer(9)).intValue());
		qInsert.setInt(OID_CLASIF_10, pers.getOidValorClasif(new Integer(10)).intValue());
		qInsert.setInt(OID_CLASIF_11, pers.getOidValorClasif(new Integer(11)).intValue());
		qInsert.setInt(OID_CLASIF_12, pers.getOidValorClasif(new Integer(12)).intValue());
		qInsert.setInt(OID_CLASIF_13, pers.getOidValorClasif(new Integer(13)).intValue());
		qInsert.setInt(OID_CLASIF_14, pers.getOidValorClasif(new Integer(14)).intValue());
		qInsert.setInt(OID_CLASIF_15, pers.getOidValorClasif(new Integer(15)).intValue());
		qInsert.setInt(OID_CLASIF_16, pers.getOidValorClasif(new Integer(16)).intValue());
		qInsert.setInt(OID_CLASIF_17, pers.getOidValorClasif(new Integer(17)).intValue());
		qInsert.setInt(OID_CLASIF_18, pers.getOidValorClasif(new Integer(18)).intValue());
		qInsert.setInt(OID_CLASIF_19, pers.getOidValorClasif(new Integer(19)).intValue());
		qInsert.setInt(OID_CLASIF_20, pers.getOidValorClasif(new Integer(20)).intValue());
		if (pers.getNro() != null)
			qInsert.setInt(NRO, pers.getNro().intValue());
		else
			qInsert.setInt(NRO, 0);
		if (pers.getCuentaVenta() != null)
			qInsert.setInt(OID_ANA_CON_VTA, pers.getCuentaVenta().getOID());
		else
			qInsert.setNull(OID_ANA_CON_VTA, Types.INTEGER);
		if (pers.getCantDecPrecioVta() != null)
			qInsert.setInt(CANT_DEC_PV, pers.getCantDecPrecioVta().intValue());
		else
			qInsert.setNull(CANT_DEC_PV, java.sql.Types.INTEGER);

		if (pers.getLeadTimeVta() != null)
			qInsert.setInt(LEAD_TIME_VTA, pers.getLeadTimeVta().intValue());
		else
			qInsert.setNull(LEAD_TIME_VTA, java.sql.Types.INTEGER);

		if (pers.getDescSearch() != null)
			qInsert.setString(DESC_SEARCH, pers.getDescSearch());
		else
			qInsert.setNull(DESC_SEARCH, java.sql.Types.VARCHAR);
		
		qInsert.setBoolean(PRECIO_NO_DEF_LP,pers.isPrecioNoDefLP());
		
		qInsert.setBoolean(HAB_ND_INT,pers.isHabilitadaNotaDebitoInterna());

		qInsert.setBoolean(HAB_NC_INT,pers.isHabilitadaNotaCreditoInterna());
		qInsert.setBoolean(CALC_PERC_IB_BA, pers.isCalcPercIBBsAs());
		qInsert.setBoolean(CALC_PERC_IB_CF, pers.isCalcPercIBCapFed());
		qInsert.setBoolean(CALC_PERC_IVA, pers.isCalcPercIVA());
		
		if (pers.isModifPrecioFactura()!=null)
			qInsert.setBoolean(MODIF_PRECIO_FACT, pers.isModifPrecioFactura().booleanValue());
		else
			qInsert.setBoolean(MODIF_PRECIO_FACT, false);
		if (pers.isSeguimientoStock()!=null)
			qInsert.setBoolean(SEGUI_STOCK, pers.isSeguimientoStock().booleanValue());
		else
			qInsert.setBoolean(SEGUI_STOCK, false);
		if (pers.isSeUsaParaSaldoPendFactSenia()!=null)
			qInsert.setBoolean(ES_SALDO_PEND_SENIA, pers.isSeUsaParaSaldoPendFactSenia().booleanValue());
		else
			qInsert.setBoolean(ES_SALDO_PEND_SENIA, false);
		if (pers.isSeniaFactura()!=null)
			qInsert.setBoolean(ES_SENIA_FACT, pers.isSeniaFactura().booleanValue());
		else
			qInsert.setBoolean(ES_SENIA_FACT, false);
		
		if (pers.getTomarPrecioOC1()!=null)
			qInsert.setString(TOMAR_PRECIO_OC_1, pers.getTomarPrecioOC1());
		else
			qInsert.setNull(TOMAR_PRECIO_OC_1, java.sql.Types.VARCHAR);
		
		if (pers.getTomarPrecioOC2()!=null)
			qInsert.setString(TOMAR_PRECIO_OC_2, pers.getTomarPrecioOC2());
		else
			qInsert.setNull(TOMAR_PRECIO_OC_2, java.sql.Types.VARCHAR);
		
		if (pers.getTomarPrecioOC3()!=null)
			qInsert.setString(TOMAR_PRECIO_OC_3, pers.getTomarPrecioOC3());
		else
			qInsert.setNull(TOMAR_PRECIO_OC_3, java.sql.Types.VARCHAR);
		
		if (pers.getTomarPrecioOC4()!=null)
			qInsert.setString(TOMAR_PRECIO_OC_4, pers.getTomarPrecioOC4());
		else
			qInsert.setNull(TOMAR_PRECIO_OC_4, java.sql.Types.VARCHAR);
		
		if (pers.getFormaCalcCosto()!=null)
			qInsert.setString(FORMA_CALC_COSTO, pers.getFormaCalcCosto());
		else
			qInsert.setNull(FORMA_CALC_COSTO, java.sql.Types.VARCHAR);
		
		if (pers.getProveedorCosto()!=null)
			qInsert.setInt(OID_PROV_COSTO, pers.getProveedorCosto().getOID());
		else
			qInsert.setNull(OID_PROV_COSTO, java.sql.Types.INTEGER);
		
		
		qInsert.executeUpdate();
		qInsert.close();

		// grabarAtributosProducto(pers);

	}

	/*
	 * private void grabarAtributosProducto(Producto producto) throws BaseException { AtributosProducto atributosProducto =
	 * (AtributosProducto) AtributosProducto.getNew(AtributosProducto.NICKNAME,this.getSesion());
	 * atributosProducto.setProducto(producto); atributosProducto.save(); }
	 */

	protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int CODIGO = 1;
		final int DESCRIPCION = 2;
		final int DESC_ABREV = 3;
		final int COMPRABLE = 4;
		final int VENDIBLE = 5;
		final int STOCKEABLE = 6;
		final int PROD_PROPIA = 7;
		final int IMPORTADO = 8;
		final int SINONIMO = 9;
		final int CODIGO_BARRA = 10;
		final int OID_UM_VTA = 11;
		final int OID_UM_STK = 12;
		final int OID_UM_STK_ALT = 13;
		final int OID_UM_CPRA = 14;
		final int OID_UM_PROD = 15;
		final int TOLERANCIA_RECEP = 16;
		final int PORC_CUMP_OC = 17;
		final int SISTEMA_CALIDAD = 18;
		final int OID_ANA_CON_CPRA = 19;
		final int MODIF_AI_CPRA = 20;
		final int ACTIVO = 21;
		final int OID_TIPO_PROD = 22;
		final int LT_ENTREGA = 23;
		final int OID_CONC_FACT_PROV = 24;
		final int LLEVA_PARTIDA = 25;
		final int LLEVA_SERIE = 26;
		final int OID_CLASIF_01 = 27;
		final int OID_CLASIF_02 = 28;
		final int OID_CLASIF_03 = 29;
		final int OID_CLASIF_04 = 30;
		final int OID_CLASIF_05 = 31;
		final int OID_CLASIF_06 = 32;
		final int OID_CLASIF_07 = 33;
		final int OID_CLASIF_08 = 34;
		final int OID_CLASIF_09 = 35;
		final int OID_CLASIF_10 = 36;
		final int OID_CLASIF_11 = 37;
		final int OID_CLASIF_12 = 38;
		final int OID_CLASIF_13 = 39;
		final int OID_CLASIF_14 = 40;
		final int OID_CLASIF_15 = 41;
		final int OID_CLASIF_16 = 42;
		final int OID_CLASIF_17 = 43;
		final int OID_CLASIF_18 = 44;
		final int OID_CLASIF_19 = 45;
		final int OID_CLASIF_20 = 46;
		final int NRO = 47;
		final int OID_ANA_CON_VTA = 48;
		final int CANT_DEC_PV = 49;
		final int LEAD_TIME_VTA = 50;
		final int DESC_SEARCH = 51;
		final int PRECIO_NO_DEF_LP = 52;
		final int HAB_ND_INT = 53;
		final int HAB_NC_INT = 54;
		final int CALC_PERC_IB_BA = 55;
		final int CALC_PERC_IB_CF = 56;
		final int CALC_PERC_IVA = 57;
		final int MODIF_PRECIO_FACT = 58;
		final int SEGUI_STOCK = 59;
		final int ES_SALDO_PEND_SENIA = 60;
		final int ES_SENIA_FACTURA = 61;
		final int TOMAR_PRECIO_OC_1 = 62;
		final int TOMAR_PRECIO_OC_2 = 63;
		final int TOMAR_PRECIO_OC_3 = 64;
		final int TOMAR_PRECIO_OC_4 = 65;
		final int FORMA_CALC_COSTO = 66;
		final int OID_PROV_COSTO = 67;
		final int OID_PRODUCTO = 68;

		Producto pers = (Producto) objetoPersistente;

		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append(" update stProducto set " + "codigo=?" + ",descripcion=?" + ",desc_abrev=?" + ",comprable=?"
				+ ",vendible=?" + ",stockeable=?" + ",prod_propia=?" + ",importado=?" + ",sinonimo=?" + ",codigo_barra=?"
				+ ",oid_um_vta=?" + ",oid_um_stk=?" + ",oid_um_stk_alt=?" + ",oid_um_cpra=?" + ",oid_um_prod=?"
				+ ",tolerancia_recep=?" + ",porc_cump_oc=?" + ",sistema_calidad=?" + ",oid_ana_con_cpra=?" + ",modif_ai_cpra=?"
				+ ",activo=?" + ",oid_tipo_prod=?" + ",lt_entrega=?" + ",oid_conc_fact_prov=?" + ",lleva_partida=?"
				+ ",lleva_serie=?," + "oid_clasif_01 = ?," + "oid_clasif_02 = ?," + "oid_clasif_03 = ?," + "oid_clasif_04 = ?,"
				+ "oid_clasif_05 = ?," + "oid_clasif_06 = ?," + "oid_clasif_07 = ?," + "oid_clasif_08 = ?,"
				+ "oid_clasif_09 = ?," + "oid_clasif_10 = ?," + "oid_clasif_11 = ?," + "oid_clasif_12 = ?,"
				+ "oid_clasif_13 = ?," + "oid_clasif_14 = ?," + "oid_clasif_15 = ?," + "oid_clasif_16 = ?,"
				+ "oid_clasif_17 = ?," + "oid_clasif_18 = ?," + "oid_clasif_19 = ?," + "oid_clasif_20 = ?, " + "nro = ?, "
				+ "oid_ana_imp_vta = ?, " + "cant_dec_pv = ?, " + "lead_time_vta = ?, " + "desc_search = ? , precio_no_def_lp = ? , hab_nd_int = ? , hab_nc_int = ? "
				+ " , calc_perc_ib_ba=? , calc_perc_ib_cf=? ,  calc_perc_iva=? , modif_precio_fact = ? , segui_stock = ? , es_saldo_pend_senia = ? , es_senia_fact = ? ,"
				+ " tomar_precio_oc_1=? , tomar_precio_oc_2=? , tomar_precio_oc_3=? , tomar_precio_oc_4=? , forma_calc_costo = ? , oid_prov_costo = ? "
				+ " where "
				+ " oid_producto=? ");

		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_PRODUCTO, pers.getOID());
		qUpdate.setString(CODIGO, pers.getCodigo());
		qUpdate.setString(DESCRIPCION, pers.getDescripcion());
		qUpdate.setString(DESC_ABREV, pers.getDesc_abrev());
		qUpdate.setBoolean(COMPRABLE, pers.isComprable().booleanValue());
		qUpdate.setBoolean(VENDIBLE, pers.isVendible().booleanValue());
		qUpdate.setBoolean(STOCKEABLE, pers.isStockeable().booleanValue());
		qUpdate.setBoolean(PROD_PROPIA, pers.isProd_propia().booleanValue());
		qUpdate.setBoolean(IMPORTADO, pers.isImportado().booleanValue());

		if (pers.getSinonimo() != null)
			qUpdate.setString(SINONIMO, pers.getSinonimo());
		else
			qUpdate.setNull(SINONIMO, java.sql.Types.VARCHAR);

		if (pers.getCodigo_barra() != null)
			qUpdate.setString(CODIGO_BARRA, pers.getCodigo_barra());
		else
			qUpdate.setNull(CODIGO_BARRA, java.sql.Types.VARCHAR);

		if (pers.getUm_vta() != null)
			qUpdate.setInt(OID_UM_VTA, pers.getUm_vta().getOID());
		else
			qUpdate.setNull(OID_UM_VTA, java.sql.Types.INTEGER);

		if (pers.getUm_stk() != null)
			qUpdate.setInt(OID_UM_STK, pers.getUm_stk().getOID());
		else
			qUpdate.setNull(OID_UM_STK, java.sql.Types.INTEGER);

		if (pers.getUm_stk_alt() != null)
			qUpdate.setInt(OID_UM_STK_ALT, pers.getUm_stk_alt().getOID());
		else
			qUpdate.setNull(OID_UM_STK_ALT, java.sql.Types.INTEGER);

		if (pers.getUm_cpra() != null)
			qUpdate.setInt(OID_UM_CPRA, pers.getUm_cpra().getOID());
		else
			qUpdate.setNull(OID_UM_CPRA, java.sql.Types.INTEGER);

		if (pers.getUm_prod() != null)
			qUpdate.setInt(OID_UM_PROD, pers.getUm_prod().getOID());
		else
			qUpdate.setNull(OID_UM_PROD, java.sql.Types.INTEGER);

		if (pers.getTolerancia_recep() != null)
			qUpdate.setDouble(TOLERANCIA_RECEP, pers.getTolerancia_recep().doubleValue());
		else
			qUpdate.setNull(TOLERANCIA_RECEP, java.sql.Types.DOUBLE);

		if (pers.getPorc_cump_oc() != null)
			qUpdate.setDouble(PORC_CUMP_OC, pers.getPorc_cump_oc().doubleValue());
		else
			qUpdate.setNull(PORC_CUMP_OC, java.sql.Types.DOUBLE);

		if (pers.isSistema_calidad() != null)
			qUpdate.setBoolean(SISTEMA_CALIDAD, pers.isSistema_calidad().booleanValue());
		else
			qUpdate.setNull(SISTEMA_CALIDAD, java.sql.Types.INTEGER);

		if (pers.getCuenta_cpra() != null)
			qUpdate.setInt(OID_ANA_CON_CPRA, pers.getCuenta_cpra().getOID());
		else
			qUpdate.setNull(OID_ANA_CON_CPRA, java.sql.Types.INTEGER);

		if (pers.isModif_ai_cpra() != null)
			qUpdate.setBoolean(MODIF_AI_CPRA, pers.isModif_ai_cpra().booleanValue());
		else
			qUpdate.setNull(MODIF_AI_CPRA, java.sql.Types.INTEGER);

		qUpdate.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		qUpdate.setInt(OID_TIPO_PROD, pers.getTipoproducto().getOID());

		if (pers.getLt_entrega() != null)
			qUpdate.setInt(LT_ENTREGA, pers.getLt_entrega().intValue());
		else
			qUpdate.setNull(LT_ENTREGA, java.sql.Types.INTEGER);

		if (pers.getConcFactProv() != null)
			qUpdate.setInt(OID_CONC_FACT_PROV, pers.getConcFactProv().getOID());
		else
			qUpdate.setNull(OID_CONC_FACT_PROV, java.sql.Types.INTEGER);

		qUpdate.setBoolean(LLEVA_PARTIDA, pers.isLlevaPartida().booleanValue());
		qUpdate.setBoolean(LLEVA_SERIE, pers.isLlevaSerie().booleanValue());

		qUpdate.setInt(OID_CLASIF_01, pers.getOidValorClasif(new Integer(1)).intValue());
		qUpdate.setInt(OID_CLASIF_02, pers.getOidValorClasif(new Integer(2)).intValue());
		qUpdate.setInt(OID_CLASIF_03, pers.getOidValorClasif(new Integer(3)).intValue());
		qUpdate.setInt(OID_CLASIF_04, pers.getOidValorClasif(new Integer(4)).intValue());
		qUpdate.setInt(OID_CLASIF_05, pers.getOidValorClasif(new Integer(5)).intValue());
		qUpdate.setInt(OID_CLASIF_06, pers.getOidValorClasif(new Integer(6)).intValue());
		qUpdate.setInt(OID_CLASIF_07, pers.getOidValorClasif(new Integer(7)).intValue());
		qUpdate.setInt(OID_CLASIF_08, pers.getOidValorClasif(new Integer(8)).intValue());
		qUpdate.setInt(OID_CLASIF_09, pers.getOidValorClasif(new Integer(9)).intValue());
		qUpdate.setInt(OID_CLASIF_10, pers.getOidValorClasif(new Integer(10)).intValue());
		qUpdate.setInt(OID_CLASIF_11, pers.getOidValorClasif(new Integer(11)).intValue());
		qUpdate.setInt(OID_CLASIF_12, pers.getOidValorClasif(new Integer(12)).intValue());
		qUpdate.setInt(OID_CLASIF_13, pers.getOidValorClasif(new Integer(13)).intValue());
		qUpdate.setInt(OID_CLASIF_14, pers.getOidValorClasif(new Integer(14)).intValue());
		qUpdate.setInt(OID_CLASIF_15, pers.getOidValorClasif(new Integer(15)).intValue());
		qUpdate.setInt(OID_CLASIF_16, pers.getOidValorClasif(new Integer(16)).intValue());
		qUpdate.setInt(OID_CLASIF_17, pers.getOidValorClasif(new Integer(17)).intValue());
		qUpdate.setInt(OID_CLASIF_18, pers.getOidValorClasif(new Integer(18)).intValue());
		qUpdate.setInt(OID_CLASIF_19, pers.getOidValorClasif(new Integer(19)).intValue());
		qUpdate.setInt(OID_CLASIF_20, pers.getOidValorClasif(new Integer(20)).intValue());

		if (pers.getNro() != null)
			qUpdate.setInt(NRO, pers.getNro().intValue());
		else
			qUpdate.setInt(NRO, 0);
		if (pers.getCuentaVenta() != null)
			qUpdate.setInt(OID_ANA_CON_VTA, pers.getCuentaVenta().getOID());
		else
			qUpdate.setNull(OID_ANA_CON_VTA, Types.INTEGER);
		if (pers.getCantDecPrecioVta() != null)
			qUpdate.setInt(CANT_DEC_PV, pers.getCantDecPrecioVta().intValue());
		else
			qUpdate.setNull(CANT_DEC_PV, java.sql.Types.INTEGER);

		if (pers.getLeadTimeVta() != null)
			qUpdate.setInt(LEAD_TIME_VTA, pers.getLeadTimeVta().intValue());
		else
			qUpdate.setNull(LEAD_TIME_VTA, java.sql.Types.INTEGER);

		if (pers.getDescSearch() != null)
			qUpdate.setString(DESC_SEARCH, pers.getDescSearch());
		else
			qUpdate.setNull(DESC_SEARCH, java.sql.Types.VARCHAR);

		qUpdate.setBoolean(PRECIO_NO_DEF_LP,pers.isPrecioNoDefLP());

		qUpdate.setBoolean(HAB_ND_INT,pers.isHabilitadaNotaDebitoInterna());

		qUpdate.setBoolean(HAB_NC_INT,pers.isHabilitadaNotaCreditoInterna());
		
		qUpdate.setBoolean(CALC_PERC_IB_BA, pers.isCalcPercIBBsAs());
		qUpdate.setBoolean(CALC_PERC_IB_CF, pers.isCalcPercIBCapFed());
		qUpdate.setBoolean(CALC_PERC_IVA, pers.isCalcPercIVA());

		if (pers.isModifPrecioFactura()!=null)
			qUpdate.setBoolean(MODIF_PRECIO_FACT, pers.isModifPrecioFactura().booleanValue());
		else
			qUpdate.setBoolean(MODIF_PRECIO_FACT, false);
		
		
		if (pers.isSeguimientoStock()!=null)
			qUpdate.setBoolean(SEGUI_STOCK, pers.isSeguimientoStock().booleanValue());
		else
			qUpdate.setBoolean(SEGUI_STOCK, false);
		if (pers.isSeUsaParaSaldoPendFactSenia()!=null)
			qUpdate.setBoolean(ES_SALDO_PEND_SENIA, pers.isSeUsaParaSaldoPendFactSenia().booleanValue());
		else
			qUpdate.setBoolean(ES_SALDO_PEND_SENIA, false);
		if (pers.isSeniaFactura()!=null)
			qUpdate.setBoolean(ES_SENIA_FACTURA, pers.isSeniaFactura().booleanValue());
		else
			qUpdate.setBoolean(ES_SENIA_FACTURA, false);
		
		if (pers.getTomarPrecioOC1()!=null)
			qUpdate.setString(TOMAR_PRECIO_OC_1, pers.getTomarPrecioOC1());
		else
			qUpdate.setNull(TOMAR_PRECIO_OC_1, java.sql.Types.VARCHAR);
		
		if (pers.getTomarPrecioOC2()!=null)
			qUpdate.setString(TOMAR_PRECIO_OC_2, pers.getTomarPrecioOC2());
		else
			qUpdate.setNull(TOMAR_PRECIO_OC_2, java.sql.Types.VARCHAR);
		
		if (pers.getTomarPrecioOC3()!=null)
			qUpdate.setString(TOMAR_PRECIO_OC_3, pers.getTomarPrecioOC3());
		else
			qUpdate.setNull(TOMAR_PRECIO_OC_3, java.sql.Types.VARCHAR);
		
		if (pers.getTomarPrecioOC4()!=null)
			qUpdate.setString(TOMAR_PRECIO_OC_4, pers.getTomarPrecioOC4());
		else
			qUpdate.setNull(TOMAR_PRECIO_OC_4, java.sql.Types.VARCHAR);
		
		if (pers.getFormaCalcCosto()!=null)
			qUpdate.setString(FORMA_CALC_COSTO, pers.getFormaCalcCosto());
		else
			qUpdate.setNull(FORMA_CALC_COSTO, java.sql.Types.VARCHAR);

		if (pers.getProveedorCosto()!=null)
			qUpdate.setInt(OID_PROV_COSTO, pers.getProveedorCosto().getOID());
		else
			qUpdate.setNull(OID_PROV_COSTO, java.sql.Types.INTEGER);
		

		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_PRODUCTO = 1;
		Producto pers = (Producto) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update stProducto " + " set activo=0 " + " where " + " oid_producto=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_PRODUCTO, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_PRODUCTO = 1;
		Producto pers = (Producto) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update stProducto " + " set activo=1 " + " where " + " oid_producto=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_PRODUCTO, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	public PreparedStatement prepararSelect(int aSelect, Object aCondiciones) throws BaseException, SQLException {
		PreparedStatement ps = null;
		switch (aSelect) {
		case IDBObjetoPersistente.SELECT_ALL: {
			ps = this.selectAll(aCondiciones);
			break;
		}
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
		case SELECT_BY_HELP_PRODUCTO: {
			ps = this.selectByHelpProducto(aCondiciones);
			break;
		}
		case SELECT_BY_HELP_PRODUCTO_ALL: {
			ps = this.selectByHelpProductoAll(aCondiciones);
			break;
		}
		case SELECT_VALIDAR_VENDIBLE: {
			ps = this.selectByValidarVendible(aCondiciones);
			break;
		}
		case SELECT_VALIDAR_STOCKEABLE: {
			ps = this.selectByValidarStockeable(aCondiciones);
			break;
		}
		case SELECT_BY_SINONIMO: {
			ps = this.selectBySinonimo(aCondiciones);
			break;
		}
		case SELECT_BY_CODIGO_BARRA: {
			ps = this.selectByCodigoBarra(aCondiciones);
			break;
		}
		case SELECT_BY_CONSULTA_MASIVA: {
			ps = this.selectByConsultaMasiva(aCondiciones);
			break;
		}
		case SELECT_BY_CODIGO_Y_DIS_OID: {
			ps = this.selectByCodigoyDistOID(aCondiciones);
			break;
		}
		case SELECT_BY_VALOR_CLASIF: {
			ps = this.selectByValorClasif(aCondiciones);
			break;
		}
		}
		return ps;
	}

	private PreparedStatement selectAll(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  stProducto ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}

	private PreparedStatement selectByConsultaMasiva(Object aCondiciones) throws BaseException, SQLException {

		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  stProducto ");
		textSQL.append(" WHERE 1=1 ");

		// Descripcion del producto
		if (condiciones.containsKey("oid_producto") && 
			 (condiciones.getInteger("oid_producto").intValue()>0)) {			
			textSQL.append(" and oid_producto = "+condiciones.getInteger("oid_producto").toString());
		}			
		
		// Descripcion del producto
		if (condiciones.containsKey("codigo_producto") && 
			 (condiciones.getString("codigo_producto").length()>0)) {			
			StringTokenizer st = new StringTokenizer(condiciones.getString("codigo_producto"), " ");
			while (st.hasMoreTokens()) {
				String next = st.nextToken().toUpperCase();
				textSQL.append(" and codigo like '%" + next + "%' ");
			}
		}			

		
		// Descripcion del producto
		if (condiciones.containsKey("desc_producto") && 
			 (condiciones.getString("desc_producto").length()>0)) {			
			StringTokenizer st = new StringTokenizer(condiciones.getString("desc_producto"), " ");
			while (st.hasMoreTokens()) {
				String next = st.nextToken().toUpperCase();
				textSQL.append(" and desc_search like '%" + next + "%' ");
			}
		}			
		
		// Descripcion abreviada del producto
		if (condiciones.containsKey("desc_abreviada") && 
				 (condiciones.getString("desc_abreviada").length()>0)) {			
				StringTokenizer st = new StringTokenizer(condiciones.getString("desc_abreviada"), " ");
				while (st.hasMoreTokens()) {
					String next = st.nextToken().toUpperCase();
					textSQL.append(" and desc_abrev like '%" + next + "%' ");
				}
		}
		
		if (condiciones.containsKey(TipoProducto.NICKNAME)) {
			TipoProducto tipoProd = (TipoProducto) condiciones.get(TipoProducto.NICKNAME);
			textSQL.append(" and oid_tipo_prod="+tipoProd.getOIDInteger());
		}
		
		if (condiciones.containsKey("COMPRABLE")) 
			textSQL.append(" and comprable=1 ");
		
		if (condiciones.containsKey("VENDIBLE")) 
			textSQL.append(" and vendible=1 ");
		
		if (condiciones.containsKey("STOCKEBLE")) 
			textSQL.append(" and stockeable=1 ");
		
		if (condiciones.containsKey("PROD_PROPIA")) 
			textSQL.append(" and prod_propia=1 ");
		
		if (condiciones.containsKey("IMPORTADO")) 
			textSQL.append(" and importado=1 ");
		
		if (condiciones.containsKey("LISTA_VAL_CLASIF")) {
			HashTableDatos listaValClasif = 
				(HashTableDatos) condiciones.get("LISTA_VAL_CLASIF");
			Iterator iterValoresClasif = listaValClasif.keySet().iterator();
			while (iterValoresClasif.hasNext()) {
				ClasificadorEntidad clasifEnt = (ClasificadorEntidad) iterValoresClasif.next();
				IValorClasificadorEntidad valor = (IValorClasificadorEntidad)
				    listaValClasif.get(clasifEnt);
				textSQL.append(" and "+clasifEnt.getCampoFisico()+"="+valor.getOID());
			}
		}		

		
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}
	
	private PreparedStatement selectByValorClasif(Object aCondiciones) throws BaseException, SQLException {

		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		ValorClasificadorEntidad valorClasif = (ValorClasificadorEntidad) condiciones.get(ValorClasificadorEntidad.NICKNAME);
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  stProducto ");
		textSQL.append(" WHERE "+valorClasif.getClasificador_entidad().getCampoFisico()+" = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		
		querySelect.setInt(1, valorClasif.getOID());
		return querySelect;
	}

	
	
	private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

		final int OID_PRODUCTO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  stProducto ");
		textSQL.append(" WHERE oid_producto = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		int oid = ((Integer) aCondiciones).intValue();
		querySelect.setInt(OID_PRODUCTO, oid);
		return querySelect;
	}


	private PreparedStatement selectByCodigoyDistOID(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  stProducto ");
		textSQL.append(" WHERE oid_producto<>? and codigo = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		Integer oidProducto = (Integer)condiciones.get("OID_PRODUCTO");
		String codigo = condiciones.getString("CODIGO");
		querySelect.setInt(1, oidProducto.intValue());
		querySelect.setString(2, codigo);
		return querySelect;
	}
	
	private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

		final int CODIGO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  stProducto ");
		textSQL.append(" WHERE  codigo = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		String codigo = (String) aCondiciones;
		querySelect.setString(CODIGO, codigo);
		return querySelect;
	}

	private PreparedStatement selectByValidarVendible(Object aCondiciones) throws BaseException, SQLException {

		final int CODIGO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  stProducto ");
		textSQL.append(" WHERE  codigo = ? and vendible = 1 ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		String codigo = (String) aCondiciones;
		;
		querySelect.setString(CODIGO, codigo);
		return querySelect;
	}

	private PreparedStatement selectByValidarStockeable(Object aCondiciones) throws BaseException, SQLException {

		final int CODIGO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  stProducto ");
		textSQL.append(" WHERE  codigo = ? and stockeable = 1 ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		String codigo = (String) aCondiciones;
		;
		querySelect.setString(CODIGO, codigo);
		return querySelect;
	}

	private PreparedStatement selectBySinonimo(Object aCondiciones) throws BaseException, SQLException {

		final int CODIGO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  stProducto ");
		textSQL.append(" WHERE  sinonimo = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		String codigo = (String) aCondiciones;
		querySelect.setString(CODIGO, codigo);
		return querySelect;
	}

	private PreparedStatement selectByCodigoBarra(Object aCondiciones) throws BaseException, SQLException {

		final int CODIGO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  stProducto ");
		textSQL.append(" WHERE  codigo_barra = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		String codigo = (String) aCondiciones;
		;
		querySelect.setString(CODIGO, codigo);
		return querySelect;
	}

	private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();

		textSQL.append("SELECT oid_producto oid, codigo,  descripcion ,activo ");
		textSQL.append(" from stProducto");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}

	private PreparedStatement selectByHelpProducto(Object aCondiciones) throws BaseException, SQLException {

		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		StringBuffer condTipoArt = new StringBuffer();

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT a.* FROM  stProducto a ");
		textSQL.append(" where 1=1 and a.activo=1  ");

		if (condiciones.containsKey("nd_int")) {
			if (condTipoArt.length() == 0)
				condTipoArt.append(" a.hab_nd_int=1 ");
			else
				condTipoArt.append(" and a.hab_nd_int=1 ");
		}
		
		if (condiciones.containsKey("nc_int")) {
			if (condTipoArt.length() == 0)
				condTipoArt.append(" a.hab_nc_int=1 ");
			else
				condTipoArt.append(" and a.hab_nc_int=1 ");
		}
		
		
		if (condiciones.containsKey("vendible")) {
			if (condTipoArt.length() == 0)
				condTipoArt.append(" a.vendible=1 ");
			else
				condTipoArt.append(" and a.vendible=1 ");
		}
		
		if (condiciones.containsKey("producible")) {
			if (condTipoArt.length() == 0)
				condTipoArt.append(" a.prod_propia=1 ");
			else
				condTipoArt.append(" and a.prod_propia=1 ");
		}
		

		if (condiciones.containsKey("stockeable")) {
			if (condTipoArt.length() == 0)
				condTipoArt.append(" a.stockeable=1 ");
			else
				condTipoArt.append(" and a.stockeable=1 ");
		}

		if (condiciones.containsKey("comprable")) {
			if (condTipoArt.length() == 0)
				condTipoArt.append(" a.comprable=1 ");
			else
				condTipoArt.append(" and a.comprable=1 ");
		}

		if (condTipoArt.length() > 0)
			textSQL.append(" and (" + condTipoArt.toString() + ") ");

		if (condiciones.containsKey("descripcion")) {
			StringTokenizer st = new StringTokenizer(condiciones.getString("descripcion"), " ");
			while (st.hasMoreTokens()) {
				String next = st.nextToken().toUpperCase();
				
				if (next.contains(",")) {
					textSQL.append(" and (1=2 ");
					StringTokenizer st1 = new StringTokenizer(next, ",");
					while (st1.hasMoreTokens()) {
						String next1 = st1.nextToken().toUpperCase();
						textSQL.append(" or a.desc_search like '%" + next1 + "%' ");
					}
					textSQL.append(" ) ");
				} else 
					textSQL.append(" and a.desc_search like '%" + next + "%' ");
			}
		}
		
		if (condiciones.containsKey("codigo")) {
			StringTokenizer st = new StringTokenizer(condiciones.getString("codigo"), " ");
			while (st.hasMoreTokens()) {
				String next = st.nextToken().toUpperCase();
				textSQL.append(" and a.codigo like '%" + next + "%' ");
			}
		}
		

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;

	}
	
	private PreparedStatement selectByHelpProductoAll(Object aCondiciones) throws BaseException, SQLException {

		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		StringBuffer condTipoArt = new StringBuffer();

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT a.* FROM  stProducto a ");
		textSQL.append(" where 1=1   ");

		if (condiciones.containsKey("nd_int")) {
			if (condTipoArt.length() == 0)
				condTipoArt.append(" a.hab_nd_int=1 ");
			else
				condTipoArt.append(" and a.hab_nd_int=1 ");
		}
		
		if (condiciones.containsKey("nc_int")) {
			if (condTipoArt.length() == 0)
				condTipoArt.append(" a.hab_nc_int=1 ");
			else
				condTipoArt.append(" and a.hab_nc_int=1 ");
		}
		
		
		if (condiciones.containsKey("vendible")) {
			if (condTipoArt.length() == 0)
				condTipoArt.append(" a.vendible=1 ");
			else
				condTipoArt.append(" and a.vendible=1 ");
		}
		
		if (condiciones.containsKey("producible")) {
			if (condTipoArt.length() == 0)
				condTipoArt.append(" a.prod_propia=1 ");
			else
				condTipoArt.append(" and a.prod_propia=1 ");
		}
		

		if (condiciones.containsKey("stockeable")) {
			if (condTipoArt.length() == 0)
				condTipoArt.append(" a.stockeable=1 ");
			else
				condTipoArt.append(" and a.stockeable=1 ");
		}

		if (condiciones.containsKey("comprable")) {
			if (condTipoArt.length() == 0)
				condTipoArt.append(" a.comprable=1 ");
			else
				condTipoArt.append(" and a.comprable=1 ");
		}

		if (condTipoArt.length() > 0)
			textSQL.append(" and (" + condTipoArt.toString() + ") ");

		if (condiciones.containsKey("descripcion")) {
			StringTokenizer st = new StringTokenizer(condiciones.getString("descripcion"), " ");
			while (st.hasMoreTokens()) {
				String next = st.nextToken().toUpperCase();
				
				if (next.contains(",")) {
					textSQL.append(" and (1=2 ");
					StringTokenizer st1 = new StringTokenizer(next, ",");
					while (st1.hasMoreTokens()) {
						String next1 = st1.nextToken().toUpperCase();
						textSQL.append(" or a.desc_search like '%" + next1 + "%' ");
					}
					textSQL.append(" ) ");
				} else 
					textSQL.append(" and a.desc_search like '%" + next + "%' ");
			}
		}
		
		if (condiciones.containsKey("codigo")) {
			StringTokenizer st = new StringTokenizer(condiciones.getString("codigo"), " ");
			while (st.hasMoreTokens()) {
				String next = st.nextToken().toUpperCase();
				textSQL.append(" and a.codigo like '%" + next + "%' ");
			}
		}
		

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;

	}


	public static List getHelpProductos(HashTableDatos condiciones, ISesion aSesion) throws BaseException {
		return (List) ObjetoLogico.getObjects(Producto.NICKNAME, DBProducto.SELECT_BY_HELP_PRODUCTO, condiciones,
				new ListObserver(), aSesion);
	}
	
	public static List getHelpProductosAll(HashTableDatos condiciones, ISesion aSesion) throws BaseException {
		return (List) ObjetoLogico.getObjects(Producto.NICKNAME, DBProducto.SELECT_BY_HELP_PRODUCTO_ALL, condiciones,
				new ListObserver(), aSesion);
	}


	public static Producto getProductoBySinonimo(String sinonimo, ISesion aSesion) throws BaseException {
		return (Producto) ObjetoLogico.getObjects(Producto.NICKNAME, DBProducto.SELECT_BY_SINONIMO, sinonimo,
				new ObjetoObservado(), aSesion);
	}
	
	public static Producto getProductoByCodigoyDistintoOid(String codigo, Integer oid, ISesion aSesion) throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put("CODIGO",codigo);
		condiciones.put("OID_PRODUCTO",oid);
		return (Producto) ObjetoLogico.getObjects(Producto.NICKNAME, DBProducto.SELECT_BY_CODIGO_Y_DIS_OID, condiciones,
				new ObjetoObservado(), aSesion);
	}
	

	public static Producto getProductoByCodigoBarra(String codigoBarra, ISesion aSesion) throws BaseException {
		return (Producto) ObjetoLogico.getObjects(Producto.NICKNAME, DBProducto.SELECT_BY_CODIGO_BARRA, codigoBarra,
				new ObjetoObservado(), aSesion);
	}
	
  public static List getConsultaMasivaProductos(
	    Integer oidProducto,
  		String descProducto,
  		String descAbreviada,
  		String codigoProducto,
  		TipoProducto tipoProducto,  		
  		boolean isComprable,
  		boolean isVendible,
  		boolean isStockeable,
  		boolean isProdPropia,
  		boolean isImportado,
  		HashTableDatos listaValoresClasif,
      ISesion aSesion) throws BaseException {
  	
  	HashTableDatos condiciones = new HashTableDatos();
  	
  	if ((oidProducto!=null) && (oidProducto.intValue()>0))
  		condiciones.put("oid_producto",oidProducto);

  	if ((descProducto!=null) && (descProducto.length()>0))
  		condiciones.put("desc_producto",descProducto);

  	if ((descAbreviada!=null) && (descAbreviada.length()>0))
  		condiciones.put("desc_abreviada",descAbreviada);
  	
  	if ((codigoProducto!=null) && (codigoProducto.length()>0))
  		condiciones.put("codigo_producto",codigoProducto);
  	
  	
  	if (tipoProducto!=null)
    		condiciones.put(TipoProducto.NICKNAME,tipoProducto);
  	
  	if (isComprable)
  		condiciones.put("COMPRABLE","");
  	if (isVendible)
  		condiciones.put("VENDIBLE","");
  	if (isStockeable)
  		condiciones.put("STOCKEBLE","");
  	if (isProdPropia)
  		condiciones.put("PROD_PROPIA","");
  	if (isImportado)
  		condiciones.put("IMPORTADO","");
  	
  	if ((listaValoresClasif!=null) && (listaValoresClasif.keySet().size()>0)) 
  		condiciones.put("LISTA_VAL_CLASIF",listaValoresClasif);
  	

  	return (List) ObjetoLogico.getObjects(Producto.NICKNAME,
         DBProducto.SELECT_BY_CONSULTA_MASIVA,
         condiciones,
         new ListObserver(),
         aSesion);
  }
  
	public static List getProductosByValorClasificador(ValorClasificadorEntidad valor, ISesion aSesion) throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put(ValorClasificadorEntidad.NICKNAME, valor);
		return (List) ObjetoLogico.getObjects(Producto.NICKNAME, DBProducto.SELECT_BY_VALOR_CLASIF, condiciones,
				new ListObserver(), aSesion);
	}
  
  
	

}
