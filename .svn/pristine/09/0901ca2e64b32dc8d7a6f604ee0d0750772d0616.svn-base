package com.srn.erp.turnos.da;

import java.sql.*;
import java.util.List;

import com.srn.erp.general.bm.Periodo;
import com.srn.erp.general.bm.PeriodoInc;
import com.srn.erp.general.bm.PeriodoIncDet;
import com.srn.erp.general.da.DBPeriodo;
import com.srn.erp.general.da.DBPeriodoIncDet;
import com.srn.erp.turnos.bm.*;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.*;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.*;

public class DBEntidadParteTableroTurnos extends DBObjetoPersistente {

  public static final String OID_PARTE_ENTIDAD = "oid_parte_entidad";
  public static final String OID_ENTIDAD_TURNO = "oid_entidad_turno";
  public static final String OID_PARTE_TABLERO = "oid_parte_tablero";
  public static final String ORDEN = "orden";
  public static final String ACTIVO = "activo";
  public static final String CAM_HOR_PON_TURNO = "cam_hor_al_pon_tur";
  public static final String MINUTOS_1_SUJ = "minu_1_suj";
  public static final String MINUTOS_2_SUJ = "minu_2_suj";
  public static final String MINUTOS_3_SUJ = "minu_3_suj";
  public static final String MINUTOS_4_SUJ = "minu_4_suj";
  
  
  public static final int SELECT_TABLERO = 100;
  public static final int SELECT_PARTE_ENTIDAD = 101;

  public DBEntidadParteTableroTurnos() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_PARTE_ENTIDAD = 1;
    final int OID_ENTIDAD_TURNO = 2;
    final int OID_PARTE_TABLERO = 3;
    final int ORDEN = 4;
    final int ACTIVO = 5;
    final int CAM_HOR_PON_TUR = 6;
    final int MINU_1_JUG = 7;
    final int MINU_2_JUG = 8;
    final int MINU_3_JUG = 9;
    final int MINU_4_JUG = 10;

    EntidadParteTableroTurnos pers = (EntidadParteTableroTurnos) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into tuEntPartesTablero "+
                     " ( "+
                      "OID_PARTE_ENTIDAD,"+
                      "OID_ENTIDAD_TURNO,"+
                      "OID_PARTE_TABLERO,"+
                      "ORDEN,"+
                      "ACTIVO,"+
                      "CAM_HOR_AL_PON_TUR,"+
                      "MINU_1_SUJ,"+
                      "MINU_2_SUJ,"+
                      "MINU_3_SUJ,"+
                      "MINU_4_SUJ) "+
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
    qInsert.setInt(OID_PARTE_ENTIDAD,pers.getOID());
    qInsert.setInt(OID_ENTIDAD_TURNO,pers.getEntidad_turno().getOID());
    qInsert.setInt(OID_PARTE_TABLERO,pers.getParte_tablero().getOID());
    qInsert.setInt(ORDEN,pers.getOrden().intValue());
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qInsert.setBoolean(CAM_HOR_PON_TUR,pers.isCambiarHorarioAlPonerTurno().booleanValue());
    qInsert.setInt(MINU_1_JUG, pers.getMinutosTur1Suj());
    qInsert.setInt(MINU_2_JUG, pers.getMinutosTur2Suj());
    qInsert.setInt(MINU_3_JUG, pers.getMinutosTur3Suj());
    qInsert.setInt(MINU_4_JUG, pers.getMinutosTur4Suj());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_ENTIDAD_TURNO = 1;
    final int OID_PARTE_TABLERO = 2;
    final int ORDEN = 3;
    final int ACTIVO = 4;
    final int CAM_HOR_PON_TUR = 5;
    final int MINU_1_JUG = 6;
    final int MINU_2_JUG = 7;
    final int MINU_3_JUG = 8;
    final int MINU_4_JUG = 9;
    final int OID_PARTE_ENTIDAD = 10;

