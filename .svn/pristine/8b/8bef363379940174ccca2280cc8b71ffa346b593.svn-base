package com.srn.erp.rrhh.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import com.srn.erp.rrhh.bm.GrabarConsRotasCab;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.applicarionServer.bm.Seguridad.Usuario;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;

public class DBGrabarConsRotasCab extends DBObjetoPersistente {

  public static final String OID_GRAB_CONS_ROTA = "oid_grab_cons_rota";
  public static final String DESCRIPCION = "descripcion";
  public static final String OID_FILTRO_CAB = "oid_filtro_cab";
  public static final String FEC_DESDE = "fec_desde";
  public static final String FEC_HASTA = "fec_hasta";
  public static final String OID_ROTA = "oid_rota";
  public static final String JUEGOS_SEP_POR_COMAS = "juegos_sep_por_comas";
  public static final String NO_MOST_SI_FRANCO = "no_most_si_franco";
  public static final String OID_USUARIO = "oid_usuario";
  public static final String FECHA_GRAB = "fecha_grab";
  public static final String HORA_GRAB = "hora_grab";
  public static final String ACTIVO = "activo";
  public static final String DIAS = "dias";
  public static final String AGRUPADOR = "agrupador";
  public static final String NRO_CONSULTA = "nro_consulta";
  
  public static final int SELECT_BY_USUARIO_FECHA = 100;
  public static final int SELECT_BY_USUARIO_FECHA_ROTA = 101;

  public DBGrabarConsRotasCab() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_GRAB_CONS_ROTA = 1;
    final int DESCRIPCION = 2;
    final int OID_FILTRO_CAB = 3;
    final int FEC_DESDE = 4;
    final int FEC_HASTA = 5;
    final int OID_ROTA = 6;
    final int JUEGOS_SEP_POR_COMAS = 7;
    final int NO_MOST_SI_FRANCO = 8;
    final int OID_USUARIO = 9;
    final int FECHA_GRAB = 10;
    final int HORA_GRAB = 11;
    final int ACTIVO = 12;
    final int DIAS = 13;
    final int AGRUPADOR = 14;
    final int NRO_CONSULTA = 15;

    GrabarConsRotasCab pers = (GrabarConsRotasCab) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into dmGrabConsRotas "+
                     " ( "+
                      "OID_GRAB_CONS_ROTA,"+
                      "DESCRIPCION,"+
                      "OID_FILTRO_CAB,"+
                      "FEC_DESDE,"+
                      "FEC_HASTA,"+
                      "OID_ROTA,"+
                      "JUEGOS_SEP_POR_COMAS,"+
                      "NO_MOST_SI_FRANCO,"+
                      "OID_USUARIO,"+
                      "FECHA_GRAB,"+
                      "HORA_GRAB,"+
                      "ACTIVO,DIAS,AGRUPADOR,NRO_CONSULTA)"+ 
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
    qInsert.setInt(OID_GRAB_CONS_ROTA,pers.getOID());
    qInsert.setString(DESCRIPCION,pers.getDescripcion());
    qInsert.setInt(OID_FILTRO_CAB,pers.getFiltro().getOID());
    qInsert.setDate(FEC_DESDE,new java.sql.Date(pers.getFec_desde().getTime()));
    qInsert.setDate(FEC_HASTA,new java.sql.Date(pers.getFec_hasta().getTime()));
    if (pers.getRota()!=null)
    	qInsert.setInt(OID_ROTA,pers.getRota().getOID());
    else
    	qInsert.setNull(OID_ROTA,Types.INTEGER);
    if (pers.getJuegos_sep_por_comas()!=null)
    	qInsert.setString(JUEGOS_SEP_POR_COMAS,pers.getJuegos_sep_por_comas());
    else
    	qInsert.setNull(JUEGOS_SEP_POR_COMAS,Types.VARCHAR);
    if (pers.isNo_most_si_franco()!=null)
    	qInsert.setBoolean(NO_MOST_SI_FRANCO,pers.isNo_most_si_franco().booleanValue());
    else
    	qInsert.setBoolean(NO_MOST_SI_FRANCO,false);
    qInsert.setInt(OID_USUARIO,pers.getUsuario().getOID());
    qInsert.setDate(FECHA_GRAB,new java.sql.Date(pers.getFecha_grab().getTime()));
    qInsert.setString(HORA_GRAB,pers.getHora_grab());
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qInsert.setInt(DIAS, pers.getDias().intValue());
    if (pers.getAgrupador()!=null)
    	qInsert.setString(AGRUPADOR, pers.getAgrupador());
    else
    	qInsert.setNull(AGRUPADOR, Types.VARCHAR);
    if (pers.getNroConsulta()!=null)
    	qInsert.setInt(NRO_CONSULTA, pers.getNroConsulta());
    else
    	qInsert.setNull(NRO_CONSULTA, Types.INTEGER);    
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int DESCRIPCION = 1;
    final int OID_FILTRO_CAB = 2;
    final int FEC_DESDE = 3;
    final int FEC_HASTA = 4;
    final int OID_ROTA = 5;
    final int JUEGOS_SEP_POR_COMAS = 6;
    final int NO_MOST_SI_FRANCO = 7;
    final int OID_USUARIO = 8;
    final int FECHA_GRAB = 9;
    final int HORA_GRAB = 10;
    final int ACTIVO = 11;
    final int DIAS = 12;
    final int AGRUPADOR = 13;
    final int NRO_CONSULTA = 14;
    final int OID_GRAB_CONS_ROTA = 15;

