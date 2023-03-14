inherited FInfoConciAut: TFInfoConciAut
  Left = 231
  Top = 186
  Width = 470
  Height = 192
  BorderIcons = [biSystemMenu]
  Caption = 'Corrida Conciliaci'#243'n Autom'#225'tica'
  DragKind = dkDrag
  DragMode = dmManual
  Position = poScreenCenter
  PixelsPerInch = 96
  TextHeight = 13
  object snLabel1: TsnLabel [0]
    Left = 24
    Top = 24
    Width = 94
    Height = 16
    Caption = 'Nro. de Corrida:'
    Font.Charset = DEFAULT_CHARSET
    Font.Color = clWindowText
    Font.Height = -13
    Font.Name = 'MS Sans Serif'
    Font.Style = []
    ParentFont = False
  end
  object snLabel2: TsnLabel [1]
    Left = 24
    Top = 56
    Width = 210
    Height = 16
    Caption = 'Cantidad de Cupones Procesados:'
    Font.Charset = DEFAULT_CHARSET
    Font.Color = clWindowText
    Font.Height = -13
    Font.Name = 'MS Sans Serif'
    Font.Style = []
    ParentFont = False
  end
  object snLabel3: TsnLabel [2]
    Left = 24
    Top = 88
    Width = 207
    Height = 16
    Caption = 'Cantidad de Cupones Conciliados:'
    Font.Charset = DEFAULT_CHARSET
    Font.Color = clWindowText
    Font.Height = -13
    Font.Name = 'MS Sans Serif'
    Font.Style = []
    ParentFont = False
  end
  object BotonSalir: TsnButton [3]
    Left = 360
    Top = 120
    Width = 75
    Height = 25
    Caption = '&Salir'
    Font.Charset = DEFAULT_CHARSET
    Font.Color = clWindowText
    Font.Height = -13
    Font.Name = 'MS Sans Serif'
    Font.Style = []
    ParentFont = False
    TabOrder = 0
    LookAndFeel.Kind = lfOffice11
  end
  object snDBEdit1: TsnDBEdit [4]
    Left = 247
    Top = 21
    DataBinding.DataField = 'nro_corrida'
    DataBinding.DataSource = DSCorrida
    ParentFont = False
    Properties.ReadOnly = True
    Style.Font.Charset = DEFAULT_CHARSET
    Style.Font.Color = clWindowText
    Style.Font.Height = -13
    Style.Font.Name = 'MS Sans Serif'
    Style.Font.Style = [fsBold]
    Style.IsFontAssigned = True
    TabOrder = 1
    Width = 82
  end
  object snDBEdit2: TsnDBEdit [5]
    Left = 247
    Top = 53
    DataBinding.DataField = 'procesados'
    DataBinding.DataSource = DSCorrida
    ParentFont = False
    Properties.ReadOnly = True
    Style.Font.Charset = DEFAULT_CHARSET
    Style.Font.Color = clWindowText
    Style.Font.Height = -13
    Style.Font.Name = 'MS Sans Serif'
    Style.Font.Style = [fsBold]
    Style.IsFontAssigned = True
    TabOrder = 2
    Width = 82
  end
  object snDBEdit3: TsnDBEdit [6]
    Left = 247
    Top = 85
    DataBinding.DataField = 'conciliados'
    DataBinding.DataSource = DSCorrida
    ParentFont = False
    Properties.ReadOnly = True
    Style.Font.Charset = DEFAULT_CHARSET
    Style.Font.Color = clWindowText
    Style.Font.Height = -13
    Style.Font.Name = 'MS Sans Serif'
    Style.Font.Style = [fsBold]
    Style.IsFontAssigned = True
    TabOrder = 3
    Width = 82
  end
  inherited DriverABM: TDriverABM
    Left = 264
    Top = 8
  end
  inherited Operacion: TOperacion
    Left = 304
    Top = 8
  end
  inherited dxComponentPrinter: TdxComponentPrinter
    Left = 344
    Top = 8
    inherited dxComponentPrinterLink1: TdxCustomContainerReportLink
      Component = Owner
      BuiltInReportLink = True
      HiddenComponents = {}
      ExcludedComponents = {}
      AggregatedReportLinks = {}
    end
  end
  inherited SaveDialog: TSaveDialog
    Left = 384
    Top = 8
  end
  inherited DriverEvent: TDriverEvent
    OnShow.Strings = (
      'begin'
      '  TCorrida.Close;'
      '  TCorrida.Open;'
      '  TCorrida.AppendRecord;'
      
        '  TCorrida.FieldName('#39'nro_corrida'#39').AsInteger := variable.getInt' +
        'eger('#39'nro_corrida'#39');'
      
        '  TCorrida.FieldName('#39'procesados'#39').AsInteger := variable.getInte' +
        'ger('#39'procesados'#39');'
      
        '  TCorrida.FieldName('#39'conciliados'#39').AsInteger := variable.getInt' +
        'eger('#39'conciliados'#39');'
      'end.')
    OnPublicVariable = <
      item
        VariableName = 'nro_corrida'
      end
      item
        VariableName = 'conciliados'
      end
      item
        VariableName = 'procesados'
      end>
    OnClickToolButton = <
      item
        ButtonName = 'BotonSalir'
        Source.Strings = (
          'begin'
          '  close();'
          'end.')
      end>
    Left = 424
    Top = 11
  end
  inherited SaveArchivo: TSaveDialog
    Top = 88
  end
  inherited ImprimirObjetoSeleccionado: TdxComponentPrinter
    Left = 288
    Top = 120
    inherited ImprimirObjetoSeleccionadodxComponentPrinterLink: TdxGridReportLink
      BuiltInReportLink = True
    end
  end
  object TCorrida: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <>
    IndexDefs = <>
    RecalcOnFetch = False
    SortOptions = []
    PersistentBackup = False
    ProgressFlags = [mtpcLoad, mtpcSave, mtpcCopy]
    VersioningMode = mtvmAllSinceCheckPoint
    FilterOptions = []
    Version = '4.08b'
    LanguageID = 0
    SortID = 0
    SubLanguageID = 1
    LocaleID = 1024
    MensajeValorDuplicadoIndice = 'Valor Duplicado'
    Left = 32
    Top = 8
    object TCorridanro_corrida: TIntegerField
      FieldName = 'nro_corrida'
    end
    object TCorridaprocesados: TIntegerField
      FieldName = 'procesados'
    end
    object TCorridaconciliados: TIntegerField
      FieldName = 'conciliados'
    end
  end
  object DSCorrida: TDataSource
    DataSet = TCorrida
    Left = 64
    Top = 8
  end
end
