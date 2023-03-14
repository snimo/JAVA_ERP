package com.srn.erp.ventas.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Hashtable;
import java.util.List;

import com.srn.erp.ventas.bm.ListaPrecios;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.Fecha;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;

public class DBListaPrecios extends DBObjetoPersistente {

  public static final String OID_PRECIO_CAB = "oid_precio_cab";
  public static final String CODIGO = "codigo";
  public static final String DESCRIPCION = "descripcion";
  public static final String COMENTARIO = "comentario";
  public static final String FEC_VIG_DESDE = "fec_vig_desde";
  public static final String FEC_VIG_HASTA = "fec_vig_hasta";
  public static final String ACTIVO = "activo";
  public static final String INCLUYE_IVA = "incluye_iva";
  
  public final static int LISTA_PRECIOS = 100;
  public final static int SELECT_TODAS = 101;


  public DBListaPrecios() {
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

    final int OID_PRECIO_CAB = 1;
    final int CODIGO = 2;
    final int DESCRIPCION = 3;
    final int COMENTARIO = 4;
    final int FEC_VIG_DESDE = 5;
    final int FEC_VIG_HASTA = 6;
    final int ACTIVO = 7;
    final int INCLUYE_IVA = 8;
  
    ListaPrecios pers = (ListaPrecios) objetoPersistente;

    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into vePreciosCab "+
                     " ( "+
                      "OID_PRECIO_CAB,"+
                      "CODIGO,"+
                      "DESCRIPCION,"+
                      "COMENTARIO,"+
                      "FEC_VIG_DESDE,"+
                      "FEC_VIG_HASTA,"+
                      "ACTIVO," +
                      "INCLUYE_IVA)"+
                      " values "+
                      "("+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
    qInsert.setInt(OID_PRECIO_CAB,pers.getOID());
    qInsert.setString(CODIGO,pers.getCodigo());
    qInsert.setString(DESCRIPCION,pers.getDescripcion());
    if (pers.getComentario()!=null)
      qInsert.setString(COMENTARIO,pers.getComentario());
    else
      qInsert.setString(COMENTARIO,"");
    qInsert.setDate(FEC_VIG_DESDE,new java.sql.Date(pers.getFec_vig_desde().getTime()));
    qInsert.setDate(FEC_VIG_HASTA,new java.sql.Date(pers.getFec_vig_hasta().getTime()));
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qInsert.setBoolean(INCLUYE_IVA, pers.isIncluyeIVA().booleanValue());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

    final int CODIGO = 1;
    final int DESCRIPCION = 2;
    final int COMENTARIO = 3;
    final int FEC_VIG_DESDE = 4;
    final int FEC_VIG_HASTA = 5;
    final int ACTIVO = 6;
    final int INCLUYE_IVA = 7;
    final int OID_PRECIO_CAB = 8;

    ListaPrecios pers = (ListaPrecios) objetoPersistente;

    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update vePreciosCab set "+
              "codigo=?"+
              ",descripcion=?"+
              ",comentario=?"+
              ",fec_vig_desde=?"+
              ",fec_vig_hasta=?"+
              ",activo=?"+
              ",incluye_iva=?"+
                 " where " +
                 " oid_precio_cab=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_PRECIO_CAB,pers.getOID());
    qUpdate.setString(CODIGO,pers.getCodigo());
    qUpdate.setString(DESCRIPCION,pers.getDescripcion());
    if (pers.getComentario()!=null)
      qUpdate.setString(COMENTARIO,pers.getComentario());
    else
      qUpdate.setString(COMENTARIO,"");
    qUpdate.setDate(FEC_VIG_DESDE,new java.sql.Date(pers.getFec_vig_desde().getTime()));
    qUpdate.setDate(FEC_VIG_HASTA,new java.sql.Date(pers.getFec_vig_hasta().getTime()));
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.setBoolean(INCLUYE_IVA, pers.isIncluyeIVA().booleanValue());
    qUpdate.executeUpdate();
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    final int OID_PRECIO_CAB = 1;
    ListaPrecios pers = (ListaPrecios) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("update vePreciosCab "+
                     " set activo=0 " +
                     " where " +
                     " oid_precio_cab=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_PRECIO_CAB, pers.getOID());
    qUpdate.executeUpdate();
    qUpdate.close();
  }

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    final int OID_PRECIO_CAB = 1;
    ListaPrecios pers = (ListaPrecios) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("update vePreciosCab "+
                     " set activo=1 " +
                     " where " +
                     " oid_precio_cab=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_PRECIO_CAB, pers.getOID());
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
      case LISTA_PRECIOS: {
        ps = this.selectByListaPreciosPorFechas(aCondiciones);
        break;
      }
      case SELECT_TODAS: {
          ps = this.selectByTodas(aCondiciones);
          break;
      }
    }
    return ps;
  }

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

    final int OID_PRECIO_CAB = 1;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  vePreciosCab ");
    textSQL.append(" WHERE oid_precio_cab = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    int oid = ( (Integer) aCondiciones).intValue();
    querySelect.setInt(OID_PRECIO_CAB, oid);
    return querySelect;
  }
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

    final int CODIGO = 1;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  vePreciosCab ");
    textSQL.append(" WHERE codigo = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    String codigo = (String) aCondiciones;
    querySelect.setString(CODIGO, codigo);
    return querySelect;
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_precio_cab oid,codigo codigo, descripcion descripcion ,activo ");
    textSQL.append(" from vePreciosCab");

    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    return querySelect;
  }

  private PreparedStatement selectByListaPreciosPorFechas(Object aCondiciones) throws BaseException, SQLException {

    java.util.Date fecha = Fecha.getFechaActual();
    int nroParam=0;
    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  vePreciosCab  ");
    textSQL.append(" where  1=1 ");
    Hashtable condiciones = (Hashtable) aCondiciones;
    if (condiciones.containsKey("listas_vigentes"))
      textSQL.append("  and fec_vig_desde<=? and fec_vig_hasta>=? ");
    if (condiciones.containsKey("listas_habilitadas"))
      textSQL.append("  and activo = 1 ");

    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    if (condiciones.containsKey("listas_vigentes")) {
      ++nroParam;
      querySelect.setDate(nroParam, new java.sql.Date(fecha.getTime()));
      ++nroParam;
      querySelect.setDate(nroParam, new java.sql.Date(fecha.getTime()));
    }
    return querySelect;

  }
  
  private PreparedStatement selectByTodas(Object aCondiciones) throws BaseException, SQLException {

	    java.util.Date fecha = Fecha.getFechaActual();
	    int nroParam=0;
	    StringBuffer textSQL = new StringBuffer();
	    textSQL.append("SELECT * FROM  vePreciosCab  ");
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
	    return querySelect;

	  }
  

  public static List getListaPrecios(boolean soloVigentes,
                                     boolean soloHabilitadas,
                                     ISesion aSesion) throws BaseException {
    Hashtable condiciones = new Hashtable();
    if (soloVigentes) condiciones.put("listas_vigentes","");
    if (soloHabilitadas) condiciones.put("listas_habilitadas","");
    return (List) ObjetoLogico.getObjects(ListaPrecios.NICKNAME,
                                          DBListaPrecios.LISTA_PRECIOS,
                                          condiciones,
                                          new ListObserver(),
                                          aSesion);
  }
  
  public static List getTodasLasListas(ISesion aSesion) throws BaseException {
	  return (List) ObjetoLogico.getObjects(ListaPrecios.NICKNAME,
               DBListaPrecios.SELECT_TODAS,
               null,
               new ListObserver(),
               aSesion);
  }
  




}
