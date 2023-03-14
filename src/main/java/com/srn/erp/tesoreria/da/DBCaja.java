package com.srn.erp.tesoreria.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.general.bm.Sucursal;
import com.srn.erp.general.bm.UnidadOrganizativa;
import com.srn.erp.tesoreria.bm.Caja;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;

public class DBCaja extends DBObjetoPersistente {

  public static final String OID_CAJA = "oid_caja";
  public static final String CODIGO = "codigo";
  public static final String DESCRIPCION = "descripcion";
  public static final String OID_UNI_ORG = "oid_uni_org";
  public static final String COMPO = "compo";
  public static final String ACTIVO = "activo";
  public static final String TIPO_CIERRE_CAJA = "tipo_cie_aper";

  public static final int SELECT_BY_UNI_ORG = 100;
  public static final int SELECT_HELP_CAJA_OPER_UNI_ORG_USU = 101;
  public static final int SELECT_VALIDAR_CAJA_OPER_UNI_ORG_USU = 102;
  public static final int SELECT_BY_SUCURSAL = 103;
  public static final int SELECT_CAJAS_OPER_ACTIVAS = 104;


  public DBCaja() {
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

    final int OID_CAJA = 1;
    final int DESCRIPCION = 2;
    final int OID_UNI_ORG = 3;
    final int COMPO = 4;
    final int ACTIVO = 5;
    final int CODIGO = 6;
    final int TIPO_CIE_APER = 7;

    Caja pers = (Caja) objetoPersistente;

    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into vaCaja "+
                     " ( "+
                      "OID_CAJA,"+
                      "DESCRIPCION,"+
                      "OID_UNI_ORG,"+
                      "COMPO,"+
                      "ACTIVO,"+
                      "CODIGO,"+
                      "TIPO_CIE_APER)"+
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
    qInsert.setInt(OID_CAJA,pers.getOID());
    qInsert.setString(DESCRIPCION,pers.getDescripcion());
    qInsert.setInt(OID_UNI_ORG,pers.getUnidadorganizativa().getOID());
    qInsert.setString(COMPO,pers.getCompo());
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qInsert.setString(CODIGO,pers.getCodigo());
    qInsert.setString(TIPO_CIE_APER,pers.getTipoCierreApertura());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

    final int DESCRIPCION = 1;
    final int OID_UNI_ORG = 2;
    final int COMPO = 3;
    final int CODIGO = 4;
    final int ACTIVO = 5;
    final int TIPO_CIERRE_CAJA = 6;
    final int OID_CAJA = 7;

    Caja pers = (Caja) objetoPersistente;

    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update vaCaja set "+
              "descripcion=?"+
              ",oid_uni_org=?"+
              ",compo=?"+
              ",codigo=?"+
              ",activo=?"+
              ",tipo_cie_aper=?"+
                 " where " +
                 " oid_caja=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_CAJA,pers.getOID());
    qUpdate.setString(DESCRIPCION,pers.getDescripcion());
    qUpdate.setInt(OID_UNI_ORG,pers.getUnidadorganizativa().getOID());
    qUpdate.setString(COMPO,pers.getCompo());
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.setString(CODIGO,pers.getCodigo());
    qUpdate.setString(TIPO_CIERRE_CAJA,pers.getTipoCierreApertura());
    qUpdate.executeUpdate();
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    final int OID_CAJA = 1;
    Caja pers = (Caja) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("update vaCaja "+
                     " set activo=0 " +
                     " where " +
                     " oid_caja=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_CAJA, pers.getOID());
    qUpdate.executeUpdate();
    qUpdate.close();
  }

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    final int OID_CAJA = 1;
    Caja pers = (Caja) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("update vaCaja "+
                     " set activo=1 " +
                     " where " +
                     " oid_caja=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_CAJA, pers.getOID());
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
      case SELECT_VALIDAR_CAJA_OPER_UNI_ORG_USU: {
          ps = this.selectByCodigoCajaOperUniOrgUsu(aCondiciones);
          break;
        }
      case IDBObjetoPersistente.SELECT_ALL_HELP: {
        ps = this.selectAllHelp(aCondiciones);
        break;
      }
      case SELECT_BY_UNI_ORG: {
        ps = this.selectByUniOrg(aCondiciones);
        break;
      }
      case SELECT_HELP_CAJA_OPER_UNI_ORG_USU: {
          ps = this.selectHelpCajaOperUniOrgUsu(aCondiciones);
          break;
      }
      case SELECT_BY_SUCURSAL: {
          ps = this.selectBySucursal(aCondiciones);
          break;
      }
      case SELECT_CAJAS_OPER_ACTIVAS: {
          ps = this.selectByCajasOperativasActivas(aCondiciones);
          break;
      }
      
    }
    return ps;
  }

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

