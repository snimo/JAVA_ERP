package com.srn.erp.compras.da;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import com.srn.erp.compras.bm.LugarEntrega;
import com.srn.erp.compras.bm.OrdenDeCompraCab;
import com.srn.erp.compras.bm.OrdenDeCompraDet;
import com.srn.erp.compras.bm.Proveedor;
import com.srn.erp.compras.bm.RequisicionCab;
import com.srn.erp.general.bm.ClasificadorEntidad;
import com.srn.erp.general.bm.Talonario;
import com.srn.erp.general.bm.ValorClasificadorEntidad;
import com.srn.erp.stock.bm.Producto;
import com.srn.erp.sueldos.bm.Legajo;
import com.srn.erp.ventas.bm.PedidoDet;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.applicarionServer.bm.Varios.Money;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;

public class DBOrdenDeCompraDet extends DBObjetoPersistente {

	public static final String	OID_OC_DET										= "oid_oc_det";

	public static final String	OID_CCO_CPRA									= "oid_cco_cpra";

	public static final String	NRO_ITEM											= "nro_item";

	public static final String	OID_UM_CPRA										= "oid_um_cpra";

	public static final String	OID_PRODUCTO									= "oid_producto";

	public static final String	DESC_ADIC_SKU									= "desc_adic_sku";

	public static final String	OID_UM_STOCK									= "oid_um_stock";

	public static final String	CANT_CPRA_UC									= "cant_cpra_uc";

	public static final String	CANT_CPRA_US									= "cant_cpra_us";

	public static final String	OID_MONEDA										= "oid_moneda";

	public static final String	FUENTE_PRECIO_SUG							= "fuente_precio_sug";

	public static final String	PRECIO_SUGERIDO								= "precio_sugerido";

	public static final String	ANULADO												= "anulado";

	public static final String	PRECIO_NETO_BONIF							= "precio_neto_bonif";

	public static final String	PRECIO												= "precio";

	public static final String	COMENTARIO										= "comentario";

	public static final String	TOTAL													= "total";

	public static final String	DTO_1													= "dto_1";

	public static final String	DTO_2													= "dto_2";

	public static final String	DTO_3													= "dto_3";

	public static final String	EN_CASCADA										= "en_cascada";
	
	public static final String  FEC_REQUERIDA									= "fec_requerida";
	
	public static final String	CANT_RECEP_UC									= "cant_recep_uc";
	
	public static final String 	CANT_RECEP_US									= "cant_recep_us";
	
	public static final String 	PEND_RECEP										= "pend_recep";
	
	public static final String  OID_PED_DET 									= "oid_ped_det";
	
	public static final String OID_PED_CAB										= "oid_ped_cab"; 
	
	public static final String OID_REQUI_DET										= "oid_requi_det";
	
	public static final String CANT_DEVUELTA_UC = "cant_devuelta_uc";
	
	public static final String CANT_DEVUELTA_US = "cant_devuelta_us";
	
	public static final String PORC_RECAR = "porc_recar";
	
	public static final String TIPO_RECAR_DTO = "tipo_recar_dto";
	
	public static final String PORC_DTO_RECAR = "porc_dto_recar";
	
	public static final String CANT_FACT_UC = "cant_fact_uc";
	
	public static final String CANT_FACT_US = "cant_fact_us";
	
	public static final String		PEND_FACT = "pend_fact";
	
	public static final String		IMPORTE_CUOTA = "importe_cuota";
	
	public static final String		SALDO_CUOTA = "saldo_cuota";
	
	public static final String		AUTORIZADO = "autorizado";
	
	public static final String		PAGAR = "pagar";

	public static final int			SELECT_BY_ORDEN_COMPRA				= 100;

	public static final int			SELECT_BY_PROVEEDOR_PRODUCTO	= 101;

	public static final int			SELECT_BY_OC_LUGAR_ENT				= 102;
	
	public static final int			SELECT_BY_OC_DET_PEND_REC     = 103;
	
	public static final int 		SELECT_BY_CONDICIONES 				= 104;
	
	public static final int 		SELECT_BY_PROV_PROD_GRAL_MAS_CERC_A_FEC = 105;
	
	

	public DBOrdenDeCompraDet() {
	}

	protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_OC_DET = 1;
		final int OID_CCO_CPRA = 2;
		final int NRO_ITEM = 3;
		final int OID_UM_CPRA = 4;
		final int OID_PRODUCTO = 5;
		final int DESC_ADIC_SKU = 6;
		final int OID_UM_STOCK = 7;
		final int CANT_CPRA_UC = 8;
		final int CANT_CPRA_US = 9;
		final int OID_MONEDA = 10;
		final int FUENTE_PRECIO_SUG = 11;
		final int PRECIO_SUGERIDO = 12;
		final int ANULADO = 13;
		final int PRECIO_NETO_BONIF = 14;
		final int PRECIO = 15;
		final int COMENTARIO = 16;
		final int TOTAL = 17;
		final int DTO_1 = 18;
		final int DTO_2 = 19;
		final int DTO_3 = 20;
		final int EN_CASCADA = 21;
		final int PORC_RECAR = 22;
		final int TIPO_RECAR_DTO = 23;
		final int PORC_DTO_RECAR = 24; 
		final int FEC_REQUERIDA = 25;
		final int CANT_RECEP_US = 26;
		final int CANT_RECEP_UC = 27;
		final int PEND_RECEP = 28;
		final int OID_PED_DET = 29;
		final int OID_PED_CAB = 30;
		final int CANT_FACT_UC = 31;
		final int CANT_FACT_US = 32;
		final int PEND_FACT = 33;
		final int OID_REQUI_DET = 34;
		final int CANT_DEVUELTA_UC = 35;
		final int CANT_DEVUELTA_US = 36;

