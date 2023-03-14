package com.srn.erp.general.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import com.srn.erp.general.bm.Sucursal;
import com.srn.erp.tesoreria.bm.GrupoCajas;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;

public class DBSucursal extends DBObjetoPersistente {

  public static final String OID_SUCURSAL = "oid_sucursal";
  public static final String CODIGO = "codigo";
  public static final String DESCRIPCION = "descripcion";
  public static final String CALLE_Y_NRO = "calle_y_nro";
  public static final String LOCALIDAD = "localidad";
  public static final String CODIGO_POSTAL = "codigo_postal";
  public static final String OID_PROVINCIA = "oid_provincia";
  public static final String OID_PAIS = "oid_pais";
  public static final String ACTIVO = "activo";
  public static final String TELEFONOS = "telefonos";
  public static final String PATH_LOGO = "path_logo";
  public static final String FAX = "fax";
  public static final String ES_AGE_PERC_IB_BA = "es_age_perc_ib_ba";
  public static final String ES_AGE_PERC_IB_CF = "es_age_perc_ib_cf";
  public static final String ES_AGE_PERC_IVA = "es_age_perc_iva";
  
  public static final int SELECT_BY_GRUPO_CAJAS = 100;

  public DBSucursal() {
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

    final int OID_SUCURSAL = 1;
    final int CODIGO = 2;
    final int DESCRIPCION = 3;
    final int CALLE_Y_NRO = 4;
    final int LOCALIDAD = 5;
    final int CODIGO_POSTAL = 6;
    final int OID_PROVINCIA = 7;
    final int OID_PAIS = 8;
    final int ACTIVO = 9;
    final int TELEFONOS = 10;
    final int PATH_LOGO = 11;
    final int FAX = 12;
    final int ES_AGE_PERC_IB_BA = 13;
    final int ES_AGE_PERC_IB_CF = 14;
    final int ES_AGE_PERC_IVA = 15;

    Sucursal pers = (Sucursal) objetoPersistente;

    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into geSucursales "+
                     " ( "+
                      "OID_SUCURSAL,"+
                      "CODIGO,"+
                      "DESCRIPCION,"+
                      "CALLE_Y_NRO,"+
                      "LOCALIDAD,"+
                      "CODIGO_POSTAL,"+
                      "OID_PROVINCIA,"+
                      "OID_PAIS,"+
                      "ACTIVO,"+
                      "TELEFONOS,"+
                      "PATH_LOGO,"+
                      "FAX,"+
                      "ES_AGE_PERC_IB_BA,"+
                      "ES_AGE_PERC_IB_CF,ES_AGE_PERC_IVA)"+
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
    qInsert.setInt(OID_SUCURSAL,pers.getOID());
    qInsert.setString(CODIGO,pers.getCodigo());
    qInsert.setString(DESCRIPCION,pers.getDescripcion());
    qInsert.setString(CALLE_Y_NRO,pers.getCalle_y_nro());
    qInsert.setString(LOCALIDAD,pers.getLocalidad());
    qInsert.setString(CODIGO_POSTAL,pers.getCodigo_postal());
    qInsert.setInt(OID_PROVINCIA,pers.getProvincia().getOID());
    qInsert.setInt(OID_PAIS,pers.getPais().getOID());
    if (pers.getTelefonos()!=null)
    	qInsert.setString(TELEFONOS,pers.getTelefonos());
    else
    	qInsert.setNull(TELEFONOS,Types.VARCHAR);
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    if (pers.getPathLogo()!=null)
    	qInsert.setString(PATH_LOGO,pers.getPathLogo());
    else
    	qInsert.setNull(PATH_LOGO,Types.VARCHAR);
    if (pers.getFax()!=null)
    	qInsert.setString(FAX, pers.getFax());
    else
    	qInsert.setNull(FAX,Types.VARCHAR);
    qInsert.setBoolean(ES_AGE_PERC_IB_BA,pers.isAgentePercIBBsAs());
    qInsert.setBoolean(ES_AGE_PERC_IB_CF,pers.isAgentePercIBCapFed());
    qInsert.setBoolean(ES_AGE_PERC_IVA,pers.isAgentePercIVA());
    
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

    final int CODIGO = 1;
    final int DESCRIPCION = 2;
    final int CALLE_Y_NRO = 3;
    final int LOCALIDAD = 4;
    final int CODIGO_POSTAL = 5;
    final int OID_PROVINCIA = 6;
    final int OID_PAIS = 7;
    final int ACTIVO = 8;
    final int TELEFONOS = 9;
    final int PATH_LOGO = 10;
    final int FAX = 11;
    final int ES_AGE_PERC_IB_BA = 12;
    final int ES_AGE_PERC_IB_CF = 13;
    final int ES_AGE_PERC_IVA = 14;
    final int OID_SUCURSAL = 15;
    
    

    Sucursal pers = (Sucursal) objetoPersistente;

    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update geSucursales set "+
              "codigo=?"+
              ",descripcion=?"+
              ",calle_y_nro=?"+
              ",localidad=?"+
              ",codigo_postal=?"+
              ",oid_provincia=?"+
              ",oid_pais=?"+
              ",activo=?"+
              ",telefonos=?"+
              ",path_logo=?"+
              ",fax=?"+
              ",es_age_perc_ib_ba=?"+
              ",es_age_perc_ib_cf=?"+
              ",es_age_perc_iva=?"+
                 " where " +
                 " oid_sucursal=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_SUCURSAL,pers.getOID());
    qUpdate.setString(CODIGO,pers.getCodigo());
    qUpdate.setString(DESCRIPCION,pers.getDescripcion());
    qUpdate.setString(CALLE_Y_NRO,pers.getCalle_y_nro());
    qUpdate.setString(LOCALIDAD,pers.getLocalidad());
    qUpdate.setString(CODIGO_POSTAL,pers.getCodigo_postal());
    qUpdate.setInt(OID_PROVINCIA,pers.getProvincia().getOID());
    qUpdate.setInt(OID_PAIS,pers.getPais().getOID());
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    if (pers.getTelefonos()!=null)
    	qUpdate.setString(TELEFONOS,pers.getTelefonos());
    else
    	qUpdate.setNull(TELEFONOS,Types.VARCHAR);
    if (pers.getPathLogo()!=null)
    	qUpdate.setString(PATH_LOGO,pers.getPathLogo());
    else
    	qUpdate.setNull(PATH_LOGO,Types.VARCHAR);
    if (pers.getFax()!=null)
    	qUpdate.setString(FAX,pers.getFax());
    else
    	qUpdate.setNull(FAX,Types.VARCHAR);
    qUpdate.setBoolean(ES_AGE_PERC_IB_BA,pers.isAgentePercIBBsAs());
    qUpdate.setBoolean(ES_AGE_PERC_IB_CF,pers.isAgentePercIBCapFed());
    qUpdate.setBoolean(ES_AGE_PERC_IVA, pers.isAgentePercIVA());
    
    qUpdate.executeUpdate();
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    final int OID_SUCURSAL = 1;
    Sucursal pers = (Sucursal) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("update geSucursales "+
                     " set activo=0 " +
                     " where " +
                     " oid_sucursal=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_SUCURSAL, pers.getOID());
    qUpdate.executeUpdate();
    qUpdate.close();
  }

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    final int OID_SUCURSAL = 1;
    Sucursal pers = (Sucursal) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("update geSucursales "+
                     " set activo=1 " +
                     " where " +
                     " oid_sucursal=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_SUCURSAL, pers.getOID());
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
      case SELECT_ALL: {
        ps = this.selectAll(aCondiciones);
        break;
      }
      case SELECT_BY_GRUPO_CAJAS: {
          ps = this.selectByGrupoCajas(aCondiciones);
          break;
      }
    }
    return ps;
  }

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

