package com.srn.erp.ventas.da;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.ventas.bm.EsquemaBonificacionVigSuj;
import com.srn.erp.ventas.bm.Sujeto;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.ObjetoObservado;

public class DBEsquemaBonificacionVigSuj extends DBObjetoPersistente {

  public static final String OID_ESQ_BON_SUJ = "oid_esq_bon_suj";
  public static final String OID_ESQ_BONIF = "oid_esq_bonif";
  public static final String OID_SUJETO = "oid_sujeto";
  public static final String FEC_VIG_DESDE = "fec_vig_desde";
  public static final String FEC_VIG_HASTA = "fec_vig_hasta";
  public static final String ACTIVO = "activo";
  
  public static final int SELECT_BY_SUJETO = 100;
  public static final int SELECT_BY_SUJETO_ESQ_VIG = 101;

  public DBEsquemaBonificacionVigSuj() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_ESQ_BON_SUJ = 1;
    final int OID_ESQ_BONIF = 2;
    final int OID_SUJETO = 3;
    final int FEC_VIG_DESDE = 4;
    final int FEC_VIG_HASTA = 5;
    final int ACTIVO = 6;

    EsquemaBonificacionVigSuj pers = (EsquemaBonificacionVigSuj) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into veEsqBonifVigSuj "+
                     " ( "+
                      "OID_ESQ_BON_SUJ,"+
                      "OID_ESQ_BONIF,"+
                      "OID_SUJETO,"+
                      "FEC_VIG_DESDE,"+
                      "FEC_VIG_HASTA,"+
                      "ACTIVO)"+ 
                      " values "+ 
                      "("+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_ESQ_BON_SUJ,pers.getOID());
    qInsert.setInt(OID_ESQ_BONIF,pers.getEsquema_bonificacion().getOID());
    qInsert.setInt(OID_SUJETO,pers.getSujeto().getOID());
    qInsert.setDate(FEC_VIG_DESDE,new Date(pers.getFec_vig_desde().getTime()));
    qInsert.setDate(FEC_VIG_HASTA,new Date(pers.getFec_vig_hasta().getTime()));
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_ESQ_BONIF = 1;
    final int OID_SUJETO = 2;
    final int FEC_VIG_DESDE = 3;
    final int FEC_VIG_HASTA = 4;
    final int ACTIVO = 5;
    final int OID_ESQ_BON_SUJ = 6;

    EsquemaBonificacionVigSuj pers = (EsquemaBonificacionVigSuj) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update veEsqBonifVigSuj set "+
              "oid_esq_bonif=?"+ 
              ",oid_sujeto=?"+ 
              ",fec_vig_desde=?"+ 
              ",fec_vig_hasta=?"+ 
              ",activo=?"+ 
                 " where " +
                 " oid_esq_bon_suj=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_ESQ_BON_SUJ,pers.getOID());
    qUpdate.setInt(OID_ESQ_BONIF,pers.getEsquema_bonificacion().getOID());
    qUpdate.setInt(OID_SUJETO,pers.getSujeto().getOID());
    qUpdate.setDate(FEC_VIG_DESDE,new Date(pers.getFec_vig_desde().getTime()));
    qUpdate.setDate(FEC_VIG_HASTA,new Date(pers.getFec_vig_hasta().getTime()));
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_ESQ_BON_SUJ = 1; 
    EsquemaBonificacionVigSuj pers = (EsquemaBonificacionVigSuj) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update veEsqBonifVigSuj "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_esq_bon_suj=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_ESQ_BON_SUJ, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_ESQ_BON_SUJ = 1; 
    EsquemaBonificacionVigSuj pers = (EsquemaBonificacionVigSuj) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update veEsqBonifVigSuj "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_esq_bon_suj=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_ESQ_BON_SUJ, pers.getOID()); 
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
      case SELECT_BY_SUJETO: {
        ps = this.selectBySujeto(aCondiciones); 
        break; 
      }
      case SELECT_BY_SUJETO_ESQ_VIG: {
        ps = this.selectBySujetoEsqVig(aCondiciones); 
         break; 
      }
    } 
    return ps;
  } 

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_ESQ_BON_SUJ = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  veEsqBonifVigSuj "); 
    textSQL.append(" WHERE oid_esq_bon_suj = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_ESQ_BON_SUJ, oid); 
    return querySelect; 
  }
  
  private PreparedStatement selectBySujetoEsqVig(Object aCondiciones) throws BaseException, SQLException {
	HashTableDatos condiciones = (HashTableDatos) aCondiciones;
	Sujeto sujeto = (Sujeto) condiciones.get(Sujeto.NICKNAME);
	java.util.Date fecha = (java.util.Date) condiciones.get("FECHA");
	StringBuffer textSQL = new StringBuffer();
	textSQL.append("SELECT * FROM  veEsqBonifVigSuj "); 
	textSQL.append(" WHERE oid_sujeto = ? and fec_vig_desde<=? and fec_vig_hasta>=? and activo=1 ");
	PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
	querySelect.setInt(1, sujeto.getOID()); 
	querySelect.setDate(2, new Date(fecha.getTime()));
	querySelect.setDate(3, new Date(fecha.getTime()));
	return querySelect; 
  }
  
  
  private PreparedStatement selectBySujeto(Object aCondiciones) throws BaseException, SQLException { 

	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM  veEsqBonifVigSuj "); 
	    textSQL.append(" WHERE oid_sujeto = ? ");
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
	    Sujeto sujeto = (Sujeto) aCondiciones; 
	    querySelect.setInt(1, sujeto.getOID()); 
	    return querySelect; 
	  }
  
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  veEsqBonifVigSuj "); 
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_esq_bon_suj oid, codigo,  descripcion ,activo ");
    textSQL.append(" from veEsqBonifVigSuj");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  }
  
  public static List getEsquemasBonifVigSuj(Sujeto sujeto,
          ISesion aSesion) throws BaseException {
	  return (List) ObjetoLogico.getObjects(EsquemaBonificacionVigSuj.NICKNAME,
             DBEsquemaBonificacionVigSuj.SELECT_BY_SUJETO,
             sujeto,
             new ListObserver(),
             aSesion);
  }
  
  public static EsquemaBonificacionVigSuj getEsquemaBonifVigSuj(Sujeto sujeto,java.util.Date fecha,
          ISesion aSesion)
          throws BaseException {
	  HashTableDatos condiciones = new HashTableDatos();
	  condiciones.put(Sujeto.NICKNAME,sujeto);
	  condiciones.put("FECHA",fecha);
	  return (EsquemaBonificacionVigSuj) ObjetoLogico.getObjects(EsquemaBonificacionVigSuj.NICKNAME,
			  				DBEsquemaBonificacionVigSuj.SELECT_BY_SUJETO_ESQ_VIG,
			  				condiciones,
			  				new ObjetoObservado(),
			  				aSesion);
  }
  
  
   
  
} 
