package com.srn.erp.stock.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

import com.srn.erp.general.bm.ClasificadorEntidad;
import com.srn.erp.general.bm.IValorClasificadorEntidad;
import com.srn.erp.general.bm.ValorClasificadorEntidad;
import com.srn.erp.stock.bm.ExtensionProdGen;
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

public class DBExtensionProdGen extends DBObjetoPersistente {

  public static final String OID_EXTENSION_PG = "oid_extension_pg";
  public static final String OID_VAL_CLASIF_ENT = "oid_val_clasif_ent";
  public static final String OID_CLASIF_ENT = "oid_clasif_ent";
  public static final String OID_CONC_FACT_PROV = "oid_conc_fact_prov";
  public static final String OID_UM_VTAS = "oid_um_vtas";
  public static final String OID_UM_COMPRA = "oid_um_compra";
  
  public static final String LT_ENTREGA = "lt_entrega";
  public static final String PRECIO_NO_DEF_LP = "prec_no_def_lp";
  public static final String MODIF_PREC_FACT = "modif_prec_fact";
  public static final String CANT_DEC_PRECIO = "cant_dec_precio";
  
  public static final String OID_UM_STOCK_PPAL = "oid_um_stock_ppal";
  public static final String OID_UM_STOCK_ALT = "oid_um_stock_alt";
  public static final String LLEVA_SERIE = "lleva_serie";
  public static final String LLEVA_PARTIDA = "lleva_partida";
  public static final String SEGUI_STOCK = "segui_stock";
  
  public static final String CALC_PERC_IB_CF = "calc_perc_ib_cf";
  public static final String CALC_PERC_IB_BA = "calc_perc_ib_ba";
  public static final String CALC_PERC_IVA = "calc_perc_iva";
  
  public static final String SISTEMA_CALIDAD = "sistema_calidad";
  
  public static final String FORMA_CALC_COSTO = "forma_calc_costo";
  public static final String OID_PROV_COSTO = "oid_prov_costo";
  
  
  
  
  
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
	
	public static final String	OID_TIPO_PROD							= "oid_tipo_prod";
	
	public static final String	COMPRABLE								= "comprable";
	
	public static final String	VENDIBLE								= "vendible";
	
	public static final String	STOCKEABLE								= "stockeable";
	
	public static final String	PROD_PROPIA								= "prod_propia";
	
	public static final String	IMPORTADO								= "importado";
	
	public static final String	OID_UM_PROD								= "oid_um_prod";
	
	public static final String	ES_SALDO_FACT_SENIA						= "es_sal_fact_senia";
	
	public static final String	ES_SENIA								= "es_senia";
	
	public static final String	OID_IMPU_VTA							= "oid_impu_vta";
	
	public static final String	HAB_ND_INT							= "hab_nd_int";
	
	public static final String	HAB_NC_INT							= "hab_nc_int";
	
	public static final String	PORC_CUMP_OC							= "porc_cump_oc";
	public static final String	OID_CUENTA_COMPRAS						= "oid_cuenta_compras";
	public static final String	PORC_TOL_RECEP							= "porc_tol_recep";
	public static final String	LT_ENTREGA_PROV							= "lt_entrega_prov";
	
	public static final String	TOMAR_PRECIO_OC_1							= "tomar_precio_oc_1";
	public static final String	TOMAR_PRECIO_OC_2							= "tomar_precio_oc_2";
	public static final String	TOMAR_PRECIO_OC_3							= "tomar_precio_oc_3";
	public static final String	TOMAR_PRECIO_OC_4							= "tomar_precio_oc_4";
	
	public static final String	COMO_OBTENER_COSTO							= "como_obtener_costo";
	
  
  public static final int SELECT_VAL_CLASIF_ENT = 100;
  public static final int			SELECT_BY_CONSULTA_MASIVA	= 101;

  public DBExtensionProdGen() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_EXTENSION_PG = 1;
    final int OID_VAL_CLASIF_ENT = 2;
    final int OID_CLASIF_ENT = 3;
    final int OID_CONC_FACT_PROV = 4;
    
    final int OID_UM_VTAS = 5;
    final int LT_ENTREGA= 6;
    final int PRECIO_NO_DEF_EN_LP = 7;
    final int MODIF_PRECIO_FACT = 8;
    final int CANT_DEC_PRECIO = 9;

