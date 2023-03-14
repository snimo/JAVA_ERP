package com.srn.erp.cip.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import com.srn.erp.cip.bm.PermisoVisita;
import com.srn.erp.cip.bm.TarjetaCIP;
import com.srn.erp.cip.bm.UtilCIP;
import com.srn.erp.cip.bm.Visita;
import com.srn.erp.ventas.bm.PedidoCab;
import com.srn.erp.ventas.da.DBPedidoCab;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;

public class DBPermisoVisita extends DBObjetoPersistente {

  public static final String OID_PERM_VISITA = "oid_perm_visita";
  public static final String PRIORIDAD = "prioridad";
  public static final String OID_VISITA = "oid_visita";
  public static final String PERMISO = "permiso";
  public static final String FEC_HOR_DESDE = "fec_hor_desde";
  public static final String FEC_HOR_HASTA = "fec_hor_hasta";
  public static final String OID_GRUPO_PUERTA = "oid_grupo_puerta";
  public static final String ACTIVO = "activo";
  public static final String OID_TARJETA = "oid_tarjeta";
  public static final String SENTIDO = "sentido";
  public static final String MOTIVO_VISITA = "oid_motivo_visita";
  public static final String COMENTARIO = "comentario";
  public static final String OID_VISITA_A = "oid_visita_a";
  public static final String OID_AUTORIZA = "oid_autoriza";
  
  public static final int SELECT_BY_VISITA_PERMISO_ACTIVO = 100;
  public static final int SELECT_BY_VISITA_PERMISO_SAL_ACTIVO = 101;
  public static final int DESACTIVAR_PERMISOS_TARJETA = 102;
  public static final int SELECT_BY_VISITA_PERM_ACT_PRIO_ALTA = 103;
  public static final int SELECT_BY_VISITA_PERM_ACT_PRIO_BAJA = 104;
  

  public DBPermisoVisita() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_PERM_VISITA = 1;
    final int PRIORIDAD = 2;
    final int OID_VISITA = 3;
    final int PERMISO = 4;
    final int FEC_HOR_DESDE = 5;
    final int FEC_HOR_HASTA = 6;
    final int OID_GRUPO_PUERTA = 7;
    final int ACTIVO = 8;
    final int OID_TARJETA = 9;
    final int SENTIDO = 10;
    final int OID_MOTIVO_VISITA = 11;
    final int COMENTARIO = 12;
    final int OID_VISITA_A = 13;
    final int OID_AUTORIZA = 14;

