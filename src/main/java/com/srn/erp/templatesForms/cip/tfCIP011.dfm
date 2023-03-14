inherited FGruposDeAccesoCIP: TFGruposDeAccesoCIP
  Left = 54
  Caption = 'Grupos de Accesos'
  PixelsPerInch = 96
  TextHeight = 13
  inherited PForm: TPanel
    inherited PMenu: TPanel
      inherited ImagenEliminar: TImagenEstado
        DataField = 'activo'
        DataSource = DSTGrupoAccesoCIP
        ValorEstadoVisible = 'True'
      end
      inherited ImagenRehabilitar: TImagenEstado
        DataField = 'activo'
        DataSource = DSTGrupoAccesoCIP
        ValorEstadoVisible = 'False'
      end
      inherited ImagenBuscar: TImagenHelpObjNeg
        Help = HelpPuertas
      end
      inherited ImagenSiguiente: TImagenHelpObjNeg
        Help = HelpPuertas
      end
      inherited ImagenAnterior: TImagenHelpObjNeg
        Help = HelpPuertas
      end
      inherited PanelEstadoON: TPanelEstado
        DataField = 'activo'
        DataSource = DSTGrupoAccesoCIP
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
    inherited PCuerpo: TPanel
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
      object snLabel4: TsnLabel
        Left = 40
        Top = 88
        Width = 104
        Height = 13
        Caption = 'Planificaci'#243'n Semanal'
      end
      object DBECodigo: TsnDBEdit
        Left = 156
        Top = 4
        DataBinding.DataField = 'codigo'
        DataBinding.DataSource = DSTGrupoAccesoCIP
        Properties.CharCase = ecUpperCase
        Properties.MaxLength = 20
        Style.BorderColor = clWindowFrame
        Style.Shadow = False
        TabOrder = 0
        Width = 133
      end
      object snDBEdit1: TsnDBEdit
        Left = 156
        Top = 44
        DataBinding.DataField = 'descripcion'
        DataBinding.DataSource = DSTGrupoAccesoCIP
        Properties.MaxLength = 50
        Style.BorderColor = clWindowFrame
        Style.Shadow = False
        TabOrder = 1
        Width = 429
      end
      object srnDBButtonEdit4: TsrnDBButtonEdit
        Left = 157
        Top = 86
        DataBinding.DataField = 'cod_perm_semanal'
        DataBinding.DataSource = DSTGrupoAccesoCIP
        Properties.Buttons = <
          item
            Default = True
            Kind = bkEllipsis
          end>
        Properties.ClickKey = 112
        TabOrder = 2
        Help = HelpPlanifSemanal
        Width = 121
      end
      object snDBEdit6: TsnDBEdit
        Left = 275
        Top = 86
        TabStop = False
        DataBinding.DataField = 'desc_perm_semanal'
        DataBinding.DataSource = DSTGrupoAccesoCIP
        Properties.ReadOnly = True
        TabOrder = 3
        Width = 305
      end
    end
  end
  inherited DriverABM: TDriverABM
    OperTraerObjeto = 'TraerGrupoAccesoCIP'
    OperGrabarObjeto = 'SaveGrupoAccesoCIP'
    CargaDataSets = <
      item
        DataSet = TGrupoAccesoCIP
        TableName = 'TGrupoAccesoCIP'
      end>
    BajaLogica = <
      item
        DataSet = TGrupoAccesoCIP
        ValorBaja = 'false'
        ValorRehabilitacion = 'true'
        TipoBajaRegistro = tblCurrentRecord
        FieldName = 'activo'
      end>
    OperHabilitadas = [toOperNuevo, toOperModificar, toOperEliminar, toOperBuscar, toOperNavegacion, toOperRehabilitar]
    DataSetCab = TGrupoAccesoCIP
    ControlFocoAlta = DBECodigo
    ControlFocoModif = DBECodigo
    Left = 512
    Top = 16
  end
  inherited Operacion: TOperacion
    Left = 560
    Top = 16
  end
  object TGrupoAccesoCIP: TsnTable [3]
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
    Top = 59
    object TGrupoAccesoCIPoid_grupo_acceso: TIntegerField
      FieldName = 'oid_grupo_acceso'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TGrupoAccesoCIPcodigo: TStringField
      DisplayWidth = 50
      FieldName = 'codigo'
      Size = 50
    end
    object TGrupoAccesoCIPdescripcion: TStringField
      DisplayWidth = 100
      FieldName = 'descripcion'
      Size = 100
    end
    object TGrupoAccesoCIPoid_perm_semanal: TIntegerField
      FieldName = 'oid_perm_semanal'
    end
    object TGrupoAccesoCIPcod_perm_semanal: TStringField
      FieldName = 'cod_perm_semanal'
      Size = 50
    end
    object TGrupoAccesoCIPdesc_perm_semanal: TStringField
      FieldName = 'desc_perm_semanal'
      Size = 100
    end
    object TGrupoAccesoCIPactivo: TBooleanField
      DefaultExpression = '1'
      FieldName = 'activo'
    end
  end
  object DSTGrupoAccesoCIP: TDataSource [4]
    DataSet = TGrupoAccesoCIP
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
        TableName = 'TGrupoAccesoCIP'
        FieldName = 'codigo'
        Source.Strings = (
          'begin'
          '  ValidadorGrupoAcceso.Value := Sender.AsString;'
          '  ValidadorGrupoAcceso.Validar;'
          'end.')
      end
      item
        Source.Strings = (
          'begin'
          '  ValidadorPlanificacionSemanal.Value := Sender.AsString;'
          '  ValidadorPlanificacionSemanal.Validar;'
          'end.')
      end>
  end
  inherited ImprimirObjetoSeleccionado: TdxComponentPrinter
    inherited ImprimirObjetoSeleccionadodxComponentPrinterLink: TdxGridReportLink
      BuiltInReportLink = True
    end
  end
  object HelpPuertas: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'cip.GrupoAccesoCIP'
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
    Titulo = 'Grupos de Acceso'
    AnchoHelp = 600
    ActivarCache = False
    ShowBotonBuscar = False
    Left = 50
    Top = 28
  end
  object ValidadorGrupoAcceso: TValidador
    Operacion = Operacion
    NickNameObjLog = 'cip.GrupoAccesoCIP'
    WhenRaiseException = teFound
    MensajeException = 'C'#243'digo de Grupo duplicado'
    NroQuery = 0
    Cache = False
    Left = 136
    Top = 51
  end
  object HelpPlanifSemanal: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'cip.PermisoSemanalCIP'
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
    Titulo = 'Planificaci'#243'n Semanal'
    AnchoHelp = 600
    ActivarCache = False
    ShowBotonBuscar = False
    Left = 370
    Top = 419
  end
  object ValidadorPlanificacionSemanal: TValidador
    Operacion = Operacion
    NickNameObjLog = 'cip.PermisoSemanalCIP'
    MensajeException = 'C'#243'digo de Planificaci'#243'n Inexistente'
    NroQuery = 0
    Cache = True
    Left = 406
    Top = 419
  end
end
