inherited FGrupoUsuMens: TFGrupoUsuMens
  Left = 82
  Top = 99
  Width = 760
  Height = 487
  Caption = 'Grupos de Usuarios para Mensajer'#237'a'
  PixelsPerInch = 96
  TextHeight = 13
  inherited PForm: TPanel
    Width = 752
    Height = 453
    inherited PPie: TPanel
      Top = 432
      Width = 752
      inherited StatusBarABM: TStatusBar
        Left = 647
      end
      inherited StatusBar2: TStatusBar
        Width = 647
      end
    end
    inherited PMenu: TPanel
      Width = 752
      inherited ImagenEliminar: TImagenEstado
        DataField = 'activo'
        DataSource = DSTGrupoUsuMens
        ValorEstadoVisible = 'True'
      end
      inherited ImagenRehabilitar: TImagenEstado
        DataField = 'activo'
        DataSource = DSTGrupoUsuMens
        ValorEstadoVisible = 'False'
      end
      inherited ImagenBuscar: TImagenHelpObjNeg
        Help = HelpGrupos
      end
      inherited ImagenSiguiente: TImagenHelpObjNeg
        Help = HelpGrupos
      end
      inherited ImagenAnterior: TImagenHelpObjNeg
        Help = HelpGrupos
      end
      inherited Panel2: TPanel
        Left = 711
      end
      inherited PanelEstadoON: TPanelEstado
        DataField = 'activo'
        DataSource = DSTGrupoUsuMens
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
      Width = 752
    end
    inherited PCabecera: TPanel
      Width = 752
      Height = 80
      object Label2: TLabel
        Left = 24
        Top = 24
        Width = 56
        Height = 13
        Caption = 'Descripci'#243'n'
      end
      object Label5: TLabel
        Left = 265
        Top = 54
        Width = 36
        Height = 13
        Caption = 'Usuario'
      end
      object Label1: TLabel
        Left = 24
        Top = 56
        Width = 32
        Height = 13
        Caption = 'Ambito'
      end
      object snDBEdit1: TsnDBEdit
        Left = 92
        Top = 20
        DataBinding.DataField = 'nombre'
        DataBinding.DataSource = DSTGrupoUsuMens
        Properties.MaxLength = 50
        Style.BorderColor = clWindowFrame
        Style.Shadow = False
        TabOrder = 0
        Width = 534
      end
      object srnDBBCodImpFiscal: TsrnDBButtonEdit
        Left = 308
        Top = 50
        DataBinding.DataField = 'cod_usu_priv'
        DataBinding.DataSource = DSTGrupoUsuMens
        Properties.Buttons = <
          item
            Default = True
            Kind = bkEllipsis
          end>
        Properties.ClickKey = 112
        TabOrder = 2
        Help = HelpUsuarioPriv
        Width = 95
      end
      object snDBDescImpFiscal: TsnDBEdit
        Left = 400
        Top = 50
        TabStop = False
        DataBinding.DataField = 'desc_usu_priv'
        DataBinding.DataSource = DSTGrupoUsuMens
        Properties.ReadOnly = True
        Style.BorderColor = clWindowFrame
        Style.Shadow = False
        TabOrder = 3
        ReadOnlyAlways = True
        Width = 226
      end
      object snDBLookup1: TsnDBLookup
        Left = 92
        Top = 52
        DataBinding.DataField = 'scope'
        DataBinding.DataSource = DSTGrupoUsuMens
        Properties.KeyFieldNames = 'codigo'
        Properties.ListColumns = <
          item
            FieldName = 'descripcion'
          end>
        Properties.ListOptions.ShowHeader = False
        Properties.ListSource = DSAmbito
        TabOrder = 1
        Width = 145
      end
    end
    inherited PCuerpo: TPanel
      Top = 132
      Width = 752
      Height = 300
      BorderWidth = 10
      object dxDBGridSN3: TdxDBGridSN
        Left = 10
        Top = 10
        Width = 732
        Height = 280
        Align = alClient
        TabOrder = 0
        LookAndFeel.Kind = lfFlat
        CriteriosPintarCelda = <>
        object dxDBGridSN3DBTableView1: TcxGridDBTableView
          NavigatorButtons.ConfirmDelete = False
          DataController.DataSource = DSTDetGrupoUsuMens
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
            PropertiesClassName = 'TcxButtonEditProperties'
            Properties.Buttons = <
              item
                Default = True
                Kind = bkEllipsis
              end>
            Properties.ClickKey = 112
            HeaderAlignmentHorz = taCenter
            Width = 122
          end
          object dxDBGridSN3DBTableView1desc_valor_clasif: TcxGridDBColumn
            Caption = 'Descripci'#243'n'
            DataBinding.FieldName = 'ape_y_nom'
            HeaderAlignmentHorz = taCenter
            Options.Editing = False
            Options.Focusing = False
            Width = 380
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
  inherited DriverABM: TDriverABM
    OperTraerObjeto = 'TraerGrupoUsuMens'
    OperGrabarObjeto = 'SaveGrupoUsuMens'
    CargaDataSets = <
      item
        DataSet = TGrupoUsuMens
        TableName = 'TGrupoUsuMens'
      end
      item
        DataSet = TDetGrupoUsuMens
        TableName = 'TDetGrupoUsuMens'
      end>
    BajaLogica = <
      item
        DataSet = TGrupoUsuMens
        ValorBaja = 'false'
        ValorRehabilitacion = 'true'
        TipoBajaRegistro = tblCurrentRecord
        FieldName = 'activo'
      end>
    OperHabilitadas = [toOperNuevo, toOperModificar, toOperEliminar, toOperBuscar, toOperNavegacion, toOperRehabilitar]
    DataSetCab = TGrupoUsuMens
    DataSetDet1 = TDetGrupoUsuMens
    ControlFocoAlta = snDBEdit1
    ControlFocoModif = snDBEdit1
    Left = 512
    Top = 16
  end
  inherited Operacion: TOperacion
    Left = 560
    Top = 16
  end
  object TGrupoUsuMens: TsnTable [3]
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'oid_grupo_dest_cab'
        DataType = ftInteger
      end
      item
        Name = 'nombre'
        DataType = ftString
        Size = 100
      end
      item
        Name = 'scope'
        DataType = ftString
        Size = 1
      end
      item
        Name = 'oid_usu_priv'
        DataType = ftInteger
      end
      item
        Name = 'cod_usu_priv'
        DataType = ftString
        Size = 50
      end
      item
        Name = 'desc_usu_priv'
        DataType = ftString
        Size = 255
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
    object TGrupoUsuMensoid_grupo_dest_cab: TIntegerField
      FieldName = 'oid_grupo_dest_cab'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TGrupoUsuMensnombre: TStringField
      FieldName = 'nombre'
      Size = 100
    end
    object TGrupoUsuMensscope: TStringField
      FieldName = 'scope'
      Size = 1
    end
    object TGrupoUsuMensoid_usu_priv: TIntegerField
      FieldName = 'oid_usu_priv'
    end
    object TGrupoUsuMenscod_usu_priv: TStringField
      FieldName = 'cod_usu_priv'
      Size = 50
    end
    object TGrupoUsuMensdesc_usu_priv: TStringField
      FieldName = 'desc_usu_priv'
      Size = 255
    end
    object TGrupoUsuMensactivo: TBooleanField
      DefaultExpression = '1'
      FieldName = 'activo'
    end
  end
  object DSTGrupoUsuMens: TDataSource [4]
    DataSet = TGrupoUsuMens
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
        TableName = 'TGrupoUsuMens'
        FieldName = 'nombre'
        Source.Strings = (
          'begin'
          'end.')
      end
      item
        TableName = 'TDetGrupoUsuMens'
        FieldName = 'codigo'
        Source.Strings = (
          'begin'
          '  ValidadorUsuario.Value := Sender.AsString;'
          '  ValidadorUsuario.Validar;'
          'end.')
      end
      item
        TableName = 'TGrupoUsuMens'
        FieldName = 'cod_usu_priv'
        Source.Strings = (
          'begin'
          '  ValidadorUsuarioPriv.Value := Sender.AsString;'
          '  ValidadorUsuarioPriv.Validar();'
          'end.')
      end>
    OnBeforePost = <
      item
        TableName = 'TGrupoUsuMens'
        Source.Strings = (
          'begin'
          '  if (Trim(DataSet.FieldName('#39'nombre'#39').AsString)='#39#39')'
          
            '     then raiseException(erCustomError,'#39'Debe ingresar el nombre ' +
            'del Grupo'#39');'
          '  if (Trim(DataSet.FieldName('#39'scope'#39').AsString)='#39#39')'
          
            '     then raiseException(erCustomError,'#39'Debe ingresar el Ambito'#39 +
            ');'
          'end.')
      end
      item
        TableName = 'TDetGrupoUsuMens'
        Source.Strings = (
          'begin'
          '  if (DataSet.FieldName('#39'oid_usuario'#39').AsInteger = 0)'
          
            '     then raiseException(erCustomError,'#39'Debe ingresar el usuario' +
            #39');'
          'end.')
      end>
    OnNuevoRegistro = <
      item
        TableName = 'TDetGrupoUsuMens'
        Source.Strings = (
          'begin'
          '  DataSet.FieldName('#39'oid_grupo_dest_cab'#39').AsInteger :='
          '    TGrupoUsuMens.FieldName('#39'oid_grupo_dest_cab'#39').AsInteger;'
          '  DataSet.FieldName('#39'activo'#39').AsBoolean := true;'
          'end.')
      end>
    OnInicializar = <
      item
        Source.Strings = (
          'begin'
          '  CargarAmbito();'
          'end.')
      end>
    OnFormFunction = <
      item
        Source.Strings = (
          'procedure CargarAmbito();'
          'begin'
          '  TAmbito.Close;'
          '  TAmbito.Open;'
          ''
          '  TAmbito.AppendRecord;'
          '  TAmbito.FieldName('#39'codigo'#39').AsString := '#39'P'#39';'
          '  TAmbito.FieldName('#39'descripcion'#39').AsString := '#39'Publico'#39';'
          '  TAmbito.PostRecord;'
          ''
          '  TAmbito.AppendRecord;'
          '  TAmbito.FieldName('#39'codigo'#39').AsString := '#39'I'#39';'
          '  TAmbito.FieldName('#39'descripcion'#39').AsString := '#39'Privado'#39';'
          '  TAmbito.PostRecord;'
          ''
          ''
          ''
          ''
          'end;')
      end>
    OnClickButtonColumn = <
      item
        ColumnName = 'dxDBGridCodPuerta'
        Source.Strings = (
          'begin'
          '  HelpUsuario.Mostrar();'
          'end.')
      end>
  end
  inherited ImprimirObjetoSeleccionado: TdxComponentPrinter
    inherited ImprimirObjetoSeleccionadodxComponentPrinterLink: TdxGridReportLink
      BuiltInReportLink = True
    end
  end
  inherited ImageListGruposPopUp: TImageList
    Left = 192
    Top = 179
  end
  inherited TDataSetOidObjSave: TsnTable
    Left = 592
    Top = 43
  end
  object HelpGrupos: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'me.GrupoUsuMens'
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
        Visible = False
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
    Titulo = 'Grupos de Usuarios'
    AnchoHelp = 600
    ActivarCache = False
    ShowBotonBuscar = False
    Left = 50
    Top = 28
  end
  object ValidadorGrupoPuerta: TValidador
    Operacion = Operacion
    NickNameObjLog = 'cip.GrupoPuerta'
    WhenRaiseException = teFound
    MensajeException = 'C'#243'digo de Punto de Acceso duplicado'
    NroQuery = 0
    Cache = False
    Left = 136
    Top = 67
  end
  object TDetGrupoUsuMens: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'oid_grupo_puerta'
        DataType = ftInteger
      end
      item
        Name = 'oid_puerta'
        DataType = ftInteger
      end
      item
        Name = 'cod_puerta'
        DataType = ftString
        Size = 50
      end
      item
        Name = 'desc_puerta'
        DataType = ftString
        Size = 100
      end
      item
        Name = 'orden'
        DataType = ftInteger
      end
      item
        Name = 'activo'
        DataType = ftBoolean
      end
      item
        Name = 'oid_grupo_dest_det'
        DataType = ftInteger
      end
      item
        Name = 'oid_grupo_dest_cab'
        DataType = ftInteger
      end
      item
        Name = 'oid_usuario'
        DataType = ftInteger
      end
      item
        Name = 'codigo'
        DataType = ftString
        Size = 50
      end
      item
        Name = 'ape_y_nom'
        DataType = ftString
        Size = 255
      end>
    IndexFieldNames = 'oid_grupo_dest_cab;orden'
    IndexDefs = <
      item
        Name = 'TGrupoPuertaDetIndex1'
        Fields = 'oid_grupo_dest_cab;orden'
      end>
    RecalcOnFetch = False
    SortOptions = []
    PersistentBackup = False
    ProgressFlags = [mtpcLoad, mtpcSave, mtpcCopy]
    VersioningMode = mtvmAllSinceCheckPoint
    FilterOptions = []
    MasterFields = 'oid_grupo_dest_cab'
    MasterSource = DSTGrupoUsuMens
    Version = '4.08b'
    LanguageID = 0
    SortID = 0
    SubLanguageID = 1
    LocaleID = 1024
    MensajeValorDuplicadoIndice = 'Puerta Duplicada'
    Left = 648
    Top = 108
    object TDetGrupoUsuMensoid_grupo_puerta: TIntegerField
      FieldName = 'oid_grupo_puerta'
    end
    object TDetGrupoUsuMensoid_puerta: TIntegerField
      FieldName = 'oid_puerta'
    end
    object TDetGrupoUsuMenscod_puerta: TStringField
      FieldName = 'cod_puerta'
      Size = 50
    end
    object TDetGrupoUsuMensdesc_puerta: TStringField
      FieldName = 'desc_puerta'
      Size = 100
    end
    object TDetGrupoUsuMensorden: TIntegerField
      AutoGenerateValue = arAutoInc
      FieldName = 'orden'
    end
    object TDetGrupoUsuMensactivo: TBooleanField
      FieldName = 'activo'
    end
    object TDetGrupoUsuMensoid_grupo_dest_det: TIntegerField
      FieldName = 'oid_grupo_dest_det'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TDetGrupoUsuMensoid_grupo_dest_cab: TIntegerField
      FieldName = 'oid_grupo_dest_cab'
    end
    object TDetGrupoUsuMensoid_usuario: TIntegerField
      FieldName = 'oid_usuario'
    end
    object TDetGrupoUsuMenscodigo: TStringField
      FieldName = 'codigo'
      Size = 50
    end
    object TDetGrupoUsuMensape_y_nom: TStringField
      FieldName = 'ape_y_nom'
      Size = 255
    end
  end
  object DSTDetGrupoUsuMens: TDataSource
    DataSet = TDetGrupoUsuMens
    Left = 680
    Top = 108
  end
  object HelpUsuario: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'se.Usuario'
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
        AsignarACampo = TDetGrupoUsuMenscodigo
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
    Titulo = 'Usuarios'
    AnchoHelp = 600
    ActivarCache = False
    ShowBotonBuscar = False
    Left = 242
    Top = 239
  end
  object ValidadorUsuario: TValidador
    Operacion = Operacion
    NickNameObjLog = 'se.Usuario'
    MensajeException = 'Usuario Inexistente'
    CampoOID = TDetGrupoUsuMensoid_usuario
    CampoDescripcion = TDetGrupoUsuMensape_y_nom
    NroQuery = 0
    Cache = True
    Left = 278
    Top = 239
  end
  object TAmbito: TsnTable
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
    Left = 152
    Top = 220
    object TAmbitocodigo: TStringField
      FieldName = 'codigo'
      Size = 1
    end
    object TAmbitodescripcion: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
  end
  object DSAmbito: TDataSource
    DataSet = TAmbito
    Left = 184
    Top = 220
  end
  object HelpUsuarioPriv: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'se.Usuario'
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
        AsignarACampo = TGrupoUsuMenscod_usu_priv
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
    Titulo = 'Usuarios'
    AnchoHelp = 600
    ActivarCache = False
    ShowBotonBuscar = False
    Left = 242
    Top = 279
  end
  object ValidadorUsuarioPriv: TValidador
    Operacion = Operacion
    NickNameObjLog = 'se.Usuario'
    MensajeException = 'Usuario Inexistente'
    CampoOID = TGrupoUsuMensoid_usu_priv
    CampoDescripcion = TGrupoUsuMensdesc_usu_priv
    NroQuery = 0
    Cache = True
    Left = 278
    Top = 279
  end
end
