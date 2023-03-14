package com.srn.erp.impuestos.da;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.general.bm.PeriodoInc;
import com.srn.erp.general.bm.PeriodoIncDet;
import com.srn.erp.general.da.DBPeriodoIncDet;
import com.srn.erp.impuestos.bm.SujetoImpositivo;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;

public class DBSujetoImpositivo extends DBObjetoPersistente {

  public static final String OID_SUJ_IMP = "oid_suj_imp";
  public static final String RAZON_SOCIAL = "razon_social";
  public static final String CUIT = "cuit";
  public static final String EXENTO_RET_IVA = "exento_ret_iva";
  public static final String EXENTO_RET_GAN = "exento_ret_gan";
  public static final String EXENTO_RET_IB = "exento_ret_ib";
  public static final String ING_BRUTOS = "ing_brutos";
  public static final String DNRP = "dnrp";
  public static final String OID_CAT_IVA = "oid_cat_iva";
  public static final String OID_CAT_IB = "oid_cat_ib";
  public static final String OID_CAT_GAN = "oid_cat_gan";
  public static final String ACTIVO = "activo";
  public static final String OID_CAT_RET_IVA = "oid_cat_ret_iva";
  public static final String OID_CAT_RET_IB  = "oid_cat_ret_ib";
  public static final String OID_CAT_RET_GAN = "oid_cat_ret_gan";
  
  public static final int SELECT_BY_PEND_REG_IB_BSAS = 100;
  public static final int SELECT_ALL_SUJETOS = 101;
  

