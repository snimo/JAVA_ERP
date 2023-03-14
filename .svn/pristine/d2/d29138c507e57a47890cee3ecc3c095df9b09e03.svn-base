package com.srn.erp.ventas.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.general.bm.Periodo;
import com.srn.erp.general.da.DBPeriodo;
import com.srn.erp.ventas.bm.ContactoSujeto;
import com.srn.erp.ventas.bm.Sujeto;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Servicios.ServicioPoolBD;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.PoolBD.IPoolBD;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.Utils.ObjetoObservado;

public class DBContactoSujeto extends DBObjetoPersistente {

  public static final String OID_CONTAC_SUJ = "oid_contac_suj";
  public static final String DESCRIPCION = "descripcion";
  public static final String OID_PROVINCIA = "oid_provincia";
  public static final String OID_PAIS = "oid_pais";
  public static final String APELLIDO = "apellido";
  public static final String NOMBRE = "nombre";
  public static final String TELEFONOS = "telefonos";
  public static final String FAX = "fax";
  public static final String DIRECCION = "direccion";
  public static final String LOCALIDAD = "localidad";
  public static final String CODIGO_POSTAL = "codigo_postal";
  public static final String MAIL = "mail";
  public static final String SECTOR = "sector";
  public static final String CARGO = "cargo";
  public static final String SUJETO = "oid_sujeto";
  public static final String ACTIVO = "activo";
  public static final String RECLAMAR_PAGO = "reclamar_pago";
  public static final String PASAR_A_COBRAR = "pasar_a_cobrar";
  
  

  public static final int SELECT_BY_SUJETO = 100;
  public static final int SELECT_BY_SUJETO_DESC = 101;

