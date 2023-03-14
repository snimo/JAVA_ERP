package com.srn.erp.impuestos.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import com.srn.erp.impuestos.bm.ConceptoImpuesto;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;

public class DBConceptoImpuesto extends DBObjetoPersistente {

	public static final String	OID_CONC_IMPU											= "oid_conc_impu";

	public static final String	CODIGO														= "codigo";

	public static final String	DESCRIPCION												= "descripcion";

	public static final String	OID_IMPUESTO											= "oid_impuesto";

	public static final String	OID_COL_LIBRO_IVA									= "oid_col_libro_iva";

	public static final String	REGIMEN														= "regimen";

	public static final String	ACTIVO														= "activo";

	public static final String	OID_ANA_IMP												= "oid_ai";
	
	public static final String  BASE_IMPONIBLE										= "base_imponible";
	
	public static final String  IMPUESTO_MINIMO										= "impu_minimo";
	
	public static final String  COL_IMPRE_COMPRO										= "col_impre_compro";
	
	public static final String  CODIGO_AFIP										= "codigo_afip";
	
	
	
	public static final String OID_PROVINCIA = "oid_provincia";

	public static final int			SELECT_BY_IVA											= 100;

	public static final int			SELECT_BY_PERC_IVA								= 101;

	public static final int			SELECT_BY_PERC_IB									= 102;

	public static final int			SELECT_BY_IMP_INT									= 103;

	public static final int			SELECT_BY_RET_IVA									= 104;

	public static final int			SELECT_BY_RET_GAN									= 105;

	public static final int			SELECT_BY_RET_IB									= 106;

	public static final int			HELP_SELECT_BY_RET_IVA						= 107;

	public static final int			HELP_SELECT_BY_RET_GAN						= 108;

	public static final int			HELP_SELECT_BY_RET_IB							= 109;

	public static final int			SELECT_BY_CONC_IMP_IVA_VTAS				= 110;

	public static final int			SELECT_BY_CONC_IMP_PERC_IVA_VTAS	= 111;

	public static final int			SELECT_BY_CONC_IMP_INT_VTAS				= 112;

	public static final int			SELECT_BY_CONC_IMP_PERC_IB_VTAS		= 113;
	
	public static final int 		HELP_SELECT_BY_IMPU_COMPRAS				= 114;
	
	public static final int 		SELECT_BY_CODIGO_IMPU_COMPRAS			= 115;
	
	public static final int			SELECT_BY_IVA_COMPRAS	            = 116;
	
	public static final int			SELECT_BY_PERC_IVA_COMPRAS				= 117;
	
	public static final int			SELECT_BY_PERC_IB_COMPRAS		  		= 118;
	
	public static final int			SELECT_BY_IMP_INT_COMPRAS	        = 119;
	
	public static final int			SELECT_BY_RET_IVA_PAGOS						= 120;

	public static final int			SELECT_BY_RET_GAN_PAGOS						= 121;

	public static final int			SELECT_BY_RET_IB_PAGOS						= 122;
	
	public static final int			HELP_SELECT_BY_RET_GAN_PROV						= 123;
	
	public static final int			HELP_SELECT_IVA						= 124;
	
	public static final int 		SELECT_BY_COD_IMP_IVA_VTAS 	=	125;
	
	public static final int			SELECT_BY_HELP_CONC_IMP_VTAS				= 126;
	
	public static final int			SELECT_BY_CODIGO_IMPU_VTAS				= 127;
	
	public DBConceptoImpuesto() {
	}

	protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_CONC_IMPU = 1;
		final int CODIGO = 2;
		final int DESCRIPCION = 3;
		final int OID_IMPUESTO = 4;
		final int OID_COL_LIBRO_IVA = 5;
		final int REGIMEN = 6;
		final int OID_AI = 7;
		final int ACTIVO = 8;
		final int OID_PROVINCIA = 9;
		final int BASE_IMPONIBLE = 10;
		final int IMPU_MINIMO = 11;
		final int COL_IMPRE_COMPRO = 12;
		final int CODIGO_AFIP = 13;

		ConceptoImpuesto pers = (ConceptoImpuesto) objetoPersistente;

