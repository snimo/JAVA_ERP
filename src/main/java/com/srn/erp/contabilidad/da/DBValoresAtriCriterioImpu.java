package com.srn.erp.contabilidad.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.contabilidad.bm.AtributoEntidadSeleccionado;
import com.srn.erp.contabilidad.bm.CriterioSelCuenta;
import com.srn.erp.contabilidad.bm.ValoresAtriCriterioImpu;

import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.ObjetoObservado;

public class DBValoresAtriCriterioImpu extends DBObjetoPersistente {

	public static final String OID_VAL_ATRI_ENT = "oid_val_atri_ent";

	public static final String OID_CRI_SEL_CTA = "oid_cri_sel_cta";

	public static final String OID_ATRI_ENT_1 = "oid_atri_ent_1";

	public static final String OID_ATRI_ENT_2 = "oid_atri_ent_2";

	public static final String OID_ATRI_ENT_3 = "oid_atri_ent_3";

	public static final String OID_ATRI_ENT_4 = "oid_atri_ent_4";

	public static final String OID_ATRI_ENT_5 = "oid_atri_ent_5";

	public static final String OID_VAL_ATRI_1 = "oid_valor_atri_1";

	public static final String OID_VAL_ATRI_2 = "oid_valor_atri_2";

	public static final String OID_VAL_ATRI_3 = "oid_valor_atri_3";

	public static final String OID_VAL_ATRI_4 = "oid_valor_atri_4";

	public static final String OID_VAL_ATRI_5 = "oid_valor_atri_5";

	public static final String TOMAR_CUENTA = "tomar_cuenta";

	public static final String OID_AI = "oid_ai";

	public static final String OID_ANA_CON = "oid_ana_con";

	public static final int SELECT_BY_CRITERIO_SEL_CTA = 100;

	public static final int SELECT_BY_ATRIBUTOS = 101;

	public DBValoresAtriCriterioImpu() {
	}

