inherited FImpHoraRempLeg: TFImpHoraRempLeg
  Top = 274
  Width = 901
  Height = 612
  Caption = 'Importaci'#243'n de Horas de Remplazo de Legajos'
  PixelsPerInch = 96
  TextHeight = 13
  object ImageSalir: TImage [0]
    Tag = 7
    Left = 732
    Top = 10
    Width = 32
    Height = 32
    Cursor = crHandPoint
    Hint = 'Salir'
    ParentShowHint = False
    ShowHint = True
  end
  object Panel1: TPanel [1]
    Left = 0
    Top = 0
    Width = 885
    Height = 57
    Align = alTop
    Color = clWindow
    TabOrder = 0
    object Label1: TLabel
      Left = 24
      Top = 16
      Width = 54
      Height = 20
      Caption = 'Per'#237'odo'
      Font.Charset = DEFAULT_CHARSET
      Font.Color = clWindowText
      Font.Height = -16
      Font.Name = 'MS Sans Serif'
      Font.Style = []
      ParentFont = False
    end
    object Image1: TImage
      Tag = 7
      Left = 764
      Top = 10
      Width = 32
      Height = 32
      Cursor = crHandPoint
      Hint = 'Salir'
      ParentShowHint = False
      ShowHint = True
    end
    object snDBEdit1: TsnDBEdit
      Left = 88
      Top = 12
      DataBinding.DataField = 'periodo'
      DataBinding.DataSource = DSInput
      ParentFont = False
      Style.Font.Charset = DEFAULT_CHARSET
      Style.Font.Color = clWindowText
      Style.Font.Height = -16
      Style.Font.Name = 'MS Sans Serif'
      Style.Font.Style = []
      Style.IsFontAssigned = True
      TabOrder = 0
      Width = 137
    end
    object snDBCheckEdit1: TsnDBCheckEdit
      Left = 238
      Top = 13
      Caption = 'Eliminar remplazos cargados del per'#237'odo'
      DataBinding.DataField = 'eliminar_reg'
      DataBinding.DataSource = DSInput
      ParentFont = False
      Style.Font.Charset = DEFAULT_CHARSET
      Style.Font.Color = clWindowText
      Style.Font.Height = -16
      Style.Font.Name = 'MS Sans Serif'
      Style.Font.Style = []
      Style.IsFontAssigned = True
      TabOrder = 1
      Width = 337
    end
    object BotonImportar: TsnButton
      Left = 592
      Top = 11
      Width = 153
      Height = 33
      Caption = 'Importar'
      Font.Charset = DEFAULT_CHARSET
      Font.Color = clWindowText
      Font.Height = -16
      Font.Name = 'MS Sans Serif'
      Font.Style = []
      ParentFont = False
      TabOrder = 2
      LookAndFeel.Kind = lfOffice11
    end
  end
  object Panel2: TPanel [2]
    Left = 0
    Top = 57
    Width = 885
    Height = 517
    Align = alClient
    BorderWidth = 10
    Color = clWindow
    TabOrder = 1
    object dxDBGridSN1: TdxDBGridSN
      Left = 11
      Top = 11
      Width = 863
      Height = 495
      Align = alClient
      TabOrder = 0
      LookAndFeel.Kind = lfFlat
      CriteriosPintarCelda = <>
      object dxDBGridSN1DBTableView1: TcxGridDBTableView
        NavigatorButtons.ConfirmDelete = False
        DataController.DataSource = DSTRemplazos
        DataController.Summary.DefaultGroupSummaryItems = <>
        DataController.Summary.FooterSummaryItems = <>
        DataController.Summary.SummaryGroups = <>
        OptionsBehavior.FocusCellOnTab = True
        OptionsBehavior.FocusFirstCellOnNewRecord = True
        OptionsBehavior.GoToNextCellOnEnter = True
        OptionsBehavior.FocusCellOnCycle = True
        OptionsData.Appending = True
        OptionsData.DeletingConfirmation = False
        OptionsSelection.InvertSelect = False
        OptionsView.GroupByBox = False
        object dxDBGridSN1DBTableView1legajo: TcxGridDBColumn
          Caption = 'Legajo'
          DataBinding.FieldName = 'legajo'
          HeaderAlignmentHorz = taCenter
          Width = 100
        end
        object dxDBGridSN1DBTableView1ape_y_nom: TcxGridDBColumn
          Caption = 'Apellido y Nombre'
          DataBinding.FieldName = 'ape_y_nom'
          HeaderAlignmentHorz = taCenter
          Width = 291
        end
        object dxDBGridSN1DBTableView1horas_acum: TcxGridDBColumn
          Caption = 'Ultimos 12 Meses'
          DataBinding.FieldName = 'horas_acum'
          HeaderAlignmentHorz = taCenter
          Width = 100
        end
        object dxDBGridSN1DBTableView1observacion: TcxGridDBColumn
          Caption = 'Observaci'#243'n'
          DataBinding.FieldName = 'observacion'
          HeaderAlignmentHorz = taCenter
          Width = 319
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
        DataSet = TCodigoLegajo
        TableName = 'TCodigoLegajo'
      end
      item
        DataSet = TResultados
        TableName = 'TResultados'
      end>
    Left = 64
    Top = 216
  end
  inherited Operacion: TOperacion
    Left = 104
    Top = 216
  end
  inherited TOidObjSave: TsnTable
    Left = 528
    Top = 0
  end
  inherited dxComponentPrinter: TdxComponentPrinter
    Left = 144
    Top = 216
    inherited dxComponentPrinterLink1: TdxCustomContainerReportLink
      Component = Owner
      BuiltInReportLink = True
      HiddenComponents = {}
      ExcludedComponents = {}
      AggregatedReportLinks = {}
    end
  end
  inherited SaveDialog: TSaveDialog
    Left = 184
    Top = 216
  end
  inherited DriverEvent: TDriverEvent
    OnValidate = <
      item
        TableName = 'TRemplazos'
        FieldName = 'legajo'
        Source.Strings = (
          'begin'
          '  ValidarLegajo(Sender.AsString);'
          'end.')
      end>
    OnInicializar = <
      item
        Source.Strings = (
          'begin'
          '  varios.setImagen('#39'Image1'#39',7);'
          '  Inicializar();'
          'end.')
      end>
    OnFormFunction = <
      item
        Source.Strings = (
          'procedure ValidarLegajo(Legajo : string);'
          'begin'
          ''
          '  TCodigoLegajo.Close;'
          '  TCodigoLegajo.Open;'
          ''
          '  if (trim(Legajo)<>'#39#39')'
          '     then begin '
          #9'  operacion.inicioOperacion();'
          #9'  operacion.setOper('#39'TraerCodigoLegajo'#39');'
          #9'  operacion.AddAtribute('#39'cod_legajo'#39',Legajo);'
          #9'  operacion.execute();'
          '          end; '
          ''
          'if (not TCodigoLegajo.IsEmpty())'
          '   then begin'
          '        TRemplazos.EditRecord;  '
          
            '        TRemplazos.FieldName('#39'oid_legajo'#39').AsInteger := TCodigoL' +
            'egajo.FieldName('#39'oid'#39').AsInteger;'
          
            '        TRemplazos.FieldName('#39'ape_y_nom'#39').AsString  := TCodigoLe' +
            'gajo.FieldName('#39'descripcion'#39').AsString;'
          '        end'
          '   else begin'
          '        TRemplazos.EditRecord;  '
          '        TRemplazos.FieldName('#39'oid_legajo'#39').Clear;'
          '        TRemplazos.FieldName('#39'ape_y_nom'#39').Clear;'
          '        end;'
          ''
          'end; '
          ''
          'procedure Importar();'
          'begin'
          '  TInput.PostRecord;'
          '  TRemplazos.PostRecord;'
          '  operacion.InicioOperacion();'
          '  operacion.setOper('#39'ImportarHorasRemplazos'#39');'
          '  operacion.AddDataSet(TInput.getDataSet());'
          '  operacion.AddDataSet(TRemplazos.getDataSet());'
          '  operacion.execute();'
          'end;'
          ''
          'procedure Inicializar();'
          'begin'
          '  TInput.Close();'
          '  TInput.Open();'
          '  TInput.AppendRecord(); '
          '  TInput.FieldName('#39'eliminar_reg'#39').AsBoolean := False;'
          '  TRemplazos.Close();'
          '  TRemplazos.Open();'
          '  TRemplazos.AppendRecord(); '
          'end;')
      end>
    OnClickToolButton = <
      item
        ButtonName = 'BotonImportar'
        Source.Strings = (
          'begin'
          
            '  if (not mensaje.question('#39'Confirma proceso de importaci'#243'n?'#39')) ' +
            'then exit;'
          '  importar();'
          
            '  mensaje.information(TResultados.FieldName('#39'descripcion'#39').AsStr' +
            'ing);'
          '  Inicializar();'
          'end.')
      end
      item
        ButtonName = 'Image1'
        Source.Strings = (
          'begin'
          '  Close();'
          'end.')
      end>
    Left = 224
    Top = 219
  end
  inherited ImprimirObjetoSeleccionado: TdxComponentPrinter
    inherited ImprimirObjetoSeleccionadodxComponentPrinterLink: TdxGridReportLink
      BuiltInReportLink = True
    end
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
    Left = 88
    Top = 96
    object TInputeliminar_reg: TBooleanField
      FieldName = 'eliminar_reg'
    end
    object TInputperiodo: TStringField
      FieldName = 'periodo'
      Size = 7
    end
  end
  object DSInput: TDataSource
    DataSet = TInput
    Left = 120
    Top = 97
  end
  object TRemplazos: TsnTable
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
    Left = 88
    Top = 137
    object TRemplazosoid_legajo: TIntegerField
      FieldName = 'oid_legajo'
    end
    object TRemplazoslegajo: TStringField
      FieldName = 'legajo'
      Size = 50
    end
    object TRemplazosape_y_nom: TStringField
      FieldName = 'ape_y_nom'
      Size = 100
    end
    object TRemplazoshoras_acum: TFloatField
      FieldName = 'horas_acum'
    end
    object TRemplazosobservacion: TStringField
      FieldName = 'observacion'
      Size = 500
    end
  end
  object DSTRemplazos: TDataSource
    DataSet = TRemplazos
    Left = 120
    Top = 137
  end
  object TCodigoLegajo: TsnTable
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
    Left = 208
    Top = 377
    object TCodigoLegajooid: TIntegerField
      FieldName = 'oid'
    end
    object TCodigoLegajocodigo: TStringField
      FieldName = 'codigo'
      Size = 50
    end
    object TCodigoLegajodescripcion: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
  end
  object TResultados: TsnTable
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
    Top = 393
    object TResultadosdescripcion: TStringField
      FieldName = 'descripcion'
      Size = 500
    end
  end
  object Varios: TsnVarios
    Operacion = Operacion
    Left = 672
    Top = 76
  end
end
