inherited FRecluAgregarCand: TFRecluAgregarCand
  Left = 54
  Top = 138
  Width = 977
  Height = 469
  BorderIcons = []
  Caption = 'Alta / Modificaci'#243'n de Candidatos'
  DragKind = dkDrag
  DragMode = dmManual
  Position = poScreenCenter
  PixelsPerInch = 96
  TextHeight = 13
  object Panel1: TPanel [0]
    Left = 0
    Top = 0
    Width = 961
    Height = 92
    Align = alTop
    BevelOuter = bvNone
    Color = clWindow
    TabOrder = 0
    object Label1: TLabel
      Left = 44
      Top = 22
      Width = 402
      Height = 18
      Caption = 'Alta  / Modificaci'#243'n de Candidatos de la posici'#243'n'
      Font.Charset = ANSI_CHARSET
      Font.Color = clWindowText
      Font.Height = -16
      Font.Name = 'Verdana'
      Font.Style = []
      ParentFont = False
    end
    object snDBEdit2: TsnDBEdit
      Left = 40
      Top = 52
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
      Width = 841
    end
  end
  object Panel3: TPanel [1]
    Left = 0
    Top = 373
    Width = 961
    Height = 58
    Align = alBottom
    BevelOuter = bvNone
    Color = clWindow
    TabOrder = 1
    object BotonGrabar: TsnButton
      Left = 616
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
        FF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7F
        FF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7F
        FF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7F
        FF7FFF7FFF7FFF7FFF7F9B73CD39AC39EE3DEE3DEE3DEE3DEE3DEE3DEE3DEE3D
        EE3DEE3DEE3DEE3DEE3DEE3DEE3DEE3DEE3DEE3DEE3DEE3DEE3DEE3DEE3DED3D
        AC359452FF7FFF7FFF7FF239C9142C212B212B212C212B212B212B212B212C21
        2B212B212B212B212B212B212B212B212B212B212B212B212B212B212B212C21
        091D8410F75EFF7FB8523636DB4ADB4ADA4ADA4ADB4AFC4EFD52FC52DB4ADA4A
        DA4ADA4ADA4ADA4ADA4ADA4ADA4ADA4ADA4ADA4ADA4ADA4ADA4ADA4ADA4ADB4A
        9A460A1D524EBE77774A5A5B7B635A5F5A5F7D677D673A5B165317575D637E67
        7B5F5A5F5A5F5A5F5A5F5A5F5A5F5A5F5A5F5A5F5A5F5A5F5A5F5A5F5A5F7B63
        1B4F6E257352BE7BD8565A5B3A5B3B5F7E6718578E366B2A4722471E6922B342
        5D633B5B3A5B3A5B3A5B3A5B3A5B3A5B3A5B3A5B3A5B3A5B3A5B3A5B3A5B5B5F
        1B534D257352BE77D8525A5B7D637D63B3426B2A8A2A8B2AAA26851A881E2312
        D4467F673B5B7C5F9E639D639D639D639D639D639D639D639D639D639D637C63
        FB524D257352BE77D9527B5F7D67B2428B2AEF3AF03ACF3A881E0E371A63420E
        AA267E677C63195BD852F852F852F852F852F852F852F852F852F852F8567B63
        1B534D257352BE77B8567D6BF54AAD2A944375433243EE365247FF7B175FA106
        A30E1857DF6FEF39E71C4A292A292A292A292A292A292A292A2909250925195B
        5D5B4D217352BE77D8569E6F164B4A420A4E8E4E754BB957BE7BFF7FF346051B
        C51E3953BF6FB54A113E52465242524252425242524252425242324232425B63
        5D574D217352BE77D856DF6BF55E20458038A03C8F5A7973D26AD5622C4EA451
        844DD35A9E67DF6FFF77FF77FF77FF77FF77FF77FF77FF77FF77FF77FF77BE6F
        1C534D257352BD77D956DF6B4D5A20412041A038A555507F927F1173A4512049
        E044A651BE6B3A5BB752D756D756D756D756D756D756D756D756D756D7569C6B
        5D5B4D257352BD77D956DF6B2A5A604D814D0041E7510F6FEE72AF620856E255
        40494C5AFF77103AA61829250925092509250925092509250925E82008253A5F
        9F632D217352BD77D956FF6FD262C259A15141456C666F7B0C7BCD6E4C5E275A
        C2551663FF73D6523142734A5346534653465346534653465346534652467C6B
        7E634D257352BD77D856DF6F5A67275EC059295A717F4E7F2D7F2D7FEC7A285E
        4C5EBE6F9E6FFF77FF7FFF7BFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF77
        5C5B4E257352BD77D856DF6F5A6B6962055AAE6A927F4E7F2E7B0D7B0C7F686A
        B15EFF73DE733963F756185B185B185B185B185B185B185B185BF856F75ADD6F
        9F5F4E217352BD77D856FF737A676B664A5EAF6A727F4F7F4E7F2D7B0D7B886A
        905EFF6FFF77103EA518292508250825082508250825082508250821E8205A63
        BF6B4E21734EBD77D856FF737B6B8D62A86E4862737B717F4E7F2D7B0D7B896A
        6E5ADF73DF77D7563146734A734A734A734A734A734A734A734A524653469D6F
        9F674E25734EBD77D856FF737C6B8D66EB764566CF6AB57F6F7F4D7F2E7F4866
        8D62FF77DE73FF7FFF7FFF7FFF7FFF7FFF7FFF77FF7BFF7BFF7BFF7BFF7BFF7B
        7D634E25734EBD77D856FF73BD6F8E662E77C672255ED06A71774F7BAD6E035E
        CF66FF73FF735A63F75A185F185FF75A5A63FF77DE73DE73DE73DE73DE73FF7B
        9D674E21734EBD77D956DE77FF7BF466EC726E7FC4724266475E4A5E626A2162
        7B6FFF7BFF7F103EA51429252921A614F03DFF7FFE77DE77DE77DE77DE77FF7B
        9E674E21734EBD73D85ADE77FF7BBD776E5ECB6E0977C17A406A24624066D266
        FF7BDF7BFF7B185F9452B656B5569452185FFF7BDF77DF77DF77DF77DF77FF7F
        9F634E21734EBD73D856DE77DF77FF7B9D73F566D26ACF6A8E62AF66586FFF7B
        DF77DF77DF77FF7BFF7FFF7FFF7FFF7FFF7BDF77DF77DF77DF77DF77DF77FF7F
        9F674D21524ABD73B856DE77FF7BDF77FF7BFF7FFF7BDF77DF77FF77FF7FFF7B
        DF77DF77DF77DF77DF77DF77DF77DF77DF77DF77DF77DF77DF77DF77DF77FF7F
        BF6B2C1D7352BD77D95AFF7BFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7F
        FF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7F
        5C63133ABD7BDF7B7C6B9D6FBD77BD73BD73BD73BD73BD73BD73BD73BD73BD73
        BD73BD73BD73BD73BD73BD73BD73BD73BD73BD73BD73BD73BD73BD73BD739D73
        B8523B63FF7FFF7FFF7F9D737D6F7C737C737C737C737C737C737C737C737C73
        7C737C737C737C737C737C737C737C737C737C737C737C737C737C739C737C6F
        7C6FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7F
        FF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7F
        FF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7F
        FF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7F
        FF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7F
        FF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7F
        FF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7F
        FF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7F
        FF7FFF7FFF7F}
      LookAndFeel.Kind = lfOffice11
    end
    object BotonCancelar: TsnButton
      Left = 752
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
  object Panel2: TPanel [2]
    Left = 0
    Top = 92
    Width = 961
    Height = 281
    Align = alClient
    BevelOuter = bvNone
    Color = clWindow
    TabOrder = 2
    object Label9: TLabel
      Left = 48
      Top = 40
      Width = 119
      Height = 16
      Caption = 'Nro de Documento: '
      Font.Charset = DEFAULT_CHARSET
      Font.Color = clWindowText
      Font.Height = -13
      Font.Name = 'MS Sans Serif'
      Font.Style = []
      ParentFont = False
    end
    object Label2: TLabel
      Left = 48
      Top = 80
      Width = 115
      Height = 16
      Caption = 'Apellido y Nombre:'
      Font.Charset = DEFAULT_CHARSET
      Font.Color = clWindowText
      Font.Height = -13
      Font.Name = 'MS Sans Serif'
      Font.Style = []
      ParentFont = False
    end
    object Label3: TLabel
      Left = 48
      Top = 120
      Width = 133
      Height = 16
      Caption = 'Estado del Candidato:'
      Font.Charset = DEFAULT_CHARSET
      Font.Color = clWindowText
      Font.Height = -13
      Font.Name = 'MS Sans Serif'
      Font.Style = []
      ParentFont = False
    end
    object Label7: TLabel
      Left = 48
      Top = 205
      Width = 72
      Height = 16
      Caption = 'Comentario:'
      Font.Charset = DEFAULT_CHARSET
      Font.Color = clWindowText
      Font.Height = -13
      Font.Name = 'MS Sans Serif'
      Font.Style = []
      ParentFont = False
    end
    object Label4: TLabel
      Left = 48
      Top = 160
      Width = 43
      Height = 16
      Caption = 'Motivo:'
      Font.Charset = DEFAULT_CHARSET
      Font.Color = clWindowText
      Font.Height = -13
      Font.Name = 'MS Sans Serif'
      Font.Style = []
      ParentFont = False
    end
    object Label5: TLabel
      Left = 600
      Top = 120
      Width = 72
      Height = 16
      Caption = 'Fec. Estado'
      Font.Charset = DEFAULT_CHARSET
      Font.Color = clWindowText
      Font.Height = -13
      Font.Name = 'MS Sans Serif'
      Font.Style = []
      ParentFont = False
    end
    object srnDBButtonEdit1: TsrnDBButtonEdit
      Left = 192
      Top = 36
      DataBinding.DataField = 'nro_docu'
      DataBinding.DataSource = DSCandidato
      ParentFont = False
      Properties.Buttons = <
        item
          Default = True
          Kind = bkEllipsis
        end>
      Style.Font.Charset = DEFAULT_CHARSET
      Style.Font.Color = clWindowText
      Style.Font.Height = -13
      Style.Font.Name = 'MS Sans Serif'
      Style.Font.Style = []
      Style.IsFontAssigned = True
      TabOrder = 0
      Help = HelpPostulantes
      Width = 153
    end
    object snDBEdit1: TsnDBEdit
      Left = 192
      Top = 76
      TabStop = False
      DataBinding.DataField = 'ape_y_nom'
      DataBinding.DataSource = DSCandidato
      ParentFont = False
      Properties.ReadOnly = True
      Style.Font.Charset = DEFAULT_CHARSET
      Style.Font.Color = clWindowText
      Style.Font.Height = -13
      Style.Font.Name = 'MS Sans Serif'
      Style.Font.Style = []
      Style.IsFontAssigned = True
      TabOrder = 1
      Width = 689
    end
    object snDBLookup5: TsnDBLookup
      Left = 192
      Top = 116
      DataBinding.DataField = 'oid_est_cand_busq'
      DataBinding.DataSource = DSCandidato
      ParentFont = False
      Properties.KeyFieldNames = 'oid'
      Properties.ListColumns = <
        item
          FieldName = 'descripcion'
        end>
      Properties.ListOptions.ShowHeader = False
      Properties.ListSource = DSTRecluEstCandBusq
      Style.Font.Charset = DEFAULT_CHARSET
      Style.Font.Color = clWindowText
      Style.Font.Height = -13
      Style.Font.Name = 'MS Sans Serif'
      Style.Font.Style = []
      Style.IsFontAssigned = True
      TabOrder = 2
      Width = 353
    end
    object snDBMemo1: TsnDBMemo
      Left = 192
      Top = 200
      DataBinding.DataField = 'comentario'
      DataBinding.DataSource = DSCandidato
      ParentFont = False
      Style.Font.Charset = DEFAULT_CHARSET
      Style.Font.Color = clWindowText
      Style.Font.Height = -13
      Style.Font.Name = 'MS Sans Serif'
      Style.Font.Style = []
      Style.IsFontAssigned = True
      TabOrder = 5
      ReadOnlyAlways = False
      Height = 65
      Width = 689
    end
    object snDBLookup1: TsnDBLookup
      Left = 192
      Top = 156
      DataBinding.DataField = 'oid_mot_est_cand'
      DataBinding.DataSource = DSCandidato
      ParentFont = False
      Properties.KeyFieldNames = 'oid'
      Properties.ListColumns = <
        item
          FieldName = 'descripcion'
        end>
      Properties.ListOptions.ShowHeader = False
      Properties.ListSource = DStMotiEstCandBusq
      Style.Font.Charset = DEFAULT_CHARSET
      Style.Font.Color = clWindowText
      Style.Font.Height = -13
      Style.Font.Name = 'MS Sans Serif'
      Style.Font.Style = []
      Style.IsFontAssigned = True
      TabOrder = 4
      Width = 353
    end
    object snDBDateEdit1: TsnDBDateEdit
      Left = 696
      Top = 116
      DataBinding.DataField = 'fec_ingreso'
      DataBinding.DataSource = DSCandidato
      ParentFont = False
      Style.Font.Charset = DEFAULT_CHARSET
      Style.Font.Color = clWindowText
      Style.Font.Height = -13
      Style.Font.Name = 'MS Sans Serif'
      Style.Font.Style = []
      Style.IsFontAssigned = True
      TabOrder = 3
      ReadOnlyAlways = False
      Width = 121
    end
  end
  inherited DriverABM: TDriverABM
    CargaDataSets = <
      item
        DataSet = TCandidato
        TableName = 'TCandidato'
      end
      item
        DataSet = TPuestoBusqueda
        TableName = 'TPuestoBusqueda'
      end
      item
        DataSet = TAdvertencia
        TableName = 'TAdvertencia'
      end
      item
        DataSet = TConsCerrarBusq
        TableName = 'TConsCerrarBusq'
      end>
    Left = 184
    Top = 288
  end
  inherited Operacion: TOperacion
    Left = 224
    Top = 288
  end
  inherited dxComponentPrinter: TdxComponentPrinter
    Left = 264
    Top = 288
    inherited dxComponentPrinterLink1: TdxCustomContainerReportLink
      Component = Owner
      BuiltInReportLink = True
      HiddenComponents = {}
      ExcludedComponents = {}
      AggregatedReportLinks = {}
    end
  end
  inherited SaveDialog: TSaveDialog
    Left = 304
    Top = 288
  end
  inherited DriverEvent: TDriverEvent
    OnShow.Strings = (
      'begin'
      ''
      '   operacion.InicioOperacion();'
      '   operacion.setOper('#39'TraerRecluPuestoBusqueda'#39');'
      
        '   operacion.AddAtribute('#39'oid_busqueda_act'#39',IntToStr(getVariable' +
        '.getValue('#39'oid_busqueda'#39')));'
      '   operacion.execute();'
      ''
      ''
      '    srnDBButtonEdit1.setFoco();'
      ''
      '    if (getVariable().getInteger('#39'oid_candidato_busq'#39')=-1)'
      '       then begin'
      '               TCandidato.close;'
      '               TCandidato.Open;'
      '               TCandidato.AppendRecord;   '
      '               end'
      '        else begin'
      '                operacion.InicioOperacion();'
      '                operacion.setOper('#39'TraerRecluCandidatoBusq'#39');'
      
        '                operacion.AddAtribute('#39'oid_candidato_busq'#39',IntTo' +
        'Str(getVariable().getInteger('#39'oid_candidato_busq'#39')));'
      '                operacion.execute();'
      '                end; '
      ' '
      ''
      ''
      'end.')
    OnValidate = <
      item
        TableName = 'TCandidato'
        FieldName = 'nro_docu'
        Source.Strings = (
          'begin'
          '  ValidarPostulante.Value := Sender.AsString;'
          '  ValidarPostulante.Validar();'
          'end.')
      end>
    OnBeforePost = <
      item
        TableName = 'TCandidato'
        Source.Strings = (
          'begin'
          ''
          '  if (Trim(DataSet.FieldName('#39'nro_docu'#39').AsString)='#39#39')'
          
            '     then raiseException(erCustomError,'#39'Debe ingresar el Nro. de' +
            ' Documento'#39');'
          ''
          '  if (Trim(DataSet.FieldName('#39'ape_y_nom'#39').AsString)='#39#39')'
          
            '     then raiseException(erCustomError,'#39'Debe ingresar el Apellid' +
            'o y Nombre'#39');'
          ''
          '  if (DataSet.FieldName('#39'oid_est_cand_busq'#39').AsInteger = 0)'
          
            '      then raiseException(erCustomError,'#39'Debe ingresar el Estado' +
            #39');'
          ''
          'end.')
      end>
    OnNuevoRegistro = <
      item
        TableName = 'TCandidato'
        Source.Strings = (
          'begin'
          '  DataSet.FieldName('#39'activo'#39').Value := true;'
          'end.')
      end>
    OnPublicVariable = <
      item
        VariableName = 'oid_busqueda'
      end
      item
        VariableName = 'oid_candidato_busq'
      end>
    OnInicializar = <
      item
        Source.Strings = (
          'begin'
          '  TMotiEstCandBusq.loadFromHelp('#39'HelpMotiEstCandBusq'#39');'
          '  TRecluEstCandBusq.loadFromHelp('#39'HelpRecluEstCandBusq'#39');'
          'end.')
      end>
    OnClickToolButton = <
      item
        ButtonName = 'BotonCancelar'
        Source.Strings = (
          'begin'
          '  if (mensaje.question('#39#191'Desea salir sin grabar los cambios?'#39'))'
          '     then close();'
          'end.')
      end
      item
        ButtonName = 'BotonGrabar'
        Source.Strings = (
          'begin'
          ''
          '  operacion.InicioOperacion();'
          '  operacion.setOper('#39'SaveRecluAltaCandBusq'#39');'
          
            '  operacion.addAtribute('#39'oid_busqueda'#39',IntToStr(getVariable.getV' +
            'alue('#39'oid_busqueda'#39')));'
          '  operacion.addDataSet(TCandidato.getDataSet());'
          '  operacion.execute();'
          ''
          '  if (not TAdvertencia.IsEmpty())'
          
            '      then mensaje.information(TAdvertencia.FieldName('#39'mensaje'#39')' +
            '.asString);'
          ''
          ''
          '  if (not TConsCerrarBusq.IsEmpty())'
          '     then begin'
          
            '             if (mensaje.question(TConsCerrarBusq.FieldName('#39'men' +
            'saje'#39').AsString))'
          '                  then begin'
          '                          operacion.InicioOperacion();'
          
            '                          operacion.setOper('#39'SaveRecluCerrarBusq' +
            'ueda'#39');'
          
            '           operacion.AddAtribute('#39'oid_busqueda'#39',IntToStr(getVari' +
            'able.getValue('#39'oid_busqueda'#39')));'
          '           operacion.execute(); '
          '                          end; '
          '             end;'
          ''
          '  close;'
          ''
          'end.')
      end>
    Left = 344
    Top = 291
  end
  inherited ImprimirObjetoSeleccionado: TdxComponentPrinter
    inherited ImprimirObjetoSeleccionadodxComponentPrinterLink: TdxGridReportLink
      BuiltInReportLink = True
    end
  end
  object TCandidato: TsnTable
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
    Left = 480
    Top = 66
    object TCandidatooid_candidato_busq: TIntegerField
      FieldName = 'oid_candidato_busq'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TCandidatooid_busqueda_act: TIntegerField
      FieldName = 'oid_busqueda_act'
    end
    object TCandidatooid_postulante: TIntegerField
      FieldName = 'oid_postulante'
    end
    object TCandidatonro_docu: TStringField
      FieldName = 'nro_docu'
      Size = 30
    end
    object TCandidatoape_y_nom: TStringField
      FieldName = 'ape_y_nom'
      Size = 100
    end
    object TCandidatooid_est_cand_busq: TIntegerField
      FieldName = 'oid_est_cand_busq'
    end
    object TCandidatocomentario: TStringField
      FieldName = 'comentario'
      Size = 4000
    end
    object TCandidatooid_mot_est_cand: TIntegerField
      FieldName = 'oid_mot_est_cand'
    end
    object TCandidatofec_ingreso: TDateField
      FieldName = 'fec_ingreso'
    end
    object TCandidatoactivo: TBooleanField
      FieldName = 'activo'
    end
  end
  object DSCandidato: TDataSource
    DataSet = TCandidato
    Left = 512
    Top = 65
  end
  object HelpRecluEstCandBusq: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'rs.RecluEstCandidatoBusq'
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
    Left = 624
    Top = 196
  end
  object TRecluEstCandBusq: TsnTable
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
    Left = 658
    Top = 196
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
  object DSTRecluEstCandBusq: TDataSource
    DataSet = TRecluEstCandBusq
    Left = 692
    Top = 196
  end
  object HelpPostulantes: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'rs.RecluPostulante'
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
        AsignarACampo = TCandidatonro_docu
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
    Titulo = 'Postulantes'
    AnchoHelp = 600
    ActivarCache = True
    ShowBotonBuscar = False
    Left = 473
    Top = 121
  end
  object ValidarPostulante: TValidador
    Operacion = Operacion
    NickNameObjLog = 'rs.RecluPostulante'
    MensajeException = 'C'#243'digo de Postulante Inexistente'
    CampoOID = TCandidatooid_postulante
    CampoDescripcion = TCandidatoape_y_nom
    NroQuery = 0
    Cache = False
    Left = 622
    Top = 81
  end
  object HelpMotiEstCandBusq: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'rs.RecluMotiEstCandBusq'
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
    Left = 359
    Top = 77
  end
  object TMotiEstCandBusq: TsnTable
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
    Left = 393
    Top = 77
    object IntegerField9: TIntegerField
      FieldName = 'oid'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object StringField19: TStringField
      FieldName = 'codigo'
      Size = 50
    end
    object StringField20: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
  end
  object DStMotiEstCandBusq: TDataSource
    DataSet = TMotiEstCandBusq
    Left = 427
    Top = 77
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
  object TAdvertencia: TsnTable
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
    Left = 440
    Top = 389
    object TAdvertenciamensaje: TStringField
      FieldName = 'mensaje'
      Size = 255
    end
  end
  object TConsCerrarBusq: TsnTable
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
    Left = 848
    Top = 252
    object TConsCerrarBusqoid_busqueda: TIntegerField
      FieldName = 'oid_busqueda'
    end
    object TConsCerrarBusqmensaje: TStringField
      FieldName = 'mensaje'
      Size = 500
    end
  end
end
