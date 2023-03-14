inherited FPermisoSemanal: TFPermisoSemanal
  Left = 66
  Top = 57
  Width = 1012
  Height = 668
  Caption = 'Permiso Semanal'
  PixelsPerInch = 96
  TextHeight = 13
  inherited PForm: TPanel
    Width = 996
    Height = 630
    inherited PPie: TPanel
      Top = 609
      Width = 996
      inherited StatusBarABM: TStatusBar
        Left = 891
      end
      inherited StatusBar2: TStatusBar
        Width = 891
      end
    end
    inherited PMenu: TPanel
      Width = 996
      inherited ImagenEliminar: TImagenEstado
        DataField = 'activo'
        DataSource = DSTPermisoSemanalCIP
        ValorEstadoVisible = 'True'
      end
      inherited ImagenRehabilitar: TImagenEstado
        DataField = 'activo'
        DataSource = DSTPermisoSemanalCIP
        ValorEstadoVisible = 'False'
      end
      inherited ImagenBuscar: TImagenHelpObjNeg
        Help = HelpPermisoSemanal
      end
      inherited ImagenSiguiente: TImagenHelpObjNeg
        Help = HelpPermisoSemanal
      end
      inherited ImagenAnterior: TImagenHelpObjNeg
        Help = HelpPermisoSemanal
      end
      inherited Panel2: TPanel
        Left = 955
      end
      inherited PanelEstadoON: TPanelEstado
        DataField = 'activo'
        DataSource = DSTPermisoSemanalCIP
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
      Width = 996
    end
    inherited PCabecera: TPanel
      Width = 996
      Height = 309
      object Label1: TLabel
        Left = 52
        Top = 24
        Width = 33
        Height = 13
        Caption = 'C'#243'digo'
      end
      object Label2: TLabel
        Left = 52
        Top = 64
        Width = 56
        Height = 13
        Caption = 'Descripci'#243'n'
      end
      object snLabel3: TsnLabel
        Left = 138
        Top = 132
        Width = 89
        Height = 37
        Alignment = taCenter
        AutoSize = False
        Caption = 'Permiso'
        Color = 33023
        Font.Charset = DEFAULT_CHARSET
        Font.Color = clWindowText
        Font.Height = -13
        Font.Name = 'MS Sans Serif'
        Font.Style = []
        ParentColor = False
        ParentFont = False
      end
      object snLabel2: TsnLabel
        Left = 138
        Top = 112
        Width = 261
        Height = 20
        Alignment = taCenter
        AutoSize = False
        Caption = '                                   Entrada'
        Color = 33023
        Font.Charset = DEFAULT_CHARSET
        Font.Color = clWindowText
        Font.Height = -16
        Font.Name = 'MS Sans Serif'
        Font.Style = [fsBold]
        ParentColor = False
        ParentFont = False
      end
      object snLabel4: TsnLabel
        Left = 226
        Top = 132
        Width = 65
        Height = 18
        Alignment = taCenter
        AutoSize = False
        Caption = 'Hora'
        Color = 33023
        Font.Charset = DEFAULT_CHARSET
        Font.Color = clWindowText
        Font.Height = -13
        Font.Name = 'MS Sans Serif'
        Font.Style = []
        ParentColor = False
        ParentFont = False
      end
      object snLabel9: TsnLabel
        Left = 540
        Top = 132
        Width = 89
        Height = 37
        Alignment = taCenter
        AutoSize = False
        Caption = 'Permiso'
        Color = 16744576
        Font.Charset = DEFAULT_CHARSET
        Font.Color = clWindowText
        Font.Height = -13
        Font.Name = 'MS Sans Serif'
        Font.Style = []
        ParentColor = False
        ParentFont = False
      end
      object snLabel8: TsnLabel
        Left = 538
        Top = 112
        Width = 327
        Height = 20
        Alignment = taCenter
        AutoSize = False
        Caption = '                   Salida'
        Color = 16744576
        Font.Charset = DEFAULT_CHARSET
        Font.Color = clWindowText
        Font.Height = -16
        Font.Name = 'MS Sans Serif'
        Font.Style = [fsBold]
        ParentColor = False
        ParentFont = False
      end
      object snLabel13: TsnLabel
        Left = 691
        Top = 132
        Width = 110
        Height = 37
        Alignment = taCenter
        AutoSize = False
        Caption = 'Minutos Salida'
        Color = 16744576
        Font.Charset = DEFAULT_CHARSET
        Font.Color = clWindowText
        Font.Height = -13
        Font.Name = 'MS Sans Serif'
        Font.Style = []
        ParentColor = False
        ParentFont = False
      end
      object snLabel24: TsnLabel
        Left = 801
        Top = 133
        Width = 141
        Height = 35
        Alignment = taCenter
        AutoSize = False
        Caption = 'Leyenda No Egresa'
        Color = 16744576
        Font.Charset = DEFAULT_CHARSET
        Font.Color = clWindowText
        Font.Height = -13
        Font.Name = 'MS Sans Serif'
        Font.Style = []
        ParentColor = False
        ParentFont = False
        Transparent = False
      end
      object snLabel15: TsnLabel
        Left = 745
        Top = 151
        Width = 53
        Height = 17
        Alignment = taCenter
        AutoSize = False
        Caption = 'Despu'#233's'
        Color = 16744576
        Font.Charset = DEFAULT_CHARSET
        Font.Color = clWindowText
        Font.Height = -13
        Font.Name = 'MS Sans Serif'
        Font.Style = []
        ParentColor = False
        ParentFont = False
      end
      object snLabel14: TsnLabel
        Left = 696
        Top = 151
        Width = 49
        Height = 17
        Alignment = taCenter
        AutoSize = False
        Caption = 'Antes'
        Color = 16744576
        Font.Charset = DEFAULT_CHARSET
        Font.Color = clWindowText
        Font.Height = -13
        Font.Name = 'MS Sans Serif'
        Font.Style = []
        ParentColor = False
        ParentFont = False
      end
      object snLabel12: TsnLabel
        Left = 628
        Top = 151
        Width = 65
        Height = 16
        Alignment = taCenter
        AutoSize = False
        Caption = 'Salida'
        Color = 16744576
        Font.Charset = DEFAULT_CHARSET
        Font.Color = clWindowText
        Font.Height = -13
        Font.Name = 'MS Sans Serif'
        Font.Style = []
        ParentColor = False
        ParentFont = False
      end
      object snLabel10: TsnLabel
        Left = 628
        Top = 132
        Width = 65
        Height = 19
        Alignment = taCenter
        AutoSize = False
        Caption = 'Hora'
        Color = 16744576
        Font.Charset = DEFAULT_CHARSET
        Font.Color = clWindowText
        Font.Height = -13
        Font.Name = 'MS Sans Serif'
        Font.Style = []
        ParentColor = False
        ParentFont = False
      end
      object snLabel7: TsnLabel
        Left = 344
        Top = 151
        Width = 53
        Height = 17
        Alignment = taCenter
        AutoSize = False
        Caption = 'Despu'#233's'
        Color = 33023
        Font.Charset = DEFAULT_CHARSET
        Font.Color = clWindowText
        Font.Height = -13
        Font.Name = 'MS Sans Serif'
        Font.Style = []
        ParentColor = False
        ParentFont = False
      end
      object snLabel6: TsnLabel
        Left = 290
        Top = 151
        Width = 49
        Height = 17
        Alignment = taCenter
        AutoSize = False
        Caption = 'Antes'
        Color = 33023
        Font.Charset = DEFAULT_CHARSET
        Font.Color = clWindowText
        Font.Height = -13
        Font.Name = 'MS Sans Serif'
        Font.Style = []
        ParentColor = False
        ParentFont = False
      end
      object snLabel11: TsnLabel
        Left = 226
        Top = 150
        Width = 65
        Height = 18
        Alignment = taCenter
        AutoSize = False
        Caption = 'Entrada'
        Color = 33023
        Font.Charset = DEFAULT_CHARSET
        Font.Color = clWindowText
        Font.Height = -13
        Font.Name = 'MS Sans Serif'
        Font.Style = []
        ParentColor = False
        ParentFont = False
      end
      object snLabel22: TsnLabel
        Left = 399
        Top = 132
        Width = 141
        Height = 35
        Alignment = taCenter
        AutoSize = False
        Caption = 'Leyenda No Ingresa'
        Color = 33023
        Font.Charset = DEFAULT_CHARSET
        Font.Color = clWindowText
        Font.Height = -13
        Font.Name = 'MS Sans Serif'
        Font.Style = []
        ParentColor = False
        ParentFont = False
      end
      object snLabel5: TsnLabel
        Left = 287
        Top = 132
        Width = 113
        Height = 37
        Alignment = taCenter
        AutoSize = False
        Caption = 'Minutos Entrada'
        Color = 33023
        Font.Charset = DEFAULT_CHARSET
        Font.Color = clWindowText
        Font.Height = -13
        Font.Name = 'MS Sans Serif'
        Font.Style = []
        ParentColor = False
        ParentFont = False
      end
      object snLabel1: TsnLabel
        Left = 42
        Top = 167
        Width = 97
        Height = 19
        AutoSize = False
        Caption = '   Lunes'
        Color = clInfoBk
        Font.Charset = DEFAULT_CHARSET
        Font.Color = clWindowText
        Font.Height = -13
        Font.Name = 'MS Sans Serif'
        Font.Style = [fsBold]
        ParentColor = False
        ParentFont = False
      end
      object snLabel16: TsnLabel
        Left = 42
        Top = 186
        Width = 97
        Height = 19
        AutoSize = False
        Caption = '   Martes'
        Color = 14540253
        Font.Charset = DEFAULT_CHARSET
        Font.Color = clWindowText
        Font.Height = -13
        Font.Name = 'MS Sans Serif'
        Font.Style = [fsBold]
        ParentColor = False
        ParentFont = False
      end
      object snLabel17: TsnLabel
        Left = 42
        Top = 205
        Width = 97
        Height = 19
        AutoSize = False
        Caption = '   Mi'#233'rcoles'
        Color = clInfoBk
        Font.Charset = DEFAULT_CHARSET
        Font.Color = clWindowText
        Font.Height = -13
        Font.Name = 'MS Sans Serif'
        Font.Style = [fsBold]
        ParentColor = False
        ParentFont = False
      end
      object snLabel18: TsnLabel
        Left = 42
        Top = 224
        Width = 97
        Height = 19
        AutoSize = False
        Caption = '   Jueves'
        Color = 14540253
        Font.Charset = DEFAULT_CHARSET
        Font.Color = clWindowText
        Font.Height = -13
        Font.Name = 'MS Sans Serif'
        Font.Style = [fsBold]
        ParentColor = False
        ParentFont = False
      end
      object snLabel19: TsnLabel
        Left = 42
        Top = 243
        Width = 97
        Height = 19
        AutoSize = False
        Caption = '   Viernes'
        Color = clInfoBk
        Font.Charset = DEFAULT_CHARSET
        Font.Color = clWindowText
        Font.Height = -13
        Font.Name = 'MS Sans Serif'
        Font.Style = [fsBold]
        ParentColor = False
        ParentFont = False
      end
      object snLabel20: TsnLabel
        Left = 42
        Top = 262
        Width = 97
        Height = 19
        AutoSize = False
        Caption = '   S'#225'bado'
        Color = 14540253
        Font.Charset = DEFAULT_CHARSET
        Font.Color = clWindowText
        Font.Height = -13
        Font.Name = 'MS Sans Serif'
        Font.Style = [fsBold]
        ParentColor = False
        ParentFont = False
      end
      object snLabel21: TsnLabel
        Left = 43
        Top = 281
        Width = 97
        Height = 19
        AutoSize = False
        Caption = '   Domingo'
        Color = clInfoBk
        Font.Charset = DEFAULT_CHARSET
        Font.Color = clWindowText
        Font.Height = -13
        Font.Name = 'MS Sans Serif'
        Font.Style = [fsBold]
        ParentColor = False
        ParentFont = False
      end
      object snLabel23: TsnLabel
        Left = 399
        Top = 112
        Width = 141
        Height = 20
        Alignment = taCenter
        AutoSize = False
        Color = 33023
        Font.Charset = DEFAULT_CHARSET
        Font.Color = clWindowText
        Font.Height = -13
        Font.Name = 'MS Sans Serif'
        Font.Style = []
        ParentColor = False
        ParentFont = False
      end
      object snLabel25: TsnLabel
        Left = 801
        Top = 112
        Width = 141
        Height = 21
        Alignment = taCenter
        AutoSize = False
        Color = 16744576
        Font.Charset = DEFAULT_CHARSET
        Font.Color = clWindowText
        Font.Height = -13
        Font.Name = 'MS Sans Serif'
        Font.Style = []
        ParentColor = False
        ParentFont = False
      end
      object snLabel26: TsnLabel
        Left = 294
        Top = 149
        Width = 49
        Height = 17
        Alignment = taCenter
        AutoSize = False
        Caption = 'Antes'
        Color = 33023
        Font.Charset = DEFAULT_CHARSET
        Font.Color = clWindowText
        Font.Height = -13
        Font.Name = 'MS Sans Serif'
        Font.Style = []
        ParentColor = False
        ParentFont = False
      end
      object snLabel27: TsnLabel
        Left = 345
        Top = 149
        Width = 53
        Height = 17
        Alignment = taCenter
        AutoSize = False
        Caption = 'Despu'#233's'
        Color = 33023
        Font.Charset = DEFAULT_CHARSET
        Font.Color = clWindowText
        Font.Height = -13
        Font.Name = 'MS Sans Serif'
        Font.Style = []
        ParentColor = False
        ParentFont = False
      end
      object DBECodigo: TsnDBEdit
        Left = 136
        Top = 20
        DataBinding.DataField = 'codigo'
        DataBinding.DataSource = DSTPermisoSemanalCIP
        Properties.CharCase = ecUpperCase
        Properties.MaxLength = 50
        Style.BorderColor = clWindowFrame
        Style.Shadow = False
        TabOrder = 0
        Width = 181
      end
      object snDBEdit1: TsnDBEdit
        Left = 136
        Top = 60
        DataBinding.DataField = 'descripcion'
        DataBinding.DataSource = DSTPermisoSemanalCIP
        Properties.MaxLength = 100
        Style.BorderColor = clWindowFrame
        Style.Shadow = False
        TabOrder = 1
        Width = 429
      end
      object snDBLookup13: TsnDBLookup
        Left = 137
        Top = 280
        DataBinding.DataField = 'tipo_per_ent_dom'
        DataBinding.DataSource = DSTPermisoSemanalCIP
        Properties.KeyFieldNames = 'codigo'
        Properties.ListColumns = <
          item
            FieldName = 'descripcion'
          end>
        Properties.ListOptions.ShowHeader = False
        Properties.ListSource = DSTiposEntradas
        Style.Color = clInfoBk
        TabOrder = 2
        Width = 91
      end
      object snDBLookup11: TsnDBLookup
        Left = 137
        Top = 261
        DataBinding.DataField = 'tipo_per_ent_sab'
        DataBinding.DataSource = DSTPermisoSemanalCIP
        Properties.KeyFieldNames = 'codigo'
        Properties.ListColumns = <
          item
            FieldName = 'descripcion'
          end>
        Properties.ListOptions.ShowHeader = False
        Properties.ListSource = DSTiposEntradas
        Style.Color = 14540253
        TabOrder = 3
        Width = 91
      end
      object snDBLookup9: TsnDBLookup
        Left = 137
        Top = 242
        DataBinding.DataField = 'tipo_per_ent_vie'
        DataBinding.DataSource = DSTPermisoSemanalCIP
        Properties.KeyFieldNames = 'codigo'
        Properties.ListColumns = <
          item
            FieldName = 'descripcion'
          end>
        Properties.ListOptions.ShowHeader = False
        Properties.ListSource = DSTiposEntradas
        Style.Color = clInfoBk
        TabOrder = 4
        Width = 91
      end
      object snDBLookup7: TsnDBLookup
        Left = 137
        Top = 223
        DataBinding.DataField = 'tipo_per_ent_jue'
        DataBinding.DataSource = DSTPermisoSemanalCIP
        Properties.KeyFieldNames = 'codigo'
        Properties.ListColumns = <
          item
            FieldName = 'descripcion'
          end>
        Properties.ListOptions.ShowHeader = False
        Properties.ListSource = DSTiposEntradas
        Style.Color = 14540253
        TabOrder = 5
        Width = 91
      end
      object snDBLookup5: TsnDBLookup
        Left = 137
        Top = 204
        DataBinding.DataField = 'tipo_per_ent_mie'
        DataBinding.DataSource = DSTPermisoSemanalCIP
        Properties.KeyFieldNames = 'codigo'
        Properties.ListColumns = <
          item
            FieldName = 'descripcion'
          end>
        Properties.ListOptions.ShowHeader = False
        Properties.ListSource = DSTiposEntradas
        Style.Color = clInfoBk
        TabOrder = 6
        Width = 91
      end
      object snDBLookup3: TsnDBLookup
        Left = 137
        Top = 185
        DataBinding.DataField = 'tipo_per_ent_mar'
        DataBinding.DataSource = DSTPermisoSemanalCIP
        Properties.KeyFieldNames = 'codigo'
        Properties.ListColumns = <
          item
            FieldName = 'descripcion'
          end>
        Properties.ListOptions.ShowHeader = False
        Properties.ListSource = DSTiposEntradas
        Style.Color = 14540253
        TabOrder = 7
        Width = 91
      end
      object snDBLookup1: TsnDBLookup
        Left = 137
        Top = 166
        DataBinding.DataField = 'tipo_per_ent_lun'
        DataBinding.DataSource = DSTPermisoSemanalCIP
        Properties.KeyFieldNames = 'codigo'
        Properties.ListColumns = <
          item
            FieldName = 'descripcion'
          end>
        Properties.ListOptions.ShowHeader = False
        Properties.ListSource = DSTiposEntradas
        Style.Color = clInfoBk
        TabOrder = 8
        Width = 91
      end
      object snDBMaskEdit1: TsnDBMaskEdit
        Left = 225
        Top = 166
        DataBinding.DataField = 'ent_hora_lun'
        DataBinding.DataSource = DSTPermisoSemanalCIP
        Properties.EditMask = '!90:00;1;_'
        Properties.MaxLength = 0
        Style.Color = clInfoBk
        TabOrder = 9
        Width = 67
      end
      object snDBEdit3: TsnDBEdit
        Left = 289
        Top = 166
        DataBinding.DataField = 'min_ent_ant_lun'
        DataBinding.DataSource = DSTPermisoSemanalCIP
        Style.Color = clInfoBk
        TabOrder = 10
        Width = 57
      end
      object snDBEdit4: TsnDBEdit
        Left = 343
        Top = 166
        DataBinding.DataField = 'min_ent_des_lun'
        DataBinding.DataSource = DSTPermisoSemanalCIP
        Style.Color = clInfoBk
        TabOrder = 11
        Width = 57
      end
      object snDBEdit30: TsnDBEdit
        Left = 397
        Top = 166
        DataBinding.DataField = 'lun_ley_no_ing'
        DataBinding.DataSource = DSTPermisoSemanalCIP
        TabOrder = 12
        Width = 145
      end
      object snDBLookup2: TsnDBLookup
        Left = 539
        Top = 166
        DataBinding.DataField = 'tipo_per_sal_lun'
        DataBinding.DataSource = DSTPermisoSemanalCIP
        Properties.KeyFieldNames = 'codigo'
        Properties.ListColumns = <
          item
            FieldName = 'descripcion'
          end>
        Properties.ListOptions.ShowHeader = False
        Properties.ListSource = DSTiposSalidas
        Style.Color = clInfoBk
        TabOrder = 13
        Width = 91
      end
      object snDBMaskEdit2: TsnDBMaskEdit
        Left = 627
        Top = 166
        DataBinding.DataField = 'sal_hora_lun'
        DataBinding.DataSource = DSTPermisoSemanalCIP
        Properties.EditMask = '!90:00;1;_'
        Properties.MaxLength = 0
        Style.Color = clInfoBk
        TabOrder = 14
        Width = 67
      end
      object snDBEdit6: TsnDBEdit
        Left = 691
        Top = 166
        DataBinding.DataField = 'min_sal_ant_lun'
        DataBinding.DataSource = DSTPermisoSemanalCIP
        Style.Color = clInfoBk
        TabOrder = 15
        Width = 57
      end
      object snDBEdit7: TsnDBEdit
        Left = 745
        Top = 166
        DataBinding.DataField = 'min_sal_des_lun'
        DataBinding.DataSource = DSTPermisoSemanalCIP
        Style.Color = clInfoBk
        TabOrder = 16
        Width = 57
      end
      object snDBEdit37: TsnDBEdit
        Left = 799
        Top = 166
        DataBinding.DataField = 'lun_ley_no_egr'
        DataBinding.DataSource = DSTPermisoSemanalCIP
        TabOrder = 17
        Width = 145
      end
      object snDBEdit38: TsnDBEdit
        Left = 799
        Top = 185
        DataBinding.DataField = 'mar_ley_no_egr'
        DataBinding.DataSource = DSTPermisoSemanalCIP
        TabOrder = 18
        Width = 145
      end
      object snDBEdit9: TsnDBEdit
        Left = 745
        Top = 185
        DataBinding.DataField = 'min_sal_des_mar'
        DataBinding.DataSource = DSTPermisoSemanalCIP
        Style.Color = 14540253
        TabOrder = 19
        Width = 57
      end
      object snDBEdit8: TsnDBEdit
        Left = 691
        Top = 185
        DataBinding.DataField = 'min_sal_ant_mar'
        DataBinding.DataSource = DSTPermisoSemanalCIP
        Style.Color = 14540253
        TabOrder = 20
        Width = 57
      end
      object snDBMaskEdit4: TsnDBMaskEdit
        Left = 627
        Top = 185
        DataBinding.DataField = 'sal_hora_mar'
        DataBinding.DataSource = DSTPermisoSemanalCIP
        Properties.EditMask = '!90:00;1;_'
        Properties.MaxLength = 0
        Style.Color = 14540253
        TabOrder = 21
        Width = 67
      end
      object snDBLookup4: TsnDBLookup
        Left = 539
        Top = 185
        DataBinding.DataField = 'tipo_per_sal_mar'
        DataBinding.DataSource = DSTPermisoSemanalCIP
        Properties.KeyFieldNames = 'codigo'
        Properties.ListColumns = <
          item
            FieldName = 'descripcion'
          end>
        Properties.ListOptions.ShowHeader = False
        Properties.ListSource = DSTiposSalidas
        Style.Color = 14540253
        TabOrder = 22
        Width = 91
      end
      object snDBEdit31: TsnDBEdit
        Left = 397
        Top = 185
        DataBinding.DataField = 'mar_ley_no_ing'
        DataBinding.DataSource = DSTPermisoSemanalCIP
        TabOrder = 23
        Width = 145
      end
      object snDBMaskEdit3: TsnDBMaskEdit
        Left = 225
        Top = 185
        DataBinding.DataField = 'ent_hora_mar'
        DataBinding.DataSource = DSTPermisoSemanalCIP
        Properties.EditMask = '!90:00;1;_'
        Properties.MaxLength = 0
        Style.Color = 14540253
        TabOrder = 24
        Width = 67
      end
      object snDBEdit2: TsnDBEdit
        Left = 289
        Top = 185
        DataBinding.DataField = 'min_ent_ant_mar'
        DataBinding.DataSource = DSTPermisoSemanalCIP
        Style.Color = 14540253
        TabOrder = 25
        Width = 57
      end
      object snDBEdit5: TsnDBEdit
        Left = 343
        Top = 185
        DataBinding.DataField = 'min_ent_des_mar'
        DataBinding.DataSource = DSTPermisoSemanalCIP
        Style.Color = 14540253
        TabOrder = 26
        Width = 57
      end
      object snDBEdit32: TsnDBEdit
        Left = 397
        Top = 204
        DataBinding.DataField = 'mie_ley_no_ing'
        DataBinding.DataSource = DSTPermisoSemanalCIP
        TabOrder = 27
        Width = 145
      end
      object snDBEdit11: TsnDBEdit
        Left = 343
        Top = 204
        DataBinding.DataField = 'min_ent_des_mie'
        DataBinding.DataSource = DSTPermisoSemanalCIP
        Style.Color = clInfoBk
        TabOrder = 28
        Width = 57
      end
      object snDBEdit10: TsnDBEdit
        Left = 289
        Top = 204
        DataBinding.DataField = 'min_ent_ant_mie'
        DataBinding.DataSource = DSTPermisoSemanalCIP
        Style.Color = clInfoBk
        TabOrder = 29
        Width = 57
      end
      object snDBMaskEdit5: TsnDBMaskEdit
        Left = 225
        Top = 204
        DataBinding.DataField = 'ent_hora_mie'
        DataBinding.DataSource = DSTPermisoSemanalCIP
        Properties.EditMask = '!90:00;1;_'
        Properties.MaxLength = 0
        Style.Color = clInfoBk
        TabOrder = 30
        Width = 67
      end
      object snDBLookup6: TsnDBLookup
        Left = 539
        Top = 204
        DataBinding.DataField = 'tipo_per_sal_mie'
        DataBinding.DataSource = DSTPermisoSemanalCIP
        Properties.KeyFieldNames = 'codigo'
        Properties.ListColumns = <
          item
            FieldName = 'descripcion'
          end>
        Properties.ListOptions.ShowHeader = False
        Properties.ListSource = DSTiposSalidas
        Style.Color = clInfoBk
        TabOrder = 31
        Width = 91
      end
      object snDBMaskEdit6: TsnDBMaskEdit
        Left = 627
        Top = 204
        DataBinding.DataField = 'sal_hora_mie'
        DataBinding.DataSource = DSTPermisoSemanalCIP
        Properties.EditMask = '!90:00;1;_'
        Properties.MaxLength = 0
        Style.Color = clInfoBk
        TabOrder = 32
        Width = 67
      end
      object snDBEdit12: TsnDBEdit
        Left = 691
        Top = 204
        DataBinding.DataField = 'min_sal_ant_mie'
        DataBinding.DataSource = DSTPermisoSemanalCIP
        Style.Color = clInfoBk
        TabOrder = 33
        Width = 57
      end
      object snDBEdit13: TsnDBEdit
        Left = 745
        Top = 204
        DataBinding.DataField = 'min_sal_des_mie'
        DataBinding.DataSource = DSTPermisoSemanalCIP
        Style.Color = clInfoBk
        TabOrder = 34
        Width = 57
      end
      object snDBEdit39: TsnDBEdit
        Left = 799
        Top = 204
        DataBinding.DataField = 'mie_ley_no_egr'
        DataBinding.DataSource = DSTPermisoSemanalCIP
        TabOrder = 35
        Width = 145
      end
      object snDBEdit40: TsnDBEdit
        Left = 799
        Top = 223
        DataBinding.DataField = 'jue_ley_no_egr'
        DataBinding.DataSource = DSTPermisoSemanalCIP
        TabOrder = 36
        Width = 145
      end
      object snDBEdit17: TsnDBEdit
        Left = 745
        Top = 223
        DataBinding.DataField = 'min_sal_des_jue'
        DataBinding.DataSource = DSTPermisoSemanalCIP
        Style.Color = 14540253
        TabOrder = 37
        Width = 57
      end
      object snDBEdit16: TsnDBEdit
        Left = 691
        Top = 223
        DataBinding.DataField = 'min_sal_ant_jue'
        DataBinding.DataSource = DSTPermisoSemanalCIP
        Style.Color = 14540253
        TabOrder = 38
        Width = 57
      end
      object snDBMaskEdit8: TsnDBMaskEdit
        Left = 627
        Top = 223
        DataBinding.DataField = 'sal_hora_jue'
        DataBinding.DataSource = DSTPermisoSemanalCIP
        Properties.EditMask = '!90:00;1;_'
        Properties.MaxLength = 0
        Style.Color = 14540253
        TabOrder = 39
        Width = 67
      end
      object snDBLookup8: TsnDBLookup
        Left = 539
        Top = 223
        DataBinding.DataField = 'tipo_per_sal_jue'
        DataBinding.DataSource = DSTPermisoSemanalCIP
        Properties.KeyFieldNames = 'codigo'
        Properties.ListColumns = <
          item
            FieldName = 'descripcion'
          end>
        Properties.ListOptions.ShowHeader = False
        Properties.ListSource = DSTiposSalidas
        Style.Color = 14540253
        TabOrder = 40
        Width = 91
      end
      object snDBEdit33: TsnDBEdit
        Left = 397
        Top = 223
        DataBinding.DataField = 'jue_ley_no_ing'
        DataBinding.DataSource = DSTPermisoSemanalCIP
        TabOrder = 41
        Width = 145
      end
      object snDBEdit15: TsnDBEdit
        Left = 343
        Top = 223
        DataBinding.DataField = 'min_ent_des_jue'
        DataBinding.DataSource = DSTPermisoSemanalCIP
        Style.Color = 14540253
        TabOrder = 42
        Width = 57
      end
      object snDBEdit14: TsnDBEdit
        Left = 289
        Top = 223
        DataBinding.DataField = 'min_ent_ant_jue'
        DataBinding.DataSource = DSTPermisoSemanalCIP
        Style.Color = 14540253
        TabOrder = 43
        Width = 57
      end
      object snDBMaskEdit7: TsnDBMaskEdit
        Left = 225
        Top = 223
        DataBinding.DataField = 'ent_hora_jue'
        DataBinding.DataSource = DSTPermisoSemanalCIP
        Properties.EditMask = '!90:00;1;_'
        Properties.MaxLength = 0
        Style.Color = 14540253
        TabOrder = 44
        Width = 67
      end
      object snDBMaskEdit9: TsnDBMaskEdit
        Left = 225
        Top = 242
        DataBinding.DataField = 'ent_hora_vie'
        DataBinding.DataSource = DSTPermisoSemanalCIP
        Properties.EditMask = '!90:00;1;_'
        Properties.MaxLength = 0
        Style.Color = clInfoBk
        TabOrder = 45
        Width = 67
      end
      object snDBEdit18: TsnDBEdit
        Left = 289
        Top = 242
        DataBinding.DataField = 'min_ent_ant_vie'
        DataBinding.DataSource = DSTPermisoSemanalCIP
        Style.Color = clInfoBk
        TabOrder = 46
        Width = 57
      end
      object snDBEdit19: TsnDBEdit
        Left = 343
        Top = 242
        DataBinding.DataField = 'min_ent_des_vie'
        DataBinding.DataSource = DSTPermisoSemanalCIP
        Style.Color = clInfoBk
        TabOrder = 47
        Width = 57
      end
      object snDBEdit34: TsnDBEdit
        Left = 397
        Top = 242
        DataBinding.DataField = 'vie_ley_no_ing'
        DataBinding.DataSource = DSTPermisoSemanalCIP
        TabOrder = 48
        Width = 145
      end
      object snDBLookup10: TsnDBLookup
        Left = 539
        Top = 242
        DataBinding.DataField = 'tipo_per_sal_vie'
        DataBinding.DataSource = DSTPermisoSemanalCIP
        Properties.KeyFieldNames = 'codigo'
        Properties.ListColumns = <
          item
            FieldName = 'descripcion'
          end>
        Properties.ListOptions.ShowHeader = False
        Properties.ListSource = DSTiposSalidas
        Style.Color = clInfoBk
        TabOrder = 49
        Width = 91
      end
      object snDBMaskEdit10: TsnDBMaskEdit
        Left = 627
        Top = 242
        DataBinding.DataField = 'sal_hora_vie'
        DataBinding.DataSource = DSTPermisoSemanalCIP
        Properties.EditMask = '!90:00;1;_'
        Properties.MaxLength = 0
        Style.Color = clInfoBk
        TabOrder = 50
        Width = 67
      end
      object snDBEdit20: TsnDBEdit
        Left = 691
        Top = 242
        DataBinding.DataField = 'min_sal_ant_vie'
        DataBinding.DataSource = DSTPermisoSemanalCIP
        Style.Color = clInfoBk
        TabOrder = 51
        Width = 57
      end
      object snDBEdit21: TsnDBEdit
        Left = 745
        Top = 242
        DataBinding.DataField = 'min_sal_des_vie'
        DataBinding.DataSource = DSTPermisoSemanalCIP
        Style.Color = clInfoBk
        TabOrder = 52
        Width = 57
      end
      object snDBEdit41: TsnDBEdit
        Left = 799
        Top = 242
        DataBinding.DataField = 'vie_ley_no_egr'
        DataBinding.DataSource = DSTPermisoSemanalCIP
        TabOrder = 53
        Width = 145
      end
      object snDBEdit42: TsnDBEdit
        Left = 799
        Top = 261
        DataBinding.DataField = 'sab_ley_no_egr'
        DataBinding.DataSource = DSTPermisoSemanalCIP
        TabOrder = 54
        Width = 145
      end
      object snDBEdit43: TsnDBEdit
        Left = 799
        Top = 280
        DataBinding.DataField = 'dom_ley_no_egr'
        DataBinding.DataSource = DSTPermisoSemanalCIP
        TabOrder = 55
        Width = 145
      end
      object snDBEdit29: TsnDBEdit
        Left = 745
        Top = 280
        DataBinding.DataField = 'min_sal_des_dom'
        DataBinding.DataSource = DSTPermisoSemanalCIP
        Style.Color = clInfoBk
        TabOrder = 56
        Width = 57
      end
      object snDBEdit25: TsnDBEdit
        Left = 745
        Top = 261
        DataBinding.DataField = 'min_sal_des_sab'
        DataBinding.DataSource = DSTPermisoSemanalCIP
        Style.Color = 14540253
        TabOrder = 57
        Width = 57
      end
      object snDBEdit24: TsnDBEdit
        Left = 691
        Top = 261
        DataBinding.DataField = 'min_sal_ant_sab'
        DataBinding.DataSource = DSTPermisoSemanalCIP
        Style.Color = 14540253
        TabOrder = 58
        Width = 57
      end
      object snDBEdit28: TsnDBEdit
        Left = 691
        Top = 280
        DataBinding.DataField = 'min_sal_ant_dom'
        DataBinding.DataSource = DSTPermisoSemanalCIP
        Style.Color = clInfoBk
        TabOrder = 59
        Width = 57
      end
      object snDBMaskEdit14: TsnDBMaskEdit
        Left = 627
        Top = 280
        DataBinding.DataField = 'sal_hora_dom'
        DataBinding.DataSource = DSTPermisoSemanalCIP
        Properties.EditMask = '!90:00;1;_'
        Properties.MaxLength = 0
        Style.Color = clInfoBk
        TabOrder = 60
        Width = 67
      end
      object snDBMaskEdit12: TsnDBMaskEdit
        Left = 627
        Top = 261
        DataBinding.DataField = 'sal_hora_sab'
        DataBinding.DataSource = DSTPermisoSemanalCIP
        Properties.EditMask = '!90:00;1;_'
        Properties.MaxLength = 0
        Style.Color = 14540253
        TabOrder = 61
        Width = 67
      end
      object snDBLookup12: TsnDBLookup
        Left = 539
        Top = 261
        DataBinding.DataField = 'tipo_per_sal_sab'
        DataBinding.DataSource = DSTPermisoSemanalCIP
        Properties.KeyFieldNames = 'codigo'
        Properties.ListColumns = <
          item
            FieldName = 'descripcion'
          end>
        Properties.ListOptions.ShowHeader = False
        Properties.ListSource = DSTiposSalidas
        Style.Color = 14540253
        TabOrder = 62
        Width = 91
      end
      object snDBLookup14: TsnDBLookup
        Left = 539
        Top = 280
        DataBinding.DataField = 'tipo_per_sal_dom'
        DataBinding.DataSource = DSTPermisoSemanalCIP
        Properties.KeyFieldNames = 'codigo'
        Properties.ListColumns = <
          item
            FieldName = 'descripcion'
          end>
        Properties.ListOptions.ShowHeader = False
        Properties.ListSource = DSTiposSalidas
        Style.Color = clInfoBk
        TabOrder = 63
        Width = 91
      end
      object snDBEdit36: TsnDBEdit
        Left = 396
        Top = 280
        DataBinding.DataField = 'dom_ley_no_ing'
        DataBinding.DataSource = DSTPermisoSemanalCIP
        TabOrder = 64
        Width = 146
      end
      object snDBEdit35: TsnDBEdit
        Left = 397
        Top = 261
        DataBinding.DataField = 'sab_ley_no_ing'
        DataBinding.DataSource = DSTPermisoSemanalCIP
        TabOrder = 65
        Width = 145
      end
      object snDBEdit23: TsnDBEdit
        Left = 343
        Top = 261
        DataBinding.DataField = 'min_ent_des_sab'
        DataBinding.DataSource = DSTPermisoSemanalCIP
        Style.Color = 14540253
        TabOrder = 66
        Width = 57
      end
      object snDBEdit27: TsnDBEdit
        Left = 343
        Top = 280
        DataBinding.DataField = 'min_ent_des_dom'
        DataBinding.DataSource = DSTPermisoSemanalCIP
        Style.Color = clInfoBk
        TabOrder = 67
        Width = 57
      end
      object snDBEdit26: TsnDBEdit
        Left = 289
        Top = 280
        DataBinding.DataField = 'min_ent_ant_dom'
        DataBinding.DataSource = DSTPermisoSemanalCIP
        Style.Color = clInfoBk
        TabOrder = 68
        Width = 57
      end
      object snDBEdit22: TsnDBEdit
        Left = 289
        Top = 261
        DataBinding.DataField = 'min_ent_ant_sab'
        DataBinding.DataSource = DSTPermisoSemanalCIP
        Style.Color = 14540253
        TabOrder = 69
        Width = 57
      end
      object snDBMaskEdit11: TsnDBMaskEdit
        Left = 225
        Top = 261
        DataBinding.DataField = 'ent_hora_sab'
        DataBinding.DataSource = DSTPermisoSemanalCIP
        Properties.EditMask = '!90:00;1;_'
        Properties.MaxLength = 0
        Style.Color = 14540253
        TabOrder = 70
        Width = 67
      end
      object snDBMaskEdit13: TsnDBMaskEdit
        Left = 225
        Top = 280
        DataBinding.DataField = 'ent_hora_dom'
        DataBinding.DataSource = DSTPermisoSemanalCIP
        Properties.EditMask = '!90:00;1;_'
        Properties.MaxLength = 0
        Style.Color = clInfoBk
        TabOrder = 71
        Width = 67
      end
    end
    inherited PCuerpo: TPanel
      Top = 361
      Width = 996
      Height = 248
      BorderWidth = 15
      object PageControlSN1: TPageControlSN
        Left = 15
        Top = 15
        Width = 966
        Height = 218
        ActivePage = TabSheet2
        Align = alClient
        TabOrder = 0
        object TabSheet2: TTabSheet
          Caption = 'Entradas Intermedias'
          ImageIndex = 1
          object PageControlSN2: TPageControlSN
            Left = 0
            Top = 0
            Width = 958
            Height = 190
            ActivePage = TabSheet1
            Align = alClient
            TabOrder = 0
            object TabSheet1: TTabSheet
              Caption = 'Lunes'
              object dxDBGridSN1: TdxDBGridSN
                Left = 0
                Top = 0
                Width = 950
                Height = 162
                Align = alClient
                TabOrder = 0
                LookAndFeel.Kind = lfFlat
                CriteriosPintarCelda = <>
                object cxGridDBTableView1: TcxGridDBTableView
                  NavigatorButtons.ConfirmDelete = False
                  DataController.DataSource = DSMotivoEntradasInterLUN
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
                  object cxGridDBTableView1oid_motivo: TcxGridDBColumn
                    Caption = 'Motivo'
                    DataBinding.FieldName = 'oid_motivo'
                    PropertiesClassName = 'TcxLookupComboBoxProperties'
                    Properties.KeyFieldNames = 'oid'
                    Properties.ListColumns = <
                      item
                        FieldName = 'descripcion'
                      end>
                    Properties.ListOptions.ShowHeader = False
                    Properties.ListSource = DSMotivos
                    HeaderAlignmentHorz = taCenter
                    Width = 187
                  end
                  object cxGridDBTableView1horario_desde: TcxGridDBColumn
                    Caption = 'Hora Desde'
                    DataBinding.FieldName = 'horario_desde'
                    HeaderAlignmentHorz = taCenter
                    Width = 82
                  end
                  object cxGridDBTableView1horario_hasta: TcxGridDBColumn
                    Caption = 'Hora Hasta'
                    DataBinding.FieldName = 'horario_hasta'
                    HeaderAlignmentHorz = taCenter
                    Width = 87
                  end
                  object cxGridDBTableView1Column1: TcxGridDBColumn
                    Caption = 'Acceso'
                    DataBinding.FieldName = 'asignacion'
                    PropertiesClassName = 'TcxLookupComboBoxProperties'
                    Properties.KeyFieldNames = 'codigo'
                    Properties.ListColumns = <
                      item
                        FieldName = 'descripcion'
                      end>
                    Properties.ListOptions.ShowHeader = False
                    Properties.ListSource = DSTCompoEntInter
                    HeaderAlignmentHorz = taCenter
                    Width = 200
                  end
                  object cxGridDBTableView1activo: TcxGridDBColumn
                    Caption = 'Activo'
                    DataBinding.FieldName = 'activo'
                    PropertiesClassName = 'TcxCheckBoxProperties'
                    HeaderAlignmentHorz = taCenter
                    Width = 52
                  end
                end
                object cxGridLevel1: TcxGridLevel
                  GridView = cxGridDBTableView1
                end
              end
            end
            object TabSheet3: TTabSheet
              Caption = 'Martes'
              ImageIndex = 1
              object dxDBGridSN2: TdxDBGridSN
                Left = 0
                Top = 0
                Width = 950
                Height = 162
                Align = alClient
                TabOrder = 0
                LookAndFeel.Kind = lfFlat
                CriteriosPintarCelda = <>
                object cxGridDBTableView2: TcxGridDBTableView
                  NavigatorButtons.ConfirmDelete = False
                  DataController.DataSource = dsTMotivoEntradasInterMAR
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
                  object cxGridDBColumn1: TcxGridDBColumn
                    Caption = 'Motivo'
                    DataBinding.FieldName = 'oid_motivo'
                    PropertiesClassName = 'TcxLookupComboBoxProperties'
                    Properties.KeyFieldNames = 'oid'
                    Properties.ListColumns = <
                      item
                        FieldName = 'descripcion'
                      end>
                    Properties.ListOptions.ShowHeader = False
                    Properties.ListSource = DSMotivos
                    HeaderAlignmentHorz = taCenter
                    Width = 187
                  end
                  object cxGridDBColumn2: TcxGridDBColumn
                    Caption = 'Hora Desde'
                    DataBinding.FieldName = 'horario_desde'
                    HeaderAlignmentHorz = taCenter
                    Width = 82
                  end
                  object cxGridDBColumn3: TcxGridDBColumn
                    Caption = 'Hora Hasta'
                    DataBinding.FieldName = 'horario_hasta'
                    HeaderAlignmentHorz = taCenter
                    Width = 87
                  end
                  object cxGridDBColumn4: TcxGridDBColumn
                    Caption = 'Acceso'
                    DataBinding.FieldName = 'asignacion'
                    PropertiesClassName = 'TcxLookupComboBoxProperties'
                    Properties.KeyFieldNames = 'codigo'
                    Properties.ListColumns = <
                      item
                        FieldName = 'descripcion'
                      end>
                    Properties.ListOptions.ShowHeader = False
                    Properties.ListSource = DSTCompoEntInter
                    HeaderAlignmentHorz = taCenter
                    Width = 200
                  end
                  object cxGridDBColumn5: TcxGridDBColumn
                    Caption = 'Activo'
                    DataBinding.FieldName = 'activo'
                    PropertiesClassName = 'TcxCheckBoxProperties'
                    HeaderAlignmentHorz = taCenter
                    Width = 52
                  end
                end
                object cxGridLevel2: TcxGridLevel
                  GridView = cxGridDBTableView2
                end
              end
            end
            object TabSheet4: TTabSheet
              Caption = 'Miercoles'
              ImageIndex = 2
              object dxDBGridSN3: TdxDBGridSN
                Left = 0
                Top = 0
                Width = 950
                Height = 162
                Align = alClient
                TabOrder = 0
                LookAndFeel.Kind = lfFlat
                CriteriosPintarCelda = <>
                object cxGridDBTableView3: TcxGridDBTableView
                  NavigatorButtons.ConfirmDelete = False
                  DataController.DataSource = dsTMotivoEntradasInterMIE
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
                  object cxGridDBColumn6: TcxGridDBColumn
                    Caption = 'Motivo'
                    DataBinding.FieldName = 'oid_motivo'
                    PropertiesClassName = 'TcxLookupComboBoxProperties'
                    Properties.KeyFieldNames = 'oid'
                    Properties.ListColumns = <
                      item
                        FieldName = 'descripcion'
                      end>
                    Properties.ListOptions.ShowHeader = False
                    Properties.ListSource = DSMotivos
                    HeaderAlignmentHorz = taCenter
                    Width = 187
                  end
                  object cxGridDBColumn7: TcxGridDBColumn
                    Caption = 'Hora Desde'
                    DataBinding.FieldName = 'horario_desde'
                    HeaderAlignmentHorz = taCenter
                    Width = 82
                  end
                  object cxGridDBColumn8: TcxGridDBColumn
                    Caption = 'Hora Hasta'
                    DataBinding.FieldName = 'horario_hasta'
                    HeaderAlignmentHorz = taCenter
                    Width = 87
                  end
                  object cxGridDBColumn9: TcxGridDBColumn
                    Caption = 'Acceso'
                    DataBinding.FieldName = 'asignacion'
                    PropertiesClassName = 'TcxLookupComboBoxProperties'
                    Properties.KeyFieldNames = 'codigo'
                    Properties.ListColumns = <
                      item
                        FieldName = 'descripcion'
                      end>
                    Properties.ListOptions.ShowHeader = False
                    Properties.ListSource = DSTCompoEntInter
                    HeaderAlignmentHorz = taCenter
                    Width = 200
                  end
                  object cxGridDBColumn10: TcxGridDBColumn
                    Caption = 'Activo'
                    DataBinding.FieldName = 'activo'
                    PropertiesClassName = 'TcxCheckBoxProperties'
                    HeaderAlignmentHorz = taCenter
                    Width = 52
                  end
                end
                object cxGridLevel3: TcxGridLevel
                  GridView = cxGridDBTableView3
                end
              end
            end
            object TabSheet5: TTabSheet
              Caption = 'Jueves'
              ImageIndex = 3
              object dxDBGridSN4: TdxDBGridSN
                Left = 0
                Top = 0
                Width = 950
                Height = 162
                Align = alClient
                TabOrder = 0
                LookAndFeel.Kind = lfFlat
                CriteriosPintarCelda = <>
                object cxGridDBTableView4: TcxGridDBTableView
                  NavigatorButtons.ConfirmDelete = False
                  DataController.DataSource = dsTMotivoEntradasInterJUE
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
                  object cxGridDBColumn11: TcxGridDBColumn
                    Caption = 'Motivo'
                    DataBinding.FieldName = 'oid_motivo'
                    PropertiesClassName = 'TcxLookupComboBoxProperties'
                    Properties.KeyFieldNames = 'oid'
                    Properties.ListColumns = <
                      item
                        FieldName = 'descripcion'
                      end>
                    Properties.ListOptions.ShowHeader = False
                    Properties.ListSource = DSMotivos
                    HeaderAlignmentHorz = taCenter
                    Width = 187
                  end
                  object cxGridDBColumn12: TcxGridDBColumn
                    Caption = 'Hora Desde'
                    DataBinding.FieldName = 'horario_desde'
                    HeaderAlignmentHorz = taCenter
                    Width = 82
                  end
                  object cxGridDBColumn13: TcxGridDBColumn
                    Caption = 'Hora Hasta'
                    DataBinding.FieldName = 'horario_hasta'
                    HeaderAlignmentHorz = taCenter
                    Width = 87
                  end
                  object cxGridDBColumn14: TcxGridDBColumn
                    Caption = 'Acceso'
                    DataBinding.FieldName = 'asignacion'
                    PropertiesClassName = 'TcxLookupComboBoxProperties'
                    Properties.KeyFieldNames = 'codigo'
                    Properties.ListColumns = <
                      item
                        FieldName = 'descripcion'
                      end>
                    Properties.ListOptions.ShowHeader = False
                    Properties.ListSource = DSTCompoEntInter
                    HeaderAlignmentHorz = taCenter
                    Width = 200
                  end
                  object cxGridDBColumn15: TcxGridDBColumn
                    Caption = 'Activo'
                    DataBinding.FieldName = 'activo'
                    PropertiesClassName = 'TcxCheckBoxProperties'
                    HeaderAlignmentHorz = taCenter
                    Width = 52
                  end
                end
                object cxGridLevel4: TcxGridLevel
                  GridView = cxGridDBTableView4
                end
              end
            end
            object TabSheet6: TTabSheet
              Caption = 'Viernes'
              ImageIndex = 4
              object dxDBGridSN5: TdxDBGridSN
                Left = 0
                Top = 0
                Width = 950
                Height = 162
                Align = alClient
                TabOrder = 0
                LookAndFeel.Kind = lfFlat
                CriteriosPintarCelda = <>
                object cxGridDBTableView5: TcxGridDBTableView
                  NavigatorButtons.ConfirmDelete = False
                  DataController.DataSource = dsTMotivoEntradasInterVIE
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
                  object cxGridDBColumn16: TcxGridDBColumn
                    Caption = 'Motivo'
                    DataBinding.FieldName = 'oid_motivo'
                    PropertiesClassName = 'TcxLookupComboBoxProperties'
                    Properties.KeyFieldNames = 'oid'
                    Properties.ListColumns = <
                      item
                        FieldName = 'descripcion'
                      end>
                    Properties.ListOptions.ShowHeader = False
                    Properties.ListSource = DSMotivos
                    HeaderAlignmentHorz = taCenter
                    Width = 187
                  end
                  object cxGridDBColumn17: TcxGridDBColumn
                    Caption = 'Hora Desde'
                    DataBinding.FieldName = 'horario_desde'
                    HeaderAlignmentHorz = taCenter
                    Width = 82
                  end
                  object cxGridDBColumn18: TcxGridDBColumn
                    Caption = 'Hora Hasta'
                    DataBinding.FieldName = 'horario_hasta'
                    HeaderAlignmentHorz = taCenter
                    Width = 87
                  end
                  object cxGridDBColumn19: TcxGridDBColumn
                    Caption = 'Acceso'
                    DataBinding.FieldName = 'asignacion'
                    PropertiesClassName = 'TcxLookupComboBoxProperties'
                    Properties.KeyFieldNames = 'codigo'
                    Properties.ListColumns = <
                      item
                        FieldName = 'descripcion'
                      end>
                    Properties.ListOptions.ShowHeader = False
                    Properties.ListSource = DSTCompoEntInter
                    HeaderAlignmentHorz = taCenter
                    Width = 200
                  end
                  object cxGridDBColumn20: TcxGridDBColumn
                    Caption = 'Activo'
                    DataBinding.FieldName = 'activo'
                    PropertiesClassName = 'TcxCheckBoxProperties'
                    HeaderAlignmentHorz = taCenter
                    Width = 52
                  end
                end
                object cxGridLevel5: TcxGridLevel
                  GridView = cxGridDBTableView5
                end
              end
            end
            object TabSheet7: TTabSheet
              Caption = 'S'#225'bado'
              ImageIndex = 5
              object dxDBGridSN6: TdxDBGridSN
                Left = 0
                Top = 0
                Width = 950
                Height = 162
                Align = alClient
                TabOrder = 0
                LookAndFeel.Kind = lfFlat
                CriteriosPintarCelda = <>
                object cxGridDBTableView6: TcxGridDBTableView
                  NavigatorButtons.ConfirmDelete = False
                  DataController.DataSource = dsTMotivoEntradasInterSAB
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
                  object cxGridDBColumn21: TcxGridDBColumn
                    Caption = 'Motivo'
                    DataBinding.FieldName = 'oid_motivo'
                    PropertiesClassName = 'TcxLookupComboBoxProperties'
                    Properties.KeyFieldNames = 'oid'
                    Properties.ListColumns = <
                      item
                        FieldName = 'descripcion'
                      end>
                    Properties.ListOptions.ShowHeader = False
                    Properties.ListSource = DSMotivos
                    HeaderAlignmentHorz = taCenter
                    Width = 187
                  end
                  object cxGridDBColumn22: TcxGridDBColumn
                    Caption = 'Hora Desde'
                    DataBinding.FieldName = 'horario_desde'
                    HeaderAlignmentHorz = taCenter
                    Width = 82
                  end
                  object cxGridDBColumn23: TcxGridDBColumn
                    Caption = 'Hora Hasta'
                    DataBinding.FieldName = 'horario_hasta'
                    HeaderAlignmentHorz = taCenter
                    Width = 87
                  end
                  object cxGridDBColumn24: TcxGridDBColumn
                    Caption = 'Acceso'
                    DataBinding.FieldName = 'asignacion'
                    PropertiesClassName = 'TcxLookupComboBoxProperties'
                    Properties.KeyFieldNames = 'codigo'
                    Properties.ListColumns = <
                      item
                        FieldName = 'descripcion'
                      end>
                    Properties.ListOptions.ShowHeader = False
                    Properties.ListSource = DSTCompoEntInter
                    HeaderAlignmentHorz = taCenter
                    Width = 200
                  end
                  object cxGridDBColumn25: TcxGridDBColumn
                    Caption = 'Activo'
                    DataBinding.FieldName = 'activo'
                    PropertiesClassName = 'TcxCheckBoxProperties'
                    HeaderAlignmentHorz = taCenter
                    Width = 52
                  end
                end
                object cxGridLevel6: TcxGridLevel
                  GridView = cxGridDBTableView6
                end
              end
            end
            object TabSheet8: TTabSheet
              Caption = 'Domingo'
              ImageIndex = 6
              object dxDBGridSN7: TdxDBGridSN
                Left = 0
                Top = 0
                Width = 950
                Height = 162
                Align = alClient
                TabOrder = 0
                LookAndFeel.Kind = lfFlat
                CriteriosPintarCelda = <>
                object cxGridDBTableView7: TcxGridDBTableView
                  NavigatorButtons.ConfirmDelete = False
                  DataController.DataSource = dsTMotivoEntradasInterDOM
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
                  object cxGridDBColumn26: TcxGridDBColumn
                    Caption = 'Motivo'
                    DataBinding.FieldName = 'oid_motivo'
                    PropertiesClassName = 'TcxLookupComboBoxProperties'
                    Properties.KeyFieldNames = 'oid'
                    Properties.ListColumns = <
                      item
                        FieldName = 'descripcion'
                      end>
                    Properties.ListOptions.ShowHeader = False
                    Properties.ListSource = DSMotivos
                    HeaderAlignmentHorz = taCenter
                    Width = 187
                  end
                  object cxGridDBColumn27: TcxGridDBColumn
                    Caption = 'Hora Desde'
                    DataBinding.FieldName = 'horario_desde'
                    HeaderAlignmentHorz = taCenter
                    Width = 82
                  end
                  object cxGridDBColumn28: TcxGridDBColumn
                    Caption = 'Hora Hasta'
                    DataBinding.FieldName = 'horario_hasta'
                    HeaderAlignmentHorz = taCenter
                    Width = 87
                  end
                  object cxGridDBColumn29: TcxGridDBColumn
                    Caption = 'Acceso'
                    DataBinding.FieldName = 'asignacion'
                    PropertiesClassName = 'TcxLookupComboBoxProperties'
                    Properties.KeyFieldNames = 'codigo'
                    Properties.ListColumns = <
                      item
                        FieldName = 'descripcion'
                      end>
                    Properties.ListOptions.ShowHeader = False
                    Properties.ListSource = DSTCompoEntInter
                    HeaderAlignmentHorz = taCenter
                    Width = 200
                  end
                  object cxGridDBColumn30: TcxGridDBColumn
                    Caption = 'Activo'
                    DataBinding.FieldName = 'activo'
                    PropertiesClassName = 'TcxCheckBoxProperties'
                    HeaderAlignmentHorz = taCenter
                    Width = 52
                  end
                end
                object cxGridLevel7: TcxGridLevel
                  GridView = cxGridDBTableView7
                end
              end
            end
          end
        end
      end
    end
  end
  inherited DriverABM: TDriverABM
    OperTraerObjeto = 'TraerPermisoSemanalCIP'
    OperGrabarObjeto = 'SavePermisoSemanalCIP'
    CargaDataSets = <
      item
        DataSet = TPermisoSemanalCIP
        TableName = 'TPermisoSemanalCIP'
      end
      item
        DataSet = TTiposEntradas
        TableName = 'TTiposEntradas'
      end
      item
        DataSet = TTiposSalidas
        TableName = 'TTiposSalidas'
      end
      item
        DataSet = TMotivoEntradasInterLUN
        TableName = 'TMotivoEntradasInterLUN'
      end
      item
        DataSet = TMotivoEntradasInterMAR
        TableName = 'TMotivoEntradasInterMAR'
      end
      item
        DataSet = TMotivoEntradasInterMIE
        TableName = 'TMotivoEntradasInterMIE'
      end
      item
        DataSet = TMotivoEntradasInterJUE
        TableName = 'TMotivoEntradasInterJUE'
      end
      item
        DataSet = TMotivoEntradasInterVIE
        TableName = 'TMotivoEntradasInterVIE'
      end
      item
        DataSet = TMotivoEntradasInterSAB
        TableName = 'TMotivoEntradasInterSAB'
      end
      item
        DataSet = TMotivoEntradasInterDOM
        TableName = 'TMotivoEntradasInterDOM'
      end
      item
        DataSet = TCompoEntInter
        TableName = 'TCompoEntInter'
      end>
    BajaLogica = <
      item
        DataSet = TPermisoSemanalCIP
        ValorBaja = 'false'
        ValorRehabilitacion = 'true'
        TipoBajaRegistro = tblCurrentRecord
        FieldName = 'activo'
      end>
    OperHabilitadas = [toOperNuevo, toOperModificar, toOperEliminar, toOperBuscar, toOperNavegacion, toOperRehabilitar]
    DataSetCab = TPermisoSemanalCIP
    DataSetDet1 = TMotivoEntradasInterLUN
    DataSetDet2 = TMotivoEntradasInterMAR
    DataSetDet3 = TMotivoEntradasInterMIE
    DataSetDet4 = TMotivoEntradasInterJUE
    DataSetDet5 = TMotivoEntradasInterVIE
    DataSetDet6 = TMotivoEntradasInterSAB
    DataSetDet7 = TMotivoEntradasInterDOM
    ControlFocoAlta = DBECodigo
    ControlFocoModif = DBECodigo
    Left = 512
    Top = 16
  end
  inherited Operacion: TOperacion
    Left = 560
    Top = 16
  end
  object TPermisoSemanalCIP: TsnTable [3]
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'oid_perm_semanal'
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
      end
      item
        Name = 'ent_hora_lun'
        DataType = ftString
        Size = 5
      end
      item
        Name = 'min_ent_ant_lun'
        DataType = ftInteger
      end
      item
        Name = 'min_ent_des_lun'
        DataType = ftInteger
      end
      item
        Name = 'tipo_per_ent_lun'
        DataType = ftString
        Size = 20
      end
      item
        Name = 'sal_hora_lun'
        DataType = ftString
        Size = 5
      end
      item
        Name = 'min_sal_ant_lun'
        DataType = ftInteger
      end
      item
        Name = 'min_sal_des_lun'
        DataType = ftInteger
      end
      item
        Name = 'tipo_per_sal_lun'
        DataType = ftString
        Size = 20
      end
      item
        Name = 'ent_hora_mar'
        DataType = ftString
        Size = 5
      end
      item
        Name = 'min_ent_ant_mar'
        DataType = ftInteger
      end
      item
        Name = 'min_ent_des_mar'
        DataType = ftInteger
      end
      item
        Name = 'tipo_per_ent_mar'
        DataType = ftString
        Size = 20
      end
      item
        Name = 'sal_hora_mar'
        DataType = ftString
        Size = 5
      end
      item
        Name = 'min_sal_ant_mar'
        DataType = ftInteger
      end
      item
        Name = 'min_sal_des_mar'
        DataType = ftInteger
      end
      item
        Name = 'tipo_per_sal_mar'
        DataType = ftString
        Size = 20
      end
      item
        Name = 'ent_hora_mie'
        DataType = ftString
        Size = 5
      end
      item
        Name = 'min_ent_ant_mie'
        DataType = ftInteger
      end
      item
        Name = 'min_ent_des_mie'
        DataType = ftInteger
      end
      item
        Name = 'tipo_per_ent_mie'
        DataType = ftString
        Size = 20
      end
      item
        Name = 'sal_hora_mie'
        DataType = ftString
        Size = 5
      end
      item
        Name = 'min_sal_ant_mie'
        DataType = ftInteger
      end
      item
        Name = 'min_sal_des_mie'
        DataType = ftInteger
      end
      item
        Name = 'tipo_per_sal_mie'
        DataType = ftString
        Size = 20
      end
      item
        Name = 'ent_hora_jue'
        DataType = ftString
        Size = 5
      end
      item
        Name = 'min_ent_ant_jue'
        DataType = ftInteger
      end
      item
        Name = 'min_ent_des_jue'
        DataType = ftInteger
      end
      item
        Name = 'tipo_per_ent_jue'
        DataType = ftString
        Size = 20
      end
      item
        Name = 'sal_hora_jue'
        DataType = ftString
        Size = 5
      end
      item
        Name = 'min_sal_ant_jue'
        DataType = ftInteger
      end
      item
        Name = 'min_sal_des_jue'
        DataType = ftInteger
      end
      item
        Name = 'tipo_per_sal_jue'
        DataType = ftString
        Size = 20
      end
      item
        Name = 'ent_hora_vie'
        DataType = ftString
        Size = 5
      end
      item
        Name = 'min_ent_ant_vie'
        DataType = ftInteger
      end
      item
        Name = 'min_ent_des_vie'
        DataType = ftInteger
      end
      item
        Name = 'tipo_per_ent_vie'
        DataType = ftString
        Size = 20
      end
      item
        Name = 'sal_hora_vie'
        DataType = ftString
        Size = 5
      end
      item
        Name = 'min_sal_ant_vie'
        DataType = ftInteger
      end
      item
        Name = 'min_sal_des_vie'
        DataType = ftInteger
      end
      item
        Name = 'tipo_per_sal_vie'
        DataType = ftString
        Size = 20
      end
      item
        Name = 'ent_hora_sab'
        DataType = ftString
        Size = 5
      end
      item
        Name = 'min_ent_ant_sab'
        DataType = ftInteger
      end
      item
        Name = 'min_ent_des_sab'
        DataType = ftInteger
      end
      item
        Name = 'tipo_per_ent_sab'
        DataType = ftString
        Size = 20
      end
      item
        Name = 'sal_hora_sab'
        DataType = ftString
        Size = 5
      end
      item
        Name = 'min_sal_ant_sab'
        DataType = ftInteger
      end
      item
        Name = 'min_sal_des_sab'
        DataType = ftInteger
      end
      item
        Name = 'tipo_per_sal_sab'
        DataType = ftString
        Size = 20
      end
      item
        Name = 'ent_hora_dom'
        DataType = ftString
        Size = 5
      end
      item
        Name = 'min_ent_ant_dom'
        DataType = ftInteger
      end
      item
        Name = 'min_ent_des_dom'
        DataType = ftInteger
      end
      item
        Name = 'tipo_per_ent_dom'
        DataType = ftString
        Size = 20
      end
      item
        Name = 'sal_hora_dom'
        DataType = ftString
        Size = 5
      end
      item
        Name = 'min_sal_ant_dom'
        DataType = ftInteger
      end
      item
        Name = 'min_sal_des_dom'
        DataType = ftInteger
      end
      item
        Name = 'tipo_per_sal_dom'
        DataType = ftString
        Size = 20
      end
      item
        Name = 'lun_ley_no_ing'
        DataType = ftString
        Size = 50
      end
      item
        Name = 'mar_ley_no_ing'
        DataType = ftString
        Size = 50
      end
      item
        Name = 'mie_ley_no_ing'
        DataType = ftString
        Size = 50
      end
      item
        Name = 'jue_ley_no_ing'
        DataType = ftString
        Size = 50
      end
      item
        Name = 'vie_ley_no_ing'
        DataType = ftString
        Size = 50
      end
      item
        Name = 'sab_ley_no_ing'
        DataType = ftString
        Size = 50
      end
      item
        Name = 'dom_ley_no_ing'
        DataType = ftString
        Size = 50
      end
      item
        Name = 'lun_ley_no_egr'
        DataType = ftString
        Size = 50
      end
      item
        Name = 'mar_ley_no_egr'
        DataType = ftString
        Size = 50
      end
      item
        Name = 'mie_ley_no_egr'
        DataType = ftString
        Size = 50
      end
      item
        Name = 'jue_ley_no_egr'
        DataType = ftString
        Size = 50
      end
      item
        Name = 'vie_ley_no_egr'
        DataType = ftString
        Size = 50
      end
      item
        Name = 'sab_ley_no_egr'
        DataType = ftString
        Size = 50
      end
      item
        Name = 'dom_ley_no_egr'
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
    Left = 648
    Top = 59
    object TPermisoSemanalCIPoid_perm_semanal: TIntegerField
      FieldName = 'oid_perm_semanal'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TPermisoSemanalCIPcodigo: TStringField
      DisplayWidth = 50
      FieldName = 'codigo'
      Size = 50
    end
    object TPermisoSemanalCIPdescripcion: TStringField
      DisplayWidth = 100
      FieldName = 'descripcion'
      Size = 100
    end
    object TPermisoSemanalCIPactivo: TBooleanField
      DefaultExpression = '1'
      FieldName = 'activo'
    end
    object TPermisoSemanalCIPent_hora_lun: TStringField
      FieldName = 'ent_hora_lun'
      Size = 5
    end
    object TPermisoSemanalCIPmin_ent_ant_lun: TIntegerField
      FieldName = 'min_ent_ant_lun'
    end
    object TPermisoSemanalCIPmin_ent_des_lun: TIntegerField
      FieldName = 'min_ent_des_lun'
    end
    object TPermisoSemanalCIPtipo_per_ent_lun: TStringField
      FieldName = 'tipo_per_ent_lun'
    end
    object TPermisoSemanalCIPsal_hora_lun: TStringField
      FieldName = 'sal_hora_lun'
      Size = 5
    end
    object TPermisoSemanalCIPmin_sal_ant_lun: TIntegerField
      FieldName = 'min_sal_ant_lun'
    end
    object TPermisoSemanalCIPmin_sal_des_lun: TIntegerField
      FieldName = 'min_sal_des_lun'
    end
    object TPermisoSemanalCIPtipo_per_sal_lun: TStringField
      FieldName = 'tipo_per_sal_lun'
    end
    object TPermisoSemanalCIPent_hora_mar: TStringField
      FieldName = 'ent_hora_mar'
      Size = 5
    end
    object TPermisoSemanalCIPmin_ent_ant_mar: TIntegerField
      FieldName = 'min_ent_ant_mar'
    end
    object TPermisoSemanalCIPmin_ent_des_mar: TIntegerField
      FieldName = 'min_ent_des_mar'
    end
    object TPermisoSemanalCIPtipo_per_ent_mar: TStringField
      FieldName = 'tipo_per_ent_mar'
    end
    object TPermisoSemanalCIPsal_hora_mar: TStringField
      FieldName = 'sal_hora_mar'
      Size = 5
    end
    object TPermisoSemanalCIPmin_sal_ant_mar: TIntegerField
      FieldName = 'min_sal_ant_mar'
    end
    object TPermisoSemanalCIPmin_sal_des_mar: TIntegerField
      FieldName = 'min_sal_des_mar'
    end
    object TPermisoSemanalCIPtipo_per_sal_mar: TStringField
      FieldName = 'tipo_per_sal_mar'
    end
    object TPermisoSemanalCIPent_hora_mie: TStringField
      FieldName = 'ent_hora_mie'
      Size = 5
    end
    object TPermisoSemanalCIPmin_ent_ant_mie: TIntegerField
      FieldName = 'min_ent_ant_mie'
    end
    object TPermisoSemanalCIPmin_ent_des_mie: TIntegerField
      FieldName = 'min_ent_des_mie'
    end
    object TPermisoSemanalCIPtipo_per_ent_mie: TStringField
      FieldName = 'tipo_per_ent_mie'
    end
    object TPermisoSemanalCIPsal_hora_mie: TStringField
      FieldName = 'sal_hora_mie'
      Size = 5
    end
    object TPermisoSemanalCIPmin_sal_ant_mie: TIntegerField
      FieldName = 'min_sal_ant_mie'
    end
    object TPermisoSemanalCIPmin_sal_des_mie: TIntegerField
      FieldName = 'min_sal_des_mie'
    end
    object TPermisoSemanalCIPtipo_per_sal_mie: TStringField
      FieldName = 'tipo_per_sal_mie'
    end
    object TPermisoSemanalCIPent_hora_juv: TStringField
      FieldName = 'ent_hora_jue'
      Size = 5
    end
    object TPermisoSemanalCIPmin_ent_ant_jue: TIntegerField
      FieldName = 'min_ent_ant_jue'
    end
    object TPermisoSemanalCIPmin_ent_des_jue: TIntegerField
      FieldName = 'min_ent_des_jue'
    end
    object TPermisoSemanalCIPtipo_per_ent_jue: TStringField
      FieldName = 'tipo_per_ent_jue'
    end
    object TPermisoSemanalCIPsal_hora_jue: TStringField
      FieldName = 'sal_hora_jue'
      Size = 5
    end
    object TPermisoSemanalCIPmin_sal_ant_jue: TIntegerField
      FieldName = 'min_sal_ant_jue'
    end
    object TPermisoSemanalCIPmin_sal_des_jue: TIntegerField
      FieldName = 'min_sal_des_jue'
    end
    object TPermisoSemanalCIPtipo_per_sal_jue: TStringField
      FieldName = 'tipo_per_sal_jue'
    end
    object TPermisoSemanalCIPent_hora_vie: TStringField
      FieldName = 'ent_hora_vie'
      Size = 5
    end
    object TPermisoSemanalCIPmin_ent_ant_vie: TIntegerField
      FieldName = 'min_ent_ant_vie'
    end
    object TPermisoSemanalCIPmin_ent_des_vie: TIntegerField
      FieldName = 'min_ent_des_vie'
    end
    object TPermisoSemanalCIPtipo_per_ent_vie: TStringField
      FieldName = 'tipo_per_ent_vie'
    end
    object TPermisoSemanalCIPsal_hora_vie: TStringField
      FieldName = 'sal_hora_vie'
      Size = 5
    end
    object TPermisoSemanalCIPmin_sal_ant_vie: TIntegerField
      FieldName = 'min_sal_ant_vie'
    end
    object TPermisoSemanalCIPmin_sal_des_vie: TIntegerField
      FieldName = 'min_sal_des_vie'
    end
    object TPermisoSemanalCIPtipo_per_sal_vie: TStringField
      FieldName = 'tipo_per_sal_vie'
    end
    object TPermisoSemanalCIPent_hora_sab: TStringField
      FieldName = 'ent_hora_sab'
      Size = 5
    end
    object TPermisoSemanalCIPmin_ent_ant_sab: TIntegerField
      FieldName = 'min_ent_ant_sab'
    end
    object TPermisoSemanalCIPmin_ent_des_sab: TIntegerField
      FieldName = 'min_ent_des_sab'
    end
    object TPermisoSemanalCIPtipo_per_ent_sab: TStringField
      FieldName = 'tipo_per_ent_sab'
    end
    object TPermisoSemanalCIPsal_hora_sab: TStringField
      FieldName = 'sal_hora_sab'
      Size = 5
    end
    object TPermisoSemanalCIPmin_sal_ant_sab: TIntegerField
      FieldName = 'min_sal_ant_sab'
    end
    object TPermisoSemanalCIPmin_sal_des_sab: TIntegerField
      FieldName = 'min_sal_des_sab'
    end
    object TPermisoSemanalCIPtipo_per_sal_sab: TStringField
      FieldName = 'tipo_per_sal_sab'
    end
    object TPermisoSemanalCIPent_hor_dom: TStringField
      FieldName = 'ent_hora_dom'
      Size = 5
    end
    object TPermisoSemanalCIPmin_ent_ant_dom: TIntegerField
      FieldName = 'min_ent_ant_dom'
    end
    object TPermisoSemanalCIPmin_ent_des_dom: TIntegerField
      FieldName = 'min_ent_des_dom'
    end
    object TPermisoSemanalCIPtipo_per_ent_dom: TStringField
      FieldName = 'tipo_per_ent_dom'
    end
    object TPermisoSemanalCIPsal_hor_dom: TStringField
      FieldName = 'sal_hora_dom'
      Size = 5
    end
    object TPermisoSemanalCIPmin_sal_ant_dom: TIntegerField
      FieldName = 'min_sal_ant_dom'
    end
    object TPermisoSemanalCIPmin_sal_des_dom: TIntegerField
      FieldName = 'min_sal_des_dom'
    end
    object TPermisoSemanalCIPtipo_per_sal_dom: TStringField
      FieldName = 'tipo_per_sal_dom'
    end
    object TPermisoSemanalCIPlun_ley_no_ing: TStringField
      FieldName = 'lun_ley_no_ing'
      Size = 50
    end
    object TPermisoSemanalCIPmar_ley_no_ing: TStringField
      FieldName = 'mar_ley_no_ing'
      Size = 50
    end
    object TPermisoSemanalCIPmie_ley_no_ing: TStringField
      FieldName = 'mie_ley_no_ing'
      Size = 50
    end
    object TPermisoSemanalCIPjue_ley_no_ing: TStringField
      FieldName = 'jue_ley_no_ing'
      Size = 50
    end
    object TPermisoSemanalCIPvie_ley_no_ing: TStringField
      FieldName = 'vie_ley_no_ing'
      Size = 50
    end
    object TPermisoSemanalCIPsab_ley_no_ing: TStringField
      FieldName = 'sab_ley_no_ing'
      Size = 50
    end
    object TPermisoSemanalCIPdom_ley_no_ing: TStringField
      FieldName = 'dom_ley_no_ing'
      Size = 50
    end
    object TPermisoSemanalCIPlun_ley_no_egr: TStringField
      FieldName = 'lun_ley_no_egr'
      Size = 50
    end
    object TPermisoSemanalCIPmar_ley_no_egr: TStringField
      FieldName = 'mar_ley_no_egr'
      Size = 50
    end
    object TPermisoSemanalCIPmie_ley_no_egr: TStringField
      FieldName = 'mie_ley_no_egr'
      Size = 50
    end
    object TPermisoSemanalCIPjue_ley_no_egr: TStringField
      FieldName = 'jue_ley_no_egr'
      Size = 50
    end
    object TPermisoSemanalCIPvie_ley_no_egr: TStringField
      FieldName = 'vie_ley_no_egr'
      Size = 50
    end
    object TPermisoSemanalCIPsab_ley_no_egr: TStringField
      FieldName = 'sab_ley_no_egr'
      Size = 50
    end
    object TPermisoSemanalCIPdom_ley_no_egr: TStringField
      FieldName = 'dom_ley_no_egr'
      Size = 50
    end
  end
  object DSTPermisoSemanalCIP: TDataSource [4]
    DataSet = TPermisoSemanalCIP
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
        TableName = 'TPermisoSemanalCIP'
        FieldName = 'codigo'
        Source.Strings = (
          'begin'
          '  ValidadorPermisoSemanal.Value := Sender.AsString;'
          '  ValidadorPermisoSemanal.Validar;'
          'end.')
      end>
    OnBeforePost = <
      item
        TableName = 'TMotivoEntradasInterLUN'
        Source.Strings = (
          'begin'
          '  if (DataSet.FieldName('#39'oid_motivo'#39').AsInteger = 0)'
          
            '      then raiseException(erCustomError,'#39'Debe ingresar el Motivo' +
            #39');'
          '  if (DataSet.FieldName('#39'Horario_desde'#39').AsString = '#39#39')'
          
            '      then  raiseException(erCustomError,'#39'Debe ingresar el horar' +
            'io desde'#39');'
          '  if (DataSet.FieldName('#39'Horario_hasta'#39').AsString = '#39#39')'
          
            '      then  raiseException(erCustomError,'#39'Debe ingresar el horar' +
            'io hasta'#39');'
          '  if (DataSet.FieldName('#39'asignacion'#39').AsString = '#39#39')'
          
            '      then  raiseException(erCustomError,'#39'Debe ingresar el tipo ' +
            'de acceso del Motivo'#39');'
          'end.')
      end
      item
        TableName = 'TMotivoEntradasInterMAR'
        Source.Strings = (
          'begin'
          '  if (DataSet.FieldName('#39'oid_motivo'#39').AsInteger = 0)'
          
            '      then raiseException(erCustomError,'#39'Debe ingresar el Motivo' +
            #39');'
          '  if (DataSet.FieldName('#39'Horario_desde'#39').AsString = '#39#39')'
          
            '      then  raiseException(erCustomError,'#39'Debe ingresar el horar' +
            'io desde'#39');'
          '  if (DataSet.FieldName('#39'Horario_hasta'#39').AsString = '#39#39')'
          
            '      then  raiseException(erCustomError,'#39'Debe ingresar el horar' +
            'io hasta'#39');'
          '  if (DataSet.FieldName('#39'asignacion'#39').AsString = '#39#39')'
          
            '      then  raiseException(erCustomError,'#39'Debe ingresar el tipo ' +
            'de acceso del Motivo'#39');'
          'end.')
      end
      item
        TableName = 'TMotivoEntradasInterMIE'
        Source.Strings = (
          'begin'
          '  if (DataSet.FieldName('#39'oid_motivo'#39').AsInteger = 0)'
          
            '      then raiseException(erCustomError,'#39'Debe ingresar el Motivo' +
            #39');'
          '  if (DataSet.FieldName('#39'Horario_desde'#39').AsString = '#39#39')'
          
            '      then  raiseException(erCustomError,'#39'Debe ingresar el horar' +
            'io desde'#39');'
          '  if (DataSet.FieldName('#39'Horario_hasta'#39').AsString = '#39#39')'
          
            '      then  raiseException(erCustomError,'#39'Debe ingresar el horar' +
            'io hasta'#39');'
          '  if (DataSet.FieldName('#39'asignacion'#39').AsString = '#39#39')'
          
            '      then  raiseException(erCustomError,'#39'Debe ingresar el tipo ' +
            'de acceso del Motivo'#39');'
          'end.')
      end
      item
        TableName = 'TMotivoEntradasInterJUE'
        Source.Strings = (
          'begin'
          '  if (DataSet.FieldName('#39'oid_motivo'#39').AsInteger = 0)'
          
            '      then raiseException(erCustomError,'#39'Debe ingresar el Motivo' +
            #39');'
          '  if (DataSet.FieldName('#39'Horario_desde'#39').AsString = '#39#39')'
          
            '      then  raiseException(erCustomError,'#39'Debe ingresar el horar' +
            'io desde'#39');'
          '  if (DataSet.FieldName('#39'Horario_hasta'#39').AsString = '#39#39')'
          
            '      then  raiseException(erCustomError,'#39'Debe ingresar el horar' +
            'io hasta'#39');'
          '  if (DataSet.FieldName('#39'asignacion'#39').AsString = '#39#39')'
          
            '      then  raiseException(erCustomError,'#39'Debe ingresar el tipo ' +
            'de acceso del Motivo'#39');'
          'end.')
      end
      item
        TableName = 'TMotivoEntradasInterVIE'
        Source.Strings = (
          'begin'
          '  if (DataSet.FieldName('#39'oid_motivo'#39').AsInteger = 0)'
          
            '      then raiseException(erCustomError,'#39'Debe ingresar el Motivo' +
            #39');'
          '  if (DataSet.FieldName('#39'Horario_desde'#39').AsString = '#39#39')'
          
            '      then  raiseException(erCustomError,'#39'Debe ingresar el horar' +
            'io desde'#39');'
          '  if (DataSet.FieldName('#39'Horario_hasta'#39').AsString = '#39#39')'
          
            '      then  raiseException(erCustomError,'#39'Debe ingresar el horar' +
            'io hasta'#39');'
          '  if (DataSet.FieldName('#39'asignacion'#39').AsString = '#39#39')'
          
            '      then  raiseException(erCustomError,'#39'Debe ingresar el tipo ' +
            'de acceso del Motivo'#39');'
          'end.')
      end
      item
        TableName = 'TMotivoEntradasInterSAB'
        Source.Strings = (
          'begin'
          '  if (DataSet.FieldName('#39'oid_motivo'#39').AsInteger = 0)'
          
            '      then raiseException(erCustomError,'#39'Debe ingresar el Motivo' +
            #39');'
          '  if (DataSet.FieldName('#39'Horario_desde'#39').AsString = '#39#39')'
          
            '      then  raiseException(erCustomError,'#39'Debe ingresar el horar' +
            'io desde'#39');'
          '  if (DataSet.FieldName('#39'Horario_hasta'#39').AsString = '#39#39')'
          
            '      then  raiseException(erCustomError,'#39'Debe ingresar el horar' +
            'io hasta'#39');'
          '  if (DataSet.FieldName('#39'asignacion'#39').AsString = '#39#39')'
          
            '      then  raiseException(erCustomError,'#39'Debe ingresar el tipo ' +
            'de acceso del Motivo'#39');'
          'end.')
      end
      item
        TableName = 'TMotivoEntradasInterDOM'
        Source.Strings = (
          'begin'
          '  if (DataSet.FieldName('#39'oid_motivo'#39').AsInteger = 0)'
          
            '      then raiseException(erCustomError,'#39'Debe ingresar el Motivo' +
            #39');'
          '  if (DataSet.FieldName('#39'Horario_desde'#39').AsString = '#39#39')'
          
            '      then  raiseException(erCustomError,'#39'Debe ingresar el horar' +
            'io desde'#39');'
          '  if (DataSet.FieldName('#39'Horario_hasta'#39').AsString = '#39#39')'
          
            '      then  raiseException(erCustomError,'#39'Debe ingresar el horar' +
            'io hasta'#39');'
          '  if (DataSet.FieldName('#39'asignacion'#39').AsString = '#39#39')'
          
            '      then  raiseException(erCustomError,'#39'Debe ingresar el tipo ' +
            'de acceso del Motivo'#39');'
          'end.')
      end>
    OnNuevoRegistro = <
      item
        TableName = 'TMotivoEntradasInterLUN'
        Source.Strings = (
          'begin'
          '  DataSet.FieldName('#39'oid_perm_semanal'#39').AsInteger := '
          
            '            TPermisoSemanalCIP.FieldName('#39'oid_perm_semanal'#39').AsI' +
            'nteger;'
          '  DataSet.FieldName('#39'activo'#39').AsBoolean := true;'
          'end.')
      end
      item
        TableName = 'TMotivoEntradasInterMAR'
        Source.Strings = (
          'begin'
          '  DataSet.FieldName('#39'oid_perm_semanal'#39').AsInteger := '
          
            '            TPermisoSemanalCIP.FieldName('#39'oid_perm_semanal'#39').AsI' +
            'nteger;'
          '  DataSet.FieldName('#39'activo'#39').AsBoolean := true;'
          'end.')
      end
      item
        TableName = 'TMotivoEntradasInterMIE'
        Source.Strings = (
          'begin'
          '  DataSet.FieldName('#39'oid_perm_semanal'#39').AsInteger := '
          
            '            TPermisoSemanalCIP.FieldName('#39'oid_perm_semanal'#39').AsI' +
            'nteger;'
          '  DataSet.FieldName('#39'activo'#39').AsBoolean := true;'
          'end.')
      end
      item
        TableName = 'TMotivoEntradasInterJUE'
        Source.Strings = (
          'begin'
          '  DataSet.FieldName('#39'oid_perm_semanal'#39').AsInteger := '
          
            '            TPermisoSemanalCIP.FieldName('#39'oid_perm_semanal'#39').AsI' +
            'nteger;'
          '  DataSet.FieldName('#39'activo'#39').AsBoolean := true;'
          'end.')
      end
      item
        TableName = 'TMotivoEntradasInterVIE'
        Source.Strings = (
          'begin'
          '  DataSet.FieldName('#39'oid_perm_semanal'#39').AsInteger := '
          
            '            TPermisoSemanalCIP.FieldName('#39'oid_perm_semanal'#39').AsI' +
            'nteger;'
          '  DataSet.FieldName('#39'activo'#39').AsBoolean := true;'
          'end.')
      end
      item
        TableName = 'TMotivoEntradasInterSAB'
        Source.Strings = (
          'begin'
          '  DataSet.FieldName('#39'oid_perm_semanal'#39').AsInteger := '
          
            '            TPermisoSemanalCIP.FieldName('#39'oid_perm_semanal'#39').AsI' +
            'nteger;'
          '  DataSet.FieldName('#39'activo'#39').AsBoolean := true;'
          'end.')
      end
      item
        TableName = 'TMotivoEntradasInterDOM'
        Source.Strings = (
          'begin'
          '  DataSet.FieldName('#39'oid_perm_semanal'#39').AsInteger := '
          
            '            TPermisoSemanalCIP.FieldName('#39'oid_perm_semanal'#39').AsI' +
            'nteger;'
          '  DataSet.FieldName('#39'activo'#39').AsBoolean := true;'
          'end.')
      end>
    OnInicializar = <
      item
        Source.Strings = (
          'begin'
          '  TraerTipos();'
          '  TraerTiposSal();'
          '  TMotivos.loadFromHelp('#39'HelpMotivos'#39');'
          '  TraerComporMotivos();'
          'end.')
      end>
    OnFormFunction = <
      item
        Source.Strings = (
          'procedure TraerTipos();'
          'begin'
          '  operacion.InicioOperacion();'
          '  operacion.setOper('#39'TraerTiposEntradasRotas'#39');'
          '  operacion.execute();'
          'end;'
          ''
          'procedure TraerTiposSal();'
          'begin'
          '  operacion.InicioOperacion();'
          '  operacion.setOper('#39'TraerTiposSalidasRotas'#39');'
          '  operacion.execute();'
          'end;'
          ''
          'procedure TraerComporMotivos();'
          'begin'
          '  operacion.InicioOperacion();'
          '  operacion.setOper('#39'TraerCompoMotEntInter'#39');'
          '  operacion.execute();'
          'end;')
      end>
  end
  inherited SaveArchivo: TSaveDialog
    Top = 128
  end
  inherited ImprimirObjetoSeleccionado: TdxComponentPrinter
    Left = 312
    Top = 128
    inherited ImprimirObjetoSeleccionadodxComponentPrinterLink: TdxGridReportLink
      BuiltInReportLink = True
    end
  end
  inherited TTempVarForm: TsnTable
    Left = 512
    Top = 72
  end
  inherited ImageListGruposPopUp: TImageList
    Top = 67
  end
  inherited ImageListItemsPopUp: TImageList
    Top = 99
  end
  inherited TPathHelp: TsnTable
    Top = 437
  end
  inherited TDataSetOidObjSave: TsnTable
    Left = 544
    Top = 75
  end
  object HelpPermisoSemanal: TsnHelp
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
    Titulo = 'Permiso Semanal'
    AnchoHelp = 600
    ActivarCache = False
    ShowBotonBuscar = False
    Left = 50
    Top = 28
  end
  object ValidadorPermisoSemanal: TValidador
    Operacion = Operacion
    NickNameObjLog = 'cip.PermisoSemanalCIP'
    WhenRaiseException = teFound
    MensajeException = 'C'#243'digo de Permiso duplicado'
    NroQuery = 0
    Cache = False
    Left = 136
    Top = 43
  end
  object TTiposEntradas: TsnTable
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
    Left = 240
    Top = 294
    object TTiposEntradascodigo: TStringField
      FieldName = 'codigo'
      Size = 50
    end
    object TTiposEntradasdescripcion: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
  end
  object DSTiposEntradas: TDataSource
    DataSet = TTiposEntradas
    Left = 272
    Top = 294
  end
  object TTiposSalidas: TsnTable
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
    Left = 240
    Top = 348
    object TTiposSalidascodigo: TStringField
      FieldName = 'codigo'
      Size = 50
    end
    object TTiposSalidasdescripcion: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
  end
  object DSTiposSalidas: TDataSource
    DataSet = TTiposSalidas
    Left = 280
    Top = 353
  end
  object TMotivoEntradasInterLUN: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'oid'
        DataType = ftInteger
      end
      item
        Name = 'oid_motivo'
        DataType = ftInteger
      end
      item
        Name = 'oid_perm_semanal'
        DataType = ftInteger
      end
      item
        Name = 'horario_desde'
        DataType = ftString
        Size = 5
      end
      item
        Name = 'horario_hasta'
        DataType = ftString
        Size = 5
      end
      item
        Name = 'asignacion'
        DataType = ftString
        Size = 20
      end
      item
        Name = 'activo'
        DataType = ftBoolean
      end>
    IndexFieldNames = 'oid_perm_semanal'
    IndexDefs = <
      item
        Name = 'TMotivoEntradasInterRotaIndex1'
        Fields = 'oid_perm_semanal'
      end>
    RecalcOnFetch = False
    SortOptions = []
    PersistentBackup = False
    ProgressFlags = [mtpcLoad, mtpcSave, mtpcCopy]
    VersioningMode = mtvmAllSinceCheckPoint
    FilterOptions = []
    MasterFields = 'oid_perm_semanal'
    MasterSource = DSTPermisoSemanalCIP
    Version = '4.08b'
    LanguageID = 0
    SortID = 0
    SubLanguageID = 1
    LocaleID = 1024
    MensajeValorDuplicadoIndice = 'Valor Duplicado'
    Left = 600
    Top = 108
    object TMotivoEntradasInterLUNoid: TIntegerField
      FieldName = 'oid'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TMotivoEntradasInterLUNoid_motivo: TIntegerField
      FieldName = 'oid_motivo'
    end
    object TMotivoEntradasInterLUNoid_perm_semanal: TIntegerField
      FieldName = 'oid_perm_semanal'
    end
    object TMotivoEntradasInterLUNhorario_desde: TStringField
      FieldName = 'horario_desde'
      EditMask = '!90:00;1;_'
      Size = 5
    end
    object TMotivoEntradasInterLUNhorario_hasta: TStringField
      FieldName = 'horario_hasta'
      EditMask = '!90:00;1;_'
      Size = 5
    end
    object TMotivoEntradasInterLUNasignacion: TStringField
      FieldName = 'asignacion'
    end
    object TMotivoEntradasInterLUNactivo: TBooleanField
      FieldName = 'activo'
    end
  end
  object DSMotivoEntradasInterLUN: TDataSource
    DataSet = TMotivoEntradasInterLUN
    Left = 632
    Top = 108
  end
  object TMotivoEntradasInterMAR: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'oid'
        DataType = ftInteger
      end
      item
        Name = 'oid_motivo'
        DataType = ftInteger
      end
      item
        Name = 'oid_perm_semanal'
        DataType = ftInteger
      end
      item
        Name = 'horario_desde'
        DataType = ftString
        Size = 5
      end
      item
        Name = 'horario_hasta'
        DataType = ftString
        Size = 5
      end
      item
        Name = 'asignacion'
        DataType = ftString
        Size = 20
      end
      item
        Name = 'activo'
        DataType = ftBoolean
      end>
    IndexFieldNames = 'oid_perm_semanal'
    IndexDefs = <
      item
        Name = 'TMotivoEntradasInterRotaIndex1'
        Fields = 'oid_perm_semanal'
      end>
    RecalcOnFetch = False
    SortOptions = []
    PersistentBackup = False
    ProgressFlags = [mtpcLoad, mtpcSave, mtpcCopy]
    VersioningMode = mtvmAllSinceCheckPoint
    FilterOptions = []
    MasterFields = 'oid_perm_semanal'
    MasterSource = DSTPermisoSemanalCIP
    Version = '4.08b'
    LanguageID = 0
    SortID = 0
    SubLanguageID = 1
    LocaleID = 1024
    MensajeValorDuplicadoIndice = 'Valor Duplicado'
    Left = 677
    Top = 108
    object IntegerField1: TIntegerField
      FieldName = 'oid'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object IntegerField2: TIntegerField
      FieldName = 'oid_motivo'
    end
    object IntegerField3: TIntegerField
      FieldName = 'oid_perm_semanal'
    end
    object StringField1: TStringField
      FieldName = 'horario_desde'
      EditMask = '!90:00;1;_'
      Size = 5
    end
    object StringField2: TStringField
      FieldName = 'horario_hasta'
      EditMask = '!90:00;1;_'
      Size = 5
    end
    object StringField3: TStringField
      FieldName = 'asignacion'
    end
    object BooleanField1: TBooleanField
      FieldName = 'activo'
    end
  end
  object dsTMotivoEntradasInterMAR: TDataSource
    DataSet = TMotivoEntradasInterMAR
    Left = 709
    Top = 108
  end
  object TMotivoEntradasInterMIE: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'oid'
        DataType = ftInteger
      end
      item
        Name = 'oid_motivo'
        DataType = ftInteger
      end
      item
        Name = 'oid_perm_semanal'
        DataType = ftInteger
      end
      item
        Name = 'horario_desde'
        DataType = ftString
        Size = 5
      end
      item
        Name = 'horario_hasta'
        DataType = ftString
        Size = 5
      end
      item
        Name = 'asignacion'
        DataType = ftString
        Size = 20
      end
      item
        Name = 'activo'
        DataType = ftBoolean
      end>
    IndexFieldNames = 'oid_perm_semanal'
    IndexDefs = <
      item
        Name = 'TMotivoEntradasInterRotaIndex1'
        Fields = 'oid_perm_semanal'
      end>
    RecalcOnFetch = False
    SortOptions = []
    PersistentBackup = False
    ProgressFlags = [mtpcLoad, mtpcSave, mtpcCopy]
    VersioningMode = mtvmAllSinceCheckPoint
    FilterOptions = []
    MasterFields = 'oid_perm_semanal'
    MasterSource = DSTPermisoSemanalCIP
    Version = '4.08b'
    LanguageID = 0
    SortID = 0
    SubLanguageID = 1
    LocaleID = 1024
    MensajeValorDuplicadoIndice = 'Valor Duplicado'
    Left = 752
    Top = 108
    object IntegerField4: TIntegerField
      FieldName = 'oid'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object IntegerField5: TIntegerField
      FieldName = 'oid_motivo'
    end
    object IntegerField6: TIntegerField
      FieldName = 'oid_perm_semanal'
    end
    object StringField4: TStringField
      FieldName = 'horario_desde'
      EditMask = '!90:00;1;_'
      Size = 5
    end
    object StringField5: TStringField
      FieldName = 'horario_hasta'
      EditMask = '!90:00;1;_'
      Size = 5
    end
    object StringField6: TStringField
      FieldName = 'asignacion'
    end
    object BooleanField2: TBooleanField
      FieldName = 'activo'
    end
  end
  object dsTMotivoEntradasInterMIE: TDataSource
    DataSet = TMotivoEntradasInterMIE
    Left = 784
    Top = 108
  end
  object TMotivoEntradasInterJUE: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'oid'
        DataType = ftInteger
      end
      item
        Name = 'oid_motivo'
        DataType = ftInteger
      end
      item
        Name = 'oid_perm_semanal'
        DataType = ftInteger
      end
      item
        Name = 'horario_desde'
        DataType = ftString
        Size = 5
      end
      item
        Name = 'horario_hasta'
        DataType = ftString
        Size = 5
      end
      item
        Name = 'asignacion'
        DataType = ftString
        Size = 20
      end
      item
        Name = 'activo'
        DataType = ftBoolean
      end>
    IndexFieldNames = 'oid_perm_semanal'
    IndexDefs = <
      item
        Name = 'TMotivoEntradasInterRotaIndex1'
        Fields = 'oid_perm_semanal'
      end>
    RecalcOnFetch = False
    SortOptions = []
    PersistentBackup = False
    ProgressFlags = [mtpcLoad, mtpcSave, mtpcCopy]
    VersioningMode = mtvmAllSinceCheckPoint
    FilterOptions = []
    MasterFields = 'oid_perm_semanal'
    MasterSource = DSTPermisoSemanalCIP
    Version = '4.08b'
    LanguageID = 0
    SortID = 0
    SubLanguageID = 1
    LocaleID = 1024
    MensajeValorDuplicadoIndice = 'Valor Duplicado'
    Left = 829
    Top = 108
    object IntegerField7: TIntegerField
      FieldName = 'oid'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object IntegerField8: TIntegerField
      FieldName = 'oid_motivo'
    end
    object IntegerField9: TIntegerField
      FieldName = 'oid_perm_semanal'
    end
    object StringField7: TStringField
      FieldName = 'horario_desde'
      EditMask = '!90:00;1;_'
      Size = 5
    end
    object StringField8: TStringField
      FieldName = 'horario_hasta'
      EditMask = '!90:00;1;_'
      Size = 5
    end
    object StringField9: TStringField
      FieldName = 'asignacion'
    end
    object BooleanField3: TBooleanField
      FieldName = 'activo'
    end
  end
  object dsTMotivoEntradasInterJUE: TDataSource
    DataSet = TMotivoEntradasInterJUE
    Left = 861
    Top = 108
  end
  object TMotivoEntradasInterVIE: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'oid'
        DataType = ftInteger
      end
      item
        Name = 'oid_motivo'
        DataType = ftInteger
      end
      item
        Name = 'oid_perm_semanal'
        DataType = ftInteger
      end
      item
        Name = 'horario_desde'
        DataType = ftString
        Size = 5
      end
      item
        Name = 'horario_hasta'
        DataType = ftString
        Size = 5
      end
      item
        Name = 'asignacion'
        DataType = ftString
        Size = 20
      end
      item
        Name = 'activo'
        DataType = ftBoolean
      end>
    IndexFieldNames = 'oid_perm_semanal'
    IndexDefs = <
      item
        Name = 'TMotivoEntradasInterRotaIndex1'
        Fields = 'oid_perm_semanal'
      end>
    RecalcOnFetch = False
    SortOptions = []
    PersistentBackup = False
    ProgressFlags = [mtpcLoad, mtpcSave, mtpcCopy]
    VersioningMode = mtvmAllSinceCheckPoint
    FilterOptions = []
    MasterFields = 'oid_perm_semanal'
    MasterSource = DSTPermisoSemanalCIP
    Version = '4.08b'
    LanguageID = 0
    SortID = 0
    SubLanguageID = 1
    LocaleID = 1024
    MensajeValorDuplicadoIndice = 'Valor Duplicado'
    Left = 597
    Top = 164
    object IntegerField10: TIntegerField
      FieldName = 'oid'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object IntegerField11: TIntegerField
      FieldName = 'oid_motivo'
    end
    object IntegerField12: TIntegerField
      FieldName = 'oid_perm_semanal'
    end
    object StringField10: TStringField
      FieldName = 'horario_desde'
      EditMask = '!90:00;1;_'
      Size = 5
    end
    object StringField11: TStringField
      FieldName = 'horario_hasta'
      EditMask = '!90:00;1;_'
      Size = 5
    end
    object StringField12: TStringField
      FieldName = 'asignacion'
    end
    object BooleanField4: TBooleanField
      FieldName = 'activo'
    end
  end
  object dsTMotivoEntradasInterVIE: TDataSource
    DataSet = TMotivoEntradasInterVIE
    Left = 629
    Top = 164
  end
  object TMotivoEntradasInterSAB: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'oid'
        DataType = ftInteger
      end
      item
        Name = 'oid_motivo'
        DataType = ftInteger
      end
      item
        Name = 'oid_perm_semanal'
        DataType = ftInteger
      end
      item
        Name = 'horario_desde'
        DataType = ftString
        Size = 5
      end
      item
        Name = 'horario_hasta'
        DataType = ftString
        Size = 5
      end
      item
        Name = 'asignacion'
        DataType = ftString
        Size = 20
      end
      item
        Name = 'activo'
        DataType = ftBoolean
      end>
    IndexFieldNames = 'oid_perm_semanal'
    IndexDefs = <
      item
        Name = 'TMotivoEntradasInterRotaIndex1'
        Fields = 'oid_perm_semanal'
      end>
    RecalcOnFetch = False
    SortOptions = []
    PersistentBackup = False
    ProgressFlags = [mtpcLoad, mtpcSave, mtpcCopy]
    VersioningMode = mtvmAllSinceCheckPoint
    FilterOptions = []
    MasterFields = 'oid_perm_semanal'
    MasterSource = DSTPermisoSemanalCIP
    Version = '4.08b'
    LanguageID = 0
    SortID = 0
    SubLanguageID = 1
    LocaleID = 1024
    MensajeValorDuplicadoIndice = 'Valor Duplicado'
    Left = 678
    Top = 164
    object IntegerField13: TIntegerField
      FieldName = 'oid'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object IntegerField14: TIntegerField
      FieldName = 'oid_motivo'
    end
    object IntegerField15: TIntegerField
      FieldName = 'oid_perm_semanal'
    end
    object StringField13: TStringField
      FieldName = 'horario_desde'
      EditMask = '!90:00;1;_'
      Size = 5
    end
    object StringField14: TStringField
      FieldName = 'horario_hasta'
      EditMask = '!90:00;1;_'
      Size = 5
    end
    object StringField15: TStringField
      FieldName = 'asignacion'
    end
    object BooleanField5: TBooleanField
      FieldName = 'activo'
    end
  end
  object dsTMotivoEntradasInterSAB: TDataSource
    DataSet = TMotivoEntradasInterSAB
    Left = 710
    Top = 164
  end
  object TMotivoEntradasInterDOM: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'oid'
        DataType = ftInteger
      end
      item
        Name = 'oid_motivo'
        DataType = ftInteger
      end
      item
        Name = 'oid_perm_semanal'
        DataType = ftInteger
      end
      item
        Name = 'horario_desde'
        DataType = ftString
        Size = 5
      end
      item
        Name = 'horario_hasta'
        DataType = ftString
        Size = 5
      end
      item
        Name = 'asignacion'
        DataType = ftString
        Size = 20
      end
      item
        Name = 'activo'
        DataType = ftBoolean
      end>
    IndexFieldNames = 'oid_perm_semanal'
    IndexDefs = <
      item
        Name = 'TMotivoEntradasInterRotaIndex1'
        Fields = 'oid_perm_semanal'
      end>
    RecalcOnFetch = False
    SortOptions = []
    PersistentBackup = False
    ProgressFlags = [mtpcLoad, mtpcSave, mtpcCopy]
    VersioningMode = mtvmAllSinceCheckPoint
    FilterOptions = []
    MasterFields = 'oid_perm_semanal'
    MasterSource = DSTPermisoSemanalCIP
    Version = '4.08b'
    LanguageID = 0
    SortID = 0
    SubLanguageID = 1
    LocaleID = 1024
    MensajeValorDuplicadoIndice = 'Valor Duplicado'
    Left = 752
    Top = 164
    object IntegerField16: TIntegerField
      FieldName = 'oid'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object IntegerField17: TIntegerField
      FieldName = 'oid_motivo'
    end
    object IntegerField18: TIntegerField
      FieldName = 'oid_perm_semanal'
    end
    object StringField16: TStringField
      FieldName = 'horario_desde'
      EditMask = '!90:00;1;_'
      Size = 5
    end
    object StringField17: TStringField
      FieldName = 'horario_hasta'
      EditMask = '!90:00;1;_'
      Size = 5
    end
    object StringField18: TStringField
      FieldName = 'asignacion'
    end
    object BooleanField6: TBooleanField
      FieldName = 'activo'
    end
  end
  object dsTMotivoEntradasInterDOM: TDataSource
    DataSet = TMotivoEntradasInterDOM
    Left = 784
    Top = 164
  end
  object HelpMotivos: TsnHelp
    Acepto = False
    Oid = 0
    Operacion = Operacion
    NickNameObjLog = 'cip.MotivoEntIntermedias'
    NroHelp = 6
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
    Left = 663
    Top = 478
  end
  object TMotivos: TsnTable
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
    Left = 695
    Top = 478
    object TMotivosoid: TIntegerField
      FieldName = 'oid'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
    end
    object TMotivoscodigo: TStringField
      FieldName = 'codigo'
      Size = 50
    end
    object TMotivosdescripcion: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
  end
  object DSMotivos: TDataSource
    DataSet = TMotivos
    Left = 728
    Top = 476
  end
  object TCompoEntInter: TsnTable
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
    Left = 192
    Top = 164
    object TCompoEntIntercodigo: TStringField
      FieldName = 'codigo'
      Size = 50
    end
    object TCompoEntInterdescripcion: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
  end
  object DSTCompoEntInter: TDataSource
    DataSet = TCompoEntInter
    Left = 224
    Top = 164
  end
end
