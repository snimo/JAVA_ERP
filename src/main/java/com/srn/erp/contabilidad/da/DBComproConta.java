package com.srn.erp.contabilidad.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.srn.erp.contabilidad.bm.ComproConta;
import com.srn.erp.general.bm.ComproCab;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ObjetoObservado;

public class DBComproConta extends DBObjetoPersistente {

  public static final String OID_CCO = "oid_cco";
  public static final String IMPUTAC = "imputac";
  public static final String CIERRE = "cierre";
  public static final String OID_PERI = "oid_peri";
  public static final String OID_DIARIO = "oid_diario";
  public static final String ANULADO = "anulado";
  
  public DBComproConta() {
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

    final int OID_CCO = 1;
    final int IMPUTAC = 2;
    final int CIERRE = 3;
    final int OID_PERI = 4;
    final int OID_DIARIO = 5;
    final int ES_ASI_CIERRE = 6;
    final int ES_ASI_APER = 7;
    final int TIPO_ASI_CIERRE = 8;

    ComproConta pers = (ComproConta) objetoPersistente;

    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into cgComproConta "+
                     " ( "+
                      "OID_CCO,"+
                      "IMPUTAC,"+
                      "CIERRE,"+
                      "OID_PERI,"+
                      "OID_DIARIO,ANULADO)"+
                      " values "+
                      "("+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "0)");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
    qInsert.setInt(OID_CCO,pers.getOID());
    qInsert.setDate(IMPUTAC,new java.sql.Date(pers.getImputac().getTime()));
    qInsert.setBoolean(CIERRE,pers.isCierre().booleanValue());
    qInsert.setInt(OID_PERI,pers.getPeriodo().getOID());
    qInsert.setInt(OID_DIARIO,pers.getDiario().getOID());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

    final int IMPUTAC = 1;
    final int CIERRE = 2;
    final int OID_PERI = 3;
    final int OID_DIARIO = 4;
    final int ANULADO = 5;
    final int OID_CCO = 6;

    ComproConta pers = (ComproConta) objetoPersistente;

    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update cgComproConta set "+
              "imputac=?"+
              ",cierre=?"+
              ",oid_peri=?"+
              ",oid_diario=?"+
              ",anulado=? "+
                 " where " +
                 " oid_cco=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_CCO,pers.getOID());
    qUpdate.setDate(IMPUTAC, new java.sql.Date(pers.getImputac().getTime()));
    qUpdate.setBoolean(CIERRE,pers.isCierre().booleanValue());
    qUpdate.setInt(OID_PERI,pers.getPeriodo().getOID());
    qUpdate.setBoolean(ANULADO,pers.isAnulado().booleanValue());
    qUpdate.setInt(OID_DIARIO,pers.getDiario().getOID());
    qUpdate.executeUpdate();
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    final int OID_CCO = 1;
    ComproConta pers = (ComproConta) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("delete from cgComproConta "+
                     " where " +
                     " oid_cco=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_CCO, pers.getOID());
    qUpdate.executeUpdate();
    qUpdate.close();
  }

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    final int OID_CCO = 1;
    ComproConta pers = (ComproConta) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("update cgComproConta "+
                     " set activo=1 " +
                     " where " +
                     " oid_cco=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_CCO, pers.getOID());
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

    final int OID_CCO = 1;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  cgComproConta ");
    textSQL.append(" WHERE oid_cco = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    int oid = ( (Integer) aCondiciones).intValue();
    querySelect.setInt(OID_CCO, oid);
    return querySelect;
  }
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

    final int CODIGO = 1;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  cgComproConta ");
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    String codigo = (String) aCondiciones;
    querySelect.setString(CODIGO, codigo);
    return querySelect;
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_cco oid, codigo,  descripcion ,activo ");
    textSQL.append(" from cgComproConta");

    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    return querySelect;
  }
  
  public static ComproConta getComproConta(ComproCab comproCab,
          								   ISesion aSesion)
          throws BaseException {
	  Integer oidComproConta = comproCab.getOIDInteger();
	  return (ComproConta) ObjetoLogico.getObjects(ComproConta.NICKNAME,
			  				DBComproConta.SELECT_BY_OID,
			  				oidComproConta,
			  				new ObjetoObservado(),
			  				aSesion);
  }  

}
