inherited FConfAlgoCacheo: TFConfAlgoCacheo
  Left = 61
  Top = 106
  Width = 758
  Height = 504
  Caption = 'Configuraci'#243'n Algoritmo de Cacheo'
  PixelsPerInch = 96
  TextHeight = 13
  inherited PForm: TPanel
    Width = 750
    Height = 470
    inherited PPie: TPanel
      Top = 449
      Width = 750
      inherited StatusBarABM: TStatusBar
        Left = 645
      end
      inherited StatusBar2: TStatusBar
        Width = 645
      end
    end
    inherited PMenu: TPanel
      Width = 750
      inherited ImagenEliminar: TImagenEstado
        DataField = 'activo'
        DataSource = DSTAlgoritmoCacheo
        ValorEstadoVisible = 'True'
      end
      inherited ImagenRehabilitar: TImagenEstado
        DataField = 'activo'
        DataSource = DSTAlgoritmoCacheo
        ValorEstadoVisible = 'False'
      end
      inherited ImagenBuscar: TImagenHelpObjNeg
        Help = HelpAlgoCacheo
      end
      inherited ImagenSiguiente: TImagenHelpObjNeg
        Help = HelpAlgoCacheo
      end
      inherited ImagenAnterior: TImagenHelpObjNeg
        Help = HelpAlgoCacheo
      end
      inherited Panel2: TPanel
        Left = 709
      end
      inherited PanelEstadoON: TPanelEstado
        DataField = 'activo'
        DataSource = DSTAlgoritmoCacheo
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
      Width = 750
    end
    inherited PCabecera: TPanel
      Width = 750
      Height = 100
      object Label1: TLabel
        Left = 32
        Top = 16
        Width = 33
        Height = 13
        Caption = 'C'#243'digo'
      end
      object Label2: TLabel
        Left = 32
        Top = 48
        Width = 56
        Height = 13
        Caption = 'Descripci'#243'n'
      end
      object DBECodigo: TsnDBEdit
        Left = 148
        Top = 12
        DataBinding.DataField = 'codigo'
        DataBinding.DataSource = DSTAlgoritmoCacheo
        Properties.CharCase = ecUpperCase
        Properties.MaxLength = 20
        Style.BorderColor = clWindowFrame
        Style.Shadow = False
        TabOrder = 0
        Width = 133
      end
      object snDBEdit1: TsnDBEdit
        Left = 148
        Top = 44
        DataBinding.DataField = 'descripcion'
        DataBinding.DataSource = DSTAlgoritmoCacheo
        Properties.MaxLength = 50
        Style.BorderColor = clWindowFrame
        Style.Shadow = False
        TabOrder = 1
        Width = 429
      end
      object snDBCheckEdit1: TsnDBCheckEdit
        Left = 40
        Top = 72
        Caption = 'Lunes'
        DataBinding.DataField = 'lunes'
        DataBinding.DataSource = DSTAlgoritmoCacheo
        TabOrder = 2
        Width = 57
      end
      object snDBCheckEdit2: TsnDBCheckEdit
        Left = 112
        Top = 71
        Caption = 'Martes'
        DataBinding.DataField = 'martes'
        DataBinding.DataSource = DSTAlgoritmoCacheo
        TabOrder = 3
        Width = 57
      end
      object snDBCheckEdit3: TsnDBCheckEdit
        Left = 184
        Top = 71
        Caption = 'Mi'#233'rcoles'
        DataBinding.DataField = 'miercoles'
        DataBinding.DataSource = DSTAlgoritmoCacheo
        TabOrder = 4
        Width = 81
      end
      object snDBCheckEdit4: TsnDBCheckEdit
        Left = 272
        Top = 71
        Caption = 'Jueves'
        DataBinding.DataField = 'jueves'
        DataBinding.DataSource = DSTAlgoritmoCacheo
        TabOrder = 5
        Width = 73
      end
      object snDBCheckEdit5: TsnDBCheckEdit
        Left = 344
        Top = 71
        Caption = 'Viernes'
        DataBinding.DataField = 'viernes'
        DataBinding.DataSource = DSTAlgoritmoCacheo
        TabOrder = 6
        Width = 81
      end
      object snDBCheckEdit6: TsnDBCheckEdit
        Left = 416
        Top = 71
        Caption = 'S'#225'bado'
        DataBinding.DataField = 'sabado'
        DataBinding.DataSource = DSTAlgoritmoCacheo
        TabOrder = 7
        Width = 81
      end
      object snDBCheckEdit7: TsnDBCheckEdit
        Left = 496
        Top = 71
        Caption = 'Domingo'
        DataBinding.DataField = 'domingo'
        DataBinding.DataSource = DSTAlgoritmoCacheo
        TabOrder = 8
        Width = 81
      end
    end
    inherited PCuerpo: TPanel
      Top = 152
      Width = 750
      Height = 297
      BorderWidth = 5
      object PageControlSN1: TPageControlSN
        Left = 5
        Top = 5
        Width = 740
        Height = 287
        ActivePage = TabSheet1
        Align = alClient
        TabOrder = 0
        object TabSheet1: TTabSheet
          Caption = 'Filtro B'#225'sico de Legajos'
          object Splitter1: TSplitter
            Left = 364
            Top = 44
            Height = 215
          end
          object Panel1: TPanel
            Left = 0
            Top = 0
            Width = 732
            Height = 44
            Align = alTop
            BevelOuter = bvNone
            Color = clWindow
            TabOrder = 0
            object Label3: TLabel
              Left = 8
              Top = 9
              Width = 77
              Height = 13
              Caption = 'Filtro de Legajos'
            end
            object snLabel1: TsnLabel
              Left = 8
              Top = 32
              Width = 118
              Height = 13
              Caption = 'Condiciones de Inclusi'#243'n'
              Font.Charset = DEFAULT_CHARSET
              Font.Color = clNavy
              Font.Height = -11
              Font.Name = 'MS Sans Serif'
              Font.Style = []
              ParentFont = False
            end
            object snLabel2: TsnLabel
              Left = 374
              Top = 31
              Width = 121
              Height = 13
              Caption = 'Condiciones de Exclusi'#243'n'
              Font.Charset = DEFAULT_CHARSET
              Font.Color = clNavy
              Font.Height = -11
              Font.Name = 'MS Sans Serif'
              Font.Style = []
              ParentFont = False
            end
            object snDBLookup1: TsnDBLookup
              Left = 108
              Top = 5
              DataBinding.DataField = 'filtro_legajo'
              DataBinding.DataSource = DSTAlgoritmoCacheo
              Properties.KeyFieldNames = 'codigo'
              Properties.ListColumns = <
                item
                  FieldName = 'descripcion'
                end>
              Properties.ListOptions.ShowHeader = False
              Properties.ListSource = DSFiltrosLegajos
              TabOrder = 0
              Width = 197
            end
          end
          object Panel3: TPanel
            Left = 0
            Top = 44
            Width = 364
            Height = 215
            Align = alLeft
            BiDiMode = bdLeftToRight
            BorderWidth = 5
            Color = clWindow
            ParentBiDiMode = False
            TabOrder = 1
            object dxDBGridSN1: TdxDBGridSN
              Left = 6
              Top = 6
              Width = 352
              Height = 203
              Align = alClient
              TabOrder = 0
              LookAndFeel.Kind = lfFlat
              CriteriosPintarCelda = <>
              object dxDBGridSN1DBTableView1: TcxGridDBTableView
                NavigatorButtons.ConfirmDelete = False
                NavigatorButtons.PriorPage.Visible = False
                NavigatorButtons.Prior.Visible = False
                NavigatorButtons.Next.Visible = False
                NavigatorButtons.NextPage.Visible = False
                NavigatorButtons.Insert.Visible = True
                NavigatorButtons.Append.Visible = False
                NavigatorButtons.Delete.Visible = False
                NavigatorButtons.Edit.Visible = False
                NavigatorButtons.Post.Visible = False
                NavigatorButtons.Cancel.Visible = False
                NavigatorButtons.Refresh.Visible = False
                NavigatorButtons.SaveBookmark.Visible = False
                NavigatorButtons.GotoBookmark.Visible = False
                NavigatorButtons.Filter.Visible = False
                DataController.DataSource = DSTAlgoCacheoClasifInc
                DataController.Options = [dcoAssignGroupingValues, dcoAssignMasterDetailKeys, dcoSaveExpanding, dcoGroupsAlwaysExpanded, dcoInsertOnNewItemRowFocusing]
                DataController.Summary.DefaultGroupSummaryItems = <>
                DataController.Summary.FooterSummaryItems = <>
                DataController.Summary.SummaryGroups = <>
                OptionsBehavior.AlwaysShowEditor = True
                OptionsBehavior.FocusCellOnTab = True
                OptionsBehavior.FocusFirstCellOnNewRecord = True
                OptionsBehavior.GoToNextCellOnEnter = True
                OptionsBehavior.FocusCellOnCycle = True
                OptionsData.Appending = True
                OptionsData.Deleting = False
                OptionsSelection.InvertSelect = False
                OptionsView.Navigator = True
                OptionsView.GroupByBox = False
                object dxDBGridSN1DBTableView1oid_clasificador: TcxGridDBColumn
                  Caption = 'Clasificador'
                  DataBinding.FieldName = 'oid_clasificador'
                  PropertiesClassName = 'TcxLookupComboBoxProperties'
                  Properties.KeyFieldNames = 'oid_clasif_ent'
                  Properties.ListColumns = <
                    item
                      FieldName = 'descripcion'
                    end>
                  Properties.ListOptions.ShowHeader = False
                  Properties.ListSource = DSClasificadorEntidad
                  HeaderAlignmentHorz = taCenter
                  HeaderAlignmentVert = vaCenter
                  Width = 99
                end
                object dxCodValClasifInc: TcxGridDBColumn
                  Caption = 'C'#243'digo'
                  DataBinding.FieldName = 'cod_val_clasif'
                  PropertiesClassName = 'TcxButtonEditProperties'
                  Properties.Buttons = <
                    item
                      Default = True
                      Kind = bkEllipsis
                    end>
                  Properties.ClickKey = 112
                  Width = 66
                end
                object dxDBGridSN1DBTableView1desc_val_clasif: TcxGridDBColumn
                  Caption = 'Descripci'#243'n'
                  DataBinding.FieldName = 'desc_val_clasif'
                  Options.Editing = False
                  Options.Focusing = False
                  Width = 119
                end
                object dxDBGridSN1DBTableView1activo: TcxGridDBColumn
                  Caption = 'Activo'
                  DataBinding.FieldName = 'activo'
                  PropertiesClassName = 'TcxCheckBoxProperties'
                  HeaderAlignmentHorz = taCenter
                  Width = 47
                end
              end
              object dxDBGridSN1Level1: TcxGridLevel
                GridView = dxDBGridSN1DBTableView1
              end
            end
          end
          object Panel4: TPanel
            Left = 367
            Top = 44
            Width = 365
            Height = 215
            Align = alClient
            BorderWidth = 5
            Color = clWindow
            TabOrder = 2
            object dxDBGridSN2: TdxDBGridSN
              Left = 6
              Top = 6
              Width = 353
              Height = 203
              Align = alClient
              TabOrder = 0
              LookAndFeel.Kind = lfFlat
              CriteriosPintarCelda = <>
              object cxGridDBTableView1: TcxGridDBTableView
                NavigatorButtons.ConfirmDelete = False
                NavigatorButtons.PriorPage.Visible = False
                NavigatorButtons.Prior.Visible = False
                NavigatorButtons.Next.Visible = False
                NavigatorButtons.NextPage.Visible = False
                NavigatorButtons.Insert.Visible = True
                NavigatorButtons.Append.Visible = False
                NavigatorButtons.Delete.Visible = False
                NavigatorButtons.Edit.Visible = False
                NavigatorButtons.Post.Visible = False
                NavigatorButtons.Cancel.Visible = False
                NavigatorButtons.Refresh.Visible = False
                NavigatorButtons.SaveBookmark.Visible = False
                NavigatorButtons.GotoBookmark.Visible = False
                NavigatorButtons.Filter.Visible = False
                DataController.DataSource = DSTAlgoCacheoClasifExc
                DataController.Options = [dcoAssignGroupingValues, dcoAssignMasterDetailKeys, dcoSaveExpanding, dcoGroupsAlwaysExpanded, dcoInsertOnNewItemRowFocusing]
                DataController.Summary.DefaultGroupSummaryItems = <>
                DataController.Summary.FooterSummaryItems = <>
                DataController.Summary.SummaryGroups = <>
                OptionsBehavior.AlwaysShowEditor = True
                OptionsBehavior.FocusCellOnTab = True
                OptionsBehavior.FocusFirstCellOnNewRecord = True
                OptionsBehavior.GoToNextCellOnEnter = True
                OptionsBehavior.FocusCellOnCycle = True
                OptionsData.Appending = True
                OptionsData.Deleting = False
                OptionsSelection.InvertSelect = False
                OptionsView.Navigator = True
                OptionsView.GroupByBox = False
                object cxGridDBColumn1: TcxGridDBColumn
                  Caption = 'Clasificador'
                  DataBinding.FieldName = 'oid_clasificador'
                  PropertiesClassName = 'TcxLookupComboBoxProperties'
                  Properties.KeyFieldNames = 'oid_clasif_ent'
                  Properties.ListColumns = <
                    item
                      FieldName = 'descripcion'
                    end>
                  Properties.ListOptions.ShowHeader = False
                  Properties.ListSource = DSClasificadorEntidad
                  HeaderAlignmentHorz = taCenter
                  HeaderAlignmentVert = vaCenter
                  Width = 99
                end
                object dxCodValClasifExc: TcxGridDBColumn
                  Caption = 'C'#243'digo'
                  DataBinding.FieldName = 'cod_val_clasif'
                  PropertiesClassName = 'TcxButtonEditProperties'
                  Properties.Buttons = <
                    item
                      Default = True
                      Kind = bkEllipsis
                    end>
                  Properties.ClickKey = 112
                  Width = 66
                end
                object cxGridDBColumn3: TcxGridDBColumn
                  Caption = 'Descripci'#243'n'
                  DataBinding.FieldName = 'desc_val_clasif'
                  Options.Editing = False
                  Options.Focusing = False
                  Width = 119
                end
                object cxGridDBColumn4: TcxGridDBColumn
                  Caption = 'Activo'
                  DataBinding.FieldName = 'activo'
                  PropertiesClassName = 'TcxCheckBoxProperties'
                  HeaderAlignmentHorz = taCenter
                  Width = 47
                end
              end
              object cxGridLevel1: TcxGridLevel
                GridView = cxGridDBTableView1
              end
            end
          end
        end
        object TabSheet2: TTabSheet
          BorderWidth = 5
          Caption = 'Filtro Avanzado de Legajos'
          ImageIndex = 1
          object Panel5: TPanel
            Left = 0
            Top = 0
            Width = 722
            Height = 33
            Align = alTop
            BevelOuter = bvNone
            Color = clWindow
            TabOrder = 0
            object Label4: TLabel
              Left = 8
              Top = 9
              Width = 102
              Height = 13
              Caption = 'Poblaci'#243'n de Legajos'
            end
            object snDBLookup2: TsnDBLookup
              Left = 132
              Top = 5
              DataBinding.DataField = 'tipo_planif'
              DataBinding.DataSource = DSTAlgoritmoCacheo
              Properties.KeyFieldNames = 'codigo'
              Properties.ListColumns = <
                item
                  FieldName = 'descripcion'
                end>
              Properties.ListOptions.ShowHeader = False
              Properties.ListSource = DSTPoblacionLegajo
              TabOrder = 0
              Width = 373
            end
          end
          object PageControlSN2: TPageControlSN
            Left = 0
            Top = 33
            Width = 722
            Height = 216
            ActivePage = TabSheet3
            Align = alClient
            TabOrder = 1
            object TabSheet3: TTabSheet
              Caption = 'Todos'
              object Label5: TLabel
                Left = 8
                Top = 16
                Width = 97
                Height = 13
                Caption = '% Entrada a Cacheo'
              end
              object snLabel3: TsnLabel
                Left = 184
                Top = 16
                Width = 259
                Height = 13
                Caption = 'Probabiliadad Ocurrencia cacheo a la entrada de 0 a 1'
              end
              object Label6: TLabel
                Left = 8
                Top = 48
                Width = 89
                Height = 13
                Caption = '% Salida a Cacheo'
              end
              object snLabel4: TsnLabel
                Left = 184
                Top = 48
                Width = 250
                Height = 13
                Caption = 'Probabiliadad Ocurrencia cacheo a la salida de 0 a 1'
              end
              object snDBEdit2: TsnDBEdit
                Left = 120
                Top = 12
                DataBinding.DataField = 'porc_ent'
                DataBinding.DataSource = DSTAlgoritmoCacheo
                TabOrder = 0
                Width = 41
              end
              object snDBEdit3: TsnDBEdit
                Left = 448
                Top = 12
                DataBinding.DataField = 'prob_cach_ent'
                DataBinding.DataSource = DSTAlgoritmoCacheo
                TabOrder = 1
                Width = 41
              end
              object snDBEdit4: TsnDBEdit
                Left = 120
                Top = 44
                DataBinding.DataField = 'porc_sal'
                DataBinding.DataSource = DSTAlgoritmoCacheo
                TabOrder = 2
                Width = 41
              end
              object snDBEdit5: TsnDBEdit
                Left = 448
                Top = 44
                DataBinding.DataField = 'prob_cach_sal'
                DataBinding.DataSource = DSTAlgoritmoCacheo
                TabOrder = 3
                Width = 41
              end
            end
            object TabSheet4: TTabSheet
              BorderWidth = 5
              Caption = 'Con rotas planificadas'
              ImageIndex = 1
              object dxDBGridSN3: TdxDBGridSN
                Left = 0
                Top = 0
                Width = 704
                Height = 178
                Align = alClient
                TabOrder = 0
                LookAndFeel.Kind = lfFlat
                CriteriosPintarCelda = <>
                object cxGridDBTableView2: TcxGridDBTableView
                  NavigatorButtons.ConfirmDelete = False
                  NavigatorButtons.PriorPage.Visible = False
                  NavigatorButtons.Prior.Visible = False
                  NavigatorButtons.Next.Visible = False
                  NavigatorButtons.NextPage.Visible = False
                  NavigatorButtons.Insert.Enabled = False
                  NavigatorButtons.Insert.Visible = False
                  NavigatorButtons.Append.Enabled = False
                  NavigatorButtons.Append.Visible = False
                  NavigatorButtons.Delete.Visible = False
                  NavigatorButtons.Edit.Visible = False
                  NavigatorButtons.Post.Visible = False
                  NavigatorButtons.Cancel.Visible = False
                  NavigatorButtons.Refresh.Visible = False
                  NavigatorButtons.SaveBookmark.Visible = False
                  NavigatorButtons.GotoBookmark.Visible = False
                  NavigatorButtons.Filter.Visible = False
                  DataController.DataSource = DSProbCacheoRota
                  DataController.Options = [dcoAssignGroupingValues, dcoAssignMasterDetailKeys, dcoSaveExpanding, dcoGroupsAlwaysExpanded, dcoInsertOnNewItemRowFocusing]
                  DataController.Summary.DefaultGroupSummaryItems = <>
                  DataController.Summary.FooterSummaryItems = <>
                  DataController.Summary.SummaryGroups = <>
                  OptionsBehavior.AlwaysShowEditor = True
                  OptionsBehavior.FocusCellOnTab = True
                  OptionsBehavior.FocusFirstCellOnNewRecord = True
                  OptionsBehavior.GoToNextCellOnEnter = True
                  OptionsBehavior.FocusCellOnCycle = True
                  OptionsData.Deleting = False
                  OptionsData.Inserting = False
                  OptionsSelection.InvertSelect = False
                  OptionsView.Navigator = True
                  OptionsView.GroupByBox = False
                  object cxGridDBTableView2rota: TcxGridDBColumn
                    Caption = 'Rota'
                    DataBinding.FieldName = 'rota'
                    HeaderAlignmentHorz = taCenter
                    Options.Editing = False
                    Options.Focusing = False
                    SortIndex = 0
                    SortOrder = soAscending
                    Width = 177
                  end
                  object cxGridDBTableView2porc_ent: TcxGridDBColumn
                    Caption = '% Entrada'
                    DataBinding.FieldName = 'porc_ent'
                    HeaderAlignmentHorz = taCenter
                    Width = 74
                  end
                  object cxGridDBTableView2prob_cach_ent: TcxGridDBColumn
                    Caption = '% Prob. Cacheo Entrada'
                    DataBinding.FieldName = 'prob_cach_ent'
                    HeaderAlignmentHorz = taCenter
                    Width = 127
                  end
                  object cxGridDBTableView2porc_sal: TcxGridDBColumn
                    Caption = '% Salida'
                    DataBinding.FieldName = 'porc_sal'
                    HeaderAlignmentHorz = taCenter
                    Width = 74
                  end
                  object cxGridDBTableView2prob_cach_sal: TcxGridDBColumn
                    Caption = '% Prob. Cacheo Salida'
                    DataBinding.FieldName = 'prob_cach_sal'
                    HeaderAlignmentHorz = taCenter
                    Width = 124
                  end
                  object cxGridDBTableView2activo: TcxGridDBColumn
                    Caption = 'Activo'
                    DataBinding.FieldName = 'activo'
                    HeaderAlignmentHorz = taCenter
                    Width = 50
                  end
                end
                object cxGridLevel2: TcxGridLevel
                  GridView = cxGridDBTableView2
                end
              end
            end
          end
        end
        object TabSheet5: TTabSheet
          Caption = 'Filtrar por Estados'
          ImageIndex = 2
          object Panel6: TPanel
            Left = 0
            Top = 0
            Width = 732
            Height = 36
            Align = alTop
            BevelOuter = bvNone
            Color = clWindow
            TabOrder = 0
            object Label7: TLabel
              Left = 8
              Top = 12
              Width = 84
              Height = 13
              Caption = 'Filtrar por Estados'
            end
            object snDBLookup3: TsnDBLookup
              Left = 108
              Top = 8
              DataBinding.DataField = 'filtro_estados'
              DataBinding.DataSource = DSTAlgoritmoCacheo
              Properties.KeyFieldNames = 'codigo'
              Properties.ListColumns = <
                item
                  FieldName = 'descripcion'
                end>
              Properties.ListOptions.ShowHeader = False
              Properties.ListSource = DSFiltrosEstados
              TabOrder = 0
              Width = 85
            end
          end
          object dxDBGridSN4: TdxDBGridSN
            Left = 0
            Top = 36
            Width = 732
            Height = 223
            Align = alClient
            BorderWidth = 5
            TabOrder = 1
            LookAndFeel.Kind = lfFlat
            CriteriosPintarCelda = <>
            object cxGridDBTableView3: TcxGridDBTableView
              NavigatorButtons.ConfirmDelete = False
              NavigatorButtons.PriorPage.Visible = False
              NavigatorButtons.Prior.Visible = False
              NavigatorButtons.Next.Visible = False
              NavigatorButtons.NextPage.Visible = False
              NavigatorButtons.Insert.Visible = True
              NavigatorButtons.Append.Visible = False
              NavigatorButtons.Delete.Visible = False
              NavigatorButtons.Edit.Visible = False
              NavigatorButtons.Post.Visible = False
              NavigatorButtons.Cancel.Visible = False
              NavigatorButtons.Refresh.Visible = False
              NavigatorButtons.SaveBookmark.Visible = False
              NavigatorButtons.GotoBookmark.Visible = False
              NavigatorButtons.Filter.Visible = False
              DataController.DataSource = DSAlgoCacheoEstado
              DataController.Options = [dcoAssignGroupingValues, dcoAssignMasterDetailKeys, dcoSaveExpanding, dcoGroupsAlwaysExpanded, dcoInsertOnNewItemRowFocusing]
              DataController.Summary.DefaultGroupSummaryItems = <>
              DataController.Summary.FooterSummaryItems = <>
              DataController.Summary.SummaryGroups = <>
              OptionsBehavior.AlwaysShowEditor = True
              OptionsBehavior.FocusCellOnTab = True
              OptionsBehavior.FocusFirstCellOnNewRecord = True
              OptionsBehavior.GoToNextCellOnEnter = True
              OptionsBehavior.FocusCellOnCycle = True
              OptionsData.Appending = True
              OptionsData.Deleting = False
              OptionsSelection.InvertSelect = False
              OptionsView.Navigator = True
              OptionsView.GroupByBox = False
              object cxGridDBTableView3oid_estado_cip: TcxGridDBColumn
                Caption = 'Estado'
                DataBinding.FieldName = 'oid_estado_cip'
                PropertiesClassName = 'TcxLookupComboBoxProperties'
                Properties.KeyFieldNames = 'oid'
                Properties.ListColumns = <
                  item
                    FieldName = 'descripcion'
                  end>
                Properties.ListOptions.ShowHeader = False
                Properties.ListSource = DSEstados
                HeaderAlignmentHorz = taCenter
                Width = 254
              end
              object cxGridDBTableView3activo: TcxGridDBColumn
                Caption = 'Activo'
                DataBinding.FieldName = 'activo'
                HeaderAlignmentHorz = taCenter
                Width = 54
              end
            end
            object cxGridLevel3: TcxGridLevel
              GridView = cxGridDBTableView3
            end
          end
        end
        object TabSheet6: TTabSheet
          BorderWidth = 5
          Caption = 'Fechas a Excluir Cacheos'
          ImageIndex = 3
          object dxDBGridSN5: TdxDBGridSN
            Left = 0
            Top = 0
            Width = 722
            Height = 249
            Align = alClient
            TabOrder = 0
            LookAndFeel.Kind = lfFlat
            CriteriosPintarCelda = <>
            object cxGridDBTableView4: TcxGridDBTableView
              NavigatorButtons.ConfirmDelete = False
              NavigatorButtons.PriorPage.Visible = False
              NavigatorButtons.Prior.Visible = False
              NavigatorButtons.Next.Visible = False
              NavigatorButtons.NextPage.Visible = False
              NavigatorButtons.Insert.Visible = True
              NavigatorButtons.Append.Visible = False
              NavigatorButtons.Delete.Visible = False
              NavigatorButtons.Edit.Visible = False
              NavigatorButtons.Post.Visible = False
              NavigatorButtons.Cancel.Visible = False
              NavigatorButtons.Refresh.Visible = False
              NavigatorButtons.SaveBookmark.Visible = False
              NavigatorButtons.GotoBookmark.Visible = False
              NavigatorButtons.Filter.Visible = False
              DataController.DataSource = DSExclusionFecha
              DataController.Options = [dcoAssignGroupingValues, dcoAssignMasterDetailKeys, dcoSaveExpanding, dcoGroupsAlwaysExpanded, dcoInsertOnNewItemRowFocusing]
              DataController.Summary.DefaultGroupSummaryItems = <>
              DataController.Summary.FooterSummaryItems = <>
              DataController.Summary.SummaryGroups = <>
              OptionsBehavior.AlwaysShowEditor = True
              OptionsBehavior.FocusCellOnTab = True
              OptionsBehavior.FocusFirstCellOnNewRecord = True
              OptionsBehavior.GoToNextCellOnEnter = True
              OptionsBehavior.FocusCellOnCycle = True
              OptionsData.Appending = True
              OptionsData.Deleting = False
              OptionsSelection.InvertSelect = False
              OptionsView.Navigator = True
              OptionsView.GroupByBox = False
              object cxGridDBTableView4fecha: TcxGridDBColumn
                Caption = 'Fecha'
                DataBinding.FieldName = 'fecha'
                PropertiesClassName = 'TcxDateEditProperties'
                HeaderAlignmentHorz = taCenter
                SortIndex = 0
                SortOrder = soDescending
                Width = 89
              end
              object cxGridDBTableView4activo: TcxGridDBColumn
                Caption = 'Activo'
                DataBinding.FieldName = 'activo'
                HeaderAlignmentHorz = taCenter
                Width = 52
              end
            end
            object cxGridLevel4: TcxGridLevel
              GridView = cxGridDBTableView4
            end
          end
        end
      end
    end
  end
  inherited DriverABM: TDriverABM
    OperTraerObjeto = 'TraerConfAlgoCacheo'
    OperGrabarObjeto = 'SaveConfAlgoCacheo'
    CargaDataSets = <
      item
        DataSet = TAlgoritmoCacheo
        TableName = 'TAlgoritmoCacheo'
      end
      item
        DataSet = TFiltrosLegajo
        TableName = 'TFiltrosLegajo'
      end
      item
        DataSet = TAlgoCacheoClasifInc
        TableName = 'TAlgoCacheoClasifInc'
      end
      item
        DataSet = TClasificadoresEntidad
        TableName = 'TClasificadoresEntidad'
      end
      item
        DataSet = TClasificadoresLegajo
        TableName = 'TClasificadoresLegajo'
      end
      item
        DataSet = TValorClaifEntidad
        TableName = 'TValorClaifEntidad'
      end
      item
        DataSet = TValoresClasificadores
        TableName = 'TValoresClasificadores'
      end
      item
        DataSet = TPoblacionLegajo
        TableName = 'TPoblacionLegajo'
      end
      item
        DataSet = TProbCacheoRota
        TableName = 'TProbCacheoRota'
      end
      item
        DataSet = TFiltrosEstados
        TableName = 'TFiltrosEstados'
      end
      item
        DataSet = TAlgoCacheoEstado
        TableName = 'TAlgoCacheoEstado'
      end
      item
        DataSet = TExclusionFecha
        TableName = 'TExclusionFecha'
      end
      item
        DataSet = TAlgoCacheoClasifExc
        TableName = 'TAlgoCacheoClasifExc'
      end>
    BajaLogica = <
      item
        DataSet = TAlgoritmoCacheo
        ValorBaja = 'false'
        ValorRehabilitacion = 'true'
        TipoBajaRegistro = tblCurrentRecord
        FieldName = 'activo'
      end>
    OperHabilitadas = [toOperNuevo, toOperModificar, toOperEliminar, toOperBuscar, toOperNavegacion, toOperRehabilitar]
    DataSetCab = TAlgoritmoCacheo
    DataSetDet1 = TAlgoCacheoClasifInc
    DataSetDet2 = TAlgoCacheoClasifExc
    DataSetDet3 = TProbCacheoRota
    DataSetDet4 = TAlgoCacheoEstado
    DataSetDet5 = TExclusionFecha
    ControlFocoAlta = DBECodigo
    ControlFocoModif = DBECodigo
    Left = 512
    Top = 16
  end
  inherited Operacion: TOperacion
    Left = 560
    Top = 16
  end
  object TAlgoritmoCacheo: TsnTable [3]
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'oid_algo_cacheo'
        DataType = ftInteger
      end
      item
        Name = 'filtro_legajo'
        DataType = ftString
        Size = 10
      end
      item
        Name = 'tipo_planif'
        DataType = ftString
        Size = 10
      end
      item
        Name = 'porc_ent'
        DataType = ftCurrency
      end
      item
        Name = 'prob_cach_ent'
        DataType = ftCurrency
      end
      item
        Name = 'porc_sal'
        DataType = ftCurrency
      end
      item
        Name = 'prob_cach_sal'
        DataType = ftCurrency
      end
      item
        Name = 'filtro_estados'
        DataType = ftString
        Size = 10
      end
      item
        Name = 'codigo'
        DataType = ftString
        Size = 20
      end
      item
        Name = 'descripcion'
        DataType = ftString
        Size = 50
      end
      item
        Name = 'activo'
        DataType = ftBoolean
      end
      item
        Name = 'lunes'
        DataType = ftBoolean
      end
      item
        Name = 'martes'
        DataType = ftBoolean
      end
      item
        Name = 'miercoles'
        DataType = ftBoolean
      end
      item
        Name = 'jueves'
        DataType = ftBoolean
      end
      item
        Name = 'viernes'
        DataType = ftBoolean
      end
      item
        Name = 'sabado'
        DataType = ftBoolean
      end
      item
        Name = 'domingo'
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
    Left = 552
    Top = 59
    object TAlgoritmoCacheooid_algo_cacheo: TIntegerField
      FieldName = 'oid_algo_cacheo'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TAlgoritmoCacheofiltro_legajo: TStringField
      FieldName = 'filtro_legajo'
      Size = 10
    end
    object TAlgoritmoCacheotipo_planif: TStringField
      FieldName = 'tipo_planif'
      Size = 10
    end
    object TAlgoritmoCacheoporc_ent: TCurrencyField
      FieldName = 'porc_ent'
    end
    object TAlgoritmoCacheoprob_cach_ent: TCurrencyField
      FieldName = 'prob_cach_ent'
    end
    object TAlgoritmoCacheoporc_sal: TCurrencyField
      FieldName = 'porc_sal'
    end
    object TAlgoritmoCacheoprob_cach_sal: TCurrencyField
      FieldName = 'prob_cach_sal'
    end
    object TAlgoritmoCacheofiltro_estados: TStringField
      FieldName = 'filtro_estados'
      Size = 10
    end
    object TAlgoritmoCacheocodigo: TStringField
      DisplayWidth = 20
      FieldName = 'codigo'
    end
    object TAlgoritmoCacheodescripcion: TStringField
      DisplayWidth = 50
      FieldName = 'descripcion'
      Size = 50
    end
    object TAlgoritmoCacheoactivo: TBooleanField
      DefaultExpression = '1'
      FieldName = 'activo'
    end
    object TAlgoritmoCacheolunes: TBooleanField
      FieldName = 'lunes'
    end
    object TAlgoritmoCacheomartes: TBooleanField
      FieldName = 'martes'
    end
    object TAlgoritmoCacheomiercoles: TBooleanField
      FieldName = 'miercoles'
    end
    object TAlgoritmoCacheojueves: TBooleanField
      FieldName = 'jueves'
    end
    object TAlgoritmoCacheoviernes: TBooleanField
      FieldName = 'viernes'
    end
    object TAlgoritmoCacheosabado: TBooleanField
      FieldName = 'sabado'
    end
    object TAlgoritmoCacheodomingo: TBooleanField
      FieldName = 'domingo'
    end
  end
  object DSTAlgoritmoCacheo: TDataSource [4]
    DataSet = TAlgoritmoCacheo
    Left = 584
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
        TableName = 'TAlgoritmoCacheo'
        FieldName = 'codigo'
        Source.Strings = (
          'begin'
          '  ValidadorAlgoCacheo.Value := Sender.AsString;'
          '  ValidadorAlgoCacheo.Validar;'
          'end.')
      end
      item
        TableName = 'TAlgoCacheoClasifInc'
        FieldName = 'cod_val_clasif'
        Source.Strings = (
          'begin'
          
            '  if (TAlgoCacheoClasifInc.FieldName('#39'oid_clasificador'#39').AsInteg' +
            'er = 0)'
          
            '     then raiseException(erCustomError,'#39'Debe seleccionar un clas' +
            'ificador'#39');'
          '  ValidarValorClasifEntidadInc('
          
            '        TAlgoCacheoClasifInc.FieldName('#39'oid_clasificador'#39').AsInt' +
            'eger,'
          '        Sender.AsString); '
          'end.')
      end
      item
        TableName = 'TAlgoCacheoClasifExc'
        FieldName = 'cod_val_clasif'
        Source.Strings = (
          'begin'
          
            '  if (TAlgoCacheoClasifExc.FieldName('#39'oid_clasificador'#39').AsInteg' +
            'er = 0)'
          
            '     then raiseException(erCustomError,'#39'Debe seleccionar un clas' +
            'ificador'#39');'
          '  ValidarValorClasifEntidadExc('
          
            '        TAlgoCacheoClasifExc.FieldName('#39'oid_clasificador'#39').AsInt' +
            'eger,'
          '        Sender.AsString); '
          'end.')
      end>
    OnChangeField = <
      item
        TableName = 'TAlgoCacheoClasifInc'
        FieldName = 'oid_clasificador'
        Source.Strings = (
          'begin'
          '  setDatosClasif(Sender.AsInteger);'
          'end.')
      end
      item
        TableName = 'TAlgoCacheoClasifExc'
        FieldName = 'oid_clasificador'
        Source.Strings = (
          'begin'
          '  setDatosClasifExc(Sender.AsInteger);'
          'end.')
      end>
    OnBeforePost = <
      item
        TableName = 'TAlgoCacheoClasifInc'
        Source.Strings = (
          'begin'
          '  if (DataSet.FieldName('#39'oid_clasificador'#39').AsInteger = 0)'
          
            '     then RaiseException(erCustomError,'#39'Debe ingresar el Clasifi' +
            'cador'#39');'
          '  if (DataSet.FieldName('#39'oid_val_clasif'#39').AsInteger = 0)'
          
            '    then RaiseException(erCustomError,'#39'Debe ingresar el valor de' +
            'l clasificador'#39');'
          'end.')
      end
      item
        TableName = 'TAlgoCacheoClasifExc'
        Source.Strings = (
          'begin'
          '  if (DataSet.FieldName('#39'oid_clasificador'#39').AsInteger = 0)'
          
            '     then RaiseException(erCustomError,'#39'Debe ingresar el Clasifi' +
            'cador'#39');'
          '  if (DataSet.FieldName('#39'oid_val_clasif'#39').AsInteger = 0)'
          
            '    then RaiseException(erCustomError,'#39'Debe ingresar el valor de' +
            'l clasificador'#39');'
          'end.')
      end
      item
        TableName = 'TAlgoCacheoEstado'
        Source.Strings = (
          'begin'
          '  if (DataSet.FieldName('#39'oid_estado_cip'#39').AsInteger=0)'
          
            '    then raiseException(erCustomError,'#39'Debe ingresar el estado'#39')' +
            ';'
          'end.')
      end
      item
        TableName = 'TExclusionFecha'
        Source.Strings = (
          'begin'
          '  if (DataSet.FieldName('#39'fecha'#39').IsNull)'
          
            '     then RaiseException(erCustomError,'#39'Debe ingresar la fecha d' +
            'e exclusi'#243'n'#39');'
          'end.')
      end>
    OnNuevoRegistro = <
      item
        TableName = 'TAlgoCacheoClasifInc'
        Source.Strings = (
          'begin'
          '  DataSet.FieldName('#39'oid_algo_cacheo'#39').AsInteger := '
          
            '          TAlgoritmoCacheo.FieldName('#39'oid_algo_cacheo'#39').AsIntege' +
            'r;'
          '  DataSet.FieldName('#39'activo'#39').AsBoolean := True;'
          '  DataSet.FieldName('#39'inc_exc'#39').AsString := '#39'I'#39';'
          'end.')
      end
      item
        TableName = 'TAlgoCacheoClasifExc'
        Source.Strings = (
          'begin'
          '  DataSet.FieldName('#39'oid_algo_cacheo'#39').AsInteger := '
          
            '          TAlgoritmoCacheo.FieldName('#39'oid_algo_cacheo'#39').AsIntege' +
            'r;'
          '  DataSet.FieldName('#39'activo'#39').AsBoolean := True;'
          '  DataSet.FieldName('#39'inc_exc'#39').AsString := '#39'E'#39';'
          'end.')
      end
      item
        TableName = 'TProbCacheoRota'
        Source.Strings = (
          'begin'
          '  DataSet.FieldName('#39'oid_algo_cacheo'#39').AsInteger := '
          
            '          TAlgoritmoCacheo.FieldName('#39'oid_algo_cacheo'#39').AsIntege' +
            'r;'
          '  DataSet.FieldName('#39'activo'#39').AsBoolean := True;'
          'end.')
      end
      item
        TableName = 'TAlgoCacheoEstado'
        Source.Strings = (
          'begin'
          '  DataSet.FieldName('#39'oid_algo_cacheo'#39').AsInteger := '
          
            '          TAlgoritmoCacheo.FieldName('#39'oid_algo_cacheo'#39').AsIntege' +
            'r;'
          '  DataSet.FieldName('#39'activo'#39').AsBoolean := True;'
          'end.')
      end
      item
        TableName = 'TAlgoritmoCacheo'
        Source.Strings = (
          'begin'
          '  TAlgoritmoCacheo.FieldName('#39'lunes'#39').AsBoolean := True;'
          '  TAlgoritmoCacheo.FieldName('#39'martes'#39').AsBoolean := True;'
          '  TAlgoritmoCacheo.FieldName('#39'miercoles'#39').AsBoolean := True;'
          '  TAlgoritmoCacheo.FieldName('#39'jueves'#39').AsBoolean := True;'
          '  TAlgoritmoCacheo.FieldName('#39'viernes'#39').AsBoolean := True;'
          '  TAlgoritmoCacheo.FieldName('#39'sabado'#39').AsBoolean := True;'
          '  TAlgoritmoCacheo.FieldName('#39'domingo'#39').AsBoolean := True;'
          'end.')
      end
      item
        TableName = 'TExclusionFecha'
        Source.Strings = (
          'begin'
          '  DataSet.FieldName('#39'oid_algo_cacheo'#39').AsInteger := '
          
            '          TAlgoritmoCacheo.FieldName('#39'oid_algo_cacheo'#39').AsIntege' +
            'r;'
          '  DataSet.FieldName('#39'activo'#39').AsBoolean := True;'
          'end.')
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
          'procedure setDatosClasif(OidClasif : integer);'
          'begin'
          ''
          
            '   TAlgoCacheoClasifInc.FieldName('#39'cod_val_clasif'#39').AsString := ' +
            #39#39';'
          '   TAlgoCacheoClasifInc.FieldName('#39'nro_clasificador'#39').Clear; '
          ''
          '  if (OidClasif<=0) '
          '     then exit;'
          ''
          '  TClasificadoresLegajo.First;'
          
            '  if (TClasificadoresLegajo.Locate('#39'oid_clasif_ent'#39',OidClasif,[]' +
            '))'
          '     then begin'
          '          TAlgoCacheoClasifInc.EditRecord;'
          
            '          TAlgoCacheoClasifInc.FieldName('#39'nro_clasificador'#39').AsI' +
            'nteger := '
          
            '              TClasificadoresLegajo.FieldName('#39'nro_clasif'#39').AsIn' +
            'teger;    '
          #9'  end;'#9
          'end;'
          ''
          'procedure setDatosClasifExc(OidClasif : integer);'
          'begin'
          ''
          
            '   TAlgoCacheoClasifExc.FieldName('#39'cod_val_clasif'#39').AsString := ' +
            #39#39';'
          '   TAlgoCacheoClasifExc.FieldName('#39'nro_clasificador'#39').Clear; '
          ''
          '  if (OidClasif<=0) '
          '     then exit;'
          ''
          '  TClasificadoresLegajo.First;'
          
            '  if (TClasificadoresLegajo.Locate('#39'oid_clasif_ent'#39',OidClasif,[]' +
            '))'
          '     then begin'
          '          TAlgoCacheoClasifExc.EditRecord;'
          
            '          TAlgoCacheoClasifExc.FieldName('#39'nro_clasificador'#39').AsI' +
            'nteger := '
          
            '              TClasificadoresLegajo.FieldName('#39'nro_clasif'#39').AsIn' +
            'teger;    '
          #9'  end;'#9
          'end;'
          ''
          ''
          'procedure TraerClasifLegajos();'
          'begin'
          '  operacion.InicioOperacion();'
          '  operacion.setOper('#39'TraerClasificadoresNickName'#39');'
          '  operacion.AddAtribute('#39'nickname'#39','#39'su.Legajo'#39');'
          '  operacion.AddAtribute('#39'SOLO_ACTIVO'#39','#39#39');'
          '  operacion.execute();'
          'end;'
          ''
          ''
          'procedure Inicializar();'
          'begin'
          ''
          '  operacion.InicioOperacion();'
          '  operacion.setOper('#39'TraerInicioConfAlgoCacheo'#39');'
          '  operacion.execute();'
          ''
          '  TraerClasifLegajos();'
          ''
          '  operacion.InicioOperacion();'
          '  operacion.setOper('#39'TraerClasifLegajos'#39');'
          '  operacion.execute();'
          ''
          '  TRotas.loadFromHelp('#39'HelpRotas'#39');'
          '  TEstados.loadFromHelp('#39'HelpEstados'#39');'
          ''
          'end;'
          ''
          'procedure MostrarHelpValoresClasificadorExc();'
          'begin'
          
            '   HelpValoresClasificadorExc.NickName           :=  '#39'su.Legajo'#39 +
            ';'
          
            '   HelpValoresClasificadorExc.NroClasificador    :=  TAlgoCacheo' +
            'ClasifExc.FieldName('#39'nro_clasificador'#39').AsInteger;'
          '   HelpValoresClasificadorExc.Mostrar();'
          'end;'
          ''
          'procedure MostrarHelpValoresClasificador();'
          'begin'
          
            '   HelpValoresClasificadorInc.NickName           :=  '#39'su.Legajo'#39 +
            ';'
          
            '   HelpValoresClasificadorInc.NroClasificador    :=  TAlgoCacheo' +
            'ClasifInc.FieldName('#39'nro_clasificador'#39').AsInteger;'
          '   HelpValoresClasificadorInc.Mostrar();'
          'end;'
          ''
          'procedure ValidarValorClasifEntidad(OidClasifEnt : integer ;'
          
            '                                                        codigo :' +
            ' string);'
          'begin'
          ''
          '  if (codigo = '#39#39')'
          '     then begin'
          '             TValoresClasificadores.EditRecord;'
          
            '             TValoresClasificadores.FieldName('#39'oid_val_clasif_en' +
            't'#39').AsInteger := 0;'
          
            '             TValoresClasificadores.FieldName('#39'desc_valor'#39').AsSt' +
            'ring := '#39#39';'
          '             exit;'
          '             end;'
          ''
          '  operacion.inicioOperacion;'
          '  operacion.setOper('#39'TraerValorClasifEntidad'#39');'
          
            '  operacion.addAtribute('#39'oid_clasif_ent'#39',IntToStr(OidClasifEnt))' +
            ';'
          '  operacion.addAtribute('#39'codigo'#39',codigo);'
          '  operacion.execute;'
          ''
          '  TValoresClasificadores.EditRecord;'
          
            '  TValoresClasificadores.FieldName('#39'oid_val_clasif_ent'#39').AsInteg' +
            'er :='
          
            '       TValorClaifEntidad.FieldName('#39'oid_valor_clasif_ent'#39').AsIn' +
            'teger;'
          '  TValoresClasificadores.FieldName('#39'desc_valor'#39').AsString :='
          '      TValorClaifEntidad.FieldName('#39'descripcion'#39').AsString;'
          ''
          'end;'
          ''
          'procedure ValidarValorClasifEntidadInc(OidClasifEnt : integer ;'
          
            '                                                              co' +
            'digo : string);'
          'begin'
          ''
          '  if (codigo = '#39#39')'
          '     then begin'
          '             TAlgoCacheoClasifInc.EditRecord;'
          
            '             TAlgoCacheoClasifInc.FieldName('#39'oid_val_clasif'#39').As' +
            'Integer := 0;'
          
            '             TAlgoCacheoClasifInc.FieldName('#39'desc_val_clasif'#39').A' +
            'sString := '#39#39';'
          '             exit;'
          '             end;'
          ''
          '  operacion.inicioOperacion;'
          '  operacion.setOper('#39'TraerValorClasifEntidad'#39');'
          
            '  operacion.addAtribute('#39'oid_clasif_ent'#39',IntToStr(OidClasifEnt))' +
            ';'
          '  operacion.addAtribute('#39'codigo'#39',codigo);'
          '  operacion.execute;'
          ''
          '  TAlgoCacheoClasifInc.EditRecord;'
          '  TAlgoCacheoClasifInc.FieldName('#39'oid_val_clasif'#39').AsInteger :='
          
            '       TValorClaifEntidad.FieldName('#39'oid_valor_clasif_ent'#39').AsIn' +
            'teger;'
          '  TAlgoCacheoClasifInc.FieldName('#39'desc_val_clasif'#39').AsString :='
          '      TValorClaifEntidad.FieldName('#39'descripcion'#39').AsString;'
          ''
          'end;'
          ''
          'procedure ValidarValorClasifEntidadExc(OidClasifEnt : integer ;'
          
            '                                                               c' +
            'odigo : string);'
          'begin'
          ''
          '  if (codigo = '#39#39')'
          '     then begin'
          '             TAlgoCacheoClasifExc.EditRecord;'
          
            '             TAlgoCacheoClasifExc.FieldName('#39'oid_val_clasif'#39').As' +
            'Integer := 0;'
          
            '             TAlgoCacheoClasifExc.FieldName('#39'desc_val_clasif'#39').A' +
            'sString := '#39#39';'
          '             exit;'
          '             end;'
          ''
          '  operacion.inicioOperacion;'
          '  operacion.setOper('#39'TraerValorClasifEntidad'#39');'
          
            '  operacion.addAtribute('#39'oid_clasif_ent'#39',IntToStr(OidClasifEnt))' +
            ';'
          '  operacion.addAtribute('#39'codigo'#39',codigo);'
          '  operacion.execute;'
          ''
          '  TAlgoCacheoClasifExc.EditRecord;'
          '  TAlgoCacheoClasifExc.FieldName('#39'oid_val_clasif'#39').AsInteger :='
          
            '       TValorClaifEntidad.FieldName('#39'oid_valor_clasif_ent'#39').AsIn' +
            'teger;'
          '  TAlgoCacheoClasifExc.FieldName('#39'desc_val_clasif'#39').AsString :='
          '      TValorClaifEntidad.FieldName('#39'descripcion'#39').AsString;'
          ''
          'end;'
          ''
          'procedure InicializarRotas();'
          'begin'
          '  TRotas.First;'
          '  while (not TRotas.eof) do'
          '    begin'
          '    TProbCacheoRota.AppendRecord;'
          '    TProbCacheoRota.FieldName('#39'oid_rota'#39').AsInteger :='
          '       TRotas.FieldName('#39'oid'#39').AsInteger;'
          '    TProbCacheoRota.FieldName('#39'rota'#39').AsString :='
          '       TRotas.FieldName('#39'descripcion'#39').AsString; '
          '    TProbCacheoRota.PostRecord; '
          '    TRotas.next;'
          '    end;'
          'end;'
          '')
      end>
    OnAfterNuevo = <
      item
        Source.Strings = (
          'begin'
          '  InicializarRotas();'
          'end.')
      end>
    OnClickButtonColumn = <
      item
        ColumnName = 'dxCodValClasifInc'
        Source.Strings = (
          'begin'
          
            '  if (TAlgoCacheoClasifInc.FieldName('#39'oid_clasificador'#39').AsInteg' +
            'er = 0)'
          
            '     then raiseException(erCustomError,'#39'Debe seleccionar un clas' +
            'ificador'#39');'
          '  MostrarHelpValoresClasificador();'
          'end.')
      end
      item
        ColumnName = 'dxCodValClasifExc'
        Source.Strings = (
          'begin'
          
            '  if (TAlgoCacheoClasifExc.FieldName('#39'oid_clasificador'#39').AsInteg' +
            'er = 0)'
          
            '     then raiseException(erCustomError,'#39'Debe seleccionar un clas' +
            'ificador'#39');'
          '  MostrarHelpValoresClasificadorExc();'
          'end.')
      end>
  end
  inherited ImprimirObjetoSeleccionado: TdxComponentPrinter
    Left = 312
    Top = 144
    inherited ImprimirObjetoSeleccionadodxComponentPrinterLink: TdxGridReportLink
      BuiltInReportLink = True
    end
  end
  inherited ImageListGruposPopUp: TImageList
    Top = 91
  end
  inherited TDataSetOidObjSave: TsnTable
    Left = 624
    Top = 219
  end
  object HelpAlgoCacheo: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'cip.AlgoritmoCacheo'
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
    Titulo = 'Algoritmos de Cacheo'
    AnchoHelp = 600
    ActivarCache = False
    ShowBotonBuscar = False
    Left = 50
    Top = 28
  end
  object ValidadorAlgoCacheo: TValidador
    Operacion = Operacion
    NickNameObjLog = 'cip.AlgoritmoCacheo'
    WhenRaiseException = teFound
    MensajeException = 'C'#243'digo de Algoritmo de Cacheo Existente'
    NroQuery = 0
    Cache = False
    Left = 136
    Top = 51
  end
  object TFiltrosLegajo: TsnTable
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
    Left = 392
    Top = 179
    object TFiltrosLegajocodigo: TStringField
      FieldName = 'codigo'
      Size = 50
    end
    object TFiltrosLegajodescripcion: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
  end
  object DSFiltrosLegajos: TDataSource
    DataSet = TFiltrosLegajo
    Left = 424
    Top = 179
  end
  object TAlgoCacheoClasifInc: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'oid_cache_clasif'
        DataType = ftInteger
      end
      item
        Name = 'oid_algo_cacheo'
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
        Name = 'inc_exc'
        DataType = ftString
        Size = 1
      end
      item
        Name = 'activo'
        DataType = ftBoolean
      end>
    IndexFieldNames = 'oid_algo_cacheo;orden'
    IndexDefs = <
      item
        Name = 'TAlgoCacheoClasifIndex1'
        Fields = 'oid_algo_cacheo;orden'
      end>
    RecalcOnFetch = False
    SortOptions = []
    PersistentBackup = False
    ProgressFlags = [mtpcLoad, mtpcSave, mtpcCopy]
    VersioningMode = mtvmAllSinceCheckPoint
    FilterOptions = []
    MasterFields = 'oid_algo_cacheo'
    MasterSource = DSTAlgoritmoCacheo
    Version = '4.08b'
    LanguageID = 0
    SortID = 0
    SubLanguageID = 1
    LocaleID = 1024
    MensajeValorDuplicadoIndice = 'Valor Duplicado'
    Left = 377
    Top = 102
    object TAlgoCacheoClasifIncoid_cache_clasif: TIntegerField
      FieldName = 'oid_cache_clasif'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TAlgoCacheoClasifIncoid_algo_cacheo: TIntegerField
      FieldName = 'oid_algo_cacheo'
    end
    object TAlgoCacheoClasifIncoid_clasificador: TIntegerField
      FieldName = 'oid_clasificador'
    end
    object TAlgoCacheoClasifIncoid_val_clasif: TIntegerField
      FieldName = 'oid_val_clasif'
    end
    object TAlgoCacheoClasifInccod_val_clasif: TStringField
      FieldName = 'cod_val_clasif'
      Size = 50
    end
    object TAlgoCacheoClasifIncdesc_val_clasif: TStringField
      FieldName = 'desc_val_clasif'
      Size = 100
    end
    object TAlgoCacheoClasifIncinc_exc: TStringField
      FieldName = 'inc_exc'
      Size = 1
    end
    object TAlgoCacheoClasifIncactivo: TBooleanField
      FieldName = 'activo'
    end
    object TAlgoCacheoClasifIncnro_clasificador: TIntegerField
      FieldName = 'nro_clasificador'
    end
    object TAlgoCacheoClasifIncorden: TIntegerField
      AutoGenerateValue = arAutoInc
      FieldName = 'orden'
    end
  end
  object DSTAlgoCacheoClasifInc: TDataSource
    DataSet = TAlgoCacheoClasifInc
    Left = 408
    Top = 100
  end
  object TClasificadoresEntidad: TsnTable
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
    Top = 267
    object TClasificadoresEntidadoid_clasif_ent: TIntegerField
      FieldName = 'oid_clasif_ent'
    end
    object TClasificadoresEntidadcodigo: TStringField
      FieldName = 'codigo'
      Size = 50
    end
    object TClasificadoresEntidaddescripcion: TStringField
      FieldName = 'descripcion'
      Size = 50
    end
    object TClasificadoresEntidadnro_clasif: TIntegerField
      FieldName = 'nro_clasif'
    end
  end
  object DSClasificadorEntidad: TDataSource
    DataSet = TClasificadoresEntidad
    Left = 626
    Top = 267
  end
  object HelpValoresClasificadorInc: THelpValoresClasificador
    AsignarCampoCodigo = TAlgoCacheoClasifInccod_val_clasif
    NroClasificador = 0
    Left = 208
    Top = 177
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
    Left = 505
    Top = 174
    object TClasificadoresLegajooid_clasif_ent: TIntegerField
      FieldName = 'oid_clasif_ent'
    end
    object TClasificadoresLegajocodigo: TStringField
      FieldName = 'codigo'
    end
    object TClasificadoresLegajodescripcion: TStringField
      FieldName = 'descripcion'
      Size = 50
    end
    object TClasificadoresLegajonickname: TStringField
      FieldName = 'nickname'
      Size = 30
    end
    object TClasificadoresLegajoobligatorio: TBooleanField
      FieldName = 'obligatorio'
    end
    object TClasificadoresLegajoactivo: TBooleanField
      FieldName = 'activo'
    end
    object TClasificadoresLegajonro_clasif: TIntegerField
      FieldName = 'nro_clasif'
    end
    object TClasificadoresLegajooid_grupo_clasif: TIntegerField
      FieldName = 'oid_grupo_clasif'
    end
    object TClasificadoresLegajocod_grupo_clasif: TStringField
      FieldName = 'cod_grupo_clasif'
      Size = 50
    end
    object TClasificadoresLegajodesc_grupo_clasif: TStringField
      FieldName = 'desc_grupo_clasif'
      Size = 100
    end
  end
  object DSClasificadoresLegajo: TDataSource
    DataSet = TClasificadoresLegajo
    Left = 537
    Top = 174
  end
  object TValorClaifEntidad: TsnTable
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
    Left = 454
    Top = 148
    object TValorClaifEntidadoid_valor_clasif_ent: TIntegerField
      FieldName = 'oid_valor_clasif_ent'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TValorClaifEntidadcodigo: TStringField
      FieldName = 'codigo'
      Size = 30
    end
    object TValorClaifEntidaddescripcion: TStringField
      FieldName = 'descripcion'
      Size = 50
    end
    object TValorClaifEntidadoid_clasif_entidad: TIntegerField
      FieldName = 'oid_clasif_entidad'
    end
  end
  object TValoresClasificadores: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'oid_valor_clasif'
        DataType = ftInteger
      end
      item
        Name = 'oid_legajo'
        DataType = ftInteger
      end
      item
        Name = 'oid_clasif_ent'
        DataType = ftInteger
      end
      item
        Name = 'oid_val_clasif_ent'
        DataType = ftInteger
      end
      item
        Name = 'nro_clasif'
        DataType = ftInteger
      end
      item
        Name = 'desc_grupo_clasif'
        DataType = ftString
        Size = 100
      end
      item
        Name = 'cod_valor'
        DataType = ftString
        Size = 30
      end
      item
        Name = 'desc_valor'
        DataType = ftString
        Size = 100
      end
      item
        Name = 'nickname'
        DataType = ftString
        Size = 50
      end
      item
        Name = 'activo'
        DataType = ftBoolean
      end
      item
        Name = 'desc_clasificador'
        DataType = ftString
        Size = 100
      end>
    IndexFieldNames = 'oid_legajo'
    IndexDefs = <
      item
        Name = 'TValoresClasificadoresIndex1'
        Fields = 'oid_legajo'
      end>
    RecalcOnFetch = False
    SortOptions = []
    PersistentBackup = False
    ProgressFlags = [mtpcLoad, mtpcSave, mtpcCopy]
    VersioningMode = mtvmAllSinceCheckPoint
    FilterOptions = []
    MasterFields = 'oid_legajo'
    Version = '4.08b'
    LanguageID = 0
    SortID = 0
    SubLanguageID = 1
    LocaleID = 1024
    MensajeValorDuplicadoIndice = 'Valor Duplicado'
    Left = 590
    Top = 300
    object TValoresClasificadoresoid_valor_clasif: TIntegerField
      FieldName = 'oid_valor_clasif'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TValoresClasificadoresoid_legajo: TIntegerField
      FieldName = 'oid_legajo'
    end
    object TValoresClasificadoresoid_clasif_ent: TIntegerField
      FieldName = 'oid_clasif_ent'
    end
    object TValoresClasificadoresoid_val_clasif_ent: TIntegerField
      FieldName = 'oid_val_clasif_ent'
    end
    object TValoresClasificadoresnro_clasif: TIntegerField
      FieldName = 'nro_clasif'
    end
    object TValoresClasificadoresdesc_grupo_clasif: TStringField
      FieldName = 'desc_grupo_clasif'
      Size = 100
    end
    object TValoresClasificadorescod_valor: TStringField
      FieldName = 'cod_valor'
      Size = 30
    end
    object TValoresClasificadoresdesc_valor: TStringField
      FieldName = 'desc_valor'
      Size = 100
    end
    object TValoresClasificadoresnickname: TStringField
      FieldName = 'nickname'
      Size = 50
    end
    object TValoresClasificadoresactivo: TBooleanField
      FieldName = 'activo'
    end
    object TValoresClasificadoresdesc_clasificador: TStringField
      FieldName = 'desc_clasificador'
      Size = 100
    end
  end
  object TAlgoCacheoClasifExc: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'oid_cache_clasif'
        DataType = ftInteger
      end
      item
        Name = 'oid_algo_cacheo'
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
        Name = 'inc_exc'
        DataType = ftString
        Size = 1
      end
      item
        Name = 'activo'
        DataType = ftBoolean
      end
      item
        Name = 'nro_clasificador'
        DataType = ftInteger
      end>
    IndexFieldNames = 'oid_algo_cacheo;orden'
    IndexDefs = <
      item
        Name = 'TAlgoCacheoClasifIndex1'
        Fields = 'oid_algo_cacheo;orden'
      end>
    RecalcOnFetch = False
    SortOptions = []
    PersistentBackup = False
    ProgressFlags = [mtpcLoad, mtpcSave, mtpcCopy]
    VersioningMode = mtvmAllSinceCheckPoint
    FilterOptions = []
    MasterFields = 'oid_algo_cacheo'
    MasterSource = DSTAlgoritmoCacheo
    Version = '4.08b'
    LanguageID = 0
    SortID = 0
    SubLanguageID = 1
    LocaleID = 1024
    MensajeValorDuplicadoIndice = 'Valor Duplicado'
    Left = 450
    Top = 102
    object IntegerField1: TIntegerField
      FieldName = 'oid_cache_clasif'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object IntegerField2: TIntegerField
      FieldName = 'oid_algo_cacheo'
    end
    object IntegerField3: TIntegerField
      FieldName = 'oid_clasificador'
    end
    object IntegerField4: TIntegerField
      FieldName = 'oid_val_clasif'
    end
    object StringField1: TStringField
      FieldName = 'cod_val_clasif'
      Size = 50
    end
    object StringField2: TStringField
      FieldName = 'desc_val_clasif'
      Size = 100
    end
    object StringField3: TStringField
      FieldName = 'inc_exc'
      Size = 1
    end
    object BooleanField1: TBooleanField
      FieldName = 'activo'
    end
    object IntegerField5: TIntegerField
      FieldName = 'nro_clasificador'
    end
    object TAlgoCacheoClasifExcorden: TIntegerField
      AutoGenerateValue = arAutoInc
      FieldName = 'orden'
    end
  end
  object DSTAlgoCacheoClasifExc: TDataSource
    DataSet = TAlgoCacheoClasifExc
    Left = 481
    Top = 100
  end
  object HelpValoresClasificadorExc: THelpValoresClasificador
    AsignarCampoCodigo = StringField1
    NroClasificador = 0
    Left = 243
    Top = 177
  end
  object TPoblacionLegajo: TsnTable
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
    Left = 466
    Top = 203
    object StringField4: TStringField
      FieldName = 'codigo'
      Size = 50
    end
    object StringField5: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
  end
  object DSTPoblacionLegajo: TDataSource
    DataSet = TPoblacionLegajo
    Left = 498
    Top = 203
  end
  object TProbCacheoRota: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'oid_prob_cacheo'
        DataType = ftInteger
      end
      item
        Name = 'oid_algo_cacheo'
        DataType = ftInteger
      end
      item
        Name = 'oid_rota'
        DataType = ftInteger
      end
      item
        Name = 'rota'
        DataType = ftString
        Size = 100
      end
      item
        Name = 'porc_ent'
        DataType = ftCurrency
      end
      item
        Name = 'prob_cach_ent'
        DataType = ftCurrency
      end
      item
        Name = 'porc_sal'
        DataType = ftCurrency
      end
      item
        Name = 'prob_cach_sal'
        DataType = ftCurrency
      end
      item
        Name = 'activo'
        DataType = ftBoolean
      end>
    IndexFieldNames = 'oid_algo_cacheo'
    IndexDefs = <
      item
        Name = 'TProbCacheoRotaIndex1'
        Fields = 'oid_algo_cacheo'
      end>
    RecalcOnFetch = False
    SortOptions = []
    PersistentBackup = False
    ProgressFlags = [mtpcLoad, mtpcSave, mtpcCopy]
    VersioningMode = mtvmAllSinceCheckPoint
    FilterOptions = []
    MasterFields = 'oid_algo_cacheo'
    MasterSource = DSTAlgoritmoCacheo
    Version = '4.08b'
    LanguageID = 0
    SortID = 0
    SubLanguageID = 1
    LocaleID = 1024
    MensajeValorDuplicadoIndice = 'Valor Duplicado'
    Left = 520
    Top = 100
    object TProbCacheoRotaoid_prob_cacheo: TIntegerField
      FieldName = 'oid_prob_cacheo'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TProbCacheoRotaoid_algo_cacheo: TIntegerField
      FieldName = 'oid_algo_cacheo'
    end
    object TProbCacheoRotaoid_rota: TIntegerField
      FieldName = 'oid_rota'
    end
    object TProbCacheoRotarota: TStringField
      DisplayWidth = 100
      FieldName = 'rota'
      Size = 100
    end
    object TProbCacheoRotaporc_ent: TCurrencyField
      FieldName = 'porc_ent'
      DisplayFormat = '###,###,###,###.##'
    end
    object TProbCacheoRotaprob_cach_ent: TCurrencyField
      FieldName = 'prob_cach_ent'
      DisplayFormat = '###,###,###,###.##'
    end
    object TProbCacheoRotaporc_sal: TCurrencyField
      FieldName = 'porc_sal'
      DisplayFormat = '###,###,###,###.##'
    end
    object TProbCacheoRotaprob_cach_sal: TCurrencyField
      FieldName = 'prob_cach_sal'
      DisplayFormat = '###,###,###,###.##'
    end
    object TProbCacheoRotaactivo: TBooleanField
      FieldName = 'activo'
    end
  end
  object DSProbCacheoRota: TDataSource
    DataSet = TProbCacheoRota
    Left = 552
    Top = 100
  end
  object HelpRotas: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'cip.Rota'
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
    Titulo = 'Rotas'
    AnchoHelp = 600
    ActivarCache = False
    ShowBotonBuscar = False
    Left = 354
    Top = 351
  end
  object TRotas: TsnTable
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
    Left = 384
    Top = 353
    object TRotasoid: TIntegerField
      FieldName = 'oid'
    end
    object TRotascodigo: TStringField
      FieldName = 'codigo'
      Size = 50
    end
    object TRotasdescripcion: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
  end
  object TFiltrosEstados: TsnTable
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
    Left = 392
    Top = 226
    object StringField6: TStringField
      FieldName = 'codigo'
      Size = 50
    end
    object StringField7: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
  end
  object DSFiltrosEstados: TDataSource
    DataSet = TFiltrosEstados
    Left = 424
    Top = 226
  end
  object HelpEstados: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'cip.EstadoCIP'
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
    Titulo = 'Estados'
    AnchoHelp = 600
    ActivarCache = False
    ShowBotonBuscar = False
    Left = 354
    Top = 311
  end
  object TEstados: TsnTable
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
    Left = 384
    Top = 313
    object IntegerField6: TIntegerField
      FieldName = 'oid'
    end
    object StringField8: TStringField
      FieldName = 'codigo'
      Size = 50
    end
    object StringField9: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
  end
  object TAlgoCacheoEstado: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'oid_algo_est'
        DataType = ftInteger
      end
      item
        Name = 'oid_algo_cacheo'
        DataType = ftInteger
      end
      item
        Name = 'oid_estado_cip'
        DataType = ftInteger
      end
      item
        Name = 'activo'
        DataType = ftBoolean
      end
      item
        Name = 'orden'
        DataType = ftInteger
      end>
    IndexFieldNames = 'oid_algo_cacheo;orden'
    IndexDefs = <
      item
        Name = 'TAlgoCacheoEstadoIndex1'
        Fields = 'oid_algo_cacheo;orden'
      end>
    RecalcOnFetch = False
    SortOptions = []
    PersistentBackup = False
    ProgressFlags = [mtpcLoad, mtpcSave, mtpcCopy]
    VersioningMode = mtvmAllSinceCheckPoint
    FilterOptions = []
    MasterFields = 'oid_algo_cacheo'
    MasterSource = DSTAlgoritmoCacheo
    Version = '4.08b'
    LanguageID = 0
    SortID = 0
    SubLanguageID = 1
    LocaleID = 1024
    MensajeValorDuplicadoIndice = 'Valor Duplicado'
    Left = 600
    Top = 100
    object TAlgoCacheoEstadooid_algo_est: TIntegerField
      FieldName = 'oid_algo_est'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TAlgoCacheoEstadooid_algo_cacheo: TIntegerField
      FieldName = 'oid_algo_cacheo'
    end
    object TAlgoCacheoEstadooid_estado_cip: TIntegerField
      FieldName = 'oid_estado_cip'
    end
    object TAlgoCacheoEstadoactivo: TBooleanField
      FieldName = 'activo'
    end
    object TAlgoCacheoEstadoorden: TIntegerField
      AutoGenerateValue = arAutoInc
      FieldName = 'orden'
    end
  end
  object DSAlgoCacheoEstado: TDataSource
    DataSet = TAlgoCacheoEstado
    Left = 632
    Top = 100
  end
  object DSEstados: TDataSource
    DataSet = TEstados
    Left = 417
    Top = 310
  end
  object TExclusionFecha: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'oid_exc_fec'
        DataType = ftInteger
      end
      item
        Name = 'oid_algo_cacheo'
        DataType = ftInteger
      end
      item
        Name = 'fecha'
        DataType = ftDate
      end
      item
        Name = 'activo'
        DataType = ftBoolean
      end>
    IndexFieldNames = 'oid_algo_cacheo'
    IndexDefs = <
      item
        Name = 'TExclusionFechaIndex1'
        Fields = 'oid_algo_cacheo'
      end>
    RecalcOnFetch = False
    SortOptions = []
    PersistentBackup = False
    ProgressFlags = [mtpcLoad, mtpcSave, mtpcCopy]
    VersioningMode = mtvmAllSinceCheckPoint
    FilterOptions = []
    MasterFields = 'oid_algo_cacheo'
    MasterSource = DSTAlgoritmoCacheo
    Version = '4.08b'
    LanguageID = 0
    SortID = 0
    SubLanguageID = 1
    LocaleID = 1024
    MensajeValorDuplicadoIndice = 'Valor Duplicado'
    Left = 672
    Top = 100
    object TExclusionFechaoid_exc_fec: TIntegerField
      FieldName = 'oid_exc_fec'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TExclusionFechaoid_algo_cacheo: TIntegerField
      FieldName = 'oid_algo_cacheo'
    end
    object TExclusionFechafecha: TDateField
      FieldName = 'fecha'
    end
    object TExclusionFechaactivo: TBooleanField
      FieldName = 'activo'
    end
  end
  object DSExclusionFecha: TDataSource
    DataSet = TExclusionFecha
    Left = 704
    Top = 100
  end
end
