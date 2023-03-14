package com.srn.erp.excluidos.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.srn.erp.excluidos.bm.EstadoIndividuoPredio;
import com.srn.erp.excluidos.bm.IndividuoExcluido;
import com.srn.erp.excluidos.bm.PredioExcluido;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.ObjetoObservado;

public class DBEstadoIndividuoPredio extends DBObjetoPersistente {

  public static final String OID_EST_IND_PREDIO = "oid_est_ind_predio";
  public static final String OID_PREDIO = "oid_predio";
  public static final String OID_INDIVIDUO = "oid_individuo";
  public static final String OID_ESTADO = "oid_estado";
  public static final String OID_ESTADO_ANT = "oid_estado_ant";
  public static final String FEC_ESTADO = "fec_estado";
  public static final String FEC_HORA_ESTADO = "fec_hora_estado";
  public static final String FEC_ESTADO_ANT = "fec_estado_ant";
  public static final String FEC_HOR_ESTADO_ANT = "fec_hor_estado_ant";
  public static final String OID_NOVEDAD = "oid_novedad";
  public static final String ACTIVO = "activo";
  
  public static final int SELECT_BY_PREDIO_INDIVIDUO = 100;

  public DBEstadoIndividuoPredio() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_EST_IND_PREDIO = 1;
    final int OID_PREDIO = 2;
    final int OID_INDIVIDUO = 3;
    final int OID_ESTADO = 4;
    final int OID_ESTADO_ANT = 5;
    final int FEC_ESTADO = 6;
    final int FEC_HORA_ESTADO = 7;
    final int FEC_ESTADO_ANT = 8;
    final int FEC_HOR_ESTADO_ANT = 9;
    final int OID_NOVEDAD = 10;
    final int ACTIVO = 11;

    EstadoIndividuoPredio pers = (EstadoIndividuoPredio) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into excEstIndiPredio "+
                     " ( "+
                      "OID_EST_IND_PREDIO,"+
                      "OID_PREDIO,"+
                      "OID_INDIVIDUO,"+
                      "OID_ESTADO,"+
                      "OID_ESTADO_ANT,"+
                      "FEC_ESTADO,"+
                      "FEC_HORA_ESTADO,"+
                      "FEC_ESTADO_ANT,"+
                      "FEC_HOR_ESTADO_ANT,"+
                      "OID_NOVEDAD,"+
                      "ACTIVO)"+ 
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
    qInsert.setInt(OID_EST_IND_PREDIO,pers.getOID());
    qInsert.setInt(OID_PREDIO,pers.getPredio().getOID());
    qInsert.setInt(OID_INDIVIDUO,pers.getIndividuo().getOID());
    if (pers.getEstado()!=null) 
      qInsert.setInt(OID_ESTADO,pers.getEstado().getOID());
    else
      qInsert.setNull(OID_ESTADO,java.sql.Types.INTEGER);
    if (pers.getEstado_anterior()!=null) 
      qInsert.setInt(OID_ESTADO_ANT,pers.getEstado_anterior().getOID());
    else
      qInsert.setNull(OID_ESTADO_ANT,java.sql.Types.INTEGER);
    if (pers.getFec_estado()!=null) 
      qInsert.setDate(FEC_ESTADO,new java.sql.Date(pers.getFec_estado().getTime()));
    else
      qInsert.setNull(FEC_ESTADO,java.sql.Types.INTEGER);
    if (pers.getFec_hora_estado()!=null) 
      qInsert.setDate(FEC_HORA_ESTADO,new java.sql.Date(pers.getFec_hora_estado().getTime()));
    else
      qInsert.setNull(FEC_HORA_ESTADO,java.sql.Types.DATE);
    if (pers.getFec_estado_ant()!=null) 
      qInsert.setDate(FEC_ESTADO_ANT,new java.sql.Date(pers.getFec_estado_ant().getTime()));
    else
      qInsert.setNull(FEC_ESTADO_ANT,java.sql.Types.DATE);
    if (pers.getFec_hor_estado_ant()!=null) 
      qInsert.setDate(FEC_HOR_ESTADO_ANT,new java.sql.Date(pers.getFec_hor_estado_ant().getTime()));
    else
      qInsert.setNull(FEC_HOR_ESTADO_ANT,java.sql.Types.DATE);
    if (pers.getNovedad()!=null) 
      qInsert.setInt(OID_NOVEDAD,pers.getNovedad().getOID());
    else
      qInsert.setNull(OID_NOVEDAD,java.sql.Types.INTEGER);
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_PREDIO = 1;
    final int OID_INDIVIDUO = 2;
    final int OID_ESTADO = 3;
    final int OID_ESTADO_ANT = 4;
    final int FEC_ESTADO = 5;
    final int FEC_HORA_ESTADO = 6;
    final int FEC_ESTADO_ANT = 7;
    final int FEC_HOR_ESTADO_ANT = 8;
    final int OID_NOVEDAD = 9;
    final int ACTIVO = 10;
    final int OID_EST_IND_PREDIO = 11;

