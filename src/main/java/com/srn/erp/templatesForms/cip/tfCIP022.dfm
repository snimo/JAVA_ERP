inherited FZonaCIP: TFZonaCIP
  Left = 98
  Top = 119
  Width = 730
  Height = 513
  Caption = 'Zonas CIP'
  PixelsPerInch = 96
  TextHeight = 13
  inherited PForm: TPanel
    Width = 714
    Height = 475
    inherited PPie: TPanel
      Top = 454
      Width = 714
      inherited StatusBarABM: TStatusBar
        Left = 609
      end
      inherited StatusBar2: TStatusBar
        Width = 609
      end
    end
    inherited PMenu: TPanel
      Width = 714
      inherited ImagenEliminar: TImagenEstado
        DataField = 'activo'
        DataSource = dsTZonaCIP
        ValorEstadoVisible = 'True'
      end
      inherited ImagenRehabilitar: TImagenEstado
        DataField = 'activo'
        DataSource = dsTZonaCIP
        ValorEstadoVisible = 'False'
      end
      inherited ImagenBuscar: TImagenHelpObjNeg
        Help = HelpZonasCIP
      end
      inherited ImagenSiguiente: TImagenHelpObjNeg
        Help = HelpZonasCIP
      end
      inherited ImagenAnterior: TImagenHelpObjNeg
        Help = HelpZonasCIP
      end
      inherited Panel2: TPanel
        Left = 673
      end
      inherited PanelEstadoON: TPanelEstado
        DataField = 'activo'
        DataSource = dsTZonaCIP
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
      Width = 714
    end
    inherited PCabecera: TPanel
      Width = 714
      Height = 101
      object Label1: TLabel
        Left = 25
        Top = 15
        Width = 33
        Height = 13
        Caption = 'C'#243'digo'
      end
      object Label2: TLabel
        Left = 25
        Top = 44
        Width = 56
        Height = 13
        Caption = 'Descripci'#243'n'
      end
      object DBECodigo: TsnDBEdit
        Left = 141
        Top = 11
        DataBinding.DataField = 'codigo'
        DataBinding.DataSource = dsTZonaCIP
        Properties.CharCase = ecUpperCase
        Properties.MaxLength = 50
        Style.BorderColor = clWindowFrame
        Style.Shadow = False
        TabOrder = 0
        Width = 133
      end
      object snDBEdit1: TsnDBEdit
        Left = 141
        Top = 40
        DataBinding.DataField = 'descripcion'
        DataBinding.DataSource = dsTZonaCIP
        Properties.MaxLength = 100
        Style.BorderColor = clWindowFrame
        Style.Shadow = False
        TabOrder = 1
        Width = 429
      end
      object snDBCheckEdit2: TsnDBCheckEdit
        Left = 21
        Top = 72
        Caption = 'Es externa?'
        DataBinding.DataField = 'es_externa'
        DataBinding.DataSource = dsTZonaCIP
        Properties.Alignment = taRightJustify
        TabOrder = 2
        Width = 136
      end
      object snDBCheckEdit3: TsnDBCheckEdit
        Left = 197
        Top = 72
        Caption = 'Controlar Antipassback Entrada?'
        DataBinding.DataField = 'controla_anti_ent'
        DataBinding.DataSource = dsTZonaCIP
        Properties.Alignment = taRightJustify
        TabOrder = 3
        Width = 188
      end
      object snDBCheckEdit4: TsnDBCheckEdit
        Left = 405
        Top = 72
        Caption = 'Controlar Antipassback Salida?'
        DataBinding.DataField = 'controla_anti_sal'
        DataBinding.DataSource = dsTZonaCIP
        Properties.Alignment = taRightJustify
        TabOrder = 4
        Width = 184
      end
    end
    inherited PCuerpo: TPanel
      Top = 153
      Width = 714
      Height = 301
      BorderWidth = 5
      object PageControlSN1: TPageControlSN
        Left = 5
        Top = 5
        Width = 704
        Height = 291
        ActivePage = TabSheet2
        Align = alClient
        TabOrder = 0
        object TabSheet2: TTabSheet
          Caption = 'Principal'
          ImageIndex = 1
          object snLabel1: TsnLabel
            Left = 16
            Top = 16
            Width = 49
            Height = 13
            Caption = 'Tipo Zona'
          end
          object snLabel4: TsnLabel
            Left = 16
            Top = 48
            Width = 61
            Height = 13
            Caption = 'Estado Zona'
          end
          object snLabel5: TsnLabel
            Left = 16
            Top = 80
            Width = 48
            Height = 13
            Caption = 'Ubicaci'#243'n'
          end
          object snDBLookup1: TsnDBLookup
            Left = 88
            Top = 12
            DataBinding.DataField = 'oid_tipo_zona'
            DataBinding.DataSource = dsTZonaCIP
            Properties.KeyFieldNames = 'oid'
            Properties.ListColumns = <
              item
                FieldName = 'descripcion'
              end>
            Properties.ListOptions.ShowHeader = False
            Properties.ListSource = DSTiposZonas
            TabOrder = 0
            Width = 217
          end
          object snDBLookup2: TsnDBLookup
            Left = 88
            Top = 44
            DataBinding.DataField = 'estado_zona'
            DataBinding.DataSource = dsTZonaCIP
            Properties.KeyFieldNames = 'codigo'
            Properties.ListColumns = <
              item
                FieldName = 'descripcion'
              end>
            Properties.ListOptions.ShowHeader = False
            Properties.ListSource = DSEstadosZonas
            TabOrder = 1
            Width = 217
          end
          object snDBMemo1: TsnDBMemo
            Left = 16
            Top = 96
            DataBinding.DataField = 'ubicacion'
            DataBinding.DataSource = dsTZonaCIP
            Properties.MaxLength = 255
            TabOrder = 2
            ReadOnlyAlways = False
            Height = 41
            Width = 641
          end
        end
        object TabSheet1: TTabSheet
          Caption = 'Capacidad Zona'
          object snLabel2: TsnLabel
            Left = 16
            Top = 16
            Width = 90
            Height = 13
            Caption = 'Capacidad M'#225'xima'
          end
          object snLabel3: TsnLabel
            Left = 232
            Top = 16
            Width = 101
            Height = 13
            Caption = 'Alarma de Capacidad'
          end
          object snLabel6: TsnLabel
            Left = 16
            Top = 48
            Width = 101
            Height = 13
            Caption = 'Alarma de Capacidad'
            Font.Charset = DEFAULT_CHARSET
            Font.Color = clBlue
            Font.Height = -11
            Font.Name = 'MS Sans Serif'
            Font.Style = [fsUnderline]
            ParentFont = False
          end
          object snLabel7: TsnLabel
            Left = 40
            Top = 80
            Width = 129
            Height = 13
            Caption = 'Avisar a Grupo de Usuarios'
          end
          object snLabel8: TsnLabel
            Left = 40
            Top = 112
            Width = 134
            Height = 13
            Caption = 'Avisar a Grupo de M'#225'quinas'
          end
          object snLabel9: TsnLabel
            Left = 40
            Top = 176
            Width = 152
            Height = 13
            Caption = 'Mensaje de alerta de capacidad'
          end
          object snLabel10: TsnLabel
            Left = 40
            Top = 144
            Width = 61
            Height = 13
            Caption = 'Aviso sonoro'
          end
          object snDBEdit2: TsnDBEdit
            Left = 120
            Top = 12
            DataBinding.DataField = 'capacidad_max'
            DataBinding.DataSource = dsTZonaCIP
            TabOrder = 0
            Width = 81
          end
          object snDBEdit3: TsnDBEdit
            Left = 344
            Top = 12
            DataBinding.DataField = 'alarma_de_cap'
            DataBinding.DataSource = dsTZonaCIP
            TabOrder = 1
            Width = 73
          end
          object snDBCheckEdit1: TsnDBCheckEdit
            Left = 452
            Top = 12
            Caption = 'Bloquear exceso de capacidad'
            DataBinding.DataField = 'bloquear_exc_cap'
            DataBinding.DataSource = dsTZonaCIP
            TabOrder = 2
            Width = 177
          end
          object snDBLookup3: TsnDBLookup
            Left = 184
            Top = 76
            DataBinding.DataField = 'oid_grupo_usu_alar'
            DataBinding.DataSource = dsTZonaCIP
            Properties.KeyFieldNames = 'oid'
            Properties.ListColumns = <
              item
                FieldName = 'descripcion'
              end>
            Properties.ListOptions.ShowHeader = False
            Properties.ListSource = DSGrupoUsuario
            TabOrder = 3
            Width = 217
          end
          object snDBLookup4: TsnDBLookup
            Left = 184
            Top = 108
            DataBinding.DataField = 'oid_grupo_maq_alar'
            DataBinding.DataSource = dsTZonaCIP
            Properties.KeyFieldNames = 'oid'
            Properties.ListColumns = <
              item
                FieldName = 'descripcion'
              end>
            Properties.ListOptions.ShowHeader = False
            Properties.ListSource = DSGrupoMaquinas
            TabOrder = 4
            Width = 217
          end
          object snDBMemo2: TsnDBMemo
            Left = 40
            Top = 192
            DataBinding.DataField = 'mens_alar_cap_max'
            DataBinding.DataSource = dsTZonaCIP
            Properties.MaxLength = 255
            TabOrder = 6
            ReadOnlyAlways = False
            Height = 41
            Width = 585
          end
          object snDBLookup5: TsnDBLookup
            Left = 184
            Top = 140
            DataBinding.DataField = 'oid_ring_max_cap'
            DataBinding.DataSource = dsTZonaCIP
            Properties.KeyFieldNames = 'oid'
            Properties.ListColumns = <
              item
                FieldName = 'descripcion'
              end>
            Properties.ListOptions.ShowHeader = False
            Properties.ListSource = DSRing
            TabOrder = 5
            Width = 217
          end
        end
      end
    end
  end
  inherited DriverABM: TDriverABM
    OperTraerObjeto = 'TraerZonaCIP'
    OperGrabarObjeto = 'SaveZonaCIP'
    CargaDataSets = <
      item
        DataSet = TZonaCIP
        TableName = 'TZonaCIP'
      end
      item
        DataSet = TEstadosZonas
        TableName = 'TEstadosZonas'
      end>
    BajaLogica = <
      item
        DataSet = TZonaCIP
        ValorBaja = 'false'
        ValorRehabilitacion = 'true'
        TipoBajaRegistro = tblCurrentRecord
        FieldName = 'activo'
      end>
    OperHabilitadas = [toOperNuevo, toOperModificar, toOperEliminar, toOperBuscar, toOperNavegacion, toOperRehabilitar]
    DataSetCab = TZonaCIP
    ControlFocoAlta = DBECodigo
    ControlFocoModif = DBECodigo
    Left = 512
    Top = 16
  end
  inherited Operacion: TOperacion
    Left = 552
    Top = 16
  end
  object TZonaCIP: TsnTable [3]
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
    Left = 648
    Top = 59
    object TZonaCIPoid_zona: TIntegerField
      FieldName = 'oid_zona'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TZonaCIPcodigo: TStringField
      DisplayWidth = 50
      FieldName = 'codigo'
      Size = 50
    end
    object TZonaCIPdescripcion: TStringField
      DisplayWidth = 100
      FieldName = 'descripcion'
      Size = 100
    end
    object TZonaCIPcolor: TStringField
      FieldName = 'color'
      Size = 50
    end
    object TZonaCIPoid_tipo_zona: TIntegerField
      FieldName = 'oid_tipo_zona'
    end
    object TZonaCIPactivo: TBooleanField
      DefaultExpression = '1'
      FieldName = 'activo'
    end
    object TZonaCIPcapacidad_max: TIntegerField
      FieldName = 'capacidad_max'
    end
    object TZonaCIPalarma_de_cap: TIntegerField
      FieldName = 'alarma_de_cap'
    end
    object TZonaCIPbloquear_exc_cap: TBooleanField
      FieldName = 'bloquear_exc_cap'
    end
    object TZonaCIPestado_zona: TStringField
      FieldName = 'estado_zona'
    end
    object TZonaCIPubicacion: TStringField
      FieldName = 'ubicacion'
      Size = 255
    end
    object TZonaCIPoid_grupo_usu_alar: TIntegerField
      FieldName = 'oid_grupo_usu_alar'
    end
    object TZonaCIPoid_grupo_maq_alar: TIntegerField
      FieldName = 'oid_grupo_maq_alar'
    end
    object TZonaCIPmens_alar_cap_max: TStringField
      FieldName = 'mens_alar_cap_max'
      Size = 255
    end
    object TZonaCIPoid_ring_max_cap: TIntegerField
      FieldName = 'oid_ring_max_cap'
    end
    object TZonaCIPes_externa: TBooleanField
      FieldName = 'es_externa'
    end
    object TZonaCIPcontrola_anti_ent: TBooleanField
      FieldName = 'controla_anti_ent'
    end
    object TZonaCIPcontrola_anti_sal: TBooleanField
      FieldName = 'controla_anti_sal'
    end
  end
  object dsTZonaCIP: TDataSource [4]
    DataSet = TZonaCIP
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
    Left = 112
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
    Left = 400
  end
  inherited DriverEvent: TDriverEvent
    OnValidate = <
      item
        TableName = 'TZonaCIP'
        FieldName = 'codigo'
        Source.Strings = (
          'begin'
          '  ValidadorZona.Value := Sender.AsString;'
          '  ValidadorZona.Validar;'
          'end.')
      end>
    OnNuevoRegistro = <
      item
        TableName = 'TZonaCIP'
        Source.Strings = (
          'begin'
          '  DataSet.FieldName('#39'activo'#39').AsBoolean := true;'
          '  DataSet.FieldName('#39'es_externa'#39').AsBoolean := false;'
          '  DataSet.FieldName('#39'controla_anti_ent'#39').AsBoolean := false;'
          '  DataSet.FieldName('#39'controla_anti_sal'#39').AsBoolean := false;'
          'end.')
      end>
    OnInicializar = <
      item
        Source.Strings = (
          'begin'
          '  Inicializar();'
          '  TTiposZonas.loadFromHelp('#39'HelpTiposZonas'#39');'
          '  TGrupoUsuario.loadFromHelp('#39'HelpGrupoUsuario'#39');'
          '  TGrupoMaquinas.LoadFromHelp('#39'HelpGrupoMaquinas'#39');'
          '  TRing.LoadFromHelp('#39'HelpRing'#39');'
          'end.')
      end>
    OnFormFunction = <
      item
        Source.Strings = (
          'procedure Inicializar();'
          'begin'
          '  operacion.InicioOperacion();'
          '  operacion.setOper('#39'TraerEstadosZonas'#39');'
          '  operacion.execute();'
          'end;')
      end>
    Left = 592
    Top = 83
  end
  inherited SaveArchivo: TSaveDialog
    Left = 552
    Top = 152
  end
  inherited ImprimirObjetoSeleccionado: TdxComponentPrinter
    inherited ImprimirObjetoSeleccionadodxComponentPrinterLink: TdxGridReportLink
      BuiltInReportLink = True
    end
  end
  inherited PopUp: TsnPopUp
    Left = 561
    Top = 80
  end
  inherited ImageListItemsPopUp: TImageList
    Top = 187
  end
  object HelpZonasCIP: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'cip.ZonaCIP'
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
    Titulo = 'Zonas'
    AnchoHelp = 600
    ActivarCache = False
    ShowBotonBuscar = False
    Left = 34
    Top = 12
  end
  object ValidadorZona: TValidador
    Operacion = Operacion
    NickNameObjLog = 'cip.ZonaCIP'
    WhenRaiseException = teFound
    MensajeException = 'C'#243'digo de Zona duplicado'
    NroQuery = 0
    Cache = False
    Left = 72
    Top = 11
  end
  object HelpTiposZonas: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'cip.TipoZona'
    NroHelp = 5
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
    Titulo = 'Tipos de Zonas'
    AnchoHelp = 600
    ActivarCache = False
    ShowBotonBuscar = False
    Left = 346
    Top = 221
  end
  object TTiposZonas: TsnTable
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
    Left = 376
    Top = 220
    object TTiposZonasoid: TIntegerField
      FieldName = 'oid'
    end
    object StringField1: TStringField
      FieldName = 'codigo'
      Size = 50
    end
    object StringField2: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
  end
  object DSTiposZonas: TDataSource
    DataSet = TTiposZonas
    Left = 409
    Top = 222
  end
  object TEstadosZonas: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <>
    IndexFieldNames = 'descripcion'
    IndexDefs = <
      item
        Name = 'TEstadosZonasIndex1'
        Fields = 'descripcion'
      end>
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
    Left = 585
    Top = 166
    object TEstadosZonascodigo: TStringField
      FieldName = 'codigo'
      Size = 50
    end
    object TEstadosZonasdescripcion: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
  end
  object DSEstadosZonas: TDataSource
    DataSet = TEstadosZonas
    Left = 617
    Top = 166
  end
  object HelpGrupoUsuario: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'me.GrupoUsuMens'
    NroHelp = 5
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
    Titulo = 'Grupo de Usuarios'
    AnchoHelp = 600
    ActivarCache = False
    ShowBotonBuscar = False
    Left = 346
    Top = 269
  end
  object TGrupoUsuario: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'oid'
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
    Left = 377
    Top = 267
    object TGrupoUsuariooid: TIntegerField
      FieldName = 'oid'
    end
    object TGrupoUsuariocodigo: TStringField
      FieldName = 'codigo'
      Size = 50
    end
    object TGrupoUsuariodescripcion: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
  end
  object DSGrupoUsuario: TDataSource
    DataSet = TGrupoUsuario
    Left = 409
    Top = 267
  end
  object HelpGrupoMaquinas: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'ge.GrupoMaquina'
    NroHelp = 5
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
    Titulo = 'Grupo de M'#225'quinas'
    AnchoHelp = 600
    ActivarCache = False
    ShowBotonBuscar = False
    Left = 346
    Top = 313
  end
  object TGrupoMaquinas: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'oid'
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
    Left = 377
    Top = 311
    object IntegerField1: TIntegerField
      FieldName = 'oid'
    end
    object StringField3: TStringField
      FieldName = 'codigo'
      Size = 50
    end
    object StringField4: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
  end
  object DSGrupoMaquinas: TDataSource
    DataSet = TGrupoMaquinas
    Left = 409
    Top = 311
  end
  object HelpRing: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'me.Ring'
    NroHelp = 5
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
    Titulo = 'Ring'
    AnchoHelp = 600
    ActivarCache = False
    ShowBotonBuscar = False
    Left = 346
    Top = 347
  end
  object TRing: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'oid'
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
    Left = 377
    Top = 345
    object IntegerField2: TIntegerField
      FieldName = 'oid'
    end
    object StringField5: TStringField
      FieldName = 'codigo'
      Size = 50
    end
    object StringField6: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
  end
  object DSRing: TDataSource
    DataSet = TRing
    Left = 409
    Top = 345
  end
end
