package com.srn.erp.cip.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.cip.bm.PlanoCIP;
import com.srn.erp.cip.bm.Puerta;
import com.srn.erp.cip.bm.PuertaPlanoCIP;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.ObjetoObservado;

public class DBPuertaPlanoCIP extends DBObjetoPersistente {

  public static final String OID_PUERTA_PLANO = "oid_puerta_plano";
  public static final String ORDEN = "orden";
  public static final String OID_PLANO = "oid_plano";
  public static final String OID_PUERTA = "oid_puerta";
  public static final String HAB_ENTRADA = "hab_entrada";
  public static final String HAB_SALIDA = "hab_salida";
  public static final String ACTIVO = "activo";
  
  public static final int SELECT_BY_PLANO 		 = 100;
  public static final int SELECT_BY_PLANO_PUERTA = 101;

  public DBPuertaPlanoCIP() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_PUERTA_PLANO = 1;
    final int ORDEN = 2;
    final int OID_PLANO = 3;
    final int OID_PUERTA = 4;
    final int HAB_ENTRADA = 5;
    final int HAB_SALIDA = 6;
    final int ACTIVO = 7;

    PuertaPlanoCIP pers = (PuertaPlanoCIP) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into cipPuertasPlano "+
                     " ( "+
                      "OID_PUERTA_PLANO,"+
                      "ORDEN,"+
                      "OID_PLANO,"+
                      "OID_PUERTA,"+
                      "HAB_ENTRADA,"+
                      "HAB_SALIDA,"+
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
    qInsert.setInt(OID_PUERTA_PLANO,pers.getOID());
    qInsert.setInt(ORDEN,pers.getOrden().intValue());
    qInsert.setInt(OID_PLANO,pers.getPlano().getOID());
    qInsert.setInt(OID_PUERTA,pers.getPuerta().getOID());
    qInsert.setBoolean(HAB_ENTRADA,pers.isHab_entrada().booleanValue());
    qInsert.setBoolean(HAB_SALIDA,pers.isHab_salida().booleanValue());
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int ORDEN = 1;
    final int OID_PLANO = 2;
    final int OID_PUERTA = 3;
    final int HAB_ENTRADA = 4;
    final int HAB_SALIDA = 5;
    final int ACTIVO = 6;
    final int OID_PUERTA_PLANO = 7;

    PuertaPlanoCIP pers = (PuertaPlanoCIP) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update cipPuertasPlano set "+
              "orden=?"+ 
              ",oid_plano=?"+ 
              ",oid_puerta=?"+ 
              ",hab_entrada=?"+ 
              ",hab_salida=?"+ 
              ",activo=?"+ 
                 " where " +
                 " oid_puerta_plano=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_PUERTA_PLANO,pers.getOID());
    qUpdate.setInt(ORDEN,pers.getOrden().intValue());
    qUpdate.setInt(OID_PLANO,pers.getPlano().getOID());
    qUpdate.setInt(OID_PUERTA,pers.getPuerta().getOID());
    qUpdate.setBoolean(HAB_ENTRADA,pers.isHab_entrada().booleanValue());
    qUpdate.setBoolean(HAB_SALIDA,pers.isHab_salida().booleanValue());
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_PUERTA_PLANO = 1; 
    PuertaPlanoCIP pers = (PuertaPlanoCIP) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update cipPuertasPlano "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_puerta_plano=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_PUERTA_PLANO, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_PUERTA_PLANO = 1; 
    PuertaPlanoCIP pers = (PuertaPlanoCIP) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update cipPuertasPlano "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_puerta_plano=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_PUERTA_PLANO, pers.getOID()); 
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
      case SELECT_BY_PLANO: {
          ps = this.selectByPlano(aCondiciones); 
          break; 
      }
      case SELECT_BY_PLANO_PUERTA: {
          ps = this.selectByPlanoPuerta(aCondiciones); 
          break; 
      }
    } 
    return ps;
  } 

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_PUERTA_PLANO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  cipPuertasPlano "); 
    textSQL.append(" WHERE oid_puerta_plano = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_PUERTA_PLANO, oid); 
    return querySelect; 
  }
  
  private PreparedStatement selectByPlanoPuerta(Object aCondiciones) throws BaseException, SQLException { 
	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM  cipPuertasPlano "); 
	    textSQL.append(" WHERE oid_plano = ? and oid_puerta = ? and activo = 1 ");
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
	    HashTableDatos condiciones = (HashTableDatos) aCondiciones;
	    PlanoCIP plano = (PlanoCIP) condiciones.get(PlanoCIP.NICKNAME);
	    Puerta puerta = (Puerta) condiciones.get(Puerta.NICKNAME);
	    querySelect.setInt(1, plano.getOID()); 
	    querySelect.setInt(2, puerta.getOID());
	    return querySelect; 
}
  
  
  private PreparedStatement selectByPlano(Object aCondiciones) throws BaseException, SQLException { 
	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM  cipPuertasPlano "); 
	    textSQL.append(" WHERE oid_plano = ? and activo = 1 ");
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
	    PlanoCIP plano = (PlanoCIP) aCondiciones; 
	    querySelect.setInt(1, plano.getOID()); 
	    return querySelect; 
  }
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  cipPuertasPlano "); 
    textSQL.append(" WHERE orden = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_puerta_plano oid,orden codigo,  descripcion ,activo ");
    textSQL.append(" from cipPuertasPlano");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  }
  
   public static List getPuertasPlano(PlanoCIP planoCIP,
	         ISesion aSesion) throws BaseException {
		 return (List) ObjetoLogico.getObjects(PuertaPlanoCIP.NICKNAME,
	            DBPuertaPlanoCIP.SELECT_BY_PLANO,
	            planoCIP,
	            new ListObserver(),
	            aSesion);
   }
   
   public static PuertaPlanoCIP getPuertaPlanoCIP(
		      Puerta puerta,
		      PlanoCIP plano,
	          ISesion aSesion)
	          throws BaseException {
	      HashTableDatos condiciones = new HashTableDatos();
	      condiciones.put(Puerta.NICKNAME, puerta);
	      condiciones.put(PlanoCIP.NICKNAME, plano);
		  return (PuertaPlanoCIP) ObjetoLogico.getObjects(PuertaPlanoCIP.NICKNAME,
				  				DBPuertaPlanoCIP.SELECT_BY_PLANO_PUERTA,
				  				condiciones,
				  				new ObjetoObservado(),
				  				aSesion);
	  }
   
  
  
} 
