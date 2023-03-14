inherited FRecluAltaProcCandi: TFRecluAltaProcCandi
  Left = 63
  Top = 45
  Width = 998
  Height = 723
  BorderIcons = []
  Caption = 'Alta Modificaci'#243'n Proceso del Candidato'
  DragKind = dkDrag
  DragMode = dmManual
  Position = poScreenCenter
  PixelsPerInch = 96
  TextHeight = 13
  object Panel1: TPanel [0]
    Left = 0
    Top = 0
    Width = 982
    Height = 121
    Align = alTop
    BevelOuter = bvNone
    Color = clWindow
    TabOrder = 0
    object Label1: TLabel
      Left = 12
      Top = 11
      Width = 480
      Height = 18
      Caption = 'Alta  / Modificaci'#243'n Proceso del Candidato en la B'#250'squeda'
      Font.Charset = ANSI_CHARSET
      Font.Color = clWindowText
      Font.Height = -16
      Font.Name = 'Verdana'
      Font.Style = []
      ParentFont = False
    end
    object Label13: TLabel
      Left = 40
      Top = 56
      Width = 53
      Height = 16
      Caption = 'Puesto:'
      Font.Charset = DEFAULT_CHARSET
      Font.Color = clWindowText
      Font.Height = -13
      Font.Name = 'MS Sans Serif'
      Font.Style = [fsBold]
      ParentFont = False
    end
    object Label14: TLabel
      Left = 40
      Top = 96
      Width = 76
      Height = 16
      Caption = 'Candidato:'
      Font.Charset = DEFAULT_CHARSET
      Font.Color = clWindowText
      Font.Height = -13
      Font.Name = 'MS Sans Serif'
      Font.Style = [fsBold]
      ParentFont = False
    end
    object snDBEdit5: TsnDBEdit
      Left = 128
      Top = 49
      TabStop = False
      DataBinding.DataField = 'nombre_puesto'
      DataBinding.DataSource = DSPuestoCandidato
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
      Width = 753
    end
    object snDBEdit6: TsnDBEdit
      Left = 128
      Top = 89
      TabStop = False
      DataBinding.DataField = 'nombre_postulante'
      DataBinding.DataSource = DSPuestoCandidato
      ParentFont = False
      Properties.ReadOnly = True
      Style.Font.Charset = ANSI_CHARSET
      Style.Font.Color = 16742263
      Style.Font.Height = -19
      Style.Font.Name = 'Verdana'
      Style.Font.Style = []
      Style.IsFontAssigned = True
      TabOrder = 1
      ReadOnlyAlways = True
      Width = 753
    end
  end
  object Panel3: TPanel [1]
    Left = 0
    Top = 632
    Width = 982
    Height = 53
    Align = alBottom
    BevelOuter = bvNone
    Color = clWindow
    TabOrder = 1
    object BotonGrabar: TsnButton
      Left = 624
      Top = -1
      Width = 113
      Height = 45
      Caption = 'Grabar'
      TabOrder = 0
      Glyph.Data = {
        42080000424D4208000000000000420000002800000020000000200000000100
        10000300000000080000202E0000202E00000000000000000000007C0000E003
        00001F000000FF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7F
        FF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FDE77BE779D737C6F3A5FBD73FF7FFF7F
        FF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7F
        DE7B9D737D675B631A5FF956D952B84E974A97467642B84AB029944EFF7FFF7F
        FF7FFF7FFF7FFF7FFF7FFF7FFF7FDE7BBE77BD737C6B3B631A5BD852974A5542
        1236D22DF22D353A553E353E763E7642764676467646D94E13369552FF7FFF7F
        FF7FFF7FFF7FFF7FFF7FFF7FFF7FD85290298F296E258F25AF2DAF29B031F239
        5442B74E754AD031553EB84A974A974A974AB84AB84AFA4E343AB652FF7FFF7F
        FF7FFF7FFF7FFF7FFF7FFF7FFF7FB74EF235954AB752F85A1A5F5B675D6F7E6F
        BF73BF733B639652F135543EB84E974AB84AB84AB84AD94E343AB652FF7FFF7F
        FF7FFF7FFF7FFF7FFF7FFF7FFF7FF8561B5FFF7FFF7BDF77DF77BF739F737F6F
        9F6F3C63B7523D67F95AF135543ED94EB84AB84AB84AD952553EB652FF7FFF7F
        FF7FFF7FFF7FFF7FFF7FFF7FFF7F195BFA5ABF779F6F9E6F7E6F7E6B7E6B7E6B
        9E6F5C67B752FA5A7D6B3A63F139143AD94EB84EB94EDA527642D652FF7FFF7F
        FF7FFF7FFF7FFF7FFF7FFF7FFF7F195FD956DF779E6F7E6F7E6B7E6B7E6B7D6B
        7D6F3C67B7521A5F3B637E6B1B63123E343ED952D94EFA527646D756FF7FFF7F
        FF7FFF7FFF7FFF7FFF7FFF7FFF7F185FD952BF777E6F7E6B7E6B7E6B7D6B7D6B
        7E6B3C63B7521A5F3C633C5F9E6B5C6B133E133AF94EFA4E9746B652FF7FFF7F
        FF7FFF7FFF7FFF7FFF7FFF7FFF7F5A67D8527F6F7E6B7E6B7D6B7D6B7D6B5D67
        5D673C63B7521B5F3C635C675C677E6B5E6B5446343AFA52B84A954AFF7FFF7F
        FF7FFF7FFF7FFF7FFF7FFF7FFF7F7B6BD9527F6F7E6B7D6B7D6B5D675D675D67
        5C6B3B6397523B637C6B5D675E675D679F6FDF775546343EB94AB64EFF7FFF7F
        FF7FFF7FFF7FFF7FFF7FFF7FFF7F9C6FD9529E6F7D6B5D675D675D675D675C67
        5C631C5F96523A637C6B3C633C633C635B637C6B7D6B764A553EB64EFF7FFF7F
        FF7FFF7FFF7FFF7FFF7FFF7FFF7F9C6FD8527D6B7D6B5D675D675C675C673C63
        3C633B63D956D756D756B652B652B752B652964EF95AD95A333AB64AFF7FFF7F
        FF7FFF7FFF7FFF7FFF7FFF7FFF7F9D73D8525D675D675D675C675C673C633C63
        3B633B631B5FFA5AFA5AF95AD95AF95AF95AFA5AFA5ED856343E964AFF7FFF7F
        FF7FFF7FFF7FFF7FFF7FFF7FFF7FBD77D8525D675C675C673C633C633C633B63
        3B631B5F1B5F1B5F1B5F1A5FFA5AFA5AFB5AFA5A1A5FD85634427546FF7FFF7F
        FF7FFF7FFF7FFF7FFF7FFF7FFF7FBD77D8565C675C673C633C633B633B631B5F
        1B5F1B5F1B5F1A5FFA5AFA5AFA5AFA5AF95AD95ADA5AB85654427546DE7BFF7F
        FF7FFF7FFF7FFF7FFF7FFF7FFF7FDE7BF95A3C5F3C633C633B633B5F1B5F1B5F
        1B5F1A5F1A5FFA5AFA5AFA5AF95AD95AD956D956DA56B9525442754ADE7BFF7F
        FF7FFF7FFF7FFF7FFF7FFF7FFF7FDE7FF95A3B5F3B633B631B5F1B5F1B5F1B5F
        1A5FFA5AFA5AFA5AFA5AF95AD95AD956D956D956F95AD8563442954ADE7BFF7F
        FF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FF95A1A5F1B5F1B5F1B5F1B5F1A5FFA5A
        FA5AFA5AFA5AF95AD95AD956D956D956D856D856D856B7525442964ADE7BFF7F
        FF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7F3A63FA5A1B5F1B5F1A5FFA5AFA5AFA5A
        FA5AF95AD95AD956D956D956D956D856D856B852B8529852543E7546BD77FF7F
        FF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7F195FDA561B5F1A5FFA5AFA5AFA5AFA5A
        F95AD956D956D956D956D856D856D856B852B852B852B752754254429C73FF7F
        FF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7F3B63D956FA5AFA5AFA5AFA5AF95AD95A
        D956D956D956D856D856D856B852B852B852B852D752B7525546543E9C73FF7F
        FF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7F3A63B852FB5AFA5AF95AD95AD956D956
        D956D956D856D856B852B852B852B752B752B752B752974E554255429C6FFF7F
        FF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7F3A63B8523B631A631A5F1A5F1A5F1A5F
        195F195FF95AD95AD956D85AD856D756D752B752974E974E744654427C6FFF7F
        FF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7F7C6F55427229B22DD335F435F439143E
        35423642564A764E764E964EB652B652B752B756B752D8563342F2357C6FFF7F
        FF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7F9C6FB752311D0F1130193019501D5119
        311D511D511D711D7121712192259329B329B32DD32D1536133EF2357C6FFF7F
        FF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7F9C73F85A353E521D9325B3259325B325
        B325B32593259425932593259325B325B32594257321F5395442333A7B6FFF7F
        FF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FBD77B84AB846563ED62DD629F52DF52D
        D531D52DD52DD52DD52DF52DD529D429D529B525363EB6565446333A7B6FFF7F
        FF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFE7BFA56D94EF952B84A573E38363936
        583A583A383A383637361836183617361636553EB74EF956FA5676465B6BFF7F
        FF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FDE7BBE77BD73BC735C63BB4A
        9B3EBB469B469B4A5B3E593A57425642984AD952FA52FC565E5F7742185FFF7F
        FF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FBE77
        BB4A7A3A9B423A3699469C739C6F7B6B5C633B5F3B5F3B5B3B5B97463A63FF7F
        FF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7FFF7F
        DE7B3B637846B94EBE77FF7FFF7FFF7FFF7FFF7FFF7FDE7BDD77BE77FF7FFF7F
        FF7FFF7FFF7F}
      LookAndFeel.Kind = lfOffice11
    end
    object BotonCancelar: TsnButton
      Left = 792
      Top = -1
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
    Top = 121
    Width = 982
    Height = 511
    Align = alClient
    BevelOuter = bvNone
    Color = clWindow
    TabOrder = 2
    object Label2: TLabel
      Left = 40
      Top = 32
      Width = 40
      Height = 16
      Caption = 'Orden:'
      Font.Charset = DEFAULT_CHARSET
      Font.Color = clWindowText
      Font.Height = -13
      Font.Name = 'MS Sans Serif'
      Font.Style = []
      ParentFont = False
    end
    object Label3: TLabel
      Left = 40
      Top = 72
      Width = 54
      Height = 16
      Caption = 'Proceso:'
      Font.Charset = DEFAULT_CHARSET
      Font.Color = clWindowText
      Font.Height = -13
      Font.Name = 'MS Sans Serif'
      Font.Style = []
      ParentFont = False
    end
    object Label4: TLabel
      Left = 40
      Top = 112
      Width = 102
      Height = 16
      Caption = 'Tipo de Ex'#225'men:'
      Font.Charset = DEFAULT_CHARSET
      Font.Color = clWindowText
      Font.Height = -13
      Font.Name = 'MS Sans Serif'
      Font.Style = []
      ParentFont = False
    end
    object Label5: TLabel
      Left = 40
      Top = 152
      Width = 38
      Height = 16
      Caption = 'Costo:'
      Font.Charset = DEFAULT_CHARSET
      Font.Color = clWindowText
      Font.Height = -13
      Font.Name = 'MS Sans Serif'
      Font.Style = []
      ParentFont = False
    end
    object Label6: TLabel
      Left = 40
      Top = 272
      Width = 46
      Height = 16
      Caption = 'Estado:'
      Font.Charset = DEFAULT_CHARSET
      Font.Color = clWindowText
      Font.Height = -13
      Font.Name = 'MS Sans Serif'
      Font.Style = []
      ParentFont = False
    end
    object Label7: TLabel
      Left = 40
      Top = 192
      Width = 77
      Height = 16
      Caption = 'Fecha Planif:'
      Font.Charset = DEFAULT_CHARSET
      Font.Color = clWindowText
      Font.Height = -13
      Font.Name = 'MS Sans Serif'
      Font.Style = []
      ParentFont = False
    end
    object Label8: TLabel
      Left = 312
      Top = 192
      Width = 69
      Height = 16
      Caption = 'Hora Planif:'
      Font.Charset = DEFAULT_CHARSET
      Font.Color = clWindowText
      Font.Height = -13
      Font.Name = 'MS Sans Serif'
      Font.Style = []
      ParentFont = False
    end
    object Label9: TLabel
      Left = 40
      Top = 232
      Width = 71
      Height = 16
      Caption = 'Contactar a:'
      Font.Charset = DEFAULT_CHARSET
      Font.Color = clWindowText
      Font.Height = -13
      Font.Name = 'MS Sans Serif'
      Font.Style = []
      ParentFont = False
    end
    object Label10: TLabel
      Left = 40
      Top = 312
      Width = 95
      Height = 16
      Caption = 'Observaciones:'
      Font.Charset = DEFAULT_CHARSET
      Font.Color = clWindowText
      Font.Height = -13
      Font.Name = 'MS Sans Serif'
      Font.Style = []
      ParentFont = False
    end
    object Label12: TLabel
      Left = 40
      Top = 392
      Width = 48
      Height = 16
      Caption = 'Archivo:'
      Font.Charset = DEFAULT_CHARSET
      Font.Color = clWindowText
      Font.Height = -13
      Font.Name = 'MS Sans Serif'
      Font.Style = []
      ParentFont = False
    end
    object Label1Visualizar: TLabel
      Left = 624
      Top = 392
      Width = 58
      Height = 16
      Cursor = crHandPoint
      Caption = 'Visualizar'
      Font.Charset = DEFAULT_CHARSET
      Font.Color = clBlue
      Font.Height = -13
      Font.Name = 'MS Sans Serif'
      Font.Style = [fsUnderline]
      ParentFont = False
    end
    object Label11: TLabel
      Left = 40
      Top = 432
      Width = 64
      Height = 16
      Caption = 'Formulario'
      Font.Charset = DEFAULT_CHARSET
      Font.Color = clWindowText
      Font.Height = -13
      Font.Name = 'MS Sans Serif'
      Font.Style = []
      ParentFont = False
    end
    object Label16: TLabel
      Left = 672
      Top = 432
      Width = 87
      Height = 16
      Caption = 'Fec. Complet'#243
      Font.Charset = DEFAULT_CHARSET
      Font.Color = clWindowText
      Font.Height = -13
      Font.Name = 'MS Sans Serif'
      Font.Style = []
      ParentFont = False
    end
    object Label15: TLabel
      Left = 264
      Top = 29
      Width = 73
      Height = 20
      Caption = 'Operaci'#243'n'
      Font.Charset = DEFAULT_CHARSET
      Font.Color = clWindowText
      Font.Height = -16
      Font.Name = 'MS Sans Serif'
      Font.Style = []
      ParentFont = False
    end
    object Label17: TLabel
      Left = 496
      Top = 29
      Width = 47
      Height = 20
      Caption = 'Sector'
      Font.Charset = DEFAULT_CHARSET
      Font.Color = clWindowText
      Font.Height = -16
      Font.Name = 'MS Sans Serif'
      Font.Style = []
      ParentFont = False
    end
    object Label18: TLabel
      Left = 712
      Top = 29
      Width = 59
      Height = 20
      Caption = 'Selector'
      Font.Charset = DEFAULT_CHARSET
      Font.Color = clWindowText
      Font.Height = -16
      Font.Name = 'MS Sans Serif'
      Font.Style = []
      ParentFont = False
    end
    object snDBEdit1: TsnDBEdit
      Left = 152
      Top = 28
      TabStop = False
      DataBinding.DataField = 'orden'
      DataBinding.DataSource = dsTAltaProcesoCandidato
      ParentFont = False
      Properties.ReadOnly = False
      Style.Font.Charset = DEFAULT_CHARSET
      Style.Font.Color = clWindowText
      Style.Font.Height = -13
      Style.Font.Name = 'MS Sans Serif'
      Style.Font.Style = []
      Style.IsFontAssigned = True
      TabOrder = 0
      Width = 97
    end
    object snDBLookup5: TsnDBLookup
      Left = 152
      Top = 68
      DataBinding.DataField = 'oid_proceso'
      DataBinding.DataSource = dsTAltaProcesoCandidato
      ParentFont = False
      Properties.KeyFieldNames = 'oid'
      Properties.ListColumns = <
        item
          FieldName = 'descripcion'
        end>
      Properties.ListOptions.ShowHeader = False
      Properties.ListSource = DSProcesos
      Style.Font.Charset = DEFAULT_CHARSET
      Style.Font.Color = clWindowText
      Style.Font.Height = -13
      Style.Font.Name = 'MS Sans Serif'
      Style.Font.Style = []
      Style.IsFontAssigned = True
      TabOrder = 4
      Width = 433
    end
    object snDBLookup1: TsnDBLookup
      Left = 152
      Top = 108
      DataBinding.DataField = 'oid_conc_proceso'
      DataBinding.DataSource = dsTAltaProcesoCandidato
      ParentFont = False
      Properties.KeyFieldNames = 'oid'
      Properties.ListColumns = <
        item
          FieldName = 'descripcion'
        end>
      Properties.ListOptions.ShowHeader = False
      Properties.ListSource = DSTiposExamenes
      Style.Font.Charset = DEFAULT_CHARSET
      Style.Font.Color = clWindowText
      Style.Font.Height = -13
      Style.Font.Name = 'MS Sans Serif'
      Style.Font.Style = []
      Style.IsFontAssigned = True
      TabOrder = 5
      Width = 433
    end
    object snDBEdit2: TsnDBEdit
      Left = 152
      Top = 148
      DataBinding.DataField = 'costo'
      DataBinding.DataSource = dsTAltaProcesoCandidato
      ParentFont = False
      Properties.ReadOnly = False
      Style.Font.Charset = DEFAULT_CHARSET
      Style.Font.Color = clWindowText
      Style.Font.Height = -13
      Style.Font.Name = 'MS Sans Serif'
      Style.Font.Style = []
      Style.IsFontAssigned = True
      TabOrder = 6
      Width = 97
    end
    object snDBLookup2: TsnDBLookup
      Left = 152
      Top = 268
      DataBinding.DataField = 'oid_est_proc_sel'
      DataBinding.DataSource = dsTAltaProcesoCandidato
      ParentFont = False
      Properties.KeyFieldNames = 'oid'
      Properties.ListColumns = <
        item
          FieldName = 'descripcion'
        end>
      Properties.ListOptions.ShowHeader = False
      Properties.ListSource = DSEstadoProceso
      Style.Font.Charset = DEFAULT_CHARSET
      Style.Font.Color = clWindowText
      Style.Font.Height = -13
      Style.Font.Name = 'MS Sans Serif'
      Style.Font.Style = []
      Style.IsFontAssigned = True
      TabOrder = 10
      Width = 433
    end
    object snDBDateEdit1: TsnDBDateEdit
      Left = 152
      Top = 188
      DataBinding.DataField = 'fecha_planif'
      DataBinding.DataSource = dsTAltaProcesoCandidato
      ParentFont = False
      Style.Font.Charset = DEFAULT_CHARSET
      Style.Font.Color = clWindowText
      Style.Font.Height = -13
      Style.Font.Name = 'MS Sans Serif'
      Style.Font.Style = []
      Style.IsFontAssigned = True
      TabOrder = 7
      ReadOnlyAlways = False
      Width = 121
    end
    object snDBEdit3: TsnDBEdit
      Left = 392
      Top = 188
      DataBinding.DataField = 'hora_planif'
      DataBinding.DataSource = dsTAltaProcesoCandidato
      ParentFont = False
      Properties.ReadOnly = False
      Style.Font.Charset = DEFAULT_CHARSET
      Style.Font.Color = clWindowText
      Style.Font.Height = -13
      Style.Font.Name = 'MS Sans Serif'
      Style.Font.Style = []
      Style.IsFontAssigned = True
      TabOrder = 8
      Width = 97
    end
    object snDBEdit4: TsnDBEdit
      Left = 152
      Top = 228
      DataBinding.DataField = 'persona'
      DataBinding.DataSource = dsTAltaProcesoCandidato
      ParentFont = False
      Properties.ReadOnly = False
      Style.Font.Charset = DEFAULT_CHARSET
      Style.Font.Color = clWindowText
      Style.Font.Height = -13
      Style.Font.Name = 'MS Sans Serif'
      Style.Font.Style = []
      Style.IsFontAssigned = True
      TabOrder = 9
      Width = 337
    end
    object snDBMemo1: TsnDBMemo
      Left = 152
      Top = 304
      DataBinding.DataField = 'observaciones'
      DataBinding.DataSource = dsTAltaProcesoCandidato
      ParentFont = False
      Style.Font.Charset = DEFAULT_CHARSET
      Style.Font.Color = clWindowText
      Style.Font.Height = -13
      Style.Font.Name = 'MS Sans Serif'
      Style.Font.Style = []
      Style.IsFontAssigned = True
      TabOrder = 11
      ReadOnlyAlways = False
      Height = 66
      Width = 433
    end
    object srnDBButtonEdit1: TsrnDBButtonEdit
      Left = 152
      Top = 388
      DataBinding.DataField = 'nombre_archivo'
      DataBinding.DataSource = dsTAltaProcesoCandidato
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
      TabOrder = 12
      Width = 433
    end
    object snDBLookup3: TsnDBLookup
      Left = 152
      Top = 428
      DataBinding.DataField = 'oid_tipo_formu'
      DataBinding.DataSource = dsTAltaProcesoCandidato
      ParentFont = False
      Properties.KeyFieldNames = 'oid'
      Properties.ListColumns = <
        item
          FieldName = 'descripcion'
        end>
      Properties.ListOptions.ShowHeader = False
      Properties.ListSource = DSTipoFormulario
      Style.Font.Charset = DEFAULT_CHARSET
      Style.Font.Color = clWindowText
      Style.Font.Height = -13
      Style.Font.Name = 'MS Sans Serif'
      Style.Font.Style = []
      Style.IsFontAssigned = True
      TabOrder = 13
      Width = 193
    end
    object snDBDateEdit2: TsnDBDateEdit
      Left = 776
      Top = 428
      DataBinding.DataField = 'fec_completo_tf'
      DataBinding.DataSource = dsTAltaProcesoCandidato
      ParentFont = False
      Style.Font.Charset = DEFAULT_CHARSET
      Style.Font.Color = clWindowText
      Style.Font.Height = -13
      Style.Font.Name = 'MS Sans Serif'
      Style.Font.Style = []
      Style.IsFontAssigned = True
      TabOrder = 15
      ReadOnlyAlways = False
      Width = 121
    end
    object snDBCheckEdit1: TsnDBCheckEdit
      Left = 416
      Top = 428
      Caption = 'Completo el Formulario?'
      DataBinding.DataField = 'completo_tipo_formu'
      DataBinding.DataSource = dsTAltaProcesoCandidato
      ParentFont = False
      Style.Font.Charset = DEFAULT_CHARSET
      Style.Font.Color = clWindowText
      Style.Font.Height = -13
      Style.Font.Name = 'MS Sans Serif'
      Style.Font.Style = []
      Style.IsFontAssigned = True
      TabOrder = 14
      Width = 177
    end
    object snDBLookup4: TsnDBLookup
      Left = 344
      Top = 25
      DataBinding.DataField = 'oid_operacion'
      DataBinding.DataSource = dsTAltaProcesoCandidato
      ParentFont = False
      Properties.KeyFieldNames = 'oid'
      Properties.ListColumns = <
        item
          FieldName = 'descripcion'
        end>
      Properties.ListOptions.ShowHeader = False
      Properties.ListSource = DSRecluOperacion
      Style.Font.Charset = DEFAULT_CHARSET
      Style.Font.Color = clWindowText
      Style.Font.Height = -16
      Style.Font.Name = 'MS Sans Serif'
      Style.Font.Style = []
      Style.IsFontAssigned = True
      TabOrder = 1
      Width = 129
    end
    object snDBLookup6: TsnDBLookup
      Left = 552
      Top = 25
      DataBinding.DataField = 'oid_sector'
      DataBinding.DataSource = dsTAltaProcesoCandidato
      ParentFont = False
      Properties.KeyFieldNames = 'oid'
      Properties.ListColumns = <
        item
          FieldName = 'descripcion'
        end>
      Properties.ListOptions.ShowHeader = False
      Properties.ListSource = DSRecluSectores
      Style.Font.Charset = DEFAULT_CHARSET
      Style.Font.Color = clWindowText
      Style.Font.Height = -16
      Style.Font.Name = 'MS Sans Serif'
      Style.Font.Style = []
      Style.IsFontAssigned = True
      TabOrder = 2
      Width = 145
    end
    object snDBLookup7: TsnDBLookup
      Left = 784
      Top = 25
      DataBinding.DataField = 'oid_selector'
      DataBinding.DataSource = dsTAltaProcesoCandidato
      ParentFont = False
      Properties.KeyFieldNames = 'oid'
      Properties.ListColumns = <
        item
          FieldName = 'descripcion'
        end>
      Properties.ListOptions.ShowHeader = False
      Properties.ListSource = DSTSelector
      Style.Font.Charset = DEFAULT_CHARSET
      Style.Font.Color = clWindowText
      Style.Font.Height = -16
      Style.Font.Name = 'MS Sans Serif'
      Style.Font.Style = []
      Style.IsFontAssigned = True
      TabOrder = 3
      Width = 145
    end
  end
  inherited DriverABM: TDriverABM
    CargaDataSets = <
      item
        DataSet = TAltaProcesoCandidato
        TableName = 'TAltaProcesoCandidato'
      end
      item
        DataSet = TArchivoPostulante
        TableName = 'TArchivoPostulante'
      end
      item
        DataSet = TPuestoCandidato
        TableName = 'TPuestoCandidato'
      end
      item
        DataSet = TNombrePostu
        TableName = 'TNombrePostu'
      end>
    Left = 264
    Top = 48
  end
  inherited Operacion: TOperacion
    Left = 304
    Top = 48
  end
  inherited dxComponentPrinter: TdxComponentPrinter
    Left = 344
    Top = 48
    inherited dxComponentPrinterLink1: TdxCustomContainerReportLink
      Component = Owner
      BuiltInReportLink = True
      HiddenComponents = {}
      ExcludedComponents = {}
      AggregatedReportLinks = {}
    end
  end
  inherited SaveDialog: TSaveDialog
    Left = 384
    Top = 48
  end
  inherited DriverEvent: TDriverEvent
    OnShow.Strings = (
      'var'
      '  oidPostulante : integer;'
      'begin'
      ''
      '  oidPostulante := -1;'
      '  if (getVariable().getInteger('#39'oid_candidato_busq'#39')>0)'
      '     then begin'
      '             operacion.inicioOperacion();'
      '             operacion.setOper('#39'TraerRecluPuestoCandi'#39');'
      
        '             operacion.addAtribute('#39'oid_candidato_busq'#39',IntToStr' +
        '(getVariable().getInteger('#39'oid_candidato_busq'#39')));'
      '             operacion.execute(); '
      '             end'
      '     else  begin'
      
        '             oidPostulante := getVariable().getInteger('#39'oid_post' +
        'ulante'#39');             '
      '             TPuestoCandidato.Close;'
      '             TPuestoCandidato.Open;'
      '             TPuestoCandidato.AppendRecord;'
      
        '             TPuestoCandidato.FieldName('#39'nombre_postulante'#39').AsS' +
        'tring :=  getNombrePostulante(oidPostulante);'
      '             end;'
      ''
      '  if (getVariable().getInteger('#39'oid_proceso_sel'#39')=-1)'
      '     then begin'
      '              AltaProcCandidato();'
      '             TAltaProcesoCandidato.Close;'
      '             TAltaProcesoCandidato.Open;'
      '             TAltaProcesoCandidato.AppendRecord;'
      '              if (OidPostulante>0)'
      
        '                  then TAltaProcesoCandidato.FieldName('#39'oid_post' +
        'ulante'#39').AsInteger := oidPostulante;     '
      '              end'
      '     else begin'
      '             operacion.InicioOperacion();'
      '             operacion.setOper('#39'TraerRecluModifProcesoCand'#39');'
      
        '             operacion.addAtribute('#39'oid_proceso_sel'#39',IntToStr(ge' +
        'tVariable().getInteger('#39'oid_proceso_sel'#39')));'
      '             operacion.execute();'
      '             TAltaProcesoCandidato.EditRecord;'
      
        '             TAltaProcesoCandidato.FieldName('#39'oid_proceso'#39').AsIn' +
        'teger :='
      
        '                TAltaProcesoCandidato.FieldName('#39'oid_proceso'#39').A' +
        'sInteger;'
      ''
      ''
      '             end;'
      '   snDBEdit1.setFoco();'
      ''
      '  if (getVariable().getInteger('#39'oid_candidato_busq'#39')>0)'
      '    then ocultarControles()'
      '    else mostrarControles();'
      ''
      ''
      'end.')
    OnChangeField = <
      item
        TableName = 'TAltaProcesoCandidato'
        FieldName = 'oid_proceso'
        Source.Strings = (
          'begin'
          '  recargarTiposExamenes();'
          'end.')
      end>
    OnNuevoRegistro = <
      item
        TableName = 'TAltaProcesoCandidato'
        Source.Strings = (
          'begin'
          '  DataSet.FieldName('#39'activo'#39').Value := true;'
          '  DataSet.FieldName('#39'puede_iniciar'#39').Value := true;'
          'end.')
      end>
    OnPublicVariable = <
      item
        VariableName = 'oid_candidato_busq'
      end
      item
        VariableName = 'oid_proceso_sel'
      end
      item
        VariableName = 'oid_postulante'
      end>
    OnInicializar = <
      item
        Source.Strings = (
          'begin'
          '  cargarSINO();'
          ' TProcesos.loadFromHelp('#39'HelpProcesos'#39');'
          ' TEstadoProceso.loadFromHelp('#39'HelpEstado'#39');'
          '  TTipoFormulario.loadFromHelp('#39'HelpTipoFormulario'#39');'
          '  TRecluOperacion.loadFromHelp('#39'HelpOperacion'#39');'
          '  TRecluSectores.loadFromHelp('#39'HelpSectores'#39');'
          '  TSelector.loadFromHelp('#39'HelpSelector'#39');'
          'end.')
      end>
    OnFormFunction = <
      item
        Source.Strings = (
          'procedure mostrarControles();'
          'begin'
          '  compo.setValue('#39'Label15'#39','#39'visible'#39',true);'
          '  compo.setValue('#39'Label17'#39','#39'visible'#39',true);'
          '  compo.setValue('#39'Label18'#39','#39'visible'#39',true);'
          '  compo.setValue('#39'snDBLookup4'#39','#39'visible'#39',true);'
          '  compo.setValue('#39'snDBLookup6'#39','#39'visible'#39',true);'
          '  compo.setValue('#39'snDBLookup7'#39','#39'visible'#39',true);'
          'end;'
          ''
          ''
          'procedure ocultarControles();'
          'begin'
          '  compo.setValue('#39'Label15'#39','#39'visible'#39',false);'
          '  compo.setValue('#39'Label17'#39','#39'visible'#39',false);'
          '  compo.setValue('#39'Label18'#39','#39'visible'#39',false);'
          '  compo.setValue('#39'snDBLookup4'#39','#39'visible'#39',false);'
          '  compo.setValue('#39'snDBLookup6'#39','#39'visible'#39',false);'
          '  compo.setValue('#39'snDBLookup7'#39','#39'visible'#39',false);'
          'end;'
          ''
          ''
          'function getNombrePostulante(OidPostulante : integer) : string;'
          'begin'
          ''
          '  operacion.InicioOperacion();'
          '  operacion.setOper('#39'TraerRecluNombrePostu'#39');'
          
            '  operacion.AddAtribute('#39'oid_postulante'#39',IntToStr(OidPostulante)' +
            ');'
          '  operacion.execute();'
          ''
          
            '  result := TNombrePostu.FieldName('#39'nombre_postulante'#39').AsString' +
            ';'
          ''
          'end;'
          ''
          'procedure AltaProcCandidato();'
          'begin'
          'end;'
          ''
          'procedure cargarSINO();'
          'begin'
          '  TIniciar.Close;'
          '  TIniciar.open;'
          ''
          '  TIniciar.appendRecord;'
          '  TIniciar.FieldName('#39'codigo'#39').value := true;'
          '  TIniciar.FieldName('#39'descripcion'#39').value := '#39'SI'#39';'
          '  TIniciar.postRecord;'
          ''
          '  TIniciar.appendRecord;'
          '  TIniciar.FieldName('#39'codigo'#39').value := false;'
          '  TIniciar.FieldName('#39'descripcion'#39').value := '#39'NO'#39';'
          '  TIniciar.postRecord;'
          ''
          'end;'
          ''
          'procedure recargarTiposExamenes();'
          'begin'
          '  HelpTipoExamenes.clearAtributos;'
          
            '  HelpTipoExamenes.addAtributo('#39'oid_proceso'#39',TAltaProcesoCandida' +
            'to.FieldName('#39'oid_proceso'#39').AsString);'
          '  TTiposExamenes.loadFromHelp('#39'HelpTipoExamenes'#39');'
          'end;'
          ''
          'function getNroArchivo() : integer;'
          'begin'
          '  operacion.InicioOperacion();'
          '  operacion.setOper('#39'SaveRecluNewNroArchPostu'#39');'
          '  operacion.execute();'
          
            '  result :=  TArchivoPostulante.FieldName('#39'nro_archivo'#39').AsInteg' +
            'er;'
          'end;'
          '')
      end>
    OnClickToolButton = <
      item
        ButtonName = 'BotonGrabar'
        Source.Strings = (
          'begin'
          ''
          '  operacion.InicioOperacion();'
          '  operacion.setOper('#39'SaveRecluAltaProcCand'#39');'
          
            '  operacion.addAtribute('#39'oid_candidato_busq'#39',IntToStr(getVariabl' +
            'e.getValue('#39'oid_candidato_busq'#39'))); '
          '  operacion.addDataSet(TAltaProcesoCandidato.getDataSet());'
          '  operacion.execute();'
          ''
          '  close;'
          ''
          'end.')
      end
      item
        ButtonName = 'BotonCancelar'
        Source.Strings = (
          'begin'
          
            '  if (mensaje.question('#39#191'Desea salir sin grabar los cambios?'#39')=f' +
            'alse) then exit;'
          '  close();'
          'end.')
      end
      item
        ButtonName = 'Label1Visualizar'
        Source.Strings = (
          'var'
          '  nomTempFile : string;'
          '  mensajeError : string;'
          'begin'
          '  mensajeError := '#39#39';'
          
            '  SaveAdjunto.setFileName(TAltaProcesoCandidato.FieldName('#39'nombr' +
            'e_archivo'#39').AsString);'
          
            '  SaveAdjunto.setDefaultExt(Varios.getFileExtension(TAltaProceso' +
            'Candidato.FieldName('#39'nombre_archivo'#39').AsString));'
          '  if (SaveAdjunto.show())'
          '     then begin'
          ''
          '               operacion.InicioOperacion();'
          '               operacion.setOper('#39'DownloadArchProcPostulante'#39');'
          
            '               nomTempFile := operacion.DownLoadFile(TAltaProces' +
            'oCandidato.FieldName('#39'nro_archivo'#39').AsString, mensajeError);    ' +
            '                              '
          
            '               nomTempFile := varios.renombrarArchivo(nomTempFil' +
            'e, SaveAdjunto.getFileName());                        '
          ''
          '               if (varios.abrirArchivo(nomTempFile)=false)'
          
            '                  then mensaje.information('#39'No se encontr'#243' aplic' +
            'aci'#243'n asociada al archivo que se desea abrir'#39');                 ' +
            '       '
          ''
          '               end;'
          'end.')
      end>
    OnClickButtonEdit = <
      item
        ButtonEdit = 'srnDBButtonEdit1'
        Source.Strings = (
          'var'
          '  mensajeError : string;'
          'begin'
          ''
          ''
          '  if (AdjArchivo1.show())'
          '      then begin'
          ''
          '              TAltaProcesoCandidato.EditRecord;'
          
            '              TAltaProcesoCandidato.FieldName('#39'nombre_archivo'#39').' +
            'AsString := AdjArchivo1.getFile();'
          
            '              TAltaProcesoCandidato.FieldName('#39'nro_archivo'#39').AsI' +
            'nteger := getNroArchivo();'
          ''
          '              operacion.InicioOperacion();'
          
            '                        operacion.setOper('#39'UploadArchProcPostula' +
            'nte'#39');'
          '                        operacion.UploadFile('
          '                        AdjArchivo1.getDataStream(),'
          
            '                       TAltaProcesoCandidato.FieldName('#39'nro_arch' +
            'ivo'#39').AsString,'
          '                        '#39#39','#39#39','
          '                        true,'
          '                        mensajeError);'
          ''
          '              end;'
          '              '
          ''
          'end.'
          '')
      end>
    Left = 424
    Top = 51
  end
  inherited ImprimirObjetoSeleccionado: TdxComponentPrinter
    inherited ImprimirObjetoSeleccionadodxComponentPrinterLink: TdxGridReportLink
      BuiltInReportLink = True
    end
  end
  inherited TPathHelp: TsnTable
    Left = 504
    Top = 389
  end
  object TAltaProcesoCandidato: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'oid_proceso_selec'
        DataType = ftInteger
      end
      item
        Name = 'oid_candidato_busq'
        DataType = ftInteger
      end
      item
        Name = 'orden'
        DataType = ftInteger
      end
      item
        Name = 'oid_proceso'
        DataType = ftInteger
      end
      item
        Name = 'oid_conc_proceso'
        DataType = ftInteger
      end
      item
        Name = 'costo'
        DataType = ftFloat
      end
      item
        Name = 'oid_est_proc_sel'
        DataType = ftInteger
      end
      item
        Name = 'fecha_planif'
        DataType = ftDate
      end
      item
        Name = 'hora_planif'
        DataType = ftString
        Size = 5
      end
      item
        Name = 'persona'
        DataType = ftString
        Size = 100
      end
      item
        Name = 'observaciones'
        DataType = ftString
        Size = 4000
      end
      item
        Name = 'puede_iniciar'
        DataType = ftBoolean
      end
      item
        Name = 'activo'
        DataType = ftBoolean
      end
      item
        Name = 'nro_archivo'
        DataType = ftInteger
      end
      item
        Name = 'nombre_archivo'
        DataType = ftString
        Size = 255
      end
      item
        Name = 'oid_tipo_formu'
        DataType = ftInteger
      end
      item
        Name = 'completo_tipo_formu'
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
    Left = 528
    Top = 97
    object TAltaProcesoCandidatooid_proceso_selec: TIntegerField
      FieldName = 'oid_proceso_selec'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TAltaProcesoCandidatooid_candidato_busq: TIntegerField
      FieldName = 'oid_candidato_busq'
    end
    object TAltaProcesoCandidatoorden: TIntegerField
      FieldName = 'orden'
    end
    object TAltaProcesoCandidatooid_proceso: TIntegerField
      FieldName = 'oid_proceso'
    end
    object TAltaProcesoCandidatooid_conc_proceso: TIntegerField
      FieldName = 'oid_conc_proceso'
    end
    object TAltaProcesoCandidatocosto: TFloatField
      FieldName = 'costo'
    end
    object TAltaProcesoCandidatooid_est_proc_sel: TIntegerField
      FieldName = 'oid_est_proc_sel'
    end
    object TAltaProcesoCandidatofecha_planif: TDateField
      FieldName = 'fecha_planif'
    end
    object TAltaProcesoCandidatohora_planif: TStringField
      FieldName = 'hora_planif'
      Size = 5
    end
    object TAltaProcesoCandidatopersona: TStringField
      FieldName = 'persona'
      Size = 100
    end
    object TAltaProcesoCandidatoobservaciones: TStringField
      FieldName = 'observaciones'
      Size = 4000
    end
    object TAltaProcesoCandidatopuede_iniciar: TBooleanField
      FieldName = 'puede_iniciar'
    end
    object TAltaProcesoCandidatoactivo: TBooleanField
      FieldName = 'activo'
    end
    object TAltaProcesoCandidatonro_archivo: TIntegerField
      FieldName = 'nro_archivo'
    end
    object TAltaProcesoCandidatonombre_archivo: TStringField
      FieldName = 'nombre_archivo'
      Size = 255
    end
    object TAltaProcesoCandidatooid_tipo_formu: TIntegerField
      FieldName = 'oid_tipo_formu'
    end
    object TAltaProcesoCandidatocompleto_tipo_formu: TBooleanField
      FieldName = 'completo_tipo_formu'
    end
    object TAltaProcesoCandidatofec_completo_tf: TDateField
      FieldName = 'fec_completo_tf'
    end
    object TAltaProcesoCandidatooid_postulante: TIntegerField
      FieldName = 'oid_postulante'
    end
    object TAltaProcesoCandidatooid_operacion: TIntegerField
      FieldName = 'oid_operacion'
    end
    object TAltaProcesoCandidatooid_sector: TIntegerField
      FieldName = 'oid_sector'
    end
    object TAltaProcesoCandidatooid_selector: TIntegerField
      FieldName = 'oid_selector'
    end
  end
  object dsTAltaProcesoCandidato: TDataSource
    DataSet = TAltaProcesoCandidato
    Left = 560
    Top = 97
  end
  object HelpProcesos: TsnHelp
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
    Left = 624
    Top = 164
  end
  object TProcesos: TsnTable
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
    Top = 164
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
  object DSProcesos: TDataSource
    DataSet = TProcesos
    Left = 692
    Top = 164
  end
  object TIniciar: TsnTable
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
    Left = 656
    Top = 241
    object TIniciarcodigo: TBooleanField
      FieldName = 'codigo'
    end
    object TIniciardescripcion: TStringField
      FieldName = 'descripcion'
      Size = 2
    end
  end
  object dsIniciar: TDataSource
    DataSet = TIniciar
    Left = 688
    Top = 241
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
    ActivarCache = False
    ShowBotonBuscar = False
    Left = 624
    Top = 200
  end
  object TTiposExamenes: TsnTable
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
    Top = 200
    object IntegerField1: TIntegerField
      FieldName = 'oid'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object StringField1: TStringField
      FieldName = 'codigo'
      Size = 50
    end
    object StringField2: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
  end
  object DSTiposExamenes: TDataSource
    DataSet = TTiposExamenes
    Left = 692
    Top = 200
  end
  object HelpEstado: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'rs.RecluEstadoProceso'
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
    Left = 623
    Top = 276
  end
  object TEstadoProceso: TsnTable
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
    Left = 657
    Top = 276
    object IntegerField2: TIntegerField
      FieldName = 'oid'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object StringField3: TStringField
      FieldName = 'codigo'
      Size = 50
    end
    object StringField4: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
  end
  object DSEstadoProceso: TDataSource
    DataSet = TEstadoProceso
    Left = 691
    Top = 276
  end
  object AdjArchivo1: TSNOpenDialog
    Left = 680
    Top = 102
  end
  object SaveAdjunto: TsnSaveDialog
    OptionsEx = [ofExNoPlacesBar]
    Left = 488
    Top = 166
  end
  object varios: TsnVarios
    Operacion = Operacion
    Left = 512
    Top = 70
  end
  object TArchivoPostulante: TsnTable
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
    Left = 305
    Top = 484
    object TArchivoPostulantenro_archivo: TIntegerField
      FieldName = 'nro_archivo'
    end
  end
  object TPuestoCandidato: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'oid_puesto'
        DataType = ftInteger
      end
      item
        Name = 'nombre_puesto'
        DataType = ftString
        Size = 200
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
    Left = 664
    Top = 369
    object TPuestoCandidatooid_puesto: TIntegerField
      FieldName = 'oid_puesto'
    end
    object TPuestoCandidatonombre_puesto: TStringField
      FieldName = 'nombre_puesto'
      Size = 200
    end
    object TPuestoCandidatooid_postulante: TIntegerField
      FieldName = 'oid_postulante'
    end
    object TPuestoCandidatonombre_postulante: TStringField
      FieldName = 'nombre_postulante'
      Size = 200
    end
  end
  object DSPuestoCandidato: TDataSource
    DataSet = TPuestoCandidato
    Left = 696
    Top = 369
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
    Left = 623
    Top = 316
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
    Left = 657
    Top = 316
    object IntegerField3: TIntegerField
      FieldName = 'oid'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object StringField7: TStringField
      FieldName = 'codigo'
      Size = 50
    end
    object StringField8: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
  end
  object DSTipoFormulario: TDataSource
    DataSet = TTipoFormulario
    Left = 691
    Top = 316
  end
  object TNombrePostu: TsnTable
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
    Left = 840
    Top = 369
    object TNombrePostuoid_postulante: TIntegerField
      FieldName = 'oid_postulante'
    end
    object TNombrePostunombre_postulante: TStringField
      FieldName = 'nombre_postulante'
      Size = 100
    end
  end
  object HelpOperacion: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'rs.RecluOperacion'
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
    Top = 578
  end
  object TRecluOperacion: TsnTable
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
    Top = 578
    object IntegerField4: TIntegerField
      FieldName = 'oid'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object StringField9: TStringField
      FieldName = 'codigo'
      Size = 50
    end
    object StringField10: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
  end
  object DSRecluOperacion: TDataSource
    DataSet = TRecluOperacion
    Left = 284
    Top = 579
  end
  object HelpSectores: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'rs.RecluSectores'
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
    Top = 618
  end
  object TRecluSectores: TsnTable
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
    Top = 618
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
  object DSRecluSectores: TDataSource
    DataSet = TRecluSectores
    Left = 284
    Top = 619
  end
  object HelpSelector: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'rs.RecluSelector'
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
    Top = 653
  end
  object TSelector: TsnTable
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
    Top = 653
    object IntegerField7: TIntegerField
      FieldName = 'oid'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object StringField13: TStringField
      FieldName = 'codigo'
      Size = 50
    end
    object StringField14: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
  end
  object DSTSelector: TDataSource
    DataSet = TSelector
    Left = 284
    Top = 654
  end
end
