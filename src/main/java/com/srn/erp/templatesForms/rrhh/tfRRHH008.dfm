inherited FVerCompetencia: TFVerCompetencia
  Left = 131
  Top = 426
  Width = 731
  Height = 300
  BorderIcons = []
  Caption = 'Competencia'
  Position = poScreenCenter
  PixelsPerInch = 96
  TextHeight = 13
  object Panel1: TPanel [0]
    Left = 0
    Top = 0
    Width = 715
    Height = 49
    Align = alTop
    BevelOuter = bvNone
    Color = clWindow
    TabOrder = 0
    object Label1: TLabel
      Left = 57
      Top = 18
      Width = 83
      Height = 16
      Caption = 'Competencia:'
      Font.Charset = DEFAULT_CHARSET
      Font.Color = clWindowText
      Font.Height = -13
      Font.Name = 'MS Sans Serif'
      Font.Style = []
      ParentFont = False
    end
    object ImageSalir: TImage
      Tag = 7
      Left = 14
      Top = 9
      Width = 32
      Height = 32
      Cursor = crHandPoint
      Hint = 'Salir'
      ParentShowHint = False
      ShowHint = True
    end
    object snDBEdit1: TsnDBEdit
      Left = 144
      Top = 16
      DataBinding.DataField = 'titulo'
      DataBinding.DataSource = DSCompetencia
      ParentFont = False
      Properties.ReadOnly = True
      Style.Font.Charset = DEFAULT_CHARSET
      Style.Font.Color = clWindowText
      Style.Font.Height = -13
      Style.Font.Name = 'MS Sans Serif'
      Style.Font.Style = []
      Style.IsFontAssigned = True
      TabOrder = 0
      Width = 559
    end
  end
  object Panel2: TPanel [1]
    Left = 0
    Top = 49
    Width = 715
    Height = 204
    Align = alClient
    BevelOuter = bvNone
    BorderWidth = 5
    Color = clWindow
    TabOrder = 1
    object snDBMemo1: TsnDBMemo
      Left = 5
      Top = 5
      Align = alClient
      DataBinding.DataField = 'definicion'
      DataBinding.DataSource = DSCompetencia
      ParentFont = False
      Properties.ReadOnly = True
      Style.Font.Charset = ANSI_CHARSET
      Style.Font.Color = clWindowText
      Style.Font.Height = -16
      Style.Font.Name = 'Verdana'
      Style.Font.Style = []
      Style.IsFontAssigned = True
      TabOrder = 0
      ReadOnlyAlways = False
      Height = 194
      Width = 705
    end
  end
  object Panel3: TPanel [2]
    Left = 0
    Top = 253
    Width = 715
    Height = 9
    Align = alBottom
    Color = clWindow
    TabOrder = 2
  end
  inherited DriverABM: TDriverABM
    CargaDataSets = <
      item
        DataSet = TCompetencia
        TableName = 'TCompetencia'
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
    OnShow.Strings = (
      'var'
      '  oidCompetencia : integer;'
      '  oidEvalCab : integer;'
      'begin'
      ''
      '  oidCompetencia  := getParamValue('#39'oid_competencia'#39');'
      '  oidEvalCab := getParamValue('#39'oid_eval_cab'#39');'
      ''
      '   if (oidCompetencia<=0) then exit;'
      '   if (oidEvalCab<=0) then exit;'
      ''
      '   operacion.InicioOperacion();'
      '   operacion.setOper('#39'TraerVerDescCompetencia'#39');'
      
        '   operacion.addAtribute('#39'oid_competencia'#39',IntToStr(oidCompetenc' +
        'ia));'
      '   operacion.addAtribute('#39'oid_eval_cab'#39',IntToStr(oidEvalCab));'
      '   operacion.execute(); '
      ' '
      'end.')
    OnPublicVariable = <
      item
        VariableName = 'oid_eval_cab'
      end
      item
        VariableName = 'oid_competencia'
      end>
    OnInicializar = <
      item
        Source.Strings = (
          'begin'
          '  varios.setImagen('#39'ImageSalir'#39',7);'
          'end.')
      end>
    OnClickToolButton = <
      item
        ButtonName = 'ImageSalir'
        Source.Strings = (
          'begin'
          '  Close();'
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
    Left = 672
    Top = 76
  end
  object TCompetencia: TsnTable
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
    Left = 512
    Top = 113
    object TCompetenciaoid_competencia: TIntegerField
      FieldName = 'oid_competencia'
    end
    object TCompetenciatitulo: TStringField
      FieldName = 'titulo'
      Size = 4000
    end
    object TCompetenciadefinicion: TMemoField
      FieldName = 'definicion'
      BlobType = ftMemo
    end
  end
  object DSCompetencia: TDataSource
    DataSet = TCompetencia
    Left = 544
    Top = 113
  end
end