    EntidadParteTableroTurnos pers = (EntidadParteTableroTurnos) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update tuEntPartesTablero set "+
              "oid_entidad_turno=?"+ 
              ",oid_parte_tablero=?"+ 
              ",orden=?"+ 
              ",activo=?"+ 
              ",cam_hor_al_pon_tur=?"+
              ",minu_1_suj=?"+
              ",minu_2_suj=?"+
              ",minu_3_suj=?"+
              ",minu_4_suj=? "+
                 " where " +
                 " oid_parte_entidad=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_PARTE_ENTIDAD,pers.getOID());
    qUpdate.setInt(OID_ENTIDAD_TURNO,pers.getEntidad_turno().getOID());
    qUpdate.setInt(OID_PARTE_TABLERO,pers.getParte_tablero().getOID());
    qUpdate.setInt(ORDEN,pers.getOrden().intValue());
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.setBoolean(CAM_HOR_PON_TUR,pers.isCambiarHorarioAlPonerTurno().booleanValue());
    qUpdate.setInt(MINU_1_JUG, pers.getMinutosTur1Suj());
    qUpdate.setInt(MINU_2_JUG, pers.getMinutosTur2Suj());
    qUpdate.setInt(MINU_3_JUG, pers.getMinutosTur3Suj());
    qUpdate.setInt(MINU_4_JUG, pers.getMinutosTur4Suj());    
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_PARTE_ENTIDAD = 1; 
    EntidadParteTableroTurnos pers = (EntidadParteTableroTurnos) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("delete from tuEntPartesTablero "+
                     " where " + 
                     " oid_parte_entidad=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_PARTE_ENTIDAD, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
    
    StringBuffer sqlUpdate1 = new StringBuffer(); 
    sqlUpdate1.append("delete from tuReservasParte "+
                     " where " + 
                     " oid_parte_entidad=? ");
    PreparedStatement qUpdate1 = getSesion().getConexionBD().prepareStatement(sqlUpdate1.toString()); 
    qUpdate1.setInt(OID_PARTE_ENTIDAD, pers.getOID()); 
    qUpdate1.executeUpdate();
    qUpdate1.close();
    
    
    
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_PARTE_ENTIDAD = 1; 
    EntidadParteTableroTurnos pers = (EntidadParteTableroTurnos) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update tuEntPartesTablero "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_parte_entidad=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_PARTE_ENTIDAD, pers.getOID()); 
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
      case SELECT_TABLERO : {
          ps = this.selectByTablero(aCondiciones); 
          break; 
      }
      case SELECT_PARTE_ENTIDAD: {
          ps = this.selectByParteEntidad(aCondiciones); 
          break; 
      }
    } 
    return ps;
  }
  
  private PreparedStatement selectByParteEntidad(Object aCondiciones) throws BaseException, SQLException {
	  
	  HashTableDatos condiciones = (HashTableDatos) aCondiciones;
	  EntidadTurno entidadTurno = (EntidadTurno) condiciones.get(EntidadTurno.NICKNAME);
	  ParteTablero parteTablero = (ParteTablero) condiciones.get(ParteTablero.NICKNAME);

	  StringBuffer textSQL = new StringBuffer(); 
	  textSQL.append("SELECT * FROM  tuEntPartesTablero "); 
	  textSQL.append(" WHERE oid_entidad_turno = ? and oid_parte_tablero = ?"); 
	  PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
	  querySelect.setInt(1, entidadTurno.getOID());
	  querySelect.setInt(2, parteTablero.getOID());
	  
	  return querySelect; 
  }
  

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_PARTE_ENTIDAD = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  tuEntPartesTablero "); 
    textSQL.append(" WHERE oid_parte_entidad = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_PARTE_ENTIDAD, oid); 
    return querySelect; 
  }
  
  private PreparedStatement selectByTablero(Object aCondiciones) throws BaseException, SQLException { 

	StringBuffer textSQL = new StringBuffer(); 
	textSQL.append("SELECT * FROM  tuEntPartesTablero "); 
	textSQL.append(" WHERE oid_parte_tablero = ? ");
	PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
	ParteTablero parteTablero = (ParteTablero) aCondiciones; 
	querySelect.setInt(1, parteTablero.getOID()); 
	return querySelect;
	
  }
		  
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  tuEntPartesTablero "); 
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_parte_entidad oid, codigo,  descripcion ,activo ");
    textSQL.append(" from tuEntPartesTablero");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  }
  
  public static List getEntidades(ParteTablero parteTablero,
          ISesion aSesion) throws BaseException {
	  return (List) ObjetoLogico.getObjects(EntidadParteTableroTurnos.NICKNAME,
             DBEntidadParteTableroTurnos.SELECT_TABLERO,
             parteTablero,
             new ListObserver(),
             aSesion);
  }
  
  public static EntidadParteTableroTurnos getEntidadParteTablero(ParteTablero parteTablero,
		  EntidadTurno entidadTurno,
          ISesion aSesion)
          throws BaseException {
	  HashTableDatos condiciones = new HashTableDatos();
	  condiciones.put(ParteTablero.NICKNAME, parteTablero);
	  condiciones.put(EntidadTurno.NICKNAME, entidadTurno);
	  
	  return (EntidadParteTableroTurnos) ObjetoLogico.getObjects(EntidadParteTableroTurnos.NICKNAME,
			  				DBEntidadParteTableroTurnos.SELECT_PARTE_ENTIDAD,
			  				condiciones,
			  				new ObjetoObservado(),
			  				aSesion);
  }
  
  
  
} 
