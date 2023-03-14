inherited FCompetencia: TFCompetencia
  Left = 133
  Top = 206
  Width = 749
  Height = 641
  Caption = 'Competencias'
  PixelsPerInch = 96
  TextHeight = 13
  inherited PForm: TPanel
    Width = 733
    Height = 603
    inherited PPie: TPanel
      Top = 582
      Width = 733
      inherited StatusBarABM: TStatusBar
        Left = 628
      end
      inherited StatusBar2: TStatusBar
        Width = 628
      end
    end
    inherited PMenu: TPanel
      Width = 733
      inherited ImagenEliminar: TImagenEstado
        DataField = 'activo'
        DataSource = DSTCompetencia
        ValorEstadoVisible = 'True'
      end
      inherited ImagenRehabilitar: TImagenEstado
        DataField = 'activo'
        DataSource = DSTCompetencia
        ValorEstadoVisible = 'False'
      end
      inherited ImagenBuscar: TImagenHelpObjNeg
        Help = HelpCompetencias
      end
      inherited ImagenSiguiente: TImagenHelpObjNeg
        Help = HelpCompetencias
      end
      inherited ImagenAnterior: TImagenHelpObjNeg
        Help = HelpCompetencias
      end
      inherited Panel2: TPanel
        Left = 692
      end
      inherited PanelEstadoON: TPanelEstado
        DataField = 'activo'
        DataSource = DSTCompetencia
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
      Width = 733
    end
    inherited PCabecera: TPanel
      Width = 733
      Height = 208
      object Label1: TLabel
        Left = 32
        Top = 16
        Width = 33
        Height = 13
        Caption = 'C'#243'digo'
      end
      object Label2: TLabel
        Left = 32
        Top = 48
        Width = 62
        Height = 13
        Caption = 'Competencia'
      end
      object Label3: TLabel
        Left = 32
        Top = 112
        Width = 47
        Height = 13
        Caption = 'Definici'#243'n'
      end
      object Label4: TLabel
        Left = 32
        Top = 80
        Width = 79
        Height = 13
        Caption = 'Desc. Abreviada'
      end
      object DBECodigo: TsnDBEdit
        Left = 148
        Top = 12
        DataBinding.DataField = 'codigo'
        DataBinding.DataSource = DSTCompetencia
        Properties.CharCase = ecUpperCase
        Properties.MaxLength = 20
        Style.BorderColor = clWindowFrame
        Style.Shadow = False
        TabOrder = 0
        Width = 133
      end
      object snDBEdit1: TsnDBEdit
        Left = 148
        Top = 44
        DataBinding.DataField = 'titulo'
        DataBinding.DataSource = DSTCompetencia
        Properties.MaxLength = 100
        Style.BorderColor = clWindowFrame
        Style.Shadow = False
        TabOrder = 1
        Width = 429
      end
      object snDBMemo1: TsnDBMemo
        Left = 148
        Top = 112
        DataBinding.DataField = 'definicion'
        DataBinding.DataSource = DSTCompetencia
        Properties.MaxLength = 3990
        Properties.WantTabs = True
        TabOrder = 3
        ReadOnlyAlways = False
        Height = 89
        Width = 557
      end
      object snDBEdit2: TsnDBEdit
        Left = 148
        Top = 76
        DataBinding.DataField = 'desc_abrev'
        DataBinding.DataSource = DSTCompetencia
        Properties.MaxLength = 20
        Style.BorderColor = clWindowFrame
        Style.Shadow = False
        TabOrder = 2
        Width = 237
      end
    end
    inherited PCuerpo: TPanel
      Top = 260
      Width = 733
      Height = 322
      object Panel1: TPanel
        Left = 0
        Top = 0
        Width = 733
        Height = 322
        Align = alClient
        BorderWidth = 5
        Color = clWindow
        TabOrder = 0
        object dxDBGridSN1: TdxDBGridSN
          Left = 6
          Top = 6
          Width = 721
          Height = 310
          Align = alClient
          TabOrder = 0
          LookAndFeel.Kind = lfFlat
          CriteriosPintarCelda = <>
          object dxDBGridSN1DBTableView1: TcxGridDBTableView
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
            NavigatorButtons.Insert.Visible = False
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
            DataController.DataSource = DSGradoCompetencia
            DataController.Summary.DefaultGroupSummaryItems = <>
            DataController.Summary.FooterSummaryItems = <
              item
                Format = '###,###,###.##'
                Kind = skSum
                Column = dxDBGridSN1DBTableView1peso_tentativo
              end>
            DataController.Summary.SummaryGroups = <>
            OptionsBehavior.FocusCellOnTab = True
            OptionsBehavior.FocusFirstCellOnNewRecord = True
            OptionsBehavior.GoToNextCellOnEnter = True
            OptionsBehavior.FocusCellOnCycle = True
            OptionsData.Appending = True
            OptionsData.Deleting = False
            OptionsData.DeletingConfirmation = False
            OptionsSelection.InvertSelect = False
            OptionsView.Navigator = True
            OptionsView.CellAutoHeight = True
            OptionsView.Footer = True
            OptionsView.GroupByBox = False
            object dxDBGridSN1DBTableView1nro_grado: TcxGridDBColumn
              Caption = 'Nro. Grado'
              DataBinding.FieldName = 'nro_grado'
              HeaderAlignmentHorz = taCenter
              SortIndex = 0
              SortOrder = soAscending
              Width = 86
            end
            object dxDBGridSN1DBTableView1desc_grados: TcxGridDBColumn
              Caption = 'Grado'
              DataBinding.FieldName = 'desc_grados'
              PropertiesClassName = 'TcxMemoProperties'
              Properties.WantTabs = True
              HeaderAlignmentHorz = taCenter
              Width = 497
            end
            object dxDBGridSN1DBTableView1peso_tentativo: TcxGridDBColumn
              Caption = 'Peso'
              DataBinding.FieldName = 'peso_tentativo'
              HeaderAlignmentHorz = taCenter
              Width = 58
            end
            object dxDBGridSN1DBTableView1activo: TcxGridDBColumn
              Caption = 'Activo'
              DataBinding.FieldName = 'activo'
              PropertiesClassName = 'TcxCheckBoxProperties'
              HeaderAlignmentHorz = taCenter
              Width = 50
            end
          end
          object dxDBGridSN1Level1: TcxGridLevel
            GridView = dxDBGridSN1DBTableView1
          end
        end
      end
    end
  end
  inherited DriverABM: TDriverABM
    OperTraerObjeto = 'TraerCompetencia'
    OperGrabarObjeto = 'SaveCompetencia'
    CargaDataSets = <
      item
        DataSet = TCompetencia
        TableName = 'TCompetencia'
      end
      item
        DataSet = TGradoCompetencia
        TableName = 'TGradoCompetencia'
      end>
    BajaLogica = <
      item
        DataSet = TCompetencia
        ValorBaja = 'false'
        ValorRehabilitacion = 'true'
        TipoBajaRegistro = tblCurrentRecord
        FieldName = 'activo'
      end>
    OperHabilitadas = [toOperNuevo, toOperModificar, toOperEliminar, toOperBuscar, toOperNavegacion, toOperRehabilitar]
    DataSetCab = TCompetencia
    DataSetDet1 = TGradoCompetencia
    ControlFocoAlta = DBECodigo
    ControlFocoModif = DBECodigo
    Left = 512
    Top = 16
  end
  inherited Operacion: TOperacion
    Left = 560
    Top = 16
  end
  object TCompetencia: TsnTable [3]
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'oid_competencia'
        DataType = ftInteger
      end
      item
        Name = 'codigo'
        DataType = ftString
        Size = 20
      end
      item
        Name = 'titulo'
        DataType = ftString
        Size = 100
      end
      item
        Name = 'activo'
        DataType = ftBoolean
      end
      item
        Name = 'definicion'
        DataType = ftString
        Size = 4000
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
    object TCompetenciaoid_competencia: TIntegerField
      FieldName = 'oid_competencia'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TCompetenciacodigo: TStringField
      DisplayWidth = 20
      FieldName = 'codigo'
    end
    object TCompetenciadesc_abrev: TStringField
      FieldName = 'desc_abrev'
    end
    object TCompetenciatitulo: TStringField
      FieldName = 'titulo'
      Size = 100
    end
    object TCompetenciaactivo: TBooleanField
      DefaultExpression = '1'
      FieldName = 'activo'
    end
    object TCompetenciadefinicion: TStringField
      FieldName = 'definicion'
      Size = 4000
    end
  end
  object DSTCompetencia: TDataSource [4]
    DataSet = TCompetencia
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
    Left = 344
    Top = 80
    inherited dxComponentPrinterLink1: TdxCustomContainerReportLink
      Component = Owner
      BuiltInReportLink = True
      HiddenComponents = {}
      ExcludedComponents = {}
      AggregatedReportLinks = {}
    end
  end
  inherited SaveDialog: TSaveDialog
    Left = 456
    Top = 80
  end
  inherited DriverEvent: TDriverEvent
    OnValidate = <
      item
        TableName = 'TCompetencia'
        FieldName = 'codigo'
        Source.Strings = (
          'begin'
          '  ValidadorCompetencia.Value := Sender.AsString;'
          '  ValidadorCompetencia.Validar;'
          'end.')
      end>
    OnBeforePost = <
      item
        TableName = 'TCompetencia'
        Source.Strings = (
          'begin'
          '  if (DataSet.FieldName('#39'codigo'#39').AsString='#39#39')'
          
            '     then raiseException(erCustomError,'#39'Debe ingresar el c'#243'digo'#39 +
            ');'
          '  if (DataSet.FieldName('#39'titulo'#39').AsString='#39#39')'
          
            '     then raiseException(erCustomError,'#39'Debe ingresar la Compete' +
            'ncia'#39');'
          '  if (DataSet.FieldName('#39'definicion'#39').AsString='#39#39')'
          
            '     then raiseException(erCustomError,'#39'Debe ingresar la Definic' +
            'i'#243'n'#39');'
          'end.')
      end
      item
        TableName = 'TGradoCompetencia'
        Source.Strings = (
          'begin'
          '  if (DataSet.FieldName('#39'nro_grado'#39').AsInteger<=0)'
          
            '     then raiseException(erCustomError,'#39'Debe ingresar el Nro. de' +
            ' Grado'#39');'
          'end.')
      end>
    OnNuevoRegistro = <
      item
        TableName = 'TCompetencia'
        Source.Strings = (
          'begin'
          '  DataSet.FieldName('#39'activo'#39').AsBoolean := True;'
          'end.')
      end
      item
        TableName = 'TGradoCompetencia'
        Source.Strings = (
          'begin'
          '  DataSet.FieldName('#39'oid_competencia'#39').AsInteger :='
          '       TCompetencia.FieldName('#39'oid_competencia'#39').AsInteger;'
          '  DataSet.FieldName('#39'activo'#39').AsBoolean := True;'
          'end.')
      end>
    Left = 424
    Top = 83
  end
  inherited ImprimirObjetoSeleccionado: TdxComponentPrinter
    inherited ImprimirObjetoSeleccionadodxComponentPrinterLink: TdxGridReportLink
      BuiltInReportLink = True
    end
  end
  inherited PopUp: TsnPopUp
    Left = 385
    Top = 80
  end
  inherited TDataSetOidObjSave: TsnTable
    Left = 464
    Top = 147
  end
  object HelpCompetencias: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'rh.Competencia'
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
    Titulo = 'Competencias'
    AnchoHelp = 600
    ActivarCache = False
    ShowBotonBuscar = False
    Left = 50
    Top = 28
  end
  object ValidadorCompetencia: TValidador
    Operacion = Operacion
    NickNameObjLog = 'rh.Competencia'
    WhenRaiseException = teFound
    MensajeException = 'C'#243'digo de Competencia duplicado'
    NroQuery = 0
    Cache = False
    Left = 136
    Top = 51
  end
  object TGradoCompetencia: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'oid_grado_compe'
        DataType = ftInteger
      end
      item
        Name = 'oid_competencia'
        DataType = ftInteger
      end
      item
        Name = 'nro_grado'
        DataType = ftInteger
      end
      item
        Name = 'desc_grados'
        DataType = ftString
        Size = 4000
      end
      item
        Name = 'peso_tentativo'
        DataType = ftCurrency
      end
      item
        Name = 'activo'
        DataType = ftBoolean
      end>
    IndexFieldNames = 'oid_competencia'
    IndexDefs = <
      item
        Name = 'TGradoCompetenciaIndex1'
        Fields = 'oid_competencia;nro_grado'
      end>
    RecalcOnFetch = False
    SortOptions = []
    PersistentBackup = False
    ProgressFlags = [mtpcLoad, mtpcSave, mtpcCopy]
    VersioningMode = mtvmAllSinceCheckPoint
    FilterOptions = []
    MasterFields = 'oid_competencia'
    MasterSource = DSTCompetencia
    Version = '4.08b'
    LanguageID = 0
    SortID = 0
    SubLanguageID = 1
    LocaleID = 1024
    MensajeValorDuplicadoIndice = 'Valor Duplicado'
    Left = 576
    Top = 100
    object TGradoCompetenciaoid_grado_compe: TIntegerField
      FieldName = 'oid_grado_compe'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TGradoCompetenciaoid_competencia: TIntegerField
      FieldName = 'oid_competencia'
    end
    object TGradoCompetencianro_grado: TIntegerField
      FieldName = 'nro_grado'
    end
    object TGradoCompetenciadesc_grados: TStringField
      FieldName = 'desc_grados'
      Size = 4000
    end
    object TGradoCompetenciapeso_tentativo: TCurrencyField
      FieldName = 'peso_tentativo'
      DisplayFormat = '###.##'
    end
    object TGradoCompetenciaactivo: TBooleanField
      FieldName = 'activo'
    end
  end
  object DSGradoCompetencia: TDataSource
    DataSet = TGradoCompetencia
    Left = 608
    Top = 100
  end
end
