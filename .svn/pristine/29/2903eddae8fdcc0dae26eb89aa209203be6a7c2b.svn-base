inherited FImpLegPAYROLL: TFImpLegPAYROLL
  Left = 118
  Top = 233
  Width = 868
  Caption = 'Importaci'#243'n de Legajos de PAYROLL'
  PixelsPerInch = 96
  TextHeight = 13
  object snLabel1: TsnLabel [0]
    Left = 56
    Top = 88
    Width = 743
    Height = 16
    Caption = 
      'El siguiente proceso importar los legajos de PAYROLL y los pasa ' +
      'al sistema SEC (Sistema de Evaluaci'#243'n de Competencias)'
    Font.Charset = DEFAULT_CHARSET
    Font.Color = clBlue
    Font.Height = -13
    Font.Name = 'MS Sans Serif'
    Font.Style = []
    ParentFont = False
  end
  object snLabel2: TsnLabel [1]
    Left = 56
    Top = 112
    Width = 413
    Height = 16
    Caption = 
      'Presione el siguiente bot'#243'n para comenza el proceso de importaci' +
      #243'n:'
    Font.Charset = DEFAULT_CHARSET
    Font.Color = clBlue
    Font.Height = -13
    Font.Name = 'MS Sans Serif'
    Font.Style = []
    ParentFont = False
  end
  object ImageSalir: TImage [2]
    Tag = 7
    Left = 18
    Top = 9
    Width = 32
    Height = 32
    Cursor = crHandPoint
    Hint = 'Salir'
    ParentShowHint = False
    ShowHint = True
  end
  object snLabel3: TsnLabel [3]
    Left = 24
    Top = 48
    Width = 191
    Height = 20
    Caption = 'Proceso de Importaci'#243'n'
    Font.Charset = DEFAULT_CHARSET
    Font.Color = clBlue
    Font.Height = -16
    Font.Name = 'MS Sans Serif'
    Font.Style = [fsBold]
    ParentFont = False
  end
  object Boton: TsnButton [4]
    Left = 56
    Top = 144
    Width = 153
    Height = 49
    Cursor = crHandPoint
    Caption = 'Comenzar Proceso ....'
    Font.Charset = DEFAULT_CHARSET
    Font.Color = clWindowText
    Font.Height = -13
    Font.Name = 'MS Sans Serif'
    Font.Style = []
    ParentFont = False
    TabOrder = 0
    LookAndFeel.Kind = lfOffice11
  end
  inherited DriverABM: TDriverABM
    Left = 560
  end
  inherited Operacion: TOperacion
    Left = 600
  end
  inherited dxComponentPrinter: TdxComponentPrinter
    Left = 640
    inherited dxComponentPrinterLink1: TdxCustomContainerReportLink
      Component = Owner
      BuiltInReportLink = True
      HiddenComponents = {}
      ExcludedComponents = {}
      AggregatedReportLinks = {}
    end
  end
  inherited SaveDialog: TSaveDialog
    Left = 680
  end
  inherited DriverEvent: TDriverEvent
    OnInicializar = <
      item
        Source.Strings = (
          'begin'
          '  varios.setImagen('#39'ImageSalir'#39',7);'
          'end.')
      end>
    OnClickToolButton = <
      item
        ButtonName = 'Boton'
        Source.Strings = (
          'begin'
          ''
          '   if (not (mensaje.question('#39'Desea comenzar el proceso?'#39') ))'
          '      then exit;'
          '   operacion.InicioOperacion();'
          '   operacion.setOper('#39'ImpLegPAYROLL'#39');'
          '   operacion.execute();        '
          ''
          '   mensaje.information('#39'Importaci'#243'n finalizada'#39');'
          ''
          'end.')
      end
      item
        ButtonName = 'ImageSalir'
        Source.Strings = (
          'begin'
          '  close();'
          'end.')
      end>
    Left = 720
  end
  inherited ImprimirObjetoSeleccionado: TdxComponentPrinter
    inherited ImprimirObjetoSeleccionadodxComponentPrinterLink: TdxGridReportLink
      BuiltInReportLink = True
    end
  end
  object Varios: TsnVarios
    Operacion = Operacion
    Left = 640
    Top = 185
  end
end
