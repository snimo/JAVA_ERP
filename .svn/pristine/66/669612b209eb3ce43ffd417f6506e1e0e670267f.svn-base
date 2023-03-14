inherited FConsCartasRemitidas: TFConsCartasRemitidas
  Top = 157
  Width = 879
  Height = 767
  Caption = 'Consultas de Cartas Remitidas'
  PixelsPerInch = 96
  TextHeight = 13
  object Panel1: TPanel [0]
    Left = 0
    Top = 0
    Width = 863
    Height = 97
    Align = alTop
    BevelOuter = bvNone
    Color = clWindow
    TabOrder = 0
    object Label1: TLabel
      Left = 20
      Top = 17
      Width = 82
      Height = 16
      Caption = 'Fecha Desde'
      Font.Charset = DEFAULT_CHARSET
      Font.Color = clWindowText
      Font.Height = -13
      Font.Name = 'MS Sans Serif'
      Font.Style = []
      ParentFont = False
    end
    object Label2: TLabel
      Left = 252
      Top = 17
      Width = 77
      Height = 16
      Caption = 'Fecha Hasta'
      Font.Charset = DEFAULT_CHARSET
      Font.Color = clWindowText
      Font.Height = -13
      Font.Name = 'MS Sans Serif'
      Font.Style = []
      ParentFont = False
    end
    object Label3: TLabel
      Left = 476
      Top = 17
      Width = 89
      Height = 16
      Caption = 'Tipo de Causa'
      Font.Charset = DEFAULT_CHARSET
      Font.Color = clWindowText
      Font.Height = -13
      Font.Name = 'MS Sans Serif'
      Font.Style = []
      ParentFont = False
    end
    object ImageBuscar: TImage
      Left = 765
      Top = 5
      Width = 32
      Height = 32
      Cursor = crHandPoint
      Hint = 'Ejecutar Consulta '
      ParentShowHint = False
      ShowHint = True
    end
    object ImageSalir: TImage
      Tag = 7
      Left = 805
      Top = 5
      Width = 32
      Height = 32
      Cursor = crHandPoint
      Hint = 'Salir'
      ParentShowHint = False
      ShowHint = True
    end
    object Label4: TLabel
      Left = 20
      Top = 41
      Width = 132
      Height = 16
      Caption = 'Nro. Carta Documento'
      Font.Charset = DEFAULT_CHARSET
      Font.Color = clWindowText
      Font.Height = -13
      Font.Name = 'MS Sans Serif'
      Font.Style = []
      ParentFont = False
    end
    object Label5: TLabel
      Left = 308
      Top = 41
      Width = 39
      Height = 16
      Caption = 'Causa'
      Font.Charset = DEFAULT_CHARSET
      Font.Color = clWindowText
      Font.Height = -13
      Font.Name = 'MS Sans Serif'
      Font.Style = []
      ParentFont = False
    end
    object Label6: TLabel
      Left = 556
      Top = 41
      Width = 92
      Height = 16
      Caption = 'Observaciones'
      Font.Charset = DEFAULT_CHARSET
      Font.Color = clWindowText
      Font.Height = -13
      Font.Name = 'MS Sans Serif'
      Font.Style = []
      ParentFont = False
    end
    object Label7: TLabel
      Left = 20
      Top = 65
      Width = 42
      Height = 16
      Caption = 'Legajo'
      Font.Charset = DEFAULT_CHARSET
      Font.Color = clWindowText
      Font.Height = -13
      Font.Name = 'MS Sans Serif'
      Font.Style = []
      ParentFont = False
    end
    object snDBDateEdit1: TsnDBDateEdit
      Left = 112
      Top = 13
      DataBinding.DataField = 'fec_desde'
      DataBinding.DataSource = DSInput
      ParentFont = False
      Style.Font.Charset = DEFAULT_CHARSET
      Style.Font.Color = clWindowText
      Style.Font.Height = -13
      Style.Font.Name = 'MS Sans Serif'
      Style.Font.Style = []
      Style.IsFontAssigned = True
      TabOrder = 0
      ReadOnlyAlways = False
      Width = 121
    end
    object snDBDateEdit2: TsnDBDateEdit
      Left = 336
      Top = 13
      DataBinding.DataField = 'fec_hasta'
      DataBinding.DataSource = DSInput
      ParentFont = False
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
    object snDBLookup1: TsnDBLookup
      Left = 569
      Top = 12
      DataBinding.DataField = 'oid_tipo_causa'
      DataBinding.DataSource = DSInput
      ParentFont = False
      Properties.KeyFieldNames = 'oid'
      Properties.ListColumns = <
        item
          FieldName = 'descripcion'
        end>
      Properties.ListOptions.ShowHeader = False
      Properties.ListSource = DSTTiposCausas
      Style.Font.Charset = DEFAULT_CHARSET
      Style.Font.Color = clWindowText
      Style.Font.Height = -13
      Style.Font.Name = 'MS Sans Serif'
      Style.Font.Style = []
      Style.IsFontAssigned = True
      TabOrder = 2
      Width = 193
    end
    object snDBEdit1: TsnDBEdit
      Left = 160
      Top = 39
      DataBinding.DataField = 'nro_carta_documento'
      DataBinding.DataSource = DSInput
      TabOrder = 3
      Width = 129
    end
    object snDBEdit2: TsnDBEdit
      Left = 352
      Top = 39
      DataBinding.DataField = 'causa'
      DataBinding.DataSource = DSInput
      TabOrder = 4
      Width = 185
    end
    object snDBEdit3: TsnDBEdit
      Left = 656
      Top = 39
      DataBinding.DataField = 'observaciones'
      DataBinding.DataSource = DSInput
      TabOrder = 5
      Width = 185
    end
    object srnDBButtonEdit1: TsrnDBButtonEdit
      Left = 160
      Top = 64
      DataBinding.DataField = 'nro_legajo'
      DataBinding.DataSource = DSInput
      ParentFont = False
      Properties.Buttons = <
        item
          Default = True
          Kind = bkEllipsis
        end>
      Properties.ClickKey = 112
      Style.Font.Charset = DEFAULT_CHARSET
      Style.Font.Color = clWindowText
      Style.Font.Height = -13
      Style.Font.Name = 'MS Sans Serif'
      Style.Font.Style = []
      Style.IsFontAssigned = True
      TabOrder = 6
      Help = HelpLegajos
      Width = 121
    end
    object snDBEdit4: TsnDBEdit
      Left = 278
      Top = 64
      TabStop = False
      DataBinding.DataField = 'ape_y_nom'
      DataBinding.DataSource = DSInput
      ParentFont = False
      Properties.ReadOnly = True
      Style.Font.Charset = DEFAULT_CHARSET
      Style.Font.Color = clWindowText
      Style.Font.Height = -13
      Style.Font.Name = 'MS Sans Serif'
      Style.Font.Style = []
      Style.IsFontAssigned = True
      TabOrder = 7
      Width = 563
    end
  end
  object Panel2: TPanel [1]
    Left = 0
    Top = 97
    Width = 863
    Height = 632
    Align = alClient
    Color = clWindow
    TabOrder = 1
    object PageControl1: TPageControl
      Left = 1
      Top = 1
      Width = 861
      Height = 630
      ActivePage = TabSheet1
      Align = alClient
      TabOrder = 0
      object TabSheet1: TTabSheet
        Caption = 'Detalle de Cartas'
        object dxGrillaSECLOS: TdxDBGridSN
          Left = 0
          Top = 0
          Width = 853
          Height = 602
          Align = alClient
          TabOrder = 0
          LookAndFeel.Kind = lfFlat
          AllowInsert = False
          CriteriosPintarCelda = <>
          object dxGrillaSECLOSDBTableViewRequisiciones: TcxGridDBTableView
            NavigatorButtons.ConfirmDelete = False
            FilterBox.Visible = fvAlways
            DataController.Filter.Active = True
            DataController.Filter.AutoDataSetFilter = True
            DataController.Summary.DefaultGroupSummaryItems = <>
            DataController.Summary.FooterSummaryItems = <>
            DataController.Summary.SummaryGroups = <>
            OptionsBehavior.GoToNextCellOnEnter = True
            OptionsBehavior.IncSearch = True
            OptionsCustomize.ColumnsQuickCustomization = True
            OptionsData.CancelOnExit = False
            OptionsData.Deleting = False
            OptionsData.DeletingConfirmation = False
            OptionsData.Inserting = False
            OptionsView.CellAutoHeight = True
          end
          object dxGrillaSECLOSBandedTableView1: TcxGridBandedTableView
            NavigatorButtons.ConfirmDelete = False
            DataController.Summary.DefaultGroupSummaryItems = <>
            DataController.Summary.FooterSummaryItems = <>
            DataController.Summary.SummaryGroups = <>
            Bands = <
              item
              end>
          end
          object dxGrillaSECLOSDBBandedTableView: TcxGridDBBandedTableView
            NavigatorButtons.ConfirmDelete = False
            DataController.DataSource = DSConsultasCartas
            DataController.Options = [dcoAssignGroupingValues, dcoAssignMasterDetailKeys, dcoSaveExpanding, dcoGroupsAlwaysExpanded]
            DataController.Summary.DefaultGroupSummaryItems = <
              item
                Format = '###,###,###,###.##'
                Kind = skSum
                Position = spFooter
              end
              item
                Format = '###,###,###,###.##'
                Kind = skSum
                Position = spFooter
              end
              item
                Format = '###,###,###,###.##'
                Kind = skSum
                Position = spFooter
              end
              item
                Format = '###,###,###,###.##'
                Kind = skSum
                Position = spFooter
              end
              item
                Format = '###,###,###,###.##'
                Kind = skSum
                Position = spFooter
              end
              item
                Format = '###,###,###,###.##'
                Kind = skSum
                Position = spFooter
              end
              item
                Format = '###,###,###,###.##'
                Kind = skSum
                Position = spFooter
              end
              item
                Format = '###,###,###,###.##'
                Kind = skSum
                Position = spFooter
              end
              item
                Format = '###,###,###,###.##'
                Kind = skSum
                Position = spFooter
              end>
            DataController.Summary.FooterSummaryItems = <
              item
                Format = '###,###,###,###.##'
                Kind = skSum
              end
              item
                Format = '###,###,###,###.##'
                Kind = skSum
              end
              item
                Format = '###,###,###,###.##'
                Kind = skSum
              end
              item
                Format = '###,###,###,###.##'
                Kind = skSum
              end
              item
                Format = '###,###,###,###.##'
                Kind = skSum
              end
              item
                Format = '###,###,###,###.##'
                Kind = skSum
              end
              item
                Format = '###,###,###,###.##'
                Kind = skSum
              end
              item
                Format = '###,###,###,###.##'
                Kind = skSum
              end>
            DataController.Summary.SummaryGroups = <>
            OptionsBehavior.FocusCellOnTab = True
            OptionsBehavior.FocusFirstCellOnNewRecord = True
            OptionsBehavior.FocusCellOnCycle = True
            OptionsCustomize.ColumnsQuickCustomization = True
            OptionsCustomize.BandsQuickCustomization = True
            OptionsData.CancelOnExit = False
            OptionsData.Deleting = False
            OptionsData.DeletingConfirmation = False
            OptionsData.Editing = False
            OptionsData.Inserting = False
            OptionsView.CellAutoHeight = True
            OptionsView.Footer = True
            OptionsView.GroupByBox = False
            OptionsView.GroupFooters = gfAlwaysVisible
            OptionsView.GroupSummaryLayout = gslAlignWithColumns
            Bands = <
              item
                Caption = 'Legajos'
                FixedKind = fkLeft
                Width = 556
              end
              item
                Caption = 'Cartas Remitidas'
              end>
            object dxGrillaSECLOSDBBandedTableViewnro_legajo: TcxGridDBBandedColumn
              Caption = 'Nro. Legajo'
              DataBinding.FieldName = 'nro_legajo'
              HeaderAlignmentHorz = taCenter
              Width = 77
              Position.BandIndex = 0
              Position.ColIndex = 0
              Position.RowIndex = 0
            end
            object dxGrillaSECLOSDBBandedTableViewape_y_nom: TcxGridDBBandedColumn
              Caption = 'Apellido y Nombre'
              DataBinding.FieldName = 'ape_y_nom'
              HeaderAlignmentHorz = taCenter
              Width = 152
              Position.BandIndex = 0
              Position.ColIndex = 1
              Position.RowIndex = 0
            end
            object dxGrillaSECLOSDBBandedTableViewempresa: TcxGridDBBandedColumn
              Caption = 'Empresa'
              DataBinding.FieldName = 'empresa'
              HeaderAlignmentHorz = taCenter
              HeaderAlignmentVert = vaCenter
              Width = 102
              Position.BandIndex = 0
              Position.ColIndex = 2
              Position.RowIndex = 0
            end
            object dxGrillaSECLOSDBBandedTableViewsector: TcxGridDBBandedColumn
              Caption = 'Sector'
              DataBinding.FieldName = 'sector'
              HeaderAlignmentHorz = taCenter
              Width = 103
              Position.BandIndex = 0
              Position.ColIndex = 3
              Position.RowIndex = 0
            end
            object dxGrillaSECLOSDBBandedTableViewpuesto: TcxGridDBBandedColumn
              Caption = 'Puesto'
              DataBinding.FieldName = 'puesto'
              HeaderAlignmentHorz = taCenter
              Width = 102
              Position.BandIndex = 0
              Position.ColIndex = 4
              Position.RowIndex = 0
            end
            object dxGrillaSECLOSDBBandedTableViewestado: TcxGridDBBandedColumn
              Caption = 'Estado'
              DataBinding.FieldName = 'estado'
              HeaderAlignmentHorz = taCenter
              Width = 20
              Position.BandIndex = 0
              Position.ColIndex = 5
              Position.RowIndex = 0
            end
            object dxGrillaSECLOSDBBandedTableViewnro_carta: TcxGridDBBandedColumn
              Caption = 'Nro. Carta'
              DataBinding.FieldName = 'nro_carta'
              HeaderAlignmentHorz = taCenter
              Width = 95
              Position.BandIndex = 1
              Position.ColIndex = 0
              Position.RowIndex = 0
            end
            object dxGrillaSECLOSDBBandedTableViewfecha: TcxGridDBBandedColumn
              Caption = 'Fecha'
              DataBinding.FieldName = 'fecha'
              HeaderAlignmentHorz = taCenter
              Width = 95
              Position.BandIndex = 1
              Position.ColIndex = 1
              Position.RowIndex = 0
            end
            object dxGrillaSECLOSDBBandedTableViewColumn1: TcxGridDBBandedColumn
              Caption = 'Tipo de Causa'
              DataBinding.FieldName = 'desc_tipo_causa'
              HeaderAlignmentHorz = taCenter
              Width = 150
              Position.BandIndex = 1
              Position.ColIndex = 2
              Position.RowIndex = 0
            end
            object dxGrillaSECLOSDBBandedTableViewcausa: TcxGridDBBandedColumn
              Caption = 'Causa'
              DataBinding.FieldName = 'causa'
              HeaderAlignmentHorz = taCenter
              Width = 200
              Position.BandIndex = 1
              Position.ColIndex = 3
              Position.RowIndex = 0
            end
            object dxGrillaSECLOSDBBandedTableViewrecibida: TcxGridDBBandedColumn
              Caption = 'Recibida'
              DataBinding.FieldName = 'recibida'
              HeaderAlignmentHorz = taCenter
              Position.BandIndex = 1
              Position.ColIndex = 4
              Position.RowIndex = 0
            end
            object dxGrillaSECLOSDBBandedTableViewobservaciones: TcxGridDBBandedColumn
              Caption = 'Observaciones'
              DataBinding.FieldName = 'observaciones'
              HeaderAlignmentHorz = taCenter
              Width = 300
              Position.BandIndex = 1
              Position.ColIndex = 5
              Position.RowIndex = 0
            end
          end
          object dxGrillaSECLOSLevel1: TcxGridLevel
            GridView = dxGrillaSECLOSDBBandedTableView
          end
        end
      end
    end
  end
  inherited DriverABM: TDriverABM
    CargaDataSets = <
      item
        DataSet = TConsultaCartas
        TableName = 'TConsultaCartas'
      end>
    Left = 32
    Top = 160
  end
  inherited Operacion: TOperacion
    Left = 72
    Top = 160
  end
  inherited dxComponentPrinter: TdxComponentPrinter
    Left = 112
    Top = 160
    inherited dxComponentPrinterLink1: TdxCustomContainerReportLink
      Component = Owner
      BuiltInReportLink = True
      HiddenComponents = {}
      ExcludedComponents = {}
      AggregatedReportLinks = {}
    end
  end
  inherited SaveDialog: TSaveDialog
    Left = 152
    Top = 160
  end
  inherited DriverEvent: TDriverEvent
    OnShow.Strings = (
      'begin'
      '  snDBDateEdit1.setFoco();'
      'end.')
    OnValidate = <
      item
        TableName = 'TInput'
        FieldName = 'nro_legajo'
        Source.Strings = (
          'begin'
          '  ValidarLegajo.Value := Sender.AsString;'
          '  ValidarLegajo.Validar();'
          'end.')
      end>
    OnInicializar = <
      item
        Source.Strings = (
          'begin'
          ''
          '  TTiposCausas.loadFromHelp('#39'HelpTipoCausaLegales'#39');'
          ''
          '  TInput.Close();'
          '  TInput.Open();'
          '  TInput.AppendRecord();'
          ''
          '  varios.setImagen('#39'ImageBuscar'#39',0);'
          '  varios.setImagen('#39'ImageSalir'#39',7);'
          ''
          'end.')
      end>
    OnFormFunction = <
      item
        Source.Strings = (
          ''
          'procedure traerConsulta();'
          'begin'
          ''
          '  TInput.PostRecord();'
          ''
          '  if (TInput.FieldName('#39'fec_desde'#39').IsNull)'
          
            '     then raiseException(erCustomError,'#39'Debe ingresar la Fecha D' +
            'esde'#39');'
          ''
          '  if (TInput.FieldName('#39'fec_hasta'#39').IsNull)'
          
            '     then raiseException(erCustomError,'#39'Debe ingresar la Fecha H' +
            'asta'#39');'
          ''
          '  operacion.InicioOperacion();'
          '  operacion.setOper('#39'TraerCartasRemitidas'#39');'
          
            '  operacion.AddAtribute('#39'fec_desde'#39',TInput.FieldName('#39'fec_desde'#39 +
            ').AsString);'
          
            '  operacion.AddAtribute('#39'fec_hasta'#39',TInput.FieldName('#39'fec_hasta'#39 +
            ').AsString);'
          ''
          ''
          '  if (TInput.FieldName('#39'oid_tipo_causa'#39').AsInteger<>0)'
          
            '     then operacion.AddAtribute('#39'oid_tipo_causa'#39',TInput.FieldNam' +
            'e('#39'oid_tipo_causa'#39').AsString);'
          ''
          '  if (TInput.FieldName('#39'nro_carta_documento'#39').AsString<>'#39#39')'
          
            '     then operacion.AddAtribute('#39'nro_carta_documento'#39',TInput.Fie' +
            'ldName('#39'nro_carta_documento'#39').AsString);'
          ''
          '  if (TInput.FieldName('#39'causa'#39').AsString<>'#39#39')'
          
            '     then operacion.AddAtribute('#39'causa'#39',TInput.FieldName('#39'causa'#39 +
            ').AsString);'
          ''
          '  if (TInput.FieldName('#39'observaciones'#39').AsString<>'#39#39')'
          
            '     then operacion.AddAtribute('#39'observaciones'#39',TInput.FieldName' +
            '('#39'observaciones'#39').AsString);'
          ''
          '  if (TInput.FieldName('#39'oid_legajo'#39').AsInteger<>0)'
          
            '     then operacion.AddAtribute('#39'oid_legajo'#39',TInput.FieldName('#39'o' +
            'id_legajo'#39').AsString);'
          ''
          '  operacion.execute();'
          ''
          'end;')
      end>
    OnClickToolButton = <
      item
        ButtonName = 'ImageSalir'
        Source.Strings = (
          'begin'
          '  Close();'
          'end.')
      end
      item
        ButtonName = 'ImageBuscar'
        Source.Strings = (
          'begin'
          '  traerConsulta();'
          'end.')
      end>
    Left = 192
    Top = 163
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
    Left = 592
    Top = 161
    object TInputfec_desde: TDateField
      FieldName = 'fec_desde'
    end
    object TInputfec_hasta: TDateField
      FieldName = 'fec_hasta'
    end
    object TInputoid_tipo_causa: TIntegerField
      FieldName = 'oid_tipo_causa'
    end
    object TInputnro_carta_documento: TStringField
      FieldName = 'nro_carta_documento'
      Size = 50
    end
    object TInputcausa: TStringField
      FieldName = 'causa'
      Size = 100
    end
    object TInputobservaciones: TStringField
      FieldName = 'observaciones'
      Size = 100
    end
    object TInputoid_legajo: TIntegerField
      FieldName = 'oid_legajo'
    end
    object TInputnro_legajo: TStringField
      FieldName = 'nro_legajo'
      Size = 50
    end
    object TInputape_y_nom: TStringField
      FieldName = 'ape_y_nom'
      Size = 200
    end
  end
  object DSInput: TDataSource
    DataSet = TInput
    Left = 648
    Top = 185
  end
  object TTipos: TsnTable
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
    Left = 528
    Top = 305
    object TTiposcodigo: TStringField
      FieldName = 'codigo'
      Size = 50
    end
    object TTiposdescripcion: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
  end
  object DSTipos: TDataSource
    DataSet = TTipos
    Left = 568
    Top = 305
  end
  object Varios: TsnVarios
    Operacion = Operacion
    Left = 488
    Top = 148
  end
  object TConsultaCartas: TsnTable
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
    Left = 109
    Top = 235
    object TConsultaCartasoid_carta: TIntegerField
      FieldName = 'oid_carta'
    end
    object TConsultaCartasoid_legajo: TIntegerField
      FieldName = 'oid_legajo'
    end
    object TConsultaCartasnro_legajo: TStringField
      FieldName = 'nro_legajo'
      Size = 50
    end
    object TConsultaCartasape_y_nom: TStringField
      FieldName = 'ape_y_nom'
      Size = 100
    end
    object TConsultaCartasempresa: TStringField
      FieldName = 'empresa'
      Size = 250
    end
    object TConsultaCartassector: TStringField
      FieldName = 'sector'
      Size = 250
    end
    object TConsultaCartaspuesto: TStringField
      FieldName = 'puesto'
      Size = 250
    end
    object TConsultaCartasestado: TStringField
      FieldName = 'estado'
      Size = 10
    end
    object TConsultaCartasnro_carta: TStringField
      FieldName = 'nro_carta'
      Size = 100
    end
    object TConsultaCartasfecha: TDateField
      FieldName = 'fecha'
    end
    object TConsultaCartasoid_tipo_causa: TIntegerField
      FieldName = 'oid_tipo_causa'
    end
    object TConsultaCartascausa: TStringField
      FieldName = 'causa'
      Size = 5000
    end
    object TConsultaCartasrecibida: TDateField
      FieldName = 'recibida'
    end
    object TConsultaCartasobservaciones: TStringField
      FieldName = 'observaciones'
      Size = 5000
    end
    object TConsultaCartasdesc_tipo_causa: TStringField
      FieldName = 'desc_tipo_causa'
      Size = 100
    end
  end
  object DSConsultasCartas: TDataSource
    DataSet = TConsultaCartas
    Left = 141
    Top = 235
  end
  object cxStyleRepository1: TcxStyleRepository
    PixelsPerInch = 96
    object cxStyle1: TcxStyle
      AssignedValues = [svFont]
      Font.Charset = DEFAULT_CHARSET
      Font.Color = clWindowText
      Font.Height = -12
      Font.Name = 'MS Sans Serif'
      Font.Style = [fsBold]
    end
  end
  object HelpTipoCausaLegales: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'leg.TipoCausaLegales'
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
    AnchoHelp = 600
    ActivarCache = True
    ShowBotonBuscar = False
    Left = 218
    Top = 369
  end
  object TTiposCausas: TsnTable
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
    Left = 250
    Top = 369
    object TTiposCausasoid: TIntegerField
      FieldName = 'oid'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TTiposCausascodigo: TStringField
      FieldName = 'codigo'
      Size = 50
    end
    object TTiposCausasdescripcion: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
  end
  object DSTTiposCausas: TDataSource
    DataSet = TTiposCausas
    Left = 285
    Top = 371
  end
  object HelpLegajos: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'su.Legajo'
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
        AsignarACampo = TInputnro_legajo
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
    Titulo = 'Legajos'
    AnchoHelp = 600
    ActivarCache = False
    ShowBotonBuscar = False
    Left = 50
    Top = 425
  end
  object ValidarLegajo: TValidador
    Operacion = Operacion
    NickNameObjLog = 'su.Legajo'
    MensajeException = 'C'#243'digo de Legajo Inexistente'
    CampoOID = TInputoid_legajo
    CampoDescripcion = TInputape_y_nom
    NroQuery = 0
    Cache = False
    Left = 78
    Top = 425
  end
end