    PermisoVisita pers = (PermisoVisita) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into cipPermisoVisita "+
                     " ( "+
                      "OID_PERM_VISITA,"+
                      "PRIORIDAD,"+
                      "OID_VISITA,"+
                      "PERMISO,"+
                      "FEC_HOR_DESDE,"+
                      "FEC_HOR_HASTA,"+
                      "OID_GRUPO_PUERTA,"+
                      "ACTIVO , OID_TARJETA,SENTIDO,OID_MOTIVO_VISITA,COMENTARIO,OID_VISITA_A,OID_AUTORIZA)"+ 
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
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_PERM_VISITA,pers.getOID());
    qInsert.setInt(PRIORIDAD,pers.getPrioridad().intValue());
    qInsert.setInt(OID_VISITA,pers.getVisita().getOID());
    qInsert.setString(PERMISO,pers.getPermiso());
    qInsert.setTimestamp(FEC_HOR_DESDE, new java.sql.Timestamp(pers.getFec_hor_desde().getTime()));
    qInsert.setTimestamp(FEC_HOR_HASTA, new java.sql.Timestamp(pers.getFec_hor_hasta().getTime()));
    qInsert.setInt(OID_GRUPO_PUERTA,pers.getGrupo_puerta().getOID());
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    if (pers.getTarjetaCIP()!=null)
    	qInsert.setInt(OID_TARJETA, pers.getTarjetaCIP().getOID());
    else
    	qInsert.setNull(OID_TARJETA, Types.INTEGER);
    if (pers.getSentido()!=null)
    	qInsert.setString(SENTIDO, pers.getSentido());
    else
    	qInsert.setNull(SENTIDO, Types.VARCHAR);
    if (pers.getMotivoVisita()!=null)
    	qInsert.setInt(OID_MOTIVO_VISITA, pers.getMotivoVisita().getOID());
    else
    	qInsert.setNull(OID_MOTIVO_VISITA, Types.INTEGER);
    if (pers.getComentario()!=null)
    	qInsert.setString(COMENTARIO, pers.getComentario());
    else
    	qInsert.setNull(COMENTARIO, Types.VARCHAR);
    if (pers.getVisitaA()!=null)
    	qInsert.setInt(OID_VISITA_A, pers.getVisitaA().getOID());
    else
    	qInsert.setNull(OID_VISITA_A, Types.INTEGER);
    if (pers.getAutoriza()!=null)
    	qInsert.setInt(OID_AUTORIZA, pers.getAutoriza().getOID());
    else
    	qInsert.setNull(OID_AUTORIZA, Types.INTEGER);
    
    
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int PRIORIDAD = 1;
    final int OID_VISITA = 2;
    final int PERMISO = 3;
    final int FEC_HOR_DESDE = 4;
    final int FEC_HOR_HASTA = 5;
    final int OID_GRUPO_PUERTA = 6;
    final int ACTIVO = 7;
    final int OID_TARJETA = 8;
    final int SENTIDO = 9;
    final int OID_MOTIVO_VISITA = 10;
    final int COMENTARIO = 11;
    final int OID_VISITA_A = 12;
    final int OID_AUTORIZA = 13;
    final int OID_PERM_VISITA = 14;

    PermisoVisita pers = (PermisoVisita) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update cipPermisoVisita set "+
              "prioridad=?"+ 
              ",oid_visita=?"+ 
              ",permiso=?"+ 
              ",fec_hor_desde=?"+ 
              ",fec_hor_hasta=?"+ 
              ",oid_grupo_puerta=?"+ 
              ",activo=?"+ 
              ",oid_tarjeta=?"+
              ",sentido=?"+
              ",oid_motivo_visita=?"+
              ",oid_visita_a=?"+
              ",oid_autoriza=?"+
                 " where " +
                 " oid_perm_visita=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_PERM_VISITA,pers.getOID());
    qUpdate.setInt(PRIORIDAD,pers.getPrioridad().intValue());
    qUpdate.setInt(OID_VISITA,pers.getVisita().getOID());
    qUpdate.setString(PERMISO,pers.getPermiso());
    qUpdate.setTimestamp(FEC_HOR_DESDE, new java.sql.Timestamp(pers.getFec_hor_desde().getTime()));
    qUpdate.setTimestamp(FEC_HOR_HASTA, new java.sql.Timestamp(pers.getFec_hor_hasta().getTime()));
    qUpdate.setInt(OID_GRUPO_PUERTA,pers.getGrupo_puerta().getOID());
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    if (pers.getTarjetaCIP()!=null)
    	qUpdate.setInt(OID_TARJETA, pers.getTarjetaCIP().getOID());
    else
    	qUpdate.setNull(OID_TARJETA, Types.INTEGER);
    if (pers.getSentido()!=null)
    	qUpdate.setString(SENTIDO, pers.getSentido());
    else
    	qUpdate.setNull(SENTIDO, Types.VARCHAR);
    if (pers.getMotivoVisita()!=null)
    	qUpdate.setInt(OID_MOTIVO_VISITA, pers.getMotivoVisita().getOID());
    else
    	qUpdate.setNull(OID_MOTIVO_VISITA, Types.INTEGER);
    if (pers.getComentario()!=null)
    	qUpdate.setString(COMENTARIO, pers.getComentario());
    else
    	qUpdate.setNull(COMENTARIO, Types.VARCHAR);
    if (pers.getVisitaA()!=null)
    	qUpdate.setInt(OID_VISITA_A, pers.getVisitaA().getOID());
    else
    	qUpdate.setNull(OID_VISITA_A, Types.INTEGER);
    if (pers.getAutoriza()!=null)
    	qUpdate.setInt(OID_AUTORIZA, pers.getAutoriza().getOID());
    else
    	qUpdate.setNull(OID_AUTORIZA, Types.INTEGER);
    
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_PERM_VISITA = 1; 
    PermisoVisita pers = (PermisoVisita) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update cipPermisoVisita "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_perm_visita=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_PERM_VISITA, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_PERM_VISITA = 1; 
    PermisoVisita pers = (PermisoVisita) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update cipPermisoVisita "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_perm_visita=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_PERM_VISITA, pers.getOID()); 
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
      case SELECT_BY_VISITA_PERMISO_ACTIVO: {
          ps = this.selectByVisitaPermisoActivo(aCondiciones); 
          break; 
      }
      case SELECT_BY_VISITA_PERM_ACT_PRIO_ALTA: {
          ps = this.selectByVisitaPermPriAlta(aCondiciones); 
          break; 
      }
      case SELECT_BY_VISITA_PERM_ACT_PRIO_BAJA: {
          ps = this.selectByVisitaPermPriBaja(aCondiciones); 
          break; 
      }
      case SELECT_BY_VISITA_PERMISO_SAL_ACTIVO: {
          ps = this.selectByVisitaPermisoSalidaActivo(aCondiciones); 
          break; 
      }
      case DESACTIVAR_PERMISOS_TARJETA: {
    	  ps = desactitarPermisosDeTarjeta(aCondiciones);
    	  break;
      }
      
    } 
    return ps;
  } 

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_PERM_VISITA = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  cipPermisoVisita "); 
    textSQL.append(" WHERE oid_perm_visita = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_PERM_VISITA, oid); 
    return querySelect; 
  }
  
  private PreparedStatement selectByVisitaPermisoSalidaActivo(Object aCondiciones) throws BaseException, SQLException { 
	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM  cipPermisoVisita "); 
	    textSQL.append(" WHERE oid_visita  = ? and activo = 1 and permiso = ? and ?>=fec_hor_desde and ?<=fec_hor_hasta and (sentido='S' or sentido='A') ");
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
	    HashTableDatos condiciones = (HashTableDatos) aCondiciones;
	    Visita visita = (Visita) condiciones.get(Visita.NICKNAME);
	    String permiso = (String) condiciones.get("PERMISO");
	    java.util.Date fecha = (java.util.Date) condiciones.get("FECHA");
	    querySelect.setInt(1, visita.getOID());
	    querySelect.setString(2, permiso);
	    querySelect.setTimestamp(3, new java.sql.Timestamp(fecha.getTime()));
	    querySelect.setTimestamp(4, new java.sql.Timestamp(fecha.getTime()));
	    return querySelect; 
  }
  
  private PreparedStatement desactitarPermisosDeTarjeta(Object aCondiciones) throws BaseException, SQLException {
		TarjetaCIP tarjeta = (TarjetaCIP) aCondiciones;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update cipPermisoVisita set activo = 0 where oid_tarjeta = ? and fec_hor_hasta>=? and activo=1 ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(1, tarjeta.getOID());
		qUpdate.setDate(2, new java.sql.Date(UtilCIP.getFechaHoraActual(this.getSesion()).getTime()));
		qUpdate.executeUpdate();
		qUpdate.close();
		return null;
  }
  
  private PreparedStatement selectByVisitaPermPriAlta(Object aCondiciones) throws BaseException, SQLException { 
	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM  cipPermisoVisita "); 
	    textSQL.append(" WHERE oid_visita  = ? and activo = 1 and permiso = ? and ?>=fec_hor_desde and ?<=fec_hor_hasta and (sentido='E' or sentido='A') and prioridad<50 ");
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
	    HashTableDatos condiciones = (HashTableDatos) aCondiciones;
	    Visita visita = (Visita) condiciones.get(Visita.NICKNAME);
	    String permiso = (String) condiciones.get("PERMISO");
	    java.util.Date fecha = (java.util.Date) condiciones.get("FECHA");
	    querySelect.setInt(1, visita.getOID());
	    querySelect.setString(2, permiso);
	    querySelect.setTimestamp(3, new java.sql.Timestamp(fecha.getTime()));
	    querySelect.setTimestamp(4, new java.sql.Timestamp(fecha.getTime()));
	    return querySelect; 
  }

  private PreparedStatement selectByVisitaPermPriBaja(Object aCondiciones) throws BaseException, SQLException { 
	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM  cipPermisoVisita "); 
	    textSQL.append(" WHERE oid_visita  = ? and activo = 1 and permiso = ? and ?>=fec_hor_desde and ?<=fec_hor_hasta and (sentido='E' or sentido='A') and prioridad>=50");
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
	    HashTableDatos condiciones = (HashTableDatos) aCondiciones;
	    Visita visita = (Visita) condiciones.get(Visita.NICKNAME);
	    String permiso = (String) condiciones.get("PERMISO");
	    java.util.Date fecha = (java.util.Date) condiciones.get("FECHA");
	    querySelect.setInt(1, visita.getOID());
	    querySelect.setString(2, permiso);
	    querySelect.setTimestamp(3, new java.sql.Timestamp(fecha.getTime()));
	    querySelect.setTimestamp(4, new java.sql.Timestamp(fecha.getTime()));
	    return querySelect; 
}
  
  
  private PreparedStatement selectByVisitaPermisoActivo(Object aCondiciones) throws BaseException, SQLException { 
	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM  cipPermisoVisita "); 
	    textSQL.append(" WHERE oid_visita  = ? and activo = 1 and permiso = ? and ?>=fec_hor_desde and ?<=fec_hor_hasta and (sentido='E' or sentido='A') ");
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
	    HashTableDatos condiciones = (HashTableDatos) aCondiciones;
	    Visita visita = (Visita) condiciones.get(Visita.NICKNAME);
	    String permiso = (String) condiciones.get("PERMISO");
	    java.util.Date fecha = (java.util.Date) condiciones.get("FECHA");
	    querySelect.setInt(1, visita.getOID());
	    querySelect.setString(2, permiso);
	    querySelect.setTimestamp(3, new java.sql.Timestamp(fecha.getTime()));
	    querySelect.setTimestamp(4, new java.sql.Timestamp(fecha.getTime()));
	    return querySelect; 
  }
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  cipPermisoVisita "); 
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_perm_visita oid, codigo,  descripcion ,activo ");
    textSQL.append(" from cipPermisoVisita");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  }
  
  public static List getPermisosVisitaEntradas(
		  Visita visita,
		  String permiso,
		  java.util.Date fecha,
		  ISesion aSesion) throws BaseException {

	  	HashTableDatos condiciones = new HashTableDatos();
	  	condiciones.put(Visita.NICKNAME, visita);
	  	condiciones.put("PERMISO", permiso);
	  	condiciones.put("FECHA", fecha);
	  
	    return (List) ObjetoLogico.getObjects(PermisoVisita.NICKNAME,
                DBPermisoVisita.SELECT_BY_VISITA_PERMISO_ACTIVO,
                condiciones,
                new ListObserver(),
                aSesion);
	  
  }
  
  public static List getPermisosVisitaEntradasPriAlta(
		  Visita visita,
		  String permiso,
		  java.util.Date fecha,
		  ISesion aSesion) throws BaseException {

	  	HashTableDatos condiciones = new HashTableDatos();
	  	condiciones.put(Visita.NICKNAME, visita);
	  	condiciones.put("PERMISO", permiso);
	  	condiciones.put("FECHA", fecha);
	  
	    return (List) ObjetoLogico.getObjects(PermisoVisita.NICKNAME,
                DBPermisoVisita.SELECT_BY_VISITA_PERM_ACT_PRIO_ALTA,
                condiciones,
                new ListObserver(),
                aSesion);
	  
  }
  
  public static List getPermisosVisitaEntradasPriBaja(
		  Visita visita,
		  String permiso,
		  java.util.Date fecha,
		  ISesion aSesion) throws BaseException {

	  	HashTableDatos condiciones = new HashTableDatos();
	  	condiciones.put(Visita.NICKNAME, visita);
	  	condiciones.put("PERMISO", permiso);
	  	condiciones.put("FECHA", fecha);
	  
	    return (List) ObjetoLogico.getObjects(PermisoVisita.NICKNAME,
                DBPermisoVisita.SELECT_BY_VISITA_PERM_ACT_PRIO_BAJA,
                condiciones,
                new ListObserver(),
                aSesion);
	  
  }
  
  
  
  public static List getPermisosVisitaSalidas(
		  Visita visita,
		  String permiso,
		  java.util.Date fecha,
		  ISesion aSesion) throws BaseException {

	  	HashTableDatos condiciones = new HashTableDatos();
	  	condiciones.put(Visita.NICKNAME, visita);
	  	condiciones.put("PERMISO", permiso);
	  	condiciones.put("FECHA", fecha);
	  
	    return (List) ObjetoLogico.getObjects(PermisoVisita.NICKNAME,
                DBPermisoVisita.SELECT_BY_VISITA_PERMISO_SAL_ACTIVO,
                condiciones,
                new ListObserver(),
                aSesion);
	  
  }
  
  public static void desactivarPermisosTarjeta(TarjetaCIP tarjeta,
	      ISesion aSesion)
	  throws BaseException {
	  	ObjetoLogico.getObjects(PermisoVisita.NICKNAME,
		  				DBPermisoVisita.DESACTIVAR_PERMISOS_TARJETA,
		  				tarjeta,
		  				null,
		  				aSesion);
  }
  
  
  
  
} 