    final int OID_CAJA = 1;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  vaCaja ");
    textSQL.append(" WHERE oid_caja = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    int oid = ( (Integer) aCondiciones).intValue();
    querySelect.setInt(OID_CAJA, oid);
    return querySelect;
  }
  
  private PreparedStatement selectByCajasOperativasActivas(Object aCondiciones) throws BaseException, SQLException {
	    StringBuffer textSQL = new StringBuffer();
	    textSQL.append("SELECT * FROM  vaCaja ");
	    textSQL.append(" WHERE  compo = 'OPER' and activo=1 ");
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
	    return querySelect;
 }
  
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

    final int CODIGO = 1;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  vaCaja ");
    textSQL.append(" WHERE  codigo = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    String codigo = (String) aCondiciones;
    querySelect.setString(CODIGO, codigo);
    return querySelect;
  }
  
  private PreparedStatement selectByCodigoCajaOperUniOrgUsu(Object aCondiciones) throws BaseException, SQLException {

	    StringBuffer textSQL = new StringBuffer();
	    textSQL.append("SELECT * FROM  vaCaja ");
	    textSQL.append(" WHERE  codigo = ? and compo = 'OPER' and oid_uni_org in (select oid_uni_org from seUniOrgHabUsu where oid_empresa = ? and "); 
	    textSQL.append(" oid_sucursal = ? and oid_usuario = ? )");

	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
	    HashTableDatos condiciones = (HashTableDatos) aCondiciones;
	    querySelect.setString(1, (String) condiciones.getString("codigo"));
	    querySelect.setInt(2, this.getSesion().getLogin().getOidEmpresa());
	    querySelect.setInt(3, this.getSesion().getLogin().getOidSucursal());
	    querySelect.setInt(4, this.getSesion().getLogin().getUsuario().getOID());
	    return querySelect;
	  }
  
  
  

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_caja oid, codigo codigo,  descripcion ,activo ");
    textSQL.append(" from vaCaja");

    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    return querySelect;
  }
  
  private PreparedStatement selectHelpCajaOperUniOrgUsu(Object aCondiciones) throws BaseException, SQLException {

	    StringBuffer textSQL = new StringBuffer();

	    textSQL.append("SELECT oid_caja oid, codigo codigo,  descripcion ,activo ");
	    textSQL.append(" from vaCaja where compo = 'OPER' and oid_uni_org in (select oid_uni_org from seUniOrgHabUsu where oid_empresa = ? and "); 
	    textSQL.append(" oid_sucursal = ? and oid_usuario = ? )");

	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
	    querySelect.setInt(1, this.getSesion().getLogin().getOidEmpresa());
	    querySelect.setInt(2, this.getSesion().getLogin().getOidSucursal());
	    querySelect.setInt(3, this.getSesion().getLogin().getUsuario().getOID());
	    
	    
	    return querySelect;
  }
  

  private PreparedStatement selectBySucursal(Object aCondiciones) throws BaseException, SQLException {
	    StringBuffer textSQL = new StringBuffer();
	    textSQL.append("SELECT * FROM  vaCaja ");
	    textSQL.append(" WHERE activo=1 and oid_uni_org in (select oid_uni_org from geUnidadOrg where oid_sucursal=? and activo=1) order by oid_caja ");
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
	    Sucursal sucursal = (Sucursal) aCondiciones;
	    querySelect.setInt(1, sucursal.getOID());
	    return querySelect;
  }
  
  

  private PreparedStatement selectByUniOrg(Object aCondiciones) throws BaseException, SQLException {
    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  vaCaja ");
    textSQL.append(" WHERE  oid_uni_org = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    UnidadOrganizativa unidadOrganizativa = (UnidadOrganizativa) aCondiciones;
    querySelect.setInt(1, unidadOrganizativa.getOID());
    return querySelect;
  }

  public static List getCajas(UnidadOrganizativa uniOrg,
                              ISesion aSesion) throws BaseException {
    return (List) ObjetoLogico.getObjects(Caja.NICKNAME,
                                          DBCaja.SELECT_BY_UNI_ORG,
                                          uniOrg,
                                          new ListObserver(),
                                          aSesion);
  }

  public static List getCajas(Sucursal sucursal,
          ISesion aSesion) throws BaseException {
	  return (List) ObjetoLogico.getObjects(Caja.NICKNAME,
                      DBCaja.SELECT_BY_SUCURSAL,
                      sucursal,
                      new ListObserver(),
                      aSesion);
  }
  
  public static List getCajasOperativasActivo(ISesion aSesion) throws BaseException {
	  return (List) ObjetoLogico.getObjects(Caja.NICKNAME,
                      DBCaja.SELECT_CAJAS_OPER_ACTIVAS,
                      null,
                      new ListObserver(),
                      aSesion);
  }
  




}
