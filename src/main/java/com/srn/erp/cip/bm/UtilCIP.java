package com.srn.erp.cip.bm;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.StringTokenizer;

import com.srn.erp.cip.da.DBFechaCIP;

import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;

public class UtilCIP {

	public static String getHoraHHMM(int minutos) throws BaseException {
		if (minutos == 0)
			return "00:00";

		int horas = (minutos / 60);
		int min = minutos - (horas * 60);

		NumberFormat formatHora = new DecimalFormat("00");
		return formatHora.format(horas) + ":" + formatHora.format(min);
	}
	
	public static final int getParteHoraEnHoras(String hora) throws BaseException {
		int horaCalc = 0;
		StringTokenizer st = new StringTokenizer(hora, ":");
		int i = 0;
		while (st.hasMoreTokens()) {
			String valor = st.nextToken();
			if (i == 0) {
				try {
					horaCalc = new Integer(valor).intValue();
					return horaCalc; 
				} catch (Exception e) {
					throw new ExceptionValidation(null, "Formato de hora incorrecto:" + valor + " Debe estar entre 0 y 23");
				}
			}
			++i;
		}
		return 0;		
	}
	
	public static final int getParteMinutosEnMinutos(String hora) throws BaseException {
		int minCalc = 0;
		StringTokenizer st = new StringTokenizer(hora, ":");
		int i = 0;
		while (st.hasMoreTokens()) {
			String valor = st.nextToken();
			if (i == 0) {
			} else if (i == 1) {
				minCalc = new Integer(valor).intValue();
				return minCalc; 
			}
			++i;
		}
		return 0;		
	}
	

	public static final int getHoraEnMin(String hora) throws BaseException {
		int totMin = 0;
		int horaCalc = 0;
		int minCalc = 0;
		StringTokenizer st = new StringTokenizer(hora, ":");
		int i = 0;
		while (st.hasMoreTokens()) {
			String valor = st.nextToken();
			if (i == 0) {
				try {
					horaCalc = new Integer(valor).intValue();
				} catch (Exception e) {
					throw new ExceptionValidation(null, "Formato de hora incorrecto:" + valor + " Debe estar entre 0 y 23");
				}
				if (!((horaCalc >= 0) && (horaCalc <= 23)))
					throw new ExceptionValidation(null, "Formato de hora incorrecto:" + valor + " Debe estar entre 0 y 23");
				totMin = totMin + (horaCalc * 60);
			} else if (i == 1) {
				try {
					minCalc = new Integer(valor).intValue();
				} catch (Exception e) {
					throw new ExceptionValidation(null, "Formato de Minutos incorrecto:" + valor + " Debe estar entre 0 y 59");
				}
				if (!((minCalc >= 0) && (minCalc <= 59)))
					throw new ExceptionValidation(null, "Formato de Minutos incorrecto:" + valor + " Debe estar entre 0 y 59");
				totMin = totMin + (minCalc);

			}
			++i;
		}
		return totMin;
	}

	public static java.util.Date getFechaHoraActual(ISesion aSesion) throws BaseException {
		return DBFechaCIP.getFechaActual(aSesion);
	}

	public static String getHHMM(java.util.Date fecha) throws BaseException {
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
		return sdf.format(fecha.getTime());
	}

	public synchronized static Date getTruncDate(java.util.Date fecha) throws BaseException {
		Calendar cal = GregorianCalendar.getInstance(); // get calendar instance
		cal.setTime(fecha); // set cal to date
		cal.set(Calendar.HOUR_OF_DAY, 0); // set hour to midnight
		cal.set(Calendar.MINUTE, 0); // set minute in hour
		cal.set(Calendar.SECOND, 0); // set second in minute
		cal.set(Calendar.MILLISECOND, 0); // set millis in second
		return cal.getTime();
	}

}
