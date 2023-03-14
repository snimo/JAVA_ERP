package com.srn.erp.turnos.da;

import java.sql.*;

import com.srn.erp.general.bm.Periodo;
import com.srn.erp.general.da.DBPeriodo;
import com.srn.erp.turnos.bm.*;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.*;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.*;

public class DBReglamentoTurno extends DBObjetoPersistente {

  public static final String OID_REGLA_CAB = "oid_regla_cab";
  public static final String CODIGO = "codigo";
  public static final String DESCRIPCION = "descripcion";
  public static final String COMPORTAMIENTO = "comportamiento";
  public static final String ACTIVO = "activo";
  public static final String USAR = "usar";
  
  public static final String REGLA_DEUDA_CATEG = "regla_deuda_categ";
  public static final String REGLA_DEUDA_GRAL = "regla_deuda_gral";
  public static final String REGLA_MONTO_DEUDA_GRAL = "monto_deuda_gral";
  public static final String REGLA_ANT_DEUDA = "regla_ant_deuda";
  public static final String DIAS_ANT_DEUDA = "dias_ant_deuda";
  
  
  public static final String REGLA_JUGADOR_INACTIVO = "regla_jug_inactivo";
  public static final String REGLA_JUGADOR_SUSPENSION = "regla_jug_susp";
  public static final String REGLA_JUGADOR_1_TURNO_ACT = "regla_juj_1tur_act";
  
  public static final String REGLA_TURNO_SEGUN_CATEG = "regla_no_tur_categ";
  public static final String REGLA_TURNO_SEGUN_RELA = "regla_no_tur_rela";
  
  public static final String REGLA_DEUDA_CONCEPTO = "regla_deuda_conc";
  public static final String REGLA_CONC_SUF_CATEG = "regla_conc_suf_cat";
  
  public static final int SELECT_BY_COMPO_USAR = 100;
  

  public DBReglamentoTurno() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_REGLA_CAB = 1;
    final int CODIGO = 2;
    final int DESCRIPCION = 3;
    final int COMPORTAMIENTO = 4;
    final int ACTIVO = 5;
    final int USAR = 6;
    final int REGLA_JUG_INACTIVO = 7;
    final int REGLA_JUG_SUSP = 8;
    final int REGLA_JUG_1TUR_ACT = 9;
    
    final int REGLA_DEUDA_CATEG = 10;
    final int REGLA_DEUDA_GRAL = 11;
    final int MONTO_DEUDA_GRAL = 12;
    final int REGLA_ANT_DEUDA = 13;
    final int DIAS_ANT_DEUDA = 14;
    
    final int REGLA_NO_TUR_CATEG = 15;
    final int REGLA_NO_TUR_RELA = 16;
    final int REGLA_DEUDA_CONCEPTO = 17;
    
    final int REGLA_CONC_SUF_CATE = 18;
    

    ReglamentoTurno pers = (ReglamentoTurno) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into tuReglamentoCab "+
                     " ( "+
                      "OID_REGLA_CAB,"+
                      "CODIGO,"+
                      "DESCRIPCION,"+
                      "COMPORTAMIENTO,"+
                      "ACTIVO,USAR,REGLA_JUG_INACTIVO,REGLA_JUG_SUSP,regla_juj_1tur_act," +
                      "regla_deuda_categ,"+
                      "regla_deuda_gral,"+
                      "monto_deuda_gral,"+
                      "regla_ant_deuda,"+
                      "dias_ant_deuda,regla_no_tur_categ,regla_no_tur_rela, regla_deuda_conc,regla_conc_suf_cat)"+
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
    qInsert.setInt(OID_REGLA_CAB,pers.getOID());
    qInsert.setString(CODIGO,pers.getCodigo());
    qInsert.setString(DESCRIPCION,pers.getDescripcion());
    qInsert.setString(COMPORTAMIENTO,pers.getComportamiento());
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    if (pers.isUsar()!=null)
    	qInsert.setBoolean(USAR,pers.isUsar().booleanValue());
    else
    	qInsert.setBoolean(USAR,false);
    if (pers.isReglaJugadorInactivo()!=null)
    	qInsert.setBoolean(REGLA_JUG_INACTIVO,pers.isReglaJugadorInactivo().booleanValue());
    else
    	qInsert.setBoolean(REGLA_JUG_INACTIVO,false);
    if (pers.isReglaJugadorSuspension()!=null)
    	qInsert.setBoolean(REGLA_JUG_SUSP,pers.isReglaJugadorSuspension().booleanValue());
    else
    	qInsert.setBoolean(REGLA_JUG_SUSP,false);
    
    if (pers.isReglaUnturnoActivo()!=null)
    	qInsert.setBoolean(REGLA_JUG_1TUR_ACT,pers.isReglaUnturnoActivo().booleanValue());
    else
    	qInsert.setBoolean(REGLA_JUG_1TUR_ACT,false);
    