	final int OID_CLASIF_01 = 10;
	final int OID_CLASIF_02 = 11;
	final int OID_CLASIF_03 = 12;
	final int OID_CLASIF_04 = 13;
	final int OID_CLASIF_05 = 14;
	final int OID_CLASIF_06 = 15;
	final int OID_CLASIF_07 = 16;
	final int OID_CLASIF_08 = 17;
	final int OID_CLASIF_09 = 18;
	final int OID_CLASIF_10 = 19;
	final int OID_CLASIF_11 = 20;
	final int OID_CLASIF_12 = 21;
	final int OID_CLASIF_13 = 22;
	final int OID_CLASIF_14 = 23;
	final int OID_CLASIF_15 = 24;
	final int OID_CLASIF_16 = 25;
	final int OID_CLASIF_17 = 26;
	final int OID_CLASIF_18 = 27;
	final int OID_CLASIF_19 = 28;
	final int OID_CLASIF_20 = 29;
	
	final int OID_UM_COMPRA = 30;
	
	final int OID_TIPO_PROD = 31;
	final int COMPRABLE = 32;
	final int VENDIBLE = 33;
	final int STOCKEABLE = 34;
	final int PROD_PROPIA = 35;
	final int IMPORTADO = 36;
	
	final int OID_UM_PROD = 37;
	
	final int OID_UM_STOCK_PPAL = 38;
	final int OID_UM_STOCK_ALT = 39;
	final int LLEVA_SERIE = 40;
	final int LLEVA_PARTIDA = 41;
	final int SEGUI_STOCK = 42;
	
	final int ES_SALDO_FACT_SENIA	= 43;
	final int ES_SENIA	= 44;
	final int OID_IMPU_VTA	= 45;
	
	final int HAB_ND_INT = 46;
	final int HAB_NC_INT = 47;
	
	final int CALC_PERC_IB_CF = 48;
	final int CALC_PERC_IB_BA = 49;
	final int CALC_PERC_IVA = 50;
	
	final int SISTEMA_CALIDAD = 51;
	
	final int PORC_CUMP_OC	= 52;
	final int OID_CUENTA_COMPRAS =  53;
	final int PORC_TOL_RECEP	= 54;
	final int LT_ENTREGA_PROV	= 55;
	
	final int TOMAR_PRECIO_OC_1 = 56;
	final int TOMAR_PRECIO_OC_2 = 57;
	final int TOMAR_PRECIO_OC_3 = 58;
	final int TOMAR_PRECIO_OC_4 = 59;
	
	final int FORMA_CALC_COSTO = 60;
	final int OID_PROV_COSTO = 61;
	
	final int COMO_OBTENER_COSTO = 62;
	
