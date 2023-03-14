package com.srn.erp.general.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Map;

import com.srn.erp.general.bm.Indice;
import com.srn.erp.general.bm.IndiceValor;
import com.srn.erp.general.bm.Periodo;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.ObjetoObservado;

public class DBIndiceValor extends DBObjetoPersistente {

  public static final String OID_INDICE_VAL = "oid_indice_val";
  public static final String OID_PERI = "oid_peri";
  public static final String INDICE = "indice";
  public static final String OID_INDICE = "oid_indice";
  public static final String ACTIVO = "activo";

  public static final int SELECT_BY_INDICE = 100;

  public DBIndiceValor() {
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

    final int OID_INDICE_VAL = 1;
    final int OID_PERI = 2;
    final int INDICE = 3;
    final int OID_INDICE = 4;
    final int ACTIVO = 5;

    IndiceValor pers = (IndiceValor) objetoPersistente;

    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into geIndicesVal "+
                     " ( "+
                      "OID_INDICE_VAL,"+
                      "OID_PERI,"+
                      "INDICE,"+
                      "OID_INDICE,"+
                      "ACTIVO)"+
                      " values "+
                      "("+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
    qInsert.setInt(OID_INDICE_VAL,pers.getOID());
    qInsert.setInt(OID_PERI,pers.getPeri().getOID());
    qInsert.setDouble(INDICE,pers.getValor().doubleValue());
    qInsert.setInt(OID_INDICE,pers.getIndice().getOID());
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

    final int OID_PERI = 1;
    final int INDICE = 2;
    final int OID_INDICE = 3;
    final int ACTIVO = 4;
    final int OID_INDICE_VAL = 5;

    IndiceValor pers = (IndiceValor) objetoPersistente;

    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update geIndicesVal set "+
              "oid_peri=?"+
              ",indice=?"+
              ",oid_indice=?"+
              ",activo=?"+
                 " where " +
                 " oid_indice_val=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_INDICE_VAL,pers.getOID());
    qUpdate.setInt(OID_PERI,pers.getPeri().getOID());
    qUpdate.setDouble(INDICE,pers.getValor().doubleValue());
    qUpdate.setInt(OID_INDICE,pers.getIndice().getOID());
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.executeUpdate();
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    final int OID_INDICE_VAL = 1;
    IndiceValor pers = (IndiceValor) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("update geIndicesVal "+
                     " set activo=0 " +
                     " where " +
                     " oid_indice_val=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_INDICE_VAL, pers.getOID());
    qUpdate.executeUpdate();
    qUpdate.close();
  }

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    final int OID_INDICE_VAL = 1;
    IndiceValor pers = (IndiceValor) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("update geIndicesVal "+
                     " set activo=1 " +
                     " where " +
                     " oid_indice_val=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_INDICE_VAL, pers.getOID());
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
      case SELECT_BY_INDICE: {
        ps = this.selectByIndicePeriodo(aCondiciones);
        break;
      }
    }
    return ps;
  }

  private PreparedStatement selectByIndicePeriodo(Object aCondiciones) throws BaseException, SQLException {
    final int OID_INDICE = 1;
    final int OID_PERI = 2;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  geIndicesVal ");
    textSQL.append(" WHERE oid_indice = ? and oid_peri = ?");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    Map mapa =( HashTableDatos) aCondiciones;
    Indice indice = ((Indice) mapa.get(Indice.NICKNAME));
    Periodo periodo = ((Periodo) mapa.get(Periodo.NICKNAME));
    querySelect.setInt(OID_INDICE, indice.getOID());
    querySelect.setInt(OID_PERI, periodo.getOID());
    return querySelect;

  }

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

    final int OID_INDICE_VAL = 1;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  geIndicesVal ");
    textSQL.append(" WHERE oid_indice_val = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    int oid = ( (Integer) aCondiciones).intValue();
    querySelect.setInt(OID_INDICE_VAL, oid);
    return querySelect;
  }
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

    final int CODIGO = 1;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  geIndicesVal ");
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    String codigo = (String) aCondiciones;
    querySelect.setString(CODIGO, codigo);
    return querySelect;
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_indice_val oid, codigo,  descripcion ,activo ");
    textSQL.append(" from geIndicesVal");

    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    return querySelect;
  }

  public static IndiceValor getIndiceValor(Indice indice,
                                            Periodo periodo,
                                            ISesion aSesion) throws BaseException {

    Map mapaDatos = new HashTableDatos();
    mapaDatos.put(Indice.NICKNAME,indice);
    mapaDatos.put(Periodo.NICKNAME,periodo);

    return (IndiceValor) ObjetoLogico.getObjects(IndiceValor.NICKNAME,
                                          DBIndiceValor.SELECT_BY_INDICE,
                                          mapaDatos,
                                          new ObjetoObservado(),
                                          aSesion);
  }


}
