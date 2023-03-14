package com.srn.erp.pagos.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Date;
import java.util.List;

import com.srn.erp.compras.bm.Proveedor;
import com.srn.erp.ctasAPagar.bm.ComproProveedor;
import com.srn.erp.ctasAPagar.da.DBComproProveedor;
import com.srn.erp.pagos.bm.ComproOrdenPagoCab;
import com.srn.erp.tesoreria.bm.Recibo;
import com.srn.erp.tesoreria.da.DBRecibo;
import com.srn.erp.ventas.bm.Sujeto;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;

public class DBComproOrdenPagoCab extends DBObjetoPersistente {

	public static final String	OID_CCO					= "oid_cco";

	public static final String	FEC_EMISION			= "fec_emision";

	public static final String	OID_MOTIVO_PAGO	= "oid_motivo_pago";

	public static final String	OID_MONEDA			= "oid_moneda";

	public static final String	COTIZACION			= "cotizacion";

	public static final String	OID_PROVEEDOR		= "oid_proveedor";

	public static final String	PAGO_A_CTA			= "pago_a_cta";

	public static final String	OID_CAJA				= "oid_caja";

	public static final String	TOTAL_PAGO			= "total_pago";
	
	public static final String	BRUTO = "bruto";
	
	public static final String	DESCUENTO = "descuento";
	
	public static final String	NETO = "neto";
	
	public static final String	RET_IVA = "ret_iva";
	
	public static final String	RET_GAN = "ret_gan";
	
	public static final String	RET_IB = "ret_ib";
	
	public static final String	RET_SUS = "ret_sus";
	
	public static final String	OID_FORMA_PAGO = "oid_forma_pago";
	
	
	
	public static final int SELECT_BY_HELP_OP_VARIAS_EFE = 100;
	public static final int SELECT_BY_HELP_OP = 101;
	
	public DBComproOrdenPagoCab() {
	}

	protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_CCO = 1;
		final int FEC_EMISION = 2;
		final int OID_MOTIVO_PAGO = 3;
		final int OID_MONEDA = 4;
		final int COTIZACION = 5;
		final int OID_PROVEEDOR = 6;
		final int PAGO_A_CTA = 7;
		final int OID_CAJA = 8;
		final int TOTAL_PAGO = 9;
		final int BRUTO = 10;
		final int DESCUENTO = 11;
		final int NETO = 12;
		final int RET_IVA = 13;
		final int RET_GAN = 14;
		final int RET_IB = 15;
		final int RET_SUS = 16;
		final int OID_FORMA_PAGO = 17;

		ComproOrdenPagoCab pers = (ComproOrdenPagoCab) objetoPersistente;

		StringBuffer sqlInsert = new StringBuffer();
		sqlInsert.append(" insert into opComproCabOP " + " ( " + "OID_CCO," + "FEC_EMISION," + "OID_MOTIVO_PAGO,"
				+ "OID_MONEDA," + "COTIZACION," + "OID_PROVEEDOR," + "PAGO_A_CTA," + "OID_CAJA," + "TOTAL_PAGO"+
				",BRUTO, DESCUENTO, NETO, RET_IVA, RET_GAN, RET_IB, RET_SUS, OID_FORMA_PAGO"+
				")" + " values "
				+ "(" + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," +"?," + "?," + "?," + "?," + "?," + "?," + "?," + "?,"+ "?) ");

		PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
		qInsert.setInt(OID_CCO, pers.getOID());
		qInsert.setDate(FEC_EMISION, new java.sql.Date(pers.getFecemision().getTime()));
		qInsert.setInt(OID_MOTIVO_PAGO, pers.getMotivopago().getOID());
		qInsert.setInt(OID_MONEDA, pers.getMoneda().getOID());
		qInsert.setDouble(COTIZACION, pers.getCotizacion().doubleValue());
		if (pers.getProveedor() != null)
			qInsert.setInt(OID_PROVEEDOR, pers.getProveedor().getOID());
		else
			qInsert.setNull(OID_PROVEEDOR, java.sql.Types.INTEGER);
		if (pers.getPagoACuenta() != null)
			qInsert.setDouble(PAGO_A_CTA, pers.getPagoACuenta().doubleValue());
		else
			qInsert.setDouble(PAGO_A_CTA, 0);
		if (pers.getCaja() != null)
			qInsert.setInt(OID_CAJA, pers.getCaja().getOID());
		else
			qInsert.setInt(OID_CAJA, Types.INTEGER);
		if (pers.getTotalPago() != null)
			qInsert.setDouble(TOTAL_PAGO, pers.getTotalPago().doubleValue());
		else
			qInsert.setNull(TOTAL_PAGO, Types.DOUBLE);
		
