inherited FMCGrupoProvUnif: TFMCGrupoProvUnif
  Left = 321
  Top = 121
  Width = 951
  Height = 678
  Caption = 'Grupos Proveedor'
  PixelsPerInch = 96
  TextHeight = 13
  inherited PForm: TPanel
    Width = 935
    Height = 640
    inherited PPie: TPanel
      Top = 619
      Width = 935
      inherited StatusBarABM: TStatusBar
        Left = 830
      end
      inherited StatusBar2: TStatusBar
        Width = 830
      end
    end
    inherited PMenu: TPanel
      Width = 935
      inherited ImagenEliminar: TImagenEstado
        DataField = 'activo'
        DataSource = DSGrupoProveedor
        ValorEstadoVisible = 'True'
      end
      inherited ImagenRehabilitar: TImagenEstado
        DataField = 'activo'
        DataSource = DSGrupoProveedor
        ValorEstadoVisible = 'False'
      end
      inherited ImagenBuscar: TImagenHelpObjNeg
        Help = HelpGrupos
      end
      inherited ImagenSiguiente: TImagenHelpObjNeg
        Help = HelpGrupos
      end
      inherited ImagenAnterior: TImagenHelpObjNeg
        Help = HelpGrupos
      end
      inherited Panel2: TPanel
        Left = 894
      end
      inherited PanelEstadoON: TPanelEstado
        DataField = 'activo'
        DataSource = DSGrupoProveedor
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
      Width = 935
    end
    inherited PCabecera: TPanel
      Width = 935
      Height = 125
      object Label1: TLabel
        Left = 120
        Top = 64
        Width = 33
        Height = 13
        Caption = 'Codigo'
      end
      object Label2: TLabel
        Left = 120
        Top = 103
        Width = 56
        Height = 13
        Caption = 'Descripcion'
      end
      object Label8: TLabel
        Left = 120
        Top = 24
        Width = 96
        Height = 17
        Caption = 'Grupo Unificado'
        Font.Charset = ANSI_CHARSET
        Font.Color = clNavy
        Font.Height = -13
        Font.Name = 'Nirmala UI'
        Font.Style = [fsItalic]
        ParentFont = False
      end
      object DBENOMBRE: TsnDBEdit
        Left = 220
        Top = 60
        DataBinding.DataField = 'codigo'
        DataBinding.DataSource = DSGrupoProveedor
        Properties.CharCase = ecUpperCase
        Properties.MaxLength = 15
        Style.BorderColor = clWindowFrame
        Style.Shadow = False
        TabOrder = 0
        Width = 285
      end
      object snDBEdit1: TsnDBEdit
        Left = 220
        Top = 99
        DataBinding.DataField = 'descripcion'
        DataBinding.DataSource = DSGrupoProveedor
        Properties.CharCase = ecUpperCase
        Properties.MaxLength = 100
        Style.BorderColor = clWindowFrame
        Style.Shadow = False
        TabOrder = 1
        Width = 397
      end
    end
    inherited PCuerpo: TPanel
      Top = 177
      Width = 935
      Height = 442
      object Label3: TLabel
        Left = 152
        Top = 64
        Width = 49
        Height = 13
        Caption = 'Grupo Ute'
      end
      object Label4: TLabel
        Left = 152
        Top = 101
        Width = 75
        Height = 13
        Caption = 'Grupo Binbaires'
      end
      object Label5: TLabel
        Left = 152
        Top = 140
        Width = 68
        Height = 13
        Caption = 'Grupo Alavera'
      end
      object Label6: TLabel
        Left = 153
        Top = 178
        Width = 61
        Height = 13
        Caption = 'Grupo Magic'
      end
      object Label7: TLabel
        Left = 120
        Top = 24
        Width = 346
        Height = 17
        Caption = 'Seleccione los grupos de Proveedores del Material Control'
        Font.Charset = ANSI_CHARSET
        Font.Color = clNavy
        Font.Height = -13
        Font.Name = 'Nirmala UI'
        Font.Style = [fsItalic]
        ParentFont = False
      end
      object snDBLookup1: TsnDBLookup
        Left = 245
        Top = 60
        DataBinding.DataField = 'oid_grupo_ute'
        DataBinding.DataSource = DSGrupoProveedor
        Properties.KeyFieldNames = 'oid_grupo_ute'
        Properties.ListColumns = <
          item
            FieldName = 'nombre'
          end>
        Properties.ListOptions.ShowHeader = False
        Properties.ListSource = DSGrupoUte
        TabOrder = 0
        Width = 332
      end
      object snDBLookup2: TsnDBLookup
        Left = 245
        Top = 97
        DataBinding.DataField = 'oid_grupo_binbaires'
        DataBinding.DataSource = DSGrupoProveedor
        Properties.KeyFieldNames = 'oid_grupo_binbaires'
        Properties.ListColumns = <
          item
            FieldName = 'nombre'
          end>
        Properties.ListOptions.ShowHeader = False
        Properties.ListSource = DSGrupoBinbaires
        TabOrder = 1
        Width = 332
      end
      object snDBLookup3: TsnDBLookup
        Left = 245
        Top = 136
        DataBinding.DataField = 'oid_grupo_alavera'
        DataBinding.DataSource = DSGrupoProveedor
        Properties.KeyFieldNames = 'oid_grupo_alavera'
        Properties.ListColumns = <
          item
            FieldName = 'nombre'
          end>
        Properties.ListOptions.ShowHeader = False
        Properties.ListSource = DSGrupoAlavera
        TabOrder = 2
        Width = 332
      end
      object snDBLookup4: TsnDBLookup
        Left = 245
        Top = 173
        DataBinding.DataField = 'oid_grupo_magic'
        DataBinding.DataSource = DSGrupoProveedor
        Properties.KeyFieldNames = 'oid_grupo_magic'
        Properties.ListColumns = <
          item
            FieldName = 'nombre'
          end>
        Properties.ListOptions.ShowHeader = False
        Properties.ListSource = DSGrupoMagic
        TabOrder = 3
        Width = 332
      end
    end
  end
  inherited DriverABM: TDriverABM
    OperTraerObjeto = 'TraerGrupoProveedor'
    OperGrabarObjeto = 'SaveGrupoProveedor'
    CargaDataSets = <
      item
        DataSet = TGrupoProveedor
        TableName = 'TGrupoProveedor'
      end
      item
        DataSet = TGrupoUte
        TableName = 'TGrupoUte'
      end
      item
        DataSet = TGrupoBinbaires
        TableName = 'TGrupoBinbaires'
      end
      item
        DataSet = TGrupoAlavera
        TableName = 'TGrupoAlavera'
      end
      item
        DataSet = TGrupoMagic
        TableName = 'TGrupoMagic'
      end>
    BajaLogica = <
      item
        DataSet = TGrupoProveedor
        ValorBaja = 'false'
        ValorRehabilitacion = 'true'
        TipoBajaRegistro = tblCurrentRecord
        FieldName = 'activo'
      end>
    OperHabilitadas = [toOperNuevo, toOperModificar, toOperEliminar, toOperBuscar, toOperNavegacion, toOperRehabilitar]
    DataSetCab = TGrupoProveedor
    Left = 488
    Top = 16
  end
  inherited Operacion: TOperacion
    Left = 528
    Top = 16
  end
  object TGrupoProveedor: TsnTable [3]
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'oid_grupo_proveedor'
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
        Name = 'oid_grupo_ute'
        DataType = ftInteger
      end
      item
        Name = 'oid_grupo_binbaires'
        DataType = ftInteger
      end
      item
        Name = 'oid_grupo_alavera'
        DataType = ftInteger
      end
      item
        Name = 'oid_grupo_magic'
        DataType = ftInteger
      end
      item
        Name = 'acrivo'
        DataType = ftBoolean
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
    Left = 544
    Top = 75
    object TGrupoProveedoroid_grupo_proveedor: TIntegerField
      FieldName = 'oid_grupo_proveedor'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TGrupoProveedorcodigo: TStringField
      FieldName = 'codigo'
      Size = 50
    end
    object TGrupoProveedordescripcion: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
    object TGrupoProveedoroid_grupo_ute: TIntegerField
      FieldName = 'oid_grupo_ute'
    end
    object TGrupoProveedoroid_grupo_binbaires: TIntegerField
      FieldName = 'oid_grupo_binbaires'
    end
    object TGrupoProveedoroid_grupo_alavera: TIntegerField
      FieldName = 'oid_grupo_alavera'
    end
    object TGrupoProveedoroid_grupo_magic: TIntegerField
      FieldName = 'oid_grupo_magic'
    end
    object TGrupoProveedoractivo: TBooleanField
      FieldName = 'activo'
    end
  end
  object DSGrupoProveedor: TDataSource [4]
    DataSet = TGrupoProveedor
    Left = 576
    Top = 75
  end
  inherited TOidObjSave: TsnTable
    Left = 608
  end
  inherited TOpcHabPrograma: TsnTable
    Top = 16
  end
  inherited dxComponentPrinter: TdxComponentPrinter
    Left = 712
    Top = 16
    inherited dxComponentPrinterLink1: TdxCustomContainerReportLink
      Component = Owner
      BuiltInReportLink = True
      HiddenComponents = {}
      ExcludedComponents = {}
      AggregatedReportLinks = {}
    end
  end
  inherited SaveDialog: TSaveDialog
    Left = 776
    Top = 16
  end
  inherited DriverEvent: TDriverEvent
    OnValidate = <
      item
        TableName = 'TGrupoProveedor'
        FieldName = 'codigo'
        Source.Strings = (
          'begin'
          '  ValidadorGruposRRHH.Value := Sender.AsString;'
          '  ValidadorGruposRRHH.Validar;'
          'end.')
      end>
    OnNuevoRegistro = <
      item
        TableName = 'TGrupoProveedor'
        Source.Strings = (
          'Begin'
          'Dataset.FieldName('#39'activo'#39').Value := true;'
          'end.')
      end>
    OnInicializar = <
      item
        Source.Strings = (
          'begin'
          '    Operacion.inicioOperacion();'
          '    Operacion.setOper('#39'TraerGrupoProveedorBase'#39');'
          '    Operacion.execute();'
          'end.')
      end>
    Left = 128
    Top = 19
  end
  inherited SaveArchivo: TSaveDialog
    Left = 744
    Top = 16
  end
  inherited ImprimirObjetoSeleccionado: TdxComponentPrinter
    Left = 680
    Top = 16
    inherited ImprimirObjetoSeleccionadodxComponentPrinterLink: TdxGridReportLink
      BuiltInReportLink = True
    end
  end
  inherited TTempVarForm: TsnTable
    Left = 872
    Top = 16
  end
  inherited PopUp: TsnPopUp
    Left = 89
    Top = 24
  end
  inherited ImageListGruposPopUp: TImageList
    Left = 840
    Top = 19
  end
  inherited ImageListItemsPopUp: TImageList
    Left = 808
    Top = 19
  end
  inherited TPathHelp: TsnTable
    Left = 568
    Top = 21
  end
  inherited TDataSetOidObjSave: TsnTable
    Left = 904
    Top = 11
  end
  object HelpGrupos: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'ma.grupoProveedor'
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
    Titulo = 'Grupos'
    AnchoHelp = 600
    ActivarCache = False
    ShowBotonBuscar = False
    Left = 10
    Top = 20
  end
  object ValidadorGruposRRHH: TValidador
    Operacion = Operacion
    NickNameObjLog = 'ma.grupoProveedor'
    WhenRaiseException = teFound
    MensajeException = 'C'#243'digo de Certificaci'#243'n Existente'
    NroQuery = 0
    Cache = False
    Left = 48
    Top = 19
  end
  object TGrupoUte: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'oid_grupo_ute'
        DataType = ftInteger
      end
      item
        Name = 'nombre'
        DataType = ftString
        Size = 200
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
    Left = 136
    Top = 341
    object TGrupoUteoid_grupo_ute: TIntegerField
      FieldName = 'oid_grupo_ute'
    end
    object TGrupoUtenombre: TStringField
      FieldName = 'nombre'
      Size = 200
    end
  end
  object DSGrupoUte: TDataSource
    DataSet = TGrupoUte
    Left = 168
    Top = 339
  end
  object TGrupoBinbaires: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'oid_grupo_binbaires'
        DataType = ftInteger
      end
      item
        Name = 'nombre'
        DataType = ftString
        Size = 200
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
    Left = 288
    Top = 349
    object TGrupoBinbairesoid_grupo_binbaires: TIntegerField
      FieldName = 'oid_grupo_binbaires'
    end
    object TGrupoBinbairesTGrupoBinbairesnombre: TStringField
      FieldName = 'nombre'
      Size = 200
    end
  end
  object TGrupoAlavera: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'oid_grupo_alavera'
        DataType = ftInteger
      end
      item
        Name = 'nombre'
        DataType = ftString
        Size = 200
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
    Left = 496
    Top = 341
    object TGrupoAlaveraoid_grupo_alavera: TIntegerField
      FieldName = 'oid_grupo_alavera'
    end
    object TGrupoAlaveraTGrupoAlaveranombre: TStringField
      FieldName = 'nombre'
      Size = 200
    end
  end
  object TGrupoMagic: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'oid_grupo_magic'
        DataType = ftInteger
      end
      item
        Name = 'nombre'
        DataType = ftString
        Size = 200
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
    Left = 704
    Top = 341
    object TGrupoMagicoid_grupo_magic: TIntegerField
      FieldName = 'oid_grupo_magic'
    end
    object TGrupoMagicTGrupoMagicnombre: TStringField
      FieldName = 'nombre'
      Size = 200
    end
  end
  object DSGrupoBinbaires: TDataSource
    DataSet = TGrupoBinbaires
    Left = 320
    Top = 347
  end
  object DSGrupoAlavera: TDataSource
    DataSet = TGrupoAlavera
    Left = 528
    Top = 339
  end
  object DSGrupoMagic: TDataSource
    DataSet = TGrupoMagic
    Left = 736
    Top = 339
  end
end
