inherited FConsRecluProcesos: TFConsRecluProcesos
  Left = 185
  Top = 0
  Width = 714
  Height = 574
  Caption = 'Consulta de Procesos'
  PixelsPerInch = 96
  TextHeight = 13
  object Panel1: TPanel [0]
    Left = 0
    Top = 0
    Width = 698
    Height = 185
    Align = alTop
    BevelOuter = bvNone
    Color = clWindow
    TabOrder = 0
    object Label1: TLabel
      Left = 32
      Top = 16
      Width = 143
      Height = 20
      Caption = 'Fecha Planif. Desde'
      Font.Charset = DEFAULT_CHARSET
      Font.Color = clWindowText
      Font.Height = -16
      Font.Name = 'MS Sans Serif'
      Font.Style = []
      ParentFont = False
    end
    object Label2: TLabel
      Left = 352
      Top = 16
      Width = 139
      Height = 20
      Caption = 'Fecha Planif. Hasta'
      Font.Charset = DEFAULT_CHARSET
      Font.Color = clWindowText
      Font.Height = -16
      Font.Name = 'MS Sans Serif'
      Font.Style = []
      ParentFont = False
    end
    object Label4: TLabel
      Left = 32
      Top = 63
      Width = 73
      Height = 20
      Caption = 'Operaci'#243'n'
      Font.Charset = DEFAULT_CHARSET
      Font.Color = clWindowText
      Font.Height = -16
      Font.Name = 'MS Sans Serif'
      Font.Style = []
      ParentFont = False
    end
    object Label5: TLabel
      Left = 32
      Top = 109
      Width = 47
      Height = 20
      Caption = 'Sector'
      Font.Charset = DEFAULT_CHARSET
      Font.Color = clWindowText
      Font.Height = -16
      Font.Name = 'MS Sans Serif'
      Font.Style = []
      ParentFont = False
    end
    object Label6: TLabel
      Left = 32
      Top = 154
      Width = 59
      Height = 20
      Caption = 'Selector'
      Font.Charset = DEFAULT_CHARSET
      Font.Color = clWindowText
      Font.Height = -16
      Font.Name = 'MS Sans Serif'
      Font.Style = []
      ParentFont = False
    end
    object snDBDateEdit1: TsnDBDateEdit
      Left = 184
      Top = 12
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
      Left = 504
      Top = 12
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
    object snDBLookup1: TsnDBLookup
      Left = 120
      Top = 59
      DataBinding.DataField = 'oid_operacion'
      DataBinding.DataSource = DSInput
      ParentFont = False
      Properties.KeyFieldNames = 'oid'
      Properties.ListColumns = <
        item
          FieldName = 'descripcion'
        end>
      Properties.ListOptions.ShowHeader = False
      Properties.ListSource = DSRecluOperacion
      Style.Font.Charset = DEFAULT_CHARSET
      Style.Font.Color = clWindowText
      Style.Font.Height = -16
      Style.Font.Name = 'MS Sans Serif'
      Style.Font.Style = []
      Style.IsFontAssigned = True
      TabOrder = 2
      Width = 273
    end
    object snDBLookup2: TsnDBLookup
      Left = 120
      Top = 105
      DataBinding.DataField = 'oid_sector'
      DataBinding.DataSource = DSInput
      ParentFont = False
      Properties.KeyFieldNames = 'oid'
      Properties.ListColumns = <
        item
          FieldName = 'descripcion'
        end>
      Properties.ListOptions.ShowHeader = False
      Properties.ListSource = DSRecluSectores
      Style.Font.Charset = DEFAULT_CHARSET
      Style.Font.Color = clWindowText
      Style.Font.Height = -16
      Style.Font.Name = 'MS Sans Serif'
      Style.Font.Style = []
      Style.IsFontAssigned = True
      TabOrder = 3
      Width = 273
    end
    object snDBLookup3: TsnDBLookup
      Left = 120
      Top = 150
      DataBinding.DataField = 'oid_selector'
      DataBinding.DataSource = DSInput
      ParentFont = False
      Properties.KeyFieldNames = 'oid'
      Properties.ListColumns = <
        item
          FieldName = 'descripcion'
        end>
      Properties.ListOptions.ShowHeader = False
      Properties.ListSource = DSTSelector
      Style.Font.Charset = DEFAULT_CHARSET
      Style.Font.Color = clWindowText
      Style.Font.Height = -16
      Style.Font.Name = 'MS Sans Serif'
      Style.Font.Style = []
      Style.IsFontAssigned = True
      TabOrder = 4
      Width = 273
    end
  end
  object Panel2: TPanel [1]
    Left = 0
    Top = 185
    Width = 698
    Height = 351
    Align = alClient
    Color = clWindow
    TabOrder = 1
    object Panel3: TPanel
      Left = 1
      Top = 1
      Width = 696
      Height = 349
      Align = alClient
      Color = clWindow
      TabOrder = 0
      object Label3: TLabel
        Left = 346
        Top = 70
        Width = 167
        Height = 23
        Caption = 'Estados del Proceso'
        Font.Charset = ANSI_CHARSET
        Font.Color = clBlack
        Font.Height = -21
        Font.Name = 'Times New Roman'
        Font.Style = []
        ParentFont = False
      end
      object Label7: TLabel
        Left = 42
        Top = 71
        Width = 75
        Height = 23
        Caption = 'Procesos'
        Font.Charset = ANSI_CHARSET
        Font.Color = clBlack
        Font.Height = -21
        Font.Name = 'Times New Roman'
        Font.Style = []
        ParentFont = False
      end
      object dxDBGridSN5: TdxDBGridSN
        Left = 338
        Top = 98
        Width = 281
        Height = 183
        TabOrder = 0
        CriteriosPintarCelda = <>
        object cxGridDBTableView4: TcxGridDBTableView
          NavigatorButtons.ConfirmDelete = False
          NavigatorButtons.First.Visible = False
          NavigatorButtons.PriorPage.Visible = False
          NavigatorButtons.Prior.Visible = False
          NavigatorButtons.Next.Visible = False
          NavigatorButtons.NextPage.Visible = False
          NavigatorButtons.Last.Visible = False
          NavigatorButtons.Insert.Visible = False
          NavigatorButtons.Append.Visible = True
          NavigatorButtons.Edit.Visible = False
          NavigatorButtons.Post.Visible = False
          NavigatorButtons.Cancel.Visible = False
          NavigatorButtons.Refresh.Visible = False
          NavigatorButtons.SaveBookmark.Visible = False
          NavigatorButtons.GotoBookmark.Visible = False
          NavigatorButtons.Filter.Visible = False
          DataController.DataSource = DSTEstadosProceso
          DataController.Summary.DefaultGroupSummaryItems = <>
          DataController.Summary.FooterSummaryItems = <>
          DataController.Summary.SummaryGroups = <>
          OptionsData.Appending = True
          OptionsData.DeletingConfirmation = False
          OptionsView.Navigator = True
          OptionsView.GroupByBox = False
          OptionsView.Header = False
          object cxGridDBColumn4: TcxGridDBColumn
            Caption = 'Competencias'
            DataBinding.FieldName = 'descripcion'
            PropertiesClassName = 'TcxButtonEditProperties'
            Properties.Buttons = <
              item
                Default = True
                Kind = bkEllipsis
              end>
            Width = 400
          end
        end
        object cxGridLevel4: TcxGridLevel
          GridView = cxGridDBTableView4
        end
      end
      object dxDBGridSN1: TdxDBGridSN
        Left = 26
        Top = 99
        Width = 281
        Height = 183
        TabOrder = 1
        CriteriosPintarCelda = <>
        object cxGridDBTableView1: TcxGridDBTableView
          NavigatorButtons.ConfirmDelete = False
          NavigatorButtons.First.Visible = False
          NavigatorButtons.PriorPage.Visible = False
          NavigatorButtons.Prior.Visible = False
          NavigatorButtons.Next.Visible = False
          NavigatorButtons.NextPage.Visible = False
          NavigatorButtons.Last.Visible = False
          NavigatorButtons.Insert.Visible = False
          NavigatorButtons.Append.Visible = True
          NavigatorButtons.Edit.Visible = False
          NavigatorButtons.Post.Visible = False
          NavigatorButtons.Cancel.Visible = False
          NavigatorButtons.Refresh.Visible = False
          NavigatorButtons.SaveBookmark.Visible = False
          NavigatorButtons.GotoBookmark.Visible = False
          NavigatorButtons.Filter.Visible = False
          DataController.DataSource = DSProcesos
          DataController.Summary.DefaultGroupSummaryItems = <>
          DataController.Summary.FooterSummaryItems = <>
          DataController.Summary.SummaryGroups = <>
          OptionsData.Appending = True
          OptionsData.DeletingConfirmation = False
          OptionsView.Navigator = True
          OptionsView.GroupByBox = False
          OptionsView.Header = False
          object cxGridDBColumn1: TcxGridDBColumn
            Caption = 'Competencias'
            DataBinding.FieldName = 'descripcion'
            PropertiesClassName = 'TcxButtonEditProperties'
            Properties.Buttons = <
              item
                Default = True
                Kind = bkEllipsis
              end>
            Width = 400
          end
        end
        object cxGridLevel1: TcxGridLevel
          GridView = cxGridDBTableView1
        end
      end
      object snDBCheckEdit1: TsnDBCheckEdit
        Left = 32
        Top = 4
        Caption = 'Incluir B'#250'squedas Abiertas'
        DataBinding.DataField = 'abiertas'
        DataBinding.DataSource = DSInput
        ParentFont = False
        Style.Font.Charset = DEFAULT_CHARSET
        Style.Font.Color = clWindowText
        Style.Font.Height = -16
        Style.Font.Name = 'MS Sans Serif'
        Style.Font.Style = []
        Style.IsFontAssigned = True
        TabOrder = 2
        Width = 217
      end
      object snDBCheckEdit2: TsnDBCheckEdit
        Left = 288
        Top = 4
        Caption = 'Incluir B'#250'squedas Cerradas'
        DataBinding.DataField = 'cerradas'
        DataBinding.DataSource = DSInput
        ParentFont = False
        Style.Font.Charset = DEFAULT_CHARSET
        Style.Font.Color = clWindowText
        Style.Font.Height = -16
        Style.Font.Name = 'MS Sans Serif'
        Style.Font.Style = []
        Style.IsFontAssigned = True
        TabOrder = 3
        Width = 297
      end
      object snDBCheckEdit3: TsnDBCheckEdit
        Left = 32
        Top = 36
        Caption = 'Incluir Procesos sin Fecha de Planificaci'#243'n'
        DataBinding.DataField = 'incluir_busq_sin_planif'
        DataBinding.DataSource = DSInput
        ParentFont = False
        Style.Font.Charset = DEFAULT_CHARSET
        Style.Font.Color = clWindowText
        Style.Font.Height = -16
        Style.Font.Name = 'MS Sans Serif'
        Style.Font.Style = []
        Style.IsFontAssigned = True
        TabOrder = 4
        Width = 361
      end
    end
  end
  object BotonEjecutarConsulta: TsnButton [2]
    Left = 445
    Top = 53
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
    TabOrder = 2
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
  inherited TOidObjSave: TsnTable
    Left = 560
    Top = 64
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
      '  TInput.close;'
      '  TInput.Open;'
      '  TInput.appendRecord;'
      ''
      '  TProcesosEnEstado.close;'
      '  TProcesosEnEstado.open;'
      ''
      '  TProcesos.close;'
      '  TProcesos.Open;'
      ''
      ''
      ' '
      'end.')
    OnBeforePost = <
      item
        TableName = 'TProcesosEnEstado'
        Source.Strings = (
          'begin'
          '  if (DataSet.FieldName('#39'oid'#39').AsInteger=0)'
          
            '     then raiseException(erCustomError,'#39'Debe ingresar un estado ' +
            'del Proceso'#39');'
          'end.')
      end
      item
        TableName = 'TProcesos'
        Source.Strings = (
          'begin'
          '  if (DataSet.FieldName('#39'oid'#39').AsInteger=0)'
          
            '     then raiseException(erCustomError,'#39'Debe ingresar el Proceso' +
            #39');'
          'end.')
      end>
    OnNuevoRegistro = <
      item
        TableName = 'TInput'
        Source.Strings = (
          'begin'
          '  DataSet.FieldName('#39'abiertas'#39').Value := true;'
          '  DataSet.FieldName('#39'cerradas'#39').Value := true;'
          '  DataSet.FieldName('#39'incluir_busq_sin_planif'#39').Value := false;'
          'end.')
      end>
    OnInicializar = <
      item
        Source.Strings = (
          'begin'
          '  TRecluOperacion.loadFromHelp('#39'HelpOperacion'#39');'
          '  TRecluSectores.loadFromHelp('#39'HelpSectores'#39');'
          '  TSelector.loadFromHelp('#39'HelpSelector'#39');'
          'end.')
      end>
    OnFormFunction = <
      item
        Source.Strings = (
          'procedure ejecutarConsultas();'
          'begin'
          ''
          '  TInput.PostRecord;'
          '  TProcesosEnEstado.PostRecord;'
          '  TProcesos.PostRecord;'
          ''
          '  TInput.PostRecord;'
          '  variable.newVariantArray('#39'parametros'#39',3);'
          
            '  variable.addKeyTableForArray('#39'parametros'#39',0,'#39'TInput'#39','#39'TInput'#39')' +
            ';  '
          
            '  variable.addKeyTableForArray('#39'parametros'#39',1,'#39'TProcesosEnEstado' +
            #39','#39'TProcesosEnEstado'#39');  '
          
            '  variable.addKeyTableForArray('#39'parametros'#39',2,'#39'TProcesos'#39','#39'TProc' +
            'esos'#39');  '
          ''
          '   FormConsProcesos.params :=  variable.getValue('#39'parametros'#39');'
          '   FormConsProcesos.Ventana := getVentana();'
          '   FormConsProcesos.Mostrar(false);'
          ''
          'end;')
      end>
    OnClickToolButton = <
      item
        ButtonName = 'BotonEjecutarConsulta'
        Source.Strings = (
          'begin'
          '  ejecutarConsultas();'
          'end.')
      end>
    OnClickButtonColumn = <
      item
        ColumnName = 'cxGridDBColumn4'
        Source.Strings = (
          'begin'
          '  HelpProcesosEnEstado.Mostrar();'
          'end.')
      end
      item
        ColumnName = 'cxGridDBColumn1'
        Source.Strings = (
          'begin'
          '  HelpProcesos.mostrar();'
          'end.')
      end>
  end
  inherited ImprimirObjetoSeleccionado: TdxComponentPrinter
    Left = 480
    Top = 256
    inherited ImprimirObjetoSeleccionadodxComponentPrinterLink: TdxGridReportLink
      BuiltInReportLink = True
    end
  end
  inherited TPathHelp: TsnTable
    Left = 608
    Top = 245
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
    Left = 177
    Top = 466
    object TInputfec_desde: TDateField
      FieldName = 'fec_desde'
    end
    object TInputfec_hasta: TDateField
      FieldName = 'fec_hasta'
    end
    object TInputoid_operacion: TIntegerField
      FieldName = 'oid_operacion'
    end
    object TInputoid_sector: TIntegerField
      FieldName = 'oid_sector'
    end
    object TInputoid_selector: TIntegerField
      FieldName = 'oid_selector'
    end
    object TInputoid_busqueda_act: TIntegerField
      FieldName = 'oid_busqueda_act'
    end
    object TInputcodigo_sexo2: TStringField
      FieldName = 'codigo_sexo'
      Size = 10
    end
    object TInputoid_postulante2: TIntegerField
      FieldName = 'oid_postulante'
    end
    object TInputes_referido2: TStringField
      FieldName = 'es_referido'
      Size = 2
    end
    object TInputgenero_postulante2: TStringField
      FieldName = 'genero_postulante'
    end
    object TInputoid_estado_postulante2: TIntegerField
      FieldName = 'oid_estado_postulante'
    end
    object TInputStringField: TStringField
      FieldName = 'buscar'
      Size = 100
    end
    object TInputIntegerField: TIntegerField
      FieldName = 'oid_puesto'
    end
    object TInputBooleanField: TBooleanField
      FieldName = 'abiertas'
    end
    object TInputBooleanField2: TBooleanField
      FieldName = 'cerradas'
    end
    object TInputincluir_busq_sin_planif: TBooleanField
      FieldName = 'incluir_busq_sin_planif'
    end
  end
  object DSInput: TDataSource
    DataSet = TInput
    Left = 209
    Top = 464
  end
  object TProcesosEnEstado: TsnTable
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
    MensajeValorDuplicadoIndice = 'TEstadosProceso'
    Left = 472
    Top = 118
    object IntegerField6: TIntegerField
      FieldName = 'oid'
    end
    object StringField11: TStringField
      FieldName = 'codigo'
      Size = 50
    end
    object StringField12: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
    object BooleanField3: TBooleanField
      FieldName = 'seleccionado'
    end
  end
  object DSTEstadosProceso: TDataSource
    DataSet = TProcesosEnEstado
    Left = 512
    Top = 118
  end
  object HelpProcesosEnEstado: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'rs.RecluEstadoProceso'
    NroHelp = 0
    Campos = <
      item
        Titulo = 'oid'
        FieldName = 'oid'
        Tipo = ftInteger
        Longitud = 0
        Visible = False
        AsignarACampo = IntegerField6
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
        AsignarACampo = StringField12
        KeyField = False
        AnchoEnCaracteres = 100
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
    Left = 384
    Top = 241
  end
  object HelpOperacion: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'rs.RecluOperacion'
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
  object TRecluOperacion: TsnTable
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
  object DSRecluOperacion: TDataSource
    DataSet = TRecluOperacion
    Left = 84
    Top = 435
  end
  object HelpSectores: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'rs.RecluSectores'
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
    Top = 474
  end
  object TRecluSectores: TsnTable
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
    Top = 474
    object IntegerField4: TIntegerField
      FieldName = 'oid'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object StringField9: TStringField
      FieldName = 'codigo'
      Size = 50
    end
    object StringField10: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
  end
  object DSRecluSectores: TDataSource
    DataSet = TRecluSectores
    Left = 84
    Top = 475
  end
  object HelpSelector: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'rs.RecluSelector'
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
    Top = 509
  end
  object TSelector: TsnTable
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
    Top = 509
    object IntegerField7: TIntegerField
      FieldName = 'oid'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object StringField13: TStringField
      FieldName = 'codigo'
      Size = 50
    end
    object StringField14: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
  end
  object DSTSelector: TDataSource
    DataSet = TSelector
    Left = 84
    Top = 510
  end
  object FormConsProcesos: TFormulario
    Nombre = 'TFRecluDetConsProc'
    CreateAlwaysANewForm = True
    Left = 16
    Top = 63
  end
  object TProcesos: TsnTable
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
    MensajeValorDuplicadoIndice = 'TEstadosProceso'
    Left = 472
    Top = 160
    object IntegerField1: TIntegerField
      FieldName = 'oid'
    end
    object StringField1: TStringField
      FieldName = 'codigo'
      Size = 50
    end
    object StringField2: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
    object BooleanField1: TBooleanField
      FieldName = 'seleccionado'
    end
  end
  object DSProcesos: TDataSource
    DataSet = TProcesos
    Left = 512
    Top = 160
  end
  object HelpProcesos: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'rs.RecluProceso'
    NroHelp = 0
    Campos = <
      item
        Titulo = 'oid'
        FieldName = 'oid'
        Tipo = ftInteger
        Longitud = 0
        Visible = False
        AsignarACampo = IntegerField1
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
        AsignarACampo = StringField2
        KeyField = False
        AnchoEnCaracteres = 100
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
    Left = 384
    Top = 281
  end
end
