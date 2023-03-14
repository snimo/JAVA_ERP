package com.srn.erp.turnos.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.turnos.bm.EntidadTurno;
import com.srn.erp.turnos.bm.ParteTablero;
import com.srn.erp.turnos.bm.ReservaParteTablero;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.ObjetoObservado;

public class DBReservaParteTablero extends DBObjetoPersistente {

  public static final String OID_RESERVA = "oid_reserva";
  public static final String OID_PARTE_TABLERO = "oid_parte_tablero";
  public static final String OID_PARTE_ENTIDAD = "oid_parte_entidad";
  public static final String OID_PARTE_HOR = "oid_parte_hor";
  public static final String OID_MOTIVO = "oid_motivo";
  public static final String COMENTARIO = "comentario";
  public static final String ACTIVO = "activo";
  
  public static final int SELECT_BY_TABLERO = 100;
  public static final int SELECT_BY_PARTE_ENTIDAD_HORARIO = 101;

  public DBReservaParteTablero() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_RESERVA = 1;
    final int OID_PARTE_TABLERO = 2;
    final int OID_PARTE_ENTIDAD = 3;
    final int OID_PARTE_HOR = 4;
    final int OID_MOTIVO = 5;
    final int COMENTARIO = 6;
    final int ACTIVO = 7;

    ReservaParteTablero pers = (ReservaParteTablero) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into tuReservasParte "+
                     " ( "+
                      "OID_RESERVA,"+
                      "OID_PARTE_TABLERO,"+
                      "OID_PARTE_ENTIDAD,"+
                      "OID_PARTE_HOR,"+
                      "OID_MOTIVO,"+
                      "COMENTARIO,"+
                      "ACTIVO)"+ 
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
    qInsert.setInt(OID_RESERVA,pers.getOID());
    qInsert.setInt(OID_PARTE_TABLERO,pers.getParte_tablero().getOID());
    qInsert.setInt(OID_PARTE_ENTIDAD,pers.getParte_entidad().getOID());
    qInsert.setInt(OID_PARTE_HOR,pers.getParte_horario().getOID());
    qInsert.setInt(OID_MOTIVO,pers.getMotivo().getOID());
    qInsert.setString(COMENTARIO,pers.getComentario());
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_PARTE_TABLERO = 1;
    final int OID_PARTE_ENTIDAD = 2;
    final int OID_PARTE_HOR = 3;
    final int OID_MOTIVO = 4;
    final int COMENTARIO = 5;
    final int ACTIVO = 6;
    final int OID_RESERVA = 7;

    ReservaParteTablero pers = (ReservaParteTablero) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update tuReservasParte set "+
              "oid_parte_tablero=?"+ 
              ",oid_parte_entidad=?"+ 
              ",oid_parte_hor=?"+ 
              ",oid_motivo=?"+ 
              ",comentario=?"+ 
              ",activo=?"+ 
                 " where " +
                 " oid_reserva=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_RESERVA,pers.getOID());
    qUpdate.setInt(OID_PARTE_TABLERO,pers.getParte_tablero().getOID());
    qUpdate.setInt(OID_PARTE_ENTIDAD,pers.getParte_entidad().getOID());
    qUpdate.setInt(OID_PARTE_HOR,pers.getParte_horario().getOID());
    qUpdate.setInt(OID_MOTIVO,pers.getMotivo().getOID());
    qUpdate.setString(COMENTARIO,pers.getComentario());
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_RESERVA = 1; 
    ReservaParteTablero pers = (ReservaParteTablero) objetoPersistente;
    if (pers == null) return;
    
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("delete from tuReservasParte "+
                     " where " + 
                     " oid_reserva=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_RESERVA, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_RESERVA = 1; 
    ReservaParteTablero pers = (ReservaParteTablero) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update tuReservasParte "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_reserva=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_RESERVA, pers.getOID()); 
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
      case SELECT_BY_TABLERO: {
          ps = this.selectByTablero(aCondiciones); 
          break; 
      }
      case SELECT_BY_PARTE_ENTIDAD_HORARIO: {
          ps = this.selectByTableroEntidadHorario(aCondiciones); 
          break; 
      }
    } 
    return ps;
  } 

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_RESERVA = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  tuReservasParte "); 
    textSQL.append(" WHERE oid_reserva = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_RESERVA, oid); 
    return querySelect; 
  }
  
  private PreparedStatement selectByTablero(Object aCondiciones) throws BaseException, SQLException { 
	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM  tuReservasParte "); 
	    textSQL.append(" WHERE oid_parte_tablero = ? "); 
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
	    ParteTablero parteTablero = (ParteTablero) aCondiciones;
	    querySelect.setInt(1, parteTablero.getOIDInteger()); 
	    return querySelect; 
	  }
  
  private PreparedStatement selectByTableroEntidadHorario(Object aCondiciones) throws BaseException, SQLException { 
	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM  tuReservasParte "); 
	    textSQL.append(" WHERE oid_parte_tablero = ? and oid_parte_entidad ");
	    textSQL.append(" = (select oid_parte_entidad from tuEntPartesTablero where oid_parte_tablero=? and oid_entidad_turno=?) ");
	    textSQL.append(" and oid_parte_hor = (select oid_parte_hor from tuParteHorario where oid_parte_tablero=? and horario = ?) "); 
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
	    
	    HashTableDatos condiciones = (HashTableDatos) aCondiciones;
	    ParteTablero parteTablero = (ParteTablero) condiciones.get(ParteTablero.NICKNAME);
	    EntidadTurno entidadTurno = (EntidadTurno) condiciones.get(EntidadTurno.NICKNAME);
	    String horario = (String) condiciones.get("HORARIO");
	    
	    querySelect.setInt(1, parteTablero.getOIDInteger()); 
	    querySelect.setInt(2, parteTablero.getOIDInteger());
	    querySelect.setInt(3, entidadTurno.getOIDInteger());
	    querySelect.setInt(4, parteTablero.getOIDInteger());
	    querySelect.setString(5, horario);
	    return querySelect; 
	  }
  
  
  
  
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  tuReservasParte "); 
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_reserva oid, codigo,  descripcion ,activo ");
    textSQL.append(" from tuReservasParte");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  }
  
  public static List getReservas(ParteTablero parteTablero,
          ISesion aSesion) throws BaseException {
	  return (List) ObjetoLogico.getObjects(ReservaParteTablero.NICKNAME,
             DBReservaParteTablero.SELECT_BY_TABLERO,
             parteTablero,
             new ListObserver(),
             aSesion);
  }
  
  public static ReservaParteTablero getReserva(ParteTablero parteTablero,
		  EntidadTurno entidadTurno,
		  String horario,
          ISesion aSesion) throws BaseException {
	  HashTableDatos condiciones = new HashTableDatos();
	  condiciones.put(ParteTablero.NICKNAME, parteTablero);
	  condiciones.put(EntidadTurno.NICKNAME, entidadTurno);
	  condiciones.put("HORARIO", horario);
	  
	  return (ReservaParteTablero) ObjetoLogico.getObjects(ReservaParteTablero.NICKNAME,
             DBReservaParteTablero.SELECT_BY_PARTE_ENTIDAD_HORARIO,
             condiciones,
             new ObjetoObservado(),
             aSesion);
  }
  
  
  
} 
