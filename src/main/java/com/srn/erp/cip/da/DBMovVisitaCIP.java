package com.srn.erp.cip.da;

import java.sql.*;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.cip.bm.*;
import com.srn.erp.general.bm.ClasificadorEntidad;
import com.srn.erp.general.bm.ValorClasificadorEntidad;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.*;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.*;

public class DBMovVisitaCIP extends DBObjetoPersistente {

  public static final String OID_MOVI_VISITA = "oid_movi_visita";
  public static final String OID_VISITA = "oid_visita";
  public static final String OID_PUERTA = "oid_puerta";
  public static final String FECHA = "fecha";
  public static final String HORA = "hora";
  public static final String HORA_EN_MIN = "hora_en_min";
  public static final String SENTIDO = "sentido";
  public static final String FEC_HOR = "fec_hor";
  public static final String OID_ZONA_ORIGEN = "oid_zona_origen";
  public static final String OID_ZONA_DESTINO = "oid_zona_destino";
  public static final String OID_VISITA_A = "oid_visita_a";
  public static final String OID_AUTORIZO = "oid_autorizo";
  public static final String ACTIVO = "activo";
  public static final String OID_TARJETA = "oid_tarjeta";
  
  public static final int SELECT_BY_CONDICIONES = 100;

  public DBMovVisitaCIP() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_MOVI_VISITA = 1;
    final int OID_VISITA = 2;
    final int OID_PUERTA = 3;
    final int FECHA = 4;
    final int HORA = 5;
    final int HORA_EN_MIN = 6;
    final int SENTIDO = 7;
    final int FEC_HOR = 8;
    final int OID_ZONA_ORIGEN = 9;
    final int OID_ZONA_DESTINO = 10;
    final int OID_VISITA_A = 11;
    final int OID_AUTORIZO = 12;
    final int ACTIVO = 13;
    final int OID_TARJETA = 14;

