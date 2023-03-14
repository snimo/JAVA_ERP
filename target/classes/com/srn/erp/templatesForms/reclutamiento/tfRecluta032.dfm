inherited FRecluConsRecepcion: TFRecluConsRecepcion
  Left = 53
  Top = 0
  Width = 984
  Height = 574
  Caption = 'Consulta Recepci'#243'n'
  Position = poScreenCenter
  PixelsPerInch = 96
  TextHeight = 13
  object Panel1: TPanel [0]
    Left = 0
    Top = 0
    Width = 968
    Height = 160
    Align = alTop
    Color = clWindow
    TabOrder = 0
    object Label1: TLabel
      Left = 32
      Top = 24
      Width = 96
      Height = 20
      Caption = 'Fecha Desde'
      Font.Charset = DEFAULT_CHARSET
      Font.Color = clWindowText
      Font.Height = -16
      Font.Name = 'MS Sans Serif'
      Font.Style = []
      ParentFont = False
    end
    object Label2: TLabel
      Left = 336
      Top = 24
      Width = 92
      Height = 20
      Caption = 'Fecha Hasta'
      Font.Charset = DEFAULT_CHARSET
      Font.Color = clWindowText
      Font.Height = -16
      Font.Name = 'MS Sans Serif'
      Font.Style = []
      ParentFont = False
    end
    object Label3: TLabel
      Left = 32
      Top = 56
      Width = 50
      Height = 20
      Caption = 'Buscar'
      Font.Charset = DEFAULT_CHARSET
      Font.Color = clWindowText
      Font.Height = -16
      Font.Name = 'MS Sans Serif'
      Font.Style = []
      ParentFont = False
      Visible = False
    end
    object Label4: TLabel
      Left = 32
      Top = 136
      Width = 84
      Height = 16
      Caption = 'Seleccionado'
      Font.Charset = DEFAULT_CHARSET
      Font.Color = clWindowText
      Font.Height = -13
      Font.Name = 'MS Sans Serif'
      Font.Style = []
      ParentFont = False
    end
    object snDBDateEdit1: TsnDBDateEdit
      Left = 144
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
      Width = 130
    end
    object snDBDateEdit2: TsnDBDateEdit
      Left = 448
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
      TabOrder = 1
      ReadOnlyAlways = False
      Width = 130
    end
    object snDBEdit1: TsnDBEdit
      Left = 144
      Top = 52
      DataBinding.DataField = 'buscar'
      DataBinding.DataSource = DSInput
      ParentFont = False
      Style.Font.Charset = DEFAULT_CHARSET
      Style.Font.Color = clWindowText
      Style.Font.Height = -16
      Style.Font.Name = 'MS Sans Serif'
      Style.Font.Style = []
      Style.IsFontAssigned = True
      TabOrder = 2
      Visible = False
      Width = 361
    end
    object ImageBuscar: TsnButton
      Left = 670
      Top = 13
      Width = 197
      Height = 39
      Cursor = crHandPoint
      Hint = 'Consultar B'#250'squedas'
      Caption = 'Ejecutar Consultar '
      Font.Charset = DEFAULT_CHARSET
      Font.Color = clWindowText
      Font.Height = -13
      Font.Name = 'MS Sans Serif'
      Font.Style = []
      ParentFont = False
      TabOrder = 3
      Glyph.Data = {
        42080000424D4208000000000000420000002800000020000000200000000100
        10000300000000080000202E0000202E00000000000000000000007C0000E003
        00001F000000FF7FFF7FFF7FFF7FFF7FFF7FDF77D756F85EDF7BFF7FFF7FFF7F
        FF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FDF7B3A635C67FF7FFF7FFF7F
        FF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7F9D6F0B4680456039AA39B756FF7BFF7F
        FF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FDF7BF95AAA356139A3412E4ABE77FF7F
        FF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FF95EA53D267BA16EE04D6239AB399452
        BF77FF7FFF7FFF7FFF7FFF7FBF77B656AB396335E04DA26A806A40353A63FF7F
        FF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7F9D730E46B677AF7FE372A36A0052603D
        8835744EBF77FF7FDF77B652883560390052A36A467F467F625EA8399E73FF7F
        FF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7B2E4A546FF57F667F47770777C56A
        2156813DCB3D3146EC4182390052C46E477B687F897F487F2156C93DDF77FF7F
        FF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7F0E461167F67F687F897F8A7F697F
        497BE6724356A14122560673697B8A7F8A7F6A7F8A7F49770252EC41FF7BFF7F
        FF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7F724ED05EF87F8A7F8A7F8B7F8B7F
        8B7F6B7B2A7729774A7B8B7F8B7F8B7F8B7F8B7FAB7F4A77E24D514EFF7FFF7F
        FF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7F94568D56FA7FAE7FAC7FAD7FAD7F
        AD7FAD7FAD7FAD7FAD7FAD7FAD7FAD7FAD7FAD7F8D7F2A73C241724EFF7FFF7F
        FF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FD75A6C52FA7FD07FAD7FAE7FAE7F
        AE7FAE7FAE7FAE7FAE7FAE7FAE7FAE7FAE7FCE7FAE7F0A6F82399452FF7FFF7F
        FF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7F3A674C4EFA7FF37FCE7FD07FD07F
        D07FD07FD07FD07FD07FD07FD07FD07FD07FD07FB07B0A6FA43DD75AFF7FFF7F
        FF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7F7C6FEA45B87BF67FD07FD17FD17F
        D17FD17FD17FD17FD17FD17FD17FD17FD17FF27FB17BA86286395C6BFF7FFF7F
        FF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7F5D6744355173F77FD17FD27FD27F
        D27FD27FD27FD27FD27FD27FD27FD27FD27FF37FB17BC962232D1A63FF7FFF7F
        FF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FBE73AB356656F37FF47FF27FF27FF27F
        F27FF27FF27FF27FF27FF27FF27FF27FF27FF37FD27B2D6F254E88359E6FFF7F
        FF7FFF7FFF7FFF7FFF7FFF7FFF7FBF734731244EF47FF47FF37FF37FF37FF37F
        F37FF37FF37FF37FF37FF37FF37FF37FF37FF37FF37FB27B8F73445248317D6F
        FF7FFF7FFF7FFF7FFF7FFF7FDF7BCD39E349F27FF57FF37FF37FF37FF37FF37F
        F37FF37FF37FF37FF37FF37FF37FF37FF37FF37FF37FF47FB2736F73C2458B35
        DF7BFF7FFF7FFF7FFF7FFF7B8B35E145F27FF47FF27FF27FF27FF27FF27FF27F
        F27FF27FF27FF27FF27FF27FF27FF27FF27FF27FF27FF27FF27FB0776D6FE349
        8B35BF77FF7FFF7FFF7B3146A141AD7BF27FF07FF07FF07FF07FF07FF07FF07F
        F07FF07FF07FF07FF07FF07FF07FF07FF07FF07FF07FF07FF07FF07F8E732B6B
        A13DEF3DFF7BFF7FEE41803DCC7FEF7FCD7BCE7BCE7BCE7BCE7BCE7BCE7BCE7B
        CE7BCE7BCE7BCE7BCE7BCE7BCE7BCE7BCE7BCE7BCE7BCE7BCE7BCE7BEE7F8D77
        496BC24110461963C4418E77F37FCF7BCE7BCD7BCC7BCC7BCD7BCD7BCD7BCE7B
        CD7BCD7BCD7BCD7BCD7BCD7BCD7BCD7BCD7BCD7BCD7BCD7BCD7BCD7BEF7FF07F
        8E77696FC341D65AAF5AB67BD47FF57FF67FF67FF47FF27FF07BCD7BCB7BCC7B
        CD7BCD7BCD7BCD7BCD7BCD7BCD7BCD7BED7FEE7BEF7FEF7FF07FF07FEE7FEE7F
        CC7F066BA43DBE772F4AA639E7452852AB5A0D677173D47BF47FF77FF57FAD7B
        AB7BAD7BAD7BAD7BAD7BAD7BAD7BAD7BCD7FEE7FCC7FAB77286BA55E4452E349
        A43D85397352FF7FDF7B5B6BF85E9452314A0D46EA3DC73DE7454952DD7FFC7F
        A97BAA7BAB7BAB7BAB7BAB7BAB7B6B73C762034EA3418439A93DED41524E9552
        F85A7D6FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7F9E731963B656AC396D52FF7F
        D17F887B8B7B8A7B8A7BAB7F8A77076B6239AE35B756F95E9E73FF7FFF7FFF7F
        FF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FA9391167
        FE7F897B88778A778A77AA7B4973214EAB35DF7BFF7FFF7FFF7FFF7FFF7FFF7F
        FF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FB556A73D
        FE7FD47B66778977897B6977A46242391A5FFF7FFF7FFF7FFF7FFF7FFF7FFF7F
        FF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7F0E42
        F162FF7F6A776677697B076FA045AD39FF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7F
        FF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7F5B67
        E841FC7FD37F64774773835E65353B63FF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7F
        FF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7F
        AA396C52FF7F6C77E36AA0411042FF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7F
        FF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7F
        19638635DB7BD57F405643315B6BFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7F
        FF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7F
        FF7F94526E52CE7F4035534AFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7F
        FF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7F
        FF7FDF774F4A054A0D46BF77FF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7F
        FF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7F
        FF7FFF7FDE775B67FF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7F
        FF7FFF7FFF7F}
      LookAndFeel.Kind = lfOffice11
    end
    object BotonMarcarLlegoPersona: TsnButton
      Left = 31
      Top = 91
      Width = 201
      Height = 34
      Caption = 'Marcar que lleg'#243' la persona'
      Font.Charset = DEFAULT_CHARSET
      Font.Color = clWindowText
      Font.Height = -13
      Font.Name = 'MS Sans Serif'
      Font.Style = []
      ParentFont = False
      TabOrder = 4
      LookAndFeel.Kind = lfOffice11
    end
    object BotonAnularLLegoPersona: TsnButton
      Left = 439
      Top = 90
      Width = 201
      Height = 34
      Caption = 'Anular que lleg'#243' la persona'
      Font.Charset = DEFAULT_CHARSET
      Font.Color = clWindowText
      Font.Height = -13
      Font.Name = 'MS Sans Serif'
      Font.Style = []
      ParentFont = False
      TabOrder = 5
      LookAndFeel.Kind = lfOffice11
    end
    object BotonCompletoFormulario: TsnButton
      Left = 255
      Top = 90
      Width = 162
      Height = 34
      Caption = 'Complet'#243' Formulario'
      Font.Charset = DEFAULT_CHARSET
      Font.Color = clWindowText
      Font.Height = -13
      Font.Name = 'MS Sans Serif'
      Font.Style = []
      ParentFont = False
      TabOrder = 6
      LookAndFeel.Kind = lfOffice11
    end
    object BotonAnularLLenadoFormu: TsnButton
      Left = 663
      Top = 90
      Width = 210
      Height = 34
      Caption = 'Anular Llenado Formulario'
      Font.Charset = DEFAULT_CHARSET
      Font.Color = clWindowText
      Font.Height = -13
      Font.Name = 'MS Sans Serif'
      Font.Style = []
      ParentFont = False
      TabOrder = 7
      LookAndFeel.Kind = lfOffice11
    end
    object snDBCurrencyEdit1: TsnDBCurrencyEdit
      Left = 120
      Top = 132
      DataBinding.DataField = 'ape_y_nom'
      DataBinding.DataSource = DSConsultaRecepcion
      ParentFont = False
      Properties.ReadOnly = True
      Style.Font.Charset = DEFAULT_CHARSET
      Style.Font.Color = clWindowText
      Style.Font.Height = -13
      Style.Font.Name = 'MS Sans Serif'
      Style.Font.Style = []
      Style.IsFontAssigned = True
      TabOrder = 8
      ReadOnlyAlways = False
      Width = 385
    end
  end
  object Panel2: TPanel [1]
    Left = 0
    Top = 160
    Width = 968
    Height = 376
    Align = alClient
    Color = clWindow
    TabOrder = 1
    object dxDBGridSN4: TdxDBGridSN
      Left = 1
      Top = 1
      Width = 966
      Height = 374
      Align = alClient
      TabOrder = 0
      CriteriosPintarCelda = <
        item
          TipoPintadaCelda = tpcTodasLasColumnas
          FieldName1 = 'llego'
          TipoCondFiltro1 = tcfIgual
          Valor1 = 'SI'
          TipoCondFiltro2 = tcfIgual
          Color = 50176
        end>
      object cxGridDBTableView3: TcxGridDBTableView
        NavigatorButtons.ConfirmDelete = False
        DataController.Summary.DefaultGroupSummaryItems = <>
        DataController.Summary.FooterSummaryItems = <>
        DataController.Summary.SummaryGroups = <>
      end
      object cxGridDBBandedTableView3: TcxGridDBBandedTableView
        NavigatorButtons.ConfirmDelete = False
        DataController.Options = [dcoAssignGroupingValues, dcoAssignMasterDetailKeys, dcoSaveExpanding, dcoGroupsAlwaysExpanded]
        DataController.Summary.DefaultGroupSummaryItems = <>
        DataController.Summary.FooterSummaryItems = <
          item
            Format = '###,###,###,###,###.##'
            Kind = skSum
          end>
        DataController.Summary.SummaryGroups = <>
        OptionsData.Deleting = False
        OptionsData.DeletingConfirmation = False
        OptionsData.Editing = False
        OptionsData.Inserting = False
        OptionsView.CellAutoHeight = True
        OptionsView.Footer = True
        Bands = <
          item
          end>
      end
      object dxDBGridSN4DBTableView1: TcxGridDBTableView
        NavigatorButtons.ConfirmDelete = False
        DataController.DataSource = DSConsultaRecepcion
        DataController.Options = [dcoAssignGroupingValues, dcoAssignMasterDetailKeys, dcoSaveExpanding, dcoGroupsAlwaysExpanded, dcoImmediatePost]
        DataController.Summary.DefaultGroupSummaryItems = <>
        DataController.Summary.FooterSummaryItems = <>
        DataController.Summary.SummaryGroups = <>
        OptionsData.Deleting = False
        OptionsData.Inserting = False
        OptionsSelection.UnselectFocusedRecordOnExit = False
        OptionsView.Indicator = True
        Styles.Content = cxStyle1
        Styles.Header = cxStyle1
        object dxDBGridSN4DBTableView1empresa: TcxGridDBColumn
          Caption = 'Empresa'
          DataBinding.FieldName = 'empresa'
          Visible = False
          GroupIndex = 0
          Options.Editing = False
        end
        object dxDBGridSN4DBTableView1fecha: TcxGridDBColumn
          Caption = 'Fecha'
          DataBinding.FieldName = 'fecha'
          Visible = False
          GroupIndex = 1
          Options.Editing = False
        end
        object dxDBGridSN4DBTableView1nro_docu: TcxGridDBColumn
          Caption = 'Nro. Documento'
          DataBinding.FieldName = 'nro_docu'
          Options.Editing = False
          Width = 89
        end
        object dxDBGridSN4DBTableView1ape_y_nom: TcxGridDBColumn
          Caption = 'Apellido y Nombre'
          DataBinding.FieldName = 'ape_y_nom'
          Options.Editing = False
          Width = 211
        end
        object dxDBGridSN4DBTableView1hora: TcxGridDBColumn
          Caption = 'Hora'
          DataBinding.FieldName = 'hora'
          HeaderAlignmentHorz = taCenter
          Options.Editing = False
          Width = 67
        end
        object dxDBGridSN4DBTableView1selector: TcxGridDBColumn
          Caption = 'Selector'
          DataBinding.FieldName = 'selector'
          Options.Editing = False
          Width = 132
        end
        object dxDBGridSN4DBTableView1contactar: TcxGridDBColumn
          Caption = 'Contactar a'
          DataBinding.FieldName = 'contactar'
          Options.Editing = False
          Width = 100
        end
        object dxDBGridSN4DBTableView1llego: TcxGridDBColumn
          Caption = 'Llego?'
          DataBinding.FieldName = 'llego'
          Options.Editing = False
          Width = 49
        end
        object dxDBGridSN4DBTableView1hora_llegada: TcxGridDBColumn
          Caption = 'Hora lleg'#243
          DataBinding.FieldName = 'hora_llegada'
          HeaderAlignmentHorz = taCenter
          Options.Editing = False
          Width = 68
        end
        object dxDBGridSN4DBTableView1oid_tipo_formulario: TcxGridDBColumn
          Caption = 'Tipo Formulario'
          DataBinding.FieldName = 'oid_tipo_formulario'
          PropertiesClassName = 'TcxLookupComboBoxProperties'
          Properties.KeyFieldNames = 'oid'
          Properties.ListColumns = <
            item
              FieldName = 'descripcion'
            end>
          Properties.ListOptions.ShowHeader = False
          Properties.ListSource = DSTipoFormulario
          Width = 124
        end
        object dxDBGridSN4DBTableView1Column1: TcxGridDBColumn
          Caption = 'Completo?'
          DataBinding.FieldName = 'completo_formu'
          Options.Editing = False
          Width = 69
        end
      end
      object cxGridLevel3: TcxGridLevel
        GridView = dxDBGridSN4DBTableView1
      end
    end
  end
  inherited DriverABM: TDriverABM
    CargaDataSets = <
      item
        DataSet = TConsultaRecepcion
        TableName = 'TConsultaRecepcion'
      end
      item
        DataSet = TTempConsultaRecepcion
        TableName = 'TTempConsultaRecepcion'
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
    OnChangeField = <
      item
        TableName = 'TConsultaRecepcion'
        FieldName = 'oid_tipo_formulario'
        Source.Strings = (
          'begin'
          '  operacion.InicioOperacion();'
          '  operacion.setOper('#39'SaveRecluCambioTipoFormu'#39');'
          
            ' operacion.AddAtribute('#39'oid_proceso_candi'#39', TConsultaRecepcion.F' +
            'ieldName('#39'oid_proceso_candi'#39').AsString);'
          
            ' operacion.AddAtribute('#39'oid_tipo_formulario'#39', IntToStr(TConsulta' +
            'Recepcion.FieldName('#39'oid_tipo_formulario'#39').AsInteger));'
          ' operacion.execute(); '
          'end.')
      end>
    OnNuevoRegistro = <
      item
        TableName = 'Tinput'
        Source.Strings = (
          'begin'
          '  DataSet.FieldName('#39'fec_desde'#39').Value := varios.getFecha();'
          '  DataSet.FieldName('#39'fec_hasta'#39').Value := varios.getFecha();'
          'end.')
      end>
    OnInicializar = <
      item
        Source.Strings = (
          'begin'
          '  dxDBGridSN4.ActivarEventoPintarCeldas;'
          '  Tinput.close;'
          '  Tinput.open;'
          '  Tinput.AppendRecord;'
          '  TRecluTipoFormulario.loadFromHelp('#39'HelpTipoFormulario'#39');'
          'end.')
      end>
    OnFormFunction = <
      item
        Source.Strings = (
          'procedure actuHoraLleggo();'
          'begin'
          '  TConsultaRecepcion.EditRecord;'
          '  TConsultaRecepcion.FieldName('#39'llego'#39').AsString := '
          '     TTempConsultaRecepcion.FieldName('#39'llego'#39').AsString;'
          '  TConsultaRecepcion.FieldName('#39'hora_llegada'#39').AsString := '
          '     TTempConsultaRecepcion.FieldName('#39'hora_llegada'#39').AsString;'
          '  TConsultaRecepcion.FieldName('#39'completo_formu'#39').AsString := '
          
            '     TTempConsultaRecepcion.FieldName('#39'completo_formu'#39').AsString' +
            ';'
          '  TConsultaRecepcion.PostRecord;'
          'end;'
          ''
          'procedure TraerConsDetRecepcion();'
          'begin'
          '  Tinput.PostRecord;'
          '  operacion.InicioOperacion();'
          '  operacion.setOper('#39'TraerRecluConsRecepcion'#39');'
          '  operacion.AddDataSet(Tinput.getDataSet());'
          '  operacion.execute();'
          'end;'
          ''
          ''
          'procedure grabar();'
          'begin'
          ''
          
            '  if (TConsultaRecepcion.FieldName('#39'oid_proceso_candi'#39').AsIntege' +
            'r=0)'
          
            '     then raiseException(erCustomError,'#39'Debe seleccionar un proc' +
            'eso'#39');'
          ''
          '  operacion.InicioOperacion();'
          '  operacion.setOper('#39'SaveRecluLlegoPersona'#39');'
          
            '  operacion.AddAtribute('#39'oid_proceso_candi'#39', TConsultaRecepcion.' +
            'FieldName('#39'oid_proceso_candi'#39').AsString);'
          '  operacion.execute();'
          ''
          'end;'
          ''
          'procedure grabarAnular();'
          'begin'
          ''
          
            '  if (TConsultaRecepcion.FieldName('#39'oid_proceso_candi'#39').AsIntege' +
            'r=0)'
          
            '     then raiseException(erCustomError,'#39'Debe seleccionar un proc' +
            'eso'#39');'
          ''
          '  operacion.InicioOperacion();'
          '  operacion.setOper('#39'SaveRecluLlegoPersonaAnu'#39');'
          
            '  operacion.AddAtribute('#39'oid_proceso_candi'#39', TConsultaRecepcion.' +
            'FieldName('#39'oid_proceso_candi'#39').AsString);'
          '  operacion.execute();'
          ''
          'end;'
          ''
          ''
          'procedure grabarCompletoFormulario();'
          'begin'
          ''
          
            '  if (TConsultaRecepcion.FieldName('#39'oid_proceso_candi'#39').AsIntege' +
            'r=0)'
          
            '     then raiseException(erCustomError,'#39'Debe seleccionar un proc' +
            'eso'#39');'
          ''
          '  operacion.InicioOperacion();'
          '  operacion.setOper('#39'SaveRecluCompletoFormu'#39');'
          
            '  operacion.AddAtribute('#39'oid_proceso_candi'#39', TConsultaRecepcion.' +
            'FieldName('#39'oid_proceso_candi'#39').AsString);'
          '  operacion.execute();'
          ''
          'end;'
          ''
          'procedure AnularCompletoFormulario();'
          'begin'
          ''
          
            '  if (TConsultaRecepcion.FieldName('#39'oid_proceso_candi'#39').AsIntege' +
            'r=0)'
          
            '     then raiseException(erCustomError,'#39'Debe seleccionar un proc' +
            'eso'#39');'
          ''
          '  operacion.InicioOperacion();'
          '  operacion.setOper('#39'AnularRecluAnularFormu'#39');'
          
            '  operacion.AddAtribute('#39'oid_proceso_candi'#39', TConsultaRecepcion.' +
            'FieldName('#39'oid_proceso_candi'#39').AsString);'
          '  operacion.execute();'
          ''
          'end;'
          '')
      end>
    OnClickToolButton = <
      item
        ButtonName = 'ImageBuscar'
        Source.Strings = (
          'begin'
          '  TraerConsDetRecepcion();'
          'end.')
      end
      item
        ButtonName = 'BotonMarcarLlegoPersona'
        Source.Strings = (
          'begin'
          
            '  if (mensaje.question('#39#191'Desea marcar la llegada?'#39')=false) then ' +
            'exit;'
          '  grabar();'
          '  actuHoraLleggo();'
          'end.')
      end
      item
        ButtonName = 'BotonAnularLLegoPersona'
        Source.Strings = (
          'begin'
          
            '  if (mensaje.question('#39#191'Desea anular la llegada?'#39')=false) then ' +
            'exit;'
          '  grabarAnular();'
          '  actuHoraLleggo();'
          'end.')
      end
      item
        ButtonName = 'BotonCompletoFormulario'
        Source.Strings = (
          'begin'
          
            '  if (mensaje.question('#39#191'Desea indicar que completo el formulari' +
            'o?'#39')=false) then exit;'
          '  grabarCompletoFormulario();'
          '  actuHoraLleggo();'
          'end.')
      end
      item
        ButtonName = 'BotonAnularLLenadoFormu'
        Source.Strings = (
          'begin'
          
            '    if (mensaje.question('#39#191'Desea marcar como NO COMPLETADO el fo' +
            'rmulario?'#39')=false) then exit;'
          '    AnularCompletoFormulario();'
          '    actuHoraLleggo();'
          'end.')
      end>
  end
  inherited ImprimirObjetoSeleccionado: TdxComponentPrinter
    inherited ImprimirObjetoSeleccionadodxComponentPrinterLink: TdxGridReportLink
      BuiltInReportLink = True
    end
  end
  object Tinput: TsnTable
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
    Left = 96
    Top = 209
    object Tinputfec_desde: TDateField
      FieldName = 'fec_desde'
    end
    object Tinputfec_hasta: TDateField
      FieldName = 'fec_hasta'
    end
    object Tinputbuscar: TStringField
      FieldName = 'buscar'
      Size = 100
    end
  end
  object DSInput: TDataSource
    DataSet = Tinput
    Left = 128
    Top = 209
  end
  object TConsultaRecepcion: TsnTable
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
    Left = 264
    Top = 313
    object TConsultaRecepcionoid_proceso_candi: TIntegerField
      FieldName = 'oid_proceso_candi'
    end
    object TConsultaRecepcionempresa: TStringField
      FieldName = 'empresa'
      Size = 100
    end
    object TConsultaRecepcionfecha: TDateField
      FieldName = 'fecha'
    end
    object TConsultaRecepcionape_y_nom: TStringField
      FieldName = 'ape_y_nom'
      Size = 100
    end
    object TConsultaRecepcionnro_docu: TStringField
      FieldName = 'nro_docu'
      Size = 50
    end
    object TConsultaRecepcionhora: TStringField
      FieldName = 'hora'
      Size = 50
    end
    object TConsultaRecepcionselector: TStringField
      FieldName = 'selector'
      Size = 100
    end
    object TConsultaRecepcioncontactar: TStringField
      FieldName = 'contactar'
      Size = 100
    end
    object TConsultaRecepcionllego: TStringField
      FieldName = 'llego'
      Size = 2
    end
    object TConsultaRecepcionhora_llegada: TStringField
      FieldName = 'hora_llegada'
      Size = 5
    end
    object TConsultaRecepcionoid_tipo_formulario: TIntegerField
      FieldName = 'oid_tipo_formulario'
    end
    object TConsultaRecepcioncompleto_formu: TStringField
      FieldName = 'completo_formu'
      Size = 2
    end
  end
  object DSConsultaRecepcion: TDataSource
    DataSet = TConsultaRecepcion
    Left = 304
    Top = 313
  end
  object HelpTipoFormulario: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'rs.RecluTipoFormuProceso'
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
    Left = 16
    Top = 434
  end
  object TRecluTipoFormulario: TsnTable
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
    Left = 50
    Top = 434
    object IntegerField5: TIntegerField
      FieldName = 'oid'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object StringField5: TStringField
      FieldName = 'codigo'
      Size = 50
    end
    object StringField6: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
  end
  object DSTipoFormulario: TDataSource
    DataSet = TRecluTipoFormulario
    Left = 84
    Top = 435
  end
  object TTempConsultaRecepcion: TsnTable
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
    Left = 264
    Top = 363
    object IntegerField1: TIntegerField
      FieldName = 'oid_proceso_candi'
    end
    object StringField1: TStringField
      FieldName = 'empresa'
      Size = 100
    end
    object DateField1: TDateField
      FieldName = 'fecha'
    end
    object StringField2: TStringField
      FieldName = 'ape_y_nom'
      Size = 100
    end
    object StringField3: TStringField
      FieldName = 'nro_docu'
      Size = 50
    end
    object StringField4: TStringField
      FieldName = 'hora'
      Size = 50
    end
    object StringField7: TStringField
      FieldName = 'selector'
      Size = 100
    end
    object StringField8: TStringField
      FieldName = 'contactar'
      Size = 100
    end
    object StringField9: TStringField
      FieldName = 'llego'
      Size = 2
    end
    object StringField10: TStringField
      FieldName = 'hora_llegada'
      Size = 5
    end
    object IntegerField2: TIntegerField
      FieldName = 'oid_tipo_formulario'
    end
    object TTempConsultaRecepcioncompleto_formu: TStringField
      FieldName = 'completo_formu'
      Size = 2
    end
  end
  object cxStyleRepository1: TcxStyleRepository
    PixelsPerInch = 96
    object cxStyle1: TcxStyle
      AssignedValues = [svFont]
      Font.Charset = DEFAULT_CHARSET
      Font.Color = clWindowText
      Font.Height = -13
      Font.Name = 'MS Sans Serif'
      Font.Style = []
    end
  end
  object Varios: TsnVarios
    Operacion = Operacion
    Left = 664
    Top = 292
  end
end
