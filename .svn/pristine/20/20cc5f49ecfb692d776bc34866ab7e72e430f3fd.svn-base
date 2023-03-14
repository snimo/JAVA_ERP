package com.srn.erp.ventas.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.general.bm.Empresa;
import com.srn.erp.general.bm.Sucursal;
import com.srn.erp.ventas.bm.CondicionPago;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.applicarionServer.bm.Seguridad.Usuario;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;

public class DBCondicionPago extends DBObjetoPersistente {

  public static final String OID_COND_PAGO = "oid_cond_pago";
  public static final String CODIGO = "codigo";
  public static final String DESCRIPCION = "descripcion";
  public static final String COMPORTAMIENTO = "comportamiento";
  public static final String OID_COND_VTA = "oid_cond_vta";
  public static final String PORC_DTO = "porc_dto";
  public static final String PORC_RECA = "porc_reca";
  public static final String OID_TAR_CREDITO = "oid_tar_credito";
  public static final String OID_GRUPO_CP = "oid_grupo_cp";
  public static final String ACTIVO = "activo";
  public static final String USAR_EN_VTAS = "usar_en_vtas";
  
  public static final int SELECT_BY_SUCURSAL_Y_VTAS = 100;

  public DBCondicionPago() {
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

    final int OID_COND_PAGO = 1;
    final int CODIGO = 2;
    final int DESCRIPCION = 3;
    final int COMPORTAMIENTO = 4;
    final int OID_COND_VTA = 5;
    final int PORC_DTO = 6;
    final int PORC_RECA = 7;
    final int OID_TAR_CREDITO = 8;
    final int OID_GRUPO_CP = 9;
    final int ACTIVO = 10;
    final int USAR_EN_VTAS = 11;

    CondicionPago pers = (CondicionPago) objetoPersistente;

    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into veCondPago "+
                     " ( "+
                      "OID_COND_PAGO,"+
                      "CODIGO,"+
                      "DESCRIPCION,"+
                      "COMPORTAMIENTO,"+
                      "OID_COND_VTA,"+
                      "PORC_DTO,"+
                      "PORC_RECA,"+
                      "OID_TAR_CREDITO,"+
                      "OID_GRUPO_CP,"+
                      "ACTIVO, USAR_EN_VTAS)"+
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
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
    qInsert.setInt(OID_COND_PAGO,pers.getOID());
    qInsert.setString(CODIGO,pers.getCodigo());
    qInsert.setString(DESCRIPCION,pers.getDescripcion());
    qInsert.setString(COMPORTAMIENTO,pers.getComportamiento());
    if (pers.getCondicion_vta()!=null)
      qInsert.setInt(OID_COND_VTA,pers.getCondicion_vta().getOID());
    else
      qInsert.setNull(OID_COND_VTA,java.sql.Types.INTEGER);
    if (pers.getPorc_desc()!=null)
      qInsert.setDouble(PORC_DTO,pers.getPorc_desc().doubleValue());
    else
      qInsert.setNull(PORC_DTO,java.sql.Types.DOUBLE);
    if (pers.getPorc_reca()!=null)
      qInsert.setDouble(PORC_RECA,pers.getPorc_reca().doubleValue());
    else
      qInsert.setNull(PORC_RECA,java.sql.Types.DOUBLE);
    if (pers.getTarjeta_credito()!=null)
      qInsert.setInt(OID_TAR_CREDITO,pers.getTarjeta_credito().getOID());
    else
      qInsert.setInt(OID_TAR_CREDITO,java.sql.Types.DOUBLE);
    qInsert.setInt(OID_GRUPO_CP,pers.getGrupo_cond_pago().getOID());
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qInsert.setBoolean(USAR_EN_VTAS, pers.isUsarEnVtas());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

    final int CODIGO = 1;
    final int DESCRIPCION = 2;
    final int COMPORTAMIENTO = 3;
    final int OID_COND_VTA = 4;
    final int PORC_DTO = 5;
    final int PORC_RECA = 6;
    final int OID_TAR_CREDITO = 7;
    final int OID_GRUPO_CP = 8;
    final int ACTIVO = 9;
    final int USAR_EN_VTAS = 10;
    final int OID_COND_PAGO = 11;

    CondicionPago pers = (CondicionPago) objetoPersistente;

    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update veCondPago set "+
              "codigo=?"+
              ",descripcion=?"+
              ",comportamiento=?"+
              ",oid_cond_vta=?"+
              ",porc_dto=?"+
              ",porc_reca=?"+
              ",oid_tar_credito=?"+
              ",oid_grupo_cp=?"+
              ",activo=?"+
              ",usar_en_vtas=?"+
                 " where " +
                 " oid_cond_pago=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_COND_PAGO,pers.getOID());
    qUpdate.setString(CODIGO,pers.getCodigo());
    qUpdate.setString(DESCRIPCION,pers.getDescripcion());
    qUpdate.setString(COMPORTAMIENTO,pers.getComportamiento());
    if (pers.getCondicion_vta()!=null)
      qUpdate.setInt(OID_COND_VTA,pers.getCondicion_vta().getOID());
    else
      qUpdate.setNull(OID_COND_VTA,java.sql.Types.INTEGER);
    if (pers.getPorc_desc()!=null)
      qUpdate.setDouble(PORC_DTO,pers.getPorc_desc().doubleValue());
    else
      qUpdate.setNull(PORC_DTO,java.sql.Types.DOUBLE);
    if (pers.getPorc_reca()!=null)
      qUpdate.setDouble(PORC_RECA,pers.getPorc_reca().doubleValue());
    else
      qUpdate.setNull(PORC_RECA,java.sql.Types.DOUBLE);
    if (pers.getTarjeta_credito()!=null)
      qUpdate.setInt(OID_TAR_CREDITO,pers.getTarjeta_credito().getOID());
    else
      qUpdate.setInt(OID_TAR_CREDITO,java.sql.Types.DOUBLE);
    qUpdate.setInt(OID_GRUPO_CP,pers.getGrupo_cond_pago().getOID());
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.setBoolean(USAR_EN_VTAS,pers.isUsarEnVtas());
    qUpdate.executeUpdate();
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    final int OID_COND_PAGO = 1;
    CondicionPago pers = (CondicionPago) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("update veCondPago "+
                     " set activo=0 " +
                     " where " +
                     " oid_cond_pago=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_COND_PAGO, pers.getOID());
    qUpdate.executeUpdate();
    qUpdate.close();
  }

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    final int OID_COND_PAGO = 1;
    CondicionPago pers = (CondicionPago) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("update veCondPago "+
                     " set activo=1 " +
                     " where " +
                     " oid_cond_pago=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_COND_PAGO, pers.getOID());
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
      case IDBObjetoPersistente.SELECT_ALL: {
        ps = this.selectAll(aCondiciones);
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
      case SELECT_BY_SUCURSAL_Y_VTAS: {
        ps = this.selectBySucursalyVtas(aCondiciones);
        break;
      }
      
    }
    return ps;
  }

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

    final int OID_COND_PAGO = 1;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  veCondPago ");
    textSQL.append(" WHERE oid_cond_pago = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    int oid = ( (Integer) aCondiciones).intValue();
    querySelect.setInt(OID_COND_PAGO, oid);
    return querySelect;
  }
  
  private PreparedStatement selectBySucursalyVtas(Object aCondiciones) throws BaseException, SQLException {
  	HashTableDatos cond = (HashTableDatos) aCondiciones;
  	Empresa empresa = (Empresa) cond.get(Empresa.NICKNAME);
  	Sucursal sucursal = (Sucursal) cond.get(Sucursal.NICKNAME);
  	Usuario usuario = (Usuario) cond.get(Usuario.NICKNAME);
  	
    StringBuffer textSQL = new StringBuffer();
    textSQL.append("select * from veCondPago where usar_en_vtas=1 ");
    textSQL.append(" and oid_cond_pago in (select oid_cond_pago from veCondPagoUniOrg where ");
    textSQL.append(" oid_uni_org in (select oid_uni_org from seUniOrgHabUsu where oid_empresa = ? and oid_sucursal = ? and oid_usuario = ?)) ");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    querySelect.setInt(1,empresa.getOID());
    querySelect.setInt(2,sucursal.getOID());
    querySelect.setInt(3,usuario.getOID());
    return querySelect;
  }
  

  private PreparedStatement selectAll(Object aCondiciones) throws BaseException, SQLException {
    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  veCondPago ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    String codigo = (String) aCondiciones;
    return querySelect;
  }


  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

    final int CODIGO = 1;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  veCondPago ");
    textSQL.append(" WHERE codigo = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    String codigo = (String) aCondiciones;
    querySelect.setString(CODIGO, codigo);
    return querySelect;
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_cond_pago oid,codigo codigo, descripcion descripcion ,activo ");
    textSQL.append(" from veCondPago");

    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    return querySelect;
  }

  public static List getCondicionesDePago(ISesion aSesion) throws BaseException {
    return (List) ObjetoLogico.getObjects(CondicionPago.NICKNAME,
                                          DBCondicionPago.SELECT_ALL,
                                          null,
                                          new ListObserver(),
                                          aSesion);
  }
  
  public static List getCondicionesDePago(ISesion aSesion,
  																				Empresa empresa,	
  		                                    Sucursal sucursal,
  		                                    Usuario usuario) throws BaseException {
  	HashTableDatos condiciones = new HashTableDatos();
  	condiciones.put(Empresa.NICKNAME,empresa);
  	condiciones.put(Sucursal.NICKNAME,sucursal);
  	condiciones.put(Usuario.NICKNAME,usuario);
  	
    return (List) ObjetoLogico.getObjects(CondicionPago.NICKNAME,
                                          DBCondicionPago.SELECT_BY_SUCURSAL_Y_VTAS,
                                          condiciones,
                                          new ListObserver(),
                                          aSesion);
  }  


}