		OrdenDeCompraDet pers = (OrdenDeCompraDet) objetoPersistente;

		StringBuffer sqlInsert = new StringBuffer();
		sqlInsert.append(" insert into cpOCDet " + " ( " + "OID_OC_DET," + "OID_CCO_CPRA," + "NRO_ITEM," + "OID_UM_CPRA,"
				+ "OID_PRODUCTO," + "DESC_ADIC_SKU," + "OID_UM_STOCK," + "CANT_CPRA_UC," + "CANT_CPRA_US," + "OID_MONEDA,"
				+ "FUENTE_PRECIO_SUG," + "PRECIO_SUGERIDO," + "ANULADO," + "PRECIO_NETO_BONIF," + "PRECIO," + "COMENTARIO,"
				+ "TOTAL,DTO_1,DTO_2,DTO_3,EN_CASCADA, PORC_RECAR , TIPO_RECAR_DTO , PORC_DTO_RECAR , FEC_REQUERIDA , CANT_RECEP_US , CANT_RECEP_UC , PEND_RECEP , OID_PED_DET , OID_PED_CAB , CANT_FACT_UC , CANT_FACT_US , PEND_FACT, OID_REQUI_DET,CANT_DEVUELTA_UC,CANT_DEVUELTA_US"+
				")" + " values " + "(" + "?," + "?," + "?,"+ "?,"+ "?," + "?," + "?," + "?," + "?," + "?,"
				+ "?," +"?," + "?,"+ "?," + "?," + "?," + "?," + "?," + "?," + "?,"+ "?," + "?," + "?," + "?," + "?,"+ "?," + "?,"+ "?,"+ "?," + "?,"+ "?,"+ "?,"+ "?,"+"?,"+ "?," + "?) ");

		PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
		qInsert.setInt(OID_OC_DET, pers.getOID());
		qInsert.setInt(OID_CCO_CPRA, pers.getOrden_de_compra().getOID());
		qInsert.setInt(NRO_ITEM, pers.getNro_item().intValue());
		qInsert.setInt(OID_UM_CPRA, pers.getUnidad_compra().getOID());
		qInsert.setInt(OID_PRODUCTO, pers.getProducto().getOID());
		if (pers.getDesc_adic_sku() != null)
			qInsert.setString(DESC_ADIC_SKU, pers.getDesc_adic_sku());
		else
			qInsert.setNull(DESC_ADIC_SKU, Types.VARCHAR);
		qInsert.setInt(OID_UM_STOCK, pers.getUm_stock().getOID());
		qInsert.setDouble(CANT_CPRA_UC, pers.getCant_comprada_uc().doubleValue());
		qInsert.setDouble(CANT_CPRA_US, pers.getCant_comprada_us().doubleValue());
		if (pers.getMoneda()!=null)
			qInsert.setInt(OID_MONEDA, pers.getMoneda().getOID());
		else
			qInsert.setNull(OID_MONEDA,Types.INTEGER);
		if (pers.getFuente_precio_sug() != null)
			qInsert.setString(FUENTE_PRECIO_SUG, pers.getFuente_precio_sug());
		else
			qInsert.setNull(FUENTE_PRECIO_SUG, Types.VARCHAR);
		if (pers.getPrecio_sugerido() != null)
			qInsert.setDouble(PRECIO_SUGERIDO, pers.getPrecio_sugerido().doubleValue());
		else
			qInsert.setDouble(PRECIO_SUGERIDO, 0);
		qInsert.setBoolean(ANULADO, pers.isAnulado().booleanValue());
		qInsert.setDouble(PRECIO_NETO_BONIF, pers.getPrecio_neto_bonif().doubleValue());
		qInsert.setDouble(PRECIO, pers.getPrecio().doubleValue());
		qInsert.setString(COMENTARIO, pers.getComentario());
		qInsert.setDouble(TOTAL, pers.getTotal().doubleValue());
		if (pers.getDto1() != null)
			qInsert.setDouble(DTO_1, pers.getDto1().doubleValue());
		else
			qInsert.setDouble(DTO_1, 0);
		if (pers.getDto2() != null)
			qInsert.setDouble(DTO_2, pers.getDto2().doubleValue());
		else
			qInsert.setDouble(DTO_2, 0);
		if (pers.getDto3() != null)
			qInsert.setDouble(DTO_3, pers.getDto3().doubleValue());
		else
			qInsert.setDouble(DTO_3, 0);
		qInsert.setBoolean(EN_CASCADA, pers.isEnCascada().booleanValue());
		if (pers.getPorcRecar()!=null)
			qInsert.setDouble(PORC_RECAR,pers.getPorcRecar().doubleValue());
		else
			qInsert.setNull(PORC_RECAR,Types.DOUBLE);
		if (pers.getTipoRecarDto()!=null)
			qInsert.setString(TIPO_RECAR_DTO,pers.getTipoRecarDto());
		else
			qInsert.setNull(TIPO_RECAR_DTO,Types.VARCHAR);
		if (pers.getPorcDtoRecar()!=null)
			qInsert.setDouble(PORC_DTO_RECAR,pers.getPorcDtoRecar().doubleValue());
		else
			qInsert.setNull(PORC_DTO_RECAR,Types.DOUBLE);
		if (pers.getFecRequerida()!=null)
			qInsert.setDate(FEC_REQUERIDA, new java.sql.Date(pers.getFecRequerida().getTime()));
		else
			qInsert.setNull(FEC_REQUERIDA, Types.DATE);
		
		if (pers.getCantRecepUS()!=null)
			qInsert.setDouble(CANT_RECEP_US, pers.getCantRecepUS().doubleValue());
		else
			qInsert.setDouble(CANT_RECEP_US, 0);
		
