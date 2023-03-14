inherited FConsAusentismo: TFConsAusentismo
  Left = 231
  Top = 85
  Width = 1026
  Height = 852
  Caption = 'Consulta de Ausentismo'
  PixelsPerInch = 96
  TextHeight = 13
  object Panel1: TPanel [0]
    Left = 0
    Top = 0
    Width = 1010
    Height = 305
    Align = alTop
    Color = clWindow
    TabOrder = 0
    object Label1: TLabel
      Left = 20
      Top = 24
      Width = 41
      Height = 13
      Caption = 'Empresa'
    end
    object Label3: TLabel
      Left = 344
      Top = 58
      Width = 64
      Height = 13
      Caption = 'Fecha Hasta:'
    end
    object Label2: TLabel
      Left = 16
      Top = 58
      Width = 67
      Height = 13
      Caption = 'Fecha Desde:'
    end
    object Label4: TLabel
      Left = 20
      Top = 88
      Width = 31
      Height = 13
      Caption = 'Sector'
    end
    object Label5: TLabel
      Left = 319
      Top = 88
      Width = 28
      Height = 13
      Caption = 'Turno'
    end
    object Label6: TLabel
      Left = 626
      Top = 84
      Width = 68
      Height = 13
      Caption = 'Tipo Ausencia'
    end
    object srnDBButtonEdit1: TsrnDBButtonEdit
      Left = 71
      Top = 20
      DataBinding.DataField = 'empresa'
      DataBinding.DataSource = DSInput
      Properties.Buttons = <
        item
          Default = True
          Kind = bkEllipsis
        end>
      Properties.ClickKey = 112
      TabOrder = 0
      Help = HelpEmpresas
      Width = 170
    end
    object snDBEdit1: TsnDBEdit
      Left = 238
      Top = 20
      TabStop = False
      DataBinding.DataField = 'nombre'
      DataBinding.DataSource = DSInput
      Properties.ReadOnly = True
      TabOrder = 1
      Width = 451
    end
    object BotonBuscar: TsnButton
      Left = 789
      Top = 19
      Width = 84
      Height = 46
      Caption = 'Buscar'
      TabOrder = 2
      LookAndFeel.Kind = lfOffice11
    end
    object snDBCheckEdit1: TsnDBCheckEdit
      Left = 648
      Top = 54
      Caption = 'Hoy'
      DataBinding.DataField = 'hoy'
      DataBinding.DataSource = DSInput
      TabOrder = 3
      Width = 57
    end
    object snDBDateEdit2: TsnDBDateEdit
      Left = 440
      Top = 54
      DataBinding.DataField = 'fec_hasta'
      DataBinding.DataSource = DSInput
      TabOrder = 4
      ReadOnlyAlways = False
      Width = 157
    end
    object snDBDateEdit1: TsnDBDateEdit
      Left = 120
      Top = 54
      DataBinding.DataField = 'fec_desde'
      DataBinding.DataSource = DSInput
      TabOrder = 5
      ReadOnlyAlways = False
      Width = 147
    end
    object dxDBGridSN1: TdxDBGridSN
      Left = 56
      Top = 88
      Width = 257
      Height = 193
      TabOrder = 6
      LookAndFeel.Kind = lfFlat
      CriteriosPintarCelda = <>
      object cxGridDBTableView1: TcxGridDBTableView
        NavigatorButtons.ConfirmDelete = False
        DataController.DataSource = DSTSectores
        DataController.Summary.DefaultGroupSummaryItems = <>
        DataController.Summary.FooterSummaryItems = <>
        DataController.Summary.SummaryGroups = <>
        OptionsBehavior.FocusFirstCellOnNewRecord = True
        OptionsBehavior.GoToNextCellOnEnter = True
        OptionsCustomize.ColumnFiltering = False
        OptionsData.Appending = True
        OptionsData.Deleting = False
        OptionsSelection.InvertSelect = False
        OptionsView.GroupByBox = False
        object cxGridDBTableView1Column1: TcxGridDBColumn
          Caption = 'Sector'
          DataBinding.FieldName = 'sector'
          Options.Editing = False
          Width = 176
        end
        object cxGridDBTableView1Column2: TcxGridDBColumn
          Caption = 'Seleccion'
          DataBinding.FieldName = 'seleccionado'
          Width = 58
        end
      end
      object cxGridLevel1: TcxGridLevel
        GridView = cxGridDBTableView1
      end
    end
    object dxDBGridSN2: TdxDBGridSN
      Left = 351
      Top = 85
      Width = 265
      Height = 193
      TabOrder = 7
      LookAndFeel.Kind = lfFlat
      CriteriosPintarCelda = <>
      object cxGridDBTableView2: TcxGridDBTableView
        NavigatorButtons.ConfirmDelete = False
        DataController.DataSource = DSTTurnos
        DataController.Summary.DefaultGroupSummaryItems = <>
        DataController.Summary.FooterSummaryItems = <>
        DataController.Summary.SummaryGroups = <>
        OptionsBehavior.FocusFirstCellOnNewRecord = True
        OptionsBehavior.GoToNextCellOnEnter = True
        OptionsCustomize.ColumnFiltering = False
        OptionsData.Appending = True
        OptionsData.Deleting = False
        OptionsSelection.InvertSelect = False
        OptionsView.GroupByBox = False
        object cxGridDBTableView2Column1: TcxGridDBColumn
          Caption = 'Turno'
          DataBinding.FieldName = 'turno'
          Options.Editing = False
          Width = 194
        end
        object cxGridDBTableView2Column2: TcxGridDBColumn
          Caption = 'Seleccion'
          DataBinding.FieldName = 'seleccionado'
          Width = 57
        end
      end
      object cxGridLevel2: TcxGridLevel
        GridView = cxGridDBTableView2
      end
    end
    object dxDBGridSN3: TdxDBGridSN
      Left = 702
      Top = 82
      Width = 289
      Height = 193
      TabOrder = 8
      LookAndFeel.Kind = lfFlat
      CriteriosPintarCelda = <>
      object cxGridDBTableView3: TcxGridDBTableView
        NavigatorButtons.ConfirmDelete = False
        DataController.DataSource = DSTAusencias
        DataController.Summary.DefaultGroupSummaryItems = <>
        DataController.Summary.FooterSummaryItems = <>
        DataController.Summary.SummaryGroups = <>
        OptionsBehavior.FocusFirstCellOnNewRecord = True
        OptionsBehavior.GoToNextCellOnEnter = True
        OptionsCustomize.ColumnFiltering = False
        OptionsData.Appending = True
        OptionsData.Deleting = False
        OptionsSelection.InvertSelect = False
        OptionsView.GroupByBox = False
        object cxGridDBTableView3Column1: TcxGridDBColumn
          Caption = 'Ausencia'
          DataBinding.FieldName = 'ausencia'
          Options.Editing = False
          Width = 212
        end
        object cxGridDBTableView3Column2: TcxGridDBColumn
          Caption = 'Seleccion'
          DataBinding.FieldName = 'seleccionado'
          Width = 55
        end
      end
      object cxGridLevel3: TcxGridLevel
        GridView = cxGridDBTableView3
      end
    end
  end
  object Panel2: TPanel [1]
    Left = 0
    Top = 305
    Width = 1010
    Height = 509
    Align = alClient
    Color = clWindow
    TabOrder = 1
    object dxGrilla: TdxDBGridSN
      Left = 1
      Top = 1
      Width = 1008
      Height = 507
      Align = alClient
      TabOrder = 0
      CriteriosPintarCelda = <>
      object dxGrillaDBTableView1: TcxGridDBTableView
        NavigatorButtons.ConfirmDelete = False
        DataController.Summary.DefaultGroupSummaryItems = <>
        DataController.Summary.FooterSummaryItems = <>
        DataController.Summary.SummaryGroups = <>
      end
      object dxGrillaDBBandedTableView1: TcxGridDBBandedTableView
        NavigatorButtons.ConfirmDelete = False
        DataController.DataSource = DSTAusentismo
        DataController.Summary.DefaultGroupSummaryItems = <>
        DataController.Summary.FooterSummaryItems = <>
        DataController.Summary.SummaryGroups = <>
        OptionsCustomize.ColumnsQuickCustomization = True
        OptionsView.GroupByBox = False
        Bands = <
          item
            Caption = 'Empleados'
            FixedKind = fkLeft
            Width = 577
          end
          item
            Caption = 'Fechas'
          end>
      end
      object dxGrillaLevel1: TcxGridLevel
        GridView = dxGrillaDBBandedTableView1
      end
    end
  end
  inherited DriverABM: TDriverABM
    CargaDataSets = <
      item
        DataSet = TSectores
        TableName = 'TSectores'
      end
      item
        DataSet = TTurnos
        TableName = 'TTurnos'
      end
      item
        DataSet = TAusencias
        TableName = 'TAusencias'
      end
      item
        DataSet = TColumnasFechas
        TableName = 'TColumnasFechas'
      end
      item
        DataSet = TAusentismo
        TableName = 'TAusentismo'
      end>
    Left = 144
    Top = 464
  end
  inherited Operacion: TOperacion
    Left = 64
    Top = 464
  end
  inherited TOidObjSave: TsnTable
    Left = 680
    Top = 272
  end
  inherited dxComponentPrinter: TdxComponentPrinter
    Left = 184
    Top = 456
    inherited dxComponentPrinterLink1: TdxCustomContainerReportLink
      Component = Owner
      BuiltInReportLink = True
      HiddenComponents = {}
      ExcludedComponents = {}
      AggregatedReportLinks = {}
    end
  end
  inherited SaveDialog: TSaveDialog
    Left = 288
    Top = 448
  end
  inherited DriverEvent: TDriverEvent
    OnValidate = <
      item
        TableName = 'TInput'
        FieldName = 'empresa'
        Source.Strings = (
          'begin'
          '  ValidadorEmpresa.Value := Sender.AsString;'
          '  ValidadorEmpresa.Validar();'
          ''
          'end.')
      end>
    OnChangeField = <
      item
        TableName = 'TInput'
        FieldName = 'empresa'
        Source.Strings = (
          'begin'
          '   TSectores.close;'
          '   TSectores.open;'
          ''
          '   Operacion.InicioOperacion();'
          '   Operacion.setOper('#39'TraerPaySectores'#39');'
          '   Operacion.addDataset(TInput.getDataset());'
          '   Operacion.execute();'
          'end.')
      end>
    OnInicializar = <
      item
        Source.Strings = (
          'begin'
          '   TInput.open;'
          '   TInput.appendRecord;'
          ''
          '   Operacion.InicioOperacion();'
          '   Operacion.setOper('#39'TraerTurnosDeRotas'#39');'
          '   Operacion.addDataset(TTurnos.getDataset());'
          '   Operacion.execute();'
          ''
          '   Operacion.InicioOperacion();'
          '   Operacion.setOper('#39'TraerTiposDeAusentismoSeleccionado'#39');'
          '   Operacion.addDataset(TAusencias.getDataset());'
          '   Operacion.execute();'
          ''
          '   TColumnasFechas.close;'
          '   TColumnasFechas.open;'
          '   TColumnasFechas.appendRecord;'
          ''
          '   TAusentismo.close;'
          '   TAusentismo.open;'
          '   TAusentismo.appendRecord;'
          ''
          'end.')
      end>
    OnFormFunction = <
      item
        Source.Strings = (
          'procedure CrearCamposGrillaDinamicos();'
          'var'
          '  col                     : TColumnaGrilla ;'
          'begin'
          '  '
          '  // Grilla Vista Principal'
          ''
          '  dxGrilla.borrarColumnas();'
          ' '
          '  col := dxGrilla.nuevaColumna('#39'legajo'#39','#39'Legajo'#39') ;'
          '  col.setWidth(110);'
          '  col.setBandIndex(0);'
          ' '
          '  col := dxGrilla.nuevaColumna('#39'nombre'#39','#39'Ape. y Nom.'#39') ;'
          '  col.setWidth(500);'
          '  col.setBandIndex(0);'
          ''
          '  col := dxGrilla.nuevaColumna('#39'sector'#39','#39'Sector'#39') ;'
          '  col.setWidth(220);'
          '  col.setBandIndex(0);'
          '  '
          '  col := dxGrilla.nuevaColumna('#39'puesto'#39','#39'Puesto'#39') ;'
          '  col.setWidth(220);'
          '  col.setBandIndex(0);'
          '  '
          
            '  col := dxGrilla.nuevaColumna('#39'inicio_lic'#39','#39'Fecha Inicio Lic.'#39')' +
            ' ;'
          '  col.setWidth(220);'
          '  col.setBandIndex(0);'
          ''
          '   TColumnasFechas.First;'
          '    while (not TColumnasFechas.eof) do'
          '        begin'
          #9
          
            '            col := dxGrilla.nuevaColumna('#39'col_'#39'+TColumnasFechas.' +
            'FieldName('#39'fecha'#39').AsString,TColumnasFechas.FieldName('#39'fecha'#39').A' +
            'sString) ;'
          '            col.setWidth(100);'
          '            col.setBandIndex(1);'
          '            '
          ''
          ''
          '        TColumnasFechas.next;'
          '        end;'
          ''
          'end;')
      end>
    OnClickToolButton = <
      item
        ButtonName = 'BotonBuscar'
        Source.Strings = (
          'Begin '
          '   operacion.InicioOperacion();'
          '   operacion.setOper('#39'TraerAusentismo'#39');'
          '   operacion.addAtribute('#39'estructura_dataset_fechas'#39','#39' '#39');'
          '   operacion.addDataset(TInput.getDataset());'
          '   operacion.execute();'
          ''
          '   TAusentismo.close;'
          '   TAusentismo.reset;'
          ''
          '   TAusentismo.addStringField('#39'legajo'#39',500);'
          '   TAusentismo.addStringField('#39'nombre'#39',500);'
          '   TAusentismo.addStringField('#39'sector'#39',500);'
          '   TAusentismo.addStringField('#39'puesto'#39',500);'
          '   TAusentismo.addStringField('#39'fecha_inicio_lic'#39',500);'
          '        '
          '   TColumnasFechas.First;'
          '    while (not TColumnasFechas.eof) do'
          '        begin'
          
            '        TAusentismo.addStringField('#39'col_'#39'+TColumnasFechas.FieldN' +
            'ame('#39'fecha'#39').AsString,4000);'
          '        TColumnasFechas.next;'
          '        end;'
          ''
          '   CrearCamposGrillaDinamicos();'
          #9#9
          '   operacion.InicioOperacion();'
          '   operacion.setOper('#39'TraerAusentismo'#39');'
          '   operacion.addAtribute('#39'datos_dataset_ausencias'#39','#39' '#39');'
          '   operacion.addDataset(TInput.getDataset());'
          '   operacion.addDataset(TSectores.getDataset());'
          '   operacion.addDataset(TTurnos.getDataset());'
          '   operacion.addDataset(TAusencias.getDataset());'
          '   operacion.execute();'
          'End.')
      end>
    Left = 248
    Top = 451
  end
  inherited SaveArchivo: TSaveDialog
    Top = 456
  end
  inherited ImprimirObjetoSeleccionado: TdxComponentPrinter
    Left = 336
    Top = 456
    inherited ImprimirObjetoSeleccionadodxComponentPrinterLink: TdxGridReportLink
      BuiltInReportLink = True
    end
  end
  inherited TTempVarForm: TsnTable
    Left = 448
    Top = 288
  end
  object TInput: TsnTable
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
    Left = 1032
    Top = 104
    object TInputfec_desde: TDateField
      FieldName = 'fec_desde'
    end
    object TInputfec_hasta: TDateField
      FieldName = 'fec_hasta'
    end
    object TInputempresa: TStringField
      FieldName = 'empresa'
      Size = 50
    end
    object TInputnombre: TStringField
      FieldName = 'nombre'
      Size = 100
    end
    object TInputhoy: TBooleanField
      FieldName = 'hoy'
    end
  end
  object DSInput: TDataSource
    DataSet = TInput
    Left = 1072
    Top = 104
  end
  object HelpEmpresas: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'admRRHH.payEmpresa'
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
        AsignarACampo = TInputempresa
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
    Titulo = 'Empresas'
    AnchoHelp = 600
    ActivarCache = False
    ShowBotonBuscar = False
    Left = 170
    Top = 284
  end
  object ValidadorEmpresa: TValidador
    Operacion = Operacion
    NickNameObjLog = 'admRRHH.payEmpresa'
    MensajeException = 'Empresa Inexistente'
    CampoDescripcion = TInputnombre
    NroQuery = 0
    Cache = False
    Left = 102
    Top = 461
  end
  object TSectores: TsnTable
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
    Left = 136
    Top = 104
    object TSectorescodigo: TIntegerField
      FieldName = 'codigo'
    end
    object TSectoressector: TStringField
      FieldName = 'sector'
      Size = 100
    end
    object TSectoresseleccionado: TBooleanField
      FieldName = 'seleccionado'
    end
  end
  object DSTSectores: TDataSource
    DataSet = TSectores
    Left = 168
    Top = 104
  end
  object DSTTurnos: TDataSource
    DataSet = TTurnos
    Left = 456
    Top = 104
  end
  object TTurnos: TsnTable
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
    Left = 424
    Top = 104
    object TTurnosoid_grupo: TIntegerField
      FieldName = 'oid_grupo'
    end
    object TTurnosturno: TStringField
      FieldName = 'turno'
      Size = 100
    end
    object TTurnosseleccionado: TBooleanField
      FieldName = 'seleccionado'
    end
  end
  object DSTAusencias: TDataSource
    DataSet = TAusencias
    Left = 812
    Top = 104
  end
  object TAusencias: TsnTable
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
    Left = 776
    Top = 104
    object TAusenciasoid_grupo_det: TIntegerField
      FieldName = 'oid_grupo_det'
    end
    object TAusenciascodigo: TIntegerField
      FieldName = 'codigo'
    end
    object TAusenciascotab: TIntegerField
      FieldName = 'cotab'
    end
    object TAusenciasausencia: TStringField
      FieldName = 'ausencia'
      Size = 200
    end
    object TAusenciasseleccionado: TBooleanField
      FieldName = 'seleccionado'
    end
  end
  object TColumnasFechas: TsnTable
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
    Left = 160
    Top = 577
    object TColumnasFechasfecha: TStringField
      FieldName = 'fecha'
      Size = 100
    end
  end
  object TAusentismo: TsnTable
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
    Left = 616
    Top = 408
    object TAusentismolegajo: TIntegerField
      FieldName = 'legajo'
    end
  end
  object DSTAusentismo: TDataSource
    DataSet = TAusentismo
    Left = 648
    Top = 408
  end
  object ImageList1: TImageList
    Left = 687
    Top = 407
    Bitmap = {
      494C010102000400040010001000FFFFFFFFFF10FFFFFFFFFFFFFFFF424D3600
      0000000000003600000028000000400000001000000001002000000000000010
      000000000000000000000000000000000000BFBFBFFFBFBFBFFFBFBFBFFFBFBF
      BFFFBFBFBFFFBFBFBFFFBFBFBFFFBFBFBFFFBFBFBFFFBFBFBFFFBFBFBFFFBFBF
      BFFFBFBFBFFFBFBFBFFFBFBFBFFFCFCFCFFF000000FF000000FF000000FFEDED
      EDFFCFCFCFFFB7B8B8FFA7A8A9FFA1A2A3FFA7A8A9FFB7B8B8FFCFCFCFFFEDED
      EDFF000000FF000000FF000000FF000000FF0000000000000000000000000000
      0000000000000000000000000000000000000000000000000000000000000000
      0000000000000000000000000000000000000000000000000000000000000000
      0000000000000000000000000000000000000000000000000000000000000000
      000000000000000000000000000000000000FFFFFFFFFFFFFFFFFFFFFFFFFFFF
      FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF
      FFFFFFFFFFFFFFFFFFFFFFFFFFFFBFBFBFFF000000FFF7F7F7FFD7D7D7FFA9AA
      AAFF979A9CFFA2A3A6FFAFB1B4FFB7B8BAFFAFB2B4FFA2A4A7FF979A9CFFA9AA
      AAFFD7D7D7FFF7F7F7FF000000FF000000FF0000000000000000000000000000
      0000000000000000000000000000000000000000000000000000000000000000
      0000000000000000000000000000000000000000000000000000000000000000
      0000000000000000000000000000000000000000000000000000000000000000
      000000000000000000000000000000000000FFFFFFFFFFFFFFFFFFFFFFFFFFFF
      FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF
      FFFFFFFFFFFFFFFFFFFFFFFFFFFFBFBFBFFFF7F7F7FFCCCCCCFF9E9EA0FFAAAC
      AEFFCACCD2FFCFD2E6FFB2BDEEFFA0B1F1FFB9C4F1FFD4D8E8FFCCCED3FFAAAC
      AFFF9EA0A1FFCCCCCCFFF7F7F7FF000000FF0000000000000000000000000000
      0000000000000000000000000000000000000000000000000000000000000000
      0000000000000000000000000000000000000000000000000000000000000000
      0000000000000000000000000000000000000000000000000000000000000000
      000000000000000000000000000000000000FFFFFFFFFFFFFFFFFFFFFFFFFFFF
      FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF
      FFFFFFFFFFFFFFFFFFFFFFFFFFFFBFBFBFFFD7D7D7FF9D9EA0FFB4B6B8FFC9CB
      E5FF9BA1ECFF6778E7FF3C5BE5FF2850E6FF5170EDFF889AF5FFB8C1F9FFD5D8
      EBFFB5B6B9FF9E9EA0FFD7D7D7FF000000FF0000000000000000000000000000
      0000000000000000000000000000000000000000000000000000000000000000
      0000000000000000000000000000000000000000000000000000000000000000
      0000000000000000000000000000000000000000000000000000000000000000
      000000000000000000000000000000000000FFFFFFFFFFFFFFFFFFFFFFFFFFFF
      FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF
      FFFFFFFFFFFFFFFFFFFFFFFFFFFFBFBFBFFFA9AAAAFFAAACAEFFC9CAE5FF8082
      E6FF212DD6FF001AD6FF0026DBFF0633E1FF1842E6FF3051ECFF5B72F2FFA7B2
      F9FFD3D8EAFFAAACAEFFA9AAAAFFEDEDEDFF0000000000000000000000000000
      0000000000000000000000000000000000000000000000000000000000000000
      0000000000000000000000000000000000000000000000000000000000000000
      0000000000000000000000000000000000000000000000000000000000000000
      000000000000000000000000000000000000FFFFFFFFFFFFFFFFFFFFFFFFFFFF
      FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF
      FFFFFFFFFFFFFFFFFFFFFFFFFFFFBFBFBFFF979A9CFFCACCD2FF9B9BEAFF2123
      D2FF000ACFFF0016D4FF0022D9FF032EDFFF0D3AE4FF2047E8FF3252ECFF546D
      F1FFB2BEF7FFCBCDD2FF999A9CFFCFCFCFFF0000000000000000000000000000
      0000000000000000000000000000000000000000000000000000000000000000
      0000000000000000000000000000000000000000000000000000000000000000
      0000000000000000000000000000000000000000000000000000000000000000
      000000000000000000000000000000000000FFFFFFFFFFFFFFFFFFFFFFFFFFFF
      FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF
      FFFFFFFFFFFFFFFFFFFFFFFFFFFFBFBFBFFFA2A3A7FFD1D2E6FF6A6AE2FF0001
      CBFF0006CDFF0011D2FF001CD7FF0126DCFF0431E0FF0E3BE4FF1B44E7FF2349
      E9FF7D93F2FFD1D6E7FFA2A4A6FFB6B7B7FF0000000000000000000000000000
      0000000000000000000000000000000000000000000000000000000000000000
      0000000000000000000000000000000000000000000000000000000000000000
      0000000000000000000000000000000000000000000000000000000000000000
      000000000000000000000000000000000000FFFFFFFFFFFFFFFFFFFFFFFFFFFF
      FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF
      FFFFFFFFFFFFFFFFFFFFFFFFFFFFBFBFBFFFB0B2B4FFC2C2EEFF5757E0FF0D0D
      CFFF0204CCFF000BCFFF0014D3FF001ED8FF0127DCFF032FE0FF0835E2FF0C39
      E3FF4467EAFFB4C1EFFFB0B2B4FFA7A8A9FF0000000000000000000000000000
      0000000000000000000000000000000000000000000000000000000000000000
      0000000000000000000000000000000000000000000000000000000000000000
      0000000000000000000000000000000000000000000000000000000000000000
      000000000000000000000000000000000000FFFFFFFFFFFFFFFFFFFFFFFFFFFF
      FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF
      FFFFFFFFFFFFFFFFFFFFFFFFFFFFBFBFBFFFB7B8BAFFB6B6F1FF5757E2FF2F2F
      D7FF191AD1FF080DCEFF020DD0FF0015D3FF001DD7FF0023DAFF0128DCFF012B
      DDFF2246E2FF9DADEFFFB7B8BAFFA1A2A3FF0000000000000000000000000000
      0000000000000000000000000000000000000000000000000000000000000000
      0000000000000000000000000000000000000000000000000000000000000000
      0000000000000000000000000000000000000000000000000000000000000000
      000000000000000000000000000000000000FFFFFFFFFFFFFFFFFFFFFFFFFFFF
      FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF
      FFFFFFFFFFFFFFFFFFFFFFFFFFFFBFBFBFFFB0B2B4FFC3C4F0FF6F6FE8FF4343
      DDFF3A3AD8FF2B2CD4FF1F23D3FF1621D3FF0F20D5FF0A21D6FF0A25D8FF0F2B
      DAFF4A60E4FFB6BFEDFFB0B2B4FFA7A8A9FF0000000000000000000000000000
      0000000000000000000000000000000000000000000000000000000000000000
      0000000000000000000000000000000000000000000000000000000000000000
      0000000000000000000000000000000000000000000000000000000000000000
      000000000000000000000000000000000000FFFFFFFFFFFFFFFFFFFFFFFFFFFF
      FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF
      FFFFFFFFFFFFFFFFFFFFFFFFFFFFBFBFBFFFA2A4A7FFD5D6E8FF8D8DEFFF4040
      E0FF4343DDFF4444DAFF4041D9FF3A3DD7FF343AD8FF303AD8FF313EDAFF3745
      DCFF8B93EBFFD5D7E6FFA2A4A7FFB6B7B7FF0000000000000000000000000000
      0000000000000000000000000000000000000000000000000000000000000000
      0000000000000000000000000000000000000000000000000000000000000000
      0000000000000000000000000000000000000000000000000000000000000000
      000000000000000000000000000000000000FFFFFFFFFFFFFFFFFFFFFFFFFFFF
      FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF
      FFFFFFFFFFFFFFFFFFFFFFFFFFFFBFBFBFFF999A9CFFCCCDD3FFB2B2F4FF5656
      E7FF3E3EE0FF4141DDFF4343DBFF4546DAFF4848DAFF4A4CDAFF4C4FDCFF6569
      E1FFBABCF1FFCCCED2FF999A9CFFCFCFCFFF0000000000000000000000000000
      0000000000000000000000000000000000000000000000000000000000000000
      0000000000000000000000000000000000000000000000000000000000000000
      0000000000000000000000000000000000000000000000000000000000000000
      000000000000000000000000000000000000FFFFFFFFFFFFFFFFFFFFFFFFFFFF
      FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF
      FFFFFFFFFFFFFFFFFFFFFFFFFFFFBFBFBFFFA9AAAAFFAAACAFFFD1D2E9FF9D9D
      F3FF5454E7FF3C3CE0FF3F3FDDFF4141DCFF4343DBFF4646DAFF6060DFFFA5A5
      EDFFD3D4E7FFAAACAFFFA9AAAAFFEDEDEDFF0000000000000000000000000000
      0000000000000000000000000000000000000000000000000000000000000000
      0000000000000000000000000000000000000000000000000000000000000000
      0000000000000000000000000000000000000000000000000000000000000000
      000000000000000000000000000000000000FFFFFFFFFFFFFFFFFFFFFFFFFFFF
      FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF
      FFFFFFFFFFFFFFFFFFFFFFFFFFFFBFBFBFFFD7D7D7FF9E9EA1FFB5B6B9FFD1D1
      E9FFB1B1F4FF8A8AEFFF6969E8FF5656E4FF6D6DE6FF8F8FEAFFB6B6F0FFD3D3
      E7FFB5B6B9FF9E9EA1FFD7D7D7FF000000FF0000000000000000000000000000
      0000000000000000000000000000000000000000000000000000000000000000
      0000000000000000000000000000000000000000000000000000000000000000
      0000000000000000000000000000000000000000000000000000000000000000
      000000000000000000000000000000000000FFFFFFFFFFFFFFFFFFFFFFFFFFFF
      FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF
      FFFFFFFFFFFFFFFFFFFFFFFFFFFFBFBFBFFFF7F7F7FFCCCCCCFF9EA0A1FFAAAD
      AFFFCCCDD3FFD4D5E8FFC1C1F0FFB2B2F1FFC2C3EFFFD5D6E7FFCCCDD3FFAAAC
      AFFF9EA0A1FFCCCCCCFFF7F7F7FF000000FF0000000000000000000000000000
      0000000000000000000000000000000000000000000000000000000000000000
      0000000000000000000000000000000000000000000000000000000000000000
      0000000000000000000000000000000000000000000000000000000000000000
      000000000000000000000000000000000000FFFFFFFFFFFFFFFFFFFFFFFFFFFF
      FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF
      FFFFFFFFFFFFFFFFFFFFFFFFFFFFBFBFBFFF000000FFF7F7F7FFD7D7D7FFA9AA
      AAFF999A9CFFA2A4A7FFAFB2B4FFB7B8BAFFAFB2B4FFA2A4A7FF999A9CFFA9AA
      AAFFD7D7D7FFF7F7F7FF000000FF000000FF0000000000000000000000000000
      0000000000000000000000000000000000000000000000000000000000000000
      0000000000000000000000000000000000000000000000000000000000000000
      0000000000000000000000000000000000000000000000000000000000000000
      000000000000000000000000000000000000424D3E000000000000003E000000
      2800000040000000100000000100010000000000800000000000000000000000
      000000000000000000000000FFFFFF000000E00F000000000000800300000000
      0000000100000000000000010000000000000000000000000000000000000000
      0000000000000000000000000000000000000000000000000000000000000000
      0000000000000000000000000000000000000000000000000000000100000000
      0000000100000000000080030000000000000000000000000000000000000000
      000000000000}
  end
end
