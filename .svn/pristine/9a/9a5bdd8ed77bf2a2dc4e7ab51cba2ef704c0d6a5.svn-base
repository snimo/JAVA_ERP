package com.srn.erp.tesoreria.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.StringTokenizer;

import com.srn.erp.general.bm.PeriodoInc;
import com.srn.erp.general.bm.PeriodoIncDet;
import com.srn.erp.general.da.DBPeriodoIncDet;
import com.srn.erp.stock.bm.Producto;
import com.srn.erp.stock.da.DBProducto;
import com.srn.erp.tesoreria.bm.Banco;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;

public class DBBanco extends DBObjetoPersistente {

  public static final String OID_BANCO = "oid_banco";
  public static final String CODIGO = "codigo";
  public static final String DESCRIPCION = "descripcion";
  public static final String ACTIVO = "activo";
  
  public static final int SELECT_BY_HELP_BANCO = 100;

  public DBBanco() {
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

    final int OID_BANCO = 1;
    final int CODIGO = 2;
    final int DESCRIPCION = 3;
    final int ACTIVO = 4;

    Banco pers = (Banco) objetoPersistente;

    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into vaBancos "+
                     " ( "+
                      "OID_BANCO,"+
                      "CODIGO,"+
                      "DESCRIPCION,"+
                      "ACTIVO)"+
                      " values "+
                      "("+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
    qInsert.setInt(OID_BANCO,pers.getOID());
    qInsert.setString(CODIGO,pers.getCodigo());
    qInsert.setString(DESCRIPCION,pers.getDescripcion());
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

    final int CODIGO = 1;
    final int DESCRIPCION = 2;
    final int ACTIVO = 3;
    final int OID_BANCO = 4;

    Banco pers = (Banco) objetoPersistente;

    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update vaBancos set "+
              "codigo=?"+
              ",descripcion=?"+
              ",activo=?"+
                 " where " +
                 " oid_banco=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_BANCO,pers.getOID());
    qUpdate.setString(CODIGO,pers.getCodigo());
    qUpdate.setString(DESCRIPCION,pers.getDescripcion());
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.executeUpdate();
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    final int OID_BANCO = 1;
    Banco pers = (Banco) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("update vaBancos "+
                     " set activo=0 " +
                     " where " +
                     " oid_banco=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_BANCO, pers.getOID());
    qUpdate.executeUpdate();
    qUpdate.close();
  }

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    final int OID_BANCO = 1;
    Banco pers = (Banco) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("update vaBancos "+
                     " set activo=1 " +
                     " where " +
                     " oid_banco=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_BANCO, pers.getOID());
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
      case SELECT_BY_HELP_BANCO: {
        ps = this.selectByHelpBancos(aCondiciones);
        break;
      }
      case SELECT_ALL_ACTIVOS: {
          ps = this.selectByAllActivos(aCondiciones);
          break;
      }
      
    }
    return ps;
  }

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

    final int OID_BANCO = 1;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  vaBancos ");
    textSQL.append(" WHERE oid_banco = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    int oid = ( (Integer) aCondiciones).intValue();
    querySelect.setInt(OID_BANCO, oid);
    return querySelect;
  }
  
  private PreparedStatement selectByHelpBancos(Object aCondiciones) throws BaseException, SQLException {
    final int CODIGO = 1;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  vaBancos ");
    textSQL.append(" WHERE 1=1 ");
    
    HashTableDatos condiciones = (HashTableDatos)aCondiciones;
    
		if (condiciones.containsKey("descripcion")) {
			StringTokenizer st = new StringTokenizer(condiciones.getString("descripcion"), " ");
			while (st.hasMoreTokens()) {
				String next = st.nextToken().toUpperCase();
				
				if (next.contains(",")) {
					textSQL.append(" and (1=2 ");
					StringTokenizer st1 = new StringTokenizer(next, ",");
					while (st1.hasMoreTokens()) {
						String next1 = st1.nextToken().toUpperCase();
						textSQL.append(" or descripcion like '%" + next1 + "%' ");
					}
					textSQL.append(" ) ");
				} else 
					textSQL.append(" and descripcion like '%" + next + "%' ");
			}
		}
		
		if (condiciones.containsKey("codigo")) {
			StringTokenizer st = new StringTokenizer(condiciones.getString("codigo"), " ");
			while (st.hasMoreTokens()) {
				String next = st.nextToken().toUpperCase();
				textSQL.append(" and codigo like '%" + next + "%' ");
			}
		}
    
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    return querySelect;
  	
  }
  
  private PreparedStatement selectByAllActivos(Object aCondiciones) throws BaseException, SQLException {

	    StringBuffer textSQL = new StringBuffer();
	    textSQL.append("SELECT * FROM  vaBancos ");
	    textSQL.append(" WHERE activo = 1 ");
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
	    return querySelect;
  }
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

    final int CODIGO = 1;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  vaBancos ");
    textSQL.append(" WHERE codigo = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    String codigo = (String) aCondiciones;
    querySelect.setString(CODIGO, codigo);
    return querySelect;
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_banco oid,codigo codigo, descripcion descripcion ,activo ");
    textSQL.append(" from vaBancos");

    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    return querySelect;
  }
  
	public static List getHelpBancos(HashTableDatos condiciones, ISesion aSesion) throws BaseException {
		return (List) ObjetoLogico.getObjects(Banco.NICKNAME, DBBanco.SELECT_BY_HELP_BANCO, condiciones,
				new ListObserver(), aSesion);
	}

	
	public static List getAllBancosActivos(
              ISesion aSesion) throws BaseException {
		  return (List) ObjetoLogico.getObjects(Banco.NICKNAME,
                 DBBanco.SELECT_ALL,
                 null,
                 new ListObserver(),
                 aSesion);
	}

}
