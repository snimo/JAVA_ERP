inherited FPermIntPuertas: TFPermIntPuertas
  Left = 374
  Top = 4
  Width = 855
  Height = 574
  Caption = 'Permisos Sobre Puertas'
  PixelsPerInch = 96
  TextHeight = 13
  inherited PForm: TPanel
    Width = 839
    Height = 536
    inherited PPie: TPanel
      Top = 515
      Width = 839
      inherited StatusBarABM: TStatusBar
        Left = 734
      end
      inherited StatusBar2: TStatusBar
        Width = 734
      end
    end
    inherited PMenu: TPanel
      Width = 839
      inherited ImagenEliminar: TImagenEstado
        DataField = 'activo'
        DataSource = DSTPermisosInternos
        ValorEstadoVisible = 'True'
      end
      inherited ImagenRehabilitar: TImagenEstado
        DataField = 'activo'
        DataSource = DSTPermisosInternos
        ValorEstadoVisible = 'False'
      end
      inherited ImagenBuscar: TImagenHelpObjNeg
        Help = HelpPermisosInternos
      end
      inherited ImagenSiguiente: TImagenHelpObjNeg
        Help = HelpPermisosInternos
      end
      inherited ImagenAnterior: TImagenHelpObjNeg
        Help = HelpPermisosInternos
      end
      inherited Panel2: TPanel
        Left = 798
      end
      inherited PanelEstadoON: TPanelEstado
        DataField = 'activo'
        DataSource = DSTPermisosInternos
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
      Width = 839
    end
    inherited PCabecera: TPanel
      Width = 839
      Height = 85
      object Label1: TLabel
        Left = 24
        Top = 16
        Width = 33
        Height = 13
        Caption = 'C'#243'digo'
      end
      object Label2: TLabel
        Left = 240
        Top = 16
        Width = 56
        Height = 13
        Caption = 'Descripci'#243'n'
      end
      object Label3: TLabel
        Left = 24
        Top = 48
        Width = 41
        Height = 13
        Caption = 'Prioridad'
      end
      object DBECodigo: TsnDBEdit
        Left = 84
        Top = 12
        DataBinding.DataField = 'codigo'
        DataBinding.DataSource = DSTPermisosInternos
        Properties.CharCase = ecUpperCase
        Properties.MaxLength = 20
        Style.BorderColor = clWindowFrame
        Style.Shadow = False
        TabOrder = 0
        Width = 133
      end
      object snDBEdit1: TsnDBEdit
        Left = 308
        Top = 12
        DataBinding.DataField = 'descripcion'
        DataBinding.DataSource = DSTPermisosInternos
        Properties.MaxLength = 50
        Style.BorderColor = clWindowFrame
        Style.Shadow = False
        TabOrder = 1
        Width = 429
      end
      object snDBEdit2: TsnDBEdit
        Left = 84
        Top = 44
        DataBinding.DataField = 'prioridad'
        DataBinding.DataSource = DSTPermisosInternos
        Properties.CharCase = ecUpperCase
        Properties.MaxLength = 20
        Style.BorderColor = clWindowFrame
        Style.Shadow = False
        TabOrder = 2
        Width = 37
      end
    end
    inherited PCuerpo: TPanel
      Top = 137
      Width = 839
      Height = 378
      object Splitter1: TSplitter
        Left = 0
        Top = 127
        Width = 839
        Height = 3
        Cursor = crVSplit
        Align = alTop
      end
      object Panel1: TPanel
        Left = 0
        Top = 0
        Width = 839
        Height = 127
        Align = alTop
        BorderWidth = 5
        Color = clWindow
        TabOrder = 0
        object dxDBGridSN1: TdxDBGridSN
          Left = 6
          Top = 6
          Width = 827
          Height = 115
          Align = alClient
          TabOrder = 0
          LookAndFeel.Kind = lfFlat
          CriteriosPintarCelda = <>
          object dxDBGridSN1DBTableView1: TcxGridDBTableView
            NavigatorButtons.ConfirmDelete = False
            NavigatorButtons.First.Enabled = False
            NavigatorButtons.First.Visible = False
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
            NavigatorButtons.Edit.Visible = False
            NavigatorButtons.Post.Enabled = False
            NavigatorButtons.Post.Visible = False
            NavigatorButtons.Cancel.Enabled = False
            NavigatorButtons.Cancel.Visible = False
            NavigatorButtons.Refresh.Visible = False
            NavigatorButtons.SaveBookmark.Visible = False
            NavigatorButtons.GotoBookmark.Enabled = False
            NavigatorButtons.GotoBookmark.Visible = False
            NavigatorButtons.Filter.Enabled = False
            NavigatorButtons.Filter.Visible = False
            DataController.DataSource = DSTReglasPermisosInt
            DataController.Summary.DefaultGroupSummaryItems = <>
            DataController.Summary.FooterSummaryItems = <>
            DataController.Summary.SummaryGroups = <>
            OptionsBehavior.FocusCellOnTab = True
            OptionsBehavior.FocusFirstCellOnNewRecord = True
            OptionsBehavior.GoToNextCellOnEnter = True
            OptionsBehavior.FocusCellOnCycle = True
            OptionsData.Appending = True
            OptionsData.CancelOnExit = False
            OptionsData.Deleting = False
            OptionsData.DeletingConfirmation = False
            OptionsSelection.InvertSelect = False
            OptionsView.Navigator = True
            OptionsView.CellAutoHeight = True
            OptionsView.GroupByBox = False
            object dxDBGridSN1DBTableView1prioridad: TcxGridDBColumn
              Caption = 'Prioridad'
              DataBinding.FieldName = 'prioridad'
              HeaderAlignmentVert = vaCenter
              SortIndex = 0
              SortOrder = soAscending
              Width = 73
            end
            object dxDBGridSN1DBTableView1descripcion: TcxGridDBColumn
              Caption = 'Descripci'#243'n'
              DataBinding.FieldName = 'descripcion'
              HeaderAlignmentHorz = taCenter
              Width = 501
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
      object Panel3: TPanel
        Left = 0
        Top = 130
        Width = 839
        Height = 248
        Align = alClient
        Color = clWindow
        TabOrder = 1
        object PageControlSN1: TPageControlSN
          Left = 1
          Top = 1
          Width = 837
          Height = 246
          ActivePage = TabSheet1
          Align = alClient
          TabOrder = 0
          object TabSheet1: TTabSheet
            Caption = 'Puertas '
            object dxDBGridSN2: TdxDBGridSN
              Left = 0
              Top = 0
              Width = 829
              Height = 218
              Align = alClient
              TabOrder = 0
              LookAndFeel.Kind = lfFlat
              CriteriosPintarCelda = <>
              object cxGridDBTableView1: TcxGridDBTableView
                NavigatorButtons.ConfirmDelete = False
                NavigatorButtons.First.Enabled = False
                NavigatorButtons.First.Visible = False
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
                NavigatorButtons.Edit.Visible = False
                NavigatorButtons.Post.Enabled = False
                NavigatorButtons.Post.Visible = False
                NavigatorButtons.Cancel.Enabled = False
                NavigatorButtons.Cancel.Visible = False
                NavigatorButtons.Refresh.Visible = False
                NavigatorButtons.SaveBookmark.Visible = False
                NavigatorButtons.GotoBookmark.Enabled = False
                NavigatorButtons.GotoBookmark.Visible = False
                NavigatorButtons.Filter.Enabled = False
                NavigatorButtons.Filter.Visible = False
                DataController.DataSource = DSTAccesoInternoPuerta
                DataController.Summary.DefaultGroupSummaryItems = <>
                DataController.Summary.FooterSummaryItems = <>
                DataController.Summary.SummaryGroups = <>
                OptionsBehavior.FocusCellOnTab = True
                OptionsBehavior.FocusFirstCellOnNewRecord = True
                OptionsBehavior.GoToNextCellOnEnter = True
                OptionsBehavior.FocusCellOnCycle = True
                OptionsData.Appending = True
                OptionsData.CancelOnExit = False
                OptionsData.Deleting = False
                OptionsData.DeletingConfirmation = False
                OptionsSelection.InvertSelect = False
                OptionsView.Navigator = True
                OptionsView.CellAutoHeight = True
                OptionsView.GroupByBox = False
                object cxGridDBTableView1Column1: TcxGridDBColumn
                  Caption = 'Orden'
                  DataBinding.FieldName = 'secu'
                  Width = 50
                end
                object cxGridDBTableView1Column2: TcxGridDBColumn
                  Caption = 'Puerta'
                  HeaderAlignmentHorz = taCenter
                  Width = 94
                end
                object cxGridDBTableView1Column3: TcxGridDBColumn
                  Caption = 'Desc. Puerta'
                  DataBinding.FieldName = 'desc_puerta'
                  Width = 185
                end
                object cxGridDBTableView1precond_entrada: TcxGridDBColumn
                  DataBinding.FieldName = 'precond_entrada'
                  Width = 50
                end
                object cxGridDBTableView1tipo_compo_entra: TcxGridDBColumn
                  DataBinding.FieldName = 'tipo_compo_entra'
                  Width = 50
                end
                object cxGridDBTableView1precond_salida: TcxGridDBColumn
                  DataBinding.FieldName = 'precond_salida'
                  Width = 50
                end
                object cxGridDBTableView1tipo_compo_sali: TcxGridDBColumn
                  DataBinding.FieldName = 'tipo_compo_sali'
                  Width = 50
                end
                object cxGridDBTableView1activo: TcxGridDBColumn
                  DataBinding.FieldName = 'activo'
                  Width = 50
                end
              end
              object dxDBGridSN2DBBandedTableView1: TcxGridDBBandedTableView
                NavigatorButtons.ConfirmDelete = False
                DataController.DataSource = DSTAccesoInternoPuerta
                DataController.Summary.DefaultGroupSummaryItems = <>
                DataController.Summary.FooterSummaryItems = <>
                DataController.Summary.SummaryGroups = <>
                OptionsSelection.InvertSelect = False
                OptionsView.GroupByBox = False
                Bands = <
                  item
                    Width = 304
                  end
                  item
                    Caption = 'Entrada'
                    Width = 620
                  end
                  item
                    Caption = 'Salida'
                    Width = 600
                  end>
                object dxDBGridSN2DBBandedTableView1secu: TcxGridDBBandedColumn
                  Caption = 'Orden'
                  DataBinding.FieldName = 'secu'
                  Width = 37
                  Position.BandIndex = 0
                  Position.ColIndex = 0
                  Position.RowIndex = 0
                end
                object dxDBGridSN2DBBandedTableView1precond_entrada: TcxGridDBBandedColumn
                  Caption = 'Pre-Condici'#243'n'
                  DataBinding.FieldName = 'precond_entrada'
                  PropertiesClassName = 'TcxLookupComboBoxProperties'
                  Properties.KeyFieldNames = 'codigo'
                  Properties.ListColumns = <
                    item
                      FieldName = 'descripcion'
                    end>
                  Properties.ListOptions.ShowHeader = False
                  Properties.ListSource = DSPrecondiciones
                  HeaderAlignmentHorz = taCenter
                  Width = 94
                  Position.BandIndex = 1
                  Position.ColIndex = 0
                  Position.RowIndex = 0
                end
                object dxDBGridSN2DBBandedTableView1tipo_compo_entra: TcxGridDBBandedColumn
                  Caption = 'Acci'#243'n'
                  DataBinding.FieldName = 'tipo_compo_entra'
                  PropertiesClassName = 'TcxLookupComboBoxProperties'
                  Properties.KeyFieldNames = 'codigo'
                  Properties.ListColumns = <
                    item
                      FieldName = 'descripcion'
                    end>
                  Properties.ListOptions.ShowHeader = False
                  Properties.ListSource = DSAcciones
                  HeaderAlignmentHorz = taCenter
                  Width = 94
                  Position.BandIndex = 1
                  Position.ColIndex = 2
                  Position.RowIndex = 0
                end
                object dxDBGridSN2DBBandedTableView1precond_salida: TcxGridDBBandedColumn
                  Caption = 'Pre-Condici'#243'n'
                  DataBinding.FieldName = 'precond_salida'
                  PropertiesClassName = 'TcxLookupComboBoxProperties'
                  Properties.KeyFieldNames = 'codigo'
                  Properties.ListColumns = <
                    item
                      FieldName = 'descripcion'
                    end>
                  Properties.ListOptions.ShowHeader = False
                  Properties.ListSource = DSPrecondiciones
                  HeaderAlignmentHorz = taCenter
                  Width = 90
                  Position.BandIndex = 2
                  Position.ColIndex = 0
                  Position.RowIndex = 0
                end
                object dxDBGridSN2DBBandedTableView1tipo_compo_sali: TcxGridDBBandedColumn
                  Caption = 'Acci'#243'n'
                  DataBinding.FieldName = 'tipo_compo_sali'
                  PropertiesClassName = 'TcxLookupComboBoxProperties'
                  Properties.KeyFieldNames = 'codigo'
                  Properties.ListColumns = <
                    item
                      FieldName = 'descripcion'
                    end>
                  Properties.ListOptions.ShowHeader = False
                  Properties.ListSource = DSAcciones
                  HeaderAlignmentHorz = taCenter
                  Width = 89
                  Position.BandIndex = 2
                  Position.ColIndex = 2
                  Position.RowIndex = 0
                end
                object dxDBGridSN2DBBandedTableView1activo: TcxGridDBBandedColumn
                  Caption = 'Activo'
                  DataBinding.FieldName = 'activo'
                  PropertiesClassName = 'TcxCheckBoxProperties'
                  Width = 40
                  Position.BandIndex = 0
                  Position.ColIndex = 3
                  Position.RowIndex = 0
                end
                object dxDBGridSN2DBBandedTableView1cod_puerta: TcxGridDBBandedColumn
                  Caption = 'Puerta'
                  DataBinding.FieldName = 'cod_puerta'
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
                object dxDBGridSN2DBBandedTableView1desc_puerta: TcxGridDBBandedColumn
                  Caption = 'Desc. Puerta'
                  DataBinding.FieldName = 'desc_puerta'
                  HeaderAlignmentHorz = taCenter
                  Options.Editing = False
                  Options.Focusing = False
                  Width = 134
                  Position.BandIndex = 0
                  Position.ColIndex = 2
                  Position.RowIndex = 0
                end
                object dxDBGridSN2DBBandedTableView1Column1: TcxGridDBBandedColumn
                  Caption = 'Mensaje'
                  DataBinding.FieldName = 'mensaje_entrada'
                  HeaderAlignmentHorz = taCenter
                  Width = 59
                  Position.BandIndex = 1
                  Position.ColIndex = 3
                  Position.RowIndex = 0
                end
                object dxDBGridSN2DBBandedTableView1Column2: TcxGridDBBandedColumn
                  Caption = 'Mensaje'
                  DataBinding.FieldName = 'mensaje_salida'
                  HeaderAlignmentHorz = taCenter
                  Width = 120
                  Position.BandIndex = 2
                  Position.ColIndex = 3
                  Position.RowIndex = 0
                end
                object dxDBGridSN2DBBandedTableView1Column3: TcxGridDBBandedColumn
                  Caption = 'Controla Horario?'
                  DataBinding.FieldName = 'tipo_ctrl_fh_ent'
                  PropertiesClassName = 'TcxLookupComboBoxProperties'
                  Properties.KeyFieldNames = 'codigo'
                  Properties.ListColumns = <
                    item
                      FieldName = 'descripcion'
                    end>
                  Properties.ListOptions.ShowHeader = False
                  Properties.ListSource = DSControlarFranja
                  HeaderAlignmentHorz = taCenter
                  Width = 123
                  Position.BandIndex = 1
                  Position.ColIndex = 4
                  Position.RowIndex = 0
                end
                object dxDBGridSN2DBBandedTableView1Column4: TcxGridDBBandedColumn
                  Caption = 'Controla Horario?'
                  DataBinding.FieldName = 'tipo_ctrl_fh_sal'
                  PropertiesClassName = 'TcxLookupComboBoxProperties'
                  Properties.KeyFieldNames = 'codigo'
                  Properties.ListColumns = <
                    item
                      FieldName = 'descripcion'
                    end>
                  Properties.ListOptions.ShowHeader = False
                  Properties.ListSource = DSControlarFranja
                  HeaderAlignmentHorz = taCenter
                  Width = 88
                  Position.BandIndex = 2
                  Position.ColIndex = 4
                  Position.RowIndex = 0
                end
                object dxDBGridSN2DBBandedTableView1Column5: TcxGridDBBandedColumn
                  Caption = 'Min. Antes'
                  DataBinding.FieldName = 'min_ent_ant_fh_ent'
                  HeaderAlignmentHorz = taCenter
                  Width = 83
                  Position.BandIndex = 1
                  Position.ColIndex = 5
                  Position.RowIndex = 0
                end
                object dxDBGridSN2DBBandedTableView1Column6: TcxGridDBBandedColumn
                  Caption = 'Min. Antes '
                  DataBinding.FieldName = 'min_ent_ant_fh_sal'
                  HeaderAlignmentHorz = taCenter
                  Width = 72
                  Position.BandIndex = 2
                  Position.ColIndex = 5
                  Position.RowIndex = 0
                end
                object dxDBGridSN2DBBandedTableView1Column7: TcxGridDBBandedColumn
                  Caption = 'Min. Despu'#233's'
                  DataBinding.FieldName = 'min_ent_des_fh_ent'
                  HeaderAlignmentHorz = taCenter
                  Width = 104
                  Position.BandIndex = 1
                  Position.ColIndex = 6
                  Position.RowIndex = 0
                end
                object dxDBGridSN2DBBandedTableView1Column8: TcxGridDBBandedColumn
                  Caption = 'Min. Despu'#233's'
                  DataBinding.FieldName = 'min_ent_des_fh_sal'
                  HeaderAlignmentHorz = taCenter
                  Width = 72
                  Position.BandIndex = 2
                  Position.ColIndex = 6
                  Position.RowIndex = 0
                end
                object dxDBGridSN2DBBandedTableView1Column9: TcxGridDBBandedColumn
                  Caption = 'Ent. Sexo'
                  DataBinding.FieldName = 'ENT_SEXO'
                  PropertiesClassName = 'TcxLookupComboBoxProperties'
                  Properties.KeyFieldNames = 'codigo'
                  Properties.ListColumns = <
                    item
                      FieldName = 'descripcion'
                    end>
                  Properties.ListOptions.ShowHeader = False
                  Properties.ListSource = DSSexo
                  Width = 63
                  Position.BandIndex = 1
                  Position.ColIndex = 1
                  Position.RowIndex = 0
                end
                object dxDBGridSN2DBBandedTableView1Column10: TcxGridDBBandedColumn
                  Caption = 'Sal. Sexo'
                  DataBinding.FieldName = 'SAL_SEXO'
                  PropertiesClassName = 'TcxLookupComboBoxProperties'
                  Properties.KeyFieldNames = 'codigo'
                  Properties.ListColumns = <
                    item
                      FieldName = 'descripcion'
                    end>
                  Properties.ListOptions.ShowHeader = False
                  Properties.ListSource = DSSexo
                  Width = 69
                  Position.BandIndex = 2
                  Position.ColIndex = 1
                  Position.RowIndex = 0
                end
              end
              object cxGridLevel1: TcxGridLevel
                GridView = dxDBGridSN2DBBandedTableView1
              end
            end
          end
          object TabSheet2: TTabSheet
            BorderWidth = 5
            Caption = 'Definici'#243'n de Regla    '
            ImageIndex = 1
            object PageControl1: TPageControl
              Left = 0
              Top = 0
              Width = 819
              Height = 208
              ActivePage = TabSheet3
              Align = alClient
              TabOrder = 0
              object TabSheet3: TTabSheet
                Caption = 'Legajo   '
                object dxDBGridSN3: TdxDBGridSN
                  Left = 0
                  Top = 0
                  Width = 811
                  Height = 195
                  Align = alClient
                  TabOrder = 0
                  LookAndFeel.Kind = lfFlat
                  CriteriosPintarCelda = <>
                  object cxGridDBTableView2: TcxGridDBTableView
                    NavigatorButtons.ConfirmDelete = False
                    NavigatorButtons.First.Enabled = False
                    NavigatorButtons.First.Visible = False
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
                    NavigatorButtons.Edit.Visible = False
                    NavigatorButtons.Post.Enabled = False
                    NavigatorButtons.Post.Visible = False
                    NavigatorButtons.Cancel.Enabled = False
                    NavigatorButtons.Cancel.Visible = False
                    NavigatorButtons.Refresh.Visible = False
                    NavigatorButtons.SaveBookmark.Visible = False
                    NavigatorButtons.GotoBookmark.Enabled = False
                    NavigatorButtons.GotoBookmark.Visible = False
                    NavigatorButtons.Filter.Enabled = False
                    NavigatorButtons.Filter.Visible = False
                    DataController.DataSource = DSPermisosIntLeg
                    DataController.Summary.DefaultGroupSummaryItems = <>
                    DataController.Summary.FooterSummaryItems = <>
                    DataController.Summary.SummaryGroups = <>
                    OptionsBehavior.FocusCellOnTab = True
                    OptionsBehavior.FocusFirstCellOnNewRecord = True
                    OptionsBehavior.GoToNextCellOnEnter = True
                    OptionsBehavior.FocusCellOnCycle = True
                    OptionsData.Appending = True
                    OptionsData.CancelOnExit = False
                    OptionsData.Deleting = False
                    OptionsData.DeletingConfirmation = False
                    OptionsSelection.InvertSelect = False
                    OptionsView.Navigator = True
                    OptionsView.CellAutoHeight = True
                    OptionsView.GroupByBox = False
                    object cxGridDBTableView2legajo: TcxGridDBColumn
                      Caption = 'Legajo'
                      DataBinding.FieldName = 'legajo'
                      PropertiesClassName = 'TcxButtonEditProperties'
                      Properties.Buttons = <
                        item
                          Default = True
                          Kind = bkEllipsis
                        end>
                      HeaderAlignmentHorz = taCenter
                      Width = 123
                    end
                    object cxGridDBTableView2ape_y_nom: TcxGridDBColumn
                      Caption = 'Apellido y Nombre'
                      DataBinding.FieldName = 'ape_y_nom'
                      HeaderAlignmentHorz = taCenter
                      HeaderAlignmentVert = vaCenter
                      Options.Editing = False
                      Options.Focusing = False
                      SortIndex = 0
                      SortOrder = soAscending
                      Width = 289
                    end
                    object cxGridDBTableView2activo: TcxGridDBColumn
                      Caption = 'Activo'
                      DataBinding.FieldName = 'activo'
                      PropertiesClassName = 'TcxCheckBoxProperties'
                      HeaderAlignmentHorz = taCenter
                      HeaderAlignmentVert = vaCenter
                      Width = 58
                    end
                  end
                  object cxGridLevel2: TcxGridLevel
                    GridView = cxGridDBTableView2
                  end
                end
              end
              object TabSheet4: TTabSheet
                Caption = 'Empresa   '
                ImageIndex = 1
                object dxDBGridSN4: TdxDBGridSN
                  Left = 0
                  Top = 0
                  Width = 811
                  Height = 195
                  Align = alClient
                  TabOrder = 0
                  LookAndFeel.Kind = lfFlat
                  CriteriosPintarCelda = <>
                  object cxGridDBTableView3: TcxGridDBTableView
                    NavigatorButtons.ConfirmDelete = False
                    NavigatorButtons.First.Enabled = False
                    NavigatorButtons.First.Visible = False
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
                    NavigatorButtons.Edit.Visible = False
                    NavigatorButtons.Post.Enabled = False
                    NavigatorButtons.Post.Visible = False
                    NavigatorButtons.Cancel.Enabled = False
                    NavigatorButtons.Cancel.Visible = False
                    NavigatorButtons.Refresh.Visible = False
                    NavigatorButtons.SaveBookmark.Visible = False
                    NavigatorButtons.GotoBookmark.Enabled = False
                    NavigatorButtons.GotoBookmark.Visible = False
                    NavigatorButtons.Filter.Enabled = False
                    NavigatorButtons.Filter.Visible = False
                    DataController.DataSource = DSPermisoIntEmp
                    DataController.Summary.DefaultGroupSummaryItems = <>
                    DataController.Summary.FooterSummaryItems = <>
                    DataController.Summary.SummaryGroups = <>
                    OptionsBehavior.FocusCellOnTab = True
                    OptionsBehavior.FocusFirstCellOnNewRecord = True
                    OptionsBehavior.GoToNextCellOnEnter = True
                    OptionsBehavior.FocusCellOnCycle = True
                    OptionsData.Appending = True
                    OptionsData.CancelOnExit = False
                    OptionsData.Deleting = False
                    OptionsData.DeletingConfirmation = False
                    OptionsSelection.InvertSelect = False
                    OptionsView.Navigator = True
                    OptionsView.CellAutoHeight = True
                    OptionsView.GroupByBox = False
                    object cxGridDBColumn1: TcxGridDBColumn
                      Caption = 'Empresa'
                      DataBinding.FieldName = 'cod_val_clasif_emp'
                      PropertiesClassName = 'TcxButtonEditProperties'
                      Properties.Buttons = <
                        item
                          Default = True
                          Kind = bkEllipsis
                        end>
                      HeaderAlignmentHorz = taCenter
                      Options.Editing = False
                      Width = 123
                    end
                    object cxGridDBColumn2: TcxGridDBColumn
                      Caption = 'Raz'#243'n Social'
                      DataBinding.FieldName = 'desc_val_clasif_emp'
                      HeaderAlignmentHorz = taCenter
                      HeaderAlignmentVert = vaCenter
                      Options.Editing = False
                      Options.Focusing = False
                      SortIndex = 0
                      SortOrder = soAscending
                      Width = 289
                    end
                    object cxGridDBColumn3: TcxGridDBColumn
                      Caption = 'Activo'
                      DataBinding.FieldName = 'activo'
                      PropertiesClassName = 'TcxCheckBoxProperties'
                      HeaderAlignmentHorz = taCenter
                      HeaderAlignmentVert = vaCenter
                      Width = 58
                    end
                  end
                  object cxGridLevel3: TcxGridLevel
                    GridView = cxGridDBTableView3
                  end
                end
              end
              object TabSheet5: TTabSheet
                Caption = 'Sector   '
                ImageIndex = 2
                object dxDBGridSN5: TdxDBGridSN
                  Left = 0
                  Top = 0
                  Width = 811
                  Height = 195
                  Align = alClient
                  TabOrder = 0
                  LookAndFeel.Kind = lfFlat
                  CriteriosPintarCelda = <>
                  object cxGridDBTableView4: TcxGridDBTableView
                    NavigatorButtons.ConfirmDelete = False
                    NavigatorButtons.First.Enabled = False
                    NavigatorButtons.First.Visible = False
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
                    NavigatorButtons.Edit.Visible = False
                    NavigatorButtons.Post.Enabled = False
                    NavigatorButtons.Post.Visible = False
                    NavigatorButtons.Cancel.Enabled = False
                    NavigatorButtons.Cancel.Visible = False
                    NavigatorButtons.Refresh.Visible = False
                    NavigatorButtons.SaveBookmark.Visible = False
                    NavigatorButtons.GotoBookmark.Enabled = False
                    NavigatorButtons.GotoBookmark.Visible = False
                    NavigatorButtons.Filter.Enabled = False
                    NavigatorButtons.Filter.Visible = False
                    DataController.DataSource = DSPermisoIntSec
                    DataController.Summary.DefaultGroupSummaryItems = <>
                    DataController.Summary.FooterSummaryItems = <>
                    DataController.Summary.SummaryGroups = <>
                    OptionsBehavior.FocusCellOnTab = True
                    OptionsBehavior.FocusFirstCellOnNewRecord = True
                    OptionsBehavior.GoToNextCellOnEnter = True
                    OptionsBehavior.FocusCellOnCycle = True
                    OptionsData.Appending = True
                    OptionsData.CancelOnExit = False
                    OptionsData.Deleting = False
                    OptionsData.DeletingConfirmation = False
                    OptionsSelection.InvertSelect = False
                    OptionsView.Navigator = True
                    OptionsView.CellAutoHeight = True
                    OptionsView.GroupByBox = False
                    object cxGridDBColumn4: TcxGridDBColumn
                      Caption = 'Sector'
                      DataBinding.FieldName = 'cod_val_clasif_sec'
                      PropertiesClassName = 'TcxButtonEditProperties'
                      Properties.Buttons = <
                        item
                          Default = True
                          Kind = bkEllipsis
                        end>
                      HeaderAlignmentHorz = taCenter
                      Options.Editing = False
                      Width = 123
                    end
                    object cxGridDBColumn5: TcxGridDBColumn
                      Caption = 'Descripci'#243'n del Sector'
                      DataBinding.FieldName = 'desc_val_clasif_sec'
                      HeaderAlignmentHorz = taCenter
                      HeaderAlignmentVert = vaCenter
                      Options.Editing = False
                      Options.Focusing = False
                      SortIndex = 0
                      SortOrder = soAscending
                      Width = 289
                    end
                    object cxGridDBColumn6: TcxGridDBColumn
                      Caption = 'Activo'
                      DataBinding.FieldName = 'activo'
                      PropertiesClassName = 'TcxCheckBoxProperties'
                      HeaderAlignmentHorz = taCenter
                      HeaderAlignmentVert = vaCenter
                      Width = 58
                    end
                  end
                  object cxGridLevel4: TcxGridLevel
                    GridView = cxGridDBTableView4
                  end
                end
              end
              object TabSheet6: TTabSheet
                Caption = 'Estado   '
                ImageIndex = 3
                object dxDBGridSN7: TdxDBGridSN
                  Left = 0
                  Top = 0
                  Width = 811
                  Height = 195
                  Align = alClient
                  TabOrder = 0
                  LookAndFeel.Kind = lfFlat
                  CriteriosPintarCelda = <>
                  object cxGridDBTableView6: TcxGridDBTableView
                    NavigatorButtons.ConfirmDelete = False
                    NavigatorButtons.First.Enabled = False
                    NavigatorButtons.First.Visible = False
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
                    NavigatorButtons.Edit.Visible = False
                    NavigatorButtons.Post.Enabled = False
                    NavigatorButtons.Post.Visible = False
                    NavigatorButtons.Cancel.Enabled = False
                    NavigatorButtons.Cancel.Visible = False
                    NavigatorButtons.Refresh.Visible = False
                    NavigatorButtons.SaveBookmark.Visible = False
                    NavigatorButtons.GotoBookmark.Enabled = False
                    NavigatorButtons.GotoBookmark.Visible = False
                    NavigatorButtons.Filter.Enabled = False
                    NavigatorButtons.Filter.Visible = False
                    DataController.DataSource = DSTPermisoIntEst
                    DataController.Summary.DefaultGroupSummaryItems = <>
                    DataController.Summary.FooterSummaryItems = <>
                    DataController.Summary.SummaryGroups = <>
                    OptionsBehavior.FocusCellOnTab = True
                    OptionsBehavior.FocusFirstCellOnNewRecord = True
                    OptionsBehavior.GoToNextCellOnEnter = True
                    OptionsBehavior.FocusCellOnCycle = True
                    OptionsData.Appending = True
                    OptionsData.CancelOnExit = False
                    OptionsData.Deleting = False
                    OptionsData.DeletingConfirmation = False
                    OptionsSelection.InvertSelect = False
                    OptionsView.Navigator = True
                    OptionsView.CellAutoHeight = True
                    OptionsView.GroupByBox = False
                    object cxGridDBColumn11: TcxGridDBColumn
                      Caption = 'Descripci'#243'n Estado'
                      DataBinding.FieldName = 'desc_estado'
                      HeaderAlignmentHorz = taCenter
                      HeaderAlignmentVert = vaCenter
                      Options.Editing = False
                      Options.Focusing = False
                      SortIndex = 0
                      SortOrder = soAscending
                      Width = 289
                    end
                    object cxGridDBColumn12: TcxGridDBColumn
                      Caption = 'Activo'
                      DataBinding.FieldName = 'activo'
                      PropertiesClassName = 'TcxCheckBoxProperties'
                      HeaderAlignmentHorz = taCenter
                      HeaderAlignmentVert = vaCenter
                      Width = 58
                    end
                  end
                  object cxGridLevel6: TcxGridLevel
                    GridView = cxGridDBTableView6
                  end
                end
              end
              object TabSheet7: TTabSheet
                Caption = 'Puesto   '
                ImageIndex = 4
                object dxDBGridSN6: TdxDBGridSN
                  Left = 0
                  Top = 0
                  Width = 811
                  Height = 195
                  Align = alClient
                  TabOrder = 0
                  LookAndFeel.Kind = lfFlat
                  CriteriosPintarCelda = <>
                  object cxGridDBTableView5: TcxGridDBTableView
                    NavigatorButtons.ConfirmDelete = False
                    NavigatorButtons.First.Enabled = False
                    NavigatorButtons.First.Visible = False
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
                    NavigatorButtons.Edit.Visible = False
                    NavigatorButtons.Post.Enabled = False
                    NavigatorButtons.Post.Visible = False
                    NavigatorButtons.Cancel.Enabled = False
                    NavigatorButtons.Cancel.Visible = False
                    NavigatorButtons.Refresh.Visible = False
                    NavigatorButtons.SaveBookmark.Visible = False
                    NavigatorButtons.GotoBookmark.Enabled = False
                    NavigatorButtons.GotoBookmark.Visible = False
                    NavigatorButtons.Filter.Enabled = False
                    NavigatorButtons.Filter.Visible = False
                    DataController.DataSource = DSPermisoIntPue
                    DataController.Summary.DefaultGroupSummaryItems = <>
                    DataController.Summary.FooterSummaryItems = <>
                    DataController.Summary.SummaryGroups = <>
                    OptionsBehavior.FocusCellOnTab = True
                    OptionsBehavior.FocusFirstCellOnNewRecord = True
                    OptionsBehavior.GoToNextCellOnEnter = True
                    OptionsBehavior.FocusCellOnCycle = True
                    OptionsData.Appending = True
                    OptionsData.CancelOnExit = False
                    OptionsData.Deleting = False
                    OptionsData.DeletingConfirmation = False
                    OptionsSelection.InvertSelect = False
                    OptionsView.Navigator = True
                    OptionsView.CellAutoHeight = True
                    OptionsView.GroupByBox = False
                    object cxGridDBColumn7: TcxGridDBColumn
                      Caption = 'Puesto'
                      DataBinding.FieldName = 'cod_val_clasif_pue'
                      PropertiesClassName = 'TcxButtonEditProperties'
                      Properties.Buttons = <
                        item
                          Default = True
                          Kind = bkEllipsis
                        end>
                      HeaderAlignmentHorz = taCenter
                      Options.Editing = False
                      Width = 123
                    end
                    object cxGridDBColumn8: TcxGridDBColumn
                      Caption = 'Descripci'#243'n'
                      DataBinding.FieldName = 'desc_val_clasif_pue'
                      HeaderAlignmentHorz = taCenter
                      HeaderAlignmentVert = vaCenter
                      Options.Editing = False
                      Options.Focusing = False
                      SortIndex = 0
                      SortOrder = soAscending
                      Width = 289
                    end
                    object cxGridDBColumn9: TcxGridDBColumn
                      Caption = 'Activo'
                      DataBinding.FieldName = 'activo'
                      PropertiesClassName = 'TcxCheckBoxProperties'
                      HeaderAlignmentHorz = taCenter
                      HeaderAlignmentVert = vaCenter
                      Width = 58
                    end
                  end
                  object cxGridLevel5: TcxGridLevel
                    GridView = cxGridDBTableView5
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
    OperTraerObjeto = 'TraerPermisosInternos'
    OperGrabarObjeto = 'SavePermisosInternos'
    CargaDataSets = <
      item
        DataSet = TPermisosInternos
        TableName = 'TPermisosInternos'
      end
      item
        DataSet = TReglasPermisosInt
        TableName = 'TReglasPermisosInt'
      end
      item
        DataSet = TAccesoInternoPuerta
        TableName = 'TAccesoInternoPuerta'
      end
      item
        DataSet = TPrecondiciones
        TableName = 'TPrecondiciones'
      end
      item
        DataSet = TAcciones
        TableName = 'TAcciones'
      end
      item
        DataSet = TPermisoIntLeg
        TableName = 'TPermisoIntLeg'
      end
      item
        DataSet = TPermisoIntEmp
        TableName = 'TPermisoIntEmp'
      end
      item
        DataSet = TTempPermisoIntEmp
        TableName = 'TTempPermisoIntEmp'
      end
      item
        DataSet = TPermisoIntSec
        TableName = 'TPermisoIntSec'
      end
      item
        DataSet = TTempPermisoIntSec
        TableName = 'TTempPermisoIntSec'
      end
      item
        DataSet = TPermisoIntPue
        TableName = 'TPermisoIntPue'
      end
      item
        DataSet = TTempPermisoIntPue
        TableName = 'TTempPermisoIntPue'
      end
      item
        DataSet = TPermisoIntEst
        TableName = 'TPermisoIntEst'
      end
      item
        DataSet = TTempPermisoIntEst
        TableName = 'TTempPermisoIntEst'
      end>
    BajaLogica = <
      item
        DataSet = TPermisosInternos
        ValorBaja = 'false'
        ValorRehabilitacion = 'true'
        TipoBajaRegistro = tblCurrentRecord
        FieldName = 'activo'
      end>
    OperHabilitadas = [toOperNuevo, toOperModificar, toOperEliminar, toOperBuscar, toOperNavegacion, toOperRehabilitar]
    DataSetCab = TPermisosInternos
    DataSetDet1 = TReglasPermisosInt
    DataSetDet2 = TAccesoInternoPuerta
    DataSetDet3 = TPermisoIntLeg
    DataSetDet4 = TPermisoIntEmp
    DataSetDet5 = TPermisoIntSec
    DataSetDet6 = TPermisoIntPue
    DataSetDet7 = TPermisoIntEst
    ControlFocoAlta = DBECodigo
    ControlFocoModif = DBECodigo
    Left = 512
    Top = 16
  end
  inherited Operacion: TOperacion
    Left = 560
    Top = 16
  end
  object TPermisosInternos: TsnTable [3]
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'oid_permiso_int'
        DataType = ftInteger
      end
      item
        Name = 'codigo'
        DataType = ftString
        Size = 20
      end
      item
        Name = 'descripcion'
        DataType = ftString
        Size = 100
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
    object TPermisosInternosoid_permiso_int: TIntegerField
      FieldName = 'oid_permiso_int'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TPermisosInternoscodigo: TStringField
      DisplayWidth = 20
      FieldName = 'codigo'
    end
    object TPermisosInternosdescripcion: TStringField
      DisplayWidth = 100
      FieldName = 'descripcion'
      Size = 100
    end
    object TPermisosInternosactivo: TBooleanField
      DefaultExpression = '1'
      FieldName = 'activo'
    end
    object TPermisosInternosprioridad: TIntegerField
      FieldName = 'prioridad'
    end
  end
  object DSTPermisosInternos: TDataSource [4]
    DataSet = TPermisosInternos
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
    Left = 312
    Top = 8
    inherited dxComponentPrinterLink1: TdxCustomContainerReportLink
      Component = Owner
      BuiltInReportLink = True
      HiddenComponents = {}
      ExcludedComponents = {}
      AggregatedReportLinks = {}
    end
  end
  inherited SaveDialog: TSaveDialog
    Left = 424
    Top = 8
  end
  inherited DriverEvent: TDriverEvent
    OnValidate = <
      item
        TableName = 'TPermisosInternos'
        FieldName = 'codigo'
        Source.Strings = (
          'begin'
          '  ValidadorPermisosInternos.Value := Sender.AsString;'
          '  ValidadorPermisosInternos.Validar;'
          'end.')
      end
      item
        TableName = 'TAccesoInternoPuerta'
        FieldName = 'cod_puerta'
        Source.Strings = (
          'begin'
          '  ValidadorPuertas.Value := Sender.AsString;'
          '  ValidadorPuertas.Validar();'
          'end.')
      end
      item
        TableName = 'TPermisoIntLeg'
        FieldName = 'legajo'
        Source.Strings = (
          'begin'
          '  ValidadorLegajo.Value := Sender.AsString;'
          '  ValidadorLegajo.Validar();'
          'end.')
      end>
    OnBeforePost = <
      item
        TableName = 'TPermisosInternos'
        Source.Strings = (
          'begin'
          '  if (Trim(DataSet.FieldName('#39'codigo'#39').AsString)='#39#39')'
          
            '      then raiseException(erCustomError,'#39'Debe ingresar el c'#243'digo' +
            #39');'
          '  if (Trim(DataSet.FieldName('#39'descripcion'#39').AsString)='#39#39')'
          
            '      then raiseException(erCustomError,'#39'Debe ingresar la descri' +
            'pci'#243'n'#39');'
          'end.')
      end
      item
        TableName = 'TReglasPermisosInt'
        Source.Strings = (
          'begin'
          ''
          '   if (DataSet.FieldName('#39'prioridad'#39').AsInteger<=0)'
          
            '      then raiseException(erCustomError,'#39'Debe ingresar la priori' +
            'dad'#39');'
          ''
          '   if (DataSet.FieldName('#39'descripcion'#39').AsString='#39#39')'
          
            '      then raiseException(erCustomError,'#39'Debe ingresar la descri' +
            'pci'#243'n'#39');'
          ''
          'end.')
      end
      item
        TableName = 'TAccesoInternoPuerta'
        Source.Strings = (
          'begin'
          ''
          '  if (DataSet.FieldName('#39'oid_puerta'#39').AsInteger=0)'
          
            '     then raiseException(erCustomError,'#39'Debe ingresar la puerta'#39 +
            ');'
          '  if (DataSet.FieldName('#39'precond_entrada'#39').AsString='#39#39')'
          
            '     then raiseException(erCustomError,'#39'Debe ingresar la precond' +
            'ici'#243'n de entrada'#39');'
          '  if (DataSet.FieldName('#39'tipo_compo_entra'#39').AsString='#39#39')'
          
            '     then raiseException(erCustomError,'#39'Debe ingresar la acci'#243'n ' +
            'de entrada'#39');'
          '  if (DataSet.FieldName('#39'precond_salida'#39').AsString='#39#39')'
          
            '     then raiseException(erCustomError,'#39'Debe ingresar la precond' +
            'ici'#243'n de salida'#39');'
          '  if (DataSet.FieldName('#39'tipo_compo_sali'#39').AsString='#39#39')'
          
            '     then raiseException(erCustomError,'#39'Debe ingresar la acci'#243'n ' +
            'de salida'#39');'
          ''
          'end.')
      end
      item
        TableName = 'TPermisoIntLeg'
        Source.Strings = (
          'begin'
          '  if (DataSet.FieldName('#39'oid_legajo'#39').AsInteger = 0)'
          
            '     then raiseException(erCustomError,'#39'Debe ingresar el Nro. de' +
            ' Legajo'#39');'
          'end.')
      end>
    OnNuevoRegistro = <
      item
        TableName = 'TPermisosInternos'
        Source.Strings = (
          'begin'
          '  DataSet.FieldName('#39'activo'#39').Value := True;'
          'end.')
      end
      item
        TableName = 'TReglasPermisosInt'
        Source.Strings = (
          'begin'
          '   TReglasPermisosInt.FieldName('#39'oid_permiso_int'#39').AsInteger :='
          
            '               TPermisosInternos.FieldName('#39'oid_permiso_int'#39').As' +
            'Integer;'
          '   TReglasPermisosInt.FieldName('#39'activo'#39').AsBoolean := True;'
          '   AltaRegla();'
          'end.')
      end
      item
        TableName = 'TAccesoInternoPuerta'
        Source.Strings = (
          'begin'
          '  DataSet.FieldName('#39'activo'#39').Value := True;'
          
            '  DataSet.FieldName('#39'oid_regla_permiso'#39').AsInteger := TReglasPer' +
            'misosInt.FieldName('#39'oid_regla_permiso'#39').AsInteger;'
          
            '  DataSet.FieldName('#39'secu'#39').AsInteger := TAccesoInternoPuerta.ge' +
            'tMaxNro('#39'secu'#39');'
          'end.')
      end
      item
        TableName = 'TPermisoIntLeg'
        Source.Strings = (
          'begin'
          '  DataSet.FieldName('#39'activo'#39').Value := True;'
          '  DataSet.FieldName('#39'oid_regla_permiso'#39').AsInteger :='
          
            '      TReglasPermisosInt.FieldName('#39'oid_regla_permiso'#39').AsIntege' +
            'r;'
          'end.')
      end
      item
        TableName = 'TPermisoIntEmp'
        Source.Strings = (
          'begin'
          '  DataSet.FieldName('#39'activo'#39').Value := True;'
          '  DataSet.FieldName('#39'oid_regla_permiso'#39').AsInteger :='
          
            '      TReglasPermisosInt.FieldName('#39'oid_regla_permiso'#39').AsIntege' +
            'r;'
          'end.')
      end
      item
        TableName = 'TPermisoIntPue'
        Source.Strings = (
          'begin'
          '  DataSet.FieldName('#39'activo'#39').Value := True;'
          '  DataSet.FieldName('#39'oid_regla_permiso'#39').AsInteger :='
          
            '      TReglasPermisosInt.FieldName('#39'oid_regla_permiso'#39').AsIntege' +
            'r;'
          'end.')
      end
      item
        TableName = 'TPermisoIntEst'
        Source.Strings = (
          'begin'
          '  DataSet.FieldName('#39'activo'#39').Value := True;'
          '  DataSet.FieldName('#39'oid_regla_permiso'#39').AsInteger :='
          
            '      TReglasPermisosInt.FieldName('#39'oid_regla_permiso'#39').AsIntege' +
            'r;'
          'end.')
      end>
    OnInicializar = <
      item
        Source.Strings = (
          'begin'
          '  Inicializar();'
          '  ControlarFranja();'
          '  cargarSexo();'
          'end.')
      end>
    OnFormFunction = <
      item
        Source.Strings = (
          'procedure ControlarFranja();'
          'begin'
          ''
          '   TControlaFranja.Close;'
          '   TControlaFranja.Open;'
          ''
          '   TControlaFranja.AppendRecord;'
          '   TControlaFranja.FieldName('#39'codigo'#39').AsString := '#39'CONTROLA'#39';'
          
            '   TControlaFranja.FieldName('#39'descripcion'#39').AsString := '#39'Control' +
            'a'#39';'
          '   TControlaFranja.PostRecord;'
          ''
          '   TControlaFranja.AppendRecord;'
          
            '   TControlaFranja.FieldName('#39'codigo'#39').AsString := '#39'NO_CONTROLA'#39 +
            ';'
          
            '   TControlaFranja.FieldName('#39'descripcion'#39').AsString := '#39'No Cont' +
            'rola'#39';'
          '   TControlaFranja.PostRecord;'
          ' '
          'end;'
          ''
          'procedure Inicializar();'
          'begin'
          ''
          '  operacion.InicioOperacion();'
          '  operacion.setOper('#39'TraerPrecondAccIntPue'#39');'
          '  operacion.execute(); '
          ''
          '  operacion.InicioOperacion();'
          '  operacion.setOper('#39'TraerAccionAccIntPue'#39');'
          '  operacion.execute(); '
          ''
          'end;'
          ''
          'procedure AltaRegla();'
          'begin'
          ''
          '  operacion.InicioOperacion();'
          '  operacion.setOper('#39'TraerPermisosInternos'#39');'
          '  operacion.AddAtribute('#39'ALTA_REGLA'#39','#39#39');'
          
            '  operacion.AddAtribute('#39'oid_regla'#39', TReglasPermisosInt.FieldNam' +
            'e('#39'oid_regla_permiso'#39').AsString);'
          '  operacion.execute();'
          ''
          ''
          '  TPermisoIntEmp.deshabilitarControles;'
          '  TPermisoIntSec.deshabilitarControles;'
          '  TPermisoIntPue.deshabilitarControles;'
          '  TPermisoIntEst.deshabilitarControles;'
          ''
          '   TRY'
          ''
          ''
          '  TPermisoIntEmp.AppendRecords(TTempPermisoIntEmp.getDataSet);'
          '  TPermisoIntSec.AppendRecords(TTempPermisoIntSec.getDataSet);'
          '  TPermisoIntPue.AppendRecords(TTempPermisoIntPue.getDataSet);'
          '  TPermisoIntEst.AppendRecords(TTempPermisoIntEst.getDataSet);'
          ''
          '  FINALLY'
          '        TPermisoIntEmp.habilitarControles;'
          '    TPermisoIntSec.habilitarControles;'
          '    TPermisoIntPue.habilitarControles;'
          '   TPermisoIntEst.habilitarControles;'
          ''
          ''
          '  END;'
          ''
          'end;'
          ''
          'procedure cargarSexo();'
          'begin'
          '  TSexo.close;'
          '  TSexo.open;'
          ''
          '  TSexo.appendRecord;'
          '  TSexo.FieldName('#39'codigo'#39').AsString := '#39'M'#39';'
          '  TSexo.FieldName('#39'descripcion'#39').AsString := '#39'Masculino'#39'; '
          '  TSexo.PostRecord;'
          ''
          ' TSexo.appendRecord;'
          '  TSexo.FieldName('#39'codigo'#39').AsString := '#39'F'#39';'
          '  TSexo.FieldName('#39'descripcion'#39').AsString := '#39'Femenino'#39'; '
          '  TSexo.PostRecord;'
          ''
          ' TSexo.appendRecord;'
          '  TSexo.FieldName('#39'codigo'#39').AsString := '#39'AMBOS'#39';'
          '  TSexo.FieldName('#39'descripcion'#39').AsString := '#39'Ambos'#39'; '
          '  TSexo.PostRecord;'
          'end;')
      end>
    OnClickButtonColumn = <
      item
        ColumnName = 'dxDBGridSN2DBBandedTableView1cod_puerta'
        Source.Strings = (
          'begin'
          '  HelpPuertas.mostrar();'
          'end.')
      end
      item
        ColumnName = 'cxGridDBTableView2legajo'
        Source.Strings = (
          'begin'
          '  HelpLegajo.Mostrar();'
          'end.')
      end>
    Left = 392
    Top = 11
  end
  inherited ImprimirObjetoSeleccionado: TdxComponentPrinter
    inherited ImprimirObjetoSeleccionadodxComponentPrinterLink: TdxGridReportLink
      BuiltInReportLink = True
    end
  end
  inherited PopUp: TsnPopUp
    Left = 353
    Top = 8
  end
  inherited TDataSetOidObjSave: TsnTable
    Left = 424
    Top = 251
  end
  object HelpPermisosInternos: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'cip.PermisosInternos'
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
    Titulo = 'Permisos Internos'
    AnchoHelp = 600
    ActivarCache = False
    ShowBotonBuscar = False
    Left = 50
    Top = 28
  end
  object ValidadorPermisosInternos: TValidador
    Operacion = Operacion
    NickNameObjLog = 'cip.PermisosInternos'
    WhenRaiseException = teFound
    MensajeException = 'C'#243'digo de Permiso duplicado'
    NroQuery = 0
    Cache = False
    Left = 136
    Top = 51
  end
  object TReglasPermisosInt: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'oid_regla_permiso'
        DataType = ftInteger
      end
      item
        Name = 'oid_permiso_int'
        DataType = ftInteger
      end
      item
        Name = 'prioridad'
        DataType = ftInteger
      end
      item
        Name = 'descripcion'
        DataType = ftString
        Size = 100
      end
      item
        Name = 'es_una_vista'
        DataType = ftBoolean
      end
      item
        Name = 'activo'
        DataType = ftBoolean
      end>
    IndexFieldNames = 'oid_permiso_int'
    IndexDefs = <
      item
        Name = 'TReglasPermisosIntIndex1'
        Fields = 'oid_permiso_int'
      end>
    RecalcOnFetch = False
    SortOptions = []
    PersistentBackup = False
    ProgressFlags = [mtpcLoad, mtpcSave, mtpcCopy]
    VersioningMode = mtvmAllSinceCheckPoint
    FilterOptions = []
    MasterFields = 'oid_permiso_int'
    MasterSource = DSTPermisosInternos
    Version = '4.08b'
    LanguageID = 0
    SortID = 0
    SubLanguageID = 1
    LocaleID = 1024
    MensajeValorDuplicadoIndice = 'Valor Duplicado'
    Left = 568
    Top = 105
    object TReglasPermisosIntoid_regla_permiso: TIntegerField
      FieldName = 'oid_regla_permiso'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TReglasPermisosIntoid_permiso_int: TIntegerField
      FieldName = 'oid_permiso_int'
    end
    object TReglasPermisosIntprioridad: TIntegerField
      FieldName = 'prioridad'
    end
    object TReglasPermisosIntdescripcion: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
    object TReglasPermisosIntes_una_vista: TBooleanField
      FieldName = 'es_una_vista'
    end
    object TReglasPermisosIntactivo: TBooleanField
      FieldName = 'activo'
    end
  end
  object DSTReglasPermisosInt: TDataSource
    DataSet = TReglasPermisosInt
    Left = 600
    Top = 105
  end
  object TAccesoInternoPuerta: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'oid_acc_int_pue'
        DataType = ftInteger
      end
      item
        Name = 'secu'
        DataType = ftInteger
      end
      item
        Name = 'oid_regla_permiso'
        DataType = ftInteger
      end
      item
        Name = 'oid_puerta'
        DataType = ftInteger
      end
      item
        Name = 'precond_entrada'
        DataType = ftString
        Size = 20
      end
      item
        Name = 'tipo_compo_entra'
        DataType = ftString
        Size = 20
      end
      item
        Name = 'precond_salida'
        DataType = ftString
        Size = 20
      end
      item
        Name = 'tipo_compo_sali'
        DataType = ftString
        Size = 20
      end
      item
        Name = 'activo'
        DataType = ftBoolean
      end>
    IndexFieldNames = 'oid_regla_permiso'
    IndexDefs = <
      item
        Name = 'TAccesoInternoPuertaIndex1'
        Fields = 'oid_regla_permiso'
      end>
    RecalcOnFetch = False
    SortOptions = []
    PersistentBackup = False
    ProgressFlags = [mtpcLoad, mtpcSave, mtpcCopy]
    VersioningMode = mtvmAllSinceCheckPoint
    FilterOptions = []
    MasterFields = 'oid_regla_permiso'
    MasterSource = DSTReglasPermisosInt
    Version = '4.08b'
    LanguageID = 0
    SortID = 0
    SubLanguageID = 1
    LocaleID = 1024
    MensajeValorDuplicadoIndice = 'Valor Duplicado'
    Left = 421
    Top = 332
    object TAccesoInternoPuertaoid_acc_int_pue: TIntegerField
      FieldName = 'oid_acc_int_pue'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TAccesoInternoPuertasecu: TIntegerField
      FieldName = 'secu'
    end
    object TAccesoInternoPuertaoid_regla_permiso: TIntegerField
      FieldName = 'oid_regla_permiso'
    end
    object TAccesoInternoPuertaoid_puerta: TIntegerField
      FieldName = 'oid_puerta'
    end
    object TAccesoInternoPuertaprecond_entrada: TStringField
      FieldName = 'precond_entrada'
    end
    object TAccesoInternoPuertatipo_compo_entra: TStringField
      FieldName = 'tipo_compo_entra'
    end
    object TAccesoInternoPuertaprecond_salida: TStringField
      FieldName = 'precond_salida'
    end
    object TAccesoInternoPuertatipo_compo_sali: TStringField
      FieldName = 'tipo_compo_sali'
    end
    object TAccesoInternoPuertaactivo: TBooleanField
      FieldName = 'activo'
    end
    object TAccesoInternoPuertacod_puerta: TStringField
      FieldName = 'cod_puerta'
      Size = 50
    end
    object TAccesoInternoPuertadesc_puerta: TStringField
      FieldName = 'desc_puerta'
      Size = 100
    end
    object TAccesoInternoPuertamensaje_entrada: TStringField
      FieldName = 'mensaje_entrada'
      Size = 100
    end
    object TAccesoInternoPuertamensaje_salida: TStringField
      FieldName = 'mensaje_salida'
      Size = 100
    end
    object TAccesoInternoPuertatipo_ctrl_fh_ent: TStringField
      FieldName = 'tipo_ctrl_fh_ent'
      Size = 10
    end
    object TAccesoInternoPuertatipo_ctrl_fh_sal: TStringField
      FieldName = 'tipo_ctrl_fh_sal'
      Size = 10
    end
    object TAccesoInternoPuertamin_ent_ant_fh_ent: TIntegerField
      FieldName = 'min_ent_ant_fh_ent'
    end
    object TAccesoInternoPuertamin_ent_des_fh_ent: TIntegerField
      FieldName = 'min_ent_des_fh_ent'
    end
    object TAccesoInternoPuertamin_ent_ant_fh_sal: TIntegerField
      FieldName = 'min_ent_ant_fh_sal'
    end
    object TAccesoInternoPuertamin_ent_des_fh_sal: TIntegerField
      FieldName = 'min_ent_des_fh_sal'
    end
    object TAccesoInternoPuertaENT_SEXO: TStringField
      FieldName = 'ENT_SEXO'
    end
    object TAccesoInternoPuertaSAL_SEXO: TStringField
      FieldName = 'SAL_SEXO'
    end
  end
  object DSTAccesoInternoPuerta: TDataSource
    DataSet = TAccesoInternoPuerta
    Left = 453
    Top = 340
  end
  object HelpPuertas: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'cip.Puerta'
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
        AsignarACampo = TAccesoInternoPuertacod_puerta
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
    Titulo = 'Puertas'
    AnchoHelp = 600
    ActivarCache = False
    ShowBotonBuscar = False
    Left = 50
    Top = 399
  end
  object ValidadorPuertas: TValidador
    Operacion = Operacion
    NickNameObjLog = 'cip.Puerta'
    MensajeException = 'C'#243'digo de Puerta Inexistente'
    CampoOID = TAccesoInternoPuertaoid_puerta
    CampoDescripcion = TAccesoInternoPuertadesc_puerta
    NroQuery = 0
    Cache = True
    Left = 86
    Top = 399
  end
  object TPrecondiciones: TsnTable
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
    Left = 64
    Top = 193
    object TPrecondicionescodigo: TStringField
      FieldName = 'codigo'
      Size = 50
    end
    object TPrecondicionesdescripcion: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
  end
  object DSPrecondiciones: TDataSource
    DataSet = TPrecondiciones
    Left = 104
    Top = 193
  end
  object TAcciones: TsnTable
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
    Left = 197
    Top = 348
    object TAccionescodigo: TStringField
      FieldName = 'codigo'
      Size = 50
    end
    object TAccionesdescripcion: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
  end
  object DSAcciones: TDataSource
    DataSet = TAcciones
    Left = 229
    Top = 348
  end
  object TPermisoIntLeg: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'oid_perm_int_leg'
        DataType = ftInteger
      end
      item
        Name = 'oid_regla_permiso'
        DataType = ftInteger
      end
      item
        Name = 'oid_legajo'
        DataType = ftInteger
      end
      item
        Name = 'legajo'
        DataType = ftString
        Size = 50
      end
      item
        Name = 'ape_y_nom'
        DataType = ftString
        Size = 100
      end
      item
        Name = 'activo'
        DataType = ftBoolean
      end>
    IndexFieldNames = 'oid_regla_permiso'
    IndexDefs = <
      item
        Name = 'TPermisoIntLegIndex1'
        Fields = 'oid_regla_permiso'
      end>
    RecalcOnFetch = False
    SortOptions = []
    PersistentBackup = False
    ProgressFlags = [mtpcLoad, mtpcSave, mtpcCopy]
    VersioningMode = mtvmAllSinceCheckPoint
    FilterOptions = []
    MasterFields = 'oid_regla_permiso'
    MasterSource = DSTReglasPermisosInt
    Version = '4.08b'
    LanguageID = 0
    SortID = 0
    SubLanguageID = 1
    LocaleID = 1024
    MensajeValorDuplicadoIndice = 'Valor Duplicado'
    Left = 513
    Top = 340
    object TPermisoIntLegoid_perm_int_leg: TIntegerField
      FieldName = 'oid_perm_int_leg'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TPermisoIntLegoid_regla_permiso: TIntegerField
      FieldName = 'oid_regla_permiso'
    end
    object TPermisoIntLegoid_legajo: TIntegerField
      FieldName = 'oid_legajo'
    end
    object TPermisoIntLeglegajo: TStringField
      FieldName = 'legajo'
      Size = 50
    end
    object TPermisoIntLegape_y_nom: TStringField
      FieldName = 'ape_y_nom'
      Size = 100
    end
    object TPermisoIntLegactivo: TBooleanField
      FieldName = 'activo'
    end
  end
  object DSPermisosIntLeg: TDataSource
    DataSet = TPermisoIntLeg
    Left = 545
    Top = 340
  end
  object HelpLegajo: TsnHelp
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
        AsignarACampo = TPermisoIntLeglegajo
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
    Left = 290
    Top = 383
  end
  object ValidadorLegajo: TValidador
    Operacion = Operacion
    NickNameObjLog = 'su.Legajo'
    MensajeException = 'C'#243'digo de Legajo Inexistente'
    CampoOID = TPermisoIntLegoid_legajo
    CampoDescripcion = TPermisoIntLegape_y_nom
    NroQuery = 0
    Cache = True
    Left = 326
    Top = 391
  end
  object TPermisoIntEmp: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'oid_perm_int_emp'
        DataType = ftInteger
      end
      item
        Name = 'oid_regla_permiso'
        DataType = ftInteger
      end
      item
        Name = 'oid_val_clasif_emp'
        DataType = ftInteger
      end
      item
        Name = 'activo'
        DataType = ftBoolean
      end>
    IndexFieldNames = 'oid_regla_permiso'
    IndexDefs = <
      item
        Name = 'TPermisoIntEmpIndex1'
        Fields = 'oid_regla_permiso'
      end>
    RecalcOnFetch = False
    SortOptions = []
    PersistentBackup = False
    ProgressFlags = [mtpcLoad, mtpcSave, mtpcCopy]
    VersioningMode = mtvmAllSinceCheckPoint
    FilterOptions = []
    MasterFields = 'oid_regla_permiso'
    MasterSource = DSTReglasPermisosInt
    Version = '4.08b'
    LanguageID = 0
    SortID = 0
    SubLanguageID = 1
    LocaleID = 1024
    MensajeValorDuplicadoIndice = 'Valor Duplicado'
    Left = 601
    Top = 340
    object TPermisoIntEmpoid_perm_int_emp: TIntegerField
      FieldName = 'oid_perm_int_emp'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TPermisoIntEmpoid_regla_permiso: TIntegerField
      FieldName = 'oid_regla_permiso'
    end
    object TPermisoIntEmpoid_val_clasif_emp: TIntegerField
      FieldName = 'oid_val_clasif_emp'
    end
    object TPermisoIntEmpactivo: TBooleanField
      FieldName = 'activo'
    end
    object TPermisoIntEmpcod_val_clasif_emp: TStringField
      FieldName = 'cod_val_clasif_emp'
      Size = 50
    end
    object TPermisoIntEmpdesc_val_clasif_emp: TStringField
      FieldName = 'desc_val_clasif_emp'
      Size = 100
    end
  end
  object DSPermisoIntEmp: TDataSource
    DataSet = TPermisoIntEmp
    Left = 633
    Top = 340
  end
  object TTempPermisoIntEmp: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'oid_perm_int_emp'
        DataType = ftInteger
      end
      item
        Name = 'oid_regla_permiso'
        DataType = ftInteger
      end
      item
        Name = 'oid_val_clasif_emp'
        DataType = ftInteger
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
    MasterFields = 'oid_regla_permiso'
    Version = '4.08b'
    LanguageID = 0
    SortID = 0
    SubLanguageID = 1
    LocaleID = 1024
    MensajeValorDuplicadoIndice = 'Valor Duplicado'
    Left = 601
    Top = 377
    object IntegerField1: TIntegerField
      FieldName = 'oid_perm_int_emp'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object IntegerField2: TIntegerField
      FieldName = 'oid_regla_permiso'
    end
    object IntegerField3: TIntegerField
      FieldName = 'oid_val_clasif_emp'
    end
    object BooleanField1: TBooleanField
      FieldName = 'activo'
    end
    object StringField1: TStringField
      FieldName = 'cod_val_clasif_emp'
      Size = 50
    end
    object StringField2: TStringField
      FieldName = 'desc_val_clasif_emp'
      Size = 100
    end
  end
  object TPermisoIntSec: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'oid_perm_int_emp'
        DataType = ftInteger
      end
      item
        Name = 'oid_regla_permiso'
        DataType = ftInteger
      end
      item
        Name = 'oid_val_clasif_emp'
        DataType = ftInteger
      end
      item
        Name = 'activo'
        DataType = ftBoolean
      end>
    IndexFieldNames = 'oid_regla_permiso'
    IndexDefs = <
      item
        Name = 'TPermisoIntEmpIndex1'
        Fields = 'oid_regla_permiso'
      end>
    RecalcOnFetch = False
    SortOptions = []
    PersistentBackup = False
    ProgressFlags = [mtpcLoad, mtpcSave, mtpcCopy]
    VersioningMode = mtvmAllSinceCheckPoint
    FilterOptions = []
    MasterFields = 'oid_regla_permiso'
    MasterSource = DSTReglasPermisosInt
    Version = '4.08b'
    LanguageID = 0
    SortID = 0
    SubLanguageID = 1
    LocaleID = 1024
    MensajeValorDuplicadoIndice = 'Valor Duplicado'
    Left = 673
    Top = 340
    object TPermisoIntSecoid_perm_int_sec: TIntegerField
      FieldName = 'oid_perm_int_sec'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object IntegerField5: TIntegerField
      FieldName = 'oid_regla_permiso'
    end
    object IntegerField6: TIntegerField
      FieldName = 'oid_val_clasif_sec'
    end
    object BooleanField2: TBooleanField
      FieldName = 'activo'
    end
    object StringField3: TStringField
      FieldName = 'cod_val_clasif_sec'
      Size = 50
    end
    object StringField4: TStringField
      FieldName = 'desc_val_clasif_sec'
      Size = 100
    end
  end
  object DSPermisoIntSec: TDataSource
    DataSet = TPermisoIntSec
    Left = 705
    Top = 340
  end
  object TTempPermisoIntSec: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'oid_perm_int_emp'
        DataType = ftInteger
      end
      item
        Name = 'oid_regla_permiso'
        DataType = ftInteger
      end
      item
        Name = 'oid_val_clasif_emp'
        DataType = ftInteger
      end
      item
        Name = 'activo'
        DataType = ftBoolean
      end>
    IndexDefs = <
      item
        Name = 'TPermisoIntEmpIndex1'
        Fields = 'oid_regla_permiso'
      end>
    RecalcOnFetch = False
    SortOptions = []
    PersistentBackup = False
    ProgressFlags = [mtpcLoad, mtpcSave, mtpcCopy]
    VersioningMode = mtvmAllSinceCheckPoint
    FilterOptions = []
    MasterFields = 'oid_regla_permiso'
    MasterSource = DSTReglasPermisosInt
    Version = '4.08b'
    LanguageID = 0
    SortID = 0
    SubLanguageID = 1
    LocaleID = 1024
    MensajeValorDuplicadoIndice = 'Valor Duplicado'
    Left = 673
    Top = 378
    object TTempPermisoIntSecoid_perm_int_sec: TIntegerField
      FieldName = 'oid_perm_int_sec'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object IntegerField8: TIntegerField
      FieldName = 'oid_regla_permiso'
    end
    object IntegerField9: TIntegerField
      FieldName = 'oid_val_clasif_sec'
    end
    object BooleanField3: TBooleanField
      FieldName = 'activo'
    end
    object StringField5: TStringField
      FieldName = 'cod_val_clasif_sec'
      Size = 50
    end
    object StringField6: TStringField
      FieldName = 'desc_val_clasif_sec'
      Size = 100
    end
  end
  object TPermisoIntPue: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'oid_perm_int_emp'
        DataType = ftInteger
      end
      item
        Name = 'oid_regla_permiso'
        DataType = ftInteger
      end
      item
        Name = 'oid_val_clasif_emp'
        DataType = ftInteger
      end
      item
        Name = 'activo'
        DataType = ftBoolean
      end>
    IndexFieldNames = 'oid_regla_permiso'
    IndexDefs = <
      item
        Name = 'TPermisoIntEmpIndex1'
        Fields = 'oid_regla_permiso'
      end>
    RecalcOnFetch = False
    SortOptions = []
    PersistentBackup = False
    ProgressFlags = [mtpcLoad, mtpcSave, mtpcCopy]
    VersioningMode = mtvmAllSinceCheckPoint
    FilterOptions = []
    MasterFields = 'oid_regla_permiso'
    MasterSource = DSTReglasPermisosInt
    Version = '4.08b'
    LanguageID = 0
    SortID = 0
    SubLanguageID = 1
    LocaleID = 1024
    MensajeValorDuplicadoIndice = 'Valor Duplicado'
    Left = 743
    Top = 340
    object TPermisoIntPueoid_perm_int_pue: TIntegerField
      FieldName = 'oid_perm_int_pue'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object IntegerField7: TIntegerField
      FieldName = 'oid_regla_permiso'
    end
    object IntegerField10: TIntegerField
      FieldName = 'oid_val_clasif_pue'
    end
    object BooleanField4: TBooleanField
      FieldName = 'activo'
    end
    object StringField7: TStringField
      FieldName = 'cod_val_clasif_pue'
      Size = 50
    end
    object StringField8: TStringField
      FieldName = 'desc_val_clasif_pue'
      Size = 100
    end
  end
  object DSPermisoIntPue: TDataSource
    DataSet = TPermisoIntPue
    Left = 775
    Top = 340
  end
  object TTempPermisoIntPue: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'oid_perm_int_emp'
        DataType = ftInteger
      end
      item
        Name = 'oid_regla_permiso'
        DataType = ftInteger
      end
      item
        Name = 'oid_val_clasif_emp'
        DataType = ftInteger
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
    Left = 743
    Top = 378
    object IntegerField4: TIntegerField
      FieldName = 'oid_perm_int_pue'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object IntegerField11: TIntegerField
      FieldName = 'oid_regla_permiso'
    end
    object IntegerField12: TIntegerField
      FieldName = 'oid_val_clasif_pue'
    end
    object BooleanField5: TBooleanField
      FieldName = 'activo'
    end
    object StringField9: TStringField
      FieldName = 'cod_val_clasif_pue'
      Size = 50
    end
    object StringField10: TStringField
      FieldName = 'desc_val_clasif_pue'
      Size = 100
    end
  end
  object TPermisoIntEst: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'oid_perm_int_emp'
        DataType = ftInteger
      end
      item
        Name = 'oid_regla_permiso'
        DataType = ftInteger
      end
      item
        Name = 'oid_val_clasif_emp'
        DataType = ftInteger
      end
      item
        Name = 'activo'
        DataType = ftBoolean
      end>
    IndexFieldNames = 'oid_regla_permiso'
    IndexDefs = <
      item
        Name = 'TPermisoIntEmpIndex1'
        Fields = 'oid_regla_permiso'
      end>
    RecalcOnFetch = False
    SortOptions = []
    PersistentBackup = False
    ProgressFlags = [mtpcLoad, mtpcSave, mtpcCopy]
    VersioningMode = mtvmAllSinceCheckPoint
    FilterOptions = []
    MasterFields = 'oid_regla_permiso'
    MasterSource = DSTReglasPermisosInt
    Version = '4.08b'
    LanguageID = 0
    SortID = 0
    SubLanguageID = 1
    LocaleID = 1024
    MensajeValorDuplicadoIndice = 'Valor Duplicado'
    Left = 719
    Top = 247
    object IntegerField13: TIntegerField
      FieldName = 'oid_perm_int_est'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object IntegerField14: TIntegerField
      FieldName = 'oid_regla_permiso'
    end
    object BooleanField6: TBooleanField
      FieldName = 'activo'
    end
    object TPermisoIntEstoid_estado: TIntegerField
      FieldName = 'oid_estado'
    end
    object TPermisoIntEstdesc_estado: TStringField
      FieldName = 'desc_estado'
      Size = 100
    end
  end
  object DSTPermisoIntEst: TDataSource
    DataSet = TPermisoIntEst
    Left = 751
    Top = 247
  end
  object TTempPermisoIntEst: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'oid_perm_int_emp'
        DataType = ftInteger
      end
      item
        Name = 'oid_regla_permiso'
        DataType = ftInteger
      end
      item
        Name = 'oid_val_clasif_emp'
        DataType = ftInteger
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
    Left = 719
    Top = 283
    object IntegerField16: TIntegerField
      FieldName = 'oid_perm_int_est'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object IntegerField17: TIntegerField
      FieldName = 'oid_regla_permiso'
    end
    object BooleanField7: TBooleanField
      FieldName = 'activo'
    end
    object TTempPermisoIntEstoid_estado: TIntegerField
      FieldName = 'oid_estado'
    end
    object TTempPermisoIntEstdesc_estado: TStringField
      FieldName = 'desc_estado'
      Size = 100
    end
  end
  object TControlaFranja: TsnTable
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
    Left = 301
    Top = 452
    object TControlaFranjacodigo: TStringField
      FieldName = 'codigo'
      Size = 10
    end
    object TControlaFranjadescripcion: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
  end
  object DSControlarFranja: TDataSource
    DataSet = TControlaFranja
    Left = 341
    Top = 452
  end
  object TSexo: TsnTable
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
    Left = 64
    Top = 151
    object StringField11: TStringField
      FieldName = 'codigo'
      Size = 50
    end
    object StringField12: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
  end
  object DSSexo: TDataSource
    DataSet = TSexo
    Left = 104
    Top = 154
  end
end
