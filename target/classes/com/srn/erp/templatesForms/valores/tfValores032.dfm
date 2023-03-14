inherited FLiquidacionDeTarjetas: TFLiquidacionDeTarjetas
  Left = 107
  Top = 92
  Width = 986
  Height = 627
  Caption = 'Liquidaci'#243'n de Tarjetas'
  PixelsPerInch = 96
  TextHeight = 13
  inherited PForm: TPanel
    Width = 978
    Height = 593
    inherited PPie: TPanel
      Top = 572
      Width = 978
      TabOrder = 4
      inherited StatusBarABM: TStatusBar
        Left = 873
      end
      inherited StatusBar2: TStatusBar
        Width = 873
      end
    end
    inherited PMenu: TPanel
      Width = 978
      TabOrder = 0
      inherited ImagenEliminar: TImagenEstado
        DataField = 'activo'
        DataSource = DSLiquidacionCAB
      end
      inherited ImagenSiguiente: TImagenHelpObjNeg
        Help = HelpLiqTar
      end
      inherited ImagenAnterior: TImagenHelpObjNeg
        Help = HelpLiqTar
      end
      inherited Panel2: TPanel
        Left = 937
      end
      inherited PanelEstadoON: TPanelEstado
        DataField = 'activo'
        DataSource = DSLiquidacionCAB
        Leyendas = <
          item
            Titulo = 'ANULADO'
            ColorTitulo = clWhite
            ValorEstado = 'false'
            Visible = True
            ColorPanel = clRed
          end>
      end
    end
    inherited POpcionesMenu: TPanel
      Width = 978
      TabOrder = 1
    end
    inherited PCabecera: TPanel
      Width = 978
      Height = 242
      TabOrder = 2
      object Label1: TLabel
        Left = 502
        Top = 13
        Width = 57
        Height = 13
        Caption = 'Fec Emisi'#243'n'
      end
      object Label2: TLabel
        Left = 374
        Top = 37
        Width = 39
        Height = 13
        Caption = 'Moneda'
      end
      object Label3: TLabel
        Left = 548
        Top = 37
        Width = 49
        Height = 13
        Caption = 'Cotizaci'#243'n'
      end
      object Label4: TLabel
        Left = 11
        Top = 85
        Width = 53
        Height = 13
        Caption = 'Comentario'
      end
      object Label5: TLabel
        Left = 11
        Top = 13
        Width = 44
        Height = 13
        Caption = 'Talonario'
      end
      object LVerCotizaciones: TsnLabel
        Left = 766
        Top = 60
        Width = 78
        Height = 13
        Cursor = crHandPoint
        Caption = 'Ver cotizaciones'
        Font.Charset = DEFAULT_CHARSET
        Font.Color = clBlue
        Font.Height = -11
        Font.Name = 'MS Sans Serif'
        Font.Style = [fsUnderline]
        ParentFont = False
      end
      object Label6: TLabel
        Left = 692
        Top = 37
        Width = 35
        Height = 13
        Caption = 'Importe'
      end
      object Label7: TLabel
        Left = 279
        Top = 13
        Width = 86
        Height = 13
        Caption = 'Nro. Comprobante'
      end
      object Label8: TLabel
        Left = 670
        Top = 13
        Width = 76
        Height = 13
        Caption = 'Fec. Imputaci'#243'n'
      end
      object Label9: TLabel
        Left = 11
        Top = 37
        Width = 46
        Height = 13
        Caption = 'Concepto'
      end
      object Label10: TLabel
        Left = 75
        Top = 140
        Width = 185
        Height = 13
        Caption = 'Busqueda de Tarjetas a Liquidar'
        Font.Charset = DEFAULT_CHARSET
        Font.Color = clWindowText
        Font.Height = -11
        Font.Name = 'MS Sans Serif'
        Font.Style = [fsBold, fsUnderline]
        ParentFont = False
      end
      object Label11: TLabel
        Left = 80
        Top = 168
        Width = 33
        Height = 13
        Caption = 'Tarjeta'
      end
      object Label12: TLabel
        Left = 12
        Top = 61
        Width = 43
        Height = 13
        Caption = 'Fec. Vto.'
      end
      object Label13: TLabel
        Left = 188
        Top = 61
        Width = 71
        Height = 13
        Caption = 'Liquidaci'#243'n del'
      end
      object Label14: TLabel
        Left = 372
        Top = 61
        Width = 8
        Height = 13
        Caption = 'al'
      end
      object Label15: TLabel
        Left = 340
        Top = 168
        Width = 36
        Height = 13
        Caption = 'Entidad'
      end
      object Label16: TLabel
        Left = 596
        Top = 168
        Width = 21
        Height = 13
        Caption = 'Caja'
      end
      object Label17: TLabel
        Left = 80
        Top = 197
        Width = 55
        Height = 13
        Caption = 'Fec. Desde'
      end
      object Label18: TLabel
        Left = 249
        Top = 196
        Width = 52
        Height = 13
        Caption = 'Fec. Hasta'
      end
      object Label29: TLabel
        Left = 531
        Top = 62
        Width = 21
        Height = 13
        Caption = 'Caja'
      end
      object LabelMarcarDodo: TsnLabel
        Left = 80
        Top = 222
        Width = 57
        Height = 13
        Cursor = crHandPoint
        Caption = 'Marcar todo'
        Font.Charset = DEFAULT_CHARSET
        Font.Color = clBlue
        Font.Height = -11
        Font.Name = 'MS Sans Serif'
        Font.Style = [fsUnderline]
        ParentFont = False
      end
      object LabelDesmarcarTodo: TsnLabel
        Left = 168
        Top = 222
        Width = 75
        Height = 13
        Cursor = crHandPoint
        Caption = 'Desmarcar todo'
        Font.Charset = DEFAULT_CHARSET
        Font.Color = clBlue
        Font.Height = -11
        Font.Name = 'MS Sans Serif'
        Font.Style = [fsUnderline]
        ParentFont = False
      end
      object LabelInvertirSeleccion: TsnLabel
        Left = 267
        Top = 222
        Width = 82
        Height = 13
        Cursor = crHandPoint
        Caption = 'Invertir Selecci'#243'n'
        Font.Charset = DEFAULT_CHARSET
        Font.Color = clBlue
        Font.Height = -11
        Font.Name = 'MS Sans Serif'
        Font.Style = [fsUnderline]
        ParentFont = False
      end
      object DBFechaEmision: TsnDBDateEdit
        Left = 568
        Top = 9
        DataBinding.DataField = 'fecha'
        DataBinding.DataSource = DSLiquidacionCAB
        TabOrder = 2
        ReadOnlyAlways = False
        Width = 94
      end
      object DBMoneda: TsnDBLookup
        Left = 417
        Top = 33
        DataBinding.DataField = 'oid_moneda'
        DataBinding.DataSource = DSLiquidacionCAB
        Properties.KeyFieldNames = 'oid'
        Properties.ListColumns = <
          item
            FieldName = 'descripcion'
          end>
        Properties.ListOptions.ShowHeader = False
        Properties.ListSource = DSMonedas
        TabOrder = 5
        Width = 118
      end
      object DBCotizacion: TsnDBEdit
        Left = 604
        Top = 33
        DataBinding.DataField = 'cotizacion'
        DataBinding.DataSource = DSLiquidacionCAB
        TabOrder = 6
        Width = 70
      end
      object snDBTalonario: TsnDBLookup
        Left = 75
        Top = 9
        DataBinding.DataField = 'oid_talonario'
        DataBinding.DataSource = DSLiquidacionCAB
        Properties.KeyFieldNames = 'oid_talonario'
        Properties.ListColumns = <
          item
            FieldName = 'descripcion'
          end>
        Properties.ListOptions.ShowHeader = False
        Properties.ListSource = DSTalonarios
        TabOrder = 0
        Width = 190
      end
      object DBImporte: TsnDBEdit
        Left = 752
        Top = 33
        DataBinding.DataField = 'importe'
        DataBinding.DataSource = DSLiquidacionCAB
        TabOrder = 7
        Width = 94
      end
      object DBNroComprobante: TsnDBEdit
        Left = 376
        Top = 8
        DataBinding.DataField = 'nro_ext'
        DataBinding.DataSource = DSLiquidacionCAB
        TabOrder = 1
        Width = 113
      end
      object DBFechaImputacion: TsnDBDateEdit
        Left = 752
        Top = 9
        DataBinding.DataField = 'imputacion'
        DataBinding.DataSource = DSLiquidacionCAB
        TabOrder = 3
        ReadOnlyAlways = False
        Width = 94
      end
      object DBConcepto: TsnDBLookup
        Left = 75
        Top = 33
        DataBinding.DataField = 'oid_conc_liq_tc'
        DataBinding.DataSource = DSLiquidacionCAB
        Properties.KeyFieldNames = 'oid_concepto'
        Properties.ListColumns = <
          item
            FieldName = 'desc_concepto'
          end>
        Properties.ListOptions.ShowHeader = False
        Properties.ListSource = DSConcLiqTar
        TabOrder = 4
        Width = 286
      end
      object snDBMemo1: TsnDBMemo
        Left = 75
        Top = 82
        DataBinding.DataField = 'comentario'
        DataBinding.DataSource = DSLiquidacionCAB
        Properties.MaxLength = 255
        TabOrder = 12
        ReadOnlyAlways = False
        Height = 49
        Width = 662
      end
      object BuscarTarjetas: TButton
        Left = 435
        Top = 192
        Width = 113
        Height = 25
        Caption = 'Buscar Tarjetas'
        TabOrder = 18
      end
      object DBTarjeta: TsnDBLookup
        Left = 143
        Top = 165
        DataBinding.DataField = 'oid_tipo_valor'
        DataBinding.DataSource = DSLiquidacionCAB
        Properties.KeyFieldNames = 'oid_tipo_valor'
        Properties.ListColumns = <
          item
            FieldName = 'desc_tipo_valor'
          end>
        Properties.ListOptions.ShowHeader = False
        Properties.ListSource = DSTiposTarjetas
        TabOrder = 13
        Width = 190
      end
      object snDBDateEdit1: TsnDBDateEdit
        Left = 75
        Top = 57
        DataBinding.DataField = 'fec_vto'
        DataBinding.DataSource = DSLiquidacionCAB
        TabOrder = 8
        ReadOnlyAlways = False
        Width = 94
      end
      object snDBDateEdit2: TsnDBDateEdit
        Left = 267
        Top = 57
        DataBinding.DataField = 'fec_desde'
        DataBinding.DataSource = DSLiquidacionCAB
        TabOrder = 9
        ReadOnlyAlways = False
        Width = 94
      end
      object snDBDateEdit3: TsnDBDateEdit
        Left = 395
        Top = 57
        DataBinding.DataField = 'fec_hasta'
        DataBinding.DataSource = DSLiquidacionCAB
        TabOrder = 10
        ReadOnlyAlways = False
        Width = 94
      end
      object DBEntidad: TsnDBLookup
        Left = 383
        Top = 165
        DataBinding.DataField = 'oid_entidad'
        DataBinding.DataSource = DSLiquidacionCAB
        Properties.KeyFieldNames = 'oid_entidad'
        Properties.ListColumns = <
          item
            FieldName = 'desc_entidad'
          end>
        Properties.ListOptions.ShowHeader = False
        Properties.ListSource = DSEntidades
        TabOrder = 14
        Width = 190
      end
      object DBCaja: TsnDBLookup
        Left = 623
        Top = 165
        DataBinding.DataField = 'oid_caja'
        DataBinding.DataSource = DSLiquidacionCAB
        Properties.KeyFieldNames = 'oid_caja'
        Properties.ListColumns = <
          item
            FieldName = 'desc_caja'
          end>
        Properties.ListOptions.ShowHeader = False
        Properties.ListSource = DSCajasOperativas
        TabOrder = 15
        Width = 190
      end
      object snDBDateEdit4: TsnDBDateEdit
        Left = 143
        Top = 193
        DataBinding.DataField = 'busc_fec_desde'
        DataBinding.DataSource = DSLiquidacionCAB
        TabOrder = 16
        ReadOnlyAlways = False
        Width = 94
      end
      object snDBDateEdit5: TsnDBDateEdit
        Left = 312
        Top = 193
        DataBinding.DataField = 'busc_fec_hasta'
        DataBinding.DataSource = DSLiquidacionCAB
        TabOrder = 17
        ReadOnlyAlways = False
        Width = 94
      end
      object snDBCaja: TsnDBLookup
        Left = 567
        Top = 58
        DataBinding.DataField = 'oid_caja_liq'
        DataBinding.DataSource = DSLiquidacionCAB
        Properties.KeyFieldNames = 'oid_caja'
        Properties.ListColumns = <
          item
            FieldName = 'desc_caja'
          end>
        Properties.ListOptions.ShowHeader = False
        Properties.ListSource = DSCajasOperativasLiq
        TabOrder = 11
        Width = 189
      end
    end
    inherited PCuerpo: TPanel
      Top = 294
      Width = 978
      Height = 278
      BorderWidth = 3
      TabOrder = 3
      object Splitter1: TSplitter
        Left = 3
        Top = 3
        Width = 972
        Height = 3
        Cursor = crVSplit
        Align = alTop
      end
      object Panel3: TPanel
        Left = 3
        Top = 6
        Width = 972
        Height = 269
        Align = alClient
        Color = clWindow
        TabOrder = 0
        object PageControl: TPageControlSN
          Left = 1
          Top = 1
          Width = 970
          Height = 267
          ActivePage = PageTarjetaCredito
          Align = alClient
          TabOrder = 0
          object PageTarjetaDebito: TTabSheet
            Caption = 'Tarjetas de D'#233'bito'
            ImageIndex = 1
            object dxDBGridValores: TdxDBGridSN
              Left = 0
              Top = 0
              Width = 962
              Height = 239
              Align = alClient
              TabOrder = 0
              LookAndFeel.Kind = lfFlat
              CriteriosPintarCelda = <>
              object cxGridDBTableView3: TcxGridDBTableView
                NavigatorButtons.ConfirmDelete = False
                DataController.Options = [dcoAssignGroupingValues, dcoAssignMasterDetailKeys, dcoSaveExpanding, dcoInsertOnNewItemRowFocusing]
                DataController.Summary.DefaultGroupSummaryItems = <>
                DataController.Summary.FooterSummaryItems = <
                  item
                    Format = '###,###,###,###,##0.00'
                    Kind = skSum
                    FieldName = 'impo_mon_pago'
                    Column = cxGridDBTableView3Column2
                  end>
                DataController.Summary.SummaryGroups = <>
                OptionsBehavior.AlwaysShowEditor = True
                OptionsBehavior.FocusCellOnTab = True
                OptionsBehavior.FocusFirstCellOnNewRecord = True
                OptionsBehavior.GoToNextCellOnEnter = True
                OptionsBehavior.FocusCellOnCycle = True
                OptionsCustomize.ColumnFiltering = False
                OptionsData.Deleting = False
                OptionsData.DeletingConfirmation = False
                OptionsData.Inserting = False
                OptionsSelection.InvertSelect = False
                OptionsView.CellAutoHeight = True
                OptionsView.Footer = True
                OptionsView.GroupByBox = False
                object cxGridDBTableView3Column1: TcxGridDBColumn
                  Caption = 'Caja'
                  DataBinding.FieldName = 'desc_caja'
                  PropertiesClassName = 'TcxLookupComboBoxProperties'
                  Properties.KeyFieldNames = 'oid_caja'
                  Properties.ListColumns = <
                    item
                      FieldName = 'descripcion'
                    end>
                  Properties.ListOptions.ShowHeader = False
                  HeaderAlignmentHorz = taCenter
                  Width = 135
                end
                object cxColTipoValor: TcxGridDBColumn
                  Caption = 'Tipo de Valor'
                  DataBinding.FieldName = 'cod_tipo_valor'
                  PropertiesClassName = 'TcxButtonEditProperties'
                  Properties.Buttons = <
                    item
                      Default = True
                      Kind = bkEllipsis
                    end>
                  Properties.CharCase = ecUpperCase
                  Properties.ClickKey = 112
                  HeaderAlignmentHorz = taCenter
                  Width = 86
                end
                object cxGridDBTableView1desc_valor: TcxGridDBColumn
                  Caption = 'Desc. Tipo Valor'
                  DataBinding.FieldName = 'desc_tipo_valor'
                  HeaderAlignmentHorz = taCenter
                  Options.Editing = False
                  Options.Focusing = False
                  Width = 200
                end
                object cxGridDBTableView1codigo_entidad: TcxGridDBColumn
                  Caption = 'Importe'
                  DataBinding.FieldName = 'impo_mon_valor'
                  HeaderAlignmentHorz = taCenter
                  Width = 102
                end
                object cxGridDBTableView3Column2: TcxGridDBColumn
                  Caption = 'Importe Moneda Pago'
                  DataBinding.FieldName = 'impo_mon_pago'
                  HeaderAlignmentHorz = taCenter
                  Options.Editing = False
                  Options.Focusing = False
                  Width = 112
                end
              end
              object cxGridLevel3: TcxGridLevel
                GridView = cxGridDBTableView3
              end
            end
          end
          object PageTarjetaCredito: TTabSheet
            Caption = 'Tarjetas de Cr'#233'dito'
            ImageIndex = 1
            object dxDBGridSN1: TdxDBGridSN
              Left = 0
              Top = 0
              Width = 962
              Height = 239
              Align = alClient
              TabOrder = 0
              LookAndFeel.Kind = lfFlat
              CriteriosPintarCelda = <>
              object cxGridDBTableView1: TcxGridDBTableView
                NavigatorButtons.ConfirmDelete = False
                DataController.DataSource = DSValoresALiquidar
                DataController.Options = [dcoAssignGroupingValues, dcoAssignMasterDetailKeys, dcoSaveExpanding, dcoImmediatePost, dcoInsertOnNewItemRowFocusing]
                DataController.Summary.DefaultGroupSummaryItems = <
                  item
                    Format = '###,###,###,###,##0.00'
                    Kind = skSum
                    Position = spFooter
                    Column = cxGridDBTableView1importe
                  end
                  item
                    Format = '###,###,###,###,##0.00'
                    Kind = skSum
                    Column = cxGridDBTableView1importe
                  end
                  item
                    Format = '###,###,###,###,##0.00'
                    Kind = skSum
                    Position = spFooter
                    Column = cxGridDBTableView1Column1
                  end
                  item
                    Format = '###,###,###,###,##0.00'
                    Kind = skSum
                    Column = cxGridDBTableView1Column1
                  end
                  item
                    Format = '###,###,###,###,##0.00'
                    Kind = skSum
                    Position = spFooter
                    Column = cxGridDBTableView1Column4
                  end
                  item
                    Format = '###,###,###,###,##0.00'
                    Column = cxGridDBTableView1Column4
                  end>
                DataController.Summary.FooterSummaryItems = <
                  item
                    Format = '###,###,###,###,##0.00'
                    Kind = skSum
                    FieldName = 'impo_mon_pago'
                  end
                  item
                    Format = '###,###,###,###,##0.00'
                    Kind = skSum
                    Column = cxGridDBTableView1importe
                  end
                  item
                    Format = '###,###,###,###,##0.00'
                    Kind = skSum
                    Column = cxGridDBTableView1Column1
                  end
                  item
                    Format = '###,###,###,###,##0.00'
                    Kind = skSum
                    Column = cxGridDBTableView1Column4
                  end>
                DataController.Summary.SummaryGroups = <>
                OptionsBehavior.AlwaysShowEditor = True
                OptionsBehavior.FocusCellOnTab = True
                OptionsBehavior.FocusFirstCellOnNewRecord = True
                OptionsBehavior.GoToNextCellOnEnter = True
                OptionsBehavior.FocusCellOnCycle = True
                OptionsCustomize.ColumnFiltering = False
                OptionsData.Deleting = False
                OptionsData.DeletingConfirmation = False
                OptionsData.Inserting = False
                OptionsSelection.InvertSelect = False
                OptionsView.CellAutoHeight = True
                OptionsView.Footer = True
                OptionsView.GroupByBox = False
                OptionsView.GroupFooters = gfVisibleWhenExpanded
                OptionsView.GroupSummaryLayout = gslAlignWithColumns
                object cxGridDBTableView1sel: TcxGridDBColumn
                  Caption = 'Sel.'
                  DataBinding.FieldName = 'sel'
                  PropertiesClassName = 'TcxCheckBoxProperties'
                  Properties.ImmediatePost = True
                end
                object cxGridDBTableView1desc_caja: TcxGridDBColumn
                  Caption = 'Caja'
                  DataBinding.FieldName = 'desc_caja'
                  Visible = False
                  GroupIndex = 0
                  Options.Editing = False
                  Width = 209
                end
                object cxGridDBTableView1nro_tarjeta: TcxGridDBColumn
                  Caption = 'Nro. Tarjeta'
                  DataBinding.FieldName = 'nro_tarjeta'
                  HeaderAlignmentHorz = taCenter
                  Options.Editing = False
                  Width = 131
                end
                object cxGridDBTableView1fec_emision: TcxGridDBColumn
                  Caption = 'Fec. Emisi'#243'n'
                  DataBinding.FieldName = 'fec_emision'
                  HeaderAlignmentHorz = taCenter
                  Options.Editing = False
                  Width = 77
                end
                object cxGridDBTableView1fec_vto: TcxGridDBColumn
                  Caption = 'Fec. Vto.'
                  DataBinding.FieldName = 'fec_vto'
                  HeaderAlignmentHorz = taCenter
                  Options.Editing = False
                  Width = 73
                end
                object cxGridDBTableView1importe: TcxGridDBColumn
                  Caption = 'Importe'
                  DataBinding.FieldName = 'importe'
                  HeaderAlignmentHorz = taCenter
                  Options.Editing = False
                  Width = 68
                end
                object cxGridDBTableView1Column4: TcxGridDBColumn
                  Caption = 'Saldo'
                  DataBinding.FieldName = 'saldo'
                  HeaderAlignmentHorz = taCenter
                  HeaderAlignmentVert = vaCenter
                end
                object cxGridDBTableView1Column3: TcxGridDBColumn
                  Caption = 'Moneda'
                  DataBinding.FieldName = 'moneda'
                  HeaderAlignmentHorz = taCenter
                  HeaderAlignmentVert = vaCenter
                  Options.Editing = False
                  Width = 59
                end
                object cxGridDBTableView1nro_lote: TcxGridDBColumn
                  Caption = 'Nro. Lote'
                  DataBinding.FieldName = 'nro_lote'
                  HeaderAlignmentHorz = taCenter
                  Options.Editing = False
                end
                object cxGridDBTableView1cupon: TcxGridDBColumn
                  Caption = 'Cup'#243'n'
                  DataBinding.FieldName = 'cupon'
                  HeaderAlignmentHorz = taCenter
                  Options.Editing = False
                  Width = 57
                end
                object cxGridDBTableView1cuotas: TcxGridDBColumn
                  Caption = 'Cuotas'
                  DataBinding.FieldName = 'cuotas'
                  HeaderAlignmentHorz = taCenter
                  Options.Editing = False
                  Width = 49
                end
                object cxGridDBTableView1cod_autoriz: TcxGridDBColumn
                  Caption = 'C'#243'd. Autoriz.'
                  DataBinding.FieldName = 'cod_autoriz'
                  HeaderAlignmentHorz = taCenter
                  Options.Editing = False
                  Width = 120
                end
                object cxGridDBTableView1Column1: TcxGridDBColumn
                  Caption = 'Liquidado'
                  DataBinding.FieldName = 'importe_liquidado'
                  HeaderAlignmentHorz = taCenter
                  HeaderAlignmentVert = vaCenter
                  Width = 82
                end
                object cxGridDBTableView1Column2: TcxGridDBColumn
                  Caption = 'Nro. Cuota'
                  DataBinding.FieldName = 'nro_cuota'
                  HeaderAlignmentVert = vaCenter
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
  end
  inherited DriverABM: TDriverABM
    OperTraerObjeto = 'TraerLiquidacionTarCab'
    OperGrabarObjeto = 'SaveLiquidacionTarCab'
    CargaDataSets = <
      item
        DataSet = TTalonarios
        TableName = 'TTalonarios'
      end
      item
        DataSet = TTalonarios
        TableName = 'TTalonarios'
      end
      item
        DataSet = TConcLiqTar
        TableName = 'TConcLiqTar'
      end
      item
        DataSet = TTiposTarjetas
        TableName = 'TTiposTarjetas'
      end
      item
        DataSet = TEntidades
        TableName = 'TEntidades'
      end
      item
        DataSet = TCajasOperativas
        TableName = 'TCajasOperativas'
      end
      item
        DataSet = TParamsLiq
        TableName = 'TParamsLiq'
      end
      item
        DataSet = TValoresALiquidar
        TableName = 'TValoresALiquidar'
      end
      item
        DataSet = TLiquidacionCab
        TableName = 'TLiquidacionCab'
      end
      item
      end
      item
        DataSet = TCajasOperativasLiq
        TableName = 'TCajasOperativasLiq'
      end>
    BajaLogica = <
      item
        DataSet = TLiquidacionCab
        ValorBaja = 'false'
        ValorRehabilitacion = 'true'
        TipoBajaRegistro = tblCurrentRecord
        FieldName = 'activo'
      end>
    OperHabilitadas = [toOperNuevo, toOperEliminar, toOperBuscar, toOperNavegacion]
    DataSetCab = TLiquidacionCab
    DataSetDet1 = TValoresALiquidar
    ControlFocoAlta = snDBTalonario
    ControlFocoModif = snDBTalonario
    Top = 25
  end
  inherited Operacion: TOperacion
    Top = 25
  end
  inherited TOpcHabPrograma: TsnTable
    Left = 712
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
    Left = 280
    Top = 136
  end
  inherited DriverEvent: TDriverEvent
    OnChangeField = <
      item
        TableName = 'TLiquidacionCab'
        FieldName = 'fecha'
        Source.Strings = (
          'begin'
          '  CompoCotizaciones.setString('#39'pFecha'#39',Sender.AsString);'
          
            '  CompoCotizaciones.setInteger('#39'pOidTipoCambio'#39',Varios.getParamO' +
            'idObjNeg('#39'TIPO_CAMBIO_REND_FF'#39'));'
          '  CompoCotizaciones.Externalcall('#39'cargarCotizaciones'#39','#39#39');  '
          'end.')
      end
      item
        TableName = 'TLiquidacionCab'
        FieldName = 'oid_moneda'
        Source.Strings = (
          'begin'
          '   TLiquidacionCab.EditRecord;'
          
            '   TLiquidacionCab.FieldName('#39'cotizacion'#39').AsCurrency := getCoti' +
            'zacion(Sender.AsInteger);'
          'end.')
      end
      item
        TableName = 'TLiquidacionCab'
        FieldName = 'oid_talonario'
        Source.Strings = (
          'begin'
          ''
          '  TLiquidacionCab.EditRecord;'
          '  TLiquidacionCab.FieldName('#39'oid_conc_liq_tc'#39').Clear;'
          ''
          '  if (Sender.AsInteger>0)'
          '     then begin '
          ''
          '             operacion.InicioOperacion();'
          '             operacion.setOper('#39'TraerConcLiqTarByTalonario'#39');'
          
            '             operacion.AddAtribute('#39'oid_talonario'#39',IntToStr(Send' +
            'er.AsInteger));'
          '             operacion.execute();'
          ''
          '             TLiquidacionCab.FieldName('#39'compor_tc'#39').AsString :='
          
            '                 TParamsLiq.FieldName('#39'compor_tipo_compro'#39').AsSt' +
            'ring ;'
          ''
          '             end;'
          ''
          'end.')
      end
      item
        TableName = 'TValoresALiquidar'
        FieldName = 'sel'
        Source.Strings = (
          'begin'
          '  if (Sender.AsBoolean = false)'
          '     then begin '
          '             TValoresALiquidar.EditRecord;'
          
            '             TValoresALiquidar.FieldName('#39'importe_liquidado'#39').As' +
            'Currency := 0;'
          '             end'
          '    else  begin'
          '            TValoresALiquidar.EditRecord;'
          
            '            TValoresALiquidar.FieldName('#39'importe_liquidado'#39').AsC' +
            'urrency := getImporteEnMoneda(TValoresALiquidar.FieldName('#39'saldo' +
            #39').AsCurrency,TValoresALiquidar.FieldName('#39'oid_moneda'#39').AsIntege' +
            'r);'
          '            end;'
          'end.')
      end
      item
        TableName = 'TValoresALiquidar'
        FieldName = 'importe_liquidado'
        Source.Strings = (
          'begin'
          ''
          '   if (Sender.AsCurrency>0)'
          '      then begin'
          '              TValoresALiquidar.EditRecord;'
          ''
          
            '                TValoresALiquidar.desHabilitarEventoOnChange('#39'se' +
            'l'#39');'
          '                try'
          
            '                    TValoresALiquidar.FieldName('#39'sel'#39').AsBoolean' +
            ' := True;'
          '                finally'
          
            '                    TValoresALiquidar.HabilitarEventoOnChange('#39's' +
            'el'#39');'
          '                end;'
          ''
          ''
          '               end;'
          ''
          '   TValoresALiquidar.EditRecord;'
          
            '   TValoresALiquidar.FieldName('#39'importe_liquidado_mon_valor'#39').As' +
            'Currency := '
          '          getImporteEnMonedaValor(Sender.AsCurrency,'
          
            '                                              TLiquidacionCab.Fi' +
            'eldName('#39'oid_moneda'#39').AsInteger,'
          
            '                                              TValoresALiquidar.' +
            'FieldName('#39'oid_moneda'#39').AsInteger);                             ' +
            '                '
          ''
          'end.')
      end>
    OnAfterSetOperacion = <
      item
        OperationName = 'SaveLiquidacionTarCab'
        Source.Strings = (
          'begin'
          '  CompoCotizaciones.ExternalCall('#39'TraerDataSetCotizacion'#39','#39#39');'
          
            '  operacion.AddDataSet(CompoCotizaciones.getVarTable('#39'pTCotizaci' +
            'ones'#39').getDataSet);'
          'end.')
      end>
    OnDataChangeDS = <
      item
        DataSourceName = 'DSLiquidacionCAB'
        Source.Strings = (
          'begin'
          '  setPageControl();'
          'end.')
      end>
    OnNuevoRegistro = <
      item
        TableName = 'TLiquidacionCab'
        Source.Strings = (
          'begin'
          '  DataSet.FieldName('#39'oid_caja'#39').AsInteger := -1;'
          '  DataSet.FieldName('#39'activo'#39').AsBoolean := true;'
          '  DataSet.FieldName('#39'fecha'#39').Value:= varios.getFecha();'
          'end.')
      end>
    OnInicializar = <
      item
        Source.Strings = (
          'begin'
          '  TraerTalonariosLiqTar();'
          '  TMonedas.loadFromHelp('#39'HelpMonedas'#39');'
          '  TraerCajasOperativas();'
          'end.')
      end>
    OnAfterTraerObjeto = <
      item
        Source.Strings = (
          'begin'
          '  setPageControl();'
          'end.')
      end>
    OnBeforeBuscar = <
      item
        Source.Strings = (
          'begin'
          '   if (HelpLiqTar.mostrar())'
          '      then begin'
          '              DriverABM.buscarObjetoByOid(HelpLiqTar.getOID());'
          '              end;'
          'end.')
      end>
    OnFormFunction = <
      item
        Source.Strings = (
          'function getCotizacion(OidMoneda : integer) : currency;'
          'begin'
          '   CompoCotizaciones.setInteger('#39'pOidMoneda'#39',OidMoneda);'
          '   CompoCotizaciones.externalCall('#39'getCotizacionMoneda'#39','#39#39');'
          '   result := CompoCotizaciones.getCurrency('#39'pCotizacion'#39');'
          'end;'
          ''
          'function getImporteEnMoneda(Importe   : currency ;'
          
            '                                                OidMoneda : inte' +
            'ger) : currency;'
          'var'
          '  importeEnPesos : currency;'
          '  cotizMoneda    : currency;'
          '  cotizMonFF : currency;'
          '  impoEnMonFF   : currency;'
          'begin'
          '  result := 0;'
          '  if (TLiquidacionCab.FieldName('#39'cotizacion'#39').AsCurrency<>0)'
          '     then begin'
          
            '          CompoCotizaciones.setInteger('#39'pOidMoneda'#39',TLiquidacion' +
            'Cab.FieldName('#39'oid_moneda'#39').AsInteger);'
          
            '          CompoCotizaciones.setCurrency('#39'pCotizacion'#39',TLiquidaci' +
            'onCab.FieldName('#39'cotizacion'#39').AsCurrency);'
          
            '          CompoCotizaciones.externalCall('#39'setCotizacionMoneda'#39','#39 +
            #39');'
          '          end;'
          '  cotizMoneda := getCotizacion(OidMoneda);'
          '  if (cotizMoneda = 0)'
          '     then Exit;'
          '  importeEnPesos := Importe * cotizMoneda;'
          '  // Llevar el Importe a la Moneda de los comprobantes FF'
          
            '  cotizMonFF := getCotizacion(TLiquidacionCab.FieldName('#39'oid_mon' +
            'eda'#39').AsInteger);'
          '  if (cotizMonFF = 0)'
          '     then Exit;'
          
            '  impoEnMonFF := varios.Redondear(importeEnPesos / cotizMonFF,2)' +
            ';'
          '  result := impoEnMonFF;'
          'end;'
          ''
          
            'function getImporteEnMonedaValor(Importe   : currency ; OidMoned' +
            'aLiq : integer ; OidMonedaValor : integer) : currency;'
          'var'
          '  importeEnPesos : currency;'
          '  cotizMoneda    : currency;'
          '  cotizMonFF : currency;'
          '  impoEnMonFF   : currency;'
          'begin'
          '  result := 0;'
          '  if (TLiquidacionCab.FieldName('#39'cotizacion'#39').AsCurrency<>0)'
          '     then begin'
          
            '          CompoCotizaciones.setInteger('#39'pOidMoneda'#39',TLiquidacion' +
            'Cab.FieldName('#39'oid_moneda'#39').AsInteger);'
          
            '          CompoCotizaciones.setCurrency('#39'pCotizacion'#39',TLiquidaci' +
            'onCab.FieldName('#39'cotizacion'#39').AsCurrency);'
          
            '          CompoCotizaciones.externalCall('#39'setCotizacionMoneda'#39','#39 +
            #39');'
          '          end;'
          '  cotizMoneda := getCotizacion(OidMonedaLiq);'
          '  if (cotizMoneda = 0)'
          '     then Exit;'
          '  importeEnPesos := Importe * cotizMoneda;'
          '  // Llevar el Importe a la Moneda de los comprobantes FF'
          '  cotizMonFF := getCotizacion(OidMonedaValor);'
          '  if (cotizMonFF = 0)'
          '     then Exit;'
          
            '  impoEnMonFF := varios.Redondear(importeEnPesos / cotizMonFF,2)' +
            ';'
          '  result := impoEnMonFF;'
          'end;'
          ''
          ''
          ''
          ''
          'procedure TraerTalonariosLiqTar();'
          'begin'
          '  operacion.inicioOperacion;'
          '  operacion.setOper('#39'TraerTalonariosLiquidaciones'#39');'
          '  operacion.execute;'
          'end;'
          ''
          'function getOidMonedaCurLegal() : integer;'
          'begin'
          '   result := Varios.getParamOidObjNeg('#39'MONEDA_CURSO_LEGAL'#39');'
          'end;'
          ''
          'procedure TraerCajasOperativas();'
          'begin'
          ''
          '  operacion.InicioOperacion();'
          '  operacion.setOper('#39'TraerCajasOperativasActivas'#39');'
          '  operacion.execute();'
          ''
          '  TCajasOperativasLiq.LoadDataSet(TCajasOperativas);'
          ''
          '  TCajasOperativas.appendRecord;'
          '  TCajasOperativas.FieldName('#39'oid_caja'#39').AsInteger := -1;'
          '  TCajasOperativas.FieldName('#39'cod_caja'#39').AsString := '#39'0'#39';'
          
            '  TCajasOperativas.FieldName('#39'desc_caja'#39').AsString := '#39'TODAS LAS' +
            ' CAJAS'#39';'
          '  TCajasOperativas.PostRecord;'
          ''
          'end;'
          ''
          'procedure TraerValoresTarjetas();'
          'var'
          '  datasetCotizaciones : TDataSet;'
          'begin'
          ''
          '  if (TLiquidacionCab.FieldName('#39'oid_talonario'#39').AsInteger<=0)'
          
            '      then raiseException(erCustomError,'#39'Debe ingresar el Talona' +
            'rio'#39');'
          '  if (TLiquidacionCab.FieldName('#39'oid_tipo_valor'#39').AsInteger<=0)'
          
            '      then raiseException(erCustomError,'#39'Debe ingresar la Tarjet' +
            'a'#39');'
          '  if (TLiquidacionCab.FieldName('#39'oid_entidad'#39').AsInteger<=0)'
          
            '      then raiseException(erCustomError,'#39'Debe ingresar la Entida' +
            'd'#39');'
          '  if (TLiquidacionCab.FieldName('#39'oid_moneda'#39').AsInteger<=0)'
          
            '      then raiseException(erCustomError,'#39'Debe Seleccionar la Mon' +
            'eda'#39');'
          '  if (TLiquidacionCab.FieldName('#39'cotizacion'#39').AsCurrency<=0)'
          
            '      then raiseException(erCustomError,'#39'Debe Seleccionar la Cot' +
            'izaci'#243'n'#39');'
          ''
          ''
          '  CompoCotizaciones.ExternalCall('#39'TraerDataSetCotizacion'#39','#39#39');'
          
            '  datasetCotizaciones := CompoCotizaciones.getVarTable('#39'pTCotiza' +
            'ciones'#39').getDataSet;'
          ''
          '  operacion.inicioOperacion;'
          '  operacion.setOper('#39'TraerValoresTarjetasALiq'#39');'
          ''
          
            '  operacion.addAtribute('#39'oid_liqui_tar'#39',TLiquidacionCab.FieldNam' +
            'e('#39'oid_liqui_tar'#39').AsString);'
          
            '  operacion.addAtribute('#39'oid_talonario'#39',TLiquidacionCab.FieldNam' +
            'e('#39'oid_talonario'#39').AsString);'
          
            '  operacion.addAtribute('#39'oid_tipo_valor'#39',TLiquidacionCab.FieldNa' +
            'me('#39'oid_tipo_valor'#39').AsString);'
          
            '  operacion.addAtribute('#39'oid_entidad'#39',TLiquidacionCab.FieldName(' +
            #39'oid_entidad'#39').AsString);'
          
            '  operacion.addAtribute('#39'oid_moneda'#39',TLiquidacionCab.FieldName('#39 +
            'oid_moneda'#39').AsString);'
          
            '  operacion.addAtribute('#39'cotizacion'#39',TLiquidacionCab.FieldName('#39 +
            'cotizacion'#39').AsString);'
          ''
          '  if (TLiquidacionCab.FieldName('#39'oid_caja'#39').AsInteger>0)'
          
            '      then operacion.addAtribute('#39'oid_caja'#39',TLiquidacionCab.Fiel' +
            'dName('#39'oid_caja'#39').AsString);'
          '  if (not TLiquidacionCab.FieldName('#39'busc_fec_desde'#39').IsNull)'
          
            '     then operacion.addAtribute('#39'busc_fec_desde'#39',TLiquidacionCab' +
            '.FieldName('#39'busc_fec_desde'#39').AsString);'
          '  if (not TLiquidacionCab.FieldName('#39'busc_fec_hasta'#39').IsNull)'
          
            '     then operacion.addAtribute('#39'busc_fec_hasta'#39',TLiquidacionCab' +
            '.FieldName('#39'busc_fec_hasta'#39').AsString);'
          ''
          
            '  operacion.AddDataSetByName(datasetCotizaciones,'#39'TCotizaciones'#39 +
            ');'
          ''
          '  operacion.execute;'
          ''
          'end;'
          ''
          'procedure setPageControl();'
          'begin'
          ''
          '  if (TLiquidacionCab.FieldName('#39'compor_tc'#39').AsString = '#39'LIQTC'#39')'
          '      then begin'
          '           PageControl.setTabVisible('#39'PageTarjetaDebito'#39',false);'
          '           PageControl.setTabVisible('#39'PageTarjetaCredito'#39',true);'
          '           PageControl.setActivePageName('#39'PageTarjetaCredito'#39');'
          '           end'
          
            '      else if (TLiquidacionCab.FieldName('#39'compor_tc'#39').AsString =' +
            ' '#39'LIQTD'#39')'
          '              then begin'
          
            '                   PageControl.setTabVisible('#39'PageTarjetaCredito' +
            #39',false);'
          
            '                   PageControl.setTabVisible('#39'PageTarjetaDebito'#39 +
            ',true);'
          
            '                   PageControl.setActivePageName('#39'PageTarjetaDeb' +
            'ito'#39');'
          '                   end'
          '              else begin'
          
            '                   PageControl.setTabVisible('#39'PageTarjetaCredito' +
            #39',false);'
          
            '                   PageControl.setTabVisible('#39'PageTarjetaDebito'#39 +
            ',false);'
          '                   end;'
          ''
          'end;'
          ''
          'procedure InvertirSeleccion();'
          'begin'
          ''
          '   if (not driverABM.isNuevo) then exit;'
          '  '
          '  TValoresALiquidar.deshabilitarControles;'
          ''
          '   try'
          ''
          '  TValoresALiquidar.first;'
          '  while (not TValoresALiquidar.EOF) do'
          '  begin'
          ''
          
            '             if (TValoresALiquidar.FieldName('#39'sel'#39').AsBoolean = ' +
            'false)'
          '                then begin'
          '                        TValoresALiquidar.EditRecord;'
          
            '                        TValoresALiquidar.FieldName('#39'sel'#39').AsBoo' +
            'lean := True;'
          '                        TValoresALiquidar.PostRecord;'
          '                        end'
          '                else begin'
          '                        TValoresALiquidar.EditRecord;'
          
            '                        TValoresALiquidar.FieldName('#39'sel'#39').AsBoo' +
            'lean := False;'
          '                        TValoresALiquidar.PostRecord;'
          '                       end;'
          ''
          '    TValoresALiquidar.next;'
          '  end;'
          ''
          ''
          '  finally'
          ''
          '  TValoresALiquidar.habilitarControles;'
          ''
          '  end;'
          ''
          '  TValoresALiquidar.First;'
          '  mensaje.information('#39'Operaci'#243'n Finalizada'#39');'
          ''
          'end;'
          ''
          ''
          ''
          ''
          'procedure MarcarTodo();'
          'begin'
          ''
          '   if (not driverABM.isNuevo) then exit;'
          '  '
          '  TValoresALiquidar.deshabilitarControles;'
          ''
          '   try'
          ''
          '  TValoresALiquidar.first;'
          '  while (not TValoresALiquidar.EOF) do'
          '  begin'
          ''
          '             TValoresALiquidar.EditRecord;'
          
            '             TValoresALiquidar.FieldName('#39'sel'#39').AsBoolean := Tru' +
            'e;'
          '             TValoresALiquidar.PostRecord;'
          ''
          '    TValoresALiquidar.next;'
          '  end;'
          ''
          ''
          '  finally'
          ''
          '  TValoresALiquidar.habilitarControles;'
          ''
          '  end;'
          ''
          '  TValoresALiquidar.First;'
          '  mensaje.information('#39'Operaci'#243'n Finalizada'#39');'
          'end;'
          ''
          'procedure DesmarcarTodo();'
          'begin'
          ''
          '   if (not driverABM.isNuevo) then exit;'
          '  '
          '  TValoresALiquidar.deshabilitarControles;'
          ''
          '   try'
          ''
          '  TValoresALiquidar.first;'
          '  while (not TValoresALiquidar.EOF) do'
          '  begin'
          ''
          '             TValoresALiquidar.EditRecord;'
          
            '             TValoresALiquidar.FieldName('#39'sel'#39').AsBoolean := Fal' +
            'se;'
          '             TValoresALiquidar.PostRecord;'
          ''
          '    TValoresALiquidar.next;'
          '  end;'
          ''
          ''
          '  finally'
          ''
          '  TValoresALiquidar.habilitarControles;'
          ''
          '  end;'
          ''
          '  TValoresALiquidar.First;'
          '  mensaje.information('#39'Operaci'#243'n Finalizada'#39');'
          'end;'
          '')
      end>
    OnBeforeGrabar = <
      item
        Source.Strings = (
          'begin'
          'end.')
      end>
    OnBeforeNuevo = <
      item
        Source.Strings = (
          'begin'
          'end.')
      end>
    OnAfterNuevo = <
      item
        Source.Strings = (
          'begin'
          '  TraerTalonariosLiqTar();'
          '  TMonedas.loadFromHelp('#39'HelpMonedas'#39');'
          '  TraerCajasOperativas();'
          'end.')
      end>
    OnAfterGrabar = <
      item
        Source.Strings = (
          'begin  '
          '  if (not TInfoComprobante.isEmpty())'
          '     then begin'
          
            '             FormularioComproGenerado.setTable('#39'dsComproGenerado' +
            's'#39',TInfoComprobante);'
          '             FormularioComproGenerado.ShowModal();'
          '             end;'
          'end.')
      end>
    OnClickToolButton = <
      item
        ButtonName = 'LVerCotizaciones'
        Source.Strings = (
          'begin'
          '  if (not driverabm.isNuevo) then exit;'
          '  CompoCotizaciones.Externalcall('#39'mostrar'#39','#39#39');'
          'end.')
      end
      item
        ButtonName = 'BuscarTarjetas'
        Source.Strings = (
          'begin'
          '  TraerValoresTarjetas();'
          '  TValoresALiquidar.marcarRegistrosComoModificados();'
          '  dxDBGridSN1.fullCollapse;'
          '  dxDBGridValores.fullCollapse;'
          '  TValoresALiquidar.first;'
          'end.')
      end
      item
        ButtonName = 'LabelMarcarDodo'
        Source.Strings = (
          'begin'
          '  MarcarTodo();'
          'end.')
      end
      item
        ButtonName = 'LabelDesmarcarTodo'
        Source.Strings = (
          'begin'
          '  DesmarcarTodo();'
          'end.')
      end
      item
        ButtonName = 'LabelInvertirSeleccion'
        Source.Strings = (
          'begin'
          '  InvertirSeleccion();'
          'end.')
      end>
    Left = 248
    Top = 139
  end
  inherited SaveArchivo: TSaveDialog
    Left = 584
    Top = 160
  end
  inherited ImprimirObjetoSeleccionado: TdxComponentPrinter
    Left = 240
    Top = 216
    inherited ImprimirObjetoSeleccionadodxComponentPrinterLink: TdxGridReportLink
      BuiltInReportLink = True
    end
  end
  inherited TTempVarForm: TsnTable
    Left = 440
    Top = 456
  end
  inherited PopUp: TsnPopUp
    Top = 25
  end
  inherited ImageListGruposPopUp: TImageList
    Left = 848
    Top = 203
  end
  inherited ImageListItemsPopUp: TImageList
    Left = 880
    Top = 203
  end
  inherited TPathHelp: TsnTable
    Left = 400
    Top = 453
  end
  object TLiquidacionCab: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'oid_liqui_tar'
        DataType = ftInteger
      end
      item
        Name = 'oid_talonario'
        DataType = ftInteger
      end
      item
        Name = 'fecha'
        DataType = ftDate
      end
      item
        Name = 'oid_moneda'
        DataType = ftInteger
      end
      item
        Name = 'cotizacion'
        DataType = ftCurrency
      end
      item
        Name = 'activo'
        DataType = ftBoolean
      end
      item
        Name = 'importe'
        DataType = ftCurrency
      end
      item
        Name = 'nro_ext'
        DataType = ftInteger
      end
      item
        Name = 'imputacion'
        DataType = ftDate
      end
      item
        Name = 'oid_conc_liq_tc'
        DataType = ftInteger
      end
      item
        Name = 'comentario'
        DataType = ftString
        Size = 255
      end
      item
        Name = 'fec_vto'
        DataType = ftDate
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
        Name = 'oid_tipo_valor'
        DataType = ftInteger
      end
      item
        Name = 'oid_entidad'
        DataType = ftInteger
      end
      item
        Name = 'oid_caja'
        DataType = ftInteger
      end
      item
        Name = 'busc_fec_desde'
        DataType = ftDate
      end
      item
        Name = 'busc_fec_hasta'
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
    Left = 852
    Top = 118
    object TLiquidacionCaboid_liqui_tar: TIntegerField
      FieldName = 'oid_liqui_tar'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TLiquidacionCaboid_talonario: TIntegerField
      FieldName = 'oid_talonario'
    end
    object TLiquidacionCabfecha: TDateField
      FieldName = 'fecha'
    end
    object TLiquidacionCaboid_moneda: TIntegerField
      FieldName = 'oid_moneda'
    end
    object TLiquidacionCabcotizacion: TCurrencyField
      FieldName = 'cotizacion'
      DisplayFormat = '###,###,###,###,##0.00'
    end
    object TLiquidacionCabactivo: TBooleanField
      FieldName = 'activo'
    end
    object TLiquidacionCabimporte: TCurrencyField
      FieldName = 'importe'
    end
    object TLiquidacionCabnro_ext: TIntegerField
      FieldName = 'nro_ext'
    end
    object TLiquidacionCabimputacion: TDateField
      FieldName = 'imputacion'
    end
    object TLiquidacionCaboid_conc_liq_tc: TIntegerField
      FieldName = 'oid_conc_liq_tc'
    end
    object TLiquidacionCabcomentario: TStringField
      FieldName = 'comentario'
      Size = 255
    end
    object TLiquidacionCabfec_vto: TDateField
      FieldName = 'fec_vto'
    end
    object TLiquidacionCabfec_desde: TDateField
      FieldName = 'fec_desde'
    end
    object TLiquidacionCabfec_hasta: TDateField
      FieldName = 'fec_hasta'
    end
    object TLiquidacionCaboid_tipo_valor: TIntegerField
      FieldName = 'oid_tipo_valor'
    end
    object TLiquidacionCaboid_entidad: TIntegerField
      FieldName = 'oid_entidad'
    end
    object TLiquidacionCaboid_caja: TIntegerField
      FieldName = 'oid_caja'
    end
    object TLiquidacionCabbusc_fec_desde: TDateField
      FieldName = 'busc_fec_desde'
    end
    object TLiquidacionCabbusc_fec_hasta: TDateField
      FieldName = 'busc_fec_hasta'
    end
    object TLiquidacionCabcompor_tc: TStringField
      FieldName = 'compor_tc'
      Size = 50
    end
    object TLiquidacionCaboid_caja_liq: TIntegerField
      FieldName = 'oid_caja_liq'
    end
  end
  object DSLiquidacionCAB: TDataSource
    DataSet = TLiquidacionCab
    Left = 884
    Top = 118
  end
  object TTalonarios: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'oid_talonario'
        DataType = ftInteger
      end
      item
        Name = 'codigo'
        DataType = ftString
        Size = 30
      end
      item
        Name = 'descripcion'
        DataType = ftString
        Size = 50
      end
      item
        Name = 'tipo_imp_asoc'
        DataType = ftString
        Size = 15
      end
      item
        Name = 'oid_imp_fiscal'
        DataType = ftInteger
      end
      item
        Name = 'oid_imp_comun'
        DataType = ftInteger
      end
      item
        Name = 'oid_tc'
        DataType = ftInteger
      end
      item
        Name = 'letra'
        DataType = ftString
        Size = 1
      end
      item
        Name = 'oid_lug_emi'
        DataType = ftInteger
      end
      item
        Name = 'nom_arch_imp'
        DataType = ftString
        Size = 100
      end
      item
        Name = 'primer_nro'
        DataType = ftInteger
      end
      item
        Name = 'nro_actual'
        DataType = ftInteger
      end
      item
        Name = 'ultimo_nro'
        DataType = ftInteger
      end
      item
        Name = 'nro_automatica'
        DataType = ftBoolean
      end
      item
        Name = 'fec_vto'
        DataType = ftDate
      end
      item
        Name = 'cai'
        DataType = ftString
        Size = 100
      end
      item
        Name = 'oid_uni_org'
        DataType = ftInteger
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
    Left = 856
    Top = 247
    object TTalonariosoid_talonario: TIntegerField
      FieldName = 'oid_talonario'
    end
    object TTalonarioscodigo: TStringField
      FieldName = 'codigo'
      Size = 30
    end
    object TTalonariosdescripcion: TStringField
      FieldName = 'descripcion'
      Size = 50
    end
    object TTalonariostipo_imp_asoc: TStringField
      FieldName = 'tipo_imp_asoc'
      Size = 15
    end
    object TTalonariosoid_imp_fiscal: TIntegerField
      FieldName = 'oid_imp_fiscal'
    end
    object TTalonariosoid_imp_comun: TIntegerField
      FieldName = 'oid_imp_comun'
    end
    object TTalonariosoid_tc: TIntegerField
      FieldName = 'oid_tc'
    end
    object TTalonarioscod_tc: TStringField
      FieldName = 'cod_tc'
      Size = 30
    end
    object TTalonariosletra: TStringField
      FieldName = 'letra'
      Size = 1
    end
    object TTalonariosoid_lug_emi: TIntegerField
      FieldName = 'oid_lug_emi'
    end
    object TTalonariosnro_lug_emi: TIntegerField
      FieldName = 'nro_lug_emi'
    end
    object TTalonariosnom_arch_imp: TStringField
      FieldName = 'nom_arch_imp'
      Size = 100
    end
    object TTalonariosprimer_nro: TIntegerField
      FieldName = 'primer_nro'
    end
    object TTalonariosnro_actual: TIntegerField
      FieldName = 'nro_actual'
    end
    object TTalonariosultimo_nro: TIntegerField
      FieldName = 'ultimo_nro'
    end
    object TTalonariosnro_automatica: TBooleanField
      FieldName = 'nro_automatica'
    end
    object TTalonariosfec_vto: TDateField
      FieldName = 'fec_vto'
    end
    object TTalonarioscai: TStringField
      FieldName = 'cai'
      Size = 100
    end
    object TTalonariosoid_uni_org: TIntegerField
      FieldName = 'oid_uni_org'
    end
    object TTalonariosactivo: TBooleanField
      FieldName = 'activo'
    end
  end
  object DSTalonarios: TDataSource
    DataSet = TTalonarios
    Left = 888
    Top = 247
  end
  object Varios: TsnVarios
    Operacion = Operacion
    Left = 296
    Top = 451
  end
  object cxEditRepository1: TcxEditRepository
    Left = 368
    Top = 36
    object cxEditRepository1LookupComboBoxItem1: TcxEditRepositoryLookupComboBoxItem
      Properties.ListColumns = <>
    end
    object cxEditRepository1ButtonItem1: TcxEditRepositoryButtonItem
      Properties.Buttons = <
        item
          Default = True
          Kind = bkEllipsis
        end>
      Properties.ClickKey = 112
    end
    object cxEditRepository1TextItem1: TcxEditRepositoryTextItem
      Properties.CharCase = ecUpperCase
    end
    object cxEditRepository1CurrencyItem1: TcxEditRepositoryCurrencyItem
    end
    object cxEditRepository1CurrencyItem2: TcxEditRepositoryCurrencyItem
    end
    object cxEditRepository1CurrencyItem3: TcxEditRepositoryCurrencyItem
    end
    object cxEditRepository1CurrencyItem4: TcxEditRepositoryCurrencyItem
    end
    object cxEditRepository1CurrencyItem5: TcxEditRepositoryCurrencyItem
    end
    object cxEditRepository1ButtonImpuFactProv: TcxEditRepositoryButtonItem
      Properties.Buttons = <
        item
          Default = True
          Kind = bkEllipsis
        end>
    end
    object cxButtonAnaImp: TcxEditRepositoryButtonItem
      Properties.Buttons = <
        item
          Default = True
          Kind = bkEllipsis
        end>
      Properties.ClickKey = 112
    end
    object cxEditRepository1LookupComboBoxItem2: TcxEditRepositoryLookupComboBoxItem
      Properties.ListColumns = <>
      Properties.ListOptions.ShowHeader = False
    end
  end
  object ValidadorCaja: TValidador
    Operacion = Operacion
    NickNameObjLog = 'te.Caja'
    MensajeException = 'Cuenta Bancaria Inexistente'
    NroQuery = 0
    Cache = False
    Left = 325
    Top = 597
  end
  object TValidadorCuentasBancarias: TValidador
    Operacion = Operacion
    NickNameObjLog = 'te.CuentaBancaria'
    TipoBusqueda = tbvByCustom
    MensajeException = 'Cuenta Bancaria Inexistente'
    NroQuery = 101
    Cache = False
    Left = 361
    Top = 598
  end
  object CompoCotizaciones: TCustomCompo
    CustomFormName = 'TFCompoCotizacion'
    Left = 264
    Top = 450
  end
  object HelpLiqTar: TCustomHelp
    Acepto = False
    Oid = 0
    HelpName = 'TFHelpLiqTar'
    CacheForm = False
    Left = 16
    Top = 48
  end
  object FormularioComproGenerado: TFormulario
    Nombre = 'TFIdentificacionCompro'
    CreateAlwaysANewForm = False
    Left = 328
    Top = 451
  end
  object TInfoComprobante: TsnTable
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
    Left = 361
    Top = 453
    object TInfoComprobanteoid_cco: TIntegerField
      FieldName = 'oid_cco'
    end
    object TInfoComprobantedesc_comprobante: TStringField
      FieldName = 'desc_comprobante'
      Size = 100
    end
  end
  object cxStyleRepository1: TcxStyleRepository
    PixelsPerInch = 96
    object cxStyle1: TcxStyle
      AssignedValues = [svColor]
      Color = 16760767
    end
  end
  object TConcLiqTar: TsnTable
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
    Left = 192
    Top = 365
    object TConcLiqTaroid_concepto: TIntegerField
      FieldName = 'oid_concepto'
    end
    object TConcLiqTarcod_concepto: TStringField
      FieldName = 'cod_concepto'
      Size = 50
    end
    object TConcLiqTardesc_concepto: TStringField
      FieldName = 'desc_concepto'
      Size = 100
    end
  end
  object DSConcLiqTar: TDataSource
    DataSet = TConcLiqTar
    Left = 232
    Top = 365
  end
  object HelpMonedas: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'ge.Moneda'
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
    Titulo = 'Monedas'
    AnchoHelp = 600
    ActivarCache = False
    ShowBotonBuscar = False
    Left = 615
    Top = 254
  end
  object TMonedas: TsnTable
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
    Left = 647
    Top = 254
    object TMonedasoid: TIntegerField
      FieldName = 'oid'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TMonedascodigo: TStringField
      FieldName = 'codigo'
      Size = 50
    end
    object TMonedasdescripcion: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
  end
  object DSMonedas: TDataSource
    DataSet = TMonedas
    Left = 682
    Top = 252
  end
  object TTiposTarjetas: TsnTable
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
    Left = 824
    Top = 339
    object TTiposTarjetasoid_tipo_valor: TIntegerField
      FieldName = 'oid_tipo_valor'
    end
    object TTiposTarjetascod_tipo_valor: TStringField
      FieldName = 'cod_tipo_valor'
      Size = 50
    end
    object TTiposTarjetasdesc_tipo_valor: TStringField
      FieldName = 'desc_tipo_valor'
      Size = 100
    end
  end
  object DSTiposTarjetas: TDataSource
    DataSet = TTiposTarjetas
    Left = 864
    Top = 339
  end
  object TEntidades: TsnTable
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
    Left = 824
    Top = 383
    object TEntidadesoid_entidad: TIntegerField
      FieldName = 'oid_entidad'
    end
    object TEntidadescod_entidad: TStringField
      FieldName = 'cod_entidad'
      Size = 50
    end
    object TEntidadesdesc_entidad: TStringField
      FieldName = 'desc_entidad'
      Size = 100
    end
  end
  object DSEntidades: TDataSource
    DataSet = TEntidades
    Left = 864
    Top = 383
  end
  object TCajasOperativas: TsnTable
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
    Left = 512
    Top = 379
    object TCajasOperativasoid_caja: TIntegerField
      FieldName = 'oid_caja'
    end
    object TCajasOperativascod_caja: TStringField
      FieldName = 'cod_caja'
      Size = 50
    end
    object TCajasOperativasdesc_caja: TStringField
      FieldName = 'desc_caja'
      Size = 100
    end
  end
  object DSCajasOperativas: TDataSource
    DataSet = TCajasOperativas
    Left = 552
    Top = 379
  end
  object TValoresALiquidar: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'sel'
        DataType = ftBoolean
      end
      item
        Name = 'oid_valor'
        DataType = ftInteger
      end
      item
        Name = 'oid_liquidar_tar'
        DataType = ftInteger
      end
      item
        Name = 'oid_caja'
        DataType = ftInteger
      end
      item
        Name = 'desc_caja'
        DataType = ftString
        Size = 50
      end
      item
        Name = 'nro_tarjeta'
        DataType = ftString
        Size = 50
      end
      item
        Name = 'fec_emision'
        DataType = ftDate
      end
      item
        Name = 'fec_vto'
        DataType = ftDate
      end
      item
        Name = 'importe'
        DataType = ftCurrency
      end
      item
        Name = 'nro_lote'
        DataType = ftInteger
      end
      item
        Name = 'cupon'
        DataType = ftInteger
      end
      item
        Name = 'cuotas'
        DataType = ftInteger
      end
      item
        Name = 'cod_autoriz'
        DataType = ftString
        Size = 50
      end>
    IndexFieldNames = 'oid_liquidar_tar'
    IndexDefs = <
      item
        Name = 'TValoresALiquidarIndex1'
        Fields = 'oid_liquidar_tar'
      end>
    RecalcOnFetch = False
    SortOptions = []
    PersistentBackup = False
    ProgressFlags = [mtpcLoad, mtpcSave, mtpcCopy]
    VersioningMode = mtvmAllSinceCheckPoint
    FilterOptions = []
    MasterFields = 'oid_liqui_tar'
    MasterSource = DSLiquidacionCAB
    Version = '4.08b'
    LanguageID = 0
    SortID = 0
    SubLanguageID = 1
    LocaleID = 1024
    MensajeValorDuplicadoIndice = 'Valor Duplicado'
    Left = 852
    Top = 154
    object TValoresALiquidarsel: TBooleanField
      FieldName = 'sel'
    end
    object TValoresALiquidaroid_valor: TIntegerField
      FieldName = 'oid_valor'
    end
    object TValoresALiquidaroid_liquidar_tar: TIntegerField
      FieldName = 'oid_liquidar_tar'
    end
    object TValoresALiquidaroid_caja: TIntegerField
      FieldName = 'oid_caja'
    end
    object TValoresALiquidardesc_caja: TStringField
      FieldName = 'desc_caja'
      Size = 50
    end
    object TValoresALiquidarnro_tarjeta: TStringField
      FieldName = 'nro_tarjeta'
      Size = 50
    end
    object TValoresALiquidarfec_emision: TDateField
      FieldName = 'fec_emision'
    end
    object TValoresALiquidarfec_vto: TDateField
      FieldName = 'fec_vto'
    end
    object TValoresALiquidarimporte: TCurrencyField
      FieldName = 'importe'
      DisplayFormat = '###,###,###,###,##0.00'
    end
    object TValoresALiquidarnro_lote: TIntegerField
      FieldName = 'nro_lote'
    end
    object TValoresALiquidarcupon: TIntegerField
      FieldName = 'cupon'
    end
    object TValoresALiquidarcuotas: TIntegerField
      FieldName = 'cuotas'
    end
    object TValoresALiquidarcod_autoriz: TStringField
      FieldName = 'cod_autoriz'
      Size = 50
    end
    object TValoresALiquidarimporte_liquidado: TCurrencyField
      FieldName = 'importe_liquidado'
      DisplayFormat = '###,###,###,###,##0.00'
    end
    object TValoresALiquidaroid_det: TIntegerField
      FieldName = 'oid_det'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TValoresALiquidarnro_cuota: TIntegerField
      FieldName = 'nro_cuota'
    end
    object TValoresALiquidarmoneda: TStringField
      FieldName = 'moneda'
    end
    object TValoresALiquidarimporte_liquidado_mon_valor: TCurrencyField
      FieldName = 'importe_liquidado_mon_valor'
    end
    object TValoresALiquidaroid_moneda: TIntegerField
      FieldName = 'oid_moneda'
    end
    object TValoresALiquidarsaldo: TCurrencyField
      FieldName = 'saldo'
      DisplayFormat = '###,###,###,###,##0.00'
    end
  end
  object DSValoresALiquidar: TDataSource
    DataSet = TValoresALiquidar
    Left = 888
    Top = 156
  end
  object TParamsLiq: TsnTable
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
    Left = 312
    Top = 347
    object TParamsLiqcompor_tipo_compro: TStringField
      FieldName = 'compor_tipo_compro'
      Size = 50
    end
  end
  object TCajasOperativasLiq: TsnTable
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
    Left = 512
    Top = 420
    object IntegerField1: TIntegerField
      FieldName = 'oid_caja'
    end
    object StringField1: TStringField
      FieldName = 'cod_caja'
      Size = 50
    end
    object StringField2: TStringField
      FieldName = 'desc_caja'
      Size = 100
    end
  end
  object DSCajasOperativasLiq: TDataSource
    DataSet = TCajasOperativasLiq
    Left = 552
    Top = 422
  end
end
