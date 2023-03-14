package com.srn.erp.excluidos.op;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.srn.erp.excluidos.bm.AlturaExcluido;
import com.srn.erp.excluidos.bm.ArchExcImpTablet;
import com.srn.erp.excluidos.bm.ColorCabelloExcluido;
import com.srn.erp.excluidos.bm.ComplexionExcluido;
import com.srn.erp.excluidos.bm.DispMovilExc;
import com.srn.erp.excluidos.bm.EdadExcluido;
import com.srn.erp.excluidos.bm.EstadoExcluido;
import com.srn.erp.excluidos.bm.GrupoImportacionExcluido;
import com.srn.erp.excluidos.bm.IndividuoExcluido;
import com.srn.erp.excluidos.bm.LogSincroExcluido;
import com.srn.erp.excluidos.bm.NovedadExcluido;
import com.srn.erp.excluidos.bm.PeligrosidadExcluido;
import com.srn.erp.excluidos.bm.PresentacionClienteExcluido;
import com.srn.erp.excluidos.bm.RazaExcluido;

import framework.applicarionServer.bl.Utils.Fecha;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class GenerarArchJSONExc extends Operation {

	
	public GenerarArchJSONExc() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		
		DispMovilExc dispMovil = null;
		if (mapaDatos.containsKey("oid_disp_movil")) {
			Integer oidDispMovil = mapaDatos.getInteger("oid_disp_movil");
			dispMovil = DispMovilExc.findByOid(oidDispMovil, this.getSesion());
		} else if (mapaDatos.containsKey("cod_disp_movil")) {
			String codDispMovil = mapaDatos.getString("cod_disp_movil");
			dispMovil = DispMovilExc.findByCodigo(codDispMovil, this.getSesion());
		}
		
		Integer ultNroLoteSinc = -1;
		
		if (dispMovil==null)
			throw new ExceptionValidation(null,"No se encontro un dispositivo móvil con ese código");
		
		if (dispMovil.isForzar_sinc_all() || dispMovil.isForzarSiempreSinc())
			ultNroLoteSinc = -1;
		else if (mapaDatos.containsKey("ult_nro_lote_sinc"))
				ultNroLoteSinc = mapaDatos.getInteger("ult_nro_lote_sinc");
		else if (mapaDatos.containsKey("nro_lote"))
			ultNroLoteSinc = mapaDatos.getInteger("nro_lote");
		
		List listaArchJSON = new ArrayList();
		
		GrupoImportacionExcluido grupoImpExc = dispMovil.getGrupo_importacion();
		
		if (grupoImpExc == null)
			throw new ExceptionValidation(null,"No se encuentra asignado grupo de importación al dispositivo");
		
		
		ArchExcImpTablet archExcImpTablet = new ArchExcImpTablet();
		listaArchJSON.add(archExcImpTablet);
		
		Integer nroImp = IndividuoExcluido.getMaxNroLoteSinc(this.getSesion()); 
		archExcImpTablet.getImportacionExcluido().setNroLote(nroImp.toString());
		String fecha = Fecha.getddmmyyyy(new Date());
		String hora = Fecha.getFormatoHoraMin(new Date());
		archExcImpTablet.getImportacionExcluido().setFecha(fecha);
		archExcImpTablet.getImportacionExcluido().setHora(hora);
		archExcImpTablet.getImportacionExcluido().setCodigoImportacion("IMPO");
		if ((dispMovil.isForzar_sinc_all()) || (ultNroLoteSinc==-1) || (dispMovil.isForzarSiempreSinc()))
			archExcImpTablet.getImportacionExcluido().setEliminarTodo("si");
		else
			archExcImpTablet.getImportacionExcluido().setEliminarTodo("no");
				
		
		IDataSet dsArchABajar = this.getDataSetArchABajar();
		IDataSet deArchJSON   = this.getDataSetArchJSON();
		
		// Se modifico para tambien devuelva los atributos cuando son nulos
		Gson datosJson = new GsonBuilder().serializeNulls().create();
		//Se comento porque cuando el valor es nulo no devuelve el atributo
		//Gson datosJson = new Gson();
		int cantIndi = 0;
		

				
		String pathArchivos = IndividuoExcluido.getPathImagenPrincipalIndividuo(this.getSesion());
		
		boolean hayNovAIncluir = false;
		boolean hayNovAExcluir = false;
		
		Iterator iterIndividuos = null;
		iterIndividuos = (Iterator) IndividuoExcluido.getAllByGrupoImportacion(this.getSesion(),grupoImpExc,IndividuoExcluido.CON_NOV_EN_CONSULTA,ultNroLoteSinc).iterator();
		while (iterIndividuos.hasNext()) {
			
			hayNovAIncluir = true;
			
			if (cantIndi>1000) {
				cantIndi = 0;
				archExcImpTablet = new ArchExcImpTablet();
				archExcImpTablet.getImportacionExcluido().setNroLote(nroImp.toString());
				archExcImpTablet.getImportacionExcluido().setFecha(fecha);
				archExcImpTablet.getImportacionExcluido().setHora(hora);
				archExcImpTablet.getImportacionExcluido().setCodigoImportacion("IMPO");
				if ((dispMovil.isForzar_sinc_all()) || (ultNroLoteSinc==-1))
					archExcImpTablet.getImportacionExcluido().setEliminarTodo("si");
				else
					archExcImpTablet.getImportacionExcluido().setEliminarTodo("no");
				
				listaArchJSON.add(archExcImpTablet);
			}
			
			IndividuoExcluido individuo = (IndividuoExcluido) iterIndividuos.next();
			PresentacionClienteExcluido presentacionCliente =  getNewCliente(individuo,pathArchivos,dsArchABajar);
			archExcImpTablet.addPresentacionCliente(presentacionCliente);
				
			++cantIndi;
			
		}
		
		// Novedades a excluir
		if (ultNroLoteSinc!=-1) {
			Iterator iterIndiConNovAExcluir = (Iterator) IndividuoExcluido.getAllByGrupoImportacion(this.getSesion(),grupoImpExc,IndividuoExcluido.CON_NOV_FUERA_CONSULTA,ultNroLoteSinc).iterator();
			while (iterIndiConNovAExcluir.hasNext()) {
			
				hayNovAExcluir = true;
			
				IndividuoExcluido individuo = (IndividuoExcluido) iterIndiConNovAExcluir.next();
				PresentacionClienteExcluido presentacionCliente =  getNewCliente(individuo,pathArchivos,null);
				// 	Marcar para borrar registro en la TABLET y no bajar las fotos
				presentacionCliente.setOper("B");
				presentacionCliente.setFoto1("");
				presentacionCliente.setFoto2("");
				presentacionCliente.setFoto3("");
				archExcImpTablet.addPresentacionCliente(presentacionCliente);			
			}
		}
		
		// Crear un cliente DUMMY con ID -1 que deberia ser ignorado del lado de la tablet (Se manda en estado Baja)
		if ((!hayNovAIncluir) && (!hayNovAExcluir)) 
			archExcImpTablet.addPresentacionCliente(getNewClienteDummy());
		
		// Cargar Estados
		Iterator iterEstados = 
			EstadoExcluido.getAllActivos(this.getSesion()).iterator();
		while (iterEstados.hasNext()) {
			EstadoExcluido estadoExcluido = (EstadoExcluido) iterEstados.next();
			if (estadoExcluido.isPublicarEnFiltro())
				archExcImpTablet.addEstadoExcluido(estadoExcluido);
		}
		
				
		// Cargar Peligrosidades
		Iterator iterPeligrosidades = 
			PeligrosidadExcluido.getAllActivos(this.getSesion()).iterator();
		while (iterPeligrosidades.hasNext()) {
			PeligrosidadExcluido peligrosidad = (PeligrosidadExcluido) iterPeligrosidades.next();
			archExcImpTablet.addPeligrosidad(peligrosidad);
		}		
		
		// Cargar Razas
		Iterator iterRazas = 
			RazaExcluido.getAllActivos(this.getSesion()).iterator();
		while (iterRazas.hasNext()) {
			RazaExcluido raza = (RazaExcluido) iterRazas.next();
			archExcImpTablet.addRaza(raza);
		}		
		
		// Cargar Alturas
		Iterator iterAlturas = 
			AlturaExcluido.getAllActivos(this.getSesion()).iterator();
		while (iterAlturas.hasNext()) {
			AlturaExcluido altura = (AlturaExcluido) iterAlturas.next();
			archExcImpTablet.addAltura(altura);
		}		
		
		// Cargar Complexion
		Iterator iterComplexion = 
			ComplexionExcluido.getAllActivos(this.getSesion()).iterator();
		while (iterComplexion.hasNext()) {
			ComplexionExcluido complexion = (ComplexionExcluido) iterComplexion.next();
			archExcImpTablet.addComplexion(complexion);
		}		
		
		// Cargar Edades
		Iterator iterEdades = 
			EdadExcluido.getAllActivos(this.getSesion()).iterator();
		while (iterEdades.hasNext()) {
			EdadExcluido edad = (EdadExcluido) iterEdades.next();
			archExcImpTablet.addEdad(edad);
		}		
		
		// Cargar Colores Cabello
		Iterator iterColoresCabello = 
			ColorCabelloExcluido.getAllActivos(this.getSesion()).iterator();
		while (iterColoresCabello.hasNext()) {
			ColorCabelloExcluido color = (ColorCabelloExcluido) iterColoresCabello.next();
			archExcImpTablet.addColorCabello(color);
		}		
		
		archExcImpTablet.addSexo(IndividuoExcluido.SEXO_M, "Masculino");
		archExcImpTablet.addSexo(IndividuoExcluido.SEXO_F, "Femenino");
		archExcImpTablet.addSexo(IndividuoExcluido.SEXO_T, "Travesti");
		
		
		int contador = 1;
		Iterator iterArchJOSN = listaArchJSON.iterator();
		while (iterArchJOSN.hasNext()) {
			ArchExcImpTablet archExcImpTabletTemp = (ArchExcImpTablet)iterArchJOSN.next();
			String nomArch = "JSON"+contador+"_"+dispMovil.getOIDInteger().toString()+".TXT";
			String nombreArchivo = IndividuoExcluido.getPathImagenPrincipalIndividuo(this.getSesion())+nomArch;
			File fichero = new File(nombreArchivo);
			try {
				BufferedWriter bw = new BufferedWriter(new FileWriter(nombreArchivo));
				bw.write(datosJson.toJson(archExcImpTabletTemp));
				bw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
			cargarArchJSON(deArchJSON,nomArch);			
			++contador;
		}
		
		
		
		// Actualizar informacion de la Sincronizacion		
		dispMovil.setFec_hor_ult_sinc_ol(Fecha.getddmmyyyy(Fecha.getFechaActual())+' '+Fecha.getHoraActualConSeg());
		dispMovil.setUlt_nro_lote_inf(nroImp);
		dispMovil.setForzar_sinc_all(false);
		dispMovil.save();
		
		// Grabar Log
		LogSincroExcluido logSincroExcluido = (LogSincroExcluido) LogSincroExcluido.getNew(LogSincroExcluido.NICKNAME, this.getSesion());
		logSincroExcluido.setDisp_movil(dispMovil);
		logSincroExcluido.setFecha(Fecha.getFechaActual());
		logSincroExcluido.setHora(Fecha.getHoraActual());
		logSincroExcluido.setGrupo_imp_exc(dispMovil.getGrupo_importacion());
		logSincroExcluido.setNro_lote(ultNroLoteSinc);
		logSincroExcluido.setActivo(true);
		logSincroExcluido.save();
		
		
		writeCliente(dsArchABajar);
		writeCliente(deArchJSON);
		
		
	}
	
	
	private PresentacionClienteExcluido getNewCliente(IndividuoExcluido individuo,
													  String pathArchivos,
													  IDataSet dsArchABajar) throws BaseException {
		
		PresentacionClienteExcluido presentacion = new PresentacionClienteExcluido();
		presentacion.setIdCliente(individuo.getOIDInteger().toString());
		presentacion.setEstadoNro(individuo.getNroPrincipal2());
		
		
		NovedadExcluido novedad = individuo.getNovedadExcluido();
		if (novedad!=null) {
			presentacion.setPeriodo(novedad.getDescVencimiento());
			if ((novedad.getMotivo()!=null) && (novedad.getMotivo().getDescripcion()!=null))
					presentacion.setMotivo(novedad.getMotivo().getDescripcion());
				else
					presentacion.setMotivo("");
			presentacion.setNroActa(Integer.toString(novedad.getnroActa()));
		}
		else {
			presentacion.setPeriodo("");
			presentacion.setMotivo("");
		}
		if (individuo.getNro_documento()!=null)
			presentacion.setNroDocumento(individuo.getNro_documento());
		else
			presentacion.setNroDocumento("");
		if (individuo.getTipo_documento()!=null)
			presentacion.setTipoDocumento(individuo.getTipo_documento().getDescripcion());
		else
			presentacion.setTipoDocumento("");
		if (individuo.getApeyNom()!=null)
			presentacion.setApe_y_nom(individuo.getApeyNom());
		else
			presentacion.setApe_y_nom("");
		
	
		String obs = individuo.getObsPrincipal();
		if (obs!=null)
			presentacion.setObsPrincipal(individuo.getObsPrincipal());
		else
			presentacion.setObsPrincipal("");
		
		
		if (individuo.getEstado()!=null) {
			presentacion.setIdEstado(individuo.getEstado().getOIDInteger().toString());
			presentacion.setDescEstado(individuo.getEstado().getDescripcion());
			if (individuo.getEstado().getColor()!=null)
				presentacion.setColorEstado(individuo.getEstado().getColor());
			else
				presentacion.setColorEstado("");
		} else {
			presentacion.setIdEstado("");
			presentacion.setDescEstado("");
			presentacion.setColorEstado("");
		}
		
		
		
		if (individuo.getPeligrosidad()!=null) {
			presentacion.setIdPeligrosidad(individuo.getPeligrosidad().getOIDInteger().toString());
			presentacion.setDescPeligrosidad(individuo.getPeligrosidad().getDescripcion());
			presentacion.setColorPeligrosidad(individuo.getPeligrosidad().getColor());
		} else {
			presentacion.setIdPeligrosidad("");
			presentacion.setDescPeligrosidad("");
			presentacion.setColorPeligrosidad("");
		}		
		
		if (individuo.getRaza()!=null) {
			presentacion.setIdRaza(individuo.getRaza().getOIDInteger().toString());
			presentacion.setDescRaza(individuo.getRaza().getDescripcion());
		} else {
			presentacion.setIdRaza("");
			presentacion.setDescRaza("");			
		}		
		
		if (individuo.getAltura()!=null) {
			presentacion.setIdAltura(individuo.getAltura().getOIDInteger().toString());
			presentacion.setDescAltura(individuo.getAltura().getDescripcion());
		} else {
			presentacion.setIdAltura("");
			presentacion.setDescAltura("");			
		}		
		
		if (individuo.getComplexion()!=null) {
			presentacion.setIdComplexion(individuo.getComplexion().getOIDInteger().toString());
			presentacion.setDescComplexion(individuo.getComplexion().getDescripcion());
		} else {
			presentacion.setIdComplexion("");
			presentacion.setDescComplexion("");			
		}		
		
		if (individuo.getEdad()!=null) {
			presentacion.setIdEdad(individuo.getEdad().getOIDInteger().toString());
			presentacion.setDescEdad(individuo.getEdad().getDescripcion());
		} else {
			presentacion.setIdEdad("");
			presentacion.setDescEdad("");			
		}		
		
		if (individuo.getColor()!=null) {
			presentacion.setIdColorCabello(individuo.getColor().getOIDInteger().toString());
			presentacion.setDescColorCabello(individuo.getColor().getDescripcion());
		} else {
			presentacion.setIdColorCabello("");
			presentacion.setDescColorCabello("");			
		}		
		
		if (individuo.getSexo()!=null) {
			presentacion.setIdSexo(individuo.getSexo());			
			presentacion.setDescSexo(IndividuoExcluido.getDescSexo(individuo.getSexo()));
		} else {
			presentacion.setIdSexo("");			
			presentacion.setDescSexo("");			
		}
		
		
		if (individuo.isActivo())
			presentacion.setOper("A");
		else
			presentacion.setOper("B");
		
		if ((individuo.getNovedadExcluido()!=null)) {
			presentacion.setNroOrden1(individuo.getNovedadExcluido().getOIDInteger().toString());
			presentacion.setNroOrden2(individuo.getNovedadExcluido().getOIDInteger().toString());
		}
		else {
			presentacion.setNroOrden1("0");
			presentacion.setNroOrden2("0");
		}
		
		String[] fotos = null;
		if (presentacion.getOper().equals("B"))
			fotos =  getFotos(pathArchivos,individuo, null);
		else
			fotos =  getFotos(pathArchivos,individuo, dsArchABajar);
		
		if (fotos[0]!=null)
			presentacion.setFoto1(fotos[0]);
		else
			presentacion.setFoto1("");
		if (fotos[1]!=null)
			presentacion.setFoto2(fotos[1]);
		else
			presentacion.setFoto2("");
		if (fotos[2]!=null)
			presentacion.setFoto3(fotos[2]);
		else
			presentacion.setFoto3("");		
		
		presentacion.setRestriccionAcceso( individuo.isRestriccionAcceso()?"1":"0");
		
		
		return presentacion;
	}
	
	
	private PresentacionClienteExcluido deleteCliente(IndividuoExcluido individuo,
			IDataSet dsArchABajar) throws BaseException {

		PresentacionClienteExcluido presentacion = new PresentacionClienteExcluido();
		presentacion.setIdCliente(individuo.getOIDInteger().toString());
		
		presentacion.setOper("B");

		return presentacion;
	}
	
	
	
	// Logica para determina que foto tomar como la principal
	private String[] getFotos(String pathArchivos,IndividuoExcluido individuo, IDataSet dsArchABajar) throws BaseException {
		
		String fotoPrincipal = "";
		String foto2 = "";
		String foto3 = "";
		
		String[] arrayString = new String[3];
		
		int[] arrayInt = new int[3];
		
		arrayInt[0] = -1;
		arrayInt[1] = -1;
		arrayInt[2] = -1;
		
		for (int i=1;i<=3;++i) {
			String nomArch = pathArchivos+"FPE_"+i+"_"+individuo.getOIDInteger().toString();
			File file = new File(nomArch);
		    if (file.exists()) {
		    	//cargarArchABaja(dsArchABajar,"FPE_"+i+"_"+individuo.getOIDInteger().toString());
		    	if ((individuo.getFotoPrincipal()!=null) && (individuo.getFotoPrincipal().intValue()==i)) {
		    		fotoPrincipal = "FPE_"+i+"_"+individuo.getOIDInteger().toString();
		    	} else {
		    		arrayInt[i-1] = i;		    		
		    	}
		    }				
		}
		
		if (fotoPrincipal.equals("")) {
			
			for(int j=2;j>=0;--j) {
				
				if (arrayInt[j]!=-1) {
					
				    	fotoPrincipal = "FPE_"+arrayInt[j]+"_"+individuo.getOIDInteger().toString();
				    	arrayInt[j] = -1;
				    	break;
				    
				}
			}
			
		}
		
		for(int j=0;j<3;++j) {
			
			if (arrayInt[j]!=-1) {
				if (fotoPrincipal.length()==0)
					fotoPrincipal = "FPE_"+arrayInt[j]+"_"+individuo.getOIDInteger().toString();
				else if (foto2.length()==0)
						foto2 = "FPE_"+arrayInt[j]+"_"+individuo.getOIDInteger().toString();
				else if (foto3.length()==0)
					foto3 = "FPE_"+arrayInt[j]+"_"+individuo.getOIDInteger().toString();
				break;
			}
		}		
		
		arrayString[0] = fotoPrincipal;
		arrayString[1] = foto2;
		arrayString[2] = foto3;
		
		//cargarArchABaja(dsArchABajar,"FPE_"+i+"_"+individuo.getOIDInteger().toString());
		if ((fotoPrincipal!=null) && (fotoPrincipal.length()>0) && (dsArchABajar!=null))
			cargarArchABaja(dsArchABajar,fotoPrincipal);
		
		return arrayString;
	}
	
	  private IDataSet getDataSetArchABajar() {
		    IDataSet dataset = new TDataSet();
		    dataset.create("TArchivosABajar");
		    dataset.fieldDef(new Field("archivo", Field.STRING, 100));
		    return dataset;
	  }
	  
	  private IDataSet getDataSetArchJSON() {
		    IDataSet dataset = new TDataSet();
		    dataset.create("TArchivoJSON");
		    dataset.fieldDef(new Field("contenido", Field.MEMO, 0));
		    return dataset;
	  }	  
	  
	  private void cargarArchABaja(IDataSet ds,String archivo) throws BaseException {
		  ds.append();
		  ds.fieldValue("archivo", archivo);
	  }
	  
	  private void cargarArchJSON(IDataSet ds,String contenido) throws BaseException {
		  
		  
		  
		  ds.append();
		  ds.fieldValue("contenido", contenido.replaceAll("\"", "ç"));
	  }
	  
	  private PresentacionClienteExcluido getNewClienteDummy() throws BaseException {

		  PresentacionClienteExcluido presentacion = new PresentacionClienteExcluido();
		  presentacion.setIdCliente("-1");
		  presentacion.setEstadoNro("");
		  presentacion.setPeriodo("");
		  presentacion.setMotivo("");
		  presentacion.setNroDocumento("");
		  presentacion.setTipoDocumento("");
		  presentacion.setApe_y_nom("");
		  presentacion.setFoto1("");
		  presentacion.setFoto2("");
		  presentacion.setFoto3("");
		  presentacion.setObsPrincipal("");
		  presentacion.setIdEstado("");
		  presentacion.setDescEstado("");
		  presentacion.setColorEstado("");
		  presentacion.setIdPeligrosidad("");
		  presentacion.setDescPeligrosidad("");
		  presentacion.setColorPeligrosidad("");
		  presentacion.setIdRaza("");
		  presentacion.setDescRaza("");			
		  presentacion.setIdAltura("");
		  presentacion.setDescAltura("");			
		  presentacion.setIdComplexion("");
		  presentacion.setDescComplexion("");			
		  presentacion.setIdEdad("");
		  presentacion.setDescEdad("");			
		  presentacion.setIdColorCabello("");
		  presentacion.setDescColorCabello("");			
		  presentacion.setIdSexo("");			
		  presentacion.setDescSexo("");			
		  presentacion.setOper("B");
		  presentacion.setNroOrden1("0");
		  presentacion.setNroOrden2("0");
		  presentacion.setNroActa("");
		  presentacion.setRestriccionAcceso("0");
		  return presentacion;
		  
	  }
	  
	
}
