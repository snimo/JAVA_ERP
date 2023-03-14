inherited FConsEvalRH: TFConsEvalRH
  Left = 63
  Top = 220
  Width = 917
  Height = 707
  Caption = 'Consulta de Evaluaciones'
  PixelsPerInch = 96
  TextHeight = 13
  object Panel1: TPanel [0]
    Left = 0
    Top = 0
    Width = 901
    Height = 144
    Align = alTop
    BevelOuter = bvNone
    Color = clWindow
    TabOrder = 0
    object Shape1: TShape
      Left = 16
      Top = 12
      Width = 329
      Height = 28
      Brush.Color = 16769217
      Shape = stRoundRect
    end
    object snLabel2: TsnLabel
      Left = 32
      Top = 17
      Width = 298
      Height = 16
      Caption = 'Evaluaciones Comprendidas entre dos fechas'
      Font.Charset = ANSI_CHARSET
      Font.Color = clWindowText
      Font.Height = -13
      Font.Name = 'Verdana'
      Font.Style = []
      ParentFont = False
      Transparent = True
    end
    object snLabel3: TsnLabel
      Left = 40
      Top = 54
      Width = 83
      Height = 16
      Caption = 'Fecha desde:'
      Font.Charset = DEFAULT_CHARSET
      Font.Color = clWindowText
      Font.Height = -13
      Font.Name = 'MS Sans Serif'
      Font.Style = []
      ParentFont = False
    end
    object snLabel4: TsnLabel
      Left = 256
      Top = 54
      Width = 77
      Height = 16
      Caption = 'Fecha hasta:'
      Font.Charset = DEFAULT_CHARSET
      Font.Color = clWindowText
      Font.Height = -13
      Font.Name = 'MS Sans Serif'
      Font.Style = []
      ParentFont = False
    end
    object ImageBuscar: TImage
      Left = 366
      Top = 9
      Width = 32
      Height = 32
      Cursor = crHandPoint
      Hint = 'Ejecutar Consulta de Evaluaciones'
      ParentShowHint = False
      ShowHint = True
    end
    object ImageSalir: TImage
      Tag = 7
      Left = 414
      Top = 9
      Width = 32
      Height = 32
      Cursor = crHandPoint
      Hint = 'Salir'
      ParentShowHint = False
      ShowHint = True
    end
    object snLabel6: TsnLabel
      Left = 40
      Top = 122
      Width = 115
      Height = 16
      Caption = 'Puntaje Evaluaci'#243'n'
      Font.Charset = DEFAULT_CHARSET
      Font.Color = clWindowText
      Font.Height = -13
      Font.Name = 'MS Sans Serif'
      Font.Style = []
      ParentFont = False
    end
    object snLabel7: TsnLabel
      Left = 232
      Top = 123
      Width = 48
      Height = 16
      Caption = 'Grados '
      Font.Charset = DEFAULT_CHARSET
      Font.Color = clWindowText
      Font.Height = -13
      Font.Name = 'MS Sans Serif'
      Font.Style = []
      ParentFont = False
    end
    object snLabel8: TsnLabel
      Left = 360
      Top = 123
      Width = 60
      Height = 16
      Caption = '% Grados'
      Font.Charset = DEFAULT_CHARSET
      Font.Color = clWindowText
      Font.Height = -13
      Font.Name = 'MS Sans Serif'
      Font.Style = []
      ParentFont = False
    end
    object snLabel9: TsnLabel
      Left = 496
      Top = 124
      Width = 127
      Height = 16
      Caption = 'Visualizar Promedios'
      Font.Charset = DEFAULT_CHARSET
      Font.Color = clWindowText
      Font.Height = -13
      Font.Name = 'MS Sans Serif'
      Font.Style = []
      ParentFont = False
      Visible = False
    end
    object Shape3: TShape
      Left = 16
      Top = 82
      Width = 97
      Height = 28
      Brush.Color = 16769217
      Shape = stRoundRect
    end
    object snLabel5: TsnLabel
      Left = 32
      Top = 87
      Width = 61
      Height = 16
      Caption = 'Visualizar'
      Font.Charset = ANSI_CHARSET
      Font.Color = clWindowText
      Font.Height = -13
      Font.Name = 'Verdana'
      Font.Style = []
      ParentFont = False
      Transparent = True
    end
    object snLabel10: TsnLabel
      Left = 464
      Top = 54
      Width = 89
      Height = 16
      Caption = 'Evaluaci'#243'n de:'
      Font.Charset = DEFAULT_CHARSET
      Font.Color = clWindowText
      Font.Height = -13
      Font.Name = 'MS Sans Serif'
      Font.Style = []
      ParentFont = False
    end
    object snDBDateEdit1: TsnDBDateEdit
      Left = 126
      Top = 50
      DataBinding.DataField = 'fec_eval_desde'
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
      Width = 107
    end
    object snDBDateEdit2: TsnDBDateEdit
      Left = 336
      Top = 50
      DataBinding.DataField = 'fec_eval_hasta'
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
      Width = 105
    end
    object snDBLookup2: TsnDBLookup
      Left = 159
      Top = 119
      DataBinding.DataField = 'ver_puntaje'
      DataBinding.DataSource = DSInput
      ParentFont = False
      Properties.KeyFieldNames = 'valor'
      Properties.ListColumns = <
        item
          FieldName = 'descripcion'
        end>
      Properties.ListOptions.ShowHeader = False
      Properties.ListSource = DSSINO
      Style.Font.Charset = ANSI_CHARSET
      Style.Font.Color = clWindowText
      Style.Font.Height = -13
      Style.Font.Name = 'Verdana'
      Style.Font.Style = []
      Style.IsFontAssigned = True
      TabOrder = 3
      Width = 47
    end
    object snDBLookup3: TsnDBLookup
      Left = 285
      Top = 118
      DataBinding.DataField = 'ver_grados'
      DataBinding.DataSource = DSInput
      ParentFont = False
      Properties.KeyFieldNames = 'valor'
      Properties.ListColumns = <
        item
          FieldName = 'descripcion'
        end>
      Properties.ListOptions.ShowHeader = False
      Properties.ListSource = DSSINO
      Style.Font.Charset = ANSI_CHARSET
      Style.Font.Color = clWindowText
      Style.Font.Height = -13
      Style.Font.Name = 'Verdana'
      Style.Font.Style = []
      Style.IsFontAssigned = True
      TabOrder = 4
      Width = 47
    end
    object snDBLookup4: TsnDBLookup
      Left = 424
      Top = 119
      DataBinding.DataField = 'ver_porc_grados'
      DataBinding.DataSource = DSInput
      ParentFont = False
      Properties.KeyFieldNames = 'valor'
      Properties.ListColumns = <
        item
          FieldName = 'descripcion'
        end>
      Properties.ListOptions.ShowHeader = False
      Properties.ListSource = DSSINO
      Style.Font.Charset = ANSI_CHARSET
      Style.Font.Color = clWindowText
      Style.Font.Height = -13
      Style.Font.Name = 'Verdana'
      Style.Font.Style = []
      Style.IsFontAssigned = True
      TabOrder = 5
      Width = 47
    end
    object snDBLookup5: TsnDBLookup
      Left = 627
      Top = 120
      DataBinding.DataField = 'ver_promedio'
      DataBinding.DataSource = DSInput
      ParentFont = False
      Properties.KeyFieldNames = 'valor'
      Properties.ListColumns = <
        item
          FieldName = 'descripcion'
        end>
      Properties.ListOptions.ShowHeader = False
      Properties.ListSource = DSSINO
      Style.Font.Charset = ANSI_CHARSET
      Style.Font.Color = clWindowText
      Style.Font.Height = -13
      Style.Font.Name = 'Verdana'
      Style.Font.Style = []
      Style.IsFontAssigned = True
      TabOrder = 6
      Visible = False
      Width = 47
    end
    object snDBLookup6: TsnDBLookup
      Left = 563
      Top = 50
      DataBinding.DataField = 'tipo'
      DataBinding.DataSource = DSInput
      ParentFont = False
      Properties.ImmediatePost = True
      Properties.KeyFieldNames = 'codigo'
      Properties.ListColumns = <
        item
          FieldName = 'descripcion'
        end>
      Properties.ListOptions.ShowHeader = False
      Properties.ListSource = DSTTiposModEval
      Style.Font.Charset = DEFAULT_CHARSET
      Style.Font.Color = clWindowText
      Style.Font.Height = -13
      Style.Font.Name = 'MS Sans Serif'
      Style.Font.Style = []
      Style.IsFontAssigned = True
      TabOrder = 2
      Width = 222
    end
  end
  object Panel2: TPanel [1]
    Left = 0
    Top = 628
    Width = 901
    Height = 41
    Align = alBottom
    BevelOuter = bvNone
    Color = clWindow
    TabOrder = 2
    object Label1: TLabel
      Left = 32
      Top = 8
      Width = 342
      Height = 16
      Caption = 'Incluir legajos que no tienen evaluaciones cargadas'
      Font.Charset = ANSI_CHARSET
      Font.Color = clWindowText
      Font.Height = -13
      Font.Name = 'Verdana'
      Font.Style = []
      ParentFont = False
    end
    object snDBLookup1: TsnDBLookup
      Left = 384
      Top = 4
      DataBinding.DataField = 'incluir_leg_sin_evaluar'
      DataBinding.DataSource = DSInput
      ParentFont = False
      Properties.KeyFieldNames = 'valor'
      Properties.ListColumns = <
        item
          FieldName = 'descripcion'
        end>
      Properties.ListOptions.ShowHeader = False
      Properties.ListSource = DSSINO
      Style.Font.Charset = ANSI_CHARSET
      Style.Font.Color = clWindowText
      Style.Font.Height = -13
      Style.Font.Name = 'Verdana'
      Style.Font.Style = []
      Style.IsFontAssigned = True
      TabOrder = 0
      Width = 57
    end
  end
  object Panel3: TPanel [2]
    Left = 0
    Top = 144
    Width = 901
    Height = 484
    Align = alClient
    BevelOuter = bvNone
    Color = clWindow
    TabOrder = 1
    object Panel4: TPanel
      Left = 0
      Top = 0
      Width = 901
      Height = 100
      Align = alTop
      BevelOuter = bvNone
      Color = clWindow
      TabOrder = 0
      object Shape2: TShape
        Left = 16
        Top = 12
        Width = 305
        Height = 28
        Brush.Color = 16769217
        Shape = stRoundRect
      end
      object snLabel1: TsnLabel
        Left = 32
        Top = 17
        Width = 276
        Height = 16
        Caption = 'Filtros para aplicar sobre las Evaluaciones'
        Font.Charset = ANSI_CHARSET
        Font.Color = clWindowText
        Font.Height = -13
        Font.Name = 'Verdana'
        Font.Style = []
        ParentFont = False
        Transparent = True
      end
      object Label2: TLabel
        Left = 23
        Top = 55
        Width = 556
        Height = 13
        Caption = 
          '(Si escribe posicionado sobre la celda de una columna, el sistem' +
          'a realizar'#225' una b'#250'squeda seg'#250'n los datos ingresados)'
      end
      object Label3: TLabel
        Left = 24
        Top = 75
        Width = 300
        Height = 13
        Caption = 'Seleccione registros para restrigir la b'#250'squeda de evaluaciones.'
      end
      object Label4: TLabel
        Left = 341
        Top = 75
        Width = 233
        Height = 13
        Caption = 'Presione F5 para Marcar / Desmarcar un registro.'
        Font.Charset = DEFAULT_CHARSET
        Font.Color = clBlue
        Font.Height = -11
        Font.Name = 'MS Sans Serif'
        Font.Style = []
        ParentFont = False
      end
    end
    object SNScrollBox1: TSNScrollBox
      Left = 0
      Top = 100
      Width = 901
      Height = 384
      HorzScrollBar.Style = ssFlat
      HorzScrollBar.Tracking = True
      Align = alClient
      TabOrder = 1
      object Panel6: TPanel
        Left = 185
        Top = 0
        Width = 344
        Height = 363
        Align = alLeft
        Color = clWindow
        TabOrder = 1
        object Panel12: TPanel
          Left = 1
          Top = 1
          Width = 342
          Height = 24
          Align = alTop
          Caption = 'Legajos'
          Font.Charset = ANSI_CHARSET
          Font.Color = clWindowText
          Font.Height = -13
          Font.Name = 'Verdana'
          Font.Style = [fsBold]
          ParentFont = False
          TabOrder = 0
        end
        object dxDBGridSN2: TdxDBGridSN
          Left = 1
          Top = 25
          Width = 342
          Height = 337
          Align = alClient
          TabOrder = 1
          LookAndFeel.Kind = lfFlat
          CriteriosPintarCelda = <>
          object cxGridDBTableView1: TcxGridDBTableView
            NavigatorButtons.ConfirmDelete = False
            DataController.DataSource = DSSelLegajos
            DataController.Summary.DefaultGroupSummaryItems = <>
            DataController.Summary.FooterSummaryItems = <>
            DataController.Summary.SummaryGroups = <>
            OptionsBehavior.IncSearch = True
            OptionsCustomize.ColumnGrouping = False
            OptionsData.Deleting = False
            OptionsData.DeletingConfirmation = False
            OptionsData.Inserting = False
            OptionsSelection.InvertSelect = False
            OptionsView.CellAutoHeight = True
            OptionsView.GroupByBox = False
            object cxGridDBTableView1sel: TcxGridDBColumn
              DataBinding.FieldName = 'sel'
              PropertiesClassName = 'TcxCheckBoxProperties'
              HeaderAlignmentHorz = taCenter
              Width = 24
              IsCaptionAssigned = True
            end
            object cxGridDBTableView1ape_y_nom: TcxGridDBColumn
              Caption = 'Apellido y Nombre'
              DataBinding.FieldName = 'ape_y_nom'
              HeaderAlignmentHorz = taCenter
              Options.Editing = False
              SortIndex = 0
              SortOrder = soAscending
              Width = 228
            end
            object cxGridDBTableView1nro_legajo: TcxGridDBColumn
              Caption = 'Legajo'
              DataBinding.FieldName = 'nro_legajo'
              HeaderAlignmentHorz = taCenter
              Options.Editing = False
              Width = 61
            end
          end
          object cxGridLevel1: TcxGridLevel
            GridView = cxGridDBTableView1
          end
        end
      end
      object Panel7: TPanel
        Left = 899
        Top = 0
        Width = 185
        Height = 363
        Align = alLeft
        Color = clWindow
        TabOrder = 4
        object Panel15: TPanel
          Left = 1
          Top = 1
          Width = 183
          Height = 24
          Align = alTop
          Caption = 'Puesto'
          Font.Charset = ANSI_CHARSET
          Font.Color = clWindowText
          Font.Height = -13
          Font.Name = 'Verdana'
          Font.Style = [fsBold]
          ParentFont = False
          TabOrder = 0
        end
        object dxDBGridSN5: TdxDBGridSN
          Left = 1
          Top = 25
          Width = 183
          Height = 337
          Align = alClient
          TabOrder = 1
          LookAndFeel.Kind = lfFlat
          CriteriosPintarCelda = <>
          object cxGridDBTableView4: TcxGridDBTableView
            NavigatorButtons.ConfirmDelete = False
            DataController.DataSource = DSSelPuesto
            DataController.Summary.DefaultGroupSummaryItems = <>
            DataController.Summary.FooterSummaryItems = <>
            DataController.Summary.SummaryGroups = <>
            OptionsBehavior.IncSearch = True
            OptionsCustomize.ColumnGrouping = False
            OptionsData.Deleting = False
            OptionsData.DeletingConfirmation = False
            OptionsData.Inserting = False
            OptionsSelection.InvertSelect = False
            OptionsView.CellAutoHeight = True
            OptionsView.GroupByBox = False
            object cxGridDBColumn5: TcxGridDBColumn
              DataBinding.FieldName = 'sel'
              PropertiesClassName = 'TcxCheckBoxProperties'
              Width = 26
              IsCaptionAssigned = True
            end
            object cxGridDBColumn6: TcxGridDBColumn
              DataBinding.FieldName = 'descripcion'
              Options.Editing = False
              SortIndex = 0
              SortOrder = soAscending
              Width = 132
              IsCaptionAssigned = True
            end
          end
          object cxGridLevel4: TcxGridLevel
            GridView = cxGridDBTableView4
          end
        end
      end
      object Panel8: TPanel
        Left = 714
        Top = 0
        Width = 185
        Height = 363
        Align = alLeft
        Color = clWindow
        TabOrder = 3
        object Panel14: TPanel
          Left = 1
          Top = 1
          Width = 183
          Height = 24
          Align = alTop
          Caption = 'Sector'
          Font.Charset = ANSI_CHARSET
          Font.Color = clWindowText
          Font.Height = -13
          Font.Name = 'Verdana'
          Font.Style = [fsBold]
          ParentFont = False
          TabOrder = 0
        end
        object dxDBGridSN4: TdxDBGridSN
          Left = 1
          Top = 25
          Width = 183
          Height = 337
          Align = alClient
          TabOrder = 1
          LookAndFeel.Kind = lfFlat
          CriteriosPintarCelda = <>
          object cxGridDBTableView3: TcxGridDBTableView
            NavigatorButtons.ConfirmDelete = False
            DataController.DataSource = DSSelSector
            DataController.Summary.DefaultGroupSummaryItems = <>
            DataController.Summary.FooterSummaryItems = <>
            DataController.Summary.SummaryGroups = <>
            OptionsBehavior.IncSearch = True
            OptionsCustomize.ColumnGrouping = False
            OptionsData.Deleting = False
            OptionsData.DeletingConfirmation = False
            OptionsData.Inserting = False
            OptionsSelection.InvertSelect = False
            OptionsView.CellAutoHeight = True
            OptionsView.GroupByBox = False
            object cxGridDBColumn3: TcxGridDBColumn
              DataBinding.FieldName = 'sel'
              PropertiesClassName = 'TcxCheckBoxProperties'
              Width = 26
              IsCaptionAssigned = True
            end
            object cxGridDBColumn4: TcxGridDBColumn
              DataBinding.FieldName = 'descripcion'
              Options.Editing = False
              SortIndex = 0
              SortOrder = soAscending
              Width = 132
              IsCaptionAssigned = True
            end
          end
          object cxGridLevel3: TcxGridLevel
            GridView = cxGridDBTableView3
          end
        end
      end
      object Panel9: TPanel
        Left = 529
        Top = 0
        Width = 185
        Height = 363
        Align = alLeft
        Color = clWindow
        TabOrder = 2
        object Panel13: TPanel
          Left = 1
          Top = 1
          Width = 183
          Height = 24
          Align = alTop
          Caption = 'Empresa'
          Font.Charset = ANSI_CHARSET
          Font.Color = clWindowText
          Font.Height = -13
          Font.Name = 'Verdana'
          Font.Style = [fsBold]
          ParentFont = False
          TabOrder = 0
        end
        object dxDBGridSN3: TdxDBGridSN
          Left = 1
          Top = 25
          Width = 183
          Height = 337
          Align = alClient
          TabOrder = 1
          LookAndFeel.Kind = lfFlat
          CriteriosPintarCelda = <>
          object cxGridDBTableView2: TcxGridDBTableView
            NavigatorButtons.ConfirmDelete = False
            DataController.DataSource = DSTSelEmpresas
            DataController.Summary.DefaultGroupSummaryItems = <>
            DataController.Summary.FooterSummaryItems = <>
            DataController.Summary.SummaryGroups = <>
            OptionsBehavior.IncSearch = True
            OptionsCustomize.ColumnGrouping = False
            OptionsData.Deleting = False
            OptionsData.DeletingConfirmation = False
            OptionsData.Inserting = False
            OptionsSelection.InvertSelect = False
            OptionsView.CellAutoHeight = True
            OptionsView.GroupByBox = False
            object cxGridDBColumn1: TcxGridDBColumn
              DataBinding.FieldName = 'sel'
              PropertiesClassName = 'TcxCheckBoxProperties'
              Width = 26
              IsCaptionAssigned = True
            end
            object cxGridDBColumn2: TcxGridDBColumn
              DataBinding.FieldName = 'razon_social'
              Options.Editing = False
              SortIndex = 0
              SortOrder = soAscending
              Width = 132
              IsCaptionAssigned = True
            end
          end
          object cxGridLevel2: TcxGridLevel
            GridView = cxGridDBTableView2
          end
        end
      end
      object Panel10: TPanel
        Left = 0
        Top = 0
        Width = 185
        Height = 363
        Align = alLeft
        Color = clWindow
        TabOrder = 0
        object Panel5: TPanel
          Left = 1
          Top = 1
          Width = 183
          Height = 24
          Align = alTop
          Caption = 'Evaluaciones'
          Font.Charset = ANSI_CHARSET
          Font.Color = clWindowText
          Font.Height = -13
          Font.Name = 'Verdana'
          Font.Style = [fsBold]
          ParentFont = False
          TabOrder = 0
        end
        object dxDBGridSN1: TdxDBGridSN
          Left = 1
          Top = 25
          Width = 183
          Height = 337
          Align = alClient
          TabOrder = 1
          LookAndFeel.Kind = lfFlat
          CriteriosPintarCelda = <>
          object dxDBGridSN1DBTableView1: TcxGridDBTableView
            NavigatorButtons.ConfirmDelete = False
            DataController.DataSource = DSTSelEvaluaciones
            DataController.Summary.DefaultGroupSummaryItems = <>
            DataController.Summary.FooterSummaryItems = <>
            DataController.Summary.SummaryGroups = <>
            OptionsBehavior.IncSearch = True
            OptionsCustomize.ColumnGrouping = False
            OptionsData.Deleting = False
            OptionsData.DeletingConfirmation = False
            OptionsData.Inserting = False
            OptionsSelection.InvertSelect = False
            OptionsView.CellAutoHeight = True
            OptionsView.GroupByBox = False
            object dxDBGridSN1DBTableView1sel: TcxGridDBColumn
              DataBinding.FieldName = 'sel'
              PropertiesClassName = 'TcxCheckBoxProperties'
              Width = 26
              IsCaptionAssigned = True
            end
            object dxDBGridSN1DBTableView1desc_mod_eval: TcxGridDBColumn
              DataBinding.FieldName = 'desc_mod_eval'
              Options.Editing = False
              Width = 132
              IsCaptionAssigned = True
            end
          end
          object dxDBGridSN1Level1: TcxGridLevel
            GridView = dxDBGridSN1DBTableView1
          end
        end
      end
      object Panel11: TPanel
        Left = 1084
        Top = 0
        Width = 185
        Height = 363
        Align = alLeft
        Color = clWindow
        TabOrder = 5
        object Panel16: TPanel
          Left = 1
          Top = 1
          Width = 183
          Height = 24
          Align = alTop
          Caption = 'Estado'
          Font.Charset = ANSI_CHARSET
          Font.Color = clWindowText
          Font.Height = -13
          Font.Name = 'Verdana'
          Font.Style = [fsBold]
          ParentFont = False
          TabOrder = 0
        end
        object dxDBGridSN6: TdxDBGridSN
          Left = 1
          Top = 25
          Width = 183
          Height = 337
          Align = alClient
          TabOrder = 1
          LookAndFeel.Kind = lfFlat
          CriteriosPintarCelda = <>
          object cxGridDBTableView5: TcxGridDBTableView
            NavigatorButtons.ConfirmDelete = False
            DataController.DataSource = DSSelEstado
            DataController.Summary.DefaultGroupSummaryItems = <>
            DataController.Summary.FooterSummaryItems = <>
            DataController.Summary.SummaryGroups = <>
            OptionsBehavior.IncSearch = True
            OptionsCustomize.ColumnGrouping = False
            OptionsData.Deleting = False
            OptionsData.DeletingConfirmation = False
            OptionsData.Inserting = False
            OptionsSelection.InvertSelect = False
            OptionsView.CellAutoHeight = True
            OptionsView.GroupByBox = False
            object cxGridDBColumn7: TcxGridDBColumn
              DataBinding.FieldName = 'sel'
              PropertiesClassName = 'TcxCheckBoxProperties'
              Width = 26
              IsCaptionAssigned = True
            end
            object cxGridDBColumn8: TcxGridDBColumn
              DataBinding.FieldName = 'descripcion'
              Options.Editing = False
              SortIndex = 0
              SortOrder = soAscending
              Width = 132
              IsCaptionAssigned = True
            end
          end
          object cxGridLevel5: TcxGridLevel
            GridView = cxGridDBTableView5
          end
        end
      end
    end
  end
  inherited DriverABM: TDriverABM
    CargaDataSets = <
      item
        DataSet = TSelEvaluaciones
        TableName = 'TSelEvaluaciones'
      end
      item
        DataSet = TSelLegajos
        TableName = 'TSelLegajos'
      end
      item
        DataSet = TSelEmpresas
        TableName = 'TSelEmpresas'
      end
      item
        DataSet = TSelSector
        TableName = 'TSelSector'
      end
      item
        DataSet = TSelPuesto
        TableName = 'TSelPuesto'
      end
      item
        DataSet = TSelEstado
        TableName = 'TSelEstado'
      end
      item
        DataSet = TTiposModEval
        TableName = 'TTiposModEval'
      end>
    Left = 472
    Top = 72
  end
  inherited Operacion: TOperacion
    Left = 512
    Top = 72
  end
  inherited dxComponentPrinter: TdxComponentPrinter
    Left = 552
    Top = 72
    inherited dxComponentPrinterLink1: TdxCustomContainerReportLink
      Component = Owner
      BuiltInReportLink = True
      HiddenComponents = {}
      ExcludedComponents = {}
      AggregatedReportLinks = {}
    end
  end
  inherited SaveDialog: TSaveDialog
    Left = 592
    Top = 72
  end
  inherited DriverEvent: TDriverEvent
    OnShow.Strings = (
      'begin'
      '  snDBDateEdit1.setFoco;'
      'end.')
    OnChangeField = <
      item
        TableName = 'Tinput'
        FieldName = 'tipo'
        Source.Strings = (
          'begin'
          '  TraerModelos(Sender.AsString);'
          'end.')
      end>
    OnNuevoRegistro = <
      item
        TableName = 'Tinput'
        Source.Strings = (
          'begin'
          
            '  DataSet.FieldName('#39'incluir_leg_sin_evaluar'#39').AsBoolean := Fals' +
            'e;'
          '  DataSet.FieldName('#39'ver_puntaje'#39').AsBoolean := True;'
          'DataSet.FieldName('#39'ver_grados'#39').AsBoolean := False;'
          'DataSet.FieldName('#39'ver_porc_grados'#39').AsBoolean := False;'
          'DataSet.FieldName('#39'ver_punt_compe'#39').AsBoolean := False;'
          'DataSet.FieldName('#39'ver_promedio'#39').AsBoolean := False;'
          ''
          ''
          'end.')
      end>
    OnKeyDown = <
      item
        Key = 116
        Shift = []
        ControlName = 'dxDBGridSN1DBTableView1'
        isNuevo = True
        isModificar = True
        isBrowse = True
        Source.Strings = (
          'begin'
          '  if (TSelEvaluaciones.IsEmpty()) then exit;'
          ''
          '  if (TSelEvaluaciones.FieldName('#39'sel'#39').AsBoolean)'
          '     then begin'
          '             TSelEvaluaciones.EditRecord;'
          
            '             TSelEvaluaciones.FieldName('#39'sel'#39').AsBoolean := Fals' +
            'e;'
          '             TSelEvaluaciones.PostRecord; '
          '             end'
          '     else begin'
          '             TSelEvaluaciones.EditRecord;'
          
            '             TSelEvaluaciones.FieldName('#39'sel'#39').AsBoolean := True' +
            ';'
          '             TSelEvaluaciones.PostRecord; '
          '             end;'
          ''
          'end.')
      end
      item
        Key = 116
        Shift = []
        ControlName = 'cxGridDBTableView1'
        isNuevo = True
        isModificar = True
        isBrowse = True
        Source.Strings = (
          'begin'
          '  if (TSelLegajos.IsEmpty()) then exit;'
          ''
          '  if (TSelLegajos.FieldName('#39'sel'#39').AsBoolean)'
          '     then begin'
          '             TSelLegajos.EditRecord;'
          '             TSelLegajos.FieldName('#39'sel'#39').AsBoolean := False;'
          '             TSelLegajos.PostRecord; '
          '             end'
          '     else begin'
          '             TSelLegajos.EditRecord;'
          '             TSelLegajos.FieldName('#39'sel'#39').AsBoolean := True;'
          '             TSelLegajos.PostRecord; '
          '             end;'
          ''
          'end.')
      end
      item
        Key = 116
        Shift = []
        ControlName = 'cxGridDBTableView2'
        isNuevo = True
        isModificar = True
        isBrowse = True
        Source.Strings = (
          'begin'
          '  if (TSelEmpresas.IsEmpty()) then exit;'
          ''
          '  if (TSelEmpresas.FieldName('#39'sel'#39').AsBoolean)'
          '     then begin'
          '             TSelEmpresas.EditRecord;'
          '             TSelEmpresas.FieldName('#39'sel'#39').AsBoolean := False;'
          '             TSelEmpresas.PostRecord; '
          '             end'
          '     else begin'
          '             TSelEmpresas.EditRecord;'
          '             TSelEmpresas.FieldName('#39'sel'#39').AsBoolean := True;'
          '             TSelEmpresas.PostRecord; '
          '             end;'
          ''
          'end.')
      end
      item
        Key = 116
        Shift = []
        ControlName = 'cxGridDBTableView3'
        isNuevo = True
        isModificar = True
        isBrowse = True
        Source.Strings = (
          'begin'
          '  if (TSelSector.IsEmpty()) then exit;'
          ''
          '  if (TSelSector.FieldName('#39'sel'#39').AsBoolean)'
          '     then begin'
          '             TSelSector.EditRecord;'
          '             TSelSector.FieldName('#39'sel'#39').AsBoolean := False;'
          '             TSelSector.PostRecord; '
          '             end'
          '     else begin'
          '             TSelSector.EditRecord;'
          '             TSelSector.FieldName('#39'sel'#39').AsBoolean := True;'
          '             TSelSector.PostRecord; '
          '             end;'
          ''
          'end.'
          '')
      end
      item
        Key = 116
        Shift = []
        ControlName = 'cxGridDBTableView4'
        isNuevo = True
        isModificar = True
        isBrowse = True
        Source.Strings = (
          'begin'
          '  if (TSelPuesto.IsEmpty()) then exit;'
          ''
          '  if (TSelPuesto.FieldName('#39'sel'#39').AsBoolean)'
          '     then begin'
          '             TSelPuesto.EditRecord;'
          '             TSelPuesto.FieldName('#39'sel'#39').AsBoolean := False;'
          '             TSelPuesto.PostRecord; '
          '             end'
          '     else begin'
          '             TSelPuesto.EditRecord;'
          '             TSelPuesto.FieldName('#39'sel'#39').AsBoolean := True;'
          '             TSelPuesto.PostRecord; '
          '             end;'
          ''
          'end.')
      end
      item
        Key = 116
        Shift = []
        ControlName = 'cxGridDBTableView5'
        isNuevo = True
        isModificar = True
        isBrowse = True
        Source.Strings = (
          'begin'
          '  if (TSelEstado.IsEmpty()) then exit;'
          ''
          '  if (TSelEstado.FieldName('#39'sel'#39').AsBoolean)'
          '     then begin'
          '             TSelEstado.EditRecord;'
          '             TSelEstado.FieldName('#39'sel'#39').AsBoolean := False;'
          '             TSelEstado.PostRecord; '
          '             end'
          '     else begin'
          '             TSelEstado.EditRecord;'
          '             TSelEstado.FieldName('#39'sel'#39').AsBoolean := True;'
          '             TSelEstado.PostRecord; '
          '             end;'
          ''
          'end.')
      end>
    OnInicializar = <
      item
        Source.Strings = (
          'begin'
          '  Inicializar();'
          '  varios.setImagen('#39'ImageBuscar'#39',0);'
          '  varios.setImagen('#39'ImageSalir'#39',7);'
          '  dxDBGridSN1.gotoFirstRecord;'
          '  dxDBGridSN2.gotoFirstRecord;'
          '  dxDBGridSN3.gotoFirstRecord;'
          '  dxDBGridSN4.gotoFirstRecord;'
          '  dxDBGridSN5.gotoFirstRecord;'
          '  dxDBGridSN6.gotoFirstRecord;'
          ''
          'end.')
      end>
    OnFormFunction = <
      item
        Source.Strings = (
          'procedure TraerModelos(Tipo : string);'
          'begin'
          '  operacion.InicioOperacion();'
          '  operacion.setOper('#39'TraerModeloEvalByTipo'#39');'
          ' operacion.AddAtribute('#39'tipo'#39',Tipo);'
          ' operacion.execute();'
          'end;'
          ''
          ''
          'procedure ValidarInput();'
          'begin'
          ''
          'Tinput.PostRecord;'
          'if (Tinput.FieldName('#39'fec_eval_desde'#39').IsNull)'
          
            '    then raiseException(erCustomError,'#39'Debe ingresar la Fecha De' +
            'sde'#39');'
          'if (Tinput.FieldName('#39'fec_eval_hasta'#39').IsNull)'
          
            '    then raiseException(erCustomError,'#39'Debe ingresar la Fecha Ha' +
            'sta'#39');'
          'if (Trim(Tinput.FieldName('#39'tipo'#39').AsString)='#39#39')'
          
            '    then raiseException(erCustomError,'#39'Debe ingresar el Tipo de ' +
            'Evaluaci'#243'n'#39');'
          ''
          'end;'
          ''
          'procedure Inicializar();'
          'begin'
          ''
          '  Tinput.Close;'
          '  Tinput.Open;'
          '  Tinput.AppendRecord;'
          ''
          '  TSINO.Close;'
          '  TSINO.Open;'
          '  TSINO.AppendRecord; '
          '  TSINO.FieldName('#39'valor'#39').AsBoolean := True;'
          '  TSINO.FieldName('#39'descripcion'#39').AsString := '#39'Si'#39';'
          '  TSINO.PostRecord;'
          '  TSINO.AppendRecord; '
          '  TSINO.FieldName('#39'valor'#39').AsBoolean := False;'
          '  TSINO.FieldName('#39'descripcion'#39').AsString := '#39'No'#39';'
          '  TSINO.PostRecord;'
          ''
          '  operacion.InicioOperacion();'
          '  operacion.setOper('#39'TraerFiltrosConsEval'#39');'
          '  operacion.execute();'
          ''
          '  operacion.InicioOperacion();'
          '  operacion.setOper('#39'TraerTiposModEval'#39');'
          '  operacion.execute();'
          ''
          ''
          ''
          ''
          'end;'
          ''
          'procedure EjecutarConsulta();'
          'begin'
          '  variable.newVariantArray('#39'parametros'#39',7);'
          
            '  variable.addKeyTableForArray('#39'parametros'#39',0,'#39'Tinput'#39','#39'TInput'#39')' +
            ';  '
          
            '  variable.addKeyTableForArray('#39'parametros'#39',1,'#39'TSelEvaluaciones'#39 +
            ','#39'TSelEvaluaciones'#39');  '
          
            '  variable.addKeyTableForArray('#39'parametros'#39',2,'#39'TSelLegajos'#39','#39'TSe' +
            'lLegajos'#39');  '
          
            '  variable.addKeyTableForArray('#39'parametros'#39',3,'#39'TSelEmpresas'#39','#39'TS' +
            'elEmpresas'#39');  '
          
            '  variable.addKeyTableForArray('#39'parametros'#39',4,'#39'TSelSector'#39','#39'TSel' +
            'Sector'#39');  '
          
            '  variable.addKeyTableForArray('#39'parametros'#39',5,'#39'TSelPuesto'#39','#39'TSel' +
            'Puesto'#39');  '
          
            '  variable.addKeyTableForArray('#39'parametros'#39',6,'#39'TSelEstado'#39','#39'TSel' +
            'Estado'#39');  '
          ''
          
            '  FormEvaluacionesLegajo.params :=  variable.getValue('#39'parametro' +
            's'#39');'
          '  FormEvaluacionesLegajo.Ventana := getVentana();'
          '  FormEvaluacionesLegajo.Mostrar(false);'
          ''
          'end;'
          '')
      end>
    OnClickToolButton = <
      item
        ButtonName = 'ImageSalir'
        Source.Strings = (
          'begin'
          '  close();'
          'end.')
      end
      item
        ButtonName = 'ImageBuscar'
        Source.Strings = (
          'begin'
          '  ValidarInput();'
          '  TInput.postRecord();'
          '  TSelEvaluaciones.postRecord();'
          '  TSelLegajos.postRecord();'
          '  TSelEmpresas.postRecord();'
          '  TSelSector.postRecord();'
          '  TSelPuesto.postRecord();'
          '  TSelEstado.postRecord();'
          '  EjecutarConsulta();'
          'end.')
      end>
    Left = 632
    Top = 75
  end
  inherited SaveArchivo: TSaveDialog
    Left = 568
    Top = 24
  end
  inherited ImprimirObjetoSeleccionado: TdxComponentPrinter
    Left = 528
    Top = 24
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
    Left = 112
    Top = 240
    object Tinputfec_eval_desde: TDateField
      FieldName = 'fec_eval_desde'
    end
    object Tinputfec_eval_hasta: TDateField
      FieldName = 'fec_eval_hasta'
    end
    object Tinputincluir_leg_sin_evaluar: TBooleanField
      FieldName = 'incluir_leg_sin_evaluar'
    end
    object Tinputver_puntaje: TBooleanField
      FieldName = 'ver_puntaje'
    end
    object Tinputver_grados: TBooleanField
      FieldName = 'ver_grados'
    end
    object Tinputver_porc_grados: TBooleanField
      FieldName = 'ver_porc_grados'
    end
    object Tinputver_punt_compe: TBooleanField
      FieldName = 'ver_punt_compe'
    end
    object Tinputver_promedio: TBooleanField
      FieldName = 'ver_promedio'
    end
    object Tinputtipo: TStringField
      FieldName = 'tipo'
    end
  end
  object DSInput: TDataSource
    DataSet = Tinput
    Left = 144
    Top = 240
  end
  object Varios: TsnVarios
    Operacion = Operacion
    Left = 672
    Top = 76
  end
  object TSINO: TsnTable
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
    Left = 409
    Top = 417
    object TSINOvalor: TBooleanField
      FieldName = 'valor'
    end
    object TSINOdescripcion: TStringField
      FieldName = 'descripcion'
    end
  end
  object DSSINO: TDataSource
    DataSet = TSINO
    Left = 441
    Top = 417
  end
  object TSelEvaluaciones: TsnTable
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
    Left = 72
    Top = 321
    object TSelEvaluacionessel: TBooleanField
      FieldName = 'sel'
    end
    object TSelEvaluacionesoid_mod_eval: TIntegerField
      FieldName = 'oid_mod_eval'
    end
    object TSelEvaluacionesdesc_mod_eval: TStringField
      FieldName = 'desc_mod_eval'
      Size = 100
    end
  end
  object DSTSelEvaluaciones: TDataSource
    DataSet = TSelEvaluaciones
    Left = 104
    Top = 321
  end
  object TSelLegajos: TsnTable
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
    Left = 151
    Top = 321
    object BooleanField1: TBooleanField
      FieldName = 'sel'
    end
    object TSelLegajosoid_legajo: TIntegerField
      FieldName = 'oid_legajo'
    end
    object TSelLegajosnro_legajo: TStringField
      FieldName = 'nro_legajo'
      Size = 50
    end
    object TSelLegajosape_y_nom: TStringField
      FieldName = 'ape_y_nom'
      Size = 100
    end
  end
  object DSSelLegajos: TDataSource
    DataSet = TSelLegajos
    Left = 183
    Top = 321
  end
  object TSelEmpresas: TsnTable
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
    Left = 232
    Top = 321
    object BooleanField2: TBooleanField
      FieldName = 'sel'
    end
    object TSelEmpresasoid_empresa: TIntegerField
      FieldName = 'oid_empresa'
    end
    object TSelEmpresasrazon_social: TStringField
      FieldName = 'razon_social'
      Size = 100
    end
  end
  object DSTSelEmpresas: TDataSource
    DataSet = TSelEmpresas
    Left = 264
    Top = 321
  end
  object TSelSector: TsnTable
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
    Left = 307
    Top = 321
    object BooleanField3: TBooleanField
      FieldName = 'sel'
    end
    object TSelSectoroid_sector: TIntegerField
      FieldName = 'oid_sector'
    end
    object TSelSectordescripcion: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
  end
  object DSSelSector: TDataSource
    DataSet = TSelSector
    Left = 339
    Top = 321
  end
  object TSelPuesto: TsnTable
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
    Left = 383
    Top = 321
    object BooleanField4: TBooleanField
      FieldName = 'sel'
    end
    object TSelPuestooid_puesto: TIntegerField
      FieldName = 'oid_puesto'
    end
    object StringField1: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
  end
  object DSSelPuesto: TDataSource
    DataSet = TSelPuesto
    Left = 415
    Top = 321
  end
  object TSelEstado: TsnTable
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
    Left = 452
    Top = 321
    object BooleanField5: TBooleanField
      FieldName = 'sel'
    end
    object TSelEstadooid_estado: TIntegerField
      FieldName = 'oid_estado'
    end
    object StringField2: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
  end
  object DSSelEstado: TDataSource
    DataSet = TSelEstado
    Left = 484
    Top = 321
  end
  object FormEvaluacionesLegajo: TFormulario
    Nombre = 'TFEvalLegajos'
    CreateAlwaysANewForm = True
    Left = 224
    Top = 278
  end
  object TTiposModEval: TsnTable
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
    Left = 744
    Top = 160
    object TTiposModEvalcodigo: TStringField
      FieldName = 'codigo'
      Size = 50
    end
    object TTiposModEvaldescripcion: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
  end
  object DSTTiposModEval: TDataSource
    DataSet = TTiposModEval
    Left = 784
    Top = 160
  end
end
