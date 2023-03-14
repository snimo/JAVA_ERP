inherited FConsMasivaIndExc: TFConsMasivaIndExc
  Left = 111
  Top = 74
  Height = 627
  BorderIcons = [biSystemMenu]
  Caption = 'Consulta de Individuos'
  PixelsPerInch = 96
  TextHeight = 13
  object Panel1: TPanel [0]
    Left = 0
    Top = 0
    Width = 779
    Height = 41
    Align = alTop
    BevelOuter = bvNone
    Color = clWindow
    TabOrder = 0
    object snLabel5: TsnLabel
      Left = 168
      Top = 12
      Width = 457
      Height = 16
      Caption = 
        'Consulta de Individuos (Presione F12 para ir a la ficha de la pe' +
        'rsona)'
      Font.Charset = ANSI_CHARSET
      Font.Color = clMaroon
      Font.Height = -13
      Font.Name = 'Verdana'
      Font.Style = []
      ParentFont = False
    end
    object ImageBuscar: TImage
      Left = 31
      Top = 3
      Width = 32
      Height = 32
      Cursor = crHandPoint
      Hint = 'Presione F12 para Consultar Formulario de Individuo'
      ParentShowHint = False
      ShowHint = True
    end
    object ImageSalir: TImage
      Left = 119
      Top = 3
      Width = 32
      Height = 32
      Cursor = crHandPoint
      Hint = 'Salir'
      ParentShowHint = False
      ShowHint = True
    end
    object ImageImprimir: TImage
      Left = 75
      Top = 3
      Width = 32
      Height = 32
      Cursor = crHandPoint
      Hint = 'Vista Preliminar'
      ParentShowHint = False
      ShowHint = True
    end
    object snDBCheckEdit1: TsnDBCheckEdit
      Left = 637
      Top = 11
      Caption = 'Navegar por Ficha'
      DataBinding.DataField = 'navegar'
      DataBinding.DataSource = DSInput
      Properties.ImmediatePost = True
      TabOrder = 0
      Width = 121
    end
  end
  object Panel2: TPanel [1]
    Left = 0
    Top = 548
    Width = 779
    Height = 41
    Align = alBottom
    BevelOuter = bvNone
    Color = clWindow
    TabOrder = 1
    object snLabel2: TsnLabel
      Left = 24
      Top = 8
      Width = 162
      Height = 16
      Caption = 'Individuos Consultados'
      Font.Charset = DEFAULT_CHARSET
      Font.Color = clWindowText
      Font.Height = -13
      Font.Name = 'MS Sans Serif'
      Font.Style = [fsBold]
      ParentFont = False
    end
    object TraerProxReg: TsnLabel
      Left = 392
      Top = 8
      Width = 162
      Height = 16
      Cursor = crHandPoint
      Caption = '(F2) Traer los pr'#243'ximos'
      Font.Charset = DEFAULT_CHARSET
      Font.Color = clNavy
      Font.Height = -13
      Font.Name = 'MS Sans Serif'
      Font.Style = [fsBold, fsUnderline]
      ParentFont = False
    end
    object LabelTraerTodos: TsnLabel
      Left = 640
      Top = 8
      Width = 88
      Height = 16
      Cursor = crHandPoint
      Caption = 'Traer Todos'
      Font.Charset = DEFAULT_CHARSET
      Font.Color = clNavy
      Font.Height = -13
      Font.Name = 'MS Sans Serif'
      Font.Style = [fsBold, fsUnderline]
      ParentFont = False
    end
    object snLabel1: TsnLabel
      Left = 270
      Top = 8
      Width = 19
      Height = 16
      Caption = 'de'
      Font.Charset = DEFAULT_CHARSET
      Font.Color = clWindowText
      Font.Height = -13
      Font.Name = 'MS Sans Serif'
      Font.Style = [fsBold]
      ParentFont = False
    end
    object DBProxReg: TsnDBEdit
      Left = 560
      Top = 6
      DataBinding.DataField = 'cant_reg_lote'
      DataBinding.DataSource = DSControladorConsMas
      TabOrder = 0
      Width = 49
    end
    object snDBEdit2: TsnDBEdit
      Left = 192
      Top = 6
      TabStop = False
      DataBinding.DataField = 'cant_reg_cons'
      DataBinding.DataSource = DSControladorConsMas
      Properties.ReadOnly = True
      TabOrder = 1
      ReadOnlyAlways = True
      Width = 73
    end
    object snDBEdit3: TsnDBEdit
      Left = 296
      Top = 6
      TabStop = False
      DataBinding.DataField = 'cant_reg_totales'
      DataBinding.DataSource = DSControladorConsMas
      Properties.ReadOnly = True
      TabOrder = 2
      ReadOnlyAlways = True
      Width = 73
    end
  end
  object Panel3: TPanel [2]
    Left = 0
    Top = 41
    Width = 779
    Height = 507
    Align = alClient
    BevelOuter = bvNone
    BorderWidth = 5
    Color = clWindow
    TabOrder = 2
    object dxDBGridSN1: TdxDBGridSN
      Left = 5
      Top = 5
      Width = 769
      Height = 497
      Align = alClient
      TabOrder = 0
      AllowInsert = False
      CriteriosPintarCelda = <>
      object dxDBGridSN1DBCardView1: TcxGridDBCardView
        NavigatorButtons.ConfirmDelete = False
        NavigatorButtons.Insert.Enabled = False
        NavigatorButtons.Insert.Visible = False
        NavigatorButtons.Append.Enabled = False
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
        NavigatorButtons.Filter.Enabled = False
        NavigatorButtons.Filter.Visible = False
        FilterBox.CustomizeDialog = False
        DataController.DataSource = DSConsultaIndividuo
        DataController.Summary.DefaultGroupSummaryItems = <>
        DataController.Summary.FooterSummaryItems = <>
        DataController.Summary.SummaryGroups = <>
        Filtering.MRUItemsList = False
        Filtering.RowMRUItemsList = False
        LayoutDirection = ldVertical
        OptionsBehavior.FocusCellOnTab = True
        OptionsBehavior.FocusFirstCellOnNewRecord = True
        OptionsBehavior.IncSearch = True
        OptionsBehavior.ExpandRowOnDblClick = False
        OptionsCustomize.CardExpanding = True
        OptionsCustomize.LayeredRows = True
        OptionsCustomize.RowFiltering = False
        OptionsCustomize.RowHiding = True
        OptionsCustomize.RowMoving = True
        OptionsData.Deleting = False
        OptionsData.Editing = False
        OptionsData.Inserting = False
        OptionsSelection.HideFocusRectOnExit = False
        OptionsSelection.MultiSelect = True
        OptionsSelection.UnselectFocusedRecordOnExit = False
        OptionsView.Navigator = True
        OptionsView.NavigatorOffset = 5
        OptionsView.NoDataToDisplayInfoText = 'Sin Datos'
        OptionsView.CardAutoWidth = True
        OptionsView.CardWidth = 680
        OptionsView.CategoryIndent = 10
        OptionsView.CategorySeparatorWidth = 1
        OptionsView.CellAutoHeight = True
        RowLayout = rlVertical
        object dxDBGridSN1DBCardView1Row4: TcxGridDBCardViewRow
          DataBinding.FieldName = 'foto'
          PropertiesClassName = 'TcxImageProperties'
          Properties.GraphicClassName = 'TJPEGImage'
          Properties.ImmediatePost = True
          Properties.ReadOnly = True
          Properties.Stretch = True
          Options.Editing = False
          Options.Filtering = False
          Options.IncSearch = False
          Options.Expanding = False
          Position.BeginsLayer = True
          Position.LineCount = 9
          Position.Width = 200
          IsCaptionAssigned = True
        end
        object dxDBGridSN1DBCardView1Row17: TcxGridDBCardViewRow
          DataBinding.FieldName = 'obs_principal'
          Options.ShowCaption = False
          Position.BeginsLayer = False
          IsCaptionAssigned = True
        end
        object dxDBGridSN1DBCardView1Row2: TcxGridDBCardViewRow
          Caption = 'Datos Principales'
          Expanded = True
          Kind = rkCategory
          Options.Editing = False
          Position.BeginsLayer = True
          Position.Width = 270
        end
        object dxDBGridSN1DBCardView1desc_estado: TcxGridDBCardViewRow
          DataBinding.FieldName = 'desc_est_y_nro_reg'
          Options.Editing = False
          Options.ShowCaption = False
          Position.BeginsLayer = False
          Styles.Content = cxStyle2
          IsCaptionAssigned = True
        end
        object dxDBGridSN1DBCardView1Row16: TcxGridDBCardViewRow
          DataBinding.FieldName = 'venc_estado'
          Options.ShowCaption = False
          Position.BeginsLayer = False
          IsCaptionAssigned = True
        end
        object dxDBGridSN1DBCardView1Row20: TcxGridDBCardViewRow
          Caption = 'Motivo'
          DataBinding.FieldName = 'motivo'
          Options.ShowCaption = False
          Position.BeginsLayer = False
        end
        object dxDBGridSN1DBCardView1oid_individuo: TcxGridDBCardViewRow
          Caption = 'ID - Interno'
          DataBinding.FieldName = 'oid_individuo'
          Options.Editing = False
          Position.BeginsLayer = False
        end
        object dxDBGridSN1DBCardView1desc_tipo_docu: TcxGridDBCardViewRow
          Caption = 'Docu.'
          DataBinding.FieldName = 'desc_tipo_docu'
          Options.Editing = False
          Position.BeginsLayer = False
        end
        object dxDBGridSN1DBCardView1nro_documento: TcxGridDBCardViewRow
          Caption = 'Nro. Docu.'
          DataBinding.FieldName = 'nro_documento'
          Options.Editing = False
          Position.BeginsLayer = False
        end
        object dxDBGridSN1DBCardView1tipo_individuo: TcxGridDBCardViewRow
          Caption = 'Tipo'
          DataBinding.FieldName = 'tipo_individuo'
          Options.Editing = False
          Position.BeginsLayer = False
        end
        object dxDBGridSN1DBCardView1apellido: TcxGridDBCardViewRow
          Caption = 'Apellido'
          DataBinding.FieldName = 'apellido'
          Options.Editing = False
          Position.BeginsLayer = False
        end
        object dxDBGridSN1DBCardView1nombre: TcxGridDBCardViewRow
          Caption = 'Nombre'
          DataBinding.FieldName = 'nombre'
          Options.Editing = False
          Position.BeginsLayer = False
        end
        object dxDBGridSN1DBCardView1nacionalidad: TcxGridDBCardViewRow
          Caption = 'Nacionalidad'
          DataBinding.FieldName = 'nacionalidad'
          Options.Editing = False
          Position.BeginsLayer = False
        end
        object dxDBGridSN1DBCardView1Row18: TcxGridDBCardViewRow
          DataBinding.FieldName = 'leyenda_rest_ingreso'
          Position.BeginsLayer = False
          Styles.Content = cxStyle3
          IsCaptionAssigned = True
        end
        object dxDBGridSN1DBCardView1Row1: TcxGridDBCardViewRow
          Caption = 'Caracter'#237'sticas'
          Expanded = True
          Kind = rkCategory
          Options.Editing = False
          Position.BeginsLayer = True
          Position.Width = 210
        end
        object dxDBGridSN1DBCardView1sexo: TcxGridDBCardViewRow
          Caption = 'Sexo'
          DataBinding.FieldName = 'sexo'
          Options.Editing = False
          Position.BeginsLayer = False
        end
        object dxDBGridSN1DBCardView1raza: TcxGridDBCardViewRow
          Caption = 'Raza'
          DataBinding.FieldName = 'raza'
          Options.Editing = False
          Position.BeginsLayer = False
        end
        object dxDBGridSN1DBCardView1altura: TcxGridDBCardViewRow
          Caption = 'Altura'
          DataBinding.FieldName = 'altura'
          Options.Editing = False
          Position.BeginsLayer = False
        end
        object dxDBGridSN1DBCardView1complexion: TcxGridDBCardViewRow
          Caption = 'Complexi'#243'n'
          DataBinding.FieldName = 'complexion'
          Options.Editing = False
          Position.BeginsLayer = False
        end
        object dxDBGridSN1DBCardView1edad: TcxGridDBCardViewRow
          Caption = 'Edad'
          DataBinding.FieldName = 'edad'
          Options.Editing = False
          Position.BeginsLayer = False
        end
        object dxDBGridSN1DBCardView1color: TcxGridDBCardViewRow
          Caption = 'Color Cabello'
          DataBinding.FieldName = 'color'
          Options.Editing = False
          Position.BeginsLayer = False
        end
        object dxDBGridSN1DBCardView1tipo_barba: TcxGridDBCardViewRow
          Caption = 'Barba'
          DataBinding.FieldName = 'tipo_barba'
          Options.Editing = False
          Position.BeginsLayer = False
        end
        object dxDBGridSN1DBCardView1cabello: TcxGridDBCardViewRow
          Caption = 'Cabello'
          DataBinding.FieldName = 'cabello'
          Options.Editing = False
          Position.BeginsLayer = False
        end
        object dxDBGridSN1DBCardView1nariz: TcxGridDBCardViewRow
          Caption = 'Nariz'
          DataBinding.FieldName = 'nariz'
          Options.Editing = False
          Position.BeginsLayer = False
        end
        object dxDBGridSN1DBCardView1Row10: TcxGridDBCardViewRow
          Caption = 'Acta'
          Expanded = True
          Kind = rkCategory
          Position.BeginsLayer = True
        end
        object dxDBGridSN1DBCardView1Row11: TcxGridDBCardViewRow
          Caption = 'Nro. Acta'
          DataBinding.FieldName = 'nro_acta'
          Position.BeginsLayer = False
        end
        object dxDBGridSN1DBCardView1Row12: TcxGridDBCardViewRow
          Caption = 'Fec. Acta'
          DataBinding.FieldName = 'fec_acta'
          Position.BeginsLayer = False
        end
        object dxDBGridSN1DBCardView1Row13: TcxGridDBCardViewRow
          Caption = 'Nro. Revo.'
          DataBinding.FieldName = 'nro_acta_revo'
          Position.BeginsLayer = False
        end
        object dxDBGridSN1DBCardView1Row14: TcxGridDBCardViewRow
          Caption = 'Fec. Revo.'
          DataBinding.FieldName = 'fec_acta_revo'
          Position.BeginsLayer = False
        end
        object dxDBGridSN1DBCardView1Row15: TcxGridDBCardViewRow
          Caption = 'Readmitido'
          DataBinding.FieldName = 'readmitido'
          Position.BeginsLayer = False
        end
        object dxDBGridSN1DBCardView1Row3: TcxGridDBCardViewRow
          Caption = 'Empleado'
          Expanded = True
          Kind = rkCategory
          Options.Editing = False
          Position.BeginsLayer = False
        end
        object dxDBGridSN1DBCardView1legajo: TcxGridDBCardViewRow
          Caption = 'Legajo'
          DataBinding.FieldName = 'legajo'
          Options.Editing = False
          Position.BeginsLayer = False
        end
        object dxDBGridSN1DBCardView1sector: TcxGridDBCardViewRow
          Caption = 'Sector'
          DataBinding.FieldName = 'sector'
          Options.Editing = False
          Position.BeginsLayer = False
        end
        object dxDBGridSN1DBCardView1cargo: TcxGridDBCardViewRow
          Caption = 'Cargo'
          DataBinding.FieldName = 'cargo'
          Options.Editing = False
          Position.BeginsLayer = False
        end
        object dxDBGridSN1DBCardView1condicion: TcxGridDBCardViewRow
          Caption = 'Condici'#243'n'
          DataBinding.FieldName = 'condicion'
          Options.Editing = False
          Position.BeginsLayer = False
        end
        object dxDBGridSN1DBCardView1Row21: TcxGridDBCardViewRow
          DataBinding.FieldName = 'color_estado'
          Visible = False
          Position.BeginsLayer = False
        end
        object dxDBGridSN1DBCardView1Row6: TcxGridDBCardViewRow
          Caption = 'Veh'#237'culo'
          Expanded = True
          Kind = rkCategory
          Options.Editing = False
          Position.BeginsLayer = True
        end
        object dxDBGridSN1DBCardView1Row7: TcxGridDBCardViewRow
          Caption = 'Dominio'
          DataBinding.FieldName = 'dominio'
          Position.BeginsLayer = False
        end
        object dxDBGridSN1DBCardView1Row19: TcxGridDBCardViewRow
          Caption = 'Marca'
          DataBinding.FieldName = 'marca_vehiculo'
          Position.BeginsLayer = False
        end
        object dxDBGridSN1DBCardView1Row8: TcxGridDBCardViewRow
          Caption = 'Modelo'
          DataBinding.FieldName = 'modelo'
          Position.BeginsLayer = False
        end
        object dxDBGridSN1DBCardView1Row9: TcxGridDBCardViewRow
          Caption = 'Color'
          DataBinding.FieldName = 'color_auto'
          Position.BeginsLayer = False
        end
        object dxDBGridSN1DBCardView1Row5: TcxGridDBCardViewRow
          Caption = 'Rasgos'
          Expanded = True
          Kind = rkCategory
          Options.Editing = False
          Position.BeginsLayer = False
        end
        object dxDBGridSN1DBCardView1marcos: TcxGridDBCardViewRow
          Caption = 'Marcas'
          DataBinding.FieldName = 'marcas'
          Options.Editing = False
          Position.BeginsLayer = False
        end
        object dxDBGridSN1DBCardView1rasgos: TcxGridDBCardViewRow
          Caption = 'Rasgos'
          DataBinding.FieldName = 'rasgos'
          Options.Editing = False
          Position.BeginsLayer = False
        end
        object dxDBGridSN1DBCardView1anteojos: TcxGridDBCardViewRow
          Caption = 'Anteojos'
          DataBinding.FieldName = 'anteojos'
          Options.Editing = False
          Position.BeginsLayer = False
        end
      end
      object dxDBGridSN1Level1: TcxGridLevel
        GridView = dxDBGridSN1DBCardView1
      end
    end
  end
  inherited DriverABM: TDriverABM
    CargaDataSets = <
      item
        DataSet = TConsultaIndividuo
        TableName = 'TConsultaIndividuo'
      end
      item
        DataSet = TControladorConsMas
        TableName = 'TControladorConsMas'
      end
      item
        DataSet = TProxConsultaIndividuo
        TableName = 'TProxConsultaIndividuo'
      end>
  end
  inherited TOidObjSave: TsnTable
    Left = 640
    Top = 32
  end
  inherited dxComponentPrinter: TdxComponentPrinter
    Tag = 1
    CurrentLink = dxComponentPrinterLink2
    inherited dxComponentPrinterLink1: TdxCustomContainerReportLink
      Component = nil
      BuiltInReportLink = True
      HiddenComponents = {}
      ExcludedComponents = {}
      AggregatedReportLinks = {}
    end
    object dxComponentPrinterLink2: TdxGridReportLink
      Component = dxDBGridSN1
      PrinterPage.DMPaper = 9
      PrinterPage.Footer = 4250
      PrinterPage.Header = 4250
      PrinterPage.Margins.Bottom = 5400
      PrinterPage.Margins.Left = 12700
      PrinterPage.Margins.Right = 12700
      PrinterPage.Margins.Top = 6600
      PrinterPage.PageSize.X = 210000
      PrinterPage.PageSize.Y = 297000
      PrinterPage.ScaleMode = smFit
      PrinterPage._dxMeasurementUnits_ = 0
      PrinterPage._dxLastMU_ = 2
      ReportDocument.CreationDate = 40658.650270833340000000
      ShrinkToPageWidth = True
      OptionsCards.InterCardsSpaceHorz = 2
      OptionsCards.InterCardsSpaceVert = 2
      OptionsOnEveryPage.Footers = False
      OptionsOnEveryPage.FilterBar = False
      OptionsPreview.AutoHeight = False
      OptionsView.Footers = False
      OptionsView.FilterBar = False
      BuiltInReportLink = True
    end
  end
  inherited DriverEvent: TDriverEvent
    OnShow.Strings = (
      'begin'
      '  dxDBGridSN1.setFoco();'
      'end.')
    OnKeyDown = <
      item
        Key = 123
        Shift = []
        isNuevo = True
        isModificar = True
        isBrowse = True
        Source.Strings = (
          'begin'
          '  consultarIndividuo();'
          'end.')
      end
      item
        Key = 113
        Shift = []
        isNuevo = True
        isModificar = True
        isBrowse = True
        Source.Strings = (
          'begin'
          '  proximosRegistros();'
          'end.')
      end>
    OnInicializar = <
      item
        Source.Strings = (
          'begin'
          '    Varios.setImagen('#39'ImageBuscar'#39',0);'
          '    Varios.setImagen('#39'ImageSalir'#39',7);    '
          '    Varios.setImagen('#39'ImageImprimir'#39',13);'
          
            '    TIndividuoExcluido.loadFromAllData(getParamValue('#39'TIndividuo' +
            'Excluido'#39'));'
          '    TEstados.loadFromAllData(getParamValue('#39'TEstados'#39'));'
          
            '    TMotivosNovedades.loadFromAllData(getParamValue('#39'TMotivosNov' +
            'edades'#39'));'
          '    TraerConsulta();'
          
            '    TraerProxRegistros(TControladorConsMas.FieldName('#39'cant_reg_l' +
            'ote'#39').AsInteger);'
          '    TInput.close;'
          '    TInput.Open;'
          '    TInput.appendRecord;'
          'end.')
      end>
    OnPrint = <
      item
        Source.Strings = (
          'begin'
          '  VistaPreliminarForm();'
          'end.')
      end>
    OnFormFunction = <
      item
        Source.Strings = (
          'procedure TraerFotoExcluido();'
          'var'
          '  mensajeError : string;'
          '  nomTempFile  : string;'
          'begin   '
          '  operacion.InicioOperacion();'
          '  operacion.setOper('#39'DownLoadImageFotoExcluidoPrinci'#39');'
          
            '  nomTempFile := operacion.DownLoadFile(TProxConsultaIndividuo.F' +
            'ieldName('#39'oid_individuo'#39').AsString, mensajeError);'
          '  TProxConsultaIndividuo.cargarImagen('#39'foto'#39',nomTempFile);'
          'end;'
          ''
          'procedure TraerConsulta();'
          'begin'
          '  operacion.InicioOperacion();'
          '  operacion.setOper('#39'TraerConsMasivaExcluidos'#39');'
          '  operacion.AddAtribute('#39'prep_cons_exc'#39','#39#39'); '
          '  operacion.AddDataSet(TIndividuoExcluido.getDataSet());'
          '  operacion.AddDataSet(TEstados.getDataSet());'
          '  operacion.AddDataSet(TMotivosNovedades.getDataSet());'
          '  operacion.execute();'
          ''
          'end;'
          ''
          'procedure TraerProxRegistros(CantReg : integer);'
          'begin'
          '  TProxConsultaIndividuo.Close;'
          '  TProxConsultaIndividuo.Open;'
          '  if (not TConsultaIndividuo.Active)'
          '     then TConsultaIndividuo.Open;'
          ''
          '  TControladorConsMas.PostRecord;'
          '  operacion.InicioOperacion();'
          '  operacion.setOper('#39'TraerConsMasivaExcluidos'#39');'
          '  operacion.AddAtribute('#39'prox_registros'#39','#39#39');'
          
            '  operacion.AddAtribute('#39'nro_lote'#39',TControladorConsMas.FieldName' +
            '('#39'nro_lote'#39').AsString);'
          '  operacion.AddAtribute('#39'cant_reg_lote'#39',intToStr(CantReg));   '
          
            '  operacion.AddAtribute('#39'cant_reg_cons'#39',TControladorConsMas.Fiel' +
            'dName('#39'cant_reg_cons'#39').AsString);'
          
            '  operacion.AddAtribute('#39'cant_reg_totales'#39',TControladorConsMas.F' +
            'ieldName('#39'cant_reg_totales'#39').AsString);'
          '  operacion.execute();'
          ''
          '  TProxConsultaIndividuo.First;'
          '  while (not TProxConsultaIndividuo.Eof) do'
          '     begin'
          '       TraerFotoExcluido();'
          '       TProxConsultaIndividuo.next;'
          '     end;'
          '  TProxConsultaIndividuo.First;'
          ''
          
            '  TConsultaIndividuo.AppendRecords(TProxConsultaIndividuo.getDat' +
            'aSet); '
          ''
          ''
          ''
          '  TProxConsultaIndividuo.First;'
          '  if (not TProxConsultaIndividuo.isEmpty)'
          
            '     then TConsultaIndividuo.Locate('#39'oid_individuo'#39', TProxConsul' +
            'taIndividuo.FieldName('#39'oid_individuo'#39').AsInteger,[]);'
          ''
          'end;'
          ''
          ''
          '    '
          'procedure consultarIndividuo();'
          'begin'
          ''
          '  if (TConsultaIndividuo.IsEmpty)'
          
            '     then raiseException(erCustomError,'#39'Debe ingresar el Individ' +
            'uo'#39');'
          ''
          '  TConsultaIndividuo.marcarRegistro;'
          '  '
          '  formConsInd.ventana := getVentana();'
          '  formConsInd.setString('#39'OPEN_BY_ID'#39','#39#39');'
          
            '  formConsInd.setString('#39'oid_cco'#39',IntToStr(TConsultaIndividuo.Fi' +
            'eldName('#39'oid_individuo'#39').AsInteger));'
          '  if (TInput.FieldName('#39'navegar'#39').AsBoolean)'
          '     then begin'
          '             formConsInd.setString('#39'OPEN_DATASET_BY_ID'#39','#39#39');'
          
            '             formConsInd.setTable('#39'TDataSetID'#39', TConsultaIndivid' +
            'uo);'
          '             end;'
          '  formConsInd.Mostrar(false);'
          ''
          '  TConsultaIndividuo.gotoToRegistroMarcado;'
          ''
          ''
          'end;'
          ''
          'procedure proximosRegistros();'
          'begin'
          '  TControladorConsMas.PostRecord;'
          
            '  TraerProxRegistros(TControladorConsMas.FieldName('#39'cant_reg_lot' +
            'e'#39').AsInteger);'
          ''
          '  if (TControladorConsMas.FieldName('#39'cargo_todos'#39').AsBoolean)'
          '     then begin'
          '             LabelTraerTodos.setVisible(false);'
          '             TraerProxReg.setVisible(false);'
          '             DBProxReg.setVisible(false);'
          '             end'
          '      else begin'
          '             LabelTraerTodos.setVisible(true);'
          '             TraerProxReg.setVisible(true);'
          '             DBProxReg.setVisible(true);'
          '             end; '
          ''
          'end;')
      end>
    OnClickToolButton = <
      item
        ButtonName = 'TraerProxReg'
        Source.Strings = (
          'begin'
          ''
          ' proximosRegistros();'
          ''
          'end.')
      end
      item
        ButtonName = 'LabelTraerTodos'
        Source.Strings = (
          'begin'
          '  TControladorConsMas.PostRecord;'
          '  TraerProxRegistros(10000000);'
          '  LabelTraerTodos.setVisible(false);'
          '  TraerProxReg.setVisible(false);'
          '  DBProxReg.setVisible(false);'
          'end.')
      end
      item
        ButtonName = 'ImageSalir'
        Source.Strings = (
          'begin'
          '  close;'
          'end.')
      end
      item
        ButtonName = 'ImageBuscar'
        Source.Strings = (
          'begin'
          '  consultarIndividuo();'
          'end.')
      end
      item
        ButtonName = 'ImageImprimir'
        Source.Strings = (
          'begin'
          '  dxDBGridSN1.setFoco;'
          '  imprimirObjetoActual();'
          'end.')
      end>
    Left = 374
    Top = 64
  end
  inherited ImprimirObjetoSeleccionado: TdxComponentPrinter
    Tag = 1
    CurrentLink = ImprimirObjetoSeleccionadoLink1
    ExplorerStubLink = ImprimirObjetoSeleccionadodxComponentPrinterLink
    inherited ImprimirObjetoSeleccionadodxComponentPrinterLink: TdxGridReportLink
      ReportDocument.CreationDate = 40464.655611157410000000
      BuiltInReportLink = True
    end
    object ImprimirObjetoSeleccionadoLink1: TdxGridReportLink
      Component = dxDBGridSN1
      PrinterPage.DMPaper = 9
      PrinterPage.Footer = 5080
      PrinterPage.Header = 5080
      PrinterPage.Margins.Bottom = 7100
      PrinterPage.Margins.Left = 12700
      PrinterPage.Margins.Right = 12700
      PrinterPage.Margins.Top = 7100
      PrinterPage.PageSize.X = 210000
      PrinterPage.PageSize.Y = 297000
      PrinterPage.ScaleMode = smFit
      PrinterPage._dxMeasurementUnits_ = 0
      PrinterPage._dxLastMU_ = 2
      ShrinkToPageWidth = True
      OptionsCards.AutoWidth = True
      OptionsCards.KeepSameHeight = False
      OptionsOnEveryPage.Footers = False
      OptionsOnEveryPage.FilterBar = False
      OptionsView.Footers = False
      OptionsView.FilterBar = False
      BuiltInReportLink = True
    end
  end
  inherited TTempVarForm: TsnTable
    Left = 488
  end
  object TConsultaIndividuo: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'desc_estado'
        DataType = ftString
        Size = 50
      end
      item
        Name = 'desc_tipo_docu'
        DataType = ftString
        Size = 50
      end
      item
        Name = 'nro_documento'
        DataType = ftString
        Size = 50
      end
      item
        Name = 'tipo_individuo'
        DataType = ftString
        Size = 50
      end
      item
        Name = 'apellido'
        DataType = ftString
        Size = 100
      end
      item
        Name = 'nombre'
        DataType = ftString
        Size = 100
      end
      item
        Name = 'apodo'
        DataType = ftString
        Size = 100
      end
      item
        Name = 'nacionalidad'
        DataType = ftString
        Size = 100
      end
      item
        Name = 'sexo'
        DataType = ftString
        Size = 100
      end
      item
        Name = 'raza'
        DataType = ftString
        Size = 100
      end
      item
        Name = 'altura'
        DataType = ftString
        Size = 100
      end
      item
        Name = 'complexion'
        DataType = ftString
        Size = 100
      end
      item
        Name = 'edad'
        DataType = ftString
        Size = 100
      end
      item
        Name = 'color'
        DataType = ftString
        Size = 100
      end
      item
        Name = 'tipo_barba'
        DataType = ftString
        Size = 100
      end
      item
        Name = 'cabello'
        DataType = ftString
        Size = 100
      end
      item
        Name = 'nariz'
        DataType = ftString
        Size = 100
      end
      item
        Name = 'anteojos'
        DataType = ftString
        Size = 2
      end
      item
        Name = 'marcas'
        DataType = ftString
        Size = 100
      end
      item
        Name = 'rasgos'
        DataType = ftString
        Size = 100
      end
      item
        Name = 'legajo'
        DataType = ftString
        Size = 50
      end
      item
        Name = 'sector'
        DataType = ftString
        Size = 100
      end
      item
        Name = 'cargo'
        DataType = ftString
        Size = 100
      end
      item
        Name = 'condicion'
        DataType = ftString
        Size = 100
      end
      item
        Name = 'foto'
        DataType = ftGraphic
      end
      item
        Name = 'oid_individuo'
        DataType = ftString
        Size = 50
      end
      item
        Name = 'dominio'
        DataType = ftString
        Size = 100
      end
      item
        Name = 'modelo'
        DataType = ftString
        Size = 100
      end
      item
        Name = 'color_auto'
        DataType = ftString
        Size = 100
      end
      item
        Name = 'nro_acta'
        DataType = ftString
        Size = 100
      end
      item
        Name = 'fec_acta'
        DataType = ftDate
      end
      item
        Name = 'nro_acta_revo'
        DataType = ftString
        Size = 100
      end
      item
        Name = 'fec_acta_revo'
        DataType = ftDate
      end
      item
        Name = 'readmitido'
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
    Left = 488
    Top = 121
    object TConsultaIndividuodesc_estado: TStringField
      FieldName = 'desc_estado'
      Size = 50
    end
    object TConsultaIndividuodesc_tipo_docu: TStringField
      FieldName = 'desc_tipo_docu'
      Size = 50
    end
    object TConsultaIndividuonro_documento: TStringField
      FieldName = 'nro_documento'
      Size = 50
    end
    object TConsultaIndividuotipo_individuo: TStringField
      FieldName = 'tipo_individuo'
      Size = 50
    end
    object TConsultaIndividuoapellido: TStringField
      FieldName = 'apellido'
      Size = 100
    end
    object TConsultaIndividuonombre: TStringField
      FieldName = 'nombre'
      Size = 100
    end
    object TConsultaIndividuoapodo: TStringField
      FieldName = 'apodo'
      Size = 100
    end
    object TConsultaIndividuonacionalidad: TStringField
      FieldName = 'nacionalidad'
      Size = 100
    end
    object TConsultaIndividuosexo: TStringField
      FieldName = 'sexo'
      Size = 100
    end
    object TConsultaIndividuoraza: TStringField
      FieldName = 'raza'
      Size = 100
    end
    object TConsultaIndividuoaltura: TStringField
      FieldName = 'altura'
      Size = 100
    end
    object TConsultaIndividuocomplexion: TStringField
      FieldName = 'complexion'
      Size = 100
    end
    object TConsultaIndividuoedad: TStringField
      FieldName = 'edad'
      Size = 100
    end
    object TConsultaIndividuocolor: TStringField
      FieldName = 'color'
      Size = 100
    end
    object TConsultaIndividuotipo_barba: TStringField
      FieldName = 'tipo_barba'
      Size = 100
    end
    object TConsultaIndividuocabello: TStringField
      FieldName = 'cabello'
      Size = 100
    end
    object TConsultaIndividuonariz: TStringField
      FieldName = 'nariz'
      Size = 100
    end
    object TConsultaIndividuoanteojos: TStringField
      FieldName = 'anteojos'
      Size = 2
    end
    object TConsultaIndividuomarcas: TStringField
      FieldName = 'marcas'
      Size = 255
    end
    object TConsultaIndividuorasgos: TStringField
      FieldName = 'rasgos'
      Size = 100
    end
    object TConsultaIndividuolegajo: TStringField
      FieldName = 'legajo'
      Size = 50
    end
    object TConsultaIndividuosector: TStringField
      FieldName = 'sector'
      Size = 100
    end
    object TConsultaIndividuocargo: TStringField
      FieldName = 'cargo'
      Size = 100
    end
    object TConsultaIndividuocondicion: TStringField
      FieldName = 'condicion'
      Size = 100
    end
    object TConsultaIndividuofoto: TGraphicField
      FieldName = 'foto'
      BlobType = ftGraphic
    end
    object TConsultaIndividuooid_individuo: TStringField
      FieldName = 'oid_individuo'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
      Size = 50
    end
    object TConsultaIndividuodominio: TStringField
      DisplayWidth = 100
      FieldName = 'dominio'
      Size = 100
    end
    object TConsultaIndividuomodelo: TStringField
      DisplayWidth = 100
      FieldName = 'modelo'
      Size = 100
    end
    object TConsultaIndividuocolor_auto: TStringField
      DisplayWidth = 100
      FieldName = 'color_auto'
      Size = 100
    end
    object TConsultaIndividuonro_acta: TStringField
      FieldName = 'nro_acta'
      Size = 100
    end
    object TConsultaIndividuofec_acta: TDateField
      FieldName = 'fec_acta'
    end
    object TConsultaIndividuonro_acta_revo: TStringField
      FieldName = 'nro_acta_revo'
      Size = 100
    end
    object TConsultaIndividuofec_acta_revo: TDateField
      FieldName = 'fec_acta_revo'
    end
    object TConsultaIndividuoreadmitido: TStringField
      FieldName = 'readmitido'
      Size = 2
    end
    object TConsultaIndividuovenc_estado: TStringField
      FieldName = 'venc_estado'
      Size = 100
    end
    object TConsultaIndividuoobs_principal: TStringField
      FieldName = 'obs_principal'
      Size = 100
    end
    object TConsultaIndividuocaracter: TStringField
      FieldName = 'caracter'
      Size = 100
    end
    object TConsultaIndividuomarca_vehiculo: TStringField
      FieldName = 'marca_vehiculo'
      Size = 100
    end
    object TConsultaIndividuonro_registro: TStringField
      FieldName = 'nro_registro'
      Size = 50
    end
    object TConsultaIndividuocolor_estado: TStringField
      FieldName = 'color_estado'
      Size = 10
    end
    object TConsultaIndividuodesc_est_y_nro_reg: TStringField
      FieldName = 'desc_est_y_nro_reg'
      Size = 100
    end
    object TConsultaIndividuomotivo: TStringField
      FieldName = 'motivo'
      Size = 100
    end
    object TConsultaIndividuoleyenda_rest_ingreso: TStringField
      FieldName = 'leyenda_rest_ingreso'
      Size = 255
    end
  end
  object DSConsultaIndividuo: TDataSource
    DataSet = TConsultaIndividuo
    Left = 520
    Top = 121
  end
  object cxStyleRepository1: TcxStyleRepository
    PixelsPerInch = 96
    object cxStyle1: TcxStyle
      AssignedValues = [svColor, svFont, svTextColor]
      Color = clGradientActiveCaption
      Font.Charset = DEFAULT_CHARSET
      Font.Color = clWhite
      Font.Height = -11
      Font.Name = 'Verdana'
      Font.Style = [fsBold]
      TextColor = clWindow
    end
    object cxStyle2: TcxStyle
      AssignedValues = [svTextColor]
      TextColor = clNavy
    end
    object cxStyle3: TcxStyle
      AssignedValues = [svFont, svTextColor]
      Font.Charset = DEFAULT_CHARSET
      Font.Color = clRed
      Font.Height = -11
      Font.Name = 'MS Sans Serif'
      Font.Style = [fsBold]
      TextColor = clRed
    end
  end
  object TControladorConsMas: TsnTable
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
    Left = 304
    Top = 289
    object TControladorConsMasnro_lote: TIntegerField
      FieldName = 'nro_lote'
    end
    object TControladorConsMascant_reg_totales: TIntegerField
      FieldName = 'cant_reg_totales'
    end
    object TControladorConsMascant_reg_lote: TIntegerField
      FieldName = 'cant_reg_lote'
    end
    object TControladorConsMascargo_todos: TBooleanField
      FieldName = 'cargo_todos'
    end
    object TControladorConsMasprimer_reg_lote: TIntegerField
      FieldName = 'primer_reg_lote'
    end
    object TControladorConsMasultimo_reg_lote: TIntegerField
      FieldName = 'ultimo_reg_lote'
    end
    object TControladorConsMascant_reg_cons: TIntegerField
      FieldName = 'cant_reg_cons'
    end
  end
  object DSControladorConsMas: TDataSource
    DataSet = TControladorConsMas
    Left = 336
    Top = 289
  end
  object TProxConsultaIndividuo: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'desc_estado'
        DataType = ftString
        Size = 50
      end
      item
        Name = 'desc_tipo_docu'
        DataType = ftString
        Size = 50
      end
      item
        Name = 'nro_documento'
        DataType = ftString
        Size = 50
      end
      item
        Name = 'tipo_individuo'
        DataType = ftString
        Size = 50
      end
      item
        Name = 'apellido'
        DataType = ftString
        Size = 100
      end
      item
        Name = 'nombre'
        DataType = ftString
        Size = 100
      end
      item
        Name = 'apodo'
        DataType = ftString
        Size = 100
      end
      item
        Name = 'nacionalidad'
        DataType = ftString
        Size = 100
      end
      item
        Name = 'sexo'
        DataType = ftString
        Size = 100
      end
      item
        Name = 'raza'
        DataType = ftString
        Size = 100
      end
      item
        Name = 'altura'
        DataType = ftString
        Size = 100
      end
      item
        Name = 'complexion'
        DataType = ftString
        Size = 100
      end
      item
        Name = 'edad'
        DataType = ftString
        Size = 100
      end
      item
        Name = 'color'
        DataType = ftString
        Size = 100
      end
      item
        Name = 'tipo_barba'
        DataType = ftString
        Size = 100
      end
      item
        Name = 'cabello'
        DataType = ftString
        Size = 100
      end
      item
        Name = 'nariz'
        DataType = ftString
        Size = 100
      end
      item
        Name = 'anteojos'
        DataType = ftString
        Size = 2
      end
      item
        Name = 'marcas'
        DataType = ftString
        Size = 100
      end
      item
        Name = 'rasgos'
        DataType = ftString
        Size = 100
      end
      item
        Name = 'legajo'
        DataType = ftString
        Size = 50
      end
      item
        Name = 'sector'
        DataType = ftString
        Size = 100
      end
      item
        Name = 'cargo'
        DataType = ftString
        Size = 100
      end
      item
        Name = 'condicion'
        DataType = ftString
        Size = 100
      end
      item
        Name = 'foto'
        DataType = ftGraphic
      end
      item
        Name = 'oid_individuo'
        DataType = ftString
        Size = 50
      end
      item
        Name = 'dominio'
        DataType = ftString
        Size = 100
      end
      item
        Name = 'modelo'
        DataType = ftString
        Size = 100
      end
      item
        Name = 'color_auto'
        DataType = ftString
        Size = 100
      end
      item
        Name = 'nro_acta'
        DataType = ftString
        Size = 100
      end
      item
        Name = 'fec_acta'
        DataType = ftDate
      end
      item
        Name = 'nro_acta_revo'
        DataType = ftString
        Size = 100
      end
      item
        Name = 'fec_acta_revo'
        DataType = ftDate
      end
      item
        Name = 'readmitido'
        DataType = ftString
        Size = 2
      end
      item
        Name = 'venc_estado'
        DataType = ftString
        Size = 100
      end
      item
        Name = 'obs_principal'
        DataType = ftString
        Size = 100
      end
      item
        Name = 'caracter'
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
    Left = 488
    Top = 164
    object StringField1: TStringField
      FieldName = 'desc_estado'
      Size = 50
    end
    object StringField2: TStringField
      FieldName = 'desc_tipo_docu'
      Size = 50
    end
    object StringField3: TStringField
      FieldName = 'nro_documento'
      Size = 50
    end
    object StringField4: TStringField
      FieldName = 'tipo_individuo'
      Size = 50
    end
    object StringField5: TStringField
      FieldName = 'apellido'
      Size = 100
    end
    object StringField6: TStringField
      FieldName = 'nombre'
      Size = 100
    end
    object StringField7: TStringField
      FieldName = 'apodo'
      Size = 100
    end
    object StringField8: TStringField
      FieldName = 'nacionalidad'
      Size = 100
    end
    object StringField9: TStringField
      FieldName = 'sexo'
      Size = 100
    end
    object StringField10: TStringField
      FieldName = 'raza'
      Size = 100
    end
    object StringField11: TStringField
      FieldName = 'altura'
      Size = 100
    end
    object StringField12: TStringField
      FieldName = 'complexion'
      Size = 100
    end
    object StringField13: TStringField
      FieldName = 'edad'
      Size = 100
    end
    object StringField14: TStringField
      FieldName = 'color'
      Size = 100
    end
    object StringField15: TStringField
      FieldName = 'tipo_barba'
      Size = 100
    end
    object StringField16: TStringField
      FieldName = 'cabello'
      Size = 100
    end
    object StringField17: TStringField
      FieldName = 'nariz'
      Size = 100
    end
    object StringField18: TStringField
      FieldName = 'anteojos'
      Size = 2
    end
    object StringField19: TStringField
      DisplayWidth = 255
      FieldName = 'marcas'
      Size = 255
    end
    object StringField20: TStringField
      FieldName = 'rasgos'
      Size = 100
    end
    object StringField21: TStringField
      FieldName = 'legajo'
      Size = 50
    end
    object StringField22: TStringField
      FieldName = 'sector'
      Size = 100
    end
    object StringField23: TStringField
      FieldName = 'cargo'
      Size = 100
    end
    object StringField24: TStringField
      FieldName = 'condicion'
      Size = 100
    end
    object GraphicField1: TGraphicField
      FieldName = 'foto'
      BlobType = ftGraphic
    end
    object StringField25: TStringField
      FieldName = 'oid_individuo'
      Size = 50
    end
    object TProxConsultaIndividuodominio: TStringField
      DisplayWidth = 100
      FieldName = 'dominio'
      Size = 100
    end
    object TProxConsultaIndividuomodelo: TStringField
      DisplayWidth = 100
      FieldName = 'modelo'
      Size = 100
    end
    object TProxConsultaIndividuocolor_auto: TStringField
      DisplayWidth = 100
      FieldName = 'color_auto'
      Size = 100
    end
    object TProxConsultaIndividuonro_acta: TStringField
      FieldName = 'nro_acta'
      Size = 100
    end
    object TProxConsultaIndividuofec_acta: TDateField
      FieldName = 'fec_acta'
    end
    object TProxConsultaIndividuonro_acta_revo: TStringField
      FieldName = 'nro_acta_revo'
      Size = 100
    end
    object TProxConsultaIndividuofec_acta_revo: TDateField
      FieldName = 'fec_acta_revo'
    end
    object TProxConsultaIndividuoreadmitido: TStringField
      FieldName = 'readmitido'
      Size = 2
    end
    object TProxConsultaIndividuovenc_estado: TStringField
      FieldName = 'venc_estado'
      Size = 100
    end
    object TProxConsultaIndividuoobs_principal: TStringField
      FieldName = 'obs_principal'
      Size = 100
    end
    object TProxConsultaIndividuocaracter: TStringField
      FieldName = 'caracter'
      Size = 100
    end
    object TProxConsultaIndividuomarca_vehiculo: TStringField
      FieldName = 'marca_vehiculo'
      Size = 100
    end
    object TProxConsultaIndividuonro_registro: TStringField
      FieldName = 'nro_registro'
      Size = 50
    end
    object TProxConsultaIndividuocolor_estado: TStringField
      FieldName = 'color_estado'
      Size = 10
    end
    object TProxConsultaIndividuodesc_est_y_nro_reg: TStringField
      FieldName = 'desc_est_y_nro_reg'
      Size = 100
    end
    object TProxConsultaIndividuomotivo: TStringField
      FieldName = 'motivo'
      Size = 100
    end
    object TProxConsultaIndividuoleyenda_rest_ingreso: TStringField
      FieldName = 'leyenda_rest_ingreso'
      Size = 255
    end
  end
  object DSProxConsultaIndividuo: TDataSource
    DataSet = TProxConsultaIndividuo
    Left = 520
    Top = 164
  end
  object formConsInd: TFormulario
    AutoLiberar = True
    Nombre = 'TFIndividuoExcluido'
    TipoForm = tipoFormABM
    CreateAlwaysANewForm = True
    Left = 490
    Top = 212
  end
  object Varios: TsnVarios
    Operacion = Operacion
    Left = 152
    Top = 19
  end
  object TIndividuoExcluido: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'oid_individuo'
        DataType = ftInteger
      end
      item
        Name = 'tipo'
        DataType = ftString
        Size = 20
      end
      item
        Name = 'apellido'
        DataType = ftString
        Size = 50
      end
      item
        Name = 'nombre'
        DataType = ftString
        Size = 50
      end
      item
        Name = 'oid_tipo_documento'
        DataType = ftInteger
      end
      item
        Name = 'nro_documento'
        DataType = ftString
        Size = 50
      end
      item
        Name = 'apodo'
        DataType = ftString
        Size = 50
      end
      item
        Name = 'oid_nacionalidad'
        DataType = ftInteger
      end
      item
        Name = 'legajo'
        DataType = ftString
        Size = 50
      end
      item
        Name = 'oid_sector'
        DataType = ftInteger
      end
      item
        Name = 'oid_cargo'
        DataType = ftInteger
      end
      item
        Name = 'tipo_condicion'
        DataType = ftString
        Size = 20
      end
      item
        Name = 'sexo'
        DataType = ftString
        Size = 1
      end
      item
        Name = 'oid_raza'
        DataType = ftInteger
      end
      item
        Name = 'oid_altura'
        DataType = ftInteger
      end
      item
        Name = 'oid_complexion'
        DataType = ftInteger
      end
      item
        Name = 'oid_edad'
        DataType = ftInteger
      end
      item
        Name = 'oid_color'
        DataType = ftInteger
      end
      item
        Name = 'oid_tipo_barba'
        DataType = ftInteger
      end
      item
        Name = 'oid_tipo_cabello'
        DataType = ftInteger
      end
      item
        Name = 'oid_tipo_nariz'
        DataType = ftInteger
      end
      item
        Name = 'activo'
        DataType = ftBoolean
      end
      item
        Name = 'anteojos'
        DataType = ftInteger
      end
      item
        Name = 'marcas'
        DataType = ftString
        Size = 50
      end
      item
        Name = 'rasgos'
        DataType = ftString
        Size = 50
      end
      item
        Name = 'oid_estado'
        DataType = ftInteger
      end
      item
        Name = 'oid_estado_ant'
        DataType = ftInteger
      end
      item
        Name = 'fec_estado'
        DataType = ftDate
      end
      item
        Name = 'fec_estado_ant'
        DataType = ftDate
      end
      item
        Name = 'oid_legajo'
        DataType = ftInteger
      end
      item
        Name = 'comen_foto_2'
        DataType = ftString
        Size = 50
      end
      item
        Name = 'comen_foto_3'
        DataType = ftString
        Size = 50
      end
      item
        Name = 'fecha_date_foto_2'
        DataType = ftDate
      end
      item
        Name = 'fecha_date_foto_3'
        DataType = ftDate
      end
      item
        Name = 'oid_rel_1'
        DataType = ftInteger
      end
      item
        Name = 'oid_rel_2'
        DataType = ftInteger
      end
      item
        Name = 'oid_rel_3'
        DataType = ftInteger
      end
      item
        Name = 'oid_rel_4'
        DataType = ftInteger
      end
      item
        Name = 'oid_rel_5'
        DataType = ftInteger
      end
      item
        Name = 'oid_rel_6'
        DataType = ftInteger
      end
      item
        Name = 'oid_rel_7'
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
    Left = 304
    Top = 387
    object TIndividuoExcluidooid_individuo: TIntegerField
      FieldName = 'oid_individuo'
    end
    object TIndividuoExcluidotipo: TStringField
      FieldName = 'tipo'
    end
    object TIndividuoExcluidoapellido: TStringField
      FieldName = 'apellido'
      Size = 50
    end
    object TIndividuoExcluidonombre: TStringField
      FieldName = 'nombre'
      Size = 50
    end
    object TIndividuoExcluidooid_tipo_documento: TIntegerField
      FieldName = 'oid_tipo_documento'
    end
    object TIndividuoExcluidonro_documento: TStringField
      FieldName = 'nro_documento'
      Size = 50
    end
    object TIndividuoExcluidoapodo: TStringField
      FieldName = 'apodo'
      Size = 50
    end
    object TIndividuoExcluidooid_nacionalidad: TIntegerField
      FieldName = 'oid_nacionalidad'
    end
    object TIndividuoExcluidolegajo: TStringField
      FieldName = 'legajo'
      Size = 50
    end
    object TIndividuoExcluidooid_sector: TIntegerField
      FieldName = 'oid_sector'
    end
    object TIndividuoExcluidooid_cargo: TIntegerField
      FieldName = 'oid_cargo'
    end
    object TIndividuoExcluidotipo_condicion: TStringField
      FieldName = 'tipo_condicion'
    end
    object TIndividuoExcluidosexo: TStringField
      FieldName = 'sexo'
      Size = 1
    end
    object TIndividuoExcluidooid_raza: TIntegerField
      FieldName = 'oid_raza'
    end
    object TIndividuoExcluidooid_altura: TIntegerField
      FieldName = 'oid_altura'
    end
    object TIndividuoExcluidooid_complexion: TIntegerField
      FieldName = 'oid_complexion'
    end
    object TIndividuoExcluidooid_edad: TIntegerField
      FieldName = 'oid_edad'
    end
    object TIndividuoExcluidooid_color: TIntegerField
      FieldName = 'oid_color'
    end
    object TIndividuoExcluidooid_tipo_barba: TIntegerField
      FieldName = 'oid_tipo_barba'
    end
    object TIndividuoExcluidooid_tipo_cabello: TIntegerField
      FieldName = 'oid_tipo_cabello'
    end
    object TIndividuoExcluidooid_tipo_nariz: TIntegerField
      FieldName = 'oid_tipo_nariz'
    end
    object TIndividuoExcluidoactivo: TBooleanField
      DefaultExpression = '1'
      FieldName = 'activo'
    end
    object TIndividuoExcluidoanteojos: TIntegerField
      FieldName = 'anteojos'
    end
    object TIndividuoExcluidomarcas: TStringField
      FieldName = 'marcas'
      Size = 50
    end
    object TIndividuoExcluidorasgos: TStringField
      FieldName = 'rasgos'
      Size = 50
    end
    object TIndividuoExcluidooid_estado: TIntegerField
      FieldName = 'oid_estado'
    end
    object TIndividuoExcluidooid_estado_ant: TIntegerField
      FieldName = 'oid_estado_ant'
    end
    object TIndividuoExcluidofec_estado: TDateField
      FieldName = 'fec_estado'
    end
    object TIndividuoExcluidofec_estado_ant: TDateField
      FieldName = 'fec_estado_ant'
    end
    object TIndividuoExcluidooid_legajo: TIntegerField
      FieldName = 'oid_legajo'
    end
    object TIndividuoExcluidocomen_foto_2: TStringField
      FieldName = 'comen_foto_2'
      Size = 50
    end
    object TIndividuoExcluidocomen_foto_3: TStringField
      FieldName = 'comen_foto_3'
      Size = 50
    end
    object TIndividuoExcluidofecha_date_foto_2: TDateField
      FieldName = 'fecha_date_foto_2'
    end
    object TIndividuoExcluidofecha_date_foto_3: TDateField
      FieldName = 'fecha_date_foto_3'
    end
    object TIndividuoExcluidooid_rel_1: TIntegerField
      FieldName = 'oid_rel_1'
    end
    object TIndividuoExcluidooid_rel_2: TIntegerField
      FieldName = 'oid_rel_2'
    end
    object TIndividuoExcluidooid_rel_3: TIntegerField
      FieldName = 'oid_rel_3'
    end
    object TIndividuoExcluidooid_rel_4: TIntegerField
      FieldName = 'oid_rel_4'
    end
    object TIndividuoExcluidooid_rel_5: TIntegerField
      FieldName = 'oid_rel_5'
    end
    object TIndividuoExcluidooid_rel_6: TIntegerField
      FieldName = 'oid_rel_6'
    end
    object TIndividuoExcluidooid_rel_7: TIntegerField
      FieldName = 'oid_rel_7'
    end
    object TIndividuoExcluidooid_rel_8: TIntegerField
      FieldName = 'oid_rel_8'
    end
    object TIndividuoExcluidoobs_rel_1: TStringField
      FieldName = 'obs_rel_1'
      Size = 255
    end
    object TIndividuoExcluidoobs_rel_2: TStringField
      FieldName = 'obs_rel_2'
      Size = 255
    end
    object TIndividuoExcluidoobs_rel_3: TStringField
      FieldName = 'obs_rel_3'
      Size = 255
    end
    object TIndividuoExcluidoobs_rel_4: TStringField
      FieldName = 'obs_rel_4'
      Size = 255
    end
    object TIndividuoExcluidoobs_rel_5: TStringField
      FieldName = 'obs_rel_5'
      Size = 255
    end
    object TIndividuoExcluidoobs_rel_6: TStringField
      FieldName = 'obs_rel_6'
      Size = 255
    end
    object TIndividuoExcluidoobs_rel_7: TStringField
      FieldName = 'obs_rel_7'
      Size = 255
    end
    object TIndividuoExcluidoobs_rel_8: TStringField
      FieldName = 'obs_rel_8'
      Size = 255
    end
    object TIndividuoExcluidooid_rel_ind_1: TIntegerField
      FieldName = 'oid_rel_ind_1'
    end
    object TIndividuoExcluidooid_rel_ind_2: TIntegerField
      FieldName = 'oid_rel_ind_2'
    end
    object TIndividuoExcluidooid_rel_ind_3: TIntegerField
      FieldName = 'oid_rel_ind_3'
    end
    object TIndividuoExcluidooid_rel_ind_4: TIntegerField
      FieldName = 'oid_rel_ind_4'
    end
    object TIndividuoExcluidooid_rel_ind_5: TIntegerField
      FieldName = 'oid_rel_ind_5'
    end
    object TIndividuoExcluidooid_rel_ind_6: TIntegerField
      FieldName = 'oid_rel_ind_6'
    end
    object TIndividuoExcluidooid_rel_ind_7: TIntegerField
      FieldName = 'oid_rel_ind_7'
    end
    object TIndividuoExcluidooid_rel_ind_8: TIntegerField
      FieldName = 'oid_rel_ind_8'
    end
    object TIndividuoExcluidonro_rel_ind_1: TIntegerField
      FieldName = 'nro_rel_ind_1'
    end
    object TIndividuoExcluidonro_rel_ind_2: TIntegerField
      FieldName = 'nro_rel_ind_2'
    end
    object TIndividuoExcluidonro_rel_ind_3: TIntegerField
      FieldName = 'nro_rel_ind_3'
    end
    object TIndividuoExcluidonro_rel_ind_4: TIntegerField
      FieldName = 'nro_rel_ind_4'
    end
    object TIndividuoExcluidonro_rel_ind_5: TIntegerField
      FieldName = 'nro_rel_ind_5'
    end
    object TIndividuoExcluidonro_rel_ind_6: TIntegerField
      FieldName = 'nro_rel_ind_6'
    end
    object TIndividuoExcluidonro_rel_ind_7: TIntegerField
      FieldName = 'nro_rel_ind_7'
    end
    object TIndividuoExcluidonro_rel_ind_8: TIntegerField
      FieldName = 'nro_rel_ind_8'
    end
    object TIndividuoExcluidoape_y_nom_rel_1: TStringField
      FieldName = 'ape_y_nom_rel_1'
      Size = 100
    end
    object TIndividuoExcluidoape_y_nom_rel_2: TStringField
      FieldName = 'ape_y_nom_rel_2'
      Size = 100
    end
    object TIndividuoExcluidoape_y_nom_rel_3: TStringField
      FieldName = 'ape_y_nom_rel_3'
      Size = 100
    end
    object TIndividuoExcluidoape_y_nom_rel_4: TStringField
      FieldName = 'ape_y_nom_rel_4'
      Size = 100
    end
    object TIndividuoExcluidoape_y_nom_rel_5: TStringField
      FieldName = 'ape_y_nom_rel_5'
      Size = 100
    end
    object TIndividuoExcluidoape_y_nom_rel_6: TStringField
      FieldName = 'ape_y_nom_rel_6'
      Size = 100
    end
    object TIndividuoExcluidoape_y_nom_rel_7: TStringField
      FieldName = 'ape_y_nom_rel_7'
      Size = 100
    end
    object TIndividuoExcluidoape_y_nom_rel_8: TStringField
      FieldName = 'ape_y_nom_rel_8'
      Size = 100
    end
    object TIndividuoExcluidoestado_rel_1: TStringField
      FieldName = 'estado_rel_1'
      Size = 50
    end
    object TIndividuoExcluidoestado_rel_2: TStringField
      FieldName = 'estado_rel_2'
      Size = 50
    end
    object TIndividuoExcluidoestado_rel_3: TStringField
      FieldName = 'estado_rel_3'
      Size = 50
    end
    object TIndividuoExcluidoestado_rel_4: TStringField
      FieldName = 'estado_rel_4'
      Size = 50
    end
    object TIndividuoExcluidoestado_rel_5: TStringField
      FieldName = 'estado_rel_5'
      Size = 50
    end
    object TIndividuoExcluidoestado_rel_6: TStringField
      FieldName = 'estado_rel_6'
      Size = 50
    end
    object TIndividuoExcluidoestado_rel_7: TStringField
      FieldName = 'estado_rel_7'
      Size = 50
    end
    object TIndividuoExcluidoestado_rel_8: TStringField
      FieldName = 'estado_rel_8'
      Size = 50
    end
    object TIndividuoExcluidooid_ind_rel_1: TIntegerField
      FieldName = 'oid_ind_rel_1'
    end
    object TIndividuoExcluidooid_ind_rel_2: TIntegerField
      FieldName = 'oid_ind_rel_2'
    end
    object TIndividuoExcluidooid_ind_rel_3: TIntegerField
      FieldName = 'oid_ind_rel_3'
    end
    object TIndividuoExcluidooid_ind_rel_4: TIntegerField
      FieldName = 'oid_ind_rel_4'
    end
    object TIndividuoExcluidooid_ind_rel_5: TIntegerField
      FieldName = 'oid_ind_rel_5'
    end
    object TIndividuoExcluidooid_ind_rel_6: TIntegerField
      FieldName = 'oid_ind_rel_6'
    end
    object TIndividuoExcluidooid_ind_rel_7: TIntegerField
      FieldName = 'oid_ind_rel_7'
    end
    object TIndividuoExcluidooid_ind_rel_8: TIntegerField
      FieldName = 'oid_ind_rel_8'
    end
    object TIndividuoExcluidodominio: TStringField
      FieldName = 'dominio'
      Size = 50
    end
    object TIndividuoExcluidomodelo: TStringField
      FieldName = 'modelo'
      Size = 50
    end
    object TIndividuoExcluidooid_color_vehiculo: TIntegerField
      FieldName = 'oid_color_vehiculo'
    end
    object TIndividuoExcluidonro_acta: TIntegerField
      FieldName = 'nro_acta'
    end
    object TIndividuoExcluidonro_acta_revo: TIntegerField
      FieldName = 'nro_acta_revo'
    end
    object TIndividuoExcluidooid_ind_relacion: TIntegerField
      FieldName = 'oid_ind_relacion'
    end
    object TIndividuoExcluidonro_ind_relacion: TIntegerField
      FieldName = 'nro_ind_relacion'
    end
    object TIndividuoExcluidoape_y_nom_relacion: TStringField
      FieldName = 'ape_y_nom_relacion'
      Size = 100
    end
    object TIndividuoExcluidocomportamiento_estado: TStringField
      FieldName = 'comportamiento_estado'
      Size = 50
    end
    object TIndividuoExcluidofec_alta_desde: TDateField
      FieldName = 'fec_alta_desde'
    end
    object TIndividuoExcluidofec_alta_hasta: TDateField
      FieldName = 'fec_alta_hasta'
    end
    object TIndividuoExcluidosin_vigencia_hasta: TBooleanField
      FieldName = 'sin_vigencia_hasta'
    end
    object TIndividuoExcluidooid_marca: TIntegerField
      FieldName = 'oid_marca'
    end
    object TIndividuoExcluidooid_rasgo: TIntegerField
      FieldName = 'oid_rasgo'
    end
  end
  object DSTIndividuoExcluido: TDataSource
    DataSet = TIndividuoExcluido
    Left = 336
    Top = 387
  end
  object DSEstados: TDataSource
    DataSet = TEstados
    Left = 336
    Top = 425
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
    Left = 304
    Top = 425
    object TEstadosoid: TIntegerField
      FieldName = 'oid'
    end
    object TEstadoscodigo: TStringField
      FieldName = 'codigo'
      Size = 50
    end
    object TEstadosdescripcion: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
    object TEstadossel: TBooleanField
      DefaultExpression = 'false'
      FieldName = 'sel'
    end
  end
  object TMotivosNovedades: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'oid'
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
    Left = 301
    Top = 465
    object IntegerField11: TIntegerField
      FieldName = 'oid'
    end
    object StringField33: TStringField
      FieldName = 'codigo'
      Size = 50
    end
    object StringField34: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
    object TMotivosNovedadessel: TBooleanField
      FieldName = 'sel'
    end
  end
  object DSMotivoNovedad: TDataSource
    DataSet = TMotivosNovedades
    Left = 333
    Top = 465
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
    Left = 216
    Top = 137
    object TInputnavegar: TBooleanField
      FieldName = 'navegar'
    end
  end
  object DSInput: TDataSource
    DataSet = TInput
    Left = 248
    Top = 137
  end
end
