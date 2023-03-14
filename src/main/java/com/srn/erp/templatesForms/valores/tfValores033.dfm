inherited FTransfClie: TFTransfClie
  Left = 435
  Top = 216
  Width = 565
  Height = 283
  BorderIcons = [biSystemMenu]
  Caption = 'Transferencia de Cliente'
  DragKind = dkDrag
  DragMode = dmManual
  OldCreateOrder = True
  Position = poScreenCenter
  PixelsPerInch = 96
  TextHeight = 13
  object Panel1: TPanel [0]
    Left = 0
    Top = 0
    Width = 557
    Height = 5
    Align = alTop
    BevelOuter = bvNone
    Color = clWindow
    TabOrder = 0
  end
  object Panel2: TPanel [1]
    Left = 0
    Top = 208
    Width = 557
    Height = 41
    Align = alBottom
    BevelOuter = bvNone
    Color = clWindow
    TabOrder = 2
    object BotonAceptar: TsnButton
      Left = 348
      Top = 8
      Width = 75
      Height = 25
      Hint = '<ENTER> Aceptar'
      Caption = '&Aceptar'
      Default = True
      TabOrder = 0
      LookAndFeel.Kind = lfOffice11
    end
    object BotonCancelar: TsnButton
      Left = 444
      Top = 8
      Width = 75
      Height = 25
      Caption = '&Cancelar'
      TabOrder = 1
      LookAndFeel.Kind = lfOffice11
    end
  end
  object Panel3: TPanel [2]
    Left = 0
    Top = 5
    Width = 557
    Height = 203
    Align = alClient
    BevelOuter = bvNone
    Color = clWindow
    TabOrder = 1
    object Label1: TLabel
      Left = 32
      Top = 19
      Width = 79
      Height = 13
      Caption = 'Cuenta Bancaria'
    end
    object Label2: TLabel
      Left = 32
      Top = 61
      Width = 88
      Height = 13
      Caption = 'Nro. Transferencia'
    end
    object Label3: TLabel
      Left = 32
      Top = 101
      Width = 60
      Height = 13
      Caption = 'Fec. Emisi'#243'n'
    end
    object Label4: TLabel
      Left = 32
      Top = 141
      Width = 82
      Height = 13
      Caption = 'Fec. Vencimiento'
    end
    object Label5: TLabel
      Left = 32
      Top = 176
      Width = 35
      Height = 13
      Caption = 'Importe'
    end
    object DBBanco: TsrnDBButtonEdit
      Left = 128
      Top = 15
      DataBinding.DataField = 'cod_cta_banco'
      DataBinding.DataSource = DSTransferenciaCliente
      Properties.Buttons = <
        item
          Default = True
          Kind = bkEllipsis
        end>
      Properties.CharCase = ecUpperCase
      Properties.ClickKey = 112
      Style.Shadow = False
      TabOrder = 0
      Help = HelpCtaBancaria
      Width = 112
    end
    object snDBEdit1: TsnDBEdit
      Left = 238
      Top = 15
      TabStop = False
      DataBinding.DataField = 'desc_cta_banco'
      DataBinding.DataSource = DSTransferenciaCliente
      Style.BorderColor = clWindowFrame
      Style.Shadow = False
      TabOrder = 2
      ReadOnlyAlways = True
      Width = 310
    end
    object snDBFecEmiDesde: TsnDBDateEdit
      Left = 128
      Top = 97
      DataBinding.DataField = 'fec_emision'
      DataBinding.DataSource = DSTransferenciaCliente
      TabOrder = 3
      ReadOnlyAlways = False
      Width = 88
    end
    object snDBDateEdit1: TsnDBDateEdit
      Left = 128
      Top = 137
      DataBinding.DataField = 'fec_vto'
      DataBinding.DataSource = DSTransferenciaCliente
      TabOrder = 4
      ReadOnlyAlways = False
      Width = 88
    end
    object snDBEdit2: TsnDBEdit
      Left = 128
      Top = 172
      DataBinding.DataField = 'importe'
      DataBinding.DataSource = DSTransferenciaCliente
      TabOrder = 5
      Width = 89
    end
    object DBNroTarjeta: TsnDBMaskEdit
      Left = 128
      Top = 56
      DataBinding.DataField = 'nro_transferencia'
      DataBinding.DataSource = DSTransferenciaCliente
      TabOrder = 1
      Width = 121
    end
  end
  inherited TOidObjSave: TsnTable
    Left = 448
    Top = 64
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
    OnShow.Strings = (
      'begin'
      ' '
      '  DBBanco.setFoco();'
      ''
      '  variable.addVariantValue('#39'acepto'#39',false);'
      ''
      '  TTransferenciaCliente.Close;'
      '  TTransferenciaCliente.Open;'
      '  TTransferenciaCliente.Append;'
      ''
      
        '  TTransferenciaCliente.FieldName('#39'nro_transferencia'#39').AsString ' +
        ':= '
      '      variable.getString('#39'nro_valor'#39');'
      '  if (variable.getInteger('#39'oid_cta_banco'#39')>0)'
      
        '    then TTransferenciaCliente.FieldName('#39'cod_cta_banco'#39').AsStri' +
        'ng :='
      
        '                        getCodigoCtaBanco(variable.getInteger('#39'o' +
        'id_cta_banco'#39'));'
      '  TTransferenciaCliente.FieldName('#39'fec_emision'#39').Value := '
      '      variable.getValue('#39'fec_emision'#39');  '
      '  TTransferenciaCliente.FieldName('#39'fec_vto'#39').Value := '
      '      variable.getValue('#39'fec_vto'#39');  '
      '  TTransferenciaCliente.FieldName('#39'importe'#39').AsCurrency :='
      '      variable.getCurrency('#39'importe'#39');'
      'end.')
    OnValidate = <
      item
        TableName = 'TTransferenciaCliente'
        FieldName = 'cod_cta_banco'
        Source.Strings = (
          'begin'
          '  ValidadorCtaBancaria.Value := Sender.AsString;'
          '  ValidadorCtaBancaria.Validar;'
          'end.')
      end>
    OnBeforePost = <
      item
        TableName = 'TTransferenciaCliente'
        Source.Strings = (
          'begin'
          '  Validar();'
          'end.')
      end>
    OnKeyDown = <
      item
        Key = 123
        Shift = []
        isNuevo = False
        isModificar = False
        isBrowse = True
        Source.Strings = (
          'begin'
          '  Aceptar();'
          'end.')
      end>
    OnPublicVariable = <
      item
        VariableName = 'oid_cta_banco'
      end
      item
        VariableName = 'nro_transferencia'
      end
      item
        VariableName = 'fec_emision'
      end
      item
        VariableName = 'fec_vto'
      end
      item
        VariableName = 'importe'
      end
      item
        VariableName = 'acepto'
      end
      item
        VariableName = 'TTransferenciaCliente'
      end
      item
        VariableName = 'nro_valor'
      end>
    OnInicializar = <
      item
        Source.Strings = (
          'begin'
          '  HelpCtasBanco.loadFromHelp('#39'HelpCtaBancaria'#39');'
          'end.')
      end>
    OnFormFunction = <
      item
        Source.Strings = (
          'function getCodigoCtaBanco(Oid : integer) : string;'
          'begin'
          '    HelpCtasBanco.first;'
          '    if (HelpCtasBanco.Locate('#39'oid'#39',oid,[]))'
          '       then result := HelpCtasBanco.FieldName('#39'codigo'#39').AsString'
          '       else result := '#39#39';'
          'end;'
          ''
          ''
          'procedure Validar();'
          'begin'
          ''
          
            'if (TTransferenciaCliente.FieldName('#39'oid_cta_banco'#39').AsInteger =' +
            ' 0)'
          
            '    then raiseexception(erCustomError, '#39'Debe ingresar la Cuenta ' +
            'Bancaria'#39');'
          ''
          
            'if (TTransferenciaCliente.FieldName('#39'nro_transferencia'#39').AsInteg' +
            'er = 0)'
          
            '    then raiseexception(erCustomError, '#39'Debe ingresar el Nro. de' +
            ' Transferencia'#39');'
          ''
          'if (TTransferenciaCliente.FieldName('#39'fec_emision'#39').Isnull)'
          
            '    then raiseexception(erCustomError, '#39'Debe ingresar la Fecha d' +
            'e Emisi'#243'n'#39'); '
          ''
          'if (TTransferenciaCliente.FieldName('#39'fec_vto'#39').Isnull)'
          
            '    then raiseexception(erCustomError, '#39'Debe ingresar la Fecha d' +
            'e Vencimiento'#39'); '
          ''
          'if (TTransferenciaCliente.FieldName('#39'importe'#39').AsCurrency<=0)'
          
            '    then raiseexception(erCustomError, '#39'Debe ingresar el Importe' +
            #39'); '
          ''
          'end;'
          ''
          ''
          'procedure Aceptar();'
          'begin'
          '  TTransferenciaCliente.PostRecord;'
          '  variable.addVariantValue('#39'acepto'#39',true);'
          '  close();'
          'end;'
          '')
      end>
    OnClickToolButton = <
      item
        ButtonName = 'BotonAceptar'
        Source.Strings = (
          'begin'
          '  Aceptar();'
          'end.')
      end
      item
        ButtonName = 'BotonCancelar'
        Source.Strings = (
          'begin'
          '  variable.addVariantValue('#39'acepto'#39',false);'
          '  close();'
          'end.')
      end>
  end
  inherited ImprimirObjetoSeleccionado: TdxComponentPrinter
    inherited ImprimirObjetoSeleccionadodxComponentPrinterLink: TdxGridReportLink
      BuiltInReportLink = True
    end
  end
  object TTransferenciaCliente: TsnTable
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
    Left = 136
    Top = 124
    object TTransferenciaClientefec_emision: TDateField
      FieldName = 'fec_emision'
    end
    object TTransferenciaClientefec_vto: TDateField
      FieldName = 'fec_vto'
    end
    object TTransferenciaClienteimporte: TCurrencyField
      FieldName = 'importe'
      DisplayFormat = '###,###,###,###,##0.00'
    end
    object TTransferenciaClienteoid_cta_banco: TIntegerField
      FieldName = 'oid_cta_banco'
    end
    object TTransferenciaClientecod_cta_banco: TStringField
      FieldName = 'cod_cta_banco'
      Size = 50
    end
    object TTransferenciaClientedesc_cta_banco: TStringField
      FieldName = 'desc_cta_banco'
      Size = 100
    end
    object TTransferenciaClientenro_transferencia: TIntegerField
      FieldName = 'nro_transferencia'
    end
  end
  object DSTransferenciaCliente: TDataSource
    DataSet = TTransferenciaCliente
    Left = 168
    Top = 124
  end
  object TTarjetas: TsnTable
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
    Left = 408
    Top = 113
    object TTarjetasoid: TIntegerField
      FieldName = 'oid'
    end
    object TTarjetascodigo: TStringField
      FieldName = 'codigo'
      Size = 50
    end
    object TTarjetasdescripcion: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
    object TTarjetasactivo: TBooleanField
      FieldName = 'activo'
    end
  end
  object HelpCtaBancaria: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'te.CuentaBancaria'
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
        AsignarACampo = TTransferenciaClientecod_cta_banco
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
    Titulo = 'Cuentas Bancarias'
    AnchoHelp = 600
    ActivarCache = False
    ShowBotonBuscar = False
    Left = 66
    Top = 31
  end
  object ValidadorCtaBancaria: TValidador
    Operacion = Operacion
    NickNameObjLog = 'te.CuentaBancaria'
    MensajeException = 'C'#243'digo de Cuenta Bancaria Inexistente'
    CampoOID = TTransferenciaClienteoid_cta_banco
    CampoDescripcion = TTransferenciaClientedesc_cta_banco
    NroQuery = 0
    Cache = True
    Left = 102
    Top = 31
  end
  object HelpCtasBanco: TsnTable
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
    Left = 8
    Top = 93
    object HelpCtasBancooid: TIntegerField
      FieldName = 'oid'
    end
    object HelpCtasBancocodigo: TStringField
      FieldName = 'codigo'
      Size = 50
    end
    object HelpCtasBancodescripcion: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
  end
end