    if (pers.isReglaDeudaCategoria()!=null)
    	qInsert.setBoolean(REGLA_DEUDA_CATEG,pers.isReglaDeudaCategoria().booleanValue());
    else
    	qInsert.setBoolean(REGLA_DEUDA_CATEG,false);
    
    if (pers.isReglaDeudaGeneral()!=null)
    	qInsert.setBoolean(REGLA_DEUDA_GRAL,pers.isReglaDeudaGeneral().booleanValue());
    else
    	qInsert.setBoolean(REGLA_DEUDA_GRAL,false);    
    
    if (pers.getMontoDeudaGral()!=null)
    	qInsert.setDouble(MONTO_DEUDA_GRAL,pers.getMontoDeudaGral().doubleValue());
    else
    	qInsert.setDouble(MONTO_DEUDA_GRAL,0);    
    
    if (pers.isReglaAntiguedadDeuda()!=null)
    	qInsert.setBoolean(REGLA_ANT_DEUDA,pers.isReglaAntiguedadDeuda().booleanValue());
    else
    	qInsert.setBoolean(REGLA_ANT_DEUDA,false);        
    
    qInsert.setInt(DIAS_ANT_DEUDA,pers.getDiasAntDeuda());
    
    if (pers.isReglaTurnoSegunCategoria()!=null)
    	qInsert.setBoolean(REGLA_NO_TUR_CATEG,pers.isReglaTurnoSegunCategoria().booleanValue());
    else
    	qInsert.setBoolean(REGLA_NO_TUR_CATEG,false);        
    
    if (pers.isReglaTurnoSegunRelacion()!=null)
    	qInsert.setBoolean(REGLA_NO_TUR_RELA,pers.isReglaTurnoSegunRelacion().booleanValue());
    else
    	qInsert.setBoolean(REGLA_NO_TUR_RELA,false);    
    
    if (pers.isReglaDeudaConcepto()!=null)
    	qInsert.setBoolean(REGLA_DEUDA_CONCEPTO,pers.isReglaDeudaConcepto().booleanValue());
    else
    	qInsert.setBoolean(REGLA_DEUDA_CONCEPTO,false);    
    
    if (pers.isReglaConcSufCateg()!=null)
    	qInsert.setBoolean(REGLA_CONC_SUF_CATE,pers.isReglaConcSufCateg().booleanValue());
    else
    	qInsert.setBoolean(REGLA_CONC_SUF_CATE,false);    
    
    	
    
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int CODIGO = 1;
    final int DESCRIPCION = 2;
    final int COMPORTAMIENTO = 3;
    final int ACTIVO = 4;
    final int USAR = 5;
    final int REGLA_JUGADOR_INACTIVO = 6;
    final int REGLA_JUGADOR_SUSP = 7;
    final int REGLA_JUG_1TUR_ACT = 8;
    
    final int REGLA_DEUDA_CATEG = 9;
    final int REGLA_DEUDA_GRAL = 10;
    final int MONTO_DEUDA_GRAL = 11;
    final int REGLA_ANT_DEUDA = 12;
    final int DIAS_ANT_DEUDA = 13;
    
    final int REGLA_NO_TUR_CATEG = 14;
    final int REGLA_NO_TUR_RELA = 15;
    
    final int REGLA_DEUDA_CONCEPTO = 16;
    
    final int REGLA_CONC_SUF_CATE = 17;
    
    final int OID_REGLA_CAB = 18;
    

    ReglamentoTurno pers = (ReglamentoTurno) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update tuReglamentoCab set "+
              "codigo=?"+ 
              ",descripcion=?"+ 
              ",comportamiento=?"+ 
              ",activo=?"+ 
              ",usar=?"+
              ",regla_jug_inactivo=?"+
              ",regla_jug_susp=?"+
              ",regla_juj_1tur_act=?"+
              ",regla_deuda_categ=?"+
              ",regla_deuda_gral=?"+
              ",monto_deuda_gral=?"+
              ",regla_ant_deuda=?"+
              ",dias_ant_deuda=?,regla_no_tur_categ=?,regla_no_tur_rela=? , regla_deuda_conc = ? ,regla_conc_suf_cat = ? "+
                 " where " +
                 " oid_regla_cab=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_REGLA_CAB,pers.getOID());
    qUpdate.setString(CODIGO,pers.getCodigo());
    qUpdate.setString(DESCRIPCION,pers.getDescripcion());
    qUpdate.setString(COMPORTAMIENTO,pers.getComportamiento());
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    if (pers.isUsar()!=null)
    	qUpdate.setBoolean(USAR,pers.isUsar().booleanValue());
    else
    	qUpdate.setBoolean(USAR,false);
    if (pers.isReglaJugadorInactivo()!=null)
    	qUpdate.setBoolean(REGLA_JUGADOR_INACTIVO,pers.isReglaJugadorInactivo().booleanValue());
    else
    	qUpdate.setBoolean(REGLA_JUGADOR_INACTIVO,false);
    if (pers.isReglaJugadorSuspension()!=null)
    	qUpdate.setBoolean(REGLA_JUGADOR_SUSP,pers.isReglaJugadorSuspension().booleanValue());
    else
    	qUpdate.setBoolean(REGLA_JUGADOR_SUSP,false);
    
