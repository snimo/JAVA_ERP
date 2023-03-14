package com.srn.erp.ventas.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import com.srn.erp.ventas.bm.Vendedor;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;

public class DBVendedor extends DBObjetoPersistente {

  public static final String OID_VENDEDOR = "oid_vendedor";
  public static final String CODIGO = "codigo";
  public static final String APELLIDO = "apellido";
  public static final String NOMBRE = "nombre";
  public static final String ACTIVO = "activo";
  public static final String MAIL = "mail";
  public static final String TELEFONO = "telefono";
  

  public DBVendedor() {
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

    final int OID_VENDEDOR = 1;
    final int CODIGO = 2;
    final int APELLIDO = 3;
    final int NOMBRE = 4;
    final int ACTIVO = 5;
    final int MAIL = 6;
    final int TELEFONO = 7;

    Vendedor pers = (Vendedor) objetoPersistente;

    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into veVendedor "+
                     " ( "+
                      "OID_VENDEDOR,"+
                      "CODIGO,"+
                      "APELLIDO,"+
                      "NOMBRE,"+
                      "ACTIVO,"+
                      "MAIL,"+
                      "TELEFONO"+
                      ")"+
                      " values "+
                      "("+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
    qInsert.setInt(OID_VENDEDOR,pers.getOID());
    qInsert.setString(CODIGO,pers.getCodigo());
    qInsert.setString(APELLIDO,pers.getApellido());
    qInsert.setString(NOMBRE,pers.getNombre());
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    
    if (pers.getMail()!=null)
    	qInsert.setString(MAIL,pers.getMail());
    else
    	qInsert.setNull(MAIL,Types.VARCHAR);
    if (pers.getTelefono()!=null)
    	qInsert.setString(TELEFONO,pers.getTelefono());
    else
    	qInsert.setNull(TELEFONO,Types.VARCHAR);
    
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

    final int CODIGO = 1;
    final int APELLIDO = 2;
    final int NOMBRE = 3;
    final int ACTIVO = 4;
    final int MAIL = 5;
    final int TELEFONO = 6;
    final int OID_VENDEDOR = 7;

    Vendedor pers = (Vendedor) objetoPersistente;

    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update veVendedor set "+
              "codigo=?"+
              ",apellido=?"+
              ",nombre=?"+
              ",activo=?"+
              ",mail=?"+
              ",telefono=?"+
                 " where " +
                 " oid_vendedor=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_VENDEDOR,pers.getOID());
    qUpdate.setString(CODIGO,pers.getCodigo());
    qUpdate.setString(APELLIDO,pers.getApellido());
    qUpdate.setString(NOMBRE,pers.getNombre());
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    
    if (pers.getMail()!=null)
    	qUpdate.setString(MAIL,pers.getMail());
    else
    	qUpdate.setNull(MAIL,Types.VARCHAR);
    if (pers.getTelefono()!=null)
    	qUpdate.setString(TELEFONO,pers.getTelefono());
    else
    	qUpdate.setNull(TELEFONO,Types.VARCHAR);
    
    
    qUpdate.executeUpdate();
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    final int OID_VENDEDOR = 1;
    Vendedor pers = (Vendedor) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("update veVendedor "+
                     " set activo=0 " +
                     " where " +
                     " oid_vendedor=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_VENDEDOR, pers.getOID());
    qUpdate.executeUpdate();
    qUpdate.close();
  }

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    final int OID_VENDEDOR = 1;
    Vendedor pers = (Vendedor) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("update veVendedor "+
                     " set activo=1 " +
                     " where " +
                     " oid_vendedor=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_VENDEDOR, pers.getOID());
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
      case IDBObjetoPersistente.SELECT_ALL : {
        ps = this.selectAll(aCondiciones);
        break;
      }
    }
    return ps;
  }

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

    final int OID_VENDEDOR = 1;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  veVendedor ");
    textSQL.append(" WHERE oid_vendedor = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    int oid = ( (Integer) aCondiciones).intValue();
    querySelect.setInt(OID_VENDEDOR, oid);
    return querySelect;
  }
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

    final int CODIGO = 1;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  veVendedor ");
    textSQL.append(" WHERE codigo = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    String codigo = (String) aCondiciones;
    querySelect.setString(CODIGO, codigo);
    return querySelect;
  }
  
  private PreparedStatement selectAll(Object aCondiciones) throws BaseException, SQLException {
    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  veVendedor ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    return querySelect;
  }
  
  
  

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_vendedor oid,codigo codigo, apellido descripcion ,activo ");
    textSQL.append(" from veVendedor");

    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    return querySelect;
  }
  
  public static List getAllVendedores(ISesion aSesion)
  throws BaseException {
  	return (List) ObjetoLogico.getObjects(Vendedor.NICKNAME,
				IDBObjetoPersistente.SELECT_ALL,
				null,
				new ListObserver(),
				aSesion);
  }
  

}
