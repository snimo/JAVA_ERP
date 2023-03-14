inherited FConsAsientoTarjDebCre: TFConsAsientoTarjDebCre
  Left = 86
  Top = 102
  Width = 815
  Height = 628
  Caption = 'Consulta de Asientos'
  PixelsPerInch = 96
  TextHeight = 13
  object Panel1: TPanel [0]
    Left = 0
    Top = 0
    Width = 807
    Height = 41
    Align = alTop
    Color = clWindow
    TabOrder = 0
    object snLabel1: TsnLabel
      Left = 16
      Top = 16
      Width = 77
      Height = 13
      Caption = 'Tipo de Asiento:'
    end
    object snLabel2: TsnLabel
      Left = 272
      Top = 16
      Width = 67
      Height = 13
      Caption = 'Fecha Desde:'
    end
    object snLabel3: TsnLabel
      Left = 480
      Top = 16
      Width = 64
      Height = 13
      Caption = 'Fecha Hasta:'
    end
    object ImageSalir: TImage
      Left = 734
      Top = 4
      Width = 32
      Height = 32
      Cursor = crHandPoint
      Hint = 'Salir'
      ParentShowHint = False
      ShowHint = True
    end
    object ImageBuscar: TImage
      Left = 687
      Top = 4
      Width = 32
      Height = 32
      Cursor = crHandPoint
      Hint = 'Buscar Asientos'
      ParentShowHint = False
      ShowHint = True
    end
    object snDBLookup1: TsnDBLookup
      Left = 104
      Top = 12
      DataBinding.DataField = 'tipo_asiento'
      DataBinding.DataSource = DSInput
      Properties.ImmediatePost = True
      Properties.KeyFieldNames = 'codigo'
      Properties.ListColumns = <
        item
          FieldName = 'descripcion'
        end>
      Properties.ListOptions.ShowHeader = False
      Properties.ListSource = DSTiposAsiento
      TabOrder = 0
      Width = 145
    end
    object snDBDateEdit1: TsnDBDateEdit
      Left = 344
      Top = 12
      DataBinding.DataField = 'fec_desde'
      DataBinding.DataSource = DSInput
      Properties.ImmediatePost = True
      TabOrder = 1
      ReadOnlyAlways = False
      Width = 105
    end
    object snDBDateEdit2: TsnDBDateEdit
      Left = 552
      Top = 12
      DataBinding.DataField = 'fec_hasta'
      DataBinding.DataSource = DSInput
      Properties.ImmediatePost = True
      TabOrder = 2
      ReadOnlyAlways = False
      Width = 105
    end
  end
  object Panel2: TPanel [1]
    Left = 0
    Top = 585
    Width = 807
    Height = 9
    Align = alBottom
    Color = clWindow
    TabOrder = 1
  end
  object Panel3: TPanel [2]
    Left = 0
    Top = 41
    Width = 807
    Height = 544
    Align = alClient
    Color = clWindow
    TabOrder = 2
    object Splitter1: TSplitter
      Left = 1
      Top = 325
      Width = 805
      Height = 3
      Cursor = crVSplit
      Align = alBottom
    end
    object PageControl: TPageControlSN
      Left = 1
      Top = 1
      Width = 805
      Height = 324
      ActivePage = TabSheetCobranza
      Align = alClient
      TabOrder = 0
      object TabSheetCobranza: TTabSheet
        BorderWidth = 2
        Caption = 'Asientos de Cobranzas'
        object Splitter2: TSplitter
          Left = 0
          Top = 133
          Width = 793
          Height = 3
          Cursor = crVSplit
          Align = alTop
        end
        object Panel7: TPanel
          Left = 0
          Top = 0
          Width = 793
          Height = 133
          Align = alTop
          Color = clWindow
          TabOrder = 0
          object Panel9: TPanel
            Left = 1
            Top = 1
            Width = 791
            Height = 16
            Align = alTop
            Color = clMoneyGreen
            TabOrder = 0
            object snLabel4: TsnLabel
              Left = 4
              Top = 0
              Width = 101
              Height = 13
              Caption = 'Cabecera del Asiento'
            end
          end
          object Panel10: TPanel
            Left = 1
            Top = 17
            Width = 791
            Height = 115
            Align = alClient
            Color = clWindow
            TabOrder = 1
            object dxDBGridSN1: TdxDBGridSN
              Left = 1
              Top = 1
              Width = 789
              Height = 113
              Align = alClient
              TabOrder = 0
              CriteriosPintarCelda = <>
              object dxDBGridSN1DBTableView1: TcxGridDBTableView
                NavigatorButtons.ConfirmDelete = False
                DataController.DataSource = DSCabAsiCob
                DataController.Summary.DefaultGroupSummaryItems = <>
                DataController.Summary.FooterSummaryItems = <>
                DataController.Summary.SummaryGroups = <>
                OptionsData.CancelOnExit = False
                OptionsData.Deleting = False
                OptionsData.DeletingConfirmation = False
                OptionsData.Editing = False
                OptionsData.Inserting = False
                OptionsView.GroupByBox = False
                object dxDBGridSN1DBTableView1fec_asiento: TcxGridDBColumn
                  Caption = 'Fecha'
                  DataBinding.FieldName = 'fec_asiento'
                  HeaderAlignmentHorz = taCenter
                  Width = 89
                end
                object dxDBGridSN1DBTableView1comentario: TcxGridDBColumn
                  Caption = 'Comentario'
                  DataBinding.FieldName = 'comentario'
                  HeaderAlignmentHorz = taCenter
                  Width = 382
                end
                object dxDBGridSN1DBTableView1conta_sist_ext: TcxGridDBColumn
                  Caption = 'Conta. Sist. Ext.?'
                  DataBinding.FieldName = 'conta_sist_ext'
                  PropertiesClassName = 'TcxCheckBoxProperties'
                  HeaderAlignmentHorz = taCenter
                  Width = 114
                end
                object dxDBGridSN1DBTableView1fec_conta_sist_ext: TcxGridDBColumn
                  Caption = 'Fec. Contabilizado'
                  DataBinding.FieldName = 'fec_conta_sist_ext'
                  HeaderAlignmentHorz = taCenter
                  Width = 108
                end
                object dxDBGridSN1DBTableView1hor_conta_sist_ext: TcxGridDBColumn
                  Caption = 'Hora'
                  DataBinding.FieldName = 'hor_conta_sist_ext'
                  HeaderAlignmentHorz = taCenter
                  Width = 55
                end
              end
              object dxDBGridSN1Level1: TcxGridLevel
                GridView = dxDBGridSN1DBTableView1
              end
            end
          end
        end
        object Panel8: TPanel
          Left = 0
          Top = 136
          Width = 793
          Height = 156
          Align = alClient
          Color = clWindow
          TabOrder = 1
          object Panel11: TPanel
            Left = 1
            Top = 1
            Width = 791
            Height = 154
            Align = alClient
            Color = clWindow
            TabOrder = 0
            object Panel12: TPanel
              Left = 1
              Top = 1
              Width = 789
              Height = 16
              Align = alTop
              Color = clMoneyGreen
              TabOrder = 0
              object snLabel5: TsnLabel
                Left = 4
                Top = 0
                Width = 94
                Height = 13
                Caption = 'Cuentas del Asiento'
              end
            end
            object Panel13: TPanel
              Left = 1
              Top = 17
              Width = 789
              Height = 136
              Align = alClient
              Color = clWindow
              TabOrder = 1
              object dxDBGridSN2: TdxDBGridSN
                Left = 1
                Top = 1
                Width = 787
                Height = 134
                Align = alClient
                TabOrder = 0
                CriteriosPintarCelda = <>
                object cxGridDBTableView1: TcxGridDBTableView
                  NavigatorButtons.ConfirmDelete = False
                  DataController.DataSource = DSAsiCobDet
                  DataController.Summary.DefaultGroupSummaryItems = <>
                  DataController.Summary.FooterSummaryItems = <
                    item
                      Format = '###,###,###,##0.00'
                      Kind = skSum
                      Column = cxGridDBTableView1debe
                    end
                    item
                      Format = '###,###,###,##0.00'
                      Kind = skSum
                      Column = cxGridDBTableView1haber
                    end>
                  DataController.Summary.SummaryGroups = <>
                  OptionsData.CancelOnExit = False
                  OptionsData.Deleting = False
                  OptionsData.DeletingConfirmation = False
                  OptionsData.Editing = False
                  OptionsData.Inserting = False
                  OptionsView.Footer = True
                  OptionsView.GroupByBox = False
                  object cxGridDBTableView1cuenta: TcxGridDBColumn
                    Caption = 'Cuenta'
                    DataBinding.FieldName = 'cuenta'
                    HeaderAlignmentHorz = taCenter
                    Width = 150
                  end
                  object cxGridDBTableView1compo1: TcxGridDBColumn
                    DataBinding.FieldName = 'compo1'
                    HeaderAlignmentHorz = taCenter
                    Width = 126
                  end
                  object cxGridDBTableView1compo2: TcxGridDBColumn
                    DataBinding.FieldName = 'compo2'
                    HeaderAlignmentHorz = taCenter
                    Width = 118
                  end
                  object cxGridDBTableView1debe: TcxGridDBColumn
                    Caption = 'Debe'
                    DataBinding.FieldName = 'debe'
                    HeaderAlignmentHorz = taCenter
                    SortIndex = 0
                    SortOrder = soDescending
                    Width = 80
                  end
                  object cxGridDBTableView1haber: TcxGridDBColumn
                    Caption = 'Haber'
                    DataBinding.FieldName = 'haber'
                    HeaderAlignmentHorz = taCenter
                    Width = 80
                  end
                end
                object cxGridLevel1: TcxGridLevel
                  GridView = cxGridDBTableView1
                end
              end
            end
          end
        end
      end
      object TabSheetLiquidacion: TTabSheet
        Caption = 'Asientos de Liquidaciones'
        ImageIndex = 1
        object Splitter3: TSplitter
          Left = 0
          Top = 143
          Width = 797
          Height = 3
          Cursor = crVSplit
          Align = alTop
        end
        object Panel16: TPanel
          Left = 0
          Top = 0
          Width = 797
          Height = 143
          Align = alTop
          Color = clWindow
          TabOrder = 0
          object Panel17: TPanel
            Left = 1
            Top = 1
            Width = 795
            Height = 16
            Align = alTop
            Color = clMoneyGreen
            TabOrder = 0
            object snLabel7: TsnLabel
              Left = 4
              Top = 0
              Width = 101
              Height = 13
              Caption = 'Cabecera del Asiento'
            end
          end
          object Panel18: TPanel
            Left = 1
            Top = 17
            Width = 795
            Height = 125
            Align = alClient
            Color = clWindow
            TabOrder = 1
            object Panel23: TPanel
              Left = 1
              Top = 1
              Width = 793
              Height = 123
              Align = alClient
              Color = clWindow
              TabOrder = 0
              object dxDBGridSN4: TdxDBGridSN
                Left = 1
                Top = 1
                Width = 791
                Height = 121
                Align = alClient
                TabOrder = 0
                CriteriosPintarCelda = <>
                object cxGridDBTableView3: TcxGridDBTableView
                  NavigatorButtons.ConfirmDelete = False
                  DataController.DataSource = DSAsiLiqCab
                  DataController.Summary.DefaultGroupSummaryItems = <>
                  DataController.Summary.FooterSummaryItems = <>
                  DataController.Summary.SummaryGroups = <>
                  OptionsData.CancelOnExit = False
                  OptionsData.Deleting = False
                  OptionsData.DeletingConfirmation = False
                  OptionsData.Editing = False
                  OptionsData.Inserting = False
                  OptionsView.GroupByBox = False
                  object cxGridDBTableView3fec_asiento: TcxGridDBColumn
                    Caption = 'Fecha'
                    DataBinding.FieldName = 'fec_asiento'
                    HeaderAlignmentHorz = taCenter
                    Width = 104
                  end
                  object cxGridDBTableView3comentario: TcxGridDBColumn
                    Caption = 'Comentario'
                    DataBinding.FieldName = 'comentario'
                    HeaderAlignmentHorz = taCenter
                    Width = 166
                  end
                  object cxGridDBTableView3nro_liquidacion: TcxGridDBColumn
                    Caption = 'Nro. Liquidaci'#243'n'
                    DataBinding.FieldName = 'nro_liquidacion'
                    HeaderAlignmentHorz = taCenter
                    Width = 94
                  end
                  object cxGridDBTableView3conta_sist_ext: TcxGridDBColumn
                    Caption = 'Conta. Sist. Ext.?'
                    DataBinding.FieldName = 'conta_sist_ext'
                    HeaderAlignmentHorz = taCenter
                    Width = 109
                  end
                  object cxGridDBTableView3fec_conta_sist_ext: TcxGridDBColumn
                    Caption = 'Fecha Conta.'
                    DataBinding.FieldName = 'fec_conta_sist_ext'
                    HeaderAlignmentHorz = taCenter
                    Width = 72
                  end
                  object cxGridDBTableView3hor_conta_sist_ext: TcxGridDBColumn
                    Caption = 'Hora'
                    DataBinding.FieldName = 'hor_conta_sist_ext'
                    HeaderAlignmentHorz = taCenter
                    Width = 67
                  end
                  object cxGridDBTableView3cuenta_banco: TcxGridDBColumn
                    Caption = 'Cuenta'
                    DataBinding.FieldName = 'cuenta_banco'
                    HeaderAlignmentHorz = taCenter
                    Width = 150
                  end
                  object cxGridDBTableView3modelo_liquidacion: TcxGridDBColumn
                    Caption = 'Liquidaci'#243'n'
                    DataBinding.FieldName = 'modelo_liquidacion'
                    HeaderAlignmentHorz = taCenter
                    Width = 150
                  end
                end
                object cxGridLevel3: TcxGridLevel
                  GridView = cxGridDBTableView3
                end
              end
            end
          end
        end
        object Panel19: TPanel
          Left = 0
          Top = 146
          Width = 797
          Height = 150
          Align = alClient
          Color = clWindow
          TabOrder = 1
          object Panel20: TPanel
            Left = 1
            Top = 1
            Width = 795
            Height = 148
            Align = alClient
            Color = clWindow
            TabOrder = 0
            object Panel21: TPanel
              Left = 1
              Top = 1
              Width = 793
              Height = 16
              Align = alTop
              Color = clMoneyGreen
              TabOrder = 0
              object snLabel8: TsnLabel
                Left = 4
                Top = 0
                Width = 94
                Height = 13
                Caption = 'Cuentas del Asiento'
              end
            end
            object Panel22: TPanel
              Left = 1
              Top = 17
              Width = 793
              Height = 130
              Align = alClient
              Color = clWindow
              TabOrder = 1
              object Panel24: TPanel
                Left = 1
                Top = 1
                Width = 791
                Height = 128
                Align = alClient
                Color = clWindow
                TabOrder = 0
                object dxDBGridSN5: TdxDBGridSN
                  Left = 1
                  Top = 1
                  Width = 789
                  Height = 126
                  Align = alClient
                  TabOrder = 0
                  CriteriosPintarCelda = <>
                  object cxGridDBTableView4: TcxGridDBTableView
                    NavigatorButtons.ConfirmDelete = False
                    DataController.DataSource = DSAsiLiqDet
                    DataController.Summary.DefaultGroupSummaryItems = <>
                    DataController.Summary.FooterSummaryItems = <
                      item
                        Format = '###,###,###,##0.00'
                        Kind = skSum
                        Column = cxGridDBColumn4
                      end
                      item
                        Format = '###,###,###,##0.00'
                        Kind = skSum
                        Column = cxGridDBColumn5
                      end>
                    DataController.Summary.SummaryGroups = <>
                    OptionsData.CancelOnExit = False
                    OptionsData.Deleting = False
                    OptionsData.DeletingConfirmation = False
                    OptionsData.Editing = False
                    OptionsData.Inserting = False
                    OptionsView.Footer = True
                    OptionsView.GroupByBox = False
                    object cxGridDBColumn1: TcxGridDBColumn
                      Caption = 'Cuenta'
                      DataBinding.FieldName = 'cuenta'
                      HeaderAlignmentHorz = taCenter
                      Width = 150
                    end
                    object cxGridDBColumn2: TcxGridDBColumn
                      DataBinding.FieldName = 'compo1'
                      HeaderAlignmentHorz = taCenter
                      Width = 126
                    end
                    object cxGridDBColumn3: TcxGridDBColumn
                      DataBinding.FieldName = 'compo2'
                      HeaderAlignmentHorz = taCenter
                      Width = 118
                    end
                    object cxGridDBColumn4: TcxGridDBColumn
                      Caption = 'Debe'
                      DataBinding.FieldName = 'debe'
                      HeaderAlignmentHorz = taCenter
                      SortIndex = 0
                      SortOrder = soDescending
                      Width = 80
                    end
                    object cxGridDBColumn5: TcxGridDBColumn
                      Caption = 'Haber'
                      DataBinding.FieldName = 'haber'
                      HeaderAlignmentHorz = taCenter
                      Width = 80
                    end
                    object cxGridDBTableView4Column1: TcxGridDBColumn
                      Caption = 'Impuesto'
                      DataBinding.FieldName = 'cod_impu'
                      HeaderAlignmentHorz = taCenter
                      Width = 73
                    end
                    object cxGridDBTableView4Column2: TcxGridDBColumn
                      Caption = 'Porc.'
                      DataBinding.FieldName = 'porc_impu'
                      HeaderAlignmentHorz = taCenter
                    end
                    object cxGridDBTableView4Column3: TcxGridDBColumn
                      Caption = 'Base'
                      DataBinding.FieldName = 'base'
                      HeaderAlignmentHorz = taCenter
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
      end
    end
    object Panel4: TPanel
      Left = 1
      Top = 328
      Width = 805
      Height = 215
      Align = alBottom
      BorderWidth = 10
      Color = clWindow
      TabOrder = 1
      object Panel6: TPanel
        Left = 11
        Top = 11
        Width = 783
        Height = 193
        Align = alClient
        Color = clWindow
        TabOrder = 0
        object Panel5: TPanel
          Left = 1
          Top = 1
          Width = 781
          Height = 191
          Align = alClient
          Color = clWindow
          TabOrder = 0
          object Panel14: TPanel
            Left = 1
            Top = 1
            Width = 779
            Height = 16
            Align = alTop
            Color = clMoneyGreen
            TabOrder = 0
            object snLabel6: TsnLabel
              Left = 4
              Top = 0
              Width = 223
              Height = 13
              Caption = 'Movimientos del POSNET asociados al Asiento'
            end
          end
          object Panel15: TPanel
            Left = 1
            Top = 17
            Width = 779
            Height = 173
            Align = alClient
            Color = clWindow
            TabOrder = 1
            object dxDBGridSN3: TdxDBGridSN
              Left = 1
              Top = 1
              Width = 777
              Height = 171
              Align = alClient
              TabOrder = 0
              LookAndFeel.Kind = lfFlat
              CriteriosPintarCelda = <
                item
                  TipoPintadaCelda = tpcTodasLasColumnas
                  FieldName1 = 'presentado'
                  TipoCondFiltro1 = tcfIgual
                  Valor1 = 'true'
                  TipoCondFiltro2 = tcfIgual
                  Color = 16759225
                end
                item
                  TipoPintadaCelda = tpcTodasLasColumnas
                  FieldName1 = 'marcar_preconci'
                  TipoCondFiltro1 = tcfIgual
                  Valor1 = 'true'
                  TipoCondFiltro2 = tcfIgual
                  Color = 5592575
                end
                item
                  TipoPintadaCelda = tpcTodasLasColumnas
                  FieldName1 = 'pre_conci'
                  TipoCondFiltro1 = tcfIgual
                  Valor1 = 'true'
                  TipoCondFiltro2 = tcfIgual
                  Color = 6460927
                end
                item
                  TipoPintadaCelda = tpcTodasLasColumnas
                  FieldName1 = 'conciliado'
                  TipoCondFiltro1 = tcfIgual
                  Valor1 = 'true'
                  TipoCondFiltro2 = tcfIgual
                  Color = 35840
                end
                item
                  TipoPintadaCelda = tpcSoloColumnaCampo
                  FieldName1 = 'preconci_dudoso'
                  TipoCondFiltro1 = tcfIgual
                  Valor1 = '?'
                  TipoCondFiltro2 = tcfIgual
                  Color = clYellow
                end>
              object cxGridDBTableView2: TcxGridDBTableView
                NavigatorButtons.ConfirmDelete = False
                DataController.Summary.DefaultGroupSummaryItems = <>
                DataController.Summary.FooterSummaryItems = <>
                DataController.Summary.SummaryGroups = <>
                OptionsView.GroupByBox = False
              end
              object dxDBGridSN1DBBandedTableView1: TcxGridDBBandedTableView
                NavigatorButtons.ConfirmDelete = False
                DataController.DataSource = DSDetCuponesCob
                DataController.Options = [dcoAssignGroupingValues, dcoAssignMasterDetailKeys, dcoSaveExpanding, dcoGroupsAlwaysExpanded]
                DataController.Summary.DefaultGroupSummaryItems = <>
                DataController.Summary.FooterSummaryItems = <
                  item
                    Format = '###,###,###,###,##0.00'
                    Kind = skSum
                    Column = dxDBGridSN1DBBandedTableView1Monto
                  end>
                DataController.Summary.SummaryGroups = <>
                OptionsBehavior.FocusCellOnTab = True
                OptionsBehavior.FocusFirstCellOnNewRecord = True
                OptionsBehavior.GoToNextCellOnEnter = True
                OptionsBehavior.IncSearch = True
                OptionsBehavior.FocusCellOnCycle = True
                OptionsCustomize.ColumnsQuickCustomization = True
                OptionsData.CancelOnExit = False
                OptionsData.Deleting = False
                OptionsData.DeletingConfirmation = False
                OptionsData.Editing = False
                OptionsData.Inserting = False
                OptionsView.Footer = True
                OptionsView.GroupByBox = False
                Bands = <
                  item
                    Width = 716
                  end
                  item
                  end
                  item
                    Caption = 'Conciliado'
                    Width = 150
                  end
                  item
                    Caption = 'Confirmado'
                    Width = 150
                  end
                  item
                    Caption = 'Cupon Recibido'
                    Width = 150
                  end
                  item
                    Caption = 'Conc. Autom'#225'tica'
                    Width = 120
                  end
                  item
                    Caption = 'Asientos'
                    Width = 500
                  end>
                object dxDBGridSN1DBBandedTableView1modo_transmision: TcxGridDBBandedColumn
                  DataBinding.FieldName = 'modo_transmision'
                  Visible = False
                  Options.Editing = False
                  Position.BandIndex = 0
                  Position.ColIndex = 0
                  Position.RowIndex = 0
                end
                object dxDBGridSN1DBBandedTableView1tipo_operacion: TcxGridDBBandedColumn
                  Caption = 'Tipo Oper.'
                  DataBinding.FieldName = 'tipo_operacion'
                  HeaderAlignmentHorz = taCenter
                  HeaderGlyphAlignmentHorz = taCenter
                  Options.Editing = False
                  Width = 52
                  Position.BandIndex = 0
                  Position.ColIndex = 4
                  Position.RowIndex = 0
                end
                object dxDBGridSN1DBBandedTableView1hora_oper: TcxGridDBBandedColumn
                  DataBinding.FieldName = 'hora_oper'
                  Visible = False
                  Options.Editing = False
                  Position.BandIndex = 0
                  Position.ColIndex = 5
                  Position.RowIndex = 0
                end
                object dxDBGridSN1DBBandedTableView1tipo_tarjeta: TcxGridDBBandedColumn
                  Caption = 'Tipo Tarj.'
                  DataBinding.FieldName = 'tipo_tarjeta'
                  HeaderAlignmentHorz = taCenter
                  Options.Editing = False
                  Width = 58
                  Position.BandIndex = 0
                  Position.ColIndex = 6
                  Position.RowIndex = 0
                end
                object dxDBGridSN1DBBandedTableView1tarjeta: TcxGridDBBandedColumn
                  Caption = 'Tarjeta'
                  DataBinding.FieldName = 'tarjeta'
                  HeaderAlignmentHorz = taCenter
                  HeaderGlyphAlignmentHorz = taCenter
                  Options.Editing = False
                  Width = 83
                  Position.BandIndex = 0
                  Position.ColIndex = 9
                  Position.RowIndex = 0
                end
                object dxDBGridSN1DBBandedTableView1nro_tarjeta: TcxGridDBBandedColumn
                  Caption = 'Nro. Tarjeta'
                  DataBinding.FieldName = 'ult_nros_tarj'
                  HeaderAlignmentHorz = taCenter
                  Options.Editing = False
                  Width = 111
                  Position.BandIndex = 0
                  Position.ColIndex = 10
                  Position.RowIndex = 0
                end
                object dxDBGridSN1DBBandedTableView1banda_manual: TcxGridDBBandedColumn
                  DataBinding.FieldName = 'banda_manual'
                  Visible = False
                  Options.Editing = False
                  Position.BandIndex = 0
                  Position.ColIndex = 11
                  Position.RowIndex = 0
                end
                object dxDBGridSN1DBBandedTableView1cod_autoriz: TcxGridDBBandedColumn
                  DataBinding.FieldName = 'cod_autoriz'
                  Visible = False
                  Options.Editing = False
                  Position.BandIndex = 0
                  Position.ColIndex = 12
                  Position.RowIndex = 0
                end
                object dxDBGridSN1DBBandedTableView1ticket: TcxGridDBBandedColumn
                  Caption = 'Cup'#243'n'
                  DataBinding.FieldName = 'ticket'
                  HeaderAlignmentHorz = taCenter
                  Options.Editing = False
                  Width = 88
                  Position.BandIndex = 1
                  Position.ColIndex = 1
                  Position.RowIndex = 0
                end
                object dxDBGridSN1DBBandedTableView1moneda: TcxGridDBBandedColumn
                  DataBinding.FieldName = 'moneda'
                  Visible = False
                  Options.Editing = False
                  Position.BandIndex = 0
                  Position.ColIndex = 13
                  Position.RowIndex = 0
                end
                object dxDBGridSN1DBBandedTableView1Monto: TcxGridDBBandedColumn
                  DataBinding.FieldName = 'Monto'
                  HeaderAlignmentHorz = taCenter
                  Options.Editing = False
                  Width = 66
                  Position.BandIndex = 0
                  Position.ColIndex = 15
                  Position.RowIndex = 0
                end
                object dxDBGridSN1DBBandedTableView1tipo_cta_deb: TcxGridDBBandedColumn
                  DataBinding.FieldName = 'tipo_cta_deb'
                  Visible = False
                  Options.Editing = False
                  Position.BandIndex = 0
                  Position.ColIndex = 16
                  Position.RowIndex = 0
                end
                object dxDBGridSN1DBBandedTableView1plan_y_cuota: TcxGridDBBandedColumn
                  DataBinding.FieldName = 'plan_y_cuota'
                  Visible = False
                  Options.Editing = False
                  Position.BandIndex = 0
                  Position.ColIndex = 17
                  Position.RowIndex = 0
                end
                object dxDBGridSN1DBBandedTableView1cod_comercio: TcxGridDBBandedColumn
                  DataBinding.FieldName = 'cod_comercio'
                  Visible = False
                  Options.Editing = False
                  Position.BandIndex = 0
                  Position.ColIndex = 18
                  Position.RowIndex = 0
                end
                object dxDBGridSN1DBBandedTableView1nro_terminal: TcxGridDBBandedColumn
                  Caption = 'Nro. Terminal'
                  DataBinding.FieldName = 'nro_terminal'
                  HeaderAlignmentHorz = taCenter
                  Options.Editing = False
                  Width = 90
                  Position.BandIndex = 1
                  Position.ColIndex = 0
                  Position.RowIndex = 0
                end
                object dxDBGridSN1DBBandedTableView1ticket_sec: TcxGridDBBandedColumn
                  DataBinding.FieldName = 'ticket_sec'
                  Visible = False
                  Options.Editing = False
                  Position.BandIndex = 0
                  Position.ColIndex = 19
                  Position.RowIndex = 0
                end
                object dxDBGridSN1DBBandedTableView1codigo_lista: TcxGridDBBandedColumn
                  DataBinding.FieldName = 'codigo_lista'
                  Visible = False
                  Options.Editing = False
                  Position.BandIndex = 0
                  Position.ColIndex = 20
                  Position.RowIndex = 0
                end
                object dxDBGridSN1DBBandedTableView1monto_sec: TcxGridDBBandedColumn
                  DataBinding.FieldName = 'monto_sec'
                  Visible = False
                  Options.Editing = False
                  Position.BandIndex = 0
                  Position.ColIndex = 21
                  Position.RowIndex = 0
                end
                object dxDBGridSN1DBBandedTableView1fecha_sec: TcxGridDBBandedColumn
                  DataBinding.FieldName = 'fecha_sec'
                  Visible = False
                  Options.Editing = False
                  Position.BandIndex = 0
                  Position.ColIndex = 22
                  Position.RowIndex = 0
                end
                object dxDBGridSN1DBBandedTableView1factura: TcxGridDBBandedColumn
                  DataBinding.FieldName = 'factura'
                  Visible = False
                  Options.Editing = False
                  Position.BandIndex = 0
                  Position.ColIndex = 23
                  Position.RowIndex = 0
                end
                object dxDBGridSN1DBBandedTableView1nro_host: TcxGridDBBandedColumn
                  DataBinding.FieldName = 'nro_host'
                  Visible = False
                  Options.Editing = False
                  Position.BandIndex = 0
                  Position.ColIndex = 24
                  Position.RowIndex = 0
                end
                object dxDBGridSN1DBBandedTableView1nro_lote: TcxGridDBBandedColumn
                  Caption = 'Lote'
                  DataBinding.FieldName = 'nro_lote'
                  HeaderAlignmentHorz = taCenter
                  HeaderAlignmentVert = vaCenter
                  Options.Editing = False
                  SortIndex = 1
                  SortOrder = soAscending
                  Width = 46
                  Position.BandIndex = 0
                  Position.ColIndex = 14
                  Position.RowIndex = 0
                end
                object dxDBGridSN1DBBandedTableView1activo: TcxGridDBBandedColumn
                  DataBinding.FieldName = 'activo'
                  Visible = False
                  Options.Editing = False
                  Position.BandIndex = 0
                  Position.ColIndex = 25
                  Position.RowIndex = 0
                end
                object dxDBGridSN1DBBandedTableView1oid_empresa: TcxGridDBBandedColumn
                  DataBinding.FieldName = 'oid_empresa'
                  Visible = False
                  Options.Editing = False
                  Position.BandIndex = 0
                  Position.ColIndex = 26
                  Position.RowIndex = 0
                end
                object dxDBGridSN1DBBandedTableView1oid_uni_neg: TcxGridDBBandedColumn
                  DataBinding.FieldName = 'oid_uni_neg'
                  Visible = False
                  Options.Editing = False
                  Position.BandIndex = 0
                  Position.ColIndex = 27
                  Position.RowIndex = 0
                end
                object dxDBGridSN1DBBandedTableView1fec_oper_date: TcxGridDBBandedColumn
                  Caption = 'Fec. Origen.'
                  DataBinding.FieldName = 'fec_oper_date'
                  HeaderAlignmentHorz = taCenter
                  HeaderAlignmentVert = vaCenter
                  Options.Editing = False
                  Width = 73
                  Position.BandIndex = 0
                  Position.ColIndex = 8
                  Position.RowIndex = 0
                end
                object dxDBGridSN1DBBandedTableView1fec_cierre: TcxGridDBBandedColumn
                  Caption = 'Fec. Cierre Lote'
                  DataBinding.FieldName = 'fec_cierre'
                  HeaderAlignmentHorz = taCenter
                  Options.Editing = False
                  SortIndex = 0
                  SortOrder = soAscending
                  Width = 75
                  Position.BandIndex = 0
                  Position.ColIndex = 7
                  Position.RowIndex = 0
                end
                object dxDBGridSN1DBBandedTableView1presentado: TcxGridDBBandedColumn
                  DataBinding.FieldName = 'presentado'
                  Visible = False
                  Options.Editing = False
                  Position.BandIndex = 4
                  Position.ColIndex = 0
                  Position.RowIndex = 0
                end
                object dxDBGridSN1DBBandedTableView1Column1: TcxGridDBBandedColumn
                  Caption = 'Recibido'
                  DataBinding.FieldName = 'presentado'
                  PropertiesClassName = 'TcxCheckBoxProperties'
                  HeaderAlignmentHorz = taCenter
                  Options.Editing = False
                  Width = 63
                  Position.BandIndex = 4
                  Position.ColIndex = 1
                  Position.RowIndex = 0
                end
                object dxDBGridSN1DBBandedTableView1Column2: TcxGridDBBandedColumn
                  Caption = 'Fec. Recibido'
                  DataBinding.FieldName = 'fec_presen_cupon'
                  HeaderAlignmentHorz = taCenter
                  Options.Editing = False
                  Width = 87
                  Position.BandIndex = 4
                  Position.ColIndex = 2
                  Position.RowIndex = 0
                end
                object dxDBGridSN1DBBandedTableView1Column3: TcxGridDBBandedColumn
                  Caption = 'Agrupador'
                  DataBinding.FieldName = 'agrupador'
                  Visible = False
                  GroupIndex = 0
                  Position.BandIndex = 0
                  Position.ColIndex = 28
                  Position.RowIndex = 0
                end
                object dxDBGridSN1DBBandedTableView1Column4: TcxGridDBBandedColumn
                  Caption = 'Marca'
                  DataBinding.FieldName = 'marcar_preconci'
                  PropertiesClassName = 'TcxCheckBoxProperties'
                  Properties.ImmediatePost = True
                  HeaderAlignmentHorz = taCenter
                  Width = 22
                  Position.BandIndex = 0
                  Position.ColIndex = 2
                  Position.RowIndex = 0
                end
                object dxDBGridSN1DBBandedTableView1Column5: TcxGridDBBandedColumn
                  Caption = 'Nro. Conci.'
                  DataBinding.FieldName = 'nro_conciliacion'
                  HeaderAlignmentHorz = taCenter
                  Options.Editing = False
                  Width = 62
                  Position.BandIndex = 0
                  Position.ColIndex = 3
                  Position.RowIndex = 0
                end
                object dxDBGridSN1DBBandedTableView1Column6: TcxGridDBBandedColumn
                  Caption = 'Conciliado'
                  DataBinding.FieldName = 'pre_conci'
                  PropertiesClassName = 'TcxCheckBoxProperties'
                  HeaderAlignmentHorz = taCenter
                  Options.Editing = False
                  Width = 87
                  Position.BandIndex = 2
                  Position.ColIndex = 1
                  Position.RowIndex = 0
                end
                object dxDBGridSN1DBBandedTableView1Column7: TcxGridDBBandedColumn
                  Caption = 'Fec. Conci.'
                  DataBinding.FieldName = 'fec_preconci'
                  HeaderAlignmentHorz = taCenter
                  Options.Editing = False
                  Width = 113
                  Position.BandIndex = 2
                  Position.ColIndex = 2
                  Position.RowIndex = 0
                end
                object dxDBGridSN1DBBandedTableView1Column8: TcxGridDBBandedColumn
                  Caption = 'Confirmado'
                  DataBinding.FieldName = 'conciliado'
                  PropertiesClassName = 'TcxCheckBoxProperties'
                  HeaderAlignmentHorz = taCenter
                  Options.Editing = False
                  Width = 81
                  Position.BandIndex = 3
                  Position.ColIndex = 0
                  Position.RowIndex = 0
                end
                object dxDBGridSN1DBBandedTableView1Column9: TcxGridDBBandedColumn
                  Caption = 'Fec. Confirmado'
                  DataBinding.FieldName = 'fec_conciliado'
                  HeaderAlignmentHorz = taCenter
                  Options.Editing = False
                  Width = 119
                  Position.BandIndex = 3
                  Position.ColIndex = 1
                  Position.RowIndex = 0
                end
                object dxDBGridSN1DBBandedTableView1Column10: TcxGridDBBandedColumn
                  Caption = 'Nro. Corrida'
                  DataBinding.FieldName = 'nro_conci_aut'
                  HeaderAlignmentHorz = taCenter
                  Options.Editing = False
                  Position.BandIndex = 5
                  Position.ColIndex = 0
                  Position.RowIndex = 0
                end
                object dxDBGridSN1DBBandedTableView1Column11: TcxGridDBBandedColumn
                  Caption = '*'
                  DataBinding.FieldName = 'preconci_dudoso'
                  HeaderAlignmentHorz = taCenter
                  Options.Editing = False
                  Width = 20
                  Position.BandIndex = 2
                  Position.ColIndex = 0
                  Position.RowIndex = 0
                end
                object dxDBGridSN1DBBandedTableView1Column12: TcxGridDBBandedColumn
                  Caption = 'Nro. Int.'
                  DataBinding.FieldName = 'oid_arch_lote_det'
                  HeaderAlignmentHorz = taCenter
                  Options.Editing = False
                  Width = 42
                  Position.BandIndex = 0
                  Position.ColIndex = 1
                  Position.RowIndex = 0
                end
                object dxDBGridSN1DBBandedTableView1Column13: TcxGridDBBandedColumn
                  Caption = 'Perd.'
                  DataBinding.FieldName = 'cupon_perdido'
                  PropertiesClassName = 'TcxCheckBoxProperties'
                  GroupSummaryAlignment = taCenter
                  HeaderAlignmentHorz = taCenter
                  Options.Editing = False
                  Position.BandIndex = 1
                  Position.ColIndex = 2
                  Position.RowIndex = 0
                end
                object dxDBGridSN1DBBandedTableView1Column14: TcxGridDBBandedColumn
                  Caption = 'Cobranza'
                  DataBinding.FieldName = 'est_asi_cob'
                  HeaderAlignmentHorz = taCenter
                  Options.Editing = False
                  Width = 71
                  Position.BandIndex = 6
                  Position.ColIndex = 0
                  Position.RowIndex = 0
                end
                object dxDBGridSN1DBBandedTableView1Column15: TcxGridDBBandedColumn
                  Caption = 'Liquidaci'#243'n'
                  DataBinding.FieldName = 'est_asi_liq'
                  HeaderAlignmentHorz = taCenter
                  Options.Editing = False
                  Width = 90
                  Position.BandIndex = 6
                  Position.ColIndex = 3
                  Position.RowIndex = 0
                end
                object dxDBGridSN1DBBandedTableView1Column16: TcxGridDBBandedColumn
                  Caption = 'Asi. Cob.'
                  DataBinding.FieldName = 'oid_cab_asi_acob'
                  Visible = False
                  HeaderAlignmentHorz = taCenter
                  Options.Editing = False
                  Width = 58
                  Position.BandIndex = 6
                  Position.ColIndex = 2
                  Position.RowIndex = 0
                end
                object dxDBGridSN1DBBandedTableView1Column17: TcxGridDBBandedColumn
                  Caption = 'Asi. Liq.'
                  DataBinding.FieldName = 'oid_cab_asi_liq'
                  Visible = False
                  HeaderAlignmentHorz = taCenter
                  Options.Editing = False
                  Width = 100
                  Position.BandIndex = 6
                  Position.ColIndex = 4
                  Position.RowIndex = 0
                end
                object dxDBGridSN1DBBandedTableView1Column18: TcxGridDBBandedColumn
                  Caption = 'Ref.Asi.Cob.'
                  DataBinding.FieldName = 'ref_asi_cob'
                  HeaderAlignmentHorz = taCenter
                  Options.Editing = False
                  Width = 174
                  Position.BandIndex = 6
                  Position.ColIndex = 1
                  Position.RowIndex = 0
                end
                object dxDBGridSN1DBBandedTableView1Column19: TcxGridDBBandedColumn
                  Caption = 'Ref. Asi. Liq.'
                  DataBinding.FieldName = 'ref_asi_liq'
                  HeaderAlignmentHorz = taCenter
                  Options.Editing = False
                  Width = 165
                  Position.BandIndex = 6
                  Position.ColIndex = 5
                  Position.RowIndex = 0
                end
              end
              object cxGridLevel2: TcxGridLevel
                GridView = dxDBGridSN1DBBandedTableView1
              end
            end
          end
        end
      end
    end
  end
  inherited DriverABM: TDriverABM
    CargaDataSets = <
      item
        DataSet = TAsiCobCab
        TableName = 'TAsiCobCab'
      end
      item
        DataSet = TAsiCobDet
        TableName = 'TAsiCobDet'
      end
      item
        DataSet = TDetCuponesCob
        TableName = 'TDetCuponesCob'
      end
      item
        DataSet = TAsiLiqCab
        TableName = 'TAsiLiqCab'
      end
      item
        DataSet = TAsiLiqDet
        TableName = 'TAsiLiqDet'
      end
      item
        DataSet = TDetCuponesLiq
        TableName = 'TDetCuponesLiq'
      end>
  end
  inherited TOidObjSave: TsnTable
    Top = 48
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
      
        '  dxDBGridSN2.setCaptionColumn('#39'compo1'#39',Varios.getValorString('#39'L' +
        'ABEL_COMP1_CONC_TARJ'#39'));'
      
        '  dxDBGridSN2.setCaptionColumn('#39'compo2'#39',Varios.getValorString('#39'L' +
        'ABEL_COMP2_CONC_TARJ'#39'));'
      
        '  dxDBGridSN5.setCaptionColumn('#39'compo1'#39',Varios.getValorString('#39'L' +
        'ABEL_COMP1_CONC_TARJ'#39'));'
      
        '  dxDBGridSN5.setCaptionColumn('#39'compo2'#39',Varios.getValorString('#39'L' +
        'ABEL_COMP1_CONC_TARJ'#39'));'
      'end.')
    OnChangeField = <
      item
        TableName = 'TInput'
        FieldName = 'tipo_asiento'
        Source.Strings = (
          'begin'
          '  if (Sender.AsString = '#39'COB'#39')'
          '      then begin'
          
            '              PageControl.setTabVisible('#39'TabSheetCobranza'#39',true)' +
            ';'
          '              PageControl.setActivePageName('#39'TabSheetCobranza'#39');'
          
            '              PageControl.setTabVisible('#39'TabSheetLiquidacion'#39',fa' +
            'lse);'
          '              TAsiCobCab.Close;'
          '              TAsiCobDet.Close;'
          '              TDetCuponesCob.Close;'
          '              TAsiLiqCab.close;'
          '              TAsiLiqDet.close;'
          '              TDetCuponesLiq.close;'
          
            '              dxDBGridSN3.setDataSourceByName('#39'DSDetCuponesCob'#39')' +
            ';'
          '              end'
          '      else  begin'
          
            '              PageControl.setTabVisible('#39'TabSheetCobranza'#39',false' +
            ');'
          
            '              PageControl.setTabVisible('#39'TabSheetLiquidacion'#39',tr' +
            'ue);'
          
            '              PageControl.setActivePageName('#39'TabSheetLiquidacion' +
            #39');'
          '              TAsiCobCab.Close;'
          '              TAsiCobDet.Close;'
          '              TDetCuponesCob.Close;'
          '              TAsiLiqCab.close;'
          '              TAsiLiqDet.close;'
          '              TDetCuponesLiq.close;'
          
            '              dxDBGridSN3.setDataSourceByName('#39'DSTDetCuponesLiq'#39 +
            ');'
          '              end;'
          ''
          ''
          'end.')
      end>
    OnInicializar = <
      item
        Source.Strings = (
          'begin'
          '   Varios.setImagen('#39'ImageBuscar'#39',0);'
          '   Varios.setImagen('#39'ImageSalir'#39',7);'
          '   cargarTiposAsientos();'
          '   PageControl.setTabVisible('#39'TabSheetCobranza'#39',false);'
          '   PageControl.setTabVisible('#39'TabSheetLiquidacion'#39',false);'
          '   TInput.Close;'
          '   TInput.Open;'
          '   TInput.AppendRecord;'
          'end.')
      end>
    OnFormFunction = <
      item
        Source.Strings = (
          'procedure cargarTiposAsientos();'
          'begin'
          ''
          '  TTiposAsientos.Close;'
          '  TTiposAsientos.Open;'
          ''
          '  TTiposAsientos.AppendRecord;'
          '  TTiposAsientos.FieldName('#39'codigo'#39').AsString := '#39'LIQ'#39';'
          
            '  TTiposAsientos.FieldName('#39'descripcion'#39').AsString := '#39'Liquidaci' +
            #243'n'#39';'
          '  TTiposAsientos.PostRecord;'
          ''
          '  TTiposAsientos.AppendRecord;'
          '  TTiposAsientos.FieldName('#39'codigo'#39').AsString := '#39'COB'#39';'
          
            '  TTiposAsientos.FieldName('#39'descripcion'#39').AsString := '#39'Cobranza'#39 +
            ';'
          '  TTiposAsientos.PostRecord;'
          '  '
          'end;'
          ''
          'procedure BuscarAsientos();'
          'begin'
          '  TDetCuponesCob.Close;'
          '  TInput.PostRecord;'
          
            '  if (TInput.FieldName('#39'tipo_asiento'#39').AsString='#39#39') then raiseEx' +
            'ception(erCustomError,'#39'Debe ingresar el tipo de asiento'#39');'
          
            '  if (TInput.FieldName('#39'fec_desde'#39').IsNull) then raiseException(' +
            'erCustomError,'#39'Debe ingresar la fecha desde'#39'); '
          
            '  if (TInput.FieldName('#39'fec_hasta'#39').IsNull) then raiseException(' +
            'erCustomError,'#39'Debe ingresar la fecha hasta'#39'); '
          '  operacion.InicioOperacion();'
          '  operacion.setOper('#39'BuscarAsiTarjDebCre'#39');'
          
            '  operacion.AddAtribute('#39'tipo'#39',TInput.FieldName('#39'tipo_asiento'#39').' +
            'AsString);'
          
            '  operacion.AddAtribute('#39'fec_desde'#39',TInput.FieldName('#39'fec_desde'#39 +
            ').AsString);'
          
            '  operacion.AddAtribute('#39'fec_hasta'#39',TInput.FieldName('#39'fec_hasta'#39 +
            ').AsString);'
          '  operacion.execute();'
          'end;')
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
          '  BuscarAsientos();'
          'end.')
      end>
    Left = 368
    Top = 51
  end
  inherited ImprimirObjetoSeleccionado: TdxComponentPrinter
    inherited ImprimirObjetoSeleccionadodxComponentPrinterLink: TdxGridReportLink
      BuiltInReportLink = True
    end
  end
  object Varios: TsnVarios
    Operacion = Operacion
    Left = 408
    Top = 273
  end
  object TInput: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'tipo_asiento'
        DataType = ftString
        Size = 50
      end
      item
        Name = 'fec_desde'
        DataType = ftDate
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
    Left = 110
    Top = 131
    object TInputtipo_asiento: TStringField
      FieldName = 'tipo_asiento'
      Size = 50
    end
    object TInputfec_desde: TDateField
      FieldName = 'fec_desde'
    end
    object TInputfec_hasta: TDateField
      FieldName = 'fec_hasta'
    end
  end
  object DSInput: TDataSource
    DataSet = TInput
    Left = 134
    Top = 131
  end
  object TTiposAsientos: TsnTable
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
    Left = 103
    Top = 208
    object TTiposAsientoscodigo: TStringField
      FieldName = 'codigo'
      Size = 50
    end
    object TTiposAsientosdescripcion: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
  end
  object DSTiposAsiento: TDataSource
    DataSet = TTiposAsientos
    Left = 135
    Top = 208
  end
  object TAsiCobCab: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'oid_cab_asi_acob'
        DataType = ftInteger
      end
      item
        Name = 'fec_asiento'
        DataType = ftDate
      end
      item
        Name = 'comentario'
        DataType = ftString
        Size = 255
      end
      item
        Name = 'nro_liquidacion'
        DataType = ftInteger
      end
      item
        Name = 'conta_sist_ext'
        DataType = ftBoolean
      end
      item
        Name = 'fec_conta_sist_ext'
        DataType = ftDate
      end
      item
        Name = 'hor_conta_sist_ext'
        DataType = ftString
        Size = 50
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
    Left = 79
    Top = 416
    object TAsiCobCaboid_cab_asi_acob: TIntegerField
      FieldName = 'oid_cab_asi_acob'
    end
    object TAsiCobCabfec_asiento: TDateField
      FieldName = 'fec_asiento'
    end
    object TAsiCobCabcomentario: TStringField
      FieldName = 'comentario'
      Size = 255
    end
    object TAsiCobCabnro_liquidacion: TIntegerField
      FieldName = 'nro_liquidacion'
    end
    object TAsiCobCabconta_sist_ext: TBooleanField
      FieldName = 'conta_sist_ext'
    end
    object TAsiCobCabfec_conta_sist_ext: TDateField
      FieldName = 'fec_conta_sist_ext'
    end
    object TAsiCobCabhor_conta_sist_ext: TStringField
      FieldName = 'hor_conta_sist_ext'
      Size = 50
    end
    object TAsiCobCabactivo: TBooleanField
      FieldName = 'activo'
    end
  end
  object DSCabAsiCob: TDataSource
    DataSet = TAsiCobCab
    Left = 111
    Top = 416
  end
  object TAsiCobDet: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'oid_det_asi_acob'
        DataType = ftInteger
      end
      item
        Name = 'orden'
        DataType = ftInteger
      end
      item
        Name = 'oid_cab_asi_acob'
        DataType = ftInteger
      end
      item
        Name = 'cuenta'
        DataType = ftString
        Size = 50
      end
      item
        Name = 'compo1'
        DataType = ftString
        Size = 50
      end
      item
        Name = 'compo2'
        DataType = ftString
        Size = 50
      end
      item
        Name = 'debe'
        DataType = ftCurrency
      end
      item
        Name = 'haber'
        DataType = ftCurrency
      end
      item
        Name = 'activo'
        DataType = ftBoolean
      end>
    IndexFieldNames = 'oid_cab_asi_acob'
    IndexDefs = <
      item
        Name = 'TAsiCobDetIndex1'
        Fields = 'oid_cab_asi_acob'
      end>
    RecalcOnFetch = False
    SortOptions = []
    PersistentBackup = False
    ProgressFlags = [mtpcLoad, mtpcSave, mtpcCopy]
    VersioningMode = mtvmAllSinceCheckPoint
    FilterOptions = []
    MasterFields = 'oid_cab_asi_acob'
    MasterSource = DSCabAsiCob
    Version = '4.08b'
    LanguageID = 0
    SortID = 0
    SubLanguageID = 1
    LocaleID = 1024
    MensajeValorDuplicadoIndice = 'Valor Duplicado'
    Left = 79
    Top = 465
    object TAsiCobDetoid_det_asi_acob: TIntegerField
      FieldName = 'oid_det_asi_acob'
    end
    object TAsiCobDetorden: TIntegerField
      FieldName = 'orden'
    end
    object TAsiCobDetoid_cab_asi_acob: TIntegerField
      FieldName = 'oid_cab_asi_acob'
    end
    object TAsiCobDetcuenta: TStringField
      FieldName = 'cuenta'
      Size = 50
    end
    object TAsiCobDetcompo1: TStringField
      FieldName = 'compo1'
      Size = 50
    end
    object TAsiCobDetcompo2: TStringField
      FieldName = 'compo2'
      Size = 50
    end
    object TAsiCobDetdebe: TCurrencyField
      FieldName = 'debe'
      DisplayFormat = '###,###,###,###.##'
    end
    object TAsiCobDethaber: TCurrencyField
      FieldName = 'haber'
      DisplayFormat = '###,###,###,###.##'
    end
    object TAsiCobDetactivo: TBooleanField
      FieldName = 'activo'
    end
  end
  object DSAsiCobDet: TDataSource
    DataSet = TAsiCobDet
    Left = 112
    Top = 464
  end
  object TDetCuponesCob: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'oid_arch_lote_det'
        DataType = ftInteger
      end
      item
        Name = 'oid_arch_lote_cab'
        DataType = ftInteger
      end
      item
        Name = 'modo_transmision'
        DataType = ftString
        Size = 3
      end
      item
        Name = 'tipo_operacion'
        DataType = ftString
        Size = 11
      end
      item
        Name = 'fecha_oper'
        DataType = ftString
        Size = 6
      end
      item
        Name = 'hora_oper'
        DataType = ftString
        Size = 6
      end
      item
        Name = 'tipo_tarjeta'
        DataType = ftString
        Size = 4
      end
      item
        Name = 'tarjeta'
        DataType = ftString
        Size = 100
      end
      item
        Name = 'nro_tarjeta'
        DataType = ftString
        Size = 20
      end
      item
        Name = 'banda_manual'
        DataType = ftString
        Size = 1
      end
      item
        Name = 'cod_autoriz'
        DataType = ftString
        Size = 6
      end
      item
        Name = 'ticket'
        DataType = ftString
        Size = 4
      end
      item
        Name = 'moneda'
        DataType = ftString
        Size = 3
      end
      item
        Name = 'Monto'
        DataType = ftFloat
      end
      item
        Name = 'tipo_cta_deb'
        DataType = ftString
        Size = 3
      end
      item
        Name = 'plan_y_cuota'
        DataType = ftString
        Size = 3
      end
      item
        Name = 'cod_comercio'
        DataType = ftString
        Size = 15
      end
      item
        Name = 'nro_terminal'
        DataType = ftString
        Size = 8
      end
      item
        Name = 'ticket_sec'
        DataType = ftString
        Size = 4
      end
      item
        Name = 'codigo_lista'
        DataType = ftString
        Size = 5
      end
      item
        Name = 'monto_sec'
        DataType = ftFloat
      end
      item
        Name = 'fecha_sec'
        DataType = ftString
        Size = 6
      end
      item
        Name = 'factura'
        DataType = ftString
        Size = 16
      end
      item
        Name = 'nro_host'
        DataType = ftString
        Size = 1
      end
      item
        Name = 'activo'
        DataType = ftBoolean
      end
      item
        Name = 'presentado'
        DataType = ftBoolean
      end
      item
        Name = 'oid_empresa'
        DataType = ftInteger
      end
      item
        Name = 'oid_uni_neg'
        DataType = ftInteger
      end
      item
        Name = 'fec_oper_date'
        DataType = ftDate
      end
      item
        Name = 'fec_cierre'
        DataType = ftDate
      end
      item
        Name = 'fec_presen_cupon'
        DataType = ftDate
      end
      item
        Name = 'conciliado'
        DataType = ftBoolean
      end
      item
        Name = 'fec_conciliado'
        DataType = ftDate
      end
      item
        Name = 'liquidado'
        DataType = ftBoolean
      end
      item
        Name = 'fec_liquidado'
        DataType = ftDate
      end
      item
        Name = 'preContabilizado'
        DataType = ftBoolean
      end
      item
        Name = 'fecPreContabilizado'
        DataType = ftDate
      end
      item
        Name = 'contabilizado'
        DataType = ftBoolean
      end
      item
        Name = 'fecContabilizado'
        DataType = ftDate
      end
      item
        Name = 'nro_lote'
        DataType = ftInteger
      end
      item
        Name = 'agrupador'
        DataType = ftString
        Size = 50
      end
      item
        Name = 'marcar_preconci'
        DataType = ftBoolean
      end
      item
        Name = 'ult_nros_tarj'
        DataType = ftInteger
      end
      item
        Name = 'nro_conciliacion'
        DataType = ftInteger
      end
      item
        Name = 'pre_conci'
        DataType = ftBoolean
      end
      item
        Name = 'fec_preconci'
        DataType = ftDate
      end
      item
        Name = 'nro_conci_aut'
        DataType = ftInteger
      end
      item
        Name = 'preconci_dudoso'
        DataType = ftString
        Size = 20
      end
      item
        Name = 'marca_asi_acob'
        DataType = ftBoolean
      end
      item
        Name = 'cupon_perdido'
        DataType = ftBoolean
      end
      item
        Name = 'est_asi_cob'
        DataType = ftString
        Size = 100
      end
      item
        Name = 'est_asi_liq'
        DataType = ftString
        Size = 50
      end
      item
        Name = 'oid_cab_asi_acob'
        DataType = ftInteger
      end
      item
        Name = 'oid_cab_asi_liq'
        DataType = ftInteger
      end
      item
        Name = 'ref_asi_cob'
        DataType = ftString
        Size = 255
      end
      item
        Name = 'ref_asi_liq'
        DataType = ftString
        Size = 255
      end>
    IndexFieldNames = 'oid_cab_asi_acob'
    IndexDefs = <
      item
        Name = 'TDetCuponesCobIndex1'
        Fields = 'oid_cab_asi_acob'
      end>
    RecalcOnFetch = False
    SortOptions = []
    PersistentBackup = False
    ProgressFlags = [mtpcLoad, mtpcSave, mtpcCopy]
    VersioningMode = mtvmAllSinceCheckPoint
    FilterOptions = []
    MasterFields = 'oid_cab_asi_acob'
    MasterSource = DSCabAsiCob
    Version = '4.08b'
    LanguageID = 0
    SortID = 0
    SubLanguageID = 1
    LocaleID = 1024
    MensajeValorDuplicadoIndice = 'Valor Duplicado'
    Left = 77
    Top = 514
    object TDetCuponesCoboid_arch_lote_det: TIntegerField
      FieldName = 'oid_arch_lote_det'
    end
    object TDetCuponesCoboid_arch_lote_cab: TIntegerField
      FieldName = 'oid_arch_lote_cab'
    end
    object TDetCuponesCobmodo_transmision: TStringField
      FieldName = 'modo_transmision'
      Size = 3
    end
    object TDetCuponesCobtipo_operacion: TStringField
      FieldName = 'tipo_operacion'
      Size = 11
    end
    object TDetCuponesCobfecha_oper: TStringField
      FieldName = 'fecha_oper'
      Size = 6
    end
    object TDetCuponesCobhora_oper: TStringField
      FieldName = 'hora_oper'
      Size = 6
    end
    object TDetCuponesCobtipo_tarjeta: TStringField
      FieldName = 'tipo_tarjeta'
      Size = 4
    end
    object TDetCuponesCobtarjeta: TStringField
      FieldName = 'tarjeta'
      Size = 100
    end
    object TDetCuponesCobnro_tarjeta: TStringField
      FieldName = 'nro_tarjeta'
    end
    object TDetCuponesCobbanda_manual: TStringField
      FieldName = 'banda_manual'
      Size = 1
    end
    object TDetCuponesCobcod_autoriz: TStringField
      FieldName = 'cod_autoriz'
      Size = 6
    end
    object TDetCuponesCobticket: TStringField
      FieldName = 'ticket'
      Size = 4
    end
    object TDetCuponesCobmoneda: TStringField
      FieldName = 'moneda'
      Size = 3
    end
    object TDetCuponesCobMonto: TFloatField
      FieldName = 'Monto'
    end
    object TDetCuponesCobtipo_cta_deb: TStringField
      FieldName = 'tipo_cta_deb'
      Size = 3
    end
    object TDetCuponesCobplan_y_cuota: TStringField
      FieldName = 'plan_y_cuota'
      Size = 3
    end
    object TDetCuponesCobcod_comercio: TStringField
      FieldName = 'cod_comercio'
      Size = 15
    end
    object TDetCuponesCobnro_terminal: TStringField
      FieldName = 'nro_terminal'
      Size = 8
    end
    object TDetCuponesCobticket_sec: TStringField
      FieldName = 'ticket_sec'
      Size = 4
    end
    object TDetCuponesCobcodigo_lista: TStringField
      FieldName = 'codigo_lista'
      Size = 5
    end
    object TDetCuponesCobmonto_sec: TFloatField
      FieldName = 'monto_sec'
    end
    object TDetCuponesCobfecha_sec: TStringField
      FieldName = 'fecha_sec'
      Size = 6
    end
    object TDetCuponesCobfactura: TStringField
      FieldName = 'factura'
      Size = 16
    end
    object TDetCuponesCobnro_host: TStringField
      FieldName = 'nro_host'
      Size = 1
    end
    object TDetCuponesCobactivo: TBooleanField
      FieldName = 'activo'
    end
    object TDetCuponesCobpresentado: TBooleanField
      FieldName = 'presentado'
    end
    object TDetCuponesCoboid_empresa: TIntegerField
      FieldName = 'oid_empresa'
    end
    object TDetCuponesCoboid_uni_neg: TIntegerField
      FieldName = 'oid_uni_neg'
    end
    object TDetCuponesCobfec_oper_date: TDateField
      FieldName = 'fec_oper_date'
    end
    object TDetCuponesCobfec_cierre: TDateField
      FieldName = 'fec_cierre'
    end
    object TDetCuponesCobfec_presen_cupon: TDateField
      FieldName = 'fec_presen_cupon'
    end
    object TDetCuponesCobconciliado: TBooleanField
      FieldName = 'conciliado'
    end
    object TDetCuponesCobfec_conciliado: TDateField
      FieldName = 'fec_conciliado'
    end
    object TDetCuponesCobliquidado: TBooleanField
      FieldName = 'liquidado'
    end
    object TDetCuponesCobfec_liquidado: TDateField
      FieldName = 'fec_liquidado'
    end
    object TDetCuponesCobpreContabilizado: TBooleanField
      FieldName = 'preContabilizado'
    end
    object TDetCuponesCobfecPreContabilizado: TDateField
      FieldName = 'fecPreContabilizado'
    end
    object TDetCuponesCobcontabilizado: TBooleanField
      FieldName = 'contabilizado'
    end
    object TDetCuponesCobfecContabilizado: TDateField
      FieldName = 'fecContabilizado'
    end
    object TDetCuponesCobnro_lote: TIntegerField
      FieldName = 'nro_lote'
    end
    object TDetCuponesCobagrupador: TStringField
      FieldName = 'agrupador'
      Size = 50
    end
    object TDetCuponesCobmarcar_preconci: TBooleanField
      DefaultExpression = 'false'
      FieldName = 'marcar_preconci'
    end
    object TDetCuponesCobult_nros_tarj: TIntegerField
      FieldName = 'ult_nros_tarj'
    end
    object TDetCuponesCobnro_conciliacion: TIntegerField
      FieldName = 'nro_conciliacion'
    end
    object TDetCuponesCobpre_conci: TBooleanField
      FieldName = 'pre_conci'
    end
    object TDetCuponesCobfec_preconci: TDateField
      FieldName = 'fec_preconci'
    end
    object TDetCuponesCobnro_conci_aut: TIntegerField
      FieldName = 'nro_conci_aut'
    end
    object TDetCuponesCobpreconci_dudoso: TStringField
      FieldName = 'preconci_dudoso'
    end
    object TDetCuponesCobmarca_asi_acob: TBooleanField
      FieldName = 'marca_asi_acob'
    end
    object TDetCuponesCobcupon_perdido: TBooleanField
      FieldName = 'cupon_perdido'
    end
    object TDetCuponesCobest_asi_cob: TStringField
      FieldName = 'est_asi_cob'
      Size = 100
    end
    object TDetCuponesCobest_asi_liq: TStringField
      FieldName = 'est_asi_liq'
      Size = 50
    end
    object TDetCuponesCoboid_cab_asi_acob: TIntegerField
      FieldName = 'oid_cab_asi_acob'
    end
    object TDetCuponesCoboid_cab_asi_liq: TIntegerField
      FieldName = 'oid_cab_asi_liq'
    end
    object TDetCuponesCobref_asi_cob: TStringField
      FieldName = 'ref_asi_cob'
      Size = 255
    end
    object TDetCuponesCobref_asi_liq: TStringField
      FieldName = 'ref_asi_liq'
      Size = 255
    end
  end
  object DSDetCuponesCob: TDataSource
    DataSet = TDetCuponesCob
    Left = 109
    Top = 514
  end
  object TAsiLiqCab: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'oid_cab_asi_liq'
        DataType = ftInteger
      end
      item
        Name = 'fec_asiento'
        DataType = ftDate
      end
      item
        Name = 'comentario'
        DataType = ftString
        Size = 255
      end
      item
        Name = 'nro_liquidacion'
        DataType = ftInteger
      end
      item
        Name = 'conta_sist_ext'
        DataType = ftBoolean
      end
      item
        Name = 'fec_conta_sist_ext'
        DataType = ftDate
      end
      item
        Name = 'hor_conta_sist_ext'
        DataType = ftString
        Size = 5
      end
      item
        Name = 'cuenta_banco'
        DataType = ftString
        Size = 100
      end
      item
        Name = 'modelo_liquidacion'
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
    Left = 230
    Top = 414
    object TAsiLiqCaboid_cab_asi_liq: TIntegerField
      FieldName = 'oid_cab_asi_liq'
    end
    object TAsiLiqCabfec_asiento: TDateField
      FieldName = 'fec_asiento'
    end
    object TAsiLiqCabcomentario: TStringField
      FieldName = 'comentario'
      Size = 255
    end
    object TAsiLiqCabnro_liquidacion: TIntegerField
      FieldName = 'nro_liquidacion'
    end
    object TAsiLiqCabconta_sist_ext: TBooleanField
      FieldName = 'conta_sist_ext'
    end
    object TAsiLiqCabfec_conta_sist_ext: TDateField
      FieldName = 'fec_conta_sist_ext'
    end
    object TAsiLiqCabhor_conta_sist_ext: TStringField
      FieldName = 'hor_conta_sist_ext'
      Size = 5
    end
    object TAsiLiqCabcuenta_banco: TStringField
      FieldName = 'cuenta_banco'
      Size = 100
    end
    object TAsiLiqCabmodelo_liquidacion: TStringField
      FieldName = 'modelo_liquidacion'
      Size = 100
    end
  end
  object DSAsiLiqCab: TDataSource
    DataSet = TAsiLiqCab
    Left = 262
    Top = 414
  end
  object TAsiLiqDet: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'oid_det_asi_liq'
        DataType = ftInteger
      end
      item
        Name = 'orden'
        DataType = ftInteger
      end
      item
        Name = 'oid_cab_asi_liq'
        DataType = ftInteger
      end
      item
        Name = 'cuenta'
        DataType = ftString
        Size = 50
      end
      item
        Name = 'compo1'
        DataType = ftString
        Size = 50
      end
      item
        Name = 'compo2'
        DataType = ftString
        Size = 50
      end
      item
        Name = 'debe'
        DataType = ftCurrency
      end
      item
        Name = 'haber'
        DataType = ftCurrency
      end
      item
        Name = 'activo'
        DataType = ftBoolean
      end
      item
        Name = 'cod_impu'
        DataType = ftString
        Size = 50
      end
      item
        Name = 'porc_impu'
        DataType = ftCurrency
      end
      item
        Name = 'base'
        DataType = ftCurrency
      end>
    IndexFieldNames = 'oid_cab_asi_liq'
    IndexDefs = <
      item
        Name = 'TAsiCobDetIndex1'
        Fields = 'oid_cab_asi_liq'
      end>
    RecalcOnFetch = False
    SortOptions = []
    PersistentBackup = False
    ProgressFlags = [mtpcLoad, mtpcSave, mtpcCopy]
    VersioningMode = mtvmAllSinceCheckPoint
    FilterOptions = []
    MasterFields = 'oid_cab_asi_liq'
    MasterSource = DSAsiLiqCab
    Version = '4.08b'
    LanguageID = 0
    SortID = 0
    SubLanguageID = 1
    LocaleID = 1024
    MensajeValorDuplicadoIndice = 'Valor Duplicado'
    Left = 232
    Top = 465
    object TAsiLiqDetoid_det_asi_liq: TIntegerField
      FieldName = 'oid_det_asi_liq'
    end
    object IntegerField2: TIntegerField
      FieldName = 'orden'
    end
    object TAsiLiqDetoid_cab_asi_liq: TIntegerField
      FieldName = 'oid_cab_asi_liq'
    end
    object StringField1: TStringField
      FieldName = 'cuenta'
      Size = 50
    end
    object StringField2: TStringField
      FieldName = 'compo1'
      Size = 50
    end
    object StringField3: TStringField
      FieldName = 'compo2'
      Size = 50
    end
    object CurrencyField1: TCurrencyField
      FieldName = 'debe'
      DisplayFormat = '###,###,###,###.##'
    end
    object CurrencyField2: TCurrencyField
      FieldName = 'haber'
      DisplayFormat = '###,###,###,###.##'
    end
    object BooleanField1: TBooleanField
      FieldName = 'activo'
    end
    object TAsiLiqDetcod_impu: TStringField
      FieldName = 'cod_impu'
      Size = 50
    end
    object TAsiLiqDetporc_impu: TCurrencyField
      FieldName = 'porc_impu'
      DisplayFormat = '###,###,###.##'
    end
    object TAsiLiqDetbase: TCurrencyField
      FieldName = 'base'
      DisplayFormat = '###,###,###.##'
    end
  end
  object DSAsiLiqDet: TDataSource
    DataSet = TAsiLiqDet
    Left = 265
    Top = 464
  end
  object TDetCuponesLiq: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'oid_arch_lote_det'
        DataType = ftInteger
      end
      item
        Name = 'oid_arch_lote_cab'
        DataType = ftInteger
      end
      item
        Name = 'modo_transmision'
        DataType = ftString
        Size = 3
      end
      item
        Name = 'tipo_operacion'
        DataType = ftString
        Size = 11
      end
      item
        Name = 'fecha_oper'
        DataType = ftString
        Size = 6
      end
      item
        Name = 'hora_oper'
        DataType = ftString
        Size = 6
      end
      item
        Name = 'tipo_tarjeta'
        DataType = ftString
        Size = 4
      end
      item
        Name = 'tarjeta'
        DataType = ftString
        Size = 100
      end
      item
        Name = 'nro_tarjeta'
        DataType = ftString
        Size = 20
      end
      item
        Name = 'banda_manual'
        DataType = ftString
        Size = 1
      end
      item
        Name = 'cod_autoriz'
        DataType = ftString
        Size = 6
      end
      item
        Name = 'ticket'
        DataType = ftString
        Size = 4
      end
      item
        Name = 'moneda'
        DataType = ftString
        Size = 3
      end
      item
        Name = 'Monto'
        DataType = ftFloat
      end
      item
        Name = 'tipo_cta_deb'
        DataType = ftString
        Size = 3
      end
      item
        Name = 'plan_y_cuota'
        DataType = ftString
        Size = 3
      end
      item
        Name = 'cod_comercio'
        DataType = ftString
        Size = 15
      end
      item
        Name = 'nro_terminal'
        DataType = ftString
        Size = 8
      end
      item
        Name = 'ticket_sec'
        DataType = ftString
        Size = 4
      end
      item
        Name = 'codigo_lista'
        DataType = ftString
        Size = 5
      end
      item
        Name = 'monto_sec'
        DataType = ftFloat
      end
      item
        Name = 'fecha_sec'
        DataType = ftString
        Size = 6
      end
      item
        Name = 'factura'
        DataType = ftString
        Size = 16
      end
      item
        Name = 'nro_host'
        DataType = ftString
        Size = 1
      end
      item
        Name = 'activo'
        DataType = ftBoolean
      end
      item
        Name = 'presentado'
        DataType = ftBoolean
      end
      item
        Name = 'oid_empresa'
        DataType = ftInteger
      end
      item
        Name = 'oid_uni_neg'
        DataType = ftInteger
      end
      item
        Name = 'fec_oper_date'
        DataType = ftDate
      end
      item
        Name = 'fec_cierre'
        DataType = ftDate
      end
      item
        Name = 'fec_presen_cupon'
        DataType = ftDate
      end
      item
        Name = 'conciliado'
        DataType = ftBoolean
      end
      item
        Name = 'fec_conciliado'
        DataType = ftDate
      end
      item
        Name = 'liquidado'
        DataType = ftBoolean
      end
      item
        Name = 'fec_liquidado'
        DataType = ftDate
      end
      item
        Name = 'preContabilizado'
        DataType = ftBoolean
      end
      item
        Name = 'fecPreContabilizado'
        DataType = ftDate
      end
      item
        Name = 'contabilizado'
        DataType = ftBoolean
      end
      item
        Name = 'fecContabilizado'
        DataType = ftDate
      end
      item
        Name = 'nro_lote'
        DataType = ftInteger
      end
      item
        Name = 'agrupador'
        DataType = ftString
        Size = 50
      end
      item
        Name = 'marcar_preconci'
        DataType = ftBoolean
      end
      item
        Name = 'ult_nros_tarj'
        DataType = ftInteger
      end
      item
        Name = 'nro_conciliacion'
        DataType = ftInteger
      end
      item
        Name = 'pre_conci'
        DataType = ftBoolean
      end
      item
        Name = 'fec_preconci'
        DataType = ftDate
      end
      item
        Name = 'nro_conci_aut'
        DataType = ftInteger
      end
      item
        Name = 'preconci_dudoso'
        DataType = ftString
        Size = 20
      end
      item
        Name = 'marca_asi_acob'
        DataType = ftBoolean
      end
      item
        Name = 'cupon_perdido'
        DataType = ftBoolean
      end
      item
        Name = 'est_asi_cob'
        DataType = ftString
        Size = 100
      end
      item
        Name = 'est_asi_liq'
        DataType = ftString
        Size = 50
      end
      item
        Name = 'oid_cab_asi_acob'
        DataType = ftInteger
      end
      item
        Name = 'oid_cab_asi_liq'
        DataType = ftInteger
      end
      item
        Name = 'ref_asi_cob'
        DataType = ftString
        Size = 255
      end
      item
        Name = 'ref_asi_liq'
        DataType = ftString
        Size = 255
      end>
    IndexFieldNames = 'oid_cab_asi_liq'
    IndexDefs = <
      item
        Name = 'TDetCuponesCobIndex1'
        Fields = 'oid_cab_asi_liq'
      end>
    RecalcOnFetch = False
    SortOptions = []
    PersistentBackup = False
    ProgressFlags = [mtpcLoad, mtpcSave, mtpcCopy]
    VersioningMode = mtvmAllSinceCheckPoint
    FilterOptions = []
    MasterFields = 'oid_cab_asi_liq'
    MasterSource = DSAsiLiqCab
    Version = '4.08b'
    LanguageID = 0
    SortID = 0
    SubLanguageID = 1
    LocaleID = 1024
    MensajeValorDuplicadoIndice = 'Valor Duplicado'
    Left = 232
    Top = 514
    object IntegerField1: TIntegerField
      FieldName = 'oid_arch_lote_det'
    end
    object IntegerField3: TIntegerField
      FieldName = 'oid_arch_lote_cab'
    end
    object StringField4: TStringField
      FieldName = 'modo_transmision'
      Size = 3
    end
    object StringField5: TStringField
      FieldName = 'tipo_operacion'
      Size = 11
    end
    object StringField6: TStringField
      FieldName = 'fecha_oper'
      Size = 6
    end
    object StringField7: TStringField
      FieldName = 'hora_oper'
      Size = 6
    end
    object StringField8: TStringField
      FieldName = 'tipo_tarjeta'
      Size = 4
    end
    object StringField9: TStringField
      FieldName = 'tarjeta'
      Size = 100
    end
    object StringField10: TStringField
      FieldName = 'nro_tarjeta'
    end
    object StringField11: TStringField
      FieldName = 'banda_manual'
      Size = 1
    end
    object StringField12: TStringField
      FieldName = 'cod_autoriz'
      Size = 6
    end
    object StringField13: TStringField
      FieldName = 'ticket'
      Size = 4
    end
    object StringField14: TStringField
      FieldName = 'moneda'
      Size = 3
    end
    object FloatField1: TFloatField
      FieldName = 'Monto'
    end
    object StringField15: TStringField
      FieldName = 'tipo_cta_deb'
      Size = 3
    end
    object StringField16: TStringField
      FieldName = 'plan_y_cuota'
      Size = 3
    end
    object StringField17: TStringField
      FieldName = 'cod_comercio'
      Size = 15
    end
    object StringField18: TStringField
      FieldName = 'nro_terminal'
      Size = 8
    end
    object StringField19: TStringField
      FieldName = 'ticket_sec'
      Size = 4
    end
    object StringField20: TStringField
      FieldName = 'codigo_lista'
      Size = 5
    end
    object FloatField2: TFloatField
      FieldName = 'monto_sec'
    end
    object StringField21: TStringField
      FieldName = 'fecha_sec'
      Size = 6
    end
    object StringField22: TStringField
      FieldName = 'factura'
      Size = 16
    end
    object StringField23: TStringField
      FieldName = 'nro_host'
      Size = 1
    end
    object BooleanField2: TBooleanField
      FieldName = 'activo'
    end
    object BooleanField3: TBooleanField
      FieldName = 'presentado'
    end
    object IntegerField4: TIntegerField
      FieldName = 'oid_empresa'
    end
    object IntegerField5: TIntegerField
      FieldName = 'oid_uni_neg'
    end
    object DateField1: TDateField
      FieldName = 'fec_oper_date'
    end
    object DateField2: TDateField
      FieldName = 'fec_cierre'
    end
    object DateField3: TDateField
      FieldName = 'fec_presen_cupon'
    end
    object BooleanField4: TBooleanField
      FieldName = 'conciliado'
    end
    object DateField4: TDateField
      FieldName = 'fec_conciliado'
    end
    object BooleanField5: TBooleanField
      FieldName = 'liquidado'
    end
    object DateField5: TDateField
      FieldName = 'fec_liquidado'
    end
    object BooleanField6: TBooleanField
      FieldName = 'preContabilizado'
    end
    object DateField6: TDateField
      FieldName = 'fecPreContabilizado'
    end
    object BooleanField7: TBooleanField
      FieldName = 'contabilizado'
    end
    object DateField7: TDateField
      FieldName = 'fecContabilizado'
    end
    object IntegerField6: TIntegerField
      FieldName = 'nro_lote'
    end
    object StringField24: TStringField
      FieldName = 'agrupador'
      Size = 50
    end
    object BooleanField8: TBooleanField
      DefaultExpression = 'false'
      FieldName = 'marcar_preconci'
    end
    object IntegerField7: TIntegerField
      FieldName = 'ult_nros_tarj'
    end
    object IntegerField8: TIntegerField
      FieldName = 'nro_conciliacion'
    end
    object BooleanField9: TBooleanField
      FieldName = 'pre_conci'
    end
    object DateField8: TDateField
      FieldName = 'fec_preconci'
    end
    object IntegerField9: TIntegerField
      FieldName = 'nro_conci_aut'
    end
    object StringField25: TStringField
      FieldName = 'preconci_dudoso'
    end
    object BooleanField10: TBooleanField
      FieldName = 'marca_asi_acob'
    end
    object BooleanField11: TBooleanField
      FieldName = 'cupon_perdido'
    end
    object StringField26: TStringField
      FieldName = 'est_asi_cob'
      Size = 100
    end
    object StringField27: TStringField
      FieldName = 'est_asi_liq'
      Size = 50
    end
    object IntegerField10: TIntegerField
      FieldName = 'oid_cab_asi_acob'
    end
    object IntegerField11: TIntegerField
      FieldName = 'oid_cab_asi_liq'
    end
    object StringField28: TStringField
      FieldName = 'ref_asi_cob'
      Size = 255
    end
    object StringField29: TStringField
      FieldName = 'ref_asi_liq'
      Size = 255
    end
  end
  object DSTDetCuponesLiq: TDataSource
    DataSet = TDetCuponesLiq
    Left = 262
    Top = 514
  end
end
