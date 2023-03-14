package com.srn.erp.conciTarjeta.op;

import java.io.File;
import java.util.Iterator;

import org.apache.commons.fileupload.FileItem;

import com.srn.erp.conciTarjeta.bm.CabTarConciEnt;
import com.srn.erp.conciTarjeta.bm.EmpresaConciTar;
import com.srn.erp.conciTarjeta.bm.ImpArchCobTar;
import com.srn.erp.conciTarjeta.bm.TipoArchConciTar;
import com.srn.erp.conciTarjeta.bm.TipoArchivoConciliacion;

import framework.applicarionServer.bl.Utils.Fecha;
import framework.applicarionServer.bm.Seguridad.Usuario;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class UploadArchCobTarj extends Operation {

	public UploadArchCobTarj() {
	}

	
	private void importarCobranza(MapDatos mapaDatos) throws BaseException {
		
		String archivo 	= mapaDatos.getString("nuevo_nombre");
		
		EmpresaConciTar empresa =
			EmpresaConciTar.findByOidProxy(mapaDatos.getInteger("oid_empresa"), this.getSesion());
		
		if (empresa == null)
			throw new ExceptionValidation(null,"Debe seleccionar una empresa para poder operar.");
		
		 
		
		CabTarConciEnt cabTarConciEnt =
			(CabTarConciEnt) CabTarConciEnt.getNew(CabTarConciEnt.NICKNAME, this.getSesion());
		cabTarConciEnt.setFec_imp(Fecha.getFechaActual());
		cabTarConciEnt.setHora_imp(Fecha.getHoraActual());
		
		
		int sepPath = archivo.lastIndexOf("\\");
		String path = archivo.substring(0, sepPath);
		
	    int sepArchivo = archivo.lastIndexOf("\\");
	    String nomArchivo = archivo.substring(sepArchivo + 1, archivo.length() );
	    
	    String tipoArchivo = getTipoArchivo(nomArchivo);
	    
	    if (tipoArchivo == null)
	    	throw new ExceptionValidation(null,"No se pudo deducir el tipo de Archivo del nombre de archivo "+nomArchivo);
	    
	    EmpresaConciTar empresaDeducidaDelArch = getEmpresaSegunNomArch(nomArchivo);
	    if (empresaDeducidaDelArch == null)
	    	throw new ExceptionValidation(null,"No se pudo deducir el nombre de empresa del archivo "+nomArchivo);
		
	    if (empresa.getOID()!=empresaDeducidaDelArch.getOID())
	    	throw new ExceptionValidation(null,"El archivo seleccionado no corresponde a la empresa "+empresa.getRazon_social());
	    
	    cabTarConciEnt.setEmpresa(empresaDeducidaDelArch);
		cabTarConciEnt.setNom_archivo(nomArchivo);
		cabTarConciEnt.setCarpetaArchivo(path);
		cabTarConciEnt.setTipoArchivo(tipoArchivo);
		cabTarConciEnt.setActivo(true);
		cabTarConciEnt.setUsuarioAlta(Usuario.findByOidProxy(this.getSesion().getLogin().getUsuario().getOIDInteger(), this.getSesion()));
		cabTarConciEnt.setFecNomArchivo(this.getFechaNomArch(nomArchivo));
		
		// Antes de grabar Verificar que sea único
		CabTarConciEnt cabTarConciEntUnico = 
			CabTarConciEnt.getCabTarConciEnt(empresa,tipoArchivo,cabTarConciEnt.getFecNomArchivo(),this.getSesion());
		if (cabTarConciEntUnico != null)
			throw new ExceptionValidation(null,"Archivo ya importado el "+Fecha.getddmmyyyy(cabTarConciEntUnico.getFec_imp())+" a las "+cabTarConciEntUnico.getHora_imp());
				
		cabTarConciEnt.save();
		
		String extension = "";
		if (tipoArchivo.equals(TipoArchivoConciliacion.TA_AME))
			extension = ".txt";
		else
		if (tipoArchivo.equals(TipoArchivoConciliacion.TA_VISA))
			extension = ".txt";
		else
			if (tipoArchivo.equals(TipoArchivoConciliacion.TA_MASTER))
				extension = ".zip";		
		
		File fNew = new File(
				CabTarConciEnt.getCarpetaArchImpCobranzas(this.getSesion()), 
				cabTarConciEnt.getOIDInteger().toString()+extension);

		FileItem fi = null;
		if (mapaDatos.containsKey("archivo"))
			fi = (FileItem) mapaDatos.getObject("archivo");
		if (fi != null) {
			// Quiere decir que enviaron un archivo
			try {
				fi.write(fNew);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				throw new ExceptionValidation(null, "Se produjo un error al querer grabar el archivo");
			}
		} else {
			// Se borrer el archivo, porque no se envio nada
			fNew.delete();
		}
		
		
		ImpArchCobTar impArchCob = ImpArchCobTar.getImpArchCobTar(tipoArchivo);
		impArchCob.setSession(this.getSesion());
		impArchCob.setArchivo(fNew.getAbsolutePath());
		impArchCob.setCabTarConciEnt(cabTarConciEnt);		
		impArchCob.importar();
		
		IDataSet ds = getImpoArchTARJETA();
		cargarRegistro(ds, impArchCob.getCantRegImp(),true);
		writeCliente(ds);
		
		
	}
	
	public void execute(MapDatos mapaDatos) throws BaseException {
		try {
			importarCobranza(mapaDatos);
			this.getSesion().commitTransaction();
		} catch(Exception e) {
			this.getSesion().rollBackTransaction();
			throw new ExceptionValidation(null,"No se pudo importar el archivo."+e.getMessage());
		}
		
	}
	
	private void cargarRegistro(IDataSet ds,int cantReg  , boolean procesoOK) {
		ds.append();
		ds.fieldValue("cant_reg_imp", cantReg);
		ds.fieldValue("proceso_ok", procesoOK);
	}
	
	private IDataSet getImpoArchTARJETA() {
		IDataSet dataset = new TDataSet();
		dataset.create("TInfoArchTarj");
		dataset.fieldDef(new Field("cant_reg_imp", Field.INTEGER, 0));
		dataset.fieldDef(new Field("proceso_ok", Field.BOOLEAN, 0));
		return dataset;
	}	
	
	public java.util.Date getFechaNomArch(String nombreArchivo) throws BaseException {
		try {
			String analizarNomArch = nombreArchivo;
			int posPunto = analizarNomArch.lastIndexOf(".");
			String archSinExt   = analizarNomArch.substring(0,posPunto);
			String fechaArchivo = archSinExt.substring(archSinExt.length()-6, archSinExt.length());
			int diaFecArch   = new Integer(fechaArchivo.substring(0,2)); 
			int mesFecArch   = new Integer(fechaArchivo.substring(2,4));
			int anioFecArch  = new Integer(fechaArchivo.substring(4,6)).intValue()+2000;
			return Fecha.getFecha(diaFecArch, mesFecArch, anioFecArch);
		} catch(Exception e) {
			throw new ExceptionValidation(null,"No se pudo obtener la fecha del nombre del archivo "+nombreArchivo);
		}
	}
	
	public EmpresaConciTar getEmpresaSegunNomArch(String nombreArchivo) throws BaseException {
		try {
			Iterator iterEmpreConciTar = 
				EmpresaConciTar.getAllActivos(this.getSesion()).iterator();
			while (iterEmpreConciTar.hasNext()) {
				EmpresaConciTar empresa = (EmpresaConciTar) iterEmpreConciTar.next();
				if (nombreArchivo.startsWith(empresa.getCodEmpArchImpTarj())) {
					return empresa;
				} 
			}
			return null;
		} catch (Exception e) {
			throw new ExceptionValidation(null,"No se pudo deducir la empresa del nombre de Archivo "+nombreArchivo);
		}
	}
	
	public String getTipoArchivo(String nombreArchivo) throws BaseException {
		try {
			Iterator iterTiposArchivos = 
				TipoArchConciTar.getAllActivos(this.getSesion()).iterator();
			while (iterTiposArchivos.hasNext()) {
				TipoArchConciTar tipoArchConciTar = (TipoArchConciTar) iterTiposArchivos.next();
				if (nombreArchivo.contains(tipoArchConciTar.getCodArchImpTarj())) {
					return tipoArchConciTar.getComportamiento();
				} 
			}
			return null;
		} catch (Exception e) {
			throw new ExceptionValidation(null,"No se pudo deducir el Tipo del nombre de Archivo "+nombreArchivo);
		}
	}
	

}
