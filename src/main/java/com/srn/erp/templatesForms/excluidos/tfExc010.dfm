inherited FEstadosExcluidos: TFEstadosExcluidos
  Left = 94
  Top = 120
  Width = 730
  Height = 592
  Caption = 'Estados de Excluidos'
  PixelsPerInch = 96
  TextHeight = 13
  inherited PForm: TPanel
    Width = 714
    Height = 554
    inherited PPie: TPanel
      Top = 533
      Width = 714
      inherited StatusBarABM: TStatusBar
        Left = 609
      end
      inherited StatusBar2: TStatusBar
        Width = 609
      end
    end
    inherited PMenu: TPanel
      Width = 714
      inherited ImagenEliminar: TImagenEstado
        DataField = 'activo'
        DataSource = dsTEstadoExcluido
        ValorEstadoVisible = 'True'
      end
      inherited ImagenRehabilitar: TImagenEstado
        DataField = 'activo'
        DataSource = dsTEstadoExcluido
        ValorEstadoVisible = 'False'
      end
      inherited ImagenBuscar: TImagenHelpObjNeg
        Help = HelpEstadosExcluidos
      end
      inherited ImagenSiguiente: TImagenHelpObjNeg
        Help = HelpEstadosExcluidos
      end
      inherited ImagenAnterior: TImagenHelpObjNeg
        Help = HelpEstadosExcluidos
      end
      inherited Panel2: TPanel
        Left = 673
      end
      inherited PanelEstadoON: TPanelEstado
        DataField = 'activo'
        DataSource = dsTEstadoExcluido
        Leyendas = <
          item
            Titulo = 'Inactivo'
            ColorTitulo = clWhite
            ValorEstado = 'false'
            Visible = True
            ColorPanel = clRed
          end>
      end
    end
    inherited POpcionesMenu: TPanel
      Width = 714
    end
    inherited PCabecera: TPanel
      Width = 714
    end
    inherited PCuerpo: TPanel
      Width = 714
      Height = 458
      object Label1: TLabel
        Left = 40
        Top = 8
        Width = 33
        Height = 13
        Caption = 'C'#243'digo'
      end
      object Label2: TLabel
        Left = 40
        Top = 48
        Width = 56
        Height = 13
        Caption = 'Descripci'#243'n'
      end
      object Label3: TLabel
        Left = 40
        Top = 88
        Width = 24
        Height = 13
        Caption = 'Peso'
      end
      object Label4: TLabel
        Left = 40
        Top = 128
        Width = 24
        Height = 13
        Caption = 'Color'
      end
      object snLabel1: TsnLabel
        Left = 288
        Top = 172
        Width = 90
        Height = 13
        Caption = 'Ult. Nro. Propuesto'
      end
      object DBECodigo: TsnDBEdit
        Left = 156
        Top = 4
        DataBinding.DataField = 'codigo'
        DataBinding.DataSource = dsTEstadoExcluido
        Properties.CharCase = ecUpperCase
        Properties.MaxLength = 20
        Style.BorderColor = clWindowFrame
        Style.Color = clWindow
        Style.Shadow = False
        TabOrder = 0
        Width = 133
      end
      object snDBEdit1: TsnDBEdit
        Left = 156
        Top = 44
        DataBinding.DataField = 'descripcion'
        DataBinding.DataSource = dsTEstadoExcluido
        Properties.MaxLength = 50
        Style.BorderColor = clWindowFrame
        Style.Shadow = False
        TabOrder = 1
        Width = 429
      end
      object snDBEdit2: TsnDBEdit
        Left = 156
        Top = 84
        DataBinding.DataField = 'peso'
        DataBinding.DataSource = dsTEstadoExcluido
        Properties.CharCase = ecUpperCase
        Properties.MaxLength = 20
        Style.BorderColor = clWindowFrame
        Style.Shadow = False
        TabOrder = 2
        Width = 133
      end
      object snDBLookup1: TsnDBLookup
        Left = 156
        Top = 125
        DataBinding.DataField = 'color'
        DataBinding.DataSource = dsTEstadoExcluido
        Properties.KeyFieldNames = 'codigo'
        Properties.ListColumns = <
          item
            FieldName = 'descripcion'
          end>
        Properties.ListOptions.ShowHeader = False
        Properties.ListSource = DSColores
        TabOrder = 3
        Width = 204
      end
      object snDBCheckEdit1: TsnDBCheckEdit
        Left = 152
        Top = 168
        Caption = 'Proponer N'#250'mero'
        DataBinding.DataField = 'proponer_nro'
        DataBinding.DataSource = dsTEstadoExcluido
        TabOrder = 4
        Width = 113
      end
      object snDBEdit3: TsnDBEdit
        Left = 388
        Top = 168
        DataBinding.DataField = 'ult_nro_propu'
        DataBinding.DataSource = dsTEstadoExcluido
        Properties.CharCase = ecUpperCase
        Properties.MaxLength = 20
        Style.BorderColor = clWindowFrame
        Style.Shadow = False
        TabOrder = 5
        Width = 133
      end
      object snDBCheckEdit2: TsnDBCheckEdit
        Left = 152
        Top = 200
        Caption = 'Nro. Acta Obligatorio'
        DataBinding.DataField = 'nro_acta_obli'
        DataBinding.DataSource = dsTEstadoExcluido
        TabOrder = 6
        Width = 137
      end
      object snDBCheckEdit3: TsnDBCheckEdit
        Left = 283
        Top = 200
        Caption = 'Permitir Modificar N'#250'mero de Acta'
        DataBinding.DataField = 'permite_modif_nro'
        DataBinding.DataSource = dsTEstadoExcluido
        TabOrder = 7
        Width = 230
      end
      object snDBCheckEdit4: TsnDBCheckEdit
        Left = 152
        Top = 232
        Caption = 'Conserva N'#250'mero'
        DataBinding.DataField = 'conserva_nro'
        DataBinding.DataSource = dsTEstadoExcluido
        TabOrder = 8
        Width = 137
      end
      object dxDBDifImportes: TdxDBGridSN
        Left = 17
        Top = 272
        Width = 688
        Height = 165
        TabOrder = 9
        CriteriosPintarCelda = <
          item
            TipoPintadaCelda = tpcTodasLasColumnas
            FieldName1 = 'activo'
            TipoCondFiltro1 = tcfIgual
            Valor1 = '2'
            TipoCondFiltro2 = tcfIgual
            Color = clRed
          end>
        object dxDBDifImportesDBTableView1: TcxGridDBTableView
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
          NavigatorButtons.Insert.Hint = 'Insertar Motivo'
          NavigatorButtons.Insert.Visible = False
          NavigatorButtons.Append.Hint = 'Insertar Motivo'
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
          DataController.DataSource = DSTEstadoPredioExc
          DataController.Summary.DefaultGroupSummaryItems = <>
          DataController.Summary.FooterSummaryItems = <>
          DataController.Summary.SummaryGroups = <>
          OptionsBehavior.PostponedSynchronization = False
          OptionsBehavior.AlwaysShowEditor = True
          OptionsBehavior.FocusCellOnTab = True
          OptionsBehavior.FocusFirstCellOnNewRecord = True
          OptionsBehavior.FocusCellOnCycle = True
          OptionsCustomize.ColumnFiltering = False
          OptionsData.Appending = True
          OptionsData.CancelOnExit = False
          OptionsData.Deleting = False
          OptionsData.DeletingConfirmation = False
          OptionsData.Inserting = False
          OptionsSelection.InvertSelect = False
          OptionsView.Navigator = True
          OptionsView.GroupByBox = False
          object dxDBDifImportesDBTableView1oid_predio: TcxGridDBColumn
            Caption = 'Predio'
            DataBinding.FieldName = 'oid_predio'
            PropertiesClassName = 'TcxLookupComboBoxProperties'
            Properties.KeyFieldNames = 'oid'
            Properties.ListColumns = <
              item
                FieldName = 'codigo'
              end>
            Properties.ListOptions.ShowHeader = False
            Properties.ListSource = DSPredios
            Width = 108
          end
          object dxDBDifImportesDBTableView1proponer_nro: TcxGridDBColumn
            Caption = 'Proponer Nro.'
            DataBinding.FieldName = 'proponer_nro'
            PropertiesClassName = 'TcxCheckBoxProperties'
            HeaderAlignmentHorz = taCenter
            Width = 97
          end
          object dxDBDifImportesDBTableView1ult_nro_propu: TcxGridDBColumn
            Caption = 'Ult. Nro. Propuesto'
            DataBinding.FieldName = 'ult_nro_propu'
            HeaderAlignmentHorz = taCenter
            Width = 129
          end
          object dxDBDifImportesDBTableView1nro_acta_obli: TcxGridDBColumn
            Caption = 'Nro. Acta Obligatoria'
            DataBinding.FieldName = 'nro_acta_obli'
            PropertiesClassName = 'TcxCheckBoxProperties'
            Width = 109
          end
          object dxDBDifImportesDBTableView1permite_modif_nro: TcxGridDBColumn
            Caption = 'Permite Modif. Nro. Acta'
            DataBinding.FieldName = 'permite_modif_nro'
            PropertiesClassName = 'TcxCheckBoxProperties'
            Width = 123
          end
          object dxDBDifImportesDBTableView1activo: TcxGridDBColumn
            DataBinding.FieldName = 'activo'
            PropertiesClassName = 'TcxCheckBoxProperties'
            HeaderAlignmentHorz = taCenter
            Width = 44
          end
        end
        object dxDBDifImportesLevel1: TcxGridLevel
          GridView = dxDBDifImportesDBTableView1
        end
      end
      object snDBCheckEdit5: TsnDBCheckEdit
        Left = 283
        Top = 232
        Caption = 'Mostrar en Filtro de Tablet'
        DataBinding.DataField = 'publicar_en_filtro'
        DataBinding.DataSource = dsTEstadoExcluido
        TabOrder = 10
        Width = 150
      end
      object snDBCheckEdit6: TsnDBCheckEdit
        Left = 451
        Top = 232
        Caption = 'Restricci'#243'n Ingreso'
        DataBinding.DataField = 'restriccion_acceso'
        DataBinding.DataSource = dsTEstadoExcluido
        TabOrder = 11
        Width = 150
      end
    end
  end
  inherited DriverABM: TDriverABM
    OperTraerObjeto = 'TraerEstadoExcluido'
    OperGrabarObjeto = 'SaveEstadoExcluido'
    CargaDataSets = <
      item
        DataSet = TEstadoExcluido
        TableName = 'TEstadoExcluido'
      end
      item
        DataSet = TColores
        TableName = 'TColores'
      end
      item
        DataSet = TEstadoPredioExc
        TableName = 'TEstadoPredioExc'
      end>
    BajaLogica = <
      item
        DataSet = TEstadoExcluido
        ValorBaja = 'false'
        ValorRehabilitacion = 'true'
        TipoBajaRegistro = tblCurrentRecord
        FieldName = 'activo'
      end>
    OperHabilitadas = [toOperNuevo, toOperModificar, toOperEliminar, toOperBuscar, toOperNavegacion, toOperRehabilitar]
    DataSetCab = TEstadoExcluido
    DataSetDet1 = TEstadoPredioExc
    ControlFocoAlta = DBECodigo
    ControlFocoModif = DBECodigo
    Left = 512
    Top = 16
  end
  inherited Operacion: TOperacion
    Left = 552
    Top = 16
  end
  object TEstadoExcluido: TsnTable [3]
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'oid_estado'
        DataType = ftInteger
      end
      item
        Name = 'codigo'
        DataType = ftString
        Size = 20
      end
      item
        Name = 'descripcion'
        DataType = ftString
        Size = 50
      end
      item
        Name = 'peso'
        DataType = ftInteger
      end
      item
        Name = 'color'
        DataType = ftString
        Size = 20
      end
      item
        Name = 'activo'
        DataType = ftBoolean
      end
      item
        Name = 'proponer_nro'
        DataType = ftBoolean
      end
      item
        Name = 'ult_nro_propu'
        DataType = ftInteger
      end
      item
        Name = 'nro_acta_obli'
        DataType = ftBoolean
      end
      item
        Name = 'permite_modif_nro'
        DataType = ftBoolean
      end
      item
        Name = 'conserva_nro'
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
    Left = 648
    Top = 59
    object TEstadoExcluidooid_estado: TIntegerField
      FieldName = 'oid_estado'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TEstadoExcluidocodigo: TStringField
      DisplayWidth = 20
      FieldName = 'codigo'
    end
    object TEstadoExcluidodescripcion: TStringField
      DisplayWidth = 50
      FieldName = 'descripcion'
      Size = 50
    end
    object TEstadoExcluidopeso: TIntegerField
      FieldName = 'peso'
    end
    object TEstadoExcluidocolor: TStringField
      FieldName = 'color'
    end
    object TEstadoExcluidoactivo: TBooleanField
      DefaultExpression = '1'
      FieldName = 'activo'
    end
    object TEstadoExcluidoproponer_nro: TBooleanField
      FieldName = 'proponer_nro'
    end
    object TEstadoExcluidoult_nro_propu: TIntegerField
      FieldName = 'ult_nro_propu'
    end
    object TEstadoExcluidonro_acta_obli: TBooleanField
      FieldName = 'nro_acta_obli'
    end
    object TEstadoExcluidopermite_modif_nro: TBooleanField
      FieldName = 'permite_modif_nro'
    end
    object TEstadoExcluidoconserva_nro: TBooleanField
      FieldName = 'conserva_nro'
    end
    object TEstadoExcluidopublicar_en_filtro: TBooleanField
      FieldName = 'publicar_en_filtro'
    end
    object TEstadoExcluidorestriccion_acceso: TBooleanField
      FieldName = 'restriccion_acceso'
    end
  end
  object dsTEstadoExcluido: TDataSource [4]
    DataSet = TEstadoExcluido
    Left = 680
    Top = 59
  end
  inherited TOidObjSave: TsnTable
    Left = 608
  end
  inherited TOpcHabPrograma: TsnTable
    Top = 16
  end
  inherited dxComponentPrinter: TdxComponentPrinter
    Left = 168
    Top = 56
    inherited dxComponentPrinterLink1: TdxCustomContainerReportLink
      Component = Owner
      BuiltInReportLink = True
      HiddenComponents = {}
      ExcludedComponents = {}
      AggregatedReportLinks = {}
    end
  end
  inherited SaveDialog: TSaveDialog
    Left = 400
  end
  inherited DriverEvent: TDriverEvent
    OnValidate = <
      item
        TableName = 'TEstadoExcluido'
        FieldName = 'codigo'
        Source.Strings = (
          'begin'
          '  ValidadorEstado.Value := Sender.AsString;'
          '  ValidadorEstado.Validar;'
          'end.')
      end>
    OnBeforePost = <
      item
        TableName = 'TEstadoPredioExc'
        Source.Strings = (
          'begin'
          '  if (DataSet.FieldName('#39'oid_predio'#39').AsInteger=0)'
          
            '     then raiseException(erCustomError,'#39'Debe ingresar el predio'#39 +
            ');'
          'end.')
      end>
    OnNuevoRegistro = <
      item
        TableName = 'TEstadoPredioExc'
        Source.Strings = (
          'begin'
          
            '  DataSet.FieldName('#39'oid_estado'#39').AsInteger := TEstadoExcluido.F' +
            'ieldName('#39'oid_estado'#39').AsInteger;'
          '  DataSet.FieldName('#39'activo'#39').AsBoolean := true;'
          'end.')
      end>
    OnInicializar = <
      item
        Source.Strings = (
          'begin'
          '  TraerColores();'
          '  TPredios.loadFromHelp('#39'HelpPredios'#39');'
          'end.')
      end>
    OnFormFunction = <
      item
        Source.Strings = (
          'procedure TraerColores();'
          'begin'
          '  operacion.InicioOperacion();'
          '  operacion.setOper('#39'TraerColoresEstadoExcluido'#39');'
          '  operacion.execute();'
          'end;')
      end>
    Left = 368
  end
  inherited ImprimirObjetoSeleccionado: TdxComponentPrinter
    inherited ImprimirObjetoSeleccionadodxComponentPrinterLink: TdxGridReportLink
      BuiltInReportLink = True
    end
  end
  object HelpEstadosExcluidos: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'exc.EstadoExcluido'
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
    Titulo = 'Estados Excluidos'
    AnchoHelp = 600
    ActivarCache = False
    ShowBotonBuscar = False
    Left = 50
    Top = 28
  end
  object ValidadorEstado: TValidador
    Operacion = Operacion
    NickNameObjLog = 'exc.EstadoExcluido'
    WhenRaiseException = teFound
    MensajeException = 'C'#243'digo de Estado duplicado'
    NroQuery = 0
    Cache = False
    Left = 136
    Top = 51
  end
  object TColores: TsnTable
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
    Left = 528
    Top = 163
    object TColorescodigo: TStringField
      FieldName = 'codigo'
      Size = 50
    end
    object TColoresdescripcion: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
  end
  object DSColores: TDataSource
    DataSet = TColores
    Left = 560
    Top = 163
  end
  object TEstadoPredioExc: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'oid_estado_predio'
        DataType = ftInteger
      end
      item
        Name = 'oid_estado'
        DataType = ftInteger
      end
      item
        Name = 'oid_predio'
        DataType = ftInteger
      end
      item
        Name = 'proponer_nro'
        DataType = ftInteger
      end
      item
        Name = 'ult_nro_propu'
        DataType = ftInteger
      end
      item
        Name = 'nro_acta_obli'
        DataType = ftBoolean
      end
      item
        Name = 'permite_modif_nro'
        DataType = ftBoolean
      end
      item
        Name = 'conserva_nro'
        DataType = ftBoolean
      end
      item
        Name = 'activo'
        DataType = ftBoolean
      end>
    IndexFieldNames = 'oid_estado'
    IndexDefs = <
      item
        Name = 'TEstadoPredioExcIndex1'
        Fields = 'oid_estado'
      end>
    RecalcOnFetch = False
    SortOptions = []
    PersistentBackup = False
    ProgressFlags = [mtpcLoad, mtpcSave, mtpcCopy]
    VersioningMode = mtvmAllSinceCheckPoint
    FilterOptions = []
    MasterFields = 'oid_estado'
    MasterSource = dsTEstadoExcluido
    Version = '4.08b'
    LanguageID = 0
    SortID = 0
    SubLanguageID = 1
    LocaleID = 1024
    MensajeValorDuplicadoIndice = 'Valor Duplicado'
    Left = 616
    Top = 171
    object TEstadoPredioExcoid_estado_predio: TIntegerField
      FieldName = 'oid_estado_predio'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TEstadoPredioExcoid_estado: TIntegerField
      FieldName = 'oid_estado'
    end
    object TEstadoPredioExcoid_predio: TIntegerField
      FieldName = 'oid_predio'
    end
    object TEstadoPredioExcult_nro_propu: TIntegerField
      FieldName = 'ult_nro_propu'
    end
    object TEstadoPredioExcnro_acta_obli: TBooleanField
      FieldName = 'nro_acta_obli'
    end
    object TEstadoPredioExcpermite_modif_nro: TBooleanField
      FieldName = 'permite_modif_nro'
    end
    object TEstadoPredioExcconserva_nro: TBooleanField
      FieldName = 'conserva_nro'
    end
    object TEstadoPredioExcactivo: TBooleanField
      FieldName = 'activo'
    end
    object TEstadoPredioExcproponer_nro: TBooleanField
      FieldName = 'proponer_nro'
    end
  end
  object DSTEstadoPredioExc: TDataSource
    DataSet = TEstadoPredioExc
    Left = 648
    Top = 171
  end
  object HelpPredios: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'exc.PredioExcluido'
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
    AnchoHelp = 600
    ActivarCache = True
    ShowBotonBuscar = False
    Left = 216
    Top = 442
  end
  object TPredios: TsnTable
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
    Left = 250
    Top = 442
    object IntegerField5: TIntegerField
      FieldName = 'oid'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object StringField5: TStringField
      FieldName = 'codigo'
      Size = 50
    end
    object StringField6: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
  end
  object DSPredios: TDataSource
    DataSet = TPredios
    Left = 288
    Top = 443
  end
end