  public DBSujetoImpositivo() {
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

    final int OID_SUJ_IMP = 1;
    final int RAZON_SOCIAL = 2;
    final int CUIT = 3;
    final int EXENTO_RET_IVA = 4;
    final int EXENTO_RET_GAN = 5;
    final int EXENTO_RET_IB = 6;
    final int ING_BRUTOS = 7;
    final int DNRP = 8;
    final int OID_CAT_IVA = 9;
    final int OID_CAT_IB = 10;
    final int OID_CAT_GAN = 11;
    final int ACTIVO = 12;
    final int CAT_RET_GAN = 13;
    final int CAT_RET_IVA = 14;
    final int CAT_RET_IB = 15;


    SujetoImpositivo pers = (SujetoImpositivo) objetoPersistente;

    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into imSujetoImpositivo "+
                     " ( "+
                      "OID_SUJ_IMP,"+
                      "RAZON_SOCIAL,"+
                      "CUIT,"+
                      "EXENTO_RET_IVA,"+
                      "EXENTO_RET_GAN,"+
                      "EXENTO_RET_IB,"+
                      "ING_BRUTOS,"+
                      "DNRP,"+
                      "OID_CAT_IVA,"+
                      "OID_CAT_IB,"+
                      "OID_CAT_GAN,"+
                      "ACTIVO,"+
                      "OID_CAT_RET_GAN,"+
                      "OID_CAT_RET_IVA,"+
                      "OID_CAT_RET_IB)"+
                      " values "+
                      "("+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
    qInsert.setInt(OID_SUJ_IMP,pers.getOID());
    qInsert.setString(RAZON_SOCIAL,pers.getRazon());

    if (pers.getCuit()!=null)
      qInsert.setString(CUIT,pers.getCuit());
    else
      qInsert.setNull(CUIT,java.sql.Types.VARCHAR);

    if (pers.isExentoretiva()!=null)
      qInsert.setBoolean(EXENTO_RET_IVA,pers.isExentoretiva().booleanValue());
    else
      qInsert.setNull(EXENTO_RET_IVA,java.sql.Types.BOOLEAN);

    if (pers.isExentoretgan()!=null)
      qInsert.setBoolean(EXENTO_RET_GAN,pers.isExentoretgan().booleanValue());
    else
      qInsert.setNull(EXENTO_RET_GAN,java.sql.Types.BOOLEAN);

    if (pers.isExentoretib()!=null)
      qInsert.setBoolean(EXENTO_RET_IB,pers.isExentoretib().booleanValue());
    else
      qInsert.setNull(EXENTO_RET_IB,java.sql.Types.BOOLEAN);

    if (pers.getIngbrutos()!=null)
      qInsert.setString(ING_BRUTOS,pers.getIngbrutos());
    else
      qInsert.setNull(ING_BRUTOS,java.sql.Types.VARCHAR);

    if (pers.getDnrp()!=null)
      qInsert.setString(DNRP,pers.getDnrp());
    else
      qInsert.setNull(DNRP,java.sql.Types.VARCHAR);

    if (pers.getCategiva()!=null)
      qInsert.setInt(OID_CAT_IVA,pers.getCategiva().getOID());
    else
      qInsert.setNull(OID_CAT_IVA,java.sql.Types.INTEGER);
    if (pers.getCategib()!=null)
      qInsert.setInt(OID_CAT_IB,pers.getCategib().getOID());
    else
      qInsert.setNull(OID_CAT_IB,java.sql.Types.INTEGER);
    if (pers.getCateggan()!=null)
      qInsert.setInt(OID_CAT_GAN,pers.getCateggan().getOID());
    else
      qInsert.setNull(OID_CAT_GAN,java.sql.Types.INTEGER);
    if (pers.getCatRetGan()!=null)
      qInsert.setInt(CAT_RET_GAN,pers.getCatRetGan().getOID());
    else
      qInsert.setNull(CAT_RET_GAN,java.sql.Types.INTEGER);

    if (pers.getCatRetIB()!=null)
      qInsert.setInt(CAT_RET_IB,pers.getCatRetIB().getOID());
    else
      qInsert.setNull(CAT_RET_IB,java.sql.Types.INTEGER);

    if (pers.getCatRetIVA()!=null)
      qInsert.setInt(CAT_RET_IVA,pers.getCatRetIVA().getOID());
    else
      qInsert.setNull(CAT_RET_IVA,java.sql.Types.INTEGER);
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

    final int RAZON_SOCIAL = 1;
    final int CUIT = 2;
    final int EXENTO_RET_IVA = 3;
    final int EXENTO_RET_GAN = 4;
    final int EXENTO_RET_IB = 5;
    final int ING_BRUTOS = 6;
    final int DNRP = 7;
    final int OID_CAT_IVA = 8;
    final int OID_CAT_IB = 9;
    final int OID_CAT_GAN = 10;
    final int ACTIVO = 11;
    final int CAT_RET_IVA = 12;
    final int CAT_RET_GAN = 13;
    final int CAT_RET_IB = 14;
    final int OID_SUJ_IMP = 15;


    SujetoImpositivo pers = (SujetoImpositivo) objetoPersistente;

    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update imSujetoImpositivo set "+
              "razon_social=?"+
              ",cuit=?"+
              ",exento_ret_iva=?"+
              ",exento_ret_gan=?"+
              ",exento_ret_ib=?"+
              ",ing_brutos=?"+
              ",dnrp=?"+
              ",oid_cat_iva=?"+
              ",oid_cat_ib=?"+
              ",oid_cat_gan=?"+
              ",activo=?"+
              ",oid_cat_ret_iva=?"+
              ",oid_cat_ret_gan=?"+
              ",oid_cat_ret_ib=?"+
                 " where " +
                 " oid_suj_imp=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_SUJ_IMP,pers.getOID());
    qUpdate.setString(RAZON_SOCIAL,pers.getRazon());

    if (pers.getCuit()!=null)
      qUpdate.setString(CUIT,pers.getCuit());
    else
      qUpdate.setNull(CUIT,java.sql.Types.VARCHAR);

    if (pers.isExentoretiva()!=null)
      qUpdate.setBoolean(EXENTO_RET_IVA,pers.isExentoretiva().booleanValue());
    else
      qUpdate.setNull(EXENTO_RET_IVA,java.sql.Types.BOOLEAN);

    if (pers.isExentoretgan()!=null)
      qUpdate.setBoolean(EXENTO_RET_GAN,pers.isExentoretgan().booleanValue());
    else
      qUpdate.setNull(EXENTO_RET_GAN,java.sql.Types.BOOLEAN);

    if (pers.isExentoretib()!=null)
      qUpdate.setBoolean(EXENTO_RET_IB,pers.isExentoretib().booleanValue());
    else
      qUpdate.setNull(EXENTO_RET_IB,java.sql.Types.BOOLEAN);

    if (pers.getIngbrutos()!=null)
      qUpdate.setString(ING_BRUTOS,pers.getIngbrutos());
    else
      qUpdate.setNull(ING_BRUTOS,java.sql.Types.VARCHAR);

    if (pers.getDnrp()!=null)
      qUpdate.setString(DNRP,pers.getDnrp());
    else
      qUpdate.setNull(DNRP,java.sql.Types.VARCHAR);

    if (pers.getCategiva()!=null)
      qUpdate.setInt(OID_CAT_IVA,pers.getCategiva().getOID());
    else
      qUpdate.setNull(OID_CAT_IVA,java.sql.Types.INTEGER);

    if (pers.getCategib()!=null)
      qUpdate.setInt(OID_CAT_IB,pers.getCategib().getOID());
    else
      qUpdate.setNull(OID_CAT_IB,java.sql.Types.INTEGER);
    if (pers.getCateggan()!=null)
      qUpdate.setInt(OID_CAT_GAN,pers.getCateggan().getOID());
    else
      qUpdate.setNull(OID_CAT_GAN,java.sql.Types.INTEGER);
    if (pers.getCatRetGan()!=null)
      qUpdate.setInt(CAT_RET_GAN,pers.getCatRetGan().getOID());
    else
      qUpdate.setNull(CAT_RET_GAN,java.sql.Types.INTEGER);

    if (pers.getCatRetIB()!=null)
      qUpdate.setInt(CAT_RET_IB,pers.getCatRetIB().getOID());
    else
      qUpdate.setNull(CAT_RET_IB,java.sql.Types.INTEGER);

    if (pers.getCatRetIVA()!=null)
      qUpdate.setInt(CAT_RET_IVA,pers.getCatRetIVA().getOID());
    else
      qUpdate.setNull(CAT_RET_IVA,java.sql.Types.INTEGER);

    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.executeUpdate();
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    final int OID_SUJ_IMP = 1;
    SujetoImpositivo pers = (SujetoImpositivo) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("update imSujetoImpositivo "+
                     " set activo=0 " +
                     " where " +
                     " oid_suj_imp=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_SUJ_IMP, pers.getOID());
    qUpdate.executeUpdate();
    qUpdate.close();
  }

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    final int OID_SUJ_IMP = 1;
    SujetoImpositivo pers = (SujetoImpositivo) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("update imSujetoImpositivo "+
                     " set activo=1 " +
                     " where " +
                     " oid_suj_imp=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_SUJ_IMP, pers.getOID());
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
      case DBSujetoImpositivo.SELECT_BY_PEND_REG_IB_BSAS: {
        ps = this.selectByPendRegIBBsAs(aCondiciones);
        break;
      }
      case DBSujetoImpositivo.SELECT_ALL_SUJETOS: {
          ps = this.selectAllSujetos(aCondiciones);
          break;
      }
      
      
    }
    return ps;
  }

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