    if (pers.isReglaUnturnoActivo()!=null)
    	qUpdate.setBoolean(REGLA_JUG_1TUR_ACT,pers.isReglaUnturnoActivo().booleanValue());
    else
    	qUpdate.setBoolean(REGLA_JUG_1TUR_ACT,false);
    
    if (pers.isReglaDeudaCategoria()!=null)
    	qUpdate.setBoolean(REGLA_DEUDA_CATEG,pers.isReglaDeudaCategoria().booleanValue());
    else
    	qUpdate.setBoolean(REGLA_DEUDA_CATEG,false);
    
    if (pers.isReglaDeudaGeneral()!=null)
    	qUpdate.setBoolean(REGLA_DEUDA_GRAL,pers.isReglaDeudaGeneral().booleanValue());
    else
    	qUpdate.setBoolean(REGLA_DEUDA_GRAL,false);    
    
    if (pers.getMontoDeudaGral()!=null)
    	qUpdate.setDouble(MONTO_DEUDA_GRAL,pers.getMontoDeudaGral().doubleValue());
    else
    	qUpdate.setDouble(MONTO_DEUDA_GRAL,0);    
    
    if (pers.isReglaAntiguedadDeuda()!=null)
    	qUpdate.setBoolean(REGLA_ANT_DEUDA,pers.isReglaAntiguedadDeuda().booleanValue());
    else
    	qUpdate.setBoolean(REGLA_ANT_DEUDA,false);        
    
    qUpdate.setInt(DIAS_ANT_DEUDA,pers.getDiasAntDeuda());
    
    if (pers.isReglaTurnoSegunCategoria()!=null)
    	qUpdate.setBoolean(REGLA_NO_TUR_CATEG,pers.isReglaTurnoSegunCategoria().booleanValue());
    else
    	qUpdate.setBoolean(REGLA_NO_TUR_CATEG,false);        
    
    if (pers.isReglaTurnoSegunRelacion()!=null)
    	qUpdate.setBoolean(REGLA_NO_TUR_RELA,pers.isReglaTurnoSegunRelacion().booleanValue());
    else
    	qUpdate.setBoolean(REGLA_NO_TUR_RELA,false);    
    
    if (pers.isReglaDeudaConcepto()!=null)
    	qUpdate.setBoolean(REGLA_DEUDA_CONCEPTO,pers.isReglaDeudaConcepto().booleanValue());
    else
    	qUpdate.setBoolean(REGLA_DEUDA_CONCEPTO,false);    
    
    if (pers.isReglaConcSufCateg()!=null)
    	qUpdate.setBoolean(REGLA_CONC_SUF_CATE,pers.isReglaConcSufCateg().booleanValue());
    else
    	qUpdate.setBoolean(REGLA_CONC_SUF_CATE,false);    
    
    
    qUpdate.executeUpdate();
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_REGLA_CAB = 1; 
    ReglamentoTurno pers = (ReglamentoTurno) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update tuReglamentoCab "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_regla_cab=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_REGLA_CAB, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_REGLA_CAB = 1; 
    ReglamentoTurno pers = (ReglamentoTurno) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update tuReglamentoCab "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_regla_cab=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_REGLA_CAB, pers.getOID()); 
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
      case SELECT_BY_COMPO_USAR: {
        ps = this.selectByComportamientoUsar(aCondiciones); 
        break; 
      }
    } 
    return ps;
  } 

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_REGLA_CAB = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  tuReglamentoCab "); 
    textSQL.append(" WHERE oid_regla_cab = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_REGLA_CAB, oid); 
    return querySelect; 
  }
  
  private PreparedStatement selectByComportamientoUsar(Object aCondiciones) throws BaseException, SQLException { 

	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM  tuReglamentoCab "); 
	    textSQL.append(" WHERE comportamiento = ? and usar = 1");
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
	    String comportamiento = (String) aCondiciones; 
	    querySelect.setString(1, comportamiento); 
	    return querySelect; 
	  }
  
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  tuReglamentoCab "); 
    textSQL.append(" WHERE CODIGO = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_regla_cab oid, codigo, codigo descripcion ,activo ");
    textSQL.append(" from tuReglamentoCab");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  } 
  
  public static ReglamentoTurno getReglamentoTurnoUsar(String comportamiento,
          ISesion aSesion)
          throws BaseException {
	  return (ReglamentoTurno) ObjetoLogico.getObjects(ReglamentoTurno.NICKNAME,
			  				DBReglamentoTurno.SELECT_BY_COMPO_USAR,
			  				comportamiento,
			  				new ObjetoObservado(),
			  				aSesion);
  }
  
  
} 