		if (pers.getBruto() != null)
			qInsert.setDouble(BRUTO, pers.getBruto().doubleValue());
		else
			qInsert.setNull(BRUTO, Types.DOUBLE);

		if (pers.getDescuento() != null)
			qInsert.setDouble(DESCUENTO, pers.getDescuento().doubleValue());
		else
			qInsert.setNull(DESCUENTO, Types.DOUBLE);
		
		if (pers.getNeto() != null)
			qInsert.setDouble(NETO, pers.getNeto().doubleValue());
		else
			qInsert.setNull(NETO, Types.DOUBLE);
		
		if (pers.getRetIVA() != null)
			qInsert.setDouble(RET_IVA, pers.getRetIVA().doubleValue());
		else
			qInsert.setNull(RET_IVA, Types.DOUBLE);
		
		if (pers.getRetGan() != null)
			qInsert.setDouble(RET_GAN, pers.getRetGan().doubleValue());
		else
			qInsert.setNull(RET_GAN, Types.DOUBLE);
		
		if (pers.getRetIB() != null)
			qInsert.setDouble(RET_IB, pers.getRetIB().doubleValue());
		else
			qInsert.setNull(RET_IB, Types.DOUBLE);
		
		if (pers.getRetSUS() != null)
			qInsert.setDouble(RET_SUS, pers.getRetSUS().doubleValue());
		else
			qInsert.setNull(RET_SUS, Types.DOUBLE);
		
		if (pers.getFormaPago() != null)
			qInsert.setInt(OID_FORMA_PAGO, pers.getFormaPago().getOID());
		else
			qInsert.setNull(OID_FORMA_PAGO, Types.INTEGER);
		