    final int OID_SUJ_IMP = 1;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  imSujetoImpositivo ");
    textSQL.append(" WHERE oid_suj_imp = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    int oid = ( (Integer) aCondiciones).intValue();
    querySelect.setInt(OID_SUJ_IMP, oid);
    return querySelect;
  }

  private PreparedStatement selectByPendRegIBBsAs(Object aCondiciones) throws BaseException, SQLException {

  	java.util.Date fecha = (java.util.Date) aCondiciones;
    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  imSujetoImpositivo where cuit not in (select cuit from vePercIBBsAs where fec_public=?) ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    querySelect.setDate(1,new Date(fecha.getTime()));
    return querySelect;
  }
  
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

    final int CODIGO = 1;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  imSujetoImpositivo ");
    textSQL.append(" WHERE  cuit = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    String codigo = (String) aCondiciones;
    querySelect.setString(CODIGO, codigo);
    return querySelect;
  }
  
  private PreparedStatement selectAllSujetos(Object aCondiciones) throws BaseException, SQLException {

	    StringBuffer textSQL = new StringBuffer();
	    textSQL.append("SELECT * FROM  imSujetoImpositivo ");
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
	    return querySelect;
	  }
  

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_suj_imp oid, cuit codigo, razon_social descripcion ,activo ");
    textSQL.append(" from imSujetoImpositivo");

    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    return querySelect;
  }
  
  public static List getAllSujetos(ISesion aSesion) throws BaseException {
	  return (List) ObjetoLogico.getObjects(SujetoImpositivo.NICKNAME,
             DBSujetoImpositivo.SELECT_ALL_SUJETOS,
             null,
             new ListObserver(),
             aSesion);
  }
  




}
