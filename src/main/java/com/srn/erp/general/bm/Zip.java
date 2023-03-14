package com.srn.erp.general.bm;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.zip.Adler32;
import java.util.zip.CheckedOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;

public class Zip {

	static final int BUFFER = 2048;
	static final int BUFFER_SIZE = 1024;

	List listaArchivos = new ArrayList();

	public void addArchivo(String archivo) {
		listaArchivos.add(archivo);
	}

	public void clearArchivos() {
		listaArchivos.clear();
	}

	public void comprimir(String archivoSalida) throws BaseException {

		try {
			BufferedInputStream origin = null;
			FileOutputStream dest = new FileOutputStream(archivoSalida);
			CheckedOutputStream checksum = new CheckedOutputStream(dest, new Adler32());
			ZipOutputStream out = new ZipOutputStream(new BufferedOutputStream(checksum));
			// out.setMethod(ZipOutputStream.DEFLATED);
			byte data[] = new byte[BUFFER];

			Iterator iterNomArchivos = listaArchivos.iterator();
			while (iterNomArchivos.hasNext()) {
				String nomArchivo = (String) iterNomArchivos.next();
				FileInputStream fi = new FileInputStream(nomArchivo);
				origin = new BufferedInputStream(fi, BUFFER);
				ZipEntry entry = new ZipEntry(nomArchivo);
				out.putNextEntry(entry);
				int count;
				while ((count = origin.read(data, 0, BUFFER)) != -1) {
					out.write(data, 0, count);
				}
				origin.close();
			}
			out.close();
		} catch (Exception e) {
			throw new ExceptionValidation(null, "Se produjo un error al comprimir el archivo:" + archivoSalida);
		}
	}

	public void Descomprimir(String archivoZIP, String archivoDescomprimido) throws Exception {
		BufferedOutputStream bos = null;
		FileInputStream fis = null;
		ZipInputStream zipis = null;
		FileOutputStream fos = null;

		try {
			fis = new FileInputStream(archivoZIP);
			zipis = new ZipInputStream(new BufferedInputStream(fis));
			if (zipis.getNextEntry() != null) {
				int len = 0;
				byte[] buffer = new byte[BUFFER_SIZE];
				fos = new FileOutputStream(archivoDescomprimido);
				bos = new BufferedOutputStream(fos, BUFFER_SIZE);

				while ((len = zipis.read(buffer, 0, BUFFER_SIZE)) != -1)
					bos.write(buffer, 0, len);
				bos.flush();
			} else {
				throw new Exception("Zip Vacio");
			} // cierra if
		} catch (Exception e) {
			throw e;
		} finally {
			bos.close();
			zipis.close();
			fos.close();
			fis.close();
		} // cierra try

	} // cierra descomprimir

}