		StringBuffer sqlInsert = new StringBuffer();
		sqlInsert.append(" insert into imConcImpu " + " ( " + "OID_CONC_IMPU," + "CODIGO," + "DESCRIPCION,"
				+ "OID_IMPUESTO," + "OID_COL_LIBRO_IVA," + "REGIMEN," + "OID_AI," + "ACTIVO , OID_PROVINCIA , BASE_IMPONIBLE , IMPU_MINIMO , COL_IMPRE_COMPRO, CODIGO_AFIP)" + " values " + "(" + "?,"+ "?," + "?,"
				+ "?," + "?," + "?,"+ "?," + "?,"+ "?," + "?,"+ "?," + "? , ?) ");

		PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
		qInsert.setInt(OID_CONC_IMPU, pers.getOID());
		qInsert.setString(CODIGO, pers.getCodigo());
		qInsert.setString(DESCRIPCION, pers.getDescripcion());
		qInsert.setInt(OID_IMPUESTO, pers.getImpuesto().getOID());
		if (pers.getColumnalibroiva() != null)
			qInsert.setInt(OID_COL_LIBRO_IVA, pers.getColumnalibroiva().getOID());
		else
			qInsert.setNull(OID_COL_LIBRO_IVA, java.sql.Types.INTEGER);
		qInsert.setString(REGIMEN, pers.getRegimen());
		if (pers.getCuentaImputable() != null)
			qInsert.setInt(OID_AI, pers.getCuentaImputable().getOID());
		else
			qInsert.setNull(OID_AI, java.sql.Types.INTEGER);
		qInsert.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		if (pers.getProvincia()!=null)
			qInsert.setInt(OID_PROVINCIA, pers.getProvincia().getOID());
		else
			qInsert.setNull(OID_PROVINCIA, Types.INTEGER);
		if (pers.getBaseImponible()!=null)
			qInsert.setDouble(BASE_IMPONIBLE , pers.getBaseImponible().doubleValue());
		else
			qInsert.setDouble(BASE_IMPONIBLE , 0);
		if (pers.getImpuestoMinimo()!=null)
			qInsert.setDouble(IMPU_MINIMO , pers.getImpuestoMinimo().doubleValue());
		else
			qInsert.setDouble(IMPU_MINIMO , 0);
		if (pers.getColImpreCompro()!=null)
			qInsert.setString(COL_IMPRE_COMPRO , pers.getColImpreCompro());
		else
			qInsert.setNull(COL_IMPRE_COMPRO, java.sql.Types.VARCHAR);
		