  public DBContactoSujeto() {
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

    final int OID_CONTAC_SUJ = 1;
    final int DESCRIPCION = 2;
    final int OID_PROVINCIA = 3;
    final int OID_PAIS = 4;
    final int APELLIDO = 5;
    final int NOMBRE = 6;
    final int TELEFONOS = 7;
    final int FAX = 8;
    final int DIRECCION = 9;
    final int LOCALIDAD = 10;
    final int CODIGO_POSTAL = 11;
    final int MAIL = 12;
    final int SECTOR = 13;
    final int CARGO = 14;
    final int SUJETO = 15;
    final int ACTIVO = 16;
    final int PASAR_A_COBRAR = 17;
    final int RECLAMAR_PAGO = 18;

    ContactoSujeto pers = (ContactoSujeto) objetoPersistente;

    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into veContacSuj "+
                     " ( "+
                      "OID_CONTAC_SUJ,"+
                      "DESCRIPCION,"+
                      "OID_PROVINCIA,"+
                      "OID_PAIS,"+
                      "APELLIDO,"+
                      "NOMBRE,"+
                      "TELEFONOS,"+
                      "FAX,"+
                      "DIRECCION,"+
                      "LOCALIDAD,"+
                      "CODIGO_POSTAL,"+
                      "MAIL,"+
                      "SECTOR,"+
                      "CARGO,"+
                      "OID_SUJETO,"+
                      "ACTIVO,PASAR_A_COBRAR,RECLAMAR_PAGO)"+
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
                      "?,"+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
    qInsert.setInt(OID_CONTAC_SUJ,pers.getOID());

    if (pers.getDescripcion()!=null)
      qInsert.setString(DESCRIPCION,pers.getDescripcion());
    else
      qInsert.setString(DESCRIPCION,"");

    if (pers.getProvincia()!=null)
      qInsert.setInt(OID_PROVINCIA,pers.getProvincia().getOID());
    else
      qInsert.setNull(OID_PROVINCIA,java.sql.Types.INTEGER);
    if (pers.getPais()!=null)
      qInsert.setInt(OID_PAIS,pers.getPais().getOID());
    else
      qInsert.setNull(OID_PAIS,java.sql.Types.INTEGER);

    qInsert.setString(APELLIDO,pers.getApellido());
    qInsert.setString(NOMBRE,pers.getNombre());

    if (pers.getTelefonos()!=null)
      qInsert.setString(TELEFONOS,pers.getTelefonos());
    else
      qInsert.setString(TELEFONOS,"");

    if (pers.getFax()!=null)
      qInsert.setString(FAX,pers.getFax());
    else
      qInsert.setString(FAX,"");

    if (pers.getDireccion()!=null)
      qInsert.setString(DIRECCION,pers.getDireccion());
    else
      qInsert.setString(DIRECCION,"");

    if (pers.getLocalidad()!=null)
      qInsert.setString(LOCALIDAD,pers.getLocalidad());
    else
      qInsert.setString(LOCALIDAD,"");

    if (pers.getCodigo_postal()!=null)
      qInsert.setString(CODIGO_POSTAL,pers.getCodigo_postal());
    else
      qInsert.setString(CODIGO_POSTAL,"");

    if (pers.getMail()!=null)
      qInsert.setString(MAIL,pers.getMail());
    else
      qInsert.setString(MAIL,"");

    if (pers.getSector()!=null)
      qInsert.setString(SECTOR,pers.getSector());
    else
      qInsert.setString(SECTOR,"");

    if (pers.getCargo()!=null)
      qInsert.setString(CARGO,pers.getCargo());
    else
      qInsert.setString(CARGO,"");
    
    if (pers.isPasarACobrar()!=null)
        qInsert.setBoolean(PASAR_A_COBRAR,pers.isPasarACobrar());
      else
        qInsert.setBoolean(PASAR_A_COBRAR,false);
    
    if (pers.isReclamarPago()!=null)
        qInsert.setBoolean(RECLAMAR_PAGO,pers.isReclamarPago());
      else
        qInsert.setBoolean(RECLAMAR_PAGO,false);
    
    

    qInsert.setInt(SUJETO,pers.getSujeto().getOID());
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

    final int DESCRIPCION = 1;
    final int OID_PROVINCIA = 2;
    final int OID_PAIS = 3;
    final int APELLIDO = 4;
    final int NOMBRE = 5;
    final int TELEFONOS = 6;
    final int FAX = 7;
    final int DIRECCION = 8;
    final int LOCALIDAD = 9;
    final int CODIGO_POSTAL = 10;
    final int MAIL = 11;
    final int SECTOR = 12;
    final int CARGO = 13;
    final int SUJETO = 14;
    final int ACTIVO = 15;
    final int PASAR_A_COBRAR = 16;
    final int RECLAMAR_PAGO = 17;
    final int OID_CONTAC_SUJ = 18;

    ContactoSujeto pers = (ContactoSujeto) objetoPersistente;

    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update veContacSuj set "+
              "descripcion=?"+
              ",oid_provincia=?"+
              ",oid_pais=?"+
              ",apellido=?"+
              ",nombre=?"+
              ",telefonos=?"+
              ",fax=?"+
              ",direccion=?"+
              ",localidad=?"+
              ",codigo_postal=?"+
              ",mail=?"+
              ",sector=?"+
              ",cargo=?"+
              ",oid_sujeto=?"+
              ",activo=?"+
              ",pasar_a_cobrar=?"+
              ",reclamar_pago=?"+
                 " where " +
                 " oid_contac_suj=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_CONTAC_SUJ,pers.getOID());

    if (pers.getDescripcion()!=null)
      qUpdate.setString(DESCRIPCION,pers.getDescripcion());
    else
      qUpdate.setString(DESCRIPCION,"");

    if (pers.getProvincia()!=null)
      qUpdate.setInt(OID_PROVINCIA,pers.getProvincia().getOID());
    else
      qUpdate.setNull(OID_PROVINCIA,java.sql.Types.INTEGER);
    if (pers.getPais()!=null)
      qUpdate.setInt(OID_PAIS,pers.getPais().getOID());
    else
      qUpdate.setNull(OID_PAIS,java.sql.Types.INTEGER);

    qUpdate.setString(APELLIDO,pers.getApellido());
    qUpdate.setString(NOMBRE,pers.getNombre());

    if (pers.getTelefonos()!=null)
      qUpdate.setString(TELEFONOS,pers.getTelefonos());
    else
      qUpdate.setString(TELEFONOS,"");

    if (pers.getFax()!=null)
      qUpdate.setString(FAX,pers.getFax());
    else
      qUpdate.setString(FAX,"");

    if (pers.getDireccion()!=null)
      qUpdate.setString(DIRECCION,pers.getDireccion());
    else
      qUpdate.setString(DIRECCION,"");

    if (pers.getLocalidad()!=null)
      qUpdate.setString(LOCALIDAD,pers.getLocalidad());
    else
      qUpdate.setString(LOCALIDAD,"");

    if (pers.getCodigo_postal()!=null)
      qUpdate.setString(CODIGO_POSTAL,pers.getCodigo_postal());
    else
      qUpdate.setString(CODIGO_POSTAL,"");

    if (pers.getMail()!=null)
      qUpdate.setString(MAIL,pers.getMail());
    else
      qUpdate.setString(MAIL,"");

    if (pers.getSector()!=null)
      qUpdate.setString(SECTOR,pers.getSector());
    else
      qUpdate.setString(SECTOR,"");

    if (pers.getCargo()!=null)
      qUpdate.setString(CARGO,pers.getCargo());
    else
      qUpdate.setString(CARGO,"");

    qUpdate.setInt(SUJETO,pers.getSujeto().getOID());
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    
    if (pers.isPasarACobrar()!=null)
    	qUpdate.setBoolean(PASAR_A_COBRAR,pers.isPasarACobrar());
      else
    	qUpdate.setBoolean(PASAR_A_COBRAR,false);
    
    if (pers.isReclamarPago()!=null)
    	qUpdate.setBoolean(RECLAMAR_PAGO,pers.isReclamarPago());
      else
    	  qUpdate.setBoolean(RECLAMAR_PAGO,false);
    
    qUpdate.executeUpdate();
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    final int OID_CONTAC_SUJ = 1;
    ContactoSujeto pers = (ContactoSujeto) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("update veContacSuj "+
                     " set activo=0 " +
                     " where " +
                     " oid_contac_suj=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_CONTAC_SUJ, pers.getOID());
    qUpdate.executeUpdate();
    qUpdate.close();
  }

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    final int OID_CONTAC_SUJ = 1;
    ContactoSujeto pers = (ContactoSujeto) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("update veContacSuj "+
                     " set activo=1 " +
                     " where " +
                     " oid_contac_suj=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_CONTAC_SUJ, pers.getOID());
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
      case SELECT_BY_SUJETO: {
        ps = this.selectBySujeto(aCondiciones);
        break;
      }
      case SELECT_BY_SUJETO_DESC: {
          ps = this.selectBySujetoDescripcion(aCondiciones);
          break;
      }

    }
    return ps;
  }

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

