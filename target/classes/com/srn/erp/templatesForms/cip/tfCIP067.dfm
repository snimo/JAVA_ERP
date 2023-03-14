inherited FCIPConsNovPerm: TFCIPConsNovPerm
  Left = 111
  Top = 127
  Width = 822
  Caption = 'Consulta de Novedades de Permisos'
  PixelsPerInch = 96
  TextHeight = 13
  object Panel1: TPanel [0]
    Left = 0
    Top = 0
    Width = 806
    Height = 73
    Align = alTop
    Color = clWindow
    TabOrder = 0
    object Label1: TLabel
      Left = 16
      Top = 16
      Width = 65
      Height = 13
      Caption = 'Fecha desde:'
    end
    object Label2: TLabel
      Left = 235
      Top = 16
      Width = 62
      Height = 13
      Caption = 'Fecha hasta:'
    end
    object Label3: TLabel
      Left = 16
      Top = 44
      Width = 35
      Height = 13
      Caption = 'Legajo:'
    end
    object ImagenSalir: TImage
      Left = 714
      Top = 14
      Width = 43
      Height = 37
      Cursor = crHandPoint
      Hint = 'Salir'
      ParentShowHint = False
      Proportional = True
      ShowHint = True
      Transparent = True
    end
    object snDBDateEdit1: TsnDBDateEdit
      Left = 84
      Top = 12
      DataBinding.DataField = 'fec_desde'
      DataBinding.DataSource = DSInput
      TabOrder = 0
      ReadOnlyAlways = False
      Width = 109
    end
    object snDBDateEdit2: TsnDBDateEdit
      Left = 307
      Top = 12
      DataBinding.DataField = 'fec_hasta'
      DataBinding.DataSource = DSInput
      TabOrder = 1
      ReadOnlyAlways = False
      Width = 110
    end
    object srnDBButtonEdit1: TsrnDBButtonEdit
      Left = 84
      Top = 40
      DataBinding.DataField = 'cod_legajo'
      DataBinding.DataSource = DSInput
      Properties.Buttons = <
        item
          Default = True
          Kind = bkEllipsis
        end>
      Properties.ClickKey = 112
      TabOrder = 2
      Help = HelpLegajos
      Width = 121
    end
    object snDBEdit1: TsnDBEdit
      Left = 203
      Top = 40
      DataBinding.DataField = 'nombre_legajo'
      DataBinding.DataSource = DSInput
      Properties.ReadOnly = True
      TabOrder = 3
      Width = 326
    end
    object BotonMovimientos: TsnButton
      Left = 552
      Top = 8
      Width = 137
      Height = 49
      Cursor = crHandPoint
      Caption = 'Consultar'
      TabOrder = 4
      Glyph.Data = {
        36080000424D3608000000000000360400002800000020000000200000000100
        0800000000000004000000000000000000000001000000000000FFFFFF000000
        000049246D00472B6300432C590045276200402E5B003E2C6100442B5E004028
        60003E286000432C5E003C2662004029600041295D0041295F00412A5F00412A
        5E0040295E0042295F0041295E00402B5D00402A5D00402B5E0042295F00412B
        5E00402A5E0042295E00412B5E00412A5E0041295E00422B5F00412A5E00412A
        5F00402B5E00412A5E00412A5E00402A5F0041295E00412B5E00402B5F00412A
        5E00402A5F00412B5F00412B5F00412B5E00412A5F00412B5F00412A5F00412B
        5F00422B5F00422C5F00412B5F00412B5F00422B5F00412A5F00412A5E00422A
        5E00422A5F00493361003F2D650049376A004B3B6D004C3B6D004C3D6E004C3D
        6F00412C5F00422C5F00432D5F00402B6000412C6000422C6000422D6000432D
        6100432E6100432F6200442F6200443062004430630045316400513E64005340
        640054426500564466005A4A670044396D004A3B6D004C3E6F004E4171005046
        7600524878003C367900544D7C0056507E00412A5E00412B5E00422B5E00422C
        5E00412A5F00412B5F00422B5F004B3762004E3A6300513E6400564466005A49
        67005F5069006C606E006D616E006E626F007267700073687100776D72007D75
        74007E777500898479008D897A00534B7B00908D7C00918E7C0096947E005752
        80009C9C80009D9D810058558300595785005A5786005B598600ACB086005C5B
        8800B3B98900B4BA8900B7BE8A005E5E8B00B8BF8B00BAC18B00BCC48C00BDC6
        8D00BFC78D00BFC88D00C1CA8E0038408F004D5B8F0060628F00616490006266
        9200646A9500646A9600676F9A0068709B0068729C006B76A0006F7EA7007080
        A8007385AD007487AF007589B000768AB100567EB200778DB300788DB4005781
        B5007990B6005884B8007B93B9005887BB007E99BE007F9ABF00829FC40082A0
        C40083A1C50083A3C6002E58C7002E59C70084A4C80084A5C8002D5AC90085A6
        C9002E5ACA002D5ACB002D5ACC0087AACD005D9ACE008DB3D5008DB4D60090BA
        DB0091BBDB0092BDDD0092BEDE0093BFDF0095C3E20063B0E40063B2E60098C9
        E80099CBE9009ACCEA009BCEEC009CCFED009DD1EF009ED2F0009ED3F0009ED4
        F1009FD4F100266BF2009FD5F200256FFB002471FF0000000000000000000000
        0000000000000000000000000000000000000000000000000000000000000000
        0000000000000000000000000000000000000000000000000000000000000000
        0000000000000000000000000000000000000000000000000000000000000000
        0000000000000000000000000000000000000000000000000000000000000000
        0000000000000000000000000000000000000000000000000000000000000000
        000000000000000000000000000000000000000000000000000001142D342209
        00000000000000000000000000000000000000000000000000000E5E3C5B5E30
        0A00000000000000000000000000000000000000000000000000253CCBCEAC45
        300A0000000000000000000000000000000000000000000000002E5BCECECEB2
        45300A0000000000000000000000000000000000000000000000185EACCECECE
        B245300A00000000000000000000000000000000000000000000043045B3CECE
        CEB245300A000000000000000000000000000000000000000000000A3045B3CE
        CECEB245300C000000000000000000000000000000000000000000000A3045B3
        CECECEAD62380A000000000000000000000000000000000000000000000A3045
        B4CECD8D5E5F310A00000B131D242A2012060000000000000000000000000A30
        45B08D5E8EA3423113295E5E5E5E48475E5E2B1501000000000000000000000A
        30625E8EBFC09E5E5E6385B1BEC4CCC3A894565E270500000000000000000000
        0A3763A5C0B6555E7DBCCCCCCCCCCCCCCCCCC5965E330F000000000000000000
        000A3146A1554AA4CCCCC29F935A58909ABCCCCCAF3D36080000000000000000
        00000A31635EA4CCCCAB3E5E5E5053615E4D9DC9CCB55E260000000000000000
        000000125E7ECCCC975E3B76868C8C887B515E7CC6CC955E1100000000000000
        000000225EBCCCAE5E6A838C8C8C8C8C8C886F5E98CCC3413503000000000000
        0000073981CCC23F3B838C8C8C8C8C8C8C8C8A5443B7CCA25E0F000000000000
        0000165EAACC9F5E768C8C8C8C8C8C8C8C8C8C806092CCB85E19000000000000
        00001C5EBDCC935E868C8C8C8C8C8C8C8C8C8C8C5259CCC64923000000000000
        00001E5EC2CC5A508C8C8C8C8C8C8C8C8C8C8C8C6D64C4CC752F000000000000
        00002147CCCC58538C8C8C8C8C8C8C8C8C8C8C8C6F5EC1CC7932000000000000
        00001F47C3CC9061888C8C8C8C8C8C8C8C8C8C8C6957CCC94F28000000000000
        0000125EA8CC9A5E7B8C7A71878C8C8B77788C84448FCCB95E1B000000000000
        0000065E94CCBD4E5188735E666E70685E6C8C6B5EA9CCA65E10000000000000
        0000002B56C5CCA05E6F8A76675E5E657289745E91CCC85C3908000000000000
        000000155E96CCCA7F5E54808C86828C846B5E40C1CC9B5E1A00000000000000
        00000001275EAFCCC7994860526D6F69445E91C1CCBB4B2C0200000000000000
        0000000005333DB5CCCCB89259645E578FA9CCCCBB753A0D0000000000000000
        00000000000F365E95C3CCCCCCC4C1CCCCCCC99C4C3A17000000000000000000
        00000000000008265E41A2B8C6CCCCC9BAA75D5E2C0D00000000000000000000
        000000000000000011355E5E4975794F5E5E391A020000000000000000000000
        000000000000000000030F19232F32281B100800000000000000}
      LookAndFeel.Kind = lfOffice11
    end
  end
  object Panel2: TPanel [1]
    Left = 0
    Top = 73
    Width = 806
    Height = 394
    Align = alClient
    Color = clWindow
    TabOrder = 1
    object dxDBGridSN1: TdxDBGridSN
      Left = 1
      Top = 1
      Width = 804
      Height = 392
      Align = alClient
      TabOrder = 0
      CriteriosPintarCelda = <>
      object dxDBGridSN1DBTableView1: TcxGridDBTableView
        NavigatorButtons.ConfirmDelete = False
        DataController.DataSource = DSTNovedades
        DataController.Options = [dcoAssignGroupingValues, dcoAssignMasterDetailKeys, dcoSaveExpanding, dcoGroupsAlwaysExpanded]
        DataController.Summary.DefaultGroupSummaryItems = <>
        DataController.Summary.FooterSummaryItems = <>
        DataController.Summary.SummaryGroups = <>
        OptionsData.CancelOnExit = False
        OptionsData.Deleting = False
        OptionsData.DeletingConfirmation = False
        OptionsData.Editing = False
        OptionsData.Inserting = False
        OptionsView.CellAutoHeight = True
        object dxDBGridSN1DBTableView1legajo: TcxGridDBColumn
          Caption = 'Legajo'
          DataBinding.FieldName = 'legajo'
          Width = 100
        end
        object dxDBGridSN1DBTableView1ape_y_nom: TcxGridDBColumn
          Caption = 'Apellido y Nombre'
          DataBinding.FieldName = 'ape_y_nom'
          Width = 200
        end
        object dxDBGridSN1DBTableView1descripcion_motivo: TcxGridDBColumn
          Caption = 'Motivo'
          DataBinding.FieldName = 'descripcion_motivo'
          Width = 157
        end
        object dxDBGridSN1DBTableView1fecha: TcxGridDBColumn
          Caption = 'Fecha'
          DataBinding.FieldName = 'fecha'
        end
        object dxDBGridSN1DBTableView1hora_desde: TcxGridDBColumn
          Caption = 'Hora Desde'
          DataBinding.FieldName = 'hora_desde'
          Width = 68
        end
        object dxDBGridSN1DBTableView1hora_hasta: TcxGridDBColumn
          Caption = 'Hora Hasta'
          DataBinding.FieldName = 'hora_hasta'
          Width = 70
        end
        object dxDBGridSN1DBTableView1permiso_ingreso: TcxGridDBColumn
          Caption = 'Permiso Ingreso'
          DataBinding.FieldName = 'permiso_ingreso'
          Width = 150
        end
        object dxDBGridSN1DBTableView1permiso_egreso: TcxGridDBColumn
          Caption = 'Permiso Egreso'
          DataBinding.FieldName = 'permiso_egreso'
          Width = 150
        end
        object dxDBGridSN1DBTableView1observacion: TcxGridDBColumn
          Caption = 'Observaci'#243'n'
          DataBinding.FieldName = 'observacion'
          Width = 170
        end
        object dxDBGridSN1DBTableView1ape_y_nom_usu_asig_perm: TcxGridDBColumn
          Caption = 'Usuario'
          DataBinding.FieldName = 'ape_y_nom_usu_asig_perm'
          Width = 167
        end
        object dxDBGridSN1DBTableView1fec_usu_asig_perm: TcxGridDBColumn
          Caption = 'Fec. Usu. Asigno'
          DataBinding.FieldName = 'fec_usu_asig_perm'
          Width = 97
        end
        object dxDBGridSN1DBTableView1hor_usu_asig_perm: TcxGridDBColumn
          Caption = 'Hora Usu. Asigno'
          DataBinding.FieldName = 'hor_usu_asig_perm'
          Width = 93
        end
        object dxDBGridSN1DBTableView1descripcion_grupo_puerta: TcxGridDBColumn
          Caption = 'Puerta'
          DataBinding.FieldName = 'descripcion_grupo_puerta'
          Width = 150
        end
      end
      object dxDBGridSN1Level1: TcxGridLevel
        GridView = dxDBGridSN1DBTableView1
      end
    end
  end
  inherited DriverABM: TDriverABM
    CargaDataSets = <
      item
        DataSet = TNovedades
        TableName = 'TNovedades'
      end>
    Left = 192
    Top = 24
  end
  inherited Operacion: TOperacion
    Left = 232
    Top = 24
  end
  inherited TOidObjSave: TsnTable
    Left = 640
    Top = 56
  end
  inherited dxComponentPrinter: TdxComponentPrinter
    Left = 272
    Top = 24
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
    Top = 24
  end
  inherited DriverEvent: TDriverEvent
    OnShow.Strings = (
      'begin'
      '  Varios.setImagen('#39'ImagenSalir'#39',7);'
      'end.')
    OnValidate = <
      item
        TableName = 'Tinput'
        FieldName = 'cod_legajo'
        Source.Strings = (
          'begin'
          '  ValidadorLegajo.Value := Sender.AsString;'
          '  ValidadorLegajo.Validar;'
          'end.')
      end>
    OnInicializar = <
      item
        Source.Strings = (
          'begin'
          '  Tinput.Close;'
          '  Tinput.Open;'
          '  Tinput.AppendRecord;'
          'end.')
      end>
    OnFormFunction = <
      item
        Source.Strings = (
          'procedure TraerConsulta();'
          'begin'
          ''
          '  operacion.InicioOperacion();'
          '  operacion.setOper('#39'TraerNovPermisosCIP'#39');'
          
            '  operacion.AddAtribute('#39'fec_desde'#39', TInput.FieldName('#39'fec_desde' +
            #39').AsString);'
          
            '  operacion.AddAtribute('#39'fec_hasta'#39', TInput.FieldName('#39'fec_hasta' +
            #39').AsString);'
          '  if (TInput.FieldName('#39'oid_legajo'#39').AsInteger>0)'
          
            '     then operacion.AddAtribute('#39'oid_legajo'#39',TInput.FieldName('#39'o' +
            'id_legajo'#39').AsString);'
          '  operacion.execute();'
          ''
          '  dxDBGridSN1.gotoFirstRecord();'
          ''
          'end;')
      end>
    OnClickToolButton = <
      item
        ButtonName = 'ImagenSalir'
        Source.Strings = (
          'begin'
          '  close;'
          'end.')
      end
      item
        ButtonName = 'BotonMovimientos'
        Source.Strings = (
          'begin'
          '  TInput.PostRecord;'
          '  if (TInput.fieldName('#39'fec_desde'#39').IsNull)'
          
            '     then raiseException(erCustomError,'#39'Debe ingresar la fecha d' +
            'esde'#39');'
          '  if (TInput.fieldName('#39'fec_hasta'#39').IsNull)'
          
            '     then raiseException(erCustomError,'#39'Debe ingresar la fecha h' +
            'asta'#39');'
          '  TraerConsulta();'
          'end.')
      end>
    Left = 352
    Top = 27
  end
  inherited ImprimirObjetoSeleccionado: TdxComponentPrinter
    inherited ImprimirObjetoSeleccionadodxComponentPrinterLink: TdxGridReportLink
      BuiltInReportLink = True
    end
  end
  object HelpLegajos: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'su.Legajo'
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
        AsignarACampo = Tinputcod_legajo
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
    Titulo = 'Legajos'
    AnchoHelp = 600
    ActivarCache = False
    ShowBotonBuscar = False
    Left = 218
    Top = 223
  end
  object ValidadorLegajo: TValidador
    Operacion = Operacion
    NickNameObjLog = 'su.Legajo'
    MensajeException = 'C'#243'digo de Legajo Inexistente'
    CampoOID = Tinputoid_legajo
    CampoDescripcion = Tinputnombre_legajo
    NroQuery = 0
    Cache = True
    Left = 254
    Top = 223
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
    Left = 144
    Top = 169
    object Tinputfec_desde: TDateField
      FieldName = 'fec_desde'
    end
    object Tinputfec_hasta: TDateField
      FieldName = 'fec_hasta'
    end
    object Tinputoid_legajo: TIntegerField
      FieldName = 'oid_legajo'
    end
    object Tinputcod_legajo: TStringField
      FieldName = 'cod_legajo'
      Size = 50
    end
    object Tinputnombre_legajo: TStringField
      FieldName = 'nombre_legajo'
      Size = 100
    end
  end
  object DSInput: TDataSource
    DataSet = Tinput
    Left = 176
    Top = 169
  end
  object Varios: TsnVarios
    Operacion = Operacion
    Left = 456
    Top = 141
  end
  object TNovedades: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'oid_nov_permiso'
        DataType = ftInteger
      end
      item
        Name = 'oid_motivo'
        DataType = ftInteger
      end
      item
        Name = 'descripcion_motivo'
        DataType = ftString
        Size = 100
      end
      item
        Name = 'fecha'
        DataType = ftDate
      end
      item
        Name = 'hora_desde'
        DataType = ftString
        Size = 5
      end
      item
        Name = 'hora_hasta'
        DataType = ftString
        Size = 5
      end
      item
        Name = 'observacion'
        DataType = ftString
        Size = 100
      end
      item
        Name = 'permiso_ingreso'
        DataType = ftString
        Size = 50
      end
      item
        Name = 'permiso_egreso'
        DataType = ftString
        Size = 50
      end
      item
        Name = 'oid_legajo'
        DataType = ftInteger
      end
      item
        Name = 'legajo'
        DataType = ftString
        Size = 50
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
    Left = 408
    Top = 321
    object TNovedadesoid_nov_permiso: TIntegerField
      FieldName = 'oid_nov_permiso'
    end
    object TNovedadesoid_motivo: TIntegerField
      FieldName = 'oid_motivo'
    end
    object TNovedadesdescripcion_motivo: TStringField
      FieldName = 'descripcion_motivo'
      Size = 100
    end
    object TNovedadesfecha: TDateField
      FieldName = 'fecha'
    end
    object TNovedadeshora_desde: TStringField
      FieldName = 'hora_desde'
      Size = 5
    end
    object TNovedadeshora_hasta: TStringField
      FieldName = 'hora_hasta'
      Size = 5
    end
    object TNovedadesobservacion: TStringField
      FieldName = 'observacion'
      Size = 100
    end
    object TNovedadespermiso_ingreso: TStringField
      FieldName = 'permiso_ingreso'
      Size = 50
    end
    object TNovedadespermiso_egreso: TStringField
      FieldName = 'permiso_egreso'
      Size = 50
    end
    object TNovedadesoid_legajo: TIntegerField
      FieldName = 'oid_legajo'
    end
    object TNovedadeslegajo: TStringField
      FieldName = 'legajo'
      Size = 50
    end
    object TNovedadesape_y_nom: TStringField
      FieldName = 'ape_y_nom'
      Size = 100
    end
    object TNovedadesoid_usu_asig_perm: TIntegerField
      FieldName = 'oid_usu_asig_perm'
    end
    object TNovedadesape_y_nom_usu_asig_perm: TStringField
      FieldName = 'ape_y_nom_usu_asig_perm'
      Size = 100
    end
    object TNovedadesfec_usu_asig_perm: TDateField
      FieldName = 'fec_usu_asig_perm'
    end
    object TNovedadeshor_usu_asig_perm: TStringField
      FieldName = 'hor_usu_asig_perm'
      Size = 5
    end
    object TNovedadesoid_grupo_puerta: TIntegerField
      FieldName = 'oid_grupo_puerta'
    end
    object TNovedadesdescripcion_grupo_puerta: TStringField
      FieldName = 'descripcion_grupo_puerta'
      Size = 100
    end
    object TNovedadesactivo: TBooleanField
      FieldName = 'activo'
    end
  end
  object DSTNovedades: TDataSource
    DataSet = TNovedades
    Left = 448
    Top = 321
  end
end