    ExtensionProdGen pers = (ExtensionProdGen) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into stExtensionPG "+
                     " ( "+
                      "OID_EXTENSION_PG,"+
                      "OID_VAL_CLASIF_ENT,"+
                      "OID_CLASIF_ENT,"+
                      "OID_CONC_FACT_PROV,OID_UM_VTAS,LT_ENTREGA,PREC_NO_DEF_LP,MODIF_PREC_FACT,CANT_DEC_PRECIO,"+
                       "OID_CLASIF_01,"
      					+ "OID_CLASIF_02," + "OID_CLASIF_03," + "OID_CLASIF_04," + "OID_CLASIF_05," + "OID_CLASIF_06,"
      					+ "OID_CLASIF_07," + "OID_CLASIF_08," + "OID_CLASIF_09," + "OID_CLASIF_10," + "OID_CLASIF_11,"
      					+ "OID_CLASIF_12," + "OID_CLASIF_13," + "OID_CLASIF_14," + "OID_CLASIF_15," + "OID_CLASIF_16,"
      					+ "OID_CLASIF_17," + "OID_CLASIF_18," + "OID_CLASIF_19," + "OID_CLASIF_20 , OID_UM_COMPRA,"
      					+ "OID_TIPO_PROD," + "COMPRABLE," + "VENDIBLE," + "STOCKEABLE , PROD_PROPIA,IMPORTADO , OID_UM_PROD,"
      					+ "OID_UM_STOCK_PPAL,OID_UM_STOCK_ALT,LLEVA_SERIE,LLEVA_PARTIDA,SEGUI_STOCK, "+
      					" es_sal_fact_senia, es_senia , oid_impu_vta , hab_nd_int , hab_nc_int , calc_perc_ib_cf , calc_perc_ib_ba , calc_perc_iva , sistema_calidad "+
      					",porc_cump_oc,oid_cuenta_compras,porc_tol_recep,lt_entrega_prov,"+
      					"tomar_precio_oc_1,tomar_precio_oc_2,tomar_precio_oc_3,tomar_precio_oc_4,"+
      					"forma_calc_costo,oid_prov_costo,como_obtener_costo"+
      					")"+
                      " values "+ 
                      "("+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_EXTENSION_PG,pers.getOID());
    qInsert.setInt(OID_VAL_CLASIF_ENT,pers.getValor_clasif_ent().getOID());
    qInsert.setInt(OID_CLASIF_ENT,pers.getClasificador().getOID());
    if (pers.getConc_fact_prov()!=null)
    	qInsert.setInt(OID_CONC_FACT_PROV,pers.getConc_fact_prov().getOID());
    else
    	qInsert.setNull(OID_CONC_FACT_PROV,java.sql.Types.INTEGER);
    
    if (pers.getUMVta()!=null)
    	qInsert.setInt(OID_UM_VTAS,pers.getUMVta().getOID());
    else
    	qInsert.setNull(OID_UM_VTAS,java.sql.Types.INTEGER);
    
    if (pers.getLTEntrega()!=null)
    	qInsert.setInt(LT_ENTREGA,pers.getLTEntrega().intValue());
    else
    	qInsert.setNull(LT_ENTREGA,java.sql.Types.INTEGER);
    
    if (pers.isPrecioNoDefEnLP()!=null)
    	qInsert.setBoolean(PRECIO_NO_DEF_EN_LP,pers.isPrecioNoDefEnLP().booleanValue());
    else
    	qInsert.setNull(PRECIO_NO_DEF_EN_LP,java.sql.Types.BOOLEAN);
    
    if (pers.isModifPrecioFact()!=null)
    	qInsert.setBoolean(MODIF_PRECIO_FACT,pers.isModifPrecioFact().booleanValue());
    else
    	qInsert.setNull(MODIF_PRECIO_FACT,java.sql.Types.BOOLEAN);
    
    if (pers.getCantDecPrecio()!=null)
    	qInsert.setInt(CANT_DEC_PRECIO,pers.getCantDecPrecio().intValue());
    else
    	qInsert.setNull(CANT_DEC_PRECIO,java.sql.Types.INTEGER);
    
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
    
    if (pers.getUMCompra()!=null)
    	qInsert.setInt(OID_UM_COMPRA,pers.getUMCompra().getOID());
    else
    	qInsert.setNull(OID_UM_COMPRA,java.sql.Types.INTEGER);
    
    if (pers.getTipoProducto()!=null)
    	qInsert.setInt(OID_TIPO_PROD,pers.getTipoProducto().getOID());
    else
    	qInsert.setNull(OID_TIPO_PROD,java.sql.Types.INTEGER);    
    
    qInsert.setBoolean(COMPRABLE,pers.isComprable());
    qInsert.setBoolean(VENDIBLE,pers.isVendible());
    qInsert.setBoolean(STOCKEABLE,pers.isStockeable());
    qInsert.setBoolean(PROD_PROPIA,pers.isProdPropia());
    qInsert.setBoolean(IMPORTADO,pers.isImportado());
    
    if (pers.getUMProd()!=null)
    	qInsert.setInt(OID_UM_PROD,pers.getUMProd().getOID());
    else
    	qInsert.setNull(OID_UM_PROD,java.sql.Types.INTEGER);    
    
    if (pers.getUMStockPpal()!=null)
    	qInsert.setInt(OID_UM_STOCK_PPAL,pers.getUMStockPpal().getOID());
    else
    	qInsert.setNull(OID_UM_STOCK_PPAL,java.sql.Types.INTEGER);    
    
    if (pers.getUMStockAlt()!=null)
    	qInsert.setInt(OID_UM_STOCK_ALT,pers.getUMStockAlt().getOID());
    else
    	qInsert.setNull(OID_UM_STOCK_ALT,java.sql.Types.INTEGER);
    
    qInsert.setBoolean(LLEVA_SERIE, pers.isLlevaSerie());
    qInsert.setBoolean(LLEVA_PARTIDA, pers.isLlevaPartida());
    qInsert.setBoolean(SEGUI_STOCK, pers.isSeguiStock());
    
    
    qInsert.setBoolean(ES_SALDO_FACT_SENIA, pers.isSaldoFacturaSenia());
    qInsert.setBoolean(ES_SENIA, pers.isSenia());
    if (pers.getCuentaImputableVentas()!=null)
    	qInsert.setInt(OID_IMPU_VTA, pers.getCuentaImputableVentas().getOID());
    else
    	qInsert.setInt(OID_IMPU_VTA, new Integer(0));
    
    if (pers.isHabNDInt()!=null)
    	qInsert.setBoolean(HAB_ND_INT, pers.isHabNDInt().booleanValue());
    else
    	qInsert.setBoolean(HAB_ND_INT, new Boolean(false));
    
    if (pers.isHabNCInt()!=null)
    	qInsert.setBoolean(HAB_NC_INT, pers.isHabNCInt().booleanValue());
    else
    	qInsert.setBoolean(HAB_NC_INT, new Boolean(false));    
    
    if (pers.isSuscPercIBCapFed()!=null)
    	qInsert.setBoolean(CALC_PERC_IB_CF, pers.isSuscPercIBCapFed().booleanValue());
    else
    	qInsert.setBoolean(CALC_PERC_IB_CF, new Boolean(false));    
    
    if (pers.isSuscPercIBBsAs()!=null)
    	qInsert.setBoolean(CALC_PERC_IB_BA, pers.isSuscPercIBBsAs().booleanValue());
    else
    	qInsert.setBoolean(CALC_PERC_IB_BA, new Boolean(false));    
    
    if (pers.isSuscPercIVA()!=null)
    	qInsert.setBoolean(CALC_PERC_IVA, pers.isSuscPercIVA().booleanValue());
    else
    	qInsert.setBoolean(CALC_PERC_IVA, new Boolean(false));
    
    qInsert.setBoolean(SISTEMA_CALIDAD, pers.isSistemaCalidad());
    
    
    if (pers.getPorcCumpOC()!=null)
    	qInsert.setDouble(PORC_CUMP_OC, pers.getPorcCumpOC().doubleValue());
    else
    	qInsert.setDouble(PORC_CUMP_OC, 0);
    
    if (pers.getCuentaCompras()!=null)
    	qInsert.setInt(OID_CUENTA_COMPRAS, pers.getCuentaCompras().getOID());
    else
    	qInsert.setNull(OID_CUENTA_COMPRAS, java.sql.Types.INTEGER);
    
    if (pers.getPorcTolRecep()!=null)
    	qInsert.setDouble(PORC_TOL_RECEP, pers.getPorcTolRecep().doubleValue());
    else
    	qInsert.setDouble(PORC_TOL_RECEP, 0);
    
    if (pers.getLTEntregaProv()!=null)
    	qInsert.setInt(LT_ENTREGA_PROV, pers.getLTEntregaProv().intValue());
    else
    	qInsert.setInt(LT_ENTREGA_PROV, 0);
    
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
    
    if (pers.getComoObtenerCosto()!=null)
    	qInsert.setString(COMO_OBTENER_COSTO, pers.getComoObtenerCosto());
    else
    	qInsert.setNull(COMO_OBTENER_COSTO, java.sql.Types.VARCHAR);    
    
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_VAL_CLASIF_ENT = 1;
    final int OID_CLASIF_ENT = 2;
    final int OID_CONC_FACT_PROV = 3;
    
    final int OID_UM_VTAS = 4;
    final int LT_ENTREGA= 5;
    final int PRECIO_NO_DEF_EN_LP = 6;
    final int MODIF_PRECIO_FACT = 7;
    final int CANT_DEC_PRECIO = 8;
    
	final int OID_CLASIF_01 = 9;
	final int OID_CLASIF_02 = 10;
	final int OID_CLASIF_03 = 11;
	final int OID_CLASIF_04 = 12;
	final int OID_CLASIF_05 = 13;
	final int OID_CLASIF_06 = 14;
	final int OID_CLASIF_07 = 15;
	final int OID_CLASIF_08 = 16;
	final int OID_CLASIF_09 = 17;
	final int OID_CLASIF_10 = 18;
	final int OID_CLASIF_11 = 19;
	final int OID_CLASIF_12 = 20;
	final int OID_CLASIF_13 = 21;
	final int OID_CLASIF_14 = 22;
	final int OID_CLASIF_15 = 23;
	final int OID_CLASIF_16 = 24;
	final int OID_CLASIF_17 = 25;
	final int OID_CLASIF_18 = 26;
	final int OID_CLASIF_19 = 27;
	final int OID_CLASIF_20 = 28;
	final int OID_UM_COMPRA = 29;
	
	final int OID_TIPO_PROD = 30;
	final int COMPRABLE = 31;
	final int VENDIBLE = 32;
	final int STOCKEABLE = 33;
	final int PROD_PROPIA = 34;
	final int IMPORTADO = 35;
	
	final int OID_UM_PROD = 36;
	final int OID_UM_STOCK_PPAL = 37;
	final int OID_UM_STOCK_ALT = 38;
	final int LLEVA_SERIE = 39;
	final int LLEVA_PARTIDA = 40;
	final int SEGUI_STOCK = 41;
	
	final int ES_SALDO_FACT_SENIA	= 42;
	final int ES_SENIA	= 43;
	final int OID_IMPU_VTA	= 44;
	
	final int HAB_ND_INT = 45;
	final int HAB_NC_INT = 46;
		
	final int CALC_PERC_IB_CF = 47;
	final int CALC_PERC_IB_BA = 48;
	final int CALC_PERC_IVA = 49;	
	
	final int SISTEMA_CALIDAD = 50;
	
	final int PORC_CUMP_OC	= 51;
	final int OID_CUENTA_COMPRAS =  52;
	final int PORC_TOL_RECEP	= 53;
	final int LT_ENTREGA_PROV	= 54;
	
	final int TOMAR_PRECIO_OC_1 = 55;
	final int TOMAR_PRECIO_OC_2 = 56;
	final int TOMAR_PRECIO_OC_3 = 57;
	final int TOMAR_PRECIO_OC_4 = 58;
	
    final int FORMA_CALC_COSTO = 59;
    final int OID_PROV_COSTO = 60;
    
    final int COMO_OBTENER_COSTO = 61;
    
    final int OID_EXTENSION_PG = 62;

    ExtensionProdGen pers = (ExtensionProdGen) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update stExtensionPG set "+
              "oid_val_clasif_ent=?"+ 
              ",oid_clasif_ent=?"+ 
              ",oid_conc_fact_prov=?"+ 
              ",OID_UM_VTAS=?"+
              ",LT_ENTREGA=?"+
              ",PREC_NO_DEF_LP=?"+
              ",MODIF_PREC_FACT=?"+
              ",CANT_DEC_PRECIO=?, "+
              "oid_clasif_01 = ?," + "oid_clasif_02 = ?," + "oid_clasif_03 = ?," + "oid_clasif_04 = ?,"
				+ "oid_clasif_05 = ?," + "oid_clasif_06 = ?," + "oid_clasif_07 = ?," + "oid_clasif_08 = ?,"
				+ "oid_clasif_09 = ?," + "oid_clasif_10 = ?," + "oid_clasif_11 = ?," + "oid_clasif_12 = ?,"
				+ "oid_clasif_13 = ?," + "oid_clasif_14 = ?," + "oid_clasif_15 = ?," + "oid_clasif_16 = ?,"
				+ "oid_clasif_17 = ?," + "oid_clasif_18 = ?," + "oid_clasif_19 = ?," + "oid_clasif_20 = ?  , oid_um_compra = ?, "+              
				 "oid_tipo_prod = ?," + "comprable = ?," + "vendible = ?," + "stockeable = ?  , prod_propia = ? , importado = ? , oid_um_prod = ?, "+
				 "oid_um_stock_ppal=? , oid_um_stock_alt = ? ,lleva_serie = ? , lleva_partida = ? , segui_stock = ? , es_sal_fact_senia = ?, es_senia = ?, oid_impu_vta = ? , hab_nd_int = ? , hab_nc_int = ? , calc_perc_ib_cf = ? , calc_perc_ib_ba = ? , calc_perc_iva = ? , sistema_calidad = ? ,"+
				 " porc_cump_oc = ?,oid_cuenta_compras = ?,porc_tol_recep = ?,lt_entrega_prov = ? ,"+
				 " tomar_precio_oc_1=?,tomar_precio_oc_2=?,tomar_precio_oc_3=?,tomar_precio_oc_4=?, "+
				 " forma_calc_costo = ? , oid_prov_costo = ? , como_obtener_costo = ? "+
                 " where " +
                 " oid_extension_pg=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_EXTENSION_PG,pers.getOID());
    qUpdate.setInt(OID_VAL_CLASIF_ENT,pers.getValor_clasif_ent().getOID());
    qUpdate.setInt(OID_CLASIF_ENT,pers.getClasificador().getOID());
    if (pers.getConc_fact_prov()!=null)
    	qUpdate.setInt(OID_CONC_FACT_PROV,pers.getConc_fact_prov().getOID());
    else
    	qUpdate.setNull(OID_CONC_FACT_PROV,java.sql.Types.INTEGER);
    
    if (pers.getUMVta()!=null)
    	qUpdate.setInt(OID_UM_VTAS,pers.getUMVta().getOID());
    else
    	qUpdate.setNull(OID_UM_VTAS,java.sql.Types.INTEGER);
    
    if (pers.getLTEntrega()!=null)
    	qUpdate.setInt(LT_ENTREGA,pers.getLTEntrega().intValue());
    else
    	qUpdate.setNull(LT_ENTREGA,java.sql.Types.INTEGER);
    
    if (pers.isPrecioNoDefEnLP()!=null)
    	qUpdate.setBoolean(PRECIO_NO_DEF_EN_LP,pers.isPrecioNoDefEnLP().booleanValue());
    else
    	qUpdate.setNull(PRECIO_NO_DEF_EN_LP,java.sql.Types.BOOLEAN);
    
    if (pers.isModifPrecioFact()!=null)
    	qUpdate.setBoolean(MODIF_PRECIO_FACT,pers.isModifPrecioFact().booleanValue());
    else
    	qUpdate.setNull(MODIF_PRECIO_FACT,java.sql.Types.BOOLEAN);
    
    if (pers.getCantDecPrecio()!=null)
    	qUpdate.setInt(CANT_DEC_PRECIO,pers.getCantDecPrecio().intValue());
    else
    	qUpdate.setNull(CANT_DEC_PRECIO,java.sql.Types.INTEGER);
    
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
    
    if (pers.getUMCompra()!=null)
    	qUpdate.setInt(OID_UM_COMPRA,pers.getUMCompra().getOID());
    else
    	qUpdate.setNull(OID_UM_COMPRA,java.sql.Types.INTEGER);
    
    if (pers.getTipoProducto()!=null)
    	qUpdate.setInt(OID_TIPO_PROD,pers.getTipoProducto().getOID());
    else
    	qUpdate.setNull(OID_TIPO_PROD,java.sql.Types.INTEGER);    
    
    qUpdate.setBoolean(COMPRABLE,pers.isComprable());
    qUpdate.setBoolean(VENDIBLE,pers.isVendible());
    qUpdate.setBoolean(STOCKEABLE,pers.isStockeable());
    qUpdate.setBoolean(PROD_PROPIA,pers.isProdPropia());
    qUpdate.setBoolean(IMPORTADO,pers.isImportado());
    
    if (pers.getUMProd()!=null)
    	qUpdate.setInt(OID_UM_PROD,pers.getUMProd().getOID());
    else
    	qUpdate.setNull(OID_UM_PROD,java.sql.Types.INTEGER);
    
    if (pers.getUMStockPpal()!=null)
    	qUpdate.setInt(OID_UM_STOCK_PPAL,pers.getUMStockPpal().getOID());
    else
    	qUpdate.setNull(OID_UM_STOCK_PPAL,java.sql.Types.INTEGER);    
    
    if (pers.getUMStockAlt()!=null)
    	qUpdate.setInt(OID_UM_STOCK_ALT,pers.getUMStockAlt().getOID());
    else
    	qUpdate.setNull(OID_UM_STOCK_ALT,java.sql.Types.INTEGER);
    
    qUpdate.setBoolean(LLEVA_SERIE, pers.isLlevaSerie());
    qUpdate.setBoolean(LLEVA_PARTIDA, pers.isLlevaPartida());
    qUpdate.setBoolean(SEGUI_STOCK, pers.isSeguiStock());
    
    qUpdate.setBoolean(ES_SALDO_FACT_SENIA, pers.isSaldoFacturaSenia());
    qUpdate.setBoolean(ES_SENIA, pers.isSenia());
    if (pers.getCuentaImputableVentas()!=null)
    	qUpdate.setInt(OID_IMPU_VTA, pers.getCuentaImputableVentas().getOID());
    else
    	qUpdate.setInt(OID_IMPU_VTA, new Integer(0));
    
    if (pers.isHabNDInt()!=null)
    	qUpdate.setBoolean(HAB_ND_INT, pers.isHabNDInt().booleanValue());
    else
    	qUpdate.setBoolean(HAB_ND_INT, new Boolean(false));
    
    if (pers.isHabNCInt()!=null)
    	qUpdate.setBoolean(HAB_NC_INT, pers.isHabNCInt().booleanValue());
    else
    	qUpdate.setBoolean(HAB_NC_INT, new Boolean(false));    
    
    if (pers.isSuscPercIBCapFed()!=null)
    	qUpdate.setBoolean(CALC_PERC_IB_CF, pers.isSuscPercIBCapFed().booleanValue());
    else
    	qUpdate.setBoolean(CALC_PERC_IB_CF, new Boolean(false));    
    
    if (pers.isSuscPercIBBsAs()!=null)
    	qUpdate.setBoolean(CALC_PERC_IB_BA, pers.isSuscPercIBBsAs().booleanValue());
    else
    	qUpdate.setBoolean(CALC_PERC_IB_BA, new Boolean(false));    
    
    if (pers.isSuscPercIVA()!=null)
    	qUpdate.setBoolean(CALC_PERC_IVA, pers.isSuscPercIVA().booleanValue());
    else
    	qUpdate.setBoolean(CALC_PERC_IVA, new Boolean(false));
    
    if (pers.isSistemaCalidad()!=null)
    	qUpdate.setBoolean(SISTEMA_CALIDAD, pers.isSistemaCalidad().booleanValue());
    else
    	qUpdate.setBoolean(SISTEMA_CALIDAD, new Boolean(false));
    
    if (pers.getPorcCumpOC()!=null)
    	qUpdate.setDouble(PORC_CUMP_OC, pers.getPorcCumpOC().doubleValue());
    else
    	qUpdate.setDouble(PORC_CUMP_OC, 0);
    
    if (pers.getCuentaCompras()!=null)
    	qUpdate.setInt(OID_CUENTA_COMPRAS, pers.getCuentaCompras().getOID());
    else
    	qUpdate.setNull(OID_CUENTA_COMPRAS, java.sql.Types.INTEGER);
    
    if (pers.getPorcTolRecep()!=null)
    	qUpdate.setDouble(PORC_TOL_RECEP, pers.getPorcTolRecep().doubleValue());
    else
    	qUpdate.setDouble(PORC_TOL_RECEP, 0);
    
    if (pers.getLTEntregaProv()!=null)
    	qUpdate.setInt(LT_ENTREGA_PROV, pers.getLTEntregaProv().intValue());
    else
    	qUpdate.setInt(LT_ENTREGA_PROV, 0);    
    
    
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

    if (pers.getComoObtenerCosto()!=null)
    	qUpdate.setString(COMO_OBTENER_COSTO, pers.getComoObtenerCosto());
    else
    	qUpdate.setNull(COMO_OBTENER_COSTO, java.sql.Types.VARCHAR);    
    
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    ExtensionProdGen pers = (ExtensionProdGen) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("delete from stExtensionPG "+
                     " where " + 
                     " oid_extension_pg=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(1, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
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
      case SELECT_VAL_CLASIF_ENT: {
          ps = this.selectByValClasifEnt(aCondiciones); 
          break; 
      }
	  case SELECT_BY_CONSULTA_MASIVA: {
		  ps = this.selectByConsultaMasiva(aCondiciones);
		  break;
	  }      
    } 
    return ps;
  }

  
  private PreparedStatement selectByValClasifEnt(Object aCondiciones) throws BaseException, SQLException { 

	  	HashTableDatos condiciones = (HashTableDatos) aCondiciones;
	  	ValorClasificadorEntidad valClasifEnt = (ValorClasificadorEntidad) condiciones.get(ValorClasificadorEntidad.NICKNAME);
	  	ClasificadorEntidad clasifEntidad = valClasifEnt.getClasificador_entidad();
	  
	  	
	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM  stExtensionPG "); 
	    textSQL.append(" WHERE oid_val_clasif_ent = ? and oid_clasif_ent = ? "); 
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
	    querySelect.setInt(1, valClasifEnt.getOID()); 
	    querySelect.setInt(2, clasifEntidad.getOID());
	    return querySelect; 
  }
  
  public static ExtensionProdGen getExtensionGral(ValorClasificadorEntidad valClasifEnt,
          ISesion aSesion)
          throws BaseException {
	  HashTableDatos condiciones = new HashTableDatos();
	  condiciones.put(ValorClasificadorEntidad.NICKNAME, valClasifEnt);
	  return (ExtensionProdGen) ObjetoLogico.getObjects(ExtensionProdGen.NICKNAME,
			  				DBExtensionProdGen.SELECT_VAL_CLASIF_ENT,
			  				condiciones,
			  				new ObjetoObservado(),
			  				aSesion);
  }
  
  
  
  
  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  stExtensionPG "); 
    textSQL.append(" WHERE oid_extension_pg = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(1, oid); 
    return querySelect; 
  }
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  stConcFactPG "); 
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_extension_pg oid, codigo,  descripcion ,activo ");
    textSQL.append(" from stExtensionPG");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
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
	  	

	  	return (List) ObjetoLogico.getObjects(ExtensionProdGen.NICKNAME,
	         DBExtensionProdGen.SELECT_BY_CONSULTA_MASIVA,
	         condiciones,
	         new ListObserver(),
	         aSesion);
	  }
  
	private PreparedStatement selectByConsultaMasiva(Object aCondiciones) throws BaseException, SQLException {

		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT a.* FROM  stExtensionPG a, geValClasifEnt b ");
		textSQL.append(" WHERE a.oid_val_clasif_ent=b.oid_val_clasif_ent ");

		// Descripcion del producto
		if (condiciones.containsKey("oid_producto") && 
			 (condiciones.getInteger("oid_producto").intValue()>0)) {			
			textSQL.append(" and a.oid_val_clasif_ent = "+condiciones.getInteger("oid_producto").toString());
		}			
		
		// Descripcion del producto
		if (condiciones.containsKey("codigo_producto") && 
			 (condiciones.getString("codigo_producto").length()>0)) {			
			StringTokenizer st = new StringTokenizer(condiciones.getString("codigo_producto"), " ");
			while (st.hasMoreTokens()) {
				String next = st.nextToken().toUpperCase();
				textSQL.append(" and b.codigo like '%" + next + "%' ");
			}
		}			

		
		// Descripcion del producto
		if (condiciones.containsKey("desc_producto") && 
			 (condiciones.getString("desc_producto").length()>0)) {			
			StringTokenizer st = new StringTokenizer(condiciones.getString("desc_producto"), " ");
			while (st.hasMoreTokens()) {
				String next = st.nextToken().toUpperCase();
				textSQL.append(" and b.descripcion like '%" + next + "%' ");
			}
		}			
		
		// Descripcion abreviada del producto
		if (condiciones.containsKey("desc_abreviada") && 
				 (condiciones.getString("desc_abreviada").length()>0)) {			
				StringTokenizer st = new StringTokenizer(condiciones.getString("desc_abreviada"), " ");
				while (st.hasMoreTokens()) {
					String next = st.nextToken().toUpperCase();
					textSQL.append(" and b.descripcion like '%" + next + "%' ");
				}
		}
		
		if (condiciones.containsKey(TipoProducto.NICKNAME)) {
			TipoProducto tipoProd = (TipoProducto) condiciones.get(TipoProducto.NICKNAME);
			textSQL.append(" and a.oid_tipo_prod="+tipoProd.getOIDInteger());
		}
		
		/*if (condiciones.containsKey("COMPRABLE")) 
			textSQL.append(" and comprable=1 ");
		
		if (condiciones.containsKey("VENDIBLE")) 
			textSQL.append(" and vendible=1 ");
		
		if (condiciones.containsKey("STOCKEBLE")) 
			textSQL.append(" and stockeable=1 ");
		
		if (condiciones.containsKey("PROD_PROPIA")) 
			textSQL.append(" and prod_propia=1 ");
		
		if (condiciones.containsKey("IMPORTADO")) 
			textSQL.append(" and importado=1 ");*/
		
		if (condiciones.containsKey("LISTA_VAL_CLASIF")) {
			HashTableDatos listaValClasif = 
				(HashTableDatos) condiciones.get("LISTA_VAL_CLASIF");
			Iterator iterValoresClasif = listaValClasif.keySet().iterator();
			while (iterValoresClasif.hasNext()) {
				ClasificadorEntidad clasifEnt = (ClasificadorEntidad) iterValoresClasif.next();
				IValorClasificadorEntidad valor = (IValorClasificadorEntidad)
				    listaValClasif.get(clasifEnt);
				textSQL.append(" and a."+clasifEnt.getCampoFisico()+"="+valor.getOID());
			}
		}		

		
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}

		
  
  
} 
