inherited FMotEntIntermedias: TFMotEntIntermedias
  Left = 93
  Top = 170
  Height = 427
  Caption = 'Motivos de Entradas Intermedias'
  PixelsPerInch = 96
  TextHeight = 13
  inherited PForm: TPanel
    Height = 393
    inherited PPie: TPanel
      Top = 372
    end
    inherited PMenu: TPanel
      inherited ImagenEliminar: TImagenEstado
        DataField = 'activo'
        DataSource = DSTMotivoEntIntermedias
      end
      inherited ImagenRehabilitar: TImagenEstado
        DataField = 'activo'
        DataSource = DSTMotivoEntIntermedias
      end
      inherited ImagenBuscar: TImagenHelpObjNeg
        Help = HelpMotivos
      end
      inherited ImagenSiguiente: TImagenHelpObjNeg
        Help = HelpMotivos
      end
      inherited ImagenAnterior: TImagenHelpObjNeg
        Help = HelpMotivos
      end
      inherited PanelEstadoON: TPanelEstado
        DataField = 'activo'
        DataSource = DSTMotivoEntIntermedias
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
    inherited PCabecera: TPanel
      Height = 93
      object Label1: TLabel
        Left = 40
        Top = 16
        Width = 33
        Height = 13
        Caption = 'C'#243'digo'
      end
      object Label2: TLabel
        Left = 40
        Top = 56
        Width = 56
        Height = 13
        Caption = 'Descripci'#243'n'
      end
      object DBECodigo: TsnDBEdit
        Left = 124
        Top = 12
        DataBinding.DataField = 'codigo'
        DataBinding.DataSource = DSTMotivoEntIntermedias
        Properties.CharCase = ecUpperCase
        Properties.MaxLength = 50
        Style.BorderColor = clWindowFrame
        Style.Shadow = False
        TabOrder = 0
        Width = 133
      end
      object DBEDescripcion: TsnDBEdit
        Left = 124
        Top = 52
        DataBinding.DataField = 'descripcion'
        DataBinding.DataSource = DSTMotivoEntIntermedias
        Properties.MaxLength = 100
        Style.BorderColor = clWindowFrame
        Style.Shadow = False
        TabOrder = 1
        Width = 273
      end
    end
    inherited PCuerpo: TPanel
      Top = 145
      Height = 227
      BorderWidth = 5
      object PageControlSN1: TPageControlSN
        Left = 5
        Top = 5
        Width = 719
        Height = 217
        ActivePage = TabSheet1
        Align = alClient
        TabOrder = 0
        object TabSheet1: TTabSheet
          Caption = 'Equivalencias Externas de C'#243'digos'
          object dxDBGridSN3: TdxDBGridSN
            Left = 0
            Top = 0
            Width = 711
            Height = 189
            Align = alClient
            TabOrder = 0
            LookAndFeel.Kind = lfFlat
            CriteriosPintarCelda = <>
            object dxDBGridSN3DBTableView1: TcxGridDBTableView
              NavigatorButtons.ConfirmDelete = False
              DataController.DataSource = DSEquivMotEntIntermedias
              DataController.Summary.DefaultGroupSummaryItems = <>
              DataController.Summary.FooterSummaryItems = <>
              DataController.Summary.SummaryGroups = <>
              OptionsBehavior.AlwaysShowEditor = True
              OptionsBehavior.FocusCellOnTab = True
              OptionsBehavior.FocusFirstCellOnNewRecord = True
              OptionsBehavior.GoToNextCellOnEnter = True
              OptionsBehavior.FocusCellOnCycle = True
              OptionsCustomize.ColumnFiltering = False
              OptionsData.Appending = True
              OptionsData.Deleting = False
              OptionsSelection.InvertSelect = False
              OptionsView.GroupByBox = False
              object dxDBGridSN3DBTableView1Column1: TcxGridDBColumn
                DataBinding.FieldName = 'orden'
                Visible = False
                SortIndex = 0
                SortOrder = soAscending
              end
              object dxDBGridCodPuerta: TcxGridDBColumn
                Caption = 'C'#243'digo'
                DataBinding.FieldName = 'codigo'
                HeaderAlignmentHorz = taCenter
                Width = 177
              end
              object dxDBGridSN3DBTableView1Column2: TcxGridDBColumn
                Caption = 'Activo'
                DataBinding.FieldName = 'activo'
                PropertiesClassName = 'TcxCheckBoxProperties'
                HeaderAlignmentHorz = taCenter
                Width = 53
              end
            end
            object dxDBGridSN3Level1: TcxGridLevel
              GridView = dxDBGridSN3DBTableView1
            end
          end
        end
      end
    end
  end
  inherited DriverABM: TDriverABM
    OperTraerObjeto = 'TraerMotivoEntIntermedias'
    OperGrabarObjeto = 'SaveMotivoEntIntermedias'
    CargaDataSets = <
      item
        DataSet = TMotivoEntIntermedias
        TableName = 'TMotivoEntIntermedias'
      end
      item
        DataSet = TEquivMotEntIntermedias
        TableName = 'TEquivMotEntIntermedias'
      end>
    BajaLogica = <
      item
        DataSet = TMotivoEntIntermedias
        ValorBaja = 'false'
        ValorRehabilitacion = 'true'
        TipoBajaRegistro = tblCurrentRecord
        FieldName = 'activo'
      end>
    OperHabilitadas = [toOperNuevo, toOperModificar, toOperEliminar, toOperBuscar, toOperNavegacion, toOperRehabilitar]
    DataSetCab = TMotivoEntIntermedias
    DataSetDet1 = TEquivMotEntIntermedias
    Left = 512
    Top = 16
  end
  inherited Operacion: TOperacion
    Left = 560
    Top = 16
  end
  object TMotivoEntIntermedias: TsnTable [3]
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'oid_motivo'
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
      end
      item
        Name = 'activo'
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
    object TMotivoEntIntermediasoid_motivo: TIntegerField
      FieldName = 'oid_motivo'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TMotivoEntIntermediascodigo: TStringField
      DisplayWidth = 50
      FieldName = 'codigo'
      Size = 50
    end
    object TMotivoEntIntermediasdescripcion: TStringField
      DisplayWidth = 100
      FieldName = 'descripcion'
      Size = 100
    end
    object TMotivoEntIntermediasactivo: TBooleanField
      DefaultExpression = '1'
      FieldName = 'activo'
    end
  end
  object DSTMotivoEntIntermedias: TDataSource [4]
    DataSet = TMotivoEntIntermedias
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
    inherited dxComponentPrinterLink1: TdxCustomContainerReportLink
      Component = Owner
      BuiltInReportLink = True
      HiddenComponents = {}
      ExcludedComponents = {}
      AggregatedReportLinks = {}
    end
  end
  inherited DriverEvent: TDriverEvent
    OnValidate = <
      item
        TableName = 'TMotivoEntIntermedias'
        FieldName = 'codigo'
        Source.Strings = (
          'begin'
          '  ValidadorMotivo.Value := Sender.AsString;'
          '  ValidadorMotivo.Validar;'
          'end.')
      end>
    OnBeforePost = <
      item
        TableName = 'TEquivMotEntIntermedias'
        Source.Strings = (
          'begin'
          '  if (DataSet.FieldName('#39'codigo'#39').AsString='#39#39')'
          
            '     then raiseException(erCustomError,'#39'Debe ingresar el c'#243'digo ' +
            'de equivalencia'#39');'
          'end.')
      end>
    OnNuevoRegistro = <
      item
        TableName = 'TEquivMotEntIntermedias'
        Source.Strings = (
          'begin'
          
            '  DataSet.FieldName('#39'oid_motivo'#39').AsInteger := TMotivoEntInterme' +
            'dias.FieldName('#39'oid_motivo'#39').AsInteger;'
          '  DataSet.FieldName('#39'activo'#39').AsBoolean := true;'
          'end.')
      end>
  end
  inherited ImprimirObjetoSeleccionado: TdxComponentPrinter
    inherited ImprimirObjetoSeleccionadodxComponentPrinterLink: TdxGridReportLink
      BuiltInReportLink = True
    end
  end
  inherited TPathHelp: TsnTable
    Left = 416
    Top = 197
  end
  inherited TDataSetOidObjSave: TsnTable
    Left = 568
  end
  object HelpMotivos: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'cip.MotivoEntIntermedias'
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
    Titulo = 'Motivos'
    AnchoHelp = 600
    ActivarCache = False
    ShowBotonBuscar = False
    Left = 50
    Top = 28
  end
  object ValidadorMotivo: TValidador
    Operacion = Operacion
    NickNameObjLog = 'cip.MotivoEntIntermedias'
    WhenRaiseException = teFound
    MensajeException = 'C'#243'digo de Motivo Existente'
    NroQuery = 0
    Cache = False
    Left = 136
    Top = 67
  end
  object TEquivMotEntIntermedias: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'oid_equiv_mot'
        DataType = ftInteger
      end
      item
        Name = 'codigo'
        DataType = ftString
        Size = 50
      end
      item
        Name = 'oid_motivo'
        DataType = ftInteger
      end
      item
        Name = 'activo'
        DataType = ftBoolean
      end
      item
        Name = 'orden'
        DataType = ftInteger
      end>
    IndexFieldNames = 'oid_motivo'
    IndexDefs = <
      item
        Name = 'TEquivMotEntIntermediasIndex1'
        Fields = 'oid_motivo'
      end>
    RecalcOnFetch = False
    SortOptions = []
    PersistentBackup = False
    ProgressFlags = [mtpcLoad, mtpcSave, mtpcCopy]
    VersioningMode = mtvmAllSinceCheckPoint
    FilterOptions = []
    MasterFields = 'oid_motivo'
    MasterSource = DSTMotivoEntIntermedias
    Version = '4.08b'
    LanguageID = 0
    SortID = 0
    SubLanguageID = 1
    LocaleID = 1024
    MensajeValorDuplicadoIndice = 'Valor Duplicado'
    Left = 648
    Top = 99
    object TEquivMotEntIntermediasoid_equiv_mot: TIntegerField
      FieldName = 'oid_equiv_mot'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TEquivMotEntIntermediascodigo: TStringField
      FieldName = 'codigo'
      Size = 50
    end
    object TEquivMotEntIntermediasoid_motivo: TIntegerField
      FieldName = 'oid_motivo'
    end
    object TEquivMotEntIntermediasactivo: TBooleanField
      FieldName = 'activo'
    end
    object TEquivMotEntIntermediasorden: TIntegerField
      AutoGenerateValue = arAutoInc
      FieldName = 'orden'
    end
  end
  object DSEquivMotEntIntermedias: TDataSource
    DataSet = TEquivMotEntIntermedias
    Left = 680
    Top = 99
  end
end
