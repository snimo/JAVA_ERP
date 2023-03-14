package com.srn.erp.presupuesto.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.presupuesto.bm.Escenario;
import com.srn.erp.presupuesto.bm.ValorEscenario;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;

public class DBValorEscenario extends DBObjetoPersistente {

  public static final String OID_VAL_ESCENARIO = "oid_val_escenario";
  public static final String OID_ESCENARIO = "oid_escenario";
  public static final String DESCRIPCION = "descripcion";
  public static final String OID_COMPO_PRESU = "oid_compo_presu";
  public static final String OID_VALOR_COMPO = "oid_valor_compo";
  public static final String NRO_RELACION = "nro_relacion";
  public static final String NRO_RELACION_PADRE = "nro_relacion_padre";
  public static final String ACTIVO = "activo";
  public static final String ULTIMO_NIVEL = "ultimo_nivel";
  
  public static final int SELECT_BY_ESCENARIO = 100;
  public static final int SELECT_BY_ULT_NIVEL = 101;

  public DBValorEscenario() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_VAL_ESCENARIO = 1;
    final int OID_ESCENARIO = 2;
    final int OID_COMPO_PRESU = 3;
    final int OID_VALOR_COMPO = 4;
    final int NRO_RELACION = 5;
    final int NRO_RELACION_PADRE = 6;
    final int ACTIVO = 7;
    final int ULTIMO_NIVEL = 8;
    final int DESCRIPCION = 9;

    ValorEscenario pers = (ValorEscenario) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into plValorEscenario "+
                     " ( "+
                      "OID_VAL_ESCENARIO,"+
                      "OID_ESCENARIO,"+
                      "OID_COMPO_PRESU,"+
                      "OID_VALOR_COMPO,"+
                      "NRO_RELACION,"+
                      "NRO_RELACION_PADRE,"+
                      "ACTIVO," +
                      "ULTIMO_NIVEL," +
                      "DESCRIPCION)"+ 
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
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_VAL_ESCENARIO,pers.getOID());
    qInsert.setInt(OID_ESCENARIO,pers.getEscenario().getOID());
    qInsert.setInt(OID_COMPO_PRESU,pers.getCompo_presu().getOID());
    qInsert.setInt(OID_VALOR_COMPO,pers.getValor_compo().getOID());
    qInsert.setString(NRO_RELACION,pers.getNro_relacion());
    qInsert.setString(NRO_RELACION_PADRE,pers.getNro_relacion_padre());
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qInsert.setBoolean(ULTIMO_NIVEL,pers.isUltimoNivel().booleanValue());
    qInsert.setString(DESCRIPCION,pers.getDescripcion());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_ESCENARIO = 1;
    final int OID_COMPO_PRESU = 2;
    final int OID_VALOR_COMPO = 3;
    final int NRO_RELACION = 4;
    final int NRO_RELACION_PADRE = 5;
    final int ACTIVO = 6;
    final int ULTIMO_NIVEL = 7;
    final int DESCRIPCION = 8;
    final int OID_VAL_ESCENARIO = 9;

    ValorEscenario pers = (ValorEscenario) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update plValorEscenario set "+
              "oid_escenario=?"+ 
              ",oid_compo_presu=?"+ 
              ",oid_valor_compo=?"+ 
              ",nro_relacion=?"+ 
              ",nro_relacion_padre=?"+ 
              ",activo=?"+ 
              ",ultimo_nivel=?"+
              ",descripcion=?"+
                 " where " +
                 " oid_val_escenario=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_ESCENARIO,pers.getEscenario().getOID());
    qUpdate.setInt(OID_VAL_ESCENARIO,pers.getOID());
    qUpdate.setInt(OID_COMPO_PRESU,pers.getCompo_presu().getOID());
    qUpdate.setInt(OID_VALOR_COMPO,pers.getValor_compo().getOID());
    qUpdate.setString(NRO_RELACION,pers.getNro_relacion());
    qUpdate.setString(NRO_RELACION_PADRE,pers.getNro_relacion_padre());
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.setBoolean(ULTIMO_NIVEL,pers.isUltimoNivel().booleanValue());
    qUpdate.setString(DESCRIPCION,pers.getDescripcion());
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    ValorEscenario valorEscenario = (ValorEscenario) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update plValorEscenario "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_val_escenario=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(1, valorEscenario.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    ValorEscenario pers = (ValorEscenario) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update plValorEscenario "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_val_escenario=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(1, pers.getOID()); 
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
      case SELECT_BY_ESCENARIO: {
        ps = this.selectByEscenario(aCondiciones); 
        break; 
      }
      case SELECT_BY_ULT_NIVEL: {
        ps = this.selectByUltNivel(aCondiciones); 
        break; 
      }
    } 
    return ps;
  } 

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 
    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  plValorEscenario"); 
    textSQL.append(" WHERE oid_val_escenario = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(1, oid); 
    return querySelect; 
  }
  
  private PreparedStatement selectByUltNivel(Object aCondiciones) throws BaseException, SQLException { 
    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  plValorEscenario "); 
    textSQL.append(" WHERE ultimo_nivel = 1 and activo = 1 ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    return querySelect; 
  }
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 
    final int CODIGO = 1; 
    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  plValorEscenario "); 
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }
  
  private PreparedStatement selectByEscenario(Object aCondiciones) throws BaseException, SQLException { 
    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  plValorEscenario "); 
    textSQL.append(" WHERE oid_escenario = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    Escenario escenario = (Escenario) aCondiciones;
    querySelect.setInt(1, escenario.getOID()); 
    return querySelect; 
  }
  
  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_val_escenario oid, codigo,  descripcion ,activo ");
    textSQL.append(" from plValorEscenario");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  }
  
  public static List getValoresByEscenario(Escenario escenario,
      ISesion aSesion) throws BaseException {
  	return (List) ObjetoLogico.getObjects(ValorEscenario.NICKNAME,
         DBValorEscenario.SELECT_BY_ESCENARIO,
         escenario,
         new ListObserver(),
         aSesion);
  }
  
  public static List getValoresByUltimoNivelActivos(ISesion aSesion) throws BaseException {
  	return (List) ObjetoLogico.getObjects(ValorEscenario.NICKNAME,
         DBValorEscenario.SELECT_BY_ULT_NIVEL,
         null,
         new ListObserver(),
         aSesion);
  }
  
} 
