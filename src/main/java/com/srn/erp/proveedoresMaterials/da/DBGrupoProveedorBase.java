package com.srn.erp.proveedoresMaterials.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.proveedoresMaterials.bm.GrupoProveedorBase;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.applicarionServer.bm.Parametros.ValorParametro;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ObjetoObservado;

public class DBGrupoProveedorBase extends DBObjetoPersistente {

	public static final String ID = "id";
	public static final String NOMBRE = "nombre";

	public static final int SELECT_BY_ID_UTE = 100;
	public static final int SELECT_BY_ID_BINBAIRES = 101;
	public static final int SELECT_BY_ID_ALAVERA = 102;
	public static final int SELECT_BY_ID_MAGIC = 103;
	public static final int SELECT_ALL_UTE = 104;
	public static final int SELECT_ALL_BINBAIRES = 105;
	public static final int SELECT_ALL_ALAVERA = 106;
	public static final int SELECT_ALL_MAGIC = 107;

	public DBGrupoProveedorBase() {
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
		case SELECT_BY_ID_UTE: {
			ps = this.selectByIdUte(aCondiciones);
			break;
		}
		case SELECT_BY_ID_BINBAIRES: {
			ps = this.selectByIdBinbaires(aCondiciones);
			break;
		}
		case SELECT_BY_ID_ALAVERA: {
			ps = this.selectByIdAlavera(aCondiciones);
			break;
		}
		case SELECT_BY_ID_MAGIC: {
			ps = this.selectByIdMagic(aCondiciones);
			break;
		}
		case SELECT_ALL_UTE: {
			ps = this.selectAllUte(aCondiciones);
			break;
		}
		case SELECT_ALL_BINBAIRES: {
			ps = this.selectAllBinbaires(aCondiciones);
			break;
		}
		case SELECT_ALL_ALAVERA: {
			ps = this.selectAllAlavera(aCondiciones);
			break;
		}
		case SELECT_ALL_MAGIC: {
			ps = this.selectAllMagic(aCondiciones);
			break;
		}
		}
		return ps;
	}

	private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

		final int ID = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  SUPPLIERGR ");
		textSQL.append(" WHERE id = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		int oid = ((Integer) aCondiciones).intValue();
		querySelect.setInt(ID, oid);
		return querySelect;
	}

	private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

		final int CODIGO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  SUPPLIERGR ");
		textSQL.append(" WHERE  = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		String codigo = (String) aCondiciones;
		querySelect.setString(CODIGO, codigo);
		return querySelect;
	}

	private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();

		textSQL.append("SELECT id oid, codigo,  descripcion ,activo ");
		textSQL.append(" from V_SUPPLIERGR");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}

	private PreparedStatement selectByIdUte(Object aCondiciones) throws BaseException, SQLException {

		String esquema = ValorParametro.findByCodigoParametro("ESQUEMA_MATERIAL_UTE", this.getSesion()).getValorCadena();
		if (!("").equals(esquema) && esquema != null) {
			esquema = esquema + ".";
		} else {
			esquema = "";
		}
		String dbLlink = ValorParametro.findByCodigoParametro("DB_LINK_UTE_MATERIAL", this.getSesion()).getValorCadena();
		if (!("").equals(dbLlink) && dbLlink != null) {
			dbLlink = "@" + dbLlink;
		} else {
			dbLlink = "";
		}

		Integer id = (Integer) aCondiciones;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT SUG_ID id, SUG_NAME nombre FROM " + esquema + "SUPPLIERGR"+ dbLlink);
		textSQL.append(" WHERE SUG_ID = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		querySelect.setInt(1, id);
		return querySelect;
	}

	private PreparedStatement selectByIdBinbaires(Object aCondiciones) throws BaseException, SQLException {

		String esquema = ValorParametro.findByCodigoParametro("ESQUEMA_MATERIAL_BINBAIRES", this.getSesion()).getValorCadena();
		if (!("").equals(esquema) && esquema != null) {
			esquema = esquema + ".";
		} else {
			esquema = "";
		}
		String dbLlink = ValorParametro.findByCodigoParametro("DB_LINK_BINBAIRES_MATERIAL", this.getSesion()).getValorCadena();
		if (!("").equals(dbLlink) && dbLlink != null) {
			dbLlink = "@" + dbLlink;
		} else {
			dbLlink = "";
		}

		Integer id = (Integer) aCondiciones;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT SUG_ID id, SUG_NAME nombre FROM " + esquema + "SUPPLIERGR"+ dbLlink);
		textSQL.append(" WHERE SUG_ID = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		querySelect.setInt(1, id);
		return querySelect;
	}

	private PreparedStatement selectByIdAlavera(Object aCondiciones) throws BaseException, SQLException {

		String esquema = ValorParametro.findByCodigoParametro("ESQUEMA_MATERIAL_ALAVERA", this.getSesion()).getValorCadena();
		if (!("").equals(esquema) && esquema != null) {
			esquema = esquema + ".";
		} else {
			esquema = "";
		}
		String dbLlink = ValorParametro.findByCodigoParametro("DB_LINK_ALAVERA_MATERIAL", this.getSesion()).getValorCadena();
		if (!("").equals(dbLlink) && dbLlink != null) {
			dbLlink = "@" + dbLlink;
		} else {
			dbLlink = "";
		}

		Integer id = (Integer) aCondiciones;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT SUG_ID id, SUG_NAME nombre FROM " + esquema + "SUPPLIERGR"+ dbLlink);
		textSQL.append(" WHERE SUG_ID = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		querySelect.setInt(1, id);
		return querySelect;
	}

	private PreparedStatement selectByIdMagic(Object aCondiciones) throws BaseException, SQLException {

		String esquema = ValorParametro.findByCodigoParametro("ESQUEMA_MATERIAL_MAGIC", this.getSesion()).getValorCadena();
		if (!("").equals(esquema) && esquema != null) {
			esquema = esquema + ".";
		} else {
			esquema = "";
		}
		String dbLlink = ValorParametro.findByCodigoParametro("DB_LINK_MAGIC_MATERIAL", this.getSesion()).getValorCadena();
		if (!("").equals(dbLlink) && dbLlink != null) {
			dbLlink = "@" + dbLlink;
		} else {
			dbLlink = "";
		}

		Integer id = (Integer) aCondiciones;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT SUG_ID id, SUG_NAME nombre FROM " + esquema + "SUPPLIERGR"+ dbLlink);
		textSQL.append(" WHERE SUG_ID = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		querySelect.setInt(1, id);
		return querySelect;
	}
	
	private PreparedStatement selectAllMagic(Object aCondiciones) throws BaseException, SQLException {

		String esquema = ValorParametro.findByCodigoParametro("ESQUEMA_MATERIAL_MAGIC", this.getSesion()).getValorCadena();
		if (!("").equals(esquema) && esquema != null) {
			esquema = esquema + ".";
		} else {
			esquema = "";
		}
		String dbLlink = ValorParametro.findByCodigoParametro("DB_LINK_MAGIC_MATERIAL", this.getSesion()).getValorCadena();
		if (!("").equals(dbLlink) && dbLlink != null) {
			dbLlink = "@" + dbLlink;
		} else {
			dbLlink = "";
		}

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT SUG_ID id, SUG_NAME nombre FROM  " + esquema + "SUPPLIERGR" + dbLlink);
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}
	
	private PreparedStatement selectAllUte(Object aCondiciones) throws BaseException, SQLException {
		String esquema = ValorParametro.findByCodigoParametro("ESQUEMA_MATERIAL_UTE", this.getSesion()).getValorCadena();
		if (!("").equals(esquema) && esquema != null) {
			esquema = esquema + ".";
		} else {
			esquema = "";
		}
		String dbLlink = ValorParametro.findByCodigoParametro("DB_LINK_UTE_MATERIAL", this.getSesion()).getValorCadena();
		if (!("").equals(dbLlink) && dbLlink != null) {
			dbLlink = "@" + dbLlink;
		} else {
			dbLlink = "";
		}

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT SUG_ID id, SUG_NAME nombre FROM  " + esquema + "SUPPLIERGR" + dbLlink);
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}

	private PreparedStatement selectAllBinbaires(Object aCondiciones) throws BaseException, SQLException {
		String esquema = ValorParametro.findByCodigoParametro("ESQUEMA_MATERIAL_BINBAIRES", this.getSesion()).getValorCadena();
		if (!("").equals(esquema) && esquema != null) {
			esquema = esquema + ".";
		} else {
			esquema = "";
		}
		String dbLlink = ValorParametro.findByCodigoParametro("DB_LINK_BINBAIRES_MATERIAL", this.getSesion()).getValorCadena();
		if (!("").equals(dbLlink) && dbLlink != null) {
			dbLlink = "@" + dbLlink;
		} else {
			dbLlink = "";
		}

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT SUG_ID id, SUG_NAME nombre FROM  " + esquema + "SUPPLIERGR" + dbLlink);
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}

	private PreparedStatement selectAllAlavera(Object aCondiciones) throws BaseException, SQLException {
		String esquema = ValorParametro.findByCodigoParametro("ESQUEMA_MATERIAL_ALAVERA", this.getSesion()).getValorCadena();
		if (!("").equals(esquema) && esquema != null) {
			esquema = esquema + ".";
		} else {
			esquema = "";
		}
		String dbLlink = ValorParametro.findByCodigoParametro("DB_LINK_ALAVERA_MATERIAL", this.getSesion()).getValorCadena();
		if (!("").equals(dbLlink) && dbLlink != null) {
			dbLlink = "@" + dbLlink;
		} else {
			dbLlink = "";
		}

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT SUG_ID id, SUG_NAME nombre FROM  " + esquema + "SUPPLIERGR" + dbLlink);
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}

	public static GrupoProveedorBase getByCuitUte(Integer id, ISesion aSesion) throws BaseException {
		return (GrupoProveedorBase) ObjetoLogico.getObjects(GrupoProveedorBase.NICKNAME, 
				DBGrupoProveedorBase.SELECT_BY_ID_UTE, id, new ObjetoObservado(), aSesion);
	}

	public static GrupoProveedorBase getByCuitBinbaires(Integer id, ISesion aSesion) throws BaseException {
		return (GrupoProveedorBase) ObjetoLogico.getObjects(GrupoProveedorBase.NICKNAME, 
				DBGrupoProveedorBase.SELECT_BY_ID_BINBAIRES, id, new ObjetoObservado(), aSesion);
	}

	public static GrupoProveedorBase getByCuitAlavera(Integer id, ISesion aSesion) throws BaseException {
		return (GrupoProveedorBase) ObjetoLogico.getObjects(GrupoProveedorBase.NICKNAME, 
				DBGrupoProveedorBase.SELECT_BY_ID_ALAVERA, id, new ObjetoObservado(), aSesion);
	}

	public static GrupoProveedorBase getByCuitMagic(Integer id, ISesion aSesion) throws BaseException {
		return (GrupoProveedorBase) ObjetoLogico.getObjects(GrupoProveedorBase.NICKNAME, 
				DBGrupoProveedorBase.SELECT_BY_ID_MAGIC, id, new ObjetoObservado(), aSesion);
	}
	
	public static List getAllUte(ISesion aSesion) throws BaseException {
		return (List) ObjetoLogico.getObjects(GrupoProveedorBase.NICKNAME, 
				DBGrupoProveedorBase.SELECT_ALL_UTE, null, new ListObserver(), aSesion);
	}

	public static List getAllBinbaires(ISesion aSesion) throws BaseException {
		return (List) ObjetoLogico.getObjects(GrupoProveedorBase.NICKNAME, 
				DBGrupoProveedorBase.SELECT_ALL_BINBAIRES, null, new ListObserver(), aSesion);
	}

	public static List getAllAlavera(ISesion aSesion) throws BaseException {
		return (List) ObjetoLogico.getObjects(GrupoProveedorBase.NICKNAME, 
				DBGrupoProveedorBase.SELECT_ALL_ALAVERA, null, new ListObserver(), aSesion);
	}

	public static List getAllMagic(ISesion aSesion) throws BaseException {
		return (List) ObjetoLogico.getObjects(GrupoProveedorBase.NICKNAME, 
				DBGrupoProveedorBase.SELECT_ALL_MAGIC, null, new ListObserver(), aSesion);
	}

	@Override
	protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		// TODO Auto-generated method stub

	}

}
