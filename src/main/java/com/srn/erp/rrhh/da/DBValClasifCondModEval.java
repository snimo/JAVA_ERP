package com.srn.erp.rrhh.da;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.general.bm.ClasificadorEntidad;
import com.srn.erp.general.bm.ValorClasificadorEntidad;
import com.srn.erp.rrhh.bm.CondModEvalCab;
import com.srn.erp.rrhh.bm.ValClasifCondModEval;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.ObjetoObservado;

public class DBValClasifCondModEval extends DBObjetoPersistente {

  public static final String OID_VAL_CLASIF_COND = "oid_val_clasif_cond";
  public static final String OID_CLASIFICADOR = "oid_clasificador";
  public static final String OID_VAL_CLASIF = "oid_val_clasif";
  public static final String OID_COND_MOD = "oid_cond_mod";
  public static final String ACTIVO = "activo";
  
  public static final int SELECT_BY_CONDICION = 100;
  public static final int SELECT_BY_COND_CLASIF_VALOR = 101;

  public DBValClasifCondModEval() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_VAL_CLASIF_COND = 1;
    final int OID_CLASIFICADOR = 2;
    final int OID_VAL_CLASIF = 3;
    final int OID_COND_MOD = 4;
    final int ACTIVO = 5;

    ValClasifCondModEval pers = (ValClasifCondModEval) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into rhValClasifCondMod "+
                     " ( "+
                      "OID_VAL_CLASIF_COND,"+
                      "OID_CLASIFICADOR,"+
                      "OID_VAL_CLASIF,"+
                      "OID_COND_MOD,"+
                      "ACTIVO)"+ 
                      " values "+ 
                      "("+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_VAL_CLASIF_COND,pers.getOID());
    qInsert.setInt(OID_CLASIFICADOR,pers.getClasificador().getOID());
    qInsert.setInt(OID_VAL_CLASIF,pers.getValor_clasificador().getOID());
    qInsert.setInt(OID_COND_MOD,pers.getCondicion_modelo().getOID());
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_CLASIFICADOR = 1;
    final int OID_VAL_CLASIF = 2;
    final int OID_COND_MOD = 3;
    final int ACTIVO = 4;
    final int OID_VAL_CLASIF_COND = 5;

    ValClasifCondModEval pers = (ValClasifCondModEval) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update rhValClasifCondMod set "+
              "oid_clasificador=?"+ 
              ",oid_val_clasif=?"+ 
              ",oid_cond_mod=?"+ 
              ",activo=?"+ 
                 " where " +
                 " oid_val_clasif_cond=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_VAL_CLASIF_COND,pers.getOID());
    qUpdate.setInt(OID_CLASIFICADOR,pers.getClasificador().getOID());
    qUpdate.setInt(OID_VAL_CLASIF,pers.getValor_clasificador().getOID());
    qUpdate.setInt(OID_COND_MOD,pers.getCondicion_modelo().getOID());
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_VAL_CLASIF_COND = 1; 
    ValClasifCondModEval pers = (ValClasifCondModEval) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update rhValClasifCondMod "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_val_clasif_cond=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_VAL_CLASIF_COND, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_VAL_CLASIF_COND = 1; 
    ValClasifCondModEval pers = (ValClasifCondModEval) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update rhValClasifCondMod "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_val_clasif_cond=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_VAL_CLASIF_COND, pers.getOID()); 
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
      case SELECT_BY_CONDICION: {
        ps = this.selectByCondicion(aCondiciones); 
        break; 
      }
      case SELECT_BY_COND_CLASIF_VALOR: {
          ps = this.selectByCondClasifValor(aCondiciones); 
          break; 
      }
    } 
    return ps;
  } 

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_VAL_CLASIF_COND = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  rhValClasifCondMod "); 
    textSQL.append(" WHERE oid_val_clasif_cond = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_VAL_CLASIF_COND, oid); 
    return querySelect; 
  }
  
  private PreparedStatement selectByCondClasifValor(Object aCondiciones) throws BaseException, SQLException {
	    HashTableDatos condiciones = (HashTableDatos) aCondiciones;
	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM  rhValClasifCondMod "); 
	    textSQL.append(" where oid_cond_mod=? and activo=1 and oid_clasificador = ? and oid_val_clasif = ? ");
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
	    CondModEvalCab condModEvalCab = (CondModEvalCab) condiciones.get(CondModEvalCab.NICKNAME);
	    ClasificadorEntidad clasificador = (ClasificadorEntidad) condiciones.get(ClasificadorEntidad.NICKNAME);
	    ValorClasificadorEntidad valorClasif = (ValorClasificadorEntidad) condiciones.get(ValorClasificadorEntidad.NICKNAME);
	    querySelect.setInt(1, condModEvalCab.getOID()); 
	    querySelect.setInt(2, clasificador.getOID());
	    querySelect.setInt(3, valorClasif.getOID());
	    return querySelect; 
	  
  }

  private PreparedStatement selectByCondicion(Object aCondiciones) throws BaseException, SQLException { 
	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM  rhValClasifCondMod "); 
	    textSQL.append(" where oid_cond_mod=? and activo=1 ");
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
	    CondModEvalCab condModEvalCab = (CondModEvalCab) aCondiciones;
	    querySelect.setInt(1, condModEvalCab.getOID()); 
	    return querySelect; 
  }
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  rhValClasifCondMod "); 
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_val_clasif_cond oid, codigo,  descripcion ,activo ");
    textSQL.append(" from rhValClasifCondMod");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  }
  
  public static ValClasifCondModEval getValorClasificador(
		  CondModEvalCab CondModEvalCab,
		  ClasificadorEntidad clasificador,
		  ValorClasificadorEntidad valorClasifEnt,
          ISesion aSesion)
          throws BaseException {
	  HashTableDatos condiciones = new HashTableDatos();
	  condiciones.put(CondModEvalCab.NICKNAME, CondModEvalCab);
	  condiciones.put(ClasificadorEntidad.NICKNAME, clasificador);
	  condiciones.put(ValorClasificadorEntidad.NICKNAME, valorClasifEnt);
	  return (ValClasifCondModEval) ObjetoLogico.getObjects(ValClasifCondModEval.NICKNAME,
			  				DBValClasifCondModEval.SELECT_BY_COND_CLASIF_VALOR,
			  				condiciones,
			  				new ObjetoObservado(),
			  				aSesion);
  }
  
  public static List getValoresClasifByCondicion(CondModEvalCab condModEvalCab,
          ISesion aSesion) throws BaseException {
	  return (List) ObjetoLogico.getObjects(ValClasifCondModEval.NICKNAME,
             DBValClasifCondModEval.SELECT_BY_CONDICION,
             condModEvalCab,
             new ListObserver(),
             aSesion);
  }
  
	public static int getCantValoresClasif(Object aCondiciones, ISesion aSesion) throws BaseException {

		try {
			
			HashTableDatos condiciones = (HashTableDatos) aCondiciones;
			
			CondModEvalCab condModEvalCab = (CondModEvalCab) condiciones.get(CondModEvalCab.NICKNAME);
			ClasificadorEntidad clasificador = (ClasificadorEntidad) condiciones.get(ClasificadorEntidad.NICKNAME);
			
			StringBuffer textSQL = new StringBuffer();

			textSQL.append("SELECT count(*) cantidad ");
			textSQL.append(" from rhValClasifCondMod where  activo = 1 and oid_cond_mod = ? and oid_clasificador = ? ");

			PreparedStatement querySelect = aSesion.getConexionBD().prepareStatement(textSQL.toString());

			querySelect.setInt(1, condModEvalCab.getOID());
			querySelect.setInt(2, clasificador.getOID());
			
			ResultSet rs = querySelect.executeQuery();
			int cant = 0;
			if (rs.next())
				cant = rs.getInt(1);
			rs.close();
			querySelect.close();

			return cant;
		}
		catch (Exception e) {
			throw new BaseException(null, e.getMessage());
		}
	}
  
  
  
  
} 
