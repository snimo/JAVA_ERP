inherited FLogImpDatosCIP: TFLogImpDatosCIP
  Left = -3
  Top = 160
  Width = 1024
  Height = 722
  Caption = 'Log Importaci'#243'n de Datos Control de Ingresos'
  PixelsPerInch = 96
  TextHeight = 13
  object Panel1: TPanel [0]
    Left = 0
    Top = 0
    Width = 1008
    Height = 44
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
    object Label1: TLabel
      Left = 64
      Top = 12
      Width = 214
      Height = 20
      Caption = 'Logs de Importaci'#243'n de Datos'
      Font.Charset = DEFAULT_CHARSET
      Font.Color = clWindowText
      Font.Height = -16
      Font.Name = 'MS Sans Serif'
      Font.Style = []
      ParentFont = False
    end
  end
  object Panel2: TPanel [1]
    Left = 0
    Top = 44
    Width = 1008
    Height = 640
    Align = alClient
    Color = clWindow
    TabOrder = 1
    object dxDBGridSN1: TdxDBGridSN
      Left = 1
      Top = 1
      Width = 1006
      Height = 638
      Align = alClient
      TabOrder = 0
      CriteriosPintarCelda = <>
      object dxDBGridSN1DBTableView1: TcxGridDBTableView
        NavigatorButtons.ConfirmDelete = False
        DataController.DataSource = DSLogs
        DataController.Summary.DefaultGroupSummaryItems = <>
        DataController.Summary.FooterSummaryItems = <>
        DataController.Summary.SummaryGroups = <>
        OptionsBehavior.FocusCellOnTab = True
        OptionsBehavior.FocusFirstCellOnNewRecord = True
        OptionsBehavior.GoToNextCellOnEnter = True
        OptionsBehavior.FocusCellOnCycle = True
        OptionsData.CancelOnExit = False
        OptionsData.Deleting = False
        OptionsData.DeletingConfirmation = False
        OptionsData.Editing = False
        OptionsData.Inserting = False
        OptionsView.CellAutoHeight = True
        OptionsView.GroupByBox = False
        object dxDBGridSN1DBTableView1FECHA: TcxGridDBColumn
          Caption = 'Fecha'
          DataBinding.FieldName = 'FECHA'
          HeaderAlignmentHorz = taCenter
          SortIndex = 0
          SortOrder = soDescending
          Width = 89
        end
        object dxDBGridSN1DBTableView1HORA: TcxGridDBColumn
          Caption = 'Hora'
          DataBinding.FieldName = 'HORA'
          HeaderAlignmentHorz = taCenter
          SortIndex = 1
          SortOrder = soDescending
          Width = 50
        end
        object dxDBGridSN1DBTableView1SE_EJECUTO: TcxGridDBColumn
          Caption = 'Se ejecuto?'
          DataBinding.FieldName = 'SE_EJECUTO'
          HeaderAlignmentHorz = taCenter
          Width = 78
        end
        object dxDBGridSN1DBTableView1MOT_NO_EJECUTO: TcxGridDBColumn
          Caption = 'Porque NO se ejecuto?'
          DataBinding.FieldName = 'MOT_NO_EJECUTO'
          HeaderAlignmentHorz = taCenter
          Width = 139
        end
        object dxDBGridSN1DBTableView1OBSERVACION: TcxGridDBColumn
          Caption = 'Observai'#243'n'
          DataBinding.FieldName = 'OBSERVACION'
          HeaderAlignmentHorz = taCenter
          Width = 187
        end
        object dxDBGridSN1DBTableView1HUBO_ERROR: TcxGridDBColumn
          Caption = 'Huo Error?'
          DataBinding.FieldName = 'HUBO_ERROR'
          HeaderAlignmentHorz = taCenter
          Width = 69
        end
        object dxDBGridSN1DBTableView1DESC_ERROR: TcxGridDBColumn
          Caption = 'Error'
          DataBinding.FieldName = 'DESC_ERROR'
          PropertiesClassName = 'TcxMemoProperties'
          HeaderAlignmentHorz = taCenter
          Width = 332
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
        DataSet = TLogs
        TableName = 'TLogs'
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
          '  TraerLogsImportacionCIP();'
          '  varios.setImagen('#39'ImageSalir'#39',7);'
          '  dxDBGridSN1.gotoFirstRecord;'
          'end.')
      end>
    OnFormFunction = <
      item
        Source.Strings = (
          'procedure TraerLogsImportacionCIP();'
          'begin'
          '  operacion.InicioOperacion();'
          '  operacion.setOper('#39'TraerLogsImpoDatosCIP'#39');'
          '  operacion.execute();'
          'end;')
      end>
    OnClickToolButton = <
      item
        ButtonName = 'ImageSalir'
        Source.Strings = (
          'begin'
          '  close();'
          'end.')
      end>
  end
  inherited ImprimirObjetoSeleccionado: TdxComponentPrinter
    inherited ImprimirObjetoSeleccionadodxComponentPrinterLink: TdxGridReportLink
      BuiltInReportLink = True
    end
  end
  object Varios: TsnVarios
    Operacion = Operacion
    Left = 640
    Top = 185
  end
  object TLogs: TsnTable
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
    Top = 300
    object TLogsOID_LOG_IMP: TIntegerField
      FieldName = 'OID_LOG_IMP'
    end
    object TLogsTIPO_IMP: TStringField
      FieldName = 'TIPO_IMP'
    end
    object TLogsFECHA: TDateField
      FieldName = 'FECHA'
    end
    object TLogsSE_EJECUTO: TBooleanField
      FieldName = 'SE_EJECUTO'
    end
    object TLogsHUBO_ERROR: TBooleanField
      FieldName = 'HUBO_ERROR'
    end
    object TLogsMOT_NO_EJECUTO: TStringField
      FieldName = 'MOT_NO_EJECUTO'
      Size = 100
    end
    object TLogsOBSERVACION: TStringField
      FieldName = 'OBSERVACION'
      Size = 100
    end
    object TLogsDESC_ERROR: TStringField
      FieldName = 'DESC_ERROR'
      Size = 2000
    end
    object TLogsACTIVO: TBooleanField
      FieldName = 'ACTIVO'
    end
    object TLogsHORA: TStringField
      FieldName = 'HORA'
      Size = 8
    end
  end
  object DSLogs: TDataSource
    DataSet = TLogs
    Left = 464
    Top = 300
  end
end
