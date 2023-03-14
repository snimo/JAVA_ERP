package com.srn.erp.cip.bm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;

import com.srn.erp.general.bm.ClasificadorEntidad;

import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.Fecha;
import framework.applicarionServer.bm.Parametros.ValorParametro;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;
import framework.request.bl.Utils.HashTableDatos;

public class HipoImpotacionManager {
	
	static boolean driverInicializado = false;
	
	ISesion sesion;
	//com.microsoft.sqlserver.jdbc.SQLServerXADataSource dataSource = new com.microsoft.sqlserver.jdbc.SQLServerXADataSource();
	java.util.Date fechaActual = null;
	java.util.Date fecDesde = null;
	java.util.Date fecHasta = null;
	
	public HipoImpotacionManager() {
		HipoImpotacionManager.inicializar();
	}
	
	public static void inicializar() {
		try {
			if (!driverInicializado)
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			driverInicializado = true;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	private ISesion getSesion() throws BaseException {
		return sesion;
	}
	
	public void setSesion(ISesion aSesion) {
		this.sesion = aSesion;
	}
	
	public void actualizarNovedadesCIP(String legajo) throws BaseException {
		actualizarEstados();
		actualizarValClasif();
		actualizarLegajos(legajo);
		actualizarNrosTarjetas(legajo);
		actualizarRotas();
		actualizarPlanifRotas(legajo);
		actualizarNovedades(legajo);
	}
	
	public void actualizarNovedadesLegajo(String legajo) throws BaseException {
		actualizarEstados();
		actualizarValClasif();
		actualizarLegajos(legajo);
		actualizarNrosTarjetas(legajo);
	}
	
	public void actualizarNovedadesPlanifRotas(String legajo, boolean actuRotas) throws BaseException {
		if (actuRotas)
			actualizarRotas();
		actualizarPlanifRotas(legajo);
		actualizarNovedades(legajo);
	}
	
	
	
	public void actualizarPlanifRotas(String legajo) throws BaseException {
	
		
		 String condicion = "";
		 if (legajo!=null) {
			 condicion = " oid_legajo in (select oid_legajo from suLegajo where nro_legajo='"+legajo.trim()+"') and ";
		 }
		 
		 if (fechaActual==null)
			 fechaActual = Fecha.getFechaTruncada(UtilCIP.getFechaHoraActual(this.getSesion()));
		 if (fecDesde==null)
			 fecDesde = Fecha.getFechaDiaAnterior(fechaActual);
		 if (fecHasta==null)
			 fecHasta = Fecha.getFechaMasDias(fechaActual, 140);
		 
		
		 PreparedStatement querySelect = null;
		 String query = 
			 " INSERT INTO cipLegRotFec "+ 
			 " (OID_LEG_ROT_FEC, "+
			 "  FECHA, "+ 
			 "  OID_LEGAJO, "+
			 "  OID_ROTA, "+
			 "  ACTIVO) "+ 
			 " SELECT SEQ_DBLEGAJOROTAFECHA.NEXTVAL+(2000000),ETRFECHA,OID_LEGAJO,OID_ROTA,1 FROM "+    
			 " ( "+   
			 "   select "+ 
			 "     a.etrfecha , b.oid_legajo,c.oid_rota "+  
			 "   from "+ 
			 "     paylegrotfec a , "+ 
			 "     suLegajo b , "+ 
			 "     cipRotas c "+ 
			 " where "+  
			 "     a.etrlegajo = b.nro_legajo and "+
			 "     c.codigo = a.etrtramo "+
			 " minus "+
			 "   select fecha,oid_legajo,oid_rota from cipLegRotFec "+ 
			 " where "+condicion+" fecha>=? and  fecha<=?) PLANIF_NUEVAS ";
			 
		 
		 try {
			 
			 querySelect = this.getSesion().getConexionBD().prepareStatement(query);
			 querySelect.setDate(1, new java.sql.Date(fecDesde.getTime()));
			 querySelect.setDate(2, new java.sql.Date(fecHasta.getTime()));
			 querySelect.executeUpdate();
			 querySelect.close();
			 this.getSesion().getConexionBD().commit();
			 
		 
		 } catch (SQLException e) {
				// TODO Auto-generated catch block
				throw new ExceptionValidation(null,"Erro al actualizar PLANIF ROTAS: "+e.getMessage()); 
		}
		 
		 querySelect = null;
		 
		 condicion = "";
		 if (legajo!=null) {
			 condicion = " a.oid_legajo in (select oid_legajo from suLegajo where nro_legajo='"+legajo.trim()+"') and ";
		 }
		 
		 
		 
		//query = 
		//	" UPDATE  /*+BYPASS_UJVC*/ ( "+ 
		//	"	    SELECT "+ 
		//	"	          a.activo AS old_activo, "+ 
		//	"	          1 AS new_activo "+ 
		//	"	    FROM cipLegRotFec a "+ 
		//	"	          INNER JOIN "+ 
		//	"					 ( select "+ 
		//	"	            a1.etrfecha , b1.oid_legajo,c1.oid_rota "+  
		//	"	           from "+  
		//	"	              paylegrotfec a1 , "+ 
		//	"	              suLegajo b1 , "+ 
		//	"	              cipRotas c1 "+ 
		//	"	           where "+  
		//	"	              a1.etrlegajo = b1.nro_legajo and "+
		//	"	              c1.codigo = a1.etrtramo) Planif "+  
		//	"	    ON "+condicion+" a.fecha = planif.etrfecha and a.oid_legajo = planif.oid_legajo and a.oid_rota = planif.oid_rota and a.activo = 0 "+
		//	"	    ) "+
		//	"	    set old_activo=new_activo ";
		 
		 
			query = 
				" UPDATE cipLegRotFec SET activo=1 where OID_LEG_ROT_FEC in ( "+ 
				"	    SELECT "+ 
				"	          a.OID_LEG_ROT_FEC "+ 
				"	    FROM cipLegRotFec a "+ 
				"	          INNER JOIN "+ 
				"					 ( select "+ 
				"	            a1.etrfecha , b1.oid_legajo,c1.oid_rota "+  
				"	           from "+  
				"	              paylegrotfec a1 , "+ 
				"	              suLegajo b1 , "+ 
				"	              cipRotas c1 "+ 
				"	           where "+  
				"	              a1.etrlegajo = b1.nro_legajo and "+
				"	              c1.codigo = a1.etrtramo) Planif "+  
				"	    ON "+condicion+" a.fecha = planif.etrfecha and a.oid_legajo = planif.oid_legajo and a.oid_rota = planif.oid_rota and a.activo = 0 "+
				"	    ) ";
		 
			
		 try {
			 
			 querySelect = this.getSesion().getConexionBD().prepareStatement(query);
			 querySelect.executeUpdate(); 
			 querySelect.close();
			 this.getSesion().getConexionBD().commit();
			 
		 
		 } catch (SQLException e) {
				// TODO Auto-generated catch block
				throw new ExceptionValidation(null,"Erro al actualizar PLANIF ROTAS: "+e.getMessage()); 
		 }
		 
		 querySelect = null;
		 
		 
		 condicion = "";
		 if (legajo!=null) {
			 condicion = " oid_legajo in (select oid_legajo from suLegajo where nro_legajo='"+legajo.trim()+"') and ";
		 }
		 
		 
			//query = 
			//	"UPDATE  /*+BYPASS_UJVC*/ ( "+ 
			//	"	    SELECT "+ 
			//	"	          a.activo AS old_activo, "+ 
			//	"	          0 AS new_activo "+ 
			//	"	    FROM cipLegRotFec a "+ 
			//	"	          INNER JOIN "+ 
			//	"					 ( select fecha,oid_legajo,oid_rota from cipLegRotFec "+ 
			//	"	              where "+condicion+" fecha>=? and  fecha<=? "+
			//	"	          minus "+
			//	"	              select "+ 
			//	"	                a.etrfecha , b.oid_legajo,c.oid_rota "+  
			//	"	              from "+ 
			//	"	                paylegrotfec a , "+ 
			//	"	                suLegajo b , "+ 
			//	"	                cipRotas c "+ 
			//	"	              where "+  
			//	"	                a.etrlegajo = b.nro_legajo and "+
			//	"	                c.codigo = a.etrtramo) PlanifBorrar "+  
			//	"	    ON a.fecha = PlanifBorrar.fecha and a.oid_legajo = PlanifBorrar.oid_legajo and a.oid_rota = PlanifBorrar.oid_rota and a.activo = 1 "+
			//	"	    ) "+
			//	"	    set old_activo=new_activo ";
			
			query = 
				"UPDATE cipLegRotFec SET activo=0 where OID_LEG_ROT_FEC in ("+ 
				"	    SELECT "+
				"	          a.OID_LEG_ROT_FEC "+				
				"	    FROM cipLegRotFec a "+ 
				"	          INNER JOIN "+ 
				"					 ( select fecha,oid_legajo,oid_rota from cipLegRotFec "+ 
				"	              where "+condicion+" fecha>=? and  fecha<=? "+
				"	          minus "+
				"	              select "+ 
				"	                a.etrfecha , b.oid_legajo,c.oid_rota "+  
				"	              from "+ 
				"	                paylegrotfec a , "+ 
				"	                suLegajo b , "+ 
				"	                cipRotas c "+ 
				"	              where "+  
				"	                a.etrlegajo = b.nro_legajo and "+
				"	                c.codigo = a.etrtramo) PlanifBorrar "+  
				"	    ON a.fecha = PlanifBorrar.fecha and a.oid_legajo = PlanifBorrar.oid_legajo and a.oid_rota = PlanifBorrar.oid_rota and a.activo = 1 "+
				"	    ) ";
			
			 try {
				 
				 querySelect = this.getSesion().getConexionBD().prepareStatement(query);
				 querySelect.setDate(1, new java.sql.Date(fecDesde.getTime()));
				 querySelect.setDate(2, new java.sql.Date(fecHasta.getTime()));
				 querySelect.executeUpdate(); 
				 querySelect.close();
				 this.getSesion().getConexionBD().commit();
				 
			 
			 } catch (SQLException e) {
					// TODO Auto-generated catch block
					throw new ExceptionValidation(null,"Erro al actualizar PLANIF ROTAS: "+e.getMessage()); 
			 }			
			
			 querySelect = null;
			 query = null;
		
	}
	
	public void actualizarNovedades(String legajo) throws BaseException {
		
		
		 String condicion = "";
		 if (legajo!=null) {
			 condicion = " oid_legajo in (select oid_legajo from suLegajo where nro_legajo='"+legajo.trim()+"') and ";
		 }
		 
		 
		if (fechaActual==null)
			fechaActual = Fecha.getFechaTruncada(UtilCIP.getFechaHoraActual(this.getSesion()));
		if (fecDesde==null)
			fecDesde = Fecha.getFechaDiaAnterior(fechaActual);
		if (fecHasta ==null)
			fecHasta = Fecha.getFechaMasDias(fechaActual, 140);
		 
		GrupoPuerta grupoPueIng = this.getGrupoPuertaIngreso(this.getSesion());
		 
		MotivosNovCIP motivo = getMotivoNoEncontrado(this.getSesion());
			
		int oidUsu = 0;
		if ((this.getSesion().getLogin()!=null) && (this.getSesion().getLogin().getUsuario()!=null))
			oidUsu = this.getSesion().getLogin().getUsuario().getOID();
		
		int oidMotivoNoEnc = 0;
		String permisoIngreso = "";
		String permisoEgreso = "";
		String codigoIngreso = "";
		String codigoEgreso = "";
		
		if (motivo!=null) {
			oidMotivoNoEnc = motivo.getOID();
			
			permisoIngreso = motivo.getCompoExtIngreso();
			
			if (permisoIngreso!=null) {
				if (permisoIngreso.equalsIgnoreCase("PERMITIDO")) {
					codigoIngreso = "HAB_ING";
				} else if (permisoIngreso.equalsIgnoreCase("DENEGADO")) {
					codigoIngreso = "DES_ING";
				} else  if (permisoIngreso.equalsIgnoreCase("SEGUN_HORARIO")) {
					codigoIngreso = "NA_ING";
				} else  {
					codigoIngreso = "NA_ING";
				}
			}
			
			
			permisoEgreso  = motivo.getCompoExtEgreso();
			
			if (permisoEgreso!=null) {
				if (permisoEgreso.equalsIgnoreCase("LIBRE")) {
					codigoEgreso = "HAB_EGR";
				} else if (permisoEgreso.equalsIgnoreCase("NO_EGRESA")) {
					codigoEgreso = "DES_EGR";
				} else  if (permisoEgreso.equalsIgnoreCase("SEGUN_HORARIO")) {
					codigoEgreso = "NA_EGR";
				} else  {
					codigoEgreso = "NA_EGR";
				}
			}			
			
		}
		
	
		try {
			PreparedStatement queryDelete = null;
			
			//String stringDelete = "delete from cipNovPermisos where "+condicion+" fecha>=? and fecha<=?  ";
			// Modificado por SNIMO el 5/2/14
			String stringDelete = "delete from cipNovPermisos where "+condicion+" fecha>=? and fecha<=? and es_nov_ext=1  ";
			queryDelete = this.getSesion().getConexionBD().prepareStatement(stringDelete);
			queryDelete.setDate(1, new java.sql.Date(fecDesde.getTime()));
			queryDelete.setDate(2, new java.sql.Date(fecHasta.getTime()));
			queryDelete.executeUpdate();
			queryDelete.close();
			this.getSesion().getConexionBD().commit();
			queryDelete = null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
				throw new ExceptionValidation(null,"Erro al actualizar NOVEDADES: "+e.getMessage()); 
		}		 
		
		
		 PreparedStatement querySelect = null;
		 String query = 
			 " INSERT INTO cipNovPermisos "+ 
			 " (OID_NOV_PERMISO, "+
			 "  OID_MOTIVO,"+
			 "  FECHA, "+
			 "  OID_LEGAJO, "+
			 "  HORA_DESDE,"+
			 "  HORA_HASTA,"+
			 "  HORA_DESDE_EN_MIN,"+
			 "  HORA_HASTA_EN_MIN,"+
			 "  OID_GRUPO_PUERTA,"+
			 "  OBSERVACION,"+
			 "  ACTIVO,"+
			 "  FEC_USU_ASIG_PERM,"+
			 "  OID_USU_ASIG_PERM,"+
			 "  HOR_USU_ASIG_PERM,"+
			 "  PERMISO_INGRESO,"+
			 "  PERMISO_EGRESO,"+
			 "  ES_NOV_EXT,"+
			 "  IDENTIF_NOV_EXT,"+
			 "  PESO_NOVEDAD) "+
			 " SELECT SEQ_DBNOVEDADPERMISOCIP.NEXTVAL+(2000000),"+
			 " NVL((select a1.oid_motivo from cipMotivosEquiv a1 where a1.activo = 1 and a1.codigo_externo = "+"(select MAX(NOVTIPO||'_'||novmotivo) from paytbcasnmo where nmonovedad||'_'||NMOORDENPR=PLANIF_NOV.identif_nov_ext )"+"),"+oidMotivoNoEnc+") OID_MOTIVO, "+
			 " PLANIF_NOV.nmofecha,"+
			 " PLANIF_NOV.oid_legajo,"+
			 " NVL((select a2.hora_desde_ing from cipMotivosEquiv a1 , cipMotivosNov a2 where a1.oid_motivo = a2.OID_MOTIVO and a1.activo = 1 and a1.codigo_externo = "+"(select MAX(NOVTIPO||'_'||novmotivo) from paytbcasnmo where nmonovedad||'_'||NMOORDENPR=PLANIF_NOV.identif_nov_ext )"+"),'00:00') HORA_DESDE, "+
			 " NVL((select a2.hora_hasta_ing from cipMotivosEquiv a1 , cipMotivosNov a2 where a1.oid_motivo = a2.OID_MOTIVO and a1.activo = 1 and a1.codigo_externo = "+"(select MAX(NOVTIPO||'_'||novmotivo) from paytbcasnmo where nmonovedad||'_'||NMOORDENPR=PLANIF_NOV.identif_nov_ext )"+"),'23:59') HORA_HASTA, "+
			 " NVL((select a2.HORA_DESDE_ING_MIN from cipMotivosEquiv a1 , cipMotivosNov a2 where a1.oid_motivo = a2.OID_MOTIVO and a1.activo = 1 and a1.codigo_externo = "+"(select MAX(NOVTIPO||'_'||novmotivo) from paytbcasnmo where nmonovedad||'_'||NMOORDENPR=PLANIF_NOV.identif_nov_ext )"+"),0) HORA_DESDE_EN_MIN, "+
			 " NVL((select a2.HORA_HASTA_ING_MIN from cipMotivosEquiv a1 , cipMotivosNov a2 where a1.oid_motivo = a2.OID_MOTIVO and a1.activo = 1 and a1.codigo_externo = "+"(select MAX(NOVTIPO||'_'||novmotivo) from paytbcasnmo where nmonovedad||'_'||NMOORDENPR=PLANIF_NOV.identif_nov_ext )"+"),1439) HORA_HASTA_EN_MIN, "+
			 grupoPueIng.getOIDInteger().toString()+" oid_grupo_puerta,"+
			 "'',"+
			 "1,"+
			 "trunc(sysdate),"+
			 oidUsu+","+
			 "'"+Fecha.getHoraActual()+"',"+
			 " NVL((select "+
			 "   DECODE(a2.compo_ext_ing , 'PERMITIDO' , 'HAB_ING' , 'DENEGADO' , 'DES_ING' , 'SEGUN_HORARIO' , 'NA_ING' , 'NA_ING' ) AS PERMING "+
			 "  from " +
			 "   cipMotivosEquiv a1 , cipMotivosNov a2 "+
			// "   where a1.oid_motivo = a2.OID_MOTIVO and a1.activo = 1 and a1.codigo_externo = PLANIF_NOV.identif_nov_ext),'"+codigoIngreso+"') PERMISOING, "+
			 "   where a1.oid_motivo = a2.OID_MOTIVO and a1.activo = 1 and a1.codigo_externo = "+"(select MAX(NOVTIPO||'_'||novmotivo) from paytbcasnmo where nmonovedad||'_'||NMOORDENPR=PLANIF_NOV.identif_nov_ext )"+"),'"+codigoIngreso+"') PERMISOING, "+
			 " NVL((select "+
			 "   DECODE(a2.compo_ext_egr , 'LIBRE' , 'HAB_EGR' , 'NO_EGRESA' , 'DES_EGR' , 'SEGUN_HORARIO' , 'NA_EGR' , 'NA_EGR' ) AS PERMEGR "+
			 "  from " +
			 "   cipMotivosEquiv a1 , cipMotivosNov a2 "+
			// "   where a1.oid_motivo = a2.OID_MOTIVO and a1.activo = 1 and a1.codigo_externo = PLANIF_NOV.identif_nov_ext),'"+codigoEgreso+"') PERMISOEGR, "+
			 "   where a1.oid_motivo = a2.OID_MOTIVO and a1.activo = 1 and a1.codigo_externo = "+"(select MAX(NOVTIPO||'_'||novmotivo) from paytbcasnmo where nmonovedad||'_'||NMOORDENPR=PLANIF_NOV.identif_nov_ext )"+"),'"+codigoEgreso+"') PERMISOEGR, "+
			 "1,"+
			 "PLANIF_NOV.identif_nov_ext,"+
			 "50 "+
			 " from "+
			 " ( "+   
			 "   select "+ 
			 "     a.nmofecha , b.oid_legajo,a.identif_nov_ext "+  
			 "   from "+ 
			 "     paytbcasnmo a , "+ 
			 "     suLegajo b  "+ 
			 " where "+condicion+  
			 "     a.nmolegajo = b.nro_legajo "+
			 " minus "+
			 "   select fecha,oid_legajo,identif_nov_ext from cipNovPermisos "+ 
			 " where "+condicion+" fecha>=? and fecha<=? and activo=1) PLANIF_NOV ";
		 
		 try {
			 
			 querySelect = this.getSesion().getConexionBD().prepareStatement(query);
			 querySelect.setDate(1, new java.sql.Date(fecDesde.getTime()));
			 querySelect.setDate(2, new java.sql.Date(fecHasta.getTime()));
			 querySelect.executeUpdate();
			 querySelect.close();
			 this.getSesion().getConexionBD().commit();
			 querySelect = null;
			 
		 
		 } catch (SQLException e) {
				// TODO Auto-generated catch block
				throw new ExceptionValidation(null,"Erro al actualizar NOVEDADES: "+e.getMessage()); 
		}
		 
		 // MODIFICADO POR SNIMO EL 24/02 porque me parece que no tiene que ejecutar lo de abajo
		 if (1==1) return;
		 
		 condicion = "";
		 if (legajo!=null) {
			 condicion = " a.oid_legajo in (select oid_legajo from suLegajo where nro_legajo='"+legajo.trim()+"') and ";
		 }
		 
		 
		query = 
			" UPDATE  /*+BYPASS_UJVC*/ ( "+ 
			"	    SELECT "+ 
			"	          a.activo AS old_activo, "+ 
			"	          1 AS new_activo "+ 
			"	    FROM cipNovPermisos a "+ 
			"	          INNER JOIN "+ 
			"					 ( select "+ 
			"	            a1.nmofecha , b1.oid_legajo,a1.identif_nov_ext "+  
			"	           from "+  
			"	              paytbcasnmo a1 , "+ 
			"	              suLegajo b1  "+ 
			"	           where "+  
			"	              a1.nmolegajo = b1.nro_legajo ) Planif "+  
			"	    ON "+condicion+" a.fecha = planif.nmofecha and a.oid_legajo = planif.oid_legajo and a.identif_nov_ext = planif.identif_nov_ext and a.activo = 0 "+
			"	    ) "+
			"	    set old_activo=new_activo ";
			
		 try {
			 
			 querySelect = this.getSesion().getConexionBD().prepareStatement(query);
			// querySelect.executeUpdate(); 
			 querySelect.close();
			 this.getSesion().getConexionBD().commit();
			 querySelect = null;
			 
		 
		 } catch (SQLException e) {
				// TODO Auto-generated catch block
				throw new ExceptionValidation(null,"Erro al actualizar NOVEDADES: "+e.getMessage()); 
		 }
		 
		// 24-02-2013 - Se comenta todo el codigo de abajo
		// Para que no ejecute la parte de abajo dado que se borran los registros y luego se vuelven a generar 
		
		
		 condicion = "";
		 if (legajo!=null) {
			 condicion = " oid_legajo in (select oid_legajo from suLegajo where nro_legajo='"+legajo.trim()+"') and ";
		 }
		 
		 
			query = 
				
				
			       " update cipNovPermisos set activo= 0 where oid_nov_permiso in ( "+
			   	   "	    SELECT "+ 
			   	   "          a.oid_nov_permiso "+
			   	   "	    FROM "+
			   	   "          cipNovPermisos a "+  
			   	   "          INNER JOIN "+  
			   	   "					 ( select fecha,oid_legajo,identif_nov_ext from cipNovPermisos "+  
			   	   "	                     where "+condicion+"fecha>=? and  fecha<=? and es_nov_ext=1 "+
			   	   "            	          minus "+ 
			   	   "       	               select "+ 
			   	   "                         a.nmofecha , b.oid_legajo,a.identif_nov_ext " +			   	   
			   	   "    	               from "+ 
			   	   "	                     paytbcasnmo a , "+ 
			   	   "                         suLegajo b "+  
			   	   " 					   where "+ 
			   	   "                         a.nmolegajo = b.nro_legajo ) PlanifBorrar "+   
			   	   "                       ON a.fecha = PlanifBorrar.fecha and "+
			   	   "                          a.oid_legajo = PlanifBorrar.oid_legajo and "+
			   	   "                          a.identif_nov_ext = PlanifBorrar.identif_nov_ext and "+
			   	   " a.activo = 1) "; 
				
				
			/*	"UPDATE */  /*+BYPASS_UJVC*/  /* ( */
					/*	"	    SELECT "+ 
				"	          a.activo AS old_activo, "+ 
				"	          0 AS new_activo "+ 
				"	    FROM cipNovPermisos a "+ 
				"	          INNER JOIN "+ 
				"					 ( select fecha,oid_legajo,identif_nov_ext from cipNovPermisos "+ 
				"	              where "+condicion+" fecha>=? and  fecha<=? "+
				"	          minus "+
				"	              select "+ 
				"	                a.nmofecha , b.oid_legajo,a.identif_nov_ext "+  
				"	              from "+ 
				"	                paytbcasnmo a , "+ 
				"	                suLegajo b  "+ 
				"	              where "+  
				"	                a.nmolegajo = b.nro_legajo ) PlanifBorrar "+  
				"	    ON a.fecha = PlanifBorrar.fecha and a.oid_legajo = PlanifBorrar.oid_legajo and a.identif_nov_ext = PlanifBorrar.identif_nov_ext and a.activo = 1 "+
				"	    ) "+
				"	    set old_activo=new_activo ";*/ 
			
			 try {
				 
				 querySelect = this.getSesion().getConexionBD().prepareStatement(query);
				 querySelect.setDate(1, new java.sql.Date(fecDesde.getTime()));
				 querySelect.setDate(2, new java.sql.Date(fecHasta.getTime()));
				 querySelect.executeUpdate(); 
				 querySelect.close();
				 this.getSesion().getConexionBD().commit();
				 querySelect = null;
				 
			 
			 } catch (SQLException e) {
					// TODO Auto-generated catch block
					throw new ExceptionValidation(null,"Erro al actualizar NOVEDADES: "+e.getMessage()); 
			 }			
			
		
	}
	
	
	public void actualizarNrosTarjetas(String legajo) throws BaseException {
		
		 PreparedStatement querySelect = null;
		 String query = 
			 " INSERT INTO cipTarjetaLegajo "+
			 " (OID_TAR_LEG,TIPO_TARJETA,NRO_TARJETA,OID_LEGAJO,ACTIVO,ORDEN) "+
			 " SELECT SEQ_DBTARJETALEGAJO.NEXTVAL+(2000000), 'HID_PROX', TRIM(TarjetasNuevas.credenc),TarjetasNuevas.oid_legajo,1,1 "+ 
			 " FROM ( "+
			 " select b.oid_legajo,a.credenc from payremples a , suLegajo b where a.codigo=b.nro_legajo and a.credenc is not null and trim(a.credenc)<>' ' "+
			 " minus "+
			 " select oid_legajo,nro_tarjeta from cipTarjetaLegajo) TarjetasNuevas ";
		 
		 try {
			 
			 querySelect = this.getSesion().getConexionBD().prepareStatement(query);
			 querySelect.executeUpdate();
			 querySelect.close();
			 this.getSesion().getConexionBD().commit();
			 
		 
		 } catch (SQLException e) {
				// TODO Auto-generated catch block
				throw new ExceptionValidation(null,"Erro al actualizar TARJETAS LEGAJOS: "+e.getMessage()); 
		}		
		 
		 querySelect = null;
		 
		String condicion = "";
		if (legajo!=null) {
			condicion = " and b1.nro_legajo = '"+legajo.trim()+"' ";
		}
		 
		//query = "UPDATE  /*+BYPASS_UJVC*/ ( "+
		//		" SELECT "+ 
		//		"	   a.activo AS old_activo, "+
		//		"	   1 AS new_activo "+
		//		"	 FROM cipTarjetaLegajo a "+
		//		"	 INNER JOIN ( select b1.oid_legajo,a1.credenc from payremples a1 , suLegajo b1 where a1.codigo=b1.nro_legajo "+condicion+" and a1.credenc is not null and trim(a1.credenc)<>' ') c "+ 
		//		"	 ON a.nro_tarjeta = c.credenc and a.oid_legajo = c.oid_legajo and a.activo = 0 "+ 
		//		"	) "+
		//		"	SET old_activo = new_activo ";
		
		
		query = "UPDATE  /*+BYPASS_UJVC*/ ( "+
		" SELECT "+ 
		"	   a.activo AS old_activo, "+
		"	   1 AS new_activo "+
		"	 FROM cipTarjetaLegajo a "+
		"	 INNER JOIN ( select b1.oid_legajo,a1.credenc from payremples a1 , suLegajo b1 where a1.codigo=b1.nro_legajo "+condicion+" and a1.credenc is not null and trim(a1.credenc)<>' ') c "+ 
		"	 ON a.nro_tarjeta = c.credenc and a.oid_legajo = c.oid_legajo and a.activo = 0 "+ 
		"	) "+
		"	SET old_activo = new_activo ";		
			
		 try {
			 
			 querySelect = this.getSesion().getConexionBD().prepareStatement(query);
			 querySelect.executeUpdate();
			 querySelect.close();
			 this.getSesion().getConexionBD().commit();
			 
		 
		 } catch (SQLException e) {
				// TODO Auto-generated catch block
				throw new ExceptionValidation(null,"Erro al actualizar TARJETAS LEGAJOS: "+e.getMessage()); 
		}	
		 
		 querySelect = null;
		 
		condicion = "";
		if (legajo!=null) {
			condicion = " where oid_legajo in (select oid_legajo from suLegajo where nro_legajo='"+legajo.trim()+"')    ";
		}
			
		//query =  " UPDATE  /*+BYPASS_UJVC*/ ( "+
		//		 "	 SELECT "+ 
		//		 "	   a.activo AS old_activo, "+
		//		 "	   0 AS new_activo "+
		//		 "	 FROM cipTarjetaLegajo a "+
		//		 "	 INNER JOIN "+ 
		//		 "	 (select oid_legajo,nro_tarjeta from cipTarjetaLegajo "+condicion+" "+
		//		 "	 minus "+
		//		 "	 select b1.oid_legajo,a1.credenc from payremples a1 , suLegajo b1 where a1.codigo=b1.nro_legajo and a1.credenc is not null and trim(a1.credenc)<>' ') c "+ 
		//		 "	 ON a.nro_tarjeta = c.nro_tarjeta and a.oid_legajo = c.oid_legajo and a.activo = 1 "+ 
		//		 "	) "+
		//		 "	SET old_activo = new_activo ";
		
		 query = " UPDATE cipTarjetaLegajo set activo = 0 where oid_tar_leg in "+ 
		 		 " ( 	 SELECT a.oid_tar_leg	 FROM cipTarjetaLegajo a 	 INNER JOIN "+ 	
		 		 " (select oid_legajo,nro_tarjeta from cipTarjetaLegajo "+condicion+" "+  	
		 		 " minus 	 select b1.oid_legajo,a1.credenc from payremples a1 , suLegajo b1 "+ 
		 		 " where a1.codigo=b1.nro_legajo and a1.credenc is not null and trim(a1.credenc)<>' ') c "+ 
		 		 " ON a.nro_tarjeta = c.nro_tarjeta and a.oid_legajo = c.oid_legajo and a.activo = 1 	) "; 		
			
		 try {
			 
			 querySelect = this.getSesion().getConexionBD().prepareStatement(query);
			 querySelect.executeUpdate(); //SUSPENDIDO POR EL MOMENTO
			 querySelect.close();
			 this.getSesion().getConexionBD().commit();
			 
		 
		 } catch (SQLException e) {
				// TODO Auto-generated catch block
				throw new ExceptionValidation(null,"Erro al actualizar TARJETAS LEGAJOS: "+e.getMessage()); 
		}		
		 
		 querySelect = null;
			 
			
	}
	
	public void actualizarEstados() throws BaseException {
		
		 PreparedStatement querySelect = null;
		 String query = "INSERT INTO CIPESTADOS("+
				        "OID_ESTADO,CODIGO,DESCRIPCION,TIPO_INGRESO,TIPO_EGRESO,ACTIVO,LEY_ING_DENEGADO,"+
				        "LEY_EGR_DENEGADO,ACT_ANTI_PASS_BACK,ES_SUSCEP_CACHEO, MIN_ENT_ANT_ENT,MIN_ENT_DES_ENT) "+
				        "SELECT SEQ_DBESTADOCIP.NEXTVAL+(2000000),UPPER(TRIM(ESTADOS.ESTADO)),TRIM(ESTADOS.ESTADO),'SEGUN_PLANIF','SEGUN_PLANIF',1,' ',' ',0,0,0,0 "+ 
				        "FROM (select DISTINCT UPPER(ESTADO) ESTADO from payremples) ESTADOS "+  
				        "WHERE ESTADOS.ESTADO NOT IN (SELECT CODIGO FROM CIPESTADOS)"; 
			 
		 try {
			 
			 
			 querySelect = this.getSesion().getConexionBD().prepareStatement(query);
			 querySelect.executeUpdate();
			 querySelect.close();
			 
			 this.getSesion().getConexionBD().commit();
			 
		 
		 } catch (SQLException e) {
				// TODO Auto-generated catch block
				throw new ExceptionValidation(null,"Erro al actualizar CIPESTADOS: "+e.getMessage()); 
		}		
		 
		querySelect = null;
		query = null;
		
	}
	
	
	public void actualizarRotas() throws BaseException {
		
		// Actualizar los Datos de la Empresa
		PreparedStatement querySelect = null;
		
		int minEntAntes = this.getMinEntAntesRota();
		int minEntDespues = this.getMinEntDespuesRota();
		
		// INSERTAR LAS EMPRESAS NUEVAS
		String query = "INSERT INTO CIPROTAS "+
			    	   "(OID_ROTA,CODIGO,DESCRIPCION,HORARIO_DESDE,HORARIO_HASTA,MIN_ENT_ANTES,ACTIVO,"+
			    	   " MIN_ENT_DESP,MIN_SAL_ANTES,TIPO_ACCESO,TIPO_EGRESO,MIN_SAL_DESPUES,"+
			    	   "LEY_NO_INGRESA,LEY_NO_EGRESA)"+
			    	   " SELECT "+
			    	   " SEQ_DBROTA.NEXTVAL+(2000000),UPPER(TRIM(ROTA.TRACODIGO)),TRIM(ROTA.TRADESCRIP),TRAHORAINI,TRAHORAFIN,"+minEntAntes+",1,"+minEntDespues+",0,'SEGUN_HORARIO','LIBRE',0,'','' "+ 
			    	   " FROM "+
			    	   " (SELECT TRACODIGO,TRADESCRIP,TRAHORAINI,TRAHORAFIN FROM PAYROTAS) ROTA WHERE TRACODIGO NOT IN (SELECT CODIGO FROM CIPROTAS ) ";
		try {
			 
			 
			 querySelect = this.getSesion().getConexionBD().prepareStatement(query);
			 querySelect.executeUpdate();
			 querySelect.close();
			 this.getSesion().getConexionBD().commit();
			 
		 
		 } catch (SQLException e) {
				// TODO Auto-generated catch block
				throw new ExceptionValidation(null,"Erro al actualizar ROTAS: "+e.getMessage()); 
		}				
		 
		 querySelect = null;
		 
		// MODIFICAR LAS EMPRESAS EXISTENTES
		 
		 query = " UPDATE  /*+BYPASS_UJVC*/ ( "+
				 " SELECT "+ 
				 "  a.descripcion AS old_descripcion, "+
				 "  b.TRADESCRIP AS new_descripcion, "+
				 "  a.horario_desde AS old_horario_desde, "+
				 "  b.TRAHORAINI AS new_horario_desde, "+
				 "  a.horario_hasta AS old_horario_hasta, "+
				 "  b.TRAHORAFIN AS new_horario_hasta "+
				 " FROM CIPROTAS a "+
				 " INNER JOIN PAYROTAS b ON a.codigo = b.tracodigo "+  
				 " ) "+
				 " SET old_descripcion = new_descripcion , old_horario_desde = new_horario_desde , old_horario_hasta = new_horario_hasta "+
				 " where "+
				 " old_descripcion <> new_descripcion or old_horario_desde <> new_horario_desde or old_horario_hasta <> new_horario_hasta ";
		 
		  try {
				 
				 
				 querySelect = this.getSesion().getConexionBD().prepareStatement(query);
				 querySelect.executeUpdate();
				 querySelect.close();
				 this.getSesion().getConexionBD().commit();
				 
			 
		  } catch (SQLException e) {
					// TODO Auto-generated catch block
				 throw new ExceptionValidation(null,"Erro al actualizar ROTAS: "+e.getMessage()); 
		  }				
		  
		  querySelect = null;
		
	}
	
	
	public void actualizarValClasif() throws BaseException {
		
		// Actualizar los Datos de la Empresa
		PreparedStatement querySelect = null;
		ClasificadorEntidad clasifEmpresa = this.getClasificadorEmpresa(this.getSesion()); 
		
		// INSERTAR LAS EMPRESAS NUEVAS
		String query = "INSERT INTO GEVALCLASIFENT("+
			    	   "OID_VAL_CLASIF_ENT,OID_CLASIF_ENT,OID_ITEM,OID_ITEM_PADRE,ACTIVO,ORDEN,TIPO,CODIGO_DESDE,CODIGO_HASTA,CODIGO,DESCRIPCION) "+
			    	   " SELECT "+
			    	   " SEQ_DBVALORCLASIFICADORENTIDAD.NEXTVAL+(2000000),"+clasifEmpresa.getOIDInteger().toString()+",SEQ_DBVALORCLASIFICADORENTIDAD.NEXTVAL+(2000000),-1,1,1,"+ 
			    	   "'TITULO','0','0',UPPER(TRIM(EMPRESA.EMPRESA)),TRIM(EMPRESA.NOMBRE) "+
			    	   " FROM "+
			    	   " (SELECT EMPRESA,NOMBRE FROM PAYEMPRESA) EMPRESA WHERE TRIM(EMPRESA) NOT IN (SELECT CODIGO FROM GEVALCLASIFENT WHERE OID_CLASIF_ENT="+clasifEmpresa.getOIDInteger().toString()+" ) ";
		try {
			 
			 
			 querySelect = this.getSesion().getConexionBD().prepareStatement(query);
			 querySelect.executeUpdate();
			 querySelect.close();
			 
			 this.getSesion().getConexionBD().commit();
		 
		 } catch (SQLException e) {
				// TODO Auto-generated catch block
				throw new ExceptionValidation(null,"Erro al actualizar VALORES CLASIF. EMPRESAS: "+e.getMessage()); 
		}				
		 
		querySelect = null; 
		 
		// MODIFICAR LAS EMPRESAS EXISTENTES
		 
 		 query = " UPDATE  /*+BYPASS_UJVC*/ ( "+
				 " SELECT "+ 
				 "  a.descripcion AS old_descripcion, "+
				 "  b.nombre AS new_descripcion "+
				 " FROM GEVALCLASIFENT a "+
				 " INNER JOIN PAYEMPRESA b ON a.codigo = b.empresa WHERE a.oid_clasif_ent = "+clasifEmpresa.getOIDInteger().toString()+" "+  
				 " ) "+
				 " SET old_descripcion = new_descripcion WHERE old_descripcion <> new_descripcion ";
		 
		  try {
				 
				 
				 querySelect = this.getSesion().getConexionBD().prepareStatement(query);
				 querySelect.executeUpdate(); // SUSPENDIDO POR AHORA
				 querySelect.close();
				 
			 
		  } catch (SQLException e) {
					// TODO Auto-generated catch block
				 throw new ExceptionValidation(null,"Erro al actualizar VALORES CLASIF. EMPRESAS: "+e.getMessage()); 
		  }	
		  
		  querySelect = null;
		
		  
		// ******************************//  
		// Insertar los centos de costos //
		// ******************************//
		ClasificadorEntidad clasifCECO = this.getClasificadorCECO(this.getSesion());
		
		
		query = " INSERT INTO GEVALCLASIFENT( "+
			    " OID_VAL_CLASIF_ENT,OID_CLASIF_ENT,OID_ITEM,OID_ITEM_PADRE,ACTIVO,ORDEN,TIPO,CODIGO_DESDE,CODIGO_HASTA,CODIGO,DESCRIPCION) "+
			    " SELECT "+
			    " SEQ_DBVALORCLASIFICADORENTIDAD.NEXTVAL+(2000000),"+clasifCECO.getOIDInteger().toString()+",SEQ_DBVALORCLASIFICADORENTIDAD.NEXTVAL+(2000000),-1,1,1, "+
			    " 'TITULO','0','0',UPPER(TRIM(RTABLAS.CODIGO)),TRIM(RTABLAS.DESCRIP) "+
			    " FROM "+
			    " (SELECT CODIGO,DESCRIP FROM PAYRTABLAS WHERE COTAB="+this.getNroCotabCECORtablas()+") RTABLAS WHERE TRIM(CODIGO) NOT IN (SELECT CODIGO FROM GEVALCLASIFENT WHERE OID_CLASIF_ENT="+clasifCECO.getOIDInteger().toString()+") ";
		 
		  try {
				 
				 
				 querySelect = this.getSesion().getConexionBD().prepareStatement(query);
				 querySelect.executeUpdate();
				 querySelect.close();
				 
			 
		  } catch (SQLException e) {
					// TODO Auto-generated catch block
				 throw new ExceptionValidation(null,"Erro al actualizar VALORES CLASIF. CECOS: "+e.getMessage()); 
		  }				
		  
		  querySelect = null;
		  
		  // Actualizar los Datos del Centro de Costos
		  //query = " UPDATE  /*+BYPASS_UJVC*/ ( "+
		  //		  " SELECT "+ 
			//	  "  a.descripcion AS old_descripcion, "+
			//	  "  b.descrip AS new_descripcion "+
			//	  " FROM GEVALCLASIFENT a "+
			//	  " INNER JOIN PAYRTABLAS b ON trim(a.codigo) = trim(b.codigo) WHERE a.oid_clasif_ent = "+clasifCECO.getOIDInteger().toString()+"  and b.cotab = "+this.getNroCotabCECORtablas()+" "+
			//	  " ) "+
			//	  " SET old_descripcion = new_descripcion WHERE old_descripcion <> new_descripcion ";
		  
		  
		  query = " UPDATE GEVALCLASIFENT A "+
		  		  " SET DESCRIPCION = (SELECT DESCRIP FROM PAYRTABLAS WHERE COTAB = "+this.getNroCotabCECORtablas()+" AND CODIGO = A.CODIGO) "+
		  		  " WHERE OID_CLASIF_ENT = "+clasifCECO.getOIDInteger().toString()+" AND "+ 
		  		  "DESCRIPCION <> (SELECT DISTINCT DESCRIP FROM PAYRTABLAS WHERE COTAB = "+this.getNroCotabCECORtablas()+" AND CODIGO = A.CODIGO) ";
		
		  try {
			  
				 querySelect = this.getSesion().getConexionBD().prepareStatement(query);
				 querySelect.executeUpdate(); 
				 querySelect.close();
				 
			 
		  } catch (SQLException e) {
					// TODO Auto-generated catch block
				 throw new ExceptionValidation(null,"Erro al actualizar VALORES CLASIF. CECOS: "+e.getMessage()); 
		  }				
		  
		  querySelect = null;
		  
			// ******************************//
			// Actualizar los puestos //
			// ******************************//
			ClasificadorEntidad clasifPuesto = this.getClasifPuesto(this.getSesion());

			query = " INSERT INTO GEVALCLASIFENT( " + " OID_VAL_CLASIF_ENT,OID_CLASIF_ENT,OID_ITEM,OID_ITEM_PADRE,ACTIVO,ORDEN,TIPO,CODIGO_DESDE,CODIGO_HASTA,CODIGO,DESCRIPCION) " + " SELECT "
					+ " SEQ_DBVALORCLASIFICADORENTIDAD.NEXTVAL+(2000000)," + clasifPuesto.getOIDInteger().toString() + ",SEQ_DBVALORCLASIFICADORENTIDAD.NEXTVAL+(2000000),-1,1,1, "
					+ " 'TITULO','0','0',UPPER(TRIM(RTABLAS.CODIGO)),TRIM(RTABLAS.DESCRIP) " + " FROM " + " (SELECT CODIGO,DESCRIP FROM PAYRTABLAS WHERE COTAB=" + getCotabPuestoUTE(this.getSesion())
					+ " ) RTABLAS WHERE TRIM(CODIGO) NOT IN (SELECT CODIGO FROM GEVALCLASIFENT WHERE OID_CLASIF_ENT=" + clasifPuesto.getOIDInteger().toString() + ") ";

			try {

				querySelect = this.getSesion().getConexionBD().prepareStatement(query);
				querySelect.executeUpdate();
				querySelect.close();

				this.getSesion().getConexionBD().commit();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				throw new ExceptionValidation(null, "Erro al actualizar VALORES CLASIF. PUESTOS: " + e.getMessage());
			}
			
			querySelect = null;

			// Actualizar los Datos del Centro de Costos
			//query = " UPDATE  /*+BYPASS_UJVC*/ ( " + " SELECT " + "  a.descripcion AS old_descripcion, " + "  b.descrip AS new_descripcion " + " FROM GEVALCLASIFENT a "
			//		+ " INNER JOIN PAYRTABLAS b ON a.codigo = b.codigo WHERE a.oid_clasif_ent = " + clasifPuesto.getOIDInteger().toString() + "  and b.cotab = " + getCotabPuestoUTE(this.getSesion())
			//		+ " " + " ) " + " SET old_descripcion = new_descripcion WHERE old_descripcion <> new_descripcion ";
			
			  query = " UPDATE GEVALCLASIFENT A "+
	  		  " SET DESCRIPCION = (SELECT DESCRIP FROM PAYRTABLAS WHERE COTAB = "+getCotabPuestoUTE(this.getSesion())+" AND CODIGO = A.CODIGO) "+
	  		  " WHERE OID_CLASIF_ENT = "+clasifPuesto.getOIDInteger().toString()+" AND "+ 
	  		  "DESCRIPCION <> (SELECT DISTINCT DESCRIP FROM PAYRTABLAS WHERE COTAB = "+getCotabPuestoUTE(this.getSesion())+" AND CODIGO = A.CODIGO) ";			

			try {

				querySelect = this.getSesion().getConexionBD().prepareStatement(query);
				querySelect.executeUpdate(); 
				querySelect.close();

				this.getSesion().getConexionBD().commit();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				throw new ExceptionValidation(null, "Erro al actualizar VALORES CLASIF. PUESTO: " + e.getMessage());
			}
			
			querySelect = null;

			/****************************/
			/** ACTUALIZAR LOS ESTADOS **/
			/****************************/

			ClasificadorEntidad clasifEstado = this.getClasifEstado(this.getSesion());
			query = "INSERT INTO GEVALCLASIFENT(" + "OID_VAL_CLASIF_ENT,OID_CLASIF_ENT,OID_ITEM,OID_ITEM_PADRE,ACTIVO,ORDEN,TIPO,CODIGO_DESDE,CODIGO_HASTA,CODIGO,DESCRIPCION) " + " SELECT "
					+ " SEQ_DBVALORCLASIFICADORENTIDAD.NEXTVAL+(2000000)," + clasifEstado.getOIDInteger().toString() + ",SEQ_DBVALORCLASIFICADORENTIDAD.NEXTVAL+(2000000),-1,1,1,"
					+ "'TITULO','0','0',UPPER(TRIM(ESTADO.ESTADO)),TRIM(ESTADO.ESTADO) " + " FROM "
					+ " (SELECT DISTINCT ESTADO FROM PAYREMPLES) ESTADO WHERE TRIM(ESTADO) NOT IN (SELECT CODIGO FROM GEVALCLASIFENT WHERE OID_CLASIF_ENT=" + clasifEstado.getOIDInteger().toString()
					+ " ) ";
			try {

				querySelect = this.getSesion().getConexionBD().prepareStatement(query);
				querySelect.executeUpdate();
				querySelect.close();

				this.getSesion().getConexionBD().commit();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				throw new ExceptionValidation(null, "Erro al actualizar VALORES CLASIF. ESTADOS: " + e.getMessage());
			}
			
			querySelect = null;
		  
		  
		
	}
	
	public static Integer getCotabPuestoUTE(ISesion aSesion) throws BaseException {
		return ValorParametro.findByCodigoParametro("COTAB_PUESTO_UTE", aSesion).getValorEntero();
	}
	
	
	public static ClasificadorEntidad getClasifPuesto(ISesion aSesion) throws BaseException {
		Integer oidClasifProd = ValorParametro.findByCodigoParametro("CLASIF_PUESTO_UTE", aSesion).getOidObjNeg();
		ClasificadorEntidad clasifEnt = ClasificadorEntidad.findByOid(oidClasifProd, aSesion);
		return clasifEnt;
	}

	public static ClasificadorEntidad getClasifEstado(ISesion aSesion) throws BaseException {
		Integer oidClasifProd = ValorParametro.findByCodigoParametro("CLASIF_ESTADO_UTE", aSesion).getOidObjNeg();
		ClasificadorEntidad clasifEnt = ClasificadorEntidad.findByOid(oidClasifProd, aSesion);
		return clasifEnt;
	}
	
	
	public void actualizarLegajos(String legajo) throws BaseException {
		
		HashTableDatos listaValClasifLeg = new HashTableDatos();
		ClasificadorEntidad clasifCECO = this.getClasificadorCECO(this.getSesion());
		ClasificadorEntidad clasifEmpresa = this.getClasificadorEmpresa(this.getSesion());
		GrupoPuerta grupoPueIng = this.getGrupoPuertaIngreso(this.getSesion());
		GrupoPuerta grupoPueEgr = this.getGrupoPuertaEgreso(this.getSesion());
		String inEmpresasLegPAYROLL = getINEmpresasLegajoPAYROLL();
		
		/** insertar los Nuevos Legajos **/
		
		
		String condicion = "";
		if (legajo!=null)
			condicion = " and j2.nro_legajo='"+legajo.trim()+"' ";
		
		PreparedStatement querySelect = null;
		String query = " INSERT INTO SULEGAJO "+
		  		" (OID_LEGAJO,NRO_LEGAJO,NOMBRE,APELLIDO,ACTIVO,OID_CLASIF_01,OID_CLASIF_02,OID_CLASIF_04, OID_CLASIF_05, "+
		  		" FEC_INGRESO,FEC_RETIRO,OID_GRUPO_PUE_ING,OID_GRUPO_PUE_EGR,OID_ESTADO,ACT_ANTI_PASS_BACK, "+
		  		" IGNORAR_PROX_APB,CIRCUITO_CACHEO,LIB_ING_AL_PREDIO) "+
		  		" SELECT SEQ_DBLEGAJO.NEXTVAL+(2000000), UPPER(TRIM(payRemples.codigo)),trim(NVL(SUBSTR(payRemples.nombre,INSTR(payRemples.nombre,',')+1,100),'')), "+
		        " trim(NVL(SUBSTR(payRemples.nombre,1,INSTR(payRemples.nombre,',')-1),'')),1, "+
		        " (SELECT MAX(OID_VAL_CLASIF_ENT) FROM GEVALCLASIFENT WHERE  OID_CLASIF_ENT = "+clasifEmpresa.getOIDInteger().toString()+" AND CODIGO = payRemples.empresa) , "+
		        " (SELECT MAX(OID_VAL_CLASIF_ENT) FROM GEVALCLASIFENT WHERE  OID_CLASIF_ENT = "+clasifCECO.getOIDInteger().toString()+" AND CODIGO = payRemples.cencos||''), "+
		        " (SELECT MAX(OID_VAL_CLASIF_ENT) FROM GEVALCLASIFENT WHERE  OID_CLASIF_ENT = "+getClasifPuesto(this.getSesion()).getOIDInteger().toString()+" AND CODIGO = payRemples.cargo), "+
		        " (SELECT MAX(OID_VAL_CLASIF_ENT) FROM GEVALCLASIFENT WHERE  OID_CLASIF_ENT = "+getClasifEstado(this.getSesion()).getOIDInteger().toString()+" AND CODIGO = payRemples.estado), "+
		        " payRemples.fecha_ing,payRemples.fecha_ret,"+grupoPueIng.getOIDInteger().toString()+","+grupoPueEgr.getOIDInteger().toString()+
		        ","+
		        " (select max(oid_estado) from cipestados where codigo = payRemples.estado)"+
		        ",0,0,0,0 "+
		        " FROM "+
		        " (SELECT j1.empresa,j1.codigo,j1.nombre,j1.estado,j1.fecha_ing,j1.fecha_ret,j1.cencos,j1.cargo from payRemples j1 , suLegajo j2   WHERE j2.nro_legajo(+)=j1.codigo "+condicion+" and j2.nro_legajo is null and j1.empresa in ("+inEmpresasLegPAYROLL+") ) payRemples ";
		  try {
			  
				 querySelect = this.getSesion().getConexionBD().prepareStatement(query);
				 querySelect.executeUpdate();
				 querySelect.close();
				 
				 this.getSesion().getConexionBD().commit();
				 
			 
		  } catch (SQLException e) {
					// TODO Auto-generated catch block
				 throw new ExceptionValidation(null,"Erro al actualizar LEGAJOS: "+e.getMessage()); 
		  }				
		
		  querySelect = null;
		  
		 /** Updetaer los Nuevos Legajos **/
		  
		  
		condicion = "";
		if (legajo!=null)
			condicion = " a.nro_legajo='"+legajo.trim()+"' or ";
		  
		
		query = " UPDATE  /*+BYPASS_UJVC*/ "; 
		query = query + " (  ";
		query = query +" SELECT ";  
		query = query +"    a.activo AS old_activo, ";  
		query = query +"    1 AS new_activo,   ";
		query = query +"    a.nombre AS old_nombre, "; 
		query = query +"    substr(trim(NVL(SUBSTR(b.nombre,INSTR(b.nombre,',')+1,100),'')),1,50) AS new_nombre, ";  
		query = query +"    a.apellido AS old_apellido,  ";
		query = query +"    substr(trim(NVL(SUBSTR(b.nombre,1,INSTR(b.nombre,',')-1),'')),1,50) AS new_apellido, ";  
		query = query +"    a.fec_ingreso as old_fec_ingreso,  ";
		query = query +"    b.fecha_ing as new_fec_ingreso,   ";
		query = query +"    a.fec_retiro as old_fec_egreso,   ";
		query = query +"    b.fecha_ret as new_fec_egreso,  ";
		query = query +"    a.oid_estado as old_estado,   ";
		query = query +"    (select max(oid_estado) from cipestados where codigo = b.estado) as new_estado,  ";
		query = query +"    a.oid_clasif_01 AS old_oid_clasif_01, ";
		query = query +"    (SELECT MAX(hh.OID_VAL_CLASIF_ENT) FROM GEVALCLASIFENT hh WHERE  hh.OID_CLASIF_ENT = "+clasifEmpresa.getOIDInteger().toString()+" AND CODIGO = b.empresa AND CODIGO<>0) AS new_oid_clasif_01, ";
		query = query +"    a.oid_clasif_02 AS old_oid_clasif_02, ";
		query = query +"    (SELECT MAX(hh.OID_VAL_CLASIF_ENT) FROM GEVALCLASIFENT hh WHERE  hh.OID_CLASIF_ENT = "+clasifCECO.getOIDInteger().toString()+" AND CODIGO = b.cencos AND CODIGO<>0) AS new_oid_clasif_02, ";
		query = query +"    a.oid_clasif_04 AS old_oid_clasif_04, ";
		query = query +"    (SELECT MAX(hh.OID_VAL_CLASIF_ENT) FROM GEVALCLASIFENT hh WHERE  hh.OID_CLASIF_ENT = "+this.getClasifPuesto(this.getSesion()).getOIDInteger()+" AND CODIGO = b.cargo AND CODIGO<>0) AS new_oid_clasif_04, ";
		query = query +"    a.oid_clasif_05 AS old_oid_clasif_05, ";
		query = query +"    (SELECT MAX(hh.OID_VAL_CLASIF_ENT) FROM GEVALCLASIFENT hh WHERE  hh.OID_CLASIF_ENT = "+this.getClasifEstado(this.getSesion()).getOIDInteger()+" AND CODIGO = b.estado AND CODIGO IS NOT NULL) AS new_oid_clasif_05 ";
		query = query +" FROM   ";
		query = query +"    SULEGAJO a INNER JOIN PAYREMPLES b ON a.nro_legajo = b.codigo  WHERE  "+condicion;
		query = query +"      a.nombre<>substr(trim(NVL(SUBSTR(b.nombre,INSTR(b.nombre,',')+1,100),'')),1,50)  ";
		query = query +"      or  ";
		query = query +"      a.apellido<>substr(trim(NVL(SUBSTR(b.nombre,1,INSTR(b.nombre,',')-1),'')),1,50)  ";
		query = query +"      or  ";
		query = query +"      a.fec_ingreso<>b.fecha_ing  ";
		query = query +"      or  ";
		query = query +"      a.fec_retiro<>b.fecha_ret  ";
		query = query +"      or  ";
		query = query +"      a.oid_estado<>(select max(oid_estado) from cipestados where codigo = b.estado)  ";
		query = query +"      or  ";
		query = query +"      a.activo<>1  ";
		query = query +"      or ";
		query = query +"      nvl(a.oid_clasif_01,0) <> (SELECT nvl(MAX(hh.OID_VAL_CLASIF_ENT),0) FROM GEVALCLASIFENT hh WHERE  hh.OID_CLASIF_ENT = "+clasifEmpresa.getOIDInteger().toString()+" AND CODIGO = b.empresa) ";
		query = query +"      or ";
		query = query +"      nvl(a.oid_clasif_02,0) <> (SELECT nvl(MAX(hh.OID_VAL_CLASIF_ENT),0) FROM GEVALCLASIFENT hh WHERE  hh.OID_CLASIF_ENT = "+clasifCECO.getOIDInteger().toString()+" AND CODIGO = b.cencos||'') ";
		query = query +"      or ";
		query = query +"      nvl(a.oid_clasif_04,0) <> (SELECT nvl(MAX(hh.OID_VAL_CLASIF_ENT),0) FROM GEVALCLASIFENT hh WHERE  hh.OID_CLASIF_ENT = "+this.getClasifPuesto(this.getSesion()).getOIDInteger().toString()+" AND CODIGO = b.cargo) ";      
		query = query +"      or ";
		query = query +"      nvl(a.oid_clasif_05,0) <> (SELECT nvl(MAX(hh.OID_VAL_CLASIF_ENT),0) FROM GEVALCLASIFENT hh WHERE  hh.OID_CLASIF_ENT = "+this.getClasifEstado(this.getSesion()).getOIDInteger().toString()+" AND CODIGO = b.estado) ";      
		query = query +"      )   ";
		query = query +"  SET  old_activo = new_activo ,  "; 
		query = query +"       old_nombre = new_nombre ,   ";
		query = query +"       old_apellido = new_apellido ,   ";
		query = query +"       old_fec_ingreso = new_fec_ingreso,  ";
		query = query +"       old_fec_egreso = new_fec_egreso,   ";
		query = query +"       old_estado = new_estado,   ";
		query = query +"       old_oid_clasif_01 = new_oid_clasif_01, ";
		query = query +"       old_oid_clasif_02 = new_oid_clasif_02, ";
		query = query +"       old_oid_clasif_04 = new_oid_clasif_04, ";
		query = query +"       old_oid_clasif_05 = new_oid_clasif_05 ";
		 
		// System.out.println(query);
		 
		  try {
			  
				 querySelect = this.getSesion().getConexionBD().prepareStatement(query);
				 querySelect.executeUpdate();
				 querySelect.close();
				 
				 
				 
				 
			 
		  } catch (SQLException e) {
					// TODO Auto-generated catch block
				 throw new ExceptionValidation(null,"Erro al actualizar LEGAJOS: "+e.getMessage()); 
		  }						 
		  
		  querySelect = null;
		  
		  // DESACTIVAR LEGAJOS NO INFORMADOS
		  
			condicion = "";
			if (legajo!=null)
				condicion = " WHERE nro_legajo='"+legajo.trim()+"' ";
		  
		  query = " UPDATE SULEGAJO SET ACTIVO = 0 WHERE NRO_LEGAJO IN ( "+
				  "  (SELECT NRO_LEGAJO FROM SULEGAJO "+condicion+" MINUS "+
				  "  SELECT CODIGO FROM PAYREMPLES)) ";		  
				   		  
		  try {
			  
				 querySelect = this.getSesion().getConexionBD().prepareStatement(query);
				 querySelect.executeUpdate();
				 querySelect.close();
				 
			 
		  } catch (SQLException e) {
					// TODO Auto-generated catch block
				 throw new ExceptionValidation(null,"Erro al actualizar LEGAJOS: "+e.getMessage()); 
		  }						 
		  
		  querySelect = null;
		  
		  listaValClasifLeg = null;
		  clasifCECO = null;
		  clasifEmpresa = null;
		  grupoPueIng = null;
		  grupoPueEgr = null;
		  inEmpresasLegPAYROLL = null;		  
		
	}
	
	public void importarDatosPayroll(String legajo,Connection conexion) throws BaseException {
		
		importarDatosEmpresa(conexion);
		importarDatosRTablas(conexion);
		
		importarDatosRemples(legajo,conexion);
		
		importarDatosRota(conexion);
		
		//importarDatosTBCASTNN(conexion);
		importarDatosLegRotaFecha(legajo,conexion);
		importarDatosNovedades(legajo,conexion);
		//importarDatosNovedadesGLM(legajo,conexion);
		
	}
	
	public void importarDatosLegajos(String legajo,Connection conexion) throws BaseException {
		importarDatosEmpresa(conexion);
		importarDatosRTablas(conexion);
		importarDatosRemples(legajo,conexion);
		//importarDatosTBCASTNN(conexion);
	}
	
	public void importarDatosPlanifRotas(String legajo,boolean importarRotas,Connection conexion) throws BaseException {
		if (importarRotas)
			importarDatosRota(conexion);
		importarDatosLegRotaFecha(legajo,conexion);
		importarDatosNovedades(legajo,conexion);
		//importarDatosNovedadesGLM(legajo,conexion);
	}
	
	
	
	public void importarDatosNovedadesGLM(String legajo,Connection conexion) throws BaseException {
		
	    final int OID_TBGL_NOV = 1;
	    final int CODIGO = 2;
	    final int FECHAINI = 3;
	    final int FECHAFIN = 4;
	    final int PROCONPE = 5;
	    final int ACTIVO = 6;
		
		
		NovedadGLMPayroll.truncarTablaNovedades(this.getSesion());
		
	    StringBuffer sqlInsert = new StringBuffer();
	    sqlInsert.append(" insert into PayTBGLMNOV "+
	                     " ( "+
	                      "OID_TBGL_NOV,"+
	                      "CODIGO,"+
	                      "FECHAINI,"+
	                      "FECHAFIN,"+
	                      "PROCONPE,"+
	                      "ACTIVO)"+ 
	                      " values "+ 
	                      "("+
	                      "?,"+
	                      "?,"+
	                      "?,"+
	                      "?,"+
	                      "?,"+
	                      "?) ");
		
	     String nolock = "";
	     if (this.isUsarNOLOCKEnImpNovedades(this.getSesion()))
	    	 nolock = " (nolock) ";
		
		 PreparedStatement querySelect = null;
		 String query = "SELECT codigo , fechaini , fechafin , proconpe  FROM "+getPrefijoTablaPAYROLL()+"tbglmnov "+nolock+" where fechafin>=? and proconpe is not null and proconpe>=? and proconpe<=?  ";
		 
		 if (legajo!=null)
			 query = query +" and RTRIM(LTRIM(codigo))='"+legajo.trim()+"'";
		 
		 try {
			 
			 if (fechaActual==null)
				 fechaActual = Fecha.getFechaTruncada(UtilCIP.getFechaHoraActual(this.getSesion()));
			 if (fecDesde==null)
				 fecDesde = Fecha.getFechaDiaAnterior(fechaActual);
			 if (fecHasta==null)
				 fecHasta = Fecha.getFechaMasDias(fechaActual, 5);
			 
			 PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
			 
			 querySelect = conexion.prepareStatement(query);
			 querySelect.setDate(1, new java.sql.Date(fecDesde.getTime()));
			 querySelect.setDate(2, new java.sql.Date(fecDesde.getTime()));
			 querySelect.setDate(3, new java.sql.Date(fecHasta.getTime()));
			 
			 int secu = 1;
			 ResultSet rs = querySelect.executeQuery();
			 while (rs.next()) {
				 NovedadGLMPayroll novedad = (NovedadGLMPayroll) NovedadGLMPayroll.getNew(NovedadGLMPayroll.NICKNAME, this.getSesion());
				 novedad.setDesHabEventoWFAfterNew(true);
				 String codigo = rs.getString("codigo");
				 if (codigo!=null)
					 novedad.setCodigo(codigo.trim().toUpperCase());
				 else
					 novedad.setCodigo("");
				 novedad.setFechaini(rs.getDate("fechaini"));
				 novedad.setFechafin(rs.getDate("fechafin"));
				 novedad.setProconpe(rs.getDate("proconpe"));
				 novedad.setActivo(true);
				 
				 qInsert.setInt(OID_TBGL_NOV,secu);
				 if (novedad.getCodigo()!=null)
				    	qInsert.setString(CODIGO,novedad.getCodigo());
				 else
				    	qInsert.setNull(CODIGO,Types.CHAR);
				 if (novedad.getFechaini()!=null)
				    	qInsert.setDate(FECHAINI,new java.sql.Date(novedad.getFechaini().getTime()));
				 else
				    	qInsert.setNull(FECHAINI,Types.DATE);
				 if (novedad.getFechafin()!=null)
				    	qInsert.setDate(FECHAFIN,new java.sql.Date(novedad.getFechafin().getTime()));
				 else
				    	qInsert.setNull(FECHAFIN,Types.DATE);
				 if (novedad.getProconpe()!=null)
				    	qInsert.setDate(PROCONPE,new java.sql.Date(novedad.getProconpe().getTime()));
				 else
				    	qInsert.setNull(PROCONPE,Types.DATE);
				 qInsert.setBoolean(ACTIVO,novedad.isActivo().booleanValue());
				 qInsert.executeUpdate();
				 ++secu;
			 }
		 
		qInsert.close();
		 rs.close();
		 querySelect.close();
		 
		 } catch (SQLException e) {
				// TODO Auto-generated catch block
				throw new ExceptionValidation(null,"Erro al importar TBCASETR de Payroll. "+e.getMessage()); 
		}
		 
		try {
			conexion.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
		}
		
	}
	
	
	public void importarDatosNovedades(String aLegajo,Connection conexion) throws BaseException {
		
	    final int OID_TBCAS_NMO = 1;
	    final int NMONOVEDAD = 2;
	    final int NMOORDENPR = 3;
	    final int NMOFECHA = 4;
	    final int NMOLEGAJO = 5;
	    final int ACTIVO = 6;
	    final int NMOCEX = 7; 
	    final int NOV_TIPO = 8;
	    final int NOV_MOTIVO = 9;
	    final int IDENTIF_NOV_EXT = 10;
	    
	    int secu = 1;
		
	    StringBuffer sqlInsert = new StringBuffer();
	    sqlInsert.append(" insert into payTbcasnmo "+
	                     " ( "+
	                      "OID_TBCAS_NMO,"+
	                      "NMONOVEDAD,"+
	                      "NMOORDENPR,"+
	                      "NMOFECHA,"+
	                      "NMOLEGAJO,"+
	                      "ACTIVO,NMOCEX,NOVTIPO,NOVMOTIVO,IDENTIF_NOV_EXT)"+ 
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
		
	     String nolock = "";
	     if (this.isUsarNOLOCKEnImpPlanifRotas(this.getSesion()))
	    	 nolock = " (nolock) ";
	    
		
		NovedadPayroll.truncarTablaNovedades(this.getSesion());
		
		 PreparedStatement querySelect = null;
		 String query = "SELECT a.nmonovedad , a.nmoordenpr , a.nmofecha , a.nmolegajo , a.nmocex , b.novtipo , b.novmotivo FROM "+getPrefijoTablaPAYROLL()+"tbcasnmo a "+nolock+" , "+getPrefijoTablaPAYROLL()+"tbcasnov b "+nolock+" where a.nmonovedad = b.novcodigo "+
		 "and  "+
		 " a.nmofecha>=? and a.nmofecha<=? ";
		 
		 if (aLegajo!=null)
			 query = query +" and RTRIM(LTRIM(nmolegajo))='"+aLegajo.trim()+"'";
		 
		 PreparedStatement qInsert = null;
		 ResultSet rs = null;
		 
		 try {
			 
			 if (fechaActual==null)
				 fechaActual = Fecha.getFechaTruncada(UtilCIP.getFechaHoraActual(this.getSesion()));
			 if (fecDesde==null)
				 fecDesde = Fecha.getFechaDiaAnterior(fechaActual);
			 if (fecHasta==null)
				 fecHasta = Fecha.getFechaMasDias(fechaActual, 5);
			 
			 qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
			 
			 querySelect = conexion.prepareStatement(query);
			 querySelect.setDate(1, new java.sql.Date(fecDesde.getTime()));
			 querySelect.setDate(2, new java.sql.Date(fecHasta.getTime()));
			 
			 
			 
			 rs = querySelect.executeQuery();
			 int x = 0;
			 while (rs.next()) {
				 NovedadPayroll novedad = (NovedadPayroll) NovedadPayroll.getNew(NovedadPayroll.NICKNAME, this.getSesion());
				 novedad.setDesHabEventoWFAfterNew(true);
				 novedad.setNmonovedad(rs.getInt("nmonovedad"));
				 novedad.setNmoordenpr(rs.getInt("nmoordenpr"));
				 novedad.setNmofecha(rs.getDate("nmofecha"));
				 //System.out.println(rs.getDate("nmofecha"));
				 novedad.setNovTipo(rs.getInt("novtipo"));
				 novedad.setNovMotivo(rs.getInt("novmotivo"));
				 // Comentado el 17-12-2013
				 //novedad.setIdentifNovExt(rs.getInt("novtipo")+"_"+rs.getInt("novmotivo"));
				 novedad.setIdentifNovExt(rs.getInt("nmonovedad")+"_"+rs.getInt("nmoordenpr"));
				 
				 String legajo = rs.getString("nmolegajo");
				 
				 if (legajo!=null)
					 novedad.setNmolegajo(legajo.trim().toUpperCase());
				 else
					 novedad.setNmolegajo("");
				 String motivo = rs.getString("nmocex");
				 if (motivo!=null)
					 novedad.setNmoCex(motivo.trim());
				 else
					 novedad.setNmoCex("");
				 
				 novedad.setActivo(true);
				 
				 qInsert.setInt(OID_TBCAS_NMO,secu);
				 if (novedad.getNmonovedad()!=null)
				    	qInsert.setInt(NMONOVEDAD,novedad.getNmonovedad().intValue());
				 else
				    	qInsert.setNull(NMONOVEDAD, Types.INTEGER);
				 if (novedad.getNmoordenpr()!=null)
				    	qInsert.setInt(NMOORDENPR,novedad.getNmoordenpr().intValue());
				 else
				    	qInsert.setNull(NMOORDENPR, Types.INTEGER);
				 if (novedad.getNmofecha()!=null) 
				      qInsert.setDate(NMOFECHA,new java.sql.Date(novedad.getNmofecha().getTime()));
				 else
				      qInsert.setNull(NMOFECHA,java.sql.Types.DATE);
				 if (novedad.getNmolegajo()!=null)
				    	qInsert.setString(NMOLEGAJO,novedad.getNmolegajo());
				 else
				    	qInsert.setNull(NMOLEGAJO,Types.CHAR);
				    
				 if (novedad.getNmoCex()!=null)
				    	qInsert.setString(NMOCEX, novedad.getNmoCex());
				 else
				    	qInsert.setNull(NMOCEX, Types.CHAR);
				    
				 if (novedad.getNovTipo()!=null)
				    	qInsert.setInt(NOV_TIPO, novedad.getNovTipo().intValue());
				 else
				    	qInsert.setNull(NOV_TIPO, Types.INTEGER);
				 
				 if (novedad.getNovMotivo()!=null)
				    	qInsert.setInt(NOV_MOTIVO, novedad.getNovMotivo().intValue());
				 else
				    	qInsert.setNull(NOV_MOTIVO, Types.INTEGER);
				 
				 qInsert.setBoolean(ACTIVO,novedad.isActivo().booleanValue());
				 if (novedad.getIdentifNovExt()!=null)
					 qInsert.setString(IDENTIF_NOV_EXT, novedad.getIdentifNovExt());
				 else
					 qInsert.setNull(IDENTIF_NOV_EXT, Types.VARCHAR);
				 
				 qInsert.executeUpdate();
				 
				 novedad = null;
				 
				 
				 ++secu;
			 }
		 
		 qInsert.close();
		 rs.close();
		 querySelect.close();
		 
		 } catch (SQLException e) {
				// TODO Auto-generated catch block
				throw new ExceptionValidation(null,"Erro al importar TBCASNMO de Payroll. "+e.getMessage()); 
		}
		 
		try {
			conexion.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
		}
		
		 sqlInsert = null;
		 qInsert = null;
		 rs = null;
		 querySelect = null;		
		
	}
	
	public void importarDatosLegRotaFecha(String aLegajo,Connection conexion) throws BaseException {
		
	    final int OID_LEG_ROT_FEC = 1;
	    final int ETRLEGAJO = 2;
	    final int ETRFECHA = 3;
	    final int ETRTRAMO = 4;
	    final int ACTIVO = 5;
		
		LegFecRotPayroll.truncarTablaLegRotFecPayroll(this.getSesion());
		
	    StringBuffer sqlInsert = new StringBuffer();
	    sqlInsert.append(" insert into payLegRotFec "+
	                     " ( "+
	                      "OID_LEG_ROT_FEC,"+
	                      "ETRLEGAJO,"+
	                      "ETRFECHA,"+
	                      "ETRTRAMO,"+
	                      "ACTIVO)"+ 
	                      " values "+ 
	                      "("+
	                      "?,"+
	                      "?,"+
	                      "?,"+
	                      "?,"+
	                      "?) ");
		
		
	     String nolock = "";
	     if (this.isUsarNOLOCKEnImpPlanifRotas(this.getSesion()))
	    	 nolock = " (nolock) ";
	    
		 PreparedStatement querySelect = null;
		 PreparedStatement qInsert = null;
		 ResultSet rs = null;
		 String query = "SELECT etrlegajo , etrfecha, etrtramo FROM "+getPrefijoTablaPAYROLL()+"tbcasetr "+nolock+" where etrfecha>=? and etrfecha<=? ";
		 
		 if (aLegajo!=null)
			 query = query +" and RTRIM(LTRIM(etrlegajo))='"+aLegajo.trim()+"'";
		 
		 try {
			 
			 if (fechaActual==null)
				 fechaActual = Fecha.getFechaTruncada(UtilCIP.getFechaHoraActual(this.getSesion()));
			 if (fecDesde==null)
				 fecDesde = Fecha.getFechaDiaAnterior(fechaActual);
			 if (fecHasta==null)
				 fecHasta = Fecha.getFechaMasDias(fechaActual, 140);
			 
			 qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
			 querySelect = conexion.prepareStatement(query);
			 querySelect.setDate(1, new java.sql.Date(fecDesde.getTime()));
			 querySelect.setDate(2, new java.sql.Date(fecHasta.getTime()));
			 
			 rs = querySelect.executeQuery();
			 int secu = 1;
			 int x = 0;
			 while (rs.next()) {
				 LegFecRotPayroll legFecRotPayroll = (LegFecRotPayroll) LegFecRotPayroll.getNew(LegFecRotPayroll.NICKNAME, this.getSesion());
				 legFecRotPayroll.setDesHabEventoWFAfterNew(true);
				 java.util.Date fecha =  Fecha.getFechaTruncada(rs.getDate("etrfecha"));;
				 if (fecha!=null)
					 fecha = Fecha.getFechaTruncada(fecha);
				 legFecRotPayroll.setEtrfecha(fecha);
				 String legajo = rs.getString("etrlegajo");
				 if (legajo!=null)
					 legFecRotPayroll.setEtrlegajo(legajo.trim().toUpperCase());
				 else
					 legFecRotPayroll.setEtrlegajo("");
				 String tramo = rs.getString("etrtramo");
				 if (tramo!=null)
					 legFecRotPayroll.setEtrtramo(tramo.trim().toUpperCase());
				 else
					 legFecRotPayroll.setEtrtramo("");
				 legFecRotPayroll.setActivo(true);
				 
				 qInsert.setInt(OID_LEG_ROT_FEC,secu);
				 if (legFecRotPayroll.getEtrlegajo()!=null)
				    	qInsert.setString(ETRLEGAJO,legFecRotPayroll.getEtrlegajo());
				 else
				    	qInsert.setNull(ETRLEGAJO,Types.CHAR);
				 if (legFecRotPayroll.getEtrfecha()!=null) 
				      qInsert.setDate(ETRFECHA,new java.sql.Date(legFecRotPayroll.getEtrfecha().getTime()));
				 else
				      qInsert.setNull(ETRFECHA,java.sql.Types.DATE);

				 if (legFecRotPayroll.getEtrtramo()!=null)
				    	qInsert.setString(ETRTRAMO,legFecRotPayroll.getEtrtramo());
				 else
				    	qInsert.setNull(ETRTRAMO,Types.CHAR);
				 qInsert.setBoolean(ACTIVO,legFecRotPayroll.isActivo().booleanValue());
				 qInsert.executeUpdate();
				 ++secu;
				 
				 legFecRotPayroll = null;
				 
				 
		 }
		 
		 qInsert.close();
		 rs.close();
		 querySelect.close();
		 
		 } catch (SQLException e) {
				// TODO Auto-generated catch block
				throw new ExceptionValidation(null,"Erro al importar TBCASETR de Payroll. "+e.getMessage()); 
		}
		 
		try {
			conexion.commit();
		} catch (SQLException e) {
		}
		
		 qInsert = null;
		 rs = null;
		 querySelect = null;
		 sqlInsert = null;
		
		
	}
	
	
	public void importarDatosRTablas(Connection conexion) throws BaseException {
		
	    final int OID_TABLA = 1;
	    final int COTAB = 2;
	    final int CODIGO = 3;
	    final int DESCRIP = 4;
	    final int ACTIVO = 5;
		
		RTablasPayroll.truncarTablaRTablaPayroll(this.getSesion());
		
	    StringBuffer sqlInsert = new StringBuffer();
	    sqlInsert.append(" insert into payRTablas "+
	                     " ( "+
	                      "OID_TABLA,"+
	                      "COTAB,"+
	                      "CODIGO,"+
	                      "DESCRIP,"+
	                      "ACTIVO)"+ 
	                      " values "+ 
	                      "("+
	                      "?,"+
	                      "?,"+
	                      "?,"+
	                      "?,"+
	                      "?) ");
	    
		
		
	     PreparedStatement qInsert = null;
		 Statement stmt = null;
		 ResultSet rs = null;
		 String query = "SELECT COTAB,CODIGO,DESCRIP FROM "+getPrefijoTablaPAYROLL()+"rtablas (nolock) where cotab in ("+this.getINCotabTablasPAYROLL()+") "; //+ "or cotab in (select tnn_cotab from "+getPrefijoTablaPAYROLL()+"tbcastnn NOLOCK) ";
		 try {
			 qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
			 
			 stmt = conexion.createStatement();
			 rs = stmt.executeQuery(query);
			 int x = 0;
			 int secu = 1;
			 while (rs.next()) {
				 RTablasPayroll rtablas = (RTablasPayroll) RTablasPayroll.getNew(RTablasPayroll.NICKNAME, this.getSesion());
				 rtablas.setDesHabEventoWFAfterNew(true);
				 rtablas.setCotab(rs.getInt("cotab"));
				 rtablas.setCodigortabla(rs.getInt("CODIGO"));
				 String descripcion = rs.getString("DESCRIP");
				 if (descripcion!=null)
					 rtablas.setDescrip(descripcion.trim());
				 else
					 rtablas.setDescrip("");
				 rtablas.setActivo(true);
				  
				 qInsert.setInt(OID_TABLA,secu);
				 qInsert.setInt(COTAB,rtablas.getCotab().intValue());
				 qInsert.setInt(CODIGO,rtablas.getCodigortabla().intValue());
				 qInsert.setString(DESCRIP,rtablas.getDescrip());
				 qInsert.setBoolean(ACTIVO,rtablas.isActivo().booleanValue());
				 qInsert.executeUpdate();
				 ++secu;
				 
				 
				 
			 }
		 
		 qInsert.close();
		 rs.close();
		 stmt.close();
		 
		 } catch (SQLException e) {
				// TODO Auto-generated catch block
				throw new ExceptionValidation(null,"Erro al importar las RTABLAS de Payroll. "+e.getMessage()); 
		}
		 
		try {
			conexion.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
		}
		
		 sqlInsert = null;
		 qInsert = null;
		 rs = null;
		 stmt = null;		
		
		
	}
	
	public void importarDatosTBCASTNN(Connection conexion) throws BaseException {
		
	    final int OID_TNN = 1;
	    final int TNNCODIGO = 2;
	    final int TNNDESCRIP = 3;
	    final int TNN_COTAB = 4;
	    final int ACTIVO = 5;
		
	    StringBuffer sqlInsert = new StringBuffer();
	    sqlInsert.append(" insert into PayTbcasTNN "+
	                     " ( "+
	                      "OID_TNN,"+
	                      "TNNCODIGO,"+
	                      "TNNDESCRIP,"+
	                      "TNN_COTAB,ACTIVO)"+ 
	                      " values "+ 
	                      "("+
	                      "?,"+
	                      "?,"+
	                      "?,"+
	                      "?,"+
	                      "?) ");
	    
	   	    
	    
		 Statement stmt = null;
		 String query = "SELECT tnncodigo,tnndescrip,tnn_cotab FROM "+getPrefijoTablaPAYROLL()+"tbcastnn (nolock) ";
		 try {
			 
			StringBuffer sqlUpdate = new StringBuffer();
			sqlUpdate.append("truncate table PayTbcasTNN ");
			PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
			qUpdate.executeUpdate();
			qUpdate.close();
			 
			 
			 PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
			 stmt = conexion.createStatement();
			 ResultSet rs = stmt.executeQuery(query);
			 int secu = 1;
			 while (rs.next()) {
				 
				 qInsert.setInt(OID_TNN,secu);
				 qInsert.setInt(TNNCODIGO,rs.getInt("tnncodigo"));
				 qInsert.setString(TNNDESCRIP, rs.getString("tnndescrip"));
				 qInsert.setInt(TNN_COTAB,rs.getInt("tnn_cotab"));
				 qInsert.setBoolean(ACTIVO, true);
				 qInsert.executeUpdate();
				 
				 ++secu;
				 
			 }
		 
		 qInsert.close();
		 rs.close();
		 stmt.close();
		 
		 } catch (SQLException e) {
				// TODO Auto-generated catch block
				throw new ExceptionValidation(null,"Erro al importar las TBCASTNN de Payroll. "+e.getMessage()); 
		}
		 
		try {
			conexion.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
		}
		
	}
	
	
	
	
	public void importarDatosRota(Connection conexion) throws BaseException {
		
	    final int OID_ROTA = 1;
	    final int TRACODIGO = 2;
	    final int TRADESCRIP = 3;
	    final int TRAHORAINI = 4;
	    final int TRAHORAFIN = 5;
	    final int ACTIVO = 6;
		
	    StringBuffer sqlInsert = new StringBuffer();
	    sqlInsert.append(" insert into payRotas "+
	                     " ( "+
	                      "OID_ROTA,"+
	                      "TRACODIGO,"+
	                      "TRADESCRIP,"+
	                      "TRAHORAINI,"+
	                      "TRAHORAFIN,"+
	                      "ACTIVO)"+ 
	                      " values "+ 
	                      "("+
	                      "?,"+
	                      "?,"+
	                      "?,"+
	                      "?,"+
	                      "?,"+
	                      "?) ");
	    
	    
		RotaPayroll.truncarTablaRotaPayroll(this.getSesion());
		
		 Statement stmt = null;
		 ResultSet rs = null;
		 PreparedStatement qInsert = null;
		 String query = "SELECT tracodigo,tradescrip,trahoraini,trahorafin FROM "+getPrefijoTablaPAYROLL()+"tbcastra (nolock) ";
		 try {
			 
			 qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
			 stmt = conexion.createStatement();
			 rs = stmt.executeQuery(query);
			 int secu = 1;
			 int x = 0;
			 while (rs.next()) {
				 RotaPayroll rota = (RotaPayroll) RotaPayroll.getNew(RotaPayroll.NICKNAME, this.getSesion());
				 rota.setDesHabEventoWFAfterNew(true);
				 String codigo = rs.getString("tracodigo");
				 if (codigo!=null)
					 rota.setTracodigo(codigo.trim().toUpperCase());
				 else
					 rota.setTracodigo("");
				 String descripcion = rs.getString("tradescrip");
				 if (descripcion!=null)
					 rota.setTradescrip(descripcion.trim());
				 else
					 rota.setTradescrip("");
				 String horaIni = rs.getString("trahoraini");
				 if (horaIni!=null)
					 rota.setTrahoraini(horaIni);
				 else
					 rota.setTrahoraini("");
				 String horaFin = rs.getString("trahorafin");
				 if (horaFin!=null)
					 rota.setTrahorafin(horaFin);
				 else
					 rota.setTrahorafin("");
				 rota.setActivo(true);
				 
				 qInsert.setInt(OID_ROTA,secu);
				 qInsert.setString(TRACODIGO,rota.getTracodigo());
				 qInsert.setString(TRADESCRIP,rota.getTradescrip());
				 qInsert.setString(TRAHORAINI,rota.getTrahoraini());
				 qInsert.setString(TRAHORAFIN,rota.getTrahorafin());
				 qInsert.setBoolean(ACTIVO,rota.isActivo().booleanValue());
				 qInsert.executeUpdate();
				 
				 ++secu;
				 
				 
				 
			 }
		 
		 qInsert.close();
		 rs.close();
		 stmt.close();
		 
		 } catch (SQLException e) {
				// TODO Auto-generated catch block
				throw new ExceptionValidation(null,"Erro al importar las ROTAS de Payroll. "+e.getMessage()); 
		}
		 
		try {
			conexion.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
		}
		
		 qInsert = null;
		 rs = null;
		 stmt = null;
		 sqlInsert = null;
		
		
	}
	
	public void importarDatosEmpresa(Connection conexion) throws BaseException {
		 EmpresaPayroll.truncarTablaEmpresaPayroll(this.getSesion()); 
		 
		    final int OID_EMPRESA = 1;
		    final int EMPRESA = 2;
		    final int NOMBRE = 3;
		    final int ACTIVO = 4;


		    StringBuffer sqlInsert = new StringBuffer();
		    sqlInsert.append(" insert into payEmpresa "+
		                     " ( "+
		                      "OID_EMPRESA,"+
		                      "EMPRESA,"+
		                      "NOMBRE,"+
		                      "ACTIVO)"+ 
		                      " values "+ 
		                      "("+
		                      "?,"+
		                      "?,"+
		                      "?,"+
		                      "?) ");
		  
			
		 Statement stmt = null;
		 ResultSet rs = null;
		 String query = "SELECT empresa,nombre FROM "+getPrefijoTablaPAYROLL()+"REMPRESA (nolock) ";
		 try {
			 
			 PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
			 stmt = conexion.createStatement();
			 rs = stmt.executeQuery(query);
			 int secu = 1;
			 while (rs.next()) {
				 EmpresaPayroll empresa = (EmpresaPayroll) EmpresaPayroll.getNew(EmpresaPayroll.NICKNAME, this.getSesion());
				 empresa.setDesHabEventoWFAfterNew(true);
				 String empresa1 = rs.getString("empresa");
				 if (empresa1!=null)
					 empresa.setEmpresa(empresa1.trim().toUpperCase());
				 else
					 empresa.setEmpresa("");
				 String rsocial = rs.getString("nombre");
				 if (rsocial!=null)
					 empresa.setNombre(rsocial.trim());
				 else
					 empresa.setNombre("");
				 empresa.setActivo(true);
			     
				 qInsert.setInt(OID_EMPRESA,secu);
				 qInsert.setString(EMPRESA,empresa.getEmpresa());
				 qInsert.setString(NOMBRE,empresa.getNombre());
				 qInsert.setBoolean(ACTIVO,empresa.isActivo().booleanValue());
				 qInsert.executeUpdate();
				 //qInsert.close();
				 ++secu;
			 }
		 
		 qInsert.close();
		 rs.close();
		 stmt.close();
		 
		 } catch (SQLException e) {
				// TODO Auto-generated catch block
				throw new ExceptionValidation(null,"Erro al importar EMPRESA de Payroll. "+e.getMessage()); 
		}
					 
		try {
			conexion.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
		}
		
		sqlInsert = null;
		stmt = null;		
		rs = null;
		query = null;
	}
	
	public void importarDatosRemples(String legajo,Connection conexion) throws BaseException {
		
         final int OID_REMPLES = 1;
	     final int EMPRESA = 2;
	     final int CODIGO = 3;
	     final int NOMBRE = 4;
	     final int ESTADO = 5;
	     final int FECHA_ING = 6;
	     final int FECHA_RET = 7;
	     final int CENCOS = 8;
	     final int ACTIVO = 9;
 	     final int CREDENC = 10;
 	     final int CARGO = 11;
		
		
	     StringBuffer sqlInsert = new StringBuffer();
	     sqlInsert.append(" insert into payRemples "+
	                      " ( "+
	                       "OID_REMPLES,"+
	                       "EMPRESA,"+
	                       "CODIGO,"+
	                       "NOMBRE,"+
	                       "ESTADO,"+
	                       "FECHA_ING,"+
	                       "FECHA_RET,"+
	                       "CENCOS,"+
	                       "ACTIVO,CREDENC,CARGO)"+ 
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
	     
		
		 RemplesPayroll.truncarTablaRemplesPayroll(this.getSesion()); 
		 int secu = 1;
		 Statement stmt = null;
		 String query = "SELECT empresa,codigo,nombre,estado , fecha_ing, fecha_ret , cencos , credenc , cargo FROM "+getPrefijoTablaPAYROLL()+"remples (nolock) where RTRIM(LTRIM(EMPRESA)) IN ("+getINEmpresasLegajoPAYROLL()+")";
		 PreparedStatement qInsert = null;
		 ResultSet rs = null;
		 
		 if (legajo!=null)
			 query = query + " and RTRIM(LTRIM(codigo))='"+legajo.trim()+"'" ;  
		 
		 try {
			 int x = 0;
			 
			 qInsert = this.getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
			 stmt = conexion.createStatement();
			 rs = stmt.executeQuery(query);
			 while (rs.next()) {
				 ++x;
				 
				 
				 
				 RemplesPayroll remples = (RemplesPayroll) RemplesPayroll.getNew(RemplesPayroll.NICKNAME, this.getSesion());
				 remples.setDesHabEventoWFAfterNew(true);
				 String empresa = rs.getString("empresa");
				 if (empresa!=null)
					 remples.setEmpresa(empresa.trim().toUpperCase());
				 else
					 remples.setEmpresa("");
				 String codigo = rs.getString("codigo");
				 
				 
				 
				 if (codigo!=null) {
					 remples.setCodigo(codigo.trim().toUpperCase());					 
				 }
				 else
					 remples.setCodigo("");
				 
				 
				 
				 //if (remples.getCodigo().equals("6666")) continue; // SUSPENDIDO
				 
				 String nombre = rs.getString("nombre");
				 if (nombre!=null)
					 remples.setNombre(nombre.trim());
				 else
					 remples.setNombre("");
				 String estado = rs.getString("estado");
				 if (estado!=null)
					 remples.setEstado(estado.trim().toUpperCase());
				 else
					 remples.setEstado("");
				 String credenc = rs.getString("credenc");
				 if (credenc!=null)
					 remples.setCredenc(credenc.trim());
				 else
					 remples.setCredenc("");
				 remples.setFecha_ing(rs.getDate("fecha_ing"));
			     remples.setFecha_ret(rs.getDate("fecha_ret"));
			     remples.setCencos(rs.getInt("cencos"));
			     remples.setCargo(rs.getInt("cargo"));
			     remples.setActivo(true);
			     
			     
			     // Ejecutar la senetencia de INSERT
			     
			     qInsert.setInt(OID_REMPLES,secu);
			     if (remples.getEmpresa()!=null)
			     	qInsert.setString(EMPRESA,remples.getEmpresa());
			     else
			     	qInsert.setNull(EMPRESA,Types.VARCHAR);
			     if (remples.getCodigo()!=null)
			     	qInsert.setString(CODIGO,remples.getCodigo());
			     else
			     	qInsert.setNull(CODIGO,Types.VARCHAR);
			     if (remples.getNombre()!=null)
			     	qInsert.setString(NOMBRE,remples.getNombre());
			     else
			     	qInsert.setNull(NOMBRE,Types.VARCHAR);
			     if (remples.getEstado()!=null)
			     	qInsert.setString(ESTADO,remples.getEstado());
			     else
			     	qInsert.setNull(ESTADO,Types.VARCHAR);
			     if (remples.getFecha_ing()!=null) 
			       qInsert.setDate(FECHA_ING,new java.sql.Date(remples.getFecha_ing().getTime()));
			     else
			       qInsert.setNull(FECHA_ING,java.sql.Types.DATE);
			     if (remples.getFecha_ret()!=null) 
			       qInsert.setDate(FECHA_RET, new java.sql.Date(remples.getFecha_ret().getTime()));
			     else
			       qInsert.setNull(FECHA_RET,java.sql.Types.DATE);
			     if (remples.getCencos()!=null)
			     	qInsert.setInt(CENCOS,remples.getCencos().intValue());
			     else
			     	qInsert.setNull(CENCOS,Types.INTEGER);
			     qInsert.setBoolean(ACTIVO,remples.isActivo().booleanValue());
			     if (remples.getCredenc()!=null)
			     	qInsert.setString(CREDENC, remples.getCredenc());
			     else
			     	qInsert.setNull(CREDENC, Types.CHAR);
				 qInsert.setInt(CARGO,remples.getCargo());
			     
			     qInsert.executeUpdate();
			     ++secu;
			     
			     remples = null;
			     
			 }
		 
		 qInsert.close();	 
		 rs.close();
		 stmt.close();
		 
		 } catch (SQLException e) {
				// TODO Auto-generated catch block
				throw new ExceptionValidation(null,"Error al importar REMPLES de Payroll. "+e.getMessage()); 
		}
		
		 
		 
		try {
			this.getSesion().getConexionBD().commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new ExceptionValidation(null, e.getMessage());
		}
		
		 rs = null;
		 stmt = null;
		 query = null;
		 qInsert = null;		
		
					 
	}
	
	public void cerrarConexionPayroll(Connection conexion) throws BaseException {
		try {
			conexion.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new ExceptionValidation(null,"No se pudo cerrar la conexion a PAYROLL");
		}
	}
	
	
	public Connection conectarSQLServer() throws BaseException {
		
		String connectionUrl = "jdbc:sqlserver://"+this.getServerNamePAYROLL()+":"+this.getPortBDPAYROLL()+";" +
		   "databaseName="+this.getDataBasePAYROLL()+";user="+this.getUserPAYROLL()+";password="+this.getPasswordPAYROLL()+";";
		Connection con = null;
		boolean error = false;
		String mensError = "";
		try {
			con = DriverManager.getConnection(connectionUrl);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			error = true;
			mensError = e1.getMessage();
		}		
		
		try {
			if (error) throw new ExceptionValidation(null,mensError);
			return con;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new ExceptionValidation(null,"No se pudo conectar al Servidor de Base de Datos de PAYROLL."+e.getMessage());
		}
		
	}
	
	/*
	public Connection conectarSQLServer() throws BaseException {
		
		java.util.Properties prop = new java.util.Properties ();
		dataSource.setServerName(this.getServerNamePAYROLL());
		dataSource.setPortNumber(this.getPortBDPAYROLL());
		dataSource.setDatabaseName(this.getDataBasePAYROLL());
		dataSource.setIntegratedSecurity(false);
		dataSource.setUser(this.getUserPAYROLL());
		dataSource.setPassword(this.getPasswordPAYROLL());
		try {
			return dataSource.getConnection();
		} catch (SQLServerException e) {
			// TODO Auto-generated catch block
			throw new ExceptionValidation(null,"No se pudo conectar al Servidor de Base de Datos de PAYROLL."+e.getMessage());
		}
	}*/

	private String getPrefijoTablaPAYROLL() throws BaseException {
		return ValorParametro.findByCodigoParametro("PREF_TAB_BD_PAYROLL", this.getSesion()).getValorCadena();
	}
	
	private String getServerNamePAYROLL() throws BaseException {
		return ValorParametro.findByCodigoParametro("SERVER_BD_PAYROLL", this.getSesion()).getValorCadena();
	}
	
	private Integer getPortBDPAYROLL() throws BaseException {
		return ValorParametro.findByCodigoParametro("PORT_BD_PAYROLL", this.getSesion()).getValorEntero();
	}
	
	private String getDataBasePAYROLL() throws BaseException {
		return ValorParametro.findByCodigoParametro("DATABASE_BD_PAYROLL", this.getSesion()).getValorCadena();
	}
	
	private String getUserPAYROLL() throws BaseException {
		return ValorParametro.findByCodigoParametro("USER_BD_PAYROLL", this.getSesion()).getValorCadena();
	}
	
	private String getPasswordPAYROLL() throws BaseException {
		return ValorParametro.findByCodigoParametro("PASSWORD_BD_PAYROLL", this.getSesion()).getValorCadena();
	}
	
	private String getINCotabTablasPAYROLL() throws BaseException {
		return ValorParametro.findByCodigoParametro("IN_COTAB_RTABLAS_PAYROLL", this.getSesion()).getValorCadena();
	}
	
	private String getINEmpresasLegajoPAYROLL() throws BaseException {
		return ValorParametro.findByCodigoParametro("IN_EMPRESAS_LEG_PAYROLL", this.getSesion()).getValorCadena();
	}
	
	private int getNroCotabCECORtablas() throws BaseException {
		return ValorParametro.findByCodigoParametro("NRO_COTAB_CECO_RTABLAS_HIP", this.getSesion()).getValorEntero();
	}
	
	
	
	
	private GrupoPuerta getGrupoPuertaIngreso(ISesion aSesion)
	throws BaseException {
		Integer oid = ValorParametro.findByCodigoParametro(
				"GRUPO_PUE_ING_HIP", aSesion).getOidObjNeg();
		GrupoPuerta grupoPuerta = GrupoPuerta.findByOid(oid, aSesion);
		return grupoPuerta;
	}
	
	private MotivosNovCIP getMotivoNoEncontrado(ISesion aSesion)
	throws BaseException {
		Integer oid = ValorParametro.findByCodigoParametro(
				"MOTDESCIMPNOVCAS", aSesion).getOidObjNeg();
		MotivosNovCIP motivo = MotivosNovCIP.findByOid(oid, aSesion);
		return motivo;
	}
	
	
	
	
	private GrupoPuerta getGrupoPuertaEgreso(ISesion aSesion)
	throws BaseException {
		Integer oid = ValorParametro.findByCodigoParametro(
				"GRUPO_PUE_EGR_HIP", aSesion).getOidObjNeg();
		GrupoPuerta grupoPuerta = GrupoPuerta.findByOid(oid, aSesion);
		return grupoPuerta;
	}
	
	private ClasificadorEntidad getClasificadorEmpresa(ISesion aSesion) throws BaseException {
		Integer oid = ValorParametro.findByCodigoParametro(
				"CLASIF_EMPRESA_HIP", aSesion).getOidObjNeg();
		ClasificadorEntidad clasificador = ClasificadorEntidad.findByOid(oid, aSesion);
		return clasificador;
	}
	
	private ClasificadorEntidad getClasificadorCECO(ISesion aSesion) throws BaseException {
		Integer oid = ValorParametro.findByCodigoParametro(
				"CLASIF_CECO_HIP", aSesion).getOidObjNeg();
		ClasificadorEntidad clasificador = ClasificadorEntidad.findByOid(oid, aSesion);
		return clasificador;
	}
	
	
	private boolean isUsarNOLOCKEnImpPlanifRotas(ISesion aSesion) throws BaseException {
		String  resp = ValorParametro.findByCodigoParametro(
				"USAR_NOLOCK_HIPO_PLANIROT", aSesion).getValorCadena();
		if ((resp!=null) && (resp.toLowerCase().startsWith("s")))
			return true;
		else
			return false;
	}

	private boolean isUsarNOLOCKEnImpNovedades(ISesion aSesion) throws BaseException {
		String  resp = ValorParametro.findByCodigoParametro(
				"USAR_NOLOCK_HIPO_NOVEADES", aSesion).getValorCadena();
		if ((resp!=null) && (resp.toLowerCase().startsWith("s")))
			return true;
		else
			return false;
	}

	
	private int getMinEntDespuesRota() throws BaseException {
		try {
			return ValorParametro.findByCodigoParametro("MIN_ENT_DES_ROTA_HIP", this.getSesion()).getValorEntero();
		} catch (Exception e) {
			return 0;
		}
	}
	
	private int getMinEntAntesRota() throws BaseException {
		try {
			return ValorParametro.findByCodigoParametro("MIN_ENT_ANT_ROTA_HIP", this.getSesion()).getValorEntero();
		} catch (Exception e) {
			return 0;
		}
	}
	
	
}