    MovVisitaCIP pers = (MovVisitaCIP) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into cipMoviVisita "+
                     " ( "+
                      "OID_MOVI_VISITA,"+
                      "OID_VISITA,"+
                      "OID_PUERTA,"+
                      "FECHA,"+
                      "HORA,"+
                      "HORA_EN_MIN,"+
                      "SENTIDO,"+
                      "FEC_HOR,"+
                      "OID_ZONA_ORIGEN,"+
                      "OID_ZONA_DESTINO,"+
                      "OID_VISITA_A,"+
                      "OID_AUTORIZO,"+
                      "ACTIVO , OID_TARJETA)"+ 
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
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_MOVI_VISITA,pers.getOID());
    qInsert.setInt(OID_VISITA,pers.getVisita().getOID());
    qInsert.setInt(OID_PUERTA,pers.getPuerta().getOID());
    qInsert.setDate(FECHA,new java.sql.Date(pers.getFecha().getTime()));
    qInsert.setString(HORA,pers.getHora());
    qInsert.setInt(HORA_EN_MIN,pers.getHora_en_min().intValue());
    qInsert.setString(SENTIDO,pers.getSentido());
    qInsert.setTimestamp(FEC_HOR, new java.sql.Timestamp(pers.getFec_hor().getTime()));
    if (pers.getZona_origen()!=null) 
      qInsert.setInt(OID_ZONA_ORIGEN,pers.getZona_origen().getOID());
    else
      qInsert.setNull(OID_ZONA_ORIGEN,java.sql.Types.INTEGER);
    if (pers.getZona_destino()!=null) 
      qInsert.setInt(OID_ZONA_DESTINO,pers.getZona_destino().getOID());
    else
      qInsert.setNull(OID_ZONA_DESTINO,java.sql.Types.INTEGER);
    if (pers.getVisita_a()!=null) 
      qInsert.setInt(OID_VISITA_A,pers.getVisita_a().getOID());
    else
      qInsert.setNull(OID_VISITA_A,java.sql.Types.INTEGER);
    if (pers.getAutorizo()!=null) 
      qInsert.setInt(OID_AUTORIZO,pers.getAutorizo().getOID());
    else
      qInsert.setNull(OID_AUTORIZO,java.sql.Types.INTEGER);
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    if (pers.getTarjeta()!=null)
    	qInsert.setInt(OID_TARJETA, pers.getTarjeta().getOID());
    else
    	qInsert.setNull(OID_TARJETA, Types.INTEGER);
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_VISITA = 1;
    final int OID_PUERTA = 2;
    final int FECHA = 3;
    final int HORA = 4;
    final int HORA_EN_MIN = 5;
    final int SENTIDO = 6;
    final int FEC_HOR = 7;
    final int OID_ZONA_ORIGEN = 8;
    final int OID_ZONA_DESTINO = 9;
    final int OID_VISITA_A = 10;
    final int OID_AUTORIZO = 11;
    final int ACTIVO = 12;
    final int OID_TARJETA = 13;
    final int OID_MOVI_VISITA = 14;

    MovVisitaCIP pers = (MovVisitaCIP) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update cipMoviVisita set "+
              "oid_visita=?"+ 
              ",oid_puerta=?"+ 
              ",fecha=?"+ 
              ",hora=?"+ 
              ",hora_en_min=?"+ 
              ",sentido=?"+ 
              ",fec_hor=?"+ 
              ",oid_zona_origen=?"+ 
              ",oid_zona_destino=?"+ 
              ",oid_visita_a=?"+ 
              ",oid_autorizo=?"+ 
              ",activo=?"+ 
              ",oid_tarjeta=?"+
                 " where " +
                 " oid_movi_visita=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_MOVI_VISITA,pers.getOID());
    qUpdate.setInt(OID_VISITA,pers.getVisita().getOID());
    qUpdate.setInt(OID_PUERTA,pers.getPuerta().getOID());
    qUpdate.setDate(FECHA,new java.sql.Date(pers.getFecha().getTime()));
    qUpdate.setString(HORA,pers.getHora());
    qUpdate.setInt(HORA_EN_MIN,pers.getHora_en_min().intValue());
    qUpdate.setString(SENTIDO,pers.getSentido());
    qUpdate.setTimestamp(FEC_HOR, new java.sql.Timestamp(pers.getFec_hor().getTime()));
    if (pers.getZona_origen()!=null) 
      qUpdate.setInt(OID_ZONA_ORIGEN,pers.getZona_origen().getOID());
    else
      qUpdate.setNull(OID_ZONA_ORIGEN,java.sql.Types.INTEGER);
    if (pers.getZona_destino()!=null) 
      qUpdate.setInt(OID_ZONA_DESTINO,pers.getZona_destino().getOID());
    else
      qUpdate.setNull(OID_ZONA_DESTINO,java.sql.Types.INTEGER);
    if (pers.getVisita_a()!=null) 
      qUpdate.setInt(OID_VISITA_A,pers.getVisita_a().getOID());
    else
      qUpdate.setNull(OID_VISITA_A,java.sql.Types.INTEGER);
    if (pers.getAutorizo()!=null) 
      qUpdate.setInt(OID_AUTORIZO,pers.getAutorizo().getOID());
    else
      qUpdate.setNull(OID_AUTORIZO,java.sql.Types.INTEGER);
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    if (pers.getTarjeta()!=null)
    	qUpdate.setInt(OID_TARJETA, pers.getTarjeta().getOID());
    else
    	qUpdate.setNull(OID_TARJETA, Types.INTEGER);
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_MOVI_VISITA = 1; 
    MovVisitaCIP pers = (MovVisitaCIP) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update cipMoviVisita "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_movi_visita=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_MOVI_VISITA, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_MOVI_VISITA = 1; 
    MovVisitaCIP pers = (MovVisitaCIP) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update cipMoviVisita "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_movi_visita=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_MOVI_VISITA, pers.getOID()); 
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
  
	private PreparedStatement selectByCondiciones(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT a.* FROM  cipMoviVisita a, cipVisita b WHERE a.oid_visita=b.oid_visita and a.fecha>=? and a.fecha<=? ");
		
		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		List visitas = (List) condiciones.get("LISTA_VISITAS");
		StringBuffer condOIDVisita = new StringBuffer("");
		if ((visitas != null) && (visitas.size() > 0)) {
			Iterator iterVisitas = visitas.iterator();
			while (iterVisitas.hasNext()) {
				Integer oidVisita = (Integer) iterVisitas.next();
				if (condOIDVisita.length() == 0)
					condOIDVisita.append(oidVisita.toString());
				else
					condOIDVisita.append("," + oidVisita.toString());
			}
			textSQL.append(" and a.oid_visita in (" + condOIDVisita.toString() + ") ");
		}
		
		
		// Filtrar por Valores de clasificador
		HashTableDatos hashTableClasif = new HashTableDatos();
		List listaValClasif = (List) condiciones.get("LISTA_VAL_CLASIF");
		if (listaValClasif != null) {

			Iterator iterValClasif = listaValClasif.iterator();
			while (iterValClasif.hasNext()) {
				ValorClasificadorEntidad valClasifEnt = (ValorClasificadorEntidad) iterValClasif.next();
				HashTableDatos htValClasif = (HashTableDatos) hashTableClasif.get(valClasifEnt.getClasificador_entidad().getOIDInteger());
				if (htValClasif == null) {
					htValClasif = new HashTableDatos();
					hashTableClasif.put(valClasifEnt.getClasificador_entidad().getOIDInteger(), htValClasif);
				}
				htValClasif.put(valClasifEnt.getOIDInteger(), valClasifEnt);
			}

			Iterator iterGrupoValClasif = hashTableClasif.values().iterator();
			while (iterGrupoValClasif.hasNext()) {
				HashTableDatos datos = (HashTableDatos) iterGrupoValClasif.next();
				Iterator iterValClasif1 = datos.values().iterator();
				int j = 1;
				while (iterValClasif1.hasNext()) {
					ValorClasificadorEntidad valClasifEnt = (ValorClasificadorEntidad) iterValClasif1.next();
					if (j == 1)
						textSQL.append(" and (");
					else
						textSQL.append(" or ");
					textSQL.append("b."+valClasifEnt.getClasificador_entidad().getCampoFisico() + "=" + valClasifEnt.getOIDInteger());
					++j;

				}
				if (j > 1)
					textSQL.append(" ) ");
			}

		}
		
		
		
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		
		
		java.util.Date fecDesde = (java.util.Date) condiciones.get("FEC_DESDE");
		java.util.Date fecHasta = (java.util.Date) condiciones.get("FEC_HASTA");
		
		querySelect.setDate(1, new java.sql.Date(fecDesde.getTime()));
		querySelect.setDate(2, new java.sql.Date(fecHasta.getTime()));
		
		
		
		
		return querySelect;
	}
  

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_MOVI_VISITA = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  cipMoviVisita "); 
    textSQL.append(" WHERE oid_movi_visita = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_MOVI_VISITA, oid); 
    return querySelect; 
  }
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  cipMoviVisita "); 
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_movi_visita oid, codigo,  descripcion ,activo ");
    textSQL.append(" from cipMoviVisita");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  }
  
	public static List getMovimientosCIP(
			java.util.Date fecDesde, 
			java.util.Date fecHasta, 
			ClasificadorEntidad titulo, 
			List listaVisitas,
			List listaValoresClasif, 
			ISesion aSesion) throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put("FEC_DESDE", fecDesde);
		condiciones.put("FEC_HASTA", fecHasta);
		if (titulo!=null)
			condiciones.put(ClasificadorEntidad.NICKNAME, titulo);
		condiciones.put("LISTA_VISITAS", listaVisitas);
		condiciones.put("LISTA_VAL_CLASIF", listaValoresClasif);

		return (List) ObjetoLogico.getObjects(
				MovVisitaCIP.NICKNAME, 
				DBMovVisitaCIP.SELECT_BY_CONDICIONES, 
				condiciones,
				new ListObserver(), 
				aSesion);
	}
  
  
} 
