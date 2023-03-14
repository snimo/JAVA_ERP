inherited FPlanifRotas: TFPlanifRotas
  Left = 23
  Top = 77
  Width = 1001
  Height = 624
  Caption = 'Planificaci'#243'n de Rotas'
  PixelsPerInch = 96
  TextHeight = 13
  object Panel1: TPanel [0]
    Left = 0
    Top = 0
    Width = 993
    Height = 41
    Align = alTop
    BevelOuter = bvNone
    Color = clWindow
    TabOrder = 0
    object ImageSalir: TImage
      Tag = 7
      Left = 18
      Top = 5
      Width = 32
      Height = 32
      Cursor = crHandPoint
      Hint = 'Salir'
      ParentShowHint = False
      ShowHint = True
    end
    object snLabel1: TsnLabel
      Left = 64
      Top = 16
      Width = 103
      Height = 13
      Caption = 'Planificaci'#243'n desde el'
    end
    object snDBEdit1: TsnDBEdit
      Left = 176
      Top = 12
      TabStop = False
      DataBinding.DataField = 'fecha'
      DataBinding.DataSource = DSInput
      Properties.ReadOnly = True
      TabOrder = 0
      Width = 73
    end
    object BotonGrabarCambios: TsnButton
      Left = 296
      Top = 9
      Width = 153
      Height = 25
      Caption = 'Grabar cambios planificaci'#243'n'
      TabOrder = 1
      LookAndFeel.Kind = lfOffice11
    end
  end
  object Panel2: TPanel [1]
    Left = 0
    Top = 549
    Width = 993
    Height = 41
    Align = alBottom
    Color = clWindow
    TabOrder = 1
  end
  object Panel3: TPanel [2]
    Left = 0
    Top = 41
    Width = 993
    Height = 508
    Align = alClient
    BevelOuter = bvNone
    Color = clWindow
    TabOrder = 2
    object dxPlanifRotas: TdxDBGridSN
      Left = 0
      Top = 0
      Width = 993
      Height = 508
      Align = alClient
      TabOrder = 0
      LookAndFeel.Kind = lfFlat
      CriteriosPintarCelda = <>
      object dxPlanifRotasDBTableView1: TcxGridDBTableView
        NavigatorButtons.ConfirmDelete = False
        DataController.Summary.DefaultGroupSummaryItems = <>
        DataController.Summary.FooterSummaryItems = <>
        DataController.Summary.SummaryGroups = <>
        OptionsBehavior.AlwaysShowEditor = True
        OptionsCustomize.ColumnFiltering = False
        OptionsData.Appending = True
        OptionsData.Deleting = False
        OptionsData.DeletingConfirmation = False
        OptionsSelection.InvertSelect = False
        OptionsView.GroupByBox = False
        object dxPlanifRotasDBTableView1codigo: TcxGridDBColumn
          Caption = 'Legajo'
          DataBinding.FieldName = 'codigo'
          PropertiesClassName = 'TcxButtonEditProperties'
          Properties.Buttons = <
            item
              Default = True
              Kind = bkEllipsis
            end>
          HeaderAlignmentHorz = taCenter
          Width = 217
        end
        object dxPlanifRotasDBTableView1nombre: TcxGridDBColumn
          Caption = 'Apellido y Nombre'
          DataBinding.FieldName = 'nombre'
          HeaderAlignmentHorz = taCenter
          Options.Focusing = False
          Width = 531
        end
      end
      object dxPlanifRotasDBBandedTableView1: TcxGridDBBandedTableView
        NavigatorButtons.ConfirmDelete = False
        DataController.DataSource = DSTPlanifRotas
        DataController.Options = [dcoAssignGroupingValues, dcoAssignMasterDetailKeys, dcoSaveExpanding, dcoGroupsAlwaysExpanded]
        DataController.Summary.DefaultGroupSummaryItems = <>
        DataController.Summary.FooterSummaryItems = <>
        DataController.Summary.SummaryGroups = <>
        OptionsBehavior.AlwaysShowEditor = True
        OptionsBehavior.FocusCellOnTab = True
        OptionsBehavior.FocusFirstCellOnNewRecord = True
        OptionsBehavior.GoToNextCellOnEnter = True
        OptionsBehavior.FocusCellOnCycle = True
        OptionsData.Deleting = False
        OptionsData.Inserting = False
        OptionsView.GroupByBox = False
        Bands = <
          item
            Caption = 'Legajo'
            FixedKind = fkLeft
            Width = 406
          end
          item
            Caption = 'Fechas'
            Width = 448
          end>
      end
      object dxPlanifRotasLevel1: TcxGridLevel
        GridView = dxPlanifRotasDBBandedTableView1
      end
    end
  end
  inherited DriverABM: TDriverABM
    OperGrabarObjeto = 'SavePlanifrotasLeg'
    CargaDataSets = <
      item
        DataSet = TCamposTablasPlanif
        TableName = 'TCamposTablasPlanif'
      end
      item
        DataSet = TPlanifRotas
        TableName = 'TPlanifRotas'
      end>
    DataSetCab = TPlanifRotas
    Top = 88
  end
  inherited Operacion: TOperacion
    Top = 104
  end
  inherited dxComponentPrinter: TdxComponentPrinter
    Top = 96
    inherited dxComponentPrinterLink1: TdxCustomContainerReportLink
      Component = Owner
      BuiltInReportLink = True
      HiddenComponents = {}
      ExcludedComponents = {}
      AggregatedReportLinks = {}
    end
  end
  inherited SaveDialog: TSaveDialog
    Top = 104
  end
  inherited DriverEvent: TDriverEvent
    OnInicializar = <
      item
        Source.Strings = (
          'begin'
          
            '  TValoresClasificador.loadFromAllData(getParamValue('#39'TValoresCl' +
            'asificador'#39'));'
          
            '  TLegajosAPlanif.loadFromAllData(getParamValue('#39'TLegajosAPlanif' +
            #39'));'
          '  TInput.loadFromAllData(getParamValue('#39'TInput'#39'));'
          '  varios.setImagen('#39'ImageSalir'#39',7);'
          '  inicializarGrilla();'
          'end.')
      end>
    OnFormFunction = <
      item
        Source.Strings = (
          'procedure grabarPlanifRotas();'
          'begin'
          '   TPlanifRotas.PostRecord;'
          '   operacion.InicioOperacion();'
          '   operacion.setOper('#39'SavePlanifrotasLeg'#39');'
          
            '   operacion.addAtribute('#39'fecha'#39',TInput.FieldName('#39'fecha'#39').AsStr' +
            'ing);'
          
            '   operacion.addAtribute('#39'dias'#39',TInput.FieldName('#39'dias'#39').AsStrin' +
            'g);'
          '   operacion.AddDataSet(TPlanifRotas.getDataSet);'
          '   operacion.execute;'
          'end;'
          ''
          'procedure AsignarEventosHelp(cantfechas : integer);'
          'var'
          '  script : string;'
          '  i : integer;'
          'begin'
          '  script := '#39'begin '#39'+'
          
            '               '#39'   HelpRotas.asignarValColACampo('#39#39'codigo'#39#39','#39#39'TP' +
            'lanifRotas'#39#39',dxPlanifRotas.getSelectedFieldName); '#39'+'
          '               '#39'   HelpRotas.Mostrar; '#39'+'
          '               '#39' end.'#39';'
          '  for i:=1 to cantfechas do'
          '    begin'
          
            '        DriverEvent.addOnClickButtonColumn('#39'C'#39'+IntToStr(i),scrip' +
            't);'
          '    end;'
          'end;'
          ''
          'procedure TraerPlanifLegajos();'
          'begin'
          '  operacion.InicioOperacion();'
          '  operacion.setOper('#39'TraerPlanifRotasLegajo'#39');'
          '  operacion.AddAtribute('#39'datosPlanif'#39','#39#39');'
          
            '  operacion.AddAtribute('#39'fecha'#39', TInput.FieldName('#39'fecha'#39').AsStr' +
            'ing);'
          
            '  operacion.AddAtribute('#39'dias'#39', TInput.FieldName('#39'dias'#39').AsStrin' +
            'g);'
          '  if (TInput.FieldName('#39'oid_clasif_agrupador'#39').AsInteger>0)'
          
            '     then operacion.AddAtribute('#39'oid_clasif_agrupador'#39',TInput.Fi' +
            'eldName('#39'oid_clasif_agrupador'#39').AsString);'
          '  operacion.AddDataSet(TLegajosAPlanif.getDataSet());'
          '   operacion.AddDataSet(TValoresClasificador.getDataSet);'
          '  operacion.execute();'
          'end;'
          ''
          'procedure CrearCamposGrillaDinamicos();'
          'var'
          '  col                     : TColumnaGrilla ;'
          '  j : integer;'
          'begin'
          ''
          '  dxPlanifRotas.setWidthBand(0,400); '
          
            '  dxPlanifRotas.setWidthBand(1,70*(TCamposTablasPlanif.count()-4' +
            '));'
          ''
          '  col := dxPlanifRotas.nuevaColumna('#39'agrupador'#39','#39#39') ;'
          '  col.setWidth(50);'
          '  col.setBandIndex(0);'
          '  col.setReadOnly(TRUE);'
          '  col.setVisible(false);'
          '  col.setGroupIndex(0);'
          ''
          '  col := dxPlanifRotas.nuevaColumna('#39'cod_legajo'#39','#39'Legajo'#39') ;'
          '  col.setWidth(50);'
          '  col.setBandIndex(0);'
          '  col.setReadOnly(TRUE);'
          ''
          
            '  col := dxPlanifRotas.nuevaColumna('#39'ape_y_nom'#39','#39'Apellido y Nomb' +
            're'#39') ;'
          '  col.setWidth(150);'
          '  col.setBandIndex(0);'
          '  col.setReadOnly(TRUE);'
          ''
          '  j := 0;'
          ''
          '  TCamposTablasPlanif.First;'
          '  while (not TCamposTablasPlanif.eof) do'
          '     begin'
          ''
          
            '     if ((TCamposTablasPlanif.FieldName('#39'campo'#39').AsString='#39'oid_l' +
            'egajo'#39') OR'
          
            '        (TCamposTablasPlanif.FieldName('#39'campo'#39').AsString='#39'cod_le' +
            'gajo'#39') OR'
          
            '        (TCamposTablasPlanif.FieldName('#39'campo'#39').AsString='#39'agrupa' +
            'dor'#39') OR'
          
            '        (TCamposTablasPlanif.FieldName('#39'campo'#39').AsString='#39'ape_y_' +
            'nom'#39'))'
          '        then begin'
          '                TCamposTablasPlanif.next;'
          '                continue;'
          '                end;'
          ''
          ''
          ''
          
            '     col := dxPlanifRotas.nuevaColumna(TCamposTablasPlanif.Field' +
            'Name('#39'campo'#39').AsString,TCamposTablasPlanif.FieldName('#39'nombre'#39').A' +
            'sString);'
          '     col.setWidth(125);'
          '     col.setBandIndex(1);'
          '     col.setColType(col.getTipoColButtonEdit());'
          '     inc(j);'
          '     col.ColumnName :='#39'C'#39'+IntToStr(j);'
          ''
          '     DriverEvent.addOnValidate('
          '               '#39'TPlanifRotas'#39','
          '               TCamposTablasPlanif.FieldName('#39'campo'#39').AsString,'
          
            '               '#39'begin ValidadorRota.Value := Sender.AsString; Va' +
            'lidadorRota.Validar(); end.'#39');'
          ''
          '     TCamposTablasPlanif.next;'
          '     end;'
          ''
          'end;'
          ''
          'procedure CrearCamposDinamicos();'
          'begin'
          ''
          '  TPlanifRotas.Close;'
          '  TPlanifRotas.Reset;'
          ''
          '  TCamposTablasPlanif.First;'
          '  while (not TCamposTablasPlanif.eof) do'
          '     begin'
          ''
          
            '     if (TCamposTablasPlanif.FieldName('#39'tipo'#39').AsString = '#39'INTEG' +
            'ER'#39')'
          '         then begin'
          
            '                 TPlanifRotas.AddIntegerField(TCamposTablasPlani' +
            'f.FieldName('#39'campo'#39').AsString);'
          '                 end'
          '         else'
          
            '     if (TCamposTablasPlanif.FieldName('#39'tipo'#39').AsString = '#39'STRIN' +
            'G'#39')'
          '         then begin'
          
            '                 TPlanifRotas.AddStringField(TCamposTablasPlanif' +
            '.FieldName('#39'campo'#39').AsString,TCamposTablasPlanif.FieldName('#39'long' +
            'itud'#39').AsInteger);'
          '                 end;'
          ''
          '     TCamposTablasPlanif.next;'
          '     end;'
          ''
          '    TPlanifRotas.Open;'
          ''
          'end;  '
          ''
          ''
          ''
          'procedure inicializarGrilla();'
          'begin'
          ''
          '  operacion.InicioOperacion();'
          '  operacion.setOper('#39'TraerPlanifRotasLegajo'#39');'
          '  operacion.AddAtribute('#39'inicializar'#39','#39#39');'
          
            '  operacion.AddAtribute('#39'fecha'#39', TInput.FieldName('#39'fecha'#39').AsStr' +
            'ing);'
          
            '  operacion.AddAtribute('#39'dias'#39', TInput.FieldName('#39'dias'#39').AsStrin' +
            'g);'
          '  operacion.execute();'
          '   '
          '  CrearCamposDinamicos();'
          '  CrearCamposGrillaDinamicos();'
          '  TraerPlanifLegajos();'
          '  AsignarEventosHelp(TInput.FieldName('#39'dias'#39').AsInteger);'
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
        ButtonName = 'BotonGrabarCambios'
        Source.Strings = (
          'begin'
          ''
          '  dxPlanifRotas.setDataSource(nil);'
          '  try   '
          '     grabarPlanifRotas();'
          '  finally'
          '     dxPlanifRotas.setDataSourceByName('#39'DSTPlanifRotas'#39');'
          '  end;'
          ''
          '  mensaje.information('#39'Se han grabado los cambios.'#39');'
          'end.')
      end>
    Top = 99
  end
  inherited ImprimirObjetoSeleccionado: TdxComponentPrinter
    inherited ImprimirObjetoSeleccionadodxComponentPrinterLink: TdxGridReportLink
      BuiltInReportLink = True
    end
  end
  object TValoresClasificador: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = False
    AttachMaxCount = 1
    AutoCalcFields = False
    FieldDefs = <
      item
        Name = 'oid_renglon'
        DataType = ftInteger
      end
      item
        Name = 'oid_clasificador'
        DataType = ftInteger
      end
      item
        Name = 'oid_valor_clasif'
        DataType = ftInteger
      end
      item
        Name = 'cod_valor_clasif'
        DataType = ftString
        Size = 50
      end
      item
        Name = 'desc_valor_clasif'
        DataType = ftString
        Size = 255
      end
      item
        Name = 'orden'
        DataType = ftInteger
      end>
    IndexFieldNames = 'oid_clasificador;orden'
    IndexDefs = <
      item
        Name = 'TValoresClasificadorIndex1'
        Fields = 'oid_clasificador;orden'
      end
      item
        Name = 'TValoresClasificadorIndex2'
        Fields = 'oid_clasificador;cod_valor_clasif'
        Options = [ixUnique]
      end>
    RecalcOnIndex = True
    RecalcOnFetch = False
    SortOptions = []
    PersistentBackup = False
    ProgressFlags = [mtpcLoad, mtpcSave, mtpcCopy]
    EnableVersioning = False
    VersioningMode = mtvmAllSinceCheckPoint
    FilterOptions = []
    Version = '4.08b'
    LanguageID = 0
    SortID = 0
    SubLanguageID = 1
    LocaleID = 1024
    MensajeValorDuplicadoIndice = 'Valor Duplicado'
    Left = 512
    Top = 111
    object TValoresClasificadoroid_renglon: TIntegerField
      FieldName = 'oid_renglon'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TValoresClasificadoroid_clasificador: TIntegerField
      FieldName = 'oid_clasificador'
    end
    object TValoresClasificadoroid_valor_clasif: TIntegerField
      FieldName = 'oid_valor_clasif'
    end
    object TValoresClasificadorcod_valor_clasif: TStringField
      FieldName = 'cod_valor_clasif'
      Size = 50
    end
    object TValoresClasificadordesc_valor_clasif: TStringField
      FieldName = 'desc_valor_clasif'
      Size = 255
    end
    object TValoresClasificadororden: TIntegerField
      AutoGenerateValue = arAutoInc
      FieldName = 'orden'
    end
  end
  object TLegajosAPlanif: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'oid_leg_a_planif'
        DataType = ftInteger
      end
      item
        Name = 'oid'
        DataType = ftInteger
      end
      item
        Name = 'oid_legajo'
        DataType = ftInteger
      end
      item
        Name = 'codigo'
        DataType = ftString
        Size = 50
      end
      item
        Name = 'nombre'
        DataType = ftString
        Size = 255
      end>
    IndexFieldNames = 'oid;orden'
    IndexDefs = <
      item
        Name = 'TLegajosAPlanifIndex1'
        Fields = 'oid;orden'
      end
      item
        Name = 'TLegajosAPlanifIndex2'
        Fields = 'codigo'
        Options = [ixUnique]
      end>
    RecalcOnIndex = True
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
    Left = 592
    Top = 113
    object TLegajosAPlanifoid_leg_a_planif: TIntegerField
      FieldName = 'oid_leg_a_planif'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TLegajosAPlanifoid: TIntegerField
      FieldName = 'oid'
    end
    object TLegajosAPlanifoid_legajo: TIntegerField
      FieldName = 'oid_legajo'
    end
    object TLegajosAPlanifcodigo: TStringField
      FieldName = 'codigo'
      Size = 50
    end
    object TLegajosAPlanifnombre: TStringField
      FieldName = 'nombre'
      Size = 255
    end
    object TLegajosAPlaniforden: TIntegerField
      AutoGenerateValue = arAutoInc
      FieldName = 'orden'
    end
  end
  object TInput: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'oid'
        DataType = ftInteger
      end
      item
        Name = 'fecha'
        DataType = ftDate
      end
      item
        Name = 'oid_clasif_agrupador'
        DataType = ftInteger
      end>
    IndexDefs = <>
    RecalcOnIndex = True
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
    MensajeValorDuplicadoIndice = 'Legajo ya ingresado'
    Left = 664
    Top = 112
    object TInputoid: TIntegerField
      FieldName = 'oid'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TInputfecha: TDateField
      FieldName = 'fecha'
    end
    object TInputoid_clasif_agrupador: TIntegerField
      FieldName = 'oid_clasif_agrupador'
    end
    object TInputdias: TIntegerField
      FieldName = 'dias'
    end
  end
  object TCamposTablasPlanif: TsnTable
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
    Left = 368
    Top = 385
    object TCamposTablasPlanifcampo: TStringField
      FieldName = 'campo'
      Size = 50
    end
    object TCamposTablasPlaniftipo: TStringField
      FieldName = 'tipo'
      Size = 50
    end
    object TCamposTablasPlaniflongitud: TIntegerField
      FieldName = 'longitud'
    end
    object TCamposTablasPlanifnombre: TStringField
      FieldName = 'nombre'
      Size = 50
    end
  end
  object TPlanifRotas: TsnTable
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
    Top = 265
    object TPlanifRotasdummy: TIntegerField
      FieldName = 'dummy'
    end
  end
  object Varios: TsnVarios
    Operacion = Operacion
    Left = 640
    Top = 185
  end
  object DSTPlanifRotas: TDataSource
    DataSet = TPlanifRotas
    Left = 344
    Top = 265
  end
  object DSInput: TDataSource
    DataSet = TInput
    Left = 696
    Top = 113
  end
  object HelpRotas: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'cip.Rota'
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
    Titulo = 'Rotas'
    AnchoHelp = 600
    ActivarCache = False
    ShowBotonBuscar = False
    Left = 570
    Top = 359
  end
  object ValidadorRota: TValidador
    Operacion = Operacion
    NickNameObjLog = 'cip.Rota'
    MensajeException = 'C'#243'digo de Rota Inexistente'
    NroQuery = 0
    Cache = True
    Left = 606
    Top = 359
  end
end
