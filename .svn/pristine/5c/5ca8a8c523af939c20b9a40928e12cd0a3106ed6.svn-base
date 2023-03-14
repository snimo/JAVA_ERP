package com.srn.erp.turnos.op;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.xBaseJ.DBF;
import org.xBaseJ.xBaseJException;
import org.xBaseJ.fields.CharField;
import org.xBaseJ.fields.DateField;
import org.xBaseJ.fields.NumField;

import com.srn.erp.turnos.bm.ImpoDeudaSujetoTurnos;

import framework.applicarionServer.bl.Utils.Fecha;
import framework.applicarionServer.bm.Parametros.ValorParametro;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;

public class ImpoCtaCteSujTurnos extends Operation {

	public ImpoCtaCteSujTurnos() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {

		Integer nro = null;
		
		try {
			
			ImpoDeudaSujetoTurnos.borrarTodo(this.getSesion());
			
			try {

				String ejecutar = ValorParametro.findByCodigoParametro("BAT_COPY_ARCH_MOV_CLUB", this.getSesion()).getValorCadena();

				Process p = Runtime.getRuntime().exec(ejecutar);
				p.waitFor(); // si quieres esperar a que la ejecucion finalize
			} catch (Exception err) {
				// El tratamiento de error que te salga de los huevos
			}
			

			DBF tablaMov = new DBF(getArchivoMovimiento(),org.xBaseJ.DBF.READ_ONLY);
			
			NumField nroSocio = (NumField) tablaMov.getField("socio");
			NumField importe = (NumField) tablaMov.getField("importe");
			NumField pagado = (NumField) tablaMov.getField("pagado");
			CharField mov = (CharField) tablaMov.getField("codmov");
			CharField periodo = (CharField) tablaMov.getField("periodo");
			DateField fecha = (DateField) tablaMov.getField("fecha");
			NumField nroMov = (NumField) tablaMov.getField("nromov");
			CharField concepto = (CharField) tablaMov.getField("cptopago");

			int cantReg = tablaMov.getRecordCount();

			for (int i = 1; i <= cantReg; i++) {
				tablaMov.read();

				try {
					nro = new Integer(nroSocio.get().trim());
				} catch(Exception e) {
					continue;
				}

				if (!((mov.get().trim().equals("FAC") || mov.get().trim()
						.equals("ND"))))
					continue;

				
				ImpoDeudaSujetoTurnos impoDeudaSujTur = (ImpoDeudaSujetoTurnos) ImpoDeudaSujetoTurnos.getNew(ImpoDeudaSujetoTurnos.NICKNAME, this.getSesion());
				impoDeudaSujTur.setNro_socio(nro);
				impoDeudaSujTur.setCod_mov(mov.get().trim());
				impoDeudaSujTur.setConcepto(concepto.get().trim());
				
				// Obtener la Fecha
				Integer anio = Fecha.getAnio(Fecha.getFechaActual());
				Integer mes = Fecha.getAnio(Fecha.getFechaActual());
				
				java.util.Date fechaPeri = null;
				if (periodo.get().trim().length()==6) {
					// Obtener fecha Desde
						anio = new Integer(periodo.get().trim().substring(0, 4));
						mes = new Integer(periodo.get().trim().substring(4, 6));				
					}
				fechaPeri = Fecha.getFechaTruncada(getFecha(1, mes, anio));
				
				
				impoDeudaSujTur.setFecha(fechaPeri);
				impoDeudaSujTur.setNro(new Integer(nroMov.get().trim()));
				double imp = 0;
				try {
				imp = new Double(importe.get().trim());
				} catch(Exception e) {}
				
				double pag = 0;
				try {
				pag = new Double(pagado.get().trim());
				} catch(Exception e) {}
				
				double saldo = imp-pag;
				impoDeudaSujTur.setSaldo(saldo);
				if (saldo!=0)
					impoDeudaSujTur.save();
				
				

			}
			tablaMov.close();
		} catch (xBaseJException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private String getArchivoMovimiento() throws BaseException {
		ValorParametro paramNomArchMov = ValorParametro.findByCodigoParametro(
				"ARCH_MOVI_SIST_CLUBES", this.getSesion());
		return paramNomArchMov.getValorCadena();
	}
	
	 public static Date getFecha(int dia,int mes,int anio) throws BaseException {
		 Calendar calendar = GregorianCalendar.getInstance();
		 calendar.set(anio,mes-1,dia);
		 Date aFecha = calendar.getTime();
		 aFecha.setHours(0);
		 aFecha.setMinutes(0);
		 aFecha.setSeconds(0);
		 return calendar.getTime();
	 }
	

}
