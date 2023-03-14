inherited FMigraSECLOS1: TFMigraSECLOS1
  Caption = 'Migraci'#243'n de JUICIOS'
  Position = poScreenCenter
  PixelsPerInch = 96
  TextHeight = 13
  object Panel1: TPanel [0]
    Left = 0
    Top = 0
    Width = 779
    Height = 41
    Align = alTop
    Color = clWindow
    TabOrder = 0
    object Label1: TLabel
      Left = 8
      Top = 8
      Width = 210
      Height = 23
      Caption = 'Migraci'#243'n de JUICIOS'
      Font.Charset = ANSI_CHARSET
      Font.Color = clWindowText
      Font.Height = -19
      Font.Name = 'Verdana'
      Font.Style = []
      ParentFont = False
    end
    object BotonMigrarElementos: TsnButton
      Left = 240
      Top = 8
      Width = 153
      Height = 25
      Caption = 'Migrar Elementos'
      TabOrder = 0
      LookAndFeel.Kind = lfOffice11
    end
    object snDBCheckEdit1: TsnDBCheckEdit
      Left = 456
      Top = 8
      Caption = 'Solo Validar'
      DataBinding.DataField = 'solo_validar'
      DataBinding.DataSource = DSInput
      TabOrder = 1
      Width = 81
    end
  end
  object Panel2: TPanel [1]
    Left = 0
    Top = 41
    Width = 779
    Height = 436
    Align = alClient
    Color = clWindow
    TabOrder = 1
    object PageControlSN1: TPageControlSN
      Left = 1
      Top = 1
      Width = 777
      Height = 434
      ActivePage = TabSheet1
      Align = alClient
      TabOrder = 0
      object TabSheet1: TTabSheet
        Caption = 'Resultados'
        object dxDBGridSN1: TdxDBGridSN
          Left = 0
          Top = 0
          Width = 769
          Height = 406
          Align = alClient
          TabOrder = 0
          CriteriosPintarCelda = <>
          object dxDBGridSN1DBTableView1: TcxGridDBTableView
            NavigatorButtons.ConfirmDelete = False
            DataController.DataSource = DSJuicios
            DataController.Summary.DefaultGroupSummaryItems = <>
            DataController.Summary.FooterSummaryItems = <>
            DataController.Summary.SummaryGroups = <>
            OptionsView.GroupByBox = False
            object dxDBGridSN1DBTableView1Column1: TcxGridDBColumn
              Caption = 'N'
              DataBinding.FieldName = 'codigo_interno'
              Width = 75
            end
            object dxDBGridSN1DBTableView1legajo: TcxGridDBColumn
              Caption = 'Legajo'
              DataBinding.FieldName = 'legajo'
              Width = 124
            end
            object dxDBGridSN1DBTableView1ape_y_nom: TcxGridDBColumn
              Caption = 'Empleado'
              DataBinding.FieldName = 'ape_y_nom'
              HeaderAlignmentHorz = taCenter
              Width = 167
            end
            object dxDBGridSN1DBTableView1empresa: TcxGridDBColumn
              Caption = 'Codigo Procedencia'
              DataBinding.FieldName = 'empresa'
              Width = 112
            end
            object dxDBGridSN1DBTableView1procedencia: TcxGridDBColumn
              Caption = 'Procedencia'
              DataBinding.FieldName = 'procedencia'
              HeaderAlignmentHorz = taCenter
              Width = 186
            end
            object dxDBGridSN1DBTableView1Column20: TcxGridDBColumn
              Caption = 'Estado Juicio'
              DataBinding.FieldName = 'estado_juicio'
              Width = 134
            end
            object dxDBGridSN1DBTableView1Column9: TcxGridDBColumn
              DataBinding.FieldName = 'D1'
              Width = 100
            end
            object dxDBGridSN1DBTableView1Column10: TcxGridDBColumn
              DataBinding.FieldName = 'D2'
              Width = 100
            end
            object dxDBGridSN1DBTableView1Column11: TcxGridDBColumn
              DataBinding.FieldName = 'D3'
              Width = 100
            end
            object dxDBGridSN1DBTableView1Column12: TcxGridDBColumn
              DataBinding.FieldName = 'D4'
              Width = 100
            end
            object dxDBGridSN1DBTableView1Column13: TcxGridDBColumn
              Caption = 'Causal Distracto'
              DataBinding.FieldName = 'causal_distracto'
              Width = 156
            end
            object dxDBGridSN1DBTableView1Column14: TcxGridDBColumn
              Caption = 'Tipo de Reclamo'
              DataBinding.FieldName = 'tipo_reclamo'
              Width = 150
            end
            object dxDBGridSN1DBTableView1monto_reclamo: TcxGridDBColumn
              Caption = 'Monto Reclamo'
              DataBinding.FieldName = 'monto_reclamo'
              HeaderAlignmentHorz = taCenter
              HeaderAlignmentVert = vaCenter
              Width = 124
            end
            object dxDBGridSN1DBTableView1Column2: TcxGridDBColumn
              Caption = 'Resultado'
              DataBinding.FieldName = 'resultado'
              HeaderAlignmentHorz = taCenter
              Width = 91
            end
            object dxDBGridSN1DBTableView1Column3: TcxGridDBColumn
              Caption = 'Previsi'#243'n'
              DataBinding.FieldName = 'prevision'
              HeaderAlignmentHorz = taCenter
              Width = 104
            end
            object dxDBGridSN1DBTableView1Column4: TcxGridDBColumn
              Caption = 'Estimado'
              DataBinding.FieldName = 'estimado'
              HeaderAlignmentHorz = taCenter
              HeaderAlignmentVert = vaCenter
              Width = 101
            end
            object dxDBGridSN1DBTableView1Column5: TcxGridDBColumn
              Caption = 'Etapa procesal'
              DataBinding.FieldName = 'etapa_procesal'
              HeaderAlignmentHorz = taCenter
              Width = 100
            end
            object dxDBGridSN1DBTableView1Column6: TcxGridDBColumn
              Caption = 'Fecha recepci'#243'n '
              DataBinding.FieldName = 'fec_recepcion'
              HeaderAlignmentVert = vaCenter
              Width = 111
            end
            object dxDBGridSN1DBTableView1Column7: TcxGridDBColumn
              Caption = 'Nro. expediente'
              DataBinding.FieldName = 'nro_expediente'
              Width = 151
            end
            object dxDBGridSN1DBTableView1Column8: TcxGridDBColumn
              Caption = 'N Juzgado'
              DataBinding.FieldName = 'nro_juzgado'
              Width = 95
            end
            object dxDBGridSN1DBTableView1Column15: TcxGridDBColumn
              Caption = 'Monto Acuerdo por capital'
              DataBinding.FieldName = 'monto_acuerdo_capital'
              Width = 141
            end
            object dxDBGridSN1DBTableView1Column16: TcxGridDBColumn
              Caption = 'Monto Honorarios Letrado'
              DataBinding.FieldName = 'monto_honorarios_letrado'
              Width = 143
            end
            object dxDBGridSN1DBTableView1Column17: TcxGridDBColumn
              Caption = 'Monto Honorarios Perito'
              DataBinding.FieldName = 'monto_honorarios_perito'
              Width = 134
            end
            object dxDBGridSN1DBTableView1Column21: TcxGridDBColumn
              Caption = 'Monto Conciliador'
              DataBinding.FieldName = 'monto_conciliado'
              HeaderAlignmentHorz = taCenter
              Width = 107
            end
            object dxDBGridSN1DBTableView1Column22: TcxGridDBColumn
              Caption = 'Tasa Justicia'
              DataBinding.FieldName = 'tasa_justicia'
              HeaderAlignmentHorz = taCenter
              Width = 102
            end
            object dxDBGridSN1DBTableView1observaciones: TcxGridDBColumn
              Caption = 'Observaciones'
              DataBinding.FieldName = 'observaciones'
              Width = 300
            end
            object dxDBGridSN1DBTableView1Column18: TcxGridDBColumn
              Caption = 'Rubros de Condena'
              DataBinding.FieldName = 'rubros_condena'
              HeaderAlignmentHorz = taCenter
              HeaderGlyphAlignmentHorz = taCenter
              Width = 150
            end
            object dxDBGridSN1DBTableView1Column19: TcxGridDBColumn
              Caption = 'Mes Deposito Monto conciliado'
              DataBinding.FieldName = 'fec_novedad'
              Width = 100
            end
          end
          object dxDBGridSN1Level1: TcxGridLevel
            GridView = dxDBGridSN1DBTableView1
          end
        end
      end
      object TabSheet5: TTabSheet
        Caption = 'Migrados OK'
        ImageIndex = 4
        object dxDBGridSN5: TdxDBGridSN
          Left = 0
          Top = 0
          Width = 769
          Height = 406
          Align = alClient
          TabOrder = 0
          CriteriosPintarCelda = <>
          object cxGridDBTableView4: TcxGridDBTableView
            NavigatorButtons.ConfirmDelete = False
            DataController.DataSource = DSMigradosOK
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
            object cxGridDBColumn5: TcxGridDBColumn
              DataBinding.FieldName = 'codigo'
              Width = 200
            end
            object cxGridDBColumn6: TcxGridDBColumn
              DataBinding.FieldName = 'descripcion'
              Width = 472
            end
          end
          object cxGridLevel4: TcxGridLevel
            GridView = cxGridDBTableView4
          end
        end
      end
      object TabSheet4: TTabSheet
        Caption = 'Registros NO Migrados'
        ImageIndex = 3
        object dxDBGridSN4: TdxDBGridSN
          Left = 0
          Top = 0
          Width = 769
          Height = 406
          Align = alClient
          TabOrder = 0
          CriteriosPintarCelda = <>
          object cxGridDBTableView3: TcxGridDBTableView
            NavigatorButtons.ConfirmDelete = False
            DataController.DataSource = DSRegNoMigrados
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
            object cxGridDBColumn3: TcxGridDBColumn
              DataBinding.FieldName = 'codigo'
              Width = 200
            end
            object cxGridDBColumn4: TcxGridDBColumn
              DataBinding.FieldName = 'descripcion'
              Width = 472
            end
          end
          object cxGridLevel3: TcxGridLevel
            GridView = cxGridDBTableView3
          end
        end
      end
      object TabSheet2: TTabSheet
        Caption = 'Legajos NO Importados'
        ImageIndex = 1
        object dxDBGridSN2: TdxDBGridSN
          Left = 0
          Top = 0
          Width = 769
          Height = 406
          Align = alClient
          TabOrder = 0
          CriteriosPintarCelda = <>
          object cxGridDBTableView1: TcxGridDBTableView
            NavigatorButtons.ConfirmDelete = False
            DataController.DataSource = DSLegNoEnc
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
            object cxGridDBTableView1codigo: TcxGridDBColumn
              DataBinding.FieldName = 'codigo'
              Width = 200
            end
            object cxGridDBTableView1descripcion: TcxGridDBColumn
              DataBinding.FieldName = 'descripcion'
              Width = 472
            end
          end
          object cxGridLevel1: TcxGridLevel
            GridView = cxGridDBTableView1
          end
        end
      end
      object TabSheet3: TTabSheet
        Caption = 'Errores encontrados'
        ImageIndex = 2
        object dxDBGridSN3: TdxDBGridSN
          Left = 0
          Top = 0
          Width = 769
          Height = 406
          Align = alClient
          TabOrder = 0
          CriteriosPintarCelda = <>
          object cxGridDBTableView2: TcxGridDBTableView
            NavigatorButtons.ConfirmDelete = False
            DataController.DataSource = DSErroresEnc
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
            object cxGridDBColumn1: TcxGridDBColumn
              DataBinding.FieldName = 'nro_linea'
              Width = 200
            end
            object cxGridDBColumn2: TcxGridDBColumn
              DataBinding.FieldName = 'descripcion'
              Width = 472
            end
          end
          object cxGridLevel2: TcxGridLevel
            GridView = cxGridDBTableView2
          end
        end
      end
    end
  end
  inherited DriverABM: TDriverABM
    CargaDataSets = <
      item
        DataSet = TLegajosNoEnco
        TableName = 'TLegajosNoEnco'
      end
      item
        DataSet = TErroresEnc
        TableName = 'TErroresEnc'
      end
      item
        DataSet = TRegNoMigrados
        TableName = 'TRegNoMigrados'
      end
      item
        DataSet = TMigradosOK
        TableName = 'TMigradosOK'
      end>
    Left = 192
    Top = 112
  end
  inherited Operacion: TOperacion
    Left = 232
    Top = 112
  end
  inherited dxComponentPrinter: TdxComponentPrinter
    Left = 272
    Top = 112
    inherited dxComponentPrinterLink1: TdxCustomContainerReportLink
      Component = Owner
      BuiltInReportLink = True
      HiddenComponents = {}
      ExcludedComponents = {}
      AggregatedReportLinks = {}
    end
  end
  inherited SaveDialog: TSaveDialog
    Left = 312
    Top = 112
  end
  inherited DriverEvent: TDriverEvent
    OnInicializar = <
      item
        Source.Strings = (
          'begin'
          '  TJuicios.Close;'
          '  TJuicios.Open;'
          '  TJuicios.AppendRecord;'
          '  Tinput.Close;'
          '  Tinput.Open;'
          '  Tinput.AppendRecord;'
          'end.')
      end>
    OnFormFunction = <
      item
        Source.Strings = (
          'procedure Importar();'
          'begin'
          '  TJuicios.PostRecord;'
          '  Tinput.postRecord;'
          '  operacion.InicioOperacion();'
          '  operacion.setOper('#39'MigrarElementosSeclo1'#39');'
          '  if (Tinput.FieldName('#39'solo_validar'#39').AsBoolean)'
          '     then operacion.addAtribute('#39'solo_validar'#39','#39#39');'
          '  operacion.addDataSet(TJuicios.getDataSet());'
          ''
          '  operacion.execute();'
          'end;')
      end>
    OnClickToolButton = <
      item
        ButtonName = 'BotonMigrarElementos'
        Source.Strings = (
          'begin'
          '  IF (mensaje.question('#39'Desea importar los SECLOS?'#39'))'
          '     then begin'
          '             Importar();'
          '             mensaje.information('#39'Fin del proceso.'#39');'
          '             end; '
          'end.')
      end>
    Left = 352
    Top = 115
  end
  inherited ImprimirObjetoSeleccionado: TdxComponentPrinter
    inherited ImprimirObjetoSeleccionadodxComponentPrinterLink: TdxGridReportLink
      BuiltInReportLink = True
    end
  end
  inherited TTempVarForm: TsnTable
    Top = 240
  end
  object TJuicios: TsnTable
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
    Left = 624
    Top = 104
    object TJuicioscodigo: TStringField
      FieldName = 'codigo'
      Size = 50
    end
    object TJuicioslegajo: TStringField
      FieldName = 'legajo'
      Size = 50
    end
    object TJuiciosape_y_nom: TStringField
      FieldName = 'ape_y_nom'
      Size = 255
    end
    object TJuiciosempresa: TStringField
      FieldName = 'empresa'
      Size = 5
    end
    object TJuiciosprocedencia: TStringField
      FieldName = 'procedencia'
      Size = 50
    end
    object TJuicioscod_correquerido: TStringField
      FieldName = 'cod_correquerido'
      Size = 10
    end
    object TJuicioscorrequerido: TStringField
      FieldName = 'correquerido'
      Size = 50
    end
    object TJuiciospuesto: TStringField
      FieldName = 'puesto'
      Size = 100
    end
    object TJuicioscentro_costo: TStringField
      FieldName = 'centro_costo'
      Size = 100
    end
    object TJuiciosfec_ant_rec: TDateField
      FieldName = 'fec_ant_rec'
    end
    object TJuiciosfec_ing_real: TDateField
      FieldName = 'fec_ing_real'
    end
    object TJuiciosfec_egreso: TDateField
      FieldName = 'fec_egreso'
    end
    object TJuiciosmot_egreso: TStringField
      FieldName = 'mot_egreso'
      Size = 100
    end
    object TJuiciosant_en_empresa: TFloatField
      FieldName = 'ant_en_empresa'
    end
    object TJuiciostipo_reclamo: TStringField
      FieldName = 'tipo_reclamo'
      Size = 100
    end
    object TJuiciosmonto_reclamo: TFloatField
      FieldName = 'monto_reclamo'
    end
    object TJuiciosestado_del_seclo: TStringField
      FieldName = 'estado_del_seclo'
      Size = 100
    end
    object TJuiciosmes_recepcion: TDateField
      FieldName = 'mes_recepcion'
    end
    object TJuiciosobservaciones: TStringField
      FieldName = 'observaciones'
      Size = 5000
    end
    object TJuicioscodigo_interno: TStringField
      FieldName = 'codigo_interno'
      Size = 50
    end
    object TJuiciosresultado: TStringField
      FieldName = 'resultado'
      Size = 50
    end
    object TJuiciosprevision: TFloatField
      FieldName = 'prevision'
    end
    object TJuiciosestimado: TFloatField
      FieldName = 'estimado'
    end
    object TJuiciosetapa_procesal: TStringField
      FieldName = 'etapa_procesal'
      Size = 100
    end
    object TJuiciosfec_recepcion: TDateField
      FieldName = 'fec_recepcion'
    end
    object TJuiciosnro_expediente: TStringField
      FieldName = 'nro_expediente'
      Size = 100
    end
    object TJuiciosnro_juzgado: TStringField
      FieldName = 'nro_juzgado'
      Size = 100
    end
    object TJuiciosD1: TStringField
      FieldName = 'D1'
      Size = 100
    end
    object TJuiciosD2: TStringField
      FieldName = 'D2'
      Size = 100
    end
    object TJuiciosD3: TStringField
      FieldName = 'D3'
      Size = 100
    end
    object TJuiciosD4: TStringField
      FieldName = 'D4'
      Size = 100
    end
    object TJuicioscausal_distracto: TStringField
      FieldName = 'causal_distracto'
      Size = 100
    end
    object TJuiciosmonto_acuerdo_capital: TFloatField
      FieldName = 'monto_acuerdo_capital'
    end
    object TJuiciosmonto_honorarios_letrado: TFloatField
      FieldName = 'monto_honorarios_letrado'
    end
    object TJuiciosmonto_honorarios_perito: TFloatField
      FieldName = 'monto_honorarios_perito'
    end
    object TJuiciosmonto_conciliado: TFloatField
      FieldName = 'monto_conciliado'
    end
    object TJuiciostasa_justicia: TFloatField
      FieldName = 'tasa_justicia'
    end
    object TJuiciosrubros_condena: TStringField
      FieldName = 'rubros_condena'
      Size = 255
    end
    object TJuiciosfec_novedad: TDateField
      FieldName = 'fec_novedad'
    end
    object TJuiciosestado_juicio: TStringField
      FieldName = 'estado_juicio'
      Size = 100
    end
  end
  object DSJuicios: TDataSource
    DataSet = TJuicios
    Left = 664
    Top = 105
  end
  object TLegajosNoEnco: TsnTable
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
    Left = 125
    Top = 202
    object TLegajosNoEncocodigo: TStringField
      FieldName = 'codigo'
      Size = 50
    end
    object TLegajosNoEncodescripcion: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
  end
  object DSLegNoEnc: TDataSource
    DataSet = TLegajosNoEnco
    Left = 165
    Top = 202
  end
  object TErroresEnc: TsnTable
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
    Left = 469
    Top = 162
    object TErroresEncnro_linea: TStringField
      FieldName = 'nro_linea'
      Size = 50
    end
    object TErroresEncdescripcion: TStringField
      FieldName = 'descripcion'
      Size = 255
    end
  end
  object DSErroresEnc: TDataSource
    DataSet = TErroresEnc
    Left = 501
    Top = 162
  end
  object TRegNoMigrados: TsnTable
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
    Left = 285
    Top = 298
    object TRegNoMigradoscodigo: TStringField
      FieldName = 'codigo'
      Size = 50
    end
    object TRegNoMigradosdescripcion: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
  end
  object DSRegNoMigrados: TDataSource
    DataSet = TRegNoMigrados
    Left = 317
    Top = 298
  end
  object TMigradosOK: TsnTable
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
    Left = 437
    Top = 306
    object TMigradosOKcodigo: TStringField
      FieldName = 'codigo'
      Size = 50
    end
    object TMigradosOKdescripcion: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
  end
  object DSMigradosOK: TDataSource
    DataSet = TMigradosOK
    Left = 469
    Top = 306
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
    Left = 509
    Top = 106
    object Tinputsolo_validar: TBooleanField
      FieldName = 'solo_validar'
    end
  end
  object DSInput: TDataSource
    DataSet = Tinput
    Left = 541
    Top = 106
  end
end
