package com.srn.erp.turnos.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.turnos.bm.ParteHorarioTurno;
import com.srn.erp.turnos.bm.ParteTablero;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.ObjetoObservado;

public class DBParteHorarioTurno extends DBObjetoPersistente {

  public static final String OID_PARTE_HOR = "oid_parte_hor";
  public static final String OID_PARTE_TABLERO = "oid_parte_tablero";
  public static final String HORARIO = "horario";
  public static final String ACTIVO = "activo";
  
  public static final int SELECT_BY_TABLERO = 100;
  public static final int SELECT_BY_HORARIO = 101;

  public DBParteHorarioTurno() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_PARTE_HOR = 1;
    final int OID_PARTE_TABLERO = 2;
    final int HORARIO = 3;
    final int ACTIVO = 4;

    ParteHorarioTurno pers = (ParteHorarioTurno) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into tuParteHorario "+
                     " ( "+
                      "OID_PARTE_HOR,"+
                      "OID_PARTE_TABLERO,"+
                      "HORARIO,"+
                      "ACTIVO)"+ 
                      " values "+ 
                      "("+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_PARTE_HOR,pers.getOID());
    qInsert.setInt(OID_PARTE_TABLERO,pers.getParte_tablero().getOID());
    qInsert.setString(HORARIO,pers.getHorario());
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_PARTE_TABLERO = 1;
    final int HORARIO = 2;
    final int ACTIVO = 3;
    final int OID_PARTE_HOR = 4;

    ParteHorarioTurno pers = (ParteHorarioTurno) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update tuParteHorario set "+
              "oid_parte_tablero=?"+ 
              ",horario=?"+ 
              ",activo=?"+ 
                 " where " +
                 " oid_parte_hor=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_PARTE_HOR,pers.getOID());
    qUpdate.setInt(OID_PARTE_TABLERO,pers.getParte_tablero().getOID());
    qUpdate.setString(HORARIO,pers.getHorario());
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_PARTE_HOR = 1; 
    ParteHorarioTurno pers = (ParteHorarioTurno) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update tuParteHorario "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_parte_hor=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_PARTE_HOR, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_PARTE_HOR = 1; 
    ParteHorarioTurno pers = (ParteHorarioTurno) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update tuParteHorario "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_parte_hor=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_PARTE_HOR, pers.getOID()); 
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
      case SELECT_BY_HORARIO: {
          ps = this.selectByHorario(aCondiciones); 
          break; 
      }
    } 
    return ps;
  } 

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_PARTE_HOR = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  tuParteHorario "); 
    textSQL.append(" WHERE oid_parte_hor = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_PARTE_HOR, oid); 
    return querySelect; 
  }
  
  private PreparedStatement selectByHorario(Object aCondiciones) throws BaseException, SQLException { 

	StringBuffer textSQL = new StringBuffer(); 
	textSQL.append("SELECT * FROM  tuParteHorario "); 
	textSQL.append(" WHERE oid_parte_tablero = ? and horario = ? ");
	HashTableDatos condiciones = (HashTableDatos) aCondiciones;
	ParteTablero parteTablero = (ParteTablero) condiciones.get(ParteTablero.NICKNAME);
	String horario = (String) condiciones.get("HORARIO");
	
	PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
	querySelect.setInt(1, parteTablero.getOID());
	querySelect.setString(2, horario);
	return querySelect;
	
  }
  
  
  private PreparedStatement selectByTablero(Object aCondiciones) throws BaseException, SQLException { 
	 StringBuffer textSQL = new StringBuffer(); 
	 textSQL.append("SELECT * FROM  tuParteHorario "); 
	 textSQL.append(" WHERE oid_parte_tablero = ? order by horario ");
	 PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
	 ParteTablero parteTablero = (ParteTablero) aCondiciones; 
	 querySelect.setInt(1, parteTablero.getOID()); 
	 return querySelect; 
  }
  
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  tuParteHorario "); 
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_parte_hor oid, codigo,  descripcion ,activo ");
    textSQL.append(" from tuParteHorario");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  }
  
  public static List getHorarios(ParteTablero parteTablero,
          ISesion aSesion) throws BaseException {
	  return (List) ObjetoLogico.getObjects(ParteHorarioTurno.NICKNAME,
             DBParteHorarioTurno.SELECT_BY_TABLERO,
             parteTablero,
             new ListObserver(),
             aSesion);
  }
  
  public static ParteHorarioTurno getHorario(ParteTablero parteTablero,
		  String horario,
          ISesion aSesion) throws BaseException {
	  HashTableDatos condiciones = new HashTableDatos();
	  condiciones.put(ParteTablero.NICKNAME, parteTablero);
	  condiciones.put("HORARIO", horario);
	  return (ParteHorarioTurno) ObjetoLogico.getObjects(ParteHorarioTurno.NICKNAME,
             DBParteHorarioTurno.SELECT_BY_HORARIO,
             condiciones,
             new ObjetoObservado(),
             aSesion);
  }
  
  
  
} 
