package com.srn.erp.turnos.op;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.xBaseJ.DBF;
import org.xBaseJ.xBaseJException;
import org.xBaseJ.fields.CharField;
import org.xBaseJ.fields.NumField;

import com.srn.erp.turnos.bm.CategoriaSujetoTurno;
import com.srn.erp.turnos.bm.LogImpSujTurno;
import com.srn.erp.turnos.bm.RelaConcSujTur;
import com.srn.erp.turnos.bm.RelacionSujetoTurno;
import com.srn.erp.ventas.bm.Sujeto;
import com.srn.erp.ventas.bm.TipoDocumento;

import framework.applicarionServer.bl.Utils.Fecha;
import framework.applicarionServer.bm.Parametros.ValorParametro;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.MapDatos;

public class ImpoSujTurnosSistClipper extends Operation {

	int cantOK = 0;
	int cantError = 0;
	List errores = new ArrayList();
	private TipoDocumento tipoDocumento = null;

	public ImpoSujTurnosSistClipper() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {

		importarReglaConcSocio();

		try {

			String ejecutar = ValorParametro.findByCodigoParametro("BAT_COPY_ARCH_SOCIOS_CLUB", this.getSesion()).getValorCadena();

			Process p = Runtime.getRuntime().exec(ejecutar);
			p.waitFor(); // si quieres esperar a que la ejecucion finalize
		} catch (Exception err) {
			// El tratamiento de error que te salga de los huevos
		}

		String archivoSociosDBF = ValorParametro.findByCodigoParametro("ARCHIVO_SOCIOS_DBF", this.getSesion()).getValorCadena();
		
	    HashTableDatos descartarDupli = new HashTableDatos();

		try {
			DBF tablaSocios = new DBF(archivoSociosDBF, org.xBaseJ.DBF.READ_ONLY);
			NumField nroSocio = (NumField) tablaSocios.getField("socio");
			CharField nombre = (CharField) tablaSocios.getField("nombre");
			CharField categoria = (CharField) tablaSocios.getField("catego");
			CharField relacion = (CharField) tablaSocios.getField("relacion");
			CharField tarjeta = (CharField) tablaSocios.getField("fax2");

			// Buscar sujeto por codigo

			LogImpSujTurno.borrarLogs(Fecha.getFechaActual(), this.getSesion());

			for (int i = 1; i <= tablaSocios.getRecordCount(); i++) {
				tablaSocios.read();
				boolean huboError = false;
				String codigoSocio = nroSocio.get().trim();
				Sujeto sujeto = Sujeto.findByCodigo(codigoSocio, this.getSesion());

				if (sujeto == null) {
					sujeto = (Sujeto) Sujeto.getNew(Sujeto.NICKNAME, this.getSesion());
					sujeto.setCodigo(codigoSocio);
					sujeto.setActivo(new Boolean(true));
					sujeto.setFisica_juridica("F");
					sujeto.setTipo_documento(getTipoDocumentoDefault());
					sujeto.setDeshabilitarCodigoAutomatico(true);
					sujeto.setEs_cliente(new Boolean(true));
					sujeto.setFecha_ingreso(Fecha.getFechaActual());
					
				}
				
				String nombreCompleto = nombre.get();
				if (nombreCompleto == null)
					nombreCompleto = ".";
				else if (nombreCompleto.trim().equals(""))
					nombreCompleto = ".";
				
				if (descartarDupli.containsKey(sujeto.getCodigo())) {
					errores.add("Socio Duplicado: Socio:" + codigoSocio + " " + nombreCompleto );
					huboError = true;
					cantError++;
					continue;
				}
				
				descartarDupli.put(sujeto.getCodigo(), "");


				sujeto.setRazon_social(nombreCompleto);
				sujeto.setNroTarjeta(tarjeta.get());

				// Buscar la categoria
				String codCateg = categoria.get().trim();
				CategoriaSujetoTurno categSujTurno = CategoriaSujetoTurno.findByCodigo(codCateg, this.getSesion());
				if (categSujTurno == null) {
					errores.add("Error: Socio:" + codigoSocio + " " + nombreCompleto + " tiene la categoría " + codCateg
							+ " que es desconocida");
					huboError = true;
				} else
					sujeto.setCategoriaSujetoTurno(categSujTurno);

				String codRelacion = relacion.get().trim();
				RelacionSujetoTurno relacionSujTurno = RelacionSujetoTurno.findByCodigo(codRelacion, this.getSesion());
				if (relacionSujTurno == null) {
					errores.add("Error: Socio:" + codigoSocio + " " + nombreCompleto + " tiene la relación " + codRelacion
							+ " que es desconocida");
					huboError = true;
				} else
					sujeto.setRelacionSujetoTurno(relacionSujTurno);

				if (huboError == false) {
					this.addTransaccion(sujeto);
					cantOK++;
				} else {
					cantError++;
				}

			}
			tablaSocios.close();
		} catch (xBaseJException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//
		addLog("Fecha última importación:" + Fecha.getddmmyyyy(Fecha.getFechaActual()));
		addLog("...");
		addLog("Resultado proceso de importación");
		addLog("...");
		addLog("Sujetos actualizados correctamente:" + cantOK);
		addLog("Sujetos con errores:" + cantError);
		addLog("...");
		addLog("Detalle de los errores");
		addLog("...");

		if (errores.size() == 0)
			addLog(" Sin errores.");
		else {
			Iterator iterErrores = errores.iterator();
			while (iterErrores.hasNext()) {
				String error = (String) iterErrores.next();
				addLog(error);
			}
		}

	}

	public void addLog(String descripcion) throws BaseException {
		LogImpSujTurno log = (LogImpSujTurno) LogImpSujTurno.getNew(LogImpSujTurno.NICKNAME, this.getSesion());
		log.setFecha(Fecha.getFechaActual());
		log.setDescripcion(descripcion);
		this.addTransaccion(log);
	}

	private TipoDocumento getTipoDocumentoDefault() throws BaseException {
		if (this.tipoDocumento == null)
			this.tipoDocumento = TipoDocumento.getTipoDocumentoImportacionSujTurnos(this.getSesion());
		return this.tipoDocumento;

	}

	private void importarReglaConcSocio() throws BaseException {

		String archivo = RelaConcSujTur.getArchDBFRelaConcSocio(this.getSesion());

		try {

			try {

				String ejecutar = ValorParametro.findByCodigoParametro("BAT_COPY_ARCH_RELA_CONC_CLUB", this.getSesion()).getValorCadena();

				Process p = Runtime.getRuntime().exec(ejecutar);
				p.waitFor(); // si quieres esperar a que la ejecucion finalize
			} catch (Exception err) {
				// El tratamiento de error que te salga de los huevos
			}

			DBF tabla = new DBF(archivo, org.xBaseJ.DBF.READ_ONLY);
			NumField nroSocio = (NumField) tabla.getField("socio");
			CharField concepto = (CharField) tabla.getField("concepto");
			NumField cantidad = (NumField) tabla.getField("cantidad");
			NumField numero = (NumField) tabla.getField("numero");
			CharField desde = (CharField) tabla.getField("desde");
			CharField hasta = (CharField) tabla.getField("hasta");

			// Buscar sujeto por codigo
			RelaConcSujTur.deleteAll(this.getSesion());

			for (int i = 1; i <= tabla.getRecordCount(); i++) {
				tabla.read();

				Integer campoSocio = new Integer(nroSocio.get().trim());
				String campoConcepto = concepto.get().trim();
				Double campoCantidad = new Double(cantidad.get().trim());
				Integer campoNumero = new Integer(numero.get().trim());

				String campoDesde = desde.get().trim();
				String campoHasta = hasta.get().trim();

				java.util.Date fechaDesde = null;
				Integer anio = null;
				Integer mes = null;
				if (campoDesde.trim().length() == 6) {
					// Obtener fecha Desde
					anio = new Integer(campoDesde.trim().substring(0, 4));
					mes = new Integer(campoDesde.trim().substring(4, 6));
					fechaDesde = Fecha.getFecha(1, mes, anio);
				}

				java.util.Date fechaHasta = null;
				if (campoHasta.trim().length() == 6) {
					anio = new Integer(campoHasta.trim().substring(0, 4));
					mes = new Integer(campoHasta.trim().substring(4, 6));
					int ultDia = Fecha.getUltimoDiaMesFechaDada(Fecha.getFecha(1, mes, anio));
					fechaHasta = Fecha.getFecha(ultDia, mes, anio);
				}

				RelaConcSujTur rela = (RelaConcSujTur) RelaConcSujTur.getNew(RelaConcSujTur.NICKNAME, this.getSesion());
				rela.setConcepto(campoConcepto);
				rela.setNro_socio(campoSocio);
				rela.setCantidad(campoCantidad.intValue());
				rela.setNumero(campoNumero);
				if (fechaDesde != null)
					rela.setDesde(Fecha.getFechaTruncada(fechaDesde));
				if (fechaHasta != null)
					rela.setHasta(Fecha.getFechaTruncada(fechaHasta));
				rela.save();

			}
			tabla.close();
		} catch (xBaseJException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