    final int OID_CONTAC_SUJ = 1;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  veContacSuj ");
    textSQL.append(" WHERE oid_contac_suj = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    int oid = ( (Integer) aCondiciones).intValue();
    querySelect.setInt(OID_CONTAC_SUJ, oid);
    return querySelect;
  }
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

    final int CODIGO = 1;
    
    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  veContacSuj ");
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    String codigo = (String) aCondiciones;
    querySelect.setString(CODIGO, codigo);
    return querySelect;
  }
  
  private PreparedStatement selectBySujetoDescripcion(Object aCondiciones) throws BaseException, SQLException {

	    HashTableDatos condiciones = (HashTableDatos) aCondiciones;
	    Sujeto sujeto = (Sujeto) condiciones.get(Sujeto.NICKNAME);
	    String descripcion = (String) condiciones.get("DESCRIPCION");
	    
	    StringBuffer textSQL = new StringBuffer();
	    textSQL.append("SELECT * FROM  veContacSuj ");
	    textSQL.append(" WHERE oid_sujeto = ? and descripcion = ? ");
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
	    querySelect.setInt(1, sujeto.getOID());
	    querySelect.setString(2, descripcion);
	    return querySelect;
  }
  
  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    MapDatos map = (MapDatos) aCondiciones;
    Integer oidCliente = map.getInteger("oid_cliente");

	String caracter = "||";
	if (this.getSesion().getServicios().getServPoolBD(ServicioPoolBD.FILE_POOL_BD).getPoolBD().getTipoBD().equals(IPoolBD.MSSQLServer))
		caracter = "+";
    
    textSQL.append("SELECT oid_contac_suj oid, descripcion codigo, nombre"+caracter+"' '"+caracter+"apellido descripcion ,activo ");
    textSQL.append(" from veContacSuj");
    textSQL.append(" where oid_sujeto="+oidCliente.toString());

    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    return querySelect;
  }

  private PreparedStatement selectBySujeto(Object aCondiciones) throws BaseException, SQLException {
    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  veContacSuj ");
    textSQL.append(" WHERE  oid_sujeto = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    Sujeto sujeto = (Sujeto) aCondiciones;
    querySelect.setInt(1, sujeto.getOID());
    return querySelect;
  }

  public static List getContactos(Sujeto sujeto,
                                       ISesion aSesion) throws BaseException {
    return (List) ObjetoLogico.getObjects(ContactoSujeto.NICKNAME,
                                          DBContactoSujeto.SELECT_BY_SUJETO,
                                          sujeto,
                                          new ListObserver(),
                                          aSesion);
  }

  public static ContactoSujeto getContactoSujeto(Sujeto sujeto,
		  String descripcion,
          ISesion aSesion)
          throws BaseException {
	  HashTableDatos condiciones = new HashTableDatos();
	  condiciones.put(Sujeto.NICKNAME, sujeto);
	  condiciones.put("DESCRIPCION", descripcion);
	  
	  return (ContactoSujeto) ObjetoLogico.getObjects(ContactoSujeto.NICKNAME,
			  				DBContactoSujeto.SELECT_BY_SUJETO_DESC,
			  				condiciones,
			  				new ObjetoObservado(),
			  				aSesion);
  }


}
