package com.srn.erp.turnos.bm;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.xBaseJ.DBF;
import org.xBaseJ.xBaseJException;
import org.xBaseJ.fields.CharField;
import org.xBaseJ.fields.DateField;
import org.xBaseJ.fields.NumField;

import com.srn.erp.ventas.bm.Sujeto;

import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.Fecha;
import framework.applicarionServer.bm.Parametros.ValorParametro;
import framework.applicarionServer.bm.Varios.Money;
import framework.request.bl.Utils.BaseException;

public class DeudaSujetoTurno {

	List gruposConceptos = new ArrayList();

	List detMov = new ArrayList();
	private boolean addDet = true;

	int nroSocio;
	static String archivoMovimiento;
	ISesion sesion;
	private String comportamiento;
	private java.util.Date fecha;

	public DeudaSujetoTurno(ISesion aSesion) {
		this.sesion = aSesion;
	}

	public void setNroSocio(int aNroSocio) throws BaseException {
		this.nroSocio = aNroSocio;
		this.detMov.clear();
		addDet = true;
	}

	public void setFecha(java.util.Date aFecha) throws BaseException {
		this.fecha = aFecha;
	}

	public void setComportamiento(String aComportamiento) throws BaseException {
		this.comportamiento = aComportamiento;
	}

	public int getNroSocio() throws BaseException {
		return this.nroSocio;
	}

