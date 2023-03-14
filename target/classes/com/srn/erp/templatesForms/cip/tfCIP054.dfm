inherited FConsMovVisCIP: TFConsMovVisCIP
  Left = 24
  Top = 51
  Width = 1109
  Height = 624
  Caption = 'Movimientos de Entrada y Salida Visitas'
  PixelsPerInch = 96
  TextHeight = 13
  object Panel1: TPanel [0]
    Left = 0
    Top = 0
    Width = 1093
    Height = 41
    Align = alTop
    BevelOuter = bvNone
    Color = clWindow
    TabOrder = 0
    object ImageSalir: TImage
      Tag = 7
      Left = 18
      Top = 5
      Width = 32
      Height = 32
      Cursor = crHandPoint
      Hint = 'Salir'
      ParentShowHint = False
      ShowHint = True
    end
    object snLabel1: TsnLabel
      Left = 80
      Top = 16
      Width = 76
      Height = 13
      Caption = 'Movimientos del'
    end
    object snLabel2: TsnLabel
      Left = 264
      Top = 16
      Width = 8
      Height = 13
      Caption = 'al'
    end
    object snDBEdit1: TsnDBEdit
      Left = 168
      Top = 12
      TabStop = False
      DataBinding.DataField = 'fec_desde'
      DataBinding.DataSource = DSInput
      Properties.ReadOnly = True
      TabOrder = 0
      ReadOnlyAlways = True
      Width = 81
    end
    object snDBEdit2: TsnDBEdit
      Left = 288
      Top = 12
      TabStop = False
      DataBinding.DataField = 'fec_hasta'
      DataBinding.DataSource = DSInput
      Properties.ReadOnly = True
      TabOrder = 1
      ReadOnlyAlways = True
      Width = 81
    end
  end
  object Panel2: TPanel [1]
    Left = 0
    Top = 578
    Width = 1093
    Height = 8
    Align = alBottom
    Color = clWindow
    TabOrder = 1
  end
  object Panel3: TPanel [2]
    Left = 0
    Top = 41
    Width = 1093
    Height = 537
    Align = alClient
    BevelOuter = bvNone
    BorderWidth = 5
    Color = clWindow
    TabOrder = 2
    object dxMovimientos: TdxDBGridSN
      Left = 5
      Top = 5
      Width = 1083
      Height = 527
      Align = alClient
      TabOrder = 0
      LookAndFeel.Kind = lfFlat
      CriteriosPintarCelda = <>
      object dxMovimientosDBTableView1: TcxGridDBTableView
        NavigatorButtons.ConfirmDelete = False
        DataController.Summary.DefaultGroupSummaryItems = <>
        DataController.Summary.FooterSummaryItems = <>
        DataController.Summary.SummaryGroups = <>
        OptionsBehavior.AlwaysShowEditor = True
        OptionsCustomize.ColumnFiltering = False
        OptionsData.Appending = True
        OptionsData.Deleting = False
        OptionsData.DeletingConfirmation = False
        OptionsSelection.InvertSelect = False
        OptionsView.GroupByBox = False
        object dxMovimientosDBTableView1codigo: TcxGridDBColumn
          Caption = 'Legajo'
          DataBinding.FieldName = 'codigo'
          PropertiesClassName = 'TcxButtonEditProperties'
          Properties.Buttons = <
            item
              Default = True
              Kind = bkEllipsis
            end>
          HeaderAlignmentHorz = taCenter
          Width = 217
        end
        object dxMovimientosDBTableView1nombre: TcxGridDBColumn
          Caption = 'Apellido y Nombre'
          DataBinding.FieldName = 'nombre'
          HeaderAlignmentHorz = taCenter
          Options.Focusing = False
          Width = 531
        end
      end
      object dxMovimientosDBBandedTableView1: TcxGridDBBandedTableView
        NavigatorButtons.ConfirmDelete = False
        DataController.DataSource = DSMovimientos
        DataController.Options = [dcoAssignGroupingValues, dcoAssignMasterDetailKeys, dcoSaveExpanding, dcoGroupsAlwaysExpanded]
        DataController.Summary.DefaultGroupSummaryItems = <>
        DataController.Summary.FooterSummaryItems = <>
        DataController.Summary.SummaryGroups = <>
        OptionsBehavior.AlwaysShowEditor = True
        OptionsBehavior.FocusCellOnTab = True
        OptionsBehavior.FocusFirstCellOnNewRecord = True
        OptionsBehavior.GoToNextCellOnEnter = True
        OptionsBehavior.FocusCellOnCycle = True
        OptionsCustomize.ColumnFiltering = False
        OptionsData.Deleting = False
        OptionsData.Inserting = False
        OptionsView.GroupByBox = False
        Bands = <
          item
          end>
        object dxMovimientosDBBandedTableView1legajo: TcxGridDBBandedColumn
          DataBinding.FieldName = 'legajo'
          Position.BandIndex = -1
          Position.ColIndex = -1
          Position.RowIndex = -1
        end
        object dxMovimientosDBBandedTableView1ape_y_nom: TcxGridDBBandedColumn
          DataBinding.FieldName = 'ape_y_nom'
          Position.BandIndex = -1
          Position.ColIndex = -1
          Position.RowIndex = -1
        end
        object dxMovimientosDBBandedTableView1puerta: TcxGridDBBandedColumn
          DataBinding.FieldName = 'puerta'
          Position.BandIndex = -1
          Position.ColIndex = -1
          Position.RowIndex = -1
        end
        object dxMovimientosDBBandedTableView1fecha: TcxGridDBBandedColumn
          DataBinding.FieldName = 'fecha'
          Position.BandIndex = -1
          Position.ColIndex = -1
          Position.RowIndex = -1
        end
        object dxMovimientosDBBandedTableView1hora: TcxGridDBBandedColumn
          DataBinding.FieldName = 'hora'
          Position.BandIndex = -1
          Position.ColIndex = -1
          Position.RowIndex = -1
        end
        object dxMovimientosDBBandedTableView1sentido: TcxGridDBBandedColumn
          DataBinding.FieldName = 'sentido'
          Position.BandIndex = -1
          Position.ColIndex = -1
          Position.RowIndex = -1
        end
      end
      object dxMovimientosDBTableView2: TcxGridDBTableView
        NavigatorButtons.ConfirmDelete = False
        DataController.DataSource = DSMovimientos
        DataController.Options = [dcoAssignGroupingValues, dcoAssignMasterDetailKeys, dcoSaveExpanding, dcoGroupsAlwaysExpanded]
        DataController.Summary.DefaultGroupSummaryItems = <>
        DataController.Summary.FooterSummaryItems = <>
        DataController.Summary.SummaryGroups = <>
        OptionsData.Editing = False
        OptionsData.Inserting = False
        object dxMovimientosDBTableView2legajo: TcxGridDBColumn
          Caption = 'Nro. Documento'
          DataBinding.FieldName = 'visita'
          HeaderAlignmentHorz = taCenter
          Width = 79
        end
        object dxMovimientosDBTableView2ape_y_nom: TcxGridDBColumn
          Caption = 'Apellido y Nombre'
          DataBinding.FieldName = 'ape_y_nom'
          HeaderAlignmentHorz = taCenter
          Width = 242
        end
        object dxMovimientosDBTableView2Column4: TcxGridDBColumn
          Caption = 'Tarjeta'
          DataBinding.FieldName = 'tarjeta'
          HeaderAlignmentHorz = taCenter
          Width = 95
        end
        object dxMovimientosDBTableView2puerta: TcxGridDBColumn
          Caption = 'Puerta'
          DataBinding.FieldName = 'puerta'
          HeaderAlignmentHorz = taCenter
          Width = 113
        end
        object dxMovimientosDBTableView2fecha: TcxGridDBColumn
          Caption = 'Fecha'
          DataBinding.FieldName = 'fecha'
          HeaderAlignmentHorz = taCenter
          SortIndex = 0
          SortOrder = soAscending
          Width = 77
        end
        object dxMovimientosDBTableView2hora: TcxGridDBColumn
          Caption = 'Hora'
          DataBinding.FieldName = 'hora'
          HeaderAlignmentHorz = taCenter
          SortIndex = 1
          SortOrder = soDescending
          Width = 71
        end
        object dxMovimientosDBTableView2Column2: TcxGridDBColumn
          Caption = 'Agrupador'
          DataBinding.FieldName = 'titulo'
          Visible = False
          GroupIndex = 0
          Options.Moving = False
          Options.ShowCaption = False
        end
        object dxMovimientosDBTableView2sentido: TcxGridDBColumn
          Caption = 'Sentido'
          DataBinding.FieldName = 'sentido'
          HeaderAlignmentHorz = taCenter
          Width = 63
        end
        object dxMovimientosDBTableView2Column1: TcxGridDBColumn
          Caption = 'De zona'
          DataBinding.FieldName = 'zona_origen'
          HeaderAlignmentHorz = taCenter
          Options.Editing = False
          Width = 113
        end
        object dxMovimientosDBTableView2Column3: TcxGridDBColumn
          Caption = 'A zona'
          DataBinding.FieldName = 'zona_destino'
          HeaderAlignmentHorz = taCenter
          Options.Editing = False
          Width = 119
        end
      end
      object dxMovimientosLevel1: TcxGridLevel
        GridView = dxMovimientosDBTableView2
      end
    end
  end
  inherited DriverABM: TDriverABM
    OperGrabarObjeto = 'SavePlanifrotasLeg'
    CargaDataSets = <
      item
        DataSet = TCamposTablasPlanif
        TableName = 'TCamposTablasPlanif'
      end
      item
        DataSet = TMovimientos
        TableName = 'TMovimientos'
      end>
    DataSetCab = TMovimientos
    Left = 224
    Top = 104
  end
  inherited Operacion: TOperacion
    Top = 104
  end
  inherited dxComponentPrinter: TdxComponentPrinter
    Top = 96
    inherited dxComponentPrinterLink1: TdxCustomContainerReportLink
      Component = Owner
      BuiltInReportLink = True
      HiddenComponents = {}
      ExcludedComponents = {}
      AggregatedReportLinks = {}
    end
  end
  inherited SaveDialog: TSaveDialog
    Top = 104
  end
  inherited DriverEvent: TDriverEvent
    OnInicializar = <
      item
        Source.Strings = (
          'begin'
          
            '  TValoresClasificador.loadFromAllData(getParamValue('#39'TValoresCl' +
            'asificador'#39'));'
          
            '  TVisitasAPlanif.loadFromAllData(getParamValue('#39'TVisitasAPlanif' +
            #39'));'
          '  TInput.loadFromAllData(getParamValue('#39'TInput'#39'));'
          '  varios.setImagen('#39'ImageSalir'#39',7);'
          '  TraerMovimientos();'
          'end.')
      end>
    OnFormFunction = <
      item
        Source.Strings = (
          'procedure TraerMovimientos();'
          'begin'
          '  operacion.InicioOperacion();'
          '  operacion.setOper('#39'TraerMovimVisCIP'#39');'
          
            '  operacion.AddAtribute('#39'fec_desde'#39', TInput.FieldName('#39'fec_desde' +
            #39').AsString);'
          
            '  operacion.AddAtribute('#39'fec_hasta'#39', TInput.FieldName('#39'fec_hasta' +
            #39').AsString);'
          '  if (TInput.FieldName('#39'oid_clasif_agrupador'#39').AsInteger>0)'
          
            '     then operacion.AddAtribute('#39'oid_clasif_agrupador'#39',TInput.Fi' +
            'eldName('#39'oid_clasif_agrupador'#39').AsString);'
          '  operacion.AddDataSet(TVisitasAPlanif.getDataSet());'
          '  operacion.AddDataSet(TValoresClasificador.getDataSet);'
          '  operacion.execute();'
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
      end>
    Top = 99
  end
  inherited ImprimirObjetoSeleccionado: TdxComponentPrinter
    inherited ImprimirObjetoSeleccionadodxComponentPrinterLink: TdxGridReportLink
      BuiltInReportLink = True
    end
  end
  object TValoresClasificador: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = False
    AttachMaxCount = 1
    AutoCalcFields = False
    FieldDefs = <
      item
        Name = 'oid_renglon'
        DataType = ftInteger
      end
      item
        Name = 'oid_clasificador'
        DataType = ftInteger
      end
      item
        Name = 'oid_valor_clasif'
        DataType = ftInteger
      end
      item
        Name = 'cod_valor_clasif'
        DataType = ftString
        Size = 50
      end
      item
        Name = 'desc_valor_clasif'
        DataType = ftString
        Size = 255
      end
      item
        Name = 'orden'
        DataType = ftInteger
      end>
    IndexFieldNames = 'oid_clasificador;orden'
    IndexDefs = <
      item
        Name = 'TValoresClasificadorIndex1'
        Fields = 'oid_clasificador;orden'
      end
      item
        Name = 'TValoresClasificadorIndex2'
        Fields = 'oid_clasificador;cod_valor_clasif'
        Options = [ixUnique]
      end>
    RecalcOnIndex = True
    RecalcOnFetch = False
    SortOptions = []
    PersistentBackup = False
    ProgressFlags = [mtpcLoad, mtpcSave, mtpcCopy]
    EnableVersioning = False
    VersioningMode = mtvmAllSinceCheckPoint
    FilterOptions = []
    Version = '4.08b'
    LanguageID = 0
    SortID = 0
    SubLanguageID = 1
    LocaleID = 1024
    MensajeValorDuplicadoIndice = 'Valor Duplicado'
    Left = 512
    Top = 111
    object TValoresClasificadoroid_renglon: TIntegerField
      FieldName = 'oid_renglon'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TValoresClasificadoroid_clasificador: TIntegerField
      FieldName = 'oid_clasificador'
    end
    object TValoresClasificadoroid_valor_clasif: TIntegerField
      FieldName = 'oid_valor_clasif'
    end
    object TValoresClasificadorcod_valor_clasif: TStringField
      FieldName = 'cod_valor_clasif'
      Size = 50
    end
    object TValoresClasificadordesc_valor_clasif: TStringField
      FieldName = 'desc_valor_clasif'
      Size = 255
    end
    object TValoresClasificadororden: TIntegerField
      AutoGenerateValue = arAutoInc
      FieldName = 'orden'
    end
  end
  object TVisitasAPlanif: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'oid_leg_a_planif'
        DataType = ftInteger
      end
      item
        Name = 'oid'
        DataType = ftInteger
      end
      item
        Name = 'oid_legajo'
        DataType = ftInteger
      end
      item
        Name = 'codigo'
        DataType = ftString
        Size = 50
      end
      item
        Name = 'nombre'
        DataType = ftString
        Size = 255
      end>
    IndexFieldNames = 'oid;orden'
    IndexDefs = <
      item
        Name = 'TLegajosAPlanifIndex1'
        Fields = 'oid;orden'
      end
      item
        Name = 'TLegajosAPlanifIndex2'
        Fields = 'codigo'
        Options = [ixUnique]
      end>
    RecalcOnIndex = True
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
    Left = 592
    Top = 113
    object TVisitasAPlanifoid_leg_a_planif: TIntegerField
      FieldName = 'oid_leg_a_planif'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TVisitasAPlanifoid: TIntegerField
      FieldName = 'oid'
    end
    object TVisitasAPlanifoid_legajo: TIntegerField
      FieldName = 'oid_legajo'
    end
    object TVisitasAPlanifcodigo: TStringField
      FieldName = 'codigo'
      Size = 50
    end
    object TVisitasAPlanifnombre: TStringField
      FieldName = 'nombre'
      Size = 255
    end
    object TVisitasAPlaniforden: TIntegerField
      AutoGenerateValue = arAutoInc
      FieldName = 'orden'
    end
    object TVisitasAPlanifoid_visita: TIntegerField
      FieldName = 'oid_visita'
    end
    object TVisitasAPlanifoid_vis_a_planif: TIntegerField
      FieldName = 'oid_vis_a_planif'
    end
  end
  object TInput: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'oid'
        DataType = ftInteger
      end
      item
        Name = 'fecha'
        DataType = ftDate
      end
      item
        Name = 'oid_clasif_agrupador'
        DataType = ftInteger
      end>
    IndexDefs = <>
    RecalcOnIndex = True
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
    MensajeValorDuplicadoIndice = 'Legajo ya ingresado'
    Left = 664
    Top = 112
    object TInputoid: TIntegerField
      FieldName = 'oid'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TInputoid_clasif_agrupador: TIntegerField
      FieldName = 'oid_clasif_agrupador'
    end
    object TInputfec_desde: TDateField
      FieldName = 'fec_desde'
    end
    object TInputfec_hasta: TDateField
      FieldName = 'fec_hasta'
    end
  end
  object TCamposTablasPlanif: TsnTable
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
    Left = 368
    Top = 385
    object TCamposTablasPlanifcampo: TStringField
      FieldName = 'campo'
      Size = 50
    end
    object TCamposTablasPlaniftipo: TStringField
      FieldName = 'tipo'
      Size = 50
    end
    object TCamposTablasPlaniflongitud: TIntegerField
      FieldName = 'longitud'
    end
    object TCamposTablasPlanifnombre: TStringField
      FieldName = 'nombre'
      Size = 50
    end
  end
  object TMovimientos: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'oid_mov'
        DataType = ftInteger
      end
      item
        Name = 'oid_legajo'
        DataType = ftInteger
      end
      item
        Name = 'legajo'
        DataType = ftString
        Size = 50
      end
      item
        Name = 'ape_y_nom'
        DataType = ftString
        Size = 100
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
    Left = 304
    Top = 265
    object TMovimientosoid_mov: TIntegerField
      FieldName = 'oid_mov'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TMovimientosoid_legajo: TIntegerField
      FieldName = 'oid_legajo'
    end
    object TMovimientoslegajo: TStringField
      FieldName = 'legajo'
      Size = 50
    end
    object TMovimientosape_y_nom: TStringField
      FieldName = 'ape_y_nom'
      Size = 100
    end
    object TMovimientosoid_puerta: TIntegerField
      FieldName = 'oid_puerta'
    end
    object TMovimientospuerta: TStringField
      FieldName = 'puerta'
      Size = 50
    end
    object TMovimientosfecha: TDateField
      FieldName = 'fecha'
    end
    object TMovimientoshora: TStringField
      FieldName = 'hora'
      Size = 8
    end
    object TMovimientossentido: TStringField
      FieldName = 'sentido'
      Size = 1
    end
    object TMovimientostitulo: TStringField
      FieldName = 'titulo'
      Size = 100
    end
    object TMovimientoszona_origen: TStringField
      FieldName = 'zona_origen'
      Size = 100
    end
    object TMovimientoszona_destino: TStringField
      FieldName = 'zona_destino'
      Size = 100
    end
    object TMovimientosoid_visita: TIntegerField
      FieldName = 'oid_visita'
    end
    object TMovimientosvisita: TStringField
      FieldName = 'visita'
      Size = 100
    end
    object TMovimientostarjeta: TStringField
      FieldName = 'tarjeta'
      Size = 50
    end
  end
  object Varios: TsnVarios
    Operacion = Operacion
    Left = 640
    Top = 185
  end
  object DSMovimientos: TDataSource
    DataSet = TMovimientos
    Left = 344
    Top = 265
  end
  object DSInput: TDataSource
    DataSet = TInput
    Left = 696
    Top = 113
  end
  object HelpRotas: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'cip.Rota'
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
    Titulo = 'Rotas'
    AnchoHelp = 600
    ActivarCache = False
    ShowBotonBuscar = False
    Left = 570
    Top = 359
  end
  object ValidadorRota: TValidador
    Operacion = Operacion
    NickNameObjLog = 'cip.Rota'
    MensajeException = 'C'#243'digo de Rota Inexistente'
    NroQuery = 0
    Cache = True
    Left = 606
    Top = 359
  end
end
