inherited FRecluAltaCompBusq: TFRecluAltaCompBusq
  Left = 174
  Top = 241
  Width = 641
  Height = 285
  BorderIcons = []
  Caption = 'Alta de Competencia'
  DragKind = dkDrag
  DragMode = dmManual
  Position = poScreenCenter
  PixelsPerInch = 96
  TextHeight = 13
  object Panel1: TPanel [0]
    Left = 0
    Top = 0
    Width = 625
    Height = 81
    Align = alTop
    BevelOuter = bvNone
    Color = clWindow
    TabOrder = 0
    object Label1: TLabel
      Left = 12
      Top = 11
      Width = 369
      Height = 18
      Caption = 'Alta de competencia asociada a la B'#250'squeda'
      Font.Charset = ANSI_CHARSET
      Font.Color = clWindowText
      Font.Height = -16
      Font.Name = 'Verdana'
      Font.Style = []
      ParentFont = False
    end
    object snDBEdit1: TsnDBEdit
      Left = 8
      Top = 36
      DataBinding.DataField = 'descripcion'
      DataBinding.DataSource = DSPuestoBusqueda
      ParentFont = False
      Properties.ReadOnly = True
      Style.Font.Charset = ANSI_CHARSET
      Style.Font.Color = 16742263
      Style.Font.Height = -19
      Style.Font.Name = 'Verdana'
      Style.Font.Style = []
      Style.IsFontAssigned = True
      TabOrder = 0
      ReadOnlyAlways = True
      Width = 609
    end
  end
  object Panel2: TPanel [1]
    Left = 0
    Top = 182
    Width = 625
    Height = 65
    Align = alBottom
    Color = clWindow
    TabOrder = 1
    object BotonGrabar: TsnButton
      Left = 336
      Top = 1
      Width = 105
      Height = 45
      Cursor = crHandPoint
      Hint = 'Nueva Competencia'
      Caption = 'Grabar'
      TabOrder = 0
      Glyph.Data = {
        42080000424D4208000000000000420000002800000020000000200000000100
        10000300000000080000202E0000202E00000000000000000000007C0000E003
        00001F000000FF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7F
        FF7FFF7FFF7FFF7F7B73136BFF7FFF7FFF7FFF7FFF7FFF7FFF7FDF7BF2669A7B
        FF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7F
        FF7FFF7FFF7FFF7F964E0035A76E356BFF7BFF7FFF7FFF7B1567485A0052BB77
        FF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7F
        FF7FBD77F75E524A09212035E07A6066AB627A735A6B6B5A6062A072C96AFF7B
        FF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FDE7B7B6FB55ACE3D
        A51821080000000002004529817F607FE076A16A8166E076607F007B106BFF7F
        FF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FBD7759679352AD350825620C00000000
        000086084D1D543ADA4ECD350173807F607F607F607F607F607F0073546BFF7F
        FF7FFF7FFF7FFF7FFF7FFF7F524E0825420C0000000000004300E910F02DB74A
        7C63DF6FFF7BFF7FFF7F1342C462E07FA07FA07FA07FA07FC07F226B7C6FFF7F
        FF7FFF7FFF7FFF7FFF7FEE410000000043000A11F12DB6425B5BDF6FFF7FFF7F
        FF7FFF7FFF7FFF7F5D67724A6473E07FC07FC07FC07FC07FE07F8277566BDF7B
        FF7FFF7FFF7FFF7FBD7BC70C8E1D1A579D6BDF77FF7FFF7FFF7FFF7FFF7FFF7B
        BE6F5A63744A9129EF3DA877E07FE07FE07FE07FE07FE07FE07FE07F636F566B
        FF7FFF7FFF7FFF7F5A6B122EDF73FF7FFF7FFF7FFF7FDF777C6F3A5F944A113E
        D0356E29CC106B29A677E07FE07FE07FE07FE07FE07FE07FE07FE07FE07F8373
        9873FF7FFF7FFF7F5A675436FF7BFF7F395FB54E3342F1356D294C214C216E25
        902D6F25ED41AE77E67FE37FE17FE07FE07FE07FE07FE07FE07FE07FE27FA377
        E8623467FF7FFF7FDE77D12DD031113A6D214D216D258E29AF2DB02DD131D131
        F1318F298A31CB39ED414C4EA95A8977E17FC07FC07FE07F466F895A8E56B256
        9156F35EFE7FFF7FFF7FF85E2D216F29D135D235D135D135B0318F29D131B131
        8F29D135B23171296F297029EE140A21A77FE07FC07F6477F8623C675C6BBE77
        FF7FFF7FFF7FFF7FFF7FDF7B133AD131F135F135F135D135F135D7567C6F7C6B
        964ED135F235F239F239133A1536AA102856E37FA07FEA6E7F6FFF7FFF7FFF7F
        FF7FFF7FFF7FFF7FFF7FFF7FD856B12DF235F235F235B029F95AFF7FFF7FFF7F
        BD73D131D231F235F235F235133AB129A61C2677237F4831F95AFF7FFF7FFF7F
        FF7FFF7FFF7FFF7FFF7FFF7FBD73133AF23112361236F13154425B679D735B67
        333ED12D12361236123612361236553EEB108349AB664400EF3DFF7FFF7FFF7F
        FF7FFF7FFF7FFF7FFF7FFF7FFF7FF856D131333A333A333A1236F231F231B029
        F335333A133A333A333A333A333A543EF22DE624596B901984105A6FFF7FFF7F
        FF7FFF7FFF7FFF7FFF7FFF7FFF7FBD77133A1336343A343A343A1332964A5B67
        DE7B7B6BF2311336343E343A343A343A1336D12DFF7F1A4F0000EF45FF7FFF7F
        FF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FF8561336543E543E543E1336764AFF7F
        FF7FFF7FD852D229343A543E543E543E553ED12D3963FF7BE904420C5A6BFF7F
        FF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7F9D6F553E553A553E553E5542F331D852
        FF7FFF7FFF7FF95634361436543A55427642143A123AFF7F973A01003046FF7F
        FF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FF95A153A7642764276425542343A
        F956DE7BFF7FFF7FBD73FA5A553E143655429746B12D195FFF77E908A5187A6F
        FF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FBD73553E56427642764277467642
        353676463B5FDE7BFF7FFF7F9D73F956553A7642353A5442FF7FB73A0000304A
        FF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FF956563E9746974677427642
        7642553A353A76425C6BFF7FFF7FFF7F3B63563E984AF2357C6FFF73A8008418
        9C73FF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7F9D6F974697429746B74AD84E
        1957F9567742763E563E7D6BFF7FFF7FFF7FD94E9742553E7546FF7F33222100
        1867FF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7F1A5B97429742FA5AFF7F
        FF7FFF7FD94E563A3536FA56FF7FFF7FFF7F3B637742D94EF2315B6F7E5BD019
        DD7BFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7F9D6FB846B84A98465C67
        FF7FFF7FDF7B5B633B5FDE77FF7FFF7FBE77B94E9846D94E9846D035195FBF6B
        FF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7F1A53B946B9469842
        1A577C67BE73FF7FFF7BBE777D6F3B5FB846B846D94AD94A1C57F23184109B77
        FF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7F7C6BB94AD94ED94E
        B94AB946B94ADA4ADA4AB94AB846B946D94AD94ED94ED94EDA4EFB52C710724E
        FF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFB56BA4ADA4E
        DA4EDA4ABA4AB946BA46B94ABA4ABA46BA46DA4ADA4ADA4EDA4EFB4EB94A9C73
        FF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7F7D6BB946DA4A
        DA4EDA4EFB52FB521B571B5B1B5F3C5F5C637D679D6B9D6F9D6FBE73DF7BFF7F
        FF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7B7C679D6B
        BE73DE77DF7BDF7BFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7F
        FF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7F
        FF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7F
        FF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7F
        FF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7F
        FF7FFF7FFF7F}
      LookAndFeel.Kind = lfOffice11
    end
    object BotonCancelar: TsnButton
      Left = 472
      Top = 1
      Width = 113
      Height = 45
      Caption = 'Cancelar'
      TabOrder = 1
      Glyph.Data = {
        42080000424D4208000000000000420000002800000020000000200000000100
        10000300000000080000202E0000202E00000000000000000000007C0000E003
        00001F000000FF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7F
        FF7FFF7FFF7FFF7FFF7FFF7B7B6F945ACE49CE49EF4994527B67FF7BFF7FFF7F
        FF7FFF7FFF7FFF7FFF7FFF7FFF7F5C5B372E583A583A583A583A583A583A583A
        583A583A583ABC3256362A49214400480054005400500048213CE92C5B5FFF7F
        FF7FFF7FFF7FFF7FFF7FFF7FFF7FFA42B809F91D191E191E191E191E191E191E
        191E191E7E1694190038005442688374427C427C847884702160004484301857
        FF7FFF7FFF7FFF7FFF7FFF7FFF7F1B4B3A22BC36BB36BB36BB36BB36BB36BB36
        9B361F33F4390054836C087DA57C217C007C007C427CA57C4A7D297900540030
        395BFF7FFF7FFF7FFF7FFF7FFF7F1B4B5A26BC3ABB36BB3ABB3ABB3ABB3ABB3A
        FE3ADC36014C4264EF7D4B798470426C0078217C4174856CE870CE758D750058
        C634DE6FFF7FFF7FFF7FFF7FFF7F1B4B7B2ADC3EDC3EDC42DC42DC42DC42DC42
        5F3F2C454160107ECE717B677B677B5B6B61007873669B635A63F75A327A6C7D
        0040EF49FF7FFF7FFF7FFF7FFF7F1B4B9B2EDC46FC46FC46FC46FC46FC463E47
        DB4601506B71737E08759472FF7FFF7FF75E2955DE7BFF7FFF7B946AAD7D737E
        2158633CDE73FF7FFF7FFF7FFF7F1B4BBC361D4F1D4B3D4F3D4F3D4F3C4F9F4B
        F14D0058527A527E6B7D08719C77FF7FDE7BDE6FFF7FFF7F396B2971CE7D737E
        086D00403967FF7FFF7FFF7FFF7F1B4BBC3A3E535E535E533E533E533E53BF53
        8E4D415C527EEF7DAD7D08793172FF7FFF7FFF7FFF7FDE73CE696A7DEE7D527E
        8C710048F762FF7FFF7FFF7FFF7F1B4BFD427F5B7E577E5B7E5B7E5B7E5BFF5B
        8D4D215C107EEF7DAD7D6C7D8C71DE77FF7FFF7FFF7F18634A71CE7DCE7D107E
        6B71004CF762FF7FFF7FFF7FFF7F1B4B1D479F5F7E5B7E5F7E5F7E5F7E5FFF5F
        AE51205CEF7DCE7DAD7D4A79946AFF7BFF7FFF7FFF7FBD6FEF5DAD7DCE7D107E
        6B7100481867FF7FFF7FFF7FFF7F1B4B3E479F639F63BF67BF67BF67BF67FF67
        535E0054AD79CE7D8C7DCE6DDE73FF7FFF7F7B6FFF7FFF7F395FAD65CE7D107E
        E76C00447B6FFF7FFF7FFF7FFF7F1B4B3D4FBF6BBF67BF6BBF6BBF6BBF6BFF6B
        7C6721500871CE7D6B75396BFF7FFF7F5B7352629C77FF7FFF7BD65EAD79107E
        005CC64CFF7BFF7FFF7FFF7FFF7F1B4B5D53DF6FBF6BDF6BDF6BDF6BDF6BDF6B
        FF6FEF5D0054AD7D107AB572F77238731973197F17731873F776D66E527E4A79
        0044D666FF7FFF7FFF7FFF7FFF7F1B4B5D53DF73DF6BDF6FDF6FDF6FDF6FDF6F
        FF73BD6F214C635C317E527EB57A387B7C7F9C7F397FD67A947A737ECE790050
        6B55FF7FFF7FFF7FFF7FFF7FFF7F1B4B5D53FF73DF6FDF6FDF6FDF6FDF6FDF6F
        DF6FFF73396F424C2158CE79D67E5A7FDE7FDE7F5A7FF77E737E6B7500500851
        DE7FFF7FFF7FFF7FFF7FFF7FFF7F1B4B7D57FF73DF6FDF73DF73DF73DF73DF73
        DF73DF73FF7B396F634C0050A568AC75317E527E107A4A754260004C4B59DE7B
        FF7FFF7FFF7FFF7FFF7FFF7FFF7F1B4B7D57FF77DF6FDF73DF73DF73DF73DF73
        DF73DF73DF73FF77DE7752628454005000540058005400542959F245DF6BFF7F
        FF7FFF7FFF7FFF7FFF7FFF7FFF7F1B4B7D5BFF77DF73FF73FF73FF73FF73FF73
        FF73FF73FF73FF73FF73FF77FF73F76A326231625266396FFF777F4F7D67FF7F
        FF7FFF7FFF7FFF7FFF7FFF7FFF7F1B4B7D5BFF77FF73FF77FF77FF77FF77FF77
        FF77FF77FF77FF77FF77FF77FF77FF7BFF7BFF7BFF7BFF77FF73FB4E7C67FF7F
        FF7FFF7FFF7FFF7FFF7FFF7FFF7F1B4B7D5BFF7BFF77FF77FF77FF77FF77FF77
        FF77FF77FF77FF77FF77FF77FF77FF77FF77FF77FF77FF77FF77FB4E7C67FF7F
        FF7FFF7FFF7FFF7FFF7FFF7FFF7F1B4B7D5BFF7BFF77FF77FF77FF77FF77FF77
        FF77FF77FF77FF77FF77FF77FF77FF77FF77FF77FF77FF77FF77FB4A7C67FF7F
        FF7FFF7FFF7FFF7FFF7FFF7FFF7F1B4B7D5BFF7BFF77FF7BFF7BFF7BFF7BFF7B
        FF7BFF7BFF7BFF7BFF7BFF77FF77DE73BE73BE73DE77DE73DF73FA4A7C67FF7F
        FF7FFF7FFF7FFF7FFF7FFF7FFF7F1B4B7D5FFF7BFF7BFF7BFF7BFF7BFF7BFF7B
        FF7BFF7BFF7BFF7BFF7BFF7BBE6F9C6B7C675C637C677C677D6BB9425B63FF7F
        FF7FFF7FFF7FFF7FFF7FFF7FFF7F1B4B7D5FFF7BFF7BFF7BFF7BFF7BFF7BFF7B
        FF7BFF7BFF7BFF7BFF7BDF779D6B3A5FD752D752F8521A577C67983E7C67FF7F
        FF7FFF7FFF7FFF7FFF7FFF7FFF7F1B4B7D5FFF7FFF7BFF7BFF7BFF7BFF7BFF7B
        FF7BFF7BFF7BFF7BFF7BDE777B6BB94258265432543EB74EB936FA4ADE7BFF7F
        FF7FFF7FFF7FFF7FFF7FFF7FFF7F1B4B7D5FFF7FFF7BFF7BFF7BFF7BFF7BFF7B
        FF7BFF7BFF7BFF7BFF7BDE775A63BA3A3F47FB3EDA429A32772ABD73FF7FFF7F
        FF7FFF7FFF7FFF7FFF7FFF7FFF7F1B4B7D5FFF7FDF7BFF7BFF7BFF7BFF7BFF7B
        FF7BFF7BFF7BFF7BDF7BBE771A53FB3EDF6FDF739F5BDA3A9C73FF7FFF7FFF7F
        FF7FFF7FFF7FFF7FFF7FFF7FFF7F1B4B7E5FFF7BDF77DF7BDF7BDF7BDF7BDF7B
        DF7BDF7BDF7BDF7BDF7BDF7BFA4EFB46FF77DF6BDA423A63FF7FFF7FFF7FFF7F
        FF7FFF7FFF7FFF7FFF7FFF7FFF7FFB423D53DE73BE6FBE73BE73BE73BE73BE73
        BE73BE73BE73BE73BE6FBE735C63BA3E9E5F1B475B63FE7FFF7FFF7FFF7FFF7F
        FF7FFF7FFF7FFF7FFF7FFF7FFF7F7D5F1B4F5C5B5C5B5C5B5C5B5C5B5C5B5C5B
        5C5B5C5B5C5B5C5B5C5B5C575D5FFB4ADB425C5FFF7FFF7FFF7FFF7FFF7FFF7F
        FF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7BFF7BFF7BFF7BFF7BFF7B
        FF7BFF7BFF7BFF7BFF7FFF7BFF7BFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7F
        FF7FFF7FFF7F}
      LookAndFeel.Kind = lfOffice11
    end
  end
  object Panel3: TPanel [2]
    Left = 0
    Top = 81
    Width = 625
    Height = 101
    Align = alClient
    BevelOuter = bvNone
    Color = clWindow
    TabOrder = 2
    object Label4: TLabel
      Left = 16
      Top = 48
      Width = 80
      Height = 16
      Caption = 'Competencia'
      Font.Charset = DEFAULT_CHARSET
      Font.Color = clWindowText
      Font.Height = -13
      Font.Name = 'MS Sans Serif'
      Font.Style = []
      ParentFont = False
    end
    object snDBLookup1: TsnDBLookup
      Left = 128
      Top = 44
      DataBinding.DataField = 'oid_competencia'
      DataBinding.DataSource = DSInput
      ParentFont = False
      Properties.KeyFieldNames = 'oid'
      Properties.ListColumns = <
        item
          FieldName = 'descripcion'
        end>
      Properties.ListOptions.ShowHeader = False
      Properties.ListSource = DSRecluCompetencias
      Style.Font.Charset = DEFAULT_CHARSET
      Style.Font.Color = clWindowText
      Style.Font.Height = -13
      Style.Font.Name = 'MS Sans Serif'
      Style.Font.Style = []
      Style.IsFontAssigned = True
      TabOrder = 0
      Width = 433
    end
  end
  inherited DriverABM: TDriverABM
    CargaDataSets = <
      item
        DataSet = TPuestoBusqueda
        TableName = 'TPuestoBusqueda'
      end>
  end
  inherited TOidObjSave: TsnTable
    Left = 512
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
      ''
      '   operacion.InicioOperacion();'
      '   operacion.setOper('#39'TraerRecluPuestoBusqueda'#39');'
      
        '   operacion.AddAtribute('#39'oid_busqueda_act'#39',IntToStr(getVariable' +
        '.getValue('#39'oid_busqueda_act'#39')));'
      '   operacion.execute();'
      ''
      '   snDBLookup1.setFoco();'
      ''
      'end.')
    OnPublicVariable = <
      item
        VariableName = 'oid_busqueda_act'
      end>
    OnInicializar = <
      item
        Source.Strings = (
          'begin'
          '    TInput.Close;'
          '    TInput.Open;'
          '    TInput.AppendRecord;'
          '    TRecluCompetencias.loadFromHelp('#39'HelpCompetencias'#39');'
          'end.')
      end>
    OnFormFunction = <
      item
        Source.Strings = (
          'procedure grabarCompetencia();'
          'begin'
          '  operacion.InicioOperacion();'
          '  operacion.setOper('#39'SaveRecluAltaCompeBusqueda'#39');'
          
            '  operacion.AddAtribute('#39'oid_competencia'#39',TInput.FieldName('#39'oid_' +
            'competencia'#39').AsString);'
          
            '  operacion.AddAtribute('#39'oid_busqueda_act'#39',IntToStr(getVariable(' +
            ').getInteger('#39'oid_busqueda_act'#39')));'
          '  operacion.execute();'
          'end;'
          ''
          ''
          '')
      end>
    OnClickToolButton = <
      item
        ButtonName = 'BotonGrabar'
        Source.Strings = (
          'begin'
          '  grabarCompetencia();  '
          '  close;'
          'end.')
      end
      item
        ButtonName = 'BotonCancelar'
        Source.Strings = (
          'begin'
          
            '  if (not mensaje.question('#39#191'Desea salir sin grabar?'#39')) then exi' +
            't;'
          '  close();'
          'end.')
      end>
  end
  inherited ImprimirObjetoSeleccionado: TdxComponentPrinter
    inherited ImprimirObjetoSeleccionadodxComponentPrinterLink: TdxGridReportLink
      BuiltInReportLink = True
    end
  end
  object HelpCompetencias: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'rs.RecluCompetencias'
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
    Left = 49
    Top = 77
  end
  object TRecluCompetencias: TsnTable
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
    Left = 83
    Top = 77
    object IntegerField11: TIntegerField
      FieldName = 'oid'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object StringField23: TStringField
      FieldName = 'codigo'
      Size = 50
    end
    object StringField24: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
  end
  object DSRecluCompetencias: TDataSource
    DataSet = TRecluCompetencias
    Left = 117
    Top = 77
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
    Left = 64
    Top = 112
    object TInputoid_competencia: TIntegerField
      FieldName = 'oid_competencia'
    end
  end
  object DSInput: TDataSource
    DataSet = TInput
    Left = 104
    Top = 112
  end
  object TPuestoBusqueda: TsnTable
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
    Left = 328
    Top = 121
    object TPuestoBusquedaoid_puesto: TIntegerField
      FieldName = 'oid_puesto'
    end
    object TPuestoBusquedadescripcion: TStringField
      FieldName = 'descripcion'
      Size = 255
    end
  end
  object DSPuestoBusqueda: TDataSource
    DataSet = TPuestoBusqueda
    Left = 368
    Top = 121
  end
end
