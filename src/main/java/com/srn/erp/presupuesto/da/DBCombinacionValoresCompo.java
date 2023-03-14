package com.srn.erp.presupuesto.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.presupuesto.bm.CombinacionValoresCompo;
import com.srn.erp.presupuesto.bm.CompoPresupuestario;
import com.srn.erp.presupuesto.bm.ValorCompoPresu;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;

public class DBCombinacionValoresCompo extends DBObjetoPersistente {
	
	public static final int SELECT_BY_COMBINACION_COMPO = 100;


  public DBCombinacionValoresCompo() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
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
      case SELECT_BY_COMBINACION_COMPO: {
        ps = this.selectByCombinacionComponentes(aCondiciones); 
        break; 
      }
    } 
    return ps;
  } 

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 
    return null; 
  }
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 
    return null; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {
    return null; 
  }
  
  public static String getAliasFieldByNroIntCompo(Integer aNroInternoCompo) {
  	return "alias_"+aNroInternoCompo.toString();
  }
  
  public PreparedStatement selectByCombinacionComponentes(Object aCondiciones) throws BaseException, SQLException {
  	
  	HashTableDatos hashCompo = (HashTableDatos) aCondiciones;
  	
    StringBuffer textSQL = new StringBuffer();
    StringBuffer textFields =  new StringBuffer(); 
    StringBuffer textFrom =  new StringBuffer();
    StringBuffer textWhere =  new StringBuffer();
    
    
  	Iterator iterComponentes = hashCompo.keySet().iterator();
  	while (iterComponentes.hasNext()) {
  		Integer nroInternoCompo = (Integer) iterComponentes.next();
  		CompoPresupuestario compoPresu = (CompoPresupuestario) hashCompo.get(nroInternoCompo);
  		String aliasTabla = getAliasFieldByNroIntCompo(nroInternoCompo);
  		
  		if (textFields.length()>0)
  			textFields.append(",");
  		textFields.append(" "+
  				              aliasTabla+"."+
  				              ValorCompoPresu.getNombreCampoOidValorCompo()+" "+
  									    "oid_val_compo_"+nroInternoCompo.toString()+" ");
  		
  		if (textFrom.length()>0)
  			textFrom.append(",");
  		textFrom.append(ValorCompoPresu.getNombreTablaValorCompo()+" "+aliasTabla+" ");
  		
  		if (textWhere.length()>0)
  			textWhere.append(" and ");
  		textWhere.append(" "+aliasTabla+"."+ValorCompoPresu.getNombreCampoOidCompoPresu()+"="+compoPresu.getOIDInteger());
  	
  	}
  	
  	textSQL.append("select  ");
  	textSQL.append(textFields.toString());
  	textSQL.append(" from ");
  	textSQL.append(textFrom.toString());
  	textSQL.append(" where ");
  	textSQL.append(textWhere.toString());
  	
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    return querySelect;
  }
  
  public static List getCombinacionesValCompo(HashTableDatos hashComponentes,
      ISesion aSesion) throws BaseException {
  	return (List) ObjetoLogico.getObjects(CombinacionValoresCompo.NICKNAME,
       DBCombinacionValoresCompo.SELECT_BY_COMBINACION_COMPO,
       hashComponentes,
       new ListObserver(),
       aSesion);
  }
  
  
} 