    EstadoIndividuoPredio pers = (EstadoIndividuoPredio) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update excEstIndiPredio set "+
              "oid_predio=?"+ 
              ",oid_individuo=?"+ 
              ",oid_estado=?"+ 
              ",oid_estado_ant=?"+ 
              ",fec_estado=?"+ 
              ",fec_hora_estado=?"+ 
              ",fec_estado_ant=?"+ 
              ",fec_hor_estado_ant=?"+ 
              ",oid_novedad=?"+ 
              ",activo=?"+ 
                 " where " +
                 " oid_est_ind_predio=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_EST_IND_PREDIO,pers.getOID());
    qUpdate.setInt(OID_PREDIO,pers.getPredio().getOID());
    qUpdate.setInt(OID_INDIVIDUO,pers.getIndividuo().getOID());
    if (pers.getEstado()!=null) 
      qUpdate.setInt(OID_ESTADO,pers.getEstado().getOID());
    else
      qUpdate.setNull(OID_ESTADO,java.sql.Types.INTEGER);
    if (pers.getEstado_anterior()!=null) 
      qUpdate.setInt(OID_ESTADO_ANT,pers.getEstado_anterior().getOID());
    else
      qUpdate.setNull(OID_ESTADO_ANT,java.sql.Types.INTEGER);
    if (pers.getFec_estado()!=null) 
      qUpdate.setDate(FEC_ESTADO,new java.sql.Date(pers.getFec_estado().getTime()));
    else
      qUpdate.setNull(FEC_ESTADO,java.sql.Types.DATE);
    if (pers.getFec_hora_estado()!=null) 
      qUpdate.setDate(FEC_HORA_ESTADO,new java.sql.Date(pers.getFec_hora_estado().getTime()));
    else
      qUpdate.setNull(FEC_HORA_ESTADO,java.sql.Types.DATE);
    if (pers.getFec_estado_ant()!=null) 
      qUpdate.setDate(FEC_ESTADO_ANT,new java.sql.Date(pers.getFec_estado_ant().getTime()));
    else
      qUpdate.setNull(FEC_ESTADO_ANT,java.sql.Types.INTEGER);
    if (pers.getFec_hor_estado_ant()!=null) 
      qUpdate.setDate(FEC_HOR_ESTADO_ANT,new java.sql.Date(pers.getFec_hor_estado_ant().getTime()));
    else
      qUpdate.setNull(FEC_HOR_ESTADO_ANT,java.sql.Types.DATE);
    if (pers.getNovedad()!=null) 
      qUpdate.setInt(OID_NOVEDAD,pers.getNovedad().getOID());
    else
      qUpdate.setNull(OID_NOVEDAD,java.sql.Types.INTEGER);
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_EST_IND_PREDIO = 1; 
    EstadoIndividuoPredio pers = (EstadoIndividuoPredio) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update excEstIndiPredio "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_est_ind_predio=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_EST_IND_PREDIO, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_EST_IND_PREDIO = 1; 
    EstadoIndividuoPredio pers = (EstadoIndividuoPredio) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update excEstIndiPredio "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_est_ind_predio=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_EST_IND_PREDIO, pers.getOID()); 
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
      case SELECT_BY_PREDIO_INDIVIDUO: {
          ps = this.selectByPredioIndividuo(aCondiciones); 
          break;    	  
      }
    } 
    return ps;
  } 

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_EST_IND_PREDIO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  excEstIndiPredio "); 
    textSQL.append(" WHERE oid_est_ind_predio = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_EST_IND_PREDIO, oid); 
    return querySelect; 
  }
  
  
  private PreparedStatement selectByPredioIndividuo(Object aCondiciones) throws BaseException, SQLException { 

	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM  excEstIndiPredio "); 
	    textSQL.append(" WHERE oid_predio = ? and oid_individuo = =  ");
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
	    
	    HashTableDatos condiciones = (HashTableDatos) aCondiciones;
	    PredioExcluido predio = (PredioExcluido) condiciones.get(PredioExcluido.NICKNAME);
	    IndividuoExcluido individuo = (IndividuoExcluido) condiciones.get(IndividuoExcluido.NICKNAME);
	    querySelect.setInt(1, predio.getOID());
	    querySelect.setInt(2, individuo.getOID()); 
	    return querySelect; 
  }  
  
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  excEstIndiPredio "); 
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_est_ind_predio oid, codigo,  descripcion ,activo ");
    textSQL.append(" from excEstIndiPredio");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  }
  

  public static EstadoIndividuoPredio getEstadoIndividuoPredio(
		  PredioExcluido predio,
		  IndividuoExcluido individuo,
          ISesion aSesion)
          throws BaseException {
	  HashTableDatos condiciones = new HashTableDatos();
	  condiciones.put(PredioExcluido.NICKNAME, predio);
	  condiciones.put(IndividuoExcluido.NICKNAME, individuo);
	  
	  return (EstadoIndividuoPredio) ObjetoLogico.getObjects(EstadoIndividuoPredio.NICKNAME,
			  				DBEstadoIndividuoPredio.SELECT_BY_PREDIO_INDIVIDUO,
			  				condiciones,
			  				new ObjetoObservado(),
			  				aSesion);
  }  
  
} 