	protected void insert(IObjetoPersistente objetoPersistente)
			throws BaseException, SQLException {

		final int OID_VAL_ATRI_ENT = 1;
		final int OID_CRI_SEL_CTA = 2;
		final int OID_ATRI_ENT_1 = 3;
		final int OID_ATRI_ENT_2 = 4;
		final int OID_ATRI_ENT_3 = 5;
		final int OID_ATRI_ENT_4 = 6;
		final int OID_ATRI_ENT_5 = 7;
		final int OID_VAL_ATRI_1 = 8;
		final int OID_VAL_ATRI_2 = 9;
		final int OID_VAL_ATRI_3 = 10;
		final int OID_VAL_ATRI_4 = 11;
		final int OID_VAL_ATRI_5 = 12;
		final int TOMAR_CUENTA = 13;
		final int OID_AI = 14;
		final int OID_ANA_CON = 15;

		ValoresAtriCriterioImpu pers = (ValoresAtriCriterioImpu) objetoPersistente;

		StringBuffer sqlInsert = new StringBuffer();
		sqlInsert.append(" insert into cgValAtrCriImpu " + " ( "
				+ "OID_VAL_ATRI_ENT," + "OID_CRI_SEL_CTA," + "OID_ATRI_ENT_1,"
				+ "OID_ATRI_ENT_2," + "OID_ATRI_ENT_3," + "OID_ATRI_ENT_4,"
				+ "OID_ATRI_ENT_5," + "OID_VALOR_ATRI_1," + "OID_VALOR_ATRI_2,"
				+ "OID_VALOR_ATRI_3," + "OID_VALOR_ATRI_4,"
				+ "OID_VALOR_ATRI_5," + "TOMAR_CUENTA," + "OID_AI,"
				+ "OID_ANA_CON)" + " values " + "(" + "?," + "?," + "?," + "?,"
				+ "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?,"
				+ "?," + "?) ");

		PreparedStatement qInsert = getSesion().getConexionBD()
				.prepareStatement(sqlInsert.toString());
		qInsert.setInt(OID_VAL_ATRI_ENT, pers.getOID());
		qInsert.setInt(OID_CRI_SEL_CTA, pers.getCriterio_sel_cta().getOID());
		if (pers.getAtri_ent_1() != null)
			qInsert.setInt(OID_ATRI_ENT_1, pers.getAtri_ent_1().getOID());
		else
			qInsert.setNull(OID_ATRI_ENT_1, java.sql.Types.INTEGER);
		if (pers.getAtri_ent_2() != null)
			qInsert.setInt(OID_ATRI_ENT_2, pers.getAtri_ent_2().getOID());
		else
			qInsert.setNull(OID_ATRI_ENT_2, java.sql.Types.INTEGER);
		if (pers.getAtri_ent_3() != null)
			qInsert.setInt(OID_ATRI_ENT_3, pers.getAtri_ent_3().getOID());
		else
			qInsert.setNull(OID_ATRI_ENT_3, java.sql.Types.INTEGER);
		if (pers.getAtri_ent_4() != null)
			qInsert.setInt(OID_ATRI_ENT_4, pers.getAtri_ent_4().getOID());
		else
			qInsert.setNull(OID_ATRI_ENT_4, java.sql.Types.INTEGER);
		if (pers.getAtri_ent_5() != null)
			qInsert.setInt(OID_ATRI_ENT_5, pers.getAtri_ent_5().getOID());
		else
			qInsert.setNull(OID_ATRI_ENT_5, java.sql.Types.INTEGER);
		if (pers.getVal_atri_1() != null)
			qInsert.setInt(OID_VAL_ATRI_1, pers.getVal_atri_1().getOID());
		else
			qInsert.setNull(OID_VAL_ATRI_1, java.sql.Types.INTEGER);
		if (pers.getVal_atri_2() != null)
			qInsert.setInt(OID_VAL_ATRI_2, pers.getVal_atri_2().getOID());
		else
			qInsert.setNull(OID_VAL_ATRI_2, java.sql.Types.INTEGER);
		if (pers.getVal_atri_3() != null)
			qInsert.setInt(OID_VAL_ATRI_3, pers.getVal_atri_3().getOID());
		else
			qInsert.setNull(OID_VAL_ATRI_3, java.sql.Types.INTEGER);
		if (pers.getVal_atri_4() != null)
			qInsert.setInt(OID_VAL_ATRI_4, pers.getVal_atri_4().getOID());
		else
			qInsert.setNull(OID_VAL_ATRI_4, java.sql.Types.INTEGER);
		if (pers.getVal_atri_5() != null)
			qInsert.setInt(OID_VAL_ATRI_5, pers.getVal_atri_5().getOID());
		else
			qInsert.setNull(OID_VAL_ATRI_5, java.sql.Types.INTEGER);
		qInsert.setString(TOMAR_CUENTA, pers.getTomar_cuenta());
		if (pers.getCuenta_imputable() != null)
			qInsert.setInt(OID_AI, pers.getCuenta_imputable().getOID());
		else
			qInsert.setNull(OID_AI, java.sql.Types.INTEGER);
		if (pers.getCuenta_contable() != null)
			qInsert.setInt(OID_ANA_CON, pers.getCuenta_contable().getOID());
		else
			qInsert.setNull(OID_ANA_CON, Types.INTEGER);
		qInsert.executeUpdate();
		qInsert.close();
	}

