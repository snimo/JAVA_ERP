inherited FAltaAccIntLeg: TFAltaAccIntLeg
  Left = 260
  Top = 125
  Width = 824
  Height = 689
  BorderIcons = [biSystemMenu]
  Caption = 'Habilitar Accesos Internos'
  DragKind = dkDrag
  DragMode = dmManual
  Position = poScreenCenter
  PixelsPerInch = 96
  TextHeight = 13
  object Panel1: TPanel [0]
    Left = 0
    Top = 598
    Width = 808
    Height = 53
    Align = alBottom
    BevelOuter = bvNone
    Color = clWindow
    TabOrder = 0
    object BotonAceptar: TsnButton
      Left = 488
      Top = 8
      Width = 113
      Height = 33
      Cursor = crHandPoint
      Caption = '&Aceptar'
      Font.Charset = DEFAULT_CHARSET
      Font.Color = clWindowText
      Font.Height = -16
      Font.Name = 'MS Sans Serif'
      Font.Style = []
      ParentFont = False
      TabOrder = 0
      LookAndFeel.Kind = lfOffice11
    end
    object BotonCancelar: TsnButton
      Left = 632
      Top = 8
      Width = 113
      Height = 33
      Cursor = crHandPoint
      Caption = '&Cancelar'
      Font.Charset = DEFAULT_CHARSET
      Font.Color = clWindowText
      Font.Height = -16
      Font.Name = 'MS Sans Serif'
      Font.Style = []
      ParentFont = False
      TabOrder = 1
      LookAndFeel.Kind = lfOffice11
    end
  end
  object Panel2: TPanel [1]
    Left = 0
    Top = 0
    Width = 808
    Height = 598
    Align = alClient
    BevelOuter = bvNone
    Color = clWindow
    TabOrder = 1
    object Panel3: TPanel
      Left = 0
      Top = 0
      Width = 808
      Height = 102
      Align = alTop
      BevelOuter = bvNone
      Color = clWindow
      TabOrder = 0
      object Label2: TLabel
        Left = 16
        Top = 24
        Width = 144
        Height = 20
        Caption = 'Fecha / Hora desde:'
        Font.Charset = DEFAULT_CHARSET
        Font.Color = clWindowText
        Font.Height = -16
        Font.Name = 'MS Sans Serif'
        Font.Style = []
        ParentFont = False
      end
      object Label3: TLabel
        Left = 400
        Top = 24
        Width = 140
        Height = 20
        Caption = 'Fecha / Hora hasta:'
        Font.Charset = DEFAULT_CHARSET
        Font.Color = clWindowText
        Font.Height = -16
        Font.Name = 'MS Sans Serif'
        Font.Style = []
        ParentFont = False
      end
      object Label1: TLabel
        Left = 16
        Top = 64
        Width = 57
        Height = 20
        Caption = 'Permiso'
        Font.Charset = DEFAULT_CHARSET
        Font.Color = clWindowText
        Font.Height = -16
        Font.Name = 'MS Sans Serif'
        Font.Style = []
        ParentFont = False
      end
      object snDBFecDesde: TsnDBDateEdit
        Left = 176
        Top = 20
        DataBinding.DataField = 'fec_desde'
        DataBinding.DataSource = DSInput
        ParentFont = False
        Style.Font.Charset = DEFAULT_CHARSET
        Style.Font.Color = clWindowText
        Style.Font.Height = -16
        Style.Font.Name = 'MS Sans Serif'
        Style.Font.Style = []
        Style.IsFontAssigned = True
        TabOrder = 0
        ReadOnlyAlways = False
        Width = 121
      end
      object snDBMaskEdit1: TsnDBMaskEdit
        Left = 295
        Top = 20
        DataBinding.DataField = 'hora_desde'
        DataBinding.DataSource = DSInput
        ParentFont = False
        Properties.EditMask = '!90:00;1;_'
        Properties.MaxLength = 0
        Style.Font.Charset = DEFAULT_CHARSET
        Style.Font.Color = clWindowText
        Style.Font.Height = -16
        Style.Font.Name = 'MS Sans Serif'
        Style.Font.Style = []
        Style.IsFontAssigned = True
        TabOrder = 1
        Width = 84
      end
      object snDBDateEdit2: TsnDBDateEdit
        Left = 560
        Top = 20
        DataBinding.DataField = 'fec_hasta'
        DataBinding.DataSource = DSInput
        ParentFont = False
        Style.Font.Charset = DEFAULT_CHARSET
        Style.Font.Color = clWindowText
        Style.Font.Height = -16
        Style.Font.Name = 'MS Sans Serif'
        Style.Font.Style = []
        Style.IsFontAssigned = True
        TabOrder = 2
        ReadOnlyAlways = False
        Width = 121
      end
      object snDBMaskEdit2: TsnDBMaskEdit
        Left = 679
        Top = 20
        DataBinding.DataField = 'hora_hasta'
        DataBinding.DataSource = DSInput
        ParentFont = False
        Properties.EditMask = '!90:00;1;_'
        Properties.MaxLength = 0
        Style.Font.Charset = DEFAULT_CHARSET
        Style.Font.Color = clWindowText
        Style.Font.Height = -16
        Style.Font.Name = 'MS Sans Serif'
        Style.Font.Style = []
        Style.IsFontAssigned = True
        TabOrder = 3
        Width = 84
      end
      object snDBLookup1: TsnDBLookup
        Left = 176
        Top = 60
        DataBinding.DataField = 'tipo_acceso'
        DataBinding.DataSource = DSInput
        ParentFont = False
        Properties.KeyFieldNames = 'codigo'
        Properties.ListColumns = <
          item
            FieldName = 'descripcion'
          end>
        Properties.ListOptions.ShowHeader = False
        Properties.ListSource = DSTTiposAccesosInternos
        Style.Font.Charset = DEFAULT_CHARSET
        Style.Font.Color = clWindowText
        Style.Font.Height = -16
        Style.Font.Name = 'MS Sans Serif'
        Style.Font.Style = []
        Style.IsFontAssigned = True
        TabOrder = 4
        Width = 201
      end
    end
    object Panel4: TPanel
      Left = 0
      Top = 102
      Width = 808
      Height = 496
      Align = alClient
      BevelOuter = bvNone
      Color = clWindow
      TabOrder = 1
      object FranjaHoraria: TdxDBGridSN
        Left = 0
        Top = 0
        Width = 808
        Height = 496
        Align = alClient
        BorderWidth = 5
        Font.Charset = DEFAULT_CHARSET
        Font.Color = clWindowText
        Font.Height = -16
        Font.Name = 'MS Sans Serif'
        Font.Style = []
        ParentFont = False
        TabOrder = 0
        CriteriosPintarCelda = <
          item
            TipoPintadaCelda = tpcTodasLasColumnas
            FieldName1 = 'baja'
            TipoCondFiltro1 = tcfIgual
            Valor1 = 'true'
            TipoCondFiltro2 = tcfIgual
            Color = clRed
          end>
        object cxGridDBTableView1: TcxGridDBTableView
          NavigatorButtons.ConfirmDelete = False
          DataController.DataSource = DSCategPuedeHabilitar
          DataController.Options = [dcoAssignGroupingValues, dcoAssignMasterDetailKeys, dcoSaveExpanding, dcoGroupsAlwaysExpanded]
          DataController.Summary.DefaultGroupSummaryItems = <>
          DataController.Summary.FooterSummaryItems = <>
          DataController.Summary.SummaryGroups = <>
          OptionsBehavior.AlwaysShowEditor = True
          OptionsCustomize.ColumnFiltering = False
          OptionsCustomize.ColumnSorting = False
          OptionsData.CancelOnExit = False
          OptionsData.Deleting = False
          OptionsData.DeletingConfirmation = False
          OptionsData.Inserting = False
          OptionsView.CellAutoHeight = True
          OptionsView.GroupByBox = False
          object cxGridDBTableView1habilitar: TcxGridDBColumn
            Caption = 'Habilitar'
            DataBinding.FieldName = 'habilitar'
            HeaderAlignmentHorz = taCenter
            Width = 80
          end
          object cxGridDBTableView1grupo: TcxGridDBColumn
            DataBinding.FieldName = 'grupo'
            Visible = False
            GroupIndex = 0
            HeaderAlignmentHorz = taCenter
            Width = 263
            IsCaptionAssigned = True
          end
          object cxGridDBTableView1subgrupo: TcxGridDBColumn
            DataBinding.FieldName = 'subgrupo'
            Visible = False
            GroupIndex = 1
            HeaderAlignmentHorz = taCenter
            Width = 283
            IsCaptionAssigned = True
          end
          object cxGridDBTableView1desc_categ_acceso: TcxGridDBColumn
            Caption = 'Accesos Internos'
            DataBinding.FieldName = 'desc_categ_acceso'
            HeaderAlignmentHorz = taCenter
            Options.Editing = False
            Options.Focusing = False
            Width = 367
          end
        end
        object cxGridLevel1: TcxGridLevel
          GridView = cxGridDBTableView1
        end
      end
    end
  end
  inherited DriverABM: TDriverABM
    CargaDataSets = <
      item
        DataSet = TTiposAccesosInternos
        TableName = 'TTiposAccesosInternos'
      end
      item
        DataSet = TCategPuedeHabilitar
        TableName = 'TCategPuedeHabilitar'
      end
      item
        DataSet = THoraCIP
        TableName = 'THoraCIP'
      end>
  end
  inherited TOidObjSave: TsnTable
    Left = 640
    Top = 56
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
      'begin'
      ''
      '    snDBFecDesde.setFoco();'
      ''
      '    TraerHora();'
      ''
      '    TInput.Close; '
      '    TInput.Open;'
      '    TInput.AppendRecord; '
      ''
      '    operacion.InicioOperacion();'
      '    operacion.setOper('#39'TraerCategAccParaHabi'#39');'
      '    operacion.execute();'
      ''
      '    setAcepto(false);'
      ''
      'end.')
    OnNuevoRegistro = <
      item
        TableName = 'TInput'
        Source.Strings = (
          'begin'
          
            '  TInput.FieldName('#39'fec_desde'#39').Value := THoraCIP.FieldName('#39'fec' +
            'ha'#39').Value;'
          
            '  TInput.FieldName('#39'hora_desde'#39').Value := THoraCIP.FieldName('#39'ho' +
            'ra_minutos'#39').Value; '
          
            '  TInput.FieldName('#39'fec_hasta'#39').Value := THoraCIP.FieldName('#39'fec' +
            'ha'#39').Value;'
          '  TInput.FieldName('#39'hora_hasta'#39').Value := '#39'23:59'#39'; '
          'end.')
      end>
    OnPublicVariable = <
      item
        VariableName = 'TValorAcepto'
      end
      item
        VariableName = 'TInput'
      end
      item
        VariableName = 'TCategPuedeHabilitar'
      end>
    OnInicializar = <
      item
        Source.Strings = (
          'begin'
          '  Inicializar();'
          'end.')
      end>
    OnFormFunction = <
      item
        Source.Strings = (
          'procedure Inicializar();'
          'begin'
          ''
          '  operacion.InicioOperacion();'
          '  operacion.setOper('#39'TraerTiposAccesosInternos'#39');'
          '  operacion.execute();'
          ''
          'end;'
          ''
          'procedure setAcepto(acepto : boolean);'
          'begin'
          ''
          '  TValorAcepto.Close;'
          '  TValorAcepto.Open;'
          '  TValorAcepto.AppendRecord; '
          '  TValorAcepto.FieldName('#39'acepto'#39').AsBoolean := acepto;'
          '  TValorAcepto.PostRecord;'
          ''
          'end;'
          ''
          'procedure ValidarCarga();'
          'var'
          '  habilitoAcceso : boolean;'
          'begin'
          ''
          '  TInput.PostRecord;'
          '  TCategPuedeHabilitar.PostRecord;'
          ''
          '  if (TInput.FieldName('#39'hora_desde'#39').AsString  = '#39#39')'
          
            '     then raiseException(erCustomError,'#39'Debe ingresar la hora de' +
            'sde.'#39'); '
          ''
          '  if (TInput.FieldName('#39'hora_hasta'#39').AsString  = '#39#39')'
          
            '     then raiseException(erCustomError,'#39'Debe ingresar la hora ha' +
            'sta.'#39'); '
          ''
          '  if (TInput.FieldName('#39'tipo_acceso'#39').AsString  = '#39#39')'
          
            '     then raiseException(erCustomError,'#39'Debe ingresar el Permiso' +
            '.'#39'); '
          ''
          '  if (TInput.FieldName('#39'fec_desde'#39').IsNull)'
          
            '     then raiseException(erCustomError,'#39'Debe ingresar la fecha D' +
            'esde.'#39');'
          ''
          '  if (TInput.FieldName('#39'fec_hasta'#39').IsNull)'
          
            '     then raiseException(erCustomError,'#39'Debe ingresar la fecha H' +
            'asta.'#39');'
          ''
          '  habilitoAcceso := false; '
          ''
          '  TCategPuedeHabilitar.First;'
          '  while (not TCategPuedeHabilitar.EOF) do'
          '     begin'
          ''
          ''
          '     if (TCategPuedeHabilitar.FieldName('#39'habilitar'#39').AsBoolean)'
          '        then habilitoAcceso := true;  '
          ''
          '     TCategPuedeHabilitar.next;'
          '     end; '
          ''
          '  if (habilitoAcceso = false)'
          '     then begin'
          
            '          if (mensaje.question('#39'No se habilit'#243' ning'#250'n acceso int' +
            'erno. Desea continuar?'#39')=false)'
          '             then abort;'
          '          end;'
          ' '
          ''
          'end;'
          ''
          ''
          'procedure TraerHora();'
          'begin'
          '  operacion.InicioOperacion();'
          '  operacion.setOper('#39'TraerQueHoraEsCIP'#39');'
          ' operacion.execute();'
          'end;')
      end>
    OnClickToolButton = <
      item
        ButtonName = 'BotonCancelar'
        Source.Strings = (
          'begin'
          '  setAcepto(false);'
          '  close;'
          'end.')
      end
      item
        ButtonName = 'BotonAceptar'
        Source.Strings = (
          'begin'
          '  ValidarCarga();'
          '  setAcepto(true);'
          '  close;'
          'end.')
      end>
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
    Left = 144
    Top = 200
    object TInputtipo_acceso: TStringField
      FieldName = 'tipo_acceso'
    end
    object TInputfec_desde: TDateField
      FieldName = 'fec_desde'
    end
    object TInputhora_desde: TStringField
      FieldName = 'hora_desde'
      Size = 5
    end
    object TInputfec_hasta: TDateField
      FieldName = 'fec_hasta'
    end
    object TInputhora_hasta: TStringField
      FieldName = 'hora_hasta'
      Size = 5
    end
  end
  object DSInput: TDataSource
    DataSet = TInput
    Left = 176
    Top = 200
  end
  object TTiposAccesosInternos: TsnTable
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
    Left = 192
    Top = 358
    object TTiposAccesosInternoscodigo: TStringField
      FieldName = 'codigo'
      Size = 50
    end
    object TTiposAccesosInternosdescripcion: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
  end
  object DSTTiposAccesosInternos: TDataSource
    DataSet = TTiposAccesosInternos
    Left = 224
    Top = 358
  end
  object TCategPuedeHabilitar: TsnTable
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
    Left = 192
    Top = 438
    object TCategPuedeHabilitaroid_categ_acceso: TIntegerField
      FieldName = 'oid_categ_acceso'
    end
    object TCategPuedeHabilitarcod_categ_acceso: TStringField
      FieldName = 'cod_categ_acceso'
      Size = 50
    end
    object TCategPuedeHabilitardesc_categ_acceso: TStringField
      FieldName = 'desc_categ_acceso'
      Size = 100
    end
    object TCategPuedeHabilitargrupo: TStringField
      FieldName = 'grupo'
      Size = 100
    end
    object TCategPuedeHabilitarsubgrupo: TStringField
      FieldName = 'subgrupo'
      Size = 100
    end
    object TCategPuedeHabilitarhabilitar: TBooleanField
      FieldName = 'habilitar'
    end
  end
  object DSCategPuedeHabilitar: TDataSource
    DataSet = TCategPuedeHabilitar
    Left = 224
    Top = 438
  end
  object TValorAcepto: TsnTable
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
    Left = 640
    Top = 94
    object TValorAceptoacepto: TBooleanField
      FieldName = 'acepto'
    end
  end
  object THoraCIP: TsnTable
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
    Left = 536
    Top = 328
    object THoraCIPhora: TStringField
      FieldName = 'hora'
      Size = 100
    end
    object THoraCIPfecha: TDateField
      FieldName = 'fecha'
    end
    object THoraCIPhora_minutos: TStringField
      FieldName = 'hora_minutos'
      Size = 5
    end
  end
end
