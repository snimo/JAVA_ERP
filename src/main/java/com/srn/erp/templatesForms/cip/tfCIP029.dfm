inherited FPersonalSeguridad: TFPersonalSeguridad
  Left = 133
  Top = 206
  Width = 730
  Height = 396
  Caption = 'Personal de Seguridad'
  PixelsPerInch = 96
  TextHeight = 13
  inherited PForm: TPanel
    Width = 722
    Height = 362
    inherited PPie: TPanel
      Top = 341
      Width = 722
      inherited StatusBarABM: TStatusBar
        Left = 617
      end
      inherited StatusBar2: TStatusBar
        Width = 617
      end
    end
    inherited PMenu: TPanel
      Width = 722
      inherited ImagenEliminar: TImagenEstado
        DataField = 'activo'
        DataSource = DSTPersonalSeguridad
        ValorEstadoVisible = 'True'
      end
      inherited ImagenRehabilitar: TImagenEstado
        DataField = 'activo'
        DataSource = DSTPersonalSeguridad
        ValorEstadoVisible = 'False'
      end
      inherited ImagenBuscar: TImagenHelpObjNeg
        Help = HelpPersSeg
      end
      inherited ImagenSiguiente: TImagenHelpObjNeg
        Help = HelpPersSeg
      end
      inherited ImagenAnterior: TImagenHelpObjNeg
        Help = HelpPersSeg
      end
      inherited Panel2: TPanel
        Left = 681
      end
      inherited PanelEstadoON: TPanelEstado
        DataField = 'activo'
        DataSource = DSTPersonalSeguridad
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
      Width = 722
    end
    inherited PCabecera: TPanel
      Width = 722
    end
    inherited PCuerpo: TPanel
      Width = 722
      Height = 266
      object Label1: TLabel
        Left = 40
        Top = 8
        Width = 33
        Height = 13
        Caption = 'C'#243'digo'
      end
      object Label2: TLabel
        Left = 40
        Top = 40
        Width = 37
        Height = 13
        Caption = 'Apellido'
      end
      object Label3: TLabel
        Left = 40
        Top = 72
        Width = 37
        Height = 13
        Caption = 'Nombre'
      end
      object Label4: TLabel
        Left = 40
        Top = 104
        Width = 94
        Height = 13
        Caption = 'Tipo de Documento'
      end
      object snLabel1: TsnLabel
        Left = 368
        Top = 104
        Width = 93
        Height = 13
        Caption = 'Nro. de Documento'
      end
      object DBECodigo: TsnDBEdit
        Left = 156
        Top = 4
        DataBinding.DataField = 'codigo'
        DataBinding.DataSource = DSTPersonalSeguridad
        Properties.CharCase = ecUpperCase
        Properties.MaxLength = 20
        Style.BorderColor = clWindowFrame
        Style.Shadow = False
        TabOrder = 0
        Width = 133
      end
      object snDBEdit1: TsnDBEdit
        Left = 156
        Top = 36
        DataBinding.DataField = 'apellido'
        DataBinding.DataSource = DSTPersonalSeguridad
        Properties.MaxLength = 50
        Style.BorderColor = clWindowFrame
        Style.Shadow = False
        TabOrder = 1
        Width = 469
      end
      object snDBEdit2: TsnDBEdit
        Left = 156
        Top = 68
        DataBinding.DataField = 'nombre'
        DataBinding.DataSource = DSTPersonalSeguridad
        Properties.MaxLength = 50
        Style.BorderColor = clWindowFrame
        Style.Shadow = False
        TabOrder = 2
        Width = 469
      end
      object snDBLookup1: TsnDBLookup
        Left = 156
        Top = 100
        DataBinding.DataField = 'oid_tipo_docu'
        DataBinding.DataSource = DSTPersonalSeguridad
        Properties.KeyFieldNames = 'oid'
        Properties.ListColumns = <
          item
            FieldName = 'descripcion'
          end>
        Properties.ListOptions.ShowHeader = False
        Properties.ListSource = DSTipoDocu
        TabOrder = 3
        Width = 189
      end
      object snDBEdit3: TsnDBEdit
        Left = 472
        Top = 100
        DataBinding.DataField = 'nro_docu'
        DataBinding.DataSource = DSTPersonalSeguridad
        Properties.MaxLength = 50
        Style.BorderColor = clWindowFrame
        Style.Shadow = False
        TabOrder = 4
        Width = 153
      end
      object snDBCheckEdit1: TsnDBCheckEdit
        Left = 152
        Top = 128
        Caption = 'Habilitado para cacheo de Personas'
        DataBinding.DataField = 'cacheo_seg'
        DataBinding.DataSource = DSTPersonalSeguridad
        TabOrder = 5
        Width = 233
      end
    end
  end
  inherited DriverABM: TDriverABM
    OperTraerObjeto = 'TraerPersonalSeguridad'
    OperGrabarObjeto = 'SavePersonalSeguridad'
    CargaDataSets = <
      item
        DataSet = TPersonalSeguridad
        TableName = 'TPersonalSeguridad'
      end>
    BajaLogica = <
      item
        DataSet = TPersonalSeguridad
        ValorBaja = 'false'
        ValorRehabilitacion = 'true'
        TipoBajaRegistro = tblCurrentRecord
        FieldName = 'activo'
      end>
    OperHabilitadas = [toOperNuevo, toOperModificar, toOperEliminar, toOperBuscar, toOperNavegacion, toOperRehabilitar]
    DataSetCab = TPersonalSeguridad
    ControlFocoAlta = DBECodigo
    ControlFocoModif = DBECodigo
    Left = 512
    Top = 16
  end
  inherited Operacion: TOperacion
    Left = 560
    Top = 16
  end
  object TPersonalSeguridad: TsnTable [3]
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
    object TPersonalSeguridadoid_pers_secu: TIntegerField
      FieldName = 'oid_pers_secu'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TPersonalSeguridadcodigo: TStringField
      DisplayWidth = 20
      FieldName = 'codigo'
    end
    object TPersonalSeguridadactivo: TBooleanField
      DefaultExpression = '1'
      FieldName = 'activo'
    end
    object TPersonalSeguridadapellido: TStringField
      FieldName = 'apellido'
      Size = 50
    end
    object TPersonalSeguridadnombre: TStringField
      FieldName = 'nombre'
      Size = 50
    end
    object TPersonalSeguridadoid_tipo_docu: TIntegerField
      FieldName = 'oid_tipo_docu'
    end
    object TPersonalSeguridadcacheo_seg: TBooleanField
      FieldName = 'cacheo_seg'
    end
    object TPersonalSeguridadnro_docu: TStringField
      FieldName = 'nro_docu'
      Size = 50
    end
  end
  object DSTPersonalSeguridad: TDataSource [4]
    DataSet = TPersonalSeguridad
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
        TableName = 'TPersonalSeguridad'
        FieldName = 'codigo'
        Source.Strings = (
          'begin'
          '  ValidadorPersSeg.Value := Sender.AsString;'
          '  ValidadorPersSeg.Validar;'
          'end.')
      end>
    OnNuevoRegistro = <
      item
        TableName = 'TPersonalSeguridad'
        Source.Strings = (
          'begin'
          '  DataSet.FieldName('#39'cacheo_seg'#39').AsBoolean := true;'
          'end.')
      end>
    OnInicializar = <
      item
        Source.Strings = (
          'begin'
          '  TTipoDocu.loadFromHelp('#39'HelpTipoDocuCIP'#39');'
          'end.')
      end>
  end
  inherited ImprimirObjetoSeleccionado: TdxComponentPrinter
    Left = 48
    Top = 64
    inherited ImprimirObjetoSeleccionadodxComponentPrinterLink: TdxGridReportLink
      BuiltInReportLink = True
    end
  end
  object HelpPersSeg: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'cip.PersonalSeguridad'
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
    Titulo = 'Personal de Seguridad'
    AnchoHelp = 600
    ActivarCache = False
    ShowBotonBuscar = False
    Left = 50
    Top = 28
  end
  object ValidadorPersSeg: TValidador
    Operacion = Operacion
    NickNameObjLog = 'cip.PersonalSeguridad'
    WhenRaiseException = teFound
    MensajeException = 'C'#243'digo de Estado duplicado'
    NroQuery = 0
    Cache = False
    Left = 136
    Top = 51
  end
  object TTipoDocu: TsnTable
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
    Left = 352
    Top = 211
    object TTipoDocuoid: TIntegerField
      FieldName = 'oid'
    end
    object TTipoDocucodigo: TStringField
      FieldName = 'codigo'
      Size = 50
    end
    object TTipoDocudescripcion: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
  end
  object HelpTipoDocuCIP: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 've.TipoDocumento'
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
    Titulo = 'Tipo de Documentacion'
    AnchoHelp = 600
    ActivarCache = False
    ShowBotonBuscar = False
    Left = 434
    Top = 213
  end
  object DSTipoDocu: TDataSource
    DataSet = TTipoDocu
    Left = 392
    Top = 211
  end
end
