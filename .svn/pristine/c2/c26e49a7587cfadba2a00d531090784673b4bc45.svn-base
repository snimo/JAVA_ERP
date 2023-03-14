package com.srn.erp.ctasAPagar.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.ctasAPagar.bm.ConcFactProv;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;

public class DBConcFactProv extends DBObjetoPersistente {

  public static final String OID_CONC_FACT_PROV = "oid_conc_fact_prov";
  public static final String CODIGO = "codigo";
  public static final String DESCRIPCION = "descripcion";
  public static final String ACTIVO = "activo";
  public static final String ORDEN = "orden";
  public static final String ES_REND_FF = "es_rend_ff";
  public static final String ADD_CTAS_REND_FF = "add_ctas_rend_ff";

  public static final int SELECT_BY_CONC_FACT_PROV = 100;
  public static final int SELECT_BY_CONC_FACT_ES_FF = 101;

  public DBConcFactProv() {
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

    final int OID_CONC_FACT_PROV = 1;
    final int CODIGO = 2;
    final int DESCRIPCION = 3;
    final int ACTIVO = 4;
    final int ORDEN = 5;
    final int ES_REND_FF = 6;
    final int ADD_CTAS_REND_FF = 7;

    ConcFactProv pers = (ConcFactProv) objetoPersistente;

    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into cpConcFactProv "+
                     " ( "+
                      "OID_CONC_FACT_PROV,"+
                      "CODIGO,"+
                      "DESCRIPCION,"+
                      "ACTIVO,"+
                      "ORDEN,ES_REND_FF,ADD_CTAS_REND_FF)"+
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
    qInsert.setInt(OID_CONC_FACT_PROV,pers.getOID());
    qInsert.setString(CODIGO,pers.getCodigo());
    qInsert.setString(DESCRIPCION,pers.getDescripcion());
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qInsert.setInt(ORDEN,pers.getOrden().intValue());
    if (pers.isRendicionFondoFijo()!=null)
    	qInsert.setBoolean(ES_REND_FF, pers.isRendicionFondoFijo().booleanValue());
    else
    	qInsert.setBoolean(ES_REND_FF, false);
    if (pers.addCtasRendFF()!=null)
    	qInsert.setBoolean(ADD_CTAS_REND_FF, pers.addCtasRendFF().booleanValue());
    else
    	qInsert.setBoolean(ADD_CTAS_REND_FF, false);
    
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

    final int CODIGO = 1;
    final int DESCRIPCION = 2;
    final int ACTIVO = 3;
    final int ORDEN = 4;
    final int ES_REND_FF = 5;
    final int ADD_CTAS_REND_FF = 6;
    final int OID_CONC_FACT_PROV = 7;

    ConcFactProv pers = (ConcFactProv) objetoPersistente;

    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update cpConcFactProv set "+
              "codigo=?"+
              ",descripcion=?"+
              ",activo=?"+
              ",orden=?"+
              ",es_rend_ff=?"+
              ",add_ctas_rend_ff=?"+
                 " where " +
                 " oid_conc_fact_prov=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_CONC_FACT_PROV,pers.getOID());
    qUpdate.setString(CODIGO,pers.getCodigo());
    qUpdate.setString(DESCRIPCION,pers.getDescripcion());
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.setInt(ORDEN,pers.getOrden().intValue());
    if (pers.isRendicionFondoFijo()!=null)
    	qUpdate.setBoolean(ES_REND_FF, pers.isRendicionFondoFijo().booleanValue());
    else
    	qUpdate.setBoolean(ES_REND_FF, false);
    if (pers.addCtasRendFF()!=null)
    	qUpdate.setBoolean(ADD_CTAS_REND_FF, pers.addCtasRendFF().booleanValue());
    else
    	qUpdate.setBoolean(ADD_CTAS_REND_FF, false);
    
    qUpdate.executeUpdate();
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    final int OID_CONC_FACT_PROV = 1;
    ConcFactProv pers = (ConcFactProv) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("update cpConcFactProv "+
                     " set activo=0 " +
                     " where " +
                     " oid_conc_fact_prov=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_CONC_FACT_PROV, pers.getOID());
    qUpdate.executeUpdate();
    qUpdate.close();
  }

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    final int OID_CONC_FACT_PROV = 1;
    ConcFactProv pers = (ConcFactProv) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("update cpConcFactProv "+
                     " set activo=1 " +
                     " where " +
                     " oid_conc_fact_prov=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_CONC_FACT_PROV, pers.getOID());
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
      case SELECT_BY_CONC_FACT_PROV: {
        ps = this.selectAllConcFactProv(aCondiciones);
        break;
      }
      case SELECT_BY_CONC_FACT_ES_FF: {
          ps = this.selectByConcFactEsRendFF(aCondiciones);
          break;
      }
      case SELECT_ALL: {
          ps = this.selectALL(aCondiciones);
          break;
      }
      
    }
    return ps;
  }

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

    final int OID_CONC_FACT_PROV = 1;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  cpConcFactProv ");
    textSQL.append(" WHERE oid_conc_fact_prov = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    int oid = ( (Integer) aCondiciones).intValue();
    querySelect.setInt(OID_CONC_FACT_PROV, oid);
    return querySelect;
  }
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

    final int CODIGO = 1;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  cpConcFactProv ");
    textSQL.append(" WHERE codigo = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    String codigo = (String) aCondiciones;
    querySelect.setString(CODIGO, codigo);
    return querySelect;
  }

  private PreparedStatement selectAllConcFactProv(Object aCondiciones) throws BaseException, SQLException {
    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  cpConcFactProv ");
    textSQL.append(" WHERE activo = 1 order by orden  ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    return querySelect;
  }

  private PreparedStatement selectALL(Object aCondiciones) throws BaseException, SQLException {
	    StringBuffer textSQL = new StringBuffer();
	    textSQL.append("SELECT * FROM  cpConcFactProv ");
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
	    return querySelect;
  }
  
  private PreparedStatement selectByConcFactEsRendFF(Object aCondiciones) throws BaseException, SQLException {
	    StringBuffer textSQL = new StringBuffer();
	    textSQL.append("SELECT * FROM  cpConcFactProv ");
	    textSQL.append(" WHERE activo = 1 and es_rend_ff=1  ");
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
	    return querySelect;
  }
  
  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_conc_fact_prov oid,codigo codigo, descripcion descripcion ,activo ");
    textSQL.append(" from cpConcFactProv");

    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    return querySelect;
  }

  public static List getConceptosFactProv(ISesion aSesion) throws BaseException {
    return (List) ObjetoLogico.getObjects(ConcFactProv.NICKNAME,
                                          DBConcFactProv.SELECT_BY_CONC_FACT_PROV,
                                          null,
                                          new ListObserver(),
                                          aSesion);
  }
  
  public static List getConceptosFactProvRendFondoFijo(ISesion aSesion) throws BaseException {
	    return (List) ObjetoLogico.getObjects(ConcFactProv.NICKNAME,
	                                          DBConcFactProv.SELECT_BY_CONC_FACT_ES_FF,
	                                          null,
	                                          new ListObserver(),
	                                          aSesion);
  }
  
  public static List getAllConceptosFactProv(ISesion aSesion) throws BaseException {
	    return (List) ObjetoLogico.getObjects(ConcFactProv.NICKNAME,
	                                          SELECT_ALL,
	                                          null,
	                                          new ListObserver(),
	                                          aSesion);
}




}
