inherited FBiometricos: TFBiometricos
  Left = 65
  Top = 58
  Width = 908
  Height = 558
  Caption = 'Biom'#233'tricos'
  PixelsPerInch = 96
  TextHeight = 13
  inherited PForm: TPanel
    Width = 900
    Height = 524
    inherited PPie: TPanel
      Top = 503
      Width = 900
      inherited StatusBarABM: TStatusBar
        Left = 795
      end
      inherited StatusBar2: TStatusBar
        Width = 795
      end
    end
    inherited PMenu: TPanel
      Width = 900
      inherited ImagenEliminar: TImagenEstado
        DataField = 'activo'
        DataSource = DSBiometrico
        ValorEstadoVisible = 'True'
      end
      inherited ImagenRehabilitar: TImagenEstado
        DataField = 'activo'
        DataSource = DSBiometrico
        ValorEstadoVisible = 'False'
      end
      inherited ImagenBuscar: TImagenHelpObjNeg
        Help = HelpBiometricos
      end
      inherited ImagenSiguiente: TImagenHelpObjNeg
        Help = HelpBiometricos
      end
      inherited ImagenAnterior: TImagenHelpObjNeg
        Help = HelpBiometricos
      end
      inherited Panel2: TPanel
        Left = 859
      end
      inherited PanelEstadoON: TPanelEstado
        DataField = 'activo'
        DataSource = DSBiometrico
        Leyendas = <
          item
            Titulo = 'Inactivo'
            ColorTitulo = clWhite
            ValorEstado = 'false'
            Visible = True
            ColorPanel = clRed
          end>
      end
    end
    inherited POpcionesMenu: TPanel
      Width = 900
    end
    inherited PCabecera: TPanel
      Width = 900
      Height = 106
      object Label1: TLabel
        Left = 40
        Top = 32
        Width = 33
        Height = 13
        Caption = 'Codigo'
      end
      object Label2: TLabel
        Left = 40
        Top = 72
        Width = 56
        Height = 13
        Caption = 'Descripci'#243'n'
      end
      object DBECodigo: TsnDBEdit
        Left = 124
        Top = 28
        DataBinding.DataField = 'codigo'
        DataBinding.DataSource = DSBiometrico
        Properties.CharCase = ecUpperCase
        Properties.MaxLength = 20
        Style.BorderColor = clWindowFrame
        Style.Shadow = False
        TabOrder = 0
        Width = 133
      end
      object DBEDescripcion: TsnDBEdit
        Left = 124
        Top = 68
        DataBinding.DataField = 'descripcion'
        DataBinding.DataSource = DSBiometrico
        Properties.MaxLength = 50
        Style.BorderColor = clWindowFrame
        Style.Shadow = False
        TabOrder = 1
        Width = 253
      end
    end
    inherited PCuerpo: TPanel
      Top = 158
      Width = 900
      Height = 345
      object Label3: TLabel
        Left = 40
        Top = 5
        Width = 10
        Height = 13
        Caption = 'IP'
      end
      object Label4: TLabel
        Left = 336
        Top = 5
        Width = 31
        Height = 13
        Caption = 'Puerto'
      end
      object Label5: TLabel
        Left = 456
        Top = 5
        Width = 72
        Height = 13
        Caption = 'Nro. Biom'#233'trico'
      end
      object snLabel1: TsnLabel
        Left = 40
        Top = 43
        Width = 72
        Height = 13
        Caption = 'Tipo biom'#233'trico'
      end
      object snDBEdit1: TsnDBEdit
        Left = 125
        Top = 1
        DataBinding.DataField = 'ip'
        DataBinding.DataSource = DSBiometrico
        TabOrder = 0
        Width = 172
      end
      object snDBEdit2: TsnDBEdit
        Left = 381
        Top = 1
        DataBinding.DataField = 'puerto'
        DataBinding.DataSource = DSBiometrico
        TabOrder = 1
        Width = 52
      end
      object snDBEdit3: TsnDBEdit
        Left = 541
        Top = 1
        DataBinding.DataField = 'nro_biometrico'
        DataBinding.DataSource = DSBiometrico
        TabOrder = 2
        Width = 52
      end
      object snDBLookup1: TsnDBLookup
        Left = 125
        Top = 39
        DataBinding.DataField = 'tipo_biometrico'
        DataBinding.DataSource = DSBiometrico
        Properties.KeyFieldNames = 'codigo'
        Properties.ListColumns = <
          item
            FieldName = 'descripcion'
          end>
        Properties.ListOptions.ShowHeader = False
        Properties.ListSource = DSTiposBiometricos
        TabOrder = 3
        Width = 212
      end
    end
  end
  inherited DriverABM: TDriverABM
    OperTraerObjeto = 'TraerBiometrico'
    OperGrabarObjeto = 'SaveBiometrico'
    CargaDataSets = <
      item
        DataSet = TBiometrico
        TableName = 'TBiometrico'
      end
      item
        DataSet = TTiposBiometricos
        TableName = 'TTiposBiometricos'
      end>
    BajaLogica = <
      item
        DataSet = TBiometrico
        ValorBaja = 'false'
        ValorRehabilitacion = 'true'
        TipoBajaRegistro = tblCurrentRecord
        FieldName = 'activo'
      end>
    OperHabilitadas = [toOperNuevo, toOperModificar, toOperEliminar, toOperBuscar, toOperNavegacion, toOperRehabilitar]
    DataSetCab = TBiometrico
    ControlFocoAlta = DBECodigo
    ControlFocoModif = DBECodigo
    Left = 512
    Top = 16
  end
  inherited Operacion: TOperacion
    Left = 560
    Top = 16
  end
  object TBiometrico: TsnTable [3]
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'oid_rota'
        DataType = ftInteger
      end
      item
        Name = 'codigo'
        DataType = ftString
        Size = 50
      end
      item
        Name = 'descripcion'
        DataType = ftString
        Size = 100
      end
      item
        Name = 'activo'
        DataType = ftBoolean
      end
      item
        Name = 'horario_desde'
        DataType = ftString
        Size = 5
      end
      item
        Name = 'horario_hasta'
        DataType = ftString
        Size = 5
      end
      item
        Name = 'min_ent_antes'
        DataType = ftInteger
      end
      item
        Name = 'min_ent_desp'
        DataType = ftInteger
      end>
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
    Left = 648
    Top = 59
    object TBiometricooid_biometrico: TIntegerField
      FieldName = 'oid_biometrico'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TBiometricocodigo: TStringField
      DisplayWidth = 20
      FieldName = 'codigo'
    end
    object TBiometricodescripcion: TStringField
      DisplayWidth = 50
      FieldName = 'descripcion'
      Size = 50
    end
    object TBiometricoip: TStringField
      FieldName = 'ip'
      Size = 50
    end
    object TBiometricopuerto: TIntegerField
      FieldName = 'puerto'
    end
    object TBiometricotipo_biometrico: TStringField
      FieldName = 'tipo_biometrico'
    end
    object TBiometriconro_biometrico: TIntegerField
      FieldName = 'nro_biometrico'
    end
    object TBiometricoactivo: TBooleanField
      DefaultExpression = '1'
      FieldName = 'activo'
    end
  end
  object DSBiometrico: TDataSource [4]
    DataSet = TBiometrico
    Left = 680
    Top = 59
  end
  inherited TOidObjSave: TsnTable
    Left = 608
  end
  inherited TOpcHabPrograma: TsnTable
    Top = 16
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
    OnValidate = <
      item
        TableName = 'TBiometrico'
        FieldName = 'codigo'
        Source.Strings = (
          'begin'
          '  ValidadorBiometrico.Value := Sender.AsString;'
          '  ValidadorBiometrico.Validar();'
          'end.')
      end>
    OnInicializar = <
      item
        Source.Strings = (
          'begin'
          '  TraerTiposBiometricos();'
          'end.')
      end>
    OnFormFunction = <
      item
        Source.Strings = (
          'procedure TraerTiposBiometricos();'
          'begin'
          '  operacion.InicioOperacion();'
          '  operacion.setOper('#39'TraerTiposBiometricos'#39');'
          '  operacion.execute();'
          'end;')
      end>
    Left = 320
  end
  inherited SaveArchivo: TSaveDialog
    Top = 128
  end
  inherited ImprimirObjetoSeleccionado: TdxComponentPrinter
    Left = 328
    Top = 272
    inherited ImprimirObjetoSeleccionadodxComponentPrinterLink: TdxGridReportLink
      BuiltInReportLink = True
    end
  end
  inherited PopUp: TsnPopUp
    Left = 280
    Top = 68
  end
  inherited ImageListItemsPopUp: TImageList
    Left = 280
    Top = 123
  end
  object HelpBiometricos: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'cip.Biometrico'
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
    Titulo = 'Biometricos'
    AnchoHelp = 600
    ActivarCache = False
    ShowBotonBuscar = False
    Left = 202
    Top = 68
  end
  object ValidadorBiometrico: TValidador
    Operacion = Operacion
    NickNameObjLog = 'cip.Biometrico'
    WhenRaiseException = teFound
    MensajeException = 'C'#243'digo de Biometrico duplicado'
    NroQuery = 0
    Cache = False
    Left = 240
    Top = 67
  end
  object TTiposBiometricos: TsnTable
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
    Left = 112
    Top = 262
    object TTiposBiometricoscodigo: TStringField
      FieldName = 'codigo'
      Size = 50
    end
    object TTiposBiometricosdescripcion: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
  end
  object DSTiposBiometricos: TDataSource
    DataSet = TTiposBiometricos
    Left = 144
    Top = 262
  end
end
