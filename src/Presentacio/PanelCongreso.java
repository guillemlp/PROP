package Presentacio;

import Domini.Congresista;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class PanelCongreso extends PanelLista {

    //Referència al controlador de presentació que crea la vista
    CPCongreso cvc;
    JButton bAgregarCongresista;
    JButton bAgregarRandom;
    JButton bCargarCongreso;
    JButton bClear;
    JButton bEliminarCongresista;
    JButton bEliminarCongreso;
    JButton bGuardarCongreso;
    JButton bModificarCongresista;
    Box.Filler filler1;
    JSpinner jSpinner1;
    JTextField textError;
    JLabel lAge;
    JLabel lCity;
    JLabel lDni;
    JLabel lName;
    JLabel lParty;
    JLabel lState;
    JLabel lSurname;
    JTextField textState;
    JTextField textAge;
    JTextField textCity;
    JTextField textDni;
    JTextField textName;
    JTextField textParty;
    JTextField textSurname;

    public PanelCongreso(CPCongreso c)
    {
        super();
        cvc = c;
        // Inicializa los componentes de la ventana
        initGUI();
    }

    public PanelCongreso() {

        super();
        // Inicializa los componentes de la ventana
        //initUI();

    }
    private void initGUI() {
        lName = new JLabel();
        textName = new JTextField();
        lSurname = new JLabel();
        textSurname = new JTextField();
        lDni = new JLabel();
        textDni = new JTextField();
        lAge = new JLabel();
        textAge = new JTextField();
        lCity = new JLabel();
        textCity = new JTextField();
        lState = new JLabel();
        textState = new JTextField();
        lParty = new JLabel();
        textParty = new JTextField();
        filler1 = new Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        bClear = new JButton();
        textError = new JTextField();
        bAgregarCongresista = new JButton();
        bAgregarRandom = new JButton();
        bEliminarCongresista = new JButton();
        bModificarCongresista = new JButton();
        bEliminarCongreso = new JButton();
        bCargarCongreso = new JButton();
        bGuardarCongreso = new JButton();
        jSpinner1 = new JSpinner();

       // setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        

        lName.setFont(new java.awt.Font("Ubuntu", 0, 18));
        lName.setText("Nombre");

        textName.setFont(new java.awt.Font("Ubuntu", 0, 18));
        textName.setText("Introduzca el Nombre");
        textName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textNameActionPerformed(evt);
            }
        });

        textSurname.setFont(new java.awt.Font("Ubuntu", 0, 18));
        textSurname.setText("Introduzca el Apellido");
        textSurname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textSurnameActionPerformed(evt);
            }
        });

        lSurname.setFont(new java.awt.Font("Ubuntu", 0, 18));
        lSurname.setText("Apellido");

        lDni.setFont(new java.awt.Font("Ubuntu", 0, 18));
        lDni.setText("Dni");

        textDni.setFont(new java.awt.Font("Ubuntu", 0, 18));
        textDni.setText("Introduzca el Dni");
        textDni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textDniActionPerformed(evt);
            }
        });

        lAge.setFont(new java.awt.Font("Ubuntu", 0, 18));
        lAge.setText("Edad");

        textAge.setFont(new java.awt.Font("Ubuntu", 0, 18));
        textAge.setText("Introduzca el Dni");
        textAge.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textAgeActionPerformed(evt);
            }
        });

        lCity.setFont(new java.awt.Font("Ubuntu", 0, 18));
        lCity.setText("Ciudad");

        textCity.setFont(new java.awt.Font("Ubuntu", 0, 18));
        textCity.setText("Introduzca el Dni");
        textCity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textCityActionPerformed(evt);
            }
        });

        lState.setFont(new java.awt.Font("Ubuntu", 0, 18));
        lState.setText("Estado");

        textState.setFont(new java.awt.Font("Ubuntu", 0, 18));
        textState.setText("Introduzca el Estado");
        textState.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textStateActionPerformed(evt);
            }
        });

        lParty.setFont(new java.awt.Font("Ubuntu", 0, 18));
        lParty.setText("Partido");

        textParty.setFont(new java.awt.Font("Ubuntu", 0, 18));
        textParty.setText("Introduzca el Partido");
        textParty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textPartyActionPerformed(evt);
            }
        });

        bClear.setFont(new java.awt.Font("Ubuntu", 0, 18));
        bClear.setText("Clear");
        bClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bClearActionPerformed(evt);
            }
        });

        textError.setText("textError");
        textError.setEditable(false);

        bAgregarCongresista.setFont(new java.awt.Font("Ubuntu", 0, 18));
        bAgregarCongresista.setText("AgregarCongresista");
        bAgregarCongresista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAgregarCongresistaActionPerformed(evt);
            }
        });

        bAgregarRandom.setFont(new java.awt.Font("Ubuntu", 0, 18));
        bAgregarRandom.setText("AgregarRandom");
        bAgregarRandom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAgregarRandomActionPerformed(evt);
            }
        });

        bEliminarCongresista.setFont(new java.awt.Font("Ubuntu", 0, 18));
        bEliminarCongresista.setText("EliminarCongresista");
        bEliminarCongresista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bEliminarCongresistaActionPerformed(evt);
            }
        });

        bModificarCongresista.setFont(new java.awt.Font("Ubuntu", 0, 18));
        bModificarCongresista.setText("Modificar");
        bModificarCongresista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bModificarCongresistaActionPerformed(evt);
            }
        });

        bEliminarCongreso.setFont(new java.awt.Font("Ubuntu", 0, 18));
        bEliminarCongreso.setText("EliminarCongreso");
        bEliminarCongreso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bEliminarCongresoActionPerformed(evt);
            }
        });

        bCargarCongreso.setFont(new java.awt.Font("Ubuntu", 0, 18));
        bCargarCongreso.setText("CargarCongreso");
        bCargarCongreso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCargarCongresoActionPerformed(evt);
            }
        });

        bGuardarCongreso.setFont(new java.awt.Font("Ubuntu", 0, 18));
        bGuardarCongreso.setText("GuardarCongreso");
        bGuardarCongreso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bGuardarCongresoActionPerformed(evt);
            }
        });

        jSpinner1.setFont(new java.awt.Font("Ubuntu", 0, 18));



        JPanel right = new JPanel();
        right.add(lName);
        right.add(textName);
        right.add(lSurname);
        right.add(textSurname);
        right.add(lDni);
        right.add(textDni);
        right.add(lAge);
        right.add(textAge);
        right.add(lCity);
        right.add(textCity);
        right.add(lState);
        right.add(textState);
        right.add(lParty);
        right.add(textParty);
        right.add(bClear);
        right.add(textError);
        right.add(bAgregarCongresista);
        right.add(bEliminarCongresista);
        right.add(bModificarCongresista);
        right.add(bEliminarCongreso);
        right.add(jSpinner1);
        right.add(bAgregarRandom);
        right.add(bCargarCongreso);
        right.add(bGuardarCongreso);

        //Obtenemos el SplitPanel de la clase padre y le asignamos el panel a la parte rightecha
        obtSp().setRightComponent(right);


        //GroupLayout gr = new GroupLayout(right);
        //right.setLayout(gr);
        //gr.setAutoCreateGaps(true);
        //gr.setAutoCreateContainerGaps(true);
        
        
        
        //TODO
        GroupLayout layout = new GroupLayout(right);
        right.setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
        //getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(textError)
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addComponent(lParty, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(textCity, GroupLayout.Alignment.LEADING)
                                        .addComponent(lCity, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(textDni, GroupLayout.Alignment.LEADING)
                                        .addComponent(lDni, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(textName, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE)
                                        .addComponent(lName, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(textParty, GroupLayout.Alignment.LEADING))
                                .addGap(14, 14, 14)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(textState)
                                        .addComponent(filler1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lState, GroupLayout.PREFERRED_SIZE, 240, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lSurname, GroupLayout.PREFERRED_SIZE, 240, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(bClear, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                        .addComponent(textAge, GroupLayout.Alignment.LEADING)
                                                        .addComponent(textSurname, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE)
                                                        .addComponent(lAge, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addGap(2, 2, 2))))
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addComponent(bCargarCongreso, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jSpinner1)
                                        .addComponent(bModificarCongresista, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(bAgregarCongresista, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(bEliminarCongresista, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(bEliminarCongreso, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(bGuardarCongreso, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(bAgregarRandom, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(lName, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lSurname))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(textName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(textSurname, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(lDni)
                                        .addComponent(lAge))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(textDni, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(textAge, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(lCity)
                                        .addComponent(lState))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(textCity, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(textState, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lParty)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(textParty, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(bClear))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(filler1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                                .addComponent(textError, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(bAgregarCongresista)
                                        .addComponent(bEliminarCongresista))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(bModificarCongresista)
                                        .addComponent(bEliminarCongreso))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(bAgregarRandom)
                                        .addComponent(jSpinner1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(bCargarCongreso)
                                        .addComponent(bGuardarCongreso))
                                .addGap(30, 30, Short.MAX_VALUE))
        );

    }// </editor-fold>                        

        private void textNameActionPerformed(java.awt.event.ActionEvent evt) {
            // TODO add your handling code here:
        }
    
        private void textSurnameActionPerformed(java.awt.event.ActionEvent evt) {
            // TODO add your handling code here:
        }
    
        private void textDniActionPerformed(java.awt.event.ActionEvent evt) {
            // TODO add your handling code here:
        }
    
        private void textAgeActionPerformed(java.awt.event.ActionEvent evt) {
            // TODO add your handling code here:
        }
    
        private void textCityActionPerformed(java.awt.event.ActionEvent evt) {
            // TODO add your handling code here:
        }
    
        private void textStateActionPerformed(java.awt.event.ActionEvent evt) {
            // TODO add your handling code here:
        }
    
        private void textPartyActionPerformed(java.awt.event.ActionEvent evt) {
            // TODO add your handling code here:
        }
    
        private void bGuardarCongresoActionPerformed(java.awt.event.ActionEvent evt) {
            // TODO add your handling code here:
        }
    
        private void bEliminarCongresistaActionPerformed(java.awt.event.ActionEvent evt) {
            // TODO add your handling code here:
        }
    
        private void bAgregarCongresistaActionPerformed(java.awt.event.ActionEvent evt) {
            // TODO add your handling code here:
        }
    
        private void bEliminarCongresoActionPerformed(java.awt.event.ActionEvent evt) {
            // TODO add your handling code here:
        }
    
        private void bModificarCongresistaActionPerformed(java.awt.event.ActionEvent evt) {
            // TODO add your handling code here:
        }
    
        private void bCargarCongresoActionPerformed(java.awt.event.ActionEvent evt) {
            // TODO add your handling code here:
        }
    
        private void bAgregarRandomActionPerformed(java.awt.event.ActionEvent evt) {
            // TODO add your handling code here:
        }
    
        private void bClearActionPerformed(java.awt.event.ActionEvent evt) {
            // TODO add your handling code here:
        }
    
    
    
    
    
    

    private void initUI()
    {

        JLabel name = new JLabel("Nombre:");
        JLabel surname = new JLabel("Apellido:");
        JLabel dni = new JLabel("DNI:");
        JLabel age = new JLabel("Edad:");
        JLabel city = new JLabel("Ciudad:");
        JLabel state = new JLabel("Estado:");
        JLabel partido = new JLabel("Partido:");
        final JTextField nameField = new JTextField("Introduzca nombre");
        //nameField.setMaximumSize(new Dimension(200, 25));
        final JTextField dniField = new JTextField("8 numbers + 1 letter");
        //dniField.setMaximumSize(new Dimension(200, 25));
        final JTextField surnameField = new JTextField("Introduzca apellido");
        //surnameField.setMaximumSize(new Dimension(200, 25));
        final JTextField partidoField = new JTextField("Introduzca partido");
        //partidoField.setMaximumSize(new Dimension(200, 25));
        final JTextField ageField = new JTextField("Introduzca edad");
        //ageField.setMaximumSize(new Dimension(200, 25));
        final JTextField cityField = new JTextField("Introduzca ciudad");
        //cityField.setMaximumSize(new Dimension(200, 25));
        final JTextField stateField = new JTextField("Introduzca estado");
        //stateField.setMaximumSize(new Dimension(200, 25));
        nameField.putClientProperty("JComponent.sizeVariant", "large");
        dniField.putClientProperty("JComponent.sizeVariant", "regular");
        surnameField.putClientProperty("JComponent.sizeVariant", "regular");
        partidoField.putClientProperty("JComponent.sizeVariant", "regular");
        ageField.putClientProperty("JComponent.sizeVariant", "regular");
        cityField.putClientProperty("JComponent.sizeVariant", "regular");
        stateField.putClientProperty("JComponent.sizeVariant", "regular");

        final JTextArea errorField = new JTextArea("No errors found");
        errorField.setMaximumSize(new Dimension(200, 50));
        errorField.setEditable(false);


        final JButton acceptButton;
        acceptButton = new JButton("Aceptar");
        acceptButton.setEnabled(false);

        // Referencias a los objetos superiores
        final JList name_list = obtJlist();
//        final DefaultListModel def = (DefaultListModel) name_list.getModel();

        //Acción realizada al seleccionar un elemento
        name_list.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {

                    if (name_list.getSelectedIndex() == -1) {
                        //No selection, disable fire button.
                        acceptButton.setEnabled(false);

                    } else {
                        //Selection, enable the fire button.
                        acceptButton.setEnabled(true);
                        String dato = (String) name_list.getSelectedValue();
                        errorField.setText("#" + name_list.getSelectedIndex());

                        // Del congresista a los campos
                        String[] campos = dato.split(" ");

                        if (campos.length >= 2 && campos[1].charAt(0) == '[') {
                            String iden = campos[1].substring(1, campos[1].length() - 1);
                            nameField.setText(campos[0]);
                            dniField.setText(iden);

                            errorField.append("\n");
                            errorField.append(dato);
                            errorField.append("\n");
                            errorField.append(iden);
                        } else {
                            nameField.setText(campos[0]);
                        }


                    }
                }
            }
        });

        //Acción del botón Aceptar
        acceptButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int in = name_list.getSelectedIndex();
                String nom = nameField.getText();
                String iden = dniField.getText();

                Congresista cong = null;

                try {
                    //cvc.agregarCongresista(dniField.getText(), nameField.getText(), surnameField.getText(), Integer.parseInt(ageField.getText()), cityField.getText(), partidoField.getText(), stateField.getText());
                    //cong = cvc.consultarCongresista(iden);
                    errorField.setText("");
                    //def.setElementAt(nom + " [" + iden + "]", in);
                } catch (Exception e1) {
                    //e1.printStackTrace();
                    errorField.setText(e1.getMessage());
                }


            }
        });

       /* //Botón eliminar
        final JButton delb = obtElimBoton();
        delb.setEnabled(false);
        delb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String iden = dniField.getText();
                def.remove(name_list.getSelectedIndex());


                try {
                    //cvc.eliminarCongresista(iden, cp.getControlRelaciones());
                } catch (Exception e2) {
                    e2.printStackTrace();
                }

                if (def.getSize() - 1 < 0) delb.setEnabled(false);
                else name_list.setSelectedIndex(def.getSize() - 1);

            }
        });

        //Botón añadir
        final JButton addb = obtAgrBoton();
        addb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                def.addElement("Nuevo");
                //nameField.setText("Insert troll here");
                nameField.requestFocusInWindow();
                //surnameField.setText("Insert meme here");
                //dniField.setText("66666666X");
                //partidoField.setText("Insert RageQuit here");
                //ageField.setText("21");
                //cityField.setText("Insert Mordor here");
                name_list.setSelectedIndex(def.getSize() - 1);


                delb.setEnabled(true);
            }
        });*/

        JPanel der = new JPanel();
        der.add(name);
        der.add(nameField);
        der.add(surname);
        der.add(surnameField);
        der.add(dni);
        der.add(dniField);
        der.add(age);
        der.add(ageField);
        der.add(partido);
        der.add(partidoField);

        //Obtenemos el SplitPanel de la clase padre y le asignamos el panel a la parte derecha
        obtSp().setRightComponent(der);


        GroupLayout gr = new GroupLayout(der);
        der.setLayout(gr);
        gr.setAutoCreateGaps(true);
        gr.setAutoCreateContainerGaps(true);



        // Layout

        gr.setHorizontalGroup(
                gr.createSequentialGroup()
                        .addGroup(gr.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(gr.createSequentialGroup()
                                                        .addGroup(gr.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                        .addComponent(name)
                                                                        .addComponent(nameField)
                                                                        .addComponent(dni)
                                                                        .addComponent(dniField)
                                                                        .addComponent(age)
                                                                        .addComponent(ageField)
                                                                        .addComponent(state)
                                                                        .addComponent(stateField)
                                                        )
                                                        .addGroup(gr.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                        .addComponent(surname)
                                                                        .addComponent(surnameField)
                                                                        .addComponent(partido)
                                                                        .addComponent(partidoField)
                                                                        .addComponent(city)
                                                                        .addComponent(cityField)
                                                        )
                                        )
                                        .addGroup(gr.createSequentialGroup()
                                                        .addComponent(errorField)
                                                                //.addComponent(delete)
                                                        .addComponent(acceptButton)
                                        )
                        )
        );




        gr.setVerticalGroup(
                gr.createParallelGroup()
                        .addGroup(gr.createSequentialGroup()
                                        .addGroup(gr.createParallelGroup()
                                                        .addGroup(gr.createSequentialGroup()
                                                                        .addComponent(name)
                                                                        .addComponent(nameField)
                                                        )
                                                        .addGroup(gr.createSequentialGroup()
                                                                        .addComponent(surname)
                                                                        .addComponent(surnameField)
                                                        )
                                        )
                                        .addGroup(gr.createParallelGroup()
                                                        .addGroup(gr.createSequentialGroup()
                                                                        .addComponent(dni)
                                                                        .addComponent(dniField)
                                                        )
                                                        .addGroup(gr.createSequentialGroup()
                                                                        .addComponent(partido)
                                                                        .addComponent(partidoField)
                                                        )
                                        )
                                        .addGroup(gr.createParallelGroup()
                                                        .addGroup(gr.createSequentialGroup()
                                                                        .addComponent(age)
                                                                        .addComponent(ageField)
                                                        )
                                                        .addGroup(gr.createSequentialGroup()
                                                                        .addComponent(city)
                                                                        .addComponent(cityField)
                                                        )
                                        )
                                        .addGroup(gr.createParallelGroup()
                                                        .addGroup(gr.createSequentialGroup()
                                                                        .addComponent(state)
                                                                        .addComponent(stateField)
                                                        )
                                                        .addGroup(gr.createSequentialGroup()
                                                                        .addComponent(city)
                                                                        .addComponent(cityField)
                                                        )
                                        )
                                        .addGroup(gr.createParallelGroup(GroupLayout.Alignment.CENTER)
                                                        .addComponent(errorField)
                                                                //.addComponent(delete)
                                                        .addComponent(acceptButton)
                                        )
                        )


        );


    }


}
