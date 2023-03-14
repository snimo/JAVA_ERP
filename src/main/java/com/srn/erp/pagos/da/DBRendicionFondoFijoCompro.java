package com.srn.erp.pagos.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.pagos.bm.RendicionFondoFijo;
import com.srn.erp.pagos.bm.RendicionFondoFijoCompro;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;

public class DBRendicionFondoFijoCompro extends DBObjetoPersistente {

	public static final String OID_REND_FF_DET = "oid_rend_ff_det";

	public static final String OID_REND_FONDO = "oid_rend_fondo";

	public static final String OID_CCO_PROV = "oid_cco_prov";
	public static final String NETO_GRAVADO = "neto_gravado";
	public static final String NETO_NO_GRAVADO = "neto_no_gravado";
	public static final String IVA = "iva";
	public static final String PERC_IVA = "perc_iva";
	public static final String PERC_IB = "perc_ib";
	public static final String OTROS_IMP = "otros_imp";
	public static final String TOTAL = "total";
	public static final String OID_MONEDA = "oid_moneda";
	public static final String OID_CONC_FACT_PROV = "oid_conc_fact_prov";
	public static final String OID_CONC_IMPU_IVA = "oid_conc_impu_iva";
	public static final String OID_CONC_IMPU_PIVA = "oid_conc_impu_piva";
	public static final String OID_CONC_IMPU_PIB = "oid_conc_impu_pib";

	public static final int SELECT_BY_REND_FF = 100;

	public DBRendicionFondoFijoCompro() {
	}

	protected void insert(IObjetoPersistente objetoPersistente)
			throws BaseException, SQLException {

		final int OID_REND_FF_DET = 1;
		final int OID_REND_FONDO = 2;
		final int OID_CCO_PROV = 3;
		final int NETO_GRAVADO = 4;
		final int NETO_NO_GRAVADO = 5;
		final int IVA = 6;
		final int PERC_IVA = 7;
		final int PERC_IB = 8;
		final int OTROS_IMP = 9;
		final int TOTAL = 10;
		final int OID_MONEDA = 11;
		final int OID_CONC_FACT_PROV = 12;
		final int OID_CONC_IMPU_IVA = 13;
		final int OID_CONC_IMPU_PIVA = 14;
		final int OID_CONC_IMPU_PIB = 15;

		RendicionFondoFijoCompro pers = (RendicionFondoFijoCompro) objetoPersistente;

		StringBuffer sqlInsert = new StringBuffer();
		sqlInsert.append(" insert into opRendFFCompro " + " ( "
				+ "OID_REND_FF_DET," + "OID_REND_FONDO," + "OID_CCO_PROV,"
				+"NETO_GRAVADO,"+
				"NETO_NO_GRAVADO,"+
				"IVA,"+
				"PERC_IVA,"+
				"PERC_IB,"+
				"OTROS_IMP,"+
				"TOTAL,"+
				"OID_MONEDA , OID_CONC_FACT_PROV,oid_conc_impu_iva,oid_conc_impu_piva,oid_conc_impu_pib)"+
				" values " + "(" + "?," + "?," +"?," + "? , ? , ? , ? , ? , ? , ? , ? , ?, ? , ? , ?) ");

		PreparedStatement qInsert = getSesion().getConexionBD()
				.prepareStatement(sqlInsert.toString());
		qInsert.setInt(OID_REND_FF_DET, pers.getOID());
		qInsert.setInt(OID_REND_FONDO, pers.getRendicion_fondo().getOID());
		qInsert.setInt(OID_CCO_PROV, pers.getComprobante_proveedor().getOID());
		if (pers.getNetoGravado()!=null)
			qInsert.setDouble(NETO_GRAVADO, pers.getNetoGravado().doubleValue());
		else
			qInsert.setDouble(NETO_GRAVADO, 0);
		if (pers.getNetoNoGravado()!=null)
			qInsert.setDouble(NETO_NO_GRAVADO,pers.getNetoNoGravado().doubleValue());
		else
			qInsert.setDouble(NETO_NO_GRAVADO,0);
		if (pers.getIVA()!=null)
			qInsert.setDouble(IVA,pers.getIVA().doubleValue());
		else
			qInsert.setDouble(IVA,0);
		if (pers.getPercIVA()!=null)
			qInsert.setDouble(PERC_IVA,pers.getPercIVA().doubleValue());
		else
			qInsert.setDouble(PERC_IVA,0);
		if (pers.getPercIB()!=null)
			qInsert.setDouble(PERC_IB,pers.getPercIB().doubleValue());
		else
			qInsert.setDouble(PERC_IB,0);
		
		if (pers.getOtrosImp()!=null)
			qInsert.setDouble(OTROS_IMP,pers.getOtrosImp().doubleValue());
		else
			qInsert.setDouble(OTROS_IMP,0);
		if (pers.getTotal()!=null)
			qInsert.setDouble(TOTAL,pers.getTotal().doubleValue());
		else
			qInsert.setDouble(TOTAL,0);
		qInsert.setInt(OID_MONEDA,pers.getRendicion_fondo().getMoneda().getOID());
		
		if (pers.getConcFactProv()!=null)
			qInsert.setInt(OID_CONC_FACT_PROV, pers.getConcFactProv().getOID());
		else
			qInsert.setInt(OID_CONC_FACT_PROV, 0);
		
		if (pers.getConcImpuIVA()!=null)
			qInsert.setInt(OID_CONC_IMPU_IVA,pers.getConcImpuIVA().getOID());
		else
			qInsert.setNull(OID_CONC_IMPU_IVA,java.sql.Types.INTEGER);
		
		if (pers.getConcImpuPercIVA()!=null)
			qInsert.setInt(OID_CONC_IMPU_PIVA,pers.getConcImpuPercIVA().getOID());
		else
			qInsert.setNull(OID_CONC_IMPU_PIVA,java.sql.Types.INTEGER);
		
		if (pers.getConcImpuPercIB()!=null)
			qInsert.setInt(OID_CONC_IMPU_PIB,pers.getConcImpuPercIB().getOID());
		else
			qInsert.setNull(OID_CONC_IMPU_PIB,java.sql.Types.INTEGER);
		
		qInsert.executeUpdate();
		qInsert.close();
	}