		qInsert.executeUpdate();
		qInsert.close();
	}

	protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int FEC_EMISION = 1;
		final int OID_MOTIVO_PAGO = 2;
		final int OID_MONEDA = 3;
		final int COTIZACION = 4;
		final int OID_PROVEEDOR = 5;
		final int PAGO_A_CTA = 6;
		final int BRUTO = 7;
		final int DESCUENTO = 8;
		final int NETO = 9;
		final int RET_IVA = 10;
		final int RET_GAN = 11;
		final int RET_IB = 12;
		final int RET_SUS = 13;
		final int OID_FORMA_PAGO = 14;		
		final int OID_CCO = 15;

		ComproOrdenPagoCab pers = (ComproOrdenPagoCab) objetoPersistente;

		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append(" update opComproCabOP set " + "fec_emision=?" + ",oid_motivo_pago=?" + ",oid_moneda=?"
				+ ",cotizacion=?" + ",oid_proveedor=?" + ",pago_a_cta=?" +
				",bruto=?, descuento = ? , neto = ? , ret_iva = ? , ret_gan = ? , ret_ib = ? , ret_sus = ? , oid_forma_pago = ? "+
				" where " + " oid_cco=? ");

		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_CCO, pers.getOID());
		qUpdate.setDate(FEC_EMISION, new java.sql.Date(pers.getFecemision().getTime()));
		qUpdate.setInt(OID_MOTIVO_PAGO, pers.getMotivopago().getOID());
		qUpdate.setInt(OID_MONEDA, pers.getMoneda().getOID());
		qUpdate.setDouble(COTIZACION, pers.getCotizacion().doubleValue());
		qUpdate.setInt(OID_PROVEEDOR, pers.getProveedor().getOID());
		qUpdate.setDouble(PAGO_A_CTA, pers.getPagoACuenta().doubleValue());
		
		if (pers.getBruto() != null)
			qUpdate.setDouble(BRUTO, pers.getBruto().doubleValue());
		else
			qUpdate.setNull(BRUTO, Types.DOUBLE);

		if (pers.getDescuento() != null)
			qUpdate.setDouble(DESCUENTO, pers.getDescuento().doubleValue());
		else
			qUpdate.setNull(DESCUENTO, Types.DOUBLE);
		
		if (pers.getNeto() != null)
			qUpdate.setDouble(NETO, pers.getNeto().doubleValue());
		else
			qUpdate.setNull(NETO, Types.DOUBLE);
		
		if (pers.getRetIVA() != null)
			qUpdate.setDouble(RET_IVA, pers.getRetIVA().doubleValue());
		else
			qUpdate.setNull(RET_IVA, Types.DOUBLE);
		
		if (pers.getRetGan() != null)
			qUpdate.setDouble(RET_GAN, pers.getRetGan().doubleValue());
		else
			qUpdate.setNull(RET_GAN, Types.DOUBLE);
		
		if (pers.getRetIB() != null)
			qUpdate.setDouble(RET_IB, pers.getRetIB().doubleValue());
		else
			qUpdate.setNull(RET_IB, Types.DOUBLE);
		
		if (pers.getRetSUS() != null)
			qUpdate.setDouble(RET_SUS, pers.getRetSUS().doubleValue());
		else
			qUpdate.setNull(RET_SUS, Types.DOUBLE);
		
		if (pers.getFormaPago() != null)
			qUpdate.setInt(OID_FORMA_PAGO, pers.getFormaPago().getOID());
		else
			qUpdate.setNull(OID_FORMA_PAGO, Types.INTEGER);
		
		
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_CCO_ANULADOR = 1;
		final int OID_CCO = 2;
		ComproOrdenPagoCab pers = (ComproOrdenPagoCab) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update geComproCab " + " set activo=0 , oid_cco_anulador = ? " + " where " + " oid_cco=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		if (pers.getComprobanteAnulador()!=null)
			qUpdate.setInt(OID_CCO_ANULADOR, pers.getComprobanteAnulador().getOID());
		else
			qUpdate.setNull(OID_CCO_ANULADOR, java.sql.Types.INTEGER);
		qUpdate.setInt(OID_CCO, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_CCO = 1;
		ComproOrdenPagoCab pers = (ComproOrdenPagoCab) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update opComproCabOP " + " set activo=1 " + " where " + " oid_cco=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_CCO, pers.getOID());
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
		case SELECT_BY_HELP_OP_VARIAS_EFE: {
			ps = this.selectByHelpOPVariasEfectivo(aCondiciones); 
			break; 
		}
	    case SELECT_BY_HELP_OP : {
	        ps = this.selectByHelp(aCondiciones); 
	        break; 
	    }
		
		}
		return ps;
	}
	
	  private PreparedStatement selectByHelp(Object aCondiciones) throws BaseException, SQLException { 

		  	int nroParam = 0;
		  	
		    HashTableDatos condiciones = (HashTableDatos) aCondiciones;

		    StringBuffer textSQL = new StringBuffer(); 
		    textSQL.append("SELECT a.*,b.* FROM  opComproCabOP a, geComproCab b  "); 
		    textSQL.append(" WHERE  a.oid_cco = b.oid_cco and b.comportamiento='ORPAG' ");
		    
		    if (condiciones.containsKey("NRO_EXT_DESDE")) 
		    	textSQL.append(" and b.nro_ext >= "+condiciones.getInteger("NRO_EXT_DESDE").toString());
		    
		    if (condiciones.containsKey("NRO_EXT_HASTA")) 
		    	textSQL.append(" and b.nro_ext <= "+condiciones.getInteger("NRO_EXT_HASTA").toString());
		    
		    if (condiciones.containsKey(Proveedor.NICKNAME)) {
					Proveedor proveedor = (Proveedor) condiciones.get(Proveedor.NICKNAME);
					textSQL.append(" and a.oid_proveedor = "
							+ proveedor.getOIDInteger().toString());
				}
		    
				if (condiciones.containsKey("FEC_DESDE"))
					textSQL.append(" and b.emision >= ? ");

				if (condiciones.containsKey("FEC_HASTA"))
					textSQL.append(" and b.emision <= ? ");
		    
		    
		    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		    
				if (condiciones.containsKey("FEC_DESDE")) {
					java.util.Date fecDesde = (java.util.Date) condiciones
							.get("FEC_DESDE");
					++nroParam;
					querySelect
							.setDate(nroParam, new java.sql.Date(fecDesde.getTime()));
				}
				if (condiciones.containsKey("FEC_HASTA")) {
					java.util.Date fecHasta = (java.util.Date) condiciones
							.get("FEC_HASTA");
					++nroParam;
					querySelect
							.setDate(nroParam, new java.sql.Date(fecHasta.getTime()));
				}
		    
		    
		    return querySelect; 
		  }
	

	private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

		final int OID_CCO = 1;

		StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT a.*,b.* FROM  opComproCabOP a, geComproCab b  "); 
    textSQL.append(" WHERE  a.oid_cco = b.oid_cco ");
		textSQL.append(" and a.oid_cco = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		int oid = ((Integer) aCondiciones).intValue();
		querySelect.setInt(OID_CCO, oid);
		return querySelect;
	}

	private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

		final int CODIGO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  opComproCabOP ");
		textSQL.append(" WHERE  = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		String codigo = (String) aCondiciones;
		querySelect.setString(CODIGO, codigo);
		return querySelect;
	}

	private PreparedStatement selectByHelpOPVariasEfectivo(Object aCondiciones) throws BaseException, SQLException {

  	int nroParam = 0;
  	
    HashTableDatos condiciones = (HashTableDatos) aCondiciones;

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT a.*,b.* FROM  opComproCabOP a, geComproCab b  "); 
    textSQL.append(" WHERE  a.oid_cco = b.oid_cco and b.comportamiento='PAVAE' ");
    
    if (condiciones.containsKey("NRO_EXT_DESDE")) 
    	textSQL.append(" and b.nro_ext >= "+condiciones.getInteger("NRO_EXT_DESDE").toString());
    
    if (condiciones.containsKey("NRO_EXT_HASTA")) 
    	textSQL.append(" and b.nro_ext <= "+condiciones.getInteger("NRO_EXT_HASTA").toString());
    
		if (condiciones.containsKey("FEC_DESDE"))
			textSQL.append(" and b.emision >= ? ");

		if (condiciones.containsKey("FEC_HASTA"))
			textSQL.append(" and b.emision <= ? ");
    
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    
		if (condiciones.containsKey("FEC_DESDE")) {
			java.util.Date fecDesde = (java.util.Date) condiciones
					.get("FEC_DESDE");
			++nroParam;
			querySelect
					.setDate(nroParam, new java.sql.Date(fecDesde.getTime()));
		}
		if (condiciones.containsKey("FEC_HASTA")) {
			java.util.Date fecHasta = (java.util.Date) condiciones
					.get("FEC_HASTA");
			++nroParam;
			querySelect
					.setDate(nroParam, new java.sql.Date(fecHasta.getTime()));
		}
    
    
    return querySelect; 
  }
	
	
	private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();

		textSQL.append("SELECT oid_cco oid, codigo,  descripcion ,activo ");
		textSQL.append(" from opComproCabOP");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}

	public static List getHelpComproOrdenPagoVariasEfectivo(
			Integer nroExtDesde, 
			Integer nroExtHasta, 
			Date fechaDesde, Date fechaHasta, ISesion aSesion) throws BaseException {

		HashTableDatos condiciones = new HashTableDatos();
		if (nroExtDesde != null)
			condiciones.put("NRO_EXT_DESDE", nroExtDesde.toString());
		if (nroExtHasta != null)
			condiciones.put("NRO_EXT_HASTA", nroExtHasta.toString());
		if (fechaDesde != null)
			condiciones.put("FEC_DESDE", fechaDesde);
		if (fechaHasta != null)
			condiciones.put("FEC_HASTA", fechaHasta);

		return (List) ObjetoLogico.getObjects(
				ComproOrdenPagoCab.NICKNAME, 
				DBComproOrdenPagoCab.SELECT_BY_HELP_OP_VARIAS_EFE, 
				condiciones, 
				new ListObserver(),
				aSesion);
	}
	
	public static List getHelpOP(
			  Integer nroExtDesde,
		      Integer nroExtHasta,
		      Proveedor proveedor,
		      Date fechaDesde,
		      Date fechaHasta,
		      ISesion aSesion) throws BaseException {

				HashTableDatos condiciones = new HashTableDatos();
				if (nroExtDesde!=null)
					condiciones.put("NRO_EXT_DESDE",nroExtDesde.toString());
				if (nroExtHasta!=null)
					condiciones.put("NRO_EXT_HASTA",nroExtHasta.toString());
				if (fechaDesde!=null)
					condiciones.put("FEC_DESDE",fechaDesde);
				if (fechaHasta!=null)
					condiciones.put("FEC_HASTA",fechaHasta);
				if (proveedor!=null)
					condiciones.put(Proveedor.NICKNAME,proveedor);

				return (List) ObjetoLogico.getObjects(ComproOrdenPagoCab.NICKNAME,
						DBComproOrdenPagoCab.SELECT_BY_HELP_OP, condiciones,
						new ListObserver(), aSesion);
			}
	
	
	

}
