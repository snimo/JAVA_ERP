package com.srn.erp.conciTarjeta.op;

import java.io.File;

import org.apache.commons.fileupload.FileItem;

import com.srn.erp.conciTarjeta.bm.ImpArchCierreLote;
import com.srn.erp.conciTarjeta.bm.TerminalConciTar;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class UploadArchSelCierreLote extends Operation {

	String archivo = null;
	
	public UploadArchSelCierreLote() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		
		
		String nombreArchOriginal = mapaDatos.getString("nuevo_nombre");
		String nroTerminal = ImpArchCierreLote.getUltCarpeta(nombreArchOriginal);
		TerminalConciTar terminal = TerminalConciTar.getTerminalByNro(nroTerminal, this.getSesion());
		
		int sepExt 		= nombreArchOriginal.lastIndexOf(".");
		String nroLote 	= nombreArchOriginal.substring(sepExt+1, nombreArchOriginal.length());		
				
		if (terminal==null)
			throw new ExceptionValidation(null,"No se pudo encontrar la terminal con código "+nroTerminal);
		
		int sep = nombreArchOriginal.lastIndexOf("\\");
		String path = nombreArchOriginal.substring(0, sep);
	    int sep1 = nombreArchOriginal.lastIndexOf("\\");
	    archivo = nombreArchOriginal.substring(sep1 + 1, nombreArchOriginal.length() );
		
	    IDataSet ds = getImpoArchPOSNET();
	    
	    //Si existe el archivo entonces borrarlo
	    try {
	    	File fsiExisteArchBorrarlo = new File(terminal.getFolderLoteProcesado(), archivo);
	    	fsiExisteArchBorrarlo.delete();
	    } catch (Exception e) {}
	    
		File fNew = new File(terminal.getFolderLoteProcesado(), archivo);

		FileItem fi = null;
		if (mapaDatos.containsKey("archivo"))
			fi = (FileItem) mapaDatos.getObject("archivo");
		if (fi != null) {
			// Quiere decir que enviaron un archivo
			try {
				fi.write(fNew);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				throw new ExceptionValidation(null, "Se produjo un error al querer grabar el archivo ");
			}
		} else {
			// Se borrer el archivo, porque no se envio nada
			fNew.delete();
			throw new ExceptionValidation(null, "Se produjo un error al querer grabar el archivo ");			
		}
		
		try {
			
		Integer nroLoteExt = new Integer(0); 
		try {
			nroLoteExt = new Integer(nroLote);
		} catch (Exception e) {
			throw new ExceptionValidation(null,"No se pudo obtener el Nro. de Lote de la extensión del archivo. Archivo "+nombreArchOriginal);
		}
		
		ImpArchCierreLote impArchCierre = ImpArchCierreLote.getNewImportador(ImpArchCierreLote.TIPO_POS);
		impArchCierre.setTerminal(terminal);
		impArchCierre.setNroLote(nroLoteExt);
		impArchCierre.setNombreArchivoOriginal(mapaDatos.getString("nuevo_nombre"));
		impArchCierre.setOidEmpresa(mapaDatos.getInteger("oid_empresa"));
		impArchCierre.setArchivo(terminal.getFolderLoteProcesado()+archivo);
		impArchCierre.setSesion(this.getSesion());
		
		
		
		
		impArchCierre.comenzar();
		this.getSesion().commitTransaction();
		// Ejecutar el support refresh
		impArchCierre.getCantRegImp();
		cargarRegistro(ds,impArchCierre.getCantRegImp(),true,"");
		renameFile(terminal.getFolderLoteProcesado()+archivo,terminal.getFolderLoteProcesado()+impArchCierre.getOidArchLoteCab()+".txt");
		} catch(Exception e) {
			cargarRegistro(ds,0,false,e.getMessage());
			this.getSesion().rollBackTransaction();
			// Para el archivo de la carpeta origen a la carpeta destino
			String archivoOrigen  = terminal.getFolderLoteProcesado()+archivo;
			String carpetaDestino = terminal.getFolderLoteError();
			// Si se produjo un error entonces pasar el archivo de la carpeta de procesados a la carpeta de archivos
			// con error
			moverArchivo(archivoOrigen,carpetaDestino);
		}
		
		writeCliente(ds);		
		
	}
	
	private void cargarRegistro(IDataSet ds,int cantReg, boolean procesado,String mensError) {
		ds.append();
		ds.fieldValue("cant_reg_imp", cantReg);
		ds.fieldValue("procesado", procesado);
		ds.fieldValue("mens_error", mensError);
	}
	
	private IDataSet getImpoArchPOSNET() {
		IDataSet dataset = new TDataSet();
		dataset.create("TInfoArchPOSNET");
		dataset.fieldDef(new Field("cant_reg_imp", Field.INTEGER, 0));
		dataset.fieldDef(new Field("procesado", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("mens_error", Field.STRING, 255));
		return dataset;
	}
	
	private void moverArchivo(String origen,String destino) throws BaseException {
		// File (or directory) to be moved
	    File file = new File(origen);
	    
	    // Destination directory
	    File dir = new File(destino);
	    
	    try {
	    	File fsiExisteArchBorrarlo = new File(destino, file.getName());
	    	fsiExisteArchBorrarlo.delete();
	    } catch (Exception e) {}	    
	    
	    
	    boolean success = file.renameTo(new File(dir, file.getName()));
	    if (!success) {
	        // File was not successfully moved
	    	throw new ExceptionValidation(null,"No se pudo mover el archivo "+origen+ " a la carpeta "+destino );
	    }
	}
	
	public void renameFile(String file, String toFile) throws BaseException {

        File toBeRenamed = new File(file);

        if (!toBeRenamed.exists() || toBeRenamed.isDirectory()) {
            return;
        }

        File newFile = new File(toFile);

        //Rename
        if (toBeRenamed.renameTo(newFile)) {
            System.out.println("File has been renamed.");
        } else {
            throw new ExceptionValidation(null,"No se pudo renombrar el archivo "+file);
        }


    }
	

}
