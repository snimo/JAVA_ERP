package com.srn.erp.cip.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.cip.bm.CIPFichadaOficina;
import com.srn.erp.general.da.DBPeriodoIncDet;
import com.srn.erp.sueldos.bm.Legajo;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.Fecha;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;

public class DBCIPFichadaOficina extends DBObjetoPersistente {

  public static final String OID_IN_OUT_OFIC = "oid_in_out_ofic";
  public static final String OID_LEGAJO = "oid_legajo";
  public static final String FEC_HOR = "fec_hor";
  public static final String SENTIDO = "sentido";
  public static final String PUNTO_FICHADA = "oid_pto_fichada";
  public static final String OID_MOTIVO_FICHADA = "oid_motivo_fichada";
  public static final String OBSERVACION = "observacion";
  public static final String ACTIVO = "activo";
  
  private static final int SELECT_BY_FECDESDE_HASTA_LEGAJO_ASC = 100;
  private static final int SELECT_BY_FECDESDE_HASTA_LEGAJO_DESC = 101;
  private static final int SELECT_BY_FECDESDE_HASTA_ORDER_LEG   = 102;

  public DBCIPFichadaOficina() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_IN_OUT_OFIC = 1;
    final int OID_LEGAJO = 2;
    final int FEC_HOR = 3;
    final int SENTIDO = 4;
    final int PUNTO_FICHADA = 5;
    final int OID_MOTIVO_FICHADA = 6;
    final int OBSERVACION = 7;
    final int ACTIVO = 8;

