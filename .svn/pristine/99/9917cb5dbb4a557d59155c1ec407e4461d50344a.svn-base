inherited FRankearCab: TFRankearCab
  Left = 140
  Top = 114
  Width = 792
  Height = 806
  Caption = 'Rankear'
  PixelsPerInch = 96
  TextHeight = 13
  inherited PForm: TPanel
    Width = 776
    Height = 768
    inherited PPie: TPanel
      Top = 747
      Width = 776
      inherited StatusBarABM: TStatusBar
        Left = 671
      end
      inherited StatusBar2: TStatusBar
        Width = 671
      end
    end
    inherited PMenu: TPanel
      Width = 776
      inherited ImagenEliminar: TImagenEstado
        DataField = 'activo'
        DataSource = DSTRankearCab
        ValorEstadoVisible = 'True'
      end
      inherited ImagenRehabilitar: TImagenEstado
        DataField = 'activo'
        DataSource = DSTRankearCab
        ValorEstadoVisible = 'False'
      end
      inherited ImagenBuscar: TImagenHelpObjNeg
        Help = HelpRankear
      end
      inherited ImagenSiguiente: TImagenHelpObjNeg
        Help = HelpRankear
      end
      inherited ImagenAnterior: TImagenHelpObjNeg
        Help = HelpRankear
      end
      inherited Panel2: TPanel
        Left = 735
      end
      inherited PanelEstadoON: TPanelEstado
        DataField = 'activo'
        DataSource = DSTRankearCab
        Leyendas = <
          item
            Titulo = 'Inactivo'
            ColorTitulo = clWhite
            ValorEstado = 'false'
            Visible = True
            ColorPanel = clRed
          end>
      end
    end
    inherited POpcionesMenu: TPanel
      Width = 776
    end
    inherited PCabecera: TPanel
      Width = 776
      Height = 48
      object Label2: TLabel
        Left = 40
        Top = 8
        Width = 33
        Height = 13
        Caption = 'C'#243'digo'
      end
      object Label1: TLabel
        Left = 40
        Top = 32
        Width = 56
        Height = 13
        Caption = 'Descripci'#243'n'
      end
      object DBEDescripcion: TsnDBEdit
        Left = 124
        Top = 4
        DataBinding.DataField = 'codigo'
        DataBinding.DataSource = DSTRankearCab
        Properties.CharCase = ecUpperCase
        Properties.MaxLength = 20
        Style.BorderColor = clWindowFrame
        Style.Shadow = False
        TabOrder = 0
        Width = 189
      end
      object snDBEdit1: TsnDBEdit
        Left = 124
        Top = 28
        DataBinding.DataField = 'descripcion'
        DataBinding.DataSource = DSTRankearCab
        Properties.MaxLength = 100
        Style.BorderColor = clWindowFrame
        Style.Shadow = False
        TabOrder = 1
        Width = 429
      end
    end
    inherited PCuerpo: TPanel
      Top = 100
      Width = 776
      Height = 647
      BorderWidth = 5
      object PageControlSN1: TPageControlSN
        Left = 5
        Top = 5
        Width = 766
        Height = 637
        ActivePage = TabSheet1
        Align = alClient
        TabOrder = 0
        object TabSheet1: TTabSheet
          Caption = 'C'#225'lculo de Puntos       '
          object Splitter1: TSplitter
            Left = 0
            Top = 227
            Width = 758
            Height = 5
            Cursor = crVSplit
            Align = alTop
            Color = 4227327
            ParentColor = False
          end
          object Panel1: TPanel
            Left = 0
            Top = 0
            Width = 758
            Height = 31
            Align = alTop
            Color = clWindow
            TabOrder = 0
            object snLabel1: TsnLabel
              Left = 232
              Top = 8
              Width = 81
              Height = 13
              Caption = 'Sumar los puntos'
            end
            object snLabel2: TsnLabel
              Left = 400
              Top = 8
              Width = 45
              Height = 13
              Caption = 'por cada '
            end
            object snLabel3: TsnLabel
              Left = 576
              Top = 8
              Width = 116
              Height = 13
              Caption = 'con una ponderaci'#243'n de'
            end
            object snDBCheckEdit1: TsnDBCheckEdit
              Left = 8
              Top = 4
              Caption = 'Rankear por ant. en la Empresa'
              DataBinding.DataField = 'rank_por_ant_emp'
              DataBinding.DataSource = DSTRankearCab
              ParentFont = False
              Style.Font.Charset = DEFAULT_CHARSET
              Style.Font.Color = clWindowText
              Style.Font.Height = -11
              Style.Font.Name = 'MS Sans Serif'
              Style.Font.Style = [fsBold]
              Style.IsFontAssigned = True
              TabOrder = 0
              Width = 209
            end
            object snDBEdit2: TsnDBEdit
              Left = 320
              Top = 4
              DataBinding.DataField = 'ptos_ant_emp'
              DataBinding.DataSource = DSTRankearCab
              TabOrder = 1
              Width = 73
            end
            object snDBLookup1: TsnDBLookup
              Left = 452
              Top = 4
              DataBinding.DataField = 'ut_ant_emp'
              DataBinding.DataSource = DSTRankearCab
              Properties.KeyFieldNames = 'codigo'
              Properties.ListColumns = <
                item
                  FieldName = 'descripcion'
                end>
              Properties.ListOptions.ShowHeader = False
              Properties.ListSource = DSUnidadTiempo
              TabOrder = 2
              Width = 117
            end
            object snDBEdit3: TsnDBEdit
              Left = 696
              Top = 4
              DataBinding.DataField = 'pond_ant_emp'
              DataBinding.DataSource = DSTRankearCab
              TabOrder = 3
              Width = 49
            end
          end
          object Panel3: TPanel
            Left = 0
            Top = 69
            Width = 758
            Height = 48
            Align = alTop
            Color = clWindow
            TabOrder = 1
            object snLabel4: TsnLabel
              Left = 232
              Top = 7
              Width = 81
              Height = 13
              Caption = 'Tomar los '#250'ltimos'
            end
            object snLabel5: TsnLabel
              Left = 400
              Top = 7
              Width = 236
              Height = 13
              Caption = 'meses, sumando por cada punto la calificaci'#243'n de'
            end
            object snLabel6: TsnLabel
              Left = 232
              Top = 28
              Width = 116
              Height = 13
              Caption = 'con una ponderaci'#243'n de'
            end
            object snDBCheckEdit2: TsnDBCheckEdit
              Left = 8
              Top = 4
              Caption = 'Rankear por Eval. de Desempe'#241'o'
              DataBinding.DataField = 'rank_por_eval'
              DataBinding.DataSource = DSTRankearCab
              ParentFont = False
              Style.Font.Charset = DEFAULT_CHARSET
              Style.Font.Color = clWindowText
              Style.Font.Height = -11
              Style.Font.Name = 'MS Sans Serif'
              Style.Font.Style = [fsBold]
              Style.IsFontAssigned = True
              TabOrder = 0
              Width = 217
            end
            object snDBEdit4: TsnDBEdit
              Left = 320
              Top = 3
              DataBinding.DataField = 'eval_ult_meses'
              DataBinding.DataSource = DSTRankearCab
              TabOrder = 1
              Width = 73
            end
            object snDBEdit5: TsnDBEdit
              Left = 640
              Top = 3
              DataBinding.DataField = 'eval_calif_punto'
              DataBinding.DataSource = DSTRankearCab
              TabOrder = 2
              Width = 73
            end
            object snDBEdit8: TsnDBEdit
              Left = 360
              Top = 24
              DataBinding.DataField = 'eval_ponderacion'
              DataBinding.DataSource = DSTRankearCab
              TabOrder = 3
              Width = 49
            end
          end
          object Panel4: TPanel
            Left = 0
            Top = 31
            Width = 758
            Height = 38
            Align = alTop
            Color = clWindow
            TabOrder = 2
            object snLabel7: TsnLabel
              Left = 231
              Top = 12
              Width = 81
              Height = 13
              Caption = 'Sumar los puntos'
            end
            object snLabel8: TsnLabel
              Left = 399
              Top = 12
              Width = 45
              Height = 13
              Caption = 'por cada '
            end
            object snLabel9: TsnLabel
              Left = 575
              Top = 12
              Width = 116
              Height = 13
              Caption = 'con una ponderaci'#243'n de'
            end
            object snDBCheckEdit3: TsnDBCheckEdit
              Left = 8
              Top = 8
              Caption = 'Rankear por ant. en el Puesto'
              DataBinding.DataField = 'rank_por_ant_pue'
              DataBinding.DataSource = DSTRankearCab
              ParentFont = False
              Style.Font.Charset = DEFAULT_CHARSET
              Style.Font.Color = clWindowText
              Style.Font.Height = -11
              Style.Font.Name = 'MS Sans Serif'
              Style.Font.Style = [fsBold]
              Style.IsFontAssigned = True
              TabOrder = 0
              Width = 201
            end
            object snDBEdit6: TsnDBEdit
              Left = 319
              Top = 8
              DataBinding.DataField = 'ptos_ant_pue'
              DataBinding.DataSource = DSTRankearCab
              TabOrder = 1
              Width = 73
            end
            object snDBLookup3: TsnDBLookup
              Left = 451
              Top = 8
              DataBinding.DataField = 'ut_ant_pue'
              DataBinding.DataSource = DSTRankearCab
              Properties.KeyFieldNames = 'codigo'
              Properties.ListColumns = <
                item
                  FieldName = 'descripcion'
                end>
              Properties.ListOptions.ShowHeader = False
              Properties.ListSource = DSUnidadTiempo
              TabOrder = 2
              Width = 117
            end
            object snDBEdit7: TsnDBEdit
              Left = 695
              Top = 8
              DataBinding.DataField = 'pond_ant_pue'
              DataBinding.DataSource = DSTRankearCab
              TabOrder = 3
              Width = 49
            end
          end
          object Panel5: TPanel
            Left = 0
            Top = 232
            Width = 758
            Height = 377
            Align = alClient
            BevelOuter = bvNone
            Color = clWindow
            TabOrder = 4
            object Panel25: TPanel
              Left = 0
              Top = 0
              Width = 758
              Height = 22
              Align = alTop
              Color = clWindow
              TabOrder = 0
              object snLabel15: TsnLabel
                Left = 464
                Top = 4
                Width = 39
                Height = 13
                Caption = 'puntos'
                Font.Charset = DEFAULT_CHARSET
                Font.Color = clWindowText
                Font.Height = -11
                Font.Name = 'MS Sans Serif'
                Font.Style = [fsBold]
                ParentFont = False
              end
              object snDBCheckEdit4: TsnDBCheckEdit
                Left = 8
                Top = 0
                Caption = 'Rankear por Novedad'
                DataBinding.DataField = 'rank_por_novedad'
                DataBinding.DataSource = DSTRankearCab
                ParentFont = False
                Style.Font.Charset = DEFAULT_CHARSET
                Style.Font.Color = clWindowText
                Style.Font.Height = -11
                Style.Font.Name = 'MS Sans Serif'
                Style.Font.Style = [fsBold]
                Style.IsFontAssigned = True
                TabOrder = 0
                Width = 161
              end
              object snDBCheckEdit24: TsnDBCheckEdit
                Left = 200
                Top = 0
                Caption = 'Desaprueba si resta m'#225's de '
                DataBinding.DataField = 'des_nov_rest_mas'
                DataBinding.DataSource = DSTRankearCab
                ParentFont = False
                Style.Font.Charset = DEFAULT_CHARSET
                Style.Font.Color = clWindowText
                Style.Font.Height = -11
                Style.Font.Name = 'MS Sans Serif'
                Style.Font.Style = [fsBold]
                Style.IsFontAssigned = True
                TabOrder = 1
                Width = 185
              end
              object snDBEdit43: TsnDBEdit
                Left = 384
                Top = 0
                DataBinding.DataField = 'ptos_max_rest_nov'
                DataBinding.DataSource = DSTRankearCab
                TabOrder = 2
                Width = 73
              end
            end
            object dxDBGridSN1: TdxDBGridSN
              Left = 0
              Top = 22
              Width = 758
              Height = 355
              Align = alClient
              TabOrder = 1
              LookAndFeel.Kind = lfFlat
              CriteriosPintarCelda = <>
              object dxDBGridSN1DBTableView1: TcxGridDBTableView
                NavigatorButtons.ConfirmDelete = False
                DataController.DataSource = DSRankearNovedad
                DataController.Options = [dcoAssignGroupingValues, dcoAssignMasterDetailKeys, dcoSaveExpanding, dcoGroupsAlwaysExpanded]
                DataController.Summary.DefaultGroupSummaryItems = <>
                DataController.Summary.FooterSummaryItems = <>
                DataController.Summary.SummaryGroups = <>
                OptionsBehavior.FocusCellOnTab = True
                OptionsBehavior.FocusFirstCellOnNewRecord = True
                OptionsBehavior.GoToNextCellOnEnter = True
                OptionsBehavior.FocusCellOnCycle = True
                OptionsData.Inserting = False
                OptionsView.GroupByBox = False
                object dxDBGridSN1DBTableView1desc_tipo_nov: TcxGridDBColumn
                  Caption = 'Novedad'
                  DataBinding.FieldName = 'desc_tipo_nov'
                  Visible = False
                  GroupIndex = 0
                  HeaderAlignmentVert = vaCenter
                  Options.Editing = False
                  Width = 108
                end
                object dxDBGridSN1DBTableView1desc_motivo: TcxGridDBColumn
                  Caption = 'Motivo'
                  DataBinding.FieldName = 'desc_motivo'
                  HeaderAlignmentHorz = taCenter
                  Options.Editing = False
                  SortIndex = 0
                  SortOrder = soAscending
                  Width = 218
                end
                object dxDBGridSN1DBTableView1aplicar: TcxGridDBColumn
                  Caption = 'Rankear?'
                  DataBinding.FieldName = 'aplicar'
                  HeaderAlignmentHorz = taCenter
                  Width = 65
                end
                object dxDBGridSN1DBTableView1suma_o_resta: TcxGridDBColumn
                  Caption = 'Suma o Resta?'
                  DataBinding.FieldName = 'suma_o_resta'
                  PropertiesClassName = 'TcxLookupComboBoxProperties'
                  Properties.KeyFieldNames = 'codigo'
                  Properties.ListColumns = <
                    item
                      FieldName = 'descripcion'
                    end>
                  Properties.ListOptions.ShowHeader = False
                  Properties.ListSource = DSSumaResta
                  HeaderAlignmentHorz = taCenter
                  Width = 100
                end
                object dxDBGridSN1DBTableView1calif_en_puntos: TcxGridDBColumn
                  Caption = 'Calif. Puntos'
                  DataBinding.FieldName = 'calif_en_puntos'
                  HeaderAlignmentHorz = taCenter
                  Width = 71
                end
                object dxDBGridSN1DBTableView1analizar_ult_meses: TcxGridDBColumn
                  Caption = 'Ult. Meses'
                  DataBinding.FieldName = 'analizar_ult_meses'
                  HeaderAlignmentHorz = taCenter
                  Width = 65
                end
                object dxDBGridSN1DBTableView1ponderacion: TcxGridDBColumn
                  Caption = 'Ponderaci'#243'n'
                  DataBinding.FieldName = 'ponderacion'
                  HeaderAlignmentHorz = taCenter
                  Width = 75
                end
              end
              object dxDBGridSN1Level1: TcxGridLevel
                GridView = dxDBGridSN1DBTableView1
              end
            end
          end
          object Panel6: TPanel
            Left = 0
            Top = 117
            Width = 758
            Height = 110
            Align = alTop
            Color = clWindow
            TabOrder = 3
            object Panel23: TPanel
              Left = 1
              Top = 1
              Width = 756
              Height = 108
              Align = alClient
              Color = clWindow
              TabOrder = 0
              object Panel24: TPanel
                Left = 1
                Top = 1
                Width = 754
                Height = 21
                Align = alTop
                BevelOuter = bvNone
                Color = clWindow
                TabOrder = 0
                object snLabel14: TsnLabel
                  Left = 464
                  Top = 4
                  Width = 39
                  Height = 13
                  Caption = 'puntos'
                  Font.Charset = DEFAULT_CHARSET
                  Font.Color = clWindowText
                  Font.Height = -11
                  Font.Name = 'MS Sans Serif'
                  Font.Style = [fsBold]
                  ParentFont = False
                end
                object snDBCheckEdit13: TsnDBCheckEdit
                  Left = 8
                  Top = 0
                  Caption = 'Rankear por Sanciones'
                  DataBinding.DataField = 'rank_por_sancion'
                  DataBinding.DataSource = DSTRankearCab
                  ParentFont = False
                  Style.Font.Charset = DEFAULT_CHARSET
                  Style.Font.Color = clWindowText
                  Style.Font.Height = -11
                  Style.Font.Name = 'MS Sans Serif'
                  Style.Font.Style = [fsBold]
                  Style.IsFontAssigned = True
                  TabOrder = 0
                  Width = 161
                end
                object snDBCheckEdit23: TsnDBCheckEdit
                  Left = 200
                  Top = 0
                  Caption = 'Desaprueba si resta m'#225's de '
                  DataBinding.DataField = 'des_sanc_rest_mas'
                  DataBinding.DataSource = DSTRankearCab
                  ParentFont = False
                  Style.Font.Charset = DEFAULT_CHARSET
                  Style.Font.Color = clWindowText
                  Style.Font.Height = -11
                  Style.Font.Name = 'MS Sans Serif'
                  Style.Font.Style = [fsBold]
                  Style.IsFontAssigned = True
                  TabOrder = 1
                  Width = 185
                end
                object snDBEdit42: TsnDBEdit
                  Left = 384
                  Top = 0
                  DataBinding.DataField = 'ptos_max_rest_sanc'
                  DataBinding.DataSource = DSTRankearCab
                  TabOrder = 2
                  Width = 73
                end
              end
              object dxDBGridSN7: TdxDBGridSN
                Left = 1
                Top = 22
                Width = 754
                Height = 85
                Align = alClient
                TabOrder = 1
                LookAndFeel.Kind = lfFlat
                CriteriosPintarCelda = <>
                object cxGridDBTableView6: TcxGridDBTableView
                  NavigatorButtons.ConfirmDelete = False
                  DataController.DataSource = dsTSancionRank
                  DataController.Options = [dcoAssignGroupingValues, dcoAssignMasterDetailKeys, dcoSaveExpanding, dcoGroupsAlwaysExpanded]
                  DataController.Summary.DefaultGroupSummaryItems = <>
                  DataController.Summary.FooterSummaryItems = <>
                  DataController.Summary.SummaryGroups = <>
                  OptionsBehavior.FocusCellOnTab = True
                  OptionsBehavior.FocusFirstCellOnNewRecord = True
                  OptionsBehavior.FocusCellOnCycle = True
                  OptionsData.Inserting = False
                  OptionsView.GroupByBox = False
                  object cxGridDBColumn13: TcxGridDBColumn
                    Caption = 'Novedad'
                    DataBinding.FieldName = 'desc_tipo_nov'
                    Visible = False
                    GroupIndex = 0
                    HeaderAlignmentVert = vaCenter
                    Options.Editing = False
                    Width = 108
                  end
                  object cxGridDBColumn14: TcxGridDBColumn
                    Caption = 'Sanci'#243'n'
                    DataBinding.FieldName = 'desc_mot_sancion'
                    HeaderAlignmentHorz = taCenter
                    Options.Editing = False
                    SortIndex = 0
                    SortOrder = soAscending
                    Width = 218
                  end
                  object cxGridDBColumn15: TcxGridDBColumn
                    Caption = 'Rankear?'
                    DataBinding.FieldName = 'aplicar'
                    HeaderAlignmentHorz = taCenter
                    Width = 65
                  end
                  object cxGridDBColumn16: TcxGridDBColumn
                    Caption = 'Suma o Resta?'
                    DataBinding.FieldName = 'suma_o_resta'
                    PropertiesClassName = 'TcxLookupComboBoxProperties'
                    Properties.KeyFieldNames = 'codigo'
                    Properties.ListColumns = <
                      item
                        FieldName = 'descripcion'
                      end>
                    Properties.ListOptions.ShowHeader = False
                    Properties.ListSource = DSSumaResta
                    HeaderAlignmentHorz = taCenter
                    Width = 100
                  end
                  object cxGridDBColumn17: TcxGridDBColumn
                    Caption = 'Calif. Puntos'
                    DataBinding.FieldName = 'calif_en_puntos'
                    HeaderAlignmentHorz = taCenter
                    Width = 71
                  end
                  object cxGridDBColumn18: TcxGridDBColumn
                    Caption = 'Ult. Meses'
                    DataBinding.FieldName = 'analizar_ult_meses'
                    HeaderAlignmentHorz = taCenter
                    Width = 65
                  end
                  object cxGridDBColumn19: TcxGridDBColumn
                    Caption = 'Ponderaci'#243'n'
                    DataBinding.FieldName = 'ponderacion'
                    HeaderAlignmentHorz = taCenter
                    Width = 75
                  end
                end
                object cxGridLevel6: TcxGridLevel
                  GridView = cxGridDBTableView6
                end
              end
            end
          end
        end
        object TabSheet2: TTabSheet
          Caption = 'Condiciones Necesarias           '
          ImageIndex = 1
          object Panel7: TPanel
            Left = 0
            Top = 0
            Width = 758
            Height = 40
            Align = alTop
            Color = clWindow
            TabOrder = 0
            object snLabel10: TsnLabel
              Left = 48
              Top = 19
              Width = 99
              Height = 13
              Caption = 'Se requiere al menos'
            end
            object snDBCheckEdit5: TsnDBCheckEdit
              Left = 8
              Top = -2
              Caption = 'Antiguedad M'#237'nima Requerida en la Empresa'
              DataBinding.DataField = 'cm_ant_req_emp'
              DataBinding.DataSource = DSTRankearCab
              ParentFont = False
              Style.Font.Charset = DEFAULT_CHARSET
              Style.Font.Color = clWindowText
              Style.Font.Height = -11
              Style.Font.Name = 'MS Sans Serif'
              Style.Font.Style = [fsBold]
              Style.IsFontAssigned = True
              TabOrder = 0
              Width = 289
            end
            object snDBEdit9: TsnDBEdit
              Left = 160
              Top = 15
              DataBinding.DataField = 'cm_cant_req_emp'
              DataBinding.DataSource = DSTRankearCab
              TabOrder = 2
              Width = 73
            end
            object snDBLookup2: TsnDBLookup
              Left = 236
              Top = 15
              DataBinding.DataField = 'cm_ut_req_emp'
              DataBinding.DataSource = DSTRankearCab
              Properties.KeyFieldNames = 'codigo'
              Properties.ListColumns = <
                item
                  FieldName = 'descripcion'
                end>
              Properties.ListOptions.ShowHeader = False
              Properties.ListSource = DSUnidadTiempo
              TabOrder = 3
              Width = 133
            end
            object snDBCheckEdit14: TsnDBCheckEdit
              Left = 384
              Top = -2
              Caption = 'Controlar Estado Desarrollo del Legajo'
              DataBinding.DataField = 'control_esta_desa'
              DataBinding.DataSource = DSTRankearCab
              ParentFont = False
              Style.Font.Charset = DEFAULT_CHARSET
              Style.Font.Color = clWindowText
              Style.Font.Height = -11
              Style.Font.Name = 'MS Sans Serif'
              Style.Font.Style = [fsBold]
              Style.IsFontAssigned = True
              TabOrder = 1
              Width = 289
            end
            object snDBCheckEdit21: TsnDBCheckEdit
              Left = 384
              Top = 15
              Caption = 'Controlar cantidad de Juegos A'
              DataBinding.DataField = 'cm_aplic_juegos_a'
              DataBinding.DataSource = DSTRankearCab
              ParentFont = False
              Style.Font.Charset = DEFAULT_CHARSET
              Style.Font.Color = clWindowText
              Style.Font.Height = -11
              Style.Font.Name = 'MS Sans Serif'
              Style.Font.Style = [fsBold]
              Style.IsFontAssigned = True
              TabOrder = 4
              Width = 289
            end
          end
          object Panel8: TPanel
            Left = 0
            Top = 40
            Width = 758
            Height = 40
            Align = alTop
            Color = clWindow
            TabOrder = 1
            object snLabel11: TsnLabel
              Left = 296
              Top = 5
              Width = 99
              Height = 13
              Caption = 'Se requiere al menos'
            end
            object snDBCheckEdit6: TsnDBCheckEdit
              Left = 8
              Top = 2
              Caption = 'Antiguedad M'#237'nima Requerida en el Puesto'
              DataBinding.DataField = 'cm_ant_req_pue'
              DataBinding.DataSource = DSTRankearCab
              ParentFont = False
              Style.Font.Charset = DEFAULT_CHARSET
              Style.Font.Color = clWindowText
              Style.Font.Height = -11
              Style.Font.Name = 'MS Sans Serif'
              Style.Font.Style = [fsBold]
              Style.IsFontAssigned = True
              TabOrder = 0
              Width = 281
            end
            object snDBEdit10: TsnDBEdit
              Left = 408
              Top = 1
              DataBinding.DataField = 'cm_cant_req_pue'
              DataBinding.DataSource = DSTRankearCab
              TabOrder = 1
              Width = 73
            end
            object snDBLookup4: TsnDBLookup
              Left = 484
              Top = 1
              DataBinding.DataField = 'cm_ut_req_pue'
              DataBinding.DataSource = DSTRankearCab
              Properties.KeyFieldNames = 'codigo'
              Properties.ListColumns = <
                item
                  FieldName = 'descripcion'
                end>
              Properties.ListOptions.ShowHeader = False
              Properties.ListSource = DSUnidadTiempo
              TabOrder = 2
              Width = 133
            end
            object snDBCheckEdit22: TsnDBCheckEdit
              Left = 8
              Top = 18
              Caption = 'Control Antiguedad en el Sector Vs. Horizonte de Carrera'
              DataBinding.DataField = 'cm_aplic_hor_car'
              DataBinding.DataSource = DSTRankearCab
              ParentFont = False
              Style.Font.Charset = DEFAULT_CHARSET
              Style.Font.Color = clWindowText
              Style.Font.Height = -11
              Style.Font.Name = 'MS Sans Serif'
              Style.Font.Style = [fsBold]
              Style.IsFontAssigned = True
              TabOrder = 3
              Width = 353
            end
          end
          object Panel9: TPanel
            Left = 0
            Top = 80
            Width = 758
            Height = 38
            Align = alTop
            Color = clWindow
            TabOrder = 2
            object snLabel12: TsnLabel
              Left = 48
              Top = 20
              Width = 201
              Height = 13
              Caption = 'Puntaje m'#237'nimo evaluaci'#243'n de desempe'#241'o'
            end
            object snLabel13: TsnLabel
              Left = 376
              Top = 20
              Width = 169
              Height = 13
              Caption = 'Puntaje m'#237'nimo calificaci'#243'n General'
            end
            object snDBCheckEdit7: TsnDBCheckEdit
              Left = 8
              Top = 0
              Caption = 'Puntaje M'#237'nimo Evaluaci'#243'n de Desempe'#241'o'
              DataBinding.DataField = 'cm_aplicar_eval'
              DataBinding.DataSource = DSTRankearCab
              ParentFont = False
              Style.Font.Charset = DEFAULT_CHARSET
              Style.Font.Color = clWindowText
              Style.Font.Height = -11
              Style.Font.Name = 'MS Sans Serif'
              Style.Font.Style = [fsBold]
              Style.IsFontAssigned = True
              TabOrder = 0
              Width = 289
            end
            object snDBEdit11: TsnDBEdit
              Left = 256
              Top = 16
              DataBinding.DataField = 'cm_puntaje_eval'
              DataBinding.DataSource = DSTRankearCab
              TabOrder = 1
              Width = 73
            end
            object snDBCheckEdit20: TsnDBCheckEdit
              Left = 336
              Top = 0
              Caption = 'Puntaje M'#237'nimo Calificaci'#243'n General'
              DataBinding.DataField = 'cm_calif_gral'
              DataBinding.DataSource = DSTRankearCab
              ParentFont = False
              Style.Font.Charset = DEFAULT_CHARSET
              Style.Font.Color = clWindowText
              Style.Font.Height = -11
              Style.Font.Name = 'MS Sans Serif'
              Style.Font.Style = [fsBold]
              Style.IsFontAssigned = True
              TabOrder = 2
              Width = 289
            end
            object snDBEdit41: TsnDBEdit
              Left = 560
              Top = 15
              DataBinding.DataField = 'cm_ptos_min_calif'
              DataBinding.DataSource = DSTRankearCab
              TabOrder = 3
              Width = 73
            end
          end
          object Panel10: TPanel
            Left = 0
            Top = 118
            Width = 758
            Height = 491
            Align = alClient
            BorderWidth = 5
            Color = clWindow
            TabOrder = 3
            object Panel11: TPanel
              Left = 6
              Top = 6
              Width = 746
              Height = 42
              Align = alTop
              BevelOuter = bvNone
              Color = clWindow
              TabOrder = 0
              object Label3: TLabel
                Left = 8
                Top = -2
                Width = 298
                Height = 13
                Caption = 'Sanciones / Licencias / Ausentismo / Suspensiones'
                Font.Charset = DEFAULT_CHARSET
                Font.Color = clWindowText
                Font.Height = -11
                Font.Name = 'MS Sans Serif'
                Font.Style = [fsBold]
                ParentFont = False
              end
              object snDBCheckEdit8: TsnDBCheckEdit
                Left = 15
                Top = 10
                Caption = 'Novedad Nro. 1'
                DataBinding.DataField = 'cm_aplic_nov_1'
                DataBinding.DataSource = DSTRankearCab
                ParentFont = False
                Style.Font.Charset = DEFAULT_CHARSET
                Style.Font.Color = clWindowText
                Style.Font.Height = -11
                Style.Font.Name = 'MS Sans Serif'
                Style.Font.Style = []
                Style.IsFontAssigned = True
                TabOrder = 0
                Width = 113
              end
              object snDBCheckEdit9: TsnDBCheckEdit
                Left = 135
                Top = 9
                Caption = 'Novedad Nro. 2'
                DataBinding.DataField = 'cm_aplic_nov_2'
                DataBinding.DataSource = DSTRankearCab
                ParentFont = False
                Style.Font.Charset = DEFAULT_CHARSET
                Style.Font.Color = clWindowText
                Style.Font.Height = -11
                Style.Font.Name = 'MS Sans Serif'
                Style.Font.Style = []
                Style.IsFontAssigned = True
                TabOrder = 1
                Width = 121
              end
              object snDBCheckEdit10: TsnDBCheckEdit
                Left = 255
                Top = 9
                Caption = 'Novedad Nro. 3'
                DataBinding.DataField = 'cm_aplic_nov_3'
                DataBinding.DataSource = DSTRankearCab
                ParentFont = False
                Style.Font.Charset = DEFAULT_CHARSET
                Style.Font.Color = clWindowText
                Style.Font.Height = -11
                Style.Font.Name = 'MS Sans Serif'
                Style.Font.Style = []
                Style.IsFontAssigned = True
                TabOrder = 2
                Width = 121
              end
              object snDBCheckEdit11: TsnDBCheckEdit
                Left = 375
                Top = 9
                Caption = 'Novedad Nro. 4'
                DataBinding.DataField = 'cm_aplic_nov_4'
                DataBinding.DataSource = DSTRankearCab
                ParentFont = False
                Style.Font.Charset = DEFAULT_CHARSET
                Style.Font.Color = clWindowText
                Style.Font.Height = -11
                Style.Font.Name = 'MS Sans Serif'
                Style.Font.Style = []
                Style.IsFontAssigned = True
                TabOrder = 3
                Width = 121
              end
              object snDBCheckEdit12: TsnDBCheckEdit
                Left = 503
                Top = 9
                Caption = 'Novedad Nro. 5'
                DataBinding.DataField = 'cm_aplic_nov_5'
                DataBinding.DataSource = DSTRankearCab
                ParentFont = False
                Style.Font.Charset = DEFAULT_CHARSET
                Style.Font.Color = clWindowText
                Style.Font.Height = -11
                Style.Font.Name = 'MS Sans Serif'
                Style.Font.Style = []
                Style.IsFontAssigned = True
                TabOrder = 4
                Width = 121
              end
              object snDBCheckEdit15: TsnDBCheckEdit
                Left = 15
                Top = 26
                Caption = 'Sanci'#243'n Nro. 1'
                DataBinding.DataField = 'cm_aplic_nov_6'
                DataBinding.DataSource = DSTRankearCab
                ParentFont = False
                Style.Font.Charset = DEFAULT_CHARSET
                Style.Font.Color = clWindowText
                Style.Font.Height = -11
                Style.Font.Name = 'MS Sans Serif'
                Style.Font.Style = []
                Style.IsFontAssigned = True
                TabOrder = 5
                Width = 113
              end
              object snDBCheckEdit16: TsnDBCheckEdit
                Left = 135
                Top = 25
                Caption = 'Sanci'#243'n Nro. 2'
                DataBinding.DataField = 'cm_aplic_nov_7'
                DataBinding.DataSource = DSTRankearCab
                ParentFont = False
                Style.Font.Charset = DEFAULT_CHARSET
                Style.Font.Color = clWindowText
                Style.Font.Height = -11
                Style.Font.Name = 'MS Sans Serif'
                Style.Font.Style = []
                Style.IsFontAssigned = True
                TabOrder = 6
                Width = 121
              end
              object snDBCheckEdit17: TsnDBCheckEdit
                Left = 255
                Top = 25
                Caption = 'Sanci'#243'n Nro. 3'
                DataBinding.DataField = 'cm_aplic_nov_8'
                DataBinding.DataSource = DSTRankearCab
                ParentFont = False
                Style.Font.Charset = DEFAULT_CHARSET
                Style.Font.Color = clWindowText
                Style.Font.Height = -11
                Style.Font.Name = 'MS Sans Serif'
                Style.Font.Style = []
                Style.IsFontAssigned = True
                TabOrder = 7
                Width = 121
              end
              object snDBCheckEdit18: TsnDBCheckEdit
                Left = 375
                Top = 25
                Caption = 'Sanci'#243'n Nro. 4'
                DataBinding.DataField = 'cm_aplic_nov_9'
                DataBinding.DataSource = DSTRankearCab
                ParentFont = False
                Style.Font.Charset = DEFAULT_CHARSET
                Style.Font.Color = clWindowText
                Style.Font.Height = -11
                Style.Font.Name = 'MS Sans Serif'
                Style.Font.Style = []
                Style.IsFontAssigned = True
                TabOrder = 8
                Width = 121
              end
              object snDBCheckEdit19: TsnDBCheckEdit
                Left = 503
                Top = 25
                Caption = 'Sanci'#243'n Nro. 5'
                DataBinding.DataField = 'cm_aplic_nov_10'
                DataBinding.DataSource = DSTRankearCab
                ParentFont = False
                Style.Font.Charset = DEFAULT_CHARSET
                Style.Font.Color = clWindowText
                Style.Font.Height = -11
                Style.Font.Name = 'MS Sans Serif'
                Style.Font.Style = []
                Style.IsFontAssigned = True
                TabOrder = 9
                Width = 121
              end
            end
            object Panel12: TPanel
              Left = 6
              Top = 48
              Width = 746
              Height = 437
              Align = alClient
              Color = clWindow
              TabOrder = 1
              object PageControlSN2: TPageControlSN
                Left = 1
                Top = 1
                Width = 744
                Height = 435
                ActivePage = TabSheet3
                Align = alClient
                TabOrder = 0
                object TabSheet3: TTabSheet
                  Caption = 'Novedades 1    '
                  object Panel13: TPanel
                    Left = 0
                    Top = 0
                    Width = 736
                    Height = 28
                    Align = alTop
                    BorderStyle = bsSingle
                    Color = clWindow
                    TabOrder = 0
                    object Label4: TLabel
                      Left = 8
                      Top = 5
                      Width = 139
                      Height = 13
                      Caption = 'Desaprueba si tiene al menos'
                    end
                    object Label6: TLabel
                      Left = 416
                      Top = 5
                      Width = 63
                      Height = 13
                      Caption = 'en los '#250'ltimos'
                    end
                    object Label7: TLabel
                      Left = 525
                      Top = 5
                      Width = 30
                      Height = 13
                      Caption = 'meses'
                    end
                    object snDBEdit12: TsnDBEdit
                      Left = 150
                      Top = 1
                      DataBinding.DataField = 'cm_dias_nov_1'
                      DataBinding.DataSource = DSTRankearCab
                      TabOrder = 0
                      Width = 39
                    end
                    object snDBEdit13: TsnDBEdit
                      Left = 192
                      Top = 1
                      DataBinding.DataField = 'cm_motivos_1'
                      DataBinding.DataSource = DSTRankearCab
                      TabOrder = 1
                      Width = 219
                    end
                    object snDBEdit14: TsnDBEdit
                      Left = 482
                      Top = 1
                      DataBinding.DataField = 'cm_ult_mes_nov_1'
                      DataBinding.DataSource = DSTRankearCab
                      TabOrder = 2
                      Width = 39
                    end
                  end
                  object Panel14: TPanel
                    Left = 0
                    Top = 28
                    Width = 736
                    Height = 379
                    Align = alClient
                    BorderStyle = bsSingle
                    Color = clWindow
                    TabOrder = 1
                    object dxDBGridSN2: TdxDBGridSN
                      Left = 1
                      Top = 1
                      Width = 730
                      Height = 373
                      Align = alClient
                      TabOrder = 0
                      LookAndFeel.Kind = lfFlat
                      CriteriosPintarCelda = <>
                      object cxGridDBTableView1: TcxGridDBTableView
                        NavigatorButtons.ConfirmDelete = False
                        DataController.DataSource = DSCondMinRank1
                        DataController.Options = [dcoAssignGroupingValues, dcoAssignMasterDetailKeys, dcoSaveExpanding, dcoGroupsAlwaysExpanded]
                        DataController.Summary.DefaultGroupSummaryItems = <>
                        DataController.Summary.FooterSummaryItems = <>
                        DataController.Summary.SummaryGroups = <>
                        OptionsData.Deleting = False
                        OptionsData.DeletingConfirmation = False
                        OptionsData.Inserting = False
                        OptionsView.GroupByBox = False
                        object cxGridDBTableView1tipo_nov: TcxGridDBColumn
                          Caption = 'Novedad'
                          DataBinding.FieldName = 'tipo_nov'
                          Visible = False
                          GroupIndex = 0
                          Width = 100
                        end
                        object cxGridDBTableView1motivo: TcxGridDBColumn
                          Caption = 'Motivo'
                          DataBinding.FieldName = 'motivo'
                          Options.Editing = False
                          SortIndex = 0
                          SortOrder = soAscending
                          Width = 274
                        end
                        object cxGridDBTableView1activo: TcxGridDBColumn
                          Caption = 'Usar?'
                          DataBinding.FieldName = 'activo'
                          PropertiesClassName = 'TcxCheckBoxProperties'
                          Width = 48
                        end
                      end
                      object cxGridLevel1: TcxGridLevel
                        GridView = cxGridDBTableView1
                      end
                    end
                  end
                end
                object TabSheet4: TTabSheet
                  Caption = 'Novedades 2    '
                  ImageIndex = 1
                  object Panel15: TPanel
                    Left = 0
                    Top = 0
                    Width = 736
                    Height = 28
                    Align = alTop
                    BorderStyle = bsSingle
                    Color = clWindow
                    TabOrder = 0
                    object Label8: TLabel
                      Left = 8
                      Top = 5
                      Width = 139
                      Height = 13
                      Caption = 'Desaprueba si tiene al menos'
                    end
                    object Label10: TLabel
                      Left = 420
                      Top = 5
                      Width = 63
                      Height = 13
                      Caption = 'en los '#250'ltimos'
                    end
                    object Label11: TLabel
                      Left = 529
                      Top = 5
                      Width = 30
                      Height = 13
                      Caption = 'meses'
                    end
                    object cm_dias_nov_2: TsnDBEdit
                      Left = 154
                      Top = 1
                      DataBinding.DataField = 'cm_dias_nov_2'
                      DataBinding.DataSource = DSTRankearCab
                      TabOrder = 0
                      Width = 39
                    end
                    object snDBEdit16: TsnDBEdit
                      Left = 198
                      Top = 1
                      DataBinding.DataField = 'cm_motivos_2'
                      DataBinding.DataSource = DSTRankearCab
                      TabOrder = 1
                      Width = 212
                    end
                    object snDBEdit17: TsnDBEdit
                      Left = 486
                      Top = 1
                      DataBinding.DataField = 'cm_ult_mes_nov_2'
                      DataBinding.DataSource = DSTRankearCab
                      TabOrder = 2
                      Width = 39
                    end
                  end
                  object Panel16: TPanel
                    Left = 0
                    Top = 28
                    Width = 736
                    Height = 395
                    Align = alClient
                    BorderStyle = bsSingle
                    Color = clWindow
                    TabOrder = 1
                    object dxDBGridSN3: TdxDBGridSN
                      Left = 1
                      Top = 1
                      Width = 730
                      Height = 389
                      Align = alClient
                      TabOrder = 0
                      LookAndFeel.Kind = lfFlat
                      CriteriosPintarCelda = <>
                      object cxGridDBTableView2: TcxGridDBTableView
                        NavigatorButtons.ConfirmDelete = False
                        DataController.DataSource = DSCondMinRank2
                        DataController.Options = [dcoAssignGroupingValues, dcoAssignMasterDetailKeys, dcoSaveExpanding, dcoGroupsAlwaysExpanded]
                        DataController.Summary.DefaultGroupSummaryItems = <>
                        DataController.Summary.FooterSummaryItems = <>
                        DataController.Summary.SummaryGroups = <>
                        OptionsData.Deleting = False
                        OptionsData.DeletingConfirmation = False
                        OptionsData.Inserting = False
                        OptionsView.GroupByBox = False
                        object cxGridDBColumn1: TcxGridDBColumn
                          Caption = 'Novedad'
                          DataBinding.FieldName = 'tipo_nov'
                          Visible = False
                          GroupIndex = 0
                          Width = 100
                        end
                        object cxGridDBColumn2: TcxGridDBColumn
                          Caption = 'Motivo'
                          DataBinding.FieldName = 'motivo'
                          Options.Editing = False
                          SortIndex = 0
                          SortOrder = soAscending
                          Width = 274
                        end
                        object cxGridDBColumn3: TcxGridDBColumn
                          Caption = 'Usar?'
                          DataBinding.FieldName = 'activo'
                          PropertiesClassName = 'TcxCheckBoxProperties'
                          Width = 43
                        end
                      end
                      object cxGridLevel2: TcxGridLevel
                        GridView = cxGridDBTableView2
                      end
                    end
                  end
                end
                object TabSheet5: TTabSheet
                  Caption = 'Novedades 3    '
                  ImageIndex = 2
                  object Panel17: TPanel
                    Left = 0
                    Top = 0
                    Width = 736
                    Height = 28
                    Align = alTop
                    BorderStyle = bsSingle
                    Color = clWindow
                    TabOrder = 0
                    object Label12: TLabel
                      Left = 8
                      Top = 5
                      Width = 139
                      Height = 13
                      Caption = 'Desaprueba si tiene al menos'
                    end
                    object Label14: TLabel
                      Left = 422
                      Top = 5
                      Width = 63
                      Height = 13
                      Caption = 'en los '#250'ltimos'
                    end
                    object Label15: TLabel
                      Left = 531
                      Top = 5
                      Width = 30
                      Height = 13
                      Caption = 'meses'
                    end
                    object snDBEdit18: TsnDBEdit
                      Left = 156
                      Top = 1
                      DataBinding.DataField = 'cm_dias_nov_3'
                      DataBinding.DataSource = DSTRankearCab
                      TabOrder = 0
                      Width = 39
                    end
                    object snDBEdit19: TsnDBEdit
                      Left = 200
                      Top = 1
                      DataBinding.DataField = 'cm_motivos_3'
                      DataBinding.DataSource = DSTRankearCab
                      TabOrder = 1
                      Width = 217
                    end
                    object snDBEdit20: TsnDBEdit
                      Left = 488
                      Top = 1
                      DataBinding.DataField = 'cm_ult_mes_nov_3'
                      DataBinding.DataSource = DSTRankearCab
                      TabOrder = 2
                      Width = 39
                    end
                  end
                  object Panel18: TPanel
                    Left = 0
                    Top = 28
                    Width = 736
                    Height = 395
                    Align = alClient
                    BorderStyle = bsSingle
                    Color = clWindow
                    TabOrder = 1
                    object dxDBGridSN4: TdxDBGridSN
                      Left = 1
                      Top = 1
                      Width = 730
                      Height = 389
                      Align = alClient
                      TabOrder = 0
                      LookAndFeel.Kind = lfFlat
                      CriteriosPintarCelda = <>
                      object cxGridDBTableView3: TcxGridDBTableView
                        NavigatorButtons.ConfirmDelete = False
                        DataController.DataSource = DSCondMinRank3
                        DataController.Options = [dcoAssignGroupingValues, dcoAssignMasterDetailKeys, dcoSaveExpanding, dcoGroupsAlwaysExpanded]
                        DataController.Summary.DefaultGroupSummaryItems = <>
                        DataController.Summary.FooterSummaryItems = <>
                        DataController.Summary.SummaryGroups = <>
                        OptionsData.Deleting = False
                        OptionsData.DeletingConfirmation = False
                        OptionsData.Inserting = False
                        OptionsView.GroupByBox = False
                        object cxGridDBColumn4: TcxGridDBColumn
                          Caption = 'Novedad'
                          DataBinding.FieldName = 'tipo_nov'
                          Visible = False
                          GroupIndex = 0
                          Width = 100
                        end
                        object cxGridDBColumn5: TcxGridDBColumn
                          Caption = 'Motivo'
                          DataBinding.FieldName = 'motivo'
                          Options.Editing = False
                          SortIndex = 0
                          SortOrder = soAscending
                          Width = 274
                        end
                        object cxGridDBColumn6: TcxGridDBColumn
                          Caption = 'Usar?'
                          DataBinding.FieldName = 'activo'
                          PropertiesClassName = 'TcxCheckBoxProperties'
                          Width = 46
                        end
                      end
                      object cxGridLevel3: TcxGridLevel
                        GridView = cxGridDBTableView3
                      end
                    end
                  end
                end
                object TabSheet6: TTabSheet
                  Caption = 'Novedades 4    '
                  ImageIndex = 3
                  object Panel19: TPanel
                    Left = 0
                    Top = 0
                    Width = 736
                    Height = 28
                    Align = alTop
                    BorderStyle = bsSingle
                    Color = clWindow
                    TabOrder = 0
                    object Label16: TLabel
                      Left = 8
                      Top = 5
                      Width = 139
                      Height = 13
                      Caption = 'Desaprueba si tiene al menos'
                    end
                    object Label18: TLabel
                      Left = 430
                      Top = 5
                      Width = 63
                      Height = 13
                      Caption = 'en los '#250'ltimos'
                    end
                    object Label19: TLabel
                      Left = 539
                      Top = 5
                      Width = 30
                      Height = 13
                      Caption = 'meses'
                    end
                    object snDBEdit21: TsnDBEdit
                      Left = 164
                      Top = 1
                      DataBinding.DataField = 'cm_dias_nov_4'
                      DataBinding.DataSource = DSTRankearCab
                      TabOrder = 0
                      Width = 39
                    end
                    object snDBEdit22: TsnDBEdit
                      Left = 208
                      Top = 1
                      DataBinding.DataField = 'cm_motivos_4'
                      DataBinding.DataSource = DSTRankearCab
                      TabOrder = 1
                      Width = 217
                    end
                    object snDBEdit23: TsnDBEdit
                      Left = 496
                      Top = 1
                      DataBinding.DataField = 'cm_ult_mes_nov_4'
                      DataBinding.DataSource = DSTRankearCab
                      TabOrder = 2
                      Width = 39
                    end
                  end
                  object Panel20: TPanel
                    Left = 0
                    Top = 28
                    Width = 736
                    Height = 395
                    Align = alClient
                    BorderStyle = bsSingle
                    Color = clWindow
                    TabOrder = 1
                    object dxDBGridSN5: TdxDBGridSN
                      Left = 1
                      Top = 1
                      Width = 730
                      Height = 389
                      Align = alClient
                      TabOrder = 0
                      LookAndFeel.Kind = lfFlat
                      CriteriosPintarCelda = <>
                      object cxGridDBTableView4: TcxGridDBTableView
                        NavigatorButtons.ConfirmDelete = False
                        DataController.DataSource = DSCondMinRank4
                        DataController.Options = [dcoAssignGroupingValues, dcoAssignMasterDetailKeys, dcoSaveExpanding, dcoGroupsAlwaysExpanded]
                        DataController.Summary.DefaultGroupSummaryItems = <>
                        DataController.Summary.FooterSummaryItems = <>
                        DataController.Summary.SummaryGroups = <>
                        OptionsData.Deleting = False
                        OptionsData.DeletingConfirmation = False
                        OptionsData.Inserting = False
                        OptionsView.GroupByBox = False
                        object cxGridDBColumn7: TcxGridDBColumn
                          Caption = 'Novedad'
                          DataBinding.FieldName = 'tipo_nov'
                          Visible = False
                          GroupIndex = 0
                          Width = 100
                        end
                        object cxGridDBColumn8: TcxGridDBColumn
                          Caption = 'Motivo'
                          DataBinding.FieldName = 'motivo'
                          Options.Editing = False
                          SortIndex = 0
                          SortOrder = soAscending
                          Width = 274
                        end
                        object cxGridDBColumn9: TcxGridDBColumn
                          Caption = 'Usar?'
                          DataBinding.FieldName = 'activo'
                          PropertiesClassName = 'TcxCheckBoxProperties'
                          Width = 45
                        end
                      end
                      object cxGridLevel4: TcxGridLevel
                        GridView = cxGridDBTableView4
                      end
                    end
                  end
                end
                object TabSheet7: TTabSheet
                  Caption = 'Novedades 5    '
                  ImageIndex = 4
                  object Panel21: TPanel
                    Left = 0
                    Top = 0
                    Width = 736
                    Height = 28
                    Align = alTop
                    BorderStyle = bsSingle
                    Color = clWindow
                    TabOrder = 0
                    object Label20: TLabel
                      Left = 8
                      Top = 5
                      Width = 139
                      Height = 13
                      Caption = 'Desaprueba si tiene al menos'
                    end
                    object Label22: TLabel
                      Left = 422
                      Top = 5
                      Width = 63
                      Height = 13
                      Caption = 'en los '#250'ltimos'
                    end
                    object Label23: TLabel
                      Left = 531
                      Top = 5
                      Width = 30
                      Height = 13
                      Caption = 'meses'
                    end
                    object snDBEdit24: TsnDBEdit
                      Left = 156
                      Top = 1
                      DataBinding.DataField = 'cm_dias_nov_5'
                      DataBinding.DataSource = DSTRankearCab
                      TabOrder = 0
                      Width = 39
                    end
                    object snDBEdit25: TsnDBEdit
                      Left = 200
                      Top = 1
                      DataBinding.DataField = 'cm_motivos_5'
                      DataBinding.DataSource = DSTRankearCab
                      TabOrder = 1
                      Width = 217
                    end
                    object snDBEdit26: TsnDBEdit
                      Left = 488
                      Top = 1
                      DataBinding.DataField = 'cm_ult_mes_nov_5'
                      DataBinding.DataSource = DSTRankearCab
                      TabOrder = 2
                      Width = 39
                    end
                  end
                  object Panel22: TPanel
                    Left = 0
                    Top = 28
                    Width = 736
                    Height = 276
                    Align = alClient
                    BorderStyle = bsSingle
                    Color = clWindow
                    TabOrder = 1
                    object dxDBGridSN6: TdxDBGridSN
                      Left = 1
                      Top = 1
                      Width = 730
                      Height = 270
                      Align = alClient
                      TabOrder = 0
                      LookAndFeel.Kind = lfFlat
                      CriteriosPintarCelda = <>
                      object cxGridDBTableView5: TcxGridDBTableView
                        NavigatorButtons.ConfirmDelete = False
                        DataController.DataSource = DSCondMinRank5
                        DataController.Options = [dcoAssignGroupingValues, dcoAssignMasterDetailKeys, dcoSaveExpanding, dcoGroupsAlwaysExpanded]
                        DataController.Summary.DefaultGroupSummaryItems = <>
                        DataController.Summary.FooterSummaryItems = <>
                        DataController.Summary.SummaryGroups = <>
                        OptionsData.Deleting = False
                        OptionsData.DeletingConfirmation = False
                        OptionsData.Inserting = False
                        OptionsView.GroupByBox = False
                        object cxGridDBColumn10: TcxGridDBColumn
                          Caption = 'Novedad'
                          DataBinding.FieldName = 'tipo_nov'
                          Visible = False
                          GroupIndex = 0
                          Width = 100
                        end
                        object cxGridDBColumn11: TcxGridDBColumn
                          Caption = 'Motivo'
                          DataBinding.FieldName = 'motivo'
                          Options.Editing = False
                          SortIndex = 0
                          SortOrder = soAscending
                          Width = 274
                        end
                        object cxGridDBColumn12: TcxGridDBColumn
                          Caption = 'Usar?'
                          DataBinding.FieldName = 'activo'
                          PropertiesClassName = 'TcxCheckBoxProperties'
                          Width = 42
                        end
                      end
                      object cxGridLevel5: TcxGridLevel
                        GridView = cxGridDBTableView5
                      end
                    end
                  end
                end
                object TabSheet8: TTabSheet
                  Caption = 'Sanciones 1'
                  ImageIndex = 5
                  object Panel26: TPanel
                    Left = 0
                    Top = 0
                    Width = 736
                    Height = 28
                    Align = alTop
                    BorderStyle = bsSingle
                    Color = clWindow
                    TabOrder = 0
                    object Label5: TLabel
                      Left = 8
                      Top = 5
                      Width = 139
                      Height = 13
                      Caption = 'Desaprueba si tiene al menos'
                    end
                    object Label9: TLabel
                      Left = 416
                      Top = 5
                      Width = 63
                      Height = 13
                      Caption = 'en los '#250'ltimos'
                    end
                    object Label13: TLabel
                      Left = 525
                      Top = 5
                      Width = 30
                      Height = 13
                      Caption = 'meses'
                    end
                    object snDBEdit15: TsnDBEdit
                      Left = 150
                      Top = 1
                      DataBinding.DataField = 'cm_dias_nov_6'
                      DataBinding.DataSource = DSTRankearCab
                      TabOrder = 0
                      Width = 39
                    end
                    object snDBEdit27: TsnDBEdit
                      Left = 192
                      Top = 1
                      DataBinding.DataField = 'cm_motivos_6'
                      DataBinding.DataSource = DSTRankearCab
                      TabOrder = 1
                      Width = 219
                    end
                    object snDBEdit28: TsnDBEdit
                      Left = 482
                      Top = 1
                      DataBinding.DataField = 'cm_ult_mes_nov_6'
                      DataBinding.DataSource = DSTRankearCab
                      TabOrder = 2
                      Width = 39
                    end
                  end
                  object dxDBGridSN8: TdxDBGridSN
                    Left = 0
                    Top = 28
                    Width = 736
                    Height = 276
                    Align = alClient
                    TabOrder = 1
                    LookAndFeel.Kind = lfFlat
                    CriteriosPintarCelda = <>
                    object cxGridDBTableView7: TcxGridDBTableView
                      NavigatorButtons.ConfirmDelete = False
                      DataController.DataSource = DSCondMinSanc6
                      DataController.Options = [dcoAssignGroupingValues, dcoAssignMasterDetailKeys, dcoSaveExpanding, dcoGroupsAlwaysExpanded]
                      DataController.Summary.DefaultGroupSummaryItems = <>
                      DataController.Summary.FooterSummaryItems = <>
                      DataController.Summary.SummaryGroups = <>
                      OptionsData.Deleting = False
                      OptionsData.DeletingConfirmation = False
                      OptionsData.Inserting = False
                      OptionsView.GroupByBox = False
                      object cxGridDBColumn21: TcxGridDBColumn
                        Caption = 'Sanci'#243'n'
                        DataBinding.FieldName = 'desc_mot_sancion'
                        Options.Editing = False
                        SortIndex = 0
                        SortOrder = soAscending
                        Width = 274
                      end
                      object cxGridDBColumn22: TcxGridDBColumn
                        Caption = 'Usar?'
                        DataBinding.FieldName = 'activo'
                        PropertiesClassName = 'TcxCheckBoxProperties'
                        Width = 48
                      end
                    end
                    object cxGridLevel7: TcxGridLevel
                      GridView = cxGridDBTableView7
                    end
                  end
                end
                object TabSheet9: TTabSheet
                  Caption = 'Sanciones 2'
                  ImageIndex = 6
                  object Panel27: TPanel
                    Left = 0
                    Top = 0
                    Width = 736
                    Height = 28
                    Align = alTop
                    BorderStyle = bsSingle
                    Color = clWindow
                    TabOrder = 0
                    object Label17: TLabel
                      Left = 8
                      Top = 5
                      Width = 139
                      Height = 13
                      Caption = 'Desaprueba si tiene al menos'
                    end
                    object Label21: TLabel
                      Left = 416
                      Top = 5
                      Width = 63
                      Height = 13
                      Caption = 'en los '#250'ltimos'
                    end
                    object Label24: TLabel
                      Left = 525
                      Top = 5
                      Width = 30
                      Height = 13
                      Caption = 'meses'
                    end
                    object snDBEdit29: TsnDBEdit
                      Left = 150
                      Top = 1
                      DataBinding.DataField = 'cm_dias_nov_7'
                      DataBinding.DataSource = DSTRankearCab
                      TabOrder = 0
                      Width = 39
                    end
                    object snDBEdit30: TsnDBEdit
                      Left = 192
                      Top = 1
                      DataBinding.DataField = 'cm_motivos_7'
                      DataBinding.DataSource = DSTRankearCab
                      TabOrder = 1
                      Width = 219
                    end
                    object snDBEdit31: TsnDBEdit
                      Left = 482
                      Top = 1
                      DataBinding.DataField = 'cm_ult_mes_nov_7'
                      DataBinding.DataSource = DSTRankearCab
                      TabOrder = 2
                      Width = 39
                    end
                  end
                  object dxDBGridSN9: TdxDBGridSN
                    Left = 0
                    Top = 28
                    Width = 736
                    Height = 276
                    Align = alClient
                    TabOrder = 1
                    LookAndFeel.Kind = lfFlat
                    CriteriosPintarCelda = <>
                    object cxGridDBTableView8: TcxGridDBTableView
                      NavigatorButtons.ConfirmDelete = False
                      DataController.DataSource = DSTCondMinSanc7
                      DataController.Options = [dcoAssignGroupingValues, dcoAssignMasterDetailKeys, dcoSaveExpanding, dcoGroupsAlwaysExpanded]
                      DataController.Summary.DefaultGroupSummaryItems = <>
                      DataController.Summary.FooterSummaryItems = <>
                      DataController.Summary.SummaryGroups = <>
                      OptionsData.Deleting = False
                      OptionsData.DeletingConfirmation = False
                      OptionsData.Inserting = False
                      OptionsView.GroupByBox = False
                      object cxGridDBColumn20: TcxGridDBColumn
                        Caption = 'Sanci'#243'n'
                        DataBinding.FieldName = 'desc_mot_sancion'
                        Options.Editing = False
                        SortIndex = 0
                        SortOrder = soAscending
                        Width = 274
                      end
                      object cxGridDBColumn23: TcxGridDBColumn
                        Caption = 'Usar?'
                        DataBinding.FieldName = 'activo'
                        PropertiesClassName = 'TcxCheckBoxProperties'
                        Width = 48
                      end
                    end
                    object cxGridLevel8: TcxGridLevel
                      GridView = cxGridDBTableView8
                    end
                  end
                end
                object TabSheet10: TTabSheet
                  Caption = 'Sanciones 3'
                  ImageIndex = 7
                  object Panel28: TPanel
                    Left = 0
                    Top = 0
                    Width = 736
                    Height = 28
                    Align = alTop
                    BorderStyle = bsSingle
                    Color = clWindow
                    TabOrder = 0
                    object Label25: TLabel
                      Left = 8
                      Top = 5
                      Width = 139
                      Height = 13
                      Caption = 'Desaprueba si tiene al menos'
                    end
                    object Label26: TLabel
                      Left = 416
                      Top = 5
                      Width = 63
                      Height = 13
                      Caption = 'en los '#250'ltimos'
                    end
                    object Label27: TLabel
                      Left = 525
                      Top = 5
                      Width = 30
                      Height = 13
                      Caption = 'meses'
                    end
                    object snDBEdit32: TsnDBEdit
                      Left = 150
                      Top = 1
                      DataBinding.DataField = 'cm_dias_nov_8'
                      DataBinding.DataSource = DSTRankearCab
                      TabOrder = 0
                      Width = 39
                    end
                    object snDBEdit33: TsnDBEdit
                      Left = 192
                      Top = 1
                      DataBinding.DataField = 'cm_motivos_8'
                      DataBinding.DataSource = DSTRankearCab
                      TabOrder = 1
                      Width = 219
                    end
                    object snDBEdit34: TsnDBEdit
                      Left = 482
                      Top = 1
                      DataBinding.DataField = 'cm_ult_mes_nov_8'
                      DataBinding.DataSource = DSTRankearCab
                      TabOrder = 2
                      Width = 39
                    end
                  end
                  object dxDBGridSN10: TdxDBGridSN
                    Left = 0
                    Top = 28
                    Width = 736
                    Height = 276
                    Align = alClient
                    TabOrder = 1
                    LookAndFeel.Kind = lfFlat
                    CriteriosPintarCelda = <>
                    object cxGridDBTableView9: TcxGridDBTableView
                      NavigatorButtons.ConfirmDelete = False
                      DataController.DataSource = DSTCondMinSanc8
                      DataController.Options = [dcoAssignGroupingValues, dcoAssignMasterDetailKeys, dcoSaveExpanding, dcoGroupsAlwaysExpanded]
                      DataController.Summary.DefaultGroupSummaryItems = <>
                      DataController.Summary.FooterSummaryItems = <>
                      DataController.Summary.SummaryGroups = <>
                      OptionsData.Deleting = False
                      OptionsData.DeletingConfirmation = False
                      OptionsData.Inserting = False
                      OptionsView.GroupByBox = False
                      object cxGridDBColumn24: TcxGridDBColumn
                        Caption = 'Sanci'#243'n'
                        DataBinding.FieldName = 'desc_mot_sancion'
                        Options.Editing = False
                        SortIndex = 0
                        SortOrder = soAscending
                        Width = 274
                      end
                      object cxGridDBColumn25: TcxGridDBColumn
                        Caption = 'Usar?'
                        DataBinding.FieldName = 'activo'
                        PropertiesClassName = 'TcxCheckBoxProperties'
                        Width = 48
                      end
                    end
                    object cxGridLevel9: TcxGridLevel
                      GridView = cxGridDBTableView9
                    end
                  end
                end
                object TabSheet11: TTabSheet
                  Caption = 'Sanciones 4'
                  ImageIndex = 8
                  object Panel29: TPanel
                    Left = 0
                    Top = 0
                    Width = 736
                    Height = 28
                    Align = alTop
                    BorderStyle = bsSingle
                    Color = clWindow
                    TabOrder = 0
                    object Label28: TLabel
                      Left = 8
                      Top = 5
                      Width = 139
                      Height = 13
                      Caption = 'Desaprueba si tiene al menos'
                    end
                    object Label29: TLabel
                      Left = 416
                      Top = 5
                      Width = 63
                      Height = 13
                      Caption = 'en los '#250'ltimos'
                    end
                    object Label30: TLabel
                      Left = 525
                      Top = 5
                      Width = 30
                      Height = 13
                      Caption = 'meses'
                    end
                    object snDBEdit35: TsnDBEdit
                      Left = 150
                      Top = 1
                      DataBinding.DataField = 'cm_dias_nov_9'
                      DataBinding.DataSource = DSTRankearCab
                      TabOrder = 0
                      Width = 39
                    end
                    object snDBEdit36: TsnDBEdit
                      Left = 192
                      Top = 1
                      DataBinding.DataField = 'cm_motivos_9'
                      DataBinding.DataSource = DSTRankearCab
                      TabOrder = 1
                      Width = 219
                    end
                    object snDBEdit37: TsnDBEdit
                      Left = 482
                      Top = 1
                      DataBinding.DataField = 'cm_ult_mes_nov_9'
                      DataBinding.DataSource = DSTRankearCab
                      TabOrder = 2
                      Width = 39
                    end
                  end
                  object dxDBGridSN11: TdxDBGridSN
                    Left = 0
                    Top = 28
                    Width = 736
                    Height = 276
                    Align = alClient
                    TabOrder = 1
                    LookAndFeel.Kind = lfFlat
                    CriteriosPintarCelda = <>
                    object cxGridDBTableView10: TcxGridDBTableView
                      NavigatorButtons.ConfirmDelete = False
                      DataController.DataSource = DSTCondMinSanc9
                      DataController.Options = [dcoAssignGroupingValues, dcoAssignMasterDetailKeys, dcoSaveExpanding, dcoGroupsAlwaysExpanded]
                      DataController.Summary.DefaultGroupSummaryItems = <>
                      DataController.Summary.FooterSummaryItems = <>
                      DataController.Summary.SummaryGroups = <>
                      OptionsData.Deleting = False
                      OptionsData.DeletingConfirmation = False
                      OptionsData.Inserting = False
                      OptionsView.GroupByBox = False
                      object cxGridDBColumn26: TcxGridDBColumn
                        Caption = 'Sanci'#243'n'
                        DataBinding.FieldName = 'desc_mot_sancion'
                        Options.Editing = False
                        SortIndex = 0
                        SortOrder = soAscending
                        Width = 274
                      end
                      object cxGridDBColumn27: TcxGridDBColumn
                        Caption = 'Usar?'
                        DataBinding.FieldName = 'activo'
                        PropertiesClassName = 'TcxCheckBoxProperties'
                        Width = 48
                      end
                    end
                    object cxGridLevel10: TcxGridLevel
                      GridView = cxGridDBTableView10
                    end
                  end
                end
                object TabSheet12: TTabSheet
                  Caption = 'Sanciones 5'
                  ImageIndex = 9
                  object Panel30: TPanel
                    Left = 0
                    Top = 0
                    Width = 736
                    Height = 28
                    Align = alTop
                    BorderStyle = bsSingle
                    Color = clWindow
                    TabOrder = 0
                    object Label31: TLabel
                      Left = 8
                      Top = 5
                      Width = 139
                      Height = 13
                      Caption = 'Desaprueba si tiene al menos'
                    end
                    object Label32: TLabel
                      Left = 416
                      Top = 5
                      Width = 63
                      Height = 13
                      Caption = 'en los '#250'ltimos'
                    end
                    object Label33: TLabel
                      Left = 525
                      Top = 5
                      Width = 30
                      Height = 13
                      Caption = 'meses'
                    end
                    object snDBEdit38: TsnDBEdit
                      Left = 150
                      Top = 1
                      DataBinding.DataField = 'cm_dias_nov_10'
                      DataBinding.DataSource = DSTRankearCab
                      TabOrder = 0
                      Width = 39
                    end
                    object snDBEdit39: TsnDBEdit
                      Left = 192
                      Top = 1
                      DataBinding.DataField = 'cm_motivos_10'
                      DataBinding.DataSource = DSTRankearCab
                      TabOrder = 1
                      Width = 219
                    end
                    object snDBEdit40: TsnDBEdit
                      Left = 482
                      Top = 1
                      DataBinding.DataField = 'cm_ult_mes_nov_10'
                      DataBinding.DataSource = DSTRankearCab
                      TabOrder = 2
                      Width = 39
                    end
                  end
                  object dxDBGridSN12: TdxDBGridSN
                    Left = 0
                    Top = 28
                    Width = 736
                    Height = 276
                    Align = alClient
                    TabOrder = 1
                    LookAndFeel.Kind = lfFlat
                    CriteriosPintarCelda = <>
                    object cxGridDBTableView11: TcxGridDBTableView
                      NavigatorButtons.ConfirmDelete = False
                      DataController.DataSource = DSTCondMinSanc10
                      DataController.Options = [dcoAssignGroupingValues, dcoAssignMasterDetailKeys, dcoSaveExpanding, dcoGroupsAlwaysExpanded]
                      DataController.Summary.DefaultGroupSummaryItems = <>
                      DataController.Summary.FooterSummaryItems = <>
                      DataController.Summary.SummaryGroups = <>
                      OptionsData.Deleting = False
                      OptionsData.DeletingConfirmation = False
                      OptionsData.Inserting = False
                      OptionsView.GroupByBox = False
                      object cxGridDBColumn28: TcxGridDBColumn
                        Caption = 'Sanci'#243'n'
                        DataBinding.FieldName = 'desc_mot_sancion'
                        Options.Editing = False
                        SortIndex = 0
                        SortOrder = soAscending
                        Width = 274
                      end
                      object cxGridDBColumn29: TcxGridDBColumn
                        Caption = 'Usar?'
                        DataBinding.FieldName = 'activo'
                        PropertiesClassName = 'TcxCheckBoxProperties'
                        Width = 48
                      end
                    end
                    object cxGridLevel11: TcxGridLevel
                      GridView = cxGridDBTableView11
                    end
                  end
                end
              end
            end
          end
        end
      end
    end
  end
  inherited DriverABM: TDriverABM
    OperTraerObjeto = 'TraerRankearCab'
    OperGrabarObjeto = 'SaveRankearCab'
    CargaDataSets = <
      item
        DataSet = TRankearCab
        TableName = 'TRankearCab'
      end
      item
        DataSet = TRankearNovedad
        TableName = 'TRankearNovedad'
      end
      item
        DataSet = TCondMinRank1
        TableName = 'TCondMinRank1'
      end
      item
        DataSet = TCondMinRank2
        TableName = 'TCondMinRank2'
      end
      item
        DataSet = TCondMinRank3
        TableName = 'TCondMinRank3'
      end
      item
        DataSet = TCondMinRank4
        TableName = 'TCondMinRank4'
      end
      item
        DataSet = TCondMinRank5
        TableName = 'TCondMinRank5'
      end
      item
        DataSet = TSancionRank
        TableName = 'TSancionRank'
      end
      item
        DataSet = TCondMinSanc6
        TableName = 'TCondMinSanc6'
      end
      item
        DataSet = TCondMinSanc7
        TableName = 'TCondMinSanc7'
      end
      item
        DataSet = TCondMinSanc8
        TableName = 'TCondMinSanc8'
      end
      item
        DataSet = TCondMinSanc9
        TableName = 'TCondMinSanc9'
      end
      item
        DataSet = TCondMinSanc10
        TableName = 'TCondMinSanc10'
      end>
    BajaLogica = <
      item
        DataSet = TRankearCab
        ValorBaja = 'false'
        ValorRehabilitacion = 'true'
        TipoBajaRegistro = tblCurrentRecord
        FieldName = 'activo'
      end>
    OperHabilitadas = [toOperNuevo, toOperModificar, toOperEliminar, toOperBuscar, toOperNavegacion, toOperRehabilitar]
    DataSetCab = TRankearCab
    DataSetDet1 = TRankearNovedad
    DataSetDet2 = TCondMinRank1
    DataSetDet3 = TCondMinRank2
    DataSetDet4 = TCondMinRank3
    DataSetDet5 = TCondMinRank4
    DataSetDet6 = TCondMinRank5
    DataSetDet7 = TSancionRank
    DataSetDet8 = TCondMinSanc6
    DataSetDet9 = TCondMinSanc7
    DataSetDetA = TCondMinSanc8
    DataSetDetB = TCondMinSanc9
    DataSetDetC = TCondMinSanc10
    ControlFocoAlta = DBEDescripcion
    ControlFocoModif = DBEDescripcion
    Left = 512
    Top = 16
  end
  inherited Operacion: TOperacion
    Left = 560
    Top = 16
  end
  object TRankearCab: TsnTable [3]
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'oid_rankear'
        DataType = ftInteger
      end
      item
        Name = 'codigo'
        DataType = ftString
        Size = 50
      end
      item
        Name = 'descripcion'
        DataType = ftString
        Size = 100
      end
      item
        Name = 'activo'
        DataType = ftBoolean
      end
      item
        Name = 'rank_por_ant_emp'
        DataType = ftBoolean
      end
      item
        Name = 'ptos_ant_emp'
        DataType = ftCurrency
      end
      item
        Name = 'ut_ant_emp'
        DataType = ftString
        Size = 1
      end
      item
        Name = 'pond_ant_emp'
        DataType = ftCurrency
      end
      item
        Name = 'rank_por_ant_pue'
        DataType = ftBoolean
      end
      item
        Name = 'ptos_ant_pue'
        DataType = ftCurrency
      end
      item
        Name = 'ut_ant_pue'
        DataType = ftString
        Size = 1
      end
      item
        Name = 'pond_ant_pue'
        DataType = ftCurrency
      end
      item
        Name = 'rank_por_novedad'
        DataType = ftBoolean
      end
      item
        Name = 'eval_ult_meses'
        DataType = ftInteger
      end
      item
        Name = 'eval_calif_punto'
        DataType = ftCurrency
      end
      item
        Name = 'eval_ponderacion'
        DataType = ftCurrency
      end
      item
        Name = 'cm_ant_req_emp'
        DataType = ftBoolean
      end
      item
        Name = 'cm_cant_req_emp'
        DataType = ftInteger
      end
      item
        Name = 'cm_ut_req_emp'
        DataType = ftString
        Size = 1
      end
      item
        Name = 'cm_ant_req_pue'
        DataType = ftBoolean
      end
      item
        Name = 'cm_cant_req_pue'
        DataType = ftInteger
      end
      item
        Name = 'cm_ut_req_pue'
        DataType = ftString
        Size = 1
      end
      item
        Name = 'cm_aplicar_eval'
        DataType = ftBoolean
      end
      item
        Name = 'cm_puntaje_eval'
        DataType = ftCurrency
      end
      item
        Name = 'cm_aplic_nov_1'
        DataType = ftBoolean
      end
      item
        Name = 'cm_dias_nov_1'
        DataType = ftInteger
      end
      item
        Name = 'cm_ult_mes_nov_1'
        DataType = ftInteger
      end
      item
        Name = 'cm_motivos_1'
        DataType = ftString
        Size = 100
      end
      item
        Name = 'cm_aplic_nov_2'
        DataType = ftBoolean
      end
      item
        Name = 'cm_dias_nov_2'
        DataType = ftInteger
      end
      item
        Name = 'cm_ult_mes_nov_2'
        DataType = ftInteger
      end
      item
        Name = 'cm_motivos_2'
        DataType = ftString
        Size = 100
      end
      item
        Name = 'cm_aplic_nov_3'
        DataType = ftBoolean
      end
      item
        Name = 'cm_dias_nov_3'
        DataType = ftInteger
      end
      item
        Name = 'cm_ult_mes_nov_3'
        DataType = ftInteger
      end
      item
        Name = 'cm_motivos_3'
        DataType = ftString
        Size = 100
      end
      item
        Name = 'cm_aplic_nov_4'
        DataType = ftBoolean
      end
      item
        Name = 'cm_dias_nov_4'
        DataType = ftInteger
      end
      item
        Name = 'cm_ult_mes_nov_4'
        DataType = ftInteger
      end
      item
        Name = 'cm_motivos_4'
        DataType = ftString
        Size = 100
      end
      item
        Name = 'cm_aplic_nov_5'
        DataType = ftBoolean
      end
      item
        Name = 'cm_dias_nov_5'
        DataType = ftInteger
      end
      item
        Name = 'cm_ult_mes_nov_5'
        DataType = ftInteger
      end
      item
        Name = 'cm_motivos_5'
        DataType = ftString
        Size = 100
      end
      item
        Name = 'rank_por_eval'
        DataType = ftBoolean
      end
      item
        Name = 'rank_por_sancion'
        DataType = ftBoolean
      end
      item
        Name = 'control_esta_desa'
        DataType = ftBoolean
      end
      item
        Name = 'cm_aplic_nov_6'
        DataType = ftBoolean
      end
      item
        Name = 'cm_dias_nov_6'
        DataType = ftInteger
      end
      item
        Name = 'cm_ult_mes_nov_6'
        DataType = ftInteger
      end
      item
        Name = 'cm_motivos_6'
        DataType = ftString
        Size = 100
      end
      item
        Name = 'cm_aplic_nov_7'
        DataType = ftBoolean
      end
      item
        Name = 'cm_dias_nov_7'
        DataType = ftInteger
      end
      item
        Name = 'cm_ult_mes_nov_7'
        DataType = ftInteger
      end
      item
        Name = 'cm_motivos_7'
        DataType = ftString
        Size = 100
      end
      item
        Name = 'cm_aplic_nov_8'
        DataType = ftBoolean
      end
      item
        Name = 'cm_dias_nov_8'
        DataType = ftInteger
      end
      item
        Name = 'cm_ult_mes_nov_8'
        DataType = ftInteger
      end
      item
        Name = 'cm_motivos_8'
        DataType = ftString
        Size = 100
      end
      item
        Name = 'cm_aplic_nov_9'
        DataType = ftBoolean
      end
      item
        Name = 'cm_dias_nov_9'
        DataType = ftInteger
      end
      item
        Name = 'cm_ult_mes_nov_9'
        DataType = ftInteger
      end
      item
        Name = 'cm_motivos_9'
        DataType = ftString
        Size = 100
      end
      item
        Name = 'cm_aplic_nov_10'
        DataType = ftBoolean
      end
      item
        Name = 'cm_dias_nov_10'
        DataType = ftInteger
      end
      item
        Name = 'cm_ult_mes_nov_10'
        DataType = ftInteger
      end
      item
        Name = 'cm_motivos_10'
        DataType = ftString
        Size = 100
      end>
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
    Top = 51
    object TRankearCaboid_rankear: TIntegerField
      FieldName = 'oid_rankear'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TRankearCabcodigo: TStringField
      DisplayWidth = 50
      FieldName = 'codigo'
      Size = 50
    end
    object TRankearCabdescripcion: TStringField
      DisplayWidth = 100
      FieldName = 'descripcion'
      Size = 100
    end
    object TRankearCabactivo: TBooleanField
      DefaultExpression = '1'
      FieldName = 'activo'
    end
    object TRankearCabrank_por_ant_emp: TBooleanField
      FieldName = 'rank_por_ant_emp'
    end
    object TRankearCabptos_ant_emp: TCurrencyField
      FieldName = 'ptos_ant_emp'
    end
    object TRankearCabut_ant_emp: TStringField
      FieldName = 'ut_ant_emp'
      Size = 1
    end
    object TRankearCabpond_ant_emp: TCurrencyField
      FieldName = 'pond_ant_emp'
    end
    object TRankearCabrank_por_ant_pue: TBooleanField
      FieldName = 'rank_por_ant_pue'
    end
    object TRankearCabptos_ant_pue: TCurrencyField
      FieldName = 'ptos_ant_pue'
    end
    object TRankearCabut_ant_pue: TStringField
      FieldName = 'ut_ant_pue'
      Size = 1
    end
    object TRankearCabpond_ant_pue: TCurrencyField
      FieldName = 'pond_ant_pue'
    end
    object TRankearCabrank_por_novedad: TBooleanField
      FieldName = 'rank_por_novedad'
    end
    object TRankearCabeval_ult_meses: TIntegerField
      FieldName = 'eval_ult_meses'
    end
    object TRankearCabeval_calif_punto: TCurrencyField
      FieldName = 'eval_calif_punto'
    end
    object TRankearCabeval_ponderacion: TCurrencyField
      FieldName = 'eval_ponderacion'
    end
    object TRankearCabcm_ant_req_emp: TBooleanField
      FieldName = 'cm_ant_req_emp'
    end
    object TRankearCabcm_cant_req_emp: TIntegerField
      FieldName = 'cm_cant_req_emp'
    end
    object TRankearCabcm_ut_req_emp: TStringField
      FieldName = 'cm_ut_req_emp'
      Size = 1
    end
    object TRankearCabcm_ant_req_pue: TBooleanField
      FieldName = 'cm_ant_req_pue'
    end
    object TRankearCabcm_cant_req_pue: TIntegerField
      FieldName = 'cm_cant_req_pue'
    end
    object TRankearCabcm_ut_req_pue: TStringField
      FieldName = 'cm_ut_req_pue'
      Size = 1
    end
    object TRankearCabcm_aplicar_eval: TBooleanField
      FieldName = 'cm_aplicar_eval'
    end
    object TRankearCabcm_puntaje_eval: TCurrencyField
      FieldName = 'cm_puntaje_eval'
    end
    object TRankearCabcm_aplic_nov_1: TBooleanField
      FieldName = 'cm_aplic_nov_1'
    end
    object TRankearCabcm_dias_nov_1: TIntegerField
      FieldName = 'cm_dias_nov_1'
    end
    object TRankearCabcm_ult_mes_nov_1: TIntegerField
      FieldName = 'cm_ult_mes_nov_1'
    end
    object TRankearCabcm_motivos_1: TStringField
      FieldName = 'cm_motivos_1'
      Size = 100
    end
    object TRankearCabcm_aplic_nov_2: TBooleanField
      FieldName = 'cm_aplic_nov_2'
    end
    object TRankearCabcm_dias_nov_2: TIntegerField
      FieldName = 'cm_dias_nov_2'
    end
    object TRankearCabcm_ult_mes_nov_2: TIntegerField
      FieldName = 'cm_ult_mes_nov_2'
    end
    object TRankearCabcm_motivos_2: TStringField
      FieldName = 'cm_motivos_2'
      Size = 100
    end
    object TRankearCabcm_aplic_nov_3: TBooleanField
      FieldName = 'cm_aplic_nov_3'
    end
    object TRankearCabcm_dias_nov_3: TIntegerField
      FieldName = 'cm_dias_nov_3'
    end
    object TRankearCabcm_ult_mes_nov_3: TIntegerField
      FieldName = 'cm_ult_mes_nov_3'
    end
    object TRankearCabcm_motivos_3: TStringField
      FieldName = 'cm_motivos_3'
      Size = 100
    end
    object TRankearCabcm_aplic_nov_4: TBooleanField
      FieldName = 'cm_aplic_nov_4'
    end
    object TRankearCabcm_dias_nov_4: TIntegerField
      FieldName = 'cm_dias_nov_4'
    end
    object TRankearCabcm_ult_mes_nov_4: TIntegerField
      FieldName = 'cm_ult_mes_nov_4'
    end
    object TRankearCabcm_motivos_4: TStringField
      FieldName = 'cm_motivos_4'
      Size = 100
    end
    object TRankearCabcm_aplic_nov_5: TBooleanField
      FieldName = 'cm_aplic_nov_5'
    end
    object TRankearCabcm_dias_nov_5: TIntegerField
      FieldName = 'cm_dias_nov_5'
    end
    object TRankearCabcm_ult_mes_nov_5: TIntegerField
      FieldName = 'cm_ult_mes_nov_5'
    end
    object TRankearCabcm_motivos_5: TStringField
      FieldName = 'cm_motivos_5'
      Size = 100
    end
    object TRankearCabrank_por_eval: TBooleanField
      FieldName = 'rank_por_eval'
    end
    object TRankearCabrank_por_sancion: TBooleanField
      FieldName = 'rank_por_sancion'
    end
    object TRankearCabcontrol_esta_desa: TBooleanField
      FieldName = 'control_esta_desa'
    end
    object TRankearCabcm_aplic_nov_6: TBooleanField
      FieldName = 'cm_aplic_nov_6'
    end
    object TRankearCabcm_dias_nov_6: TIntegerField
      FieldName = 'cm_dias_nov_6'
    end
    object TRankearCabcm_ult_mes_nov_6: TIntegerField
      FieldName = 'cm_ult_mes_nov_6'
    end
    object TRankearCabcm_motivos_6: TStringField
      FieldName = 'cm_motivos_6'
      Size = 100
    end
    object TRankearCabcm_aplic_nov_7: TBooleanField
      FieldName = 'cm_aplic_nov_7'
    end
    object TRankearCabcm_dias_nov_7: TIntegerField
      FieldName = 'cm_dias_nov_7'
    end
    object TRankearCabcm_ult_mes_nov_7: TIntegerField
      FieldName = 'cm_ult_mes_nov_7'
    end
    object TRankearCabcm_motivos_7: TStringField
      FieldName = 'cm_motivos_7'
      Size = 100
    end
    object TRankearCabcm_aplic_nov_8: TBooleanField
      FieldName = 'cm_aplic_nov_8'
    end
    object TRankearCabcm_dias_nov_8: TIntegerField
      FieldName = 'cm_dias_nov_8'
    end
    object TRankearCabcm_ult_mes_nov_8: TIntegerField
      FieldName = 'cm_ult_mes_nov_8'
    end
    object TRankearCabcm_motivos_8: TStringField
      FieldName = 'cm_motivos_8'
      Size = 100
    end
    object TRankearCabcm_aplic_nov_9: TBooleanField
      FieldName = 'cm_aplic_nov_9'
    end
    object TRankearCabcm_dias_nov_9: TIntegerField
      FieldName = 'cm_dias_nov_9'
    end
    object TRankearCabcm_ult_mes_nov_9: TIntegerField
      FieldName = 'cm_ult_mes_nov_9'
    end
    object TRankearCabcm_motivos_9: TStringField
      FieldName = 'cm_motivos_9'
      Size = 100
    end
    object TRankearCabcm_aplic_nov_10: TBooleanField
      FieldName = 'cm_aplic_nov_10'
    end
    object TRankearCabcm_dias_nov_10: TIntegerField
      FieldName = 'cm_dias_nov_10'
    end
    object TRankearCabcm_ult_mes_nov_10: TIntegerField
      FieldName = 'cm_ult_mes_nov_10'
    end
    object TRankearCabcm_motivos_10: TStringField
      FieldName = 'cm_motivos_10'
      Size = 100
    end
    object TRankearCabcm_calif_gral: TBooleanField
      FieldName = 'cm_calif_gral'
    end
    object TRankearCabcm_ptos_min_calif: TCurrencyField
      FieldName = 'cm_ptos_min_calif'
      DisplayFormat = '###,###,###.##'
    end
    object TRankearCabcm_aplic_juegos_a: TBooleanField
      FieldName = 'cm_aplic_juegos_a'
    end
    object TRankearCabcm_aplic_hor_car: TBooleanField
      FieldName = 'cm_aplic_hor_car'
    end
    object TRankearCabdes_sanc_rest_mas: TBooleanField
      FieldName = 'des_sanc_rest_mas'
    end
    object TRankearCabdes_nov_rest_mas: TBooleanField
      FieldName = 'des_nov_rest_mas'
    end
    object TRankearCabptos_max_rest_sanc: TFloatField
      FieldName = 'ptos_max_rest_sanc'
    end
    object TRankearCabptos_max_rest_nov: TFloatField
      FieldName = 'ptos_max_rest_nov'
    end
  end
  object DSTRankearCab: TDataSource [4]
    DataSet = TRankearCab
    Left = 544
    Top = 51
  end
  inherited TOidObjSave: TsnTable
    Left = 608
  end
  inherited TOpcHabPrograma: TsnTable
    Top = 16
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
  inherited SaveDialog: TSaveDialog
    Left = 376
    Top = 32
  end
  inherited DriverEvent: TDriverEvent
    OnValidate = <
      item
        TableName = 'TRankearCab'
        FieldName = 'codigo'
        Source.Strings = (
          'begin'
          '  ValidadorRankeador.Value := Sender.AsString;'
          '  ValidadorRankeador.Validar();'
          'end.')
      end>
    OnNuevoRegistro = <
      item
        TableName = 'TRankearCab'
        Source.Strings = (
          'begin'
          '  DataSet.FieldName('#39'activo'#39').AsBoolean := True;'
          '  AltaRankear();'
          'end.')
      end
      item
        TableName = 'TRankearNovedad'
        Source.Strings = (
          'begin'
          
            '  DataSet.FieldName('#39'oid_rankear'#39').AsInteger := TRankearCab.Fiel' +
            'dName('#39'oid_rankear'#39').AsInteger;'
          '  DataSet.FieldName('#39'activo'#39').AsBoolean := true;'
          'end.')
      end
      item
        TableName = 'TSancionRank'
        Source.Strings = (
          'begin'
          '  DataSet.FieldName('#39'activo'#39').AsBoolean := True;'
          
            '  DataSet.FieldName('#39'oid_rankear'#39').AsInteger := TRankearCab.Fiel' +
            'dName('#39'oid_rankear'#39').AsInteger;'
          'end.')
      end>
    OnInicializar = <
      item
        Source.Strings = (
          'begin'
          '  cargarUnidades();'
          '  SumaYResta(); '
          'end.')
      end>
    OnFormFunction = <
      item
        Source.Strings = (
          'procedure cargarUnidades();'
          'begin'
          '  TUnidadTiempo.Close;'
          '  TUnidadTiempo.Open;'
          ''
          '  TUnidadTiempo.AppendRecord;'
          '  TUnidadTiempo.FieldName('#39'codigo'#39').AsString := '#39'A'#39';'
          '  TUnidadTiempo.FieldName('#39'descripcion'#39').AsString := '#39'A'#241'o/s'#39';'
          '  TUnidadTiempo.PostRecord;'
          ''
          '  TUnidadTiempo.AppendRecord;'
          '  TUnidadTiempo.FieldName('#39'codigo'#39').AsString := '#39'M'#39';'
          '  TUnidadTiempo.FieldName('#39'descripcion'#39').AsString := '#39'Mes/es'#39';'
          '  TUnidadTiempo.PostRecord;'
          ''
          'end;'
          ''
          ''
          'procedure SumaYResta();'
          'begin'
          ''
          '  TSumaResta.Close;'
          '  TSumaResta.Open;'
          ''
          '  TSumaResta.AppendRecord;'
          '  TSumaResta.FieldName('#39'codigo'#39').AsString := '#39'S'#39';'
          '  TSumaResta.FieldName('#39'descripcion'#39').AsString := '#39'Suma'#39';'
          '  TSumaResta.PostRecord;'
          ''
          '  TSumaResta.AppendRecord;'
          '  TSumaResta.FieldName('#39'codigo'#39').AsString := '#39'R'#39';'
          '  TSumaResta.FieldName('#39'descripcion'#39').AsString := '#39'Resta'#39';'
          '  TSumaResta.PostRecord;'
          ''
          ''
          'end;'
          ''
          'procedure AltaRankear();'
          'begin'
          '  operacion.InicioOperacion();'
          '  operacion.setOper('#39'AltaRankearCab'#39');'
          
            '  operacion.AddAtribute('#39'oid_rankear'#39',TRankearCab.FieldName('#39'oid' +
            '_rankear'#39').AsString);'
          '  operacion.execute();'
          'end;')
      end>
    Left = 320
  end
  inherited SaveArchivo: TSaveDialog
    Left = 712
    Top = 72
  end
  inherited ImprimirObjetoSeleccionado: TdxComponentPrinter
    Left = 656
    Top = 136
    inherited ImprimirObjetoSeleccionadodxComponentPrinterLink: TdxGridReportLink
      BuiltInReportLink = True
    end
  end
  inherited TTempVarForm: TsnTable
    Left = 648
    Top = 56
  end
  inherited PopUp: TsnPopUp
    Left = 280
    Top = 68
  end
  inherited ImageListGruposPopUp: TImageList
    Top = 99
  end
  inherited ImageListItemsPopUp: TImageList
    Left = 248
    Top = 99
  end
  inherited TDataSetOidObjSave: TsnTable
    Left = 680
    Top = 67
  end
  object HelpRankear: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'rh.RankearCab'
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
    Titulo = 'Rankeadores'
    AnchoHelp = 600
    ActivarCache = False
    ShowBotonBuscar = False
    Left = 202
    Top = 68
  end
  object ValidadorRankeador: TValidador
    Operacion = Operacion
    NickNameObjLog = 'rh.RankearCab'
    WhenRaiseException = teFound
    MensajeException = 'C'#243'digo de Rankeador duplicado'
    NroQuery = 0
    Cache = False
    Left = 240
    Top = 67
  end
  object TUnidadTiempo: TsnTable
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
    Top = 446
    object TUnidadTiempocodigo: TStringField
      FieldName = 'codigo'
      Size = 5
    end
    object TUnidadTiempodescripcion: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
  end
  object DSUnidadTiempo: TDataSource
    DataSet = TUnidadTiempo
    Left = 209
    Top = 446
  end
  object TRankearNovedad: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'oid_rankear_nov'
        DataType = ftInteger
      end
      item
        Name = 'oid_rankear'
        DataType = ftInteger
      end
      item
        Name = 'oid_tipo_nov'
        DataType = ftInteger
      end
      item
        Name = 'activo'
        DataType = ftBoolean
      end
      item
        Name = 'oid_motivo'
        DataType = ftInteger
      end
      item
        Name = 'aplicar'
        DataType = ftBoolean
      end
      item
        Name = 'suma_o_resta'
        DataType = ftString
        Size = 20
      end
      item
        Name = 'calif_en_puntos'
        DataType = ftCurrency
      end
      item
        Name = 'analizar_ult_meses'
        DataType = ftInteger
      end
      item
        Name = 'ponderacion'
        DataType = ftCurrency
      end>
    IndexFieldNames = 'oid_rankear'
    IndexDefs = <
      item
        Name = 'TRankearNovedadIndex1'
        Fields = 'oid_rankear'
      end>
    RecalcOnFetch = False
    SortOptions = []
    PersistentBackup = False
    ProgressFlags = [mtpcLoad, mtpcSave, mtpcCopy]
    VersioningMode = mtvmAllSinceCheckPoint
    FilterOptions = []
    MasterFields = 'oid_rankear'
    MasterSource = DSTRankearCab
    Version = '4.08b'
    LanguageID = 0
    SortID = 0
    SubLanguageID = 1
    LocaleID = 1024
    MensajeValorDuplicadoIndice = 'Valor Duplicado'
    Left = 33
    Top = 85
    object TRankearNovedadoid_rankear_nov: TIntegerField
      FieldName = 'oid_rankear_nov'
    end
    object TRankearNovedadoid_rankear: TIntegerField
      FieldName = 'oid_rankear'
    end
    object TRankearNovedadoid_tipo_nov: TIntegerField
      FieldName = 'oid_tipo_nov'
    end
    object TRankearNovedadactivo: TBooleanField
      FieldName = 'activo'
    end
    object TRankearNovedadoid_motivo: TIntegerField
      FieldName = 'oid_motivo'
    end
    object TRankearNovedadaplicar: TBooleanField
      FieldName = 'aplicar'
    end
    object TRankearNovedadsuma_o_resta: TStringField
      FieldName = 'suma_o_resta'
    end
    object TRankearNovedadcalif_en_puntos: TCurrencyField
      FieldName = 'calif_en_puntos'
      DisplayFormat = '###,###,###.##'
    end
    object TRankearNovedadanalizar_ult_meses: TIntegerField
      FieldName = 'analizar_ult_meses'
    end
    object TRankearNovedadponderacion: TCurrencyField
      FieldName = 'ponderacion'
      DisplayFormat = '###,###,###.##'
    end
    object TRankearNovedaddesc_tipo_nov: TStringField
      FieldName = 'desc_tipo_nov'
      Size = 100
    end
    object TRankearNovedaddesc_motivo: TStringField
      FieldName = 'desc_motivo'
      Size = 100
    end
  end
  object DSRankearNovedad: TDataSource
    DataSet = TRankearNovedad
    Left = 64
    Top = 84
  end
  object TSumaResta: TsnTable
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
    Top = 493
    object TSumaRestacodigo: TStringField
      FieldName = 'codigo'
      Size = 5
    end
    object TSumaRestadescripcion: TStringField
      FieldName = 'descripcion'
      Size = 10
    end
  end
  object DSSumaResta: TDataSource
    DataSet = TSumaResta
    Left = 209
    Top = 493
  end
  object TCondMinRank1: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'oid_cond_min_rank'
        DataType = ftInteger
      end
      item
        Name = 'nro_novedad'
        DataType = ftInteger
      end
      item
        Name = 'oid_rankear'
        DataType = ftInteger
      end
      item
        Name = 'oid_tipo_nov'
        DataType = ftInteger
      end
      item
        Name = 'tipo_nov'
        DataType = ftString
        Size = 100
      end
      item
        Name = 'oid_motivo'
        DataType = ftInteger
      end
      item
        Name = 'motivo'
        DataType = ftString
        Size = 100
      end
      item
        Name = 'activo'
        DataType = ftBoolean
      end>
    IndexFieldNames = 'oid_rankear'
    IndexDefs = <
      item
        Name = 'TCondMinRank1Index1'
        Fields = 'oid_rankear'
      end>
    RecalcOnFetch = False
    SortOptions = []
    PersistentBackup = False
    ProgressFlags = [mtpcLoad, mtpcSave, mtpcCopy]
    VersioningMode = mtvmAllSinceCheckPoint
    FilterOptions = []
    MasterFields = 'oid_rankear'
    MasterSource = DSTRankearCab
    Version = '4.08b'
    LanguageID = 0
    SortID = 0
    SubLanguageID = 1
    LocaleID = 1024
    MensajeValorDuplicadoIndice = 'Valor Duplicado'
    Left = 344
    Top = 100
    object TCondMinRank1oid_cond_min_rank: TIntegerField
      FieldName = 'oid_cond_min_rank'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TCondMinRank1nro_novedad: TIntegerField
      FieldName = 'nro_novedad'
    end
    object TCondMinRank1oid_rankear: TIntegerField
      FieldName = 'oid_rankear'
    end
    object TCondMinRank1oid_tipo_nov: TIntegerField
      FieldName = 'oid_tipo_nov'
    end
    object TCondMinRank1tipo_nov: TStringField
      FieldName = 'tipo_nov'
      Size = 100
    end
    object TCondMinRank1oid_motivo: TIntegerField
      FieldName = 'oid_motivo'
    end
    object TCondMinRank1motivo: TStringField
      FieldName = 'motivo'
      Size = 100
    end
    object TCondMinRank1activo: TBooleanField
      FieldName = 'activo'
    end
  end
  object DSCondMinRank1: TDataSource
    DataSet = TCondMinRank1
    Left = 376
    Top = 100
  end
  object TCondMinRank2: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'oid_cond_min_rank'
        DataType = ftInteger
      end
      item
        Name = 'nro_novedad'
        DataType = ftInteger
      end
      item
        Name = 'oid_rankear'
        DataType = ftInteger
      end
      item
        Name = 'oid_tipo_nov'
        DataType = ftInteger
      end
      item
        Name = 'tipo_nov'
        DataType = ftString
        Size = 100
      end
      item
        Name = 'oid_motivo'
        DataType = ftInteger
      end
      item
        Name = 'motivo'
        DataType = ftString
        Size = 100
      end
      item
        Name = 'activo'
        DataType = ftBoolean
      end>
    IndexFieldNames = 'oid_rankear'
    IndexDefs = <
      item
        Name = 'TCondMinRank2Index1'
        Fields = 'oid_rankear'
      end>
    RecalcOnFetch = False
    SortOptions = []
    PersistentBackup = False
    ProgressFlags = [mtpcLoad, mtpcSave, mtpcCopy]
    VersioningMode = mtvmAllSinceCheckPoint
    FilterOptions = []
    MasterFields = 'oid_rankear'
    MasterSource = DSTRankearCab
    Version = '4.08b'
    LanguageID = 0
    SortID = 0
    SubLanguageID = 1
    LocaleID = 1024
    MensajeValorDuplicadoIndice = 'Valor Duplicado'
    Left = 420
    Top = 100
    object IntegerField1: TIntegerField
      FieldName = 'oid_cond_min_rank'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object IntegerField2: TIntegerField
      FieldName = 'nro_novedad'
    end
    object IntegerField3: TIntegerField
      FieldName = 'oid_rankear'
    end
    object IntegerField4: TIntegerField
      FieldName = 'oid_tipo_nov'
    end
    object StringField1: TStringField
      FieldName = 'tipo_nov'
      Size = 100
    end
    object IntegerField5: TIntegerField
      FieldName = 'oid_motivo'
    end
    object StringField2: TStringField
      FieldName = 'motivo'
      Size = 100
    end
    object BooleanField1: TBooleanField
      FieldName = 'activo'
    end
  end
  object DSCondMinRank2: TDataSource
    DataSet = TCondMinRank2
    Left = 452
    Top = 100
  end
  object TCondMinRank3: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'oid_cond_min_rank'
        DataType = ftInteger
      end
      item
        Name = 'nro_novedad'
        DataType = ftInteger
      end
      item
        Name = 'oid_rankear'
        DataType = ftInteger
      end
      item
        Name = 'oid_tipo_nov'
        DataType = ftInteger
      end
      item
        Name = 'tipo_nov'
        DataType = ftString
        Size = 100
      end
      item
        Name = 'oid_motivo'
        DataType = ftInteger
      end
      item
        Name = 'motivo'
        DataType = ftString
        Size = 100
      end
      item
        Name = 'activo'
        DataType = ftBoolean
      end>
    IndexFieldNames = 'oid_rankear'
    IndexDefs = <
      item
        Name = 'TCondMinRank3Index1'
        Fields = 'oid_rankear'
      end>
    RecalcOnFetch = False
    SortOptions = []
    PersistentBackup = False
    ProgressFlags = [mtpcLoad, mtpcSave, mtpcCopy]
    VersioningMode = mtvmAllSinceCheckPoint
    FilterOptions = []
    MasterFields = 'oid_rankear'
    MasterSource = DSTRankearCab
    Version = '4.08b'
    LanguageID = 0
    SortID = 0
    SubLanguageID = 1
    LocaleID = 1024
    MensajeValorDuplicadoIndice = 'Valor Duplicado'
    Left = 496
    Top = 100
    object IntegerField6: TIntegerField
      FieldName = 'oid_cond_min_rank'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object IntegerField7: TIntegerField
      FieldName = 'nro_novedad'
    end
    object IntegerField8: TIntegerField
      FieldName = 'oid_rankear'
    end
    object IntegerField9: TIntegerField
      FieldName = 'oid_tipo_nov'
    end
    object StringField3: TStringField
      FieldName = 'tipo_nov'
      Size = 100
    end
    object IntegerField10: TIntegerField
      FieldName = 'oid_motivo'
    end
    object StringField4: TStringField
      FieldName = 'motivo'
      Size = 100
    end
    object BooleanField2: TBooleanField
      FieldName = 'activo'
    end
  end
  object DSCondMinRank3: TDataSource
    DataSet = TCondMinRank3
    Left = 528
    Top = 100
  end
  object TCondMinRank4: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'oid_cond_min_rank'
        DataType = ftInteger
      end
      item
        Name = 'nro_novedad'
        DataType = ftInteger
      end
      item
        Name = 'oid_rankear'
        DataType = ftInteger
      end
      item
        Name = 'oid_tipo_nov'
        DataType = ftInteger
      end
      item
        Name = 'tipo_nov'
        DataType = ftString
        Size = 100
      end
      item
        Name = 'oid_motivo'
        DataType = ftInteger
      end
      item
        Name = 'motivo'
        DataType = ftString
        Size = 100
      end
      item
        Name = 'activo'
        DataType = ftBoolean
      end>
    IndexFieldNames = 'oid_rankear'
    IndexDefs = <
      item
        Name = 'TCondMinRank4Index1'
        Fields = 'oid_rankear'
      end>
    RecalcOnFetch = False
    SortOptions = []
    PersistentBackup = False
    ProgressFlags = [mtpcLoad, mtpcSave, mtpcCopy]
    VersioningMode = mtvmAllSinceCheckPoint
    FilterOptions = []
    MasterFields = 'oid_rankear'
    MasterSource = DSTRankearCab
    Version = '4.08b'
    LanguageID = 0
    SortID = 0
    SubLanguageID = 1
    LocaleID = 1024
    MensajeValorDuplicadoIndice = 'Valor Duplicado'
    Left = 566
    Top = 100
    object IntegerField11: TIntegerField
      FieldName = 'oid_cond_min_rank'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object IntegerField12: TIntegerField
      FieldName = 'nro_novedad'
    end
    object IntegerField13: TIntegerField
      FieldName = 'oid_rankear'
    end
    object IntegerField14: TIntegerField
      FieldName = 'oid_tipo_nov'
    end
    object StringField5: TStringField
      FieldName = 'tipo_nov'
      Size = 100
    end
    object IntegerField15: TIntegerField
      FieldName = 'oid_motivo'
    end
    object StringField6: TStringField
      FieldName = 'motivo'
      Size = 100
    end
    object BooleanField3: TBooleanField
      FieldName = 'activo'
    end
  end
  object DSCondMinRank4: TDataSource
    DataSet = TCondMinRank4
    Left = 598
    Top = 100
  end
  object TCondMinRank5: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'oid_cond_min_rank'
        DataType = ftInteger
      end
      item
        Name = 'nro_novedad'
        DataType = ftInteger
      end
      item
        Name = 'oid_rankear'
        DataType = ftInteger
      end
      item
        Name = 'oid_tipo_nov'
        DataType = ftInteger
      end
      item
        Name = 'tipo_nov'
        DataType = ftString
        Size = 100
      end
      item
        Name = 'oid_motivo'
        DataType = ftInteger
      end
      item
        Name = 'motivo'
        DataType = ftString
        Size = 100
      end
      item
        Name = 'activo'
        DataType = ftBoolean
      end>
    IndexFieldNames = 'oid_rankear'
    IndexDefs = <
      item
        Name = 'TCondMinRank5Index1'
        Fields = 'oid_rankear'
      end>
    RecalcOnFetch = False
    SortOptions = []
    PersistentBackup = False
    ProgressFlags = [mtpcLoad, mtpcSave, mtpcCopy]
    VersioningMode = mtvmAllSinceCheckPoint
    FilterOptions = []
    MasterFields = 'oid_rankear'
    MasterSource = DSTRankearCab
    Version = '4.08b'
    LanguageID = 0
    SortID = 0
    SubLanguageID = 1
    LocaleID = 1024
    MensajeValorDuplicadoIndice = 'Valor Duplicado'
    Left = 639
    Top = 100
    object IntegerField16: TIntegerField
      FieldName = 'oid_cond_min_rank'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object IntegerField17: TIntegerField
      FieldName = 'nro_novedad'
    end
    object IntegerField18: TIntegerField
      FieldName = 'oid_rankear'
    end
    object IntegerField19: TIntegerField
      FieldName = 'oid_tipo_nov'
    end
    object StringField7: TStringField
      FieldName = 'tipo_nov'
      Size = 100
    end
    object IntegerField20: TIntegerField
      FieldName = 'oid_motivo'
    end
    object StringField8: TStringField
      FieldName = 'motivo'
      Size = 100
    end
    object BooleanField4: TBooleanField
      FieldName = 'activo'
    end
  end
  object DSCondMinRank5: TDataSource
    DataSet = TCondMinRank5
    Left = 671
    Top = 100
  end
  object TSancionRank: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'oid_sancion_rank'
        DataType = ftInteger
      end
      item
        Name = 'oid_mot_sancion'
        DataType = ftInteger
      end
      item
        Name = 'activo'
        DataType = ftBoolean
      end
      item
        Name = 'aplicar'
        DataType = ftBoolean
      end
      item
        Name = 'suma_o_resta'
        DataType = ftString
        Size = 20
      end
      item
        Name = 'calif_en_puntos'
        DataType = ftCurrency
      end
      item
        Name = 'oid_rankear'
        DataType = ftInteger
      end
      item
        Name = 'analizar_ult_meses'
        DataType = ftInteger
      end
      item
        Name = 'ponderacion'
        DataType = ftCurrency
      end>
    IndexFieldNames = 'oid_rankear'
    IndexDefs = <
      item
        Name = 'TSancionRankIndex1'
        Fields = 'oid_rankear'
      end>
    RecalcOnFetch = False
    SortOptions = []
    PersistentBackup = False
    ProgressFlags = [mtpcLoad, mtpcSave, mtpcCopy]
    VersioningMode = mtvmAllSinceCheckPoint
    FilterOptions = []
    MasterFields = 'oid_rankear'
    MasterSource = DSTRankearCab
    Version = '4.08b'
    LanguageID = 0
    SortID = 0
    SubLanguageID = 1
    LocaleID = 1024
    MensajeValorDuplicadoIndice = 'Valor Duplicado'
    Left = 41
    Top = 477
    object TSancionRankoid_sancion_rank: TIntegerField
      FieldName = 'oid_sancion_rank'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TSancionRankoid_mot_sancion: TIntegerField
      FieldName = 'oid_mot_sancion'
    end
    object TSancionRankdesc_mot_sancion: TStringField
      FieldName = 'desc_mot_sancion'
      Size = 100
    end
    object TSancionRankaplicar: TBooleanField
      FieldName = 'aplicar'
    end
    object TSancionRanksuma_o_resta: TStringField
      FieldName = 'suma_o_resta'
    end
    object TSancionRankcalif_en_puntos: TCurrencyField
      FieldName = 'calif_en_puntos'
      DisplayFormat = '###,###,###,###.##'
    end
    object TSancionRankoid_rankear: TIntegerField
      FieldName = 'oid_rankear'
    end
    object TSancionRankanalizar_ult_meses: TIntegerField
      FieldName = 'analizar_ult_meses'
    end
    object TSancionRankponderacion: TCurrencyField
      FieldName = 'ponderacion'
      DisplayFormat = '###,###,###.##'
    end
    object TSancionRankactivo: TBooleanField
      FieldName = 'activo'
    end
  end
  object dsTSancionRank: TDataSource
    DataSet = TSancionRank
    Left = 73
    Top = 477
  end
  object TCondMinSanc6: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'oid_cond_min_sanc'
        DataType = ftInteger
      end
      item
        Name = 'nro_novedad'
        DataType = ftInteger
      end
      item
        Name = 'oid_rankear'
        DataType = ftInteger
      end
      item
        Name = 'oid_mot_sancion'
        DataType = ftInteger
      end
      item
        Name = 'desc_mot_sancion'
        DataType = ftString
        Size = 100
      end
      item
        Name = 'activo'
        DataType = ftBoolean
      end>
    IndexFieldNames = 'oid_rankear'
    IndexDefs = <
      item
        Name = 'TCondMinSanc6Index1'
        Fields = 'oid_rankear'
      end>
    RecalcOnFetch = False
    SortOptions = []
    PersistentBackup = False
    ProgressFlags = [mtpcLoad, mtpcSave, mtpcCopy]
    VersioningMode = mtvmAllSinceCheckPoint
    FilterOptions = []
    MasterFields = 'oid_rankear'
    MasterSource = DSTRankearCab
    Version = '4.08b'
    LanguageID = 0
    SortID = 0
    SubLanguageID = 1
    LocaleID = 1024
    MensajeValorDuplicadoIndice = 'Valor Duplicado'
    Left = 337
    Top = 269
    object TCondMinSanc6oid_cond_min_sanc: TIntegerField
      FieldName = 'oid_cond_min_sanc'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TCondMinSanc6nro_novedad: TIntegerField
      FieldName = 'nro_novedad'
    end
    object TCondMinSanc6oid_rankear: TIntegerField
      FieldName = 'oid_rankear'
    end
    object TCondMinSanc6oid_mot_sancion: TIntegerField
      FieldName = 'oid_mot_sancion'
    end
    object TCondMinSanc6desc_mot_sancion: TStringField
      FieldName = 'desc_mot_sancion'
      Size = 100
    end
    object TCondMinSanc6activo: TBooleanField
      FieldName = 'activo'
    end
  end
  object DSCondMinSanc6: TDataSource
    DataSet = TCondMinSanc6
    Left = 369
    Top = 269
  end
  object TCondMinSanc7: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'oid_cond_min_sanc'
        DataType = ftInteger
      end
      item
        Name = 'nro_novedad'
        DataType = ftInteger
      end
      item
        Name = 'oid_rankear'
        DataType = ftInteger
      end
      item
        Name = 'oid_mot_sancion'
        DataType = ftInteger
      end
      item
        Name = 'desc_mot_sancion'
        DataType = ftString
        Size = 100
      end
      item
        Name = 'activo'
        DataType = ftBoolean
      end>
    IndexFieldNames = 'oid_rankear'
    IndexDefs = <
      item
        Name = 'TCondMinSanc6Index1'
        Fields = 'oid_rankear'
      end>
    RecalcOnFetch = False
    SortOptions = []
    PersistentBackup = False
    ProgressFlags = [mtpcLoad, mtpcSave, mtpcCopy]
    VersioningMode = mtvmAllSinceCheckPoint
    FilterOptions = []
    MasterFields = 'oid_rankear'
    MasterSource = DSTRankearCab
    Version = '4.08b'
    LanguageID = 0
    SortID = 0
    SubLanguageID = 1
    LocaleID = 1024
    MensajeValorDuplicadoIndice = 'Valor Duplicado'
    Left = 406
    Top = 269
    object IntegerField21: TIntegerField
      FieldName = 'oid_cond_min_sanc'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object IntegerField22: TIntegerField
      FieldName = 'nro_novedad'
    end
    object IntegerField23: TIntegerField
      FieldName = 'oid_rankear'
    end
    object IntegerField24: TIntegerField
      FieldName = 'oid_mot_sancion'
    end
    object StringField9: TStringField
      FieldName = 'desc_mot_sancion'
      Size = 100
    end
    object BooleanField5: TBooleanField
      FieldName = 'activo'
    end
  end
  object DSTCondMinSanc7: TDataSource
    DataSet = TCondMinSanc7
    Left = 438
    Top = 269
  end
  object TCondMinSanc8: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'oid_cond_min_sanc'
        DataType = ftInteger
      end
      item
        Name = 'nro_novedad'
        DataType = ftInteger
      end
      item
        Name = 'oid_rankear'
        DataType = ftInteger
      end
      item
        Name = 'oid_mot_sancion'
        DataType = ftInteger
      end
      item
        Name = 'desc_mot_sancion'
        DataType = ftString
        Size = 100
      end
      item
        Name = 'activo'
        DataType = ftBoolean
      end>
    IndexFieldNames = 'oid_rankear'
    IndexDefs = <
      item
        Name = 'TCondMinSanc6Index1'
        Fields = 'oid_rankear'
      end>
    RecalcOnFetch = False
    SortOptions = []
    PersistentBackup = False
    ProgressFlags = [mtpcLoad, mtpcSave, mtpcCopy]
    VersioningMode = mtvmAllSinceCheckPoint
    FilterOptions = []
    MasterFields = 'oid_rankear'
    MasterSource = DSTRankearCab
    Version = '4.08b'
    LanguageID = 0
    SortID = 0
    SubLanguageID = 1
    LocaleID = 1024
    MensajeValorDuplicadoIndice = 'Valor Duplicado'
    Left = 473
    Top = 269
    object IntegerField25: TIntegerField
      FieldName = 'oid_cond_min_sanc'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object IntegerField26: TIntegerField
      FieldName = 'nro_novedad'
    end
    object IntegerField27: TIntegerField
      FieldName = 'oid_rankear'
    end
    object IntegerField28: TIntegerField
      FieldName = 'oid_mot_sancion'
    end
    object StringField10: TStringField
      FieldName = 'desc_mot_sancion'
      Size = 100
    end
    object BooleanField6: TBooleanField
      FieldName = 'activo'
    end
  end
  object DSTCondMinSanc8: TDataSource
    DataSet = TCondMinSanc8
    Left = 505
    Top = 269
  end
  object TCondMinSanc9: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'oid_cond_min_sanc'
        DataType = ftInteger
      end
      item
        Name = 'nro_novedad'
        DataType = ftInteger
      end
      item
        Name = 'oid_rankear'
        DataType = ftInteger
      end
      item
        Name = 'oid_mot_sancion'
        DataType = ftInteger
      end
      item
        Name = 'desc_mot_sancion'
        DataType = ftString
        Size = 100
      end
      item
        Name = 'activo'
        DataType = ftBoolean
      end>
    IndexFieldNames = 'oid_rankear'
    IndexDefs = <
      item
        Name = 'TCondMinSanc6Index1'
        Fields = 'oid_rankear'
      end>
    RecalcOnFetch = False
    SortOptions = []
    PersistentBackup = False
    ProgressFlags = [mtpcLoad, mtpcSave, mtpcCopy]
    VersioningMode = mtvmAllSinceCheckPoint
    FilterOptions = []
    MasterFields = 'oid_rankear'
    MasterSource = DSTRankearCab
    Version = '4.08b'
    LanguageID = 0
    SortID = 0
    SubLanguageID = 1
    LocaleID = 1024
    MensajeValorDuplicadoIndice = 'Valor Duplicado'
    Left = 538
    Top = 269
    object IntegerField29: TIntegerField
      FieldName = 'oid_cond_min_sanc'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object IntegerField30: TIntegerField
      FieldName = 'nro_novedad'
    end
    object IntegerField31: TIntegerField
      FieldName = 'oid_rankear'
    end
    object IntegerField32: TIntegerField
      FieldName = 'oid_mot_sancion'
    end
    object StringField11: TStringField
      FieldName = 'desc_mot_sancion'
      Size = 100
    end
    object BooleanField7: TBooleanField
      FieldName = 'activo'
    end
  end
  object DSTCondMinSanc9: TDataSource
    DataSet = TCondMinSanc9
    Left = 570
    Top = 269
  end
  object TCondMinSanc10: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'oid_cond_min_sanc'
        DataType = ftInteger
      end
      item
        Name = 'nro_novedad'
        DataType = ftInteger
      end
      item
        Name = 'oid_rankear'
        DataType = ftInteger
      end
      item
        Name = 'oid_mot_sancion'
        DataType = ftInteger
      end
      item
        Name = 'desc_mot_sancion'
        DataType = ftString
        Size = 100
      end
      item
        Name = 'activo'
        DataType = ftBoolean
      end>
    IndexFieldNames = 'oid_rankear'
    IndexDefs = <
      item
        Name = 'TCondMinSanc6Index1'
        Fields = 'oid_rankear'
      end>
    RecalcOnFetch = False
    SortOptions = []
    PersistentBackup = False
    ProgressFlags = [mtpcLoad, mtpcSave, mtpcCopy]
    VersioningMode = mtvmAllSinceCheckPoint
    FilterOptions = []
    MasterFields = 'oid_rankear'
    MasterSource = DSTRankearCab
    Version = '4.08b'
    LanguageID = 0
    SortID = 0
    SubLanguageID = 1
    LocaleID = 1024
    MensajeValorDuplicadoIndice = 'Valor Duplicado'
    Left = 606
    Top = 269
    object IntegerField33: TIntegerField
      FieldName = 'oid_cond_min_sanc'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object IntegerField34: TIntegerField
      FieldName = 'nro_novedad'
    end
    object IntegerField35: TIntegerField
      FieldName = 'oid_rankear'
    end
    object IntegerField36: TIntegerField
      FieldName = 'oid_mot_sancion'
    end
    object StringField12: TStringField
      FieldName = 'desc_mot_sancion'
      Size = 100
    end
    object BooleanField8: TBooleanField
      FieldName = 'activo'
    end
  end
  object DSTCondMinSanc10: TDataSource
    DataSet = TCondMinSanc10
    Left = 638
    Top = 269
  end
end
