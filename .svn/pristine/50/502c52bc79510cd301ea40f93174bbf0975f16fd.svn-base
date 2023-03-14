package com.srn.erp.presupuesto.da;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.presupuesto.bm.AtriCompoPresu;
import com.srn.erp.presupuesto.bm.CompoPresupuestario;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;

public class DBAtriCompoPresu extends DBObjetoPersistente {

	public static final String	OID_ATRI_PRESU					= "oid_atri_presu";

	public static final String	OID_COMPO_PRESU					= "oid_compo_presu";

	public static final String	TIPO_ATRIBUTO						= "tipo_atributo";

	public static final String	NOMBRE_LOGICO						= "nombre_logico";

	public static final String	NRO_ORDEN								= "nro_orden";

	public static final String	OID_COMPO_ATRI					= "oid_compo_atri";

	public static final String	ACTIVO									= "activo";
	
	public static final String	OBLIGATORIO							= "obligatorio";
	
	public static final String  NRO_INTERNO_ATRI        = "nro_interno_atri";
	
	public static final String  FORMATO = "formato";

	public static final int			SELECT_BY_COMPRO_PRESU	= 100;

	public DBAtriCompoPresu() {
	}

	protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_ATRI_PRESU = 1;
		final int OID_COMPO_PRESU = 2;
		final int TIPO_ATRIBUTO = 3;
		final int NOMBRE_LOGICO = 4;
		final int NRO_ORDEN = 5;
		final int OID_COMPO_ATRI = 6;
		final int ACTIVO = 7;
		final int OBLIGATORIO = 8;
		final int NRO_INTERNO_ATRI = 9;
		final int FORMATO = 10;

		AtriCompoPresu pers = (AtriCompoPresu) objetoPersistente;

		StringBuffer sqlInsert = new StringBuffer();
		sqlInsert.append(" insert into plAtriCompoPresu " + " ( " + "OID_ATRI_PRESU," + "OID_COMPO_PRESU,"
				+ "TIPO_ATRIBUTO," + "NOMBRE_LOGICO," + "NRO_ORDEN," + "OID_COMPO_ATRI," + "ACTIVO , OBLIGATORIO , NRO_INTERNO_ATRI , FORMATO)" + " values " + "(" + "?,"
				+ "?," + "?," + "?," + "?," + "?," + "?,"+ "?,"+ "?," + "?) ");

		PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
		qInsert.setInt(OID_ATRI_PRESU, pers.getOID());
		qInsert.setInt(OID_COMPO_PRESU, pers.getCompo_presu().getOID());
		qInsert.setString(TIPO_ATRIBUTO, pers.getTipo_atributo());
		qInsert.setString(NOMBRE_LOGICO, pers.getNombre_logico());
		qInsert.setInt(NRO_ORDEN, pers.getNro_orden().intValue());
		if (pers.getCompo_presu_atri() != null)
			qInsert.setInt(OID_COMPO_ATRI, pers.getCompo_presu_atri().getOID());
		else
			qInsert.setNull(OID_COMPO_ATRI, java.sql.Types.INTEGER);
		qInsert.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		qInsert.setBoolean(OBLIGATORIO, pers.isObligatorio().booleanValue());
		int proxNroInternoAtri = AtriCompoPresu.getUltNroAtri(pers.getCompo_presu(),pers.getTipo_atributo(),this.getSesion())+1;
		qInsert.setInt(NRO_INTERNO_ATRI, proxNroInternoAtri);
		qInsert.setString(FORMATO, pers.getFormato());
		qInsert.executeUpdate();
		qInsert.close();
	}

	protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_COMPO_PRESU = 1;
		final int TIPO_ATRIBUTO = 2;
		final int NOMBRE_LOGICO = 3;
		final int NRO_ORDEN = 4;
		final int OID_COMPO_ATRI = 5;
		final int ACTIVO = 6;
		final int OBLIGATORIO = 7;
		final int NRO_INTERNO_ATRI = 8;
		final int FORMATO = 9;
		final int OID_ATRI_PRESU = 10;

		AtriCompoPresu pers = (AtriCompoPresu) objetoPersistente;

		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append(" update plAtriCompoPresu set " + "oid_compo_presu=?" + ",tipo_atributo=?" + ",nombre_logico=?"
				+ ",nro_orden=?" + ",oid_compo_atri=?" + ",activo=?"+ ",obligatorio=?,nro_interno_atri=? , formato = ? " + " where " + " oid_atri_presu=? ");

		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_ATRI_PRESU, pers.getOID());
		qUpdate.setInt(OID_COMPO_PRESU, pers.getCompo_presu().getOID());
		qUpdate.setString(TIPO_ATRIBUTO, pers.getTipo_atributo());
		qUpdate.setString(NOMBRE_LOGICO, pers.getNombre_logico());
		qUpdate.setInt(NRO_ORDEN, pers.getNro_orden().intValue());
		if (pers.getCompo_presu_atri() != null)
			qUpdate.setInt(OID_COMPO_ATRI, pers.getCompo_presu_atri().getOID());
		else
			qUpdate.setNull(OID_COMPO_ATRI, java.sql.Types.INTEGER);
		qUpdate.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		qUpdate.setBoolean(OBLIGATORIO, pers.isObligatorio().booleanValue());
		qUpdate.setInt(NRO_INTERNO_ATRI, pers.getNroInternoAtri().intValue());
		qUpdate.setString(FORMATO, pers.getFormato());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_ATRI_PRESU = 1;
		AtriCompoPresu pers = (AtriCompoPresu) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update plAtriCompoPresu " + " set activo=0 " + " where " + " oid_atri_presu=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_ATRI_PRESU, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_ATRI_PRESU = 1;
		AtriCompoPresu pers = (AtriCompoPresu) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update plAtriCompoPresu " + " set activo=1 " + " where " + " oid_atri_presu=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_ATRI_PRESU, pers.getOID());
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
		case SELECT_BY_COMPRO_PRESU: {
			ps = this.selectByCompoPresu(aCondiciones);
			break;
		}
		}
		return ps;
	}

	private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

		final int OID_ATRI_PRESU = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  plAtriCompoPresu ");
		textSQL.append(" WHERE oid_atri_presu = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		int oid = ((Integer) aCondiciones).intValue();
		querySelect.setInt(OID_ATRI_PRESU, oid);
		return querySelect;
	}

	private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

		final int CODIGO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  plAtriCompoPresu ");
		textSQL.append(" WHERE  = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		String codigo = (String) aCondiciones;
		querySelect.setString(CODIGO, codigo);
		return querySelect;
	}

	private PreparedStatement selectByCompoPresu(Object aCondiciones) throws BaseException, SQLException {
		CompoPresupuestario compoPresu = (CompoPresupuestario) aCondiciones;
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  plAtriCompoPresu ");
		textSQL.append(" WHERE oid_compo_presu = ? and activo = 1 ");
		textSQL.append(" order by nro_orden ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		querySelect.setInt(1, compoPresu.getOID());
		return querySelect;
	}

	private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();

		textSQL.append("SELECT oid_atri_presu oid, codigo,  descripcion ,activo ");
		textSQL.append(" from plAtriCompoPresu");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}

	public static List getAtributosCompoPresu(CompoPresupuestario compoPresu, ISesion aSesion) throws BaseException {
		return (List) ObjetoLogico.getObjects(AtriCompoPresu.NICKNAME, DBAtriCompoPresu.SELECT_BY_COMPRO_PRESU, compoPresu,
				new ListObserver(), aSesion);
	}
	
  public static int getUltimoNroInterno(ISesion aSesion , CompoPresupuestario compo, String tipoAtributo) throws BaseException {

		 try { 
			 	StringBuffer condFiltro = new StringBuffer(" where oid_compo_presu="+compo.getOIDInteger().toString()+ " ");
			 	
			 	if ((tipoAtributo.equals(AtriCompoPresu.VALOR_TEXTO)) ||
			 			(tipoAtributo.equals(AtriCompoPresu.VALOR_TEXTO_EXTENDIDO))) 
			 			condFiltro.append(" and tipo_atributo in ('"+AtriCompoPresu.VALOR_TEXTO+"','"+AtriCompoPresu.VALOR_TEXTO_EXTENDIDO+"')");
			 	
				if ((tipoAtributo.equals(AtriCompoPresu.VALOR_DECIMAL)) ||
				 			(tipoAtributo.equals(AtriCompoPresu.VALOR_ENTERO))) 
				 			condFiltro.append(" and tipo_atributo in ('"+AtriCompoPresu.VALOR_DECIMAL+"','"+AtriCompoPresu.VALOR_ENTERO+"')");
				  					
				if (tipoAtributo.equals(AtriCompoPresu.VALOR_FECHA)) 
				 		condFiltro.append(" and tipo_atributo ='"+AtriCompoPresu.VALOR_FECHA+"' ");			 		
			 	
				if (tipoAtributo.equals(AtriCompoPresu.VALOR_COMPO)) 
			 		condFiltro.append(" and tipo_atributo ='"+AtriCompoPresu.VALOR_COMPO+"' ");			 		
			 	
			 	
		    StringBuffer textSQL = new StringBuffer();

		    textSQL.append("SELECT max(nro_interno_atri) nro_interno_atri ");
		    textSQL.append(" from plAtriCompoPresu "+condFiltro.toString());

		    PreparedStatement querySelect = aSesion.getConexionBD().prepareStatement(textSQL.toString());
		    
		    ResultSet rs = querySelect.executeQuery();
		    int ultimoNro = 0;
		    if (rs.next())
		    	ultimoNro = rs.getInt(1);
		    rs.close();
		    querySelect.close();	    
		    
		    return ultimoNro;
		 }
		 catch(Exception e) {
			 throw new BaseException(null,e.getMessage());
		 }
	  }
	

}
