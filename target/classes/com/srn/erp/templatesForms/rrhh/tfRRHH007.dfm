inherited FEvalLegajos: TFEvalLegajos
  Left = 91
  Top = 160
  Height = 667
  Caption = 'Evaluaciones'
  PixelsPerInch = 96
  TextHeight = 13
  object Panel1: TPanel [0]
    Left = 0
    Top = 0
    Width = 779
    Height = 50
    Align = alTop
    Color = clWindow
    TabOrder = 0
    object ImageSalir: TImage
      Tag = 7
      Left = 14
      Top = 9
      Width = 32
      Height = 32
      Cursor = crHandPoint
      Hint = 'Salir'
      ParentShowHint = False
      ShowHint = True
    end
    object Label1: TLabel
      Left = 64
      Top = 8
      Width = 590
      Height = 16
      Caption = 
        'Evaluaciones (Haga doble click sobre una celda de puntaje para v' +
        'isualizar la Evaluaci'#243'n) '
      Font.Charset = ANSI_CHARSET
      Font.Color = clNavy
      Font.Height = -13
      Font.Name = 'Verdana'
      Font.Style = []
      ParentFont = False
    end
    object Label2: TLabel
      Left = 64
      Top = 25
      Width = 478
      Height = 16
      Caption = 
        '                  (Haga doble click sobre el legajo para visuali' +
        'zar sus datos)'
      Font.Charset = ANSI_CHARSET
      Font.Color = clNavy
      Font.Height = -13
      Font.Name = 'Verdana'
      Font.Style = []
      ParentFont = False
    end
  end
  object Panel2: TPanel [1]
    Left = 0
    Top = 50
    Width = 779
    Height = 538
    Align = alClient
    Color = clWindow
    TabOrder = 1
    object dxGrillaEvaluaciones: TdxDBGridSN
      Left = 1
      Top = 1
      Width = 777
      Height = 536
      Align = alClient
      TabOrder = 0
      LookAndFeel.Kind = lfFlat
      AllowInsert = False
      CriteriosPintarCelda = <>
      object dxGrillaEvaluacionesDBTableViewRequisiciones: TcxGridDBTableView
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
      object dxGrillaEvaluacionesBandedTableView1: TcxGridBandedTableView
        NavigatorButtons.ConfirmDelete = False
        DataController.Summary.DefaultGroupSummaryItems = <>
        DataController.Summary.FooterSummaryItems = <>
        DataController.Summary.SummaryGroups = <>
        Bands = <
          item
          end>
      end
      object dxGrillaEvaluacionesDBBandedTableView: TcxGridDBBandedTableView
        NavigatorButtons.ConfirmDelete = False
        DataController.DataSource = DSConsEvaluaciones
        DataController.Options = [dcoAssignGroupingValues, dcoAssignMasterDetailKeys, dcoSaveExpanding, dcoGroupsAlwaysExpanded]
        DataController.Summary.DefaultGroupSummaryItems = <>
        DataController.Summary.FooterSummaryItems = <>
        DataController.Summary.SummaryGroups = <>
        OptionsBehavior.FocusCellOnTab = True
        OptionsBehavior.FocusFirstCellOnNewRecord = True
        OptionsBehavior.FocusCellOnCycle = True
        OptionsData.CancelOnExit = False
        OptionsData.Deleting = False
        OptionsData.DeletingConfirmation = False
        OptionsData.Editing = False
        OptionsData.Inserting = False
        OptionsSelection.InvertSelect = False
        OptionsView.GroupFooters = gfAlwaysVisible
        Styles.ContentOdd = cxStyle4
        Bands = <
          item
            Caption = 'Legajos'
            FixedKind = fkLeft
            Width = 581
          end>
        object dxGrillaEvaluacionesDBBandedTableViewempresa: TcxGridDBBandedColumn
          Caption = 'Empresa'
          DataBinding.FieldName = 'empresa'
          Visible = False
          GroupIndex = 0
          Position.BandIndex = 0
          Position.ColIndex = 0
          Position.RowIndex = 0
        end
        object dxGrillaEvaluacionesDBBandedTableViewsector: TcxGridDBBandedColumn
          Caption = 'Sector'
          DataBinding.FieldName = 'sector'
          Visible = False
          GroupIndex = 1
          Position.BandIndex = 0
          Position.ColIndex = 1
          Position.RowIndex = 0
        end
        object dxGrillaEvaluacionesDBBandedTableViewlegajo: TcxGridDBBandedColumn
          Caption = 'Legajo'
          DataBinding.FieldName = 'legajo'
          HeaderAlignmentHorz = taCenter
          Width = 51
          Position.BandIndex = 0
          Position.ColIndex = 2
          Position.RowIndex = 0
        end
        object dxGrillaEvaluacionesDBBandedTableViewape_y_nom: TcxGridDBBandedColumn
          Caption = 'Apellido y Nombre'
          DataBinding.FieldName = 'ape_y_nom'
          HeaderAlignmentHorz = taCenter
          Width = 262
          Position.BandIndex = 0
          Position.ColIndex = 3
          Position.RowIndex = 0
        end
        object dxGrillaEvaluacionesDBBandedTableViewpuesto: TcxGridDBBandedColumn
          Caption = 'Puesto'
          DataBinding.FieldName = 'puesto'
          HeaderAlignmentHorz = taCenter
          Width = 181
          Position.BandIndex = 0
          Position.ColIndex = 4
          Position.RowIndex = 0
        end
        object dxGrillaEvaluacionesDBBandedTableViewestado: TcxGridDBBandedColumn
          Caption = 'Estado'
          DataBinding.FieldName = 'estado'
          HeaderAlignmentHorz = taCenter
          Width = 53
          Position.BandIndex = 0
          Position.ColIndex = 5
          Position.RowIndex = 0
        end
      end
      object dxGrillaEvaluacionesLevel1: TcxGridLevel
        GridView = dxGrillaEvaluacionesDBBandedTableView
      end
    end
  end
  object Panel3: TPanel [2]
    Left = 0
    Top = 588
    Width = 779
    Height = 41
    Align = alBottom
    Color = clWindow
    TabOrder = 2
  end
  inherited DriverABM: TDriverABM
    CargaDataSets = <
      item
        DataSet = TConsEvaluaciones
        TableName = 'TConsEvaluaciones'
      end
      item
        DataSet = TColumnasEvaluaciones
        TableName = 'TColumnasEvaluaciones'
      end
      item
        DataSet = TBandasEvaluaciones
        TableName = 'TBandasEvaluaciones'
      end
      item
        DataSet = TEvalCelda
        TableName = 'TEvalCelda'
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
    OnDblClick = <
      item
        CompoName = 'dxGrillaEvaluacionesDBBandedTableView'
        Source.Strings = (
          'begin'
          
            '  if ((dxGrillaEvaluaciones.getSelectedFieldName()='#39'legajo'#39') OR ' +
            '(dxGrillaEvaluaciones.getSelectedFieldName()='#39'ape_y_nom'#39'))'
          '     then  irAConsLegajo()'
          '     else irAEvaluacion();'
          'end.')
      end>
    OnInicializar = <
      item
        Source.Strings = (
          'begin'
          '   varios.setImagen('#39'ImageSalir'#39',7);'
          '  Tinput.loadFromAllData(getParamValue('#39'Tinput'#39'));'
          
            '  TSelEvaluaciones.loadFromAllData(getParamValue('#39'TSelEvaluacion' +
            'es'#39'));'
          '  TSelLegajos.loadFromAllData(getParamValue('#39'TSelLegajos'#39'));'
          '  TSelEmpresas.loadFromAllData(getParamValue('#39'TSelEmpresas'#39'));'
          '  TSelSector.loadFromAllData(getParamValue('#39'TSelSector'#39'));'
          '  TSelPuesto.loadFromAllData(getParamValue('#39'TSelPuesto'#39'));'
          '  TSelEstado.loadFromAllData(getParamValue('#39'TSelEstado'#39'));'
          '   '
          '  TraerEstructura();'
          '  '
          '  armarColDinamicas();'
          ''
          '  CrearVista();'
          ''
          '  setFormato();'
          ''
          '  '
          '  EjecutarConsulta();'
          ''
          '  setAnchoBandas();'
          ''
          '  setFormato();'
          ''
          'end.')
      end>
    OnFormFunction = <
      item
        Source.Strings = (
          'procedure TraerEstructura();'
          'begin'
          '  operacion.inicioOperacion;'
          '  operacion.setOper('#39'TraerConsultaEvaluaciones'#39');'
          '  operacion.addAtribute('#39'estructura'#39','#39#39');'
          '  operacion.AddDataSet(Tinput.getDataSet());'
          '  operacion.AddDataSet(TSelEvaluaciones.getDataSet());'
          '  operacion.execute();'
          'end;'
          ''
          'procedure EjecutarConsulta();'
          'begin'
          ''
          '  dxGrillaEvaluaciones.setDataSource(nil);'
          ''
          '  try'
          ''
          '    operacion.inicioOperacion;'
          '    operacion.setOper('#39'TraerConsultaEvaluaciones'#39');'
          '    operacion.addAtribute('#39'consulta'#39','#39#39');'
          '    operacion.AddDataSet(Tinput.getDataSet());'
          '    operacion.AddDataSet(TSelEvaluaciones.getDataSet());'
          '    operacion.AddDataSet(TSelLegajos.getDataSet());'
          '    operacion.AddDataSet(TSelEmpresas.getDataSet());'
          '    operacion.AddDataSet(TSelSector.getDataSet());'
          '    operacion.AddDataSet(TSelPuesto.getDataSet());'
          '    operacion.AddDataSet(TSelEstado.getDataSet());'
          '    operacion.AddDataSet(TColumnasEvaluaciones.getDataSet());'
          '    operacion.execute();'
          ''
          '  finally'
          ''
          
            '  dxGrillaEvaluaciones.setDataSourceByName('#39'DSConsEvaluaciones'#39')' +
            ';'
          ''
          '  end;'
          ''
          '  dxGrillaEvaluaciones.gotoFirstRecord;'
          ''
          'end;'
          ''
          ''
          'procedure armarColDinamicas();'
          'var'
          '  col                     : TColumnaGrilla ;'
          ' BandaDBGrilla : TBandaDBGrilla;'
          'begin'
          ''
          '  TBandasEvaluaciones.First;'
          '  while (not TBandasEvaluaciones.eof) do'
          '     begin'
          
            '     BandaDBGrilla := dxGrillaEvaluaciones.createBand('#39'BANDA'#39'+TB' +
            'andasEvaluaciones.FieldName('#39'oid_mod_eval_cab'#39').AsString); '
          
            '     BandaDBGrilla.setCaption(TBandasEvaluaciones.FieldName('#39'tit' +
            'ulo'#39').AsString);'
          '     BandaDBGrilla.setWidth(100);'
          '     TBandasEvaluaciones.next;'
          '     end;'
          ' '
          '  TColumnasEvaluaciones.First;'
          '  while (not TColumnasEvaluaciones.eof) do'
          '     begin'
          '           '
          
            '     col := dxGrillaEvaluaciones.nuevaColumna(TColumnasEvaluacio' +
            'nes.FieldName('#39'campo_puntaje'#39').AsString,TColumnasEvaluaciones.Fi' +
            'eldName('#39'titulo'#39').AsString) ;'
          '     col.setWidth(80);'
          
            '     col.setBandIndex(TColumnasEvaluaciones.FieldName('#39'banda'#39').A' +
            'sInteger);'
          '     col.Format :='#39'###,###,###.##'#39'; '
          ''
          '     if (TInput.FieldName('#39'ver_promedio'#39').AsBoolean)'
          '        then begin'
          '                col.setAvgGroupFooter();'
          '                col.GroupFooterFormat := '#39'###,###,###.##'#39';'
          '                end;'
          ''
          ''
          '     TColumnasEvaluaciones.next;'
          '     end;'
          ''
          'end;'
          ''
          'procedure CrearVista();'
          'begin'
          '  TConsEvaluaciones.Close;'
          '  TConsEvaluaciones.Reset;'
          '  TConsEvaluaciones.AddStringField('#39'empresa'#39',100);'
          '  TConsEvaluaciones.AddStringField('#39'sector'#39',100);'
          '  TConsEvaluaciones.AddIntegerField('#39'oid_legajo'#39');'
          '  TConsEvaluaciones.AddStringField('#39'legajo'#39',100);'
          '  TConsEvaluaciones.AddStringField('#39'ape_y_nom'#39',100);'
          '  TConsEvaluaciones.AddStringField('#39'puesto'#39',100);'
          '  TConsEvaluaciones.AddStringField('#39'estado'#39',100);'
          '  TColumnasEvaluaciones.First;'
          '  while (not TColumnasEvaluaciones.EOF) do'
          '    begin'
          ''
          
            '    TConsEvaluaciones.AddCurrencyField(TColumnasEvaluaciones.Fie' +
            'ldName('#39'campo_puntaje'#39').AsString);'
          ''
          '    TColumnasEvaluaciones.Next;'
          '    end;'
          ''
          ''
          '    '
          '   TConsEvaluaciones.Open;'
          '  '
          'end;  '
          ''
          ''
          'procedure setFormato();'
          'var'
          '  i , j : integer;'
          'begin'
          '  j := TConsEvaluaciones.getCountFields();'
          '    for i:=1 to j-1 do'
          '      begin'
          '      if (TConsEvaluaciones.isCurrencyField(i))'
          
            '          then TConsEvaluaciones.setFormatCurrency(i,'#39'###,###,##' +
            '#,###,###.##'#39');'
          '      end;'
          ''
          'end;'
          ''
          ''
          'procedure setAnchoBandas();'
          'var'
          '  cantCol : integer;'
          'begin'
          '   TBandasEvaluaciones.First;'
          '   while (not TBandasEvaluaciones.EOF) do'
          '       begin'
          '  '
          '       cantCol := 0;'
          '   '
          '       TColumnasEvaluaciones.First;'
          '       while (not TColumnasEvaluaciones.EOF) do'
          '          begin'
          ''
          
            '          if (TBandasEvaluaciones.FieldName('#39'banda'#39').AsInteger =' +
            '  TColumnasEvaluaciones.FieldName('#39'banda'#39').AsInteger)'
          '              then begin'
          '                      cantCol := cantCol + 1;'
          '                      end;'
          ''
          ''
          '          TColumnasEvaluaciones.next;'
          '          end;'
          ''
          
            '       dxGrillaEvaluaciones.setWidthBand(TBandasEvaluaciones.Fie' +
            'ldName('#39'banda'#39').AsInteger,80*cantCol);'
          ''
          '       '
          '       TBandasEvaluaciones.next;'
          '       end;'
          'end;'
          ''
          'procedure irAEvaluacion();'
          'begin'
          ''
          '  if (TConsEvaluaciones.FieldName('#39'oid_legajo'#39').AsInteger<=0)'
          
            '      then raiseException(erCustomError,'#39'Debe seleccionar un Leg' +
            'ajo'#39');'
          ''
          '  operacion.InicioOperacion();'
          '  operacion.setOper('#39'VerEvaluacionCelda'#39');'
          
            '  operacion.AddAtribute('#39'oid_legajo'#39', TConsEvaluaciones.FieldNam' +
            'e('#39'oid_legajo'#39').AsString);'
          
            '  operacion.AddAtribute('#39'columna'#39', dxGrillaEvaluaciones.getSelec' +
            'tedFieldName());'
          '  operacion.execute();'
          ''
          '  if (TEvalCelda.IsEmpty())'
          
            '     then raiseException(erCustomError,'#39'No se pudo encontrar una' +
            ' evaluaci'#243'n para la celda seleccionada.'#39');'
          ''
          ''
          '  if (Tinput.FieldName('#39'tipo'#39').AsString = '#39'POTEN'#39' )'
          '      then begin'
          '              formConsEvalPot.ventana := getVentana();'
          '              formConsEvalPot.setString('#39'OPEN_BY_ID'#39','#39#39');'
          
            '              formConsEvalPot.setString('#39'oid_cco'#39',IntToStr(TEval' +
            'Celda.FieldName('#39'oid_evaluacion'#39').AsInteger));'
          '              formConsEvalPot.Mostrar(false);'
          '              end'
          '      else begin '
          '              formConsEval.ventana := getVentana();'
          '              formConsEval.setString('#39'OPEN_BY_ID'#39','#39#39');'
          
            '              formConsEval.setString('#39'oid_cco'#39',IntToStr(TEvalCel' +
            'da.FieldName('#39'oid_evaluacion'#39').AsInteger));'
          '              formConsEval.Mostrar(false);'
          '              end;'
          ''
          ''
          'end;'
          ''
          'procedure irAConsLegajo();'
          'begin'
          ''
          '  if (TConsEvaluaciones.FieldName('#39'oid_legajo'#39').AsInteger<=0)'
          
            '      then raiseException(erCustomError,'#39'Debe seleccionar un Leg' +
            'ajo'#39');'
          ''
          '  formConsLegajo.ventana := getVentana();'
          '  formConsLegajo.setString('#39'OPEN_BY_ID'#39','#39#39');'
          
            '  formConsLegajo.setString('#39'oid_cco'#39',IntToStr(TConsEvaluaciones.' +
            'FieldName('#39'oid_legajo'#39').AsInteger));'
          '  formConsLegajo.Mostrar(false);'
          ''
          'end;'
          ''
          ''
          ''
          ''
          '')
      end>
    OnAfterOpen = <
      item
        TableName = 'TConsEvaluaciones'
        Source.Strings = (
          'begin'
          'end.')
      end>
    OnClickToolButton = <
      item
        ButtonName = 'ImageSalir'
        Source.Strings = (
          'begin'
          '  Close();'
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
    Left = 672
    Top = 76
  end
  object TConsEvaluaciones: TsnTable
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
    Left = 148
    Top = 161
    object TConsEvaluacionesempresa: TStringField
      FieldName = 'empresa'
      Size = 100
    end
    object TConsEvaluacionessector: TStringField
      FieldName = 'sector'
      Size = 100
    end
    object TConsEvaluacionesoid_legajo: TIntegerField
      FieldName = 'oid_legajo'
    end
    object TConsEvaluacioneslegajo: TStringField
      FieldName = 'legajo'
      Size = 50
    end
    object TConsEvaluacionesape_y_nom: TStringField
      FieldName = 'ape_y_nom'
      Size = 100
    end
    object TConsEvaluacionespuesto: TStringField
      FieldName = 'puesto'
      Size = 100
    end
    object TConsEvaluacionesestado: TStringField
      FieldName = 'estado'
      Size = 100
    end
  end
  object DSConsEvaluaciones: TDataSource
    DataSet = TConsEvaluaciones
    Left = 184
    Top = 162
  end
  object Tinput: TsnTable
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
    Left = 24
    Top = 320
    object Tinputfec_eval_desde: TDateField
      FieldName = 'fec_eval_desde'
    end
    object Tinputfec_eval_hasta: TDateField
      FieldName = 'fec_eval_hasta'
    end
    object Tinputincluir_leg_sin_evaluar: TBooleanField
      FieldName = 'incluir_leg_sin_evaluar'
    end
    object Tinputver_puntaje: TBooleanField
      FieldName = 'ver_puntaje'
    end
    object Tinputver_grados: TBooleanField
      FieldName = 'ver_grados'
    end
    object Tinputver_porc_grados: TBooleanField
      FieldName = 'ver_porc_grados'
    end
    object Tinputver_punt_compe: TBooleanField
      FieldName = 'ver_punt_compe'
    end
    object Tinputver_promedio: TBooleanField
      FieldName = 'ver_promedio'
    end
    object Tinputtipo: TStringField
      FieldName = 'tipo'
    end
  end
  object TSelEvaluaciones: TsnTable
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
    Left = 72
    Top = 321
    object TSelEvaluacionessel: TBooleanField
      FieldName = 'sel'
    end
    object TSelEvaluacionesoid_mod_eval: TIntegerField
      FieldName = 'oid_mod_eval'
    end
    object TSelEvaluacionesdesc_mod_eval: TStringField
      FieldName = 'desc_mod_eval'
      Size = 100
    end
  end
  object TSelLegajos: TsnTable
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
    Left = 127
    Top = 321
    object BooleanField1: TBooleanField
      FieldName = 'sel'
    end
    object TSelLegajosoid_legajo: TIntegerField
      FieldName = 'oid_legajo'
    end
    object TSelLegajosnro_legajo: TStringField
      FieldName = 'nro_legajo'
      Size = 50
    end
    object TSelLegajosape_y_nom: TStringField
      FieldName = 'ape_y_nom'
      Size = 100
    end
  end
  object TSelEmpresas: TsnTable
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
    Left = 184
    Top = 321
    object BooleanField2: TBooleanField
      FieldName = 'sel'
    end
    object TSelEmpresasoid_empresa: TIntegerField
      FieldName = 'oid_empresa'
    end
    object TSelEmpresasrazon_social: TStringField
      FieldName = 'razon_social'
      Size = 100
    end
  end
  object TSelSector: TsnTable
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
    Left = 235
    Top = 321
    object BooleanField3: TBooleanField
      FieldName = 'sel'
    end
    object TSelSectoroid_sector: TIntegerField
      FieldName = 'oid_sector'
    end
    object TSelSectordescripcion: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
  end
  object TSelPuesto: TsnTable
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
    Left = 295
    Top = 321
    object BooleanField4: TBooleanField
      FieldName = 'sel'
    end
    object TSelPuestooid_puesto: TIntegerField
      FieldName = 'oid_puesto'
    end
    object StringField1: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
  end
  object TSelEstado: TsnTable
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
    Left = 348
    Top = 321
    object BooleanField5: TBooleanField
      FieldName = 'sel'
    end
    object TSelEstadooid_estado: TIntegerField
      FieldName = 'oid_estado'
    end
    object StringField2: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
  end
  object TColumnasEvaluaciones: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <>
    IndexFieldNames = 'orden'
    IndexDefs = <
      item
        Name = 'TColumnasEvaluacionesIndex1'
        Fields = 'orden'
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
    Left = 272
    Top = 434
    object TColumnasEvaluacionesorden: TIntegerField
      FieldName = 'orden'
    end
    object TColumnasEvaluacionescampo_puntaje: TStringField
      FieldName = 'campo_puntaje'
      Size = 100
    end
    object TColumnasEvaluacionestitulo: TStringField
      FieldName = 'titulo'
      Size = 100
    end
    object TColumnasEvaluacionesbanda: TIntegerField
      FieldName = 'banda'
    end
  end
  object TBandasEvaluaciones: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <>
    IndexFieldNames = 'orden'
    IndexDefs = <
      item
        Name = 'TBandasEvaluacionesIndex1'
        Fields = 'orden'
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
    Left = 400
    Top = 322
    object TBandasEvaluacionesorden: TIntegerField
      FieldName = 'orden'
    end
    object TBandasEvaluacionesoid_mod_eval_cab: TIntegerField
      FieldName = 'oid_mod_eval_cab'
    end
    object TBandasEvaluacionestitulo: TStringField
      FieldName = 'titulo'
      Size = 100
    end
    object TBandasEvaluacionesbanda: TIntegerField
      FieldName = 'banda'
    end
  end
  object TEvalCelda: TsnTable
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
    Left = 648
    Top = 186
    object TEvalCeldaoid_evaluacion: TIntegerField
      FieldName = 'oid_evaluacion'
    end
  end
  object formConsEval: TFormulario
    AutoLiberar = True
    Nombre = 'TFCargaEvalLeg'
    TipoForm = tipoFormABM
    CreateAlwaysANewForm = True
    Left = 490
    Top = 212
  end
  object formConsLegajo: TFormulario
    AutoLiberar = True
    Nombre = 'TFLegajos'
    TipoForm = tipoFormABM
    CreateAlwaysANewForm = True
    Left = 490
    Top = 261
  end
  object cxStyleRepository1: TcxStyleRepository
    PixelsPerInch = 96
    object cxStyle1: TcxStyle
    end
    object cxStyle2: TcxStyle
    end
    object cxStyle3: TcxStyle
    end
  end
  object cxStyleRepository2: TcxStyleRepository
    PixelsPerInch = 96
    object cxStyle4: TcxStyle
      AssignedValues = [svColor]
      Color = 12706047
    end
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
