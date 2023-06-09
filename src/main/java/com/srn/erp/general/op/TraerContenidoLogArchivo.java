package com.srn.erp.general.op;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import com.srn.erp.general.bm.LogsArchivo;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerContenidoLogArchivo extends Operation {

	public TraerContenidoLogArchivo() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {

		Integer oidLogArchivo = mapaDatos.getInteger("oid_log_archivo");
		LogsArchivo logArchivo = LogsArchivo.findByOid(oidLogArchivo, this.getSesion());

		IDataSet dataset = this.getDataSet();
		
		if (!((new File(logArchivo.getDescripcion())).exists()))
			return;
		String contenido = getContents(new File(logArchivo.getDescripcion()));
		cargarRegistro(dataset, contenido);
		

		writeCliente(dataset);
	}

	private IDataSet getDataSet() {
		IDataSet dataset = new TDataSet();
		dataset.create("TVistaArchivo");
		dataset.fieldDef(new Field("contenido", Field.MEMO, 0));
		return dataset;
	}

	private void cargarRegistro(IDataSet dataset, String contenido) {
		
		String[] listaCodigos = contenido.split("\r\n");
		for (int i = 0; i < listaCodigos.length; ++i) {
			String linea = listaCodigos[i];
			dataset.append();
			dataset.fieldValue("contenido", linea);
		}		
		
	}

	public String getContents(File aFile) {
		// ...checks on aFile are elided
		StringBuilder contents = new StringBuilder();

		try {
			// use buffering, reading one line at a time
			// FileReader always assumes default encoding is OK!
			BufferedReader input = new BufferedReader(new FileReader(aFile));
			try {
				String line = null; // not declared within while loop
				/*
				 * readLine is a bit quirky : it returns the content of a line
				 * MINUS the newline. it returns null only for the END of the
				 * stream. it returns an empty String if two newlines appear in
				 * a row.
				 */
				while ((line = input.readLine()) != null) {
					contents.append(line);
					contents.append(System.getProperty("line.separator"));
				}
			} finally {
				input.close();
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}

		return contents.toString();
	}

}
