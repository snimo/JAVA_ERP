inherited FTerminalConciTar: TFTerminalConciTar
  Left = 134
  Top = 167
  Height = 438
  Caption = 'Terminales'
  PixelsPerInch = 96
  TextHeight = 13
  inherited PForm: TPanel
    Height = 404
    inherited PPie: TPanel
      Top = 383
    end
    inherited PMenu: TPanel
      inherited ImagenEliminar: TImagenEstado
        DataField = 'activo'
        DataSource = DSTTerminalConciTar
        ValorEstadoVisible = 'True'
      end
      inherited ImagenRehabilitar: TImagenEstado
        DataField = 'activo'
        DataSource = DSTTerminalConciTar
        ValorEstadoVisible = 'False'
      end
      inherited ImagenBuscar: TImagenHelpObjNeg
        Help = HelpTerminales
      end
      inherited ImagenSiguiente: TImagenHelpObjNeg
        Help = HelpTerminales
      end
      inherited ImagenAnterior: TImagenHelpObjNeg
        Help = HelpTerminales
      end
      inherited PanelEstadoON: TPanelEstado
        DataField = 'activo'
        DataSource = DSTTerminalConciTar
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
      Height = 308
      object Label1: TLabel
        Left = 40
        Top = 8
        Width = 63
        Height = 13
        Caption = 'Nro. Terminal'
      end
      object Label2: TLabel
        Left = 40
        Top = 72
        Width = 97
        Height = 13
        Caption = 'Unidad de Negocios'
      end
      object Label3: TLabel
        Left = 40
        Top = 40
        Width = 56
        Height = 13
        Caption = 'Descripci'#243'n'
      end
      object Label4: TLabel
        Left = 40
        Top = 104
        Width = 121
        Height = 13
        Caption = 'Carpeta Archivos Entrada'
      end
      object Label5: TLabel
        Left = 40
        Top = 136
        Width = 140
        Height = 13
        Caption = 'Carpeta Archivos Procesados'
      end
      object Label6: TLabel
        Left = 40
        Top = 168
        Width = 138
        Height = 13
        Caption = 'Carpeta Archivos con Errores'
      end
      object DBECodigo: TsnDBEdit
        Left = 189
        Top = 4
        DataBinding.DataField = 'nro_terminal'
        DataBinding.DataSource = DSTTerminalConciTar
        Properties.CharCase = ecUpperCase
        Properties.MaxLength = 20
        Style.BorderColor = clWindowFrame
        Style.Shadow = False
        TabOrder = 0
        Width = 156
      end
      object DBEmpresa: TsnDBLookup
        Left = 188
        Top = 68
        DataBinding.DataField = 'oid_uni_neg'
        DataBinding.DataSource = DSTTerminalConciTar
        Properties.KeyFieldNames = 'oid_uni_neg'
        Properties.ListColumns = <
          item
            FieldName = 'descripcion'
          end>
        Properties.ListOptions.ShowHeader = False
        Properties.ListSource = DSTUniNegConciTar
        TabOrder = 2
        Width = 317
      end
      object snDBEdit1: TsnDBEdit
        Left = 189
        Top = 36
        DataBinding.DataField = 'descripcion'
        DataBinding.DataSource = DSTTerminalConciTar
        Properties.CharCase = ecUpperCase
        Properties.MaxLength = 100
        Style.BorderColor = clWindowFrame
        Style.Shadow = False
        TabOrder = 1
        Width = 372
      end
      object snDBEdit2: TsnDBEdit
        Left = 189
        Top = 100
        DataBinding.DataField = 'Folder_IN_CieLot'
        DataBinding.DataSource = DSTTerminalConciTar
        Properties.MaxLength = 100
        Style.BorderColor = clWindowFrame
        Style.Shadow = False
        TabOrder = 3
        Width = 436
      end
      object snDBEdit3: TsnDBEdit
        Left = 189
        Top = 132
        DataBinding.DataField = 'folder_arch_proc'
        DataBinding.DataSource = DSTTerminalConciTar
        Properties.MaxLength = 100
        Style.BorderColor = clWindowFrame
        Style.Shadow = False
        TabOrder = 4
        Width = 436
      end
      object snDBEdit4: TsnDBEdit
        Left = 189
        Top = 164
        DataBinding.DataField = 'folder_lote_error'
        DataBinding.DataSource = DSTTerminalConciTar
        Properties.MaxLength = 100
        Style.BorderColor = clWindowFrame
        Style.Shadow = False
        TabOrder = 5
        Width = 436
      end
    end
  end
  inherited DriverABM: TDriverABM
    OperTraerObjeto = 'TraerTerminalConciTar'
    OperGrabarObjeto = 'SaveTerminalConciTar'
    CargaDataSets = <
      item
        DataSet = TTerminalConciTar
        TableName = 'TTerminalConciTar'
      end
      item
        DataSet = TUniNegConciTar
        TableName = 'TUniNegConciTar'
      end>
    BajaLogica = <
      item
        DataSet = TTerminalConciTar
        ValorBaja = 'false'
        ValorRehabilitacion = 'true'
        TipoBajaRegistro = tblCurrentRecord
        FieldName = 'activo'
      end>
    OperHabilitadas = [toOperNuevo, toOperModificar, toOperEliminar, toOperBuscar, toOperNavegacion, toOperRehabilitar]
    DataSetCab = TTerminalConciTar
    ControlFocoAlta = DBECodigo
    ControlFocoModif = DBECodigo
    Left = 520
    Top = 16
  end
  inherited Operacion: TOperacion
    Left = 560
    Top = 16
  end
  object TTerminalConciTar: TsnTable [3]
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
    object TTerminalConciTaroid_terminal: TIntegerField
      FieldName = 'oid_terminal'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TTerminalConciTarnro_terminal: TStringField
      FieldName = 'nro_terminal'
    end
    object TTerminalConciTardescripcion: TStringField
      DisplayWidth = 100
      FieldName = 'descripcion'
      Size = 100
    end
    object TTerminalConciTarFolder_IN_CieLot: TStringField
      FieldName = 'Folder_IN_CieLot'
      Size = 100
    end
    object TTerminalConciTaroid_uni_neg: TIntegerField
      FieldName = 'oid_uni_neg'
    end
    object TTerminalConciTaractivo: TBooleanField
      DefaultExpression = '1'
      FieldName = 'activo'
    end
    object TTerminalConciTarfolder_arch_proc: TStringField
      FieldName = 'folder_arch_proc'
      Size = 100
    end
    object TTerminalConciTarfolder_lote_error: TStringField
      FieldName = 'folder_lote_error'
      Size = 255
    end
  end
  object DSTTerminalConciTar: TDataSource [4]
    DataSet = TTerminalConciTar
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
        TableName = 'TTerminalConciTar'
        FieldName = 'nro_terminal'
        Source.Strings = (
          'begin'
          '  ValidadorTerminal.Value := Sender.AsString;'
          '  ValidadorTerminal.Validar;'
          'end.')
      end>
    OnInicializar = <
      item
        Source.Strings = (
          'begin'
          '  operacion.InicioOperacion();'
          '  operacion.setOper('#39'TraerUnidadesNegConciTar'#39');'
          ' operacion.execute();  '
          'end.')
      end>
  end
  inherited ImprimirObjetoSeleccionado: TdxComponentPrinter
    inherited ImprimirObjetoSeleccionadodxComponentPrinterLink: TdxGridReportLink
      BuiltInReportLink = True
    end
  end
  inherited ImageListItemsPopUp: TImageList
    Left = 264
  end
  object HelpTerminales: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'ctar.TerminalConciTar'
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
    Titulo = 'Terminales'
    AnchoHelp = 600
    ActivarCache = False
    ShowBotonBuscar = False
    Left = 50
    Top = 28
  end
  object ValidadorTerminal: TValidador
    Operacion = Operacion
    NickNameObjLog = 'ctar.TerminalConciTar'
    WhenRaiseException = teFound
    MensajeException = 'Nro. de Terminal Duplicada'
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
end
