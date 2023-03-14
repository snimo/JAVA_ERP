package com.srn.erp.ctasACobrar.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.ctasACobrar.bm.AplicacionComproClie;
import com.srn.erp.ctasAPagar.bm.AplicacionComproProv;
import com.srn.erp.ctasAPagar.da.DBAplicacionComproProv;
import com.srn.erp.general.bm.ComproCab;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;

public class DBAplicacionComproClie extends DBObjetoPersistente {

  public static final String OID_CCO = "oid_cco";
  public static final String SUJETO = "oid_sujeto";
  public static final String ALLOW_DESAPLICAR = "allow_desaplicar";
  
  public static final int SELECT_APLIC_ACTIVAS_COMPRO = 100;

  public DBAplicacionComproClie() {
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

    final int OID_CCO = 1;
    final int SUJETO  = 2;
    final int ALLOW_DESAPLICAR = 3;

    AplicacionComproClie pers = (AplicacionComproClie) objetoPersistente;

    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into veComproClieApl "+
                     " ( "+
                      "OID_CCO,"+
                      "OID_SUJETO,ALLOW_DESAPLICAR)"+
                      " values "+
                      "("+
                      "?,"+
                      "?,"+
                      "?)");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
    qInsert.setInt(OID_CCO,pers.getOID());
    qInsert.setInt(SUJETO,pers.getSujeto().getOID());
    if (pers.isAllowDesaplicar()!=null)
    	qInsert.setBoolean(ALLOW_DESAPLICAR,pers.isAllowDesaplicar());
    else
    	qInsert.setBoolean(ALLOW_DESAPLICAR,false);
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

    final int OID_SUJETO = 1;
    final int ALLOW_DESAPLICAR = 2;
    final int OID_CCO = 3;

    AplicacionComproClie pers = (AplicacionComproClie) objetoPersistente;

    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update veComproClieApl set "+
              "oid_sujeto=?,allow_desaplicar=? "+
                 " where " +
                 " oid_cco=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_CCO,pers.getOID());
    qUpdate.setInt(OID_SUJETO,pers.getSujeto().getOID());
    if (pers.isAllowDesaplicar()!=null)
    	qUpdate.setBoolean(ALLOW_DESAPLICAR,pers.isAllowDesaplicar());
    else
    	qUpdate.setBoolean(ALLOW_DESAPLICAR,false);
    qUpdate.executeUpdate();
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    final int OID_CCO = 1;
    AplicacionComproClie pers = (AplicacionComproClie) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("update geComproCab " + " set activo=0 " + " where " + " oid_cco=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_CCO, pers.getOID());
    qUpdate.executeUpdate();
    qUpdate.close();
  }

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
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
      case SELECT_APLIC_ACTIVAS_COMPRO: {
          ps = this.selectAplicacionesActivasCompro(aCondiciones);
          break;
      }
      
    }
    return ps;
  }
  
  private PreparedStatement selectAplicacionesActivasCompro(Object aCondiciones) throws BaseException, SQLException {

	    StringBuffer textSQL = new StringBuffer();
	    textSQL.append(" select "); 
	    textSQL.append("  distinct a2.*,a1.oid_sujeto,a1.allow_desaplicar "); 
	    textSQL.append(" from "); 
	    textSQL.append("  veComproClieApl a1, geComproCab a2 , veComproClieAplDet a3 , geComproCab a4 ");
	    textSQL.append(" where "); 
	    textSQL.append("  a1.oid_cco = a2.oid_cco and "); 
	    textSQL.append("  a2.activo=1 and "); 
	    textSQL.append("  a3.oid_cco = a1.oid_cco and ");
	    textSQL.append("  a3.oid_compro_aplic = ? and a3.oid_cco = a4.oid_cco and a4.activo = 1 ");
	    
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
	    ComproCab comproCab =  (ComproCab) aCondiciones;
	    querySelect.setInt(1, comproCab.getOID());
	    return querySelect;
}
  

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

    final int OID_CCO = 1;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  veComproClieApl a ,  geComproCab b ");
    textSQL.append(" WHERE a.oid_cco = b.oid_cco and a.oid_cco = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    int oid = ( (Integer) aCondiciones).intValue();
    querySelect.setInt(OID_CCO, oid);
    return querySelect;
  }
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

    final int OID_CCO = 1;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  veComproClieApl ");
    textSQL.append(" WHERE  oid_cco = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    int oid = ( (Integer) aCondiciones).intValue();
    querySelect.setInt(OID_CCO, oid);
    return querySelect;
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {
    return null;
  }
  
  public static List getAplicacionesActivasCompro(ComproCab compro,
          ISesion aSesion) throws BaseException {
	  return (List) ObjetoLogico.getObjects(AplicacionComproClie.NICKNAME,
             DBAplicacionComproClie.SELECT_APLIC_ACTIVAS_COMPRO,
             compro,
             new ListObserver(),
             aSesion);
  }
  

}
