inherited FCargaEvalLeg: TFCargaEvalLeg
  Left = 181
  Top = 13
  Width = 856
  Height = 958
  Caption = 'Evaluaciones de Desempe'#241'o'
  Constraints.MaxWidth = 900
  PrintScale = poPrintToFit
  PixelsPerInch = 96
  TextHeight = 13
  inherited PForm: TPanel
    Width = 840
    Height = 920
    inherited PPie: TPanel
      Top = 899
      Width = 840
      inherited StatusBarABM: TStatusBar
        Left = 735
      end
      inherited StatusBar2: TStatusBar
        Width = 735
      end
    end
    inherited PMenu: TPanel
      Top = 0
      Width = 840
      inherited ImagenEliminar: TImagenEstado
        DataField = 'activo'
        DataSource = dsEVALUCIONCAB
      end
      inherited ImagenRehabilitar: TImagenEstado
        DataField = 'activo'
        DataSource = dsEVALUCIONCAB
      end
      inherited Panel2: TPanel
        Left = 799
      end
      inherited PanelEstadoON: TPanelEstado
        Left = 575
        Width = 170
        DataField = 'activo'
        DataSource = dsEVALUCIONCAB
        Leyendas = <
          item
            Titulo = 'EVALUACION ANULADA'
            ColorTitulo = clWindow
            ValorEstado = 'false'
            Visible = True
            ColorPanel = clRed
          end>
      end
    end
    inherited POpcionesMenu: TPanel
      Top = 41
      Width = 840
      Height = 0
    end
    inherited PCabecera: TPanel
      Top = 41
      Width = 840
      Height = 0
    end
    inherited PCuerpo: TPanel
      Top = 41
      Width = 840
      Height = 858
      AutoSize = True
      object SNScrollBox1: TSNScrollBox
        Left = 0
        Top = 0
        Width = 840
        Height = 858
        Align = alClient
        TabOrder = 0
        object Panel1: TPanel
          Left = 0
          Top = 0
          Width = 819
          Height = 101
          Align = alTop
          BevelOuter = bvNone
          Color = clWindow
          TabOrder = 7
          object Label1: TLabel
            Left = 8
            Top = 27
            Width = 89
            Height = 49
            Alignment = taCenter
            AutoSize = False
            Caption = '          RRHH          '
            Color = 10801663
            Font.Charset = DEFAULT_CHARSET
            Font.Color = clWindowText
            Font.Height = -11
            Font.Name = 'MS Sans Serif'
            Font.Style = [fsBold]
            ParentColor = False
            ParentFont = False
            Layout = tlCenter
          end
          object ImagenLogo: TsnImage
            Left = 452
            Top = 9
            Width = 139
            Height = 82
          end
          object snLabel12: TsnLabel
            Left = 601
            Top = 0
            Width = 183
            Height = 13
            Caption = 'Otras Versiones (Doble Click visualizar)'
            Font.Charset = DEFAULT_CHARSET
            Font.Color = clBlue
            Font.Height = -11
            Font.Name = 'MS Sans Serif'
            Font.Style = []
            ParentFont = False
          end
          object snDBEdit1: TsnDBEdit
            Left = 108
            Top = 16
            TabStop = False
            DataBinding.DataField = 'titulo_1'
            DataBinding.DataSource = DSTLeyendasReporte
            ParentFont = False
            Properties.Alignment.Horz = taCenter
            Properties.ReadOnly = True
            Style.Edges = []
            Style.Font.Charset = DEFAULT_CHARSET
            Style.Font.Color = clWindowText
            Style.Font.Height = -13
            Style.Font.Name = 'MS Sans Serif'
            Style.Font.Style = [fsBold]
            Style.IsFontAssigned = True
            TabOrder = 0
            Width = 350
          end
          object snDBEdit2: TsnDBEdit
            Left = 108
            Top = 37
            TabStop = False
            DataBinding.DataField = 'titulo_2'
            DataBinding.DataSource = DSTLeyendasReporte
            ParentFont = False
            Properties.Alignment.Horz = taCenter
            Properties.ReadOnly = True
            Style.Edges = []
            Style.Font.Charset = DEFAULT_CHARSET
            Style.Font.Color = clWindowText
            Style.Font.Height = -13
            Style.Font.Name = 'MS Sans Serif'
            Style.Font.Style = [fsBold]
            Style.IsFontAssigned = True
            TabOrder = 1
            Width = 350
          end
          object snDBEdit3: TsnDBEdit
            Left = 108
            Top = 58
            TabStop = False
            DataBinding.DataField = 'titulo_3'
            DataBinding.DataSource = DSTLeyendasReporte
            ParentFont = False
            Properties.Alignment.Horz = taCenter
            Properties.ReadOnly = True
            Style.Edges = []
            Style.Font.Charset = DEFAULT_CHARSET
            Style.Font.Color = clWindowText
            Style.Font.Height = -13
            Style.Font.Name = 'MS Sans Serif'
            Style.Font.Style = [fsBold]
            Style.IsFontAssigned = True
            TabOrder = 2
            Width = 350
          end
          object dxDBGridSN2: TdxDBGridSN
            Left = 594
            Top = 16
            Width = 207
            Height = 76
            TabOrder = 3
            TabStop = False
            CriteriosPintarCelda = <
              item
                TipoPintadaCelda = tpcTodasLasColumnas
                FieldName1 = 'vigente'
                TipoCondFiltro1 = tcfIgual
                Valor1 = True
                TipoCondFiltro2 = tcfIgual
                Color = 16756912
              end>
            object dxDBGridSN2DBTableView1: TcxGridDBTableView
              NavigatorButtons.ConfirmDelete = False
              DataController.DataSource = DSOtrasVersiones
              DataController.Summary.DefaultGroupSummaryItems = <>
              DataController.Summary.FooterSummaryItems = <>
              DataController.Summary.SummaryGroups = <>
              OptionsBehavior.FocusCellOnTab = True
              OptionsBehavior.FocusFirstCellOnNewRecord = True
              OptionsBehavior.FocusCellOnCycle = True
              OptionsCustomize.ColumnFiltering = False
              OptionsCustomize.ColumnSorting = False
              OptionsData.CancelOnExit = False
              OptionsData.Deleting = False
              OptionsData.DeletingConfirmation = False
              OptionsData.Editing = False
              OptionsData.Inserting = False
              OptionsSelection.InvertSelect = False
              OptionsView.NoDataToDisplayInfoText = '.'
              OptionsView.GridLines = glNone
              OptionsView.GroupByBox = False
              OptionsView.Header = False
              object dxDBGridSN2DBTableView1version: TcxGridDBColumn
                Caption = 'Ver.'
                DataBinding.FieldName = 'version'
                Width = 25
              end
              object dxDBGridSN2DBTableView1fec_carga: TcxGridDBColumn
                Caption = 'Fec. Carga'
                DataBinding.FieldName = 'fec_carga'
                HeaderAlignmentHorz = taCenter
                SortIndex = 0
                SortOrder = soDescending
                Width = 67
              end
              object dxDBGridSN2DBTableView1Column1: TcxGridDBColumn
                Caption = 'Puntaje'
                DataBinding.FieldName = 'puntaje'
                HeaderAlignmentHorz = taCenter
                Width = 41
              end
              object dxDBGridSN2DBTableView1Column2: TcxGridDBColumn
                Caption = 'Activo'
                DataBinding.FieldName = 'activo'
                HeaderAlignmentHorz = taCenter
                Width = 52
              end
              object dxDBGridSN2DBTableView1Column3: TcxGridDBColumn
                DataBinding.FieldName = 'vigente'
                Visible = False
              end
            end
            object dxDBGridSN2Level1: TcxGridLevel
              GridView = dxDBGridSN2DBTableView1
            end
          end
        end
        object Panel3: TPanel
          Left = 0
          Top = 101
          Width = 819
          Height = 245
          Align = alTop
          BevelOuter = bvNone
          BorderWidth = 3
          Color = clWindow
          TabOrder = 0
          object Panel4: TPanel
            Left = 3
            Top = 3
            Width = 813
            Height = 21
            Align = alTop
            BevelOuter = bvNone
            Color = clWindow
            ParentBackground = False
            TabOrder = 0
            object snLabel1: TsnLabel
              Left = 160
              Top = -1
              Width = 298
              Height = 16
              Caption = 'EVALUACION Y GESTION DEL DESEMPE'#209'O'
              Color = 10801663
              Font.Charset = ANSI_CHARSET
              Font.Color = clWindowText
              Font.Height = -13
              Font.Name = 'Verdana'
              Font.Style = [fsBold]
              ParentColor = False
              ParentFont = False
            end
          end
          object Panel5: TPanel
            Left = 3
            Top = 24
            Width = 813
            Height = 218
            Align = alClient
            BevelOuter = bvNone
            Color = clWindow
            TabOrder = 1
            object Panel6: TPanel
              Left = 0
              Top = 0
              Width = 474
              Height = 218
              Align = alLeft
              BevelOuter = bvNone
              Color = clWindow
              TabOrder = 1
              object Panel7: TPanel
                Left = 0
                Top = 176
                Width = 474
                Height = 17
                Align = alTop
                BevelOuter = bvNone
                Color = 15658734
                TabOrder = 0
                object snLabel2: TsnLabel
                  Left = 14
                  Top = 2
                  Width = 53
                  Height = 16
                  Caption = 'PUESTO'
                  Font.Charset = ANSI_CHARSET
                  Font.Color = clWindowText
                  Font.Height = -13
                  Font.Name = 'Verdana'
                  Font.Style = []
                  ParentFont = False
                end
              end
              object Panel9: TPanel
                Left = 0
                Top = 17
                Width = 474
                Height = 27
                Align = alTop
                BevelOuter = bvNone
                Color = clWindow
                TabOrder = 1
                object snDBLookup1: TsnDBLookup
                  Left = 13
                  Top = 2
                  DataBinding.DataField = 'oid_mod_eval_cab'
                  DataBinding.DataSource = dsEVALUCIONCAB
                  ParentFont = False
                  Properties.KeyFieldNames = 'oid_mod_eval_cab'
                  Properties.ListColumns = <
                    item
                      FieldName = 'desc_abraviada'
                    end>
                  Properties.ListOptions.ShowHeader = False
                  Properties.ListSource = DSModelosVigentes
                  Style.Font.Charset = ANSI_CHARSET
                  Style.Font.Color = clWindowText
                  Style.Font.Height = -13
                  Style.Font.Name = 'Verdana'
                  Style.Font.Style = []
                  Style.IsFontAssigned = True
                  TabOrder = 0
                  Width = 253
                end
                object snDBEdit4: TsnDBEdit
                  Left = 271
                  Top = 2
                  TabStop = False
                  DataBinding.DataField = 'version_eval'
                  DataBinding.DataSource = dsEVALUCIONCAB
                  ParentFont = False
                  Properties.Alignment.Horz = taCenter
                  Properties.ReadOnly = True
                  Style.Font.Charset = ANSI_CHARSET
                  Style.Font.Color = clWindowText
                  Style.Font.Height = -13
                  Style.Font.Name = 'Verdana'
                  Style.Font.Style = []
                  Style.IsFontAssigned = True
                  TabOrder = 1
                  Width = 60
                end
                object snDBDateEdit1: TsnDBDateEdit
                  Left = 338
                  Top = 2
                  DataBinding.DataField = 'fec_eval'
                  DataBinding.DataSource = dsEVALUCIONCAB
                  ParentFont = False
                  Properties.Alignment.Horz = taCenter
                  Style.Font.Charset = ANSI_CHARSET
                  Style.Font.Color = clWindowText
                  Style.Font.Height = -13
                  Style.Font.Name = 'Verdana'
                  Style.Font.Style = []
                  Style.IsFontAssigned = True
                  TabOrder = 2
                  ReadOnlyAlways = False
                  Width = 135
                end
              end
              object Panel10: TPanel
                Left = 0
                Top = 0
                Width = 474
                Height = 17
                Align = alTop
                BevelOuter = bvNone
                Color = 10801663
                TabOrder = 2
                object snLabel5: TsnLabel
                  Left = 14
                  Top = 1
                  Width = 191
                  Height = 16
                  Caption = 'EVALUACION DE DESEMPE'#209'O'
                  Color = clWindow
                  Font.Charset = ANSI_CHARSET
                  Font.Color = clWindowText
                  Font.Height = -13
                  Font.Name = 'Verdana'
                  Font.Style = []
                  ParentColor = False
                  ParentFont = False
                end
                object snLabel6: TsnLabel
                  Left = 271
                  Top = 2
                  Width = 58
                  Height = 16
                  Caption = 'VERSION'
                  Font.Charset = ANSI_CHARSET
                  Font.Color = clWindowText
                  Font.Height = -13
                  Font.Name = 'Verdana'
                  Font.Style = []
                  ParentFont = False
                end
                object snLabel7: TsnLabel
                  Left = 339
                  Top = 2
                  Width = 132
                  Height = 16
                  Caption = 'FECHA EVALUACION'
                  Font.Charset = ANSI_CHARSET
                  Font.Color = clWindowText
                  Font.Height = -13
                  Font.Name = 'Verdana'
                  Font.Style = []
                  ParentFont = False
                end
              end
              object Panel12: TPanel
                Left = 0
                Top = 61
                Width = 474
                Height = 27
                Align = alTop
                BevelOuter = bvNone
                Color = clWindow
                TabOrder = 3
                object srnDBButtonEdit1: TsrnDBButtonEdit
                  Left = 13
                  Top = 2
                  DataBinding.DataField = 'cod_legajo'
                  DataBinding.DataSource = dsEVALUCIONCAB
                  ParentFont = False
                  Properties.Buttons = <
                    item
                      Default = True
                      Kind = bkEllipsis
                    end>
                  Properties.ClickKey = 112
                  Style.Font.Charset = ANSI_CHARSET
                  Style.Font.Color = clWindowText
                  Style.Font.Height = -13
                  Style.Font.Name = 'Verdana'
                  Style.Font.Style = []
                  Style.IsFontAssigned = True
                  TabOrder = 0
                  Help = HelpLegajos
                  Width = 100
                end
                object snDBEdit5: TsnDBEdit
                  Left = 110
                  Top = 2
                  TabStop = False
                  DataBinding.DataField = 'ape_nom_legajo'
                  DataBinding.DataSource = dsEVALUCIONCAB
                  ParentFont = False
                  Properties.Alignment.Horz = taLeftJustify
                  Properties.ReadOnly = True
                  Style.Font.Charset = ANSI_CHARSET
                  Style.Font.Color = clWindowText
                  Style.Font.Height = -13
                  Style.Font.Name = 'Verdana'
                  Style.Font.Style = []
                  Style.IsFontAssigned = True
                  TabOrder = 1
                  Width = 361
                end
              end
              object Panel13: TPanel
                Left = 0
                Top = 44
                Width = 474
                Height = 17
                Align = alTop
                BevelOuter = bvNone
                Color = 15658734
                TabOrder = 4
                object snLabel4: TsnLabel
                  Left = 14
                  Top = 2
                  Width = 49
                  Height = 16
                  Caption = 'LEGAJO'
                  Font.Charset = ANSI_CHARSET
                  Font.Color = clWindowText
                  Font.Height = -13
                  Font.Name = 'Verdana'
                  Font.Style = []
                  ParentFont = False
                end
                object snLabel8: TsnLabel
                  Left = 112
                  Top = 3
                  Width = 136
                  Height = 16
                  Caption = 'APELLIDO Y NOMBRE'
                  Font.Charset = ANSI_CHARSET
                  Font.Color = clWindowText
                  Font.Height = -13
                  Font.Name = 'Verdana'
                  Font.Style = []
                  ParentFont = False
                end
              end
              object Panel14: TPanel
                Left = 0
                Top = 105
                Width = 474
                Height = 27
                Align = alTop
                BevelOuter = bvNone
                Color = clWindow
                TabOrder = 5
                object srnDBButtonEmpresa: TsrnDBButtonEdit
                  Left = 13
                  Top = 2
                  DataBinding.DataField = 'cod_empresa'
                  DataBinding.DataSource = dsEVALUCIONCAB
                  ParentFont = False
                  Properties.Buttons = <
                    item
                      Default = True
                      Kind = bkEllipsis
                    end>
                  Properties.ClickKey = 112
                  Style.Font.Charset = ANSI_CHARSET
                  Style.Font.Color = clWindowText
                  Style.Font.Height = -13
                  Style.Font.Name = 'Verdana'
                  Style.Font.Style = []
                  Style.IsFontAssigned = True
                  TabOrder = 0
                  Width = 100
                end
                object snDBEdit6: TsnDBEdit
                  Left = 110
                  Top = 2
                  TabStop = False
                  DataBinding.DataField = 'desc_empresa'
                  DataBinding.DataSource = dsEVALUCIONCAB
                  ParentFont = False
                  Properties.Alignment.Horz = taLeftJustify
                  Properties.ReadOnly = True
                  Style.Font.Charset = ANSI_CHARSET
                  Style.Font.Color = clWindowText
                  Style.Font.Height = -13
                  Style.Font.Name = 'Verdana'
                  Style.Font.Style = []
                  Style.IsFontAssigned = True
                  TabOrder = 1
                  Width = 361
                end
              end
              object Panel15: TPanel
                Left = 0
                Top = 88
                Width = 474
                Height = 17
                Align = alTop
                BevelOuter = bvNone
                Color = 15658734
                TabOrder = 6
                object snLabel3: TsnLabel
                  Left = 14
                  Top = 2
                  Width = 61
                  Height = 16
                  Caption = 'EMPRESA'
                  Font.Charset = ANSI_CHARSET
                  Font.Color = clWindowText
                  Font.Height = -13
                  Font.Name = 'Verdana'
                  Font.Style = []
                  ParentFont = False
                end
              end
              object Panel16: TPanel
                Left = 0
                Top = 149
                Width = 474
                Height = 27
                Align = alTop
                BevelOuter = bvNone
                Color = clWindow
                TabOrder = 7
                object srnDBButtonSector: TsrnDBButtonEdit
                  Left = 13
                  Top = 2
                  DataBinding.DataField = 'cod_sector'
                  DataBinding.DataSource = dsEVALUCIONCAB
                  ParentFont = False
                  Properties.Buttons = <
                    item
                      Default = True
                      Kind = bkEllipsis
                    end>
                  Properties.ClickKey = 112
                  Style.Font.Charset = ANSI_CHARSET
                  Style.Font.Color = clWindowText
                  Style.Font.Height = -13
                  Style.Font.Name = 'Verdana'
                  Style.Font.Style = []
                  Style.IsFontAssigned = True
                  TabOrder = 0
                  Width = 100
                end
                object snDBEdit7: TsnDBEdit
                  Left = 110
                  Top = 2
                  TabStop = False
                  DataBinding.DataField = 'desc_sector'
                  DataBinding.DataSource = dsEVALUCIONCAB
                  ParentFont = False
                  Properties.Alignment.Horz = taLeftJustify
                  Properties.ReadOnly = True
                  Style.Font.Charset = ANSI_CHARSET
                  Style.Font.Color = clWindowText
                  Style.Font.Height = -13
                  Style.Font.Name = 'Verdana'
                  Style.Font.Style = []
                  Style.IsFontAssigned = True
                  TabOrder = 1
                  Width = 361
                end
              end
              object Panel17: TPanel
                Left = 0
                Top = 132
                Width = 474
                Height = 17
                Align = alTop
                BevelOuter = bvNone
                Color = 15658734
                TabOrder = 8
                object snLabel9: TsnLabel
                  Left = 14
                  Top = 2
                  Width = 53
                  Height = 16
                  Caption = 'SECTOR'
                  Font.Charset = ANSI_CHARSET
                  Font.Color = clWindowText
                  Font.Height = -13
                  Font.Name = 'Verdana'
                  Font.Style = []
                  ParentFont = False
                end
              end
              object Panel18: TPanel
                Left = 0
                Top = 193
                Width = 474
                Height = 27
                Align = alTop
                BevelOuter = bvNone
                Color = clWindow
                TabOrder = 9
                object srnDBButtonPuesto: TsrnDBButtonEdit
                  Left = 13
                  Top = 2
                  DataBinding.DataField = 'cod_puesto'
                  DataBinding.DataSource = dsEVALUCIONCAB
                  ParentFont = False
                  Properties.Buttons = <
                    item
                      Default = True
                      Kind = bkEllipsis
                    end>
                  Properties.ClickKey = 112
                  Style.Font.Charset = ANSI_CHARSET
                  Style.Font.Color = clWindowText
                  Style.Font.Height = -13
                  Style.Font.Name = 'Verdana'
                  Style.Font.Style = []
                  Style.IsFontAssigned = True
                  TabOrder = 0
                  Width = 100
                end
                object snDBEdit8: TsnDBEdit
                  Left = 110
                  Top = 2
                  TabStop = False
                  DataBinding.DataField = 'desc_puesto'
                  DataBinding.DataSource = dsEVALUCIONCAB
                  ParentFont = False
                  Properties.Alignment.Horz = taLeftJustify
                  Properties.ReadOnly = True
                  Style.Font.Charset = ANSI_CHARSET
                  Style.Font.Color = clWindowText
                  Style.Font.Height = -13
                  Style.Font.Name = 'Verdana'
                  Style.Font.Style = []
                  Style.IsFontAssigned = True
                  TabOrder = 1
                  Width = 361
                end
              end
            end
            object Panel8: TPanel
              Left = 474
              Top = 0
              Width = 339
              Height = 218
              Align = alClient
              BevelOuter = bvNone
              Color = clWindow
              TabOrder = 0
              object Panel19: TPanel
                Left = 0
                Top = 6
                Width = 339
                Height = 171
                Align = alTop
                BevelOuter = bvNone
                Color = clWindow
                TabOrder = 0
                object ImagenLegajo: TsnImage
                  Left = 1
                  Top = 0
                  Width = 215
                  Height = 170
                  Center = True
                  Proportional = True
                  Stretch = True
                end
                object Label2: TLabel
                  Left = 240
                  Top = 24
                  Width = 56
                  Height = 13
                  Caption = 'Evaluaci'#243'n '
                end
                object Label3: TLabel
                  Left = 248
                  Top = 40
                  Width = 36
                  Height = 13
                  Caption = 'Vigente'
                end
                object snDBEdit10: TsnDBEdit
                  Left = 240
                  Top = 58
                  TabStop = False
                  DataBinding.DataField = 'vigente'
                  DataBinding.DataSource = dsEVALUCIONCAB
                  ParentFont = False
                  Properties.Alignment.Horz = taCenter
                  Properties.ReadOnly = True
                  Style.Color = 16756912
                  Style.Font.Charset = ANSI_CHARSET
                  Style.Font.Color = clGray
                  Style.Font.Height = -16
                  Style.Font.Name = 'Verdana'
                  Style.Font.Style = []
                  Style.IsFontAssigned = True
                  TabOrder = 0
                  Width = 49
                end
                object BotonPonerComoVig: TsnButton
                  Left = 221
                  Top = 96
                  Width = 105
                  Height = 25
                  Caption = 'Poner como Vigente'
                  TabOrder = 1
                  TabStop = False
                  LookAndFeel.Kind = lfOffice11
                end
              end
              object Panel20: TPanel
                Left = 0
                Top = 177
                Width = 339
                Height = 16
                Align = alTop
                BevelOuter = bvNone
                Color = 15658734
                TabOrder = 1
                object snLabel10: TsnLabel
                  Left = 38
                  Top = 0
                  Width = 143
                  Height = 16
                  Caption = 'PUNTAJE ALCANZADO'
                  Color = 10801663
                  Font.Charset = ANSI_CHARSET
                  Font.Color = clWindowText
                  Font.Height = -13
                  Font.Name = 'Verdana'
                  Font.Style = []
                  ParentColor = False
                  ParentFont = False
                end
              end
              object Panel21: TPanel
                Left = 0
                Top = 193
                Width = 339
                Height = 27
                Align = alTop
                BevelOuter = bvNone
                Color = clWindow
                TabOrder = 2
                object snDBEdit9: TsnDBEdit
                  Left = 36
                  Top = 2
                  TabStop = False
                  DataBinding.DataField = 'puntaje'
                  DataBinding.DataSource = dsEVALUCIONCAB
                  ParentFont = False
                  Properties.Alignment.Horz = taCenter
                  Properties.ReadOnly = True
                  Style.Font.Charset = ANSI_CHARSET
                  Style.Font.Color = clWindowText
                  Style.Font.Height = -13
                  Style.Font.Name = 'Verdana'
                  Style.Font.Style = []
                  Style.IsFontAssigned = True
                  TabOrder = 0
                  Width = 146
                end
              end
              object Panel11: TPanel
                Left = 0
                Top = 0
                Width = 339
                Height = 6
                Align = alTop
                BevelOuter = bvNone
                Color = clWindow
                TabOrder = 3
              end
            end
          end
        end
        object Panel22: TPanel
          Left = 0
          Top = 346
          Width = 819
          Height = 222
          Align = alTop
          Color = clWindow
          TabOrder = 1
          object Panel23: TPanel
            Left = 1
            Top = 1
            Width = 817
            Height = 22
            Align = alTop
            BevelOuter = bvNone
            Color = 10801663
            ParentBackground = True
            TabOrder = 0
            object snLabel11: TsnLabel
              Left = 176
              Top = 3
              Width = 113
              Height = 16
              Caption = 'COMPETENCIAS'
              Color = 10801663
              Font.Charset = ANSI_CHARSET
              Font.Color = clWindowText
              Font.Height = -13
              Font.Name = 'Verdana'
              Font.Style = [fsBold]
              ParentColor = False
              ParentFont = False
            end
          end
          object dxDBGridSN1: TdxDBGridSN
            Left = 1
            Top = 23
            Width = 817
            Height = 198
            Align = alClient
            TabOrder = 1
            LookAndFeel.Kind = lfFlat
            CriteriosPintarCelda = <>
            object dxDBGridSN1DBTableView1: TcxGridDBTableView
              NavigatorButtons.ConfirmDelete = False
              DataController.DataSource = DSTCompetenciasEval
              DataController.Summary.DefaultGroupSummaryItems = <>
              DataController.Summary.FooterSummaryItems = <>
              DataController.Summary.SummaryGroups = <>
              OptionsBehavior.FocusCellOnTab = True
              OptionsBehavior.FocusFirstCellOnNewRecord = True
              OptionsBehavior.GoToNextCellOnEnter = True
              OptionsCustomize.ColumnFiltering = False
              OptionsCustomize.ColumnSorting = False
              OptionsData.CancelOnExit = False
              OptionsData.Deleting = False
              OptionsData.DeletingConfirmation = False
              OptionsData.Inserting = False
              OptionsSelection.InvertSelect = False
              OptionsView.CellAutoHeight = True
              OptionsView.GroupByBox = False
              Styles.Header = cxStyle1
              object dxDBGridSN1DBTableView1orden: TcxGridDBColumn
                DataBinding.FieldName = 'orden'
                Visible = False
                SortIndex = 0
                SortOrder = soAscending
              end
              object dxDBGridSN1DBTableView1desc_competencia: TcxGridDBColumn
                DataBinding.FieldName = 'desc_competencia'
                HeaderAlignmentHorz = taCenter
                Options.Editing = False
                Options.Focusing = False
                Styles.Content = cxStyle1
                Width = 190
                IsCaptionAssigned = True
              end
              object dxDBGridSN1DBTableView1grado: TcxGridDBColumn
                Caption = 'Gr.'
                DataBinding.FieldName = 'nro_grado'
                HeaderAlignmentHorz = taCenter
                Styles.Content = cxStyle1
                Width = 30
              end
              object dxDBGridSN1DBTableView1Column1: TcxGridDBColumn
                Caption = '% Gr.'
                DataBinding.FieldName = 'porc_cump'
                HeaderAlignmentHorz = taCenter
                Options.Editing = False
                Options.Focusing = False
                Styles.Content = cxStyle1
                Width = 41
              end
              object dxDBGridSN1DBTableView1Column2: TcxGridDBColumn
                Caption = 'Descripci'#243'n'
                DataBinding.FieldName = 'descripcion'
                PropertiesClassName = 'TcxMemoProperties'
                Properties.ReadOnly = True
                HeaderAlignmentHorz = taCenter
                Options.Focusing = False
                Styles.Content = cxStyle1
                Width = 522
              end
            end
            object dxDBGridSN1Level1: TcxGridLevel
              GridView = dxDBGridSN1DBTableView1
            end
          end
        end
        object Panel24: TPanel
          Left = 0
          Top = 1230
          Width = 819
          Height = 1
          Align = alBottom
          TabOrder = 2
        end
        object Panel25: TPanel
          Left = 0
          Top = 568
          Width = 819
          Height = 164
          Align = alTop
          TabOrder = 3
          object Splitter1: TSplitter
            Left = 388
            Top = 23
            Height = 140
          end
          object Panel26: TPanel
            Left = 1
            Top = 1
            Width = 817
            Height = 22
            Align = alTop
            BevelOuter = bvNone
            Color = 10801663
            TabOrder = 0
            object snLabel13: TsnLabel
              Left = 24
              Top = 3
              Width = 298
              Height = 16
              Caption = 'ASPECTOS DESTACADOS DEL DESEMPE'#209'O'
              Color = 10801663
              Font.Charset = ANSI_CHARSET
              Font.Color = clWindowText
              Font.Height = -13
              Font.Name = 'Verdana'
              Font.Style = [fsBold]
              ParentColor = False
              ParentFont = False
            end
            object snLabel14: TsnLabel
              Left = 440
              Top = 3
              Width = 283
              Height = 16
              Caption = 'ASPECTOS A MEJORAR DEL DESEMPE'#209'O'
              Color = 10801663
              Font.Charset = ANSI_CHARSET
              Font.Color = clWindowText
              Font.Height = -13
              Font.Name = 'Verdana'
              Font.Style = [fsBold]
              ParentColor = False
              ParentFont = False
            end
          end
          object Panel27: TPanel
            Left = 1
            Top = 23
            Width = 387
            Height = 140
            Align = alLeft
            TabOrder = 1
            object dxDBGridSN3: TdxDBGridSN
              Left = 1
              Top = 1
              Width = 385
              Height = 138
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
                DataController.DataSource = DSAspectosDestacados
                DataController.Summary.DefaultGroupSummaryItems = <>
                DataController.Summary.FooterSummaryItems = <>
                DataController.Summary.SummaryGroups = <>
                OptionsBehavior.FocusCellOnTab = True
                OptionsBehavior.FocusFirstCellOnNewRecord = True
                OptionsBehavior.GoToNextCellOnEnter = True
                OptionsCustomize.ColumnFiltering = False
                OptionsCustomize.ColumnSorting = False
                OptionsData.Appending = True
                OptionsData.CancelOnExit = False
                OptionsData.Deleting = False
                OptionsData.DeletingConfirmation = False
                OptionsSelection.InvertSelect = False
                OptionsView.Navigator = True
                OptionsView.CellAutoHeight = True
                OptionsView.GroupByBox = False
                OptionsView.Header = False
                Styles.Header = cxStyle1
                object cxGridDBTableView1ASPECTO: TcxGridDBColumn
                  DataBinding.FieldName = 'ASPECTO'
                  PropertiesClassName = 'TcxMemoProperties'
                  Properties.MaxLength = 4000
                  Properties.ScrollBars = ssVertical
                  Options.Filtering = False
                  Styles.Content = cxStyle2
                  Width = 316
                end
                object cxGridDBTableView1Column1: TcxGridDBColumn
                  Caption = 'Activo'
                  DataBinding.FieldName = 'ACTIVO'
                  PropertiesClassName = 'TcxCheckBoxProperties'
                  HeaderAlignmentHorz = taCenter
                  Width = 48
                end
              end
              object cxGridLevel1: TcxGridLevel
                GridView = cxGridDBTableView1
              end
            end
          end
          object dxDBGridSN4: TdxDBGridSN
            Left = 391
            Top = 23
            Width = 427
            Height = 140
            Align = alClient
            TabOrder = 2
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
              DataController.DataSource = DSAspectosAMejorar
              DataController.Summary.DefaultGroupSummaryItems = <>
              DataController.Summary.FooterSummaryItems = <>
              DataController.Summary.SummaryGroups = <>
              OptionsBehavior.FocusCellOnTab = True
              OptionsBehavior.FocusFirstCellOnNewRecord = True
              OptionsBehavior.GoToNextCellOnEnter = True
              OptionsCustomize.ColumnFiltering = False
              OptionsCustomize.ColumnSorting = False
              OptionsData.Appending = True
              OptionsData.CancelOnExit = False
              OptionsData.Deleting = False
              OptionsData.DeletingConfirmation = False
              OptionsSelection.InvertSelect = False
              OptionsView.Navigator = True
              OptionsView.CellAutoHeight = True
              OptionsView.GroupByBox = False
              OptionsView.Header = False
              Styles.Header = cxStyle1
              object cxGridDBColumn1: TcxGridDBColumn
                DataBinding.FieldName = 'ASPECTO'
                PropertiesClassName = 'TcxMemoProperties'
                Properties.MaxLength = 4000
                Properties.ScrollBars = ssVertical
                Options.Filtering = False
                Styles.Content = cxStyle3
                Width = 316
              end
              object cxGridDBColumn2: TcxGridDBColumn
                Caption = 'Activo'
                DataBinding.FieldName = 'ACTIVO'
                PropertiesClassName = 'TcxCheckBoxProperties'
                HeaderAlignmentHorz = taCenter
                Width = 48
              end
            end
            object cxGridLevel2: TcxGridLevel
              GridView = cxGridDBTableView2
            end
          end
        end
        object Panel28: TPanel
          Left = 0
          Top = 732
          Width = 819
          Height = 105
          Align = alTop
          Color = clWindow
          TabOrder = 4
          object Panel29: TPanel
            Left = 1
            Top = 1
            Width = 817
            Height = 22
            Align = alTop
            BevelOuter = bvNone
            Color = 10801663
            TabOrder = 0
            object snLabel15: TsnLabel
              Left = 24
              Top = 3
              Width = 218
              Height = 16
              Caption = 'COMENTARIOS DEL EVALUADO'
              Color = 10801663
              Font.Charset = ANSI_CHARSET
              Font.Color = clWindowText
              Font.Height = -13
              Font.Name = 'Verdana'
              Font.Style = [fsBold]
              ParentColor = False
              ParentFont = False
            end
          end
          object snDBMemo1: TsnDBMemo
            Left = 1
            Top = 23
            Align = alClient
            DataBinding.DataField = 'comen_del_evaluado'
            DataBinding.DataSource = dsEVALUCIONCAB
            ParentFont = False
            Properties.MaxLength = 3990
            Properties.ScrollBars = ssVertical
            Style.Font.Charset = ANSI_CHARSET
            Style.Font.Color = clWindowText
            Style.Font.Height = -13
            Style.Font.Name = 'Verdana'
            Style.Font.Style = []
            Style.IsFontAssigned = True
            TabOrder = 1
            ReadOnlyAlways = False
            Height = 81
            Width = 817
          end
        end
        object Panel30: TPanel
          Left = 0
          Top = 837
          Width = 819
          Height = 145
          Align = alTop
          Color = clWindow
          TabOrder = 5
          object Splitter2: TSplitter
            Left = 388
            Top = 23
            Height = 121
          end
          object Panel31: TPanel
            Left = 1
            Top = 1
            Width = 817
            Height = 22
            Align = alTop
            BevelOuter = bvNone
            Color = 10801663
            TabOrder = 0
            object snLabel16: TsnLabel
              Left = 24
              Top = 3
              Width = 277
              Height = 16
              Caption = 'OBSERVACIONES GENERALES DE RRHH'
              Color = 10801663
              Font.Charset = ANSI_CHARSET
              Font.Color = clWindowText
              Font.Height = -13
              Font.Name = 'Verdana'
              Font.Style = [fsBold]
              ParentColor = False
              ParentFont = False
            end
            object snLabel17: TsnLabel
              Left = 454
              Top = 2
              Width = 295
              Height = 16
              Caption = 'OBSERVACIONES CODIFICADAS DE RRHH'
              Color = 10801663
              Font.Charset = ANSI_CHARSET
              Font.Color = clWindowText
              Font.Height = -13
              Font.Name = 'Verdana'
              Font.Style = [fsBold]
              ParentColor = False
              ParentFont = False
            end
          end
          object Panel32: TPanel
            Left = 1
            Top = 23
            Width = 387
            Height = 121
            Align = alLeft
            TabOrder = 1
            object dxDBGridSN5: TdxDBGridSN
              Left = 1
              Top = 1
              Width = 385
              Height = 119
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
                DataController.DataSource = dsTObsGenRRHH
                DataController.Summary.DefaultGroupSummaryItems = <>
                DataController.Summary.FooterSummaryItems = <>
                DataController.Summary.SummaryGroups = <>
                OptionsBehavior.FocusCellOnTab = True
                OptionsBehavior.FocusFirstCellOnNewRecord = True
                OptionsBehavior.GoToNextCellOnEnter = True
                OptionsCustomize.ColumnFiltering = False
                OptionsCustomize.ColumnSorting = False
                OptionsData.Appending = True
                OptionsData.CancelOnExit = False
                OptionsData.Deleting = False
                OptionsData.DeletingConfirmation = False
                OptionsSelection.InvertSelect = False
                OptionsView.Navigator = True
                OptionsView.CellAutoHeight = True
                OptionsView.GroupByBox = False
                OptionsView.Header = False
                Styles.Header = cxStyle1
                object cxGridDBColumn3: TcxGridDBColumn
                  DataBinding.FieldName = 'observacion'
                  PropertiesClassName = 'TcxMemoProperties'
                  Properties.MaxLength = 4000
                  Properties.ScrollBars = ssVertical
                  Options.Filtering = False
                  Styles.Content = cxStyle4
                  Width = 316
                end
                object cxGridDBColumn4: TcxGridDBColumn
                  Caption = 'Activo'
                  DataBinding.FieldName = 'activo'
                  PropertiesClassName = 'TcxCheckBoxProperties'
                  HeaderAlignmentHorz = taCenter
                  Width = 48
                end
              end
              object cxGridLevel3: TcxGridLevel
                GridView = cxGridDBTableView3
              end
            end
          end
          object dxDBGridSN6: TdxDBGridSN
            Left = 391
            Top = 23
            Width = 427
            Height = 121
            Align = alClient
            TabOrder = 2
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
              DataController.DataSource = DSObsCodif
              DataController.Summary.DefaultGroupSummaryItems = <>
              DataController.Summary.FooterSummaryItems = <>
              DataController.Summary.SummaryGroups = <>
              OptionsBehavior.FocusCellOnTab = True
              OptionsBehavior.FocusFirstCellOnNewRecord = True
              OptionsBehavior.GoToNextCellOnEnter = True
              OptionsCustomize.ColumnFiltering = False
              OptionsCustomize.ColumnSorting = False
              OptionsData.CancelOnExit = False
              OptionsData.Deleting = False
              OptionsData.DeletingConfirmation = False
              OptionsData.Editing = False
              OptionsData.Inserting = False
              OptionsSelection.InvertSelect = False
              OptionsView.Navigator = True
              OptionsView.CellAutoHeight = True
              OptionsView.GroupByBox = False
              OptionsView.Header = False
              Styles.Header = cxStyle1
              object cxGridDBColumn5: TcxGridDBColumn
                DataBinding.FieldName = 'observacion'
                PropertiesClassName = 'TcxMemoProperties'
                Properties.MaxLength = 4000
                Properties.ScrollBars = ssVertical
                Options.Filtering = False
                Width = 316
              end
            end
            object cxGridLevel4: TcxGridLevel
              GridView = cxGridDBTableView4
            end
          end
        end
        object PanelEstado1: TPanelEstado
          Left = 0
          Top = 982
          Width = 819
          Height = 124
          Align = alTop
          Color = clWindow
          TabOrder = 6
          Leyendas = <>
          object Panel33: TPanel
            Left = 1
            Top = 1
            Width = 817
            Height = 22
            Align = alTop
            BevelOuter = bvNone
            Color = 10801663
            TabOrder = 0
            object snLabel18: TsnLabel
              Left = 24
              Top = 3
              Width = 105
              Height = 16
              Caption = 'EVALUADORES'
              Color = 10801663
              Font.Charset = ANSI_CHARSET
              Font.Color = clWindowText
              Font.Height = -13
              Font.Name = 'Verdana'
              Font.Style = [fsBold]
              ParentColor = False
              ParentFont = False
            end
          end
          object dxDBGridSN7: TdxDBGridSN
            Left = 1
            Top = 23
            Width = 817
            Height = 100
            Align = alClient
            TabOrder = 1
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
              DataController.DataSource = DSEvaluadores
              DataController.Summary.DefaultGroupSummaryItems = <>
              DataController.Summary.FooterSummaryItems = <>
              DataController.Summary.SummaryGroups = <>
              OptionsBehavior.AlwaysShowEditor = True
              OptionsBehavior.FocusCellOnTab = True
              OptionsBehavior.FocusFirstCellOnNewRecord = True
              OptionsBehavior.GoToNextCellOnEnter = True
              OptionsCustomize.ColumnFiltering = False
              OptionsCustomize.ColumnSorting = False
              OptionsData.Appending = True
              OptionsData.CancelOnExit = False
              OptionsData.Deleting = False
              OptionsData.DeletingConfirmation = False
              OptionsSelection.InvertSelect = False
              OptionsView.Navigator = True
              OptionsView.CellAutoHeight = True
              OptionsView.GroupByBox = False
              Styles.Header = cxStyle1
              object cxGridDBTableView5cod_legajo: TcxGridDBColumn
                Caption = 'Legajo'
                DataBinding.FieldName = 'cod_legajo'
                PropertiesClassName = 'TcxButtonEditProperties'
                Properties.Buttons = <
                  item
                    Default = True
                    Kind = bkEllipsis
                  end>
                Properties.ClickKey = 112
                HeaderAlignmentHorz = taCenter
                Width = 97
              end
              object cxGridDBTableView5desc_legajo: TcxGridDBColumn
                Caption = 'Apellido y Nombre'
                DataBinding.FieldName = 'desc_legajo'
                HeaderAlignmentHorz = taCenter
                Options.Editing = False
                Options.Focusing = False
                Width = 245
              end
              object cxGridDBTableView5firmado: TcxGridDBColumn
                Caption = 'Firmado?'
                DataBinding.FieldName = 'firmado'
                PropertiesClassName = 'TcxLookupComboBoxProperties'
                Properties.KeyFieldNames = 'valor'
                Properties.ListColumns = <
                  item
                    FieldName = 'descripcion'
                  end>
                Properties.ListOptions.ShowHeader = False
                Properties.ListSource = DSSiNo
                HeaderAlignmentHorz = taCenter
                Width = 66
              end
              object cxGridDBTableView5fec_firmado: TcxGridDBColumn
                Caption = 'Fec. Firma'
                DataBinding.FieldName = 'fec_firmado'
                PropertiesClassName = 'TcxDateEditProperties'
                HeaderAlignmentHorz = taCenter
                Width = 86
              end
              object cxGridDBTableView5Column1: TcxGridDBColumn
                Caption = 'Puesto'
                DataBinding.FieldName = 'puesto'
                HeaderAlignmentHorz = taCenter
                Options.Editing = False
                Options.Focusing = False
                Width = 214
              end
              object cxGridDBTableView5activo: TcxGridDBColumn
                Caption = 'Activo'
                DataBinding.FieldName = 'activo'
                PropertiesClassName = 'TcxCheckBoxProperties'
                HeaderAlignmentHorz = taCenter
                Width = 53
              end
            end
            object cxGridLevel5: TcxGridLevel
              GridView = cxGridDBTableView5
            end
          end
        end
        object Panel34: TPanel
          Left = 0
          Top = 1106
          Width = 819
          Height = 124
          Align = alTop
          Color = clWindow
          TabOrder = 8
          TabStop = True
          object Panel35: TPanel
            Left = 1
            Top = 1
            Width = 817
            Height = 22
            Align = alTop
            BevelOuter = bvNone
            Color = 10801663
            TabOrder = 0
            object snLabel19: TsnLabel
              Left = 24
              Top = 3
              Width = 55
              Height = 16
              Caption = 'FIRMAS'
              Color = 10801663
              Font.Charset = ANSI_CHARSET
              Font.Color = clWindowText
              Font.Height = -13
              Font.Name = 'Verdana'
              Font.Style = [fsBold]
              ParentColor = False
              ParentFont = False
            end
          end
          object dxDBGridSN8: TdxDBGridSN
            Left = 1
            Top = 23
            Width = 817
            Height = 100
            Align = alClient
            TabOrder = 1
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
              DataController.DataSource = DSFirmas
              DataController.Summary.DefaultGroupSummaryItems = <>
              DataController.Summary.FooterSummaryItems = <>
              DataController.Summary.SummaryGroups = <>
              OptionsBehavior.AlwaysShowEditor = True
              OptionsBehavior.FocusCellOnTab = True
              OptionsBehavior.FocusFirstCellOnNewRecord = True
              OptionsBehavior.GoToNextCellOnEnter = True
              OptionsCustomize.ColumnFiltering = False
              OptionsCustomize.ColumnSorting = False
              OptionsData.Appending = True
              OptionsData.CancelOnExit = False
              OptionsData.Deleting = False
              OptionsData.DeletingConfirmation = False
              OptionsSelection.InvertSelect = False
              OptionsView.Navigator = True
              OptionsView.CellAutoHeight = True
              OptionsView.GroupByBox = False
              Styles.Header = cxStyle1
              object cxGridDBColumn6: TcxGridDBColumn
                Caption = 'Legajo'
                DataBinding.FieldName = 'cod_legajo_firma'
                PropertiesClassName = 'TcxButtonEditProperties'
                Properties.Buttons = <
                  item
                    Default = True
                    Kind = bkEllipsis
                  end>
                Properties.ClickKey = 112
                HeaderAlignmentHorz = taCenter
                Width = 97
              end
              object cxGridDBColumn7: TcxGridDBColumn
                Caption = 'Apellido y Nombre'
                DataBinding.FieldName = 'desc_legajo_firma'
                HeaderAlignmentHorz = taCenter
                Options.Editing = False
                Options.Focusing = False
                Width = 245
              end
              object cxGridDBColumn8: TcxGridDBColumn
                Caption = 'Firmado?'
                DataBinding.FieldName = 'firmo'
                PropertiesClassName = 'TcxLookupComboBoxProperties'
                Properties.KeyFieldNames = 'valor'
                Properties.ListColumns = <
                  item
                    FieldName = 'descripcion'
                  end>
                Properties.ListOptions.ShowHeader = False
                Properties.ListSource = DSSiNo
                HeaderAlignmentHorz = taCenter
                Width = 66
              end
              object cxGridDBColumn9: TcxGridDBColumn
                Caption = 'Fec. Firma'
                DataBinding.FieldName = 'fec_firma'
                PropertiesClassName = 'TcxDateEditProperties'
                HeaderAlignmentHorz = taCenter
                Width = 86
              end
              object cxGridDBColumn10: TcxGridDBColumn
                Caption = 'Puesto'
                DataBinding.FieldName = 'puesto'
                HeaderAlignmentHorz = taCenter
                Options.Editing = False
                Options.Focusing = False
                Width = 214
              end
              object cxGridDBColumn11: TcxGridDBColumn
                Caption = 'Activo'
                DataBinding.FieldName = 'activo'
                PropertiesClassName = 'TcxCheckBoxProperties'
                HeaderAlignmentHorz = taCenter
                Width = 53
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
  inherited DriverABM: TDriverABM
    OperTraerObjeto = 'TraerEvaluacionCompetencias'
    OperGrabarObjeto = 'SaveEvaluacionCompetencias'
    CargaDataSets = <
      item
        DataSet = TLeyendasReporte
        TableName = 'TLeyendasReporte'
      end
      item
        DataSet = TEvaluacionCAB
        TableName = 'TEvaluacionCAB'
      end
      item
        DataSet = TModelosVigentes
        TableName = 'TModelosVigentes'
      end
      item
        DataSet = TValorClaifEntidad
        TableName = 'TValorClaifEntidad'
      end
      item
        DataSet = TDatosLegajo
        TableName = 'TDatosLegajo'
      end
      item
        DataSet = TCompetenciasEval
        TableName = 'TCompetenciasEval'
      end
      item
        DataSet = TEvalCarga
        TableName = 'TEvalCarga'
      end
      item
        DataSet = TOtrasVersiones
        TableName = 'TOtrasVersiones'
      end
      item
        DataSet = TAspectosDestacados
        TableName = 'TAspectosDestacados'
      end
      item
        DataSet = TAspectosAMejorar
        TableName = 'TAspectosAMejorar'
      end
      item
        DataSet = TObsGenRRHH
        TableName = 'TObsGenRRHH'
      end
      item
        DataSet = TObsCodif
        TableName = 'TObsCodif'
      end
      item
        DataSet = TEvaluadores
        TableName = 'TEvaluadores'
      end
      item
        DataSet = TFirmas
        TableName = 'TFirmas'
      end
      item
        DataSet = TFirmasTemp
        TableName = 'TFirmasTemp'
      end>
    BajaLogica = <
      item
        DataSet = TEvaluacionCAB
        ValorBaja = 'false'
        ValorRehabilitacion = 'true'
        TipoBajaRegistro = tblCurrentRecord
        FieldName = 'activo'
      end>
    OperHabilitadas = [toOperNuevo, toOperModificar, toOperEliminar, toOperBuscar, toOperImprimir, toOperNavegacion, toOperRehabilitar]
    DataSetCab = TEvaluacionCAB
    DataSetDet1 = TCompetenciasEval
    DataSetDet2 = TAspectosDestacados
    DataSetDet3 = TAspectosAMejorar
    DataSetDet4 = TObsGenRRHH
    DataSetDet5 = TEvaluadores
    DataSetDet6 = TFirmas
    ControlFocoAlta = snDBLookup1
    ControlFocoModif = srnDBButtonPuesto
  end
  inherited TOidObjSave: TsnTable
    Left = 440
    Top = 24
  end
  inherited TOpcHabPrograma: TsnTable
    Left = 448
    Top = 40
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
      '    snDBLookup1.setFoco;'
      'end.')
    OnValidate = <
      item
        TableName = 'TEvaluacionCAB'
        FieldName = 'cod_legajo'
        Source.Strings = (
          'begin'
          ''
          
            '   if (TEvaluacionCAB.FieldName('#39'oid_mod_eval_cab'#39').AsInteger = ' +
            '0)'
          
            '      then raiseException(erCustomError,'#39'Debe seleccionar el mod' +
            'elo de Evaluaci'#243'n'#39');'
          ''
          '   if (DriverABM.isNuevo)'
          
            '       then validarCargaEval(Sender.AsString,TEvaluacionCAB.Fiel' +
            'dName('#39'oid_mod_eval_cab'#39').AsInteger);'
          ''
          '  ValidadorLegajo.Value := Sender.AsString;'
          '  ValidadorLegajo.Validar();'
          ''
          'end.')
      end
      item
        TableName = 'TEvaluacionCAB'
        FieldName = 'cod_empresa'
        Source.Strings = (
          'begin'
          '  ValidarValorClasifEntidadEmpresa(Sender.AsString);'
          'end.')
      end
      item
        TableName = 'TEvaluacionCAB'
        FieldName = 'cod_sector'
        Source.Strings = (
          'begin'
          '    ValidarValorClasifEntidadSector(Sender.AsString);'
          'end.')
      end
      item
        TableName = 'TEvaluacionCAB'
        FieldName = 'cod_puesto'
        Source.Strings = (
          'begin'
          '    ValidarValorClasifEntidadPuesto(Sender.AsString);'
          'end.')
      end
      item
        TableName = 'TCompetenciasEval'
        FieldName = 'nro_grado'
        Source.Strings = (
          'begin'
          '  if (TCompetenciasEval.FieldName('#39'nro_grado'#39').AsString<>'#39#39')'
          '      then begin '
          '              operacion.InicioOperacion();'
          '              operacion.setOper('#39'ValidarGradoCompe'#39');'
          
            '              operacion.AddAtribute('#39'oid_mod_eval_compe'#39', TCompe' +
            'tenciasEval.FieldName('#39'oid_compe_eval'#39').AsString);'
          
            '              operacion.AddAtribute('#39'nro_grado'#39', TCompetenciasEv' +
            'al.FieldName('#39'nro_grado'#39').AsString);'
          '              operacion.execute();'
          '              end;'
          'end.')
      end
      item
        TableName = 'TEvaluacionCAB'
        FieldName = 'cod_estado'
        Source.Strings = (
          'begin'
          '    ValidarValorClasifEntidadEstado(Sender.AsString);'
          'end.')
      end
      item
        TableName = 'TEvaluadores'
        FieldName = 'cod_legajo'
        Source.Strings = (
          'begin'
          '  ValidadorLegajos1.Value := Sender.AsString;'
          '  ValidadorLegajos1.Validar();'
          'end.')
      end
      item
        TableName = 'TFirmas'
        FieldName = 'cod_legajo_firma'
        Source.Strings = (
          'begin'
          '  ValidadorLegajos2.Value := Sender.AsString;'
          '  ValidadorLegajos2.Validar();'
          'end.')
      end>
    OnChangeField = <
      item
        TableName = 'TEvaluacionCAB'
        FieldName = 'oid_legajo'
        Source.Strings = (
          'begin'
          ''
          '   TraerDatosLegajo(Sender.AsInteger,'
          
            '                                TEvaluacionCAB.FieldName('#39'oid_mo' +
            'd_eval_cab'#39').AsInteger , '
          
            '                                TEvaluacionCAB.FieldName('#39'oid_ev' +
            'al_cab'#39').AsInteger);'
          ''
          '  if (Sender.AsInteger>0)'
          '     then begin'
          '             srnDBButtonEdit1.setEnable(false);'
          '             snDBLookup1.setEnable(false);'
          '             end;'
          ''
          'end.')
      end>
    OnBeforePost = <
      item
        TableName = 'TAspectosDestacados'
        Source.Strings = (
          'begin'
          ''
          'end.')
      end
      item
        TableName = 'TEvaluadores'
        Source.Strings = (
          'begin'
          '  if (DataSet.FieldName('#39'oid_legajo'#39').AsInteger = 0)'
          
            '     then raiseException(erCustomError,'#39'Debe ingresar el Legajo'#39 +
            ');'
          'end.')
      end>
    OnNuevoRegistro = <
      item
        TableName = 'TEvaluacionCAB'
        Source.Strings = (
          'begin'
          '  DataSet.FieldName('#39'activo'#39').AsBoolean := True;'
          'end.')
      end
      item
        TableName = 'TAspectosDestacados'
        Source.Strings = (
          'begin'
          
            '  DataSet.FieldName('#39'OID_EVAL_CAB'#39').AsInteger := TEvaluacionCAB.' +
            'FieldName('#39'oid_eval_cab'#39').AsInteger;'
          '  DataSet.FieldName('#39'activo'#39').AsBoolean := True;'
          '  DataSet.FieldName('#39'TIPO_ASPECTO'#39').AsString := '#39'DES'#39';'
          'end.')
      end
      item
        TableName = 'TAspectosAMejorar'
        Source.Strings = (
          'begin'
          
            '  DataSet.FieldName('#39'OID_EVAL_CAB'#39').AsInteger := TEvaluacionCAB.' +
            'FieldName('#39'oid_eval_cab'#39').AsInteger;'
          '  DataSet.FieldName('#39'activo'#39').AsBoolean := True;'
          '  DataSet.FieldName('#39'TIPO_ASPECTO'#39').AsString := '#39'MEJ'#39';'
          'end.')
      end
      item
        TableName = 'TObsGenRRHH'
        Source.Strings = (
          'begin'
          
            '  DataSet.FieldName('#39'OID_EVAL_CAB'#39').AsInteger := TEvaluacionCAB.' +
            'FieldName('#39'oid_eval_cab'#39').AsInteger;'
          '  DataSet.FieldName('#39'activo'#39').AsBoolean := True;'
          'end.')
      end
      item
        TableName = 'TEvaluadores'
        Source.Strings = (
          'begin'
          
            '  DataSet.FieldName('#39'oid_eval_cab'#39').AsInteger := TEvaluacionCAB.' +
            'FieldName('#39'oid_eval_cab'#39').AsInteger;'
          '  DataSet.FieldName('#39'activo'#39').AsBoolean := True;'
          '  DataSet.FieldName('#39'firmado'#39').AsBoolean := True;'
          '  DataSet.FieldName('#39'fec_firmado'#39').Value := varios.getFecha();'
          'end.')
      end
      item
        TableName = 'TFirmas'
        Source.Strings = (
          'begin'
          
            '   DataSet.FieldName('#39'oid_eval_cab'#39').AsInteger := TEvaluacionCAB' +
            '.FieldName('#39'oid_eval_cab'#39').AsInteger;'
          '   DataSet.FieldName('#39'activo'#39').AsBoolean := true;'
          'end.')
      end>
    OnDblClick = <
      item
        CompoName = 'dxDBGridSN2DBTableView1'
        Source.Strings = (
          'begin'
          ''
          '  if (DriverABM.isBrowse())'
          '      then begin'
          '              operacion.InicioOperacion();'
          '              operacion.setOper('#39'TraerEvaluacionCompetencias'#39');'
          
            '              operacion.AddAtribute('#39'oid'#39', TOtrasVersiones.Field' +
            'Name('#39'oid_otra_eval'#39').AsString);'
          '              operacion.execute();'
          '              end;'
          'end.')
      end
      item
        CompoName = 'dxDBGridSN1DBTableView1'
        Source.Strings = (
          'begin'
          ''
          '   if (not DriverABM.isBrowse) then exit;'
          ' '
          '   variable.newVariantArray('#39'parametros'#39',2);'
          
            '   variable.addKeyValueForArray('#39'parametros'#39',0,'#39'oid_competencia'#39 +
            ',TCompetenciasEval.FieldName('#39'oid_competencia'#39').AsInteger);  '
          
            '   variable.addKeyValueForArray('#39'parametros'#39',1,'#39'oid_eval_cab'#39',TC' +
            'ompetenciasEval.FieldName('#39'oid_eval_cab'#39').AsInteger);  '
          ''
          
            '   formConsVerCompetencia.params :=  variable.getValue('#39'parametr' +
            'os'#39');'
          '   //formConsVerCompetencia.Ventana := getVentana();'
          '   formConsVerCompetencia.ShowModal();'
          ''
          ' end.')
      end>
    OnPublicVariable = <
      item
        VariableName = 'OPEN_BY_ID'
      end
      item
        VariableName = 'oid_cco'
      end>
    OnInicializar = <
      item
        Source.Strings = (
          'begin'
          '  TraerLeyendasReporte();'
          '  TraerLogoReporte();'
          '  dxDBGridSN2.ActivarEventoPintarCeldas();'
          '  cargarSINO();'
          '  compo.exec('#39'SNScrollBox1'#39','#39'setPosIni'#39');'
          'end.')
      end>
    OnAfterTraerObjeto = <
      item
        Source.Strings = (
          'begin'
          '  TraerImagenLegajo()'
          'end.')
      end>
    OnAfterModificar = <
      item
        Source.Strings = (
          'begin'
          '  srnDBButtonEdit1.setEnable(false);'
          '  snDBLookup1.setEnable(false);'
          '  snDBEdit4.setFoco();'
          '  compo.exec('#39'SNScrollBox1'#39','#39'setPosIni'#39');'
          '  dxDBGridSN1.setFoco();'
          'end.')
      end>
    OnPrint = <
      item
        Source.Strings = (
          'begin'
          
            '    ImpresorEvaluacion.setInteger('#39'oid_cco'#39',TEvaluacionCAB.Field' +
            'Name('#39'oid_eval_cab'#39').AsInteger);'
          '    ImpresorEvaluacion.Mostrar(true);'
          'end.')
      end>
    OnFormFunction = <
      item
        Source.Strings = (
          'procedure TraerLeyendasReporte();'
          'begin'
          '  operacion.InicioOperacion();'
          '  operacion.setOper('#39'TraerLeyendasRepEval'#39');'
          '  operacion.execute();'
          'end;'
          ''
          'procedure TraerLogoReporte();'
          'var'
          '  mensajeError  : string;'
          '  nomTempFile : string;'
          'begin'
          '  operacion.InicioOperacion();'
          '  operacion.setOper('#39'DownLoadLogoRepEval'#39');'
          '  nomTempFile := operacion.DownLoadFile('#39'0'#39', mensajeError);'
          '  ImagenLogo.LoadFromFile(nomTempFile);'
          'end;'
          ''
          'procedure traerModelosVig();'
          'begin'
          '  operacion.InicioOperacion();'
          '  operacion.setOper('#39'TraerModelosEvalVig'#39');'
          '  operacion.AddAtribute('#39'DESEM'#39','#39#39');'
          '  operacion.execute();'
          'end;'
          ''
          'procedure MostrarHelpValoresClasifEmpresa();'
          'begin   '
          '   HelpValoresClasifEmpresa.NickName           :=  '#39'su.Legajo'#39';'
          
            '   HelpValoresClasifEmpresa.NroClasificador    :=  TLeyendasRepo' +
            'rte.FieldName('#39'nro_clasif_empresa'#39').AsInteger;'
          '   HelpValoresClasifEmpresa.Mostrar();'
          'end;'
          ''
          'procedure MostrarHelpValoresClasifSector();'
          'begin   '
          '   HelpValoresClasifSector.NickName           :=  '#39'su.Legajo'#39';'
          
            '   HelpValoresClasifSector.NroClasificador    :=  TLeyendasRepor' +
            'te.FieldName('#39'nro_clasif_sector'#39').AsInteger;'
          '   HelpValoresClasifSector.Mostrar();'
          'end;'
          ''
          'procedure MostrarHelpValoresClasifPuesto();'
          'begin   '
          '   HelpValoresClasifPuesto.NickName           :=  '#39'su.Legajo'#39';'
          
            '   HelpValoresClasifPuesto.NroClasificador    :=  TLeyendasRepor' +
            'te.FieldName('#39'nro_clasif_puesto'#39').AsInteger;'
          '   HelpValoresClasifPuesto.Mostrar();'
          'end;'
          ''
          ''
          ''
          'procedure ValidarValorClasifEntidadEmpresa(codigo : string);'
          'begin'
          ''
          '  if (codigo = '#39#39')'
          '     then begin'
          '             TEvaluacionCAB.EditRecord;'
          
            '             TEvaluacionCAB.FieldName('#39'oid_empresa'#39').AsInteger :' +
            '= 0;'
          
            '             TEvaluacionCAB.FieldName('#39'desc_empresa'#39').AsString :' +
            '= '#39#39';'
          '             exit;'
          '             end;'
          ''
          '  operacion.inicioOperacion;'
          '  operacion.setOper('#39'TraerValorClasifEntidad'#39');'
          
            '  operacion.addAtribute('#39'oid_clasif_ent'#39',TLeyendasReporte.FieldN' +
            'ame('#39'oid_clasif_empresa'#39').AsString);'
          '  operacion.addAtribute('#39'codigo'#39',codigo);'
          '  operacion.execute;'
          ''
          '  TEvaluacionCAB.EditRecord;'
          '  TEvaluacionCAB.FieldName('#39'oid_empresa'#39').AsInteger :='
          
            '       TValorClaifEntidad.FieldName('#39'oid_valor_clasif_ent'#39').AsIn' +
            'teger;'
          '  TEvaluacionCAB.FieldName('#39'desc_empresa'#39').AsString :='
          '      TValorClaifEntidad.FieldName('#39'descripcion'#39').AsString;'
          ''
          'end;'
          ''
          'procedure ValidarValorClasifEntidadEstado(codigo : string);'
          'begin'
          ''
          '  if (codigo = '#39#39')'
          '     then begin'
          '             TEvaluacionCAB.EditRecord;'
          
            '             TEvaluacionCAB.FieldName('#39'oid_estado'#39').AsInteger :=' +
            ' 0;'
          
            '             TEvaluacionCAB.FieldName('#39'desc_estado'#39').AsString :=' +
            ' '#39#39';'
          '             exit;'
          '             end;'
          ''
          '  operacion.inicioOperacion;'
          '  operacion.setOper('#39'TraerValorClasifEntidad'#39');'
          
            '  operacion.addAtribute('#39'oid_clasif_ent'#39',TLeyendasReporte.FieldN' +
            'ame('#39'oid_clasif_estado'#39').AsString);'
          '  operacion.addAtribute('#39'codigo'#39',codigo);'
          '  operacion.execute;'
          ''
          '  TEvaluacionCAB.EditRecord;'
          '  TEvaluacionCAB.FieldName('#39'oid_estado'#39').AsInteger :='
          
            '       TValorClaifEntidad.FieldName('#39'oid_valor_clasif_ent'#39').AsIn' +
            'teger;'
          '  TEvaluacionCAB.FieldName('#39'desc_estado'#39').AsString :='
          '      TValorClaifEntidad.FieldName('#39'descripcion'#39').AsString;'
          ''
          'end;'
          ''
          ''
          ''
          'procedure ValidarValorClasifEntidadSector(codigo : string);'
          'begin'
          ''
          '  if (codigo = '#39#39')'
          '     then begin'
          '             TEvaluacionCAB.EditRecord;'
          
            '             TEvaluacionCAB.FieldName('#39'oid_sector'#39').AsInteger :=' +
            ' 0;'
          
            '             TEvaluacionCAB.FieldName('#39'desc_sector'#39').AsString :=' +
            ' '#39#39';'
          '             exit;'
          '             end;'
          ''
          '  operacion.inicioOperacion;'
          '  operacion.setOper('#39'TraerValorClasifEntidad'#39');'
          
            '  operacion.addAtribute('#39'oid_clasif_ent'#39',TLeyendasReporte.FieldN' +
            'ame('#39'oid_clasif_sector'#39').AsString);'
          '  operacion.addAtribute('#39'codigo'#39',codigo);'
          '  operacion.execute;'
          ''
          '  TEvaluacionCAB.EditRecord;'
          '  TEvaluacionCAB.FieldName('#39'oid_sector'#39').AsInteger :='
          
            '       TValorClaifEntidad.FieldName('#39'oid_valor_clasif_ent'#39').AsIn' +
            'teger;'
          '  TEvaluacionCAB.FieldName('#39'desc_sector'#39').AsString :='
          '      TValorClaifEntidad.FieldName('#39'descripcion'#39').AsString;'
          ''
          'end;'
          ''
          'procedure ValidarValorClasifEntidadPuesto(codigo : string);'
          'begin'
          ''
          '  if (codigo = '#39#39')'
          '     then begin'
          '             TEvaluacionCAB.EditRecord;'
          
            '             TEvaluacionCAB.FieldName('#39'oid_puesto'#39').AsInteger :=' +
            ' 0;'
          
            '             TEvaluacionCAB.FieldName('#39'desc_puesto'#39').AsString :=' +
            ' '#39#39';'
          '             exit;'
          '             end;'
          ''
          '  operacion.inicioOperacion;'
          '  operacion.setOper('#39'TraerValorClasifEntidad'#39');'
          
            '  operacion.addAtribute('#39'oid_clasif_ent'#39',TLeyendasReporte.FieldN' +
            'ame('#39'oid_clasif_puesto'#39').AsString);'
          '  operacion.addAtribute('#39'codigo'#39',codigo);'
          '  operacion.execute;'
          ''
          '  TEvaluacionCAB.EditRecord;'
          '  TEvaluacionCAB.FieldName('#39'oid_puesto'#39').AsInteger :='
          
            '       TValorClaifEntidad.FieldName('#39'oid_valor_clasif_ent'#39').AsIn' +
            'teger;'
          '  TEvaluacionCAB.FieldName('#39'desc_puesto'#39').AsString :='
          '      TValorClaifEntidad.FieldName('#39'descripcion'#39').AsString;'
          ''
          'end;'
          ''
          'procedure TraerImagenLegajo();'
          'var'
          '  mensajeError  : string;'
          '  nomTempFile : string;'
          'begin'
          '  operacion.InicioOperacion();'
          '  operacion.setOper('#39'DownLoadImageLegajo'#39');'
          
            '  nomTempFile := operacion.DownLoadFile(TEvaluacionCAB.FieldName' +
            '('#39'cod_legajo'#39').AsString, mensajeError);'
          '  ImagenLegajo.LoadFromFile(nomTempFile);'
          'end;'
          ''
          ''
          
            'procedure TraerDatosLegajo(oidLegajo : integer ; oidModEvalCab :' +
            ' integer ; oidEvalCab : integer);'
          'begin'
          ''
          '  if (oidLegajo=0)'
          '    then begin'
          '            TEvaluacionCAB.EditRecord;'
          
            '            TEvaluacionCAB.FieldName('#39'cod_empresa'#39').AsString := ' +
            #39#39'; '
          
            '            TEvaluacionCAB.FieldName('#39'cod_sector'#39').AsString := '#39 +
            #39';'
          
            '            TEvaluacionCAB.FieldName('#39'cod_puesto'#39').AsString := '#39 +
            #39';'
          
            '            TEvaluacionCAB.FieldName('#39'cod_estado'#39').AsString := '#39 +
            #39';'
          ''
          '            TEvaluacionCAB.FieldName('#39'oid_cond_mod_eval'#39').Clear;'
          '       '
          '            ImagenLegajo.BorrarImagen();'
          ''
          '            end'
          '    else  begin'
          ''
          '            operacion.InicioOperacion();'
          '            operacion.setOper('#39'TraerDatosLegEvalRH'#39');'
          
            '            operacion.AddAtribute('#39'oid_legajo'#39',IntToStr(oidLegaj' +
            'o));'
          
            '            operacion.AddAtribute('#39'oid_mod_eval_cab'#39', intToStr(o' +
            'idModEvalCab));'
          
            '            operacion.AddAtribute('#39'oid_eval_cab'#39',inttostr(oidEva' +
            'lCab));'
          '            operacion.execute();'
          ''
          '            TEvaluacionCAB.EditRecord;'
          
            '            TEvaluacionCAB.FieldName('#39'cod_empresa'#39').AsString := ' +
            'TDatosLegajo.FieldName('#39'cod_valor_empresa'#39').AsString; '
          
            '            TEvaluacionCAB.FieldName('#39'cod_sector'#39').AsString := T' +
            'DatosLegajo.FieldName('#39'cod_valor_sector'#39').AsString; '
          
            '            TEvaluacionCAB.FieldName('#39'cod_puesto'#39').AsString := T' +
            'DatosLegajo.FieldName('#39'cod_valor_puesto'#39').AsString; '
          
            '            TEvaluacionCAB.FieldName('#39'cod_estado'#39').AsString := T' +
            'DatosLegajo.FieldName('#39'cod_valor_estado'#39').AsString;  '
          ''
          
            '            TEvaluacionCAB.FieldName('#39'oid_cond_mod_eval'#39').AsInte' +
            'ger :=  TDatosLegajo.FieldName('#39'oid_cond_modelo'#39').AsInteger; '
          ''
          '            TFirmas.First; '
          '            while (not TFirmas.EOF) do'
          '                begin'
          ''
          
            '                if (TFirmas.FieldName('#39'oid_firma_eval'#39').AsIntege' +
            'r<0)'
          '                   then begin'
          '                           TFirmas.borrar;'
          '                           continue;'
          '                           end;'
          ''
          '               TFirmas.next;'
          '                end;'
          ' '
          '            TFirmasTemp.First;'
          '            while (not TFirmasTemp.EOF) do'
          '                begin'
          ' '
          '                TFirmas.AppendRecord;'
          
            '                TFirmas.FieldName('#39'oid_eval_cab'#39').AsInteger := o' +
            'idEvalCab;'
          
            '                TFirmas.FieldName('#39'nro_firma'#39').AsInteger :=  TFi' +
            'rmasTemp.FieldName('#39'nro_firma'#39').AsInteger;'
          
            '                TFirmas.FieldName('#39'cod_legajo_firma'#39').AsString :' +
            '= TFirmasTemp.FieldName('#39'cod_legajo_firma'#39').AsString;'
          '                TFirmas.FieldName('#39'firmo'#39').AsBoolean := False;'
          '                TFirmas.FieldName('#39'activo'#39').AsBoolean := True;'
          
            '                TFirmas.FieldName('#39'puesto'#39').AsString := TFirmasT' +
            'emp.FieldName('#39'puesto'#39').AsString;'
          ''
          '                TFirmas.PostRecord; '
          ''
          '                TFirmasTemp.next;'
          '                end;'
          ''
          '            TraerImagenLegajo();'
          ''
          '            end; '
          'end;'
          ''
          'procedure InitAlta();'
          'begin'
          '   TModelosVigentes.First;'
          '   TEvaluacionCAB.EditRecord;'
          
            '   TEvaluacionCAB.FieldName('#39'oid_mod_eval_cab'#39').AsInteger := TMo' +
            'delosVigentes.FieldName('#39'oid_mod_eval_cab'#39').AsInteger;'
          
            '   TEvaluacionCAB.FieldName('#39'fec_eval'#39').Value := Varios.getFecha' +
            '();  '
          'end;'
          ''
          
            'procedure validarCargaEval(NroLegajo : string; OidModelo : integ' +
            'er);'
          'begin'
          ''
          '   if (Trim(NroLegajo)='#39#39') then exit;'
          ''
          '   if (OidModelo = 0) then exit;'
          ''
          '   operacion.InicioOperacion();'
          '   operacion.setOper('#39'ValidarCargaEvalLeg'#39');'
          '   operacion.AddAtribute('#39'nro_legajo'#39',NroLegajo);'
          
            '   operacion.AddAtribute('#39'oid_mod_eval_cab'#39',IntToStr(OidModelo))' +
            ';'
          '   operacion.execute();'
          ''
          '   if (not TEvalCarga.IsEmpty)'
          '  then begin'
          
            '       if (not mensaje.question('#39'Ya se cargo una evaluaci'#243'n con ' +
            'fecha '#39'+TEvalCarga.FieldName('#39'fecha'#39').AsString+'#39'. Desea cargar u' +
            'na nueva Evaluaci'#243'n?'#39'))'
          '           then begin'
          '                abort; '
          '                end;'
          '       end; '
          ''
          'end;'
          ''
          'procedure setPonerComoVigente();'
          'begin'
          ''
          '  if (TEvaluacionCAB.FieldName('#39'oid_eval_cab'#39').AsInteger =0)'
          
            '      then raiseException(erCustomError,'#39'Debe ingresar la Evalua' +
            'ci'#243'n'#39');'
          ''
          '  operacion.InicioOperacion();'
          '  operacion.setOper('#39'PonerVigEvaluacion'#39');'
          
            '  operacion.AddAtribute('#39'oid_eval_leg'#39', TEvaluacionCAB.FieldName' +
            '('#39'oid_eval_cab'#39').AsString);'
          '  operacion.execute(); '
          ''
          'end;'
          ''
          'procedure cargarSINO();'
          'begin'
          ''
          '  TSiNo.Close;'
          '  TSiNo.Open;'
          ''
          '  TSiNo.AppendRecord;'
          '  TSiNo.FieldName('#39'valor'#39').AsBoolean := True;'
          '  TSiNo.FieldName('#39'descripcion'#39').AsString := '#39'SI'#39';'
          '  TSiNo.PostRecord;'
          ''
          '  TSiNo.AppendRecord;'
          '  TSiNo.FieldName('#39'valor'#39').AsBoolean := False;'
          '  TSiNo.FieldName('#39'descripcion'#39').AsString := '#39'NO'#39';'
          '  TSiNo.PostRecord;'
          ''
          'end;')
      end>
    OnAfterNuevo = <
      item
        Source.Strings = (
          'begin'
          '    ImagenLegajo.BorrarImagen();'
          '    traerModelosVig();    '
          '    InitAlta();'
          '    srnDBButtonEdit1.setEnable(true);'
          '    snDBLookup1.setEnable(true);'
          '    snDBLookup1.setFoco();'
          '    compo.exec('#39'SNScrollBox1'#39','#39'setPosIni'#39');'
          'end.')
      end>
    OnAfterCancelar = <
      item
        Source.Strings = (
          'begin'
          '      ImagenLegajo.BorrarImagen();'
          'end.')
      end>
    OnAfterGrabar = <
      item
        Source.Strings = (
          'begin'
          '    compo.exec('#39'SNScrollBox1'#39','#39'setPosIni'#39');'
          'end.')
      end>
    OnClickToolButton = <
      item
        ButtonName = 'BotonPonerComoVig'
        Source.Strings = (
          'begin'
          '    if (DriverABM.isBrowse()) '
          '       then begin'
          ''
          
            '               if (mensaje.question('#39'Desea poner la evaluaci'#243'n c' +
            'omo vigente?'#39'))'
          '                  then begin    '
          '                          setPonerComoVigente();'
          '                          operacion.InicioOperacion();'
          
            '                          operacion.setOper('#39'TraerEvaluacionComp' +
            'etencias'#39');'
          
            '                          operacion.AddAtribute('#39'oid'#39', TEvaluaci' +
            'onCAB.FieldName('#39'oid_eval_cab'#39').AsString);'
          '                          operacion.execute();'
          '                          end;'
          '               end;'
          'end.')
      end>
    OnClickButtonColumn = <
      item
        ColumnName = 'cxGridDBTableView5cod_legajo'
        Source.Strings = (
          'begin'
          '  HelpLegajos1.Mostrar();'
          'end.')
      end
      item
        ColumnName = 'cxGridDBColumn6'
        Source.Strings = (
          'begin'
          '   HelpLegajos2.Mostrar();'
          'end.')
      end>
    OnClickButtonEdit = <
      item
        ButtonEdit = 'srnDBButtonEmpresa'
        Source.Strings = (
          'begin'
          '  MostrarHelpValoresClasifEmpresa();'
          'end.')
      end
      item
        ButtonEdit = 'srnDBButtonSector'
        Source.Strings = (
          'begin'
          '  MostrarHelpValoresClasifSector();'
          'end.')
      end
      item
        ButtonEdit = 'srnDBButtonPuesto'
        Source.Strings = (
          'begin'
          '  MostrarHelpValoresClasifPuesto();'
          'end.')
      end>
  end
  inherited ImprimirObjetoSeleccionado: TdxComponentPrinter
    Top = 160
    inherited ImprimirObjetoSeleccionadodxComponentPrinterLink: TdxGridReportLink
      BuiltInReportLink = True
    end
  end
  inherited TDataSetOidObjSave: TsnTable
    Left = 448
    Top = 83
  end
  object TLeyendasReporte: TsnTable
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
    Left = 480
    Top = 115
    object TLeyendasReportetitulo_1: TStringField
      FieldName = 'titulo_1'
      Size = 100
    end
    object TLeyendasReportetitulo_2: TStringField
      FieldName = 'titulo_2'
      Size = 100
    end
    object TLeyendasReportetitulo_3: TStringField
      FieldName = 'titulo_3'
      Size = 100
    end
    object TLeyendasReporteoid_clasif_empresa: TIntegerField
      FieldName = 'oid_clasif_empresa'
    end
    object TLeyendasReporteoid_clasif_sector: TIntegerField
      FieldName = 'oid_clasif_sector'
    end
    object TLeyendasReporteoid_clasif_puesto: TIntegerField
      FieldName = 'oid_clasif_puesto'
    end
    object TLeyendasReportenro_clasif_empresa: TIntegerField
      FieldName = 'nro_clasif_empresa'
    end
    object TLeyendasReportenro_clasif_sector: TIntegerField
      FieldName = 'nro_clasif_sector'
    end
    object TLeyendasReportenro_clasif_puesto: TIntegerField
      FieldName = 'nro_clasif_puesto'
    end
    object TLeyendasReporteoid_cond_modelo: TIntegerField
      FieldName = 'oid_cond_modelo'
    end
    object TLeyendasReporteoid_clasif_estado: TIntegerField
      FieldName = 'oid_clasif_estado'
    end
    object TLeyendasReportenro_clasif_estado: TIntegerField
      FieldName = 'nro_clasif_estado'
    end
  end
  object DSTLeyendasReporte: TDataSource
    DataSet = TLeyendasReporte
    Left = 512
    Top = 115
  end
  object TEvaluacionCAB: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'oid_eval_cab'
        DataType = ftInteger
      end
      item
        Name = 'version_eval'
        DataType = ftInteger
      end
      item
        Name = 'oid_mod_eval_cab'
        DataType = ftInteger
      end
      item
        Name = 'oid_legajo'
        DataType = ftInteger
      end
      item
        Name = 'cod_legajo'
        DataType = ftString
        Size = 20
      end
      item
        Name = 'ape_nom_legajo'
        DataType = ftString
        Size = 100
      end
      item
        Name = 'fec_eval'
        DataType = ftDate
      end
      item
        Name = 'fec_puntuacion'
        DataType = ftDate
      end
      item
        Name = 'oid_usu_carga'
        DataType = ftInteger
      end
      item
        Name = 'fec_alta_carga'
        DataType = ftDate
      end
      item
        Name = 'oid_usu_modif'
        DataType = ftInteger
      end
      item
        Name = 'fec_ult_modif'
        DataType = ftDate
      end
      item
        Name = 'puntaje'
        DataType = ftCurrency
      end
      item
        Name = 'firmado'
        DataType = ftBoolean
      end
      item
        Name = 'fec_firmado'
        DataType = ftDate
      end
      item
        Name = 'comen_del_evaluado'
        DataType = ftMemo
        Size = 4000
      end
      item
        Name = 'activo'
        DataType = ftBoolean
      end
      item
        Name = 'oid_empresa'
        DataType = ftInteger
      end
      item
        Name = 'cod_empresa'
        DataType = ftString
        Size = 50
      end
      item
        Name = 'desc_empresa'
        DataType = ftString
        Size = 100
      end
      item
        Name = 'oid_sector'
        DataType = ftInteger
      end
      item
        Name = 'cod_sector'
        DataType = ftString
        Size = 20
      end
      item
        Name = 'desc_sector'
        DataType = ftString
        Size = 100
      end
      item
        Name = 'oid_puesto'
        DataType = ftInteger
      end
      item
        Name = 'cod_puesto'
        DataType = ftString
        Size = 20
      end
      item
        Name = 'desc_puesto'
        DataType = ftString
        Size = 100
      end
      item
        Name = 'oid_cond_mod_eval'
        DataType = ftInteger
      end
      item
        Name = 'oid_estado'
        DataType = ftInteger
      end
      item
        Name = 'cod_estado'
        DataType = ftString
        Size = 50
      end
      item
        Name = 'desc_estado'
        DataType = ftString
        Size = 100
      end
      item
        Name = 'vigente'
        DataType = ftString
        Size = 2
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
    Left = 328
    Top = 435
    object TEvaluacionCABoid_eval_cab: TIntegerField
      FieldName = 'oid_eval_cab'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TEvaluacionCABversion_eval: TIntegerField
      FieldName = 'version_eval'
    end
    object TEvaluacionCABoid_mod_eval_cab: TIntegerField
      FieldName = 'oid_mod_eval_cab'
    end
    object TEvaluacionCABoid_legajo: TIntegerField
      FieldName = 'oid_legajo'
    end
    object TEvaluacionCABcod_legajo: TStringField
      FieldName = 'cod_legajo'
    end
    object TEvaluacionCABape_nom_legajo: TStringField
      FieldName = 'ape_nom_legajo'
      Size = 100
    end
    object TEvaluacionCABfec_eval: TDateField
      FieldName = 'fec_eval'
    end
    object TEvaluacionCABfec_puntuacion: TDateField
      FieldName = 'fec_puntuacion'
    end
    object TEvaluacionCABoid_usu_carga: TIntegerField
      FieldName = 'oid_usu_carga'
    end
    object TEvaluacionCABfec_alta_carga: TDateField
      FieldName = 'fec_alta_carga'
    end
    object TEvaluacionCABoid_usu_modif: TIntegerField
      FieldName = 'oid_usu_modif'
    end
    object TEvaluacionCABfec_ult_modif: TDateField
      FieldName = 'fec_ult_modif'
    end
    object TEvaluacionCABpuntaje: TCurrencyField
      FieldName = 'puntaje'
      DisplayFormat = '###,###,###.##'
    end
    object TEvaluacionCABfirmado: TBooleanField
      FieldName = 'firmado'
    end
    object TEvaluacionCABfec_firmado: TDateField
      FieldName = 'fec_firmado'
    end
    object TEvaluacionCABcomen_del_evaluado: TMemoField
      FieldName = 'comen_del_evaluado'
      BlobType = ftMemo
      Size = 4000
    end
    object TEvaluacionCABactivo: TBooleanField
      FieldName = 'activo'
    end
    object TEvaluacionCABoid_empresa: TIntegerField
      FieldName = 'oid_empresa'
    end
    object TEvaluacionCABcod_empresa: TStringField
      FieldName = 'cod_empresa'
      Size = 50
    end
    object TEvaluacionCABdesc_empresa: TStringField
      FieldName = 'desc_empresa'
      Size = 100
    end
    object TEvaluacionCABoid_sector: TIntegerField
      FieldName = 'oid_sector'
    end
    object TEvaluacionCABcod_sector: TStringField
      FieldName = 'cod_sector'
    end
    object TEvaluacionCABdesc_sector: TStringField
      FieldName = 'desc_sector'
      Size = 100
    end
    object TEvaluacionCABoid_puesto: TIntegerField
      FieldName = 'oid_puesto'
    end
    object TEvaluacionCABcod_puesto: TStringField
      FieldName = 'cod_puesto'
    end
    object TEvaluacionCABdesc_puesto: TStringField
      FieldName = 'desc_puesto'
      Size = 100
    end
    object TEvaluacionCABoid_cond_mod_eval: TIntegerField
      FieldName = 'oid_cond_mod_eval'
    end
    object TEvaluacionCABoid_estado: TIntegerField
      FieldName = 'oid_estado'
    end
    object TEvaluacionCABcod_estado: TStringField
      FieldName = 'cod_estado'
      Size = 50
    end
    object TEvaluacionCABdesc_estado: TStringField
      FieldName = 'desc_estado'
      Size = 100
    end
    object TEvaluacionCABvigente: TStringField
      FieldName = 'vigente'
      Size = 2
    end
    object TEvaluacionCABoid_val_pue_fut: TIntegerField
      FieldName = 'oid_val_pue_fut'
    end
    object TEvaluacionCABcod_val_pue_fut: TStringField
      FieldName = 'cod_val_pue_fut'
      Size = 50
    end
    object TEvaluacionCABdesc_val_pue_fut: TStringField
      FieldName = 'desc_val_pue_fut'
      Size = 100
    end
  end
  object dsEVALUCIONCAB: TDataSource
    DataSet = TEvaluacionCAB
    Left = 360
    Top = 435
  end
  object TModelosVigentes: TsnTable
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
    Left = 27
    Top = 179
    object TModelosVigentesoid_mod_eval_cab: TIntegerField
      FieldName = 'oid_mod_eval_cab'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TModelosVigentestitulo: TStringField
      FieldName = 'titulo'
      Size = 100
    end
    object TModelosVigentesdesc_abraviada: TStringField
      FieldName = 'desc_abraviada'
      Size = 50
    end
    object TModelosVigentesfec_desde: TDateField
      FieldName = 'fec_desde'
    end
    object TModelosVigentesfec_hasta: TDateField
      FieldName = 'fec_hasta'
    end
  end
  object DSModelosVigentes: TDataSource
    DataSet = TModelosVigentes
    Left = 57
    Top = 181
  end
  object ValidadorLegajo: TValidador
    Operacion = Operacion
    NickNameObjLog = 'su.Legajo'
    MensajeException = 'C'#243'digo de Legajo Inexistente'
    CampoOID = TEvaluacionCABoid_legajo
    CampoDescripcion = TEvaluacionCABape_nom_legajo
    NroQuery = 0
    Cache = True
    Left = 622
    Top = 185
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
        AsignarACampo = TEvaluacionCABcod_legajo
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
    Left = 586
    Top = 185
  end
  object HelpValoresClasifEmpresa: THelpValoresClasificador
    AsignarCampoCodigo = TEvaluacionCABcod_empresa
    NroClasificador = 0
    Left = 144
    Top = 465
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
    Left = 203
    Top = 387
    object TValorClaifEntidadoid_valor_clasif_ent: TIntegerField
      FieldName = 'oid_valor_clasif_ent'
    end
    object TValorClaifEntidadcodigo: TStringField
      FieldName = 'codigo'
      Size = 30
    end
    object TValorClaifEntidaddescripcion: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
    object TValorClaifEntidadoid_clasif_entidad: TIntegerField
      FieldName = 'oid_clasif_entidad'
    end
  end
  object HelpValoresClasifSector: THelpValoresClasificador
    AsignarCampoCodigo = TEvaluacionCABcod_sector
    NroClasificador = 0
    Left = 144
    Top = 503
  end
  object HelpValoresClasifPuesto: THelpValoresClasificador
    AsignarCampoCodigo = TEvaluacionCABcod_puesto
    NroClasificador = 0
    Left = 144
    Top = 545
  end
  object TDatosLegajo: TsnTable
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
    Left = 200
    Top = 453
    object TDatosLegajooid_clasif_empresa: TIntegerField
      FieldName = 'oid_clasif_empresa'
    end
    object TDatosLegajooid_valor_empresa: TIntegerField
      FieldName = 'oid_valor_empresa'
    end
    object TDatosLegajocod_valor_empresa: TStringField
      FieldName = 'cod_valor_empresa'
      Size = 50
    end
    object TDatosLegajodesc_valor_empresa: TStringField
      FieldName = 'desc_valor_empresa'
      Size = 100
    end
    object TDatosLegajooid_clasif_sector: TIntegerField
      FieldName = 'oid_clasif_sector'
    end
    object TDatosLegajooid_valor_sector: TIntegerField
      FieldName = 'oid_valor_sector'
    end
    object TDatosLegajocod_valor_sector: TStringField
      FieldName = 'cod_valor_sector'
      Size = 50
    end
    object TDatosLegajodesc_valor_sector: TStringField
      FieldName = 'desc_valor_sector'
      Size = 100
    end
    object TDatosLegajooid_clasif_puesto: TIntegerField
      FieldName = 'oid_clasif_puesto'
    end
    object TDatosLegajooid_valor_puesto: TIntegerField
      FieldName = 'oid_valor_puesto'
    end
    object TDatosLegajocod_valor_puesto: TStringField
      FieldName = 'cod_valor_puesto'
      Size = 50
    end
    object TDatosLegajodesc_valor_puesto: TStringField
      FieldName = 'desc_valor_puesto'
      Size = 100
    end
    object TDatosLegajooid_legajo: TIntegerField
      FieldName = 'oid_legajo'
    end
    object TDatosLegajocod_legajo: TStringField
      FieldName = 'cod_legajo'
      Size = 50
    end
    object TDatosLegajoape_y_nom: TStringField
      FieldName = 'ape_y_nom'
      Size = 100
    end
    object TDatosLegajooid_cond_modelo: TIntegerField
      FieldName = 'oid_cond_modelo'
    end
    object TDatosLegajooid_clasif_estado: TIntegerField
      FieldName = 'oid_clasif_estado'
    end
    object TDatosLegajooid_valor_estado: TIntegerField
      FieldName = 'oid_valor_estado'
    end
    object TDatosLegajocod_valor_estado: TStringField
      FieldName = 'cod_valor_estado'
      Size = 50
    end
    object TDatosLegajodesc_valor_estado: TStringField
      FieldName = 'desc_valor_estado'
      Size = 100
    end
  end
  object Varios: TsnVarios
    Operacion = Operacion
    Left = 551
    Top = 361
  end
  object TCompetenciasEval: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'oid_compe_eval'
        DataType = ftInteger
      end
      item
        Name = 'orden'
        DataType = ftInteger
      end
      item
        Name = 'oid_eval_cab'
        DataType = ftInteger
      end
      item
        Name = 'oid_competencia'
        DataType = ftInteger
      end
      item
        Name = 'desc_competencia'
        DataType = ftString
        Size = 255
      end
      item
        Name = 'grado'
        DataType = ftInteger
      end>
    IndexDefs = <
      item
        Name = 'TCompetenciasEvalIndex1'
        Fields = 'oid_eval_cab'
      end>
    RecalcOnFetch = False
    SortOptions = []
    PersistentBackup = False
    ProgressFlags = [mtpcLoad, mtpcSave, mtpcCopy]
    VersioningMode = mtvmAllSinceCheckPoint
    FilterOptions = []
    MasterSource = dsEVALUCIONCAB
    Version = '4.08b'
    LanguageID = 0
    SortID = 0
    SubLanguageID = 1
    LocaleID = 1024
    MensajeValorDuplicadoIndice = 'Valor Duplicado'
    Left = 328
    Top = 469
    object TCompetenciasEvaloid_compe_eval: TIntegerField
      FieldName = 'oid_compe_eval'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TCompetenciasEvalorden: TIntegerField
      FieldName = 'orden'
    end
    object TCompetenciasEvaloid_eval_cab: TIntegerField
      FieldName = 'oid_eval_cab'
    end
    object TCompetenciasEvaloid_competencia: TIntegerField
      FieldName = 'oid_competencia'
    end
    object TCompetenciasEvaldesc_competencia: TStringField
      FieldName = 'desc_competencia'
      Size = 255
    end
    object TCompetenciasEvalnro_grado: TIntegerField
      FieldName = 'nro_grado'
      DisplayFormat = '#####'
    end
    object TCompetenciasEvalporc_cump: TCurrencyField
      FieldName = 'porc_cump'
      DisplayFormat = '###,###.##'
    end
    object TCompetenciasEvaldescripcion: TMemoField
      FieldName = 'descripcion'
      BlobType = ftMemo
    end
  end
  object DSTCompetenciasEval: TDataSource
    DataSet = TCompetenciasEval
    Left = 361
    Top = 471
  end
  object cxStyleRepository1: TcxStyleRepository
    PixelsPerInch = 96
    object cxStyle1: TcxStyle
      AssignedValues = [svFont]
      Font.Charset = ANSI_CHARSET
      Font.Color = clWindowText
      Font.Height = -13
      Font.Name = 'Verdana'
      Font.Style = []
    end
    object cxStyle2: TcxStyle
      AssignedValues = [svFont]
      Font.Charset = ANSI_CHARSET
      Font.Color = clWindowText
      Font.Height = -13
      Font.Name = 'Verdana'
      Font.Style = []
    end
    object cxStyle3: TcxStyle
      AssignedValues = [svFont]
      Font.Charset = ANSI_CHARSET
      Font.Color = clWindowText
      Font.Height = -13
      Font.Name = 'Verdana'
      Font.Style = []
    end
    object cxStyle4: TcxStyle
      AssignedValues = [svFont]
      Font.Charset = ANSI_CHARSET
      Font.Color = clWindowText
      Font.Height = -13
      Font.Name = 'Verdana'
      Font.Style = []
    end
  end
  object TEvalCarga: TsnTable
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
    Left = 40
    Top = 443
    object TEvalCargaoid_eval_leg_cab: TIntegerField
      FieldName = 'oid_eval_leg_cab'
    end
    object TEvalCargaoid_legajo: TIntegerField
      FieldName = 'oid_legajo'
    end
    object TEvalCargafecha: TDateField
      FieldName = 'fecha'
    end
  end
  object TOtrasVersiones: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'oid_eval_cab'
        DataType = ftInteger
      end
      item
        Name = 'oid_otra_eval'
        DataType = ftInteger
      end
      item
        Name = 'version'
        DataType = ftInteger
      end
      item
        Name = 'fec_carga'
        DataType = ftDate
      end
      item
        Name = 'activo'
        DataType = ftBoolean
      end>
    IndexFieldNames = 'oid_eval_cab'
    IndexDefs = <
      item
        Name = 'TOtrasVersionesIndex1'
        Fields = 'oid_eval_cab'
      end>
    RecalcOnFetch = False
    SortOptions = []
    PersistentBackup = False
    ProgressFlags = [mtpcLoad, mtpcSave, mtpcCopy]
    VersioningMode = mtvmAllSinceCheckPoint
    FilterOptions = []
    MasterFields = 'oid_eval_cab'
    MasterSource = dsEVALUCIONCAB
    Version = '4.08b'
    LanguageID = 0
    SortID = 0
    SubLanguageID = 1
    LocaleID = 1024
    MensajeValorDuplicadoIndice = 'Valor Duplicado'
    Left = 520
    Top = 57
    object TOtrasVersionesoid_eval_cab: TIntegerField
      FieldName = 'oid_eval_cab'
    end
    object TOtrasVersionesoid_otra_eval: TIntegerField
      FieldName = 'oid_otra_eval'
    end
    object TOtrasVersionesversion: TIntegerField
      FieldName = 'version'
    end
    object TOtrasVersionesfec_carga: TDateField
      FieldName = 'fec_carga'
    end
    object TOtrasVersionespuntaje: TCurrencyField
      FieldName = 'puntaje'
      DisplayFormat = '###.##'
    end
    object TOtrasVersionesactivo: TStringField
      DisplayWidth = 10
      FieldName = 'activo'
      Size = 10
    end
    object TOtrasVersionesvigente: TBooleanField
      FieldName = 'vigente'
    end
  end
  object DSOtrasVersiones: TDataSource
    DataSet = TOtrasVersiones
    Left = 552
    Top = 57
  end
  object TAspectosDestacados: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'OID_EVAL_ASP'
        DataType = ftInteger
      end
      item
        Name = 'OID_EVAL_CAB'
        DataType = ftInteger
      end
      item
        Name = 'TIPO_ASPECTO'
        DataType = ftString
        Size = 10
      end
      item
        Name = 'ASPECTO'
        DataType = ftString
        Size = 4000
      end
      item
        Name = 'ACTIVO'
        DataType = ftBoolean
      end>
    IndexFieldNames = 'OID_EVAL_CAB;ORDEN'
    IndexDefs = <
      item
        Name = 'TAspectosDestacadosIndex1'
        Fields = 'OID_EVAL_CAB;ORDEN'
      end>
    RecalcOnFetch = False
    SortOptions = []
    PersistentBackup = False
    ProgressFlags = [mtpcLoad, mtpcSave, mtpcCopy]
    VersioningMode = mtvmAllSinceCheckPoint
    FilterOptions = []
    MasterFields = 'oid_eval_cab'
    MasterSource = dsEVALUCIONCAB
    Version = '4.08b'
    LanguageID = 0
    SortID = 0
    SubLanguageID = 1
    LocaleID = 1024
    MensajeValorDuplicadoIndice = 'Valor Duplicado'
    Left = 280
    Top = 515
    object TAspectosDestacadosOID_EVAL_ASP: TIntegerField
      FieldName = 'OID_EVAL_ASP'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TAspectosDestacadosOID_EVAL_CAB: TIntegerField
      FieldName = 'OID_EVAL_CAB'
    end
    object TAspectosDestacadosTIPO_ASPECTO: TStringField
      FieldName = 'TIPO_ASPECTO'
      Size = 10
    end
    object TAspectosDestacadosACTIVO: TBooleanField
      FieldName = 'ACTIVO'
    end
    object TAspectosDestacadosORDEN: TIntegerField
      AutoGenerateValue = arAutoInc
      FieldName = 'ORDEN'
    end
    object TAspectosDestacadosASPECTO: TMemoField
      FieldName = 'ASPECTO'
      BlobType = ftMemo
    end
  end
  object DSAspectosDestacados: TDataSource
    DataSet = TAspectosDestacados
    Left = 312
    Top = 515
  end
  object TAspectosAMejorar: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'OID_EVAL_ASP'
        DataType = ftInteger
      end
      item
        Name = 'OID_EVAL_CAB'
        DataType = ftInteger
      end
      item
        Name = 'TIPO_ASPECTO'
        DataType = ftString
        Size = 10
      end
      item
        Name = 'ACTIVO'
        DataType = ftBoolean
      end
      item
        Name = 'ASPECTO'
        DataType = ftMemo
      end
      item
        Name = 'ORDEN'
        DataType = ftInteger
      end>
    IndexFieldNames = 'OID_EVAL_CAB;ORDEN'
    IndexDefs = <
      item
        Name = 'TAspectosAMejorarIndex1'
        Fields = 'OID_EVAL_CAB;ORDEN'
      end>
    RecalcOnFetch = False
    SortOptions = []
    PersistentBackup = False
    ProgressFlags = [mtpcLoad, mtpcSave, mtpcCopy]
    VersioningMode = mtvmAllSinceCheckPoint
    FilterOptions = []
    MasterFields = 'oid_eval_cab'
    MasterSource = dsEVALUCIONCAB
    Version = '4.08b'
    LanguageID = 0
    SortID = 0
    SubLanguageID = 1
    LocaleID = 1024
    MensajeValorDuplicadoIndice = 'Valor Duplicado'
    Left = 368
    Top = 515
    object TAspectosAMejorarOID_EVAL_ASP: TIntegerField
      FieldName = 'OID_EVAL_ASP'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TAspectosAMejorarOID_EVAL_CAB: TIntegerField
      FieldName = 'OID_EVAL_CAB'
    end
    object TAspectosAMejorarTIPO_ASPECTO: TStringField
      FieldName = 'TIPO_ASPECTO'
      Size = 10
    end
    object TAspectosAMejorarACTIVO: TBooleanField
      FieldName = 'ACTIVO'
    end
    object TAspectosAMejorarASPECTO: TMemoField
      FieldName = 'ASPECTO'
      BlobType = ftMemo
    end
    object TAspectosAMejorarORDEN: TIntegerField
      AutoGenerateValue = arAutoInc
      FieldName = 'ORDEN'
    end
  end
  object DSAspectosAMejorar: TDataSource
    DataSet = TAspectosAMejorar
    Left = 400
    Top = 515
  end
  object TObsGenRRHH: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'oid_obs_gen'
        DataType = ftInteger
      end
      item
        Name = 'oid_eval_cab'
        DataType = ftInteger
      end
      item
        Name = 'observacion'
        DataType = ftString
        Size = 4000
      end
      item
        Name = 'activo'
        DataType = ftBoolean
      end
      item
        Name = 'orden'
        DataType = ftInteger
      end>
    IndexFieldNames = 'oid_eval_cab;orden'
    IndexDefs = <
      item
        Name = 'TObsGenRRHHIndex1'
        Fields = 'oid_eval_cab;orden'
      end>
    RecalcOnFetch = False
    SortOptions = []
    PersistentBackup = False
    ProgressFlags = [mtpcLoad, mtpcSave, mtpcCopy]
    VersioningMode = mtvmAllSinceCheckPoint
    FilterOptions = []
    MasterFields = 'oid_eval_cab'
    MasterSource = dsEVALUCIONCAB
    Version = '4.08b'
    LanguageID = 0
    SortID = 0
    SubLanguageID = 1
    LocaleID = 1024
    MensajeValorDuplicadoIndice = 'Valor Duplicado'
    Left = 456
    Top = 515
    object TObsGenRRHHoid_obs_gen: TIntegerField
      FieldName = 'oid_obs_gen'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TObsGenRRHHoid_eval_cab: TIntegerField
      FieldName = 'oid_eval_cab'
    end
    object TObsGenRRHHobservacion: TStringField
      FieldName = 'observacion'
      Size = 4000
    end
    object TObsGenRRHHactivo: TBooleanField
      FieldName = 'activo'
    end
    object TObsGenRRHHorden: TIntegerField
      AutoGenerateValue = arAutoInc
      FieldName = 'orden'
    end
  end
  object dsTObsGenRRHH: TDataSource
    DataSet = TObsGenRRHH
    Left = 488
    Top = 515
  end
  object TObsCodif: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'orden'
        DataType = ftInteger
      end
      item
        Name = 'oid_eval_cab'
        DataType = ftInteger
      end
      item
        Name = 'observacion'
        DataType = ftString
        Size = 4000
      end>
    IndexFieldNames = 'oid_eval_cab'
    IndexDefs = <
      item
        Name = 'TObsCodifIndex1'
        Fields = 'oid_eval_cab'
      end>
    RecalcOnFetch = False
    SortOptions = []
    PersistentBackup = False
    ProgressFlags = [mtpcLoad, mtpcSave, mtpcCopy]
    VersioningMode = mtvmAllSinceCheckPoint
    FilterOptions = []
    MasterFields = 'oid_eval_cab'
    MasterSource = dsEVALUCIONCAB
    Version = '4.08b'
    LanguageID = 0
    SortID = 0
    SubLanguageID = 1
    LocaleID = 1024
    MensajeValorDuplicadoIndice = 'Valor Duplicado'
    Left = 560
    Top = 515
    object TObsCodiforden: TIntegerField
      FieldName = 'orden'
    end
    object TObsCodifoid_eval_cab: TIntegerField
      FieldName = 'oid_eval_cab'
    end
    object TObsCodifobservacion: TStringField
      FieldName = 'observacion'
      Size = 4000
    end
  end
  object DSObsCodif: TDataSource
    DataSet = TObsCodif
    Left = 592
    Top = 515
  end
  object TEvaluadores: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'oid_eval_evaluador'
        DataType = ftInteger
      end
      item
        Name = 'oid_eval_cab'
        DataType = ftInteger
      end
      item
        Name = 'oid_legajo'
        DataType = ftInteger
      end
      item
        Name = 'cod_legajo'
        DataType = ftString
        Size = 50
      end
      item
        Name = 'desc_legajo'
        DataType = ftString
        Size = 100
      end
      item
        Name = 'firmado'
        DataType = ftBoolean
      end
      item
        Name = 'fec_firmado'
        DataType = ftDate
      end
      item
        Name = 'activo'
        DataType = ftBoolean
      end>
    IndexFieldNames = 'oid_eval_cab'
    IndexDefs = <
      item
        Name = 'TEvaluadoresIndex1'
        Fields = 'oid_eval_cab'
      end>
    RecalcOnFetch = False
    SortOptions = []
    PersistentBackup = False
    ProgressFlags = [mtpcLoad, mtpcSave, mtpcCopy]
    VersioningMode = mtvmAllSinceCheckPoint
    FilterOptions = []
    MasterFields = 'oid_eval_cab'
    MasterSource = dsEVALUCIONCAB
    Version = '4.08b'
    LanguageID = 0
    SortID = 0
    SubLanguageID = 1
    LocaleID = 1024
    MensajeValorDuplicadoIndice = 'Valor Duplicado'
    Left = 656
    Top = 512
    object TEvaluadoresoid_eval_evaluador: TIntegerField
      FieldName = 'oid_eval_evaluador'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TEvaluadoresoid_eval_cab: TIntegerField
      FieldName = 'oid_eval_cab'
    end
    object TEvaluadoresoid_legajo: TIntegerField
      FieldName = 'oid_legajo'
    end
    object TEvaluadorescod_legajo: TStringField
      FieldName = 'cod_legajo'
      Size = 50
    end
    object TEvaluadoresdesc_legajo: TStringField
      FieldName = 'desc_legajo'
      Size = 100
    end
    object TEvaluadoresfirmado: TBooleanField
      FieldName = 'firmado'
    end
    object TEvaluadoresfec_firmado: TDateField
      FieldName = 'fec_firmado'
    end
    object TEvaluadoresactivo: TBooleanField
      FieldName = 'activo'
    end
    object TEvaluadorespuesto: TStringField
      FieldName = 'puesto'
      Size = 100
    end
  end
  object DSEvaluadores: TDataSource
    DataSet = TEvaluadores
    Left = 688
    Top = 512
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
        AsignarACampo = TEvaluadorescod_legajo
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
    Left = 98
    Top = 817
  end
  object ValidadorLegajos1: TValidador
    Operacion = Operacion
    NickNameObjLog = 'su.Legajo'
    MensajeException = 'C'#243'digo de Legajo Inexistente'
    CampoOID = TEvaluadoresoid_legajo
    CampoDescripcion = TEvaluadoresdesc_legajo
    NroQuery = 0
    Cache = True
    Left = 134
    Top = 817
  end
  object TSiNo: TsnTable
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
    Left = 456
    Top = 584
    object TSiNovalor: TBooleanField
      FieldName = 'valor'
    end
    object TSiNodescripcion: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
  end
  object DSSiNo: TDataSource
    DataSet = TSiNo
    Left = 488
    Top = 584
  end
  object TFirmas: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'oid_firma_eval'
        DataType = ftInteger
      end
      item
        Name = 'oid_eval_cab'
        DataType = ftInteger
      end
      item
        Name = 'nro_firma'
        DataType = ftInteger
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
        Name = 'firmo'
        DataType = ftBoolean
      end
      item
        Name = 'fec_firma'
        DataType = ftDate
      end
      item
        Name = 'activo'
        DataType = ftBoolean
      end>
    IndexFieldNames = 'oid_eval_cab'
    IndexDefs = <
      item
        Name = 'TFirmasIndex1'
        Fields = 'oid_eval_cab'
      end>
    RecalcOnFetch = False
    SortOptions = []
    PersistentBackup = False
    ProgressFlags = [mtpcLoad, mtpcSave, mtpcCopy]
    VersioningMode = mtvmAllSinceCheckPoint
    FilterOptions = []
    MasterFields = 'oid_eval_cab'
    MasterSource = dsEVALUCIONCAB
    Version = '4.08b'
    LanguageID = 0
    SortID = 0
    SubLanguageID = 1
    LocaleID = 1024
    MensajeValorDuplicadoIndice = 'Valor Duplicado'
    Left = 736
    Top = 508
    object TFirmasoid_firma_eval: TIntegerField
      FieldName = 'oid_firma_eval'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TFirmasoid_eval_cab: TIntegerField
      FieldName = 'oid_eval_cab'
    end
    object TFirmasnro_firma: TIntegerField
      FieldName = 'nro_firma'
    end
    object TFirmasoid_legajo_firma: TIntegerField
      FieldName = 'oid_legajo_firma'
    end
    object TFirmascod_legajo_firma: TStringField
      FieldName = 'cod_legajo_firma'
      Size = 50
    end
    object TFirmasdesc_legajo_firma: TStringField
      FieldName = 'desc_legajo_firma'
      Size = 100
    end
    object TFirmasfirmo: TBooleanField
      FieldName = 'firmo'
    end
    object TFirmasfec_firma: TDateField
      FieldName = 'fec_firma'
    end
    object TFirmasactivo: TBooleanField
      FieldName = 'activo'
    end
    object TFirmaspuesto: TStringField
      FieldName = 'puesto'
      Size = 100
    end
  end
  object DSFirmas: TDataSource
    DataSet = TFirmas
    Left = 768
    Top = 512
  end
  object HelpLegajos2: TsnHelp
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
        AsignarACampo = TFirmascod_legajo_firma
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
    Left = 98
    Top = 848
  end
  object ValidadorLegajos2: TValidador
    Operacion = Operacion
    NickNameObjLog = 'su.Legajo'
    MensajeException = 'C'#243'digo de Legajo Inexistente'
    CampoOID = TFirmasoid_legajo_firma
    CampoDescripcion = TFirmasdesc_legajo_firma
    NroQuery = 0
    Cache = True
    Left = 134
    Top = 848
  end
  object TFirmasTemp: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'oid_firma_eval'
        DataType = ftInteger
      end
      item
        Name = 'oid_eval_cab'
        DataType = ftInteger
      end
      item
        Name = 'nro_firma'
        DataType = ftInteger
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
        Name = 'firmo'
        DataType = ftBoolean
      end
      item
        Name = 'fec_firma'
        DataType = ftDate
      end
      item
        Name = 'activo'
        DataType = ftBoolean
      end>
    IndexFieldNames = 'oid_eval_cab'
    IndexDefs = <
      item
        Name = 'TFirmasIndex1'
        Fields = 'oid_eval_cab'
      end>
    RecalcOnFetch = False
    SortOptions = []
    PersistentBackup = False
    ProgressFlags = [mtpcLoad, mtpcSave, mtpcCopy]
    VersioningMode = mtvmAllSinceCheckPoint
    FilterOptions = []
    MasterFields = 'oid_eval_cab'
    MasterSource = dsEVALUCIONCAB
    Version = '4.08b'
    LanguageID = 0
    SortID = 0
    SubLanguageID = 1
    LocaleID = 1024
    MensajeValorDuplicadoIndice = 'Valor Duplicado'
    Left = 736
    Top = 552
    object IntegerField1: TIntegerField
      FieldName = 'oid_firma_eval'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object IntegerField2: TIntegerField
      FieldName = 'oid_eval_cab'
    end
    object IntegerField3: TIntegerField
      FieldName = 'nro_firma'
    end
    object IntegerField4: TIntegerField
      FieldName = 'oid_legajo_firma'
    end
    object StringField1: TStringField
      FieldName = 'cod_legajo_firma'
      Size = 50
    end
    object StringField2: TStringField
      FieldName = 'desc_legajo_firma'
      Size = 100
    end
    object BooleanField1: TBooleanField
      FieldName = 'firmo'
    end
    object DateField1: TDateField
      FieldName = 'fec_firma'
    end
    object BooleanField2: TBooleanField
      FieldName = 'activo'
    end
    object StringField3: TStringField
      FieldName = 'puesto'
      Size = 100
    end
  end
  object formConsVerCompetencia: TFormulario
    AutoLiberar = True
    Nombre = 'TFVerCompetencia'
    CreateAlwaysANewForm = True
    Left = 54
    Top = 220
  end
  object ImpresorEvaluacion: TFormulario
    Nombre = 'TFImpresorEvaluacion'
    TipoForm = tipoImpresorCompro
    CreateAlwaysANewForm = False
    Left = 288
    Top = 280
  end
end
