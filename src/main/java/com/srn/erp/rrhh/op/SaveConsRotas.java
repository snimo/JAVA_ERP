package com.srn.erp.rrhh.op;

import com.srn.erp.cip.bm.Rota;
import com.srn.erp.cip.bm.UtilCIP;
import com.srn.erp.rrhh.bm.FiltroLegCab;
import com.srn.erp.rrhh.bm.GrabarConsRotasCab;
import com.srn.erp.rrhh.bm.GrabarConsRotasDet;
import com.srn.erp.sueldos.bm.Legajo;

import framework.applicarionServer.bl.Utils.Fecha;
import framework.applicarionServer.bm.Seguridad.Usuario;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class SaveConsRotas extends Operation { 

  public SaveConsRotas() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    IDataSet dsInput = mapaDatos.getDataSet("TInput");
    IDataSet dsConsPlanif = mapaDatos.getDataSet("TEnviar");

    procesarRegistros(dsInput,dsConsPlanif);
    
  }
    

  private void procesarRegistros(IDataSet dsInput,IDataSet dsConsPlanif) throws BaseException {
	  
	  GrabarConsRotasCab grabarConsRotasCab = null;
	  HashTableDatos diasFechas = new HashTableDatos();
	  	  
	  
	  dsInput.first();
	  while (!dsInput.EOF()) {
		  
		  FiltroLegCab filtro = FiltroLegCab.findByOid(dsInput.getInteger("oid_filtro"),this.getSesion());
		  java.util.Date fecDesde = dsInput.getDate("fec_desde");
		  java.util.Date fecHasta = dsInput.getDate("fec_hasta");
		  Rota rota = Rota.findByOid(dsInput.getInteger("oid_rota"), this.getSesion());
		  String juegos = dsInput.getString("juego");
		  Integer dias = dsInput.getInteger("dias");
		  Boolean exlSiTieneNov = dsInput.getBoolean("exc_si_tiene_nov");
		  String descripcion = dsInput.getString("grabar_nombre");
		  
		  
		  // En base a la fecha Desde generar los proximos 8 Dias
		  int i=1;
		  java.util.Date fecha = Fecha.getFechaDiaAnterior(fecDesde);  
		  for (i=1;i<=8;++i) {
			  
			  fecha  = Fecha.getFechaDiaPosterior(fecha);
			  
			  diasFechas.put(new Integer(i), fecha);
			  
		  }
		  
		  grabarConsRotasCab = 
			  (GrabarConsRotasCab)GrabarConsRotasCab.getNew(GrabarConsRotasCab.NICKNAME, this.getSesion());
		  grabarConsRotasCab.setFiltro(filtro);
		  grabarConsRotasCab.setFec_desde(fecDesde);
		  grabarConsRotasCab.setFec_hasta(fecHasta);
		  grabarConsRotasCab.setRota(rota);
		  grabarConsRotasCab.setJuegos_sep_por_comas(juegos);
		  grabarConsRotasCab.setNo_most_si_franco(exlSiTieneNov);
		  grabarConsRotasCab.setDias(dias);
		  grabarConsRotasCab.setUsuario(Usuario.findByOidProxy(this.getSesion().getLogin().getUsuario().getOIDInteger(), this.getSesion()));
		  grabarConsRotasCab.setFecha_grab(Fecha.getFechaTruncada(UtilCIP.getFechaHoraActual(this.getSesion())));
		  grabarConsRotasCab.setHora_grab(UtilCIP.getHHMM(UtilCIP.getFechaHoraActual(this.getSesion())));
		  grabarConsRotasCab.setActivo(true);
		  grabarConsRotasCab.setDescripcion(descripcion);
		  
		  dsInput.next();
	  }
	  
	  boolean firstTime = true;
	  dsConsPlanif.first();
	  while (!dsConsPlanif.EOF()) {
		  
		  if ((grabarConsRotasCab!=null) && (firstTime)) {
			  grabarConsRotasCab.setAgrupador(dsConsPlanif.getString("agrupador"));
			  grabarConsRotasCab.setNroConsulta(dsConsPlanif.getInteger("nro_consulta"));
			  
			  firstTime = false;
		  }
		  
		  Legajo legajo = Legajo.findByOidProxy(dsConsPlanif.getInteger("oid_legajo"), this.getSesion());
		  String novedad = dsConsPlanif.getString("novedad");
		  String novDia1 = dsConsPlanif.getString("nov_dia_1");
		  String novDia2 = dsConsPlanif.getString("nov_dia_2");
		  String novDia3 = dsConsPlanif.getString("nov_dia_3");
		  String novDia4 = dsConsPlanif.getString("nov_dia_4");
		  String novDia5 = dsConsPlanif.getString("nov_dia_5");
		  String novDia6 = dsConsPlanif.getString("nov_dia_6");
		  String novDia7 = dsConsPlanif.getString("nov_dia_7");
		  
		  int i = 1;
		  for (i=1;i<=8;++i) {
			  
			  String leyendaRota = "";
			  java.util.Date fecha = (java.util.Date) diasFechas.get(new Integer(i));
			  
			  switch(i) {
			  case 1: {
				  		leyendaRota = novedad;
				  		break;
			  		}
			  case 2: {
				  leyendaRota = novDia1;
				  break;
			  }
			  case 3: {
				  leyendaRota = novDia2;
				  break;
			  }
			  case 4: {
				  leyendaRota = novDia3;
				  break;
			  }
			  case 5: {
				  leyendaRota = novDia4;
				  break;
			  }
			  case 6: {
				  leyendaRota = novDia5;
				  break;
			  }
			  case 7: {
				  leyendaRota = novDia6;
				  break;
			  }
			  case 8: {
				  leyendaRota = novDia7;
				  break;
			  }
			  }
			  
			  GrabarConsRotasDet grabarConsRotasDet = 
				  (GrabarConsRotasDet) GrabarConsRotasDet.getNew(GrabarConsRotasDet.NICKNAME, this.getSesion());
			  grabarConsRotasDet.setGrab_cons_rota(grabarConsRotasCab);
			  grabarConsRotasDet.setLegajo(legajo);
			  grabarConsRotasDet.setFecha(fecha);
			  grabarConsRotasDet.setRota(leyendaRota);
			  grabarConsRotasDet.setActivo(true);
			  
			  grabarConsRotasCab.addConsultaRotaDet(grabarConsRotasDet);
			  
		  }		  
		  
		  dsConsPlanif.next();
	  }	  

	  if (grabarConsRotasCab!=null)
		  grabarConsRotasCab.save();
	  
	    IDataSet ds = this.getDataSetNovConsRota();
	    if (grabarConsRotasCab!=null) {
	    		ds.append();
	    		if (grabarConsRotasCab.getNroConsulta()!=null)
	    			ds.fieldValue("oid", grabarConsRotasCab.getNroConsulta());
	    		else
	    			ds.fieldValue("oid", 0);
	    }
	    writeCliente(ds);
	  
	  
  }
  
	private IDataSet getDataSetNovConsRota() {
		IDataSet dataset = new TDataSet();
		dataset.create("TNroConsultaGrabada");
		dataset.fieldDef(new Field("oid", Field.INTEGER, 0));
		return dataset;
	}  
  
  
}
