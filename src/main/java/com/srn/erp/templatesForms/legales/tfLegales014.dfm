inherited FSeguiLega: TFSeguiLega
  Left = 39
  Top = 183
  Width = 1068
  Height = 661
  Caption = 'Seguimientos Legales'
  PixelsPerInch = 96
  TextHeight = 13
  object Panel1: TPanel [0]
    Left = 0
    Top = 0
    Width = 1052
    Height = 41
    Align = alTop
    Color = clWindow
    TabOrder = 0
    object Label1: TLabel
      Left = 22
      Top = 10
      Width = 180
      Height = 18
      Caption = 'Seguimiento Legales'
      Font.Charset = ANSI_CHARSET
      Font.Color = clWindowText
      Font.Height = -16
      Font.Name = 'Verdana'
      Font.Style = [fsBold]
      ParentFont = False
    end
    object ImageSalir: TImage
      Tag = 7
      Left = 230
      Top = 3
      Width = 32
      Height = 32
      Cursor = crHandPoint
      Hint = 'Salir'
      ParentShowHint = False
      ShowHint = True
    end
  end
  object Panel2: TPanel [1]
    Left = 0
    Top = 41
    Width = 1052
    Height = 582
    Align = alClient
    Color = clWindow
    TabOrder = 1
    object dxGrillaSECLOS: TdxDBGridSN
      Left = 1
      Top = 1
      Width = 1050
      Height = 580
      Align = alClient
      TabOrder = 0
      LookAndFeel.Kind = lfFlat
      AllowInsert = False
      CriteriosPintarCelda = <>
      object dxGrillaSECLOSDBTableViewRequisiciones: TcxGridDBTableView
        NavigatorButtons.ConfirmDelete = False
        FilterBox.Visible = fvAlways
        DataController.Filter.Active = True
        DataController.Filter.AutoDataSetFilter = True
        DataController.Summary.DefaultGroupSummaryItems = <>
        DataController.Summary.FooterSummaryItems = <>
        DataController.Summary.SummaryGroups = <>
        OptionsBehavior.GoToNextCellOnEnter = True
        OptionsBehavior.IncSearch = True
        OptionsCustomize.ColumnsQuickCustomization = True
        OptionsData.CancelOnExit = False
        OptionsData.Deleting = False
        OptionsData.DeletingConfirmation = False
        OptionsData.Inserting = False
        OptionsView.CellAutoHeight = True
      end
      object dxGrillaSECLOSBandedTableView1: TcxGridBandedTableView
        NavigatorButtons.ConfirmDelete = False
        DataController.Summary.DefaultGroupSummaryItems = <>
        DataController.Summary.FooterSummaryItems = <>
        DataController.Summary.SummaryGroups = <>
        Bands = <
          item
          end>
      end
      object dxGrillaSECLOSDBBandedTableView: TcxGridDBBandedTableView
        NavigatorButtons.ConfirmDelete = False
        DataController.DataSource = DSConsultasPagos
        DataController.Options = [dcoAssignGroupingValues, dcoAssignMasterDetailKeys, dcoSaveExpanding, dcoGroupsAlwaysExpanded]
        DataController.Summary.DefaultGroupSummaryItems = <
          item
            Format = '###,###,###,###.##'
            Kind = skSum
            Position = spFooter
            Column = dxGrillaSECLOSDBBandedTableViewColumn2
          end
          item
            Format = '###,###,###,###.##'
            Kind = skSum
            Position = spFooter
            Column = dxGrillaSECLOSDBBandedTableViewpago_acuerdo
          end
          item
            Format = '###,###,###,###.##'
            Kind = skSum
            Position = spFooter
            Column = dxGrillaSECLOSDBBandedTableViewpago_conciliador
          end
          item
            Format = '###,###,###,###.##'
            Kind = skSum
            Position = spFooter
            Column = dxGrillaSECLOSDBBandedTableViewpago_letrado
          end
          item
            Format = '###,###,###,###.##'
            Kind = skSum
            Position = spFooter
            Column = dxGrillaSECLOSDBBandedTableViewpago_perito
          end
          item
            Format = '###,###,###,###.##'
            Kind = skSum
            Position = spFooter
            Column = dxGrillaSECLOSDBBandedTableViewpago_justicia
          end
          item
            Format = '###,###,###,###.##'
            Kind = skSum
            Position = spFooter
            Column = dxGrillaSECLOSDBBandedTableViewtotal_pagado
          end
          item
            Format = '###,###,###,###.##'
            Kind = skSum
            Position = spFooter
            Column = dxGrillaSECLOSDBBandedTableViewColumn5
          end
          item
            Format = '###,###,###,###.##'
            Kind = skSum
            Position = spFooter
            Column = dxGrillaSECLOSDBBandedTableViewColumn6
          end>
        DataController.Summary.FooterSummaryItems = <
          item
            Format = '###,###,###,###.##'
            Kind = skSum
            Column = dxGrillaSECLOSDBBandedTableViewpago_acuerdo
          end
          item
            Format = '###,###,###,###.##'
            Kind = skSum
            Column = dxGrillaSECLOSDBBandedTableViewpago_conciliador
          end
          item
            Format = '###,###,###,###.##'
            Kind = skSum
            Column = dxGrillaSECLOSDBBandedTableViewpago_letrado
          end
          item
            Format = '###,###,###,###.##'
            Kind = skSum
            Column = dxGrillaSECLOSDBBandedTableViewpago_perito
          end
          item
            Format = '###,###,###,###.##'
            Kind = skSum
            Column = dxGrillaSECLOSDBBandedTableViewpago_justicia
          end
          item
            Format = '###,###,###,###.##'
            Kind = skSum
            Column = dxGrillaSECLOSDBBandedTableViewtotal_pagado
          end
          item
            Format = '###,###,###,###.##'
            Kind = skSum
            Column = dxGrillaSECLOSDBBandedTableViewColumn5
          end
          item
            Format = '###,###,###,###.##'
            Kind = skSum
            Column = dxGrillaSECLOSDBBandedTableViewColumn6
          end>
        DataController.Summary.SummaryGroups = <>
        OptionsBehavior.FocusCellOnTab = True
        OptionsBehavior.FocusFirstCellOnNewRecord = True
        OptionsBehavior.FocusCellOnCycle = True
        OptionsCustomize.ColumnsQuickCustomization = True
        OptionsCustomize.BandsQuickCustomization = True
        OptionsData.CancelOnExit = False
        OptionsData.Deleting = False
        OptionsData.DeletingConfirmation = False
        OptionsData.Editing = False
        OptionsData.Inserting = False
        OptionsView.CellAutoHeight = True
        OptionsView.Footer = True
        OptionsView.GroupFooters = gfAlwaysVisible
        OptionsView.GroupSummaryLayout = gslAlignWithColumns
        Bands = <
          item
            Caption = 'Legajos'
            FixedKind = fkLeft
            Width = 740
          end
          item
            Caption = 'Pagado'
          end
          item
            Caption = 'A Pagar'
            Width = 488
          end
          item
            Caption = 'SECLO / JUICIO'
          end
          item
            Caption = 'Datos Empresa'
            Width = 500
          end
          item
            Caption = 'Concepto Pago'
          end>
        object dxGrillaSECLOSDBBandedTableViewcodigo_interno: TcxGridDBBandedColumn
          Caption = 'C'#243'd. Interno'
          DataBinding.FieldName = 'codigo_interno'
          HeaderAlignmentHorz = taCenter
          Width = 120
          Position.BandIndex = 3
          Position.ColIndex = 2
          Position.RowIndex = 0
        end
        object dxGrillaSECLOSDBBandedTableViewlegajo: TcxGridDBBandedColumn
          Caption = 'Legajo'
          DataBinding.FieldName = 'legajo'
          HeaderAlignmentHorz = taCenter
          Width = 110
          Position.BandIndex = 0
          Position.ColIndex = 0
          Position.RowIndex = 0
        end
        object dxGrillaSECLOSDBBandedTableViewColumn1: TcxGridDBBandedColumn
          Caption = 'Ape. y Nom.'
          DataBinding.FieldName = 'ape_y_nom'
          HeaderAlignmentHorz = taCenter
          HeaderAlignmentVert = vaCenter
          Width = 297
          Position.BandIndex = 0
          Position.ColIndex = 1
          Position.RowIndex = 0
        end
        object dxGrillaSECLOSDBBandedTableViewprocedencia: TcxGridDBBandedColumn
          Caption = 'Procedencia'
          DataBinding.FieldName = 'procedencia'
          HeaderAlignmentHorz = taCenter
          Width = 200
          Position.BandIndex = 4
          Position.ColIndex = 0
          Position.RowIndex = 0
        end
        object dxGrillaSECLOSDBBandedTableViewpuesto: TcxGridDBBandedColumn
          Caption = 'Puesto'
          DataBinding.FieldName = 'puesto'
          HeaderAlignmentHorz = taCenter
          Width = 200
          Position.BandIndex = 4
          Position.ColIndex = 1
          Position.RowIndex = 0
        end
        object dxGrillaSECLOSDBBandedTableViewsector: TcxGridDBBandedColumn
          Caption = 'Sector'
          DataBinding.FieldName = 'sector'
          HeaderAlignmentHorz = taCenter
          Width = 200
          Position.BandIndex = 4
          Position.ColIndex = 2
          Position.RowIndex = 0
        end
        object dxGrillaSECLOSDBBandedTableViewfec_ant_rec: TcxGridDBBandedColumn
          Caption = 'Fec.Ant.Rec.'
          DataBinding.FieldName = 'fec_ant_rec'
          HeaderAlignmentHorz = taCenter
          Width = 111
          Position.BandIndex = 0
          Position.ColIndex = 2
          Position.RowIndex = 0
        end
        object dxGrillaSECLOSDBBandedTableViewfec_ing_rea: TcxGridDBBandedColumn
          Caption = 'Fec.Ing.Rea.'
          DataBinding.FieldName = 'fec_ing_rea'
          HeaderAlignmentHorz = taCenter
          Width = 111
          Position.BandIndex = 0
          Position.ColIndex = 3
          Position.RowIndex = 0
        end
        object dxGrillaSECLOSDBBandedTableViewfec_egreso: TcxGridDBBandedColumn
          Caption = 'Fec.Egreso'
          DataBinding.FieldName = 'fec_egreso'
          HeaderAlignmentHorz = taCenter
          Width = 111
          Position.BandIndex = 0
          Position.ColIndex = 4
          Position.RowIndex = 0
        end
        object dxGrillaSECLOSDBBandedTableViewestado_juicio: TcxGridDBBandedColumn
          Caption = 'Estado Juicio'
          DataBinding.FieldName = 'estado_juicio'
          HeaderAlignmentHorz = taCenter
          Width = 120
          Position.BandIndex = 3
          Position.ColIndex = 3
          Position.RowIndex = 0
        end
        object dxGrillaSECLOSDBBandedTableViewnro_expediente: TcxGridDBBandedColumn
          Caption = 'Nro. Expediente'
          DataBinding.FieldName = 'nro_expediente'
          HeaderAlignmentHorz = taCenter
          Width = 120
          Position.BandIndex = 3
          Position.ColIndex = 4
          Position.RowIndex = 0
        end
        object dxGrillaSECLOSDBBandedTableViewcausal_distracto: TcxGridDBBandedColumn
          Caption = 'Causal Distracto'
          DataBinding.FieldName = 'causal_distracto'
          HeaderAlignmentHorz = taCenter
          Width = 120
          Position.BandIndex = 3
          Position.ColIndex = 5
          Position.RowIndex = 0
        end
        object dxGrillaSECLOSDBBandedTableViewtipo_reclamo: TcxGridDBBandedColumn
          Caption = 'Tipo Reclamo'
          DataBinding.FieldName = 'tipo_reclamo'
          HeaderAlignmentHorz = taCenter
          Width = 120
          Position.BandIndex = 3
          Position.ColIndex = 6
          Position.RowIndex = 0
        end
        object dxGrillaSECLOSDBBandedTableViewmonto_reclamo: TcxGridDBBandedColumn
          Caption = 'Monto Reclamo'
          DataBinding.FieldName = 'monto_reclamo'
          HeaderAlignmentHorz = taCenter
          Width = 120
          Position.BandIndex = 3
          Position.ColIndex = 7
          Position.RowIndex = 0
        end
        object dxGrillaSECLOSDBBandedTableViewetapa_procesal: TcxGridDBBandedColumn
          Caption = 'Etapa Procesal'
          DataBinding.FieldName = 'etapa_procesal'
          HeaderAlignmentHorz = taCenter
          Width = 120
          Position.BandIndex = 3
          Position.ColIndex = 8
          Position.RowIndex = 0
        end
        object dxGrillaSECLOSDBBandedTableViewmonto_acuerdo: TcxGridDBBandedColumn
          Caption = 'Acuerdo'
          DataBinding.FieldName = 'monto_acuerdo'
          HeaderAlignmentHorz = taCenter
          Width = 80
          Position.BandIndex = 2
          Position.ColIndex = 0
          Position.RowIndex = 0
        end
        object dxGrillaSECLOSDBBandedTableViewmonto_conciliador: TcxGridDBBandedColumn
          Caption = 'Conciliador'
          DataBinding.FieldName = 'monto_conciliador'
          HeaderAlignmentHorz = taCenter
          Width = 80
          Position.BandIndex = 2
          Position.ColIndex = 1
          Position.RowIndex = 0
        end
        object dxGrillaSECLOSDBBandedTableViewmonto_letrado: TcxGridDBBandedColumn
          Caption = 'Letrado'
          DataBinding.FieldName = 'monto_letrado'
          HeaderAlignmentHorz = taCenter
          Width = 80
          Position.BandIndex = 2
          Position.ColIndex = 2
          Position.RowIndex = 0
        end
        object dxGrillaSECLOSDBBandedTableViewmonto_perito: TcxGridDBBandedColumn
          Caption = 'Perito'
          DataBinding.FieldName = 'monto_perito'
          HeaderAlignmentHorz = taCenter
          Width = 80
          Position.BandIndex = 2
          Position.ColIndex = 3
          Position.RowIndex = 0
        end
        object dxGrillaSECLOSDBBandedTableViewmonto_justicia: TcxGridDBBandedColumn
          Caption = 'Tasa Just.'
          DataBinding.FieldName = 'monto_justicia'
          HeaderAlignmentHorz = taCenter
          Width = 80
          Position.BandIndex = 2
          Position.ColIndex = 4
          Position.RowIndex = 0
        end
        object dxGrillaSECLOSDBBandedTableViewmonto_total: TcxGridDBBandedColumn
          Caption = 'Total a Pagar'
          DataBinding.FieldName = 'monto_total'
          HeaderAlignmentHorz = taCenter
          Width = 80
          Position.BandIndex = 2
          Position.ColIndex = 5
          Position.RowIndex = 0
        end
        object dxGrillaSECLOSDBBandedTableViewfec_pago: TcxGridDBBandedColumn
          Caption = 'Fec. Pago'
          DataBinding.FieldName = 'fec_pago'
          HeaderAlignmentHorz = taCenter
          Width = 80
          Position.BandIndex = 1
          Position.ColIndex = 0
          Position.RowIndex = 0
        end
        object dxGrillaSECLOSDBBandedTableViewpago_acuerdo: TcxGridDBBandedColumn
          Caption = 'Acuerdo'
          DataBinding.FieldName = 'pago_acuerdo'
          HeaderAlignmentHorz = taCenter
          Width = 80
          Position.BandIndex = 1
          Position.ColIndex = 1
          Position.RowIndex = 0
        end
        object dxGrillaSECLOSDBBandedTableViewpago_conciliador: TcxGridDBBandedColumn
          Caption = 'Conciliador'
          DataBinding.FieldName = 'pago_conciliador'
          HeaderAlignmentHorz = taCenter
          Width = 80
          Position.BandIndex = 1
          Position.ColIndex = 2
          Position.RowIndex = 0
        end
        object dxGrillaSECLOSDBBandedTableViewpago_letrado: TcxGridDBBandedColumn
          Caption = 'Letrado'
          DataBinding.FieldName = 'pago_letrado'
          HeaderAlignmentHorz = taCenter
          Width = 80
          Position.BandIndex = 1
          Position.ColIndex = 3
          Position.RowIndex = 0
        end
        object dxGrillaSECLOSDBBandedTableViewpago_perito: TcxGridDBBandedColumn
          Caption = 'Perito'
          DataBinding.FieldName = 'pago_perito'
          HeaderAlignmentHorz = taCenter
          Width = 80
          Position.BandIndex = 1
          Position.ColIndex = 4
          Position.RowIndex = 0
        end
        object dxGrillaSECLOSDBBandedTableViewpago_justicia: TcxGridDBBandedColumn
          Caption = 'Tasa Just.'
          DataBinding.FieldName = 'pago_justicia'
          HeaderAlignmentHorz = taCenter
          Width = 80
          Position.BandIndex = 1
          Position.ColIndex = 5
          Position.RowIndex = 0
        end
        object dxGrillaSECLOSDBBandedTableViewtotal_pagado: TcxGridDBBandedColumn
          Caption = 'Total Pagado'
          DataBinding.FieldName = 'total_pagado'
          HeaderAlignmentHorz = taCenter
          Width = 80
          Position.BandIndex = 1
          Position.ColIndex = 6
          Position.RowIndex = 0
        end
        object dxGrillaSECLOSDBBandedTableViewColumn2: TcxGridDBBandedColumn
          DataBinding.FieldName = 'juicio_seclo'
          Visible = False
          GroupIndex = 0
          Position.BandIndex = 0
          Position.ColIndex = 5
          Position.RowIndex = 0
          IsCaptionAssigned = True
        end
        object dxGrillaSECLOSDBBandedTableViewColumn3: TcxGridDBBandedColumn
          Caption = 'Concepto'
          DataBinding.FieldName = 'concepto_pago'
          HeaderAlignmentHorz = taCenter
          Width = 200
          Position.BandIndex = 5
          Position.ColIndex = 0
          Position.RowIndex = 0
        end
        object dxGrillaSECLOSDBBandedTableViewColumn4: TcxGridDBBandedColumn
          Caption = 'Obs. Pago'
          DataBinding.FieldName = 'obs_pago'
          PropertiesClassName = 'TcxMemoProperties'
          HeaderAlignmentHorz = taCenter
          Width = 400
          Position.BandIndex = 5
          Position.ColIndex = 1
          Position.RowIndex = 0
        end
        object dxGrillaSECLOSDBBandedTableViewColumn5: TcxGridDBBandedColumn
          Caption = 'Cant. Pagos'
          DataBinding.FieldName = 'cant_pagos'
          Position.BandIndex = 1
          Position.ColIndex = 7
          Position.RowIndex = 0
        end
        object dxGrillaSECLOSDBBandedTableViewColumn6: TcxGridDBBandedColumn
          Caption = 'Cant. Jui./Sec.'
          DataBinding.FieldName = 'cant_jui_seclos'
          Width = 75
          Position.BandIndex = 1
          Position.ColIndex = 8
          Position.RowIndex = 0
        end
        object dxGrillaSECLOSDBBandedTableViewColumn7: TcxGridDBBandedColumn
          Caption = 'Fec. Recepci'#243'n'
          DataBinding.FieldName = 'fec_recepcion'
          HeaderAlignmentHorz = taCenter
          Width = 94
          Position.BandIndex = 3
          Position.ColIndex = 0
          Position.RowIndex = 0
        end
        object dxGrillaSECLOSDBBandedTableViewColumn8: TcxGridDBBandedColumn
          Caption = 'Requeridos'
          DataBinding.FieldName = 'requeridos'
          HeaderAlignmentHorz = taCenter
          Width = 230
          Position.BandIndex = 3
          Position.ColIndex = 1
          Position.RowIndex = 0
        end
      end
      object dxGrillaSECLOSDBTableView1: TcxGridDBTableView
        NavigatorButtons.ConfirmDelete = False
        DataController.DataSource = DSConsultasPagos
        DataController.Options = [dcoAssignGroupingValues, dcoAssignMasterDetailKeys, dcoSaveExpanding, dcoGroupsAlwaysExpanded]
        DataController.Summary.DefaultGroupSummaryItems = <>
        DataController.Summary.FooterSummaryItems = <>
        DataController.Summary.SummaryGroups = <>
        OptionsView.CellAutoHeight = True
        object dxGrillaSECLOSDBTableView1legajo: TcxGridDBColumn
          Caption = 'Legajo'
          DataBinding.FieldName = 'legajo'
          HeaderAlignmentHorz = taCenter
          SortIndex = 0
          SortOrder = soAscending
          Width = 107
        end
        object dxGrillaSECLOSDBTableView1Column1: TcxGridDBColumn
          Caption = 'Ape. y Nom.'
          DataBinding.FieldName = 'ape_y_nom'
          HeaderAlignmentHorz = taCenter
          Width = 276
        end
        object dxGrillaSECLOSDBTableView1procedencia: TcxGridDBColumn
          Caption = 'Procedencia'
          DataBinding.FieldName = 'procedencia'
          HeaderAlignmentHorz = taCenter
          Width = 187
        end
        object dxGrillaSECLOSDBTableView1puesto: TcxGridDBColumn
          Caption = 'Puesto'
          DataBinding.FieldName = 'puesto'
          HeaderAlignmentHorz = taCenter
          Width = 181
        end
        object dxGrillaSECLOSDBTableView1sector: TcxGridDBColumn
          Caption = 'Sector'
          DataBinding.FieldName = 'sector'
          HeaderAlignmentHorz = taCenter
          Width = 164
        end
        object dxGrillaSECLOSDBTableView1fec_ant_rec: TcxGridDBColumn
          Caption = 'Fec. Ant. Rec.'
          DataBinding.FieldName = 'fec_ant_rec'
          Width = 100
        end
        object dxGrillaSECLOSDBTableView1fec_ing_rea: TcxGridDBColumn
          Caption = 'Fec. Ing. Real'
          DataBinding.FieldName = 'fec_ing_rea'
          HeaderAlignmentHorz = taCenter
          Width = 100
        end
        object dxGrillaSECLOSDBTableView1fec_egreso: TcxGridDBColumn
          Caption = 'Fec. Egreso'
          DataBinding.FieldName = 'fec_egreso'
          HeaderAlignmentHorz = taCenter
          Width = 100
        end
        object dxGrillaSECLOSDBTableView1Column2: TcxGridDBColumn
          Caption = 'Segui. Leg.'
          DataBinding.FieldName = 'segui_legales'
          HeaderAlignmentHorz = taCenter
          Width = 80
        end
        object dxGrillaSECLOSDBTableView1Column3: TcxGridDBColumn
          Caption = 'Segui Cartas'
          DataBinding.FieldName = 'segui_cartas'
          HeaderAlignmentHorz = taCenter
          Width = 80
        end
        object dxGrillaSECLOSDBTableView1Column4: TcxGridDBColumn
          Caption = 'Fec. Neg.'
          DataBinding.FieldName = 'fec_neg'
          HeaderAlignmentHorz = taCenter
          Options.Editing = False
          SortIndex = 1
          SortOrder = soDescending
          Width = 100
        end
        object dxGrillaSECLOSDBTableView1Column5: TcxGridDBColumn
          Caption = 'Negociaci'#243'n'
          DataBinding.FieldName = 'obs_neg'
          HeaderAlignmentHorz = taCenter
          Options.Editing = False
          Width = 400
        end
        object dxGrillaSECLOSDBTableView1Column6: TcxGridDBColumn
          Caption = 'Monto Negociaci'#243'n'
          DataBinding.FieldName = 'monto_neg'
          HeaderAlignmentHorz = taCenter
          Options.Editing = False
          Width = 100
        end
      end
      object dxGrillaSECLOSLevel1: TcxGridLevel
        GridView = dxGrillaSECLOSDBTableView1
      end
    end
  end
  inherited DriverABM: TDriverABM
    CargaDataSets = <
      item
        DataSet = TLegajosSegui
        TableName = 'TLegajosSegui'
      end>
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
    OnInicializar = <
      item
        Source.Strings = (
          'begin'
          '     varios.setImagen('#39'ImageSalir'#39',7);'
          '    operacion.InicioOperacion();'
          '    operacion.setOper('#39'TraerSeguiLegales'#39');'
          '  operacion.execute();'
          'end.')
      end>
    OnClickToolButton = <
      item
        ButtonName = 'ImageSalir'
        Source.Strings = (
          'begin'
          '  close();'
          'end.')
      end>
  end
  inherited ImprimirObjetoSeleccionado: TdxComponentPrinter
    inherited ImprimirObjetoSeleccionadodxComponentPrinterLink: TdxGridReportLink
      BuiltInReportLink = True
    end
  end
  object Varios: TsnVarios
    Operacion = Operacion
    Left = 448
    Top = 60
  end
  object TLegajosSegui: TsnTable
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
    Left = 109
    Top = 235
    object TLegajosSeguisecu: TIntegerField
      FieldName = 'secu'
    end
    object TLegajosSeguioid_legajo: TIntegerField
      FieldName = 'oid_legajo'
    end
    object TLegajosSeguilegajo: TStringField
      FieldName = 'legajo'
      Size = 50
    end
    object TLegajosSeguiape_y_nom: TStringField
      FieldName = 'ape_y_nom'
      Size = 255
    end
    object TLegajosSeguiprocedencia: TStringField
      FieldName = 'procedencia'
      Size = 255
    end
    object TLegajosSeguipuesto: TStringField
      FieldName = 'puesto'
      Size = 255
    end
    object TLegajosSeguisector: TStringField
      FieldName = 'sector'
      Size = 255
    end
    object TLegajosSeguifec_ant_rec: TDateField
      FieldName = 'fec_ant_rec'
    end
    object TLegajosSeguifec_ing_rea: TDateField
      FieldName = 'fec_ing_rea'
    end
    object TLegajosSeguifec_egreso: TDateField
      FieldName = 'fec_egreso'
    end
    object TLegajosSeguisegui_legales: TStringField
      FieldName = 'segui_legales'
      Size = 2
    end
    object TLegajosSeguisegui_cartas: TStringField
      FieldName = 'segui_cartas'
      Size = 2
    end
    object TLegajosSeguifec_neg: TDateField
      FieldName = 'fec_neg'
    end
    object TLegajosSeguiobs_neg: TMemoField
      FieldName = 'obs_neg'
      BlobType = ftMemo
    end
    object TLegajosSeguimonto_neg: TCurrencyField
      FieldName = 'monto_neg'
      DisplayFormat = '###,###,###,##0.00'
    end
  end
  object DSConsultasPagos: TDataSource
    DataSet = TLegajosSegui
    Left = 141
    Top = 235
  end
end
