package com.srn.erp.conciTarjeta.op;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import com.srn.erp.conciTarjeta.bm.EmpresaConciTar;
import com.srn.erp.conciTarjeta.bm.ImpArchCierreLote;
import com.srn.erp.conciTarjeta.bm.TerminalConciTar;

import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bm.Parametros.ValorParametro;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class ImpAutArchTarjPOSNETS extends Operation {

	public ImpAutArchTarjPOSNETS() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		IDataSet ds = getDataSetResultadoImp();
		Integer oidEmpresa = mapaDatos.getInteger("oid_empresa");
		EmpresaConciTar empresa =
			EmpresaConciTar.findByOidProxy(oidEmpresa, this.getSesion());
		String carpetaBase = getCarpetaArchPOSNETSLoteIP(this.getSesion());
		File dir = new File(carpetaBase);
		File[] children = dir.listFiles();
		for (int i = 0; i < children.length; i++) {
			File filename = children[i];
			TerminalConciTar terminal = TerminalConciTar.getTerminalByNro(filename.getName(), this.getSesion());
			if (terminal == null) continue;
			if (terminal.getUni_neg()==null) continue;
			if (terminal.getUni_neg().getEmpresa()==null) continue;
			if (terminal.getUni_neg().getEmpresa().getOID() != empresa.getOID()) continue;
			importarArchivos(ds,terminal, filename.getAbsolutePath());
		}
		writeCliente(ds);
	}

	private void importarArchivos(IDataSet ds,TerminalConciTar terminal, String path) throws BaseException {
		// Carpeta Base del POSNET
		File dir = new File(path);
		File[] children = dir.listFiles();
		File filename = null;
		for (int i = 0; i < children.length; i++) {
			String archivoOrigen  = "";
			String carpetaDestino = "";
			try {
				
				filename = children[i];
				File archivoDestino = new File(terminal.getFolderLoteProcesado(),filename.getName());
				copiarArchivo(filename, archivoDestino);
				//moverArchivo(path,filename.getName(),terminal.getFolderLoteProcesado(),filename.getName());
				
				int sepExt = filename.getName().lastIndexOf(".");
				String nroLote = filename.getName().substring(sepExt + 1, filename.getName().length());

				ImpArchCierreLote impArchCierre = ImpArchCierreLote.getNewImportador(ImpArchCierreLote.TIPO_POS);
				impArchCierre.setTerminal(terminal);
				impArchCierre.setNroLote(new Integer(nroLote));
				impArchCierre.setNombreArchivoOriginal(filename.getName());
				if ((terminal.getUni_neg() != null) && (terminal.getUni_neg().getEmpresa() != null))
					impArchCierre.setOidEmpresa(terminal.getUni_neg().getEmpresa().getOIDInteger());
				impArchCierre.setArchivo(terminal.getFolderLoteProcesado() + filename.getName());
				impArchCierre.setSesion(this.getSesion());
				impArchCierre.comenzar();
				this.getSesion().commitTransaction();
				renameFile(terminal.getFolderLoteProcesado() + filename.getName(), terminal.getFolderLoteProcesado()
						+ impArchCierre.getOidArchLoteCab() + ".txt");
				if (filename.delete()==false)
					throw new ExceptionValidation(null,"No se pudo borrar el archivo "+filename.getName());
				cargarRegistroResImp(ds,terminal.getUni_neg().getDescripcion(),terminal.getDescripcion(),filename.getAbsolutePath(),filename.getName(), impArchCierre.getCantRegImp(),"OK",new Integer(0));
			} catch (Exception e) {
				archivoOrigen  = terminal.getFolderLoteProcesado() + filename.getName();
				carpetaDestino = terminal.getFolderLoteError();
				cargarRegistroResImp(ds,terminal.getUni_neg().getDescripcion(),terminal.getDescripcion(),filename.getAbsolutePath(),filename.getName(), 0,"ERROR:"+e.getMessage(),new Integer(1));
				moverArchivo(archivoOrigen, carpetaDestino);
			}
		}
	}

	public static String getCarpetaArchPOSNETSLoteIP(ISesion aSesion) throws BaseException {
		return ValorParametro.findByCodigoParametro("CARP_ARCH_POSNETS_LOTEIP", aSesion).getValorCadena();
	}

	public void renameFile(String file, String toFile) throws BaseException {
		File toBeRenamed = new File(file);
		if (!toBeRenamed.exists() || toBeRenamed.isDirectory()) {
			return;
		}
		File newFile = new File(toFile);
		if (toBeRenamed.renameTo(newFile)) {
		} else {
			throw new ExceptionValidation(null, "No se pudo renombrar el archivo " + file);
		}
	}

	private void moverArchivo(String origen, String destino) throws BaseException {
		// File (or directory) to be moved
		File file = new File(origen);
		// Destination directory
		File dir = new File(destino);
		try {
			File fsiExisteArchBorrarlo = new File(destino, file.getName());
			fsiExisteArchBorrarlo.delete();
		} catch (Exception e) {
		}
		boolean success = file.renameTo(new File(dir, file.getName()));
		if (!success) {
			// File was not successfully moved
			throw new ExceptionValidation(null, "No se pudo mover el archivo " + origen + " a la carpeta " + destino);
		}
	}
	
	private void moverArchivo(String carpetaOrigen,String archivoOrigen,String carpetaDestino,String archivoDestino) throws BaseException {
		// File (or directory) to be moved
		File file = new File(carpetaOrigen,archivoOrigen);
		// Destination directory
		File dir = new File(carpetaDestino,archivoDestino);
		try {
			File fsiExisteArchBorrarlo = new File(carpetaDestino, file.getName());
			fsiExisteArchBorrarlo.delete();
		} catch (Exception e) {
		}
		boolean success = file.renameTo(new File(carpetaDestino, archivoDestino));
		if (!success) {
			// File was not successfully moved
			throw new ExceptionValidation(null, "No se pudo mover el archivo "+carpetaOrigen+"\\"+archivoOrigen +" a "+ carpetaDestino + "\\" + archivoDestino);
		}
	}
	
	void copiarArchivo(File in, File out) throws IOException {
		 FileInputStream fis = new FileInputStream(in);
         FileOutputStream fos = new FileOutputStream(out);
         byte[] buf = new byte[1024];
         int i = 0;
             while((i=fis.read(buf))!=-1) {
             fos.write(buf, 0, i);
         }
         fis.close();
         fos.close();
	}
	
	  private IDataSet getDataSetResultadoImp() {
		    IDataSet dataset = new TDataSet();
		    dataset.create("TResImpAutLOTEIP");
		    dataset.fieldDef(new Field("unidad_negocio", Field.STRING, 255));
		    dataset.fieldDef(new Field("terminal", Field.STRING, 255));
		    dataset.fieldDef(new Field("path", Field.STRING, 255));
		    dataset.fieldDef(new Field("archivo", Field.STRING, 255));
		    dataset.fieldDef(new Field("cant_reg_imp", Field.INTEGER, 0));
		    dataset.fieldDef(new Field("errores", Field.STRING, 255));
		    dataset.fieldDef(new Field("color_reg", Field.INTEGER, 0));
		    return dataset;
	  }

	  private void cargarRegistroResImp(
			  IDataSet dataset,
			  String   unidadNegocio,
			  String   terminal,
			  String   path,
			  String   archivo,
			  Integer  cantRegImp,
			  String   errores,
			  Integer colorRegistro
	  ) {
		    dataset.append();
		    dataset.fieldValue("unidad_negocio", unidadNegocio);
		    dataset.fieldValue("terminal", terminal);
		    dataset.fieldValue("path", path);
		    dataset.fieldValue("archivo", archivo);
		    dataset.fieldValue("cant_reg_imp", cantRegImp);
		    dataset.fieldValue("errores", errores);
		    dataset.fieldValue("color_reg", colorRegistro);
	  }	

}
