package com.srn.erp.turnos.bm;

import java.io.IOException;
import java.util.List;

import org.xBaseJ.DBF;
import org.xBaseJ.xBaseJException;
import org.xBaseJ.fields.CharField;
import org.xBaseJ.fields.DateField;
import org.xBaseJ.fields.NumField;

import com.srn.erp.turnos.da.DBGrupoConceptoTurno;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.applicarionServer.bm.Parametros.ValorParametro;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.ObjetoObservado;
import framework.request.bl.Utils.Validar;

public class GrupoConceptoTurno extends ObjetoLogico {

	@Override
	public Boolean isActivo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public GrupoConceptoTurno() {
	}

	public static String NICKNAME = "tu.GrupoConceptoTurno";

	private DeudaPorConcTurno deuda_por_concepto;
	private String concepto;

	public DeudaPorConcTurno getDeuda_por_concepto() throws BaseException {
		supportRefresh();
		return deuda_por_concepto;
	}

	public void setDeuda_por_concepto(DeudaPorConcTurno aDeuda_por_concepto) {
		this.deuda_por_concepto = aDeuda_por_concepto;
	}

	public String getConcepto() throws BaseException {
		supportRefresh();
		return concepto;
	}

	public void setConcepto(String aConcepto) {
		this.concepto = aConcepto;
	}

	public String getNickName() {
		return NICKNAME;
	}

	public static GrupoConceptoTurno findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (GrupoConceptoTurno) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static GrupoConceptoTurno findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (GrupoConceptoTurno) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(deuda_por_concepto, "Debe ingresar la Deuda");
		Validar.noNulo(concepto, "Debe ingresar el comportamiento");
	}

	public static List getConceptos(DeudaPorConcTurno deudaPorConcepto, ISesion aSesion) throws BaseException {
		return DBGrupoConceptoTurno.getConceptos(deudaPorConcepto, aSesion);
	}

	public static GrupoConceptoTurno getGrupoConceptoTurno(DeudaPorConcTurno deudaPorConcepto, String concepto, ISesion aSesion)
			throws BaseException {
		return DBGrupoConceptoTurno.getGrupoConceptoTurno(deudaPorConcepto, concepto, aSesion);
	}

	public static String getArchivoConceptos(ISesion aSesion) throws BaseException {
		ValorParametro paramNomArch = ValorParametro.findByCodigoParametro("ARCH_CONC_SIST_CLUBES", aSesion);
		return paramNomArch.getValorCadena();
	}

	public static HashTableDatos getConceptosSisteClubes(ISesion aSesion) throws BaseException {
		HashTableDatos conceptos = new HashTableDatos();

		DBF tabla = null;
		try {

			try {

				String ejecutar = ValorParametro.findByCodigoParametro("BAT_COPY_ARCH_CONC_CLUB", aSesion).getValorCadena();

				Process p = Runtime.getRuntime().exec(ejecutar);
				p.waitFor(); // si quieres esperar a que la ejecucion finalize
			} catch (Exception err) {
				// El tratamiento de error que te salga de los huevos
			}

			tabla = new DBF(getArchivoConceptos(aSesion), org.xBaseJ.DBF.READ_ONLY);

		} catch (xBaseJException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		CharField codigo = null;
		CharField descripcion = null;
		try {
			codigo = (CharField) tabla.getField("codconc");
			descripcion = (CharField) tabla.getField("descrip");
		} catch (ArrayIndexOutOfBoundsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (xBaseJException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		for (int i = 1; i <= tabla.getRecordCount(); i++) {
			try {
				tabla.read();
				conceptos.put(codigo.get().trim(), descripcion.get());

			} catch (xBaseJException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		try {
			tabla.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return conceptos;

	}

	public static String getDescConcSistClubes(String codigo, ISesion aSesion) throws BaseException {
		try {
			String desc = (String) getConceptosSisteClubes(aSesion).get(codigo);
			if (desc != null)
				return desc.trim();
			else
				return "";
		} catch (Exception e) {
			return "";
		}
	}

}
