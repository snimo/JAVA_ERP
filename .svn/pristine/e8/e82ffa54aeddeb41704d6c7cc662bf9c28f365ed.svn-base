package com.srn.erp.ventas.da;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import com.srn.erp.general.bm.ValorClasificadorEntidad;
import com.srn.erp.ventas.bm.EsquemaBonificacion;
import com.srn.erp.ventas.bm.EsquemaBonificacionClasifProd;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.ObjetoObservado;

public class DBEsquemaBonificacionClasifProd extends DBObjetoPersistente {

  public static final String OID_ESQ_BON_CLASIF = "oid_esq_bon_clasif";
  public static final String FEC_DESDE = "fec_desde";
  public static final String OID_ESQ_BONIF = "oid_esq_bonif";
  public static final String FEC_HASTA = "fec_hasta";
  public static final String PORC_BONIF_1 = "porc_bonif_1";
  public static final String PORC_BONIF_2 = "porc_bonif_2";
  public static final String PORC_BONIF_3 = "porc_bonif_3";
  public static final String PORC_BONIF_4 = "porc_bonif_4";
  public static final String PORC_BONIF_5 = "porc_bonif_5";
  public static final String EN_CASCADA = "en_cascada";
  public static final String ACTIVO = "activo";
  public static final String OID_VAL_CLASIF_ENT = "oid_val_clasif_ent";
  
  public static final int SELECT_BY_ESQUEMA_BONIF = 100;
  public static final int SELECT_BY_ESQ_BONIF_VAL_CLASIF_VIG = 101;

  public DBEsquemaBonificacionClasifProd() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_ESQ_BON_CLASIF = 1;
    final int FEC_DESDE = 2;
    final int OID_ESQ_BONIF = 3;
    final int FEC_HASTA = 4;
    final int PORC_BONIF_1 = 5;
    final int PORC_BONIF_2 = 6;
    final int PORC_BONIF_3 = 7;
    final int PORC_BONIF_4 = 8;
    final int PORC_BONIF_5 = 9;
    final int EN_CASCADA = 10;
    final int ACTIVO = 11;
    final int OID_VAL_CLASIF_ENT = 12;