	protected void update(IObjetoPersistente objetoPersistente)
			throws BaseException, SQLException {

		final int OID_CRI_SEL_CTA = 1;
		final int OID_ATRI_ENT_1 = 2;
		final int OID_ATRI_ENT_2 = 3;
		final int OID_ATRI_ENT_3 = 4;
		final int OID_ATRI_ENT_4 = 5;
		final int OID_ATRI_ENT_5 = 6;
		final int OID_VAL_ATRI_1 = 7;
		final int OID_VAL_ATRI_2 = 8;
		final int OID_VAL_ATRI_3 = 9;
		final int OID_VAL_ATRI_4 = 10;
		final int OID_VAL_ATRI_5 = 11;
		final int TOMAR_CUENTA = 12;
		final int OID_AI = 13;
		final int OID_ANA_CON = 14;
		final int OID_VAL_ATRI_ENT = 15;

		ValoresAtriCriterioImpu pers = (ValoresAtriCriterioImpu) objetoPersistente;

		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append(" update cgValAtrCriImpu set " + "oid_cri_sel_cta=?"
				+ ",oid_atri_ent_1=?" + ",oid_atri_ent_2=?"
				+ ",oid_atri_ent_3=?" + ",oid_atri_ent_4=?"
				+ ",oid_atri_ent_5=?" + ",oid_valor_atri_1=?"
				+ ",oid_valor_atri_2=?" + ",oid_valor_atri_3=?"
				+ ",oid_valor_atri_4=?" + ",oid_valor_atri_5=?"
				+ ",tomar_cuenta=?" + ",oid_ai=?" + ",oid_ana_con=?"
				+ " where " + " oid_val_atri_ent=? ");

		PreparedStatement qUpdate = getSesion().getConexionBD()
				.prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_VAL_ATRI_ENT, pers.getOID());
		qUpdate.setInt(OID_CRI_SEL_CTA, pers.getCriterio_sel_cta().getOID());
		if (pers.getAtri_ent_1() != null)
			qUpdate.setInt(OID_ATRI_ENT_1, pers.getAtri_ent_1().getOID());
		else
			qUpdate.setNull(OID_ATRI_ENT_1, java.sql.Types.INTEGER);
		if (pers.getAtri_ent_2() != null)
			qUpdate.setInt(OID_ATRI_ENT_2, pers.getAtri_ent_2().getOID());
		else
			qUpdate.setNull(OID_ATRI_ENT_2, java.sql.Types.INTEGER);
		if (pers.getAtri_ent_3() != null)
			qUpdate.setInt(OID_ATRI_ENT_3, pers.getAtri_ent_3().getOID());
		else
			qUpdate.setNull(OID_ATRI_ENT_3, java.sql.Types.INTEGER);
		if (pers.getAtri_ent_4() != null)
			qUpdate.setInt(OID_ATRI_ENT_4, pers.getAtri_ent_4().getOID());
		else
			qUpdate.setNull(OID_ATRI_ENT_4, java.sql.Types.INTEGER);
		if (pers.getAtri_ent_5() != null)
			qUpdate.setInt(OID_ATRI_ENT_5, pers.getAtri_ent_5().getOID());
		else
			qUpdate.setNull(OID_ATRI_ENT_5, java.sql.Types.INTEGER);
		if (pers.getVal_atri_1() != null)
			qUpdate.setInt(OID_VAL_ATRI_1, pers.getVal_atri_1().getOID());
		else
			qUpdate.setNull(OID_VAL_ATRI_1, java.sql.Types.INTEGER);
		if (pers.getVal_atri_2() != null)
			qUpdate.setInt(OID_VAL_ATRI_2, pers.getVal_atri_2().getOID());
		else
			qUpdate.setNull(OID_VAL_ATRI_2, java.sql.Types.INTEGER);
		if (pers.getVal_atri_3() != null)
			qUpdate.setInt(OID_VAL_ATRI_3, pers.getVal_atri_3().getOID());
		else
			qUpdate.setNull(OID_VAL_ATRI_3, java.sql.Types.INTEGER);
		if (pers.getVal_atri_4() != null)
			qUpdate.setInt(OID_VAL_ATRI_4, pers.getVal_atri_4().getOID());
		else
			qUpdate.setNull(OID_VAL_ATRI_4, java.sql.Types.INTEGER);
		if (pers.getVal_atri_5() != null)
			qUpdate.setInt(OID_VAL_ATRI_5, pers.getVal_atri_5().getOID());
		else
			qUpdate.setNull(OID_VAL_ATRI_5, java.sql.Types.INTEGER);
		qUpdate.setString(TOMAR_CUENTA, pers.getTomar_cuenta());
		if (pers.getCuenta_imputable() != null)
			qUpdate.setInt(OID_AI, pers.getCuenta_imputable().getOID());
		else
			qUpdate.setNull(OID_AI, java.sql.Types.INTEGER);
		if (pers.getCuenta_contable() != null)
			qUpdate.setInt(OID_ANA_CON, pers.getCuenta_contable().getOID());
		else
			qUpdate.setNull(OID_ANA_CON, Types.INTEGER);

		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void delete(IObjetoPersistente objetoPersistente)
			throws BaseException, SQLException {
		final int OID_VAL_ATRI_ENT = 1;
		ValoresAtriCriterioImpu pers = (ValoresAtriCriterioImpu) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("delete from cgValAtrCriImpu " + " where "
				+ " oid_val_atri_ent=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD()
				.prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_VAL_ATRI_ENT, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void rehabilitar(IObjetoPersistente objetoPersistente)
			throws BaseException, SQLException {
		final int OID_VAL_ATRI_ENT = 1;
		ValoresAtriCriterioImpu pers = (ValoresAtriCriterioImpu) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update cgValAtrCriImpu " + " set activo=1 "
				+ " where " + " oid_val_atri_ent=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD()
				.prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_VAL_ATRI_ENT, pers.getOID());
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
		case SELECT_BY_CRITERIO_SEL_CTA: {
			ps = this.selectByCriterioSelCta(aCondiciones);
			break;
		}
		case SELECT_BY_ATRIBUTOS: {
			ps = this.selectByAtributos(aCondiciones);
			break;
		}
		}
		return ps;
	}