		if (pers.getCodigoAfip()!=null)
			qInsert.setInt(CODIGO_AFIP, pers.getCodigoAfip());
		else
			qInsert.setNull(CODIGO_AFIP, Types.INTEGER);
		
		
		qInsert.executeUpdate();
		qInsert.close();
	}

	protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int CODIGO = 1;
		final int DESCRIPCION = 2;
		final int OID_IMPUESTO = 3;
		final int OID_COL_LIBRO_IVA = 4;
		final int REGIMEN = 5;
		final int ACTIVO = 6;
		final int OID_AI = 7;
		final int OID_PROVINCIA = 8;
		final int BASE_IMPONIBLE = 9;
		final int IMPU_MINIMO = 10;
		final int COL_IMPRE_COMPRO = 11;
		final int CODIGO_AFIP = 12;
		final int OID_CONC_IMPU = 13;

		ConceptoImpuesto pers = (ConceptoImpuesto) objetoPersistente;

		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append(" update imConcImpu set " + "codigo=?" + ",descripcion=?" + ",oid_impuesto=?"
				+ ",oid_col_libro_iva=?" + ",regimen=?" + ",activo=?" + ",oid_ai=? , oid_provincia=? " +
				", base_imponible = ? ,impu_minimo = ? ,  col_impre_compro = ? , codigo_afip = ?  "+
				" where " + " oid_conc_impu=? ");

		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_CONC_IMPU, pers.getOID());
		qUpdate.setString(CODIGO, pers.getCodigo());
		qUpdate.setString(DESCRIPCION, pers.getDescripcion());
		qUpdate.setInt(OID_IMPUESTO, pers.getImpuesto().getOID());
		if (pers.getColumnalibroiva() != null)
			qUpdate.setInt(OID_COL_LIBRO_IVA, pers.getColumnalibroiva().getOID());
		else
			qUpdate.setNull(OID_COL_LIBRO_IVA, java.sql.Types.INTEGER);
		qUpdate.setString(REGIMEN, pers.getRegimen());
		if (pers.getCuentaImputable() != null)
			qUpdate.setInt(OID_AI, pers.getCuentaImputable().getOID());
		else
			qUpdate.setNull(OID_AI, java.sql.Types.INTEGER);
		qUpdate.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		if (pers.getProvincia()!=null)
			qUpdate.setInt(OID_PROVINCIA, pers.getProvincia().getOID());
		else
			qUpdate.setNull(OID_PROVINCIA, Types.INTEGER);
		if (pers.getBaseImponible()!=null)
			qUpdate.setDouble(BASE_IMPONIBLE , pers.getBaseImponible().doubleValue());
		else
			qUpdate.setDouble(BASE_IMPONIBLE , 0);
		if (pers.getImpuestoMinimo()!=null)
			qUpdate.setDouble(IMPU_MINIMO , pers.getImpuestoMinimo().doubleValue());
		else
			qUpdate.setDouble(IMPU_MINIMO , 0);
		if (pers.getColImpreCompro()!=null)
			qUpdate.setString(COL_IMPRE_COMPRO , pers.getColImpreCompro());
		else
			qUpdate.setNull(COL_IMPRE_COMPRO, java.sql.Types.VARCHAR);
		
		if (pers.getCodigoAfip()!=null)
			qUpdate.setInt(CODIGO_AFIP, pers.getCodigoAfip());
		else
			qUpdate.setNull(CODIGO_AFIP, Types.INTEGER);
	
		
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_CONC_IMPU = 1;
		ConceptoImpuesto pers = (ConceptoImpuesto) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update imConcImpu " + " set activo=0 " + " where " + " oid_conc_impu=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_CONC_IMPU, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_CONC_IMPU = 1;
		ConceptoImpuesto pers = (ConceptoImpuesto) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update imConcImpu " + " set activo=1 " + " where " + " oid_conc_impu=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_CONC_IMPU, pers.getOID());
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
		case SELECT_BY_CODIGO_IMPU_VTAS: {
			ps = this.selectByCodigoImpVtas(aCondiciones);
			break;
		}
		case SELECT_BY_HELP_CONC_IMP_VTAS: {
			ps = this.selectByHelpConcImpVtas(aCondiciones);
			break;
		}
		case SELECT_BY_COD_IMP_IVA_VTAS: {
			ps = this.selectByCodImpuIVAVtas(aCondiciones);
			break;
		}
		case IDBObjetoPersistente.SELECT_ALL_HELP: {
			ps = this.selectAllHelp(aCondiciones);
			break;
		}
		case SELECT_BY_IVA: {
			ps = this.selectByIVA(aCondiciones);
			break;
		}
		case SELECT_BY_IVA_COMPRAS: {
			ps = this.selectByIVACompras(aCondiciones);
			break;
		}
		case SELECT_BY_PERC_IVA: {
			ps = this.selectByPercIVA(aCondiciones);
			break;
		}
		case SELECT_BY_PERC_IVA_COMPRAS: {
			ps = this.selectByPercIVACompras(aCondiciones);
			break;
		}
		case SELECT_BY_PERC_IB: {
			ps = this.selectByPercIB(aCondiciones);
			break;
		}
		case SELECT_BY_PERC_IB_COMPRAS: {
			ps = this.selectByPercIBCompras(aCondiciones);
			break;
		}
		case SELECT_BY_IMP_INT: {
			ps = this.selectByImpInt(aCondiciones);
			break;
		}
		case SELECT_BY_IMP_INT_COMPRAS: {
			ps = this.selectByImpIntCompras(aCondiciones);
			break;
		}
		case SELECT_BY_RET_IVA: {
			ps = this.selectByRetIVA(aCondiciones);
			break;
		}
		case SELECT_BY_RET_GAN: {
			ps = this.selectByRetGan(aCondiciones);
			break;
		}
		case SELECT_BY_RET_IB: {
			ps = this.selectByReIB(aCondiciones);
			break;
		}
		case SELECT_BY_RET_IVA_PAGOS: {
			ps = this.selectByRetIVAPagos(aCondiciones);
			break;
		}
		case SELECT_BY_RET_GAN_PAGOS: {
			ps = this.selectByRetGanPagos(aCondiciones);
			break;
		}
		case SELECT_BY_RET_IB_PAGOS: {
			ps = this.selectByReIBPagos(aCondiciones);
			break;
		}
		
		case HELP_SELECT_BY_RET_IVA: {
			ps = this.selectByHelpRetIVA(aCondiciones);
			break;
		}
		case HELP_SELECT_BY_RET_GAN: {
			ps = this.selectByHelpRetGan(aCondiciones);
			break;
		}
		case HELP_SELECT_BY_RET_IB: {
			ps = this.selectByHelpRetIB(aCondiciones);
			break;
		}
		case SELECT_BY_CONC_IMP_IVA_VTAS: {
			ps = this.selectByConcImpIVAVtas(aCondiciones);
			break;
		}
		case SELECT_BY_CONC_IMP_PERC_IVA_VTAS: {
			ps = this.selectByConcImpPercIVAVtas(aCondiciones);
			break;
		}
		case SELECT_BY_CONC_IMP_INT_VTAS: {
			ps = this.selectByConcImpIntVtas(aCondiciones);
			break;
		}
		case SELECT_BY_CONC_IMP_PERC_IB_VTAS: {
			ps = this.selectByConcImpPercIBVtas(aCondiciones);
			break;
		}
		case HELP_SELECT_BY_IMPU_COMPRAS: {
			ps = this.selectByHelpImpuestosCompras(aCondiciones);
			break;
		}
		case SELECT_BY_CODIGO_IMPU_COMPRAS: {
			ps = this.selectByCodigoImpuCompras(aCondiciones);
			break;
		}
		case HELP_SELECT_BY_RET_GAN_PROV: {
			ps = this.selectByHelpRetGanProv(aCondiciones);
			break;
		}
		case HELP_SELECT_IVA: {
			ps = this.selectHelpByIVA(aCondiciones);
			break;
		}

		}
		return ps;
	}

	private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

		final int OID_CONC_IMPU = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  imConcImpu ");
		textSQL.append(" WHERE oid_conc_impu = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		int oid = ((Integer) aCondiciones).intValue();
		querySelect.setInt(OID_CONC_IMPU, oid);
		return querySelect;
	}

	private PreparedStatement selectByConcImpPercIVAVtas(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();
		textSQL.append(" select * from imConcImpu where oid_impuesto ");
		textSQL.append(" in (select oid_impuesto from imImpuestos where compo='PERC_IVA' and ventas=1) ");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;

	}

	private PreparedStatement selectByConcImpIntVtas(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();
		textSQL.append(" select * from imConcImpu where oid_impuesto ");
		textSQL.append(" in (select oid_impuesto from imImpuestos where compo='IMP_INT' and ventas=1) ");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;

	}

	private PreparedStatement selectByConcImpIVAVtas(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();
		textSQL.append(" select * from imConcImpu where oid_impuesto ");
		textSQL.append(" in (select oid_impuesto from imImpuestos where compo='IVA' and ventas=1) ");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;

	}

	private PreparedStatement selectByConcImpPercIBVtas(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();
		textSQL.append(" select * from imConcImpu where oid_impuesto ");
		textSQL.append(" in (select oid_impuesto from imImpuestos where compo='PERC_IB' and ventas=1) ");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;

	}
	
	private PreparedStatement selectByCodImpuIVAVtas(Object aCondiciones) throws BaseException, SQLException {

		final int CODIGO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT a.* FROM  imConcImpu a , imImpuestos b");
		textSQL.append(" WHERE a.oid_impuesto = b.oid_impuesto and b.ventas=1 and b.compo = 'IVA' and a.codigo = ? ");
		
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		String codigo = (String) aCondiciones;
		querySelect.setString(CODIGO, codigo);
		return querySelect;
	}

	private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

		final int CODIGO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  imConcImpu ");
		textSQL.append(" WHERE codigo = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		String codigo = (String) aCondiciones;
		querySelect.setString(CODIGO, codigo);
		return querySelect;
	}

	private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();

		textSQL.append("SELECT oid_conc_impu oid,codigo codigo, descripcion descripcion ,activo ");
		textSQL.append(" from imConcImpu");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}

	private PreparedStatement selectByIVA(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT a.* FROM  imConcImpu a , imImpuestos b");
		textSQL.append(" WHERE a.oid_impuesto = b.oid_impuesto and b.compo='IVA' ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}
	
	private PreparedStatement selectByIVACompras(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT a.* FROM  imConcImpu a , imImpuestos b");
		textSQL.append(" WHERE a.oid_impuesto = b.oid_impuesto and b.compo='IVA_C' ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}
	

	private PreparedStatement selectByPercIVA(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT a.* FROM  imConcImpu a , imImpuestos b");
		textSQL.append(" WHERE a.oid_impuesto = b.oid_impuesto and b.compo='PERC_IVA' ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}
	
	private PreparedStatement selectByPercIVACompras(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT a.* FROM  imConcImpu a , imImpuestos b");
		textSQL.append(" WHERE a.oid_impuesto = b.oid_impuesto and b.compo='PERC_IVA_C' ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}
	

	private PreparedStatement selectByPercIB(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT a.* FROM  imConcImpu a , imImpuestos b");
		textSQL.append(" WHERE a.oid_impuesto = b.oid_impuesto and b.compo IN ('PI_BA','PI_CF') ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}
	
	private PreparedStatement selectByPercIBCompras(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT a.* FROM  imConcImpu a , imImpuestos b");
		textSQL.append(" WHERE a.oid_impuesto = b.oid_impuesto and b.compo ='PERC_IB_C' ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}
	

	private PreparedStatement selectByImpInt(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT a.* FROM  imConcImpu a , imImpuestos b");
		textSQL.append(" WHERE a.oid_impuesto = b.oid_impuesto and b.compo='IMP_INT' ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}
	
	private PreparedStatement selectByImpIntCompras(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT a.* FROM  imConcImpu a , imImpuestos b");
		textSQL.append(" WHERE a.oid_impuesto = b.oid_impuesto and b.compo='IMP_INT_C' ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}
	

	private PreparedStatement selectByRetIVA(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT a.* FROM  imConcImpu a , imImpuestos b");
		textSQL.append(" WHERE a.oid_impuesto = b.oid_impuesto and b.compo='RET_IVA' ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}
	
	private PreparedStatement selectByRetIVAPagos(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT a.* FROM  imConcImpu a , imImpuestos b");
		textSQL.append(" WHERE a.oid_impuesto = b.oid_impuesto and b.compo='RET_IVA_P' ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}
	

	private PreparedStatement selectByHelpRetIVA(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT a.oid_conc_impu oid,a.codigo,a.descripcion,a.activo FROM  imConcImpu a , imImpuestos b");
		textSQL.append(" WHERE a.oid_impuesto = b.oid_impuesto and b.compo='RET_IVA' ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}
	
	private PreparedStatement selectByHelpRetIVAPagos(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT a.oid_conc_impu oid,a.codigo,a.descripcion,a.activo FROM  imConcImpu a , imImpuestos b");
		textSQL.append(" WHERE a.oid_impuesto = b.oid_impuesto and b.compo='RET_IVA_P' ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}
	
	private PreparedStatement selectByCodigoImpVtas(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT a.* FROM  imConcImpu a , imImpuestos b");
		textSQL.append(" WHERE a.oid_impuesto = b.oid_impuesto and b.ventas=1 and b.compo in ('IVA','PERC_IVA','PERC_IB') AND a.codigo = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		HashTableDatos condiciones = (HashTableDatos)aCondiciones; 
		String codigo = (String) condiciones.get("codigo"); 
		querySelect.setString(1, codigo);
		return querySelect;
	}
	
	
	private PreparedStatement selectByHelpConcImpVtas(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT a.oid_conc_impu oid,a.codigo,a.descripcion,a.activo FROM  imConcImpu a , imImpuestos b");
		textSQL.append(" WHERE a.oid_impuesto = b.oid_impuesto and b.ventas=1 and b.compo in ('IVA','PERC_IVA','PERC_IB') ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}
	
	
	
	private PreparedStatement selectByHelpImpuestosCompras(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT a.oid_conc_impu oid,a.codigo,a.descripcion,a.activo FROM  imConcImpu a , imImpuestos b");
		textSQL.append(" WHERE a.oid_impuesto = b.oid_impuesto and b.compras=1 and b.compo in ('IVA_C','PERC_IVA_C','PERC_IB_C') ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}
	
	private PreparedStatement selectHelpByIVA(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT a.oid_conc_impu oid,a.codigo,a.descripcion,a.activo FROM  imConcImpu a , imImpuestos b");
		textSQL.append(" WHERE a.oid_impuesto = b.oid_impuesto and b.ventas=1 and b.compo = 'IVA' ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}
	
	private PreparedStatement selectByCodigoImpuCompras(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT a.* FROM  imConcImpu a , imImpuestos b");
		textSQL.append(" WHERE a.oid_impuesto = b.oid_impuesto and b.compras=1 and codigo=? and b.compo in ('IVA_C','PERC_IVA_C','PERC_IB_C')  ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		String codigo = (String) aCondiciones;
		querySelect.setString(1,codigo);
		return querySelect;
	}
	

	private PreparedStatement selectByHelpRetGan(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT a.oid_conc_impu oid,a.codigo,a.descripcion,a.activo FROM  imConcImpu a , imImpuestos b");
		textSQL.append(" WHERE a.oid_impuesto = b.oid_impuesto and b.compo='RET_GAN' ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}
	
	private PreparedStatement selectByHelpRetGanProv(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT a.oid_conc_impu oid,a.codigo,a.descripcion,a.activo FROM  imConcImpu a , imImpuestos b");
		textSQL.append(" WHERE a.oid_impuesto = b.oid_impuesto and b.compo='RET_GAN_P' ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}
	

	private PreparedStatement selectByHelpRetIB(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT a.oid_conc_impu oid,a.codigo,a.descripcion,a.activo FROM  imConcImpu a , imImpuestos b");
		textSQL.append(" WHERE a.oid_impuesto = b.oid_impuesto and b.compo='RET_IB' ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}

	private PreparedStatement selectByRetGan(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT a.* FROM  imConcImpu a , imImpuestos b");
		textSQL.append(" WHERE a.oid_impuesto = b.oid_impuesto and b.compo='RET_GAN' ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}
	
	private PreparedStatement selectByRetGanPagos(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT a.* FROM  imConcImpu a , imImpuestos b");
		textSQL.append(" WHERE a.oid_impuesto = b.oid_impuesto and b.compo='RET_GAN_P' ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}
	

	private PreparedStatement selectByReIB(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT a.* FROM  imConcImpu a , imImpuestos b");
		textSQL.append(" WHERE a.oid_impuesto = b.oid_impuesto and b.compo='RET_IB' ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}
	
	private PreparedStatement selectByReIBPagos(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT a.* FROM  imConcImpu a , imImpuestos b");
		textSQL.append(" WHERE a.oid_impuesto = b.oid_impuesto and b.compo='RET_IB_P' ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}
	

	public static List getConcImpuIVA(ISesion aSesion) throws BaseException {
		return (List) ObjetoLogico.getObjects(ConceptoImpuesto.NICKNAME, SELECT_BY_IVA, null, new ListObserver(), aSesion);
	}
	
	public static List getConcImpuIVACompras(ISesion aSesion) throws BaseException {
		return (List) ObjetoLogico.getObjects(ConceptoImpuesto.NICKNAME, SELECT_BY_IVA_COMPRAS, null, new ListObserver(), aSesion);
	}
	

	public static List getConcImpuPercIVA(ISesion aSesion) throws BaseException {
		return (List) ObjetoLogico.getObjects(ConceptoImpuesto.NICKNAME, SELECT_BY_PERC_IVA, null, new ListObserver(),
				aSesion);
	}
	
	public static List getConcImpuPercIVACompras(ISesion aSesion) throws BaseException {
		return (List) ObjetoLogico.getObjects(ConceptoImpuesto.NICKNAME, SELECT_BY_PERC_IVA_COMPRAS, null, new ListObserver(),
				aSesion);
	}
	

	public static List getConcImpuPercIB(ISesion aSesion) throws BaseException {
		return (List) ObjetoLogico.getObjects(ConceptoImpuesto.NICKNAME, SELECT_BY_PERC_IB, null, new ListObserver(),
				aSesion);
	}
	
	public static List getConcImpuPercIBCompras(ISesion aSesion) throws BaseException {
		return (List) ObjetoLogico.getObjects(ConceptoImpuesto.NICKNAME, SELECT_BY_PERC_IB_COMPRAS, null, new ListObserver(),
				aSesion);
	}	

	public static List getConcImpuInt(ISesion aSesion) throws BaseException {
		return (List) ObjetoLogico.getObjects(ConceptoImpuesto.NICKNAME, SELECT_BY_IMP_INT, null, new ListObserver(),
				aSesion);
	}
	
	public static List getConcImpuIntCompras(ISesion aSesion) throws BaseException {
		return (List) ObjetoLogico.getObjects(ConceptoImpuesto.NICKNAME, SELECT_BY_IMP_INT_COMPRAS, null, new ListObserver(),
				aSesion);
	}

	public static List getConcImpuRetGan(ISesion aSesion) throws BaseException {
		return (List) ObjetoLogico.getObjects(ConceptoImpuesto.NICKNAME, SELECT_BY_RET_GAN, null, new ListObserver(),
				aSesion);
	}

	public static List getConcImpuRetIVA(ISesion aSesion) throws BaseException {
		return (List) ObjetoLogico.getObjects(ConceptoImpuesto.NICKNAME, SELECT_BY_RET_IVA, null, new ListObserver(),
				aSesion);
	}

	public static List getConcImpuRetIB(ISesion aSesion) throws BaseException {
		return (List) ObjetoLogico.getObjects(ConceptoImpuesto.NICKNAME, SELECT_BY_RET_IB, null, new ListObserver(),
				aSesion);
	}
	
	public static List getConcImpuRetGanPagos(ISesion aSesion) throws BaseException {
		return (List) ObjetoLogico.getObjects(ConceptoImpuesto.NICKNAME, SELECT_BY_RET_GAN_PAGOS, null, new ListObserver(),
				aSesion);
	}

	public static List getConcImpuRetIVAPagos(ISesion aSesion) throws BaseException {
		return (List) ObjetoLogico.getObjects(ConceptoImpuesto.NICKNAME, SELECT_BY_RET_IVA_PAGOS, null, new ListObserver(),
				aSesion);
	}

	public static List getConcImpuRetIBPagos(ISesion aSesion) throws BaseException {
		return (List) ObjetoLogico.getObjects(ConceptoImpuesto.NICKNAME, SELECT_BY_RET_IB_PAGOS, null, new ListObserver(),
				aSesion);
	}
	

	public static List getConcImpuIVAVtas(ISesion aSesion) throws BaseException {
		return (List) ObjetoLogico.getObjects(ConceptoImpuesto.NICKNAME, SELECT_BY_CONC_IMP_IVA_VTAS, null,
				new ListObserver(), aSesion);
	}

	public static List getConcImpuPercIVAVtas(ISesion aSesion) throws BaseException {
		return (List) ObjetoLogico.getObjects(ConceptoImpuesto.NICKNAME, SELECT_BY_CONC_IMP_PERC_IVA_VTAS, null,
				new ListObserver(), aSesion);
	}

	public static List getConcImpuIntVtas(ISesion aSesion) throws BaseException {
		return (List) ObjetoLogico.getObjects(ConceptoImpuesto.NICKNAME, SELECT_BY_CONC_IMP_INT_VTAS, null,
				new ListObserver(), aSesion);
	}

	public static List getConcImpuPercIBVtas(ISesion aSesion) throws BaseException {
		return (List) ObjetoLogico.getObjects(ConceptoImpuesto.NICKNAME, SELECT_BY_CONC_IMP_PERC_IB_VTAS, null,
				new ListObserver(), aSesion);
	}
	
	
	
	public static List getConcImpuCompras(ISesion aSesion) throws BaseException {
		return (List) ObjetoLogico.getObjects(ConceptoImpuesto.NICKNAME, HELP_SELECT_BY_IMPU_COMPRAS, null,
				new ListObserver(), aSesion);
	}
	

}
