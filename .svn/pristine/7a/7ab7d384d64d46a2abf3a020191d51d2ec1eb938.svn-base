package com.srn.erp.cip.op;

import java.util.Iterator;

import com.srn.erp.cip.bm.IdentificadoresDeLegajosCIP;
import com.srn.erp.cip.bm.InterpretarNroValCIP;
import com.srn.erp.cip.bm.PrepararLB;
import com.srn.erp.cip.bm.Puerta;
import com.srn.erp.cip.bm.TarjetaLegajo;
import com.srn.erp.cip.bm.TiposAlimListaBlanca;
import com.srn.erp.cip.bm.UtilCIP;
import com.srn.erp.sueldos.bm.Legajo;

import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bm.Parametros.ValorParametro;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.MapDatos;

public class PrepararListaBlancaNegra extends Operation {

	boolean readCargaLegajos = false;
	boolean readCargaTarjetas = false;
	private Puerta puerta = null;
	private String  respRecNroTarj = null;

	public PrepararListaBlancaNegra() {
	}

	private void prepararListaSal(Puerta puerta, HashTableDatos listaValores) throws BaseException {

		// Determinar la lista Blanca / Negra para los Legajos
		if (puerta.getIdentifLegSal().equals(IdentificadoresDeLegajosCIP.IDENTIF_LEGAJO)) {
			if (puerta.getTipoAlimLBSal().equals(TiposAlimListaBlanca.TIP_ALI_TODOS)) {
				if (readCargaLegajos == false) {
					Iterator iterLegajos = Legajo.getAllLegajosActivosConIdentif(this.getSesion()).iterator();
					while (iterLegajos.hasNext()) {
						Legajo legajo = (Legajo) iterLegajos.next();
						listaValores.put(legajo.getIDIdentificacion(), Legajo.NICKNAME);
					}
				}
			}
		}

		// Determinar la lista Blanca / Negra pero con los Tarjetas
		if (puerta.getIdentifLegSal().equals(IdentificadoresDeLegajosCIP.NRO_TARJETA)) {
			if (puerta.getTipoAlimLBSal().equals(TiposAlimListaBlanca.TIP_ALI_TODOS)) {
				if (readCargaTarjetas == false) {
					boolean reconvertir = isReconvertirNroTarjENListaBlanca(this.getSesion());
					Iterator iterTarLeg = TarjetaLegajo.getTarjetasActivas(this.getSesion()).iterator();
					while (iterTarLeg.hasNext()) {
						TarjetaLegajo tarjetaLegajo = (TarjetaLegajo) iterTarLeg.next();
						Integer nro = 0;
						try {
							nro = new Integer(tarjetaLegajo.getNro_tarjeta());
						} catch (Exception e) {
							continue;
						}
						;
						if (nro.intValue() != 0) {
							if ((puerta.getInterpretarNroSal().equals(InterpretarNroValCIP.B1FC_U2DBNRO)) && reconvertir)
								nro = InterpretarNroValCIP.getB1FCYU2BNROInverso(nro.toString());
							listaValores.put(nro, tarjetaLegajo);
						}
					}
				}
			}
		}

	}

	private void prepararListaEnt(Puerta puerta, HashTableDatos listaValores) throws BaseException {
		// Determinar la lista Blanca / Negra para los Legajos
		if (puerta.getIdentifLegEntrada().equals(IdentificadoresDeLegajosCIP.IDENTIF_LEGAJO)) {
			if (puerta.getTipoAlimLBEnt().equals(TiposAlimListaBlanca.TIP_ALI_TODOS)) {
				readCargaLegajos = true;
				Iterator iterLegajos = Legajo.getAllLegajosActivosConIdentif(this.getSesion()).iterator();
				while (iterLegajos.hasNext()) {
					Legajo legajo = (Legajo) iterLegajos.next();
					listaValores.put(legajo.getIDIdentificacion(), legajo);
				}
			}
		}

		// Determinar la lista Blanca / Negra pero con los Tarjetas
		if (puerta.getIdentifLegEntrada().equals(IdentificadoresDeLegajosCIP.NRO_TARJETA)) {
			if (puerta.getTipoAlimLBEnt().equals(TiposAlimListaBlanca.TIP_ALI_TODOS)) {
				readCargaTarjetas = true;
				Iterator iterTarLeg = TarjetaLegajo.getTarjetasActivas(this.getSesion()).iterator();
				boolean reconvertir = isReconvertirNroTarjENListaBlanca(this.getSesion());
				while (iterTarLeg.hasNext()) {
					TarjetaLegajo tarjetaLegajo = (TarjetaLegajo) iterTarLeg.next();
					Integer nro = 0;
					try {
						nro = new Integer(tarjetaLegajo.getNro_tarjeta());
					} catch (Exception e) {
						continue;
					}
					if (nro.intValue() != 0) {
						if ((puerta.getInterpretarNroEnt().equals(InterpretarNroValCIP.B1FC_U2DBNRO)) && reconvertir)
							nro = InterpretarNroValCIP.getB1FCYU2BNROInverso(nro.toString());
						listaValores.put(nro, tarjetaLegajo);
					}
				}
			}
		}

	}

