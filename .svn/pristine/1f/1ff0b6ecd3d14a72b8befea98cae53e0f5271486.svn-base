package com.srn.erp.rrhh.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.srn.erp.rrhh.bm.AgrupadorAntEmp;

import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class DBAgrupadorAntEmp extends DBObjetoPersistente {

	public static final String OID_VAL_CLASIF_EMP = "oid_val_clasif_emp";
	public static final String COD_ANT_EMP = "cod_ant_emp";
	public static final String OID_AGRUPADOR = "oid_agrupador";

	public DBAgrupadorAntEmp() {
	}

	protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID = 1;
		final int OID_VAL_CLASIF_EMP = 2;
		final int COD_ANT_EMP = 3;

		AgrupadorAntEmp pers = (AgrupadorAntEmp) objetoPersistente;

		StringBuffer sqlInsert = new StringBuffer();
		sqlInsert.append(" insert into rhAgrupAntEmp " + " ( " + "OID_AGRUPADOR,OID_VAL_CLASIF_EMP," + "COD_ANT_EMP)" + " values " + "(" + "?,"+ "?," + "?) ");

		PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
		qInsert.setInt(OID, pers.getOID());
		qInsert.setInt(OID_VAL_CLASIF_EMP, pers.getValorClasifEmpresa().getOID());
		qInsert.setString(COD_ANT_EMP, pers.getCod_ant_emp());
		qInsert.executeUpdate();
		qInsert.close();
	}

	protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    AgrupadorAntEmp pers = (AgrupadorAntEmp) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update rhAgrupAntEmp set OID_VAL_CLASIF_EMP = ?, "+
              	 " cod_ant_emp=? "+ 
                 " where " +
                 " oid_agrupador=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(1,pers.getValorClasifEmpresa().getOIDInteger());
    qUpdate.setString(2,pers.getCod_ant_emp());
    qUpdate.setInt(3,pers.getOID());
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

	protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    AgrupadorAntEmp pers = (AgrupadorAntEmp) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("delete from rhAgrupAntEmp "+
                     " where " + 
                     " oid_val_clasif_emp=? ");
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
		}
		return ps;
	}

	private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 
    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  rhAgrupAntEmp "); 
    textSQL.append(" WHERE oid_val_clasif_emp = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(1, oid); 
    return querySelect; 
  }

	private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  rhAgrupAntEmp ");
		textSQL.append(" WHERE oid_val_clasif_emp = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		String codigo = (String) aCondiciones;
		querySelect.setInt(1, new Integer(codigo));
		return querySelect;
	}

	private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();

		textSQL.append("SELECT  oid, codigo,  descripcion ,activo ");
		textSQL.append(" from rhAgrupAntEmp");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}

}
