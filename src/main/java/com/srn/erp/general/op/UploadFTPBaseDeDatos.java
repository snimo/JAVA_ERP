package com.srn.erp.general.op;

import com.srn.erp.general.bm.MsWinSvc;
import com.srn.erp.general.bm.SimpleFTPClient;
import com.srn.erp.general.bm.Zip;

import framework.applicarionServer.bl.Utils.Fecha;
import framework.applicarionServer.bm.Parametros.ValorParametro;
import framework.applicarionServer.bm.Seguridad.DesEncriptarCadena;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class UploadFTPBaseDeDatos extends Operation  {

	public UploadFTPBaseDeDatos() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {

		
		String servicioBD = this.getSevicioBD();
		String archivoBD = this.getArchivoBD();
		String archivoTempBDComprimido = getArchivoTempBDComprimido();
		String ftp = getFTP();
		String usuarioFTP = getUsuarioFTP();
		String passwordFTP = DesEncriptarCadena.getCadenaDesencriptada(getPasswordUsuarioFTP());
		String ubicacionRemota = getUbicacionRemota();

		IDataSet ds = this.getDataSet();
		/*
		try {
			MsWinSvc.stopService(servicioBD);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/

		Zip zipFile = new Zip();
		zipFile.addArchivo(archivoBD);
		zipFile.comprimir(archivoTempBDComprimido);

		SimpleFTPClient f = new SimpleFTPClient();
		f.setHost(ftp);
		f.setUser(usuarioFTP);
		f.setPassword(passwordFTP);
		f.setRemoteFile(ubicacionRemota+Fecha.getNombreDiaSemanaSinAcento(Fecha.getFechaActual())+".RAR");
		boolean connected = f.connect();
		String mensaje = "";
		if (connected) {

			if (f.uploadFile(archivoTempBDComprimido))
				mensaje = f.getLastSuccessMessage();
			else
				mensaje = f.getLastErrorMessage();
		}

		ds.append();
		ds.fieldValue("descripcion", mensaje);

		writeCliente(ds);

		/*
		try {
			MsWinSvc.startService(servicioBD);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/

	}

	private IDataSet getDataSet() {
		IDataSet dataset = new TDataSet();
		dataset.create("TResultado");
		dataset.fieldDef(new Field("descripcion", Field.INTEGER, 255));
		return dataset;
	}
	
	private String getSevicioBD() throws BaseException {
		return ValorParametro.findByCodigoParametro(
				"SERVICIO_WINDOWS_BD", this.getSesion()).getValorCadena();
	}
	
	private String getArchivoBD() throws BaseException {
		return ValorParametro.findByCodigoParametro(
				"ARCHIVO_BD", this.getSesion()).getValorCadena();
	}
	
	private String getArchivoTempBDComprimido() throws BaseException {
		return ValorParametro.findByCodigoParametro(
				"NOM_ARCH_TEMP_BD_COMPRIMIDO", this.getSesion()).getValorCadena();
	}

	private String getFTP() throws BaseException {
		return ValorParametro.findByCodigoParametro(
				"FTP_PARA_BACKUP_BD", this.getSesion()).getValorCadena();
	}

	private String getUsuarioFTP() throws BaseException {
		return ValorParametro.findByCodigoParametro(
				"USU_FTP_PARA_BACKUP_BD", this.getSesion()).getValorCadena();
	}
	
	private String getPasswordUsuarioFTP() throws BaseException {
		return ValorParametro.findByCodigoParametro(
				"PASS_ENC_FTP_PARA_BACKUP_BD", this.getSesion()).getValorCadena();
	}
	
	private String getUbicacionRemota() throws BaseException {
		return ValorParametro.findByCodigoParametro(
				"UBI_REMOTA_FTP_BACKUP_BD", this.getSesion()).getValorCadena();
	}
	
	
	
	
	
}