	public void execute(MapDatos mapaDatos) throws BaseException {

		Puerta puertaParam = null;
		Integer oidPuerta = null;
		if (mapaDatos != null)
			if (mapaDatos.containsKey("oid_puerta"))
				oidPuerta = mapaDatos.getInteger("oid_puerta");
		if ((oidPuerta != null) && (oidPuerta.intValue() > 0))
			puertaParam = Puerta.findByOid(oidPuerta, this.getSesion());
		
		//long start = System.currentTimeMillis();
		
		Iterator iterPuertas = Puerta.getPuertasActivas(this.getSesion()).iterator();
		while (iterPuertas.hasNext()) {

			Puerta puerta = (Puerta) iterPuertas.next();
			if ((puertaParam != null) && (puertaParam.getOID() != puerta.getOID()))
				continue;

			HashTableDatos listaValores = new HashTableDatos();
			prepararListaEnt(puerta, listaValores);
			prepararListaSal(puerta, listaValores);

			// Borrar la lista Blanca de la Puerta

			puerta.supportRefresh();
			
			if (listaValores!=null)
				puerta.setCantRegLP(listaValores.size());
			puerta.save();
			
			try {
				if (this.getSesion()!=null)
					this.getSesion().commitTransaction();
			} catch(Exception e) {
				if (this.getSesion()!=null)
					this.getSesion().rollBackTransaction();			
			}			

			PrepararLB prepararLB =
				PrepararLB.getPrepararLB(puerta, this.getSesion());
			if (prepararLB == null)
				prepararLB = (PrepararLB) PrepararLB.getNew(PrepararLB.NICKNAME, this.getSesion());
			java.util.Date fecha = UtilCIP.getFechaHoraActual(this.getSesion());
			prepararLB.setFecha_preparacion(fecha);
			String hora = UtilCIP.getHHMM(fecha);
			prepararLB.setHora_prep(hora);
			prepararLB.setPuerta(puerta);
			prepararLB.setActivo(true);
			prepararLB.save();
			
			try {
				if (this.getSesion()!=null)
					this.getSesion().commitTransaction();
			} catch(Exception e) {
				if (this.getSesion()!=null)
					this.getSesion().rollBackTransaction();			
			}			
			
			puerta.setListaBlancaAGrabar(listaValores);
			puerta.grabarLB();
			
			try {
				if (this.getSesion()!=null)
					this.getSesion().commitTransaction();
			} catch(Exception e) {
				if (this.getSesion()!=null)
					this.getSesion().rollBackTransaction();			
			}			
							
			
			
			// long end = System.currentTimeMillis();
			// System.out.println("Segundos: "+(end - start)/1000);
		}

	}
	
	private boolean isReconvertirNroTarjENListaBlanca(ISesion aSesion) throws BaseException {
		
		try {
			if(respRecNroTarj == null)
			{
				respRecNroTarj = ValorParametro.findByCodigoParametro("RECONV_NRO_TARJ_EN_LB", aSesion).getValorCadena();
			}	
			if (respRecNroTarj == null) return false;
		} catch (Exception e) {
			return false;
		}
		if ((respRecNroTarj!=null) && (respRecNroTarj.toLowerCase().startsWith("s")))
			return true;
		else
			return false;
	}
	

}