	private PreparedStatement selectByOID(Object aCondiciones)
			throws BaseException, SQLException {

		final int OID_VAL_ATRI_ENT = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cgValAtrCriImpu ");
		textSQL.append(" WHERE oid_val_atri_ent = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD()
				.prepareStatement(textSQL.toString());
		int oid = ((Integer) aCondiciones).intValue();
		querySelect.setInt(OID_VAL_ATRI_ENT, oid);
		return querySelect;
	}

	private PreparedStatement selectByCriterioSelCta(Object aCondiciones)
			throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cgValAtrCriImpu ");
		textSQL.append(" WHERE oid_cri_sel_cta = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD()
				.prepareStatement(textSQL.toString());
		CriterioSelCuenta criterioSelCuenta = (CriterioSelCuenta) aCondiciones;
		querySelect.setInt(1, criterioSelCuenta.getOID());
		return querySelect;
	}

	private PreparedStatement selectByCodigo(Object aCondiciones)
			throws BaseException, SQLException {

		final int CODIGO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cgValAtrCriImpu ");
		textSQL.append(" WHERE  = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD()
				.prepareStatement(textSQL.toString());
		String codigo = (String) aCondiciones;
		querySelect.setString(CODIGO, codigo);
		return querySelect;
	}

	private PreparedStatement selectByAtributos(Object aCondiciones)
			throws BaseException, SQLException {

		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		CriterioSelCuenta criterioSelCta = (CriterioSelCuenta)condiciones.get(CriterioSelCuenta.NICKNAME);
		IObjetoLogico objLog = (IObjetoLogico) condiciones.get("OBJETO_LOGICO");
		StringBuffer condValAtri = new StringBuffer();
		
		int i=0;
		Iterator iterAtriSel = criterioSelCta.getAtributosEntSel().iterator();
		while (iterAtriSel.hasNext()) {
			AtributoEntidadSeleccionado atriEntSel = (AtributoEntidadSeleccionado) iterAtriSel.next();
			IObjetoLogico objLogAtri = objLog.getAtributoObjLog(atriEntSel.getAtributo_entidad().getSignature());
			++i;
			condValAtri.append(" and oid_atri_ent_"+new Integer(i)+"="+atriEntSel.getAtributo_entidad().getOIDInteger().toString()+
					           " and oid_valor_atri_"+new Integer(i)+"="+objLogAtri.getOIDInteger().toString()+" ");
		}
		
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cgValAtrCriImpu ");
		textSQL.append(" WHERE oid_cri_sel_cta = "+criterioSelCta.getOIDInteger().toString());
		textSQL.append(condValAtri); 
		PreparedStatement querySelect = getSesion().getConexionBD()
				.prepareStatement(textSQL.toString());
		return querySelect;
	}

	private PreparedStatement selectAllHelp(Object aCondiciones)
			throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();

		textSQL
				.append("SELECT oid_val_atri_ent oid, codigo,  descripcion ,activo ");
		textSQL.append(" from cgValAtrCriImpu");

		PreparedStatement querySelect = getSesion().getConexionBD()
				.prepareStatement(textSQL.toString());
		return querySelect;
	}

	public static List getValoresAtriCriterioImpu(
			CriterioSelCuenta criterioSelCuenta, ISesion aSesion)
			throws BaseException {
		return (List) ObjetoLogico.getObjects(ValoresAtriCriterioImpu.NICKNAME,
				DBValoresAtriCriterioImpu.SELECT_BY_CRITERIO_SEL_CTA,
				criterioSelCuenta, new ListObserver(), aSesion);
	}
	
	  public static ValoresAtriCriterioImpu getValorAtriCriImpu(CriterioSelCuenta criterioSelCta,
			  													IObjetoLogico objetoLogico,
			  													ISesion aSesion)
	          throws BaseException {
		  HashTableDatos condiciones = new HashTableDatos();
		  condiciones.put(CriterioSelCuenta.NICKNAME,criterioSelCta);
		  condiciones.put("OBJETO_LOGICO",objetoLogico);
		  
		  return (ValoresAtriCriterioImpu) ObjetoLogico.getObjects(ValoresAtriCriterioImpu.NICKNAME,
				  				DBValoresAtriCriterioImpu.SELECT_BY_ATRIBUTOS,
				  				condiciones,
				  				new ObjetoObservado(),
				  				aSesion);
	  }
	

}
