inherited FPlanifCacheos: TFPlanifCacheos
  Left = 147
  Top = 182
  Width = 851
  Height = 444
  Caption = 'Planificaci'#243'n de Cacheos'
  PixelsPerInch = 96
  TextHeight = 13
  object Panel1: TPanel [0]
    Left = 0
    Top = 0
    Width = 843
    Height = 41
    Align = alTop
    BevelOuter = bvNone
    Color = clWindow
    TabOrder = 0
    object ImageBuscar: TImage
      Left = 18
      Top = 5
      Width = 32
      Height = 32
      Cursor = crHandPoint
      Hint = '<F12> Traer Cacheos Planificados'
      ParentShowHint = False
      ShowHint = True
    end
    object ImageSalir: TImage
      Tag = 7
      Left = 66
      Top = 5
      Width = 32
      Height = 32
      Cursor = crHandPoint
      Hint = 'Salir'
      ParentShowHint = False
      ShowHint = True
    end
  end
  object Panel2: TPanel [1]
    Left = 0
    Top = 41
    Width = 843
    Height = 369
    Align = alClient
    Color = clWindow
    TabOrder = 1
    object snLabel1: TsnLabel
      Left = 24
      Top = 16
      Width = 289
      Height = 16
      Caption = 'Ingrese el rango de fechas para planificar cacheos'
      Font.Charset = ANSI_CHARSET
      Font.Color = clNavy
      Font.Height = -13
      Font.Name = 'Arial'
      Font.Style = [fsUnderline]
      ParentFont = False
    end
    object snLabel2: TsnLabel
      Left = 56
      Top = 56
      Width = 75
      Height = 16
      Caption = 'Fecha desde'
      Font.Charset = ANSI_CHARSET
      Font.Color = clWindowText
      Font.Height = -13
      Font.Name = 'Arial'
      Font.Style = []
      ParentFont = False
    end
    object snLabel3: TsnLabel
      Left = 280
      Top = 56
      Width = 67
      Height = 16
      Caption = 'fecha hasta'
      Font.Charset = ANSI_CHARSET
      Font.Color = clWindowText
      Font.Height = -13
      Font.Name = 'Arial'
      Font.Style = []
      ParentFont = False
    end
    object snDBDateEdit1: TsnDBDateEdit
      Left = 136
      Top = 52
      DataBinding.DataField = 'fec_desde'
      DataBinding.DataSource = DSInput
      ParentFont = False
      Style.Font.Charset = DEFAULT_CHARSET
      Style.Font.Color = clWindowText
      Style.Font.Height = -13
      Style.Font.Name = 'MS Sans Serif'
      Style.Font.Style = []
      Style.IsFontAssigned = True
      TabOrder = 0
      ReadOnlyAlways = False
      Width = 121
    end
    object snDBDateEdit2: TsnDBDateEdit
      Left = 360
      Top = 52
      DataBinding.DataField = 'fec_hasta'
      DataBinding.DataSource = DSInput
      ParentFont = False
      Style.Font.Charset = DEFAULT_CHARSET
      Style.Font.Color = clWindowText
      Style.Font.Height = -13
      Style.Font.Name = 'MS Sans Serif'
      Style.Font.Style = []
      Style.IsFontAssigned = True
      TabOrder = 1
      ReadOnlyAlways = False
      Width = 121
    end
  end
  inherited DriverABM: TDriverABM
    Left = 224
    Top = 16
  end
  inherited Operacion: TOperacion
    Left = 264
    Top = 16
  end
  inherited dxComponentPrinter: TdxComponentPrinter
    Left = 304
    Top = 48
    inherited dxComponentPrinterLink1: TdxCustomContainerReportLink
      Component = Owner
      BuiltInReportLink = True
      HiddenComponents = {}
      ExcludedComponents = {}
      AggregatedReportLinks = {}
    end
  end
  inherited SaveDialog: TSaveDialog
    Left = 328
    Top = 48
  end
  inherited DriverEvent: TDriverEvent
    OnInicializar = <
      item
        Source.Strings = (
          'begin'
          '  varios.setImagen('#39'ImageBuscar'#39',0);'
          '  varios.setImagen('#39'ImageSalir'#39',7);'
          '  Inicializar();'
          'end.'
          '')
      end>
    OnFormFunction = <
      item
        Source.Strings = (
          'procedure Inicializar();'
          'begin'
          '  TInput.Close;'
          '  TInput.Open;'
          '  TInput.AppendRecord; '
          'end;'
          ''
          'procedure EjecutarConsulta();'
          'begin'
          ''
          '  TInput.PostRecord;'
          ''
          '  if (TInput.FieldName('#39'fec_desde'#39').IsNull)'
          
            '     then raiseException(erCustomError,'#39'Debe ingresar la fecha d' +
            'esde'#39');'
          '  if (TInput.FieldName('#39'fec_hasta'#39').IsNull)'
          
            '     then raiseException(erCustomError,'#39'Debe ingresar la fecha h' +
            'asta'#39');'
          '  '
          '  variable.newVariantArray('#39'parametros'#39',1);'
          
            '  variable.addKeyTableForArray('#39'parametros'#39',0,'#39'TInput'#39','#39'TInput'#39')' +
            ';  '
          ''
          
            '  FormResPlanifCacheo.params :=  variable.getValue('#39'parametros'#39')' +
            ';'
          '  FormResPlanifCacheo.Ventana := getVentana();'
          '  FormResPlanifCacheo.Mostrar(false);'
          ''
          'end;'
          '')
      end>
    OnClickToolButton = <
      item
        ButtonName = 'ImageSalir'
        Source.Strings = (
          'begin'
          '  close();'
          'end.')
      end
      item
        ButtonName = 'ImageBuscar'
        Source.Strings = (
          'begin'
          '  EjecutarConsulta();'
          'end.')
      end>
    Left = 368
    Top = 59
  end
  inherited ImprimirObjetoSeleccionado: TdxComponentPrinter
    inherited ImprimirObjetoSeleccionadodxComponentPrinterLink: TdxGridReportLink
      BuiltInReportLink = True
    end
  end
  object Varios: TsnVarios
    Operacion = Operacion
    Left = 376
    Top = 17
  end
  object TInput: TsnTable
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
    Left = 480
    Top = 129
    object TInputfec_desde: TDateField
      FieldName = 'fec_desde'
    end
    object TInputfec_hasta: TDateField
      FieldName = 'fec_hasta'
    end
  end
  object DSInput: TDataSource
    DataSet = TInput
    Left = 512
    Top = 129
  end
  object FormResPlanifCacheo: TFormulario
    Nombre = 'TFResPlanifCacheo'
    CreateAlwaysANewForm = True
    Left = 224
    Top = 278
  end
end