		if (pers.getCantRecepUC()!=null)
			qInsert.setDouble(CANT_RECEP_UC, pers.getCantRecepUC().doubleValue());
		else
			qInsert.setDouble(CANT_RECEP_UC, 0);
		
		if (pers.isPendienteRecepcion()!=null)
			qInsert.setBoolean(PEND_RECEP, pers.isPendienteRecepcion().booleanValue());
		else
			qInsert.setBoolean(PEND_RECEP, true);
		
		if (pers.getPedidoDet()!=null)
			qInsert.setInt(OID_PED_DET, pers.getPedidoDet().getOID());
		else
			qInsert.setNull(OID_PED_DET, java.sql.Types.INTEGER);

		if ((pers.getPedidoDet()!=null) && (pers.getPedidoDet().getPedido()!=null))
			qInsert.setInt(OID_PED_CAB, pers.getPedidoDet().getPedido().getOID());
		else
			if (pers.getPedidoCab()!=null)
				qInsert.setInt(OID_PED_CAB, pers.getPedidoCab().getOID());
			else
				qInsert.setNull(OID_PED_CAB, java.sql.Types.INTEGER);
		
		if (pers.getCantFactUC()!=null)
			qInsert.setDouble(CANT_FACT_UC,pers.getCantFactUC().doubleValue());
		else
			qInsert.setNull(CANT_FACT_UC,java.sql.Types.DOUBLE);
		
		if (pers.getCantFactUS()!=null)
			qInsert.setDouble(CANT_FACT_US,pers.getCantFactUS().doubleValue());
		else
			qInsert.setNull(CANT_FACT_US,java.sql.Types.DOUBLE); 
		
		if (pers.isPendFact()!=null)
			qInsert.setBoolean(PEND_FACT, pers.isPendFact().booleanValue());
		else
			qInsert.setNull(PEND_FACT, java.sql.Types.BOOLEAN );
		
		if (pers.getRequisicionDet()!=null)
			qInsert.setInt(OID_REQUI_DET, pers.getRequisicionDet().getOID());
		else
			qInsert.setNull(OID_REQUI_DET, java.sql.Types.INTEGER );
		
		if (pers.getCantDevueltaUC()!=null)
			qInsert.setDouble(CANT_DEVUELTA_UC, pers.getCantDevueltaUC().doubleValue());
		else
			qInsert.setDouble(CANT_DEVUELTA_UC, 0 );
		
