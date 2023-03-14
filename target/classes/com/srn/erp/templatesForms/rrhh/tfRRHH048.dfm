inherited FSelConsGrabRota: TFSelConsGrabRota
  Left = 164
  Top = 141
  Width = 904
  Height = 568
  BorderIcons = []
  Caption = 'Seleccionar Consulta'
  Position = poScreenCenter
  PixelsPerInch = 96
  TextHeight = 13
  object Panel1: TPanel [0]
    Left = 0
    Top = 0
    Width = 888
    Height = 179
    Align = alTop
    Color = clWindow
    TabOrder = 0
    object Label2: TLabel
      Left = 8
      Top = 149
      Width = 414
      Height = 16
      Caption = 'Seleccione la consulta grabada y presione el bot'#243'n "SELECCIONAR"'
      Font.Charset = DEFAULT_CHARSET
      Font.Color = clBlue
      Font.Height = -13
      Font.Name = 'MS Sans Serif'
      Font.Style = []
      ParentFont = False
    end
    object Label5: TLabel
      Left = 7
      Top = 6
      Width = 268
      Height = 16
      Caption = 'Debe ingresar la Fecha o el Nro. de Consulta'
      Font.Charset = DEFAULT_CHARSET
      Font.Color = clBlue
      Font.Height = -13
      Font.Name = 'MS Sans Serif'
      Font.Style = []
      ParentFont = False
    end
    object BotonBuscarConsGrabadas: TButton
      Left = 540
      Top = 112
      Width = 197
      Height = 46
      Caption = 'Traer Consultas Grabadas'
      Font.Charset = DEFAULT_CHARSET
      Font.Color = clWindowText
      Font.Height = -13
      Font.Name = 'MS Sans Serif'
      Font.Style = []
      ParentFont = False
      TabOrder = 2
    end
    object snDBCheckEdit1: TsnDBCheckEdit
      Left = 7
      Top = 97
      Caption = 
        'Mostrar si hubo novedades desde la grabaci'#243'n de la consulta a Ho' +
        'y'
      DataBinding.DataField = 'ver_novedades'
      DataBinding.DataSource = DSInput
      ParentFont = False
      Style.Font.Charset = DEFAULT_CHARSET
      Style.Font.Color = clWindowText
      Style.Font.Height = -13
      Style.Font.Name = 'MS Sans Serif'
      Style.Font.Style = []
      Style.IsFontAssigned = True
      TabOrder = 3
      Width = 452
    end
    object snDBCheckEdit2: TsnDBCheckEdit
      Left = 7
      Top = 121
      Caption = 'En caso de encontrar novedades, mostrar solo las del primer d'#237'a'
      DataBinding.DataField = 'solo_novedades_primer_dia'
      DataBinding.DataSource = DSInput
      ParentFont = False
      Style.Font.Charset = DEFAULT_CHARSET
      Style.Font.Color = clWindowText
      Style.Font.Height = -13
      Style.Font.Name = 'MS Sans Serif'
      Style.Font.Style = []
      Style.IsFontAssigned = True
      TabOrder = 4
      Width = 474
    end
    object GroupBox1: TGroupBox
      Left = 8
      Top = 26
      Width = 537
      Height = 65
      TabOrder = 0
      object Label1: TLabel
        Left = 8
        Top = 9
        Width = 102
        Height = 16
        Caption = 'Tipo de Consulta'
        Font.Charset = DEFAULT_CHARSET
        Font.Color = clBlue
        Font.Height = -13
        Font.Name = 'MS Sans Serif'
        Font.Style = []
        ParentFont = False
      end
      object Label3: TLabel
        Left = 399
        Top = 9
        Width = 38
        Height = 16
        Caption = 'Fecha'
        Font.Charset = DEFAULT_CHARSET
        Font.Color = clBlue
        Font.Height = -13
        Font.Name = 'MS Sans Serif'
        Font.Style = []
        ParentFont = False
      end
      object snDBLookup1: TsnDBLookup
        Left = 8
        Top = 32
        DataBinding.DataField = 'tipo_fecha'
        DataBinding.DataSource = DSInput
        ParentFont = False
        Properties.KeyFieldNames = 'codigo'
        Properties.ListColumns = <
          item
            FieldName = 'descripcion'
          end>
        Properties.ListOptions.ShowHeader = False
        Properties.ListSource = DSSeleccionTipoFecha
        Style.Font.Charset = DEFAULT_CHARSET
        Style.Font.Color = clWindowText
        Style.Font.Height = -13
        Style.Font.Name = 'MS Sans Serif'
        Style.Font.Style = []
        Style.IsFontAssigned = True
        TabOrder = 0
        Width = 385
      end
      object snDBDateEdit1: TsnDBDateEdit
        Left = 399
        Top = 32
        DataBinding.DataField = 'fecha'
        DataBinding.DataSource = DSInput
        ParentFont = False
        Properties.ImmediatePost = True
        Style.Font.Charset = DEFAULT_CHARSET
        Style.Font.Color = clWindowText
        Style.Font.Height = -13
        Style.Font.Name = 'MS Sans Serif'
        Style.Font.Style = []
        Style.IsFontAssigned = True
        TabOrder = 1
        ReadOnlyAlways = False
        Width = 121
      end
    end
    object GroupBox2: TGroupBox
      Left = 552
      Top = 26
      Width = 185
      Height = 65
      TabOrder = 1
      object Label4: TLabel
        Left = 14
        Top = 11
        Width = 99
        Height = 16
        Caption = 'Nro. de Consulta'
        Font.Charset = DEFAULT_CHARSET
        Font.Color = clBlue
        Font.Height = -13
        Font.Name = 'MS Sans Serif'
        Font.Style = []
        ParentFont = False
      end
      object snDBEdit1: TsnDBEdit
        Left = 13
        Top = 32
        DataBinding.DataField = 'nro_consulta'
        DataBinding.DataSource = DSInput
        ParentFont = False
        Style.Font.Charset = DEFAULT_CHARSET
        Style.Font.Color = clWindowText
        Style.Font.Height = -13
        Style.Font.Name = 'MS Sans Serif'
        Style.Font.Style = []
        Style.IsFontAssigned = True
        TabOrder = 0
        Width = 121
      end
    end
  end
  object Panel2: TPanel [1]
    Left = 0
    Top = 482
    Width = 888
    Height = 48
    Align = alBottom
    Color = clWindow
    TabOrder = 1
    object BotonSeleccionar: TButton
      Left = 432
      Top = 8
      Width = 121
      Height = 33
      Caption = 'Seleccionar'
      Default = True
      Font.Charset = DEFAULT_CHARSET
      Font.Color = clWindowText
      Font.Height = -13
      Font.Name = 'MS Sans Serif'
      Font.Style = []
      ParentFont = False
      TabOrder = 0
    end
    object BotonSalir: TButton
      Left = 592
      Top = 8
      Width = 121
      Height = 33
      Caption = 'Salir'
      Font.Charset = DEFAULT_CHARSET
      Font.Color = clWindowText
      Font.Height = -13
      Font.Name = 'MS Sans Serif'
      Font.Style = []
      ParentFont = False
      TabOrder = 1
    end
  end
  object Panel3: TPanel [2]
    Left = 0
    Top = 179
    Width = 888
    Height = 303
    Align = alClient
    Color = clWindow
    TabOrder = 2
    object dxDBGridSN4: TdxDBGridSN
      Left = 1
      Top = 1
      Width = 886
      Height = 301
      Align = alClient
      TabOrder = 0
      CriteriosPintarCelda = <>
      object cxGridDBTableView3: TcxGridDBTableView
        NavigatorButtons.ConfirmDelete = False
        DataController.DataSource = DSConsultasGrabadas
        DataController.Summary.DefaultGroupSummaryItems = <>
        DataController.Summary.FooterSummaryItems = <>
        DataController.Summary.SummaryGroups = <>
        OptionsBehavior.IncSearch = True
        OptionsCustomize.ColumnFiltering = False
        OptionsData.CancelOnExit = False
        OptionsData.Deleting = False
        OptionsData.DeletingConfirmation = False
        OptionsData.Editing = False
        OptionsData.Inserting = False
        OptionsSelection.UnselectFocusedRecordOnExit = False
        OptionsView.CellAutoHeight = True
        OptionsView.GroupByBox = False
        object cxGridDBTableView3Column1: TcxGridDBColumn
          Caption = 'Nro. '
          DataBinding.FieldName = 'nro_int'
          HeaderAlignmentHorz = taCenter
          SortIndex = 0
          SortOrder = soDescending
          Width = 75
        end
        object cxGridDBTableView3fec_desde: TcxGridDBColumn
          Caption = 'Fecha Rota'
          DataBinding.FieldName = 'fec_desde'
          HeaderAlignmentHorz = taCenter
          Width = 91
        end
        object cxGridDBTableView3descripcion: TcxGridDBColumn
          Caption = 'Consulta'
          DataBinding.FieldName = 'descripcion'
          HeaderAlignmentHorz = taCenter
          Width = 211
        end
        object cxGridDBTableView3agrupador: TcxGridDBColumn
          Caption = 'Desc. Detallada'
          DataBinding.FieldName = 'agrupador'
          HeaderAlignmentHorz = taCenter
          Width = 182
        end
        object cxGridDBTableView3fecha: TcxGridDBColumn
          Caption = 'Fecha Grabaci'#243'n'
          DataBinding.FieldName = 'fecha'
          HeaderAlignmentHorz = taCenter
          Width = 94
        end
        object cxGridDBTableView3hora: TcxGridDBColumn
          Caption = 'Hora Grabaci'#243'n'
          DataBinding.FieldName = 'hora'
          HeaderAlignmentHorz = taCenter
          Width = 88
        end
        object cxGridDBTableView3Column2: TcxGridDBColumn
          Caption = 'Usuario'
          DataBinding.FieldName = 'usuario'
          HeaderAlignmentHorz = taCenter
          Options.Editing = False
          Width = 136
        end
      end
      object cxGridLevel3: TcxGridLevel
        GridView = cxGridDBTableView3
      end
    end
  end
  inherited DriverABM: TDriverABM
    CargaDataSets = <
      item
        DataSet = TConsultasGrabadas
        TableName = 'TConsultasGrabadas'
      end>
    Left = 248
    Top = 296
  end
  inherited Operacion: TOperacion
    Left = 288
    Top = 296
  end
  inherited TOidObjSave: TsnTable
    Left = 552
    Top = 104
  end
  inherited dxComponentPrinter: TdxComponentPrinter
    Left = 328
    Top = 296
    inherited dxComponentPrinterLink1: TdxCustomContainerReportLink
      Component = Owner
      BuiltInReportLink = True
      HiddenComponents = {}
      ExcludedComponents = {}
      AggregatedReportLinks = {}
    end
  end
  inherited SaveDialog: TSaveDialog
    Left = 368
    Top = 296
  end
  inherited DriverEvent: TDriverEvent
    OnShow.Strings = (
      'begin'
      '  Inicializar();'
      '  snDBDateEdit1.setFoco(); '
      'end.')
    OnChangeField = <
      item
        TableName = 'TInput'
        FieldName = 'fecha'
        Source.Strings = (
          'begin'
          '   TConsultasGrabadas.Close;'
          '   TConsultasGrabadas.Open;'
          'end.')
      end>
    OnNuevoRegistro = <
      item
        TableName = 'TInput'
        Source.Strings = (
          'begin'
          '  DataSet.FieldName('#39'ver_novedades'#39').AsBoolean := true;'
          '  //DataSet.FieldName('#39'fecha'#39').Value := varios.getFecha()-1;'
          '  DataSet.FieldName('#39'tipo_fecha'#39').Value := '#39'ROTA'#39';'
          '  DataSet.FieldName('#39'solo_novedades_primer_dia'#39').Value := true;'
          'end.')
      end>
    OnDblClick = <
      item
        CompoName = 'cxGridDBTableView3'
        Source.Strings = (
          'begin'
          '  selecciono();'
          'end.')
      end>
    OnPublicVariable = <
      item
        VariableName = 'TConsultasGrabadas'
      end
      item
        VariableName = 'TInput'
      end>
    OnInicializar = <
      item
        Source.Strings = (
          'begin'
          '   Inicializar();'
          '   cargarTiposFechas();'
          'end.')
      end>
    OnFormFunction = <
      item
        Source.Strings = (
          'procedure Inicializar();'
          'begin'
          '   TInput.Close;'
          '   TInput.Open;'
          '   TInput.AppendRecord;'
          'end;'
          ''
          'procedure EjecutarConsulta();'
          'begin'
          ''
          '  TInput.PostRecord;'
          ''
          '  operacion.InicioOperacion();'
          '  operacion.setOper('#39'TraerConsGrabRotas'#39');'
          '  operacion.AddDataSet(TInput.getDataSet());'
          '  operacion.execute();'
          '  dxDBGridSN4.gotoFirstRecord;'
          '  if (TConsultasGrabadas.IsEmpty)'
          
            '      then mensaje.information('#39'No hay consultas para la selecci' +
            #243'n realizada.'#39');'
          ''
          'end;'
          ''
          'procedure cargarTiposFechas();'
          'begin'
          ''
          '  TSeleccionTipoFecha.Close;'
          '  TSeleccionTipoFecha.Open;'
          ''
          '  TSeleccionTipoFecha.AppendRecord; '
          '  TSeleccionTipoFecha.FieldName('#39'codigo'#39').AsString := '#39'ROTA'#39';'
          
            '  TSeleccionTipoFecha.FieldName('#39'descripcion'#39').AsString := '#39'Cons' +
            'ultas cuya fecha de rota sea del '#39';'
          '  TSeleccionTipoFecha.PostRecord;'
          ''
          '  TSeleccionTipoFecha.AppendRecord; '
          '  TSeleccionTipoFecha.FieldName('#39'codigo'#39').AsString := '#39'GRABA'#39';'
          
            '  TSeleccionTipoFecha.FieldName('#39'descripcion'#39').AsString := '#39'Cons' +
            'ultas cuya fecha de grabaci'#243'n sea del'#39';'
          '  TSeleccionTipoFecha.PostRecord;'
          ''
          'end;'
          ''
          'procedure selecciono();'
          'begin'
          '    TInput.EditRecord;'
          '  TInput.FieldName('#39'acepto'#39').Value := true;'
          '  TInput.PostRecord;'
          '  Close();'
          ''
          'end;')
      end>
    OnClickToolButton = <
      item
        ButtonName = 'BotonBuscarConsGrabadas'
        Source.Strings = (
          'begin'
          '   EjecutarConsulta();'
          'end.')
      end
      item
        ButtonName = 'BotonSalir'
        Source.Strings = (
          'begin'
          '  TInput.EditRecord;'
          '  TInput.FieldName('#39'acepto'#39').Value := False;'
          '  TInput.PostRecord;'
          ''
          '  Close();'
          'end.')
      end
      item
        ButtonName = 'BotonSeleccionar'
        Source.Strings = (
          'begin'
          '  selecciono();'
          'end.')
      end>
    Left = 408
    Top = 299
  end
  inherited ImprimirObjetoSeleccionado: TdxComponentPrinter
    inherited ImprimirObjetoSeleccionadodxComponentPrinterLink: TdxGridReportLink
      BuiltInReportLink = True
    end
  end
  inherited TTempVarForm: TsnTable
    Left = 448
    Top = 128
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
    Left = 64
    Top = 169
    object TInputfecha: TDateField
      FieldName = 'fecha'
    end
    object TInputacepto: TBooleanField
      FieldName = 'acepto'
    end
    object TInputver_novedades: TBooleanField
      FieldName = 'ver_novedades'
    end
    object TInputtipo_fecha: TStringField
      FieldName = 'tipo_fecha'
      Size = 50
    end
    object TInputsolo_novedades_primer_dia: TBooleanField
      FieldName = 'solo_novedades_primer_dia'
    end
    object TInputnro_consulta: TIntegerField
      FieldName = 'nro_consulta'
    end
  end
  object DSInput: TDataSource
    DataSet = TInput
    Left = 104
    Top = 169
  end
  object TConsultasGrabadas: TsnTable
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
    Top = 185
    object TConsultasGrabadasnro_int: TIntegerField
      FieldName = 'nro_int'
    end
    object TConsultasGrabadasfecha: TDateField
      FieldName = 'fecha'
    end
    object TConsultasGrabadashora: TStringField
      FieldName = 'hora'
      Size = 5
    end
    object TConsultasGrabadasagrupador: TStringField
      DisplayWidth = 500
      FieldName = 'agrupador'
      Size = 500
    end
    object TConsultasGrabadasdescripcion: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
    object TConsultasGrabadasfec_desde: TDateField
      FieldName = 'fec_desde'
    end
    object TConsultasGrabadasoid: TIntegerField
      FieldName = 'oid'
    end
    object TConsultasGrabadasusuario: TStringField
      FieldName = 'usuario'
      Size = 100
    end
  end
  object DSConsultasGrabadas: TDataSource
    DataSet = TConsultasGrabadas
    Left = 240
    Top = 185
  end
  object varios: TsnVarios
    Operacion = Operacion
    Left = 576
    Top = 201
  end
  object TSeleccionTipoFecha: TsnTable
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
    Left = 216
    Top = 143
    object TSeleccionTipoFechacodigo: TStringField
      FieldName = 'codigo'
      Size = 50
    end
    object TSeleccionTipoFechadescripcion: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
  end
  object DSSeleccionTipoFecha: TDataSource
    DataSet = TSeleccionTipoFecha
    Left = 248
    Top = 143
  end
end
