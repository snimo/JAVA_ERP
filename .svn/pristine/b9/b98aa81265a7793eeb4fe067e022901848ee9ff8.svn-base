package com.srn.erp.payroll.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.payroll.bm.PayTareaDesempenada;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;

public class DBPayTareaDesempenada extends DBObjetoPersistente {

	public static final String CODIGO = "codigo";
	public static final String DESCRIP = "descrip";
	
	private static final int SELECT_ALL_TAREAS = 100;

	public DBPayTareaDesempenada() {
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
			case DBPayTareaDesempenada.SELECT_ALL_TAREAS: {
				ps = this.selectAll(aCondiciones);
				break;
			}
		}
		return ps;
	}

	private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

		final int CODIGO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  pay_tareas ");
		textSQL.append(" WHERE  = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		String codigo = (String) aCondiciones;
		querySelect.setString(CODIGO, codigo);
		return querySelect;
	}
	
	private PreparedStatement selectAll(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  pay_tareas ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}

	private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();

		textSQL.append("SELECT  oid, codigo,  descripcion ,activo ");
		textSQL.append(" from pay_tareas");

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
		return (List) ObjetoLogico.getObjects(PayTareaDesempenada.NICKNAME, DBPayTareaDesempenada.SELECT_ALL_TAREAS, null, new ListObserver(), aSesion);
	}

}
