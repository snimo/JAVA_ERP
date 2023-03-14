inherited FConsPlanDesa: TFConsPlanDesa
  Left = 87
  Top = 85
  Width = 1059
  Height = 751
  Caption = 'Consulta Detallada Desarrollo'
  PixelsPerInch = 96
  TextHeight = 13
  object Panel1: TPanel [0]
    Left = 0
    Top = 0
    Width = 1043
    Height = 114
    Align = alTop
    BevelOuter = bvNone
    Color = clWindow
    TabOrder = 0
    object Shape1: TShape
      Left = 16
      Top = 12
      Width = 721
      Height = 28
      Brush.Color = 16769217
      Shape = stRoundRect
    end
    object ImageSalir: TImage
      Tag = 7
      Left = 742
      Top = 9
      Width = 32
      Height = 32
      Cursor = crHandPoint
      Hint = 'Salir'
      ParentShowHint = False
      ShowHint = True
    end
    object snLabel1: TsnLabel
      Left = 546
      Top = 17
      Width = 26
      Height = 16
      Caption = 'Mes'
      Font.Charset = ANSI_CHARSET
      Font.Color = clWindowText
      Font.Height = -13
      Font.Name = 'Verdana'
      Font.Style = []
      ParentFont = False
      Transparent = True
    end
    object snLabel3: TsnLabel
      Left = 18
      Top = 49
      Width = 59
      Height = 16
      Caption = 'Acciones'
      Font.Charset = ANSI_CHARSET
      Font.Color = clWindowText
      Font.Height = -13
      Font.Name = 'Verdana'
      Font.Style = []
      ParentFont = False
    end
    object snDBEdit2: TsnDBEdit
      Left = 576
      Top = 14
      DataBinding.DataField = 'mes'
      DataBinding.DataSource = DSFiltros
      ParentFont = False
      Properties.ReadOnly = True
      Style.Color = 16769217
      Style.Edges = []
      Style.Font.Charset = ANSI_CHARSET
      Style.Font.Color = clWindowText
      Style.Font.Height = -13
      Style.Font.Name = 'Verdana'
      Style.Font.Style = [fsBold]
      Style.IsFontAssigned = True
      TabOrder = 0
      Width = 153
    end
    object dxDBGridSN1: TdxDBGridSN
      Left = 88
      Top = 48
      Width = 438
      Height = 62
      TabOrder = 1
      CriteriosPintarCelda = <>
      object dxDBGridSN1DBTableView1: TcxGridDBTableView
        NavigatorButtons.ConfirmDelete = False
        DataController.DataSource = DSAcciones
        DataController.Summary.DefaultGroupSummaryItems = <>
        DataController.Summary.FooterSummaryItems = <>
        DataController.Summary.SummaryGroups = <>
        OptionsData.CancelOnExit = False
        OptionsData.Deleting = False
        OptionsData.DeletingConfirmation = False
        OptionsData.Editing = False
        OptionsData.Inserting = False
        OptionsView.CellAutoHeight = True
        OptionsView.GroupByBox = False
        OptionsView.Header = False
        Styles.Content = cxStyle1
        object dxDBGridSN1DBTableView1Column1: TcxGridDBColumn
          DataBinding.FieldName = 'accion'
          Options.Editing = False
          Width = 400
        end
      end
      object dxDBGridSN1Level1: TcxGridLevel
        GridView = dxDBGridSN1DBTableView1
      end
    end
    object snDBEdit1: TsnDBEdit
      Left = 24
      Top = 14
      DataBinding.DataField = 'desc_cronograma'
      DataBinding.DataSource = DSFiltros
      ParentFont = False
      Properties.ReadOnly = True
      Style.Color = 16769217
      Style.Edges = []
      Style.Font.Charset = ANSI_CHARSET
      Style.Font.Color = clWindowText
      Style.Font.Height = -13
      Style.Font.Name = 'Verdana'
      Style.Font.Style = [fsBold]
      Style.IsFontAssigned = True
      TabOrder = 2
      Width = 505
    end
    object BotonCompoDet: TsnButton
      Left = 544
      Top = 56
      Width = 193
      Height = 41
      Cursor = crHandPoint
      Caption = 'Ver composici'#243'n Calificaci'#243'n'
      TabOrder = 3
      LookAndFeel.Kind = lfOffice11
    end
  end
  object Panel2: TPanel [1]
    Left = 0
    Top = 114
    Width = 1043
    Height = 599
    Align = alClient
    BevelOuter = bvNone
    BorderWidth = 3
    Color = clWindow
    TabOrder = 1
    object dxDBGridSN2: TdxDBGridSN
      Left = 3
      Top = 3
      Width = 1037
      Height = 593
      Align = alClient
      TabOrder = 0
      LookAndFeel.Kind = lfFlat
      CriteriosPintarCelda = <
        item
          TipoPintadaCelda = tpcTodasLasColumnas
          FieldName1 = 'aprobado'
          TipoCondFiltro1 = tcfIgual
          Valor1 = 'No'
          TipoCondFiltro2 = tcfIgual
          Color = 7303167
        end
        item
          TipoPintadaCelda = tpcTodasLasColumnas
          FieldName1 = 'aprobado'
          TipoCondFiltro1 = tcfIgual
          Valor1 = 'Si'
          TipoCondFiltro2 = tcfIgual
          Color = 6208256
        end>
      object dxDBGridSN2DBTableView1: TcxGridDBTableView
        NavigatorButtons.ConfirmDelete = False
        DataController.DataSource = DSTConsultaDesarrollo
        DataController.Summary.DefaultGroupSummaryItems = <>
        DataController.Summary.FooterSummaryItems = <>
        DataController.Summary.SummaryGroups = <>
        OptionsData.CancelOnExit = False
        OptionsData.Deleting = False
        OptionsData.DeletingConfirmation = False
        OptionsData.Editing = False
        OptionsData.Inserting = False
        OptionsView.CellAutoHeight = True
      end
      object dxDBGridSN2DBBandedTableView1: TcxGridDBBandedTableView
        NavigatorButtons.ConfirmDelete = False
        DataController.DataSource = DSTConsultaDesarrollo
        DataController.Options = [dcoAssignGroupingValues, dcoAssignMasterDetailKeys, dcoSaveExpanding, dcoGroupsAlwaysExpanded]
        DataController.Summary.DefaultGroupSummaryItems = <>
        DataController.Summary.FooterSummaryItems = <>
        DataController.Summary.SummaryGroups = <>
        OptionsBehavior.FocusCellOnTab = True
        OptionsBehavior.FocusFirstCellOnNewRecord = True
        OptionsBehavior.GoToNextCellOnEnter = True
        OptionsBehavior.FocusCellOnCycle = True
        OptionsCustomize.BandsQuickCustomization = True
        OptionsData.CancelOnExit = False
        OptionsData.Deleting = False
        OptionsData.DeletingConfirmation = False
        OptionsData.Editing = False
        OptionsData.Inserting = False
        OptionsSelection.UnselectFocusedRecordOnExit = False
        OptionsView.CellAutoHeight = True
        OptionsView.BandHeaderEndEllipsis = True
        Bands = <
          item
            Caption = 'Legajo'
            FixedKind = fkLeft
            Width = 800
          end
          item
            Caption = 'Puesto'
            Width = 548
          end
          item
            Caption = 'Evaluaci'#243'n de Desempe'#241'o'
            Width = 366
          end
          item
            Caption = 'Evaluaci'#243'n de Potencial'
            Width = 500
          end
          item
            Caption = 'Horizonte de Carrera'
            Width = 450
          end
          item
            Caption = 'Relaciones Laborales'
            Width = 500
          end
          item
            Caption = 'An'#225'lisis Final'
            Width = 568
          end
          item
            Caption = 'Pendientes para poder Evaluar. Cargar de ...'
            Width = 324
          end
          item
            Caption = 'Otros'
            Width = 200
          end>
        object dxDBGridSN2DBBandedTableView1desc_accion: TcxGridDBBandedColumn
          Caption = 'Acci'#243'n'
          DataBinding.FieldName = 'desc_accion'
          Visible = False
          GroupIndex = 1
          Width = 150
          Position.BandIndex = 0
          Position.ColIndex = 0
          Position.RowIndex = 0
        end
        object dxDBGridSN2DBBandedTableView1legajo: TcxGridDBBandedColumn
          Caption = 'Legajo'
          DataBinding.FieldName = 'legajo'
          HeaderAlignmentHorz = taCenter
          Width = 46
          Position.BandIndex = 0
          Position.ColIndex = 1
          Position.RowIndex = 0
        end
        object dxDBGridSN2DBBandedTableView1apellido: TcxGridDBBandedColumn
          Caption = 'Apellido'
          DataBinding.FieldName = 'apellido'
          HeaderAlignmentHorz = taCenter
          SortIndex = 0
          SortOrder = soAscending
          Width = 126
          Position.BandIndex = 0
          Position.ColIndex = 2
          Position.RowIndex = 0
        end
        object dxDBGridSN2DBBandedTableView1nombre: TcxGridDBBandedColumn
          Caption = 'Nombre'
          DataBinding.FieldName = 'nombre'
          HeaderAlignmentHorz = taCenter
          Width = 137
          Position.BandIndex = 0
          Position.ColIndex = 3
          Position.RowIndex = 0
        end
        object dxDBGridSN2DBBandedTableView1desc_val_clasif_emp: TcxGridDBBandedColumn
          Caption = 'Empresa'
          DataBinding.FieldName = 'desc_val_clasif_emp'
          Visible = False
          GroupIndex = 0
          HeaderAlignmentHorz = taCenter
          Width = 135
          Position.BandIndex = 8
          Position.ColIndex = 0
          Position.RowIndex = 0
        end
        object dxDBGridSN2DBBandedTableView1desc_val_clasif_sec: TcxGridDBBandedColumn
          Caption = 'Sector'
          DataBinding.FieldName = 'desc_val_clasif_sec'
          Visible = False
          GroupIndex = 2
          HeaderAlignmentHorz = taCenter
          Width = 135
          Position.BandIndex = 8
          Position.ColIndex = 1
          Position.RowIndex = 0
        end
        object dxDBGridSN2DBBandedTableView1desc_val_clasif_pue: TcxGridDBBandedColumn
          Caption = 'Puesto Actual'
          DataBinding.FieldName = 'desc_val_clasif_pue'
          HeaderAlignmentHorz = taCenter
          Width = 176
          Position.BandIndex = 1
          Position.ColIndex = 0
          Position.RowIndex = 0
        end
        object dxDBGridSN2DBBandedTableView1fec_ingreso: TcxGridDBBandedColumn
          Caption = 'Fec. Ant. Emp.'
          DataBinding.FieldName = 'fec_ingreso'
          HeaderAlignmentHorz = taCenter
          Width = 76
          Position.BandIndex = 0
          Position.ColIndex = 4
          Position.RowIndex = 0
        end
        object dxDBGridSN2DBBandedTableView1Column1: TcxGridDBBandedColumn
          Caption = 'Jue. A'
          DataBinding.FieldName = 'cant_juegos_a'
          HeaderAlignmentHorz = taCenter
          Options.Editing = False
          Width = 40
          Position.BandIndex = 0
          Position.ColIndex = 6
          Position.RowIndex = 0
        end
        object dxDBGridSN2DBBandedTableView1Column2: TcxGridDBBandedColumn
          Caption = 'Jue. B'
          DataBinding.FieldName = 'cant_juegos_b'
          HeaderAlignmentHorz = taCenter
          Options.Editing = False
          Width = 37
          Position.BandIndex = 0
          Position.ColIndex = 7
          Position.RowIndex = 0
        end
        object dxDBGridSN2DBBandedTableView1Column4: TcxGridDBBandedColumn
          Caption = 'Puesto Posible'
          DataBinding.FieldName = 'desc_categ_posible'
          HeaderAlignmentHorz = taCenter
          Options.Editing = False
          Width = 153
          Position.BandIndex = 1
          Position.ColIndex = 3
          Position.RowIndex = 0
        end
        object dxDBGridSN2DBBandedTableView1Column3: TcxGridDBBandedColumn
          Caption = 'Ant. Empresa'
          DataBinding.FieldName = 'ant_ingreso'
          HeaderAlignmentHorz = taCenter
          Options.Editing = False
          Width = 121
          Position.BandIndex = 0
          Position.ColIndex = 5
          Position.RowIndex = 0
        end
        object dxDBGridSN2DBBandedTableView1Column5: TcxGridDBBandedColumn
          Caption = 'Fecha Asumi'#243
          DataBinding.FieldName = 'fec_ant_puesto'
          HeaderAlignmentHorz = taCenter
          Options.Editing = False
          Width = 102
          Position.BandIndex = 1
          Position.ColIndex = 1
          Position.RowIndex = 0
        end
        object dxDBGridSN2DBBandedTableView1Column6: TcxGridDBBandedColumn
          Caption = 'Antig. Puesto'
          DataBinding.FieldName = 'ant_puesto'
          HeaderAlignmentHorz = taCenter
          Options.Editing = False
          Width = 117
          Position.BandIndex = 1
          Position.ColIndex = 2
          Position.RowIndex = 0
        end
        object dxDBGridSN2DBBandedTableView1Column7: TcxGridDBBandedColumn
          Caption = 'Punt.Eval. Desemp.'
          DataBinding.FieldName = 'evaluacion'
          HeaderAlignmentHorz = taCenter
          Options.Editing = False
          Width = 100
          Position.BandIndex = 2
          Position.ColIndex = 2
          Position.RowIndex = 0
        end
        object dxDBGridSN2DBBandedTableView1Column8: TcxGridDBBandedColumn
          Caption = 'Eval. Desemp.'
          DataBinding.FieldName = 'desc_evaluacion'
          HeaderAlignmentHorz = taCenter
          Options.Editing = False
          Width = 148
          Position.BandIndex = 2
          Position.ColIndex = 1
          Position.RowIndex = 0
        end
        object dxDBGridSN2DBBandedTableView1Column9: TcxGridDBBandedColumn
          Caption = 'Calif. Gral.'
          DataBinding.FieldName = 'ranking'
          HeaderAlignmentHorz = taCenter
          Options.Editing = False
          SortIndex = 1
          SortOrder = soDescending
          Styles.Content = cxStyle2
          Width = 95
          Position.BandIndex = 6
          Position.ColIndex = 0
          Position.RowIndex = 0
        end
        object dxDBGridSN2DBBandedTableView1Column10: TcxGridDBBandedColumn
          Caption = 'Aprobado'
          DataBinding.FieldName = 'aprobado'
          HeaderAlignmentHorz = taCenter
          Options.Editing = False
          Width = 76
          Position.BandIndex = 6
          Position.ColIndex = 1
          Position.RowIndex = 0
        end
        object dxDBGridSN2DBBandedTableView1Column11: TcxGridDBBandedColumn
          Caption = 'Motivos (S'#237'mbolo (!) indica NO aprobado)'
          DataBinding.FieldName = 'mot_no_aprob'
          HeaderAlignmentHorz = taCenter
          Options.Editing = False
          Width = 397
          Position.BandIndex = 6
          Position.ColIndex = 2
          Position.RowIndex = 0
        end
        object dxDBGridSN2DBBandedTableView1Column12: TcxGridDBBandedColumn
          DataBinding.FieldName = 'cant_nov_1'
          Width = 155
          Position.BandIndex = 8
          Position.ColIndex = 2
          Position.RowIndex = 0
        end
        object dxDBGridSN2DBBandedTableView1Column13: TcxGridDBBandedColumn
          DataBinding.FieldName = 'cant_nov_2'
          Width = 166
          Position.BandIndex = 8
          Position.ColIndex = 3
          Position.RowIndex = 0
        end
        object dxDBGridSN2DBBandedTableView1Column14: TcxGridDBBandedColumn
          DataBinding.FieldName = 'cant_nov_3'
          Width = 173
          Position.BandIndex = 8
          Position.ColIndex = 4
          Position.RowIndex = 0
        end
        object dxDBGridSN2DBBandedTableView1Column15: TcxGridDBBandedColumn
          DataBinding.FieldName = 'cant_nov_4'
          Width = 172
          Position.BandIndex = 8
          Position.ColIndex = 5
          Position.RowIndex = 0
        end
        object dxDBGridSN2DBBandedTableView1Column16: TcxGridDBBandedColumn
          DataBinding.FieldName = 'cant_nov_5'
          Width = 162
          Position.BandIndex = 8
          Position.ColIndex = 6
          Position.RowIndex = 0
        end
        object dxDBGridSN2DBBandedTableView1Column17: TcxGridDBBandedColumn
          DataBinding.FieldName = 'cant_nov_6'
          Width = 169
          Position.BandIndex = 8
          Position.ColIndex = 7
          Position.RowIndex = 0
        end
        object dxDBGridSN2DBBandedTableView1Column18: TcxGridDBBandedColumn
          DataBinding.FieldName = 'cant_nov_7'
          Width = 166
          Position.BandIndex = 8
          Position.ColIndex = 8
          Position.RowIndex = 0
        end
        object dxDBGridSN2DBBandedTableView1Column19: TcxGridDBBandedColumn
          DataBinding.FieldName = 'cant_nov_8'
          Width = 181
          Position.BandIndex = 8
          Position.ColIndex = 9
          Position.RowIndex = 0
        end
        object dxDBGridSN2DBBandedTableView1Column20: TcxGridDBBandedColumn
          DataBinding.FieldName = 'cant_nov_9'
          Width = 150
          Position.BandIndex = 8
          Position.ColIndex = 10
          Position.RowIndex = 0
        end
        object dxDBGridSN2DBBandedTableView1Column21: TcxGridDBBandedColumn
          DataBinding.FieldName = 'cant_nov_10'
          Width = 178
          Position.BandIndex = 8
          Position.ColIndex = 11
          Position.RowIndex = 0
        end
        object dxDBGridSN2DBBandedTableView1Column22: TcxGridDBBandedColumn
          Caption = 'D'#237'as Acum. R.T.'
          DataBinding.FieldName = 'horas_acum'
          HeaderAlignmentHorz = taCenter
          Options.Editing = False
          Width = 82
          Position.BandIndex = 4
          Position.ColIndex = 3
          Position.RowIndex = 0
        end
        object dxDBGridSN2DBBandedTableView1Column23: TcxGridDBBandedColumn
          Caption = 'Min. Jue. A'
          DataBinding.FieldName = 'cant_min_juegos_a'
          HeaderAlignmentVert = vaCenter
          Options.Editing = False
          Width = 61
          Position.BandIndex = 0
          Position.ColIndex = 8
          Position.RowIndex = 0
        end
        object dxDBGridSN2DBBandedTableView1Column24: TcxGridDBBandedColumn
          Caption = 'Horiz. Carrera'
          DataBinding.FieldName = 'tiempo_hor_carrera'
          HeaderAlignmentHorz = taCenter
          Options.Editing = False
          Width = 142
          Position.BandIndex = 4
          Position.ColIndex = 0
          Position.RowIndex = 0
        end
        object dxDBGridSN2DBBandedTableView1Column25: TcxGridDBBandedColumn
          Caption = 'Dif. Meses H.C.'
          DataBinding.FieldName = 'dif_meses_hc'
          HeaderAlignmentHorz = taCenter
          Options.Editing = False
          Width = 82
          Position.BandIndex = 4
          Position.ColIndex = 2
          Position.RowIndex = 0
        end
        object dxDBGridSN2DBBandedTableView1Column26: TcxGridDBBandedColumn
          Caption = 'Antig. Sector'
          DataBinding.FieldName = 'antiguedad_sector'
          HeaderAlignmentHorz = taCenter
          HeaderAlignmentVert = vaCenter
          Width = 144
          Position.BandIndex = 4
          Position.ColIndex = 1
          Position.RowIndex = 0
        end
        object dxDBGridSN2DBBandedTableView1Column27: TcxGridDBBandedColumn
          Caption = 'Fec.Eval.Desemp.'
          DataBinding.FieldName = 'fec_eval_desemp'
          HeaderAlignmentHorz = taCenter
          Width = 118
          Position.BandIndex = 2
          Position.ColIndex = 0
          Position.RowIndex = 0
        end
        object dxDBGridSN2DBBandedTableView1Column28: TcxGridDBBandedColumn
          Caption = 'Fec.Eval.Pot'
          DataBinding.FieldName = 'fec_eval_pot'
          HeaderAlignmentHorz = taCenter
          Width = 84
          Position.BandIndex = 3
          Position.ColIndex = 0
          Position.RowIndex = 0
        end
        object dxDBGridSN2DBBandedTableView1Column29: TcxGridDBBandedColumn
          Caption = 'Eval. Potencial'
          DataBinding.FieldName = 'desc_evaluacion_pot'
          HeaderAlignmentHorz = taCenter
          Width = 100
          Position.BandIndex = 3
          Position.ColIndex = 1
          Position.RowIndex = 0
        end
        object dxDBGridSN2DBBandedTableView1Column30: TcxGridDBBandedColumn
          Caption = 'Punt.Eval.Pot.'
          DataBinding.FieldName = 'evaluacion_pot'
          HeaderAlignmentHorz = taCenter
          Width = 69
          Position.BandIndex = 3
          Position.ColIndex = 2
          Position.RowIndex = 0
        end
        object dxDBGridSN2DBBandedTableView1Column31: TcxGridDBBandedColumn
          Caption = 'Puesto Evaluaci'#243'n Potencial'
          DataBinding.FieldName = 'puesto_eval_pot'
          HeaderAlignmentHorz = taCenter
          Width = 197
          Position.BandIndex = 3
          Position.ColIndex = 3
          Position.RowIndex = 0
        end
        object dxDBGridSN2DBBandedTableView1Column32: TcxGridDBBandedColumn
          Caption = 'Fec. IRL'
          DataBinding.FieldName = 'fec_irl'
          HeaderAlignmentHorz = taCenter
          Width = 73
          Position.BandIndex = 5
          Position.ColIndex = 0
          Position.RowIndex = 0
        end
        object dxDBGridSN2DBBandedTableView1Column33: TcxGridDBBandedColumn
          Caption = 'Resul.IRL'
          DataBinding.FieldName = 'result_irl'
          HeaderAlignmentHorz = taCenter
          Width = 65
          Position.BandIndex = 5
          Position.ColIndex = 1
          Position.RowIndex = 0
        end
        object dxDBGridSN2DBBandedTableView1Column34: TcxGridDBBandedColumn
          Caption = 'Obs. IRL.'
          DataBinding.FieldName = 'obs_irl'
          HeaderAlignmentHorz = taCenter
          Width = 362
          Position.BandIndex = 5
          Position.ColIndex = 2
          Position.RowIndex = 0
        end
        object dxDBGridSN2DBBandedTableView1Column35: TcxGridDBBandedColumn
          Caption = 'Eval. Desemp.'
          DataBinding.FieldName = 'pend_realizar_eval_des'
          HeaderAlignmentHorz = taCenter
          Position.BandIndex = 7
          Position.ColIndex = 0
          Position.RowIndex = 0
        end
        object dxDBGridSN2DBBandedTableView1Column36: TcxGridDBBandedColumn
          Caption = 'Eval. Poten.'
          DataBinding.FieldName = 'pend_realizar_eval_pot'
          HeaderAlignmentHorz = taCenter
          Position.BandIndex = 7
          Position.ColIndex = 1
          Position.RowIndex = 0
        end
        object dxDBGridSN2DBBandedTableView1Column37: TcxGridDBBandedColumn
          Caption = 'Inf. Rel. Lab.'
          DataBinding.FieldName = 'pend_realizar_irl'
          HeaderAlignmentHorz = taCenter
          Position.BandIndex = 7
          Position.ColIndex = 2
          Position.RowIndex = 0
        end
        object dxDBGridSN2DBBandedTableView1Column38: TcxGridDBBandedColumn
          Caption = 'Carga Juegos A'
          DataBinding.FieldName = 'pend_realizar_carga_ja'
          HeaderAlignmentHorz = taCenter
          Position.BandIndex = 7
          Position.ColIndex = 3
          Position.RowIndex = 0
        end
        object dxDBGridSN2DBBandedTableView1Column39: TcxGridDBBandedColumn
          Caption = 'Clase'
          DataBinding.FieldName = 'clase_sindicato'
          HeaderAlignmentHorz = taCenter
          Width = 105
          Position.BandIndex = 0
          Position.ColIndex = 9
          Position.RowIndex = 0
        end
      end
      object dxDBGridSN2Level1: TcxGridLevel
        GridView = dxDBGridSN2DBBandedTableView1
      end
    end
  end
  inherited DriverABM: TDriverABM
    CargaDataSets = <
      item
        DataSet = TFiltros
        TableName = 'TFiltros'
      end
      item
        DataSet = TAcciones
        TableName = 'TAcciones'
      end
      item
        DataSet = TConsultaDesarrollo
        TableName = 'TConsultaDesarrollo'
      end
      item
        DataSet = TColNov
        TableName = 'TColNov'
      end>
  end
  inherited TOidObjSave: TsnTable
    Left = 800
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
    OnDblClick = <
      item
        CompoName = 'dxDBGridSN2DBBandedTableView1'
        Source.Strings = (
          'begin'
          '  if ((dxDBGridSN2.getSelectedFieldName()='#39'fec_eval_desemp'#39') OR '
          '     (dxDBGridSN2.getSelectedFieldName()='#39'desc_evaluacion'#39') OR'
          '     (dxDBGridSN2.getSelectedFieldName()='#39'evaluacion'#39'))'
          '     then begin'
          
            '              if (TConsultaDesarrollo.FieldName('#39'oid_eval_desemp' +
            #39').AsInteger<=0) then exit;'
          '              formConsEval.ventana := getVentana();'
          '              formConsEval.setString('#39'OPEN_BY_ID'#39','#39#39');'
          
            '              formConsEval.setString('#39'oid_cco'#39',IntToStr(TConsult' +
            'aDesarrollo.FieldName('#39'oid_eval_desemp'#39').AsInteger));'
          '              formConsEval.Mostrar(false);              '
          '             end'
          
            '  else    if ((dxDBGridSN2.getSelectedFieldName()='#39'fec_eval_pot'#39 +
            ') OR '
          
            '                   (dxDBGridSN2.getSelectedFieldName()='#39'desc_eva' +
            'luacion_pot'#39') OR'
          
            '                   (dxDBGridSN2.getSelectedFieldName()='#39'evaluaci' +
            'on_pot'#39') OR'
          
            '                   (dxDBGridSN2.getSelectedFieldName()='#39'puesto_e' +
            'val_pot'#39')'
          '                   )'
          '                   then begin'
          
            '                           if (TConsultaDesarrollo.FieldName('#39'oi' +
            'd_eval_poten'#39').AsInteger<=0)  then exit;'
          
            '                           formConsEvalPot.ventana := getVentana' +
            '();'
          
            '                           formConsEvalPot.setString('#39'OPEN_BY_ID' +
            #39','#39#39');'
          
            '                           formConsEvalPot.setString('#39'oid_cco'#39',I' +
            'ntToStr(TConsultaDesarrollo.FieldName('#39'oid_eval_poten'#39').AsIntege' +
            'r));'
          
            '                           formConsEvalPot.Mostrar(false);      ' +
            '        '
          '                           end'
          '                   else begin'
          
            '                          if (TConsultaDesarrollo.FieldName('#39'oid' +
            '_legajo'#39').AsInteger<=0) then exit;'
          
            '                           formConsLegajo.ventana := getVentana(' +
            ');'
          
            '                           formConsLegajo.setString('#39'OPEN_BY_ID'#39 +
            ','#39#39');'
          
            '                           formConsLegajo.setString('#39'oid_cco'#39',In' +
            'tToStr(TConsultaDesarrollo.FieldName('#39'oid_legajo'#39').AsInteger));'
          '                           formConsLegajo.Mostrar(false);'
          '                          end; '
          ''
          ''
          ''
          'end.')
      end>
    OnInicializar = <
      item
        Source.Strings = (
          'begin'
          '      dxDBGridSN2.ActivarEventoPintarCeldas();'
          '      varios.setImagen('#39'ImageSalir'#39',7);'
          '      TInput.loadFromAllData(getParamValue('#39'TInput'#39'));'
          
            '      TAccionesCronograma.loadFromAllData(getParamValue('#39'TAccion' +
            'esCronograma'#39'));'
          '       TraerSugerencia();'
          '       setColCantNov();'
          '  '
          'end.')
      end>
    OnFormFunction = <
      item
        Source.Strings = (
          'procedure TraerSugerencia();'
          'begin'
          '      operacion.InicioOperacion();'
          '      operacion.setOper('#39'TraerPropuRecateg'#39');'
          '      operacion.addDataSet(TInput.getDataSet());'
          '      operacion.AddDataSet(TAccionesCronograma.getDataSet());'
          '      operacion.execute(); '
          'end;'
          ''
          'procedure setColCantNov();'
          'var'
          '  i  : integer;'
          'begin'
          '  for i:=1 to 10 do'
          '    begin'
          '    if (TColNov.FieldName('#39'titulo_'#39'+IntToStr(i)).AsString<>'#39#39') '
          '        then BEGIN'
          
            '                dxDBGridSN2.setColumnaVisible('#39'cant_nov_'#39'+IntToS' +
            'tr(i),true);'
          
            '                dxDBGridSN2.setCaptionColumn( '#39'cant_nov_'#39'+IntToS' +
            'tr(i),TColNov.FieldName('#39'titulo_'#39'+IntToStr(i)).AsString);'
          '                END'
          
            '        else dxDBGridSN2.setColumnaVisible('#39'cant_nov_'#39'+IntToStr(' +
            'i),false);'
          '    end;'
          'end;'
          ''
          'procedure EjecutarCompoCalif();'
          'begin'
          ''
          ''
          '  TFiltros.EditRecord;'
          
            '  TFiltros.FieldName('#39'oid_legajo'#39').AsInteger := TConsultaDesarro' +
            'llo.FieldName('#39'oid_legajo'#39').AsInteger;'
          
            '  TFiltros.FieldName('#39'oid_accion'#39').AsInteger := TConsultaDesarro' +
            'llo.FieldName('#39'oid_accion'#39').AsInteger;'
          '  TFiltros.PostRecord;'
          '  '
          '  variable.newVariantArray('#39'parametros'#39',1);'
          
            '  variable.addKeyTableForArray('#39'parametros'#39',0,'#39'TFiltros'#39','#39'TFiltr' +
            'os'#39');  '
          '  FormConsCompoCalif.params :=  variable.getValue('#39'parametros'#39');'
          '  FormConsCompoCalif.Ventana := getVentana();'
          '  FormConsCompoCalif.Mostrar(false);'
          ''
          'end;'
          '')
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
        ButtonName = 'BotonCompoDet'
        Source.Strings = (
          'begin'
          '   // Ver detalle composici'#243'n'
          '  EjecutarCompoCalif();'
          'end.')
      end>
  end
  inherited SaveArchivo: TSaveDialog
    Left = 376
    Top = 224
  end
  inherited ImprimirObjetoSeleccionado: TdxComponentPrinter
    Top = 208
    inherited ImprimirObjetoSeleccionadodxComponentPrinterLink: TdxGridReportLink
      BuiltInReportLink = True
    end
  end
  inherited TTempVarForm: TsnTable
    Top = 296
  end
  object Varios: TsnVarios
    Operacion = Operacion
    Left = 672
    Top = 76
  end
  object TInput: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'oid_cronograma'
        DataType = ftInteger
      end
      item
        Name = 'mes'
        DataType = ftString
        Size = 10
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
    Left = 568
    Top = 207
    object TInputoid_cronograma: TIntegerField
      FieldName = 'oid_cronograma'
    end
    object TInputmes: TStringField
      FieldName = 'mes'
      Size = 10
    end
    object TInputanio: TIntegerField
      FieldName = 'anio'
    end
  end
  object TAccionesCronograma: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'oid_cronograma'
        DataType = ftInteger
      end
      item
        Name = 'oid_accion'
        DataType = ftInteger
      end
      item
        Name = 'descripcion'
        DataType = ftString
        Size = 1000
      end
      item
        Name = 'seleccionar'
        DataType = ftBoolean
      end>
    IndexFieldNames = 'oid_cronograma'
    IndexDefs = <
      item
        Name = 'TAccionesCronogramaIndex1'
        Fields = 'oid_cronograma'
      end>
    RecalcOnFetch = False
    SortOptions = []
    PersistentBackup = False
    ProgressFlags = [mtpcLoad, mtpcSave, mtpcCopy]
    VersioningMode = mtvmAllSinceCheckPoint
    FilterOptions = []
    MasterFields = 'oid_cronograma'
    Version = '4.08b'
    LanguageID = 0
    SortID = 0
    SubLanguageID = 1
    LocaleID = 1024
    MensajeValorDuplicadoIndice = 'Valor Duplicado'
    Left = 568
    Top = 247
    object TAccionesCronogramaoid_cronograma: TIntegerField
      FieldName = 'oid_cronograma'
    end
    object TAccionesCronogramaoid_accion: TIntegerField
      FieldName = 'oid_accion'
    end
    object TAccionesCronogramadescripcion: TStringField
      FieldName = 'descripcion'
      Size = 1000
    end
    object TAccionesCronogramaseleccionar: TBooleanField
      FieldName = 'seleccionar'
    end
  end
  object TFiltros: TsnTable
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
    Left = 104
    Top = 17
    object TFiltrosoid_cronograma: TIntegerField
      FieldName = 'oid_cronograma'
    end
    object TFiltrosdesc_cronograma: TStringField
      FieldName = 'desc_cronograma'
      Size = 100
    end
    object TFiltrosmes: TStringField
      FieldName = 'mes'
      Size = 100
    end
    object TFiltrosacciones: TStringField
      FieldName = 'acciones'
      Size = 4000
    end
    object TFiltrosoid_legajo: TIntegerField
      FieldName = 'oid_legajo'
    end
    object TFiltrosoid_accion: TIntegerField
      FieldName = 'oid_accion'
    end
    object TFiltroscodigo_mes: TStringField
      FieldName = 'codigo_mes'
      Size = 10
    end
    object TFiltrosanio: TIntegerField
      FieldName = 'anio'
    end
  end
  object DSFiltros: TDataSource
    DataSet = TFiltros
    Left = 136
    Top = 17
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
    Left = 104
    Top = 55
    object TAccionesaccion: TStringField
      FieldName = 'accion'
      Size = 100
    end
  end
  object DSAcciones: TDataSource
    DataSet = TAcciones
    Left = 136
    Top = 55
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
      AssignedValues = [svFont, svTextColor]
      Font.Charset = ANSI_CHARSET
      Font.Color = clBlue
      Font.Height = -16
      Font.Name = 'Verdana'
      Font.Style = []
      TextColor = clDefault
    end
    object cxStyle3: TcxStyle
      AssignedValues = [svFont, svTextColor]
      Font.Charset = DEFAULT_CHARSET
      Font.Color = clBlue
      Font.Height = -11
      Font.Name = 'MS Sans Serif'
      Font.Style = []
      TextColor = 33023
    end
  end
  object TConsultaDesarrollo: TsnTable
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
    Left = 112
    Top = 254
    object TConsultaDesarrollooid_cronograma: TIntegerField
      FieldName = 'oid_cronograma'
    end
    object TConsultaDesarrollodesc_cronograma: TStringField
      FieldName = 'desc_cronograma'
      Size = 100
    end
    object TConsultaDesarrollooid_accion: TIntegerField
      FieldName = 'oid_accion'
    end
    object TConsultaDesarrollodesc_accion: TStringField
      FieldName = 'desc_accion'
      Size = 500
    end
    object TConsultaDesarrollooid_legajo: TIntegerField
      FieldName = 'oid_legajo'
    end
    object TConsultaDesarrollolegajo: TStringField
      FieldName = 'legajo'
      Size = 50
    end
    object TConsultaDesarrolloapellido: TStringField
      FieldName = 'apellido'
      Size = 100
    end
    object TConsultaDesarrollonombre: TStringField
      FieldName = 'nombre'
      Size = 100
    end
    object TConsultaDesarrollofec_ingreso: TDateField
      FieldName = 'fec_ingreso'
    end
    object TConsultaDesarrollooid_val_clasif_emp: TIntegerField
      FieldName = 'oid_val_clasif_emp'
    end
    object TConsultaDesarrollodesc_val_clasif_emp: TStringField
      FieldName = 'desc_val_clasif_emp'
      Size = 100
    end
    object TConsultaDesarrollooid_val_clasif_sec: TIntegerField
      FieldName = 'oid_val_clasif_sec'
    end
    object TConsultaDesarrollodesc_val_clasif_sec: TStringField
      FieldName = 'desc_val_clasif_sec'
      Size = 100
    end
    object TConsultaDesarrollooid_val_clasif_pue: TIntegerField
      FieldName = 'oid_val_clasif_pue'
    end
    object TConsultaDesarrollodesc_val_clasif_pue: TStringField
      FieldName = 'desc_val_clasif_pue'
      Size = 100
    end
    object TConsultaDesarrollocant_juegos_a: TIntegerField
      FieldName = 'cant_juegos_a'
    end
    object TConsultaDesarrollocant_juegos_b: TIntegerField
      FieldName = 'cant_juegos_b'
    end
    object TConsultaDesarrollooid_categ_posible: TIntegerField
      FieldName = 'oid_categ_posible'
    end
    object TConsultaDesarrollodesc_categ_posible: TStringField
      FieldName = 'desc_categ_posible'
      Size = 100
    end
    object TConsultaDesarrolloant_ingreso: TStringField
      FieldName = 'ant_ingreso'
      Size = 50
    end
    object TConsultaDesarrollofec_ant_puesto: TDateField
      FieldName = 'fec_ant_puesto'
    end
    object TConsultaDesarrolloant_puesto: TStringField
      FieldName = 'ant_puesto'
      Size = 50
    end
    object TConsultaDesarrolloevaluacion: TFloatField
      FieldName = 'evaluacion'
    end
    object TConsultaDesarrollodesc_evaluacion: TStringField
      FieldName = 'desc_evaluacion'
      Size = 100
    end
    object TConsultaDesarrolloranking: TFloatField
      FieldName = 'ranking'
    end
    object TConsultaDesarrolloaprobado: TStringField
      DisplayWidth = 4
      FieldName = 'aprobado'
      Size = 4
    end
    object TConsultaDesarrollomot_no_aprob: TMemoField
      FieldName = 'mot_no_aprob'
      BlobType = ftMemo
    end
    object TConsultaDesarrollocant_nov_1: TIntegerField
      FieldName = 'cant_nov_1'
    end
    object TConsultaDesarrollocant_nov_2: TIntegerField
      FieldName = 'cant_nov_2'
    end
    object TConsultaDesarrollocant_nov_3: TIntegerField
      FieldName = 'cant_nov_3'
    end
    object TConsultaDesarrollocant_nov_4: TIntegerField
      FieldName = 'cant_nov_4'
    end
    object TConsultaDesarrollocant_nov_5: TIntegerField
      FieldName = 'cant_nov_5'
    end
    object TConsultaDesarrollocant_nov_6: TIntegerField
      FieldName = 'cant_nov_6'
    end
    object TConsultaDesarrollocant_nov_7: TIntegerField
      FieldName = 'cant_nov_7'
    end
    object TConsultaDesarrollocant_nov_8: TIntegerField
      FieldName = 'cant_nov_8'
    end
    object TConsultaDesarrollocant_nov_9: TIntegerField
      FieldName = 'cant_nov_9'
    end
    object TConsultaDesarrollocant_nov_10: TIntegerField
      FieldName = 'cant_nov_10'
    end
    object TConsultaDesarrollohoras_acum: TIntegerField
      FieldName = 'horas_acum'
    end
    object TConsultaDesarrollocant_min_juegos_a: TIntegerField
      FieldName = 'cant_min_juegos_a'
    end
    object TConsultaDesarrollotiempo_hor_carrera: TStringField
      FieldName = 'tiempo_hor_carrera'
      Size = 50
    end
    object TConsultaDesarrollodif_meses_hc: TIntegerField
      FieldName = 'dif_meses_hc'
    end
    object TConsultaDesarrolloantiguedad_sector: TStringField
      FieldName = 'antiguedad_sector'
      Size = 50
    end
    object TConsultaDesarrolloant_sec_meses: TIntegerField
      FieldName = 'ant_sec_meses'
    end
    object TConsultaDesarrollofec_eval_desemp: TDateField
      FieldName = 'fec_eval_desemp'
    end
    object TConsultaDesarrolloevaluacion_pot: TFloatField
      FieldName = 'evaluacion_pot'
    end
    object TConsultaDesarrollodesc_evaluacion_pot: TStringField
      FieldName = 'desc_evaluacion_pot'
      Size = 100
    end
    object TConsultaDesarrollofec_eval_pot: TDateField
      FieldName = 'fec_eval_pot'
    end
    object TConsultaDesarrollopuesto_eval_pot: TStringField
      FieldName = 'puesto_eval_pot'
      Size = 255
    end
    object TConsultaDesarrollofec_irl: TDateField
      FieldName = 'fec_irl'
    end
    object TConsultaDesarrolloresult_irl: TStringField
      FieldName = 'result_irl'
    end
    object TConsultaDesarrolloobs_irl: TMemoField
      FieldName = 'obs_irl'
      BlobType = ftMemo
    end
    object TConsultaDesarrollopend_realizar_eval_des: TStringField
      FieldName = 'pend_realizar_eval_des'
      Size = 2
    end
    object TConsultaDesarrollopend_realizar_eval_pot: TStringField
      FieldName = 'pend_realizar_eval_pot'
      Size = 2
    end
    object TConsultaDesarrollopend_realizar_irl: TStringField
      FieldName = 'pend_realizar_irl'
      Size = 2
    end
    object TConsultaDesarrollopend_realizar_carga_ja: TStringField
      FieldName = 'pend_realizar_carga_ja'
      Size = 2
    end
    object TConsultaDesarrollooid_eval_desemp: TIntegerField
      FieldName = 'oid_eval_desemp'
    end
    object TConsultaDesarrollooid_eval_poten: TIntegerField
      FieldName = 'oid_eval_poten'
    end
    object TConsultaDesarrolloclase_sindicato: TStringField
      FieldName = 'clase_sindicato'
      Size = 100
    end
  end
  object DSTConsultaDesarrollo: TDataSource
    DataSet = TConsultaDesarrollo
    Left = 144
    Top = 246
  end
  object TColNov: TsnTable
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
    Left = 272
    Top = 474
    object TColNovnro_col_1: TIntegerField
      FieldName = 'nro_col_1'
    end
    object TColNovnro_col_2: TIntegerField
      FieldName = 'nro_col_2'
    end
    object TColNovnro_col_3: TIntegerField
      FieldName = 'nro_col_3'
    end
    object TColNovnro_col_4: TIntegerField
      FieldName = 'nro_col_4'
    end
    object TColNovnro_col_5: TIntegerField
      FieldName = 'nro_col_5'
    end
    object TColNovnro_col_6: TIntegerField
      FieldName = 'nro_col_6'
    end
    object TColNovnro_col_7: TIntegerField
      FieldName = 'nro_col_7'
    end
    object TColNovnro_col_8: TIntegerField
      FieldName = 'nro_col_8'
    end
    object TColNovnro_col_9: TIntegerField
      FieldName = 'nro_col_9'
    end
    object TColNovnro_col_10: TIntegerField
      FieldName = 'nro_col_10'
    end
    object TColNovtitulo_1: TStringField
      FieldName = 'titulo_1'
      Size = 100
    end
    object TColNovtitulo_2: TStringField
      FieldName = 'titulo_2'
      Size = 100
    end
    object TColNovtitulo_3: TStringField
      FieldName = 'titulo_3'
      Size = 100
    end
    object TColNovtitulo_4: TStringField
      FieldName = 'titulo_4'
      Size = 100
    end
    object TColNovtitulo_5: TStringField
      FieldName = 'titulo_5'
      Size = 100
    end
    object TColNovtitulo_6: TStringField
      FieldName = 'titulo_6'
      Size = 100
    end
    object TColNovtitulo_7: TStringField
      FieldName = 'titulo_7'
      Size = 100
    end
    object TColNovtitulo_8: TStringField
      FieldName = 'titulo_8'
      Size = 100
    end
    object TColNovtitulo_9: TStringField
      FieldName = 'titulo_9'
      Size = 100
    end
    object TColNovtitulo_10: TStringField
      FieldName = 'titulo_10'
    end
  end
  object FormComposicionCalif: TFormulario
    Nombre = 'TFConsPlanDesa'
    CreateAlwaysANewForm = True
    Left = 224
    Top = 278
  end
  object FormConsCompoCalif: TFormulario
    Nombre = 'TFComposiCalif'
    CreateAlwaysANewForm = True
    Left = 344
    Top = 310
  end
  object formConsLegajo: TFormulario
    AutoLiberar = True
    Nombre = 'TFLegajos'
    TipoForm = tipoFormABM
    CreateAlwaysANewForm = True
    Left = 490
    Top = 261
  end
  object formConsEval: TFormulario
    AutoLiberar = True
    Nombre = 'TFCargaEvalLeg'
    TipoForm = tipoFormABM
    CreateAlwaysANewForm = True
    Left = 490
    Top = 212
  end
  object formConsEvalPot: TFormulario
    AutoLiberar = True
    Nombre = 'TFCargaEvalPot'
    TipoForm = tipoFormABM
    CreateAlwaysANewForm = True
    Left = 442
    Top = 212
  end
end
