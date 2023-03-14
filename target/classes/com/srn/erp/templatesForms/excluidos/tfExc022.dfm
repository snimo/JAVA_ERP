inherited FProcesoActEstInd: TFProcesoActEstInd
  Left = 133
  Top = 35
  Width = 763
  Height = 641
  Caption = 'Proceso de Actualizaci'#243'n de Estados de Individuos'
  PixelsPerInch = 96
  TextHeight = 13
  object snLabel1: TsnLabel [0]
    Left = 32
    Top = 32
    Width = 479
    Height = 20
    Caption = 
      'Presione el bot'#243'n para actualizar los estados de todos los indiv' +
      'iduos'
    Font.Charset = DEFAULT_CHARSET
    Font.Color = clBlue
    Font.Height = -16
    Font.Name = 'MS Sans Serif'
    Font.Style = []
    ParentFont = False
  end
  object BotonActualizar: TsnButton [1]
    Left = 40
    Top = 72
    Width = 353
    Height = 27
    Caption = 'Actualizar estados de Individduos'
    Font.Charset = DEFAULT_CHARSET
    Font.Color = clWindowText
    Font.Height = -16
    Font.Name = 'MS Sans Serif'
    Font.Style = []
    ParentFont = False
    TabOrder = 0
    LookAndFeel.Kind = lfOffice11
  end
  inherited dxComponentPrinter: TdxComponentPrinter
    inherited dxComponentPrinterLink1: TdxCustomContainerReportLink
      Component = Owner
      BuiltInReportLink = True
      HiddenComponents = {}
      ExcludedComponents = {}
      AggregatedReportLinks = {}
    end
  end
  inherited DriverEvent: TDriverEvent
    OnFormFunction = <
      item
        Source.Strings = (
          'procedure ActualizarEstados();'
          'begin'
          '  operacion.InicioOperacion();'
          '  operacion.setOper('#39'SaveActuEstadosExc'#39');'
          '  operacion.execute(); '
          '  mensaje.information('#39'Proceso finalizado.'#39');'
          'end;')
      end>
    OnClickToolButton = <
      item
        ButtonName = 'BotonActualizar'
        Source.Strings = (
          'begin'
          
            '   if (mensaje.question('#39'Desea actualizar el estado de todos los' +
            ' individuos?'#39')=false)'
          '       then exit;'
          '  ActualizarEstados();'
          'end.')
      end>
  end
  inherited ImprimirObjetoSeleccionado: TdxComponentPrinter
    inherited ImprimirObjetoSeleccionadodxComponentPrinterLink: TdxGridReportLink
      BuiltInReportLink = True
    end
  end
end
