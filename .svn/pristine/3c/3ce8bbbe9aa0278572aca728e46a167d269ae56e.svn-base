package com.srn.erp.general.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.srn.erp.general.bm.FactorConversion;
import com.srn.erp.stock.bm.UnidadMedida;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.ObjetoObservado;

public class DBFactorConversion extends DBObjetoPersistente {

  public static final String OID_FACT_CONV = "oid_fact_conv";
  public static final String OID_UM_ORI = "oid_um_ori";
  public static final String OID_UM_DEST = "oid_um_dest";
  public static final String FACTOR = "factor";
  public static final String ACTIVO = "activo";

  public static final int SELECT_BY_UM_ORI_UM_DEST = 100;

  public DBFactorConversion() {
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

    final int OID_FACT_CONV = 1;
    final int OID_UM_ORI = 2;
    final int OID_UM_DEST = 3;
    final int FACTOR = 4;
    final int ACTIVO = 5;

    FactorConversion pers = (FactorConversion) objetoPersistente;

    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into geFactConv "+
                     " ( "+
                      "OID_FACT_CONV,"+
                      "OID_UM_ORI,"+
                      "OID_UM_DEST,"+
                      "FACTOR,"+
                      "ACTIVO)"+
                      " values "+
                      "("+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
    qInsert.setInt(OID_FACT_CONV,pers.getOID());
    qInsert.setInt(OID_UM_ORI,pers.getUni_med_ori().getOID());
    qInsert.setInt(OID_UM_DEST,pers.getUni_med_dest().getOID());
    qInsert.setDouble(FACTOR,pers.getFactor().doubleValue());
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

    final int OID_UM_ORI = 1;
    final int OID_UM_DEST = 2;
    final int FACTOR = 3;
    final int ACTIVO = 4;
    final int OID_FACT_CONV = 5;

    FactorConversion pers = (FactorConversion) objetoPersistente;

    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update geFactConv set "+
              "oid_um_ori=?"+
              ",oid_um_dest=?"+
              ",factor=?"+
              ",activo=?"+
                 " where " +
                 " oid_fact_conv=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_FACT_CONV,pers.getOID());
    qUpdate.setInt(OID_UM_ORI,pers.getUni_med_ori().getOID());
    qUpdate.setInt(OID_UM_DEST,pers.getUni_med_dest().getOID());
    qUpdate.setDouble(FACTOR,pers.getFactor().doubleValue());
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.executeUpdate();
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    final int OID_FACT_CONV = 1;
    FactorConversion pers = (FactorConversion) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("delete from geFactConv "+
                     " where " +
                     " oid_fact_conv=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_FACT_CONV, pers.getOID());
    qUpdate.executeUpdate();
    qUpdate.close();
  }

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    final int OID_FACT_CONV = 1;
    FactorConversion pers = (FactorConversion) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("update geFactConv "+
                     " set activo=1 " +
                     " where " +
                     " oid_fact_conv=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_FACT_CONV, pers.getOID());
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
      case SELECT_BY_UM_ORI_UM_DEST : {
        ps = this.selectByUM_ORI_UM_DEST(aCondiciones);
        break;
      }
    }
    return ps;
  }

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

    final int OID_FACT_CONV = 1;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  geFactConv ");
    textSQL.append(" WHERE oid_fact_conv = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    int oid = ( (Integer) aCondiciones).intValue();
    querySelect.setInt(OID_FACT_CONV, oid);
    return querySelect;
  }

  private PreparedStatement selectByUM_ORI_UM_DEST(Object aCondiciones) throws BaseException, SQLException {

    HashTableDatos condiciones = (HashTableDatos) aCondiciones;
    UnidadMedida umOri = (UnidadMedida) condiciones.get("um_ori");
    UnidadMedida umDest = (UnidadMedida) condiciones.get("um_dest");

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  geFactConv ");
    textSQL.append(" WHERE oid_um_ori = ? and oid_um_dest = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());

    querySelect.setInt(1, umOri.getOID());
    querySelect.setInt(2, umDest.getOID());

    return querySelect;
  }


  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

    final int CODIGO = 1;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  geFactConv ");
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    String codigo = (String) aCondiciones;
    querySelect.setString(CODIGO, codigo);
    return querySelect;
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_fact_conv oid, codigo,  descripcion ,activo ");
    textSQL.append(" from geFactConv");

    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    return querySelect;
  }

  public static FactorConversion getFactConv(UnidadMedida umOri,
                                    UnidadMedida umDest,
                                    ISesion aSesion)  throws BaseException {
    HashTableDatos condiciones = new HashTableDatos();
    condiciones.put("um_ori",umOri);
    condiciones.put("um_dest",umDest);
    return (FactorConversion) ObjetoLogico.getObjects(FactorConversion.NICKNAME,
                                             DBFactorConversion.SELECT_BY_UM_ORI_UM_DEST,
                                             condiciones,
                                             new ObjetoObservado(),
                                             aSesion);
  }




}
