inherited FCronoDesa: TFCronoDesa
  Left = 107
  Top = 117
  Width = 871
  Height = 771
  Caption = 'Cronograma de Desarrollo'
  PixelsPerInch = 96
  TextHeight = 13
  inherited PForm: TPanel
    Width = 855
    Height = 733
    inherited PPie: TPanel
      Top = 712
      Width = 855
      inherited StatusBarABM: TStatusBar
        Left = 750
      end
      inherited StatusBar2: TStatusBar
        Width = 750
      end
    end
    inherited PMenu: TPanel
      Width = 855
      inherited ImagenEliminar: TImagenEstado
        DataField = 'activo'
        DataSource = DSTCronogramaDesa
        ValorEstadoVisible = 'True'
      end
      inherited ImagenRehabilitar: TImagenEstado
        DataField = 'activo'
        DataSource = DSTCronogramaDesa
        ValorEstadoVisible = 'False'
      end
      inherited ImagenBuscar: TImagenHelpObjNeg
        Help = HelpCronogramas
      end
      inherited ImagenSiguiente: TImagenHelpObjNeg
        Help = HelpCronogramas
      end
      inherited ImagenAnterior: TImagenHelpObjNeg
        Help = HelpCronogramas
      end
      inherited Panel2: TPanel
        Left = 814
      end
      inherited PanelEstadoON: TPanelEstado
        DataField = 'activo'
        DataSource = DSTCronogramaDesa
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
      Width = 855
    end
    inherited PCabecera: TPanel
      Width = 855
      Height = 77
      object Label1: TLabel
        Left = 32
        Top = 8
        Width = 33
        Height = 13
        Caption = 'C'#243'digo'
      end
      object Label3: TLabel
        Left = 32
        Top = 47
        Width = 71
        Height = 13
        Caption = 'Observaciones'
      end
      object Label2: TLabel
        Left = 32
        Top = 29
        Width = 56
        Height = 13
        Caption = 'Descripci'#243'n'
      end
      object DBECodigo: TsnDBEdit
        Left = 148
        Top = 4
        DataBinding.DataField = 'codigo'
        DataBinding.DataSource = DSTCronogramaDesa
        Properties.CharCase = ecUpperCase
        Properties.MaxLength = 50
        Style.BorderColor = clWindowFrame
        Style.Shadow = False
        TabOrder = 0
        Width = 133
      end
      object snDBMemo1: TsnDBMemo
        Left = 148
        Top = 46
        DataBinding.DataField = 'observaciones'
        DataBinding.DataSource = DSTCronogramaDesa
        Properties.MaxLength = 3990
        Properties.WantTabs = True
        TabOrder = 2
        ReadOnlyAlways = False
        Height = 32
        Width = 557
      end
      object snDBEdit1: TsnDBEdit
        Left = 148
        Top = 25
        DataBinding.DataField = 'descripcion'
        DataBinding.DataSource = DSTCronogramaDesa
        Properties.CharCase = ecUpperCase
        Properties.MaxLength = 100
        Style.BorderColor = clWindowFrame
        Style.Shadow = False
        TabOrder = 1
        Width = 557
      end
    end
    inherited PCuerpo: TPanel
      Top = 129
      Width = 855
      Height = 583
      object Splitter1: TSplitter
        Left = 0
        Top = 136
        Width = 855
        Height = 5
        Cursor = crVSplit
        Align = alTop
        Color = 33023
        ParentColor = False
      end
      object Panel1: TPanel
        Left = 0
        Top = 0
        Width = 855
        Height = 136
        Align = alTop
        BevelOuter = bvNone
        BorderWidth = 5
        Color = clWindow
        TabOrder = 0
        object Panel4: TPanel
          Left = 5
          Top = 5
          Width = 845
          Height = 13
          Align = alTop
          BevelOuter = bvNone
          Color = clWindow
          TabOrder = 0
          object Label4: TLabel
            Left = 8
            Top = 0
            Width = 163
            Height = 16
            Caption = 'Acciones del Programa'
            Font.Charset = DEFAULT_CHARSET
            Font.Color = clNavy
            Font.Height = -13
            Font.Name = 'MS Sans Serif'
            Font.Style = [fsBold]
            ParentFont = False
          end
        end
        object Panel5: TPanel
          Left = 5
          Top = 18
          Width = 845
          Height = 113
          Align = alClient
          BevelOuter = bvNone
          BorderWidth = 5
          Color = clWindow
          TabOrder = 1
          object dxDBGridSN1: TdxDBGridSN
            Left = 5
            Top = 5
            Width = 835
            Height = 103
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
              DataController.DataSource = DSTAccCronoDesa
              DataController.Summary.DefaultGroupSummaryItems = <>
              DataController.Summary.FooterSummaryItems = <>
              DataController.Summary.SummaryGroups = <>
              OptionsBehavior.FocusCellOnTab = True
              OptionsBehavior.FocusFirstCellOnNewRecord = True
              OptionsBehavior.GoToNextCellOnEnter = True
              OptionsBehavior.FocusCellOnCycle = True
              OptionsCustomize.ColumnFiltering = False
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
                Width = 49
              end
              object dxDBGridSN1DBTableView1accion: TcxGridDBColumn
                Caption = 'Acci'#243'n'
                DataBinding.FieldName = 'accion'
                PropertiesClassName = 'TcxMemoProperties'
                HeaderAlignmentHorz = taCenter
                Width = 149
              end
              object dxDBGridSN1DBTableView1Column3: TcxGridDBColumn
                Caption = 'Sector'
                DataBinding.FieldName = 'sector'
                PropertiesClassName = 'TcxMemoProperties'
                GroupSummaryAlignment = taCenter
                HeaderAlignmentHorz = taCenter
                HeaderAlignmentVert = vaCenter
                Width = 150
              end
              object dxDBGridSN1DBTableView1revision: TcxGridDBColumn
                Caption = 'Revisi'#243'n'
                DataBinding.FieldName = 'revision'
                PropertiesClassName = 'TcxMemoProperties'
                HeaderAlignmentHorz = taCenter
                Width = 135
              end
              object dxDBGridSN1DBTableView1Observaciones: TcxGridDBColumn
                Caption = 'Requisitos'
                DataBinding.FieldName = 'Observaciones'
                PropertiesClassName = 'TcxMemoProperties'
                HeaderAlignmentHorz = taCenter
                Width = 168
              end
              object dxDBGridSN1DBTableView1Column1: TcxGridDBColumn
                Caption = 'Categor'#237'a Posible'
                DataBinding.FieldName = 'oid_categ_posible'
                PropertiesClassName = 'TcxLookupComboBoxProperties'
                Properties.DropDownWidth = 250
                Properties.KeyFieldNames = 'oid'
                Properties.ListColumns = <
                  item
                    FieldName = 'descripcion'
                  end>
                Properties.ListOptions.ShowHeader = False
                Properties.ListSource = DSCategorias
                HeaderAlignmentHorz = taCenter
                Width = 161
              end
              object dxDBGridSN1DBTableView1Column4: TcxGridDBColumn
                Caption = 'Par'#225'metros'
                DataBinding.FieldName = 'parametros'
                PropertiesClassName = 'TcxMemoProperties'
                HeaderAlignmentHorz = taCenter
                Width = 150
              end
              object dxDBGridSN1DBTableView1Column2: TcxGridDBColumn
                Caption = 'Rankear'
                DataBinding.FieldName = 'oid_rankear'
                PropertiesClassName = 'TcxLookupComboBoxProperties'
                Properties.KeyFieldNames = 'oid'
                Properties.ListColumns = <
                  item
                    FieldName = 'descripcion'
                  end>
                Properties.ListOptions.ShowHeader = False
                Properties.ListSource = DSHelpRankear
                HeaderAlignmentHorz = taCenter
                HeaderGlyphAlignmentHorz = taCenter
                Width = 79
              end
              object dxDBGridSN1DBTableView1activo: TcxGridDBColumn
                Caption = 'Activo'
                DataBinding.FieldName = 'activo'
                PropertiesClassName = 'TcxCheckBoxProperties'
                HeaderAlignmentHorz = taCenter
                Width = 43
              end
            end
            object dxDBGridSN1Level1: TcxGridLevel
              GridView = dxDBGridSN1DBTableView1
            end
          end
        end
      end
      object Panel3: TPanel
        Left = 0
        Top = 141
        Width = 855
        Height = 442
        Align = alClient
        Color = clWindow
        TabOrder = 1
        object Panel6: TPanel
          Left = 1
          Top = 1
          Width = 853
          Height = 21
          Align = alTop
          BevelOuter = bvNone
          Color = clWindow
          TabOrder = 0
          object snLabel1: TsnLabel
            Left = 16
            Top = 1
            Width = 148
            Height = 16
            Caption = 'Acci'#243'n Seleccionada'
            Font.Charset = DEFAULT_CHARSET
            Font.Color = clNavy
            Font.Height = -13
            Font.Name = 'MS Sans Serif'
            Font.Style = [fsBold]
            ParentFont = False
          end
          object snDBEdit2: TsnDBEdit
            Left = 176
            Top = -1
            DataBinding.DataField = 'accion'
            DataBinding.DataSource = DSTAccCronoDesa
            TabOrder = 0
            Width = 569
          end
        end
        object Panel7: TPanel
          Left = 1
          Top = 22
          Width = 853
          Height = 419
          Align = alClient
          BevelOuter = bvNone
          Color = clWindow
          TabOrder = 1
          object PageControlSN1: TPageControlSN
            Left = 0
            Top = 0
            Width = 853
            Height = 419
            ActivePage = TabSheet1
            Align = alClient
            TabOrder = 0
            object TabSheet1: TTabSheet
              Caption = 'Segmentaci'#243'n'
              object snDBTreeList1: TsnDBTreeList
                Left = 0
                Top = 0
                Width = 845
                Height = 391
                Align = alClient
                Bands = <
                  item
                  end>
                BufferedPaint = False
                DataController.DataSource = DSSegmentacion
                DataController.ImageIndexFieldName = 'image_index'
                DataController.ParentField = 'secu_padre'
                DataController.KeyField = 'secu'
                LookAndFeel.Kind = lfFlat
                OptionsBehavior.ConfirmDelete = False
                OptionsBehavior.DragCollapse = False
                OptionsData.Deleting = False
                OptionsView.CellAutoHeight = True
                RootValue = -1
                TabOrder = 0
                object snDBTreeList1descripcion: TcxDBTreeListColumn
                  Caption.AlignHorz = taCenter
                  Caption.Text = 'Categor'#237'a Actual'
                  DataBinding.FieldName = 'descripcion'
                  Options.Editing = False
                  Width = 291
                  Position.ColIndex = 1
                  Position.RowIndex = 0
                  Position.BandIndex = 0
                  SortOrder = soAscending
                end
                object snDBTreeList1habilitado: TcxDBTreeListColumn
                  Caption.AlignHorz = taCenter
                  Caption.Text = 'Incluir?'
                  DataBinding.FieldName = 'habilitado'
                  Width = 45
                  Position.ColIndex = 3
                  Position.RowIndex = 0
                  Position.BandIndex = 0
                end
                object snDBTreeList1secu: TcxDBTreeListColumn
                  Visible = False
                  DataBinding.FieldName = 'secu'
                  Position.ColIndex = 2
                  Position.RowIndex = 0
                  Position.BandIndex = 0
                end
                object snDBTreeList1secu_padre: TcxDBTreeListColumn
                  Visible = False
                  DataBinding.FieldName = 'secu_padre'
                  Position.ColIndex = 5
                  Position.RowIndex = 0
                  Position.BandIndex = 0
                end
                object snDBTreeList1cxDBTreeListColumn1: TcxDBTreeListColumn
                  Caption.AlignHorz = taCenter
                  Caption.Text = 'Orden'
                  Width = 75
                  Position.ColIndex = 0
                  Position.RowIndex = 0
                  Position.BandIndex = 0
                end
                object snDBTreeList1cxDBTreeListColumn2: TcxDBTreeListColumn
                  PropertiesClassName = 'TcxLookupComboBoxProperties'
                  Properties.KeyFieldNames = 'oid'
                  Properties.ListColumns = <
                    item
                      FieldName = 'descripcion'
                    end>
                  Properties.ListOptions.ShowHeader = False
                  Properties.ListSource = DSCategorias
                  Caption.AlignHorz = taCenter
                  Caption.Text = 'Categor'#237'a Posible'
                  DataBinding.FieldName = 'oid_categ_posible'
                  Width = 165
                  Position.ColIndex = 4
                  Position.RowIndex = 0
                  Position.BandIndex = 0
                end
                object snDBTreeList1cxDBTreeListColumn3: TcxDBTreeListColumn
                  Caption.AlignHorz = taCenter
                  Caption.Text = 'A'#241'os Req.'
                  DataBinding.FieldName = 'cant_anios_puesto'
                  Width = 65
                  Position.ColIndex = 7
                  Position.RowIndex = 0
                  Position.BandIndex = 0
                end
                object snDBTreeList1cxDBTreeListColumn4: TcxDBTreeListColumn
                  Caption.AlignHorz = taCenter
                  Caption.Text = 'Meses Req.'
                  DataBinding.FieldName = 'cant_meses_puesto'
                  Width = 67
                  Position.ColIndex = 8
                  Position.RowIndex = 0
                  Position.BandIndex = 0
                end
                object snDBTreeList1cxDBTreeListColumn5: TcxDBTreeListColumn
                  PropertiesClassName = 'TcxLookupComboBoxProperties'
                  Properties.KeyFieldNames = 'oid'
                  Properties.ListColumns = <
                    item
                      FieldName = 'descripcion'
                    end>
                  Properties.ListOptions.ShowHeader = False
                  Properties.ListSource = DSHelpRankear
                  Caption.AlignHorz = taCenter
                  Caption.Text = 'Rankear'
                  DataBinding.FieldName = 'oid_rankear_cab'
                  Width = 100
                  Position.ColIndex = 13
                  Position.RowIndex = 0
                  Position.BandIndex = 0
                end
                object snDBTreeList1cxDBTreeListColumn6: TcxDBTreeListColumn
                  Caption.AlignHorz = taCenter
                  Caption.Text = 'Ptos.M'#237'n.Eval.Des.'
                  DataBinding.FieldName = 'ptos_min_eval'
                  Width = 105
                  Position.ColIndex = 9
                  Position.RowIndex = 0
                  Position.BandIndex = 0
                end
                object snDBTreeList1cxDBTreeListColumn7: TcxDBTreeListColumn
                  Caption.AlignHorz = taCenter
                  Caption.Text = 'Cant. Juegos A'
                  DataBinding.FieldName = 'cant_min_juegos_a'
                  Width = 100
                  Position.ColIndex = 6
                  Position.RowIndex = 0
                  Position.BandIndex = 0
                end
                object snDBTreeList1cxDBTreeListColumn8: TcxDBTreeListColumn
                  Caption.AlignHorz = taCenter
                  Caption.Text = 'Cant. A'#241'os H.C.'
                  DataBinding.FieldName = 'cant_anios_hc'
                  Width = 100
                  Position.ColIndex = 11
                  Position.RowIndex = 0
                  Position.BandIndex = 0
                end
                object snDBTreeList1cxDBTreeListColumn9: TcxDBTreeListColumn
                  Caption.AlignHorz = taCenter
                  Caption.Text = 'Cant. Meses H.C.'
                  DataBinding.FieldName = 'cant_meses_hc'
                  Width = 100
                  Position.ColIndex = 12
                  Position.RowIndex = 0
                  Position.BandIndex = 0
                end
                object snDBTreeList1cxDBTreeListColumn10: TcxDBTreeListColumn
                  Caption.Text = 'Ptos.Min.Calig.Gen.'
                  DataBinding.FieldName = 'ptos_min_calif_gen'
                  Width = 100
                  Position.ColIndex = 10
                  Position.RowIndex = 0
                  Position.BandIndex = 0
                end
                object snDBTreeList1cxDBTreeListColumn11: TcxDBTreeListColumn
                  Caption.AlignHorz = taCenter
                  Caption.Text = 'Meses Eval. Pot.'
                  DataBinding.FieldName = 'ult_meses_eval_pot'
                  Width = 100
                  Position.ColIndex = 19
                  Position.RowIndex = 0
                  Position.BandIndex = 0
                end
                object snDBTreeList1cxDBTreeListColumn12: TcxDBTreeListColumn
                  PropertiesClassName = 'TcxCheckBoxProperties'
                  Caption.Text = 'Eval. Pend. Sin Eval. Desemp.'
                  DataBinding.FieldName = 'eval_pend_sin_eval'
                  Width = 159
                  Position.ColIndex = 14
                  Position.RowIndex = 0
                  Position.BandIndex = 0
                end
                object snDBTreeList1cxDBTreeListColumn13: TcxDBTreeListColumn
                  PropertiesClassName = 'TcxCheckBoxProperties'
                  Caption.Text = 'Eval. Pend. sin Juegos'
                  DataBinding.FieldName = 'eval_pend_sin_jue'
                  Width = 122
                  Position.ColIndex = 15
                  Position.RowIndex = 0
                  Position.BandIndex = 0
                end
                object snDBTreeList1cxDBTreeListColumn14: TcxDBTreeListColumn
                  PropertiesClassName = 'TcxCheckBoxProperties'
                  Caption.AlignHorz = taCenter
                  Caption.Text = 'Eval. Pend. sin IRL'
                  DataBinding.FieldName = 'eval_pend_sin_irl'
                  Width = 112
                  Position.ColIndex = 16
                  Position.RowIndex = 0
                  Position.BandIndex = 0
                end
                object snDBTreeList1cxDBTreeListColumn15: TcxDBTreeListColumn
                  PropertiesClassName = 'TcxCheckBoxProperties'
                  Caption.AlignHorz = taCenter
                  Caption.Text = 'Eval. Pend. sin E.Pot.'
                  DataBinding.FieldName = 'eval_pend_sin_pot'
                  Width = 120
                  Position.ColIndex = 18
                  Position.RowIndex = 0
                  Position.BandIndex = 0
                end
                object snDBTreeList1cxDBTreeListColumn17: TcxDBTreeListColumn
                  Caption.AlignHorz = taCenter
                  Caption.Text = 'Meses IRL'
                  DataBinding.FieldName = 'ult_meses_irl'
                  Width = 100
                  Position.ColIndex = 17
                  Position.RowIndex = 0
                  Position.BandIndex = 0
                end
              end
            end
            object TabSheet2: TTabSheet
              Caption = 'Estados Habilitados'
              ImageIndex = 1
              object dxDBGridSN2: TdxDBGridSN
                Left = 0
                Top = 0
                Width = 845
                Height = 378
                Align = alClient
                TabOrder = 0
                LookAndFeel.Kind = lfFlat
                CriteriosPintarCelda = <>
                object cxGridDBTableView1: TcxGridDBTableView
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
                  DataController.DataSource = DSEstados
                  DataController.Summary.DefaultGroupSummaryItems = <>
                  DataController.Summary.FooterSummaryItems = <>
                  DataController.Summary.SummaryGroups = <>
                  OptionsBehavior.FocusCellOnTab = True
                  OptionsBehavior.FocusFirstCellOnNewRecord = True
                  OptionsBehavior.GoToNextCellOnEnter = True
                  OptionsBehavior.FocusCellOnCycle = True
                  OptionsCustomize.ColumnFiltering = False
                  OptionsData.Deleting = False
                  OptionsData.DeletingConfirmation = False
                  OptionsData.Inserting = False
                  OptionsSelection.HideFocusRectOnExit = False
                  OptionsSelection.InvertSelect = False
                  OptionsView.Navigator = True
                  OptionsView.CellAutoHeight = True
                  OptionsView.GroupByBox = False
                  object cxGridDBTableView1activo: TcxGridDBColumn
                    Caption = 'Incorporar?'
                    DataBinding.FieldName = 'activo'
                    PropertiesClassName = 'TcxCheckBoxProperties'
                    HeaderAlignmentHorz = taCenter
                    Width = 91
                  end
                  object cxGridDBTableView1desc_val_clasif_est: TcxGridDBColumn
                    Caption = 'Estado'
                    DataBinding.FieldName = 'desc_val_clasif_est'
                    HeaderAlignmentHorz = taCenter
                    Options.Editing = False
                    Width = 321
                  end
                end
                object cxGridLevel1: TcxGridLevel
                  GridView = cxGridDBTableView1
                end
              end
            end
            object TabSheet3: TTabSheet
              Caption = 'Meses a Evaluar'
              ImageIndex = 2
              object dxDBGridSN3: TdxDBGridSN
                Left = 0
                Top = 0
                Width = 845
                Height = 378
                Align = alClient
                TabOrder = 0
                LookAndFeel.Kind = lfFlat
                CriteriosPintarCelda = <>
                object cxGridDBTableView2: TcxGridDBTableView
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
                  DataController.DataSource = DSMesesAEvalau
                  DataController.Summary.DefaultGroupSummaryItems = <>
                  DataController.Summary.FooterSummaryItems = <>
                  DataController.Summary.SummaryGroups = <>
                  OptionsBehavior.FocusCellOnTab = True
                  OptionsBehavior.FocusFirstCellOnNewRecord = True
                  OptionsBehavior.GoToNextCellOnEnter = True
                  OptionsBehavior.FocusCellOnCycle = True
                  OptionsCustomize.ColumnFiltering = False
                  OptionsData.Deleting = False
                  OptionsData.DeletingConfirmation = False
                  OptionsData.Inserting = False
                  OptionsSelection.HideFocusRectOnExit = False
                  OptionsSelection.InvertSelect = False
                  OptionsView.Navigator = True
                  OptionsView.CellAutoHeight = True
                  OptionsView.GroupByBox = False
                  object cxGridDBColumn2: TcxGridDBColumn
                    Caption = 'Evaluar?'
                    DataBinding.FieldName = 'activo'
                    PropertiesClassName = 'TcxCheckBoxProperties'
                    HeaderAlignmentHorz = taCenter
                    Width = 84
                  end
                  object cxGridDBColumn1: TcxGridDBColumn
                    Caption = 'Mes'
                    DataBinding.FieldName = 'desc_mes'
                    HeaderAlignmentHorz = taCenter
                    Options.Editing = False
                    Width = 253
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
    end
  end
  inherited DriverABM: TDriverABM
    OperTraerObjeto = 'TraerCronogramaDesa'
    OperGrabarObjeto = 'SaveCronogramaDesa'
    CargaDataSets = <
      item
        DataSet = TCronogramaDesa
        TableName = 'TCronogramaDesa'
      end
      item
        DataSet = TAccCronoDesa
        TableName = 'TAccCronoDesa'
      end
      item
        DataSet = TEstados
        TableName = 'TEstados'
      end
      item
        DataSet = TMesesAEvaluar
        TableName = 'TMesesAEvaluar'
      end
      item
        DataSet = TSegmentacion
        TableName = 'TSegmentacion'
      end
      item
        DataSet = TAltaSegmentacion
        TableName = 'TAltaSegmentacion'
      end
      item
        DataSet = TAltaEstados
        TableName = 'TAltaEstados'
      end
      item
        DataSet = TAltaMesesAEvaluar
        TableName = 'TAltaMesesAEvaluar'
      end
      item
        DataSet = TCategorias
        TableName = 'TCategorias'
      end>
    BajaLogica = <
      item
        DataSet = TCronogramaDesa
        ValorBaja = 'false'
        ValorRehabilitacion = 'true'
        TipoBajaRegistro = tblCurrentRecord
        FieldName = 'activo'
      end>
    OperHabilitadas = [toOperNuevo, toOperModificar, toOperEliminar, toOperBuscar, toOperNavegacion, toOperRehabilitar]
    DataSetCab = TCronogramaDesa
    DataSetDet1 = TAccCronoDesa
    DataSetDet2 = TEstados
    DataSetDet3 = TMesesAEvaluar
    DataSetDet4 = TSegmentacion
    ControlFocoAlta = DBECodigo
    ControlFocoModif = DBECodigo
    Left = 512
    Top = 16
  end
  inherited Operacion: TOperacion
    Left = 560
    Top = 16
  end
  object TCronogramaDesa: TsnTable [3]
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'oid_crono_desa'
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
        Name = 'observaciones'
        DataType = ftString
        Size = 4000
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
    object TCronogramaDesaoid_crono_desa: TIntegerField
      FieldName = 'oid_crono_desa'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TCronogramaDesacodigo: TStringField
      DisplayWidth = 50
      FieldName = 'codigo'
      Size = 50
    end
    object TCronogramaDesadescripcion: TStringField
      DisplayWidth = 100
      FieldName = 'descripcion'
      Size = 100
    end
    object TCronogramaDesaobservaciones: TStringField
      FieldName = 'observaciones'
      Size = 4000
    end
    object TCronogramaDesaactivo: TBooleanField
      DefaultExpression = '1'
      FieldName = 'activo'
    end
  end
  object DSTCronogramaDesa: TDataSource [4]
    DataSet = TCronogramaDesa
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
    Left = 344
    Top = 80
    inherited dxComponentPrinterLink1: TdxCustomContainerReportLink
      Component = Owner
      BuiltInReportLink = True
      HiddenComponents = {}
      ExcludedComponents = {}
      AggregatedReportLinks = {}
    end
  end
  inherited SaveDialog: TSaveDialog
    Left = 456
    Top = 80
  end
  inherited DriverEvent: TDriverEvent
    OnValidate = <
      item
        TableName = 'TCronogramaDesa'
        FieldName = 'codigo'
        Source.Strings = (
          'begin'
          '  ValidadorCronograma.Value := Sender.AsString;'
          '  ValidadorCronograma.Validar;'
          'end.')
      end>
    OnBeforePost = <
      item
        TableName = 'TCronogramaDesa'
        Source.Strings = (
          'begin'
          '  if (DataSet.FieldName('#39'codigo'#39').AsString='#39#39')'
          
            '     then raiseException(erCustomError,'#39'Debe ingresar el c'#243'digo'#39 +
            ');'
          '  if (DataSet.FieldName('#39'descripcion'#39').AsString='#39#39')'
          
            '     then raiseException(erCustomError,'#39'Debe ingresar la Descrip' +
            'ci'#243'n'#39');'
          'end.')
      end
      item
        TableName = 'TAccCronoDesa'
        Source.Strings = (
          'begin'
          '  if (DataSet.FieldName('#39'orden'#39').AsInteger = 0)'
          
            '     then raiseException(erCustomError,'#39'Debe ingresar el Orden'#39')' +
            ';'
          '  if (DataSet.FieldName('#39'accion'#39').AsString = '#39#39')'
          
            '     then raiseException(erCustomError,'#39'Debe ingresar la Acci'#243'n'#39 +
            ');'
          'end.')
      end>
    OnNuevoRegistro = <
      item
        TableName = 'TCronogramaDesa'
        Source.Strings = (
          'begin'
          '  DataSet.FieldName('#39'activo'#39').AsBoolean := True;'
          'end.')
      end
      item
        TableName = 'TAccCronoDesa'
        Source.Strings = (
          'begin'
          
            '  DataSet.FieldName('#39'orden'#39').AsInteger := TAccCronoDesa.getMaxNr' +
            'o('#39'orden'#39')+1;'
          
            '  DataSet.FieldName('#39'oid_cronograma'#39').AsInteger := TCronogramaDe' +
            'sa.FieldName('#39'oid_crono_desa'#39').AsInteger;'
          '  DataSet.FieldName('#39'activo'#39').AsBoolean := True;  '
          '  altaAccion();'
          ''
          ''
          ''
          'end.')
      end
      item
        TableName = 'TEstados'
        Source.Strings = (
          'begin'
          
            '  DataSet.FieldName('#39'oid_accion_cro'#39').AsInteger := TAccCronoDesa' +
            '.FieldName('#39'oid_accion_cro'#39').AsInteger;'
          '  DataSet.FieldName('#39'activo'#39').AsBoolean := False;'
          'end.')
      end
      item
        TableName = 'TMesesAEvaluar'
        Source.Strings = (
          'begin'
          
            '  DataSet.FieldName('#39'oid_accion_cro'#39').AsInteger := TAccCronoDesa' +
            '.FieldName('#39'oid_accion_cro'#39').AsInteger;'
          '  DataSet.FieldName('#39'activo'#39').AsBoolean := True;'
          'end.')
      end>
    OnInicializar = <
      item
        Source.Strings = (
          'begin'
          '  TraerCategoriasLegajo();'
          '  THelpRankear.loadFromHelp('#39'HelpRankear'#39'); '
          'end.')
      end>
    OnFormFunction = <
      item
        Source.Strings = (
          ''
          ''
          'procedure llenarRegAltaAccion();'
          'begin'
          ''
          '  TEstados.desHabilitarAllEvents;'
          '  TSegmentacion.desHabilitarAllEvents;'
          '  TMesesAEvaluar.desHabilitarAllEvents;'
          ''
          '   try'
          ' '
          '  TEstados.AppendRecords(TAltaEstados.getDataSet);'
          '  TMesesAEvaluar.AppendRecords(TAltaMesesAEvaluar.getDataSet);'
          '  TSegmentacion.AppendRecords(TAltaSegmentacion.getDataSet);'
          ''
          '     finally'
          ''
          '      TEstados.HabilitarAllEvents;'
          '      TSegmentacion.HabilitarAllEvents;'
          '      TMesesAEvaluar.HabilitarAllEvents;'
          ''
          '      TEstados.First; '
          '      TSegmentacion.First;'
          '      TMesesAEvaluar.First;'
          ''
          '      snDBTreeList1.FullCollapse();'
          ''
          '     end;'
          ''
          '  '
          'end;'
          ''
          'procedure altaAccion();'
          'begin'
          ''
          '  operacion.InicioOperacion();'
          '  operacion.setOper('#39'AltaAccionCronograma'#39');'
          
            '  operacion.AddAtribute('#39'oid_accion'#39', TAccCronoDesa.FieldName('#39'o' +
            'id_accion_cro'#39').AsString);'
          '  operacion.execute();'
          ''
          '  llenarRegAltaAccion();'
          ''
          'end;'
          ''
          'procedure TraerCategoriasLegajo();'
          'begin'
          '   operacion.InicioOperacion();'
          '   operacion.setOper('#39'TraerCategoriasLegajo'#39');'
          ' operacion.execute();'
          'end;'
          '')
      end>
    Left = 424
    Top = 83
  end
  inherited SaveArchivo: TSaveDialog
    Top = 176
  end
  inherited ImprimirObjetoSeleccionado: TdxComponentPrinter
    inherited ImprimirObjetoSeleccionadodxComponentPrinterLink: TdxGridReportLink
      BuiltInReportLink = True
    end
  end
  inherited PopUp: TsnPopUp
    Left = 385
    Top = 80
  end
  inherited TDataSetOidObjSave: TsnTable
    Left = 464
    Top = 187
  end
  object HelpCronogramas: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'rh.CronogramaDesa'
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
    Titulo = 'Cronogramas'
    AnchoHelp = 600
    ActivarCache = False
    ShowBotonBuscar = False
    Left = 50
    Top = 28
  end
  object ValidadorCronograma: TValidador
    Operacion = Operacion
    NickNameObjLog = 'rh.CronogramaDesa'
    WhenRaiseException = teFound
    MensajeException = 'C'#243'digo de Cronograma duplicado'
    NroQuery = 0
    Cache = False
    Left = 136
    Top = 51
  end
  object TAccCronoDesa: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'oid_accion_cro'
        DataType = ftInteger
      end
      item
        Name = 'oid_cronograma'
        DataType = ftInteger
      end
      item
        Name = 'orden'
        DataType = ftInteger
      end
      item
        Name = 'accion'
        DataType = ftString
        Size = 500
      end
      item
        Name = 'revision'
        DataType = ftString
        Size = 500
      end
      item
        Name = 'Observaciones'
        DataType = ftString
        Size = 1000
      end
      item
        Name = 'activo'
        DataType = ftBoolean
      end>
    IndexFieldNames = 'oid_cronograma;orden'
    IndexDefs = <
      item
        Name = 'TAccCronoDesaIndex1'
        Fields = 'oid_cronograma;orden'
      end>
    RecalcOnFetch = False
    SortOptions = []
    PersistentBackup = False
    ProgressFlags = [mtpcLoad, mtpcSave, mtpcCopy]
    VersioningMode = mtvmAllSinceCheckPoint
    FilterOptions = []
    MasterFields = 'oid_crono_desa'
    MasterSource = DSTCronogramaDesa
    Version = '4.08b'
    LanguageID = 0
    SortID = 0
    SubLanguageID = 1
    LocaleID = 1024
    MensajeValorDuplicadoIndice = 'Valor Duplicado'
    Left = 648
    Top = 100
    object TAccCronoDesaoid_accion_cro: TIntegerField
      FieldName = 'oid_accion_cro'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TAccCronoDesaoid_cronograma: TIntegerField
      FieldName = 'oid_cronograma'
    end
    object TAccCronoDesaorden: TIntegerField
      FieldName = 'orden'
    end
    object TAccCronoDesaaccion: TStringField
      FieldName = 'accion'
      Size = 500
    end
    object TAccCronoDesarevision: TStringField
      FieldName = 'revision'
      Size = 500
    end
    object TAccCronoDesaObservaciones: TStringField
      FieldName = 'Observaciones'
      Size = 1000
    end
    object TAccCronoDesaactivo: TBooleanField
      FieldName = 'activo'
    end
    object TAccCronoDesaoid_categ_posible: TIntegerField
      FieldName = 'oid_categ_posible'
    end
    object TAccCronoDesaoid_rankear: TIntegerField
      FieldName = 'oid_rankear'
    end
    object TAccCronoDesasector: TStringField
      FieldName = 'sector'
      Size = 1000
    end
    object TAccCronoDesaparametros: TStringField
      FieldName = 'parametros'
      Size = 1000
    end
  end
  object DSTAccCronoDesa: TDataSource
    DataSet = TAccCronoDesa
    Left = 680
    Top = 100
  end
  object TEstados: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'oid_estado_acc_cro'
        DataType = ftInteger
      end
      item
        Name = 'oid_accion_cro'
        DataType = ftInteger
      end
      item
        Name = 'oid_val_clasif_est'
        DataType = ftInteger
      end
      item
        Name = 'desc_val_clasif_est'
        DataType = ftString
        Size = 100
      end
      item
        Name = 'activo'
        DataType = ftBoolean
      end>
    IndexFieldNames = 'oid_accion_cro'
    IndexDefs = <
      item
        Name = 'TEstadosIndex1'
        Fields = 'oid_accion_cro'
      end>
    RecalcOnFetch = False
    SortOptions = []
    PersistentBackup = False
    ProgressFlags = [mtpcLoad, mtpcSave, mtpcCopy]
    VersioningMode = mtvmAllSinceCheckPoint
    FilterOptions = []
    MasterFields = 'oid_accion_cro'
    MasterSource = DSTAccCronoDesa
    Version = '4.08b'
    LanguageID = 0
    SortID = 0
    SubLanguageID = 1
    LocaleID = 1024
    MensajeValorDuplicadoIndice = 'Valor Duplicado'
    Left = 528
    Top = 180
    object TEstadosoid_estado_acc_cro: TIntegerField
      FieldName = 'oid_estado_acc_cro'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TEstadosoid_accion_cro: TIntegerField
      FieldName = 'oid_accion_cro'
    end
    object TEstadosoid_val_clasif_est: TIntegerField
      FieldName = 'oid_val_clasif_est'
    end
    object TEstadosdesc_val_clasif_est: TStringField
      FieldName = 'desc_val_clasif_est'
      Size = 100
    end
    object TEstadosactivo: TBooleanField
      FieldName = 'activo'
    end
  end
  object DSEstados: TDataSource
    DataSet = TEstados
    Left = 560
    Top = 180
  end
  object TMesesAEvaluar: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'oid_mes_a_eval'
        DataType = ftInteger
      end
      item
        Name = 'orden'
        DataType = ftInteger
      end
      item
        Name = 'oid_accion_cro'
        DataType = ftInteger
      end
      item
        Name = 'mes'
        DataType = ftString
        Size = 5
      end
      item
        Name = 'activo'
        DataType = ftBoolean
      end>
    IndexFieldNames = 'oid_accion_cro'
    IndexDefs = <
      item
        Name = 'TMesesAEvaluarIndex1'
        Fields = 'oid_accion_cro'
      end>
    RecalcOnFetch = False
    SortOptions = []
    PersistentBackup = False
    ProgressFlags = [mtpcLoad, mtpcSave, mtpcCopy]
    VersioningMode = mtvmAllSinceCheckPoint
    FilterOptions = []
    MasterFields = 'oid_accion_cro'
    MasterSource = DSTAccCronoDesa
    Version = '4.08b'
    LanguageID = 0
    SortID = 0
    SubLanguageID = 1
    LocaleID = 1024
    MensajeValorDuplicadoIndice = 'Valor Duplicado'
    Left = 608
    Top = 180
    object TMesesAEvaluaroid_mes_a_eval: TIntegerField
      FieldName = 'oid_mes_a_eval'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TMesesAEvaluarorden: TIntegerField
      FieldName = 'orden'
    end
    object TMesesAEvaluaroid_accion_cro: TIntegerField
      FieldName = 'oid_accion_cro'
    end
    object TMesesAEvaluarmes: TStringField
      FieldName = 'mes'
      Size = 5
    end
    object TMesesAEvaluardesc_mes: TStringField
      FieldName = 'desc_mes'
      Size = 100
    end
    object TMesesAEvaluaractivo: TBooleanField
      FieldName = 'activo'
    end
  end
  object DSMesesAEvalau: TDataSource
    DataSet = TMesesAEvaluar
    Left = 640
    Top = 180
  end
  object TSegmentacion: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'oid_segmentacion'
        DataType = ftInteger
      end
      item
        Name = 'oid_accion_cro'
        DataType = ftInteger
      end
      item
        Name = 'descripcion'
        DataType = ftString
        Size = 100
      end
      item
        Name = 'habilitado'
        DataType = ftBoolean
      end
      item
        Name = 'secu'
        DataType = ftString
        Size = 100
      end
      item
        Name = 'secu_padre'
        DataType = ftString
        Size = 100
      end
      item
        Name = 'oid_val_clasif_emp'
        DataType = ftInteger
      end
      item
        Name = 'oid_val_clasif_sec'
        DataType = ftInteger
      end
      item
        Name = 'oid_val_clasif_pue'
        DataType = ftInteger
      end>
    IndexFieldNames = 'oid_accion_cro'
    IndexDefs = <
      item
        Name = 'TSegmentacionIndex1'
        Fields = 'oid_accion_cro'
      end>
    RecalcOnFetch = False
    SortOptions = []
    PersistentBackup = False
    ProgressFlags = [mtpcLoad, mtpcSave, mtpcCopy]
    VersioningMode = mtvmAllSinceCheckPoint
    FilterOptions = []
    MasterFields = 'oid_accion_cro'
    MasterSource = DSTAccCronoDesa
    Version = '4.08b'
    LanguageID = 0
    SortID = 0
    SubLanguageID = 1
    LocaleID = 1024
    MensajeValorDuplicadoIndice = 'Valor Duplicado'
    Left = 688
    Top = 180
    object TSegmentacionoid_segmentacion: TIntegerField
      FieldName = 'oid_segmentacion'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TSegmentacionoid_accion_cro: TIntegerField
      FieldName = 'oid_accion_cro'
    end
    object TSegmentaciondescripcion: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
    object TSegmentacionhabilitado: TBooleanField
      FieldName = 'habilitado'
    end
    object TSegmentacionsecu: TStringField
      FieldName = 'secu'
      Size = 100
    end
    object TSegmentacionsecu_padre: TStringField
      FieldName = 'secu_padre'
      Size = 100
    end
    object TSegmentacionoid_val_clasif_emp: TIntegerField
      FieldName = 'oid_val_clasif_emp'
    end
    object TSegmentacionoid_val_clasif_sec: TIntegerField
      FieldName = 'oid_val_clasif_sec'
    end
    object TSegmentacionoid_val_clasif_pue: TIntegerField
      FieldName = 'oid_val_clasif_pue'
    end
    object TSegmentacionorden: TIntegerField
      FieldName = 'orden'
    end
    object TSegmentacionoid_categ_posible: TIntegerField
      FieldName = 'oid_categ_posible'
    end
    object TSegmentacioncant_anios_puesto: TIntegerField
      FieldName = 'cant_anios_puesto'
    end
    object TSegmentacioncant_meses_puesto: TIntegerField
      FieldName = 'cant_meses_puesto'
    end
    object TSegmentacionoid_rankear_cab: TIntegerField
      FieldName = 'oid_rankear_cab'
    end
    object TSegmentacionptos_min_eval: TCurrencyField
      FieldName = 'ptos_min_eval'
      DisplayFormat = '###,###,###.##'
    end
    object TSegmentacioncant_min_juegos_a: TIntegerField
      FieldName = 'cant_min_juegos_a'
    end
    object TSegmentacioncant_anios_hc: TIntegerField
      FieldName = 'cant_anios_hc'
    end
    object TSegmentacioncant_meses_hc: TIntegerField
      FieldName = 'cant_meses_hc'
    end
    object TSegmentacionptos_min_calif_gen: TCurrencyField
      FieldName = 'ptos_min_calif_gen'
      DisplayFormat = '###,###,###.##'
    end
    object TSegmentacionult_meses_eval_pot: TIntegerField
      FieldName = 'ult_meses_eval_pot'
    end
    object TSegmentacioneval_pend_sin_eval: TBooleanField
      FieldName = 'eval_pend_sin_eval'
    end
    object TSegmentacioneval_pend_sin_jue: TBooleanField
      FieldName = 'eval_pend_sin_jue'
    end
    object TSegmentacioneval_pend_sin_irl: TBooleanField
      FieldName = 'eval_pend_sin_irl'
    end
    object TSegmentacionult_meses_irl: TIntegerField
      FieldName = 'ult_meses_irl'
    end
    object TSegmentacioneval_pend_sin_pot: TBooleanField
      FieldName = 'eval_pend_sin_pot'
    end
  end
  object DSSegmentacion: TDataSource
    DataSet = TSegmentacion
    Left = 720
    Top = 180
  end
  object TAltaSegmentacion: TsnTable
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
    Left = 141
    Top = 300
    object TAltaSegmentacionoid_segmentacion: TIntegerField
      FieldName = 'oid_segmentacion'
    end
    object TAltaSegmentacionoid_accion_cro: TIntegerField
      FieldName = 'oid_accion_cro'
    end
    object TAltaSegmentaciondescripcion: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
    object TAltaSegmentacionhabilitado: TBooleanField
      FieldName = 'habilitado'
    end
    object TAltaSegmentacionsecu: TStringField
      FieldName = 'secu'
      Size = 100
    end
    object TAltaSegmentacionsecu_padre: TStringField
      FieldName = 'secu_padre'
      Size = 100
    end
    object TAltaSegmentacionoid_val_clasif_emp: TIntegerField
      FieldName = 'oid_val_clasif_emp'
    end
    object TAltaSegmentacionoid_val_clasif_sec: TIntegerField
      FieldName = 'oid_val_clasif_sec'
    end
    object TAltaSegmentacionoid_val_clasif_pue: TIntegerField
      FieldName = 'oid_val_clasif_pue'
    end
    object TAltaSegmentacionorden: TIntegerField
      FieldName = 'orden'
    end
  end
  object TAltaEstados: TsnTable
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
    Left = 189
    Top = 300
    object TAltaEstadosoid_estado_acc_cro: TIntegerField
      FieldName = 'oid_estado_acc_cro'
    end
    object TAltaEstadosoid_accion_cro: TIntegerField
      FieldName = 'oid_accion_cro'
    end
    object TAltaEstadosoid_val_clasif_est: TIntegerField
      FieldName = 'oid_val_clasif_est'
    end
    object TAltaEstadosdesc_val_clasif_est: TStringField
      FieldName = 'desc_val_clasif_est'
      Size = 100
    end
    object TAltaEstadosactivo: TBooleanField
      FieldName = 'activo'
    end
  end
  object TAltaMesesAEvaluar: TsnTable
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
    Left = 237
    Top = 300
    object TAltaMesesAEvaluaroid_mes_a_eval: TIntegerField
      FieldName = 'oid_mes_a_eval'
    end
    object TAltaMesesAEvaluaroid_accion_cro: TIntegerField
      FieldName = 'oid_accion_cro'
    end
    object TAltaMesesAEvaluarmes: TStringField
      FieldName = 'mes'
      Size = 5
    end
    object TAltaMesesAEvaluardesc_mes: TStringField
      FieldName = 'desc_mes'
      Size = 100
    end
    object TAltaMesesAEvaluaractivo: TBooleanField
      FieldName = 'activo'
    end
    object TAltaMesesAEvaluarorden: TIntegerField
      FieldName = 'orden'
    end
  end
  object TCategorias: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <>
    IndexFieldNames = 'descripcion'
    IndexDefs = <
      item
        Name = 'TCategoriasIndex1'
        Fields = 'descripcion'
      end>
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
    Left = 437
    Top = 548
    object TCategoriasoid: TIntegerField
      FieldName = 'oid'
    end
    object TCategoriascodigo: TStringField
      FieldName = 'codigo'
      Size = 50
    end
    object TCategoriasdescripcion: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
  end
  object DSCategorias: TDataSource
    DataSet = TCategorias
    Left = 477
    Top = 548
  end
  object HelpRankear: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'rh.RankearCab'
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
    Titulo = 'Rankear'
    AnchoHelp = 600
    ActivarCache = False
    ShowBotonBuscar = False
    Left = 258
    Top = 536
  end
  object THelpRankear: TsnTable
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
    Left = 292
    Top = 532
    object THelpRankearoid: TIntegerField
      FieldName = 'oid'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object THelpRankearcodigo: TStringField
      FieldName = 'codigo'
      Size = 50
    end
    object THelpRankeardescripcion: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
    object THelpRankearactivo: TBooleanField
      FieldName = 'activo'
    end
  end
  object DSHelpRankear: TDataSource
    DataSet = THelpRankear
    Left = 325
    Top = 534
  end
end
