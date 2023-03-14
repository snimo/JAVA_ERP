package com.srn.erp.cip.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.srn.erp.cip.bm.AccesoValClasif;
import com.srn.erp.general.bm.ValorClasificadorEntidad;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ObjetoObservado;

public class DBAccesoValClasif extends DBObjetoPersistente {

  public static final String OID_VAL_ACCESO = "oid_val_acceso";
  public static final String TIPO_INGRESO = "tipo_ingreso";
  public static final String LEY_NO_INGRESO = "ley_no_ingreso";
  public static final String MIN_ENT_ANTES = "min_ent_antes";
  public static final String MIN_ENT_DESPUES = "min_ent_despues";
  public static final String TIPO_EGRESO = "tipo_egreso";
  public static final String LEY_NO_EGRESO = "ley_no_egreso";
  public static final String ANTIPASSBACK = "antipassback";
  public static final String CACHEO = "cacheo";
  public static final String ACTIVO = "activo";
  public static final String OID_VAL_CLASIF = "oid_val_clasif";
  
  public static final int SELECT_VAL_CLASIF_ACTIVO = 100;

  public DBAccesoValClasif() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_VAL_ACCESO = 1;
    final int TIPO_INGRESO = 2;
    final int LEY_NO_INGRESO = 3;
    final int MIN_ENT_ANTES = 4;
    final int MIN_ENT_DESPUES = 5;
    final int TIPO_EGRESO = 6;
    final int LEY_NO_EGRESO = 7;
    final int ANTIPASSBACK = 8;
    final int CACHEO = 9;
    final int ACTIVO = 10;
    final int OID_VAL_CLASIF = 11;

    AccesoValClasif pers = (AccesoValClasif) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into cipValClasifAcceso "+
                     " ( "+
                      "OID_VAL_ACCESO,"+
                      "TIPO_INGRESO,"+
                      "LEY_NO_INGRESO,"+
                      "MIN_ENT_ANTES,"+
                      "MIN_ENT_DESPUES,"+
                      "TIPO_EGRESO,"+
                      "LEY_NO_EGRESO,"+
                      "ANTIPASSBACK,"+
                      "CACHEO,"+
                      "ACTIVO,OID_VAL_CLASIF)"+ 
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
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_VAL_ACCESO,pers.getOID());
    qInsert.setString(TIPO_INGRESO,pers.getTipo_ingreso());
    qInsert.setString(LEY_NO_INGRESO,pers.getLey_no_ingreso());
    qInsert.setInt(MIN_ENT_ANTES,pers.getMin_ent_antes().intValue());
    qInsert.setInt(MIN_ENT_DESPUES,pers.getMin_ent_despues().intValue());
    qInsert.setString(TIPO_EGRESO,pers.getTipo_egreso());
    qInsert.setString(LEY_NO_EGRESO,pers.getLey_no_egreso());
    qInsert.setBoolean(ANTIPASSBACK,pers.isAntipassback().booleanValue());
    qInsert.setBoolean(CACHEO,pers.isCacheo().booleanValue());
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qInsert.setInt(OID_VAL_CLASIF, pers.getValor().getOID());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int TIPO_INGRESO = 1;
    final int LEY_NO_INGRESO = 2;
    final int MIN_ENT_ANTES = 3;
    final int MIN_ENT_DESPUES = 4;
    final int TIPO_EGRESO = 5;
    final int LEY_NO_EGRESO = 6;
    final int ANTIPASSBACK = 7;
    final int CACHEO = 8;
    final int ACTIVO = 9;
    final int OID_VAL_CLASIF = 10;
    final int OID_VAL_ACCESO = 11;

    AccesoValClasif pers = (AccesoValClasif) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update cipValClasifAcceso set "+
              "tipo_ingreso=?"+ 
              ",ley_no_ingreso=?"+ 
              ",min_ent_antes=?"+ 
              ",min_ent_despues=?"+ 
              ",tipo_egreso=?"+ 
              ",ley_no_egreso=?"+ 
              ",antipassback=?"+ 
              ",cacheo=?"+ 
              ",activo=?"+ 
              ",oid_val_clasif=?"+
                 " where " +
                 " oid_val_acceso=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_VAL_ACCESO,pers.getOID());
    qUpdate.setString(TIPO_INGRESO,pers.getTipo_ingreso());
    qUpdate.setString(LEY_NO_INGRESO,pers.getLey_no_ingreso());
    qUpdate.setInt(MIN_ENT_ANTES,pers.getMin_ent_antes().intValue());
    qUpdate.setInt(MIN_ENT_DESPUES,pers.getMin_ent_despues().intValue());
    qUpdate.setString(TIPO_EGRESO,pers.getTipo_egreso());
    qUpdate.setString(LEY_NO_EGRESO,pers.getLey_no_egreso());
    qUpdate.setBoolean(ANTIPASSBACK,pers.isAntipassback().booleanValue());
    qUpdate.setBoolean(CACHEO,pers.isCacheo().booleanValue());
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.setInt(OID_VAL_CLASIF, pers.getValor().getOID());
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_VAL_ACCESO = 1; 
    AccesoValClasif pers = (AccesoValClasif) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update cipValClasifAcceso "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_val_acceso=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_VAL_ACCESO, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_VAL_ACCESO = 1; 
    AccesoValClasif pers = (AccesoValClasif) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update cipValClasifAcceso "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_val_acceso=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_VAL_ACCESO, pers.getOID()); 
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
      case SELECT_VAL_CLASIF_ACTIVO: {
          ps = this.selectByValClasifActivo(aCondiciones); 
          break; 
      }
    } 
    return ps;
  } 

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_VAL_ACCESO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  cipValClasifAcceso "); 
    textSQL.append(" WHERE oid_val_acceso = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_VAL_ACCESO, oid); 
    return querySelect; 
  }

  private PreparedStatement selectByValClasifActivo(Object aCondiciones) throws BaseException, SQLException { 
	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM  cipValClasifAcceso "); 
	    textSQL.append(" WHERE oid_val_clasif  = ? and activo = 1 ");
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
	    ValorClasificadorEntidad valor = (ValorClasificadorEntidad) aCondiciones; 
	    querySelect.setInt(1, valor.getOID()); 
	    return querySelect; 
  }
  
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  cipValClasifAcceso "); 
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_val_acceso oid, codigo,  descripcion ,activo ");
    textSQL.append(" from cipValClasifAcceso");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  }
  
  public static AccesoValClasif getAccesoValClasif(
		  ValorClasificadorEntidad valor,
          ISesion aSesion)
          throws BaseException {
	  return (AccesoValClasif) ObjetoLogico.getObjects(AccesoValClasif.NICKNAME,
			  				DBAccesoValClasif.SELECT_VAL_CLASIF_ACTIVO,
			  				valor,
			  				new ObjetoObservado(),
			  				aSesion);
  }
  
  
} 
