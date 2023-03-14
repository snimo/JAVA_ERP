inherited FDefProcesoEnBusq: TFDefProcesoEnBusq
  Left = 68
  Top = 222
  Width = 970
  Height = 471
  BorderIcons = []
  Caption = 'Definici'#243'n de Procesos'
  DragKind = dkDrag
  DragMode = dmManual
  Font.Height = -13
  Position = poScreenCenter
  PixelsPerInch = 96
  TextHeight = 16
  object Panel1: TPanel [0]
    Left = 0
    Top = 0
    Width = 954
    Height = 41
    Align = alTop
    Color = clWindow
    TabOrder = 0
    object Label1: TLabel
      Left = 13
      Top = 8
      Width = 367
      Height = 23
      Caption = 'Definici'#243'n procesos para b'#250'squeda de'
      Font.Charset = ANSI_CHARSET
      Font.Color = 16742263
      Font.Height = -19
      Font.Name = 'Verdana'
      Font.Style = []
      ParentFont = False
    end
    object snDBEdit1: TsnDBEdit
      Left = 392
      Top = 4
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
      Width = 545
    end
  end
  object Panel2: TPanel [1]
    Left = 0
    Top = 41
    Width = 954
    Height = 335
    Align = alClient
    Color = clWindow
    TabOrder = 1
    object dxDBGridSN1: TdxDBGridSN
      Left = 1
      Top = 1
      Width = 952
      Height = 333
      Align = alClient
      TabOrder = 0
      CriteriosPintarCelda = <>
      object cxGridDBTableView1: TcxGridDBTableView
        NavigatorButtons.ConfirmDelete = False
        NavigatorButtons.First.Visible = False
        NavigatorButtons.PriorPage.Visible = False
        NavigatorButtons.Prior.Visible = False
        NavigatorButtons.Next.Visible = False
        NavigatorButtons.NextPage.Visible = False
        NavigatorButtons.Last.Visible = False
        NavigatorButtons.Insert.Visible = False
        NavigatorButtons.Append.Visible = True
        NavigatorButtons.Delete.Visible = False
        NavigatorButtons.Edit.Visible = False
        NavigatorButtons.Post.Visible = False
        NavigatorButtons.Cancel.Visible = False
        NavigatorButtons.Refresh.Visible = False
        NavigatorButtons.SaveBookmark.Visible = False
        NavigatorButtons.GotoBookmark.Visible = False
        NavigatorButtons.Filter.Visible = False
        DataController.DataSource = DSTProcesoDefBusq
        DataController.Options = [dcoAssignGroupingValues, dcoAssignMasterDetailKeys, dcoSaveExpanding, dcoGroupsAlwaysExpanded]
        DataController.Summary.DefaultGroupSummaryItems = <>
        DataController.Summary.FooterSummaryItems = <>
        DataController.Summary.SummaryGroups = <>
        OptionsBehavior.FocusCellOnTab = True
        OptionsBehavior.FocusFirstCellOnNewRecord = True
        OptionsBehavior.GoToNextCellOnEnter = True
        OptionsBehavior.FocusCellOnCycle = True
        OptionsData.Appending = True
        OptionsData.Deleting = False
        OptionsSelection.InvertSelect = False
        OptionsView.Navigator = True
        OptionsView.CellAutoHeight = True
        OptionsView.GroupByBox = False
        object cxGridDBTableView1orden: TcxGridDBColumn
          DataBinding.FieldName = 'orden'
          SortIndex = 0
          SortOrder = soAscending
          Width = 54
        end
        object cxGridDBTableView1oid_proceso: TcxGridDBColumn
          Caption = 'Proceso'
          DataBinding.FieldName = 'oid_proceso'
          PropertiesClassName = 'TcxLookupComboBoxProperties'
          Properties.KeyFieldNames = 'oid'
          Properties.ListColumns = <
            item
              FieldName = 'descripcion'
            end>
          Properties.ListOptions.ShowHeader = False
          Properties.ListSource = DSRecluProceso
          HeaderAlignmentHorz = taCenter
          Width = 312
        end
        object cxGridDBTableView1oid_conc_proceso: TcxGridDBColumn
          Caption = 'Tipo de Ex'#225'men'
          DataBinding.FieldName = 'examen'
          PropertiesClassName = 'TcxButtonEditProperties'
          Properties.Buttons = <
            item
              Default = True
              Kind = bkEllipsis
            end>
          Properties.ReadOnly = True
          HeaderAlignmentHorz = taCenter
          Width = 263
        end
        object cxGridDBTableView1fecha_asigno: TcxGridDBColumn
          Caption = 'Fecha Asigno'
          DataBinding.FieldName = 'fecha_asigno'
          PropertiesClassName = 'TcxDateEditProperties'
          Visible = False
          HeaderAlignmentHorz = taCenter
          Width = 105
        end
        object cxGridDBTableView1Column1: TcxGridDBColumn
          Caption = 'Tipo Formulario'
          DataBinding.FieldName = 'oid_tipo_formu'
          PropertiesClassName = 'TcxLookupComboBoxProperties'
          Properties.KeyFieldNames = 'oid'
          Properties.ListColumns = <
            item
              FieldName = 'descripcion'
            end>
          Properties.ListOptions.ShowHeader = False
          Properties.ListSource = DSTipoFormulario
          HeaderAlignmentHorz = taCenter
          Width = 218
        end
        object cxGridDBTableView1activo: TcxGridDBColumn
          Caption = 'Activo'
          DataBinding.FieldName = 'activo'
          HeaderAlignmentHorz = taCenter
          Width = 47
        end
      end
      object cxGridLevel1: TcxGridLevel
        GridView = cxGridDBTableView1
      end
    end
  end
  object Panel3: TPanel [2]
    Left = 0
    Top = 376
    Width = 954
    Height = 57
    Align = alBottom
    Color = clWindow
    TabOrder = 2
    object BotonGrabar: TsnButton
      Left = 600
      Top = 7
      Width = 113
      Height = 45
      Caption = 'Grabar'
      TabOrder = 0
      Glyph.Data = {
        42080000424D4208000000000000420000002800000020000000200000000100
        10000300000000080000202E0000202E00000000000000000000007C0000E003
        00001F000000FF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7F
        FF7FFF7FFF7FFF7F9C73B94E123A514A375F58637863BB6FFF7FFF7FFF7FFF7F
        FF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7F
        BF733D677A73FA523626ED09A401A001C009C009A005A209271A134FFF7FFF7F
        FF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7F7E6B
        6D5AC545162A5822A605C0056222C32AE0260027012BA32A000E60016B2EFD7B
        FF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FDF73945AE461
        607F667B3536A2050112083F4643243BC5328632C536453F4947093F8001E411
        FE7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7F5C674E5A206E407F
        E17F697FC619E0054B4F4A4B0433E3323A673E73B352C32E073B4C530C478001
        8B32FF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7F9F6F945AE361C07AE27FC27F
        A07FE04EA1012E4B2D4BE93E0537C42EBC77FF7F365FA432073BE9426F570C47
        60013453FF7FFF7FFF7FFF7FFF7FFF7FFF7FDF7B4C5E006E607FE07FC07B607F
        A07F201A4922915B2A4729432537E4369B73FF7FF55AC432283F29474C4B715B
        E111471EFF7FFF7FFF7FFF7FFF7FFF7FDF774F73807FE27FE17F294B5126D046
        E752A0050D434F53AA3EA936863266329B73FF7FF55A462EA836893AAB3E6F57
        A936A105BB6FFF7FFF7FFF7F1A5BB4313419EA2D616BE07F6963BB3EBA521E67
        9436C1052C4B2F4F3A67196318631967DE7BFF7F9C731963186319679556ED46
        2C4780011453FF7FFF7FF95AF000350131001300500489140F15F441F65E386F
        8E42C1050A430E4FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7F5C6FAB42
        4C4BA001D042FF7FDE7371119605D8157204BB21BF325C15B70472042F009110
        4A11000E0A470D4B5763796B78677867DE7BFF7FDD77796B786B796B3663EC4A
        2B47A001F24AFF7FF94A5009D90DB615D40892085A327F4FBF577F539D3A9C25
        140DA00109432C4FE83EEA3EEA42AB42BC73FF7FF65EAC42EC46EB42EA424E53
        A832A005BA6FFF7BD846510DFA09D719361111001100D510D92DBD4ABF67FF77
        FF73261A44224D530B474D4B2F4FF04EBD77FF7FF65EF04E51532E4F4C4B6E53
        0216051AFF7FFF7FD83E3101F915D719361174009500350014001500D810BB29
        DF5AF54AE005EA3E6D532E4B3153F256BD7BFF7F1863D14E31572F4F70570B47
        60011353FF7FFF7FF95232011916F719361175009600B700B800980078005800
        5B00FF0CA60920164D53705B325714575A6B9C733863F256325772574D4FC00D
        2822FF7FFF7FFF7FB7525301F915F7199615B7049700B800B900DA00DB00FB00
        FB00BE00FC04A60520120A47725F56633763165F365F7563725B2C4B8001C30D
        DE7BFF7FFF7FFF7F96465301F915B619F8193A0D7800DA00DB00DB00FC00FC00
        1D013D01FF003C058601E009642AEA422E4F2F532E4F0A43431E8001271EBA6B
        FF7FFF7FFF7FFF7F553A5401F915B615F7199C117A00FB00FC001D011D013E01
        3E013F013F015F019F09D50DC705C005C009E009A00180014822134FFF7FFF7F
        FF7FFF7FFF7FFF7F142E7501F919F8199515BC15BC00FC001D011E013E013F01
        3F013F017F05DF0D1F165F1E9F269822531A72221347F51D1C63FF7FFF7FFF7F
        FF7FFF7FFF7FFE7FD3219601F715381A7311D619FF15DE00FF00FF001F013F01
        7F05DF0D1F165F1E9F26BF2ABF2EDF32DF32BF32DF6FBF3A393EFF7FFF7FFF7F
        FF7FFF7FFF7FDD7BB3199705F819F819F9157411181A1B16FE11DF0DFF0D1F12
        FF153F1E9F26BF2ABF2EBF2EBF2EBF2E9F2E7F26DF3E9E36D829FE7FFF7FFF7F
        FF7FFF7FFF7F9C6F76199E21FE2DDE29FF2DFE2979219821D825D71DD6157A1E
        FF2ABF2ABF2EBF2EBF2EBF2E9F2E7F2A7F2A5F263F265F2E37111A63FF7FFF7F
        FF7FFF7FFF7F5A635715FF2D1F361F321F321F321F36FF31FE31FD3178251415
        9A221F33BF2EBF2E9F2E9F2A7F2A5F2A5F261F26FF25FF251809774AFF7FFF7F
        FF7FFF7FFF7F543E57155F365F363F363F363F363F363F363F365F367F3E3F3E
        3415BB26DF327F2A7F2A5F2A3F261F26FF21DF21BF1D9F1D1D09383EFF7FFF7F
        FF7FFF7FFF7F764296199F3E7F3A7F3A7F3A7F3A7F3A7F3A7F3A7F3A5F3ABF42
        FB317515FF2A7F2A1F26FF25DF21DF21BF1DBF1D9F197F19FE08B825FE7FFF7F
        FF7FFF7FFF7F3A63B51DBF3ABF42BF3EBF3EBF3EBF3EBF3EBF3EBF3EBF3EBF3E
        FF46F931B5119C227E265F26FF21BF197F1D5F193F151F15DF0CD8087B6FFF7F
        FF7FFF7FFF7FBD73D425BF36DF42DF3EDF3EDF3EDF3EDF3EDF3EDF3EDF3EDF3E
        DF3EFF46192EB721F721F71DF81D1A1E1C1EBD11BF119F195F0DD6007B6BFF7F
        FF7FFF7FFF7FFF7F543AB619DF3EDF3EFF42FF42FF42DF3EDF3EDF3EDF3ADF3A
        BF3ABF3AFF46DF429E3E7C3A7B3A3B2AD621563AF725B61575119846FF7FFF7F
        FF7FFF7FFF7FFF7F7C6FF32DB61DFA211B1E1C223D265F2EBF36BF3A9F3A9E3A
        9E3EBE3A9E3A9E3ABF3ABF3EDF3E5F267B36FE7F9C77F9623A6BFF7FFF7FFF7F
        FF7FFF7FFF7FFF7FFF7FFF7F5B6B3A5FB84A573AD525B61D7611770D99119B15
        DC1DFC211C263C2A3D2E3D2E1D267B09DB46FF7FFF7FFF7FFF7FFF7FFF7FFF7F
        FF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FDE7FBC77F95A974A573AF729
        B71557091701180118055A0D1A09B7005C5BFF7FFF7FFF7FFF7FFF7FFF7FFF7F
        FF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7F
        DE7B9D6F5C63FB52793AB81D37055A3AFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7F
        FF7FFF7FFF7F}
      LookAndFeel.Kind = lfOffice11
    end
    object BotonCancelar: TsnButton
      Left = 760
      Top = 7
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
  inherited DriverABM: TDriverABM
    CargaDataSets = <
      item
        DataSet = TProcesoDefBusq
        TableName = 'TProcesoDefBusq'
      end
      item
        DataSet = TConceProceso
        TableName = 'TConceProceso'
      end
      item
        DataSet = TPuestoBusqueda
        TableName = 'TPuestoBusqueda'
      end>
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
      '   '
      '   operacion.InicioOperacion();'
      '   operacion.setOper('#39'TraerRecluPuestoBusqueda'#39');'
      
        '   operacion.AddAtribute('#39'oid_busqueda_act'#39',IntToStr(getVariable' +
        '.getValue('#39'oid_busqueda'#39')));'
      '   operacion.execute();'
      ''
      
        '   TraerDefinicionProcesos(IntToStr(getVariable.getValue('#39'oid_bu' +
        'squeda'#39')));'
      ''
      '   dxDBGridSN1.setFoco();'
      ''
      'end.')
    OnChangeField = <
      item
        TableName = 'TProcesoDefBusq'
        FieldName = 'oid_proceso'
        Source.Strings = (
          'begin'
          '  TProcesoDefBusq.FieldName('#39'oid_conc_proceso'#39').Clear;'
          '  TConceProceso.Close;'
          '  TConceProceso.Open;'
          '  if (Sender.AsInteger>0)'
          '     then TraerConceptosProceso(IntToStr(Sender.AsInteger));'
          'end.')
      end>
    OnBeforePost = <
      item
        TableName = 'TProcesoDefBusq'
        Source.Strings = (
          'begin'
          '  if (DataSet.FieldName('#39'orden'#39').AsInteger<=0)'
          
            '     then raiseException(erCustomError,'#39'Debe ingresar el Orden'#39')' +
            ';'
          '  if (DataSet.FieldName('#39'oid_conc_proceso'#39').AsInteger<=0)'
          
            '     then raiseException(erCustomError,'#39'Debe ingresar el Concept' +
            'o'#39');'
          'end.')
      end>
    OnNuevoRegistro = <
      item
        TableName = 'TProcesoDefBusq'
        Source.Strings = (
          'begin'
          '  DataSet.FieldName('#39'activo'#39').Value := true;'
          
            '  DataSet.FieldName('#39'oid_busqueda_act'#39').AsInteger := getVariable' +
            '.getValue('#39'oid_busqueda'#39');'
          'end.')
      end>
    OnPublicVariable = <
      item
        VariableName = 'oid_busqueda'
      end>
    OnInicializar = <
      item
        Source.Strings = (
          'begin'
          '  TRecluProceso.loadFromHelp('#39'HelpProceso'#39');'
          '  TTipoFormulario.loadFromHelp('#39'HelpTipoFormulario'#39');'
          'end.')
      end>
    OnFormFunction = <
      item
        Source.Strings = (
          'procedure TraerDefinicionProcesos(OidProceso : string);'
          'begin'
          '  operacion.InicioOperacion();'
          '  operacion.setOper('#39'TraerRecluProcDefBusq'#39');'
          ' operacion.AddAtribute('#39'oid_busqueda'#39',OidProceso);'
          ' operacion.execute(); '
          'end;'
          ''
          ''
          'procedure TraerConceptosProceso(OidProceso : string);'
          'begin'
          '  operacion.InicioOperacion();'
          '  operacion.setOper('#39'TraerRecluConcProceso'#39');'
          ' operacion.AddAtribute('#39'oid_proceso'#39',OidProceso);'
          ' operacion.execute(); '
          'end;'
          ''
          'procedure grabarDefinicionProcesos();'
          'begin'
          '  TProcesoDefBusq.PostRecord;'
          '  operacion.InicioOperacion();'
          '  operacion.setOper('#39'SaveRecluDefProcBusqueda'#39');'
          '  operacion.AddDataSet(TProcesoDefBusq.getDataSet());'
          '  operacion.execute(); '
          'end;'
          ''
          ''
          'procedure mostrarHelpTipoExamen();'
          'begin'
          '  if (TProcesoDefBusq.FieldName('#39'oid_proceso'#39').AsInteger = 0)'
          
            '      then raiseException(erCustomError,'#39'Debe ingresar el proces' +
            'o'#39');'
          '  HelpTipoExamenes.clearAtributos;'
          
            '  HelpTipoExamenes.addAtributo('#39'oid_proceso'#39',TProcesoDefBusq.Fie' +
            'ldName('#39'oid_proceso'#39').AsString);'
          '  HelpTipoExamenes.Mostrar();'
          'end;')
      end>
    OnClickToolButton = <
      item
        ButtonName = 'BotonCancelar'
        Source.Strings = (
          'begin'
          
            '  if (mensaje.question('#39#191'Esta seguro que desea salir sin grabar ' +
            'los cambios?'#39'))'
          '     then close();'
          'end.')
      end
      item
        ButtonName = 'BotonGrabar'
        Source.Strings = (
          'begin'
          '   grabarDefinicionProcesos();'
          '   close;'
          ''
          'end.')
      end>
    OnClickButtonColumn = <
      item
        ColumnName = 'cxGridDBTableView1oid_conc_proceso'
        Source.Strings = (
          'begin'
          '  mostrarHelpTipoExamen();'
          'end.')
      end>
  end
  inherited ImprimirObjetoSeleccionado: TdxComponentPrinter
    inherited ImprimirObjetoSeleccionadodxComponentPrinterLink: TdxGridReportLink
      BuiltInReportLink = True
    end
  end
  object TProcesoDefBusq: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <>
    IndexFieldNames = 'oid_proc_def_busq'
    IndexDefs = <
      item
        Name = 'TProcesoDefBusqIndex1'
        Fields = 'oid_proc_def_busq'
      end>
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
    Left = 160
    Top = 185
    object TProcesoDefBusqoid_proc_def_busq: TIntegerField
      FieldName = 'oid_proc_def_busq'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TProcesoDefBusqoid_busqueda_act: TIntegerField
      FieldName = 'oid_busqueda_act'
    end
    object TProcesoDefBusqorden: TIntegerField
      FieldName = 'orden'
    end
    object TProcesoDefBusqoid_proceso: TIntegerField
      FieldName = 'oid_proceso'
    end
    object TProcesoDefBusqfecha_asigno: TDateField
      FieldName = 'fecha_asigno'
    end
    object TProcesoDefBusqoid_conc_proceso: TIntegerField
      FieldName = 'oid_conc_proceso'
    end
    object TProcesoDefBusqactivo: TBooleanField
      FieldName = 'activo'
    end
    object TProcesoDefBusqexamen: TStringField
      FieldName = 'examen'
      Size = 100
    end
    object TProcesoDefBusqoid_tipo_formu: TIntegerField
      FieldName = 'oid_tipo_formu'
    end
  end
  object DSTProcesoDefBusq: TDataSource
    DataSet = TProcesoDefBusq
    Left = 192
    Top = 185
  end
  object HelpProceso: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'rs.RecluProceso'
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
    Left = 497
    Top = 89
  end
  object TRecluProceso: TsnTable
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
    Left = 531
    Top = 89
    object IntegerField6: TIntegerField
      FieldName = 'oid'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object StringField11: TStringField
      FieldName = 'codigo'
      Size = 50
    end
    object StringField12: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
  end
  object DSRecluProceso: TDataSource
    DataSet = TRecluProceso
    Left = 565
    Top = 89
  end
  object TConceProceso: TsnTable
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
    Top = 297
    object TConceProcesooid: TIntegerField
      FieldName = 'oid'
    end
    object TConceProcesodescripcion: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
  end
  object DSConceptoProceso: TDataSource
    DataSet = TConceProceso
    Left = 568
    Top = 297
  end
  object HelpTipoExamenes: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'rs.RecluConceptoProceso'
    NroHelp = 101
    Campos = <
      item
        Titulo = 'oid'
        FieldName = 'oid'
        Tipo = ftInteger
        Longitud = 0
        Visible = False
        AsignarACampo = TProcesoDefBusqoid_conc_proceso
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
        AsignarACampo = TProcesoDefBusqexamen
        KeyField = False
        AnchoEnCaracteres = 30
        ActivarFiltro = True
        Sorted = scUp
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
    Titulo = 'Tipos de Ex'#225'menes'
    AnchoHelp = 600
    ActivarCache = False
    ShowBotonBuscar = False
    Left = 497
    Top = 138
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
    Left = 800
    Top = 137
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
    Left = 840
    Top = 137
  end
  object HelpTipoFormulario: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'rs.RecluTipoFormuProceso'
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
    Left = 199
    Top = 276
  end
  object TTipoFormulario: TsnTable
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
    Left = 233
    Top = 276
    object IntegerField43: TIntegerField
      FieldName = 'oid'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object StringField44: TStringField
      FieldName = 'codigo'
      Size = 50
    end
    object StringField45: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
  end
  object DSTipoFormulario: TDataSource
    DataSet = TTipoFormulario
    Left = 267
    Top = 276
  end
end
