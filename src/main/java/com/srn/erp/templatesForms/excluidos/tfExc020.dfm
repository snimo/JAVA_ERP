inherited FBuscadorIndExc: TFBuscadorIndExc
  Left = 18
  Top = 80
  Width = 999
  Height = 643
  Caption = 'Buscador de Individuos'
  PixelsPerInch = 96
  TextHeight = 13
  object Panel1: TPanel [0]
    Left = 0
    Top = 0
    Width = 991
    Height = 41
    Align = alTop
    BevelOuter = bvNone
    Color = clWindow
    TabOrder = 0
    object ImageBuscar: TImage
      Left = 31
      Top = 3
      Width = 32
      Height = 32
      Cursor = crHandPoint
      Hint = 'Presione F12 para Ejecutar Consulta'
      ParentShowHint = False
      ShowHint = True
    end
    object ImageSalir: TImage
      Left = 79
      Top = 3
      Width = 32
      Height = 32
      Cursor = crHandPoint
      Hint = 'Salir'
      ParentShowHint = False
      ShowHint = True
    end
    object snLabel44: TsnLabel
      Left = 128
      Top = 12
      Width = 387
      Height = 16
      Caption = 'Ingrese los filtros y presione F12 para ejecutar la consulta'
      Font.Charset = ANSI_CHARSET
      Font.Color = clMaroon
      Font.Height = -13
      Font.Name = 'Verdana'
      Font.Style = []
      ParentFont = False
    end
  end
  object Panel2: TPanel [1]
    Left = 0
    Top = 568
    Width = 991
    Height = 41
    Align = alBottom
    BevelOuter = bvNone
    Color = clWindow
    TabOrder = 1
  end
  object Panel3: TPanel [2]
    Left = 0
    Top = 41
    Width = 991
    Height = 527
    Align = alClient
    BevelOuter = bvNone
    BorderWidth = 2
    Color = clWindow
    TabOrder = 2
    object ScrollBox1: TSNScrollBox
      Left = 2
      Top = 2
      Width = 987
      Height = 523
      Align = alClient
      TabOrder = 0
      object snLabel2: TsnLabel
        Left = 36
        Top = 42
        Width = 144
        Height = 22
        Caption = 'Datos Principales'
        Font.Charset = ANSI_CHARSET
        Font.Color = clWindowText
        Font.Height = -19
        Font.Name = 'Times New Roman'
        Font.Style = [fsBold]
        ParentFont = False
      end
      object snLabel7: TsnLabel
        Left = 36
        Top = 81
        Width = 71
        Height = 16
        Caption = 'Tipo Docu.'
        Font.Charset = ANSI_CHARSET
        Font.Color = clWindowText
        Font.Height = -13
        Font.Name = 'Verdana'
        Font.Style = []
        ParentFont = False
      end
      object snLabel8: TsnLabel
        Left = 36
        Top = 105
        Width = 70
        Height = 16
        Caption = 'Nro. Docu.'
        Font.Charset = ANSI_CHARSET
        Font.Color = clWindowText
        Font.Height = -13
        Font.Name = 'Verdana'
        Font.Style = []
        ParentFont = False
      end
      object snLabel3: TsnLabel
        Left = 36
        Top = 129
        Width = 92
        Height = 16
        Caption = 'Tipo Individuo'
        Font.Charset = ANSI_CHARSET
        Font.Color = clWindowText
        Font.Height = -13
        Font.Name = 'Verdana'
        Font.Style = []
        ParentFont = False
      end
      object snLabel4: TsnLabel
        Left = 36
        Top = 153
        Width = 80
        Height = 16
        Caption = 'Nro. Interno'
        Font.Charset = ANSI_CHARSET
        Font.Color = clWindowText
        Font.Height = -13
        Font.Name = 'Verdana'
        Font.Style = []
        ParentFont = False
      end
      object snLabel5: TsnLabel
        Left = 36
        Top = 177
        Width = 50
        Height = 16
        Caption = 'Apellido'
        Font.Charset = ANSI_CHARSET
        Font.Color = clWindowText
        Font.Height = -13
        Font.Name = 'Verdana'
        Font.Style = []
        ParentFont = False
      end
      object snLabel6: TsnLabel
        Left = 36
        Top = 201
        Width = 49
        Height = 16
        Caption = 'Nombre'
        Font.Charset = ANSI_CHARSET
        Font.Color = clWindowText
        Font.Height = -13
        Font.Name = 'Verdana'
        Font.Style = []
        ParentFont = False
      end
      object snLabel9: TsnLabel
        Left = 36
        Top = 225
        Width = 41
        Height = 16
        Caption = 'Apodo'
        Font.Charset = ANSI_CHARSET
        Font.Color = clWindowText
        Font.Height = -13
        Font.Name = 'Verdana'
        Font.Style = []
        ParentFont = False
      end
      object snLabel10: TsnLabel
        Left = 36
        Top = 249
        Width = 82
        Height = 16
        Caption = 'Nacionalidad'
        Font.Charset = ANSI_CHARSET
        Font.Color = clWindowText
        Font.Height = -13
        Font.Name = 'Verdana'
        Font.Style = []
        ParentFont = False
      end
      object snLabel11: TsnLabel
        Left = 36
        Top = 291
        Width = 125
        Height = 22
        Caption = 'Características'
        Font.Charset = ANSI_CHARSET
        Font.Color = clWindowText
        Font.Height = -19
        Font.Name = 'Times New Roman'
        Font.Style = [fsBold]
        ParentFont = False
      end
      object snLabel12: TsnLabel
        Left = 36
        Top = 323
        Width = 32
        Height = 16
        Caption = 'Sexo'
        Font.Charset = ANSI_CHARSET
        Font.Color = clWindowText
        Font.Height = -13
        Font.Name = 'Verdana'
        Font.Style = []
        ParentFont = False
      end
      object snLabel13: TsnLabel
        Left = 36
        Top = 347
        Width = 31
        Height = 16
        Caption = 'Raza'
        Font.Charset = ANSI_CHARSET
        Font.Color = clWindowText
        Font.Height = -13
        Font.Name = 'Verdana'
        Font.Style = []
        ParentFont = False
      end
      object snLabel14: TsnLabel
        Left = 36
        Top = 371
        Width = 39
        Height = 16
        Caption = 'Altura'
        Font.Charset = ANSI_CHARSET
        Font.Color = clWindowText
        Font.Height = -13
        Font.Name = 'Verdana'
        Font.Style = []
        ParentFont = False
      end
      object snLabel15: TsnLabel
        Left = 36
        Top = 395
        Width = 73
        Height = 16
        Caption = 'Complexión'
        Font.Charset = ANSI_CHARSET
        Font.Color = clWindowText
        Font.Height = -13
        Font.Name = 'Verdana'
        Font.Style = []
        ParentFont = False
      end
      object snLabel16: TsnLabel
        Left = 36
        Top = 419
        Width = 32
        Height = 16
        Caption = 'Edad'
        Font.Charset = ANSI_CHARSET
        Font.Color = clWindowText
        Font.Height = -13
        Font.Name = 'Verdana'
        Font.Style = []
        ParentFont = False
      end
      object snLabel17: TsnLabel
        Left = 36
        Top = 443
        Width = 85
        Height = 16
        Caption = 'Color Cabello'
        Font.Charset = ANSI_CHARSET
        Font.Color = clWindowText
        Font.Height = -13
        Font.Name = 'Verdana'
        Font.Style = []
        ParentFont = False
      end
      object snLabel18: TsnLabel
        Left = 364
        Top = 323
        Width = 70
        Height = 16
        Caption = 'Tipo Barba'
        Font.Charset = ANSI_CHARSET
        Font.Color = clWindowText
        Font.Height = -13
        Font.Name = 'Verdana'
        Font.Style = []
        ParentFont = False
      end
      object snLabel19: TsnLabel
        Left = 364
        Top = 347
        Width = 47
        Height = 16
        Caption = 'Cabello'
        Font.Charset = ANSI_CHARSET
        Font.Color = clWindowText
        Font.Height = -13
        Font.Name = 'Verdana'
        Font.Style = []
        ParentFont = False
      end
      object snLabel20: TsnLabel
        Left = 364
        Top = 371
        Width = 32
        Height = 16
        Caption = 'Nariz'
        Font.Charset = ANSI_CHARSET
        Font.Color = clWindowText
        Font.Height = -13
        Font.Name = 'Verdana'
        Font.Style = []
        ParentFont = False
      end
      object snLabel21: TsnLabel
        Left = 364
        Top = 395
        Width = 58
        Height = 16
        Caption = 'Anteojos'
        Font.Charset = ANSI_CHARSET
        Font.Color = clWindowText
        Font.Height = -13
        Font.Name = 'Verdana'
        Font.Style = []
        ParentFont = False
      end
      object snLabel22: TsnLabel
        Left = 364
        Top = 419
        Width = 47
        Height = 16
        Caption = 'Marcas'
        Font.Charset = ANSI_CHARSET
        Font.Color = clWindowText
        Font.Height = -13
        Font.Name = 'Verdana'
        Font.Style = []
        ParentFont = False
      end
      object snLabel23: TsnLabel
        Left = 364
        Top = 443
        Width = 46
        Height = 16
        Caption = 'Rasgos'
        Font.Charset = ANSI_CHARSET
        Font.Color = clWindowText
        Font.Height = -13
        Font.Name = 'Verdana'
        Font.Style = []
        ParentFont = False
      end
      object snLabel24: TsnLabel
        Left = 363
        Top = 42
        Width = 90
        Height = 22
        Caption = 'Empleados'
        Font.Charset = ANSI_CHARSET
        Font.Color = clWindowText
        Font.Height = -19
        Font.Name = 'Times New Roman'
        Font.Style = [fsBold]
        ParentFont = False
      end
      object snLabel25: TsnLabel
        Left = 364
        Top = 81
        Width = 43
        Height = 16
        Caption = 'Legajo'
        Font.Charset = ANSI_CHARSET
        Font.Color = clWindowText
        Font.Height = -13
        Font.Name = 'Verdana'
        Font.Style = []
        ParentFont = False
      end
      object snLabel26: TsnLabel
        Left = 364
        Top = 105
        Width = 44
        Height = 16
        Caption = 'Sector'
        Font.Charset = ANSI_CHARSET
        Font.Color = clWindowText
        Font.Height = -13
        Font.Name = 'Verdana'
        Font.Style = []
        ParentFont = False
      end
      object snLabel27: TsnLabel
        Left = 364
        Top = 129
        Width = 38
        Height = 16
        Caption = 'Cargo'
        Font.Charset = ANSI_CHARSET
        Font.Color = clWindowText
        Font.Height = -13
        Font.Name = 'Verdana'
        Font.Style = []
        ParentFont = False
      end
      object snLabel28: TsnLabel
        Left = 364
        Top = 153
        Width = 63
        Height = 16
        Caption = 'Condición'
        Font.Charset = ANSI_CHARSET
        Font.Color = clWindowText
        Font.Height = -13
        Font.Name = 'Verdana'
        Font.Style = []
        ParentFont = False
      end
      object snLabel1: TsnLabel
        Left = 363
        Top = 180
        Width = 71
        Height = 22
        Caption = 'Vehículo'
        Font.Charset = ANSI_CHARSET
        Font.Color = clWindowText
        Font.Height = -19
        Font.Name = 'Times New Roman'
        Font.Style = [fsBold]
        ParentFont = False
      end
      object snLabel29: TsnLabel
        Left = 364
        Top = 210
        Width = 50
        Height = 16
        Caption = 'Dominio'
        Font.Charset = ANSI_CHARSET
        Font.Color = clWindowText
        Font.Height = -13
        Font.Name = 'Verdana'
        Font.Style = []
        ParentFont = False
      end
      object snLabel30: TsnLabel
        Left = 364
        Top = 258
        Width = 46
        Height = 16
        Caption = 'Modelo'
        Font.Charset = ANSI_CHARSET
        Font.Color = clWindowText
        Font.Height = -13
        Font.Name = 'Verdana'
        Font.Style = []
        ParentFont = False
      end
      object snLabel31: TsnLabel
        Left = 364
        Top = 282
        Width = 33
        Height = 16
        Caption = 'Color'
        Font.Charset = ANSI_CHARSET
        Font.Color = clWindowText
        Font.Height = -13
        Font.Name = 'Verdana'
        Font.Style = []
        ParentFont = False
      end
      object snLabel32: TsnLabel
        Left = 28
        Top = 509
        Width = 89
        Height = 22
        Caption = 'Novedades'
        Font.Charset = ANSI_CHARSET
        Font.Color = clWindowText
        Font.Height = -19
        Font.Name = 'Times New Roman'
        Font.Style = [fsBold]
        ParentFont = False
      end
      object snLabel33: TsnLabel
        Left = 27
        Top = 575
        Width = 81
        Height = 16
        Caption = 'Observación'
        Font.Charset = ANSI_CHARSET
        Font.Color = clWindowText
        Font.Height = -13
        Font.Name = 'Verdana'
        Font.Style = []
        ParentFont = False
      end
      object snLabel34: TsnLabel
        Left = 28
        Top = 603
        Width = 63
        Height = 16
        Caption = 'Nro. Acta'
        Font.Charset = ANSI_CHARSET
        Font.Color = clWindowText
        Font.Height = -13
        Font.Name = 'Verdana'
        Font.Style = []
        ParentFont = False
      end
      object snLabel35: TsnLabel
        Left = 292
        Top = 602
        Width = 143
        Height = 16
        Caption = 'Nro. Acta Revocación'
        Font.Charset = ANSI_CHARSET
        Font.Color = clWindowText
        Font.Height = -13
        Font.Name = 'Verdana'
        Font.Style = []
        ParentFont = False
      end
      object snLabel36: TsnLabel
        Left = 36
        Top = 637
        Width = 164
        Height = 16
        Caption = 'Motivos de Novedades'
        Font.Charset = ANSI_CHARSET
        Font.Color = clWindowText
        Font.Height = -13
        Font.Name = 'Verdana'
        Font.Style = [fsBold]
        ParentFont = False
      end
      object snLabel37: TsnLabel
        Left = 356
        Top = 681
        Width = 149
        Height = 16
        Caption = 'Motivos de Novedades'
        Font.Charset = ANSI_CHARSET
        Font.Color = clWindowText
        Font.Height = -13
        Font.Name = 'Verdana'
        Font.Style = []
        ParentFont = False
      end
      object snLabel38: TsnLabel
        Left = 355
        Top = 636
        Width = 50
        Height = 16
        Caption = 'Estado'
        Font.Charset = ANSI_CHARSET
        Font.Color = clWindowText
        Font.Height = -13
        Font.Name = 'Verdana'
        Font.Style = [fsBold]
        ParentFont = False
      end
      object snLabel39: TsnLabel
        Left = 36
        Top = 467
        Width = 81
        Height = 16
        Caption = 'Se relaciona'
        Font.Charset = ANSI_CHARSET
        Font.Color = clWindowText
        Font.Height = -13
        Font.Name = 'Verdana'
        Font.Style = []
        ParentFont = False
      end
      object snLabel40: TsnLabel
        Left = 364
        Top = 234
        Width = 40
        Height = 16
        Caption = 'Marca'
        Font.Charset = ANSI_CHARSET
        Font.Color = clWindowText
        Font.Height = -13
        Font.Name = 'Verdana'
        Font.Style = []
        ParentFont = False
      end
      object snLabel41: TsnLabel
        Left = 36
        Top = 467
        Width = 57
        Height = 16
        Caption = 'Caracter'
        Font.Charset = ANSI_CHARSET
        Font.Color = clWindowText
        Font.Height = -13
        Font.Name = 'Verdana'
        Font.Style = []
        ParentFont = False
        Visible = False
      end
      object snLabel42: TsnLabel
        Left = 28
        Top = 545
        Width = 180
        Height = 16
        Caption = 'Fecha Desde Alta Individuo'
        Font.Charset = ANSI_CHARSET
        Font.Color = clWindowText
        Font.Height = -13
        Font.Name = 'Verdana'
        Font.Style = []
        ParentFont = False
      end
      object snLabel43: TsnLabel
        Left = 332
        Top = 545
        Width = 178
        Height = 16
        Caption = 'Fecha Hasta Alta Individuo'
        Font.Charset = ANSI_CHARSET
        Font.Color = clWindowText
        Font.Height = -13
        Font.Name = 'Verdana'
        Font.Style = []
        ParentFont = False
      end
      object snLabel45: TsnLabel
        Left = 38
        Top = 15
        Width = 83
        Height = 16
        Caption = 'Ordenar por '
        Font.Charset = ANSI_CHARSET
        Font.Color = clWindowText
        Font.Height = -13
        Font.Name = 'Verdana'
        Font.Style = []
        ParentFont = False
      end
      object snDBLookup2: TsnDBLookup
        Left = 132
        Top = 77
        DataBinding.DataField = 'oid_tipo_documento'
        DataBinding.DataSource = DSTIndividuoExcluido
        ParentFont = False
        Properties.KeyFieldNames = 'oid'
        Properties.ListColumns = <
          item
            FieldName = 'descripcion'
          end>
        Properties.ListOptions.ShowHeader = False
        Properties.ListSource = DSTipoDocumento
        Style.Font.Charset = ANSI_CHARSET
        Style.Font.Color = clWindowText
        Style.Font.Height = -13
        Style.Font.Name = 'Verdana'
        Style.Font.Style = []
        Style.IsFontAssigned = True
        TabOrder = 0
        Width = 201
      end
      object snDBEdit4: TsnDBEdit
        Left = 132
        Top = 101
        DataBinding.DataField = 'nro_documento'
        DataBinding.DataSource = DSTIndividuoExcluido
        ParentFont = False
        Properties.MaxLength = 50
        Properties.ReadOnly = False
        Style.Font.Charset = ANSI_CHARSET
        Style.Font.Color = clWindowText
        Style.Font.Height = -13
        Style.Font.Name = 'Verdana'
        Style.Font.Style = []
        Style.IsFontAssigned = True
        TabOrder = 1
        Width = 201
      end
      object snDBLookup1: TsnDBLookup
        Left = 132
        Top = 125
        DataBinding.DataField = 'tipo'
        DataBinding.DataSource = DSTIndividuoExcluido
        ParentFont = False
        Properties.KeyFieldNames = 'codigo'
        Properties.ListColumns = <
          item
            FieldName = 'descripcion'
          end>
        Properties.ListOptions.ShowHeader = False
        Properties.ListSource = DSTipoEmpleado
        Style.Font.Charset = ANSI_CHARSET
        Style.Font.Color = clWindowText
        Style.Font.Height = -13
        Style.Font.Name = 'Verdana'
        Style.Font.Style = []
        Style.IsFontAssigned = True
        TabOrder = 2
        Width = 105
      end
      object snDBEdit1: TsnDBEdit
        Left = 132
        Top = 149
        DataBinding.DataField = 'oid_individuo'
        DataBinding.DataSource = DSTIndividuoExcluido
        ParentFont = False
        Properties.ReadOnly = False
        Style.Font.Charset = ANSI_CHARSET
        Style.Font.Color = clWindowText
        Style.Font.Height = -13
        Style.Font.Name = 'Verdana'
        Style.Font.Style = []
        Style.IsFontAssigned = True
        TabOrder = 3
        Width = 105
      end
      object snDBEdit2: TsnDBEdit
        Left = 132
        Top = 173
        DataBinding.DataField = 'apellido'
        DataBinding.DataSource = DSTIndividuoExcluido
        ParentFont = False
        Properties.CharCase = ecUpperCase
        Properties.MaxLength = 50
        Style.Font.Charset = ANSI_CHARSET
        Style.Font.Color = clWindowText
        Style.Font.Height = -13
        Style.Font.Name = 'Verdana'
        Style.Font.Style = []
        Style.IsFontAssigned = True
        TabOrder = 4
        Width = 205
      end
      object snDBEdit3: TsnDBEdit
        Left = 132
        Top = 197
        DataBinding.DataField = 'nombre'
        DataBinding.DataSource = DSTIndividuoExcluido
        ParentFont = False
        Properties.CharCase = ecUpperCase
        Properties.MaxLength = 50
        Style.Font.Charset = ANSI_CHARSET
        Style.Font.Color = clWindowText
        Style.Font.Height = -13
        Style.Font.Name = 'Verdana'
        Style.Font.Style = []
        Style.IsFontAssigned = True
        TabOrder = 5
        Width = 205
      end
      object snDBEdit5: TsnDBEdit
        Left = 132
        Top = 221
        DataBinding.DataField = 'apodo'
        DataBinding.DataSource = DSTIndividuoExcluido
        ParentFont = False
        Properties.CharCase = ecUpperCase
        Properties.MaxLength = 50
        Style.Font.Charset = ANSI_CHARSET
        Style.Font.Color = clWindowText
        Style.Font.Height = -13
        Style.Font.Name = 'Verdana'
        Style.Font.Style = []
        Style.IsFontAssigned = True
        TabOrder = 6
        Width = 205
      end
      object snDBLookup3: TsnDBLookup
        Left = 132
        Top = 245
        DataBinding.DataField = 'oid_nacionalidad'
        DataBinding.DataSource = DSTIndividuoExcluido
        ParentFont = False
        Properties.KeyFieldNames = 'oid'
        Properties.ListColumns = <
          item
            FieldName = 'descripcion'
          end>
        Properties.ListOptions.ShowHeader = False
        Properties.ListSource = DSNacionalidad
        Style.Font.Charset = ANSI_CHARSET
        Style.Font.Color = clWindowText
        Style.Font.Height = -13
        Style.Font.Name = 'Verdana'
        Style.Font.Style = []
        Style.IsFontAssigned = True
        TabOrder = 7
        Width = 205
      end
      object snDBLookup4: TsnDBLookup
        Left = 132
        Top = 319
        DataBinding.DataField = 'sexo'
        DataBinding.DataSource = DSTIndividuoExcluido
        ParentFont = False
        Properties.KeyFieldNames = 'codigo'
        Properties.ListColumns = <
          item
            FieldName = 'descripcion'
          end>
        Properties.ListOptions.ShowHeader = False
        Properties.ListSource = DSSexo
        Style.Font.Charset = ANSI_CHARSET
        Style.Font.Color = clWindowText
        Style.Font.Height = -13
        Style.Font.Name = 'Verdana'
        Style.Font.Style = []
        Style.IsFontAssigned = True
        TabOrder = 8
        Width = 113
      end
      object snDBLookup5: TsnDBLookup
        Left = 132
        Top = 343
        DataBinding.DataField = 'oid_raza'
        DataBinding.DataSource = DSTIndividuoExcluido
        ParentFont = False
        Properties.KeyFieldNames = 'oid'
        Properties.ListColumns = <
          item
            FieldName = 'descripcion'
          end>
        Properties.ListOptions.ShowHeader = False
        Properties.ListSource = DSRaza
        Style.Font.Charset = ANSI_CHARSET
        Style.Font.Color = clWindowText
        Style.Font.Height = -13
        Style.Font.Name = 'Verdana'
        Style.Font.Style = []
        Style.IsFontAssigned = True
        TabOrder = 9
        Width = 205
      end
      object snDBLookup6: TsnDBLookup
        Left = 132
        Top = 367
        DataBinding.DataField = 'oid_altura'
        DataBinding.DataSource = DSTIndividuoExcluido
        ParentFont = False
        Properties.KeyFieldNames = 'oid'
        Properties.ListColumns = <
          item
            FieldName = 'descripcion'
          end>
        Properties.ListOptions.ShowHeader = False
        Properties.ListSource = DSAltura
        Style.Font.Charset = ANSI_CHARSET
        Style.Font.Color = clWindowText
        Style.Font.Height = -13
        Style.Font.Name = 'Verdana'
        Style.Font.Style = []
        Style.IsFontAssigned = True
        TabOrder = 10
        Width = 205
      end
      object snDBLookup7: TsnDBLookup
        Left = 132
        Top = 391
        DataBinding.DataField = 'oid_complexion'
        DataBinding.DataSource = DSTIndividuoExcluido
        ParentFont = False
        Properties.KeyFieldNames = 'oid'
        Properties.ListColumns = <
          item
            FieldName = 'descripcion'
          end>
        Properties.ListOptions.ShowHeader = False
        Properties.ListSource = DSComplexion
        Style.Font.Charset = ANSI_CHARSET
        Style.Font.Color = clWindowText
        Style.Font.Height = -13
        Style.Font.Name = 'Verdana'
        Style.Font.Style = []
        Style.IsFontAssigned = True
        TabOrder = 11
        Width = 205
      end
      object snDBLookup8: TsnDBLookup
        Left = 132
        Top = 415
        DataBinding.DataField = 'oid_edad'
        DataBinding.DataSource = DSTIndividuoExcluido
        ParentFont = False
        Properties.KeyFieldNames = 'oid'
        Properties.ListColumns = <
          item
            FieldName = 'descripcion'
          end>
        Properties.ListOptions.ShowHeader = False
        Properties.ListSource = dsEdad
        Style.Font.Charset = ANSI_CHARSET
        Style.Font.Color = clWindowText
        Style.Font.Height = -13
        Style.Font.Name = 'Verdana'
        Style.Font.Style = []
        Style.IsFontAssigned = True
        TabOrder = 12
        Width = 205
      end
      object snDBLookup9: TsnDBLookup
        Left = 132
        Top = 439
        DataBinding.DataField = 'oid_color'
        DataBinding.DataSource = DSTIndividuoExcluido
        ParentFont = False
        Properties.KeyFieldNames = 'oid'
        Properties.ListColumns = <
          item
            FieldName = 'descripcion'
          end>
        Properties.ListOptions.ShowHeader = False
        Properties.ListSource = DSTColorCabello
        Style.Font.Charset = ANSI_CHARSET
        Style.Font.Color = clWindowText
        Style.Font.Height = -13
        Style.Font.Name = 'Verdana'
        Style.Font.Style = []
        Style.IsFontAssigned = True
        TabOrder = 13
        Width = 205
      end
      object snDBLookup10: TsnDBLookup
        Left = 460
        Top = 319
        DataBinding.DataField = 'oid_tipo_barba'
        DataBinding.DataSource = DSTIndividuoExcluido
        ParentFont = False
        Properties.KeyFieldNames = 'oid'
        Properties.ListColumns = <
          item
            FieldName = 'descripcion'
          end>
        Properties.ListOptions.ShowHeader = False
        Properties.ListSource = DSTipoBarba
        Style.Font.Charset = ANSI_CHARSET
        Style.Font.Color = clWindowText
        Style.Font.Height = -13
        Style.Font.Name = 'Verdana'
        Style.Font.Style = []
        Style.IsFontAssigned = True
        TabOrder = 18
        Width = 205
      end
      object snDBLookup11: TsnDBLookup
        Left = 460
        Top = 343
        DataBinding.DataField = 'oid_tipo_cabello'
        DataBinding.DataSource = DSTIndividuoExcluido
        ParentFont = False
        Properties.KeyFieldNames = 'oid'
        Properties.ListColumns = <
          item
            FieldName = 'descripcion'
          end>
        Properties.ListOptions.ShowHeader = False
        Properties.ListSource = DSCabello
        Style.Font.Charset = ANSI_CHARSET
        Style.Font.Color = clWindowText
        Style.Font.Height = -13
        Style.Font.Name = 'Verdana'
        Style.Font.Style = []
        Style.IsFontAssigned = True
        TabOrder = 19
        Width = 205
      end
      object snDBLookup12: TsnDBLookup
        Left = 460
        Top = 367
        DataBinding.DataField = 'oid_tipo_nariz'
        DataBinding.DataSource = DSTIndividuoExcluido
        ParentFont = False
        Properties.KeyFieldNames = 'oid'
        Properties.ListColumns = <
          item
            FieldName = 'descripcion'
          end>
        Properties.ListOptions.ShowHeader = False
        Properties.ListSource = DSTNariz
        Style.Font.Charset = ANSI_CHARSET
        Style.Font.Color = clWindowText
        Style.Font.Height = -13
        Style.Font.Name = 'Verdana'
        Style.Font.Style = []
        Style.IsFontAssigned = True
        TabOrder = 20
        Width = 205
      end
      object snDBLookup13: TsnDBLookup
        Left = 460
        Top = 391
        DataBinding.DataField = 'anteojos'
        DataBinding.DataSource = DSTIndividuoExcluido
        ParentFont = False
        Properties.KeyFieldNames = 'codigo'
        Properties.ListColumns = <
          item
            FieldName = 'descripcion'
          end>
        Properties.ListOptions.ShowHeader = False
        Properties.ListSource = DSSI
        Style.Font.Charset = ANSI_CHARSET
        Style.Font.Color = clWindowText
        Style.Font.Height = -13
        Style.Font.Name = 'Verdana'
        Style.Font.Style = []
        Style.IsFontAssigned = True
        TabOrder = 21
        Width = 49
      end
      object snDBEdit10: TsnDBEdit
        Left = 460
        Top = 77
        DataBinding.DataField = 'legajo'
        DataBinding.DataSource = DSTIndividuoExcluido
        ParentFont = False
        Properties.MaxLength = 50
        Style.Font.Charset = ANSI_CHARSET
        Style.Font.Color = clWindowText
        Style.Font.Height = -13
        Style.Font.Name = 'Verdana'
        Style.Font.Style = []
        Style.IsFontAssigned = True
        TabOrder = 24
        Width = 201
      end
      object snDBLookup15: TsnDBLookup
        Left = 460
        Top = 101
        DataBinding.DataField = 'oid_sector'
        DataBinding.DataSource = DSTIndividuoExcluido
        ParentFont = False
        Properties.KeyFieldNames = 'oid'
        Properties.ListColumns = <
          item
            FieldName = 'descripcion'
          end>
        Properties.ListOptions.ShowHeader = False
        Properties.ListSource = DSSector
        Style.Font.Charset = ANSI_CHARSET
        Style.Font.Color = clWindowText
        Style.Font.Height = -13
        Style.Font.Name = 'Verdana'
        Style.Font.Style = []
        Style.IsFontAssigned = True
        TabOrder = 25
        Width = 201
      end
      object snDBLookup16: TsnDBLookup
        Left = 460
        Top = 125
        DataBinding.DataField = 'oid_cargo'
        DataBinding.DataSource = DSTIndividuoExcluido
        ParentFont = False
        Properties.KeyFieldNames = 'oid'
        Properties.ListColumns = <
          item
            FieldName = 'descripcion'
          end>
        Properties.ListOptions.ShowHeader = False
        Properties.ListSource = dsCargo
        Style.Font.Charset = ANSI_CHARSET
        Style.Font.Color = clWindowText
        Style.Font.Height = -13
        Style.Font.Name = 'Verdana'
        Style.Font.Style = []
        Style.IsFontAssigned = True
        TabOrder = 26
        Width = 201
      end
      object snDBLookup17: TsnDBLookup
        Left = 460
        Top = 149
        DataBinding.DataField = 'tipo_condicion'
        DataBinding.DataSource = DSTIndividuoExcluido
        ParentFont = False
        Properties.KeyFieldNames = 'codigo'
        Properties.ListColumns = <
          item
            FieldName = 'descripcion'
          end>
        Properties.ListOptions.ShowHeader = False
        Properties.ListSource = DSCondicion
        Style.Font.Charset = ANSI_CHARSET
        Style.Font.Color = clWindowText
        Style.Font.Height = -13
        Style.Font.Name = 'Verdana'
        Style.Font.Style = []
        Style.IsFontAssigned = True
        TabOrder = 27
        Width = 201
      end
      object snDBEdit8: TsnDBEdit
        Left = 460
        Top = 206
        DataBinding.DataField = 'dominio'
        DataBinding.DataSource = DSTIndividuoExcluido
        ParentFont = False
        Properties.MaxLength = 50
        Style.Font.Charset = ANSI_CHARSET
        Style.Font.Color = clWindowText
        Style.Font.Height = -13
        Style.Font.Name = 'Verdana'
        Style.Font.Style = []
        Style.IsFontAssigned = True
        TabOrder = 28
        Width = 205
      end
      object snDBEdit9: TsnDBEdit
        Left = 460
        Top = 254
        DataBinding.DataField = 'modelo'
        DataBinding.DataSource = DSTIndividuoExcluido
        ParentFont = False
        Properties.MaxLength = 50
        Style.Font.Charset = ANSI_CHARSET
        Style.Font.Color = clWindowText
        Style.Font.Height = -13
        Style.Font.Name = 'Verdana'
        Style.Font.Style = []
        Style.IsFontAssigned = True
        TabOrder = 30
        Width = 205
      end
      object snDBLookup14: TsnDBLookup
        Left = 460
        Top = 278
        DataBinding.DataField = 'oid_color_vehiculo'
        DataBinding.DataSource = DSTIndividuoExcluido
        ParentFont = False
        Properties.KeyFieldNames = 'oid'
        Properties.ListColumns = <
          item
            FieldName = 'descripcion'
          end>
        Properties.ListOptions.ShowHeader = False
        Properties.ListSource = DSColor
        Style.Font.Charset = ANSI_CHARSET
        Style.Font.Color = clWindowText
        Style.Font.Height = -13
        Style.Font.Name = 'Verdana'
        Style.Font.Style = []
        Style.IsFontAssigned = True
        TabOrder = 31
        Width = 205
      end
      object snDBEdit11: TsnDBEdit
        Left = 124
        Top = 571
        DataBinding.DataField = 'observacion'
        DataBinding.DataSource = DSTIndividuoExcluido
        ParentFont = False
        Properties.MaxLength = 50
        Style.Font.Charset = ANSI_CHARSET
        Style.Font.Color = clWindowText
        Style.Font.Height = -13
        Style.Font.Name = 'Verdana'
        Style.Font.Style = []
        Style.IsFontAssigned = True
        TabOrder = 32
        Width = 533
      end
      object snDBEdit12: TsnDBEdit
        Left = 124
        Top = 599
        DataBinding.DataField = 'nro_acta'
        DataBinding.DataSource = DSTIndividuoExcluido
        ParentFont = False
        Properties.MaxLength = 50
        Style.Font.Charset = ANSI_CHARSET
        Style.Font.Color = clWindowText
        Style.Font.Height = -13
        Style.Font.Name = 'Verdana'
        Style.Font.Style = []
        Style.IsFontAssigned = True
        TabOrder = 33
        Width = 133
      end
      object snDBEdit13: TsnDBEdit
        Left = 452
        Top = 599
        DataBinding.DataField = 'nro_acta_revo'
        DataBinding.DataSource = DSTIndividuoExcluido
        ParentFont = False
        Properties.MaxLength = 50
        Style.Font.Charset = ANSI_CHARSET
        Style.Font.Color = clWindowText
        Style.Font.Height = -13
        Style.Font.Name = 'Verdana'
        Style.Font.Style = []
        Style.IsFontAssigned = True
        TabOrder = 34
        Width = 133
      end
      object dxDBGridSN1: TdxDBGridSN
        Left = 36
        Top = 656
        Width = 289
        Height = 232
        TabOrder = 35
        CriteriosPintarCelda = <>
        object dxDBGridSN1DBTableView1: TcxGridDBTableView
          NavigatorButtons.ConfirmDelete = False
          DataController.DataSource = DSMotivosNovedades
          DataController.Summary.DefaultGroupSummaryItems = <>
          DataController.Summary.FooterSummaryItems = <>
          DataController.Summary.SummaryGroups = <>
          OptionsCustomize.ColumnFiltering = False
          OptionsCustomize.GroupBySorting = True
          OptionsData.Deleting = False
          OptionsData.Inserting = False
          OptionsView.GroupByBox = False
          object dxDBGridSN1DBTableView1sel: TcxGridDBColumn
            Caption = 'Sel.'
            DataBinding.FieldName = 'sel'
          end
          object dxDBGridSN1DBTableView1descripcion: TcxGridDBColumn
            Caption = 'Motivo'
            DataBinding.FieldName = 'descripcion'
            HeaderAlignmentHorz = taCenter
            Options.Editing = False
            Options.Focusing = False
            Width = 229
          end
        end
        object dxDBGridSN1Level1: TcxGridLevel
          GridView = dxDBGridSN1DBTableView1
        end
      end
      object dxDBGridSN2: TdxDBGridSN
        Left = 348
        Top = 656
        Width = 289
        Height = 232
        TabOrder = 36
        CriteriosPintarCelda = <>
        object cxGridDBTableView1: TcxGridDBTableView
          NavigatorButtons.ConfirmDelete = False
          DataController.DataSource = DSEstados
          DataController.Summary.DefaultGroupSummaryItems = <>
          DataController.Summary.FooterSummaryItems = <>
          DataController.Summary.SummaryGroups = <>
          OptionsCustomize.ColumnFiltering = False
          OptionsCustomize.GroupBySorting = True
          OptionsData.Deleting = False
          OptionsData.Inserting = False
          OptionsView.GroupByBox = False
          object cxGridDBColumn1: TcxGridDBColumn
            Caption = 'Sel.'
            DataBinding.FieldName = 'sel'
          end
          object cxGridDBColumn2: TcxGridDBColumn
            Caption = 'Estado'
            DataBinding.FieldName = 'descripcion'
            HeaderAlignmentHorz = taCenter
            Options.Editing = False
            Options.Focusing = False
            Width = 229
          end
        end
        object cxGridLevel1: TcxGridLevel
          GridView = cxGridDBTableView1
        end
      end
      object snDBLookup18: TsnDBLookup
        Left = 412
        Top = 633
        DataBinding.DataField = 'comportamiento_estado'
        DataBinding.DataSource = DSTIndividuoExcluido
        ParentFont = False
        Properties.KeyFieldNames = 'codigo'
        Properties.ListColumns = <
          item
            FieldName = 'descripcion'
          end>
        Properties.ListOptions.ShowHeader = False
        Properties.ListSource = DSComportamientoEstado
        Style.Font.Charset = ANSI_CHARSET
        Style.Font.Color = clWindowText
        Style.Font.Height = -13
        Style.Font.Name = 'Verdana'
        Style.Font.Style = []
        Style.IsFontAssigned = True
        TabOrder = 37
        Width = 205
      end
      object srnDBButtonEdit1: TsrnDBButtonEdit
        Left = 132
        Top = 463
        DataBinding.DataField = 'nro_ind_relacion'
        DataBinding.DataSource = DSTIndividuoExcluido
        ParentFont = False
        Properties.Buttons = <
          item
            Default = True
            Kind = bkEllipsis
          end>
        Style.Font.Charset = ANSI_CHARSET
        Style.Font.Color = clWindowText
        Style.Font.Height = -13
        Style.Font.Name = 'Verdana'
        Style.Font.Style = []
        Style.IsFontAssigned = True
        TabOrder = 38
        Width = 121
      end
      object snDBEdit14: TsnDBEdit
        Left = 250
        Top = 463
        TabStop = False
        DataBinding.DataField = 'ape_y_nom_relacion'
        DataBinding.DataSource = DSTIndividuoExcluido
        ParentFont = False
        Properties.MaxLength = 50
        Properties.ReadOnly = True
        Style.Font.Charset = ANSI_CHARSET
        Style.Font.Color = clWindowText
        Style.Font.Height = -13
        Style.Font.Name = 'Verdana'
        Style.Font.Style = []
        Style.IsFontAssigned = True
        TabOrder = 39
        Width = 415
      end
      object snDBEdit15: TsnDBEdit
        Left = 460
        Top = 230
        DataBinding.DataField = 'marca'
        DataBinding.DataSource = DSTIndividuoExcluido
        ParentFont = False
        Properties.MaxLength = 50
        Style.Font.Charset = ANSI_CHARSET
        Style.Font.Color = clWindowText
        Style.Font.Height = -13
        Style.Font.Name = 'Verdana'
        Style.Font.Style = []
        Style.IsFontAssigned = True
        TabOrder = 29
        Width = 205
      end
      object snDBLookup19: TsnDBLookup
        Left = 132
        Top = 463
        DataBinding.DataField = 'oid_caracter'
        DataBinding.DataSource = DSTIndividuoExcluido
        ParentFont = False
        Properties.KeyFieldNames = 'oid'
        Properties.ListColumns = <
          item
            FieldName = 'descripcion'
          end>
        Properties.ListOptions.ShowHeader = False
        Properties.ListSource = DSCaracter
        Style.Font.Charset = ANSI_CHARSET
        Style.Font.Color = clWindowText
        Style.Font.Height = -13
        Style.Font.Name = 'Verdana'
        Style.Font.Style = []
        Style.IsFontAssigned = True
        TabOrder = 14
        Visible = False
        Width = 205
      end
      object DBFecAltaDesde: TsnDBDateEdit
        Left = 219
        Top = 542
        DataBinding.DataField = 'fec_alta_desde'
        DataBinding.DataSource = DSTIndividuoExcluido
        ParentFont = False
        Style.Font.Charset = DEFAULT_CHARSET
        Style.Font.Color = clWindowText
        Style.Font.Height = -13
        Style.Font.Name = 'MS Sans Serif'
        Style.Font.Style = []
        Style.IsFontAssigned = True
        TabOrder = 16
        ReadOnlyAlways = False
        Width = 102
      end
      object snDBDateEdit1: TsnDBDateEdit
        Left = 523
        Top = 542
        DataBinding.DataField = 'fec_alta_hasta'
        DataBinding.DataSource = DSTIndividuoExcluido
        ParentFont = False
        Style.Font.Charset = DEFAULT_CHARSET
        Style.Font.Color = clWindowText
        Style.Font.Height = -13
        Style.Font.Name = 'MS Sans Serif'
        Style.Font.Style = []
        Style.IsFontAssigned = True
        TabOrder = 17
        ReadOnlyAlways = False
        Width = 102
      end
      object snDBCheckEdit1: TsnDBCheckEdit
        Left = 128
        Top = 510
        Caption = 'Novedad Activa Sin Vigencia Hasta (Indefinido)'
        DataBinding.DataField = 'sin_vigencia_hasta'
        DataBinding.DataSource = DSTIndividuoExcluido
        ParentFont = False
        Style.Font.Charset = DEFAULT_CHARSET
        Style.Font.Color = clWindowText
        Style.Font.Height = -13
        Style.Font.Name = 'MS Sans Serif'
        Style.Font.Style = []
        Style.IsFontAssigned = True
        TabOrder = 15
        Width = 313
      end
      object snDBLookup20: TsnDBLookup
        Left = 460
        Top = 415
        DataBinding.DataField = 'oid_marca'
        DataBinding.DataSource = DSTIndividuoExcluido
        ParentFont = False
        Properties.KeyFieldNames = 'oid'
        Properties.ListColumns = <
          item
            FieldName = 'descripcion'
          end>
        Properties.ListOptions.ShowHeader = False
        Properties.ListSource = dsTMarcas
        Style.Font.Charset = ANSI_CHARSET
        Style.Font.Color = clWindowText
        Style.Font.Height = -13
        Style.Font.Name = 'Verdana'
        Style.Font.Style = []
        Style.IsFontAssigned = True
        TabOrder = 22
        Width = 205
      end
      object snDBLookup21: TsnDBLookup
        Left = 460
        Top = 439
        DataBinding.DataField = 'oid_rasgo'
        DataBinding.DataSource = DSTIndividuoExcluido
        ParentFont = False
        Properties.KeyFieldNames = 'oid'
        Properties.ListColumns = <
          item
            FieldName = 'descripcion'
          end>
        Properties.ListOptions.ShowHeader = False
        Properties.ListSource = DSTRasgos
        Style.Font.Charset = ANSI_CHARSET
        Style.Font.Color = clWindowText
        Style.Font.Height = -13
        Style.Font.Name = 'Verdana'
        Style.Font.Style = []
        Style.IsFontAssigned = True
        TabOrder = 23
        Width = 205
      end
      object snDBLookup22: TsnDBLookup
        Left = 130
        Top = 13
        DataBinding.DataField = 'ordenar_por'
        DataBinding.DataSource = DSTIndividuoExcluido
        ParentFont = False
        Properties.KeyFieldNames = 'codigo'
        Properties.ListColumns = <
          item
            FieldName = 'descripcion'
          end>
        Properties.ListOptions.ShowHeader = False
        Properties.ListSource = DSOrdenarPor
        Style.Font.Charset = ANSI_CHARSET
        Style.Font.Color = clWindowText
        Style.Font.Height = -13
        Style.Font.Name = 'Verdana'
        Style.Font.Style = []
        Style.IsFontAssigned = True
        TabOrder = 40
        Width = 201
      end
      object snDBCheckEdit2: TsnDBCheckEdit
        Left = 448
        Top = 510
        Caption = 'Con nro. de Acta de Revocación'
        DataBinding.DataField = 'con_acta_revocacion'
        DataBinding.DataSource = DSTIndividuoExcluido
        ParentFont = False
        Style.Font.Charset = DEFAULT_CHARSET
        Style.Font.Color = clWindowText
        Style.Font.Height = -13
        Style.Font.Name = 'MS Sans Serif'
        Style.Font.Style = []
        Style.IsFontAssigned = True
        TabOrder = 41
        Width = 217
      end
    end
  end
  inherited DriverABM: TDriverABM
    CargaDataSets = <
      item
        DataSet = TTipoEmpleado
        TableName = 'TTipoEmpleado'
      end
      item
        DataSet = TTipoDocumento
        TableName = 'TTipoDocumento'
      end
      item
        DataSet = TNacionalidad
        TableName = 'TNacionalidad'
      end
      item
        DataSet = TSexo
        TableName = 'TSexo'
      end
      item
        DataSet = TMonedas
        TableName = 'TMonedas'
      end
      item
        DataSet = TMotivoNovedad
        TableName = 'TMotivoNovedad'
      end
      item
        DataSet = TSupervisor
        TableName = 'TSupervisor'
      end
      item
        DataSet = TTurno
        TableName = 'TTurno'
      end
      item
        DataSet = TSeRetira
        TableName = 'TSeRetira'
      end
      item
        DataSet = TSector
        TableName = 'TSector'
      end
      item
        DataSet = TCargo
        TableName = 'TCargo'
      end
      item
        DataSet = TCondicion
        TableName = 'TCondicion'
      end
      item
        DataSet = TMotivosDifPago
        TableName = 'TMotivosDifPago'
      end
      item
        DataSet = TAltura
        TableName = 'TAltura'
      end
      item
        DataSet = TComplexion
        TableName = 'TComplexion'
      end
      item
        DataSet = TEdad
        TableName = 'TEdad'
      end
      item
        DataSet = TColor
        TableName = 'TColor'
      end
      item
        DataSet = TTipoBarba
        TableName = 'TTipoBarba'
      end
      item
        DataSet = TRaza
        TableName = 'TRaza'
      end
      item
        DataSet = TNariz
        TableName = 'TNariz'
      end
      item
        DataSet = TCabello
        TableName = 'TCabello'
      end
      item
        DataSet = TRaza
        TableName = 'TRaza'
      end
      item
        DataSet = TNariz
        TableName = 'TNariz'
      end
      item
        DataSet = TCabello
        TableName = 'TCabello'
      end
      item
        DataSet = TColorCabello
        TableName = 'TColorCabello'
      end
      item
        DataSet = TEstados
        TableName = 'TEstados'
      end
      item
        DataSet = TEstados
        TableName = 'TEstados'
      end
      item
        DataSet = TRelacionIndividuo
        TableName = 'TRelacionIndividuo'
      end
      item
        DataSet = TCaracter
        TableName = 'TCaracter'
      end
      item
        DataSet = TMarcas
        TableName = 'TMarcas'
      end
      item
        DataSet = TRasgos
        TableName = 'TRasgos'
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
      '  snDBLookup22.setFoco;'
      'end.')
    OnValidate = <
      item
        TableName = 'TIndividuoExcluido'
        FieldName = 'nro_ind_relacion'
        Source.Strings = (
          'begin'
          '  TraerRelacionIndividuo(Sender.AsInteger);'
          '  if (not TRelacionIndividuo.IsEmpty)'
          '     then begin'
          '             TIndividuoExcluido.EditRecord;'
          
            '             TIndividuoExcluido.FieldName(''ape_y_nom_relacion'').' +
            'AsString :='
          
            '                       TRelacionIndividuo.FieldName(''ape_y_nom'')' +
            '.AsString;'
          
            '             TIndividuoExcluido.FieldName(''oid_ind_relacion'').As' +
            'Integer :='
          
            '                       TRelacionIndividuo.FieldName(''oid_individ' +
            'uo'').AsInteger;'
          '              end'
          '     else begin'
          '             TIndividuoExcluido.EditRecord;'
          
            '             TIndividuoExcluido.FieldName(''ape_y_nom_relacion'').' +
            'AsString := '''';'
          
            '             TIndividuoExcluido.FieldName(''oid_ind_relacion'').Cl' +
            'ear; '
          '             end;'
          ''
          'end.')
      end>
    OnNuevoRegistro = <
      item
        TableName = 'TIndividuoExcluido'
        Source.Strings = (
          'begin'
          '  DataSet.FieldName(''comportamiento_estado'').AsString := ''VIG'';'
          '  DataSet.FieldName(''ordenar_por'').AsString := ''ACTA_DES'';'
          'end.')
      end>
    OnKeyDown = <
      item
        Key = 123
        Shift = []
        isNuevo = True
        isModificar = True
        isBrowse = True
        Source.Strings = (
          'begin'
          '  ConsultarMasiva();'
          'end.')
      end>
    OnInicializar = <
      item
        Source.Strings = (
          'begin'
          '  Varios.setImagen(''ImageBuscar'',0);'
          '  Varios.setImagen(''ImageSalir'',7);'
          '  Inicializar();'
          '  sino();'
          '  cargarCompoEstado();'
          '  TMotivosNovedades.LoadDataSet(TMotivoNovedad);'
          '  TIndividuoExcluido.Close;'
          '  TIndividuoExcluido.Open;'
          '  TIndividuoExcluido.AppendRecord;'
          '   ordernarPor();'
          'end.')
      end>
    OnFormFunction = <
      item
        Source.Strings = (
          'procedure TraerRelacionIndividuo(OidIndividuo : integer);'
          'begin'
          '  operacion.InicioOperacion;'
          '  operacion.setOper(''TraerRelIndiExc'');'
          
            '  operacion.AddAtribute(''oid_individuo'',IntToStr(OidIndividuo));' +
            ' '
          '  operacion.execute();  '
          'end;'
          ''
          'procedure Inicializar();'
          'begin'
          '  operacion.InicioOperacion();'
          '  operacion.setOper(''TraerDatosInicioExcluidos'');'
          ' operacion.execute();'
          'end;'
          ''
          'procedure sino();'
          'begin'
          '  TSINO.close;'
          '  TSINO.open;'
          '  TSINO.appendRecord;'
          '  TSINO.fieldName(''codigo'').AsInteger := 1;'
          '  TSINO.fieldName(''descripcion'').AsString := ''SI'';'
          '  TSINO.postRecord;'
          '  TSINO.appendRecord;'
          '  TSINO.fieldName(''codigo'').AsInteger := 0;'
          '  TSINO.fieldName(''descripcion'').AsString := ''NO'';'
          '  TSINO.postRecord;'
          '  TSI.close;'
          '  TSI.open;'
          '  TSI.appendRecord;'
          '  TSI.fieldName(''codigo'').AsInteger := 1;'
          '  TSI.fieldName(''descripcion'').AsString := ''SI'';'
          '  TSI.postRecord;'
          'end;'
          ''
          'procedure cargarCompoEstado();'
          'begin'
          '   TComportamientoEstado.Close;'
          '   TComportamientoEstado.Open;'
          ''
          '   TComportamientoEstado.AppendRecord;'
          '   TComportamientoEstado.FieldName(''codigo'').AsString := ''VIG'';'
          
            '   TComportamientoEstado.FieldName(''descripcion'').AsString := ''V' +
            'igente sea'';'
          '   TComportamientoEstado.PostRecord;'
          ''
          '   TComportamientoEstado.AppendRecord;'
          '   TComportamientoEstado.FieldName(''codigo'').AsString := ''EAO'';'
          
            '   TComportamientoEstado.FieldName(''descripcion'').AsString := ''E' +
            'n alguna ocasión'';'
          '   TComportamientoEstado.PostRecord;'
          ''
          ''
          'end;'
          ''
          'procedure ConsultarMasiva();'
          'begin'
          '  TIndividuoExcluido.PostRecord;'
          '  TMotivosNovedades.PostRecord;'
          '  TEstados.PostRecord;'
          '  variable.newVariantArray(''parametros'',3);'
          
            '  variable.addKeyTableForArray(''parametros'',0,''TIndividuoExcluid' +
            'o'',''TIndividuoExcluido'');  '
          
            '  variable.addKeyTableForArray(''parametros'',1,''TMotivosNovedades' +
            ''',''TMotivosNovedades'');  '
          
            '  variable.addKeyTableForArray(''parametros'',2,''TEstados'',''TEstad' +
            'os'');  '
          
            '  FormularioConsultaMasiva.params :=  variable.getValue(''paramet' +
            'ros'');'
          '  FormularioConsultaMasiva.Ventana := getVentana();'
          '  FormularioConsultaMasiva.Mostrar(false)'
          'end;'
          ''
          'procedure ordernarPor();'
          'begin'
          '  TOrdenarPor.Close;'
          '  TOrdenarPor.Open;'
          '  TOrdenarPor.AppendRecord;'
          '  TOrdenarPor.FieldName(''codigo'').AsString := ''ACTA_DES'';'
          
            '  TOrdenarPor.FieldName(''descripcion'').AsString := ''Acta de meno' +
            'r a mayor'';'
          '  TOrdenarPor.PostRecord;'
          '  TOrdenarPor.AppendRecord;'
          '  TOrdenarPor.FieldName(''codigo'').AsString := ''ACTA_ASC'';'
          
            '  TOrdenarPor.FieldName(''descripcion'').AsString := ''Acta de mayo' +
            'r a menor'';'
          '  TOrdenarPor.PostRecord;'
          'end;')
      end>
    OnClickToolButton = <
      item
        ButtonName = 'ImageSalir'
        Source.Strings = (
          'begin'
          '  close;'
          'end.')
      end
      item
        ButtonName = 'ImageBuscar'
        Source.Strings = (
          'begin'
          '  ConsultarMasiva();'
          'end.')
      end>
  end
  inherited ImprimirObjetoSeleccionado: TdxComponentPrinter
    Top = 160
    inherited ImprimirObjetoSeleccionadodxComponentPrinterLink: TdxGridReportLink
      BuiltInReportLink = True
    end
  end
  object Varios: TsnVarios
    Operacion = Operacion
    Left = 184
    Top = 67
  end
  object TTipoEmpleado: TsnTable
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
    Left = 160
    Top = 150
    object TTipoEmpleadocodigo: TStringField
      FieldName = 'codigo'
      Size = 50
    end
    object TTipoEmpleadodescripcion: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
  end
  object DSTipoEmpleado: TDataSource
    DataSet = TTipoEmpleado
    Left = 192
    Top = 150
  end
  object TTipoDocumento: TsnTable
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
    Top = 30
    object TTipoDocumentooid: TIntegerField
      FieldName = 'oid'
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
  object DSTipoDocumento: TDataSource
    DataSet = TTipoDocumento
    Left = 184
    Top = 30
  end
  object TNacionalidad: TsnTable
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
    Left = 24
    Top = 334
    object IntegerField1: TIntegerField
      FieldName = 'oid'
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
  object DSNacionalidad: TDataSource
    DataSet = TNacionalidad
    Left = 56
    Top = 334
  end
  object TSexo: TsnTable
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
    Left = 104
    Top = 375
    object StringField5: TStringField
      FieldName = 'codigo'
      Size = 50
    end
    object StringField6: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
  end
  object DSSexo: TDataSource
    DataSet = TSexo
    Left = 136
    Top = 375
  end
  object TMonedas: TsnTable
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
    Left = 24
    Top = 364
    object TMonedasoid: TIntegerField
      FieldName = 'oid'
    end
    object StringField31: TStringField
      FieldName = 'codigo'
      Size = 50
    end
    object StringField32: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
  end
  object DSMonedas: TDataSource
    DataSet = TMonedas
    Left = 56
    Top = 364
  end
  object TMotivoNovedad: TsnTable
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
    Left = 141
    Top = 577
    object IntegerField11: TIntegerField
      FieldName = 'oid'
    end
    object StringField33: TStringField
      FieldName = 'codigo'
      Size = 50
    end
    object StringField34: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
  end
  object DSMotivoNovedad: TDataSource
    DataSet = TMotivoNovedad
    Left = 173
    Top = 577
  end
  object TSector: TsnTable
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
    Left = 200
    Top = 573
    object IntegerField9: TIntegerField
      FieldName = 'oid'
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
  object DSSector: TDataSource
    DataSet = TSector
    Left = 232
    Top = 573
  end
  object dsCargo: TDataSource
    DataSet = TCargo
    Left = 872
    Top = 370
  end
  object TCargo: TsnTable
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
    Top = 370
    object IntegerField10: TIntegerField
      FieldName = 'oid'
    end
    object StringField25: TStringField
      FieldName = 'codigo'
      Size = 50
    end
    object StringField26: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
  end
  object DSSupervisor: TDataSource
    DataSet = TSupervisor
    Left = 813
    Top = 371
  end
  object TSupervisor: TsnTable
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
    Left = 781
    Top = 371
    object IntegerField12: TIntegerField
      FieldName = 'oid'
    end
    object StringField35: TStringField
      FieldName = 'codigo'
      Size = 50
    end
    object StringField36: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
  end
  object TTurno: TsnTable
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
    Left = 781
    Top = 403
    object IntegerField13: TIntegerField
      FieldName = 'oid'
    end
    object StringField37: TStringField
      FieldName = 'codigo'
      Size = 50
    end
    object StringField38: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
  end
  object DSTurno: TDataSource
    DataSet = TTurno
    Left = 813
    Top = 403
  end
  object TCondicion: TsnTable
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
    Top = 406
    object StringField27: TStringField
      FieldName = 'codigo'
      Size = 50
    end
    object StringField28: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
  end
  object DSCondicion: TDataSource
    DataSet = TCondicion
    Left = 872
    Top = 406
  end
  object DSMotivosDifPago: TDataSource
    DataSet = TMotivosDifPago
    Left = 160
    Top = 529
  end
  object TMotivosDifPago: TsnTable
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
    Left = 128
    Top = 529
    object TMotivosDifPagooid: TIntegerField
      FieldName = 'oid'
    end
    object StringField29: TStringField
      FieldName = 'codigo'
      Size = 50
    end
    object StringField30: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
  end
  object DSTSeRetira: TDataSource
    DataSet = TSeRetira
    Left = 101
    Top = 529
  end
  object TSeRetira: TsnTable
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
    Left = 69
    Top = 529
    object IntegerField14: TIntegerField
      FieldName = 'oid'
    end
    object StringField39: TStringField
      FieldName = 'codigo'
      Size = 50
    end
    object StringField40: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
  end
  object TAltura: TsnTable
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
    Left = 496
    Top = 64
    object IntegerField2: TIntegerField
      FieldName = 'oid'
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
  object DSAltura: TDataSource
    DataSet = TAltura
    Left = 528
    Top = 64
  end
  object TComplexion: TsnTable
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
    Left = 496
    Top = 95
    object IntegerField3: TIntegerField
      FieldName = 'oid'
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
  object DSComplexion: TDataSource
    DataSet = TComplexion
    Left = 528
    Top = 95
  end
  object TEdad: TsnTable
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
    Left = 496
    Top = 125
    object IntegerField4: TIntegerField
      FieldName = 'oid'
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
  object dsEdad: TDataSource
    DataSet = TEdad
    Left = 528
    Top = 125
  end
  object TColor: TsnTable
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
    Left = 496
    Top = 156
    object IntegerField5: TIntegerField
      FieldName = 'oid'
    end
    object StringField15: TStringField
      FieldName = 'codigo'
      Size = 50
    end
    object StringField16: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
  end
  object DSColor: TDataSource
    DataSet = TColor
    Left = 528
    Top = 156
  end
  object DSTipoBarba: TDataSource
    DataSet = TTipoBarba
    Left = 528
    Top = 187
  end
  object TTipoBarba: TsnTable
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
    Left = 496
    Top = 187
    object IntegerField6: TIntegerField
      FieldName = 'oid'
    end
    object StringField17: TStringField
      FieldName = 'codigo'
      Size = 50
    end
    object StringField18: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
  end
  object TIndividuoExcluido: TsnTable
    DesignActivation = True
    AttachedAutoRefresh = True
    AttachMaxCount = 1
    FieldDefs = <
      item
        Name = 'oid_individuo'
        DataType = ftInteger
      end
      item
        Name = 'tipo'
        DataType = ftString
        Size = 20
      end
      item
        Name = 'apellido'
        DataType = ftString
        Size = 50
      end
      item
        Name = 'nombre'
        DataType = ftString
        Size = 50
      end
      item
        Name = 'oid_tipo_documento'
        DataType = ftInteger
      end
      item
        Name = 'nro_documento'
        DataType = ftString
        Size = 50
      end
      item
        Name = 'apodo'
        DataType = ftString
        Size = 50
      end
      item
        Name = 'oid_nacionalidad'
        DataType = ftInteger
      end
      item
        Name = 'legajo'
        DataType = ftString
        Size = 50
      end
      item
        Name = 'oid_sector'
        DataType = ftInteger
      end
      item
        Name = 'oid_cargo'
        DataType = ftInteger
      end
      item
        Name = 'tipo_condicion'
        DataType = ftString
        Size = 20
      end
      item
        Name = 'sexo'
        DataType = ftString
        Size = 1
      end
      item
        Name = 'oid_raza'
        DataType = ftInteger
      end
      item
        Name = 'oid_altura'
        DataType = ftInteger
      end
      item
        Name = 'oid_complexion'
        DataType = ftInteger
      end
      item
        Name = 'oid_edad'
        DataType = ftInteger
      end
      item
        Name = 'oid_color'
        DataType = ftInteger
      end
      item
        Name = 'oid_tipo_barba'
        DataType = ftInteger
      end
      item
        Name = 'oid_tipo_cabello'
        DataType = ftInteger
      end
      item
        Name = 'oid_tipo_nariz'
        DataType = ftInteger
      end
      item
        Name = 'activo'
        DataType = ftBoolean
      end
      item
        Name = 'anteojos'
        DataType = ftInteger
      end
      item
        Name = 'marcas'
        DataType = ftString
        Size = 50
      end
      item
        Name = 'rasgos'
        DataType = ftString
        Size = 50
      end
      item
        Name = 'oid_estado'
        DataType = ftInteger
      end
      item
        Name = 'oid_estado_ant'
        DataType = ftInteger
      end
      item
        Name = 'fec_estado'
        DataType = ftDate
      end
      item
        Name = 'fec_estado_ant'
        DataType = ftDate
      end
      item
        Name = 'oid_legajo'
        DataType = ftInteger
      end
      item
        Name = 'comen_foto_2'
        DataType = ftString
        Size = 50
      end
      item
        Name = 'comen_foto_3'
        DataType = ftString
        Size = 50
      end
      item
        Name = 'fecha_date_foto_2'
        DataType = ftDate
      end
      item
        Name = 'fecha_date_foto_3'
        DataType = ftDate
      end
      item
        Name = 'oid_rel_1'
        DataType = ftInteger
      end
      item
        Name = 'oid_rel_2'
        DataType = ftInteger
      end
      item
        Name = 'oid_rel_3'
        DataType = ftInteger
      end
      item
        Name = 'oid_rel_4'
        DataType = ftInteger
      end
      item
        Name = 'oid_rel_5'
        DataType = ftInteger
      end
      item
        Name = 'oid_rel_6'
        DataType = ftInteger
      end
      item
        Name = 'oid_rel_7'
        DataType = ftInteger
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
    Left = 296
    Top = 115
    object TIndividuoExcluidooid_individuo: TIntegerField
      FieldName = 'oid_individuo'
    end
    object TIndividuoExcluidotipo: TStringField
      FieldName = 'tipo'
    end
    object TIndividuoExcluidoapellido: TStringField
      FieldName = 'apellido'
      Size = 50
    end
    object TIndividuoExcluidonombre: TStringField
      FieldName = 'nombre'
      Size = 50
    end
    object TIndividuoExcluidooid_tipo_documento: TIntegerField
      FieldName = 'oid_tipo_documento'
    end
    object TIndividuoExcluidonro_documento: TStringField
      FieldName = 'nro_documento'
      Size = 50
    end
    object TIndividuoExcluidoapodo: TStringField
      FieldName = 'apodo'
      Size = 50
    end
    object TIndividuoExcluidooid_nacionalidad: TIntegerField
      FieldName = 'oid_nacionalidad'
    end
    object TIndividuoExcluidolegajo: TStringField
      FieldName = 'legajo'
      Size = 50
    end
    object TIndividuoExcluidooid_sector: TIntegerField
      FieldName = 'oid_sector'
    end
    object TIndividuoExcluidooid_cargo: TIntegerField
      FieldName = 'oid_cargo'
    end
    object TIndividuoExcluidotipo_condicion: TStringField
      FieldName = 'tipo_condicion'
    end
    object TIndividuoExcluidosexo: TStringField
      FieldName = 'sexo'
      Size = 1
    end
    object TIndividuoExcluidooid_raza: TIntegerField
      FieldName = 'oid_raza'
    end
    object TIndividuoExcluidooid_altura: TIntegerField
      FieldName = 'oid_altura'
    end
    object TIndividuoExcluidooid_complexion: TIntegerField
      FieldName = 'oid_complexion'
    end
    object TIndividuoExcluidooid_edad: TIntegerField
      FieldName = 'oid_edad'
    end
    object TIndividuoExcluidooid_color: TIntegerField
      FieldName = 'oid_color'
    end
    object TIndividuoExcluidooid_tipo_barba: TIntegerField
      FieldName = 'oid_tipo_barba'
    end
    object TIndividuoExcluidooid_tipo_cabello: TIntegerField
      FieldName = 'oid_tipo_cabello'
    end
    object TIndividuoExcluidooid_tipo_nariz: TIntegerField
      FieldName = 'oid_tipo_nariz'
    end
    object TIndividuoExcluidoactivo: TBooleanField
      DefaultExpression = '1'
      FieldName = 'activo'
    end
    object TIndividuoExcluidoanteojos: TIntegerField
      FieldName = 'anteojos'
    end
    object TIndividuoExcluidomarcas: TStringField
      FieldName = 'marcas'
      Size = 50
    end
    object TIndividuoExcluidorasgos: TStringField
      FieldName = 'rasgos'
      Size = 50
    end
    object TIndividuoExcluidooid_estado: TIntegerField
      FieldName = 'oid_estado'
    end
    object TIndividuoExcluidooid_estado_ant: TIntegerField
      FieldName = 'oid_estado_ant'
    end
    object TIndividuoExcluidofec_estado: TDateField
      FieldName = 'fec_estado'
    end
    object TIndividuoExcluidofec_estado_ant: TDateField
      FieldName = 'fec_estado_ant'
    end
    object TIndividuoExcluidooid_legajo: TIntegerField
      FieldName = 'oid_legajo'
    end
    object TIndividuoExcluidocomen_foto_2: TStringField
      FieldName = 'comen_foto_2'
      Size = 50
    end
    object TIndividuoExcluidocomen_foto_3: TStringField
      FieldName = 'comen_foto_3'
      Size = 50
    end
    object TIndividuoExcluidofecha_date_foto_2: TDateField
      FieldName = 'fecha_date_foto_2'
    end
    object TIndividuoExcluidofecha_date_foto_3: TDateField
      FieldName = 'fecha_date_foto_3'
    end
    object TIndividuoExcluidooid_rel_1: TIntegerField
      FieldName = 'oid_rel_1'
    end
    object TIndividuoExcluidooid_rel_2: TIntegerField
      FieldName = 'oid_rel_2'
    end
    object TIndividuoExcluidooid_rel_3: TIntegerField
      FieldName = 'oid_rel_3'
    end
    object TIndividuoExcluidooid_rel_4: TIntegerField
      FieldName = 'oid_rel_4'
    end
    object TIndividuoExcluidooid_rel_5: TIntegerField
      FieldName = 'oid_rel_5'
    end
    object TIndividuoExcluidooid_rel_6: TIntegerField
      FieldName = 'oid_rel_6'
    end
    object TIndividuoExcluidooid_rel_7: TIntegerField
      FieldName = 'oid_rel_7'
    end
    object TIndividuoExcluidooid_rel_8: TIntegerField
      FieldName = 'oid_rel_8'
    end
    object TIndividuoExcluidoobs_rel_1: TStringField
      FieldName = 'obs_rel_1'
      Size = 255
    end
    object TIndividuoExcluidoobs_rel_2: TStringField
      FieldName = 'obs_rel_2'
      Size = 255
    end
    object TIndividuoExcluidoobs_rel_3: TStringField
      FieldName = 'obs_rel_3'
      Size = 255
    end
    object TIndividuoExcluidoobs_rel_4: TStringField
      FieldName = 'obs_rel_4'
      Size = 255
    end
    object TIndividuoExcluidoobs_rel_5: TStringField
      FieldName = 'obs_rel_5'
      Size = 255
    end
    object TIndividuoExcluidoobs_rel_6: TStringField
      FieldName = 'obs_rel_6'
      Size = 255
    end
    object TIndividuoExcluidoobs_rel_7: TStringField
      FieldName = 'obs_rel_7'
      Size = 255
    end
    object TIndividuoExcluidoobs_rel_8: TStringField
      FieldName = 'obs_rel_8'
      Size = 255
    end
    object TIndividuoExcluidooid_rel_ind_1: TIntegerField
      FieldName = 'oid_rel_ind_1'
    end
    object TIndividuoExcluidooid_rel_ind_2: TIntegerField
      FieldName = 'oid_rel_ind_2'
    end
    object TIndividuoExcluidooid_rel_ind_3: TIntegerField
      FieldName = 'oid_rel_ind_3'
    end
    object TIndividuoExcluidooid_rel_ind_4: TIntegerField
      FieldName = 'oid_rel_ind_4'
    end
    object TIndividuoExcluidooid_rel_ind_5: TIntegerField
      FieldName = 'oid_rel_ind_5'
    end
    object TIndividuoExcluidooid_rel_ind_6: TIntegerField
      FieldName = 'oid_rel_ind_6'
    end
    object TIndividuoExcluidooid_rel_ind_7: TIntegerField
      FieldName = 'oid_rel_ind_7'
    end
    object TIndividuoExcluidooid_rel_ind_8: TIntegerField
      FieldName = 'oid_rel_ind_8'
    end
    object TIndividuoExcluidonro_rel_ind_1: TIntegerField
      FieldName = 'nro_rel_ind_1'
    end
    object TIndividuoExcluidonro_rel_ind_2: TIntegerField
      FieldName = 'nro_rel_ind_2'
    end
    object TIndividuoExcluidonro_rel_ind_3: TIntegerField
      FieldName = 'nro_rel_ind_3'
    end
    object TIndividuoExcluidonro_rel_ind_4: TIntegerField
      FieldName = 'nro_rel_ind_4'
    end
    object TIndividuoExcluidonro_rel_ind_5: TIntegerField
      FieldName = 'nro_rel_ind_5'
    end
    object TIndividuoExcluidonro_rel_ind_6: TIntegerField
      FieldName = 'nro_rel_ind_6'
    end
    object TIndividuoExcluidonro_rel_ind_7: TIntegerField
      FieldName = 'nro_rel_ind_7'
    end
    object TIndividuoExcluidonro_rel_ind_8: TIntegerField
      FieldName = 'nro_rel_ind_8'
    end
    object TIndividuoExcluidoape_y_nom_rel_1: TStringField
      FieldName = 'ape_y_nom_rel_1'
      Size = 100
    end
    object TIndividuoExcluidoape_y_nom_rel_2: TStringField
      FieldName = 'ape_y_nom_rel_2'
      Size = 100
    end
    object TIndividuoExcluidoape_y_nom_rel_3: TStringField
      FieldName = 'ape_y_nom_rel_3'
      Size = 100
    end
    object TIndividuoExcluidoape_y_nom_rel_4: TStringField
      FieldName = 'ape_y_nom_rel_4'
      Size = 100
    end
    object TIndividuoExcluidoape_y_nom_rel_5: TStringField
      FieldName = 'ape_y_nom_rel_5'
      Size = 100
    end
    object TIndividuoExcluidoape_y_nom_rel_6: TStringField
      FieldName = 'ape_y_nom_rel_6'
      Size = 100
    end
    object TIndividuoExcluidoape_y_nom_rel_7: TStringField
      FieldName = 'ape_y_nom_rel_7'
      Size = 100
    end
    object TIndividuoExcluidoape_y_nom_rel_8: TStringField
      FieldName = 'ape_y_nom_rel_8'
      Size = 100
    end
    object TIndividuoExcluidoestado_rel_1: TStringField
      FieldName = 'estado_rel_1'
      Size = 50
    end
    object TIndividuoExcluidoestado_rel_2: TStringField
      FieldName = 'estado_rel_2'
      Size = 50
    end
    object TIndividuoExcluidoestado_rel_3: TStringField
      FieldName = 'estado_rel_3'
      Size = 50
    end
    object TIndividuoExcluidoestado_rel_4: TStringField
      FieldName = 'estado_rel_4'
      Size = 50
    end
    object TIndividuoExcluidoestado_rel_5: TStringField
      FieldName = 'estado_rel_5'
      Size = 50
    end
    object TIndividuoExcluidoestado_rel_6: TStringField
      FieldName = 'estado_rel_6'
      Size = 50
    end
    object TIndividuoExcluidoestado_rel_7: TStringField
      FieldName = 'estado_rel_7'
      Size = 50
    end
    object TIndividuoExcluidoestado_rel_8: TStringField
      FieldName = 'estado_rel_8'
      Size = 50
    end
    object TIndividuoExcluidooid_ind_rel_1: TIntegerField
      FieldName = 'oid_ind_rel_1'
    end
    object TIndividuoExcluidooid_ind_rel_2: TIntegerField
      FieldName = 'oid_ind_rel_2'
    end
    object TIndividuoExcluidooid_ind_rel_3: TIntegerField
      FieldName = 'oid_ind_rel_3'
    end
    object TIndividuoExcluidooid_ind_rel_4: TIntegerField
      FieldName = 'oid_ind_rel_4'
    end
    object TIndividuoExcluidooid_ind_rel_5: TIntegerField
      FieldName = 'oid_ind_rel_5'
    end
    object TIndividuoExcluidooid_ind_rel_6: TIntegerField
      FieldName = 'oid_ind_rel_6'
    end
    object TIndividuoExcluidooid_ind_rel_7: TIntegerField
      FieldName = 'oid_ind_rel_7'
    end
    object TIndividuoExcluidooid_ind_rel_8: TIntegerField
      FieldName = 'oid_ind_rel_8'
    end
    object TIndividuoExcluidodominio: TStringField
      FieldName = 'dominio'
      Size = 50
    end
    object TIndividuoExcluidomodelo: TStringField
      FieldName = 'modelo'
      Size = 50
    end
    object TIndividuoExcluidooid_color_vehiculo: TIntegerField
      FieldName = 'oid_color_vehiculo'
    end
    object TIndividuoExcluidonro_acta: TIntegerField
      FieldName = 'nro_acta'
    end
    object TIndividuoExcluidonro_acta_revo: TIntegerField
      FieldName = 'nro_acta_revo'
    end
    object TIndividuoExcluidooid_ind_relacion: TIntegerField
      FieldName = 'oid_ind_relacion'
    end
    object TIndividuoExcluidonro_ind_relacion: TIntegerField
      FieldName = 'nro_ind_relacion'
    end
    object TIndividuoExcluidoape_y_nom_relacion: TStringField
      FieldName = 'ape_y_nom_relacion'
      Size = 100
    end
    object TIndividuoExcluidocomportamiento_estado: TStringField
      FieldName = 'comportamiento_estado'
      Size = 50
    end
    object TIndividuoExcluidomarca: TStringField
      FieldName = 'marca'
      Size = 100
    end
    object TIndividuoExcluidooid_caracter: TIntegerField
      FieldName = 'oid_caracter'
    end
    object TIndividuoExcluidoobservacion: TStringField
      FieldName = 'observacion'
      Size = 100
    end
    object TIndividuoExcluidofec_alta_desde: TDateField
      FieldName = 'fec_alta_desde'
    end
    object TIndividuoExcluidofec_alta_hasta: TDateField
      FieldName = 'fec_alta_hasta'
    end
    object TIndividuoExcluidosin_vigencia_hasta: TBooleanField
      DefaultExpression = 'false'
      FieldName = 'sin_vigencia_hasta'
    end
    object TIndividuoExcluidooid_marca: TIntegerField
      FieldName = 'oid_marca'
    end
    object TIndividuoExcluidooid_rasgo: TIntegerField
      FieldName = 'oid_rasgo'
    end
    object TIndividuoExcluidoordenar_por: TStringField
      FieldName = 'ordenar_por'
      Size = 10
    end
    object TIndividuoExcluidocon_acta_revocacion: TBooleanField
      FieldName = 'con_acta_revocacion'
    end
  end
  object DSTIndividuoExcluido: TDataSource
    DataSet = TIndividuoExcluido
    Left = 328
    Top = 115
  end
  object TSINO: TsnTable
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
    Top = 374
    object TSINOcodigo: TIntegerField
      FieldName = 'codigo'
    end
    object TSINOdescripcion: TStringField
      FieldName = 'descripcion'
      Size = 2
    end
  end
  object dsSINO: TDataSource
    DataSet = TSINO
    Left = 272
    Top = 374
  end
  object TRaza: TsnTable
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
    Left = 496
    Top = 217
    object TRazaoid: TIntegerField
      FieldName = 'oid'
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
  object DSRaza: TDataSource
    DataSet = TRaza
    Left = 528
    Top = 217
  end
  object TNariz: TsnTable
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
    Left = 496
    Top = 281
    object IntegerField8: TIntegerField
      FieldName = 'oid'
    end
    object StringField21: TStringField
      FieldName = 'codigo'
      Size = 50
    end
    object StringField22: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
  end
  object DSTNariz: TDataSource
    DataSet = TNariz
    Left = 528
    Top = 281
  end
  object TCabello: TsnTable
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
    Left = 712
    Top = 219
    object IntegerField7: TIntegerField
      FieldName = 'oid'
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
  object DSCabello: TDataSource
    DataSet = TCabello
    Left = 744
    Top = 219
  end
  object TMotivosNovedades: TsnTable
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
    Left = 266
    Top = 451
    object TMotivosNovedadesoid: TIntegerField
      FieldName = 'oid'
    end
    object TMotivosNovedadescodigo: TStringField
      FieldName = 'codigo'
      Size = 50
    end
    object TMotivosNovedadesdescripcion: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
    object TMotivosNovedadessel: TBooleanField
      DefaultExpression = 'false'
      FieldName = 'sel'
    end
  end
  object DSMotivosNovedades: TDataSource
    DataSet = TMotivosNovedades
    Left = 298
    Top = 451
  end
  object TColorCabello: TsnTable
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
    Left = 70
    Top = 566
    object IntegerField15: TIntegerField
      FieldName = 'oid'
    end
    object StringField41: TStringField
      FieldName = 'codigo'
      Size = 50
    end
    object StringField42: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
  end
  object DSTColorCabello: TDataSource
    DataSet = TColorCabello
    Left = 102
    Top = 566
  end
  object TEstados: TsnTable
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
    Left = 712
    Top = 249
    object TEstadosoid: TIntegerField
      FieldName = 'oid'
    end
    object TEstadoscodigo: TStringField
      FieldName = 'codigo'
      Size = 50
    end
    object TEstadosdescripcion: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
    object TEstadossel: TBooleanField
      DefaultExpression = 'false'
      FieldName = 'sel'
    end
  end
  object DSEstados: TDataSource
    DataSet = TEstados
    Left = 744
    Top = 249
  end
  object TRelacionIndividuo: TsnTable
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
    Left = 352
    Top = 350
    object TRelacionIndividuooid_individuo: TIntegerField
      FieldName = 'oid_individuo'
    end
    object TRelacionIndividuoape_y_nom: TStringField
      FieldName = 'ape_y_nom'
      Size = 255
    end
    object TRelacionIndividuoestado: TStringField
      FieldName = 'estado'
      Size = 100
    end
  end
  object TComportamientoEstado: TsnTable
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
    Left = 394
    Top = 523
    object TComportamientoEstadocodigo: TStringField
      FieldName = 'codigo'
      Size = 50
    end
    object TComportamientoEstadodescripcion: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
  end
  object DSComportamientoEstado: TDataSource
    DataSet = TComportamientoEstado
    Left = 426
    Top = 523
  end
  object FormularioConsultaMasiva: TFormulario
    Nombre = 'TFConsMasivaIndExc'
    CreateAlwaysANewForm = True
    Left = 96
    Top = 275
  end
  object TCaracter: TsnTable
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
    Left = 24
    Top = 151
    object TCaracteroid: TIntegerField
      FieldName = 'oid'
    end
    object StringField43: TStringField
      FieldName = 'codigo'
      Size = 50
    end
    object StringField44: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
  end
  object DSCaracter: TDataSource
    DataSet = TCaracter
    Left = 56
    Top = 151
  end
  object TSI: TsnTable
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
    Top = 337
    object IntegerField16: TIntegerField
      FieldName = 'codigo'
    end
    object StringField45: TStringField
      FieldName = 'descripcion'
      Size = 2
    end
  end
  object DSSI: TDataSource
    DataSet = TSI
    Left = 272
    Top = 337
  end
  object TMarcas: TsnTable
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
    Left = 573
    Top = 217
    object IntegerField17: TIntegerField
      FieldName = 'oid'
    end
    object StringField46: TStringField
      FieldName = 'codigo'
      Size = 50
    end
    object StringField47: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
  end
  object dsTMarcas: TDataSource
    DataSet = TMarcas
    Left = 605
    Top = 217
  end
  object TRasgos: TsnTable
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
    Left = 573
    Top = 254
    object IntegerField18: TIntegerField
      FieldName = 'oid'
    end
    object StringField48: TStringField
      FieldName = 'codigo'
      Size = 50
    end
    object StringField49: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
  end
  object DSTRasgos: TDataSource
    DataSet = TRasgos
    Left = 605
    Top = 254
  end
  object TOrdenarPor: TsnTable
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
    Left = 602
    Top = 67
    object TOrdenarPorcodigo: TStringField
      FieldName = 'codigo'
      Size = 10
    end
    object TOrdenarPordescripcion: TStringField
      FieldName = 'descripcion'
      Size = 100
    end
  end
  object DSOrdenarPor: TDataSource
    DataSet = TOrdenarPor
    Left = 634
    Top = 67
  end
end
