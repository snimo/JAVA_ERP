inherited FCacheoPersona: TFCacheoPersona
  Left = 37
  Top = 312
  BorderIcons = [biSystemMenu]
  BorderStyle = bsDialog
  Caption = 'Cacheo'
  ClientHeight = 149
  ClientWidth = 431
  Color = clYellow
  DragKind = dkDrag
  DragMode = dmManual
  PixelsPerInch = 96
  TextHeight = 13
  object Panel1: TPanel [0]
    Left = 0
    Top = 0
    Width = 431
    Height = 2
    Align = alTop
    BevelOuter = bvNone
    Color = clWindow
    TabOrder = 0
  end
  object Panel2: TPanel [1]
    Left = 0
    Top = 120
    Width = 431
    Height = 29
    Align = alClient
    BevelOuter = bvNone
    Color = 9568255
    TabOrder = 1
    object BotonAceptar: TsnButton
      Left = 152
      Top = -1
      Width = 75
      Height = 25
      Caption = '&Aceptar'
      Default = True
      TabOrder = 0
      LookAndFeel.Kind = lfOffice11
    end
    object BotonCancelar: TsnButton
      Left = 248
      Top = -1
      Width = 75
      Height = 25
      Caption = '&Cancelar'
      TabOrder = 1
      LookAndFeel.Kind = lfOffice11
    end
  end
  object Panel3: TPanel [2]
    Left = 0
    Top = 2
    Width = 431
    Height = 118
    Align = alTop
    BevelOuter = bvNone
    Color = 9568255
    TabOrder = 2
    object Label1: TLabel
      Left = 8
      Top = 30
      Width = 131
      Height = 16
      Caption = 'Resultado de Cacheo'
      Font.Charset = DEFAULT_CHARSET
      Font.Color = clWindowText
      Font.Height = -13
      Font.Name = 'MS Sans Serif'
      Font.Style = []
      ParentFont = False
    end
    object Label2: TLabel
      Left = 8
      Top = 50
      Width = 92
      Height = 16
      Caption = 'Observaciones'
      Font.Charset = DEFAULT_CHARSET
      Font.Color = clWindowText
      Font.Height = -13
      Font.Name = 'MS Sans Serif'
      Font.Style = []
      ParentFont = False
    end
    object Label3: TLabel
      Left = 8
      Top = 6
      Width = 85
      Height = 16
      Caption = 'Realizado por'
      Font.Charset = DEFAULT_CHARSET
      Font.Color = clWindowText
      Font.Height = -13
      Font.Name = 'MS Sans Serif'
      Font.Style = []
      ParentFont = False
    end
    object snDBMemo1: TsnDBMemo
      Left = 144
      Top = 50
      DataBinding.DataField = 'observacion'
      DataBinding.DataSource = DSCacheo
      ParentFont = False
      Properties.MaxLength = 250
      Properties.WantReturns = False
      Style.Font.Charset = DEFAULT_CHARSET
      Style.Font.Color = clWindowText
      Style.Font.Height = -13
      Style.Font.Name = 'MS Sans Serif'
      Style.Font.Style = []
      Style.IsFontAssigned = True
      TabOrder = 2
      ReadOnlyAlways = False
      Height = 65
      Width = 273
    end
    object snDBLookup1: TsnDBLookup
      Left = 144
      Top = 26
      DataBinding.DataField = 'oid_res_cacheo'
      DataBinding.DataSource = DSCacheo
      ParentFont = False
      Properties.KeyFieldNames = 'oid'
      Properties.ListColumns = <
        item
          FieldName = 'descripcion'
        end>
      Properties.ListOptions.ShowHeader = False
      Properties.ListSource = DSResultadoCacheo
      Style.Font.Charset = DEFAULT_CHARSET
      Style.Font.Color = clWindowText
      Style.Font.Height = -13
      Style.Font.Name = 'MS Sans Serif'
      Style.Font.Style = []
      Style.IsFontAssigned = True
      TabOrder = 1
      Width = 273
    end
    object snDBLookup2: TsnDBLookup
      Left = 144
      Top = 2
      DataBinding.DataField = 'oid_pers_seg'
      DataBinding.DataSource = DSCacheo
      ParentFont = False
      Properties.KeyFieldNames = 'oid'
      Properties.ListColumns = <
        item
          FieldName = 'descripcion'
        end>
      Properties.ListOptions.ShowHeader = False
      Properties.ListSource = DSPersonalSeguridad
      Style.Font.Charset = DEFAULT_CHARSET
      Style.Font.Color = clWindowText
      Style.Font.Height = -13
      Style.Font.Name = 'MS Sans Serif'
      Style.Font.Style = []
      Style.IsFontAssigned = True
      TabOrder = 0
      Width = 273
    end
  end
  inherited DriverABM: TDriverABM
    Left = 48
    Top = 48
  end
  inherited Operacion: TOperacion
    Left = 80
    Top = 48
  end
  inherited dxComponentPrinter: TdxComponentPrinter
    Left = 48
    Top = 88
    inherited dxComponentPrinterLink1: TdxCustomContainerReportLink
      Component = Owner
      BuiltInReportLink = True
      HiddenComponents = {}
      ExcludedComponents = {}
      AggregatedReportLinks = {}
    end
  end
  inherited SaveDialog: TSaveDialog
    Left = 80
    Top = 88
  end
  inherited DriverEvent: TDriverEvent
    OnShow.Strings = (
      'begin'
      '  Inicializar();'
      '  snDBLookup2.setFoco();'
      'end.')
    OnPublicVariable = <
      item
        VariableName = 'TCacheo'
      end>
    OnInicializar = <
      item
        Source.Strings = (
          'begin'
          '  Inicializar();'
          '  TCacheo.FieldName('#39'acepto'#39').AsBoolean := True; '
          '  ResultadoCacheo.loadFromHelp('#39'HelpCacheo'#39');'
          'end.')
      end>
    OnFormFunction = <
      item
        Source.Strings = (
          'procedure Inicializar();'
          'begin'
          '  TPersonalSeguridad.loadFromHelp('#39'HelpPersSeg'#39');'
          '  TCacheo.Close;'
          '  TCacheo.Open;'
          '  TCacheo.AppendRecord;'
          'end;')
      end>
    OnClickToolButton = <
      item
        ButtonName = 'BotonCancelar'
        Source.Strings = (
          'begin'
          '  close;'
          'end.')
      end
      item
        ButtonName = 'BotonAceptar'
        Source.Strings = (
          'begin'
          '  if (TCacheo.FieldName('#39'oid_res_cacheo'#39').AsInteger = 0)'
          
            '     then raiseException(erCustomError,'#39'Debe ingresar el resulta' +
            'do del cacheo'#39'); '
          '  if (TCacheo.FieldName('#39'oid_pers_seg'#39').AsInteger = 0)'
          
            '     then raiseException(erCustomError,'#39'Debe ingresar el persona' +
            'l de seguridad'#39'); '
          ''
          '  TCacheo.EditRecord;'
          '  TCacheo.FieldName('#39'acepto'#39').AsBoolean := True;'
          '  TCacheo.PostRecord;'
          '  close;'
          'end.')
      end>
    Left = 112
    Top = 89
  end
  inherited SaveArchivo: TSaveDialog
    Left = 48
    Top = 120
  end
  inherited ImprimirObjetoSeleccionado: TdxComponentPrinter
    inherited ImprimirObjetoSeleccionadodxComponentPrinterLink: TdxGridReportLink
      BuiltInReportLink = True
    end
  end
  object TCacheo: TsnTable
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
    Left = 80
    Top = 118
    object TCacheooid_pers_seg: TIntegerField
      FieldName = 'oid_pers_seg'
    end
    object TCacheooid_res_cacheo: TIntegerField
      FieldName = 'oid_res_cacheo'
    end
    object TCacheoobservacion: TStringField
      FieldName = 'observacion'
      Size = 255
    end
    object TCacheoacepto: TBooleanField
      FieldName = 'acepto'
    end
  end
  object DSCacheo: TDataSource
    DataSet = TCacheo
    Left = 112
    Top = 118
  end
  object ResultadoCacheo: TsnTable
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
    Left = 264
    Top = 6
    object ResultadoCacheooid: TIntegerField
      FieldName = 'oid'
    end
    object ResultadoCacheocodigo: TStringField
      FieldName = 'codigo'
      Size = 50
    end
    object ResultadoCacheodescripcion: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
  end
  object DSResultadoCacheo: TDataSource
    DataSet = ResultadoCacheo
    Left = 296
    Top = 6
  end
  object HelpCacheo: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'cip.ResultadoCacheo'
    NroHelp = 0
    Campos = <
      item
        Titulo = 'oid'
        FieldName = 'oid'
        Tipo = ftInteger
        Longitud = 0
        Visible = False
        KeyField = True
        AnchoEnCaracteres = 30
        ActivarFiltro = True
      end
      item
        Titulo = 'Descripci'#243'n'
        FieldName = 'descripcion'
        Tipo = ftString
        Longitud = 30
        Visible = True
        KeyField = False
        AnchoEnCaracteres = 30
        ActivarFiltro = True
        Sorted = scUp
      end
      item
        Titulo = 'C'#243'digo'
        FieldName = 'codigo'
        Tipo = ftString
        Longitud = 30
        Visible = True
        KeyField = False
        AnchoEnCaracteres = 30
        ActivarFiltro = True
      end
      item
        Titulo = 'Activo'
        FieldName = 'activo'
        Tipo = ftBoolean
        Longitud = 0
        Visible = True
        KeyField = False
        AnchoEnCaracteres = 8
        ActivarFiltro = True
      end>
    Titulo = 'Resultados Cacheo'
    AnchoHelp = 600
    ActivarCache = False
    ShowBotonBuscar = False
    Left = 266
    Top = 45
  end
  object TPersonalSeguridad: TsnTable
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
    Left = 328
    Top = 91
    object TPersonalSeguridadoid: TIntegerField
      FieldName = 'oid'
    end
    object TPersonalSeguridadcodigo: TStringField
      FieldName = 'codigo'
      Size = 50
    end
    object TPersonalSeguridaddescripcion: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
  end
  object DSPersonalSeguridad: TDataSource
    DataSet = TPersonalSeguridad
    Left = 368
    Top = 91
  end
  object HelpPersSeg: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'cip.PersonalSeguridad'
    NroHelp = 100
    Campos = <
      item
        Titulo = 'oid'
        FieldName = 'oid'
        Tipo = ftInteger
        Longitud = 0
        Visible = False
        KeyField = True
        AnchoEnCaracteres = 30
        ActivarFiltro = True
      end
      item
        Titulo = 'Descripci'#243'n'
        FieldName = 'descripcion'
        Tipo = ftString
        Longitud = 30
        Visible = True
        KeyField = False
        AnchoEnCaracteres = 30
        ActivarFiltro = True
        Sorted = scUp
      end
      item
        Titulo = 'C'#243'digo'
        FieldName = 'codigo'
        Tipo = ftString
        Longitud = 30
        Visible = True
        KeyField = False
        AnchoEnCaracteres = 30
        ActivarFiltro = True
      end
      item
        Titulo = 'Activo'
        FieldName = 'activo'
        Tipo = ftBoolean
        Longitud = 0
        Visible = True
        KeyField = False
        AnchoEnCaracteres = 8
        ActivarFiltro = True
      end>
    Titulo = 'Personas de Seguridad'
    AnchoHelp = 600
    ActivarCache = False
    ShowBotonBuscar = False
    Left = 354
    Top = 117
  end
end
