inherited FLogAgrupAntEmp: TFLogAgrupAntEmp
  Caption = 'L'#243'gica de Agrupaci'#243'n de Antiguedad en Empresas '
  Position = poScreenCenter
  PixelsPerInch = 96
  TextHeight = 13
  object Panel1: TPanel [0]
    Left = 0
    Top = 0
    Width = 779
    Height = 41
    Align = alTop
    Color = clWindow
    TabOrder = 0
    object Label1: TLabel
      Left = 17
      Top = 10
      Width = 306
      Height = 16
      Caption = 'L'#243'gica de Agrupaci'#243'n en Antiguedad de Empresas'
      Font.Charset = DEFAULT_CHARSET
      Font.Color = clWindowText
      Font.Height = -13
      Font.Name = 'MS Sans Serif'
      Font.Style = []
      ParentFont = False
    end
    object snButton1: TsnButton
      Left = 352
      Top = 8
      Width = 121
      Height = 25
      Caption = 'Grabar Cambios'
      TabOrder = 0
      LookAndFeel.Kind = lfOffice11
    end
    object BotonSalir: TsnButton
      Left = 640
      Top = 8
      Width = 121
      Height = 25
      Caption = 'Salir'
      TabOrder = 1
      LookAndFeel.Kind = lfOffice11
    end
  end
  object Panel2: TPanel [1]
    Left = 0
    Top = 41
    Width = 779
    Height = 436
    Align = alClient
    Color = clWindow
    TabOrder = 1
    object dxDBGridSN1: TdxDBGridSN
      Left = 1
      Top = 1
      Width = 777
      Height = 434
      Align = alClient
      TabOrder = 0
      LookAndFeel.Kind = lfFlat
      CriteriosPintarCelda = <>
      object dxDBGridSN1DBTableView1: TcxGridDBTableView
        NavigatorButtons.ConfirmDelete = False
        DataController.DataSource = DSAgrupadoresEmpresas
        DataController.Summary.DefaultGroupSummaryItems = <>
        DataController.Summary.FooterSummaryItems = <>
        DataController.Summary.SummaryGroups = <>
        OptionsBehavior.FocusCellOnTab = True
        OptionsBehavior.FocusFirstCellOnNewRecord = True
        OptionsBehavior.GoToNextCellOnEnter = True
        OptionsBehavior.FocusCellOnCycle = True
        OptionsData.Deleting = False
        OptionsData.DeletingConfirmation = False
        OptionsData.Inserting = False
        OptionsSelection.InvertSelect = False
        OptionsView.GroupByBox = False
        object dxDBGridSN1DBTableView1DESC_EMPRESA: TcxGridDBColumn
          Caption = 'Empresa'
          DataBinding.FieldName = 'DESC_EMPRESA'
          Options.Editing = False
          Width = 328
        end
        object dxDBGridSN1DBTableView1COD_ANT_EMP: TcxGridDBColumn
          Caption = 'C'#243'digo Agrupaci'#243'n Empresa'
          DataBinding.FieldName = 'COD_ANT_EMP'
          Width = 156
        end
      end
      object dxDBGridSN1Level1: TcxGridLevel
        GridView = dxDBGridSN1DBTableView1
      end
    end
  end
  inherited DriverABM: TDriverABM
    CargaDataSets = <
      item
        DataSet = TAgrupadoresEmpresas
        TableName = 'TAgrupadoresEmpresas'
      end>
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
    OnInicializar = <
      item
        Source.Strings = (
          'begin'
          '  TraerAgrupadores();'
          'end.')
      end>
    OnFormFunction = <
      item
        Source.Strings = (
          'procedure TraerAgrupadores();'
          'begin'
          '   operacion.InicioOperacion();'
          '   operacion.setOper('#39'TraerEmpAgruParaAntiSec'#39');'
          ' operacion.execute();'
          'end;')
      end>
    OnClickToolButton = <
      item
        ButtonName = 'BotonSalir'
        Source.Strings = (
          'begin'
          '  Close();'
          'end.')
      end
      item
        ButtonName = 'snButton1'
        Source.Strings = (
          'begin'
          '  TAgrupadoresEmpresas.PostRecord;'
          '  operacion.InicioOperacion();'
          '  operacion.setOper('#39'SaveEmpAgruParaAnt'#39');'
          '  operacion.addDataSet(TAgrupadoresEmpresas.getDataSet()); '
          '  operacion.execute();'
          '  close;'
          'end.')
      end>
  end
  inherited ImprimirObjetoSeleccionado: TdxComponentPrinter
    inherited ImprimirObjetoSeleccionadodxComponentPrinterLink: TdxGridReportLink
      BuiltInReportLink = True
    end
  end
  object TAgrupadoresEmpresas: TsnTable
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
    Left = 560
    Top = 113
    object TAgrupadoresEmpresasOID_VAL_CLASIF_EMP: TIntegerField
      FieldName = 'OID_VAL_CLASIF_EMP'
    end
    object TAgrupadoresEmpresasCOD_ANT_EMP: TStringField
      FieldName = 'COD_ANT_EMP'
      Size = 10
    end
    object TAgrupadoresEmpresasDESC_EMPRESA: TStringField
      FieldName = 'DESC_EMPRESA'
      Size = 100
    end
  end
  object DSAgrupadoresEmpresas: TDataSource
    DataSet = TAgrupadoresEmpresas
    Left = 592
    Top = 113
  end
end