		if (pers.getCantDevueltaUS()!=null)
			qInsert.setDouble(CANT_DEVUELTA_US, pers.getCantDevueltaUS().doubleValue());
		else
			qInsert.setDouble(CANT_DEVUELTA_US, 0 );
		
		
		qInsert.executeUpdate();
		qInsert.close();
	}

	protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_CCO_CPRA = 1;
		final int NRO_ITEM = 2;
		final int OID_UM_CPRA = 3;
		final int OID_PRODUCTO = 4;
		final int DESC_ADIC_SKU = 5;
		final int OID_UM_STOCK = 6;
		final int CANT_CPRA_UC = 7;
		final int CANT_CPRA_US = 8;
		final int OID_MONEDA = 9;
		final int FUENTE_PRECIO_SUG = 10;
		final int PRECIO_SUGERIDO = 11;
		final int ANULADO = 12;
		final int PRECIO_NETO_BONIF = 13;
		final int PRECIO = 14;
		final int COMENTARIO = 15;
		final int TOTAL = 16;
		final int DTO_1 = 17;
		final int DTO_2 = 18;
		final int DTO_3 = 19;
		final int EN_CASCADA = 20;
		final int PORC_RECAR = 21;
		final int TIPO_RECAR_DTO = 22;
		final int PORC_DTO_RECAR = 23;
		final int FEC_REQUERIDA = 24;
		final int CANT_RECEP_UC = 25;
		final int CANT_RECEP_US = 26;
		final int PEND_RECEP = 27;
		final int OID_PED_DET = 28;
		final int OID_PED_CAB = 29;
		final int CANT_FACT_UC = 30;
		final int CANT_FACT_US = 31;
		final int PEND_FACT = 32;
		final int OID_REQUI_DET = 33;
		final int CANT_DEVUELTA_UC = 34;
		final int CANT_DEVUELTA_US = 35;
		final int OID_OC_DET = 36;
		
		
		OrdenDeCompraDet pers = (OrdenDeCompraDet) objetoPersistente;

		
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append(" update cpOCDet set ");
		sqlUpdate.append(" oid_cco_cpra=?, ");
		sqlUpdate.append(" nro_item=?, ");
		sqlUpdate.append(" oid_um_cpra=?, ");
		sqlUpdate.append(" oid_producto=?,");
		sqlUpdate.append(" desc_adic_sku=?,");
		sqlUpdate.append(" oid_um_stock=?, ");
		sqlUpdate.append(" cant_cpra_uc=?,");
		sqlUpdate.append(" cant_cpra_us=?,");
		sqlUpdate.append(" oid_moneda=?, ");
		sqlUpdate.append(" fuente_precio_sug=?,");
		sqlUpdate.append(" precio_sugerido=?,");
		sqlUpdate.append(" anulado=?,");
		sqlUpdate.append(" precio_neto_bonif=?,");
		sqlUpdate.append(" precio=?,"); 
		sqlUpdate.append(" comentario=?,");
		sqlUpdate.append(" total=?,");
		sqlUpdate.append(" dto_1=?,");
		sqlUpdate.append(" dto_2=?,");
		sqlUpdate.append(" dto_3=?,");
		sqlUpdate.append(" en_cascada=?,");
		sqlUpdate.append(" porc_recar=?,");
		sqlUpdate.append(" tipo_recar_dto = ?,");
		sqlUpdate.append(" porc_dto_recar=?,");
		sqlUpdate.append(" fec_requerida = ?,");
		sqlUpdate.append(" cant_recep_uc = ?,");
		sqlUpdate.append(" cant_recep_us = ?,");
		sqlUpdate.append(" pend_recep = ?,");
		sqlUpdate.append(" oid_ped_det=?,");
		sqlUpdate.append(" oid_ped_cab = ?,");
		sqlUpdate.append(" cant_fact_uc = ?,");
		sqlUpdate.append(" cant_fact_us = ?, ");
		sqlUpdate.append(" pend_fact = ?, ");
		sqlUpdate.append(" oid_requi_det = ?, ");
		sqlUpdate.append(" cant_devuelta_uc = ?, ");
		sqlUpdate.append(" cant_devuelta_us = ? ");
		sqlUpdate.append(" where oid_oc_det=? ");

		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_OC_DET, pers.getOID());
		qUpdate.setInt(OID_CCO_CPRA, pers.getOrden_de_compra().getOID());
		qUpdate.setInt(NRO_ITEM, pers.getNro_item().intValue());
		qUpdate.setInt(OID_UM_CPRA, pers.getUnidad_compra().getOID());
		qUpdate.setInt(OID_PRODUCTO, pers.getProducto().getOID());
		if (pers.getDesc_adic_sku() != null)
			qUpdate.setString(DESC_ADIC_SKU, pers.getDesc_adic_sku());
		else
			qUpdate.setNull(DESC_ADIC_SKU, Types.VARCHAR);
		qUpdate.setInt(OID_UM_STOCK, pers.getUm_stock().getOID());
		qUpdate.setDouble(CANT_CPRA_UC, pers.getCant_comprada_uc().doubleValue());
		qUpdate.setDouble(CANT_CPRA_US, pers.getCant_comprada_us().doubleValue());
		if (pers.getMoneda()!=null)
			qUpdate.setInt(OID_MONEDA, pers.getMoneda().getOID());
		else
			qUpdate.setNull(OID_MONEDA, Types.INTEGER);
		if (pers.getFuente_precio_sug() != null)
			qUpdate.setString(FUENTE_PRECIO_SUG, pers.getFuente_precio_sug());
		else
			qUpdate.setNull(FUENTE_PRECIO_SUG, Types.VARCHAR);
		if (pers.getPrecio_sugerido() != null)
			qUpdate.setDouble(PRECIO_SUGERIDO, pers.getPrecio_sugerido().doubleValue());
		else
			qUpdate.setDouble(PRECIO_SUGERIDO, 0);
		qUpdate.setBoolean(ANULADO, pers.isAnulado().booleanValue());
		qUpdate.setDouble(PRECIO_NETO_BONIF, pers.getPrecio_neto_bonif().doubleValue());
		qUpdate.setDouble(PRECIO, pers.getPrecio().doubleValue());
		qUpdate.setString(COMENTARIO, pers.getComentario());
		qUpdate.setDouble(TOTAL, pers.getTotal().doubleValue());
		if (pers.getDto1() != null)
			qUpdate.setDouble(DTO_1, pers.getDto1().doubleValue());
		else
			qUpdate.setDouble(DTO_1, 0);
		if (pers.getDto2() != null)
			qUpdate.setDouble(DTO_2, pers.getDto2().doubleValue());
		else
			qUpdate.setDouble(DTO_2, 0);
		if (pers.getDto3() != null)
			qUpdate.setDouble(DTO_3, pers.getDto3().doubleValue());
		else
			qUpdate.setDouble(DTO_3, 0);
		qUpdate.setBoolean(EN_CASCADA, pers.isEnCascada().booleanValue());
		if (pers.getPorcRecar()!=null)
			qUpdate.setDouble(PORC_RECAR,pers.getPorcRecar().doubleValue());
		else
			qUpdate.setNull(PORC_RECAR,Types.DOUBLE);
		if (pers.getTipoRecarDto()!=null)
			qUpdate.setString(TIPO_RECAR_DTO,pers.getTipoRecarDto());
		else
			qUpdate.setNull(TIPO_RECAR_DTO,Types.VARCHAR);
		if (pers.getPorcDtoRecar()!=null)
			qUpdate.setDouble(PORC_DTO_RECAR,pers.getPorcDtoRecar().doubleValue());
		else
			qUpdate.setNull(PORC_DTO_RECAR,Types.DOUBLE);
		if (pers.getFecRequerida()!=null)
			qUpdate.setDate(FEC_REQUERIDA, new java.sql.Date(pers.getFecRequerida().getTime()));
		else
			qUpdate.setNull(FEC_REQUERIDA, Types.DATE);

		if (pers.getCantRecepUS()!=null)
			qUpdate.setDouble(CANT_RECEP_US, pers.getCantRecepUS().doubleValue());
		else
			qUpdate.setDouble(CANT_RECEP_US, 0);
		
		if (pers.getCantRecepUC()!=null)
			qUpdate.setDouble(CANT_RECEP_UC, pers.getCantRecepUC().doubleValue());
		else
			qUpdate.setDouble(CANT_RECEP_UC, 0);
		
		if (pers.isPendienteRecepcion()!=null)
			qUpdate.setBoolean(PEND_RECEP, pers.isPendienteRecepcion().booleanValue());
		else
			qUpdate.setBoolean(PEND_RECEP, true);
		
		if (pers.getPedidoDet()!=null)
			qUpdate.setInt(OID_PED_DET, pers.getPedidoDet().getOID());
		else
			qUpdate.setNull(OID_PED_DET, java.sql.Types.INTEGER);

		if (pers.getPedidoDet()!=null)
			qUpdate.setInt(OID_PED_CAB, pers.getPedidoDet().getPedido().getOID());
		else
			if (pers.getPedidoCab()!=null)
				qUpdate.setInt(OID_PED_CAB, pers.getPedidoCab().getOID());
			else
				qUpdate.setNull(OID_PED_CAB, java.sql.Types.INTEGER);
		
		if (pers.getCantFactUS()!=null)
			qUpdate.setDouble(CANT_FACT_US,pers.getCantFactUS().doubleValue());
		else
			qUpdate.setNull(CANT_FACT_US,java.sql.Types.DOUBLE);
		
		if (pers.getCantFactUC()!=null)
			qUpdate.setDouble(CANT_FACT_UC,pers.getCantFactUC().doubleValue());
		else
			qUpdate.setNull(CANT_FACT_UC,java.sql.Types.DOUBLE); 
		
		if (pers.isPendFact()!=null)
			qUpdate.setBoolean(PEND_FACT, pers.isPendFact().booleanValue());
		else
			qUpdate.setNull(PEND_FACT, java.sql.Types.BOOLEAN );
		
		if (pers.getRequisicionDet()!=null)
			qUpdate.setInt(OID_REQUI_DET, pers.getRequisicionDet().getOID());
		else
			qUpdate.setNull(OID_REQUI_DET, java.sql.Types.INTEGER );
		
		if (pers.getCantDevueltaUC()!=null)
			qUpdate.setDouble(CANT_DEVUELTA_UC, pers.getCantDevueltaUC().doubleValue());
		else
			qUpdate.setDouble(CANT_DEVUELTA_UC, 0 );
		
		if (pers.getCantDevueltaUS()!=null)
			qUpdate.setDouble(CANT_DEVUELTA_US, pers.getCantDevueltaUS().doubleValue());
		else
			qUpdate.setDouble(CANT_DEVUELTA_US, 0 );
		
		
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		// Borrar Detalle
		final int OID_OC_DET = 1;
		OrdenDeCompraDet pers = (OrdenDeCompraDet) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update cpOCDet set anulado=1 where " + " oid_oc_det=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_OC_DET, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();

		// Borrar Entregas
		StringBuffer sqlUpdateEnt = new StringBuffer();
		sqlUpdateEnt.append("delete from cpOCDetEnt  where " + " oid_oc_det=? ");
		PreparedStatement qUpdateEnt = getSesion().getConexionBD().prepareStatement(sqlUpdateEnt.toString());
		qUpdateEnt.setInt(OID_OC_DET, pers.getOID());
		qUpdateEnt.executeUpdate();
		qUpdateEnt.close();

	}

	protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_OC_DET = 1;
		OrdenDeCompraDet pers = (OrdenDeCompraDet) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update cpOCDet " + " set activo=1 " + " where " + " oid_oc_det=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_OC_DET, pers.getOID());
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
		case SELECT_BY_ORDEN_COMPRA: {
			ps = this.selectByOrdenCompra(aCondiciones);
			break;
		}
		case SELECT_BY_PROVEEDOR_PRODUCTO: {
			ps = this.selectByProveedorProducto(aCondiciones);
			break;
		}
		case SELECT_BY_OC_LUGAR_ENT: {
			ps = this.selectByOCLugarEnt(aCondiciones);
			break;
		}
		case SELECT_BY_OC_DET_PEND_REC: {
			ps = this.selectByOCDetPendRecep(aCondiciones);
			break;
		}
		case SELECT_BY_CONDICIONES: {
			ps = this.selectByCondiciones(aCondiciones);
			break;
		}
		case SELECT_BY_PROV_PROD_GRAL_MAS_CERC_A_FEC: {
			ps = this.selectByProveedorProGralmasCercAFecha(aCondiciones);
			break;
		}
		}
		return ps;
	}

	private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

		final int OID_OC_DET = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cpOCDet ");
		textSQL.append(" WHERE oid_oc_det = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		int oid = ((Integer) aCondiciones).intValue();
		querySelect.setInt(OID_OC_DET, oid);
		return querySelect;
	}
	
	
	private PreparedStatement selectByProveedorProGralmasCercAFecha(Object aCondiciones) throws BaseException, SQLException {

		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		Proveedor proveedor = (Proveedor) condiciones.get(Proveedor.NICKNAME);
		ValorClasificadorEntidad valorClasifEnt = (ValorClasificadorEntidad) condiciones.get(ValorClasificadorEntidad.NICKNAME);
		java.util.Date fecha = (java.util.Date) condiciones.get("FECHA");
		
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT ");
		textSQL.append("  a.* ");
		textSQL.append("FROM  ");
		textSQL.append("  cpOCDet a, geComproCab b , stProducto c  ");
		
		if (proveedor!=null)
			textSQL.append("  ,CPOCCAB d ");
			
		
		textSQL.append("WHERE");
		textSQL.append("  a.oid_cco_cpra = b.oid_cco  ");
		textSQL.append("  and a.anulado  = 0 and b.activo = 1 and c.oid_producto = a.oid_producto ");
		textSQL.append("  and b.emision <= ? ");
		
		ClasificadorEntidad clasif = Producto.getClasifProductoGeneral(this.getSesion());
		textSQL.append("  and c."+clasif.getCampoFisico()+" = "+valorClasifEnt.getOIDInteger());
		
		if (proveedor!=null) {
			textSQL.append("  and a.oid_cco_cpra = d.oid_oc ");
			textSQL.append("  and d.oid_proveedor = "+proveedor.getOIDInteger());
		}
		
		textSQL.append("  and b.emision = ( ");
		
		
		textSQL.append("SELECT ");
		textSQL.append("  max(b1.emision) ");
		textSQL.append("FROM  ");
		textSQL.append("  cpOCDet a1, geComproCab b1 , stProducto c1  ");
		
		if (proveedor!=null)
			textSQL.append("  ,CPOCCAB d1 ");
			
		
		textSQL.append("WHERE");
		textSQL.append("  a1.oid_cco_cpra = b1.oid_cco  ");
		textSQL.append("  and a1.anulado  = 0 and b1.activo = 1 and c1.oid_producto = a1.oid_producto ");
		textSQL.append("  and b1.emision <= ? ");
		
		textSQL.append("  and c1."+clasif.getCampoFisico()+" = "+valorClasifEnt.getOIDInteger());
		
		if (proveedor!=null) {
			textSQL.append("  and a1.oid_cco_cpra = d1.oid_oc ");
			textSQL.append("  and d1.oid_proveedor = "+proveedor.getOIDInteger());
		}
		
		textSQL.append("  ) ");
		textSQL.append("  order by a.oid_oc_det asc "); // Tomo el ultimo ingresado
		
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		querySelect.setDate(1,new java.sql.Date(fecha.getTime()));
		querySelect.setDate(2,new java.sql.Date(fecha.getTime()));
		
		return querySelect;
		
	}
	
	public static void actuCantDevueltas(ISesion aSesion, OrdenDeCompraDet ocDet, Double cantDevUS , Double cantDevUC) throws BaseException {

	try {
		
		if (cantDevUS == null)
			cantDevUS = new Double(0);
		
		if (cantDevUC == null)
			cantDevUC = new Double(0);
		
		StringBuffer sqlActuCantDev = new StringBuffer(
				" update cpOCDet set cant_devuelta_uc = ? , cant_devuelta_us = ?   where oid_oc_det = "
				+ ocDet.getOIDInteger().toString());
		PreparedStatement querySelect = aSesion.getConexionBD().prepareStatement(sqlActuCantDev.toString());
		querySelect.setDouble(1, cantDevUC.doubleValue());
		querySelect.setDouble(2, cantDevUS.doubleValue());
		querySelect.executeUpdate();
		querySelect.close();

	
	} catch (Exception e) {
		throw new BaseException(null, e.getMessage());
	}
	}
	
	public static void actuMarcarCompPendRecep(ISesion aSesion, OrdenDeCompraDet ocDet, boolean pendRecep) throws BaseException {

		try {
			
			StringBuffer sqlActuCantDev = new StringBuffer(
					" update cpOCDet set pend_recep = ? where oid_oc_det = "
					+ ocDet.getOIDInteger().toString());
			PreparedStatement querySelect = aSesion.getConexionBD().prepareStatement(sqlActuCantDev.toString());
			querySelect.setBoolean(1, pendRecep);
			querySelect.executeUpdate();
			querySelect.close();

		
		} catch (Exception e) {
			throw new BaseException(null, e.getMessage());
		}
		}
	
	
	public static void actuCantRecepcionadas(ISesion aSesion, OrdenDeCompraDet ocDet , Double cantRecUS , Double cantRecUC)
	throws BaseException {

	try {
		
		if (cantRecUS == null)
			cantRecUS = new Double(0);
		
		if (cantRecUC == null)
			cantRecUC = new Double(0);
		
		StringBuffer sqlActuCantDev = new StringBuffer(
				" update cpOCDet set cant_recep_uc = ? , cant_recep_us = ?   where oid_oc_det =  "
				+ ocDet.getOIDInteger().toString());
		PreparedStatement querySelect = aSesion.getConexionBD().prepareStatement(sqlActuCantDev.toString());
		querySelect.setDouble(1, cantRecUC.doubleValue());
		querySelect.setDouble(2, cantRecUS.doubleValue());
		querySelect.executeUpdate();
		querySelect.close();

	
	} catch (Exception e) {
		throw new BaseException(null, e.getMessage());
	}
	}
	
	
	private PreparedStatement selectByOCDetPendRecep(Object aCondiciones) throws BaseException, SQLException {

		HashTableDatos condiciones = (HashTableDatos) aCondiciones;

		OrdenDeCompraCab oc = null;
		PedidoDet pedidoDet = null;
		Producto producto = null;
		
		if (condiciones.containsKey(OrdenDeCompraCab.NICKNAME))
			oc = (OrdenDeCompraCab) condiciones.get(OrdenDeCompraCab.NICKNAME);
		
		if (condiciones.containsKey(PedidoDet.NICKNAME))
			pedidoDet = (PedidoDet) condiciones.get(PedidoDet.NICKNAME);
		
		if (condiciones.containsKey(Producto.NICKNAME))
			producto = (Producto) condiciones.get(Producto.NICKNAME);		
		
		
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT a.* FROM  cpOCDet a, geComproCab b where a.oid_cco_cpra=b.oid_cco and ");
		textSQL.append("a.pend_recep = 1 and a.anulado = 0 and b.activo = 1 ");
		
		if (oc!=null)
			textSQL.append("and a.oid_cco_cpra = "+oc.getOIDInteger().toString()); 
		
		if (pedidoDet!=null)
			textSQL.append("and a.oid_ped_det = "+pedidoDet.getOIDInteger().toString()); 
		
		if (producto!=null)
			textSQL.append("and a.oid_producto = "+producto.getOIDInteger().toString());		
		
		
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}
	
	private PreparedStatement selectByCondiciones(Object aCondiciones) throws BaseException, SQLException {

		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		OrdenDeCompraCab oc = (OrdenDeCompraCab) condiciones.get(OrdenDeCompraCab.NICKNAME);
		
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT a.* FROM  cpOCDet a, geComproCab b , cpOCCab c where a.oid_cco_cpra=b.oid_cco ");
		textSQL.append(" and c.oid_oc = a.oid_cco_cpra ");
		
		if (condiciones.containsKey("NRO_DESDE"))
			textSQL.append(" and b.nro_ext>="+((Integer)condiciones.get("NRO_DESDE")).toString());
		
		if (condiciones.containsKey("NRO_HASTA"))
			textSQL.append(" and b.nro_ext<="+((Integer)condiciones.get("NRO_HASTA")).toString());		
		
		if (condiciones.containsKey(Talonario.NICKNAME)) {
			Talonario talonario = (Talonario) condiciones.get(Talonario.NICKNAME);
			textSQL.append(" and b.oid_talonario="+talonario.getOIDInteger().toString());
		}

		if (condiciones.containsKey(Producto.NICKNAME)) {
			Producto producto = (Producto) condiciones.get(Producto.NICKNAME);
			textSQL.append(" and a.oid_producto="+producto.getOIDInteger().toString());
		}		
		
		if (condiciones.containsKey(Proveedor.NICKNAME)) {
			Proveedor proveedor = (Proveedor) condiciones.get(Proveedor.NICKNAME);
			textSQL.append(" and c.oid_proveedor="+proveedor.getOIDInteger().toString());
		}
		
		if (condiciones.containsKey(OrdenDeCompraCab.NICKNAME)) {
			OrdenDeCompraCab ordenDeCompra = (OrdenDeCompraCab) condiciones.get(OrdenDeCompraCab.NICKNAME);
			textSQL.append(" and c.oid_oc ="+ ordenDeCompra.getOIDInteger().toString());
		}			
		
		if (condiciones.containsKey("FILTRO_OC")) {
			if ((condiciones.getString("FILTRO_OC").equals(OrdenDeCompraCab.OC_PEND_EXT)))
				textSQL.append(" and a.pend_recep = 1");
		}
		
		if (condiciones.containsKey("ESTADO_AUTORIZACION")) {
			Integer estadoAutoriz = (Integer)condiciones.get("ESTADO_AUTORIZACION"); 
			if (estadoAutoriz.intValue()!=-1) // Todos
				textSQL.append(" and c.estado_autoriz ="+estadoAutoriz.toString());
		}
		
		if (condiciones.containsKey("FEC_EMI_DESDE")) 
			textSQL.append(" and b.emision >=?");
		
		if (condiciones.containsKey("FEC_EMI_HASTA")) 
			textSQL.append(" and b.emision <=?");
		
		PreparedStatement querySelect = getSesion().getConexionBD()
		.prepareStatement(textSQL.toString());

		int nroParam = 0;
		
		if (condiciones.containsKey("FEC_EMI_DESDE")) {
			++nroParam;
			java.util.Date fecha = (java.util.Date) condiciones.get("FEC_EMI_DESDE");
			querySelect.setDate(nroParam,new java.sql.Date(fecha.getTime()));
		}
		
		if (condiciones.containsKey("FEC_EMI_HASTA")) {
			++nroParam;
			java.util.Date fecha = (java.util.Date) condiciones.get("FEC_EMI_HASTA");
			querySelect.setDate(nroParam,new java.sql.Date(fecha.getTime()));			
		}
		
		
		return querySelect;
		
	}
	

	
	private PreparedStatement selectByProveedorProducto(Object aCondiciones) throws BaseException, SQLException {
		
		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		
		StringBuffer textSQL = new StringBuffer();
		textSQL.append(" select ");
		textSQL.append(" a.* ");
		textSQL.append(" from ");
		textSQL.append(" cpOCDet a, ");
		textSQL.append(" cpOCCab b , ");
		textSQL.append(" geComproCab c ");
		textSQL.append(" where ");
		textSQL.append(" a.oid_cco_cpra = b.oid_oc and ");
		textSQL.append(" c.oid_cco = b.oid_oc and ");
		textSQL.append(" a.oid_producto = ? ");
		
		if (condiciones.containsKey(Proveedor.NICKNAME))
			textSQL.append(" and b.oid_proveedor = ? ");
		
		textSQL.append(" and a.anulado = 0 and c.activo = 1 order by c.emision desc,a.oid_oc_det desc ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		
		Producto producto = (Producto) condiciones.get(Producto.NICKNAME);
		Proveedor proveedor = (Proveedor) condiciones.get(Proveedor.NICKNAME);
		
		querySelect.setInt(1, producto.getOID());
		
		if (condiciones.containsKey(Proveedor.NICKNAME))
			querySelect.setInt(2, proveedor.getOID());
		return querySelect;
	}

	private PreparedStatement selectByOrdenCompra(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cpOCDet ");
		textSQL.append(" WHERE  oid_cco_cpra = ? and anulado=0");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		OrdenDeCompraCab ordenDeCompra = (OrdenDeCompraCab) aCondiciones;
		querySelect.setInt(1, ordenDeCompra.getOID());
		return querySelect;
	}

	private PreparedStatement selectByOCLugarEnt(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cpOCDet ");
		textSQL.append(" WHERE  oid_cco_cpra = ? and oid_oc_det in (select oid_oc_det from cpOCDetEnt where oid_lugar_ent = ?) ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		OrdenDeCompraCab oc = (OrdenDeCompraCab) condiciones.get(OrdenDeCompraCab.NICKNAME);
		LugarEntrega lugarEntrega = (LugarEntrega) condiciones.get(LugarEntrega.NICKNAME);
		querySelect.setInt(1, oc.getOID());
		querySelect.setInt(2, lugarEntrega.getOID());
		return querySelect;
	}

	private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

		final int CODIGO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cpOCDet ");
		textSQL.append(" WHERE  = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		String codigo = (String) aCondiciones;
		querySelect.setString(CODIGO, codigo);
		return querySelect;
	}

	private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();

		textSQL.append("SELECT oid_oc_det oid, codigo,  descripcion ,activo ");
		textSQL.append(" from cpOCDet");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}

	public static List getDetallesOC(OrdenDeCompraCab ordenDeCompraCab, ISesion aSesion) throws BaseException {
		return (List) ObjetoLogico.getObjects(OrdenDeCompraDet.NICKNAME, DBOrdenDeCompraDet.SELECT_BY_ORDEN_COMPRA,
				ordenDeCompraCab, new ListObserver(), aSesion);
	}

	public static List getDetallesByProductoProveedor(Producto producto, Proveedor proveedor, ISesion aSesion)
			throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put(Producto.NICKNAME, producto);
		if (proveedor!=null)
			condiciones.put(Proveedor.NICKNAME, proveedor);
		return (List) ObjetoLogico.getObjects(OrdenDeCompraDet.NICKNAME, DBOrdenDeCompraDet.SELECT_BY_PROVEEDOR_PRODUCTO,
				condiciones, new ListObserver(), aSesion);
	}
	
	public static List getDetallesOC(OrdenDeCompraCab ordenDeCompraCab, 
																	 LugarEntrega lugarEntrega,
																	 ISesion aSesion) throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put(OrdenDeCompraCab.NICKNAME,ordenDeCompraCab);
		condiciones.put(LugarEntrega.NICKNAME,lugarEntrega);
		return (List) ObjetoLogico.getObjects(OrdenDeCompraDet.NICKNAME, DBOrdenDeCompraDet.SELECT_BY_OC_LUGAR_ENT,
				condiciones, new ListObserver(), aSesion);
	}
	
	public static List getDetallesOCPendRecep(OrdenDeCompraCab oc,
			 																			ISesion aSesion) throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put(OrdenDeCompraCab.NICKNAME,oc);
		return (List) ObjetoLogico.getObjects(
				OrdenDeCompraDet.NICKNAME, 
				DBOrdenDeCompraDet.SELECT_BY_OC_DET_PEND_REC,
				condiciones, new ListObserver(), aSesion);
	}
	
	public static List getDetallesOCPendRecep(PedidoDet pedidoDet,
				ISesion aSesion) throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put(PedidoDet.NICKNAME,pedidoDet);
		return (List) ObjetoLogico.getObjects(
				OrdenDeCompraDet.NICKNAME, 
				DBOrdenDeCompraDet.SELECT_BY_OC_DET_PEND_REC,
				condiciones, new ListObserver(), aSesion);
	}
	
	public static List getDetallesOCPendRecep(Producto producto,
			ISesion aSesion) throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put(Producto.NICKNAME,producto);
		return (List) ObjetoLogico.getObjects(
			OrdenDeCompraDet.NICKNAME, 
			DBOrdenDeCompraDet.SELECT_BY_OC_DET_PEND_REC,
			condiciones, new ListObserver(), aSesion);
	}
	
	
	
	public static List getDetallesByCondiciones(HashTableDatos condiciones,
			                                        ISesion aSesion) throws BaseException {
		return (List) ObjetoLogico.getObjects(
				OrdenDeCompraDet.NICKNAME, 
				DBOrdenDeCompraDet.SELECT_BY_CONDICIONES,
				condiciones, new ListObserver(), aSesion);
		
	}
	
	public static List getDetallesByProvProdGralMasCercaAFecha(
			java.util.Date fecha,
			Proveedor proveedor,
			ValorClasificadorEntidad valorClasif,
            ISesion aSesion) throws BaseException {
		
		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put("FECHA", fecha);
		if (proveedor!=null)
			condiciones.put(Proveedor.NICKNAME, proveedor);
		condiciones.put(ValorClasificadorEntidad.NICKNAME, valorClasif);
		
		return (List) ObjetoLogico.getObjects(
				OrdenDeCompraDet.NICKNAME, 
				DBOrdenDeCompraDet.SELECT_BY_PROV_PROD_GRAL_MAS_CERC_A_FEC,
				condiciones, new ListObserver(), aSesion);

	}
	
	public static int getMaxNroRenglon(ISesion aSesion, OrdenDeCompraCab oc)
	throws BaseException {

	try {

		StringBuffer sqlUltNroItem = new StringBuffer(
				" select max(nro_item) from cpOCDet where oid_cco_cpra="
				+ oc.getOIDInteger().toString());
		PreparedStatement querySelect = aSesion.getConexionBD().prepareStatement(sqlUltNroItem.toString());
		ResultSet rs = querySelect.executeQuery();
		int ultimoNro = 0;
		if (rs.next())
			ultimoNro = rs.getInt(1);
		rs.close();
		querySelect.close();

	return ultimoNro;
	
	} catch (Exception e) {
		throw new BaseException(null, e.getMessage());
	}
	}
	
	public static double getCantProdOCPendRecep(Producto producto, ISesion aSesion) throws BaseException {

		try {
			
			
			StringBuffer textSQL = new StringBuffer();

			textSQL.append("SELECT sum(a.cant_cpra_us - a.cant_recep_us) cant_oc FROM  cpOCDet a, geComproCab b where a.oid_cco_cpra=b.oid_cco and ");
			textSQL.append("a.pend_recep = 1 and a.anulado = 0 and b.activo = 1 and a.oid_producto = ? ");
		
			PreparedStatement querySelect = aSesion.getConexionBD().prepareStatement(textSQL.toString());

			querySelect.setInt(1, producto.getOID());
			
			ResultSet rs = querySelect.executeQuery();
			double total = 0;
			if (rs.next())
				total = rs.getDouble(1);
			rs.close();
			querySelect.close();

			Money redondear = new Money(total); 
			
			return redondear.doubleValue(2);
		}
		catch (Exception e) {
			throw new BaseException(null, e.getMessage());
		}
	}	

	
	
	

}
