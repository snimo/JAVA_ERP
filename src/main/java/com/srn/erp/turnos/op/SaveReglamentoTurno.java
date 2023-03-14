package com.srn.erp.turnos.op;

import com.srn.erp.turnos.bm.ReglamentoTurno;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveReglamentoTurno extends Operation { 

  public SaveReglamentoTurno() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    IDataSet dataset = mapaDatos.getDataSet("TReglamentoTurno"); 
    procesarRegistros(dataset); 
  } 

  private void procesarRegistros(IDataSet dataset) throws BaseException { 
    dataset.first(); 
      while (!dataset.EOF()) { 
        ReglamentoTurno reglamentoturno = ReglamentoTurno.findByOid(dataset.getInteger("oid_regla_cab"),getSesion());
        reglamentoturno.setOID(dataset.getInteger("oid_regla_cab"));
        reglamentoturno.setCodigo(dataset.getString("codigo"));
        reglamentoturno.setDescripcion(dataset.getString("descripcion"));
        reglamentoturno.setComportamiento(dataset.getString("comportamiento"));
        reglamentoturno.setActivo(dataset.getBoolean("activo"));
        reglamentoturno.setUsar(dataset.getBoolean("usar"));
        reglamentoturno.setReglaJugadorInactivo(dataset.getBoolean("regla_jug_inactivo"));
        reglamentoturno.setReglaJugadorSuspension(dataset.getBoolean("regla_jug_susp"));
        reglamentoturno.setReglaUnTurnoActivo(dataset.getBoolean("regla_juj_1tur_act"));
        reglamentoturno.setReglaDeudaCategoria(dataset.getBoolean("regla_deuda_categ"));
        reglamentoturno.setReglaDeudaGeneral(dataset.getBoolean("regla_deuda_gral"));
        reglamentoturno.setMontoDeudaGral(dataset.getMoney("monto_deuda_gral"));
        reglamentoturno.setReglaAntiguedadDeuda(dataset.getBoolean("regla_ant_deuda"));
        reglamentoturno.setDiasAntiguedadDeuda(dataset.getInteger("dias_ant_deuda"));
        reglamentoturno.setReglaTurnoSegunCategoria(dataset.getBoolean("regla_no_tur_categ"));
        reglamentoturno.setReglaTurnoSegunRelacion(dataset.getBoolean("regla_no_tur_rela"));
        reglamentoturno.setReglaDeudaConcepto(dataset.getBoolean("regla_deuda_conc"));
        reglamentoturno.setReglaConcSufCateg(dataset.getBoolean("regla_conc_suf_cat"));
        
               
        
        addTransaccion(reglamentoturno);
        dataset.next();
    }
  }
  
}