    final int OID_SUCURSAL = 1;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  geSucursales ");
    textSQL.append(" WHERE oid_sucursal = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    int oid = ( (Integer) aCondiciones).intValue();
    querySelect.setInt(OID_SUCURSAL, oid);
    return querySelect;
  }
  
  
  private PreparedStatement selectByGrupoCajas(Object aCondiciones) throws BaseException, SQLException {

	    StringBuffer textSQL = new StringBuffer();
	    
	    
	    textSQL.append("select * from geSucursales where activo=1 and oid_sucursal in ( ");
	    textSQL.append("		   select oid_sucursal from geUnidadOrg where oid_uni_org in  ( ");
	    textSQL.append("		       select oid_uni_org from vaCaja where activo=1 and (oid_caja in ( ");
	    textSQL.append("		                                         select oid_caja from vaGrupoCajaDet where oid_grupo_caja  = ? and activo = 1 ");
	    textSQL.append("		                                         )))) order by oid_sucursal	    "); // para que siempre respete el mismo orden
	    
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
	    GrupoCajas grupoCajas = (GrupoCajas) aCondiciones;
	    querySelect.setInt(1, grupoCajas.getOID());
	    return querySelect;
  
  }


  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

    final int CODIGO = 1;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  geSucursales ");
    textSQL.append(" WHERE codigo = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    String codigo = (String) aCondiciones;
    querySelect.setString(CODIGO, codigo);
    return querySelect;
  }

  private PreparedStatement selectAll(Object aCondiciones) throws BaseException, SQLException {
    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  geSucursales ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    return querySelect;
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_sucursal oid,codigo codigo, descripcion descripcion ,activo ");
    textSQL.append(" from geSucursales");

    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    return querySelect;
  }

  public static List getSucursales(ISesion aSesion) throws BaseException {
    return (List) ObjetoLogico.getObjects(Sucursal.NICKNAME,
                                          DBSucursal.SELECT_ALL,
                                          null,
                                          new ListObserver(),
                                          aSesion);
  }
  
  public static List getSucursales(GrupoCajas grupoCajas,ISesion aSesion) throws BaseException {
	    return (List) ObjetoLogico.getObjects(Sucursal.NICKNAME,
	                                          DBSucursal.SELECT_BY_GRUPO_CAJAS,
	                                          grupoCajas,
	                                          new ListObserver(),
	                                          aSesion);
  }  


}
