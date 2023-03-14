package com.srn.erp.legales.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import com.srn.erp.legales.bm.CartasDocRemLega;
import com.srn.erp.legales.bm.TipoCausaLegales;
import com.srn.erp.sueldos.bm.Legajo;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;

public class DBCartasDocRemLega extends DBObjetoPersistente {

  public static final String OID_CARTA_REMITIDA = "oid_carta_remitida";
  public static final String NRO_ORDEN = "nro_orden";
  public static final String OID_LEGAJO = "oid_legajo";
  public static final String NRO_CARTA_DOC = "nro_carta_doc";
  public static final String FECHA = "fecha";
  public static final String OID_TIPO_CAUSA = "oid_tipo_causa";
  public static final String CAUSA = "causa";
  public static final String RECIBIDO = "recibido";
  public static final String OBSERVACIONES = "observaciones";
  public static final String ACTIVO = "activo";
  
  public static final int SELECT_BY_LEGAJO = 100;
  public static final int SELECT_BY_CONDICIONES = 101;

  public DBCartasDocRemLega() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_CARTA_REMITIDA = 1;
    final int NRO_ORDEN = 2;
    final int OID_LEGAJO = 3;
    final int NRO_CARTA_DOC = 4;
    final int FECHA = 5;
    final int OID_TIPO_CAUSA = 6;
    final int CAUSA = 7;
    final int RECIBIDO = 8;
    final int OBSERVACIONES = 9;
    final int ACTIVO = 10;

