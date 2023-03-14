inherited FCantJuegos: TFCantJuegos
  Left = 133
  Top = 206
  Width = 749
  Height = 641
  Caption = 'Cantidad de Juegos'
  PixelsPerInch = 96
  TextHeight = 13
  inherited PForm: TPanel
    Width = 733
    Height = 603
    inherited PPie: TPanel
      Top = 582
      Width = 733
      inherited StatusBarABM: TStatusBar
        Left = 628
      end
      inherited StatusBar2: TStatusBar
        Width = 628
      end
    end
    inherited PMenu: TPanel
      Width = 733
      inherited ImagenEliminar: TImagenEstado
        DataField = 'activo'
        DataSource = dsTGrados
        ValorEstadoVisible = 'True'
      end
      inherited ImagenRehabilitar: TImagenEstado
        DataField = 'activo'
        DataSource = dsTGrados
        ValorEstadoVisible = 'False'
      end
      inherited ImagenSiguiente: TImagenHelpObjNeg
        Help = HelpGrados
      end
      inherited ImagenAnterior: TImagenHelpObjNeg
        Help = HelpGrados
      end
      inherited Panel2: TPanel
        Left = 692
      end
      inherited PanelEstadoON: TPanelEstado
        DataField = 'activo'
        DataSource = dsTGrados
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
      Width = 733
    end
    inherited PCabecera: TPanel
      Width = 733
      Height = 530
      Align = alClient
      object dxDBGridSN1: TdxDBGridSN
        Left = 0
        Top = 0
        Width = 733
        Height = 530
        Align = alClient
        TabOrder = 0
        LookAndFeel.Kind = lfFlat
        CriteriosPintarCelda = <>
        object dxDBGridSN1DBTableView1: TcxGridDBTableView
          NavigatorButtons.ConfirmDelete = False
          DataController.DataSource = dsTGrados
          DataController.Summary.DefaultGroupSummaryItems = <>
          DataController.Summary.FooterSummaryItems = <>
          DataController.Summary.SummaryGroups = <>
          OptionsData.CancelOnExit = False
          OptionsData.Deleting = False
          OptionsData.DeletingConfirmation = False
          OptionsData.Inserting = False
          OptionsView.GroupByBox = False
          object dxDBGridSN1DBTableView1codigo: TcxGridDBColumn
            Caption = 'C'#243'digo'
            DataBinding.FieldName = 'codigo'
            HeaderAlignmentHorz = taCenter
            Options.Editing = False
            Width = 82
          end
          object dxDBGridSN1DBTableView1descripcion: TcxGridDBColumn
            Caption = 'Descripci'#243'n'
            DataBinding.FieldName = 'descripcion'
            HeaderAlignmentHorz = taCenter
            Options.Editing = False
            Width = 400
          end
          object dxDBGridSN1DBTableView1cant_juegos_a: TcxGridDBColumn
            Caption = 'Cant. Juegos A'
            DataBinding.FieldName = 'cant_juegos_a'
            HeaderAlignmentHorz = taCenter
            Width = 108
          end
          object dxDBGridSN1DBTableView1cant_juegos_b: TcxGridDBColumn
            Caption = 'Cant. Juegos B'
            DataBinding.FieldName = 'cant_juegos_b'
            HeaderAlignmentHorz = taCenter
            Width = 97
          end
        end
        object dxDBGridSN1Level1: TcxGridLevel
          GridView = dxDBGridSN1DBTableView1
        end
      end
    end
    inherited PCuerpo: TPanel
      Top = 52
      Width = 733
      Height = 0
      Align = alNone
    end
  end
  inherited DriverABM: TDriverABM
    OperTraerObjeto = 'TraerGradoLegajo'
    OperGrabarObjeto = 'SaveGradoLegajo'
    CargaDataSets = <
      item
        DataSet = TGrados
        TableName = 'TGrados'
      end>
    BajaLogica = <
      item
        DataSet = TGrados
        ValorBaja = 'false'
        ValorRehabilitacion = 'true'
        TipoBajaRegistro = tblCurrentRecord
        FieldName = 'activo'
      end>
    OperHabilitadas = [toOperNuevo, toOperModificar, toOperEliminar, toOperBuscar, toOperNavegacion, toOperRehabilitar]
    DataSetCab = TGrados
    AllowModifiedEmptyDataSetCab = True
    Left = 512
    Top = 16
  end
  inherited Operacion: TOperacion
    Left = 560
    Top = 16
  end
  object TGrados: TsnTable [3]
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'oid_competencia'
        DataType = ftInteger
      end
      item
        Name = 'codigo'
        DataType = ftString
        Size = 20
      end
      item
        Name = 'titulo'
        DataType = ftString
        Size = 100
      end
      item
        Name = 'activo'
        DataType = ftBoolean
      end
      item
        Name = 'definicion'
        DataType = ftString
        Size = 4000
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
    object TGradosoid_grado_leg: TIntegerField
      FieldName = 'oid_grado_leg'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TGradoscodigo: TStringField
      DisplayWidth = 20
      FieldName = 'codigo'
      Size = 50
    end
    object TGradosdescripcion: TStringField
      DisplayWidth = 100
      FieldName = 'descripcion'
      Size = 100
    end
    object TGradosactivo: TBooleanField
      DefaultExpression = '1'
      FieldName = 'activo'
    end
    object TGradoscant_juegos_a: TIntegerField
      FieldName = 'cant_juegos_a'
    end
    object TGradoscant_juegos_b: TIntegerField
      FieldName = 'cant_juegos_b'
    end
  end
  object dsTGrados: TDataSource [4]
    DataSet = TGrados
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
    Left = 336
    Top = 24
    inherited dxComponentPrinterLink1: TdxCustomContainerReportLink
      Component = Owner
      BuiltInReportLink = True
      HiddenComponents = {}
      ExcludedComponents = {}
      AggregatedReportLinks = {}
    end
  end
  inherited SaveDialog: TSaveDialog
    Left = 448
    Top = 24
  end
  inherited DriverEvent: TDriverEvent
    OnInicializar = <
      item
        Source.Strings = (
          'begin'
          '  DriverABM.OperBuscar;'
          '  Buscar();'
          'end.')
      end>
    OnAfterBuscar = <
      item
        Source.Strings = (
          'begin'
          '  operacion.InicioOperacion();'
          '  operacion.setOper('#39'TraerCantJuegosGrado'#39');'
          ' operacion.execute();'
          'end.')
      end>
    OnAfterGrabar = <
      item
        Source.Strings = (
          'begin'
          '  DriverABM.OperBuscar;'
          '  Buscar();'
          'end.')
      end>
    Left = 416
    Top = 27
  end
  inherited ImprimirObjetoSeleccionado: TdxComponentPrinter
    inherited ImprimirObjetoSeleccionadodxComponentPrinterLink: TdxGridReportLink
      BuiltInReportLink = True
    end
  end
  inherited PopUp: TsnPopUp
    Left = 377
    Top = 24
  end
  inherited TDataSetOidObjSave: TsnTable
    Left = 464
    Top = 147
  end
  object HelpGrados: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'rh.GradoLegajo'
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
    Titulo = 'Grados Legajos'
    AnchoHelp = 600
    ActivarCache = False
    ShowBotonBuscar = False
    Left = 50
    Top = 28
  end
  object ValidadorGradoLegajo: TValidador
    Operacion = Operacion
    NickNameObjLog = 'rh.GradoLegajo'
    WhenRaiseException = teFound
    MensajeException = 'C'#243'digo de Grado duplicado'
    NroQuery = 0
    Cache = False
    Left = 136
    Top = 51
  end
end
