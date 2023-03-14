inherited FDefEvalCompe: TFDefEvalCompe
  Left = 57
  Top = 157
  Width = 936
  Height = 780
  Caption = 'Definici'#243'n de Evaluaciones'
  PixelsPerInch = 96
  TextHeight = 13
  inherited PForm: TPanel
    Width = 920
    Height = 742
    inherited PPie: TPanel
      Top = 721
      Width = 920
      inherited StatusBarABM: TStatusBar
        Left = 815
      end
      inherited StatusBar2: TStatusBar
        Width = 815
      end
    end
    inherited PMenu: TPanel
      Width = 920
      inherited ImagenEliminar: TImagenEstado
        DataField = 'activo'
        DataSource = DSTModeloEvalCab
        ValorEstadoVisible = 'True'
      end
      inherited ImagenRehabilitar: TImagenEstado
        DataField = 'activo'
        DataSource = DSTModeloEvalCab
        ValorEstadoVisible = 'False'
      end
      inherited ImagenBuscar: TImagenHelpObjNeg
        Help = HelpDefiniciones
      end
      inherited ImagenSiguiente: TImagenHelpObjNeg
        Help = HelpDefiniciones
      end
      inherited ImagenAnterior: TImagenHelpObjNeg
        Help = HelpDefiniciones
      end
      inherited Panel2: TPanel
        Left = 879
      end
      inherited PanelEstadoON: TPanelEstado
        DataField = 'activo'
        DataSource = DSTModeloEvalCab
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
      Width = 920
    end
    inherited PCabecera: TPanel
      Width = 920
      Height = 108
      object Label1: TLabel
        Left = 44
        Top = 16
        Width = 28
        Height = 13
        Caption = 'T'#237'tulo'
      end
      object Label2: TLabel
        Left = 44
        Top = 40
        Width = 107
        Height = 13
        Caption = 'Descripci'#243'n Abreviada'
      end
      object Label3: TLabel
        Left = 44
        Top = 64
        Width = 64
        Height = 13
        Caption = 'Fecha Desde'
      end
      object Label4: TLabel
        Left = 284
        Top = 62
        Width = 61
        Height = 13
        Caption = 'Fecha Hasta'
      end
      object Label15: TLabel
        Left = 44
        Top = 88
        Width = 78
        Height = 13
        Caption = 'Armar en Base a'
      end
      object Label16: TLabel
        Left = 484
        Top = 40
        Width = 80
        Height = 13
        Caption = 'Tipo Evaluaci'#243'n:'
      end
      object DBECodigo: TsnDBEdit
        Left = 160
        Top = 12
        DataBinding.DataField = 'titulo'
        DataBinding.DataSource = DSTModeloEvalCab
        Properties.CharCase = ecUpperCase
        Properties.MaxLength = 100
        Style.BorderColor = clWindowFrame
        Style.Shadow = False
        TabOrder = 0
        Width = 429
      end
      object snDBEdit1: TsnDBEdit
        Left = 160
        Top = 36
        DataBinding.DataField = 'desc_abreviada'
        DataBinding.DataSource = DSTModeloEvalCab
        Properties.MaxLength = 50
        Style.BorderColor = clWindowFrame
        Style.Shadow = False
        TabOrder = 1
        Width = 313
      end
      object snDBDateEdit1: TsnDBDateEdit
        Left = 160
        Top = 60
        DataBinding.DataField = 'fec_desde'
        DataBinding.DataSource = DSTModeloEvalCab
        TabOrder = 3
        ReadOnlyAlways = False
        Width = 101
      end
      object snDBDateEdit2: TsnDBDateEdit
        Left = 360
        Top = 58
        DataBinding.DataField = 'fec_hasta'
        DataBinding.DataSource = DSTModeloEvalCab
        TabOrder = 4
        ReadOnlyAlways = False
        Width = 101
      end
      object snDBCheckEdit1: TsnDBCheckEdit
        Left = 490
        Top = 58
        Caption = 'Vigente'
        DataBinding.DataField = 'vigente'
        DataBinding.DataSource = DSTModeloEvalCab
        TabOrder = 5
        Width = 62
      end
      object srnDBButtonEdit1: TsrnDBButtonEdit
        Left = 160
        Top = 84
        DataBinding.DataField = 'cod_armar_en_base_a'
        DataBinding.DataSource = DSTModeloEvalCab
        Properties.Buttons = <
          item
            Default = True
            Kind = bkEllipsis
          end>
        Properties.ClickKey = 112
        TabOrder = 6
        Help = HelpModEval
        Width = 121
      end
      object snDBEdit7: TsnDBEdit
        Left = 278
        Top = 84
        TabStop = False
        DataBinding.DataField = 'desc_armar_en_base_a'
        DataBinding.DataSource = DSTModeloEvalCab
        Properties.ReadOnly = True
        TabOrder = 7
        Width = 311
      end
      object BotonRecalcularEvaluaciones: TsnButton
        Left = 664
        Top = 1
        Width = 185
        Height = 33
        Cursor = crHandPoint
        Caption = 'Recalcular punatje evaluaciones'
        TabOrder = 8
        LookAndFeel.Kind = lfOffice11
      end
      object snDBLookup1: TsnDBLookup
        Left = 577
        Top = 36
        DataBinding.DataField = 'tipo'
        DataBinding.DataSource = DSTModeloEvalCab
        Properties.KeyFieldNames = 'codigo'
        Properties.ListColumns = <
          item
            FieldName = 'descripcion'
          end>
        Properties.ListOptions.ShowHeader = False
        Properties.ListSource = DSTipoModelosEval
        TabOrder = 2
        Width = 146
      end
    end
    inherited PCuerpo: TPanel
      Top = 160
      Width = 920
      Height = 561
      object Panel1: TPanel
        Left = 0
        Top = 0
        Width = 920
        Height = 147
        Align = alTop
        BevelOuter = bvNone
        BorderWidth = 5
        Color = clWindow
        TabOrder = 0
        object Panel4: TPanel
          Left = 5
          Top = 5
          Width = 910
          Height = 27
          Align = alTop
          BevelOuter = bvNone
          Color = clWindow
          TabOrder = 0
          object Label5: TLabel
            Left = 39
            Top = 2
            Width = 430
            Height = 16
            Caption = 'Aplicar evaluaciones seg'#250'n las siguientes condiciones de Legajos'
            Font.Charset = ANSI_CHARSET
            Font.Color = clNavy
            Font.Height = -13
            Font.Name = 'Verdana'
            Font.Style = []
            ParentFont = False
          end
          object DBNavigator2: TDBNavigator
            Left = 496
            Top = 0
            Width = 82
            Height = 23
            DataSource = DSTCondModEvalCab
            VisibleButtons = [nbPrior, nbNext]
            TabOrder = 0
          end
        end
        object Panel5: TPanel
          Left = 5
          Top = 32
          Width = 910
          Height = 110
          Align = alClient
          BevelOuter = bvNone
          Color = clWindow
          TabOrder = 1
          object dxDBGridSN1: TdxDBGridSN
            Left = 39
            Top = 0
            Width = 871
            Height = 110
            Align = alClient
            TabOrder = 0
            LookAndFeel.Kind = lfFlat
            CriteriosPintarCelda = <>
            object dxDBGridSN1DBTableView1: TcxGridDBTableView
              NavigatorButtons.ConfirmDelete = False
              NavigatorButtons.First.Visible = False
              NavigatorButtons.PriorPage.Enabled = False
              NavigatorButtons.PriorPage.Visible = False
              NavigatorButtons.Prior.Enabled = False
              NavigatorButtons.Prior.Visible = False
              NavigatorButtons.Next.Visible = False
              NavigatorButtons.NextPage.Enabled = False
              NavigatorButtons.NextPage.Visible = False
              NavigatorButtons.Last.Visible = False
              NavigatorButtons.Insert.Hint = 'Agregar condici'#243'n'
              NavigatorButtons.Insert.Visible = True
              NavigatorButtons.Append.Enabled = False
              NavigatorButtons.Append.Visible = False
              NavigatorButtons.Delete.Enabled = False
              NavigatorButtons.Delete.Visible = False
              NavigatorButtons.Edit.Enabled = False
              NavigatorButtons.Edit.Visible = False
              NavigatorButtons.Post.Enabled = False
              NavigatorButtons.Post.Visible = False
              NavigatorButtons.Cancel.Enabled = False
              NavigatorButtons.Cancel.Visible = False
              NavigatorButtons.Refresh.Enabled = False
              NavigatorButtons.Refresh.Visible = False
              NavigatorButtons.SaveBookmark.Enabled = False
              NavigatorButtons.SaveBookmark.Visible = False
              NavigatorButtons.GotoBookmark.Enabled = False
              NavigatorButtons.GotoBookmark.Visible = False
              NavigatorButtons.Filter.Enabled = False
              NavigatorButtons.Filter.Visible = False
              DataController.DataSource = DSTCondModEvalCab
              DataController.Summary.DefaultGroupSummaryItems = <>
              DataController.Summary.FooterSummaryItems = <>
              DataController.Summary.SummaryGroups = <>
              OptionsBehavior.FocusCellOnTab = True
              OptionsBehavior.FocusFirstCellOnNewRecord = True
              OptionsBehavior.GoToNextCellOnEnter = True
              OptionsBehavior.FocusCellOnCycle = True
              OptionsData.Appending = True
              OptionsData.Deleting = False
              OptionsData.DeletingConfirmation = False
              OptionsSelection.HideFocusRectOnExit = False
              OptionsSelection.InvertSelect = False
              OptionsView.Navigator = True
              OptionsView.CellAutoHeight = True
              OptionsView.GroupByBox = False
              object dxDBGridSN1DBTableView1orden: TcxGridDBColumn
                Caption = 'Orden'
                DataBinding.FieldName = 'orden'
                HeaderAlignmentHorz = taCenter
                SortIndex = 0
                SortOrder = soAscending
                Width = 59
              end
              object dxDBGridSN1DBTableView1condicion: TcxGridDBColumn
                Caption = 'Condici'#243'n que debe cumplir para aplicar el modelo de evaluaci'#243'n'
                DataBinding.FieldName = 'condicion'
                HeaderAlignmentHorz = taCenter
                Width = 519
              end
              object dxDBGridSN1DBTableView1activo: TcxGridDBColumn
                Caption = 'Activo'
                DataBinding.FieldName = 'activo'
                PropertiesClassName = 'TcxCheckBoxProperties'
                HeaderAlignmentHorz = taCenter
                Width = 42
              end
            end
            object dxDBGridSN1Level1: TcxGridLevel
              GridView = dxDBGridSN1DBTableView1
            end
          end
          object Panel6: TPanel
            Left = 0
            Top = 0
            Width = 39
            Height = 110
            Align = alLeft
            BevelOuter = bvNone
            Color = clWindow
            TabOrder = 1
          end
        end
      end
      object Panel3: TPanel
        Left = 0
        Top = 147
        Width = 920
        Height = 414
        Align = alClient
        Color = clWindow
        TabOrder = 1
        object Panel7: TPanel
          Left = 1
          Top = 1
          Width = 43
          Height = 412
          Align = alLeft
          BevelOuter = bvNone
          Color = clWindow
          TabOrder = 0
        end
        object PageControlSN1: TPageControlSN
          Left = 44
          Top = 1
          Width = 875
          Height = 412
          ActivePage = TabSheet4
          Align = alClient
          Font.Charset = DEFAULT_CHARSET
          Font.Color = clBlue
          Font.Height = -13
          Font.Name = 'MS Sans Serif'
          Font.Style = []
          ParentFont = False
          TabOrder = 1
          object TabSheet4: TTabSheet
            Caption = 'Detalle de Condiciones'
            ImageIndex = 3
            object Panel13: TPanel
              Left = 0
              Top = 0
              Width = 867
              Height = 26
              Align = alTop
              Color = clWindow
              TabOrder = 0
              object Label8: TLabel
                Left = 7
                Top = 3
                Width = 387
                Height = 16
                Caption = 'Condiciones a cumplir para aplicar el Modelo de Evaluaci'#243'n'
                Font.Charset = ANSI_CHARSET
                Font.Color = clNavy
                Font.Height = -13
                Font.Name = 'Verdana'
                Font.Style = []
                ParentFont = False
              end
            end
            object Panel14: TPanel
              Left = 0
              Top = 26
              Width = 867
              Height = 355
              Align = alClient
              Color = clWindow
              TabOrder = 1
              object Splitter2: TSplitter
                Left = 289
                Top = 1
                Height = 353
              end
              object Panel15: TPanel
                Left = 1
                Top = 1
                Width = 288
                Height = 353
                Align = alLeft
                Color = clWindow
                TabOrder = 0
                object Panel17: TPanel
                  Left = 1
                  Top = 1
                  Width = 286
                  Height = 29
                  Align = alTop
                  Color = clWindow
                  TabOrder = 0
                  object Label9: TLabel
                    Left = 8
                    Top = 5
                    Width = 213
                    Height = 16
                    Caption = 'Seg'#250'n clasificaciones del Legajo'
                    Font.Charset = ANSI_CHARSET
                    Font.Color = clNavy
                    Font.Height = -13
                    Font.Name = 'Verdana'
                    Font.Style = []
                    ParentFont = False
                  end
                end
                object Panel19: TPanel
                  Left = 1
                  Top = 30
                  Width = 286
                  Height = 322
                  Align = alClient
                  Color = clWindow
                  TabOrder = 1
                  object dxDBGridSN4: TdxDBGridSN
                    Left = 1
                    Top = 1
                    Width = 284
                    Height = 320
                    Align = alClient
                    TabOrder = 0
                    LookAndFeel.Kind = lfFlat
                    CriteriosPintarCelda = <>
                    object cxGridDBTableView1: TcxGridDBTableView
                      NavigatorButtons.ConfirmDelete = False
                      NavigatorButtons.First.Enabled = False
                      NavigatorButtons.First.Visible = False
                      NavigatorButtons.PriorPage.Enabled = False
                      NavigatorButtons.PriorPage.Visible = False
                      NavigatorButtons.Prior.Enabled = False
                      NavigatorButtons.Prior.Visible = False
                      NavigatorButtons.Next.Enabled = False
                      NavigatorButtons.Next.Visible = False
                      NavigatorButtons.NextPage.Enabled = False
                      NavigatorButtons.NextPage.Visible = False
                      NavigatorButtons.Last.Enabled = False
                      NavigatorButtons.Last.Visible = False
                      NavigatorButtons.Insert.Enabled = False
                      NavigatorButtons.Insert.Visible = False
                      NavigatorButtons.Append.Visible = True
                      NavigatorButtons.Delete.Enabled = False
                      NavigatorButtons.Delete.Visible = False
                      NavigatorButtons.Edit.Enabled = False
                      NavigatorButtons.Edit.Visible = False
                      NavigatorButtons.Post.Enabled = False
                      NavigatorButtons.Post.Visible = False
                      NavigatorButtons.Cancel.Enabled = False
                      NavigatorButtons.Cancel.Visible = False
                      NavigatorButtons.Refresh.Enabled = False
                      NavigatorButtons.Refresh.Visible = False
                      NavigatorButtons.SaveBookmark.Enabled = False
                      NavigatorButtons.SaveBookmark.Visible = False
                      NavigatorButtons.GotoBookmark.Enabled = False
                      NavigatorButtons.GotoBookmark.Visible = False
                      NavigatorButtons.Filter.Enabled = False
                      NavigatorButtons.Filter.Visible = False
                      DataController.DataSource = DSClasifCond
                      DataController.Summary.DefaultGroupSummaryItems = <>
                      DataController.Summary.FooterSummaryItems = <>
                      DataController.Summary.SummaryGroups = <>
                      OptionsBehavior.FocusCellOnTab = True
                      OptionsBehavior.FocusFirstCellOnNewRecord = True
                      OptionsBehavior.GoToNextCellOnEnter = True
                      OptionsBehavior.FocusCellOnCycle = True
                      OptionsData.CancelOnExit = False
                      OptionsData.Deleting = False
                      OptionsData.DeletingConfirmation = False
                      OptionsData.Editing = False
                      OptionsData.Inserting = False
                      OptionsSelection.HideFocusRectOnExit = False
                      OptionsSelection.InvertSelect = False
                      OptionsView.Navigator = True
                      OptionsView.CellAutoHeight = True
                      OptionsView.GroupByBox = False
                      OptionsView.Header = False
                      object cxGridDBTableView1desc_clasificador: TcxGridDBColumn
                        Caption = 'Clasificadores'
                        DataBinding.FieldName = 'desc_clasificador'
                        HeaderAlignmentHorz = taCenter
                        Width = 271
                      end
                    end
                    object cxGridLevel1: TcxGridLevel
                      GridView = cxGridDBTableView1
                    end
                  end
                end
              end
              object Panel16: TPanel
                Left = 292
                Top = 1
                Width = 574
                Height = 353
                Align = alClient
                Color = clWindow
                TabOrder = 1
                object Panel18: TPanel
                  Left = 1
                  Top = 1
                  Width = 572
                  Height = 29
                  Align = alTop
                  Color = clWindow
                  TabOrder = 0
                  object Label10: TLabel
                    Left = 8
                    Top = 6
                    Width = 81
                    Height = 16
                    Caption = 'Clasificador:'
                    Font.Charset = ANSI_CHARSET
                    Font.Color = clNavy
                    Font.Height = -13
                    Font.Name = 'Verdana'
                    Font.Style = []
                    ParentFont = False
                  end
                  object snDBEdit4: TsnDBEdit
                    Left = 89
                    Top = 3
                    TabStop = False
                    DataBinding.DataField = 'desc_clasificador'
                    DataBinding.DataSource = DSClasifCond
                    ParentFont = False
                    Properties.ReadOnly = True
                    Style.Edges = []
                    Style.Font.Charset = ANSI_CHARSET
                    Style.Font.Color = clBlue
                    Style.Font.Height = -13
                    Style.Font.Name = 'Verdana'
                    Style.Font.Style = []
                    Style.IsFontAssigned = True
                    TabOrder = 0
                    Width = 371
                  end
                end
                object Panel20: TPanel
                  Left = 1
                  Top = 30
                  Width = 572
                  Height = 322
                  Align = alClient
                  Color = clWindow
                  TabOrder = 1
                  object dxDBGridSN5: TdxDBGridSN
                    Left = 1
                    Top = 1
                    Width = 570
                    Height = 320
                    Align = alClient
                    TabOrder = 0
                    LookAndFeel.Kind = lfFlat
                    CriteriosPintarCelda = <>
                    object cxGridDBTableView2: TcxGridDBTableView
                      NavigatorButtons.ConfirmDelete = False
                      NavigatorButtons.First.Enabled = False
                      NavigatorButtons.First.Visible = False
                      NavigatorButtons.PriorPage.Enabled = False
                      NavigatorButtons.PriorPage.Visible = False
                      NavigatorButtons.Prior.Enabled = False
                      NavigatorButtons.Prior.Visible = False
                      NavigatorButtons.Next.Enabled = False
                      NavigatorButtons.Next.Visible = False
                      NavigatorButtons.NextPage.Enabled = False
                      NavigatorButtons.NextPage.Visible = False
                      NavigatorButtons.Last.Enabled = False
                      NavigatorButtons.Last.Visible = False
                      NavigatorButtons.Insert.Enabled = False
                      NavigatorButtons.Insert.Visible = False
                      NavigatorButtons.Append.Visible = True
                      NavigatorButtons.Delete.Enabled = False
                      NavigatorButtons.Delete.Visible = False
                      NavigatorButtons.Edit.Enabled = False
                      NavigatorButtons.Edit.Visible = False
                      NavigatorButtons.Post.Enabled = False
                      NavigatorButtons.Post.Visible = False
                      NavigatorButtons.Cancel.Enabled = False
                      NavigatorButtons.Cancel.Visible = False
                      NavigatorButtons.Refresh.Enabled = False
                      NavigatorButtons.Refresh.Visible = False
                      NavigatorButtons.SaveBookmark.Enabled = False
                      NavigatorButtons.SaveBookmark.Visible = False
                      NavigatorButtons.GotoBookmark.Enabled = False
                      NavigatorButtons.GotoBookmark.Visible = False
                      NavigatorButtons.Filter.Enabled = False
                      NavigatorButtons.Filter.Visible = False
                      DataController.DataSource = DSValoresClasificadoresCond
                      DataController.Summary.DefaultGroupSummaryItems = <>
                      DataController.Summary.FooterSummaryItems = <>
                      DataController.Summary.SummaryGroups = <>
                      OptionsBehavior.FocusCellOnTab = True
                      OptionsBehavior.FocusFirstCellOnNewRecord = True
                      OptionsBehavior.GoToNextCellOnEnter = True
                      OptionsBehavior.IncSearch = True
                      OptionsBehavior.FocusCellOnCycle = True
                      OptionsData.CancelOnExit = False
                      OptionsData.Deleting = False
                      OptionsData.DeletingConfirmation = False
                      OptionsData.Inserting = False
                      OptionsSelection.HideFocusRectOnExit = False
                      OptionsSelection.InvertSelect = False
                      OptionsView.Navigator = True
                      OptionsView.ScrollBars = ssVertical
                      OptionsView.CellAutoHeight = True
                      OptionsView.GroupByBox = False
                      object cxGridDBTableView2activo: TcxGridDBColumn
                        Caption = 'Sel.'
                        DataBinding.FieldName = 'activo'
                        PropertiesClassName = 'TcxCheckBoxProperties'
                        HeaderAlignmentHorz = taCenter
                        Options.IncSearch = False
                        Width = 54
                      end
                      object cxGridDBTableView2cod_val_clasif: TcxGridDBColumn
                        Caption = 'C'#243'digo'
                        DataBinding.FieldName = 'cod_val_clasif'
                        PropertiesClassName = 'TcxButtonEditProperties'
                        Properties.Buttons = <
                          item
                            Default = True
                            Kind = bkEllipsis
                          end>
                        HeaderAlignmentHorz = taCenter
                        Options.Editing = False
                        Width = 78
                      end
                      object cxGridDBTableView2desc_val_clasif: TcxGridDBColumn
                        Caption = 'Descripci'#243'n'
                        DataBinding.FieldName = 'desc_val_clasif'
                        HeaderAlignmentHorz = taCenter
                        Options.Editing = False
                        Width = 396
                      end
                    end
                    object cxGridLevel2: TcxGridLevel
                      GridView = cxGridDBTableView2
                    end
                  end
                end
              end
            end
          end
          object TabSheet1: TTabSheet
            Caption = 'Competencias'
            Font.Charset = DEFAULT_CHARSET
            Font.Color = clWindowText
            Font.Height = -11
            Font.Name = 'MS Sans Serif'
            Font.Style = []
            ParentFont = False
            object Splitter1: TSplitter
              Left = 0
              Top = 147
              Width = 867
              Height = 3
              Cursor = crVSplit
              Align = alTop
            end
            object dxDBGridSN2: TdxDBGridSN
              Left = 0
              Top = 0
              Width = 867
              Height = 147
              Align = alTop
              BorderWidth = 3
              TabOrder = 0
              LookAndFeel.Kind = lfFlat
              CriteriosPintarCelda = <>
              object dxDBGridSN2DBTableView1: TcxGridDBTableView
                NavigatorButtons.ConfirmDelete = False
                DataController.DataSource = DSCompetenciasCond
                DataController.Summary.DefaultGroupSummaryItems = <>
                DataController.Summary.FooterSummaryItems = <>
                DataController.Summary.SummaryGroups = <>
                OptionsView.GroupByBox = False
              end
              object dxDBGridSN2DBBandedTableView1: TcxGridDBBandedTableView
                NavigatorButtons.ConfirmDelete = False
                NavigatorButtons.First.Enabled = False
                NavigatorButtons.First.Visible = False
                NavigatorButtons.PriorPage.Enabled = False
                NavigatorButtons.PriorPage.Visible = False
                NavigatorButtons.Prior.Enabled = False
                NavigatorButtons.Prior.Visible = False
                NavigatorButtons.Next.Enabled = False
                NavigatorButtons.Next.Visible = False
                NavigatorButtons.NextPage.Enabled = False
                NavigatorButtons.NextPage.Visible = False
                NavigatorButtons.Last.Enabled = False
                NavigatorButtons.Last.Visible = False
                NavigatorButtons.Insert.Enabled = False
                NavigatorButtons.Insert.Visible = False
                NavigatorButtons.Append.Visible = True
                NavigatorButtons.Delete.Enabled = False
                NavigatorButtons.Delete.Visible = False
                NavigatorButtons.Edit.Enabled = False
                NavigatorButtons.Edit.Visible = False
                NavigatorButtons.Post.Enabled = False
                NavigatorButtons.Post.Visible = False
                NavigatorButtons.Cancel.Enabled = False
                NavigatorButtons.Cancel.Visible = False
                NavigatorButtons.Refresh.Enabled = False
                NavigatorButtons.Refresh.Visible = False
                NavigatorButtons.SaveBookmark.Enabled = False
                NavigatorButtons.SaveBookmark.Visible = False
                NavigatorButtons.GotoBookmark.Enabled = False
                NavigatorButtons.GotoBookmark.Visible = False
                NavigatorButtons.Filter.Enabled = False
                NavigatorButtons.Filter.Visible = False
                DataController.DataSource = DSCompetenciasCond
                DataController.Summary.DefaultGroupSummaryItems = <>
                DataController.Summary.FooterSummaryItems = <>
                DataController.Summary.SummaryGroups = <>
                OptionsBehavior.FocusCellOnTab = True
                OptionsBehavior.FocusFirstCellOnNewRecord = True
                OptionsBehavior.GoToNextCellOnEnter = True
                OptionsBehavior.FocusCellOnCycle = True
                OptionsData.Appending = True
                OptionsData.Deleting = False
                OptionsData.DeletingConfirmation = False
                OptionsSelection.HideFocusRectOnExit = False
                OptionsSelection.InvertSelect = False
                OptionsView.Navigator = True
                OptionsView.NoDataToDisplayInfoText = 'Sin competencias'
                OptionsView.CellAutoHeight = True
                OptionsView.GroupByBox = False
                Styles.Content = cxStyle1
                Bands = <
                  item
                    Width = 703
                  end>
                object dxDBGridSN2DBBandedTableView1orden: TcxGridDBBandedColumn
                  Caption = 'Orden'
                  DataBinding.FieldName = 'orden'
                  SortIndex = 0
                  SortOrder = soAscending
                  Width = 53
                  Position.BandIndex = 0
                  Position.ColIndex = 0
                  Position.RowIndex = 0
                end
                object dxDBGridSN2DBBandedTableView1codigo_compe: TcxGridDBBandedColumn
                  Caption = 'C'#243'digo'
                  DataBinding.FieldName = 'codigo_compe'
                  PropertiesClassName = 'TcxButtonEditProperties'
                  Properties.Buttons = <
                    item
                      Default = True
                      Kind = bkEllipsis
                    end>
                  HeaderAlignmentHorz = taCenter
                  Width = 93
                  Position.BandIndex = 0
                  Position.ColIndex = 1
                  Position.RowIndex = 0
                end
                object dxDBGridSN2DBBandedTableView1titulo_compe: TcxGridDBBandedColumn
                  Caption = 'Competencia'
                  DataBinding.FieldName = 'titulo_compe'
                  HeaderAlignmentHorz = taCenter
                  Styles.Content = cxStyle1
                  Width = 464
                  Position.BandIndex = 0
                  Position.ColIndex = 2
                  Position.RowIndex = 0
                end
                object dxDBGridSN2DBBandedTableView1peso_competencia: TcxGridDBBandedColumn
                  Caption = 'Peso'
                  DataBinding.FieldName = 'peso_competencia'
                  HeaderAlignmentHorz = taCenter
                  Width = 51
                  Position.BandIndex = 0
                  Position.ColIndex = 3
                  Position.RowIndex = 0
                end
                object dxDBGridSN2DBBandedTableView1activo: TcxGridDBBandedColumn
                  Caption = 'Activo'
                  DataBinding.FieldName = 'activo'
                  PropertiesClassName = 'TcxCheckBoxProperties'
                  HeaderAlignmentHorz = taCenter
                  Width = 42
                  Position.BandIndex = 0
                  Position.ColIndex = 4
                  Position.RowIndex = 0
                end
              end
              object dxDBGridSN2Level1: TcxGridLevel
                GridView = dxDBGridSN2DBBandedTableView1
              end
            end
            object Panel8: TPanel
              Left = 0
              Top = 150
              Width = 867
              Height = 231
              Align = alClient
              Color = clWindow
              TabOrder = 1
              object Panel9: TPanel
                Left = 1
                Top = 1
                Width = 865
                Height = 24
                Align = alTop
                Color = clWindow
                TabOrder = 0
                object Label6: TLabel
                  Left = 3
                  Top = 4
                  Width = 158
                  Height = 13
                  Caption = 'Definici'#243'n de Competencia:'
                  Font.Charset = ANSI_CHARSET
                  Font.Color = clNavy
                  Font.Height = -11
                  Font.Name = 'Verdana'
                  Font.Style = []
                  ParentFont = False
                end
                object snDBEdit2: TsnDBEdit
                  Left = 161
                  Top = 0
                  TabStop = False
                  DataBinding.DataField = 'titulo_compe'
                  DataBinding.DataSource = DSCompetenciasCond
                  ParentFont = False
                  Properties.ReadOnly = True
                  Style.Edges = []
                  Style.Font.Charset = ANSI_CHARSET
                  Style.Font.Color = clNavy
                  Style.Font.Height = -12
                  Style.Font.Name = 'Verdana'
                  Style.Font.Style = []
                  Style.IsFontAssigned = True
                  TabOrder = 0
                  Width = 573
                end
              end
              object Panel10: TPanel
                Left = 1
                Top = 25
                Width = 865
                Height = 205
                Align = alClient
                Color = clWindow
                TabOrder = 1
                object snDBMemo1: TsnDBMemo
                  Left = 1
                  Top = 1
                  Align = alClient
                  DataBinding.DataField = 'definicion_compe'
                  DataBinding.DataSource = DSCompetenciasCond
                  ParentFont = False
                  Properties.ScrollBars = ssVertical
                  Properties.WantTabs = True
                  Style.Font.Charset = DEFAULT_CHARSET
                  Style.Font.Color = clWindowText
                  Style.Font.Height = -13
                  Style.Font.Name = 'MS Sans Serif'
                  Style.Font.Style = []
                  Style.IsFontAssigned = True
                  TabOrder = 0
                  ReadOnlyAlways = False
                  Height = 203
                  Width = 863
                end
              end
            end
          end
          object TabSheet2: TTabSheet
            Caption = 'Grados'
            ImageIndex = 1
            object Panel11: TPanel
              Left = 0
              Top = 0
              Width = 867
              Height = 81
              Align = alTop
              Color = clWindow
              TabOrder = 0
              object Label7: TLabel
                Left = 22
                Top = 29
                Width = 80
                Height = 13
                Caption = 'Competencia:'
                Font.Charset = ANSI_CHARSET
                Font.Color = clNavy
                Font.Height = -11
                Font.Name = 'Verdana'
                Font.Style = []
                ParentFont = False
              end
              object snLabel1: TsnLabel
                Left = 24
                Top = 6
                Width = 167
                Height = 13
                Cursor = crHandPoint
                Caption = 'ir a la siguiente Competencia'
                Font.Charset = ANSI_CHARSET
                Font.Color = clBlue
                Font.Height = -11
                Font.Name = 'Verdana'
                Font.Style = [fsUnderline]
                ParentFont = False
              end
              object snLabel2: TsnLabel
                Left = 224
                Top = 6
                Width = 147
                Height = 13
                Cursor = crHandPoint
                Caption = 'ir a Competencia anterior'
                Font.Charset = ANSI_CHARSET
                Font.Color = clBlue
                Font.Height = -11
                Font.Name = 'Verdana'
                Font.Style = [fsUnderline]
                ParentFont = False
              end
              object snDBEdit3: TsnDBEdit
                Left = 104
                Top = 25
                TabStop = False
                DataBinding.DataField = 'titulo_compe'
                DataBinding.DataSource = DSCompetenciasCond
                ParentFont = False
                Properties.ReadOnly = True
                Style.Edges = []
                Style.Font.Charset = ANSI_CHARSET
                Style.Font.Color = clNavy
                Style.Font.Height = -12
                Style.Font.Name = 'Verdana'
                Style.Font.Style = []
                Style.IsFontAssigned = True
                TabOrder = 0
                Width = 633
              end
              object DBNavigator1: TDBNavigator
                Left = 24
                Top = 48
                Width = 128
                Height = 25
                DataSource = DSCompetenciasCond
                VisibleButtons = [nbPrior, nbNext]
                TabOrder = 1
              end
            end
            object Panel12: TPanel
              Left = 0
              Top = 81
              Width = 867
              Height = 300
              Align = alClient
              Color = clWindow
              TabOrder = 1
              object dxDBGridSN3: TdxDBGridSN
                Left = 1
                Top = 1
                Width = 865
                Height = 298
                Align = alClient
                TabOrder = 0
                LookAndFeel.Kind = lfFlat
                CriteriosPintarCelda = <>
                object dxDBGridSN3DBTableView1: TcxGridDBTableView
                  NavigatorButtons.ConfirmDelete = False
                  NavigatorButtons.First.Enabled = False
                  NavigatorButtons.First.Visible = False
                  NavigatorButtons.PriorPage.Enabled = False
                  NavigatorButtons.PriorPage.Visible = False
                  NavigatorButtons.Prior.Enabled = False
                  NavigatorButtons.Prior.Visible = False
                  NavigatorButtons.Next.Enabled = False
                  NavigatorButtons.Next.Visible = False
                  NavigatorButtons.NextPage.Enabled = False
                  NavigatorButtons.NextPage.Visible = False
                  NavigatorButtons.Last.Enabled = False
                  NavigatorButtons.Last.Visible = False
                  NavigatorButtons.Insert.Enabled = False
                  NavigatorButtons.Insert.Visible = False
                  NavigatorButtons.Append.Visible = True
                  NavigatorButtons.Delete.Enabled = False
                  NavigatorButtons.Delete.Visible = False
                  NavigatorButtons.Edit.Enabled = False
                  NavigatorButtons.Edit.Visible = False
                  NavigatorButtons.Post.Enabled = False
                  NavigatorButtons.Post.Visible = False
                  NavigatorButtons.Cancel.Enabled = False
                  NavigatorButtons.Cancel.Visible = False
                  NavigatorButtons.Refresh.Enabled = False
                  NavigatorButtons.Refresh.Visible = False
                  NavigatorButtons.SaveBookmark.Enabled = False
                  NavigatorButtons.SaveBookmark.Visible = False
                  NavigatorButtons.GotoBookmark.Enabled = False
                  NavigatorButtons.GotoBookmark.Visible = False
                  NavigatorButtons.Filter.Enabled = False
                  NavigatorButtons.Filter.Visible = False
                  DataController.DataSource = DSTModeloEvalGrados
                  DataController.Summary.DefaultGroupSummaryItems = <>
                  DataController.Summary.FooterSummaryItems = <>
                  DataController.Summary.SummaryGroups = <>
                  OptionsBehavior.FocusCellOnTab = True
                  OptionsBehavior.FocusFirstCellOnNewRecord = True
                  OptionsBehavior.GoToNextCellOnEnter = True
                  OptionsBehavior.FocusCellOnCycle = True
                  OptionsData.Appending = True
                  OptionsData.Deleting = False
                  OptionsSelection.HideFocusRectOnExit = False
                  OptionsSelection.InvertSelect = False
                  OptionsView.Navigator = True
                  OptionsView.CellAutoHeight = True
                  OptionsView.GroupByBox = False
                  object dxDBGridSN3DBTableView1nro_grado: TcxGridDBColumn
                    Caption = 'Nro. Grado'
                    DataBinding.FieldName = 'nro_grado'
                    HeaderAlignmentHorz = taCenter
                    SortIndex = 0
                    SortOrder = soAscending
                    Width = 90
                  end
                  object dxDBGridSN3DBTableView1desc_grados: TcxGridDBColumn
                    Caption = 'Grado'
                    DataBinding.FieldName = 'desc_grados'
                    PropertiesClassName = 'TcxMemoProperties'
                    Properties.MaxLength = 3990
                    Properties.ScrollBars = ssVertical
                    Properties.WantTabs = True
                    HeaderAlignmentHorz = taCenter
                    Width = 502
                  end
                  object dxDBGridSN3DBTableView1peso: TcxGridDBColumn
                    Caption = '% Cumplimiento'
                    DataBinding.FieldName = 'peso'
                    HeaderAlignmentHorz = taCenter
                    Width = 124
                  end
                  object dxDBGridSN3DBTableView1activo: TcxGridDBColumn
                    Caption = 'Activo'
                    DataBinding.FieldName = 'activo'
                    PropertiesClassName = 'TcxCheckBoxProperties'
                    HeaderAlignmentHorz = taCenter
                    Width = 50
                  end
                end
                object dxDBGridSN3Level1: TcxGridLevel
                  GridView = dxDBGridSN3DBTableView1
                end
              end
            end
          end
          object TabSheet3: TTabSheet
            Caption = 'Firmas'
            ImageIndex = 2
            object dxDBGridSN6: TdxDBGridSN
              Left = 0
              Top = 0
              Width = 867
              Height = 381
              Align = alClient
              TabOrder = 0
              LookAndFeel.Kind = lfFlat
              CriteriosPintarCelda = <>
              object cxGridDBTableView3: TcxGridDBTableView
                NavigatorButtons.ConfirmDelete = False
                NavigatorButtons.First.Enabled = False
                NavigatorButtons.First.Visible = False
                NavigatorButtons.PriorPage.Enabled = False
                NavigatorButtons.PriorPage.Visible = False
                NavigatorButtons.Prior.Enabled = False
                NavigatorButtons.Prior.Visible = False
                NavigatorButtons.Next.Enabled = False
                NavigatorButtons.Next.Visible = False
                NavigatorButtons.NextPage.Enabled = False
                NavigatorButtons.NextPage.Visible = False
                NavigatorButtons.Last.Enabled = False
                NavigatorButtons.Last.Visible = False
                NavigatorButtons.Insert.Enabled = False
                NavigatorButtons.Insert.Visible = False
                NavigatorButtons.Append.Visible = True
                NavigatorButtons.Delete.Enabled = False
                NavigatorButtons.Delete.Visible = False
                NavigatorButtons.Edit.Enabled = False
                NavigatorButtons.Edit.Visible = False
                NavigatorButtons.Post.Enabled = False
                NavigatorButtons.Post.Visible = False
                NavigatorButtons.Cancel.Enabled = False
                NavigatorButtons.Cancel.Visible = False
                NavigatorButtons.Refresh.Enabled = False
                NavigatorButtons.Refresh.Visible = False
                NavigatorButtons.SaveBookmark.Enabled = False
                NavigatorButtons.SaveBookmark.Visible = False
                NavigatorButtons.GotoBookmark.Enabled = False
                NavigatorButtons.GotoBookmark.Visible = False
                NavigatorButtons.Filter.Enabled = False
                NavigatorButtons.Filter.Visible = False
                DataController.DataSource = DSFirmasCond
                DataController.Summary.DefaultGroupSummaryItems = <>
                DataController.Summary.FooterSummaryItems = <>
                DataController.Summary.SummaryGroups = <>
                OptionsBehavior.FocusCellOnTab = True
                OptionsBehavior.FocusFirstCellOnNewRecord = True
                OptionsBehavior.GoToNextCellOnEnter = True
                OptionsBehavior.FocusCellOnCycle = True
                OptionsData.Appending = True
                OptionsData.Deleting = False
                OptionsSelection.HideFocusRectOnExit = False
                OptionsSelection.InvertSelect = False
                OptionsView.Navigator = True
                OptionsView.CellAutoHeight = True
                OptionsView.GroupByBox = False
                object cxGridDBTableView3nro_firma: TcxGridDBColumn
                  Caption = 'Nro. Firma'
                  DataBinding.FieldName = 'nro_firma'
                  HeaderAlignmentHorz = taCenter
                  SortIndex = 0
                  SortOrder = soAscending
                  Width = 72
                end
                object cxGridDBTableView3titulo: TcxGridDBColumn
                  Caption = 'T'#237'tulo Reporte'
                  DataBinding.FieldName = 'titulo'
                  HeaderAlignmentHorz = taCenter
                  Width = 217
                end
                object cxGridDBTableView3cod_legajo_firma: TcxGridDBColumn
                  Caption = 'Legajo'
                  DataBinding.FieldName = 'cod_legajo_firma'
                  PropertiesClassName = 'TcxButtonEditProperties'
                  Properties.Buttons = <
                    item
                      Default = True
                      Kind = bkEllipsis
                    end>
                  HeaderAlignmentHorz = taCenter
                  Width = 92
                end
                object cxGridDBTableView3desc_legajo_firma: TcxGridDBColumn
                  Caption = 'Apellido y Nombre'
                  DataBinding.FieldName = 'desc_legajo_firma'
                  HeaderAlignmentHorz = taCenter
                  Options.Editing = False
                  Options.Focusing = False
                  Width = 269
                end
                object cxGridDBTableView3activo: TcxGridDBColumn
                  Caption = 'Activo'
                  DataBinding.FieldName = 'activo'
                  PropertiesClassName = 'TcxCheckBoxProperties'
                  HeaderAlignmentHorz = taCenter
                  Width = 56
                end
              end
              object cxGridLevel3: TcxGridLevel
                GridView = cxGridDBTableView3
              end
            end
          end
          object TabSheet5: TTabSheet
            Caption = 'Legajos'
            ImageIndex = 4
            object Panel21: TPanel
              Left = 0
              Top = 0
              Width = 867
              Height = 28
              Align = alTop
              Color = clWindow
              TabOrder = 0
              object Label11: TLabel
                Left = 15
                Top = 5
                Width = 277
                Height = 16
                Caption = 'Aplicar evaluaci'#243'n a los siguientes legajos'
                Font.Charset = ANSI_CHARSET
                Font.Color = clNavy
                Font.Height = -13
                Font.Name = 'Verdana'
                Font.Style = []
                ParentFont = False
              end
            end
            object Panel22: TPanel
              Left = 0
              Top = 28
              Width = 867
              Height = 353
              Align = alClient
              Color = clWindow
              TabOrder = 1
              object dxDBGridSN7: TdxDBGridSN
                Left = 1
                Top = 1
                Width = 865
                Height = 351
                Align = alClient
                TabOrder = 0
                LookAndFeel.Kind = lfFlat
                CriteriosPintarCelda = <>
                object cxGridDBTableView4: TcxGridDBTableView
                  NavigatorButtons.ConfirmDelete = False
                  NavigatorButtons.First.Enabled = False
                  NavigatorButtons.First.Visible = False
                  NavigatorButtons.PriorPage.Enabled = False
                  NavigatorButtons.PriorPage.Visible = False
                  NavigatorButtons.Prior.Enabled = False
                  NavigatorButtons.Prior.Visible = False
                  NavigatorButtons.Next.Enabled = False
                  NavigatorButtons.Next.Visible = False
                  NavigatorButtons.NextPage.Enabled = False
                  NavigatorButtons.NextPage.Visible = False
                  NavigatorButtons.Last.Enabled = False
                  NavigatorButtons.Last.Visible = False
                  NavigatorButtons.Insert.Enabled = False
                  NavigatorButtons.Insert.Visible = False
                  NavigatorButtons.Append.Visible = True
                  NavigatorButtons.Delete.Enabled = False
                  NavigatorButtons.Delete.Visible = False
                  NavigatorButtons.Edit.Enabled = False
                  NavigatorButtons.Edit.Visible = False
                  NavigatorButtons.Post.Enabled = False
                  NavigatorButtons.Post.Visible = False
                  NavigatorButtons.Cancel.Enabled = False
                  NavigatorButtons.Cancel.Visible = False
                  NavigatorButtons.Refresh.Enabled = False
                  NavigatorButtons.Refresh.Visible = False
                  NavigatorButtons.SaveBookmark.Enabled = False
                  NavigatorButtons.SaveBookmark.Visible = False
                  NavigatorButtons.GotoBookmark.Enabled = False
                  NavigatorButtons.GotoBookmark.Visible = False
                  NavigatorButtons.Filter.Enabled = False
                  NavigatorButtons.Filter.Visible = False
                  DataController.DataSource = DSTLegajosCond
                  DataController.Summary.DefaultGroupSummaryItems = <>
                  DataController.Summary.FooterSummaryItems = <>
                  DataController.Summary.SummaryGroups = <>
                  OptionsBehavior.FocusCellOnTab = True
                  OptionsBehavior.FocusFirstCellOnNewRecord = True
                  OptionsBehavior.GoToNextCellOnEnter = True
                  OptionsBehavior.FocusCellOnCycle = True
                  OptionsData.Appending = True
                  OptionsData.Deleting = False
                  OptionsSelection.HideFocusRectOnExit = False
                  OptionsSelection.InvertSelect = False
                  OptionsView.Navigator = True
                  OptionsView.CellAutoHeight = True
                  OptionsView.GroupByBox = False
                  object cxGridDBTableView4cod_legajo: TcxGridDBColumn
                    Caption = 'Legajo'
                    DataBinding.FieldName = 'cod_legajo'
                    PropertiesClassName = 'TcxButtonEditProperties'
                    Properties.Buttons = <
                      item
                        Default = True
                        Kind = bkEllipsis
                      end>
                    HeaderAlignmentHorz = taCenter
                    Width = 86
                  end
                  object cxGridDBTableView4desc_legajo: TcxGridDBColumn
                    Caption = 'Apellido y Nombre'
                    DataBinding.FieldName = 'desc_legajo'
                    HeaderAlignmentHorz = taCenter
                    Options.Editing = False
                    Options.Focusing = False
                    Width = 444
                  end
                  object cxGridDBTableView4activo: TcxGridDBColumn
                    Caption = 'Activo'
                    DataBinding.FieldName = 'activo'
                    PropertiesClassName = 'TcxCheckBoxProperties'
                    HeaderAlignmentHorz = taCenter
                    Width = 63
                  end
                end
                object cxGridLevel4: TcxGridLevel
                  GridView = cxGridDBTableView4
                end
              end
            end
          end
          object TabSheet6: TTabSheet
            Caption = 'Observaciones seg'#250'n Puntaje'
            ImageIndex = 5
            object Panel23: TPanel
              Left = 0
              Top = 0
              Width = 867
              Height = 124
              Align = alTop
              BevelOuter = bvNone
              Color = clWindow
              TabOrder = 0
              object Panel25: TPanel
                Left = 0
                Top = 0
                Width = 867
                Height = 16
                Align = alTop
                BevelOuter = bvNone
                Color = clWindow
                TabOrder = 0
                object Label12: TLabel
                  Left = 15
                  Top = -1
                  Width = 460
                  Height = 16
                  Caption = 
                    'Rango de Puntajes sobre los cuales aplicar observaciones codific' +
                    'adas'
                  Font.Charset = ANSI_CHARSET
                  Font.Color = clNavy
                  Font.Height = -13
                  Font.Name = 'Verdana'
                  Font.Style = []
                  ParentFont = False
                end
              end
              object Panel26: TPanel
                Left = 0
                Top = 16
                Width = 867
                Height = 108
                Align = alClient
                BevelOuter = bvNone
                BorderWidth = 2
                Color = clWindow
                TabOrder = 1
                object dxDBGridSN8: TdxDBGridSN
                  Left = 2
                  Top = 2
                  Width = 863
                  Height = 104
                  Align = alClient
                  TabOrder = 0
                  LookAndFeel.Kind = lfFlat
                  CriteriosPintarCelda = <>
                  object cxGridDBTableView5: TcxGridDBTableView
                    NavigatorButtons.ConfirmDelete = False
                    NavigatorButtons.First.Enabled = False
                    NavigatorButtons.First.Visible = False
                    NavigatorButtons.PriorPage.Enabled = False
                    NavigatorButtons.PriorPage.Visible = False
                    NavigatorButtons.Prior.Enabled = False
                    NavigatorButtons.Prior.Visible = False
                    NavigatorButtons.Next.Enabled = False
                    NavigatorButtons.Next.Visible = False
                    NavigatorButtons.NextPage.Enabled = False
                    NavigatorButtons.NextPage.Visible = False
                    NavigatorButtons.Last.Enabled = False
                    NavigatorButtons.Last.Visible = False
                    NavigatorButtons.Insert.Enabled = False
                    NavigatorButtons.Insert.Visible = False
                    NavigatorButtons.Append.Visible = True
                    NavigatorButtons.Delete.Enabled = False
                    NavigatorButtons.Delete.Visible = False
                    NavigatorButtons.Edit.Enabled = False
                    NavigatorButtons.Edit.Visible = False
                    NavigatorButtons.Post.Enabled = False
                    NavigatorButtons.Post.Visible = False
                    NavigatorButtons.Cancel.Enabled = False
                    NavigatorButtons.Cancel.Visible = False
                    NavigatorButtons.Refresh.Enabled = False
                    NavigatorButtons.Refresh.Visible = False
                    NavigatorButtons.SaveBookmark.Enabled = False
                    NavigatorButtons.SaveBookmark.Visible = False
                    NavigatorButtons.GotoBookmark.Enabled = False
                    NavigatorButtons.GotoBookmark.Visible = False
                    NavigatorButtons.Filter.Enabled = False
                    NavigatorButtons.Filter.Visible = False
                    DataController.DataSource = DSTObsCodigSegunPtos
                    DataController.Summary.DefaultGroupSummaryItems = <>
                    DataController.Summary.FooterSummaryItems = <>
                    DataController.Summary.SummaryGroups = <>
                    OptionsBehavior.FocusCellOnTab = True
                    OptionsBehavior.FocusFirstCellOnNewRecord = True
                    OptionsBehavior.GoToNextCellOnEnter = True
                    OptionsBehavior.FocusCellOnCycle = True
                    OptionsData.Appending = True
                    OptionsData.Deleting = False
                    OptionsSelection.HideFocusRectOnExit = False
                    OptionsSelection.InvertSelect = False
                    OptionsView.Navigator = True
                    OptionsView.CellAutoHeight = True
                    OptionsView.GroupByBox = False
                    object cxGridDBTableView5puntaje_desde: TcxGridDBColumn
                      Caption = 'Puntaje Desde'
                      DataBinding.FieldName = 'puntaje_desde'
                      HeaderAlignmentHorz = taCenter
                      SortIndex = 0
                      SortOrder = soAscending
                      Width = 113
                    end
                    object cxGridDBTableView5puntaje_hasta: TcxGridDBColumn
                      Caption = 'Puntaje Hasta'
                      DataBinding.FieldName = 'puntaje_hasta'
                      HeaderAlignmentHorz = taCenter
                      Width = 113
                    end
                    object cxGridDBTableView5activo: TcxGridDBColumn
                      Caption = 'Activo'
                      DataBinding.FieldName = 'activo'
                      HeaderAlignmentHorz = taCenter
                      Width = 59
                    end
                  end
                  object cxGridLevel5: TcxGridLevel
                    GridView = cxGridDBTableView5
                  end
                end
              end
            end
            object Panel24: TPanel
              Left = 0
              Top = 124
              Width = 867
              Height = 257
              Align = alClient
              Color = clWindow
              TabOrder = 1
              object Panel27: TPanel
                Left = 1
                Top = 1
                Width = 865
                Height = 255
                Align = alClient
                BevelOuter = bvNone
                Color = clWindow
                TabOrder = 0
                object Panel28: TPanel
                  Left = 0
                  Top = 0
                  Width = 865
                  Height = 23
                  Align = alTop
                  BevelOuter = bvNone
                  Color = clWindow
                  TabOrder = 0
                  object Label13: TLabel
                    Left = 15
                    Top = 4
                    Width = 349
                    Height = 16
                    Caption = 'Observaciones codificadas para el rango de puntaje:'
                    Font.Charset = ANSI_CHARSET
                    Font.Color = clNavy
                    Font.Height = -13
                    Font.Name = 'Verdana'
                    Font.Style = []
                    ParentFont = False
                  end
                  object Label14: TLabel
                    Left = 447
                    Top = 3
                    Width = 6
                    Height = 16
                    Caption = '/'
                    Font.Charset = ANSI_CHARSET
                    Font.Color = clNavy
                    Font.Height = -13
                    Font.Name = 'Verdana'
                    Font.Style = []
                    ParentFont = False
                  end
                  object snDBEdit5: TsnDBEdit
                    Left = 376
                    Top = -1
                    TabStop = False
                    DataBinding.DataField = 'puntaje_desde'
                    DataBinding.DataSource = DSTObsCodigSegunPtos
                    Properties.ReadOnly = True
                    TabOrder = 0
                    Width = 65
                  end
                  object snDBEdit6: TsnDBEdit
                    Left = 456
                    Top = -1
                    TabStop = False
                    DataBinding.DataField = 'puntaje_hasta'
                    DataBinding.DataSource = DSTObsCodigSegunPtos
                    Properties.ReadOnly = True
                    TabOrder = 1
                    Width = 65
                  end
                end
                object Panel29: TPanel
                  Left = 0
                  Top = 23
                  Width = 865
                  Height = 232
                  Align = alClient
                  BevelOuter = bvNone
                  Color = clWindow
                  TabOrder = 1
                  object dxDBGridSN9: TdxDBGridSN
                    Left = 0
                    Top = 0
                    Width = 865
                    Height = 232
                    Align = alClient
                    TabOrder = 0
                    LookAndFeel.Kind = lfFlat
                    CriteriosPintarCelda = <>
                    object cxGridDBTableView6: TcxGridDBTableView
                      NavigatorButtons.ConfirmDelete = False
                      NavigatorButtons.First.Enabled = False
                      NavigatorButtons.First.Visible = False
                      NavigatorButtons.PriorPage.Enabled = False
                      NavigatorButtons.PriorPage.Visible = False
                      NavigatorButtons.Prior.Enabled = False
                      NavigatorButtons.Prior.Visible = False
                      NavigatorButtons.Next.Enabled = False
                      NavigatorButtons.Next.Visible = False
                      NavigatorButtons.NextPage.Enabled = False
                      NavigatorButtons.NextPage.Visible = False
                      NavigatorButtons.Last.Enabled = False
                      NavigatorButtons.Last.Visible = False
                      NavigatorButtons.Insert.Enabled = False
                      NavigatorButtons.Insert.Visible = False
                      NavigatorButtons.Append.Visible = True
                      NavigatorButtons.Delete.Enabled = False
                      NavigatorButtons.Delete.Visible = False
                      NavigatorButtons.Edit.Enabled = False
                      NavigatorButtons.Edit.Visible = False
                      NavigatorButtons.Post.Enabled = False
                      NavigatorButtons.Post.Visible = False
                      NavigatorButtons.Cancel.Enabled = False
                      NavigatorButtons.Cancel.Visible = False
                      NavigatorButtons.Refresh.Enabled = False
                      NavigatorButtons.Refresh.Visible = False
                      NavigatorButtons.SaveBookmark.Enabled = False
                      NavigatorButtons.SaveBookmark.Visible = False
                      NavigatorButtons.GotoBookmark.Enabled = False
                      NavigatorButtons.GotoBookmark.Visible = False
                      NavigatorButtons.Filter.Enabled = False
                      NavigatorButtons.Filter.Visible = False
                      DataController.DataSource = DSTObsCodifEvalRango
                      DataController.Summary.DefaultGroupSummaryItems = <>
                      DataController.Summary.FooterSummaryItems = <>
                      DataController.Summary.SummaryGroups = <>
                      OptionsBehavior.FocusCellOnTab = True
                      OptionsBehavior.FocusFirstCellOnNewRecord = True
                      OptionsBehavior.GoToNextCellOnEnter = True
                      OptionsBehavior.FocusCellOnCycle = True
                      OptionsData.Appending = True
                      OptionsData.Deleting = False
                      OptionsSelection.HideFocusRectOnExit = False
                      OptionsSelection.InvertSelect = False
                      OptionsView.Navigator = True
                      OptionsView.CellAutoHeight = True
                      OptionsView.GroupByBox = False
                      object cxGridDBTableView6cod_obs_codif: TcxGridDBColumn
                        Caption = 'C'#243'digo'
                        DataBinding.FieldName = 'cod_obs_codif'
                        PropertiesClassName = 'TcxButtonEditProperties'
                        Properties.Buttons = <
                          item
                            Default = True
                            Kind = bkEllipsis
                          end>
                        HeaderAlignmentHorz = taCenter
                        Width = 122
                      end
                      object cxGridDBTableView6descripcion: TcxGridDBColumn
                        Caption = 'Descripci'#243'n'
                        DataBinding.FieldName = 'descripcion'
                        PropertiesClassName = 'TcxMemoProperties'
                        Properties.MaxLength = 3990
                        Properties.ScrollBars = ssVertical
                        Properties.WantTabs = True
                        HeaderAlignmentHorz = taCenter
                        Width = 583
                      end
                      object cxGridDBTableView6activo: TcxGridDBColumn
                        Caption = 'Activo'
                        DataBinding.FieldName = 'activo'
                        PropertiesClassName = 'TcxCheckBoxProperties'
                        HeaderAlignmentHorz = taCenter
                        Width = 55
                      end
                    end
                    object cxGridLevel6: TcxGridLevel
                      GridView = cxGridDBTableView6
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
    OperTraerObjeto = 'TraerModeloEvalCab'
    OperGrabarObjeto = 'SaveModeloEvalCab'
    CargaDataSets = <
      item
        DataSet = TModeloEvalCab
        TableName = 'TModeloEvalCab'
      end
      item
        DataSet = TCondModEvalCab
        TableName = 'TCondModEvalCab'
      end
      item
        DataSet = TCompetenciasCond
        TableName = 'TCompetenciasCond'
      end
      item
        DataSet = TCompetencia
        TableName = 'TCompetencia'
      end
      item
        DataSet = TModeloEvalGrados
        TableName = 'TModeloEvalGrados'
      end
      item
        DataSet = TClasificadoresLegajo
        TableName = 'TClasificadoresLegajo'
      end
      item
        DataSet = TClasificadoresCond
        TableName = 'TClasificadoresCond'
      end
      item
        DataSet = TValoresClasificadoresLegajo
        TableName = 'TValoresClasificadoresLegajo'
      end
      item
        DataSet = TValoresClasificadoresCond
        TableName = 'TValoresClasificadoresCond'
      end
      item
        DataSet = TFirmasCond
        TableName = 'TFirmasCond'
      end
      item
        DataSet = TLegajosCond
        TableName = 'TLegajosCond'
      end
      item
        DataSet = TObsCodigSegunPtos
        TableName = 'TObsCodigSegunPtos'
      end
      item
        DataSet = TObsCodifEvalRango
        TableName = 'TObsCodifEvalRango'
      end
      item
        DataSet = TGradoCompetencia
        TableName = 'TGradoCompetencia'
      end
      item
        DataSet = TTiposModEval
        TableName = 'TTiposModEval'
      end>
    BajaLogica = <
      item
        DataSet = TModeloEvalCab
        ValorBaja = 'false'
        ValorRehabilitacion = 'true'
        TipoBajaRegistro = tblCurrentRecord
        FieldName = 'activo'
      end>
    OperHabilitadas = [toOperNuevo, toOperModificar, toOperEliminar, toOperBuscar, toOperNavegacion, toOperRehabilitar]
    DataSetCab = TModeloEvalCab
    DataSetDet1 = TCondModEvalCab
    DataSetDet2 = TCompetenciasCond
    DataSetDet3 = TModeloEvalGrados
    DataSetDet4 = TClasificadoresCond
    DataSetDet5 = TValoresClasificadoresCond
    DataSetDet6 = TFirmasCond
    DataSetDet7 = TLegajosCond
    DataSetDet8 = TObsCodigSegunPtos
    DataSetDet9 = TObsCodifEvalRango
    ControlFocoAlta = DBECodigo
    ControlFocoModif = DBECodigo
    Left = 512
    Top = 16
  end
  inherited Operacion: TOperacion
    Left = 560
    Top = 16
  end
  object TModeloEvalCab: TsnTable [3]
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'oid_mod_eval_cab'
        DataType = ftInteger
      end
      item
        Name = 'titulo'
        DataType = ftString
        Size = 100
      end
      item
        Name = 'desc_abreviada'
        DataType = ftString
        Size = 50
      end
      item
        Name = 'fec_desde'
        DataType = ftDate
      end
      item
        Name = 'fec_hasta'
        DataType = ftDate
      end
      item
        Name = 'vigente'
        DataType = ftBoolean
      end
      item
        Name = 'activo'
        DataType = ftBoolean
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
    Left = 648
    Top = 59
    object TModeloEvalCaboid_mod_eval_cab: TIntegerField
      FieldName = 'oid_mod_eval_cab'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TModeloEvalCabtitulo: TStringField
      FieldName = 'titulo'
      Size = 100
    end
    object TModeloEvalCabdesc_abreviada: TStringField
      FieldName = 'desc_abreviada'
      Size = 50
    end
    object TModeloEvalCabfec_desde: TDateField
      FieldName = 'fec_desde'
    end
    object TModeloEvalCabfec_hasta: TDateField
      FieldName = 'fec_hasta'
    end
    object TModeloEvalCabvigente: TBooleanField
      FieldName = 'vigente'
    end
    object TModeloEvalCabactivo: TBooleanField
      DefaultExpression = '1'
      FieldName = 'activo'
    end
    object TModeloEvalCaboid_armar_en_base_a: TIntegerField
      FieldName = 'oid_armar_en_base_a'
    end
    object TModeloEvalCabcod_armar_en_base_a: TStringField
      FieldName = 'cod_armar_en_base_a'
      Size = 4000
    end
    object TModeloEvalCabdesc_armar_en_base_a: TStringField
      FieldName = 'desc_armar_en_base_a'
      Size = 4000
    end
    object TModeloEvalCabtipo: TStringField
      FieldName = 'tipo'
    end
  end
  object DSTModeloEvalCab: TDataSource [4]
    DataSet = TModeloEvalCab
    Left = 680
    Top = 59
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
  inherited DriverEvent: TDriverEvent
    OnValidate = <
      item
        TableName = 'TModeloEvalCab'
        FieldName = 'desc_abreviada'
        Source.Strings = (
          'begin'
          '  ValidadorDefinicion.Value := Sender.AsString;'
          '  ValidadorDefinicion.Validar;'
          'end.')
      end
      item
        TableName = 'TCompetenciasCond'
        FieldName = 'codigo_compe'
        Source.Strings = (
          'begin'
          ''
          ' '
          
            '  if (TCompetenciasCond.FieldName('#39'oid_competencia'#39').AsInteger>0' +
            ')'
          
            '      then raiseException(erCustomError,'#39'No se puede modificar u' +
            'na competencia una vez ingresada. Si no desea utilizarla desacti' +
            've la misma desmarcando el tilde de activo.'#39');'
          ''
          '  if (Trim(Sender.AsString)<>'#39#39')'
          '     then begin'
          ''
          '             TraerCompetencia(Sender.AsString);'
          ''
          '             if  (TCompetencia.IsEmpty())'
          
            '                 then raiseException(erCustomError,'#39'C'#243'digo de co' +
            'mpetencia inexistente.'#39');'
          ''
          '            TCompetenciasCond.EditRecord;'
          
            '            TCompetenciasCond.FieldName('#39'oid_competencia'#39').AsInt' +
            'eger := TCompetencia.FieldName('#39'oid_competencia'#39').AsInteger;'
          
            '            TCompetenciasCond.FieldName('#39'titulo_compe'#39').AsString' +
            ' := TCompetencia.FieldName('#39'titulo'#39').AsString;'
          
            '            TCompetenciasCond.FieldName('#39'definicion_compe'#39').AsSt' +
            'ring :=  TCompetencia.FieldName('#39'definicion'#39').AsString;         ' +
            ' '
          ''
          ''
          '            if (TModeloEvalGrados.IsEmpty()) '
          '               then begin'
          ''
          '                      TGradoCompetencia.First;'
          '                      while (not TGradoCompetencia.EOF) do'
          '                        begin'
          ''
          '                        TModeloEvalGrados.AppendRecord;'
          
            '                        TModeloEvalGrados.FieldName('#39'oid_mod_eva' +
            'l_comp'#39').AsInteger := TCompetenciasCond.FieldName('#39'oid_mod_eval_' +
            'comp'#39').AsInteger;'
          
            '                        TModeloEvalGrados.FieldName('#39'nro_grado'#39')' +
            '.AsInteger :=  TGradoCompetencia.FieldName('#39'nro_grado'#39').AsIntege' +
            'r;'
          
            '                        TModeloEvalGrados.FieldName('#39'desc_grados' +
            #39').Value := TGradoCompetencia.FieldName('#39'desc_grados'#39').Value;'
          
            '                        TModeloEvalGrados.FieldName('#39'peso'#39').Valu' +
            'e := TGradoCompetencia.FieldName('#39'peso_tentativo'#39').Value;'
          
            '                        TModeloEvalGrados.FieldName('#39'activo'#39').As' +
            'Boolean := True; '
          '                        TModeloEvalGrados.PostRecord;'
          ''
          '                        TGradoCompetencia.next;'
          '                        end;'
          ''
          '                       end;'
          '  '
          ''
          '             end'
          '     else begin'
          '            TCompetenciasCond.EditRecord;'
          
            '            TCompetenciasCond.FieldName('#39'oid_competencia'#39').Clear' +
            ';'
          '            TCompetenciasCond.FieldName('#39'titulo_compe'#39').Clear;'
          
            '            TCompetenciasCond.FieldName('#39'definicion_compe'#39').Clea' +
            'r;           '
          '            end;'
          'end.')
      end
      item
        TableName = 'TCompetenciasCond'
        FieldName = 'peso_competencia'
        Source.Strings = (
          'begin'
          '  if (Sender.AsCurrency<0)'
          
            '     then raiseException(erCustomError,'#39'El peso debe ser mayor o' +
            ' igual a cero'#39');'
          'end.')
      end
      item
        TableName = 'TFirmasCond'
        FieldName = 'cod_legajo_firma'
        Source.Strings = (
          'begin'
          '  ValidadorLegajo.Value := Sender.AsString;'
          '  ValidadorLegajo.Validar();'
          'end.')
      end
      item
        TableName = 'TLegajosCond'
        FieldName = 'cod_legajo'
        Source.Strings = (
          'begin'
          '  ValidadorLegajo1.Value := Sender.AsString;'
          '  ValidadorLegajo1.Validar();'
          'end.')
      end
      item
        TableName = 'TObsCodifEvalRango'
        FieldName = 'cod_obs_codif'
        Source.Strings = (
          'begin'
          '  ValidadorObsCodif.Value := Sender.AsString;'
          '  ValidadorObsCodif.Validar();'
          'end.')
      end
      item
        TableName = 'TModeloEvalCab'
        FieldName = 'cod_armar_en_base_a'
        Source.Strings = (
          'begin'
          '   ValidadorModEval.Value := Sender.AsString;'
          '   ValidadorModEval.Validar;'
          'end.')
      end
      item
        TableName = 'TModeloEvalCab'
        FieldName = 'cod_armar_en_base_a'
        Source.Strings = (
          'begin'
          '  if (not TCondModEvalCab.IsEmpty)'
          
            '     then raiseException(erCustomError,'#39'Las condiciones deben es' +
            'tar vac'#237'as para poder aplicar un modelo de evaluaci'#243'n base'#39');'
          'end.')
      end>
    OnChangeField = <
      item
        TableName = 'TModeloEvalCab'
        FieldName = 'oid_armar_en_base_a'
        Source.Strings = (
          'begin'
          '  if (Sender.AsInteger>0)'
          '     then begin'
          '             TraerCopiaModeloEval(Sender.AsInteger);'
          '             end;'
          'end.')
      end>
    OnBeforePost = <
      item
        TableName = 'TCondModEvalCab'
        Source.Strings = (
          'begin'
          '  if (DataSet.FieldName('#39'orden'#39').AsInteger<=0)'
          
            '     then raiseException(erCustomError,'#39'Debe ingresar el Nro. de' +
            ' Orden'#39');'
          'end.')
      end
      item
        TableName = 'TCompetenciasCond'
        Source.Strings = (
          'begin'
          '   if (DataSet.FieldName('#39'oid_competencia'#39').AsInteger=0)'
          '       then raiseException(null,'#39'Debe ingresar la competencia'#39');'
          '  if (DataSet.FieldName('#39'codigo_compe'#39').AsString='#39#39')'
          
            '       then raiseException(null,'#39'Debe ingresar el C'#243'digo de Comp' +
            'etencia'#39');'
          '  if (DataSet.FieldName('#39'titulo_compe'#39').AsString='#39#39')'
          
            '       then raiseException(null,'#39'Debe ingresar la descripci'#243'n de' +
            ' la Competencia'#39');'
          '   if (DataSet.FieldName('#39'peso_competencia'#39').Isnull)'
          
            '       then raiseException(null,'#39'Debe ingresar el peso de la com' +
            'petencia'#39');'
          'end.')
      end
      item
        TableName = 'TModeloEvalCab'
        Source.Strings = (
          'begin'
          '  if (Trim(DataSet.FieldName('#39'titulo'#39').AsString)='#39#39')'
          
            '     then raiseException(erCustomError,'#39'Debe ingresar el t'#237'tulo'#39 +
            ');'
          '  if (DataSet.FieldName('#39'desc_abreviada'#39').AsString = '#39#39')'
          
            '     then raiseException(erCustomError,'#39'Debe ingresar la descrip' +
            'ci'#243'n Abreviada'#39');'
          '  if (DataSet.FieldName('#39'fec_desde'#39').IsNull)'
          
            '     then raiseException(erCustomError,'#39'Debe ingresar la fecha d' +
            'esde'#39');'
          '  if (DataSet.FieldName('#39'fec_hasta'#39').IsNull)'
          
            '     then raiseException(erCustomError,'#39'Debe ingresar la fecha h' +
            'asta'#39');'
          'end.')
      end
      item
        TableName = 'TModeloEvalGrados'
        Source.Strings = (
          'begin'
          '  if (DataSet.FieldName('#39'nro_grado'#39').AsInteger=0)'
          
            '     then raiseException(erCustomError,'#39'Debe ingresar el Nro. de' +
            ' Orden'#39');'
          '  if (Trim(DataSet.FieldName('#39'desc_grados'#39').AsString)='#39#39')'
          
            '      then raiseException(erCustomError,'#39'Debe ingresar la descri' +
            'pci'#243'n del Grado'#39');'
          '  if (DataSet.FieldName('#39'peso'#39').IsNull)'
          
            '      then raiseException(erCustomError,'#39'Debe ingresar el peso d' +
            'el Grado'#39');'
          'end.')
      end
      item
        TableName = 'TFirmasCond'
        Source.Strings = (
          'begin'
          ''
          ' if (DataSet.FieldName('#39'nro_firma'#39').AsInteger<=0)'
          
            '    then raiseException(erCustomError,'#39'Debe ingresar el Nro. de ' +
            'Firma'#39');'
          ''
          ' if (Trim(DataSet.FieldName('#39'titulo'#39').AsString)='#39#39')'
          
            '    then raiseException(erCustomError,'#39'Debe ingresar el T'#237'tulo'#39')' +
            ';'
          ''
          'end.')
      end
      item
        TableName = 'TLegajosCond'
        Source.Strings = (
          'begin'
          '  if (DataSet.FieldName('#39'oid_legajo'#39').AsInteger=0)'
          
            '     then raiseException(erCustomError,'#39'Debe ingresar el Legajo'#39 +
            ');'
          'end.')
      end
      item
        TableName = 'TObsCodigSegunPtos'
        Source.Strings = (
          'begin'
          ''
          
            '  if (not (DataSet.FieldName('#39'puntaje_desde'#39').AsCurrency<=DataSe' +
            't.FieldName('#39'puntaje_hasta'#39').AsCurrency))'
          
            '     then raiseException(erCustomError,'#39'El puntaje desde debe se' +
            'r menor o igual al puntaje hasta'#39');'
          ''
          '  if (DataSet.FieldName('#39'puntaje_desde'#39').IsNull)'
          
            '      then raiseException(erCustomError,'#39'Debe ingresar el Puntaj' +
            'e desde'#39');'
          ''
          '  if (DataSet.FieldName('#39'puntaje_hasta'#39').IsNull)'
          
            '      then raiseException(erCustomError,'#39'Debe ingresar el Puntaj' +
            'e hasta'#39');'
          ''
          'end.')
      end>
    OnNuevoRegistro = <
      item
        TableName = 'TModeloEvalCab'
        Source.Strings = (
          'begin'
          '  DataSet.FieldName('#39'vigente'#39').AsBoolean := False;'
          'end.')
      end
      item
        TableName = 'TCondModEvalCab'
        Source.Strings = (
          'begin'
          '  TCondModEvalCab.FieldName('#39'oid_mod_eval_cab'#39').AsInteger :='
          
            '              TModeloEvalCab.FieldName('#39'oid_mod_eval_cab'#39').AsInt' +
            'eger;'
          '  TCondModEvalCab.FieldName('#39'activo'#39').AsBoolean := True;'
          ''
          '  altaClasifCondicion();'
          ''
          'end.')
      end
      item
        TableName = 'TCompetenciasCond'
        Source.Strings = (
          'begin'
          
            '  DataSet.FieldName('#39'oid_cond_mod'#39').AsInteger := TCondModEvalCab' +
            '.FieldName('#39'oid_cond_mod'#39').AsInteger;'
          '  DataSet.FieldName('#39'peso_competencia'#39').AsCurrency := 0;'
          '  DataSet.FieldName('#39'activo'#39').AsBoolean := True;  '
          'end.')
      end
      item
        TableName = 'TModeloEvalGrados'
        Source.Strings = (
          'begin'
          
            '  DataSet.FieldName('#39'oid_mod_eval_comp'#39').AsInteger := TCompetenc' +
            'iasCond.FieldName('#39'oid_mod_eval_comp'#39').AsInteger;'
          '  DataSet.FieldName('#39'activo'#39').AsBoolean := True;'
          'end.')
      end
      item
        TableName = 'TFirmasCond'
        Source.Strings = (
          'begin'
          
            '  DataSet.FieldName('#39'oid_cond_mod'#39').AsInteger := TCondModEvalCab' +
            '.FieldName('#39'oid_cond_mod'#39').AsInteger;'
          '  DataSet.FieldName('#39'activo'#39').AsBoolean := True;'
          'end.')
      end
      item
        TableName = 'TLegajosCond'
        Source.Strings = (
          'begin'
          
            '  DataSet.FieldName('#39'oid_cond_mod'#39').AsInteger := TCondModEvalCab' +
            '.FieldName('#39'oid_cond_mod'#39').AsInteger;'
          '  DataSet.FieldName('#39'activo'#39').AsBoolean := true;'
          'end.')
      end
      item
        TableName = 'TObsCodigSegunPtos'
        Source.Strings = (
          'begin'
          
            '  DataSet.FieldName('#39'oid_cond_mod'#39').AsInteger := TCondModEvalCab' +
            '.FieldName('#39'oid_cond_mod'#39').AsInteger;'
          '  DataSet.FieldName('#39'activo'#39').AsBoolean := True;'
          'end.')
      end
      item
        TableName = 'TObsCodigSegunPtos'
        Source.Strings = (
          'begin'
          
            '  DataSet.FieldName('#39'oid_cond_mod'#39').AsInteger := TCondModEvalCab' +
            '.FieldName('#39'oid_cond_mod'#39').AsInteger;'
          '  DataSet.FieldName('#39'activo'#39').AsBoolean := True;'
          'end.')
      end
      item
        TableName = 'TObsCodifEvalRango'
        Source.Strings = (
          'begin'
          
            '  DataSet.FieldName('#39'oid_mod_obs_codif'#39').AsInteger := TObsCodigS' +
            'egunPtos.FieldName('#39'oid_mod_obs_codif'#39').AsInteger;'
          '  DataSet.FieldName('#39'activo'#39').AsBoolean := True;'
          'end.')
      end>
    OnInicializar = <
      item
        Source.Strings = (
          'begin'
          '  TraerClasificadoresLegajo();'
          '  TraerValoresClasif();'
          '  TraerTipos();'
          'end.')
      end>
    OnAfterModificar = <
      item
        Source.Strings = (
          'begin'
          '  srnDBButtonEdit1.setEnable(false);'
          '  snDBEdit7.setEnable(false);'
          'end.')
      end>
    OnFormFunction = <
      item
        Source.Strings = (
          'procedure TraerCompetencia(codigo : string);'
          'begin'
          '  operacion.inicioOperacion();'
          '  operacion.setOper('#39'TraerCompetencia'#39');'
          '  operacion.AddAtribute('#39'codigo'#39',codigo);'
          '  operacion.execute();'
          'end;'
          ''
          'procedure TraerClasificadoresLegajo();'
          'begin'
          '  operacion.inicioOperacion();'
          '  operacion.setOper('#39'TraerClasifLegajos'#39');'
          ' operacion.execute();'
          'end;'
          ''
          'procedure altaClasifCondicion();'
          'begin'
          ''
          '  if (not TClasificadoresCond.IsEmpty()) then exit;'
          ''
          '  TClasificadoresLegajo.First;'
          '  while (not TClasificadoresLegajo.eof) do'
          '      begin'
          ''
          '      TClasificadoresCond.AppendRecord;'
          
            '      TClasificadoresCond.FieldName('#39'oid_cond_mod'#39').AsInteger :=' +
            ' TCondModEvalCab.FieldName('#39'oid_cond_mod'#39').AsInteger;'
          
            '      TClasificadoresCond.FieldName('#39'oid_clasificador'#39').AsIntege' +
            'r := TClasificadoresLegajo.FieldName('#39'oid_clasif_ent'#39').AsInteger' +
            ';'
          
            '      TClasificadoresCond.FieldName('#39'desc_clasificador'#39').AsStrin' +
            'g := TClasificadoresLegajo.FieldName('#39'descripcion'#39').AsString;'
          '      TClasificadoresCond.PostRecord;  '
          '         '
          '      TClasificadoresLegajo.next; '
          '      end;'
          ''
          '   if (not TValoresClasificadoresCond.IsEmpty)'
          '      then exit;'
          ''
          '   TValoresClasificadoresCond.desHabilitarAllEvents;'
          '   dxDBGridSN5.setDataSource(nil);'
          '  '
          '   try'
          ''
          '  '
          '   TValoresClasificadoresLegajo.First;'
          '   while (not TValoresClasificadoresLegajo.EOF) do'
          '       begin'
          ''
          '       TValoresClasificadoresCond.AppendRecord;'
          
            '       TValoresClasificadoresCond.FieldName('#39'oid_cond_mod'#39').AsIn' +
            'teger := TCondModEvalCab.FieldName('#39'oid_cond_mod'#39').AsInteger;'
          
            '       TValoresClasificadoresCond.FieldName('#39'oid_clasificador'#39').' +
            'AsInteger := TValoresClasificadoresLegajo.FieldName('#39'oid_clasifi' +
            'cador'#39').AsInteger;'
          
            '       TValoresClasificadoresCond.FieldName('#39'oid_val_clasif'#39').As' +
            'Integer := TValoresClasificadoresLegajo.FieldName('#39'oid_val_clasi' +
            'f'#39').AsInteger;'
          
            '       TValoresClasificadoresCond.FieldName('#39'cod_val_clasif'#39').As' +
            'String := TValoresClasificadoresLegajo.FieldName('#39'cod_val_clasif' +
            #39').AsString;'
          
            '       TValoresClasificadoresCond.FieldName('#39'desc_val_clasif'#39').A' +
            'sString := TValoresClasificadoresLegajo.FieldName('#39'desc_val_clas' +
            'if'#39').AsString;'
          
            '       TValoresClasificadoresCond.FieldName('#39'activo'#39').AsBoolean ' +
            ':= false;'
          '       TValoresClasificadoresCond.PostRecord;'
          ''
          '       TValoresClasificadoresLegajo.next;'
          '       end;'
          ''
          '   finally'
          ''
          '  TValoresClasificadoresCond.HabilitarAllEvents;'
          
            '  dxDBGridSN5.setDataSourceByName('#39'DSValoresClasificadoresCond'#39')' +
            ';'
          ''
          '  end;'
          ''
          ''
          ''
          ''
          'end;'
          ''
          'procedure TraerValoresClasif();'
          'begin'
          '  operacion.inicioOperacion();'
          '  operacion.setOper('#39'TraerValClasifLegEval'#39');'
          ' operacion.execute();'
          'end;'
          ''
          'procedure marcarRegistros();'
          'begin'
          ''
          '  dxDBGridSN4.setDataSource(nil);'
          '  dxDBGridSN5.setDataSource(nil);'
          ''
          ''
          '  try'
          ''
          '  TCondModEvalCab.marcarRegistrosComoModificados();'
          ''
          '  TCondModEvalCab.First;'
          '  while (not TCondModEvalCab.EOF) do'
          '         begin'
          ''
          '        TCompetenciasCond.marcarRegistrosComoModificados();'
          '        TClasificadoresCond.marcarRegistrosComoModificados();'
          '        TFirmasCond.marcarRegistrosComoModificados();'
          '        TLegajosCond.marcarRegistrosComoModificados();'
          '        TObsCodigSegunPtos.marcarRegistrosComoModificados();'
          ''
          '        TCompetenciasCond.first;'
          '        while (not TCompetenciasCond.EOF) do'
          '              begin'
          
            '              TModeloEvalGrados.marcarRegistrosComoModificados()' +
            ';'
          '              TCompetenciasCond.next;'
          '              end;'
          ''
          '       TClasificadoresCond.first;'
          '       while (not TClasificadoresCond.EOF) do'
          '           begin'
          ''
          '           TValoresClasificadoresCond.first;'
          '            while (not TValoresClasificadoresCond.EOF) do'
          '                      begin'
          ''
          
            '                      if (TValoresClasificadoresCond.FieldName('#39 +
            'activo'#39').AsBoolean)'
          '                          then begin'
          
            '                                  TValoresClasificadoresCond.set' +
            'RegistroComoModif();'
          '                                  end;'
          ''
          '                    TValoresClasificadoresCond.next;'
          ''
          '                    end;'
          ''
          '          TClasificadoresCond.next;'
          '          end;'
          ''
          '         TObsCodigSegunPtos.first;'
          '         while (not TObsCodigSegunPtos.EOF) do'
          '                   begin'
          
            '                  TObsCodifEvalRango.marcarRegistrosComoModifica' +
            'dos();'
          '                  TObsCodigSegunPtos.next;'
          '          end;'
          ''
          ''
          '        TCondModEvalCab.next;'
          '         end;'
          ''
          ''
          ''
          '  finally'
          ''
          '  dxDBGridSN4.setDataSourceByName('#39'DSClasifCond'#39');'
          
            '  dxDBGridSN5.setDataSourceByName('#39'DSValoresClasificadoresCond'#39')' +
            ';'
          ''
          '  end;'
          ''
          'end;'
          ''
          'procedure TraerCopiaModeloEval(Oid : integer);'
          'begin'
          '  operacion.InicioOperacion();'
          '  operacion.setOper('#39'CopiarModeloEvalRH'#39');'
          '  operacion.addAtribute('#39'oid_modelo'#39',IntToStr(Oid));'
          
            '  operacion.addAtribute('#39'oid_modelo_nuevo'#39',TModeloEvalCab.FieldN' +
            'ame('#39'oid_mod_eval_cab'#39').AsString);'
          '  operacion.execute();'
          ''
          '  marcarRegistros();'
          ''
          'end;'
          ''
          ''
          'procedure RecalcularPuntajes();'
          'begin'
          ''
          
            '  if (TModeloEvalCab.FieldName('#39'oid_mod_eval_cab'#39').AsInteger = 0' +
            ')'
          
            '      then raiseException(erCustomError,'#39'Debe seleccionar un mod' +
            'elo.'#39');'
          ''
          '  operacion.InicioOperacion();'
          '  operacion.setOper('#39'RecalcEvalRRHH'#39');'
          
            '  operacion.AddAtribute('#39'oid_modelo_eval'#39', TModeloEvalCab.FieldN' +
            'ame('#39'oid_mod_eval_cab'#39').AsString);'
          '  operacion.execute();'
          ''
          'end;'
          ''
          'procedure TraerTipos();'
          'begin'
          '  operacion.InicioOperacion();'
          '  operacion.setOper('#39'TraerTiposModEval'#39');'
          ' operacion.execute();'
          'end;')
      end>
    OnAfterNuevo = <
      item
        Source.Strings = (
          'begin'
          '  srnDBButtonEdit1.setEnable(true);'
          '  snDBEdit7.setEnable(true);'
          'end.')
      end>
    OnClickToolButton = <
      item
        ButtonName = 'snLabel1'
        Source.Strings = (
          'begin'
          '  TCompetenciasCond.next();'
          'end.')
      end
      item
        ButtonName = 'snLabel2'
        Source.Strings = (
          'begin'
          '  TCompetenciasCond.prior();'
          'end.')
      end
      item
        ButtonName = 'BotonRecalcularEvaluaciones'
        Source.Strings = (
          'begin'
          '  if (not DriverABM.isBrowse) then exit;'
          
            '  if (mensaje.question('#39'Desea recalcular las evaluaciones corres' +
            'pondientes a este modelo?'#39'))'
          '     then begin'
          '             RecalcularPuntajes();'
          '             mensaje.information('#39'Proceso finalizado.'#39'); '
          '             end;'
          'end.')
      end>
    OnClickButtonColumn = <
      item
        ColumnName = 'dxDBGridSN2DBBandedTableView1codigo_compe'
        Source.Strings = (
          'begin'
          '  HelpCompetencia.Mostrar();'
          'end.')
      end
      item
        ColumnName = 'cxGridDBTableView3cod_legajo_firma'
        Source.Strings = (
          'begin'
          '   HelpLegajos.mostrar();'
          'end.')
      end
      item
        ColumnName = 'cxGridDBTableView4cod_legajo'
        Source.Strings = (
          'begin'
          '  HelpLegajos1.Mostrar();'
          'end.')
      end
      item
        ColumnName = 'cxGridDBTableView6cod_obs_codif'
        Source.Strings = (
          'begin'
          '  HelpObsCodif.Mostrar();'
          'end.')
      end>
    Left = 283
    Top = 232
  end
  inherited SaveArchivo: TSaveDialog
    Left = 480
  end
  inherited ImprimirObjetoSeleccionado: TdxComponentPrinter
    Left = 216
    Top = 232
    inherited ImprimirObjetoSeleccionadodxComponentPrinterLink: TdxGridReportLink
      BuiltInReportLink = True
    end
  end
  inherited TTempVarForm: TsnTable
    Top = 296
  end
  inherited PopUp: TsnPopUp
    Left = 249
    Top = 232
  end
  inherited ImageListItemsPopUp: TImageList
    Left = 424
    Top = 139
  end
  inherited TDataSetOidObjSave: TsnTable
    Left = 552
    Top = 59
  end
  object HelpDefiniciones: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'rh.ModeloEvalCab'
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
        AnchoEnCaracteres = 20
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
        AnchoEnCaracteres = 20
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
    Titulo = 'Definici'#243'n de Evaluaciones'
    AnchoHelp = 600
    ActivarCache = False
    ShowBotonBuscar = False
    Left = 50
    Top = 28
  end
  object ValidadorDefinicion: TValidador
    Operacion = Operacion
    NickNameObjLog = 'rh.ModeloEvalCab'
    WhenRaiseException = teFound
    MensajeException = 'C'#243'digo de Definici'#243'n de Evaluaci'#243'n duplicado'
    NroQuery = 0
    Cache = False
    Left = 96
    Top = 107
  end
  object TCondModEvalCab: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'oid_cond_mod'
        DataType = ftInteger
      end
      item
        Name = 'oid_mod_eval_cab'
        DataType = ftInteger
      end
      item
        Name = 'orden'
        DataType = ftInteger
      end
      item
        Name = 'condicion'
        DataType = ftString
        Size = 4000
      end
      item
        Name = 'activo'
        DataType = ftBoolean
      end>
    IndexFieldNames = 'oid_mod_eval_cab'
    IndexDefs = <
      item
        Name = 'TCondModEvalCabIndex1'
        Fields = 'oid_mod_eval_cab;orden'
      end>
    RecalcOnFetch = False
    SortOptions = []
    PersistentBackup = False
    ProgressFlags = [mtpcLoad, mtpcSave, mtpcCopy]
    VersioningMode = mtvmAllSinceCheckPoint
    FilterOptions = []
    MasterFields = 'oid_mod_eval_cab'
    MasterSource = DSTModeloEvalCab
    Version = '4.08b'
    LanguageID = 0
    SortID = 0
    SubLanguageID = 1
    LocaleID = 1024
    MensajeValorDuplicadoIndice = 'Valor Duplicado'
    Left = 608
    Top = 100
    object TCondModEvalCaboid_cond_mod: TIntegerField
      FieldName = 'oid_cond_mod'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TCondModEvalCaboid_mod_eval_cab: TIntegerField
      FieldName = 'oid_mod_eval_cab'
    end
    object TCondModEvalCaborden: TIntegerField
      FieldName = 'orden'
    end
    object TCondModEvalCabcondicion: TStringField
      FieldName = 'condicion'
      Size = 4000
    end
    object TCondModEvalCabactivo: TBooleanField
      FieldName = 'activo'
    end
  end
  object DSTCondModEvalCab: TDataSource
    DataSet = TCondModEvalCab
    Left = 640
    Top = 100
  end
  object TCompetenciasCond: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'oid_mod_eval_comp'
        DataType = ftInteger
      end
      item
        Name = 'oid_cond_mod'
        DataType = ftInteger
      end
      item
        Name = 'oid_competencia'
        DataType = ftInteger
      end
      item
        Name = 'orden'
        DataType = ftInteger
      end
      item
        Name = 'codigo_compe'
        DataType = ftString
        Size = 20
      end
      item
        Name = 'titulo_compe'
        DataType = ftString
        Size = 100
      end
      item
        Name = 'definicion_compe'
        DataType = ftString
        Size = 4000
      end
      item
        Name = 'peso_competencia'
        DataType = ftCurrency
      end
      item
        Name = 'activo'
        DataType = ftBoolean
      end>
    IndexFieldNames = 'oid_cond_mod'
    IndexDefs = <
      item
        Name = 'TCompetenciasCondIndex1'
        Fields = 'oid_cond_mod'
      end
      item
        Name = 'TCompetenciasCondIndex2'
        Fields = 'oid_cond_mod;codigo_compe'
        Options = [ixUnique]
      end>
    RecalcOnFetch = False
    SortOptions = []
    PersistentBackup = False
    ProgressFlags = [mtpcLoad, mtpcSave, mtpcCopy]
    VersioningMode = mtvmAllSinceCheckPoint
    FilterOptions = []
    MasterFields = 'oid_cond_mod'
    MasterSource = DSTCondModEvalCab
    Version = '4.08b'
    LanguageID = 0
    SortID = 0
    SubLanguageID = 1
    LocaleID = 1024
    MensajeValorDuplicadoIndice = 'C'#243'digo de Competencia Duplicado'
    Left = 536
    Top = 140
    object TCompetenciasCondoid_mod_eval_comp: TIntegerField
      FieldName = 'oid_mod_eval_comp'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TCompetenciasCondoid_cond_mod: TIntegerField
      FieldName = 'oid_cond_mod'
    end
    object TCompetenciasCondoid_competencia: TIntegerField
      FieldName = 'oid_competencia'
    end
    object TCompetenciasCondorden: TIntegerField
      FieldName = 'orden'
    end
    object TCompetenciasCondcodigo_compe: TStringField
      FieldName = 'codigo_compe'
    end
    object TCompetenciasCondtitulo_compe: TStringField
      FieldName = 'titulo_compe'
      Size = 100
    end
    object TCompetenciasConddefinicion_compe: TStringField
      FieldName = 'definicion_compe'
      Size = 4000
    end
    object TCompetenciasCondpeso_competencia: TCurrencyField
      FieldName = 'peso_competencia'
      DisplayFormat = '###,###,##0.##'
    end
    object TCompetenciasCondactivo: TBooleanField
      FieldName = 'activo'
    end
  end
  object DSCompetenciasCond: TDataSource
    DataSet = TCompetenciasCond
    Left = 568
    Top = 140
  end
  object HelpCompetencia: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'rh.Competencia'
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
        AsignarACampo = TCompetenciasCondcodigo_compe
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
    Titulo = 'Competencias'
    AnchoHelp = 600
    ActivarCache = False
    ShowBotonBuscar = False
    Left = 250
    Top = 273
  end
  object ValidadorCompetencia: TValidador
    Operacion = Operacion
    NickNameObjLog = 'rh.Competencia'
    MensajeException = 'C'#243'digo de Competencia Inexistente'
    NroQuery = 0
    Cache = True
    Left = 286
    Top = 273
  end
  object TCompetencia: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'oid_competencia'
        DataType = ftInteger
      end
      item
        Name = 'codigo'
        DataType = ftString
        Size = 20
      end
      item
        Name = 'titulo'
        DataType = ftString
        Size = 100
      end
      item
        Name = 'activo'
        DataType = ftBoolean
      end
      item
        Name = 'definicion'
        DataType = ftString
        Size = 4000
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
    Left = 251
    Top = 315
    object TCompetenciaoid_competencia: TIntegerField
      FieldName = 'oid_competencia'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TCompetenciacodigo: TStringField
      DisplayWidth = 20
      FieldName = 'codigo'
    end
    object TCompetenciatitulo: TStringField
      FieldName = 'titulo'
      Size = 100
    end
    object TCompetenciaactivo: TBooleanField
      DefaultExpression = '1'
      FieldName = 'activo'
    end
    object TCompetenciadefinicion: TStringField
      FieldName = 'definicion'
      Size = 4000
    end
  end
  object DSTModeloEvalGrados: TDataSource
    DataSet = TModeloEvalGrados
    Left = 541
    Top = 183
  end
  object cxStyleRepository1: TcxStyleRepository
    PixelsPerInch = 96
    object cxStyle1: TcxStyle
      AssignedValues = [svFont]
      Font.Charset = ANSI_CHARSET
      Font.Color = clWindowText
      Font.Height = -11
      Font.Name = 'Verdana'
      Font.Style = []
    end
  end
  object TModeloEvalGrados: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'oid_mov_eva_grados'
        DataType = ftInteger
      end
      item
        Name = 'oid_mod_eval_comp'
        DataType = ftInteger
      end
      item
        Name = 'nro_grado'
        DataType = ftInteger
      end
      item
        Name = 'desc_grados'
        DataType = ftString
        Size = 3990
      end
      item
        Name = 'peso'
        DataType = ftCurrency
      end
      item
        Name = 'activo'
        DataType = ftBoolean
      end>
    IndexFieldNames = 'oid_mod_eval_comp;nro_grado'
    IndexDefs = <
      item
        Name = 'TModeloEvalGradosIndex1'
        Fields = 'oid_mod_eval_comp;nro_grado'
      end>
    RecalcOnFetch = False
    SortOptions = []
    PersistentBackup = False
    ProgressFlags = [mtpcLoad, mtpcSave, mtpcCopy]
    VersioningMode = mtvmAllSinceCheckPoint
    FilterOptions = []
    MasterFields = 'oid_mod_eval_comp'
    MasterSource = DSCompetenciasCond
    Version = '4.08b'
    LanguageID = 0
    SortID = 0
    SubLanguageID = 1
    LocaleID = 1024
    MensajeValorDuplicadoIndice = 'Valor Duplicado'
    Left = 509
    Top = 183
    object TModeloEvalGradosoid_mov_eva_grados: TIntegerField
      FieldName = 'oid_mov_eva_grados'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TModeloEvalGradosoid_mod_eval_comp: TIntegerField
      FieldName = 'oid_mod_eval_comp'
    end
    object TModeloEvalGradosnro_grado: TIntegerField
      FieldName = 'nro_grado'
    end
    object TModeloEvalGradosdesc_grados: TStringField
      FieldName = 'desc_grados'
      Size = 3990
    end
    object TModeloEvalGradospeso: TCurrencyField
      FieldName = 'peso'
      DisplayFormat = '###,###,###.##'
    end
    object TModeloEvalGradosactivo: TBooleanField
      FieldName = 'activo'
    end
  end
  object TClasificadoresLegajo: TsnTable
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
    Left = 138
    Top = 466
    object TClasificadoresLegajooid_clasif_ent: TIntegerField
      FieldName = 'oid_clasif_ent'
    end
    object TClasificadoresLegajocodigo: TStringField
      FieldName = 'codigo'
      Size = 50
    end
    object TClasificadoresLegajodescripcion: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
    object TClasificadoresLegajonickname: TStringField
      FieldName = 'nickname'
      Size = 50
    end
    object TClasificadoresLegajoobligatorio: TBooleanField
      FieldName = 'obligatorio'
    end
  end
  object TClasificadoresCond: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'secu'
        DataType = ftInteger
      end
      item
        Name = 'oid_cond_mod'
        DataType = ftInteger
      end
      item
        Name = 'oid_clasificador'
        DataType = ftInteger
      end
      item
        Name = 'desc_clasificador'
        DataType = ftString
        Size = 100
      end>
    IndexFieldNames = 'oid_cond_mod'
    IndexDefs = <
      item
        Name = 'TClasificadoresCondIndex1'
        Fields = 'oid_cond_mod'
      end>
    RecalcOnFetch = False
    SortOptions = []
    PersistentBackup = False
    ProgressFlags = [mtpcLoad, mtpcSave, mtpcCopy]
    VersioningMode = mtvmAllSinceCheckPoint
    FilterOptions = []
    MasterFields = 'oid_cond_mod'
    MasterSource = DSTCondModEvalCab
    Version = '4.08b'
    LanguageID = 0
    SortID = 0
    SubLanguageID = 1
    LocaleID = 1024
    MensajeValorDuplicadoIndice = 'Valor Duplicado'
    Left = 616
    Top = 140
    object TClasificadoresCondsecu: TIntegerField
      FieldName = 'secu'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TClasificadoresCondoid_cond_mod: TIntegerField
      FieldName = 'oid_cond_mod'
    end
    object TClasificadoresCondoid_clasificador: TIntegerField
      FieldName = 'oid_clasificador'
    end
    object TClasificadoresConddesc_clasificador: TStringField
      FieldName = 'desc_clasificador'
      Size = 100
    end
  end
  object DSClasifCond: TDataSource
    DataSet = TClasificadoresCond
    Left = 648
    Top = 140
  end
  object TValoresClasificadoresLegajo: TsnTable
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
    Left = 138
    Top = 498
    object TValoresClasificadoresLegajooid_val_clasif: TIntegerField
      FieldName = 'oid_val_clasif'
    end
    object TValoresClasificadoresLegajooid_clasificador: TIntegerField
      FieldName = 'oid_clasificador'
    end
    object TValoresClasificadoresLegajocod_val_clasif: TStringField
      FieldName = 'cod_val_clasif'
      Size = 50
    end
    object TValoresClasificadoresLegajodesc_val_clasif: TStringField
      FieldName = 'desc_val_clasif'
      Size = 100
    end
  end
  object TValoresClasificadoresCond: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'secu'
        DataType = ftInteger
      end
      item
        Name = 'oid_cond_mod'
        DataType = ftInteger
      end
      item
        Name = 'oid_clasificador'
        DataType = ftInteger
      end
      item
        Name = 'oid_val_clasif'
        DataType = ftInteger
      end
      item
        Name = 'cod_val_clasif'
        DataType = ftString
        Size = 50
      end
      item
        Name = 'desc_val_clasif'
        DataType = ftString
        Size = 100
      end
      item
        Name = 'activo'
        DataType = ftBoolean
      end>
    IndexFieldNames = 'oid_cond_mod;oid_clasificador'
    IndexDefs = <
      item
        Name = 'TValoresClasificadoresCondIndex1'
        Fields = 'oid_cond_mod;oid_clasificador'
      end>
    RecalcOnFetch = False
    SortOptions = []
    PersistentBackup = False
    ProgressFlags = [mtpcLoad, mtpcSave, mtpcCopy]
    VersioningMode = mtvmAllSinceCheckPoint
    FilterOptions = []
    MasterFields = 'oid_cond_mod;oid_clasificador'
    MasterSource = DSClasifCond
    Version = '4.08b'
    LanguageID = 0
    SortID = 0
    SubLanguageID = 1
    LocaleID = 1024
    MensajeValorDuplicadoIndice = 'Valor Duplicado'
    Left = 613
    Top = 183
    object TValoresClasificadoresCondsecu: TIntegerField
      FieldName = 'secu'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TValoresClasificadoresCondoid_cond_mod: TIntegerField
      FieldName = 'oid_cond_mod'
    end
    object TValoresClasificadoresCondoid_clasificador: TIntegerField
      FieldName = 'oid_clasificador'
    end
    object TValoresClasificadoresCondoid_val_clasif: TIntegerField
      FieldName = 'oid_val_clasif'
    end
    object TValoresClasificadoresCondcod_val_clasif: TStringField
      FieldName = 'cod_val_clasif'
      Size = 50
    end
    object TValoresClasificadoresConddesc_val_clasif: TStringField
      FieldName = 'desc_val_clasif'
      Size = 100
    end
    object TValoresClasificadoresCondactivo: TBooleanField
      FieldName = 'activo'
    end
  end
  object DSValoresClasificadoresCond: TDataSource
    DataSet = TValoresClasificadoresCond
    Left = 645
    Top = 183
  end
  object TFirmasCond: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'oid_mov_eval_firm'
        DataType = ftInteger
      end
      item
        Name = 'oid_cond_mod'
        DataType = ftInteger
      end
      item
        Name = 'nro_firma'
        DataType = ftInteger
      end
      item
        Name = 'titulo'
        DataType = ftString
        Size = 100
      end
      item
        Name = 'oid_legajo_firma'
        DataType = ftInteger
      end
      item
        Name = 'cod_legajo_firma'
        DataType = ftString
        Size = 50
      end
      item
        Name = 'desc_legajo_firma'
        DataType = ftString
        Size = 100
      end
      item
        Name = 'activo'
        DataType = ftBoolean
      end>
    IndexFieldNames = 'oid_cond_mod;nro_firma'
    IndexDefs = <
      item
        Name = 'TFirmasCondIndex1'
        Fields = 'oid_cond_mod;nro_firma'
      end>
    RecalcOnFetch = False
    SortOptions = []
    PersistentBackup = False
    ProgressFlags = [mtpcLoad, mtpcSave, mtpcCopy]
    VersioningMode = mtvmAllSinceCheckPoint
    FilterOptions = []
    MasterFields = 'oid_cond_mod'
    MasterSource = DSTCondModEvalCab
    Version = '4.08b'
    LanguageID = 0
    SortID = 0
    SubLanguageID = 1
    LocaleID = 1024
    MensajeValorDuplicadoIndice = 'Valor Duplicado'
    Left = 696
    Top = 140
    object TFirmasCondoid_mov_eval_firm: TIntegerField
      FieldName = 'oid_mov_eval_firm'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TFirmasCondoid_cond_mod: TIntegerField
      FieldName = 'oid_cond_mod'
    end
    object TFirmasCondnro_firma: TIntegerField
      FieldName = 'nro_firma'
    end
    object TFirmasCondtitulo: TStringField
      FieldName = 'titulo'
      Size = 100
    end
    object TFirmasCondoid_legajo_firma: TIntegerField
      FieldName = 'oid_legajo_firma'
    end
    object TFirmasCondcod_legajo_firma: TStringField
      FieldName = 'cod_legajo_firma'
      Size = 50
    end
    object TFirmasConddesc_legajo_firma: TStringField
      FieldName = 'desc_legajo_firma'
      Size = 100
    end
    object TFirmasCondactivo: TBooleanField
      FieldName = 'activo'
    end
  end
  object DSFirmasCond: TDataSource
    DataSet = TFirmasCond
    Left = 728
    Top = 140
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
        Longitud = 50
        Visible = True
        KeyField = False
        AnchoEnCaracteres = 50
        ActivarFiltro = True
        Sorted = scUp
      end
      item
        Titulo = 'C'#243'digo'
        FieldName = 'codigo'
        Tipo = ftString
        Longitud = 50
        Visible = True
        AsignarACampo = TFirmasCondcod_legajo_firma
        KeyField = False
        AnchoEnCaracteres = 50
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
    Left = 530
    Top = 505
  end
  object ValidadorLegajo: TValidador
    Operacion = Operacion
    NickNameObjLog = 'su.Legajo'
    MensajeException = 'C'#243'digo de Legajo Inexistente'
    CampoOID = TFirmasCondoid_legajo_firma
    CampoDescripcion = TFirmasConddesc_legajo_firma
    NroQuery = 0
    Cache = True
    Left = 566
    Top = 505
  end
  object TLegajosCond: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'oid_leg_cond_mod'
        DataType = ftInteger
      end
      item
        Name = 'secu'
        DataType = ftInteger
      end
      item
        Name = 'oid_legajo'
        DataType = ftInteger
      end
      item
        Name = 'oid_cond_mod'
        DataType = ftInteger
      end
      item
        Name = 'activo'
        DataType = ftBoolean
      end>
    IndexFieldNames = 'oid_cond_mod;secu'
    IndexDefs = <
      item
        Name = 'TLegajosCondIndex1'
        Fields = 'oid_cond_mod;secu'
      end>
    RecalcOnFetch = False
    SortOptions = []
    PersistentBackup = False
    ProgressFlags = [mtpcLoad, mtpcSave, mtpcCopy]
    VersioningMode = mtvmAllSinceCheckPoint
    FilterOptions = []
    MasterFields = 'oid_cond_mod'
    MasterSource = DSTCondModEvalCab
    Version = '4.08b'
    LanguageID = 0
    SortID = 0
    SubLanguageID = 1
    LocaleID = 1024
    MensajeValorDuplicadoIndice = 'Valor Duplicado'
    Left = 768
    Top = 140
    object TLegajosCondoid_leg_cond_mod: TIntegerField
      FieldName = 'oid_leg_cond_mod'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TLegajosCondsecu: TIntegerField
      AutoGenerateValue = arAutoInc
      FieldName = 'secu'
    end
    object TLegajosCondoid_legajo: TIntegerField
      FieldName = 'oid_legajo'
    end
    object TLegajosCondoid_cond_mod: TIntegerField
      FieldName = 'oid_cond_mod'
    end
    object TLegajosCondcod_legajo: TStringField
      FieldName = 'cod_legajo'
      Size = 50
    end
    object TLegajosConddesc_legajo: TStringField
      FieldName = 'desc_legajo'
      Size = 100
    end
    object TLegajosCondactivo: TBooleanField
      FieldName = 'activo'
    end
  end
  object DSTLegajosCond: TDataSource
    DataSet = TLegajosCond
    Left = 800
    Top = 140
  end
  object HelpLegajos1: TsnHelp
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
        Longitud = 50
        Visible = True
        KeyField = False
        AnchoEnCaracteres = 50
        ActivarFiltro = True
        Sorted = scUp
      end
      item
        Titulo = 'C'#243'digo'
        FieldName = 'codigo'
        Tipo = ftString
        Longitud = 50
        Visible = True
        AsignarACampo = TLegajosCondcod_legajo
        KeyField = False
        AnchoEnCaracteres = 50
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
    Left = 530
    Top = 542
  end
  object ValidadorLegajo1: TValidador
    Operacion = Operacion
    NickNameObjLog = 'su.Legajo'
    MensajeException = 'C'#243'digo de Legajo Inexistente'
    CampoOID = TLegajosCondoid_legajo
    CampoDescripcion = TLegajosConddesc_legajo
    NroQuery = 0
    Cache = True
    Left = 566
    Top = 542
  end
  object TObsCodigSegunPtos: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'oid_mod_obs_codif'
        DataType = ftInteger
      end
      item
        Name = 'oid_cond_mod'
        DataType = ftInteger
      end
      item
        Name = 'puntaje_desde'
        DataType = ftCurrency
      end
      item
        Name = 'puntaje_hasta'
        DataType = ftCurrency
      end
      item
        Name = 'activo'
        DataType = ftBoolean
      end>
    IndexFieldNames = 'oid_cond_mod;puntaje_desde'
    IndexDefs = <
      item
        Name = 'TObsCodigSegunPtosIndex1'
        Fields = 'oid_cond_mod;puntaje_desde'
      end>
    RecalcOnFetch = False
    SortOptions = []
    PersistentBackup = False
    ProgressFlags = [mtpcLoad, mtpcSave, mtpcCopy]
    VersioningMode = mtvmAllSinceCheckPoint
    FilterOptions = []
    MasterFields = 'oid_cond_mod'
    MasterSource = DSTCondModEvalCab
    Version = '4.08b'
    LanguageID = 0
    SortID = 0
    SubLanguageID = 1
    LocaleID = 1024
    MensajeValorDuplicadoIndice = 'Valor Duplicado'
    Left = 840
    Top = 140
    object TObsCodigSegunPtosoid_mod_obs_codif: TIntegerField
      FieldName = 'oid_mod_obs_codif'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TObsCodigSegunPtosoid_cond_mod: TIntegerField
      FieldName = 'oid_cond_mod'
    end
    object TObsCodigSegunPtospuntaje_desde: TCurrencyField
      FieldName = 'puntaje_desde'
      DisplayFormat = '###,###,##0.##'
    end
    object TObsCodigSegunPtospuntaje_hasta: TCurrencyField
      FieldName = 'puntaje_hasta'
      DisplayFormat = '###,###,##0.##'
    end
    object TObsCodigSegunPtosactivo: TBooleanField
      FieldName = 'activo'
    end
  end
  object DSTObsCodigSegunPtos: TDataSource
    DataSet = TObsCodigSegunPtos
    Left = 872
    Top = 140
  end
  object TObsCodifEvalRango: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'oid_mod_obs_det'
        DataType = ftInteger
      end
      item
        Name = 'orden'
        DataType = ftInteger
      end
      item
        Name = 'oid_obs_codif'
        DataType = ftInteger
      end
      item
        Name = 'oid_mod_obs_codif'
        DataType = ftInteger
      end
      item
        Name = 'descripcion'
        DataType = ftString
        Size = 4000
      end
      item
        Name = 'activo'
        DataType = ftBoolean
      end>
    IndexFieldNames = 'oid_mod_obs_codif'
    IndexDefs = <
      item
        Name = 'TObsCodifEvalRangoIndex1'
        Fields = 'oid_mod_obs_codif'
      end>
    RecalcOnFetch = False
    SortOptions = []
    PersistentBackup = False
    ProgressFlags = [mtpcLoad, mtpcSave, mtpcCopy]
    VersioningMode = mtvmAllSinceCheckPoint
    FilterOptions = []
    MasterFields = 'oid_mod_obs_codif'
    MasterSource = DSTObsCodigSegunPtos
    Version = '4.08b'
    LanguageID = 0
    SortID = 0
    SubLanguageID = 1
    LocaleID = 1024
    MensajeValorDuplicadoIndice = 'Valor Duplicado'
    Left = 837
    Top = 183
    object TObsCodifEvalRangooid_mod_obs_det: TIntegerField
      FieldName = 'oid_mod_obs_det'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TObsCodifEvalRangooid_mod_obs_codif: TIntegerField
      FieldName = 'oid_mod_obs_codif'
    end
    object TObsCodifEvalRangoorden: TIntegerField
      FieldName = 'orden'
    end
    object TObsCodifEvalRangooid_obs_codif: TIntegerField
      FieldName = 'oid_obs_codif'
    end
    object TObsCodifEvalRangocod_obs_codif: TStringField
      FieldName = 'cod_obs_codif'
    end
    object TObsCodifEvalRangodescripcion: TMemoField
      FieldName = 'descripcion'
      BlobType = ftMemo
      Size = 4000
    end
    object TObsCodifEvalRangoactivo: TBooleanField
      FieldName = 'activo'
    end
  end
  object DSTObsCodifEvalRango: TDataSource
    DataSet = TObsCodifEvalRango
    Left = 869
    Top = 183
  end
  object HelpObsCodif: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'rh.ObsCodifEvalRH'
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
        Longitud = 50
        Visible = True
        KeyField = False
        AnchoEnCaracteres = 50
        ActivarFiltro = True
        Sorted = scUp
      end
      item
        Titulo = 'C'#243'digo'
        FieldName = 'codigo'
        Tipo = ftString
        Longitud = 50
        Visible = True
        AsignarACampo = TObsCodifEvalRangocod_obs_codif
        KeyField = False
        AnchoEnCaracteres = 50
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
    Titulo = 'Observaciones Codificadas'
    AnchoHelp = 600
    ActivarCache = False
    ShowBotonBuscar = False
    Left = 530
    Top = 578
  end
  object ValidadorObsCodif: TValidador
    Operacion = Operacion
    NickNameObjLog = 'rh.ObsCodifEvalRH'
    MensajeException = 'C'#243'digo de Observaci'#243'n Codificada Inexistente'
    CampoOID = TObsCodifEvalRangooid_obs_codif
    CampoDescripcion = TObsCodifEvalRangodescripcion
    NroQuery = 0
    Cache = True
    Left = 566
    Top = 578
  end
  object HelpModEval: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'rh.ModeloEvalCab'
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
        Longitud = 50
        Visible = True
        AsignarACampo = TModeloEvalCabcod_armar_en_base_a
        KeyField = False
        AnchoEnCaracteres = 50
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
    Titulo = 'Modelos de Evaluaciones'
    AnchoHelp = 600
    ActivarCache = False
    ShowBotonBuscar = False
    Left = 250
    Top = 354
  end
  object ValidadorModEval: TValidador
    Operacion = Operacion
    NickNameObjLog = 'rh.ModeloEvalCab'
    MensajeException = 'C'#243'digo de Modelo de Evaluaci'#243'n Inexistente'
    CampoOID = TModeloEvalCaboid_armar_en_base_a
    CampoDescripcion = TModeloEvalCabdesc_armar_en_base_a
    NroQuery = 0
    Cache = True
    Left = 286
    Top = 354
  end
  object TGradoCompetencia: TsnTable
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
    Left = 381
    Top = 464
    object TGradoCompetenciaoid_grado_compe: TIntegerField
      FieldName = 'oid_grado_compe'
    end
    object TGradoCompetenciaoid_competencia: TIntegerField
      FieldName = 'oid_competencia'
    end
    object TGradoCompetencianro_grado: TIntegerField
      FieldName = 'nro_grado'
    end
    object TGradoCompetenciadesc_grados: TStringField
      FieldName = 'desc_grados'
      Size = 4000
    end
    object TGradoCompetenciapeso_tentativo: TCurrencyField
      FieldName = 'peso_tentativo'
    end
    object TGradoCompetenciaactivo: TBooleanField
      FieldName = 'activo'
    end
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
    Left = 773
    Top = 480
    object TTiposModEvalcodigo: TStringField
      FieldName = 'codigo'
      Size = 50
    end
    object TTiposModEvaldescripcion: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
  end
  object DSTipoModelosEval: TDataSource
    DataSet = TTiposModEval
    Left = 813
    Top = 480
  end
end
