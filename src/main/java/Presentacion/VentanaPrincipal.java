package Presentacion;

import Logica.EnumEstado;
import Logica.EnumRetorno;
import Logica.IControlador;
import java.io.File;
import java.time.LocalDate;
import java.time.LocalDateTime;
import org.mindrot.jbcrypt.BCrypt;

public class VentanaPrincipal extends javax.swing.JFrame {

    protected final IControlador ic;

    public VentanaPrincipal(IControlador ic) {
        this.ic = ic;
        initComponents();
        try {
            javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private VentanaPrincipal() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        Desktop = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuPerfil = new javax.swing.JMenu();
        menuAltaUsuario = new javax.swing.JMenuItem();
        menuSeguir = new javax.swing.JMenuItem();
        menuDejarSeguir = new javax.swing.JMenuItem();
        subMenuConsultaPerfil = new javax.swing.JMenu();
        menuConsultaProponente = new javax.swing.JMenuItem();
        menuConsultaCola = new javax.swing.JMenuItem();
        menuBajaUsuario = new javax.swing.JMenuItem();
        menuPropuestas = new javax.swing.JMenu();
        menuAltaProp = new javax.swing.JMenuItem();
        menuModificarProp = new javax.swing.JMenuItem();
        menuConsultaPropu = new javax.swing.JMenuItem();
        menuConsultaPropuEst = new javax.swing.JMenuItem();
        menuAltaCategoria = new javax.swing.JMenuItem();
        menuEvaluarPropuesta = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        menuRegistrarCola = new javax.swing.JMenuItem();
        menuConsultarCola = new javax.swing.JMenuItem();
        menuCancelarCola = new javax.swing.JMenuItem();
        menuDatos = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();

        jMenuItem1.setText("jMenuItem1");

        jMenuItem3.setText("jMenuItem3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Culturarte");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);

        javax.swing.GroupLayout DesktopLayout = new javax.swing.GroupLayout(Desktop);
        Desktop.setLayout(DesktopLayout);
        DesktopLayout.setHorizontalGroup(
            DesktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 800, Short.MAX_VALUE)
        );
        DesktopLayout.setVerticalGroup(
            DesktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 598, Short.MAX_VALUE)
        );

        menuPerfil.setText("Perfil");

        menuAltaUsuario.setText("Alta de Usuario");
        menuAltaUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuAltaUsuarioActionPerformed(evt);
            }
        });
        menuPerfil.add(menuAltaUsuario);

        menuSeguir.setText("Seguir Usuario");
        menuSeguir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuSeguirActionPerformed(evt);
            }
        });
        menuPerfil.add(menuSeguir);

        menuDejarSeguir.setText("Dejar de seguir Usuario");
        menuDejarSeguir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuDejarSeguirActionPerformed(evt);
            }
        });
        menuPerfil.add(menuDejarSeguir);

        subMenuConsultaPerfil.setText("Consulta Perfil");

        menuConsultaProponente.setText("Consulta perfil proponente");
        menuConsultaProponente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuConsultaProponenteActionPerformed(evt);
            }
        });
        subMenuConsultaPerfil.add(menuConsultaProponente);

        menuConsultaCola.setText("Consulta perfil colaborador");
        menuConsultaCola.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuConsultaColaActionPerformed(evt);
            }
        });
        subMenuConsultaPerfil.add(menuConsultaCola);

        menuPerfil.add(subMenuConsultaPerfil);

        menuBajaUsuario.setText("Baja de Usuario");
        menuBajaUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuBajaUsuarioActionPerformed(evt);
            }
        });
        menuPerfil.add(menuBajaUsuario);

        jMenuBar1.add(menuPerfil);

        menuPropuestas.setText("Propuestas");

        menuAltaProp.setText("Alta de Propuestas");
        menuAltaProp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuAltaPropActionPerformed(evt);
            }
        });
        menuPropuestas.add(menuAltaProp);

        menuModificarProp.setText("Modificar Datos Propuesta");
        menuModificarProp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuModificarPropActionPerformed(evt);
            }
        });
        menuPropuestas.add(menuModificarProp);

        menuConsultaPropu.setText("Consulta de Propuesta");
        menuConsultaPropu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuConsultaPropuActionPerformed(evt);
            }
        });
        menuPropuestas.add(menuConsultaPropu);

        menuConsultaPropuEst.setText("Consulta de Propuesta x Estado");
        menuConsultaPropuEst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuConsultaPropuEstActionPerformed(evt);
            }
        });
        menuPropuestas.add(menuConsultaPropuEst);

        menuAltaCategoria.setText("Alta Categoria");
        menuAltaCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuAltaCategoriaActionPerformed(evt);
            }
        });
        menuPropuestas.add(menuAltaCategoria);

        menuEvaluarPropuesta.setText("Evaluar Propuesta");
        menuEvaluarPropuesta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuEvaluarPropuestaActionPerformed(evt);
            }
        });
        menuPropuestas.add(menuEvaluarPropuesta);

        jMenuBar1.add(menuPropuestas);

        jMenu1.setText("Colaboracion");

        menuRegistrarCola.setText("Registrar Colaboracion");
        menuRegistrarCola.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuRegistrarColaActionPerformed(evt);
            }
        });
        jMenu1.add(menuRegistrarCola);

        menuConsultarCola.setText("Consulta de Colaboracion");
        menuConsultarCola.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuConsultarColaActionPerformed(evt);
            }
        });
        jMenu1.add(menuConsultarCola);

        menuCancelarCola.setText("Cancelar Colaboracion");
        menuCancelarCola.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCancelarColaActionPerformed(evt);
            }
        });
        jMenu1.add(menuCancelarCola);

        jMenuBar1.add(jMenu1);

        menuDatos.setText("Datos");

        jMenuItem2.setText("Cargar datos");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        menuDatos.add(jMenuItem2);

        jMenuBar1.add(menuDatos);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 800, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(Desktop))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 598, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(Desktop))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuConsultaProponenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuConsultaProponenteActionPerformed
        if (this.ICPP == null || ICPP.isClosed()) {
            ICPP = new InterConsultaPerfilProponente(this.ic);
            this.Desktop.add(ICPP);
            ICPP.show();

        }
    }//GEN-LAST:event_menuConsultaProponenteActionPerformed

    private void menuAltaUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuAltaUsuarioActionPerformed
        // TODO add your handling code here:
        if (this.IAU == null || IAU.isClosed()) {
            IAU = new InterAltaUsuario(this.ic);
            this.Desktop.add(IAU);
            IAU.show();
            int x = (this.getWidth() - IAU.getWidth()) / 2;
            int y = (this.getHeight() - IAU.getHeight()) / 2;
            IAU.setLocation(x, y - 50);
        }
    }//GEN-LAST:event_menuAltaUsuarioActionPerformed

    private void menuConsultaPropuEstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuConsultaPropuEstActionPerformed
        // TODO add your handling code here:
        if (this.ICE == null) {
            ICE = new InterConsultaXEstado(ic);
            this.Desktop.add(ICE);
            ICE.show();
        } else if (!this.ICE.abierto()) {
            ICE = new InterConsultaXEstado(ic);
            this.Desktop.add(ICE);
            ICE.show();
        }
    }//GEN-LAST:event_menuConsultaPropuEstActionPerformed

    private void menuRegistrarColaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuRegistrarColaActionPerformed

        if ((this.IRC == null || this.IRC.isClosed()) && !ic.getColaboradores().isEmpty() && !ic.getPropuestas_Proponentes().isEmpty()) {
            IRC = new InterRegistrarCola(ic);
            this.Desktop.add(IRC);
            IRC.setLocation(30, 50);
            IRC.setVisible(true);
        } else {
            javax.swing.JOptionPane.showMessageDialog(this, "Se requieren Colaboradores y Propuestas ingresadas para acceder", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_menuRegistrarColaActionPerformed

    private void menuConsultarColaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuConsultarColaActionPerformed
        if ((this.ICC == null || this.ICC.isClosed()) && !ic.getColaboradores().isEmpty() && !ic.getPropuestas_Proponentes().isEmpty()) {
            ICC = new InterConsultaCola(ic);
            this.Desktop.add(ICC);
            ICC.setLocation(50, 50);
            ICC.show();
        } else {
            javax.swing.JOptionPane.showMessageDialog(this, "Se requieren Colaboradores y Propuestas para acceder", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_menuConsultarColaActionPerformed
    private void menuAltaCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuAltaCategoriaActionPerformed
        // TODO add your handling code here:
        if (this.IAC == null || IAC.isClosed()) {
            IAC = new InterAltaCategoria(this.ic);
            this.Desktop.add(IAC);
            IAC.show();
        }

    }//GEN-LAST:event_menuAltaCategoriaActionPerformed
    private void menuAltaPropActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuAltaPropActionPerformed
        // TODO add your handling code here:
        if (this.IAP == null || this.IAP.isClosed()) {
            IAP = new InterAltaPropuesta(ic);
            this.Desktop.add(IAP);
            IAP.show();

        }
    }//GEN-LAST:event_menuAltaPropActionPerformed

    private void menuSeguirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuSeguirActionPerformed
        // TODO add your handling code here:
        if (this.ISU == null || ISU.isClosed()) {
            ISU = new InterSeguirUsuario(this.ic);
            this.Desktop.add(ISU);
            ISU.show();
            int x = (this.getWidth() - ISU.getWidth()) / 2;
            int y = (this.getHeight() - ISU.getHeight()) / 2;
            ISU.setLocation(x, y - 50);
        }
    }//GEN-LAST:event_menuSeguirActionPerformed
    private void menuConsultaPropuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuConsultaPropuActionPerformed
        // TODO add your handling code here:
        if (this.ICP == null) {
            ICP = new InterConsultaPropuesta(ic);
            this.Desktop.add(ICP);
            ICP.show();
        } else if (!this.ICP.abierto()) {
            ICP = new InterConsultaPropuesta(ic);
            this.Desktop.add(ICP);
            ICP.show();
        }
    }//GEN-LAST:event_menuConsultaPropuActionPerformed

    private void menuDejarSeguirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuDejarSeguirActionPerformed
        // TODO add your handling code here:
        if (this.IDS == null || IDS.isClosed()) {
            IDS = new InterDejarSeguir(this.ic);
            this.Desktop.add(IDS);
            IDS.show();
            int x = (this.getWidth() - IDS.getWidth()) / 2;
            int y = (this.getHeight() - IDS.getHeight()) / 2;
            IDS.setLocation(x, y - 75);
        }
    }//GEN-LAST:event_menuDejarSeguirActionPerformed

    private void menuModificarPropActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuModificarPropActionPerformed
        // TODO add your handling code here:
        if (this.IMP == null || IMP.isClosed()) {
            InterModificarPropuesta IMP = new InterModificarPropuesta(this.ic);
            this.Desktop.add(IMP);
            IMP.show();
            //consigue largo y ancho de ventana principal
            int x = (this.getWidth() - IMP.getWidth()) / 2;
            int y = (this.getHeight() - IMP.getHeight()) / 2;
            IMP.setLocation(x, y - 30);
        }
    }//GEN-LAST:event_menuModificarPropActionPerformed

    private void menuCancelarColaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCancelarColaActionPerformed
        if ((this.ICrC == null || this.ICrC.isClosed()) && !ic.getColaboradores().isEmpty() && !ic.getPropuestas_Proponentes().isEmpty()) {
            ICrC = new InterCancelarCola(ic);
            this.Desktop.add(ICrC);
            ICrC.setLocation(30, 50);
            ICrC.setVisible(true);
        } else {
            javax.swing.JOptionPane.showMessageDialog(this, "Se requieren Colaboradores y Propuestas ingresadas para acceder", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_menuCancelarColaActionPerformed
    private void menuConsultaColaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuConsultaColaActionPerformed
        if (this.ICPC == null || ICPC.isClosed()) {
            ICPC = new InterConsultaPerfilColaborador(this.ic);
            this.Desktop.add(ICPC);
            ICPC.show();
        }
    }//GEN-LAST:event_menuConsultaColaActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed

        String rutaEstacion = "C:\\Users\\mafiu\\Documents\\NetBeansProjects\\CulturarteOnline\\CulturarteWeb\\src\\main\\webapp\\fotos" + File.separator;
        String rutaWeb = "fotos" + File.separator;
        
        //PROPONENTES
        ic.añadirUsuario("hrubino", "Horacio", "Rubino", "horacio.rubino@guambia.com.uy", LocalDate.of(1962, 2, 25), rutaEstacion + "HR.jpg", BCrypt.hashpw("1234", BCrypt.gensalt()), "18 de Julio 1234", "Horacio Rubino Torres nace el 25 de febrero de 1962, es conductor, actor y libretista. Debuta en 1982 en carnaval en Los \"Klaper´s\", donde estuvo cuatro años, actuando y libretando. Luego para \"Gaby´s\" (6 años), escribió en categoría revistas y humoristas y desde el comienzo y hasta el presente en su propio conjunto Momosapiens.", "https://twitter.com/horaciorubino", rutaWeb + "HR.jpg");
        ic.añadirUsuario("mbusca", "Martín", "Buscaglia", "Martin.bus@agadu.org.uy", LocalDate.of(1972, 6, 14), rutaEstacion + "MB.jpg", BCrypt.hashpw("1234", BCrypt.gensalt()), "Colonia 4321", "Martín Buscaglia (Montevideo, 1972) es un artista, músico, compositor y productor uruguayo. Tanto con su banda (“Los Bochamakers”) como en su formato “Hombre orquesta”, o solo con su guitarra, ha recorrido el mundo tocando entre otros países en España, Estados Unidos, Inglaterra, Francia, Australia, Brasil, Colombia, Argentina, Chile, Paraguay, México y Uruguay. (Actualmente los Bochamakers son Matías Rada, Martín Ibarburu, Mateo Moreno, Herman Klang) Paralelamente, tiene proyectos a dúo con el español Kiko Veneno, la cubana Yusa, el argentino Lisandro Aristimuño, su compatriota Antolín, y a trío junto a los brasileros Os Mulheres Negras", "http://www.martinbuscaglia.com/", rutaWeb + "MB.jpg");
        ic.añadirUsuario("tabarec", "Tabaré", "Cardozo", "tabare.car@agadu.org.uy", LocalDate.of(1971, 7, 24), rutaEstacion + "TC.jpg", BCrypt.hashpw("1234", BCrypt.gensalt()), "Santiago Rivas 1212", "Tabaré Cardozo (Montevideo, 24 de julio de 1971) es un cantante, compositor y murguista uruguayo; conocido por su participación en la murga Agarrate Catalina, conjunto que fundó junto a su hermano Yamandú y Carlos Tanco en el año 2001.", "https://www.facebook.com/Tabar%C3%A9-Cardozo-55179094281/?ref=br_rs", rutaWeb + "TC.jpg");
        ic.añadirUsuario("cachilas", "Waldemar \"Cachila\"", "Silva", "Cachila.sil@c1080.org.uy", LocalDate.of(1947, 1, 1), rutaEstacion + "CS.jpg", BCrypt.hashpw("1234", BCrypt.gensalt()), "Br. Artigas 4567", "Nace en el año 1947 en el conventillo \"Medio Mundo\" ubicado en pleno Barrio Sur. Es heredero parcialmentejunto al resto de sus hermanos- de la Comparsa \"Morenada\" (inactiva desde el fallecimiento de Juan Ángel Silva), en 1999 forma su propia Comparsa de negros y lubolos \"Cuareim 1080\". Director responsable, compositor y cantante de la misma.", "https://www.facebook.com/C1080?ref=br_rs", rutaWeb + "CS.jpg");
        ic.añadirUsuario("hectorg", "Héctor", "Guido", "hector.gui@elgalpon.org.uy", LocalDate.of(1954, 1, 7), rutaEstacion + "HG.jpg", BCrypt.hashpw("1234", BCrypt.gensalt()), "Gral. Flores 5645", "En 1972 ingresó a la Escuela de Arte Dramático del teatro El Galpón. Participó en más de treinta obras teatrales y varios largometrajes. Integró el elenco estable de Radioteatro del Sodre, y en 2006 fue asesor de su Consejo Directivo. Como actor recibió múltiples reconocimientos: cuatro premios Florencio, premio al mejor actor extranjero del Festival de Miami y premio Mejor Actor de Cine 2008. Durante varios períodos fue directivo del teatro El Galpón y dirigente de la Sociedad Uruguaya de Actores (SUA); integró también la Federación Uruguaya de Teatros Independientes (FUTI). Formó parte del equipo de gestión de la refacción de los teatros La Máscara, Astral y El Galpón, y del equipo de gestión en la construcción del teatro De la Candela y de la sala Atahualpa de El Galpón", "", rutaWeb + "HG.jpg");
        ic.añadirUsuario("juliob", "Julio", "Bocca", "juliobocca@sodre.com.uy", LocalDate.of(1967, 3, 16), "", BCrypt.hashpw("1234", BCrypt.gensalt()), "Benito Blanco 4321", "", "", "");
        ic.añadirUsuario("diegop", "Diego", "Parodi", "diego@efectocine.com", LocalDate.of(1975, 1, 1), "", BCrypt.hashpw("1234", BCrypt.gensalt()), "Emilio Frugoni 1138 Ap. 02", "", "http://www.efectocine.com", "");
        ic.añadirUsuario("kairoh", "Kairo", "Herrera", "kairoher@pilsenrock.com.uy", LocalDate.of(1970, 4, 25), rutaEstacion + "KH.jpg", BCrypt.hashpw("1234", BCrypt.gensalt()), "Paraguay 1423", "", "", rutaWeb + "KH.jpg");
        ic.añadirUsuario("losBardo", "Los", "Bardo", "losbardo@bardocientifico.com", LocalDate.of(1980, 10, 31), rutaEstacion + "LB.jpg", BCrypt.hashpw("1234", BCrypt.gensalt()), "8 de Octubre 1429", "Queremos ser vistos y reconocidos como una organización: referente en divulgación científica con un fuerte espíritu didáctico y divertido, a través de acciones coordinadas con otros divulgadores científicos, que permitan establecer puentes de comunicación. Impulsora en la generación de espacios de democratización y apropiación social del conocimiento científico.", "https://bardocientifico.com/", rutaWeb + "LB.jpg");

        //COLABORADORES
        ic.añadirUsuario("robinh", "Robin", "Henderson", "Robin.h@tinglesa.com.uy", LocalDate.of(1940, 8, 3), "", BCrypt.hashpw("1234", BCrypt.gensalt()), "");
        ic.añadirUsuario("marcelot", "Marcelo", "Tinelli", "marcelot@ideasdelsur.com.ar", LocalDate.of(1960, 4, 1), rutaEstacion + "MT.jpg", BCrypt.hashpw("1234", BCrypt.gensalt()), rutaWeb + "MT.jpg");
        ic.añadirUsuario("novick", "Edgardo", "Novick", "edgardo@novick.com.uy", LocalDate.of(1952, 7, 17), rutaEstacion + "EN.jpg", BCrypt.hashpw("1234", BCrypt.gensalt()), rutaWeb + "EN.jpg");
        ic.añadirUsuario("sergiop", "Sergio", "Puglia", "puglia@alpanpan.com.uy", LocalDate.of(1950, 1, 28), rutaEstacion + "SP.jpg", BCrypt.hashpw("1234", BCrypt.gensalt()), rutaWeb + "SP.jpg");
        ic.añadirUsuario("chino", "Alvaro", "Recoba", "chino@trico.org.uy", LocalDate.of(1976, 3, 17), rutaEstacion + "AR.jpg", BCrypt.hashpw("1234", BCrypt.gensalt()), rutaWeb + "AR.jpg");
        ic.añadirUsuario("tonyp", "Antonio", "Pacheco", "eltony@manya.org.uy", LocalDate.of(1955, 2, 14), "", BCrypt.hashpw("1234", BCrypt.gensalt()), "");
        ic.añadirUsuario("nicoJ", "Nicolás", "Jodal", "jodal@artech.com.uy", LocalDate.of(1960, 8, 9), rutaEstacion + "NJ.jpg", BCrypt.hashpw("1234", BCrypt.gensalt()), rutaWeb + "NJ.jpg");
        ic.añadirUsuario("juanP", "Juan", "Perez", "juanp@elpueblo.com", LocalDate.of(1970, 1, 1), "", BCrypt.hashpw("1234", BCrypt.gensalt()), "");
        ic.añadirUsuario("Mengano", "Mengano", "Gómez", "menganog@elpueblo.com", LocalDate.of(1982, 2, 2), "", BCrypt.hashpw("1234", BCrypt.gensalt()), "");
        ic.añadirUsuario("Perengano", "Perengano", "López", "pere@elpueblo.com", LocalDate.of(1985, 3, 3), "", BCrypt.hashpw("1234", BCrypt.gensalt()), "");
        ic.añadirUsuario("Tiajaci", "Tía", "Jacinta", "jacinta@elpueblo.com", LocalDate.of(1990, 4, 4), "", BCrypt.hashpw("1234", BCrypt.gensalt()), "");

        //HR
        ic.seguirUsuario("hrubino", "hectorg");
        ic.seguirUsuario("hrubino", "diegop");
        ic.seguirUsuario("hrubino", "losBardo");
        //MB
        ic.seguirUsuario("mbusca", "tabarec");
        ic.seguirUsuario("mbusca", "cachilas");
        ic.seguirUsuario("mbusca", "kairoh");
        //HG
        ic.seguirUsuario("hectorg", "mbusca");
        ic.seguirUsuario("hectorg", "juliob");
        //TC
        ic.seguirUsuario("tabarec", "hrubino");
        ic.seguirUsuario("tabarec", "cachilas");
        //CS
        ic.seguirUsuario("cachilas", "hrubino");
        //JB
        ic.seguirUsuario("juliob", "mbusca");
        ic.seguirUsuario("juliob", "diegop");
        //DP
        ic.seguirUsuario("diegop", "hectorg");
        ic.seguirUsuario("diegop", "losBardo");
        //KH
        ic.seguirUsuario("kairoh", "sergiop");
        //LB
        ic.seguirUsuario("losBardo", "hrubino");
        ic.seguirUsuario("losBardo", "nicoJ");
        //RH
        ic.seguirUsuario("robinh", "hectorg");
        ic.seguirUsuario("robinh", "juliob");
        ic.seguirUsuario("robinh", "diegop");
        //MT
        ic.seguirUsuario("marcelot", "cachilas");
        ic.seguirUsuario("marcelot", "juliob");
        ic.seguirUsuario("marcelot", "kairoh");
        //EN
        ic.seguirUsuario("novick", "hrubino");
        ic.seguirUsuario("novick", "tabarec");
        ic.seguirUsuario("novick", "cachilas");
        //SP                
        ic.seguirUsuario("sergiop", "mbusca");
        ic.seguirUsuario("sergiop", "juliob");
        ic.seguirUsuario("sergiop", "diegop");
        //AR                        
        ic.seguirUsuario("chino", "tonyp");
        //AP                                
        ic.seguirUsuario("tonyp", "chino");
        //NJ                                        
        ic.seguirUsuario("nicoJ", "diegop");
        ic.seguirUsuario("nicoJ", "losBardo");
        //JP                                                       
        ic.seguirUsuario("juanP", "tabarec");
        ic.seguirUsuario("juanP", "cachilas");
        ic.seguirUsuario("juanP", "kairoh");
        //MG                                                               
        ic.seguirUsuario("Mengano", "hectorg");
        ic.seguirUsuario("Mengano", "juliob");
        ic.seguirUsuario("Mengano", "chino");
        //PL                                                                       
        ic.seguirUsuario("Perengano", "diegop");
        ic.seguirUsuario("Perengano", "tonyp");
        //TJ                                                                           
        ic.seguirUsuario("Tiajaci", "juliob");
        ic.seguirUsuario("Tiajaci", "kairoh");
        ic.seguirUsuario("Tiajaci", "novick");

        //CATEGORIA
        ic.altaCategoria("Carnaval");
        ic.altaCategoria("Murga", "Carnaval");
        ic.altaCategoria("Humoristas", "Carnaval");
        ic.altaCategoria("Parodistas", "Carnaval");
        ic.altaCategoria("Lumbolos", "Carnaval");
        ic.altaCategoria("Revista", "Carnaval");
        ic.altaCategoria("Teatro");
        ic.altaCategoria("Teatro Dramático", "Teatro");
        ic.altaCategoria("Teatro Musical", "Teatro");
        ic.altaCategoria("Comedia", "Teatro");
        ic.altaCategoria("Stand-up", "Comedia");
        ic.altaCategoria("Literatura");
        ic.altaCategoria("Musica");
        ic.altaCategoria("Festival","Musica");
        ic.altaCategoria("Concierto","Musica");
        ic.altaCategoria("Cine");
        ic.altaCategoria("Cine al Aire Libre", "Cine");
        ic.altaCategoria("Cine a Pedal", "Cine");
        ic.altaCategoria("Danza");
        ic.altaCategoria("Ballet", "Danza");
        ic.altaCategoria("Flamenco", "Danza");
        

        //PROPUESTA
        ic.altaPropuesta("diegop", "Cine al Aire Libre", "Cine en el Botánico",
                "El 16 de Diciembre a la hora 20 se proyectará la película \"Clever\", en el Jardín Botánico (Av. 19 de Abril 1181) en el marco de las actividades realizadas por el ciclo Cultura al Aire Libre. El largometraje uruguayo de ficción Clever es dirigido por Federico Borgia y Guillermo Madeiro. Es apto para mayores de 15 años.",
                "Jardín Botánico", LocalDate.of(2017, 12, 16), "200", "150000", EnumRetorno.PORCENTAJE_VENTAS, LocalDate.of(2017, 9, 16), "");

        ic.altaPropuesta("hrubino", "Parodistas", "Religiosamente",
                "MOMOSAPIENS presenta \"Religiosamente\". Mediante dos parodias y un hilo conductor que aborda la temática de la religión Momosapiens, mediante el humor y la reflexión, hilvana una historia que muestra al hombre inmerso en el tema religioso. El libreto está escrito utilizando diferentes lenguajes de humor, dando una visión satírica y reflexiva desde distintos puntos de vista, logrando mediante situaciones paródicas armar una propuesta plena de arte carnavalero.",
                "Teatro de Verano", LocalDate.of(2017, 10, 7), "300", "300000", EnumRetorno.AMBOS, LocalDate.of(2017, 6, 18), "fotos/MOM.jpg");

        ic.altaPropuesta("mbusca", "Concierto", "El Pimiento Indomable",
                "El Pimiento Indomable, formación compuesta por Kiko Veneno y el uruguayo Martín Buscaglia, presentará este 19 de Octubre, su primer trabajo. Bajo un título homónimo al del grupo, es un disco que según los propios protagonistas “no se parece al de ninguno de los dos por separado. Entre los títulos que se podrán escuchar se encuentran “Nadador salvador”, “América es más grande”, “Pescaito Enroscado” o “La reina del placer”.",
                "Teatro Solís", LocalDate.of(2017, 10, 19), "400", "400000", EnumRetorno.PORCENTAJE_VENTAS, LocalDate.of(2017, 7, 26), "fotos/PIM.jpg");

        ic.altaPropuesta("kairoh", "Festival", "Pilsen Rock",
                "La edición 2017 del Pilsen Rock se celebrará el 21 de Octubre en la Rural del Prado y contará con la participación de más de 15 bandas nacionales. Quienes no puedan trasladarse al lugar, tendrán la posibilidad de disfrutar los shows a través de Internet, así como entrevistas en vivo a los músicos una vez finalizados los conciertos.",
                "Rural de Prado", LocalDate.of(2017, 10, 21), "1000", "900000", EnumRetorno.AMBOS, LocalDate.of(2017, 7, 30), "fotos/PIL.jpg");

        ic.altaPropuesta("juliob", "Ballet", "Romeo y Julieta",
                "Romeo y Julieta de Kenneth MacMillan, uno de los ballets favoritos del director artístico Julio Bocca, se presentará nuevamente el 5 de Noviembre en el Auditorio Nacional del Sodre. Basada en la obra homónima de William Shakespeare, Romeo y Julieta es considerada la coreografía maestra del MacMillan. La producción de vestuario y escenografía se realizó en los Talleres del Auditorio Adela Reta, sobre los diseños originales.",
                "Auditorio Nacional del Sodre", LocalDate.of(2017, 11, 5), "800", "750000", EnumRetorno.PORCENTAJE_VENTAS, LocalDate.of(2017, 8, 4), "fotos/RYJ.jpg");

        ic.altaPropuesta("tabarec", "Murga", "Un día de Julio",
                "La Catalina presenta el espectáculo \"Un Día de Julio\" en Landia. Un hombre misterioso y solitario vive encerrado entre las cuatro paredes de su casa. Intenta, con sus teorías extravagantes, cambiar el mundo exterior que le resulta inhabitable. Un día de Julio sucederá algo que cambiará su vida y la de su entorno para siempre.",
                "Landia", LocalDate.of(2017, 11, 16), "650", "300000", EnumRetorno.AMBOS, LocalDate.of(2017, 8, 6), "fotos/UDJ.jpg");

        ic.altaPropuesta("hectorg", "Teatro Dramático", "El Lazarillo de Tormes",
                "Vuelve unas de las producciones de El Galpón más aclamadas de los últimos tiempos. Esta obra se ha presentado en Miami, Nueva York, Washington, México, Guadalajara, Río de Janeiro y La Habana. En nuestro país, El Lazarillo de Tormes fue nominado en los rubros mejor espectáculo y mejor dirección a los Premios Florencio 1995, obteniendo su protagonista Héctor Guido el Florencio a Mejor actor de ese año.",
                "Teatro el Galpón", LocalDate.of(2017, 12, 3), "350", "175000", EnumRetorno.ENTRADAS_GRATIS, LocalDate.of(2017, 8, 18), "");

        ic.altaPropuesta("losBardo", "Stand-up", "Bardo en la FING",
                "El 10 de Diciembre se presentará Bardo Científico en la FING. El humor puede ser usado como una herramienta importante para el aprendizaje y la democratización de la ciencia, los monólogos científicos son una forma didáctica de apropiación del conocimiento científico y contribuyen a que el público aprenda ciencia de forma amena. Los invitamos a pasar un rato divertido, en un espacio en el cual aprenderán cosas de la ciencia que los sorprenderán. ¡Los esperamos!",
                "Anfiteatro Edificio \"José Luis Massera\"", LocalDate.of(2017, 12, 10), "200", "100000", EnumRetorno.ENTRADAS_GRATIS, LocalDate.of(2017, 8, 23), "");
        
        ic.cambiarEstadoPropuesta("Cine en el Botánico", EnumEstado.PUBLICADA.toString());
        ic.cambiarEstadoPropuesta("Cine en el Botánico", EnumEstado.EN_FINANCIACION.toString());
        ic.cambiarEstadoPropuesta("Cine en el Botánico", EnumEstado.FINANCIADA.toString());
        ic.cambiarEstadoPropuesta("Cine en el Botánico", EnumEstado.CANCELADA.toString());
        
        ic.cambiarEstadoPropuesta("Religiosamente", EnumEstado.PUBLICADA.toString());
        ic.cambiarEstadoPropuesta("Religiosamente", EnumEstado.EN_FINANCIACION.toString());
        ic.cambiarEstadoPropuesta("Religiosamente", EnumEstado.FINANCIADA.toString());
        
        ic.cambiarEstadoPropuesta("El Pimiento Indomable", EnumEstado.PUBLICADA.toString());
        ic.cambiarEstadoPropuesta("El Pimiento Indomable", EnumEstado.EN_FINANCIACION.toString());
        
        ic.cambiarEstadoPropuesta("Pilsen Rock", EnumEstado.PUBLICADA.toString());
        ic.cambiarEstadoPropuesta("Pilsen Rock", EnumEstado.EN_FINANCIACION.toString());
        
        ic.cambiarEstadoPropuesta("Un día de Julio", EnumEstado.PUBLICADA.toString());
        ic.cambiarEstadoPropuesta("Un día de Julio", EnumEstado.EN_FINANCIACION.toString());
        
        ic.cambiarEstadoPropuesta("El Lazarillo de Tormes", EnumEstado.PUBLICADA.toString());
        
        //COLABORACIONES/APORTES
        ic.altaAporte("novick","Cine en el Botánico",50000, 0, EnumRetorno.PORCENTAJE_VENTAS , LocalDateTime.of(2017, 5, 20, 14, 30));
        ic.altaAporte("robinh","Cine en el Botánico",50000, 0, EnumRetorno.PORCENTAJE_VENTAS, LocalDateTime.of(2017, 5, 24, 17, 25));
        ic.altaAporte("nicoJ","Cine en el Botánico",50000, 0, EnumRetorno.PORCENTAJE_VENTAS, LocalDateTime.of(2017, 5, 30, 18, 30));
        ic.altaAporte("marcelot","Religiosamente",200000, 0, EnumRetorno.PORCENTAJE_VENTAS, LocalDateTime.of(2017, 6, 30, 14, 25));
        ic.altaAporte("Tiajaci","Religiosamente",500, 0, EnumRetorno.ENTRADAS_GRATIS,LocalDateTime.of(2017, 7, 1, 18, 5));
        ic.altaAporte("Mengano","Religiosamente",600, 0,EnumRetorno.ENTRADAS_GRATIS, LocalDateTime.of(2017, 7, 7, 17, 45));
        ic.altaAporte("novick","Religiosamente",50000, 0,EnumRetorno.PORCENTAJE_VENTAS, LocalDateTime.of(2017, 7, 10, 14, 35));
        ic.altaAporte("sergiop","Religiosamente",50000, 0, EnumRetorno.PORCENTAJE_VENTAS,LocalDateTime.of(2017, 7, 15, 9, 45));
        ic.altaAporte("marcelot","El Pimiento Indomable",200000, 0,EnumRetorno.PORCENTAJE_VENTAS, LocalDateTime.of(2017, 8, 1, 7, 40));
        ic.altaAporte("sergiop","El Pimiento Indomable",80000, 0,EnumRetorno.PORCENTAJE_VENTAS, LocalDateTime.of(2017, 8, 3, 9, 25));
        ic.altaAporte("chino","Pilsen Rock",50000, 0,EnumRetorno.ENTRADAS_GRATIS, LocalDateTime.of(2017, 8, 5, 16, 50));
        ic.altaAporte("novick","Pilsen Rock",120000, 0, EnumRetorno.PORCENTAJE_VENTAS, LocalDateTime.of(2017, 8, 10, 15, 50));
        ic.altaAporte("tonyp","Pilsen Rock",120000, 0,EnumRetorno.ENTRADAS_GRATIS, LocalDateTime.of(2017, 8, 15, 19, 30));
        ic.altaAporte("sergiop","Romeo y Julieta", 100000, 0,EnumRetorno.PORCENTAJE_VENTAS, LocalDateTime.of(2017, 8, 13, 4, 58));
        ic.altaAporte("marcelot","Romeo y Julieta",200000, 0,EnumRetorno.PORCENTAJE_VENTAS, LocalDateTime.of(2017, 8, 14, 11, 25));
        ic.altaAporte("tonyp","Un día de Julio",30000, 0,EnumRetorno.ENTRADAS_GRATIS, LocalDateTime.of(2017, 8, 15, 4, 48));
        ic.altaAporte("marcelot","Un día de Julio",150000, 0,EnumRetorno.PORCENTAJE_VENTAS, LocalDateTime.of(2017, 8, 17, 15, 30));

        javax.swing.JOptionPane.showMessageDialog(this, "Datos de prueba cargados correctamente", "Atención", javax.swing.JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void menuEvaluarPropuestaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuEvaluarPropuestaActionPerformed
        // TODO add your handling code here:
         if (this.IEP == null || this.IEP.isClosed()) {
            IEP = new InterEvaluarPropuesta(ic);
            this.Desktop.add(IEP);
            IEP.show();
        }
    }//GEN-LAST:event_menuEvaluarPropuestaActionPerformed
    private void menuBajaUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuBajaUsuarioActionPerformed
        // TODO add your handling code here:
        if (this.IBU == null || IBU.isClosed()) {
            IBU = new InterBajaUsuario(this.ic);
            this.Desktop.add(IBU);
            IBU.show();
            int x = (this.getWidth() - IBU.getWidth()) / 2;
            int y = (this.getHeight() - IBU.getHeight()) / 2;
            IBU.setLocation(x, y - 50);
        }
    }//GEN-LAST:event_menuBajaUsuarioActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new VentanaPrincipal().setVisible(true);
        });
    }

    private InterConsultaPerfilProponente ICPP;
    private InterConsultaPropuesta ICP;
    private InterAltaPropuesta IAP;
    private InterRegistrarCola IRC;
    private InterConsultaCola ICC;
    private InterAltaCategoria IAC;
    private InterCancelarCola ICrC;
    private InterConsultaXEstado ICE;
    private InterConsultaPerfilColaborador ICPC;
    private InterAltaUsuario IAU;
    private InterSeguirUsuario ISU;
    private InterDejarSeguir IDS;
    private InterModificarPropuesta IMP;
    private InterEvaluarPropuesta IEP;
    private InterBajaUsuario IBU;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane Desktop;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem menuAltaCategoria;
    private javax.swing.JMenuItem menuAltaProp;
    private javax.swing.JMenuItem menuAltaUsuario;
    private javax.swing.JMenuItem menuBajaUsuario;
    private javax.swing.JMenuItem menuCancelarCola;
    private javax.swing.JMenuItem menuConsultaCola;
    private javax.swing.JMenuItem menuConsultaProponente;
    private javax.swing.JMenuItem menuConsultaPropu;
    private javax.swing.JMenuItem menuConsultaPropuEst;
    private javax.swing.JMenuItem menuConsultarCola;
    private javax.swing.JMenu menuDatos;
    private javax.swing.JMenuItem menuDejarSeguir;
    private javax.swing.JMenuItem menuEvaluarPropuesta;
    private javax.swing.JMenuItem menuModificarProp;
    private javax.swing.JMenu menuPerfil;
    private javax.swing.JMenu menuPropuestas;
    private javax.swing.JMenuItem menuRegistrarCola;
    private javax.swing.JMenuItem menuSeguir;
    private javax.swing.JMenu subMenuConsultaPerfil;
    // End of variables declaration//GEN-END:variables
}