    GrabarConsRotasCab pers = (GrabarConsRotasCab) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update dmGrabConsRotas set "+
              "descripcion=?"+ 
              ",oid_filtro_cab=?"+ 
              ",fec_desde=?"+ 
              ",fec_hasta=?"+ 
              ",oid_rota=?"+ 
              ",juegos_sep_por_comas=?"+ 
              ",no_most_si_franco=?"+ 
              ",oid_usuario=?"+ 
              ",fecha_grab=?"+ 
              ",hora_grab=?"+ 
              ",activo=?"+ 
              ",dias=?"+
              ",agrupador=?"+
              ",nro_consulta=?"+
                 " where " +
                 " oid_grab_cons_rota=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_GRAB_CONS_ROTA,pers.getOID());
    qUpdate.setString(DESCRIPCION,pers.getDescripcion());
    qUpdate.setInt(OID_FILTRO_CAB,pers.getFiltro().getOID());
    qUpdate.setDate(FEC_DESDE,new java.sql.Date(pers.getFec_desde().getTime()));
    qUpdate.setDate(FEC_HASTA,new java.sql.Date(pers.getFec_hasta().getTime()));
    if (pers.getRota()!=null)
    	qUpdate.setInt(OID_ROTA,pers.getRota().getOID());
    else
    	qUpdate.setNull(OID_ROTA,Types.INTEGER);
    if (pers.getJuegos_sep_por_comas()!=null)
    	qUpdate.setString(JUEGOS_SEP_POR_COMAS,pers.getJuegos_sep_por_comas());
    else
    	qUpdate.setNull(JUEGOS_SEP_POR_COMAS,Types.VARCHAR);
    if (pers.isNo_most_si_franco()!=null)
    	qUpdate.setBoolean(NO_MOST_SI_FRANCO,pers.isNo_most_si_franco().booleanValue());
    else
    	qUpdate.setBoolean(NO_MOST_SI_FRANCO,false);
    qUpdate.setInt(OID_USUARIO,pers.getUsuario().getOID());
    qUpdate.setDate(FECHA_GRAB,new java.sql.Date(pers.getFecha_grab().getTime()));
    qUpdate.setString(HORA_GRAB,pers.getHora_grab());
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.setInt(DIAS, pers.getDias().intValue());
    if (pers.getAgrupador()!=null)
    	qUpdate.setString(AGRUPADOR, pers.getAgrupador());
    else
    	qUpdate.setNull(AGRUPADOR, Types.VARCHAR);    
    if (pers.getNroConsulta()!=null)
    	qUpdate.setInt(NRO_CONSULTA, pers.getNroConsulta());
    else
    	qUpdate.setNull(NRO_CONSULTA, Types.INTEGER);    
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_GRAB_CONS_ROTA = 1; 
    GrabarConsRotasCab pers = (GrabarConsRotasCab) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update dmGrabConsRotas "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_grab_cons_rota=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_GRAB_CONS_ROTA, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_GRAB_CONS_ROTA = 1; 
    GrabarConsRotasCab pers = (GrabarConsRotasCab) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update dmGrabConsRotas "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_grab_cons_rota=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_GRAB_CONS_ROTA, pers.getOID()); 
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
      case SELECT_BY_USUARIO_FECHA: {
          ps = this.selectByUsuarioFecha(aCondiciones); 
          break;    	  
      }
      case SELECT_BY_USUARIO_FECHA_ROTA: {
          ps = this.selectByUsuarioFechaRota(aCondiciones); 
          break;    	  
      }      
    } 
    return ps;
  } 

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_GRAB_CONS_ROTA = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  dmGrabConsRotas "); 
    textSQL.append(" WHERE oid_grab_cons_rota = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_GRAB_CONS_ROTA, oid); 
    return querySelect; 
  }
  
  
  private PreparedStatement selectByUsuarioFecha(Object aCondiciones) throws BaseException, SQLException { 
	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM  dmGrabConsRotas "); 
	    textSQL.append(" WHERE oid_usuario=? and activo=1 ");
	    
	     
	     
	    HashTableDatos condiciones = (HashTableDatos) aCondiciones;
	    java.util.Date fecha = (java.util.Date) condiciones.get("FECHA");
	    
	    if (fecha!=null) {
	    	textSQL.append(" and fecha_grab = ? ");
	    }
	    
	    
	    Usuario usuario = (Usuario) condiciones.get(Usuario.NICKNAME);
	    Integer nroConsulta = (Integer) condiciones.get("NRO_CONSULTA");
	    
	    if (nroConsulta!=null) {
	    	textSQL.append(" and nro_consulta="+nroConsulta);
	    }
	    
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
	    
	    
	    querySelect.setInt(1, usuario.getOID());
	    
	    if (fecha!=null)
	    	querySelect.setDate(2, new java.sql.Date(fecha.getTime()));
	    
	    return querySelect; 
  }  
  
  private PreparedStatement selectByUsuarioFechaRota(Object aCondiciones) throws BaseException, SQLException { 
	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM  dmGrabConsRotas "); 
	    textSQL.append(" where activo=1 and oid_usuario in ( ");
	    textSQL.append("		select oid_usuario from sePerfFuncUsu where activo=1 and oid_perfil_func in "); 
	    textSQL.append("		(select oid_perfil_func from sePerfFuncUsu where activo = 1 and oid_usuario=?) ");
	    textSQL.append("		) ");
	    textSQL.append(" and oid_filtro_cab in ( ");
	    textSQL.append(" SELECT OID_FILTRO_CAB FROM rhPerfilFilLegCab a1 ,  sePerfFuncUsu a2 where a1.oid_perfil = a2.oid_perfil_func and a1.activo=1 and a2.activo=1 and a2.oid_usuario=?) ");
	    
	    
	    HashTableDatos condiciones = (HashTableDatos) aCondiciones;
	    java.util.Date fecha = (java.util.Date) condiciones.get("FECHA");
	    Usuario usuario = (Usuario) condiciones.get(Usuario.NICKNAME);
	    Integer nroConsulta = (Integer) condiciones.get("NRO_CONSULTA");

	    if (fecha!=null)
	    	textSQL.append(" and fec_desde = ? "); 
	    
	    if (nroConsulta!=null)
	    	textSQL.append(" and nro_consulta="+nroConsulta);
	    
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
	    
	    querySelect.setInt(1, usuario.getOID());
	    querySelect.setInt(2, usuario.getOID());
	    
	    if (fecha!=null)
	    	querySelect.setDate(3, new java.sql.Date(fecha.getTime()));
	    
	    return querySelect; 
}  
  
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  dmGrabConsRotas "); 
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_grab_cons_rota oid, codigo,  descripcion ,activo ");
    textSQL.append(" from dmGrabConsRotas");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  }
  
  public static List getConsRotasGrabadas(
		  Usuario usuario,
		  java.util.Date fecha,
		  Integer nroConsulta,
          ISesion aSesion) throws BaseException {
	  HashTableDatos condiciones = new HashTableDatos();
	  condiciones.put(Usuario.NICKNAME, usuario);
	  if (fecha!=null)
		  condiciones.put("FECHA" , fecha);
	  if (nroConsulta!=null)
		  condiciones.put("NRO_CONSULTA" , nroConsulta);
	  
	  return (List) ObjetoLogico.getObjects(GrabarConsRotasCab.NICKNAME,
             DBGrabarConsRotasCab.SELECT_BY_USUARIO_FECHA,
             condiciones,
             new ListObserver(),
             aSesion);
 }  
  
  public static List getConsRotasGrabadasFecRota(
		  Usuario usuario,
		  java.util.Date fecha,
		  Integer nroConsulta,
          ISesion aSesion) throws BaseException {
	  HashTableDatos condiciones = new HashTableDatos();
	  condiciones.put(Usuario.NICKNAME, usuario);
	  if (nroConsulta!=null)
	  	condiciones.put("NRO_CONSULTA" , nroConsulta);
	  	if (fecha!=null)
	  		condiciones.put("FECHA" , fecha);
	  return (List) ObjetoLogico.getObjects(GrabarConsRotasCab.NICKNAME,
             DBGrabarConsRotasCab.SELECT_BY_USUARIO_FECHA_ROTA,
             condiciones,
             new ListObserver(),
             aSesion);
 }  
  
} 