    CIPFichadaOficina pers = (CIPFichadaOficina) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into cipFichada "+
                     " ( "+
                      "OID_IN_OUT_OFIC,"+
                      "OID_LEGAJO,"+
                      "FEC_HOR,"+
                      "SENTIDO,"+
                      "OID_PTO_FICHADA,"+
                      "OID_MOTIVO_FICHADA,"+
                      "OBSERVACION,"+
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
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_IN_OUT_OFIC,pers.getOID());
    qInsert.setInt(OID_LEGAJO,pers.getLegajo().getOID());
    qInsert.setTimestamp(FEC_HOR,new java.sql.Timestamp(pers.getFec_hor().getTime()));
    qInsert.setString(SENTIDO,pers.getSentido());
    qInsert.setInt(PUNTO_FICHADA,pers.getOid_pto_fichada().getOID());
    qInsert.setInt(OID_MOTIVO_FICHADA,pers.getMotivo_fichada().getOID());
    if (pers.getObservacion()!=null)
    	qInsert.setString(OBSERVACION,pers.getObservacion());
    else
    	qInsert.setString(OBSERVACION,"");
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_LEGAJO = 1;
    final int FEC_HOR = 2;
    final int SENTIDO = 3;
    final int PUNTO_FICHADA = 4;
    final int OID_MOTIVO_FICHADA = 5;
    final int OBSERVACION = 6;
    final int ACTIVO = 7;
    final int OID_IN_OUT_OFIC = 8;

    CIPFichadaOficina pers = (CIPFichadaOficina) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update cipFichada set "+
              "oid_legajo=?"+ 
              ",fec_hor=?"+ 
              ",sentido=?"+ 
              ",oid_pto_fichada=?"+ 
              ",oid_motivo_fichada=?"+ 
              ",observacion=?"+ 
              ",activo=?"+ 
                 " where " +
                 " oid_in_out_ofic=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_IN_OUT_OFIC,pers.getOID());
    qUpdate.setInt(OID_LEGAJO,pers.getLegajo().getOID());
    qUpdate.setTimestamp(FEC_HOR,new java.sql.Timestamp(pers.getFec_hor().getTime()));
    qUpdate.setString(SENTIDO,pers.getSentido());
    qUpdate.setInt(PUNTO_FICHADA,pers.getOid_pto_fichada().getOID());
    qUpdate.setInt(OID_MOTIVO_FICHADA,pers.getMotivo_fichada().getOID());
    if (pers.getObservacion()!=null)
    	qUpdate.setString(OBSERVACION,pers.getObservacion());
    else
    	qUpdate.setString(OBSERVACION,"");
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_IN_OUT_OFIC = 1; 
    CIPFichadaOficina pers = (CIPFichadaOficina) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update cipFichada "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_in_out_ofic=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_IN_OUT_OFIC, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_IN_OUT_OFIC = 1; 
    CIPFichadaOficina pers = (CIPFichadaOficina) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update cipFichada "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_in_out_ofic=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_IN_OUT_OFIC, pers.getOID()); 
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
      case SELECT_BY_FECDESDE_HASTA_LEGAJO_ASC: {
          ps = this.selectByFecDesHasLegAsc(aCondiciones); 
          break;    	  
      }
      case SELECT_BY_FECDESDE_HASTA_LEGAJO_DESC: {
          ps = this.selectByFecDesHasLegDesc(aCondiciones); 
          break;    	  
      }   
      case SELECT_BY_FECDESDE_HASTA_ORDER_LEG: {
    	  ps = this.selectByOrdenLegFecDesde(aCondiciones); 
          break;    	  
      }
    } 
    return ps;
  } 

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_IN_OUT_OFIC = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  cipFichada "); 
    textSQL.append(" WHERE oid_in_out_ofic = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_IN_OUT_OFIC, oid); 
    return querySelect; 
  }
  
  private PreparedStatement selectByFecDesHasLegAsc(Object aCondiciones) throws BaseException, SQLException { 

	    HashTableDatos condiciones = (HashTableDatos)aCondiciones;
	    java.util.Date fecDesde = (java.util.Date) condiciones.get("FECHA_DESDE");
	    java.util.Date fecHasta = (java.util.Date) condiciones.get("FECHA_HASTA");
	    Legajo legajo = (Legajo) condiciones.get(Legajo.NICKNAME);

	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM  cipFichada "); 
	    textSQL.append(" WHERE fec_hor >= ? and fec_hor<? and activo = 1 ");
	    if (legajo!=null)
	    	textSQL.append("  and oid_legajo = "+legajo.getOIDInteger().toString()+" ");
	    textSQL.append(" order by fec_hor   ");
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
	    
	    fecDesde = Fecha.getFechaTruncada(fecDesde);
	    fecHasta = Fecha.getFechaTruncada(Fecha.getFechaDiaPosterior(Fecha.getFechaTruncada(fecHasta)));
	    
	    querySelect.setDate(1, new java.sql.Date(fecDesde.getTime())); 
	    querySelect.setDate(2, new java.sql.Date(fecHasta.getTime()));
	    return querySelect; 
	  }  
  

  private PreparedStatement selectByOrdenLegFecDesde(Object aCondiciones) throws BaseException, SQLException { 

	    HashTableDatos condiciones = (HashTableDatos)aCondiciones;
	    java.util.Date fecDesde = (java.util.Date) condiciones.get("FECHA_DESDE");
	    java.util.Date fecHasta = (java.util.Date) condiciones.get("FECHA_HASTA");
	    
	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM  cipFichada "); 
	    textSQL.append(" WHERE fec_hor >= ? and fec_hor<=? and activo = 1 ");
	    textSQL.append(" order by oid_legajo, fec_hor  ");
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
	    
	    querySelect.setTimestamp(1, new java.sql.Timestamp(fecDesde.getTime()));
	    querySelect.setTimestamp(2, new java.sql.Timestamp(fecHasta.getTime()));
	    return querySelect; 
	  }  
  
  
  private PreparedStatement selectByFecDesHasLegDesc(Object aCondiciones) throws BaseException, SQLException { 

	    HashTableDatos condiciones = (HashTableDatos)aCondiciones;
	    java.util.Date fecDesde = (java.util.Date) condiciones.get("FECHA_DESDE");
	    java.util.Date fecHasta = (java.util.Date) condiciones.get("FECHA_HASTA");
	    Legajo legajo = (Legajo) condiciones.get(Legajo.NICKNAME);

	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM  cipFichada "); 
	    textSQL.append(" WHERE fec_hor >= ? and fec_hor<? and activo = 1 ");
	    if (legajo!=null)
	    	textSQL.append("  and oid_legajo = "+legajo.getOIDInteger().toString()+" ");
	    textSQL.append(" order by fec_hor desc  ");
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
	    
	    fecDesde = Fecha.getFechaTruncada(fecDesde);
	    fecHasta = Fecha.getFechaTruncada(Fecha.getFechaDiaPosterior(Fecha.getFechaTruncada(fecHasta)));
	    
	    querySelect.setDate(1, new java.sql.Date(fecDesde.getTime())); 
	    querySelect.setDate(2, new java.sql.Date(fecHasta.getTime()));
	    return querySelect; 
	  }  
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  cipFichada "); 
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_in_out_ofic oid, codigo,  descripcion ,activo ");
    textSQL.append(" from cipFichada");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  }
  
  public static List getFichadasOficinaAsc(
		  java.util.Date fecDesde,
		  java.util.Date fecHasta,
		  Legajo legajo,
          ISesion aSesion) throws BaseException {
	  
	  HashTableDatos condiciones = new HashTableDatos();
	  condiciones.put("FECHA_DESDE", fecDesde);
	  condiciones.put("FECHA_HASTA", fecHasta);
	  if (legajo!=null)
		  condiciones.put(Legajo.NICKNAME, legajo);
	  
	  return (List) ObjetoLogico.getObjects(CIPFichadaOficina.NICKNAME,
             DBCIPFichadaOficina.SELECT_BY_FECDESDE_HASTA_LEGAJO_ASC,
             condiciones,
             new ListObserver(),
             aSesion);
  }
  
  
  public static List getFichadasOficinaDesc(
		  java.util.Date fecDesde,
		  java.util.Date fecHasta,
		  Legajo legajo,
          ISesion aSesion) throws BaseException {
	  
	  HashTableDatos condiciones = new HashTableDatos();
	  condiciones.put("FECHA_DESDE", fecDesde);
	  condiciones.put("FECHA_HASTA", fecHasta);
	  if (legajo!=null)
		  condiciones.put(Legajo.NICKNAME, legajo);
	  
	  return (List) ObjetoLogico.getObjects(CIPFichadaOficina.NICKNAME,
             DBCIPFichadaOficina.SELECT_BY_FECDESDE_HASTA_LEGAJO_DESC,
             condiciones,
             new ListObserver(),
             aSesion);
  }
  
  public static List getFichadasOficinaOrderByLegFec(
		  java.util.Date fecDesde,
		  java.util.Date fecHasta,
	      ISesion aSesion) throws BaseException {
	  
	  HashTableDatos condiciones = new HashTableDatos();
	  condiciones.put("FECHA_DESDE", fecDesde);
	  condiciones.put("FECHA_HASTA", fecHasta);
	  
	  return (List) ObjetoLogico.getObjects(CIPFichadaOficina.NICKNAME,
             DBCIPFichadaOficina.SELECT_BY_FECDESDE_HASTA_ORDER_LEG,
             condiciones,
             new ListObserver(),
             aSesion);
  }   
  
  
} 
