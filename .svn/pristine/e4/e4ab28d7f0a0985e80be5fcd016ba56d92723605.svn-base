package com.srn.erp.impuestos.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.impuestos.bm.ColumnaLibroIVA;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;

public class DBColumnaLibroIVA extends DBObjetoPersistente {

  public static final String OID_COL_LIBRO_IVA = "oid_col_libro_iva";
  public static final String CODIGO = "codigo";
  public static final String DESCRIPCION = "descripcion";
  public static final String COLUMNA = "columna";
  public static final String ACTIVO = "activo";
  public static final String USAR_IVA_VTAS = "usar_iva_vtas";
  public static final String USAR_IVA_CPRAS = "usar_iva_cpras";
  
  public static final int SELECT_BY_COL_IVA_COMPRAS = 100;

  public DBColumnaLibroIVA() {
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

    final int OID_COL_LIBRO_IVA = 1;
    final int CODIGO = 2;
    final int DESCRIPCION = 3;
    final int COLUMNA = 4;
    final int ACTIVO = 5;
    final int USAR_IVA_VTAS = 6;
    final int USAR_IVA_CPRAS = 7;

    ColumnaLibroIVA pers = (ColumnaLibroIVA) objetoPersistente;

    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into imColLibroIVA "+
                     " ( "+
                      "OID_COL_LIBRO_IVA,"+
                      "CODIGO,"+
                      "DESCRIPCION,"+
                      "COLUMNA,"+
                      "ACTIVO,USAR_IVA_VTAS,USAR_IVA_CPRAS)"+
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
    qInsert.setInt(OID_COL_LIBRO_IVA,pers.getOID());
    qInsert.setString(CODIGO,pers.getCodigo());
    qInsert.setString(DESCRIPCION,pers.getDescripcion());
    qInsert.setInt(COLUMNA,pers.getColumna().intValue());
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qInsert.setBoolean(USAR_IVA_VTAS,pers.isUsarIVAVentas().booleanValue());
    qInsert.setBoolean(USAR_IVA_CPRAS,pers.isUsarIVACompras().booleanValue());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

    final int CODIGO = 1;
    final int DESCRIPCION = 2;
    final int COLUMNA = 3;
    final int ACTIVO = 4;
    final int USAR_IVA_VTAS = 5;
    final int USAR_IVA_CPRAS = 6;    
    final int OID_COL_LIBRO_IVA = 7;

    ColumnaLibroIVA pers = (ColumnaLibroIVA) objetoPersistente;

    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update imColLibroIVA set "+
              "codigo=?"+
              ",descripcion=?"+
              ",columna=?"+
              ",activo=?"+
              ",usar_iva_vtas=?"+
              ",usar_iva_cpras=?"+
                 " where " +
                 " oid_col_libro_iva=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_COL_LIBRO_IVA,pers.getOID());
    qUpdate.setString(CODIGO,pers.getCodigo());
    qUpdate.setString(DESCRIPCION,pers.getDescripcion());
    qUpdate.setInt(COLUMNA,pers.getColumna().intValue());
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.setBoolean(USAR_IVA_VTAS,pers.isUsarIVAVentas().booleanValue());
    qUpdate.setBoolean(USAR_IVA_CPRAS,pers.isUsarIVACompras().booleanValue());
    qUpdate.executeUpdate();
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    final int OID_COL_LIBRO_IVA = 1;
    ColumnaLibroIVA pers = (ColumnaLibroIVA) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("update imColLibroIVA "+
                     " set activo=0 " +
                     " where " +
                     " oid_col_libro_iva=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_COL_LIBRO_IVA, pers.getOID());
    qUpdate.executeUpdate();
    qUpdate.close();
  }

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    final int OID_COL_LIBRO_IVA = 1;
    ColumnaLibroIVA pers = (ColumnaLibroIVA) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("update imColLibroIVA "+
                     " set activo=1 " +
                     " where " +
                     " oid_col_libro_iva=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_COL_LIBRO_IVA, pers.getOID());
    qUpdate.executeUpdate();
    qUpdate.close();
  }

  public PreparedStatement prepararSelect(int aSelect, Object aCondiciones) throws BaseException, SQLException {
    PreparedStatement ps = null;
    switch (aSelect) {
      case IDBObjetoPersistente.SELECT_ALL: {
        ps = this.selectAll(aCondiciones);
        break;
      }
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
      case SELECT_BY_COL_IVA_COMPRAS: {
          ps = this.selectByColLibroIVACompras(aCondiciones);
          break;
      }
    }
    return ps;
  }

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

    final int OID_COL_LIBRO_IVA = 1;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  imColLibroIVA ");
    textSQL.append(" WHERE oid_col_libro_iva = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    int oid = ( (Integer) aCondiciones).intValue();
    querySelect.setInt(OID_COL_LIBRO_IVA, oid);
    return querySelect;
  }
  
  private PreparedStatement selectByColLibroIVACompras(Object aCondiciones) throws BaseException, SQLException {
	    StringBuffer textSQL = new StringBuffer();
	    textSQL.append("SELECT * FROM  imColLibroIVA ");
	    textSQL.append(" WHERE usar_iva_cpras = 1 ");
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
	    return querySelect;
  }
  
  
  private PreparedStatement selectAll(Object aCondiciones) throws BaseException, SQLException {
	    StringBuffer textSQL = new StringBuffer();
	    textSQL.append("SELECT * FROM  imColLibroIVA ");
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
	    return querySelect;
  }
  
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

    final int CODIGO = 1;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  imColLibroIVA ");
    textSQL.append(" WHERE codigo = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    String codigo = (String) aCondiciones;
    querySelect.setString(CODIGO, codigo);
    return querySelect;
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_col_libro_iva oid,codigo codigo, descripcion descripcion ,activo ");
    textSQL.append(" from imColLibroIVA");

    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    return querySelect;
  }
  
  public static List getColLibroIVACompras(ISesion aSesion) throws BaseException {
	  return (List) ObjetoLogico.getObjects(ColumnaLibroIVA.NICKNAME,
             DBColumnaLibroIVA.SELECT_BY_COL_IVA_COMPRAS,
             null,
             new ListObserver(),
             aSesion);
  }
  
  public static List getColLibroIVA(ISesion aSesion) throws BaseException {
	  return (List) ObjetoLogico.getObjects(ColumnaLibroIVA.NICKNAME,
             DBColumnaLibroIVA.SELECT_ALL,
             null,
             new ListObserver(),
             aSesion);
  }  
  

}