    CartasDocRemLega pers = (CartasDocRemLega) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into legCartasRemitidas "+
                     " ( "+
                      "OID_CARTA_REMITIDA,"+
                      "NRO_ORDEN,"+
                      "OID_LEGAJO,"+
                      "NRO_CARTA_DOC,"+
                      "FECHA,"+
                      "OID_TIPO_CAUSA,"+
                      "CAUSA,"+
                      "RECIBIDO,"+
                      "OBSERVACIONES,"+
                      "ACTIVO)"+ 
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
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_CARTA_REMITIDA,pers.getOID());
    if (pers.getNro_orden()!=null)
    	qInsert.setInt(NRO_ORDEN,pers.getNro_orden().intValue());
    else
    	qInsert.setNull(NRO_ORDEN,Types.INTEGER);
    qInsert.setInt(OID_LEGAJO,pers.getLegajo().getOID());
    qInsert.setString(NRO_CARTA_DOC,pers.getNro_carta_doc());
    qInsert.setDate(FECHA,new java.sql.Date(pers.getFecha().getTime()));
    if (pers.getTipocausa()!=null)
    	qInsert.setInt(OID_TIPO_CAUSA,pers.getTipocausa().getOID());
    else
    	qInsert.setNull(OID_TIPO_CAUSA,Types.INTEGER);
    qInsert.setString(CAUSA,pers.getCausa());
    if (pers.getRecibido()!=null) 
      qInsert.setDate(RECIBIDO,new java.sql.Date(pers.getRecibido().getTime()));
    else
      qInsert.setNull(RECIBIDO,java.sql.Types.DATE);
    qInsert.setString(OBSERVACIONES,pers.getObservaciones());
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int NRO_ORDEN = 1;
    final int OID_LEGAJO = 2;
    final int NRO_CARTA_DOC = 3;
    final int FECHA = 4;
    final int OID_TIPO_CAUSA = 5;
    final int CAUSA = 6;
    final int RECIBIDO = 7;
    final int OBSERVACIONES = 8;
    final int ACTIVO = 9;
    final int OID_CARTA_REMITIDA = 10;

    CartasDocRemLega pers = (CartasDocRemLega) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update legCartasRemitidas set "+
              "nro_orden=?"+ 
              ",oid_legajo=?"+ 
              ",nro_carta_doc=?"+ 
              ",fecha=?"+ 
              ",oid_tipo_causa=?"+ 
              ",causa=?"+ 
              ",recibido=?"+ 
              ",observaciones=?"+ 
              ",activo=?"+ 
                 " where " +
                 " oid_carta_remitida=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_CARTA_REMITIDA,pers.getOID());
    if (pers.getNro_orden()!=null)
    	qUpdate.setInt(NRO_ORDEN,pers.getNro_orden().intValue());
    else
    	qUpdate.setNull(NRO_ORDEN,Types.INTEGER);
    qUpdate.setInt(OID_LEGAJO,pers.getLegajo().getOID());
    qUpdate.setString(NRO_CARTA_DOC,pers.getNro_carta_doc());
    qUpdate.setDate(FECHA,new java.sql.Date(pers.getFecha().getTime()));
    if (pers.getTipocausa()!=null)
    	qUpdate.setInt(OID_TIPO_CAUSA,pers.getTipocausa().getOID());
    else
    	qUpdate.setNull(OID_TIPO_CAUSA,Types.INTEGER);
    qUpdate.setString(CAUSA,pers.getCausa());
    if (pers.getRecibido()!=null) 
      qUpdate.setDate(RECIBIDO,new java.sql.Date(pers.getRecibido().getTime()));
    else
      qUpdate.setNull(RECIBIDO,java.sql.Types.DATE);
    qUpdate.setString(OBSERVACIONES,pers.getObservaciones());
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_CARTA_REMITIDA = 1; 
    CartasDocRemLega pers = (CartasDocRemLega) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update legCartasRemitidas "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_carta_remitida=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_CARTA_REMITIDA, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_CARTA_REMITIDA = 1; 
    CartasDocRemLega pers = (CartasDocRemLega) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update legCartasRemitidas "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_carta_remitida=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_CARTA_REMITIDA, pers.getOID()); 
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
      case SELECT_BY_LEGAJO: {
          ps = this.selectByLegajo(aCondiciones); 
          break; 
      }
      case SELECT_BY_CONDICIONES: {
          ps = this.selectByCondiciones(aCondiciones); 
          break;    	  
      }
    } 
    return ps;
  } 

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_CARTA_REMITIDA = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  legCartasRemitidas "); 
    textSQL.append(" WHERE oid_carta_remitida = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_CARTA_REMITIDA, oid); 
    return querySelect; 
  }

  private PreparedStatement selectByCondiciones(Object aCondiciones) throws BaseException, SQLException {
	  
	    HashTableDatos condiciones = (HashTableDatos) aCondiciones;
	    java.util.Date fecDesde = (java.util.Date) condiciones.get("FEC_DESDE");
	    java.util.Date fecHasta = (java.util.Date) condiciones.get("FEC_HASTA");
	    TipoCausaLegales tipoCausa = (TipoCausaLegales) condiciones.get(TipoCausaLegales.NICKNAME);
	    String nroCarta = (String) condiciones.get("NRO_CARTA");
	    String causa = (String) condiciones.get("CAUSA");
	    String observaciones = (String) condiciones.get("OBSERVACIONES");
	    Legajo legajo = (Legajo) condiciones.get(Legajo.NICKNAME);
	    
	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM  legCartasRemitidas "); 
	    textSQL.append(" WHERE fecha>=? and fecha<=? ");
	    
	    if (tipoCausa!=null)
	    	textSQL.append(" and oid_tipo_causa="+tipoCausa.getOIDInteger()+" ");
	    
	    if (nroCarta!=null)
	    	textSQL.append(" and upper(nro_carta_doc) like '%"+nroCarta.toUpperCase()+"%' ");
	    
	    if (causa!=null)
	    	textSQL.append(" and upper(causa) like '%"+causa.toUpperCase()+"%' ");	    
	    
	    if (observaciones!=null)
	    	textSQL.append(" and upper(observaciones) like '%"+observaciones.toUpperCase()+"%' ");
	    
	    if (legajo!=null)
	    	textSQL.append(" and oid_legajo="+legajo.getOID());
	    
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
	    querySelect.setDate(1, new java.sql.Date(fecDesde.getTime())); 
	    querySelect.setDate(2, new java.sql.Date(fecHasta.getTime()));
	    
	    return querySelect; 
  }  
  
  
  private PreparedStatement selectByLegajo(Object aCondiciones) throws BaseException, SQLException { 
	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM  legCartasRemitidas "); 
	    textSQL.append(" WHERE oid_legajo = ? and activo = 1 ");
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
	    Legajo legajo = (Legajo) aCondiciones; 
	    querySelect.setInt(1, legajo.getOID()); 
	    return querySelect; 
  }
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  legCartasRemitidas "); 
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_carta_remitida oid, codigo, nro_orden descripcion ,activo ");
    textSQL.append(" from legCartasRemitidas");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  }
  
  public static List getCartasDocRemLega(Legajo aLegajo,
          ISesion aSesion) throws BaseException {
	  return (List) ObjetoLogico.getObjects(CartasDocRemLega.NICKNAME,
             DBCartasDocRemLega.SELECT_BY_LEGAJO,
             aLegajo,
             new ListObserver(),
             aSesion);
  }
  
  public static List getCartasDocRem(HashTableDatos condiciones,
          ISesion aSesion) throws BaseException {
	  return (List) ObjetoLogico.getObjects(CartasDocRemLega.NICKNAME,
             DBCartasDocRemLega.SELECT_BY_CONDICIONES,
             condiciones,
             new ListObserver(),
             aSesion);
  }  
  
  
} 
