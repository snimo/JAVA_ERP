package com.srn.erp.general.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.srn.erp.general.bm.LugarEmision;

import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class DBLugarEmision extends DBObjetoPersistente {

  public static final String OID_LUG_EMI = "oid_lug_emi";
  public static final String LUG_EMI = "lug_emi";
  public static final String DESCRIPCION = "descripcion";
  public static final String OID_UNI_ORG = "oid_uni_org";
  public static final String ACTIVO = "activo";

  public DBLugarEmision() {
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

    final int OID_LUG_EMI = 1;
    final int LUG_EMI = 2;
    final int DESCRIPCION = 3;
    final int OID_UNI_ORG = 4;
    final int ACTIVO = 5;

    LugarEmision pers = (LugarEmision) objetoPersistente;

    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into geLugEmi "+
                     " ( "+
                      "OID_LUG_EMI,"+
                      "LUG_EMI,"+
                      "DESCRIPCION,"+
                      "OID_UNI_ORG,"+
                      "ACTIVO)"+
                      " values "+
                      "("+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
    qInsert.setInt(OID_LUG_EMI,pers.getOID());
    qInsert.setInt(LUG_EMI,pers.getLugemi().intValue());
    qInsert.setString(DESCRIPCION,pers.getDescripcion());
    if (pers.getUnidadorganizativa()!=null)
    	qInsert.setInt(OID_UNI_ORG,pers.getUnidadorganizativa().getOID());
    else
    	qInsert.setNull(OID_UNI_ORG,java.sql.Types.INTEGER);
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

    final int LUG_EMI = 1;
    final int DESCRIPCION = 2;
    final int OID_UNI_ORG = 3;
    final int ACTIVO = 4;
    final int OID_LUG_EMI = 5;

    LugarEmision pers = (LugarEmision) objetoPersistente;

    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update geLugEmi set "+
              "lug_emi=?"+
              ",descripcion=?"+
              ",oid_uni_org=?"+
              ",activo=?"+
                 " where " +
                 " oid_lug_emi=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_LUG_EMI,pers.getOID());
    qUpdate.setInt(LUG_EMI,pers.getLugemi().intValue());
    qUpdate.setString(DESCRIPCION,pers.getDescripcion());
    if (pers.getUnidadorganizativa()!=null)
    	qUpdate.setInt(OID_UNI_ORG,pers.getUnidadorganizativa().getOID());
    else
    	qUpdate.setNull(OID_UNI_ORG,java.sql.Types.INTEGER);
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.executeUpdate();
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    final int OID_LUG_EMI = 1;
    LugarEmision pers = (LugarEmision) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("update geLugEmi "+
                     " set activo=0 " +
                     " where " +
                     " oid_lug_emi=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_LUG_EMI, pers.getOID());
    qUpdate.executeUpdate();
    qUpdate.close();
  }

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    final int OID_LUG_EMI = 1;
    LugarEmision pers = (LugarEmision) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("update geLugEmi "+
                     " set activo=1 " +
                     " where " +
                     " oid_lug_emi=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_LUG_EMI, pers.getOID());
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
    }
    return ps;
  }

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

    final int OID_LUG_EMI = 1;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  geLugEmi ");
    textSQL.append(" WHERE oid_lug_emi = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    int oid = ( (Integer) aCondiciones).intValue();
    querySelect.setInt(OID_LUG_EMI, oid);
    return querySelect;
  }
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

    final int CODIGO = 1;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  geLugEmi ");
    textSQL.append(" WHERE lug_emi = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    String codigo = (String) aCondiciones;
    Integer valorNumCodigo = new Integer(codigo);
    querySelect.setInt(CODIGO, valorNumCodigo.intValue());
    return querySelect;
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_lug_emi oid, lug_emi codigo, descripcion descripcion ,activo ");
    textSQL.append(" from geLugEmi");

    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    return querySelect;
  }

}
