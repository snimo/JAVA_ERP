inherited FAsiLiqTarj: TFAsiLiqTarj
  Left = 68
  Top = 111
  Width = 914
  Height = 579
  BorderIcons = [biSystemMenu]
  Caption = 'Asiento Liquidaci'#243'n de Tarjetas'
  DragKind = dkDrag
  DragMode = dmManual
  Position = poScreenCenter
  PixelsPerInch = 96
  TextHeight = 13
  object Panel1: TPanel [0]
    Left = 0
    Top = 0
    Width = 898
    Height = 68
    Align = alTop
    BevelOuter = bvNone
    Color = clWindow
    TabOrder = 0
    object Label1: TLabel
      Left = 247
      Top = 16
      Width = 41
      Height = 16
      Caption = 'Fecha:'
      Font.Charset = DEFAULT_CHARSET
      Font.Color = clWindowText
      Font.Height = -13
      Font.Name = 'MS Sans Serif'
      Font.Style = []
      ParentFont = False
    end
    object Label2: TLabel
      Left = 16
      Top = 16
      Width = 72
      Height = 16
      Caption = 'Liquidaci'#243'n:'
      Font.Charset = DEFAULT_CHARSET
      Font.Color = clWindowText
      Font.Height = -13
      Font.Name = 'MS Sans Serif'
      Font.Style = []
      ParentFont = False
    end
    object Label3: TLabel
      Left = 386
      Top = 16
      Width = 100
      Height = 16
      Caption = 'Nro. Liquidaci'#243'n:'
      Font.Charset = DEFAULT_CHARSET
      Font.Color = clWindowText
      Font.Height = -13
      Font.Name = 'MS Sans Serif'
      Font.Style = []
      ParentFont = False
    end
    object Label4: TLabel
      Left = 572
      Top = 16
      Width = 42
      Height = 16
      Caption = 'Banco:'
      Font.Charset = DEFAULT_CHARSET
      Font.Color = clWindowText
      Font.Height = -13
      Font.Name = 'MS Sans Serif'
      Font.Style = []
      ParentFont = False
    end
    object Label5: TLabel
      Left = 16
      Top = 47
      Width = 161
      Height = 16
      Caption = 'Total Importe Movimientos:'
      Font.Charset = DEFAULT_CHARSET
      Font.Color = clWindowText
      Font.Height = -13
      Font.Name = 'MS Sans Serif'
      Font.Style = []
      ParentFont = False
    end
    object Label6: TLabel
      Left = 288
      Top = 47
      Width = 131
      Height = 16
      Caption = 'Cant. de Movimientos:'
      Font.Charset = DEFAULT_CHARSET
      Font.Color = clWindowText
      Font.Height = -13
      Font.Name = 'MS Sans Serif'
      Font.Style = []
      ParentFont = False
    end
    object Label7: TLabel
      Left = 528
      Top = 46
      Width = 80
      Height = 16
      Caption = 'Total Gastos:'
      Font.Charset = DEFAULT_CHARSET
      Font.Color = clWindowText
      Font.Height = -13
      Font.Name = 'MS Sans Serif'
      Font.Style = []
      ParentFont = False
    end
    object snDBLookup1: TsnDBLookup
      Left = 92
      Top = 14
      DataBinding.DataField = 'oid_liquidacion'
      DataBinding.DataSource = DSInput
      Properties.ImmediatePost = True
      Properties.KeyFieldNames = 'oid'
      Properties.ListColumns = <
        item
          FieldName = 'descripcion'
        end>
      Properties.ListOptions.ShowHeader = False
      Properties.ListSource = DSLiquidaciones
      TabOrder = 0
      Width = 145
    end
    object snDBDateEdit1: TsnDBDateEdit
      Left = 290
      Top = 14
      DataBinding.DataField = 'fecha'
      DataBinding.DataSource = DSInput
      TabOrder = 1
      ReadOnlyAlways = False
      Width = 89
    end
    object snDBEdit1: TsnDBEdit
      Left = 488
      Top = 14
      DataBinding.DataField = 'nro_liquidacion'
      DataBinding.DataSource = DSInput
      TabOrder = 2
      Width = 73
    end
    object snDBLookup2: TsnDBLookup
      Left = 616
      Top = 14
      DataBinding.DataField = 'oid_cta_banco'
      DataBinding.DataSource = DSInput
      Properties.KeyFieldNames = 'oid'
      Properties.ListColumns = <
        item
          FieldName = 'descripcion'
        end>
      Properties.ListOptions.ShowHeader = False
      Properties.ListSource = DSCtasBancarias
      TabOrder = 3
      Width = 185
    end
    object snDBEdit2: TsnDBEdit
      Left = 184
      Top = 46
      TabStop = False
      DataBinding.DataField = 'tot_mov'
      DataBinding.DataSource = DSInput
      Properties.ReadOnly = True
      TabOrder = 4
      ReadOnlyAlways = True
      Width = 89
    end
    object snDBEdit3: TsnDBEdit
      Left = 424
      Top = 45
      TabStop = False
      DataBinding.DataField = 'cant_mov'
      DataBinding.DataSource = DSInput
      Properties.ReadOnly = True
      TabOrder = 5
      ReadOnlyAlways = True
      Width = 73
    end
    object snDBEdit4: TsnDBEdit
      Left = 616
      Top = 44
      DataBinding.DataField = 'tot_gastos'
      DataBinding.DataSource = DSInput
      Properties.ReadOnly = False
      TabOrder = 6
      ReadOnlyAlways = True
      Width = 89
    end
  end
  object Panel2: TPanel [1]
    Left = 0
    Top = 68
    Width = 898
    Height = 432
    Align = alClient
    BevelOuter = bvNone
    BorderWidth = 10
    Color = clWindow
    TabOrder = 1
    object PageControlSN1: TPageControlSN
      Left = 10
      Top = 10
      Width = 878
      Height = 412
      ActivePage = TabSheet1
      Align = alClient
      Font.Charset = DEFAULT_CHARSET
      Font.Color = clWindowText
      Font.Height = -13
      Font.Name = 'MS Sans Serif'
      Font.Style = []
      ParentFont = False
      TabOrder = 0
      object TabSheet1: TTabSheet
        BorderWidth = 5
        Caption = '  Asiento de Liquidaci'#243'n  '
        Font.Charset = DEFAULT_CHARSET
        Font.Color = clWindowText
        Font.Height = -11
        Font.Name = 'MS Sans Serif'
        Font.Style = []
        ParentFont = False
        object dxDBGridSN1: TdxDBGridSN
          Left = 0
          Top = 0
          Width = 860
          Height = 371
          Align = alClient
          TabOrder = 0
          LookAndFeel.Kind = lfFlat
          CriteriosPintarCelda = <>
          object dxDBGridSN1DBTableView1: TcxGridDBTableView
            NavigatorButtons.ConfirmDelete = False
            DataController.DataSource = DSTDetalleAsiento
            DataController.Summary.DefaultGroupSummaryItems = <>
            DataController.Summary.FooterSummaryItems = <
              item
                Format = '###,###,###,###,##0.00'
                Kind = skSum
                Column = dxDBGridSN1DBTableView1debe
              end
              item
                Format = '###,###,###,###,##0.00'
                Kind = skSum
                Column = dxDBGridSN1DBTableView1haber
              end>
            DataController.Summary.SummaryGroups = <>
            OptionsBehavior.FocusCellOnTab = True
            OptionsBehavior.FocusFirstCellOnNewRecord = True
            OptionsBehavior.GoToNextCellOnEnter = True
            OptionsBehavior.FocusCellOnCycle = True
            OptionsData.Deleting = False
            OptionsData.DeletingConfirmation = False
            OptionsData.Inserting = False
            OptionsSelection.InvertSelect = False
            OptionsView.Footer = True
            OptionsView.GroupByBox = False
            object dxDBGridSN1DBTableView1orden: TcxGridDBColumn
              Caption = 'Orden'
              DataBinding.FieldName = 'orden'
              HeaderAlignmentHorz = taCenter
              SortIndex = 0
              SortOrder = soAscending
              Width = 34
            end
            object dxDBGridSN1DBTableView1cuenta: TcxGridDBColumn
              Caption = 'Cuenta'
              DataBinding.FieldName = 'cuenta'
              HeaderAlignmentHorz = taCenter
              Options.Editing = False
              Width = 77
            end
            object dxDBGridSN1DBTableView1desc_cuenta: TcxGridDBColumn
              Caption = 'Desc. Cuenta'
              DataBinding.FieldName = 'desc_cuenta'
              HeaderAlignmentHorz = taCenter
              Options.Editing = False
              Width = 129
            end
            object dxDBGridSN1DBTableView1Column4: TcxGridDBColumn
              Caption = 'Comentario'
              DataBinding.FieldName = 'comentario'
              HeaderAlignmentHorz = taCenter
              Width = 111
            end
            object dxDBGridSN1DBTableView1compo1: TcxGridDBColumn
              Caption = 'Compo. 1'
              DataBinding.FieldName = 'compo1'
              HeaderAlignmentHorz = taCenter
              Options.Editing = False
              Width = 64
            end
            object dxDBGridSN1DBTableView1compo2: TcxGridDBColumn
              Caption = 'Compo. 2'
              DataBinding.FieldName = 'compo2'
              HeaderAlignmentHorz = taCenter
              Options.Editing = False
              Width = 64
            end
            object dxDBGridSN1DBTableView1debe: TcxGridDBColumn
              Caption = 'Debe'
              DataBinding.FieldName = 'debe'
              PropertiesClassName = 'TcxCalcEditProperties'
              Properties.ImmediatePost = True
              HeaderAlignmentHorz = taCenter
              Width = 80
            end
            object dxDBGridSN1DBTableView1haber: TcxGridDBColumn
              Caption = 'Haber'
              DataBinding.FieldName = 'haber'
              PropertiesClassName = 'TcxCalcEditProperties'
              Properties.ImmediatePost = True
              HeaderAlignmentHorz = taCenter
              Width = 80
            end
            object dxDBGridSN1DBTableView1Column1: TcxGridDBColumn
              Caption = 'Cod. Impuesto'
              DataBinding.FieldName = 'cod_impuesto'
              HeaderAlignmentHorz = taCenter
              Width = 80
            end
            object dxDBGridSN1DBTableView1Column2: TcxGridDBColumn
              Caption = '% Imp.'
              DataBinding.FieldName = 'porc_imp'
              HeaderAlignmentHorz = taCenter
              Width = 48
            end
            object dxDBGridSN1DBTableView1Column3: TcxGridDBColumn
              Caption = 'Base'
              DataBinding.FieldName = 'base'
              HeaderAlignmentHorz = taCenter
              Options.Editing = False
            end
          end
          object dxDBGridSN1Level1: TcxGridLevel
            GridView = dxDBGridSN1DBTableView1
          end
        end
      end
      object TabSheet2: TTabSheet
        Caption = 'Detalle de Movimientos POSNET'
        ImageIndex = 1
        object Panel3: TPanel
          Left = 0
          Top = 0
          Width = 878
          Height = 33
          Align = alTop
          BevelOuter = bvNone
          Color = clWindow
          TabOrder = 0
          object BotonEliminar: TsnButton
            Left = 16
            Top = 3
            Width = 75
            Height = 25
            Cursor = crHandPoint
            Caption = '&Eliminar'
            TabOrder = 0
            LookAndFeel.Kind = lfOffice11
          end
        end
        object Panel4: TPanel
          Left = 0
          Top = 33
          Width = 878
          Height = 352
          Align = alClient
          Color = clWindow
          TabOrder = 1
          object dxDBGridSN2: TdxDBGridSN
            Left = 1
            Top = 1
            Width = 876
            Height = 350
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
            object cxGridDBTableView1: TcxGridDBTableView
              NavigatorButtons.ConfirmDelete = False
              DataController.Summary.DefaultGroupSummaryItems = <>
              DataController.Summary.FooterSummaryItems = <>
              DataController.Summary.SummaryGroups = <>
              OptionsView.GroupByBox = False
            end
            object dxDBGridSN1DBBandedTableView1: TcxGridDBBandedTableView
              NavigatorButtons.ConfirmDelete = False
              DataController.DataSource = DSDetCupones
              DataController.Options = [dcoAssignGroupingValues, dcoAssignMasterDetailKeys, dcoSaveExpanding, dcoGroupsAlwaysExpanded]
              DataController.Summary.DefaultGroupSummaryItems = <>
              DataController.Summary.FooterSummaryItems = <
                item
                  Format = '###,###,###,###.##'
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
              OptionsData.Deleting = False
              OptionsData.DeletingConfirmation = False
              OptionsData.Editing = False
              OptionsData.Inserting = False
              OptionsView.Footer = True
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
                  Width = 300
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
                Width = 51
                Position.BandIndex = 0
                Position.ColIndex = 3
                Position.RowIndex = 0
              end
              object dxDBGridSN1DBBandedTableView1hora_oper: TcxGridDBBandedColumn
                DataBinding.FieldName = 'hora_oper'
                Visible = False
                Options.Editing = False
                Position.BandIndex = 0
                Position.ColIndex = 4
                Position.RowIndex = 0
              end
              object dxDBGridSN1DBBandedTableView1tipo_tarjeta: TcxGridDBBandedColumn
                Caption = 'Tipo Tarj.'
                DataBinding.FieldName = 'tipo_tarjeta'
                HeaderAlignmentHorz = taCenter
                Options.Editing = False
                Width = 56
                Position.BandIndex = 0
                Position.ColIndex = 5
                Position.RowIndex = 0
              end
              object dxDBGridSN1DBBandedTableView1tarjeta: TcxGridDBBandedColumn
                Caption = 'Tarjeta'
                DataBinding.FieldName = 'tarjeta'
                HeaderAlignmentHorz = taCenter
                HeaderGlyphAlignmentHorz = taCenter
                Options.Editing = False
                Width = 81
                Position.BandIndex = 0
                Position.ColIndex = 8
                Position.RowIndex = 0
              end
              object dxDBGridSN1DBBandedTableView1nro_tarjeta: TcxGridDBBandedColumn
                Caption = 'Nro. Tarjeta'
                DataBinding.FieldName = 'ult_nros_tarj'
                HeaderAlignmentHorz = taCenter
                Options.Editing = False
                Width = 109
                Position.BandIndex = 0
                Position.ColIndex = 9
                Position.RowIndex = 0
              end
              object dxDBGridSN1DBBandedTableView1banda_manual: TcxGridDBBandedColumn
                DataBinding.FieldName = 'banda_manual'
                Visible = False
                Options.Editing = False
                Position.BandIndex = 0
                Position.ColIndex = 10
                Position.RowIndex = 0
              end
              object dxDBGridSN1DBBandedTableView1cod_autoriz: TcxGridDBBandedColumn
                DataBinding.FieldName = 'cod_autoriz'
                Visible = False
                Options.Editing = False
                Position.BandIndex = 0
                Position.ColIndex = 11
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
                Position.ColIndex = 12
                Position.RowIndex = 0
              end
              object dxDBGridSN1DBBandedTableView1Monto: TcxGridDBBandedColumn
                DataBinding.FieldName = 'Monto'
                HeaderAlignmentHorz = taCenter
                Options.Editing = False
                Width = 65
                Position.BandIndex = 0
                Position.ColIndex = 14
                Position.RowIndex = 0
              end
              object dxDBGridSN1DBBandedTableView1tipo_cta_deb: TcxGridDBBandedColumn
                DataBinding.FieldName = 'tipo_cta_deb'
                Visible = False
                Options.Editing = False
                Position.BandIndex = 0
                Position.ColIndex = 15
                Position.RowIndex = 0
              end
              object dxDBGridSN1DBBandedTableView1plan_y_cuota: TcxGridDBBandedColumn
                DataBinding.FieldName = 'plan_y_cuota'
                Visible = False
                Options.Editing = False
                Position.BandIndex = 0
                Position.ColIndex = 16
                Position.RowIndex = 0
              end
              object dxDBGridSN1DBBandedTableView1cod_comercio: TcxGridDBBandedColumn
                DataBinding.FieldName = 'cod_comercio'
                Visible = False
                Options.Editing = False
                Position.BandIndex = 0
                Position.ColIndex = 17
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
                Position.ColIndex = 18
                Position.RowIndex = 0
              end
              object dxDBGridSN1DBBandedTableView1codigo_lista: TcxGridDBBandedColumn
                DataBinding.FieldName = 'codigo_lista'
                Visible = False
                Options.Editing = False
                Position.BandIndex = 0
                Position.ColIndex = 19
                Position.RowIndex = 0
              end
              object dxDBGridSN1DBBandedTableView1monto_sec: TcxGridDBBandedColumn
                DataBinding.FieldName = 'monto_sec'
                Visible = False
                Options.Editing = False
                Position.BandIndex = 0
                Position.ColIndex = 20
                Position.RowIndex = 0
              end
              object dxDBGridSN1DBBandedTableView1fecha_sec: TcxGridDBBandedColumn
                DataBinding.FieldName = 'fecha_sec'
                Visible = False
                Options.Editing = False
                Position.BandIndex = 0
                Position.ColIndex = 21
                Position.RowIndex = 0
              end
              object dxDBGridSN1DBBandedTableView1factura: TcxGridDBBandedColumn
                DataBinding.FieldName = 'factura'
                Visible = False
                Options.Editing = False
                Position.BandIndex = 0
                Position.ColIndex = 22
                Position.RowIndex = 0
              end
              object dxDBGridSN1DBBandedTableView1nro_host: TcxGridDBBandedColumn
                DataBinding.FieldName = 'nro_host'
                Visible = False
                Options.Editing = False
                Position.BandIndex = 0
                Position.ColIndex = 23
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
                Width = 45
                Position.BandIndex = 0
                Position.ColIndex = 13
                Position.RowIndex = 0
              end
              object dxDBGridSN1DBBandedTableView1activo: TcxGridDBBandedColumn
                DataBinding.FieldName = 'activo'
                Visible = False
                Options.Editing = False
                Position.BandIndex = 0
                Position.ColIndex = 24
                Position.RowIndex = 0
              end
              object dxDBGridSN1DBBandedTableView1oid_empresa: TcxGridDBBandedColumn
                DataBinding.FieldName = 'oid_empresa'
                Visible = False
                Options.Editing = False
                Position.BandIndex = 0
                Position.ColIndex = 25
                Position.RowIndex = 0
              end
              object dxDBGridSN1DBBandedTableView1oid_uni_neg: TcxGridDBBandedColumn
                DataBinding.FieldName = 'oid_uni_neg'
                Visible = False
                Options.Editing = False
                Position.BandIndex = 0
                Position.ColIndex = 26
                Position.RowIndex = 0
              end
              object dxDBGridSN1DBBandedTableView1fec_oper_date: TcxGridDBBandedColumn
                Caption = 'Fec. Origen.'
                DataBinding.FieldName = 'fec_oper_date'
                HeaderAlignmentHorz = taCenter
                HeaderAlignmentVert = vaCenter
                Options.Editing = False
                Width = 71
                Position.BandIndex = 0
                Position.ColIndex = 7
                Position.RowIndex = 0
              end
              object dxDBGridSN1DBBandedTableView1fec_cierre: TcxGridDBBandedColumn
                Caption = 'Fec. Cierre Lote'
                DataBinding.FieldName = 'fec_cierre'
                HeaderAlignmentHorz = taCenter
                Options.Editing = False
                SortIndex = 0
                SortOrder = soAscending
                Width = 74
                Position.BandIndex = 0
                Position.ColIndex = 6
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
                Position.ColIndex = 27
                Position.RowIndex = 0
              end
              object dxDBGridSN1DBBandedTableView1Column5: TcxGridDBBandedColumn
                Caption = 'Nro. Conci.'
                DataBinding.FieldName = 'nro_conciliacion'
                HeaderAlignmentHorz = taCenter
                Options.Editing = False
                Width = 61
                Position.BandIndex = 0
                Position.ColIndex = 2
                Position.RowIndex = 0
              end
              object dxDBGridSN1DBBandedTableView1Column6: TcxGridDBBandedColumn
                Caption = 'Conciliado'
                DataBinding.FieldName = 'pre_conci'
                PropertiesClassName = 'TcxCheckBoxProperties'
                HeaderAlignmentHorz = taCenter
                Width = 87
                Position.BandIndex = 2
                Position.ColIndex = 1
                Position.RowIndex = 0
              end
              object dxDBGridSN1DBBandedTableView1Column7: TcxGridDBBandedColumn
                Caption = 'Fec. Conci.'
                DataBinding.FieldName = 'fec_preconci'
                HeaderAlignmentHorz = taCenter
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
                Width = 81
                Position.BandIndex = 3
                Position.ColIndex = 0
                Position.RowIndex = 0
              end
              object dxDBGridSN1DBBandedTableView1Column9: TcxGridDBBandedColumn
                Caption = 'Fec. Confirmado'
                DataBinding.FieldName = 'fec_conciliado'
                HeaderAlignmentHorz = taCenter
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
                Width = 43
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
                Width = 78
                Position.BandIndex = 6
                Position.ColIndex = 0
                Position.RowIndex = 0
              end
              object dxDBGridSN1DBBandedTableView1Column15: TcxGridDBBandedColumn
                Caption = 'Liquidaci'#243'n'
                DataBinding.FieldName = 'est_asi_liq'
                HeaderAlignmentHorz = taCenter
                Options.Editing = False
                Width = 153
                Position.BandIndex = 6
                Position.ColIndex = 2
                Position.RowIndex = 0
              end
              object dxDBGridSN1DBBandedTableView1Column16: TcxGridDBBandedColumn
                Caption = 'Asi. Cob.'
                DataBinding.FieldName = 'oid_cab_asi_acob'
                HeaderAlignmentHorz = taCenter
                Options.Editing = False
                Width = 69
                Position.BandIndex = 6
                Position.ColIndex = 1
                Position.RowIndex = 0
              end
            end
            object cxGridLevel1: TcxGridLevel
              GridView = dxDBGridSN1DBBandedTableView1
            end
          end
        end
      end
    end
  end
  object Panel5: TPanel [2]
    Left = 0
    Top = 500
    Width = 898
    Height = 41
    Align = alBottom
    Color = clWindow
    TabOrder = 2
    object BotonGenerarAsi: TsnButton
      Left = 664
      Top = 0
      Width = 169
      Height = 33
      Cursor = crHandPoint
      Caption = 'Generar Asiento'
      Font.Charset = DEFAULT_CHARSET
      Font.Color = clWindowText
      Font.Height = -13
      Font.Name = 'MS Sans Serif'
      Font.Style = []
      ParentFont = False
      TabOrder = 0
      LookAndFeel.Kind = lfOffice11
    end
    object BotonSalir: TsnButton
      Left = 40
      Top = 0
      Width = 169
      Height = 33
      Cursor = crHandPoint
      Caption = 'Salir'
      Font.Charset = DEFAULT_CHARSET
      Font.Color = clWindowText
      Font.Height = -13
      Font.Name = 'MS Sans Serif'
      Font.Style = []
      ParentFont = False
      TabOrder = 1
      LookAndFeel.Kind = lfOffice11
    end
  end
  inherited DriverABM: TDriverABM
    CargaDataSets = <
      item
        DataSet = TDetCupones
        TableName = 'TDetCupones'
      end
      item
        DataSet = TLiquidaciones
        TableName = 'TLiquidaciones'
      end
      item
        DataSet = TCabModeloLiq
        TableName = 'TCabModeloLiq'
      end
      item
        DataSet = TDetModeloLiq
        TableName = 'TDetModeloLiq'
      end
      item
        DataSet = TGenAsiLiq
        TableName = 'TGenAsiLiq'
      end
      item
        DataSet = TAsiLiqGenerado
        TableName = 'TAsiLiqGenerado'
      end
      item
        DataSet = TCtasBancarias
        TableName = 'TCtasBancarias'
      end>
    Left = 56
    Top = 264
  end
  inherited Operacion: TOperacion
    Left = 88
    Top = 264
  end
  inherited TOidObjSave: TsnTable
    Left = 464
    Top = 72
  end
  inherited dxComponentPrinter: TdxComponentPrinter
    Left = 152
    Top = 264
    inherited dxComponentPrinterLink1: TdxCustomContainerReportLink
      Component = Owner
      BuiltInReportLink = True
      HiddenComponents = {}
      ExcludedComponents = {}
      AggregatedReportLinks = {}
    end
  end
  inherited SaveDialog: TSaveDialog
    Left = 120
    Top = 264
  end
  inherited DriverEvent: TDriverEvent
    OnShow.Strings = (
      'begin'
      '  InicializarTabla();'
      '  TDetalleAsiento.Close;'
      '  TDetalleAsiento.Open;'
      '  TDetCupones.Close;'
      '  TDetCupones.Open;'
      
        '  dxDBGridSN1.setCaptionColumn('#39'compo1'#39',Varios.getValorString('#39'L' +
        'ABEL_COMP1_CONC_TARJ'#39'));'
      
        '  dxDBGridSN1.setCaptionColumn('#39'compo2'#39',Varios.getValorString('#39'L' +
        'ABEL_COMP2_CONC_TARJ'#39'));'
      '  operacion.InicioOperacion();'
      '  operacion.setOper('#39'TraerCtasConciByEmp'#39');'
      
        '  operacion.AddAtribute('#39'oid_empresa'#39',IntToStr(variable.getInteg' +
        'er('#39'oid_empresa'#39')));'
      '  operacion.execute();'
      'end.')
    OnValidate = <
      item
        TableName = 'TInput'
        FieldName = 'oid_liquidacion'
        Source.Strings = (
          'begin'
          '  if (Sender.IsNull)'
          
            '     then raiseException(erCustomError,'#39'Debe ingresar la Liquida' +
            'ci'#243'n'#39');'
          '  ValidarDatosCabAsi();'
          'end.')
      end
      item
        TableName = 'TDetalleAsiento'
        FieldName = 'debe'
        Source.Strings = (
          'begin'
          '  if (Sender.AsCurrency<0)'
          
            '    then raiseException(erCustomError,'#39'El importe del DEBE no pu' +
            'ede ser negativo'#39');'
          'end.')
      end
      item
        TableName = 'TDetalleAsiento'
        FieldName = 'haber'
        Source.Strings = (
          'begin'
          '  if (Sender.AsCurrency<0)'
          
            '    then raiseException(erCustomError,'#39'El importe del HABER no p' +
            'uede ser negativo'#39');'
          'end.'
          '')
      end
      item
        TableName = 'TInput'
        FieldName = 'fecha'
        Source.Strings = (
          'begin'
          '  ValidarDatosCabAsi();'
          'end.')
      end
      item
        TableName = 'TInput'
        FieldName = 'nro_liquidacion'
        Source.Strings = (
          'begin'
          ' ValidarDatosCabAsi();'
          'end.')
      end>
    OnChangeField = <
      item
        TableName = 'TInput'
        FieldName = 'oid_liquidacion'
        Source.Strings = (
          'begin'
          '  if (Sender.AsInteger>0)'
          '     then begin'
          '             TraerModeloLiq(Sender.AsInteger);'
          '              llenarAsiento();'
          '             TraerMovCupones();'
          '             CalcTotMov();'
          '             end;'
          'end.')
      end>
    OnBeforePost = <
      item
        TableName = 'TDetalleAsiento'
        Source.Strings = (
          'begin'
          '  if (Trim(TDetalleAsiento.FieldName('#39'cuenta'#39').AsString)='#39#39')'
          
            '     then raiseException(erCustomError,'#39'Debe ingresar la cuenta'#39 +
            ');'
          
            '  if ((DataSet.FieldName('#39'debe'#39').AsCurrency<>0) and (DataSet.Fie' +
            'ldName('#39'haber'#39').AsCurrency<>0))'
          
            '     then raiseException(erCustomError,'#39'Debe ingresar el importe' +
            ' en el debe o el haber'#39');'
          'end.')
      end>
    OnPublicVariable = <
      item
        VariableName = 'oid_empresa'
      end
      item
        VariableName = 'TInput'
      end
      item
        VariableName = 'mis_marcados'
      end>
    OnCalcFields = <
      item
        TableName = 'TDetalleAsiento'
        Source.Strings = (
          'var'
          '  importe : currency;'
          '  porc : currency;'
          'begin'
          '  importe := 0;'
          '  if (DataSet.FieldName('#39'debe'#39').AsCurrency<>0)'
          '     then importe := DataSet.FieldName('#39'debe'#39').AsCurrency;'
          '  if (DataSet.FieldName('#39'haber'#39').AsCurrency<>0)'
          '     then importe := DataSet.FieldName('#39'haber'#39').AsCurrency;  '
          '  porc := (DataSet.FieldName('#39'porc_imp'#39').AsCurrency/100);'
          '  if (porc<>0)'
          
            '     then DataSet.FieldName('#39'base'#39').AsCurrency := varios.redonde' +
            'ar((importe / porc),2)'
          '     else  DataSet.FieldName('#39'base'#39').AsCurrency := 0; '
          'end.')
      end>
    OnInicializar = <
      item
        Source.Strings = (
          'begin'
          'end.')
      end>
    OnFormFunction = <
      item
        Source.Strings = (
          'procedure TraerModLiq();'
          'begin'
          '  operacion.InicioOperacion();'
          '  operacion.setOper('#39'TraerModLiqEmp'#39');'
          
            '  operacion.AddAtribute('#39'oid_empresa'#39',intToStr(variable.getInteg' +
            'er('#39'oid_empresa'#39')));'
          '  operacion.execute();'
          'end;'
          ''
          ''
          'procedure InicializarTabla();'
          'begin'
          '  TraerModLiq();'
          '  TInput.Close;'
          '  TInput.Open;'
          '  TInput.AppendRecord;'
          '  TInput.FieldName('#39'acepto'#39').AsBoolean := False;'
          
            '  TInput.FieldName('#39'oid_empresa'#39').AsInteger := variable.getInteg' +
            'er('#39'oid_empresa'#39');'
          '  TInput.PostRecord;'
          'end;'
          ''
          'procedure TraerMovCupones();'
          'begin'
          ''
          '  if (variable.getInteger('#39'oid_empresa'#39')=0)'
          
            '     then raiseException(erCustomError,'#39'Debe ingresar la empresa' +
            #39');  '
          ''
          '  if (TInput.FieldName('#39'oid_liquidacion'#39').AsInteger=0)'
          
            '     then raiseException(erCustomError,'#39'Debe ingresar la liquida' +
            'ci'#243'n'#39');  '
          ''
          '  operacion.InicioOperacion();'
          '  operacion.setOper('#39'TraerMovCupoParaAsiLiq'#39');'
          
            '  operacion.AddAtribute('#39'oid_empresa'#39', intToStr(variable.getInte' +
            'ger('#39'oid_empresa'#39')));'
          
            '  operacion.AddAtribute('#39'oid_mod_liq'#39',TInput.FieldName('#39'oid_liqu' +
            'idacion'#39').AsString);'
          
            '  operacion.AddAtribute('#39'mis_marcados'#39',variable.getString('#39'mis_m' +
            'arcados'#39'));'
          '  operacion.execute();'
          ''
          'end;'
          ''
          'procedure TraerModeloLiq(OidModelo : integer);'
          'begin'
          '  operacion.InicioOperacion();'
          '  operacion.setOper('#39'TraerModAsiLiq'#39');'
          '  operacion.AddAtribute('#39'oid'#39',IntToStr(OidModelo));'
          '  operacion.execute();'
          'end;'
          ''
          'procedure llenarAsiento();'
          'begin'
          ''
          '   TDetalleAsiento.DeshabilitarEventoOnCalcFields;'
          ''
          '   try'
          '  '
          '   TDetalleAsiento.Close;'
          '   TDetalleAsiento.Open; '
          '   TDetModeloLiq.First;'
          '   while (not TDetModeloLiq.EOF) do'
          '     begin'
          ''
          '     TDetalleAsiento.AppendRecord;'
          
            '     TDetalleAsiento.FieldName('#39'orden'#39').AsInteger := TDetModeloL' +
            'iq.FieldName('#39'orden'#39').AsInteger;'
          
            '     TDetalleAsiento.FieldName('#39'cuenta'#39').AsString := TDetModeloL' +
            'iq.FieldName('#39'cuenta'#39').AsString;'
          
            '     TDetalleAsiento.FieldName('#39'desc_cuenta'#39').AsString := TDetMo' +
            'deloLiq.FieldName('#39'desc_cuenta'#39').AsString;'
          
            '     TDetalleAsiento.FieldName('#39'compo1'#39').AsString := TDetModeloL' +
            'iq.FieldName('#39'compo1'#39').AsString;'
          
            '     TDetalleAsiento.FieldName('#39'compo2'#39').AsString := TDetModeloL' +
            'iq.FieldName('#39'compo2'#39').AsString;'
          
            '     TDetalleAsiento.FieldName('#39'debe'#39').AsCurrency := TDetModeloL' +
            'iq.FieldName('#39'debe'#39').AsCurrency;'
          
            '     TDetalleAsiento.FieldName('#39'haber'#39').AsCurrency := TDetModelo' +
            'Liq.FieldName('#39'haber'#39').AsCurrency;'
          
            '     TDetalleAsiento.FieldName('#39'cod_impuesto'#39').AsString := TDetM' +
            'odeloLiq.FieldName('#39'cod_impuesto'#39').AsString;'
          
            '     TDetalleAsiento.FieldName('#39'porc_imp'#39').AsCurrency := TDetMod' +
            'eloLiq.FieldName('#39'porc_imp'#39').AsCurrency;'
          '     TDetalleAsiento.PostRecord;'
          ' '
          '     TDetModeloLiq.next;'
          '     end;'
          ''
          ''
          '     finally'
          ''
          '     TDetalleAsiento.HabilitarEventoOnCalcFields;'
          ''
          '      end;'
          ''
          'end;'
          ''
          'procedure CalcTotMov();'
          'var'
          '  importe : currency;'
          '  cant : integer;'
          'begin   '
          ''
          '   TDetCupones.DesHabilitarControles();'
          ''
          '   try '
          ''
          '   importe := 0;'
          '   cant := 0;'
          ''
          '   TDetCupones.First;'
          '   while (not TDetCupones.eof) do'
          '       begin'
          ''
          
            '       importe := importe + TDetCupones.FieldName('#39'Monto'#39').AsCur' +
            'rency;'
          '       cant := cant + 1; '
          ''
          '       TDetCupones.next;'
          '       end;'
          ''
          '   TInput.EditRecord;'
          '   TInput.FieldName('#39'tot_mov'#39').AsCurrency := importe;'
          '   TInput.FieldName('#39'cant_mov'#39').AsInteger := cant;'
          ''
          '   finally'
          '     TDetCupones.HabilitarControles();'
          '   end;'
          ''
          'end;'
          ''
          'procedure GenerarAsiento();'
          'begin'
          ''
          '  TGenAsiLiq.Close;'
          '  TGenAsiLiq.Open;    '
          '  TAsiLiqGenerado.Close;'
          '  TAsiLiqGenerado.Open;'
          ''
          '  operacion.InicioOperacion();'
          '  operacion.setOper('#39'GenerarAsiLiqTarj'#39');'
          '  operacion.AddDataSet(TInput.getDataSet());'
          '  operacion.AddDataSet(TDetalleAsiento.getDataSet());'
          '  operacion.AddDataSet(TDetCupones.getDataSet());'
          '  operacion.execute();'
          ''
          '  if (not TAsiLiqGenerado.IsEmpty())'
          
            '     then  mensaje.information('#39'Se genero el asiento de Liquidac' +
            'i'#243'n  '#39'+TAsiLiqGenerado.FieldName('#39'referencia'#39').AsString);'
          ''
          '  TInput.EditRecord;'
          '  TInput.FieldName('#39'acepto'#39').AsBoolean := true;'
          '  TInput.PostRecord;'
          '   '
          '  close;'
          ' '
          'end;'
          ''
          'procedure ValidarDatosCabAsi();'
          'begin'
          ''
          
            '  if (TInput.FieldName('#39'oid_liquidacion'#39').AsInteger<=0) then exi' +
            't;'
          '  if (TInput.FieldName('#39'fecha'#39').IsNull) then exit;'
          
            '  if (TInput.FieldName('#39'nro_liquidacion'#39').AsInteger<=0) then exi' +
            't;'
          ''
          '  operacion.InicioOperacion();'
          '  operacion.setOper('#39'ValidarIngAsiLiq'#39');'
          
            '  operacion.AddAtribute('#39'oid_modelo_liq'#39', TInput.FieldName('#39'oid_' +
            'liquidacion'#39').AsString);'
          
            '  operacion.AddAtribute('#39'fecha'#39', TInput.FieldName('#39'fecha'#39').AsStr' +
            'ing);'
          
            '  operacion.AddAtribute('#39'nro_liquidacion'#39', TInput.FieldName('#39'nro' +
            '_liquidacion'#39').AsString);'
          '  operacion.execute();'
          ''
          'end;'
          ''
          ''
          ''
          ''
          '')
      end>
    OnClickToolButton = <
      item
        ButtonName = 'BotonEliminar'
        Source.Strings = (
          'begin'
          '  if (not TDetCupones.isEmpty)'
          
            '      then if (mensaje.question('#39'Desea eliminar el movimiento ac' +
            'tual?'#39'))'
          '              then begin'
          '                      TDetCupones.borrar();'
          '                      CalcTotMov();'
          '                      end;'
          'end.')
      end
      item
        ButtonName = 'BotonSalir'
        Source.Strings = (
          'begin'
          '  close;'
          'end.')
      end
      item
        ButtonName = 'BotonGenerarAsi'
        Source.Strings = (
          'begin'
          '  GenerarAsiento();'
          'end.')
      end>
    Left = 184
    Top = 265
  end
  inherited ImprimirObjetoSeleccionado: TdxComponentPrinter
    Left = 296
    Top = 320
    inherited ImprimirObjetoSeleccionadodxComponentPrinterLink: TdxGridReportLink
      BuiltInReportLink = True
    end
  end
  object TLiquidaciones: TsnTable
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
    Left = 327
    Top = 238
    object TLiquidacionesoid: TIntegerField
      FieldName = 'oid'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TLiquidacionescodigo: TStringField
      FieldName = 'codigo'
      Size = 50
    end
    object TLiquidacionesdescripcion: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
  end
  object DSLiquidaciones: TDataSource
    DataSet = TLiquidaciones
    Left = 360
    Top = 240
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
    Left = 56
    Top = 224
    object TInputoid_liquidacion: TIntegerField
      FieldName = 'oid_liquidacion'
    end
    object TInputfecha: TDateField
      FieldName = 'fecha'
    end
    object TInputnro_liquidacion: TIntegerField
      FieldName = 'nro_liquidacion'
    end
    object TInputoid_cta_banco: TIntegerField
      FieldName = 'oid_cta_banco'
    end
    object TInputtot_mov: TCurrencyField
      FieldName = 'tot_mov'
    end
    object TInputcant_mov: TIntegerField
      FieldName = 'cant_mov'
    end
    object TInputacepto: TBooleanField
      FieldName = 'acepto'
    end
    object TInputtot_gastos: TCurrencyField
      FieldName = 'tot_gastos'
      DisplayFormat = '###,###,###,##0.00'
    end
    object TInputoid_empresa: TIntegerField
      FieldName = 'oid_empresa'
    end
  end
  object DSInput: TDataSource
    DataSet = TInput
    Left = 88
    Top = 224
  end
  object HelpCtasBancarias: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'ctar.CtaBancoLiqTarj'
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
    Titulo = 'CtasBancarias'
    AnchoHelp = 600
    ActivarCache = False
    ShowBotonBuscar = False
    Left = 295
    Top = 278
  end
  object TCtasBancarias: TsnTable
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
    Left = 327
    Top = 278
    object IntegerField1: TIntegerField
      FieldName = 'oid'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object StringField1: TStringField
      FieldName = 'codigo'
      Size = 50
    end
    object StringField2: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
  end
  object DSCtasBancarias: TDataSource
    DataSet = TCtasBancarias
    Left = 360
    Top = 280
  end
  object TDetCupones: TsnTable
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
    Left = 461
    Top = 161
    object TDetCuponesoid_arch_lote_det: TIntegerField
      FieldName = 'oid_arch_lote_det'
    end
    object TDetCuponesoid_arch_lote_cab: TIntegerField
      FieldName = 'oid_arch_lote_cab'
    end
    object TDetCuponesmodo_transmision: TStringField
      FieldName = 'modo_transmision'
      Size = 3
    end
    object TDetCuponestipo_operacion: TStringField
      FieldName = 'tipo_operacion'
      Size = 11
    end
    object TDetCuponesfecha_oper: TStringField
      FieldName = 'fecha_oper'
      Size = 6
    end
    object TDetCuponeshora_oper: TStringField
      FieldName = 'hora_oper'
      Size = 6
    end
    object TDetCuponestipo_tarjeta: TStringField
      FieldName = 'tipo_tarjeta'
      Size = 4
    end
    object TDetCuponestarjeta: TStringField
      FieldName = 'tarjeta'
      Size = 100
    end
    object TDetCuponesnro_tarjeta: TStringField
      FieldName = 'nro_tarjeta'
    end
    object TDetCuponesbanda_manual: TStringField
      FieldName = 'banda_manual'
      Size = 1
    end
    object TDetCuponescod_autoriz: TStringField
      FieldName = 'cod_autoriz'
      Size = 6
    end
    object TDetCuponesticket: TStringField
      FieldName = 'ticket'
      Size = 4
    end
    object TDetCuponesmoneda: TStringField
      FieldName = 'moneda'
      Size = 3
    end
    object TDetCuponesMonto: TFloatField
      FieldName = 'Monto'
    end
    object TDetCuponestipo_cta_deb: TStringField
      FieldName = 'tipo_cta_deb'
      Size = 3
    end
    object TDetCuponesplan_y_cuota: TStringField
      FieldName = 'plan_y_cuota'
      Size = 3
    end
    object TDetCuponescod_comercio: TStringField
      FieldName = 'cod_comercio'
      Size = 15
    end
    object TDetCuponesnro_terminal: TStringField
      FieldName = 'nro_terminal'
      Size = 8
    end
    object TDetCuponesticket_sec: TStringField
      FieldName = 'ticket_sec'
      Size = 4
    end
    object TDetCuponescodigo_lista: TStringField
      FieldName = 'codigo_lista'
      Size = 5
    end
    object TDetCuponesmonto_sec: TFloatField
      FieldName = 'monto_sec'
    end
    object TDetCuponesfecha_sec: TStringField
      FieldName = 'fecha_sec'
      Size = 6
    end
    object TDetCuponesfactura: TStringField
      FieldName = 'factura'
      Size = 16
    end
    object TDetCuponesnro_host: TStringField
      FieldName = 'nro_host'
      Size = 1
    end
    object TDetCuponesactivo: TBooleanField
      FieldName = 'activo'
    end
    object TDetCuponespresentado: TBooleanField
      FieldName = 'presentado'
    end
    object TDetCuponesoid_empresa: TIntegerField
      FieldName = 'oid_empresa'
    end
    object TDetCuponesoid_uni_neg: TIntegerField
      FieldName = 'oid_uni_neg'
    end
    object TDetCuponesfec_oper_date: TDateField
      FieldName = 'fec_oper_date'
    end
    object TDetCuponesfec_cierre: TDateField
      FieldName = 'fec_cierre'
    end
    object TDetCuponesfec_presen_cupon: TDateField
      FieldName = 'fec_presen_cupon'
    end
    object TDetCuponesconciliado: TBooleanField
      FieldName = 'conciliado'
    end
    object TDetCuponesfec_conciliado: TDateField
      FieldName = 'fec_conciliado'
    end
    object TDetCuponesliquidado: TBooleanField
      FieldName = 'liquidado'
    end
    object TDetCuponesfec_liquidado: TDateField
      FieldName = 'fec_liquidado'
    end
    object TDetCuponespreContabilizado: TBooleanField
      FieldName = 'preContabilizado'
    end
    object TDetCuponesfecPreContabilizado: TDateField
      FieldName = 'fecPreContabilizado'
    end
    object TDetCuponescontabilizado: TBooleanField
      FieldName = 'contabilizado'
    end
    object TDetCuponesfecContabilizado: TDateField
      FieldName = 'fecContabilizado'
    end
    object TDetCuponesnro_lote: TIntegerField
      FieldName = 'nro_lote'
    end
    object TDetCuponesagrupador: TStringField
      FieldName = 'agrupador'
      Size = 50
    end
    object TDetCuponesmarcar_preconci: TBooleanField
      DefaultExpression = 'false'
      FieldName = 'marcar_preconci'
    end
    object TDetCuponesult_nros_tarj: TIntegerField
      FieldName = 'ult_nros_tarj'
    end
    object TDetCuponesnro_conciliacion: TIntegerField
      FieldName = 'nro_conciliacion'
    end
    object TDetCuponespre_conci: TBooleanField
      FieldName = 'pre_conci'
    end
    object TDetCuponesfec_preconci: TDateField
      FieldName = 'fec_preconci'
    end
    object TDetCuponesnro_conci_aut: TIntegerField
      FieldName = 'nro_conci_aut'
    end
    object TDetCuponespreconci_dudoso: TStringField
      FieldName = 'preconci_dudoso'
    end
    object TDetCuponesmarca_asi_acob: TBooleanField
      FieldName = 'marca_asi_acob'
    end
    object TDetCuponescupon_perdido: TBooleanField
      FieldName = 'cupon_perdido'
    end
    object TDetCuponesest_asi_cob: TStringField
      FieldName = 'est_asi_cob'
      Size = 100
    end
    object TDetCuponesest_asi_liq: TStringField
      FieldName = 'est_asi_liq'
      Size = 50
    end
    object TDetCuponesoid_cab_asi_acob: TIntegerField
      FieldName = 'oid_cab_asi_acob'
    end
  end
  object DSDetCupones: TDataSource
    DataSet = TDetCupones
    Left = 493
    Top = 161
  end
  object TCabModeloLiq: TsnTable
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
    Left = 614
    Top = 174
    object TCabModeloLiqoid_modelo_liq: TIntegerField
      FieldName = 'oid_modelo_liq'
    end
    object TCabModeloLiqcodigo: TStringField
      FieldName = 'codigo'
    end
    object TCabModeloLiqdescripcion: TStringField
      FieldName = 'descripcion'
      Size = 50
    end
    object TCabModeloLiqactivo: TBooleanField
      FieldName = 'activo'
    end
  end
  object TDetModeloLiq: TsnTable
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
    Left = 614
    Top = 206
    object TDetModeloLiqoid_modelo_det: TIntegerField
      FieldName = 'oid_modelo_det'
    end
    object TDetModeloLiqoid_modelo_liq: TIntegerField
      FieldName = 'oid_modelo_liq'
    end
    object TDetModeloLiqorden: TIntegerField
      FieldName = 'orden'
    end
    object TDetModeloLiqcuenta: TStringField
      FieldName = 'cuenta'
      Size = 50
    end
    object TDetModeloLiqdesc_cuenta: TStringField
      FieldName = 'desc_cuenta'
      Size = 100
    end
    object TDetModeloLiqcompo1: TStringField
      FieldName = 'compo1'
      Size = 50
    end
    object TDetModeloLiqcompo2: TStringField
      FieldName = 'compo2'
      Size = 50
    end
    object TDetModeloLiqdebe: TCurrencyField
      FieldName = 'debe'
      DisplayFormat = '###,###,###,###,###.##'
    end
    object TDetModeloLiqhaber: TCurrencyField
      FieldName = 'haber'
      DisplayFormat = '###,###,###,###,###.##'
    end
    object TDetModeloLiqactivo: TBooleanField
      FieldName = 'activo'
    end
    object TDetModeloLiqcod_impuesto: TStringField
      FieldName = 'cod_impuesto'
      Size = 50
    end
    object TDetModeloLiqporc_imp: TCurrencyField
      FieldName = 'porc_imp'
      DisplayFormat = '###,###,###,###,###.##'
    end
  end
  object TDetalleAsiento: TsnTable
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
    Left = 54
    Top = 310
    object TDetalleAsientoorden: TIntegerField
      FieldName = 'orden'
    end
    object TDetalleAsientocuenta: TStringField
      FieldName = 'cuenta'
      Size = 50
    end
    object TDetalleAsientodesc_cuenta: TStringField
      FieldName = 'desc_cuenta'
      Size = 100
    end
    object TDetalleAsientodebe: TCurrencyField
      FieldName = 'debe'
      DisplayFormat = '###,###,###,###.##'
    end
    object TDetalleAsientohaber: TCurrencyField
      FieldName = 'haber'
      DisplayFormat = '###,###,###,###.##'
    end
    object TDetalleAsientocod_impuesto: TStringField
      FieldName = 'cod_impuesto'
      Size = 50
    end
    object TDetalleAsientocompo1: TStringField
      FieldName = 'compo1'
      Size = 50
    end
    object TDetalleAsientocompo2: TStringField
      FieldName = 'compo2'
      Size = 50
    end
    object TDetalleAsientoporc_imp: TCurrencyField
      FieldName = 'porc_imp'
      DisplayFormat = '###,###,###,###.##'
    end
    object TDetalleAsientocomentario: TStringField
      FieldName = 'comentario'
      Size = 100
    end
    object TDetalleAsientobase: TCurrencyField
      FieldKind = fkCalculated
      FieldName = 'base'
      DisplayFormat = '###,###,###,##0.00'
      Calculated = True
    end
  end
  object DSTDetalleAsiento: TDataSource
    DataSet = TDetalleAsiento
    Left = 86
    Top = 310
  end
  object TGenAsiLiq: TsnTable
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
    Left = 502
    Top = 361
    object TGenAsiLiqnro_liquidacion: TIntegerField
      FieldName = 'nro_liquidacion'
    end
  end
  object Varios: TsnVarios
    Operacion = Operacion
    Left = 582
    Top = 177
  end
  object cxStyleRepository1: TcxStyleRepository
    PixelsPerInch = 96
    object cxStyle1: TcxStyle
      AssignedValues = [svColor]
      Color = clActiveBorder
    end
  end
  object TAsiLiqGenerado: TsnTable
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
    Left = 350
    Top = 377
    object TAsiLiqGeneradoreferencia: TStringField
      FieldName = 'referencia'
      Size = 255
    end
  end
end