    EsquemaBonificacionClasifProd pers = (EsquemaBonificacionClasifProd) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into veEsqBonifClasif "+
                     " ( "+
                      "OID_ESQ_BON_CLASIF,"+
                      "FEC_DESDE,"+
                      "OID_ESQ_BONIF,"+
                      "FEC_HASTA,"+
                      "PORC_BONIF_1,"+
                      "PORC_BONIF_2,"+
                      "PORC_BONIF_3,"+
                      "PORC_BONIF_4,"+
                      "PORC_BONIF_5,"+
                      "EN_CASCADA,"+
                      "ACTIVO,"+
                      "OID_VAL_CLASIF_ENT)"+ 
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
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_ESQ_BON_CLASIF,pers.getOID());
    qInsert.setDate(FEC_DESDE,new Date(pers.getFec_desde().getTime()));
    qInsert.setInt(OID_ESQ_BONIF,pers.getEsquema_bonificacion().getOID());
    qInsert.setDate(FEC_HASTA,new Date(pers.getFec_hasta().getTime()));
    if (pers.getPorc_bonif_1()!=null)
    	qInsert.setDouble(PORC_BONIF_1,pers.getPorc_bonif_1().doubleValue());
    else
    	qInsert.setNull(PORC_BONIF_1,Types.DOUBLE);
    if (pers.getPorc_bonif_2()!=null)
    	qInsert.setDouble(PORC_BONIF_2,pers.getPorc_bonif_2().doubleValue());
    else
    	qInsert.setNull(PORC_BONIF_2,Types.DOUBLE);
    if (pers.getPorc_bonif_3()!=null)
    	qInsert.setDouble(PORC_BONIF_3,pers.getPorc_bonif_3().doubleValue());
    else
    	qInsert.setNull(PORC_BONIF_3,Types.DOUBLE);
    if (pers.getPorc_bonif_4()!=null)
    	qInsert.setDouble(PORC_BONIF_4,pers.getPorc_bonif_4().doubleValue());
    else
    	qInsert.setNull(PORC_BONIF_4,Types.DOUBLE);
    if (pers.getPorc_bonif_5()!=null)
    	qInsert.setDouble(PORC_BONIF_5,pers.getPorc_bonif_5().doubleValue());
    else
    	qInsert.setNull(PORC_BONIF_5,Types.DOUBLE);
    qInsert.setBoolean(EN_CASCADA,pers.isEn_cascada().booleanValue());
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qInsert.setInt(OID_VAL_CLASIF_ENT,pers.getValor_clasif_entidad().getOID());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int FEC_DESDE = 1;
    final int OID_ESQ_BONIF = 2;
    final int FEC_HASTA = 3;
    final int PORC_BONIF_1 = 4;
    final int PORC_BONIF_2 = 5;
    final int PORC_BONIF_3 = 6;
    final int PORC_BONIF_4 = 7;
    final int PORC_BONIF_5 = 8;
    final int EN_CASCADA = 9;
    final int ACTIVO = 10;
    final int OID_VAL_CLASIF_ENT = 11;
    final int OID_ESQ_BON_CLASIF = 12;

    EsquemaBonificacionClasifProd pers = (EsquemaBonificacionClasifProd) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update veEsqBonifClasif set "+
              "fec_desde=?"+ 
              ",oid_esq_bonif=?"+ 
              ",fec_hasta=?"+ 
              ",porc_bonif_1=?"+ 
              ",porc_bonif_2=?"+ 
              ",porc_bonif_3=?"+ 
              ",porc_bonif_4=?"+ 
              ",porc_bonif_5=?"+ 
              ",en_cascada=?"+ 
              ",activo=?"+ 
              ",oid_val_clasif_ent=?"+ 
                 " where " +
                 " oid_esq_bon_clasif=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_ESQ_BON_CLASIF,pers.getOID());
    qUpdate.setDate(FEC_DESDE,new Date(pers.getFec_desde().getTime()));
    qUpdate.setInt(OID_ESQ_BONIF,pers.getEsquema_bonificacion().getOID());
    qUpdate.setDate(FEC_HASTA,new Date(pers.getFec_hasta().getTime()));
    if (pers.getPorc_bonif_1()!=null)
    	qUpdate.setDouble(PORC_BONIF_1,pers.getPorc_bonif_1().doubleValue());
    else
    	qUpdate.setNull(PORC_BONIF_1,Types.DOUBLE);
    if (pers.getPorc_bonif_2()!=null)
    	qUpdate.setDouble(PORC_BONIF_2,pers.getPorc_bonif_2().doubleValue());
    else
    	qUpdate.setNull(PORC_BONIF_2,Types.DOUBLE);
    if (pers.getPorc_bonif_3()!=null)
    	qUpdate.setDouble(PORC_BONIF_3,pers.getPorc_bonif_3().doubleValue());
    else
    	qUpdate.setNull(PORC_BONIF_3,Types.DOUBLE);
    if (pers.getPorc_bonif_4()!=null)
    	qUpdate.setDouble(PORC_BONIF_4,pers.getPorc_bonif_4().doubleValue());
    else
    	qUpdate.setNull(PORC_BONIF_4,Types.DOUBLE);
    if (pers.getPorc_bonif_5()!=null)
    	qUpdate.setDouble(PORC_BONIF_5,pers.getPorc_bonif_5().doubleValue());
    else
    	qUpdate.setNull(PORC_BONIF_5,Types.DOUBLE);
        
    qUpdate.setBoolean(EN_CASCADA,pers.isEn_cascada().booleanValue());
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.setInt(OID_VAL_CLASIF_ENT,pers.getValor_clasif_entidad().getOID());
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_ESQ_BON_CLASIF = 1; 
    EsquemaBonificacionClasifProd pers = (EsquemaBonificacionClasifProd) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update veEsqBonifClasif "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_esq_bon_clasif=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_ESQ_BON_CLASIF, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_ESQ_BON_CLASIF = 1; 
    EsquemaBonificacionClasifProd pers = (EsquemaBonificacionClasifProd) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update veEsqBonifClasif "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_esq_bon_clasif=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_ESQ_BON_CLASIF, pers.getOID()); 
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
      case SELECT_BY_ESQUEMA_BONIF: {
        ps = this.selectByEsquemaBonif(aCondiciones); 
        break; 
      }
      case SELECT_BY_ESQ_BONIF_VAL_CLASIF_VIG: {
        ps = this.selectByEsquemaBonifValClasifVig(aCondiciones); 
        break; 
      }
    } 
    return ps;
  } 

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_ESQ_BON_CLASIF = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  veEsqBonifClasif "); 
    textSQL.append(" WHERE oid_esq_bon_clasif = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_ESQ_BON_CLASIF, oid); 
    return querySelect; 
  }
  
  private PreparedStatement selectByEsquemaBonif(Object aCondiciones) throws BaseException, SQLException { 
	StringBuffer textSQL = new StringBuffer(); 
	textSQL.append("SELECT * FROM  veEsqBonifClasif "); 
	textSQL.append(" WHERE  oid_esq_bonif = ? ");
	PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
	EsquemaBonificacion esquemaBonificacion = (EsquemaBonificacion) aCondiciones; 
	querySelect.setInt(1, esquemaBonificacion.getOID()); 
	return querySelect; 
  }
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  veEsqBonifClasif "); 
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }
  
  private PreparedStatement selectByEsquemaBonifValClasifVig(Object aCondiciones) throws BaseException, SQLException {

	    HashTableDatos condiciones = (HashTableDatos) aCondiciones;
	    EsquemaBonificacion esquemaBonificacion = (EsquemaBonificacion) condiciones.get(EsquemaBonificacion.NICKNAME);
	    ValorClasificadorEntidad valorClasifEntidad = (ValorClasificadorEntidad) condiciones.get(ValorClasificadorEntidad.NICKNAME);
	    java.util.Date fecha = (java.util.Date) condiciones.get("FECHA");

	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM  veEsqBonifClasif "); 
	    textSQL.append(" WHERE  oid_esq_bonif = ? and oid_val_clasif_ent = ? and activo=1 and fec_desde<=? and fec_hasta>=? ");
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
	    querySelect.setInt(1, esquemaBonificacion.getOID());
	    querySelect.setInt(2, valorClasifEntidad.getOID());
	    querySelect.setDate(3, new Date(fecha.getTime()));
	    querySelect.setDate(4, new Date(fecha.getTime()));
	    return querySelect; 
	  
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_esq_bon_clasif oid, codigo,  descripcion ,activo ");
    textSQL.append(" from veEsqBonifClasif");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  }
  
  public static List getEsquemasBonifClasifProd(EsquemaBonificacion esquemaBonificacion,
          ISesion aSesion) throws BaseException {
    return (List) ObjetoLogico.getObjects(EsquemaBonificacionClasifProd.NICKNAME,
             DBEsquemaBonificacionClasifProd.SELECT_BY_ESQUEMA_BONIF,
             esquemaBonificacion,
             new ListObserver(),
             aSesion);
  }
  
  public static EsquemaBonificacionClasifProd getEsquemaClasifProdVig(EsquemaBonificacion esquemaBonificacion,
		  									  						   ValorClasificadorEntidad valClasifEnt,
		  									  						   java.util.Date fecha,
		  									  						   ISesion aSesion) throws BaseException {
	    HashTableDatos condiciones = new HashTableDatos();
	    condiciones.put(EsquemaBonificacion.NICKNAME,esquemaBonificacion);
	    condiciones.put(ValorClasificadorEntidad.NICKNAME,valClasifEnt);
	    condiciones.put("FECHA",fecha);
	    return (EsquemaBonificacionClasifProd) ObjetoLogico.getObjects(EsquemaBonificacionClasifProd.NICKNAME,
	             DBEsquemaBonificacionClasifProd.SELECT_BY_ESQ_BONIF_VAL_CLASIF_VIG,
	             condiciones,
	             new ObjetoObservado(),
	             aSesion);
	  
	  
  }
  
  
} 