	private double traerDeudaOnLine() throws BaseException {

		// Obtener los Grupos
		gruposConceptos.clear();
		Iterator iterDeudasPorConc = DeudaPorConcTurno.getDeudasPorConc(
				comportamiento, sesion).iterator();
		while (iterDeudasPorConc.hasNext()) {

			DeudaPorConcTurno deudaPorConcTur = (DeudaPorConcTurno) iterDeudasPorConc
					.next();

			ItemDeudaGrupo itemDeudaGrupo = new ItemDeudaGrupo();
			itemDeudaGrupo.inicializar();
			itemDeudaGrupo.setDeudaPorConc(deudaPorConcTur);
			itemDeudaGrupo.setFecActual(fecha);
			itemDeudaGrupo.setDeudaSujetoTurno(this);

			gruposConceptos.add(itemDeudaGrupo);

		}

		double t = 0;
		Integer nro = null;

		try {
			
			
			try {

				String ejecutar = ValorParametro.findByCodigoParametro("BAT_COPY_ARCH_MOV_CLUB", this.sesion).getValorCadena();

				Process p = Runtime.getRuntime().exec(ejecutar);
				p.waitFor(); // si quieres esperar a que la ejecucion finalize
			} catch (Exception err) {
				// El tratamiento de error que te salga de los huevos
			}
			

			DBF tablaMov = new DBF(getArchivoMovimiento(),org.xBaseJ.DBF.READ_ONLY);
			

			// tablaMov.createIndex("c:\\prueba.ndx","socio",true,false);

			CharField peri = (CharField) tablaMov.getField("periodo");
			NumField nroSocio = (NumField) tablaMov.getField("socio");
			NumField importe = (NumField) tablaMov.getField("importe");
			NumField pagado = (NumField) tablaMov.getField("pagado");
			CharField mov = (CharField) tablaMov.getField("codmov");
			//DateField fecha = (DateField) tablaMov.getField("fecha");
			// Tomar la fecha armando la misma con el periodo
			
			NumField nroMov = (NumField) tablaMov.getField("nromov");
			CharField concepto = (CharField) tablaMov.getField("cptopago");
			

			t = 0;

			int cantReg = tablaMov.getRecordCount();

			for (int i = 1; i <= cantReg; i++) {
				tablaMov.read();

				nro = new Integer(nroSocio.get().trim());

				if (!((mov.get().trim().equals("FAC") || mov.get().trim()
						.equals("ND"))))
					continue;

				if (nro.intValue() != this.getNroSocio())
					continue;
				
				java.util.Date fecDeuda = Fecha.getFecha(1, new Integer(peri.get().substring(4,6)), new Integer(peri.get().substring(0,4)));
				

				t = t + new Double(importe.get());
				String impoPagado = pagado.get();

				try {
					t = t - new Double(impoPagado);
				} catch (Exception e) {
				}

				if (addDet) {
					ItemDeudaSujetoTurno itemDeudaSujTur = new ItemDeudaSujetoTurno();
					itemDeudaSujTur.setCodMov(mov.get());
					itemDeudaSujTur.setConcepto(concepto.get());
					itemDeudaSujTur.setFecha(fecDeuda);
					itemDeudaSujTur.setImporte(new Double(importe.get()));
					itemDeudaSujTur.setNroMov(new Integer(nroMov.get().trim()));
					try {
						itemDeudaSujTur.setPagado(new Double(pagado.get()));
					} catch (Exception e) {
					}

					if ((itemDeudaSujTur.getImporte() > 0)
							&& (itemDeudaSujTur.getPagado() < itemDeudaSujTur
									.getImporte())) {
						detMov.add(itemDeudaSujTur);

						// Acumular por grupo de conceptos
						Iterator iterGruposConc = gruposConceptos.iterator();
						while (iterGruposConc.hasNext()) {
							ItemDeudaGrupo itemDeudaGrupo = (ItemDeudaGrupo) iterGruposConc
									.next();
							String descCompro = mov.get().trim()
									+ "-"
									+ nroMov.get().trim()
									+ " "
									+ concepto.get().trim()
									+ "-"
									+ GrupoConceptoTurno.getDescConcSistClubes(
											concepto.get().trim(), sesion)
									+ " Período "+
									peri + " Monto:"
									+ itemDeudaSujTur.getSaldoPendPago();
							itemDeudaGrupo.addDeuda(fecDeuda, concepto.get(), new Money(
									itemDeudaSujTur.getImporte()
											- itemDeudaSujTur.getPagado()),
									descCompro);
						}

					}
				}

			}
			tablaMov.close();
			addDet = false;
		} catch (xBaseJException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return t;

	}

	private double traerDeudaOffLine() throws BaseException {

		// Obtener los Grupos
		gruposConceptos.clear();
		Iterator iterDeudasPorConc = DeudaPorConcTurno.getDeudasPorConc(
				comportamiento, sesion).iterator();
		while (iterDeudasPorConc.hasNext()) {

			DeudaPorConcTurno deudaPorConcTur = (DeudaPorConcTurno) iterDeudasPorConc
					.next();

			ItemDeudaGrupo itemDeudaGrupo = new ItemDeudaGrupo();
			itemDeudaGrupo.inicializar();
			itemDeudaGrupo.setDeudaPorConc(deudaPorConcTur);
			itemDeudaGrupo.setFecActual(fecha);
			itemDeudaGrupo.setDeudaSujetoTurno(this);

			gruposConceptos.add(itemDeudaGrupo);

		}

		double t = 0;
		Integer nro = null;

		Iterator iterImpoDeudaSujTur = ImpoDeudaSujetoTurnos.getDeuda(
				this.getNroSocio(), sesion).iterator();
		while (iterImpoDeudaSujTur.hasNext()) {
			ImpoDeudaSujetoTurnos impoDeudaSujTur = (ImpoDeudaSujetoTurnos) iterImpoDeudaSujTur
					.next();

			t = t + impoDeudaSujTur.getSaldo();

			if (addDet) {
				ItemDeudaSujetoTurno itemDeudaSujTur = new ItemDeudaSujetoTurno();
				itemDeudaSujTur.setCodMov(impoDeudaSujTur.getCod_mov());
				itemDeudaSujTur.setConcepto(impoDeudaSujTur.getConcepto());
				itemDeudaSujTur.setFecha(impoDeudaSujTur.getFecha());
				itemDeudaSujTur.setImporte(impoDeudaSujTur.getSaldo());
				itemDeudaSujTur.setNroMov(impoDeudaSujTur.getNro());
				itemDeudaSujTur.setPagado(new Double(0));

				if ((itemDeudaSujTur.getImporte() > 0)
						&& (itemDeudaSujTur.getPagado() < itemDeudaSujTur
								.getImporte())) {
					detMov.add(itemDeudaSujTur);

					// Acumular por grupo de conceptos
					Iterator iterGruposConc = gruposConceptos.iterator();
					while (iterGruposConc.hasNext()) {
						ItemDeudaGrupo itemDeudaGrupo = (ItemDeudaGrupo) iterGruposConc
								.next();
						String descCompro = impoDeudaSujTur.getCod_mov() + "-"
								+ impoDeudaSujTur.getNro() + " "
								+ impoDeudaSujTur.getConcepto() + " "
								+ Fecha.getddmmyyyy(impoDeudaSujTur.getFecha())
								+ " Monto:"
								+ itemDeudaSujTur.getSaldoPendPago();
						itemDeudaGrupo.addDeuda(impoDeudaSujTur.getFecha(),
								impoDeudaSujTur.getConcepto(), new Money(
										itemDeudaSujTur.getImporte()
												- itemDeudaSujTur.getPagado()),
								descCompro);
					}

				}

			}

		}

		addDet = false;

		return t;

	}

	public double getDeuda() throws BaseException {
		if (isTraerDeudaOnLine(sesion))
			return traerDeudaOnLine();
		else
			return traerDeudaOffLine();

	}

	private String getArchivoMovimiento() throws BaseException {
		if (archivoMovimiento == null) {
			ValorParametro paramNomArchMov = ValorParametro
					.findByCodigoParametro("ARCH_MOVI_SIST_CLUBES", sesion);
			archivoMovimiento = paramNomArchMov.getValorCadena();
		}
		return archivoMovimiento;
	}

	private static boolean isTraerDeudaOnLine(ISesion aSesion)
			throws BaseException {
		return ValorParametro.findByCodigoParametro("GET_DEUDA_SOCIO_ONLINE",
				aSesion).getBoolean();
	}

	private String getArchivoIndiceMovimiento() throws BaseException {
		ValorParametro paramNomArch = ValorParametro.findByCodigoParametro(
				"ARCH_INDICE_MOV_SOCIOS", sesion);
		return paramNomArch.getValorCadena();
	}

	public List getDetMov() throws BaseException {
		return this.detMov;
	}

	public List getGruposConceptos() throws BaseException {
		return gruposConceptos;
	}
	
	public String getNroSocioyNombre() throws BaseException {
		Sujeto sujeto = Sujeto.findByCodigo(new Integer(nroSocio).toString(), sesion);
		return sujeto.getCodigo()+" - "+sujeto.getRazon_social();
	}

}