	protected void update(IObjetoPersistente objetoPersistente)
			throws BaseException, SQLException {

		final int OID_REND_FONDO = 1;
		final int OID_CCO_PROV = 2;
		final int OID_REND_FF_DET = 3;

		RendicionFondoFijoCompro pers = (RendicionFondoFijoCompro) objetoPersistente;

		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append(" update opRendFFCompro set " + "oid_rend_fondo=?"
				+ ",oid_cco_prov=?" + " where " + " oid_rend_ff_det=? ");

		PreparedStatement qUpdate = getSesion().getConexionBD()
				.prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_REND_FF_DET, pers.getOID());
		qUpdate.setInt(OID_REND_FONDO, pers.getRendicion_fondo().getOID());
		qUpdate.setInt(OID_CCO_PROV, pers.getComprobante_proveedor().getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void delete(IObjetoPersistente objetoPersistente)
			throws BaseException, SQLException {
		final int OID_REND_FF_DET = 1;
		RendicionFondoFijoCompro pers = (RendicionFondoFijoCompro) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update opRendFFCompro " + " set activo=0 "
				+ " where " + " oid_rend_ff_det=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD()
				.prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_REND_FF_DET, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void rehabilitar(IObjetoPersistente objetoPersistente)
			throws BaseException, SQLException {
		final int OID_REND_FF_DET = 1;
		RendicionFondoFijoCompro pers = (RendicionFondoFijoCompro) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update opRendFFCompro " + " set activo=1 "
				+ " where " + " oid_rend_ff_det=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD()
				.prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_REND_FF_DET, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	public PreparedStatement prepararSelect(int aSelect, Object aCondiciones)
			throws BaseException, SQLException {
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
		case SELECT_BY_REND_FF: {
			ps = this.selectByRendFondFijo(aCondiciones);
			break;
		}
		}
		return ps;
	}

	private PreparedStatement selectByOID(Object aCondiciones)
			throws BaseException, SQLException {

		final int OID_REND_FF_DET = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  opRendFFCompro ");
		textSQL.append(" WHERE oid_rend_ff_det = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD()
				.prepareStatement(textSQL.toString());
		int oid = ((Integer) aCondiciones).intValue();
		querySelect.setInt(OID_REND_FF_DET, oid);
		return querySelect;
	}

	private PreparedStatement selectByCodigo(Object aCondiciones)
			throws BaseException, SQLException {

		final int CODIGO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  opRendFFCompro ");
		textSQL.append(" WHERE  = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD()
				.prepareStatement(textSQL.toString());
		String codigo = (String) aCondiciones;
		querySelect.setString(CODIGO, codigo);
		return querySelect;
	}

	private PreparedStatement selectByRendFondFijo(Object aCondiciones)
			throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  opRendFFCompro ");
		textSQL.append(" WHERE oid_rend_fondo = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD()
				.prepareStatement(textSQL.toString());
		RendicionFondoFijo rendicionFF = (RendicionFondoFijo) aCondiciones;
		querySelect.setInt(1, rendicionFF.getOID());
		return querySelect;
	}

	private PreparedStatement selectAllHelp(Object aCondiciones)
			throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();

		textSQL
				.append("SELECT oid_rend_ff_det oid, codigo,  descripcion ,activo ");
		textSQL.append(" from opRendFFCompro");

		PreparedStatement querySelect = getSesion().getConexionBD()
				.prepareStatement(textSQL.toString());
		return querySelect;
	}
	
	public static List getComprobantesFF(RendicionFondoFijo rendicionFondoFijo,
              ISesion aSesion) throws BaseException {
		  return (List) ObjetoLogico.getObjects(RendicionFondoFijoCompro.NICKNAME,
                 DBRendicionFondoFijoCompro.SELECT_BY_REND_FF,
                 rendicionFondoFijo,
                 new ListObserver(),
                 aSesion);
    }
	

}
