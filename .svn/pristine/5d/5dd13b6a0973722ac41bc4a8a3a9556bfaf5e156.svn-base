package com.srn.erp.cip.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.cip.bm.PaseRechazado;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;

public class DBPaseRechazado extends DBObjetoPersistente {

  public static final String OID_PASE_RECH = "oid_pase_rech";
  public static final String OID_LEGAJO = "oid_legajo";
  public static final String FECHA = "fecha";
  public static final String HORA = "hora";
  public static final String OID_PUERTA = "oid_puerta";
  public static final String MEDIA = "media";
  public static final String MOTIVO = "motivo";
  public static final String ACTIVO = "activo";
  public static final String ENTRADA_SALIDA = "entrada_salida";
  public static final String OID_VISITA = "oid_visita";
  
  public static final int SELECT_BY_CONDICIONES = 100;

  public DBPaseRechazado() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_PASE_RECH = 1;
    final int OID_LEGAJO = 2;
    final int FECHA = 3;
    final int HORA = 4;
    final int OID_PUERTA = 5;
    final int MEDIA = 6;
    final int MOTIVO = 7;
    final int ACTIVO = 8;
    final int ENTRADA_SALIDA = 9;
    final int OID_VISITA = 10;

    PaseRechazado pers = (PaseRechazado) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into cipPasesRech "+
                     " ( "+
                      "OID_PASE_RECH,"+
                      "OID_LEGAJO,"+
                      "FECHA,"+
                      "HORA,"+
                      "OID_PUERTA,"+
                      "MEDIA,"+
                      "MOTIVO,"+
                      "ACTIVO,ENTRADA_SALIDA,OID_VISITA)"+ 
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
    qInsert.setInt(OID_PASE_RECH,pers.getOID());
    if (pers.getLegajo()!=null) 
      qInsert.setInt(OID_LEGAJO,pers.getLegajo().getOID());
    else
      qInsert.setNull(OID_LEGAJO,java.sql.Types.INTEGER);
    qInsert.setDate(FECHA,new java.sql.Date(pers.getFecha().getTime()));
    qInsert.setString(HORA,pers.getHora());
    qInsert.setInt(OID_PUERTA,pers.getPuerta().getOID());
    qInsert.setInt(MEDIA,pers.getMedia().intValue());
    if (pers.getMotivo()!=null)
    	qInsert.setString(MOTIVO,pers.getMotivo());
    else
    	qInsert.setString(MOTIVO,"");
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qInsert.setString(ENTRADA_SALIDA, pers.getEntradaSalida());
    if (pers.getVisita()!=null)
    	qInsert.setInt(OID_VISITA, pers.getVisita().getOID());
    else
    	qInsert.setNull(OID_VISITA, java.sql.Types.INTEGER);
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_LEGAJO = 1;
    final int FECHA = 2;
    final int HORA = 3;
    final int OID_PUERTA = 4;
    final int MEDIA = 5;
    final int MOTIVO = 6;
    final int ACTIVO = 7;
    final int ENTRADA_SALIDA = 8;
    final int OID_VISITA = 9;
    final int OID_PASE_RECH = 10;

    PaseRechazado pers = (PaseRechazado) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update cipPasesRech set "+
              "oid_legajo=?"+ 
              ",fecha=?"+ 
              ",hora=?"+ 
              ",oid_puerta=?"+ 
              ",media=?"+ 
              ",motivo=?"+ 
              ",activo=?"+
              ",entrada_salida=?"+ 
              ",oid_visita=?"+
                 " where " +
                 " oid_pase_rech=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_PASE_RECH,pers.getOID());
    if (pers.getLegajo()!=null) 
      qUpdate.setInt(OID_LEGAJO,pers.getLegajo().getOID());
    else
      qUpdate.setNull(OID_LEGAJO,java.sql.Types.INTEGER);
    qUpdate.setDate(FECHA,new java.sql.Date(pers.getFecha().getTime()));
    qUpdate.setString(HORA,pers.getHora());
    qUpdate.setInt(OID_PUERTA,pers.getPuerta().getOID());
    qUpdate.setInt(MEDIA,pers.getMedia().intValue());
    if (pers.getMotivo()!=null)
    	qUpdate.setString(MOTIVO,pers.getMotivo());
    else
    	qUpdate.setString(MOTIVO,"");
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.setString(ENTRADA_SALIDA, pers.getEntradaSalida());
    if (pers.getVisita()!=null)
    	qUpdate.setInt(OID_VISITA, pers.getVisita().getOID());
    else
    	qUpdate.setNull(OID_VISITA, Types.INTEGER);
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_PASE_RECH = 1; 
    PaseRechazado pers = (PaseRechazado) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update cipPasesRech "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_pase_rech=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_PASE_RECH, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_PASE_RECH = 1; 
    PaseRechazado pers = (PaseRechazado) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update cipPasesRech "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_pase_rech=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_PASE_RECH, pers.getOID()); 
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
      case SELECT_BY_CONDICIONES: {
          ps = this.selectByCondiciones(aCondiciones); 
          break; 
      }
    } 
    return ps;
  } 

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_PASE_RECH = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  cipPasesRech "); 
    textSQL.append(" WHERE oid_pase_rech = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_PASE_RECH, oid); 
    return querySelect; 
  }
  
  
  private PreparedStatement selectByCondiciones(Object aCondiciones) throws BaseException, SQLException { 

	    HashTableDatos condiciones = (HashTableDatos) aCondiciones;
	    java.util.Date fecDesde = (java.util.Date) condiciones.get("FEC_DESDE");
	    java.util.Date fecHasta = (java.util.Date) condiciones.get("FEC_HASTA");
	    List listaLegajos = (List) condiciones.get("LISTA_LEGAJOS");
	    
	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM  cipPasesRech "); 
	    textSQL.append(" WHERE fecha >= ? and fecha<=? and activo=1  ");
	    
	    if ((listaLegajos!=null) && (listaLegajos.size()>0)) {
	    	StringBuffer oidLegajos = new StringBuffer("");
	    	textSQL.append(" and oid_legajo in ( ");
	    	Iterator iterOIDLeg = 
	    		listaLegajos.iterator();
	    	while (iterOIDLeg.hasNext()) {
	    		Integer oidLegajo = (Integer) iterOIDLeg.next();
	    		if (oidLegajos.length()==0)
	    			oidLegajos.append(oidLegajo);
	    		else
	    			oidLegajos.append(","+oidLegajo);
	    	}
	    	textSQL.append(oidLegajos.toString());
	    	textSQL.append(" ) ");
	    }
	    
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
	    querySelect.setDate(1, new java.sql.Date(fecDesde.getTime())); 
	    querySelect.setDate(2, new java.sql.Date(fecHasta.getTime()));
	    return querySelect;
	    
	  }

  
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  cipPasesRech "); 
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_pase_rech oid, codigo,  descripcion ,activo ");
    textSQL.append(" from cipPasesRech");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  }
  
  public static List getPasesRechazados(
		  java.util.Date fecDesde,
		  java.util.Date fecHasta,
		  List listaLegajos,
          ISesion aSesion) throws BaseException {
	  
	  HashTableDatos condiciones = new HashTableDatos();
	  condiciones.put("FEC_DESDE", fecDesde);
	  condiciones.put("FEC_HASTA", fecHasta);
	  condiciones.put("LISTA_LEGAJOS", listaLegajos);
	  
	  return (List) ObjetoLogico.getObjects(PaseRechazado.NICKNAME,
             DBPaseRechazado.SELECT_BY_CONDICIONES,
             condiciones,
             new ListObserver(),
             aSesion);
	  
  }
  
  
} 
