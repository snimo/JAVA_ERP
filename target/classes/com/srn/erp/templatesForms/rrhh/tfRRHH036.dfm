inherited FConsFilSeclos: TFConsFilSeclos
  Left = 40
  Top = 179
  Width = 917
  Height = 707
  Caption = 'Filtros consulta  de SECLOS'
  PixelsPerInch = 96
  TextHeight = 13
  object Panel1: TPanel [0]
    Left = 0
    Top = 0
    Width = 901
    Height = 147
    Align = alTop
    BevelOuter = bvNone
    Color = clWindow
    TabOrder = 0
    object Shape4: TShape
      Left = 512
      Top = 82
      Width = 153
      Height = 28
      Brush.Color = 16769217
      Shape = stRoundRect
    end
    object Shape1: TShape
      Left = 16
      Top = 12
      Width = 233
      Height = 28
      Brush.Color = 16769217
      Shape = stRoundRect
    end
    object snLabel2: TsnLabel
      Left = 32
      Top = 17
      Width = 202
      Height = 16
      Caption = 'Fecha de Recepci'#243'n de Seclos'
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
    object Shape3: TShape
      Left = 16
      Top = 82
      Width = 153
      Height = 28
      Brush.Color = 16769217
      Shape = stRoundRect
    end
    object snLabel5: TsnLabel
      Left = 32
      Top = 87
      Width = 116
      Height = 16
      Caption = 'Monto Reclamado'
      Font.Charset = ANSI_CHARSET
      Font.Color = clWindowText
      Font.Height = -13
      Font.Name = 'Verdana'
      Font.Style = []
      ParentFont = False
      Transparent = True
    end
    object snLabel6: TsnLabel
      Left = 32
      Top = 126
      Width = 84
      Height = 16
      Caption = 'Monto Desde:'
      Font.Charset = DEFAULT_CHARSET
      Font.Color = clWindowText
      Font.Height = -13
      Font.Name = 'MS Sans Serif'
      Font.Style = []
      ParentFont = False
    end
    object snLabel7: TsnLabel
      Left = 264
      Top = 127
      Width = 79
      Height = 16
      Caption = 'Monto Hasta:'
      Font.Charset = DEFAULT_CHARSET
      Font.Color = clWindowText
      Font.Height = -13
      Font.Name = 'MS Sans Serif'
      Font.Style = []
      ParentFont = False
    end
    object snLabel8: TsnLabel
      Left = 512
      Top = 126
      Width = 90
      Height = 16
      Caption = 'C'#243'digo Interno:'
      Font.Charset = DEFAULT_CHARSET
      Font.Color = clWindowText
      Font.Height = -13
      Font.Name = 'MS Sans Serif'
      Font.Style = []
      ParentFont = False
    end
    object snLabel9: TsnLabel
      Left = 528
      Top = 87
      Width = 97
      Height = 16
      Caption = 'C'#243'digo Interno'
      Font.Charset = ANSI_CHARSET
      Font.Color = clWindowText
      Font.Height = -13
      Font.Name = 'Verdana'
      Font.Style = []
      ParentFont = False
      Transparent = True
    end
    object snDBDateEdit1: TsnDBDateEdit
      Left = 126
      Top = 50
      DataBinding.DataField = 'fec_rec_desde'
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
      DataBinding.DataField = 'fec_rec_hasta'
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
    object snDBEdit1: TsnDBEdit
      Left = 128
      Top = 122
      DataBinding.DataField = 'monto_desde'
      DataBinding.DataSource = DSInput
      ParentFont = False
      Style.Font.Charset = DEFAULT_CHARSET
      Style.Font.Color = clWindowText
      Style.Font.Height = -13
      Style.Font.Name = 'MS Sans Serif'
      Style.Font.Style = []
      Style.IsFontAssigned = True
      TabOrder = 2
      Width = 121
    end
    object snDBEdit2: TsnDBEdit
      Left = 360
      Top = 123
      DataBinding.DataField = 'monto_hasta'
      DataBinding.DataSource = DSInput
      ParentFont = False
      Style.Font.Charset = DEFAULT_CHARSET
      Style.Font.Color = clWindowText
      Style.Font.Height = -13
      Style.Font.Name = 'MS Sans Serif'
      Style.Font.Style = []
      Style.IsFontAssigned = True
      TabOrder = 3
      Width = 121
    end
    object snDBEdit3: TsnDBEdit
      Left = 608
      Top = 121
      DataBinding.DataField = 'codigo_interno'
      DataBinding.DataSource = DSInput
      ParentFont = False
      Style.Font.Charset = DEFAULT_CHARSET
      Style.Font.Color = clWindowText
      Style.Font.Height = -13
      Style.Font.Name = 'MS Sans Serif'
      Style.Font.Style = []
      Style.IsFontAssigned = True
      TabOrder = 4
      Width = 153
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
  end
  object Panel3: TPanel [2]
    Left = 0
    Top = 147
    Width = 901
    Height = 481
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
        Width = 243
        Height = 16
        Caption = 'Filtros para aplicar sobre los SECLOS'
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
        Width = 279
        Height = 13
        Caption = 'Seleccione registros para restrigir la b'#250'squeda de SECLOS.'
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
      object snLabel10: TsnLabel
        Left = 616
        Top = 18
        Width = 31
        Height = 16
        Caption = 'Tipo:'
        Font.Charset = DEFAULT_CHARSET
        Font.Color = clWindowText
        Font.Height = -13
        Font.Name = 'MS Sans Serif'
        Font.Style = []
        ParentFont = False
      end
      object snDBCheckEdit1: TsnDBCheckEdit
        Left = 324
        Top = 14
        Caption = 'Solo SECLOS con audiencias pendientes.'
        DataBinding.DataField = 'solo_con_aud_pend'
        DataBinding.DataSource = DSInput
        ParentFont = False
        Style.Font.Charset = DEFAULT_CHARSET
        Style.Font.Color = clWindowText
        Style.Font.Height = -13
        Style.Font.Name = 'MS Sans Serif'
        Style.Font.Style = []
        Style.IsFontAssigned = True
        TabOrder = 0
        Width = 277
      end
      object snDBLookup1: TsnDBLookup
        Left = 656
        Top = 14
        DataBinding.DataField = 'tipo'
        DataBinding.DataSource = DSInput
        ParentFont = False
        Properties.KeyFieldNames = 'codigo'
        Properties.ListColumns = <
          item
            FieldName = 'descripcion'
          end>
        Properties.ListOptions.ShowHeader = False
        Properties.ListSource = DSTiposSeclos
        Style.Font.Charset = DEFAULT_CHARSET
        Style.Font.Color = clWindowText
        Style.Font.Height = -13
        Style.Font.Name = 'MS Sans Serif'
        Style.Font.Style = []
        Style.IsFontAssigned = True
        TabOrder = 1
        Width = 193
      end
    end
    object SNScrollBox1: TSNScrollBox
      Left = 0
      Top = 100
      Width = 901
      Height = 381
      HorzScrollBar.Style = ssFlat
      HorzScrollBar.Tracking = True
      Align = alClient
      TabOrder = 1
      object Panel6: TPanel
        Left = 370
        Top = 0
        Width = 344
        Height = 360
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
          Height = 334
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
        Left = 1084
        Top = 0
        Width = 185
        Height = 360
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
          Height = 334
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
        Left = 899
        Top = 0
        Width = 185
        Height = 360
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
          Height = 334
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
        Left = 714
        Top = 0
        Width = 185
        Height = 360
        Align = alLeft
        Color = clWindow
        TabOrder = 2
        object Panel13: TPanel
          Left = 1
          Top = 1
          Width = 183
          Height = 24
          Align = alTop
          Caption = 'Empresa Requerida'
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
          Height = 334
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
        Left = 185
        Top = 0
        Width = 185
        Height = 360
        Align = alLeft
        Color = clWindow
        TabOrder = 0
        object Panel5: TPanel
          Left = 1
          Top = 1
          Width = 183
          Height = 24
          Align = alTop
          Caption = 'Tipo Reclamo'
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
          Height = 334
          Align = alClient
          TabOrder = 1
          LookAndFeel.Kind = lfFlat
          CriteriosPintarCelda = <>
          object dxDBGridSN1DBTableView1: TcxGridDBTableView
            NavigatorButtons.ConfirmDelete = False
            DataController.DataSource = DSTSelTipoReclamo
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
              DataBinding.FieldName = 'desc_tipo_reclamo'
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
        Left = 1269
        Top = 0
        Width = 185
        Height = 360
        Align = alLeft
        Color = clWindow
        TabOrder = 5
        object Panel16: TPanel
          Left = 1
          Top = 1
          Width = 183
          Height = 24
          Align = alTop
          Caption = 'Estado Legajo'
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
          Height = 334
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
      object Panel17: TPanel
        Left = 0
        Top = 0
        Width = 185
        Height = 360
        Align = alLeft
        Color = clWindow
        TabOrder = 6
        object Panel18: TPanel
          Left = 1
          Top = 1
          Width = 183
          Height = 24
          Align = alTop
          Caption = 'Estado SECLO'
          Font.Charset = ANSI_CHARSET
          Font.Color = clWindowText
          Font.Height = -13
          Font.Name = 'Verdana'
          Font.Style = [fsBold]
          ParentFont = False
          TabOrder = 0
        end
        object dxDBGridSN7: TdxDBGridSN
          Left = 1
          Top = 25
          Width = 183
          Height = 334
          Align = alClient
          TabOrder = 1
          LookAndFeel.Kind = lfFlat
          CriteriosPintarCelda = <>
          object cxGridDBTableView6: TcxGridDBTableView
            NavigatorButtons.ConfirmDelete = False
            DataController.DataSource = dsTSelEstadoSECLO
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
            object cxGridDBColumn9: TcxGridDBColumn
              DataBinding.FieldName = 'sel'
              PropertiesClassName = 'TcxCheckBoxProperties'
              Width = 26
              IsCaptionAssigned = True
            end
            object cxGridDBColumn10: TcxGridDBColumn
              DataBinding.FieldName = 'desc_estado_seclo'
              Options.Editing = False
              Width = 132
              IsCaptionAssigned = True
            end
          end
          object cxGridLevel6: TcxGridLevel
            GridView = cxGridDBTableView6
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
      end
      item
        DataSet = TSelTipoReclamo
        TableName = 'TSelTipoReclamo'
      end
      item
        DataSet = TSelEstadoSECLO
        TableName = 'TSelEstadoSECLO'
      end
      item
        DataSet = TTiposSeclos
        TableName = 'TTiposSeclos'
      end>
    Left = 616
    Top = 16
  end
  inherited Operacion: TOperacion
    Left = 656
    Top = 16
  end
  inherited dxComponentPrinter: TdxComponentPrinter
    Left = 696
    Top = 16
    inherited dxComponentPrinterLink1: TdxCustomContainerReportLink
      Component = Owner
      BuiltInReportLink = True
      HiddenComponents = {}
      ExcludedComponents = {}
      AggregatedReportLinks = {}
    end
  end
  inherited SaveDialog: TSaveDialog
    Left = 736
    Top = 16
  end
  inherited DriverEvent: TDriverEvent
    OnShow.Strings = (
      'begin'
      '  snDBDateEdit1.setFoco;'
      'end.')
    OnNuevoRegistro = <
      item
        TableName = 'Tinput'
        Source.Strings = (
          'begin'
          '  DataSet.FieldName('#39'solo_con_aud_pend'#39').AsBoolean := False;'
          '  DataSet.FieldName('#39'tipo'#39').AsString := '#39'SECLO'#39';'
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
      end
      item
        Key = 116
        Shift = []
        ControlName = 'dxDBGridSN1'
        isNuevo = True
        isModificar = True
        isBrowse = True
        Source.Strings = (
          'begin'
          '  if (TSelTipoReclamo.IsEmpty()) then exit;'
          ''
          '  if (TSelTipoReclamo.FieldName('#39'sel'#39').AsBoolean)'
          '     then begin'
          '             TSelTipoReclamo.EditRecord;'
          
            '             TSelTipoReclamo.FieldName('#39'sel'#39').AsBoolean := False' +
            ';'
          '             TSelTipoReclamo.PostRecord; '
          '             end'
          '     else begin'
          '             TSelTipoReclamo.EditRecord;'
          '             TSelTipoReclamo.FieldName('#39'sel'#39').AsBoolean := True;'
          '             TSelTipoReclamo.PostRecord; '
          '             end;'
          ''
          'end.'
          '')
      end
      item
        Key = 116
        Shift = []
        ControlName = 'dxDBGridSN7'
        isNuevo = True
        isModificar = True
        isBrowse = True
        Source.Strings = (
          'begin'
          '  if (TSelEstadoSECLO.IsEmpty()) then exit;'
          ''
          '  if (TSelEstadoSECLO.FieldName('#39'sel'#39').AsBoolean)'
          '     then begin'
          '             TSelEstadoSECLO.EditRecord;'
          
            '             TSelEstadoSECLO.FieldName('#39'sel'#39').AsBoolean := False' +
            ';'
          '             TSelEstadoSECLO.PostRecord; '
          '             end'
          '     else begin'
          '             TSelEstadoSECLO.EditRecord;'
          '             TSelEstadoSECLO.FieldName('#39'sel'#39').AsBoolean := True;'
          '             TSelEstadoSECLO.PostRecord; '
          '             end;'
          ''
          'end.'
          ''
          '')
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
          '  '
          '   operacion.InicioOperacion();'
          '   operacion.setOper('#39'TraerTiposSeclos'#39');'
          '   operacion.execute();'
          ''
          '   TTiposSeclos.AppendRecord;'
          '   TTiposSeclos.FieldName('#39'codigo'#39').AsString := '#39'TODOS'#39';'
          '   TTiposSeclos.FieldName('#39'descripcion'#39').AsString := '#39'TODOS'#39';'
          '   TTiposSeclos.PostRecord;'
          ''
          ''
          'end.')
      end>
    OnFormFunction = <
      item
        Source.Strings = (
          'procedure ValidarInput();'
          'begin'
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
          '  operacion.InicioOperacion();'
          '  operacion.setOper('#39'TraerFiltrosConsSECLOS'#39');'
          '  operacion.execute();'
          ''
          ''
          'end;'
          ''
          'procedure EjecutarConsulta();'
          'begin'
          ''
          '   TSelTipoReclamo.postRecord;'
          '   TSelEstadoSECLO.postRecord;'
          '   TSelLegajos.postRecord;'
          '   TSelEmpresas.postRecord;'
          '   TSelSector.postRecord;'
          '   TSelPuesto.postRecord;'
          '   TSelEstado.postRecord;'
          ''
          '  variable.newVariantArray('#39'parametros'#39',8);'
          
            '  variable.addKeyTableForArray('#39'parametros'#39',0,'#39'Tinput'#39','#39'TInput'#39')' +
            ';  '
          
            '  variable.addKeyTableForArray('#39'parametros'#39',1,'#39'TSelTipoReclamo'#39',' +
            #39'TSelTipoReclamo'#39');  '
          
            '  variable.addKeyTableForArray('#39'parametros'#39',2,'#39'TSelEstadoSECLO'#39',' +
            #39'TSelEstadoSECLO'#39');  '
          
            '  variable.addKeyTableForArray('#39'parametros'#39',3,'#39'TSelLegajos'#39','#39'TSe' +
            'lLegajos'#39');  '
          
            '  variable.addKeyTableForArray('#39'parametros'#39',4,'#39'TSelEmpresas'#39','#39'TS' +
            'elEmpresas'#39');  '
          
            '  variable.addKeyTableForArray('#39'parametros'#39',5,'#39'TSelSector'#39','#39'TSel' +
            'Sector'#39');  '
          
            '  variable.addKeyTableForArray('#39'parametros'#39',6,'#39'TSelPuesto'#39','#39'TSel' +
            'Puesto'#39');  '
          
            '  variable.addKeyTableForArray('#39'parametros'#39',7,'#39'TSelEstado'#39','#39'TSel' +
            'Estado'#39');  '
          ''
          '  FormConsSECLOS.params :=  variable.getValue('#39'parametros'#39');'
          '  FormConsSECLOS.Ventana := getVentana();'
          '  FormConsSECLOS.Mostrar(false);'
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
    Left = 776
    Top = 19
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
    object Tinputmonto_desde: TCurrencyField
      FieldName = 'monto_desde'
      DisplayFormat = '###,###,###,###.##'
    end
    object Tinputmonto_hasta: TCurrencyField
      FieldName = 'monto_hasta'
      DisplayFormat = '###,###,###,###.##'
    end
    object Tinputcodigo_interno: TStringField
      FieldName = 'codigo_interno'
      Size = 50
    end
    object Tinputsolo_con_aud_pend: TBooleanField
      FieldName = 'solo_con_aud_pend'
    end
    object Tinputfec_rec_desde: TDateField
      FieldName = 'fec_rec_desde'
    end
    object Tinputfec_rec_hasta: TDateField
      FieldName = 'fec_rec_hasta'
    end
    object Tinputtipo: TStringField
      FieldName = 'tipo'
      Size = 10
    end
  end
  object DSInput: TDataSource
    DataSet = Tinput
    Left = 144
    Top = 240
  end
  object Varios: TsnVarios
    Operacion = Operacion
    Left = 816
    Top = 20
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
  object FormConsSECLOS: TFormulario
    Nombre = 'TFConsSECLOS'
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
    Left = 760
    Top = 128
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
    Left = 792
    Top = 128
  end
  object TSelTipoReclamo: TsnTable
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
    Top = 362
    object BooleanField6: TBooleanField
      FieldName = 'sel'
    end
    object TSelTipoReclamooid_tipo_reclamo: TIntegerField
      FieldName = 'oid_tipo_reclamo'
    end
    object TSelTipoReclamodesc_tipo_reclamo: TStringField
      FieldName = 'desc_tipo_reclamo'
      Size = 100
    end
  end
  object DSTSelTipoReclamo: TDataSource
    DataSet = TSelTipoReclamo
    Left = 104
    Top = 362
  end
  object TSelEstadoSECLO: TsnTable
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
    Top = 404
    object BooleanField7: TBooleanField
      FieldName = 'sel'
    end
    object TSelEstadoSECLOoid_estado_seclo: TIntegerField
      FieldName = 'oid_estado_seclo'
    end
    object TSelEstadoSECLOdesc_estado_seclo: TStringField
      FieldName = 'desc_estado_seclo'
      Size = 255
    end
  end
  object dsTSelEstadoSECLO: TDataSource
    DataSet = TSelEstadoSECLO
    Left = 104
    Top = 404
  end
  object snVarios1: TsnVarios
    Operacion = Operacion
    Left = 688
    Top = 76
  end
  object TTiposSeclos: TsnTable
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
    Left = 784
    Top = 88
    object TTiposSecloscodigo: TStringField
      FieldName = 'codigo'
      Size = 50
    end
    object TTiposSeclosdescripcion: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
  end
  object DSTiposSeclos: TDataSource
    DataSet = TTiposSeclos
    Left = 816
    Top = 88
  end
end
