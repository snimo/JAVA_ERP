inherited FTipoArchConciTar: TFTipoArchConciTar
  Left = 91
  Top = 145
  Height = 460
  Caption = 'Tipos de Archivos a Conciliar'
  PixelsPerInch = 96
  TextHeight = 13
  inherited PForm: TPanel
    Height = 426
    inherited PPie: TPanel
      Top = 405
    end
    inherited PMenu: TPanel
      inherited ImagenEliminar: TImagenEstado
        DataField = 'activo'
        DataSource = DSTTipoArchConciTar
        ValorEstadoVisible = 'True'
      end
      inherited ImagenRehabilitar: TImagenEstado
        DataField = 'activo'
        DataSource = DSTTipoArchConciTar
        ValorEstadoVisible = 'False'
      end
      inherited ImagenBuscar: TImagenHelpObjNeg
        Help = HelpTipoArchivos
      end
      inherited ImagenSiguiente: TImagenHelpObjNeg
        Help = HelpTipoArchivos
      end
      inherited ImagenAnterior: TImagenHelpObjNeg
        Help = HelpTipoArchivos
      end
      inherited PanelEstadoON: TPanelEstado
        DataField = 'activo'
        DataSource = DSTTipoArchConciTar
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
    inherited PCuerpo: TPanel
      Height = 330
      object Label1: TLabel
        Left = 40
        Top = 8
        Width = 33
        Height = 13
        Caption = 'C'#243'digo'
      end
      object Label2: TLabel
        Left = 41
        Top = 72
        Width = 76
        Height = 13
        Caption = 'Comportamiento'
      end
      object Label3: TLabel
        Left = 40
        Top = 40
        Width = 56
        Height = 13
        Caption = 'Descripci'#243'n'
      end
      object Label4: TLabel
        Left = 152
        Top = 285
        Width = 133
        Height = 13
        Caption = 'Ante'#250'ltima Carpeta Empresa'
        Visible = False
      end
      object Label5: TLabel
        Left = 152
        Top = 309
        Width = 132
        Height = 13
        Caption = 'Ultima Carpeta Tipo Archivo'
        Visible = False
      end
      object snLabel1: TsnLabel
        Left = 48
        Top = 232
        Width = 206
        Height = 13
        Caption = 'Importaci'#243'n de Archivos de Tarjetas'
        Font.Charset = DEFAULT_CHARSET
        Font.Color = clNavy
        Font.Height = -11
        Font.Name = 'MS Sans Serif'
        Font.Style = [fsBold, fsUnderline]
        ParentFont = False
        Visible = False
      end
      object snLabel2: TsnLabel
        Left = 128
        Top = 261
        Width = 271
        Height = 13
        Caption = 'Seg'#250'n la ubicaci'#243'n del archivo en sus carpetas'
        Font.Charset = DEFAULT_CHARSET
        Font.Color = clNavy
        Font.Height = -11
        Font.Name = 'MS Sans Serif'
        Font.Style = [fsBold]
        ParentFont = False
        Visible = False
      end
      object snLabel3: TsnLabel
        Left = 40
        Top = 103
        Width = 422
        Height = 13
        Caption = 
          'Importaci'#243'n Archivo de Tarjetas seg'#250'n contenga en el nombre del ' +
          'Archivo'
        Font.Charset = DEFAULT_CHARSET
        Font.Color = clNavy
        Font.Height = -11
        Font.Name = 'MS Sans Serif'
        Font.Style = [fsBold]
        ParentFont = False
      end
      object Label6: TLabel
        Left = 40
        Top = 133
        Width = 117
        Height = 13
        Caption = 'Que contenga la palabra'
      end
      object DBECodigo: TsnDBEdit
        Left = 189
        Top = 4
        DataBinding.DataField = 'codigo'
        DataBinding.DataSource = DSTTipoArchConciTar
        Properties.CharCase = ecUpperCase
        Properties.MaxLength = 20
        Style.BorderColor = clWindowFrame
        Style.Shadow = False
        TabOrder = 0
        Width = 156
      end
      object DBEmpresa: TsnDBLookup
        Left = 189
        Top = 68
        DataBinding.DataField = 'comportamiento'
        DataBinding.DataSource = DSTTipoArchConciTar
        Properties.KeyFieldNames = 'codigo'
        Properties.ListColumns = <
          item
            FieldName = 'descripcion'
          end>
        Properties.ListOptions.ShowHeader = False
        Properties.ListSource = DSComporTipoArchivo
        TabOrder = 2
        Width = 197
      end
      object snDBEdit1: TsnDBEdit
        Left = 189
        Top = 36
        DataBinding.DataField = 'descripcion'
        DataBinding.DataSource = DSTTipoArchConciTar
        Properties.CharCase = ecUpperCase
        Properties.MaxLength = 50
        Style.BorderColor = clWindowFrame
        Style.Shadow = False
        TabOrder = 1
        Width = 372
      end
      object snDBEdit2: TsnDBEdit
        Left = 301
        Top = 281
        DataBinding.DataField = 'ant_ult_folder_emp'
        DataBinding.DataSource = DSTTipoArchConciTar
        Properties.MaxLength = 255
        Style.BorderColor = clWindowFrame
        Style.Shadow = False
        TabOrder = 3
        Visible = False
        Width = 396
      end
      object snDBEdit3: TsnDBEdit
        Left = 301
        Top = 305
        DataBinding.DataField = 'ult_folder_tipo'
        DataBinding.DataSource = DSTTipoArchConciTar
        Properties.MaxLength = 255
        Style.BorderColor = clWindowFrame
        Style.Shadow = False
        TabOrder = 4
        Visible = False
        Width = 396
      end
      object snDBEdit4: TsnDBEdit
        Left = 189
        Top = 129
        DataBinding.DataField = 'cod_arch_imp_tarj'
        DataBinding.DataSource = DSTTipoArchConciTar
        Properties.MaxLength = 255
        Style.BorderColor = clWindowFrame
        Style.Shadow = False
        TabOrder = 5
        Width = 100
      end
    end
  end
  inherited DriverABM: TDriverABM
    OperTraerObjeto = 'TraerTipoArchCTar'
    OperGrabarObjeto = 'SaveTipoArchConciTar'
    CargaDataSets = <
      item
        DataSet = TTipoArchConciTar
        TableName = 'TTipoArchConciTar'
      end
      item
        DataSet = TUniNegConciTar
        TableName = 'TUniNegConciTar'
      end
      item
        DataSet = TComporTipoArch
        TableName = 'TComporTipoArch'
      end>
    BajaLogica = <
      item
        DataSet = TTipoArchConciTar
        ValorBaja = 'false'
        ValorRehabilitacion = 'true'
        TipoBajaRegistro = tblCurrentRecord
        FieldName = 'activo'
      end>
    OperHabilitadas = [toOperNuevo, toOperModificar, toOperEliminar, toOperBuscar, toOperNavegacion, toOperRehabilitar]
    DataSetCab = TTipoArchConciTar
    ControlFocoAlta = DBECodigo
    ControlFocoModif = DBECodigo
    Left = 520
    Top = 16
  end
  inherited Operacion: TOperacion
    Left = 560
    Top = 16
  end
  object TTipoArchConciTar: TsnTable [3]
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
    object TTipoArchConciTaroid_tipo_archivo: TIntegerField
      FieldName = 'oid_tipo_archivo'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TTipoArchConciTarcodigo: TStringField
      FieldName = 'codigo'
    end
    object TTipoArchConciTardescripcion: TStringField
      DisplayWidth = 50
      FieldName = 'descripcion'
      Size = 50
    end
    object TTipoArchConciTarcomportamiento: TStringField
      FieldName = 'comportamiento'
    end
    object TTipoArchConciTarant_ult_folder_emp: TStringField
      FieldName = 'ant_ult_folder_emp'
      Size = 255
    end
    object TTipoArchConciTarult_folder_tipo: TStringField
      FieldName = 'ult_folder_tipo'
      Size = 255
    end
    object TTipoArchConciTaractivo: TBooleanField
      DefaultExpression = '1'
      FieldName = 'activo'
    end
    object TTipoArchConciTarcod_arch_imp_tarj: TStringField
      FieldName = 'cod_arch_imp_tarj'
      Size = 10
    end
  end
  object DSTTipoArchConciTar: TDataSource [4]
    DataSet = TTipoArchConciTar
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
        TableName = 'TTipoArchConciTar'
        FieldName = 'codigo'
        Source.Strings = (
          'begin'
          '  ValidadorTipoArchivo.Value := Sender.AsString;'
          '  ValidadorTipoArchivo.Validar;'
          'end.')
      end>
    OnInicializar = <
      item
        Source.Strings = (
          'begin'
          '  operacion.InicioOperacion();'
          '  operacion.setOper('#39'TraerUnidadesNegConciTar'#39');'
          '  operacion.execute();  '
          '  TraerComportamientos();'
          'end.')
      end>
    OnFormFunction = <
      item
        Source.Strings = (
          'procedure TraerComportamientos();'
          'begin'
          '  operacion.InicioOperacion();'
          '  operacion.setOper('#39'TraerTipoArchConciTar'#39');'
          ' operacion.execute();'
          'end;')
      end>
  end
  inherited ImprimirObjetoSeleccionado: TdxComponentPrinter
    Top = 136
    inherited ImprimirObjetoSeleccionadodxComponentPrinterLink: TdxGridReportLink
      BuiltInReportLink = True
    end
  end
  inherited ImageListItemsPopUp: TImageList
    Left = 264
    Top = 123
  end
  object HelpTipoArchivos: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'ctar.TipoArchConciTar'
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
    Titulo = 'Tipos de Archivos'
    AnchoHelp = 600
    ActivarCache = False
    ShowBotonBuscar = False
    Left = 50
    Top = 28
  end
  object ValidadorTipoArchivo: TValidador
    Operacion = Operacion
    NickNameObjLog = 'ctar.TipoArchConciTar'
    WhenRaiseException = teFound
    MensajeException = 'Tipo de Archivo Existente'
    NroQuery = 0
    Cache = False
    Left = 136
    Top = 67
  end
  object TUniNegConciTar: TsnTable
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
    Left = 384
    Top = 251
    object TUniNegConciTaroid_uni_neg: TIntegerField
      FieldName = 'oid_uni_neg'
    end
    object TUniNegConciTardescripcion: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
    object TUniNegConciTaroid_empresa: TIntegerField
      FieldName = 'oid_empresa'
    end
    object TUniNegConciTaractivo: TBooleanField
      FieldName = 'activo'
    end
  end
  object DSTUniNegConciTar: TDataSource
    DataSet = TUniNegConciTar
    Left = 416
    Top = 251
  end
  object TComporTipoArch: TsnTable
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
    Left = 64
    Top = 243
    object TComporTipoArchcodigo: TStringField
      FieldName = 'codigo'
    end
    object TComporTipoArchdescripcion: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
  end
  object DSComporTipoArchivo: TDataSource
    DataSet = TComporTipoArch
    Left = 96
    Top = 243
  end
end
