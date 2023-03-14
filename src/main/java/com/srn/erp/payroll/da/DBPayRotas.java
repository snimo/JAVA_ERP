package com.srn.erp.payroll.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.payroll.bm.PayRotas;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;

public class DBPayRotas extends DBObjetoPersistente {

  public static final String TRACODIGO = "tracodigo";
  public static final String TRADESCRIP = "tradescrip";
  public static final String TRAHORAINI = "trahoraini";
  public static final String TRAHORAFIN  = "trahorafin";
  
  private static final int SELECT_ALL = 100;

  public DBPayRotas() { 
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
      case DBPayRotas.SELECT_ALL: { 
          ps = this.findAll(aCondiciones); 
          break; 
       } 
    } 
    return ps;
  } 

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  pay_rotas "); 
    textSQL.append(" WHERE  = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    return querySelect; 
  }
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  pay_rotas "); 
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT  oid, codigo,  descripcion ,activo ");
    textSQL.append(" from pay_rotas");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  }
  
  private PreparedStatement findAll(Object aCondiciones) throws BaseException, SQLException {

	    StringBuffer textSQL = new StringBuffer();

	    textSQL.append("SELECT * from pay_rotas");
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
	    return querySelect; 
  }

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static List<PayRotas> findAll(ISesion aSesion) throws BaseException {
		return (List<PayRotas>) ObjetoLogico.getObjects(PayRotas.NICKNAME,
	           DBPayRotas.SELECT_ALL,
	           null,
	           new ListObserver(),
	           aSesion);
	}

	@Override
	protected void insert(IObjetoPersistente objetoPersistente)
			throws BaseException, SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	protected void delete(IObjetoPersistente objetoPersistente)
			throws BaseException, SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	protected void update(IObjetoPersistente objetoPersistente)
			throws BaseException, SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	protected void rehabilitar(IObjetoPersistente objetoPersistente)
			throws BaseException, SQLException {
		// TODO Auto-generated method stub

	}
  
} 