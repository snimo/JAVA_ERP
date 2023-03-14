package com.srn.erp.contabilidad.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.srn.erp.contabilidad.bm.Diario;
import com.srn.erp.general.bm.TipoComprobante;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.Utils.ObjetoObservado;

public class DBDiario extends DBObjetoPersistente {

  public static final String OID_DIARIO = "oid_diario";
  public static final String OID_TC = "oid_tc";
  public static final String IMPUTAC = "imputac";
  public static final String CIERRE = "cierre";
  public static final String COMENTARIO = "comentario";

  public static final int SELECT_BY_TIPO_Y_FECHA = 100;

  public DBDiario() {
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

    final int OID_DIARIO = 1;
    final int OID_TC = 2;
    final int IMPUTAC = 3;
    final int CIERRE = 4;
    final int COMENTARIO = 5;

    Diario pers = (Diario) objetoPersistente;

    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into cgDiario "+
                     " ( "+
                      "OID_DIARIO,"+
                      "OID_TC,"+
                      "IMPUTAC,"+
                      "CIERRE,"+
                      "COMENTARIO)"+
                      " values "+
                      "("+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
    qInsert.setInt(OID_DIARIO,pers.getOID());
    qInsert.setInt(OID_TC,pers.getTipocomprobante().getOID());
    qInsert.setDate(IMPUTAC,new java.sql.Date(pers.getImputac().getTime()));
    qInsert.setBoolean(CIERRE,pers.isCierre().booleanValue());
    qInsert.setString(COMENTARIO,pers.getComentario());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

    final int OID_TC = 1;
    final int IMPUTAC = 2;
    final int CIERRE = 3;
    final int COMENTARIO = 4;
    final int OID_DIARIO = 5;

    Diario pers = (Diario) objetoPersistente;

    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update cgDiario set "+
              "oid_tc=?"+
              ",imputac=?"+
              ",cierre=?"+
              ",comentario=?"+
                 " where " +
                 " oid_diario=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_DIARIO,pers.getOID());
    qUpdate.setInt(OID_TC,pers.getTipocomprobante().getOID());
    qUpdate.setDate(IMPUTAC,new java.sql.Date(pers.getImputac().getTime()));
    qUpdate.setBoolean(CIERRE,pers.isCierre().booleanValue());
    qUpdate.setString(COMENTARIO,pers.getComentario());
    qUpdate.executeUpdate();
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    final int OID_DIARIO = 1;
    Diario pers = (Diario) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("delete from cgDiario "+
                     " where " +
                     " oid_diario=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_DIARIO, pers.getOID());
    qUpdate.executeUpdate();
    qUpdate.close();
  }

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    final int OID_DIARIO = 1;
    Diario pers = (Diario) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("update cgDiario "+
                     " set activo=1 " +
                     " where " +
                     " oid_diario=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_DIARIO, pers.getOID());
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
      case SELECT_BY_TIPO_Y_FECHA: {
        ps = this.selectByTipoyFecha(aCondiciones);
        break;
      }
    }
    return ps;
  }

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

    final int OID_DIARIO = 1;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  cgDiario ");
    textSQL.append(" WHERE oid_diario = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    int oid = ( (Integer) aCondiciones).intValue();
    querySelect.setInt(OID_DIARIO, oid);
    return querySelect;
  }
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

    final int CODIGO = 1;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  cgDiario ");
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    String codigo = (String) aCondiciones;
    querySelect.setString(CODIGO, codigo);
    return querySelect;
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_diario oid, codigo,  descripcion ,activo ");
    textSQL.append(" from cgDiario");

    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    return querySelect;
  }

  private PreparedStatement selectByTipoyFecha(Object aCondiciones) throws BaseException, SQLException {
    MapDatos mapaDatos        = (HashTableDatos) aCondiciones;
    java.util.Date fecha = (java.util.Date) mapaDatos.get(DBDiario.IMPUTAC);
    TipoComprobante tc   = (TipoComprobante) mapaDatos.getObject(TipoComprobante.NICKNAME);

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  cgDiario ");
    textSQL.append(" WHERE  oid_tc=? and imputac=?");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());

    querySelect.setInt(1,tc.getOID());
    querySelect.setDate(2,new java.sql.Date(fecha.getTime()));
    return querySelect;
  }

  public static Diario getDiarioByFechayTC(java.util.Date fecha,
                                           TipoComprobante tc,
                                           ISesion aSesion)
                                           throws BaseException {
    MapDatos mapaDatos = new HashTableDatos();
    mapaDatos.put(DBDiario.IMPUTAC,fecha);
    mapaDatos.put(TipoComprobante.NICKNAME,tc);
    return (Diario) ObjetoLogico.getObjects(Diario.NICKNAME,
                                            DBDiario.SELECT_BY_TIPO_Y_FECHA,
                                            mapaDatos,
                                            new ObjetoObservado(),
                                            aSesion);

  }


}
