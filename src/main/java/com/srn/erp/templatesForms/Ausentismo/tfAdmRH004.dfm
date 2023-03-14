inherited FCertificacionProveedor: TFCertificacionProveedor
  Left = 324
  Top = 121
  Width = 952
  Height = 864
  Caption = 'Grupo Personas'
  PixelsPerInch = 96
  TextHeight = 13
  inherited PForm: TPanel
    Width = 936
    Height = 826
    inherited PPie: TPanel
      Top = 805
      Width = 936
      inherited StatusBarABM: TStatusBar
        Left = 831
      end
      inherited StatusBar2: TStatusBar
        Width = 831
      end
    end
    inherited PMenu: TPanel
      Width = 936
      inherited ImagenEliminar: TImagenEstado
        DataField = 'activo'
        DataSource = DSGrupoGral
        ValorEstadoVisible = 'True'
      end
      inherited ImagenRehabilitar: TImagenEstado
        DataField = 'activo'
        DataSource = DSGrupoGral
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
        Left = 895
      end
      inherited PanelEstadoON: TPanelEstado
        Left = 677
        Top = 4
        DataField = 'activo'
        DataSource = DSGrupoGral
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
      Width = 936
    end
    inherited PCabecera: TPanel
      Width = 936
      Height = 61
      object Label1: TLabel
        Left = 48
        Top = 24
        Width = 37
        Height = 13
        Caption = 'Nombre'
      end
      object DBENOMBRE: TsnDBEdit
        Left = 108
        Top = 20
        DataBinding.DataField = 'nombre'
        DataBinding.DataSource = DSGrupoGral
        Properties.CharCase = ecUpperCase
        Properties.MaxLength = 15
        Style.BorderColor = clWindowFrame
        Style.Shadow = False
        TabOrder = 0
        Width = 397
      end
    end
    inherited PCuerpo: TPanel
      Top = 401
      Width = 936
      Height = 404
      object TPageControlSN
        Left = 0
        Top = 0
        Width = 936
        Height = 404
        ActivePage = TabSheet1
        Align = alClient
        TabOrder = 0
        object TabSheet1: TTabSheet
          Caption = 'TabSheet1'
          object dxDBGridSN6: TdxDBGridSN
            Left = 0
            Top = 0
            Width = 928
            Height = 376
            Align = alClient
            TabOrder = 0
            LookAndFeel.Kind = lfFlat
            CriteriosPintarCelda = <>
            object cxGridDBTableView1: TcxGridDBTableView
              NavigatorButtons.ConfirmDelete = False
              DataController.DataSource = DSEmpresa
              DataController.Summary.DefaultGroupSummaryItems = <>
              DataController.Summary.FooterSummaryItems = <>
              DataController.Summary.SummaryGroups = <>
              OptionsBehavior.FocusFirstCellOnNewRecord = True
              OptionsBehavior.GoToNextCellOnEnter = True
              OptionsCustomize.ColumnFiltering = False
              OptionsCustomize.ColumnSorting = False
              OptionsData.Appending = True
              OptionsData.Deleting = False
              OptionsSelection.InvertSelect = False
              OptionsView.GroupByBox = False
              object cxGridDBTableView1Column1: TcxGridDBColumn
                Caption = 'Codigo'
                DataBinding.FieldName = 'codigo'
                Width = 192
              end
              object cxGridDBTableView1Column2: TcxGridDBColumn
                Caption = 'Empresa'
                DataBinding.FieldName = 'descripccion'
                Width = 497
              end
              object cxGridDBTableView1Column3: TcxGridDBColumn
                Caption = 'Seleccionado'
                DataBinding.FieldName = 'seleccionado'
                Width = 85
              end
            end
            object cxGridLevel1: TcxGridLevel
              GridView = cxGridDBTableView1
            end
          end
        end
        object TabSheet2: TTabSheet
          Caption = 'TabSheet2'
          ImageIndex = 1
          object dxDBGridSN1: TdxDBGridSN
            Left = 0
            Top = 0
            Width = 928
            Height = 376
            Align = alClient
            TabOrder = 0
            LookAndFeel.Kind = lfFlat
            CriteriosPintarCelda = <>
            object cxGridDBTableView2: TcxGridDBTableView
              NavigatorButtons.ConfirmDelete = False
              DataController.DataSource = DSEstado
              DataController.Summary.DefaultGroupSummaryItems = <>
              DataController.Summary.FooterSummaryItems = <>
              DataController.Summary.SummaryGroups = <>
              OptionsBehavior.FocusFirstCellOnNewRecord = True
              OptionsBehavior.GoToNextCellOnEnter = True
              OptionsCustomize.ColumnFiltering = False
              OptionsCustomize.ColumnSorting = False
              OptionsData.Appending = True
              OptionsData.Deleting = False
              OptionsSelection.InvertSelect = False
              OptionsView.GroupByBox = False
              object cxGridDBTableView2Column1: TcxGridDBColumn
                Caption = 'Estado'
                DataBinding.FieldName = 'estado'
                Width = 243
              end
              object cxGridDBTableView2Column2: TcxGridDBColumn
                Caption = 'Seleccionado'
                DataBinding.FieldName = 'seleccionado'
                Width = 133
              end
            end
            object cxGridLevel2: TcxGridLevel
              GridView = cxGridDBTableView2
            end
          end
        end
        object TabSheet3: TTabSheet
          Caption = 'TabSheet3'
          ImageIndex = 2
          object dxDBGridSN2: TdxDBGridSN
            Left = 0
            Top = 0
            Width = 928
            Height = 376
            Align = alClient
            TabOrder = 0
            LookAndFeel.Kind = lfFlat
            CriteriosPintarCelda = <>
            object cxGridDBTableView3: TcxGridDBTableView
              NavigatorButtons.ConfirmDelete = False
              DataController.DataSource = DSSector
              DataController.Summary.DefaultGroupSummaryItems = <>
              DataController.Summary.FooterSummaryItems = <>
              DataController.Summary.SummaryGroups = <>
              OptionsBehavior.FocusFirstCellOnNewRecord = True
              OptionsBehavior.GoToNextCellOnEnter = True
              OptionsCustomize.ColumnFiltering = False
              OptionsCustomize.ColumnSorting = False
              OptionsData.Appending = True
              OptionsData.Deleting = False
              OptionsSelection.InvertSelect = False
              OptionsView.GroupByBox = False
              object cxGridDBColumn4: TcxGridDBColumn
                Caption = 'Codigo'
                DataBinding.FieldName = 'codigo'
                Width = 192
              end
              object cxGridDBColumn5: TcxGridDBColumn
                Caption = 'Sector'
                DataBinding.FieldName = 'descripcion'
                Width = 497
              end
              object cxGridDBColumn6: TcxGridDBColumn
                Caption = 'Seleccionado'
                DataBinding.FieldName = 'seleccionado'
                Width = 85
              end
            end
            object cxGridLevel3: TcxGridLevel
              GridView = cxGridDBTableView3
            end
          end
        end
        object TabSheet4: TTabSheet
          Caption = 'TabSheet4'
          ImageIndex = 3
          object dxDBGridSN3: TdxDBGridSN
            Left = 0
            Top = 0
            Width = 928
            Height = 376
            Align = alClient
            TabOrder = 0
            LookAndFeel.Kind = lfFlat
            CriteriosPintarCelda = <>
            object cxGridDBTableView4: TcxGridDBTableView
              NavigatorButtons.ConfirmDelete = False
              DataController.DataSource = DSPuesto
              DataController.Summary.DefaultGroupSummaryItems = <>
              DataController.Summary.FooterSummaryItems = <>
              DataController.Summary.SummaryGroups = <>
              OptionsBehavior.FocusFirstCellOnNewRecord = True
              OptionsBehavior.GoToNextCellOnEnter = True
              OptionsCustomize.ColumnFiltering = False
              OptionsCustomize.ColumnSorting = False
              OptionsData.Appending = True
              OptionsData.Deleting = False
              OptionsSelection.InvertSelect = False
              OptionsView.GroupByBox = False
              object cxGridDBColumn7: TcxGridDBColumn
                Caption = 'Codigo'
                DataBinding.FieldName = 'codigo'
                Width = 192
              end
              object cxGridDBColumn8: TcxGridDBColumn
                Caption = 'Puesto'
                DataBinding.FieldName = 'descripcion'
                Width = 497
              end
              object cxGridDBColumn9: TcxGridDBColumn
                Caption = 'Seleccionado'
                DataBinding.FieldName = 'seleccionado'
                Width = 85
              end
            end
            object cxGridLevel4: TcxGridLevel
              GridView = cxGridDBTableView4
            end
          end
        end
        object TabSheet5: TTabSheet
          Caption = 'TabSheet5'
          ImageIndex = 4
          object dxDBGridSN4: TdxDBGridSN
            Left = 0
            Top = 0
            Width = 928
            Height = 376
            Align = alClient
            TabOrder = 0
            LookAndFeel.Kind = lfFlat
            CriteriosPintarCelda = <>
            object cxGridDBTableView5: TcxGridDBTableView
              NavigatorButtons.ConfirmDelete = False
              DataController.DataSource = DSTareaDesemp
              DataController.Summary.DefaultGroupSummaryItems = <>
              DataController.Summary.FooterSummaryItems = <>
              DataController.Summary.SummaryGroups = <>
              OptionsBehavior.FocusFirstCellOnNewRecord = True
              OptionsBehavior.GoToNextCellOnEnter = True
              OptionsCustomize.ColumnFiltering = False
              OptionsCustomize.ColumnSorting = False
              OptionsData.Appending = True
              OptionsData.Deleting = False
              OptionsSelection.InvertSelect = False
              OptionsView.GroupByBox = False
              object cxGridDBColumn10: TcxGridDBColumn
                Caption = 'Codigo'
                DataBinding.FieldName = 'codigo'
                Width = 192
              end
              object cxGridDBColumn11: TcxGridDBColumn
                Caption = 'Tarea Desempe'#241'ada'
                DataBinding.FieldName = 'descripcion'
                Width = 497
              end
              object cxGridDBColumn12: TcxGridDBColumn
                Caption = 'Seleccionado'
                DataBinding.FieldName = 'seleccionado'
                Width = 85
              end
            end
            object cxGridLevel5: TcxGridLevel
              GridView = cxGridDBTableView5
            end
          end
        end
        object TabSheet6: TTabSheet
          Caption = 'TabSheet6'
          ImageIndex = 5
          object dxDBGridSN5: TdxDBGridSN
            Left = 0
            Top = 0
            Width = 928
            Height = 376
            Align = alClient
            TabOrder = 0
            LookAndFeel.Kind = lfFlat
            CriteriosPintarCelda = <>
            object cxGridDBTableView6: TcxGridDBTableView
              NavigatorButtons.ConfirmDelete = False
              DataController.DataSource = DSSindicato
              DataController.Summary.DefaultGroupSummaryItems = <>
              DataController.Summary.FooterSummaryItems = <>
              DataController.Summary.SummaryGroups = <>
              OptionsBehavior.FocusFirstCellOnNewRecord = True
              OptionsBehavior.GoToNextCellOnEnter = True
              OptionsCustomize.ColumnFiltering = False
              OptionsCustomize.ColumnSorting = False
              OptionsData.Appending = True
              OptionsData.Deleting = False
              OptionsSelection.InvertSelect = False
              OptionsView.GroupByBox = False
              object cxGridDBColumn13: TcxGridDBColumn
                Caption = 'Codigo'
                DataBinding.FieldName = 'codigo'
                Width = 192
              end
              object cxGridDBColumn14: TcxGridDBColumn
                Caption = 'Sindicato'
                DataBinding.FieldName = 'descripcion'
                Width = 497
              end
              object cxGridDBColumn15: TcxGridDBColumn
                Caption = 'Seleccionado'
                DataBinding.FieldName = 'seleccionado'
                Width = 85
              end
            end
            object cxGridLevel6: TcxGridLevel
              GridView = cxGridDBTableView6
            end
          end
        end
      end
    end
    object Panel1: TPanel
      Left = 0
      Top = 113
      Width = 936
      Height = 288
      Align = alTop
      BevelOuter = bvNone
      Color = clWindow
      ParentBackground = False
      TabOrder = 5
      object dxDBCotizacionesFecha: TdxDBGridSN
        Left = 0
        Top = 0
        Width = 936
        Height = 288
        Align = alClient
        TabOrder = 0
        LookAndFeel.Kind = lfFlat
        CriteriosPintarCelda = <>
        object dxDBCotizacionesFechaDBTableView1: TcxGridDBTableView
          NavigatorButtons.ConfirmDelete = False
          DataController.DataSource = DSGrupoGralDesc
          DataController.Summary.DefaultGroupSummaryItems = <>
          DataController.Summary.FooterSummaryItems = <>
          DataController.Summary.SummaryGroups = <>
          OptionsBehavior.FocusFirstCellOnNewRecord = True
          OptionsBehavior.GoToNextCellOnEnter = True
          OptionsCustomize.ColumnFiltering = False
          OptionsCustomize.ColumnSorting = False
          OptionsData.Appending = True
          OptionsData.Deleting = False
          OptionsSelection.InvertSelect = False
          OptionsView.GroupByBox = False
          object dxDBCotizacionesFechaDBTableView1Column1: TcxGridDBColumn
            Caption = 'Descripcion'
            DataBinding.FieldName = 'descripcion'
            Width = 584
          end
        end
        object dxDBCotizacionesFechaLevel1: TcxGridLevel
          GridView = dxDBCotizacionesFechaDBTableView1
        end
      end
    end
  end
  inherited DriverABM: TDriverABM
    OperTraerObjeto = 'TraerGrupoRRHHGeneral'
    OperGrabarObjeto = 'SaveGrupoRRHHGeneral'
    CargaDataSets = <
      item
        DataSet = TGrupoGral
        TableName = 'TGrupoGral'
      end
      item
        DataSet = TGrupoGralDesc
        TableName = 'TGrupoGralDesc'
      end
      item
        DataSet = TEmpresa
        TableName = 'TEmpresa'
      end
      item
        DataSet = TEstado
        TableName = 'TEstado'
      end
      item
        DataSet = TSector
        TableName = 'TSector'
      end
      item
        DataSet = TPuesto
        TableName = 'TPuesto'
      end
      item
        DataSet = TTareaDesemp
        TableName = 'TTareaDesemp'
      end
      item
        DataSet = TSindicato
        TableName = 'TSindicato'
      end>
    BajaLogica = <
      item
        DataSet = TGrupoGral
        ValorBaja = 'false'
        ValorRehabilitacion = 'true'
        TipoBajaRegistro = tblCurrentRecord
        FieldName = 'activo'
      end>
    OperHabilitadas = [toOperNuevo, toOperModificar, toOperEliminar, toOperBuscar, toOperNavegacion, toOperRehabilitar]
    DataSetCab = TGrupoGral
    DataSetDet1 = TGrupoGralDesc
    Left = 496
    Top = 32
  end
  inherited Operacion: TOperacion
    Left = 536
    Top = 32
  end
  object TGrupoGral: TsnTable [3]
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'oid_grupo_gral'
        DataType = ftInteger
      end
      item
        Name = 'tipo'
        DataType = ftString
        Size = 50
      end
      item
        Name = 'nombre'
        DataType = ftString
        Size = 100
      end
      item
        Name = 'activo'
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
    Left = 528
    Top = 75
    object TGrupoGraloid_grupo_gral: TIntegerField
      FieldName = 'oid_grupo_gral'
    end
    object TGrupoGraltipo: TStringField
      FieldName = 'tipo'
      Size = 50
    end
    object TGrupoGralnombre: TStringField
      FieldName = 'nombre'
      Size = 100
    end
    object TGrupoGralactivo: TBooleanField
      DefaultExpression = '1'
      FieldName = 'activo'
    end
  end
  object DSGrupoGral: TDataSource [4]
    DataSet = TGrupoGral
    Left = 568
    Top = 75
  end
  inherited TOidObjSave: TsnTable
    Left = 824
    Top = 48
  end
  inherited TOpcHabPrograma: TsnTable
    Left = 872
    Top = 48
  end
  inherited dxComponentPrinter: TdxComponentPrinter
    Left = 816
    Top = 8
    inherited dxComponentPrinterLink1: TdxCustomContainerReportLink
      Component = Owner
      BuiltInReportLink = True
      HiddenComponents = {}
      ExcludedComponents = {}
      AggregatedReportLinks = {}
    end
  end
  inherited SaveDialog: TSaveDialog
    Left = 904
    Top = 56
  end
  inherited DriverEvent: TDriverEvent
    OnValidate = <
      item
        TableName = 'TGrupoGral'
        FieldName = 'nombre'
        Source.Strings = (
          'begin'
          '  ValidadorGruposRRHH.Value := Sender.AsString;'
          '  ValidadorGruposRRHH.Validar;'
          'end.')
      end>
    OnNuevoRegistro = <
      item
        TableName = 'TGrupoGral'
        Source.Strings = (
          'begin'
          '    Operacion.inicioOperacion();'
          '    Operacion.setOper('#39'TraerGrupoRRHHGeneral'#39');'
          
            '    Operacion.AddAtribute('#39'oid_grupo_gral'#39',TGrupoGral.FieldName(' +
            #39'oid_grupo_gral'#39').AsString);'
          '    Operacion.execute();'
          ''
          '   TEmpresa.AppendRecords(TEmpresaAux.getDataSet());'
          ''
          'end.')
      end>
    Left = 712
    Top = 83
  end
  inherited SaveArchivo: TSaveDialog
    Left = 904
    Top = 80
  end
  inherited ImprimirObjetoSeleccionado: TdxComponentPrinter
    Left = 856
    Top = 8
    inherited ImprimirObjetoSeleccionadodxComponentPrinterLink: TdxGridReportLink
      BuiltInReportLink = True
    end
  end
  inherited TTempVarForm: TsnTable
    Left = 792
    Top = 80
  end
  inherited PopUp: TsnPopUp
    Grupos = <
      item
        IconoIden = 0
      end>
    Left = 673
    Top = 80
  end
  inherited ImageListGruposPopUp: TImageList
    Left = 792
    Top = 51
  end
  inherited ImageListItemsPopUp: TImageList
    Left = 776
    Top = 11
  end
  inherited TPathHelp: TsnTable
    Left = 872
    Top = 85
  end
  inherited TDataSetOidObjSave: TsnTable
    Left = 832
    Top = 83
  end
  object HelpGrupos: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'admRRHH.GrupoRRHHGeneral'
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
    Titulo = 'GruposGrals'
    AnchoHelp = 600
    ActivarCache = False
    ShowBotonBuscar = False
    Left = 10
    Top = 28
  end
  object ValidadorGruposRRHH: TValidador
    Operacion = Operacion
    NickNameObjLog = 'admRRHH.GrupoRRHHGeneral'
    WhenRaiseException = teFound
    MensajeException = 'C'#243'digo de Certificaci'#243'n Existente'
    NroQuery = 0
    Cache = False
    Left = 56
    Top = 27
  end
  object TGrupoGralDesc: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'oid_gru_gral_desc'
        DataType = ftInteger
      end
      item
        Name = 'oid_grupo_gral'
        DataType = ftInteger
      end
      item
        Name = 'descripcion'
        DataType = ftString
        Size = 100
      end
      item
        Name = 'activo'
        DataType = ftBoolean
      end>
    IndexDefs = <>
    RecalcOnFetch = False
    SortOptions = []
    PersistentBackup = False
    ProgressFlags = [mtpcLoad, mtpcSave, mtpcCopy]
    VersioningMode = mtvmAllSinceCheckPoint
    FilterOptions = []
    MasterSource = DSGrupoGral
    Version = '4.08b'
    LanguageID = 0
    SortID = 0
    SubLanguageID = 1
    LocaleID = 1024
    MensajeValorDuplicadoIndice = 'Valor Duplicado'
    Left = 688
    Top = 277
    object TGrupoGralDescoid_gru_gral_desc: TIntegerField
      FieldName = 'oid_gru_gral_desc'
    end
    object TGrupoGralDescoid_grupo_gral: TIntegerField
      FieldName = 'oid_grupo_gral'
    end
    object TGrupoGralDescdescripcion: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
    object TGrupoGralDescactivo: TBooleanField
      FieldName = 'activo'
    end
  end
  object DSGrupoGralDesc: TDataSource
    DataSet = TGrupoGralDesc
    Left = 720
    Top = 275
  end
  object TEmpresa: TsnTable
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
    MasterSource = DSGrupoGralDesc
    Version = '4.08b'
    LanguageID = 0
    SortID = 0
    SubLanguageID = 1
    LocaleID = 1024
    MensajeValorDuplicadoIndice = 'Valor Duplicado'
    Left = 24
    Top = 493
    object TEmpresaoid: TIntegerField
      FieldName = 'oid'
    end
    object TEmpresaoid_gru_gral_desc: TIntegerField
      FieldName = 'oid_gru_gral_desc'
    end
    object TEmpresacodigo: TStringField
      FieldName = 'codigo'
      Size = 100
    end
    object TEmpresadescripccion: TStringField
      FieldName = 'descripccion'
      Size = 200
    end
    object TEmpresaseleccionado: TBooleanField
      FieldName = 'seleccionado'
    end
  end
  object DSEmpresa: TDataSource
    DataSet = TEmpresa
    Left = 24
    Top = 531
  end
  object DSEstado: TDataSource
    DataSet = TEstado
    Left = 64
    Top = 531
  end
  object DSSector: TDataSource
    DataSet = TSector
    Left = 104
    Top = 531
  end
  object DSPuesto: TDataSource
    DataSet = TPuesto
    Left = 144
    Top = 531
  end
  object DSTareaDesemp: TDataSource
    DataSet = TTareaDesemp
    Left = 184
    Top = 531
  end
  object DSSindicato: TDataSource
    DataSet = TSindicato
    Left = 224
    Top = 531
  end
  object TEstado: TsnTable
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
    MasterSource = DSGrupoGralDesc
    Version = '4.08b'
    LanguageID = 0
    SortID = 0
    SubLanguageID = 1
    LocaleID = 1024
    MensajeValorDuplicadoIndice = 'Valor Duplicado'
    Left = 64
    Top = 493
    object IntegerField1: TIntegerField
      FieldName = 'oid'
    end
    object TEstadooid_gru_gral_desc: TIntegerField
      FieldName = 'oid_gru_gral_desc'
    end
    object TEstadoestado: TStringField
      FieldName = 'estado'
      Size = 100
    end
    object BooleanField1: TBooleanField
      FieldName = 'seleccionado'
    end
  end
  object TSector: TsnTable
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
    MasterSource = DSGrupoGralDesc
    Version = '4.08b'
    LanguageID = 0
    SortID = 0
    SubLanguageID = 1
    LocaleID = 1024
    MensajeValorDuplicadoIndice = 'Valor Duplicado'
    Left = 104
    Top = 493
    object IntegerField3: TIntegerField
      FieldName = 'oid'
    end
    object TSectoroid_gru_gral_desc: TIntegerField
      FieldName = 'oid_gru_gral_desc'
    end
    object TSectorcodigo: TStringField
      FieldName = 'codigo'
      Size = 100
    end
    object TSectordescripcion: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
    object BooleanField2: TBooleanField
      FieldName = 'seleccionado'
    end
  end
  object TPuesto: TsnTable
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
    MasterSource = DSGrupoGralDesc
    Version = '4.08b'
    LanguageID = 0
    SortID = 0
    SubLanguageID = 1
    LocaleID = 1024
    MensajeValorDuplicadoIndice = 'Valor Duplicado'
    Left = 144
    Top = 493
    object IntegerField5: TIntegerField
      FieldName = 'oid'
    end
    object TPuestooid_gru_gral_desc: TIntegerField
      FieldName = 'oid_gru_gral_desc'
    end
    object TPuestocodigo: TStringField
      FieldName = 'codigo'
      Size = 100
    end
    object TPuestodescripcion: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
    object BooleanField3: TBooleanField
      FieldName = 'seleccionado'
    end
  end
  object TTareaDesemp: TsnTable
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
    MasterSource = DSGrupoGralDesc
    Version = '4.08b'
    LanguageID = 0
    SortID = 0
    SubLanguageID = 1
    LocaleID = 1024
    MensajeValorDuplicadoIndice = 'Valor Duplicado'
    Left = 184
    Top = 496
    object IntegerField7: TIntegerField
      FieldName = 'oid'
    end
    object TTareaDesempoid_gru_gral_desc: TIntegerField
      FieldName = 'oid_gru_gral_desc'
    end
    object TTareaDesempcodigo: TStringField
      FieldName = 'codigo'
      Size = 100
    end
    object TTareaDesempdescripcion: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
    object BooleanField4: TBooleanField
      FieldName = 'seleccionado'
    end
  end
  object TSindicato: TsnTable
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
    MasterSource = DSGrupoGralDesc
    Version = '4.08b'
    LanguageID = 0
    SortID = 0
    SubLanguageID = 1
    LocaleID = 1024
    MensajeValorDuplicadoIndice = 'Valor Duplicado'
    Left = 224
    Top = 493
    object IntegerField9: TIntegerField
      FieldName = 'oid'
    end
    object TSindicatooid_gru_gral_desc: TIntegerField
      FieldName = 'oid_gru_gral_desc'
    end
    object TSindicatocodigo: TStringField
      FieldName = 'codigo'
      Size = 100
    end
    object TSindicatodescripcion: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
    object BooleanField5: TBooleanField
      FieldName = 'seleccionado'
    end
  end
  object DSEmpresaAux: TDataSource
    DataSet = TEmpresaAux
    Left = 24
    Top = 619
  end
  object DSEstadoAux: TDataSource
    DataSet = TEstadoAux
    Left = 64
    Top = 619
  end
  object DSSectorAux: TDataSource
    DataSet = TSectorAux
    Left = 104
    Top = 619
  end
  object DSPuestoAux: TDataSource
    DataSet = TPuestoAux
    Left = 144
    Top = 619
  end
  object DSTareaDesempAux: TDataSource
    DataSet = TTareaDesempAux
    Left = 184
    Top = 619
  end
  object DSSindicatoAux: TDataSource
    DataSet = TSindicatoAux
    Left = 224
    Top = 619
  end
  object TEmpresaAux: TsnTable
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
    Left = 24
    Top = 581
    object IntegerField2: TIntegerField
      FieldName = 'oid'
    end
    object IntegerField4: TIntegerField
      FieldName = 'oid_gru_gral_desc'
    end
    object StringField1: TStringField
      FieldName = 'codigo'
      Size = 100
    end
    object StringField2: TStringField
      FieldName = 'descripccion'
      Size = 200
    end
    object BooleanField6: TBooleanField
      FieldName = 'seleccionado'
    end
  end
  object TEstadoAux: TsnTable
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
    Top = 581
    object IntegerField6: TIntegerField
      FieldName = 'oid'
    end
    object IntegerField8: TIntegerField
      FieldName = 'oid_gru_gral_desc'
    end
    object TEstadoAuxestado: TStringField
      FieldName = 'estado'
      Size = 100
    end
    object BooleanField7: TBooleanField
      FieldName = 'seleccionado'
    end
  end
  object TSectorAux: TsnTable
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
    Left = 104
    Top = 581
    object IntegerField10: TIntegerField
      FieldName = 'oid'
    end
    object IntegerField11: TIntegerField
      FieldName = 'oid_gru_gral_desc'
    end
    object StringField5: TStringField
      FieldName = 'codigo'
      Size = 100
    end
    object StringField6: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
    object BooleanField8: TBooleanField
      FieldName = 'seleccionado'
    end
  end
  object TPuestoAux: TsnTable
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
    Left = 144
    Top = 581
    object IntegerField12: TIntegerField
      FieldName = 'oid'
    end
    object IntegerField13: TIntegerField
      FieldName = 'oid_gru_gral_desc'
    end
    object StringField7: TStringField
      FieldName = 'codigo'
      Size = 100
    end
    object StringField8: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
    object BooleanField9: TBooleanField
      FieldName = 'seleccionado'
    end
  end
  object TTareaDesempAux: TsnTable
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
    Left = 184
    Top = 584
    object IntegerField14: TIntegerField
      FieldName = 'oid'
    end
    object IntegerField15: TIntegerField
      FieldName = 'oid_gru_gral_desc'
    end
    object StringField9: TStringField
      FieldName = 'codigo'
      Size = 100
    end
    object StringField10: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
    object BooleanField10: TBooleanField
      FieldName = 'seleccionado'
    end
  end
  object TSindicatoAux: TsnTable
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
    Left = 224
    Top = 581
    object IntegerField16: TIntegerField
      FieldName = 'oid'
    end
    object IntegerField17: TIntegerField
      FieldName = 'oid_gru_gral_desc'
    end
    object StringField11: TStringField
      FieldName = 'codigo'
      Size = 100
    end
    object StringField12: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
    object BooleanField11: TBooleanField
      FieldName = 'seleccionado'
    end
  end
end
