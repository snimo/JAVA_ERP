package com.srn.erp.payroll.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.payroll.bm.PaySectores;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.applicarionServer.bm.Parametros.ValorParametro;
import framework.request.bl.Utils.BaseException;

public class DBPaySectores extends DBObjetoPersistente {

	public static final String CODIGO = "codigo";
	public static final String DESCRIP = "descrip";

	private static final int SELECT_ALL_SECTORES = 100;
	private static final int SELECT_BY_EMPRESA = 101;

	public DBPaySectores() {
	}

	public PreparedStatement prepararSelect(int aSelect, Object aCondiciones) throws BaseException, SQLException {
		PreparedStatement ps = null;
		switch (aSelect) {
			case IDBObjetoPersistente.SELECT_BY_CODIGO: {
				ps = this.selectByCodigo(aCondiciones);
				break;
			}
			case IDBObjetoPersistente.SELECT_ALL_HELP: {
				ps = this.selectAllHelp(aCondiciones);
				break;
			}
			case DBPaySectores.SELECT_ALL_SECTORES: {
				ps = this.findAll(aCondiciones);
				break;
			}
			case DBPaySectores.SELECT_BY_EMPRESA: {
				ps = this.findByEmpresa(aCondiciones);
				break;
			}
		}
		return ps;
	}

	private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {
		
		final int CODIGO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  pay_sectores ");
		textSQL.append(" WHERE  = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		String codigo = (String) aCondiciones;
		querySelect.setString(CODIGO, codigo);
		return querySelect;
	}

	private PreparedStatement findAll(Object aCondiciones) throws BaseException, SQLException {
		
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  pay_sectores ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}

	private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();

		textSQL.append("SELECT  oid, codigo,  descripcion ,activo ");
		textSQL.append(" from pay_sectores");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}

	private PreparedStatement findByEmpresa(Object aCondiciones) throws BaseException, SQLException {
		
		String esquema = ValorParametro.findByCodigoParametro("USU_PAYROLL_PROD", this.getSesion()).getValorCadena();
		if (!("").equals(esquema) && esquema != null) {
			esquema = esquema + ".";
		}
		else
		{
			esquema = "";
		}
		String dbLlink = ValorParametro.findByCodigoParametro("DATABASE_LINK_PAYROLL", this.getSesion()).getValorCadena();
		if (!("").equals(dbLlink) && dbLlink != null) {
			dbLlink = "@" + dbLlink;
		}
		else
		{
			dbLlink = "";
		}
		
		String oid_empresa = (String) aCondiciones;
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("select * from Pay_Sectores where codigo in ");
		textSQL.append("(select distinct cencos from " + esquema + "remples" + dbLlink + " where empresa = '" + oid_empresa + "')");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
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

	@SuppressWarnings("rawtypes")
	public static List findAll(ISesion aSesion) throws BaseException {
		return (List) ObjetoLogico.getObjects(PaySectores.NICKNAME, DBPaySectores.SELECT_ALL_SECTORES, null, new ListObserver(), aSesion);
	}
	
	@SuppressWarnings("rawtypes")
	public static List findByEmpresa(String oid_empresa, ISesion aSesion) throws BaseException {
		return (List) ObjetoLogico.getObjects(PaySectores.NICKNAME, DBPaySectores.SELECT_BY_EMPRESA, oid_empresa, new ListObserver(), aSesion);
	}

}
